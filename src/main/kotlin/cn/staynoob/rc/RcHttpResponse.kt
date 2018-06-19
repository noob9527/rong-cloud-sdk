package cn.staynoob.rc

import cn.staynoob.rc.util.objectMapper
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fasterxml.jackson.databind.node.IntNode
import com.fasterxml.jackson.databind.node.TextNode

@JsonDeserialize(using = RcHttpResponse.RcHttpResponseDeserializer::class)
data class RcHttpResponse<out T>(
        val code: Int,
        val msg: String? = null,
        val data: T? = null
) {

    class RcHttpResponseDeserializer
        : JsonDeserializer<RcHttpResponse<*>>(), ContextualDeserializer {

        private var valueType: JavaType? = null

        override fun createContextual(ctxt: DeserializationContext, property: BeanProperty?): JsonDeserializer<*> {
            val javaType = ctxt.contextualType
                    .containedType(0)
            val deserializer = RcHttpResponseDeserializer()
            deserializer.valueType = javaType
            return deserializer
        }

        override fun deserialize(p: JsonParser, ctxt: DeserializationContext): RcHttpResponse<*> {
            val node = p.codec.readTree<JsonNode>(p)
            val code = (node["code"] as IntNode).numberValue() as Int
            val msg = (node["msg"] as? TextNode)?.textValue()
            val data: Any = objectMapper.convertValue(node, valueType)
            return RcHttpResponse(code, msg, data)
        }
    }
}

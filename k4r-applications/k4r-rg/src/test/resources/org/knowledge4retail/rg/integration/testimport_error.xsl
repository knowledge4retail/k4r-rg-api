<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:template match="/">
        {
        "products": [
        <xsl:for-each select="items/item">
            {
            "id": "<xsl:value-of select="./@id"/>",
            "name": "<xsl:value-of select="./@name"/>",
            "properties": [
            <xsl:for-each select="./property">
                {
                "ShelfContext_id": "<xsl:value-of select="./@ShelfContextid"/>",
                "characteristic_id": "<xsl:value-of select="./@characteristicid"/>",
                "value": "<xsl:value-of select="./@value"/>"
                }<xsl:if test="not(position() = last())">,</xsl:if>
            </xsl:for-each>
            ]
            }<xsl:if test="not(position() = last())">,</xsl:if>
        </xsl:for-each>
        ]
        }
    </xsl:template>
</xsl:stylesheet>
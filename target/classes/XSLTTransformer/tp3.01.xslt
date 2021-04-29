<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xslt" xmlns:cv21="http://univ.fr/cv21">
	<xsl:output method="xml" indent="yes" xalan:indent-amount="4"/>
	<xsl:template match="/cv21:cv21">
		<xsl:element name="html">
			<xsl:element name="head"></xsl:element>
			<xsl:element name="body">
				<xsl:element name="p"><xsl:text>Le 10 février 2021</xsl:text></xsl:element>
				<xsl:element name="p">CV21 - XSLT v1.0</xsl:element>
				<xsl:element name="h1"><xsl:text>Développement logiciel</xsl:text></xsl:element>
				<xsl:element name="h1"><xsl:value-of select="cv21:objectif"/></xsl:element>
				<xsl:element name="p"> Demande de <xsl:value-of select="cv21:objectif/@statut"/></xsl:element>
				<xsl:element name="h2">
					<xsl:value-of select="cv21:identitie/genre"/>
					<xsl:text> </xsl:text>
					<xsl:value-of select="cv21:identitie/nom"/>
					<xsl:text> </xsl:text>
					<xsl:value-of select="cv21:identitie/prenom"/> 
				</xsl:element>
				<xsl:element name="p">
					Tel : <xsl:value-of select="cv21:identitie/tel"></xsl:value-of>
					<xsl:element name="br"/>
					Mel : <xsl:value-of select="cv21:identitie/mel"></xsl:value-of>
				</xsl:element>
				<xsl:element name="h1"><xsl:text>Expériences professionnelles</xsl:text></xsl:element>
				<xsl:element name="ol">
					<xsl:for-each select="cv21:prof/expe">
						<xsl:element name="li">
							<xsl:value-of select="titre"/>
							<xsl:text> (du </xsl:text>
							<xsl:value-of select="datedeb"/>
							<xsl:text> au </xsl:text>
							<xsl:value-of select="datefin"/>
							<xsl:text>)</xsl:text>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="h1"><xsl:text>Diplômes</xsl:text></xsl:element>
				<xsl:element name="table">
					<xsl:for-each select="cv21:competences/diplome">
						<xsl:element name="tr">
							<xsl:element name="td"><xsl:value-of select="date"/></xsl:element>
							<xsl:element name="td"><xsl:value-of select="titre"/></xsl:element>
							<xsl:element name="td"><xsl:text>(</xsl:text><xsl:value-of select="@niveau"/><xsl:text>)</xsl:text></xsl:element>
							<xsl:element name="td"><xsl:value-of select="etab"/></xsl:element>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="h1">Certifications</xsl:element>
				<xsl:element name="table">
					<xsl:for-each select="cv21:competences/certif">
						<xsl:element name="tr">
							<xsl:element name="td">
								<xsl:value-of select="datedeb"/><xsl:text>-</xsl:text><xsl:value-of select="datefin"/>
							</xsl:element>
							<xsl:element name="td">
								<xsl:value-of select="titre"/>
							</xsl:element>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="h1">Langues</xsl:element>
				<xsl:element name="ul">
					<xsl:for-each select="cv21:divers/lv">
						<xsl:element name="li">
							<xsl:value-of select="@lang"/>
							<xsl:text> : </xsl:text>
							<xsl:value-of select="@cert"/>
							<xsl:text> (</xsl:text>
							<xsl:value-of select="@nivs"/>
							<xsl:value-of select="@nivi"/>
							<xsl:text>)</xsl:text>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
				<xsl:element name="h1">Divers</xsl:element>
				<xsl:element name="ul">
					<xsl:for-each select="cv21:divers/autre">
						<xsl:element name="li">
							<xsl:value-of select="@titre"/>
							<xsl:text> : </xsl:text>
							<xsl:value-of select="@comment"/>
						</xsl:element>
					</xsl:for-each>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>
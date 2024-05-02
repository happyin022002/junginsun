/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiMain12RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */  
 
public class BLIssuanceDBDAOsearchDblEdiMain12RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiMain12RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiMain12RSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT 'VVD:'|| BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_LANE:' || BK.SLAN_CD || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_CALLSIGN:' || V.CALL_SGN_NO || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_LLOYDCODE:' || V.LLOYD_NO || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_FULLNAME:' || V.VSL_ENG_NM || CHR(10) || " ).append("\n"); 
		query.append("       'VSL_FLAG:' || V.VSL_RGST_CNT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'BLNBR:' || BK.BL_NO || BK.BL_TP_CD|| CHR(10)|| " ).append("\n"); 
		query.append("       'BLPOL:' || BK.POL_CD || CHR(10) || " ).append("\n"); 
		query.append("       'POL_AMS:' || DECODE(@[edi_receive_id],'6111470101',DECODE(BK.POL_NOD_CD,'CNSHAYS','57037', POL.LOC_AMS_PORT_CD),POL.LOC_AMS_PORT_CD) || CHR(10) || " ).append("\n"); 
		query.append("       'POL_FULLNAME:' || BL.POL_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BLPOD:' || BK.POD_CD || CHR(10) || " ).append("\n"); 
		query.append("       'POD_AMS:' || POD.LOC_AMS_PORT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'POD_FULLNAME:' || POD.LOC_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BLPOR:' || BK.POR_CD || CHR(10) || " ).append("\n"); 
		query.append("       'POR_AMS:' || DECODE(@[edi_receive_id],'6111470101',DECODE(BK.POR_NOD_CD,'CNSHAYS','57037', POR.LOC_AMS_PORT_CD),POL.LOC_AMS_PORT_CD) || CHR(10) || " ).append("\n"); 
		query.append("       'POR_FULLNAME:' || POR.LOC_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BLDEL:' || BK.DEL_CD || CHR(10) || " ).append("\n"); 
		query.append("       'DEL_AMS:' || DEL.LOC_AMS_PORT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'DEL_FULLNAME:' || DEL.LOC_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BLRLY:' || BK.PRE_RLY_PORT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'RLY_AMS:' || RLY.LOC_AMS_PORT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'RLY_FULLNAME:' || RLY.LOC_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BLRLY2:' || BK.PST_RLY_PORT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'RLY_AMS2:' || RLY2.LOC_AMS_PORT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'RLY_FULLNAME2:' || RLY2.LOC_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BLPLACE:' || ISS.OBL_ISS_OFC_CD || CHR(10) || " ).append("\n"); 
		query.append("       'BLDATE:' || TO_CHAR(ISS.OBL_ISS_DT, 'RRRRMMDD')|| CHR(10) || " ).append("\n"); 
		query.append("       'SHCD1:' || SH.CUST_CNT_CD||SH.CUST_SEQ || CHR(10) || " ).append("\n"); 
		query.append("       'CNCD1:' || CN.CUST_CNT_CD||CN.CUST_SEQ || CHR(10) || " ).append("\n"); 
		query.append("       'NFCD1:' || NF.CUST_CNT_CD||NF.CUST_SEQ || CHR(10) || " ).append("\n"); 
		query.append("       'FWCD1:' || FW.CUST_CNT_CD||FW.CUST_SEQ || CHR(10) ||" ).append("\n"); 
		query.append("       'ANCD1:' || AN.CUST_CNT_CD||AN.CUST_SEQ || CHR(10) ||" ).append("\n"); 
		query.append("       'SHPR1:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(SH.CUST_NM, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(SH.CUST_NM, 1, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(SH.CUST_NM, 1, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR2:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(SH.CUST_NM, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(SH.CUST_NM, 2, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(SH.CUST_NM, 2, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR3:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 1, '*:&<>\"\\/'''))" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 1, ''))" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 1, '*:'))" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR4:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 2, '*:&<>\"\\/'''))" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 2, ''))" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 2, '*:'))" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR5:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 3, '*:&<>\"\\/'''))" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 3, ''))" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 3, '*:'))" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR_CITY_NM:' || CASE" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(SH.CUST_CTY_NM, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                 SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                 SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                 SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(SH.CUST_CTY_NM, 0, '')" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(SH.CUST_CTY_NM, 0, '*:')" ).append("\n"); 
		query.append("                          END " ).append("\n"); 
		query.append("                       || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR_STAT_CD:' || SH.CUST_STE_CD || CHR(10) || " ).append("\n"); 
		query.append("       'SHPR_ZIP_CD:' || CASE" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                            BKG_TOKEN_NL_FNC(SH.CUST_ZIP_ID, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                            BKG_TOKEN_NL_FNC(SH.CUST_ZIP_ID, 0, '')" ).append("\n"); 
		query.append("                          ELSE" ).append("\n"); 
		query.append("                            BKG_TOKEN_NL_FNC(SH.CUST_ZIP_ID, 0, '*:')" ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("                      || CHR(10) ||" ).append("\n"); 
		query.append("       'SHPR_CNT_CD:' || SH.CSTMS_DECL_CNT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'SH_IND:' || CHR(10) || " ).append("\n"); 
		query.append("       'CNEE1:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_NM, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_NM, 1, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_NM, 1, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'CNEE2:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_NM, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                          WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_NM, 2, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_NM, 2, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'CNEE3:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 1, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 1, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) ||" ).append("\n"); 
		query.append("       'CNEE4:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 2, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 2, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) ||" ).append("\n"); 
		query.append("       'CNEE5:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 3, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 3, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 3, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) ||" ).append("\n"); 
		query.append("       'CNEE_CITY_NM:' || CASE" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(CN.CUST_CTY_NM, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                  SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                  SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                  SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(CN.CUST_CTY_NM, 0, '')" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(CN.CUST_CTY_NM, 0, '*:')" ).append("\n"); 
		query.append("                          END " ).append("\n"); 
		query.append("                       || CHR(10) || " ).append("\n"); 
		query.append("       'CNEE_STAT_CD:' || CN.CUST_STE_CD || CHR(10) || " ).append("\n"); 
		query.append("       'CNEE_ZIP_CD:' || CASE" ).append("\n"); 
		query.append("                           WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(CN.CUST_ZIP_ID, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                  SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                  SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                  SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(CN.CUST_ZIP_ID, 0, '')" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(CN.CUST_ZIP_ID, 0, '*:')" ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("                      || CHR(10) ||" ).append("\n"); 
		query.append("       'CNEE_CNT_CD:' || CN.CSTMS_DECL_CNT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'CN_IND:' || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY1:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_NM, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_NM, 1, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_NM, 1, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY2:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_NM, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_NM, 2, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_NM, 2, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY3:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 1, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 1, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) ||" ).append("\n"); 
		query.append("       'NTFY4:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 2, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 2, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) ||" ).append("\n"); 
		query.append("       'NTFY5:' || CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 3, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                          SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 3, '')" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(NF.CUST_ADDR, 3, '*:')" ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("                || CHR(10) ||" ).append("\n"); 
		query.append("       'NTFY6:' || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY_CITY_NM:' || CASE" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(NF.CUST_CTY_NM, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                            WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                 SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                 SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                 SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(NF.CUST_CTY_NM, 0, '')" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(NF.CUST_CTY_NM, 0, '*:')" ).append("\n"); 
		query.append("                          END " ).append("\n"); 
		query.append("                       || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY_STAT_CD:' || NF.CUST_STE_CD || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY_ZIP_CD:' || CASE" ).append("\n"); 
		query.append("                           WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(NF.CUST_ZIP_ID, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                           WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                                SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(NF.CUST_ZIP_ID, 0, '')" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                              BKG_TOKEN_NL_FNC(NF.CUST_ZIP_ID, 0, '*:')" ).append("\n"); 
		query.append("                         END " ).append("\n"); 
		query.append("                      || CHR(10) ||" ).append("\n"); 
		query.append("       'NTFY_CNT_CD:' || NF.CSTMS_DECL_CNT_CD || CHR(10) || " ).append("\n"); 
		query.append("       'NF_IND:' || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY21:' || CASE" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 1, '')" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 1, '*:')" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                 || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY22:' || CASE" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 2, '')" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 2, '*:')" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                 || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY23:' || CASE" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 3, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 3, '')" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 3, '*:')" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                 || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY24:' || CASE" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 4, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 4, '')" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 4, '*:')" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                 || CHR(10) || " ).append("\n"); 
		query.append("       'NTFY25:' || CASE" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 5, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 5, '')" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(AN.CUST_NM, 5, '*:')" ).append("\n"); 
		query.append("                    END " ).append("\n"); 
		query.append("                 || CHR(10) || " ).append("\n"); 
		query.append("       'AN_IND:' || CHR(10) || " ).append("\n"); 
		query.append("       'BL_PO_NO:' || REPLACE(REPLACE(PO.CUST_REF_NO_CTNT, CHR(13), ''), CHR(10), '' ) || CHR(10) || " ).append("\n"); 
		query.append("       'BL_SI_NO:' || SI.CUST_REF_NO_CTNT || CHR(10) || " ).append("\n"); 
		query.append("       'BL_PPD_LOC_CD:' || PPD.LOC_CD || CHR(10) || " ).append("\n"); 
		query.append("       'BL_CCT_LOC_CD:' || CCT.LOC_CD || CHR(10) || " ).append("\n"); 
		query.append("       'BL_PPD_LOC_NM:' || PPDL.LOC_NM || CHR(10) || " ).append("\n"); 
		query.append("       'BL_CCT_LOC_NM:' || CCTL.LOC_NM || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,BKG_BL_DOC BL" ).append("\n"); 
		query.append("      ,BKG_RATE RT" ).append("\n"); 
		query.append("      ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("      ,BKG_REFERENCE SI" ).append("\n"); 
		query.append("      ,BKG_REFERENCE PO" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER SH" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER NF" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER CN" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER FW" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER EX" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER AN" ).append("\n"); 
		query.append("      ,MDM_LOCATION POL" ).append("\n"); 
		query.append("      ,MDM_LOCATION POD" ).append("\n"); 
		query.append("      ,MDM_LOCATION POR" ).append("\n"); 
		query.append("      ,MDM_LOCATION DEL" ).append("\n"); 
		query.append("      ,MDM_LOCATION RLY" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR V" ).append("\n"); 
		query.append("      ,COM_USER SCR" ).append("\n"); 
		query.append("      ,MDM_COUNTRY CNT" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("      ,MDM_LOCATION RLY2" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION PPD" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION CCT" ).append("\n"); 
		query.append("      ,MDM_LOCATION PPDL" ).append("\n"); 
		query.append("      ,MDM_LOCATION CCTL" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = SI.BKG_NO(+)" ).append("\n"); 
		query.append("   AND SI.BKG_REF_TP_CD (+) = 'ESRF'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = PO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND PO.BKG_REF_TP_CD (+) = 'BKPO'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = SH.BKG_NO(+)" ).append("\n"); 
		query.append("   AND SH.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = NF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND NF.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = CN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CN.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = FW.BKG_NO(+)" ).append("\n"); 
		query.append("   AND FW.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = EX.BKG_NO(+)" ).append("\n"); 
		query.append("   AND EX.BKG_CUST_TP_CD(+) = 'E'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = AN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND AN.BKG_CUST_TP_CD(+) = 'A'" ).append("\n"); 
		query.append("   AND BK.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.POD_CD = POD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.DEL_CD = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.PRE_RLY_PORT_CD = RLY.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.PST_RLY_PORT_CD = RLY2.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_USR_ID = SCR.USR_ID(+)" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_OFC_CD = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("   AND RT.PPD_RCV_OFC_CD = PPD.OFC_CD(+)" ).append("\n"); 
		query.append("   AND RT.CLT_OFC_CD = CCT.OFC_CD(+)" ).append("\n"); 
		query.append("   AND PPD.LOC_CD = PPDL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND CCT.LOC_CD = CCTL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND OFC.LOC_CD = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("   AND LOC.CNT_CD = CNT.CNT_CD(+)" ).append("\n"); 

	}
}
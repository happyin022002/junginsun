/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCncusBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCncusBlListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusBlRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               ST.BL_NO," ).append("\n"); 
		query.append("               MAX (  ST.BL_NO" ).append("\n"); 
		query.append("                        ||CHR(9)||TO_CHAR((SELECT MAX(SKD.VPS_ETB_DT)" ).append("\n"); 
		query.append("                                             FROM     BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                             WHERE    VVD.BKG_NO   = ST.BKG_NO" ).append("\n"); 
		query.append("                                             AND      VVD.POL_CD   = ST.PORT_CD" ).append("\n"); 
		query.append("                                             AND      VVD.VSL_CD   = SKD.VSL_CD" ).append("\n"); 
		query.append("                                             AND      VVD.SKD_VOY_NO  = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             AND      VVD.SKD_DIR_CD  = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                             AND      VVD.POL_CD   = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                             AND      VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ), 'YYYYMMDD')" ).append("\n"); 
		query.append("               ||CHR(9)||TO_CHAR(ST.BL_POD_ETA_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("               ||CHR(9)||TO_CHAR(ST.BL_ISS_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("               ||CHR(9)||ST.BL_ISS_OFC_CD" ).append("\n"); 
		query.append("               ||CHR(9)||LOC5.LOC_NM" ).append("\n"); 
		query.append("               ||CHR(9)||ST.POR_CD" ).append("\n"); 
		query.append("               ||CHR(9)||LOC1.LOC_NM" ).append("\n"); 
		query.append("               ||CHR(9)||ST.POL_CD" ).append("\n"); 
		query.append("               ||CHR(9)||LOC2.LOC_NM" ).append("\n"); 
		query.append("               ||CHR(9)||ST.POD_CD" ).append("\n"); 
		query.append("               ||CHR(9)||LOC3.LOC_NM" ).append("\n"); 
		query.append("               ||CHR(9)||ST.DEL_CD" ).append("\n"); 
		query.append("               ||CHR(9)||LOC4.LOC_NM" ).append("\n"); 
		query.append("               ||CHR(9)||ST.CHN_CSTMS_TRSP_MOD_CD" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BB_CGO_FLG FROM BKG_BOOKING BKG WHERE BKG.BKG_NO  = ST.BKG_NO)" ).append("\n"); 
		query.append("               ||CHR(9)||ST.RCV_TERM_CD||ST.DE_TERM_CD" ).append("\n"); 
		query.append("               ||CHR(9)||DECODE(ST.FRT_TERM_CD,'P','PP','C','CC')" ).append("\n"); 
		query.append("               ||CHR(9)||BKG_SPCLCHAR_CONV_FNC(TRIM(S.CUST_NM), 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||BKG_SPCLCHAR_CONV_FNC(TRIM(S.CUST_ADDR), 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CUST_CTY_NM FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CUST_ZIP_ID FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CSTMS_DECL_CNT_CD FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'S')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT CP.INTL_PHN_NO||CP.PHN_NO" ).append("\n"); 
		query.append("                   FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("                   WHERE S.CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND S.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT CP.INTL_FAX_NO||CP.FAX_NO" ).append("\n"); 
		query.append("                   FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("                   WHERE S.CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND S.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ||CHR(9)||BKG_SPCLCHAR_CONV_FNC(TRIM(C.CUST_NM), 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||BKG_SPCLCHAR_CONV_FNC(TRIM(C.CUST_ADDR), 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CUST_CTY_NM FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CUST_ZIP_ID FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CSTMS_DECL_CNT_CD FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT CP.INTL_PHN_NO||CP.PHN_NO" ).append("\n"); 
		query.append("                   FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("                   WHERE C.CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND C.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT CP.INTL_FAX_NO||CP.FAX_NO" ).append("\n"); 
		query.append("                   FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("                   WHERE C.CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND C.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ||CHR(9)||BKG_SPCLCHAR_CONV_FNC(TRIM(N.CUST_NM), 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||BKG_SPCLCHAR_CONV_FNC(TRIM(N.CUST_ADDR), 'C')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CUST_CTY_NM FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CUST_ZIP_ID FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BS.CSTMS_DECL_CNT_CD FROM BKG_CUSTOMER BS WHERE ST.BKG_NO = BS.BKG_NO AND BS.BKG_CUST_TP_CD = 'N')" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT CP.INTL_PHN_NO||CP.PHN_NO" ).append("\n"); 
		query.append("                   FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("                   WHERE N.CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND N.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT CP.INTL_FAX_NO||CP.FAX_NO" ).append("\n"); 
		query.append("                   FROM MDM_CUST_CNTC_PNT CP" ).append("\n"); 
		query.append("                   WHERE N.CNT_CD = CP.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND N.CUST_SEQ = CP.CUST_SEQ" ).append("\n"); 
		query.append("                     AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ||CHR(9)||(SELECT BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(REPLACE(TRIM(CUST_NM||CUST_ADDR) ,CHR(34)),CHR(9),' '), CHR(10),' ')), 'C')" ).append("\n"); 
		query.append("                            FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("                           WHERE BKG_NO = ST.BKG_NO" ).append("\n"); 
		query.append("                             AND BKG_CUST_TP_CD = 'A')" ).append("\n"); 
		query.append("               ||CHR(9)||ST.POD_ROUT_DESC" ).append("\n"); 
		query.append("                --||CHR(9)||REPLACE(ST.POD_ROUT_DESC,';',CHR(9))" ).append("\n"); 
		query.append("                ||CHR(9)||NVL(SUBSTR(TRIM(ST.CSTMS_DESC), 1, 512), 'N/M')" ).append("\n"); 
		query.append("                ||CHR(9)||NVL(SUBSTR(SM.BL_MK_DESC, 1, 100), '')" ).append("\n"); 
		query.append("            	||CHR(9)||NVL(SUBSTR(SM.BL_MK_DESC, 101, 100), '')           " ).append("\n"); 
		query.append("            	||CHR(9)||NVL(SUBSTR(SM.BL_MK_DESC, 201, 100), '')           " ).append("\n"); 
		query.append("            	||CHR(9)||NVL(SUBSTR(SM.BL_MK_DESC, 301, 100), '')           " ).append("\n"); 
		query.append("            	||CHR(9)||NVL(SUBSTR(SM.BL_MK_DESC, 401, 100), '')              " ).append("\n"); 
		query.append("                ||CHR(9)||TO_CHAR(ST.ACT_WGT, 'FM999999990.000')" ).append("\n"); 
		query.append("                ||CHR(9)||ST.PCK_QTY" ).append("\n"); 
		query.append("                ||CHR(9)||NVL(CNV.CSTMS_PCK_TP_CD, ST.PCK_TP_CD)" ).append("\n"); 
		query.append("                ||CHR(9)||NVL2(RF.BL_NO,'Y','N')" ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(RF.FDO_TEMP, NULL, DECODE(RF.CDO_TEMP, NULL, 0, RF.CDO_TEMP), RF.FDO_TEMP)" ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(RF.FDO_TEMP, NULL, 'C', 'F')" ).append("\n"); 
		query.append("                ||CHR(9)||TO_CHAR(ST.MEAS_QTY, 'FM999999990.000')" ).append("\n"); 
		query.append("                ||CHR(9)||'1') BL_DATA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CHN_BL ST," ).append("\n"); 
		query.append("     BKG_CSTMS_CHN_CUST C," ).append("\n"); 
		query.append("     BKG_CSTMS_CHN_CUST S," ).append("\n"); 
		query.append("     BKG_CSTMS_CHN_CUST N," ).append("\n"); 
		query.append("     MDM_LOCATION LOC1," ).append("\n"); 
		query.append("     MDM_LOCATION LOC2," ).append("\n"); 
		query.append("     MDM_LOCATION LOC3," ).append("\n"); 
		query.append("     MDM_LOCATION LOC4," ).append("\n"); 
		query.append("     MDM_LOCATION LOC5," ).append("\n"); 
		query.append("     BKG_CSTMS_CHN_RF RF," ).append("\n"); 
		query.append("       ( SELECT  BL_NO, DBMS_LOB.SUBSTR( BKG_SPCLCHAR_CONV_CLOB_FNC(BL_MK_DESC,'J'), 1000, 1) BL_MK_DESC" ).append("\n"); 
		query.append("         FROM    BKG_CSTMS_CHN_MK" ).append("\n"); 
		query.append("         WHERE	  1=1" ).append("\n"); 
		query.append("       AND   ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("                 #if($velocityCount > 1)" ).append("\n"); 
		query.append("                 OR #end      BL_NO IN ( $field_id )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("         AND     CHN_MF_SND_IND_CD  =	@[trans_mode]) SM," ).append("\n"); 
		query.append("     BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("         #if($velocityCount > 1)" ).append("\n"); 
		query.append("         OR #end      ST.BL_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	@[trans_mode]   /*24hr*/" ).append("\n"); 
		query.append("#if (${trans_mode} == 'P')" ).append("\n"); 
		query.append("AND	    ST.BKG_POL_CD = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	    ST.BKG_POD_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	C.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	C.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND	    C.BKG_CUST_TP_CD(+)	  =	'C'" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	S.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	S.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND	    S.BKG_CUST_TP_CD(+)	  =	'S'" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	N.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	N.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND	    N.BKG_CUST_TP_CD(+)	  =	'N'" ).append("\n"); 
		query.append("AND	    ST.POR_CD		      =	LOC1.LOC_CD" ).append("\n"); 
		query.append("ANd	    ST.POL_CD	          =	LOC2.LOC_CD" ).append("\n"); 
		query.append("AND	    ST.POD_CD	          =	LOC3.LOC_CD" ).append("\n"); 
		query.append("AND	    ST.DEL_CD	      	  =	LOC4.LOC_CD" ).append("\n"); 
		query.append("AND	    ST.BL_ISS_OFC_CD      =	LOC5.LOC_CD(+)" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	SM.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	RF.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	RF.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND	    ST.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("AND	    CNV.CNT_CD(+) = 'CN'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY ST.BL_NO" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class BLIssuanceDBDAOAddBkgEblAvcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ebl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_AVC" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_RMK" ).append("\n"); 
		query.append("	,DOC_NO_AND_CLSS_NM" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD1" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD2" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD3" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD4" ).append("\n"); 
		query.append("	,EBL_DEPT_NM" ).append("\n"); 
		query.append("	,CNTC_PSON_TELCM_NO" ).append("\n"); 
		query.append("	,CNTC_FAX_NO" ).append("\n"); 
		query.append("	,CNTC_EML" ).append("\n"); 
		query.append("	,CNTC_MPHN_NO" ).append("\n"); 
		query.append("	,APRO_USR_NM1" ).append("\n"); 
		query.append("	,BL_ISS_DT" ).append("\n"); 
		query.append("	,CLT_AGN_FLG" ).append("\n"); 
		query.append("	,CHG_AMT" ).append("\n"); 
		query.append("	,XPT_FLG" ).append("\n"); 
		query.append("	,CGOR_RMK" ).append("\n"); 
		query.append("	,EBL_CGO_CATE_CD" ).append("\n"); 
		query.append("	,SR_NO" ).append("\n"); 
		query.append("	,EBL_SR_AMD_TP_CD" ).append("\n"); 
		query.append("	,EBL_ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BL_TP_CD" ).append("\n"); 
		query.append("	,ORG_BL_NO" ).append("\n"); 
		query.append("	,RISS_FLG" ).append("\n"); 
		query.append("	,NTC_TIT_CTNT" ).append("\n"); 
		query.append("	,SIG_STMT_CTNT" ).append("\n"); 
		query.append("	,EBL_FRT_TERM_CD" ).append("\n"); 
		query.append("	,AR_INV_NO" ).append("\n"); 
		query.append("	,LC_NO" ).append("\n"); 
		query.append("	,SHPR_NM1" ).append("\n"); 
		query.append("	,SHPR_NM2" ).append("\n"); 
		query.append("	,ACT_SHPR_PHN_NO1" ).append("\n"); 
		query.append("	,SHPR_FAX_NO1" ).append("\n"); 
		query.append("	,SHPR_EML1" ).append("\n"); 
		query.append("	,SHPR_ADDR1" ).append("\n"); 
		query.append("	,SHPR_ADDR2" ).append("\n"); 
		query.append("	,SHPR_ADDR3" ).append("\n"); 
		query.append("	,SHPR_ADDR4" ).append("\n"); 
		query.append("	,SHPR_ADDR5" ).append("\n"); 
		query.append("	,ACT_SHPR_PHN_NO2" ).append("\n"); 
		query.append("	,ACT_SHPR_NM" ).append("\n"); 
		query.append("	,CFM_FLG" ).append("\n"); 
		query.append("	,CFM_DT" ).append("\n"); 
		query.append("	,BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append("	,BL_OBRD_DT" ).append("\n"); 
		query.append("	,VSL_ETA_DT" ).append("\n"); 
		query.append("	,SR_CMT_DESC" ).append("\n"); 
		query.append("	,VVD_CD" ).append("\n"); 
		query.append("	,PRE_VSL_NM" ).append("\n"); 
		query.append("	,VSL_NM" ).append("\n"); 
		query.append("	,VVD_NM" ).append("\n"); 
		query.append("	,EBL_NTLT_DIV_CD" ).append("\n"); 
		query.append("	,OBL_SRND_FLG" ).append("\n"); 
		query.append("	,POL_CD" ).append("\n"); 
		query.append("	,POL_NM" ).append("\n"); 
		query.append("	,POD_CD" ).append("\n"); 
		query.append("	,POD_NM" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,DEL_NM" ).append("\n"); 
		query.append("	,DEL_CD1" ).append("\n"); 
		query.append("	,DEL_NM1" ).append("\n"); 
		query.append("	,POR_CD" ).append("\n"); 
		query.append("	,POR_NM" ).append("\n"); 
		query.append("	,DEL_CD2" ).append("\n"); 
		query.append("	,DEL_NM2" ).append("\n"); 
		query.append("	,POD_CD1" ).append("\n"); 
		query.append("	,POD_NM1" ).append("\n"); 
		query.append("	,INLND_ROUT_RMK" ).append("\n"); 
		query.append("	,EBL_PRE_PORT_CD" ).append("\n"); 
		query.append("	,INLND_ROUT_RMK1" ).append("\n"); 
		query.append("	,BL_MV_TP_NM" ).append("\n"); 
		query.append("	,BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("	,CUST_REF_RMK" ).append("\n"); 
		query.append("	,VNDR_CUST_REF_RMK" ).append("\n"); 
		query.append("	,ORG_CNT_NM" ).append("\n"); 
		query.append("	,LODG_RMK" ).append("\n"); 
		query.append("	,EBL_MSG_TP_CD" ).append("\n"); 
		query.append("	,CO_NM1" ).append("\n"); 
		query.append("	,CO_NM2" ).append("\n"); 
		query.append("	,CO_ADDR1" ).append("\n"); 
		query.append("	,CO_ADDR2" ).append("\n"); 
		query.append("	,CO_ADDR3" ).append("\n"); 
		query.append("	,BL_ISS_LOC_CD" ).append("\n"); 
		query.append("	,BL_ISS_LOC_NM" ).append("\n"); 
		query.append("	,EBL_BKG_PPD_INP_TERM_CD" ).append("\n"); 
		query.append("	,EBL_PPD_OFC_CD" ).append("\n"); 
		query.append("	,EBL_BKG_CLT_INP_TERM_CD" ).append("\n"); 
		query.append("	,EBL_CLT_OFC_CD" ).append("\n"); 
		query.append("	,OBL_ISS_KNT" ).append("\n"); 
		query.append("	,SHPR_NM3" ).append("\n"); 
		query.append("	,SHPR_NM4" ).append("\n"); 
		query.append("	,ACT_SHPR_PHN_NO3" ).append("\n"); 
		query.append("	,SHPR_EML2" ).append("\n"); 
		query.append("	,SHPR_FAX_NO2" ).append("\n"); 
		query.append("	,SHPR_ADDR6" ).append("\n"); 
		query.append("	,SHPR_ADDR7" ).append("\n"); 
		query.append("	,SHPR_ADDR8" ).append("\n"); 
		query.append("	,SHPR_ADDR9" ).append("\n"); 
		query.append("	,SHPR_ADDR10" ).append("\n"); 
		query.append("	,APRO_USR_NM2" ).append("\n"); 
		query.append("	,SHPR_CTNT1" ).append("\n"); 
		query.append("	,SHPR_CTNT2" ).append("\n"); 
		query.append("	,SHPR_ADDR11" ).append("\n"); 
		query.append("	,SHPR_ADDR12" ).append("\n"); 
		query.append("	,SHPR_ADDR13" ).append("\n"); 
		query.append("	,SHPR_ADDR14" ).append("\n"); 
		query.append("	,SHPR_ADDR15" ).append("\n"); 
		query.append("	,ACT_CUST_PHN_NO" ).append("\n"); 
		query.append("	,ACT_CUST_FAX_NO" ).append("\n"); 
		query.append("	,CUST_EML1" ).append("\n"); 
		query.append("	,APRO_USR_NM3" ).append("\n"); 
		query.append("	,CHG_RMK1" ).append("\n"); 
		query.append("	,CHG_RMK2" ).append("\n"); 
		query.append("	,CUST_ADDR1" ).append("\n"); 
		query.append("	,CUST_ADDR2" ).append("\n"); 
		query.append("	,CUST_ADDR3" ).append("\n"); 
		query.append("	,CUST_ADDR4" ).append("\n"); 
		query.append("	,CUST_ADDR5" ).append("\n"); 
		query.append("	,CUST_PHN_NO1" ).append("\n"); 
		query.append("	,CUST_FAX_NO1" ).append("\n"); 
		query.append("	,CUST_EML2" ).append("\n"); 
		query.append("	,APRO_USR_NM4" ).append("\n"); 
		query.append("	,CHG_RMK3" ).append("\n"); 
		query.append("	,CHG_RMK4" ).append("\n"); 
		query.append("	,CUST_ADDR6" ).append("\n"); 
		query.append("	,CUST_ADDR7" ).append("\n"); 
		query.append("	,CUST_ADDR8" ).append("\n"); 
		query.append("	,CUST_ADDR9" ).append("\n"); 
		query.append("	,CUST_ADDR10" ).append("\n"); 
		query.append("	,CUST_PHN_NO2" ).append("\n"); 
		query.append("	,CUST_FAX_NO2" ).append("\n"); 
		query.append("	,CUST_EML3" ).append("\n"); 
		query.append("	,APRO_USR_NM5" ).append("\n"); 
		query.append("	,CHK_DE_CTY_NM1" ).append("\n"); 
		query.append("	,CHK_DE_CTY_NM2" ).append("\n"); 
		query.append("	,CHK_DE_ADDR1" ).append("\n"); 
		query.append("	,CHK_DE_ADDR2" ).append("\n"); 
		query.append("	,CHK_DE_ADDR3" ).append("\n"); 
		query.append("	,CHK_DE_ADDR4" ).append("\n"); 
		query.append("	,CHK_DE_ADDR5" ).append("\n"); 
		query.append("	,CUST_PHN_NO3" ).append("\n"); 
		query.append("	,CUST_FAX_NO3" ).append("\n"); 
		query.append("	,CUST_EML4" ).append("\n"); 
		query.append("	,APRO_USR_NM6" ).append("\n"); 
		query.append("	,CNTR_WGT" ).append("\n"); 
		query.append("	,ACT_WGT" ).append("\n"); 
		query.append("	,PCK_QTY" ).append("\n"); 
		query.append("	,PCK_TP_CD" ).append("\n"); 
		query.append("	,MK_DESC1" ).append("\n"); 
		query.append("	,MK_DESC2" ).append("\n"); 
		query.append("	,MK_DESC3" ).append("\n"); 
		query.append("	,MK_DESC4" ).append("\n"); 
		query.append("	,MK_DESC5" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT)" ).append("\n"); 
		query.append("SELECT  BK.BKG_NO   BKG_NO		" ).append("\n"); 
		query.append("        ,@[bkg_ebl_seq] BKG_EBL_SEQ" ).append("\n"); 
		query.append("        ,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("		,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("#if (${sr_sts_cd} == 'I')" ).append("\n"); 
		query.append("		,'BLAdvice'  DOC_RMK" ).append("\n"); 
		query.append("#elseif(${sr_sts_cd} == 'U')" ).append("\n"); 
		query.append("		,'BLReissue'  DOC_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ,BK.BKG_NO   DOC_NO_AND_CLSS_NM" ).append("\n"); 
		query.append("        ,'1'         OBJ_FUNC_EVNT_CD1" ).append("\n"); 
		query.append("        ,'NA'        OBJ_FUNC_EVNT_CD2" ).append("\n"); 
		query.append("        ,'1.0'       OBJ_FUNC_EVNT_CD3" ).append("\n"); 
		query.append("        ,'1'         OBJ_FUNC_EVNT_CD4" ).append("\n"); 
		query.append("        ,ISS.OBL_ISS_USR_ID       EBL_DEPT_NM" ).append("\n"); 
		query.append("        ,CNTC.CNTC_PSON_PHN_NO   CNTC_PSON_TELCM_NO" ).append("\n"); 
		query.append("        ,CNTC.CNTC_PSON_FAX_NO   CNTC_FAX_NO" ).append("\n"); 
		query.append("        ,SUBSTR(CNTC.CNTC_PSON_EML,1,25) CNTC_EML" ).append("\n"); 
		query.append("        ,CNTC.CNTC_PSON_MPHN_NO  CNTC_MPHN_NO       " ).append("\n"); 
		query.append("        ,(SELECT SUBSTR(USR_NM,1,17) FROM COM_USER COM WHERE COM.USR_ID = ISS.OBL_ISS_USR_ID) APRO_USR_NM1" ).append("\n"); 
		query.append("        ,TO_DATE(TO_CHAR(ISS.OBL_ISS_DT,'YYYYMMDD'),'YYYYMMDD')  BL_ISS_DT" ).append("\n"); 
		query.append("        ,'N' CLT_AGN_FLG" ).append("\n"); 
		query.append("        ,'' CHG_AMT" ).append("\n"); 
		query.append("        ,'Y' XPT_FLG" ).append("\n"); 
		query.append("        ,'Ocean B/L' CGOR_RMK" ).append("\n"); 
		query.append("        ,DECODE (BK.DCGO_FLG,'Y','**','') EBL_CGO_CATE_CD" ).append("\n"); 
		query.append("        ,BK.BKG_NO SR_NO" ).append("\n"); 
		query.append("        ,'1' EBL_SR_AMD_TP_CD" ).append("\n"); 
		query.append("        ,NVL(DECODE(BK.RCV_TERM_CD, 'Y', 'CY'  " ).append("\n"); 
		query.append("                                  , 'S', 'CFS'  " ).append("\n"); 
		query.append("                                  , 'H', 'CY'  " ).append("\n"); 
		query.append("                                  , 'D', 'DOOR'  " ).append("\n"); 
		query.append("                                  , 'I', 'FREE IN'  " ).append("\n"); 
		query.append("                                  , 'T', 'TACKLE'  " ).append("\n"); 
		query.append("                                  , 'M', ''  " ).append("\n"); 
		query.append("                                  , '',  ''), BKG_JOIN_FNC(CURSOR(  " ).append("\n"); 
		query.append("                          SELECT DECODE(CON.RCV_TERM_CD, 'Y', 'CY'  " ).append("\n"); 
		query.append("                                                       , 'S', 'CFS'  " ).append("\n"); 
		query.append("                                                       , 'H', 'CY'  " ).append("\n"); 
		query.append("                                                       , 'D', 'DOOR'  " ).append("\n"); 
		query.append("                                                       , 'I', 'FREE IN'  " ).append("\n"); 
		query.append("                                                       , 'T', 'TACKLE'  " ).append("\n"); 
		query.append("                                                       , 'M', 'MIXED'  " ).append("\n"); 
		query.append("                                                       , '',  '') AS A  " ).append("\n"); 
		query.append("                             FROM BKG_CONTAINER CON  " ).append("\n"); 
		query.append("                            WHERE 1=1  " ).append("\n"); 
		query.append("                              AND CON.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("                            GROUP BY CON.RCV_TERM_CD  " ).append("\n"); 
		query.append("                         ), '+'))||'/'||" ).append("\n"); 
		query.append("		      NVL(DECODE(BK.DE_TERM_CD, 'Y', 'CY'  " ).append("\n"); 
		query.append("                                 , 'S', 'CFS'  " ).append("\n"); 
		query.append("                                 , 'H', 'CY'  " ).append("\n"); 
		query.append("                                 , 'D', 'DOOR'  " ).append("\n"); 
		query.append("                                 , 'O', 'FREE OUT'  " ).append("\n"); 
		query.append("                                 , 'T', 'TACKLE'  " ).append("\n"); 
		query.append("                                 , 'M', ''  " ).append("\n"); 
		query.append("                                 , '',  '') , BKG_JOIN_FNC(CURSOR(  " ).append("\n"); 
		query.append("                          SELECT DECODE(CON.DE_TERM_CD, 'Y', 'CY'  " ).append("\n"); 
		query.append("                                                      , 'S', 'CFS'  " ).append("\n"); 
		query.append("                                                      , 'H', 'CY'  " ).append("\n"); 
		query.append("                                                      , 'D', 'DOOR'  " ).append("\n"); 
		query.append("                                                      , 'O', 'FREE OUT'  " ).append("\n"); 
		query.append("                                                      , 'T', 'TACKLE'  " ).append("\n"); 
		query.append("                                                      , 'M', 'MIXED'  " ).append("\n"); 
		query.append("                                                      , '',  '') AS A  " ).append("\n"); 
		query.append("                             FROM BKG_CONTAINER CON  " ).append("\n"); 
		query.append("                            WHERE 1=1  " ).append("\n"); 
		query.append("                              AND CON.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("                          GROUP BY CON.DE_TERM_CD  " ).append("\n"); 
		query.append("                         ), '+'))  EBL_ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("        ,BK.BL_NO               BL_NO" ).append("\n"); 
		query.append("        ,DECODE(BK.BL_TP_CD,'W','2','1')  BL_TP_CD" ).append("\n"); 
		query.append("        ,BK.BL_NO		        ORG_BL_NO" ).append("\n"); 
		query.append("        ,'N'        RISS_FLG" ).append("\n"); 
		query.append("        ,'Ocean B/L' NTC_TIT_CTNT" ).append("\n"); 
		query.append("        ,'' SIG_STMT_CTNT" ).append("\n"); 
		query.append("        ,DECODE(RT.FRT_TERM_CD,'P','=FREIGHT PREPAID=','C','=FREIGHT COLLECT=',NULL) EBL_FRT_TERM_CD" ).append("\n"); 
		query.append("        ,(SELECT COALESCE(PSAN_NO,XTER_SI_REF_NO,XTER_REF_NO) AS DOC_NO  " ).append("\n"); 
		query.append("           FROM (  " ).append("\n"); 
		query.append("                 SELECT BKG_NO  " ).append("\n"); 
		query.append("                       ,MAX(DECODE(BKG_REF_TP_CD, 'PSAN', CUST_REF_NO_CTNT, '')) AS PSAN_NO  " ).append("\n"); 
		query.append("                       ,MAX(DECODE(BKG_REF_TP_CD, 'EBRF', CUST_REF_NO_CTNT, '')) AS XTER_REF_NO  " ).append("\n"); 
		query.append("                       ,MAX(DECODE(BKG_REF_TP_CD, 'ESRF', CUST_REF_NO_CTNT, '')) AS XTER_SI_REF_NO  " ).append("\n"); 
		query.append("                   FROM BKG_REFERENCE  " ).append("\n"); 
		query.append("                  WHERE BKG_NO IN (@[bkg_no])   " ).append("\n"); 
		query.append("                    AND BKG_REF_TP_CD IN ('EBRF', 'ESRF','PSAN')  " ).append("\n"); 
		query.append("                  GROUP BY BKG_NO)) AR_INV_NO" ).append("\n"); 
		query.append("        ,'' LC_NO" ).append("\n"); 
		query.append("		,SUBSTR(REPLACE(CUST.CUST_NM,CHR(13)||CHR(10),'^'),1,INSTR(REPLACE(CUST.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_NM1" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_NM,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_NM2" ).append("\n"); 
		query.append("        ,'' ACT_SHPR_PHN_NO1" ).append("\n"); 
		query.append("        ,CUST.CUST_FAX_NO SHPR_FAX_NO1" ).append("\n"); 
		query.append("        ,CUST.CUST_EML SHPR_EML1" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),1,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_ADDR1" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_ADDR2" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - 1) SHPR_ADDR3" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) - 1) SHPR_ADDR4" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,5) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) - 1) SHPR_ADDR5 " ).append("\n"); 
		query.append("        ,'' ACT_SHPR_PHN_NO2" ).append("\n"); 
		query.append("        ,SUBSTR(CUST.CUST_NM,1,25) ACT_SHPR_NM" ).append("\n"); 
		query.append("        ,'Y' CFM_FLG" ).append("\n"); 
		query.append("        ,TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD') CFM_DT" ).append("\n"); 
		query.append("        ,'' BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append("        ,TO_DATE(TO_CHAR(BL.BL_OBRD_DT,'YYYYMMDD'),'YYYYMMDD') BL_OBRD_DT" ).append("\n"); 
		query.append("        ,TO_DATE(TO_CHAR(VSK.VPS_ETA_DT,'YYYYMMDD'),'YYYYMMDD') VSL_ETA_DT" ).append("\n"); 
		query.append("        ,'' SR_CMT_DESC" ).append("\n"); 
		query.append("        ,(SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM BKG_VVD WHERE BKG_NO = BK.BKG_NO AND POL_CD = BK.POL_CD AND VSL_PRE_PST_CD = 'S') VVD_CD" ).append("\n"); 
		query.append("		,SUBSTR(BL.PRE_VSL_NM,1,17) PRE_VSL_NM" ).append("\n"); 
		query.append("        ,SUBSTR(BL.VSL_NM,1,35) VSL_NM" ).append("\n"); 
		query.append("        ,SUBSTR(MDM_VSL.VSL_RGST_CNT_CD,1,5) VVD_NM" ).append("\n"); 
		query.append("        ,SUBSTR(MDM_VSL.VSL_ENG_NM,1,14) EBL_NTLT_DIV_CD" ).append("\n"); 
		query.append("        ,ISS.OBL_SRND_FLG OBL_SRND_FLG" ).append("\n"); 
		query.append("        ,BK.POL_CD POL_CD" ).append("\n"); 
		query.append("		,SUBSTR(BL.POL_NM,1,35)  POL_NM" ).append("\n"); 
		query.append("        ,BK.POD_CD POD_CD" ).append("\n"); 
		query.append("        ,SUBSTR(BL.POD_NM,1,35)  POD_NM" ).append("\n"); 
		query.append("        ,BK.DEL_CD DEL_CD" ).append("\n"); 
		query.append("        ,NVL(BL.FNL_DEST_NM,' ') DEL_NM" ).append("\n"); 
		query.append("        ,BK.DEL_CD DEL_CD1" ).append("\n"); 
		query.append("        ,NVL(BL.FNL_DEST_NM,' ') DEL_NM1" ).append("\n"); 
		query.append("        ,BK.POR_CD POR_CD" ).append("\n"); 
		query.append("        ,SUBSTR(BL.POR_NM,1,35) POR_NM" ).append("\n"); 
		query.append("        ,BK.DEL_CD DEL_CD2" ).append("\n"); 
		query.append("        ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) DEL_NM2" ).append("\n"); 
		query.append("        ,BK.POD_CD POD_CD1" ).append("\n"); 
		query.append("        ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POD_CD) POD_NM1" ).append("\n"); 
		query.append("        ,'N' INLND_ROUT_RMK" ).append("\n"); 
		query.append("        ,SUBSTR(BL.PRE_VSL_NM,1,35) EBL_PRE_PORT_CD" ).append("\n"); 
		query.append("        ,'' INLND_ROUT_RMK1" ).append("\n"); 
		query.append("        ,'' BL_MV_TP_NM" ).append("\n"); 
		query.append("        ,DECODE(DECODE(NVL(ISS.ORG_PPD_RCV_CD,'X'),'N',1,'C',1,0)+DECODE(NVL(ISS.ORG_N3PTY_PPD_CD,'X'),'N',1,'C',1,0),0,'Y','N') BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,(SELECT SUBSTR(F.CUST_NM,1,300) FROM BKG_CUSTOMER F WHERE F.BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD ='F') CUST_REF_RMK" ).append("\n"); 
		query.append("        ,(SELECT SUBSTR(CUST_NM,1,300) FROM BKG_CUSTOMER E WHERE BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD ='E') VNDR_CUST_REF_RMK" ).append("\n"); 
		query.append("        ,'' ORG_CNT_NM" ).append("\n"); 
		query.append("        ,'' LODG_RMK" ).append("\n"); 
		query.append("        ,'' EBL_MSG_TP_CD" ).append("\n"); 
		query.append("        ,'' CO_NM1" ).append("\n"); 
		query.append("        ,'' CO_NM2" ).append("\n"); 
		query.append("        ,'SM Line Corporation,' CO_ADDR1" ).append("\n"); 
		query.append("        ,'25 Gukjegeumyung-ro 2-gil, Yeongdeungpo-gu,' CO_ADDR2" ).append("\n"); 
		query.append("        ,'Seoul, Korea 07327' CO_ADDR3" ).append("\n"); 
		query.append("        ,ISS.OBL_ISS_OFC_CD BL_ISS_LOC_CD" ).append("\n"); 
		query.append("		,SUBSTR((SELECT A3.LOC_NM || ',' || A3.CNT_CD FROM MDM_ORGANIZATION A1, BKG_BL_ISS A2, MDM_LOCATION A3 WHERE A1.OFC_CD = A2.OBL_ISS_OFC_CD AND A2.BKG_NO = BK.BKG_NO AND A1.LOC_CD = A3.LOC_CD),1,25) BL_ISS_LOC_NM" ).append("\n"); 
		query.append("        ,RT.PPD_RCV_OFC_CD EBL_BKG_PPD_INP_TERM_CD" ).append("\n"); 
		query.append("		,SUBSTR((SELECT A2.LOC_CD FROM BKG_RATE A1 ,MDM_ORGANIZATION A2 WHERE A1.PPD_RCV_OFC_CD = A2.OFC_CD AND A1.BKG_NO = BK.BKG_NO AND EXISTS ( SELECT 'Y' FROM BKG_CHG_RT RT WHERE RT.BKG_NO = A1.BKG_NO AND RT.FRT_INCL_XCLD_DIV_CD = 'N' AND FRT_TERM_CD ='P' AND ROWNUM = 1) ),1,25)  EBL_PPD_OFC_CD" ).append("\n"); 
		query.append("        ,RT.CLT_OFC_CD EBL_BKG_CLT_INP_TERM_CD" ).append("\n"); 
		query.append("		,SUBSTR((SELECT A2.LOC_CD FROM BKG_RATE A1 ,MDM_ORGANIZATION A2 WHERE A1.CLT_OFC_CD = A2.OFC_CD AND A1.BKG_NO = BK.BKG_NO AND EXISTS ( SELECT 'Y' FROM BKG_CHG_RT RT WHERE RT.BKG_NO = A1.BKG_NO AND RT.FRT_INCL_XCLD_DIV_CD = 'N' AND FRT_TERM_CD ='C' AND ROWNUM = 1) ),1,25) EBL_CLT_OFC_CD" ).append("\n"); 
		query.append("        ,ISS.BL_CPY_KNT OBL_ISS_KNT" ).append("\n"); 
		query.append("        ,SUBSTR(CUST.CUST_NM,1,50) SHPR_NM3" ).append("\n"); 
		query.append("        ,SUBSTR(CUST.CUST_NM,51,50) SHPR_NM4" ).append("\n"); 
		query.append("        ,'' ACT_SHPR_PHN_NO3" ).append("\n"); 
		query.append("        ,CUST.CUST_EML SHPR_EML2" ).append("\n"); 
		query.append("        ,CUST.CUST_FAX_NO SHPR_FAX_NO2" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),1,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_ADDR6" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_ADDR7" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - 1) SHPR_ADDR7" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,3) - 1) SHPR_ADDR9" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST.CUST_ADDR,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) + 1" ).append("\n"); 
		query.append("                                                            ,INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,5) - " ).append("\n"); 
		query.append("                                                             INSTR(REPLACE(CUST.CUST_ADDR||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,4) - 1) SHPR_ADD10" ).append("\n"); 
		query.append("        ,SUBSTR(CNTC.CNTC_PSON_NM,1,35) APRO_USR_NM2" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST2.CUST_NM,CHR(13)||CHR(10),'^'),1,INSTR(REPLACE(CUST2.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_CTNT1" ).append("\n"); 
		query.append("        ,SUBSTR(REPLACE(CUST2.CUST_NM,CHR(13)||CHR(10),'^'),INSTR(REPLACE(CUST2.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) + 1" ).append("\n"); 
		query.append("                                                           ,INSTR(REPLACE(CUST2.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,2) - " ).append("\n"); 
		query.append("                                                            INSTR(REPLACE(CUST2.CUST_NM||CHR(13)||CHR(10),CHR(13)||CHR(10),'^'),'^',1,1) - 1) SHPR_CTNT2" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,1,50) SHPR_ADDR11" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,51,50) SHPR_ADDR12" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,101,50) SHPR_ADDR13" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,151,50) SHPR_ADDR14" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,201,50) SHPR_ADDR15" ).append("\n"); 
		query.append("        ,'' ACT_CUST_PHN_NO" ).append("\n"); 
		query.append("        ,CUST2.CUST_FAX_NO ACT_CUST_FAX_NO" ).append("\n"); 
		query.append("        ,CUST2.CUST_EML CUST_EML1" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_NM,1,35) APRO_USR_NM3" ).append("\n"); 
		query.append("        ,'' CHG_RMK1" ).append("\n"); 
		query.append("        ,'' CHG_RMK2" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,1,50) CUST_ADDR1" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,51,50) CUST_ADDR2" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,101,50) CUST_ADDR3" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,151,50) CUST_ADDR4" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,201,50) CUST_ADDR5" ).append("\n"); 
		query.append("        ,'' CUST_PHN_NO1" ).append("\n"); 
		query.append("        ,CUST2.CUST_FAX_NO CUST_FAX_NO1" ).append("\n"); 
		query.append("        ,CUST2.CUST_EML CUST_EML2" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_NM,1,35) APRO_USR_NM4" ).append("\n"); 
		query.append("        ,'' CHG_RMK3" ).append("\n"); 
		query.append("        ,'' CHG_RMK4" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,1,50) CUST_ADDR6" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,51,50) CUST_ADDR7" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,101,50) CUST_ADDR8" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,151,50) CUST_ADDR9" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_ADDR,201,50) CUST_ADDR10" ).append("\n"); 
		query.append("        ,'' CUST_PHN_NO2" ).append("\n"); 
		query.append("        ,CUST2.CUST_FAX_NO CUST_FAX_NO2" ).append("\n"); 
		query.append("        ,CUST2.CUST_EML CUST_EML3" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_NM,1,35) APRO_USR_NM5" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD),1,30) CHK_DE_CTY_NM1" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD),31) CHK_DE_CTY_NM2" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = BK.DEL_NOD_CD),1,50) CHK_DE_ADDR1" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = BK.DEL_NOD_CD),51,50) CHK_DE_ADDR2" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = BK.DEL_NOD_CD),101,50) CHK_DE_ADDR3" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = BK.DEL_NOD_CD),151,50) CHK_DE_ADDR4" ).append("\n"); 
		query.append("        ,SUBSTR((SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = BK.DEL_NOD_CD),201,50) CHK_DE_ADDR5" ).append("\n"); 
		query.append("        ,'' CUST_PHN_NO3" ).append("\n"); 
		query.append("        ,CUST2.CUST_FAX_NO CUST_FAX_NO3" ).append("\n"); 
		query.append("        ,CUST2.CUST_EML CUST_EML4" ).append("\n"); 
		query.append("        ,SUBSTR(CUST2.CUST_NM,1,35) APRO_USR_NM6" ).append("\n"); 
		query.append("        ,DECODE(BL.WGT_UT_CD,'KGS',LTRIM(BL.ACT_WGT)  " ).append("\n"); 
		query.append("                                                       ,LTRIM(ROUND(BL.ACT_WGT * 0.4536,3))) CNTR_WGT" ).append("\n"); 
		query.append("        ,DECODE(BL.MEAS_UT_CD,'CBM',LTRIM(BL.MEAS_QTY)  " ).append("\n"); 
		query.append("                                                         ,LTRIM(ROUND(BL.MEAS_QTY * 0.0283,3))) ACT_WGT" ).append("\n"); 
		query.append("        ,BL.PCK_QTY PCK_QTY" ).append("\n"); 
		query.append("        ,BL.PCK_TP_CD PCK_TP_CD" ).append("\n"); 
		query.append("        ,SUBSTR(BL.TTL_PCK_DESC,1,70) MK_DESC1" ).append("\n"); 
		query.append("        ,SUBSTR(BL.TTL_PCK_DESC,71,70) MK_DESC2" ).append("\n"); 
		query.append("        ,SUBSTR(BL.TTL_PCK_DESC,141,70) MK_DESC3" ).append("\n"); 
		query.append("        ,SUBSTR(BL.TTL_PCK_DESC,211,70) MK_DESC4" ).append("\n"); 
		query.append("        ,SUBSTR(BL.TTL_PCK_DESC,281,70) MK_DESC5" ).append("\n"); 
		query.append("        ,'N' IF_FLG" ).append("\n"); 
		query.append("        ,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("        ,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM  BKG_BOOKING BK" ).append("\n"); 
		query.append("       ,BKG_CNTC_PSON CNTC" ).append("\n"); 
		query.append("       ,BKG_BL_ISS    ISS" ).append("\n"); 
		query.append("	   ,BKG_RATE      RT" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER  CUST" ).append("\n"); 
		query.append("       ,BKG_BL_DOC    BL" ).append("\n"); 
		query.append("       ,BKG_VVD       VVD" ).append("\n"); 
		query.append("       ,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("	   ,BKG_CUSTOMER  CUST2" ).append("\n"); 
		query.append("	   ,MDM_VSL_CNTR MDM_VSL" ).append("\n"); 
		query.append(" WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = CNTC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  CNTC.BKG_CNTC_PSON_TP_CD(+) = 'BK'" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("   AND  CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = CUST2.BKG_NO" ).append("\n"); 
		query.append("   AND  CUST2.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND  BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND  BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("   AND  BK.VSL_CD = MDM_VSL.VSL_CD" ).append("\n"); 
		query.append("   AND  VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("   AND  VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND  VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND  VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BK.BKG_NO)" ).append("\n"); 

	}
}
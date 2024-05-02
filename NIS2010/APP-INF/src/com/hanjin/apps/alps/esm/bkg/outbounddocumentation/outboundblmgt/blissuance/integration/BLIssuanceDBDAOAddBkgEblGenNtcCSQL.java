/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblGenNtcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.21
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.21 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblGenNtcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOAddBkgEblGenNtcCSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblGenNtcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ebl_type_code",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : BLIssuanceDBDAOAddBkgEblGenNtcCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_GEN_NTC" ).append("\n"); 
		query.append("    (BKG_NO" ).append("\n"); 
		query.append("    ,BKG_EBL_SEQ" ).append("\n"); 
		query.append("    ,CNTR_SEQ" ).append("\n"); 
		query.append("    ,DOC_PARA_NO1" ).append("\n"); 
		query.append("    ,DOC_PARA_NO2" ).append("\n"); 
		query.append("    ,DOC_RMK" ).append("\n"); 
		query.append("    ,DOC_NO_AND_CLSS_NM" ).append("\n"); 
		query.append("    ,OBJ_FUNC_EVNT_CD1" ).append("\n"); 
		query.append("    ,OBJ_FUNC_EVNT_CD2" ).append("\n"); 
		query.append("    ,OBJ_FUNC_EVNT_CD3" ).append("\n"); 
		query.append("    ,OBJ_FUNC_EVNT_CD4" ).append("\n"); 
		query.append("    ,OBJ_FUNC_EVNT_CD5" ).append("\n"); 
		query.append("    ,REF_NO" ).append("\n"); 
		query.append("    ,UPLD_DT" ).append("\n"); 
		query.append("    ,ACT_CUST_NM" ).append("\n"); 
		query.append("    ,ITM_NM" ).append("\n"); 
		query.append("    ,BL_NO" ).append("\n"); 
		query.append("    ,BL_ISS_DT" ).append("\n"); 
		query.append("    ,RISS_DT" ).append("\n"); 
		query.append("    ,BKG_CFM_FLG" ).append("\n"); 
		query.append("    ,RJCT_RSN_RMK" ).append("\n"); 
		query.append("    ,SHPR_NM" ).append("\n"); 
		query.append("    ,SHPR_CTNT" ).append("\n"); 
		query.append("    ,CNEE_NM" ).append("\n"); 
		query.append("    ,CNEE_CTNT" ).append("\n"); 
		query.append("    ,OBL_SRND_FLG" ).append("\n"); 
		query.append("    ,INTER_RMK" ).append("\n"); 
		query.append("    ,RQST_CO_NM" ).append("\n"); 
		query.append("    ,RQST_RMK" ).append("\n"); 
		query.append("    ,RQST_USR_NM" ).append("\n"); 
		query.append("    ,RQST_PHN_NO" ).append("\n"); 
		query.append("    ,RCVR_NM" ).append("\n"); 
		query.append("    ,DE_NM" ).append("\n"); 
		query.append("    ,PRN_DT" ).append("\n"); 
		query.append("    ,BL_CPY_KNT" ).append("\n"); 
		query.append("    ,APRO_FLG" ).append("\n"); 
		query.append("    ,EBL_RJCT_RSN" ).append("\n"); 
		query.append("    ,ACK_RCV_DT" ).append("\n"); 
		query.append("    ,DE_DT" ).append("\n"); 
		query.append("    ,BKG_CUST_NM" ).append("\n"); 
		query.append("    ,BL_CUST_NM" ).append("\n"); 
		query.append("    ,CUST_PHN_NO" ).append("\n"); 
		query.append("    ,RSLT_FLG" ).append("\n"); 
		query.append("    ,RSLT_RMK" ).append("\n"); 
		query.append("    ,ERR_TP_CTNT" ).append("\n"); 
		query.append("    ,ERR_MSG" ).append("\n"); 
		query.append("    ,IF_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("    ,@[bkg_ebl_seq]" ).append("\n"); 
		query.append("    ,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,'BLGeneralNotice' AS DOC_RMK" ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_NO_AND_CLSS_NM" ).append("\n"); 
		query.append("	,'1' OBJ_FUNC_EVNT_CD1" ).append("\n"); 
		query.append("	,'NA' OBJ_FUNC_EVNT_CD2" ).append("\n"); 
		query.append("	,'1.0' OBJ_FUNC_EVNT_CD3" ).append("\n"); 
		query.append("	,'1' OBJ_FUNC_EVNT_CD4" ).append("\n"); 
		query.append("	,@[ebl_type_code]  OBJ_FUNC_EVNT_CD5" ).append("\n"); 
		query.append("	,'' REF_NO" ).append("\n"); 
		query.append("	,SYSDATE UPLD_DT" ).append("\n"); 
		query.append("	,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='C') ACT_CUST_NM" ).append("\n"); 
		query.append("    ,'A' ITM_NM" ).append("\n"); 
		query.append("    ,BK.BL_NO BL_NO" ).append("\n"); 
		query.append("    ,ISS.OBL_ISS_DT BL_ISS_DT" ).append("\n"); 
		query.append("    ,ISS.OBL_ISS_DT RISS_DT" ).append("\n"); 
		query.append("    ,'Y' BKG_CFM_FLG " ).append("\n"); 
		query.append("    ,'' RJCT_RSN_RMK  " ).append("\n"); 
		query.append("    ,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='S') SHPR_NM" ).append("\n"); 
		query.append("    ,'' SHPR_CTNT" ).append("\n"); 
		query.append("    ,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='C') CNEE_NM" ).append("\n"); 
		query.append("    ,'' CNEE_CTNT" ).append("\n"); 
		query.append("    ,'N' OBL_SRND_FLG" ).append("\n"); 
		query.append("    ,'' INTER_RMK" ).append("\n"); 
		query.append("    ,'' RQST_CO_NM" ).append("\n"); 
		query.append("    ,'' RQST_RMK" ).append("\n"); 
		query.append("    ,'' RQST_USR_NM" ).append("\n"); 
		query.append("    ,'' RQST_PHN_NO" ).append("\n"); 
		query.append("    ,'' RCVR_NM" ).append("\n"); 
		query.append("    ,'' DE_NM" ).append("\n"); 
		query.append("	,'' PRN_DT" ).append("\n"); 
		query.append("    ,ISS.BL_ISS_KNT BL_CPY_KNT" ).append("\n"); 
		query.append("    ,'Y' APRO_FLG" ).append("\n"); 
		query.append("    ,'' EBL_RJCT_RSN" ).append("\n"); 
		query.append("    ,'' ACK_RCV_DT" ).append("\n"); 
		query.append("    ,'' DE_DT" ).append("\n"); 
		query.append("    ,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='C') BKG_CUST_NM" ).append("\n"); 
		query.append("    ,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='C') BL_CUST_NM" ).append("\n"); 
		query.append("    ,'' CUST_PHN_NO" ).append("\n"); 
		query.append("    ,'' RSLT_FLG" ).append("\n"); 
		query.append("    ,'' RSLT_RMK" ).append("\n"); 
		query.append("    ,'' ERR_TP_CTNT" ).append("\n"); 
		query.append("    ,'' ERR_MSG" ).append("\n"); 
		query.append("	,'N' IF_FLG" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT	" ).append("\n"); 
		query.append("  FROM	BKG_BOOKING BK, BKG_BL_ISS ISS" ).append("\n"); 
		query.append(" WHERE 	BK.BKG_NO = @[bkg_no]				   			   " ).append("\n"); 
		query.append("   AND  BK.BKG_NO = ISS.BKG_NO" ).append("\n"); 

	}
}
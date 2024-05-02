/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RuLabelManagementDBDAOsearchRuLabelAttachmentExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.02.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RuLabelManagementDBDAOsearchRuLabelAttachmentExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 엑셀 업로드후 처리
	  * </pre>
	  */
	public RuLabelManagementDBDAOsearchRuLabelAttachmentExcelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.integration").append("\n"); 
		query.append("FileName : RuLabelManagementDBDAOsearchRuLabelAttachmentExcelListRSQL").append("\n"); 
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
		query.append("SELECT   MC.CNTR_NO" ).append("\n"); 
		query.append("       , MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , MC.AGMT_CTY_CD|| LTRIM(TO_CHAR(MC.AGMT_SEQ,'000000')) AGMT_NO" ).append("\n"); 
		query.append("       , MC.VNDR_SEQ  AS LESSOR" ).append("\n"); 
		query.append("       , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR B WHERE MC.VNDR_SEQ = B.VNDR_SEQ) AS LESSOR_NM" ).append("\n"); 
		query.append("       , MC.CNTR_AUTH_NO" ).append("\n"); 
		query.append("	   , (SELECT RSTR_USG_TP_CD FROM MST_RSTR_USG_CD WHERE 1=1 AND DELT_FLG = 'N' AND RSTR_USG_TP_CD = TMP.INP_MSG2 AND ROWNUM=1) AS RU_LABEL_TYPE" ).append("\n"); 
		query.append("	   , (SELECT RSTR_USG_LBL_NM FROM MST_RSTR_USG_CD WHERE 1=1 AND DELT_FLG = 'N' AND RSTR_USG_TP_CD = TMP.INP_MSG2 AND RSTR_USG_LBL_NM = TMP.INP_MSG3 AND ROWNUM=1) RU_LABEL_VALUE" ).append("\n"); 
		query.append("       , (SELECT RSTR_USG_LBL_NM FROM MST_RSTR_USG_CD WHERE 1=1 AND DELT_FLG = 'N' AND RSTR_USG_TP_CD = TMP.INP_MSG2 AND RSTR_USG_LBL_NM = TMP.INP_MSG3 AND ROWNUM=1) HIS_RU_LABEL_VALUE" ).append("\n"); 
		query.append("	   , TMP.INP_MSG4 AS REMARK" ).append("\n"); 
		query.append("	   , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("	   , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("	   , TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("	   , @[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("       , (SELECT  LA.LSE_CTRT_NO" ).append("\n"); 
		query.append("            FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("           WHERE LA.AGMT_CTY_CD = MC.AGMT_CTY_CD" ).append("\n"); 
		query.append("             AND LA.AGMT_SEQ    = MC.AGMT_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM         = 1) AS LSE_CTRT_NO" ).append("\n"); 
		query.append("       , MC.CRNT_YD_CD" ).append("\n"); 
		query.append("       , MC.CNMV_STS_CD" ).append("\n"); 
		query.append("       , TO_CHAR(MC.CNMV_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_DT" ).append("\n"); 
		query.append("       , DECODE(MC.FULL_FLG, 'Y', 'F', 'M') AS FULL_FLG" ).append("\n"); 
		query.append("       , MC.CNTR_STS_CD" ).append("\n"); 
		query.append("       , MC.MFTR_VNDR_SEQ" ).append("\n"); 
		query.append("       , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("           WHERE MC.MFTR_VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM               = 1) MFTR_VNDR_NM" ).append("\n"); 
		query.append("       , TO_CHAR(MC.MFT_DT, 'YYYY-MM-DD') AS MFT_DT" ).append("\n"); 
		query.append("       , DECODE(MC.RF_MKR_SEQ, 0, NULL, MC.RF_MKR_SEQ) RF_MKR_SEQ" ).append("\n"); 
		query.append("       , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("           WHERE MC.RF_MKR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM               = 1) RF_MKR_NM  " ).append("\n"); 
		query.append("       , MC.RF_MDL_NM" ).append("\n"); 
		query.append("       , MC.LSTM_CD" ).append("\n"); 
		query.append("FROM EQR_CTRL_DAT_VRFY TMP" ).append("\n"); 
		query.append("    , MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE TMP.INP_MSG1 = MC.CNTR_NO" ).append("\n"); 
		query.append("AND   TMP.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("ORDER BY  TMP.INP_MSG1" ).append("\n"); 

	}
}
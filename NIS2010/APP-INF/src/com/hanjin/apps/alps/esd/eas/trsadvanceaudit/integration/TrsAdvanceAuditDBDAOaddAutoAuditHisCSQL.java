/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOaddAutoAuditHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.03.07 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOaddAutoAuditHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit History 저장
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOaddAutoAuditHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOaddAutoAuditHisCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_TRSP_AUD_HIS (" ).append("\n"); 
		query.append("  INV_NO" ).append("\n"); 
		query.append(", INV_VNDR_SEQ" ).append("\n"); 
		query.append(", TRSP_SO_TP_CD" ).append("\n"); 
		query.append(", AUD_HIS_SEQ" ).append("\n"); 
		query.append(", EXPN_AUD_STS_CD" ).append("\n"); 
		query.append(", EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append(", EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append(", EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append(", ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append(", RHQ_CD" ).append("\n"); 
		query.append(", INV_OFC_CD" ).append("\n"); 
		query.append(", INV_CFM_DT" ).append("\n"); 
		query.append(", AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", WO_AMT" ).append("\n"); 
		query.append(", INV_AMT" ).append("\n"); 
		query.append(", CURR_CNG_FLG" ).append("\n"); 
		query.append(", INV_DIFF_AMT" ).append("\n"); 
		query.append(", INV_DIFF_RTO" ).append("\n"); 
		query.append(", AGMT_APLY_FLG" ).append("\n"); 
		query.append(", OPTM_ROUT_FLG" ).append("\n"); 
		query.append(", AVG_OVR_DIFF_AMT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", INV_ISS_DT" ).append("\n"); 
		query.append(", INV_ISS_USR_ID" ).append("\n"); 
		query.append(", GEN_PAY_TERM_CD" ).append("\n"); 
		query.append(", PAY_DUE_DT" ).append("\n"); 
		query.append(", PAY_DT" ).append("\n"); 
		query.append(", HJL_INV_NO" ).append("\n"); 
		query.append(", HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append(", INV_DIFF_FLG" ).append("\n"); 
		query.append(", AVG_OVR_DIFF_FLG" ).append("\n"); 
		query.append(", AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append(", AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append(", EAC_NO_CTNT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT INV_NO" ).append("\n"); 
		query.append(", INV_VNDR_SEQ" ).append("\n"); 
		query.append(", TRSP_SO_TP_CD" ).append("\n"); 
		query.append(", NVL((SELECT /*+ INDEX_DESC(X XPKEAS_TRSP_AUD_HIS) */" ).append("\n"); 
		query.append("              AUD_HIS_SEQ" ).append("\n"); 
		query.append("         FROM EAS_TRSP_AUD_HIS X" ).append("\n"); 
		query.append("        WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("          AND X.INV_VNDR_SEQ  = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("          AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("  ),0) + 1 AUD_HIS_SEQ" ).append("\n"); 
		query.append(", EXPN_AUD_STS_CD" ).append("\n"); 
		query.append(", EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append(", EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append(", EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append(", ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append(", RHQ_CD" ).append("\n"); 
		query.append(", INV_OFC_CD" ).append("\n"); 
		query.append(", INV_CFM_DT" ).append("\n"); 
		query.append(", AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", WO_AMT" ).append("\n"); 
		query.append(", INV_AMT" ).append("\n"); 
		query.append(", CURR_CNG_FLG" ).append("\n"); 
		query.append(", INV_DIFF_AMT" ).append("\n"); 
		query.append(", INV_DIFF_RTO" ).append("\n"); 
		query.append(", AGMT_APLY_FLG" ).append("\n"); 
		query.append(", OPTM_ROUT_FLG" ).append("\n"); 
		query.append(", AVG_OVR_DIFF_AMT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", INV_ISS_DT" ).append("\n"); 
		query.append(", INV_ISS_USR_ID" ).append("\n"); 
		query.append(", GEN_PAY_TERM_CD" ).append("\n"); 
		query.append(", PAY_DUE_DT" ).append("\n"); 
		query.append(", PAY_DT" ).append("\n"); 
		query.append(", HJL_INV_NO" ).append("\n"); 
		query.append(", HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append(", INV_DIFF_FLG" ).append("\n"); 
		query.append(", AVG_OVR_DIFF_FLG" ).append("\n"); 
		query.append(", AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append(", AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append(", (SELECT WM_CONCAT(X.EAC_NO)" ).append("\n"); 
		query.append("     FROM EAS_TRSP_AUD_CHK X" ).append("\n"); 
		query.append("    WHERE X.INV_NO = A.INV_NO" ).append("\n"); 
		query.append("      AND X.INV_VNDR_SEQ  = A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("      AND X.TRSP_SO_TP_CD = A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM EAS_TRSP_AUD A" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND INV_VNDR_SEQ  = @[inv_vndr_seq]" ).append("\n"); 
		query.append("  AND TRSP_SO_TP_CD = @[trsp_so_tp_cd]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOAddAutoAuditHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.03.25 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOAddAutoAuditHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOAddAutoAuditHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOAddAutoAuditHistoryCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO EAS_PORT_SO_CFM_INV_HIS( " ).append("\n"); 
		query.append("	ISS_CTY_CD" ).append("\n"); 
		query.append("     , SO_SEQ" ).append("\n"); 
		query.append("     , SO_DTL_SEQ" ).append("\n"); 
		query.append("     , AUD_HIS_SEQ" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_CHK_CD" ).append("\n"); 
		query.append("     , EAC_NO" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_RSLT_RMK" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("     , ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("     , EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("     , RHQ_CD" ).append("\n"); 
		query.append("     , INV_OFC_CD" ).append("\n"); 
		query.append("     , INV_CFM_DT" ).append("\n"); 
		query.append("     , AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("     , YD_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , CALC_AMT" ).append("\n"); 
		query.append("     , ADJ_AMT" ).append("\n"); 
		query.append("     , LOCL_AMT" ).append("\n"); 
		query.append("     , INV_AMT" ).append("\n"); 
		query.append("     , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , CSR_NO" ).append("\n"); 
		query.append("     , EXPN_AUD_INV_STS_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , DP_IO_BND_CD" ).append("\n"); 
		query.append("     , VPS_ETB_DT" ).append("\n"); 
		query.append("     , ISS_DT" ).append("\n"); 
		query.append("     , INV_CRE_USR_ID" ).append("\n"); 
		query.append("     , DIFF_AMT" ).append("\n"); 
		query.append("     , FOML_DESC" ).append("\n"); 
		query.append("     , XPR_DESC" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_DT" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_USR_ID" ).append("\n"); 
		query.append("     , DIFF_RMK" ).append("\n"); 
		query.append("     , BRTH_HRS" ).append("\n"); 
		query.append("     , LST_PORT_CD" ).append("\n"); 
		query.append("     , ST_PORT_CD" ).append("\n"); 
		query.append("     , GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("     , NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("     , ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("     , DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("     , PAY_TERM_DYS" ).append("\n"); 
		query.append("     , PAY_DUE_DT" ).append("\n"); 
		query.append("     , AP_PAY_DT" ).append("\n"); 
		query.append("     , SUZ_GT_WGT" ).append("\n"); 
		query.append("     , MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("     , SDR_XCH_RT" ).append("\n"); 
		query.append("     , VSL_TR_NO   " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("ISS_CTY_CD" ).append("\n"); 
		query.append("     , SO_SEQ" ).append("\n"); 
		query.append("     , SO_DTL_SEQ" ).append("\n"); 
		query.append("     , NVL((SELECT /*+ INDEX_DESC(X XPKEAS_PORT_SO_CFM_INV_HIS) */" ).append("\n"); 
		query.append("                  AUD_HIS_SEQ" ).append("\n"); 
		query.append("             FROM EAS_PORT_SO_CFM_INV_HIS X" ).append("\n"); 
		query.append("            WHERE X.ISS_CTY_CD = A.ISS_CTY_CD" ).append("\n"); 
		query.append("              AND X.SO_SEQ  = A.SO_SEQ" ).append("\n"); 
		query.append("              AND X.SO_DTL_SEQ = A.SO_DTL_SEQ" ).append("\n"); 
		query.append("              AND ROWNUM = 1),0) + 1 AUD_HIS_SEQ" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_CHK_CD" ).append("\n"); 
		query.append("     , EAC_NO" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_RSLT_RMK" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("     , ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("     , EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("     , RHQ_CD" ).append("\n"); 
		query.append("     , INV_OFC_CD" ).append("\n"); 
		query.append("     , INV_CFM_DT" ).append("\n"); 
		query.append("     , AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("     , YD_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , LGS_COST_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , CALC_AMT" ).append("\n"); 
		query.append("     , ADJ_AMT" ).append("\n"); 
		query.append("     , LOCL_AMT" ).append("\n"); 
		query.append("     , INV_AMT" ).append("\n"); 
		query.append("     , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , CSR_NO" ).append("\n"); 
		query.append("     , EXPN_AUD_INV_STS_CD" ).append("\n"); 
		query.append("     , UPD_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , DP_IO_BND_CD" ).append("\n"); 
		query.append("     , VPS_ETB_DT" ).append("\n"); 
		query.append("     , ISS_DT" ).append("\n"); 
		query.append("     , INV_CRE_USR_ID" ).append("\n"); 
		query.append("     , DIFF_AMT" ).append("\n"); 
		query.append("     , FOML_DESC" ).append("\n"); 
		query.append("     , XPR_DESC" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_DT" ).append("\n"); 
		query.append("     , PORT_CHG_AUD_USR_ID" ).append("\n"); 
		query.append("     , DIFF_RMK" ).append("\n"); 
		query.append("     , BRTH_HRS" ).append("\n"); 
		query.append("     , LST_PORT_CD" ).append("\n"); 
		query.append("     , ST_PORT_CD" ).append("\n"); 
		query.append("     , GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("     , NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("     , ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("     , DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("     , PAY_TERM_DYS" ).append("\n"); 
		query.append("     , PAY_DUE_DT" ).append("\n"); 
		query.append("     , AP_PAY_DT" ).append("\n"); 
		query.append("     , SUZ_GT_WGT" ).append("\n"); 
		query.append("     , MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("     , SDR_XCH_RT" ).append("\n"); 
		query.append("     , VSL_TR_NO " ).append("\n"); 
		query.append("  FROM EAS_PORT_SO_CFM_INV A" ).append("\n"); 
		query.append(" WHERE ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("   AND SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("   AND SO_DTL_SEQ = @[so_dtl_seq]" ).append("\n"); 

	}
}
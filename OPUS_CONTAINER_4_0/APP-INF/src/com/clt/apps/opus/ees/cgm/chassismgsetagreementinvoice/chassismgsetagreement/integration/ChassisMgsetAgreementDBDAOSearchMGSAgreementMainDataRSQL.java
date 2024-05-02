/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementMainDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchMGSAgreementMainDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchMGSAgreementMainData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchMGSAgreementMainDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementMainDataRSQL").append("\n"); 
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
		query.append("SELECT 		" ).append("\n"); 
		query.append("	A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("	A.AGMT_SEQ," ).append("\n"); 
		query.append("	A.AGMT_VER_NO," ).append("\n"); 
		query.append("    A.LST_VER_FLG," ).append("\n"); 
		query.append("	A.AGMT_ISS_OFC_CD," ).append("\n"); 
		query.append("	A.AGMT_REF_NO," ).append("\n"); 
		query.append("	A.CURR_CD," ).append("\n"); 
		query.append("	TO_CHAR(A.AGMT_DT,'YYYY-MM-DD') AS AGMT_DT," ).append("\n"); 
		query.append("	TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT, " ).append("\n"); 
		query.append("	TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT," ).append("\n"); 
		query.append("	TO_CHAR(A.AGMT_EFF_DT,'YYYY-MM-DD') AS AGMT_EFF_DT, " ).append("\n"); 
		query.append("	TO_CHAR(A.AGMT_EXP_DT,'YYYY-MM-DD') AS AGMT_EXP_DT," ).append("\n"); 
		query.append("	A.VNDR_SEQ," ).append("\n"); 
		query.append("	B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("	A.PAY_TERM_DYS," ).append("\n"); 
		query.append("	A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("	A.CHSS_POOL_CD," ).append("\n"); 
		query.append("	A.EQ_RNTL_TP_CD," ).append("\n"); 
		query.append("	A.DPP_TP_CD," ).append("\n"); 
		query.append("	A.DPP_RT_AMT," ).append("\n"); 
		query.append("	A.DPP_CVRG_AMT," ).append("\n"); 
		query.append("	A.LMSM_AMT," ).append("\n"); 
		query.append("	A.ONH_HNDL_RT_AMT," ).append("\n"); 
		query.append("	A.OFFH_HNDL_RT_AMT," ).append("\n"); 
		query.append("	A.DRP_OFF_LMT_QTY," ).append("\n"); 
		query.append("	A.DRP_OFF_LMT_TP_CD," ).append("\n"); 
		query.append("	A.DRP_OFF_LMT_RTO," ).append("\n"); 
		query.append("	A.DRP_OFF_LMT_PRD_CD," ).append("\n"); 
		query.append("	A.MON_DPC_RT_AMT," ).append("\n"); 
		query.append("	A.MAX_DPC_RT_AMT," ).append("\n"); 
		query.append("	A.INIT_DPC_RT_AMT," ).append("\n"); 
		query.append("	A.DIFF_RMK," ).append("\n"); 
		query.append("    A.OLD_AGMT_NO," ).append("\n"); 
		query.append("    A.AGMT_CTRT_NO" ).append("\n"); 
		query.append("FROM CGM_AGREEMENT A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ " ).append("\n"); 
		query.append("	  AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("	  AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("	  AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#if (${agmt_ver_no} != '') " ).append("\n"); 
		query.append("	  AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	  AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.AGMT_VER_NO" ).append("\n"); 

	}
}
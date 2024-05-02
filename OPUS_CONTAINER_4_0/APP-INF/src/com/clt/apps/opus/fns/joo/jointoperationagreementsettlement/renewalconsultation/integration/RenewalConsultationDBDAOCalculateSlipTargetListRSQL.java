/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOCalculateSlipTargetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOCalculateSlipTargetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slip 대상을 조회 한다.
	  * </pre>
	  */
	public RenewalConsultationDBDAOCalculateSlipTargetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOCalculateSlipTargetListRSQL").append("\n"); 
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
		query.append("WITH V_MDM_ORG AS (" ).append("\n"); 
		query.append("    SELECT D.OFC_CD" ).append("\n"); 
		query.append("         , D.LOC_CD" ).append("\n"); 
		query.append("         , D.AP_CTR_CD" ).append("\n"); 
		query.append("         , D.AP_OFC_CD" ).append("\n"); 
		query.append("         , D.FINC_RGN_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION D" ).append("\n"); 
		query.append("         , MDM_ORGANIZATION E" ).append("\n"); 
		query.append("     WHERE D.OFC_CD = E.AP_OFC_CD" ).append("\n"); 
		query.append("       AND E.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("       AND ROWNUM   = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT INV.SLP_TP_CD" ).append("\n"); 
		query.append("     , INV.SLP_FUNC_CD" ).append("\n"); 
		query.append("     , INV.SLP_OFC_CD" ).append("\n"); 
		query.append("     , INV.SLP_ISS_DT" ).append("\n"); 
		query.append("     , INV.SLP_SER_NO" ).append("\n"); 
		query.append("     , ROUND(INV.ACT_AMT, 2) AS TOT_AMOUNT" ).append("\n"); 
		query.append("     , INV.ACCT_YRMON" ).append("\n"); 
		query.append("     , INV.JO_CRR_CD" ).append("\n"); 
		query.append("     , INV.INV_NO" ).append("\n"); 
		query.append("     , INV.PRNR_REF_NO" ).append("\n"); 
		query.append("     , SUBSTR(INV.INV_NO,1, 7)||SUBSTR(INV.INV_NO,9, 2)||LPAD(ROWNUM, 3, '0') AS KEY_NO" ).append("\n"); 
		query.append("     , DTL.VSL_CD" ).append("\n"); 
		query.append("     , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("     , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("     , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("     , DTL.REV_YRMON" ).append("\n"); 
		query.append("     , DTL.STL_VVD_SEQ" ).append("\n"); 
		query.append("     , DTL.ACT_AMT AS STL_LOCL_AMT" ).append("\n"); 
		query.append("     , STL.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , STL.RLANE_CD" ).append("\n"); 
		query.append("     , STL.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , ACC.DR_ACCT_CD" ).append("\n"); 
		query.append("     , ACC.CR_ACCT_CD" ).append("\n"); 
		query.append("     , ORG.AP_CTR_CD AS DR_CTR_CD" ).append("\n"); 
		query.append("     , ORG.AP_CTR_CD AS CR_CTR_CD" ).append("\n"); 
		query.append("     , ORG.LOC_CD AS DR_LOC_CD" ).append("\n"); 
		query.append("     , ORG.LOC_CD AS CR_LOC_CD" ).append("\n"); 
		query.append("     , 'DR' AS DR_CR_CD" ).append("\n"); 
		query.append("     , STL.JO_CRR_CD||'/'||ITM.JO_STL_ITM_NM AS SLP_DESC" ).append("\n"); 
		query.append("     , ( SELECT CASE WHEN COUNT(VVD.REV_YRMON) > 0 THEN 'N' ELSE 'Y' END" ).append("\n"); 
		query.append("           FROM AR_MST_REV_VVD VVD" ).append("\n"); 
		query.append("          WHERE VVD.VSL_CD        = STL.VSL_CD" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO    = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD    = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND VVD.RLANE_DIR_CD  = STL.REV_DIR_CD" ).append("\n"); 
		query.append("            AND VVD.RLANE_CD      = STL.RLANE_CD" ).append("\n"); 
		query.append("       ) AS VVD_CXL_FLG" ).append("\n"); 
		query.append("  FROM JOO_INVOICE INV" ).append("\n"); 
		query.append("     , JOO_INV_DTL DTL" ).append("\n"); 
		query.append("     , JOO_STL_TGT STL" ).append("\n"); 
		query.append("     , JOO_STL_ITM ITM" ).append("\n"); 
		query.append("     , JOO_STL_ITM_ACCT ACC" ).append("\n"); 
		query.append("     , V_MDM_ORG ORG" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND INV.INV_NO           = @[inv_no]" ).append("\n"); 
		query.append("   AND INV.ACCT_YRMON       = @[acct_yrmon]" ).append("\n"); 
		query.append("   AND INV.RE_DIVR_CD       = @[re_divr_cd]" ).append("\n"); 
		query.append("   AND INV.ACCTG_CRR_CD     = @[acctg_crr_cd]" ).append("\n"); 
		query.append("   AND INV.LOCL_CURR_CD     = @[locl_curr_cd]" ).append("\n"); 
		query.append("   AND INV.PRNR_REF_NO      = @[prnr_ref_no]" ).append("\n"); 
		query.append("   AND INV.ACCT_YRMON       = DTL.ACCT_YRMON" ).append("\n"); 
		query.append("   AND INV.JO_CRR_CD        = DTL.JO_CRR_CD" ).append("\n"); 
		query.append("   AND INV.INV_NO           = DTL.INV_NO" ).append("\n"); 
		query.append("   AND INV.RE_DIVR_CD       = DTL.RE_DIVR_CD" ).append("\n"); 
		query.append("   AND DTL.VSL_CD           = STL.VSL_CD" ).append("\n"); 
		query.append("   AND DTL.SKD_VOY_NO       = STL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND DTL.SKD_DIR_CD       = STL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND DTL.REV_DIR_CD       = STL.REV_DIR_CD" ).append("\n"); 
		query.append("   AND DTL.REV_YRMON        = STL.REV_YRMON" ).append("\n"); 
		query.append("   AND DTL.STL_VVD_SEQ      = STL.STL_VVD_SEQ" ).append("\n"); 
		query.append("   AND STL.JO_STL_ITM_CD    = ITM.JO_STL_ITM_CD" ).append("\n"); 
		query.append("   AND INV.RE_DIVR_CD       = ACC.RE_DIVR_CD" ).append("\n"); 
		query.append("   AND ITM.JO_STL_ITM_CD    = ACC.JO_STL_ITM_CD" ).append("\n"); 
		query.append(" ORDER BY DTL.VSL_CD" ).append("\n"); 
		query.append("     , DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("     , DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("     , DTL.REV_DIR_CD" ).append("\n"); 
		query.append("     , DTL.REV_YRMON   " ).append("\n"); 
		query.append("     , ITM.ORD_SEQ" ).append("\n"); 

	}
}
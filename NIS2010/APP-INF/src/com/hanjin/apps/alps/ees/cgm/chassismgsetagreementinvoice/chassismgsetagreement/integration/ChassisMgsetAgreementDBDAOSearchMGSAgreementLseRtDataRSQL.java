/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementLseRtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.10.01 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchMGSAgreementLseRtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchMGSAgreementLseRtData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchMGSAgreementLseRtDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchMGSAgreementLseRtDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(ONH_INIT_VAL_AMT_CLG),0) AS ONH_INIT_VAL_AMT_CLG," ).append("\n"); 
		query.append("NVL(SUM(ONH_INIT_VAL_AMT_UMG),0) AS ONH_INIT_VAL_AMT_UMG," ).append("\n"); 
		query.append("NVL(SUM(MGST_LSE_FX_RT_AMT_CLG),0) AS MGST_LSE_FX_RT_AMT_CLG," ).append("\n"); 
		query.append("NVL(SUM(MGST_LSE_FX_RT_AMT_UMG),0) AS MGST_LSE_FX_RT_AMT_UMG," ).append("\n"); 
		query.append("NVL(SUM(MGST_BLDP_RT_AMT_CLG),0) AS MGST_BLDP_RT_AMT_CLG," ).append("\n"); 
		query.append("NVL(SUM(MGST_BLDP_RT_AMT_UMG),0) AS MGST_BLDP_RT_AMT_UMG," ).append("\n"); 
		query.append("NVL(SUM(MGST_POTC_SCG_RT_AMT_CLG),0) AS MGST_POTC_SCG_RT_AMT_CLG," ).append("\n"); 
		query.append("NVL(SUM(MGST_POTC_SCG_RT_AMT_UMG),0) AS MGST_POTC_SCG_RT_AMT_UMG," ).append("\n"); 
		query.append("NVL(SUM(MGST_PRTC_SCG_RT_AMT_CLG),0) AS MGST_PRTC_SCG_RT_AMT_CLG," ).append("\n"); 
		query.append("NVL(SUM(MGST_PRTC_SCG_RT_AMT_UMG),0) AS MGST_PRTC_SCG_RT_AMT_UMG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CLG' THEN T1.ONH_INIT_VAL_AMT END AS ONH_INIT_VAL_AMT_CLG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN T1.ONH_INIT_VAL_AMT END AS ONH_INIT_VAL_AMT_UMG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CLG' THEN T1.MGST_LSE_FX_RT_AMT END AS MGST_LSE_FX_RT_AMT_CLG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN T1.MGST_LSE_FX_RT_AMT END AS MGST_LSE_FX_RT_AMT_UMG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CLG' THEN T1.MGST_BLDP_RT_AMT END AS MGST_BLDP_RT_AMT_CLG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN T1.MGST_BLDP_RT_AMT END AS MGST_BLDP_RT_AMT_UMG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CLG' THEN T1.MGST_POTC_SCG_RT_AMT END AS MGST_POTC_SCG_RT_AMT_CLG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN T1.MGST_POTC_SCG_RT_AMT END AS MGST_POTC_SCG_RT_AMT_UMG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CLG' THEN T1.MGST_PRTC_SCG_RT_AMT END AS MGST_PRTC_SCG_RT_AMT_CLG," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN T1.MGST_PRTC_SCG_RT_AMT END AS MGST_PRTC_SCG_RT_AMT_UMG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.ONH_INIT_VAL_AMT," ).append("\n"); 
		query.append("B.MGST_LSE_FX_RT_AMT," ).append("\n"); 
		query.append("B.MGST_BLDP_RT_AMT," ).append("\n"); 
		query.append("B.MGST_POTC_SCG_RT_AMT," ).append("\n"); 
		query.append("B.MGST_PRTC_SCG_RT_AMT" ).append("\n"); 
		query.append("FROM    CGM_AGREEMENT A, CGM_AGMT_LSE_RT B" ).append("\n"); 
		query.append("WHERE   A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
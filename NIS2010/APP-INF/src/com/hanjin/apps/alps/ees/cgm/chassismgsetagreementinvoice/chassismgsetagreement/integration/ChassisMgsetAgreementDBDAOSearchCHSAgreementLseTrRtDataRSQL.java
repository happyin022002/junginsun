/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementLseTrRtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.10.13 김창식
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

public class ChassisMgsetAgreementDBDAOSearchCHSAgreementLseTrRtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchCHSAgreementLseTrRtData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSAgreementLseTrRtDataRSQL(){
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
		params.put("eq_rntl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementLseTrRtDataRSQL").append("\n"); 
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
		query.append("#if (${eq_rntl_tp_cd} == 'F')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SF2),0) AS EQ_TPSZ_CD_SF2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SL2),0) AS EQ_TPSZ_CD_SL2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_TA2),0) AS EQ_TPSZ_CD_TA2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SF4),0) AS EQ_TPSZ_CD_SF4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_GN4),0) AS EQ_TPSZ_CD_GN4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_CB4),0) AS EQ_TPSZ_CD_CB4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_EG5),0) AS EQ_TPSZ_CD_EG5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_EG8),0) AS EQ_TPSZ_CD_EG8," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_GN5),0) AS EQ_TPSZ_CD_GN5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_ZT4),0) AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'SF2' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_SF2," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'SL2' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_SL2," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'TA2' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_TA2," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'SF4' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_SF4," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'GN4' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_GN4," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CB4' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_CB4," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_EG5," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'EG8' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_EG8," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'GN5' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_GN5," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'ZT4' THEN T1.CHSS_LSE_RT_AMT END AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.CHSS_LSE_RT_AMT" ).append("\n"); 
		query.append("FROM    CGM_AGREEMENT A, CGM_AGMT_LSE_RT B" ).append("\n"); 
		query.append("WHERE   A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("AND A.EQ_RNTL_TP_CD = @[eq_rntl_tp_cd]" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RNTL_FM_TR_VAL," ).append("\n"); 
		query.append("RNTL_TO_TR_VAL," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SF2),0) AS EQ_TPSZ_CD_SF2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SL2),0) AS EQ_TPSZ_CD_SL2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_TA2),0) AS EQ_TPSZ_CD_TA2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SF4),0) AS EQ_TPSZ_CD_SF4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_GN4),0) AS EQ_TPSZ_CD_GN4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_CB4),0) AS EQ_TPSZ_CD_CB4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_EG5),0) AS EQ_TPSZ_CD_EG5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_EG8),0) AS EQ_TPSZ_CD_EG8," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_GN5),0) AS EQ_TPSZ_CD_GN5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_ZT4),0) AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.RNTL_FM_TR_VAL," ).append("\n"); 
		query.append("T1.RNTL_TO_TR_VAL," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'SF2' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_SF2," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'SL2' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_SL2," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'TA2' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_TA2," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'SF4' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_SF4," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'GN4' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_GN4," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'CB4' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_CB4," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_EG5," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'EG8' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_EG8," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'GN5' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_GN5," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'ZT4' THEN SUM(T1.TR_RT_AMT) END AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.RNTL_FM_TR_VAL," ).append("\n"); 
		query.append("B.RNTL_TO_TR_VAL," ).append("\n"); 
		query.append("B.TR_RT_AMT" ).append("\n"); 
		query.append("FROM    CGM_AGREEMENT A, CGM_AGMT_LSE_TR_RT B" ).append("\n"); 
		query.append("WHERE   A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("AND A.EQ_RNTL_TP_CD = @[eq_rntl_tp_cd]" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append("GROUP BY T1.RNTL_FM_TR_VAL, T1.RNTL_TO_TR_VAL, T1.EQ_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY RNTL_FM_TR_VAL, RNTL_TO_TR_VAL" ).append("\n"); 
		query.append("ORDER BY RNTL_FM_TR_VAL, RNTL_TO_TR_VAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
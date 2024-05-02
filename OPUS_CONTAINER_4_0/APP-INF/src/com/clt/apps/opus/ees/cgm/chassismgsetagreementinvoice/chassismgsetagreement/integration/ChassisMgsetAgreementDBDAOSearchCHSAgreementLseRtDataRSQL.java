/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementLseRtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.19 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSAgreementLseRtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchCHSAgreementLseRtData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSAgreementLseRtDataRSQL(){
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
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSAgreementLseRtDataRSQL").append("\n"); 
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
		query.append("NVL(SUM(EQ_TPSZ_CD1),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD2),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD3),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD4),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD5),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD6),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD7),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD8),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD9),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD10),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD11),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD12),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD13),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD14),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD15),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD16),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD17),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD18),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD19),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD20),0) AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '1' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '2' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '3' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '4' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '5' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '6' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '7' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '8' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '9' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '10' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '11' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '12' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '13' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '14' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '15' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '16' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '17' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '18' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '19' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("CASE WHEN T1.DP_SEQ = '20' THEN T1.ONH_INIT_VAL_AMT END AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  B.EQ_TPSZ_CD, " ).append("\n"); 
		query.append("                B.ONH_INIT_VAL_AMT," ).append("\n"); 
		query.append("				G.DP_SEQ" ).append("\n"); 
		query.append("		FROM    CGM_AGREEMENT A, CGM_AGMT_LSE_RT B ,  " ).append("\n"); 
		query.append("				(SELECT EQ_TPSZ_CD,ROW_NUMBER() OVER (ORDER BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) DP_SEQ " ).append("\n"); 
		query.append("  				   FROM CGM_EQ_TP_SZ WHERE EQ_KND_CD = 'Z' GROUP BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE   A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                AND A.AGMT_VER_NO = B.AGMT_VER_NO " ).append("\n"); 
		query.append("                AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                AND A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                AND A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("				AND A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("				AND B.EQ_TPSZ_CD = G.EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
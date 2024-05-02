/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchTgtVoyVsUnstlStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.18 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchTgtVoyVsUnstlStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Voyage vs Unsettled Status
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchTgtVoyVsUnstlStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchTgtVoyVsUnstlStatusListRSQL").append("\n"); 
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
		query.append("        A.TRD_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.REV_YRMON" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,NVL(SUM(E.R_COA_BSA_AMT),0) AS R_COA_BSA_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(C.R_JOO_CMB_AMT),0) AS R_JOO_CMB_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(D.R_JOO_SLP_AMT),0) AS R_JOO_SLP_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(E.E_COA_BSA_AMT),0) AS E_COA_BSA_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(C.E_JOO_CMB_AMT),0) AS E_JOO_CMB_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(D.E_JOO_SLP_AMT),0) AS E_JOO_SLP_AMT" ).append("\n"); 
		query.append("FROM    JOO_STL_VVD     A" ).append("\n"); 
		query.append("       ,AR_MST_REV_VVD  B" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               C.ACCT_YRMON" ).append("\n"); 
		query.append("              ,C.STL_VVD_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(C.RE_DIVR_CD,'R',C.STL_LOCL_AMT,0)) AS R_JOO_CMB_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(C.RE_DIVR_CD,'E',C.STL_LOCL_AMT,0)) AS E_JOO_CMB_AMT" ).append("\n"); 
		query.append("        FROM  JOO_SETTLEMENT  C" ).append("\n"); 
		query.append("             ,JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("             ,JOO_STL_CMB     E" ).append("\n"); 
		query.append("        WHERE  C.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("		AND    C.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("		AND    C.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("		AND    D.ACCT_YRMON  = E.ACCT_YRMON" ).append("\n"); 
		query.append("		AND    D.JO_CRR_CD   = E.JO_CRR_CD" ).append("\n"); 
		query.append("		AND    D.STL_CMB_SEQ = E.STL_CMB_SEQ" ).append("\n"); 
		query.append("		AND    D.RE_DIVR_CD  = E.RE_DIVR_CD" ).append("\n"); 
		query.append("        AND    C.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    E.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("        AND    C.ACCT_YRMON  BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("        AND    C.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND    C.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("        AND    C.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("        AND    C.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        GROUP  BY" ).append("\n"); 
		query.append("               C.ACCT_YRMON" ).append("\n"); 
		query.append("              ,C.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               A.ACCT_YRMON" ).append("\n"); 
		query.append("              ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(A.RE_DIVR_CD,'R',C.CSR_LOCL_AMT,0)) AS R_JOO_SLP_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(A.RE_DIVR_CD,'E',C.CSR_LOCL_AMT,0)) AS E_JOO_SLP_AMT" ).append("\n"); 
		query.append("        FROM   JOO_STL_CMB_DTL A" ).append("\n"); 
		query.append("              ,JOO_STL_CMB     B" ).append("\n"); 
		query.append("              ,JOO_SLIP        C" ).append("\n"); 
		query.append("              ,JOO_SETTLEMENT  D" ).append("\n"); 
		query.append("        WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("		AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("		AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("		AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("        AND    A.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("        AND    A.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("        AND    A.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("		AND    B.SLP_TP_CD   = C.SLP_TP_CD" ).append("\n"); 
		query.append("		AND    B.SLP_FUNC_CD = C.SLP_FUNC_CD" ).append("\n"); 
		query.append("		AND    B.SLP_OFC_CD  = C.SLP_OFC_CD" ).append("\n"); 
		query.append("		AND    B.SLP_ISS_DT  = C.SLP_ISS_DT" ).append("\n"); 
		query.append("		AND    B.SLP_SER_NO  = C.SLP_SER_NO" ).append("\n"); 
		query.append("        AND    B.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("        AND    A.ACCT_YRMON  BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("        AND    D.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND    D.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("        AND    D.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("        AND    D.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        GROUP  BY" ).append("\n"); 
		query.append("               A.ACCT_YRMON" ).append("\n"); 
		query.append("              ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		        A.COST_YRMON AS ACCT_YRMON" ).append("\n"); 
		query.append("		       ,C.CRR_CD  AS JO_CRR_CD" ).append("\n"); 
		query.append("		       ,A.TRD_CD" ).append("\n"); 
		query.append("		       ,A.RLANE_CD" ).append("\n"); 
		query.append("		       ,A.VSL_CD" ).append("\n"); 
		query.append("		       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("		       ,A.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("               ,'S/H' AS JO_STL_ITM_CD" ).append("\n"); 
		query.append("		       ,SUM(CASE WHEN C.BSA_OP_JB_CD IN ('001','002','004') THEN C.CRR_PERF_AMT ELSE 0 END) AS R_COA_BSA_AMT" ).append("\n"); 
		query.append("		       ,SUM(CASE WHEN C.BSA_OP_JB_CD IN ('000','003','005') THEN C.CRR_PERF_AMT ELSE 0 END) AS E_COA_BSA_AMT" ).append("\n"); 
		query.append("		  FROM COA_MON_VVD      A," ).append("\n"); 
		query.append("		       BSA_VVD_MST      B," ).append("\n"); 
		query.append("		       BSA_VVD_CRR_PERF C" ).append("\n"); 
		query.append("		 WHERE A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("		   AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		   AND A.DIR_CD      = B.SKD_DIR_CD" ).append("\n"); 
		query.append("		   AND A.TRD_CD      = B.TRD_CD" ).append("\n"); 
		query.append("		   AND A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("		   AND A.VSL_CD      = C.VSL_CD" ).append("\n"); 
		query.append("		   AND A.SKD_VOY_NO  = C.SKD_VOY_NO" ).append("\n"); 
		query.append("		   AND A.DIR_CD      = C.SKD_DIR_CD" ).append("\n"); 
		query.append("		   AND A.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("		   AND A.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("		   AND A.COST_YRMON BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("		   AND C.BSA_OP_JB_CD IN ('000','001','002','003','004','005')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("           AND A.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND    A.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("        AND    C.CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("        AND    'S/H'         = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("		   AND C.CRR_CD      <> COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("		   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("		 GROUP BY" ).append("\n"); 
		query.append("		        A.COST_YRMON" ).append("\n"); 
		query.append("		       ,C.CRR_CD" ).append("\n"); 
		query.append("		       ,A.TRD_CD" ).append("\n"); 
		query.append("		       ,A.RLANE_CD" ).append("\n"); 
		query.append("		       ,A.VSL_CD" ).append("\n"); 
		query.append("		       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("		       ,A.DIR_CD" ).append("\n"); 
		query.append("		HAVING SUM(C.CRR_BSA_CAPA) <> 0" ).append("\n"); 
		query.append("		AND    SUM(C.CRR_PERF_AMT) <> 0" ).append("\n"); 
		query.append("      ) E" ).append("\n"); 
		query.append("WHERE  A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = C.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = C.STL_VVD_SEQ  (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = D.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = D.STL_VVD_SEQ  (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = E.ACCT_YRMON   (+)" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = E.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("AND    A.TRD_CD        = E.TRD_CD       (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = E.RLANE_CD     (+)" ).append("\n"); 
		query.append("AND    A.VSL_CD        = E.VSL_CD       (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = E.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = E.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = E.RLANE_CD     (+)" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = E.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON BETWEEN REPLACE(@[acct_yrmon_fr],'-','') AND REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("GROUP  BY" ).append("\n"); 
		query.append("        A.TRD_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.REV_YRMON" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 

	}
}
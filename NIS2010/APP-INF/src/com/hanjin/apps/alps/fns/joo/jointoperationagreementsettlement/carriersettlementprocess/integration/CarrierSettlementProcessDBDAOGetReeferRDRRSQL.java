/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetReeferRDRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetReeferRDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reefer의 Data를 가져온다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetReeferRDRRSQL(){
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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetReeferRDRRSQL").append("\n"); 
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
		query.append("WITH CRR AS (" ).append("\n"); 
		query.append("SELECT B.JO_CRR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd]) AS JO_CRR_CD, TO_DATE('99991231','YYYYMMDD') AS EFF_ETA_DT" ).append("\n"); 
		query.append("       FROM   DUAL" ).append("\n"); 
		query.append("       UNION  ALL" ).append("\n"); 
		query.append("       SELECT JO_N2ND_CRR_CD AS JO_CRR_CD, EFF_ETA_DT" ).append("\n"); 
		query.append("       FROM   JOO_CRR_MRG A" ).append("\n"); 
		query.append("       WHERE  A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("       AND    A.ACCTG_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("       AND    A.JO_N1ST_CRR_CD = DECODE(@[re_divr_cd], 'E', 'SML', @[jo_crr_cd])" ).append("\n"); 
		query.append("       AND    A.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("       AND    A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.BZC_PORT_ETA_DT <= B.EFF_ETA_DT" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND    A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       O.RF_20_QTY AS USD_SLT_BSA_QTY_20" ).append("\n"); 
		query.append("     , O.RF_40_QTY AS USD_SLT_BSA_QTY_40" ).append("\n"); 
		query.append("     , P.RF_20_PRC AS RF_SCG_PRC_20" ).append("\n"); 
		query.append("     , P.RF_40_PRC AS RF_SCG_PRC_40" ).append("\n"); 
		query.append("  FROM JOO_STL_VVD J" ).append("\n"); 
		query.append("     , (       " ).append("\n"); 
		query.append("       /* 1. Externally Main Trade (Ocean) */" ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("              'O' OI, M.VSL_CD, M.VOY_NO, M.DIR_CD, M.POL, M.POD_ISO AS POD, H.REGION AS RGN," ).append("\n"); 
		query.append("              SUM(DECODE(M.CNTR_SIZE,'2',1,'3',1,0))       RF_20_QTY," ).append("\n"); 
		query.append("              SUM(DECODE(M.CNTR_SIZE,'4',1,'H',1,'L',1,0)) RF_40_QTY             " ).append("\n"); 
		query.append("        FROM  RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("       WHERE  1 = 1" ).append("\n"); 
		query.append("         AND  M.POL     = @[fm_port_cd]" ).append("\n"); 
		query.append("         AND  M.POD_ISO = @[to_port_cd]" ).append("\n"); 
		query.append("         AND  H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("         AND  H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("         AND  H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("         AND  H.REGION  = M.REGION" ).append("\n"); 
		query.append("         AND  M.TEMP    IS NOT NULL" ).append("\n"); 
		query.append("         AND  M.CARGO_TYPE <> 'IR'" ).append("\n"); 
		query.append("         AND (M.OPR_CD, M.VSL_CD, M.VOY_NO, M.DIR_CD) IN " ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("              SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("              FROM   CRR" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("      GROUP BY M.VSL_CD, M.VOY_NO, M.DIR_CD, M.POL, M.POD_ISO, H.REGION" ).append("\n"); 
		query.append("       /* 2. Internally Main Trade (Ocean) */" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("             'O' OI, S.VSL_CD, S.VOY_NO, S.DIR_CD, S.POL, S.POD_ISO AS POD, S.REGION AS RGN," ).append("\n"); 
		query.append("             SUM(DECODE(S.CNTR_SIZE,'2',QTY,0)) RF_20_QTY," ).append("\n"); 
		query.append("             SUM(DECODE(S.CNTR_SIZE,'4',QTY,0)) RF_40_QTY" ).append("\n"); 
		query.append("      FROM   RDR_HEADER H, RDR_SUMMARY S" ).append("\n"); 
		query.append("      WHERE  H.VSL_CD     = S.VSL_CD" ).append("\n"); 
		query.append("      AND    H.VOY_NO     = S.VOY_NO" ).append("\n"); 
		query.append("      AND    H.DIR_CD     = S.DIR_CD" ).append("\n"); 
		query.append("      AND    H.REGION     = S.REGION" ).append("\n"); 
		query.append("      AND    S.CNTR_TYPE  = 'T'" ).append("\n"); 
		query.append("      AND   (S.OPR_CD, S.VSL_CD, S.VOY_NO, S.DIR_CD) IN " ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("              SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("              FROM   CRR" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("      GROUP BY S.VSL_CD, S.VOY_NO, S.DIR_CD, S.POL, S.POD_ISO, S.REGION" ).append("\n"); 
		query.append("       /* 3. Externally Inter Port */" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT 'I' OI, M.VSL_CD, M.VOY_NO, M.DIR_CD, M.POL, M.POD_ISO AS POD, H.REGION AS RGN," ).append("\n"); 
		query.append("             SUM(DECODE(M.CNTR_SIZE,'2',1,'3',1,0))       RF_20_QTY," ).append("\n"); 
		query.append("             SUM(DECODE(M.CNTR_SIZE,'4',1,'H',1,'L',1,0)) RF_40_QTY" ).append("\n"); 
		query.append("        FROM RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("       WHERE 1 = 1 " ).append("\n"); 
		query.append("         AND M.POL     = @[fm_port_cd]" ).append("\n"); 
		query.append("         AND M.POD_ISO = @[to_port_cd]" ).append("\n"); 
		query.append("         AND H.VSL_CD  = M.VSL_CD " ).append("\n"); 
		query.append("         AND H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("         AND H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("         AND H.REGION  = M.REGION" ).append("\n"); 
		query.append("         AND M.CARGO_TYPE = 'IR'" ).append("\n"); 
		query.append("         AND (M.OPR_CD, M.VSL_CD, M.VOY_NO, M.DIR_CD) IN " ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("              SELECT JO_CRR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("              FROM   CRR" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       GROUP BY M.VSL_CD, M.VOY_NO, M.DIR_CD, M.POL, M.POD_ISO, H.REGION" ).append("\n"); 
		query.append("       )O    " ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("       SELECT  M.TRD_CD, M.RLANE_CD, M.DIR_CD, M.BSA_SLT_PRC_FM_DT, M.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("             , SUM(DECODE(M.RT_TEU_FLG, 'A', D.UC_AMT, 'T', D.UC_AMT, 0)) RF_20_PRC" ).append("\n"); 
		query.append("             , SUM(DECODE(M.RT_TEU_FLG, 'A', D.UC_AMT, 'F', D.UC_AMT, 0)) RF_40_PRC" ).append("\n"); 
		query.append("         FROM  BSA_RF_SCG_MST M" ).append("\n"); 
		query.append("             , BSA_RF_SCG_SLT_PRC D" ).append("\n"); 
		query.append("        WHERE M.BSA_SLT_COST_TP_CD = D.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("          AND M.RF_SCG_SLT_PRC_SEQ = D.RF_SCG_SLT_PRC_SEQ" ).append("\n"); 
		query.append("          AND M.TRD_CD             = D.TRD_CD" ).append("\n"); 
		query.append("          AND M.RLANE_CD           = D.RLANE_CD" ).append("\n"); 
		query.append("          AND M.DIR_CD             = D.DIR_CD" ).append("\n"); 
		query.append("          AND M.BSA_SLT_COST_TP_CD = DECODE(@[ioc_cd],'O','018','I','019')" ).append("\n"); 
		query.append("          AND M.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("          AND D.TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("          AND D.RLANE_CD           = @[rlane_cd]" ).append("\n"); 
		query.append("          AND D.DIR_CD             = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND D.CRR_CD             = @[jo_crr_cd]" ).append("\n"); 
		query.append("        GROUP BY M.TRD_CD, M.RLANE_CD, M.DIR_CD, M.BSA_SLT_PRC_FM_DT, M.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("       )P      " ).append("\n"); 
		query.append(" WHERE J.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("   AND J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("   AND J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("   AND J.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("   AND J.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND J.SKD_DIR_CD    = @[skd_dir_cd]	  " ).append("\n"); 
		query.append("   AND J.UC_BSS_PORT_CD= @[fm_port_cd]                        " ).append("\n"); 
		query.append("   AND J.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("   AND J.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("   AND J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("   AND J.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("   AND O.OI(+)         = @[ioc_cd]" ).append("\n"); 
		query.append("   AND O.RGN(+)        = @[sconti_cd]" ).append("\n"); 
		query.append("   AND J.VSL_CD        = O.VSL_CD(+)" ).append("\n"); 
		query.append("   AND J.SKD_VOY_NO    = O.VOY_NO(+)" ).append("\n"); 
		query.append("   AND J.SKD_DIR_CD    = O.DIR_CD(+)" ).append("\n"); 
		query.append("   AND J.TRD_CD        = P.TRD_CD(+)" ).append("\n"); 
		query.append("   AND J.RLANE_CD      = P.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND J.SKD_DIR_CD    = P.DIR_CD(+)" ).append("\n"); 
		query.append("   AND J.UC_BSS_PORT_ETD_DT BETWEEN TO_DATE(P.BSA_SLT_PRC_FM_DT(+),'YYYYMMDDHH24MISS') AND TO_DATE(P.BSA_SLT_PRC_TO_DT(+),'YYYYMMDDHH24MISS')" ).append("\n"); 

	}
}
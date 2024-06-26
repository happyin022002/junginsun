/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOSearchAddStlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.12.02 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOSearchAddStlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement Target Create 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOSearchAddStlRSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSearchAddStlRSQL").append("\n"); 
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
		query.append("      'R' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.STL_SEQ" ).append("\n"); 
		query.append("      ,A.TRD_CD" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("      ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,A.JO_MNU_NM" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.REV_DIR_CD" ).append("\n"); 
		query.append("      ,A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') ETA_DT" ).append("\n"); 
		query.append("      ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,A.BSA_QTY" ).append("\n"); 
		query.append("      ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.STL_USD_AMT" ).append("\n"); 
		query.append("      ,A.IOC_CD" ).append("\n"); 
		query.append("      ,A.SCONTI_CD" ).append("\n"); 
		query.append("      ,A.FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("      ,A.FNL_BSA_WGT" ).append("\n"); 
		query.append("      ,A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("      ,A.USD_SLT_WGT" ).append("\n"); 
		query.append("      ,A.BSA_PER_WGT" ).append("\n"); 
		query.append("      ,A.FM_PORT_CD" ).append("\n"); 
		query.append("      ,A.TO_PORT_CD" ).append("\n"); 
		query.append("      ,A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("      ,A.RF_SCG_PRC" ).append("\n"); 
		query.append("      ,A.STL_RMK" ).append("\n"); 
		query.append("      ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("      ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("      ,A.STL_TJ_NO" ).append("\n"); 
		query.append("      ,A.STL_ADJ_FLG" ).append("\n"); 
		query.append("      ,A.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.PRE_STL_SEQ" ).append("\n"); 
		query.append("      ,A.STL_LST_FLG" ).append("\n"); 
		query.append("      ,A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("      ,B.SLIP_NO" ).append("\n"); 
		query.append("      , CASE WHEN NVL(C.REV_YRMON,'null') = 'null' THEN 'Y' ELSE 'N' END AS CXL_VVD_FLG" ).append("\n"); 
		query.append("      , NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
		query.append("      ,NULL AS REV_YRMON" ).append("\n"); 
		query.append("      ,NULL AS REV_YRMON_SEQ" ).append("\n"); 
		query.append("      ,NULL AS REV_SEQ  " ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             B.ACCT_YRMON" ).append("\n"); 
		query.append("            ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("            ,B.STL_SEQ" ).append("\n"); 
		query.append("            ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("            ,A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS SLIP_NO" ).append("\n"); 
		query.append("            ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("            ,A.RJCT_CMB_FLG" ).append("\n"); 
		query.append("      FROM   JOO_STL_CMB     A," ).append("\n"); 
		query.append("             JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("      WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("      AND    A.JO_CRR_CD   = B.JO_CRR_CD" ).append("\n"); 
		query.append("      AND    A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("      AND    A.RE_DIVR_CD  = B.RE_DIVR_CD" ).append("\n"); 
		query.append("      AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("	  #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("      AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	  #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("      AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("      -- 2010.03.23 REVERSE 된 것은 copy를 하므로 기존 reverse data는 combined no를 보여주도록 한다. (삭제불가)" ).append("\n"); 
		query.append("      --AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("      --AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("      ) B," ).append("\n"); 
		query.append("       AR_MST_REV_VVD C" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.VSL_CD        = C.VSL_CD     (+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = C.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = C.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = C.RLANE_CD   (+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND	  A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND	  A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND	  A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND	  A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_mnu_nm} != '')" ).append("\n"); 
		query.append("AND   A.JO_MNU_NM     = @[jo_mnu_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--2010.04.14 누락된 조회조건 추가 => Settlement단에는 Adjust내역을 보여주지 않는다." ).append("\n"); 
		query.append("AND    NVL(A.STL_ADJ_FLG,'N') = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'I' AS IBFLAG" ).append("\n"); 
		query.append("       ,A.ACCT_YRMON" ).append("\n"); 
		query.append("       ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,A.STL_SEQ" ).append("\n"); 
		query.append("       ,A.TRD_CD" ).append("\n"); 
		query.append("       ,A.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("       ,A.RLANE_CD" ).append("\n"); 
		query.append("       ,A.RE_DIVR_CD			" ).append("\n"); 
		query.append("       ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ,'M/S'    AS JO_MNU_NM	" ).append("\n"); 
		query.append("       ,A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.REV_DIR_CD			" ).append("\n"); 
		query.append("       ,A.VPS_PORT_CD   AS STL_BZC_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MISS') ETA_DT    -- BZC_PORT_ETA_DT" ).append("\n"); 
		query.append("       ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("       ,A.FNL_BSA_QTY" ).append("\n"); 
		query.append("       ,A.FNL_BSA_SLT_PRC" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                 c1.locl_curr_cd" ).append("\n"); 
		query.append("            FROM joo_carrier  a1," ).append("\n"); 
		query.append("                 joo_crr_auth b1," ).append("\n"); 
		query.append("                 joo_finc_mtx c1" ).append("\n"); 
		query.append("            WHERE a1.delt_flg = 'N'" ).append("\n"); 
		query.append("            and   b1.delt_flg = 'N'" ).append("\n"); 
		query.append("            and   a1.jo_crr_cd = b1.jo_crr_cd" ).append("\n"); 
		query.append("            and   a1.rlane_cd  = b1.rlane_cd" ).append("\n"); 
		query.append("            and   b1.auth_ofc_cd = @[auth_ofc_cd]" ).append("\n"); 
		query.append("            and   a1.jo_crr_cd = c1.jo_crr_cd(+)" ).append("\n"); 
		query.append("            and   a1.rlane_cd  = c1.rlane_cd (+)" ).append("\n"); 
		query.append("            and   c1.re_divr_cd(+)    = A.RE_DIVR_CD" ).append("\n"); 
		query.append("            and   c1.jo_stl_itm_cd(+) = A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("            AND	  a1.jo_crr_cd = A.CRR_CD" ).append("\n"); 
		query.append("            AND	  a1.trd_cd    = A.TRD_CD" ).append("\n"); 
		query.append("            AND   a1.rlane_cd  = A.RLANE_CD" ).append("\n"); 
		query.append("            AND   ROWNUM = 1" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       ,NULL AS ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("       ,NULL AS ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("       ,DECODE(A.STL_LOCL_AMT,0,A.FNL_BSA_QTY*A.FNL_BSA_SLT_PRC,A.STL_LOCL_AMT) AS STL_LOCL_AMT" ).append("\n"); 
		query.append("       ,NULL AS STL_USD_AMT" ).append("\n"); 
		query.append("       ,NULL AS IOC_CD" ).append("\n"); 
		query.append("       ,NULL AS SCONTI_CD" ).append("\n"); 
		query.append("       ,NULL AS FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("       ,NULL AS FNL_BSA_WGT" ).append("\n"); 
		query.append("       ,NULL AS USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("       ,NULL AS USD_SLT_WGT" ).append("\n"); 
		query.append("       ,NULL AS BSA_PER_WGT" ).append("\n"); 
		query.append("       ,NULL AS FM_PORT_CD" ).append("\n"); 
		query.append("       ,NULL AS TO_PORT_CD" ).append("\n"); 
		query.append("       ,NULL AS RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("       ,NULL AS RF_SCG_PRC" ).append("\n"); 
		query.append("       ,A.STL_RMK" ).append("\n"); 
		query.append("       ,NULL AS CMB_CFM_FLG" ).append("\n"); 
		query.append("       ,NULL AS STL_CMB_SEQ" ).append("\n"); 
		query.append("       ,NULL AS STL_TJ_NO" ).append("\n"); 
		query.append("       ,'N'  AS STL_ADJ_FLG" ).append("\n"); 
		query.append("       ,NULL AS PRE_ACCT_YRMON" ).append("\n"); 
		query.append("       ,NULL AS PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("       ,NULL AS PRE_STL_SEQ" ).append("\n"); 
		query.append("       ,'Y'  AS STL_LST_FLG" ).append("\n"); 
		query.append("       ,A.VPS_PORT_CD           AS UC_BSS_PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("       ,'' AS SLIP_NO" ).append("\n"); 
		query.append("       ,CASE WHEN NVL(A.REV_YRMON,'null') = 'null' THEN 'Y' ELSE 'N' END AS CXL_VVD_FLG" ).append("\n"); 
		query.append("       ,'N' AS RVS_CMB_FLG" ).append("\n"); 
		query.append("       ,A.REV_YRMON" ).append("\n"); 
		query.append("       ,A.REV_YRMON_SEQ" ).append("\n"); 
		query.append("       ,A.REV_SEQ   " ).append("\n"); 
		query.append("FROM JOO_STL_TGT A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.STL_TGT_FLG = '1'" ).append("\n"); 
		query.append("AND   A.STL_CLZ_FLG = '0'" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND	  A.CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND	  A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND	  A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND	  A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '')" ).append("\n"); 
		query.append("AND	  A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.JO_STL_ITM_CD,'N',A.ACCT_YRMON) NOT IN (" ).append("\n"); 
		query.append("        SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.REV_DIR_CD, X.JO_STL_ITM_CD,NVL(Y.RVS_CMB_FLG,'N') AS RVS_CMB_FLG, X.ACCT_YRMON " ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT Y.ACCT_YRMON, Y.STL_VVD_SEQ, Y.STL_SEQ, Z.RVS_CMB_FLG, NVL(Z.STL_CMB_SEQ,0) AS STL_CMB_SEQ" ).append("\n"); 
		query.append("               FROM   JOO_STL_CMB_DTL Y," ).append("\n"); 
		query.append("                      JOO_STL_CMB     Z" ).append("\n"); 
		query.append("               WHERE  Y.ACCT_YRMON = Z.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    Y.JO_CRR_CD  = Z.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    Y.STL_CMB_SEQ= Z.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    Y.RE_DIVR_CD = Z.RE_DIVR_CD" ).append("\n"); 
		query.append("               ) Y" ).append("\n"); 
		query.append("        WHERE  Y.STL_CMB_SEQ > 0 " ).append("\n"); 
		query.append("		AND    X.ACCT_YRMON     = Y.ACCT_YRMON  (+)" ).append("\n"); 
		query.append("        AND    X.STL_VVD_SEQ    = Y.STL_VVD_SEQ (+)" ).append("\n"); 
		query.append("        AND    X.STL_SEQ        = Y.STL_SEQ     (+) " ).append("\n"); 
		query.append("	    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("  	    #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("  	    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("  	    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("        SELECT X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.REV_DIR_CD, X.JO_STL_ITM_CD,NVL(Y.RVS_CMB_FLG,'N') AS RVS_CMB_FLG, X.ACCT_YRMON " ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  X," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               SELECT Y.ACCT_YRMON, Y.STL_VVD_SEQ, Y.STL_SEQ, Z.RVS_CMB_FLG, NVL(Z.STL_CMB_SEQ,0) AS STL_CMB_SEQ" ).append("\n"); 
		query.append("               FROM   JOO_STL_CMB_DTL Y," ).append("\n"); 
		query.append("                      JOO_STL_CMB     Z" ).append("\n"); 
		query.append("               WHERE  Y.ACCT_YRMON = Z.ACCT_YRMON" ).append("\n"); 
		query.append("               AND    Y.JO_CRR_CD  = Z.JO_CRR_CD" ).append("\n"); 
		query.append("               AND    Y.STL_CMB_SEQ= Z.STL_CMB_SEQ" ).append("\n"); 
		query.append("               AND    Y.RE_DIVR_CD = Z.RE_DIVR_CD" ).append("\n"); 
		query.append("               ) Y" ).append("\n"); 
		query.append("        WHERE  (X.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','') AND Y.STL_CMB_SEQ IS NULL)" ).append("\n"); 
		query.append("		AND    X.ACCT_YRMON     = Y.ACCT_YRMON  (+)" ).append("\n"); 
		query.append("        AND    X.STL_VVD_SEQ    = Y.STL_VVD_SEQ (+)" ).append("\n"); 
		query.append("        AND    X.STL_SEQ        = Y.STL_SEQ     (+) " ).append("\n"); 
		query.append("	    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("        AND    X.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("  	    #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("        AND    X.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("  	    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("        AND    X.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("  	    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND    X.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY 1 DESC, SKD_DIR_CD, VSL_CD, SKD_VOY_NO, REV_DIR_CD" ).append("\n"); 

	}
}
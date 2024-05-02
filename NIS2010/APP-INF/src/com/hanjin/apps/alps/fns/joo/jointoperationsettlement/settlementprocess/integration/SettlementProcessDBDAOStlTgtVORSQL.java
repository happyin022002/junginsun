/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOStlTgtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.09.07 민정호
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

public class SettlementProcessDBDAOStlTgtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/H, OUS(RDR,TDR) 대상 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOStlTgtVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOStlTgtVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        A.ACCT_YRMON" ).append("\n"); 
		query.append("      , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("      , A.STL_SEQ" ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , A.JO_CRR_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.RE_DIVR_CD" ).append("\n"); 
		query.append("      , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      , A.JO_MNU_NM" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.SKD_DIR_CD" ).append("\n"); 
		query.append("      , A.REV_DIR_CD" ).append("\n"); 
		query.append("      , A.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("      , TO_CHAR(A.ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("      , A.JO_STL_JB_CD" ).append("\n"); 
		query.append("      , A.BSA_QTY" ).append("\n"); 
		query.append("      , A.BSA_SLT_PRC" ).append("\n"); 
		query.append("      , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      , A.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("      , A.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("      , A.STL_LOCL_AMT" ).append("\n"); 
		query.append("      , A.STL_USD_AMT" ).append("\n"); 
		query.append("      , A.IOC_CD" ).append("\n"); 
		query.append("      , A.SCONTI_CD" ).append("\n"); 
		query.append("      , A.FNL_HJS_BSA_QTY" ).append("\n"); 
		query.append("      , A.FNL_BSA_WGT" ).append("\n"); 
		query.append("      , A.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("      , A.USD_SLT_WGT" ).append("\n"); 
		query.append("      , A.BSA_PER_WGT" ).append("\n"); 
		query.append("      , A.FM_PORT_CD" ).append("\n"); 
		query.append("      , A.TO_PORT_CD" ).append("\n"); 
		query.append("      , A.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("      , A.RF_SCG_PRC" ).append("\n"); 
		query.append("      , A.STL_RMK" ).append("\n"); 
		query.append("      , A.CMB_CFM_FLG" ).append("\n"); 
		query.append("      , A.STL_TJ_NO" ).append("\n"); 
		query.append("      , A.STL_ADJ_FLG" ).append("\n"); 
		query.append("      , A.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("      , A.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("      , A.PRE_STL_SEQ" ).append("\n"); 
		query.append("      , A.STL_LST_FLG" ).append("\n"); 
		query.append("      , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("      , TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("      , B.STL_CMB_SEQ" ).append("\n"); 
		query.append("      , B.SLIP_NO" ).append("\n"); 
		query.append("      --DUP이 있는지 여부(row별)" ).append("\n"); 
		query.append("      , A.STL_DUP_FLG" ).append("\n"); 
		query.append("      --DUP이 있는지 여부(전체)" ).append("\n"); 
		query.append("      , '' AS DUP_FLG" ).append("\n"); 
		query.append("      , TO_CHAR(A.CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("      , A.CRE_USR_ID" ).append("\n"); 
		query.append("      , TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID" ).append("\n"); 
		query.append("      -- OTH에서 취소된 VVD인 경우 0053 pop-up을 띄우기 위함..." ).append("\n"); 
		query.append("      , CASE WHEN NVL(C.REV_YRMON,'null') = 'null' THEN 'Y' ELSE 'N' END AS CXL_VVD_FLG" ).append("\n"); 
		query.append("      , NVL(B.RVS_CMB_FLG,'N') AS RVS_CMB_FLG" ).append("\n"); 
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
		query.append("      #end " ).append("\n"); 
		query.append("	  #if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("      AND    A.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("      -- 2010.01.06 REVERSE 된 것은 COMBINED NO가 보여져서는 안된다 => 삭제가능하게 " ).append("\n"); 
		query.append("      -- 2010.03.23 REVERSE 된 것은 copy를 하므로 기존 reverse data는 combined no를 보여주도록 한다. (삭제불가)" ).append("\n"); 
		query.append("      --AND    A.RVS_CMB_FLG = 'N'" ).append("\n"); 
		query.append("      --AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("      ) B," ).append("\n"); 
		query.append("      AR_MST_REV_VVD C" ).append("\n"); 
		query.append("WHERE A.ACCT_YRMON    = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND   A.VSL_CD        = C.VSL_CD     (+)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO    = C.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD    = C.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND   A.RLANE_CD      = C.RLANE_CD   (+)" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
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
		query.append("--2010.01.05 SETTLEMENT단에서는 ADJUST한 것은 보여줄 필요없음" ).append("\n"); 
		query.append("AND   NVL(A.STL_ADJ_FLG,'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY A.SKD_DIR_CD, A.ETA_DT, A.VSL_CD, A.SKD_VOY_NO, A.REV_DIR_CD, A.STL_SEQ" ).append("\n"); 

	}
}
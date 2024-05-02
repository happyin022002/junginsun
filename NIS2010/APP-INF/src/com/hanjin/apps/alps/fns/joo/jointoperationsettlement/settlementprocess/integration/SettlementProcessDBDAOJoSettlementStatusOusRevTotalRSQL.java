/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SettlementProcessDBDAOJoSettlementStatusOusRevTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOJoSettlementStatusOusRevTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미정산 VVD 조회
	  * </pre>
	  */
	public SettlementProcessDBDAOJoSettlementStatusOusRevTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoSettlementStatusOusRevTotalRSQL").append("\n"); 
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
		query.append("WITH BAY_PLN_LIST AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("		 MIN(T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD || TO_CHAR(T1.VPS_ETD_DT,'YYYYMMDDHH24MI')) OVER (PARTITION BY T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD) AS VVD_ETD_GROUP	" ).append("\n"); 
		query.append("		,T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		,T1.VPS_PORT_CD" ).append("\n"); 
		query.append("		,T1.CLPT_IND_SEQ      " ).append("\n"); 
		query.append("		,T1.VPS_ETD_DT    " ).append("\n"); 
		query.append("		,T1.CNTR_SUBST_FLG      AS SUB_CHK" ).append("\n"); 
		query.append("		,T1.VSL_CD" ).append("\n"); 
		query.append("		,T1.SKD_VOY_NO " ).append("\n"); 
		query.append("		,T1.SKD_DIR_CD " ).append("\n"); 
		query.append("		,'IST' AS SOURCE" ).append("\n"); 
		query.append("		,T1.RLANE_CD" ).append("\n"); 
		query.append("		,T1.TRD_CD" ).append("\n"); 
		query.append("		,T1.YD_CD" ).append("\n"); 
		query.append("		,T1.SLAN_CD" ).append("\n"); 
		query.append("		,T1.RE_DIVR_CD " ).append("\n"); 
		query.append("		,T1.REV_DIR_CD " ).append("\n"); 
		query.append("		,T1.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("		,T1.CRR_CD " ).append("\n"); 
		query.append("    FROM JOO_BAY_PLN T1" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("	AND T1.VPS_ETD_DT BETWEEN TO_DATE('201510','YYYYMM') AND ADD_MONTHS(TO_DATE(REPLACE(@[rev_yrmon],'-',''),'YYYYMM'),1)" ).append("\n"); 
		query.append("	#if (${trd_cd}!= '')" ).append("\n"); 
		query.append("		   AND   T1.TRD_CD        =  @[trd_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${rlane_cd}!= '')" ).append("\n"); 
		query.append("		   AND   T1.RLANE_CD      =  @[rlane_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${jo_crr_cd}!= '')" ).append("\n"); 
		query.append("		   AND   T1.CRR_CD     =  @[jo_crr_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${re_divr_cd}!= '')" ).append("\n"); 
		query.append("		   AND   T1.RE_DIVR_CD    =  @[re_divr_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("		   AND   T1.SKD_DIR_CD    =  @[skd_dir_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd}!= '')" ).append("\n"); 
		query.append("		   AND   T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD like @[vvd_cd]||'%'" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("    AND T1.JO_REP_CRR_FLG = 'N'      " ).append("\n"); 
		query.append("    AND T1.RF_SCG_STL_TP_CD = 'T'" ).append("\n"); 
		query.append("    AND T1.RE_DIVR_CD = 'R'" ).append("\n"); 
		query.append("), BAY_PLN_LIST_SUM AS (   " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("		 VVD_ETD_GROUP	" ).append("\n"); 
		query.append("		,VVD" ).append("\n"); 
		query.append("		,VPS_PORT_CD" ).append("\n"); 
		query.append("		,CLPT_IND_SEQ      " ).append("\n"); 
		query.append("		,TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MISS') AS VPS_ETD_DT " ).append("\n"); 
		query.append("		,SUB_CHK" ).append("\n"); 
		query.append("		,VSL_CD" ).append("\n"); 
		query.append("		,SKD_VOY_NO " ).append("\n"); 
		query.append("		,SKD_DIR_CD " ).append("\n"); 
		query.append("		,'IST' AS SOURCE" ).append("\n"); 
		query.append("		,RLANE_CD" ).append("\n"); 
		query.append("		,TRD_CD" ).append("\n"); 
		query.append("		,YD_CD" ).append("\n"); 
		query.append("		,SLAN_CD" ).append("\n"); 
		query.append("		,RE_DIVR_CD " ).append("\n"); 
		query.append("		,REV_DIR_CD " ).append("\n"); 
		query.append("		,RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("        ,CRR_CD" ).append("\n"); 
		query.append("    FROM BAY_PLN_LIST" ).append("\n"); 
		query.append("    GROUP BY " ).append("\n"); 
		query.append("         VVD_ETD_GROUP	" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,VPS_PORT_CD" ).append("\n"); 
		query.append("        ,CLPT_IND_SEQ      " ).append("\n"); 
		query.append("        ,VPS_ETD_DT    " ).append("\n"); 
		query.append("        ,SUB_CHK" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO " ).append("\n"); 
		query.append("        ,SKD_DIR_CD     " ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("		,YD_CD" ).append("\n"); 
		query.append(" 	    ,SLAN_CD" ).append("\n"); 
		query.append("        ,RE_DIVR_CD " ).append("\n"); 
		query.append("        ,REV_DIR_CD " ).append("\n"); 
		query.append("        ,RF_SCG_STL_TP_CD   " ).append("\n"); 
		query.append("        ,CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    CEIL(COUNT(1)/TO_NUMBER(@[pagerows])) AS TOT_PAGE_CNT    " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         B.*" ).append("\n"); 
		query.append("		,NVL(J.STL_TGT_FLG,'0') AS STL_TGT_FLG" ).append("\n"); 
		query.append("		,NVL(J.STL_CLZ_FLG,'0') AS STL_CLZ_FLG" ).append("\n"); 
		query.append("    FROM BAY_PLN_LIST_SUM B, JOO_LODG_TGT J" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("--	AND B.CRR_CD != 'SML'" ).append("\n"); 
		query.append("    AND B.VSL_CD        = J.VSL_CD(+)" ).append("\n"); 
		query.append("    AND B.SKD_VOY_NO    = J.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND B.SKD_DIR_CD    = J.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND B.VPS_PORT_CD   = J.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("	AND B.CRR_CD        = J.CRR_CD(+)" ).append("\n"); 
		query.append("    AND B.RLANE_CD      = J.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND B.TRD_CD        = J.TRD_CD(+)" ).append("\n"); 
		query.append("    AND J.RF_SCG_STL_TP_CD (+)    = 'T'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (STL_TGT_FLG = '0' AND STL_CLZ_FLG = '0')" ).append("\n"); 

	}
}
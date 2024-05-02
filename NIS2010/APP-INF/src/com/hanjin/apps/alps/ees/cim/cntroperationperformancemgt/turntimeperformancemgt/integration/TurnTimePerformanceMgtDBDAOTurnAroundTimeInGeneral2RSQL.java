/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneral2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneral2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TurnAroundTimeInGeneral2VO 조회
	  * </pre>
	  */
	public TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneral2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration").append("\n"); 
		query.append("FileName : TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneral2RSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("        /*+ ORDERED USE_NL(D S) INDEX (D XAK1CIM_SHP_TURN_TM_SMRY) */" ).append("\n"); 
		query.append("		D.CNTR_TPSZ_CD	loccode1,								" ).append("\n"); 
		query.append("		D.TRD_CD||'-'||D.TRNK_DIR_CD loccode2,										" ).append("\n"); 
		query.append("		--M.TRNK_DIR_CD boundCode,									" ).append("\n"); 
		query.append("		ROUND(SUM( " ).append("\n"); 
		query.append("			OB_FULL_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			FULL_SEA_TT_DYS	+ " ).append("\n"); 
		query.append("			TS_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			TS_SEA_TT_DYS	+ " ).append("\n"); 
		query.append("			IB_FULL_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			MTY_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			MTY_SEA_TT_DYS " ).append("\n"); 
		query.append("		)/SUM(CNTR_KNT),1)  total,											" ).append("\n"); 
		query.append("		ROUND(SUM(OB_FULL_LAND_TT_DYS)/SUM(CNTR_KNT),1) obFullLandTime,		" ).append("\n"); 
		query.append("		ROUND(SUM(FULL_SEA_TT_DYS)/SUM(CNTR_KNT),1)  fullSeaTime,		" ).append("\n"); 
		query.append("		ROUND(SUM(TS_LAND_TT_DYS)/SUM(CNTR_KNT),1)  tsLandTime,		" ).append("\n"); 
		query.append("		ROUND(SUM(TS_SEA_TT_DYS)/SUM(CNTR_KNT),1)  tsSeaTime,		" ).append("\n"); 
		query.append("		ROUND(SUM(IB_FULL_LAND_TT_DYS)/SUM(CNTR_KNT),1)  ibFullLandTime,		" ).append("\n"); 
		query.append("		ROUND(SUM(MTY_LAND_TT_DYS)/SUM(CNTR_KNT),1)  mtyLandTime,		" ).append("\n"); 
		query.append("		ROUND(SUM(MTY_SEA_TT_DYS)/SUM(CNTR_KNT),1)  mtySeaTime,	" ).append("\n"); 
		query.append("		ROUND(365/(SUM( " ).append("\n"); 
		query.append("			OB_FULL_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			FULL_SEA_TT_DYS	+ " ).append("\n"); 
		query.append("			TS_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			TS_SEA_TT_DYS	+ " ).append("\n"); 
		query.append("			IB_FULL_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			MTY_LAND_TT_DYS	+ " ).append("\n"); 
		query.append("			MTY_SEA_TT_DYS " ).append("\n"); 
		query.append("		    )/	SUM(CNTR_KNT)),1) eq," ).append("\n"); 
		query.append("		SUM(CNTR_KNT) cntrVolume	" ).append("\n"); 
		query.append("FROM	CIM_SHP_TURN_TM_SMRY	D," ).append("\n"); 
		query.append("		CIM_TP_SZ_DP_SEQ		S " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '' && ${subtrade} != 'ALL') " ).append("\n"); 
		query.append("         ,(SELECT DISTINCT M.TRD_CD||SUBSTR(M.RLANE_CD, 1, 3)||M.SUB_TRD_CD AS SUBT" ).append("\n"); 
		query.append("           FROM MDM_DTL_REV_LANE M" ).append("\n"); 
		query.append("          ) M" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period} == 'M') " ).append("\n"); 
		query.append("WHERE	TGT_MVMT_DT	BETWEEN    @[from]	AND @[to]" ).append("\n"); 
		query.append("#elseif (${period} == 'W') " ).append("\n"); 
		query.append("WHERE	TGT_YRWK	BETWEEN    @[from]	AND @[to]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		D.CNTR_TPSZ_CD		=	S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trade} != '') " ).append("\n"); 
		query.append("AND		D.TRD_CD			=	@[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '') " ).append("\n"); 
		query.append("AND		D.TRNK_DIR_CD		=	@[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '')  " ).append("\n"); 
		query.append("AND		D.SLAN_CD			=	@[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tpsz} != '') " ).append("\n"); 
		query.append("AND     D.CNTR_TPSZ_CD		IN	(" ).append("\n"); 
		query.append("#foreach($cntrtpszcd in ${vel_tpsz_cd})  " ).append("\n"); 
		query.append("	'$cntrtpszcd',  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("	'') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tscntr} == 'E') " ).append("\n"); 
		query.append("AND		D.TS_FLG		=	'N' " ).append("\n"); 
		query.append("#elseif (${tscntr} == 'O') " ).append("\n"); 
		query.append("AND		D.TS_FLG		=	'Y' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${soc} == 'E') " ).append("\n"); 
		query.append("AND		D.SOC_FLG		=	'N' " ).append("\n"); 
		query.append("#elseif (${soc} == 'O') " ).append("\n"); 
		query.append("AND		D.SOC_FLG		=	'Y' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '' && ${subtrade} != 'ALL') " ).append("\n"); 
		query.append("AND   D.TRD_CD  = SUBSTR(M.SUBT, 1, 3)" ).append("\n"); 
		query.append("AND   D.SLAN_CD = SUBSTR(M.SUBT, 4, 3)" ).append("\n"); 
		query.append("AND   SUBSTR(M.SUBT, 7, 2) = @[subtrade]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("		RollUp(S.DP_SEQ," ).append("\n"); 
		query.append("		D.CNTR_TPSZ_CD,									" ).append("\n"); 
		query.append("		D.TRD_CD||'-'||D.TRNK_DIR_CD)" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		S.DP_SEQ," ).append("\n"); 
		query.append("		D.TRD_CD||'-'||D.TRNK_DIR_CD" ).append("\n"); 

	}
}
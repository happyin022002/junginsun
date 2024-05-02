/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchRepoExePlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchRepoExePlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repo Plan Search
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchRepoExePlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoPlanID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toWeek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("refId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mtyBkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromWeek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchRepoExePlanRSQL").append("\n"); 
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
		query.append("	E.TRSP_MOD_CD 	ITEM" ).append("\n"); 
		query.append("	,E.VSL_CD||E.SKD_VOY_NO ||E.SKD_DIR_CD			VVD" ).append("\n"); 
		query.append("	,E.VSL_LANE_CD 			LANE" ).append("\n"); 
		query.append("	,E.FM_YD_CD 	FRLOC" ).append("\n"); 
		query.append("    ,TO_CHAR(E.FM_ETD_DT, 'YYYYMMDD') 		ETD" ).append("\n"); 
		query.append("    ,E.TO_YD_CD 	TOLOC" ).append("\n"); 
		query.append("    ,TO_CHAR(E.TO_ETA_DT, 'YYYYMMDD') 		ETA" ).append("\n"); 
		query.append("	,'' EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("	,E.EXE_ISS_FLG SOSEND" ).append("\n"); 
		query.append("    ,E.REPO_MTY_BKG_FLG REPOBKG" ).append("\n"); 
		query.append("	,CASE WHEN E.MTY_BKG_NO IS NULL THEN " ).append("\n"); 
		query.append("          'EXECUTION'" ).append("\n"); 
		query.append("     ELSE " ).append("\n"); 
		query.append("          (SELECT CASE SPLIT_FLG" ).append("\n"); 
		query.append("        		WHEN 'Y' THEN 'SPLIT BKG'" ).append("\n"); 
		query.append("        		WHEN 'N' THEN 'REPO BKG'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("  			FROM BKG_BOOKING" ).append("\n"); 
		query.append(" 				WHERE 1=1" ).append("\n"); 
		query.append("   			AND BKG_NO = E.MTY_BKG_NO)" ).append("\n"); 
		query.append("     END DIV" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,E.MTY_BKG_NO" ).append("\n"); 
		query.append("	,E.REF_ID    " ).append("\n"); 
		query.append("	,'' AS MIDDLE_POINT" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec4} != '-1')" ).append("\n"); 
		query.append("	,0 TOTALTEUVOL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec1} != '-1')" ).append("\n"); 
		query.append("	,0 TOTALTEUATTACH " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec2} != '-1')" ).append("\n"); 
		query.append("	,0 TOTALTEUWORKORDER" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec3} != '-1')" ).append("\n"); 
		query.append("	,0 TOTALTEUMVMT" ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec4} != '-1')" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("	#foreach(${key} in ${tpszArr})" ).append("\n"); 
		query.append("		NVL(MAX(DECODE(E.CNTR_TPSZ_CD, '${key}', E.CNTR_QTY)),0)" ).append("\n"); 
		query.append("		#if($velocityCount < $tpszArr.size())" ).append("\n"); 
		query.append("			+" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	 TOTALVOL " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec1} != '-1')" ).append("\n"); 
		query.append("	,(SELECT COUNT(*) FROM EQR_EXE_PLN_CNTR WHERE REPO_PLN_ID = @[repoPlanID] AND PLN_SEQ = E.PLN_SEQ AND PLN_YRWK=E.PLN_YRWK) TOTALATTACH " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec2} != '-1')" ).append("\n"); 
		query.append("	, 0 TOTALWORKORDER " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${volsec} == '' || ${volsec3} != '-1')" ).append("\n"); 
		query.append("	, 0 TOTALMVMT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#foreach(${key} in ${tpszArr})" ).append("\n"); 
		query.append("		#if ( ${volsec} == '' || ${volsec4} != '-1')" ).append("\n"); 
		query.append("		,NVL(MAX(DECODE(E.CNTR_TPSZ_CD, '${key}', E.CNTR_QTY)),0)    ${key}VOL " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   	 	#if ( ${volsec} == '' || ${volsec1} != '-1')" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("		SELECT COUNT(CNTR_NO) FROM EQR_EXE_PLN_CNTR WHERE REPO_PLN_ID = @[repoPlanID]" ).append("\n"); 
		query.append("		AND PLN_YRWK = E.PLN_YRWK" ).append("\n"); 
		query.append("		AND PLN_SEQ = E.PLN_SEQ" ).append("\n"); 
		query.append("		AND REF_ID = E.REF_ID" ).append("\n"); 
		query.append("		AND CNTR_TPSZ_CD = '${key}'" ).append("\n"); 
		query.append("	  	) ${key}ATTACH" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( ${volsec} == '' || ${volsec2} != '-1')" ).append("\n"); 
		query.append("    	,0 ${key}WORKORDER" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( ${volsec} == '' || ${volsec3} != '-1')" ).append("\n"); 
		query.append("    	,0 ${key}MVMT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    , (SELECT OFC_CD FROM COM_USER WHERE USR_ID = (SELECT UPD_USR_ID FROM EQR_REPO_EXE_PLN WHERE REPO_PLN_ID =  @[repoPlanID] AND PLN_YRWK = PLN_YRWK AND PLN_SEQ = PLN_SEQ AND REF_ID = REF_ID AND ROWNUM=1)) OFC_CD  " ).append("\n"); 
		query.append("	, (SELECT UPD_USR_ID FROM COM_USER WHERE USR_ID = (SELECT UPD_USR_ID FROM EQR_REPO_EXE_PLN WHERE REPO_PLN_ID =  @[repoPlanID] AND PLN_YRWK = PLN_YRWK AND PLN_SEQ = PLN_SEQ AND REF_ID = REF_ID AND ROWNUM=1)) UPD_USR_ID  " ).append("\n"); 
		query.append("	, TO_CHAR((SELECT UPD_DT FROM COM_USER WHERE USR_ID = (SELECT UPD_USR_ID FROM EQR_REPO_EXE_PLN WHERE REPO_PLN_ID =  @[repoPlanID] AND PLN_YRWK = PLN_YRWK AND PLN_SEQ = PLN_SEQ AND REF_ID = REF_ID AND ROWNUM=1)),'YYYY-MM-DD') UPD_DT " ).append("\n"); 
		query.append("    ,E.PLN_YRWK" ).append("\n"); 
		query.append("	,E.REPO_PLN_ID 	-- HIDDEN" ).append("\n"); 
		query.append("	,1 SORTNUM    	-- HIDDEN" ).append("\n"); 
		query.append("    ,'' WEEKFROMDATE" ).append("\n"); 
		query.append("	,'' WEEKTODATE" ).append("\n"); 
		query.append("	,'' WEEKMAXDATE" ).append("\n"); 
		query.append("	,E.VSL_CD" ).append("\n"); 
		query.append("	,E.SKD_DIR_CD" ).append("\n"); 
		query.append("	,E.SKD_VOY_NO" ).append("\n"); 
		query.append("	,'H'		 		COMPANY    -- E.CO_CD" ).append("\n"); 
		query.append("	,''	ALLLOCCD" ).append("\n"); 
		query.append("	,E.PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("	,'' SPLITREPOPLNFLG" ).append("\n"); 
		query.append("	,(SELECT DISTINCT RCC_CD FROM EQR_ECC_MST WHERE ECC_CD = SUBSTR(E.FM_YD_CD,1,5)) FM_RCC" ).append("\n"); 
		query.append("	,(SELECT DISTINCT RCC_CD FROM EQR_ECC_MST WHERE ECC_CD = SUBSTR(E.TO_YD_CD,1,5)) TO_RCC     -- To   ecc's RCC" ).append("\n"); 
		query.append("    ,(SELECT DISTINCT LCC_CD FROM EQR_ECC_MST WHERE ECC_CD = SUBSTR(E.FM_YD_CD,1,5)) FM_LCC     -- From ecc's LCC" ).append("\n"); 
		query.append("    ,(SELECT DISTINCT LCC_CD FROM EQR_ECC_MST WHERE ECC_CD = SUBSTR(E.TO_YD_CD,1,5)) TO_LCC     -- To   ecc's LCC" ).append("\n"); 
		query.append("	,SUBSTR(E.FM_YD_CD,1,5) FM_ECC    " ).append("\n"); 
		query.append("    ,SUBSTR(E.TO_YD_CD,1,5) TO_ECC  " ).append("\n"); 
		query.append("	,'' AS   TPSZNO" ).append("\n"); 
		query.append("    ,E.PLN_SEQ " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        A.PLN_YRWK" ).append("\n"); 
		query.append("        ,A.PLN_SEQ" ).append("\n"); 
		query.append("        ,A.CO_CD" ).append("\n"); 
		query.append("        ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,B.ECC_CD FM_ECC" ).append("\n"); 
		query.append("        ,C.ECC_CD TO_ECC" ).append("\n"); 
		query.append("        ,Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.REPO_PLN_ID" ).append("\n"); 
		query.append("		,A.REF_ID" ).append("\n"); 
		query.append("        ,A.PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("        ,Q.TRSP_COST_AMT" ).append("\n"); 
		query.append("        ,Q.CNTR_QTY" ).append("\n"); 
		query.append("        ,A.FM_YD_CD" ).append("\n"); 
		query.append("        ,A.FM_ETD_DT" ).append("\n"); 
		query.append("        ,A.TO_YD_CD" ).append("\n"); 
		query.append("        ,A.TO_ETA_DT" ).append("\n"); 
		query.append("        ,A.VSL_CD" ).append("\n"); 
		query.append("        ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("        ,SUM(Q.CNTR_QTY) MAX_QTY" ).append("\n"); 
		query.append("		,A.MTY_BKG_NO" ).append("\n"); 
		query.append("		,A.REPO_MTY_BKG_FLG" ).append("\n"); 
		query.append("		,A.EXE_ISS_FLG" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        EQR_REPO_EXE_PLN A," ).append("\n"); 
		query.append("        EQR_REPO_EXE_PLN_QTY Q," ).append("\n"); 
		query.append("        MDM_EQ_ORZ_CHT B," ).append("\n"); 
		query.append("        MDM_EQ_ORZ_CHT C," ).append("\n"); 
		query.append("        MDM_LOCATION E," ).append("\n"); 
		query.append("        MDM_LOCATION F" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("        A.REPO_PLN_ID = Q.REPO_PLN_ID" ).append("\n"); 
		query.append("        AND A.PLN_YRWK = Q.PLN_YRWK" ).append("\n"); 
		query.append("        AND A.PLN_SEQ = Q.PLN_SEQ" ).append("\n"); 
		query.append("        AND A.REF_ID = Q.REF_ID" ).append("\n"); 
		query.append("        AND SUBSTR(A.FM_YD_CD, 0, 5) = E.LOC_CD" ).append("\n"); 
		query.append("        AND E.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("        AND SUBSTR(A.TO_YD_CD, 0, 5) = F.LOC_CD" ).append("\n"); 
		query.append("        AND F.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("        AND   A.REPO_PLN_ID = @[repoPlanID]" ).append("\n"); 
		query.append("        AND   A.PLN_YRWK BETWEEN @[fromWeek] AND @[toWeek]" ).append("\n"); 
		query.append("    GROUP BY" ).append("\n"); 
		query.append("        A.PLN_YRWK" ).append("\n"); 
		query.append("        ,A.PLN_SEQ" ).append("\n"); 
		query.append("        ,A.CO_CD" ).append("\n"); 
		query.append("        ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,B.ECC_CD" ).append("\n"); 
		query.append("        ,C.ECC_CD" ).append("\n"); 
		query.append("        ,Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.REPO_PLN_ID" ).append("\n"); 
		query.append("        ,A.PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("        ,Q.TRSP_COST_AMT" ).append("\n"); 
		query.append("        ,Q.CNTR_QTY" ).append("\n"); 
		query.append("        ,A.FM_YD_CD" ).append("\n"); 
		query.append("        ,A.FM_ETD_DT" ).append("\n"); 
		query.append("        ,A.TO_YD_CD" ).append("\n"); 
		query.append("        ,A.TO_ETA_DT" ).append("\n"); 
		query.append("        ,A.VSL_CD" ).append("\n"); 
		query.append("        ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("		,A.REF_ID" ).append("\n"); 
		query.append("		,A.MTY_BKG_NO" ).append("\n"); 
		query.append("		,A.REPO_MTY_BKG_FLG" ).append("\n"); 
		query.append("		,A.EXE_ISS_FLG" ).append("\n"); 
		query.append("        ) E" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    AND   E.REPO_PLN_ID = @[repoPlanID]" ).append("\n"); 
		query.append("    AND   E.PLN_YRWK BETWEEN @[fromWeek] AND @[toWeek]" ).append("\n"); 
		query.append("	#if ( ${mtyBkgNo} != '' )" ).append("\n"); 
		query.append("		AND E.MTY_BKG_NO = @[mtyBkgNo]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${refId} != '' )" ).append("\n"); 
		query.append("		AND E.REF_ID = @[refId]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvdStrArr} != '')" ).append("\n"); 
		query.append("		AND E.VSL_CD||E.SKD_VOY_NO||E.SKD_DIR_CD	IN ( ${vvdStrArr} )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    E.PLN_YRWK" ).append("\n"); 
		query.append("    ,E.PLN_SEQ" ).append("\n"); 
		query.append("    ,E.CO_CD" ).append("\n"); 
		query.append("    ,E.FM_YD_CD 	" ).append("\n"); 
		query.append("    ,E.FM_ETD_DT 		" ).append("\n"); 
		query.append("    ,E.TO_YD_CD 	" ).append("\n"); 
		query.append("    ,E.TO_ETA_DT 	" ).append("\n"); 
		query.append("    ,E.TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,E.REPO_PLN_ID" ).append("\n"); 
		query.append("    ,E.PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("    ,E.VSL_CD" ).append("\n"); 
		query.append("    ,E.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,E.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,E.VSL_LANE_CD" ).append("\n"); 
		query.append("	,E.REF_ID" ).append("\n"); 
		query.append("	,E.MTY_BKG_NO" ).append("\n"); 
		query.append("	,E.REPO_MTY_BKG_FLG" ).append("\n"); 
		query.append("	,E.EXE_ISS_FLG" ).append("\n"); 
		query.append("ORDER BY E.PLN_SEQ ASC" ).append("\n"); 

	}
}
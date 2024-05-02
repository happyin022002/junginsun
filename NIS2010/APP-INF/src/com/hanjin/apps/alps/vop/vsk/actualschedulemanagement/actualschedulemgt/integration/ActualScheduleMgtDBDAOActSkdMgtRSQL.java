/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActSkdMgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOActSkdMgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Port Schedule 정보를 조회합니다.
	  * ------------------------------------------------------------------------------------------
	  * 2010.12.10 진마리아 [CHM-201007578-01] 최초 입력된 INP_DT, INP_USR_ID 컬럼을 추가하여 조회합니다. 
	  * 2010.12.28 선처리CSR 이석준 CRE_DT, UPD_DT를 해당 PORT 기준으로 변환하여 조회합니다.
	  * 2011.05.13 진마리아 [CHM-201110230-01] VSK-Actual SKD creation 화면 일부 수정 요청(EDI와 Departure Report 정보 구분)
	  * 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경. ATA,ATB,ATD 별 Remark 칼럼 추가
	  * 2012.08.28 진마리아 CHM-201219486-01 VSK_DEP_RPT 차단(FCM_DEP_RPT 대체) / ACT SKD과 VMS Data를 구별하여 alert
	  * 2012.10.24 진마리아 CHM-201220527-01 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
	  * 2014.02.27 임예지 [CHM-201429074] - ATA, ATB, ATD 삭제 히스토리가 있을 경우 Departure Report의 ATA, ATB, ATD 값을 안보여 주도록 변경.
	  * 2014.09.25 강지혜	Actual 정보 조회시 최초에만 Departure Report정보로 
	  * 				PLT_LST_UNLD_DT, BFR_BRTH_ANK_DRP_DT,BFR_BRTH_ANK_OFF_DT,AFT_UNBRTH_ANK_DRP_DT,AFT_UNBRTH_ANK_OFF_DT
	  * 				값을 보여주고 Actual 정보 저장 후 Actual 정보로 보여준다.
	  * 				FLAG컬럼 : '' 에서 Actual 정보 저장이 있을경우 A로 없을 경우 R로 
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActSkdMgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActSkdMgtRSQL").append("\n"); 
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
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("	, T1.SKD_VOY_NO" ).append("\n"); 
		query.append("	, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("	, T1.VPS_PORT_CD" ).append("\n"); 
		query.append("	, T1.CLPT_SEQ" ).append("\n"); 
		query.append("	, T1.YD_CD " ).append("\n"); 
		query.append("	, T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, T1.SLAN_CD" ).append("\n"); 
		query.append("	, T2.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	, TO_CHAR(T1.PF_ETA_DT	, 'YYYY-MM-DD HH24:MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("	, TO_CHAR(T1.PF_ETB_DT	, 'YYYY-MM-DD HH24:MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("	, TO_CHAR(T1.PF_ETD_DT	, 'YYYY-MM-DD HH24:MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.LST_ETA_DT, T1.VPS_ETA_DT)	, 'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.LST_ETB_DT, T1.VPS_ETB_DT)	, 'YYYY-MM-DD HH24:MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.LST_ETD_DT, T1.VPS_ETD_DT)	, 'YYYY-MM-DD HH24:MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("	, T1.TURN_PORT_FLG" ).append("\n"); 
		query.append("	, T1.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	, T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	, T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	, T1.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, CASE WHEN T2.ACT_ARR_DT IS NOT NULL THEN TO_CHAR(T2.ACT_ARR_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	       WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("	             FROM   VSK_ACT_PORT_SKD_HIS X" ).append("\n"); 
		query.append("	             WHERE  X.VSL_CD       = T1.VSL_CD" ).append("\n"); 
		query.append("	             AND    X.SKD_VOY_NO   = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("	             AND    X.SKD_DIR_CD   = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("	             AND    X.VPS_PORT_CD  = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("	             AND    X.CLPT_IND_SEQ = T1.CLPT_IND_SEQ) = 0 THEN TO_CHAR(T3.PLT_IN_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	  END  AS ACT_ARR_DT" ).append("\n"); 
		query.append("	, CASE WHEN T2.ACT_BRTH_DT IS NOT NULL THEN TO_CHAR(T2.ACT_BRTH_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	       WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("	             FROM   VSK_ACT_PORT_SKD_HIS X" ).append("\n"); 
		query.append("	             WHERE  X.VSL_CD       = T1.VSL_CD" ).append("\n"); 
		query.append("	             AND    X.SKD_VOY_NO   = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("	             AND    X.SKD_DIR_CD   = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("	             AND    X.VPS_PORT_CD  = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("	             AND    X.CLPT_IND_SEQ = T1.CLPT_IND_SEQ) = 0 THEN TO_CHAR(T3.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	  END  AS ACT_BRTH_DT" ).append("\n"); 
		query.append("	, CASE WHEN T2.ACT_DEP_DT IS NOT NULL THEN TO_CHAR(T2.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	       WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("	             FROM   VSK_ACT_PORT_SKD_HIS X" ).append("\n"); 
		query.append("	             WHERE  X.VSL_CD       = T1.VSL_CD" ).append("\n"); 
		query.append("	             AND    X.SKD_VOY_NO   = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("	             AND    X.SKD_DIR_CD   = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("	             AND    X.VPS_PORT_CD  = T1.VPS_PORT_CD" ).append("\n"); 
		query.append("	             AND    X.CLPT_IND_SEQ = T1.CLPT_IND_SEQ) = 0 THEN TO_CHAR(T3.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("	  END  AS ACT_DEP_DT" ).append("\n"); 
		query.append("--	, TO_CHAR(NVL(T2.ACT_ARR_DT	, T3.PLT_IN_DT	),	'YYYY-MM-DD HH24:MI') AS ACT_ARR_DT" ).append("\n"); 
		query.append("--	, TO_CHAR(NVL(T2.ACT_BRTH_DT, T3.VPS_ETB_DT),	'YYYY-MM-DD HH24:MI') AS ACT_BRTH_DT" ).append("\n"); 
		query.append("--	, TO_CHAR(NVL(T2.ACT_DEP_DT	, T3.VPS_ETD_DT	),	'YYYY-MM-DD HH24:MI') AS ACT_DEP_DT" ).append("\n"); 
		query.append("	, TO_CHAR(T2.LST_ETA_DT	, 'YYYY-MM-DD HH24:MI') AS LST_ETA_DT" ).append("\n"); 
		query.append("	, TO_CHAR(T2.LST_ETB_DT	, 'YYYY-MM-DD HH24:MI') AS LST_ETB_DT" ).append("\n"); 
		query.append("	, TO_CHAR(T2.LST_ETD_DT	, 'YYYY-MM-DD HH24:MI') AS LST_ETD_DT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR(ROUND(T2.ACT_ARR_DT	- T1.VPS_ETA_DT, 1), '990.0')) AS DLAY_ARR_TM" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR(ROUND(T2.ACT_BRTH_DT- T1.VPS_ETB_DT, 1), '990.0')) AS DLAY_BRTH_TM" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR(ROUND(T2.ACT_DEP_DT	- T1.VPS_ETD_DT, 1), '990.0')) AS DLAY_DEP_TM" ).append("\n"); 
		query.append("	, T2.VSL_ARR_DLAY_RSN_CD" ).append("\n"); 
		query.append("	, T2.VSL_BRTH_DLAY_RSN_CD" ).append("\n"); 
		query.append("	, T2.VSL_DEP_DLAY_RSN_CD" ).append("\n"); 
		query.append("	, '' AS VSL_ARR_DLAY_RSN_NM" ).append("\n"); 
		query.append("	, '' AS VSL_BRTH_DLAY_RSN_NM" ).append("\n"); 
		query.append("	, '' AS VSL_DEP_DLAY_RSN_NM" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_FOIL_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_FOIL_WGT         ) , '', T2.ARR_FOIL_WGT          , '0', T2.ARR_FOIL_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_FOIL_WGT)         ) , T2.ARR_FOIL_WGT))          , '99,990.09'   )) AS ARR_FOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_LOW_SULP_FOIL_WGT,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_LOW_SULP_FOIL_WGT) , '', T2.ARR_LOW_SULP_FOIL_WGT , '0', T2.ARR_LOW_SULP_FOIL_WGT, VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_LOW_SULP_FOIL_WGT)) , T2.ARR_LOW_SULP_FOIL_WGT)) , '99,990.09'   )) AS ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_DOIL_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_DOIL_WGT         ) , '', T2.ARR_DOIL_WGT          , '0', T2.ARR_DOIL_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_DOIL_WGT)         ) , T2.ARR_DOIL_WGT))          , '99,990.09'   )) AS ARR_DOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_LOW_SULP_DOIL_WGT,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_LOW_SULP_DOIL_WGT) , '', T2.ARR_LOW_SULP_DOIL_WGT , '0', T2.ARR_LOW_SULP_DOIL_WGT, VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_LOW_SULP_DOIL_WGT)) , T2.ARR_LOW_SULP_DOIL_WGT)) , '99,990.09'   )) AS ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_FRSH_WTR_WGT     ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_FRSH_WTR_WGT     ) , '', T2.ARR_FRSH_WTR_WGT      , '0', T2.ARR_FRSH_WTR_WGT     , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_FRSH_WTR_WGT)     ) , T2.ARR_FRSH_WTR_WGT))      , '99,990.09'   )) AS ARR_FRSH_WTR_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_BLST_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_BLST_WGT         ) , '', T2.ARR_BLST_WGT          , '0', T2.ARR_BLST_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_BLST_WGT)         ) , T2.ARR_BLST_WGT))          , '99,990.09'   )) AS ARR_BLST_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_FWDDR_HGT        ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_FWDDR_HGT        ) , '', T2.ARR_FWDDR_HGT         , '0', T2.ARR_FWDDR_HGT        , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_FWDDR_HGT)        ) , T2.ARR_FWDDR_HGT))         , '90.09'       )) AS ARR_FWDDR_HGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_AFTDR_HGT        ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_AFTDR_HGT        ) , '', T2.ARR_AFTDR_HGT         , '0', T2.ARR_AFTDR_HGT        , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_AFTDR_HGT)        ) , T2.ARR_AFTDR_HGT))         , '90.09'       )) AS ARR_AFTDR_HGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.ARR_GM_HGT           ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_GM_HGT           ) , '', T2.ARR_GM_HGT            , '0', T2.ARR_GM_HGT           , VSK_REMOVE_NONE_NUMERIC_FNC(T3.ARR_GM_HGT)           ) , T2.ARR_GM_HGT))            , '90.09'       )) AS ARR_GM_HGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR(T2.ARR_TUG_BOT_KNT                                                                                                                                                                          , '90'          )) AS ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.SPL_FOIL_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_FOIL_ACT_WGT          ), '', T2.SPL_FOIL_WGT          , '0', T2.SPL_FOIL_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_FOIL_ACT_WGT)          ), T2.SPL_FOIL_WGT))          , '99,990.09'   )) AS SPL_FOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.SPL_LOW_SULP_FOIL_WGT,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_LOW_SULP_FOIL_ACT_WGT ), '', T2.SPL_LOW_SULP_FOIL_WGT , '0', T2.SPL_LOW_SULP_FOIL_WGT, VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_LOW_SULP_FOIL_ACT_WGT) ), T2.SPL_LOW_SULP_FOIL_WGT)) , '99,990.09'   )) AS SPL_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.SPL_DOIL_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_DOIL_ACT_WGT          ), '', T2.SPL_DOIL_WGT          , '0', T2.SPL_DOIL_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_DOIL_ACT_WGT)          ), T2.SPL_DOIL_WGT))          , '99,990.09'   )) AS SPL_DOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.SPL_LOW_SULP_DOIL_WGT,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_LOW_SULP_DOIL_ACT_WGT ), '', T2.SPL_LOW_SULP_DOIL_WGT , '0', T2.SPL_LOW_SULP_DOIL_WGT, VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_LOW_SULP_DOIL_ACT_WGT) ), T2.SPL_LOW_SULP_DOIL_WGT)) , '99,990.09'   )) AS SPL_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.SPL_FRSH_WTR_WGT     ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_FRSH_WTR_ACT_WGT      ), '', T2.SPL_FRSH_WTR_WGT      , '0', T2.SPL_FRSH_WTR_WGT     , VSK_REMOVE_NONE_NUMERIC_FNC(T3.SPL_FRSH_WTR_ACT_WGT)      ), T2.SPL_FRSH_WTR_WGT))      , '99,990.09'   )) AS SPL_FRSH_WTR_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_LOW_SULP_FOIL_WGT,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_LOW_SULP_FOIL_WGT ), '', T2.DEP_LOW_SULP_FOIL_WGT , '0', T2.DEP_LOW_SULP_FOIL_WGT, VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_LOW_SULP_FOIL_WGT) ), T2.DEP_LOW_SULP_FOIL_WGT)) , '99,990.09'   )) AS DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_FOIL_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_FOIL_WGT          ), '', T2.DEP_FOIL_WGT          , '0', T2.DEP_FOIL_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_FOIL_WGT)          ), T2.DEP_FOIL_WGT))          , '99,990.09'   )) AS DEP_FOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_LOW_SULP_DOIL_WGT,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_LOW_SULP_DOIL_WGT ), '', T2.DEP_LOW_SULP_DOIL_WGT , '0', T2.DEP_LOW_SULP_DOIL_WGT, VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_LOW_SULP_DOIL_WGT) ), T2.DEP_LOW_SULP_DOIL_WGT)) , '99,990.09'   )) AS DEP_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_DOIL_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_DOIL_WGT          ), '', T2.DEP_DOIL_WGT          , '0', T2.DEP_DOIL_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_DOIL_WGT)          ), T2.DEP_DOIL_WGT))          , '99,990.09'   )) AS DEP_DOIL_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_FRSH_WTR_WGT     ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_FRSH_WTR_WGT      ), '', T2.DEP_FRSH_WTR_WGT      , '0', T2.DEP_FRSH_WTR_WGT     , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_FRSH_WTR_WGT)      ), T2.DEP_FRSH_WTR_WGT))      , '99,990.09'   )) AS DEP_FRSH_WTR_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_BLST_WGT         ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_BLST_WGT          ), '', T2.DEP_BLST_WGT          , '0', T2.DEP_BLST_WGT         , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_BLST_WGT)          ), T2.DEP_BLST_WGT))          , '99,990.09'   )) AS DEP_BLST_WGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_FWDDR_HGT        ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_FWDDR_HGT         ), '', T2.DEP_FWDDR_HGT         , '0', T2.DEP_FWDDR_HGT        , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_FWDDR_HGT)         ), T2.DEP_FWDDR_HGT))         , '90.09'       )) AS DEP_FWDDR_HGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_AFTDR_HGT        ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_AFTDR_HGT         ), '', T2.DEP_AFTDR_HGT         , '0', T2.DEP_AFTDR_HGT        , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_AFTDR_HGT)         ), T2.DEP_AFTDR_HGT))         , '90.09'       )) AS DEP_AFTDR_HGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.DEP_GM_HGT           ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_GM_HGT            ), '', T2.DEP_GM_HGT            , '0', T2.DEP_GM_HGT           , VSK_REMOVE_NONE_NUMERIC_FNC(T3.DEP_GM_HGT)            ), T2.DEP_GM_HGT))            , '90.09'       )) AS DEP_GM_HGT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR(T2.DEP_TUG_BOT_KNT                                                                                                                                                                          , '90'          )) AS DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR((DECODE(NVL(T2.TTL_SLG_WGT          ,0), 0, DECODE(VSK_REMOVE_NONE_NUMERIC_FNC(T3.TTL_SLG_WGT           ), '', T2.TTL_SLG_WGT           , '0', T2.TTL_SLG_WGT          , VSK_REMOVE_NONE_NUMERIC_FNC(T3.TTL_SLG_WGT)           ), T2.TTL_SLG_WGT))           , '99,990.09'   )) AS TTL_SLG_WGT /* 신규 추가 */" ).append("\n"); 
		query.append("	, LTRIM(TO_CHAR(T2.TTL_GBG_QTY                                                                                                                                                                              , '99,990.09'   )) AS TTL_GBG_QTY /* 신규 추가 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* (Vessel Condition FLG) Actual 값이 있거나, Actual/Departure Report 둘 다 값이 없으면 Actual 을, Actual이 없으나 Dep 값이 있으면 Dep 을 가져온다. */" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_FOIL_WGT         ,0), 0, DECODE(T3.ARR_FOIL_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_FOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_LOW_SULP_FOIL_WGT,0), 0, DECODE(T3.ARR_LOW_SULP_FOIL_WGT , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_LOW_SULP_FOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_DOIL_WGT         ,0), 0, DECODE(T3.ARR_DOIL_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_DOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_LOW_SULP_DOIL_WGT,0), 0, DECODE(T3.ARR_LOW_SULP_DOIL_WGT , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_LOW_SULP_DOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_FRSH_WTR_WGT     ,0), 0, DECODE(T3.ARR_FRSH_WTR_WGT      , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_FRSH_WTR_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_BLST_WGT         ,0), 0, DECODE(T3.ARR_BLST_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_BLST_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_FWDDR_HGT        ,0), 0, DECODE(T3.ARR_FWDDR_HGT         , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_FWDDR_HGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_AFTDR_HGT        ,0), 0, DECODE(T3.ARR_AFTDR_HGT         , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_AFTDR_HGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.ARR_GM_HGT           ,0), 0, DECODE(T3.ARR_GM_HGT            , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS ARR_GM_HGT_FLG" ).append("\n"); 
		query.append("	, 'Act' AS ARR_TUG_BOT_KNT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.SPL_FOIL_WGT         ,0), 0, DECODE(T3.SPL_FOIL_ACT_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS SPL_FOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.SPL_LOW_SULP_FOIL_WGT,0), 0, DECODE(T3.SPL_LOW_SULP_FOIL_ACT_WGT , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS SPL_LOW_SULP_FOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.SPL_DOIL_WGT         ,0), 0, DECODE(T3.SPL_DOIL_ACT_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS SPL_DOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.SPL_LOW_SULP_DOIL_WGT,0), 0, DECODE(T3.SPL_LOW_SULP_DOIL_ACT_WGT , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS SPL_LOW_SULP_DOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.SPL_FRSH_WTR_WGT     ,0), 0, DECODE(T3.SPL_FRSH_WTR_ACT_WGT      , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS SPL_FRSH_WTR_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_LOW_SULP_FOIL_WGT,0), 0, DECODE(T3.DEP_LOW_SULP_FOIL_WGT , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_LOW_SULP_FOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_FOIL_WGT         ,0), 0, DECODE(T3.DEP_FOIL_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_FOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_LOW_SULP_DOIL_WGT,0), 0, DECODE(T3.DEP_LOW_SULP_DOIL_WGT , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_LOW_SULP_DOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_DOIL_WGT         ,0), 0, DECODE(T3.DEP_DOIL_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_DOIL_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_FRSH_WTR_WGT     ,0), 0, DECODE(T3.DEP_FRSH_WTR_WGT      , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_FRSH_WTR_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_BLST_WGT         ,0), 0, DECODE(T3.DEP_BLST_WGT          , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_BLST_WGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_FWDDR_HGT        ,0), 0, DECODE(T3.DEP_FWDDR_HGT         , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_FWDDR_HGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_AFTDR_HGT        ,0), 0, DECODE(T3.DEP_AFTDR_HGT         , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_AFTDR_HGT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.DEP_GM_HGT           ,0), 0, DECODE(T3.DEP_GM_HGT            , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS DEP_GM_HGT_FLG" ).append("\n"); 
		query.append("	, 'Act' AS DEP_TUG_BOT_KNT_FLG" ).append("\n"); 
		query.append("	, LTRIM(DECODE(NVL(T2.TTL_SLG_WGT          ,0), 0, DECODE(T3.TTL_SLG_WGT           , '', 'Act', '0', 'Act', 'Dep') , 'Act')) AS TTL_SLG_WGT_FLG" ).append("\n"); 
		query.append("	, 'Act' AS TTL_GBG_QTY_FLG" ).append("\n"); 
		query.append("	/*최초조회 이후 Depart Report를 가지고있으나 Actual 정보를 입력했으면 Actual정보를 보여준다 */" ).append("\n"); 
		query.append("	--, TO_CHAR(NVL(T2.PLT_LST_UNLD_DT	        , T3.PLT_OUT_DT      ), 'YYYY-MM-DD HH24:MI') AS PLT_LST_UNLD_DT" ).append("\n"); 
		query.append("	--, TO_CHAR(NVL(T2.BFR_BRTH_ANK_DRP_DT	    , T3.BFR_BRTH_ANK_DRP_DT	), 'YYYY-MM-DD HH24:MI') AS BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	--, TO_CHAR(NVL(T2.BFR_BRTH_ANK_OFF_DT	    , T3.BFR_BRTH_ANK_OFF_DT	), 'YYYY-MM-DD HH24:MI') AS BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	--, TO_CHAR(NVL(T2.AFT_UNBRTH_ANK_DRP_DT	    , T3.AFT_UNBRTH_ANK_DRP_DT	), 'YYYY-MM-DD HH24:MI') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	--, TO_CHAR(NVL(T2.AFT_UNBRTH_ANK_OFF_DT	    , T3.AFT_UNBRTH_ANK_OFF_DT  ), 'YYYY-MM-DD HH24:MI') AS AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.PLT_LST_UNLD_DT	        , DECODE( T2.ACT_ARR_DT , null , T3.PLT_OUT_DT ,null)       ), 'YYYY-MM-DD HH24:MI') AS PLT_LST_UNLD_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.BFR_BRTH_ANK_DRP_DT	    , DECODE( T2.ACT_ARR_DT , null , T3.BFR_BRTH_ANK_DRP_DT, null)	), 'YYYY-MM-DD HH24:MI') AS BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.BFR_BRTH_ANK_OFF_DT	    , DECODE( T2.ACT_ARR_DT , null , T3.BFR_BRTH_ANK_OFF_DT, null)	), 'YYYY-MM-DD HH24:MI') AS BFR_BRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.AFT_UNBRTH_ANK_DRP_DT	    , DECODE( T2.ACT_ARR_DT , null , T3.AFT_UNBRTH_ANK_DRP_DT, null)	), 'YYYY-MM-DD HH24:MI') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("	, TO_CHAR(NVL(T2.AFT_UNBRTH_ANK_OFF_DT	    , DECODE( T2.ACT_ARR_DT , null , T3.AFT_UNBRTH_ANK_OFF_DT, null)	), 'YYYY-MM-DD HH24:MI') AS AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("	, T2.DIFF_RMK" ).append("\n"); 
		query.append("	, T2.ACT_ARR_RMK" ).append("\n"); 
		query.append("	, T2.ACT_BRTH_RMK" ).append("\n"); 
		query.append("	, T2.ACT_DEP_RMK" ).append("\n"); 
		query.append("	, T2.CRE_USR_ID" ).append("\n"); 
		query.append("--	, TO_CHAR(T2.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("    , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', T2.CRE_DT, @[vps_port_cd]), 'YYYY-MM-DD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("	, T2.UPD_USR_ID" ).append("\n"); 
		query.append("--	, TO_CHAR(T2.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("    , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', T2.UPD_DT, @[vps_port_cd]), 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("	, (" ).append("\n"); 
		query.append("            SELECT MAX(VPS_PORT_CD)" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = CASE WHEN T1.CLPT_SEQ = '1' THEN T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                     ELSE T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = CASE WHEN T1.CLPT_SEQ = '1' THEN T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                     ELSE T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("               AND CLPT_SEQ =      CASE WHEN T1.CLPT_SEQ = '1' " ).append("\n"); 
		query.append("										THEN (" ).append("\n"); 
		query.append("											SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("											FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("											WHERE VSL_CD=T1.VSL_CD " ).append("\n"); 
		query.append("											AND SKD_VOY_NO = T1.TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("											AND SKD_DIR_CD = T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("											AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("											AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("										ELSE (" ).append("\n"); 
		query.append("											SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("											FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("											WHERE VSL_CD=T1.VSL_CD " ).append("\n"); 
		query.append("											AND SKD_VOY_NO = T1.SKD_VOY_NO " ).append("\n"); 
		query.append("											AND SKD_DIR_CD = T1.SKD_DIR_CD " ).append("\n"); 
		query.append("											AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("											AND CLPT_SEQ < T1.CLPT_SEQ" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("										END" ).append("\n"); 
		query.append("         ) AS PRE_PORT_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT MAX(TO_CHAR(T11.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = CASE WHEN T1.CLPT_SEQ = '1' THEN T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                     ELSE T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = CASE WHEN T1.CLPT_SEQ = '1' THEN T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                     ELSE T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("               AND CLPT_SEQ =      CASE WHEN T1.CLPT_SEQ = '1' " ).append("\n"); 
		query.append("										THEN (" ).append("\n"); 
		query.append("											SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("											FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("											WHERE VSL_CD=T1.VSL_CD " ).append("\n"); 
		query.append("											AND SKD_VOY_NO = T1.TURN_SKD_VOY_NO " ).append("\n"); 
		query.append("											AND SKD_DIR_CD = T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("											AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("											AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("										ELSE (" ).append("\n"); 
		query.append("											SELECT MAX(CLPT_SEQ) " ).append("\n"); 
		query.append("											FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("											WHERE VSL_CD=T1.VSL_CD " ).append("\n"); 
		query.append("											AND SKD_VOY_NO = T1.SKD_VOY_NO " ).append("\n"); 
		query.append("											AND SKD_DIR_CD = T1.SKD_DIR_CD " ).append("\n"); 
		query.append("											AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("											AND CLPT_SEQ < T1.CLPT_SEQ" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("										END" ).append("\n"); 
		query.append("         ) AS PRE_ETD_DT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			   AND CLPT_SEQ = (SELECT MIN(T21.CLPT_SEQ)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD T21" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND CLPT_SEQ > TO_CHAR(TO_NUMBER(T1.CLPT_SEQ), '99')" ).append("\n"); 
		query.append("                                   AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("         ) AS NXT_PORT_CD" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(T11.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			   AND CLPT_SEQ = (SELECT MIN(T21.CLPT_SEQ)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD T21" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND CLPT_SEQ > TO_CHAR(TO_NUMBER(T1.CLPT_SEQ), '99')" ).append("\n"); 
		query.append("                                   AND NVL(SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("         ) AS NXT_ETA_DT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT ACT_INP_FLG" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD T11" ).append("\n"); 
		query.append("             WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("               AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			   AND CLPT_SEQ = (SELECT MIN(T21.CLPT_SEQ)" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD T21" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND CLPT_SEQ > TO_CHAR(TO_NUMBER(T1.CLPT_SEQ), '99'))" ).append("\n"); 
		query.append("         ) AS NXT_ACT_INP_FLG" ).append("\n"); 
		query.append("		/*ATA정보가 입력된 이후 시점은 Actual로 간주한다.*/" ).append("\n"); 
		query.append("       ,(	SELECT DECODE( TT.ACT_ARR_DT , null , 'R' , 'A') " ).append("\n"); 
		query.append("			FROM	VSK_ACT_PORT_SKD  TT" ).append("\n"); 
		query.append("			WHERE	TT.VSL_CD		    = T2.VSL_CD		    " ).append("\n"); 
		query.append("			AND	TT.SKD_VOY_NO		= T2.SKD_VOY_NO		" ).append("\n"); 
		query.append("			AND	TT.SKD_DIR_CD		= T2.SKD_DIR_CD		" ).append("\n"); 
		query.append("			AND	TT.VPS_PORT_CD		= T2.VPS_PORT_CD	" ).append("\n"); 
		query.append("			AND	TT.CLPT_IND_SEQ		= T2.CLPT_IND_SEQ	) AS FLAG" ).append("\n"); 
		query.append("	   , T4.SKD_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT TO_CHAR(ACT_ATA_INP_DT, 'YYYYMMDDHH24MISS') FROM (" ).append("\n"); 
		query.append("				SELECT T1.*, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) RNUM" ).append("\n"); 
		query.append("				FROM VSK_ACT_PORT_SKD_HIS T1" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("				AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("				AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("				AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("				AND ACT_ATA_INP_DT IS NOT NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			WHERE RNUM=1" ).append("\n"); 
		query.append("	     ) AS ACT_ATA_INP_DT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT ACT_ATA_INP_USR_ID FROM (" ).append("\n"); 
		query.append("				SELECT T1.*, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) RNUM" ).append("\n"); 
		query.append("				FROM VSK_ACT_PORT_SKD_HIS T1" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("				AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("				AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("				AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("				AND ACT_ATA_INP_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			WHERE RNUM=1" ).append("\n"); 
		query.append("	     ) AS ACT_ATA_INP_USR_ID" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT TO_CHAR(ACT_ATB_INP_DT, 'YYYYMMDDHH24MISS') FROM (" ).append("\n"); 
		query.append("				SELECT T1.*, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) RNUM" ).append("\n"); 
		query.append("				FROM VSK_ACT_PORT_SKD_HIS T1" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("				AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("				AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("				AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("				AND ACT_ATB_INP_DT IS NOT NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			WHERE RNUM=1" ).append("\n"); 
		query.append("	     ) AS ACT_ATB_INP_DT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT ACT_ATB_INP_USR_ID FROM (" ).append("\n"); 
		query.append("				SELECT T1.*, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) RNUM" ).append("\n"); 
		query.append("				FROM VSK_ACT_PORT_SKD_HIS T1" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("				AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("				AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("				AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("				AND ACT_ATB_INP_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			WHERE RNUM=1" ).append("\n"); 
		query.append("	     ) AS ACT_ATB_INP_USR_ID" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT TO_CHAR(ACT_ATD_INP_DT, 'YYYYMMDDHH24MISS') FROM (" ).append("\n"); 
		query.append("				SELECT T1.*, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) RNUM" ).append("\n"); 
		query.append("				FROM VSK_ACT_PORT_SKD_HIS T1" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("				AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("				AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("				AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("				AND ACT_ATD_INP_DT IS NOT NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			WHERE RNUM=1" ).append("\n"); 
		query.append("	     ) AS ACT_ATD_INP_DT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("			SELECT ACT_ATD_INP_USR_ID FROM (" ).append("\n"); 
		query.append("				SELECT T1.*, ROW_NUMBER() OVER(ORDER BY CNG_SEQ DESC) RNUM" ).append("\n"); 
		query.append("				FROM VSK_ACT_PORT_SKD_HIS T1" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("				AND SKD_VOY_NO=@[skd_voy_no]" ).append("\n"); 
		query.append("				AND SKD_DIR_CD=@[skd_dir_cd]" ).append("\n"); 
		query.append("				AND VPS_PORT_CD=@[vps_port_cd]" ).append("\n"); 
		query.append("				AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("				AND ACT_ATD_INP_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			WHERE RNUM=1" ).append("\n"); 
		query.append("	     ) AS ACT_ATD_INP_USR_ID" ).append("\n"); 
		query.append("       , CASE WHEN T2.VSL_CD IS NOT NULL THEN 'VSK'" ).append("\n"); 
		query.append("              WHEN T3.VSL_CD IS NOT NULL THEN 'VMS'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END AS ACT_SKD_SRC_SYS_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1, VSK_ACT_PORT_SKD T2, FCM_DEP_RPT T3, VSK_VSL_SKD T4" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND	T1.VSL_CD		    = @[vsl_cd]" ).append("\n"); 
		query.append("AND	T1.SKD_VOY_NO		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	T1.SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	T1.VPS_PORT_CD		= @[vps_port_cd]" ).append("\n"); 
		query.append("AND	T1.CLPT_IND_SEQ		= @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND	T1.VSL_CD		    = T2.VSL_CD		    (+)" ).append("\n"); 
		query.append("AND	T1.SKD_VOY_NO		= T2.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("AND	T1.SKD_DIR_CD		= T2.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("AND	T1.VPS_PORT_CD		= T2.VPS_PORT_CD	(+)" ).append("\n"); 
		query.append("AND	T1.CLPT_IND_SEQ		= T2.CLPT_IND_SEQ	(+)" ).append("\n"); 
		query.append("AND	T1.VSL_CD		    = T3.VSL_CD		    (+)" ).append("\n"); 
		query.append("AND	T1.SKD_VOY_NO		= T3.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("AND	T1.SKD_DIR_CD		= T3.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("AND	T1.VPS_PORT_CD		= T3.DEP_PORT_CD	(+)" ).append("\n"); 
		query.append("AND	T1.CLPT_IND_SEQ		= T3.CLPT_IND_SEQ	(+)" ).append("\n"); 
		query.append("AND	T1.VSL_CD           = T4.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO       = T4.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD       = T4.SKD_DIR_CD" ).append("\n"); 

	}
}
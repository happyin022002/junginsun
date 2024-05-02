/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActSkdSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.02 
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

public class ActualScheduleMgtDBDAOActSkdSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.
	  * 사용자가 입력한 조건에 맞는 Port들에 Actual Report 입력 현황을 조회한다.
	  * -------------------------------------------------------------------
	  * ** 변경이력 **
	  * -------------------------------------------------------------------
	  * [CHM-201005472-01]
	  * EGSUZ/PAPAC 보이지 않도록 변경.
	  * -------------------------------------------------------------------
	  * 2010.12.23 선CSR 진마리아  TTL_POR_CNT(Port Calling Count), OVER_INPUT_CNT(Over Inputted Count) 컬럼 추가
	  * 2011.08.09 CHM-201112647-01 김민아 Actual SKD input Ratio Tab 및 조회 로직 변경 요청
	  *                                                         - 페이징 처리를 위한 조건 추가 및 쿼리 수정
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActSkdSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActSkdSumRSQL").append("\n"); 
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
		query.append("SELECT  TARGET_LANE_CNT" ).append("\n"); 
		query.append("       ,TARGET_VVD_CNT" ).append("\n"); 
		query.append("       ,TTL_PORT_CNT" ).append("\n"); 
		query.append("       ,INPUTTED_CNT" ).append("\n"); 
		query.append("       ,OVER_INPUT_CNT" ).append("\n"); 
		query.append("       ,RHQ" ).append("\n"); 
		query.append("       ,CTRL_OFC" ).append("\n"); 
		query.append("       ,PORT_CD" ).append("\n"); 
		query.append("       ,INPUT_RTO" ).append("\n"); 
		query.append("       ,OVERDUE_RTO" ).append("\n"); 
		query.append("       ,TOTAL_CNT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  TARGET_LANE_CNT" ).append("\n"); 
		query.append("                , TARGET_VVD_CNT" ).append("\n"); 
		query.append("                , TTL_PORT_CNT" ).append("\n"); 
		query.append("                , INPUTTED_CNT" ).append("\n"); 
		query.append("                , OVER_INPUT_CNT" ).append("\n"); 
		query.append("                , CASE WHEN GROUPING1 = 1 AND GROUPING2 = 1 AND GROUPING3 = 1 THEN ' '" ).append("\n"); 
		query.append("                       ELSE DECODE(RHQ, 'ZZZ', NULL, RHQ)" ).append("\n"); 
		query.append("                  END                                                                                   AS RHQ" ).append("\n"); 
		query.append("                , CASE WHEN GROUPING1 = 1 AND GROUPING2 = 1 AND GROUPING3 = 1 THEN 'Grand Total' " ).append("\n"); 
		query.append("                       WHEN GROUPING1 = 0 AND GROUPING2 = 1 AND GROUPING3 = 1 THEN ' '" ).append("\n"); 
		query.append("                       ELSE DECODE(CTRL_OFC, 'ZZZ', NULL, CTRL_OFC)" ).append("\n"); 
		query.append("                  END                                                                                   AS CTRL_OFC" ).append("\n"); 
		query.append("                , CASE WHEN GROUPING1 = 1 AND GROUPING2 = 1 AND GROUPING3 = 1 THEN ' '" ).append("\n"); 
		query.append("                       WHEN GROUPING1 = 0 AND GROUPING2 = 1 AND GROUPING3 = 1 THEN 'Sub Total'" ).append("\n"); 
		query.append("                       ELSE PORT_CD" ).append("\n"); 
		query.append("                  END                                                                                    AS PORT_CD" ).append("\n"); 
		query.append("                , ROUND(( INPUTTED_CNT / TTL_PORT_CNT ) * 100, 1)                                       AS INPUT_RTO" ).append("\n"); 
		query.append("                , ROUND(DECODE(OVER_INPUT_CNT, 0, 0, (OVER_INPUT_CNT / INPUTTED_CNT) ) * 100, 1)        AS OVERDUE_RTO" ).append("\n"); 
		query.append("                , COUNT(*) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("        		, ROW_NUMBER() OVER(ORDER BY SEQ01, SEQ02) AS RNUM" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  GROUPING(NVL(T4.VSKD_PORT_RHQ_CD          , 'ZZZ'))                                                               AS GROUPING1" ).append("\n"); 
		query.append("                        , GROUPING(NVL(T4.SLS_OFC_CD             , 'ZZZ'))                                                               AS GROUPING2" ).append("\n"); 
		query.append("                        , GROUPING(NVL(T2.VPS_PORT_CD            , 'ZZZ'))                                                               AS GROUPING3" ).append("\n"); 
		query.append("                        , NVL(T4.VSKD_PORT_RHQ_CD                 , 'ZZZ')                                                                AS RHQ" ).append("\n"); 
		query.append("                        , NVL(T4.SLS_OFC_CD                      , 'ZZZ')                                                                AS CTRL_OFC" ).append("\n"); 
		query.append("                        , NVL(T2.VPS_PORT_CD                     , 'ZZZ')                                                                AS PORT_CD" ).append("\n"); 
		query.append("                        , COUNT(DISTINCT T4.VSKD_PORT_RHQ_CD||T4.SLS_OFC_CD||T2.VPS_PORT_CD||T1.VSL_SLAN_CD)                              AS TARGET_LANE_CNT" ).append("\n"); 
		query.append("                        , COUNT(DISTINCT T4.VSKD_PORT_RHQ_CD||T4.SLS_OFC_CD||T2.VPS_PORT_CD||T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD)     AS TARGET_VVD_CNT" ).append("\n"); 
		query.append("                        , SUM(DECODE(T3.PORT_SKD_STS_CD, 'D', 1, 0))                                                                     AS INPUTTED_CNT" ).append("\n"); 
		query.append("                        , SUM(1)                                                                                                         AS TTL_PORT_CNT" ).append("\n"); 
		query.append("                        , SUM(DECODE(SIGN(T3.ACT_ATD_INP_DT + ((T4.GMT_HRS - T5.GMT_HRS ) / 60 / 24 ) - ( ACT_DEP_DT + 1)), 1, 1, 0))    AS OVER_INPUT_CNT" ).append("\n"); 
		query.append("                        , ROW_NUMBER() OVER (ORDER BY NVL(T4.VSKD_PORT_RHQ_CD, 'ZZZ'))                                                    AS SEQ01" ).append("\n"); 
		query.append("                        , ROW_NUMBER() OVER (PARTITION BY NVL(T4.VSKD_PORT_RHQ_CD, 'ZZZ') ORDER BY NVL(T4.SLS_OFC_CD, 'ZZZ') )            AS SEQ02" ).append("\n"); 
		query.append("                FROM    	VSK_VSL_SKD        	T1" ).append("\n"); 
		query.append("                        , 	VSK_VSL_PORT_SKD 	T2" ).append("\n"); 
		query.append("                        , 	(SELECT * FROM VSK_ACT_PORT_SKD WHERE PORT_SKD_STS_CD = 'D') T3" ).append("\n"); 
		query.append("                        , 	MDM_LOCATION     	T4" ).append("\n"); 
		query.append("                        , 	MDM_LOCATION     	T5" ).append("\n"); 
		query.append("                        , 	MDM_VSL_SVC_LANE 	T6" ).append("\n"); 
		query.append("						,	MDM_VSL_CNTR		VC" ).append("\n"); 
		query.append("                WHERE   1                       = 1" ).append("\n"); 
		query.append("                AND     T1.VSL_CD               = T2.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_VOY_NO           = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T1.SKD_DIR_CD           = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND		T1.VSL_CD				= VC.VSL_CD" ).append("\n"); 
		query.append("                AND     T2.VSL_CD               = T3.VSL_CD         (+)" ).append("\n"); 
		query.append("                AND     T2.SKD_VOY_NO           = T3.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("                AND     T2.SKD_DIR_CD           = T3.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("                AND     T2.VPS_PORT_CD          = T3.VPS_PORT_CD    (+)" ).append("\n"); 
		query.append("                AND     T2.CLPT_IND_SEQ         = T3.CLPT_IND_SEQ   (+)" ).append("\n"); 
		query.append("                AND     T1.VSL_SLAN_CD          = T6.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     T2.VPS_ETD_DT           BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                AND     TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999           " ).append("\n"); 
		query.append("                AND     T2.TURN_PORT_IND_CD     NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                AND     'S'                     !=NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                AND     T2.VPS_PORT_CD          = T4.LOC_CD" ).append("\n"); 
		query.append("                AND     T5.LOC_CD               = 'KRPUS'           /* KRPUS 기준으로 한다 */" ).append("\n"); 
		query.append("                AND     T1.SKD_STS_CD           IN ('ACT', 'CLO')" ).append("\n"); 
		query.append("                AND     T6.VSL_SLAN_CD         != 'GBA'" ).append("\n"); 
		query.append("                AND     T6.VSL_TP_CD       = 'C' /* 컨테이너선 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND			NVL(T1.ACT_CRR_CD,VC.CRR_CD)	= @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("        		AND     T1.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        		AND     T1.SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("        		AND     T1.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("                AND     T2.VPS_PORT_CD          LIKE @[vps_port_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("                AND     T4.VSKD_PORT_RHQ_CD     = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sls_ofc_cd} != '' && ${sls_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("                AND     T4.SLS_OFC_CD          = @[sls_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vsl_svc_tp_cd} == 'O')" ).append("\n"); 
		query.append("                AND     T6.VSL_SVC_TP_CD            = 'O'" ).append("\n"); 
		query.append("        #elseif (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("                AND     NVL(T6.VSL_SVC_TP_CD, ' ') != 'O'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        		AND	(	T6.VSL_SVC_TP_CD != 'O'    /* Feeder가 아닌 경우, BKG 정보와 상관없이 조회 */" ).append("\n"); 
		query.append("        				OR" ).append("\n"); 
		query.append("        				(                          /* Feeder인 경우, BKG 정보가 있는 경우에만 조회 */" ).append("\n"); 
		query.append("        					T6.VSL_SVC_TP_CD = 'O' AND" ).append("\n"); 
		query.append("        					EXISTS (" ).append("\n"); 
		query.append("                               SELECT  'X'" ).append("\n"); 
		query.append("                               FROM    BKG_VVD S1, BKG_BOOKING S2" ).append("\n"); 
		query.append("                               WHERE   1   = 1" ).append("\n"); 
		query.append("                               AND     S1.BKG_NO            = S2.BKG_NO" ).append("\n"); 
		query.append("                               AND     S1.VSL_CD            = T2.VSL_CD" ).append("\n"); 
		query.append("                               AND     S1.SKD_VOY_NO        = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND     S1.SKD_DIR_CD        = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND   ((S1.POL_CD = T2.VPS_PORT_CD AND S1.POL_CLPT_IND_SEQ = T2.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                   OR (S1.POD_CD = T2.VPS_PORT_CD AND S1.POD_CLPT_IND_SEQ = T2.CLPT_IND_SEQ))" ).append("\n"); 
		query.append("                               AND     S2.BKG_STS_CD        !='X'              /* CANCEL된 BOOKING 제외 */" ).append("\n"); 
		query.append("                               AND     S2.BKG_CGO_TP_CD     = 'F'              /* FULL BOOKING        */" ).append("\n"); 
		query.append("                               AND     ROWNUM               = 1" ).append("\n"); 
		query.append("        					)" ).append("\n"); 
		query.append("        				)" ).append("\n"); 
		query.append("        			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        		AND T2.VPS_PORT_CD NOT IN ( 'EGSUZ', 'PAPAC', 'DEKEL' )        /* 2013-07-02::DEKEL제외처리 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                GROUP BY ROLLUP (NVL(T4.VSKD_PORT_RHQ_CD, 'ZZZ'), NVL(T4.SLS_OFC_CD, 'ZZZ'), NVL(T2.VPS_PORT_CD, 'ZZZ'))" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("        WHERE   GROUPING1 + GROUPING2 + GROUPING3 != 1" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("--        ORDER BY SEQ01, SEQ02" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}
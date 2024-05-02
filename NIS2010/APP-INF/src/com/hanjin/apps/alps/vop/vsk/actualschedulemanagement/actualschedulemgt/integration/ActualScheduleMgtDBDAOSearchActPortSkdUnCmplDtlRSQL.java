/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchActPortSkdUnCmplDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.19 
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

public class ActualScheduleMgtDBDAOSearchActPortSkdUnCmplDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ActualScheduleMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.
	  * Actual Schedule이 작성되지 않는 Report를 조회한다.
	  * -------------------------------------------------------------------
	  * ** 변경이력 **
	  * -------------------------------------------------------------------
	  * [CHM-201005472-01]
	  * EGSUZ/PAPAC 보이지 않도록 변경.
	  * 2011.08.09 CHM-201112647-01 김민아 Actual SKD input Ratio Tab 및 조회 로직 변경 요청 - 페이징 처리를 위한 조건 추가 및 쿼리 수정
	  * -------------------------------------------------------------------
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchActPortSkdUnCmplDtlRSQL(){
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
		query.append("FileName : ActualScheduleMgtDBDAOSearchActPortSkdUnCmplDtlRSQL").append("\n"); 
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
		query.append("SELECT  VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,SLS_OFC_CD" ).append("\n"); 
		query.append("       ,VPS_PORT_CD" ).append("\n"); 
		query.append("       ,YD_CD" ).append("\n"); 
		query.append("       ,TML_CD" ).append("\n"); 
		query.append("       ,VVD" ).append("\n"); 
		query.append("       ,VPS_ETA_DT" ).append("\n"); 
		query.append("       ,ACT_ARR_DT" ).append("\n"); 
		query.append("       ,VPS_ETB_DT" ).append("\n"); 
		query.append("       ,ACT_BRTH_DT" ).append("\n"); 
		query.append("       ,VPS_ETD_DT" ).append("\n"); 
		query.append("       ,ACT_DEP_DT" ).append("\n"); 
		query.append("       ,TOTAL_CNT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                , T4.SLS_OFC_CD" ).append("\n"); 
		query.append("                , T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                , T2.YD_CD" ).append("\n"); 
		query.append("                , SUBSTR(T2.YD_CD, 6)                        AS TML_CD" ).append("\n"); 
		query.append("                , T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD    AS VVD" ).append("\n"); 
		query.append("                , TO_CHAR(T2.VPS_ETA_DT, 'YYYYMMDDHH24MI')   AS VPS_ETA_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T3.ACT_ARR_DT, 'YYYYMMDDHH24MI')   AS ACT_ARR_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T2.VPS_ETB_DT, 'YYYYMMDDHH24MI')   AS VPS_ETB_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T3.ACT_BRTH_DT, 'YYYYMMDDHH24MI')  AS ACT_BRTH_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T2.VPS_ETD_DT, 'YYYYMMDDHH24MI')   AS VPS_ETD_DT" ).append("\n"); 
		query.append("                , TO_CHAR(T3.ACT_DEP_DT, 'YYYYMMDDHH24MI')   AS ACT_DEP_DT" ).append("\n"); 
		query.append("                , COUNT(*) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("                , ROWNUM          AS RNUM" ).append("\n"); 
		query.append("        FROM    	VSK_VSL_SKD        	T1 " ).append("\n"); 
		query.append("                , 	VSK_VSL_PORT_SKD 	T2" ).append("\n"); 
		query.append("                , 	VSK_ACT_PORT_SKD 	T3" ).append("\n"); 
		query.append("                , 	MDM_LOCATION     	T4" ).append("\n"); 
		query.append("                , 	MDM_LOCATION     	T5" ).append("\n"); 
		query.append("                , 	MDM_VSL_SVC_LANE 	T6" ).append("\n"); 
		query.append("				,	MDM_VSL_CNTR		VC" ).append("\n"); 
		query.append("        WHERE   1                       = 1" ).append("\n"); 
		query.append("        AND     T1.VSL_CD               = T2.VSL_CD" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO           = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD           = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND		T1.VSL_CD				= VC.VSL_CD" ).append("\n"); 
		query.append("        AND     T2.VSL_CD               = T3.VSL_CD         (+)" ).append("\n"); 
		query.append("        AND     T2.SKD_VOY_NO           = T3.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("        AND     T2.SKD_DIR_CD           = T3.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("        AND     T2.VPS_PORT_CD          = T3.VPS_PORT_CD    (+)" ).append("\n"); 
		query.append("        AND     T2.CLPT_IND_SEQ         = T3.CLPT_IND_SEQ   (+)" ).append("\n"); 
		query.append("        AND     T1.VSL_SLAN_CD          = T6.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND     T2.VPS_ETD_DT           BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                        AND     TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        AND     T2.TURN_PORT_IND_CD     NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("        AND     'S'                    != NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("        AND     T2.VPS_PORT_CD          = T4.LOC_CD" ).append("\n"); 
		query.append("        AND     T5.LOC_CD               = 'KRPUS'           /* KRPUS 기준으로 한다  */" ).append("\n"); 
		query.append("        AND     T1.SKD_STS_CD           IN ('ACT', 'CLO')" ).append("\n"); 
		query.append("        AND     T6.VSL_SLAN_CD         != 'GBA'" ).append("\n"); 
		query.append("        AND     T6.VSL_TP_CD            = 'C' /* 컨테이너선 */" ).append("\n"); 
		query.append("        AND	'D'                    != NVL(T2.PORT_SKD_STS_CD, ' ')" ).append("\n"); 
		query.append("		AND     NVL(VC.VSL_CLSS_FLG,'N' ) <> 'T' 	/*Psuedo 제외*/" ).append("\n"); 
		query.append("		AND     NVL(VC.DELT_FLG,'N') <> 'Y' 		/*삭제된 Vessel 제외*/" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND			NVL(T1.ACT_CRR_CD,VC.CRR_CD)	= @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("        AND     T2.VPS_PORT_CD          LIKE @[vps_port_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("        AND     T4.VSKD_PORT_RHQ_CD      = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sls_ofc_cd} != '' && ${sls_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("        AND     T4.SLS_OFC_CD           = @[sls_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vsl_svc_tp_cd} == 'O')" ).append("\n"); 
		query.append("        AND     T6.VSL_SVC_TP_CD        = 'O'" ).append("\n"); 
		query.append("        #elseif (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("        AND     'O'                    != NVL(T6.VSL_SVC_TP_CD, ' ')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND		(	T6.VSL_SVC_TP_CD != 'O'    /* Feeder가 아닌 경우, BKG 정보와 상관없이 조회 */" ).append("\n"); 
		query.append("        			OR" ).append("\n"); 
		query.append("        			(                          /* Feeder인 경우, BKG 정보가 있는 경우에만 조회 */" ).append("\n"); 
		query.append("        				T6.VSL_SVC_TP_CD = 'O' AND" ).append("\n"); 
		query.append("        				EXISTS  (" ).append("\n"); 
		query.append("                       		SELECT  'X'" ).append("\n"); 
		query.append("                       		FROM    BKG_VVD S1, BKG_BOOKING S2" ).append("\n"); 
		query.append("                       		WHERE   1   = 1" ).append("\n"); 
		query.append("                       		AND     S1.BKG_NO            = S2.BKG_NO" ).append("\n"); 
		query.append("                       		AND     S1.VSL_CD            = T2.VSL_CD" ).append("\n"); 
		query.append("                       		AND     S1.SKD_VOY_NO        = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                       		AND     S1.SKD_DIR_CD        = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                       		AND     ((S1.POL_CD = T2.VPS_PORT_CD AND S1.POL_CLPT_IND_SEQ = T2.CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                            		OR  (S1.POD_CD = T2.VPS_PORT_CD AND S1.POD_CLPT_IND_SEQ = T2.CLPT_IND_SEQ))" ).append("\n"); 
		query.append("                       		AND     S2.BKG_STS_CD       != 'X'              /* CANCEL된 BOOKING 제외 */" ).append("\n"); 
		query.append("                       		AND     S2.BKG_CGO_TP_CD     = 'F'              /* FULL BOOKING        */" ).append("\n"); 
		query.append("                       		AND     ROWNUM               = 1" ).append("\n"); 
		query.append("                       	)" ).append("\n"); 
		query.append("        			)" ).append("\n"); 
		query.append("        		)" ).append("\n"); 
		query.append("        AND T2.VPS_PORT_CD NOT IN ('EGSUZ', 'PAPAC', 'DEKEL')               /* 2013-07-02::DEKEL제외처리 */" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}
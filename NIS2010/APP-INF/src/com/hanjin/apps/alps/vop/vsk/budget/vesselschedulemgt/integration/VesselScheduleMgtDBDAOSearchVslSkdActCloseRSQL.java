/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVslSkdActCloseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.15 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchVslSkdActCloseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Active & Closing VVD 리스트를 조회한다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVslSkdActCloseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVslSkdActCloseRSQL").append("\n"); 
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
		query.append("	, PF_SKD_TP_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, VSL_ENG_NM" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, SKD_STS_CD" ).append("\n"); 
		query.append("	, VIR_SKD_STS_CD" ).append("\n"); 
		query.append("	, TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	, TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("	, SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, CUR_CRR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT  T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("    		, T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("			, T1.VSL_CD" ).append("\n"); 
		query.append("			, T2.VSL_ENG_NM" ).append("\n"); 
		query.append("			, T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			, T1.SKD_STS_CD" ).append("\n"); 
		query.append("			, T1.SKD_STS_CD AS VIR_SKD_STS_CD" ).append("\n"); 
		query.append("			, T4.TURN_SKD_VOY_NO                              AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("			, T4.TURN_SKD_DIR_CD                              AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("			, TO_CHAR(T1.CRE_DT, 'YYYY-MM-DD')                AS CRE_DT" ).append("\n"); 
		query.append("			, TO_CHAR(T1.N1ST_PORT_BRTH_DT, 'YYYY-MM-DD')     AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("			, T1.SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("			, T1.CRE_USR_ID" ).append("\n"); 
		query.append("			, T1.UPD_USR_ID" ).append("\n"); 
		query.append("			, T2.CRR_CD AS CUR_CRR_CD" ).append("\n"); 
		query.append("		FROM    VSK_BUD_VSL_SKD  T1" ).append("\n"); 
		query.append("		, MDM_VSL_CNTR       T2" ).append("\n"); 
		query.append("		, MDM_VSL_SVC_LANE   T3" ).append("\n"); 
		query.append("		, VSK_BUD_VSL_PORT_SKD   T4" ).append("\n"); 
		query.append("		WHERE   1             = 1                " ).append("\n"); 
		query.append("		AND     T1.VSL_CD     = T4.VSL_CD     (+)" ).append("\n"); 
		query.append("		AND     T1.SKD_VOY_NO = T4.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("		AND     T1.SKD_DIR_CD = T4.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("		AND     T3.VSL_TP_CD  = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("		AND     T4.ROWID      = NVL((SELECT /*+ INDEX_ASC(S XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("										S.ROWID /* 일부 SKIP된  PORT일 경우 : SKIP이 아닌 첫번째을 대상으로 함. */" ).append("\n"); 
		query.append("									FROM   VSK_BUD_VSL_PORT_SKD S" ).append("\n"); 
		query.append("									WHERE  1 = 1" ).append("\n"); 
		query.append("									AND    S.VSL_CD        = T1.VSL_CD" ).append("\n"); 
		query.append("									AND    S.SKD_VOY_NO    = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("									AND    S.SKD_DIR_CD    = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("									AND    'S'            != NVL(S.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("									AND    ROWNUM          = 1" ).append("\n"); 
		query.append("									)," ).append("\n"); 
		query.append("									(SELECT /*+ INDEX_ASC(S XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("										S.ROWID /* 모두 SKIP된 PORT일 경우 : DELETE 기능 사용을 위해 조회해야 함. */" ).append("\n"); 
		query.append("									FROM   VSK_BUD_VSL_PORT_SKD S" ).append("\n"); 
		query.append("									WHERE  1 = 1" ).append("\n"); 
		query.append("									AND    S.VSL_CD        = T1.VSL_CD" ).append("\n"); 
		query.append("									AND    S.SKD_VOY_NO    = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("									AND    S.SKD_DIR_CD    = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("									AND    ROWNUM          = 1" ).append("\n"); 
		query.append("									))" ).append("\n"); 
		query.append("		AND     T1.VSL_SLAN_CD     = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("		AND     T3.VSL_SVC_TP_CD  != 'O'" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} == 'F') " ).append("\n"); 
		query.append("		AND     T3.VSL_SVC_TP_CD   = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("                AND     T1.VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("		AND     T1.VSL_CD          LIKE @[vsl_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND     T1.VSL_CD          = T2.VSL_CD" ).append("\n"); 
		query.append("#if (${skd_sts_cd} == 'CLO')" ).append("\n"); 
		query.append("		AND     (T1.SKD_STS_CD    = 'CLO' AND T1.SKD_STS_MNL_FLG = 'N') /* AUTO CLOSE */" ).append("\n"); 
		query.append("#elseif (${skd_sts_cd} == 'RDY')" ).append("\n"); 
		query.append("		AND     (T1.SKD_STS_CD    = 'RDY') /* Ready */" ).append("\n"); 
		query.append("#elseif (${skd_sts_cd} == 'ACT')" ).append("\n"); 
		query.append("		AND     (T1.SKD_STS_CD    = 'ACT' OR T1.SKD_STS_MNL_FLG = 'Y') /* Activate 면서 AUTO CLOSE가 아닌것 */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND     T1.RUSE_PROHI_FLG  = 'N' /* DELETE OR CLOSE 기능을 위한 조회이므로 재무VVD는 조회하지 않음 */" ).append("\n"); 
		query.append("		AND     T1.N1ST_PORT_BRTH_DT != TO_DATE('0001/01/01', 'YYYY/MM/DD') /* 껍데기 VVD 선별, 나중에 삭제 */" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("ORDER BY N1ST_PORT_BRTH_DT" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCstSkdByPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCstSkdByPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Port의 Costal Schedule 정보를 조회합니다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCstSkdByPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_def_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("carrier_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_pgm_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCstSkdByPortRSQL").append("\n"); 
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
		query.append("SELECT  	VSL_CD" ).append("\n"); 
		query.append("        , 	SKD_VOY_NO" ).append("\n"); 
		query.append("        , 	SKD_DIR_CD" ).append("\n"); 
		query.append("        , 	VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT  VSL_ENG_NM" ).append("\n"); 
		query.append("            FROM    MDM_VSL_CNTR   " ).append("\n"); 
		query.append("            WHERE   VSL_CD = T11.VSL_CD" ).append("\n"); 
		query.append("          ) AS VSL_ENG_NM" ).append("\n"); 
		query.append("        , 	VSL_SLAN_CD" ).append("\n"); 
		query.append("        , 	POL_PORT" ).append("\n"); 
		query.append("        , 	POL_YARD " ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT YD_NM " ).append("\n"); 
		query.append("			FROM MDM_YARD" ).append("\n"); 
		query.append("			WHERE YD_CD = POL_YARD " ).append("\n"); 
		query.append("		) AS POL_YARD_NM" ).append("\n"); 
		query.append("        , 	NVL(POL_YARD, '') AS POL_TML_CD " ).append("\n"); 
		query.append("        , 	TO_CHAR(POL_ETA, 'YYYYMMDDHH24MI') AS POL_ETA" ).append("\n"); 
		query.append("        , 	TO_CHAR(POL_ETB, 'YYYYMMDDHH24MI') AS POL_ETB" ).append("\n"); 
		query.append("        , 	TO_CHAR(POL_ETD, 'YYYYMMDDHH24MI') AS POL_ETD" ).append("\n"); 
		query.append("        , 	SUBSTR(NEXT_PORT_ETA, 13, 5 ) AS NEXT_PORT" ).append("\n"); 
		query.append("        , 	SUBSTR(NEXT_PORT_ETA, 18    ) AS NEXT_YARD" ).append("\n"); 
		query.append("        , 	SUBSTR(NEXT_PORT_ETA, 1, 12) AS NEXT_ETA" ).append("\n"); 
		query.append("        , 	TO_CHAR(PF_ETA, 'YYYYMMDDHH24MI') AS PF_ETA" ).append("\n"); 
		query.append("        , 	TO_CHAR(PF_ETB, 'YYYYMMDDHH24MI') AS PF_ETB" ).append("\n"); 
		query.append("        , 	TO_CHAR(PF_ETD, 'YYYYMMDDHH24MI') AS PF_ETD" ).append("\n"); 
		query.append("        , 	ROUND(DECODE(PF_ETA, NULL, 0, POL_ETA - PF_ETA)*24 , 1) AS DELY_ETA_TM" ).append("\n"); 
		query.append("		, 	ROUND(DECODE(PF_ETB, NULL, 0, POL_ETB - PF_ETB)*24 , 1) AS DELY_ETB_TM" ).append("\n"); 
		query.append("        , 	ROUND(DECODE(PF_ETD, NULL, 0, POL_ETD - PF_ETD)*24 , 1) AS DELY_ETD_TM" ).append("\n"); 
		query.append("        , 	CARRIER_CD" ).append("\n"); 
		query.append("        , 	VPS_PORT_CD" ).append("\n"); 
		query.append("        , 	VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("        , 	VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("        , 	'' AS TYPE_CD" ).append("\n"); 
		query.append("        , 	'' AS FM_DT" ).append("\n"); 
		query.append("        , 	'' AS TO_DT" ).append("\n"); 
		query.append("        --, SUBSTR(ACT_SKD, 1, 1 ) DLY_FLG" ).append("\n"); 
		query.append("        , 	SUBSTR(ACT_SKD, 2, 5 ) AS VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append("        , 	TO_NUMBER(SUBSTR(ACT_SKD, 7, 7 )) AS MAJOR_DELY_HR" ).append("\n"); 
		query.append("        , 	DECODE(SUBSTR(ACT_SKD, 14, 3), '000', '', SUBSTR(ACT_SKD, 14, 3)) AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("        , (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("            WHERE INTG_CD_ID = 'CD01830'" ).append("\n"); 
		query.append("              AND INTG_CD_VAL_CTNT = SUBSTR(ACT_SKD, 14, 3)) AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append("        , 	SUBSTR(ACT_SKD, 17) AS VSL_DLAY_RMK" ).append("\n"); 
		query.append("		,	T11.PF_SKD_TP_CD" ).append("\n"); 
		query.append("		,	T11.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT    T1.VSL_CD" ).append("\n"); 
		query.append("					, T1.SKD_VOY_NO" ).append("\n"); 
		query.append("					, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("					, T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    , T2.VPS_PORT_CD AS POL_PORT" ).append("\n"); 
		query.append("                    , T2.YD_CD       AS POL_YARD" ).append("\n"); 
		query.append("                    , T2.VPS_ETA_DT  AS POL_ETA                    " ).append("\n"); 
		query.append("                    , T2.VPS_ETB_DT  AS POL_ETB" ).append("\n"); 
		query.append("                    , T2.VPS_ETD_DT  AS POL_ETD                " ).append("\n"); 
		query.append("                    , T2.PF_ETA_DT   AS PF_ETA              " ).append("\n"); 
		query.append("                    , T2.PF_ETB_DT   AS PF_ETB" ).append("\n"); 
		query.append("                    , T2.PF_ETD_DT   AS PF_ETD" ).append("\n"); 
		query.append("                    , T2.TURN_PORT_IND_CD                    " ).append("\n"); 
		query.append("                    , (" ).append("\n"); 
		query.append("                        SELECT  MAX(TO_CHAR(S1.VPS_ETA_DT, 'YYYYMMDDHH24MI')||S1.VPS_PORT_CD||S1.YD_CD)" ).append("\n"); 
		query.append("                        FROM    VSK_BUD_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                        WHERE   VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("                        AND     SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     CLPT_SEQ =  (" ).append("\n"); 
		query.append("                                                SELECT  MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                FROM    VSK_BUD_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                WHERE   VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("                                                AND     SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                AND     SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                AND     CLPT_SEQ > T2.CLPT_SEQ" ).append("\n"); 
		query.append("                                                AND     (SKD_CNG_STS_CD IS NULL OR SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                      ) AS NEXT_PORT_ETA" ).append("\n"); 
		query.append("					, T3.CRR_CD AS CARRIER_CD--CRR_CD를 가져오기 위해 변경 2014.07.14 이용준" ).append("\n"); 
		query.append("                    , DECODE(T4.VSL_SVC_TP_CD, NULL, 'O', 'O', 'O', 'T') AS VSL_SVC_TP_CD" ).append("\n"); 
		query.append("                    , VPS_PORT_CD" ).append("\n"); 
		query.append("                    , (" ).append("\n"); 
		query.append("                      	SELECT     " ).append("\n"); 
		query.append("                        		DECODE(" ).append("\n"); 
		query.append("                        				SUBSTR(LTRIM(MIN(TO_CHAR(LEVEL, '000')||OFC_CD || PRNT_OFC_CD)), 4)  , " ).append("\n"); 
		query.append("                                		'SINRSSHARC', 'SINRS', SUBSTR(LTRIM(MAX(TO_CHAR(LEVEL, '000')||OFC_CD)), 4)" ).append("\n"); 
		query.append("                                		)" ).append("\n"); 
		query.append("                    		-- 1. 2건에 RHQ Code가 발생할 경우, Level이 낮은 것을 기준으로 하고," ).append("\n"); 
		query.append("                    		-- 2, 'SINRSSHARC'일 경우에는 'SINRS'로 표시하고, 일반적으로는 Level에 Max를 표시한다." ).append("\n"); 
		query.append("                        FROM     MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE    1   = 1" ).append("\n"); 
		query.append("                        AND      OFC_KND_CD  ='2'" ).append("\n"); 
		query.append("                        AND      DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                        START    WITH OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("                        CONNECT BY PRIOR  PRNT_OFC_CD =OFC_CD" ).append("\n"); 
		query.append("                        ) AS VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("                    , 	M.OFC_CD AS VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    , 	VSK_GET_DLY_INFO_FNC(T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ, T2.ACT_INP_FLG) ACT_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("					,	T3.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("            FROM      	VSK_BUD_VSL_SKD 		T1" ).append("\n"); 
		query.append("					, 	VSK_BUD_VSL_PORT_SKD 	T2" ).append("\n"); 
		query.append("					, 	MDM_VSL_CNTR 			T3" ).append("\n"); 
		query.append("					, 	MDM_VSL_SVC_LANE 		T4" ).append("\n"); 
		query.append("					, 	MDM_YARD 				M" ).append("\n"); 
		query.append("					,   MDM_VSL_CNTR            C1--CRR_CD를 가져오기 위해 추가 2014.07.14 이용준" ).append("\n"); 
		query.append("            WHERE   	T1.VSL_CD       		= T2.VSL_CD" ).append("\n"); 
		query.append("            AND     	T1.SKD_VOY_NO   		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     	T1.SKD_DIR_CD   		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     	T1.VSL_CD       		= T3.VSL_CD" ).append("\n"); 
		query.append("            AND     	T1.VSL_SLAN_CD  		= T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("			AND			T1.VSL_CD				= C1.VSL_CD--CRR_CD를 가져오기 위해 추가 2014.07.14 이용준" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("            AND     	T2.VPS_PORT_CD  		= @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_cd} != '') " ).append("\n"); 
		query.append("        	AND     T2.YD_CD IN  (" ).append("\n"); 
		query.append("        						#foreach($key IN ${tml_cd}) " ).append("\n"); 
		query.append("        							#if($velocityCount < $tml_cd.size())" ).append("\n"); 
		query.append("        								'$key'," ).append("\n"); 
		query.append("        							#else" ).append("\n"); 
		query.append("        								'$key'" ).append("\n"); 
		query.append("        							#end" ).append("\n"); 
		query.append("        						#end" ).append("\n"); 
		query.append("        						)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("            AND     T1.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("            AND     T1.VSL_SLAN_CD  LIKE @[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${carrier_cd} != '') " ).append("\n"); 
		query.append("            AND     @[carrier_cd] = NVL(T1.ACT_CRR_CD, T3.CRR_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${et_type} != '' && ${et_type} == 'ETA')" ).append("\n"); 
		query.append("			AND	    T2.VPS_ETA_DT   BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND  TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${et_type} != '' && ${et_type} == 'ETB')" ).append("\n"); 
		query.append("			AND 	T2.VPS_ETB_DT   BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND  TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${et_type} != '' && ${et_type} == 'ETD')" ).append("\n"); 
		query.append("			AND 	T2.VPS_ETD_DT   BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND  TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end	            " ).append("\n"); 
		query.append("            AND     (T2.TURN_PORT_IND_CD IS NULL OR T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("            AND     (T2.SKD_CNG_STS_CD IS NULL OR T2.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("            AND     T4.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("            AND     M.YD_CD = T2.YD_CD" ).append("\n"); 
		query.append("#if (${vop_port_ctrl_ofc_cd} != '') " ).append("\n"); 
		query.append("        	AND     M.OFC_CD IN  (" ).append("\n"); 
		query.append("        						#foreach($key IN ${vop_port_ctrl_ofc_cd}) " ).append("\n"); 
		query.append("        							#if($velocityCount < $vop_port_ctrl_ofc_cd.size())" ).append("\n"); 
		query.append("        								'$key'," ).append("\n"); 
		query.append("        							#else" ).append("\n"); 
		query.append("        								'$key'" ).append("\n"); 
		query.append("        							#end" ).append("\n"); 
		query.append("        						#end" ).append("\n"); 
		query.append("        						)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_def_grp_nm} != '')" ).append("\n"); 
		query.append("			AND     (T2.SLAN_CD,T2.SKD_DIR_CD,T2.VPS_PORT_CD)  IN (" ).append("\n"); 
		query.append("                                                       SELECT  D.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                             , D.DIR_CD" ).append("\n"); 
		query.append("                                                             , D.PORT_CD" ).append("\n"); 
		query.append("                                                       FROM    VSK_USR_DEF_COND_HDR  H" ).append("\n"); 
		query.append("                                                             , VSK_USR_DEF_COND_DTL  D" ).append("\n"); 
		query.append("                                                       WHERE   H.USR_ID              = D.USR_ID" ).append("\n"); 
		query.append("                                                       AND     H.USR_DEF_GRP_NM      = D.USR_DEF_GRP_NM" ).append("\n"); 
		query.append("                                                       AND     H.USE_PGM_NM          = D.USE_PGM_NM " ).append("\n"); 
		query.append("                                                       AND     H.DELT_FLG            = D.DELT_FLG" ).append("\n"); 
		query.append("                                                       AND     H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                                                       AND     H.USR_ID              = @[usr_id]       /* Binding */" ).append("\n"); 
		query.append("                                                       AND     H.USE_PGM_NM          = @[use_pgm_nm]   /* Binding */" ).append("\n"); 
		query.append("                                                       AND     H.USR_DEF_GRP_NM      = @[usr_def_grp_nm]              /* Binding */" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end					" ).append("\n"); 
		query.append("        ) T11" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${type_cd} != '') " ).append("\n"); 
		query.append("AND			VSL_SVC_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("AND     	VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 	VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("		,	VOP_PORT_CTRL_OFC_CD" ).append("\n"); 
		query.append("		,	POL_PORT" ).append("\n"); 
		query.append("		,	POL_YARD" ).append("\n"); 
		query.append("		,	PF_ETA" ).append("\n"); 
		query.append("		,	PF_ETB" ).append("\n"); 
		query.append("		,	PF_ETD" ).append("\n"); 
		query.append("		,	POL_ETA" ).append("\n"); 
		query.append("		,	POL_ETB" ).append("\n"); 
		query.append("		,	POL_ETD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVslSkdActCloseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("     , PF_SKD_TP_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , VSL_ENG_NM" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , SKD_STS_CD" ).append("\n"); 
		query.append("     , VIR_SKD_STS_CD" ).append("\n"); 
		query.append("     , TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("     , TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("     , SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , CUR_CRR_CD" ).append("\n"); 
		query.append("     , ACT_CRR_CD" ).append("\n"); 
		query.append("     , DECODE(VSL_NM_XTER_HIDE_FLG,'Y','1','0') AS VSL_NM_XTER_HIDE_FLG" ).append("\n"); 
		query.append("     , MODI_VOP_TP_CD" ).append("\n"); 
		query.append("     , MODI_VSL_OPR_TP_CD" ).append("\n"); 
		query.append("FROM   (SELECT /*+ ORDERED USE_NL(T1 T2 T3 T4) */" ).append("\n"); 
		query.append("               T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("             , T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("             , T1.VSL_CD" ).append("\n"); 
		query.append("             , T2.VSL_ENG_NM" ).append("\n"); 
		query.append("             , T1.SKD_VOY_NO" ).append("\n"); 
		query.append("             , T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             , DECODE(T1.SKD_STS_CD, 'CLO', 'CLO'" ).append("\n"); 
		query.append("                                , DECODE((SELECT CASE WHEN T4.VPS_ETA_DT > SYSDATE + 3 THEN '1' /* ETA - 3일 전 BOOKING 삭제 가능  */" ).append("\n"); 
		query.append("                                                      ELSE '2' /* ETA - 3일 후 BOOKING 삭제 불가  */" ).append("\n"); 
		query.append("                                                      END" ).append("\n"); 
		query.append("                                FROM   BKG_VVD S1" ).append("\n"); 
		query.append("                                     , BKG_BOOKING S2" ).append("\n"); 
		query.append("                                WHERE  1 = 1" ).append("\n"); 
		query.append("                                AND    S1.BKG_NO = S2.BKG_NO" ).append("\n"); 
		query.append("                                AND    S1.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                                AND    S1.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND    S1.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND    S2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                                AND    ROWNUM = 1), NULL, T1.SKD_STS_CD, '1', 'BKG', '2', 'BKGNOD' )) AS SKD_STS_CD" ).append("\n"); 
		query.append("             , DECODE(T1.SKD_STS_CD, 'CLO', 'CLO'" ).append("\n"); 
		query.append("                       , DECODE(" ).append("\n"); 
		query.append("                               (SELECT /*+ INDEX_ASC(S3 XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                              CASE WHEN S.VPS_ETA_DT > SYSDATE + 3 THEN '1' /* ETA - 3일 전 BOOKING 삭제 가능  */ ELSE '2' /* ETA - 3일 후 BOOKING 삭제 불가  */ END" ).append("\n"); 
		query.append("                                FROM   VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                                WHERE  1 = 1" ).append("\n"); 
		query.append("                                AND    S.VSL_CD = T4.VSL_CD" ).append("\n"); 
		query.append("                                AND    S.SKD_VOY_NO = T4.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND    S.SKD_DIR_CD = T4.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("--::TOP::2014-08-16::------------------------" ).append("\n"); 
		query.append("                                AND    S.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                                AND    ROWNUM = 1" ).append("\n"); 
		query.append("                                AND   EXISTS" ).append("\n"); 
		query.append("                                     (SELECT 'X'" ).append("\n"); 
		query.append("                                      FROM    BKG_VVD S1" ).append("\n"); 
		query.append("                                            , BKG_BOOKING S2" ).append("\n"); 
		query.append("                                      WHERE   1=1" ).append("\n"); 
		query.append("                                      --::TOP::2014-08-16::------------------------" ).append("\n"); 
		query.append("                                        AND    S.VPS_PORT_CD  = S1.POD_CD" ).append("\n"); 
		query.append("                                        AND    S.CLPT_IND_SEQ = S1.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        AND    S1.BKG_NO      = S2.BKG_NO" ).append("\n"); 
		query.append("                                        AND    S1.VSL_CD      = S.VSL_CD" ).append("\n"); 
		query.append("                                        AND    S1.SKD_VOY_NO  = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND    S1.SKD_DIR_CD  = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND    S2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                                        AND    'S' != NVL(S.SKD_CNG_STS_CD, ' ') /* 일부 SKIP된  PORT일 경우 : SKIP이 아닌 첫번째을 대상으로 함. */" ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        SELECT 'X'" ).append("\n"); 
		query.append("                                        FROM    BKG_VVD S1" ).append("\n"); 
		query.append("                                                    , BKG_BOOKING S2" ).append("\n"); 
		query.append("                                        WHERE   1=1" ).append("\n"); 
		query.append("                                              --::TOP::2014-08-16::------------------------" ).append("\n"); 
		query.append("                                        AND    S.VPS_PORT_CD  = S1.POD_CD" ).append("\n"); 
		query.append("                                        AND    S.CLPT_IND_SEQ = S1.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        AND    S1.BKG_NO      = S2.BKG_NO" ).append("\n"); 
		query.append("                                        AND    S1.VSL_CD      = S.VSL_CD" ).append("\n"); 
		query.append("                                        AND    S1.SKD_VOY_NO  = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND    S1.SKD_DIR_CD  = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND    S2.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("                                        /* 모두 SKIP된 PORT일 경우 : DELETE 기능 사용을 위해 조회해야 함. */" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                ), NULL, T1.SKD_STS_CD, '1', 'BKG', '2', 'BKGNOD' )) AS VIR_SKD_STS_CD" ).append("\n"); 
		query.append("             , T4.TURN_SKD_VOY_NO AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("             , T4.TURN_SKD_DIR_CD AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("             , TO_CHAR(T1.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("             , TO_CHAR(T4.VPS_ETB_DT, 'YYYY-MM-DD') AS N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("             , T1.SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("             , T1.CRE_USR_ID" ).append("\n"); 
		query.append("             , T1.UPD_USR_ID" ).append("\n"); 
		query.append("             , T2.CRR_CD AS CUR_CRR_CD" ).append("\n"); 
		query.append("             , T1.ACT_CRR_CD" ).append("\n"); 
		query.append("             , T1.VSL_NM_XTER_HIDE_FLG" ).append("\n"); 
		query.append("             , T1.MODI_VOP_TP_CD" ).append("\n"); 
		query.append("             , T2.MODI_VSL_OPR_TP_CD" ).append("\n"); 
		query.append("        FROM   VSK_VSL_SKD T1" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE T3" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD T4" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    T1.VSL_CD = T4.VSL_CD (+)" ).append("\n"); 
		query.append("        AND    T1.SKD_VOY_NO = T4.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("        AND    T1.SKD_DIR_CD = T4.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("        AND    T3.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("        AND    T4.ROWID = NVL(" ).append("\n"); 
		query.append("                        (SELECT /*+ INDEX_ASC(S XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                          S.ROWID /* 일부 SKIP된  PORT일 경우 : SKIP이 아닌 첫번째을 대상으로 함. */" ).append("\n"); 
		query.append("                        FROM   VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                        WHERE  1 = 1" ).append("\n"); 
		query.append("                        AND    S.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                        AND    S.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    S.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND    'S' != NVL(S.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                        AND    ROWNUM = 1 ), " ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_ASC(S XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                          S.ROWID /* 모두 SKIP된 PORT일 경우 : DELETE 기능 사용을 위해 조회해야 함. */" ).append("\n"); 
		query.append("                        FROM   VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                        WHERE  1 = 1" ).append("\n"); 
		query.append("                        AND    S.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                        AND    S.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    S.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND    ROWNUM = 1 ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    T1.VSL_SLAN_CD 	= T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND    T1.VSL_CD 		= T2.VSL_CD 		(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("		AND     T3.VSL_SVC_TP_CD  != 'O'" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} == 'F') " ).append("\n"); 
		query.append("		AND     T3.VSL_SVC_TP_CD   = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("                AND     T1.VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("				AND     T1.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skd_sts_cd} == 'CLO')" ).append("\n"); 
		query.append("		AND     (T1.SKD_STS_CD    = 'CLO' ) /* AUTO CLOSE */" ).append("\n"); 
		query.append("#elseif (${skd_sts_cd} == 'RDY')" ).append("\n"); 
		query.append("		AND     (T1.SKD_STS_CD    = 'RDY') /* Ready */" ).append("\n"); 
		query.append("#elseif (${skd_sts_cd} == 'ACT')" ).append("\n"); 
		query.append("		AND     (T1.SKD_STS_CD    = 'ACT' ) /* Activate 면서 AUTO CLOSE가 아닌것 */" ).append("\n"); 
		query.append("#elseif (${skd_sts_cd} == 'MSK')" ).append("\n"); 
		query.append("		AND     (T1.VSL_NM_XTER_HIDE_FLG	= 'Y' ) /* Masked VVD */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		--::2015-06-09::-- AND     T1.RUSE_PROHI_FLG  = 'N' /* DELETE OR CLOSE 기능을 위한 조회이므로 재무VVD는 조회하지 않음 */" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY MIN(N1ST_PORT_BRTH_DT) OVER(PARTITION BY VSL_CD, SKD_VOY_NO), N1ST_PORT_BRTH_DT" ).append("\n"); 

	}
}
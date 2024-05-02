/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchActualTargetLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchActualTargetLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchActualTargetLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchActualTargetLaneRSQL").append("\n"); 
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
		query.append("SELECT  T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("        , VSL_SLAN_NM" ).append("\n"); 
		query.append("        , 'Y' AS ACT_SKD_TGT_FLG" ).append("\n"); 
		query.append("        , DECODE(VSL_SVC_TP_CD, 'O', 'O', 'T') AS VSL_SVC_TP_CD" ).append("\n"); 
		query.append("FROM	VSK_VSL_SKD 		T1" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD	T2" ).append("\n"); 
		query.append("        , MDM_VSL_SVC_LANE	T3" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND     T1.VSL_CD         = T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO     = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD     = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VSL_SLAN_CD    = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T1.SKD_STS_CD     IN ('ACT', 'CLO')" ).append("\n"); 
		query.append("AND     'S'               != NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("AND     T3.VSL_TP_CD       = 'C' /* 컨테이너선 */" ).append("\n"); 
		query.append("AND     T2.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND     TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#if (${vsl_svc_tp_cd} == 'T') " ).append("\n"); 
		query.append("AND     'O'               != NVL(T3.VSL_SVC_TP_CD, ' ')" ).append("\n"); 
		query.append("#elseif (${vsl_svc_tp_cd} == 'O') " ).append("\n"); 
		query.append("AND     VSL_SVC_TP_CD      = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     EXISTS" ).append("\n"); 
		query.append("        (   SELECT  'X'" ).append("\n"); 
		query.append("            FROM    BKG_VVD S, BKG_BOOKING S1" ).append("\n"); 
		query.append("            WHERE   1   = 1" ).append("\n"); 
		query.append("            AND	    S.BKG_NO            = S1.BKG_NO" ).append("\n"); 
		query.append("            AND     S1.BKG_STS_CD      != 'X'" ).append("\n"); 
		query.append("            AND     S1.BKG_CGO_TP_CD    = 'F'              /* FULL BOOKING      */" ).append("\n"); 
		query.append("            AND     S.VSL_CD            = T2.VSL_CD" ).append("\n"); 
		query.append("            AND     S.SKD_VOY_NO        = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     S.SKD_DIR_CD        = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND   ((S.POL_CD = T2.VPS_PORT_CD AND S.POL_CLPT_IND_SEQ = T2.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                OR (S.POD_CD = T2.VPS_PORT_CD AND S.POD_CLPT_IND_SEQ = T2.CLPT_IND_SEQ))" ).append("\n"); 
		query.append("            AND     ROWNUM              = 1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY T1.VSL_SLAN_CD, VSL_SLAN_NM, DECODE(VSL_SVC_TP_CD, 'O', 'O', 'T')" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}
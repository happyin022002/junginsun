/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationDBDAOSearchSPQualitativeEvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.04.03 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationDBDAOSearchSPQualitativeEvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/P Qualitative Evaulation Inquiry 조회
	  * </pre>
	  */
	public QualitativeEvaluationDBDAOSearchSPQualitativeEvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationDBDAOSearchSPQualitativeEvRSQL").append("\n"); 
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
		query.append("SELECT A.EV_YR" ).append("\n"); 
		query.append("     , A.EG_ID" ).append("\n"); 
		query.append("     , LPAD(A.SP_SEQ, 6, '0') AS SP_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.SP_SEQ) AS SP_NAME" ).append("\n"); 
		query.append("     , A.EV_MON" ).append("\n"); 
		query.append("     , A.QUAL_EV_SEQ" ).append("\n"); 
		query.append("     , A.EV_AREA_CTNT" ).append("\n"); 
		query.append("     , A.EV_FCTR_CTNT" ).append("\n"); 
		query.append("     , A.EV_WGT_RT" ).append("\n"); 
		query.append("     , A.N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append("     , A.N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append("     , A.N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append("     , CASE WHEN A.EV_GRD_CHK_CD = 'A'" ).append("\n"); 
		query.append("            THEN '1' ELSE '0' END AS GRADE_A" ).append("\n"); 
		query.append("     , CASE WHEN A.EV_GRD_CHK_CD = 'B'" ).append("\n"); 
		query.append("            THEN '1' ELSE '0' END AS GRADE_B" ).append("\n"); 
		query.append("     , CASE WHEN A.EV_GRD_CHK_CD = 'C'" ).append("\n"); 
		query.append("            THEN '1' ELSE '0' END AS GRADE_C" ).append("\n"); 
		query.append("     , A.EV_WGT_RSLT_RT" ).append("\n"); 
		query.append("     , CASE WHEN A.EV_MON = '01' THEN 'JAN'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '02' THEN 'FEB'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '03' THEN 'MAR'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '04' THEN 'APR'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '05' THEN 'MAY'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '06' THEN 'JUN'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '07' THEN 'JUL'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '08' THEN 'AUG'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '09' THEN 'SEP'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '10' THEN 'OCT'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '11' THEN 'NOV'" ).append("\n"); 
		query.append("            WHEN A.EV_MON = '12' THEN 'DEC'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS CRE_DT" ).append("\n"); 
		query.append("  FROM SPE_SP_QUAL_EV A" ).append("\n"); 
		query.append("     , SPE_EV_GRP B" ).append("\n"); 
		query.append(" WHERE A.EG_ID = B.EG_ID" ).append("\n"); 
		query.append("   AND A.EV_YR              = @[s_ev_yr]" ).append("\n"); 
		query.append("   AND A.EVR_USR_ID         = @[cre_usr_id]" ).append("\n"); 
		query.append("#if(${s_sp_seq}!='')" ).append("\n"); 
		query.append("   AND A.SP_SEQ             = @[s_sp_seq]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if(${s_ev_mon}!='')" ).append("\n"); 
		query.append("   AND TO_NUMBER(A.EV_MON)  = @[s_ev_mon]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if(${s_eg_rhq_cd}!='')" ).append("\n"); 
		query.append("   AND B.EG_RHQ_CD          = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eg_ofc_cd}!='')" ).append("\n"); 
		query.append("   AND B.EG_OFC_CD          = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ev_svc_cate_cd}!='')" ).append("\n"); 
		query.append("   AND B.EV_SVC_CATE_CD     = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.EV_YR,A.EV_MON,A.SP_SEQ" ).append("\n"); 

	}
}
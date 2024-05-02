/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageDBDAOSearchEGTerminalKpiManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupTerminalKpiManageDBDAOSearchEGTerminalKpiManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Productivity
	  * </pre>
	  */
	public EvaluationGroupTerminalKpiManageDBDAOSearchEGTerminalKpiManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupTerminalKpiManageDBDAOSearchEGTerminalKpiManageRSQL").append("\n"); 
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
		query.append("B.EV_YR," ).append("\n"); 
		query.append("B.EG_ID," ).append("\n"); 
		query.append("B.EG_ID_SEQ," ).append("\n"); 
		query.append("A.REG_GROUP," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("Y.YD_CD," ).append("\n"); 
		query.append("Y.YD_NM," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("A.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' AS PER," ).append("\n"); 
		query.append("'' AS TARGET," ).append("\n"); 
		query.append("B.KPI_TGT_RTO||DECODE(B.KPI_UT_CD, 'PC', '%' , 'PO', 'PT' , 'MM', 'MM') AS KPI_TGT_RTO," ).append("\n"); 
		query.append("B.KPI_UT_CD," ).append("\n"); 
		query.append("M.KPI_WGT_RTO," ).append("\n"); 
		query.append("A.ENG_VNDR_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT D.EG_ID," ).append("\n"); 
		query.append("D.EG_ID_SEQ," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', 'NYC', 'A', 'SHA') AS REG_GROUP ," ).append("\n"); 
		query.append("V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("D.ENG_VNDR_RMK" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B," ).append("\n"); 
		query.append("MDM_VENDOR V," ).append("\n"); 
		query.append("SPE_EV_GRP_SVC_PROV_MTCH D" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND V.OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("AND V.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("SPE_EV_GRP_TML_KPI_TGT_RTO B," ).append("\n"); 
		query.append("MDM_YARD Y," ).append("\n"); 
		query.append("SPE_EV_GRP_KPI_TGT_RTO M" ).append("\n"); 
		query.append("WHERE A.EG_ID||A.EG_ID_SEQ = B.EG_ID||B.EG_ID_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND B.YD_CD    = Y.YD_CD" ).append("\n"); 
		query.append("AND B.EV_YR    = M.EV_YR" ).append("\n"); 
		query.append("AND B.YD_CD    = UPPER(@[yd_cd])" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND B.EV_YR    = @[ev_yr]" ).append("\n"); 
		query.append("AND A.EG_ID||A.EG_ID_SEQ = M.EG_ID||M.EG_ID_SEQ" ).append("\n"); 
		query.append("AND M.SP_KPI_CD = 'TMLP'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("M.EV_YR," ).append("\n"); 
		query.append("D.EG_ID," ).append("\n"); 
		query.append("D.EG_ID_SEQ," ).append("\n"); 
		query.append("DECODE(B.CONTI_CD, 'F', 'HAM', 'E', 'HAM', 'M', 'NYC', 'A', 'SHA') AS REG_GROUP," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("Y.YD_CD," ).append("\n"); 
		query.append("Y.YD_NM," ).append("\n"); 
		query.append("V.VNDR_SEQ," ).append("\n"); 
		query.append("V.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' AS PER," ).append("\n"); 
		query.append("'' AS TARGET," ).append("\n"); 
		query.append("'' AS KPI_TGT_RTO," ).append("\n"); 
		query.append("'' AS KPI_UT_CD," ).append("\n"); 
		query.append("DECODE( M.SP_KPI_CD, 'TMLP', M.KPI_WGT_RTO, 0)," ).append("\n"); 
		query.append("D.ENG_VNDR_RMK" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_LOCATION B," ).append("\n"); 
		query.append("MDM_VENDOR V," ).append("\n"); 
		query.append("SPE_EV_GRP_SVC_PROV_MTCH D," ).append("\n"); 
		query.append("MDM_YARD Y," ).append("\n"); 
		query.append("SPE_EV_GRP_KPI_TGT_RTO M" ).append("\n"); 
		query.append("WHERE A.LOC_CD  = B.LOC_CD" ).append("\n"); 
		query.append("AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND V.OFC_CD  = A.OFC_CD" ).append("\n"); 
		query.append("AND V.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("AND M.EV_YR =  @[ev_yr]" ).append("\n"); 
		query.append("AND V.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND YD_CD = UPPER(@[yd_cd])" ).append("\n"); 
		query.append("AND M.SP_KPI_CD = 'TMLP'" ).append("\n"); 
		query.append("AND D.EG_ID||D.EG_ID_SEQ = M.EG_ID||M.EG_ID_SEQ" ).append("\n"); 
		query.append("AND D.EG_ID||D.EG_ID_SEQ||'TMLP' NOT IN (  SELECT D.EG_ID||D.EG_ID_SEQ||D.SP_KPI_CD" ).append("\n"); 
		query.append("FROM SPE_EV_GRP_TML_KPI_TGT_RTO D" ).append("\n"); 
		query.append("WHERE EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("AND YD_CD = UPPER(@[yd_cd])" ).append("\n"); 
		query.append("AND VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("AND SP_KPI_CD = 'TMLP' )" ).append("\n"); 

	}
}
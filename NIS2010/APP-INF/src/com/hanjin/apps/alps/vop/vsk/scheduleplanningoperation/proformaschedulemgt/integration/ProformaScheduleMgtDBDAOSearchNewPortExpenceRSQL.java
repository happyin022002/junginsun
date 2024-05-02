/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchNewPortExpenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.01.29 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchNewPortExpenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNewPortExpence
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchNewPortExpenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eventNav",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vsl_clss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchNewPortExpenceRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(YD_CD,6,7) AS YD_CD" ).append("\n"); 
		query.append(", PORT_ROTN_SEQ" ).append("\n"); 
		query.append(", SUM(CLASS01) AS SUM_CLASS01" ).append("\n"); 
		query.append(", SUM(CLASS02) AS SUM_CLASS02" ).append("\n"); 
		query.append(", SUM(CLASS03) AS SUM_CLASS03" ).append("\n"); 
		query.append(", ROUND((SUM(NVL(CLASS01,0))+SUM(NVL(CLASS02,0))+SUM(NVL(CLASS03,0)) ) / MAX(CLASS_CNT), 2) AS CLASS_AVG" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", PORT_CD" ).append("\n"); 
		query.append(", CLPT_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("/* X02 : Start */" ).append("\n"); 
		query.append("SELECT  VSL_SLAN_CD" ).append("\n"); 
		query.append(", PF_SVC_TP_CD" ).append("\n"); 
		query.append(", T11.YD_CD AS YD_CD, PORT_ROTN_SEQ" ).append("\n"); 
		query.append(", VSL_CLASS" ).append("\n"); 
		query.append(", CLASS_CNT" ).append("\n"); 
		query.append(", SUM(DECODE(SEQ, 1, TTL_CHG_AMT)) CLASS01" ).append("\n"); 
		query.append(", SUM(DECODE(SEQ, 2, TTL_CHG_AMT)) CLASS02" ).append("\n"); 
		query.append(", SUM(DECODE(SEQ, 3, TTL_CHG_AMT)) CLASS03" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", PORT_CD" ).append("\n"); 
		query.append(", CLPT_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("/* X01 : Start */" ).append("\n"); 
		query.append("SELECT  VSL_SLAN_CD, PF_SVC_TP_CD" ).append("\n"); 
		query.append(", YD_CD, PORT_ROTN_SEQ" ).append("\n"); 
		query.append(", SEQ" ).append("\n"); 
		query.append(", CASE WHEN (N1ST_VSL_CLSS_CD IS NULL OR N1ST_VSL_CLSS_CD = '0') THEN 0 ELSE 1 END +" ).append("\n"); 
		query.append("CASE WHEN (N2ND_VSL_CLSS_CD IS NULL OR N2ND_VSL_CLSS_CD = '0') THEN 0 ELSE 1 END +" ).append("\n"); 
		query.append("CASE WHEN (N3RD_VSL_CLSS_CD IS NULL OR N3RD_VSL_CLSS_CD = '0') THEN 0 ELSE 1 END" ).append("\n"); 
		query.append("AS CLASS_CNT /* 투입된 VESSEL CLASS 종류를 COUNT*/" ).append("\n"); 
		query.append(", DECODE(SEQ, 1, N1ST_VSL_CLSS_CD, 2, N2ND_VSL_CLSS_CD, 3, N3RD_VSL_CLSS_CD) AS VSL_CLASS" ).append("\n"); 
		query.append(", SKD_DIR_CD,PORT_CD,CLPT_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("/* X00 : Start */" ).append("\n"); 
		query.append("SELECT  SEQ, T01.VSL_SLAN_CD, T01.PF_SVC_TP_CD" ).append("\n"); 
		query.append(",T02.YD_CD, T02.PORT_ROTN_SEQ," ).append("\n"); 
		query.append("DECODE(@[eventNav], 'R', N1ST_VSL_CLSS_CD,  @[n1st_vsl_clss_cd])  AS N1ST_VSL_CLSS_CD," ).append("\n"); 
		query.append("DECODE(@[eventNav], 'R', N1ST_VSL_CLSS_KNT, @[n1st_vsl_clss_knt]) AS N1ST_VSL_CLSS_KNT," ).append("\n"); 
		query.append("DECODE(@[eventNav], 'R', N2ND_VSL_CLSS_CD,  @[n2nd_vsl_clss_cd])  AS N2ND_VSL_CLSS_CD," ).append("\n"); 
		query.append("DECODE(@[eventNav], 'R', N2ND_VSL_CLSS_KNT, @[n2nd_vsl_clss_knt]) AS N2ND_VSL_CLSS_KNT," ).append("\n"); 
		query.append("DECODE(@[eventNav], 'R', N3RD_VSL_CLSS_CD,  @[n3rd_vsl_clss_cd])  AS N3RD_VSL_CLSS_CD," ).append("\n"); 
		query.append("DECODE(@[eventNav], 'R', N3RD_VSL_CLSS_KNT, @[n3rd_vsl_clss_knt]) AS N3RD_VSL_CLSS_KNT," ).append("\n"); 
		query.append("T02.SKD_DIR_CD,T02.PORT_CD,T02.CLPT_SEQ" ).append("\n"); 
		query.append("FROM    VSK_PF_SKD T01, VSK_PF_SKD_DTL T02" ).append("\n"); 
		query.append(", (SELECT 1 SEQ FROM DUAL UNION ALL SELECT 2 FROM DUAL UNION ALL SELECT 3 FROM DUAL)" ).append("\n"); 
		query.append("WHERE   T01.VSL_SLAN_CD     = T02.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T01.PF_SVC_TP_CD    = T02.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND     T01.VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND     T01.PF_SVC_TP_CD    = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND     T02.TURN_PORT_IND_CD!= 'F'" ).append("\n"); 
		query.append("/* X00 : End */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/* X01 : End */" ).append("\n"); 
		query.append(") T11, PSO_VSL_CLSS_TRF T12" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     T12.BSE_YR              (+) = @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND     T12.BSE_QTR_CD          (+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND     T12.CNTR_VSL_CLSS_CAPA  (+) = T11.VSL_CLASS" ).append("\n"); 
		query.append("AND     T12.YD_CD               (+) = T11.YD_CD" ).append("\n"); 
		query.append("GROUP BY VSL_SLAN_CD, PF_SVC_TP_CD, T11.YD_CD, PORT_ROTN_SEQ, VSL_CLASS, CLASS_CNT" ).append("\n"); 
		query.append(", SKD_DIR_CD, PORT_CD, CLPT_SEQ" ).append("\n"); 
		query.append("/* X02 : End */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("GROUP BY YD_CD, PORT_ROTN_SEQ, SKD_DIR_CD, PORT_CD, CLPT_SEQ" ).append("\n"); 
		query.append("ORDER BY PORT_ROTN_SEQ" ).append("\n"); 

	}
}
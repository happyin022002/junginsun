/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchPortExpenceByClassRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2010.02.02 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchPortExpenceByClassRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPortExpenceByClass
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchPortExpenceByClassRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_class02",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_class03",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_class01",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchPortExpenceByClassRSQL").append("\n"); 
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
		query.append("SELECT	CLASS01 AS SUM_CLASS01, CLASS02 AS SUM_CLASS02, CLASS03 AS SUM_CLASS03," ).append("\n"); 
		query.append("ROUND((NVL(CLASS01, 0) + NVL(CLASS02, 0) + NVL(CLASS03, 0)) / CLASS_CNT, 2) AS CLASS_AVG" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	SUM(DECODE(CNTR_VSL_CLSS_CAPA, @[vsl_class01], TTL_CHG_AMT)) AS CLASS01" ).append("\n"); 
		query.append(", SUM(DECODE(CNTR_VSL_CLSS_CAPA, @[vsl_class02], TTL_CHG_AMT)) AS CLASS02" ).append("\n"); 
		query.append(", SUM(DECODE(CNTR_VSL_CLSS_CAPA, @[vsl_class03], TTL_CHG_AMT)) AS CLASS03" ).append("\n"); 
		query.append(", DECODE(@[vsl_class01], NULL, 0, 1) + DECODE(@[vsl_class02], NULL, 0, 1) + DECODE(@[vsl_class03], NULL, 0, 1) AS CLASS_CNT" ).append("\n"); 
		query.append("FROM	PSO_VSL_CLSS_TRF" ).append("\n"); 
		query.append("WHERE	BSE_YR		= @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND		BSE_QTR_CD	= @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND		YD_CD		= @[port_cd]||@[yd_cd]" ).append("\n"); 
		query.append("AND		CNTR_VSL_CLSS_CAPA	IN (@[vsl_class01], @[vsl_class02], @[vsl_class03])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
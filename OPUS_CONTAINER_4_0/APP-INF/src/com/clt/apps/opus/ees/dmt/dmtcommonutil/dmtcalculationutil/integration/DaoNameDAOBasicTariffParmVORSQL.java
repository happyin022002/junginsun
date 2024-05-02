/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOBasicTariffParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.19 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOBasicTariffParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public DaoNameDAOBasicTariffParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOBasicTariffParmVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' POR_CONTI_CD" ).append("\n"); 
		query.append(",'' POR_CNT_CD" ).append("\n"); 
		query.append(",'' POR_RGN_CD" ).append("\n"); 
		query.append(",'' POR_STE_CD" ).append("\n"); 
		query.append(",'' POR_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' YRD_CONTI_CD" ).append("\n"); 
		query.append(",'' YRD_CNT_CD" ).append("\n"); 
		query.append(",'' YRD_RGN_CD" ).append("\n"); 
		query.append(",'' YRD_STE_CD" ).append("\n"); 
		query.append(",'' YRD_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' POL_CONTI_CD" ).append("\n"); 
		query.append(",'' POL_CNT_CD" ).append("\n"); 
		query.append(",'' POL_RGN_CD" ).append("\n"); 
		query.append(",'' POL_STE_CD" ).append("\n"); 
		query.append(",'' POL_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' DEL_CONTI_CD" ).append("\n"); 
		query.append(",'' DEL_CNT_CD" ).append("\n"); 
		query.append(",'' DEL_RGN_CD" ).append("\n"); 
		query.append(",'' DEL_STE_CD" ).append("\n"); 
		query.append(",'' DEL_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' EFF_DT" ).append("\n"); 
		query.append(",'' DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",'' DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append(",'' AWK_IN_OUT" ).append("\n"); 
		query.append(",'' SUTH_CHN_USE_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' CVRG_YD_CD" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}
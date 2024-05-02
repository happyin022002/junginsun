/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOBasicTariffKeyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.19 최성환
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

public class DaoNameDAOBasicTariffKeyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public DaoNameDAOBasicTariffKeyVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' TRF_SEQ" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",''	DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append(",'' CMNC_HR" ).append("\n"); 
		query.append(",'' XCLD_SAT_FLG" ).append("\n"); 
		query.append(",'' XCLD_SUN_FLG" ).append("\n"); 
		query.append(",'' XCLD_HOL_FLG" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append(",'' MSG_CD" ).append("\n"); 
		query.append(",'' MSG_DESC" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOBasicTariffKeyVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
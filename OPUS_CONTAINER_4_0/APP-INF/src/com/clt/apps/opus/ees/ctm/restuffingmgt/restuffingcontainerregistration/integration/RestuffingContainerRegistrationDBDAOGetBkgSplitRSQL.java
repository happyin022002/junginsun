/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RestuffingContainerRegistrationDBDAOGetBkgSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.06 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RestuffingContainerRegistrationDBDAOGetBkgSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CONTAINER 에서 SPLIT된 부킹을 찾아온다
	  * </pre>
	  */
	public RestuffingContainerRegistrationDBDAOGetBkgSplitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration").append("\n"); 
		query.append("FileName : RestuffingContainerRegistrationDBDAOGetBkgSplitRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("BKG.BL_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_CYC_NO = (SELECT MAX (CNMV_CYC_NO)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNMV_CYC_NO != '9999')" ).append("\n"); 
		query.append("AND CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 

	}
}
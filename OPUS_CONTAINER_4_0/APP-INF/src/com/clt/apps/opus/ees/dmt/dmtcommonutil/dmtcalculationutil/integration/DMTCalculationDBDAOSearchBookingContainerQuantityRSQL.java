/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBookingContainerQuantityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.18 최성환
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

public class DMTCalculationDBDAOSearchBookingContainerQuantityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBookingContainerQuantity
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBookingContainerQuantityRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT COUNT (CNTR_NO) BKGQTY" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBookingContainerQuantityRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
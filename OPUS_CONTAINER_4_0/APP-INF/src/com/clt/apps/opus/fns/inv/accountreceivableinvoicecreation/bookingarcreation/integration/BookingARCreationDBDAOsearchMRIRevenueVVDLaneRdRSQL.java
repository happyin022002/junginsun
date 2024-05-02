/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL").append("\n"); 
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
		query.append("SELECT MAX(RLANE_CD) REV_LANE" ).append("\n"); 
		query.append("     , MAX(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) REV_VVD" ).append("\n"); 
		query.append("  FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append(" WHERE VSL_CD = DECODE(@[vsl], 'COMC', @[vsl], 'USAC', @[vsl],  DECODE(@[vsl], 'CNTC', 'CNTC', 'CFDR'))" ).append("\n"); 
		query.append("   AND REV_YRMON = (SELECT MAX(REV_YRMON)" ).append("\n"); 
		query.append("                      FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("                     WHERE VSL_CD = DECODE(@[vsl], 'COMC', @[vsl], 'USAC', @[vsl], DECODE(@[vsl], 'CNTC', 'CNTC', 'CFDR')))" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SalesRPTDBDAOIsDeleteBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.03.18 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOIsDeleteBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제된 Booking인지조회
	  * </pre>
	  */
	public SalesRPTDBDAOIsDeleteBookingRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOIsDeleteBookingRSQL").append("\n"); 
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
		query.append("SELECT  a.bkg_sts_cd" ).append("\n"); 
		query.append("FROM  MAS_RGST_BKG a" ).append("\n"); 
		query.append(",BKG_BOOKING b" ).append("\n"); 
		query.append("WHERE  a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("AND  a.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}
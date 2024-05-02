/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOsearchMdmVslSvcLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchMdmVslSvcLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Code정합성조회
	  * </pre>
	  */
	public BookingUtilDBDAOsearchMdmVslSvcLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchMdmVslSvcLaneRSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD FROM " ).append("\n"); 
		query.append("MDM_SVC_SCP_LANE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND VSL_SLAN_CD =@[slan_cd]" ).append("\n"); 

	}
}
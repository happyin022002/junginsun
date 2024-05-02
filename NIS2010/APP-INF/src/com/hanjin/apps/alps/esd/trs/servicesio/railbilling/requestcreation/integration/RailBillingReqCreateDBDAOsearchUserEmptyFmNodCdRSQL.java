/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchUserEmptyFmNodCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.20 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchUserEmptyFmNodCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUserEmptyFmNodCd
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchUserEmptyFmNodCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration ").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchUserEmptyFmNodCdRSQL").append("\n"); 
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
		query.append("SELECT /*+ index_desc(a XAK11TRS_TRSP_RAIL_BIL_ORD)*/" ).append("\n"); 
		query.append("fm_nod_cd" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append("WHERE prov_usr_id = @[prov_usr_id]" ).append("\n"); 
		query.append("AND cgo_tp_cd = 'M'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
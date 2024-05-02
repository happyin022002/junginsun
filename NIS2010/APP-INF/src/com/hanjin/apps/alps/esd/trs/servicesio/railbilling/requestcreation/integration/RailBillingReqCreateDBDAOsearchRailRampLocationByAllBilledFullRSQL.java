/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchRailRampLocationByAllBilledFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.12 박연진
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

public class RailBillingReqCreateDBDAOsearchRailRampLocationByAllBilledFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRailRampLocationByAllBilledFull
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchRailRampLocationByAllBilledFullRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration ").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchRailRampLocationByAllBilledFullRSQL").append("\n"); 
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
		query.append("SELECT rout_org_nod_cd" ).append("\n"); 
		query.append(",rout_dest_nod_cd" ).append("\n"); 
		query.append(",c1.loc_cd org_loc_cd" ).append("\n"); 
		query.append(",c1.loc_nm || ' ' || d1.cnt_nm org_loc_nm" ).append("\n"); 
		query.append(",b1.yd_cd org_yd_cd" ).append("\n"); 
		query.append(",b1.yd_nm org_yd_nm" ).append("\n"); 
		query.append(",b1.yd_addr org_yd_addr" ).append("\n"); 
		query.append(",c2.loc_cd dest_loc_cd" ).append("\n"); 
		query.append(",c2.loc_nm || ' ' || d2.cnt_nm dest_loc_nm" ).append("\n"); 
		query.append(",b2.yd_cd dest_yd_cd" ).append("\n"); 
		query.append(",b2.yd_nm dest_yd_nm" ).append("\n"); 
		query.append(",b2.yd_addr dest_yd_addr" ).append("\n"); 
		query.append("FROM trs_trsp_rail_bil_ord a" ).append("\n"); 
		query.append(",mdm_yard b1" ).append("\n"); 
		query.append(",mdm_location c1" ).append("\n"); 
		query.append(",mdm_country d1" ).append("\n"); 
		query.append(",mdm_yard b2" ).append("\n"); 
		query.append(",mdm_location c2" ).append("\n"); 
		query.append(",mdm_country d2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND a.fm_nod_cd = b1.yd_cd" ).append("\n"); 
		query.append("AND SUBSTR(a.fm_nod_cd, 1, 5) = c1.loc_cd" ).append("\n"); 
		query.append("AND c1.cnt_cd = d1.cnt_cd" ).append("\n"); 
		query.append("AND a.to_nod_cd = b2.yd_cd" ).append("\n"); 
		query.append("AND SUBSTR(a.to_nod_cd, 1, 5) = c2.loc_cd" ).append("\n"); 
		query.append("AND c2.cnt_cd = d2.cnt_cd" ).append("\n"); 
		query.append("AND a.bkg_no = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
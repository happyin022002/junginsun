/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchRailRampLocationByAutoAdjustFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.11.30 박연진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchRailRampLocationByAutoAdjustFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Billing Full Cntr Request (Rail Ramp)화면에 대한 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchRailRampLocationByAutoAdjustFullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("routDestNodCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("routOrgNodCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("routSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchRailRampLocationByAutoAdjustFullRSQL").append("\n"); 
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
		query.append("SELECT '' rout_org_nod_cd" ).append("\n"); 
		query.append(",'' rout_dest_nod_cd" ).append("\n"); 
		query.append(",dtl1.lnk_org_nod_cd" ).append("\n"); 
		query.append(",dtl2.lnk_dest_nod_cd" ).append("\n"); 
		query.append(",loc1.loc_cd org_loc_cd" ).append("\n"); 
		query.append(",loc1.loc_nm || ' ' || cnt1.cnt_nm org_loc_nm" ).append("\n"); 
		query.append(",yd1.yd_cd org_yd_cd" ).append("\n"); 
		query.append(",yd1.yd_nm org_yd_nm" ).append("\n"); 
		query.append(",yd1.yd_addr org_yd_addr" ).append("\n"); 
		query.append(",loc2.loc_cd dest_loc_cd" ).append("\n"); 
		query.append(",loc2.loc_nm || ' ' || cnt2.cnt_nm dest_loc_nm" ).append("\n"); 
		query.append(",yd2.yd_cd dest_yd_cd" ).append("\n"); 
		query.append(",yd2.yd_nm dest_yd_nm" ).append("\n"); 
		query.append(",yd2.yd_addr dest_yd_addr" ).append("\n"); 
		query.append(",'' block_vndr_flg" ).append("\n"); 
		query.append(",'' bill_type_flg" ).append("\n"); 
		query.append(",'' embargo_flg" ).append("\n"); 
		query.append(",'' tofc_flg" ).append("\n"); 
		query.append(",'' wrs_full_flg" ).append("\n"); 
		query.append(",'' auto_irg_flg" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_dtl dtl1" ).append("\n"); 
		query.append(",prd_inlnd_rout_dtl dtl2" ).append("\n"); 
		query.append(",mdm_yard yd1" ).append("\n"); 
		query.append(",mdm_location loc1" ).append("\n"); 
		query.append(",mdm_country cnt1" ).append("\n"); 
		query.append(",mdm_yard yd2" ).append("\n"); 
		query.append(",mdm_location loc2" ).append("\n"); 
		query.append(",mdm_country cnt2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND dtl1.rout_org_nod_cd = @[routOrgNodCd]" ).append("\n"); 
		query.append("AND dtl1.rout_dest_nod_cd = @[routDestNodCd]" ).append("\n"); 
		query.append("AND dtl1.rout_seq = @[routSeq]" ).append("\n"); 
		query.append("AND dtl1.trsp_mod_cd = 'RD'" ).append("\n"); 
		query.append("AND dtl1.rout_dtl_seq =" ).append("\n"); 
		query.append("(SELECT MIN(rout_dtl_seq)" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_dtl" ).append("\n"); 
		query.append("WHERE rout_org_nod_cd = dtl1.rout_org_nod_cd" ).append("\n"); 
		query.append("AND rout_dest_nod_cd = dtl1.rout_dest_nod_cd" ).append("\n"); 
		query.append("AND rout_seq = dtl1.rout_seq" ).append("\n"); 
		query.append("AND trsp_mod_cd = 'RD')" ).append("\n"); 
		query.append("AND dtl2.rout_org_nod_cd = @[routOrgNodCd]" ).append("\n"); 
		query.append("AND dtl2.rout_dest_nod_cd = @[routDestNodCd]" ).append("\n"); 
		query.append("AND dtl2.rout_seq = @[routSeq]" ).append("\n"); 
		query.append("AND dtl2.trsp_mod_cd = 'RD'" ).append("\n"); 
		query.append("AND dtl2.rout_dtl_seq =" ).append("\n"); 
		query.append("(SELECT MAX(rout_dtl_seq)" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_dtl" ).append("\n"); 
		query.append("WHERE rout_org_nod_cd = dtl2.rout_org_nod_cd" ).append("\n"); 
		query.append("AND rout_dest_nod_cd = dtl2.rout_dest_nod_cd" ).append("\n"); 
		query.append("AND rout_seq = dtl2.rout_seq" ).append("\n"); 
		query.append("AND trsp_mod_cd = 'RD')" ).append("\n"); 
		query.append("AND SUBSTR(dtl1.lnk_org_nod_cd, 1, 5) = loc1.loc_cd(+)" ).append("\n"); 
		query.append("AND loc1.cnt_cd = cnt1.cnt_cd(+)" ).append("\n"); 
		query.append("AND dtl1.lnk_org_nod_cd = yd1.yd_cd(+)" ).append("\n"); 
		query.append("AND SUBSTR(dtl2.lnk_dest_nod_cd, 1, 5) = loc2.loc_cd(+)" ).append("\n"); 
		query.append("AND loc2.cnt_cd = cnt2.cnt_cd(+)" ).append("\n"); 
		query.append("AND dtl2.lnk_dest_nod_cd = yd2.yd_cd(+)" ).append("\n"); 

	}
}
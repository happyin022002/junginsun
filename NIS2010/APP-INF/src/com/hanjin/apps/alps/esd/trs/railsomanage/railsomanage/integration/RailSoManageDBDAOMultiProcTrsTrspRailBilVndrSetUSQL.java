/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 요율정보를 SO Vendor 테이블에 수정 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_fuel_scg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_rail_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_basic_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_over_wgt_scg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_hzs_scg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_local_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_way_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_ttl_scg_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOMultiProcTrsTrspRailBilVndrSetUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_VNDR_SET" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if(${po_local_curr_cd} == \"\")" ).append("\n"); 
		query.append("CURR_CD = \"\"," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("CURR_CD = @[po_local_curr_cd]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("BZC_AMT = @[po_basic_rt]," ).append("\n"); 
		query.append("FUEL_SCG_AMT = @[po_fuel_scg_rt]," ).append("\n"); 
		query.append("NEGO_AMT = 0," ).append("\n"); 
		query.append("OVR_WGT_SCG_AMT = @[po_over_wgt_scg_rt]," ).append("\n"); 
		query.append("TRSP_AGMT_WY_TP_CD = @[po_way_type]," ).append("\n"); 
		query.append("TRSP_AGMT_RT_TP_CD = @[po_trsp_agmt_rt_tp_cd]," ).append("\n"); 
		query.append("HZD_MTRL_SCG_AMT = @[po_hzs_scg_rt], -- add 20100803" ).append("\n"); 
		query.append("ETC_ADD_AMT = @[po_ttl_scg_rt]  -- add 20100803" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND   SUB_RAIL_SEQ = @[sub_rail_seq]" ).append("\n"); 

	}
}
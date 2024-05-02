/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.29 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO에 요율정보(USD 단위)를 요율변환 테이블에 추가 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL(){
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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("po_local_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soffice_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOMultiProcTrsTrspRailConvAmtUsdCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_CONV_AMT (" ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("SUB_RAIL_SEQ," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("BZC_AMT," ).append("\n"); 
		query.append("FUEL_SCG_AMT," ).append("\n"); 
		query.append("OVR_WGT_SCG_AMT," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_so_seq]," ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[sub_rail_seq]," ).append("\n"); 
		query.append("'USD'," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC (@[po_local_curr_cd], @[po_basic_rt])," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC (@[po_local_curr_cd], @[po_fuel_scg_rt])," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC (@[po_local_curr_cd], @[po_over_wgt_scg_rt])," ).append("\n"); 
		query.append("@[cre_ofc_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[soffice_cd])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[soffice_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
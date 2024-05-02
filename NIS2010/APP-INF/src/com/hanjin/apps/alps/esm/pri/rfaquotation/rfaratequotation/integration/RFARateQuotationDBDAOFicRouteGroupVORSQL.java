/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAOFicRouteGroupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.25
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.25 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOFicRouteGroupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RouteGroup 조회
	  * </pre>
	  */
	public RFARateQuotationDBDAOFicRouteGroupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOFicRouteGroupVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${add_on_flag} == 'Y' )" ).append("\n"); 
		query.append("	PRI_ADDON_RATE_CALCULATE_PKG.PRI_GETFICROUTEGROUP_FNC(@[eff_dt], @[svc_scp_cd], @[prc_io_bnd_cd], @[rout_pnt_loc_def_cd], @[bse_port_def_cd], @[rcv_de_term_cd], @[prc_trsp_mod_cd]) AS FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("     , PRI_ADDON_RATE_CALCULATE_PKG.PRI_getBasePortList_FNC(@[eff_dt], @[svc_scp_cd], @[prc_io_bnd_cd], @[rout_pnt_loc_def_cd], @[rcv_de_term_cd], NULL, 'N') AS BASE_PORT_LIST" ).append("\n"); 
		query.append("     , (SELECT TRIM(REGEXP_SUBSTR(DATA, '[^|]+', 1, 2))" ).append("\n"); 
		query.append("        FROM   (SELECT PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICTransByRoute_FNC(@[eff_dt], @[svc_scp_cd], @[prc_io_bnd_cd], @[rout_pnt_loc_def_cd], @[bse_port_def_cd], @[rcv_de_term_cd]) DATA FROM DUAL)" ).append("\n"); 
		query.append("       ) PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	PRI_FIC_RATE_CALCULATE_PKG.PRI_GETFICROUTEGROUP_FNC(@[eff_dt], @[svc_scp_cd], @[rout_pnt_loc_def_cd], @[bse_port_def_cd], @[rcv_de_term_cd], @[prc_trsp_mod_cd]) AS FIC_RT_USE_STS_CD" ).append("\n"); 
		query.append("     , PRI_FIC_RATE_CALCULATE_PKG.PRI_getBasePortList_FNC(@[eff_dt], @[svc_scp_cd], @[rout_pnt_loc_def_cd], @[rcv_de_term_cd], NULL, 'N') AS BASE_PORT_LIST" ).append("\n"); 
		query.append("     , (SELECT TRIM(REGEXP_SUBSTR(DATA, '[^|]+', 1, 2))" ).append("\n"); 
		query.append("        FROM   (SELECT PRI_FIC_RATE_CALCULATE_PKG.PRI_getFICTransByRoute_FNC(@[eff_dt], @[svc_scp_cd], @[rout_pnt_loc_def_cd], @[bse_port_def_cd], @[rcv_de_term_cd]) DATA FROM DUAL)" ).append("\n"); 
		query.append("       ) PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , @[eff_dt] EFF_DT" ).append("\n"); 
		query.append("     , @[svc_scp_cd] SVC_SCP_CD" ).append("\n"); 
		query.append("     , @[rout_pnt_loc_def_cd] ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("     , @[bse_port_def_cd] BSE_PORT_DEF_CD" ).append("\n"); 
		query.append("     , @[rcv_de_term_cd] RCV_DE_TERM_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
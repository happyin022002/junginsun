/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeDBDAOAllPriScgRtVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.12.30 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOAllPriScgRtVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Rate 수정
	  * </pre>
	  */
	public SurchargeDBDAOAllPriScgRtVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOAllPriScgRtVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SCG_RT SET" ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if (${por_use_flg} == \"N\")" ).append("\n"); 
		query.append(", POR_TP_CD = ''" ).append("\n"); 
		query.append(", POR_DEF_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_use_flg} == \"N\")" ).append("\n"); 
		query.append(", POL_TP_CD = ''" ).append("\n"); 
		query.append(", POL_DEF_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_use_flg} == \"N\")" ).append("\n"); 
		query.append(", POD_TP_CD = ''" ).append("\n"); 
		query.append(", POD_DEF_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_use_flg} == \"N\")" ).append("\n"); 
		query.append(", DEL_TP_CD = ''" ).append("\n"); 
		query.append(", DEL_DEF_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_clss_use_flg} == 'N')" ).append("\n"); 
		query.append(", SCG_IMDG_CLSS_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_use_flg} == 'N')" ).append("\n"); 
		query.append(", SUB_TRD_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_use_flg} == 'N')" ).append("\n"); 
		query.append(", VSL_SLAN_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ts_port_use_flg} == 'N')" ).append("\n"); 
		query.append(", TS_PORT_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_call_use_flg} == 'N')" ).append("\n"); 
		query.append(", DIR_CALL_FLG = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_use_flg} == 'N')" ).append("\n"); 
		query.append(", TML_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trns_mod_use_flg} == 'N')" ).append("\n"); 
		query.append(", ORG_TRSP_MOD_CD = ''" ).append("\n"); 
		query.append(", DEST_TRSP_MOD_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usa_svc_mod_use_flg} == 'N')" ).append("\n"); 
		query.append(", USA_SVC_MOD_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rcv_de_term_use_flg} == 'N')" ).append("\n"); 
		query.append(", PRC_RCV_TERM_CD = ''" ).append("\n"); 
		query.append(", PRC_DE_TERM_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hngr_bar_use_flg} == 'N')" ).append("\n"); 
		query.append(", PRC_HNGR_BAR_TP_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_wgt_use_flg} == 'N')" ).append("\n"); 
		query.append(", MIN_CGO_WGT = ''" ).append("\n"); 
		query.append(", MAX_CGO_WGT = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_use_flg} == 'N')" ).append("\n"); 
		query.append(", CMDT_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gri_cmdt_use_flg} == 'N')" ).append("\n"); 
		query.append(", SCG_GRP_CMDT_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc_use_flg} == 'N')" ).append("\n"); 
		query.append(", SOC_FLG = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_ga_use_flg} == 'N')" ).append("\n"); 
		query.append(", IO_GA_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnl_tz_flg} == 'N')" ).append("\n"); 
		query.append(", CNL_TZ_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND CHG_CD = @[chg_cd]" ).append("\n"); 

	}
}
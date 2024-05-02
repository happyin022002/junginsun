/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanadaCustomsVesselDBDAOaddCanadaCustomsVesselCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCustomsVesselDBDAOaddCanadaCustomsVesselCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI_CND_CSTMS_VSL 테이블에 데이타 insert
	  * </pre>
	  */
	public CanadaCustomsVesselDBDAOaddCanadaCustomsVesselCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_arr_rpt_snt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rspn_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.integration ").append("\n"); 
		query.append("FileName : CanadaCustomsVesselDBDAOaddCanadaCustomsVesselCSQL").append("\n"); 
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
		query.append("INSERT INTO EDI_CND_CSTMS_VSL (" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", CVY_MRN_NO" ).append("\n"); 
		query.append(", CVY_CAP_NM" ).append("\n"); 
		query.append(", CVY_ETA_DT" ).append("\n"); 
		query.append(", VSL_CVY_NO" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", VSL_ARR_RPT_SNT_DT" ).append("\n"); 
		query.append(", CVY_ACK_CTRL_NO" ).append("\n"); 
		query.append(", CVY_ACK_CD" ).append("\n"); 
		query.append(", CVY_ACK_NO" ).append("\n"); 
		query.append(", RCV_ERR_MSG" ).append("\n"); 
		query.append(", RSPN_RCV_DT" ).append("\n"); 
		query.append(", CND_CSTMS_RJCT_CD" ).append("\n"); 
		query.append(", EAI_EVNT_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", cvy_mrn_no" ).append("\n"); 
		query.append(", cvy_cap_nm" ).append("\n"); 
		query.append(", TO_DATE(@[cvy_eta_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", vsl_cvy_no" ).append("\n"); 
		query.append(", upd_usr_id" ).append("\n"); 
		query.append(", TO_DATE(@[upd_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", TO_DATE(@[vsl_arr_rpt_snt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", cvy_ack_ctrl_no" ).append("\n"); 
		query.append(", cvy_ack_cd" ).append("\n"); 
		query.append(", cvy_ack_no" ).append("\n"); 
		query.append(", rcv_err_msg" ).append("\n"); 
		query.append(", TO_DATE(@[rspn_rcv_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", cnd_cstms_rjct_cd" ).append("\n"); 
		query.append(", TO_DATE(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
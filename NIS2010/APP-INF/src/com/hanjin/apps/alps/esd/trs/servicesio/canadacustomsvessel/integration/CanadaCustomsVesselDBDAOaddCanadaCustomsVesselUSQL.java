/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanadaCustomsVesselDBDAOaddCanadaCustomsVesselUSQL.java
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

public class CanadaCustomsVesselDBDAOaddCanadaCustomsVesselUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI_CND_CSTMS_VSL 해당 조건의 데이타 update
	  * </pre>
	  */
	public CanadaCustomsVesselDBDAOaddCanadaCustomsVesselUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_rjct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_cap_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvy_ack_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_ack_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cvy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvy_ack_ctrl_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.integration ").append("\n"); 
		query.append("FileName : CanadaCustomsVesselDBDAOaddCanadaCustomsVesselUSQL").append("\n"); 
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
		query.append("UPDATE EDI_CND_CSTMS_VSL SET" ).append("\n"); 
		query.append("CVY_MRN_NO					= @[cvy_mrn_no]" ).append("\n"); 
		query.append(", CVY_CAP_NM					= @[cvy_cap_nm]" ).append("\n"); 
		query.append(", CVY_ETA_DT					= TO_DATE(@[cvy_eta_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", VSL_CVY_NO				  	= @[vsl_cvy_no]" ).append("\n"); 
		query.append(", UPD_USR_ID					= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT						= TO_DATE(@[upd_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", VSL_ARR_RPT_SNT_DT			= TO_DATE(@[vsl_arr_rpt_snt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", CVY_ACK_CTRL_NO				= @[cvy_ack_ctrl_no]" ).append("\n"); 
		query.append(", CVY_ACK_CD					= @[cvy_ack_cd]" ).append("\n"); 
		query.append(", CVY_ACK_NO				  	= @[cvy_ack_no]" ).append("\n"); 
		query.append(", RCV_ERR_MSG					= @[rcv_err_msg]" ).append("\n"); 
		query.append(", RSPN_RCV_DT					= TO_DATE(@[rspn_rcv_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", CND_CSTMS_RJCT_CD				= @[cnd_cstms_rjct_cd]" ).append("\n"); 
		query.append(", EAI_EVNT_DT			        = to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("WHERE 	  VSL_CD					= @[vsl_cd]" ).append("\n"); 
		query.append("AND	  SKD_VOY_NO					= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	  SKD_DIR_CD					= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND 	NVL(EAI_EVNT_DT, to_date(20070505,'yyyymmddhh24miss'))  <= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}
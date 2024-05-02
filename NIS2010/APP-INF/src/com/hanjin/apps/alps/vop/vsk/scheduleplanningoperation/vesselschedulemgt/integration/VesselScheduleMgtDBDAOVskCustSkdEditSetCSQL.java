/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOVskCustSkdEditSetCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.15 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOVskCustSkdEditSetCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOVskCustSkdEditSetCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_dmy_skd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_dmy_skd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_rsrc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_svc_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_stup_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOVskCustSkdEditSetCSQL").append("\n"); 
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
		query.append("MERGE INTO VSK_CUST_SKD_EDI_SET B" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[edi_stup_id] EDI_STUP_ID," ).append("\n"); 
		query.append("@[use_flg]     USE_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append("ON(" ).append("\n"); 
		query.append("A.EDI_STUP_ID = B.EDI_STUP_ID" ).append("\n"); 
		query.append("AND A.USE_FLG IN ('U', 'D')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET B.EDI_SVC_TP_NM   = @[edi_svc_tp_nm]," ).append("\n"); 
		query.append("B.WRK_RSRC_NM     = @[wrk_rsrc_nm]," ).append("\n"); 
		query.append("B.SND_FM_DYS      = @[snd_fm_dys]," ).append("\n"); 
		query.append("B.SND_TO_DYS      = @[snd_to_dys]," ).append("\n"); 
		query.append("B.PRE_DMY_SKD_FLG = @[pre_dmy_skd_flg]," ).append("\n"); 
		query.append("B.PST_DMY_SKD_FLG = @[pst_dmy_skd_flg]," ).append("\n"); 
		query.append("B.EAI_EVNT_DT     = TO_DATE(SUBSTR(@[eai_evnt_dt], 0, 14), 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("B.USE_FLG		 = DECODE(A.USE_FLG, 'U', 'Y', 'D', 'D')," ).append("\n"); 
		query.append("B.UPD_USR_ID      = @[upd_usr_id]," ).append("\n"); 
		query.append("B.UPD_DT          = TO_DATE(SUBSTR(@[upd_dt], 0, 14), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT(" ).append("\n"); 
		query.append("B.EDI_STUP_ID" ).append("\n"); 
		query.append(",B.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",B.EDI_SNDR_ID" ).append("\n"); 
		query.append(",B.EDI_MSG_NM" ).append("\n"); 
		query.append(",B.EDI_SVC_TP_NM" ).append("\n"); 
		query.append(",B.WRK_RSRC_NM" ).append("\n"); 
		query.append(",B.SND_FM_DYS" ).append("\n"); 
		query.append(",B.SND_TO_DYS" ).append("\n"); 
		query.append(",B.PRE_DMY_SKD_FLG" ).append("\n"); 
		query.append(",B.PST_DMY_SKD_FLG" ).append("\n"); 
		query.append(",B.USE_FLG" ).append("\n"); 
		query.append(",B.EAI_EVNT_DT" ).append("\n"); 
		query.append(",B.CRE_USR_ID" ).append("\n"); 
		query.append(",B.CRE_DT" ).append("\n"); 
		query.append(",B.UPD_USR_ID" ).append("\n"); 
		query.append(",B.UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[edi_stup_id]" ).append("\n"); 
		query.append(",@[cust_trd_prnr_id]" ).append("\n"); 
		query.append(",@[edi_sndr_id]" ).append("\n"); 
		query.append(",@[edi_msg_nm]" ).append("\n"); 
		query.append(",@[edi_svc_tp_nm]" ).append("\n"); 
		query.append(",@[wrk_rsrc_nm]" ).append("\n"); 
		query.append(",@[snd_fm_dys]" ).append("\n"); 
		query.append(",@[snd_to_dys]" ).append("\n"); 
		query.append(",@[pre_dmy_skd_flg]" ).append("\n"); 
		query.append(",@[pst_dmy_skd_flg]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[eai_evnt_dt], 0, 14), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[cre_dt], 0, 14), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",TO_DATE(SUBSTR(@[upd_dt], 0, 14), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
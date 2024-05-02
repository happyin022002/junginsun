/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleTransmitManagementDBDAOManageTransmitNoticeTargetSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleTransmitManagementDBDAOManageTransmitNoticeTargetSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대상Schedule에 대한 ETA Notice 및 Pre Stowage Notice를 TELEX/FAX 전송 및 이력관리
	  * </pre>
	  */
	public ScheduleTransmitManagementDBDAOManageTransmitNoticeTargetSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esvc_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tlx_imst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_ownr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_tlx_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_fax_trsm_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_tlx_trsm_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fb_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_imst_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration ").append("\n"); 
		query.append("FileName : ScheduleTransmitManagementDBDAOManageTransmitNoticeTargetSkdCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_PORT_SKD_TRSM_HIS" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   VSL_CD," ).append("\n"); 
		query.append("   SKD_VOY_NO, " ).append("\n"); 
		query.append("   SKD_DIR_CD, " ).append("\n"); 
		query.append("   VPS_PORT_CD, " ).append("\n"); 
		query.append("   CLPT_IND_SEQ, " ).append("\n"); 
		query.append("   TRSM_HIS_SEQ, " ).append("\n"); 
		query.append("   YD_CD, " ).append("\n"); 
		query.append("   TRSM_MZD_CD, " ).append("\n"); 
		query.append("   TRSM_OWNR_CD, " ).append("\n"); 
		query.append("   SLAN_CD, " ).append("\n"); 
		query.append("   ACT_CRR_CD, " ).append("\n"); 
		query.append("   VPS_ETA_DT, " ).append("\n"); 
		query.append("   VPS_ETB_DT, " ).append("\n"); 
		query.append("   VPS_ETD_DT," ).append("\n"); 
		query.append("   #if (${ntc_eta_dt} != '')" ).append("\n"); 
		query.append("	   NTC_ETA_DT, " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${ntc_etb_dt} != '')" ).append("\n"); 
		query.append("	   NTC_ETB_DT, " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${ntc_etd_dt} != '')" ).append("\n"); 
		query.append("	   NTC_ETD_DT, " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   TRSM_RSN, " ).append("\n"); 
		query.append("   VSL_FAX_NO, " ).append("\n"); 
		query.append("   VSL_TLX_NO, " ).append("\n"); 
		query.append("   VSL_EML, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${trsm_mzd_cd} == 'FAX')" ).append("\n"); 
		query.append("   FAX_IMST_CD," ).append("\n"); 
		query.append("   VSL_FAX_TRSM_EML," ).append("\n"); 
		query.append("   #elseif(${trsm_mzd_cd} == 'TLX')" ).append("\n"); 
		query.append("   TLX_IMST_CD," ).append("\n"); 
		query.append("   VSL_TLX_TRSM_EML," ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${trsm_ownr_cd} == 'ESVC')" ).append("\n"); 
		query.append("   ESVC_VNDR_SEQ," ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   TRSM_LOCL_DT, " ).append("\n"); 
		query.append("   TRSM_DT, " ).append("\n"); 
		query.append("   SKD_TRSM_STS_CD, " ).append("\n"); 
		query.append("   SNDR_EML," ).append("\n"); 
		query.append("   EML_SND_NO," ).append("\n"); 
		query.append("   FB_EML," ).append("\n"); 
		query.append("   CRE_USR_ID, " ).append("\n"); 
		query.append("   LOCL_CRE_DT, " ).append("\n"); 
		query.append("   CRE_DT, " ).append("\n"); 
		query.append("   UPD_USR_ID, " ).append("\n"); 
		query.append("   LOCL_UPD_DT, " ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   SNDR_NM," ).append("\n"); 
		query.append("   SNDR_PHN_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   TRSM_PURP_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   @[vsl_cd], " ).append("\n"); 
		query.append("   @[skd_voy_no], " ).append("\n"); 
		query.append("   @[skd_dir_cd], " ).append("\n"); 
		query.append("   @[vps_port_cd], " ).append("\n"); 
		query.append("   @[clpt_ind_seq], " ).append("\n"); 
		query.append("   TRSM_HIS_SEQ.NEXTVAL," ).append("\n"); 
		query.append("   @[yd_cd], " ).append("\n"); 
		query.append("   @[trsm_mzd_cd], " ).append("\n"); 
		query.append("   @[trsm_ownr_cd], " ).append("\n"); 
		query.append("   @[slan_cd], " ).append("\n"); 
		query.append("   @[act_crr_cd], " ).append("\n"); 
		query.append("   TO_DATE(@[vps_eta_dt],'yyyymmddHH24Mi'), " ).append("\n"); 
		query.append("   TO_DATE(@[vps_etb_dt],'yyyymmddHH24Mi'), " ).append("\n"); 
		query.append("   TO_DATE(@[vps_etd_dt],'yyyymmddHH24Mi'), " ).append("\n"); 
		query.append("   #if (${ntc_eta_dt} != '')" ).append("\n"); 
		query.append("	   TO_DATE(@[ntc_eta_dt],'yyyymmddHH24Mi'), " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${ntc_etb_dt} != '')" ).append("\n"); 
		query.append("	   TO_DATE(@[ntc_etb_dt],'yyyymmddHH24Mi'), " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${ntc_etd_dt} != '')" ).append("\n"); 
		query.append("	   TO_DATE(@[ntc_etd_dt],'yyyymmddHH24Mi'), " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   @[trsm_rsn], " ).append("\n"); 
		query.append("   @[vsl_fax_no], " ).append("\n"); 
		query.append("   @[vsl_tlx_no], " ).append("\n"); 
		query.append("   @[vsl_eml], " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${trsm_mzd_cd} == 'FAX')" ).append("\n"); 
		query.append("   @[fax_imst_cd], " ).append("\n"); 
		query.append("   @[vsl_fax_trsm_eml], " ).append("\n"); 
		query.append("   #elseif(${trsm_mzd_cd} == 'TLX')" ).append("\n"); 
		query.append("   @[tlx_imst_cd], " ).append("\n"); 
		query.append("   @[vsl_tlx_trsm_eml]," ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${trsm_ownr_cd} == 'ESVC')" ).append("\n"); 
		query.append("   @[esvc_vndr_seq]," ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   GLOBALDATE_PKG.TIME_LOCAL_FNC(@[vps_port_cd]), " ).append("\n"); 
		query.append("   sysdate, " ).append("\n"); 
		query.append("   @[skd_trsm_sts_cd], " ).append("\n"); 
		query.append("   @[sndr_eml]," ).append("\n"); 
		query.append("   @[eml_snd_no]," ).append("\n"); 
		query.append("   @[fb_eml]," ).append("\n"); 
		query.append("   @[cre_usr_id], " ).append("\n"); 
		query.append("   GLOBALDATE_PKG.TIME_LOCAL_FNC(@[vps_port_cd]), " ).append("\n"); 
		query.append("   sysdate, " ).append("\n"); 
		query.append("   @[upd_usr_id], " ).append("\n"); 
		query.append("   GLOBALDATE_PKG.TIME_LOCAL_FNC(@[vps_port_cd]), " ).append("\n"); 
		query.append("   sysdate," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   @[sndr_nm]," ).append("\n"); 
		query.append("   @[sndr_phn_no]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   @[trsm_purp_cd]" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}
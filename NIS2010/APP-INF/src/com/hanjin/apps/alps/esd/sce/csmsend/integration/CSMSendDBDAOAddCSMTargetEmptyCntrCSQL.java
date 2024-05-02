/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CSMSendDBDAOAddCSMTargetEmptyCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.23
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.06.23 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAOAddCSMTargetEmptyCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty container movement 를 대상으로 해당 mvmt 에 딸린 bkg 의 vvd 중 pod /del 도착까지 미주를 경유하는지
	  * 조회하여 대상이면 SCE_CNTR_STS_MSG_TGT 에 insert
	  * </pre>
	  */
	public CSMSendDBDAOAddCSMTargetEmptyCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.csmsend.integration").append("\n"); 
		query.append("FileName : CSMSendDBDAOAddCSMTargetEmptyCntrCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO SCE_CNTR_STS_MSG_TGT" ).append("\n"); 
		query.append("(ACT_RCV_DT, ACT_RCV_NO, BKG_NO, CNTR_NO, ACT_DT, ACT_STS_MAPG_CD, NOD_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD, ACT_UMCH_TP_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, COP_EVNT_SEQ," ).append("\n"); 
		query.append("CNTR_CGO_TP_CD, CNMV_CO_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select TO_CHAR(SYSDATE, 'YYYYMMDD') AS ACT_RCV_DT," ).append("\n"); 
		query.append("SCE_CNTR_STS_MSG_TGT_SEQ1.NEXTVAL AS ACT_RCV_NO," ).append("\n"); 
		query.append("A.bkg_no," ).append("\n"); 
		query.append("A.cntr_no," ).append("\n"); 
		query.append("A.CNMV_EVNT_DT as ACT_DT," ).append("\n"); 
		query.append("A.MVMT_STS_CD AS ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("A.ORG_YD_CD AS NOD_CD," ).append("\n"); 
		query.append("1 AS ACT_RCV_TP_CD," ).append("\n"); 
		query.append("'00' AS ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("A.CRNT_VSL_CD AS VSL_CD," ).append("\n"); 
		query.append("A.CRNT_SKD_VOY_NO AS SKD_VOY_NO," ).append("\n"); 
		query.append("A.CRNT_SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("0 AS COP_EVNT_SEQ," ).append("\n"); 
		query.append("A.BKG_CGO_TP_CD AS CNTR_CGO_TP_CD," ).append("\n"); 
		query.append("A.CNMV_CO_CD," ).append("\n"); 
		query.append("'EMPTY' AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("'EMPTY' AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("from ctm_movement a," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select cntr_no," ).append("\n"); 
		query.append("cnmv_yr," ).append("\n"); 
		query.append("cnmv_id_no," ).append("\n"); 
		query.append("mvmt_sts_cd," ).append("\n"); 
		query.append("v.vsl_cd," ).append("\n"); 
		query.append("v.skd_voy_no," ).append("\n"); 
		query.append("v.skd_dir_cd," ).append("\n"); 
		query.append("max(case when b.pod_cd = c.vps_port_cd then clpt_seq else null end) as pod_clpt_seq," ).append("\n"); 
		query.append("max(case when b.del_cd = c.vps_port_cd then clpt_seq else null end) as del_clpt_seq" ).append("\n"); 
		query.append("from ctm_movement a," ).append("\n"); 
		query.append("bkg_booking b," ).append("\n"); 
		query.append("bkg_vvd v," ).append("\n"); 
		query.append("vsk_vsl_port_skd c" ).append("\n"); 
		query.append("where a.upd_dt between to_date(to_char(sysdate - (2/24), 'yyyymmddhh24') || '00', 'yyyymmddhh24mi') and sysdate" ).append("\n"); 
		query.append("and a.bkg_cgo_tp_cd = 'P'" ).append("\n"); 
		query.append("and a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("and a.bkg_no = v.bkg_no" ).append("\n"); 
		query.append("and v.vsl_cd = c.vsl_cd" ).append("\n"); 
		query.append("and v.skd_voy_no = c.skd_voy_no" ).append("\n"); 
		query.append("and v.skd_dir_cd = c.skd_dir_cd" ).append("\n"); 
		query.append("group by cntr_no, cnmv_yr, cnmv_id_no, mvmt_sts_cd, v.vsl_cd, v.skd_voy_no, v.skd_dir_cd ) b" ).append("\n"); 
		query.append("where a.cntr_no = b.cntr_no" ).append("\n"); 
		query.append("and a.cnmv_yr = b.cnmv_yr" ).append("\n"); 
		query.append("and a.cnmv_id_no = b.cnmv_id_no" ).append("\n"); 
		query.append("and a.mvmt_sts_cd = b.mvmt_sts_cd" ).append("\n"); 
		query.append("and exists (" ).append("\n"); 
		query.append("select '1'" ).append("\n"); 
		query.append("from vsk_vsl_port_skd c" ).append("\n"); 
		query.append("where b.vsl_cd = c.vsl_cd" ).append("\n"); 
		query.append("and b.skd_voy_no = c.skd_voy_no" ).append("\n"); 
		query.append("and b.skd_dir_cd = c.skd_dir_cd" ).append("\n"); 
		query.append("and ( (c.clpt_seq <= pod_clpt_seq" ).append("\n"); 
		query.append("and c.vps_port_cd like 'US%')" ).append("\n"); 
		query.append("or (c.clpt_seq <= del_clpt_seq" ).append("\n"); 
		query.append("and c.vps_port_cd like 'US%') ) )" ).append("\n"); 
		query.append("and not exists (" ).append("\n"); 
		query.append("select '1'" ).append("\n"); 
		query.append("from sce_cntr_sts_msg_tgt" ).append("\n"); 
		query.append("where cntr_no = a.cntr_no" ).append("\n"); 
		query.append("and bkg_no = a.bkg_no" ).append("\n"); 
		query.append("and act_sts_mapg_cd = a.mvmt_sts_cd" ).append("\n"); 
		query.append(") )" ).append("\n"); 

	}
}
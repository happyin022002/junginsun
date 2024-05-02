/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchPfSkdDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.12.02 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchPfSkdDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Lane Code, P/F Service Type Code가 일치하는 Proforma 정보를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchPfSkdDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchPfSkdDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T1.VSL_SLAN_CD" ).append("\n"); 
		query.append(",	T1.PF_SVC_TP_CD" ).append("\n"); 
		query.append(",	T1.SLAN_STND_FLG" ).append("\n"); 
		query.append(",	T1.SVC_DUR_DYS" ).append("\n"); 
		query.append(",	T1.STND_SVC_SPD" ).append("\n"); 
		query.append(",	T1.BRTH_ITVAL_DYS" ).append("\n"); 
		query.append(",	T1.MML_USD_FLG" ).append("\n"); 
		query.append(",	T1.SIM_DT" ).append("\n"); 
		query.append(",	T1.SIM_NO" ).append("\n"); 
		query.append(",	T1.N1ST_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	T1.N1ST_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	T1.N2ND_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	T1.N2ND_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	T1.N3RD_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	T1.N3RD_VSL_CLSS_KNT" ).append("\n"); 
		query.append(",	T1.CLPT_KNT" ).append("\n"); 
		query.append(",	T1.TTL_DIST" ).append("\n"); 
		query.append(",	T1.MAX_SPD" ).append("\n"); 
		query.append(",	T1.AVG_SPD" ).append("\n"); 
		query.append(",	T1.DELT_FLG" ).append("\n"); 
		query.append(",	T1.PF_SKD_RMK" ).append("\n"); 
		query.append(",	T2.PORT_CD" ).append("\n"); 
		query.append(",	T2.SKD_DIR_CD" ).append("\n"); 
		query.append(",	T2.CLPT_SEQ" ).append("\n"); 
		query.append(",	T2.PORT_ROTN_SEQ" ).append("\n"); 
		query.append(",	T2.YD_CD" ).append("\n"); 
		query.append(",	T2.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",	T2.TURN_PORT_FLG" ).append("\n"); 
		query.append(",	T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",	T2.ETB_DY_CD" ).append("\n"); 
		query.append(",	T2.ETB_DY_NO" ).append("\n"); 
		query.append(",	T2.ETB_TM_HRMNT" ).append("\n"); 
		query.append(",	T2.ETD_DY_CD" ).append("\n"); 
		query.append(",	T2.ETD_DY_NO" ).append("\n"); 
		query.append(",	T2.ETD_TM_HRMNT" ).append("\n"); 
		query.append(",	T2.LNK_DIST" ).append("\n"); 
		query.append(",	T2.LNK_SPD" ).append("\n"); 
		query.append(",	T2.TZTM_HRS" ).append("\n"); 
		query.append(",	T2.SEA_BUF_HRS" ).append("\n"); 
		query.append(",	T2.SEA_BUF_SPD" ).append("\n"); 
		query.append(",	T2.MNVR_IN_HRS" ).append("\n"); 
		query.append(",	T2.MNVR_OUT_HRS" ).append("\n"); 
		query.append(",	T2.IB_IPCGO_QTY" ).append("\n"); 
		query.append(",	T2.IB_OCN_CGO_QTY" ).append("\n"); 
		query.append(",	T2.OB_IPCGO_QTY" ).append("\n"); 
		query.append(",	T2.OB_OCN_CGO_QTY" ).append("\n"); 
		query.append(",	T2.TML_PROD_QTY" ).append("\n"); 
		query.append(",	T2.CRN_KNT" ).append("\n"); 
		query.append(",	T2.ACT_WRK_HRS" ).append("\n"); 
		query.append(",	T2.PORT_BUF_HRS" ).append("\n"); 
		query.append(",	T2.CRE_USR_ID" ).append("\n"); 
		query.append(",	T2.CRE_DT" ).append("\n"); 
		query.append(",	T2.UPD_USR_ID" ).append("\n"); 
		query.append(",	T2.UPD_DT" ).append("\n"); 
		query.append("FROM VSK_PF_SKD T1, VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("AND T1.PF_SVC_TP_CD=@[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T1.PF_SVC_TP_CD=T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("ORDER BY PORT_ROTN_SEQ" ).append("\n"); 

	}
}
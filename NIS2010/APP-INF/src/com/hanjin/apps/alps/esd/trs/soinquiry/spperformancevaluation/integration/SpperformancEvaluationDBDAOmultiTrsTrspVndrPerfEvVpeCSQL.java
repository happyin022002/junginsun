/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_VNDR_PERF_EV에 데이타 입력
	  * </pre>
	  */
	public SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_ev_grd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("HID_CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("HID_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_ev_grd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("HID_CRE_DT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration").append("\n"); 
		query.append("FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeCSQL").append("\n"); 
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
		query.append("insert into TRS_TRSP_VNDR_PERF_EV (" ).append("\n"); 
		query.append("trsp_wo_ofc_cty_cd," ).append("\n"); 
		query.append("trsp_wo_seq," ).append("\n"); 
		query.append("wo_ev_grd_cd," ).append("\n"); 
		query.append("shpr_ev_grd_cd," ).append("\n"); 
		query.append("ev_ctnt," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_ofc_cd," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("upd_usr_id" ).append("\n"); 
		query.append(") values (" ).append("\n"); 
		query.append("@[trsp_wo_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_wo_seq]," ).append("\n"); 
		query.append("NVL(@[wo_ev_grd_cd],'')," ).append("\n"); 
		query.append("NVL(@[shpr_ev_grd_cd],'')," ).append("\n"); 
		query.append("NVL(@[ev_ctnt],'')," ).append("\n"); 
		query.append("TO_DATE( @[HID_CRE_DT] , 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("@[HID_CRE_USR_ID]," ).append("\n"); 
		query.append("NVL(@[HID_CRE_OFC_CD],'')," ).append("\n"); 
		query.append("TO_DATE( @[HID_CRE_DT] , 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("@[HID_CRE_USR_ID]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
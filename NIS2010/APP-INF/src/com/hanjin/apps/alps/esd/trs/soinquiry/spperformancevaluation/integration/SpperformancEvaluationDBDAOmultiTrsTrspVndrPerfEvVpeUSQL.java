/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeUSQL.java
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

public class SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_VNDR_PERF_EV 업데이트
	  * </pre>
	  */
	public SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeUSQL(){
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
		query.append("FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeUSQL").append("\n"); 
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
		query.append("UPDATE   TRS_TRSP_VNDR_PERF_EV" ).append("\n"); 
		query.append("SET	wo_ev_grd_cd	 	= @[wo_ev_grd_cd]" ).append("\n"); 
		query.append(",shpr_ev_grd_cd	 	= @[shpr_ev_grd_cd]" ).append("\n"); 
		query.append(",ev_ctnt	 		= nvl(@[ev_ctnt],'')" ).append("\n"); 
		query.append(",upd_usr_id	 		= @[HID_CRE_USR_ID]" ).append("\n"); 
		query.append(",upd_dt	 = TO_DATE( @[HID_CRE_DT] , 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("WHERE  trsp_wo_ofc_cty_cd	 = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND  trsp_wo_seq	 = @[trsp_wo_seq]" ).append("\n"); 

	}
}
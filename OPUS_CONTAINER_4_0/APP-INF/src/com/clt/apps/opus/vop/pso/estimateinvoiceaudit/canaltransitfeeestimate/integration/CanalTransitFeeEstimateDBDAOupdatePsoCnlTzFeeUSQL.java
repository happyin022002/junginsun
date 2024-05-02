/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalTransitFeeEstimateDBDAOupdatePsoCnlTzFeeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeEstimateDBDAOupdatePsoCnlTzFeeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Requested Advanced Payment Reject@CLICK
	  * Estimate Target VVD 의 Status 를 Ready 상태로 변경한다. 
	  * -------------------------------------------------------------------
	  * ** 변경이력 **
	  * -------------------------------------------------------------------
	  * [CHM-201005375-01]
	  * CALL_SEQ 를 KEY값으로 포함함
	  * -------------------------------------------------------------------
	  * </pre>
	  */
	public CanalTransitFeeEstimateDBDAOupdatePsoCnlTzFeeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeEstimateDBDAOupdatePsoCnlTzFeeUSQL").append("\n"); 
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
		query.append("update pso_cnl_tz_fee" ).append("\n"); 
		query.append("			set CNL_TZ_PROC_STS_CD = 'R'" ).append("\n"); 
		query.append("			,   DIFF_RMK = 'Rejected'" ).append("\n"); 
		query.append("			,   ISS_CTY_CD = NULL" ).append("\n"); 
		query.append("			,   SO_SEQ = NULL" ).append("\n"); 
		query.append("			,   UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("			,   UPD_DT = SYSDATE" ).append("\n"); 
		query.append("			where  PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("			AND CNL_TZ_BZTP_CD = @[cnl_tz_bztp_cd]--'E'" ).append("\n"); 
		query.append("			AND VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = substr(@[vvd], 9)" ).append("\n"); 
		query.append("AND CALL_SEQ = @[call_seq]" ).append("\n"); 

	}
}
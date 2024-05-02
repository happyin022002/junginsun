/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOMergeRepoPlanRLAThresholdCSQL.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 이송 계획
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAOMergeRepoPlanRLAThresholdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_PLN_RED_LGT_ALT_MST 테이블의 데이터 수정/입력
	  * </pre>
	  */
	public RepoThresholdManageDBDAOMergeRepoPlanRLAThresholdCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("perf_dur_wks",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ls_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_capa_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO EQR_REPO_PLN_RED_LGT_ALT_MST I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[rcc_cd] AS RCC_CD FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON (I.RCC_CD = M.RCC_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET I.PERF_DUR_WKS  = @[perf_dur_wks]," ).append("\n"); 
		query.append("I.TRSP_CAPA_RTO = @[trsp_capa_rto]," ).append("\n"); 
		query.append("I.LS_RTO        = @[ls_rto]," ).append("\n"); 
		query.append("I.UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("I.UPD_DT    	= SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.RCC_CD," ).append("\n"); 
		query.append("I.PERF_DUR_WKS," ).append("\n"); 
		query.append("I.TRSP_CAPA_RTO," ).append("\n"); 
		query.append("I.LS_RTO," ).append("\n"); 
		query.append("I.CRE_USR_ID," ).append("\n"); 
		query.append("I.CRE_DT," ).append("\n"); 
		query.append("I.UPD_USR_ID," ).append("\n"); 
		query.append("I.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[rcc_cd]," ).append("\n"); 
		query.append("@[perf_dur_wks]," ).append("\n"); 
		query.append("@[trsp_capa_rto]," ).append("\n"); 
		query.append("@[ls_rto]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOMergeRepoPlanRLAThresholdCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
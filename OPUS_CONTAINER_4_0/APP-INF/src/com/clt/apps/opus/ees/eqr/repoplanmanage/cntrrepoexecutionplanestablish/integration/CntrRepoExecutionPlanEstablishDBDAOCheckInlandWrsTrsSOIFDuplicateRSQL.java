/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckInlandWrsTrsSOIFDuplicateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.16 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOCheckInlandWrsTrsSOIFDuplicateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 
	  * * TRS --> EQR SO IF 중에 EQR_INLND_TRSP_EXE_PLN 테이블에 출발-도착 YARD 날짜가 같은 경우가 없는지 확인
	  * * 존재하는 경우 REF ID를 리턴
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckInlandWrsTrsSOIFDuplicateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckInlandWrsTrsSOIFDuplicateRSQL").append("\n"); 
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
		query.append("REF_ID" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_INLND_TRSP_EXE_PLN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND   PLN_YRWK    = @[pln_yrwk]" ).append("\n"); 
		query.append("AND   TRSP_MOD_CD = @[trsp_mod_cd]" ).append("\n"); 
		query.append("AND   FM_YD_CD    = @[fm_yd_cd]" ).append("\n"); 
		query.append("AND   TO_CHAR(FM_ETD_DT, 'YYYYMMDD')   = @[fm_etd_dt]" ).append("\n"); 
		query.append("AND   TO_YD_CD    = @[to_yd_cd]" ).append("\n"); 
		query.append("AND   TO_CHAR(TO_ETA_DT, 'YYYYMMDD')   = @[to_eta_dt]" ).append("\n"); 
		query.append("AND   EQ_REPO_PURP_CD IS NULL" ).append("\n"); 
		query.append("AND   REPO_PLN_FB_RSN_CD IS NULL" ).append("\n"); 
		query.append("AND   REPO_PLN_FB_RMK IS NULL" ).append("\n"); 
		query.append("AND   CRE_USR_ID = 'TRS_SOIF'" ).append("\n"); 
		query.append("AND   XTER_RQST_PLN_OWNR_CD <> 'E'" ).append("\n"); 

	}
}
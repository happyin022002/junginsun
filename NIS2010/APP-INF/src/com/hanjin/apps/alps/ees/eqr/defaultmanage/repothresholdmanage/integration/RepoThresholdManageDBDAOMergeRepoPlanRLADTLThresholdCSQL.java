/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOMergeRepoPlanRLADTLThresholdCSQL.java
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

public class RepoThresholdManageDBDAOMergeRepoPlanRLADTLThresholdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_PLN_RED_LGT_ALT_DTL 테이블의 데이터 수정/입력
	  * </pre>
	  */
	public RepoThresholdManageDBDAOMergeRepoPlanRLADTLThresholdCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adhr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adhr_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adhr_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adhr_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO EQR_REPO_PLN_RED_LGT_ALT_DTL I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[rcc_cd] AS RCC_CD" ).append("\n"); 
		query.append(",@[adhr_itm_cd] AS ADHR_ITM_CD" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.RCC_CD       = M.RCC_CD" ).append("\n"); 
		query.append("AND I.ADHR_ITM_CD  = M.ADHR_ITM_CD" ).append("\n"); 
		query.append("AND I.CNTR_TPSZ_CD = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET I.ADHR_BSE_CD   = @[adhr_bse_cd]," ).append("\n"); 
		query.append("I.ADHR_RTO      = @[adhr_rto]," ).append("\n"); 
		query.append("I.ADHR_VOL_QTY  = @[adhr_vol_qty]," ).append("\n"); 
		query.append("I.UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("I.UPD_DT    	= SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.RCC_CD," ).append("\n"); 
		query.append("I.ADHR_ITM_CD," ).append("\n"); 
		query.append("I.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("I.ADHR_BSE_CD," ).append("\n"); 
		query.append("I.ADHR_RTO," ).append("\n"); 
		query.append("I.ADHR_VOL_QTY," ).append("\n"); 
		query.append("I.CRE_USR_ID," ).append("\n"); 
		query.append("I.CRE_DT," ).append("\n"); 
		query.append("I.UPD_USR_ID," ).append("\n"); 
		query.append("I.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[rcc_cd]," ).append("\n"); 
		query.append("@[adhr_itm_cd]," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[adhr_bse_cd]," ).append("\n"); 
		query.append("@[adhr_rto]," ).append("\n"); 
		query.append("@[adhr_vol_qty]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOMergeRepoPlanRLADTLThresholdCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOMergeWeekNewVanPlanCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 운영2팀 정은호
*@LastVersion : 1.0
* 2009.07.17 운영2팀 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ho Chung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOMergeWeekNewVanPlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_NEW_VAN_LONG_TERM 테이블 수정/입력
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOMergeWeekNewVanPlanCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_de_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration ").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOMergeWeekNewVanPlanCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_NEW_VAN_LONG_TERM I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[pln_yrmon] AS PLN_YRMON" ).append("\n"); 
		query.append(",@[co_cd] AS CO_CD" ).append("\n"); 
		query.append(",@[ecc_cd] AS ECC_CD" ).append("\n"); 
		query.append(",@[cntr_lstm_cd] AS CNTR_LSTM_CD" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",@[vndr_cnt_cd] AS VNDR_CNT_CD" ).append("\n"); 
		query.append(",@[vndr_seq] AS VNDR_SEQ" ).append("\n"); 
		query.append(",@[cntr_de_sts_cd] AS CNTR_DE_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.PLN_YRMON     = M.PLN_YRMON" ).append("\n"); 
		query.append("AND I.CO_CD 		= M.CO_CD" ).append("\n"); 
		query.append("AND I.ECC_CD        = M.ECC_CD" ).append("\n"); 
		query.append("AND I.CNTR_LSTM_CD  = M.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND I.CNTR_TPSZ_CD  = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND I.VNDR_CNT_CD   = M.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND I.VNDR_SEQ      = M.VNDR_SEQ" ).append("\n"); 
		query.append("AND I.CNTR_DE_STS_CD= M.CNTR_DE_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET I.CNTR_VOL_QTY    = @[cntr_vol_qty]," ).append("\n"); 
		query.append("I.UPD_USR_ID      = @[user_id]," ).append("\n"); 
		query.append("I.UPD_DT    	  = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT  (" ).append("\n"); 
		query.append("I.PLN_YRMON" ).append("\n"); 
		query.append(",I.CO_CD" ).append("\n"); 
		query.append(",I.ECC_CD" ).append("\n"); 
		query.append(",I.CNTR_LSTM_CD" ).append("\n"); 
		query.append(",I.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",I.VNDR_CNT_CD" ).append("\n"); 
		query.append(",I.VNDR_SEQ" ).append("\n"); 
		query.append(",I.CNTR_DE_STS_CD" ).append("\n"); 
		query.append(",I.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",I.VNDR_ABBR_NM" ).append("\n"); 
		query.append(",I.CRE_USR_ID" ).append("\n"); 
		query.append(",I.CRE_DT" ).append("\n"); 
		query.append(",I.UPD_USR_ID" ).append("\n"); 
		query.append(",I.UPD_DT" ).append("\n"); 
		query.append(")  VALUES (" ).append("\n"); 
		query.append("@[pln_yrmon] ," ).append("\n"); 
		query.append("@[co_cd] ," ).append("\n"); 
		query.append("@[ecc_cd] ," ).append("\n"); 
		query.append("@[cntr_lstm_cd] ," ).append("\n"); 
		query.append("@[cntr_tpsz_cd] ," ).append("\n"); 
		query.append("@[vndr_cnt_cd] ," ).append("\n"); 
		query.append("@[vndr_seq] ," ).append("\n"); 
		query.append("@[cntr_de_sts_cd] ," ).append("\n"); 
		query.append("@[cntr_vol_qty]," ).append("\n"); 
		query.append("-- 주간정보인 경우에 sheet 에 정의된 파라메타명" ).append("\n"); 
		query.append("@[vndr_abbr_nm_cd]," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
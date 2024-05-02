/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOMergeYearNewvanPlanCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOMergeYearNewvanPlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_NEW_VAN_LONG_TERM 테이블의 데이터 수정/입력
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOMergeYearNewvanPlanCSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOMergeYearNewvanPlanCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_SCNR_NEW_VAN_LONG_TERM A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[scnr_id]  AS SCNR_ID," ).append("\n"); 
		query.append("@[pln_yrmon]  AS PLN_YRMON," ).append("\n"); 
		query.append("@[co_cd]  AS CO_CD," ).append("\n"); 
		query.append("@[ecc_cd]  AS ECC_CD," ).append("\n"); 
		query.append("@[cntr_lstm_cd]  AS CNTR_LSTM_CD," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]  AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("@[vndr_cnt_cd]  AS VNDR_CNT_CD," ).append("\n"); 
		query.append("@[vndr_seq]  AS VNDR_SEQ," ).append("\n"); 
		query.append("@[cntr_de_sts_cd]  AS CNTR_DE_STS_CD," ).append("\n"); 
		query.append("@[vndr_abbr_nm]  AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A.SCNR_ID        = B.SCNR_ID" ).append("\n"); 
		query.append("AND A.PLN_YRMON      = B.PLN_YRMON" ).append("\n"); 
		query.append("AND A.CO_CD          = B.CO_CD" ).append("\n"); 
		query.append("AND A.ECC_CD         = B.ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD   = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD   = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.VNDR_CNT_CD    = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND A.VNDR_SEQ       = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.CNTR_DE_STS_CD = B.CNTR_DE_STS_CD" ).append("\n"); 
		query.append("AND A.VNDR_ABBR_NM   = B.VNDR_ABBR_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.CNTR_VOL_QTY   = @[cntr_vol_qty]," ).append("\n"); 
		query.append("A.UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("A.UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("A.SCNR_ID       ," ).append("\n"); 
		query.append("A.PLN_YRMON     ," ).append("\n"); 
		query.append("A.CO_CD         ," ).append("\n"); 
		query.append("A.ECC_CD        ," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD  ," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD  ," ).append("\n"); 
		query.append("A.VNDR_CNT_CD   ," ).append("\n"); 
		query.append("A.VNDR_SEQ      ," ).append("\n"); 
		query.append("A.CNTR_DE_STS_CD," ).append("\n"); 
		query.append("A.CNTR_VOL_QTY  ," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM  ," ).append("\n"); 
		query.append("A.CRE_USR_ID    ," ).append("\n"); 
		query.append("A.CRE_DT        ," ).append("\n"); 
		query.append("A.UPD_USR_ID    ," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[scnr_id]," ).append("\n"); 
		query.append("@[pln_yrmon]," ).append("\n"); 
		query.append("@[co_cd]," ).append("\n"); 
		query.append("@[ecc_cd]," ).append("\n"); 
		query.append("@[cntr_lstm_cd]," ).append("\n"); 
		query.append("@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("@[vndr_cnt_cd]," ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("@[cntr_de_sts_cd]," ).append("\n"); 
		query.append("@[cntr_vol_qty]," ).append("\n"); 
		query.append("@[vndr_abbr_nm]," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
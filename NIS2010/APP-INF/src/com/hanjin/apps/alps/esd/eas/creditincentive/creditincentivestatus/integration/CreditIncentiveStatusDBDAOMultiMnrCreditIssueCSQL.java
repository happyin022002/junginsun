/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAOMultiMnrCreditIssueCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.11 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveStatusDBDAOMultiMnrCreditIssueCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R Credit Issue Save
	  * </pre>
	  */
	public CreditIncentiveStatusDBDAOMultiMnrCreditIssueCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mkr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("team_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_iss_evid_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration").append("\n"); 
		query.append("FileName : CreditIncentiveStatusDBDAOMultiMnrCreditIssueCSQL").append("\n"); 
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
		query.append("MERGE INTO EAS_MNR_CR_ISS A USING DUAL" ).append("\n"); 
		query.append("ON( A.CR_ISS_NO = @[cr_iss_no]" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("	   SET RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("          ,TEAM_CD = @[team_cd]" ).append("\n"); 
		query.append("          ,MKR_CD = @[mkr_cd]" ).append("\n"); 
		query.append("          ,CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("          ,CR_ISS_DT = TO_DATE(@[cr_iss_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,CR_ISS_UT_AMT = @[cr_iss_ut_amt]" ).append("\n"); 
		query.append("          ,CR_ISS_QTY = @[cr_iss_qty]" ).append("\n"); 
		query.append("          ,CR_ISS_TTL_AMT = @[cr_iss_ttl_amt]" ).append("\n"); 
		query.append("          ,CR_ISS_RSN = @[cr_iss_rsn]" ).append("\n"); 
		query.append("          ,LR_NM = @[lr_nm]" ).append("\n"); 
		query.append("          ,AGMT_NO = @[agmt_no]" ).append("\n"); 
		query.append("          ,LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("          ,EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("          ,CR_ISS_EVID_NO = @[cr_iss_evid_no]" ).append("\n"); 
		query.append("          ,CR_ISS_RMK = @[cr_iss_rmk]" ).append("\n"); 
		query.append("          ,ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append("          ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("          ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(CR_ISS_NO" ).append("\n"); 
		query.append("          ,RHQ_CD" ).append("\n"); 
		query.append("          ,TEAM_CD" ).append("\n"); 
		query.append("          ,MKR_CD" ).append("\n"); 
		query.append("          ,CR_ISS_DT" ).append("\n"); 
		query.append("          ,CURR_CD" ).append("\n"); 
		query.append("          ,CR_ISS_UT_AMT" ).append("\n"); 
		query.append("          ,CR_ISS_QTY" ).append("\n"); 
		query.append("          ,CR_ISS_TTL_AMT " ).append("\n"); 
		query.append("          ,CR_ISS_RSN" ).append("\n"); 
		query.append("          ,LR_NM" ).append("\n"); 
		query.append("          ,AGMT_NO" ).append("\n"); 
		query.append("          ,LSTM_CD" ).append("\n"); 
		query.append("          ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("          ,CR_ISS_EVID_NO" ).append("\n"); 
		query.append("          ,CR_ISS_RMK" ).append("\n"); 
		query.append("          ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("          ,CRE_USR_ID" ).append("\n"); 
		query.append("          ,CRE_DT" ).append("\n"); 
		query.append("          ,UPD_USR_ID" ).append("\n"); 
		query.append("          ,UPD_DT" ).append("\n"); 
		query.append("	)VALUES(" ).append("\n"); 
		query.append("           @[cr_iss_no]" ).append("\n"); 
		query.append("          ,@[rhq_cd]" ).append("\n"); 
		query.append("          ,@[team_cd]" ).append("\n"); 
		query.append("          ,@[mkr_cd]" ).append("\n"); 
		query.append("          ,TO_DATE(@[cr_iss_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("          ,@[curr_cd]" ).append("\n"); 
		query.append("          ,@[cr_iss_ut_amt]" ).append("\n"); 
		query.append("          ,@[cr_iss_qty]" ).append("\n"); 
		query.append("          ,@[cr_iss_ttl_amt]" ).append("\n"); 
		query.append("          ,@[cr_iss_rsn]" ).append("\n"); 
		query.append("          ,@[lr_nm]" ).append("\n"); 
		query.append("          ,@[agmt_no]" ).append("\n"); 
		query.append("          ,@[lstm_cd]" ).append("\n"); 
		query.append("          ,@[eq_tpsz_cd]" ).append("\n"); 
		query.append("          ,@[cr_iss_evid_no]" ).append("\n"); 
		query.append("          ,@[cr_iss_rmk]" ).append("\n"); 
		query.append("          ,@[atch_file_lnk_id]" ).append("\n"); 
		query.append("          ,@[usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE		" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnhireApprovalDBDAOaddOnhireApprovalNumberHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOaddOnhireApprovalNumberHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LSE_ONH_APRO_HIS를 생성한다.
	  * </pre>
	  */
	public OnhireApprovalDBDAOaddOnhireApprovalNumberHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_onh_auth_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("onh_apro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOaddOnhireApprovalNumberHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_ONH_APRO_HIS (" ).append("\n"); 
		query.append("    AGMT_CTY_CD" ).append("\n"); 
		query.append("  , AGMT_SEQ" ).append("\n"); 
		query.append("  , CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("  , ONH_APRO_SEQ" ).append("\n"); 
		query.append("  , LSEE_VNDR_SEQ" ).append("\n"); 
		query.append("  , LSTM_CD" ).append("\n"); 
		query.append("  , ONH_LOC_CD" ).append("\n"); 
		query.append("  , PKUP_FM_DT" ).append("\n"); 
		query.append("  , PKUP_DUE_DT" ).append("\n"); 
		query.append("  , MFT_YR" ).append("\n"); 
		query.append("  , FREE_DYS" ).append("\n"); 
		query.append("  , PKUP_CHG_AMT" ).append("\n"); 
		query.append("  , PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append("  , DPP_CHG_AMT" ).append("\n"); 
		query.append("  , MIN_ONH_DYS" ).append("\n"); 
		query.append("  , AUTH_DPP_FREE_DYS" ).append("\n"); 
		query.append("  , APRO_RMK" ).append("\n"); 
		query.append("  , DELT_FLG" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , EQ_LOC_TP_CD" ).append("\n"); 
		query.append("  , LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT AGMT_CTY_CD" ).append("\n"); 
		query.append("     , AGMT_SEQ" ).append("\n"); 
		query.append("     , CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("     , @[onh_apro_seq]" ).append("\n"); 
		query.append("     , LSEE_VNDR_SEQ" ).append("\n"); 
		query.append("     , LSTM_CD" ).append("\n"); 
		query.append("     , ONH_LOC_CD" ).append("\n"); 
		query.append("     , PKUP_FM_DT" ).append("\n"); 
		query.append("     , PKUP_DUE_DT" ).append("\n"); 
		query.append("     , MFT_YR" ).append("\n"); 
		query.append("     , FREE_DYS" ).append("\n"); 
		query.append("     , PKUP_CHG_AMT" ).append("\n"); 
		query.append("     , PKUP_CHG_CR_AMT" ).append("\n"); 
		query.append("     , DPP_CHG_AMT" ).append("\n"); 
		query.append("     , MIN_ONH_DYS" ).append("\n"); 
		query.append("     , AUTH_DPP_FREE_DYS" ).append("\n"); 
		query.append("     , APRO_RMK" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , EQ_LOC_TP_CD" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("  FROM LSE_ONH_APRO" ).append("\n"); 
		query.append(" WHERE CNTR_ONH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingFullHIstoryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingFullHIstoryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyAfterBookingFullHIstoryUSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingFullHIstoryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_cust_ans_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_act_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_bkg_full_his_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ans_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingFullHIstoryUSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_FULL_HIS_RQST" ).append("\n"); 
		query.append("  USING DUAL" ).append("\n"); 
		query.append("  ON (      AFT_EXPT_DAR_NO          =   @[aft_expt_dar_no]" ).append("\n"); 
		query.append("     AND    AFT_BKG_FULL_HIS_RQST_SEQ =   TO_NUMBER(@[aft_bkg_full_his_rqst_seq])" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET AFT_CUST_ANS_DT      =   TO_DATE(@[aft_cust_ans_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        , USR_ACT_RMK      =   @[usr_act_rmk]" ).append("\n"); 
		query.append("        , CUST_ANS_RMK      =   @[cust_ans_rmk]" ).append("\n"); 
		query.append("        , UPD_USR_ID    =   @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT        =   nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("          , AFT_BKG_FULL_HIS_RQST_SEQ" ).append("\n"); 
		query.append("          , AFT_CUST_ANS_DT" ).append("\n"); 
		query.append("          , USR_ACT_RMK" ).append("\n"); 
		query.append("          , CUST_ANS_RMK" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("    		@[aft_expt_dar_no]" ).append("\n"); 
		query.append("    	   ,NVL(( SELECT MAX(AFT_BKG_FULL_HIS_RQST_SEQ)+1 " ).append("\n"); 
		query.append("                    FROM DMT_AFT_BKG_FULL_HIS_RQST" ).append("\n"); 
		query.append("                   WHERE AFT_EXPT_DAR_NO = @[aft_expt_dar_no] ),1)" ).append("\n"); 
		query.append("    	   ,TO_DATE(@[aft_cust_ans_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("    	   ,@[usr_act_rmk]" ).append("\n"); 
		query.append("    	   ,@[cust_ans_rmk]" ).append("\n"); 
		query.append("    	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("    	   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("    	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("    	   ,nvl(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), sysdate)" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}
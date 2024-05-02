/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproRmkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.05 
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

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproRmkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproRmk
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproRmkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_mgr_cmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_mgr_rslt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bbg_rslt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_pic_cmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_pic_rslt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bbo_cmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bbg_cmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_mgr_rslt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_pic_cmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_path_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_pic_rslt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bbo_rslt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ho_mgr_cmt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingAproRmkUSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_APRO_RMK RMK" ).append("\n"); 
		query.append("  USING (" ).append("\n"); 
		query.append("                SELECT @[aft_expt_dar_no] AS AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                     , @[aft_bkg_path_cd] AS AFT_BKG_PATH_CD" ).append("\n"); 
		query.append("                     , @[seq] AS AFT_BKG_ITM_LVL" ).append("\n"); 
		query.append("                     , CASE @[aft_bkg_path_cd] WHEN 'BBOPIC' THEN @[bbo_rslt]" ).append("\n"); 
		query.append("                                               WHEN 'BBGMGR' THEN @[bbg_rslt]" ).append("\n"); 
		query.append("                                               WHEN 'RHQPIC' THEN @[rhq_pic_rslt]" ).append("\n"); 
		query.append("                                               WHEN 'RHQMGR' THEN @[rhq_mgr_rslt]" ).append("\n"); 
		query.append("                                               WHEN 'HDOPIC' THEN @[ho_pic_rslt]" ).append("\n"); 
		query.append("                                               WHEN 'HDOMGR' THEN @[ho_mgr_rslt]" ).append("\n"); 
		query.append("                                               ELSE '' END AS DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("                     , CASE @[aft_bkg_path_cd] WHEN 'BBOPIC' THEN @[bbo_cmt]" ).append("\n"); 
		query.append("                                               WHEN 'BBGMGR' THEN @[bbg_cmt]" ).append("\n"); 
		query.append("                                               WHEN 'RHQPIC' THEN @[rhq_pic_cmt]" ).append("\n"); 
		query.append("                                               WHEN 'RHQMGR' THEN @[rhq_mgr_cmt]" ).append("\n"); 
		query.append("                                               WHEN 'HDOPIC' THEN @[ho_pic_cmt]" ).append("\n"); 
		query.append("                                               WHEN 'HDOMGR' THEN @[ho_mgr_cmt]" ).append("\n"); 
		query.append("                                               ELSE '' END AS AFT_BKG_APRO_RMK" ).append("\n"); 
		query.append("                FROM DUAL ) AA" ).append("\n"); 
		query.append("  ON (      RMK.AFT_EXPT_DAR_NO =  AA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("     AND    RMK.AFT_BKG_PATH_CD =  AA.AFT_BKG_PATH_CD" ).append("\n"); 
		query.append("     AND    RMK.AFT_BKG_ITM_LVL =  AA.AFT_BKG_ITM_LVL" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("      SET RMK.DMDT_EXPT_RQST_STS_CD      =   AA.DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("        , RMK.AFT_BKG_APRO_RMK      =   AA.AFT_BKG_APRO_RMK" ).append("\n"); 
		query.append("        , UPD_USR_ID    =   @[upd_usr_id]" ).append("\n"); 
		query.append("        , UPD_DT        =   sysdate" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("          , AFT_BKG_PATH_CD" ).append("\n"); 
		query.append("          , AFT_BKG_ITM_LVL" ).append("\n"); 
		query.append("          , DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("          , AFT_BKG_APRO_RMK" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("    		AA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("          , AA.AFT_BKG_PATH_CD" ).append("\n"); 
		query.append("          , AA.AFT_BKG_ITM_LVL" ).append("\n"); 
		query.append("          , AA.DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("          , AA.AFT_BKG_APRO_RMK" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}
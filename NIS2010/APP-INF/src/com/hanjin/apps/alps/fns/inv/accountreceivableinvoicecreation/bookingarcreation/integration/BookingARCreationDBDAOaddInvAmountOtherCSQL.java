/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOaddInvAmountOtherCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.07.23 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOaddInvAmountOtherCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOaddInvAmountOtherCSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOaddInvAmountOtherCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_inv_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_coa_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOaddInvAmountOtherCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_AMT (" ).append("\n"); 
		query.append("       AR_IF_NO" ).append("\n"); 
		query.append("     , AR_IF_SER_NO" ).append("\n"); 
		query.append("     , TJ_SRC_NM" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , INV_AMT" ).append("\n"); 
		query.append("     , AR_INV_SRC_CD " ).append("\n"); 
		query.append("     , INV_COA_CO_CD " ).append("\n"); 
		query.append("     , INV_COA_RGN_CD " ).append("\n"); 
		query.append("     , INV_COA_CTR_CD " ).append("\n"); 
		query.append("     , INV_COA_ACCT_CD " ).append("\n"); 
		query.append("     , INV_COA_INTER_CO_CD " ).append("\n"); 
		query.append("     , INV_COA_VSL_CD " ).append("\n"); 
		query.append("     , INV_COA_VOY_NO " ).append("\n"); 
		query.append("     , INV_COA_SKD_DIR_CD " ).append("\n"); 
		query.append("     , INV_COA_REV_DIR_CD" ).append("\n"); 
		query.append("     , ERP_IF_GL_DT" ).append("\n"); 
		query.append("     , ERP_IF_OFC_CD " ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT)" ).append("\n"); 
		query.append("(SELECT @[ar_if_no]" ).append("\n"); 
		query.append("     , A.AR_IF_SER_NO" ).append("\n"); 
		query.append("     , A.TJ_SRC_NM" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , @[ar_inv_src_cd]" ).append("\n"); 
		query.append("     , @[inv_coa_co_cd]" ).append("\n"); 
		query.append("     , @[inv_coa_rgn_cd]" ).append("\n"); 
		query.append("     , @[inv_coa_ctr_cd]" ).append("\n"); 
		query.append("     , (SELECT DECODE(A.TJ_SRC_NM, 'WHF', DECODE(@[svr_id], 'KOR', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '110611', '111021'), '110611')," ).append("\n"); 
		query.append("                                            DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MCT', '110811'," ).append("\n"); 
		query.append("                                                                                'MDJ', @[acct_cd]," ).append("\n"); 
		query.append("                                                                                'MTH', @[acct_cd]," ).append("\n"); 
		query.append("                                                                                'MSO', '111091'," ).append("\n"); 
		query.append("                                                                                'MTP', '111091'," ).append("\n"); 
		query.append("                                                                                'MRD', '111091'," ).append("\n"); 
		query.append("                                                                                'MLS', '111091'," ).append("\n"); 
		query.append("                                                                                'MDO', '111091'," ).append("\n"); 
		query.append("                                                                                       '110611')) " ).append("\n"); 
		query.append("          FROM DUAL) " ).append("\n"); 
		query.append("     , @[inv_coa_inter_co_cd]" ).append("\n"); 
		query.append("     , @[inv_coa_vsl_cd]" ).append("\n"); 
		query.append("     , @[inv_coa_voy_no]" ).append("\n"); 
		query.append("     , @[inv_coa_skd_dir_cd]" ).append("\n"); 
		query.append("     , @[inv_coa_rev_dir_cd]" ).append("\n"); 
		query.append("     , @[erp_if_gl_dt]" ).append("\n"); 
		query.append("     , @[erp_if_ofc_cd]" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[upd_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("FROM (SELECT IAC.AR_IF_SER_NO" ).append("\n"); 
		query.append("           , IAC.CURR_CD" ).append("\n"); 
		query.append("           , ROUND(SUM(IAC.CHG_AMT), MC.DP_PRCS_KNT) INV_AMT" ).append("\n"); 
		query.append("           , IAC.TJ_SRC_NM" ).append("\n"); 
		query.append("        FROM INV_AR_CHG IAC" ).append("\n"); 
		query.append("           , MDM_CURRENCY MC" ).append("\n"); 
		query.append("       WHERE AR_IF_NO = @[ar_if_no] " ).append("\n"); 
		query.append("         AND IAC.CURR_CD = MC.CURR_CD" ).append("\n"); 
		query.append("GROUP BY IAC.AR_IF_SER_NO, IAC.CURR_CD, IAC.TJ_SRC_NM, MC.DP_PRCS_KNT) A)" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchInvArIfMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.10 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchInvArIfMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchInvArIfMainRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchInvArIfMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchInvArIfMainRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   I.SRC_IF_DT, I.SRC_IF_SEQ, I.BL_NO, " ).append("\n"); 
		query.append("   I.BL_TP_CD, I.BL_SRC_NO, I.INV_SRC_NO, " ).append("\n"); 
		query.append("   I.BKG_NO, I.BKG_CORR_NO, I.BKG_CORR_DT, " ).append("\n"); 
		query.append("   I.VVD_TRNS_FLG, I.CUST_CNT_CD, I.CUST_SEQ, " ).append("\n"); 
		query.append("   I.FRT_FWRD_CNT_CD, I.FRT_FWRD_CUST_SEQ, I.OFC_CD, " ).append("\n"); 
		query.append("   I.IF_SRC_CD, I.VSL_CD, I.SKD_VOY_NO, " ).append("\n"); 
		query.append("   I.SKD_DIR_CD, I.SVC_SCP_CD, I.SAIL_DT, " ).append("\n"); 
		query.append("   I.SAIL_ARR_DT, I.DUE_DT, I.GL_EFF_DT, " ).append("\n"); 
		query.append("   I.SLAN_CD, I.IO_BND_CD, I.TRNK_VSL_CD, " ).append("\n"); 
		query.append("   I.TRNK_SKD_VOY_NO, I.TRNK_SKD_DIR_CD, I.POR_CD, " ).append("\n"); 
		query.append("   I.POL_CD, I.POD_CD, I.DEL_CD, " ).append("\n"); 
		query.append("   I.CGO_WGT, I.CGO_MEAS_QTY, I.BKG_TEU_QTY, " ).append("\n"); 
		query.append("   I.BKG_FEU_QTY, I.SC_NO, I.RFA_NO, " ).append("\n"); 
		query.append("   I.SREP_CD, I.SLS_OFC_CD, I.MST_BL_NO, " ).append("\n"); 
		query.append("   I.DEST_TRNS_SVC_MOD_CD, I.SI_REF_NO, " ).append("\n"); 
		query.append("   I.BKG_REF_NO, I.INV_REF_NO, I.BL_INV_IF_FLG, " ).append("\n"); 
		query.append("   I.BL_INV_IF_DT, I.AR_IF_NO, I.IF_ERR_RSN, " ).append("\n"); 
		query.append("   I.TRSP_RQST_ORD_FLG, I.AP_AR_OFFST_NO, I.INV_RMK, " ).append("\n"); 
		query.append("   I.OFC_TRNS_FLG," ).append("\n"); 
		query.append("   I.CRE_USR_ID, I.CRE_DT, I.UPD_USR_ID, " ).append("\n"); 
		query.append("   I.UPD_DT" ).append("\n"); 
		query.append("FROM INV_AR_IF_MN I" ).append("\n"); 
		query.append("WHERE SRC_IF_DT = @[src_if_dt]" ).append("\n"); 
		query.append("  AND SRC_IF_SEQ = @[src_if_seq]" ).append("\n"); 

	}
}
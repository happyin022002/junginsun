/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchBKGInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.05.26 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchBKGInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchBKGInterfaceRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchBKGInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchBKGInterfaceRSQL").append("\n"); 
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
		query.append("SELECT BL_TP_CD," ).append("\n"); 
		query.append("       TRNK_VSL_CD," ).append("\n"); 
		query.append("	   TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("	   DEL_CD," ).append("\n"); 
		query.append("       CGO_WGT," ).append("\n"); 
		query.append("       CGO_MEAS_QTY," ).append("\n"); 
		query.append("       SREP_CD," ).append("\n"); 
		query.append("       BKG_REF_NO," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       MST_BL_NO," ).append("\n"); 
		query.append("       INV_REF_NO," ).append("\n"); 
		query.append("       SI_REF_NO," ).append("\n"); 
		query.append("       BKG_TEU_QTY," ).append("\n"); 
		query.append("       BKG_FEU_QTY," ).append("\n"); 
		query.append("       FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("	   FRT_FWRD_CUST_SEQ," ).append("\n"); 
		query.append("       '' VVD_TRNS_FLG," ).append("\n"); 
		query.append("	   DEST_SVC_MOD_CD," ).append("\n"); 
		query.append("       BDR_IND_FLG," ).append("\n"); 
		query.append("       BKG_CORR_NO," ).append("\n"); 
		query.append("       TO_CHAR(BKG_CORR_DT,'YYYY/MM/DD HH24:MI:SS') BKG_CORR_DT," ).append("\n"); 
		query.append("       CA_RSN_CD," ).append("\n"); 
		query.append("       WHF_DECL_NO," ).append("\n"); 
		query.append("	   WHF_DECL_CFM_DT," ).append("\n"); 
		query.append("       WHF_DECL_OFC_CD," ).append("\n"); 
		query.append("       WHF_MRN_NO," ).append("\n"); 
		query.append("       WHF_NTC_NO," ).append("\n"); 
		query.append("       WHF_DECL_VSL_CD," ).append("\n"); 
		query.append("       WHF_DECL_VOY_NO," ).append("\n"); 
		query.append("       WHF_DECL_DIR_CD," ).append("\n"); 
		query.append("       CXL_FLG," ).append("\n"); 
		query.append("       CSR_NO," ).append("\n"); 
		query.append("	   CTRT_OFC_CD," ).append("\n"); 
		query.append("	   NVL((SELECT 'Y' FROM DUAL" ).append("\n"); 
		query.append("         	 WHERE EXISTS (SELECT 1 FROM INV_BKG_IF_CHG " ).append("\n"); 
		query.append("							WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("							  AND BKG_SEQ = @[bkg_seq] " ).append("\n"); 
		query.append("							  AND OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                       						   WHERE AR_OFC_CD = ( SELECT AR_OFC_CD " ).append("\n"); 
		query.append("                         											 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        											WHERE OFC_CD = @[ofc_cd] ))" ).append("\n"); 
		query.append("							  AND WHF_FLG='Y')),'N') WHF_FLG," ).append("\n"); 
		query.append("	   OBRD_DT" ).append("\n"); 
		query.append("  FROM INV_BKG_IF_MN" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 

	}
}
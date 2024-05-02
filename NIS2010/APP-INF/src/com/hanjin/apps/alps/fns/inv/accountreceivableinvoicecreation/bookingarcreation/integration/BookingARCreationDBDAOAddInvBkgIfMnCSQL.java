/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOAddInvBkgIfMnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.20 최도순
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

public class BookingARCreationDBDAOAddInvBkgIfMnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOAddInvBkgIfMnCSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOAddInvBkgIfMnCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_BKG_IF_MN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO ," ).append("\n"); 
		query.append("BKG_SEQ ," ).append("\n"); 
		query.append("BKG_TMS ," ).append("\n"); 
		query.append("SRC_IF_DT ," ).append("\n"); 
		query.append("BL_SRC_NO ," ).append("\n"); 
		query.append("BL_TP_CD ," ).append("\n"); 
		query.append("BKG_STS_CD ," ).append("\n"); 
		query.append("CXL_FLG ," ).append("\n"); 
		query.append("CXL_DT ," ).append("\n"); 
		query.append("BDR_IND_FLG ," ).append("\n"); 
		query.append("BKG_CORR_NO ," ).append("\n"); 
		query.append("BKG_CORR_DT ," ).append("\n"); 
		query.append("CA_RSN_CD ," ).append("\n"); 
		query.append("SLAN_CD ," ).append("\n"); 
		query.append("TRNK_VSL_CD ," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO ," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD ," ).append("\n"); 
		query.append("REV_DIR_CD ," ).append("\n"); 
		query.append("POR_CD ," ).append("\n"); 
		query.append("POL_CD ," ).append("\n"); 
		query.append("POD_CD ," ).append("\n"); 
		query.append("DEL_CD ," ).append("\n"); 
		query.append("CGO_WGT ," ).append("\n"); 
		query.append("CGO_MEAS_QTY ," ).append("\n"); 
		query.append("SREP_CD ," ).append("\n"); 
		query.append("DEST_SVC_MOD_CD ," ).append("\n"); 
		query.append("MST_BL_NO ," ).append("\n"); 
		query.append("SVC_SCP_CD ," ).append("\n"); 
		query.append("BKG_REF_NO ," ).append("\n"); 
		query.append("INV_REF_NO ," ).append("\n"); 
		query.append("SI_REF_NO ," ).append("\n"); 
		query.append("AUTO_MNL_DIV_CD ," ).append("\n"); 
		query.append("FRT_FWRD_CNT_CD ," ).append("\n"); 
		query.append("FRT_FWRD_CUST_SEQ ," ).append("\n"); 
		query.append("SC_NO ," ).append("\n"); 
		query.append("RFA_NO ," ).append("\n"); 
		query.append("BKG_TEU_QTY ," ).append("\n"); 
		query.append("BKG_FEU_QTY ," ).append("\n"); 
		query.append("POL_VSL_CD ," ).append("\n"); 
		query.append("POL_SKD_VOY_NO ," ).append("\n"); 
		query.append("POL_SKD_DIR_CD ," ).append("\n"); 
		query.append("POD_VSL_CD ," ).append("\n"); 
		query.append("POD_SKD_VOY_NO ," ).append("\n"); 
		query.append("POD_SKD_DIR_CD ," ).append("\n"); 
		query.append("TRO_PAYR_CNT_CD ," ).append("\n"); 
		query.append("TRO_PAYR_SEQ ," ).append("\n"); 
		query.append("TRO_IO_BND_CD ," ).append("\n"); 
		query.append("WHF_DECL_NO ," ).append("\n"); 
		query.append("WHF_DECL_CFM_DT ," ).append("\n"); 
		query.append("WHF_DECL_OFC_CD ," ).append("\n"); 
		query.append("WHF_MRN_NO ," ).append("\n"); 
		query.append("WHF_NTC_NO ," ).append("\n"); 
		query.append("WHF_DECL_VSL_CD ," ).append("\n"); 
		query.append("WHF_DECL_VOY_NO ," ).append("\n"); 
		query.append("WHF_DECL_DIR_CD ," ).append("\n"); 
		query.append("CSR_NO ," ).append("\n"); 
		query.append("CHN_AGN_CD ," ).append("\n"); 
		query.append("INV_AR_IF_CD ," ).append("\n"); 
		query.append("AR_IF_ERR_RSN ," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO ," ).append("\n"); 
		query.append("@[bkg_seq] ," ).append("\n"); 
		query.append("SYSTIMESTAMP ," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE,'YYYYMMDD') SRC_IF_DT," ).append("\n"); 
		query.append("BL_SRC_NO ," ).append("\n"); 
		query.append("BL_TP_CD ," ).append("\n"); 
		query.append("BKG_STS_CD ," ).append("\n"); 
		query.append("CXL_FLG ," ).append("\n"); 
		query.append("CXL_DT ," ).append("\n"); 
		query.append("BDR_IND_FLG ," ).append("\n"); 
		query.append("BKG_CORR_NO ," ).append("\n"); 
		query.append("BKG_CORR_DT ," ).append("\n"); 
		query.append("CA_RSN_CD ," ).append("\n"); 
		query.append("SLAN_CD ," ).append("\n"); 
		query.append("TRNK_VSL_CD ," ).append("\n"); 
		query.append("TRNK_SKD_VOY_NO ," ).append("\n"); 
		query.append("TRNK_SKD_DIR_CD ," ).append("\n"); 
		query.append("REV_DIR_CD ," ).append("\n"); 
		query.append("POR_CD ," ).append("\n"); 
		query.append("POL_CD ," ).append("\n"); 
		query.append("POD_CD ," ).append("\n"); 
		query.append("DEL_CD ," ).append("\n"); 
		query.append("CGO_WGT ," ).append("\n"); 
		query.append("CGO_MEAS_QTY ," ).append("\n"); 
		query.append("SREP_CD ," ).append("\n"); 
		query.append("DEST_SVC_MOD_CD ," ).append("\n"); 
		query.append("MST_BL_NO ," ).append("\n"); 
		query.append("SVC_SCP_CD ," ).append("\n"); 
		query.append("BKG_REF_NO ," ).append("\n"); 
		query.append("INV_REF_NO ," ).append("\n"); 
		query.append("SI_REF_NO ," ).append("\n"); 
		query.append("AUTO_MNL_DIV_CD ," ).append("\n"); 
		query.append("FRT_FWRD_CNT_CD ," ).append("\n"); 
		query.append("FRT_FWRD_CUST_SEQ ," ).append("\n"); 
		query.append("SC_NO ," ).append("\n"); 
		query.append("RFA_NO ," ).append("\n"); 
		query.append("BKG_TEU_QTY ," ).append("\n"); 
		query.append("BKG_FEU_QTY ," ).append("\n"); 
		query.append("SUBSTR(POL_VVD,1,4) POL_VSL_CD ," ).append("\n"); 
		query.append("SUBSTR(POL_VVD,5,4) POL_SKD_VOY_NO ," ).append("\n"); 
		query.append("SUBSTR(POL_VVD,9,1) POL_SKD_DIR_CD ," ).append("\n"); 
		query.append("SUBSTR(POD_VVD,1,4) POD_VSL_CD ," ).append("\n"); 
		query.append("SUBSTR(POD_VVD,5,4) POD_SKD_VOY_NO ," ).append("\n"); 
		query.append("SUBSTR(POD_VVD,9,1) POD_SKD_DIR_CD ," ).append("\n"); 
		query.append("TRO_PAYR_CNT_CD ," ).append("\n"); 
		query.append("TRO_PAYR_SEQ ," ).append("\n"); 
		query.append("TRO_IO_BND_CD ," ).append("\n"); 
		query.append("WHF_DECL_NO ," ).append("\n"); 
		query.append("WHF_DECL_CFM_DT ," ).append("\n"); 
		query.append("WHF_DECL_OFC_CD ," ).append("\n"); 
		query.append("WHF_MRN_NO ," ).append("\n"); 
		query.append("WHF_NTC_NO ," ).append("\n"); 
		query.append("SUBSTR(WHF_VVD,1,4) WHF_DECL_VSL_CD ," ).append("\n"); 
		query.append("SUBSTR(WHF_VVD,5,4) WHF_DECL_VOY_NO ," ).append("\n"); 
		query.append("SUBSTR(WHF_VVD,9,1) WHF_DECL_DIR_CD ," ).append("\n"); 
		query.append("CSR_NO ," ).append("\n"); 
		query.append("CHN_AGN_CD ," ).append("\n"); 
		query.append("'N' ," ).append("\n"); 
		query.append("'' ," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM TABLE (BKG_INV_IF_PKG.BKG_IF_HEADER_TBL_FUNC(@[bkg_no]))" ).append("\n"); 

	}
}
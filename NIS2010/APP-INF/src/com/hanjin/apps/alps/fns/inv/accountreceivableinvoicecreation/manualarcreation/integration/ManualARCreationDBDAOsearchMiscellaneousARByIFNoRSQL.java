/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchMiscellaneousARByIFNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.02.19 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchMiscellaneousARByIFNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManualARCreationDBDAOsearchMiscellaneousARByIFNoRSQL
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchMiscellaneousARByIFNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchMiscellaneousARByIFNoRSQL").append("\n"); 
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
		query.append("SELECT C.BL_SRC_NO" ).append("\n"); 
		query.append(", C.AR_OFC_CD" ).append("\n"); 
		query.append(", C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", LPAD(C.ACT_CUST_SEQ, 6, 0) ACT_CUST_SEQ" ).append("\n"); 
		query.append(", A.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append(", A.CUST_RGST_NO CUST_RGST_NO" ).append("\n"); 
		query.append(", B.CR_CURR_CD CR_CURR_CD" ).append("\n"); 
		query.append(", B.CR_AMT CR_AMT" ).append("\n"); 
		query.append(", B.IB_CR_TERM_DYS IB_CR_TERM_DYS" ).append("\n"); 
		query.append(", B.OB_CR_TERM_DYS OB_CR_TERM_DYS" ).append("\n"); 
		query.append(", B.CR_CLT_OFC_CD CR_CLT_OFC_CD" ).append("\n"); 
		query.append(", C.REV_TP_CD" ).append("\n"); 
		query.append(", C.REV_SRC_CD" ).append("\n"); 
		query.append(", C.VSL_CD" ).append("\n"); 
		query.append(", C.SKD_VOY_NO" ).append("\n"); 
		query.append(", C.SKD_DIR_CD" ).append("\n"); 
		query.append(", C.SVC_SCP_CD" ).append("\n"); 
		query.append(", C.IO_BND_CD" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(C.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD') SAIL_ARR_DT" ).append("\n"); 
		query.append(", C.TRNK_VSL_CD" ).append("\n"); 
		query.append(", C.TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(", C.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(", C.POR_CD" ).append("\n"); 
		query.append(", C.POL_CD" ).append("\n"); 
		query.append(", C.POD_CD" ).append("\n"); 
		query.append(", C.DEL_CD" ).append("\n"); 
		query.append(", C.MST_BL_NO" ).append("\n"); 
		query.append(", C.HJS_STF_CTNT" ).append("\n"); 
		query.append(", C.BKG_TEU_QTY" ).append("\n"); 
		query.append(", C.BKG_FEU_QTY" ).append("\n"); 
		query.append(", C.INV_REF_NO" ).append("\n"); 
		query.append(", C.BKG_REF_NO" ).append("\n"); 
		query.append(", C.SI_REF_NO" ).append("\n"); 
		query.append(", C.INV_RMK" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(C.DUE_DT, 'YYYYMMDD'), 'YYYY-MM-DD') DUE_DT" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(C.GL_EFF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') GL_EFF_DT" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(C.BL_INV_IF_DT, 'YYYYMMDD'), 'YYYY-MM-DD') BL_INV_IF_DT" ).append("\n"); 
		query.append(", NVL(A.DELT_FLG, 'Y') DELT_FLG" ).append("\n"); 
		query.append(", C.BL_INV_CFM_DT" ).append("\n"); 
		query.append(", C.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN C" ).append("\n"); 
		query.append(", MDM_CUSTOMER A" ).append("\n"); 
		query.append(", MDM_CR_CUST B" ).append("\n"); 
		query.append("WHERE C.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD(+) = C.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ(+) = C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 

	}
}
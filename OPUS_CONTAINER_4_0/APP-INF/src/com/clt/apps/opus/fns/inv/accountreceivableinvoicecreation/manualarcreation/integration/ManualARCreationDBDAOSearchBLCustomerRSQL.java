/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchBLCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchBLCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 BL_SRC NO, AR_OFC_CD의 MAX(AR_IF_NO)의 ACT_CUST_CNT_CD, ACT_CUST_SEQ 관련 정보를 가져온다.
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchBLCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchBLCustomerRSQL").append("\n"); 
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
		query.append("SELECT B.CUST_CNT_CD," ).append("\n"); 
		query.append("  B.CUST_SEQ," ).append("\n"); 
		query.append("  C.CR_CURR_CD CR_CURR_CD," ).append("\n"); 
		query.append("  C.CR_AMT CR_AMT," ).append("\n"); 
		query.append("  C.IB_CR_TERM_DYS IB_CR_TERM_DYS," ).append("\n"); 
		query.append("  C.OB_CR_TERM_DYS OB_CR_TERM_DYS," ).append("\n"); 
		query.append("  C.CR_CLT_OFC_CD CR_CLT_OFC_CD," ).append("\n"); 
		query.append("  C.LOCL_NM CUST_NM," ).append("\n"); 
		query.append("  B.CUST_LGL_ENG_NM CUST_ENG_NM," ).append("\n"); 
		query.append("  C.OB_PHN_NO OB_PHN_NO," ).append("\n"); 
		query.append("  C.IB_PHN_NO IB_PHN_NO," ).append("\n"); 
		query.append("  C.OB_FAX_NO OB_FAX_NO," ).append("\n"); 
		query.append("  C.IB_FAX_NO IB_FAX_NO," ).append("\n"); 
		query.append("  C.CNTC_PSON_NM CNTC_PSON_NM," ).append("\n"); 
		query.append("  C.BZCT_NM BZCT_NM," ).append("\n"); 
		query.append("  C.BZTP_NM BZTP_NM," ).append("\n"); 
		query.append("  B.CUST_RGST_NO CUST_RGST_NO," ).append("\n"); 
		query.append("  A.OTS_PAY_CD, --migration data" ).append("\n"); 
		query.append("  A.ORG_INV_NO, --migration data" ).append("\n"); 
		query.append("  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS OTH_LCL_VVD," ).append("\n"); 
		query.append("  A.POL_CD AS OTH_POL_CD," ).append("\n"); 
		query.append("  A.SVC_SCP_CD AS OTH_SVC_SCP_CD," ).append("\n"); 
		query.append("  A.IO_BND_CD AS OTH_IO_BND_CD," ).append("\n"); 
		query.append("  A.SAIL_DT AS OTH_SAIL_DT," ).append("\n"); 
		query.append("  A.SAIL_ARR_DT AS OTH_SAIL_ARR_DT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CUSTOMER B," ).append("\n"); 
		query.append("  MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE B.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("  AND B.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("  AND B.CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("  AND B.CUST_SEQ = A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("  AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceMainByIFNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.05 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchARInvoiceMainByIFNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceCorrectionDBDAO::searchARInvoiceMainByIFNo
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchARInvoiceMainByIFNoVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceMainByIFNoVORSQL").append("\n"); 
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
		query.append("	A.SC_NO        				SC_NO     " ).append("\n"); 
		query.append(",	A.RFA_NO       				RFA_NO    " ).append("\n"); 
		query.append(",	A.INV_RMK      				INV_RMK   " ).append("\n"); 
		query.append(",	A.MST_BL_NO    				MST_BL_NO " ).append("\n"); 
		query.append(",	A.BKG_REF_NO   				BKG_REF_NO" ).append("\n"); 
		query.append(",	A.INV_REF_NO   				INV_REF_NO" ).append("\n"); 
		query.append(",	A.SI_REF_NO             	SI_REF_NO      " ).append("\n"); 
		query.append(",	A.HJS_STF_CTNT            	HJS_STF_CTNT    " ).append("\n"); 
		query.append(",	A.AR_IF_NO              	AR_IF_NO       " ).append("\n"); 
		query.append(",	A.BL_SRC_NO             	BL_SRC_NO      " ).append("\n"); 
		query.append(",	A.BKG_NO                	BKG_NO         " ).append("\n"); 
		query.append(",	A.BKG_CORR_NO           	BKG_CORR_NO    " ).append("\n"); 
		query.append(",	to_char(A.BKG_CORR_DT,'yyyymmdd')    	 		BKG_CORR_DT    " ).append("\n"); 
		query.append(",	A.ACT_CUST_CNT_CD 			ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	LPAD(A.ACT_CUST_SEQ,6,0) 	ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	A.AR_OFC_CD             	AR_OFC_CD  " ).append("\n"); 
		query.append(",	A.REV_TP_CD             	REV_TP_CD  " ).append("\n"); 
		query.append(",	A.REV_SRC_CD            	REV_SRC_CD " ).append("\n"); 
		query.append(",	A.VSL_CD                	VSL_CD     " ).append("\n"); 
		query.append(",	A.SKD_VOY_NO            	SKD_VOY_NO " ).append("\n"); 
		query.append(",	A.SKD_DIR_CD    			SKD_DIR_CD " ).append("\n"); 
		query.append(",	A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD LOCAL_VVD" ).append("\n"); 
		query.append(",	A.SVC_SCP_CD            	SVC_SCP_CD     " ).append("\n"); 
		query.append(",	A.SAIL_ARR_DT           	SAIL_ARR_DT    " ).append("\n"); 
		query.append(",	A.SLAN_CD               	SLAN_CD        " ).append("\n"); 
		query.append(",	decode(A.IO_BND_CD,'I','I/B','O/B')    	IO_BND_CD      " ).append("\n"); 
		query.append(",	A.TRNK_VSL_CD           	TRNK_VSL_CD    " ).append("\n"); 
		query.append(",	A.TRNK_SKD_VOY_NO       	TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",	A.TRNK_SKD_DIR_CD 			TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",	A.TRNK_VSL_CD || A.TRNK_SKD_VOY_NO || A.TRNK_SKD_DIR_CD TRUNK_VVD" ).append("\n"); 
		query.append(",	A.POR_CD                	POR_CD         " ).append("\n"); 
		query.append(",	A.POL_CD                	POL_CD         " ).append("\n"); 
		query.append(",	A.POD_CD                	POD_CD         " ).append("\n"); 
		query.append(",	A.DEL_CD                	DEL_CD         " ).append("\n"); 
		query.append(",	A.INV_CUST_CNT_CD			INV_CUST_CNT_CD" ).append("\n"); 
		query.append(",	LPAD(A.INV_CUST_SEQ,6,0)	INV_CUST_SEQ" ).append("\n"); 
		query.append(",	A.SREP_CD               	SREP_CD          " ).append("\n"); 
		query.append(",	A.CGO_WGT               	CGO_WGT          " ).append("\n"); 
		query.append(",	A.CGO_MEAS_QTY          	CGO_MEAS_QTY     " ).append("\n"); 
		query.append(",	A.WHF_DECL_NO           	WHF_DECL_NO      " ).append("\n"); 
		query.append(",	A.WHF_DECL_CFM_DT      		WHF_DECL_CFM_DT  " ).append("\n"); 
		query.append(",	A.BKG_TEU_QTY           	BKG_TEU_QTY      " ).append("\n"); 
		query.append(",	A.BKG_FEU_QTY           	BKG_FEU_QTY      " ).append("\n"); 
		query.append(",	A.BL_INV_IF_DT          	BL_INV_IF_DT     " ).append("\n"); 
		query.append(",	A.BL_INV_CFM_DT         	BL_INV_CFM_DT    " ).append("\n"); 
		query.append(",	A.GL_EFF_DT             	GL_EFF_DT        " ).append("\n"); 
		query.append(",	A.DUE_DT                	DUE_DT           " ).append("\n"); 
		query.append(",	A.FRT_FWRD_CNT_CD       	FRT_FWRD_CNT_CD  " ).append("\n"); 
		query.append(",	A.FRT_FWRD_CUST_SEQ     	FRT_FWRD_CUST_SEQ" ).append("\n"); 
		query.append(",	B.INV_NO					INV_NO    " ).append("\n"); 
		query.append(",	C.CUST_LOCL_LANG_NM			CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append(",	C.CUST_LGL_ENG_NM       	CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",	C.CUST_LGL_ENG_NM			CUST_NM" ).append("\n"); 
		query.append(",	C.CUST_RGST_NO          	CUST_RGST_NO   " ).append("\n"); 
		query.append(",	D.CR_CURR_CD            	CR_CURR_CD     " ).append("\n"); 
		query.append(",	D.CR_AMT                	CR_AMT         " ).append("\n"); 
		query.append(",	D.OB_CR_TERM_DYS        	OB_CR_TERM_DYS " ).append("\n"); 
		query.append(",	D.IB_CR_TERM_DYS        	IB_CR_TERM_DYS " ).append("\n"); 
		query.append(",	D.CR_CLT_OFC_CD         	CR_CLT_OFC_CD  " ).append("\n"); 
		query.append(",	A.CR_TERM_DYS				CR_TERM_DYS" ).append("\n"); 
		query.append(",	B.INV_NO                	INV_NO         " ).append("\n"); 
		query.append(",	E.ISS_DT                	ISS_DT         " ).append("\n"); 
		query.append(",	D.CR_FLG					CR_FLG   " ).append("\n"); 
		query.append(",	A.ZN_IOC_CD					ZN_IOC_CD     " ).append("\n"); 
		query.append(", 	LOCL_CURR_CD				LOCL_CURR_CD	" ).append("\n"); 
		query.append(",	A.INV_DELT_DIV_CD			INV_DELT_DIV_CD" ).append("\n"); 
		query.append(",	A.CUST_CR_FLG				CUST_CR_FLG" ).append("\n"); 
		query.append(",   A.XCH_RT_N3RD_TP_CD   		XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(",   A.XCH_RT_USD_TP_CD 			XCH_RT_USD_TP_CD" ).append("\n"); 
		query.append(",   A.XCH_RT_DT 				XCH_RT_DT" ).append("\n"); 
		query.append(",   A.SAIL_DT 					SAIL_DT" ).append("\n"); 
		query.append(",   A.USD_XCH_RT 				USD_XCH_RT" ).append("\n"); 
		query.append(", 	A.DEST_TRNS_SVC_MOD_CD      DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(",   A.INV_SVC_SCP_CD			INV_SVC_SCP_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN A, INV_AR_ISS_DTL B,MDM_CUSTOMER C,MDM_CR_CUST D,INV_AR_ISS E" ).append("\n"); 
		query.append("WHERE	A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND A.AR_IF_NO = B.AR_IF_NO(+)" ).append("\n"); 
		query.append("AND B.INV_NO = E.INV_NO(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND E.INV_SEQ(+)=1" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}
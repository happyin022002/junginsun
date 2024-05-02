/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchOutstandingHdrByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchOutstandingHdrByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding Inquiry by B/L(Invoice) Header
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchOutstandingHdrByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchOutstandingHdrByBlRSQL").append("\n"); 
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
		query.append("SELECT             A.RHQ_CD" ).append("\n"); 
		query.append("                 , A.OTS_OFC_CD" ).append("\n"); 
		query.append("                 , A.BL_NO" ).append("\n"); 
		query.append("                 , A.INV_NO" ).append("\n"); 
		query.append("				 , A.INV_CURR_CD" ).append("\n"); 
		query.append("                 , A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("                 , LPAD(A.BIL_TO_CUST_SEQ,6, '0') AS BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("                 , A.BIL_TO_CUST_CNT_CD || LPAD(A.BIL_TO_CUST_SEQ,6, '0') AS CUST_NUM" ).append("\n"); 
		query.append("                 , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.BIL_TO_CUST_CNT_CD AND CUST_SEQ = A.BIL_TO_CUST_SEQ) AS CUST_NM" ).append("\n"); 
		query.append("                 , A.SHP_TO_CUST_CNT_CD           " ).append("\n"); 
		query.append("                 , LPAD(A.SHP_TO_CUST_SEQ,6, '0') AS SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("                 , A.SHP_TO_CUST_CNT_CD  || LPAD(A.SHP_TO_CUST_SEQ,6, '0') AS SHIP_CUST_NUM" ).append("\n"); 
		query.append("                 , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.SHP_TO_CUST_CNT_CD AND CUST_SEQ = A.SHP_TO_CUST_SEQ) AS SHIP_CUST_NM" ).append("\n"); 
		query.append("                 , A.BKG_NO " ).append("\n"); 
		query.append("				 , NVL(A.OTS_PAY_CD,'N') AS OTS_PAY_CD" ).append("\n"); 
		query.append("                 , B.CR_CURR_CD" ).append("\n"); 
		query.append("                 , B.CR_AMT" ).append("\n"); 
		query.append("                 , B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("                 , B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append("                 , A.OTS_RT_FLG" ).append("\n"); 
		query.append("				 , A.ORG_INV_NO" ).append("\n"); 
		query.append("                 , A.VSL_CD || A.SKD_VOY_NO || A.DIR_CD  VVD " ).append("\n"); 
		query.append("                 , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("                 , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("                 , A.SVC_SCP_CD" ).append("\n"); 
		query.append("                 , A.LANE_CD" ).append("\n"); 
		query.append("                 , A.BKG_IO_BND_CD" ).append("\n"); 
		query.append("                 , A.POR_CD" ).append("\n"); 
		query.append("                 , A.POL_CD" ).append("\n"); 
		query.append("                 , A.POD_CD" ).append("\n"); 
		query.append("                 , A.DEL_CD" ).append("\n"); 
		query.append("                 , A.DUE_DT" ).append("\n"); 
		query.append("                 , TRUNC(SYSDATE) - TO_DATE(A.DUE_DT,'YYYYMMDD') OVER_DUE" ).append("\n"); 
		query.append("                 , A.OTS_SRC_CD" ).append("\n"); 
		query.append("                 , A.BKG_REF_NO" ).append("\n"); 
		query.append("                 , A.INV_DT" ).append("\n"); 
		query.append("                 , A.CUST_SREP_CD" ).append("\n"); 
		query.append("                 , A.CLT_OFC_CD" ).append("\n"); 
		query.append("                 , A.OTS_TP_CD" ).append("\n"); 
		query.append("                 , (SELECT ATTR_CTNT1 FROM SCO_LU_DTL WHERE LU_TP_CD = 'OTS GROUP' AND LU_CD = A.OTS_GRP_TP_CD) AS OTS_GRP_TP_CD" ).append("\n"); 
		query.append("                 , A.OTS_RMK" ).append("\n"); 
		query.append("                 , A.SC_NO" ).append("\n"); 
		query.append("                 , A.UPD_USR_ID" ).append("\n"); 
		query.append("                 , A.CRE_USR_ID" ).append("\n"); 
		query.append("                 , @[cond_bl_no] AS COND_BL_NO" ).append("\n"); 
		query.append("                 , @[cond_bkg_no] AS COND_BKG_NO" ).append("\n"); 
		query.append("          FROM   SAR_OTS_HDR A" ).append("\n"); 
		query.append("               , MDM_CR_CUST B" ).append("\n"); 
		query.append("          WHERE A.BIL_TO_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("          AND A.BIL_TO_CUST_SEQ = B.CUST_SEQ (+)         " ).append("\n"); 
		query.append("          #if(${ots_cd} == 'COU')  " ).append("\n"); 
		query.append("              AND A.OTS_OFC_CD = @[rep_ots_ofc_cd]" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("              AND A.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if(${cond_bl_no} != '') " ).append("\n"); 
		query.append("              AND A.BL_NO = @[cond_bl_no]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if(${cond_bkg_no} != '')" ).append("\n"); 
		query.append("              AND A.BKG_NO = @[cond_bkg_no]         " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if(${inv_no} != '')" ).append("\n"); 
		query.append("              AND A.INV_NO = @[inv_no]         " ).append("\n"); 
		query.append("          #end" ).append("\n"); 

	}
}
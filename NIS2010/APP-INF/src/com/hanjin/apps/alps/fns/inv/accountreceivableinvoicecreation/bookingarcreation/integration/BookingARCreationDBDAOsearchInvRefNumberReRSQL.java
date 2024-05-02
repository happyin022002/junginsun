/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchInvRefNumberReRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchInvRefNumberReRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvRefNumberRe
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchInvRefNumberReRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchInvRefNumberReRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.IO_BND_CD, 'O', DECODE(A.OTS_SMRY_CD,'INV',DECODE(A.REV_CNT,0,A.INV_REF, NVL(A.FINV_CNT,NVL(A.ESRF_CNT,A.EBRF_CNT))),A.FINV_CNT), A.INV_REF) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    SELECT  BKG_NO" ).append("\n"); 
		query.append("            ,MAX(DECODE(BKG_REF_TP_CD,'FINV',SUBSTR(CUST_REF_NO_CTNT,1,50),'')) FINV_CNT" ).append("\n"); 
		query.append("            ,MAX(DECODE(BKG_REF_TP_CD,'ESRF',SUBSTR(CUST_REF_NO_CTNT,1,50),'')) ESRF_CNT" ).append("\n"); 
		query.append("            ,MAX(DECODE(BKG_REF_TP_CD,'EBRF',SUBSTR(CUST_REF_NO_CTNT,1,50),'')) EBRF_CNT" ).append("\n"); 
		query.append("            ,(SELECT COUNT(K1.AR_IF_NO) FROM INV_AR_MN K1, INV_AR_ISS_DTL K2 WHERE K1.AR_IF_NO=K2.AR_IF_NO AND K2.INV_NO = @[inv_no] AND K1.REV_TP_CD <> 'M') REV_CNT                      " ).append("\n"); 
		query.append("            ,(SELECT K1.INV_REF_NO FROM INV_AR_MN K1 WHERE K1.AR_IF_NO = (SELECT MAX(AR_IF_NO) FROM INV_AR_ISS_DTL K2 WHERE K2.INV_NO = @[inv_no])) INV_REF" ).append("\n"); 
		query.append("			,(SELECT OTS_SMRY_CD FROM INV_AR_STUP_OFC WHERE AR_OFC_CD = @[ar_ofc_cd]) OTS_SMRY_CD" ).append("\n"); 
		query.append("			,(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO IN (SELECT MAX(AR_IF_NO) FROM INV_AR_ISS_DTL WHERE INV_NO = @[inv_no] )) IO_BND_CD" ).append("\n"); 
		query.append("    FROM BKG_REFERENCE  " ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND BKG_REF_TP_CD IN ('FINV','ESRF','EBRF')" ).append("\n"); 
		query.append("    GROUP BY BKG_NO" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 

	}
}
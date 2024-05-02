/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroPayerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2010.01.14 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroPayerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroPayerRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroPayerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroPayerRSQL").append("\n"); 
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
		query.append("SELECT (select ofc_cd from com_user usr where usr.usr_id = TRO.CRE_USR_ID) CRE_OFC_CD" ).append("\n"); 
		query.append("        , CLT_OFC_CD " ).append("\n"); 
		query.append("        , CLT_PAYR_CNT_CD      PAYER_CNT_CD" ).append("\n"); 
		query.append("        , DECODE(CLT_PAYR_CUST_SEQ, 0, ' ', CLT_PAYR_CUST_SEQ) PAYER_SEQ" ).append("\n"); 
		query.append("        , CUST.CUST_LGL_ENG_NM PAYER_NM" ).append("\n"); 
		query.append("        , '' CCT_OFC_CD" ).append("\n"); 
		query.append("        , TRO.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("        , BKG_RATE RATE" ).append("\n"); 
		query.append("        , MDM_CUSTOMER CUST" ).append("\n"); 
		query.append(" WHERE TRO.BKG_NO             = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND RATE.CLT_PAYR_CNT_CD   = CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND RATE.CLT_PAYR_CUST_SEQ = CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND TRO.BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("--   AND CRE_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}
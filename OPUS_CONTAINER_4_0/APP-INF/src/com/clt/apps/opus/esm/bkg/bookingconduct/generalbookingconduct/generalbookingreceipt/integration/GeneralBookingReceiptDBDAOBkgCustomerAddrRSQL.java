/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOBkgCustomerAddrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOBkgCustomerAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Customer 정보
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOBkgCustomerAddrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOBkgCustomerAddrRSQL").append("\n"); 
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
		query.append("	UPPER(REPLACE(bzet_addr, '@*', CHR(10))) AS ADDR," ).append("\n"); 
		query.append("	(SELECT UPPER(CUST_LGL_ENG_NM) FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[cust_cnt_cd] AND CUST_SEQ = @[cust_seq]) AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("	(SELECT FRT_FWRD_FMC_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = @[cust_cnt_cd] AND CUST_SEQ = @[cust_seq]) AS FMC_NO" ).append("\n"); 
		query.append("FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ		= @[cust_seq]" ).append("\n"); 
		query.append("AND PRMRY_CHK_FLG 	= 'Y'" ).append("\n"); 
		query.append("AND ROWNUM  		= 1" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcancelCustCdValUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.01.04 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcancelCustCdValUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking번호 기준으로 Customer Code Validation 정보를 제거한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcancelCustCdValUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcancelCustCdValUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUSTOMER" ).append("\n"); 
		query.append("SET ORG_CUST_CNT_CD = CUST_CNT_CD  -- Outbound에서 입력한 정보 보존용 Column에 데이터 저장" ).append("\n"); 
		query.append(", ORG_CUST_SEQ    = CUST_SEQ" ).append("\n"); 
		query.append(", MTCH_FLG = 'N'                 -- Validation Codes" ).append("\n"); 
		query.append(", VAL_CD = NULL" ).append("\n"); 
		query.append(", VAL_USR_ID = NULL              -- Validate Additional Info" ).append("\n"); 
		query.append(", VAL_DT = NULL" ).append("\n"); 
		query.append(", AN_SND_FLG = 'N'" ).append("\n"); 
		query.append(", CHG_DP_FLG = 'N'" ).append("\n"); 
		query.append(", VAL_NM = BKG_IB_CUST_NM_VAL_FNC(CUST_CNT_CD, CUST_NM)" ).append("\n"); 
		query.append(", VAL_FAX_NO = BKG_IB_FAX_NO_VAL_FNC(CUST_FAX_NO)" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD IN ('C', 'N')" ).append("\n"); 

	}
}
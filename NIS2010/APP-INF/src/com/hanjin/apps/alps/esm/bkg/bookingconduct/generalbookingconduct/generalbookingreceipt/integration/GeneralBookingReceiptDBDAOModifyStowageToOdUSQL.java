/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyStowageToOdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyStowageToOdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 아래 조건에 해당될 경우 Stowage를 OD로 자동 지정
	  * 1.RFA No : SEL17A0140
	  * 2.Shipper Code : KR695 
	  * 
	  * * Hard Coding ID : STWG_OD 참고
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyStowageToOdUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyStowageToOdUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append(" STWG_CD = 'OD'" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RFA_NO IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                WHERE HRD_CDG_ID = 'STWG_OD'" ).append("\n"); 
		query.append("                AND ATTR_CTNT1 = 'RFA_NO')" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("             SELECT 1" ).append("\n"); 
		query.append("             FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND CUST_CNT_CD = 'KR'" ).append("\n"); 
		query.append("               AND CUST_SEQ = '165'" ).append("\n"); 
		query.append("			   )" ).append("\n"); 

	}
}
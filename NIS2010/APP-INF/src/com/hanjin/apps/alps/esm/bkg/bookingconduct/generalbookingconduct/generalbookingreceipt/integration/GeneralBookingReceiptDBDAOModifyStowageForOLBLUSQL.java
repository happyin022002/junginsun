/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyStowageForOLBLUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.04 
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

public class GeneralBookingReceiptDBDAOModifyStowageForOLBLUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 아래 조건에 해당될 경우 Stowage를 OLBL로 자동 지정
	  * 1.SC No : OLBL 에 해당되는 SC NO
	  * 2.Shipper Code : KR695 가 아님
	  * 3.모든 Container Type/Size가 D2이면 제외.
	  * 4.모든 Container에 DG Cargo가 하나라도 있으면 제외.
	  * 
	  * * Hard Coding ID : STWG_OLBL 참고
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyStowageForOLBLUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyStowageForOLBLUSQL").append("\n"); 
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
		query.append(" STWG_CD = 'OLBL'" ).append("\n"); 
		query.append(", BLCK_STWG_CD = 'LBL'" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SC_NO IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                WHERE HRD_CDG_ID = 'STWG_OLBL'" ).append("\n"); 
		query.append("                AND ATTR_CTNT1 = 'SC_NO')" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("             SELECT 1" ).append("\n"); 
		query.append("             FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND CUST_CNT_CD = 'KR'" ).append("\n"); 
		query.append("               AND CUST_SEQ = '695'" ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("AND (		SELECT COUNT(1)" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND CNTR_TPSZ_CD NOT IN ('D4','D5')) = 0" ).append("\n"); 
		query.append("AND (       SELECT COUNT(1)" ).append("\n"); 
		query.append("            FROM BKG_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("     ) = 0" ).append("\n"); 

	}
}
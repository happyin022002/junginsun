/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoToCanadaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.28 
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

public class GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoToCanadaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 아래 조건에 해당될 경우 Stowage를 OBSS로 자동 지정
	  * 1.SC No : AEF180101, AEF180202, AEF180303
	  * 2.POD이 CAVAN 인 경우
	  * 
	  * Trans Mode가 Rail/Truck 일때
	  * 
	  * * Hard Coding ID : STWG_OBSS 참고
	  * 
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoToCanadaUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoToCanadaUSQL").append("\n"); 
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
		query.append(" STWG_CD = 'OBSS'" ).append("\n"); 
		query.append(", BLCK_STWG_CD = CASE WHEN POD_CD = 'CAVAN' THEN 'VAX'" ).append("\n"); 
		query.append("                        ELSE BLCK_STWG_CD " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SC_NO IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("                AND ATTR_CTNT1 = 'SC_NO')" ).append("\n"); 
		query.append("AND (		SELECT COUNT(1)" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND CNTR_TPSZ_CD NOT IN ('D2','D4','D5')) = 0" ).append("\n"); 
		query.append("AND (       SELECT COUNT(1)" ).append("\n"); 
		query.append("            FROM BKG_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("     ) = 0" ).append("\n"); 
		query.append("AND AWK_CGO_FLG = 'N'" ).append("\n"); 
		query.append("AND BB_CGO_FLG  = 'N'" ).append("\n"); 
		query.append("AND POD_CD LIKE 'CA%'" ).append("\n"); 

	}
}
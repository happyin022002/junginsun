/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoUSQL.java
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

public class GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 아래 조건에 해당될 경우 Stowage를 OBSS로 자동 지정
	  * 1.SC No : AEN140201, AEN142674, AEF141659
	  * 2.POL이 KRPUS거나, (Pre or Post) Relay port가 KRPUS 인 경우
	  * 3.DEL : MXTIJ, USLGB, USLAX
	  * 
	  * * Hard Coding ID : STWG_OBSS 참고
	  * 
	  * 2015.07.14 [CHM-201536625] AWK, BB 는 제외
	  * 2017.04.17 iylee S/C No : AEF170260 는 LBP에서 제외
	  *                 DEL이 USRIQ 이고 Trans Mode 가 RAIL/Truck 이면 Block Stowage Code 를 LB1으로 지정.
	  * 2017.05.15 
	  * 			3.모든 Container Type/Size가 D4, D5인 경우만 해당.
	  * 			4.모든 Container에 DG Cargo가 하나라도 있으면 제외.
	  * 2017.05.25	1.모든 Container Type/Size가 D2, D4, D5인 경우만 해당.
	  * 		       2. POL, POD, DEL 등에 관계없이 적용가능 하도록 설정.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyStowageForSamsungMexicoUSQL").append("\n"); 
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
		query.append(", BLCK_STWG_CD = CASE WHEN POD_CD = 'USLGB' THEN 'LB7'" ).append("\n"); 
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
		query.append("--AND (" ).append("\n"); 
		query.append("--       POL_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("--                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("--                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("--                AND ATTR_CTNT1 = 'POL_CD')" ).append("\n"); 
		query.append("--    OR PRE_RLY_PORT_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("--                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("--                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("--                AND ATTR_CTNT1 = 'PRE_RLY_PORT_CD')" ).append("\n"); 
		query.append("--    OR PST_RLY_PORT_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("--                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("--                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("--                AND ATTR_CTNT1 = 'PST_RLY_PORT_CD')" ).append("\n"); 
		query.append("--    )" ).append("\n"); 
		query.append("--AND ( " ).append("\n"); 
		query.append("--       POD_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("--                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("--                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("--                AND ATTR_CTNT1 = 'POD_CD')" ).append("\n"); 
		query.append("--    OR DEL_CD IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("--                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("--                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("--                AND ATTR_CTNT1 = 'DEL_CD')" ).append("\n"); 
		query.append("--    OR SUBSTR(DEL_CD,1,2) IN (SELECT ATTR_CTNT2" ).append("\n"); 
		query.append("--                FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("--                WHERE HRD_CDG_ID = 'STWG_OBSS'" ).append("\n"); 
		query.append("--                AND ATTR_CTNT1 = 'DEL_CNT_CD')" ).append("\n"); 
		query.append("--)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (		SELECT COUNT(1)" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND CNTR_TPSZ_CD NOT IN ('D2','D4','D5')) = 0" ).append("\n"); 
		query.append("AND (       SELECT COUNT(1)" ).append("\n"); 
		query.append("            FROM BKG_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("     ) = 0" ).append("\n"); 
		query.append("   AND DEL_CD <> 'USRIQ'" ).append("\n"); 
		query.append("AND AWK_CGO_FLG = 'N'" ).append("\n"); 
		query.append("AND BB_CGO_FLG  = 'N'" ).append("\n"); 
		query.append("AND POD_CD LIKE 'US%'" ).append("\n"); 

	}
}
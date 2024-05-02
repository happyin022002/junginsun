/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyExportRefNmByRfaHolderNmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.12 
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

public class GeneralBookingReceiptDBDAOModifyExportRefNmByRfaHolderNmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Export Ref.란에 RFA Holder Name을 자동 Copy
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyExportRefNmByRfaHolderNmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_holder_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyExportRefNmByRfaHolderNmUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CUSTOMER EX" ).append("\n"); 
		query.append(" USING DUAL" ).append("\n"); 
		query.append("    ON (EX.BKG_NO = @[bkg_no] and EX.BKG_CUST_TP_CD = 'E')" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("        CUST_NM = DECODE(NVL(CUST_NM,''), '', @[rfa_holder_nm], CUST_NM || CHR(13)||CHR(10) || @[rfa_holder_nm])" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND BKG_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (BKG_NO, BKG_CUST_TP_CD, CUST_NM)" ).append("\n"); 
		query.append("    VALUES (@[bkg_no],'E', @[rfa_holder_nm])" ).append("\n"); 

	}
}
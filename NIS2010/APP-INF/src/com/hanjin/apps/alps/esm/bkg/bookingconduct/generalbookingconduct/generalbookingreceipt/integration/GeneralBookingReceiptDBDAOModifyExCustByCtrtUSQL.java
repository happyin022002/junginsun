/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyExCustByCtrtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyExCustByCtrtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약조건이 맞는경우 EDI Ref.가 존재하지 않을 때 특정 Customer code로 지정
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyExCustByCtrtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hrd_cdg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration ").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyExCustByCtrtUSQL").append("\n"); 
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
		query.append("MERGE INTO " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("            BKG_CUST_HIS CUS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            BKG_CUSTOMER CUS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT HRD.ATTR_CTNT4 CUST_CNT_CD" ).append("\n"); 
		query.append("             ,HRD.ATTR_CTNT5 CUST_SEQ" ).append("\n"); 
		query.append("             ,BKG.BKG_NO" ).append("\n"); 
		query.append("         FROM BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             ,BKG_BKG_HIS BKG" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      #if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("        AND BKG.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("        AND HRD.HRD_CDG_ID = @[hrd_cdg_id]" ).append("\n"); 
		query.append("        AND ((HRD.ATTR_CTNT1 = 'SC' AND BKG.SC_NO = HRD.ATTR_CTNT2)" ).append("\n"); 
		query.append("        OR (HRD.ATTR_CTNT1 = 'RFA' AND BKG.RFA_NO = HRD.ATTR_CTNT2))" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" ) CTRT" ).append("\n"); 
		query.append("  ON (CUS.BKG_NO =CTRT.BKG_NO" ).append("\n"); 
		query.append("  AND CUS.BKG_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  AND CUS.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN " ).append("\n"); 
		query.append("  UPDATE " ).append("\n"); 
		query.append("     SET CUS.CUST_CNT_CD = NVL(CUS.CUST_CNT_CD,CTRT.CUST_CNT_CD)" ).append("\n"); 
		query.append("        ,CUS.CUST_SEQ = NVL(CUS.CUST_SEQ,CTRT.CUST_SEQ)" ).append("\n"); 

	}
}
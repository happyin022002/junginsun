/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyExCustByActCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
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

public class GeneralBookingReceiptDBDAOModifyExCustByActCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer 와 S/C or RFA no. 를 조건으로 EDI Ref. 를 강제 지정한다.
	  * 
	  * 2015.05.06 : RFA no. 변경 TYO14A0649 -> TYO15A0357
	  * 2015.05.08 : SC no.  변경 AEF143333 -> AEF153333
	  * 2015.11.19 : RFA no. 변경 TYO15A0357-> TYO15A0654
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyExCustByActCustUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyExCustByActCustUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUST_HIS CUST" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET CUST_CNT_CD = 'JP'" ).append("\n"); 
		query.append("     , CUST_SEQ    = 11750" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT '1' " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                 FROM BKG_BKG_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                WHERE BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("                  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND AGMT_ACT_CNT_CD   = 'JP'" ).append("\n"); 
		query.append("                  AND AGMT_ACT_CUST_SEQ = 11750" ).append("\n"); 
		query.append("                  AND ( SC_NO  = 'AEF153333' " ).append("\n"); 
		query.append("                     OR RFA_NO = 'TYO15A0654' )" ).append("\n"); 
		query.append("             )" ).append("\n"); 

	}
}
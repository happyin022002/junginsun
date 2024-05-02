/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchNisRfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchNisRfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNisRf
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchNisRfRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchNisRfRSQL").append("\n"); 
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
		query.append("SELECT RF.BKG_NO" ).append("\n"); 
		query.append("        , RF.CNTR_NO" ).append("\n"); 
		query.append("        , RF.RC_SEQ" ).append("\n"); 
		query.append("        , RF.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , DECODE(RF.SPCL_CGO_APRO_CD, 'Y', 'Approved', 'N', 'Rejected', 'R', 'Requested', 'New') STATUS" ).append("\n"); 
		query.append("        , RF.CMDT_CD" ).append("\n"); 
		query.append("        , RF.CMDT_DESC" ).append("\n"); 
		query.append("        , RF.FDO_TEMP --화씨 온도" ).append("\n"); 
		query.append("        , RF.CDO_TEMP --섭씨 온도" ).append("\n"); 
		query.append("        , RF.PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append("        , decode(RF.CNTR_VENT_TP_CD,'P', RF.VENT_RTO,'C',RF.CBM_PER_HR_QTY) VENT_RTO" ).append("\n"); 
		query.append("        , RF.CLNG_TP_CD" ).append("\n"); 
		query.append("        , RF.HUMID_NO" ).append("\n"); 
		query.append("		, RC_SEQ.MAX_RC_SEQ" ).append("\n"); 
		query.append("        , RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("        , RF.DIFF_RMK" ).append("\n"); 
		query.append("  FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC(RF XPKBKG_RF_CGO) */ RC_SEQ AS MAX_RC_SEQ" ).append("\n"); 
		query.append("          FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("         WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) RC_SEQ" ).append("\n"); 
		query.append(" WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
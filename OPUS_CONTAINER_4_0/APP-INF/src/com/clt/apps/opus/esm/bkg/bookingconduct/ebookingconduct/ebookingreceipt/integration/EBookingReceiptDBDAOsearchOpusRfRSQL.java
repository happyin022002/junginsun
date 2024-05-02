/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusRfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.09.01 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchOpusRfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusRf
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusRfRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusRfRSQL").append("\n"); 
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
		query.append("       -- , RF.VENT_RTO" ).append("\n"); 
		query.append("		, CASE WHEN RF.CNTR_VENT_TP_CD = 'C' " ).append("\n"); 
		query.append("			 THEN RF.CBM_PER_HR_QTY " ).append("\n"); 
		query.append("			 ELSE RF.VENT_RTO " ).append("\n"); 
		query.append("		  END AS VENT_RTO" ).append("\n"); 
		query.append("        , RF.CLNG_TP_CD" ).append("\n"); 
		query.append("        , RF.HUMID_NO" ).append("\n"); 
		query.append("		, RC_SEQ.MAX_RC_SEQ" ).append("\n"); 
		query.append("		, RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("		, RF.DIFF_RMK" ).append("\n"); 
		query.append("  FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("      ,(SELECT /*+ INDEX_DESC(RF XPKBKG_RF_CGO) */ RC_SEQ AS MAX_RC_SEQ" ).append("\n"); 
		query.append("          FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("         WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) RC_SEQ" ).append("\n"); 
		query.append(" WHERE RF.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
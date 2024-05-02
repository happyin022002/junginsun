/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchAlpsBbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.14 
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

public class EBookingReceiptDBDAOsearchAlpsBbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ALPS BKG BB Cargo 정보 조회
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchAlpsBbRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchAlpsBbRSQL").append("\n"); 
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
		query.append("SELECT    BKG_NO" ).append("\n"); 
		query.append(", BB_CGO_SEQ" ).append("\n"); 
		query.append(", '' AS CNTR_NO" ).append("\n"); 
		query.append(", '' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", DECODE(SPCL_CGO_APRO_CD, 'Y', 'Approved', 'N', 'Rejected', 'R', 'Requested', 'New') STATUS" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", ( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BB.CMDT_CD AND ROWNUM = 1 ) CMDT_NM" ).append("\n"); 
		query.append(", DIM_LEN" ).append("\n"); 
		query.append(", DIM_WDT" ).append("\n"); 
		query.append(", DIM_HGT" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", NET_WGT" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", MAX_BB_CGO_SEQ" ).append("\n"); 
		query.append(", CGO_DCHG_SD_CD" ).append("\n"); 
		query.append("FROM BKG_BB_CGO BB" ).append("\n"); 
		query.append(",(SELECT /*+ INDEX_DESC(BB XPKBKG_BB_CGO) */ BB_CGO_SEQ AS MAX_BB_CGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_BB_CGO BB" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") BB_SEQ" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
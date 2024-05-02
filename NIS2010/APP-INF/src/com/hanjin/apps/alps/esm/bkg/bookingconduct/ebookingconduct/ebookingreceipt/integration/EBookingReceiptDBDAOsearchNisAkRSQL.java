/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchNisAkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.01 
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

public class EBookingReceiptDBDAOsearchNisAkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNisAk
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchNisAkRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchNisAkRSQL").append("\n"); 
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
		query.append(", AWK_CGO_SEQ" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", DECODE(SPCL_CGO_APRO_CD, 'Y', 'Approved', 'N', 'Rejected', 'R', 'Requested', 'New') STATUS" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", ( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = AK.CMDT_CD AND ROWNUM = 1 ) CMDT_NM" ).append("\n"); 
		query.append(", TTL_DIM_LEN" ).append("\n"); 
		query.append(", TTL_DIM_WDT" ).append("\n"); 
		query.append(", TTL_DIM_HGT" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", NET_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD WGT_UT_CD2" ).append("\n"); 
		query.append(", STWG_RQST_DESC" ).append("\n"); 
		query.append(", MAX_AWK_CGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO AK" ).append("\n"); 
		query.append(",(SELECT /*+ INDEX_DESC(AK XPKBKG_AWK_CGO) */ AWK_CGO_SEQ AS MAX_AWK_CGO_SEQ" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO AK" ).append("\n"); 
		query.append("WHERE AK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") AK_SEQ" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
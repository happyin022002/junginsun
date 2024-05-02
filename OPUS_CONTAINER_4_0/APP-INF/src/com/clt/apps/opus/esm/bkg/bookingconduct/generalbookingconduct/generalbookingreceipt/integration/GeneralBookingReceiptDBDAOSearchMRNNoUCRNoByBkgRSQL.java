/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchMRNNoUCRNoByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchMRNNoUCRNoByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search MRN No, UCR No
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchMRNNoUCRNoByBkgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchMRNNoUCRNoByBkgRSQL").append("\n"); 
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
		query.append("SELECT REF_SEQ" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , REF_NO" ).append("\n"); 
		query.append("    , CNTR_NO" ).append("\n"); 
		query.append("    , BKG_REF_TP_CD" ).append("\n"); 
		query.append("    , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("    , (SELECT COUNT(*) FROM BKG_CNTR_HIS WHERE BKG_NO=A.BKG_NO AND CNTR_NO=A.CNTR_NO AND CORR_NO=A.CORR_NO) AS CNTR_FLG" ).append("\n"); 
		query.append("	, BKG_REF_TP_CD AS OLD_BKG_REF_TP_CD" ).append("\n"); 
		query.append("    , CUST_REF_NO_CTNT AS OLD_CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM  BKG_REF_HIS A" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BKG_REF_TP_CD IN ('CMRN','CUCR')" ).append("\n"); 
		query.append("AND NOT (CUST_REF_NO_CTNT IS NULL AND REF_NO IS NULL)" ).append("\n"); 
		query.append("ORDER BY REF_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT REF_SEQ" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , REF_NO" ).append("\n"); 
		query.append("    , CNTR_NO" ).append("\n"); 
		query.append("    , BKG_REF_TP_CD" ).append("\n"); 
		query.append("    , CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("    , (SELECT COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO=A.BKG_NO AND CNTR_NO=A.CNTR_NO) AS CNTR_FLG" ).append("\n"); 
		query.append("	, BKG_REF_TP_CD AS OLD_BKG_REF_TP_CD" ).append("\n"); 
		query.append("    , CUST_REF_NO_CTNT AS OLD_CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM  BKG_REFERENCE A" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_REF_TP_CD IN ('CMRN','CUCR')" ).append("\n"); 
		query.append("AND NOT (CUST_REF_NO_CTNT IS NULL AND REF_NO IS NULL)" ).append("\n"); 
		query.append("ORDER BY REF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
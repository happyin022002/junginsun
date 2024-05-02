/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchRFAHolderNameByShprCneeFFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.18 
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

public class GeneralBookingReceiptDBDAOsearchRFAHolderNameByShprCneeFFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Holder Name이 shpr / cnee / freight forwarder 셋 중 어딘가에 있는지 체크.
	  * (RFA Holder Name이 2/3 일치하면 있다고 봄.(그 중간에 엔터, 스페이스가 들어가 있으면 Space로 바꿔서 체크)
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchRFAHolderNameByShprCneeFFRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOsearchRFAHolderNameByShprCneeFFRSQL").append("\n"); 
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
		query.append("WITH RFA_HOLDER AS (" ).append("\n"); 
		query.append("            SELECT (SELECT MDM.CUST_LGL_ENG_NM FROM MDM_CUSTOMER MDM WHERE MDM.CUST_CNT_CD = RM.CTRT_CUST_CNT_CD AND MDM.CUST_SEQ = RM.CTRT_CUST_SEQ ) AS RFA_HOLDER_NAME" ).append("\n"); 
		query.append("            from PRI_RP_MN RM, PRI_RP_HDR RH, BKG_BOOKING BKG" ).append("\n"); 
		query.append("            WHERE RM.PROP_NO = RH.PROP_NO" ).append("\n"); 
		query.append("            AND RM.PROP_STS_CD  = 'A'" ).append("\n"); 
		query.append("            AND  RH.RFA_NO = BKG.RFA_NO " ).append("\n"); 
		query.append("            AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT RFA_HOLDER_NAME, EXISTS_RFA, DISPLAY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT RFA_HOLDER_NAME, EXISTS_RFA, DISPLAY" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("	(SELECT SH.CUST_NM RFA_HOLDER_NAME, 'Y' EXISTS_RFA, '1' DISPLAY" ).append("\n"); 
		query.append("	  FROM BKG_CUSTOMER SH," ).append("\n"); 
		query.append("	       RFA_HOLDER" ).append("\n"); 
		query.append("	 WHERE SH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	  AND SH.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("	  AND REPLACE(REPLACE(SH.CUST_NM,CHR(13)||CHR(10),' '),' ','') LIKE '%' || SUBSTR(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''),1,LENGTH(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''))*(2/3)) || '%'" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT CN.CUST_NM RFA_HOLDER_NAME,  'Y' EXISTS_RFA, '2' DISPLAY" ).append("\n"); 
		query.append("	  FROM BKG_CUSTOMER CN," ).append("\n"); 
		query.append("	       RFA_HOLDER" ).append("\n"); 
		query.append("	 WHERE CN.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	  AND CN.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("	  AND REPLACE(REPLACE(CN.CUST_NM,CHR(13)||CHR(10),' '),' ','') LIKE '%' || SUBSTR(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''),1,LENGTH(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''))*(2/3)) || '%'" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	SELECT FF.CUST_NM RFA_HOLDER_NAME,  'Y' EXISTS_RFA, '3' DISPLAY" ).append("\n"); 
		query.append("	  FROM BKG_CUSTOMER FF," ).append("\n"); 
		query.append("	       RFA_HOLDER" ).append("\n"); 
		query.append("	 WHERE FF.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	  AND FF.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("	  AND REPLACE(REPLACE(FF.CUST_NM,CHR(13)||CHR(10),' '),' ','') LIKE '%' || SUBSTR(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''),1,LENGTH(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''))*(2/3)) || '%'" ).append("\n"); 
		query.append("	UNION " ).append("\n"); 
		query.append("#if (${rate_flg}== 'Y')" ).append("\n"); 
		query.append("	SELECT EX.CUST_NM RFA_HOLDER_NAME,  'Y' EXISTS_RFA, '4' DISPLAY" ).append("\n"); 
		query.append("	  FROM BKG_CUSTOMER EX," ).append("\n"); 
		query.append("	       RFA_HOLDER" ).append("\n"); 
		query.append("	 WHERE EX.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	  AND EX.BKG_CUST_TP_CD(+) = 'E'" ).append("\n"); 
		query.append("	  AND REPLACE(REPLACE(EX.CUST_NM,CHR(13)||CHR(10),' '),' ','') LIKE '%' || SUBSTR(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''),1,LENGTH(REPLACE(REPLACE(RFA_HOLDER.RFA_HOLDER_NAME,CHR(13)||CHR(10),' '),' ',''))*(2/3)) || '%'" ).append("\n"); 
		query.append("    UNION  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	SELECT RFA_HOLDER.RFA_HOLDER_NAME,  'N' EXISTS_RFA, '5' DISPLAY" ).append("\n"); 
		query.append("	  FROM RFA_HOLDER" ).append("\n"); 
		query.append("	) T" ).append("\n"); 
		query.append("ORDER BY DISPLAY )" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}
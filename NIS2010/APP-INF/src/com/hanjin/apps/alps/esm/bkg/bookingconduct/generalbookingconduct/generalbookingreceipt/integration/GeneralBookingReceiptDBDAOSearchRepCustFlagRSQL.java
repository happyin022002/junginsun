/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchRepCustFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.28 
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

public class GeneralBookingReceiptDBDAOSearchRepCustFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepCustFlag
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchRepCustFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nf_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nf_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cn_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchRepCustFlagRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN CO_BIZ_FLG = 'N' AND REP_CUST_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END AS MIN_FLAG" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(RT_BL_TP_CD, 'B', 'Y', 'N') AS CO_BIZ_FLG" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("          FROM BKG_RT_HIS" ).append("\n"); 
		query.append("         WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_RATE" ).append("\n"); 
		query.append("         WHERE @[bkg_no] = BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) COBIZ" ).append("\n"); 
		query.append("      ,(SELECT MAX(REP_CUST_FLG) AS REP_CUST_FLG " ).append("\n"); 
		query.append("          FROM (SELECT DECODE(COUNT(1), 0, 'N', 'Y') AS REP_CUST_FLG" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE @[cn_cust_cnt_cd] = REP_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND @[cn_cust_seq] = REP_CUST_SEQ" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT DECODE(COUNT(1), 0, 'N', 'Y')" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                 WHERE @[nf_cust_cnt_cd] = REP_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND @[nf_cust_seq] = REP_CUST_SEQ" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) REP" ).append("\n"); 

	}
}
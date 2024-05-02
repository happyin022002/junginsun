/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchCustomerInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.BKG_CUST_TP_CD, 'S', 'CZ', 'C', 'CN', 'N', 'PK') CUSTOMER_TYPE ," ).append("\n"); 
		query.append("       C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ, '000000') CUSTOMER_CD ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 1, 35), 'Y') CUSTOMER_NM1 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 36, 35), 'Y') CUSTOMER_NM2 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, 35), 'Y') CUSTOMER_ADDR1 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 36, 35), 'Y') CUSTOMER_ADDR2 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 71, 35), 'Y') CUSTOMER_ADDR3 ," ).append("\n"); 
		query.append("       (SELECT U.USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_NM ," ).append("\n"); 
		query.append("       (SELECT U.XTN_PHN_NO" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_TEL ," ).append("\n"); 
		query.append("       (SELECT U.FAX_NO" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_FAX ," ).append("\n"); 
		query.append("       (SELECT U.USR_EML" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_EMAIL" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(C.BKG_CUST_TP_CD, 'S', 'CZ', 'C', 'CN', 'N', 'PK') CUSTOMER_TYPE ," ).append("\n"); 
		query.append("       C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ, '000000') CUSTOMER_CD ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 1, 35), 'Y') CUSTOMER_NM1 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 36, 35), 'Y') CUSTOMER_NM2 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, 35), 'Y') CUSTOMER_ADDR1 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 36, 35), 'Y') CUSTOMER_ADDR2 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 71, 35), 'Y') CUSTOMER_ADDR3 ," ).append("\n"); 
		query.append("       (SELECT U.USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_NM ," ).append("\n"); 
		query.append("       (SELECT U.XTN_PHN_NO" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_TEL ," ).append("\n"); 
		query.append("       (SELECT U.FAX_NO" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_FAX ," ).append("\n"); 
		query.append("       (SELECT U.USR_EML" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_EMAIL" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(C.BKG_CUST_TP_CD, 'S', 'CZ', 'C', 'CN', 'N', 'PK') CUSTOMER_TYPE ," ).append("\n"); 
		query.append("       C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ, '000000') CUSTOMER_CD ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 1, 35), 'Y') CUSTOMER_NM1 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 36, 35), 'Y') CUSTOMER_NM2 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, 35), 'Y') CUSTOMER_ADDR1 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 36, 35), 'Y') CUSTOMER_ADDR2 ," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 71, 35), 'Y') CUSTOMER_ADDR3 ," ).append("\n"); 
		query.append("       (SELECT U.USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_NM ," ).append("\n"); 
		query.append("       (SELECT U.XTN_PHN_NO" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_TEL ," ).append("\n"); 
		query.append("       (SELECT U.FAX_NO" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_FAX ," ).append("\n"); 
		query.append("       (SELECT U.USR_EML" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE USR_ID = @[usr_id] ) CONTACT_EMAIL" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD ='N'" ).append("\n"); 

	}
}
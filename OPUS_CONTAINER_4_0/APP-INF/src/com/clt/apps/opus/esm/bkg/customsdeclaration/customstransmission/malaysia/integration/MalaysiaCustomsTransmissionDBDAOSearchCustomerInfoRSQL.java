/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.21
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.21 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchCustomerInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchCustomerInfoRSQL").append("\n"); 
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
		query.append("SELECT    DECODE(C.BKG_CUST_TP_CD,'S','SH','C','CN','F','FW','N','N1','A','N2') CUSTOMER_TYPE" ).append("\n"); 
		query.append("         ,C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ,'000000') CUSTOMER_CD" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 1, 35),'Y') CUSTOMER_NM1" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_NM, 36, 35),'Y') CUSTOMER_NM2" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, 35),'Y')	CUSTOMER_ADDR1" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 36, 35),'Y')	CUSTOMER_ADDR2" ).append("\n"); 
		query.append("         ,BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 71, 35),'Y')	CUSTOMER_ADDR3" ).append("\n"); 
		query.append("         ,( SELECT U.USR_NM     FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_NM " ).append("\n"); 
		query.append("         ,( SELECT U.XTN_PHN_NO FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_TEL " ).append("\n"); 
		query.append("         ,( SELECT U.FAX_NO     FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_FAX " ).append("\n"); 
		query.append("         ,( SELECT U.USR_EML    FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_EMAIL " ).append("\n"); 
		query.append("FROM      BKG_CUSTOMER C" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       C.BKG_CUST_TP_CD IN ('C','F','N','S','A')" ).append("\n"); 
		query.append("AND       C.CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("--AND       C.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY  BKG_CUST_TP_CD DESC" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchBlCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchBlCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCust
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchBlCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchBlCustRSQL").append("\n"); 
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
		query.append("SELECT --16 Shipper Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS SHPR_CD," ).append("\n"); 
		query.append("       --17 Shipper Name1 (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_NM, 1, ''), ' '), 1, 35), 35, ' ') AS SHPR_NM1," ).append("\n"); 
		query.append("       --18 Shipper Name2 (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_NM, 2, ''), ' '), 1, 35), 35, ' ') AS SHPR_NM2," ).append("\n"); 
		query.append("       --19 Shipper Address 1/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_ADDR, 1, ''), ' '), 1, 35), 35, ' ') AS SHPR_ADDR1," ).append("\n"); 
		query.append("       --20 Shipper Address 2/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_ADDR, 2, ''), ' '), 1, 35), 35, ' ') AS SHPR_ADDR2," ).append("\n"); 
		query.append("       --21 Shipper Address 3/4 (City name)  (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_ADDR, 3, ''), ' '), 1, 35), 35, ' ') AS SHPR_ADDR3," ).append("\n"); 
		query.append("       --22 Shipper Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_ADDR4," ).append("\n"); 
		query.append("       --23 Shipper ZIP ID" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS SHPR_POST_ID," ).append("\n"); 
		query.append("       --24 Shipper Country Code" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(SHPR.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS SHPR_CNT_CD," ).append("\n"); 
		query.append("       --25 Shipper Phone No" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(SHPR.PHN_NO, ' '), 1, 14), 14, ' ') AS SHPR_PHN_NO," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --26 Consignee Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS CNEE_CD," ).append("\n"); 
		query.append("       --27 Consignee Name1 (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_NM, 1, ''), ' '), 1, 35), 35, ' ') AS CNEE_NM1," ).append("\n"); 
		query.append("       --28 Consignee Name2 (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_NM, 2, ''), ' '), 1, 35), 35, ' ') AS CNEE_NM2," ).append("\n"); 
		query.append("       --29 Consignee Address 1/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_ADDR, 1, ''), ' '), 1, 35), 35, ' ') AS CNEE_ADDR1," ).append("\n"); 
		query.append("       --30 Consignee Address 2/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_ADDR, 2, ''), ' '), 1, 35), 35, ' ') AS CNEE_ADDR2," ).append("\n"); 
		query.append("       --31 Consignee Address 3/4 (City name)  (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_ADDR, 3, ''), ' '), 1, 35), 35, ' ') AS CNEE_ADDR3," ).append("\n"); 
		query.append("       --32 Consignee Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_ADDR4," ).append("\n"); 
		query.append("       --33 Consignee ZIP ID" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS CNEE_POST_ID," ).append("\n"); 
		query.append("       --34 Consignee Country Code" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(CNEE.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS CNEE_CNT_CD," ).append("\n"); 
		query.append("       --35 Consignee Phone No" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(CNEE.PHN_NO, ' '), 1, 14), 14, ' ') AS CNEE_PHN_NO," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --36 Notify Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS NTFY1_CD," ).append("\n"); 
		query.append("       --37 Notify Name1 (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_NM, 1, ''), 'SAME AS CONSIGNEE'), 1, 35), 35, ' ') AS NTFY1_NM1," ).append("\n"); 
		query.append("       --38 Notify Name2 (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_NM, 2, ''), ' '), 1, 35), 35, ' ') AS NTFY1_NM2," ).append("\n"); 
		query.append("       --39 Notify Address 1/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_ADDR, 1, ''), ' '), 1, 35), 35, ' ') AS NTFY1_ADDR1," ).append("\n"); 
		query.append("       --40 Notify Address 2/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_ADDR, 2, ''), ' '), 1, 35), 35, ' ') AS NTFY1_ADDR2," ).append("\n"); 
		query.append("       --41 Notify Address 3/4 (City name)  (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_ADDR, 3, ''), ' '), 1, 35), 35, ' ') AS NTFY1_ADDR3," ).append("\n"); 
		query.append("       --42 Notify Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_ADDR4," ).append("\n"); 
		query.append("       --43 Notify ZIP ID" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS NTFY1_POST_ID," ).append("\n"); 
		query.append("       --44 Notify Country Code" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(NTFY.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS NTFY1_CNT_CD," ).append("\n"); 
		query.append("       --45 Notify Phone No" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(NTFY.PHN_NO, ' '), 1, 14), 14, ' ') AS NTFY1_PHN_NO," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --46 Notify Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_CD," ).append("\n"); 
		query.append("       --47 Notify Name1 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_NM1," ).append("\n"); 
		query.append("       --48 Notify Name2 (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_NM2," ).append("\n"); 
		query.append("       --49 Notify Address 1/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR1," ).append("\n"); 
		query.append("       --40 Notify Address 2/4 (Street and number/P.O.Box) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR2," ).append("\n"); 
		query.append("       --51 Notify Address 3/4 (City name)  (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR3," ).append("\n"); 
		query.append("       --52 Notify Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR4," ).append("\n"); 
		query.append("       --53 Notify ZIP ID" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS NTFY2_POST_ID," ).append("\n"); 
		query.append("       --54 Notify Country Code" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS NTFY2_CNT_CD," ).append("\n"); 
		query.append("       --55 Notify Phone No" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS NTFY2_PHN_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_BL_CUST SHPR," ).append("\n"); 
		query.append("       BKG_CSTMS_JP_BL_CUST CNEE," ).append("\n"); 
		query.append("       BKG_CSTMS_JP_BL_CUST NTFY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE SHPR.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND SHPR.BL_SPLIT_NO = nvl(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND SHPR.BL_NO = CNEE.BL_NO" ).append("\n"); 
		query.append("   AND SHPR.BL_SPLIT_NO = CNEE.BL_SPLIT_NO" ).append("\n"); 
		query.append("   AND CNEE.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND SHPR.BL_NO = NTFY.BL_NO" ).append("\n"); 
		query.append("   AND SHPR.BL_SPLIT_NO = NTFY.BL_SPLIT_NO" ).append("\n"); 
		query.append("   AND NTFY.BKG_CUST_TP_CD = 'N'" ).append("\n"); 

	}
}
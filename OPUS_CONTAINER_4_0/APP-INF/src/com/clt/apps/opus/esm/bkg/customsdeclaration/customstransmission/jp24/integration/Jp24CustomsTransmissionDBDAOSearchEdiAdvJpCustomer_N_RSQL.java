/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomer_N_RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomer_N_RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomer_N_RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchEdiAdvJpCustomer_N_RSQL").append("\n"); 
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
		query.append("SELECT --34.Shipper Code (17)" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA00," ).append("\n"); 
		query.append("       --35.Shipper Name (70)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_NM, 1, ''), ' '), 1, 70), 70, ' ') AS DATA01," ).append("\n"); 
		query.append("       --36.Shipper Address (block entry) (175)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(SHPR.CUST_ADDR, ' '), 1, 175), 175, ' ') AS DATA02," ).append("\n"); 
		query.append("       --37.Shipper Address 1/4 (Street and number/P.O. Box) (70)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_ADDR, 1, ''), ' '), 1, 70), 70, ' ') AS DATA03," ).append("\n"); 
		query.append("       --38.Shipper Address 2/4 (Street and number/P.O. Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_ADDR, 2, ''), ' '), 1, 35), 35, ' ') AS DATA04," ).append("\n"); 
		query.append("       --39.Shipper Address 3/4 (City name) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(SHPR.CUST_ADDR, 3, ''), ' '), 1, 35), 35, ' ') AS DATA05," ).append("\n"); 
		query.append("       --40.Shipper Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA06," ).append("\n"); 
		query.append("       --41.Shipper Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(SHPR.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA07," ).append("\n"); 
		query.append("       --42.Shipper Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(SHPR.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA08," ).append("\n"); 
		query.append("       --43.Shipper Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(SHPR.PHN_NO, ' '), 1, 14), 14, ' ') AS DATA09," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --44.Consignee Code (17)" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA10," ).append("\n"); 
		query.append("       --45.Consignee Name Consignee Name1 (70)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_NM, 1, ''), ' '), 1, 70), 70, ' ') AS DATA11," ).append("\n"); 
		query.append("       --46.Consignee Address (block entry) (175)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(CNEE.CUST_ADDR, ' '), 1, 175), 175, ' ') AS DATA12," ).append("\n"); 
		query.append("       --47.Consignee Address 1/4 (Street and number/P.O. Box) (70)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_ADDR, 1, ''), ' '), 1, 70), 70, ' ') AS DATA13," ).append("\n"); 
		query.append("       --48.Consignee Address 2/4 (Street and number/P.O. Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_ADDR, 2, ''), ' '), 1, 35), 35, ' ') AS DATA14," ).append("\n"); 
		query.append("       --49.Consignee Address 3/4 (City name) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(CNEE.CUST_ADDR, 3, ''), ' '), 1, 35), 35, ' ') AS DATA15," ).append("\n"); 
		query.append("       --50.Consignee Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA16," ).append("\n"); 
		query.append("       --51.Consignee Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(CNEE.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA17," ).append("\n"); 
		query.append("       --52.Consignee Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(CNEE.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA18," ).append("\n"); 
		query.append("       --53.Consignee Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(CNEE.PHN_NO, ' '), 1, 14), 14, ' ') AS DATA19," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --54.Notify Code (17) x2" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA20," ).append("\n"); 
		query.append("       --55.Notify Party Name Notify Party Name1 (70)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_NM, 1, ''), ' '), 1, 70), 70, ' ') AS DATA21," ).append("\n"); 
		query.append("       --56.Notify Party Address (block entry) (175)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(NTFY.CUST_ADDR, ' '), 1, 175), 175, ' ') AS DATA22," ).append("\n"); 
		query.append("       --57.Notify Party Address 1/4 (Street and number/P.O. Box) (70)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_ADDR, 1, ''), ' '), 1, 70), 70, ' ') AS DATA23," ).append("\n"); 
		query.append("       --58.Notify Party Address 2/4 (Street and number/P.O. Box) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_ADDR, 2, ''), ' '), 1, 35), 35, ' ') AS DATA24," ).append("\n"); 
		query.append("       --59.Notify Party Address 3/4 (City name) (35)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(BKG_TOKEN_NL_FNC(NTFY.CUST_ADDR, 3, ''), ' '), 1, 35), 35, ' ') AS DATA25," ).append("\n"); 
		query.append("       --60.Notify Party Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA26," ).append("\n"); 
		query.append("       --61.Notify Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(NTFY.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA27," ).append("\n"); 
		query.append("       --62.Notify Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(NTFY.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA28," ).append("\n"); 
		query.append("       --63.Notify Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(NTFY.PHN_NO, ' '), 1, 14), 14, ' ') AS DATA29," ).append("\n"); 
		query.append("       ---------------------------------------------------------" ).append("\n"); 
		query.append("       --54.Notify Code (17)" ).append("\n"); 
		query.append("       RPAD(' ', 17, ' ') AS DATA30," ).append("\n"); 
		query.append("       --55.Notify Party Name Notify Party Name1 (70)" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA31," ).append("\n"); 
		query.append("       --56.Notify Party Address (block entry) (175)" ).append("\n"); 
		query.append("       RPAD(' ', 175, ' ') AS DATA32," ).append("\n"); 
		query.append("       --57.Notify Party Address 1/4 (Street and number/P.O. Box) (70)" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA33," ).append("\n"); 
		query.append("       --58.Notify Party Address 2/4 (Street and number/P.O. Box) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA34," ).append("\n"); 
		query.append("       --59.Notify Party Address 3/4 (City name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA35," ).append("\n"); 
		query.append("       --60.Notify Party Address 4/4 (Country sub-entity, name) (35)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA36," ).append("\n"); 
		query.append("       --61.Notify Postal Code (Postcode identification) (9)" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS DATA37," ).append("\n"); 
		query.append("       --62.Notify Country Code (Country, coded) (2)" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("       --63.Notify Telephone Number (14)" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS DATA39" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM BKG_CSTMS_ADV_JP_CUST SHPR," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_JP_CUST CNEE," ).append("\n"); 
		query.append("      BKG_CSTMS_ADV_JP_CUST NTFY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND SHPR.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND SHPR.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("  AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("  AND SHPR.BL_NO = CNEE.BL_NO" ).append("\n"); 
		query.append("  AND SHPR.BL_SPLIT_NO = CNEE.BL_SPLIT_NO" ).append("\n"); 
		query.append("  AND CNEE.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("  AND SHPR.BL_NO = NTFY.BL_NO" ).append("\n"); 
		query.append("  AND SHPR.BL_SPLIT_NO = NTFY.BL_SPLIT_NO" ).append("\n"); 
		query.append("  AND NTFY.BKG_CUST_TP_CD = 'N'" ).append("\n"); 

	}
}
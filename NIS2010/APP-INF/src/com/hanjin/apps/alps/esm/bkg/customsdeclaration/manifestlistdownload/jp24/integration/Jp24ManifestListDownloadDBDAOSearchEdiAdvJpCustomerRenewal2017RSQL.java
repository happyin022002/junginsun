/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRenewal2017RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRenewal2017RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRenewal2017RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRenewal2017RSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    DATA00, DATA01, DATA02, DATA03, DATA04, DATA05" ).append("\n"); 
		query.append("  , DATA06, DATA07, DATA08, DATA09, DATA10" ).append("\n"); 
		query.append("  , CASE WHEN TO_ORDER_FLAG > 0 THEN RPAD('TO ORDER',70, ' ')" ).append("\n"); 
		query.append("         ELSE RPAD(DATA11,70, ' ')" ).append("\n"); 
		query.append("    END AS DATA11    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  , CASE WHEN TO_ORDER_FLAG > 0 THEN RPAD('TO ORDER',175, ' ') /* NAME이 TO ORDER 이면 주소도 TO ORDER */" ).append("\n"); 
		query.append("         ELSE RPAD(DATA12,175, ' ')" ).append("\n"); 
		query.append("    END AS DATA12" ).append("\n"); 
		query.append("  , DATA13, DATA14, DATA15" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , DATA16, DATA17    " ).append("\n"); 
		query.append("  , CASE WHEN TO_ORDER_FLAG > 0 THEN DATA28                    /* NAME이 TO ORDER 이면 Notify Country Code */" ).append("\n"); 
		query.append("         ELSE DATA18" ).append("\n"); 
		query.append("    END AS DATA18" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  , CASE WHEN TO_ORDER_FLAG > 0 THEN RPAD('TO ORDER',14, ' ') /* NAME이 TO ORDER 이면 전화번호도 TO ORDER */" ).append("\n"); 
		query.append("         ELSE RPAD(REGEXP_REPLACE(DATA19,'[^0-9]',''),14, ' ')" ).append("\n"); 
		query.append("    END AS DATA19" ).append("\n"); 
		query.append("  , DATA20" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , DATA21, DATA22, DATA23, DATA24, DATA25" ).append("\n"); 
		query.append("  , DATA26, DATA27, DATA28, DATA29, DATA30" ).append("\n"); 
		query.append("  , DATA31, DATA32, DATA33, DATA34, DATA35" ).append("\n"); 
		query.append("  , DATA36, DATA37, DATA38, DATA39" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT --34 Shipper Code  (17)" ).append("\n"); 
		query.append("               RPAD(' ', 17, ' ') AS DATA00," ).append("\n"); 
		query.append("               --35 Shipper Name" ).append("\n"); 
		query.append("               RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_NM, ' '), 'J'), 1, 70), 70, ' ') AS DATA01," ).append("\n"); 
		query.append("               --36 Shipper ADDR" ).append("\n"); 
		query.append("               RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_ADDR, ' '), 'J'), 1, 175), 175, ' ') AS DATA02," ).append("\n"); 
		query.append("               --37 Shipper 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("               RPAD(' ', 70, ' ') AS DATA03," ).append("\n"); 
		query.append("               --38 Shipper 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA04," ).append("\n"); 
		query.append("               --39 Shipper 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA05," ).append("\n"); 
		query.append("               --40 Shipper 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA06," ).append("\n"); 
		query.append("               --41 Shipper ZIP" ).append("\n"); 
		query.append("               RPAD(SUBSTR(NVL(A.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA07," ).append("\n"); 
		query.append("               --42 Shipper Country" ).append("\n"); 
		query.append("               RPAD(SUBSTR(NVL(A.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA08," ).append("\n"); 
		query.append("               --43 Shipper Phone No" ).append("\n"); 
		query.append("               RPAD(SUBSTR(REGEXP_REPLACE(A.PHN_NO,'[^0-9]',''), " ).append("\n"); 
		query.append("                           1, 14), " ).append("\n"); 
		query.append("                     14, ' ') AS DATA09," ).append("\n"); 
		query.append("               ----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("               --44 Consignee Code  (17)" ).append("\n"); 
		query.append("               RPAD(' ', 17, ' ') AS DATA10," ).append("\n"); 
		query.append("               --45 Consignee Name" ).append("\n"); 
		query.append("               RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_NM, ' '), 'J'), 1, 70), 70, ' ') AS DATA11," ).append("\n"); 
		query.append("               --TO_ORDER_FLAG" ).append("\n"); 
		query.append("               INSTR(REPLACE(B.CUST_NM,' ',''),'TOORDER') AS TO_ORDER_FLAG," ).append("\n"); 
		query.append("               --46 Consignee ADDR" ).append("\n"); 
		query.append("               RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_ADDR, ' '), 'J'), 1, 175), 175, ' ') AS DATA12," ).append("\n"); 
		query.append("               --47 Consignee 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("               RPAD(' ', 70, ' ') AS DATA13," ).append("\n"); 
		query.append("               --48 Consignee 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA14," ).append("\n"); 
		query.append("               --44 Consignee 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA15," ).append("\n"); 
		query.append("               --50 Consignee 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA16," ).append("\n"); 
		query.append("               --51 Consignee ZIP" ).append("\n"); 
		query.append("               RPAD(SUBSTR(NVL(B.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA17," ).append("\n"); 
		query.append("               --52 Consignee Country" ).append("\n"); 
		query.append("               RPAD(SUBSTR(NVL(B.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA18," ).append("\n"); 
		query.append("               --53 Consignee Phone No" ).append("\n"); 
		query.append("               RPAD(SUBSTR(REGEXP_REPLACE(B.PHN_NO,'[^0-9]',''), " ).append("\n"); 
		query.append("                           1, 14), " ).append("\n"); 
		query.append("                    14, ' ') AS DATA19," ).append("\n"); 
		query.append("               -----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("               --54 Notify Code  (17)" ).append("\n"); 
		query.append("               RPAD(' ', 17, ' ') AS DATA20," ).append("\n"); 
		query.append("               --55 Notify Name" ).append("\n"); 
		query.append("               RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_NM, ' '), 'J'), 1, 70), 70, ' ') AS DATA21," ).append("\n"); 
		query.append("               --56 Notify ADDR" ).append("\n"); 
		query.append("               RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_ADDR, ' '), 'J'), 1, 175), 175, ' ') AS DATA22," ).append("\n"); 
		query.append("               --57 Notify 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("               RPAD(' ', 70, ' ') AS DATA23," ).append("\n"); 
		query.append("               --58 화물 발송인 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA24," ).append("\n"); 
		query.append("               --59 화물 발송인 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA25," ).append("\n"); 
		query.append("               --60 화물 발송인 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA26," ).append("\n"); 
		query.append("               --61 Notify Party Postal Code (Postcode identification)" ).append("\n"); 
		query.append("               RPAD(SUBSTR(NVL(C.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA27," ).append("\n"); 
		query.append("               --62 Notify Party Country Code (Country, coded)" ).append("\n"); 
		query.append("               RPAD(SUBSTR(NVL(C.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA28," ).append("\n"); 
		query.append("               --63 Notify Party Telephone Number" ).append("\n"); 
		query.append("               RPAD(SUBSTR(REGEXP_REPLACE(C.PHN_NO,'[^0-9]',''), " ).append("\n"); 
		query.append("                           1, 14), " ).append("\n"); 
		query.append("                    14, ' ') AS DATA29," ).append("\n"); 
		query.append("               -----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("               --64 Notify Code  (12)" ).append("\n"); 
		query.append("               RPAD(' ', 17, ' ') AS DATA30," ).append("\n"); 
		query.append("               --65 Notify Name" ).append("\n"); 
		query.append("               RPAD(' ', 70, ' ') AS DATA31," ).append("\n"); 
		query.append("               --66 Notify ADDR" ).append("\n"); 
		query.append("               RPAD(' ', 175, ' ') AS DATA32," ).append("\n"); 
		query.append("               --67 Notify 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("               RPAD(' ', 70, ' ') AS DATA33," ).append("\n"); 
		query.append("               --68 화물 발송인 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA34," ).append("\n"); 
		query.append("               --69 화물 발송인 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA35," ).append("\n"); 
		query.append("               --70 화물 발송인 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("               RPAD(' ', 35, ' ') AS DATA36," ).append("\n"); 
		query.append("               --71 Shipper ZIP" ).append("\n"); 
		query.append("               RPAD(' ', 9, ' ') AS DATA37," ).append("\n"); 
		query.append("               --72 Shipper Country" ).append("\n"); 
		query.append("               RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("               --73 Shipper Phone No" ).append("\n"); 
		query.append("               RPAD(' ', 14, ' ') AS DATA39" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_CUST A," ).append("\n"); 
		query.append("               BKG_CSTMS_ADV_JP_CUST B," ).append("\n"); 
		query.append("               BKG_CSTMS_ADV_JP_CUST C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("           AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("           AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = B.BL_SPLIT_NO" ).append("\n"); 
		query.append("           AND B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("           AND A.BL_SPLIT_NO = C.BL_SPLIT_NO" ).append("\n"); 
		query.append("           AND C.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
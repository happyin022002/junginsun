/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.10.30 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRSQL(){
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
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpCustomerRSQL").append("\n"); 
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
		query.append("SELECT --29 Shipper Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS DATA00," ).append("\n"); 
		query.append("       --30 Shipper Name" ).append("\n"); 
		query.append("       RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_NM, ' '), 'J'), 1, 70), 70, ' ') AS DATA01," ).append("\n"); 
		query.append("       --31 Shipper ADDR" ).append("\n"); 
		query.append("       RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_ADDR, ' '), 'J'), 1, 105), 105, ' ') AS DATA02," ).append("\n"); 
		query.append("       --32 Shipper 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA03," ).append("\n"); 
		query.append("       --33 Shipper 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA04," ).append("\n"); 
		query.append("       --34 Shipper 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA05," ).append("\n"); 
		query.append("       --35 Shipper 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA06," ).append("\n"); 
		query.append("       --36 Shipper ZIP" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(A.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA07," ).append("\n"); 
		query.append("       --37 Shipper Country" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(A.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA08," ).append("\n"); 
		query.append("       --38 Shipper Phone No" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(A.PHN_NO, ' '), 1, 14), 14, ' ') AS DATA09," ).append("\n"); 
		query.append("       ----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("       --39 Consignee Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS DATA10," ).append("\n"); 
		query.append("       --40 Consignee Name" ).append("\n"); 
		query.append("       RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_NM, ' '), 'J'), 1, 70), 70, ' ') AS DATA11," ).append("\n"); 
		query.append("       --41 Consignee ADDR" ).append("\n"); 
		query.append("       RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_ADDR, ' '), 'J'), 1, 105), 105, ' ') AS DATA12," ).append("\n"); 
		query.append("       --42 Consignee 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA13," ).append("\n"); 
		query.append("       --43 Consignee 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA14," ).append("\n"); 
		query.append("       --44 Consignee 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA15," ).append("\n"); 
		query.append("       --45 Consignee 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA16," ).append("\n"); 
		query.append("       --46 Consignee ZIP" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(B.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA17," ).append("\n"); 
		query.append("       --47 Consignee Country" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(B.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA18," ).append("\n"); 
		query.append("       --48 Consignee Phone No" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(B.PHN_NO, ' '), 1, 14), 14, ' ') AS DATA19," ).append("\n"); 
		query.append("       -----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("       --49 Notify Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS DATA20," ).append("\n"); 
		query.append("       --50 Notify Name" ).append("\n"); 
		query.append("       RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_NM, ' '), 'J'), 1, 70), 70, ' ') AS DATA21," ).append("\n"); 
		query.append("       --51 Notify ADDR" ).append("\n"); 
		query.append("       RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_ADDR, ' '), 'J'), 1, 105), 105, ' ') AS DATA22," ).append("\n"); 
		query.append("       --52 Notify 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA23," ).append("\n"); 
		query.append("       --53 화물 발송인 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA24," ).append("\n"); 
		query.append("       --54 화물 발송인 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA25," ).append("\n"); 
		query.append("       --55 화물 발송인 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA26," ).append("\n"); 
		query.append("       --56 Shipper ZIP" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(C.CUST_ZIP_ID, ' '), 1, 9), 9, ' ') AS DATA27," ).append("\n"); 
		query.append("       --57 Shipper Country" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(C.CUST_CNT_CD, ' '), 1, 2), 2, ' ') AS DATA28," ).append("\n"); 
		query.append("       --58 Shipper Phone No" ).append("\n"); 
		query.append("       RPAD(SUBSTR(NVL(C.PHN_NO, ' '), 1, 14), 14, ' ') AS DATA29," ).append("\n"); 
		query.append("       -----------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS DATA30," ).append("\n"); 
		query.append("       --49 Notify Code  (12)" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA31," ).append("\n"); 
		query.append("       --50 Notify Name" ).append("\n"); 
		query.append("       RPAD(' ', 105, ' ') AS DATA32," ).append("\n"); 
		query.append("       --51 Notify ADDR" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA33," ).append("\n"); 
		query.append("       --52 Notify 주소 1/4(Street and number/P.O.Box)  (70)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA34," ).append("\n"); 
		query.append("       --53 화물 발송인 주소 2/4(Street and number/P.O.Box)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA35," ).append("\n"); 
		query.append("       --54 화물 발송인 주소 3/4(City name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA36," ).append("\n"); 
		query.append("       --55 화물 발송인 주소 4/4(Country sub-entity, name)  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS DATA37," ).append("\n"); 
		query.append("       --56 Shipper ZIP" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA38," ).append("\n"); 
		query.append("       --57 Shipper Country" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS DATA39" ).append("\n"); 
		query.append("       --58 Shipper Phone No" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_CUST A," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_CUST B," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_CUST C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = B.BL_SPLIT_NO" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = C.BL_SPLIT_NO" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD = 'N'" ).append("\n"); 

	}
}
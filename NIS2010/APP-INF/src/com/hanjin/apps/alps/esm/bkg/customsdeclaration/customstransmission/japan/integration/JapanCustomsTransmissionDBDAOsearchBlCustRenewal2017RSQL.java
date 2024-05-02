/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanCustomsTransmissionDBDAOsearchBlCustRenewal2017RSQL.java
*@FileTitle : JapanCustomsTransmissionDBDAOsearchBlCustRenewal2017RSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.09.05 하대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchBlCustRenewal2017RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCust
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchBlCustRenewal2017RSQL(){
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchBlCustRenewal2017RSQL").append("\n"); 
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
		query.append("       DATA1      , CUST_NM1         , CUST_ADDR1     , DATA2         , DATA3     , DATA4        , DATA5" ).append("\n"); 
		query.append("     , DATA6      , CUST_CNT_CD1     , PHN_NO1        , DATA7       /*, CUST_NM2  , CUST_ADDR2*/ , DATA8        , DATA9     , DATA10" ).append("\n"); 
		query.append("     , DATA11     , DATA12         /*, CUST_CNT_CD2   , PHN_NO2*/     , DATA13    , CUST_NM3     , CUST_ADDR3   , DATA14    , DATA15" ).append("\n"); 
		query.append("     , DATA16     , DATA17           , DATA18         , CUST_CNT_CD3  , PHN_NO3   , DATA19       , DATA20" ).append("\n"); 
		query.append("     , DATA21     , DATA22           , DATA23         , DATA24        , DATA25" ).append("\n"); 
		query.append("     , DATA26     , DATA27           , DATA28" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , CASE WHEN TO_ORDER_FLAG > 0 THEN RPAD('TO ORDER',70, ' ')" ).append("\n"); 
		query.append("            ELSE RPAD(CUST_NM2,70, ' ')" ).append("\n"); 
		query.append("       END AS CUST_NM2    " ).append("\n"); 
		query.append("     , CASE WHEN TO_ORDER_FLAG > 0 THEN RPAD('TO ORDER',175, ' ') /* NAME이 TO ORDER 이면 주소도 TO ORDER */" ).append("\n"); 
		query.append("            ELSE RPAD(CUST_ADDR2,175, ' ')" ).append("\n"); 
		query.append("       END AS CUST_ADDR2   " ).append("\n"); 
		query.append("     , CASE WHEN TO_ORDER_FLAG > 0 THEN CUST_CNT_CD3              /* NAME이 TO ORDER 이면 Notify Country Code */" ).append("\n"); 
		query.append("            ELSE CUST_CNT_CD2" ).append("\n"); 
		query.append("       END AS CUST_CNT_CD2" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("     , CASE WHEN TO_ORDER_FLAG > 0 THEN RPAD('TO ORDER',14, ' ') /* NAME이 TO ORDER 이면 전화번호도 TO ORDER */" ).append("\n"); 
		query.append("            ELSE RPAD(REGEXP_REPLACE(PHN_NO2,'[^0-9]',''),14, ' ')" ).append("\n"); 
		query.append("       END AS PHN_NO2    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (  " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        --21.Shipper Code" ).append("\n"); 
		query.append("            RPAD(' ',17,' ') DATA1,            " ).append("\n"); 
		query.append("        --22.Shipper Name" ).append("\n"); 
		query.append("            RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_NM, ' '), 'J'), 1, 70),70,' ') CUST_NM1," ).append("\n"); 
		query.append("        --23.Shipper Address (block entry)" ).append("\n"); 
		query.append("            RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_ADDR, ' '), 'J'),1,175),175,' ') CUST_ADDR1," ).append("\n"); 
		query.append("        --24.Shipper Address 1/4 (Street and number/P.O. Box)" ).append("\n"); 
		query.append("            RPAD(' ',70,' ') DATA2,                    " ).append("\n"); 
		query.append("        --25.Shipper Address 2/4 (Street and number/P.O. Box)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA3,                  " ).append("\n"); 
		query.append("        --26.Shipper Address 3/4 (City name)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA4, " ).append("\n"); 
		query.append("        --27.Shipper Address 4/4 (Country sub-entity, name)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA5,                   " ).append("\n"); 
		query.append("        --28.Shipper Postal Code (Postcode identification)" ).append("\n"); 
		query.append("            RPAD(' ',9,' ') DATA6," ).append("\n"); 
		query.append("        --29.Shipper Country Code (Country, coded)                     " ).append("\n"); 
		query.append("            RPAD(SUBSTR(NVL(A.CUST_CNT_CD,' '),1,2),2,' ') CUST_CNT_CD1, " ).append("\n"); 
		query.append("        --30.Shipper Telephone Number" ).append("\n"); 
		query.append("            RPAD(SUBSTR(NVL(REGEXP_REPLACE(A.PHN_NO, '[^0-9]', ''),(SELECT OFC_PHN_NO" ).append("\n"); 
		query.append(" 																	  FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append(" 																     WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("   																	   AND ML.LOC_CD         = @[pod_cd])" ).append("\n"); 
		query.append("                            )," ).append("\n"); 
		query.append("                        1,14)," ).append("\n"); 
		query.append("                 14,' ') PHN_NO1," ).append("\n"); 
		query.append("        --31.Consignee Code" ).append("\n"); 
		query.append("            RPAD(' ',17,' ')  DATA7,                     " ).append("\n"); 
		query.append("        --32.Consignee Name" ).append("\n"); 
		query.append("            RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_NM, ' '), 'J'), 1, 70),70,' ') CUST_NM2," ).append("\n"); 
		query.append("        --TO_ORDER_FLAG" ).append("\n"); 
		query.append("            INSTR(REPLACE(B.CUST_NM,' ',''),'TOORDER') AS TO_ORDER_FLAG,            " ).append("\n"); 
		query.append("        --33.Consignee Address (block entry)" ).append("\n"); 
		query.append("            RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_ADDR, ' '), 'J'),1,175),175,' ') CUST_ADDR2," ).append("\n"); 
		query.append("        --34.Consignee Address 1/4 (Street and number/P.O. Box)" ).append("\n"); 
		query.append("            RPAD(' ',70,' ') DATA8," ).append("\n"); 
		query.append("        --35.Consignee Address 2/4 (Street and number/P.O. Box)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA9,                " ).append("\n"); 
		query.append("        --36.Consignee Address 3/4 (City name)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA10, " ).append("\n"); 
		query.append("        --37.Consignee Address 4/4 (Country sub-entity, name)          " ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA11, " ).append("\n"); 
		query.append("        --38.Consignee Postal Code (Postcode identification)                " ).append("\n"); 
		query.append("            RPAD(' ',9,' ') DATA12," ).append("\n"); 
		query.append("        --39.Consignee Country Code (Country, coded)       " ).append("\n"); 
		query.append("            RPAD(SUBSTR(NVL(B.CUST_CNT_CD,' '),1,2),2,' ') CUST_CNT_CD2, " ).append("\n"); 
		query.append("        --40.Consignee Telephone Number" ).append("\n"); 
		query.append("            RPAD(SUBSTR(NVL(REGEXP_REPLACE(B.PHN_NO,'[^0-9]',''),(SELECT OFC_PHN_NO" ).append("\n"); 
		query.append(" 																	  FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append(" 																     WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("   																	   AND ML.LOC_CD         = @[pod_cd])" ).append("\n"); 
		query.append("                           )," ).append("\n"); 
		query.append("                        1,14)," ).append("\n"); 
		query.append("                 14,' ') PHN_NO2," ).append("\n"); 
		query.append("        --41.Notify Party Code" ).append("\n"); 
		query.append("            RPAD(' ',17,' ')  DATA13, " ).append("\n"); 
		query.append("        --42.Notify Party Name" ).append("\n"); 
		query.append("            RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_NM,'SAME AS CONSIGNEE'), 'J'), 1, 70),70,' ') CUST_NM3," ).append("\n"); 
		query.append("        --43.Notify Party Address (block entry)" ).append("\n"); 
		query.append("            RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_ADDR, ' '), 'J'),1,175),175,' ') CUST_ADDR3," ).append("\n"); 
		query.append("        --44.Notify Party Address 1/4(Street and number/P.O.Box)" ).append("\n"); 
		query.append("            RPAD(' ',70,' ') DATA14, " ).append("\n"); 
		query.append("        --45.Notify Party Address 2/4(Street and number/P.O.Box)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA15, " ).append("\n"); 
		query.append("        --46.Notify Party Address 3/4(City name)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA16, " ).append("\n"); 
		query.append("        --47.Notify Party Address 4/4(Country sub- entity, name)                " ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA17, " ).append("\n"); 
		query.append("        --48.Notify Party Postal Code (Postcode identification)" ).append("\n"); 
		query.append("            RPAD(' ',9,' ') DATA18, " ).append("\n"); 
		query.append("        --49.Notify Party Country Code (Country, coded)" ).append("\n"); 
		query.append("            RPAD(SUBSTR(NVL(C.CUST_CNT_CD,' '),1,2),2,' ') CUST_CNT_CD3, " ).append("\n"); 
		query.append("        --50.Notify Party Telephone Number" ).append("\n"); 
		query.append("            RPAD(SUBSTR(NVL(REGEXP_REPLACE(C.PHN_NO, '[^0-9]', ''), (SELECT OFC_PHN_NO" ).append("\n"); 
		query.append(" 																	  FROM MDM_LOCATION ML, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append(" 																     WHERE ML.EQ_CTRL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("   																	   AND ML.LOC_CD         = @[pod_cd])" ).append("\n"); 
		query.append("                           )," ).append("\n"); 
		query.append("                       1,14)," ).append("\n"); 
		query.append("                  14,' ') PHN_NO3," ).append("\n"); 
		query.append("        --51.Notify Party Code(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',17,' ') DATA19," ).append("\n"); 
		query.append("        --52.Notify Party Name(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',70,' ') DATA20, " ).append("\n"); 
		query.append("        --53.Notify Party Address (block entry)(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',175,' ') DATA21," ).append("\n"); 
		query.append("        --54.Notify Party Address 1/4（Street and number/P.O.Box）(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',70,' ') DATA22," ).append("\n"); 
		query.append("        --55.Notify Party Address 2/4（Street and number/P.O.Box）(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA23,  " ).append("\n"); 
		query.append("        --56.Notify Party Address 3/4（City name）(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA24, " ).append("\n"); 
		query.append("        --57.Notify Party Address 4/4（Country sub- entity, name）(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',35,' ') DATA25," ).append("\n"); 
		query.append("        --58.Notify Party Postal Code (Postcode identification)(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',9,' ') DATA26, " ).append("\n"); 
		query.append("        --59.Notify Party Country Code (Country, coded)(반복2)" ).append("\n"); 
		query.append("            RPAD(' ',2,' ') DATA27," ).append("\n"); 
		query.append("        --60.Notify Party Telephone Number(반복2) " ).append("\n"); 
		query.append("            RPAD(' ',14,' ') DATA28  " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            BKG_CSTMS_JP_BL_CUST A, " ).append("\n"); 
		query.append("            BKG_CSTMS_JP_BL_CUST B, " ).append("\n"); 
		query.append("            BKG_CSTMS_JP_BL_CUST C" ).append("\n"); 
		query.append("        WHERE	A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        AND	A.BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 
		query.append("        AND A.BKG_CUST_TP_CD    = 'S'" ).append("\n"); 
		query.append("        AND A.BL_NO     = B.BL_NO" ).append("\n"); 
		query.append("        AND A.BL_SPLIT_NO = B.BL_SPLIT_NO" ).append("\n"); 
		query.append("        AND B.BKG_CUST_TP_CD    = 'C'" ).append("\n"); 
		query.append("        AND A.BL_NO     = C.BL_NO" ).append("\n"); 
		query.append("        AND A.BL_SPLIT_NO = C.BL_SPLIT_NO" ).append("\n"); 
		query.append("        AND C.BKG_CUST_TP_CD    = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
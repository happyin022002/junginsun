/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchBlCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.14 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	RPAD(' ',12,' ') DATA1, --16 Shipper Code  (12)   C                   " ).append("\n"); 
		query.append("	--RPAD(SUBSTR(REPLACE(REPLACE(NVL(A.CUST_NM,' '),CHR(13)||CHR(10),' '),'#',' '),1,175),175,' ') CUST_NM1," ).append("\n"); 
		query.append("	--RPAD(SUBSTR(REPLACE(REPLACE(NVL(A.CUST_ADDR,' '),CHR(13)||CHR(10),' '),'#',' '),1,105),105,' ') CUST_ADDR1," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_NM, ' '), 'J'), 1, 175),175,' ') CUST_NM1," ).append("\n"); 
		query.append("    RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(A.CUST_ADDR, ' '), 'J'),1,105),105,' ') CUST_ADDR1," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA2, --19 화물 발송인 주소 1/4(Street and number/P.O.Box)  (70)   C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA3, --20 화물 발송인 주소 2/4(Street and number/P.O.Box)  (35)   C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA4, --21 화물 발송인 주소 3/4(City name)  (35)   C                     " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA5, --22 화물 발송인 주소 4/4(Country sub-entity, name)  (35)   C                    " ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA6, --23 화물 발송인 우편번호(Postcode identification)  (9)   C                     " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(A.CUST_CNT_CD,' '),1,2),2,' ') CUST_CNT_CD1, " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(A.PHN_NO,' '),1,14),14,' ') PHN_NO1," ).append("\n"); 
		query.append("	RPAD(' ',12,' ')  DATA7, --26 수화인 코드  (12)   C    --Consinee 정보                    " ).append("\n"); 
		query.append("	--RPAD(SUBSTR(REPLACE(REPLACE(NVL(B.CUST_NM,' '),CHR(13)||CHR(10),' '),'#',' '),1,175),175,' ') CUST_NM2," ).append("\n"); 
		query.append("	--RPAD(SUBSTR(REPLACE(REPLACE(NVL(B.CUST_ADDR,' '),CHR(13)||CHR(10),' '),'#',' '),1,105),105,' ') CUST_ADDR2," ).append("\n"); 
		query.append("    RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_NM, ' '), 'J'), 1, 175),175,' ') CUST_NM2," ).append("\n"); 
		query.append("    RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(B.CUST_ADDR, ' '), 'J'),1,105),105,' ') CUST_ADDR2," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA8, --29 수화인주소 1/4(Street and number/P.O.Box)  (70)   C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA9, --30 수화인주소 2/4(Street and number/P.O.Box)  (35)   C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA10, --31 수화인주소 3/4(City name)  (35)   C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA11, --32 수화인주소 4/4(Country sub-entity, name)  (35)   C                     " ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA12, --33 수화인우편번호(Postcode identification)  (9)   C                                          " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(B.CUST_CNT_CD,' '),1,2),2,' ') CUST_CNT_CD2, " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(B.PHN_NO,' '),1,14),14,' ') PHN_NO2," ).append("\n"); 
		query.append("	RPAD(' ',12,' ')  DATA13, --36 착하 통지처 코드  (12)    2            C    --Notify 정보 1  (2회 반복 36~45번)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--RPAD(SUBSTR(REPLACE(REPLACE(NVL(C.CUST_NM,'SAME AS CONSIGNEE'),CHR(13)||CHR(10),' '),'#',' '),1,175),175,' ') CUST_NM3," ).append("\n"); 
		query.append("	--RPAD(SUBSTR(REPLACE(REPLACE(NVL(C.CUST_ADDR,' '),CHR(13)||CHR(10),' '),'#',' '),1,105),105,' ') CUST_ADDR3," ).append("\n"); 
		query.append("	RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_NM,'SAME AS CONSIGNEE'), 'J'), 1, 175),175,' ') CUST_NM3," ).append("\n"); 
		query.append("    RPAD(SUBSTR(BKG_SPCLCHAR_CONV_FNC(NVL(C.CUST_ADDR, ' '), 'J'),1,105),105,' ') CUST_ADDR3," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA14, --39 착하 통지 선주소 1/4(Street and number/P.O.Box)  (70)   *             C                     " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA15, --40 착하 통지 선주소 2/4(Street and number/P.O.Box)  (35)   *             C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA16, --41 착하 통지 선주소 3/4(City name)  (35)   *             C                    " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA17, --42 착하 통지 선주소 4/4(Country sub-entity, name)  (35)   *             C                    " ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA18, --43 착하 통지처 우편번호(Postcode identification)  (9)   *             C                     " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(C.CUST_CNT_CD,' '),1,2),2,' ') CUST_CNT_CD3, " ).append("\n"); 
		query.append("	RPAD(SUBSTR(NVL(C.PHN_NO,' '),1,14),14,' ') PHN_NO3," ).append("\n"); 
		query.append("	RPAD(' ',12,' ') DATA19, --36 착하 통지처 코드  (12)    2            C    --Notify 정보 2  (2회 반복 36~45번)                    " ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA20, --37 Notify Name  (175)   *             C                    " ).append("\n"); 
		query.append("	RPAD(' ',105,' ') DATA21, --38 착하 통지 선주소 (연속 입력)  (105)   *             C    --  주의 @, # 값은 인식하지 못함.                   " ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA22, --39 착하 통지 선주소 1/4(Street and number/P.O.Box)  (70)   *             C                              " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA23,  --40 착하 통지 선주소 2/4(Street and number/P.O.Box)  (35)   *             C                      " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA24, --41 착하 통지 선주소 3/4(City name)  (35)   *             C                              " ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA25, --42 착하 통지 선주소 4/4(Country sub-entity, name)  (35)   *             C                              " ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA26, --43 착하 통지처 우편번호(Postcode identification)  (9)   *             C                             " ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA27, --44 착하 통지처 국명 코드(Country, coded)  (2)   *             C                             " ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA28  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CUST A, " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CUST B, " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CUST C" ).append("\n"); 
		query.append("WHERE	A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	A.BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 
		query.append("AND A.BKG_CUST_TP_CD    = 'S'" ).append("\n"); 
		query.append("AND A.BL_NO     = B.BL_NO" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO = B.BL_SPLIT_NO" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD    = 'C'" ).append("\n"); 
		query.append("AND A.BL_NO     = C.BL_NO" ).append("\n"); 
		query.append("AND A.BL_SPLIT_NO = C.BL_SPLIT_NO" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD    = 'N'" ).append("\n"); 

	}
}
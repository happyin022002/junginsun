/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.09 
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

public class JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEmptyBl
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL(){
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
		params.put("in_call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL").append("\n"); 
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
		query.append("SELECT RPAD(SUBSTR(@[in_call_sgn_no], 1, 9), 9, ' ') AS IN_CALL_SGN_NO, " ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd], 5, 5)), 10, ' ') AS IN_VVD_CD," ).append("\n"); 
		query.append("       RPAD(NVL(JP_TML_VSL_NO, ' '), 10, ' ') AS JP_TML_VSL_NO," ).append("\n"); 
		query.append("       RPAD(' ', 1, ' ') AS DATA01,    --7 POD Split No (1) C" ).append("\n"); 
		query.append("       RPAD(NVL(CY_OPR_ID, ' '), 5, ' ') AS CY_OPR_CD," ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA02,    --10 B/L번호 (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA03,    --11 POL 코드 (5) M" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA04,    --12 Final. DEST Code (5) C" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA05,    --13 Final. DEST Name (20) C" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA06,    --14 DEL DEST Code (5) M" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA07,    --15 DEL DEST Name (20) C" ).append("\n"); 
		query.append("---------------------------------------------------------" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS SHPR_CD,    --16 Shipper Code (12) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_NM1,    --17 Shipper Name (175) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_NM2,    --18 화물 발송인 주소(연속 입력) (105) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_ADDR1,    --19 화물 발송인 주소 1/4(Street and number/P.O.Box) (70) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_ADDR2,    --20 화물 발송인 주소 2/4(Street and number/P.O.Box) (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_ADDR3,    --21 화물 발송인 주소 3/4(City name) (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS SHPR_ADDR4,    --22 화물 발송인 주소 4/4(Country sub-entity, name) (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS SHPR_POST_ID,    --23 화물 발송인 우편번호(Postcode identification) (9) C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS SHPR_CNT_CD,    --24 화물 발송인 국명 코드(Country, Coded) (2) C" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS SHPR_PHN_NO,    --25 화물 발송인 전화번호 (14) C" ).append("\n"); 
		query.append("---------------------------------------------------------" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS CNEE_CD,    --26 수화인 코드 (12) C --Consinee 정보" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_NM1,    --27 Consignee Name (175) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_NM2,    --28 수화인주소(연속 입력) (105) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_ADDR1,    --29 수화인주소 1/4(Street and number/P.O.Box) (70) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_ADDR2,    --30 수화인주소 2/4(Street and number/P.O.Box) (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_ADDR3,    --31 수화인주소 3/4(City name) (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS CNEE_ADDR4,    --32 수화인주소 4/4(Country sub-entity, name) (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS CNEE_POST_ID,    --33 수화인우편번호(Postcode identification) (9) C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS CNEE_CNT_CD,    --34 수화인국명 코드(Country, Coded) (2) C" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS CNEE_PHN_NO,    --35 수화인전화번호 (14) C" ).append("\n"); 
		query.append("---------------------------------------------------------" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS NTFY1_CD,    --36 착하 통지처 코드 (12) 2 C --Notify 정보 1 (2회 반복 36~45번)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_NM1,    --37 Notify Name (175) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_NM2,    --38 착하 통지 선주소 (연속 입력) (105) * C --주의 @, # 값은 인식하지 못함." ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_ADDR1,    --39 착하 통지 선주소 1/4(Street and number/P.O.Box) (70) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_ADDR2,    --40 착하 통지 선주소 2/4(Street and number/P.O.Box) (35) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_ADDR3,    --41 착하 통지 선주소 3/4(City name) (35) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY1_ADDR4,    --42 착하 통지 선주소 4/4(Country sub-entity, name) (35) * C" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS NTFY1_POST_ID,    --43 착하 통지처 우편번호(Postcode identification) (9) * C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS NTFY1_CNT_CD,    --44 착하 통지처 국명 코드(Country, Coded) (2) * C" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS NTFY1_PHN_NO,    --45.착하 통지처 전화번호" ).append("\n"); 
		query.append("---------------------------------------------------------" ).append("\n"); 
		query.append("       RPAD(' ', 12, ' ') AS NTFY2_CD,    --36 착하 통지처 코드 (12) 2 C --Notify 정보 2 (2회 반복 36~45번)" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_NM1,    --37 Notify Name (175) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_NM2,    --38 착하 통지 선주소 (연속 입력) (105) * C --주의 @, # 값은 인식하지 못함." ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR1,    --39 착하 통지 선주소 1/4(Street and number/P.O.Box) (70) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR2,    --40 착하 통지 선주소 2/4(Street and number/P.O.Box) (35) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR3,    --41 착하 통지 선주소 3/4(City name) (35) * C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS NTFY2_ADDR4,    --42 착하 통지 선주소 4/4(Country sub-entity, name) (35) * C" ).append("\n"); 
		query.append("       RPAD(' ', 9, ' ') AS NTFY2_POST_ID,    --43 착하 통지처 우편번호(Postcode identification) (9) * C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS NTFY2_CNT_CD,    --44 착하 통지처 국명 코드(Country, Coded) (2) * C" ).append("\n"); 
		query.append("       RPAD(' ', 14, ' ') AS NTFY2_PHN_NO,    --45.착하 통지처 전화번호" ).append("\n"); 
		query.append("---------------------------------------------------------" ).append("\n"); 
		query.append("       RPAD(' ', 70, ' ') AS DATA48,    --46 Description (70) M" ).append("\n"); 
		query.append("       RPAD(' ', 4, ' ') AS DATA49,    --47 대표 품목번호 HS_CODE (4) C" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA50,    --48 기호번호 (140) M" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA51,    --49 Package (8) M" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA52,    --50 Package단위코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA53,    --51 총중량  GWT (10) M" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA54,    --52 중량단위 코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA55,    --53 인터넷중량 (10) C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA56,    --54 중량단위 코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA57,    --55 용적 (10) M" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA58,    --56 용적단위 코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA59,    --57 원산국 코드 (2) C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA60,    --58 위험화물등 코드 (3) C" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA61,    --59 해상운임(후레토】) (18) C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA62,    --60 해상운임통화종별코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA63,    --61 가격 (18) C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA64,    --62 가격통화종별코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 11, ' ') AS DATA65,    --63 포괄 보세 운송 승인 번호 (11) C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA66,    --64 가양육 식별 (3) C" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA67,    --65 가양육 사유 코드 (3) M" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA68,    --66 가양육 기간 (2) M" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA69,    --67 운송 기간시작 예정일 (8) C" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA70,    --68 운송 기간종료 예정일 (8) C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA71,    --69 개별운송 또는 가양육 화물보세 운송의 운송 도구 코드 (2) C" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA72,    --70 도착지코드 (5) C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA73,    --71 도착지명 (35) C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA74,    --72 타법령 코드 (2) 5[반복] C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA75,    --72 타법령 코드 (2) 5[반복] C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA76,    --72 타법령 코드 (2) 5[반복] C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA77,    --72 타법령 코드 (2) 5[반복] C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA78,    --72 타법령 코드 (2) 5[반복] C" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA79 --73 기사 (140) C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND BL_SPLIT_NO = nvl(@[bl_split_no], '  ')" ).append("\n"); 

	}
}
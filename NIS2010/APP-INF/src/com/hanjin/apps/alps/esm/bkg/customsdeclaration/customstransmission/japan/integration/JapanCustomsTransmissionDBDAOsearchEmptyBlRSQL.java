/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL.java
*@FileTitle : JapanCustomsTransmissionDBDAOsearchEmptyBlRSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.06
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.08.06 하대성
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	RPAD(SUBSTR(@[in_call_sgn_no],1,9),9,' ') IN_CALL_SGN_NO, --3 Vessel Code	" ).append("\n"); 
		query.append("    RPAD( NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd],5,5)),10,' ') IN_VVD_CD, --4 Voyage number" ).append("\n"); 
		query.append("	RPAD(' ',1,' ') DATA1, --7 POD Split No (1)  C	" ).append("\n"); 
		query.append("	RPAD(NVL(CY_OPR_ID,' '),5,' ') CY_OPR_CD, --9 Container Operator Code" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA2,	--10 B/L번호    (35)   C						" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA3, --11 POL 코드  (5)   M 						" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA4, --12 Final. DEST Code  (5) C								" ).append("\n"); 
		query.append("	RPAD(' ',20,' ') DATA5, --13 Final. DEST Name  (20) C							" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA6, --14 DEL DEST Code  (5) M	" ).append("\n"); 
		query.append("	RPAD(' ',20,' ') DATA7, --15 DEL DEST Name  (20) C" ).append("\n"); 
		query.append("	RPAD(' ',12,' ') DATA8,	--16 Shipper Code  (12)   C						" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA9, --17 Shipper Name  (175)   C						" ).append("\n"); 
		query.append("	RPAD(' ',105,' ') DATA10, --18 화물 발송인 주소(연속 입력)  (105)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA11, --19 화물 발송인 주소 1/4(Street and number/P.O.Box)  (70)   C 									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA12, --20 화물 발송인 주소 2/4(Street and number/P.O.Box)  (35)   C 									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA13, --21 화물 발송인 주소 3/4(City name)  (35)   C 									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA14, --22 화물 발송인 주소 4/4(Country sub-entity, name)  (35)   C 								" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA15, --23 화물 발송인 우편번호(Postcode identification)  (9)   C 									" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA16, --24 화물 발송인 국명 코드(Country, coded)  (2)   C							" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA17, --25 화물 발송인 전화번호  (14)   C							" ).append("\n"); 
		query.append("	RPAD(' ',12,' ') DATA18, --26 수화인 코드  (12)   C    --Consinee 정보 							" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA19, --27 Consignee Name  (175)   C						" ).append("\n"); 
		query.append("	RPAD(' ',105,' ') DATA20, --28 수화인주소(연속 입력)  (105)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA21, --29 수화인주소 1/4(Street and number/P.O.Box)  (70)   C 								" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA22, --30 수화인주소 2/4(Street and number/P.O.Box)  (35)   C 									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA23, --31 수화인주소 3/4(City name)  (35)   C  									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA24, --32 수화인주소 4/4(Country sub-entity, name)  (35)   C   						" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA25,	--33 수화인우편번호(Postcode identification)  (9)   C " ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA26,	--34 수화인국명 코드(Country, coded)  (2)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA27, --35 수화인전화번호  (14)   C							" ).append("\n"); 
		query.append("	RPAD(' ',12,' ') DATA28, --36 착하 통지처 코드  (12)	2			C    --Notify 정보 1  (2회 반복 36~45번)							" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA29, --37 Notify Name  (175)   * 			C						" ).append("\n"); 
		query.append("	RPAD(' ',105,' ') DATA30, --38 착하 통지 선주소 (연속 입력)  (105)   * 			C    --  주의 @, # 값은 인식하지 못함.						" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA31, --39 착하 통지 선주소 1/4(Street and number/P.O.Box)  (70)   * 			C 							" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA32, --40 착하 통지 선주소 2/4(Street and number/P.O.Box)  (35)   * 			C							" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA33, --41 착하 통지 선주소 3/4(City name)  (35)   * 			C  									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA34, --42 착하 통지 선주소 4/4(Country sub-entity, name)  (35)   * 			C  								" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA35, --43 착하 통지처 우편번호(Postcode identification)  (9)   * 			C						" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA36, --44 착하 통지처 국명 코드(Country, coded)  (2)   * 			C						" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA37, --45.착하 통지처 전화번호							" ).append("\n"); 
		query.append("	RPAD(' ',12,' ') DATA38, --36 착하 통지처 코드  (12)	2			C    --Notify 정보 2  (2회 반복 36~45번)							" ).append("\n"); 
		query.append("	RPAD(' ',175,' ') DATA39, --37 Notify Name  (175)   * 			C	 					" ).append("\n"); 
		query.append("	RPAD(' ',105,' ') DATA40, --38 착하 통지 선주소 (연속 입력)  (105)   * 			C    --  주의 @, # 값은 인식하지 못함.						" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA41, --39 착하 통지 선주소 1/4(Street and number/P.O.Box)  (70)   * 			C  								" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA42, --40 착하 통지 선주소 2/4(Street and number/P.O.Box)  (35)   * 			C								" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA43, --41 착하 통지 선주소 3/4(City name)  (35)   * 			C  									" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA44, --42 착하 통지 선주소 4/4(Country sub-entity, name)  (35)   * 			C  								" ).append("\n"); 
		query.append("	RPAD(' ',9,' ') DATA45, --43 착하 통지처 우편번호(Postcode identification)  (9)   * 			C								" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA46, --44 착하 통지처 국명 코드(Country, coded)  (2)   * 			C							" ).append("\n"); 
		query.append("	RPAD(' ',14,' ') DATA47, --45.착하 통지처 전화번호							" ).append("\n"); 
		query.append("	RPAD(' ',70,' ') DATA48, --46 Description  (70)   M							" ).append("\n"); 
		query.append("	RPAD(' ',4,' ') DATA49,	 --47 대표 품목번호  (4)   C						" ).append("\n"); 
		query.append("	RPAD(' ',140,' ') DATA50, --48 기호번호  (140)   M 						" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA51,	--49 Package  (8)   M						" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA52,	--50 Package단위코】-도  (3)   M 						" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA53, --51 총중량 	GWT  (10)   M							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA54, --52 중량단위 코드  (3)   M							" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA55, --53 인터넷중량  (10)   C 							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA56,	--54 중량단위 코드  (3)   M						" ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA57, --55 용적  (10)   M 							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA58,	--56 용적단위 코드  (3)   M						" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA59, --57 원산국 코드  (2)   C	 						" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA60, --58 위험화물등 코드  (3)   C							" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA61, --59 해상운임(후레토】)  (18)   C							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA62, --60 해상운임통화종별코드  (3)   M							" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA63, --61 가격  (18)   C							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA64, --62 가격통화종별코드  (3)   M 							" ).append("\n"); 
		query.append("	RPAD(' ',11,' ') DATA65, --63 포괄 보세 운송 승인 번호  (11)   C							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA66, --64 가양육 식별  (3)   C							" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA67, --65 가양육 사유 코드  (3)   M							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA68, --66 가양육 기간  (2)   M 							" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA69,	--67 운송 기간시작 예정일  (8)   C						" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA70, --68 운송 기간종료 예정일  (8)   C 							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA71, --69 개별운송 또는 가양육 화물보세 운송의 운송 도구 코드  (2)   C							" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA72, --70 도착지코드  (5)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA73, --71 도착지명  (35)   C 							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA74, --72 타법령 코드  (2)   5[반복]   C							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA75, --72 타법령 코드  (2)   5[반복]   C							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA76, --72 타법령 코드  (2)   5[반복]   C							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA77, --72 타법령 코드  (2)   5[반복]   C							" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA78, --72 타법령 코드  (2)   5[반복]   C							" ).append("\n"); 
		query.append("	RPAD(' ',140,' ')  DATA79 --73 기사  (140)   C 						" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 

	}
}
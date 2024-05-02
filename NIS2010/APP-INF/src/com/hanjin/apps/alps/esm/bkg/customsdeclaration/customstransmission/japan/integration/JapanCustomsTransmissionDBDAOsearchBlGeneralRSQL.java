/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlGeneral
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
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
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT		" ).append("\n"); 
		query.append("	RPAD(NVL(SUBSTR(@[in_call_sgn_no],1,9),' '),9,' ') IN_CALL_SGN_NO,	" ).append("\n"); 
		query.append("    RPAD( NVL(JP_TML_VSL_NO, SUBSTR(@[in_vvd_cd],5,5)),10,' ') IN_VVD_CD," ).append("\n"); 
		query.append("	RPAD(' ',1,' ') DATA1, --7 POD Split No (1)	" ).append("\n"); 
		query.append("	RPAD(NVL(A.CY_OPR_ID,' '),5,' ') CY_OPR_CD,		" ).append("\n"); 
		query.append("	RPAD('SMLM'||@[bl_no],35,' ') DATA2," ).append("\n"); 
		query.append("	DECODE(L3.ATTR_CTNT2,NULL,DECODE(SUBSTR(L1.LOC_CD,1,2),'AW','AN','CS','CB','EU','ZY','KZ','KA','LI','ZY','RU','RS','TJ','TA','UA','UK','UZ','UB','YU','YE',SUBSTR(L1.LOC_CD,1,2))||'ZZZ',L3.ATTR_CTNT2) UN_LOC_ID1," ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA3, --12 Final. DEST Code  (5) C						" ).append("\n"); 
		query.append("	RPAD(' ',20,' ') DATA4,	--13 Final. DEST Name  (20) C					" ).append("\n"); 
		query.append("	DECODE(L4.ATTR_CTNT2,NULL,DECODE(SUBSTR(L2.LOC_CD,1,2),'AW','AN','CS','CB','EU','ZY','KZ','KA','LI','ZY','RU','RS','TJ','TA','UA','UK','UZ','UB','YU','YE',SUBSTR(L1.LOC_CD,1,2))||'ZZZ',L4.ATTR_CTNT2) UN_LOC_ID2," ).append("\n"); 
		query.append("	RPAD(SUBSTR(DECODE(L4.ATTR_CTNT2,NULL,L2.LOC_NM,' '),1,20),20,' ') LOC_NM," ).append("\n"); 
		query.append("	RPAD(' ',4,' ') DATA5, --47 대표 품목번호  (4)   C						" ).append("\n"); 
		query.append("	LPAD(NVL(A.PCK_QTY,0),8,' ') PCK_QTY,			" ).append("\n"); 
		query.append("	RPAD(DECODE(P.JP_CSTMS_PCK_CD,NULL,'ZZ',P.JP_CSTMS_PCK_CD),3,' ') PCK_CSTMS_CD," ).append("\n"); 
		query.append("	LPAD(DECODE(NVL(A.GRS_WGT,0),0,0,SUBSTR(TO_CHAR(NVL(A.GRS_WGT,0),'0999999.999'),2)),10,' ') GRS_WGT," ).append("\n"); 
		query.append("	DECODE(NVL(A.WGT_UT_CD,'KGS'),'LBS','LBR','KGS','KGM',A.WGT_UT_CD ) WGT_UT_CD," ).append("\n"); 
		query.append("	RPAD(' ',10,' ') DATA6,	--53 인터넷중량  (10)   C					" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA7, --54 중량단위 코드  (3)   C-M							" ).append("\n"); 
		query.append("	LPAD(DECODE(NVL(A.MEAS_QTY,0),0,0,SUBSTR(TO_CHAR(NVL(A.MEAS_QTY,0),'0999999.999'),2)),10,' ') MEAS_QTY," ).append("\n"); 
		query.append("	DECODE(NVL(A.MEAS_UT_CD,'CBM'),'CMF','FTQ','MTQ') MEAS_UT_CD," ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA8, --57 원산국 코드  (2)   C						" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA9, --58 위험화물등 코드  (3)   C						" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA10, --59 해상운임(후레토】)  (18)   C						" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA11, --60 해상운임통화종별코드  (3)   M					" ).append("\n"); 
		query.append("	RPAD(' ',18,' ') DATA12, --61 가격  (18)   C						" ).append("\n"); 
		query.append("	RPAD(' ',3,' ') DATA13, --62 가격통화종별코드  (3)   C-M						" ).append("\n"); 
		query.append("	RPAD(' ',11,' ') DATA14, --63 포괄 보세 운송 승인 번호  (11)   C						" ).append("\n"); 
		query.append("	DECODE(NVL(A.LOCL_TS_IND_CD,'L'),'T','28 ','   ') LOCL_TS_FLG1," ).append("\n"); 
		query.append("	DECODE(NVL(A.LOCL_TS_IND_CD,' '),'T',NVL(A.JP_CSTMS_TRNS_CD,' '),'   ') LOCL_TS_FLG2," ).append("\n"); 
		query.append("	DECODE(NVL(A.LOCL_TS_IND_CD,' '),'T',SUBSTR(TO_CHAR(NVL(A.LMT_NO,0),'99'),2),'  ') LOCL_TS_FLG3," ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA15, --67 운송 기간시작 예정일  (8)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',8,' ') DATA16, --68 운송 기간종료 예정일  (8)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA17,	--69 개별운송 또는 가양육 화물보세 운송의 운송 도구 코드  (2)   C					" ).append("\n"); 
		query.append("	RPAD(' ',5,' ') DATA18, --70 도착지코드  (5)   C 						" ).append("\n"); 
		query.append("	RPAD(' ',35,' ') DATA19, --71 도착지명  (35)   C 					" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA20, --72 타법령 코드  (2)   5[반복]   C						" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA21,	--72 타법령 코드  (2)   5[반복]   C					" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA22,	--72 타법령 코드  (2)   5[반복]   C					" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA23,	--72 타법령 코드  (2)   5[반복]   C					" ).append("\n"); 
		query.append("	RPAD(' ',2,' ') DATA24,	--72 타법령 코드  (2)   5[반복]   C					" ).append("\n"); 
		query.append("	RPAD(' ',140,' ')  DATA25 --73 기사  (140)   C		" ).append("\n"); 
		query.append("FROM BKG_CSTMS_JP_BL A, MDM_LOCATION L1,  MDM_LOCATION L2, MDM_PCK_TP P, BKG_CSTMS_CD_CONV_CTNT L3, BKG_CSTMS_CD_CONV_CTNT L4" ).append("\n"); 
		query.append("WHERE	A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	A.BL_SPLIT_NO = nvl(@[bl_split_no],'  ')" ).append("\n"); 
		query.append("AND A.BKG_POL_CD      = L1.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.BKG_DEL_CD      = L2.LOC_CD(+)" ).append("\n"); 
		query.append("AND L3.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("AND L3.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("AND A.BKG_POL_CD	  = L3.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND L4.CNT_CD(+) = 'JP'" ).append("\n"); 
		query.append("AND L4.CSTMS_DIV_ID(+) = 'JAPAN_LOC'" ).append("\n"); 
		query.append("AND A.BKG_DEL_CD	  = L4.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND A.PCK_TP_CD   = P.PCK_CD(+)" ).append("\n"); 
		query.append("AND P.DELT_FLG(+) = 'N'" ).append("\n"); 

	}
}
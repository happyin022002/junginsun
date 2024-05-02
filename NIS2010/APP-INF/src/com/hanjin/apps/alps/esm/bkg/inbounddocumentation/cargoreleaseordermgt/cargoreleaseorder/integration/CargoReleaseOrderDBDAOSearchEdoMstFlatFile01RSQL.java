/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoMstFlatFile01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.24 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoMstFlatFile01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자가운송 요청 동의서 승인 시 Flat파일 생성을 위한 E-D/O 마스터 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoMstFlatFile01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoMstFlatFile01RSQL").append("\n"); 
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
		query.append("SELECT 'MSG_REQ_NO:'  ||A.EDO_RQST_NO                                 ||'\\n' -- 수신받은 EDO 요청 번호 MRN(11자리) + MSN number(4자리)" ).append("\n"); 
		query.append("|| 'MSG_REQ_FLAG:'||DECODE(A.EDO_ACK_CD,NULL, '9','35')           ||'\\n' -- MESSAGE로 번송 반은 데이터의 구분 9:원본 35:재전송 1:취소" ).append("\n"); 
		query.append("|| 'MSG_TP_FLAG:' ||A.EDO_TP_CD                                   ||'\\n' -- EDO로 수신한 문서 종류 5JN:D/O발급 요청서 5JM:자가운송 신청서 5JK:자가운송 요청 동의서" ).append("\n"); 
		query.append("|| 'MBL_NO:'      ||A.BL_NO                                       ||'\\n' -- 수신받은 EDO 요청 번호 MRN(11자리) + MSN number(4자리)" ).append("\n"); 
		query.append("|| 'MBL_SEQ:'     ||A.MF_SEQ_NO                                   ||'\\n' -- VVD당 정의된 MRN NO에 해당되는 Booking별 새로 부여되는 Number 운항에서는 MRN,MSN으로 분리 구분한다" ).append("\n"); 
		query.append("|| 'DO_NO:'       ||''                                            ||'\\n'" ).append("\n"); 
		query.append("|| 'MSG_R_DT:'    ||TO_CHAR(EDO_RCT_DT, 'YYYYMMDDHH24MISS')       ||'\\n' -- EDO를 수신한 일자" ).append("\n"); 
		query.append("|| 'MSG_ATA_DT:'  ||TO_CHAR(VSL_ARR_DT, 'YYYYMMDDHH24MISS')       ||'\\n' -- Vessel Arrival Date at POD의 도착예정일짜" ).append("\n"); 
		query.append("|| 'MSG_R_LOC:'   ||EDO_RCT_LOC_CD                                ||'\\n' -- EDO MSG를 수신한 LOCATION" ).append("\n"); 
		query.append("|| 'PAYER_NM:'    ||''                                            ||'\\n' -- BL의 송금업체 상호 또는 성명" ).append("\n"); 
		query.append("|| 'PAY_AMT:'     ||''                                            ||'\\n' -- BL의 송금금액" ).append("\n"); 
		query.append("|| 'PAY_CURR_CD:' ||''                                            ||'\\n' -- BL의 송금할 환률" ).append("\n"); 
		query.append("|| 'PAY_BANK:'    ||''                                            ||'\\n' -- BL의 송금할 입금은행명" ).append("\n"); 
		query.append("|| 'PAY_ACCNT:'   ||''                                            ||'\\n' -- BL에 대해 입금계좌번호" ).append("\n"); 
		query.append("|| 'VYG_NO:'      ||A.EDO_SKD_VOY_NO                              ||'\\n' -- BL의 Vessel Voyage No." ).append("\n"); 
		query.append("|| 'DIR_CD:'      ||A.EDO_SKD_DIR_CD                              ||'\\n' -- BL의 Vessel Direction Code" ).append("\n"); 
		query.append("|| 'VSL_NM:'      ||A.EDO_VSL_NM                                  ||'\\n' -- BL의 Vessel Voyage Name" ).append("\n"); 
		query.append("|| 'SELF_IND:'    ||''                                            ||'\\n' -- 자가운송코드 S:자가, A:자선" ).append("\n"); 
		query.append("|| 'REQ_ISS_DT:'  ||''                                            ||'\\n' -- 양수인이 KT-NET에서 요청한 희망 발급일" ).append("\n"); 
		query.append("|| 'REQ_TRNS_DT:' ||TO_CHAR(B.RQST_TRSP_DT,'YYYYMMDDHH24MISS')    ||'\\n' -- Bl에대해 기존 EDO 전송 시간" ).append("\n"); 
		query.append("|| 'MSG_ISS_DT:'  ||''                                            ||'\\n' -- EDO 발행일" ).append("\n"); 
		query.append("|| 'ARV_CD:'      ||B.ARR_AREA_NO                                 ||'\\n' -- BL의 Arrival Location Code(장치장 부호 8 digit) KT net에서 관리하는 Location Code" ).append("\n"); 
		query.append("|| 'ARV_CTS_CD:'  ||B.ARR_CSTMS_NO                                ||'\\n' -- BL의 도착지 관할 세관 코드 3 digit" ).append("\n"); 
		query.append("|| 'BND_FM_CD:'   ||''                                            ||'\\n' -- Bonded Area Code of Departure (8 digit 세관 Code)-KT-NET에서 받는 Code" ).append("\n"); 
		query.append("|| 'BND_TO_CD:'   ||''                                            ||'\\n'" ).append("\n"); 
		query.append("|| 'BND_TO_NM:'   ||''                                            ||'\\n' -- 세관(INBOND)의 Full name" ).append("\n"); 
		query.append("|| 'GOODS_DESC1:' ||B.GDS_DESC1                                   ||'\\n' -- BL의 KT net관의 송신 결과의 Goods Description 1" ).append("\n"); 
		query.append("|| 'GOODS_DESC2:' ||B.GDS_DESC2                                   ||'\\n' -- BL의 KT net관의 송신 결과의 Goods Description 2" ).append("\n"); 
		query.append("|| 'GOODS_DESC3:' ||B.GDS_DESC3                                   ||'\\n' -- BL의 KT net관의 송신 결과의 Goods Description 3" ).append("\n"); 
		query.append("|| 'GOODS_DESC4:' ||B.GDS_DESC4                                   ||'\\n' -- BL의 KT net관의 송신 결과의 Goods Description 4" ).append("\n"); 
		query.append("|| 'INV_AMT:'     ||B.INV_AMT                                     ||'\\n' -- BL의 화주가 찾아갈 경우 지불해야 될 Invoice Amount" ).append("\n"); 
		query.append("|| 'INV_CUR:'     ||B.INV_CURR_CD                                 ||'\\n' -- BL의 화주가 찾아갈 경우 지불해야 될 Invoice Amount 의 Currency(e.g. KRW)" ).append("\n"); 
		query.append("|| 'MISC_DESC:'   ||A.DIFF_RMK                                    ||'\\n' -- BL의 Requester’s Remark" ).append("\n"); 
		query.append("|| 'PKG_CD:'      ||B.PCK_TP_CD                                   ||'\\n' -- BL별 포장 단위로써 Pakege Type Code" ).append("\n"); 
		query.append("|| 'PKG_QTY:'     ||B.PCK_QTY                                     ||'\\n' -- BL별 포장 단위로써 Package수량" ).append("\n"); 
		query.append("|| 'WGT_CD:'      ||B.WGT_UT_CD                                   ||'\\n' -- BL별 해당무게 단위 (Weight Type)" ).append("\n"); 
		query.append("|| 'WGT_QTY:'     ||B.TTL_WGT                                     ||'\\n' -- BL별 해당무게 (Weight)" ).append("\n"); 
		query.append("FROM BKG_EDO_MST A" ).append("\n"); 
		query.append(", BKG_EDO_IBD_TRSP B" ).append("\n"); 
		query.append("WHERE A.EDO_RQST_NO  = B.EDO_RQST_NO" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ = B.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.EDO_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND A.VTY_FLG      = 'Y'" ).append("\n"); 
		query.append("AND A.EDO_TP_CD    = @[edo_tp_cd]" ).append("\n"); 

	}
}
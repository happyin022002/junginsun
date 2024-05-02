/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyHandlingOfcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.08.25 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOModifyHandlingOfcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. S/I일 떄 기존 bkg이 있으면 해당 bkg의 bkg_ofc_cd 
	  * 2.. cust_cnt_cd, cust_seq가 mdm_customer에 mdm_customer에서 담당 office, 
	  * 3. porCd가 mdm_location에 있으면 location의 sales office, 
	  * 4. polCd가 mdm_location에 있으면 location의 sales office를 찾아서 기준 정보 table에서 mapping된 ofc_cd가 있으면 조회된 Office
	  * 5. Doc Type이 'B'인경우와 'S'인 경우에 컬럼을 나누어 저장함.
	  * * 2011.05.23 김진승 [CHM-201110982-01] e-Booking Receipt시 현재 BKG의 CNTR Qty와 접수된 Request상의 CNTR Qty를 업데이트
	  *  - ORG_BKG_QTY , ORG_BKG_CNTR_QTY 칼럼 업데이트 추가 
	  *   => 커밋/태깅 9300에서 테스트 예정 (김진주)
	  * 6.SPLIT_STS_CD : 접수된 Container 가 0개인 경우 Split 대상 아님
	  *                         BKG 의 Container Volume이 접수된 Container수보다 큰 경우 Split 대상
	  * *2013.07.10 최문환 [CHM-201325586] E-BKG & E-SI request Date 기준 조정 요청
	  *  => POR, POL이 없는 경우의 request Date를 Handling Office를 기준으로 계산하도록 변경
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyHandlingOfcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOModifyHandlingOfcUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST M " ).append("\n"); 
		query.append("   SET HNDL_OFC_CD =(SELECT OFC" ).append("\n"); 
		query.append("                       FROM " ).append("\n"); 
		query.append("                        (SELECT RANK, CASE WHEN RANK = 1 THEN OFC.OFC" ).append("\n"); 
		query.append("                                          WHEN RANK <> 1 THEN NVL(CTRL.HNDL_OFC_CD, OFC.OFC) END OFC" ).append("\n"); 
		query.append("                          FROM" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("							SELECT 0.9 RANK, BHC.ATTR_CTNT2 OFC" ).append("\n"); 
		query.append("                              FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                   BKG_HRD_CDG_CTNT  BHC" ).append("\n"); 
		query.append("                             WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]	" ).append("\n"); 
		query.append("                               AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_LOC'" ).append("\n"); 
		query.append("                               AND BHC.ATTR_CTNT1 = MST.POR_CD" ).append("\n"); 
		query.append("                               AND BHC.ATTR_CTNT1 = MST.POL_CD" ).append("\n"); 
		query.append("                               AND BHC.ATTR_CTNT3 ='Location'" ).append("\n"); 
		query.append("							UNION" ).append("\n"); 
		query.append("							SELECT 1 RANK, BK.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                              FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                             WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("           					   AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]	" ).append("\n"); 
		query.append("                            UNION							" ).append("\n"); 
		query.append("                            SELECT 1.4 RANK, DECODE(MST.POL_CD, 'CNXMN', 'XMNSC', 'CNFOC', 'XMNSC', 'HKGSC') OFC" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST MXC," ).append("\n"); 
		query.append("                                                       BKG_HRD_CDG_CTNT BHC," ).append("\n"); 
		query.append("                                                       MDM_LOCATION POL" ).append("\n"); 
		query.append("                                                 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = @[rqst_seq]	" ).append("\n"); 
		query.append("                                                   AND MST.XTER_SNDR_ID = MXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = MXC.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = MXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   AND MXC.XTER_CUST_TP_CD in ( 'E' , 'S' )" ).append("\n"); 
		query.append("                                                   AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'" ).append("\n"); 
		query.append("                                                   AND MXC.CNT_CD = BHC.ATTR_CTNT1" ).append("\n"); 
		query.append("                                                   AND MXC.CUST_SEQ = BHC.ATTR_CTNT2" ).append("\n"); 
		query.append("                                                   AND BHC.ATTR_CTNT3 is null" ).append("\n"); 
		query.append("                                                   AND BHC.ATTR_CTNT4 is null" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_VIA_CD = BHC.ATTR_CTNT6" ).append("\n"); 
		query.append("                                                   AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                                                   and rgn_cd in ('CNS', 'HKG')" ).append("\n"); 
		query.append("                                                   and rownum = 1" ).append("\n"); 
		query.append("	                        UNION " ).append("\n"); 
		query.append("                            SELECT 1.5 RANK, BHC.ATTR_CTNT5 OFC       " ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST,            " ).append("\n"); 
		query.append("                                 BKG_XTER_CUST     MXE,            " ).append("\n"); 
		query.append("                                 BKG_XTER_CUST     MXS,            " ).append("\n"); 
		query.append("                                 BKG_HRD_CDG_CTNT  BHC      " ).append("\n"); 
		query.append("                           WHERE MST.XTER_SNDR_ID = @[sender_id]        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = @[rqst_no]        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = @[rqst_seq]        " ).append("\n"); 
		query.append("                             AND MST.XTER_SNDR_ID = MXE.XTER_SNDR_ID        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = MXE.XTER_RQST_NO        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = MXE.XTER_RQST_SEQ        " ).append("\n"); 
		query.append("                             AND MXE.XTER_CUST_TP_CD = 'E'        " ).append("\n"); 
		query.append("                             AND MST.XTER_SNDR_ID = MXS.XTER_SNDR_ID        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = MXS.XTER_RQST_NO        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = MXS.XTER_RQST_SEQ        " ).append("\n"); 
		query.append("                             AND MXS.XTER_CUST_TP_CD = 'S'              " ).append("\n"); 
		query.append("                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'        " ).append("\n"); 
		query.append("                             AND MXE.CNT_CD = BHC.ATTR_CTNT1        " ).append("\n"); 
		query.append("                             AND MXE.CUST_SEQ = BHC.ATTR_CTNT2        " ).append("\n"); 
		query.append("                             AND MST.POR_CD = BHC.ATTR_CTNT3        " ).append("\n"); 
		query.append("                             AND MXS.CUST_NM LIKE BHC.ATTR_CTNT4||'%'    " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_VIA_CD = BHC.ATTR_CTNT6" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("					      SELECT 1.55 RANK,  BHC.ATTR_CTNT5 OFC          " ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST,            " ).append("\n"); 
		query.append("                                 BKG_XTER_CUST     MXS,            " ).append("\n"); 
		query.append("                                 BKG_HRD_CDG_CTNT  BHC      " ).append("\n"); 
		query.append("                           WHERE MST.XTER_SNDR_ID = @[sender_id]        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = @[rqst_no]        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = @[rqst_seq]    " ).append("\n"); 
		query.append("                             AND MST.XTER_SNDR_ID = MXS.XTER_SNDR_ID        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = MXS.XTER_RQST_NO        " ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = MXS.XTER_RQST_SEQ        " ).append("\n"); 
		query.append("                             AND MXS.XTER_CUST_TP_CD = 'S'              " ).append("\n"); 
		query.append("                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'      " ).append("\n"); 
		query.append("                             and BHC.ATTR_CTNT4 is not null" ).append("\n"); 
		query.append("							 and BHC.ATTR_CTNT1 is null" ).append("\n"); 
		query.append("							 and BHC.ATTR_CTNT2 is null" ).append("\n"); 
		query.append("							 and BHC.ATTR_CTNT3 is null" ).append("\n"); 
		query.append("                             and BHC.ATTR_CTNT6 is null" ).append("\n"); 
		query.append("                             AND upper(MXS.CUST_NM) LIKE upper(BHC.ATTR_CTNT4||'%')" ).append("\n"); 
		query.append("						   UNION" ).append("\n"); 
		query.append("                            SELECT 1.6 RANK" ).append("\n"); 
		query.append("                                   ,NVL(NVL(BHC.ATTR_CTNT3,POR.SLS_OFC_CD), POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                 BKG_XTER_CUST     MXC," ).append("\n"); 
		query.append("                                 BKG_HRD_CDG_CTNT  BHC," ).append("\n"); 
		query.append("                                 MDM_LOCATION      POR," ).append("\n"); 
		query.append("                                 MDM_LOCATION      POL" ).append("\n"); 
		query.append("                           WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                             AND MST.XTER_SNDR_ID = MXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = MXC.XTER_RQST_NO" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = MXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                             AND MXC.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_S'" ).append("\n"); 
		query.append("                             AND MXC.CNT_CD = BHC.ATTR_CTNT1" ).append("\n"); 
		query.append("                             AND MXC.CUST_SEQ = BHC.ATTR_CTNT2" ).append("\n"); 
		query.append("                             AND MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                             AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("							SELECT 1.7 RANK" ).append("\n"); 
		query.append("                                   ,NVL(POR.SLS_OFC_CD, POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                 BKG_HRD_CDG_CTNT  BHC," ).append("\n"); 
		query.append("                                 MDM_LOCATION      POR," ).append("\n"); 
		query.append("                                 MDM_LOCATION      POL" ).append("\n"); 
		query.append("                           WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                             AND MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                             AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_PHILIPS'" ).append("\n"); 
		query.append("                             and ctrt_no in BHC.ATTR_CTNT1   " ).append("\n"); 
		query.append("							UNION" ).append("\n"); 
		query.append("                            SELECT 1.8 RANK" ).append("\n"); 
		query.append("                                   ,NVL(POR.SLS_OFC_CD, POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                            FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                 BKG_XTER_CUST     MXC," ).append("\n"); 
		query.append("                                 BKG_HRD_CDG_CTNT  BHC," ).append("\n"); 
		query.append("                                 MDM_LOCATION      POR," ).append("\n"); 
		query.append("                                 MDM_LOCATION      POL" ).append("\n"); 
		query.append("                           WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                             AND MST.XTER_SNDR_ID = MXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_NO = MXC.XTER_RQST_NO" ).append("\n"); 
		query.append("                             AND MST.XTER_RQST_SEQ = MXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                             AND MXC.XTER_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'" ).append("\n"); 
		query.append("                             AND MXC.CNT_CD = BHC.ATTR_CTNT1" ).append("\n"); 
		query.append("                             AND MXC.CUST_SEQ = BHC.ATTR_CTNT2" ).append("\n"); 
		query.append("                             AND BHC.ATTR_CTNT4 IS NULL" ).append("\n"); 
		query.append("                             AND BHC.ATTR_CTNT1 = 'NL'" ).append("\n"); 
		query.append("                             AND MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                             AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 1.91 RANK " ).append("\n"); 
		query.append("       ,HOS.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("     ,BKG_HNDL_OFC_STUP HOS" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[rqst_seq]     " ).append("\n"); 
		query.append("AND upper(MST.CMDT_DESC) LIKE '%'||HOS.CMDT_NM||'%'" ).append("\n"); 
		query.append("AND HOS.CMDT_NM IS NOT NULL" ).append("\n"); 
		query.append("AND MST.POL_CD LIKE 'US%'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 1.92 RANK " ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("             WHEN FF.CNT_CD = 'US' THEN HOS.HNDL_OFC_CD             " ).append("\n"); 
		query.append("             WHEN SH.CNT_CD = 'US' THEN HOS.HNDL_OFC_CD" ).append("\n"); 
		query.append("             ELSE HOS.HNDL_OFC_CD" ).append("\n"); 
		query.append("             END OFC" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("     ,BKG_XTER_CUST FF" ).append("\n"); 
		query.append("     ,BKG_XTER_CUST SH" ).append("\n"); 
		query.append("     ,BKG_HNDL_OFC_STUP HOS" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("AND MST.POL_CD = HOS.POL_CD" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = FF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = FF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = FF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND FF.XTER_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   							UNION" ).append("\n"); 
		query.append("                            SELECT 2 RANK, MDM_CUST.OFC_CD OFC" ).append("\n"); 
		query.append("                              FROM BKG_XTER_CUST CUST, MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("           					 WHERE CUST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND CUST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND CUST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                               AND CUST.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                               AND CUST.CNT_CD      = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                               AND CUST.CUST_SEQ    = MDM_CUST.CUST_SEQ " ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 3 RANK, MDM_CUST.OFC_CD OFC" ).append("\n"); 
		query.append("                              FROM BKG_XTER_CUST CUST, MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("           					 WHERE CUST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND CUST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND CUST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                               AND CUST.XTER_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("                               AND CUST.CNT_CD      = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                               AND CUST.CUST_SEQ    = MDM_CUST.CUST_SEQ 							" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("							SELECT 3.5 RANK, BHC.ATTR_CTNT2 OFC" ).append("\n"); 
		query.append("							  FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("							       BKG_HRD_CDG_CTNT  BHC" ).append("\n"); 
		query.append("                             WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                               AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("							   AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_LOC'" ).append("\n"); 
		query.append("							   AND BHC.ATTR_CTNT1 = MST.POR_CD " ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 4 RANK, NVL(POR.SLS_OFC_CD, POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                              FROM BKG_XTER_RQST_MST MST, MDM_LOCATION POR, MDM_LOCATION POL" ).append("\n"); 
		query.append("           					 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                               AND MST.POR_CD       = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                               AND MST.POL_CD       = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                            UNION" ).append("\n"); 
		query.append("                            SELECT 5 RANK, MST.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                              FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("           					 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                               AND MST.XTER_RQST_VIA_CD = 'SIM'" ).append("\n"); 
		query.append("                               AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                            ) OFC, BKG_ESVC_CTRL_OFC CTRL" ).append("\n"); 
		query.append("                         WHERE OFC.OFC = CTRL.CTRL_OFC_CD(+)" ).append("\n"); 
		query.append("                        ORDER BY RANK" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                     WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                       AND OFC IS NOT NULL) " ).append("\n"); 
		query.append("	 , BKG_UPLD_STS_CD = 'N'" ).append("\n"); 
		query.append("	 , RQST_DT = NVL((SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,NVL(POR_CD, POL_CD))" ).append("\n"); 
		query.append("					    FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("					   WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("					     AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("					     AND XTER_RQST_SEQ= @[rqst_seq])" ).append("\n"); 
		query.append("				, NVL (GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL'" ).append("\n"); 
		query.append("                                                   , SYSDATE" ).append("\n"); 
		query.append("                                                   , (SELECT LOC_CD" ).append("\n"); 
		query.append("                                                        FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                                       WHERE OFC_CD = (SELECT OFC" ).append("\n"); 
		query.append("                                                                       FROM " ).append("\n"); 
		query.append("                                                                        (SELECT RANK, CASE WHEN RANK = 1 THEN OFC.OFC" ).append("\n"); 
		query.append("                                                                                          WHEN RANK <> 1 THEN NVL(CTRL.HNDL_OFC_CD, OFC.OFC) END OFC" ).append("\n"); 
		query.append("                                                                          FROM" ).append("\n"); 
		query.append("                                                                            (" ).append("\n"); 
		query.append("                                                							SELECT 1 RANK, BK.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                                                                              FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                                                                             WHERE MST.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                                                           					   AND MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]	" ).append("\n"); 
		query.append("                                                                            UNION" ).append("\n"); 
		query.append("                            					SELECT 1.4 RANK, DECODE(MST.POL_CD, 'CNXMN', 'XMNSC', 'CNFOC', 'XMNSC', 'HKGSC') OFC" ).append("\n"); 
		query.append("                                                  FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                                       BKG_XTER_CUST MXC," ).append("\n"); 
		query.append("                                                       BKG_HRD_CDG_CTNT BHC," ).append("\n"); 
		query.append("                                                       MDM_LOCATION POL" ).append("\n"); 
		query.append("                                                 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = @[rqst_seq]	" ).append("\n"); 
		query.append("                                                   AND MST.XTER_SNDR_ID = MXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_NO = MXC.XTER_RQST_NO" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_SEQ = MXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                                                   AND MXC.XTER_CUST_TP_CD in ( 'E' , 'S' )" ).append("\n"); 
		query.append("                                                   AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'" ).append("\n"); 
		query.append("                                                   AND MXC.CNT_CD = BHC.ATTR_CTNT1" ).append("\n"); 
		query.append("                                                   AND MXC.CUST_SEQ = BHC.ATTR_CTNT2" ).append("\n"); 
		query.append("                                                   AND BHC.ATTR_CTNT3 is null" ).append("\n"); 
		query.append("                                                   AND BHC.ATTR_CTNT4 is null" ).append("\n"); 
		query.append("                                                   AND MST.XTER_RQST_VIA_CD = BHC.ATTR_CTNT6" ).append("\n"); 
		query.append("                                                   AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                                                   and rgn_cd in ('CNS', 'HKG')" ).append("\n"); 
		query.append("                                                   and rownum = 1" ).append("\n"); 
		query.append("                                                	                        UNION " ).append("\n"); 
		query.append("                                                                            SELECT 1.5 RANK, BHC.ATTR_CTNT5 OFC       " ).append("\n"); 
		query.append("                                                                            FROM BKG_XTER_RQST_MST MST,            " ).append("\n"); 
		query.append("                                                                                 BKG_XTER_CUST     MXE,            " ).append("\n"); 
		query.append("                                                                                 BKG_XTER_CUST     MXS,            " ).append("\n"); 
		query.append("                                                                                 BKG_HRD_CDG_CTNT  BHC      " ).append("\n"); 
		query.append("                                                                           WHERE MST.XTER_SNDR_ID = @[sender_id]        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_NO = @[rqst_no]        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_SEQ = @[rqst_seq]        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_SNDR_ID = MXE.XTER_SNDR_ID        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_NO = MXE.XTER_RQST_NO        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_SEQ = MXE.XTER_RQST_SEQ        " ).append("\n"); 
		query.append("                                                                             AND MXE.XTER_CUST_TP_CD = 'E'        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_SNDR_ID = MXS.XTER_SNDR_ID        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_NO = MXS.XTER_RQST_NO        " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_SEQ = MXS.XTER_RQST_SEQ        " ).append("\n"); 
		query.append("                                                                             AND MXS.XTER_CUST_TP_CD = 'S'              " ).append("\n"); 
		query.append("                                                                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'        " ).append("\n"); 
		query.append("                                                                             AND MXE.CNT_CD = BHC.ATTR_CTNT1        " ).append("\n"); 
		query.append("                                                                             AND MXE.CUST_SEQ = BHC.ATTR_CTNT2        " ).append("\n"); 
		query.append("                                                                             AND MST.POR_CD = BHC.ATTR_CTNT3        " ).append("\n"); 
		query.append("                                                                             AND MXS.CUST_NM LIKE BHC.ATTR_CTNT4||'%'    " ).append("\n"); 
		query.append("                                                                             AND MST.XTER_RQST_VIA_CD = BHC.ATTR_CTNT6" ).append("\n"); 
		query.append("									       UNION" ).append("\n"); 
		query.append("                                          SELECT 1.55 RANK,  BHC.ATTR_CTNT5 OFC          " ).append("\n"); 
		query.append("                                            FROM BKG_XTER_RQST_MST MST,            " ).append("\n"); 
		query.append("                                                 BKG_XTER_CUST     MXS,            " ).append("\n"); 
		query.append("                                                 BKG_HRD_CDG_CTNT  BHC      " ).append("\n"); 
		query.append("                                           WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                             AND MST.XTER_RQST_NO = @[rqst_no]        " ).append("\n"); 
		query.append("                                             AND MST.XTER_RQST_SEQ = @[rqst_seq]    " ).append("\n"); 
		query.append("                                             AND MST.XTER_SNDR_ID = MXS.XTER_SNDR_ID        " ).append("\n"); 
		query.append("                                             AND MST.XTER_RQST_NO = MXS.XTER_RQST_NO        " ).append("\n"); 
		query.append("                                             AND MST.XTER_RQST_SEQ = MXS.XTER_RQST_SEQ        " ).append("\n"); 
		query.append("                                             AND MXS.XTER_CUST_TP_CD = 'S'              " ).append("\n"); 
		query.append("                                             AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'      " ).append("\n"); 
		query.append("                                             and BHC.ATTR_CTNT4 is not null" ).append("\n"); 
		query.append("                                             and BHC.ATTR_CTNT1 is null" ).append("\n"); 
		query.append("                                             and BHC.ATTR_CTNT2 is null" ).append("\n"); 
		query.append("                                             and BHC.ATTR_CTNT3 is null" ).append("\n"); 
		query.append("                                             and BHC.ATTR_CTNT6 is null" ).append("\n"); 
		query.append("                                             AND upper(MXS.CUST_NM) LIKE upper(BHC.ATTR_CTNT4||'%')" ).append("\n"); 
		query.append("                                                                            UNION" ).append("\n"); 
		query.append("                                                                          SELECT 1.6 RANK" ).append("\n"); 
		query.append("                                                                                 ,NVL(NVL(BHC.ATTR_CTNT3,POR.SLS_OFC_CD), POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                                                                            FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("																				 BKG_XTER_CUST     MXC," ).append("\n"); 
		query.append("																				 BKG_HRD_CDG_CTNT  BHC," ).append("\n"); 
		query.append("																				 MDM_LOCATION      POR," ).append("\n"); 
		query.append("																				 MDM_LOCATION      POL" ).append("\n"); 
		query.append("																			WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("																			AND MST.XTER_SNDR_ID = MXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_NO = MXC.XTER_RQST_NO" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_SEQ = MXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("																			AND MXC.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("																			AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_S'" ).append("\n"); 
		query.append("																			AND MXC.CNT_CD = BHC.ATTR_CTNT1" ).append("\n"); 
		query.append("																			AND MXC.CUST_SEQ = BHC.ATTR_CTNT2" ).append("\n"); 
		query.append("																			AND MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("																			AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                                                                    UNION" ).append("\n"); 
		query.append("																	SELECT 1.7 RANK" ).append("\n"); 
		query.append("                                                                           ,NVL(POR.SLS_OFC_CD, POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                                                                    FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                                                         BKG_HRD_CDG_CTNT  BHC," ).append("\n"); 
		query.append("                                                                         MDM_LOCATION      POR," ).append("\n"); 
		query.append("                                                                         MDM_LOCATION      POL" ).append("\n"); 
		query.append("                                                                   WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                                     AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                                     AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                                                                     AND MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                                                                     AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                                                                     AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_PHILIPS'" ).append("\n"); 
		query.append("                                                                     and ctrt_no in BHC.ATTR_CTNT1  " ).append("\n"); 
		query.append("																	UNION                           " ).append("\n"); 
		query.append("                                                                          SELECT 1.8 RANK" ).append("\n"); 
		query.append("                                                                                 ,NVL(POR.SLS_OFC_CD, POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("																			FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("																				 BKG_XTER_CUST     MXC," ).append("\n"); 
		query.append("																				 BKG_HRD_CDG_CTNT  BHC," ).append("\n"); 
		query.append("																				 MDM_LOCATION      POR," ).append("\n"); 
		query.append("																				 MDM_LOCATION      POL" ).append("\n"); 
		query.append("																			WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("																			AND MST.XTER_SNDR_ID = MXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_NO = MXC.XTER_RQST_NO" ).append("\n"); 
		query.append("																			AND MST.XTER_RQST_SEQ = MXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("																			AND MXC.XTER_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("																			AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC'" ).append("\n"); 
		query.append("																			AND MXC.CNT_CD = BHC.ATTR_CTNT1" ).append("\n"); 
		query.append("																			AND MXC.CUST_SEQ = BHC.ATTR_CTNT2" ).append("\n"); 
		query.append("																			AND BHC.ATTR_CTNT4 IS NULL" ).append("\n"); 
		query.append("																			AND BHC.ATTR_CTNT1 = 'NL'" ).append("\n"); 
		query.append("																			AND MST.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("																			AND MST.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 1.91 RANK " ).append("\n"); 
		query.append("       ,HOS.HNDL_OFC_CD OFC" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("     ,BKG_HNDL_OFC_STUP HOS" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[rqst_seq]     " ).append("\n"); 
		query.append("AND upper(MST.CMDT_DESC) LIKE '%'||HOS.CMDT_NM||'%'" ).append("\n"); 
		query.append("AND HOS.CMDT_NM IS NOT NULL" ).append("\n"); 
		query.append("AND MST.POL_CD LIKE 'US%' " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 1.92 RANK " ).append("\n"); 
		query.append(",CASE " ).append("\n"); 
		query.append("             WHEN FF.CNT_CD = 'US' THEN HOS.HNDL_OFC_CD             " ).append("\n"); 
		query.append("             WHEN SH.CNT_CD = 'US' THEN HOS.HNDL_OFC_CD" ).append("\n"); 
		query.append("             ELSE HOS.HNDL_OFC_CD" ).append("\n"); 
		query.append("             END OFC" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("     ,BKG_XTER_CUST FF" ).append("\n"); 
		query.append("     ,BKG_XTER_CUST SH" ).append("\n"); 
		query.append("     ,BKG_HNDL_OFC_STUP HOS" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("AND MST.POL_CD = HOS.POL_CD" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = FF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = FF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = FF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND FF.XTER_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND SH.XTER_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("                                                   							UNION" ).append("\n"); 
		query.append("                                                                            SELECT 2 RANK, MDM_CUST.OFC_CD OFC" ).append("\n"); 
		query.append("                                                                              FROM BKG_XTER_CUST CUST, MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("                                                           					 WHERE CUST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                				               AND CUST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                           					   AND CUST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                                                                               AND CUST.XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                                               AND CUST.CNT_CD      = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                               AND CUST.CUST_SEQ    = MDM_CUST.CUST_SEQ " ).append("\n"); 
		query.append("                                                                            UNION" ).append("\n"); 
		query.append("                                                                            SELECT 3 RANK, MDM_CUST.OFC_CD OFC" ).append("\n"); 
		query.append("                                                                              FROM BKG_XTER_CUST CUST, MDM_CUSTOMER MDM_CUST" ).append("\n"); 
		query.append("                                                           					 WHERE CUST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                				               AND CUST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                           					   AND CUST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                                                                               AND CUST.XTER_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("                                                                               AND CUST.CNT_CD      = MDM_CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                               AND CUST.CUST_SEQ    = MDM_CUST.CUST_SEQ 							" ).append("\n"); 
		query.append("                                                                            UNION" ).append("\n"); 
		query.append("                                                							SELECT 3.5 RANK, BHC.ATTR_CTNT2 OFC" ).append("\n"); 
		query.append("                                                							  FROM BKG_XTER_RQST_MST MST," ).append("\n"); 
		query.append("                                                							       BKG_HRD_CDG_CTNT  BHC" ).append("\n"); 
		query.append("                                                                             WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                                               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                                               AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("                                                							   AND BHC.HRD_CDG_ID = 'EBKG_HND_OFC_LOC'" ).append("\n"); 
		query.append("                                                							   AND BHC.ATTR_CTNT1 = MST.POR_CD " ).append("\n"); 
		query.append("                                                                            UNION" ).append("\n"); 
		query.append("                                                                            SELECT 4 RANK, NVL(POR.SLS_OFC_CD, POL.SLS_OFC_CD) OFC" ).append("\n"); 
		query.append("                                                                              FROM BKG_XTER_RQST_MST MST, MDM_LOCATION POR, MDM_LOCATION POL" ).append("\n"); 
		query.append("                                                           					 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                                                                               AND MST.POR_CD       = POR.LOC_CD(+)" ).append("\n"); 
		query.append("                                                                               AND MST.POL_CD       = POL.LOC_CD(+)" ).append("\n"); 
		query.append("                                                                            UNION" ).append("\n"); 
		query.append("                                                                            SELECT 5 RANK, MST.BKG_OFC_CD OFC" ).append("\n"); 
		query.append("                                                                              FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("                                                           					 WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("                                                				               AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("                                                           					   AND MST.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("                                                                               AND MST.XTER_RQST_VIA_CD = 'SIM'" ).append("\n"); 
		query.append("                                                                               AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                                            ) OFC, BKG_ESVC_CTRL_OFC CTRL" ).append("\n"); 
		query.append("                                                                         WHERE OFC.OFC = CTRL.CTRL_OFC_CD(+)" ).append("\n"); 
		query.append("                                                                        ORDER BY RANK" ).append("\n"); 
		query.append("                                                                        )" ).append("\n"); 
		query.append("                                                                     WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                                                       AND OFC IS NOT NULL)))" ).append("\n"); 
		query.append("                                                   , SYSDATE))" ).append("\n"); 
		query.append("	, GDS_DESC  = @[gds_desc]" ).append("\n"); 
		query.append("	, MK_DESC   = @[mk_desc]" ).append("\n"); 
		query.append("	, ESTM_WGT_UT_CD = DECODE( ESTM_WGT_UT_CD, NULL, 'KGS','K','KGS','L','LBS',ESTM_WGT_UT_CD)" ).append("\n"); 
		query.append("	, MEAS_UT_CD     = DECODE( MEAS_UT_CD,     NULL, 'CBM','X','CBM','E','CBF',MEAS_UT_CD)" ).append("\n"); 
		query.append("	, SI_CNTC_NM          = DECODE( DOC_TP_CD, 'S', CNTC_NM         , SI_CNTC_NM         )" ).append("\n"); 
		query.append("	, SI_CNTC_PHN_INTL_NO = DECODE( DOC_TP_CD, 'S', CNTC_PHN_INTL_NO, SI_CNTC_PHN_INTL_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_PHN_AREA_NO = DECODE( DOC_TP_CD, 'S', CNTC_PHN_AREA_NO, SI_CNTC_PHN_AREA_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_PHN_NO      = DECODE( DOC_TP_CD, 'S', CNTC_PHN_NO     , SI_CNTC_PHN_NO     )" ).append("\n"); 
		query.append("	, SI_CNTC_XTN_PHN_NO  = DECODE( DOC_TP_CD, 'S', CNTC_XTN_PHN_NO , SI_CNTC_XTN_PHN_NO )" ).append("\n"); 
		query.append("	, SI_CNTC_FAX_INTL_NO = DECODE( DOC_TP_CD, 'S', CNTC_FAX_INTL_NO, SI_CNTC_FAX_INTL_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_FAX_AREA_NO = DECODE( DOC_TP_CD, 'S', CNTC_FAX_AREA_NO, SI_CNTC_FAX_AREA_NO)" ).append("\n"); 
		query.append("	, SI_CNTC_FAX_NO      = DECODE( DOC_TP_CD, 'S', CNTC_FAX_NO     , SI_CNTC_FAX_NO     )" ).append("\n"); 
		query.append("	, SI_CNTC_EML         = DECODE( DOC_TP_CD, 'S', CNTC_EML        , SI_CNTC_EML        )" ).append("\n"); 
		query.append("	, SI_CNTC_MPHN_NO     = DECODE( DOC_TP_CD, 'S', CNTC_MPHN_NO    , SI_CNTC_MPHN_NO    )" ).append("\n"); 
		query.append("	, CNTC_NM             = DECODE( DOC_TP_CD, 'S', ''              , CNTC_NM            )" ).append("\n"); 
		query.append("	, CNTC_PHN_INTL_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_PHN_INTL_NO   )" ).append("\n"); 
		query.append("	, CNTC_PHN_AREA_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_PHN_AREA_NO   )" ).append("\n"); 
		query.append("	, CNTC_PHN_NO         = DECODE( DOC_TP_CD, 'S', ''              , CNTC_PHN_NO        )" ).append("\n"); 
		query.append("	, CNTC_XTN_PHN_NO     = DECODE( DOC_TP_CD, 'S', ''              , CNTC_XTN_PHN_NO    )" ).append("\n"); 
		query.append("	, CNTC_FAX_INTL_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_FAX_INTL_NO   )" ).append("\n"); 
		query.append("	, CNTC_FAX_AREA_NO    = DECODE( DOC_TP_CD, 'S', ''              , CNTC_FAX_AREA_NO   )" ).append("\n"); 
		query.append("	, CNTC_FAX_NO         = DECODE( DOC_TP_CD, 'S', ''              , CNTC_FAX_NO        )" ).append("\n"); 
		query.append("	, CNTC_EML            = DECODE( DOC_TP_CD, 'S', ''              , CNTC_EML           )" ).append("\n"); 
		query.append("	, CNTC_MPHN_NO        = DECODE( DOC_TP_CD, 'S', ''              , CNTC_MPHN_NO       )	" ).append("\n"); 
		query.append("    , ORG_BKG_QTY         = (CASE WHEN (SELECT COUNT(CNTR_NO) " ).append("\n"); 
		query.append("                                        FROM BKG_XTER_CNTR C " ).append("\n"); 
		query.append("                                        WHERE C.XTER_SNDR_ID = M.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_NO = M.XTER_RQST_NO " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_SEQ = M.XTER_RQST_SEQ) = 0 THEN NULL" ).append("\n"); 
		query.append("                                  ELSE (SELECT SUM(OP_CNTR_QTY) " ).append("\n"); 
		query.append("                                        FROM BKG_QUANTITY C " ).append("\n"); 
		query.append("                                        WHERE C.BKG_NO = M.BKG_NO " ).append("\n"); 
		query.append("                                        AND CNTR_TPSZ_CD NOT LIKE 'Q%')" ).append("\n"); 
		query.append("                             END ) " ).append("\n"); 
		query.append("    , ORG_BKG_CNTR_QTY    = (CASE WHEN (SELECT COUNT(CNTR_NO) " ).append("\n"); 
		query.append("                                        FROM BKG_XTER_CNTR C " ).append("\n"); 
		query.append("                                        WHERE C.XTER_SNDR_ID = M.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_NO = M.XTER_RQST_NO " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_SEQ = M.XTER_RQST_SEQ) = 0 THEN NULL" ).append("\n"); 
		query.append("                                  ELSE (SELECT SUM(CNTR_VOL_QTY) " ).append("\n"); 
		query.append("                                        FROM BKG_CONTAINER C " ).append("\n"); 
		query.append("                                        WHERE C.BKG_NO = M.BKG_NO )" ).append("\n"); 
		query.append("                             END ) " ).append("\n"); 
		query.append("    , SPLIT_STS_CD        = (CASE WHEN XTER_SNDR_ID = 'EML' THEN SPLIT_STS_CD" ).append("\n"); 
		query.append("                                  WHEN (SELECT COUNT(CNTR_NO) " ).append("\n"); 
		query.append("                                        FROM BKG_XTER_CNTR C " ).append("\n"); 
		query.append("                                        WHERE C.XTER_SNDR_ID = M.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_NO = M.XTER_RQST_NO " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_SEQ = M.XTER_RQST_SEQ) = 0 THEN NULL" ).append("\n"); 
		query.append("                                  WHEN (SELECT SUM(OP_CNTR_QTY) " ).append("\n"); 
		query.append("                                        FROM BKG_QUANTITY C " ).append("\n"); 
		query.append("                                        WHERE C.BKG_NO = M.BKG_NO " ).append("\n"); 
		query.append("                                        AND CNTR_TPSZ_CD NOT LIKE 'Q%')" ).append("\n"); 
		query.append("                                        >" ).append("\n"); 
		query.append("                                       (SELECT COUNT(CNTR_NO) FROM BKG_XTER_CNTR C " ).append("\n"); 
		query.append("                                        WHERE C.XTER_SNDR_ID = M.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_NO = M.XTER_RQST_NO " ).append("\n"); 
		query.append("                                        AND C.XTER_RQST_SEQ = M.XTER_RQST_SEQ) THEN 'S'" ).append("\n"); 
		query.append("                                  ELSE NULL" ).append("\n"); 
		query.append("                             END )" ).append("\n"); 
		query.append("--add 2011/11/24 " ).append("\n"); 
		query.append(", INCL_RT_BL_KNT = DECODE(XTER_SNDR_ID,'EXCEL', DECODE(XTER_BL_TP_CD,'S','','W','',INCL_RT_BL_KNT),INCL_RT_BL_KNT)" ).append("\n"); 
		query.append(", XCLD_RT_BL_KNT = DECODE(XTER_SNDR_ID,'EXCEL', DECODE(XTER_BL_TP_CD,'S','','W','',XCLD_RT_BL_KNT),XCLD_RT_BL_KNT)" ).append("\n"); 
		query.append(", NON_NEGO_RT_INCL_KNT = DECODE(XTER_SNDR_ID,'EXCEL', DECODE(XTER_BL_TP_CD,'W',INCL_RT_BL_KNT,NON_NEGO_RT_INCL_KNT),NON_NEGO_RT_INCL_KNT)" ).append("\n"); 
		query.append(", NON_NEGO_RT_XCLD_KNT = DECODE(XTER_SNDR_ID,'EXCEL', DECODE(XTER_BL_TP_CD,'W',XCLD_RT_BL_KNT,NON_NEGO_RT_XCLD_KNT),NON_NEGO_RT_XCLD_KNT)" ).append("\n"); 
		query.append(", USA_CSTMS_FILE_NO = DECODE(XTER_BL_TP_CD,'H',BL_NO_CTNT,USA_CSTMS_FILE_NO)" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 

	}
}
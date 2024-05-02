/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptBCImpl.java
*@FileTitle : e-Booking n SI Process
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.05.21 전용진
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
* 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
* 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
* 2011.01.11 이일민 [] 1월 6일자 R4J 관련 수정
* 2011.03.02 김영철 [] EDI로 ACK를 보내주는 부분을 수정 ( EDI로 들어온것만 보내도록 함. )
* 2011.03.29 이일민 [] seanaccs처럼 samsung추가 (1421 라인 sendXterRqstRejectEmail 임시 주석)
* 2011.03.31 이일민 [CHM-201109868-01] e-Booking & SI Request pop-up 기능 변경
* 2011.04.18 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청
* 2011.04.21 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청- 담당 office에 notice 삭제 (batch로 notice)
* 2011.05.24,26 김진승 [CHM-201111095-01] e-Booking Receipt 중 Booking Quantity에 EQ Sub 정보 업로드 처리  
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2011.06.09 손은주 [CHM-201111364-01] EDI BKG# prefix 처리 로직 추가 요청
* 2011.06.10 손은주 [CHM-201111435-01]소문자 BKG NO 대문자 자동 변환 요청
* 2011.07.05 이일민 Simple EDI 오류메일 전송 라이브 적용
* 2011.07.12 김진승 [CHM-201111965-01 [Simple SI] Customer Code I/F 요청
* 2011.07.11 정선용 [CHM-201112036-01] [INTTRA] S/I Rejection APERAK 요청.
* 2011.08.19 정선용 [CHM-201112445-01] SI Automation System 구축
* 2011.08.24 김기종 [CHM-201112495-01] Split Candidate 후보 flag변경(취소)기능 개발요청
* 2011.10.18 정선용 [CHM-201114011]    Sea NACCS 순차 수신여부 확인 로그 추가
* 2011.10.19 정선용 [CHM-201113772-01] [삼성SDS] 신규 TP ID 셋업 요청 
* 2011.12.02 정선용 [CLT-111121273-01] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2011.12.21 정선용 [CHM-201115169-01] [INTTRA] SOC 항목 F/F 추가 및 매핑 수정
* 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
* 2012.06.21 조정민 [CHM-201218361] [BKG] [삼성전자] BOKCON 재전송 기능 검토 요청
* 2012.11.06 김현화 [CHM-201220884-01]APERAK 송신 로직 추가(searchXterBkgAckReceiver)
* 2012.11.09 김진주 [             ] 자체 개선사항. e-BKG/SI 수신오류 원인 분석 메세지  제공
* 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
* 2013.08.06 최문환 [CHM-201326009] [Customer란] EDI 수신 문서 대문자로 변환 로직 요청
* 2014.08.22 최도순[CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화
* 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
* 2014.11.03 최도순[CHM-201432379] 미주 E-BKG HANDLING OFFICE 지정로직
* 2014.01.13 최도순 [CHM-201433292] e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
* =======================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration.EBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration.EBookingReceiptEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterChgRtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtPtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtRqstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.DgRiderCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.EBookingControlMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ErrMsgToEsvcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstAkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl1VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl2VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstRfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiInstrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RejectEdiVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RjctSndrRcvrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterEtcInterfaceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterShprInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TmnlRcvIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration.PerformanceReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImgStoVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;

/**
 * ALPS-EBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-EBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0228EventResponse,EBookingReceiptBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class EBookingReceiptBCImpl extends BasicCommandSupport implements EBookingReceiptBC {

	// Database Access Object
	private transient EBookingReceiptDBDAO dbDao = null;
	private transient PerformanceReportDBDAO prDbDao = null;
	// EAI Access Object
	private transient EBookingReceiptEAIDAO eaiDao = null;

	/**
	 * EBookingReceiptBCImpl 객체 생성<br>
	 * EBookingReceiptDBDAO를 생성한다.<br>
	 */
	public EBookingReceiptBCImpl() { 
		dbDao = new EBookingReceiptDBDAO();
		eaiDao = new EBookingReceiptEAIDAO();
		prDbDao = new PerformanceReportDBDAO();
	}
    /**
	 * continent code를 조회한다.<br>
     *
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchComboMdmConti() throws EventException {
        try {
            return dbDao.searchComboMdmConti();
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }
    
    private boolean propertySet(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(toCamelCase(fieldName));
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
                log.error(e.getMessage());
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }
    
	private String toCamelCase(String target) {
		StringBuffer buffer = new StringBuffer();
		for (String token : target.toLowerCase().split("_")) {
			buffer.append(StringUtils.capitalize(token));
		}
		return StringUtils.uncapitalize(buffer.toString());
	}
	
	/**
	 * Excel 파일에서 추출한 External Request를 VGM의 data로 insert한다<br>
	 *
	 * @param	List<BkgXterVrfdWgtRqstVO> rqstList
	 * @param	List<BkgXterVrfdWgtPtyVO> ptyList  
	 * @exception EventException
	 */
	public void receiptXterVGMRqstXls(List<BkgXterVrfdWgtRqstVO> rqstList, List<BkgXterVrfdWgtPtyVO> ptyList) throws EventException {
		try {			
			for(BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO : rqstList){
				dbDao.addBkgXterVrfdWgtRqst(bkgXterVrfdWgtRqstVO, null);
			}
			for(BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO : ptyList){
				dbDao.addBkgXterVrfdWgtPty(bkgXterVrfdWgtPtyVO, null);
			}			
		} catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
		}
	}
    /**
	 * FlatFile 형태의 External Request를 VGM의 data로 insert한다<br>
	 *
	 * @param	String rcvMsg 
	 * @exception EventException
	 */
	public void receiptXterVGMRqst(String rcvMsg) throws EventException {
		try {
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("XTER_BKG_RECEIPT_VGM");
	        List<BkgHrdCdgCtntVO> hrdCdgList = searchHardCoding(bkgHrdCdgCtntListCondVO);
	        
	        String[] rcvMsgS = splitString(rcvMsg, '\n');
	        	        
			String[] splitRcvMsg = null;
			
			List<XterRqstVO> sealList = new ArrayList<XterRqstVO>();	
			List<XterRqstVO> cntrCustList = new ArrayList<XterRqstVO>();
			List<XterRqstVO> vermasList = new ArrayList<XterRqstVO>();
			List<XterRqstVO> cntrList = new ArrayList<XterRqstVO>();
			
			String[] groupList = {"IVC_CNTR_SEAL","IVC_CNTR_CUST","IV_CNTR", "I_VERMAS"};

			String rawMsg = rcvMsg.replace("", "");

			for (int g = 0; g< groupList.length ; g++){
				String groupNm = groupList[g];
				int groupIdx = -1;				
				int tmpCnt = 0;
		        while((groupIdx = rawMsg.indexOf("{"+groupNm, groupIdx + 1)) != -1) {
		        	String contentOfBrackets = rawMsg.substring(groupIdx + groupNm.length() + 1, rawMsg.indexOf("}" + groupNm, groupIdx));
		        	if( g != 3 ){
		        		rawMsg = rawMsg.replaceFirst(Pattern.quote(contentOfBrackets), "");
		        	}
					
					String cntrNo = "";
					//System.out.println("RAW : "+ contentOfBrackets);
					int beginIdx = rawMsg.indexOf("}" + groupNm, rawMsg.indexOf("{"+groupNm + "}"+groupNm) + 1) + groupNm.length() + 1;										
					if(g == 1 || g== 0){
						String tmp[] = splitString(rawMsg.substring(rawMsg.lastIndexOf("IVC_CNTRNO", beginIdx)), '\n');
						if(tmp.length > 0){
							cntrNo = tmp[0];
							cntrNo = cntrNo.replaceAll("[\n\r]", "");
							cntrNo = splitByToken(cntrNo, ":")[1];
							rawMsg = rawMsg.replace("{"+groupNm + "}"+groupNm, "");
						}
					}
					//System.out.println("C B : " + rawMsg.substring(rawMsg.indexOf("{"+groupNm + "}"+groupNm, rawMsg.indexOf("}" + groupNm, groupIdx + 1))));
					tmpCnt++;
					rcvMsgS = splitString(contentOfBrackets, '\n');
					if( rcvMsgS != null ){
						for(int k=0;k<rcvMsgS.length;k++){
							rcvMsgS[k] = rcvMsgS[k].replaceAll("[\n\r]", "");
							//System.out.println("["+rcvMsgS[k]+"]");
							if(isNull(rcvMsgS[k].trim())){
								continue;
							}
							// Column, Value 분리								
							if (rcvMsgS[k].indexOf(":") > 0) {							
								splitRcvMsg = splitByToken(rcvMsgS[k], ":");
								//System.out.println("::::::: tmpCnt : "+ tmpCnt +":::: " + g + ":::::::" +splitRcvMsg[0]);
								for(BkgHrdCdgCtntVO hrdCdg : hrdCdgList){
									if (hrdCdg.getAttrCtnt2().equals(splitRcvMsg[0])) {		
										XterRqstVO rqstVo = new XterRqstVO();
										rqstVo.setTableNm(hrdCdg.getAttrCtnt3());
										rqstVo.setColumnNm(hrdCdg.getAttrCtnt4());
					        			rqstVo.setColumnType(hrdCdg.getAttrCtnt5());	        			
					        			rqstVo.setInputValue(splitRcvMsg[1]);
					        			rqstVo.setSeq( String.valueOf(tmpCnt) );
					        			//rqstVoList.add(rqstVo);
					        			switch (g) {
										case 0:
											//sealList.add(rqstVo);
											if(cntrNo != null && !"".equals(cntrNo)){
												rqstVo = new XterRqstVO();
												rqstVo.setTableNm(hrdCdg.getAttrCtnt3());
												rqstVo.setColumnNm(hrdCdg.getAttrCtnt4());
							        			rqstVo.setSeq( String.valueOf(tmpCnt) );
												rqstVo.setColumnNm(cntrNo);	        			
							        			rqstVo.setInputValue(splitRcvMsg[1]);
							        			sealList.add(rqstVo);
							        			cntrNo = "";
											}
											break;
										case 1:
											cntrCustList.add(rqstVo);
											if(cntrNo != null && !"".equals(cntrNo)){
												rqstVo = new XterRqstVO();
												rqstVo.setTableNm(hrdCdg.getAttrCtnt3());
												//rqstVo.setColumnNm(hrdCdg.getAttrCtnt4());
							        			rqstVo.setSeq( String.valueOf(tmpCnt) );
												rqstVo.setColumnNm("CNTR_NO");	        			
							        			rqstVo.setInputValue(cntrNo);
							        			cntrCustList.add(rqstVo);
							        			cntrNo = "";
											}
											break;
										case 2:
											cntrList.add(rqstVo);
											break;
										case 3:
											vermasList.add(rqstVo);
											break;
										}
					        			break;
									}
								}
							}
							
							
						}
					}
		        }
			}
			
			Set<String> groupCount = new HashSet<String>();
			Set<String> groupCount2 = new HashSet<String>();
			List<BkgXterVrfdWgtRqstVO> rqstList = new ArrayList<BkgXterVrfdWgtRqstVO>();
			List<BkgXterVrfdWgtPtyVO> ptyList = new ArrayList<BkgXterVrfdWgtPtyVO>();
			String sndrId = "";
			String rqstNo = "";
			
			for(XterRqstVO vo : cntrList){
				groupCount.add(vo.getSeq());				
			}
			for(XterRqstVO vo : cntrCustList){
				groupCount2.add(vo.getSeq());				
			}
			
			for(int c=0; c<groupCount.size(); c++){
				BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO = new BkgXterVrfdWgtRqstVO();		
				for(XterRqstVO vo : vermasList){
					propertySet(bkgXterVrfdWgtRqstVO, vo.getColumnNm(), vo.getInputValue());
					if("XTER_VGM_RQST_NO".equals(vo.getColumnNm())){
						rqstNo = vo.getInputValue();						
					}
				}
				
				if(rcvMsg.substring(0,rcvMsg.indexOf("{I_VERMAS")).indexOf("VGMMAIL") > -1){
					bkgXterVrfdWgtRqstVO.setXterRqstViaCd("INT");
				}
				
				int hidx = rcvMsg.indexOf("$$$MSGSTART:");
				int ridx = rcvMsg.indexOf("  ");
				String contentOfBrackets = rcvMsg.substring(hidx + 12, ridx);				
		        //System.out.println(contentOfBrackets);
		        sndrId = contentOfBrackets;
		        bkgXterVrfdWgtRqstVO.setXterSndrId(contentOfBrackets);
						        
		        
		        rqstList.add(bkgXterVrfdWgtRqstVO);
				
			}
			
			for(int c2=0; c2<groupCount2.size(); c2++){ 
		        BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO = new BkgXterVrfdWgtPtyVO();	
				bkgXterVrfdWgtPtyVO.setXterSndrId(sndrId);
				bkgXterVrfdWgtPtyVO.setXterVgmRqstNo(rqstNo);
				ptyList.add(bkgXterVrfdWgtPtyVO);
			}
			
			for(XterRqstVO vo : cntrList){
				int seq = NumberUtils.toInt(vo.getSeq());
				if(rqstList.size() >= seq){
					propertySet(rqstList.get(seq - 1), vo.getColumnNm(), vo.getInputValue());								 
				}
			}
			
			for(BkgXterVrfdWgtRqstVO vo : rqstList){
				if(sealList.size() > 0){						
					StringBuilder sb = new StringBuilder();
					for(XterRqstVO item: sealList){
					    if(sb.length() > 0){
					        sb.append(',');
					    }
					    if(vo.getCntrNo().equals(item.getColumnNm())){
					    	sb.append(item.getInputValue());						
						}
					    
					}
					vo.setXterCntrSealNo(sb.toString());
				}
			}		
			
//			for(XterRqstVO vo : cntrList){
//				int seq = NumberUtils.toInt(vo.getSeq());
//			
//				for(int c=0; c<ptyList.size();c++){
//					if((seq - 1) == c){
//						propertySet(ptyList.get(c), vo.getColumnNm(), vo.getInputValue());
//						tmp = ptyList.get(c).getMaxRows();
//						if(ptyList.get(c).getMaxRows() == tmp){
//							propertySet(ptyList.get(c), vo.getColumnNm(), vo.getInputValue());
//						}
//					}
//				}
//			}
			
			
			for(XterRqstVO vo : cntrCustList){
				int seq = NumberUtils.toInt(vo.getSeq());
				if(ptyList.size() >= seq){
					propertySet(ptyList.get(seq - 1), vo.getColumnNm(), vo.getInputValue());
				}
				
				// cntr cust 가 몽땅 같은 경우 예외처리 - 앞에 값 복사
				if(groupCount.size() > groupCount2.size()){
					for(int p=seq;p < ptyList.size();p++){
						if(ptyList.get(p) != null){
							propertySet(ptyList.get(p), vo.getColumnNm(), vo.getInputValue());
						}
					}
					
				}
			}
			
			
			
			for(BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO : rqstList){
				dbDao.addBkgXterVrfdWgtRqst(bkgXterVrfdWgtRqstVO, null);
			}
			
			for(BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO : ptyList){
				dbDao.addBkgXterVrfdWgtPty(bkgXterVrfdWgtPtyVO, null);
			}			
			
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
		}
	}
    
	/**
	 * FlatFile 형태의 External Request를 bkg/doc의 data로 insert한다<br>
	 *
	 * @param String rcvMsg
	 * @return XterRqstNoVO
	 * @exception EventException
	 */
	public XterRqstNoVO receiptXterRqst(String rcvMsg) throws EventException {		
		XterRqstNoVO rqstNoVo = new XterRqstNoVO();
		try {			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("XTER_BKG_RECEIPT");
	        List<BkgHrdCdgCtntVO> hrdCdgList = searchHardCoding(bkgHrdCdgCtntListCondVO);
	        List<BkgHrdCdgCtntVO> hrdTableList = null;
	        List<XterRqstVO> rqstVoList = new ArrayList<XterRqstVO>();

	        boolean isNewTable = true;
	        String[] rcvMsgS = splitString(rcvMsg, '\n');
	        	        
			String[] splitRcvMsg = null;

			String oldTable = "";
			String newTable = null;
			int cnt = 0;

			// 입력용
			String xterRqstNo = null;
			String xterSndrId = null;
			String ffRefNo = null;
			String xterBkgNo = null;
			String xterSiNo = null;
			String xterBlNo = null;
			// 조건 분기용
			String xterBiTpCd = null;
			String xterRqstViaCd = null;
			String xterDocTpCd = null;
			//SEANACCS VSL_CD 조회용
			String xterCallSgnNo = null;
			String xterSkdVoyNo = null;
			String xterSkdDirCd = null;
			
			// BKG_XTER_CNTR_MK_DESC이면서 IBD_DESC 인경우에는 Seq를 '0'하지 않도록 하기 위한 변수
			String bkgXterCntrMkDescFlag = "N";
									 
			for(int i=0;i<rcvMsgS.length;i++) {				
				rcvMsgS[i] = remove(rcvMsgS[i], '\n');
				rcvMsgS[i] = remove(rcvMsgS[i], '\r');
				
				if(isNull(rcvMsgS[i].trim())){
					continue;
				}				
				if(0==i && rcvMsgS[i].length() > 62){
					ffRefNo = rcvMsgS[i].substring(62);
					continue;
				}
				
				if (isNewTable && "{".equals(rcvMsgS[i].substring(0, 1))) {
					newTable = rcvMsgS[i].substring(1, rcvMsgS[i].length());
					hrdTableList = searchHardCodingTableList(hrdCdgList, newTable);
					isNewTable = false;

					if (!newTable.equals(oldTable)) {
						cnt = 0;
					} else if (newTable.equals(oldTable)) {
						cnt++;
					}
				} else if ("}".equals(rcvMsgS[i].substring(0, 1))) {
					isNewTable = true;
					oldTable = rcvMsgS[i].substring(1, rcvMsgS[i].length());
				}
				
				// Column, Value 분리								
				if (rcvMsgS[i].indexOf(":") > 0) {
					splitRcvMsg = splitByToken(rcvMsgS[i], ":");
				}
				
				// 해당 그룹의 Column명 만으로 매핑
	        	if ( !"{".equals(rcvMsgS[i].substring(0, 1)) && !"}".equals(rcvMsgS[i].substring(0, 1)) ) {
	        		if(hrdTableList != null){
						for (int j=0;j<hrdTableList.size();j++) {
				        	BkgHrdCdgCtntVO hrdCdg = (BkgHrdCdgCtntVO) hrdTableList.get(j);		        		
			        		if (hrdCdg.getAttrCtnt2().equals(splitRcvMsg[0])) {
	//		        			log.debug("rcvMsgS[i] :"+rcvMsgS[i] + " / splitRcvMsg[0]:" + splitRcvMsg[0] + " / splitRcvMsg[1]:" + splitRcvMsg[1]);
			        			if ( "IB_IE_IND".equals(splitRcvMsg[0]) ) {
			        				if ( "I".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "INT";
			        				else if ( "W".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "WEB";
			        				else if ( "E".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "EDI";
			        				else if ( "C".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "CSM";
			        				else if ( "G".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "GTN";
			        				else if ( "P".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "DSK";
			        				else if ( "D".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "DAK";
			        				else if ( "S".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "SEA";
			        				else if ( "X".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "SIM";
			        				else if ( "EML".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "EML";
			        				else if ( "ULD".equals(splitRcvMsg[1]) ) splitRcvMsg[1] = "ULD"; 
			        				else splitRcvMsg[1] = "EDI";
			        				xterRqstViaCd = splitRcvMsg[1];
			        			} else if ( "IB_TP".equals(splitRcvMsg[0]) ) {
			        				xterBiTpCd = splitRcvMsg[1];
			        			} else if ( "IB_MSG_FLAG".equals(splitRcvMsg[0]) ) {
			        				xterDocTpCd = splitRcvMsg[1];
			        			} else if ( "IB_NO".equals(splitRcvMsg[0]) ) {
			        				xterRqstNo = splitRcvMsg[1];
			        			} else if ( "IB_SI_NO".equals(splitRcvMsg[0]) ) {
			        				xterSiNo = splitRcvMsg[1];
			        			} else if ( "IB_EDI_ID".equals(splitRcvMsg[0]) ) {
			        				xterSndrId = splitRcvMsg[1];
				        			if(xterSndrId.equals("DAKOSY")){
				        				xterRqstViaCd = "DAK";
				        			}
			        			} else if ( "IB_BKG_NO".equals(splitRcvMsg[0]) ) {
			        				//2011.06.10 소문자를 대문자로 변환
			        				xterBkgNo = splitRcvMsg[1].toUpperCase();
			        			} else if ( "IB_BL_NO".equals(splitRcvMsg[0]) ){
			        				xterBlNo = splitRcvMsg[1];
			        			} else if ( "IB_SKD_VOYAGE_NO".equals(splitRcvMsg[0]) ) {
			        				xterSkdVoyNo = splitRcvMsg[1];
			        			} else if ( "IB_SKD_DIR_CD".equals(splitRcvMsg[0]) ) {
			        				xterSkdDirCd = splitRcvMsg[1];
			        			} else if ( "IB_VSL_CD".equals(splitRcvMsg[0]) ) {
			        				xterCallSgnNo = splitRcvMsg[1];
			        			}		      
	//		        			if("SEA".equals(xterRqstViaCd)) {
	//		        				log.error("\n rcvMsg:"+rcvMsg);
	//		        			}
	
			        			XterRqstVO rqstVo = new XterRqstVO();
			        			rqstVo.setColumnNm(hrdCdg.getAttrCtnt4());
			        			rqstVo.setColumnType(hrdCdg.getAttrCtnt5());
			        			
			        			//[CHM-201326009] 2013.08.06 최문환
			        			//BKG_XTER_CUST의 CUST_EML과 CNTC_EML을 제외한 모든항목을 대문자로 변환함
			        			if(hrdCdg.getAttrCtnt3().equals("BKG_XTER_CUST")){
			        				if(hrdCdg.getAttrCtnt4().equals("CNTC_EML") || hrdCdg.getAttrCtnt4().equals("CUST_EML")){
			        					rqstVo.setInputValue(splitRcvMsg[1]);
			        				}else{
			        					rqstVo.setInputValue(splitRcvMsg[1].toUpperCase());
			        				}		        				
			        			}else if (hrdCdg.getAttrCtnt3().equals("BKG_XTER_RQST_MST")){
			        				if(hrdCdg.getAttrCtnt4().equals("BKG_OFC_CD") || hrdCdg.getAttrCtnt4().equals("SLS_OFC_CD")){
			        					
			        					BookingUtil util = new BookingUtil();
			        					BkgHrdCdgCtntListCondVO hrdCdgCtnt = new BkgHrdCdgCtntListCondVO();
			        					hrdCdgCtnt.setHrdCdgId("XTER_OFC_MAP_CTRL");			
			        					List<BkgHrdCdgCtntVO> ofcMap = util.searchHardCoding(hrdCdgCtnt);					
			        					
			        					if(ofcMap != null && ofcMap.get(0).getAttrCtnt1().equals("ON")){
			        						String newOfcCd = dbDao.searchNewOfcCd(splitRcvMsg[1]);
			        						if(newOfcCd!=null && !"".equals(newOfcCd)){
			        							rqstVo.setInputValue(newOfcCd);
			        						} else {
			        							rqstVo.setInputValue(splitRcvMsg[1]);
			        						}
			        					} else {
			        						rqstVo.setInputValue(splitRcvMsg[1]);
			        					}			        					
			        				} else{
			        					rqstVo.setInputValue(splitRcvMsg[1]);
			        				}
			        			}else{			
			        				rqstVo.setInputValue(splitRcvMsg[1]);
			        			}
	//		        			rqstVo.setInputValue(splitRcvMsg[1]);
			        			rqstVo.setSeq( (("N".equals(bkgXterCntrMkDescFlag) && "IBD_DESC".equals(splitRcvMsg[0])) || "IBM_MARK".equals(splitRcvMsg[0]) || "IBEM_MISC".equals(splitRcvMsg[0]))?"0":String.valueOf(cnt) );
			        			rqstVo.setTableNm(hrdCdg.getAttrCtnt3());
			        			rqstVoList.add(rqstVo);
			        		}
			        	}
	        		}
				} else {
					if ( 15 == rcvMsgS[i].length()) {
						if ( "{I_CM_MARK_DESC".equals(rcvMsgS[i].substring(0, 15)) ) {
							bkgXterCntrMkDescFlag = "Y";
						} else if ( "}I_CM_MARK_DESC".equals(rcvMsgS[i].substring(0, 15)) ) {
							bkgXterCntrMkDescFlag = "N";
						}
					}
				}
			}
			
			rqstNoVo.setRqstNo(xterRqstNo);
			rqstNoVo.setSenderId(xterSndrId);
			
			if ( xterBkgNo != null && xterBkgNo.length() > 13 ) {
//				log.debug("xterBkgNo.substring(0, 4):" + xterBkgNo.substring(0, 4) );
//				if ( "HJSC".equals(xterBkgNo.substring(0, 4))) {
//					xterBkgNo = xterBkgNo.substring(4, xterBkgNo.length());
//				} else
				
				if ("SMLM".equals(xterBkgNo.substring(0,4))){
					xterBkgNo = xterBkgNo.substring(4);
				}
				if ( StringUtils.containsNone(xterBkgNo.substring(xterBkgNo.length()-2, xterBkgNo.length()-1), "0123456789") ) {
					xterBkgNo = xterBkgNo.substring(0, xterBkgNo.length()-2);
				}
				
				if ( xterBkgNo.length() != 12 ) {
					xterBkgNo = "";
				}
			}
			if(xterBlNo != null && !"".equals(xterBlNo) && 4<=xterBlNo.length()){
				if ("SMLM".equals(xterBlNo.substring(0,4))){
					xterBlNo = xterBlNo.substring(4);
				}				
			}
			rqstNoVo.setBkgNo(xterBkgNo);
			rqstNoVo.setBlNoCtnt(xterBlNo);
			// DB입력용 Columns, Value 매핑
			if ( !"E".equals(xterDocTpCd) || xterDocTpCd == null ) {
				String[][] val_BKG_XTER_RQST_MST = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RQST_MST");
				val_BKG_XTER_RQST_MST = concateDescValue(val_BKG_XTER_RQST_MST);
				String[][] val_BKG_XTER_RQST_MISC = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RQST_MISC");
				String[][] val_BKG_XTER_INSTR = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_INSTR");
				String[][] val_BKG_XTER_RQST_CNG = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RQST_CNG");
				String[][] val_BKG_XTER_CNTR = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CNTR");
				String[][] val_BKG_XTER_CNTR_SEAL_NO = searchCntrSealNoList(rcvMsgS, hrdCdgList, val_BKG_XTER_CNTR);
				String[][] val_BKG_XTER_CUST = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CUST");
				String[][] val_BKG_XTER_XPT_LIC_NO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_XPT_LIC_NO");
				String[][] val_BKG_XTER_QTY = searchXterQtyList(rcvMsgS, hrdCdgList);
				String[][] val_BKG_XTER_DG_CGO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_DG_CGO");
				String[][] val_BKG_XTER_AWK_CGO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_AWK_CGO");
				String[][] val_BKG_XTER_RF_CGO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_RF_CGO");
				String[][] val_BKG_XTER_CNTR_MK_DESC = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CNTR_MK_DESC");
				String[][] val_BKG_XTER_TRO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_TRO");
				String[][] val_BKG_XTER_TRO_DTL = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_TRO_DTL");
				String[][] val_BKG_XTER_AES = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_AES");
				String[][] val_BKG_XTER_TMP_BL_MK_DESC = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_TMP_BL_MK_DESC");
				String[][] val_BKG_XTER_CAED = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_CAED");
				
				//CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
				String[][] val_BKG_XTER_REF_DTL = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_REF_DTL");
					
				String [] gdsDesc = new String[2];
				String [] mkDesc = new String[2];
				String [] newVal = new String[2];
				String vslCd = null;
				BookingUtil bcUtil = new BookingUtil();
				for(int i=0;i<val_BKG_XTER_RQST_MST.length;i++){
					for(int j=0;j<val_BKG_XTER_RQST_MST[i].length;j++){					
						if(val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].length()> 10 
								&& val_BKG_XTER_RQST_MST[i][j].substring(0,10).equals("N_GDS_DESC")){
							gdsDesc = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
							val_BKG_XTER_RQST_MST[i][j] = ":";
						} else if(val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].length()> 9 
								&& val_BKG_XTER_RQST_MST[i][j].substring(0,9).equals("N_MK_DESC")){
							mkDesc = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
							val_BKG_XTER_RQST_MST[i][j] = ":";
						} else {
							/******************************************************
							 * 2010-07-07 [CHM-201004482] EI 300 UPLOAD를 위한 로직보완
							 ******************************************************/
							if (!"SEANACCS".equals(xterSndrId)) {
								
								int callSignLen = 0;
								if( xterCallSgnNo != null ){
									callSignLen = xterCallSgnNo.length();
								}
								
								if (val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].indexOf("N_VSL_CD") >= 0 && callSignLen == 7) {
									newVal = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
									vslCd = bcUtil.searchVslCdByLloydNo(xterCallSgnNo, xterSkdVoyNo, xterSkdDirCd);
									if (vslCd == null)
										vslCd = "    ";
									val_BKG_XTER_RQST_MST[i][j] = newVal[0] + ":" + vslCd;
								}
							} else {
//							if( "SEANACCS".equals(xterSndrId) ) {
								if(val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].length()> 8
										&& val_BKG_XTER_RQST_MST[i][j].substring(0,8).equals("N_VSL_CD")){
									newVal = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
									vslCd = dbDao.searchXterVslCd(xterCallSgnNo, xterSkdVoyNo, xterSkdDirCd);
									if ( vslCd != null ){
										val_BKG_XTER_RQST_MST[i][j] = newVal[0]+":"+vslCd;
									} else {
										val_BKG_XTER_RQST_MST[i][j] = newVal[0]+":    ";
									}
								} 
							}
						}
					}				
				}
	
				newVal = null;
				for(int i=0;i<val_BKG_XTER_TMP_BL_MK_DESC.length;i++){
					for(int j=0;j<val_BKG_XTER_TMP_BL_MK_DESC[i].length;j++){
						if(val_BKG_XTER_TMP_BL_MK_DESC[i][j] != null  && val_BKG_XTER_TMP_BL_MK_DESC[i][j].length()> 13
								&& val_BKG_XTER_TMP_BL_MK_DESC[i][j].substring(0,13).equals("N_TTL_PCK_LVL")){
							newVal = splitByToken(val_BKG_XTER_TMP_BL_MK_DESC[i][j], ":");
							/* StringUtils.containsNone - 변수, check할 값을 입력 : */
							if ( !StringUtils.containsOnly(newVal[1], "0123456789") ) {
								val_BKG_XTER_TMP_BL_MK_DESC[i][j] = ":";
							}
						}
					}
				}
				
				if ( isNull(xterBiTpCd) || !"H".equals(replaceNull(xterBiTpCd)) ) {
					rqstNoVo = dbDao.searchXterRqstMstSeq(xterSndrId, xterRqstNo, xterDocTpCd);
				} else if ( "H".equals(replaceNull(xterBiTpCd)) ) {					
					
					rqstNoVo = dbDao.searchXterHblSeq(rqstNoVo, xterRqstViaCd, xterSiNo, xterDocTpCd);
					
					BookingUtil util = new BookingUtil();
					BkgHrdCdgCtntListCondVO hrdCdgCtnt = new BkgHrdCdgCtntListCondVO();
					hrdCdgCtnt.setHrdCdgId("EBKG_HBL");			
					List<BkgHrdCdgCtntVO> hbl = util.searchHardCoding(hrdCdgCtnt);					
					if(hbl != null && hbl.get(0).getAttrCtnt1().equals("ON")){
						//20150413 CHM-201535059 PANTOS HBL수신 시 HBL이 재수신되어도 UPLOAD될 수 있게 로직 추가/변경
						
						rqstNoVo.setRqstNo(xterRqstNo);
						rqstNoVo.setSenderId(xterSndrId);
						rqstNoVo.setBkgNo(xterBkgNo);						
						
						Integer hblCnt= dbDao.searchXterHblDup(rqstNoVo, xterSiNo, xterDocTpCd);
						
						if(hblCnt>0){
							return null;
						}
						
						xterRqstNo = dbDao.searchXterHblRqstNo(rqstNoVo);
						
						//house b/l dup을 피하기 위해 H로 추가						
						//xterRqstNo = xterRqstNo + "H";
					}
					
					// HBl인 경우 기존 rqst_no를 리턴
					rqstNoVo.setRqstNo(xterRqstNo);
				}
				
				if(rqstNoVo.getRqstSeq().length()>3){
					return null;
				}
				
				rqstNoVo.setRqstNo(xterRqstNo);
				rqstNoVo.setSenderId(xterSndrId);
				rqstNoVo.setBkgNo(xterBkgNo);
				rqstNoVo.setBlNoCtnt(xterBlNo);
				rqstNoVo.setFfRefNo(ffRefNo);
				rqstNoVo.setSiNo(xterSiNo);
				rqstNoVo.setXterBlTpCd(xterBiTpCd);
				rqstNoVo.setDocTpCd(xterDocTpCd);
	
				log.debug("xterRqstViaCd:"+replaceNull(xterRqstViaCd));
				log.debug("xterDocTpCd:"+replaceNull(xterDocTpCd));
				log.debug("xterSndrId:"+replaceNull(xterSndrId));
				log.debug("xterRqstNo:"+replaceNull(xterRqstNo));
				log.debug("xterRqstSeq:"+replaceNull(rqstNoVo.getRqstSeq()));
				log.debug("ffRefNo:"+replaceNull(rqstNoVo.getFfRefNo()));
				log.debug("xterBiTpCd:"+replaceNull(xterBiTpCd));
				log.debug("xterBkgNo:"+replaceNull(rqstNoVo.getBkgNo()));
				log.debug("xterBlNo:"+replaceNull(rqstNoVo.getBlNoCtnt()));
				
				if ( "H".equals(replaceNull(xterBiTpCd))) {
					if (((isNull(rqstNoVo.getBkgNo())?0:rqstNoVo.getBkgNo().length()) < 11 )) {
						XterRqstNoVO rqstNoTmpVo = new XterRqstNoVO();
						rqstNoTmpVo = dbDao.searchXterBkgNo(rqstNoVo);
						if ( rqstNoTmpVo != null ) {
							rqstNoVo.setBkgNo(rqstNoTmpVo.getBkgNo());
						}
					}
				} else {				
					if ( Integer.parseInt((isNull(rqstNoVo.getRqstSeq()))?"0":rqstNoVo.getRqstSeq()) > 1 
						&& ((isNull(rqstNoVo.getBkgNo())?0:rqstNoVo.getBkgNo().length()) < 11 )) {
		//					&& (isNull(rqstNoVo.getBkgNo()) 
		//							&& rqstNoVo.getBkgNo().length() < 11) ) {
						XterRqstNoVO rqstNoTmpVo = new XterRqstNoVO();
						rqstNoTmpVo = dbDao.searchXterBkgNo(rqstNoVo);
						if ( rqstNoTmpVo != null ) {
							rqstNoVo.setBkgNo(rqstNoTmpVo.getBkgNo());
						}
					}
				}
				
				if ( "GTN".equals(xterRqstViaCd) && "S".equals(xterDocTpCd) ) {
					String[] xterRqstNoHbi = dbDao.searchXterHblCount(rqstNoVo);
					XterRqstNoVO xterHblNo = new XterRqstNoVO();
					xterHblNo.setRqstNo(xterRqstNo);
					xterHblNo.setSenderId(xterSndrId);
	
					for (int i=0;i<xterRqstNoHbi.length;i++) {
						xterHblNo.setRqstSeq(xterRqstNoHbi[i]);
						dbDao.copyBkgXterRqstMst(xterHblNo);
						dbDao.copyBkgXterCust(xterHblNo);
						dbDao.copyBkgXterCntr(xterHblNo);
						dbDao.copyBkgXterCntrSealNo(xterHblNo);
						dbDao.copyBkgXterCntrMkDesc(xterHblNo);
					}
				}
				/* ----- Start ----- */
				String sigCtnt = "";	
				for (int i=0;i<val_BKG_XTER_CUST.length;i++){
					for (int j=0;j<val_BKG_XTER_CUST[i].length;j++){
						if(val_BKG_XTER_CUST[i][j] != null && val_BKG_XTER_CUST[i][j].indexOf("R1") > -1){
							for (int k=0;k<val_BKG_XTER_CUST[i].length;k++){
								if(val_BKG_XTER_CUST[i][k] != null && val_BKG_XTER_CUST[i][k].indexOf("CNTC_NM") > -1){
									sigCtnt = val_BKG_XTER_CUST[i][k].replace("N_CNTC_NM:", "");
									break;
								}
							}
							break;
						}
					}
				}
				
				dbDao.addBkgXterRqstMst(rqstNoVo, val_BKG_XTER_RQST_MST[0]);
				if(val_BKG_XTER_RQST_MISC.length>0)
					dbDao.addBkgXterRqstMisc(rqstNoVo, val_BKG_XTER_RQST_MISC[0]);
				if(val_BKG_XTER_INSTR.length>0)
					dbDao.addBkgXterInstr(rqstNoVo, val_BKG_XTER_INSTR[0]);
				if(val_BKG_XTER_RQST_CNG.length>0)
					dbDao.addBkgXterRqstCng(rqstNoVo, val_BKG_XTER_RQST_CNG[0]);
				for (int i=0;i<val_BKG_XTER_QTY.length;i++)
					dbDao.addBkgXterQty(rqstNoVo, val_BKG_XTER_QTY[i]);
	
				if(val_BKG_XTER_CNTR != null){
					for (int i=0;i<val_BKG_XTER_CNTR.length;i++){
						String[] arr = null;
						for (int j=0;j<val_BKG_XTER_CNTR[i].length;j++){
							if(val_BKG_XTER_CNTR[i][j] != null && val_BKG_XTER_CNTR[i][j].indexOf("@VGM@") > -1){
								arr = val_BKG_XTER_CNTR[i][j].split("@VGM@");
								val_BKG_XTER_CNTR[i][j] = arr[0];
								break;
							}
						}
						for (int j=0;j<val_BKG_XTER_CNTR[i].length;j++){
							boolean isFound = false;
							if(val_BKG_XTER_CNTR[i][j] != null && val_BKG_XTER_CNTR[i][j].indexOf("VGM_VRFY_SIG_CTNT") > -1){
								isFound = true;
								break;
							}
							if(!isFound && val_BKG_XTER_CNTR[i][j] == null){
								if(StringUtils.isEmpty(sigCtnt) && arr != null && arr.length > 1){
									sigCtnt = arr[1];
								}
								val_BKG_XTER_CNTR[i][j] = "N_VGM_VRFY_SIG_CTNT:" + sigCtnt;
								//sigCtnt = "";
								break;
							}
						}
						dbDao.addBkgXterCntr(rqstNoVo, val_BKG_XTER_CNTR[i]);
					}
					
				}
				
				if(val_BKG_XTER_CNTR_MK_DESC != null)
					for (int i=0;i<val_BKG_XTER_CNTR_MK_DESC.length;i++){
						for (int j=0;j<val_BKG_XTER_CNTR_MK_DESC[i].length;j++){
							log.debug("val_BKG_XTER_CNTR_MK_DESC[i][j]:"+val_BKG_XTER_CNTR_MK_DESC[i][j]);
						}
						for (int j=0;j<val_BKG_XTER_CNTR_MK_DESC[i].length;j++){
							if(val_BKG_XTER_CNTR_MK_DESC[i][j] != null && val_BKG_XTER_CNTR_MK_DESC[i][j].length()>14){
								if(val_BKG_XTER_CNTR_MK_DESC[i][j].substring(0, 13).equals("N_MK_DESC_SEQ")){
									dbDao.addBkgXterCntrMkDesc(rqstNoVo, val_BKG_XTER_CNTR_MK_DESC[i]);
									break;
								}
							}	
						}
					}
					
				if(val_BKG_XTER_CNTR_SEAL_NO != null)
					for (int i=0;i<val_BKG_XTER_CNTR_SEAL_NO.length;i++){
						for(int j=0;j<val_BKG_XTER_CNTR_SEAL_NO[i].length;j++){
							//seal no가 있어야만 insert한다.
							if(val_BKG_XTER_CNTR_SEAL_NO[i][j] != null && val_BKG_XTER_CNTR_SEAL_NO[i][j].length()>19){
								if(val_BKG_XTER_CNTR_SEAL_NO[i][j].substring(0, 19).equals("N_XTER_CNTR_SEAL_NO")){
									dbDao.addBkgXterCntrSealNo(rqstNoVo, val_BKG_XTER_CNTR_SEAL_NO[i]);
									break;
								}
							}
						}	
					}					
				for (int i=0;i<val_BKG_XTER_CUST.length;i++){
					dbDao.addBkgXterCust(rqstNoVo, val_BKG_XTER_CUST[i]);
					if ( rqstNoVo!=null && rqstNoVo.getSenderId()!=null && ( rqstNoVo.getSenderId().equals("EXCEL") || rqstNoVo.getSenderId().equals("EML") ) ){ /// 2011.07.07
						dbDao.modifyXterCustForSimpleSi(rqstNoVo, null);
					}
				}
				for (int i=0;i<val_BKG_XTER_XPT_LIC_NO.length;i++)
					dbDao.addBkgXterXptLicNo(rqstNoVo, val_BKG_XTER_XPT_LIC_NO[i]);
				for (int i=0;i<val_BKG_XTER_DG_CGO.length;i++)
					dbDao.addBkgXterDgCgo(rqstNoVo, val_BKG_XTER_DG_CGO[i]);
				for (int i=0;i<val_BKG_XTER_AWK_CGO.length;i++)
					dbDao.addBkgXterAwkCgo(rqstNoVo, val_BKG_XTER_AWK_CGO[i]);
				for (int i=0;i<val_BKG_XTER_RF_CGO.length;i++)
					dbDao.addBkgXterRfCgo(rqstNoVo, val_BKG_XTER_RF_CGO[i]);
				for (int i=0;i<val_BKG_XTER_TRO.length;i++)
					dbDao.addBkgXterTro(rqstNoVo, val_BKG_XTER_TRO[i]);
				for (int i=0;i<val_BKG_XTER_TRO_DTL.length;i++)
					dbDao.addBkgXterTroDtl(rqstNoVo, val_BKG_XTER_TRO_DTL[i]);
				for (int i=0;i<val_BKG_XTER_AES.length;i++)
					dbDao.addBkgXterAes(rqstNoVo, val_BKG_XTER_AES[i]);				
					
					//CHM-201536544 PHXSC BBC 미팅 - SI 접수시 AES No.와 같이 들어온 경우 AES NO. AUTO UPLOAD 요청
				if(val_BKG_XTER_AES.length >0 && "S".equals(xterDocTpCd)){
					dbDao.addBkgAes(rqstNoVo);			
				}
				
				for (int i=0;i<val_BKG_XTER_TMP_BL_MK_DESC.length;i++)
					dbDao.addBkgXterTmpBlMkDesc(rqstNoVo, val_BKG_XTER_TMP_BL_MK_DESC[i]);
				for (int i=0;i<val_BKG_XTER_CAED.length;i++)
					dbDao.addBkgXterCaed(rqstNoVo, val_BKG_XTER_CAED[i]);
				
				//CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
				for (int i=0;i<val_BKG_XTER_REF_DTL.length;i++)
					dbDao.addBkgXterRefDtl(rqstNoVo, val_BKG_XTER_REF_DTL[i]);
				/* ----- End ----- */

				dbDao.updateBkgXterXptLicNo(rqstNoVo);
				// insert한 data를 기준으로 handling office, rqst_dt, desc를 update한다.
				// clob type이 insert가 안되서 update로 변경
				dbDao.modifyHandlingOfc(rqstNoVo, gdsDesc[1], mkDesc[1]);
				
				//2014.11.03 최도순[CHM-201432379] 미주 E-BKG HANDLING OFFICE 지정로직 UPload 시점으로 변경
				/*
				if(rqstNoVo.getBkgNo() == null || "".equals(rqstNoVo.getBkgNo())){
					BookingUtil util = new BookingUtil();
					
					String ofcCd = dbDao.searchUsHandlingOfc(rqstNoVo);
					
					log.debug("ofcCd=============="+ofcCd);
					if(ofcCd != null && !"".equals(ofcCd)){
						BkgBlNoVO bkgBlNoVO = util.manageBkgNumberGeneration("BKG", ofcCd, "SYSTEM");
						
						log.debug("bkgNo=============="+bkgBlNoVO.getBkgNo());
						
						rqstNoVo.setBkgNo(bkgBlNoVO.getBkgNo()+ "00");
						dbDao.modifyXterBkgNo(rqstNoVo);
					}
				}
				*/
				
				// 성공으로 e-svc에 i/f(EAI 전송 : EDI001_0001) no error로 전송
//				sendErrMsgToEsvc("NU", "", rqstNoVo);
				
				// 담당 office에 notice
				// batch로 넘김
//				String emailAddress[] = dbDao.searchXterRqstNoticeOfc(rqstNoVo);
//				String xterShprNm = dbDao.searchXterShprNm(rqstNoVo);
//				rqstNoVo.setXterShprNm(xterShprNm);
//				for(int i = 0; i < emailAddress.length; i++){
//					eaiDao.sendXterRqstNotice(emailAddress[i], rqstNoVo);
//				}
	
	/**********************************************************
	// 			bkg no 자동 채번 대상인지 확인한다. 
	//			1. 삼성전자 Booking Request의 경우, 자동으로 Booking Confirmation 문서를 생성한다.
	//          2. 범한물류 Shipping Instructions(Master,seq1)의 경우, 자동으로 Booking Number를 생성한다.
	**********************************************************/
	//			if(rqstNoVo.getRqstSeq().equals("1")){
	//				if(rqstNoVo.getSenderId().equals("PKEXM010") && !"H".equals(replaceNull(xterBiTpCd))){
	//					BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO2 = new BkgHrdCdgCtntListCondVO();
	//					bkgHrdCdgCtntListCondVO2.setHrdCdgId("XTER_AUTO_BKG_NO");
	//					bkgHrdCdgCtntListCondVO2.setAttrCtnt1(rqstNoVo.getSenderId());
	//					bkgHrdCdgCtntListCondVO2.setAttrCtnt2(xterDocTpCd);
	//					List<BkgHrdCdgCtntVO> bkgNoAssign = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO2);
	//					if(bkgNoAssign.size() > 0){
	//						if(rqstNoVo.getSenderId().equals("PKEXM010") && !"H".equals(replaceNull(xterBiTpCd)) && rqstNoVo.getRqstSeq().equals("1")){
	//							return rqstNoVo;
	////						} else if(!rqstNoVo.getSenderId().equals("PKEXM010") && rqstNoVo.getRqstSeq().equals("1")) {
	//						} else if(!rqstNoVo.getSenderId().equals("PKEXM010") ) {
	//							return rqstNoVo;
	//						} else {
	////							return null;
	//							// DPCS IF 를 위해 임시로 무조건 rqstNoVo 를 넘김. 2010.1.19 전창현.
	//							return rqstNoVo;
	//						}
	//					}
	//				} else {
	//					//PKEXM010에서 보낸 rqst가 SI이면서(sql 대상 table에  반영됨) house b/l이 아니면 그대로 진행
	//					return null;
	//				}
	//			}
	//			return null;
				// DPCS IF 를 위해 임시로 무조건 rqstNoVo 를 넘김. 2010.1.19 전창현.
			} else {
				// ELNO 저장 로직
				String[][] val_BKG_XTER_XPT_LIC_NO = searchColVal(rqstVoList, hrdCdgList, "BKG_XTER_XPT_LIC_NO");				

				rqstNoVo = dbDao.searchXterRqstMstSeq(xterSndrId, xterRqstNo, xterDocTpCd);
				rqstNoVo.setRqstNo(xterRqstNo);
				rqstNoVo.setSenderId(xterSndrId);
				rqstNoVo.setBkgNo(xterBkgNo);
				rqstNoVo.setFfRefNo(ffRefNo);
				rqstNoVo.setSiNo(xterSiNo);
				rqstNoVo.setXterBlTpCd(xterBiTpCd);
				rqstNoVo.setDocTpCd(xterDocTpCd);
				
				for (int i=0;i<val_BKG_XTER_XPT_LIC_NO.length;i++)
					dbDao.addBkgXterXptLicNo(rqstNoVo, val_BKG_XTER_XPT_LIC_NO[i]);
				
				dbDao.updateBkgXterXptLicNo(rqstNoVo);
			}
			
			checkBkgBlackList(rqstNoVo);
			
			return rqstNoVo;
		} catch(DAOException ex) {
			sendErrMsgToEsvc("NU", ex.getMessage(), rqstNoVo);
			sendErrLogMail( ex.getMessage().toString(), rcvMsg);
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch(Exception ex) {
        	sendErrMsgToEsvc("NU", ex.getCause().toString(), rqstNoVo);
			sendErrLogMail( ex.getCause().toString(), rcvMsg);
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
		}
	}
	/**
	 * e-svc로 발생한 err에 대해 eai로 전송한다.<BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param XterRqstNoVO xterRqstNoVO
	 */
	public void sendErrMsgToEsvc(String eaiIfTp, String eaiIfMsg, XterRqstNoVO xterRqstNoVO) {
		// error에 대한 추가 처리이므호 exception을 throw하지 않음
		try{
			if(xterRqstNoVO.getSenderId() != "WEB" && xterRqstNoVO.getSenderId() != "EXCEL" ){
				ErrMsgToEsvcVO errMsgToEsvcVO = dbDao.searchErrMsgToEsvc(eaiIfTp, eaiIfMsg, xterRqstNoVO);
				
				if(errMsgToEsvcVO != null){
					log.debug("조회 성공 여부 : "+errMsgToEsvcVO.getEaiDt());				
					eaiDao.sendErrMsgToEsvc(errMsgToEsvcVO, xterRqstNoVO);
				}
			}
		} catch(DAOException de) {
        	log.error(de.getMessage(),de);
		} catch (Exception ex) {
        	log.error(ex.getMessage(),ex);
		}
	}
	/**
	 * ebkg 담당자에게 발생한 err에 대해 g/w mail로 전송한다.<br>
	 * @param String errStr
	 * @param String flatFileStr
	 */
	public void sendErrLogMail(String errStr, String flatFileStr) {
		try{
			errStr = dbDao.searchErrMsgForMail(errStr);
			eaiDao.sendErrLogMail(errStr, flatFileStr);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
		}
	}
	/**
	 * 해당 테이블의 컬럼과 입력값 리턴<br>
	 *  MQ 연동<br>
	 *
	 * @param List<XterRqstVO> rqstVoList
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String tableNm
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] searchColVal(List<XterRqstVO> rqstVoList, List<BkgHrdCdgCtntVO> hrdList, String tableNm) throws EventException, DAOException {
		String[][] retVal = null;
        List<XterRqstVO> rqstTabList = null;
		int tmpSeq = 0;
		int saveSeq = 0;
		String oldCol = null;
		String colValue = null;
		XterRqstVO rqstTabVo = null;
		try {
	        rqstTabList = new ArrayList<XterRqstVO>();
			for (int i=0;i<rqstVoList.size();i++) {
				XterRqstVO rqstVos = (XterRqstVO) rqstVoList.get(i);
				if ( tableNm.equals(rqstVos.getTableNm()) ) {
					if (Integer.parseInt(rqstVos.getSeq()) > tmpSeq) tmpSeq = Integer.parseInt(rqstVos.getSeq());
					rqstTabList.add(rqstVos);
				}
			}
	
			if (rqstTabList.size() > 0) {
				tmpSeq = tmpSeq + 1; // 배열은 1 더 크므로
				retVal = new String[tmpSeq][searchColumnSize(hrdList, tableNm)];
			} else retVal = new String[0][0];
	
			if (rqstTabList != null && rqstTabList.size() > 0) {
	
				int i = 0;
				String oldMkSeq = "";
				for (int j=0;j<((tmpSeq == 0)?1:tmpSeq);j++) {					
					for (int k=0;k<rqstTabList.size();k++) {
						if (k > 0) oldCol = rqstTabList.get(k-1).getColumnNm();
						rqstTabVo = (XterRqstVO) rqstTabList.get(k);
	
						if (Integer.parseInt(rqstTabVo.getSeq()) == j) {
							colValue = rqstTabVo.getInputValue();
	
// Start : 테스트를 위해 임시로 substring함. - 2009-09-28
							if (rqstTabVo.getColumnNm().length() > 1 && "CNTR_VENT_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 1) colValue = rqstTabVo.getInputValue().substring(0, 1);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CSTMS_CMDT_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 6) colValue = rqstTabVo.getInputValue().substring(0, 6);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "BKG_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 13) colValue = rqstTabVo.getInputValue().substring(0, 13);
							} else if (rqstTabVo.getColumnNm().length() > 1 && ("VSL_CD".equals(rqstTabVo.getColumnNm()) || "SKD_VOY_NO".equals(rqstTabVo.getColumnNm()))) {
								if (rqstTabVo.getInputValue().length() > 4) colValue = rqstTabVo.getInputValue().substring(0, 4);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CSTMS_CMDT_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 6) colValue = rqstTabVo.getInputValue().substring(0, 6);
							} else if (rqstTabVo.getColumnNm().length() > 1 && ("POD_CD".equals(rqstTabVo.getColumnNm()) || "DEL_CD".equals(rqstTabVo.getColumnNm()))) {
								if (rqstTabVo.getInputValue().length() > 5) colValue = rqstTabVo.getInputValue().substring(0, 5);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "TWN_SO_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 4) colValue = rqstTabVo.getInputValue().substring(0, 4);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CNTR_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() < 1) colValue = "No Data";
							} else if (rqstTabVo.getColumnNm().length() > 1 && "MK_SUB_SEQ".equals(rqstTabVo.getColumnNm()) ) {
//								colValue = String.valueOf(j+1);
								colValue = String.valueOf(++i);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "MK_SEQ".equals(rqstTabVo.getColumnNm()) ) {
								if ( j == 0 ) {
									oldMkSeq = colValue.trim();
								} else if ( !(oldMkSeq.trim()).equals(colValue.trim())){
									i = 0;
									oldMkSeq = colValue.trim();
								}
							} else if (rqstTabVo.getColumnNm().length() > 1 && "CNTR_TPSZ_CD".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() < 1) colValue = "ZZ";
							} else if (rqstTabVo.getColumnNm().length() > 1 && "EORI_NO".equals(rqstTabVo.getColumnNm())) {
								if (rqstTabVo.getInputValue().length() > 20) colValue = rqstTabVo.getInputValue().substring(0, 20);
							} else if (rqstTabVo.getColumnNm().length() > 1 && "TTL_PCK_QTY".equals(rqstTabVo.getColumnNm())) {
								if ( !StringUtils.containsOnly(colValue, "0123456789.") ) {
									colValue = "0";
								}
							}
							// End : 테스트를 위해 임시로 substring함. - 2009-09-28
							//log.debug("name:"+rqstTabVo.getColumnNm() + " col:"+colValue);
							// 숫자 column이 숫자로 입력되지 않으면 "0"으로 치환
							if(rqstTabVo.getColumnNm().length()> 4){							
								if (rqstTabVo.getColumnNm().substring(rqstTabVo.getColumnNm().length() - 3).equals("QTY")
										|| rqstTabVo.getColumnNm().substring(rqstTabVo.getColumnNm().length() - 3).equals("WGT")
										|| rqstTabVo.getColumnNm().equals("CUST_SEQ")){
									if (colValue.replace(",", ".") == null || colValue.replace(",", ".").trim().equals("")) {
										colValue = "0";
									}
									else {
										colValue = "" + Double.parseDouble(colValue.replace(",", "."));
									}
/*									try {							
										colValue = ""+Double.parseDouble(colValue.replace(",", "."));
									} catch (Exception ex){
										colValue = "0";
									}*/
								}
							}
	
							if (!"BKG_NO".equals(rqstTabVo.getColumnNm())&&!"BL_NO_CTNT".equals(rqstTabVo.getColumnNm())) {
								if ( saveSeq > 0 && rqstTabVo.getColumnNm().equals(oldCol) ) {
									retVal[j][saveSeq-1] = retVal[j][saveSeq-1] + "\r\n" + colValue;
								} else {
									retVal[j][saveSeq] = (("DATE".equals(rqstTabVo.getColumnType()))?"D_":"N_")+rqstTabVo.getColumnNm()+":"+colValue;
									saveSeq++;
								}
							}
						}
					}
	
					saveSeq = 0;
				}
			}
        } catch (Exception ex) {
        	log.debug(ex.toString());
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retVal;
	}

	/**
	 * BKG_XTER_QTY 테이블의 Qty 정보 리턴<br>
	 *  MQ 연동<br>
	 *
	 * @param String[] rcvMsgS
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] searchXterQtyList(String[] rcvMsgS, List<BkgHrdCdgCtntVO> hrdList) throws EventException {
		String[][] retVal = null;
        List<XterRqstVO> rqstVoList = null;
		ArrayList<String> qtyIdArr = null;
		ArrayList<String> cnrtCd = null;
		String[] splitRcvMsg = null;
		boolean startFlg = false;
		int qtySeq = 0;
		XterRqstVO rqstVo = null;
		HashSet<String> hs = null;
		Iterator<String> it = null;
		XterRqstVO rqstQtyVo = null;
		try {
			retVal = null;
	        rqstVoList = new ArrayList<XterRqstVO>();
			qtyIdArr = new ArrayList<String>();
			cnrtCd = new ArrayList<String>();
			splitRcvMsg = null;
			startFlg = false;
			qtySeq = 0;

			for(int i=1;i<rcvMsgS.length;i++) {
				rcvMsgS[i] = remove(rcvMsgS[i], '\n');
	
				if ( "{I_BKG_QTY".equals(rcvMsgS[i]) ) {
					startFlg = true;
					qtySeq++;
				} else if ( "}I_BKG_QTY".equals(rcvMsgS[i]) ) {
					startFlg = false;
				}
	
				if ( startFlg ) {
					if ( !"{".equals(rcvMsgS[i].substring(0, 1)) && !"}".equals(rcvMsgS[i].substring(0, 1)) ) {
						splitRcvMsg = splitByToken(rcvMsgS[i], ":");
	
	        			rqstVo = new XterRqstVO();
	        			rqstVo.setSeq(String.valueOf(qtySeq-1));
	        			rqstVo.setColumnNm(splitRcvMsg[0]);
	        			rqstVo.setInputValue(splitRcvMsg[1]);
	        			rqstVoList.add(rqstVo);
	
	        			if ( "CNTRTS_CD".equals(splitRcvMsg[0]) ) {
	        				if ( splitRcvMsg[1].length() > 0 ) {
	        					qtyIdArr.add(splitRcvMsg[1]);
	        				} else {
	        					qtyIdArr.add("ZZ");
	        				}
	        					
	        			}
	
					}
				}
			}
			// 컨테이너 TP_SZ 코드 Unique화  D1 D1 -> D1으로
			hs = new HashSet<String>(qtyIdArr);
			it = hs.iterator();
			while(it.hasNext()){
				cnrtCd.add(it.next().toString());
			}
	
			retVal = new String[cnrtCd.size()][searchColumnSize(hrdList, "BKG_XTER_QTY")];
	
			double qtySum = 0;
			String subCntrTsCd = null; ///2011.05.24
			double subQtySum = 0; ///2011.05.24
			double socQtySum = 0; 
			for(int i=0;i<cnrtCd.size();i++) {
				subCntrTsCd = ""; ///2011.05.24
				subQtySum = 0; ///2011.05.24
				for(int j=0;j<rqstVoList.size();j++) {
					rqstVo = (XterRqstVO) rqstVoList.get(j);
					if ( "CNTRTS_CD".equals(rqstVo.getColumnNm()) && cnrtCd.get(i).equals(rqstVo.getInputValue()) ) {
						for(int k=0;k<rqstVoList.size();k++) {
							rqstQtyVo = (XterRqstVO) rqstVoList.get(k);
							if ( Integer.parseInt(rqstQtyVo.getSeq()) == Integer.parseInt(rqstVo.getSeq()) && "IBQTY_QTY".equals(rqstQtyVo.getColumnNm()) ) {
								if (rqstQtyVo.getInputValue()!=null && rqstQtyVo.getInputValue().trim().length()>0){
									qtySum += Double.parseDouble(rqstQtyVo.getInputValue().trim());
								}
							}
							if ( Integer.parseInt(rqstQtyVo.getSeq()) == Integer.parseInt(rqstVo.getSeq()) && "SUB_BQTY_QTY".equals(rqstQtyVo.getColumnNm()) ) { ///2011.05.24
								if (rqstQtyVo.getInputValue()!=null && rqstQtyVo.getInputValue().trim().length()>0){
									subQtySum += Double.parseDouble(rqstQtyVo.getInputValue().trim());
								}
							}
							if ( Integer.parseInt(rqstQtyVo.getSeq()) == Integer.parseInt(rqstVo.getSeq()) && "CNTR_SOC_QTY".equals(rqstQtyVo.getColumnNm()) ) { ///2011.05.24
								if (rqstQtyVo.getInputValue()!=null && rqstQtyVo.getInputValue().trim().length()>0){
									socQtySum += Double.parseDouble(rqstQtyVo.getInputValue().trim());
								}
							}
							if ( Integer.parseInt(rqstQtyVo.getSeq()) == Integer.parseInt(rqstVo.getSeq()) && "SUB_CNTR_TS_CD".equals(rqstQtyVo.getColumnNm()) ) { ///2011.05.24
								subCntrTsCd = rqstQtyVo.getInputValue();
							}
						}
					}
				}
				retVal[i][0] = "N_CNTR_TPSZ_CD:"+cnrtCd.get(i);
				retVal[i][1] = "N_CNTR_QTY:"+String.valueOf(qtySum);
				retVal[i][2] = "N_EQ_SUBST_CNTR_TPSZ_CD:"+subCntrTsCd; ///2011.05.24
				retVal[i][3] = "N_EQ_SUBST_CGO_QTY:"+String.valueOf(subQtySum); ///2011.05.24
				retVal[i][4] = "N_SOC_QTY:"+String.valueOf(socQtySum); ///2011.05.24
				qtySum = 0;
				subQtySum = 0;
				socQtySum = 0;
			}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retVal;
	}

	/**
	 * BKG_XTER_CNTR_SEAL_NO 테이블의 컨테이너 정보 리턴<br>
	 *
	 * @param String[] rcvMsgS
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String[][] cntrList
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] searchCntrSealNoList(String[] rcvMsgS, List<BkgHrdCdgCtntVO> hrdList, String[][] cntrList) throws EventException {
		String[][] retVal = null;
		String[] splitRcvMsg = null;
		boolean startFlg = false;
		boolean existSealFlg = false;
		int sealSeq = 0;
		int colSeq = 0;
		try {
			retVal = new String[cntrList.length][searchColumnSize(hrdList, "BKG_XTER_CNTR_SEAL_NO")+2];

			for(int i=1;i<rcvMsgS.length;i++) {
				rcvMsgS[i] = remove(rcvMsgS[i], '\n');
				if ( "{I_BKG_CNTR".equals(rcvMsgS[i]) ) {
					for(int j=i;j<rcvMsgS.length;j++){
						if ( "}I_BKG_CNTR".equals(rcvMsgS[j])){
							break;
						}
						if ( !"{".equals(rcvMsgS[j].substring(0, 1)) && !"}".equals(rcvMsgS[j].substring(0, 1)) ) {
							//seal no가 있어야만 처리되도록 하고 없을 경우 return은 null로 함
							splitRcvMsg = splitByToken(rcvMsgS[j], ":");
							if ( "IBCNTR_SEAL_NO".equals(splitRcvMsg[0]) ) {
								startFlg = true;
								sealSeq++;
								break;
							} else if ( "IBCNTR_SEAL_NO2".equals(splitRcvMsg[0]) ) {
								startFlg = true;
								sealSeq++;
								break;
							} else if ( "IBCNTR_SEAL_NO3".equals(splitRcvMsg[0]) ) {
								startFlg = true;
								sealSeq++;
								break;
							}	
						}					
					}
				} else if ( "}I_BKG_CNTR".equals(rcvMsgS[i]) ) {
					startFlg = false;
					colSeq = 0;
				}
	
				if ( startFlg ) {
					if ( !"{".equals(rcvMsgS[i].substring(0, 1)) && !"}".equals(rcvMsgS[i].substring(0, 1)) ) {
						splitRcvMsg = splitByToken(rcvMsgS[i], ":");
						for (int j=0;j<hrdList.size();j++) {
				        	BkgHrdCdgCtntVO hrdCdg = (BkgHrdCdgCtntVO) hrdList.get(j);
			        		if ( "BKG_XTER_CNTR_SEAL_NO".equals(hrdCdg.getAttrCtnt3()) && hrdCdg.getAttrCtnt2().equals(splitRcvMsg[0]) ) {
			        			retVal[sealSeq-1][colSeq++] = (("DATE".equals(hrdCdg.getAttrCtnt5()))?"D_":"N_")+hrdCdg.getAttrCtnt4()+":"+splitRcvMsg[1];
				        	}
						}
	
						if ( "CNTR_NO".equals(splitRcvMsg[0]) ) {
							retVal[sealSeq-1][colSeq++] = "N_"+splitRcvMsg[0]+":"+splitRcvMsg[1];
						} else if ( "IBCNTR_SEAL_NO".equals(splitRcvMsg[0]) ) {
	//						retVal[sealSeq-1][colSeq++] = "N_CNTR_SEAL_SEQ:1";
							existSealFlg = true;
						} else if ( "IBCNTR_SEAL_NO2".equals(splitRcvMsg[0]) ) {
	//						retVal[sealSeq-1][colSeq++] = "N_CNTR_SEAL_SEQ:2";
							existSealFlg = true;
						} else if ( "IBCNTR_SEAL_NO3".equals(splitRcvMsg[0]) ) {
	//						retVal[sealSeq-1][colSeq++] = "N_CNTR_SEAL_SEQ:3";
							existSealFlg = true;
						}
					}
				}
			}
			log.debug("seal_no exit : " + existSealFlg);
			if (!existSealFlg) retVal = null;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return retVal;
	}

	/**
	 * IBD_DESC, IBM_MARK, IBEM_MISC 정보 하나로 묶기<br>
	 *
	 * @param String[][] val_BKG_XTER_RQST_MST
	 * @return String[][]
	 * @exception EventException
	 */
	private String[][] concateDescValue(String[][] val_BKG_XTER_RQST_MST) throws EventException {
		String[] splitColVal = null;
		StringBuffer gdsDescMsg = null;
		StringBuffer mkDescMsg = null;
		StringBuffer miscDescMsg = null;
		int gdsDescPosition = 0;
		int mkDescPosition = 0;
		int miscDescPosition = 0;
		try {
			gdsDescMsg = new StringBuffer();
			mkDescMsg = new StringBuffer();
			miscDescMsg = new StringBuffer();
			for (int i=0;i<val_BKG_XTER_RQST_MST.length;i++) {
				for (int j=0;j<val_BKG_XTER_RQST_MST[i].length;j++) {
					if (val_BKG_XTER_RQST_MST[i][j] != null && val_BKG_XTER_RQST_MST[i][j].indexOf(":") > 0) {
						splitColVal = splitByToken(val_BKG_XTER_RQST_MST[i][j], ":");
	
/*						
 * 						필요없는 것 부분인 것 같아 comment 처리 하였으며, 빈 block 으로 R4J에 걸려서 수정.
 *                      나중엔 지워 버리자  */
						if ( splitColVal[0].indexOf("GDS_DESC") != -1 ) {
							// 필요 없는 부분인 것 같음..
							gdsDescPosition = j;
	
							val_BKG_XTER_RQST_MST[i][j] = ":";
//							log.debug("[i][j]=[" + i + "][" + j + "]");
//							log.debug("splitColVal[0]=[" + splitColVal[0] + "]");
//							log.debug("splitColVal[1]=[" + splitColVal[1] + "]");
//							log.debug("gdsDescMsg=[" + gdsDescMsg + "]");
							gdsDescMsg.append(splitColVal[1]+"\n");
						} else if ( splitColVal[0].indexOf("MK_DESC") != -1 ) {
							mkDescPosition = j;
	
							val_BKG_XTER_RQST_MST[i][j] = ":";
							mkDescMsg.append(splitColVal[1]+"\n");
						} else if ( splitColVal[0].indexOf("MISC_DESC") != -1 ) {
							miscDescPosition = j;
	
							val_BKG_XTER_RQST_MST[i][j] = ":";
							miscDescMsg.append(splitColVal[1]+"\n");
						}
					}
				}
	
				if (!isNull(gdsDescMsg.toString())) val_BKG_XTER_RQST_MST[0][gdsDescPosition] = "N_GDS_DESC:"+gdsDescMsg.toString();
				if (!isNull(mkDescMsg.toString())) val_BKG_XTER_RQST_MST[0][mkDescPosition] = "N_MK_DESC:"+mkDescMsg.toString();
				if (!isNull(miscDescMsg.toString())) val_BKG_XTER_RQST_MST[0][miscDescPosition] = "N_MISC_DESC:"+miscDescMsg.toString();
			}
/*
			for (int i=0;i<val_BKG_XTER_RQST_MST.length;i++) {
				for (int j=0;j<val_BKG_XTER_RQST_MST[i].length;j++) {
					log.debug("COL:"+val_BKG_XTER_RQST_MST[i][j]);
				}
			}
*/
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return val_BKG_XTER_RQST_MST;
	}

	/**
	 * 전문정보로부터 그룹별 컬럼과 카운트를 리턴<br>
	 *  MQ 연동<br>
	 *
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String tableNm
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCodingTableList(List<BkgHrdCdgCtntVO> hrdList, String tableNm) throws EventException {
		List<BkgHrdCdgCtntVO> list = null;
//		int startSeq = 0;
		try {
			list = new ArrayList<BkgHrdCdgCtntVO>();
			for (int i=0;i<hrdList.size();i++) {
	        	BkgHrdCdgCtntVO hrdCdg = (BkgHrdCdgCtntVO) hrdList.get(i);
/*	        	if (tableNm.equals(hrdCdg.getAttrCtnt2().substring(1, hrdCdg.getAttrCtnt2().length())) ||
	        		tableNm.equals(hrdCdg.getAttrCtnt2().substring(0, hrdCdg.getAttrCtnt2().length()-1)) ) {
	        		startSeq++;
	        	}
	        	// Hrd리스트에서 새로운 그룹으로 바뀌기 전까지 add
	        	if (startSeq == 1) {
					list.add(hrdCdg);
	        	} else if (startSeq > 1) break;*/
	        	if (tableNm.equals(hrdCdg.getAttrCtnt6())) {
	        		list.add(hrdCdg);
	        	}
			}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
		return list;
	}

	/**
	 * 하드코딩 테이블의 컬럼갯수 리턴<br>
	 *  MQ 연동<br>
	 *
	 * @param List<BkgHrdCdgCtntVO> hrdList
	 * @param String tableNm
	 * @return int
	 * @exception EventException
	 */
	private int searchColumnSize(List<BkgHrdCdgCtntVO> hrdList, String tableNm) throws EventException {
		int retSize = 0;
		try {
			for (int i=0;i<hrdList.size();i++) {
	        	if ( tableNm.equals(((BkgHrdCdgCtntVO) hrdList.get(i)).getAttrCtnt3()) ) {
	        		retSize++;
	        	}
			}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
        log.debug("\n searchColumnSize :"+ tableNm +" sz:"+retSize);
		return retSize;
	}

	/**
	 * 하드코딩 정보 리턴<br>
	 *  MQ 연동<br>
	 *
	 * @param BkgHrdCdgCtntListCondVO hrdCdgCond
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(BkgHrdCdgCtntListCondVO hrdCdgCond) throws EventException {
        try {
            BookingUtil bcUtil = null;
            bcUtil = new BookingUtil();
	        //hrdCdgCond.setHrdCdgId("XTER_BKG_RECEIPT");
	        return bcUtil.searchHardCoding(hrdCdgCond);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
	    }
	}

	/**
	 * 해당 사용자의 external request 조회조건을 조회한다.<br>
	 *
	 * @param String userId
	 * @return List<BkgXterSrchSetVO>
	 * @exception EventException
	 */
	public List<BkgXterSrchSetVO> searchXterSrchSetForList(String userId) throws EventException {
		try {
			return dbDao.searchXterSrchSetForList(userId);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * IKEA Customer 인지 여부를 체크한다<br>
	 *
	 * @param SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean validateEdiIkeaCust(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO) throws EventException {
		try {
			return dbDao.validateEdiIkeaCust(searchXterPoMdtItmParmVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 수신한 External Request List를 조회함<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return List<ExternalRqstListVO>
	 * @exception EventException
	 */
	public List<ExternalRqstListVO> searchXterRqstList(ExternalRqstListInputVO xterRqstListInputVO) throws EventException {
		try {
			if(xterRqstListInputVO.getBkgNo() == null
					&& xterRqstListInputVO.getBkgNo().length() < 1
					&& xterRqstListInputVO.getXterRqstNo() == null
					&& xterRqstListInputVO.getXterRqstNo().length() < 1){
				if(xterRqstListInputVO.getRqstFromDt() == null 
						|| xterRqstListInputVO.getRqstFromDt().length() < 8){
					throw new EventException((String)new ErrorHandler("BKG00870").getMessage());				
				}
				if(xterRqstListInputVO.getRqstToDt() == null
						|| xterRqstListInputVO.getRqstToDt().length() < 8){
					throw new EventException((String)new ErrorHandler("BKG00871").getMessage());
				}
			}
	        return dbDao.searchXterRqstList(xterRqstListInputVO);
		} catch (EventException e){
			throw e;
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 필요에 따라 Booking Staff이 External Request의 상태를 조정한다.<br>
	 * 상태 종류는 New, Firm, Reject, Pending이 있다.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @param String newSts
	 * @param String reInstCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeXterRqstStatus(XterRqstNoVO[] xterRqstNoVO, String newSts, String reInstCd, SignOnUserAccount account) throws EventException{
		String rqstStsCd = null;
		List<XterRqstNoVO> updateVoList = null;
		try {
			updateVoList = new ArrayList<XterRqstNoVO>();
			for ( int i=0; i<xterRqstNoVO.length; i++ ) {
				if ( xterRqstNoVO[i].getIbflag().equals("U")){
					// Reinstate가 아닌 경우만 validation check
					if ( !"N".equals(newSts) ) {
						rqstStsCd = dbDao.searchXterRqstStatus(xterRqstNoVO[i]);
						if ("N".equals(reInstCd)) {
							if ("D".equals(rqstStsCd)) {
								throw new EventException(new ErrorHandler("BKG00471").getMessage());
							} else if ("R".equals(rqstStsCd)) {
								throw new EventException(new ErrorHandler("BKG00473").getMessage());
							}
						}
						if ("D".equals(rqstStsCd)) {
							throw new EventException(new ErrorHandler("BKG00471").getMessage());
						} else if ("R".equals(rqstStsCd)) {
							throw new EventException(new ErrorHandler("BKG00473").getMessage());
						}
						if ("P".equals(newSts) && "P".equals(rqstStsCd)) throw new EventException(new ErrorHandler("BKG00472").getMessage());
					}
					updateVoList.add(xterRqstNoVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.changeXterRqstStatus(account.getUsr_id(), newSts, updateVoList);
			}
		}catch(EventException e){
			throw e;
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * External Request의 정보를 Booking Data로 Create/Update하기 위해서 해당 External Request의 상세 정보를 조회함.<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchXterBkg(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException {
		ExternalRqstBkgVO externalRqstBkgVO = null;
		try {
			externalRqstBkgVO = new ExternalRqstBkgVO();
			externalRqstBkgVO.setXterRqstMstVO(dbDao.searchXterBkg(xterRqstNoVO));
			externalRqstBkgVO.setBkgXterQtyVO(dbDao.searchXterQty(xterRqstNoVO));
			externalRqstBkgVO.setXterRqstTabVO(dbDao.searchXterRqstTab(xterRqstNoVO, account));

//			externalRqstBkgVO.setAlpsBkgVO(dbDao.searchAlpsBkg(xterRqstNoVO));
//			externalRqstBkgVO.setAlpsQtyVO(dbDao.searchAlpsQty(xterRqstNoVO));
//			externalRqstBkgVO.setVslSkdVO(dbDao.searchAlpsVvd(xterRqstNoVO));
//			externalRqstBkgVO.setAlpsQtyDtlVO(dbDao.searchAlpsQtyDtl(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return externalRqstBkgVO;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Find Booking 버튼 Click 시 ALPS Booking 정보만 조회 <br>
	 * 
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstBkgVO
	 * @exception EventException
	 */
	public ExternalRqstBkgVO searchAlpsBkg(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstBkgVO externalRqstBkgVO = null;
		try {
			externalRqstBkgVO = new ExternalRqstBkgVO();
//			externalRqstBkgVO.setAlpsBkgVO(dbDao.searchAlpsBkg(xterRqstNoVO));
//			externalRqstBkgVO.setAlpsQtyVO(dbDao.searchAlpsQty(xterRqstNoVO));
//			externalRqstBkgVO.setVslSkdVO(dbDao.searchAlpsVvd(xterRqstNoVO));
//			externalRqstBkgVO.setAlpsQtyDtlVO(dbDao.searchAlpsQtyDtl(xterRqstNoVO));
//        } catch (DAOException de) {
//            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return externalRqstBkgVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 customer 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCustVO
	 * @exception EventException
	 */
	public ExternalRqstCustVO searchXterCust(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstCustVO externalRqstCustVO = null;
		try {
//			BookingUtil util = new BookingUtil();
			externalRqstCustVO = new ExternalRqstCustVO();
//			externalRqstCustVO.setBlDocCustVO(dbDao.searchXterBlDocCust(xterRqstNoVO));
//			CustEtcVO custEtcVO = dbDao.searchXterBkgCustEtc(xterRqstNoVO);			

			// CANADA 경유 여부 확인
//			String frobCode = util.searchFrob(custEtcVO.getBkgVvd(), custEtcVO.getPolCd(), custEtcVO.getPodCd());
//			String frobFlag = "N";
//			if("CA".equals(frobCode) || "AL".equals(frobCode)){
//				frobFlag = "Y";
//			}
//			custEtcVO.setFrobFlag(frobFlag);
//			externalRqstCustVO.setCustEtcVO(custEtcVO);
			externalRqstCustVO.setBkgXterCustVO(dbDao.searchXterCust(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return externalRqstCustVO;
	}

	/**
	 * extenal request의 container 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCntrVO
	 * @exception EventException
	 */
	public ExternalRqstCntrVO searchXterCntr(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstCntrVO externalRqstCntrVO = null;
		try {
			externalRqstCntrVO = new ExternalRqstCntrVO();
//			externalRqstCntrVO.setAlpsCntrVO			(dbDao.searchAlpsCntr		(xterRqstNoVO));
//			externalRqstCntrVO.setBkgCntrSealNoVO		(dbDao.searchAlpsCntrSealNo	(xterRqstNoVO));
			externalRqstCntrVO.setXterCntrVO			(dbDao.searchXterCntr		(xterRqstNoVO));
			externalRqstCntrVO.setBkgXterCntrSealNoVO	(dbDao.searchXterCntrSealNo	(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstCntrVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 mark & Description 정보를 조회한다.<br>
	 * BKG_XTER_XPT_LIC_NO, BKG_XTER_AES, BKG_XTER_RQST_MST, BKG_XTER_CNTR에서 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String usrOfc
	 * @return ExternalRqstMndVO
	 * @exception EventException
	 */
	public ExternalRqstMndVO searchXterMnd(XterRqstNoVO xterRqstNoVO, String usrOfc) throws EventException {
		ExternalRqstMndVO externalRqstMndVO = null;
		BookingUtil util = new BookingUtil();
		try {
			externalRqstMndVO = new ExternalRqstMndVO();
			List<XterMndVO> xterMndVOs = dbDao.searchXterMnd(xterRqstNoVO, usrOfc);
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("EBKG_MND_LOAD_SPEED");			
			List<BkgHrdCdgCtntVO> loadSpeed = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			if(!(loadSpeed != null && loadSpeed.get(0).getAttrCtnt1().equals("ON"))){
				xterMndVOs.get(0).setIdXptLicCnt("1");
				xterMndVOs.get(0).setKrXptLicCnt("1");				
			}

			externalRqstMndVO.setXterMndVO(xterMndVOs);
			
			// alps bkg
			externalRqstMndVO.setAlpsXptImpLicListVOs(dbDao.searchAlpsXptImpLicList(xterRqstNoVO));
			
			//e-bkg MEXICO,turkey,ISRAEL,LEBANON,BRAZIL,USA,CANADA
			externalRqstMndVO.setXterXptLicVO(dbDao.searchXterXptLicVO(xterRqstNoVO));

			// e-bkg korea
			externalRqstMndVO.setKrXptLicNoVOs(dbDao.searchKrXptLicNoList(xterRqstNoVO));

			// e-bkg indonesia
			externalRqstMndVO.setIdXptLicNoVOs(dbDao.searchXptLicNoListByCntCd(xterRqstNoVO, "ID"));
			
			externalRqstMndVO.setXterCntrPoNoVOs(dbDao.searchXterCntrPoNoList(xterRqstNoVO));
			externalRqstMndVO.setXterPoDtlVOs(dbDao.searchXterPoDtlNoList(xterRqstNoVO));
			
			//CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가			
			externalRqstMndVO.setXterRefDtlVOs(dbDao.searchXterRefDtlList(xterRqstNoVO));
			
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstMndVO;
	}

	/**
	 * extenal request의 container manifest 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstCmVO
	 * @exception EventException
	 */
	public ExternalRqstCmVO searchXterCm(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstCmVO externalRqstCmVO = null;
		try {
			externalRqstCmVO = new ExternalRqstCmVO();
			externalRqstCmVO.setAlpsCmVO(dbDao.searchAlpsCm(xterRqstNoVO));
			externalRqstCmVO.setBkgXterCntrMkDescVO(dbDao.searchXterCm(xterRqstNoVO));
			externalRqstCmVO.setBkgDgCgoVOs(dbDao.searchBkgDgCgo(xterRqstNoVO.getBkgNo()));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstCmVO;
	}

	/**
	 * extenal request의 tro 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstTroVO
	 * @exception EventException
	 */
	public ExternalRqstTroVO searchXterTro(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstTroVO externalRqstTroVO = null;
		try {
			externalRqstTroVO = new ExternalRqstTroVO();
			externalRqstTroVO.setBkgXterTroVO(dbDao.searchXterTro(xterRqstNoVO));
			externalRqstTroVO.setBkgXterTroDtlVO(dbDao.searchXterTroDtl(xterRqstNoVO));
			externalRqstTroVO.setNisTroMstVO(dbDao.searchAlpsTro(xterRqstNoVO));
			externalRqstTroVO.setNisTroDtlVO(dbDao.searchAlpsTroDtl(xterRqstNoVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstTroVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstRfVO
	 * @exception EventException
	 */
	public ExternalRqstRfVO searchXterRf(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstRfVO externalRqstRfVO = null;
		try {
			externalRqstRfVO = new ExternalRqstRfVO();
			externalRqstRfVO.setNisRfVO(dbDao.searchAlpsRf(xterRqstNoVO));
			externalRqstRfVO.setBkgXterRfCgoVO(dbDao.searchXterRf(xterRqstNoVO));
			externalRqstRfVO.setAlpsCntrTpszVO(dbDao.searchAlpsCntrTpSz(xterRqstNoVO.getBkgNo()));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstRfVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstDgVO
	 * @exception EventException
	 */
	public ExternalRqstDgVO searchXterDg(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstDgVO externalRqstDgVO = null;
		try {
			externalRqstDgVO = new ExternalRqstDgVO();
			externalRqstDgVO.setNisDgVO(dbDao.searchAlpsDg(xterRqstNoVO));
			externalRqstDgVO.setBkgXterDgCgoVO(dbDao.searchXterDg(xterRqstNoVO));
			externalRqstDgVO.setAlpsCntrTpszVO(dbDao.searchAlpsCntrTpSz(xterRqstNoVO.getBkgNo()));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstDgVO;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * extenal request의 awkward cargo 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstAkVO
	 * @exception EventException
	 */
	public ExternalRqstAkVO searchXterAk(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstAkVO externalRqstAkVO = null;
		try {
			externalRqstAkVO = new ExternalRqstAkVO();
			externalRqstAkVO.setNisAkVO(dbDao.searchAlpsAk(xterRqstNoVO));
			externalRqstAkVO.setBkgXterAwkCgoVO(dbDao.searchXterAk(xterRqstNoVO));
			externalRqstAkVO.setAlpsCntrTpszVO(dbDao.searchAlpsCntrTpSz(xterRqstNoVO.getBkgNo()));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstAkVO;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * extenal request의 break bulk cargo 정보들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstAkVO
	 * @exception EventException
	 */
	public ExternalRqstBbVO searchXterBb(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstBbVO externalRqstBbVO = null;
		try {
			externalRqstBbVO = new ExternalRqstBbVO();
			externalRqstBbVO.setAlpsBbVO(dbDao.searchAlpsBb(xterRqstNoVO));
			externalRqstBbVO.setBkgXterBbCgoVO(dbDao.searchXterBb(xterRqstNoVO));
//			externalRqstBbVO.setAlpsCntrTpszVO(dbDao.searchAlpsCntrTpSz(xterRqstNoVO.getBkgNo()));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstBbVO;
	}
	
	/**
	 * extenal request의 house b/l들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl1VO
	 * @exception EventException
	 */
	public ExternalRqstHbl1VO searchXterHbl1(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstHbl1VO externalRqstHbl1VO = null;
		try {
			externalRqstHbl1VO = new ExternalRqstHbl1VO();
			externalRqstHbl1VO.setNisHbl1VO(dbDao.searchAlpsHbl1(xterRqstNoVO));
			externalRqstHbl1VO.setXterHbl1VO(dbDao.searchXterHbl1(xterRqstNoVO));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstHbl1VO;
	}

	/**
	 * extenal request의 ams file no들을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return ExternalRqstHbl2VO
	 * @exception EventException
	 */
	public ExternalRqstHbl2VO searchXterHbl2(XterRqstNoVO xterRqstNoVO) throws EventException {
		ExternalRqstHbl2VO externalRqstHbl2VO = null;
		try {
			externalRqstHbl2VO = new ExternalRqstHbl2VO();
			externalRqstHbl2VO.setBkgUsaCstmsFileNoVO(dbDao.searchAlpsHbl2(xterRqstNoVO));
			externalRqstHbl2VO.setXterUsaCstmsFileNoVO(dbDao.searchXterHbl2(xterRqstNoVO));
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return externalRqstHbl2VO;
	}

	/**
	 * eBKG reject 내역을 email로 전송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param String bkgNo
	 * @param String senderEml
	 * @param String cntcEml
	 * @param String rjctRsnRmk
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendXterRqstRejectEmail(String bkgNo, String senderEml, String cntcEml, String rjctRsnRmk, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		try {
            util = new BookingUtil();
            String senderMailAddr ="";
			String rcvFntOfcEmlAddr ="";
			senderMailAddr = util.searchGroupEmailAddrRSQL(bkgNo, account.getUsr_id(),"EM", "BL");//group mail check
			rcvFntOfcEmlAddr = JSPUtil.getNull(util.searchGroupEmailAddrRSQL(bkgNo, account.getUsr_id(),"FNT_EML", "BL"));//group mail check
			cntcEml = cntcEml + ";" +rcvFntOfcEmlAddr;            
			senderEml = senderMailAddr.equals("") ? senderEml:senderMailAddr;
			eaiDao.sendXterRqstRejectEmail(senderEml, cntcEml, rjctRsnRmk);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * eBKG pending 내역을 email로 전송한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param String emlSndYn
	 * @param String senderEml
	 * @param String cntcEml
	 * @param String xterRjctRsnCd
	 * @param String pendingRsnRmk
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendXterRqstPendingNotice(XterRqstNoVO xterRqstNoVO, String emlSndYn, String senderEml, String cntcEml,
				String xterRjctRsnCd, String pendingRsnRmk, SignOnUserAccount account) throws EventException{
		BookingUtil util = null;
		try {
			// Reinstate가 아닌 경우만 validation check
			String rqstStsCd = dbDao.searchXterRqstStatus(xterRqstNoVO);
			if ("D".equals(rqstStsCd)) {
				throw new EventException(new ErrorHandler("BKG00471").getMessage());
			} else if ("R".equals(rqstStsCd)) {
				throw new EventException(new ErrorHandler("BKG00473").getMessage());
			} else if ("P".equals(rqstStsCd)){ 
				throw new EventException(new ErrorHandler("BKG00472").getMessage());
			}
			
			dbDao.modifyXterRqstReject(pendingRsnRmk, xterRjctRsnCd, account.getUsr_id(), xterRqstNoVO, "P");
			if(emlSndYn.equals("Y")){
	            util = new BookingUtil();
	            String senderMailAddr ="";
				String rcvFntOfcEmlAddr ="";
				String bkgNo = xterRqstNoVO.getBkgNo();
				senderMailAddr = util.searchGroupEmailAddrRSQL(bkgNo, account.getUsr_id(),"EM", "BL");//group mail check
				rcvFntOfcEmlAddr = JSPUtil.getNull(util.searchGroupEmailAddrRSQL(bkgNo, account.getUsr_id(),"FNT_EML", "BL"));//group mail check
				cntcEml = cntcEml + ";" +rcvFntOfcEmlAddr;            
				senderEml = senderMailAddr.equals("") ? senderEml:senderMailAddr;
				eaiDao.sendXterRqstPendingNotice(senderEml, cntcEml, pendingRsnRmk);
			}
		} catch (EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * external request에 대해 reject에 대한 edi를 화주별 format으로 만든다.<br>
	 *
	 * @param String rjctRsnRmk
	 * @param String xterRjctRsnCd
	 * @param XterRqstNoVO xterRqstNoVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException 
	 */
	public String createXterRqstRejectEdi(String rjctRsnRmk, String xterRjctRsnCd, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException {
        BookingUtil bcUtil = null;
		String rejectEdiType = null;
		String hostTpId = null;
		String ediHeader = null;
		String ediBody = null;
		StringBuffer flatFile = null;
		RjctSndrRcvrVO rjctSndrRcvrVO = null;
		RejectEdiMstVO rejectEdiMstVO = null;
		List<RejectEdiCntrVO> rejectEdiCntrVO = null;
		List<RejectEdiDgVO> rejectEdiDgVO = null;
		List<RejectEdiQtyVO> rejectEdiQtyVO = null;
		List<RejectEdiVvdVO> rejectEdiVvdVO = null;
		List<RejectEdiCustVO> rejectEdiCustVO = null;
		List<RejectEdiDescVO> rejectEdiDescVO = null;
		RejectEdiInstrVO rejectEdiInstrVO = null;
		RejectEdiCntrVO cntrVO = null;
		RejectEdiDescVO descVO = null;
		RejectEdiDgVO dgVO = null;
		RejectEdiQtyVO qtyVO = null;
		try {
	        bcUtil = new BookingUtil();
			flatFile = new StringBuffer();
			rjctSndrRcvrVO = new RjctSndrRcvrVO();
			rejectEdiMstVO = new RejectEdiMstVO();
			rejectEdiCntrVO = new ArrayList<RejectEdiCntrVO>();
			rejectEdiDgVO = new ArrayList<RejectEdiDgVO>();
			rejectEdiQtyVO = new ArrayList<RejectEdiQtyVO>();
			rejectEdiVvdVO = new ArrayList<RejectEdiVvdVO>();
			rejectEdiCustVO = new ArrayList<RejectEdiCustVO>();
			rejectEdiDescVO = new ArrayList<RejectEdiDescVO>();
			rejectEdiInstrVO = new RejectEdiInstrVO();

			// bkg_xter_rqst_mst의 데이터를 Reject정보로 갱신한다.
			dbDao.modifyXterRqstReject(rjctRsnRmk, xterRjctRsnCd, account.getUsr_id(), xterRqstNoVO, "R");
			//xterRqstViaCd = dbDao.searchXterRqstViaCode(xterRqstNoVO);
//			rejectEdiType = dbDao.searchRejectEdiType(xterRqstNoVO.getSenderId());
			rejectEdiType = dbDao.searchRejectEdiType(xterRqstNoVO);
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(account.getOfc_cd().substring(0, 3));			
			String svrId = bcUtil.searchSvrByBkgNo(bkgBlNoVO);
			// EDI로 보낼 FlatFile 정보 생성
//			if ( "Y".equals(rejectEdiType) ) {
			if ( "301".equals(rejectEdiType) ) {
				rjctSndrRcvrVO = dbDao.searchRejectEdiHeader(xterRqstNoVO.getSenderId());
				ediHeader = bcUtil.searchEdiHeader(rjctSndrRcvrVO.getSndrId(), xterRqstNoVO.getSenderId(), "301");
				rejectEdiMstVO = dbDao.searchXterRqstMstForRejectEdi(xterRqstNoVO.getSenderId(), rjctRsnRmk, xterRqstNoVO);
				flatFile.append(ediHeader).append("\n");
				rejectEdiCntrVO = dbDao.searchXterCntrForRejectEdi(xterRqstNoVO);
				rejectEdiDgVO = dbDao.searchXterDgForRejectEdi(xterRqstNoVO);
				rejectEdiQtyVO = dbDao.searchXterQtyForRejectEdi(xterRqstNoVO);
				rejectEdiVvdVO = dbDao.searchXterVvdForRejectEdi(xterRqstNoVO);
				rejectEdiCustVO = dbDao.searchXterCustForRejectEdi(xterRqstNoVO);
				rejectEdiDescVO = dbDao.searchXterDescForRejectEdi(xterRqstNoVO);
				rejectEdiInstrVO = dbDao.searchXterInstrForRejeceEdi(xterRqstNoVO);
				
				if ( rejectEdiMstVO != null ) {
					flatFile.append("BKGNBR:"          ).append(rejectEdiMstVO.getBkgnbr()        ).append("\n");
					flatFile.append("BKG_DT:"          ).append(rejectEdiMstVO.getBkgDt()         ).append("\n");
					flatFile.append("BRAC:"            ).append(rejectEdiMstVO.getBrac()          ).append("\n");
					flatFile.append("BL_NO:"           ).append(rejectEdiMstVO.getBlNo()          ).append("\n");
					flatFile.append("BKG_LANE:"        ).append(rejectEdiMstVO.getBkgLane()       ).append("\n");
					flatFile.append("BV_LANE:"         ).append(rejectEdiMstVO.getBvLane()        ).append("\n");
					flatFile.append("TOVSL:"           ).append(rejectEdiMstVO.getTovsl()         ).append("\n");
					flatFile.append("LOYD:"            ).append(rejectEdiMstVO.getLoyd()          ).append("\n");
					flatFile.append("VSLNAME:"         ).append(rejectEdiMstVO.getVslname()       ).append("\n");
					flatFile.append("VSL_CALL_SIGN:"   ).append(rejectEdiMstVO.getVslCallSign()   ).append("\n");
					flatFile.append("VVD_REF_NO:"      ).append(rejectEdiMstVO.getVvdRefNo()      ).append("\n");
					flatFile.append("TOVOY:"           ).append(rejectEdiMstVO.getTovoy()         ).append("\n");
					flatFile.append("TODIR:"           ).append(rejectEdiMstVO.getTodir()         ).append("\n");
					flatFile.append("VSLLD:"           ).append(rejectEdiMstVO.getVslld()         ).append("\n");
					flatFile.append("VSLD:"            ).append(rejectEdiMstVO.getVsld()          ).append("\n");
					flatFile.append("OLDVSL:"          ).append(rejectEdiMstVO.getOldvsl()        ).append("\n");
					flatFile.append("OLDLOYD:"         ).append(rejectEdiMstVO.getOldloyd()       ).append("\n");
					flatFile.append("OLDVSLNAME:"      ).append(rejectEdiMstVO.getOldvslname()    ).append("\n");
					flatFile.append("OLDVSL_CALL_SIGN:").append(rejectEdiMstVO.getOldvslCallSign()).append("\n");
					flatFile.append("OLDVOY:"          ).append(rejectEdiMstVO.getOldvoy()        ).append("\n");
					flatFile.append("OLDDIR:"          ).append(rejectEdiMstVO.getOlddir()        ).append("\n");
					flatFile.append("TVSL:"            ).append(rejectEdiMstVO.getTvsl()          ).append("\n");
					flatFile.append("TLOYD:"           ).append(rejectEdiMstVO.getTloyd()         ).append("\n");
					flatFile.append("TVSLNAME:"        ).append(rejectEdiMstVO.getTvslname()      ).append("\n");
					flatFile.append("TVSL_CALL_SIGN:"  ).append(rejectEdiMstVO.getTvslCallSign()  ).append("\n");
					flatFile.append("TVOY:"            ).append(rejectEdiMstVO.getTvoy()          ).append("\n");
					flatFile.append("TDIR:"            ).append(rejectEdiMstVO.getTdir()          ).append("\n");
					flatFile.append("POR_NAME:" ).append(rejectEdiMstVO.getName1()   ).append("\n");
					flatFile.append("POR_QUAL:" ).append(rejectEdiMstVO.getQual1()   ).append("\n");
					flatFile.append("POR_PORT:" ).append(rejectEdiMstVO.getPort1()   ).append("\n");
					flatFile.append("POR_UNLC:" ).append(rejectEdiMstVO.getUnlc1()   ).append("\n");
					flatFile.append("POL_NAME:" ).append(rejectEdiMstVO.getName2()   ).append("\n");
					flatFile.append("POL_QUAL:" ).append(rejectEdiMstVO.getQual2()   ).append("\n");
					flatFile.append("POL_PORT:" ).append(rejectEdiMstVO.getPort2()   ).append("\n");
					flatFile.append("POL_UNLC:" ).append(rejectEdiMstVO.getUnlc2()   ).append("\n");
					flatFile.append("POL_ETA:"  ).append(rejectEdiMstVO.getEta2()    ).append("\n");
					flatFile.append("POL_ETD:"  ).append(rejectEdiMstVO.getEtd2()    ).append("\n");
					flatFile.append("POL_ETD_7:").append(rejectEdiMstVO.getEtd4()    ).append("\n");
					flatFile.append("BED:"      ).append(rejectEdiMstVO.getBed3()    ).append("\n");
					flatFile.append("CCT:"      ).append(rejectEdiMstVO.getCct2()    ).append("\n");
					flatFile.append("DCT:"      ).append(rejectEdiMstVO.getVpsCctDt()).append("\n");
					flatFile.append("POD_NAME:" ).append(rejectEdiMstVO.getName3()   ).append("\n");
					flatFile.append("POD_QUAL:" ).append(rejectEdiMstVO.getQual3()   ).append("\n");
					flatFile.append("POD_PORT:" ).append(rejectEdiMstVO.getPort3()   ).append("\n");
					flatFile.append("POD_UNLC:" ).append(rejectEdiMstVO.getUnlc3()   ).append("\n");
					flatFile.append("POD_ETA:"  ).append(rejectEdiMstVO.getEta3()    ).append("\n");
					flatFile.append("POD_ETA_1:").append(rejectEdiMstVO.getEta31()   ).append("\n");
					flatFile.append("POD_ETD:"  ).append(rejectEdiMstVO.getEtd3()    ).append("\n");
					flatFile.append("DEL_NAME:" ).append(rejectEdiMstVO.getName4()   ).append("\n");
					flatFile.append("DEL_QUAL:" ).append(rejectEdiMstVO.getQual4()   ).append("\n");
					flatFile.append("DEL_PORT:" ).append(rejectEdiMstVO.getPort4()   ).append("\n");
					flatFile.append("DEL_UNLC:" ).append(rejectEdiMstVO.getUnlc4()   ).append("\n");
					flatFile.append("DEL_ETA:"  ).append(rejectEdiMstVO.getEta4()    ).append("\n");
					flatFile.append("DEL_ETD:"  ).append(rejectEdiMstVO.getEtd4()    ).append("\n"); /* YCKIM */
					flatFile.append("RLY_NAME:" ).append(rejectEdiMstVO.getName5()   ).append("\n");
					flatFile.append("RLY_QUAL:" ).append(rejectEdiMstVO.getQual5()   ).append("\n");
					flatFile.append("RLY_PORT:" ).append(rejectEdiMstVO.getPort5()   ).append("\n");
					flatFile.append("RLY_UNLC:" ).append(rejectEdiMstVO.getUnlc5()   ).append("\n");
					flatFile.append("RLY_ETA:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY_ETD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_NAME:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_QUAL:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_PORT:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_UNLC:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_ETA:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_ETD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_NAME:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_QUAL:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_PORT:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_UNLC:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_ETA:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("PUNIT:"          ).append(rejectEdiMstVO.getPunit()         ).append("\n");
					flatFile.append("PKG:"            ).append(rejectEdiMstVO.getPkg()           ).append("\n");
					flatFile.append("WUNIT:"          ).append(rejectEdiMstVO.getWunit()         ).append("\n");
					flatFile.append("WGT:"            ).append(rejectEdiMstVO.getWgt()           ).append("\n");
					flatFile.append("EWUNIT:"         ).append(rejectEdiMstVO.getEwunit()        ).append("\n");
					flatFile.append("EWGT:"           ).append(rejectEdiMstVO.getEwgt()          ).append("\n");
					flatFile.append("MUNIT:"          ).append(rejectEdiMstVO.getMunit()         ).append("\n");
					flatFile.append("MEAS:"           ).append(rejectEdiMstVO.getMeas()          ).append("\n");
					flatFile.append("RDTYP:"          ).append(rejectEdiMstVO.getRdtyp()         ).append("\n");
					flatFile.append("SMOD:"           ).append(rejectEdiMstVO.getSmod()          ).append("\n");
					flatFile.append("TRUCK:"          ).append(rejectEdiMstVO.getTruck()         ).append("\n");
					flatFile.append("REMARK:"         ).append(rejectEdiMstVO.getRemark()        ).append("\n");
					flatFile.append("CMD:"            ).append(rejectEdiMstVO.getCmd()           ).append("\n");
					flatFile.append("CMDD:"           ).append(rejectEdiMstVO.getCmdd()          ).append("\n");
					flatFile.append("EQREL:"          ).append(rejectEdiMstVO.getEqrel()         ).append("\n");
					flatFile.append("LC_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("INV_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("ACI_FILER_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("AMS_FILER_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("CN_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("EX_LICENCE_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SHN1:"           ).append(rejectEdiMstVO.getShn1()          ).append("\n");
					flatFile.append("FFN1:"           ).append(rejectEdiMstVO.getFfn1()          ).append("\n");
					flatFile.append("CNE1:"           ).append(rejectEdiMstVO.getCne1()          ).append("\n");
					flatFile.append("SH_CD1:"         ).append(rejectEdiMstVO.getShCd1()         ).append("\n");
					flatFile.append("FF_CD1:"         ).append(rejectEdiMstVO.getFfCd1()         ).append("\n");
					flatFile.append("CN_CD1:"         ).append(rejectEdiMstVO.getCnCd1()         ).append("\n");
					flatFile.append("NTFY_CD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("ANTFY_CD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("3RD_NTFY_CD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SHPR1:"          ).append(rejectEdiMstVO.getShpr1()         ).append("\n");
					flatFile.append("SHPR2:"          ).append(rejectEdiMstVO.getShpr2()         ).append("\n");
					flatFile.append("SHPR3:"          ).append(rejectEdiMstVO.getShpr3()         ).append("\n");
					flatFile.append("SHPR4:"          ).append(rejectEdiMstVO.getShpr4()         ).append("\n");
					flatFile.append("SHPR5:"          ).append(rejectEdiMstVO.getShpr5()         ).append("\n");
					flatFile.append("CNEE1:"          ).append(rejectEdiMstVO.getCnee1()         ).append("\n");
					flatFile.append("CNEE2:"          ).append(rejectEdiMstVO.getCnee2()         ).append("\n");
					flatFile.append("CNEE3:"          ).append(rejectEdiMstVO.getCnee3()         ).append("\n");
					flatFile.append("CNEE4:"          ).append(rejectEdiMstVO.getCnee4()         ).append("\n");
					flatFile.append("CNEE5:"          ).append(rejectEdiMstVO.getCnee5()         ).append("\n");
					flatFile.append("FWDR1:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FWDR2:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FWDR3:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FWDR4:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FWDR5:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("NTFY1:"          ).append(rejectEdiMstVO.getNtfy1()         ).append("\n");
					flatFile.append("NTFY2:"          ).append(rejectEdiMstVO.getNtfy2()         ).append("\n");
					flatFile.append("NTFY3:"          ).append(rejectEdiMstVO.getNtfy3()         ).append("\n");
					flatFile.append("NTFY4:"          ).append(rejectEdiMstVO.getNtfy4()         ).append("\n");
					flatFile.append("NTFY5:"          ).append(rejectEdiMstVO.getNtfy5()         ).append("\n");
					flatFile.append("ANTFY1:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("ANTFY2:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("ANTFY3:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("ANTFY4:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("ANTFY5:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("CANCEL_BIT:"     ).append(rejectEdiMstVO.getCancelBit()     ).append("\n");
					flatFile.append("CARGOTYPE:"      ).append(rejectEdiMstVO.getCargotype()     ).append("\n");
					flatFile.append("DR_IND:"         ).append(rejectEdiMstVO.getDrInd()         ).append("\n");
					flatFile.append("RF_IND:"         ).append(rejectEdiMstVO.getRfInd()         ).append("\n");
					flatFile.append("AK_IND:"         ).append(rejectEdiMstVO.getAkInd()         ).append("\n");
					flatFile.append("BB_IND:"         ).append(rejectEdiMstVO.getBbInd()         ).append("\n");
					flatFile.append("HD_IND:"         ).append(rejectEdiMstVO.getHdInd()         ).append("\n");
					flatFile.append("UD_IND:"         ).append(rejectEdiMstVO.getUdInd()         ).append("\n");
					flatFile.append("UD_CD:"          ).append(rejectEdiMstVO.getUdCd()          ).append("\n");
					flatFile.append("RD_IND:"         ).append(rejectEdiMstVO.getRdUnd()         ).append("\n");
					flatFile.append("RF_CA:"          ).append(rejectEdiMstVO.getRfCa()          ).append("\n");
					flatFile.append("RF_MA:"          ).append(rejectEdiMstVO.getRfMa()          ).append("\n");
					flatFile.append("SOC_IND:"        ).append(rejectEdiMstVO.getSocInd()        ).append("\n");
					flatFile.append("SALES_OFFICE:"   ).append(rejectEdiMstVO.getSalesOffice()   ).append("\n");
					flatFile.append("SALES_NAME:"     ).append(rejectEdiMstVO.getSalesName()     ).append("\n");
					flatFile.append("BKG_STF:"        ).append(rejectEdiMstVO.getBkgStf()        ).append("\n");
					flatFile.append("BKG_STF_NAME:"   ).append(rejectEdiMstVO.getBkgStfName()    ).append("\n");
					flatFile.append("BKG_STF_TEL:"    ).append(rejectEdiMstVO.getBkgStfTel()     ).append("\n");
					flatFile.append("BKG_STF_FAX:"    ).append(rejectEdiMstVO.getBkgStfFax()     ).append("\n");
					flatFile.append("CONTACT_NAME:"   ).append(rejectEdiMstVO.getContactName()   ).append("\n");
					flatFile.append("CONTACT_TEL:"    ).append(rejectEdiMstVO.getContactTel()    ).append("\n");
					flatFile.append("BOUND_IND:"      ).append(rejectEdiMstVO.getBoundInd()      ).append("\n");
					flatFile.append("REGIONAL_BKGNBR:").append(rejectEdiMstVO.getRegionalBkgnbr()).append("\n");
					flatFile.append("CUST_REF_NO:"    ).append(rejectEdiMstVO.getCustRefNo()     ).append("\n");
					flatFile.append("REF_VOYAGE:"     ).append(rejectEdiMstVO.getRefVoyage()     ).append("\n");
					flatFile.append("SO_NO:"          ).append(rejectEdiMstVO.getSoNo()          ).append("\n");
					flatFile.append("BLKSTWG:"        ).append(rejectEdiMstVO.getBlkstwg()       ).append("\n");
					flatFile.append("EQPICKDT:"       ).append(rejectEdiMstVO.getEqpickdt()      ).append("\n");
					flatFile.append("EQRTN:"          ).append(rejectEdiMstVO.getEqrtn()         ).append("\n");
					flatFile.append("PUCY_CNT:"       ).append(rejectEdiMstVO.getPucyCnt()       ).append("\n");
					flatFile.append("PUCY_CD:").append(rejectEdiMstVO.getPucyCd()).append("\n");
					flatFile.append("PUCY_NM:"   ).append(rejectEdiMstVO.getPucyNm()   ).append("\n");
					flatFile.append("PUCY_ADDR1:").append(rejectEdiMstVO.getPucyAddr1()).append("\n");
					flatFile.append("PUCY_ADDR2:").append(rejectEdiMstVO.getPucyAddr2()).append("\n");
					flatFile.append("PUCY_ADDR3:").append(rejectEdiMstVO.getPucyAddr3()).append("\n");
					flatFile.append("PUCY_ADDR4:").append(rejectEdiMstVO.getPucyAddr4()).append("\n");
					flatFile.append("PUCY_ADDR5:").append(rejectEdiMstVO.getPucyAddr5()).append("\n");
					flatFile.append("RTCY_CNT:"  ).append(rejectEdiMstVO.getRtcyCnt()  ).append("\n");
					flatFile.append("RTCY_CD:").append(rejectEdiMstVO.getRtcyCd()).append("\n");
					flatFile.append("RTCY_NM:"   ).append(rejectEdiMstVO.getRtcyNm()   ).append("\n");
					flatFile.append("RTCY_ADDR1:").append(rejectEdiMstVO.getRtcyAddr1()).append("\n");
					flatFile.append("RTCY_ADDR2:").append(rejectEdiMstVO.getRtcyAddr2()).append("\n");
					flatFile.append("RTCY_ADDR3:").append(rejectEdiMstVO.getRtcyAddr3()).append("\n");
					flatFile.append("RTCY_ADDR4:").append(rejectEdiMstVO.getRtcyAddr4()).append("\n");
					flatFile.append("RTCY_ADDR5:").append(rejectEdiMstVO.getRtcyAddr5()).append("\n");
					flatFile.append("BL_PO_NO:"  ).append(rejectEdiMstVO.getBlPoNo()   ).append("\n");
					flatFile.append("BL_SI_NO:"  ).append(rejectEdiMstVO.getBlSiNo()   ).append("\n");
					flatFile.append("FRT_TERM:").append(rejectEdiMstVO.getFrtTerm()   ).append("\n");
					flatFile.append("ONBOARD:").append(rejectEdiMstVO.getOnboard()   ).append("\n");
					flatFile.append("BKG_OFC:").append(rejectEdiMstVO.getBkgOfc()    ).append("\n");
					flatFile.append("SC_NO:").append(rejectEdiMstVO.getScNo()      ).append("\n");
					flatFile.append("GROUP_ID:").append(rejectEdiMstVO.getEdiGroupId()).append("\n");
					flatFile.append("BKG_VIA:").append(rejectEdiMstVO.getIbIeInd()   ).append("\n");
					flatFile.append("BKG_CUST_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("BKG_SH_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("BKG_FF_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SI_CUST_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SI_SH_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SI_FF_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
				} else {
					flatFile.append("BKGNBR:\n");
					flatFile.append("BKG_DT:\n");
					flatFile.append("BRAC:\n");
					flatFile.append("BL_NO:\n");
					flatFile.append("BKG_LANE:\n");
					flatFile.append("BV_LANE:\n");
					flatFile.append("TOVSL:\n");
					flatFile.append("LOYD:\n");
					flatFile.append("VSLNAME:\n");
					flatFile.append("VSL_CALL_SIGN:\n");
					flatFile.append("VVD_REF_NO:\n");
					flatFile.append("TOVOY:\n");
					flatFile.append("TODIR:\n");
					flatFile.append("VSLLD:\n");
					flatFile.append("VSLD:\n");
					flatFile.append("OLDVSL:\n");
					flatFile.append("OLDLOYD:\n");
					flatFile.append("OLDVSLNAME:\n");
					flatFile.append("OLDVSL_CALL_SIGN:\n");
					flatFile.append("OLDVOY:\n");
					flatFile.append("OLDDIR:\n");
					flatFile.append("TVSL:\n");
					flatFile.append("TLOYD:\n");
					flatFile.append("TVSLNAME:\n");
					flatFile.append("TVSL_CALL_SIGN:\n");
					flatFile.append("TVOY:\n");
					flatFile.append("TDIR:\n");
					flatFile.append("POR_NAME:\n");
					flatFile.append("POR_QUAL:\n");
					flatFile.append("POR_PORT:\n");
					flatFile.append("POR_UNLC:\n");
					flatFile.append("POL_NAME:\n");
					flatFile.append("POL_QUAL:\n");
					flatFile.append("POL_PORT:\n");
					flatFile.append("POL_UNLC:\n");
					flatFile.append("POL_ETA:\n");
					flatFile.append("POL_ETD:\n");
					flatFile.append("POL_ETD_7:\n");
					flatFile.append("BED:\n");
					flatFile.append("CCT:\n");
					flatFile.append("DCT:\n");
					flatFile.append("POD_NAME:\n");
					flatFile.append("POD_QUAL:\n");
					flatFile.append("POD_PORT:\n");
					flatFile.append("POD_UNLC:\n");
					flatFile.append("POD_ETA:\n");
					flatFile.append("POD_ETA_1:\n");
					flatFile.append("POD_ETD:\n");
					flatFile.append("DEL_NAME:\n");
					flatFile.append("DEL_QUAL:\n");
					flatFile.append("DEL_PORT:\n");
					flatFile.append("DEL_UNLC:\n");
					flatFile.append("DEL_ETA:\n");
					flatFile.append("RLY_NAME:\n");
					flatFile.append("RLY_QUAL:\n");
					flatFile.append("RLY_PORT:\n");
					flatFile.append("RLY_UNLC:\n");
					flatFile.append("RLY_ETA:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY_ETD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_NAME:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_QUAL:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_PORT:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_UNLC:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_ETA:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("RLY2_ETD:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_NAME:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_QUAL:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_PORT:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_UNLC:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("FNLDST_ETA:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("PUNIT:\n");
					flatFile.append("PKG:\n");
					flatFile.append("WUNIT:\n");
					flatFile.append("WGT:\n");
					flatFile.append("EWUNIT:\n");
					flatFile.append("EWGT:\n");
					flatFile.append("MUNIT:\n");
					flatFile.append("MEAS:\n");
					flatFile.append("RDTYP:\n");
					flatFile.append("SMOD:\n");
					flatFile.append("TRUCK:\n");
					flatFile.append("REMARK:\n");
					flatFile.append("CMD:\n");
					flatFile.append("CMDD:\n");
					flatFile.append("EQREL:\n");
					flatFile.append("SHN1:\n");
					flatFile.append("FFN1:\n");
					flatFile.append("CNE1:\n");
					flatFile.append("SH_CD1:\n");
					flatFile.append("FF_CD1:\n");
					flatFile.append("CN_CD1:\n");
					flatFile.append("SHPR1:\n");
					flatFile.append("SHPR2:\n");
					flatFile.append("SHPR3:\n");
					flatFile.append("SHPR4:\n");
					flatFile.append("SHPR5:\n");
					flatFile.append("CNEE1:\n");
					flatFile.append("CNEE2:\n");
					flatFile.append("CNEE3:\n");
					flatFile.append("CNEE4:\n");
					flatFile.append("CNEE5:\n");
					flatFile.append("NTFY1:\n");
					flatFile.append("NTFY2:\n");
					flatFile.append("NTFY3:\n");
					flatFile.append("NTFY4:\n");
					flatFile.append("NTFY5:\n");
					flatFile.append("CANCEL_BIT:\n");
					flatFile.append("CARGOTYPE:\n");
					flatFile.append("DR_IND:\n");
					flatFile.append("RF_IND:\n");
					flatFile.append("AK_IND:\n");
					flatFile.append("BB_IND:\n");
					flatFile.append("HD_IND:\n");
					flatFile.append("UD_IND:\n");
					flatFile.append("UD_CD:\n");
					flatFile.append("RD_IND:\n");
					flatFile.append("RF_CA:\n");
					flatFile.append("RF_MA:\n");
					flatFile.append("SOC_IND:\n");
					flatFile.append("SALES_OFFICE:\n");
					flatFile.append("SALES_NAME:\n");
					flatFile.append("BKG_STF:\n");
					flatFile.append("BKG_STF_NAME:\n");
					flatFile.append("BKG_STF_TEL:\n");
					flatFile.append("BKG_STF_FAX:\n");
					flatFile.append("CONTACT_NAME:\n");
					flatFile.append("CONTACT_TEL:\n");
					flatFile.append("BOUND_IND:\n");
					flatFile.append("REGIONAL_BKGNBR:\n");
					flatFile.append("CUST_REF_NO:\n");
					flatFile.append("REF_VOYAGE:\n");
					flatFile.append("SO_NO:\n");
					flatFile.append("BLKSTWG:\n");
					flatFile.append("EQPICKDT:\n");
					flatFile.append("EQRTN:\n");
					flatFile.append("PUCY_CNT:\n");
					flatFile.append("PUCY_CD:\n");
					flatFile.append("PUCY_NM:\n");
					flatFile.append("PUCY_ADDR1:\n");
					flatFile.append("PUCY_ADDR2:\n");
					flatFile.append("PUCY_ADDR3:\n");
					flatFile.append("PUCY_ADDR4:\n");
					flatFile.append("PUCY_ADDR5:\n");
					flatFile.append("RTCY_CNT:\n");
					flatFile.append("RTCY_CD:\n");
					flatFile.append("RTCY_NM:\n");
					flatFile.append("RTCY_ADDR1:\n");
					flatFile.append("RTCY_ADDR2:\n");
					flatFile.append("RTCY_ADDR3:\n");
					flatFile.append("RTCY_ADDR4:\n");
					flatFile.append("RTCY_ADDR5:\n");
					flatFile.append("BL_PO_NO:\n");
					flatFile.append("BL_SI_NO:\n");
					flatFile.append("FRT_TERM:\n");
					flatFile.append("ONBOARD:\n");
					flatFile.append("BKG_OFC:\n");
					flatFile.append("SC_NO:\n");
					flatFile.append("GROUP_ID:\n");
					flatFile.append("BKG_VIA:\n");
					flatFile.append("BKG_CUST_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("BKG_SH_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("BKG_FF_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SI_CUST_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SI_SH_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
					flatFile.append("SI_FF_REF_NO:\n"); /* NIS에서는 값을 보내지 않고 있음. */
				}

				if ( rejectEdiCntrVO.size() > 0 ) {
					for (int i=0;i<rejectEdiCntrVO.size();i++) {
						cntrVO = (RejectEdiCntrVO)rejectEdiCntrVO.get(i);
						flatFile.append("{CNTR_INFO\n");
						flatFile.append("CNTN:"           ).append(cntrVO.getACntrNo()            ).append("\n");
						flatFile.append("CNTT:"           ).append(cntrVO.getACntrTpsz()          ).append("\n");
						flatFile.append("SEAL:"           ).append(cntrVO.getASealNo()            ).append("\n");
						flatFile.append("RIND:"           ).append(cntrVO.getACntrRind()          ).append("\n");
						flatFile.append("DIND:"           ).append(cntrVO.getACntrDind()          ).append("\n");
						flatFile.append("AIND:"           ).append(cntrVO.getACntrAind()          ).append("\n");
						flatFile.append("BIND:"           ).append(cntrVO.getACntrBind()          ).append("\n");
						flatFile.append("PKG_QTY:\n");
						flatFile.append("PKG_TP:\n");
						flatFile.append("MEA_QTY:\n");
						flatFile.append("MEA_TP:\n");
						flatFile.append("WGT_QTY:"        ).append(cntrVO.getACntrWgtQty()        ).append("\n");
						flatFile.append("WGT_TP:"         ).append(cntrVO.getACntrWgtTp()         ).append("\n");
						flatFile.append("TEMP:"           ).append(cntrVO.getACntrTemp()          ).append("\n");
						flatFile.append("TUN:"            ).append(cntrVO.getACntrTun()           ).append("\n");
						flatFile.append("TEMP_C:"         ).append(cntrVO.getACntrTempC()         ).append("\n");
						flatFile.append("TUN_C:"          ).append(cntrVO.getACntrTunC()          ).append("\n");
						flatFile.append("RF_VOLTAGE:"     ).append(cntrVO.getACntrRfVoltage()     ).append("\n");
						flatFile.append("VENT:"           ).append(cntrVO.getACntrVent()          ).append("\n");
						flatFile.append("HUMID:"          ).append(cntrVO.getACntrHumid()         ).append("\n");
						flatFile.append("GENSET:"         ).append(cntrVO.getACntrGenset()        ).append("\n");
						flatFile.append("RF_REMARK:"      ).append(cntrVO.getACntrRfRemark()      ).append("\n");
						flatFile.append("RFDRY_IND:"      ).append(cntrVO.getACntrRfdryInd()      ).append("\n");
						flatFile.append("OVF:"            ).append(cntrVO.getACntrOvf()           ).append("\n");
						flatFile.append("OVR:"            ).append(cntrVO.getACntrOvr()           ).append("\n");
						flatFile.append("OVH:"            ).append(cntrVO.getACntrOvh()           ).append("\n");
						flatFile.append("OVLW:"           ).append(cntrVO.getACntrOvlw()          ).append("\n");
						flatFile.append("OVRW:"           ).append(cntrVO.getACntrOvrw()          ).append("\n");
						flatFile.append("OVWGT:"          ).append(cntrVO.getACntrOvwgt()         ).append("\n");
						flatFile.append("VOID_SLOT:"      ).append(cntrVO.getACntrVoidSlot()      ).append("\n");
						flatFile.append("STWG_REQ:"       ).append(cntrVO.getACntrStwgReq()       ).append("\n");
						flatFile.append("TTL_DIM_LEN:"    ).append(cntrVO.getACntrTtlDimLen()     ).append("\n");
						flatFile.append("TTL_DIM_WDT:"    ).append(cntrVO.getACntrTtlDimWdt()     ).append("\n");
						flatFile.append("TTL_DIM_HGT:"    ).append(cntrVO.getACntrTtlDimHgt()     ).append("\n");
						flatFile.append("TRM_TYPE:"       ).append(cntrVO.getACntrTrmType()       ).append("\n");
						flatFile.append("TRM_WEIGHT:"     ).append(cntrVO.getACntrTrmWeight()     ).append("\n");
						flatFile.append("TRM_HAULAGE:"    ).append(cntrVO.getACntrTrmHaulage()    ).append("\n");
						flatFile.append("TRM_HMODE:"      ).append(cntrVO.getACntrTrmHmode()      ).append("\n");
						flatFile.append("TRM_PICKUP_CY:"  ).append(cntrVO.getACntrTrmPickupCy()   ).append("\n");
						flatFile.append("TRM_RETURN_CY:"  ).append(cntrVO.getACntrTrmReturnCy()   ).append("\n");
						flatFile.append("TRM_INSTRUCTION:").append(cntrVO.getACntrTrmInstruction()).append("\n");
						flatFile.append("TRM_TRAN_DT:"    ).append(cntrVO.getACntrTrmTranDt()     ).append("\n");
						flatFile.append("TRM_TRAN_OFFICE:").append(cntrVO.getACntrTrmTranOffice() ).append("\n");
						flatFile.append("TRM_TRAN_NO:"    ).append(cntrVO.getACntrTrmTranNo()     ).append("\n");
						flatFile.append("USR_ID:"         ).append(cntrVO.getACntrUsrId()         ).append("\n");
						flatFile.append("CNTR_RCV_TERM:\n");
						flatFile.append("CNTR_DLV_TERM:\n");
						flatFile.append("{CNTR_TRO_DTL\n");
						flatFile.append("TRD_ADDR:\n");
						flatFile.append("TRD_DOOR_LOC:\n");
						flatFile.append("TRD_DOOR_POSTAL:\n");
						flatFile.append("TRD_DOOR_DT:\n");
						flatFile.append("TRD_PERSON:\n");
						flatFile.append("TRD_TEL:\n");
						flatFile.append("TRD_FAX:\n");
						flatFile.append("TRD_ACTSHIP:\n");
						flatFile.append("TRD_REMARK:\n");
						flatFile.append("}CNTR_TRO_DTL\n");
						flatFile.append("}CNTR_INFO\n");
					}
				}else {
					flatFile.append("{CNTR_INFO\n");
					flatFile.append("CNTN:\n");
					flatFile.append("CNTT:\n");
					flatFile.append("SEAL:\n");
					flatFile.append("RIND:\n");
					flatFile.append("DIND:\n");
					flatFile.append("AIND:\n");
					flatFile.append("BIND:\n");
					flatFile.append("PKG_QTY:\n");
					flatFile.append("PKG_TP:\n");
					flatFile.append("MEA_QTY:\n");
					flatFile.append("MEA_TP:\n");
					flatFile.append("WGT_QTY:\n");
					flatFile.append("WGT_TP:\n");
					flatFile.append("TEMP:\n");
					flatFile.append("TUN:\n");
					flatFile.append("TEMP_C:\n");
					flatFile.append("TUN_C:\n");
					flatFile.append("RF_VOLTAGE:\n");
					flatFile.append("VENT:\n");
					flatFile.append("HUMID:\n");
					flatFile.append("GENSET:\n");
					flatFile.append("RF_REMARK:\n");
					flatFile.append("RFDRY_IND:\n");
					flatFile.append("OVF:\n");
					flatFile.append("OVR:\n");
					flatFile.append("OVH:\n");
					flatFile.append("OVLW:\n");
					flatFile.append("OVRW:\n");
					flatFile.append("OVWGT:\n");
					flatFile.append("VOID_SLOT:\n");
					flatFile.append("STWG_REQ:\n");
					flatFile.append("TTL_DIM_LEN:\n");
					flatFile.append("TTL_DIM_WDT:\n");
					flatFile.append("TTL_DIM_HGT:\n");
					flatFile.append("TRM_TYPE:\n");
					flatFile.append("TRM_WEIGHT:\n");
					flatFile.append("TRM_HAULAGE:\n");
					flatFile.append("TRM_HMODE:\n");
					flatFile.append("TRM_PICKUP_CY:\n");
					flatFile.append("TRM_RETURN_CY:\n");
					flatFile.append("TRM_INSTRUCTION:\n");
					flatFile.append("TRM_TRAN_DT:\n");
					flatFile.append("TRM_TRAN_OFFICE:\n");
					flatFile.append("TRM_TRAN_NO:\n");
					flatFile.append("USR_ID:\n");
					flatFile.append("CNTR_RCV_TERM:\n");
					flatFile.append("CNTR_DLV_TERM:\n");
					flatFile.append("{CNTR_TRO_DTL\n");
					flatFile.append("TRD_ADDR:\n");
					flatFile.append("TRD_DOOR_LOC:\n");
					flatFile.append("TRD_DOOR_POSTAL:\n");
					flatFile.append("TRD_DOOR_DT:\n");
					flatFile.append("TRD_PERSON:\n");
					flatFile.append("TRD_TEL:\n");
					flatFile.append("TRD_FAX:\n");
					flatFile.append("TRD_ACTSHIP:\n");
					flatFile.append("TRD_REMARK:\n");
					flatFile.append("}CNTR_TRO_DTL\n");
					flatFile.append("}CNTR_INFO\n");
				}
				
				if ( rejectEdiDgVO.size() > 0 ) {
					for (int k=0;k<rejectEdiDgVO.size();k++) {
						dgVO = (RejectEdiDgVO)rejectEdiDgVO.get(k);
						flatFile.append("{CNTR_DANGER\n");
						flatFile.append("UNBR:"      ).append(dgVO.getADgUnbr()     ).append("\n");
						flatFile.append("CLAS:"      ).append(dgVO.getADgClas()     ).append("\n");
						flatFile.append("DESC:"      ).append(dgVO.getADgDesc()     ).append("\n");
						flatFile.append("PHON:"      ).append(dgVO.getADgPhon()     ).append("\n");
						flatFile.append("PAGE:"      ).append(dgVO.getADgPage()     ).append("\n");
						flatFile.append("FPNT:"      ).append(dgVO.getADgFpnt()     ).append("\n");
						flatFile.append("FPUN:"      ).append(dgVO.getADgFpun()     ).append("\n");
						flatFile.append("DG_REMARK:" ).append(dgVO.getADgDgRemark() ).append("\n");
						flatFile.append("EMSNO:"     ).append(dgVO.getADgEmsno()    ).append("\n");
						flatFile.append("PSACLS:"    ).append(dgVO.getADgPsacls()   ).append("\n");
						flatFile.append("PKGGRP:"    ).append(dgVO.getADgPkggrp()   ).append("\n");
						flatFile.append("MFAG1:"     ).append(dgVO.getADgMfag1()    ).append("\n");
						flatFile.append("MFAG2:"     ).append(dgVO.getADgMfag2()    ).append("\n");
						flatFile.append("MAR_POLL:"  ).append(dgVO.getADgMarPoll()  ).append("\n");
						flatFile.append("LABEL_CD:"  ).append(dgVO.getADgLabelCd()  ).append("\n");
						flatFile.append("LABEL_DESC:").append(dgVO.getADgLabelDesc()).append("\n");
						flatFile.append("D_PKG:"     ).append(dgVO.getADgDPkg()     ).append("\n");
						flatFile.append("D_PKGUNIT:" ).append(dgVO.getADgDPkgunit() ).append("\n");
						flatFile.append("NWGT:"      ).append(dgVO.getADgNwgt()     ).append("\n");
						flatFile.append("NWGT_UNIT:" ).append(dgVO.getADgNwgtUnit() ).append("\n");
						flatFile.append("GWGT:"      ).append(dgVO.getADgGwgt()     ).append("\n");
						flatFile.append("GWGT_UNIT:" ).append(dgVO.getADgGwgtUnit() ).append("\n");
						flatFile.append("MEA:"       ).append(dgVO.getADgMea()      ).append("\n");
						flatFile.append("MEA_UNIT:"  ).append(dgVO.getADgMeaUnit()  ).append("\n");
						flatFile.append("HAZ_CONT:"  ).append(dgVO.getADgHazCont()  ).append("\n");
						flatFile.append("STWG:"      ).append(dgVO.getADgStwg()     ).append("\n");
						flatFile.append("LABEL:"     ).append(dgVO.getADgLabel()    ).append("\n");
						flatFile.append("PROPER_SHIP_NAME:\n");
						flatFile.append("CONT_TPSZ:\n");
						flatFile.append("CARGO_SEQ:\n");
						flatFile.append("}CNTR_DANGER\n");
					}
				} else {
					flatFile.append("{CNTR_DANGER\n");
					flatFile.append("UNBR:\n");
					flatFile.append("CLAS:\n");
					flatFile.append("DESC:\n");
					flatFile.append("PHON:\n");
					flatFile.append("PAGE:\n");
					flatFile.append("FPNT:\n");
					flatFile.append("FPUN:\n");
					flatFile.append("DG_REMARK:\n");
					flatFile.append("EMSNO:\n");
					flatFile.append("PSACLS:\n");
					flatFile.append("PKGGRP:\n");
					flatFile.append("MFAG1:\n");
					flatFile.append("MFAG2:\n");
					flatFile.append("MAR_POLL:\n");
					flatFile.append("LABEL_CD:\n");
					flatFile.append("LABEL_DESC:\n");
					flatFile.append("D_PKG:\n");
					flatFile.append("D_PKGUNIT:\n");
					flatFile.append("NWGT:\n");
					flatFile.append("NWGT_UNIT:\n");
					flatFile.append("GWGT:\n");
					flatFile.append("GWGT_UNIT:\n");
					flatFile.append("MEA:\n");
					flatFile.append("MEA_UNIT:\n");
					flatFile.append("HAZ_CONT:\n");
					flatFile.append("STWG:\n");
					flatFile.append("LABEL:\n");
					flatFile.append("PROPER_SHIP_NAME:\n");
					flatFile.append("CONT_TPSZ:\n");
					flatFile.append("CARGO_SEQ:\n");
					flatFile.append("}CNTR_DANGER\n");
				}	
				if ( rejectEdiQtyVO.size() > 0 ) {
					for (int i=0;i<rejectEdiQtyVO.size();i++) {
						qtyVO = (RejectEdiQtyVO)rejectEdiQtyVO.get(i);
						flatFile.append("{BL_CNTR\n");
						flatFile.append("HTYP:").append(qtyVO.getAQtyCntrCd() ).append("\n");
						flatFile.append("ITYP:").append(qtyVO.getAQtyItyp()   ).append("\n");
						flatFile.append("CNT:" ).append(qtyVO.getAQtyBqtyQty()).append("\n");
						flatFile.append("}BL_CNTR\n");
					}
				} else {
					flatFile.append("{BL_CNTR\n");
					flatFile.append("HTYP:\n");
					flatFile.append("ITYP:\n");
					flatFile.append("CNT:\n");
					flatFile.append("}BL_CNTR\n");
					
				}
				if ( rejectEdiVvdVO.size() > 0 ) {
					for (int j=0;j<rejectEdiVvdVO.size();j++) {
						RejectEdiVvdVO vvdVO = (RejectEdiVvdVO)rejectEdiVvdVO.get(j);
						flatFile.append("{BL_VVD\n");
						flatFile.append("VVDCODE:"         ).append(vvdVO.getVvdcode()       ).append("\n");
						flatFile.append("VVDLOYD:"         ).append(vvdVO.getVvdloyd ()      ).append("\n");
						flatFile.append("VVDVSLNAME:"      ).append(vvdVO.getVvdvslname ()   ).append("\n");
						flatFile.append("VVDVSL_CALL_SIGN:").append(vvdVO.getVvdvslCallSign()).append("\n");
						flatFile.append("VVDVOY:"          ).append(vvdVO.getVvdvoy()        ).append("\n");
						flatFile.append("VVDDIR:"          ).append(vvdVO.getVvddir()        ).append("\n");
						flatFile.append("VVDPOLUNLC:"      ).append(vvdVO.getVvdpolunlc()    ).append("\n");
						flatFile.append("VVDPOLNAME:"      ).append(vvdVO.getVvdpolname()    ).append("\n");
						flatFile.append("VVDPODUNLC:"      ).append(vvdVO.getVvdpodunlc()    ).append("\n");
						flatFile.append("VVDPODNAME:"      ).append(vvdVO.getVvdpodname()    ).append("\n");
						flatFile.append("REF1VVDVOY:"      ).append(vvdVO.getRef1vvdvoy()    ).append("\n");
						flatFile.append("VVDPOLETA:").append(vvdVO.getVvdpoleta()).append("\n");
						flatFile.append("VVDPOLETD:").append(vvdVO.getVvdpoletd()).append("\n");
						flatFile.append("VVDPODETA:").append(vvdVO.getVvdpodeta()).append("\n");
						flatFile.append("}BL_VVD\n");
					}
				} else {
					flatFile.append("{BL_VVD\n");
					flatFile.append("VVDCODE:\n");
					flatFile.append("VVDLOYD:\n");
					flatFile.append("VVDVSLNAME:\n");
					flatFile.append("VVDVSL_CALL_SIGN:\n");
					flatFile.append("VVDVOY:\n");
					flatFile.append("VVDDIR:\n");
					flatFile.append("VVDPOLUNLC:\n");
					flatFile.append("VVDPOLNAME:\n");
					flatFile.append("VVDPODUNLC:\n");
					flatFile.append("VVDPODNAME:\n");
					flatFile.append("REF1VVDVOY:\n");
					flatFile.append("VVDPOLETA:\n");
					flatFile.append("VVDPOLETD:\n");
					flatFile.append("VVDPODETA:\n");
					flatFile.append("}BL_VVD\n");
				}
				
				flatFile.append("{PO_INFO\n");
				flatFile.append("PO_BKG:\n");
				flatFile.append("PO_NO:\n");
				flatFile.append("PO_CNTR:\n");
				flatFile.append("PO_SEQ:\n");
				flatFile.append("PO_STOCK_NO:\n");
				flatFile.append("PO_DESC:\n");
				flatFile.append("PO_PKGU:\n");
				flatFile.append("PO_PKG_QTY:\n");
				flatFile.append("PO_WGTU:\n");
				flatFile.append("PO_WGT:\n");
				flatFile.append("PO_MEAU:\n");
				flatFile.append("PO_MEA:\n");
				flatFile.append("}PO_INFO\n");

				if ( rejectEdiDescVO.size() > 0 ) {
					for (int l=0;l<rejectEdiDescVO.size();l++) {
						descVO = (RejectEdiDescVO)rejectEdiDescVO.get(l);
						flatFile.append("{DESC\n");
						flatFile.append("DESC:").append(descVO.getBlDesc()).append("\n");
						flatFile.append("}DESC\n");
					}					
				} else {
					flatFile.append("{DESC\n");
					flatFile.append("DESC:\n");
					flatFile.append("}DESC\n");
				}
				
				flatFile.append("{CM_MARK_DESC\n");
				flatFile.append("CMD_SEQ:\n");
				flatFile.append("CMD_CNTR_NO:\n");
				flatFile.append("CMD_HTS_CD:\n");
				flatFile.append("CMD_PKG_CD:\n");
				flatFile.append("CMD_PKG_QTY:\n");
				flatFile.append("CMD_WGT_TP:\n");
				flatFile.append("CMD_WGT_QTY:\n");
				flatFile.append("CMD_MEA_TP:\n");
				flatFile.append("CMD_MEA_QTY:\n");
				flatFile.append("CMD_DESC:\n");
				flatFile.append("CMD_MARK:\n");
				flatFile.append("}CM_MARK_DESC\n");
				

				if ( rejectEdiInstrVO != null ) {
					flatFile.append("{I_BKG_INFO\n");
					flatFile.append("IB_EDI_ORG_ID:").append(rejectEdiInstrVO.getIbEdiOrgId()).append("\n");
					flatFile.append("IB_EDI_ID:"    ).append(rejectEdiInstrVO.getIbEdiId()   ).append("\n");
					flatFile.append("IB_POL_CD:"    ).append(rejectEdiInstrVO.getIbPolCd()   ).append("\n");
					flatFile.append("IB_POD_CD:"    ).append(rejectEdiInstrVO.getIbPodCd()   ).append("\n");
					flatFile.append("IB_PICKUP_DT:").append(rejectEdiInstrVO.getMtyPkupDt()).append("\n");
					flatFile.append("IB_ARV_R_DT:"  ).append(rejectEdiInstrVO.getRqstArrDt()  ).append("\n");
					flatFile.append("CNTRTS_CD:"    ).append(rejectEdiInstrVO.getCntrtsCd()   ).append("\n");
					flatFile.append("IBI_POR_CD:"   ).append(rejectEdiInstrVO.getPorCtnt()    ).append("\n");
					flatFile.append("IBI_POR_NM:"   ).append(rejectEdiInstrVO.getPorNm  ()    ).append("\n");
					flatFile.append("IBI_POL_CD:"   ).append(rejectEdiInstrVO.getPolCtnt()    ).append("\n");
					flatFile.append("IBI_POL_NM:"   ).append(rejectEdiInstrVO.getPolNm  ()    ).append("\n");
					flatFile.append("IBI_POD_CD:"   ).append(rejectEdiInstrVO.getPodCtnt()    ).append("\n");
					flatFile.append("IBI_POD_NM:"   ).append(rejectEdiInstrVO.getPodNm  ()    ).append("\n");
					flatFile.append("IBI_DEL_CD:"   ).append(rejectEdiInstrVO.getDelCtnt()    ).append("\n");
					flatFile.append("IBI_DEL_NM:"   ).append(rejectEdiInstrVO.getDelNm  ()    ).append("\n");
					flatFile.append("IBI_TRANS_IND:").append(rejectEdiInstrVO.getTrnsIndCtnt()).append("\n");
					flatFile.append("}I_BKG_INFO\n");
				} else {
					flatFile.append("{I_BKG_INFO\n");
					flatFile.append("IB_EDI_ORG_ID:\n");
					flatFile.append("IB_EDI_ID:\n");
					flatFile.append("IB_POL_CD:\n");
					flatFile.append("IB_POD_CD:\n");
					flatFile.append("IB_PICKUP_DT:\n");
					flatFile.append("IB_ARV_R_DT:\n");
					flatFile.append("CNTRTS_CD:\n");
					flatFile.append("IBI_POR_CD:\n");
					flatFile.append("IBI_POR_NM:\n");
					flatFile.append("IBI_POL_CD:\n");
					flatFile.append("IBI_POL_NM:\n");
					flatFile.append("IBI_POD_CD:\n");
					flatFile.append("IBI_POD_NM:\n");
					flatFile.append("IBI_DEL_CD:\n");
					flatFile.append("IBI_DEL_NM:\n");
					flatFile.append("IBI_TRANS_IND:\n");
					flatFile.append("}I_BKG_INFO\n");
				}
				
				if ( rejectEdiCustVO.size() > 0 ) {
					for (int k=0;k<rejectEdiCustVO.size();k++) {
						RejectEdiCustVO custVO = (RejectEdiCustVO)rejectEdiCustVO.get(k);
						flatFile.append("{I_BKG_CUST\n");
						flatFile.append("IBCS_TP:"      ).append(custVO.getIbcsTp()     ).append("\n");
						flatFile.append("IBCS_NM1:"     ).append(custVO.getIbcsNm1()    ).append("\n");
						flatFile.append("IBCS_NM2:"     ).append(custVO.getIbcsNm2()    ).append("\n");
						flatFile.append("IBCS_ADDR1:"   ).append(custVO.getIbcsAddr1()  ).append("\n");
						flatFile.append("IBCS_ADDR2:"   ).append(custVO.getIbcsAddr2()  ).append("\n");
						flatFile.append("IBCS_ADDR3:"   ).append(custVO.getIbcsAddr3()  ).append("\n");
						flatFile.append("IBCS_C_NM1:"   ).append(custVO.getIbcsCNm1()   ).append("\n");
						flatFile.append("IBCS_C_NM2:"   ).append(custVO.getIbcsCNm2()   ).append("\n");
						flatFile.append("CNT_CD:"       ).append(custVO.getCntCd()      ).append("\n");
						flatFile.append("CUST_CD:"      ).append(custVO.getCustCd()     ).append("\n");
						flatFile.append("IBCS_CUST_LOC:").append(custVO.getIbcsCustLoc()).append("\n");
						flatFile.append("IBCS_STREET:"  ).append(custVO.getIbcsStreet() ).append("\n");
						flatFile.append("IBCS_LOC_CD:"  ).append(custVO.getIbcsLocCd()  ).append("\n");
						flatFile.append("IBCS_LOC_NM:"  ).append(custVO.getIbcsLocNm()  ).append("\n");
						flatFile.append("IBCS_ZIP_CD:"  ).append(custVO.getIbcsZipCd()  ).append("\n");
						flatFile.append("IBCS_C_TP:"    ).append(custVO.getIbcsCTp()    ).append("\n");
						flatFile.append("IBCS_C_TEL:"   ).append(custVO.getIbcsCTel()   ).append("\n");
						flatFile.append("IBCS_C_FAX:"   ).append(custVO.getIbcsCFax()   ).append("\n");
						flatFile.append("IBCS_C_EMAIL:" ).append(custVO.getIbcsCEmail() ).append("\n");
						flatFile.append("}I_BKG_CUST\n");
					}
				} else {
					flatFile.append("{I_BKG_CUST\n");
					flatFile.append("IBCS_TP:\n");
					flatFile.append("IBCS_NM1:\n");
					flatFile.append("IBCS_NM2:\n");
					flatFile.append("IBCS_ADDR1:\n");
					flatFile.append("IBCS_ADDR2:\n");
					flatFile.append("IBCS_ADDR3:\n");
					flatFile.append("IBCS_C_NM1:\n");
					flatFile.append("IBCS_C_NM2:\n");
					flatFile.append("CNT_CD:\n");
					flatFile.append("CUST_CD:\n");
					flatFile.append("IBCS_CUST_LOC:\n");
					flatFile.append("IBCS_STREET:\n");
					flatFile.append("IBCS_LOC_CD:\n");
					flatFile.append("IBCS_LOC_NM:\n");
					flatFile.append("IBCS_ZIP_CD:\n");
					flatFile.append("IBCS_C_TP:\n");
					flatFile.append("IBCS_C_TEL:\n");
					flatFile.append("IBCS_C_FAX:\n");
					flatFile.append("IBCS_C_EMAIL:\n");
					flatFile.append("}I_BKG_CUST \n");
				}
				
				flatFile.append("{I_CM_MARK_DESC\n");
				flatFile.append("ICMD_SEQ:\n");
				flatFile.append("ICMD_CNTR_NO:\n");
				flatFile.append("ICMD_HTS_CD:\n");
				flatFile.append("ICMD_PKG_CD:\n");
				flatFile.append("ICMD_PKG_QTY:\n");
				flatFile.append("ICMD_WGT_TP:\n");
				flatFile.append("ICMD_WGT_QTY:\n");
				flatFile.append("ICMD_MEA_TP:\n");
				flatFile.append("ICMD_MEA_QTY:\n");
				flatFile.append("ICMD_DESC:\n");
				flatFile.append("ICMD_DESC_DTL:\n");
				flatFile.append("ICMD_MARK:\n");
				flatFile.append("}I_CM_MARK_DESC\n");
				
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				log.debug("\nflatFile:"+flatFile.toString());
				String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER_301.IBMMQ.QUEUE");
				log.debug("QUEUE NAME:"+queueNm);
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());
				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			} else if("APERAK".equals(rejectEdiType)) {
				rjctSndrRcvrVO = dbDao.searchRejectEdiHeader(xterRqstNoVO.getSenderId());
				ediHeader = bcUtil.searchEdiHeader(rjctSndrRcvrVO.getSndrId(), xterRqstNoVO.getSenderId(), "APERAK");
				ediBody = dbDao.searchXterRqstRejectAperakEdi(xterRqstNoVO, rjctSndrRcvrVO.getSndrId());
				flatFile.append(ediHeader).append("\n");
				flatFile.append(ediBody).append("\n");
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				log.debug("\nflatFile2:"+flatFile.toString());
				String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ACK.IBMMQ.QUEUE");
				log.debug("QUEUE NAME:"+queueNm);
				sendFlatFileVO.setQueueNm(queueNm);
				FlatFileAckVO flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());
				if ( flatFileAckVO.getAckStsCd().equals("E") )
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				
			} else {
				if ( "CHN".equals(svrId)) {
					hostTpId = bcUtil.searchEdi301HostId(xterRqstNoVO.getSenderId(), "CUST");
					ediHeader = bcUtil.searchEdiHeader(hostTpId, xterRqstNoVO.getSenderId(), "APERAK");
					ediBody = dbDao.searchXterRqstRejectEdi(xterRqstNoVO, account.getUsr_id());
	
					flatFile.append(ediHeader).append("\n");
					flatFile.append(ediBody).append("\n");
					
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACK.IBMMQ.QUEUE");
					log.debug("QUEUE NAME:"+queueNm);
					sendFlatFileVO.setQueueNm(queueNm);
					FlatFileAckVO flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
					log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());
					if ( flatFileAckVO.getAckStsCd().equals("E") )
						throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				}
			}	// if ( "Y".equals(rejectEdiType) )
			
//			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
//			sendFlatFileVO.setFlatFile(flatFile.toString());
//			String queueNm = ( "Y".equals(rejectEdiType) )?SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER_301.IBMMQ.QUEUE"):SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACK.IBMMQ.QUEUE");
//			log.debug("QUEUE NAME:"+queueNm);
//			sendFlatFileVO.setQueueNm(queueNm);
//			FlatFileAckVO flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
//			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

//			if ( flatFileAckVO.getAckStsCd().equals("E") )
//				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

			log.debug("RESULT:"+flatFile.toString());
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	/**
	 * external request에 대해 Ack Edi Flatfile을 만든다.<br> 
	 * (send_NIS2010BKG_UBIZHJS_ACK)<br>
	 *
	 * @param String docTpCd
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws EventException 
	 */
	public String createXterBkgAckEdi(String docTpCd, XterRqstNoVO xterRqstNoVO) throws EventException {
        BookingUtil bcUtil = null;
		String ackRcv = null;
		String flatFile = "";
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		try {
	        bcUtil = new BookingUtil();

			ackRcv = dbDao.searchXterBkgAckReceiver(xterRqstNoVO.getSenderId(), xterRqstNoVO.getRqstNo(), xterRqstNoVO.getRqstSeq());
			if ( !isNull(ackRcv) && "Y".equals(ackRcv) ) {
				//APERAK
				flatFile = dbDao.searchXterBkgAck(docTpCd, xterRqstNoVO);

				sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile);
				String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ACK.IBMMQ.QUEUE");
				log.debug("QUEUE NAME:"+queueNm);
				sendFlatFileVO.setQueueNm(queueNm);
				flatFileAckVO = bcUtil.sendFlatFile(sendFlatFileVO);
				log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

				if ( "E".equals(flatFileAckVO.getAckStsCd()) ) {
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				}
				log.debug("RESULT:"+flatFile);
			}
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return flatFile;
	}
   	/**
	 * Char Count<br>
	 *
	 * @param String   src
	 * @param char   c
	 * @return int
	 */
	private int countChar(String src,char c) {
		int count=0;
		if (src!=null) {
			for (int i=0;i<src.length();i++) {
				if (src.charAt(i)==c) {
					count++;
				}
			}
		}
		return count;
	}
   	/**
	 * String split<br>
	 *
	 * @param String   src
	 * @param char   sep
	 * @return String[]
	 */
	private String[] splitString(String src,char sep) {
		String[] dest=null;
		if (src!=null && src.length()>0) {
			int count=countChar(src,sep)+1;
			int startIndex=0;
			int endIndex=0;
			dest=new String[count];
			for (int i=0;i<count;i++) {
				if ((endIndex=src.indexOf(sep,startIndex))<0) {
					endIndex=src.length();
				}
				dest[i]=src.substring(startIndex,endIndex);
				startIndex=endIndex+1;
			}
		}
		return dest;
	}
   	/**
	 * Char remove<br>
	 *
	 * @param String   str
	 * @param char   delim
	 * @return String
	 */
	private String remove(String str, char delim){
		if (str == null || str.length() == 0 || delim == 0 ) {
            return str;
        }
		char[] chars = str.toCharArray();
		StringBuffer buffer = new StringBuffer(str.length());
		int len = chars.length;
		for(int i = 0; i<len ; i++){
			if(chars[i] != delim) buffer.append(chars[i]);
		}
		return buffer.toString();
	}
   	/**
	 * Null replace<br>
	 *
	 * @param String str
	 * @return String
	 */
    private String replaceNull(String str) {
        return (str==null)?"":str;
    }
   	/**
	 * Null 체크<br>
	 *
	 * @param String str
	 * @return boolean
	 */
    private boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }

   	/**
	 * 첫번째 sep만 split하여 리턴<br>
	 *
	 * @param String   str
	 * @param String   sep
	 * @return String[]
	 */
	private String[] splitByToken(String str, String sep) {
        String[] retStr = new String[2];

        int splitNo = str.indexOf(sep);
	    retStr[0] = str.substring(0, splitNo);
	    retStr[1] = str.substring(splitNo+1, str.length());

        return retStr;
    }
	
   	/**
	 * 채번된 bkg_no, bkg_no_split을 assign한다.<br>
	 * booking receipt 자동 전송 대상 업체일 경우 booking receipt를 보낸다.
	 * (ebkg이 아닌 일반 booking에서 보내는 booking receipt와는 flatfile이 다르다)<br>
	 * E-BKG Receipt ACK EDI 전송<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @throws EventException 
	 */
	public void assignBkgNoToXterRqst(XterRqstNoVO rqstNoVo) throws EventException {
		BookingUtil utilBC = null;		
		String xterBkgBlNo = null;
		BkgBlNoVO bkgBlNoVO = null;
		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = null;
		List<BkgHrdCdgCtntVO> ackReceiver = null;
		String senderId = null;
		StringBuilder flatFileSB = null;
		String flatFile = "";
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		utilBC = new BookingUtil();	
		try {
			if(rqstNoVo.getSenderId() == null) return;

/**********************************************************
// 			bkg no 자동 채번 대상인지 확인한다. 
//			1. 삼성전자 Booking Request의 경우, 자동으로 Booking Confirmation 문서를 생성한다.
//          2. 범한물류 Shipping Instructions(Master,seq1)의 경우, 자동으로 Booking Number를 생성한다.
**********************************************************/
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO2 = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO2.setHrdCdgId("XTER_AUTO_BKG_NO");
			bkgHrdCdgCtntListCondVO2.setAttrCtnt1(rqstNoVo.getSenderId());
			bkgHrdCdgCtntListCondVO2.setAttrCtnt2(rqstNoVo.getDocTpCd());
			List<BkgHrdCdgCtntVO> bkgNoAssign = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO2);
			if(bkgNoAssign.size() > 0){
				if(rqstNoVo.getSenderId().equals("PKEXM010") && !"H".equals(replaceNull(rqstNoVo.getXterBlTpCd())) && rqstNoVo.getRqstSeq().equals("1")){
					log.debug("PKEXM010+master rqst 진행");
//					return rqstNoVo;
				} else if(!rqstNoVo.getSenderId().equals("PKEXM010") ) {
					log.debug("PKEXM010 rqst 진행");
//					return rqstNoVo;
				} else {
					return ;
				}
			} else {
				return ;
			}
			xterBkgBlNo = dbDao.searchXterRqstMstBkgNo(rqstNoVo);
			rqstNoVo.setBkgNo(xterBkgBlNo);
			if (xterBkgBlNo == null ) {					
				bkgBlNoVO = utilBC.manageBkgNumberGeneration("BKG", "SELSC", "SYSTEM");
				rqstNoVo.setBkgNo(bkgBlNoVO.getBkgNo() + "00"); 
			}
			// rqst 건에 bkg_no를 update
			dbDao.assignBkgNoToXterRqst(rqstNoVo);
			
			// auto confirm(자동으로 ack 전송) 대상인지 확인한다.
			bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("XTER_AUTO_BKG_RCT");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(rqstNoVo.getSenderId());
			ackReceiver = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			if (ackReceiver.size()==0) return;
			
//			if (rqstNoVo.getSenderId().substring(0,4).equals("C1T0")
//					||rqstNoVo.getSenderId().substring(0,4).equals("C1S0")){
//				senderId = "C1T0WSML1";
//			} else if(rqstNoVo.getSenderId().substring(0,5).equals("110AL")){ 
//				senderId = "C1T0WSML1";	
//			} else {
//				senderId = "SMLINE"; //
//			}
			
			senderId = dbDao.searchHostTradePartnerId(rqstNoVo.getSenderId());
			//flatfile 생성
			flatFileSB = new StringBuilder();
			String [] flatFileStr = new String[6];
			flatFileSB.append(utilBC.searchEdiHeader(senderId, rqstNoVo.getSenderId(), "BOKCON") + "\n");
			
			flatFileStr[0] = dbDao.searchXterRqstMstForAck(rqstNoVo);				
			flatFileStr[1] = dbDao.searchXterRqstMiscForAck(rqstNoVo);
			flatFileStr[2] = dbDao.searchXterCustForAck(rqstNoVo);
			flatFileStr[3] = dbDao.searchXterTroForAck(rqstNoVo);
			flatFileStr[4] = dbDao.searchXterTroDtlForAck(rqstNoVo);
			flatFileStr[5] = dbDao.searchXterDescForAck(rqstNoVo);
			
			for(int i = 0; i < 6; i++){
				if(flatFileStr[i] != null){
//					log.debug("flatFileStr[i]:"+flatFileStr[i]);
					flatFileSB.append(flatFileStr[i]);
				}
			}				

			flatFile = flatFileSB.toString();				
			log.debug("FlatFile:" + flatFile);
			
			// auto confirm edi flatfile 전송
			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

			// auto confirm을 보냈음을 기록함
			dbDao.modifyAutoBkgRctSend(rqstNoVo);
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 신규 추가된 TP에 대해 BKG 신규 생성 후 BOKCON 발송기능 추가
	 * 
	 * @param XterRqstNoVO rqstNoVo
	 * @throws EventException
	 */
	public void sendBOKCON(XterRqstNoVO rqstNoVo) throws EventException {
		BookingUtil utilBC = null;		
//		String xterBkgBlNo = null;
//		BkgBlNoVO bkgBlNoVO = null;
		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = null;
		List<BkgHrdCdgCtntVO> ackReceiver = null;
		String senderId = null;
		StringBuilder flatFileSB = null;
		String flatFile = "";
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		utilBC = new BookingUtil();	
		try {
//			if(rqstNoVo.getSenderId() == null) return;
//
///**********************************************************
//// 			bkg no 자동 채번 대상인지 확인한다. 
////			1. 삼성전자 Booking Request의 경우, 자동으로 Booking Confirmation 문서를 생성한다.
////          2. 범한물류 Shipping Instructions(Master,seq1)의 경우, 자동으로 Booking Number를 생성한다.
//**********************************************************/
//			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO2 = new BkgHrdCdgCtntListCondVO();
//			bkgHrdCdgCtntListCondVO2.setHrdCdgId("XTER_AUTO_BKG_NO");
//			bkgHrdCdgCtntListCondVO2.setAttrCtnt1(rqstNoVo.getSenderId());
//			bkgHrdCdgCtntListCondVO2.setAttrCtnt2(rqstNoVo.getDocTpCd());
//			List<BkgHrdCdgCtntVO> bkgNoAssign = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO2);
//			if(bkgNoAssign.size() > 0){
//				if(rqstNoVo.getSenderId().equals("PKEXM010") && !"H".equals(replaceNull(rqstNoVo.getXterBlTpCd())) && rqstNoVo.getRqstSeq().equals("1")){
//					log.debug("PKEXM010+master rqst 진행");
//				} else if(!rqstNoVo.getSenderId().equals("PKEXM010") ) {
//					log.debug("PKEXM010 rqst 진행");
//				} else {
//					return ;
//				}
//			} else {
//				return ;
//			}
//			xterBkgBlNo = dbDao.searchXterRqstMstBkgNo(rqstNoVo);
//			rqstNoVo.setBkgNo(xterBkgBlNo);
//			if (xterBkgBlNo == null ) {					
//				bkgBlNoVO = utilBC.manageBkgNumberGeneration("BKG", "SELBB", "SYSTEM");
//				rqstNoVo.setBkgNo(bkgBlNoVO.getBkgNo() + "00"); 
//			}
//			// rqst 건에 bkg_no를 update
//			dbDao.assignBkgNoToXterRqst(rqstNoVo);
//			
			// auto confirm(자동으로 ack 전송) 대상인지 확인한다.
			bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("XTER_AUTO_BOKCON");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(rqstNoVo.getSenderId());
			ackReceiver = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			if (ackReceiver.size()==0) return;
			
//			if (rqstNoVo.getSenderId().substring(0,4).equals("C1T0")
//					||rqstNoVo.getSenderId().substring(0,4).equals("C1S0")){
//				senderId = "C1T0WSML1";
//			} else if(rqstNoVo.getSenderId().substring(0,5).equals("110AL")){ 
//				senderId = "C1T0WSML1";	
//			} else {
//				senderId = "HANJINSHIP";
//			}
			senderId = dbDao.searchHostTradePartnerId(rqstNoVo.getSenderId());
			//flatfile 생성
			flatFileSB = new StringBuilder();
			String [] flatFileStr = new String[6];
			flatFileSB.append(utilBC.searchEdiHeader(senderId, rqstNoVo.getSenderId(), "BOKCON") + "\n");
			
			flatFileStr[0] = dbDao.searchXterRqstMstForAck(rqstNoVo);				
			flatFileStr[1] = dbDao.searchXterRqstMiscForAck(rqstNoVo);
			flatFileStr[2] = dbDao.searchXterCustForAck(rqstNoVo);
			flatFileStr[3] = dbDao.searchXterTroForAck(rqstNoVo);
			flatFileStr[4] = dbDao.searchXterTroDtlForAck(rqstNoVo);
			flatFileStr[5] = dbDao.searchXterDescForAck(rqstNoVo);
			
			for(int i = 0; i < 6; i++){
				if(flatFileStr[i] != null){
//					log.debug("flatFileStr[i]:"+flatFileStr[i]);
					flatFileSB.append(flatFileStr[i]);
				}
			}				

			flatFile = flatFileSB.toString();				
			log.debug("FlatFile:" + flatFile);
			
			// auto confirm edi flatfile 전송
			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

			// auto confirm을 보냈음을 기록함
			dbDao.modifyAutoBkgRctSend(rqstNoVo);
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * bkg_xter_rqst에 upload 했다는 기록을 남긴다.<br>
	 * bkg no, confirm date, user, status 변경 등.<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void completeUpload(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException{
		XterShprInfoVO xterShprInfoVO = null;
		try {
			//bkg_xter_rqst_mst에 upload 되었음을 기록함
			dbDao.updateXterRqstCfm(rqstNoVO, account);
			
            if (!"WEB".equals(rqstNoVO.getSenderId()) && !"EXCEL".equals(rqstNoVO.getSenderId()) && !"EML".equals(rqstNoVO.getSenderId())) {
                //rqst건의 shipper에 update함
                dbDao.updateXterShipper(rqstNoVO, account);
            }

			
			// 정상 upload 되었음을 e-svc로 조회함
			sendErrMsgToEsvc("BC", "", rqstNoVO);
			
			if (!"WEB".equals(rqstNoVO.getSenderId()) && !"EXCEL".equals(rqstNoVO.getSenderId()) && !"EML".equals(rqstNoVO.getSenderId())) {
				//e-SVC로 전송할 EAI I/F를 위해 shipper 정보를 조회함
				xterShprInfoVO = dbDao.searchXterShprInfo(rqstNoVO, account);
			
				// upload 완료시 E-svc로 화주 정보를 전송한
				eaiDao.sendXterShprToEsvc(xterShprInfoVO, rqstNoVO);
			}
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}		
	}
	
	/**
	 * eBkg Customer Code를 ALPS Customer 정보를 토대로 업데이트함<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterCustCustCd(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterCustCustCd(rqstNoVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * eBkg을 통해 Bkg No가 생성된 경우 그 정보를 BKG_XTER_RQST_MST에 업데이트함<br>
	 *
	 * @param XterRqstNoVO rqstNoVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNo(XterRqstNoVO rqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterBkgNo(rqstNoVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Po No 정보만 조회 <br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return BkgReferenceVO
	 * @exception EventException
	 */
	public BkgReferenceVO searchAlpsPoNo(String bkgNo, String cntrNo ) throws EventException {
		BkgReferenceVO bkgReferenceVO = null;
		try {
			bkgReferenceVO = new BkgReferenceVO();
			bkgReferenceVO = dbDao.searchAlpsPoNo(bkgNo, cntrNo);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgReferenceVO;
	}
	
	/**
	 * 해당 사용자의 external request 조회조건을 조회한다.<br>
	 *
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterInnerPackageVO>
	 * @exception EventException
	 */
	public List<XterInnerPackageVO> searchXterInnerPackage(XterRqstNoVO xterRqstNoVO) throws EventException {
		try {
			return dbDao.searchXterInnerPackage(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * e-Booking Control for Vessel Slot Management 조회(ESM_BKG_1088)<br>
	 *
	 * @param EBookingControlMgmtVO eBookingControlMgmtVO
	 * @return List<EbookingControlMgmtVO>
	 * @exception EventException
	 */
	public List<EBookingControlMgmtVO> searchEBookingControlForVslMgmt(EBookingControlMgmtVO eBookingControlMgmtVO) throws EventException {
		try {
			return dbDao.searchEBookingControlForVslMgmt(eBookingControlMgmtVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * e-Booking Control Management 수정(ESM_BKG_1088)<br>
	 * 
	 * @param List<EBookingControlMgmtVO> eBookingControlMgmtVOList
	 * @param String modifyMode
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyEBookingControlMgmt(List<EBookingControlMgmtVO> eBookingControlMgmtVOList, String modifyMode, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyEBookingControlMgmt(eBookingControlMgmtVOList, modifyMode, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}

	
	/**
	 * BKG CONTAINER의 VGM WGT 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @param ContainerVO[] containerVOs
	 * @return ContainerVO
	 * @exception EventException
	 */
	public ContainerVO searchBkgCntrVgmWgt(String bkgNo, ContainerVO[] containerVOs) throws EventException {
		try {
			ContainerVO containerVO = new ContainerVO();
			int len = containerVOs == null ? 0 : containerVOs.length;
            for(int i = 0; i < len; i++) {
        		containerVO = dbDao.searchBkgCntrVgmWgt(bkgNo, containerVOs[i]);
        		if (containerVO.getVgmWgt() != null && NumberUtils.toDouble(containerVO.getVgmWgt()) > 0){
        			break;
        		}
            }
            return containerVO;
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Container에 tVvd와 CgoTpCd 조회한다.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return CntrEtcInfoVO
	 * @exception EventException
	 */
	public CntrEtcInfoVO manageCntrEtcInfo(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.manageCntrEtcInfo(bkgBlNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * B/L ISS 조회한다.(ESM_BKG_022901)<br>
	 * 
	 * @author 	KimByungKyu
	 * @param 	XterRqstNoVO xterRqstNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void searchBlIss(XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			// b/l issue 됐으면 [BKG02019]를 보여주고 중지한다.
			if("Y".equals(dbDao.searchBlIss(xterRqstNoVO))){
				throw new EventException((String)new ErrorHandler("BKG02058").getMessage());
			}
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * 필요에 따라 Booking No를 저장한다.<br>
	 *
	 * @param XterRqstNoVO[] xterRqstNoVO
	 * @exception EventException
	 */
	public void changeXterRqstBkgNo(XterRqstNoVO[] xterRqstNoVO) throws EventException{
		List<XterRqstNoVO> updateVoList = null;
		BookingUtil util  = null;
		BkgBlNoVO bkgVO = null;
		try {
			util = new BookingUtil();
			updateVoList = new ArrayList<XterRqstNoVO>();
			for ( int i=0; i<xterRqstNoVO.length; i++ ) {
				bkgVO = new BkgBlNoVO();
				bkgVO.setBkgNo(xterRqstNoVO[i].getBkgNo());
				bkgVO = util.searchBkgBlNoVO(bkgVO);
				if (null==bkgVO || null==bkgVO.getBkgNo()) {
					throw new EventException(new ErrorHandler("BKG00183", new String[]{xterRqstNoVO[i].getBkgNo()}).getMessage());
				}
				if ( xterRqstNoVO[i].getIbflag().equals("U")){
					updateVoList.add(xterRqstNoVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.changeXterRqstBkgNo(updateVoList);
			}
        } catch (EventException ee) {
        	throw ee;
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0228 : 0228에서 Detail 부분 Open시에 Validation 부분
	 * EBookingReceipt의 Seanaccs Validation 정보 조회<br>
	 *
	 * @param ExternalRqstListInputVO xterRqstListInputVO
	 * @return XterRqstValidationVO
	 * @exception EventException
	 */
	public XterRqstValidationVO searchXterRqstValidation(ExternalRqstListInputVO xterRqstListInputVO) throws EventException {
		try {
	        return dbDao.searchXterRqstValidation(xterRqstListInputVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchMqXlsGroupList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
	        return dbDao.searchMqXlsGroupList(bkgHrdCdgCtntVO);
	    } catch (DAOException de) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchMqXlsMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
	        return dbDao.searchMqXlsMappingList(bkgHrdCdgCtntVO);
	    } catch (DAOException de) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * searchMqXlsBkgGroupList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsBkgGroupList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
			return dbDao.searchMqXlsBkgGroupList(bkgHrdCdgCtntVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * searchMqXlsBkgMappingList 정보를 조회한다.<br>
	 *
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @exception EventException
	 */
	public List<BkgHrdCdgCtntVO> searchMqXlsBkgMappingList(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException {
		try {
			return dbDao.searchMqXlsBkgMappingList(bkgHrdCdgCtntVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * booking split 관련 상태 수정(ESM_BKG_0099)<br>
	 * 
	 * @param SplitBlInfoVO splitBlInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNoBySplit(SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterBkgNoBySplit(splitBlInfoVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * Cancel Split Candidate (ESM_BKG_0445)<br>
	 * 
	 * @param SplitBlInfoVO splitBlInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyXterBkgNoBySplitStsCd(SplitBlInfoVO splitBlInfoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyXterBkgNoBySplitStsCd(splitBlInfoVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * @param String flatFileStr 
	 * @param String key (ex.IB_NO)
	 * @param String msgstart (ex.EML)
	 * @return
	 */
	public String getFlatFileValue(String flatFileStr, String key, String msgstart) {
		//log.debug("\n getFlatFileValue flatFileStr:["+flatFileStr +"]key:["+key+"] msgstart:["+msgstart+"]");
		String delim ="\n";
		StringTokenizer sToken = null;
		sToken = new StringTokenizer(flatFileStr, delim);
		
        int lastIdx = 0;
        int subIdx = 0;
        String returnValue ="";
//        String ibNo ="";
//        String faxLogRefNo ="";
        String msg ="";
        StringBuffer replaceSb = new StringBuffer();
		boolean resultbb = false;
        while (sToken.hasMoreTokens()) {
  			String str = sToken.nextToken();
//  			log.debug("\nstr:["+str+"]");
  			// \r\n 이 있으면 제거 (S)
  			String regex = "\r\n|\r|\n";             
  			Pattern p = Pattern.compile(regex);
  			Matcher mm = p.matcher(str);
  			resultbb = mm.find();
  			// 패턴과 일치하는 문자열을 ""으로 교체해가며
  			// 새로운 문자열을 만든다.

  			while(resultbb) {
  				mm.appendReplacement(replaceSb, "");
  				str = replaceSb.toString();
  				resultbb = mm.find();
  			}
  			
    		// \r\n 이 있으면 제거 (E)
  			
  			// MSGSTART 가 맞는지 확인 (S)
  			lastIdx = str.lastIndexOf("MSGSTART:");
  			if(lastIdx >= 0){
  				subIdx = str.indexOf(":");
  				msg = str.substring(subIdx+1,subIdx+msgstart.length()+1);
  			
  			}
  			if (!msgstart.equals(msg)) {
  				break;
  			}
  		    // MSGSTART 가 맞는지 확인 (E)
  			lastIdx = str.lastIndexOf(key);
  			if(lastIdx >= 0){
  				subIdx = str.indexOf(":");
  				returnValue = str.substring(subIdx+1);
  			}
 
  			
        }
		return returnValue;
		
	}
	/**
	 * @param String flatFileStr 
	 * @param String srProcTpCd
	 * @exception EventException
	 */
	public void addBkgSrProcHisPrc(String flatFileStr, String srProcTpCd) throws EventException {

        String ibNo ="";
        String faxLogRefNo ="";
        try {
        
	        ibNo = getFlatFileValue(flatFileStr, "IB_NO", "EML");
	        faxLogRefNo = getFlatFileValue(flatFileStr, "IB_DCUBE_FAX_LOG_REF_NO", "EML");
	        if( !"".equals(ibNo) ) {
		        log.debug("\n addBkgSrProcHisPrc IB_NO:"+ibNo +"IB_DCUBE_FAX_LOG_REF_NO:"+faxLogRefNo);
//				prDbDao.addBkgSrProcHisPrc(ibNo, faxLogRefNo, srProcTpCd, "SYSTEM");	 
//				prDbDao.modifyBkgProcTpCd (ibNo, faxLogRefNo, srProcTpCd, "SYSTEM");	 
				addBkgSrProcHisPrcSql(ibNo, faxLogRefNo, srProcTpCd, "SYSTEM");
	        }

		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
        
	}	
	/**
	 * @param String srNo
	 * @param String faxLogRefNo
	 * @param String srProcTpCd
	 * @param String usrId
	 * @throws EventException
	 */
	public void addBkgSrProcHisPrcSql(String srNo, String faxLogRefNo, String srProcTpCd, String usrId) throws EventException {

 
        try {
        
	        log.debug("\n srNo:"+srNo +"faxLogRefNo:"+faxLogRefNo);
			prDbDao.addBkgSrProcHisPrc(srNo, faxLogRefNo, srProcTpCd, usrId);	 
			prDbDao.modifyBkgProcTpCd (srNo, faxLogRefNo, srProcTpCd, usrId);	

		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
        
	}	
	/**
	 * 
	 * @param String flatFileStr
	 * @throws EventException
	 */
	public void sendSiTransErrMail(String flatFileStr) throws EventException {
		try{
//			String emlFlg = "";
	        String ibNo ="";
	        String faxLogRefNo ="";
	        Map<String, Object> infoEml =null;

	        
//	        	emlFlg = getFlatFileValue(flatFileStr, "MSGSTART", "EML");
	        ibNo = getFlatFileValue(flatFileStr, "IB_NO", "EML");
//		        if( emlFlg.indexOf("EML")>= 0 &&  !"".equals(ibNo) ) {
        	if( !"".equals(ibNo) ) {
	        	faxLogRefNo = getFlatFileValue(flatFileStr, "IB_DCUBE_FAX_LOG_REF_NO", "EML");
		        log.debug("\n addBkgSrProcHisPrc IB_NO:"+ibNo +"IB_DCUBE_FAX_LOG_REF_NO:"+faxLogRefNo);
		        //bkg_sr_fax(FNT_OFC_EML) 에서 이메일 주소를 찾는다.
		        infoEml =dbDao.searchReturnEml(ibNo, faxLogRefNo);
	        	//메일을 보낸다.
				eaiDao.sendSiTransErrMail(infoEml);		        
	        }
        	
//        	emlSubjCtnt = dbDao.searchSREmlCtnt(ibNo, faxLogRefNo);

        } catch(Exception ex) {
        	 throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
	}
	/**
	 * b/l rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<BlRiderVO>
	 * @throws EventException
	 */
	public List<BlRiderVO> searchXterImgSto(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchXterImgSto(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * alps b/l rider search
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<BlRiderVO>
	 * @throws EventException
	 */
	public List<BlRiderVO> searchBkgImgSto(BkgBlNoVO bkgBlNoVO)
			throws EventException {
		try {
			return dbDao.searchBkgImgSto(bkgBlNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * e-svc d/g rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchXterDgRiderList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchXterDgRiderList(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}
	/**
	 * e-svc d/g rider cntr list search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchXterDgRiderCntrList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		String checkBoxString="";
		try {
			List<DgRiderCntrListVO> dgRiderCntrListVOs = dbDao.searchXterDgRiderCntrList(xterRqstNoVO);
			//화면단에서 컨트롤하기 어려워 컨터이너 데이터 가공처리
			StringBuffer cBoxBuf = new StringBuffer("");

			cBoxBuf.append("<table width='100%' class='grid2' border='0' id= t_table2>");
			if(dgRiderCntrListVOs.size() > 0){
				Iterator<DgRiderCntrListVO> list = dgRiderCntrListVOs.iterator();
	        	while(list.hasNext()){
	        		DgRiderCntrListVO dgRiderCntrListVO = (DgRiderCntrListVO)list.next();
	        		cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
	        		cBoxBuf.append("<input type='checkbox' name='t_check2'  value='"+dgRiderCntrListVO.getCargoValue()+"' disabled></td>");
	        		cBoxBuf.append("<td width='90%' align='center'>"+dgRiderCntrListVO.getCargoName()+"</td>");
	        		cBoxBuf.append("<input type='hidden' name='t_name2' value='"+dgRiderCntrListVO.getCargoName()+"'></tr>");
	        	}
			}else{
				cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
				cBoxBuf.append("no data... </td></tr>");
			}
			cBoxBuf.append("</table>");

        	checkBoxString = cBoxBuf.toString();

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return checkBoxString;	
	}
	/**
	 * alps d/g rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchAlpsDgRiderList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchAlpsDgRiderList(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * akps d/g rider cntr list search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAlpsDgRiderCntrList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		String checkBoxString="";
		try {
			List<DgRiderCntrListVO> dgRiderCntrListVOs = dbDao.searchAlpsDgRiderCntrList(xterRqstNoVO);
			//화면단에서 컨트롤하기 어려워 컨터이너 데이터 가공처리
			StringBuffer cBoxBuf = new StringBuffer("");

			cBoxBuf.append("<table width='100%' class='grid2' border='0' id= t_table>");
			if(dgRiderCntrListVOs.size() > 0){
				Iterator<DgRiderCntrListVO> list = dgRiderCntrListVOs.iterator();
	        	while(list.hasNext()){
	        		DgRiderCntrListVO dgRiderCntrListVO = (DgRiderCntrListVO)list.next();
	        		cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
	        		cBoxBuf.append("<input type='checkbox' name='t_check'  value='"+dgRiderCntrListVO.getCargoValue()+"'></td>");
	        		cBoxBuf.append("<td width='90%' align='center'>"+dgRiderCntrListVO.getCargoName()+"</td>");
	        		cBoxBuf.append("<input type='hidden' name='t_name' value='"+dgRiderCntrListVO.getCargoName()+"'></tr>");
	        	}
			}else{
				cBoxBuf.append("<tr class='tr2_head'><td width='10%' align='center'>");
				cBoxBuf.append("no data... </td></tr>");
			}
			cBoxBuf.append("</table>");

        	checkBoxString = cBoxBuf.toString();

        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return checkBoxString;	
	}
	
	/**
	 * VGM Terminal EDI outbound
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvId
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createTerminalVERMASEdi(BkgBlNoVO bkgBlNoVO, String rcvId) throws EventException {
		
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		//BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		String bracCd = "9";					
		try {
			//flatfile 생성
			if(StringUtils.isEmpty(rcvId)){
				for(TmnlRcvIdVO trvo : dbDao.searchVGMOutboundRcvId(bkgBlNoVO)){
					bracCd = StringUtils.isNotEmpty(trvo.getBracCd()) ? trvo.getBracCd() : "9";
					bkgNtcHisVOs.add(createTerminalVERMASFlatFile(bkgBlNoVO, trvo.getEdiRcvId(), bracCd));
				}
			} else {
				bkgNtcHisVOs.add(createTerminalVERMASFlatFile(bkgBlNoVO, rcvId, bracCd));
			}
			//historyBC.createBkgNtcHis(bkgNtcHisVOs, "");			
			
//		} catch (DAOException de) {
//	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return bkgNtcHisVOs;
	}
	
	/**
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String receiveId
	 * @param String bracCd
	 * @return BkgNtcHisVO
	 * @throws EventException, DAOException
	 */
	public BkgNtcHisVO createTerminalVERMASFlatFile(BkgBlNoVO bkgBlNoVO, String receiveId, String bracCd) throws EventException, DAOException{
		StringBuilder flatFileSB = null;
		
		String flatFile = "";
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		BookingUtil utilBC =  new BookingUtil();
		
		String sndrId = utilBC.searchEdi301HostId(receiveId, "TMNL");
		String header = JSPUtil.getNull(utilBC.searchEdiHeader(sndrId, receiveId, "VERMAS"));
		
		String tmlEdiRefNo = header.substring(62);
		flatFileSB = new StringBuilder();
		flatFileSB.append(header);
		String body = dbDao.searchVGMOutbound(bkgBlNoVO, bracCd);
		if(!StringUtils.isEmpty(body)){
			flatFileSB.append("\n");
			flatFileSB.append(body);
			flatFileSB.append("\n");
			flatFile = flatFileSB.toString();				
			log.debug("FlatFile:" + flatFile);
			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VERMAS.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

			if ( flatFileAckVO.getAckStsCd().equals("E") ){
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}
		}
		
		// History				
		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
		bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
		bkgNtcHisVO.setNtcViaCd("E");
		bkgNtcHisVO.setNtcKndCd("VM");
		bkgNtcHisVO.setEdiId(receiveId);
		bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO == null ? "E" : flatFileAckVO.getAckStsCd());
		bkgNtcHisVO.setSndId(sndrId);
		
		// Account 정보가 없을 경우에는 Batch에서 호출된것으로 판단하여 User ID, Office CD을 SYSTEM으로 설정한다.
		String usrId = "SYSTEM";
		String ofcCd = "SYSTEM";
		
		bkgNtcHisVO.setSndUsrId(usrId);
		bkgNtcHisVO.setSndOfcCd(ofcCd);
		bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
		bkgNtcHisVO.setTmlNtcSndStsCd(bracCd);
		bkgNtcHisVO.setDiffRmk(tmlEdiRefNo);
		bkgNtcHisVO.setCreUsrId(usrId);
		bkgNtcHisVO.setUpdUsrId(usrId);		
		return bkgNtcHisVO;
	}
	
	/**
	 * VGM Upload 후 결과 ACK 전송을 위한 Flat File 생성
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @param String rcvId
	 * @return 
	 * @throws EventException
	 */
	public void createVGMUploadAckEdi(XterVgmRqstListVO xterVgmRqstListVO, String rcvId) throws EventException {

		try{
			StringBuilder flatFileSB = null;
			String flatFile = "";
			SendFlatFileVO sendFlatFileVO = null;
			FlatFileAckVO flatFileAckVO = null;
			BookingUtil utilBC =  new BookingUtil();
			
			//flatfile 생성
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(xterVgmRqstListVO.getBkgNo());
			
				// header 생성
				String hostTpId = utilBC.searchEdi301HostId(xterVgmRqstListVO.getXterSndrId(), "CUST");
				if(hostTpId == null || "".equals(hostTpId)){
					hostTpId = "SMLM";
				}
				String header = JSPUtil.getNull(utilBC.searchEdiHeader(hostTpId, xterVgmRqstListVO.getXterSndrId(), "VGMAPERAK"));
				flatFileSB = new StringBuilder();
				flatFileSB.append(header);
				
				// body 생성
				String body = dbDao.searchVGMUploadAck(xterVgmRqstListVO);
				if(!StringUtils.isEmpty(body)){
					flatFileSB.append("\n");
					flatFileSB.append(body);
					flatFileSB.append("\n");
					flatFile = flatFileSB.toString();				
					log.debug("FlatFile:" + flatFile);
					sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile);
					String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_ACK.IBMMQ.QUEUE");
					sendFlatFileVO.setQueueNm(queueNm);
					flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
					log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

					if ( flatFileAckVO.getAckStsCd().equals("E") ){
						throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
					}
				}
			
		} catch (DAOException de) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createBOKCONEdi(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {		
		String senderId = null;
		StringBuilder flatFileSB = null;
		String flatFile = "";
		SendFlatFileVO sendFlatFileVO = null;
		FlatFileAckVO flatFileAckVO = null;
		BookingUtil utilBC =  new BookingUtil();	
		XterRqstNoVO xterRqstNoVO = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		
		try {
			xterRqstNoVO = dbDao.selectBkgRqstNoByBkgNo(bkgBlNoVO.getBkgNo());	
			
			if(xterRqstNoVO == null) return null;
			
			xterRqstNoVO.setBkgNo(bkgBlNoVO.getBkgNo());
			
//			if (xterRqstNoVO.getSenderId().length() > 4 && 
//					(xterRqstNoVO.getSenderId().substring(0,4).equals("C1T0")
//							|| xterRqstNoVO.getSenderId().substring(0,4).equals("C1S0"))){
//				senderId = "C1T0WSML1";
//			} else if(xterRqstNoVO.getSenderId().length() > 5 && xterRqstNoVO.getSenderId().substring(0,5).equals("110AL")){ 
//				senderId = "C1T0WSML1";	
//			} else {
//				senderId = "HANJINSHIP";
//			}
			
			senderId = dbDao.searchHostTradePartnerId(xterRqstNoVO.getSenderId());

			//flatfile 생성
			flatFileSB = new StringBuilder();
			String [] flatFileStr = new String[6];
			flatFileSB.append(utilBC.searchEdiHeader(senderId, xterRqstNoVO.getSenderId(), "BOKCON") + "\n");

			log.debug("rqstNoVo.getSenderId():"+xterRqstNoVO.getSenderId());
			
			flatFileStr[0] = dbDao.searchXterRqstMstForBOKCON(xterRqstNoVO);				
			flatFileStr[1] = dbDao.searchXterRqstMiscForAck(xterRqstNoVO);
			flatFileStr[2] = dbDao.searchXterCustForAck(xterRqstNoVO);
			flatFileStr[3] = dbDao.searchXterTroForBOKCON(xterRqstNoVO);
			flatFileStr[4] = dbDao.searchXterTroDtlForBOKCON(xterRqstNoVO);
			flatFileStr[5] = dbDao.searchXterDescForAck(xterRqstNoVO);
			
			for(int i = 0; i < 6; i++){
				if(flatFileStr[i] != null){
//					log.debug("flatFileStr[i]:"+flatFileStr[i]);
					flatFileSB.append(flatFileStr[i]);
				}
			}				

			flatFile = flatFileSB.toString();				
			log.debug("FlatFile:" + flatFile);
			
			// auto confirm edi flatfile 전송
			sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			String queueNm = SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER.IBMMQ.QUEUE");
			sendFlatFileVO.setQueueNm(queueNm);
			flatFileAckVO = utilBC.sendFlatFile(sendFlatFileVO);
			log.debug("ACT_STS:"+flatFileAckVO.getAckStsCd());

			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());

			// History
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setNtcKndCd("BO");
			bkgNtcHisVO.setEdiId(xterRqstNoVO.getSenderId());
			bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
			bkgNtcHisVOs.add(bkgNtcHisVO);			
		}catch(EventException e){
			throw e;
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		
		return bkgNtcHisVOs;
	}
	/**
	 * PO NO의 path item 조회
	 * @param SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO
	 * @return String
	 * @throws EventException
	 */
	public String searchXterPoMdtItm(SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO)
			throws EventException {
		try {
			return dbDao.searchXterPoMdtItm(searchXterPoMdtItmParmVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}		
    
    /**
     * BL Issue 상태 조회
     * 
     * @param String bkgNo
     * @return List<HistoryLineVO>
     * @throws EventException
     */
    public List<HistoryLineVO> searchBlIssComplete(String bkgNo) throws EventException {
        try {
            return dbDao.searchBlIssComplete(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
    
    
    /**
     * CNTR Type Size 조회
     * 
     * @param String cntrTpSz
     * @return String
     * @throws EventException
     */
    public String searchCntrTpSz(String cntrTpSz) throws EventException {
        try {
            return dbDao.searchCntrTpSz(cntrTpSz);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    
    
	/**
	 * ALPS b/l Wharfage search
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<KrWhfBlExptInfoVO>
	 * @throws EventException
	 */
	public List<KrWhfBlExptInfoVO> searchKrWhfBlExptInfo(BkgBlNoVO bkgBlNoVO)
			throws EventException {
		try {
			return dbDao.searchKrWhfBlInfo(bkgBlNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}   
		
	/**
	 * e-SVC b/l Wharfage search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<KrWhfBlExptInfoVO>
	 * @throws EventException
	 */
	public List<KrWhfBlExptInfoVO> searchXterKrWhfBlExptInfo(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchXterKrWhfBlInfo(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}     
    

    /**
     * Xter Upload Sts Code 조회
     * 
     * @param XterRqstNoVO xterRqstNoVO
     * @return String
     * @throws EventException
     */
    public String searchXterBkgSts(XterRqstNoVO xterRqstNoVO) throws EventException {
        try {
            return dbDao.searchXterBkgSts(xterRqstNoVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    
    
    /**
	 * Allcoation Popup Firm Notice Send
	 * @param AllocStsVO allocStsVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendXterRqstAllocationNotice(AllocStsVO allocStsVO,BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		GeneralBookingSearchBC  searchBC	= new GeneralBookingSearchBCImpl();
		BLIssuanceBC            blIssBC    	= new BLIssuanceBCImpl();
		BLIssuanceBC           bLIssuanceBC = new BLIssuanceBCImpl();
		BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
		BookingUtil             util        = new BookingUtil();
		
		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
		DblWblVO[] dblWblVOs = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		StringBuilder sbParam = null;
		sbParam = new StringBuilder();
		
		String siContactUsrNm = null;
		String siContactEmail = null;
		
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		List<BkgNtcHisVO> bkgNtcHisSysVOs = new ArrayList<BkgNtcHisVO>();
		//List<HistoryLineVO> historyLineVOs = null;
		
		String mrdNm = null;
		String [] rmk = new String[1];
		rmk[0] = "";
		
		try {
			BkgBlNoVO bkgBlNoVO2 = util.searchBkgBlNoVO(bkgBlNoVO);
			if(bkgBlNoVO2!=null && bkgBlNoVO2.getBlNo()!=null){
				bkgBlNoVO.setBlNo(bkgBlNoVO2.getBlNo());
			}
			
			if ( "Y".equals(allocStsVO.getAutoNotification() )) {
				
				if ("B".equals(allocStsVO.getDocTpCd()) && allocStsVO.getBkgCntcPsonEml().trim().length() > 0
						&& !StringUtils.containsNone(allocStsVO.getBkgCntcPsonEml().trim(), "@")){
					String [] eml = new String[allocStsVO.getBkgCntcPsonEml().length()];
					eml[0] = allocStsVO.getBkgCntcPsonEml();
					StringBuilder titleSb = new StringBuilder("SM Line Web Booking Notification");
					titleSb.append(" ( ").append(bkgBlNoVO.getBkgNo()).append(" :  Uploaded )");
					StringBuilder contentSb = new StringBuilder("Dear Customer");
					contentSb.append("<br><br>Thank you for using our website");
					contentSb.append("<br>Your booking '").append(bkgBlNoVO.getBkgNo()).append("' request is successfully processed in our booking & documentation system.");
					contentSb.append("<br>For your cargo information, refer to the attached file");
					contentSb.append("<br><br><br>If you have any question, please contact our booking & documentation");
					contentSb.append("<br>").append(account.getUsr_id());
					contentSb.append("<br><br><br>We would like to listen to how you think of our service, If you have any suggestions or comments");
					contentSb.append("<br>please visit our website and leave your comments into the section of Voice of Customer");
					BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[] {new BkgBlNoVO() };
					
					mrdNm = "ESM_BKG_5005G";
					String [] cct = new String[allocStsVO.getBkgCntcPsonEml().length()];  //
					for(int j=0;j<cct.length;j++){
						cct[j]="";
					}
					
					String vslNm = blIssBC.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());					
					bkgBlNoVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					
					bkgNtcHisVOs = searchBC.sendXterReceiptByEmail(bkgBlNoVOs, eml, rmk, mrdNm, cct, account, titleSb.toString(), contentSb.toString(), vslNm );
					
				} else if ( ("S".equals(allocStsVO.getDocTpCd()) || "U".equals(allocStsVO.getDocTpCd()))
						&& allocStsVO.getSiCntcPsonEml().trim().length() > 0
						&& !StringUtils.containsNone(allocStsVO.getSiCntcPsonEml().trim(), "@")){
					String [] siEml = new String[allocStsVO.getSiCntcPsonEml().length()];
					siEml[0] = allocStsVO.getSiCntcPsonEml();
					sbParam = new StringBuilder();
					
					if ("PKGSA".equals(account.getOfc_cd())){
						String[] bkgContact  = searchBkgContactInfo(bkgBlNoVO.getBkgNo());
						siContactUsrNm = bkgContact[0];
						siContactEmail = bkgContact[1];
						if (siContactUsrNm == null || "".equals(siContactUsrNm)) {
							siContactUsrNm = account.getUsr_nm();
							siContactEmail = account.getUsr_eml();
						}
					} else {
						siContactUsrNm = account.getUsr_nm();
						siContactEmail = account.getUsr_eml();
					}
					
					StringBuilder titleSb = new StringBuilder("SM Line Web B/L Instruction Notification ");
					titleSb.append(" ( ").append(bkgBlNoVO.getBkgNo()).append(" :  Uploaded )");
					StringBuilder contentSb = new StringBuilder("Dear Customer");
					contentSb.append("\n\nThank you for using SM Line Website.");
					contentSb.append("\nThis is an automated message to inform you that your B/L instruction request for \"").append(bkgBlNoVO.getBkgNo()).append("\"  is received for processing.");
					contentSb.append("\nPlease note that the attachment is not the final draft B/L, but a preview form of the final draft B/L.");
					contentSb.append("\n\nIf you have any question on the submitted B/L instruction or booking, please contact: ").append(siContactUsrNm).append(" (").append(siContactEmail).append(").");
					contentSb.append("\n\nIf you have any suggestions or comments, do not hesitate to share us your valuable comments in our \"Voice of Customer\" menu.");
					
					sType="2";
					sMrd="ESM_BKG_0109_DBL.mrd";					
					sLevel="6";
					
					sbParam.append("/rv");
					sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
					sbParam.append(" form_type[").append(sType).append("]");
					sbParam.append(" form_dataOnly[N]");
					sbParam.append(" form_manifest[N]");
					sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
					sbParam.append(" form_hiddeData[N]");
					sbParam.append(" form_level[(").append(sLevel).append(")]");
					sbParam.append(" form_remark[").append(rmk[0]).append(")]");
					sbParam.append(" form_Cntr[1]");
					sbParam.append(" form_mainOnly[N]");
					sbParam.append(" form_CorrNo[]");
					sbParam.append(" form_his_cntr[BKG_CONTAINER]");
					sbParam.append(" form_his_bkg[BKG_BOOKING]");
					sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
					sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
					sbParam.append(" form_his_bl[BKG_BL_DOC]");
					sbParam.append(" /rp []");
					sbParam.append(" /riprnmargin");
					dblWblVOs = new DblWblVO[1];
					dblWblVOs[0] = new DblWblVO();
					dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
					dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setTmplmrd(sMrd);
					dblWblVOs[0].setBatchflg("N");
					dblWblVOs[0].setTmplparam(sbParam.toString());
					dblWblVOs[0].setRcveml(siEml[0]);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
					dblWblVOs[0].setItr("|$$|");
		//			dblWblVOs[0].setNtcKndCd("");
		//			dblWblVOs[0].setHiddOpt("N");
					dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setTitle(titleSb.toString()); /* 제목 */
					dblWblVOs[0].setContents(contentSb.toString()); /* 내용 */
					
					bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);					
				}
				bkgNtcHisVO = bkgNtcHisVOs.get(0);
		        bkgNtcHisVO.setSndUsrId("SYSTEM");
		        bkgNtcHisSysVOs.add(bkgNtcHisVO);
		        
		        historyBC.createBkgNtcHis(bkgNtcHisSysVOs, "ESM_BKG_0229");		
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Booking pol이 Europe 인지 확인하고 POD 목록을 조회<br>
	 * @param String bkgNo
	 * @return  String[]
	 * @throws EventException
	 */
	public String[] searchXterCMvalidationEuDeHjsCD(String bkgNo) throws EventException{
		try {
			String[] valiVal =  dbDao.searchXterCMvalidationEuDeHjsCD(bkgNo);		
			return valiVal;
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * Actual Customer Nmae 조회<br>
	 * @param String agmtActCntCd
	 * @param String agmtActCustSeq
	 * @param String exCustNm
	 * @return  String[]
	 * @throws EventException
	 */
	public String[] searchActualCustomerName(String agmtActCntCd, String agmtActCustSeq, String exCustNm  ) throws EventException{
		try {
			String[] valiVal =  dbDao.searchActualCustomerName(agmtActCntCd, agmtActCustSeq, exCustNm);		
			return valiVal;
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * BKG Contract Name 조회<br>
	 * @param String bkgNo
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchBkgContactInfo(String bkgNo  ) throws EventException{
		try {
			String[] valiVal =  dbDao.searchBkgContactInfo(bkgNo);		
			return valiVal;
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * e-BKG cancel request 업로드 시에도 remark 저장<br>
	 *
	 * @param String bkgNo
	 * @param String interRmk
	 * @param String xterRmk
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBkgRmk(String bkgNo , String interRmk, String xterRmk, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyBkgRmk( bkgNo, interRmk, xterRmk , account );
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBookingInfoVO
	 * @exception EventException
	 */
	public BkgBookingInfoVO searchXterBkgInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgBookingInfoVO bkgBookingInfoVO = null;
		try {
			bkgBookingInfoVO = new BkgBookingInfoVO();
			bkgBookingInfoVO = dbDao.searchXterBkgInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgBookingInfoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgBookingInfoVO
	 * @exception EventException
	 */
	public BkgBookingInfoVO searchXterSIInterface(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgBookingInfoVO bkgBookingInfoVO = null;
		try {
			bkgBookingInfoVO = new BkgBookingInfoVO();
			bkgBookingInfoVO = dbDao.searchXterSIInterface(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgBookingInfoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 customer 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BlCustomerVO
	 * @exception EventException
	 */
	public BlCustomerVO searchXterCustInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BlCustomerVO blCustomerVO = null;
		
		try {
			blCustomerVO = new BlCustomerVO();
			// Bkg Customer 정보를 조회한다.
			BlDocCustVO blDocCustVO = dbDao.searchXterCustInterface(bkgWebServiceVO);
			// Bkg Customer 이외의 정보를 조회한다.
			CustEtcVO custEtcVO = dbDao.searchBkgCustEtcInterface(bkgWebServiceVO);
			
			blCustomerVO.setBlDocCustVO(blDocCustVO);
			blCustomerVO.setCustEtcVO(custEtcVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return blCustomerVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Tro 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return TroVO
	 * @exception EventException
	 */
	public TroVO searchXterTroInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		TroVO troVO = new TroVO();

		try {
			troVO.setArrTroMstVO((TroMstVO[])dbDao.searchXterTroInterface(bkgWebServiceVO));
			troVO.setArrTroDtlVO((TroDtlVO[])dbDao.searchXterTroDtlInterface(bkgWebServiceVO));
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return troVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 Reefer cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgRfCgoVO[]
	 * @exception EventException
	 */
	public BkgRfCgoVO[] searchXterRfInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgRfCgoVO[] bkgRfCgoVO = null;		
		
		try {
			bkgRfCgoVO = dbDao.searchXterRfInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return bkgRfCgoVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 danger cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return DgCgoListVO[]
	 * @exception EventException
	 */
	public DgCgoListVO[] searchXterDgInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		DgCgoListVO[] dgCgoListVO = null;

		try {
			dgCgoListVO = dbDao.searchXterDgInterface(bkgWebServiceVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return dgCgoListVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 danger cgo Rider 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgImgStoVO[]
	 * @exception EventException
	 */
	public BkgImgStoVO[] searchXterDgRiderListInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgImgStoVO[] bkgImgStoVO = null;
		
		try {
			bkgImgStoVO = dbDao.searchXterDgRiderListInterface(bkgWebServiceVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return bkgImgStoVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 awkward cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgAwkCgoVO[]
	 * @exception EventException
	 */
	public BkgAwkCgoVO[] searchXterAkInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgAwkCgoVO[] bkgAwkCgoVO = null;

		try {
			bkgAwkCgoVO = dbDao.searchXterAkInterface(bkgWebServiceVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return bkgAwkCgoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Awkward cgo Rider 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgImgStoVO[]
	 * @exception EventException
	 */
	public BkgImgStoVO[] searchXterAkRiderListInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgImgStoVO[] bkgImgStoVO = null;
		
		try {
			bkgImgStoVO = dbDao.searchXterAkRiderListInterface(bkgWebServiceVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return bkgImgStoVO;
	}

	/**
	 * MND 중 Booking Request시 접수되는 Import&Export Licence No만 별도 처리하기 위해 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return AlpsXptImpLicListVO[]
	 * @exception EventException
	 */
	public AlpsXptImpLicListVO[] searchAlpsXptImpLicListInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		AlpsXptImpLicListVO[] alpsXptImpLicListVO = null;

		try {
			alpsXptImpLicListVO = dbDao.searchAlpsXptImpLicListInterface(bkgWebServiceVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return alpsXptImpLicListVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 Break Bulk cgo 정보를 조회한다.<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBbCgoVO[]
	 * @exception EventException
	 */
	public BkgBbCgoVO[] searchXterBbInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgBbCgoVO[] bkgBbCgoVO = null;
		
		try {
			bkgBbCgoVO = dbDao.searchXterBbInterface(bkgWebServiceVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return bkgBbCgoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return XterRqstNoVO
	 * @exception EventException
	 */
	public XterRqstNoVO searchXterRqstNoInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		XterRqstNoVO xterRqstNoRstVO = new XterRqstNoVO();
		try {
			
			xterRqstNoRstVO = dbDao.searchXterRqstNoInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return xterRqstNoRstVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgBlNoVO
	 * @exception EventException
	 */
	public BkgBlNoVO searchBkgBlNoInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		try {
			bkgBlNoVO = dbDao.searchBkgBlNoInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgBlNoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return XterEtcInterfaceVO
	 * @exception EventException
	 */
	public XterEtcInterfaceVO searchXterEtcInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		XterEtcInterfaceVO xterEtcInterfaceVO = new XterEtcInterfaceVO();
		try {
			xterEtcInterfaceVO = dbDao.searchXterEtcInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return xterEtcInterfaceVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return VslSkdVO[]
	 * @exception EventException
	 */
	public VslSkdVO[] searchVslSkdInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		VslSkdVO[] vslSkdVO = null;
		try {
			vslSkdVO = dbDao.searchVslSkdInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return vslSkdVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return DocRqstVO
	 * @exception EventException
	 */
	public DocRqstVO searchDocRqstInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		DocRqstVO docRqstVO = new DocRqstVO();
		try {
			docRqstVO = dbDao.searchDocRqstInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return docRqstVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BookingSaveValidationVO
	 * @exception EventException
	 */
	public BookingSaveValidationVO searchBookingSaveValidationInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BookingSaveValidationVO bookingSaveValidationVO = new BookingSaveValidationVO();
		try {
			bookingSaveValidationVO = dbDao.searchBookingSaveValidationInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bookingSaveValidationVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BookingSaveValidationVO
	 * @exception EventException
	 */
	public BookingSaveValidationVO searchSISaveValidationInterface(SIWebServiceVO sIWebServiceVO) throws EventException {
		BookingSaveValidationVO bookingSaveValidationVO = new BookingSaveValidationVO();
		try {
			bookingSaveValidationVO = dbDao.searchSISaveValidationInterface(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bookingSaveValidationVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgQuantityVO[]
	 * @exception EventException
	 */
	public BkgQuantityVO[] searchBkgQuantityInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgQuantityVO[] bkgQuantityVO = null;
		try {
			bkgQuantityVO = dbDao.searchBkgQuantityInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgQuantityVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgQuantityVO[]
	 * @exception EventException
	 */
	public BkgQuantityVO[] searchSIBkgQuantityInterface(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgQuantityVO[] bkgQuantityVO = null;
		try {
			bkgQuantityVO = dbDao.searchSIBkgQuantityInterface(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgQuantityVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgQtyDtlVO[]
	 * @exception EventException
	 */
	public BkgQtyDtlVO[] searchBkgQtyDtlInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgQtyDtlVO[] bkgQtyDtlVO = null;
		try {
			bkgQtyDtlVO = dbDao.searchBkgQtyDtlInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgQtyDtlVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgQtyDtlVO[]
	 * @exception EventException
	 */
	public BkgQtyDtlVO[] searchSIBkgQtyDtlInterface(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgQtyDtlVO[] bkgQtyDtlVO = null;
		try {
			bkgQtyDtlVO = dbDao.searchSIBkgQtyDtlInterface(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgQtyDtlVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BlCustomerInfoVO
	 * @exception EventException
	 */
	public BlCustomerInfoVO searchBlCustomerInfoInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BlCustomerInfoVO blCustomerInfoVO = new BlCustomerInfoVO();
		try {
			blCustomerInfoVO = dbDao.searchBlCustomerInfoInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return blCustomerInfoVO;
	}

	/**
	 * external request 처리를 위해 external rqst의 BkgTroSpclCgoSeqVO 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgTroSpclCgoSeqVO[]
	 * @exception EventException
	 */
	public BkgTroSpclCgoSeqVO[] searchXterBkgTroSpclCgoSeqInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgTroSpclCgoSeqVO[] bkgTroSpclCgoSeqVO = null;
		try {
			bkgTroSpclCgoSeqVO = dbDao.searchXterBkgTroSpclCgoSeqInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgTroSpclCgoSeqVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 BkgQuantityVO 정보를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return BkgQuantityVO[]
	 * @exception EventException
	 */
	public BkgQuantityVO[] searchBkgQuantityVOInterface(BkgBlNoVO bkgBlNoVO) throws EventException {
		BkgQuantityVO[] bkgQuantityVO = null;
		try {
			bkgQuantityVO = dbDao.searchBkgQuantityVOInterface(bkgBlNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgQuantityVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Reference 정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @return BkgReferenceVO[]
	 * @exception EventException
	 */
	public BkgReferenceVO[] searchBkgReferenceInterface(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		BkgReferenceVO[] bkgReferenceVO = null;
		try {
			bkgReferenceVO = dbDao.searchBkgReferenceInterface(bkgWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgReferenceVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag정보를 조회한다.<br>
	 * 
	 * @param BkgWebServiceVO bkgWebServiceParamVO
	 * @return BkgWebServiceVO
	 * @exception EventException
	 */
	public BkgWebServiceVO searchWebServiceProcessType(BkgWebServiceVO bkgWebServiceParamVO) throws EventException {
		BkgWebServiceVO bkgWebServiceVO = null;
		try {
			bkgWebServiceVO = new BkgWebServiceVO();
			bkgWebServiceVO = dbDao.searchWebServiceProcessType(bkgWebServiceParamVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgWebServiceVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Job Type, BKG Block Flag, Manual Flag정보를 조회한다.<br>
	 * 
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @return SIWebServiceVO
	 * @exception EventException
	 */
	public SIWebServiceVO searchWebServiceSIProcessType(XterRqstNoVO xterRqstNoRstVO) throws EventException {
		SIWebServiceVO sIWebServiceVO = null;
		try {
			sIWebServiceVO = new SIWebServiceVO();
			sIWebServiceVO = dbDao.searchWebServiceSIProcessType(xterRqstNoRstVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return sIWebServiceVO;
	}

   	/**
	 * Interface로 Upload된 정보 PreviousStatus Update<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @param SignOnUserAccount account
	 * @throws EventException 
	 */
	public void modifyPreviousBookingRequestStatus(BkgWebServiceVO bkgWebServiceVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyPreviousBookingRequestStatus(bkgWebServiceVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Interface로 Upload된 S/I 정보 PreviousStatus Update<br>
	 *
	 * @param XterRqstNoVO xterRqstNoRstVO
	 * @param SignOnUserAccount account
	 * @throws EventException 
	 */
	public void modifyPreviousSIRequestStatus(XterRqstNoVO xterRqstNoRstVO, SignOnUserAccount account) throws EventException {
		try {
			if("Y".equals(xterRqstNoRstVO.getPreSeqDeltFlg())){
				dbDao.modifyAllPreviousSIRequestStatus(xterRqstNoRstVO, account);
			} else {
				dbDao.modifyPreviousSIRequestStatus(xterRqstNoRstVO, account);
			}
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

   	/**
	 * Interface로 Upload된 정보 Status Update<br>
	 *
	 * @param BkgWebServiceVO bkgWebServiceVO
	 * @param SignOnUserAccount account
	 * @throws EventException 
	 */
	public void modifyAutoUploadStatus(BkgWebServiceVO bkgWebServiceVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyAutoUploadStatus(bkgWebServiceVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Interface로 Upload된 정보 Status Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @throws EventException 
	 */
	public void modifySIAutoUploadStatus(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifySIAutoUploadStatus(sIWebServiceVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 미주지역 Rqst에 대한 Handling Office를 조회한다.
	 * 
	 * @param String polCd
	 * @param String cmdtNm
	 * @return String
	 * @throws EventException
	 */
	public String searchUsHandlingOfc(String polCd, String cmdtNm) throws EventException {
		String bkgOfcCd="";
		try {
			bkgOfcCd = dbDao.searchUsHandlingOfc(polCd, cmdtNm);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return bkgOfcCd;	
	}
	
	/**
	 * BKG Black List 체크
	 * 
	 * @param XterRqstNoVO rqstNoVo
	 * @return String
	 * @throws EventException
	 */
	public String checkBkgBlackList(XterRqstNoVO rqstNoVo) throws EventException {
		String blackCustName="";
		try {
			blackCustName = dbDao.checkBkgBlackList(rqstNoVo);
			
			List<XterRqstNoVO> xterRqstNoVOs = new ArrayList<XterRqstNoVO>();
			xterRqstNoVOs.add(rqstNoVo);
			
			if(blackCustName != null && !"".equals(blackCustName)){
				dbDao.changeXterRqstStatus("BLACK_LIST", "D", xterRqstNoVOs);
			}
			
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return blackCustName;	
	}
	
	/**
	 * BKG EXEC ENIS LOGS
	 * 
	 * @param String logDesc
	 * @param String applInfo
	 * @param String modName
	 * @throws EventException
	 */
	public void createBkgExecEnisLog(String logDesc, String applInfo, String modName) throws EventException {
		try {
			dbDao.createBkgExecEnisLog(logDesc, applInfo, modName);			
			
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * Portal Customer 체크
	 * 
	 * @param String xterSndrId
	 * @param String custTpcd
	 * @param String custCd
	 * @return String
	 * @throws EventException
	 */
	public String checkPortalCustomerCd(String xterSndrId, String custTpcd, String custCd) throws EventException {
		String isExist = "N";
		try {
			isExist = dbDao.checkPortalCustomerCd(xterSndrId, custTpcd, custCd);			
			
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return isExist;	
	}
	
	
	/**
	 * e-svc a/k rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchXterAkRiderList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchXterAkRiderList(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}
	
	/**
	 * alps a/k rider search
	 * @param XterRqstNoVO xterRqstNoVO
	 * @return List<XterDgRiderVO>
	 * @throws EventException
	 */
	public List<XterDgRiderVO> searchAlpsAkRiderList(XterRqstNoVO xterRqstNoVO)
			throws EventException {
		try {
			return dbDao.searchAlpsAkRiderList(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 미주 서부임을 확인한다
	 * 
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 */
	public String searchUsWest(String locCd) throws EventException {
		String usWestFlag="";
		try {
			usWestFlag = dbDao.searchUsWest(locCd);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return usWestFlag;	
	}
	
	/**
	 * eBKG, eSI Upload 화주 Check Point 확인.<br>
	 * 
	 * @param xterRqstNoVO XterRqstNoVO
	 * @return XterCustChkPntVO
	 * @throws EventException
	 */
	public XterCustChkPntVO searchXterCustChkPnt(XterRqstNoVO xterRqstNoVO) throws EventException {
		XterCustChkPntVO xterCustChkPntVO= new XterCustChkPntVO();
		try {
			xterCustChkPntVO = dbDao.searchXterCustChkPnt(xterRqstNoVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return xterCustChkPntVO;	
	}
	
	/**
	 * BKG, eSI Upload 화주 Check Point 확인.<br>
	 * 
	 * @param String bkgNo
	 * @return XterCustChkPntVO
	 * @throws EventException
	 */
	public XterCustChkPntVO searchBkgCustChkPnt(String bkgNo) throws EventException {
		XterCustChkPntVO xterCustChkPntVO= new XterCustChkPntVO();
		try {
			xterCustChkPntVO = dbDao.searchBkgCustChkPnt(bkgNo);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
		return xterCustChkPntVO;	
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Container ETC 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return CntrEtcInfoVO
	 * @exception EventException
	 */
	public CntrEtcInfoVO searchXterSIEtcInfoForCntr(SIWebServiceVO sIWebServiceVO) throws EventException {
		CntrEtcInfoVO cntrEtcInfoVO = null;
		try {
			cntrEtcInfoVO = new CntrEtcInfoVO();
			cntrEtcInfoVO = dbDao.searchXterSIEtcInfoForCntr(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return cntrEtcInfoVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Container 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return ContainerVO[] 
	 * @exception EventException
	 */
	public ContainerVO[] searchXterSIContainer(SIWebServiceVO sIWebServiceVO) throws EventException {
		ContainerVO[] containerVOs= null;
		try {
			containerVOs = dbDao.searchXterSIContainer(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return containerVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Seal No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgCntrSealNoVO[] 
	 * @exception EventException
	 */
	public BkgCntrSealNoVO[] searchXterSISealNo(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgCntrSealNoVO[] bkgCntrSealNoVOs= null;
		try {
			bkgCntrSealNoVOs = dbDao.searchXterSISealNo(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgCntrSealNoVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Mnd 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return MndVO
	 * @exception EventException
	 */
	public MndVO searchXterSIMnd(SIWebServiceVO sIWebServiceVO) throws EventException {
		MndVO mndVO = null;
		try {
			mndVO = new MndVO();
			mndVO = dbDao.searchXterSIMnd(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return mndVO;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 XptImpLic 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return AlpsXptImpLicListVO[] 
	 * @exception EventException
	 */
	public AlpsXptImpLicListVO[] searchXterSIXptImpLicList(SIWebServiceVO sIWebServiceVO)  throws EventException {
		AlpsXptImpLicListVO[] alpsXptImpLicListVOs= null;
		try {
			alpsXptImpLicListVOs = dbDao.searchXterSIXptImpLicList(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return alpsXptImpLicListVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Indonesia XptImpLic 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return AlpsXptImpLicListVO[] 
	 * @exception EventException
	 */
	public XptImpLicVO[] searchXterSIIdXptImpLicList(SIWebServiceVO sIWebServiceVO) throws EventException {
		XptImpLicVO[] xptImpLicVOs= null;
		try {
			xptImpLicVOs = dbDao.searchXterSIIdXptImpLicList(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return xptImpLicVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 Container Po No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[] 
	 * @exception EventException
	 */
	public BkgReferenceVO[] searchXterSIPoOtherCntr(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgReferenceVO[] bkgReferenceVOs= null;
		try {
			bkgReferenceVOs = dbDao.searchXterSIPoOtherCntr(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgReferenceVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 B/L Rider 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BlRiderVO[] 
	 * @exception EventException
	 */
	public  BlRiderVO[] searchXterSIBlRider(SIWebServiceVO sIWebServiceVO) throws EventException {
		BlRiderVO[] BlRiderVOs= null;
		try {
			BlRiderVOs = dbDao.searchXterSIBlRider(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return BlRiderVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 BKG Po No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgReferenceVO[] 
	 * @exception EventException
	 */
	public BkgReferenceVO[] searchXterSIPoOtherNoBkg(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgReferenceVO[] bkgReferenceVOs= null;
		try {
			bkgReferenceVOs = dbDao.searchXterSIPoOtherNoBkg(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgReferenceVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 CM Po No 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgRefDtlVO[] 
	 * @exception EventException
	 */
	public BkgRefDtlVO[] searchXterSIPoOtherCm(SIWebServiceVO sIWebServiceVO) throws EventException {
		BkgRefDtlVO[] bkgRefDtlVOs= null;
		try {
			bkgRefDtlVOs = dbDao.searchXterSIPoOtherCm(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgRefDtlVOs;
	}
	
	/**
	 * external request 처리를 위해 external rqst의 CM 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return BkgRefDtlVO[] 
	 * @exception EventException
	 */
	public List<BkgCntrMfDescVO> searchXterSICntrMfDesc(SIWebServiceVO sIWebServiceVO) throws EventException {
		List<BkgCntrMfDescVO> bkgCntrMfDescVOs= null;
		try {
			bkgCntrMfDescVOs = dbDao.searchXterSICntrMfDesc(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgCntrMfDescVOs;
	}
	
	/**
	 * CMPB 산출된 Rate 정보 Add<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */			
	public void addSiBkgChgRate(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account)throws EventException {
		try{
			dbDao.addSiBkgChgRate(sIWebServiceVO, account);
		} catch (DAOException de) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * VGM 정보 Add<br>
	 *
	 * @param BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */				
	public void addBkgXterVrfdWgtRqst(BkgXterVrfdWgtRqstVO bkgXterVrfdWgtRqstVO, SignOnUserAccount account)throws EventException {
		try{
			dbDao.addBkgXterVrfdWgtRqst(bkgXterVrfdWgtRqstVO, account);
		} catch (DAOException de) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * VGM Party 정보 Add<br>
	 *
	 * @param BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */				
	public void addBkgXterVrfdWgtPty(BkgXterVrfdWgtPtyVO bkgXterVrfdWgtPtyVO, SignOnUserAccount account)throws EventException {
		try{
			dbDao.addBkgXterVrfdWgtPty(bkgXterVrfdWgtPtyVO, account);
		} catch (DAOException de) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * external request 처리를 위해 external rqst의 Charge 정보를 조회한다.<br>
	 * 
	 * @param SIWebServiceVO sIWebServiceVO
	 * @return List<BkgXterChgRtVO>
	 * @exception EventException
	 */
	public  List<BkgXterChgRtVO> searchXterSIChgRt(SIWebServiceVO sIWebServiceVO) throws EventException {
		List<BkgXterChgRtVO> bkgXterChgRtVOs= null;
		try {
			bkgXterChgRtVOs = dbDao.searchXterSIChgRt(sIWebServiceVO);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
        return bkgXterChgRtVOs;
	}
	
	 /**
     * Contract Sale Rep, Loading Rep Email를 조회한다.
     * 
     * @param SIWebServiceVO sIWebServiceVO
     * @return String
     * @throws EventException
     */
    public String searchXterSISrepEml(SIWebServiceVO sIWebServiceVO) throws EventException {
        try {
            return dbDao.searchXterSISrepEml(sIWebServiceVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    
    
    /**
	 * Interface로 Upload된 정보 Audit Flag Update<br>
	 *
	 * @param SIWebServiceVO sIWebServiceVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException 
	 */
	public int modifySIAuditFlag(SIWebServiceVO sIWebServiceVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.modifySIAuditFlag(sIWebServiceVO, account);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	 /**
		 * Interface로 Upload된 정보 Old MK Desc Update<br>
		 *
		 * @param SIWebServiceVO sIWebServiceVO
		 * @return int
		 * @throws EventException 
		 */
		public int modifySIOldMkDesc(SIWebServiceVO sIWebServiceVO) throws EventException {
			try {
				return dbDao.modifySIOldMkDesc(sIWebServiceVO);
			} catch (DAOException de) {
	            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
			}
		}
		
		/**
		 * BKG의 Charge 정보를 조회한다.<br>
		 * 
		 * @param String bkgNo
		 * @return List<BkgChgRateVO>
		 * @exception EventException
		 */
		public  List<BkgChgRateVO> searchBkgChgRt(String bkgNo)  throws EventException {
			List<BkgChgRateVO> bkgChgRateVOs= null;
			try {
				bkgChgRateVOs = dbDao.searchBkgChgRt(bkgNo);
	        } catch (DAOException de) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
	        return bkgChgRateVOs;
		}
		
		/**
		 * external request 처리를 위해 CMPB의 Charge 정보를 조회한다.<br>
		 * 
		 * @param SIWebServiceVO sIWebServiceVO
		 * @return List<BkgXterChgRtVO>
		 * @exception EventException
		 */
		public  List<BkgXterChgRtVO> searchCmpbChgRt(SIWebServiceVO sIWebServiceVO) throws EventException {
			List<BkgXterChgRtVO> bkgXterChgRtVOs= null;
			try {
				bkgXterChgRtVOs = dbDao.searchCmpbChgRt(sIWebServiceVO);
	        } catch (DAOException de) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
	        return bkgXterChgRtVOs;
		}
		
		/**
		 * external request 처리를 위해 external rqst의 Charge 정보를 조회한다.<br>
		 * 
		 * @param SIWebServiceVO sIWebServiceVO
		 * @return List<BkgXterChgRtVO>
		 * @exception EventException
		 */
		public  List<BkgXterChgRtVO> searchXterChgRt(SIWebServiceVO sIWebServiceVO) throws EventException {
			List<BkgXterChgRtVO> bkgXterChgRtVOs= null;
			try {
				bkgXterChgRtVOs = dbDao.searchXterChgRt(sIWebServiceVO);
	        } catch (DAOException de) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
	        return bkgXterChgRtVOs;
		}
		
		/**
		 * Customer의 Ratign 변경여부를 조회한다.<br>
		 *
		 * @param SIWebServiceVO sIWebServiceVO
		 * @return String
		 * @exception DAOException
		 */
		public String searchXterSIChgModFlg(SIWebServiceVO sIWebServiceVO) throws EventException {
			 try {
		            return dbDao.searchXterSIChgModFlg(sIWebServiceVO);
		        } catch (DAOException de) {
					log.error("err " + de.toString(), de);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
				} catch (Exception ex) {
					log.error("err " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
				}
		}
		
		/**
		 * external request 처리를 위해 external rqst의 HBL 정보를 조회한다.<br>
		 * 
		 * @param SIWebServiceVO sIWebServiceVO
		 * @return List<HblDtlInfoVO>
		 * @exception EventException
		 */
		public  List<HblDtlInfoVO> searchXterSIHbl1(SIWebServiceVO sIWebServiceVO) throws EventException {
			List<HblDtlInfoVO> hblDtlInfoVOs= null;
			try {
				hblDtlInfoVOs = dbDao.searchXterSIHbl1(sIWebServiceVO);
	        } catch (DAOException de) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
	        return hblDtlInfoVOs;
		}
		
		/**
		 * external request 처리를 위해 external rqst의 NVOCC의 AMS File No 및 Piece Count를 조회한다.<br>
		 * 
		 * @param SIWebServiceVO sIWebServiceVO
		 * @return BkgUsaCstmsFileNoVO[] 
		 * @exception EventException
		 */
		public BkgUsaCstmsFileNoVO[] searchXterSIHbl2(SIWebServiceVO sIWebServiceVO) throws EventException {
			BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs= null;
			try {
				bkgUsaCstmsFileNoVOs = dbDao.searchXterSIHbl2(sIWebServiceVO);
	        } catch (DAOException de) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
	        return bkgUsaCstmsFileNoVOs;
		}
		
		/**
		 * 
		 * @param rqstNo
		 * @param msg
		 * @throws EventException
		 */
		public void sendAutoBkgMail(String rqstNo, String msg) throws EventException {
			try {
				eaiDao.sendAutoBkgMail(rqstNo, msg);
	        } catch (DAOException de) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}
			
		}
		
		/**
		 * 
		 * @param msg
		 * @return
		 */
		public String[] getReceiptXterRqstEdiMsgType(String msg) throws EventException {
			String[] msgstart = msg.replaceAll("\\$\\$\\$MSGSTART:", "").split(" ");
			List<String> headers = new ArrayList<String>();
			for (int i = 0; i < msgstart.length; i++) {
				if(msgstart[i].trim().length() > 1) {
					if(msgstart[i].indexOf(":") > -1) msgstart[i] = msgstart[i].split(":")[1];
					headers.add(msgstart[i].trim());
				}
			}
//			headers[0] = msgstart.substring(0, 20).trim();
//			headers[1] = msgstart.substring(20, 40).trim();
//			headers[2] = msgstart.substring(40, 50).trim();
//			headers[3] = msgstart.substring(50, msgstart.length()).trim();
			return headers.toArray(new String[0]);
		}
}
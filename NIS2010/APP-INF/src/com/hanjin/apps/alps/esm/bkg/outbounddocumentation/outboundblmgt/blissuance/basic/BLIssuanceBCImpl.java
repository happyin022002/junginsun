/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceBCImpl.java
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.04.29 박준용
* 1.0 Creation
* -----------------------------------------------------------
* History
* 2010.11.17 이일민 [CHM-201006979-01] Draft B/L 메일 제목 변경 요청 (T/VVD 정보 추가)
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
* 2011.02.23 이일민 [CHM-201108785-01] (ALPS) WEB OBL auth cancle 기능
* 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로  Draft B/L 전송시  SENDER,RECEIVE Email 주소에 Front Office,동보수신 Email 주소 추가
* 2011.04.04 조원주 [CHM-201109863] Missing Name at B/L Preview 정정 요청
* 2011.04.11 이일민 [CHM-201109940-01] B/L Issue & Onboard date update 보완 요청
* 2011.05.02 최도순 [CHM-201108221-01][CSR] 전자선하증권 시범사업 Test 환경 구축
* 2011.08.09 김기종 [CHM-201112634-01] Draft B/L 발송 로직 변경 - 동보수신 삭제
* 2011.10.18 김종호 [CHM-201113664] ALPS EAI 연동 개발- 홈페이지 OBL 출력 시 ALPS에 정보 I/F 기능 추가 (Web0040001)
* 2011.10.20 김종호 [CHM-201113688] ALPS EAI 연동 개발- 홈페이지 BL 발급요청 시 ALPS에 정보 I/F 기능 추가 (Web0050001)
* 2011.12.01 김종호 [CHM-201114841] [BKG] B/L 발급 신청 수정 요청
* 2012.07.16 김보배 [CHM-201217208] [BKG] DRAFT B/L 을 화주(LG PANTOS)의 FPT에 직접 등록 요청
* 2013.04.16 김태경 [CHM-201323803] VFC 310 정보 추가 전송 관련 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration.BookingHistoryMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderEAIDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration.BLIssuanceDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration.BLIssuanceEAIDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgBlIssRqstMailSndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssHisVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgDocIssRdemVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgSrEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService005VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlAtchVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlCertiRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblCntVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblEQVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.FaxSendVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MailSendVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.N3ptyBlRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchReminderEmailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgBlIssInfoVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.ftp.Ftp;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.table.BkgAutoEmlVO;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtHisVO;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtVO;
import com.hanjin.syscommon.common.table.BkgHisDtlVO;
import com.hanjin.syscommon.common.table.BkgHisMstVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
/**
 * NIS2010-OutboundBLMgt Business Logic Basic Command implementation<br>
 * - NIS2010-OutboundBLMgt에 대한 비지니스 로직을 처리한다.<br>
 *      
 * @author Joon Yong Park
 * @see esm_bkg_0278EventResponse,BLIssuanceBC 각 DAO 클래스 참조 
 * @since J2EE 1.4
 */

public class BLIssuanceBCImpl extends BasicCommandSupport implements BLIssuanceBC {
               
    // Database Access Object
    private transient BLIssuanceDBDAO dbDao = null;
    private transient BLIssuanceEAIDAO bleaiDao = null;
    //private transient CargoReleaseOrderDBDAO dbCargo = null;
    private transient CargoReleaseOrderEAIDAO eaiDbDao = null;
    private transient BookingHistoryMgtDBDAO histDao = null;
    
    public SimpleDateFormat yyyymmddhh24missFormat = new SimpleDateFormat ("yyyyMMddHHmmss") ;
    
    /**
     * BLIssuanceBCImpl 객체 생성<br>
     * BLIssuanceDBDAO를 생성한다.<br>
     */
    public BLIssuanceBCImpl() {
        dbDao = new BLIssuanceDBDAO();
        bleaiDao = new BLIssuanceEAIDAO();
        eaiDbDao = new CargoReleaseOrderEAIDAO();
        //dbCargo = new CargoReleaseOrderDBDAO();
        histDao = new BookingHistoryMgtDBDAO();
    }
    
	/**
	 * EsmBkg1074Event 조회 이벤트 처리<br>
	 * Internet O.B/L Print Authorize[UC-BKG-009 B/L 발행 송부]
	 * B/L Issue 화면(UI_BKG-0079-09) 의 Internet Auth 버튼에 연결된 팝업
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @return List<AuthCustVO>
	 * @exception EventException
	 */
	public List<AuthCustVO> searchCustInfo(String bkgNo) throws EventException{
		List<AuthCustVO> list = null;
		
        try {
            // 01. validation을 수행한다.
            
            // 02. 비즈니스 로직 수행
        	list = dbDao.searchCustInfo(bkgNo);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }		
		return list;
	}
	
	/**
	 * EsmBkg007909Event 조회 이벤트 처리<br>
	 * B/L validateBlIssue 체크 <br>
	 * @author LEE JIN SEO
	 * @param BlIssInfoVO blIssInfoVO
	 * @return BlStatusVO
	 * @exception EventException
	 */
	public BlStatusVO validateBlIssue(BlIssInfoVO blIssInfoVO) throws EventException{
		BlStatusVO blsvo = null;
		
        try {
            // 01. validation을 수행한다.
            
            // 02. 비즈니스 로직 수행
        	blsvo = dbDao.searchBlStatus(blIssInfoVO); 
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }		
		return blsvo;
	}
    
    /**
     * EsmBkg007909Event 조회 이벤트 처리<br>
     * B/L Issue 정보 조회<br>
     * B/L Type, Freight 지불 여부 등의 B/L 발행 전 필요사항을 기입
     * @author LEE JIN SEO
     * @param BlIssueVO blIssueVO
     * @return BlIssueVO
     * @exception EventException
     */

    public  BlIssueVO searchBlIssInfo(BlIssueVO blIssueVO) throws EventException {
    log.debug("============================>[[ BLIssuanceBCImpl  searchBlIssInfo START ]]<============================");

        String bkg_no = blIssueVO.getBkg_no();
        String bl_no  = blIssueVO.getBl_no();
        SignOnUserAccount  account = blIssueVO.getAccount();
      
        try {
            // 01. 조회를 수행한다.
            //BlIssInfoList : 결과값 setting 
            List<BlIssInfoVO> rBlIssInfoVO = dbDao.searchBlIssInfo(bkg_no,account.getUsr_id());
            //VesselVoyagedList : 결과값 setting
            blIssueVO.setVesselVoyagedList(dbDao.searchComboVVDInfo(bkg_no,""));
            //PreCarriageList : 결과값 setting
            blIssueVO.setPreCarriageList(dbDao.searchComboVVDInfo(bkg_no,"S"));
            //Bl_ready_no validation checked 
            blIssueVO.setBl_not_ready(dbDao.searchBLNotReady(bkg_no));
            
            //if(false){
            if(rBlIssInfoVO.size()>0){
            	OtsRcvInfoVO otsRcvInfoVO = this.searchErpOtsInfo(bl_no);
               // OtsRcvInfoVO otsRcvInfoVO = eaiDbDao.searchOtsInfo(bl_no);
                //OtsRcvInfoVO : 결과값 setting 
                String pptStsCd         =   otsRcvInfoVO.getPptStsCd();
                String pptRcvOfcCd      =   otsRcvInfoVO.getPptRcvOfcCd();
                String cctStsCd         =   otsRcvInfoVO.getCctStsCd();
                String cctRcvOfcCd      =   otsRcvInfoVO.getCctRcvOfcCd();
                String n3ptyPptStsCd    =   otsRcvInfoVO.getN3ptyPptStsCd();
                String n3ptyPptRcvOfcCd =   otsRcvInfoVO.getN3ptyPptRcvOfcCd();
                String n3ptyCctStsCd    =   otsRcvInfoVO.getN3ptyCctStsCd();
                String n3ptyCctRcvOfcCd =   otsRcvInfoVO.getN3ptyCctRcvOfcCd();
                rBlIssInfoVO.get(0).setPpdRcv(pptStsCd);
                rBlIssInfoVO.get(0).setPpdOffice(pptRcvOfcCd);
                rBlIssInfoVO.get(0).setTrdPpdRcv(n3ptyPptStsCd);
                rBlIssInfoVO.get(0).setTrdPpdOffice(n3ptyPptRcvOfcCd);
                rBlIssInfoVO.get(0).setCctRcv(cctStsCd);
                rBlIssInfoVO.get(0).setCctOffice(cctRcvOfcCd);
                rBlIssInfoVO.get(0).setTrdCctRcv(n3ptyCctStsCd);
                rBlIssInfoVO.get(0).setTrdCctOffice(n3ptyCctRcvOfcCd);
                log.debug("=============================================");
                log.debug(" [연계] Outstanding Amounts 조회 결과값 ");
                log.debug("=============================================");
                log.debug("pptStsCd:"+pptStsCd);
                log.debug("pptRcvOfcCd:"+pptRcvOfcCd);
                log.debug("cctStsCd:"+cctStsCd);
                log.debug("cctRcvOfcCd:"+cctRcvOfcCd);
                log.debug("n3ptyPptStsCd:"+n3ptyPptStsCd);
                log.debug("n3ptyPptRcvOfcCd:"+n3ptyPptRcvOfcCd);
                log.debug("n3ptyCctStsCd:"+n3ptyCctStsCd);
                log.debug("n3ptyCctRcvOfcCd:"+n3ptyCctRcvOfcCd);
                blIssueVO.setOtsRcvInfoVO(otsRcvInfoVO);
            }
            // 최종 결과값 Container VO
            blIssueVO.setBlIssInfoList(rBlIssInfoVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
        }
        return blIssueVO ;
    }
    /**
     * ERP I/F를 위한 EAIDAO 호출
     *
     * @param String blNo
     * @return OtsRcvInfoVO
     * @exception EventException
     */
    public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException {
        OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
        try {
            log.debug("ERP I/F를 위한 EAIDAO 호출");            
            otsRcvInfoVO = eaiDbDao.searchOtsInfo(blNo);
            if(otsRcvInfoVO.getTotOtsAmt1() == null 
            		|| otsRcvInfoVO.getTotOtsAmt1().trim().equals("")
            		|| otsRcvInfoVO.getTotOtsStsCd() == null
            		|| otsRcvInfoVO.getTotOtsStsCd().trim().equals("")
            		){
            	otsRcvInfoVO.setTotOtsStsCd("");            
                otsRcvInfoVO.setTotOtsAmt1("N/A");
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            otsRcvInfoVO.setTotOtsStsCd("");            
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
            //throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            otsRcvInfoVO.setTotOtsStsCd("");            
            otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
            //throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return otsRcvInfoVO;
    }
    /**
     * EsmBkg007909Event 저장 이벤트 처리<br>
     * bl issue 관련 정보를 관리한다.<br>
     * 
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssInfo(BlIssInfoVO blIssInfoVO) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  manageBlIssInfo START ]]<============================");

        try {
        	// if the input office code is invalid, err msg will throw         	
            
        	
          	String valFlg = dbDao.validateBLIssOfcCd( blIssInfoVO.getBlIssueAt());
	        if ("N".equals(valFlg)) {
					throw new EventException(new ErrorHandler("BKG00905").getMessage());
					   
			}
        	
            // 02. 비즈니스 로직 수행
            dbDao.manageBlIssInfo(blIssInfoVO);
            
        } catch(EventException ex) {
            throw ex;
        }  catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }

    }
    /**
     * EsmBkg007909Event 저장 이벤트 처리<br>
     * bl issue 관련 정보를 관리한다.<br>
     * 1. Issue Type에 따라 아래와 같이 업데이트 한다.
     							B/L type  Issued	     Released	Internet Auth
		Internet Auth			B			Y			Y			Y
		O.B/L Release			B			Y			Y			N
		SWB Release				W			Y			Y			N
		Issue          			null		Y			N			N
		Cancel Release			null		N			N			N
		Cancel Auth				null		N			N			N
		
		btn_t11InternetAUTH
		btn_t11OBLRelease
		btn_t11SWBRelease
		btn_t11Issue
		btn_t11CancelRelease
		btn_t11CancelAUTH

		,BKG_BL_DOC.BL_OBRD_TP_CD		on_board_type
		,BKG_BL_ISS.OBL_ISS_FLG			issued
		,BKG_BL_ISS.OBL_RLSE_FLG		released
		,BKG_BL_ISS.OBL_INET_FLG		internet_auth
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException{
    	log.debug("[1][======== [BLIssuanceBC] :: manageBlIssueFlg ]==========");
    	
    	String bkgNo 	  = blIssInfoVO.getBkgNo();
    	String blNo 	  = blIssInfoVO.getBlNo();
    	String buttonType = blIssInfoVO.getButtontype();
    	log.debug("[1][======== [BLIssuanceBC] :: bkgNo ]=========="+bkgNo);
    	log.debug("[1][======== [BLIssuanceBC] :: blNo ]=========="+blNo);
    	log.debug("[1][======== [BLIssuanceBC] :: buttonType ]=========="+buttonType);
    	
        try {        	
        	
        	String valFlg = dbDao.validateBLIssOfcCd( blIssInfoVO.getBlIssueAt());
	        if ("N".equals(valFlg)) {
					throw new EventException(new ErrorHandler("BKG00905").getMessage());
					   
			}
        	  
        	//버튼액션을 취하기 전에 우선적으로 화면의 데이터 값을 저장처리를 한다.
        	manageBlIssInfo(blIssInfoVO);
        	
        	// validation 
            BookingUtil bookingUtilBC = new BookingUtil();
            BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
            bkgBlNoIn.setBkgNo(bkgNo);
            bkgBlNoIn.setBlNo(blNo);
    		bkgBlNoIn.setCaUsrId(blIssInfoVO.getUpdUsrId());
            BkgBlNoVO bkgBlNoOut = bookingUtilBC.searchBkgBlNoVO(bkgBlNoIn);
            if(bkgBlNoOut == null) {
                throw new Exception(new ErrorHandler("BKG08073").getMessage());
            }
            // Cancel된 booking은  처리 않는다.
            if("X".equals(bkgBlNoOut.getBkgStsCd())) {
                // TODO
                throw new Exception(new ErrorHandler("BKG08073").getMessage());
            }
           
            // 00. button setting 
        	if(buttonType.equals("btn_t11InternetAUTH")){
            	blIssInfoVO.setBlIssueblType("B");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("Y");
        	}else if(buttonType.equals("btn_t11OBLRelease")){
            	blIssInfoVO.setBlIssueblType("B");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11SWBRelease")){
            	blIssInfoVO.setBlIssueblType("W");
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("Y");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11Issue")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("Y");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11CancelRelease")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("N");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}else if(buttonType.equals("btn_t11CancelAUTH")){
            	blIssInfoVO.setBlIssueblType(null);
            	blIssInfoVO.setIssued("N");
            	blIssInfoVO.setReleased("N");
            	blIssInfoVO.setInternetAuth("N");
        	}

            // 01. Flg 변경 BLIssuanceDBDAO::manageBlIssueFlg ( bkgNo , issueType )/manageBlIssueFlg ( [in] bkgNo : String , [in] issueType : String ) : void
            dbDao.manageBlIssueFlg(blIssInfoVO);

            // 02. issue InterAuth / CancelAuth  
            if(buttonType.equals("btn_t11InternetAUTH") || buttonType.equals("btn_t11CancelAUTH")){
            	log.debug("###########################issue InterAuth / CancelAuth##########################?"+blIssInfoVO.getButtontype());
                dbDao.manageIntAuth(blIssInfoVO);
            }

            log.debug("[2][======== [BLIssuanceBC] :: manageBlIssueFlg ]==========");

        } catch(EventException ee) {
            throw ee;
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }   
    
	/**
	 * EsmBkg1074Event 조회 이벤트 처리<br>
	 * sendAuthEmail 발행 송부]
	 * B/L Issue 화면(UI_BKG-0079-09) 의 Internet Auth 버튼에 연결된 팝업
	 * @author LEE JIN SEO
	 * @param Mail amail
	 * @exception EventException
	 */
    public void sendAuthEmail(Mail amail) throws EventException {
		try {
			bleaiDao.sendInternetAuthMail(amail);
		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}   

    /**
     * EsmBkg0649Event 조회 이벤트 처리<br>
     * B/L searchBlReIssue 정보 조회<br>
     * @author LEE JIN SEO
     * @param String bkg_no
     * @return ReIssueVO
     * @exception EventException
     */
    public ReIssueVO searchBlReIssue(String bkg_no) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  searchBlReIssue START ]]<============================");
        ReIssueVO reIssueVO = new ReIssueVO();
        try {
            
            //<BL로 조회한 경우>
            //  -> [] BookingUtilBC::searchBkgNoByBlNo ( blNo )
            // 01. 조회를 수행한다.  SC로 이동함

            //[] BLIssuanceDBDAO::searchBlReIssueInfo ( bkgNo )
            //B/L Issue 정보 조회
            //«» searchBlReIssueInfo ( [in] bkgNo : String ) : ReIssueInfoVO
            reIssueVO.setReIssueInfoVO(dbDao.searchBlReIssueInfo(bkg_no));

            //[] BLIssuanceDBDAO::searchBlReIssueHist ( bkgNo )
            //B/L Issue History 정보 조회
            //«» searchBlReIssueHist ( [in] bkgNo : String ) : BkgDocIssHisVO
            reIssueVO.setBkgDocIssHisVO(dbDao.searchBlReIssueHist(bkg_no));
            
            //[] BLIssuanceDBDAO::searchBlReIssueCollect ( bkgNo )
            //B/L Issue Collect 정보 조회
            //«» searchBlReIssueCollect ( [in] bkgNo : String ) : BkgDocIssRdemVO[]
            reIssueVO.setBkgDocIssRdemVO(dbDao.searchBlReIssueCollect(bkg_no));
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
        return reIssueVO ; 
    }
    
    /**
     * EsmBkg0649Event 저장 이벤트 처리<br>
     * B/L Re-Issue  정보를 추가/수정한다.<br>
     * 
     * @author LEE JIN SEO
     * @param ReIssueVO reIssueVO
     * @exception EventException
     */
    public void manageBlReIssue(ReIssueVO reIssueVO) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  manageBlReIssue START ]]<============================");
    
        List<BkgDocIssHisVO> bkgDocIssHisVOList     = new ArrayList<BkgDocIssHisVO>();
        
        SignOnUserAccount account = reIssueVO.getAccount();
        String userID = account.getUsr_id();
        String bkgNo = reIssueVO.getBkg_no();
        BlIssInfoVO blIssInfoVO = null;
       
        try {

        		//[] IBLIssuanceBC::manageBlReIssue ( reIssue )
                //[] BLIssuanceDBDAO::manageBlReIssue ( docIssHis )
                //Re-Issue History에 행을 추가한다.
                //No.(회수 Count)가 '0' 인 경우는 저장하지 않는다.
                //«» manageBlReIssue ( [in] docIssHis : BkgDocIssHisVO ) : void
                
                BkgDocIssHisVO[]  bkgDocIssHisVOs = reIssueVO.getBkgDocIssHisVOs();
                if(bkgDocIssHisVOs != null){
                    int cntHis = bkgDocIssHisVOs.length;
                    for(int i = 0; i < cntHis; i++) {
                        bkgDocIssHisVOs[i].setBkgNo(bkgNo);
                        bkgDocIssHisVOs[i].setCreUsrId(userID);
                        bkgDocIssHisVOs[i].setUpdUsrId(userID);
                        bkgDocIssHisVOList.add(bkgDocIssHisVOs[i]);
                    }
                    dbDao.manageBlReIssue(bkgDocIssHisVOList);
                }

                //FOR문으로 처리 
                //[] BLIssuanceDBDAO::manageBlReIssueCollect ( docIssRdem )
                //B/L Re-Issue Colliect 정보를 추가/수정한다.
                //«» manageBlReIssueCollect ( [in] docIssRdem : BkgDocIssRdemVO )
                
                BkgDocIssRdemVO[]  bkgDocIssRdemVOs = reIssueVO.getBkgDocIssRdemVOs();
                List<BkgDocIssRdemVO> insertVoList   = new ArrayList<BkgDocIssRdemVO>();
                List<BkgDocIssRdemVO> updateVoList   = new ArrayList<BkgDocIssRdemVO>();
                List<BkgDocIssRdemVO> deleteVoList   = new ArrayList<BkgDocIssRdemVO>();
                if(bkgDocIssRdemVOs != null){
                    int cntRdem = bkgDocIssRdemVOs.length;
                    for(int i = 0; i < cntRdem; i++) {
                    	
                    	if("0".equals(bkgDocIssRdemVOs[i].getIssRdemKnt())){
                    		//seq 가 있으면 update
                    		bkgDocIssRdemVOs[i].setBkgNo(bkgNo);
                            deleteVoList.add(bkgDocIssRdemVOs[i]);

                    	}else {
                    		
                            if(bkgDocIssRdemVOs[i].getHisSeq() == null || bkgDocIssRdemVOs[i].getHisSeq().length() == 0 ){
                        		//seq 가 없으면 insert 
                        		bkgDocIssRdemVOs[i].setBkgNo(bkgNo);
                                bkgDocIssRdemVOs[i].setCreUsrId(userID);
                                bkgDocIssRdemVOs[i].setUpdUsrId(userID);
                                insertVoList.add(bkgDocIssRdemVOs[i]);
                                
                        	}else{
                        		//seq 가 있으면 update
                        		bkgDocIssRdemVOs[i].setBkgNo(bkgNo);
                                bkgDocIssRdemVOs[i].setUpdUsrId(userID);
                                updateVoList.add(bkgDocIssRdemVOs[i]);
                        	}
                    	}
                    }
                    // DB에 저장한다. 
                    if(deleteVoList.size() > 0) {
                    	dbDao.manageBlReIssueCollect(deleteVoList,"D");
                    }
                    if(insertVoList.size()>0){
                        dbDao.manageBlReIssueCollect(insertVoList,"C");
                    }
                    if(updateVoList.size()>0){
                        dbDao.manageBlReIssueCollect(updateVoList,"U");
                    }
                }

                

	        	
                //Comfirm할경우 
        		if("COMFIRM".equals(reIssueVO.getCommand_type())){
	        		 dbDao.confirmBlReIssue(bkgNo);
	        		 
	        		 
	 	        	blIssInfoVO = new BlIssInfoVO();
		        	blIssInfoVO.setBkgNo(bkgNo);
		        	blIssInfoVO.setUpdUsrId(userID);
		        	blIssInfoVO.setUpdOffice(account.getOfc_cd());
		        	dbDao.manageIntAuth(blIssInfoVO);
		        	
		        	
	 	        	/* Issue/Release Cancel 의 History 누락 방지를 위해 B/L Issue 의 OBL Issue Flg 미리 update 한다.  */
	 	        	blIssInfoVO.setIssued("N");
	 	    		blIssInfoVO.setOblIssFlg("N");
	 	    		blIssInfoVO.setReleased("N");
	 	    		blIssInfoVO.setInternetAuth("N");
	 	        	
	 	        	dbDao.manageBlIssueFlg(blIssInfoVO);
        		}



        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  manageBlReIssue END ]]<============================");
    }
   
    /**
     * EsmBkg0400Event 조회 이벤트 처리<br>
     * O.B/L Surrender 데이터 조회<br>
     * 
     * @author LEE JIN SEO
     * @param String bkg_no
     * @param String bl_no
     * @return List<SrndVO>
     * @exception EventException
     */
    public List<SrndVO> searchSurrenderInfo(String bkg_no,String bl_no)  throws EventException {
    log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo START ]]<============================");
        List<SrndVO> rlst = null;
        
        try {
            
            //<BL로 조회한 경우>
        	if(bkg_no.length() == 0 && bl_no.length() > 0 ){
      		  BookingUtil bookingUtilBC = new BookingUtil();
      		  if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
      		  bkg_no = bookingUtilBC.searchBkgNoByBlNo(bl_no);	
        	}
        	
            // 01. 조회를 수행한다.
            rlst = dbDao.searchSurrenderInfo(bkg_no, bl_no);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  searchSurrenderInfo END ]]<============================");
        return rlst ; 
    }
    /**
     * EsmBkg0400Event 저장 이벤트 처리<br>
     * B/L 정보에서 Surrender 관련사항을 업데이트 한다<br>
     * 
     * @author LEE JIN SEO
     * @param SrndVO srndvo
     * @exception EventException
     */
    public void modifySurrenderInfo(SrndVO srndvo)  throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst START ]]<============================");

            String bkg_no       = srndvo.getBkgNo();
            String bl_no        = srndvo.getBlNo();
            //SignOnUserAccount ssoAcount = srndvo.getAccount();
            String errorMessage = "";
            /*1) 설명
            -OBL을 surrender(포기) 처리한다.
            -특정화주가 OBL이 불필요하며 발행자체를 원치 않을 경우 사용한다.
            -surrender와 동시에 redemption(화수) 된 것으로 처리한다.-- UI_BKG-0400
            */          
        try {

            //비즈니스 로직 수행

            
            //1. 해당 BKG No로 조회한다.
            //1. -> [] IBLIssuanceBC::modifySurrenderInfo ( srndvo )
                //[] BLIssuanceDBDAO::searchDoStatus ( bkgNo )
                //D/O Status를 조회한다.
                //SELECT 'X'  FROM  BKG_DO WHERE BKG_NO =@[bkg_no]
                //«» searchDoStatus ( [in] bkgNo : String ) : String
                String result  = (String)dbDao.searchDoStatus(bkg_no);
                if(result != null){
                	errorMessage = (String)new ErrorHandler("BKG00434").getMessage();
                    throw new EventException((String)new ErrorHandler("BKG00434").getMessage());               	
                }
                else if(result == null){
                //아직 deliver_order 가 되지 않은상태 
                    
                    //2. 예외조건을 검사한다. D/O status 포함
                        //[] BLIssuanceDBDAO::searchSurrenderInfo ( bkgNo , blNo )
                        //O.B/L Surrender 데이터 조회
                        //«» searchSurrenderInfo ( [in] bkgNo : String , [in] blNo : String ) : SrndVO
                    List<SrndVO> srndVOList =  dbDao.searchSurrenderInfo( bkg_no, bl_no);
                    
                    if(srndVOList.size()>0){
                        SrndVO rSrndvo = srndVOList.get(0);
                        /*
                        1. Booking 이 cancel 된 경우 [BKG08073]
                        2. O.B/L이 아닌 경우 [BKG00372]
                        3. B/L이 release가 안된 경우 [BKG00373]
                        4. 이전 Surrender 부서와 현재 로긴 부서가 다른 경우 [BKG00382]
                        5. D/O issue 된 경우 [BKG00434]
                        6. Issue Date보다 surrender date가 이전인 경우 [BKG00436]
                        7. 발행본과 회수본수가 틀린 경우 [BKG00437]
                        8. B/L 발행 점소 country와 DEST Country가 같은 경우 [BKG00435]
                        9. Order B/L일 경우 [BKG00374]
                        */

                        //F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, 처음상태는 W
                        //: bkg_sts_cd = 'X'
                        if("X".equals(rSrndvo.getBkgStsCd())){
                        	errorMessage = (String)new ErrorHandler("BKG08073").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG08073").getMessage());
                            
                        }
                        //OBL_RDEM_KNT
                        //: bkg_booking.bl_tp_cd = 'W' 이면 obl이 아님
                        else if("W".equals(rSrndvo.getBlTpCd())){
                        	errorMessage = (String)new ErrorHandler("BKG00372").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00372").getMessage());
                            
                        }
                        //OBL_RLSE_FLG
                        //: BKG_BL_ISS.OBL_RLSE_FLG == "N"
                        else if("N".equals(rSrndvo.getOblRlseFlg())){
                        	errorMessage = (String)new ErrorHandler("BKG00373").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00373").getMessage());
                            
                        }
                        //OBL_RDEM_OFC_CD
                        //: BKG_BL_ISS.OBL_RDEM_OFC_CD와 session의 부서가 다른경우   by 전성진 삭제요청 
                        /*else if(!rSrndvo.getOblRdemOfcCd().equals(ssoAcount.getOfc_cd())){
                            throw new EventException((String)new ErrorHandler("BKG00382").getMessage());
                            
                        }*/
                        //DO_ISUUE :: D/O Release Flg
                        /*else if("Y".equals(rSrndvo.getDoIsuue())){
                        	errorMessage = (String)new ErrorHandler("BKG00434").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00434").getMessage());
                            
                        }*/
                        //  OBL_ISS_DT > OBL_RDEM_DT    
                        else if(Integer.parseInt(rSrndvo.getOblIssDt().replace("-", "")) > Integer.parseInt(srndvo.getOblRdemDt().replace("-", "")) ){
                        	errorMessage = (String)new ErrorHandler("BKG00436").getMessage();
                        	//throw new EventException((String)new ErrorHandler("BKG00436").getMessage());
                        	throw new EventException(new ErrorHandler("BKG00436", new String[] { rSrndvo.getOblIssDt() }).getMessage());                            
                        }
                        //OBL_RDEM_KNT  != OBL_ISS_KNT
                        else if(!srndvo.getOblRdemKnt().equals(srndvo.getOblIssKnt())){
                        	errorMessage = (String)new ErrorHandler("BKG00437").getMessage();
                            //throw new EventException((String)new ErrorHandler("BKG00437").getMessage());
                        	throw new EventException(new ErrorHandler("BKG00437", new String[] { srndvo.getOblRdemKnt(), srndvo.getOblIssKnt() }).getMessage());
                        }
                        //8.Issue Office B/L 발행 점소 country와 DEST Country가 같은 경우 [BKG00435]
                        else if(rSrndvo.getDelCd().substring(1,2).equals(rSrndvo.getCntCd())){
                        	errorMessage = (String)new ErrorHandler("BKG00372").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00372").getMessage());
                            
                        }                       
                        //9. Order B/L일 경우 [BKG00374]
                        //Y/N Order B/L :: : BKG_BOOKING.CUST_TO_ORD_FLG
                        else if("Y".equals(rSrndvo.getCustToOrdFlg())){
                        	errorMessage = (String)new ErrorHandler("BKG00372").getMessage();
                            throw new EventException((String)new ErrorHandler("BKG00372").getMessage());
                        }
    
                        //3. B/L 정보에서 Surrender 관련사항을 업데이트 한다.
                            //[] BLIssuanceDBDAO::modifySurrenderInfo ( srnd )
                            //B/L 정보에서 Surrender 관련사항을 업데이트 한다. -- UI_BKG-0079-09
                            //«» modifySurrenderInfo ( [in] srnd : SrndVO ) : void
 
                        dbDao.modifySurrenderInfo(srndvo);
                    
                    }

                }
                
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(errorMessage, new String[]{}).getMessage(),ex);
        } catch (EventException evtEx) {
        	throw evtEx;
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(errorMessage, new String[]{}).getMessage(),ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst END ]]<============================");
    }
    /**
     * EsmBkg0400Event 삭제 이벤트 처리<br>
     * B/L 정보에서 Surrender 관련사항을 초기화 한다<br>
     * 
     * @author LEE JIN SEO
     * @param String bkg_no
     * @exception EventException
     */
    public void removeSurrenderInfo(String bkg_no)  throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  removeSurrenderInfo START ]]<============================");

        try {

            //비즈니스 로직 수행
            //Surrender 정보를 초기화 한다.
            //«» removeSurrenderInfo ( [in] bkgNo : String ) : void
            dbDao.removeSurrenderInfo(bkg_no);
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  removeSurrenderInfo END ]]<============================");
    }
    /**
     * EsmBkg00059Event 조회 이벤트 처리<br>
     * Documentation Requirement(ESM_BKG-0079 의 B/L INFO의 POP-UP)<br>
     * 화면번호 : Documentation Requirement 데이터를 조회 -- UI_BKG-0059 <br>
     * 
     * @author LEE JIN SEO
     * @param String bkg_no
     * @param String ofc_cd
     * @return List<DocRqstVO>
     * @exception EventException
     */
    public List<DocRqstVO> searchDocRqst(String bkg_no ,String ofc_cd) throws EventException {
    log.debug("============================>[[ BLIssuanceBCImpl  searchDocRqst START ]]<============================");
        List<DocRqstVO> rlst = null;
        
        try {
            // 01. 조회를 수행한다.
            rlst = dbDao.searchDocRqst(bkg_no,ofc_cd);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  searchDocRqst END ]]<============================");
        return rlst ; 
    }
    /**
     * EsmBkg00059Event 저장 이벤트 처리<br>
     * Documentation Requirement 데이터를 수정한다. -- UI_BKG-0059<br>
     * 
     * @author LEE JIN SEO
     * @param DocRqstVO docrqstvo
     * @exception EventException
     */
    public void modifyDocRqst(DocRqstVO docrqstvo) throws EventException{
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst START ]]<============================");
	
	    // 01. validation을 수행한다.
		BookingUtil bookingUtil = new BookingUtil();
	    BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
	    bkgBlNoIN.setBkgNo(docrqstvo.getBkgNo());
		bkgBlNoIN.setCaUsrId(docrqstvo.getUserId());
		
        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            //caFlag
            docrqstvo.setCaflag(bkgBlNoVO.getCaFlg());
            
            // 02. 비즈니스 로직 수행
            if(dbDao.modifyDocRqst(docrqstvo) == 0){
            	dbDao.addDocRqst(docrqstvo);
            }
            
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    log.debug("============================>[[ BLIssuanceBCImpl  modifyDocRqst END ]]<============================");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * 조회 이벤트 처리
     *  MultiCombo 조회 이벤트 처리 ESM_BKG_0278
     *
     * @param bkgComboVO
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws EventException {
        try {
            return dbDao.searchSRouteFromList(bkgComboVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리
     *  ESM_BKG_0280화면에 대한 조회 이벤트 처리
     *
     * @param grpBlPrtInVO
     * @return GrpBlPrtOutVO
     * @exception EventException
     */
    public GrpBlPrtOutVO searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws EventException {
        //컨테이너 vo
        GrpBlPrtOutVO grpBlPrtOutVO = new GrpBlPrtOutVO();
        try {
            List<GrpBlPrtVO> grpBlPrt = dbDao.searchBkgListForGrpBlPr(grpBlPrtInVO);

            // 컨테이너vo에 담는다.
            grpBlPrtOutVO.setGrpBlPrts(grpBlPrt);

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return grpBlPrtOutVO;
    }
    
    /**
     * Original B/L 회수 여부와 상세 정보 입력 이벤트 처리<br>
     * @param blIssueVO 
     * @exception EventException
     */
    public void manageOblRcv(BlIssVO blIssueVO) throws EventException {
        try {
        	/*
        	 * default initilize
        	 * if ida
        	 *     if (rdem >0 ||  (lg/lc && accept ))  && inbound doc Y then Y)  -- 20091109 수정 
        	 *     else N
        	 * else
        	 *     if rdem >0, or lg/lc & accept then Y
        	 *     else N 
        	 * end
        	 */
        	
        	if (blIssueVO.getOblRdemKnt() == null || blIssueVO.getOblRdemKnt().equals("")) {
        		// OB/L Redemption Count는 0건 이상이다. 
        		// null 값이 들어가지 않도록 처리한다.
        		blIssueVO.setOblRdemKnt("0");
        	}
        	
        	if (blIssueVO.getDelCntCd() != null && blIssueVO.getDelCntCd().equals("IN")) {
        		//bl_otr_doc_rcv_cd
        		//otr_doc_cgor_flg
        		// ida_bl_entr_rcv_flg
        		if ( (  (Integer.parseInt(blIssueVO.getOblRdemKnt()) > 0)
        		      ||(blIssueVO.getBlOtrDocRcvCd() != null && blIssueVO.getOtrDocCgorFlg() != null && blIssueVO.getOtrDocCgorFlg().equals("Y"))
        		     ) &&
        			  (blIssueVO.getIbdDocRcvFlg() != null && blIssueVO.getIbdDocRcvFlg().equals("Y"))
         		    )
        		{
        			blIssueVO.setOblRdemFlg("Y");
        			
        		} else {
        			blIssueVO.setOblRdemFlg("N");
        		}
        	} else {
        		//obl_rdem_knt
        		//bl_otr_doc_rcv_cd
        		//otr_doc_cgor_flg
        		if (  (Integer.parseInt(blIssueVO.getOblRdemKnt()) > 0)
        			||(blIssueVO.getBlOtrDocRcvCd().length()> 1 && blIssueVO.getOtrDocCgorFlg().equals("Y")) 
        		   ) 
        	    {
        			blIssueVO.setOblRdemFlg("Y");
        			
        		} else {
        			blIssueVO.setOblRdemFlg("N");
        		}
        	}
            int result = dbDao.modifyOblRcvByIbd(blIssueVO);
            
            if(result == 0){
            	log.debug("manageOblRcv 메소드 실행결과 0건 수정 신규입력 메소드 호출");
            	dbDao.addOblRcvByIbd(blIssueVO);
            }

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * [0909] Original Bill of Lading Status 수정
     *
     * @param BkgBlIssVO[] blStatusVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageOblRcvByUsCgo(BkgBlIssVO[] blStatusVOs,SignOnUserAccount account) throws EventException {

        try {

            BkgBlIssVO blStatusVO = null;

            // 1번만 실행됨.
            for (int i = 0; i < blStatusVOs.length; i++) {
                blStatusVO = blStatusVOs[i];
                log.debug("------------------ blStatusVO " + blStatusVO.getColumnValues());
                //bl_cpy_knt,"bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
                if((blStatusVO.getBlCpyKnt() == null
                        || blStatusVO.getBlCpyKnt().equals(""))
                    &&(blStatusVO.getBlOtrDocRcvCd().equals("LG")
                        ||blStatusVO.getBlOtrDocRcvCd().equals("LI"))
                ){
                    //INSERT
                    dbDao.addOblRcvByUsCgo(blStatusVO,account);
                }else{
                    //MODIFY
                    dbDao.modifyOblRcvByUsCgo(blStatusVO, account);
                }
                break;
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }  
    
    
    /**
     * searchBlListForGroupUpdate
     * 
     * @param GrpBlDtInVO grpBlDtInVO
     * @return GrpBlDtVO
     * @throws EventException
     */
    public GrpBlDtVO searchBlListForGroupUpdate(GrpBlDtInVO grpBlDtInVO) throws EventException {
        GrpBlDtVO grpBlDtVO = new GrpBlDtVO();
        GrpBlDtInVO grpBlDtOutVO = new GrpBlDtInVO();
        try {
            
            BookingUtil utilCmd = new BookingUtil();
            
            if(null!=grpBlDtInVO.getVvd() && !"".equals(grpBlDtInVO.getVvd())){
                String vvd = grpBlDtInVO.getVvd();
                String vslCd = vvd.substring(0, 4);
                String voyNo = vvd.substring(4, 8);
                String dirCd = vvd.substring(8, 9);
                String portCd = grpBlDtInVO.getPolCd();
                String clptIndSeq = grpBlDtInVO.getPolClptIndSeq();

                VskVslPortSkdVO vskVslPortSkdVO = utilCmd.searchEtbEtdEta(vslCd, voyNo, dirCd, portCd, clptIndSeq);
                
                if(vskVslPortSkdVO != null && vskVslPortSkdVO.getVslCd() != null) {
                    // grpBlDtOutVO.setVvd(vskVslPortSkdVO.getVslCd()+vskVslPortSkdVO.getSkdVoyNo()+vskVslPortSkdVO.getSkdDirCd());
                    // grpBlDtOutVO.setPolCd(vskVslPortSkdVO.getVpsPortCd());
                    grpBlDtOutVO.setVvd(vvd);
                    grpBlDtOutVO.setPolCd(portCd);
                    grpBlDtOutVO.setActArrDt(vskVslPortSkdVO.getVpsEtaDt());
                    grpBlDtOutVO.setActDepDt(vskVslPortSkdVO.getVpsEtdDt());
                }
               
            }else{
            	
                grpBlDtOutVO.setActArrDt("");
                grpBlDtOutVO.setActDepDt("");
            	
            }

            List<GrpBlDtListVO> grpBlDtListVOs = dbDao.searchBlListForGroupUpdate(grpBlDtInVO);

            // GrpBlDtInVO 정보
//            


            // GrpBlDtVO 정보

            grpBlDtVO.setGrpBlDtListVOs(grpBlDtListVOs);
            grpBlDtVO.setGrpBlDtInVO(grpBlDtOutVO);
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return grpBlDtVO;
    }
    
    /**
     * modifyGroupBlUpdate
     * 
     * @param GrpBlDtListVO grpBlDtListVO
     * @param GrpBlDtInVO grpBlDtInVO
     * @throws EventException
     */
    public void modifyGroupBlUpdate(GrpBlDtListVO grpBlDtListVO, GrpBlDtInVO grpBlDtInVO) throws EventException {
        try {
            dbDao.modifyBlIssueDt(grpBlDtListVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }
    
    /**
     * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.<br>
     * 
     * @param ObDblWblInVO obDblWblInVO
     * @return DblWblOutVO
     * @exception EventException
     */
    public DblWblOutVO searchBkgListForObDblWbl(ObDblWblInVO obDblWblInVO) throws EventException {
        DblWblOutVO dblWblOutVO = null;
        List<DblWblVO> dblWblVOs = null;
        List<DblWblCntVO> dblWblCntVOs = null;
        try {
            dblWblVOs = dbDao.searchBkgListForObDrblWbl(obDblWblInVO);
            if (null!=dblWblVOs && 0<dblWblVOs.size()) {
                dblWblCntVOs = dbDao.searchBkgListForObDrblWblCnt(obDblWblInVO);
                if (null!=dblWblCntVOs && 0<dblWblCntVOs.size()) {
                    dblWblOutVO = new DblWblOutVO();
                    dblWblOutVO.setDblWbls(dblWblVOs);
                    dblWblOutVO.setDblWblCnts(dblWblCntVOs);
                }
            }
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return dblWblOutVO;
    }
    
    /**
     * Draft BL 및 Waybill 전송을 위한 Inbound booking list를 조회한다.<br>
     * 
     * @param InDblWblInVO inDblWblInVO
     * @return DblWblOutVO
     * @exception EventException
     */
    public DblWblOutVO searchBkgListForIbDblWbl(InDblWblInVO inDblWblInVO) throws EventException {
        DblWblOutVO dblWblOutVO = null;
        List<DblWblVO> dblWblVOs = null;
        List<DblWblCntVO> dblWblCntVOs = null;
        try {
            dblWblVOs = dbDao.searchBkgListForIbDrblWbl(inDblWblInVO);
            if (null!=dblWblVOs && 0<dblWblVOs.size()) {
                dblWblCntVOs = dbDao.searchBkgListForIbDrblWblCnt(inDblWblInVO);
                if (null!=dblWblCntVOs && 0<dblWblCntVOs.size()) {
                    dblWblOutVO = new DblWblOutVO();
                    dblWblOutVO.setDblWbls(dblWblVOs);
                    dblWblOutVO.setDblWblCnts(dblWblCntVOs);
                }
            }
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return dblWblOutVO;
    }
    
    /**
	 * BKG에 해당하는 Draft B/L 전송시 Chinese Booking Agent Code에 있는 Email 주소 조회한다.<br>
     * 
     * @param List<String> bkgNos
     * @return List<AgentEmlVO>
     * @exception EventException
     */
    public List<AgentEmlVO> searchBkgAgentEml(List<String> bkgNos) throws EventException {
        List<AgentEmlVO> agentEmlVOs = null;
        try {
        	agentEmlVOs = dbDao.searchBkgAgentEml(bkgNos);
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return agentEmlVOs;
    }
    
    /**
     * Booking 별 Fax, Mail의 전송결과를 조회한다.<br>
     * 
     * @param MultiNtcHisVO multiNtcHisVO
     * @return List<MultiNtcHisVO>
     * @exception EventException
     */
    public List<MultiNtcHisVO> searchMultiNtcHis(MultiNtcHisVO multiNtcHisVO) throws EventException {
        List<MultiNtcHisVO> multiNtcHisVOs = null;
        try {
        	multiNtcHisVOs = dbDao.searchMultiNtcHis(multiNtcHisVO);
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return multiNtcHisVOs;
    }
    
    /**
     * 조회 이벤트 처리
     *  Rider 여부판단 ESM_BKG_0927
     *
     * @param String bkg_no
     * @param String hiddenData
     * @param String rate
     * @param String cntr
     * @param String corr_no
     * @return String
     * @exception EventException
     */
    public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws EventException {
        try {
            return dbDao.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 조회 이벤트 처리
     *  HouseB/L 여부판단 ESM_BKG_0927
     *
     * @param bkg_no
     * @return String[]
     * @exception EventException
     */
    public String[] searchHouseBlYn(String bkg_no) throws EventException {
        try {
            return dbDao.searchHouseBlYn(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 조회 이벤트 처리<br>
     *  HouseB/L 여부판단 ESM_BKG_0743<br>
     *
     * @param String bkg_no
     * @param String corr_no
     * @return String
     * @exception EventException
     */
    public String searchOblRlseFlg(String bkg_no, String corr_no) throws EventException {
        try {
            return dbDao.searchOblRlseFlg(bkg_no, corr_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 조회 이벤트 처리<br>
     * OBL_ISS_FLG ESM_BKG_0743<br>
     *
     * @param String bkg_no
     * @return String
     * @exception EventException
     */
    public String searchOblIssFlg(String bkg_no) throws EventException {
        try {
            return dbDao.searchOblIssFlg(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * EsmBkg0927Event Email 이벤트 처리
     * Email 전송
     *
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblWblByEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        ArrayList<String> arrTmplMrd = null;
        ArrayList<String> arrTmplParam = null;
        ArrayList<String> arrTmplMrdPdf = null;
        List<ComRptDsgnXptInfoVO> xptVOs = null;
        ComRptDsgnXptInfoVO xptVO = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        StringBuilder sbBlNos = null;
        String strBlNoTitle = null;
        String strBlNoBody = null;
        String title = null;
        String bodySbTitle = null;
        String contentsParam = null;
        int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		String blNtcKndCd = "";

        try {
            util = new BookingUtil();
			// 수정  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";
            String senderCcMailAddr ="";
            int idx = 0;
            for (DblWblVO vo : dblWblVOs) {
            	if(vo != null){
            		String bkgNo = "";
            		if(null != vo.getBkgNo()){
            			bkgNo = vo.getBkgNo();
            		}
	                // 여러개의 *.mrd파일을 Email송신을 할 경우
	                // vo.getTmplmrd()의 값으로 구분자('|$$|')를  기준으로 
	                // 루프를 돌면서 Email에 파일로 첨부시킨다.
	                // tmplmrd / tmplparam 이 2개의 값만 여러개가 올 수 있고 나머지Parameter는 동일하다.
	                arrTmplMrd    = new ArrayList<String>();
	                arrTmplParam  = new ArrayList<String>();
	                arrTmplMrdPdf = new ArrayList<String>();
	                if(null != vo.getTmplmrd()){
	                	for (String s : vo.getTmplmrd   ().split("\\|\\$\\$\\|")) { arrTmplMrd   .add(s); }
	                }
	                if(null != vo.getTmplparam()){
	                	for (String s : vo.getTmplparam ().split("\\|\\$\\$\\|")) { arrTmplParam .add(s); }
	                }
	                if(null != vo.getTmplmrdpdf()){
	                	for (String s : vo.getTmplmrdpdf().split("\\|\\$\\$\\|")) { arrTmplMrdPdf.add(s); }
	                }
	                xptVOs = new ArrayList<ComRptDsgnXptInfoVO>(arrTmplParam.size());
	                for (int j=0; j < arrTmplParam.size(); j++) {
	                	xptVO = new ComRptDsgnXptInfoVO(); 
	                	xptVO.setRdTmpltNm(arrTmplMrd.get(j));           // *.mrd 명칭
	                	xptVO.setRdParaCtnt(arrTmplParam.get(j));  // *.mrd 파라메터
	                	xptVO.setXptFileNm(arrTmplMrdPdf.get(j));   // *.mrd 첨부 시 변환될 파일명칭
	                	xptVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
	                    xptVOs.add(xptVO);
	                }
	                // Email 전송
	                mailInfo = new MailSendVO();
					mailInfo.setSysCd("BKG");
					mailInfo.setTmplMrd(vo.getTmplmrd());
					mailInfo.setBatchFlg("N");
					mailInfo.setTmplParam(vo.getTmplparam());
					
					//WayBill 처리 로직 추가 2011.10.04
					//DblWblVO vo
					if( vo != null && null != vo.getNtcKndCd() && !"".equals(vo.getNtcKndCd()) && "WB".equals(vo.getNtcKndCd())){
						//SWB Release버튼 클릭 시 rate/unrate모두 전송시에 파라미터 추가 
						if(null != vo.getTmplparam2() && !"".equals(vo.getTmplparam2())){
							mailInfo.setTmplParam2(vo.getTmplparam2());
						}
						blNtcKndCd = vo.getNtcKndCd();
					}else{
						blNtcKndCd = "BL";	
					}
					
					if(vo != null && null != vo.getFntEmlFlg() && !"".equals(vo.getFntEmlFlg())){ 
						senderMailAddr = dbDao.searchFrontEmail(bkgNo);//group mail check
						if(senderMailAddr.equals("")){
							senderMailAddr = dbDao.searchCreUsrEml(bkgNo);
						}
					} else{
						senderMailAddr = util.searchGroupEmailAddrRSQL(bkgNo, account.getUsr_id(),"EM", blNtcKndCd);//group mail check
						senderCcMailAddr = util.searchGroupCcEmailAddrRSQL(bkgNo, account.getUsr_id(),"EM", blNtcKndCd); // group cc mail check
					}

	
					
					if(senderMailAddr.equals("")){
						mailInfo.setSndNm(account.getUsr_nm());
					}else{
						mailInfo.setSndNm("");
					}
					//TO 에 FROM EMAIL 제거 
					if(null != vo.getRcveml()){
						mailInfo.setRcvEml(vo.getRcveml());
					}
	 				if (senderMailAddr.equals("")){
							mailInfo.setSndEml(sUsrEml);
					}else {
						mailInfo.setSndEml(senderMailAddr);
					}
					//from mail 값 셋
	 				if(bkgEmlEdtVO != null && null != bkgEmlEdtVO.getEdtFromEml() && !"".equals(bkgEmlEdtVO.getEdtFromEml())){
						mailInfo.setSndEml(bkgEmlEdtVO.getEdtFromEml());
					}
					mailInfo.setCrtUserId(account.getUsr_id());
					
					if(bkgEmlEdtVO != null && null != bkgEmlEdtVO.getFileKey()){
						mailInfo.setFileKey(bkgEmlEdtVO.getFileKey());//0095
					} else{
						mailInfo.setFileKey("");//기존로직
					}
					String grpFlag = "";
            		if(null != vo.getGrpFlag()){
            			grpFlag = vo.getGrpFlag();
            		}
	                //그룹메일인 경우에는 한번만 전송한다
					if (!"Y".equalsIgnoreCase(grpFlag) || ("Y".equalsIgnoreCase(grpFlag) && 0==idx++)) {
	                	if ("Y".equalsIgnoreCase(grpFlag)) {  //그룹메일인 경우
	                		sbBlNos = new StringBuilder();
	                		cnt = -1;
	    					for (DblWblVO tmp : dblWblVOs) {
	    						sbBlNos.append(tmp.getBlNo()).append(", ");
	    						cnt++;
	    					}
	    					sbBlNos.delete(sbBlNos.lastIndexOf(","), sbBlNos.length());
							strBlNoTitle = vo.getBlNo()+" and "+cnt+" B/Ls";
							strBlNoBody = sbBlNos.toString();
							mailInfo.setTmplMrdPdf("SMLM"+vo.getBlNo()+".pdf");
	                	} else {
							strBlNoTitle = strBlNoBody = vo.getBlNo();
							mailInfo.setTmplMrdPdf("SMLM"+strBlNoTitle+".pdf");
	                	}
	                	//메일양식
	                	String vslNm = this.searchVesselNameByBkgNo(bkgNo);
	                	String strEmlCtnt = this.searchEmlCtnt(bkgNo);
	                	if (!StringUtils.isEmpty(vo.getTitle())) {
	                		title = vo.getTitle();
	                	} else {
	                		StringBuilder titleSb = new StringBuilder("SM Line ");
	                		StringBuilder bodySb = new StringBuilder("");
	                		if ("WB".equalsIgnoreCase(vo.getNtcKndCd())) {
	                			titleSb.append("Sea Waybills");
	                			bodySb.append("Sea Waybills");
	                		} else if ("NN".equalsIgnoreCase(vo.getNtcKndCd())) {
	                   			titleSb.append("B/L Copy");
	                   			bodySb.append("B/L Copy");
	                		} else {
	                			titleSb.append("Draft B/L(s)");
	                			bodySb.append("Draft B/L(s)");
	                		}
	                		titleSb.append(" (T/VVD : ").append(vslNm).append(" / B/L No : ").append(strBlNoTitle).append(")");
	                		bodySb.append(" (T/VVD : ").append(vslNm).append(" / B/L No : ").append(strBlNoTitle).append(")");
	                		
	                		bodySbTitle = bodySb.toString();
	                		title = titleSb.toString();
	                	}
						if("".equals(strEmlCtnt)){
							contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : "+strBlNoTitle+"@@blNoBody;"+strBlNoBody;
						}else{
							contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : "+strBlNoTitle+"@@blNoBody;"+strBlNoBody +"@@emlCtnt;"+ strEmlCtnt.replace("\n","<br>");
							
						}
	                	
						mailInfo.setTitle(title); // 제목
	    				mailInfo.setContents(contentsParam); // 내용
	    				String lang = "";
	    				lang = util.searchBkgCustCntCd("S", bkgNo);
	    				mailInfo.setTextContents(lang);
						mailInfo.setCcEml(util.searchCcEmailAddrRSQL(vo.getNtcKndCd(), account.getUsr_id())+";"+senderMailAddr);
	    				if (arrTmplParam != null && arrTmplParam.size() > 1) {
		                    retEmailSndId = bleaiDao.sendReportDesignerWithFiles(mailInfo, bkgEmlEdtVO, xptVOs);
		                } else {
		                    // Send Mail - *.mrd 파일 단건 보낼 시 1:1매칭
		                    // 즉, *.mrd파일이 여러건일 경우 동일한 메일계정으로 *.mrd파일 수 만큼 송신이됨
		                    retEmailSndId = bleaiDao.sendEmail(mailInfo, bkgEmlEdtVO, vo.getNtcKndCd(), util.searchCcEmailAddrRSQL(vo.getNtcKndCd(), account.getUsr_id())+";"+senderCcMailAddr);
		                }

					}
	                // Notice History Setting(History에는 bkg_no별로 남겨야 함)
	                strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");  // 한  BL에 여러 BKG_NO가 올 경우 "|"로 구분하여 문자열로 넘어 온다고 가정하여 처리
	                while (strNBkgNo.hasMoreTokens()) {
	                    bkgNtcHisVO = new BkgNtcHisVO();
	                    bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
	                    bkgNtcHisVO.setNtcViaCd("M");
	                    bkgNtcHisVO.setNtcKndCd((vo.getNtcKndCd()==null||"".equals(vo.getNtcKndCd()))?"BL":vo.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
	                    bkgNtcHisVO.setAgnCd("");
	                    bkgNtcHisVO.setNtcFomCd("");
	                    bkgNtcHisVO.setNtcSeq("");
	                    bkgNtcHisVO.setBkgCustTpCd("");
	                    bkgNtcHisVO.setCustCntcTpCd("");
	                    bkgNtcHisVO.setNtcEml(vo.getRcveml());
	                    bkgNtcHisVO.setSndId(retEmailSndId);
	                    bkgNtcHisVO.setFrtHdnFlg(vo.getHiddOpt());
	                    bkgNtcHisVO.setFrtAllFlg(vo.getFrtAllFlg());
	                    bkgNtcHisVO.setFrtCltFlg(vo.getFrtCltFlg());
	                    bkgNtcHisVO.setFrtPpdFlg(vo.getFrtPpdFlg());
	                    bkgNtcHisVO.setFrtChgFlg(vo.getFrtChgFlg());
	                    bkgNtcHisVO.setFrtArrFlg(vo.getFrtArrFlg());
	                    bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
	                    bkgNtcHisVO.setSndUsrId(account.getUsr_id());
	                    bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
	                    bkgNtcHisVO.setDiffRmk(""); //양동
	                    bkgNtcHisVO.setCreUsrId(account.getUsr_id());
	                    bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
	                    bkgNtcHisVOs.add(bkgNtcHisVO);
	                }
	            }
        	}
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }

    
    /**
     * EsmBkg0927Event Fax 이벤트 처리
     * Fax 전송
     *
     * @param DblWblVO[] dblWblVOs
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblWblByFax(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        ArrayList<String> arrTmplMrd = null;
        ArrayList<String> arrTmplParam = null;
        SimpleDateFormat format = null;
        String rcvInfo = null;
        FaxSendVO faxInfo = null;
        String retFaxSndId = null;
        StringTokenizer strNBkgNo = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        BookingUtil util = new BookingUtil();
        String groupOfcCd="";
        String bkg_no="";
        String blNtcKndCd = "";
        try {
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            for (DblWblVO vo : dblWblVOs) {
            	if(vo != null){
            		String bkgNo = "";
            		if(null != vo.getBkgNo()){
            			bkgNo = vo.getBkgNo();
            		}
            				
	                arrTmplMrd = new ArrayList<String>();
	                arrTmplParam = new ArrayList<String>();
	                // 여러개의 *.mrd파일을 Fax송신을 할 경우
	                // bkgListForDblWblVO.getTmplmrd()의 값으로 구분자('|$$|')를  기준으로 
	                // 루프를 돌면서 Fax를 전송한다.
	                // tmplmrd / tmplparam 이 2개의 값만 여러개가 올 수 있고 나머지Parameter는 동일하다.
	                if(null != vo.getTmplmrd()){
	                	for (String s : vo.getTmplmrd  ().split("\\|\\$\\$\\|")) { arrTmplMrd  .add(s); }
	                }
	                if(null != vo.getTmplparam()){
	                	for (String s : vo.getTmplparam().split("\\|\\$\\$\\|")) { arrTmplParam.add(s); }
	                }
	                for (int j=0; j < arrTmplParam.size(); j++) {
	                    rcvInfo = "" + ";" + vo.getRcvinfo();
	                    // Fax 정보 설정
	                    faxInfo = new FaxSendVO();
	                    faxInfo.setSysCd(vo.getSyscd());
	                    faxInfo.setTmplMrd(arrTmplMrd.get(j));
	                    faxInfo.setBatchFlg(vo.getBatchflg());
	            		if (!StringUtils.isEmpty(vo.getTitle())) {
	            			faxInfo.setTitle(vo.getTitle());
	            		} else {
	                        StringBuilder titleSb = new StringBuilder("SM Line ");
	            			if ("BL".equalsIgnoreCase(vo.getNtcKndCd())) {
	            				titleSb.append("Draft B/L(s)");
	            			} else if ("WB".equalsIgnoreCase(vo.getNtcKndCd())) {
	                			titleSb.append("Sea Waybills");
	                		} else if ("NN".equalsIgnoreCase(vo.getNtcKndCd())) {
	                   			titleSb.append("B/L Copy");
	                		}
	            			faxInfo.setTitle(titleSb.toString());
	            		}
	                    faxInfo.setTmplParam(arrTmplParam.get(j)); // R.D 에 넘겨질 Parameter
	                    faxInfo.setRcvInfo(rcvInfo);// fax_no 를 , 로 연결한 문자열
	                    
	    				//WayBill 처리 로직 추가 2011.10.04
	    				//DblWblVO vo
	                    if( vo != null && null != vo.getNtcKndCd() && !"".equals(vo.getNtcKndCd()) && "WB".equals(vo.getNtcKndCd())){
	    					blNtcKndCd = vo.getNtcKndCd();
	    				}else{
	    					blNtcKndCd = "BL";	
	    				}
	                    
	                    groupOfcCd = util.searchGroupEmailAddrRSQL(bkgNo, account.getUsr_id(),"OFC", blNtcKndCd);//group ofc cd check
	                    groupOfcCd = groupOfcCd.equals("") ? account.getOfc_cd():groupOfcCd;
	     				
	                    faxInfo.setOffice(groupOfcCd);
	                    faxInfo.setCrtUserId(account.getUsr_id());
	                    // Fax 전송
	                    retFaxSndId = bleaiDao.sendFax(faxInfo);
	                    // 한  BL에 여러 BKG_NO가 올 경우 "|"로 구분하여 문자열로 넘어 온다고 가정하여 처리
	                    // History에는 bkg_no별로 남겨야 함.
	                    strNBkgNo = new StringTokenizer(bkgNo, "|");
	                    while (strNBkgNo.hasMoreTokens()) {
	                    	bkg_no = strNBkgNo.nextToken();
	                    	
	                        bkgNtcHisVO = new BkgNtcHisVO();
	                        bkgNtcHisVO.setBkgNo(bkg_no);
	                        bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
	                        bkgNtcHisVO.setNtcKndCd(blNtcKndCd); // BL : Draft B/L -- 우선 BL을 사용 추후에 수정요망
	                        bkgNtcHisVO.setAgnCd("");
	                        bkgNtcHisVO.setNtcFomCd("");
	                        bkgNtcHisVO.setNtcSeq("");
	                        bkgNtcHisVO.setCustCntcTpCd("");
	                        bkgNtcHisVO.setNtcFaxNo(vo.getRcvinfo());
	                        bkgNtcHisVO.setSndId(retFaxSndId);
	
	                        groupOfcCd = util.searchGroupEmailAddrRSQL(bkg_no, account.getUsr_id(),"OFC", blNtcKndCd);//group ofc cd check
	                        groupOfcCd = groupOfcCd.equals("") ? account.getOfc_cd():groupOfcCd;
	         				
	                        
	                        bkgNtcHisVO.setSndOfcCd(groupOfcCd);
	                        
	                        bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
	                        bkgNtcHisVO.setSndUsrId(account.getUsr_id());
	                        bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
	                        bkgNtcHisVO.setDiffRmk("");
	                        bkgNtcHisVO.setCreUsrId(account.getUsr_id());
	                        bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
	                        if(null != vo.getHiddOpt()){
	                        	bkgNtcHisVO.setFrtHdnFlg(vo.getHiddOpt());
	                        }
	                        if(null != vo.getFrtAllFlg()){
	                        	bkgNtcHisVO.setFrtAllFlg(vo.getFrtAllFlg());
	                        }
	                        if(null != vo.getFrtCltFlg()){
	                        	bkgNtcHisVO.setFrtCltFlg(vo.getFrtCltFlg());
	                        }
	                        if(null != vo.getFrtPpdFlg()){
	                        	bkgNtcHisVO.setFrtPpdFlg(vo.getFrtPpdFlg());
	                        }
	                        if(null != vo.getFrtChgFlg()){
	                        	bkgNtcHisVO.setFrtChgFlg(vo.getFrtChgFlg());
	                        }
	                        if(null != vo.getFrtArrFlg()){
	                        	bkgNtcHisVO.setFrtArrFlg(vo.getFrtArrFlg());
	                        }
	                    	bkgNtcHisVOs.add(bkgNtcHisVO);
	                    }
	                }
	            }
	        }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }

    /**
     * B/L 발행 송부 - Draft B/L 자동 발송
     * 
     * @author Jeon Sung-Jin
     * @param String bkgNo
     * @param String blChgFlg
     * @param SignOnUserAccount account
     * @return List<DblEdiVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> createDraftBlEdiAuto(String bkgNo, String blChgFlg, SignOnUserAccount account) throws EventException { 
    	DblEdiVO dblEdiVO = null;
    	DblEdiInVO dblEdiInVO = null;
    	BookingUtil utilCmd = new BookingUtil();
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;  
		GeneralBookingReceiptBC rcpCmd = new GeneralBookingReceiptBCImpl();
    	
    	BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
        bkgBlNoIn.setBkgNo(bkgNo);
		bkgBlNoIn.setCaUsrId(account.getUsr_id());		
    	
		try {

	    	BkgBlNoVO bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIn);
	    	
	        if(bkgBlNoOut == null) {
	            throw new EventException(new ErrorHandler("BKG01049", bkgNo).getMessage());
	        }
	        
	        /* 홍우리님 요청 사항 
	        if(account.getUsr_id() == "SYSTEM"){
	        	log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        }
			*/

	        List<CustTpIdVO> custTpIdVos = utilCmd.searchEdiCustTpId(bkgBlNoOut, "D", "Y");

	        
	        /*blChgFlg : A - 1차 310 자동전송 (batch auto)
	         *         : Y - 1차 310자동전송 이후 SWB,OBL release혹은 cancel시 310자동전송
	         *         : N - SWB,OBL release이후에는 데이터 변경있으면 310자동전송
	         */
	        if(custTpIdVos.size()==0 && !"A".equals(blChgFlg)){
	        	List<CustTpIdVO> custTpIdAftRlseVos = dbDao.searchEdiCustTpIdAftRlse(bkgBlNoOut, blChgFlg);
	        	if(custTpIdAftRlseVos.size()>0)
	        		custTpIdVos.addAll(custTpIdAftRlseVos);
	        }
	        
	        
	        bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();

			
	        for(int i=0 ; i < custTpIdVos.size() ; i++) { 
	        	dblEdiInVO = new DblEdiInVO();
	        	dblEdiInVO.setBkgNo(bkgNo);
	        	dblEdiInVO.setEdiReceiveId(custTpIdVos.get(i).getRcvId());
	        	dblEdiInVO.setGroupEdiId(custTpIdVos.get(i).getGroupId());
	        	dblEdiInVO.setGroupEdiCust(custTpIdVos.get(i).getRefCode());
	        	dblEdiInVO.setAutoManualFlg("Y");
	        	
	        	log.debug("\n #####################################################");
	            log.debug("\n EdiReceiveId: " + custTpIdVos.get(i).getRcvId());
	            log.debug("\n #####################################################");
	            
	        	// Receive ID 가 있을 경우만 전송
	        	if(custTpIdVos.get(i).getRcvId() != null || custTpIdVos.get(i).getRcvId() != "") {
		        	dblEdiVO = createDraftBlEdi(dblEdiInVO, account);		        	
		        	
		        	//전송이 성공했을 경우만 History 생성
		        	if(dblEdiVO != null){		    			
		        		String rcvId = custTpIdVos.get(i).getRcvId();
						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
						bkgNtcHisVO.setBkgNo(bkgNo);
						bkgNtcHisVO.setNtcViaCd("E");
						bkgNtcHisVO.setNtcKndCd("BL");
						bkgNtcHisVO.setEdiId(rcvId);
						bkgNtcHisVO.setEsvcGrpCd(custTpIdVos.get(i).getGroupId());
						bkgNtcHisVO.setFltFileRefNo(dblEdiVO.getFlatFileAckVOs().get(0).getFltFileRefNo());
						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVO.getFlatFileAckVOs().get(0).getAckStsCd());
						bkgNtcHisVO.setSndUsrId("SYSTEM");
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
						bkgNtcHisVOs.add(bkgNtcHisVO);
						if (Constants.SAMF_LIST.contains(rcvId)) {
							BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
							bkgReferenceVO.setBkgNo(bkgNo);
							bkgReferenceVO.setBkgRefTpCd("SAMF");						
							bkgReferenceVO.setCustRefNoCtnt(dblEdiVO.getDblEdiSamf());
							
							BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[1];
							bkgReferenceVOs[0] = bkgReferenceVO;

							rcpCmd.manageRefNo(bkgReferenceVOs, account, bkgBlNoOut);
						}
						

		        	}
	        	}        
	        }
		} catch (EventException ex) {
			throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
    	return bkgNtcHisVOs;
    }
    /**
     * B/L 발행 송부 - Draft B/L 발송
     * 
     * @author Park Jun-Yong
     * @param DblEdiInVO dblEdiInVO
     * @param SignOnUserAccount account
     * @return DblEdiVO
     * @exception EventException
     */
    public DblEdiVO createDraftBlEdi(DblEdiInVO dblEdiInVO, SignOnUserAccount account) throws EventException {

        BookingUtil utilCmd = new BookingUtil();

        DblEdiVO dblEdiOutVO = new DblEdiVO();
        
        try {

            BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
            String bkgNo = dblEdiInVO.getBkgNo();
            bkgBlNoIn.setBkgNo(dblEdiInVO.getBkgNo());
            bkgBlNoIn.setBlNo(dblEdiInVO.getBlNo());
    		bkgBlNoIn.setCaUsrId(account.getUsr_id());

            log.debug("#####################################################");
            log.debug("validation Start");
            log.debug("#####################################################");

            String ec_edircv_id_old = null;
            // EDI RECEIVER ID
//            String[] ec_edircv_id_arr = null; 
            String ec_edircv_id_5 = "";
            String ec_edircv_id_6 = "";
            String ec_edircv_id_8 = "";
            
            String strFuncCode = null; 
            
            ec_edircv_id_old = (dblEdiInVO.getEdiReceiveId() == null) ? "" : dblEdiInVO.getEdiReceiveId();
            
            log.debug("#####################################################");
            log.debug("ec_edircv_id_old : " + ec_edircv_id_old);
            log.debug("#####################################################");
            
            BkgBlNoVO bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIn);
            if(bkgBlNoOut == null) {
                throw new EventException(new ErrorHandler("BKG01049", bkgNo).getMessage());
            }
            
            // No Rate 인 경우 D B/L을 전송하지 않는다.
            if("Y".equals(utilCmd.searchNoRateBlockFlg(bkgBlNoOut))){
	        	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	        		throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgNo}).getMessage());
				} else {
					return null;
				}	
            }
            // Standby 인 경우 D B/L을 전송하지 않는다.
            if("Y".equals(utilCmd.searchStandbyBlockFlg(bkgBlNoOut))){
	        	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	        		throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgNo}).getMessage());
				} else {
					return null;
				}	
            }
	            
            if(!"KTNETPCS".equals(ec_edircv_id_old))
        	{        	
	            // Cancel된 booking은 310을 전송하지 않는다.
	            if("X".equals(bkgBlNoOut.getBkgStsCd())) {
	            	//Auto로 전송할 경우 사용자 에러 무시
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	                    throw new EventException(new ErrorHandler("BKG06097").getMessage());
	            	} else {
	            		return null;
	            	}
	            }
	            // B/L No 존재여부 체크
	            if(bkgBlNoOut.getBlNo() == null || bkgBlNoOut.getBlNo().equals("")) {
	            	//Auto로 전송할 경우 사용자 에러 무시
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	                    throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
	            	} else {
	            		return null;
	            	}	                
	            }
	            // Consignee의 Name 누락여부
	            String strCneeChk = dbDao.searchDblEdiCneeNm(dblEdiInVO);
	            if(strCneeChk == null || strCneeChk.equals("")) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
		                throw new EventException(new ErrorHandler("BKG00701", new String[]{"Consignee Name"}).getMessage());
	            	} else {
	            		return null;
	            	}
	            }
	            // TTL Package and Description 누락여부
	            String strTTLChk = dbDao.searchDblEdiTtlPkgDesc(dblEdiInVO);
	            if(!"Y".equals(strTTLChk)) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
						throw new EventException(new ErrorHandler("BKG00701",new String[] { "Total Package and Description of Goods" }).getMessage());
					} else {
						return null;
					}
	            }
	            // CNTR No 존재 여부 
	            String strCntrNo = dbDao.searchDblEdiCntrNo(dblEdiInVO);
	            if(strCntrNo == null || strCntrNo.equals("")) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	            		throw new EventException(new ErrorHandler("BKG00701", new String[]{"Container No."}).getMessage());
					} else {
						return null;
					}
	            }
	
	            
	            // 'EDI RECEIVER ID'가 넘어 오지 않을 경우는 에러처리? or 패스?
	            dblEdiInVO.setBlNo(bkgBlNoOut.getBlNo());
	            dblEdiInVO.setEdiReceiveIdOld(ec_edircv_id_old);
	            log.debug("########## validation EDI_REVEIVE_ID : " + ec_edircv_id_old);
	
	            // EDI RECEIVER ID 존재 여부 
	            if(ec_edircv_id_old == null || ec_edircv_id_old.equals("")) {
	            	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
	            		throw new EventException(new ErrorHandler("BKG00701", new String[]{"EDI Receiver ID"}).getMessage());
					} else {
						return null;
					}	                
	            }
        	}
            
            if(ec_edircv_id_old.length() == 5){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
            }else if(ec_edircv_id_old.length() == 6){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
                ec_edircv_id_6 = ec_edircv_id_old.substring(0, 6);
            }else if(ec_edircv_id_old.length() == 7){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
                ec_edircv_id_6 = ec_edircv_id_old.substring(0, 6);
            }else if(ec_edircv_id_old.length() >= 8){
                ec_edircv_id_5 = ec_edircv_id_old.substring(0, 5);
                ec_edircv_id_6 = ec_edircv_id_old.substring(0, 6);
                ec_edircv_id_8 = ec_edircv_id_old.substring(0, 8);                    
            }
            
            if("LEHXML".equals(ec_edircv_id_6)) {
                /* 
                 * LEHXML(Lehnkering) 경우 B/L 발행시 BL Release 후에만 BL 전송이 가능.
                 * B/L Release 이후 : BKG_BL_ISS.OBL_ISS_KNT > 0 -> 발행
                 * BL Type Check - W : Waybill, Null : B/L
                 */
                //String strBlTp = dbDao.searchDblEdiBlTp(dblEdiInVO);
                String strIssCnt = dbDao.searchDblEdiIssCnt(dblEdiInVO);
                int issCnt = (strIssCnt==null || strIssCnt.equals("")) ? 0 : Integer.parseInt(strIssCnt);
                if(!"W".equals(bkgBlNoOut.getBlTpCd())) {
                    if(issCnt < 1) {
                    	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
                    		throw new EventException(new ErrorHandler("BKG00701", new String[]{"B/L Release"}).getMessage());
                    	} else {
                    		return null;	
                    	}
                    }
                }
            } 
            
			if (Constants.SAMF_LIST.contains(ec_edircv_id_6) || Constants.SAMF_LIST.contains(ec_edircv_id_5)) {
                String strPkgWord = JSPUtil.getNull(dbDao.searchDblEdiPkgWord(dblEdiInVO));
                if(strPkgWord == null || strPkgWord.equals("")) {
                	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
                		throw new EventException(new ErrorHandler("BKG00701", new String[]{"Package Word"}).getMessage());
                	} else {
                		return null;	
                	}
                }
            } 
            
            if("LGELA010".equals(ec_edircv_id_8) || 
               "PKEXM010".equals(ec_edircv_id_8) || 
               "PKHKCNA01".equals(ec_edircv_id_8) || 
               "PKCNCNA01".equals(ec_edircv_id_8)) {
                /*
                 * LG(LGELA010), 범한(PKEXM010)의 경우, bkg_ref_no  Check : SI_REF_NO 없으면  -> 전송 불가
                 */
                String strRefNo = dbDao.searchDblEdiRefNo(dblEdiInVO);
                if(strRefNo == null || strRefNo.equals("")) {
                	if (!"Y".equals(dblEdiInVO.getAutoManualFlg())) {
                		throw new EventException(new ErrorHandler("BKG00701", new String[]{"SI Reference No."}).getMessage());
	            	} else {
	            		return null;	
	            	}
                }
            }
            
            log.debug("#####################################################");
            log.debug("validation End");
            log.debug("#####################################################");
            
//            log.debug("#####################################################");
//            log.debug(" Search EC_EDIRCV_ID 시작 ");
//            log.debug("#####################################################");
//            
//            if("KTNETPCS".equals(ec_edircv_id_8)) {
//                /*
//                 * 한국 Outbound건에 대해서 PLL(Pre Loading List) 전송.
//                 * KL-NET에 IFTMCS를 보내면서 PLL관련 Booking정보 수정없음 Confirm목적.
//                 * 문의 - Vendor EDI 담당자 added by thhong 2005.02.16
//                 * 아래 query 에서 BKG_NO_SPLIT 을 check 하지 않았으나, split booking 의 경우
//                 * 문제 발생하여 추가함. - 20060518 bho
//                */
//                ec_edircv_id_arr = dbDao.searchEdiRcvIdByKlnet(dblEdiInVO);
//            } else if("EIXML".equals(ec_edircv_id_5) || 
//                      "EIXMLC".equals(ec_edircv_id_6) || 
//                      "SEAEXPD".equals(ec_edircv_id_7)) {
//                /*
//                 * added by yong 2005.04.04 Expeditor요청에 따라 
//                 * Draft B/L을 EI와 관련된 Customer로 중복전송 하지 않고 
//                 * One BKG(B/L)당 최소의 단위인 Draft B/L 3가지(Draft B/L, B/L Image 2가지)만 전송되도록 수정 
//                 * 1차적으로 SHPR CODE, 2차로 SHPR CODE 대상 CODE아니면 CNEE, 3차로 NTFY, 4차로 F/Forward, 5차로 US393
//                 * 
//                 * edi_customer -> e_edi_group, e_edi_grp_msg, e_edi_grp_customer로 변경 프로그램 수정 
//                 * Y.C.KIM - 2007.10.26
//                 */
//                List<CustTpIdVO> custTpIdVos = utilCmd.searchEdiCustTpId(bkgBlNoOut, bkgBlNoOut.getBlTpCd(), "");
//                int rCnt = (custTpIdVos == null) ? 0 : custTpIdVos.size();
//                ec_edircv_id_arr = new String[rCnt];
//                for(int j = 0; j < rCnt; j++) {
//                    ec_edircv_id_arr[j] = custTpIdVos.get(j).getRcvId();
//                }
//            } else if("LEHXML".equals(ec_edircv_id_6)) {
//                /*
//                 * 2005.09.05 SA Jang Lehnkering의 경우 Forwarder만 BL 전송을 해야함.
//                 */
//                ec_edircv_id_arr = dbDao.searchEdiRcvIdByLehxml(dblEdiInVO);
//            } else {
//                /*
//                 * 그 외의  경우
//                 */
//                ec_edircv_id_arr = dbDao.searchEdiRcvId(dblEdiInVO);
//            }
//            log.debug("#####################################################");
//            log.debug(" Search EC_EDIRCV_ID 끝 ");
//            log.debug("#####################################################");
            
            String strSamf = dbDao.searchDblEdiSamf(dblEdiInVO);
            log.debug("\n******************** samf ********************\n" + strSamf);
            
//            int rcvCnt = (ec_edircv_id_arr == null) ? 0 : ec_edircv_id_arr.length;
//            log.debug("########## EC_EDIRCV_ID_ARR.LENGTH : " + rcvCnt);

            log.debug("#####################################################");
            log.debug(" Flat File 시작 ");
            log.debug("#####################################################");
            StringBuffer sbuff = null;
            List<FlatFileAckVO> flatFileAckVOs = new ArrayList<FlatFileAckVO>();
//            for(int l = 0; l < rcvCnt; l++) {
            	
            	sbuff = new StringBuffer();
//                log.debug("\n******************** edi_rcv_id ********************\n" + ec_edircv_id_arr[l]);
                dblEdiInVO.setEdiReceiveId(ec_edircv_id_old);

                // func_code : first trans (9)
                if("9".equals(dblEdiInVO.getFuncCode())) {
                	strFuncCode = "9";
                } else {
                	strFuncCode = dbDao.searchDblEdiFncCode(dblEdiInVO);
                }
                
                //edi_group_id
                if(dblEdiInVO.getGroupNm()==null || dblEdiInVO.getGroupEdiId()==null){
                    String[] edi_grp_cd = dbDao.searchDblEdiGrpId(dblEdiInVO);
                    dblEdiInVO.setGroupEdiCust(edi_grp_cd[0]);
                    dblEdiInVO.setGroupEdiId(edi_grp_cd[1]);
                    dblEdiInVO.setGroupNm(edi_grp_cd[2]);
                }
                String strEdiGroupCust = dblEdiInVO.getGroupEdiCust();	
                String strEdiGroupId = dblEdiInVO.getGroupEdiId();
                
                log.debug("\n******************** edi_group_cust ********************\n" + strEdiGroupCust);
                log.debug("\n******************** edi_group_id ********************\n" + strEdiGroupId);

                // B/L Type Code
                String strBlTp = dbDao.searchDblEdiBlTp(dblEdiInVO);
                log.debug("\n******************** bl_type ********************\n" + strBlTp);

                // Final ETA
                String strFnalEta = null;
//                if(("SECXML".equals(ec_edircv_id_arr[l]) ||
//                    "IPCXML".equals(ec_edircv_id_arr[l]) ||
//                    "HTLXML".equals(ec_edircv_id_arr[l]) ||
//                    "FSELC".equals(ec_edircv_id_arr[l]) ||
//                    "HTLXML_IMG".equals(ec_edircv_id_arr[l])) 
//                    ||
//                   ("C1T0W".equals(ec_edircv_id_old) ||
//                    "C1T0S".equals(ec_edircv_id_old) ||
//                    "C1T0M".equals(ec_edircv_id_old) ||
//                    "110AL".equals(ec_edircv_id_old))){
//                    //BLIssuanceDBDAO::searchFinalEta11 ( dblEdiInVO )
//                    strFnalEta = dbDao.searchFinalEta11(dblEdiInVO);
//                    if(strFnalEta == null ) strFnalEta = dbDao.searchFinalEta12(dblEdiInVO);
//                    if(strFnalEta == null ) strFnalEta = dbDao.searchFinalEta13(dblEdiInVO);
//                    if(strFnalEta == null ) strFnalEta = dbDao.searchFinalEta14(dblEdiInVO);
//                }else if("KIPC".equals(ec_edircv_id_arr[l])){
//                    strFnalEta = dbDao.searchFinalEta21(dblEdiInVO);
//                    if(strFnalEta == null ) strFnalEta = dbDao.searchFinalEta22(dblEdiInVO);
//                }else{
//                    strFnalEta = dbDao.searchFinalEta31(dblEdiInVO);
//                    if(strFnalEta == null ) strFnalEta = dbDao.searchFinalEta12(dblEdiInVO);
//                }
                
                strFnalEta = dbDao.searchFinalEta12(dblEdiInVO);
                
                log.debug("\n******************** final_eta ********************\n" + strFnalEta);

                // Sender Id
                String strSndrId = null;
                if("KTNETPCS".equals(ec_edircv_id_old)) {
                    strSndrId = dbDao.searchEdiSndrByKlnettcs(dblEdiInVO);
                } else {
                    dblEdiInVO.setTmpCnt("1");
                    strSndrId = dbDao.searchEdiSndr1(dblEdiInVO);
                    if(strSndrId == null) strSndrId = dbDao.searchEdiSndr2(dblEdiInVO);
                }
                if(strSndrId == null ) strSndrId = "NISBKG";
                log.debug("\n******************** sender_id ********************\n" + strSndrId);
                // TODO
                String strEdiHostId = utilCmd.searchEdi301HostId(ec_edircv_id_old, strBlTp);
                log.debug("\n******************** edi_host_id ********************\n" + strEdiHostId);
                // TODO
                String strEdiHeader = utilCmd.searchEdiHeader(strSndrId, ec_edircv_id_old, "310");
                log.debug("\n******************** edi_header ********************\n" + strEdiHeader);
                sbuff.append(strEdiHeader + "\n");
                
                String strXterInfo[] = dbDao.searchDblEdiIbNo(dblEdiInVO);
                String ediSender = strXterInfo[0];
                String strIbNo = strXterInfo[1];

                log.debug("\n******************** ib_no ********************\n" + strIbNo);

                dblEdiInVO.setEdiSender(ediSender);
                dblEdiInVO.setIbNo(strIbNo);
                String strMaxIbSeq = dbDao.searchDblEdiMaxIbSeq(dblEdiInVO);
                log.debug("\n******************** max_ib_seq ********************\n" + strMaxIbSeq);
                
                // Edi Main
                String strEdiMain1 = null;
                //홍우리님 요청 Live 미반영건 
                String strEdiMain2 = null;
                if("KTNETPCS".equals(ec_edircv_id_old)) {
                    DblEdiInfoVO ediInfoVO = dbDao.searchDblEdiInfo1(dblEdiInVO);
                    if("KRPUS".equals(ediInfoVO.getPreRlyPortCd()) || "KRPUS".equals(ediInfoVO.getPstRlyPortCd())) {
                        ediInfoVO = dbDao.searchDblEdiInfo2(ediInfoVO);
                    }
                    dblEdiInVO.setPreRlyPortCd(ediInfoVO.getPreRlyPortCd());
                    dblEdiInVO.setPstRlyPortCd(ediInfoVO.getPstRlyPortCd());
                    strEdiMain1 = dbDao.searchDblEdiMain11(dblEdiInVO);
                } else {
                    strEdiMain1 = dbDao.searchDblEdiMain12(dblEdiInVO);
                }
                log.debug("\n******************** edi_main 1 ********************\n" + strEdiMain1);
                sbuff.append(strEdiMain1);
                
                String strGmt = dbDao.searchDblEdiGmt(dblEdiInVO);
                log.debug("\n******************** gmt ********************\n" + strGmt);
                sbuff.append(strGmt);
                
                dblEdiInVO.setFinalEta(strFnalEta);
                dblEdiInVO.setFuncCode(strFuncCode);
                //홍우리님 요청 Live 미반영건
                if("TRADIANT".equals(ec_edircv_id_old) && (null != dblEdiInVO.getGroupNm() && "LF USA TSG Panyu".equals(dblEdiInVO.getGroupNm()))) {
                    BkgBlIssInfoVO bkgBlIssInfoVO = new BkgBlIssInfoVO();
                    bkgBlIssInfoVO = dbDao.searchBkgTerm(bkgNo);
                    if("S".equals(bkgBlIssInfoVO.getRcvTermCd()) && "Y".equals(bkgBlIssInfoVO.getDeTermCd())){
                    	strEdiMain2 = dbDao.searchDblEdiMain3(dblEdiInVO);	
                    }else{
                    	strEdiMain2 = dbDao.searchDblEdiMain2(dblEdiInVO);
                    }
                }else{
                	strEdiMain2 = dbDao.searchDblEdiMain2(dblEdiInVO);	 
                }
//                String strEdiMain2 = dbDao.searchDblEdiMain2(dblEdiInVO);
                log.debug("\n******************** edi_main 2 ********************\n" + strEdiMain2);
                sbuff.append(strEdiMain2);
                
                String strMsIbcs = dbDao.searchDblEdiMsIbcs(dblEdiInVO);
                log.debug("\n******************** ms_ibcs ********************\n" + strMsIbcs);
                sbuff.append(strMsIbcs);
                
                dblEdiInVO.setIbSeq(strMaxIbSeq);
                String strCustIbcs = dbDao.searchDblEdiCustIbcs(dblEdiInVO);
                log.debug("\n******************** cust_ibcs ********************\n" + strCustIbcs);
                sbuff.append(strCustIbcs);
                
                String strIbShRef= dbDao.searchDblEdiIbShRef(dblEdiInVO);
                log.debug("\n******************** ib_sh_ref ********************\n" + strIbShRef);
                sbuff.append(strIbShRef);
                
                String strSendCnt = dbDao.searchDblEdiSendCnt(dblEdiInVO);
                log.debug("\n******************** send_cnt ********************\n" + strSendCnt);
                sbuff.append(strSendCnt);
                
                //ec_edircv_id=FSELC,PKEXM010] IF
                if("FSELC".equals(ec_edircv_id_old) || "PKEXM010".equals(ec_edircv_id_old)){
                    String strMrnNo = dbDao.searchDblEdiMrnNo(dblEdiInVO);
                    log.debug("\n******************** mrn_no ********************\n" + strMrnNo);
                    sbuff.append(strMrnNo);
                    
                    String strPolAtd = dbDao.searchDblEdiPolAtd(dblEdiInVO);
                    log.debug("\n******************** pol_atd ********************\n" + strPolAtd);
                    sbuff.append(strPolAtd);
                    
                    String strPodAta = dbDao.searchDblEdiPodAta(dblEdiInVO);
                    log.debug("\n******************** pod_ata ********************\n" + strPodAta);
                    sbuff.append(strPodAta);
                // 람세스물류 MRN No 추가건 2013.09.12
                }else if("1048145083".equals(ec_edircv_id_old)){
                	String strMrnNo = dbDao.searchDblEdiMrnNo(dblEdiInVO);
                    log.debug("\n******************** mrn_no ********************\n" + strMrnNo);
                    sbuff.append(strMrnNo);
                    
                    String strPolAtd = dbDao.searchDblEdiPolAtd(dblEdiInVO);
                    log.debug("\n******************** pol_atd ********************\n" + strPolAtd);
                    sbuff.append(strPolAtd);
                    
                    String strPodAta = dbDao.searchDblEdiPodAta(dblEdiInVO);
                    log.debug("\n******************** pod_ata ********************\n" + strPodAta);
                    sbuff.append(strPodAta);
                }
                // 2015 04 08 양동훈 수정.  
                // TP ID: TSKN , TSKN_IMPORT 310 EDI 에 POL_ATD, POD_ATA 정보표시
                else if("TSKN".equals(ec_edircv_id_old)||"TSKN_IMPORT".equals(ec_edircv_id_old)){
                	sbuff.append("MRN_NO:\n");
                	
                	String strPolAtd = dbDao.searchDblEdiPolAtd(dblEdiInVO);
                	log.debug("\n******************** pol_atd ********************\n" + strPolAtd);
                    sbuff.append(strPolAtd);
                	
                    String strPodAta = dbDao.searchDblEdiPodAta(dblEdiInVO);
                	log.debug("\n******************** pod_ata ********************\n" + strPodAta);
                    sbuff.append(strPodAta);
                }  
                //양동훈 수정 끝.
                else{
                    sbuff.append("MRN_NO:\n"
                            + "POL_ATD:\n"
                            + "POD_ATA:\n");
                }                
                
                if(strEdiGroupId == null) strEdiGroupId = " ";
                if(strEdiGroupCust == null) strEdiGroupCust = " ";
                
                String strGroupId = "GROUP_ID:" + strEdiGroupId + "/" + strEdiGroupCust+ "\n";
                log.debug("\n******************** group_id ********************\n" + strGroupId);
                sbuff.append(strGroupId);
                
                String strHpNmFlg = dbDao.searchHpNmFlg(dblEdiInVO);
                log.debug("\n******************** hp_nm_flg ********************\n" + strHpNmFlg);
                sbuff.append(strHpNmFlg);
                
                String strCustRef = dbDao.searchDblEdiCustRef(dblEdiInVO, strBlTp);
                log.debug("\n******************** cust_ref ********************\n" + strCustRef);
                sbuff.append(strCustRef);
                
                String strIcust = dbDao.searchDblEdiIcust(dblEdiInVO);
                log.debug("\n******************** icust ********************\n" + strIcust);
                sbuff.append(strIcust);
                
                String strBkgInfo = dbDao.searchDblEdiBkgInfo(dblEdiInVO);
                log.debug("\n******************** bkg_info ********************\n" + strBkgInfo);
                sbuff.append(strBkgInfo);
                
                //310 VF Corp. 으로  EX RATE 적용전 로직 Rollback 여부 체크 
                BkgHrdCdgCtntVO bkgAplyFlgVO = new BkgHrdCdgCtntVO();
                bkgAplyFlgVO.setHrdCdgId("BKG_APL_FLG");
                bkgAplyFlgVO.setAttrCtnt1("EDI310_EX");
                bkgAplyFlgVO.setAttrCtnt2("Y");
                
                //310전송시 Charge정보가 세팅되는 HP EDI TP ID확인
                BkgHrdCdgCtntVO bkgAplyFlg2VO = new BkgHrdCdgCtntVO();
                bkgAplyFlg2VO.setHrdCdgId("ASIA_HP_EDI_TP_CD");
                bkgAplyFlg2VO.setAttrCtnt1(ec_edircv_id_old);
                Boolean hp_asia_flg = utilCmd.checkBkgAplFlg(bkgAplyFlg2VO, account);
    			
                //CHARGE 정보 조회
                String strEdiChg = null;
                if(hp_asia_flg) {
                    /*
                     * 1. N3RD_OFC 가 SINSC 일 경우 searchDblEdiChgBySwaTrax
                     * 2. N3RD_OFC 가 SHARC 또는 SHAHQ 일 경우 searchDblEdiChgByChnTrax
                     * 3. CLT_OFC_CD 가 SHARC 또는 SHAHQ 일 경우 searchDblEdiChgByChnTrax
                     * 4. PPD_RCV_OFC_CD 또는 CLT_OFC_CD 가 SINSC 일 경우 searchDblEdiChgBySwaTrax
                     * 5. 위조건에 해당하지 않는 경우 수행하지 않음                             
                    */
                    String[] ediChgByTrax = dbDao.searchDblEdiChgByTrax(dblEdiInVO);
                    if("SINSC".equals(ediChgByTrax[0])){
                        strEdiChg = dbDao.searchDblEdiChgBySwaTrax(dblEdiInVO);
                    }else if("SHARC".equals(ediChgByTrax[0]) || "SHAHQ".equals(ediChgByTrax[0])){
                        strEdiChg = dbDao.searchDblEdiChgByChnTrax(dblEdiInVO);
                    }else if("SHARC".equals(ediChgByTrax[1]) || "SHAHQ".equals(ediChgByTrax[1])){
                        strEdiChg = dbDao.searchDblEdiChgByChnTrax(dblEdiInVO);
                    }else if("SINSC".equals(ediChgByTrax[1]) || "SINSC".equals(ediChgByTrax[2])){
                        strEdiChg = dbDao.searchDblEdiChgBySwaTrax(dblEdiInVO);
                    }else{
                        strEdiChg = "{CHARGE\n"
                                  + "FCTYPE:\n"
                                  + "RATE:\n"
                                  + "RATED_AS:\n"
                                  + "REVENUETON:\n"
                                  + "DIF_AMT:\n"
                                  + "CURRENCYCODE:\n"
                                  + "TARIFF:\n"
                                  + "PERTYPE:\n"
                                  + "EXRATE:\n"
                                  + "FRT_IND:\n"
                                  + "}CHARGE\n";
                    }
                } else if( "STARBUCKS".equals(ec_edircv_id_old) ){
                	strEdiChg = dbDao.searchDblEdiChg2(dblEdiInVO);
                } else if(null != dblEdiInVO.getGroupNm() && !"".equals(dblEdiInVO.getGroupNm()) && "VF Corp.".equals(dblEdiInVO.getGroupNm())){
                	if(utilCmd.checkBkgAplFlg(bkgAplyFlgVO, account)){
                		//VF Corp. 인경우 EXRATE 전송 
                		strEdiChg = dbDao.searchDblEdiChgByVf(dblEdiInVO);
                	}else{
                		strEdiChg = dbDao.searchDblEdiChg(dblEdiInVO);
                	}                	
                } else{
                    strEdiChg = dbDao.searchDblEdiChg(dblEdiInVO);
                }
                log.debug("\n******************** edi_chg ********************\n" + strEdiChg);
                sbuff.append(strEdiChg);
                
                //CHARGE Detail 조회
                String strEdiChgDtl = null;
                if( "HTLXML".equals(ec_edircv_id_old) || "HTLXML_IMG".equals(ec_edircv_id_old) ){
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl1(dblEdiInVO);
                } else if(hp_asia_flg){
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl2(dblEdiInVO);
                } else if( "STARBUCKS".equals(ec_edircv_id_old) ){
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl4(dblEdiInVO);
                } else if(null != dblEdiInVO.getGroupNm() && !"".equals(dblEdiInVO.getGroupNm()) && "VF Corp.".equals(dblEdiInVO.getGroupNm())){
                	if(utilCmd.checkBkgAplFlg(bkgAplyFlgVO, account)){
                		strEdiChgDtl = dbDao.searchDblEdiChgDtl5(dblEdiInVO);
                	}else{
                		strEdiChgDtl = dbDao.searchDblEdiChgDtl3(dblEdiInVO);
                	}
                } else{
                    strEdiChgDtl = dbDao.searchDblEdiChgDtl3(dblEdiInVO);
                }
                log.debug("\n******************** edi_chg_dtl ********************\n" + strEdiChgDtl);
                sbuff.append(strEdiChgDtl);
                
                String[] mk_desc_arr = dbDao.searchDblEdiMkDesc(dblEdiInVO);
                String strCmdtDesc = mk_desc_arr[0];
                String strMkDesc = mk_desc_arr[1];
                log.debug("\n******************** descriptions ********************\n" + strCmdtDesc);
                log.debug("\n******************** marks ********************\n" + strMkDesc);
                sbuff.append("{DESC\n");
                sbuff.append(strCmdtDesc);
                sbuff.append("}DESC\n");
                sbuff.append("{MARK\n");
                sbuff.append(strMkDesc);
                sbuff.append("}MARK\n");
                
                String tmpCntrDesc = "{CNTR_INFO:\n"
                                   + "CNTRNBR:\n"
                                   + "PUNIT:\n"
                                   + "PKG:\n"
                                   + "CNTRWGT:\n"
                                   + "CNTR_WGT_UNIT:\n"
                                   + "CNTRTYPE:\n"
                                   + "SEALNBR:\n"
                                   + "SEALNBR2:\n"
                                   + "SEALNBR3:\n"
                                   + "FM_IND:\n"
                                   + "RF_IND:\n"
                                   + "DG_IND:\n"
                                   + "AK_IND:\n"
                                   + "BK_IND:\n"
                                   + "SOC_IND:\n"
                                   + "TEMP:\n"
                                   + "TUNIT:\n"
                                   + "VENT:\n"
                                   + "HUMID:\n"
                                   + "MEASURE:\n"
                                   + "MEASURE_UNIT:\n"
                                   + "CN_RDTYPE:\n"
                                   + "CMDT_DESC:\n"
                                   + "CMDTCD:\n"
                                   + "RF_REMARK:\n"
                                   + "RFDRY_IND:\n"
                                   + "OVF:\n"
                                   + "OVR:\n"
                                   + "OVH:\n"
                                   + "OVLW:\n"
                                   + "OVRW:\n"
                                   + "OVWGT:\n"
                                   + "OVWGT_UNIT:\n"
                                   + "VOID_SLOT:\n"
                                   + "STWG_REQ:\n"
                                   + "PARTIAL:\n"
                                   + "EXCEPT:\n"
                                   + "SHIP_UNNO:\n";
                
                List<DblEdiCntrVO> cntrList = dbDao.searchDblEdiCntr(dblEdiInVO);
                int cntrCnt = cntrList == null ? 0 : cntrList.size();
                if(cntrCnt > 0){
                    for(int m=0;m<cntrCnt;m++){
                        DblEdiCntrVO ediCntrVO = cntrList.get(m);

                        log.debug("\n******************** cntr ********************\n" + ediCntrVO.getBkgCntr());
                        sbuff.append((ediCntrVO.getBkgCntr()==null || ediCntrVO.getBkgCntr().equals(""))?tmpCntrDesc:ediCntrVO.getBkgCntr());
                        
                        String strCntrDg = dbDao.searchDblEdiCntrDg(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_dg ********************\n" + strCntrDg);
                        sbuff.append(strCntrDg);
                        
                        String strCntrMf = dbDao.searchDblEdiCntrMf(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_mf ********************\n" + strCntrMf);
                        sbuff.append(strCntrMf);
                        
                        String strCntrPo = dbDao.searchDblEdiCntrPo(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_po ********************\n" + strCntrPo);
                        sbuff.append(strCntrPo);
                        
                        String strCntrSeal = dbDao.searchDblEdiCntrSeal(dblEdiInVO, ediCntrVO.getCntrNo());
                        log.debug("\n******************** cntr_seal ********************\n" + strCntrSeal);
                        sbuff.append(strCntrSeal);
                        
                        sbuff.append("}CNTR_INFO\n");

                    }
                }else{
                    sbuff.append(tmpCntrDesc);
                    sbuff.append("{CNTR_DANGER\n"
                            + "UNNBR:\n"
                            + "CLASS:\n"
                            + "DG_DESC:\n"
                            + "PHONE:\n"
                            + "PAGE:\n"
                            + "FLSH_TEMP:\n"
                            + "FLSH_UNIT:\n"
                            + "DG_REMARK:\n"
                            + "EMSNO:\n"
                            + "PSACLS:\n"
                            + "PKGGRP:\n"
                            + "MFAG1:\n"
                            + "MFAG2:\n"
                            + "MAR_POLL:\n"
                            + "LABEL_CD:\n"
                            + "LABEL_DESC:\n"
                            + "DG_PKG:\n"
                            + "DG_PKGUNIT:\n"
                            + "NWGT:\n"
                            + "NWGT_UNIT:\n"
                            + "GWGT:\n"
                            + "GWGT_UNIT:\n"
                            + "MEA:\n"
                            + "MEA_UNIT:\n"
                            + "HAZ_CONT:\n"
                            + "STWG:\n"
                            + "PACK_GP:\n"
                            + "}CNTR_DANGER\n"
                            + "{CNTR_DESC\n"
                            + "D_CMDT:\n"
                            + "D_PUNIT:\n"
                            + "D_PKG:\n"
                            + "D_WGT:\n"
                            + "D_MEAS:\n"
                            + "D_DESC:\n"
                            + "{CUS_MARK\n"
                            + "D_MARK:\n"
                            + "}CUS_MARK\n"
                            + "}CNTR_DESC\n"
                            + "{MULTI_PO_NO\n"
                            + "CNTR_PO_NO:\n"
                            + "}MULTI_PO_NO\n"
                            + "{MULTI_SEAL_NO\n"
                            + "CNTR_SEAL_NO:\n"
                            + "}MULTI_SEAL_NO\n"
                            + "}CNTR_INFO\n");
                }
                
                //searchDblEdiQty 
                String strQty = dbDao.searchDblEdiQty(dblEdiInVO);
                log.debug("\n******************** qty ********************\n" + strQty);
                sbuff.append(strQty);
                
                //searchDblEdiVvd
                String strVvd = dbDao.searchDblEdiVvd(dblEdiInVO);
                log.debug("\n******************** vvd ********************\n" + strVvd);
                sbuff.append(strVvd);

                //[ec_edircv_id=SECXML,FSELC OR ec_edircv_id_old=C1T0W,C1T0S,C1T0M,110AL] BLIssuanceDBDAO::searchDblEdiMisc ( dblEdiInVO )
    			if (Constants.SAMF_LIST.contains(ec_edircv_id_old)) {
                    String strMisc = dbDao.searchDblEdiMisc(dblEdiInVO, strSamf);
                    log.debug("\n******************** misc ********************\n" + strMisc);
                    sbuff.append(strMisc);  
                }else{
                    sbuff.append("{I_BKG_MISC\n"
                            + "IBM_PLANT_CD:\n"
                            + "IBM_PLANT_NM:\n"
                            + "IBM_DIV_CD:\n"
                            + "IBM_DIV_NM:\n"
                            + "IBM_BIZ_TP:\n"
                            + "IBM_BIZ_NM:\n"
                            + "IBM_TS_TP:\n"
                            + "IBM_TS_NM:\n"
                            + "IBM_POL_ZIP_CD:\n"
                            + "IBM_POL_POST_CD:\n"
                            + "IBM_POD_ZIP_CD:\n"
                            + "IBM_POD_POST_CD:\n"
                            + "IBM_DEL_ZIP_CD:\n"
                            + "IBM_DEL_POST_CD:\n"
                            + "IBM_PAY_MTH:\n"
                            + "IBM_INV_DT:\n"
                            + "IBM_LINE_CHG_WGT:\n"
                            + "IBM_LINE_CHG_WGT_CD:\n"
                            + "IBM_EDN_CHG_QTY:\n"
                            + "IBM_EDN_CHG_QTY_CD:\n"
                            + "IBM_EDN_CHG_WGT:\n"
                            + "IBM_EDN_CHG_WGT_CD:\n"
                            + "IBM_SUMCHG_WGT_QTY:\n"
                            + "IBM_SUMCHG_WGT_CD:\n"
                            + "IBM_MESSAGE_NO:\n"
                            + "}I_BKG_MISC\n");
                }
                

                //[ec_edircv_id_old="TRAX.HPAPAC","TRAX.HPAPACPROD"] BLIssuanceDBDAO::searchDblEdiHpSwa ( dblEdiInVO 
                if (hp_asia_flg){
                    String strHpSwa = dbDao.searchDblEdiHpSwa(dblEdiInVO);
                    log.debug("\n******************** hp_swa ********************\n" + strHpSwa);
                    sbuff.append(strHpSwa);
                }else{
                    sbuff.append("{HPSWA_INFO\n"
                            + "SHIP_ID:\n"
                            + "PART_NO:\n"
                            + "}HPSWA_INFO\n");
                }
                
                //310전송시 application date가  세팅되는 HP EDI TP ID확인
                BkgHrdCdgCtntVO bkgAplyFlg3VO = new BkgHrdCdgCtntVO();
                bkgAplyFlg3VO.setHrdCdgId("USA_HP_EDI_TP_CD");
                bkgAplyFlg3VO.setAttrCtnt1(ec_edircv_id_old);
                
                //[ec_edircv_id="6111470101","6111470101T",TRAX.HP"] BLIssuanceDBDAO::searchDblEdiChgInfo ( dblEdiInVO )
                if ("6111470101".equals(ec_edircv_id_old) || 
                    "6111470101T".equals(ec_edircv_id_old) || 
                    utilCmd.checkBkgAplFlg(bkgAplyFlg3VO, account) ){
                    String strChgInfo = dbDao.searchDblEdiChgInfo(dblEdiInVO);
                    log.debug("\n******************** chg_info ********************\n" + strChgInfo);
                    sbuff.append(strChgInfo);
                }else{
                    sbuff.append("{CHARGE_INFO\n"
                            + "CHG_APPL_DT:\n"
                            + "}CHARGE_INFO\n");
                }
                
                //[ec_edircv_id="3102178910"] BLIssuanceDBDAO::searchDblEdiNtc ( dblEdiInVO )
                if ("3102178910".equals(ec_edircv_id_old)){
                    String strNtc = dbDao.searchDblEdiNtc(dblEdiInVO);
                    log.debug("\n******************** notice ********************\n" + strNtc);
                    sbuff.append(strNtc);
                }else{
                    sbuff.append("{BKG_NOTICE\n"
                            + "PU_CY:\n"
                            + "PU_CYNAME:\n"
                            + "PU_CYADDR1:\n"
                            + "PU_CYADDR2:\n"
                            + "PU_CYADDR3:\n"
                            + "PU_CYADDR4:\n"
                            + "PU_CYADDR5:\n"
                            + "PU_CYPOST:\n"
                            + "PU_CYTEL:\n"
                            + "PU_CYFAX:\n"
                            + "}BKG_NOTICE\n");
                }
                
                String strAmsInfo = dbDao.searchDblEdiAmsInfo(dblEdiInVO);
                log.debug("\n******************** ams_info ********************\n" + strAmsInfo);
                sbuff.append(strAmsInfo); 

                log.debug("#####################################################");
                log.debug(" Flat File 끝 ");
                log.debug("#####################################################");
                //log.debug("\n" + sbuff.toString());
                //log.debug("");
                /* EDI 전송 */
                log.debug("#####################################################");
                log.debug(" EDI 전송 시작 ");
                log.debug("#####################################################");
                SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
                //특수문자 제거
                if("AJNMT".equals(ec_edircv_id_old)){
                	sendFlatFileVO.setFlatFile(sbuff.toString().replace(">",".").replace("*",".").replace("^","."));
                }else if("TRADIANT".equals(ec_edircv_id_old)){//GTN일 경우
                	sendFlatFileVO.setFlatFile(sbuff.toString().replace(">",".").replace("^",".").replace("~",".").replace("?","."));
                }else{
                	sendFlatFileVO.setFlatFile(sbuff.toString());
                }
                //sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UDEVHJS_CUSTOMER_301.IBMMQ.QUEUE"));
                sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMER_310.IBMMQ.QUEUE"));
                FlatFileAckVO flatFileAckVO = utilCmd.sendFlatFile(sendFlatFileVO);
                log.debug("#####################################################");
                log.debug(" EDI 전송 끝 : " + ("A".equals(flatFileAckVO.getAckStsCd()) ? "성공!" : "실패!"));
                log.debug("#####################################################");  
                //refernece No.를 추가
                flatFileAckVO.setFltFileRefNo(strEdiHeader.substring(62));
                flatFileAckVOs.add(flatFileAckVO);
                if ("E".equals(flatFileAckVO.getAckStsCd())){
                    //log.debug(new ErrorHandler("BKG00205", new String[] {}).getMessage());
                    throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
                }
                
                // DRAFT B/L 을 화주의 FTP에 직접 등록
                String ftpFlg = dbDao.searchFtPCheck(bkgNo);
                
                // DRAFT B/L 을 화주의 FTP에 직접 등록 : EIXML, EIXMLC 인 경우 
                String ftpPdfFlg = "";
                BkgHrdCdgCtntVO bkgHrdCdgCtntVO = dbDao.search310PdfGrpCheck(bkgNo, ec_edircv_id_old, dblEdiInVO.getGroupEdiCust());
                String formLevel = "";
                // chgFlg에 값이 있다는 것은 ftpPdfFlg가 'Y'라는 의미와 같다.
                if(bkgHrdCdgCtntVO != null) {
                	ftpPdfFlg = "Y";
                	if("Y".equals(bkgHrdCdgCtntVO.getAttrCtnt2()))  
                		formLevel = "1";
                	else
                		formLevel = "6";
                }
                else { 
                	formLevel = "1";
                }
                
                StringBuilder sbParam = new StringBuilder();
                if("Y".equals(ftpFlg) || "Y".equals(ftpPdfFlg)){
                	
            		sbParam.append("/rv");
            		sbParam.append(" form_bkgNo[('").append(bkgNo).append("')]");
            		sbParam.append(" form_type[").append("2").append("]");
            		sbParam.append(" form_dataOnly[N]");
            		sbParam.append(" form_manifest[N]");
            		sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
            		sbParam.append(" form_hiddeData[N]");
            		sbParam.append(" form_level[(").append(formLevel).append(")]");
            		sbParam.append(" form_remark[]");
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
                }
                
                String yyyymmddhh24miss = yyyymmddhh24missFormat.format(new Date(System.currentTimeMillis()));

                if ("Y".equals(ftpFlg)) {
					Ftp esvcFtp = new Ftp();
					esvcFtp.setRdApplCd("BKG016");
					esvcFtp.setRdParaCtnt(sbParam.toString());
					esvcFtp.setSubSysCd("BKG");
					esvcFtp.setUserId(account.getUsr_id());
					esvcFtp.setXptFileNm("SMLM" + bkgNo + "_" + ec_edircv_id_old + "_" + yyyymmddhh24miss + ".pdf");
	
					try {
						esvcFtp.sendEsvcReportFile("ESVC");
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				} 
                
                if ("Y".equals(ftpPdfFlg)) {
                	if(bkgHrdCdgCtntVO != null){
    					Ftp imageFtp = new Ftp();
    					//강정민 과장님  pd 전송 미반영 
    					imageFtp.setRdApplCd(bkgHrdCdgCtntVO.getAttrCtnt9()); // Draft - BKG016, BKG008 - Original Copy
//    					imageFtp.setRdApplCd("BKG016");
    					imageFtp.setRdParaCtnt(sbParam.toString());
    					imageFtp.setSubSysCd("BKG");
    					imageFtp.setUserId(account.getUsr_id());
    					imageFtp.setXptFileNm(bkgHrdCdgCtntVO.getAttrCtnt4());
    	
    					try {
    						imageFtp.sendEsvcReportFile(bkgHrdCdgCtntVO.getAttrCtnt3());
    					} catch (Exception e) {
    						log.error(e.getMessage());
    					}
                	}
				} 
                


//            }// enf of FOR 'ec_edircv_id_arr'

            dblEdiOutVO.setDblEdiSamf(strSamf);
            dblEdiOutVO.setFlatFileAckVOs(flatFileAckVOs);

        } catch(EventException ex) {
			throw ex;	
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
        return dblEdiOutVO;
    }

    /**
     * 조회 이벤트 처리
     * B/L no나 BKG no 오류체크 처리 ESM_BKG_0418
     *
     * @param String inoutMode
     * @param String vvd
     * @param String port
     * @param String[] bkgBlNos
     * @return String
     * @exception EventException
     */
    public String validBkgBlNo(String inoutMode, String vvd, String port, String[] bkgBlNos) throws EventException {
        StringBuilder sbBkgNos = null;
        int iCnt = 0;
        boolean bResult = true;
        String strResult = "";
        BkgBookingVO bkgBookingVO = null;
        try {
        	sbBkgNos = new StringBuilder();
        	if (null!=bkgBlNos && 0<bkgBlNos.length) {
	            for (int i=0; i<bkgBlNos.length; i++) {
	                bkgBookingVO = dbDao.searchBkgBookingByBkgBlNo(bkgBlNos[i]);
	                if (!"".equals(bkgBookingVO.getBkgNo())) {
	                	sbBkgNos.append(bkgBookingVO.getBkgNo()).append("@");
	                	if ("I".equalsIgnoreCase(inoutMode)) {
	                		sbBkgNos.append(bkgBookingVO.getPolCd());
	                	} else {
	                		sbBkgNos.append(bkgBookingVO.getPodCd());
	                	}
	                	sbBkgNos.append("|");
	                }
	                // B/L no나 BKG no 오류일 경우 - CoBkg.js ===> BKG00273
	                if ("".equals(bkgBookingVO.getBkgNo()) || "".equals(bkgBookingVO.getBlNo()) || "".equals(bkgBookingVO.getBkgStsCd())) {
	                    bResult = false;
	                    iCnt = i;
	                    break;
	                }
	            }
	            if (bResult && 0 < sbBkgNos.length()) {
	            	sbBkgNos.delete(sbBkgNos.length()-1,sbBkgNos.length());
	            	strResult = sbBkgNos.toString();
	            } else {
	            	strResult = "Error_" + iCnt;
	            }
        	}
            return strResult;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    
    /**
     * sendCanonEmlBkg
     * 
     * @param CanonEmlVO canonEml
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void sendCanonEmlBkg(CanonEmlVO canonEml, SignOnUserAccount account) throws EventException {
        BkgAutoEmlVO autoEmlVO = null;
        
        String bkgNo  = null;
        String blNo  = null;
        String usrId  = "";
        String usrNm  = "";
        String usrEml = "";
        String ofcCd = "";
        
        try {
            
            log.debug("CanonEmlVO --> AtdDt    : " + canonEml.getAtdDt());
            log.debug("CanonEmlVO --> CoNm     : " + canonEml.getCoNm());
            log.debug("CanonEmlVO --> VslCd    : " + canonEml.getVslCd());
            log.debug("CanonEmlVO --> SkdVoyNo : " + canonEml.getSkdVoyNo());
            log.debug("CanonEmlVO --> SkdDirCd : " + canonEml.getSkdDirCd());
            log.debug("CanonEmlVO --> PolCd    : " + canonEml.getPolCd());
            
            List<CanonEmlBkgVO> canonEmlVOs = dbDao.searchCanonEmlBkg(canonEml);
            int len = canonEmlVOs == null ? 0 : canonEmlVOs.size();
            if(len > 0 ){
                DblWblVO[] dblWblVOs = new DblWblVO[len];
                for(int i = 0; i < len; i++) {
                    bkgNo  = canonEmlVOs.get(i).getBkgNo();
                    blNo   = canonEmlVOs.get(i).getBlNo();
                    usrId  = canonEmlVOs.get(i).getUsrId();
                    usrNm  = canonEmlVOs.get(i).getUsrNm();
                    usrEml = canonEmlVOs.get(i).getUsrEml();
                    ofcCd = canonEmlVOs.get(i).getOfcCd();
                        
                    autoEmlVO = new BkgAutoEmlVO();
                    autoEmlVO.setBkgNo(bkgNo);
                    autoEmlVO.setAtdDt(canonEml.getAtdDt());
                    autoEmlVO.setSndFlg("Y");
                    autoEmlVO.setCreUsrId(usrId);
                    autoEmlVO.setUpdUsrId(usrId);
                    log.debug("BkgNo --> " + bkgNo);
                    log.debug("BlNo  --> " + blNo);
    
                    String rmkXchRt       = dbDao.searchCanonEmlRmkXchRt(autoEmlVO);
                    String rmkMrn         = dbDao.searchCanonEmlRmkMrn(autoEmlVO);
                    String rmkVslCallSign = dbDao.searchCanonEmlRmkVslCallSign(autoEmlVO);
                    String rmkCcn         = dbDao.searchCanonEmlRmkCcn(autoEmlVO);
                    String rmkUsrDflt     = dbDao.searchCanonEmlRmUsrDflt(autoEmlVO);
    
                    String blInfos        = dbDao.searchCanonEmlSubject(autoEmlVO);
                    log.debug("BlNo --> " + blInfos);
                    String[] blInfoArr    = blInfos.split("\\^");
                    log.debug("blInfoArr --> " + blInfoArr.length);
                    
                    String emlAddr        = dbDao.searchCanonEmlUsrEmlAddr(autoEmlVO);
                    String emlSubject     = "BL Draft: I/V NO-"+blInfoArr[2]+" B/L NO-"+blInfoArr[0];
                    String emlContents    = "Dear Customer,\n"
                                          + "\n"
                                          + "Please be informed B/L(s) are ready as per your shipping instruction.\n"
                                          + "\n"
                                          + "- B/L No : " + blInfoArr[0] + "\n"
                                          + "\n"
                                          + "If you find any discrepancy on attached draft B/Ls, please advise us of what needs to be amended. \n"
                                          + "\n"
                                          + "Thank you for choosing us\n"
                                          + "\n"
                                          + "SM Line Corporation\n"
                                          + "\n"
                                          + "For more detailed information on your shipments, go to <a href=\"http://www.smlines.com\">http://www.smlines.com</a>\n";
                    String mrdRmk         = rmkXchRt + "(##)" + rmkMrn + "(##)" + rmkVslCallSign + "(##)" + rmkCcn + "(##)" + rmkUsrDflt + "(##)";
                    String mrdParam       = "/rv "
                                          + "form_bkgNo[('"+bkgNo+"')] "
                                          + "form_type[2] "
                                          + "form_dataOnly[N] "
                                          + "form_manifest[N] "
                                          + "form_usrId["+usrId+"] "
                                          + "form_hiddeData[N] "
                                          + "form_level[(1)] "
                                          + "form_remark["+mrdRmk+"] "
                                          + "form_Cntr[1] "
                                          + "form_mainOnly[N] "
                                          + "form_CorrNo[] "
                                          + "form_his_cntr[BKG_CONTAINER] "
                                          + "form_his_bkg[BKG_BOOKING] "
                                          + "form_his_mkd[BKG_BL_MK_DESC] "
                                          + "form_his_xpt[BKG_XPT_IMP_LIC] "
                                          + "form_his_bl[BKG_BL_DOC] "
                                          + "/rp "
                                          + "[] "
                                          + "/riprnmargin ";

                    dblWblVOs[i] = new DblWblVO();
                    dblWblVOs[i].setBkgNo(bkgNo);
                    dblWblVOs[i].setBlNo(blNo);
                    dblWblVOs[i].setNtcKndCd("BL");
                    dblWblVOs[i].setSyscd("BKG");
                    dblWblVOs[i].setBatchflg("N");
                    dblWblVOs[i].setTmplmrd("ESM_BKG_0109_DBL.mrd");
                    dblWblVOs[i].setTmplparam(mrdParam);
                    dblWblVOs[i].setTmplmrdpdf(bkgNo + ".pdf");
                    dblWblVOs[i].setItr("|$$|");
                    dblWblVOs[i].setRcveml(emlAddr);
                    dblWblVOs[i].setTitle(emlSubject);
                    //dblWblVOs[i].setContents(emlContents);
                    dblWblVOs[i].setSndeml(usrEml);
                    dblWblVOs[i].setSndnm(usrNm);
                    
                    log.debug("\n---------------------------------------------------" +
                              "\n* To        : " + emlAddr +
                              "\n* Subject   : " + emlSubject +
                              "\n* Contents  : " + emlContents +
                              "\n" +
                              "\n--------------------------------------------------" +
                              "\n" +
                              "\n* MRD Name  : ESM_BKG_0109_DBL.mrd" + 
                              "\n* MRD Param : " + mrdParam +
                              "\n---------------------------------------------------");
                    
                    dbDao.createAutoEml(autoEmlVO);
                }
                
                /* EDI의 경우 account 정보가 없음.
                 * update on 2010.02.08
                 */
                account = new SignOnUserAccount(usrId,usrNm,"","","",usrEml,"","","","","","",ofcCd,"","","","","","","","","");
                
                log.debug("#################################### START : sendDblWblByEmail");
                sendDblWblByEmail(dblWblVOs, null, account);
//                List<BkgNtcHisVO> ntcHisVOs = sendDblWblByEmail(dblWblVOs, account);
                log.debug("#################################### END : sendDblWblByEmail");

                //BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
                //histCmd.createBkgNtcHis(ntcHisVOs, "BKG_BAT_010");
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * C/A를 위해 BlIssuanceBC 책임 table들을 복사한다.<br>
     * : 1. bkg_bl_iss를 복사한다.
     * : 2. copyTypeCd에 따라 'TEMP'나 'BKG'이면 caNo = 'TMP0000001'으로 하고 'HIST'이면 bkgBlNoVO.caNo로 한다.
     * @author    Lee NamKyung
     * @param     BkgBlNoVO bkgBlNoVO
     * @param     String copyTypeCd
     * @exception EventException
     */
    public void createIssCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            if ("BKG".equals(copyTypeCd)) {
//                dbDao.removeIssCA(bkgBlNoVO, copyTypeCd); 
            	dbDao.modifyIssCa(bkgBlNoVO, copyTypeCd);
            } else {
            	dbDao.createIssCA(bkgBlNoVO, copyTypeCd);
            }
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * C/A를 위해 booking 관련 BlIssuanceBC의 책임table을 삭제한다.
     * 
     * @author      Lee NamKyung
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String copyTypeCd
     * @exception   EventException
     */
    public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            //01. 
            dbDao.removeIssCA(bkgBlNoVO, copyTypeCd);   
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * LOCAL ISS 세부정보 수정
	 * 
	 * @param BkgBlIssVO bkgBlIssVO
	 * @exception EventException
	 */
	public void modifyIbDtlBlIss(BkgBlIssVO bkgBlIssVO) throws EventException {

        try {
            dbDao.modifyIbDtlBlIss(bkgBlIssVO);
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
        }

    }
	
	/**
	 * BKG_BL_ISS테이블 OBL_RLSE_FLG 관련 정보를 관리한다.<br>
	 * ESM_BKG_0743	연동 System	
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void modifyOBLRlseFlg(BlIssInfoVO blIssInfoVO)  throws EventException {
		
		try {
			dbDao.modifyOBLRlseFlg(blIssInfoVO);
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		
	}
	
	/**
	 * searchVesselNameByBkgNo.<br>
	 * bkgNo로 vessel명을 가져온다.	
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselNameByBkgNo(String bkgNo) throws EventException {
		String vslNm = null;
		try {
			vslNm = dbDao.searchVesselNameByBkgNo(bkgNo);
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return vslNm;
	}
	
	/**
	 * searchEmlCtnt.<br>
	 * bkgNo로 email content 를 가져온다.	
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchEmlCtnt(String bkgNo) throws EventException {
		String strEmlCtnt = null;
		try {
			strEmlCtnt = dbDao.searchEmlCtnt(bkgNo);

		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
		return strEmlCtnt;
	}
	

    /**
     * EsmBkg0095Event Email 이벤트 처리
     * Email 전송 (FAX&EDI > Draft B/L > EDI Transmission 발생시)
     *
     * @param DblWblVO dblWblVO
     * @param String tpId
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */
    public List<BkgNtcHisVO> sendDblAutoEmail(DblWblVO dblWblVO, String tpId, SignOnUserAccount account) throws EventException {
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
    	MailSendVO mailInfo = null;
        String retEmailSndId = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        String strBlNoTitle = null;
        String title = null;
        String contentsParam = null;
        BookingUtil util = null;
        StringBuilder sbParam = new StringBuilder();
        BkgRouteVO bkgRoute = null;
        String mrdName = null;
		ComUserVO comUserVO = null;
        try {
            util = new BookingUtil();
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            
            // Get Receive Email Address (Search Hard Coding Table)		
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("AUTO_DBL_EMAIL");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1(tpId);		
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs= util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			if(bkgHrdCdgCtntVOs.size() > 0) {
				dblWblVO.setRcveml(bkgHrdCdgCtntVOs.get(0).getAttrCtnt3());
			} else {
				return null;
			}

            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";
            mrdName = "ESM_BKG_0109_OBL_A4.mrd";
            bkgRoute = util.searchBkgRoute(dblWblVO.getBkgNo());
            if (null!=bkgRoute && 0==bkgRoute.getPorCd().indexOf("US")) {
                mrdName = "ESM_BKG_0109_OBL_LETTER.mrd";
            }
            // Email 전송
            mailInfo = new MailSendVO();
			mailInfo.setSysCd("BKG");
			mailInfo.setTmplMrd(mrdName);
			mailInfo.setBatchFlg("N");
			sbParam.append("/rv");
			sbParam.append(" form_bkgNo[('").append(dblWblVO.getBkgNo()).append("')]");
			sbParam.append(" form_type[2]");
			sbParam.append(" form_dataOnly[N]");
			sbParam.append(" form_manifest[N]");
			sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
			sbParam.append(" form_hiddeData[N]");
			sbParam.append(" form_level[(1)]");
			sbParam.append(" form_remark[]");
			sbParam.append(" form_Cntr[1]");
			sbParam.append(" form_mainOnly[N]");
			sbParam.append(" form_CorrNo[]");
			sbParam.append(" form_his_cntr[BKG_CONTAINER]");
			sbParam.append(" form_his_bkg[BKG_BOOKING]");
			sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
			sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
			sbParam.append(" form_his_bl[BKG_BL_DOC]");
			sbParam.append(" isEncode[Y]");
			sbParam.append(" /rp []");
			sbParam.append(" /riprnmargin");
			mailInfo.setTmplParam(sbParam.toString());
			senderMailAddr = util.searchGroupEmailAddrRSQL(dblWblVO.getBkgNo(), account.getUsr_id(),"EM", "BL");//group mail check
			if(senderMailAddr.equals("")){
				mailInfo.setSndNm(account.getUsr_nm());
			}else{
				mailInfo.setSndNm("");
			}
			
			mailInfo.setRcvEml(dblWblVO.getRcveml());
			if (senderMailAddr.equals("")){
				mailInfo.setSndEml(sUsrEml);
			}else{
				mailInfo.setSndEml(senderMailAddr);
        	}
			
			log.debug("dblWblVO.getRcveml()++++++++++++"+dblWblVO.getRcveml());
			log.debug("account.getUsr_id()++++++++++++"+account.getUsr_id());
			
			mailInfo.setCrtUserId(account.getUsr_id());
			mailInfo.setFileKey("");
			
			strBlNoTitle = dblWblVO.getBlNo();
			mailInfo.setTmplMrdPdf("SMLM"+strBlNoTitle+".pdf");

        	//Mail Title
        	if (!StringUtils.isEmpty(dblWblVO.getTitle())) {
        		title = dblWblVO.getTitle();
        	} 
        	//Mail Content
        	if (!StringUtils.isEmpty(dblWblVO.getContents())) {
        		contentsParam = dblWblVO.getContents();
        	} 
			
			mailInfo.setTitle(title); // 제목
			mailInfo.setContents(contentsParam); // 내용
	
            // Send Mail - *.mrd 파일 단건 보낼 시 1:1매칭
			//retEmailSndId = bleaiDao.sendEmail(mailInfo,dblWblVO.getNtcKndCd());
			
			//retEmailSndId = bleaiDao.sendEmail(mailInfo,dblWblVO.getNtcKndCd(),"webmaster@smlines.com");  //참조(cc)추가
			String ccEmlAddr = util.searchCcEmailAddrRSQL(dblWblVO.getNtcKndCd(), account.getUsr_id());
			if (StringUtils.isEmpty(ccEmlAddr)){
				ccEmlAddr = "webmaster@smlines.com";
			}
			retEmailSndId = bleaiDao.sendEmail(mailInfo,null,dblWblVO.getNtcKndCd(),util.searchCcEmailAddrRSQL(dblWblVO.getNtcKndCd(), account.getUsr_id())+";"+senderMailAddr);  //참조(cc)추가
			
//			log.debug("retEmailSndIds"+retEmailSndIds.size());
//			if (retEmailSndIds.size() > 0) retEmailSndId = retEmailSndIds.get(0);
//			else  retEmailSndId = "";
			
            // Notice History Setting(History에는 bkg_no별로 남겨야 함)
            strNBkgNo = new StringTokenizer(dblWblVO.getBkgNo(), "|");  // 한  BL에 여러 BKG_NO가 올 경우 "|"로 구분하여 문자열로 넘어 온다고 가정하여 처리
            while (strNBkgNo.hasMoreTokens()) {
                bkgNtcHisVO = new BkgNtcHisVO();
                bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
                bkgNtcHisVO.setNtcViaCd("M");
                bkgNtcHisVO.setNtcKndCd((dblWblVO.getNtcKndCd()==null||"".equals(dblWblVO.getNtcKndCd()))?"BL":dblWblVO.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                bkgNtcHisVO.setAgnCd("");
                bkgNtcHisVO.setNtcFomCd("");
                bkgNtcHisVO.setNtcSeq("");
                bkgNtcHisVO.setBkgCustTpCd("");
                bkgNtcHisVO.setCustCntcTpCd("");
                bkgNtcHisVO.setNtcEml(dblWblVO.getRcveml());
                bkgNtcHisVO.setSndId(retEmailSndId);
                bkgNtcHisVO.setFrtHdnFlg(dblWblVO.getHiddOpt());
                bkgNtcHisVO.setFrtAllFlg(dblWblVO.getFrtAllFlg());
                bkgNtcHisVO.setFrtCltFlg(dblWblVO.getFrtCltFlg());
                bkgNtcHisVO.setFrtPpdFlg(dblWblVO.getFrtPpdFlg());
                bkgNtcHisVO.setFrtChgFlg(dblWblVO.getFrtChgFlg());
                bkgNtcHisVO.setFrtArrFlg(dblWblVO.getFrtArrFlg());
                bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                bkgNtcHisVO.setDiffRmk("");
                bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                bkgNtcHisVOs.add(bkgNtcHisVO);
            }
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
    /**
     * E-B/L Issue 대상을 조회한다.<br>
     * 
     * @param EBLIssueInputVO eBLIssueInputVO
     * @return List<EBLIssueVO>
     * @exception EventException
     */
    public List<EBLIssueVO> searchEBLIssueList(EBLIssueInputVO eBLIssueInputVO) throws EventException {
        List<EBLIssueVO> eBLIssueVOs = null;
        try {
        	eBLIssueVOs = dbDao.searchEBLIssueList(eBLIssueInputVO);
        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eBLIssueVOs;
    }
    
    /**
     *  E-B/L Issue
     *
     * @param String bkgNo
     * @param String srStsCd
     * @param String rate
     * @param String hiddenData
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEBLIssue(String bkgNo, String srStsCd, String rate, String hiddenData, SignOnUserAccount account) throws EventException {
    	String maxBkgEblSeq = "";
    	String maxEblHisSeq = "";
    	int result = 0;
        try {
        	if(!bkgNo.equals("")){	
        		
        		dbDao.modifyBkgElctrBlCrntRqst(bkgNo, srStsCd, account.getUsr_id());                
        		maxBkgEblSeq = dbDao.searchEblMaxBkgSeq(bkgNo);        		
        		result = dbDao.addBkgEblAvc(bkgNo, maxBkgEblSeq, srStsCd,account.getUsr_id());
        		
        		if(result > 0){
	                dbDao.addBkgEblAvcAdd(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcChg(bkgNo, maxBkgEblSeq, rate, hiddenData,account.getUsr_id());
	                dbDao.addBkgEblAvcCntr(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcDesc(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcNtfy(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcVvd(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcXchRt(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                
	                maxEblHisSeq = dbDao.searchEblMaxHisSeq(bkgNo);
	                dbDao.addBkgEblCrntRqstHis(bkgNo, maxEblHisSeq ,account.getUsr_id());
        		}
        	}
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }  
    
    /**
     *  E-B/L Re-Issue
     *
     * @param String bkgNo
     * @param String srStsCd
     * @param String rate
     * @param String hiddenData
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEBLReIssue(String bkgNo, String srStsCd, String rate, String hiddenData, SignOnUserAccount account) throws EventException {
    	String maxBkgEblSeq = "";
    	String maxEblHisSeq = "";
//    	String eblTypeCode = "";
//    	String maxBkgEblGenSeq = "";
    	int result = 0;
        try {
        	if(!bkgNo.equals("")){	
//        		eblTypeCode = "3"; // 변경발행
        		dbDao.modifyBkgElctrBlCrntRqst(bkgNo, srStsCd, account.getUsr_id());                
        		maxBkgEblSeq = dbDao.searchEblMaxBkgSeq(bkgNo);
//        		maxBkgEblGenSeq = dbDao.searchEblMaxGenSeq(bkgNo);
        		result = dbDao.addBkgEblAvc(bkgNo, maxBkgEblSeq, srStsCd,account.getUsr_id());
        		
        		if(result > 0){
	                dbDao.addBkgEblAvcAdd(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcChg(bkgNo, maxBkgEblSeq, rate, hiddenData,account.getUsr_id());
	                dbDao.addBkgEblAvcCntr(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcDesc(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcNtfy(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcVvd(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                dbDao.addBkgEblAvcXchRt(bkgNo, maxBkgEblSeq, account.getUsr_id());
	                
	                
//	                dbDao.addBkgEblGenNtc(bkgNo, maxBkgEblGenSeq,eblTypeCode, account.getUsr_id());
	                
	                maxEblHisSeq = dbDao.searchEblMaxHisSeq(bkgNo);
	                dbDao.addBkgEblCrntRqstHis(bkgNo, maxEblHisSeq ,account.getUsr_id());
        		}
        	}
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }      
    
    /**
     *  E-B/L Issue
     *
     * @param String bkgNo
     * @param String srStsCd
     * @param String remark
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEBLReject(String bkgNo, String srStsCd, String remark, SignOnUserAccount account) throws EventException {
    	String maxBkgEblSeq = "";
    	String maxEblHisSeq = "";
    	String eblTypeCode = "";
        try {
        	if(!bkgNo.equals("")){	
        		eblTypeCode = "11"; //취소결과통보
        		dbDao.modifyBkgElctrBlCrntRqst(bkgNo, "U", remark, account.getUsr_id());                
        		maxBkgEblSeq = dbDao.searchEblMaxBkgSeq(bkgNo);
                maxEblHisSeq = dbDao.searchEblMaxHisSeq(bkgNo);
                dbDao.addBkgEblCrntRqstHis(bkgNo, maxEblHisSeq ,account.getUsr_id());
    			dbDao.addBkgEblGenNtc(bkgNo, maxBkgEblSeq,eblTypeCode, account.getUsr_id());
    			
        		}
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }  
    
    /**
     *  E-B/L Issue
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageEBLConfirm(String bkgNo, SignOnUserAccount account) throws EventException {
    	String maxEblHisSeq = "";
    	int result = 0;
        try {
        	if(!bkgNo.equals("")){	
        		
        		result = dbDao.addBkgElctrBlCrntRqst(bkgNo, account.getUsr_id());   
        		
        		if(result > 0){ 
	                
        			maxEblHisSeq = dbDao.searchEblMaxHisSeq(bkgNo);
	                dbDao.addBkgEblCrntRqstHis(bkgNo, maxEblHisSeq ,account.getUsr_id());
        		}
        	}
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }  
    /**
     *  E-B/L Delivery Notice
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageDelConfirm(String bkgNo, SignOnUserAccount account) throws EventException {
    	String maxEblHisSeq = "";
    	String maxBkgEblGenSeq = "";
    	String eblTypeCode ="";
        try {
        	if(!bkgNo.equals("")){	
        			eblTypeCode = "6"; // 상환내역통보
        			dbDao.modifyBkgElctrBlCrntRqst(bkgNo, "D", account.getUsr_id());
        			maxEblHisSeq = dbDao.searchEblMaxHisSeq(bkgNo);
	                dbDao.addBkgEblCrntRqstHis(bkgNo, maxEblHisSeq ,account.getUsr_id());
	        		maxBkgEblGenSeq = dbDao.searchEblMaxGenSeq(bkgNo);
	                dbDao.addBkgEblGenNtc(bkgNo, maxBkgEblGenSeq,eblTypeCode, account.getUsr_id());
	                dbDao.addBkgEblDeNtc(bkgNo, maxEblHisSeq ,account.getUsr_id());
        	}
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     *  E-B/L Confirm
     *
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageConfirm(String bkgNo, SignOnUserAccount account) throws EventException {
    	String maxBkgEblSeq = "";
    	String maxEblHisSeq = "";
    	String eblTypeCode = "";
    	String srStsCd = "";
        try {
        	if(!bkgNo.equals("")){
        		srStsCd = dbDao.searchEblCrntSrSts(bkgNo);
        		log.debug("@@@@@@@"+srStsCd);
        		eblTypeCode = "5"; // 인도청구신청결과통보
    			if(null != srStsCd && srStsCd.equals("R")){
        			eblTypeCode = "2"; // 변경신청결과통보        				
    			}
        		maxBkgEblSeq = dbDao.searchEblMaxBkgSeq(bkgNo);
        		dbDao.modifyBkgElctrBlCrntRqst(bkgNo, "F", account.getUsr_id());                
        		maxEblHisSeq = dbDao.searchEblMaxHisSeq(bkgNo);
        		dbDao.addBkgEblCrntRqstHis(bkgNo, maxEblHisSeq ,account.getUsr_id());
    			dbDao.addBkgEblGenNtc(bkgNo, maxBkgEblSeq,eblTypeCode, account.getUsr_id());
	                
        	}
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }     
    
	/**
	 * Web Service EAI용(WEB_004_0001)<br>
	 * 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트<br>
	 * 
	 * @param BkgWebService004VO webVo
	 * @exception EventException
	 */
	public void modifyWeb0040001Control(BkgWebService004VO webVo) throws EventException {
		try {
			
			// UPDATE
			dbDao.modifyIntAuth(webVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}	
	}
	
	/**
	 * Web Service EAI용(WEB_005_0001)<br>
	 * 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트<br>
	 * 
	 * @param BkgWebService005VO webVo
	 * @exception EventException
	 */
	public void modifyWeb0050001Control(BkgWebService005VO webVo) throws EventException {
		try {
			
			// INSERT
			dbDao.addBLissueRqst(webVo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}	
	}
	
	
	/**
     * ESM_BKG_1119
     * Retrieve버튼 클릭시 Data를 조회한다.<br>
     * 
     * @param BlIssRqstVO blIssRqstVO
     * @return List<BlIssRqstVO>
     * @exception EventException
     */
    public List<BlIssRqstVO> searchBlIssRqstList(BlIssRqstVO blIssRqstVO) throws EventException {
        List<BlIssRqstVO> blIssRqstVOs = null;
        try {
        	blIssRqstVOs = dbDao.searchBlIssRqstList(blIssRqstVO);
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blIssRqstVOs;
    }	
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 명세 화면 설정을 위한 Data를 조회한다.
	 * 
     * @param String xterRqstNo
     * @param String xterRqstSeq
     * @return BlIssRqstVO
     * @exception EventException
	 */
	public BlIssRqstVO searchBlIssRqstInquiry(String xterRqstNo, String xterRqstSeq) throws EventException {
        BlIssRqstVO blIssRqstVO = null;
        try {
        	blIssRqstVO = dbDao.searchBlIssRqstInquiry(xterRqstNo, xterRqstSeq);
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blIssRqstVO;		
	}
	
	/**
	 * ESM_BKG_1119
	 * B/L 발급 신청 리스트 화면에서 Delete버튼을 클릭했을 때 delt_flg값을 'Y'으로 Update한다.
	 * 
     * @param BlIssRqstVO[] blIssRqstVOs
     * @param String updUsrId
     * @exception EventException
	 */
    public void modifyBlIssRqstDeltFlg(BlIssRqstVO[] blIssRqstVOs, String updUsrId) throws EventException {
        try {
        	if (blIssRqstVOs != null) {
				for(int i=0; i<blIssRqstVOs.length; i++){
					dbDao.modifyBlIssRqstDeltFlg(blIssRqstVOs[i], updUsrId);
				}
        	}				
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Approval버튼을 클릭했을 때 상태코드와 remark를 Update한다.
	 * 
     * @param BlIssRqstVO blIssRqstVO
     * @param String updUsrId
     * @exception EventException
	 */
    public void modifyBlIssRqstApproval(BlIssRqstVO blIssRqstVO, String updUsrId) throws EventException {
        try {
        	if (blIssRqstVO != null) {
				dbDao.modifyBlIssRqstApproval(blIssRqstVO, updUsrId);
				
        	}
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Reject버튼을 클릭했을 때 상태코드와 remark를 Update한다.
	 * 
     * @param BlIssRqstVO blIssRqstVO
     * @param String updUsrId
     * @exception EventException
	 */
    public void modifyBlIssRqstReject(BlIssRqstVO blIssRqstVO, String updUsrId) throws EventException {
        try {
        	if (blIssRqstVO != null) {
				dbDao.modifyBlIssRqstReject(blIssRqstVO, updUsrId);
        	}				
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Approval버튼을 클릭했을 때 상태코드와 remark가 Update 된 뒤 메일을 발송
	 * 
     * @param BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO
     * @param SignOnUserAccount account
     * @exception EventException
	 */
    public void sendBlIssRqstByMail(BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO, SignOnUserAccount account) throws EventException {
        try {
        	log.debug("@@@@@@ BCImpl : sendBlIssRqstByMail start");
        	if (bkgBlIssRqstMailSndVO != null) {
        		log.debug("@@@@@@ BCImpl : bkgBlIssRqstMailSndVO is not null");
        		
        		//메일 발송
        		String sndId = bleaiDao.sendBlIssRqstByMail(bkgBlIssRqstMailSndVO);
        		log.debug("@@@@@@ BCImpl : send mail finish. sndId = "+sndId);
        		
        		log.debug("@@@@@@ BCImpl : history log start");
        		//내역 기록
        		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
        		bkgNtcHisVO.setSndId(sndId);
    			bkgNtcHisVO.setBkgNo(bkgBlIssRqstMailSndVO.getBlNo());
    			bkgNtcHisVO.setNtcViaCd("M"); // M = eMail
    			bkgNtcHisVO.setNtcKndCd("KB"); // B/L Issue Request(WEB)
    			bkgNtcHisVO.setNtcEml(bkgBlIssRqstMailSndVO.getRcvrEml());
    			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
    			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
    			//snd_rqst_dt의 형식을 기존 쿼리문 사용에 문제가 없도록 
    			//YYYY-MM-DD HH24:MI -> YYYYMMDD HH24MISS 형식으로 변환
    			String modifiedDt = bkgBlIssRqstMailSndVO.getSndDt();
    			modifiedDt = modifiedDt.replace("-", "");
    			modifiedDt = modifiedDt.replace(":", "");
    			StringBuffer modifiedDt1= new StringBuffer(modifiedDt);
    			modifiedDt1.append("00");
    			modifiedDt = modifiedDt1.toString();

    			bkgNtcHisVO.setSndRqstDt(modifiedDt);
    			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
    			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
        		histDao.addBkgNtcHis(bkgNtcHisVO);
        		log.debug("@@@@@@ BCImpl : history log finish");
        	}				
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    
    
    /**
     * Email(S/R) 전송
     *
     * @param DblWblVO[] dblWblVOs
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */    
    public List<BkgNtcHisVO> sendSrEmail(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
//        String strBlNoTitle = null;
//        String strBlNoBody = null;
        String title = null;
        String contentsParam = null;
        //int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		//String blNtcKndCd = "";
        try {
            util = new BookingUtil();
			// 수정  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";
            int idx = 0;
            for (DblWblVO vo : dblWblVOs) {
                // 여러개의 *.mrd파일을 Email송신을 할 경우
                // vo.getTmplmrd()의 값으로 구분자('|$$|')를  기준으로 
                // 루프를 돌면서 Email에 파일로 첨부시킨다.
                // tmplmrd / tmplparam 이 2개의 값만 여러개가 올 수 있고 나머지Parameter는 동일하다.

            	// Email 전송
                mailInfo = new MailSendVO();
				mailInfo.setSysCd("BKG");
				mailInfo.setTmplMrd(vo.getTmplmrd());
				mailInfo.setBatchFlg("N");
				mailInfo.setTmplParam(vo.getTmplparam());
				
				// BKG별 S/R 정보를 가져온다.
            	BkgSrEmlEdtVO bkgSrEmlEdtVO = dbDao.searchSrEmail(vo.getBkgNo(),account.getUsr_id());
    	        if (bkgSrEmlEdtVO==null) {
    					throw new EventException(new ErrorHandler("BKG95064").getMessage());
    					   
    			}
            	
				if(senderMailAddr.equals("")){
					mailInfo.setSndNm(account.getUsr_nm());
				}else{
					mailInfo.setSndNm("");
				}
				//TO 에 FROM EMAIL 제거 
				mailInfo.setRcvEml(vo.getRcveml());
 				if (senderMailAddr.equals("")){
						mailInfo.setSndEml(sUsrEml);
				}else {
					mailInfo.setSndEml(senderMailAddr);
				}
				//from mail 값 셋
				mailInfo.setCrtUserId(account.getUsr_id());
				mailInfo.setFileKey("");
                
				if (!"Y".equalsIgnoreCase(vo.getGrpFlag()) || ("Y".equalsIgnoreCase(vo.getGrpFlag()) && 0==idx++)) {
					//strBlNoTitle = strBlNoBody = vo.getBlNo();
                	//메일양식
            		StringBuilder titleSb = new StringBuilder("SM Line ");
            		if("Y".equals(bkgSrEmlEdtVO.getCnOfcFlg()))
            			titleSb.append("S/R 截止日期信息 ");
            		else	
            			titleSb.append("S/R 마감 안내");
            		title = titleSb.toString();
					contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "vslNm;"+bkgSrEmlEdtVO.getVslNm()+"@@bkgNo;"+bkgSrEmlEdtVO.getBkgNo()+"@@polPodCd;"+bkgSrEmlEdtVO.getPolPodCd()+"@@etbEtdDt;"+bkgSrEmlEdtVO.getEtbEtdDt()+"@@doc;"+bkgSrEmlEdtVO.getDoc()+"@@cargo;"+bkgSrEmlEdtVO.getCargo()+"@@vgmCutOff;"+bkgSrEmlEdtVO.getVgmCutOff()+"@@remark;"+bkgSrEmlEdtVO.getRemark()+"@@img;"+"http://alps.smlines.com/hanjin/img/report_hanjin_logo.jpg";
					mailInfo.setTitle(title); // 제목
    				mailInfo.setContents(contentsParam); // 내용
                    // Send Mail - *.mrd 파일 단건 보낼 시 1:1매칭
                    // 즉, *.mrd파일이 여러건일 경우 동일한 메일계정으로 *.mrd파일 수 만큼 송신이됨
                    retEmailSndId = bleaiDao.sendSrEmail(mailInfo, vo.getNtcKndCd(),bkgSrEmlEdtVO.getCnOfcFlg());
                }
                // Notice History Setting(History에는 bkg_no별로 남겨야 함)
                strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");  // 한  BL에 여러 BKG_NO가 올 경우 "|"로 구분하여 문자열로 넘어 온다고 가정하여 처리
                while (strNBkgNo.hasMoreTokens()) {
                    bkgNtcHisVO = new BkgNtcHisVO();
                    bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
                    bkgNtcHisVO.setNtcViaCd("M");
                    bkgNtcHisVO.setNtcKndCd((vo.getNtcKndCd()==null||"".equals(vo.getNtcKndCd()))?"BL":vo.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                    bkgNtcHisVO.setAgnCd("");
                    bkgNtcHisVO.setNtcFomCd("");
                    bkgNtcHisVO.setNtcSeq("");
                    bkgNtcHisVO.setBkgCustTpCd("");
                    bkgNtcHisVO.setCustCntcTpCd("");
                    bkgNtcHisVO.setNtcEml(vo.getRcveml());
                    bkgNtcHisVO.setSndId(retEmailSndId);
                    bkgNtcHisVO.setFrtHdnFlg(vo.getHiddOpt());
                    bkgNtcHisVO.setFrtAllFlg(vo.getFrtAllFlg());
                    bkgNtcHisVO.setFrtCltFlg(vo.getFrtCltFlg());
                    bkgNtcHisVO.setFrtPpdFlg(vo.getFrtPpdFlg());
                    bkgNtcHisVO.setFrtChgFlg(vo.getFrtChgFlg());
                    bkgNtcHisVO.setFrtArrFlg(vo.getFrtArrFlg());
                    bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                    bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                    bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                    bkgNtcHisVO.setDiffRmk("");
                    bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                    bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                    bkgNtcHisVOs.add(bkgNtcHisVO);
                }
            }
        }catch(EventException ee) {
            throw ee;
        }catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
    /**
     * Email(S/R) 전송
     *
     * @param DblWblVO[] dblWblVOs
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @exception EventException
     */    
    public List<BkgNtcHisVO> sendEqEmail(DblWblVO[] dblWblVOs, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
//        String strBlNoTitle = null;
//        String strBlNoBody = null;
        String title = null;
        String contentsParam = null;
        //int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
		//String blNtcKndCd = "";
        try {
            util = new BookingUtil();
			// 수정  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";
            int idx = 0;
            for (DblWblVO vo : dblWblVOs) {
                // 여러개의 *.mrd파일을 Email송신을 할 경우
                // vo.getTmplmrd()의 값으로 구분자('|$$|')를  기준으로 
                // 루프를 돌면서 Email에 파일로 첨부시킨다.
                // tmplmrd / tmplparam 이 2개의 값만 여러개가 올 수 있고 나머지Parameter는 동일하다.

            	// Email 전송
                mailInfo = new MailSendVO();
				mailInfo.setSysCd("BKG");
				mailInfo.setTmplMrd(vo.getTmplmrd());
				mailInfo.setBatchFlg("N");
				mailInfo.setTmplParam(vo.getTmplparam());
				
				// BKG별 E/Q 정보를 가져온다.
				DblWblEQVO dblWblEQVO = dbDao.searchEqEmail(vo.getBkgNo());
    	        if (dblWblEQVO==null) {
    					throw new EventException(new ErrorHandler("BKG95064").getMessage());
    					   
    			}
            	
				if(senderMailAddr.equals("")){
					mailInfo.setSndNm(account.getUsr_nm());
				}else{
					mailInfo.setSndNm("");
				}
				//TO 에 FROM EMAIL 제거 
				mailInfo.setRcvEml(vo.getRcveml());
 				if (senderMailAddr.equals("")){
						mailInfo.setSndEml(sUsrEml);
				}else {
					mailInfo.setSndEml(senderMailAddr);
				}
				//from mail 값 셋
				mailInfo.setCrtUserId(account.getUsr_id());
				mailInfo.setFileKey("");
                
				if (!"Y".equalsIgnoreCase(vo.getGrpFlag()) || ("Y".equalsIgnoreCase(vo.getGrpFlag()) && 0==idx++)) {
					//strBlNoTitle = strBlNoBody = vo.getBlNo();
                	//메일양식
            		StringBuilder titleSb = new StringBuilder("");
            		if(account.getOfc_cd().startsWith("SEL"))
            			titleSb.append("[SM Line] Container Pickup 안내");
            		else	
            			titleSb.append("A Guide to Container Pickup [SM Line]");
            		title = titleSb.toString();
            		
            		//현재 cntr이 attach 안되었으면 NIL
            		if("".equalsIgnoreCase(dblWblEQVO.getCntrQty()) || StringUtils.isEmpty(dblWblEQVO.getCntrQty())){
            			dblWblEQVO.setCntrQty("NIL");
            		}
					contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "vslNm;"+dblWblEQVO.getVvdNm()+"@@bkgNo;"+dblWblEQVO.getBkgNo()+"@@polPodCd;"+dblWblEQVO.getPolCd()+" / "+dblWblEQVO.getPodCd()+"@@etbEtdDt;"+dblWblEQVO.getEtb()+" / "+dblWblEQVO.getEtd()+"@@cargo;"+dblWblEQVO.getCgoCutOffTm()+"@@bkgQty;"+dblWblEQVO.getBkgQty()+"@@cntrQty;"+dblWblEQVO.getCntrQty()+"@@img;"+"http://alps.smlines.com/hanjin/img/report_hanjin_logo.jpg";
					mailInfo.setTitle(title); // 제목
    				mailInfo.setContents(contentsParam); // 내용
                    // Send Mail - *.mrd 파일 단건 보낼 시 1:1매칭
                    // 즉, *.mrd파일이 여러건일 경우 동일한 메일계정으로 *.mrd파일 수 만큼 송신이됨
                    retEmailSndId = bleaiDao.sendEqEmail(mailInfo, vo.getNtcKndCd(),account);
                }
                // Notice History Setting(History에는 bkg_no별로 남겨야 함)
                strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");  // 한  BL에 여러 BKG_NO가 올 경우 "|"로 구분하여 문자열로 넘어 온다고 가정하여 처리
                while (strNBkgNo.hasMoreTokens()) {
                    bkgNtcHisVO = new BkgNtcHisVO();
                    bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
                    bkgNtcHisVO.setNtcViaCd("M");
                    bkgNtcHisVO.setNtcKndCd((vo.getNtcKndCd()==null||"".equals(vo.getNtcKndCd()))?"EQ":vo.getNtcKndCd());  // NTC_KND_CD(BL:Outbound,NN:Inbound,WB:Waybill)  
                    bkgNtcHisVO.setAgnCd("");
                    bkgNtcHisVO.setNtcFomCd("");
                    bkgNtcHisVO.setNtcSeq("");
                    bkgNtcHisVO.setBkgCustTpCd("");
                    bkgNtcHisVO.setCustCntcTpCd("");
                    bkgNtcHisVO.setNtcEml(vo.getRcveml());
                    bkgNtcHisVO.setSndId(retEmailSndId);
//                    bkgNtcHisVO.setFrtHdnFlg(vo.getHiddOpt());
//                    bkgNtcHisVO.setFrtAllFlg(vo.getFrtAllFlg());
//                    bkgNtcHisVO.setFrtCltFlg(vo.getFrtCltFlg());
//                    bkgNtcHisVO.setFrtPpdFlg(vo.getFrtPpdFlg());
//                    bkgNtcHisVO.setFrtChgFlg(vo.getFrtChgFlg());
//                    bkgNtcHisVO.setFrtArrFlg(vo.getFrtArrFlg());
                    bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                    bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                    bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                    bkgNtcHisVO.setDiffRmk("");
                    bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                    bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                    bkgNtcHisVOs.add(bkgNtcHisVO);
                }
            }
        }catch(EventException ee) {
            throw ee;
        }catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
    
    /**
     * EsmBkg0726Event 저장 이벤트 처리<br>
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageGrpBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException{
    	
    	log.debug("[1][======== [BLIssuanceBC] :: manageBlIssueFlg ]==========");
    	
    	String bkgNo 	  = blIssInfoVO.getBkgNo();
    	String blNo 	  = blIssInfoVO.getBlNo();
    	String buttonType = blIssInfoVO.getButtontype();
    	log.debug("[1][======== [BLIssuanceBC] :: bkgNo ]=========="+bkgNo);
    	log.debug("[1][======== [BLIssuanceBC] :: blNo ]=========="+blNo);
    	log.debug("[1][======== [BLIssuanceBC] :: buttonType ]=========="+buttonType);
    	
        try {        	
        	
        	String valFlg = dbDao.validateBLIssOfcCd( blIssInfoVO.getBlIssueAt());
	        if ("N".equals(valFlg)) {
					throw new EventException(new ErrorHandler("BKG00905").getMessage());
					   
			}
        	  
        	//버튼액션을 취하기 전에 우선적으로 화면의 데이터 값을 저장처리를 한다. -- 0726은 불필요
        	//manageBlIssInfo(blIssInfoVO);
        	
        	// validation 
            BookingUtil bookingUtilBC = new BookingUtil();
            BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
            bkgBlNoIn.setBkgNo(bkgNo);
            bkgBlNoIn.setBlNo(blNo);
    		bkgBlNoIn.setCaUsrId(blIssInfoVO.getUpdUsrId());
            BkgBlNoVO bkgBlNoOut = bookingUtilBC.searchBkgBlNoVO(bkgBlNoIn);
            if(bkgBlNoOut == null) {
                throw new Exception(new ErrorHandler("BKG08073").getMessage());
            }
            // Cancel된 booking은  처리 않는다.
            if("X".equals(bkgBlNoOut.getBkgStsCd())) {
                // TODO
                throw new Exception(new ErrorHandler("BKG08073").getMessage());
            }
           
            // 00. button setting 
        	blIssInfoVO.setBlIssueblType("W");
        	blIssInfoVO.setIssued("Y");
        	blIssInfoVO.setReleased("Y");
        	blIssInfoVO.setInternetAuth("N");

            // 01. Flg 변경 BLIssuanceDBDAO::manageBlIssueFlg ( bkgNo , issueType )/manageBlIssueFlg ( [in] bkgNo : String , [in] issueType : String ) : void
            dbDao.manageBlIssueFlg(blIssInfoVO);

        } catch(EventException ee) {
            throw ee;
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }  
    
    /**
	 * e-Booking S/I upload 시 BL Ready 정보를 update 한다.
	 * 
	 * @param BlIssInfoVO blIssInfoVO
	 * @exception EventException
	 */
	public void modifyBlRdyInfo(BlIssInfoVO blIssInfoVO) throws EventException {

        try {
        	if (blIssInfoVO != null) {
        	dbDao.modifyBlRdyInfo(blIssInfoVO);
        	}
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

    }
	
	
    /**
     * 
     * Late SI,AES/CAED Notice를 전송한다.
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public List<BkgNtcHisVO> sendRmdEmail(DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
        List<BkgNtcHisVO> bkgNtcHisVOs = null;
        MailSendVO mailInfo = null;
        String retEmailSndId = null;
        StringTokenizer strNBkgNo = null;
        SimpleDateFormat format = null;
        BkgNtcHisVO bkgNtcHisVO = null;
        StringBuilder sbBlNos = null;
        String strBlNoTitle = null;
        String strBlNoBody = null;
        String title = null;
        String contentsParam = null;
        int cnt = 0;
        BookingUtil util = null;
		ComUserVO comUserVO = null;
        try {
            util = new BookingUtil();
			// 수정  account.getUsr_Eml() -> getDfltEml()
            comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			
            bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
            format = new SimpleDateFormat("yyyyMMddHHmmss");
            String senderMailAddr ="";

            int idx = 0;
            for (DblWblVO vo : dblWblVOs) {
                // Email 전송
                mailInfo = new MailSendVO();
				mailInfo.setSysCd("BKG");
				mailInfo.setBatchFlg("N");
				
				senderMailAddr = dbDao.searchFrontEmail(vo.getBkgNo());//group mail check
				
				if(senderMailAddr.equals("")){
					mailInfo.setSndNm(account.getUsr_nm());
				}else{
					mailInfo.setSndNm("");
				}
				//TO 에 FROM EMAIL 제거 
				mailInfo.setRcvEml(vo.getRcveml());
 				if (senderMailAddr.equals("")){
						mailInfo.setSndEml(sUsrEml);
				}else {
					mailInfo.setSndEml(senderMailAddr);
				}
				//from mail 값 셋
 				if(bkgEmlEdtVO != null && null != bkgEmlEdtVO.getEdtFromEml() && !"".equals(bkgEmlEdtVO.getEdtFromEml())){
					mailInfo.setSndEml(bkgEmlEdtVO.getEdtFromEml());
				}
				mailInfo.setCrtUserId(account.getUsr_id());
				
				if(bkgEmlEdtVO != null && null != bkgEmlEdtVO.getFileKey()){
					mailInfo.setFileKey(bkgEmlEdtVO.getFileKey());//0095
				} else{
					mailInfo.setFileKey("");//기존로직
				}
				
                //그룹메일인 경우에는 한번만 전송한다
				if (!"Y".equalsIgnoreCase(vo.getGrpFlag()) || ("Y".equalsIgnoreCase(vo.getGrpFlag()) && 0==idx++)) {
                	if ("Y".equalsIgnoreCase(vo.getGrpFlag())) {  //그룹메일인 경우
                		sbBlNos = new StringBuilder();
                		cnt = -1;
    					for (DblWblVO tmp : dblWblVOs) {
    						sbBlNos.append(tmp.getBlNo()).append(", ");
    						cnt++;
    					}
    					sbBlNos.delete(sbBlNos.lastIndexOf(","), sbBlNos.length());
						strBlNoTitle = vo.getBlNo()+" and "+cnt+" B/Ls";
						strBlNoBody = sbBlNos.toString();

                	} else {
						strBlNoTitle = strBlNoBody = vo.getBlNo();

                	}
                	//메일양식
//                	String vslNm = this.searchVesselNameByBkgNo(vo.getBkgNo());
                	SearchReminderEmailVO emailvo = dbDao.searchReminderEmail(vo.getBkgNo());

                	if (!StringUtils.isEmpty(vo.getTitle())) {
                		title = vo.getTitle();
                	} else {
                		StringBuilder titleSb = new StringBuilder("SM Line ");
                		if ("DR".equalsIgnoreCase(vo.getNtcKndCd())) {
                			titleSb.append("Doc cut-off Reminder");
                		} else if ("UR".equalsIgnoreCase(vo.getNtcKndCd())) {
                   			titleSb.append("AES/CAED Reminder");
                		}
    					titleSb.append(" (B/L No : ").append(strBlNoTitle).append(")");
                		title = titleSb.toString();
                	}
                	if ("DR".equalsIgnoreCase(vo.getNtcKndCd())) {
                		contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;"+strBlNoTitle +"@@blNoBody;"+strBlNoBody + "@@vslNm;"+emailvo.getVslNm()+"@@etd;"+emailvo.getEtdDt()+"@@date; "+emailvo.getDocClzDt()+"@@time; "+emailvo.getDocClzTm();
                	} else if ("UR".equalsIgnoreCase(vo.getNtcKndCd())) {
                		if("AES".equalsIgnoreCase(vo.getGubun())||"US".equalsIgnoreCase(emailvo.getCntCd())){
                			contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;"+strBlNoTitle +"@@blNoBody;"+strBlNoBody + "@@vslNm;"+emailvo.getVslNm()+"@@etd;"+emailvo.getEtdDt()+"@@date; "+emailvo.getDocClzDt()+"@@time; "+emailvo.getDocClzTm()+ "@@url;"+"http://www.smlines.com/hanjin/CUP_HOM_3058.do?sessLocale=en";
                		}else{
                			contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;"+strBlNoTitle +"@@blNoBody;"+strBlNoBody + "@@vslNm;"+emailvo.getVslNm()+"@@etd;"+emailvo.getEtdDt()+"@@date; "+emailvo.getDocClzDt()+"@@time; "+emailvo.getDocClzTm()+ "@@url;"+"http://www.smlines.com/hanjin/CUP_HOM_3252.do?sessLocale=en";
                		}
                		
            		}
					
//					contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : "+strBlNoTitle+"@@blNoBody;"+strBlNoBody;

                	
					mailInfo.setTitle(title); // 제목
    				mailInfo.setContents(contentsParam); // 내용
//					mailInfo.setCcEml(util.searchCcEmailAddrRSQL(vo.getNtcKndCd(), account.getUsr_id())+";"+senderMailAddr);
                    // Send Mail - *.mrd 파일 단건 보낼 시 1:1매칭
                    // 즉, *.mrd파일이 여러건일 경우 동일한 메일계정으로 *.mrd파일 수 만큼 송신이됨
                    retEmailSndId = bleaiDao.sendRmdEmail(mailInfo, bkgEmlEdtVO, vo.getNtcKndCd());

                }
                // Notice History Setting(History에는 bkg_no별로 남겨야 함)
                strNBkgNo = new StringTokenizer(vo.getBkgNo(), "|");  // 한  BL에 여러 BKG_NO가 올 경우 "|"로 구분하여 문자열로 넘어 온다고 가정하여 처리
                while (strNBkgNo.hasMoreTokens()) {
                    bkgNtcHisVO = new BkgNtcHisVO();
                    bkgNtcHisVO.setBkgNo(strNBkgNo.nextToken());
                    bkgNtcHisVO.setNtcViaCd("M");
                    bkgNtcHisVO.setNtcKndCd(vo.getNtcKndCd());  // 
                    bkgNtcHisVO.setAgnCd("");
                    bkgNtcHisVO.setNtcFomCd("");
                    bkgNtcHisVO.setNtcSeq("");
                    bkgNtcHisVO.setBkgCustTpCd("");
                    bkgNtcHisVO.setCustCntcTpCd("");
                    bkgNtcHisVO.setNtcEml(vo.getRcveml());
                    bkgNtcHisVO.setSndId(retEmailSndId);
                    bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
                    bkgNtcHisVO.setSndUsrId(account.getUsr_id());
                    bkgNtcHisVO.setSndRqstDt(format.format(new Date()));
                    bkgNtcHisVO.setDiffRmk("");
                    bkgNtcHisVO.setCreUsrId(account.getUsr_id());
                    bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
                    bkgNtcHisVOs.add(bkgNtcHisVO);
                }
            }
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return bkgNtcHisVOs;
    }
    
	/**
	 * Doc cut-off 및 AES/CAED Reminder관련 정보를 조회한다.
	 * 
	 * @param String bkg_no
	 * @return SearchReminderEmailVO
	 * @throws EventException
	 */
	public SearchReminderEmailVO searchReminderEmail(String bkg_no) throws EventException {
        try {
            return dbDao.searchReminderEmail(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
        
    
    /**
	 * DRAFT Remark를 구한다.
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
    public String searchDraftRemark(String bkgNo) throws EventException {
        try {
            return dbDao.searchDraftRemark(bkgNo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    
    
	/**
	 * Philips 계약인지 확인
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchPhilipsCheck(String bkgNo) throws EventException {
        try {
            return dbDao.searchPhilipsCheck(bkgNo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
	
	
    
    /**
     * @param N3ptyBlRqstVO n3ptyBlRqstVO
     * @return List<N3ptyBlRqstVO>
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public List<N3ptyBlRqstVO> searchN3ptyBlRqst(N3ptyBlRqstVO n3ptyBlRqstVO, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchN3ptyBlRqst(n3ptyBlRqstVO,account.getOfc_cd());  
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 3rd Party Billing & Issue Request데이터를 생성한다.
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void createN3ptyBlRqst(String bkgNo, SignOnUserAccount account) throws EventException{

    	String hisFlg = "N";

        try {        	
        	
        	List<N3ptyBlRqstVO> N3ptyBlRqstVOs = dbDao.searchN3ptyList(bkgNo);
        	if(N3ptyBlRqstVOs!=null && N3ptyBlRqstVOs.size()>0){
                for(int i = 0; i < N3ptyBlRqstVOs.size(); i++) {
                	int result = dbDao.createN3ptyBlRqst(N3ptyBlRqstVOs.get(i),account); 
                	if(result>0)
                		hisFlg = "Y";
                }
                
                if("Y".equals(hisFlg)){
                	BookingHistoryMgtDBDAO hisdao = new BookingHistoryMgtDBDAO();
	    			// bkg_his_mst의 다음 seq 조회
	    			String strHisSeq = hisdao.searchNextHistSeq(bkgNo);
	    			
	    			//-------------------------
	    			// add History Master
	    			//-------------------------
	    			BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
	    			bkgHisMstVO.setBkgNo(bkgNo);
	    			bkgHisMstVO.setHisSeq(strHisSeq);			
	    			bkgHisMstVO.setBkgHisIssUiId("ESM_BKG_9460");
	    			bkgHisMstVO.setCorrNo("");
    				bkgHisMstVO.setCreUsrId(account.getUsr_id());
    				bkgHisMstVO.setUpdUsrId(account.getUsr_id());

    				hisdao.addBkgHisMst(bkgHisMstVO);
	    						
	    			//-------------------------
	    			// add History Dtl Line
	    			//-------------------------		
	    			BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
	    			bkgHisDtlVO.setBkgNo    (bkgNo);
	    			bkgHisDtlVO.setHisSeq   (strHisSeq);
	    			//bkgHisDtlVO.setHisDtlSeq();  //query에서 계산
	    			//bkgHisDtlVO.setPreCtnt  ();  //사용않함 
	    			bkgHisDtlVO.setCrntCtnt ("Request has been created"); 
	    			bkgHisDtlVO.setPreCtnt  ("");
	    			bkgHisDtlVO.setHisCateNm("Request Creation");	
    				bkgHisDtlVO.setCreUsrId (account.getUsr_id());
    				bkgHisDtlVO.setUpdUsrId (account.getUsr_id());
    				hisdao.addBkgHisDtlLine(bkgHisDtlVO);  
	        	}
        	}
        	  
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }   





	/**
	 * 해당 사용자의 조회조건을 조회한다.<br>
	 * @param String userId
	 * @return List<BkgSrchSetVO>
	 * @throws EventException
	 */
	public List<BkgSrchSetVO> searchSrchSetForList(String userId) throws EventException{
		try {
			return dbDao.searchSrchSetForList(userId);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	
    /**
     * 3rd Party Billing & Issue Request데이터를 저장한다.
     * @param N3ptyBlRqstVO[] n3ptyBlRqstVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void modifyN3ptyBlRqst(N3ptyBlRqstVO[] n3ptyBlRqstVOs,SignOnUserAccount account) throws EventException {

        try {
            for (int i = 0; i < n3ptyBlRqstVOs.length; i++) {
            	if("Y".equals(n3ptyBlRqstVOs[i].getChgFlg())&&!"R".equals(n3ptyBlRqstVOs[i].getN3ptyBlStsCd())){
            		dbDao.modifyOtrBlRqst(n3ptyBlRqstVOs[i], account.getUsr_id());
            	}
            	dbDao.modifyN3ptyBlRqst(n3ptyBlRqstVOs[i], account.getUsr_id());
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    
    
    /**
     * approval과 reject결과를 메일로 전송한다.
     * @param N3ptyBlRqstVO n3ptyBlRqstVO
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void sendN3ptyBlRqst(N3ptyBlRqstVO n3ptyBlRqstVO, SignOnUserAccount account) throws EventException {
        try {
        	log.debug("@@@@@@ BCImpl : sendN3ptyBlRqst start");
        	if (n3ptyBlRqstVO != null) {
        		
        		//메일 발송
        		String sndId = bleaiDao.sendN3ptyBlRqst(n3ptyBlRqstVO,account);

        		//내역 기록
        		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
        		bkgNtcHisVO.setSndId(sndId);
    			bkgNtcHisVO.setBkgNo(n3ptyBlRqstVO.getBkgNo());
    			bkgNtcHisVO.setNtcViaCd("M"); // M = eMail
    			if("A".equals(n3ptyBlRqstVO.getN3ptyBlStsCd())){
    				bkgNtcHisVO.setNtcKndCd("BA"); // Billing request (approval)
    			}else{
    				bkgNtcHisVO.setNtcKndCd("BC"); // B/L Issue Request(WEB)
    			}
    			bkgNtcHisVO.setNtcEml(n3ptyBlRqstVO.getUsrEml());
    			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
    			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());

    			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
    			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
        		histDao.addBkgNtcHis(bkgNtcHisVO);
        		log.debug("@@@@@@ BCImpl : history log finish");
        	}				
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    
	/**
	 * BL Issue note list조회
	 * @param String bkgNo
	 * @return List<BkgMdtItmVO>
	 * @throws EventException
	 */
	public List<BkgMdtItmVO> searchBlIssNote(String bkgNo) throws EventException{
		List<BkgMdtItmVO> list = null;
		
        try {
        	list = dbDao.searchBlIssNote(bkgNo);  
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }		
		return list;
	}
	
	
	/**
	 * 3rd party request관련 생성된 request당 파일 목록을 조회한다.
	 * @param BlAtchVO blAtchVO
	 * @return List<BlAtchVO>
	 * @throws EventException
	 */
	public List<BlAtchVO> searchBlAtchList(BlAtchVO blAtchVO) throws EventException {
		List<BlAtchVO> list = null;
		try {
			list = dbDao.searchBlAtchList(blAtchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		return list;
	}
	
	
	/**
	 * 3rd party request관련 생성된 request당 파일 목록을 저장한다.
	 * @param BlAtchVO[] blAtchVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBlAtch(BlAtchVO[] blAtchVOs, SignOnUserAccount account) throws EventException {
		String use_id = account.getUsr_id();// user id

		try {
			List<BlAtchVO> insertVoList = new ArrayList<BlAtchVO>();
			List<BlAtchVO> deleteVoList = new ArrayList<BlAtchVO>();
			List<BlAtchVO> updateVoList = new ArrayList<BlAtchVO>();
			for (int i = 0; i < blAtchVOs.length; i++) {

				if (blAtchVOs[i].getIbflag().equals("U")) {
					deleteVoList.add(blAtchVOs[i]);
					blAtchVOs[i].setIbflag("I");
				}

				if (blAtchVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(blAtchVOs[i]);
					UpdateFileMetaInfo.delete(blAtchVOs[i].getFileSavId());

				} else if (blAtchVOs[i].getIbflag().equals("I")) {
					blAtchVOs[i].setCreUsrId(use_id);
					blAtchVOs[i].setUpdUsrId(use_id);

					blAtchVOs[i].setFileSavId(blAtchVOs[i].getKeys());
					insertVoList.add(blAtchVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeBlAtch(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addBlAtch(insertVoList);
				// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
				updateVoList.add(blAtchVOs[0]);
				dbDao.modifyBlAtch(updateVoList);
			}

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
	}
	
	/**
	 * Bl Certi Requset 목록을 조회한다.
	 * @param BlCertiRqstVO blCertiRqstVO
	 * @return List<BlCertiRqstVO>
	 * @throws EventException
	 */
	public List<BlCertiRqstVO> searchBlCertiRqst(BlCertiRqstVO blCertiRqstVO) throws EventException {
		List<BlCertiRqstVO> list = null;
		try {
			list = dbDao.searchBlCertiRqst(blCertiRqstVO); 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		return list; 
	}
	
	
	
    /**
     * BL certi Status 를 수정(ESM_BKG_9464)
     * @param BlCertiRqstVO blCertiRqstVO
     * @throws EventException
     */
    public void manageBlCertiSts(BlCertiRqstVO blCertiRqstVO) throws EventException{		
        try {
        	dbDao.manageBlCertiSts(blCertiRqstVO);           
        	
        	BookingHistoryMgtDBDAO hisdao = new BookingHistoryMgtDBDAO();
			// bkg_his_mst의 다음 seq 조회
			String strHisSeq = hisdao.searchNextHistSeq(blCertiRqstVO.getBlNo());
			
			//-------------------------
			// add History Master
			//-------------------------
			BkgHisMstVO bkgHisMstVO = new BkgHisMstVO();
			bkgHisMstVO.setBkgNo(blCertiRqstVO.getBlNo());
			bkgHisMstVO.setHisSeq(strHisSeq);			
			bkgHisMstVO.setBkgHisIssUiId("ESM_BKG_9464");
			bkgHisMstVO.setCorrNo("");
			bkgHisMstVO.setCreUsrId(blCertiRqstVO.getUpdUsrId());
			bkgHisMstVO.setUpdUsrId(blCertiRqstVO.getUpdUsrId());

			hisdao.addBkgHisMst(bkgHisMstVO);
						
			//-------------------------
			// add History Dtl Line
			//-------------------------		
			BkgHisDtlVO bkgHisDtlVO = new BkgHisDtlVO();
			bkgHisDtlVO.setBkgNo    (blCertiRqstVO.getBlNo());
			bkgHisDtlVO.setHisSeq   (strHisSeq);
			//bkgHisDtlVO.setHisDtlSeq();  //query에서 계산
			//bkgHisDtlVO.setPreCtnt  ();  //사용않함 
			if("A".equals(blCertiRqstVO.getBlCertiStsCd())){
				bkgHisDtlVO.setCrntCtnt ("Request has been approved"); 
			}else if("X".equals(blCertiRqstVO.getBlCertiStsCd())){
				bkgHisDtlVO.setCrntCtnt ("Request has been rejected"); 
			}
			
			bkgHisDtlVO.setPreCtnt  ("");
			bkgHisDtlVO.setHisCateNm("Creation");	
			bkgHisDtlVO.setCreUsrId (blCertiRqstVO.getUpdUsrId());
			bkgHisDtlVO.setUpdUsrId (blCertiRqstVO.getUpdUsrId());
			hisdao.addBkgHisDtlLine(bkgHisDtlVO);  
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
        }
    }
    
    
    /** BL Certi Print flag를 업데이트한다.
     * @param BlCertiRqstVO[] blCertiRqstVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageBlCertiPrn(BlCertiRqstVO[] blCertiRqstVOs, SignOnUserAccount account) throws EventException {
        try {
        	if (blCertiRqstVOs != null) {
				for(int i=0; i<blCertiRqstVOs.length; i++){
					dbDao.manageBlCertiPrn(blCertiRqstVOs[i], account.getUsr_id());
				}
        	}				
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	
    /**
     * Web OB/L Paper Management를 조회
     * @param BkgCustBlPprMgmtVO blPprMgmtVO
     * @return List<BlPprMgmtVO>
     * @throws EventException
     */
    public List<BkgCustBlPprMgmtVO> searchBlPprMgmt(BkgCustBlPprMgmtVO blPprMgmtVO) throws EventException {
        try {
        	if("1".equals(blPprMgmtVO.getRocDiv())){
        		return dbDao.searchBlPprMgmtTtl(blPprMgmtVO);  
        	}else{
        		return dbDao.searchBlPprMgmt(blPprMgmtVO);  
        	}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * Web OB/L Paper Management를 저장
	 * @param BkgCustBlPprMgmtVO[] blPprMgmtVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBlPprMgmt(BkgCustBlPprMgmtVO[] blPprMgmtVOs, SignOnUserAccount account) throws EventException {

		try {
			if(blPprMgmtVOs!=null && blPprMgmtVOs.length>0){
				for(int i=0; i<blPprMgmtVOs.length; i++) {
					BkgCustBlPprMgmtHisVO hisvo = new BkgCustBlPprMgmtHisVO();
					hisvo.setDtrbYr(blPprMgmtVOs[i].getDtrbYr());
					hisvo.setRhqCd(blPprMgmtVOs[i].getRhqCd());
					hisvo.setOfcCd(blPprMgmtVOs[i].getOfcCd());
					hisvo.setCustCntCd(blPprMgmtVOs[i].getCustCntCd());
					hisvo.setCustSeq(blPprMgmtVOs[i].getCustSeq());
					
					if (blPprMgmtVOs[i].getIbflag().equals("I")) {
						dbDao.addBlPprMgmt(blPprMgmtVOs[i],account);	
						hisvo.setCrntCtnt(blPprMgmtVOs[i].getCustDtrbKnt());
		
					}else if (blPprMgmtVOs[i].getIbflag().equals("D")) {
						BkgCustBlPprMgmtVO oldvo = dbDao.searchOldBlPprMgmt(blPprMgmtVOs[i]);
						dbDao.removeBlPprMgmt(blPprMgmtVOs[i],account);	
						hisvo.setPreCtnt(oldvo.getCustDtrbKnt());
						
					}else if (blPprMgmtVOs[i].getIbflag().equals("U")) {
						BkgCustBlPprMgmtVO oldvo = dbDao.searchOldBlPprMgmt(blPprMgmtVOs[i]);
						dbDao.modifyBlPprMgmt(blPprMgmtVOs[i],account);
						
						hisvo.setPreCtnt(oldvo.getCustDtrbKnt());
						hisvo.setCrntCtnt(blPprMgmtVOs[i].getCustDtrbKnt());
						
					}

					dbDao.addBlPprMgmtHis(hisvo,account);
				}
			}

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
	}
	
	
    /**
     * Web OB/L Paper Management화면의 정보를 저장시 중복된 값이 있는지 체크한다.
     * @param BkgCustBlPprMgmtVO blPprMgmtVO
     * @return String
     * @throws EventException
     */
    public String checkBlPprMgmt(BkgCustBlPprMgmtVO blPprMgmtVO) throws EventException {
        try {
            return dbDao.checkBlPprMgmt(blPprMgmtVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    
    
    /**
     * OBL 용지배부내역 히스토리을 조회한다.(ESM_BKG_9468)
     * @param BkgCustBlPprMgmtHisVO blPprMgmtHisVO
     * @return List<BkgCustBlPprMgmtHisVO>
     * @throws EventException
     */
    public List<BkgCustBlPprMgmtHisVO> searchBlPprMgmtHis(BkgCustBlPprMgmtHisVO blPprMgmtHisVO) throws EventException {
        try {
        	return dbDao.searchBlPprMgmtHis(blPprMgmtHisVO);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * CA Confirm시 Charge 데이터가 달라졌는지 체크한다.
     * @param String bkgNo
     * @return String
     * @throws DAOException
     */
    public String checkDiffChargeData(String bkgNo) throws EventException {
        try {
            return dbDao.checkDiffChargeData(bkgNo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
   	 * BL Data Complete update한다.<br>
   	 * @param BlIssInfoVO[] blIssInfoVOs
   	 * @exception DAOException
   	 */
    public void updateBLComplete(BlIssInfoVO[] blIssInfoVOs) throws EventException {
        try {
        	for(int i=0;i<blIssInfoVOs.length;i++){
        		dbDao.updateBLComplete(blIssInfoVOs[i]);
        	}
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 이메일 보내기
     * @param DblWblVO[] dblWblVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public List<BkgNtcHisVO> sendBLByEmailForSamsung (DblWblVO[] dblWblVOs, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException {
    	List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
    	BkgNtcHisVO bkgNtcHisVO = null;
    	DblWblVO dblWblVO = null;
    	try {
			for(int i=0;i<dblWblVOs.length;i++){
				dblWblVO = new DblWblVO();
				dblWblVO.setBkgNo(dblWblVOs[i].getBkgNo());
				dblWblVO.setBlNo(dblWblVOs[i].getBlNo());
				dblWblVO.setBkgStsCd("BKG");
				dblWblVO.setTmplmrd(dblWblVOs[i].getTmplmrd());
				dblWblVO.setBatchflg("N");
				//dblWblVO.setTitle("prealert:DR4E:SMLM"+dblWblVOs[i].getBkgNo());
				
				/* 우방과 합병으로 인해 사업자번호 변경에따른 삼성전자 EDI 식별자 변경 */
//				dblWblVO.setTitle("SWBUPLOAD:DZEV:");
				dblWblVO.setTitle("SWBUPLOAD:E04S:");
				
				dblWblVO.setTmplparam(dblWblVOs[i].getTmplparam());
				dblWblVO.setSndnm(account.getUsr_nm());
				dblWblVO.setSndeml("noreply@smlines.com");
				dblWblVO.setRcveml(dblWblVOs[i].getRcveml());
				
				String sendId = bleaiDao.sendRDEmail(dblWblVO, bkgEmlEdtVO, account);
				
				//history
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(dblWblVOs[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("BL");
				bkgNtcHisVO.setAgnCd("");
                bkgNtcHisVO.setNtcFomCd("");
                bkgNtcHisVO.setNtcSeq("");
                bkgNtcHisVO.setBkgCustTpCd("");
                bkgNtcHisVO.setCustCntcTpCd("");
                bkgNtcHisVO.setNtcEml(dblWblVO.getRcveml());
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId("SYSTEM");
				bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
    	
    	return bkgNtcHisVOs;
    }
    
    /**
     * 조건과 맞다면 bl issue시에 이메일과 함께 BL PDF파일이 전송
     * @param String bkgNo
     * @return String
     * @throws DAOException
     */
    public String checkAutoEmailWithBLForSamsung(String bkgNo) throws EventException {
        try {
            return dbDao.checkAutoEmailWithBLForSamsung(bkgNo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

}


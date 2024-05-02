/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtBC.java
*@FileTitle : Booking_History_Mgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.11 김영출
* 1.0 Creation
* ------------------------------------------------------
* History
* 2011.12.06 김종호 [CHM-201114075] [Homepage Renewal] EAI-Webservice I/F 개발 (AES NO Input)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgInetBlPrnAuthVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHisDtlVO;
import com.hanjin.syscommon.common.table.BkgHisMstVO;
import com.hanjin.syscommon.common.table.BkgMfCstmsHisVO;
import com.hanjin.syscommon.common.table.BkgNonDgCgoTgtIfVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * NIS2010-Bookingcommon Business Logic Command Interface<br>
 * - NIS2010-Bookingcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Youngchul
 * @see Booking_history_mgtEventResponse 참조
 * @since J2EE 1.4
 */

public interface BookingHistoryMgtBC {
	/**
	 * Booking Cancel <br> 
	 * 취소에 관련된 정보를 처리한다<br>
	 *
	 * @author Lee NamKyung
	 * @param  String bkgDocProcTpCd
	 * @param  String bkgNo
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBkgDocProcSkd( String bkgDocProcTpCd, String bkgNo, SignOnUserAccount account) throws EventException;
	
	/**
     * Booking의 Notice 관련 생성/변경에 대해 History를 기록한다.
     * 
     * @param List<BkgNtcHisVO> ntcHis
     * @param String uiId
     * @exception EventException
     */
    public void createBkgNtcHis(List<BkgNtcHisVO> ntcHis, String uiId) throws EventException;
    
    /**
	 * Booking History : Old Data Search<br> 
	 * 변견 전 data를 조회한다<br>
	 * 조회결과가 manageBookingHistory()에 전달된다.<br>
	 *
	 * @author Lee NamKyung
	 * @param  String uiId
     * @param  BkgBlNoVO bkgBlNoVO
	 * @return HistoryTableVO
	 * @exception EventException
	 */
	public HistoryTableVO searchOldBkgForHistory(String uiId, BkgBlNoVO bkgBlNoVO) throws EventException;
		
	/**
	 * Booking History : Change/New Data Store<br> 
	 * 변경 전/후 값을 비교하여 실제 보여질 history를 만든다<br>
	 *
	 * @author Lee NamKyung
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBookingHistory(String uiId, HistoryTableVO historyTableVO, SignOnUserAccount account) throws EventException;


	/**
	 * Booking History : Change/New Data Store<br> 
	 * 변경 전/후 값을 비교하여 실제 보여질 history를 만든다<br>
	 * EAI I/F WEB006 용 메소드 (account정보가 없기 때문에 복제 생성)<br>
	 * @author Kim Jong ho
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  String webId
	 * @param  String porCd
	 * @exception EventException
	 */
	public void eaiManageBookingHistory(String uiId, HistoryTableVO historyTableVO, String webId, String porCd) throws EventException;
	
	
	/**
	 * Booking Line History를 생성한다<br> 
	 *
	 * @author Lee NamKyung
	 * @param  HistoryLineVO historyLineVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBkgHistoryLine(HistoryLineVO historyLineVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 세관 신고 이력을 생성한다.<br> 
	 *
	 * @author Lee NamKyung
	 * @param  BkgMfCstmsHisVO bkgMfCstmsHisVO
	 * @exception EventException
	 */
	public void createCustomsHistory(BkgMfCstmsHisVO bkgMfCstmsHisVO) throws EventException;
	
	/**
	 * Booking History : manageDocProcess<br> 
	 * bkg별 주요 event에 대한 history를 생성한다<br> 
	 *
	 * @author Lee NamKyung
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageDocProcess(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException;

	/**
	 * Booking History : manageDocProcFlag<br> 
	 * bkg별 주요 event에 대한 Flag를 관리한다<br> 
	 *
	 * @author Ryu Dae Young
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocProcFlag(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking History : releaseCntrFinalConfirm<br> 
	 * container confirm 이력을 생성한다.<br>
	 *
	 * @author Ryu Dae Young
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void releaseCntrFinalConfirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking History : Temp History Data 일괄삭제 <br> 
	 * c/a cancel시 실행됨<br>
	 *
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @exception EventException
	 */
	public void removeTmpHistory(BkgBlNoVO vo) throws EventException;
	
	/**
	 * Booking History : C/A No Update<br>
	 * c/a confirm시 실행됨<br>
	 * 
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @exception EventException
	 */
	public void modifyCaCorrNoForHistory(BkgBlNoVO vo) throws EventException;
	
	/**
	 * MQ 연동 처리(UBIZHJS_ALPSBKG_USTMNL_ACK)<br>
	 * 미주 terminal edi 수신 이력<br>
	 * 
	 * @author 		Jun Yong Jin
	 * @param 		String rcvMsg
	 * @exception 	EventException
	 */
	public void receiptUsaTmlEdiAck(String rcvMsg) throws EventException ;

	/**
	 * 한국세관 BOOKING HISTORY 추가<br>
	 * 범용으로 사용가능<br>
	 * 
	 * @param BkgHisMstVO bkgHisMstVO
	 * @param BkgHisDtlVO bkgHisDtlVO
	 * @throws EventException
	 */
	public void createBkgHisMst(BkgHisMstVO bkgHisMstVO, BkgHisDtlVO bkgHisDtlVO) throws EventException;

	/**
	 * Split source booking의 history의 correction no를 변경한다<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String lstCorrNo
	 * @throws EventException
	 */
	public void modifyCorrNo(BkgBlNoVO bkgBlNoVO, String lstCorrNo) throws EventException;
	
	/**
	 * Booking History : Change/New Data Store<br> 
	 * 변경 전/후 값을 비교하여 실제 보여질 history 를 만든다<br>
	 *
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCtmMvmtIrrFlg(String uiId, HistoryTableVO historyTableVO, SignOnUserAccount account) throws EventException;

	/**
	 * bkg별 주요 AI event에 대한 Flag를 관리한다<br> 
	 *
	 * @author Jong Yun Kyoung
	 * @param  String mfNo
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @exception EventException
	 */
	public void manageDocProcAIFlag(String mfNo, BkgDocProcSkdVO bkgDocProcSkdVO) throws EventException;
	
	
	/**
	 * BKG_NON_DG_CGO_TGT_IF 에 BKG정보를 등록한다.
	 * @param bkgNonDgCgoTgtIfVO
	 * @throws EventException
	 */
	public void createNonDgCgoTgt(BkgNonDgCgoTgtIfVO bkgNonDgCgoTgtIfVO) throws EventException;
	
	/**
	 * SCG인터페이스 푸 인터페이스 플래그를 Y로 변경
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String asFlg
	 * @param String toFlg
	 * @throws EventException
	 */
	public void modifyNonDgCgoTgt(String bkgNo, String cntrNo, String asFlg, String toFlg) throws EventException;
	
	/**
	 * container 화면에서 container a가 b로 바로변경 되었을 때 BKG_DOC_PROC_SKD테이블에서 업데이트
	 * @param BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBkgDocProcSkdForCntatc(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * C/A를 위해 해당 bkg의 table들을 복사한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String copyTypeCd
	 * @throws EventException
	 */
	public void createHisCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
	
	/**
	 * C/A를 위해 HIS 관련 table을 삭제한다.
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException;
	
    /**
     * BKG history유무를 조회한다.
     * @param BkgBlNoVO bkgBlNoVO
     * @param String uiId
     * @return String
     * @throws EventException
     */
	public String searchBkgHistory(BkgBlNoVO bkgBlNoVO, String uiId) throws EventException;
	
	/**
	 * 
	 * @param oldBl
	 * @param bkgNo
	 * @param uiId
	 * @param account
	 * @throws EventException
	 */
	public void bkgInetBlOblSerNoHistory(List<BkgInetBlPrnAuthVO> oldBl, String bkgNo, String uiId, SignOnUserAccount account) throws EventException;
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtBC.java
*@FileTitle : Booking_History_Mgt
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgHisDtlVO;
import com.clt.syscommon.common.table.BkgHisMstVO;
import com.clt.syscommon.common.table.BkgMfCstmsHisVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * 2010-Bookingcommon Business Logic Command Interface<br>
 * - 2010-Bookingcommon biz Logic Interface<br>
 *
 * @author CLT
 * @see Booking_history_mgtEventResponse reference
 * @since J2EE 1.4
 */

public interface BookingHistoryMgtBC {
	/**
	 * Booking Cancel <br> 
	 *
	 * @param  String bkgDocProcTpCd
	 * @param  String bkgNo
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBkgDocProcSkd( String bkgDocProcTpCd, String bkgNo, SignOnUserAccount account) throws EventException;
	
	/**
     * Creating the History of the Notice
     * 
     * @param List<BkgNtcHisVO> ntcHis
     * @param String uiId
     * @exception EventException
     */
    public void createBkgNtcHis(List<BkgNtcHisVO> ntcHis, String uiId) throws EventException;
    
    /**
	 * Booking History : Old Data Search<br> 
	 *
	 * @param  String uiId
     * @param  BkgBlNoVO bkgBlNoVO
	 * @return HistoryTableVO
	 * @exception EventException
	 */
	public HistoryTableVO searchOldBkgForHistory(String uiId, BkgBlNoVO bkgBlNoVO) throws EventException;
		
	/**
	 * Booking History : Change/New Data Store<br> 
	 *
	 * @param  String uiId
	 * @param  HistoryTableVO historyTableVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBookingHistory(String uiId, HistoryTableVO historyTableVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Creating the Booking Line History<br> 
	 *
	 * @param  HistoryLineVO historyLineVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void createBkgHistoryLine(HistoryLineVO historyLineVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param historyLineVO
	 * @param title
	 * @param message
	 * @param account
	 * @throws EventException
	 */
	public void createBkgHistoryLine(HistoryLineVO historyLineVO, String title, String message,SignOnUserAccount account) throws EventException;
	
	/**
	 * Creating the Customs Manifest History<br> 
	 *
	 * @param  BkgMfCstmsHisVO bkgMfCstmsHisVO
	 * @exception EventException
	 */
	public void createCustomsHistory(BkgMfCstmsHisVO bkgMfCstmsHisVO) throws EventException;
	
	/**
	 * Booking History : manageDocProcess<br> 
	 *
	 * @param  BkgDocProcSkdVO bkgDocProcSkdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageDocProcess(BkgDocProcSkdVO bkgDocProcSkdVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * Booking History : releaseCntrFinalConfirm<br> 
	 *
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void releaseCntrFinalConfirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking History : Temp History Data Remove all <br> 
	 *
	 * @param  BkgBlNoVO vo
	 * @exception EventException
	 */
	public void removeTmpHistory(BkgBlNoVO vo) throws EventException;
	
	/**
	 * Booking History : C/A No Update<br>
	 * 
	 * @param  BkgBlNoVO vo
	 * @exception EventException
	 */
	public void modifyCaCorrNoForHistory(BkgBlNoVO vo) throws EventException;
	
	/**
	 * MQ Interworking (UBIZ_BKG_USTMNL_ACK)<br>
	 * 
	 * @param 		String rcvMsg
	 * @exception 	EventException
	 */
	public void receiptUsaTmlEdiAck(String rcvMsg) throws EventException ;

	/**
	 * Creating the KOREA BOOKING HISTORY<br>
	 * 
	 * @param BkgHisMstVO bkgHisMstVO
	 * @param BkgHisDtlVO bkgHisDtlVO
	 * @throws EventException
	 */
	public void createBkgHisMst(BkgHisMstVO bkgHisMstVO, BkgHisDtlVO bkgHisDtlVO) throws EventException;
	
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
	 * Split source booking의 history의 correction no를 변경한다<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String lstCorrNo
	 * @throws EventException
	 */
	public void modifyCorrNo(BkgBlNoVO bkgBlNoVO, String lstCorrNo) throws EventException;
	
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
	 * Booking History : search VVD change data<br> 
	 * VVD 변경 전/후 값을 비교하여 실제 보여질 data를 조회한다.<br>
	 * @param HistoryTableVO oldHistoryTableVO
	 * @return List<HistCtntVO>
	 * @exception EventException
	 */
	public List<HistCtntVO> searchChangeVVDHistory(HistoryTableVO oldHistoryTableVO) throws EventException;
	
	/**
	 * 
	 * @param historyLineVO
	 * @param account
	 * @throws EventException
	 */
	public void createdAmsAi(HistoryLineVO historyLineVO, SignOnUserAccount account) throws EventException;
	
}
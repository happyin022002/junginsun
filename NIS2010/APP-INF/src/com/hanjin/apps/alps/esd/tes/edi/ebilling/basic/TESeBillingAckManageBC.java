/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingAckManageBC.java
*@FileTitle : TES eBilling EDI 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-01-22 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiAckSndLogVO;
import com.hanjin.syscommon.common.table.TesEdiAckSndLogInvVO;
import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiSndAckMnRuleVO;


/**
 * ALPS-ESD Business Logic Command Interface<br>
 * - ALPS-ESD에 대한 비지니스 로직에 대한 인터페이스<br> 
 *
 * @author 
 * @see TESInterfaceEventResponse 참조
 * @since J2EE 1.4
 */
public interface TESeBillingAckManageBC  {
	
	static final String CHR10 = "\n";
	static final String ACK_ACT_TP_CD     	= "ACK_ACT_TP_CD";
	static final String ACK_ACT_TP_BATCH   	= "B";
	static final String ACK_ACT_TP_EDI     	= "E";
	static final String ACK_SND_RULE    	= "ACK_SND_RULE";
	static final String ACK_SND_LOG      	= "ACK_SND_LOG";
	static final String ACK_SND_INV_LST     = "ACK_SND_INV_LST";
	static final String ACK_FLT_FILES		= "ACK_FLT_FILES";
	static final String ACK_SND_VOS			= "ACK_SND_VOS";
	
	/**
	 * ACK 대상 EDI invoice 대상 초기화
	 * @param eventResponse
	 * @throws EventException
	 */
	public void initSendAckEdiInv(EventResponse eventResponse) throws EventException;

	/**
	 * ACK 대상 EDI invoice 대상 추출 및 F/F 조합
	 * @param eventResponse
	 * @throws EventException
	 */
	public void makeFFAckEdiInv(EventResponse eventResponse) throws EventException;
	
	/**
	 * ACK 대상 EDI invoice 대상 전송
	 * @param eventResponse
	 * @throws EventException
	 */
	public void sendAckEdiInv(EventResponse eventResponse) throws EventException;

	/**
	 * ACK 전송 규칙 정보 조회
	 * @param ack_act_tp_cd
	 * @return List<TesEdiSndAckMnRuleVO>
	 * @throws EventException
	 */
	public List<TesEdiSndAckMnRuleVO> getAckSendAckMainRule(String ack_act_tp_cd) throws EventException;
	
	/**
	 * 주어진 ofc에 해당하는 EDI로 전송할 날짜 구하기
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getDtStr(String ofc_cd) throws EventException;

	/**
	 * ACK LOG용 주 sequence 구하기
	 * @return String
	 * @throws EventException
	 */
	public String getAckSendSeq() throws EventException;

	/**
	 * (HIT/YICT) ACK전문의 FILE sequence 구하기
	 * @return String
	 * @throws EventException
	 */
	public String getAckFileSeq() throws EventException;

	/**
	 * ACK 대상 EDI invoice 대상 조회
	 * @param ackEdiSndAckMainRuleVO
	 * @return List<TesEdiSoHdrVO>
	 * @throws EventException
	 */
	public List<TesEdiSoHdrVO> getAckEdiInvList(TesEdiSndAckMnRuleVO ackEdiSndAckMainRuleVO) throws EventException;

	/**
	 * ACK 대상 EDI invoice 대상 조회
	 * @param tesEdiAckSndLogVO
	 * @return List<TesEdiSoHdrVO>
	 * @throws EventException
	 */
	public List<TesEdiSoHdrVO> getAckFFLogInvList(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException;

	/**
	 * ACK SEND F/F 생성 대상 EDI invoice 목록 조회 
	 * @param tesEdiSndAckMainRuleVO
	 * @return List<ComTesEdiAckSndLogVO>
	 * @throws EventException
	 */
	public List<ComTesEdiAckSndLogVO> getAckFFLogList(TesEdiSndAckMnRuleVO tesEdiSndAckMainRuleVO) throws EventException;
	
	/**
	 * ACK 대상 EDI invoice 대상 초기화
	 * @param ackSndLogVO
	 * @param ediInvLst
	 * @throws EventException
	 */
	public void saveAckEdiInv(ComTesEdiAckSndLogVO ackSndLogVO, List<TesEdiAckSndLogInvVO> ediInvLst) throws EventException;
	
	/**
	 * ACK 대상 전송 전 DB에서의 전송 대기 가능(ERROR나 CANCEL된게 아닌지) 상태를 확인한다.
	 * @param tesEdiAckSndLogVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAckEDILogB4Send(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException;

	/**
	 * ACK 전송 후 완료 표시하기
	 * @param tesEdiAckSndLogVO
	 * @throws EventException
	 */
	public void completeAckEdiSndLogSts(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException;

	/**
	 * Error log로 남기기
	 * @param tesEdiAckSndLogVO
	 * @throws EventException
	 */
	public void logAckEDIErrMsg(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException;
	
	/**
	 * EDI 공용 Error log로 남기기
	 * @param tesEdiErrLogVO
	 * @throws EventException
	 */
	public void logAckCommErrMsg(TesEdiSoErrLogVO tesEdiErrLogVO) throws EventException;
	
}
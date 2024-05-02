/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSMSendBC.java
*@FileTitle : CSM (Container Status Message) 미세관 전송 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-02-05
*@LastModifier : Kim In-soo
*@LastVersion : 1.0
* 1.0 최초 생성   
* 
* 2009-03-04 iskim
* 	(1) R200903040003	2월 소스품질 검토 결과 follow-up
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.basic;


import com.clt.apps.opus.esd.sce.csmsend.vo.CSMSendVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * SCEM Business Logic Command Interface<br>
 * - SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author 2002701
 * @see
 * @since J2EE 1.4
 */
public interface CSMSendBC  {
		
	/**
	 * 불필요한 것으로 판단된 movement target data 를 삭제한다.
	 * (booking 정보가 없어서 미주 행인지 판단 못한 건을 차후 판단시 미주가 아니라고 판단되면 삭제)
	 * @param CSMSendVO cSMSendVO
	 * @throws EventException
	 */
	public void deleteCSMTarget(CSMSendVO cSMSendVO) throws EventException ;

	/**
	 * movement 발생 건 별로 flat file 을 생성한다.
	 * @param CSMSendVO cSMSendVO
	 * @return int
	 * @throws EventException
	 */
	public int insertFlatFile(CSMSendVO cSMSendVO) throws EventException ;
	

	/**
	 * 미 전송건 전부 QUEUE 로 전송
	 * @throws EventException
	 */
	public void sendFlatFileIntoQueue() throws EventException;
	
	/**
	 * parameter 에 해당 되는 전송 성공 log 가 존재하는 지를 확인한다.
	 * 존재한다면 해당 전송은 skip 된다.
	 * @param sendVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchDupSndRslt(CSMSendVO sendVO) throws EventException ;
	
	/**
	 * movement data 의 처리 결과를 update 한다.
	 * 99 : 정상 발생, queue 전송 완료
	 * XX : process 진행 중
	 * @param act_rcv_dt
	 * @param act_rcv_no
	 * @param act_umch_tp_cd
	 * @throws EventException
	 */
	public void updateActUmchTpCd(String act_rcv_dt, String act_rcv_no, String act_umch_tp_cd) throws EventException;
	
	/**
	 * movement data 의 처리 결과를 update 한다.
	 * 99 : 정상 발생, queue 전송 완료
	 * XX : process 진행 중
	 * @param sendVO
	 * @throws EventException
	 */
	public void updateActUmchTpCd(CSMSendVO sendVO)throws EventException;
	
	/**
	 * booking 정보가 없어서 미주 행인지 판단 못한 건을 차후 판단
	 * @param cSMSendVO
	 * @return String
	 * @throws EventException
	 */
	public String searchBkgBound(CSMSendVO cSMSendVO) throws EventException; 
	
	/**
	 * Empty container movement 를 대상으로 해당 mvmt 에 딸린 bkg 의 vvd 중 pod /del 도착까지 미주를 경유하는지 조회하여
	 * 대상이면 SCE_CNTR_STS_MSG_TGT 에 insert
	 * @return int
	 * @throws EventException
	 */
	public int addCSMSendTargetEmptyCntr() throws EventException;
}
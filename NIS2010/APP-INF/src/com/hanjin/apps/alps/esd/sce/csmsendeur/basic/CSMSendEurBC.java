/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurBC.java
*@FileTitle : CSM (Container Status Message) 구주세관 전송 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-15
*@LastModifier :
*@LastVersion : 1.0
* 1.0 최초 생성   
=========================================================*/
package com.hanjin.apps.alps.esd.sce.csmsendeur.basic;


import com.hanjin.apps.alps.esd.sce.csmsendeur.vo.CSMSendEurVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * SCEM Business Logic Command Interface<br>
 *  -SCEM에 대한 비지니스 로직에 대한 인터페이스<br>
 * @author 2002701
 * @see
 * @since J2EE 1.4
 */
public interface CSMSendEurBC  {
			
	/**
	 * Movement 발생 건 별로 Flat File 을 생성한다.
	 * @param CSMSendEurVO cSMSendEurVO
	 * @return int
	 * @throws EventException
	 */
	public int insertFlatFile(CSMSendEurVO cSMSendEurVO) throws EventException ;

	/**
	 * 미 전송 건 전부 QUEUE 로 전송
	 * @param CSMSendEurVO cSMSendEurVO
	 * @throws EventException
	 */
	public void sendFlatFileIntoQueue(CSMSendEurVO cSMSendEurVO) throws EventException;
	
	/**
	 * Parameter 에 해당 되는 전송 성공 log 가 존재하는 지를 확인한다.
	 * 존재한다면 해당 전송은 skip 된다.
	 * @param CSMSendEurVO cSMSendEurVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean searchDupSndRslt(CSMSendEurVO cSMSendEurVO) throws EventException ;
		
	/**
	 * Movement Data 의 처리 결과를 Update 한다.
	 * 99 : 정상 발생, queue 전송 완료
	 * XX : process 진행 중
	 * @param CSMSendEurVO cSMSendEurVO
	 * @throws EventException
	 */
	public void updateActUmchTpCd(CSMSendEurVO cSMSendEurVO)throws EventException;
	
}
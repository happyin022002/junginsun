/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PsoAdvanceAuditBC   
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청

=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditBatchVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditCreSetVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ROUTUnMatmanageBC PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface PsoAdvanceAuditBC {
	/**
	 * Port (Service) Charge 조회.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPreAuditList(Event e) throws EventException;
	/**
	 * Port (Service) Charge 조회.
	 * 
	 * @category EDS_EAS_0301
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPreAuditList2(Event e) throws EventException;
	/**
	 * Port (Service) Charge - Confirm - DB에 반영한다.(변경)
	 * 
	 * @category EDS_EAS_0301
	 * @param e EDS_EAS_0301Event
	 * @param account SignOnUserAccount
	 * @return EventResponse EDS_EAS_0301EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAutoAuditFlg(Event e, SignOnUserAccount account) throws EventException;	
	/**
	 * Port (Service) Charge에 관련 Account를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgAccount(Event e) throws EventException;
	/**
	 * Port (Service) Charge에 관련 Cost를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgCost(Event e) throws EventException;
	/**
	 * S/P No. name 조회.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return String
	 * @throws EventException
	 */
	public String searchAuditFlgSpName(Event e) throws EventException;
	/**
	 * Port (Service) Charge에 관련 VesselClass를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgVslClass(Event e) throws EventException;
	/**
	 * Port (Service) Charge에 관련 VesselClass관련 Vessel를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgVslClassVessel(Event e) throws EventException;
	/**
	 * Port (Service) Charge History 조회.
	 * 
	 * @category EDS_EAS_0302
	 * @param e EsdEas0302Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPreAuditHistoryList(Event e) throws EventException;
	/**
	 * Pre-Audit Criterion setting 내역을 조회한다.
	 * 
	 * @param PreAuditCreSetVO preAuditCreSetVO
	 * @param SignOnUserAccount account
	 * @return List<PreAuditCreSetVO>
	 * @throws EventException
	 */
	public List<PreAuditCreSetVO> searchPsoConfig(PreAuditCreSetVO preAuditCreSetVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Pre-Audit Criterion setting 내역을 저장한다. <br>
	 * 
	 * @param PreAuditCreSetVO[] preAuditCreSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void  multiPsoConfig(PreAuditCreSetVO[] preAuditCreSetVOs,SignOnUserAccount account) throws EventException;	

	/***************************************************************************************************************/
	
	/**
	 * Pso Invoice Charge  를 저장한다.<br>
	 * 
	 * @param PreAuditBatchVO[] psoPreAudListVOs
	 * @exception EventException
	 */
	public void confirmPsoPreAudit(PreAuditBatchVO[] psoPreAudListVOs) throws EventException;

	/**
	 * Pso Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param PreAuditBatchVO conditionVO
	 * @return List<PreAuditBatchVO> 
	 * @exception EventException
	 */
	public List<PreAuditBatchVO> searchPsoAutoAudList(PreAuditBatchVO conditionVO) throws EventException;
	
	/**
	 * Audit History를 저장한다.<br>
	 * 
	 * @param PreAuditBatchVO psoPreAudListVO
	 * @exception EventException
	 */
	public void addAutoAuditHis(PreAuditBatchVO psoPreAudListVO) throws EventException;
	
	/**
	 * Auto Audit 내역을 삭제 한다.<br>
	 * 
	 * @param PreAuditBatchVO psoPreAudListVO
	 * @exception EventException
	 */
	public void removeAutoAudit(PreAuditBatchVO psoPreAudListVO) throws EventException;
	
	/**
	 * 실시간 배치 대상의 상태코드를 완료로 변경한다.<br>
	 * 
	 * @param PreAuditBatchVO psoPreAudListVO
	 * @exception EventException
	 */
	public void updateBatchStatus(PreAuditBatchVO psoPreAudListVO) throws EventException;
	
	/**
	 * 실시간 배치 대상을 저장한다.<br>
	 * 
	 * @param PreAuditBatchVO[] psoPreAudListVOs
	 * @exception EventException
	 */
	public void saveReBatchTarget(PreAuditBatchVO[] psoPreAudListVOs) throws EventException;


}

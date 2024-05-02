/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PsoAdvanceAuditBCImpl
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


import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0301Event;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0302Event;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration.PsoAdvanceAuditDBDAO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditBatchVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditCreSetVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * PsoAdvanceAuditBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class PsoAdvanceAuditBCImpl extends BasicCommandSupport implements PsoAdvanceAuditBC {

	
	// Database Access Object
	private transient PsoAdvanceAuditDBDAO dbDao = null;

	/**
	 * PsoAdvanceAuditBCImpl 객체 생성<br>
	 * PsoAdvanceAuditDBDAO 생성한다.<br>
	 */
	public PsoAdvanceAuditBCImpl(){
		dbDao = new PsoAdvanceAuditDBDAO();
	}

	/**
	 * Port (Service) Charge 조회.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPreAuditList(Event e) throws EventException {
		EsdEas0301Event event=(EsdEas0301Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.searchPreAuditList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Port (Service) Charge 조회.
	 * 
	 * @category EDS_EAS_0301
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPreAuditList2(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		EsdEas0301Event event=(EsdEas0301Event)e;
		try {
			rowSet = dbDao.searchPreAuditList2(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Port (Service) Charge - Confirm - DB에 반영한다.(변경) <br>
	 * 
	 * @category EDS_EAS_0301
	 * @param e EDS_EAS_0301Event
	 * @param account SignOnUserAccount
	 * @return EventResponse EDS_EAS_0301EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAutoAuditFlg(Event e,SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0301Event event=(EsdEas0301Event)e;
		try {
			dbDao.modifyAutoAuditFlg(event, account);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Port (Service) Charge에 관련 Account를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgAccount(Event e) throws EventException {
		EsdEas0301Event event=(EsdEas0301Event)e;
		
		try {
			return dbDao.searchAuditFlgAccount(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Port (Service) Charge에 관련 Cost를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgCost(Event e) throws EventException {
		EsdEas0301Event event=(EsdEas0301Event)e;
		
		try {
			return dbDao.searchAuditFlgCost(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * S/P No. name 조회.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return String
	 * @throws EventException
	 */
	public String searchAuditFlgSpName(Event e) throws EventException {

		EsdEas0301Event event=(EsdEas0301Event)e;
		
		try {
			return dbDao.searchAuditFlgSpName(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Port (Service) Charge에 관련 VesselClass를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgVslClass(Event e) throws EventException {
		EsdEas0301Event event=(EsdEas0301Event)e;
		
		try {
			return dbDao.searchAuditFlgVslClass(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Port (Service) Charge에 관련 VesselClass관련 Vessel를 조회한다.
	 * 
	 * @category EDS_EAS_0301
	 * @param e EsdEas0301Event
	 * @return   List<PreAuditListVO>
	 * @throws   EventException
	 */		
	public List<PreAuditListVO> searchAuditFlgVslClassVessel(Event e) throws EventException {
		EsdEas0301Event event=(EsdEas0301Event)e;
		
		try {
			return dbDao.searchAuditFlgVslClassVessel(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Port (Service) Charge History 조회.
	 * 
	 * @category EDS_EAS_0302
	 * @param e EsdEas0302Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPreAuditHistoryList(Event e) throws EventException {
		
		EsdEas0302Event event=(EsdEas0302Event)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			rowSet = dbDao.searchPreAuditHistoryList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Pre-Audit Criterion setting 내역을 조회한다
	 * 
	 * @category EDS_EAS_0303
	 * @param PreAuditCreSetVO preAuditCreSetVO
	 * @param SignOnUserAccount account
	 * @return List<PreAuditCreSetVO>
	 * @throws EventException
	 */
	public List<PreAuditCreSetVO> searchPsoConfig(PreAuditCreSetVO preAuditCreSetVO,SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchPsoConfig(preAuditCreSetVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Pre-Audit Criterion setting 내역을 저장한다. 
	 * 
	 * @param PreAuditCreSetVO[] preAuditCreSetVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void  multiPsoConfig(PreAuditCreSetVO[] preAuditCreSetVOs,SignOnUserAccount account) throws EventException {
		try {
			String usrId = account.getUsr_id();
			if(null != preAuditCreSetVOs){
				for(int i=0;i<preAuditCreSetVOs.length;i++){
					preAuditCreSetVOs[i].setUpdUsrId(usrId);				 
					dbDao.multiPsoConfig(preAuditCreSetVOs[i]);
				}				
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/***************************************************************************************************************/
	
	/**
	 *Pso Pre-Audit Criterion setting 를 저장한다.(배치용)<br>
	 * 
	 * @param PreAuditBatchVO[] psoPreAudListVOs
	 * @exception EventException
	 */
	public void confirmPsoPreAudit(PreAuditBatchVO[] psoPreAudListVOs) throws EventException {
		try {
			PreAuditBatchVO psoPreAudListVO = new PreAuditBatchVO();
			for ( int i=0; i<psoPreAudListVOs.length; i++ ) {
				psoPreAudListVO = psoPreAudListVOs[i];
				//trsPreAudListVO.setSSaveTpCd(trsPreAudListVOs[0].getSSaveTpCd());
				dbDao.confirmPsoPreAudit(psoPreAudListVO);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Pso Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param PreAuditBatchVO conditionVO
	 * @return List<PreAuditBatchVO>
	 * @exception EventException
	 */
	public List<PreAuditBatchVO> searchPsoAutoAudList(PreAuditBatchVO conditionVO)  throws EventException {
		try {
			return dbDao.searchPsoAutoAudList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Audit History를 저장한다.<br>
	 * 
	 * @param PreAuditBatchVO psoPreAudListVO
	 * @exception EventException
	 */
	public void addAutoAuditHis(PreAuditBatchVO psoPreAudListVO) throws EventException {
		try {
			dbDao.addAutoAuditHis(psoPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Auto Audit 내역을 삭제 한다.<br>
	 * 
	 * @param PreAuditBatchVO psoPreAudListVO
	 * @exception EventException
	 */
	public void removeAutoAudit(PreAuditBatchVO psoPreAudListVO) throws EventException {
		try {
			dbDao.removeAutoAudit(psoPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 실시간 배치 대상의 상태코드를 완료로 변경한다.<br>
	 * 
	 * @param PreAuditBatchVO psoPreAudListVO
	 * @exception EventException
	 */
	public void updateBatchStatus(PreAuditBatchVO psoPreAudListVO) throws EventException {
		try {
			dbDao.updateBatchStatus(psoPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 실시간 배치 대상을 저장한다.<br>
	 * 
	 * @param PreAuditBatchVO[] psoPreAudListVOs
	 * @exception EventException
	 */
	public void saveReBatchTarget(PreAuditBatchVO[] psoPreAudListVOs) throws EventException {
		try {
			PreAuditBatchVO psoPreAudListVO = new PreAuditBatchVO();
			for ( int i=0; i<psoPreAudListVOs.length; i++ ) {
				psoPreAudListVO = psoPreAudListVOs[i];
				dbDao.saveReBatchTarget(psoPreAudListVO);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
}

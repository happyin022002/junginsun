/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScheduleTransmitManagementBCImpl.java
*@FileTitle : ETA sending (Auto FAX/TLX)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.05 진마리아
* 1.0 Creation
* History
* 2012.12.20 CHM-201221649-01 진마리아  ETA sending (Auto FAX/TLX)
* 2013.05.07 CHM-201324462 [VOP-VSK] VSK Auto TLX SPP 발송 계정 변경
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration.ScheduleTransmitManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration.ScheduleTransmitManagementEAIDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendMoniVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-ScheduleUtilityManagement Business Logic Basic Command implementation<br>
 * - NIS2010-ScheduleUtilityManagement 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Maria Chin
 * @see UI_VSK-0290EventResponse,ScheduleTransmitManagementBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ScheduleTransmitManagementBCImpl extends BasicCommandSupport implements ScheduleTransmitManagementBC {

	// Database Access Object
	private transient ScheduleTransmitManagementDBDAO dbDao = null;

	/**
	 * ScheduleTransmitManagementBCImpl 객체 생성<br>
	 * ScheduleTransmitManagementDBDAO를 생성한다.<br>
	 */
	public ScheduleTransmitManagementBCImpl() {
		dbDao = new ScheduleTransmitManagementDBDAO();
	}
	
	/**
	 * ETA Sending(Auto-fax) 대상 SKD을 조회합니다.
	 * 
	 * @param  EtaSendTgtVO etaSendTgtVO
	 * @return List<EtaSendTgtVO>
	 * @exception EventException
	 */
	public List<EtaSendTgtVO> searchTransmitNoticeTgtSkdList(EtaSendTgtVO etaSendTgtVO) throws EventException {
		try {
			return dbDao.searchTransmitNoticeTgtSkdList(etaSendTgtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * 기전송된 ETA 정보에 대하여, RPM에 대한 결과값을 저장합니다.
	 * 
	 * @param  List<EtaSendTgtVO> etaSendTgtVOList
	 * @exception EventException
	 */
	public void manageEtaSendResult(List<EtaSendTgtVO> etaSendTgtVOList) throws EventException {
		try {

			if (etaSendTgtVOList.size() > 0) {
				dbDao.modifyEtaSendResult(etaSendTgtVOList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		}
	}
	
	
/*	public void manageEtaSendResult(EtaSendTgtVO[] etaSendTgtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<EtaSendTgtVO> updateVoList = new ArrayList<EtaSendTgtVO>();
			
			for(EtaSendTgtVO vo : etaSendTgtVOs){
				if("ALPS".equals(vo.getTrsmOwnrCd())){
					
					if("U".equals(vo.getIbflag())){
						vo.setUpdUsrId(account.getUsr_id());
						updateVoList.add(vo);
					}
				
				*//*** "ESVC" --- SPP ***//*
				}else{
					vo.setUpdUsrId(account.getUsr_id());					
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyEtaSendResult(updateVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		}
	}	
	*/
	
	

	/**
	 * 변경된 VSK_VSL_PORT_SKD_TRSM_HIS의 ETA, ETB 정보를 저장하고 FAX 발송
	 * 
	 * @param EtaSendTgtVO etaSendTgtVO
	 * @exception EventException
	 */
	public void manageTransmitNoticeTargetSkd(EtaSendTgtVO etaSendTgtVO) throws EventException {

		final 	String sEsvcSndrEml	= "vessel-ops@smlines.com"; 
		
		try {
			
			//int trsmHisSeq = 0;	
			//trsmHisSeq = dbDao.searchtrsmHisSeq();      // sequence 채번 
			//etaSendTgtVO.setTrsmHisSeq(Integer.toString(trsmHisSeq));
			ScheduleTransmitManagementEAIDAO eaiDao = new ScheduleTransmitManagementEAIDAO();
			
			/*********************************************************
			 * SPP 발송 TELEX/FAX의 경우 Sender Email을 고정함
			 * -------------------------------------------------------
			 * vessel-ops@smlines.com
			 */
			
			log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementBCImpl::========= \n\n");
	        log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementBCImpl::Owner >>> ["+etaSendTgtVO.getTrsmOwnrCd()+"]\n\n");  
	        log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementBCImpl::Sender.Email >>> ["+etaSendTgtVO.getSndrEml()+"]\n\n");
			
			String	sSndrEml	= "ESVC".equals(etaSendTgtVO.getTrsmOwnrCd())?sEsvcSndrEml:etaSendTgtVO.getSndrEml();
			etaSendTgtVO.setSndrEml(sSndrEml);
			 
			log.info("\n ======== ::jskjskjsk::ScheduleTransmitManagementBCImpl::Conversion.Email >>> ["+etaSendTgtVO.getSndrEml()+"]\n\n");  
			
	        String ref = eaiDao.sendScheduleTransmitEmail(etaSendTgtVO);
	        etaSendTgtVO.setEmlSndNo(ref);
	        //log.debug("ref:"+ ref);
	        
			dbDao.manageTransmitNoticeTargetSkd(etaSendTgtVO);    // VSK_VSL_PORT_SKD_TRSM_HIS INSERT  
			//dbDao.manageEtaSendTgtSkdEml(etaSendTgtVO); // VSK_VSL_PORT_SKD_TRSM_EML INSERT
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}

	/**
	 * ETA Sending(Auto TLX/FAX) 내역을 조회합니다.
	 * 
	 * @param  EtaSendMoniVO etaSendMoniVO
	 * @return List<EtaSendMoniVO>
	 * @exception EventException
	 */
	public List<EtaSendMoniVO> searchTransmitNoticeMoniList(EtaSendMoniVO etaSendMoniVO) throws EventException {
		try {
			return dbDao.searchTransmitNoticeMoniList(etaSendMoniVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
}
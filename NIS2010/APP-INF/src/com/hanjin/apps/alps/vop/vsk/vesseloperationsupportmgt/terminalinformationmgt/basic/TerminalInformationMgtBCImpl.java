/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtBCImpl.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.25 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration.TerminalInformationMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalHandlingInfoAttachFileVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskPortFltgCrnVO;
import com.hanjin.syscommon.common.table.VskPortGngStrcVO;

/**
 * NIS2010-VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - NIS2010-VesselOperationSupportMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Suk Hyun
 * @see vop_opf_0007EventResponse,TerminalInformationMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TerminalInformationMgtBCImpl extends BasicCommandSupport implements TerminalInformationMgtBC {

	// Database Access Object
	private transient TerminalInformationMgtDBDAO dbDao = null;

	/**
	 * TerminalInformationMgtBCImpl 객체 생성<br>
	 * TerminalInformationMgtDBDAO를 생성한다.<br>
	 */
	public TerminalInformationMgtBCImpl() {
		dbDao = new TerminalInformationMgtDBDAO();
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Combo]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPortComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException { 
		try {
			return dbDao.searchPortComboList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Combo"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Combo"}).getUserMessage(),ex);
		}
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Max Sequence]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchMaxFCraneSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {
		try {
			return dbDao.searchMaxFCraneSeqList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Max Sequence"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Max Sequence"}).getUserMessage(),ex);
		}
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Combo]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPortInfoList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException{
		try {
			return dbDao.searchPortInfoList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Combo"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Combo"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Combo]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchTermialComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {
		try {
			return dbDao.searchTermialComboList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Combo"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Combo"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [G/Crane]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGntrCrnVO>
	 * @exception EventException
	 */
	public List<VskPortGntrCrnVO> searchGCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {
		try {
			return dbDao.searchGCraneList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation G/Crane"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation G/Crane"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [F/Crane]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortFltgCrnVO>
	 * @exception EventException
	 */
	public List<VskPortFltgCrnVO> searchFCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {	
		try {
			return dbDao.searchFCraneList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation F/Crane"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation F/Crane"}).getUserMessage(),ex);
		}
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Gang Structure]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGngStrcVO>
	 * @exception EventException
	 */
	public List<VskPortGngStrcVO> searchGangStructureList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {
		try {
			return dbDao.searchGangStructureList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Gang Structure"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Gang Structure"}).getUserMessage(),ex);
		}
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Birth Window]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortBrthWdoVO>
	 * @exception EventException
	 */
	public List<VskPortBrthWdoVO> searchBerthWindowList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {
		try {
			return dbDao.searchBerthWindowList(terminalInfoConditionVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Birth Window"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Birth Window"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Save <br>
	 * [VSK PORT GANTRY CRANE]을 [저장] 합니다.<br>
	 * 
	 * @param VskPortGntrCrnVO[] vskPortGntrCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGcrane(VskPortGntrCrnVO[] vskPortGntrCrnVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortGntrCrnVO> 	insertVoList 				= new ArrayList<VskPortGntrCrnVO>();
			List<VskPortGntrCrnVO> 	updateVoList 				= new ArrayList<VskPortGntrCrnVO>();
			List<VskPortGntrCrnVO> 	deleteVoList 				= new ArrayList<VskPortGntrCrnVO>();
			
			List<VskPortGntrCrnVO> 	mergeSpclCgoHndlRmkVOList 	= new ArrayList<VskPortGntrCrnVO>();
			int						iSpclCgoHndlRmkKnt			= 0;
			
			if(vskPortGntrCrnVOs != null){
				for ( int i=0; i<vskPortGntrCrnVOs .length; i++ ) {
					
					log.info("\n\n====== ::jskjskjsk:: ======= <<getIbflag>> =======["+vskPortGntrCrnVOs[i].getIbflag()+"]\n\n");
					
					if (vskPortGntrCrnVOs[i].getIbflag().equals("S")){

						if(iSpclCgoHndlRmkKnt == 0){
							iSpclCgoHndlRmkKnt++;

							vskPortGntrCrnVOs[i].setCreUsrId(account.getUsr_id());
							vskPortGntrCrnVOs[i].setUpdUsrId(account.getUsr_id());							
							mergeSpclCgoHndlRmkVOList.add(vskPortGntrCrnVOs[i]);
							
							log.info("\n\n====== ::jskjskjsk:: [SELECT] ======= <<iSpclCgoHndlRmkKnt>> =======["+iSpclCgoHndlRmkKnt+"]\n\n");
						}
						
					} else if (vskPortGntrCrnVOs[i].getIbflag().equals("I")){
						vskPortGntrCrnVOs[i].setCreUsrId(account.getUsr_id());
						vskPortGntrCrnVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(vskPortGntrCrnVOs[i]);
						
						if(iSpclCgoHndlRmkKnt == 0){
							iSpclCgoHndlRmkKnt++;
							mergeSpclCgoHndlRmkVOList.add(vskPortGntrCrnVOs[i]);
							
							log.info("\n\n====== ::jskjskjsk:: [INSERT] ======= <<iSpclCgoHndlRmkKnt>> =======["+iSpclCgoHndlRmkKnt+"]\n\n");
						}
						
					} else if (vskPortGntrCrnVOs[i].getIbflag().equals("U")){
						vskPortGntrCrnVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortGntrCrnVOs[i]);
						
						////if(iSpclCgoHndlRmkKnt == 0 && vskPortGntrCrnVOs[i].getSpclCgoHndlRmk() != null && !"".equals(vskPortGntrCrnVOs[i].getSpclCgoHndlRmk())){
						if(iSpclCgoHndlRmkKnt == 0){
								
							iSpclCgoHndlRmkKnt++;
							mergeSpclCgoHndlRmkVOList.add(vskPortGntrCrnVOs[i]);
							
							log.info("\n\n====== ::jskjskjsk:: [UPDATE] ======= <<iSpclCgoHndlRmkKnt>> =======["+iSpclCgoHndlRmkKnt+"]\n\n");
						}
						
					} else if (vskPortGntrCrnVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortGntrCrnVOs[i]);
					}
				}
				
				log.info("\n\n====== ::jskjskjsk:: ======= <<TerminalInformationMgtBCImpl.java>> =======\n\n");
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addGCraneS(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyGCraneS(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeGCraneS(deleteVoList);
				}
				
				//::PORT SPECIAL CARGO HANDLING INFORMATION SPECIAL REMARK MERGE/DELETE:://
				////if(iSpclCgoHndlRmkKnt == 0){
				////	dbDao.removeSpclCgoHndlRmk	(mergeSpclCgoHndlRmkVOList);
				if(mergeSpclCgoHndlRmkVOList.size() > 0) {
					dbDao.saveSpclCgoHndlRmk	(mergeSpclCgoHndlRmkVOList);
				}
				
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Gantry Crane"}).getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Gantry Crane"}).getUserMessage(),de);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Save <br>
	 * [VSK PORT FLOATING CRANE]을 [저장] 합니다.<br>
	 * 
	 * @param VskPortFltgCrnVO[] vskPortFltgCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoFcrane(VskPortFltgCrnVO[] vskPortFltgCrnVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortFltgCrnVO> insertVoList = new ArrayList<VskPortFltgCrnVO>();
			List<VskPortFltgCrnVO> updateVoList = new ArrayList<VskPortFltgCrnVO>();
			List<VskPortFltgCrnVO> deleteVoList = new ArrayList<VskPortFltgCrnVO>();
			if(vskPortFltgCrnVOs != null){
				for ( int i=0; i< vskPortFltgCrnVOs.length; i++ ) {
					if ( vskPortFltgCrnVOs[i].getIbflag().equals("I")){
						vskPortFltgCrnVOs[i].setCreUsrId(account.getUsr_id());
						vskPortFltgCrnVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(vskPortFltgCrnVOs[i]);
					} else if ( vskPortFltgCrnVOs[i].getIbflag().equals("U")){
						vskPortFltgCrnVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortFltgCrnVOs[i]);
					} else if ( vskPortFltgCrnVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortFltgCrnVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addFCraneS(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyFCraneS(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeFCraneS(deleteVoList);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Floating Crane"}).getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Floating Crane"}).getUserMessage(),de);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Save <br>
	 * [VSK PORT GANG STRUCTURE]을 [저장] 합니다.<br>
	 * 
	 * @param VskPortGngStrcVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGang(VskPortGngStrcVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortGngStrcVO> insertVoList = new ArrayList<VskPortGngStrcVO>();
			List<VskPortGngStrcVO> updateVoList = new ArrayList<VskPortGngStrcVO>();
			List<VskPortGngStrcVO> deleteVoList = new ArrayList<VskPortGngStrcVO>();
			if(vskPortGngStrcVOs != null){
				for ( int i=0; i< vskPortGngStrcVOs.length; i++ ) {
					if ( vskPortGngStrcVOs[i].getIbflag().equals("I")){
						vskPortGngStrcVOs[i].setCreUsrId(account.getUsr_id());
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("U")){
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortGngStrcVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addGangStructureS(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyGangStructureS(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeGangStructureS(deleteVoList);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Gang Structure"}).getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Gang Structure"}).getUserMessage(),de);
		}
	}
	
	/**
	 * VOP_VSK_0507 : Save <br>
	 * [VSK PORT BIRTH WINDOW]을 [저장] 합니다.<br>
	 * 
	 * @param VskPortBrthWdoVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoBerth(VskPortBrthWdoVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortBrthWdoVO> insertVoList = new ArrayList<VskPortBrthWdoVO>();
			List<VskPortBrthWdoVO> updateVoList = new ArrayList<VskPortBrthWdoVO>();
			List<VskPortBrthWdoVO> deleteVoList = new ArrayList<VskPortBrthWdoVO>();
			if(vskPortGngStrcVOs != null){
				for ( int i=0; i< vskPortGngStrcVOs.length; i++ ) {
					if ( vskPortGngStrcVOs[i].getIbflag().equals("I")){
						vskPortGngStrcVOs[i].setCreUsrId(account.getUsr_id());
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("U")){
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortGngStrcVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addBerthWindowS(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyBerthWindowS(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeBerthWindowS(deleteVoList); 
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Birth Window"}).getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"TerminalInformation Birth Window"}).getUserMessage(),de);
		}
	}
	
	/**
	 * VOP_VSK_2507 : Retrieve <br>
	 * Terminal Handling Information Attach File List를 조회 합니다.<br>
	 * 
	 * @param TerminalHandlingInfoAttachFileVO terminalHandlingInfoAttachFileVO
	 * @return List<TerminalHandlingInfoAttachFileVO>
	 * @exception EventException
	 */
	public List<TerminalHandlingInfoAttachFileVO> searchTerminalHandlingInfoAttachFileList(TerminalHandlingInfoAttachFileVO terminalHandlingInfoAttachFileVO) throws EventException {
		
		try {
			return dbDao.searchTerminalHandlingInfoAttachFileList(terminalHandlingInfoAttachFileVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Handling Information Attach File"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Handling Information Attach File"}).getUserMessage(),ex);
		}
	}
	
	
	/**
	 * VOP_VSK_2507 : Save <br>
	 * Terminal Handling Information Attach File List를 저장 합니다.<br>
	 * 
	 * @param TerminalHandlingInfoAttachFileVO[] terminalHandlingInfoAttachFileVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @exception DAOException
	 */
	public void manageTerminalHandlingInfoAttachFileList(TerminalHandlingInfoAttachFileVO[] terminalHandlingInfoAttachFileVO, SignOnUserAccount account) throws EventException, DAOException {
		
		List<TerminalHandlingInfoAttachFileVO> insertVoList = new ArrayList<TerminalHandlingInfoAttachFileVO>();
		////List<TerminalHandlingInfoAttachFileVO> updateVoList = new ArrayList<TerminalHandlingInfoAttachFileVO>();
		List<TerminalHandlingInfoAttachFileVO> deleteVoList = new ArrayList<TerminalHandlingInfoAttachFileVO>();
		
		for (int i=0; i<terminalHandlingInfoAttachFileVO.length; i++) {
			
			if(terminalHandlingInfoAttachFileVO[i].getIbflag().equals("I")){
				terminalHandlingInfoAttachFileVO[i].setCreUsrId(account.getUsr_id());
				terminalHandlingInfoAttachFileVO[i].setUpdUsrId(account.getUsr_id());
				
				log.info("\n\n ======= ::jskjsk:: ========= getIbflag ["+terminalHandlingInfoAttachFileVO[i].getIbflag()+"]\n");
				log.info("\n   ======= ::jskjsk:: ========= getFileNm ["+terminalHandlingInfoAttachFileVO[i].getFileNm()+"]\n");
				
				
				insertVoList.add(terminalHandlingInfoAttachFileVO[i]);
			////} else if ( terminalHandlingInfoAttachFileVO[i].getIbflag().equals("U")){
			////	terminalHandlingInfoAttachFileVO[i].setCreUsrId(account.getUsr_id());
			////	terminalHandlingInfoAttachFileVO[i].setUpdUsrId(account.getUsr_id());
			////	updateVoList.add(terminalHandlingInfoAttachFileVO[i]);
			}else if(terminalHandlingInfoAttachFileVO[i].getIbflag().equals("D")){
				deleteVoList.add(terminalHandlingInfoAttachFileVO[i]);
			}
			
		}
		
		if ( insertVoList.size() > 0 ) {
			dbDao.addTerminalHandlingInfoAttachFileList		(insertVoList);
		}
		
		////if ( updateVoList.size() > 0 ) {
		////	dbDao.modifyTerminalHandlingInfoAttachFileList	(updateVoList);
		////}
		
		if ( deleteVoList.size() > 0 ) {
			dbDao.removeTerminalHandlingInfoAttachFileList	(deleteVoList);
		}		
		
		
	}
	
}
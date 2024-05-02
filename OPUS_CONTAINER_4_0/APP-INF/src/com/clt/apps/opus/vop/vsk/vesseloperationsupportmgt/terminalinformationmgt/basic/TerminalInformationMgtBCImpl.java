/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtBCImpl.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.integration.TerminalInformationMgtDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskPortFltgCrnVO;
import com.clt.syscommon.common.table.VskPortGngStrcVO;

/**
 * VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * -Handling business logic of VesselOperationSupportMgt<br>
 *
 * @author
 * @see vop_opf_0007EventResponse,TerminalInformationMgtBC,DAO
 * @since J2EE 1.4
 */
public class TerminalInformationMgtBCImpl extends BasicCommandSupport implements TerminalInformationMgtBC {

	// Database Access Object
	private transient TerminalInformationMgtDBDAO dbDao = null;

	/**
	 * TerminalInformationMgtBCImpl object creation<br>
	 * Creating TerminalInformationMgtDBDAO<br>
	 */
	public TerminalInformationMgtBCImpl() {
		dbDao = new TerminalInformationMgtDBDAO();
	}

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Port Combo
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
	 * Retrieving Port Max Sequence
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
	 * Retrieving Gang Structure  Max Sequence
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchMaxGngSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException {
		try {
			return dbDao.searchMaxGngSeqList(terminalInfoConditionVO);
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
	 * Retrieving Port Combo
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
	 * Retrieving Terminal Combo
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
	 * Retrieving G/Crane
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
	 * Retrieving F/Crane
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
	 * Retrieving Gang Structure
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
	 * Retrieving Berth Window
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
	 * Saving VSK PORT GANTRY CRANE
	 * 
	 * @param VskPortGntrCrnVO[] vskPortGntrCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGcrane(VskPortGntrCrnVO[] vskPortGntrCrnVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortGntrCrnVO> insertVoList = new ArrayList<VskPortGntrCrnVO>();
			List<VskPortGntrCrnVO> updateVoList = new ArrayList<VskPortGntrCrnVO>();
			List<VskPortGntrCrnVO> deleteVoList = new ArrayList<VskPortGntrCrnVO>();
			
			if(vskPortGntrCrnVOs != null){
				for ( int i=0; i<vskPortGntrCrnVOs .length; i++ ) {
					if ( vskPortGntrCrnVOs[i].getIbflag().equals("I")){
						vskPortGntrCrnVOs[i].setCreUsrId(account.getUsr_id());
						vskPortGntrCrnVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(vskPortGntrCrnVOs[i]);
					} else if ( vskPortGntrCrnVOs[i].getIbflag().equals("U")){
						vskPortGntrCrnVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortGntrCrnVOs[i]);
					} else if ( vskPortGntrCrnVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortGntrCrnVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addGCraneS(insertVoList);
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyGCraneS(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeGCraneS(deleteVoList);
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
	 * Saving VSK PORT FLOATING CRANE
	 * 
	 * @param VskPortFltgCrnVO[] vskPortFltgCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoFcrane(VskPortFltgCrnVO[] vskPortFltgCrnVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortFltgCrnVO> updateVoList = new ArrayList<VskPortFltgCrnVO>();
			List<VskPortFltgCrnVO> deleteVoList = new ArrayList<VskPortFltgCrnVO>();
			if(vskPortFltgCrnVOs != null){
				for ( int i=0; i< vskPortFltgCrnVOs.length; i++ ) {
					if ( vskPortFltgCrnVOs[i].getIbflag().equals("I")){
						vskPortFltgCrnVOs[i].setCreUsrId(account.getUsr_id());
						vskPortFltgCrnVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.addFCraneS(vskPortFltgCrnVOs[i]);
					} else if ( vskPortFltgCrnVOs[i].getIbflag().equals("U")){
						vskPortFltgCrnVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortFltgCrnVOs[i]);
					} else if ( vskPortFltgCrnVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortFltgCrnVOs[i]);
					}
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
	 * Saving VSK PORT GANG STRUCTURE
	 * 
	 * @param VskPortGngStrcVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGang(VskPortGngStrcVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortGngStrcVO> updateVoList = new ArrayList<VskPortGngStrcVO>();
			List<VskPortGngStrcVO> deleteVoList = new ArrayList<VskPortGngStrcVO>();
			if(vskPortGngStrcVOs != null){
				for ( int i=0; i< vskPortGngStrcVOs.length; i++ ) {
					if ( vskPortGngStrcVOs[i].getIbflag().equals("I")){
						vskPortGngStrcVOs[i].setCreUsrId(account.getUsr_id());
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.addGangStructureS(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("U")){
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortGngStrcVOs[i]);
					}
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
	 * Saving VSK PORT BERTH WINDOW
	 * 
	 * @param VskPortBrthWdoVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoBerth(VskPortBrthWdoVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortBrthWdoVO> updateVoList = new ArrayList<VskPortBrthWdoVO>();
			List<VskPortBrthWdoVO> deleteVoList = new ArrayList<VskPortBrthWdoVO>();
			if(vskPortGngStrcVOs != null){
				for ( int i=0; i< vskPortGngStrcVOs.length; i++ ) {
					if ( vskPortGngStrcVOs[i].getIbflag().equals("I")){
						vskPortGngStrcVOs[i].setCreUsrId(account.getUsr_id());
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.addBerthWindowS(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("U")){
						vskPortGngStrcVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vskPortGngStrcVOs[i]);
					} else if ( vskPortGngStrcVOs[i].getIbflag().equals("D")){
						deleteVoList.add(vskPortGngStrcVOs[i]);
					}
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
	
}
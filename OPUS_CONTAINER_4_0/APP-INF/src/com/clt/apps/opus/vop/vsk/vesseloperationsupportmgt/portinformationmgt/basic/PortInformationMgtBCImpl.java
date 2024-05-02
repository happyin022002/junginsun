/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtBCImpl.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration.PortInformationMgtDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskPortCnlTrScgVO;

/**
 * VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - Handling business logic of VesselOperationSupportMgt<br>
 *
 * @author
 * @see VOP_VSK_0004EventResponse,PortInformationMgtBC, dao
 * @since J2EE 1.6
 */
public class PortInformationMgtBCImpl extends BasicCommandSupport implements PortInformationMgtBC {

	// Database Access Object
	private transient PortInformationMgtDBDAO dbDao = null;

	/**
	 * PortInformationMgtBCImpl object creation<br>
	 * Creating PortInformationMgtDBDAO<br>
	 */
	public PortInformationMgtBCImpl() {
		dbDao = new PortInformationMgtDBDAO();
	}
	/**
	 * Retrieving Maneuvering in Port Information Creation<br>
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<PortInformationMgtVO>
	 * @exception EventException
	 */
	public List<PortInformationMgtVO> searchManueveringList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchManueveringList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	/**
	 * Maneuvering Terminal Non-Working in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortNworkVO>
	 * @exception EventException
	 */
	public List<VskPortNworkVO> searchNonWorkingList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchNonWorkingList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Distance in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */
	public List<VskPortDistVO> searchDistanceList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchDistanceList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Doc.&Dead Hrs in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortDocBufTmVO>
	 * @exception EventException
	 */
	public List<VskPortDocBufTmVO> searchDocHourList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchDocHourList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Canal in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlPassCondVO>
	 * @exception EventException
	 */
	public List<VskPortCnlPassCondVO> searchCanelList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchCanelList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving 2nd grid of Canal in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgListVO>
	 * @exception EventException
	 */
	public List<VskPortCnlTrScgListVO> searchPortCnlTrScgList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchPortCnlTrScgList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving 2nd grid for saving of Canal in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortCnlTrScgVO>
	 * @exception EventException
	 */
	public List<VskPortCnlTrScgVO> searchPortCnlTrScg(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchPortCnlTrScg(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Trucking in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO>
	 * @exception EventException
	 */
	public List<VskPortTrspCondVO> searchTruckingList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchTruckingList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Railroad in Port Information Creation
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<VskPortTrspCondVO>
	 * @exception EventException
	 */
	public List<VskPortTrspCondVO> searchRailLoadList(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchRailLoadList(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 *  Retrieving TMNL Code in Maneuvering
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmYardCombo(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchMdmYardCombo(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving RHQ of Port Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmLocCdCombo(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchMdmLocCdCombo(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Retrieving Port for Doc.&Dead Hrs
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmRhqLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchMdmRhqLocCombo(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}	

	/**
	 * Retrieving Port Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmRhqDocLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchMdmRhqDocLocCombo(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Port Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmYardComboVO>
	 * @exception EventException
	 */
	public List<MdmYardComboVO> searchMdmTrspLocCombo(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchMdmTrspLocCombo(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving RHQ Code
	 * 
	 * @param PortInformationConditionVO portInformationConditionVO
	 * @return List<MdmRhqComboVO>
	 * @exception EventException
	 */
	public List<MdmRhqComboVO> searchMdmRhqCombo(PortInformationConditionVO portInformationConditionVO) throws EventException {
		try {
			return dbDao.searchMdmRhqCombo(portInformationConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Data"}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving Maneuvering
	 * 
	 * @param PortInformationMgtVO[] portInformationMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortInfo(PortInformationMgtVO[] portInformationMgtVO, SignOnUserAccount account) throws EventException{
		try {
			List<PortInformationMgtVO> insertVoList = new ArrayList<PortInformationMgtVO>();
			List<PortInformationMgtVO> updateVoList = new ArrayList<PortInformationMgtVO>();
			List<PortInformationMgtVO> deleteVoList = new ArrayList<PortInformationMgtVO>();
			for ( int i=0; i<portInformationMgtVO .length; i++ ) {
				if ( portInformationMgtVO[i].getIbflag().equals("I")){
					portInformationMgtVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(portInformationMgtVO[i]);
				} else if ( portInformationMgtVO[i].getIbflag().equals("U")){
					portInformationMgtVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(portInformationMgtVO[i]); 
				} else if ( portInformationMgtVO[i].getIbflag().equals("D")){
					deleteVoList.add(portInformationMgtVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanagePortInfoS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanagePortInfoS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanagePortInfoS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 * Saving Terminal Non-Working
	 * 
	 * @param VskPortNworkVO[] vskPortNworkVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNonWorking(VskPortNworkVO[] vskPortNworkVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortNworkVO> insertVoList = new ArrayList<VskPortNworkVO>();
			List<VskPortNworkVO> updateVoList = new ArrayList<VskPortNworkVO>();
			List<VskPortNworkVO> deleteVoList = new ArrayList<VskPortNworkVO>();
			for ( int i=0; i<vskPortNworkVO .length; i++ ) {
				if ( vskPortNworkVO[i].getIbflag().equals("I")){
					vskPortNworkVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(vskPortNworkVO[i]);
				} else if ( vskPortNworkVO[i].getIbflag().equals("U")){
					vskPortNworkVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortNworkVO[i]); 
				} else if ( vskPortNworkVO[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortNworkVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addPortNonWorkingS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortNonWorkingS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortNonWorkingS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 * Saving Distance
	 * 
	 * @param VskPortDistVO[] vskPortDistVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortDistance(VskPortDistVO[] vskPortDistVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortDistVO> insertVoList = new ArrayList<VskPortDistVO>();
			List<VskPortDistVO> updateVoList = new ArrayList<VskPortDistVO>();
			List<VskPortDistVO> deleteVoList = new ArrayList<VskPortDistVO>();
			for ( int i=0; i<vskPortDistVO .length; i++ ) {
				if ( vskPortDistVO[i].getIbflag().equals("I")){
					vskPortDistVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(vskPortDistVO[i]);
				} else if ( vskPortDistVO[i].getIbflag().equals("U")){
					vskPortDistVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortDistVO[i]); 
				} else if ( vskPortDistVO[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortDistVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addPortDistanceS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortDistanceS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortDistanceS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving Doc.&Dead Hrs
	 * 
	 * @param VskPortDocBufTmVO[] vskPortDocBufTmVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortDocHour(VskPortDocBufTmVO[] vskPortDocBufTmVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortDocBufTmVO> insertVoList = new ArrayList<VskPortDocBufTmVO>();
			List<VskPortDocBufTmVO> updateVoList = new ArrayList<VskPortDocBufTmVO>();
			List<VskPortDocBufTmVO> deleteVoList = new ArrayList<VskPortDocBufTmVO>();
			for ( int i=0; i<vskPortDocBufTmVO .length; i++ ) {
				if ( vskPortDocBufTmVO[i].getIbflag().equals("I")){
					vskPortDocBufTmVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(vskPortDocBufTmVO[i]);
				} else if ( vskPortDocBufTmVO[i].getIbflag().equals("U")){
					vskPortDocBufTmVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortDocBufTmVO[i]); 
				} else if ( vskPortDocBufTmVO[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortDocBufTmVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addPortDocHourS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortDocHourS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortDocHourS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 * Saving Canal
	 * 
	 * @param VskPortCnlPassCondVO[] vskPortCnlPassCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCanel(VskPortCnlPassCondVO[] vskPortCnlPassCondVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortCnlPassCondVO> insertVoList = new ArrayList<VskPortCnlPassCondVO>();
			List<VskPortCnlPassCondVO> updateVoList = new ArrayList<VskPortCnlPassCondVO>();
			List<VskPortCnlPassCondVO> deleteVoList = new ArrayList<VskPortCnlPassCondVO>();
			for ( int i=0; i<vskPortCnlPassCondVO .length; i++ ) {
				if ( vskPortCnlPassCondVO[i].getIbflag().equals("I")){
					vskPortCnlPassCondVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(vskPortCnlPassCondVO[i]);
				} else if ( vskPortCnlPassCondVO[i].getIbflag().equals("U")){
					vskPortCnlPassCondVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortCnlPassCondVO[i]); 
				} else if ( vskPortCnlPassCondVO[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortCnlPassCondVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addPortCanelS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortCanelS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortCanelS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}

	/**
	 * Saving Canal's 2nd grid
	 * 
	 * @param VskPortCnlTrScgVO[] vskPortCnlTrScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCnlTrScg(VskPortCnlTrScgVO[] vskPortCnlTrScgVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortCnlTrScgVO> updateVoList = new ArrayList<VskPortCnlTrScgVO>();
			for ( int i=0; i<vskPortCnlTrScgVO .length; i++ ) {
				if ( vskPortCnlTrScgVO[i].getIbflag().equals("U")){
					vskPortCnlTrScgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortCnlTrScgVO[i]); 
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortCnlTrScgS(updateVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Saving Trucking
	 * 
	 * @param VskPortTrspCondVO[] vskPortTrspCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTrucking(VskPortTrspCondVO[] vskPortTrspCondVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortTrspCondVO> insertVoList = new ArrayList<VskPortTrspCondVO>();
			List<VskPortTrspCondVO> updateVoList = new ArrayList<VskPortTrspCondVO>();
			List<VskPortTrspCondVO> deleteVoList = new ArrayList<VskPortTrspCondVO>();
			for ( int i=0; i<vskPortTrspCondVO .length; i++ ) {
				if ( vskPortTrspCondVO[i].getIbflag().equals("I")){
					vskPortTrspCondVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(vskPortTrspCondVO[i]);
				} else if ( vskPortTrspCondVO[i].getIbflag().equals("U")){
					vskPortTrspCondVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortTrspCondVO[i]); 
				} else if ( vskPortTrspCondVO[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortTrspCondVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addPortTruckingS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortTruckingS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortTruckingS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving Railroad
	 * 
	 * @param VskPortTrspCondVO[] vskPortTrspCondVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortRailLoad(VskPortTrspCondVO[] vskPortTrspCondVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortTrspCondVO> insertVoList = new ArrayList<VskPortTrspCondVO>();
			List<VskPortTrspCondVO> updateVoList = new ArrayList<VskPortTrspCondVO>();
			List<VskPortTrspCondVO> deleteVoList = new ArrayList<VskPortTrspCondVO>();
			for ( int i=0; i<vskPortTrspCondVO .length; i++ ) {
				if ( vskPortTrspCondVO[i].getIbflag().equals("I")){
					vskPortTrspCondVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(vskPortTrspCondVO[i]);
				} else if ( vskPortTrspCondVO[i].getIbflag().equals("U")){
					vskPortTrspCondVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskPortTrspCondVO[i]); 
				} else if ( vskPortTrspCondVO[i].getIbflag().equals("D")){
					deleteVoList.add(vskPortTrspCondVO[i]);
				}
			}
		
			if ( insertVoList.size() > 0 ) {
				dbDao.addPortRailLoadS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortRailLoadS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePortRailLoadS(deleteVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Port Information"}).getMessage(), ex);
		}
	}
	
	/**
	 * Save Tier & Surcharge<br>
	 * 
	 * @param VskPortCnlTrScgVO[] vskPortCnlTrScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTierSurcharge(VskPortCnlTrScgVO[] vskPortCnlTrScgVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortCnlTrScgVO> tierScgVOList = new ArrayList<VskPortCnlTrScgVO>();
			for ( int i=0; i<vskPortCnlTrScgVO .length; i++ ) {
				if ( vskPortCnlTrScgVO[i].getIbflag().equals("I")){
					vskPortCnlTrScgVO[i].setCreUsrId(account.getUsr_id());
					tierScgVOList.add(vskPortCnlTrScgVO[i]); 
				}
			}

			if ( tierScgVOList.size() > 0 ) {
				dbDao.addTierSurcharge(tierScgVOList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tier Surcharge"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Tier Surcharge"}).getMessage(), ex);
		}
	}	
}
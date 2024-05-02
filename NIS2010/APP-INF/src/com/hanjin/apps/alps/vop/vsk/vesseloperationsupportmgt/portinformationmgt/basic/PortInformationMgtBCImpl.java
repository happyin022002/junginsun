/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtBCImpl.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0 
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.basic;
 
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration.PortInformationMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmRhqComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.MdmYardComboVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlTrScgListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskPortCnlTrScgVO;

/**
 * NIS2010-VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - NIS2010-VesselOperationSupportMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0004EventResponse,PortInformationMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PortInformationMgtBCImpl extends BasicCommandSupport implements PortInformationMgtBC {

	// Database Access Object
	private transient PortInformationMgtDBDAO dbDao = null;

	/**
	 * PortInformationMgtBCImpl 객체 생성<br>
	 * PortInformationMgtDBDAO를 생성한다.<br>
	 */
	public PortInformationMgtBCImpl() {
		dbDao = new PortInformationMgtDBDAO();
	}
	/**
	 * Port Information Creation에 Maneuvering 을 조회 합니다.<br>
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
	 * Port Information Creation에 Terminal Non-Working 을 조회 합니다.<br>
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
	 * Port Information Creation에 Distance 을 조회 합니다.<br>
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
	 * Port Information Creation에 Doc.&Dead Hrs 을 조회 합니다.<br>
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
	 * Port Information Creation에 Canal 을 조회 합니다.<br>
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
	 * Port Information Creation에 Canal 을 두번재 그리드 조회 합니다.<br> 
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
	 * Port Information Creation에 Canal 을 두번재 그리드 저장용 합니다.<br>
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
	 * Port Information Creation에 Trucking 을 조회 합니다.<br>
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
	 * Port Information Creation에 Railroad 을 조회 합니다.<br>
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
	 *  Maneuvering에 등록 가능한 TMNL Code을 조회(콤보생성) 합니다.<br>
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
	 * 조회 조건에서 Port Code에 해당하는 RHQ를 조회 합니다.<br>
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
	 * Doc.&Dead Hrs 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
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
	 * 등록 가능한 Port Code 을 조회(콤보생성) 합니다.<br>
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
	 * 등록 가능한 Port 을 조회(콤보생성) 합니다.<br>
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
	 * RHQ Code 을 조회 합니다.<br>
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
	 * Maneuvering 을 저장 합니다.<br>
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
	 * Terminal Non-Working 을 저장 합니다.<br>
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
	 * Distance 을 저장 합니다.<br>
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
	 * Doc.&Dead Hrs 을 저장 합니다.<br>
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
	 * Canal 을 저장 합니다.<br>
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
            throw new EventException(new ErrorHandler("COM12192", new String[]{"xxx"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"xxx"}).getMessage(), ex);
		}
	}

	/**
	 * Canal 을 두번째 그리드 저장 합니다.<br>
	 * 
	 * @param VskPortCnlTrScgVO[] vskPortCnlTrScgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortCnlTrScg(VskPortCnlTrScgVO[] vskPortCnlTrScgVO, SignOnUserAccount account) throws EventException{
		try {
			List<VskPortCnlTrScgVO> updateVoList = new ArrayList<VskPortCnlTrScgVO>();
			if(vskPortCnlTrScgVO != null){
				for ( int i=0; i<vskPortCnlTrScgVO.length; i++ ) {
						if ( vskPortCnlTrScgVO[i].getIbflag().equals("U")){
							vskPortCnlTrScgVO[i].setUpdUsrId(account.getUsr_id());
							updateVoList.add(vskPortCnlTrScgVO[i]); 
					}

				}
			}


			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortCnlTrScgS(updateVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"xxxx"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"xxxx"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Trucking 을 저장 합니다.<br>
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
	 * Railroad 을 저장 합니다.<br>
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
	
}
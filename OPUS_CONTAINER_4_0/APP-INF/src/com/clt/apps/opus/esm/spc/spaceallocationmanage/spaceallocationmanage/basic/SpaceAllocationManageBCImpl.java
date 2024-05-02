/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpaceAllocationManageBCImpl.java
*@FileTitle      : SpaceAllocationManage
*Open Issues     :
*Change history  :
*@LastModifyDate :
*@LastModifier   : 
*@LastVersion    : 

=========================================================
*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration.SpaceAllocationManageDBDAO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowAdjustmentListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchRemarkFlagOfficeVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045QtyListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcAlocCtrlOptVO;
import com.clt.syscommon.common.table.SpcAlocPolPodVO;
import com.clt.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.clt.syscommon.common.table.SpcNshwRsltVO;

/**
 * SpaceAllocationManage Business Logic Basic Command implementation<br>
 * - handling business transaction for SpaceAllocationManage<br>
 *
 * @author 
 * @see ESM_SPC_0042EventResponse,SpaceAllocationManageBC (Reference DAO Class of each)
 * @since J2EE 1.6
 */
public class SpaceAllocationManageBCImpl extends BasicCommandSupport implements SpaceAllocationManageBC {

	// Database Access Object
	private transient SpaceAllocationManageDBDAO dbDao = null;

	/**
	 * SpaceAllocationManageBCImpl Object Creation<br>
	 * SpaceAllocationManageDBDAO Object Creation<br>
	 */
	public SpaceAllocationManageBCImpl() {
		dbDao = new SpaceAllocationManageDBDAO();
	}

	/**
	 * EsmSpc0042Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return List<SpaceAllocationManageVO>
     * @exception EventException
     */		
	public List<SpaceAllocationManageVO> searchSpaceAllocationDetailList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SearchSpaceAllocation0042DetailListVO> searchSpaceAllocation0042DetailListVOs = null;
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			conditionVO.setUserOfc(account.getOfc_cd());
			conditionVO.setOfcCd(account.getOfc_cd());
			
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			
			rsList.add(rowSet);
			
			if("ALL".equals(conditionVO.getOffice())){
				searchSpaceAllocation0042DetailListVOs = dbDao.searchSpaceAllocationDetailList2(conditionVO);
			}else{
				searchSpaceAllocation0042DetailListVOs = dbDao.searchSpaceAllocationDetailList(conditionVO);
			}
			
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0042DetailListVOs(searchSpaceAllocation0042DetailListVOs);
			spaceAllocationManageVO.setRsList(rsList);
			spaceAllocationManageVO.setConditionVO(conditionVO);
			
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmSpc0042Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
     * @exception EventException
     */		
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocationMasterList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocationMasterList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmSpc0042Event save event process<br>
	 * space allocation info save<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
     * @exception EventException
     */		
	public void multiSpaceAllocation(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList1 = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList2 = new ArrayList<SpcAlocPolPodVO>();
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if(spcAlocPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPodYdCd("0000000");
				}
				if(spcAlocPolPodVO[i].getPolYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPolYdCd("0000000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocPolPodVO[i].setAlocGdt(date);
				
				spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocPolPodVO[i]);
					
					if(spcAlocPolPodVO[i].getPodYdCd().equals("0000000")) {
						if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocPolPodVO[i]);
					}
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					
					updateVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocPolPodVO[i]);
				}
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationS(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpaceAllocationS(insertVoList);
				dbDao.removemultiSpaceAllocationS(deleteVoList1);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationS(updateVoList);
			}
			
			
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if ( spcAlocPolPodVO[i].getIbflag().equals("I") || spcAlocPolPodVO[i].getIbflag().equals("U")){
					dbDao.modifymultiSpaceAllocation(spcAlocPolPodVO[i]);
				}
			}			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmSpc0042Event save event process<br>
	 * control option save<br>
	 * 
	 * @param SpcAlocCtrlOptVO[] spcAlocCtrlOptVO
	 * @param account SignOnUserAccount
     * @exception EventException
     */		
	public void multiControlOption(SpcAlocCtrlOptVO[] spcAlocCtrlOptVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcAlocCtrlOptVO> insertVoList = new ArrayList<SpcAlocCtrlOptVO>();
			List<SpcAlocCtrlOptVO> updateVoList = new ArrayList<SpcAlocCtrlOptVO>();
			List<SpcAlocCtrlOptVO> deleteVoList = new ArrayList<SpcAlocCtrlOptVO>();
			for ( int i=0; i<spcAlocCtrlOptVO .length; i++ ) {
				if ( spcAlocCtrlOptVO[i].getIbflag().equals("I")){
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("D") ? "Y":"N");
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlPortFlg());
					} else {
						spcAlocCtrlOptVO[i].setCtrlPortFlg("N");
					}
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlLvlCd());
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("Y") ? "D":"L");
					} else {
						spcAlocCtrlOptVO[i].setCtrlLvlCd("N");
					}
					
					spcAlocCtrlOptVO[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(spcAlocCtrlOptVO[i]);
				} else if ( spcAlocCtrlOptVO[i].getIbflag().equals("U")){
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("D") ? "Y":"N");
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlPortFlg(spcAlocCtrlOptVO[i].getCtrlPortFlg());
					} else {
						spcAlocCtrlOptVO[i].setCtrlPortFlg("N");
					}
					
					if(spcAlocCtrlOptVO[i].getCtrlLvlCd() != null && !spcAlocCtrlOptVO[i].getCtrlLvlCd().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlLvlCd());
					} else if(spcAlocCtrlOptVO[i].getCtrlPortFlg() != null && !spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("")) {
						spcAlocCtrlOptVO[i].setCtrlLvlCd(spcAlocCtrlOptVO[i].getCtrlPortFlg().equals("Y") ? "D":"L");
					} else {
						spcAlocCtrlOptVO[i].setCtrlLvlCd("N");
					}
					
					spcAlocCtrlOptVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(spcAlocCtrlOptVO[i]);
				} else if ( spcAlocCtrlOptVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcAlocCtrlOptVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiControlOptionS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiControlOptionS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiControlOptionS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmSpc0071Event retrieve event process<br>
	 * vessel schedule info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SearchVesselSKDListVO>
     * @exception EventException
     */		
	public List<SearchVesselSKDListVO> searchVesselSKDList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchVesselSKDList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmSpc0044Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
     * @exception EventException
     */	
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044DetailList(ConditionVO conditionVO) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SearchSpaceAllocation0044DetailListVO> searchSpaceAllocation0044DetailListVOs = null;
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			
			rsList.add(rowSet);
			
			searchSpaceAllocation0044DetailListVOs = dbDao.searchSpaceAllocation0044DetailList(conditionVO);
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0044DetailListVOs(searchSpaceAllocation0044DetailListVOs);
			spaceAllocationManageVO.setRsList(rsList);
			spaceAllocationManageVO.setConditionVO(conditionVO);
			
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmSpc0044Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
     * @exception EventException
     */		
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044MasterList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			String vvd = conditionVO.getVvd();
			if (!vvd.equals("")) {
				conditionVO.setVslCd(vvd.substring(0, 4));
				conditionVO.setSkdVoyNo(vvd.substring(4, 8));
				conditionVO.setDirCd(vvd.substring(8));
			}
			
			List<SearchSpaceAllocation0044MasterListVO> searchSpaceAllocation0044MasterListVOs = dbDao.searchSpaceAllocation0044MasterList(conditionVO);
			managerVO.setSearchSpaceAllocation0044MasterListVOs(searchSpaceAllocation0044MasterListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmSpc0044Event save event process<br>
	 * space allocation info save<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
     * @exception EventException
     */		
	public void multiSpaceAllocation0044Manage(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList1 = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList2 = new ArrayList<SpcAlocPolPodVO>();
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if(spcAlocPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPodYdCd("0000000");
				}
				if(spcAlocPolPodVO[i].getPolYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPolYdCd("0000000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocPolPodVO[i].setAlocGdt(date);
				
				spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocPolPodVO[i]);
					
					if(spcAlocPolPodVO[i].getPodYdCd().equals("0000000")) {
						if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocPolPodVO[i]);
					}
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					
					updateVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocPolPodVO[i]);
				}
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationS0044(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpaceAllocationS0044(insertVoList);
				dbDao.removemultiSpaceAllocationS0044(deleteVoList1);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationS0044(updateVoList);
			}
			
			// Remark 부분 처리
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if ( spcAlocPolPodVO[i].getIbflag().equals("I") || spcAlocPolPodVO[i].getIbflag().equals("U")){
					dbDao.modifymultiSpaceAllocation(spcAlocPolPodVO[i]);
				}
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * EsmSpc0045Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
     * @exception EventException
     */	
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045VVDList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchSpaceAllocationManage045VVDListVO> searchSpaceAllocationManage045VVDListVOs = dbDao.searchSpaceAllocationManage045VVDList(conditionVO);
			managerVO.setSearchSpaceAllocationManage045VVDListVOs(searchSpaceAllocationManage045VVDListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * EsmSpc0045Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
     * @exception EventException
     */	
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045QtyList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO1 = new SpaceAllocationManageVO();
			SpaceAllocationManageVO managerVO2 = new SpaceAllocationManageVO();
			
			String vvd = conditionVO.getVvd();
			if (vvd.length() == 9) {
				conditionVO.setVslCd(vvd.substring(0, 4));
				conditionVO.setSkdVoyNo(vvd.substring(4, 8));
				conditionVO.setSkdDirCd(vvd.substring(8));
			}
			
			conditionVO.setQtyTp("1");
			List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyListVOs1 = dbDao.searchSpaceAllocationManage045QtyList(conditionVO);
			managerVO1.setSearchSpaceAllocationManage045QtyListVOs(searchSpaceAllocationManage045QtyListVOs1);
			
			conditionVO.setQtyTp("2");
			List<SearchSpaceAllocationManage045QtyListVO> searchSpaceAllocationManage045QtyListVOs2 = dbDao.searchSpaceAllocationManage045QtyList(conditionVO);
			managerVO2.setSearchSpaceAllocationManage045QtyListVOs(searchSpaceAllocationManage045QtyListVOs2);
			
			managerVOs.add(managerVO1);
			managerVOs.add(managerVO2);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * EsmSpc0047Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
     * @exception EventException
     */	
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047DetailList(ConditionVO conditionVO) throws EventException {
		List<SpaceAllocationManageVO> spaceAllocationManageVOs = new ArrayList<SpaceAllocationManageVO>();
		List<SearchSpaceAllocation0047DetailListVO> searchSpaceAllocation0047DetailListVOs = null;
		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		
		try {
			
			DBRowSet rowSet = dbDao.searchSpaceAllocationControlFlagList(conditionVO);
			
			rsList.add(rowSet);
			
			searchSpaceAllocation0047DetailListVOs = dbDao.searchSpaceAllocation0047DetailList(conditionVO);
			
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0047DetailListVOs(searchSpaceAllocation0047DetailListVOs);
			spaceAllocationManageVO.setRsList(rsList);
			spaceAllocationManageVO.setConditionVO(conditionVO);
			
			spaceAllocationManageVOs.add(spaceAllocationManageVO);
			
			return spaceAllocationManageVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmSpc0047Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
     * @exception EventException
     */	
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047MasterList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchSpaceAllocation0047MasterListVO> searchSpaceAllocation0047MasterListVOs = dbDao.searchSpaceAllocation0047MasterList(conditionVO);
			managerVO.setSearchSpaceAllocation0047MasterListVOs(searchSpaceAllocation0047MasterListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * multiSpaceAllocation0047Manage
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
     * @exception EventException
     */	
	public void multiSpaceAllocation0047Manage(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcAlocPolPodVO> insertVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> updateVoList  = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList1 = new ArrayList<SpcAlocPolPodVO>();
			List<SpcAlocPolPodVO> deleteVoList2 = new ArrayList<SpcAlocPolPodVO>();
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if(spcAlocPolPodVO[i].getPodYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPodYdCd("0000000");
				}
				if(spcAlocPolPodVO[i].getPolYdCd().length() < 7) {
					spcAlocPolPodVO[i].setPolYdCd("0000000");
				}
				
				Calendar calendar = Calendar.getInstance();
				String date = "" + calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DATE) + " "
				                 + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
				
				spcAlocPolPodVO[i].setAlocGdt(date);
				
				spcAlocPolPodVO[i].setCreUsrId(account.getUsr_id());
				spcAlocPolPodVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcAlocPolPodVO[i].getIbflag().equals("I")){
					insertVoList.add(spcAlocPolPodVO[i]);
					
					if(spcAlocPolPodVO[i].getPodYdCd().equals("0000000")) {
						if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
							spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
						}
						deleteVoList1.add(spcAlocPolPodVO[i]);
					}
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("U")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					
					updateVoList.add(spcAlocPolPodVO[i]);
				} else if ( spcAlocPolPodVO[i].getIbflag().equals("D")){
					if(spcAlocPolPodVO[i].getTsFlg().equals("Y") && (spcAlocPolPodVO[i].getSlsOfcCd() == null || spcAlocPolPodVO[i].getSlsOfcCd().equals(""))) {
						spcAlocPolPodVO[i].setSlsOfcCd(spcAlocPolPodVO[i].getSlsRhqCd());
					}
					deleteVoList2.add(spcAlocPolPodVO[i]);
				}
			}
			
			if ( deleteVoList2.size() > 0 ) {
				dbDao.removemultiSpaceAllocationS0047(deleteVoList2);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpaceAllocationS0047(insertVoList);
				dbDao.removemultiSpaceAllocationS0047(deleteVoList1);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationS0047(updateVoList);
			}
			
			// Remark 부분 처리
			for ( int i=0; i<spcAlocPolPodVO .length; i++ ) {
				if ( spcAlocPolPodVO[i].getIbflag().equals("I") || spcAlocPolPodVO[i].getIbflag().equals("U")){
					dbDao.modifymultiSpaceAllocation(spcAlocPolPodVO[i]);
				}
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * EsmSpc0053Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0053ManageListVO>
     * @exception EventException
     */	
	public List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocationManageList(ConditionVO conditionVO) throws EventException {
		try {
			
			String vvd = conditionVO.getVvd();
			String vsl_cd = "";
			String skd_voy_no = "";
			String skd_dir_cd = "";
			if(vvd != null && vvd.length() == 9){
				vsl_cd = vvd.substring(0, 4);
				skd_voy_no = vvd.substring(4, 8);
				skd_dir_cd = vvd.substring(8);				
			}
			conditionVO.setVslCd(vsl_cd);
			conditionVO.setSkdVoyNo(skd_voy_no);
			conditionVO.setSkdDirCd(skd_dir_cd);
			List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocation0053ManageListVOs = dbDao.searchSpaceAllocationManageList(conditionVO);
			return searchSpaceAllocation0053ManageListVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * retrieve event process<br>
	 * remark info retrieve<br>
	 * 
     * @author
	 * @param String ofcCd
	 * @return String
     * @exception EventException
     */	
	public String searchRemarkFlagOffice(String ofcCd) throws EventException {
		try {			
			List<SearchRemarkFlagOfficeVO> searchRemarkFlagOfficeVOs = dbDao.searchRemarkFlagOffice(ofcCd);
			String rmkFlg = "N";
			
			if( searchRemarkFlagOfficeVOs.size() > 0) {
				rmkFlg = searchRemarkFlagOfficeVOs.get(0).getSpcCtrlAlocRmkFlg();
			}
			
			return rmkFlg;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowAdjustmentList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
				String[] rhqArr = conditionVO.getRhq().split(",");		
			
			if(rhqArr.length == 2){
				conditionVO.setRhq(rhqArr[0]);
				conditionVO.setRhq2(rhqArr[1]);
			}
			
			List<SearchNoShowAdjustmentListVO> searchNoShowAdjustmentListVOs = dbDao.searchNoShowAdjustmentList(conditionVO);
			managerVO.setSearchNoShowAdjustmentListVOs(searchNoShowAdjustmentListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowDownloadDateList(ConditionVO conditionVO) throws EventException {
		try {
			List<SpaceAllocationManageVO> managerVOs = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO managerVO = new SpaceAllocationManageVO();
			
			List<SearchNoShowDownloadDateListVO> searchNoShowDownloadDateListVOs = dbDao.searchNoShowDownloadDateList(conditionVO);
			managerVO.setSearchNoShowDownloadDateListVOs(searchNoShowDownloadDateListVOs);
			managerVOs.add(managerVO);
			return managerVOs;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcNshwRsltVO[] spcNshwRsltVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNoShowAdjustment(SpcNshwRsltVO[] spcNshwRsltVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcNshwRsltVO> insertVoList  = new ArrayList<SpcNshwRsltVO>();
			List<SpcNshwRsltVO> updateVoList  = new ArrayList<SpcNshwRsltVO>();
			List<SpcNshwRsltVO> deleteVoList  = new ArrayList<SpcNshwRsltVO>();
			for ( int i=0; i<spcNshwRsltVO .length; i++ ) {
				
				spcNshwRsltVO[i].setCreUsrId(account.getUsr_id());
				spcNshwRsltVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcNshwRsltVO[i].getIbflag().equals("I")){
					insertVoList.add(spcNshwRsltVO[i]);					
					deleteVoList.add(spcNshwRsltVO[i]);
					
				} else if ( spcNshwRsltVO[i].getIbflag().equals("U")){
					updateVoList.add(spcNshwRsltVO[i]);
					
				} else if ( spcNshwRsltVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcNshwRsltVO[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiNoShowAdjustment(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiNoShowAdjustment(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiNoShowAdjustment(deleteVoList);
			}
			
						
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiForcastDownloadDate(SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcFcastDwnLodSkdVO> insertVoList  = new ArrayList<SpcFcastDwnLodSkdVO>();
			List<SpcFcastDwnLodSkdVO> updateVoList  = new ArrayList<SpcFcastDwnLodSkdVO>();
			List<SpcFcastDwnLodSkdVO> deleteVoList  = new ArrayList<SpcFcastDwnLodSkdVO>();
			for ( int i=0; i<spcFcastDwnLodSkdVO .length; i++ ) {
				
				spcFcastDwnLodSkdVO[i].setCreUsrId(account.getUsr_id());
				spcFcastDwnLodSkdVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcFcastDwnLodSkdVO[i].getIbflag().equals("I")){
					insertVoList.add(spcFcastDwnLodSkdVO[i]);					
					deleteVoList.add(spcFcastDwnLodSkdVO[i]);
					
				} else if ( spcFcastDwnLodSkdVO[i].getIbflag().equals("U")){
					updateVoList.add(spcFcastDwnLodSkdVO[i]);
					
				} else if ( spcFcastDwnLodSkdVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcFcastDwnLodSkdVO[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiForcastDownloadDate(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiForcastDownloadDate(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiForcastDownloadDate(deleteVoList);
			}
			
					
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}


}
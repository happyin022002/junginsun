/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataBCImpl.java
*@FileTitle : Port Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic;


import java.util.List;
import java.util.ArrayList;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration.VesselScheduleMasterDataDBDAO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * VesselScheduleMasterData Business Logic Basic Command implementation<br>
 * - Handling business logic of VesselScheduleMasterData<br>
 *
 * @author 
 * @see VOP_VSK-0033EventResponse,VesselScheduleMasterDataBC, DAO
 * @since J2EE 1.4
 */
public class VesselScheduleMasterDataBCImpl extends BasicCommandSupport implements VesselScheduleMasterDataBC {

	// Database Access Object
	private transient VesselScheduleMasterDataDBDAO dbDao = null;

	/**
	 * VesselScheduleMasterDataBCImpl object creation<br>
	 * Creating VesselScheduleMasterDataBCImpl<br>
	 */
	public VesselScheduleMasterDataBCImpl() {
		dbDao = new VesselScheduleMasterDataDBDAO();
	}
	

	/**
	 * Retrieving Port
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchPortList(LocationVO locationVO) throws EventException {
		try {
			return dbDao.searchPortList(locationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Modifying Port
	 * 
	 * @param LocationVO[] locationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortList(LocationVO[] locationVOs, SignOnUserAccount account) throws EventException{
		try {
			List<LocationVO> locationVoList = new ArrayList<LocationVO>();
			if(locationVOs == null || locationVOs.length==0){
				throw new EventException(new ErrorHandler("VSK10039").getMessage());
			}
			
			int voCnt = locationVOs.length;
			for (int i=0; i<voCnt; i++) {
				locationVoList.add(locationVOs[i]);
			}
			
			if (locationVoList.size() > 0) {
				dbDao.modifyPortList(locationVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Lane Code List of Canal Agency
	 * 
	 * @return CanelRegistGRPVO
	 * @exception EventException
	 */
	public CanelRegistGRPVO searchLaneListByCanalAgency() throws EventException{
		try {
			CanelRegistGRPVO canelRegistGRPVO = new CanelRegistGRPVO();
			
			List<VendorVO> vendorVOs = dbDao.searchCanalAgencyList();
			List<CanalAgencyLaneVO> canalAgencyLaneVOs = dbDao.searchLaneListByCanalAgency();
			
			canelRegistGRPVO.setVendorVOs(vendorVOs);
			canelRegistGRPVO.setCanalAgencyLaneVOs(canalAgencyLaneVOs);
			
			return canelRegistGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Adding Lane Code List of Canal Agency
	 * 
	 * @param CanelRegistGRPVO canelRegistGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneListByCanalAgency(CanelRegistGRPVO canelRegistGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<VendorVO> vendorVOs = canelRegistGRPVO.getVendorVOs();
			List<CanalAgencyLaneVO> canalAgencyLaneVOs = canelRegistGRPVO.getCanalAgencyLaneVOs();
			
			// MDM_VENDOR
			if(vendorVOs != null){
				for(VendorVO vendorVO : vendorVOs){
					vendorVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyMdmVendor(vendorVO);
				}
			}
			
			// MDM_VSL_SVC_LANE, MDM_VSL_SVC_LANE_DIR
			if(canalAgencyLaneVOs != null){
				for(CanalAgencyLaneVO canalAgencyLaneVO : canalAgencyLaneVOs){
					// MDM_VSL_SVC_LANE
					canalAgencyLaneVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyMdmVslSvcLane(canalAgencyLaneVO);
						
					// MDM_VSL_SVC_LANE_DIR
					if(VSKGeneralUtil.isNotNull(canalAgencyLaneVO.getNorthDir())){
						canalAgencyLaneVO.setSvcScpBndCd("N");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getNorthDir());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}else{
						canalAgencyLaneVO.setSvcScpBndCd("N");
						//canalAgencyLaneVO.setSvcScpBndCd("");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getBound1());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}
					if(VSKGeneralUtil.isNotNull(canalAgencyLaneVO.getSouthDir())){
						canalAgencyLaneVO.setSvcScpBndCd("S");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getSouthDir());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}else{
						canalAgencyLaneVO.setSvcScpBndCd("S");
						//canalAgencyLaneVO.setSvcScpBndCd("");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getBound2());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}
				}
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Lane Group per User
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception EventException
	 */
	public List<UserLaneGroupVO> searchUserLaneGroup(String usrId) throws EventException {
		try {
			return dbDao.searchUserLaneGroup(usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Adding Lane Group per User
	 * 
	 * @param UserLaneGroupVO[] userLaneGroupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUserLaneGroup(UserLaneGroupVO[] userLaneGroupVOs, SignOnUserAccount account) throws EventException {
		try{
			
			for(UserLaneGroupVO userLaneGroupVO : userLaneGroupVOs){
				
				userLaneGroupVO.setUsrId(account.getUsr_id());
				userLaneGroupVO.setCreUsrId(account.getUsr_id());
				userLaneGroupVO.setUpdUsrId(account.getUsr_id());
				
				if("I".equals(userLaneGroupVO.getIbflag())){
					dbDao.addVskUsrLaneGrp(userLaneGroupVO);
				}else if("U".equals(userLaneGroupVO.getIbflag())){
					dbDao.modifyVskUsrLaneGrp(userLaneGroupVO);
				}else if("D".equals(userLaneGroupVO.getIbflag())){
					dbDao.removeVskUsrLaneGrp(userLaneGroupVO);
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Lane Group per User
	 * 
	 * @param String usrId
	 * @return List<UserLaneGroupVO>
	 * @exception EventException
	 */
	public List<UserLaneGroupVO> searchLaneGrpByUsrId(String usrId) throws EventException {
		try {
			return dbDao.searchLaneGrpByUsrId(usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}	
	
}
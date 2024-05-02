/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataBCImpl.java
*@FileTitle : Port Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.05.20 서창열
* 1.0 Creation
*
* History
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic;


import java.util.List;
import java.util.ArrayList;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration.VesselScheduleMasterDataDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-VesselScheduleMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-VesselScheduleMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK-0033EventResponse,VesselScheduleMasterDataBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class VesselScheduleMasterDataBCImpl extends BasicCommandSupport implements VesselScheduleMasterDataBC {

	// Database Access Object
	private transient VesselScheduleMasterDataDBDAO dbDao = null;

	/**
	 * VesselScheduleMasterDataBCImpl 객체 생성<br>
	 * VesselScheduleMasterDataBCImpl를 생성한다.<br>
	 */
	public VesselScheduleMasterDataBCImpl() {
		dbDao = new VesselScheduleMasterDataDBDAO();
	}
	

	/**
	 * Port 정보를 조회합니다.
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
	 * Port 정보를 수정합니다.
	 * 
	 * @param LocationVO[] locationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortList(LocationVO[] locationVOs, SignOnUserAccount account) throws EventException{
		try {
			List<LocationVO> locationVoList = new ArrayList<LocationVO>();
			if(locationVOs == null || locationVOs.length==0){
				/*
				 * MSG - 서비스 실행중 오류가 발생하였습니다.
				 */
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
	 * 운하대리점이 관리하고 있는 Lane Code 리스트 정보를 조회합니다.
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
	 * 운하대리점이 관리하고 있는 Lane Code 리스트 정보를 등록한다.
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
					// MDM_VSL_SVC_LANE, VSK_CNL_VENDOR
					if(VSKGeneralUtil.isNotNull(canalAgencyLaneVO.getCnlAgnVndrSeq())){
						canalAgencyLaneVO.setCreUsrId(account.getCre_usr_id());
						canalAgencyLaneVO.setUpdUsrId(account.getUsr_id());
						dbDao.modifyVskCanalVendor(canalAgencyLaneVO);
						dbDao.modifyMdmVslSvcLane(canalAgencyLaneVO);

					}else{
						canalAgencyLaneVO.setCreUsrId(account.getCre_usr_id());
						canalAgencyLaneVO.setUpdUsrId(account.getUsr_id());
						dbDao.deleteVskCanalVendor(canalAgencyLaneVO);
						
						dbDao.modifyMdmVslSvcLane(canalAgencyLaneVO);


					}
						
					// MDM_VSL_SVC_LANE_DIR
					if(VSKGeneralUtil.isNotNull(canalAgencyLaneVO.getNorthDir())){
						canalAgencyLaneVO.setSvcScpBndCd("N");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getNorthDir());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}else{
						canalAgencyLaneVO.setSvcScpBndCd("");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getBound1());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}
					if(VSKGeneralUtil.isNotNull(canalAgencyLaneVO.getSouthDir())){
						canalAgencyLaneVO.setSvcScpBndCd("S");
						canalAgencyLaneVO.setVslSlanDirCd(canalAgencyLaneVO.getSouthDir());
						dbDao.modifyMdmVslSvcLaneDir(canalAgencyLaneVO);
					}else{
						canalAgencyLaneVO.setSvcScpBndCd("");
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
	 * MDM Lane에 대한 사용자별 Lane Group 정보를 조회합니다.
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
	 * 사용자별 Lane Group 정보를 저장합니다.
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
	 * 사용자별 Lane Group 정보를 조회합니다.
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

	/**VOP_VSK_0021 OPEN
	 * User별 Group을 조회합니다
	 * 
	 * @param String usr_id
	 * @return List<UserDefinedLanePortGroupVO>
	 * @exception EventException
	 */
	public List<UserDefinedLanePortGroupVO> searchLanePortGroupByUserId(String usr_id) throws EventException {
		try {
			return dbDao.searchLanePortGroupByUserId(usr_id);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**VOP_VSK_9001
	 * Save user별 Lane Group 정보를 저장합니다.
	 * 
	 * @param UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUserDefinedLanePortGroup(UserDefinedLanePortGroupVO[] userDefinedLanePortGroupVOs, SignOnUserAccount account) throws EventException {
		try{
			
			
			//all data delete
			dbDao.removeUserLanePortGroupDtl(userDefinedLanePortGroupVOs[0]);
			dbDao.removeUserLanePortGroupHdr(userDefinedLanePortGroupVOs[0]);
			
			for(UserDefinedLanePortGroupVO userDefinedLanePortGroupVO : userDefinedLanePortGroupVOs){
					userDefinedLanePortGroupVO.setUsrId(account.getUsr_id());
					userDefinedLanePortGroupVO.setCreUsrId(account.getUsr_id());
					userDefinedLanePortGroupVO.setUpdUsrId(account.getUsr_id());
					userDefinedLanePortGroupVO.setUsePgmNm(userDefinedLanePortGroupVOs[0].getUsePgmNm());
					userDefinedLanePortGroupVO.setUsePgmDesc(userDefinedLanePortGroupVOs[0].getUsePgmDesc());
					userDefinedLanePortGroupVO.setDeltFlg(userDefinedLanePortGroupVOs[0].getDeltFlg());
			
					//ibflag가 D인 것 제외하고 화면에 보이는 데이터 모두 insert
					if(!"D".equals(userDefinedLanePortGroupVO.getIbflag())){
						dbDao.addUserDefinedLanePortGroupHdr(userDefinedLanePortGroupVO);
						dbDao.addUserDefinedLanePortGroupDtl(userDefinedLanePortGroupVO);
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

	/** VOP_VSK_9001 OPEN
	 * User별 Group을 조회합니다<br>
	 * 
	 * @param String usr_id
	 * @return List<UserDefinedLanePortGroupVO>
	 * @exception EventException
	 */
	public List<UserDefinedLanePortGroupVO> searchUserDefinedLanePortGroup(String usr_id) throws EventException {
		try {
			return dbDao.searchUserDefinedLanePortGroup(usr_id);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
	}	
	
}
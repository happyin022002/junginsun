/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OptimizeddistancemgtBCImpl.java
*@FileTitle : Yard Group (Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration.OptimizeddistancemgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.YardGroupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Optimizeddistancemgt Business Logic Basic Command implementation<br>
 * - NIS2010-Optimizeddistancemgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Un Jeong
 * @see UI_VSK-9515EventResponse,OptimizeddistancemgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class OptimizeddistancemgtBCImpl extends BasicCommandSupport implements OptimizeddistancemgtBC {

	// Database Access Object 
	private transient OptimizeddistancemgtDBDAO dbDao = null;

	/**
	 * OptimizeddistancemgtBCImpl 객체 생성<br>
	 * OptimizeddistancemgtDBDAO를 생성한다.<br>
	 */
	public OptimizeddistancemgtBCImpl() {
		dbDao = new OptimizeddistancemgtDBDAO();
	}
	
	/**
	 * 해당 Port에 따른 Yard Group을 조회합니다.
	 * 
	 * @param  YardGroupVO yardGroupVO
	 * @return List<YardGroupVO>
	 * @exception EventException
	 */
	public List<YardGroupVO> searchYardGroupList(YardGroupVO yardGroupVO) throws EventException {
		try {
			return dbDao.searchYardGroupList(yardGroupVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Port에 따른 Yard Group을 저장합니다.
	 * 
	 * @param  YardGroupVO[] yardGroupVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageYardGroupList	(YardGroupVO[] yardGroupVOs, SignOnUserAccount account) throws EventException {
		try {
			
			List<YardGroupVO> deleteVoList = new ArrayList<YardGroupVO>();
			List<YardGroupVO> updateVoList = new ArrayList<YardGroupVO>();

			for (int i=0; i<yardGroupVOs.length; i++) {
				if(yardGroupVOs[i].getYdGrpId().equals("")){
					deleteVoList.add(yardGroupVOs[i]);
				} else {
					yardGroupVOs[i].setUsrId(account.getUsr_id());
					updateVoList.add(yardGroupVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeYardGroupList(deleteVoList);
			} else if (updateVoList.size() > 0){
				dbDao.modifyYardGroupList(updateVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Port에 따른 Yard Group Combo List를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchYardGroupCombo(OptimizedDistanceVO optimizedDistanceVO) throws EventException {
		try {
			return dbDao.searchYardGroupCombo(optimizedDistanceVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Port에 따른 Optimized Distance 정보를 조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchOptimizedDistance(OptimizedDistanceVO optimizedDistanceVO) throws EventException {
		try {
			return dbDao.searchOptimizedDistance(optimizedDistanceVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * Optimized Distance 정보를 저장합니다.
	 * 
	 * @param  OptimizedDistanceVO[] optimizedDistanceVOs
	 * @param  List<String> keys
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOptimizedDistance	(OptimizedDistanceVO[] optimizedDistanceVOs, List<String> keys, SignOnUserAccount account) throws EventException {
		try {
			//FILE UPLOAD KEY값
			Iterator<String> keyArr = null;			
			if(keys != null) keyArr = keys.iterator();
			
			List<OptimizedDistanceVO> deleteVoList = new ArrayList<OptimizedDistanceVO>();
			List<OptimizedDistanceVO> updateVoList = new ArrayList<OptimizedDistanceVO>();
			List<OptimizedDistanceVO> insertVoList = new ArrayList<OptimizedDistanceVO>();

			log.info("\n\n optimizedDistanceVOs.length ["+optimizedDistanceVOs.length+"]");
			
			for (int i=0; i<optimizedDistanceVOs.length; i++) {
				//FILE UPLOAD KEY값 SETTING하기
				if(keyArr != null) {
					if("Y".equals(optimizedDistanceVOs[i].getFileSetYn()) && keyArr.hasNext()) 
						optimizedDistanceVOs[i].setFileSavId(keyArr.next());	 
				}
				
				
				if(optimizedDistanceVOs[i].getIbflag().equals("D")){
					deleteVoList.add(optimizedDistanceVOs[i]);
				} else if(optimizedDistanceVOs[i].getIbflag().equals("I")){
					optimizedDistanceVOs[i].setUsrId(account.getUsr_id());
					insertVoList.add(optimizedDistanceVOs[i]);
				} else if(optimizedDistanceVOs[i].getIbflag().equals("U")){
					optimizedDistanceVOs[i].setUsrId(account.getUsr_id());
					updateVoList.add(optimizedDistanceVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeOptimizedDistance(deleteVoList);
			} else if (insertVoList.size() > 0){
				dbDao.addOptimizedDistance(insertVoList);
			} else if (updateVoList.size() > 0){
				dbDao.modifyOptimizedDistance(updateVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12208", new String[]{"ETA Sending RPM Result"}).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Port에 따른 Optimized Distance정보를 조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchSlipForOptimizedDistance(OptimizedDistanceVO optimizedDistanceVO) throws EventException {
		try {
			return dbDao.searchSlipForOptimizedDistance(optimizedDistanceVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * To Port입력 시에 해당 Distance 정보를 조회합니다. 
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchToPortDistance(OptimizedDistanceVO optimizedDistanceVO) throws EventException {
		try {
			return dbDao.searchToPortDistance(optimizedDistanceVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * VMS Short 클릭 시 Target 정보를  조회 합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchTargetVmsShort(OptimizedDistanceVO optimizedDistanceVO) throws EventException {
		try {
			return dbDao.searchTargetVmsShort(optimizedDistanceVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}
	
	/**
	 * VMS Short 클릭 시 popup에서 plt_stn_desc정보를 조회합니다.
	 * 
	 * @param  OptimizedDistanceVO optimizedDistanceVO
	 * @return List<OptimizedDistanceVO>
	 * @exception EventException
	 */
	public List<OptimizedDistanceVO> searchVmsShortPltStnDesc(OptimizedDistanceVO optimizedDistanceVO) throws EventException {
		try {
			return dbDao.searchVmsShortPltStnDesc(optimizedDistanceVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
		}
	}

}
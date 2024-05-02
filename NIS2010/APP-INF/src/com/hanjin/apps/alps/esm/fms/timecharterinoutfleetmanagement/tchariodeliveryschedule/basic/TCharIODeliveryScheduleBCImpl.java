/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleBCImpl.java
*@FileTitle : Ship Yard Select – Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.20 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration.TCharIODeliveryScheduleDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomNewBldSkdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-TimeCharterInOutFleetManagement Business Logic Basic Command implementation<br>
 * - NIS2010-TimeCharterInOutFleetManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0082EventResponse,TCharIODeliveryScheduleBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TCharIODeliveryScheduleBCImpl extends BasicCommandSupport implements TCharIODeliveryScheduleBC {

	// Database Access Object
	private transient TCharIODeliveryScheduleDBDAO dbDao = null;

	/**
	 * TCharIODeliveryScheduleBCImpl 객체 생성<br>
	 * TCharIODeliveryScheduleDBDAO를 생성한다.<br>
	 */
	public TCharIODeliveryScheduleBCImpl() {
		dbDao = new TCharIODeliveryScheduleDBDAO();
	}
	
	/**
	 * Ship Yard Name를 조회한다<br>
	 * 
	 * @return List<SearchShipYardNameListVO>
	 * @exception EventException
	 */
	public List<SearchShipYardNameListVO> searchShipYardNameList() throws EventException {
		try {
			return dbDao.searchShipYardNameList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01252",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01252",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Ship Yard Name를 생성, 수정, 삭제를 한다<br>
	 * 
	 * @param customShpYdVOs CustomShpYdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageShipYardName(CustomShpYdVO[] customShpYdVOs, String usrid) throws EventException{
		try {
			List<CustomShpYdVO> addVoList = new ArrayList<CustomShpYdVO>();
			List<CustomShpYdVO> modifyVoList = new ArrayList<CustomShpYdVO>();
			List<CustomShpYdVO> removeVoList = new ArrayList<CustomShpYdVO>();
			//List<SearchDeliveryScheduleListVO> searchDeliveryScheduleListVO = null;
			
			for ( int i=0; i<customShpYdVOs .length; i++ ) {
				if ( customShpYdVOs[i].getIbflag().equals("I")){
					customShpYdVOs[i].setCreUsrId(usrid);
					customShpYdVOs[i].setUpdUsrId(usrid);
					addVoList.add(customShpYdVOs[i]);
				} else if ( customShpYdVOs[i].getIbflag().equals("U")){
					customShpYdVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customShpYdVOs[i]);
				} else if ( customShpYdVOs[i].getIbflag().equals("D")){
					removeVoList.add(customShpYdVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addShpYds(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyShpYds(modifyVoList);
			}

			if ( removeVoList.size() > 0 ) {
				// FMS_NEW_BLD_SKD 에 Ship Yard Sequence 가 있는지 검사한다.
				//searchDeliveryScheduleListVO = dbDao.searchCheckShpYdUse(removeVoList);
				
				//if (searchDeliveryScheduleListVO != null && searchDeliveryScheduleListVO.size() > 0) {
					//throw new EventException(new ErrorHandler("FMS01254",new String[]{}).getUserMessage());
				//}

				dbDao.removeShpYds(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01253",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01253",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * 인도 되어질 선박을 조회한다<br>
	 * 
	 * @param condDeliveryScheduleVO CondDeliveryScheduleVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDeliveryScheduleListVO> searchDeliveryScheduleList(CondDeliveryScheduleVO condDeliveryScheduleVO) throws EventException {
		try {
			condDeliveryScheduleVO.setVslCdSize1(condDeliveryScheduleVO.getVslCdSize1().replace(",", ""));
			condDeliveryScheduleVO.setVslCdSize2(condDeliveryScheduleVO.getVslCdSize2().replace(",", ""));
			return dbDao.searchDeliveryScheduleList(condDeliveryScheduleVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01250",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01250",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 인도되어질 선박을 생성, 수정, 삭제를 한다<br>
	 * 
	 * @param customNewBldSkdVOs CustomNewBldSkdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageDeliverySchedule(CustomNewBldSkdVO[] customNewBldSkdVOs, String usrid) throws EventException{
		try {
			List<CustomNewBldSkdVO> addVoList = new ArrayList<CustomNewBldSkdVO>();
			List<CustomNewBldSkdVO> modifyVoList = new ArrayList<CustomNewBldSkdVO>();
			List<CustomNewBldSkdVO> remofeVoList = new ArrayList<CustomNewBldSkdVO>();
			for ( int i=0; i<customNewBldSkdVOs .length; i++ ) {
				if ( customNewBldSkdVOs[i].getIbflag().equals("I")){
					customNewBldSkdVOs[i].setCreUsrId(usrid);
					customNewBldSkdVOs[i].setUpdUsrId(usrid);
					addVoList.add(customNewBldSkdVOs[i]);
				} else if ( customNewBldSkdVOs[i].getIbflag().equals("U")){
					customNewBldSkdVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customNewBldSkdVOs[i]);
				} else if ( customNewBldSkdVOs[i].getIbflag().equals("D")){
					remofeVoList.add(customNewBldSkdVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addNewBldSkds(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyNewBldSkds(modifyVoList);
			}

			if ( remofeVoList.size() > 0 ) {
				dbDao.removeNewBldSkds(remofeVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01251",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01251",new String[]{}).getMessage(), ex);
		}
	}
}
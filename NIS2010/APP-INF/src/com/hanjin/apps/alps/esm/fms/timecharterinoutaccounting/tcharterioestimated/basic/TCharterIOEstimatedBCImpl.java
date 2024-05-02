/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedBCImpl.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration.TCharterIOEstimatedDBDAO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - NIS2010-TimeCharterInOutAccounting에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Yoon, Seyeong
 * @see ESM_FMS_0046EventResponse,TCharterIOEstimatedBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TCharterIOEstimatedBCImpl extends BasicCommandSupport implements TCharterIOEstimatedBC {

	// Database Access Object
	private transient TCharterIOEstimatedDBDAO dbDao = null;

	/**
	 * TCharterIOEstimatedBCImpl 객체 생성<br>
	 * TCharterIOEstimatedDBDAO를 생성한다.<br>
	 */
	public TCharterIOEstimatedBCImpl() {
		dbDao = new TCharterIOEstimatedDBDAO();
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMmFrom String
	 * @param estRevMmTo String
	 * @param fletCtrtTpCd String
	 * @param seachTpCd String
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedRevenueList(String estRevMmFrom , String estRevMmTo , String fletCtrtTpCd, String seachTpCd) throws EventException {
		try {
			return dbDao.searchEstimatedRevenueList(estRevMmFrom, estRevMmTo, fletCtrtTpCd, seachTpCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param customEstmIfVOs CustomEstmIfVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedRevenue(CustomEstmIfVO[] customEstmIfVOs, String slpOfcCd, String usrId) throws EventException{
		try {

			List<CustomEstmIfVO> insertVoList = new ArrayList<CustomEstmIfVO>();
			CustomEstmIfVO customEstmIfVO = new CustomEstmIfVO();
			for ( int i=0; i<customEstmIfVOs .length; i++ ) {
				if ( customEstmIfVOs[i].getIbflag().equals("I")){
					customEstmIfVOs[i].setEstmSeqNo(Integer.toString(i+1));
					customEstmIfVOs[i].setSlpOfcCd(slpOfcCd);
					customEstmIfVOs[i].setSlpOfcCd(slpOfcCd);
					customEstmIfVOs[i].setEstmVvdTpCd("RV");
					customEstmIfVOs[i].setCreUsrId(usrId);
					insertVoList.add(customEstmIfVOs[i]);
					
					if (i==0) {
						customEstmIfVO = (CustomEstmIfVO)customEstmIfVOs[i].clone();
					}
				}
			}

			if ( insertVoList.size() > 0 ) {

				//입력할 월의 데이터 미리 삭제
				dbDao.removeEstimated(customEstmIfVO);
				
				dbDao.addEstimatedRevenues(insertVoList);
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01903",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01903",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMm String
	 * @return List<SearchEstimatedProRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueList(String estRevMm) throws EventException {
		try {
			return dbDao.searchEstimatedProRevenueList(estRevMm);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01900",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01900",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 결과를 등록한다<br>
	 * 
	 * @param customEstmIfVOs CustomEstmIfVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedProRevenue(CustomEstmIfVO[] customEstmIfVOs, String slpOfcCd, String usrId) throws EventException{
		try {
	
			List<CustomEstmIfVO> insertVoList = new ArrayList<CustomEstmIfVO>();
			CustomEstmIfVO customEstmIfVO = new CustomEstmIfVO();
			for ( int i=0; i<customEstmIfVOs .length; i++ ) {
				if ( customEstmIfVOs[i].getIbflag().equals("I")){
					customEstmIfVOs[i].setEstmSeqNo(Integer.toString(i+1));
					customEstmIfVOs[i].setSlpOfcCd(slpOfcCd);
					customEstmIfVOs[0].setEstmVvdTpCd("PV");
					customEstmIfVOs[i].setCreUsrId(usrId);
					insertVoList.add(customEstmIfVOs[i]);
					
					if (i==0) {
						customEstmIfVO = (CustomEstmIfVO)customEstmIfVOs[i].clone();
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {

				//입력할 월의 데이터 미리 삭제
				dbDao.removeEstimated(customEstmIfVO);

				dbDao.addEstimatedProRevenues(insertVoList);
			}
	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01901",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01901",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMmFrom String
	 * @param estRevMmTo String
	 * @param fletCtrtTpCd String
	 * @return List<SearchEstimatedHireResultListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedHireResultListVO> searchEstimatedHireResultList(String estRevMmFrom , String estRevMmTo , String fletCtrtTpCd) throws EventException {
		try {
			return dbDao.searchEstimatedHireResultList(estRevMmFrom, estRevMmTo, fletCtrtTpCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01904",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01904",new String[]{}).getMessage(), ex);
		}
	}
	
}
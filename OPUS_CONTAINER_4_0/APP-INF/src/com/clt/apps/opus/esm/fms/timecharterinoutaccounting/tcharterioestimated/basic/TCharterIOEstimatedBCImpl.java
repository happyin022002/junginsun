/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedBCImpl.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration.TCharterIOEstimatedDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.ConditionEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutAccounting<br>
 *
 * @author 
 * @see ESM_FMS_0046EventResponse,TCharterIOEstimatedBC Reference to each DAO Class
 * @since J2EE 1.6
 */
public class TCharterIOEstimatedBCImpl extends BasicCommandSupport implements TCharterIOEstimatedBC {

	// Database Access Object
	private transient TCharterIOEstimatedDBDAO dbDao = null;

	/**
	 * Generating TCharterIOEstimatedBCImpl Object<br>
	 * Generating TCharterIOEstimatedDBDAO<br>
	 */
	public TCharterIOEstimatedBCImpl() {
		dbDao = new TCharterIOEstimatedDBDAO();
	}
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedRevenueCreList(ConditionEstmIfVO conditionEstmIfVO) throws EventException {
		try {
			return dbDao.searchEstimatedRevenueCreList(conditionEstmIfVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 2015.10.26
	 * 
	 * @param searchEstimatedRevenueListVOs SearchEstimatedRevenueListVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedHireRevenue(SearchEstimatedRevenueListVO[] searchEstimatedRevenueListVOs, String slpOfcCd, String usrId) throws EventException{
		try {

			List<SearchEstimatedRevenueListVO> insertVoList = new ArrayList<SearchEstimatedRevenueListVO>();
			List<SearchEstimatedRevenueListVO> deleteVoList = new ArrayList<SearchEstimatedRevenueListVO>();

			for ( int i=0; i<searchEstimatedRevenueListVOs .length; i++ ) {
				log.debug("\ncreateEstimatedRevenue ["+i+"] IBflag ["+searchEstimatedRevenueListVOs[i].getIbflag()+"]");
				if ( !searchEstimatedRevenueListVOs[i].getIbflag().equals("D")){
					searchEstimatedRevenueListVOs[i].setEstmSeqNo(Integer.toString(i+1));
					searchEstimatedRevenueListVOs[i].setSlpOfcCd(slpOfcCd);
					//searchEstimatedRevenueListVOs[i].setEstmVvdTpCd("RV");
					searchEstimatedRevenueListVOs[i].setCreUsrId(usrId);
					insertVoList.add(searchEstimatedRevenueListVOs[i]);
					
					/*if (i==0) {
						customEstmIfVO = (CustomEstmIfVO)customEstmIfVOs[i].clone();
					}*/
				}else if("D".equals(searchEstimatedRevenueListVOs[i].getIbflag())){
					//searchEstimatedRevenueListVOs[i].setEstmVvdTpCd("RV");
					deleteVoList.add(searchEstimatedRevenueListVOs[i]);
					
				}
			}
			
			//2015.07.28 Modify exe_yrmon 한번만 돌리도록 수정함.
			//TODO : 삭제 할때 전체 삭제가 아닌 선택된 삭제 데이타만 삭제 하도록 수정 해야 함.
			String tmpExeYrmon = "";
			if(deleteVoList.size() > 0){
				for( SearchEstimatedRevenueListVO delVo: deleteVoList){
					if(!tmpExeYrmon.equals(delVo.getExeYrmon())){
						dbDao.removeEstimatedHire(delVo);
						log.debug("\ncreateEstimatedRevenue removeEstimatedHire 1st ExeYrmon["+delVo.getExeYrmon()+"]");
					}
					tmpExeYrmon = delVo.getExeYrmon();
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				//Deleting the data of month planning to insert previously
				tmpExeYrmon = "";
				for( SearchEstimatedRevenueListVO delVo: insertVoList){
					if(!tmpExeYrmon.equals(delVo.getExeYrmon())){
						dbDao.removeEstimatedHire(delVo);
						log.debug("\ncreateEstimatedRevenue removeEstimatedHire 2st ExeYrmon["+delVo.getExeYrmon()+"]");
					}
					tmpExeYrmon = delVo.getExeYrmon();
				}
				
				//2015.10.26 건 by 건 으로 Insert 한다.
				for( SearchEstimatedRevenueListVO inVo: insertVoList){
					dbDao.addEstimatedHireRevenues(inVo);
				}
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
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedProRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueList(ConditionEstmIfVO conditionEstmIfVO) throws EventException {
		try {
			return dbDao.searchEstimatedProRevenueList(conditionEstmIfVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01900",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01900",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param customEstmIfVOs CustomEstmIfVO[]
	 * @param slpOfcCd String
	 * @param usrId String
	 * @exception EventException
	 */
	public void createEstimatedProRevenue(CustomEstmIfVO[] customEstmIfVOs, String slpOfcCd, String usrId) throws EventException{
		try {
	
			List<CustomEstmIfVO> insertVoList = new ArrayList<CustomEstmIfVO>();
			List<CustomEstmIfVO> deleteVoList = new ArrayList<CustomEstmIfVO>();
			//CustomEstmIfVO customEstmIfVO = new CustomEstmIfVO();
			for ( int i=0; i<customEstmIfVOs .length; i++ ) {
				if ( !customEstmIfVOs[i].getIbflag().equals("D")){
					customEstmIfVOs[i].setEstmSeqNo(Integer.toString(i+1));
					customEstmIfVOs[i].setSlpOfcCd(slpOfcCd);
					customEstmIfVOs[i].setEstmVvdTpCd("PV");
					customEstmIfVOs[i].setCreUsrId(usrId);
					insertVoList.add(customEstmIfVOs[i]);
					
					/*if (i==0) {
						customEstmIfVO = (CustomEstmIfVO)customEstmIfVOs[i].clone();
					}*/
				}else if("D".equals(customEstmIfVOs[i].getIbflag())){
					customEstmIfVOs[i].setEstmVvdTpCd("PV");
					deleteVoList.add(customEstmIfVOs[i]);
					
				}
			}
			
			//2015.07.28 Modify exe_yrmon 한번만 돌리도록 수정함.
			String tmpExeYrmon = "";
			if(deleteVoList.size() > 0){
				for( CustomEstmIfVO delVo: deleteVoList){
					if(!tmpExeYrmon.equals(delVo.getExeYrmon())){
						dbDao.removeEstimated(delVo);
						log.debug("\ncreateEstimatedProRevenue removeEstimated ExeYrmon["+delVo.getExeYrmon()+"]");
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {

				//Deleting the data of month planning to insert previously
				//dbDao.removeEstimated(customEstmIfVO);
				tmpExeYrmon = "";
				for( CustomEstmIfVO delVo: insertVoList){
					if(!tmpExeYrmon.equals(delVo.getExeYrmon())){
						dbDao.removeEstimated(delVo);
						log.debug("\ncreateEstimatedProRevenue removeEstimated ExeYrmon["+delVo.getExeYrmon()+"]");
					}
				}

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
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedHireResultListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedHireResultListVO> searchEstimatedHireResultList(ConditionEstmIfVO conditionEstmIfVO) throws EventException {
		try {
			return dbDao.searchEstimatedHireResultList(conditionEstmIfVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01904",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01904",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage(RV)<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedResultByHireList(ConditionEstmIfVO conditionEstmIfVO) throws EventException {
		try {
			return dbDao.searchEstimatedResultByHireList(conditionEstmIfVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving data for each voyage by Charter/Hire Out costs, monthly import target voyage(PV)<br>
	 * 
	 * @param ConditionEstmIfVO conditionEstmIfVO
	 * @return List<SearchEstimatedRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchEstimatedRevenueListVO> searchEstimatedResultByProList(ConditionEstmIfVO conditionEstmIfVO) throws EventException {
		try {
			return dbDao.searchEstimatedResultByProList(conditionEstmIfVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01902",new String[]{}).getMessage(), ex);
		}
	}
	
}
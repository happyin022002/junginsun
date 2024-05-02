/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleDAO.java
*@FileTitle : Ship Yard Select – Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.20 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic.TCharIODeliveryScheduleBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomNewBldSkdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 TCharIODeliveryScheduleDAO <br>
 * - NIS2010-TimeCharterInOutFleetManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Woo-Seok
 * @see TCharIODeliveryScheduleBCImpl 참조
 * @since J2EE 1.4
 */
public class TCharIODeliveryScheduleDBDAO extends DBDAOSupport {

	/**
	 * Ship Yard Name를 조회한다<br>
	 * 
	 * @return List<SearchShipYardNameListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<SearchShipYardNameListVO> searchShipYardNameList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchShipYardNameListVO> searchShipYardNameListVOs = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsShpYdRSQL(), null, null);
			searchShipYardNameListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchShipYardNameListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchShipYardNameListVOs;
	}
	
	/**
	 * FMS_NEW_BLD_SKD 에 Ship Yard Sequence 가 있는지 검사한다<br>
	 * 
	 * @param customShpYdVO List<CustomShpYdVO>
	 * @return List<SearchShipYardNameListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<SearchDeliveryScheduleListVO> searchCheckShpYdUse(List<CustomShpYdVO> customShpYdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDeliveryScheduleListVO> searchDeliveryScheduleListVOs = null;
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<String> aryYdSeq = new ArrayList(); 
		
		for(int i = 0; i < customShpYdVO.size(); i++){
			aryYdSeq.add(customShpYdVO.get(i).getYdSeq());
		}

		velParam.put("yd_seq", aryYdSeq);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODeliveryScheduleDAOCheckShpYdUseRSQL(), null, velParam);
			searchDeliveryScheduleListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDeliveryScheduleListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDeliveryScheduleListVOs;
	}

	/**
	 * Ship Yard Name를 생성한다<br>
	 * 
	 * @param customShpYdVO List<CustomShpYdVO>
	 * @throws DAOException
	 */
	public void addShpYds(List<CustomShpYdVO> customShpYdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customShpYdVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsShpYdCSQL(), customShpYdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Ship Yard Name를 수정한다<br>
	 * 
	 * @param customShpYdVO List<CustomShpYdVO>
	 * @throws DAOException
	 */
	public void modifyShpYds(List<CustomShpYdVO> customShpYdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customShpYdVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsShpYdUSQL(), customShpYdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Ship Yard Name를 삭제한다<br>
	 * 
	 * @param customShpYdVO List<CustomShpYdVO>
	 * @throws DAOException
	 */
	public void removeShpYds(List<CustomShpYdVO> customShpYdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customShpYdVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsShpYdDSQL(), customShpYdVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 인도될 선박을 조회한다<br>
	 * 
	 * @param condDeliveryScheduleVO CondDeliveryScheduleVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDeliveryScheduleListVO> searchDeliveryScheduleList(CondDeliveryScheduleVO condDeliveryScheduleVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDeliveryScheduleListVO> searchDeliveryScheduleListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(condDeliveryScheduleVO != null){
				Map<String, String> mapVO = condDeliveryScheduleVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsNewBldSkdRSQL(), param, velParam);
			searchDeliveryScheduleListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDeliveryScheduleListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDeliveryScheduleListVO;
	 }
	 
    /**
	 * 인도될 선박을 등록한다<br>
	 * 
	 * @param customNewBldSkdVO List<CustomNewBldSkdVO>
	 * @throws DAOException
	 */
	public void addNewBldSkds(List<CustomNewBldSkdVO> customNewBldSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customNewBldSkdVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsNewBldSkdCSQL(), customNewBldSkdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 인도될 선박을 변경한다<br>
	 * 
	 * @param customNewBldSkdVO List<CustomNewBldSkdVO>
	 * @throws DAOException
	 */
	public void modifyNewBldSkds(List<CustomNewBldSkdVO> customNewBldSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customNewBldSkdVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsNewBldSkdUSQL(), customNewBldSkdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 인도될 선박을 변경한다<br>
	 * 
	 * @param customNewBldSkdVO List<CustomNewBldSkdVO>
	 * @throws DAOException
	 */
	public void removeNewBldSkds(List<CustomNewBldSkdVO> customNewBldSkdVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customNewBldSkdVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharIODeliveryScheduleDAOFmsNewBldSkdDSQL(), customNewBldSkdVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}

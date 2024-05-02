/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BSAYearlyPlanDBDAO.java
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.basic.BSAYearlyPlanBCImpl;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.BsaYearlyPlanConditionVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamProcedureVO;
import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.RsltCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BsaBudJntOpBzcVO;
import com.hanjin.syscommon.common.table.BsaBudJntOpCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrBzcVO;
import com.hanjin.syscommon.common.table.BsaBudSltChtrCrrCapaVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcCrrVO;
import com.hanjin.syscommon.common.table.BsaBudSltPrcVO;
 
/**
 * ALPS BSAYearlyPlanDBDAO <br>
 * - ALPS-BSAYearlyPlan system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see BSAYearlyPlanBCImpl 참조
 * @since J2EE 1.6
 */
public class BSAYearlyPlanDBDAO extends DBDAOSupport {
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *  - 사용 프로그램 : ESM_BSA_0040<br>
	 *  
	 * @param String bsaOpCd
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBSATableHeaderList(String bsaOpCd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(bsaOpCd != null){
				param.put("bsa_op_cd",bsaOpCd);				
			}	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchBSATableHeaderListRSQL(), param, null);
			rsVo.setDbRowset(dbRowset);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rsVo;		
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0040
	 *
	 * @param BsaYearlyPlanConditionVO vo
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBSATableJOList(BsaYearlyPlanConditionVO vo,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchBSATableJORSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0040
	 *
	 * @param BsaYearlyPlanConditionVO vo
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBSATableSCList(BsaYearlyPlanConditionVO vo,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		DBRowSet dbRowset = null;
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchBSATableSCRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;			
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addBsaBudJntOpBzc(List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpBzcVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOAddBsaBudJntOpBzcVOSCSQL(), bsaBudJntOpBzcVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpBzc(List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpBzcVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpBzcVOSUSQL(), bsaBudJntOpBzcVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] multiBsaBudJntOpCrrCapa(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int mrgCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				mrgCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOMultiBsaBudJntOpCrrCapaCSQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < mrgCnt.length; i++){
					if(mrgCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mrgCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addBsaBudJntOpCrrCapa(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOAddBsaBudJntOpCrrCapaCSQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpCrrCapa1(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa1USQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpCrrCapa2(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa2USQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSA의 HJS정보를 FNL_HJS_BSA_CAPA정보로 업데이트<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpCrrCapa3(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa3USQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSA, Weight Per TEU가 변경되었을때 TTL Weight의 값도 변경시켜준다<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpCrrCapa4(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa4USQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpCrrCapa5(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa5USQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * BSA정보가 변경되면 TTL Weight정보를 다시 계산한다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudJntOpCrrCapa6(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudJntOpCrrCapa6USQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addBsaBudSltChtrBzc(List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrBzcVOs .size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOAddBsaBudSltChtrBzcCSQL(), bsaBudSltChtrBzcVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudSltChtrBzc(List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrBzcVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudSltChtrBzcUSQL(), bsaBudSltChtrBzcVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] multiBsaBudSltChtrCrrCapa(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int mrgCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				mrgCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOMultiBsaBudSltChtrCrrCapaCSQL(), bsaBudSltChtrCrrCapaVOs,null);
				for(int i = 0; i < mrgCnt.length; i++){
					if(mrgCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mrgCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addBsaBudSltChtrCrrCapa(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOAddBsaBudSltChtrCrrCapaCSQL(), bsaBudSltChtrCrrCapaVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudSltChtrCrrCapa1(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa1USQL(), bsaBudSltChtrCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudSltChtrCrrCapa2(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa2USQL(), bsaBudSltChtrCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudSltChtrCrrCapa3(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa3USQL(), bsaBudSltChtrCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudSltChtrCrrCapa4(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa4USQL(), bsaBudSltChtrCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyBsaBudSltChtrCrrCapa5(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOModifyBsaBudSltChtrCrrCapa5USQL(), bsaBudSltChtrCrrCapaVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeBsaBudJntOpCrrCapa(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAORemoveBsaBudJntOpCrrCapaDSQL(), bsaBudJntOpCrrCapaVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeBsaBudJntOpBzc(List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudJntOpBzcVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAORemoveBsaBudJntOpBzcDSQL(), bsaBudJntOpBzcVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeBsaBudSltChtrCrrCapa(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAORemoveBsaBudSltChtrCrrCapaDSQL(), bsaBudSltChtrCrrCapaVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeBsaBudSltChtrBzc(List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bsaBudSltChtrBzcVOs .size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAORemoveBsaBudSltChtrBzcDSQL(), bsaBudSltChtrBzcVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 생성하기 위한 정보를 조회.<br>
	 * - 사용 프로그램 : ESM_BSA_0040
	 *
	 * @param BsaYearlyPlanConditionVO vo
	 * @return  DBRowSet
	 * @throws DAOException
	 */	
	public DBRowSet searchCreateBSAInfo(BsaYearlyPlanConditionVO vo) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(vo != null){
				String fm_yrwk   = vo.getTxtsdate().equals("")?"":vo.getTxtsdate().substring(0,6);
				String to_yrwk   = vo.getTxtedate().equals("")?"":vo.getTxtedate().substring(0,6);
				param.put("fm_yrwk",fm_yrwk);
				param.put("to_yrwk",to_yrwk);		
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchCreateBSAInfoRSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			log.error("err "+se.toString(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			log.error("err "+ex.toString(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
	}
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchBsaCrrRgstList() throws DAOException {

		DBRowSet dbRowset = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchBsaCrrRgstListRSQL(), null, null);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSAManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_BSA_0028
	 * 
	 * @param BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO
	 * @param List<SearchBsaCrrRgstListVO> codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchSlotCostList(BsaYearlyPlanConditionVO bsaYearlyPlanConditionVO,List<SearchBsaCrrRgstListVO> codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bsaYearlyPlanConditionVO != null){
				Map<String, String> mapVO = bsaYearlyPlanConditionVO .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchSlotCostListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_SUD_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0041
	 * 
	 * @param List<BsaBudSltPrcVO> models 
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiBsaBudSltPrc(List<BsaBudSltPrcVO> models ) throws DAOException,Exception {
		int insCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOMultiBsaBudSltPrcCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_SUD_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정)<br>
	 * - 사용 프로그램 : ESM_BSA_0041
	 * 
	 * @param List<BsaBudSltPrcCrrVO> models 
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] multiBsaBudSltPrcCrr(List<BsaBudSltPrcCrrVO> models ) throws DAOException,Exception {
		int insCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOMultiBsaBudSltPrcCrrCSQL(), models,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * BSA_BUD_SLT_PRC_CRR의 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0041
	 * 
	 * @param List<BsaBudSltPrcCrrVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBsaBudSltPrcCrr(List<BsaBudSltPrcCrrVO> models) throws DAOException,Exception {
		int delCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAORemoveBsaBudSltPrcCrrDSQL(), models, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;	
	}

	/**
	 * BSA_BUD_SLT_PRC의 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)<br>
	 * - 사용 프로그램 : ESM_BSA_0041
	 * 
	 * @param List<BsaBudSltPrcVO> models
	 * @return int[]
	 * @throws DAOException
	 */
	public int[] removeBsaBudSltPrc(List<BsaBudSltPrcVO> models) throws DAOException,Exception {
		int delCnt[] = null; 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAORemoveBsaBudSltPrcDSQL(), models, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;	
	}

	/**
	 * BSA_OP_JB, BSA_CRR_RGST테이블에서 ESM_BSA_0030의 HEADER목록을 조회한다.
	 * 
	 * @param  BsaYearlyPlanConditionVO vo
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchOpJobCarrierList(BsaYearlyPlanConditionVO vo) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchOpJobCarrierListRSQL(), param, velParam);
			
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF, BSA_VVD_PERF 테이블의 내용을 조회한다.
	 * ESM_BSA_0030
	 * @param BsaYearlyPlanConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchRevCostSwapVvdList(BsaYearlyPlanConditionVO vo, String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchRevCostSwapVvdListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * BSA_VVD_MST, BSA_VVD_CRR_PERF 테이블의 내용을 조회한다.
	 * 
	 * @param BsaYearlyPlanConditionVO vo
	 * @param String[] codeArr
	 * @return CommonBsaRsVO
	 * @throws DAOException
	 */
	public CommonBsaRsVO searchTEUPrcSwapVvdList(BsaYearlyPlanConditionVO vo, String[] codeArr) throws DAOException {
		DBRowSet dbRowset  = new DBRowSet();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);				
				velParam.putAll(mapVO);
				velParam.put("keyList",codeArr);
		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOSearchTEUPrcSwapListRSQL(), param, velParam);
			rsVo.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVo;
	}
	
	/**
	 * [Target VVD] 정보를 [조회] 합니다.<br>
	 * 
	 * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
	 * @return List<RsltCoaMonVvdYryPlnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCoaMonVvdYryPlnVO> searchYearlyPlanTargetVVDList(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCoaMonVvdYryPlnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramCoaMonVvdYryPlnVO != null){
				Map<String, String> mapVO = paramCoaMonVvdYryPlnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOCoaMonVvdYryPlnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCoaMonVvdYryPlnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	 
		
	/**
	 * 연간 계획 수립 시 사용하는 대상 항차를 생성
	 *
	 * @param ParamProcedureVO paramProcedureVO
	 * @return ParamProcedureVO
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public ParamProcedureVO createYearlyPlanTargetVVD(ParamProcedureVO paramProcedureVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ParamProcedureVO result = new ParamProcedureVO();
    	
        try{
        	resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new BSAYearlyPlanDBDAOCreateYryTargetVvdPrcCSQL(), 
        			paramProcedureVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
	        	result.setPErrorCode((String) resultMap.get("p_error_code"));
	        	result.setPErrorMsg((String) resultMap.get("p_error_msg"));
        	}
        	
        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return result;
    }
    
	
	/**
	 * 대상항차 생성 후 Flag 정보를 update
	 *
	 * @param ParamProcedureVO paramProcedureVO
	 * @return ParamProcedureVO
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public ParamProcedureVO createYearlyPlanTargetVVDUpdate(ParamProcedureVO paramProcedureVO) throws DAOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ParamProcedureVO result = new ParamProcedureVO();
    	
        try{
        	resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new BSAYearlyPlanDBDAOCreateYryVvdFlgUpdPrcCSQL(), 
        			paramProcedureVO.getColumnValues(), null);
        	
        	if ( resultMap != null) {
	        	result.setPErrCd((String) resultMap.get("p_err_cd"));
	        	result.setPErrMsg((String) resultMap.get("p_err_msg"));
        	}
        	
        }catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return result;
    }
   

    /**
	 * COA_VSL_RGST중 stnd_ldb_capa가 0인것의 갯수를 조회한다.<br>
	 * 
	 * @param ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO
	 * @return List<RsltCoaMonVvdYryPlnVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<RsltCoaMonVvdYryPlnVO> searchVslRgstCount(ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCoaMonVvdYryPlnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(paramCoaMonVvdYryPlnVO != null){
				Map<String, String> mapVO = paramCoaMonVvdYryPlnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BSAYearlyPlanDBDAOCoaVslRgstVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCoaMonVvdYryPlnVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
    
    /**
	 * BSA_BUD_JNT_OP_CRR_CAPA의 데이타를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteBsaBudJntOpCrrCapa(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudJntOpCrrCapaVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudJntOpCrrCapaVOs.get(0).getRlaneCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAODeleteBsaBudJntOpCrrCapaDSQL(), bsaBudJntOpCrrCapaVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSA_BUD_JNT_OP_BZC 데이타를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteBsaBudJntOpBzc(List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudJntOpBzcVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudJntOpBzcVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudJntOpBzcVOs.get(0).getRlaneCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAODeleteBsaBudJntOpBzcDSQL(), bsaBudJntOpBzcVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSA_BUD_JNT_OP_CRR_CAPA 데이타를 입력한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertBsaBudJntOpCrrCapa(List<BsaBudJntOpCrrCapaVO> bsaBudJntOpCrrCapaVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudJntOpCrrCapaVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudJntOpCrrCapaVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudJntOpCrrCapaVOs.get(0).getRlaneCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOInsertBsaBudJntOpCrrCapaCSQL(), bsaBudJntOpCrrCapaVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_BUD_JNT_OP_BZC 데이타를 입력한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertBsaBudJntOpBzc(List<BsaBudJntOpBzcVO> bsaBudJntOpBzcVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudJntOpBzcVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudJntOpBzcVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudJntOpBzcVOs.get(0).getRlaneCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOInsertBsaBudJntOpBzcCSQL(), bsaBudJntOpBzcVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_BUD_SLT_CHTR_CRR_CAPA의 데이타를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteBsaBudSltChtrCrrCapa(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltChtrCrrCapaVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltChtrCrrCapaVOs.get(0).getRlaneCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAODeleteBsaBudSltChtrCrrCapaDSQL(), bsaBudSltChtrCrrCapaVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSA_BUD_SLT_CHTR_BZC 데이타를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcsVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteBsaBudSltChtrBzc(List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcsVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltChtrBzcsVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltChtrBzcsVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltChtrBzcsVOs.get(0).getRlaneCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAODeleteBsaBudSltChtrBzcDSQL(), bsaBudSltChtrBzcsVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSA_BUD_SLT_CHTR_CRR_CAPA 데이타를 입력한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertBsaBudSltChtrCrrCapa(List<BsaBudSltChtrCrrCapaVO> bsaBudSltChtrCrrCapaVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltChtrCrrCapaVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltChtrCrrCapaVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltChtrCrrCapaVOs.get(0).getRlaneCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOInsertBsaBudSltChtrCrrCapaCSQL(), bsaBudSltChtrCrrCapaVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_BUD_SLT_CHTR_BZC 데이타를 입력한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertBsaBudSltChtrBzc(List<BsaBudSltChtrBzcVO> bsaBudSltChtrBzcVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltChtrBzcVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltChtrBzcVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltChtrBzcVOs.get(0).getRlaneCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOInsertBsaBudSltChtrBzcCSQL(), bsaBudSltChtrBzcVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_BUD_SLT_PRC_CRR의 데이타를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltPrcCrrVO> bsaBudSltPrcCrrVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteBsaBudSltPrcCrr(List<BsaBudSltPrcCrrVO> bsaBudSltPrcCrrVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltPrcCrrVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltPrcCrrVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltPrcCrrVOs.get(0).getRlaneCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAODeleteBsaBudSltPrcCrrDSQL(), bsaBudSltPrcCrrVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSA_BUD_SLT_PRC의 데이타를 삭제한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltPrcVO> bsaBudSltPrcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] deleteBsaBudSltPrc(List<BsaBudSltPrcVO> bsaBudSltPrcVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltPrcVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltPrcVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltPrcVOs.get(0).getRlaneCd());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAODeleteBsaBudSltPrcDSQL(), bsaBudSltPrcVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * BSA_BUD_SLT_PRC 데이타를 입력한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltPrcVO> bsaBudSltPrcVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertBsaBudSltPrc(List<BsaBudSltPrcVO> bsaBudSltPrcVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltPrcVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltPrcVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltPrcVOs.get(0).getRlaneCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOInsertBsaBudSltPrcCSQL(), bsaBudSltPrcVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * BSA_BUD_SLT_PRC_CRR 데이타를 입력한다.<br>
	 * - 사용 프로그램 : ESM_BSA_0045
	 * 
	 * @param List<BsaBudSltPrcCrrVO> bsaBudSltPrcCrrVOs
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] insertBsaBudSltPrcCrr(List<BsaBudSltPrcCrrVO> bsaBudSltPrcCrrVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(bsaBudSltPrcCrrVOs .size() > 0){
				
				velParam.put("trd_cd"  , bsaBudSltPrcCrrVOs.get(0).getTrdCd());
				velParam.put("rlane_cd", bsaBudSltPrcCrrVOs.get(0).getRlaneCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BSAYearlyPlanDBDAOInsertBsaBudSltPrcCrrCSQL(), bsaBudSltPrcCrrVOs, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
}
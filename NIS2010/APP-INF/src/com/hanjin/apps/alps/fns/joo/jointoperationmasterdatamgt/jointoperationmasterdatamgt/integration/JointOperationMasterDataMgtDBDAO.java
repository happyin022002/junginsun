/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAO.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박희동  
*@LastVersion : 1.0
* 2009.04.24 박희동
* 1.0 Creation
* 2011.02.17 남궁진호 [CHM-201108954-01] FNS_JOO_0002 : Financial Affairs Creation & Inquiry 화면의 저장 로직 수정 
*            manageCarFinancialMtrx 로직변경 : 존재유무 체크 후 false= Insert, true=update
*            checkedJooCarrier: joo_carrier 데이터 체크 메소드 추가 
* -------------------------------------------------------
* 2012.04.05 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* 1. BSA adjustment 칼럼 추가  :
* 기존 통합선복사용실적조회 화면에 있던 BSA adjustment 기능을 Basic Info 화면으로 옮겨, 
* 해당 Lane, Carrier에 일괄적으로 적용 (TEU, WT 분리하여 적용)
* 2. Add Carriers 수정 : 
* Main에서 Lane, Rep. Carrier를 신규로 생성했을 때, Add Carriers로 자동으로 저장되도록 수정
* 3. Bay plan table에서 같은 포트가 2개 이상일 경우, 가장 늦은 ETD에 해당하는 plan의 data를 적용 수정 : 
* 테스트 서버 적용된 사항 미반영 상태. 
* 모든 레인에서 같은 포트가 두 개 이상이라면 마지막에 CALLING 한 포트를 기준으로 해야 함 
* (ALX, BRSSZ & ALW, MXZLO)
* EX. ALX/ HJAA0014E : ETD 2011-10-15 data (현재 ETD 2011-10-03 data 임)
* 4. RF sub alloc 수정 : 
* Basic Info에 입력된 RF sub alloc 을 반영하여, sub alloc 보다 loading 개수가 
* 적은 경우 “0”으로 표기되도록 쿼리 수정
* 2013.05.06 김현화[CHM-201324350]BSA Information Entry 로직 추가- old_ver_no 구해 오는 로직변경. 
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AdditionalSlotManageVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BlkVygSttsVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaCarrieHistoryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BsaInformationEntryVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.BzcAgmtCrrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooStlBssPortVO;
import com.hanjin.syscommon.common.table.JooStlItmAcctVO;
import com.hanjin.syscommon.common.table.JooStlVvdVO;


/**
 * ALPS JointOperationMasterDataMgtDBDAO <br>
 * - ALPS-JointOperationMasterDataMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see JointOperationMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class JointOperationMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * Item List를 조회한다.
	 * @return List<STLItemAcctVO>
	 * @throws DAOException
	 */
	public List<STLItemAcctVO> searchSTLItemAcctList() throws DAOException {
		DBRowSet dbRowset = null;
		List<STLItemAcctVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemAcctVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, STLItemAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Settlement Item의 Account정보를 생성한다.
	 * @param JooStlItmAcctVO jooStlItmAcctVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooStlItmAcct(JooStlItmAcctVO jooStlItmAcctVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlItmAcctVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			//joo_stl_itm_acct 입력 (E)
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemAcctVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert JOO_STL_ITM_ACCT");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * JOO_STL_ITM 테이블에 정보입력한다.
	 * @param STLItemAcctVO sTLItemAcctVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooStlItm(STLItemAcctVO sTLItemAcctVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVOMst = sTLItemAcctVO.getColumnValues();

			param.putAll(mapVOMst);
			velParam.putAll(mapVOMst);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL MASTER");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * JOO_STL_ITM_ACCT테이블을 Update한다.
	 * @param JooStlItmAcctVO jooStlItmAcctVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyJooStlItmAcct(JooStlItmAcctVO jooStlItmAcctVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = jooStlItmAcctVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemAcctVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL DETAIL E");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * JOO_STL_ITM테이블을 수정한다.
	 * @param STLItemAcctVO sTLItemAcctVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyJooStlItm(STLItemAcctVO sTLItemAcctVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = sTLItemAcctVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * JOO_STL_ITM_ACCT 테이블 정보를 삭제한다.
	 * @param JooStlItmAcctVO jooStlItmAcctVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeJooStlItmAcct(JooStlItmAcctVO jooStlItmAcctVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = jooStlItmAcctVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemAcctVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL DETAIL R");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Settlement Item정보를 삭제한다.
	 * @param STLItemAcctVO sTLItemAcctVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeJooStlItm(STLItemAcctVO sTLItemAcctVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = sTLItemAcctVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSTLItemVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Financial Matrix를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return List<CarFinanMtrxVO>
	 * @throws DAOException
	 */
	public List<CarFinanMtrxVO> searchFinanMtrxList(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarFinanMtrxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOFincMtxVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarFinanMtrxVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Carrier 정보를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return CarrierVO
	 * @throws DAOException
	 */
	public CarrierVO searchCarCustVndrCd(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		CarrierVO rtnCarrierVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCarrierVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO .class);

			if (list.size() > 0){
				rtnCarrierVO = (CarrierVO)list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnCarrierVO;
	}

	/**
	 * Account Matrix를 생성하기 위해 기초정보를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return List<CarFinanMtrxVO>
	 * @throws DAOException
	 */
	public List<CarFinanMtrxVO> searchCalFinanMtrxList(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarFinanMtrxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOFincMtxTmpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarFinanMtrxVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Carrier정보의 생성 유무를 체크한다.
	 * @param CarrierVO carrierVO
	 * @return boolean
	 * @throws DAOException
	 * @throws Exception
	 */
	   public boolean checkedJooCarrier(CarrierVO carrierVO) throws DAOException {   
	       DBRowSet dbRowset = null;
	       //query parameter
	       Map<String, Object> param = new HashMap<String, Object>();
	       
	   	   boolean result = true;
	       try{
	           if(carrierVO != null){
	               Map<String, String> mapVO = carrierVO .getColumnValues();
	           
	               param.putAll(mapVO);
	           }
	           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCheckedCarrierRSQL(), param, null);
	           if(dbRowset.getRowCount() <= 0 )
					result = false;	
	           
	       } catch(SQLException se) {
	           log.error(se.getMessage(),se);
	           throw new DAOException(new ErrorHandler(se).getMessage());
	       } catch(Exception ex) {
	           log.error(ex.getMessage(),ex);
	           throw new DAOException(new ErrorHandler(ex).getMessage());
	       }
	       return result; 
	   }
	   
	/**
	 * Carrier정보를 생성한다.
	 * @param CarrierVO carrierVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addJooCarrier(CarrierVO carrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int rtnVal = 0;
		try {
			Map<String, String> mapVO = carrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCarrierVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
		} catch (SQLException se) {
			//dup이 나면 1을 return한다.
			if (se.getErrorCode() == 1){
				rtnVal = 1;
			}else{
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnVal;
	}

	/**
	 * joo_carrier table에 수정
	 * @param CarrierVO carrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooCarrier(CarrierVO carrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCarrierVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financial Matrix를 생성한다.
	 * @param CarFinanMtrxVO carFinanMtrxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooFincMtx(CarFinanMtrxVO carFinanMtrxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carFinanMtrxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOFincMtxVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financail Matrix를 수정한다.
	 * @param CarFinanMtrxVO carFinanMtrxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooFincMtx(CarFinanMtrxVO carFinanMtrxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carFinanMtrxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOFincMtxVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Financial Matrix를 삭제한다.
	 * @param CarFinanMtrxVO carFinanMtrxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooFincMtx(CarFinanMtrxVO carFinanMtrxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carFinanMtrxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOFincMtxVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Carrier의 delt_flg가 Y인 경우 Carrier와 Lane을 조건으로 모든 data 삭제한다.
	 * @param carrierVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooFincMtxByCarrierLane(CarrierVO carrierVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carrierVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOFincMtxTmpDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Carrier Merge정보를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @return List<JooCrrMrgVO>
	 * @throws DAOException
	 */
	public List<JooCrrMrgVO> searchCarrierMerge(MstComInputVO mstComInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCrrMrgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstComInputVO != null){
				Map<String, String> mapVO = mstComInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCrrMrgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooCrrMrgVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 다수의 Carrier Merge정보를 생성한다.
	 * @param jooCrrMrgVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCarrierMergeS(List<JooCrrMrgVO> jooCrrMrgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(jooCrrMrgVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCrrMrgVOCSQL(), jooCrrMrgVOs,null);
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
	 * 다건의 Carrier Merge정보를 갱신한다.
	 * @param List<JooCrrMrgVO> jooCrrMrgVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCarrierMergeS(List<JooCrrMrgVO> jooCrrMrgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(jooCrrMrgVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCrrMrgVOUSQL(), jooCrrMrgVOs,null);
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
	 * 다건의 Carrier Merge정보를 삭제한다.
	 * @param List<JooCrrMrgVO> jooCrrMrgVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCarrierMergeS(List<JooCrrMrgVO> jooCrrMrgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(jooCrrMrgVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCrrMrgVODSQL(), jooCrrMrgVOs,null);
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
	 * Carrier 정보를 조회한다.
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @throws DAOException
	 */
	public List<CarrierVO> searchVndrCustListByCar(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOVndrCustListVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Basic Port list를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @param String lsAbbr
	 * @param String lsDir 
	 * @return List<StlBssPortVO>
	 * @throws DAOException
	 */
	public List<StlBssPortVO> searchSettlementBasicPortList(MstComInputVO mstComInputVO, String lsAbbr, String lsDir) throws DAOException {
		DBRowSet dbRowset = null;
		List<StlBssPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstComInputVO != null){
				Map<String, String> mapVO = mstComInputVO.getColumnValues();
				
				mapVO.put("jo_stl_itm_cd", lsAbbr);
				mapVO.put("skd_dir_cd"   , lsDir );
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOStlBssPortVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StlBssPortVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 다건의 Basic Port정보를 생성한다.
	 * @param List<JooStlBssPortVO> jooStlBssPortVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addSettlementBasicPort(List<JooStlBssPortVO> jooStlBssPortVOs) throws DAOException,Exception {
		int rtnVal = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(jooStlBssPortVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlBssPortVOCSQL(), jooStlBssPortVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			//Duplicate Error 가 나면
			if (se.getErrorCode() == 1){
				rtnVal = se.getErrorCode();
			}else{
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * 다건의 Basic Port정보를 갱신한다.
	 * @param List<JooStlBssPortVO> jooStlBssPortVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySettlementBasicPort(List<JooStlBssPortVO> jooStlBssPortVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(jooStlBssPortVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlBssPortVOUSQL(), jooStlBssPortVOs,null);
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
	 * 다건의 Basic Port정보를 삭제한다.
	 * @param List<JooStlBssPortVO> jooStlBssPortVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSettlementBasicPort(List<JooStlBssPortVO> jooStlBssPortVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(jooStlBssPortVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlBssPortVODSQL(), jooStlBssPortVOs,null);
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
	 * Settlement Item 정보를 생성하기 위해 기초정보를 조회한다.
	 * @param MstComInputVO mstComInputVO
	 * @return List<StlBssPortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<StlBssPortVO> searchItemDirList(MstComInputVO mstComInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StlBssPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstComInputVO != null){
				Map<String, String> mapVO = mstComInputVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlBssPortCreRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StlBssPortVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Carrier, Trade, Lane으로 Carrier정보 조회한다.
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO> 
	 * @throws DAOException
	 */
	public List<CarrierVO> searchCarrierList(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCarrierRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Inquiry of Target Voyage Choose by Settlement Item
	 * @param TargetVVDVO targetVVDVO
	 * @return List<TargetVVDVO>
	 * @throws DAOException
	 */
	public List<TargetVVDVO> searchTargetVVDList(TargetVVDVO targetVVDVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TargetVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(targetVVDVO != null){
				Map<String, String> mapVO = targetVVDVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOTargetVVDVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TargetVVDVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Target VVD 생성하기 위해 기초정보를 조회한다. 
	 * @param TargetVVDVO targetVVDVO
	 * @param String joStlOptCd
	 * @return List<TargetVVDVO>
	 * @throws DAOException
	 */
	public List<TargetVVDVO> searchSKDVVDList(TargetVVDVO targetVVDVO, String joStlOptCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<TargetVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(targetVVDVO != null){
				Map<String, String> mapVO = targetVVDVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if ("B".equals(joStlOptCd)){			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOTargetVVDBoundCreRSQL(), param, velParam);
			}else if ("R".equals(joStlOptCd)){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOTargetVVDRoundCreRSQL(), param, velParam);
			}else if ("C".equals(joStlOptCd)){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOTargetVVDCycleCreRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOTargetVVDBoundCreRSQL(), param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TargetVVDVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 한건의 Target VVD를 생성한다.
	 * @param JooStlVvdVO jooStlVvdVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addTargetVVD(JooStlVvdVO jooStlVvdVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlVvdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlVvdVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 다건의 Target VVD를 수정한다.
	 * @param List<JooStlVvdVO> jooStlVvdVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTargetVVD(List<JooStlVvdVO> jooStlVvdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(jooStlVvdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlVvdVOUSQL(), jooStlVvdVOs,null);
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
	 * 다건의 Target VVD를 삭제한다.
	 * @param List<JooStlVvdVO> jooStlVvdVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeTargetVVD(List<JooStlVvdVO> jooStlVvdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(jooStlVvdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlVvdVODSQL(), jooStlVvdVOs,null);
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
	 * 입력한 Target VVD 중복체크를 위해 조회한다.
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws DAOException
	 */
	public List<JooStlVvdVO> searchTargetVvdDup(JooStlVvdVO jooStlVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooStlVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(jooStlVvdVO != null){
				Map<String, String> mapVO = jooStlVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlVvdDupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Target VVD에서 OUS인 경우 jo_mnu_nm을 Basis Port 의 jo_stl_tgt_tp_cd에서 조회한다. (TDR/RDR)
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws DAOException
	 */
	public List<JooStlVvdVO> searchOusTdrRdrInBssPort(JooStlVvdVO jooStlVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooStlVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(jooStlVvdVO != null){
				Map<String, String> mapVO = jooStlVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlBssPortOUSRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Settlement시 Target VVD의 PROC_JB_FLG를 Y로 UPDATE한다.
	 * @param List<ProcSettlementVO> procSettlementVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooStlVVDForSettlement(List<ProcSettlementVO> procSettlementVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(procSettlementVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSettlementJooStlVvdUSQL(), procSettlementVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Carrier 삭제하거나 Carrier의 Vendor정보, Customer정보를 삭제할 때 해당 Carrier로 TargetVVD에 R/E가 존재하면 삭제하는 것을 막기 위한 query임
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @throws DAOException
	 */
	public List<CarrierVO> searchChkVvdForDelCar(CarrierVO carrierVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(carrierVO != null){
				Map<String, String> mapVO = carrierVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOChkVvdForDelCarRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CarrierVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Target VVD 입력,수정시 Financial Matrix에 해당 ITEM이 존재하지 않으면 error 발생
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws DAOException
	 */
	public List<JooStlVvdVO> searchFincMtxItmForStlVvdList(JooStlVvdVO jooStlVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooStlVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(jooStlVvdVO != null){
				Map<String, String> mapVO = jooStlVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOChkFincMtxItmForStlVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
    /**
     * Authority Office Creation 의 권한정보를 조회  합니다
     * @param  AuthorityOfficeVO authorityOfficeVO
     * @return List<AuthorityOfficeVO>
     * @throws DAOException
     */
    public List<AuthorityOfficeVO> searchAuthorityOffice(AuthorityOfficeVO authorityOfficeVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<AuthorityOfficeVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(authorityOfficeVO != null){
                Map<String, String> mapVO = authorityOfficeVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchAuthorityOfficeRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, AuthorityOfficeVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    /**
     * Office Code의 Authority를 입력한다. 
     * @param  List<AuthorityOfficeVO>  authorityOfficeVOs
     * @throws DAOException
     * @throws Exception
     */
    public void addAuthorityOffice(List<AuthorityOfficeVO> authorityOfficeVOs) throws DAOException  {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(authorityOfficeVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDAOAddAuthorityOfficeCSQL(), authorityOfficeVOs, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Insert No"+ i + " SQL");
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
     * Office Code의 Authority를 삭제 한다. 
     * @param  List<AuthorityOfficeVO>  authorityOfficeVOs
     * @throws DAOException
     * @throws Exception
     */
    public void removeAuthorityOffice(List<AuthorityOfficeVO> authorityOfficeVOs) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(authorityOfficeVOs.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDAORemoveAuthorityOfficeDSQL(), authorityOfficeVOs, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Insert No"+ i + " SQL");
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
     * S/H Adjustment시 JOO_STL_VVD에 없는 VVD는 새로 생성하기 위해 조회를 해본다. 
     * @param AdjustSettlementVO adjustSettlementVO
     * @return List<AdjustSettlementVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<AdjustSettlementVO> searchStlVvdByVvd(AdjustSettlementVO adjustSettlementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdjustSettlementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(adjustSettlementVO != null){
				Map<String, String> mapVO = adjustSettlementVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchTargetVVDByVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Target VVD의 Account Year Month, Revenue/Expense, Office로 마감여부를 조회한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchCloseYn(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(jooCodeParamVO != null){
				Map<String, String> mapVO = jooCodeParamVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOApPeriodChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
    /**
     * Office Mapping 정보 조회 합니다
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return List<CustomSearchOfficeMappingManagementVO>
     * @throws DAOException
     */
    public List<CustomSearchOfficeMappingManagementVO> searchOfficeMappingManagementList(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<CustomSearchOfficeMappingManagementVO> list = null;
        //query parameter;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter;
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(customSearchOfficeMappingManagementVO != null){
                Map<String, String> mapVO = customSearchOfficeMappingManagementVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCustomSearchOfficeMappingManagementVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomSearchOfficeMappingManagementVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
     * Office Mapping 정보 Dup Check 조회 합니다
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return String
     * @throws DAOException
     */
    public String searchOfficeMappingDupCheck(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnValue = "";        
        //query parameter;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter;
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(customSearchOfficeMappingManagementVO != null){
                Map<String, String> mapVO = customSearchOfficeMappingManagementVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCngOfcDupCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString(1);
			} else{
				rtnValue = "";
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnValue;
    }
    
    /**
     * Office Mapping 정보를 저장 합니다.<br> 
     * @param  List<CustomSearchOfficeMappingManagementVO>  customSearchOfficeMappingManagementVOs
     * @return int
     * @throws DAOException
     * @throws Exception
     */
    public int addOfficeMappingManagement(List<CustomSearchOfficeMappingManagementVO> customSearchOfficeMappingManagementVOs) throws DAOException  {
    	int iRtn = 0;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(customSearchOfficeMappingManagementVOs.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCngOfcCSQL(), customSearchOfficeMappingManagementVOs, null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to Insert No"+ i + " SQL");
                }
            }
 
        } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return iRtn;
    }
    
    /**
     * Office Mapping 정보를 수정 합니다.<br> 
     * @param  List<CustomSearchOfficeMappingManagementVO>  customSearchOfficeMappingManagementVOs
     * @throws DAOException
     * @throws Exception
     */
	public void modifyOfficeMappingManagement(List<CustomSearchOfficeMappingManagementVO> customSearchOfficeMappingManagementVOs) throws DAOException,Exception {
		try {
			if(customSearchOfficeMappingManagementVOs != null && customSearchOfficeMappingManagementVOs.size() > 0) {

				Map<String, String> mapVO = new HashMap<String, String>();
		        //velocity parameter;
		        Map<String, Object> velParam = new HashMap<String, Object>();
		        
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				for (int k = 0; k < customSearchOfficeMappingManagementVOs.size(); k++) {
	                mapVO = customSearchOfficeMappingManagementVOs.get(k).getColumnValues();
	                velParam.putAll(mapVO);
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCngOfcUSQL(), customSearchOfficeMappingManagementVOs, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다음 Ref No 를 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchNextJoRefNo(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String joRefNo = "";
		try{
            if(cusBzcAgmtVO != null){
                Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetNextJoRefNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
			if (list.isEmpty()){
	            if(cusBzcAgmtVO != null){ 				
	            	joRefNo = cusBzcAgmtVO.getOfcCd()+"-"+cusBzcAgmtVO.getReDivrCd()+"-"+cusBzcAgmtVO.getTrdCd()+"-"+cusBzcAgmtVO.getRlaneCd()+"-"+DateTime.getFormatString("yyyyMM").substring(2)+"-"+"001";
	            }
			}else{
				joRefNo = list.get(0).getJoRefNo();
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return joRefNo;
	}

	/**
	 * 다음 Ref Seq 를 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchNextJoRefSeq(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String joRefSeq = "1";
		try{
            if(cusBzcAgmtVO != null){
                Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetNextJoRefSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
			if (list.isEmpty()){
				joRefSeq = "1";
			}else{
				joRefSeq = list.get(0).getJoRefSeq();
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return joRefSeq;
	}

	/**
	 * JOO_BZC_AGMT에 Data입력한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooBzcAgmt(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooBzcAgmtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * JOO_BZC_AGMT 수정한다.
	 * @param List<CusBzcAgmtVO> cusBzcAgmtVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooBzcAgmt(List<CusBzcAgmtVO> cusBzcAgmtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cusBzcAgmtVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooBzcAgmtUSQL(), cusBzcAgmtVOs,null);
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
	 * JOO_BZC_AGMT를 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws DAOException
	 */
	public List<CusBzcAgmtVO> searchJooBzcAgmtList(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCusBzcAgmtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * JOO_BZC_AGMT의 Ref.NO List를 조회한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchRefNoList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetRefNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 기간이 겹치는 REF_NO가 있는지 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws DAOException
	 */
	public List<CusBzcAgmtVO> searchOverlappedRefNoList(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCheckPeriodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 같은 조건의 ref no가 있으면 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws DAOException
	 */
	public List<CusBzcAgmtVO> searchRefNo(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetJoRefNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 같은 OFFICE, R/E, TRADE, RLANE 인 경우 PERIOD가 같으므로 조회하여 Setting한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws DAOException
	 */
	public List<CusBzcAgmtVO> searchRefNoNPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetRefNoNPeriodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * JOO_BZC_AGMT에 Data입력한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooBzcAgmtPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooBzcAgmtPeriodUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Add Carriers list를 조회한다.
	 * @param BzcAgmtCrrVO bzcAgmtCrrVO
	 * @return List<BzcAgmtCrrVO>
	 * @throws DAOException
	 */
	public List<BzcAgmtCrrVO> searchAddCarriersList(BzcAgmtCrrVO bzcAgmtCrrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BzcAgmtCrrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bzcAgmtCrrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBzcAgmtCrrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BzcAgmtCrrVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * 중복된 Add Carriers list를 조회한다.
	 * @param BzcAgmtCrrVO bzcAgmtCrrVO
	 * @return List<BzcAgmtCrrVO>
	 * @throws DAOException
	 */
	public List<BzcAgmtCrrVO> searchAddCarrierList(BzcAgmtCrrVO bzcAgmtCrrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BzcAgmtCrrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bzcAgmtCrrVO.getColumnValues();
 
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOChkBzcAgmtCrrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BzcAgmtCrrVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
    /**
     * ADD Carriers의 신규Carriers를 입력한다. 
     * @param  List<BzcAgmtCrrVO> bzcAgmtCrrVOs
	 * @return int
     * @throws DAOException
     * @throws Exception
     */
	public int addCarriers(List<BzcAgmtCrrVO> bzcAgmtCrrVOs) throws DAOException,Exception {
		int rtnVal = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(bzcAgmtCrrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBzcAgmtCrrCSQL(), bzcAgmtCrrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			//Duplicate Error 가 나면
			if (se.getErrorCode() == 1){
				rtnVal = se.getErrorCode();
			}else{
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){    
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
    
	/**
	 * ADD Carriers 수정한다.
	 * @param List<BzcAgmtCrrVO> bzcAgmtCrrVOs
	 * @throws DAOException
	 * @throws Exception   
	 */
	public void modifyCarriers(List<BzcAgmtCrrVO> bzcAgmtCrrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(bzcAgmtCrrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBzcAgmtCrrVOUSQL(), bzcAgmtCrrVOs,null);
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
	 * ADD Carriers 삭제한다.
	 * @param List<BzcAgmtCrrVO> bzcAgmtCrrVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteCarriers(List<BzcAgmtCrrVO> bzcAgmtCrrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(bzcAgmtCrrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBzcAgmtCrrVODSQL(), bzcAgmtCrrVOs,null);
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
	 * 중복된 Add Carriers Chk list를 조회한다.
	 * @param CusBzcAgmtVO cusBzcAgmtVO
	 * @return List<CusBzcAgmtVO>
	 * @throws DAOException
	 */
	public List<CusBzcAgmtVO> searchAddCarrierListChk(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusBzcAgmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
 
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOChkCusBzcAgmtCrrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
    /**
     * ADD Carriers의 신규Carriers를 입력한다. 
     * @param  List<CusBzcAgmtVO> cusBzcAgmtVO
	 * @return int
     * @throws DAOException
     * @throws Exception
     */
	public int addCarriersII(List<CusBzcAgmtVO> cusBzcAgmtVO) throws DAOException,Exception {
		int rtnVal = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cusBzcAgmtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCusBzcAgmtCrrCSQL(), cusBzcAgmtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			//Duplicate Error 가 나면
			if (se.getErrorCode() == 1){
				rtnVal = se.getErrorCode();
			}else{
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){    
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
    /**
     * ADD Carriers의 Represent 변경으로 전체를 삭제한다. 
     * @param  List<CusBzcAgmtVO> cusBzcAgmtVO
     * @throws DAOException
     * @throws Exception
     */
	public void deleteAllCarriers(List<CusBzcAgmtVO> cusBzcAgmtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cusBzcAgmtVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDAORemoveAddCarrierDSQL(), cusBzcAgmtVO, null);
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
	 * BSA Information Entry를 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryList(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaInformationEntryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationEntryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaInformationEntryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * YYYY-WW, Date 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BsaInformationEntryVO> searchBsaInformationYyyyWwDt(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaInformationEntryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationYyyyWwDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaInformationEntryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * BSA Information Entry를 조회한다.   Target Excel을 위한 조회
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryListForTargetExcel(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaInformationEntryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationEntryListForTargetExcelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaInformationEntryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * BSA Information Entry를 조회한다.   Target Excel을 위한 조회(동일 노선 이중 Trade인 경우)
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryListForTargetExcelDulTrd(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaInformationEntryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationEntryListForTargetExcelDulTrdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaInformationEntryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
//	/**
//	 * New Version을 얻는다.<br>
//	 *
//	 * @param String vslCd
//	 * @param String skdDirCd
//	 * @param String portCd
//	 * @param String portSeq
//	 * @param String joCrrCd
//	 * @param String rlaneCd
//	 * @return String 
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	//2013.09.30 로즈불일치
//	public String searchBsaInformationEntryVersionChk(String vslCd,String skdDirCd,String portCd,String portSeq,String joCrrCd, String rlaneCd) throws DAOException {
//		DBRowSet dbRowset = null;
//		String rtnValue = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try {
//			param.put("vsl_cd", vslCd);
//			param.put("skd_dir_cd", skdDirCd);
//			param.put("port_cd", portCd);
//			param.put("port_seq", portSeq);
//			param.put("jo_crr_cd", joCrrCd);
//			param.put("rlane_cd", rlaneCd);
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryVersionChkRSQL(), param, null);
//			if(dbRowset.next()) {
//				rtnValue = dbRowset.getString("JO_VER_NO");
//			}
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return rtnValue;
//	}

//	/**
//	 * Before Version의 END VVD, Port 정보를 가지고 온다<br>
//	 *
//	 * @param BsaInformationParmVO bsaInformationParmVO
//	 * @return String 
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	 //2013.09.30 로즈 불일치
//	public String searchBsaInformationEntryJoBeforeVVD(BsaInformationParmVO bsaInformationParmVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		String rtnValue = null;
//		
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try {
//
//			param.put("vsl_cd", bsaInformationParmVO.getVslCd());
//			param.put("skd_dir_cd", bsaInformationParmVO.getSkdDirCd());
//			param.put("port_cd", bsaInformationParmVO.getPortCd());
//			param.put("port_seq", bsaInformationParmVO.getPortSeq());
//			param.put("jo_crr_cd", bsaInformationParmVO.getJoCrrCd());
//			param.put("rlane_cd", bsaInformationParmVO.getRlaneCd());
//			param.put("old_jo_ver_no", bsaInformationParmVO.getOldJoVerNo()); 
//			param.put("jo_st_skd_voy_no", bsaInformationParmVO.getJoStSkdVoyNo());
//			param.put("jo_end_skd_voy_no", bsaInformationParmVO.getJoEndSkdVoyNo());
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOsearchBsaInformationEntryJoBeforeVVDRSQL(), param, null);
//			if(dbRowset.next()) {
//				rtnValue = dbRowset.getString("JO_END_VSL_CD");
//			}
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return rtnValue;
//	}	
	
	
	
	
	/**
	 * New JoBsaRefSeq를 얻는다.<br>
	 * @param String joBsaRefNo
	 * @return String
	 * @exception DAOException
	 * @throws Exception
	 */
	public String searchBsaInformationEntryJoBsaRefSeq(String joBsaRefNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("jo_bsa_ref_no", joBsaRefNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryJoBsaRefSeqRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("JO_BSA_REF_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	

	/**
	 * BSA Information Entry를 등록한다.
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBsaInformationEntryList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOAddBsaInformationEntryCSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BSA Information Entry를 등록한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBsaInformationEntry(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOAddBsaInformationEntryCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	
	/**
	 * BSA Information Entry를 수정한다.
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyBsaInformationEntryList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOModifyBsaInformationEntryUSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BSA Information Entry를 History 저장 한다.
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBsaInformationEntryHisList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationEntryHisCSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BSA Information Entry를 History 저장 한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBsaInformationEntryHis(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationEntryHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
		
	/**
	 * BSA Information Entry를 삭제한다.(DELT_FLG만 "Y"로 업데이트)
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeBsaInformationEntryList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAORemoveBsaInformationEntryUSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BSA Information Entry를 삭제한다.(데이터를 삭제한다.)
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteBsaInformationEntryList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAODeleteBsaInformationEntryDSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * BSA Information Entry를 삭제한다.(데이터를 삭제한다.)
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteBsaInformationEntry(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {	
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAODeleteBsaInformationEntryDSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_BSA_AGMT");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}	
	
	
	/**
	 * BSA Information Entry Histroy를 조회한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @return List<BsaInformationEntryVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BsaInformationEntryVO> searchBsaInformationEntryHistoryList(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaInformationEntryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBsaInformationEntryHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaInformationEntryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * BSA Information Entry Histroy를 조회한다.
	 * @param BsaCarrieHistoryVO bsaCarrieHistoryVO
	 * @return List<BsaCarrieHistoryVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BsaCarrieHistoryVO> searchAddBsaCarrieList(BsaCarrieHistoryVO bsaCarrieHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BsaCarrieHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bsaCarrieHistoryVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchAddBsaCarrieHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BsaCarrieHistoryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * New JoBsaRefSeq를 얻는다.<br>
	 *
	 * @param String joBsaRefNo
	 * @return String
	 * @exception DAOException
	 * @throws Exception
	 */
	public String searchBsaCarrieListChk(String joBsaRefNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("jo_bsa_ref_no", joBsaRefNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchAddBsaCarrieHistoryChkRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("JO_BSA_ADD_REF_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	
	
	/**
	 * Add BSA Carrier를 수정한다.
	 * @param List<BsaCarrieHistoryVO> bsaCarrieHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyBsaCarrieList(List<BsaCarrieHistoryVO> bsaCarrieHistoryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaCarrieHistoryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOModifyBsaCarrieListUSQL(), bsaCarrieHistoryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Add BSA Carrier를 신규입력 등록 한다.
	 * @param List<BsaCarrieHistoryVO> bsaCarrieHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBsaCarrieList(List<BsaCarrieHistoryVO> bsaCarrieHistoryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaCarrieHistoryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOAddBsaCarrieListCSQL(), bsaCarrieHistoryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Add BSA Carrier를 Key값에 해당하는 데이터를 삭제 한다.
	 * @param BsaCarrieHistoryVO bsaCarrieHistoryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void delBsaCarrieList(BsaCarrieHistoryVO bsaCarrieHistoryVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
	
			Map<String, String> mapVO = bsaCarrieHistoryVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			//
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAODelBsaCarrieListDSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_ADD_BSA_COPY");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Excel Add BSA Carrier를 신규입력 등록 한다.
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addExcelBsaCarrieList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOAddExcelBsaCarrieListCSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Excel Add BSA Carrier를 Key값에 해당하는 데이터를 삭제 한다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void delExcelBsaCarrieList(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
	
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			//
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAODelBsaCarrieListDSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete JOO_ADD_BSA_COPY");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	
	/**
	 * Add BSA Carrier를 수정한다.
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyExcelBsaCarrieList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOModifyExcelBsaCarrieListUSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Before Version의 END VVD, Port 정보를 가지고 온다<br>
	 *
	 * @param String joBsaRefNo
	 * @param String joCrrCd
	 * @return String 
	 * @throws DAOException
	 * @throws Exception
	 */
	 
	public String searchBsaInformationEntryExistRefNo(String joBsaRefNo, String joCrrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("jo_bsa_ref_no", joBsaRefNo);
			param.put("jo_crr_cd", joCrrCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryExistRefNoRSQL(), param, null);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("JO_BSA_REF_NO");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * Add Carrier의 TEU값을 Main 테이블의 JO_BSA_ADD_TEU_QTY 값에 Update 해주고, JO_ADD_BSA_CRR_FLG 값을 "N"으로 Update 한다.
	 *
	 * @param List<BsaInformationEntryVO> bsaInformationEntryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	 
	public void modifyAddBsaCarrieList(List<BsaInformationEntryVO> bsaInformationEntryVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bsaInformationEntryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOModifyAddBsaCarrieListUSQL(), bsaInformationEntryVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
//	/**
//	 * Before Version의 END VVD Voyage와 신규입력된 START Voyage를 check 함.<br>
//	 *
//	 * @param BsaInformationParmVO bsaInformationParmVO
//	 * @return String 
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	 //2013. 09.30 로즈 불일치 작업
//	public String checkVoyage(BsaInformationParmVO bsaInformationParmVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		String rtnValue = null;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			
//			param.put("vsl_cd", bsaInformationParmVO.getVslCd());
//			param.put("skd_dir_cd", bsaInformationParmVO.getSkdDirCd());
//			param.put("port_cd", bsaInformationParmVO.getPortCd());
//			param.put("port_seq", bsaInformationParmVO.getPortSeq());
//			param.put("jo_crr_cd", bsaInformationParmVO.getJoCrrCd());
//			param.put("rlane_cd", bsaInformationParmVO.getRlaneCd());
//			param.put("old_jo_ver_no", bsaInformationParmVO.getOldJoVerNo()); 
//			param.put("jo_st_skd_voy_no", bsaInformationParmVO.getJoStSkdVoyNo());
//			param.put("jo_end_skd_voy_no", bsaInformationParmVO.getJoEndSkdVoyNo());
//			velParam.put("old_jo_ver_no",bsaInformationParmVO.getOldJoVerNo()); 
//			velParam.put("jo_st_skd_voy_no",bsaInformationParmVO.getJoStSkdVoyNo());
//			velParam.put("jo_end_skd_voy_no", bsaInformationParmVO.getJoEndSkdVoyNo());
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCheckVoyageRSQL(), param, velParam);
//			if(dbRowset.next()) {
//				rtnValue = dbRowset.getString("VOY_CHK");
//			}
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return rtnValue;
//	}			
//	/**
//	 * Before  last Version을 찾음<br>
//	 *
//	 * @param BsaInformationParmVO bsaInformationParmVO
//	 * @return String 
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	 //2013.09.30 로즈 불일치
//	public String searchBsaInformationEntryLastVersion(BsaInformationParmVO bsaInformationParmVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		String rtnValue = null;
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try {
//			param.put("vsl_cd", bsaInformationParmVO.getVslCd());
//			param.put("skd_dir_cd", bsaInformationParmVO.getSkdDirCd());
//			param.put("port_cd", bsaInformationParmVO.getPortCd());
//			param.put("port_seq", bsaInformationParmVO.getPortSeq());
//			param.put("jo_crr_cd", bsaInformationParmVO.getJoCrrCd());
//			param.put("rlane_cd", bsaInformationParmVO.getRlaneCd());
//			param.put("jo_ver_no",bsaInformationParmVO.getJoVerNo());
//            if ("U".equals(bsaInformationParmVO.getIbflag())){
//            	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryLastVersionForUpdateRSQL(), param, null);
//            }else{
//			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOSearchBsaInformationEntryLastVersionRSQL(), param, null);
//            }
//			if(dbRowset.next()) {
//				rtnValue = dbRowset.getString("OLD_JO_VER_NO");
//			}
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return rtnValue;
//	}	
	
	/**
	 * BSA Entry화면에서 Row Copy시 Add BSA 정보를 자동으로 생성해준다.
	 * @param BsaInformationEntryVO bsaInformationEntryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	
	public void addBsaAddTeuQtyCopy(BsaInformationEntryVO bsaInformationEntryVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
	
			Map<String, String> mapVO = bsaInformationEntryVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			//
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOAddBsaAddTeuQtyCopyCSQL(), mapVO, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert JOO_ADD_BSA_COPY");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Additional Slot Manage정보를 조회한다.
	 * @param AdditionalSlotManageVO additionalSlotManageVO
	 * @return List<AdditionalSlotManageVO>
	 * @throws DAOException
	 */
	public List<AdditionalSlotManageVO> searchAdditionalSlotManage(AdditionalSlotManageVO additionalSlotManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AdditionalSlotManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(additionalSlotManageVO != null){
				Map<String, String> mapVO = additionalSlotManageVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooAddSlotMgrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AdditionalSlotManageVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 다수의 Additional Slot Manage정보를 생성한다.
	 * @param additionalSlotManageVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAdditionalSlotManageS(List<AdditionalSlotManageVO> additionalSlotManageVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(additionalSlotManageVOs.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOCSQL(), additionalSlotManageVOs,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
			
			//201408 민정호
			//executeBatch로 하면 ORA-00604: 순환 SQL 레벨 1 에 오류가 발생했습니다
			//								  ORA-06502: PL/SQL: 수치 또는 값 오류: 문자열 버퍼가 너무 작습니다 \
			//에러 발생하므로 아래로 변경
			if(additionalSlotManageVOs.size() > 0){				
				for (int i = 0; i < additionalSlotManageVOs.size(); i++)
				{
					sqlExe.executeUpdate((ISQLTemplate) new JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOCSQL(),
							additionalSlotManageVOs.get(i).getColumnValues(), null);
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
	 * 다건의 Additional Slot Manage정보를 갱신한다.
	 * @param List<AdditionalSlotManageVO> additionalSlotManageVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyAdditionalSlotManageS(List<AdditionalSlotManageVO> additionalSlotManageVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(additionalSlotManageVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooAddSlotMgrVOUSQL(), additionalSlotManageVOs,null);
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
	 * 다건의 Additional Slot Manage정보를 삭제한다.
	 * @param List<AdditionalSlotManageVO> additionalSlotManageVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeAdditionalSlotManageS(List<AdditionalSlotManageVO> additionalSlotManageVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(additionalSlotManageVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooAddSlotMgrVODSQL(), additionalSlotManageVOs,null);
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
	 * 다수의 Blank Voyage Status 정보를 생성한다.
	 * @param blkVygSttsVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBlankVoyageStatus(List<BlkVygSttsVO> blkVygSttsVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(blkVygSttsVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new JointOperationMasterDataMgtDBDAOBlankVoyageStatusCSQL(), blkVygSttsVOs, null);
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
	 * 다건의 Blank Voyage Status 정보를 갱신한다. ( Delete Flag = 'D' Update 도 포함)
	 * @param List<BlkVygSttsVO> blkVygSttsVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyBlankVoyageStatus(List<BlkVygSttsVO> blkVygSttsVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(blkVygSttsVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBlankVoyageStatusUSQL(), blkVygSttsVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Blank Voyage Status정보를 조회한다.
	 * @param BlkVygSttsVO blkVygSttsVO
	 * @return List<BlkVygSttsVO>
	 * @throws DAOException
	 */
	public List<BlkVygSttsVO> searchBlankVoyageStatus(BlkVygSttsVO blkVygSttsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlkVygSttsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blkVygSttsVO != null){
				Map<String, String> mapVO = blkVygSttsVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOBlankVoyageStatusRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlkVygSttsVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	} 
	
	/**
	 * VVD & ITEM 2년전까지 비교한다.
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws DAOException
	 */
	public List<JooStlVvdVO> searchTargetVvdDup2(JooStlVvdVO jooStlVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooStlVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(jooStlVvdVO != null){
				Map<String, String> mapVO = jooStlVvdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooStlVvdDup2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Settlement PIC를 저장한다.
	 * 
	 * @param CarFinanMtrxVO carFinanMtrxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPic(CarFinanMtrxVO carFinanMtrxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carFinanMtrxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOPicUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Settlement Pic를 삭제한다.
	 * 
	 * @param CarFinanMtrxVO carFinanMtrxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePic(CarFinanMtrxVO carFinanMtrxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = carFinanMtrxVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm 입력
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOPicDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
}

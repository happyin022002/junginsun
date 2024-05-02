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
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic.JointOperationMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.JooCrrMrgVO;
import com.clt.syscommon.common.table.JooStlBssPortVO;
import com.clt.syscommon.common.table.JooStlItmAcctVO;
import com.clt.syscommon.common.table.JooStlVvdVO;


/**
 * OPUS JointOperationMasterDataMgtDBDAO <br>
 * - OPUS-JointOperationMasterDataMgtSC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
//    public List<CustomSearchOfficeMappingManagementVO> searchOfficeMappingManagementList(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws DAOException {
//        DBRowSet dbRowset = null;
//        List<CustomSearchOfficeMappingManagementVO> list = null;
//        //query parameter;
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter;
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            if(customSearchOfficeMappingManagementVO != null){
//                Map<String, String> mapVO = customSearchOfficeMappingManagementVO.getColumnValues();
//                param.putAll(mapVO);
//                velParam.putAll(mapVO);
//            }
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCustomSearchOfficeMappingManagementVORSQL(), param, velParam);
//            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomSearchOfficeMappingManagementVO.class);
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//        return list;
//    }

    /**
     * Office Mapping 정보 Dup Check 조회 합니다
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return String
     * @throws DAOException
     */
//    public String searchOfficeMappingDupCheck(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws DAOException {
//        DBRowSet dbRowset = null;
//        String rtnValue = "";        
//        //query parameter;
//        Map<String, Object> param = new HashMap<String, Object>();
//        //velocity parameter;
//        Map<String, Object> velParam = new HashMap<String, Object>();
//
//        try{
//            if(customSearchOfficeMappingManagementVO != null){
//                Map<String, String> mapVO = customSearchOfficeMappingManagementVO.getColumnValues();
//                param.putAll(mapVO);
//                velParam.putAll(mapVO);
//            }
//            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCngOfcDupCheckRSQL(), param, velParam);
//			if (dbRowset.next()) {
//				rtnValue = dbRowset.getString(1);
//			} else{
//				rtnValue = "";
//			}
//        }catch(SQLException se){
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//        return rtnValue;
//    }
    
    /**
     * Office Mapping 정보를 저장 합니다.<br> 
     * @param  List<CustomSearchOfficeMappingManagementVO>  customSearchOfficeMappingManagementVOs
     * @return int
     * @throws DAOException
     * @throws Exception
     */
//    public int addOfficeMappingManagement(List<CustomSearchOfficeMappingManagementVO> customSearchOfficeMappingManagementVOs) throws DAOException  {
//    	int iRtn = 0;
//        try {
//            SQLExecuter sqlExe = new SQLExecuter("");
//            int insCnt[] = null;
//            if(customSearchOfficeMappingManagementVOs.size() > 0){
//                insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCngOfcCSQL(), customSearchOfficeMappingManagementVOs, null);
//                for(int i = 0; i < insCnt.length; i++){
//                    if(insCnt[i]== Statement.EXECUTE_FAILED)
//                        throw new DAOException("Fail to Insert No"+ i + " SQL");
//                }
//            }
// 
//        } catch (SQLException se) {
//	        log.error(se.getMessage(),se);
//	        throw new DAOException(new ErrorHandler(se).getMessage());
//        }catch(Exception ex){
//            log.error(ex.getMessage(),ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage());
//        }
//        return iRtn;
//    }
    
    /**
     * Office Mapping 정보를 수정 합니다.<br> 
     * @param  List<CustomSearchOfficeMappingManagementVO>  customSearchOfficeMappingManagementVOs
     * @throws DAOException
     * @throws Exception
     */
//	public void modifyOfficeMappingManagement(List<CustomSearchOfficeMappingManagementVO> customSearchOfficeMappingManagementVOs) throws DAOException,Exception {
//		try {
//			if(customSearchOfficeMappingManagementVOs != null && customSearchOfficeMappingManagementVOs.size() > 0) {
//
//				Map<String, String> mapVO = new HashMap<String, String>();
//		        //velocity parameter;
//		        Map<String, Object> velParam = new HashMap<String, Object>();
//		        
//				SQLExecuter sqlExe = new SQLExecuter("");
//				int updCnt[] = null;
//				for (int k = 0; k < customSearchOfficeMappingManagementVOs.size(); k++) {
//	                mapVO = customSearchOfficeMappingManagementVOs.get(k).getColumnValues();
//	                velParam.putAll(mapVO);
//				}
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooCngOfcUSQL(), customSearchOfficeMappingManagementVOs, velParam);
//				for (int i = 0; i < updCnt.length; i++) {
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to update No"+ i + " SQL");
//				}
//            }
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}

//	/**
//	 * 다음 Ref No 를 조회한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return String
//	 * @throws DAOException
//	 */
//	public String searchNextJoRefNo(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<CusBzcAgmtVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		String joRefNo = "";
//		try{
//            if(cusBzcAgmtVO != null){
//                Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//                param.putAll(mapVO);
//                velParam.putAll(mapVO);
//            }
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetNextJoRefNoRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
//			if (list.isEmpty()){
//				joRefNo = cusBzcAgmtVO.getOfcCd()+cusBzcAgmtVO.getReDivrCd()+cusBzcAgmtVO.getTrdCd()+cusBzcAgmtVO.getRlaneCd()+DateTime.getFormatString("yyyyMM").substring(2)+"001";
//			}else{
//				joRefNo = list.get(0).getJoRefNo();
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return joRefNo;
//	}

//	/**
//	 * 다음 Ref Seq 를 조회한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return String
//	 * @throws DAOException
//	 */
//	public String searchNextJoRefSeq(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<CusBzcAgmtVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		String joRefSeq = "1";
//		try{
//            if(cusBzcAgmtVO != null){
//                Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//                param.putAll(mapVO);
//                velParam.putAll(mapVO);
//            }
//						
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetNextJoRefSeqRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
//			if (list.isEmpty()){
//				joRefSeq = "1";
//			}else{
//				joRefSeq = list.get(0).getJoRefSeq();
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return joRefSeq;
//	}

//	/**
//	 * JOO_BZC_AGMT에 Data입력한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public void addJooBzcAgmt(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			SQLExecuter sqlExe = new SQLExecuter("");
//
//			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooBzcAgmtCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}

//	/**
//	 * JOO_BZC_AGMT 수정한다.
//	 * @param List<CusBzcAgmtVO> cusBzcAgmtVOs
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public void modifyJooBzcAgmt(List<CusBzcAgmtVO> cusBzcAgmtVOs) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(cusBzcAgmtVOs.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooBzcAgmtUSQL(), cusBzcAgmtVOs,null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
//	/**
//	 * JOO_BZC_AGMT를 조회한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws DAOException
//	 */
//	public List<CusBzcAgmtVO> searchJooBzcAgmtList(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<CusBzcAgmtVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCusBzcAgmtVORSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

//	/**
//	 * JOO_BZC_AGMT의 Ref.NO List를 조회한다.
//	 * @param JooCodeParamVO jooCodeParamVO
//	 * @return List<JooCodeInfoVO>
//	 * @throws DAOException
//	 */
//	public List<JooCodeInfoVO> searchRefNoList(JooCodeParamVO jooCodeParamVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<JooCodeInfoVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			Map<String, String> mapVO = jooCodeParamVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetRefNoListRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

//	/**
//	 * 기간이 겹치는 REF_NO가 있는지 조회한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws DAOException
//	 */
//	public List<CusBzcAgmtVO> searchOverlappedRefNoList(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<CusBzcAgmtVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOCheckPeriodRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

//	/**
//	 * 같은 조건의 ref no가 있으면 조회한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws DAOException
//	 */
//	public List<CusBzcAgmtVO> searchRefNo(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<CusBzcAgmtVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetJoRefNoRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

//	/**
//	 * 같은 OFFICE, R/E, TRADE, RLANE 인 경우 PERIOD가 같으므로 조회하여 Setting한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws DAOException
//	 */
//	public List<CusBzcAgmtVO> searchRefNoNPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<CusBzcAgmtVO> list = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationMasterDataMgtDBDAOGetRefNoNPeriodRSQL(), param, velParam);
//			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusBzcAgmtVO .class);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return list;
//	}

//	/**
//	 * JOO_BZC_AGMT에 Data입력한다.
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @throws DAOException
//	 * @throws Exception
//	 */
//	public void modifyJooBzcAgmtPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = cusBzcAgmtVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			SQLExecuter sqlExe = new SQLExecuter("");
//
//			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationMasterDataMgtDBDAOJooBzcAgmtPeriodUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to update SQL");
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
}

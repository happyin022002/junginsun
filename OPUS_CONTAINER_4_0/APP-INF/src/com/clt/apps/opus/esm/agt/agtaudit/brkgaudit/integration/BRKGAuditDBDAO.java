/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGAuditDBDAO.java
*@FileTitle : Brokerage Maintenance & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-01
*@LastModifier : Jung-Hyung Kim
*@LastVersion : 1.0
* 2006-12-01 Jung-Hyung Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration.AGTAuditDBDAOModifyAGTCommProcStsCdUSQL;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration.AGTAuditDBDAOSearchApPayInvDtlRSQL;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration.AGTAuditDBDAOSearchApPayInvRSQL;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBCImpl;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrogApPayInvVO;
import com.clt.bizcommon.approval.util.ApprovalUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.ComAproCsrDtlVO;
import com.clt.syscommon.common.table.ComAproRqstHdrVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;

/**
 * OPUS-AGT에 대한 DB 처리를 담당<br>
 * - OPUS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author junghyung kim
 * @see BRKGAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class BRKGAuditDBDAO extends DBDAOSupport {

	/**
     * (ESM_AGT_0013) Brokerage Commission Maintenance & Approval 대상리스트를 가져온다.<br>
     * 
     * @param  BrkgCommVO brkgCommVO
     * @return List<BrkgCommVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BrkgCommVO> searchBRKGCommforAudit(BrkgCommVO brkgCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BrkgCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchBRKGCommforAuditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BrkgCommVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * (ESM_AGT_0013) Brokerage Maintenance 수정/삭제 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyBRKGCommforAuditAgtBrogCommCM(BrkgCommVO brkgCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBRKGCommInfoAgtBrogCommCMUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_0013) Brokerage Maintenance 수정/삭제 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyBRKGCommforAuditAgtBrogComm(BrkgCommVO brkgCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBRKGCommInfoAgtBrogCommUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_0013) Brokerage Maintenance 수정/삭제 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBRKGCommforAuditAgtCommBkgInfo(BrkgCommVO brkgCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBRKGCommInfoAgtCommBkgInfoUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_0013) Brokerage Maintenance 삭제 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeBRKGCommforAuditAgtBrogChgDtl(BrkgCommVO brkgCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBRKGCommInfoAgtBrogChgDtlDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_0013) Brokerage Maintenance 삭제 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeBRKGCommforAuditAgtBrogComm(BrkgCommVO brkgCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBRKGCommInfoAgtBrogCommDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_0013) Brokerage Maintenance 삭제 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeBRKGCommforAuditAgtBrogCommDtl(BrkgCommVO brkgCommVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if(brkgCommVO != null){
				Map<String, String> mapVO = brkgCommVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBRKGCommInfoAgtBrogCommDtlDSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * ESM_AGT_0014) Brokerage Commission의 Basic 정보를 조회<br>
	 * @param BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO
	 * @return List<BRKGCommDetailBasicbyBLVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BRKGCommDetailBasicbyBLVO> searchBRKGCommDetailBasicbyBL(BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<BRKGCommDetailBasicbyBLVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(brkgCommDetailBasicbyBLVO != null){
				Map<String, String> mapVO = brkgCommDetailBasicbyBLVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOBRKGCommDetailBasicbyBLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BRKGCommDetailBasicbyBLVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * (ESM_AGT_0014) Charge Detail 목록 조회<br>
	 * @param BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO
	 * @return List<BRKGCommDetailChargebyBLVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BRKGCommDetailChargebyBLVO> searchBRKGCommDetailChargebyBL(BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<BRKGCommDetailChargebyBLVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(brkgCommDetailChargebyBLVO != null){
				Map<String, String> mapVO = brkgCommDetailChargebyBLVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOBRKGCommDetailChargebyBLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BRKGCommDetailChargebyBLVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * (ESM_AGT_0014) Brokerage Commission의 History Detail 목록 조회<br>
	 * @param BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO
	 * @return List<BRKGCommDetailHistorybyBLVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BRKGCommDetailHistorybyBLVO> searchBRKGCommDetailHistorybyBL(BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<BRKGCommDetailHistorybyBLVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(brkgCommDetailHistorybyBLVO != null){
				Map<String, String> mapVO = brkgCommDetailHistorybyBLVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOBRKGCommDetailHistorybyBLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BRKGCommDetailHistorybyBLVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * ESM_AGT_0014 화면 요율 정보 조회 이벤트 처리<br>
	 * @param AGTBRKGRateInfoVO agtBRKGRateInfoVO
	 * @return List<AGTBRKGRateInfoVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AGTBRKGRateInfoVO> searchAGTBRKGRateInfo(AGTBRKGRateInfoVO agtBRKGRateInfoVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<AGTBRKGRateInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtBRKGRateInfoVO != null){
				Map<String, String> mapVO = agtBRKGRateInfoVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOAGTBRKGRateInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGTBRKGRateInfoVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }


	 /**
	 * (ESM_AGT_018) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @return List<APActualInterfaceMasterForBRKGVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<APActualInterfaceMasterForBRKGVO> searchAPActualInterfaceMasterForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<APActualInterfaceMasterForBRKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apActualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = apActualInterfaceMasterForBRKGVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualInterfaceMasterRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceMasterForBRKGVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * (ESM_AGT_018) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO
	 * @return List<APActualInterfaceDetailForBRKGVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<APActualInterfaceDetailForBRKGVO> searchAPActualInterfaceDetailForBRKGVO(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<APActualInterfaceDetailForBRKGVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(apActualInterfaceDetailForBRKGVO != null){
				Map<String, String> mapVO = apActualInterfaceDetailForBRKGVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualInterfaceDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceDetailForBRKGVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}



	/**
	 * (ESM_AGT_018) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceVO apActualInterfaceVO
	 * @return List<APActualInterfaceVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<APActualInterfaceVO> searchAPActualInterfaceMasterDetailDownExcel(APActualInterfaceVO apActualInterfaceVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<APActualInterfaceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(apActualInterfaceVO != null){
				Map<String, String> mapVO = apActualInterfaceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualInterfaceMasterDetailDownExcelRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * (ESM_AGT_018) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param BRKGInfoListForPrintVO brgkInfoListForPrintVO
	 * @return List<BRKGInfoListForPrintVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BRKGInfoListForPrintVO> searchBRKGInfoListForPrint(BRKGInfoListForPrintVO brgkInfoListForPrintVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<BRKGInfoListForPrintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(brgkInfoListForPrintVO != null){
				Map<String, String> mapVO = brgkInfoListForPrintVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchBRKGInfoListForPrintRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BRKGInfoListForPrintVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * (ESM_AGT_018) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param BRKGInfoForPrintVO brkgInfoForPrintVO
	 * @return List<BRKGInfoForPrintVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BRKGInfoForPrintVO> searchBRKGInfoForPrint1(BRKGInfoForPrintVO brkgInfoForPrintVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<BRKGInfoForPrintVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(brkgInfoForPrintVO != null){
				Map<String, String> mapVO = brkgInfoForPrintVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchBRKGInfoForPrint1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BRKGInfoForPrintVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * (ESM_AGT_018) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param BRKGInfoForPrint2VO brkgInfoForPrint2VO
	 * @return List<BRKGInfoForPrint2VO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<BRKGInfoForPrint2VO> searchBRKGInfoForPrint2(BRKGInfoForPrint2VO brkgInfoForPrint2VO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<BRKGInfoForPrint2VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if(brkgInfoForPrint2VO != null){
				Map<String, String> mapVO = brkgInfoForPrint2VO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>velParam="+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchBRKGInfoForPrint2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BRKGInfoForPrint2VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
	/**
	 * Local Date Search<br>
	 * @return APActualInterfaceMasterForBRKGVO
	 * @throws DAOException
	 * @throws EventException
	 */
	public APActualInterfaceMasterForBRKGVO searchAPActualInterfaceBRKGLocalDt() throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<APActualInterfaceMasterForBRKGVO> list = null;
		APActualInterfaceMasterForBRKGVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualInterfaceBRKGLocalDtRSQL(), param, velParam);
			if(0 < dbRowset.getRowCount()){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceMasterForBRKGVO .class);
				result = list.get(0);
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @return APActualInterfaceMasterForBRKGVO
	 * @throws DAOException
	 * @throws EventException
	 */
	public APActualInterfaceMasterForBRKGVO searchAPActualInterfaceBRKGCsrGubun(
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<APActualInterfaceMasterForBRKGVO> list = null;
		APActualInterfaceMasterForBRKGVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(actualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = actualInterfaceMasterForBRKGVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualInterfaceBRKGCsrGubunRSQL(), param, velParam);
			if(0 < dbRowset.getRowCount()){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceMasterForBRKGVO .class);
				result = list.get(0);
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @return APActualInterfaceMasterForBRKGVO
	 * @throws DAOException
	 * @throws EventException
	 */
	public APActualInterfaceMasterForBRKGVO searchAPActualInterfaceBRKGCsrNo(
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO) throws DAOException, EventException{
		DBRowSet dbRowset = null;
		List<APActualInterfaceMasterForBRKGVO> list = null;
		APActualInterfaceMasterForBRKGVO result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(actualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = actualInterfaceMasterForBRKGVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualInterfaceBRKGCsrNoRSQL(), param, velParam);
			if(0 < dbRowset.getRowCount()){
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, APActualInterfaceMasterForBRKGVO .class);
				result = list.get(0);
			}
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @return int
	 * @throws DAOException
	 * @throws EventException
	 */
	public int createApCsrNo(APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO) throws DAOException, EventException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(actualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = actualInterfaceMasterForBRKGVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>param="+param);
				log.info("\n >>>>velParam="+velParam);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOCreateApCsrNoCSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO approVO
	 * @return int
	 * @throws DAOException
	 * @throws EventException
	 */
	public int modifyAPActualInterfaceBRKGAgtBrogComm(
			APActualInterfaceMasterForBRKGVO approVO) throws DAOException, EventException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int modifyResult = 0;
		try{
			if(approVO != null){
				Map<String, String> mapVO = approVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>param="+param);
				log.info("\n >>>>velParam="+velParam);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			modifyResult = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyAPActualInterfaceBRKGAgtBrogCommUSQL(), param,velParam);
			
			if(modifyResult == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return modifyResult;
	}
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws EventException
	 */
	public DBRowSet searchAPActualApprovalRequestList(
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO) throws DAOException, EventException{
		
		DBRowSet dRs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(actualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = actualInterfaceMasterForBRKGVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("\n >>>>param="+param);
				log.info("\n >>>>velParam="+velParam);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchAPActualApprovalRequestListRSQL(), param, velParam);
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param String fwdr
	 * @param String vndr_seq
	 * @param String ap_ofc_cd
	 * @param SignOnUserAccount account
	 * @return ArrayList
	 * @throws DAOException
	 * @throws EventException
	 */
	public ArrayList createBRKGCSRHeader(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO, String fwdr, String vndr_seq, String ap_ofc_cd, SignOnUserAccount account) throws DAOException, EventException{
		Connection con = null;				// Connection Interface  
        PreparedStatement selectPs0 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs3 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs1 = null; // INSERT를 수행하기 위한 SQL Statement
        PreparedStatement updatePs1 = null; // UPDADE를 수행하기 위한 SQL Statement
        PreparedStatement selectPs4 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs5 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs6 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs7 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs8 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs9 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs10 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs11 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs12 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement updatePs2 = null; // UPDADE를 수행하기 위한 SQL Statement
        PreparedStatement insertPs2 = null; // INSERT를 수행하기 위한 SQL Statement
        
        ResultSet rs0 = null;	// DB ResultSet
        ResultSet rs1 = null;	// DB ResultSet
        ResultSet rs2 = null;	// DB ResultSet
        ResultSet rs3 = null;	// DB ResultSet
        ResultSet rs4 = null;	// DB ResultSet
        ResultSet rs5 = null;	// DB ResultSet
        ResultSet rs6 = null;	// DB ResultSet
        ResultSet rs7 = null;	// DB ResultSet
        ResultSet rs8 = null;	// DB ResultSet
        ResultSet rs9 = null;	// DB ResultSet
        ResultSet rs10 = null;	// DB ResultSet
        ResultSet rs11 = null;	// DB ResultSet
        ResultSet rs12 = null;	// DB ResultSet
        //DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String effDt = "";
        String locCd = "USNYC";
        String localDt = "";
        //String invDt = "";
        //String termDt = "";
        String glDt  = "";
//        String csrPartNo = "";
//        String apOfc = "";
//        int vndrNo = 0;
        String csrNo = "";
//        String termNm = "";
        double csrAmt = 0;
        String csrNoGbn = "";
        String invDesc = "FAC/Brokerage";
        String attrCateNm = "Invoices";
        String attrCtnt1 = null;	//EP 결재자명(일단 NULL)
        String userId = "";	//event
        String userNm = "";	//event
        String userEm = "";
        String srcCtnt    = "BROKERAGE";
        String payMzdLuCd = "";
        String payGrpLuCd = "";
        String coaRgnCd = "";
        String coaCtrCd = "";
        String coaIntrCmpyCd = "";
        //String csrTpCd = "STANDARD";
        ArrayList<HashMap<String, String>> rtnArray = null;
        HashMap<String, String> rtnHash = null;
        
        String bkgNum = "";
        String bkgCreDt = "";
        
        
        String ar_hd_qtr_ofc_cd = "";
        int gl_dt_cnt = 0;

        // 2008.02.14-sunganj Approval & Request 조건으로 날짜 추가        
        String stsOpt = "";
        String frDate = "";
        String toDate = "";
        
        StringBuffer selectQuery0 = new StringBuffer();
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
        StringBuffer selectQuery3 = new StringBuffer();
        StringBuffer insertQuery1 = new StringBuffer();
        StringBuffer updateQuery1 = new StringBuffer();
        StringBuffer selectQuery4 = new StringBuffer();
        StringBuffer selectQuery5 = new StringBuffer();
        StringBuffer selectQuery6 = new StringBuffer();
        StringBuffer selectQuery7 = new StringBuffer();
        StringBuffer selectQuery8 = new StringBuffer();
        StringBuffer selectQuery9 = new StringBuffer();
        StringBuffer selectQuery10 = new StringBuffer();
        StringBuffer selectQuery11 = new StringBuffer();
        StringBuffer updateQuery2 = new StringBuffer();
        StringBuffer insertQuery2 = new StringBuffer();
        
        ////변수값 세팅        
        effDt = actualInterfaceMasterForBRKGVO.getEffDate();
//        effDt  = effDt.substring(0,4) + effDt.substring(5,7) + effDt.substring(8);
        
        stsOpt = actualInterfaceMasterForBRKGVO.getStsOption();
        frDate = actualInterfaceMasterForBRKGVO.getSearchDtFr();
        toDate = actualInterfaceMasterForBRKGVO.getSearchDtTo();
        ////변수값 세팅.끝

        
        
        
        
        //2.UPDATE REV VVD
        selectQuery2.append("\n    UPDATE /*+ bypass_ujvc */ ");
        selectQuery2.append("\n         ( ");
        selectQuery2.append("\n               SELECT ");
        selectQuery2.append("\n                      INF.BKG_NO, ");
        selectQuery2.append("\n                      INF.RLANE_CD        AS INF_RLANE_CD, ");
        selectQuery2.append("\n                      INF.REV_VVD_CD      AS INF_REV_VVD_CD, ");
        selectQuery2.append("\n                      INF.ESTM_IOC_DIV_CD AS INF_ESTM_IOC_DIV_CD, ");
        selectQuery2.append("\n                      REV.RLANE_CD        AS REV_RLANE_CD, ");
        selectQuery2.append("\n                      REV.REV_VVD_CD      AS REV_REV_VVD_CD, ");
        selectQuery2.append("\n                      REV.ESTM_IOC_DIV_CD AS REV_ESTM_IOC_DIV_CD ");
        selectQuery2.append("\n                 FROM AGT_COMM_BKG_INFO INF, ");
        selectQuery2.append("\n                    ( ");
        selectQuery2.append("\n                          SELECT ");
        selectQuery2.append("\n                                 BKG_NO, ");
        selectQuery2.append("\n                            CASE RNK  ");
        selectQuery2.append("\n                            WHEN 1  ");
        selectQuery2.append("\n                            THEN N1ST_CONTI  ");
        selectQuery2.append("\n                            WHEN 2  ");
        selectQuery2.append("\n                            THEN N2ND_CONTI  ");
        selectQuery2.append("\n                            WHEN 3  ");
        selectQuery2.append("\n                            THEN N3RD_CONTI  ");
        selectQuery2.append("\n                            WHEN 4  ");
        selectQuery2.append("\n                            THEN N4TH_CONTI  ");
        selectQuery2.append("\n                            ELSE ''  ");
        selectQuery2.append("\n                            END                 AS ESTM_IOC_DIV_CD,  ");
        selectQuery2.append("\n                            CASE RNK  ");
        selectQuery2.append("\n                            WHEN 1  ");
        selectQuery2.append("\n                            THEN N1ST_RLANE_CD  ");
        selectQuery2.append("\n                            WHEN 2  ");
        selectQuery2.append("\n                            THEN N2ND_RLANE_CD  ");
        selectQuery2.append("\n                            WHEN 3  ");
        selectQuery2.append("\n                            THEN N3RD_RLANE_CD  ");
        selectQuery2.append("\n                            ELSE N4TH_RLANE_CD  ");
        selectQuery2.append("\n                             END                 AS RLANE_CD,  ");
        selectQuery2.append("\n                            CASE  ");
        selectQuery2.append("\n                            WHEN 'RBCCO' = CASE RNK WHEN 1 THEN N1ST_RLANE_CD WHEN 2 THEN N2ND_RLANE_CD WHEN 3 THEN N3RD_RLANE_CD ELSE N4TH_RLANE_CD END ");
        selectQuery2.append("\n                            THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE'  ");
        selectQuery2.append("\n                            ELSE  ");
        selectQuery2.append("\n                               (  ");
        selectQuery2.append("\n                            CASE RNK  ");
        selectQuery2.append("\n                            WHEN 1  ");
        selectQuery2.append("\n                            THEN N1ST_VVD_CD  ");
        selectQuery2.append("\n                            WHEN 2  ");
        selectQuery2.append("\n                            THEN N2ND_VVD_CD  ");
        selectQuery2.append("\n                            WHEN 3  ");
        selectQuery2.append("\n                            THEN N3RD_VVD_CD  ");
        selectQuery2.append("\n                            ELSE N4TH_VVD_CD  ");
        selectQuery2.append("\n                             END  ");
        selectQuery2.append("\n                               )  ");
        selectQuery2.append("\n                             END                 AS REV_VVD_CD ");
        selectQuery2.append("\n                            FROM ");
        selectQuery2.append("\n                               ( ");
        selectQuery2.append("\n                                     SELECT ");
        selectQuery2.append("\n                                            C.BKG_NO       AS BKG_NO, ");
        selectQuery2.append("\n                                            COA_RANK_INFO_FNC ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                            NVL (SAQ_GET_RLANE_FNC (C.SLAN_CD,C.POL_CD,C.POD_CD), 'RBCCO'), --N1ST_RLANE_CD ");
        selectQuery2.append("\n                                            CASE WHEN D.SLAN_CD IS NULL THEN '' ELSE SAQ_GET_RLANE_FNC (D.SLAN_CD,D.POL_CD,D.POD_CD) END, --N2ND_RLANE_CD ");
        selectQuery2.append("\n                                            CASE WHEN E.SLAN_CD IS NULL THEN '' ELSE SAQ_GET_RLANE_FNC (E.SLAN_CD,E.POL_CD,E.POD_CD) END, -- N3RD_RLANE_CD ");
        selectQuery2.append("\n                                            CASE WHEN F.SLAN_CD IS NULL THEN '' ELSE SAQ_GET_RLANE_FNC (F.SLAN_CD,F.POL_CD,F.POD_CD) END, -- N4TH_RLANE_CD ");
        selectQuery2.append("\n                                            CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END,                        -- N1ST_CONTI ");
        selectQuery2.append("\n                                            CASE WHEN POD2.CONTI_CD = POD3.CONTI_CD THEN 'I'||POD3.CONTI_CD ELSE 'OO' END,                        -- N2ND_CONTI ");
        selectQuery2.append("\n                                            CASE WHEN POD3.CONTI_CD = POD4.CONTI_CD THEN 'I'||POD4.CONTI_CD ELSE 'OO' END,                        -- N3RD_CONTI ");
        selectQuery2.append("\n                                            CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END                         -- N4TH_CONTI ");
        selectQuery2.append("\n                                          ) AS RNK, ");
        selectQuery2.append("\n                                            CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END AS N1ST_CONTI,  ");
        selectQuery2.append("\n                                            CASE WHEN POD2.CONTI_CD = POD3.CONTI_CD THEN 'I'||POD3.CONTI_CD ELSE 'OO' END AS N2ND_CONTI,  ");
        selectQuery2.append("\n                                            CASE WHEN POD3.CONTI_CD = POD4.CONTI_CD THEN 'I'||POD4.CONTI_CD ELSE 'OO' END AS N3RD_CONTI,  ");
        selectQuery2.append("\n                                            CASE WHEN POD4.CONTI_CD = POD5.CONTI_CD THEN 'I'||POD5.CONTI_CD ELSE 'OO' END AS N4TH_CONTI, ");
        selectQuery2.append("\n                                            NVL (SAQ_GET_RLANE_FNC (C.SLAN_CD,C.POL_CD,C.POD_CD), 'RBCCO') AS N1ST_RLANE_CD,  ");
        selectQuery2.append("\n                                            CASE WHEN D.SLAN_CD IS NULL THEN '' ELSE SAQ_GET_RLANE_FNC (D.SLAN_CD,D.POL_CD,D.POD_CD) END AS N2ND_RLANE_CD,  ");
        selectQuery2.append("\n                                            CASE WHEN E.SLAN_CD IS NULL THEN '' ELSE SAQ_GET_RLANE_FNC (E.SLAN_CD,E.POL_CD,E.POD_CD) END AS N3RD_RLANE_CD,  ");
        selectQuery2.append("\n                                            CASE WHEN F.SLAN_CD IS NULL THEN '' ELSE SAQ_GET_RLANE_FNC (F.SLAN_CD,F.POL_CD,F.POD_CD) END AS N4TH_RLANE_CD, ");
        selectQuery2.append("\n                                            C.VSL_CD ");
        selectQuery2.append("\n                                         || C.SKD_VOY_NO ");
        selectQuery2.append("\n                                         || C.SKD_DIR_CD ");
        selectQuery2.append("\n                                         || NVL ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                                SELECT -- COA_REV_DIR_CONV_FNC (C.SLAN_CD, C.POL_CD, C.SKD_DIR_CD) ");
        selectQuery2.append("\n                                                       RLANE_DIR_CD ");
        selectQuery2.append("\n                                                  FROM AR_FINC_DIR_CONV ");
        selectQuery2.append("\n                                                 WHERE SLAN_CD = C.SLAN_CD ");
        selectQuery2.append("\n                                                   AND SCONTI_CD = POL2.SCONTI_CD ");
        selectQuery2.append("\n                                                   AND SLAN_DIR_CD = C.SKD_DIR_CD ");
        selectQuery2.append("\n                                                   AND DELT_FLG ='N' ");
        selectQuery2.append("\n                                          ) ");
        selectQuery2.append("\n                                          , C.SKD_DIR_CD ");
        selectQuery2.append("\n                                          )                                             AS N1ST_VVD_CD,  ");
        selectQuery2.append("\n                                            D.VSL_CD ");
        selectQuery2.append("\n                                         || D.SKD_VOY_NO ");
        selectQuery2.append("\n                                         || D.SKD_DIR_CD  ");
        selectQuery2.append("\n                                         ||  ");
        selectQuery2.append("\n                                       CASE D.SLAN_CD  ");
        selectQuery2.append("\n                                       WHEN NULL  ");
        selectQuery2.append("\n                                       THEN D.SKD_DIR_CD  ");
        selectQuery2.append("\n                                       ELSE NVL ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                                SELECT -- COA_REV_DIR_CONV_FNC (D.SLAN_CD, D.POL_CD, D.SKD_DIR_CD) ");
        selectQuery2.append("\n                                                       RLANE_DIR_CD ");
        selectQuery2.append("\n                                                  FROM AR_FINC_DIR_CONV ");
        selectQuery2.append("\n                                                 WHERE SLAN_CD = D.SLAN_CD ");
        selectQuery2.append("\n                                                   AND SCONTI_CD = POL3.SCONTI_CD ");
        selectQuery2.append("\n                                                   AND SLAN_DIR_CD = D.SKD_DIR_CD ");
        selectQuery2.append("\n                                                   AND DELT_FLG ='N' ");
        selectQuery2.append("\n                                          ) ");
        selectQuery2.append("\n                                          , D.SKD_DIR_CD ");
        selectQuery2.append("\n                                          ) ");
        selectQuery2.append("\n                                        END                                                                           AS N2ND_VVD_CD,  ");
        selectQuery2.append("\n                                            E.VSL_CD||E.SKD_VOY_NO||E.SKD_DIR_CD  ");
        selectQuery2.append("\n                                         ||  ");
        selectQuery2.append("\n                                       CASE E.SLAN_CD  ");
        selectQuery2.append("\n                                       WHEN NULL  ");
        selectQuery2.append("\n                                       THEN E.SKD_DIR_CD ");
        selectQuery2.append("\n                                       ELSE NVL ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                                SELECT -- COA_REV_DIR_CONV_FNC (E.SLAN_CD, E.POL_CD, E.SKD_DIR_CD) ");
        selectQuery2.append("\n                                                       RLANE_DIR_CD ");
        selectQuery2.append("\n                                                  FROM AR_FINC_DIR_CONV ");
        selectQuery2.append("\n                                                 WHERE SLAN_CD     = E.SLAN_CD ");
        selectQuery2.append("\n                                                   AND SCONTI_CD   = POL4.SCONTI_CD ");
        selectQuery2.append("\n                                                   AND SLAN_DIR_CD = E.SKD_DIR_CD ");
        selectQuery2.append("\n                                                   AND DELT_FLG    ='N' ");
        selectQuery2.append("\n                                          ) ");
        selectQuery2.append("\n                                          , E.SKD_DIR_CD ");
        selectQuery2.append("\n                                          )  ");
        selectQuery2.append("\n                                        END                                                                           AS N3RD_VVD_CD,  ");
        selectQuery2.append("\n                                            F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD  ");
        selectQuery2.append("\n                                         ||  ");
        selectQuery2.append("\n                                       CASE F.SLAN_CD  ");
        selectQuery2.append("\n                                       WHEN NULL  ");
        selectQuery2.append("\n                                       THEN F.SKD_DIR_CD ");
        selectQuery2.append("\n                                       ELSE NVL ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                                SELECT -- COA_REV_DIR_CONV_FNC (F.SLAN_CD, F.POL_CD, F.SKD_DIR_CD) ");
        selectQuery2.append("\n                                                       RLANE_DIR_CD ");
        selectQuery2.append("\n                                                  FROM AR_FINC_DIR_CONV ");
        selectQuery2.append("\n                                                 WHERE SLAN_CD     = F.SLAN_CD ");
        selectQuery2.append("\n                                                   AND SCONTI_CD   = POL5.SCONTI_CD ");
        selectQuery2.append("\n                                                   AND SLAN_DIR_CD = F.SKD_DIR_CD ");
        selectQuery2.append("\n                                                   AND DELT_FLG    ='N' ");
        selectQuery2.append("\n                                          ) ");
        selectQuery2.append("\n                                          , F.SKD_DIR_CD ");
        selectQuery2.append("\n                                          )  ");
        selectQuery2.append("\n                                        END                                                                           AS N4TH_VVD_CD ");
        selectQuery2.append("\n                                       FROM    ");
        selectQuery2.append("\n                                            BKG_VVD D, ");
        selectQuery2.append("\n                                            BKG_VVD E, ");
        selectQuery2.append("\n                                            BKG_VVD F, ");
        selectQuery2.append("\n                                            MDM_LOCATION POL2,                           ");
        selectQuery2.append("\n                                            MDM_LOCATION POD2, ");
        selectQuery2.append("\n                                            MDM_LOCATION POL3, ");
        selectQuery2.append("\n                                            MDM_LOCATION POD3, ");
        selectQuery2.append("\n                                            MDM_LOCATION POL4, ");
        selectQuery2.append("\n                                            MDM_LOCATION POD4, ");
        selectQuery2.append("\n                                            MDM_LOCATION POL5, ");
        selectQuery2.append("\n                                            MDM_LOCATION POD5, ");
        selectQuery2.append("\n                                          ( ");
        selectQuery2.append("\n                                                SELECT ");
        selectQuery2.append("\n                                                       VVD.BKG_NO, ");
        selectQuery2.append("\n                                                       VVD.VSL_CD, ");
        selectQuery2.append("\n                                                       VVD.SKD_VOY_NO, ");
        selectQuery2.append("\n                                                       VVD.SKD_DIR_CD, ");
        selectQuery2.append("\n                                                       VVD.SLAN_CD, ");
        selectQuery2.append("\n                                                       VVD.POL_CD, ");
        selectQuery2.append("\n                                                       VVD.POD_CD ");
        selectQuery2.append("\n                                                  FROM BKG_VVD     VVD, ");
        selectQuery2.append("\n                                                       BKG_BOOKING BKG ");
        selectQuery2.append("\n                                                 WHERE VVD.BKG_NO       = BKG.BKG_NO ");
        selectQuery2.append("\n                                                   AND VVD.POL_CD       = BKG.POL_CD ");
        selectQuery2.append("\n                                                   AND BKG.BKG_NO ");
        selectQuery2.append("\n                                                    IN ");
        selectQuery2.append("\n                                                     ( ");

        
        
        
        
        
        selectQuery2.append("\n          SELECT A.BKG_NO ");
        selectQuery2.append("\n            FROM AGT_BROG_COMM A, AGT_COMM_BKG_INFO B ");
        selectQuery2.append("\n           WHERE A.BKG_NO = B.BKG_NO ");
        selectQuery2.append("\n             AND B.BL_NO IS NOT NULL ");
        selectQuery2.append("\n             AND A.CRE_USR_ID != 'COST' ");
        selectQuery2.append("\n             AND A.VNDR_SEQ = ? "); //:vndrSeq
        selectQuery2.append("\n             AND A.FRT_FWRD_CNT_CD || TO_CHAR (A.FRT_FWRD_SEQ, 'FM000000') = ? "); //:fwdr 
        selectQuery2.append("\n             AND A.AP_OFC_CD = ? "); //:apOfc

        // 2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	selectQuery2.append("\n         AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery2.append("\n         AND A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }
        selectQuery2.append("\n             AND A.COMM_PROC_STS_CD IN ('CS', 'CM', 'CA') ");
        selectQuery2.append("\n                                                     ) ");
        selectQuery2.append("\n                                          ) C ");
        selectQuery2.append("\n                                      WHERE D.BKG_NO(+)   = C.BKG_NO ");
        selectQuery2.append("\n                                        AND D.POL_CD(+)   = C.POD_CD ");
        selectQuery2.append("\n                                        AND E.BKG_NO(+)   = D.BKG_NO ");
        selectQuery2.append("\n                                        AND E.POL_CD(+)   = D.POD_CD ");
        selectQuery2.append("\n                                        AND F.BKG_NO(+)   = E.BKG_NO ");
        selectQuery2.append("\n                                        AND F.POL_CD(+)   = E.POD_CD ");
        selectQuery2.append("\n                                        AND C.POL_CD      = POL2.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND C.POD_CD      = POD2.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND D.POL_CD      = POL3.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND D.POD_CD      = POD3.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND E.POL_CD      = POL4.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND E.POD_CD      = POD4.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND F.POL_CD      = POL5.LOC_CD (+) ");
        selectQuery2.append("\n                                        AND F.POD_CD      = POD5.LOC_CD (+) ");
        selectQuery2.append("\n                               ) ");
        selectQuery2.append("\n                    ) REV ");
        selectQuery2.append("\n                WHERE INF.BKG_NO            = REV.BKG_NO ");
        selectQuery2.append("\n                  AND INF.REV_VVD_CD      <>  REV.REV_VVD_CD ");
        selectQuery2.append("\n                  AND REV.REV_VVD_CD       IS NOT NULL ");
        selectQuery2.append("\n         ) ");
        selectQuery2.append("\n       SET INF_RLANE_CD        = REV_RLANE_CD, ");
        selectQuery2.append("\n           INF_REV_VVD_CD      = REV_REV_VVD_CD, ");
        selectQuery2.append("\n           INF_ESTM_IOC_DIV_CD = REV_ESTM_IOC_DIV_CD ");
        
        
        
        
        
        
        
        
        
        
      //0.CHECK BKG_CRE_DT
        selectQuery0.append("\nSELECT A.BKG_NO AS BKG_NO, TO_CHAR(B.BKG_CRE_DT,'yyyymmdd') AS BKG_CRE_DT ");
        selectQuery0.append("\n  FROM AGT_BROG_COMM A, BKG_BOOKING B ");
        
        // 2008.02.14-sunganj Approval & Request 조건으로 날짜 추가
        //selectQuery0.append("\n WHERE a.comm_proc_sts_cd IN('CS','CM','CA') ");        
        //selectQuery0.append("\n WHERE DECODE(?,'1',a.vsl_dep_dt,a.cre_dt) BETWEEN TO_DATE(?,'YYYYMMDD') AND TO_DATE(?,'YYYYMMDD')+0.999999 ");// :stsOpt,:frDate,:toDate
        // 2008.10.06 권상준 SQL 튜닝
//        selectQuery0.append("\n WHERE ((? = 1 and a.vsl_dep_dt BETWEEN TO_DATE(?, 'YYYYMMDD') AND TO_DATE(?, 'YYYYMMDD')+0.999999) ");//:stsOpt,:frDate,:toDate
//        selectQuery0.append("\n       or (? = 0 and a.cre_dt BETWEEN TO_DATE(?, 'YYYYMMDD') AND TO_DATE(?, 'YYYYMMDD')+0.999999)) ");
        if(stsOpt.equals("1")){
        	selectQuery0.append("\n         WHERE A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery0.append("\n         WHERE A.CRE_DT BETWEEN TO_DATE(replace(?, '-'), 'YYYYMMDD') AND TO_DATE(replace(?, '-'), 'YYYYMMDD')+0.999999 ");
        }else{
        	selectQuery0.append("\n         WHERE 1 = 1 ");        	
        }
        selectQuery0.append("\n   AND A.COMM_PROC_STS_CD IN('CS','CM','CA') ");        
        
        selectQuery0.append("\n   AND A.CRE_USR_ID != 'COST' ");
        selectQuery0.append("\n   AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000')||A.VNDR_SEQ||A.AP_OFC_CD IN( \n");
    	for (int j=0; j<actualInterfaceMasterForBRKGVOs.length; j++)
    	{
    		if (!(j==0)) selectQuery0.append(",\n");
    		selectQuery0.append("           '");
    		selectQuery0.append(actualInterfaceMasterForBRKGVOs[j].getFwdr());
    		selectQuery0.append(actualInterfaceMasterForBRKGVOs[j].getVndrSeq());
    		selectQuery0.append(actualInterfaceMasterForBRKGVOs[j].getApOfcCd());
    		selectQuery0.append("'");
    	}        
//        for(int k=1; k<actualInterfaceMasterForBRKGVOs.length; k++){selectQuery0.append(", ?");}
        selectQuery0.append(") ");
        selectQuery0.append("\n   AND A.BROG_IF_DT IS NULL ");
        selectQuery0.append("\n   AND B.BL_NO IS NOT NULL ");
        selectQuery0.append("\n   AND A.BKG_NO = B.BKG_NO ");
                       
        ////1.GET LOCAL_DATE, INVOICE DATE, TERM_DATE, GL_DATE
        selectQuery1.append("\n SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD ),'YYYYMMDD') ");
        selectQuery1.append("\n  FROM MDM_ORGANIZATION ");
        selectQuery1.append("\n WHERE LOC_CD = ? ");	//:USNYC
        selectQuery1.append("\n   AND ROWNUM = 1 ");
        
        //1-1.GET CSR_AMOUNT 2007.08.17 추가 (CSR_NO 생성시 CSR_AMT 금액에 따라 CSR_NO 의 세번째 자리가 0이상이면 'S' 마이너스 금액이면 'C'
        selectQuery11.append("\n SELECT SUM(ROUND(A.ACT_IF_COMM_AMT,2)) ");
        selectQuery11.append("\n  FROM AGT_BROG_COMM A, AGT_COMM_BKG_INFO B ");
        selectQuery11.append("\n WHERE A.VNDR_SEQ = ? ");	//:vndr_seq        
        selectQuery11.append("\n   AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') = ? ");	//:frt_fwrd_cnt_cd        
        selectQuery11.append("\n   AND A.AP_OFC_CD = ? ");	//:ap_ofc_cd
        selectQuery11.append("\n   AND A.BROG_IF_DT IS NULL ");
        selectQuery11.append("\n   AND A.COMM_PROC_STS_CD IN('CS','CM','CA') ");
        selectQuery11.append("\n   AND A.BKG_NO       = B.BKG_NO ");
        selectQuery11.append("\n   AND A.CRE_USR_ID != 'COST' ");
        selectQuery11.append("\n   AND B.BL_NO IS NOT NULL ");
        selectQuery11.append("\n   AND (A.BKG_NO,  A.BROG_SEQ) IN  ");
        selectQuery11.append("\n       (SELECT BKG_NO,   BROG_SEQ  ");
        selectQuery11.append("\n          FROM AGT_BROG_COMM ");
        // 2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	selectQuery11.append("\n         WHERE A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery11.append("\n         WHERE A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }else{
        	selectQuery11.append("\n         WHERE 1 = 1 ");        	
        }
        selectQuery11.append("\n           AND COMM_PROC_STS_CD IN('CS','CM','CA') ");
        
        selectQuery11.append("\n           AND BROG_IF_DT IS NULL ");
        selectQuery11.append("\n           AND VNDR_SEQ = ? ");	//:vndr_seq        
        selectQuery11.append("\n           AND FRT_FWRD_CNT_CD||TO_CHAR(FRT_FWRD_SEQ,'FM000000') = ? ");	//:frt_fwrd_cnt_cd        
        selectQuery11.append("\n       ) ");
                
        ////3.GET CSR_NO
        selectQuery3.append("\n SELECT '08'||?||?||SUBSTR(?,3,6)||TO_CHAR(SER,'FM00000') ");	//:csr_part_no
        selectQuery3.append("\n  FROM (SELECT NVL(MAX(TO_NUMBER(SUBSTR(CSR_NO,LENGTH(CSR_NO)-4)))+1,10001) SER ");        
        selectQuery3.append("\n          FROM AP_CSR_NO ");
        selectQuery3.append("\n         WHERE CSR_NO LIKE '08'||?||?||SUBSTR(?,3,6)||'%') ");	//:csr_part_no
		
        ////4.AP_CSR_NO INSERT
        insertQuery1.append("\n INSERT INTO AP_CSR_NO(CSR_NO, CRE_USR_ID, CRE_DT) ");
        insertQuery1.append("\n VALUES(?, 'BRKG/FAC', SYSDATE) ");	//:csr_no
        
        ////5.AGT_BROG_COMM UPDATE
        updateQuery1.append("\n UPDATE AGT_BROG_COMM ");
        updateQuery1.append("\n   SET CSR_NO = ? "); //:csrNo
        updateQuery1.append("\n WHERE (BKG_NO, BROG_SEQ) IN ( ");
        updateQuery1.append("\n          SELECT A.BKG_NO, ");
        updateQuery1.append("\n                 A.BROG_SEQ ");
        updateQuery1.append("\n            FROM AGT_BROG_COMM A, AGT_COMM_BKG_INFO B ");
        updateQuery1.append("\n           WHERE A.BKG_NO = B.BKG_NO ");
        updateQuery1.append("\n             AND B.BL_NO IS NOT NULL ");
        updateQuery1.append("\n             AND A.CRE_USR_ID != 'COST' ");
        updateQuery1.append("\n             AND A.VNDR_SEQ = ? "); //:vndrSeq
        updateQuery1.append("\n             AND A.FRT_FWRD_CNT_CD || TO_CHAR (A.FRT_FWRD_SEQ, 'FM000000') = ? "); //:fwdr 
        updateQuery1.append("\n             AND A.AP_OFC_CD = ? "); //:apOfc

        // 2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	updateQuery1.append("\n         AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	updateQuery1.append("\n         AND A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }
        updateQuery1.append("\n             AND A.COMM_PROC_STS_CD IN ('CS', 'CM', 'CA')) ");

        ////6.GET VNDR_TERM_NM, COA_INTER_COMPY_CD, INV_DESC
        selectQuery4.append("\n SELECT GEN_PAY_TERM_CD, ");
        selectQuery4.append("\n       NVL(LTRIM(SUBS_CO_CD),'00'), ");
        selectQuery4.append("\n       NVL(LTRIM(VNDR_LOCL_LANG_NM),VNDR_LGL_ENG_NM) ");
        selectQuery4.append("\n  FROM MDM_VENDOR ");
        selectQuery4.append("\n WHERE VNDR_SEQ = ? ");	//:vndr_seq
                
        selectQuery9.append("\n SELECT A.BKG_NO, A.BROG_SEQ,  A.ACT_IF_COMM_AMT ");
        selectQuery9.append("\n  FROM AGT_BROG_COMM A, AGT_COMM_BKG_INFO B ");
        selectQuery9.append("\n WHERE A.BKG_NO = B.BKG_NO ");
        selectQuery9.append("\n	  AND B.BL_NO IS NOT NULL ");
        selectQuery9.append("\n	  AND A.VNDR_SEQ = ?  "); //:vndr_seq
        selectQuery9.append("\n   AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') = ? "); //:frt_fwrd_cnt_cd
        selectQuery9.append("\n   AND A.AP_OFC_CD = ? "); //:ap_ofc_cd
        selectQuery9.append("\n   AND A.BROG_IF_DT IS NULL ");
        //2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	selectQuery9.append("\n         AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery9.append("\n         AND A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }
        selectQuery9.append("\n   AND A.COMM_PROC_STS_CD IN('CS','CM','CA') ");
        selectQuery9.append("\n   AND A.CRE_USR_ID != 'COST' ");
        selectQuery9.append("\n   AND A.CSR_NO IS NOT NULL ");
        selectQuery9.append("\n   AND (A.BKG_NO, A.BROG_SEQ) IN  ");
        selectQuery9.append("\n       (SELECT BKG_NO, MAX(BROG_SEQ) ");
        selectQuery9.append("\n          FROM AGT_BROG_COMM ");
        //2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	selectQuery9.append("\n         WHERE A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery9.append("\n         WHERE A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }else{
        	selectQuery9.append("\n         WHERE 1 = 1 ");
        }
        selectQuery9.append("\n           AND COMM_PROC_STS_CD IN('CS','CM','CA') ");
        
        selectQuery9.append("\n           AND BROG_IF_DT IS NULL ");
        selectQuery9.append("\n           AND CSR_NO IS NOT NULL ");
        selectQuery9.append("\n           AND VNDR_SEQ = ? "); //:vndr_seq
        selectQuery9.append("\n           AND FRT_FWRD_CNT_CD||TO_CHAR(FRT_FWRD_SEQ,'FM000000') = ? "); //:frt_fwrd_cnt_cd
        selectQuery9.append("\n         GROUP BY BKG_NO ");
        selectQuery9.append("\n       ) ");
        
        // 6.2 GET LOCAL DETAIL AMOUNT
        selectQuery10.append("\n SELECT SUM(A.ACT_USD_COMM_AMT) ACT_USD_COMM_AMT ");       
        selectQuery10.append("\n  FROM  AGT_BROG_COMM_DTL A ");
        selectQuery10.append("\n WHERE A.BKG_NO = ? ");
        selectQuery10.append("\n   AND A.BROG_SEQ = ? ");        
        
        // 6.3 UPDATE agt_agn_comm_dtl 
		updateQuery2.append("\n UPDATE AGT_BROG_COMM_DTL ");
		updateQuery2.append("\n   SET ACT_USD_COMM_AMT = ACT_USD_COMM_AMT + (? - ?) ");
		updateQuery2.append("\n WHERE BKG_NO = ? ");
		updateQuery2.append("\n   AND BROG_SEQ = ? ");
		updateQuery2.append("\n   AND CNTR_TPSZ_CD = (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = ? ");
		updateQuery2.append("\n	  AND ROWNUM = 1) ");
        
        ////7.GET CSR_AMOUNT
        selectQuery5.append("\n SELECT SUM(ROUND(A.ACT_IF_COMM_AMT,2)) ");
        selectQuery5.append("\n  FROM AGT_BROG_COMM A, AGT_COMM_BKG_INFO B ");
        selectQuery5.append("\n WHERE A.VNDR_SEQ = ? ");	//:vndr_seq        
        selectQuery5.append("\n   AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') = ? ");	//:frt_fwrd_cnt_cd        
        selectQuery5.append("\n   AND A.AP_OFC_CD = ? ");	//:ap_ofc_cd
        selectQuery5.append("\n   AND A.BROG_IF_DT IS NULL ");
        //2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	selectQuery5.append("\n         AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery5.append("\n         AND A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }
        selectQuery5.append("\n   AND A.COMM_PROC_STS_CD IN('CS','CM','CA') ");
        
        selectQuery5.append("\n   AND A.BKG_NO       = B.BKG_NO ");
        selectQuery5.append("\n   AND A.CRE_USR_ID != 'COST' ");
        selectQuery5.append("\n   AND B.BL_NO IS NOT NULL ");
        selectQuery5.append("\n   AND A.CSR_NO        = ? ");
        selectQuery5.append("\n   AND (A.BKG_NO, A.BROG_SEQ) IN  ");
        selectQuery5.append("\n       (SELECT BKG_NO, BROG_SEQ  ");
        selectQuery5.append("\n          FROM AGT_BROG_COMM ");
        //2008.10.06 권상준 SQL 튜닝
        if(stsOpt.equals("1")){
        	selectQuery5.append("\n         WHERE A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery5.append("\n         WHERE A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }else{
        	selectQuery5.append("\n         WHERE 1 = 1 ");
        }
        selectQuery5.append("\n           AND COMM_PROC_STS_CD IN('CS','CM','CA') ");
        
        selectQuery5.append("\n           AND BROG_IF_DT IS NULL ");
        selectQuery5.append("\n           AND CSR_NO     = ? ");
        selectQuery5.append("\n           AND VNDR_SEQ = ? ");	//:vndr_seq        
        selectQuery5.append("\n           AND FRT_FWRD_CNT_CD||TO_CHAR(FRT_FWRD_SEQ,'FM000000') = ? ");	//:frt_fwrd_cnt_cd        
        selectQuery5.append("\n       ) ");

        ////8.GET PAY_MZD_LU_CD, PAY_GRP_LU_CD
        selectQuery6.append("\n SELECT DECODE(B.CONTI_CD,'M','CMS CHECK(O/EXP)','E','CMS WIRE','WIRE'), ");
//        selectQuery6.append("\n       a.ap_ofc_cd||'_O/EXP' ");
        selectQuery6.append("\n       'NYCNA_BROKERAGE' ");
        selectQuery6.append("\n  FROM MDM_ORGANIZATION A, MDM_LOCATION B ");
        selectQuery6.append("\n WHERE A.OFC_CD = ? ");	//:ap_ofc_cd
        selectQuery6.append("\n   AND A.LOC_CD = B.LOC_CD ");
         
        ////9.GET COA_RGN_CD, COA_CTR_CD
        selectQuery7.append("\n SELECT NVL(FINC_RGN_CD,'00'), AP_CTR_CD, AR_HD_QTR_OFC_CD ");
        selectQuery7.append("\n  FROM MDM_ORGANIZATION ");
        selectQuery7.append("\n WHERE OFC_CD = ? ");	//:ap_ofc_cd
        selectQuery7.append("\n   AND NVL(DELT_FLG,'N') = 'N' ");
        
        // 마감월 체크하여 gl_dt(effDt 재셋팅)
        selectQuery8.append("\nSELECT DECODE (A.STS, 'O', ?, 'C', B.DT) ");
        selectQuery8.append("\n  FROM (SELECT CLZ_STS_CD AS STS ");
        selectQuery8.append("\n          FROM AP_PERIOD ");
        selectQuery8.append("\n         WHERE SYS_DIV_CD = 23 ");
        // 2008.06.25 권상준 추가 (AP_PERIOD 테이블 PK 추가에 따른 SQL 수정
        selectQuery8.append("\n           AND AR_AP_DIV_CD = 'P' ");
        selectQuery8.append("\n           AND OFC_CD = ? ");
        selectQuery8.append("\n           AND EFF_YRMON = SUBSTR (?, 1, 6)) A ");
        selectQuery8.append("\n     , (SELECT MIN (EFF_YRMON) || '01' AS DT ");
        selectQuery8.append("\n          FROM AP_PERIOD ");
        selectQuery8.append("\n         WHERE SYS_DIV_CD = 23 ");
        //2008.06.25 권상준 추가 (AP_PERIOD 테이블 PK 추가에 따른 SQL 수정
        selectQuery8.append("\n           AND AR_AP_DIV_CD = 'P' ");
        selectQuery8.append("\n           AND OFC_CD = ? ");
        selectQuery8.append("\n           AND CLZ_STS_CD = 'O' AND EFF_YRMON >= SUBSTR(REPLACE(?, '-'), 1, 6) ) B ");
        
        ////10.AP_INV_HDR INSERT
//        insertQuery2.append("\n INSERT INTO AP_INV_HDR ");
//        insertQuery2.append("\n      (CSR_NO, CSR_TP_CD, INV_DT, INV_TERM_DT, GL_DT, VNDR_NO, CSR_AMT, "); 					//1
//        insertQuery2.append("\n       PAY_AMT, PAY_DT, CSR_CURR_CD, VNDR_TERM_NM, INV_DESC, ATTR_CATE_NM, "); 				//2
//        insertQuery2.append("\n       ATTR_CTNT1, ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5, "); 						//3
//        insertQuery2.append("\n       ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, "); 						//4
//        insertQuery2.append("\n       ATTR_CTNT11, ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14, ATTR_CTNT15, "); 					//5
//        insertQuery2.append("\n       GLO_ATTR_CTNT1, GLO_ATTR_CTNT2, GLO_ATTR_CTNT3, GLO_ATTR_CTNT4, GLO_ATTR_CTNT5, "); 	//6
//        insertQuery2.append("\n       GLO_ATTR_CTNT6, GLO_ATTR_CTNT7, GLO_ATTR_CTNT8, GLO_ATTR_CTNT9, GLO_ATTR_CTNT10, "); 	//7
//        insertQuery2.append("\n       GLO_ATTR_CTNT11, GLO_ATTR_CTNT12, GLO_ATTR_CTNT13, GLO_ATTR_CTNT14, GLO_ATTR_CTNT15, "); //8
//        insertQuery2.append("\n       GLO_ATTR_CTNT16, GLO_ATTR_CTNT17, GLO_ATTR_CTNT18, "); 								//9
//        insertQuery2.append("\n       SRC_CTNT, PAY_MZD_LU_CD, PAY_GRP_LU_CD, COA_CO_CD, COA_RGN_CD, COA_CTR_CD, "); 		//10
//        insertQuery2.append("\n       COA_ACCT_CD, COA_VVD_CD, COA_INTER_CO_CD, COA_FTU_N1ST_CD, COA_FTU_N2ND_CD, "); 		//11
//        insertQuery2.append("\n       PPD_NO, PPD_DTRB_NO, PPD_APLY_AMT, PPD_GL_DT, APRO_FLG, TAX_DECL_FLG, ERR_CSR_NO, "); //12
//        insertQuery2.append("\n       IF_FLG, IF_DT, IF_ERR_RSN, PPAY_APLY_FLG, TJ_OFC_CD, ACT_XCH_RT, IMP_ERR_FLG, "); 	//13
//        insertQuery2.append("\n       RCV_ERR_FLG, TAX_CURR_XCH_FLG, USR_EML, IMP_ERR_RSN, RCV_ERR_RSN, "); 				//14
//        insertQuery2.append("\n       FTU_USE_CTNT1, FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CTNT5, "); 		//15
//        insertQuery2.append("\n       CRE_DT, CRE_USR_ID, EAI_EVNT_DT) "); 													//16
//        insertQuery2.append("\n VALUES(?, DECODE(SIGN(?),-1,'CREDIT','STANDARD'), REPLACE(?, '-'), REPLACE(?, '-'), REPLACE(?, '-'), ?, ROUND(?,2), "); //1
//        // 2008.11.18 권상준 추가 Invoice Date 는 무조건 Effective Date + 3 일로 셋팅한다.
//        insertQuery2.append("\n       0, null, 'USD', '3', ?, ?, "); 							//2
//        insertQuery2.append("\n       ?, null, null, null, null, "); 						//3
//        insertQuery2.append("\n       null, null, TO_CHAR(sysdate,'yyyymmddhh24miss'), null, ?, "); 						//4
//        insertQuery2.append("\n       null, null, null, null, null, "); 					//5
//        insertQuery2.append("\n       null, null, null, null, null, "); 					//6
//        insertQuery2.append("\n       null, null, null, null, null, "); 					//7
//        insertQuery2.append("\n       null, null, null, null, null, ");	 					//8
//        insertQuery2.append("\n       null, null, null, "); 								//9
//        insertQuery2.append("\n       ?, ?, ?, '01', ?, ?, "); 								//10
//        insertQuery2.append("\n       '210111', '0000000000', ?, '000000', '000000', "); //11
//        insertQuery2.append("\n       null, null, null, null, 'Y', 'N', null, "); 			//12
//        insertQuery2.append("\n       null, null, null, 'N', ?, null, null, "); 			//13
//        insertQuery2.append("\n       null, null, ?, null, null, "); 						//14
//        insertQuery2.append("\n       null, null, null, null, null, "); 					//15
//        insertQuery2.append("\n       SYSDATE, ?, SYSDATE) "); 								//16
        
        try{
        	con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	selectPs0 = new LoggableStatement(con, selectQuery0.toString());
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
            	selectPs2 = new LoggableStatement(con, selectQuery2.toString());
                selectPs3 = new LoggableStatement(con, selectQuery3.toString());
                insertPs1 = new LoggableStatement(con, insertQuery1.toString());
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
                selectPs4 = new LoggableStatement(con, selectQuery4.toString());
                selectPs5 = new LoggableStatement(con, selectQuery5.toString());
                selectPs6 = new LoggableStatement(con, selectQuery6.toString());
                selectPs7 = new LoggableStatement(con, selectQuery7.toString());
                selectPs8 = new LoggableStatement(con, selectQuery8.toString());
                selectPs9 = new LoggableStatement(con, selectQuery9.toString());
                selectPs10 = new LoggableStatement(con, selectQuery10.toString());
                selectPs11 = new LoggableStatement(con, selectQuery11.toString());
                selectPs12 = new LoggableStatement(con, selectQuery8.toString());
                updatePs2 = new LoggableStatement(con, updateQuery2.toString());
//                insertPs2 = new LoggableStatement(con, insertQuery2.toString());
            } else {
            	selectPs0 = con.prepareStatement(selectQuery0.toString());
            	selectPs1 = con.prepareStatement(selectQuery1.toString());
            	selectPs2 = con.prepareStatement(selectQuery2.toString());
                selectPs3 = con.prepareStatement(selectQuery3.toString());
                insertPs1 = con.prepareStatement(insertQuery1.toString());
                updatePs1 = con.prepareStatement(updateQuery1.toString());
                selectPs4 = con.prepareStatement(selectQuery4.toString());
                selectPs5 = con.prepareStatement(selectQuery5.toString());
                selectPs6 = con.prepareStatement(selectQuery6.toString());
                selectPs7 = con.prepareStatement(selectQuery7.toString());
                selectPs8 = con.prepareStatement(selectQuery8.toString());
                selectPs9 = con.prepareStatement(selectQuery9.toString());
                selectPs10 = con.prepareStatement(selectQuery10.toString());
                selectPs11 = con.prepareStatement(selectQuery11.toString());
                selectPs12 = con.prepareStatement(selectQuery8.toString());
                updatePs2 = con.prepareStatement(updateQuery2.toString());
//                insertPs2 = con.prepareStatement(insertQuery2.toString());
            }
            
        ////변수값 세팅
            userId = account.getUsr_id();
            userNm = account.getUsr_nm();
            userEm = account.getUsr_eml();
            rtnArray = new ArrayList();
            ////변수값 세팅.끝

            
            
            
            
            
            
        ////0.CHECK BKG_CRE_DT start
            i = 1;
            // 2008.10.06 권상준 SQL 튜닝 수정.
            if(stsOpt.equals("1")){
            	selectPs0.setString(i++, frDate);
            	selectPs0.setString(i++, toDate);
            }else if(stsOpt.equals("0")){
            	selectPs0.setString(i++, frDate);
            	selectPs0.setString(i++, toDate);
            }
            //String fwdrvndrSeqapOfcCd = "";
        	log.info("\n actualInterfaceMasterForBRKGVOs length BKG_CRE_DT start="+actualInterfaceMasterForBRKGVOs.length);
//        	for(int j=0; j<actualInterfaceMasterForBRKGVOs.length; j++){
//        		log.info("\n actualInterfaceMasterForBRKGVOs fwdr="+actualInterfaceMasterForBRKGVOs[j].getFwdr());
//        		log.info("\n actualInterfaceMasterForBRKGVOs getVndrSeq="+actualInterfaceMasterForBRKGVOs[j].getVndrSeq());
//        		log.info("\n actualInterfaceMasterForBRKGVOs getApOfcCd="+actualInterfaceMasterForBRKGVOs[j].getApOfcCd());
//        		selectPs0.setString(i++, (actualInterfaceMasterForBRKGVOs[j].getFwdr()+
//						actualInterfaceMasterForBRKGVOs[j].getVndrSeq()+
//						actualInterfaceMasterForBRKGVOs[j].getApOfcCd()));
//        	}
        	//Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL2 : \n" + ((LoggableStatement)selectPs0).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL2 : \n" + selectQuery0.toString() );
            }            
            rs0 = selectPs0.executeQuery();
//            ResultSetMetaData rsmd = rs0.getMetaData();
//            log.info("\n rsmd ="+rsmd);
//            int numberOfColumns = rsmd.getColumnCount();
//            log.info("\n rs0.next() ="+rs0.next());
//            log.info("\n numberOfColumns="+numberOfColumns);
			while (rs0.next()) {
				log.info("\n bkgNum="+rs0.getString(1));
				bkgNum = rs0.getString(1);
				bkgCreDt = rs0.getString(2);
//				
				if(bkgCreDt == null || Integer.parseInt(bkgCreDt) < 20070507){
					//[$s] does not exist!, Please check up Again!
                	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"[BKG:" + bkgNum + "]Booking creation date(" + bkgCreDt + ") does less than 2007-05-07 or "})).getMessage());
				}
			}
		////0.CHECK BKG_CRE_DT start
			
		////1.GET LOCAL_DATE, INVOICE_DATE, TERM_DATE, GL_DATE
            i = 1;
            selectPs1.setString(i++, locCd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL1 ::::::::: \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL1 : \n" + selectQuery1.toString() );
            }            
            rs1 = selectPs1.executeQuery();
            
            while (rs1.next()) {
            	log.info("\n localDt="+rs1.getString(1));
				localDt = rs1.getString(1);
				//invDt = rs1.getString(1);
				//termDt = rs1.getString(1);
				//glDt = rs1.getString(1);
			}
            
//            2.GET CSR_PART_NO, F.Forwarder, Vendor, AP_OFC_CD...
            i = 1;
         // 1-1 2007.08.17 추가 (CSR_NO 생성시 CSR_AMT 금액에 따라 CSR_NO 의 세번째 자리가 0이상이면 'S' 마이너스 금액이면 'C'
        	i = 1;
        	selectPs11.setString(i++, vndr_seq);
        	selectPs11.setString(i++, fwdr);
        	selectPs11.setString(i++, ap_ofc_cd);      
        	
            // 2008.10.06 권상준 SQL 튜닝 수정.
            if(stsOpt.equals("1")){
            	selectPs11.setString(i++, frDate);
            	selectPs11.setString(i++, toDate);
            }else if(stsOpt.equals("0")){
            	selectPs11.setString(i++, frDate);
            	selectPs11.setString(i++, toDate);
            }
        	
        	selectPs11.setString(i++, vndr_seq);
        	selectPs11.setString(i++, fwdr);       	
        	
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Update SQL1 ::::::::: \n" + ((LoggableStatement)selectPs11).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Update SQL1 : \n" + selectQuery11.toString() );
            }            
            rs11 = selectPs11.executeQuery();
            
            while (rs11.next()) {
            	csrAmt = rs11.getDouble(1);
            }
            closeResultSet(rs11);
            
            if(csrAmt >= 0){
            	csrNoGbn = "S";
            }else{
            	csrNoGbn = "C";
            }
            log.info("\n csrNoGbn = "+csrNoGbn);
        ////3.GET CSR_NO
            i = 1;
            selectPs3.setString(i++, csrNoGbn);
            selectPs3.setString(i++, ap_ofc_cd);
            selectPs3.setString(i++, localDt);
            selectPs3.setString(i++, csrNoGbn);
            selectPs3.setString(i++, ap_ofc_cd);
            selectPs3.setString(i++, localDt);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL3 ::::::::: \n" + ((LoggableStatement)selectPs3).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL3 : \n" + selectQuery3.toString() );
            }            
            rs3 = selectPs3.executeQuery();
            
            while (rs3.next()) {
				csrNo = rs3.getString(1);
				log.info("\n csrNo="+csrNo);
			}
            closeResultSet(rs3);
            
        ////4.AP_CSR_NO INSERT
        	i = 1;
        	insertPs1.setString(i++, csrNo);
        	
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Insert SQL1 ::::::::: \n" + ((LoggableStatement)insertPs1).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Insert SQL1 : \n" + insertQuery1.toString() );
            }            
            insertPs1.execute();
            
            
            
            
            ////0.CHECK BKG_CRE_DT start
        	i = 1;
        	selectPs2.setString(i++, vndr_seq);
        	selectPs2.setString(i++, fwdr);
        	selectPs2.setString(i++, ap_ofc_cd);
        	// 2008.10.06 권상준 SQL 튜닝 수정.
            if(stsOpt.equals("1")){
            	selectPs2.setString(i++, frDate);
            	selectPs2.setString(i++, toDate);
            }else if(stsOpt.equals("0")){
            	selectPs2.setString(i++, frDate);
            	selectPs2.setString(i++, toDate);
            }
        	
        	//Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL2 : \n" + ((LoggableStatement)selectPs2).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL2 : \n" + selectQuery2.toString() );
            }            
			
            selectPs2.executeUpdate();            
			
			

            
            
        ////5.AGT_BROG_COMM UPDATE
        	i = 1;
        	updatePs1.setString(i++, csrNo);
        	updatePs1.setString(i++, vndr_seq);
        	updatePs1.setString(i++, fwdr);
        	updatePs1.setString(i++, ap_ofc_cd);
        	// 2008.10.06 권상준 SQL 튜닝 수정.
            if(stsOpt.equals("1")){
            	updatePs1.setString(i++, frDate);
            	updatePs1.setString(i++, toDate);
            }else if(stsOpt.equals("0")){
            	updatePs1.setString(i++, frDate);
            	updatePs1.setString(i++, toDate);
            }
        	
        	
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Update SQL1 ::::::::: \n" + ((LoggableStatement)updatePs1).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Update SQL1 : \n" + updateQuery1.toString() );
            }            
            updatePs1.executeUpdate();
            
        ////6.GET VNDR_TERM_NM, COA_INTER_CMPY_CD
            i = 1;
            selectPs4.setString(i++, vndr_seq);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL4 ::::::::: \n" + ((LoggableStatement)selectPs4).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL4 : \n" + selectQuery4.toString() );
            }            
            rs4 = selectPs4.executeQuery();
            
        	while (rs4.next()) {
//				termNm = rs4.getString(1);
				coaIntrCmpyCd = rs4.getString(2);
				invDesc = rs4.getString(3);
			}
        	closeResultSet(rs4);
        	

			
		////7.GET CSR_AMOUNT           	
        	i = 1;
            selectPs5.setString(i++, vndr_seq);
            selectPs5.setString(i++, fwdr);
            selectPs5.setString(i++, ap_ofc_cd);    

            //2008.10.06 권상준 SQL 튜닝 수정.
            if(stsOpt.equals("1")){
            	selectPs5.setString(i++, frDate);
            	selectPs5.setString(i++, toDate);
            }else if(stsOpt.equals("0")){
            	selectPs5.setString(i++, frDate);
            	selectPs5.setString(i++, toDate);
            }
            
            selectPs5.setString(i++, csrNo);
            
            //2008.10.06 권상준 SQL 튜닝 수정.
            if(stsOpt.equals("1")){
            	selectPs5.setString(i++, frDate);
            	selectPs5.setString(i++, toDate);
            }else if(stsOpt.equals("0")){
            	selectPs5.setString(i++, frDate);
            	selectPs5.setString(i++, toDate);
            }                
            
            selectPs5.setString(i++, csrNo);                
            selectPs5.setString(i++, vndr_seq);
            selectPs5.setString(i++, fwdr);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL5 ::::::::: \n" + ((LoggableStatement)selectPs5).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL5 : \n" + selectQuery5.toString() );
            }            
            rs5 = selectPs5.executeQuery();
            
        	while (rs5.next()) {
        		csrAmt = rs5.getDouble(1);
			}
        	closeResultSet(rs5);
        	
        ////8.GET PAY_MZD_LU_CD, PAY_GRP_LU_CD
        	i = 1;
            selectPs6.setString(i++, ap_ofc_cd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL6 ::::::::: \n" + ((LoggableStatement)selectPs6).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL6 : \n" + selectQuery6.toString() );
            }            
            rs6 = selectPs6.executeQuery();
            
            if (rs6 != null) {
				while (rs6.next()) {
			        payMzdLuCd = rs6.getString(1);
			        payGrpLuCd = rs6.getString(2);
				}
			}
            closeResultSet(rs6);
            
        ////9.GET COA_RGN_CD, COA_CTR_CD
            i = 1;
            selectPs7.setString(i++, ap_ofc_cd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createBRKGCSRHeader]Select SQL7 ::::::::: \n" + ((LoggableStatement)selectPs7).getQueryString());
            } else {
                log.info("\n [createBRKGCSRHeader]Select SQL7 : \n" + selectQuery7.toString() );
            }            
            rs7 = selectPs7.executeQuery();
            
        	while (rs7.next()) {
				coaRgnCd = rs7.getString(1);
				coaCtrCd = rs7.getString(2);
				ar_hd_qtr_ofc_cd = rs7.getString(3);
			}
        	closeResultSet(rs7);
        	
       //// 마감월 체크하여 gl_dt(effDt 셋팅)
    		i = 1;
    		glDt = effDt;
            selectPs8.setString(i++, effDt);
            selectPs8.setString(i++, ap_ofc_cd);
            selectPs8.setString(i++, effDt);
            selectPs8.setString(i++, ap_ofc_cd);
            selectPs8.setString(i++, effDt);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createAGTCSRDistribution]Select SQL8 : \n" + ((LoggableStatement)selectPs8).getQueryString());
            } else {
                log.info("\n [createAGTCSRDistribution]Select SQL8 : \n" + selectQuery8.toString() );
            }            
            rs8 = selectPs8.executeQuery();
            
            while (rs8.next()) {
            	gl_dt_cnt = 1;
            	effDt = rs8.getString(1);
            } 
            closeResultSet(rs8);
            
         // 2008.08.21 권상준 추가 AP Office 로 GL Date 조회시 값이 없으면 ar_hd_qtr_ofc_cd 로 다시 조회
            if(gl_dt_cnt == 0 || effDt.equals("01")){
            	 //// 마감월 체크하여 gl_dt(effDt 셋팅)
        		i = 1;
                selectPs12.setString(i++, effDt);
                selectPs12.setString(i++, ar_hd_qtr_ofc_cd);
                selectPs12.setString(i++, effDt);
                selectPs12.setString(i++, ar_hd_qtr_ofc_cd);
                selectPs12.setString(i++, effDt);
                
                //Loggable Statement 사용에 의해 추가
                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                    log.info("\n [createAGTCSRDistribution]Select SQL10 : \n" + ((LoggableStatement)selectPs12).getQueryString());
                } else {
                    log.info("\n [createAGTCSRDistribution]Select SQL10 : \n" + selectQuery8.toString() );
                }            
                rs12 = selectPs12.executeQuery();
                
                while (rs12.next()) {
                	gl_dt_cnt = 1;
                	effDt = rs12.getString(1);
                }
                closeResultSet(rs12);
            }           
        ////10.AP_INV_HDR INSERT
        	i = 1;
        	insertPs2.setString(i++, csrNo);
        	insertPs2.setDouble(i++, csrAmt);
        	//insertPs2.setString(i++, invDt);
        	//insertPs2.setString(i++, termDt);
        	//insertPs2.setString(i++, glDt);
        	insertPs2.setString(i++, glDt);	//inv_dt
        	insertPs2.setString(i++, glDt);	//terms_dt
        	//insertPs2.setString(i++, termNm);	//pay_term
        	insertPs2.setString(i++, effDt);	//gl_dt
        	insertPs2.setString(i++, vndr_seq);
        	insertPs2.setDouble(i++, csrAmt);
        	//insertPs2.setString(i++, termNm);
        	insertPs2.setString(i++, invDesc);
        	insertPs2.setString(i++, attrCateNm);
        	insertPs2.setString(i++, attrCtnt1);
        	insertPs2.setString(i++, userNm);
        	insertPs2.setString(i++, srcCtnt);
        	insertPs2.setString(i++, payMzdLuCd);
        	insertPs2.setString(i++, payGrpLuCd);
        	insertPs2.setString(i++, coaRgnCd);
        	insertPs2.setString(i++, coaCtrCd);
        	insertPs2.setString(i++, coaIntrCmpyCd);
        	insertPs2.setString(i++, ap_ofc_cd);
        	insertPs2.setString(i++, userEm);
        	insertPs2.setString(i++, userId);
        	
            // Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n [createBRKGCSRHeader]Insert SQL2 ::::::::: \n" + ((LoggableStatement)insertPs2).getQueryString());
//            } else {
//                log.info("\n [createBRKGCSRHeader]Insert SQL2 : \n" + insertQuery2.toString() );
//            }            
//            insertPs2.execute();
            
            
            //CSR_NO, VENDOR_SEQ를 HashMap에 담아 ArrayList에 담는다.
            rtnHash = new HashMap();
            rtnHash.put("fwdr", fwdr);
            rtnHash.put("csrNo", csrNo);
            rtnHash.put("vndr", vndr_seq);
            rtnHash.put("apOfc", ap_ofc_cd);
            rtnHash.put("glDt", glDt);
            rtnArray.add(rtnHash);
            
        }catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {      
        	closeResultSet(rs0);
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeResultSet(rs3);
        	closeResultSet(rs4);
        	closeResultSet(rs5);
        	closeResultSet(rs6);
        	closeResultSet(rs7);
        	closeResultSet(rs8);
        	closeResultSet(rs9);
        	closeResultSet(rs10);
        	closeResultSet(rs11);
        	closeResultSet(rs12);
        	closeStatement(selectPs0);
        	closeStatement(selectPs1);
            closeStatement(selectPs2);
            closeStatement(selectPs3);
            closeStatement(insertPs1);
            closeStatement(updatePs1);
            closeStatement(selectPs4);
            closeStatement(selectPs5);
            closeStatement(selectPs6);
            closeStatement(selectPs7);
            closeStatement(selectPs8);
            closeStatement(selectPs9);
            closeStatement(selectPs10);
            closeStatement(selectPs11);
            closeStatement(selectPs12);
            closeStatement(updatePs2);
            closeStatement(insertPs2);
            closeConnection(con);
        }
		return rtnArray;
	}


	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param String fwdr
	 * @param String csrNo
	 * @param String vndr
	 * @param String apOfc
	 * @param String glDt
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws EventException
	 */
	public DBRowSet createBRKGCSRDistributionOne(
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO,
			String fwdr, String csrNo, String vndr, String apOfc, String glDt, SignOnUserAccount account) throws DAOException, EventException{
		Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs1 = null; // INSERT를 수행하기 위한 SQL Statement
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement updatePs2 = null; // UPDATE를 수행하기 위한 SQL Statement
        
        ResultSet rs1 = null;	// DB ResultSet
        DBRowSet dRs = null;	// DB DBRowSet
        int i = 1;				// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String userId = "";		//event
        String regionCd  = "";
        String centerCd  = "";
        String accountCd = "";
        String vvdCd 	 = "";
        String bkgNo     = "";
        String blNo      = "";
        // 2008.11.24 권상준 수정 (소스품질검토 결과에 따른 삭제 처리)
//        String inv_desc = "BROKERAGE";
        
//      2008.03.17-sunganj Approval & Request 조건으로 날짜 추가   
        String stsOpt = "";
        String frDate = "";
        String toDate = "";
    	
    	// 2008.02.14-sunganj Approval & Request 조건으로 날짜 추가     
    	stsOpt = actualInterfaceMasterForBRKGVO.getStsOption();
    	frDate = actualInterfaceMasterForBRKGVO.getSearchDtFr();
        toDate = actualInterfaceMasterForBRKGVO.getSearchDtTo();
       
//        frDate = frDate.substring(0,4) + frDate.substring(5,7) + frDate.substring(8);
//        toDate = toDate.substring(0,4) + toDate.substring(5,7) + toDate.substring(8);
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer insertQuery1 = new StringBuffer();
        StringBuffer updateQuery1 = new StringBuffer();
        StringBuffer updateQuery2 = new StringBuffer();
//        
        ////1.GET AP_INV_DSTR 
        selectQuery1.append("\n SELECT Y.CSR_NO, ");
        selectQuery1.append("\n       ROW_NUMBER() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_SEQ, ");
    	selectQuery1.append("\n       DENSE_RANK() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_NUMBER, ");
        selectQuery1.append("\n       X.LOOKUP, X.INV_AMT, X.INV_DESC, X.TAX_CD, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD, ");
        selectQuery1.append("\n       X.INTR_CMPY, X.FUTURE1, X.FUTURE2, X.ATT_CTLG, X.ATT1, X.ATT2, X.ATT3, X.ATT4, X.ATT5, ");
        selectQuery1.append("\n       X.ATT6, X.ATT7, X.ATT8, X.ATT9, X.ATT10, X.ATT11, X.ATT12, X.ATT13, X.ATT14, X.ATT15, ");
        selectQuery1.append("\n       X.BKG_NO, X.TPSZ, X.REV_VVD, X.DIV_CD, X.CARRIER, X.YARD, X.COST_CODE, ");
        selectQuery1.append("\n       X.QTY, X.TMNL_CD, X.AGNT, X.SUB_FLG, X.BL_NO ");
        selectQuery1.append("\n  FROM (SELECT A.VNDR_SEQ VNDR, ");
        selectQuery1.append("\n               'ITEM' AS LOOKUP, ");
        selectQuery1.append("\n               ROUND(NVL(B.ACT_USD_COMM_AMT,A.ACT_IF_COMM_AMT),2) AS INV_AMT, ");
        selectQuery1.append("\n               (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = A.COMM_STND_COST_CD)||'/'||A.BKG_NO AS INV_DESC, ");
        selectQuery1.append("\n               '' AS TAX_CD, ");
        selectQuery1.append("\n               '01' AS COMPANY, ");
        selectQuery1.append("\n               NVL((SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD),'00') AS REGION, ");
        selectQuery1.append("\n               (SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD) AS CENTER, A.COMM_STND_COST_CD ACCT, ");
        selectQuery1.append("\n        	      (SELECT DECODE(SUBSTR(REV_VVD_CD,0,2),'FD','CFDR'||SUBSTR(REV_VVD_CD,3,4)||'EE',REV_VVD_CD) FROM AGT_COMM_BKG_INFO WHERE BKG_NO = A.BKG_NO ) AS VVD, ");
    	selectQuery1.append("\n               (SELECT NVL(LTRIM(SUBS_CO_CD),'00') FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS INTR_CMPY, ");
    	selectQuery1.append("\n               '000000' AS FUTURE1, ");
    	selectQuery1.append("\n               '000000' AS FUTURE2, ");
    	selectQuery1.append("\n               A.COMM_STND_COST_CD AS ATT_CTLG, ");
        selectQuery1.append("\n               C.BL_NO||SUBSTR(TO_CHAR(A.BROG_SEQ,'FM000000'),4,6) AS ATT1, ");
        selectQuery1.append("\n               SUBSTR(?, 0, 4)||'/'||SUBSTR(?, 5, 2)||'/'||SUBSTR(?, 7, 2)||' 00:00:00' AS ATT2, ");
        selectQuery1.append("\n               A.COMM_OCCR_INFO_CD AS ATT3, ");
        selectQuery1.append("\n               '' AS ATT4, '' AS ATT5, '' AS ATT6, '' AS ATT7, '' AS ATT8, '' AS ATT9, ");
        selectQuery1.append("\n               '' AS ATT10, '' AS ATT11, '' AS ATT12, '' AS ATT13, '' AS ATT14, '' AS ATT15, ");
        selectQuery1.append("\n               A.BKG_NO, ");
        selectQuery1.append("\n               B.CNTR_TPSZ_CD AS TPSZ, ");
        selectQuery1.append("\n               DECODE(A.COMM_SLAN_CD||SUBSTR(A.COMM_VSL_CD,0,2),'RBCFD','CFDR'||SUBSTR(A.COMM_VSL_CD,3,2)||SUBSTR(COMM_SKD_VOY_NO,0,2)||'EE', "); 
    	selectQuery1.append("\n                      A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||NVL(A.COMM_REV_DIR_CD,A.COMM_SKD_DIR_CD)) AS REV_VVD, ");
    	selectQuery1.append("\n               'C' AS DIV_CD, ");
        selectQuery1.append("\n               '' AS CARRIER, ");
        selectQuery1.append("\n               '' AS YARD, ");
        selectQuery1.append("\n               '' AS COST_CODE, ");
        selectQuery1.append("\n               B.BKG_VOL_QTY AS QTY, ");
        selectQuery1.append("\n               '' AS TMNL_CD, ");
        selectQuery1.append("\n               '' AS AGNT, ");
        selectQuery1.append("\n               '' AS SUB_FLG, ");
        selectQuery1.append("\n               C.BL_NO AS BL_NO, ");
        selectQuery1.append("\n               A.CSR_NO AS CSR_NO ");
        selectQuery1.append("\n          FROM AGT_BROG_COMM A, AGT_BROG_COMM_DTL B, AGT_COMM_BKG_INFO C ");
        selectQuery1.append("\n         WHERE A.BROG_IF_DT IS NULL ");
        
        if(stsOpt.equals("1")){
        	selectQuery1.append("\n         AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	selectQuery1.append("\n         AND A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }

        selectQuery1.append("\n           AND A.COMM_PROC_STS_CD IN('CS','CM','CA') ");
        selectQuery1.append("\n           AND A.VNDR_SEQ  = ? ");	//:vndr_seq
        
        selectQuery1.append("\n           AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') = ? ");	//:frt_fwrd_cnt_cd
        
        selectQuery1.append("\n           AND A.AP_OFC_CD = ? ");	//:ap_ofc_cd
        selectQuery1.append("\n           AND A.CRE_USR_ID != 'COST' ");
        selectQuery1.append("\n           AND A.CSR_NO IS NOT NULL ");
        selectQuery1.append("\n           AND C.BL_NO IS NOT NULL ");
        selectQuery1.append("\n           AND (a.bkg_no, a.brog_seq) IN ");
        selectQuery1.append("\n               (SELECT bkg_no,   brog_seq ");
        selectQuery1.append("\n                  FROM agt_brog_comm ");
        selectQuery1.append("\n                 WHERE brog_if_dt IS NULL ");
        selectQuery1.append("\n                   AND comm_proc_sts_cd IN('CS','CM','CA') ");
        selectQuery1.append("\n                   AND vndr_seq  = ? ");	//:vndr_seq
        
        selectQuery1.append("\n                   AND frt_fwrd_cnt_cd||TO_CHAR(frt_fwrd_seq,'FM000000') = ? ");	//:frt_fwrd_cnt_cd
        
        selectQuery1.append("\n                   AND ap_ofc_cd = ? ");	//:ap_ofc_cd
        selectQuery1.append("\n                   AND csr_no is not null ");
        selectQuery1.append("\n                   AND cre_usr_id != 'COST' ");
        selectQuery1.append("\n                 ) ");
        selectQuery1.append("\n           AND a.bkg_no       = b.bkg_no(+) ");
        selectQuery1.append("\n           AND a.brog_seq     = b.brog_seq(+) ");
        selectQuery1.append("\n           AND a.bkg_no       = c.bkg_no(+) ");
        selectQuery1.append("\n       ) x, ");
        selectQuery1.append("\n       (SELECT csr_no, vndr_no ");
        selectQuery1.append("\n          FROM ap_inv_hdr ");
        selectQuery1.append("\n         WHERE csr_no = ? ");	//:csr_no
        selectQuery1.append("\n       ) y ");
        selectQuery1.append("\n WHERE x.vndr = y.vndr_no ");
        selectQuery1.append("\n AND   x.csr_no = y.csr_no ");
        	
        ////6.AP_INV_DSTR INSERT
        insertQuery1.append("\nINSERT INTO ap_inv_dtrb ");
        insertQuery1.append("\n       (csr_no, line_seq, line_no, line_tp_lu_cd, inv_amt, inv_desc, inv_tax_cd, ");
        insertQuery1.append("\n        dtrb_coa_co_cd, dtrb_coa_rgn_cd, dtrb_coa_ctr_cd, dtrb_coa_acct_cd, ");
        insertQuery1.append("\n        dtrb_coa_vvd_cd, dtrb_coa_inter_co_cd, dtrb_coa_ftu_n1st_cd, dtrb_coa_ftu_n2nd_cd, ");
        insertQuery1.append("\n        attr_cate_nm, attr_ctnt1, attr_ctnt2, attr_ctnt3, attr_ctnt4, attr_ctnt5, ");
        insertQuery1.append("\n        attr_ctnt6, attr_ctnt7, attr_ctnt8, attr_ctnt9, attr_ctnt10, ");
        insertQuery1.append("\n        attr_ctnt11, attr_ctnt12, attr_ctnt13, attr_ctnt14, attr_ctnt15, ");
        insertQuery1.append("\n        bkg_no, cntr_tpsz_cd, act_vvd_cd, pln_sctr_div_cd, ");
        insertQuery1.append("\n        so_crr_cd, yd_cd, ftu_use_ctnt1, ftu_use_ctnt2, ftu_use_ctnt3, ");
        insertQuery1.append("\n        ftu_use_ctnt4, ftu_use_ctnt5, cre_dt, cre_usr_id, eai_evnt_dt) ");
        insertQuery1.append("\n SELECT Y.CSR_NO, ");
        insertQuery1.append("\n       ROW_NUMBER() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_SEQ, ");
    	insertQuery1.append("\n       DENSE_RANK() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_NUMBER, ");
        insertQuery1.append("\n       X.LOOKUP, X.INV_AMT, X.INV_DESC, X.TAX_CD, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD, ");
        insertQuery1.append("\n       X.INTR_CMPY, X.FUTURE1, X.FUTURE2, X.ATT_CTLG, X.ATT1, X.ATT2, X.ATT3, X.ATT4, X.ATT5, ");
        insertQuery1.append("\n       X.ATT6, X.ATT7, X.ATT8, X.ATT9, X.ATT10, X.ATT11, X.ATT12, X.ATT13, X.ATT14, X.ATT15, ");
        insertQuery1.append("\n       X.BKG_NO, X.TPSZ, X.REV_VVD, X.DIV_CD, X.CARRIER, X.YARD, X.COST_CODE, ");
        insertQuery1.append("\n       X.QTY, X.TMNL_CD, X.AGNT, X.SUB_FLG, SYSDATE, ?, SYSDATE ");
        insertQuery1.append("\n  FROM (SELECT A.VNDR_SEQ VNDR, ");
        insertQuery1.append("\n               'ITEM' AS LOOKUP, ");
        insertQuery1.append("\n               ROUND(NVL(B.ACT_USD_COMM_AMT,A.ACT_IF_COMM_AMT),2) AS INV_AMT, ");
        insertQuery1.append("\n               (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = A.COMM_STND_COST_CD)||'/'||A.BKG_NO AS INV_DESC, ");
        insertQuery1.append("\n               '' AS TAX_CD, ");
        insertQuery1.append("\n               '01' AS COMPANY, ");
        insertQuery1.append("\n               NVL((SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD),'00') AS REGION, ");
        insertQuery1.append("\n               (SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD) AS CENTER, A.COMM_STND_COST_CD ACCT, ");
        insertQuery1.append("\n        	      (SELECT DECODE(SUBSTR(REV_VVD_CD,0,2),'FD','CFDR'||SUBSTR(REV_VVD_CD,3,4)||'EE',REV_VVD_CD) FROM AGT_COMM_BKG_INFO WHERE BKG_NO = A.BKG_NO ) AS VVD, ");
    	insertQuery1.append("\n               (SELECT NVL(LTRIM(SUBS_CO_CD),'00') FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS INTR_CMPY, ");
    	insertQuery1.append("\n               '000000' AS FUTURE1, ");
    	insertQuery1.append("\n               '000000' AS FUTURE2, ");
    	insertQuery1.append("\n               A.COMM_STND_COST_CD AS ATT_CTLG, ");
        insertQuery1.append("\n               C.BL_NO||SUBSTR(TO_CHAR(A.BROG_SEQ,'FM000000'),4,6) AS ATT1, ");
        insertQuery1.append("\n               SUBSTR(?, 0, 4)||'/'||SUBSTR(?, 5, 2)||'/'||SUBSTR(?, 7, 2)||' 00:00:00' AS ATT2, ");
        insertQuery1.append("\n               A.COMM_OCCR_INFO_CD AS ATT3, ");
        insertQuery1.append("\n               '' AS ATT4, '' AS ATT5, '' AS ATT6, '' AS ATT7, '' AS ATT8, '' AS ATT9, ");
        insertQuery1.append("\n               '' AS ATT10, '' AS ATT11, '' AS ATT12, '' AS ATT13, '' AS ATT14, '' AS ATT15, ");
        insertQuery1.append("\n               A.BKG_NO, ");
        insertQuery1.append("\n               B.CNTR_TPSZ_CD AS TPSZ, ");
        insertQuery1.append("\n               DECODE(A.COMM_SLAN_CD||SUBSTR(A.COMM_VSL_CD,0,2),'RBCFD','CFDR'||SUBSTR(A.COMM_VSL_CD,3,2)||SUBSTR(COMM_SKD_VOY_NO,0,2)||'EE', "); 
    	insertQuery1.append("\n                      A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||NVL(A.COMM_REV_DIR_CD,A.COMM_SKD_DIR_CD)) AS REV_VVD, ");
    	insertQuery1.append("\n               'C' AS DIV_CD, ");
        insertQuery1.append("\n               '' AS CARRIER, ");
        insertQuery1.append("\n               '' AS YARD, ");
        insertQuery1.append("\n               '' AS COST_CODE, ");
        insertQuery1.append("\n               B.BKG_VOL_QTY AS QTY, ");
        insertQuery1.append("\n               '' AS TMNL_CD, ");
        insertQuery1.append("\n               '' AS AGNT, ");
        insertQuery1.append("\n               '' AS SUB_FLG, ");
        insertQuery1.append("\n               C.BL_NO AS BL_NO, ");
        insertQuery1.append("\n               A.CSR_NO AS CSR_NO ");
        insertQuery1.append("\n          FROM AGT_BROG_COMM A, AGT_BROG_COMM_DTL B, AGT_COMM_BKG_INFO C ");
        insertQuery1.append("\n         WHERE A.BROG_IF_DT IS NULL ");
        
        if(stsOpt.equals("1")){
        	insertQuery1.append("\n         AND A.VSL_DEP_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");//:stsOpt,:frDate,:toDate
        }else if(stsOpt.equals("0")){
        	insertQuery1.append("\n         AND A.CRE_DT BETWEEN TO_DATE(REPLACE(?, '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(?, '-'), 'YYYYMMDD')+0.999999 ");
        }

        insertQuery1.append("\n           AND A.COMM_PROC_STS_CD IN('CS','CM','CA') ");
        insertQuery1.append("\n           AND A.VNDR_SEQ  = ? ");	//:vndr_seq
        
        insertQuery1.append("\n           AND A.FRT_FWRD_CNT_CD||TO_CHAR(A.FRT_FWRD_SEQ,'FM000000') = ? ");	//:frt_fwrd_cnt_cd
        
        insertQuery1.append("\n           AND A.AP_OFC_CD = ? ");	//:ap_ofc_cd
        insertQuery1.append("\n           AND A.CRE_USR_ID != 'COST' ");
        insertQuery1.append("\n           AND A.CSR_NO IS NOT NULL ");
        insertQuery1.append("\n           AND C.BL_NO IS NOT NULL ");
        insertQuery1.append("\n           AND (a.bkg_no, a.brog_seq) IN ");
        insertQuery1.append("\n               (SELECT bkg_no,   brog_seq ");
        insertQuery1.append("\n                  FROM agt_brog_comm ");
        insertQuery1.append("\n                 WHERE brog_if_dt IS NULL ");
        insertQuery1.append("\n                   AND comm_proc_sts_cd IN('CS','CM','CA') ");
        insertQuery1.append("\n                   AND vndr_seq  = ? ");	//:vndr_seq
        
        insertQuery1.append("\n                   AND frt_fwrd_cnt_cd||TO_CHAR(frt_fwrd_seq,'FM000000') = ? ");	//:frt_fwrd_cnt_cd
        
        insertQuery1.append("\n                   AND ap_ofc_cd = ? ");	//:ap_ofc_cd
        insertQuery1.append("\n                   AND csr_no is not null ");
        insertQuery1.append("\n                   AND cre_usr_id != 'COST' ");
        insertQuery1.append("\n                 ) ");
        insertQuery1.append("\n           AND a.bkg_no       = b.bkg_no(+) ");
        insertQuery1.append("\n           AND a.brog_seq     = b.brog_seq(+) ");
        insertQuery1.append("\n           AND a.bkg_no       = c.bkg_no(+) ");
        insertQuery1.append("\n       ) x, ");
        insertQuery1.append("\n       (SELECT csr_no, vndr_no ");
        insertQuery1.append("\n          FROM ap_inv_hdr ");
        insertQuery1.append("\n         WHERE csr_no = ? ");	//:csr_no
        insertQuery1.append("\n       ) y ");
        insertQuery1.append("\n WHERE x.vndr = y.vndr_no ");
        insertQuery1.append("\n AND   x.csr_no = y.csr_no ");


        ////7.CHECK HDR_AMT vs DTRB_AMT
        updateQuery1.append("\nUPDATE ap_inv_dtrb a ");
		updateQuery1.append("\n   SET inv_amt = ROUND(inv_amt + (SELECT x.csr_amt - SUM(y.inv_amt) ");
		updateQuery1.append("\n                              FROM ap_inv_hdr x, ap_inv_dtrb y ");
		updateQuery1.append("\n                             WHERE x.csr_no = ? "); //:csrNo
		updateQuery1.append("\n                               AND x.csr_no = y.csr_no ");
		updateQuery1.append("\n                             GROUP BY x.csr_amt),2) ");
		updateQuery1.append("\n WHERE csr_no = ? "); //:csrNo
		updateQuery1.append("\n   AND (line_seq,line_no) IN (SELECT line_seq, line_no ");
		updateQuery1.append("\n                                FROM ap_inv_dtrb ");
		updateQuery1.append("\n                               WHERE csr_no = a.csr_no ");
		updateQuery1.append("\n                                 AND ROWNUM = 1) ");

		////8. UPDATE agt_comm_bkg_info
		updateQuery2.append("\nUPDATE agt_comm_bkg_info ");
		updateQuery2.append("\n   SET rev_vvd_cd = ? ");
		updateQuery2.append("\n WHERE bkg_no = ? ");
		
		try{
			con = getConnection();
            
                selectPs1 = new LoggableStatement(con, selectQuery1.toString());
                insertPs1 = new LoggableStatement(con, insertQuery1.toString());
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
                updatePs2 = new LoggableStatement(con, updateQuery2.toString());

        ////변수값 세팅
            userId = account.getUsr_id();
            ////끝
            	
	            ////1.GET AP_INV_DSTR
	            i = 1;
	            selectPs1.setString(i++, glDt);
	            selectPs1.setString(i++, glDt);
	            selectPs1.setString(i++, glDt);
	            
                //2008.10.06 권상준 SQL 튜닝 수정.
                if(stsOpt.equals("1")){
                	selectPs1.setString(i++, frDate);
                	selectPs1.setString(i++, toDate);
                }else if(stsOpt.equals("0")){
                	selectPs1.setString(i++, frDate);
                	selectPs1.setString(i++, toDate);
                }	            
	            
	            selectPs1.setInt(i++, Integer.parseInt(vndr));
	            selectPs1.setString(i++, fwdr);
	            selectPs1.setString(i++, apOfc);
	            selectPs1.setInt(i++, Integer.parseInt(vndr));
	            selectPs1.setString(i++, fwdr);
	            selectPs1.setString(i++, apOfc);
	            selectPs1.setString(i++, csrNo);
                log.info("\n [createBRKGCSRDistribution]Select SQL1 ::::::::: \n" + ((LoggableStatement)selectPs1).getQueryString());
	            rs1 = selectPs1.executeQuery();
	            
            	while(rs1.next()) {
					regionCd  = rs1.getString(9);
				    centerCd  = rs1.getString(10);
				    accountCd = rs1.getString(11);
				    vvdCd     = rs1.getString(12);
				    bkgNo     = rs1.getString(32);
				    blNo      = rs1.getString(43);
				     
				    //CHECK(1)
				    if(regionCd == null || regionCd.length() < 1){
				    	//[Region Code] does not exist!, Please check up Again!
				    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Region Code"})).getMessage());
				    }

				    //CHECK(2)
				    if(centerCd == null || centerCd.length() < 1){
				    	//[Center Code] does not exist!, Please check up Again!
				    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Center Code"})).getMessage());
				    }
				    
				    //CHECK(3)
				    if(blNo == null || blNo.length() < 1){
				    	//[BL No] does not exist!, Please check up Again!
				    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"[vendor : " + vndr + "]BL No"})).getMessage());
				    }
				    
//				    if(vvdCd == null || vvdCd == "") {
//				    	this.processProcedure(bkgNo);
//				    }
				    
				    if(vvdCd == null || vvdCd == "") {
						//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
						throw new DAOException((new ErrorHandler("AGT00030", new String[]{vvdCd})).getMessage());
		            }
				    
				    createBRKGCSRDistributionCheck(con, bkgNo, vvdCd, csrNo, accountCd, stsOpt, frDate, toDate, userId);
            	}//while (rs1.next()) {
	            ////6.AP_INV_DSTR INSERT
	        	i = 1;
	        	insertPs1.setString(i++, userId);
	        	insertPs1.setString(i++, glDt);
	            insertPs1.setString(i++, glDt);
	            insertPs1.setString(i++, glDt);
	            
                //2008.10.06 권상준 SQL 튜닝 수정.
                if(stsOpt.equals("1")){
                	insertPs1.setString(i++, frDate);
                	insertPs1.setString(i++, toDate);
                }else if(stsOpt.equals("0")){
                	insertPs1.setString(i++, frDate);
                	insertPs1.setString(i++, toDate);
                }	            
	            
	            insertPs1.setInt(i++, Integer.parseInt(vndr));
	            insertPs1.setString(i++, fwdr);
	            insertPs1.setString(i++, apOfc);
	            insertPs1.setInt(i++, Integer.parseInt(vndr));
	            insertPs1.setString(i++, fwdr);
	            insertPs1.setString(i++, apOfc);
	            insertPs1.setString(i++, csrNo);

	        	
                log.info("\n [createBRKGCSRDistribution]Insert SQL1 ::::::::: \n" + ((LoggableStatement)insertPs1).getQueryString());
	            insertPs1.execute();             	
    			////7.CHECK AMOUNT
    			i = 1;
                updatePs1.setString(i++, csrNo);
                updatePs1.setString(i++, csrNo);
                log.info("\n [createBRKGCSRDistribution]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
                updatePs1.executeUpdate();
                
    			////8.CHECK AMOUNT
    			i = 1;
                updatePs2.setString(i++, vvdCd);
                updatePs2.setString(i++, bkgNo);
                                
                log.info("\n [createAGTCSRDistribution]Update SQL1 : \n" + ((LoggableStatement)updatePs2).getQueryString());
                updatePs2.executeUpdate();
		}
		catch (SQLException se)
		{
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
		catch (DAOException de)
		{
            log.error(de.getMessage(),de);
            throw de;
        }
		catch (Exception e)
		{
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
		finally
		{
        	closeResultSet(rs1);
        	closeStatement(selectPs1);
            closeStatement(insertPs1);
            closeStatement(updatePs1);
            closeStatement(updatePs2);
            closeConnection(con);
        }
		return dRs;
				
	}
	
	/**
	 * CSR_NO 생성시 CSR_AMT 금액에 따라 0 이상이면 'S' 마이너스이면 'C' 로 CSR Gubun<br>
	 * @param Connection con
	 * @param String bkgNo
	 * @param String vvdCd
	 * @param String csrNo
	 * @param String accountCd
	 * @param String stsOpt
	 * @param String frDate
	 * @param String toDate
	 * @param String userId
	 * @throws DAOException
	 * @throws EventException
	 */
	public void createBRKGCSRDistributionCheck (
		Connection con, String bkgNo, String vvdCd, String csrNo, String accountCd,
		String stsOpt, String frDate, String toDate, String userId
		) throws DAOException, EventException
	{
		PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
		PreparedStatement selectPs3 = null; // SELECT를 수행하기 위한 SQL Statement
		PreparedStatement selectPs4 = null; // SELECT를 수행하기 위한 SQL Statement
		PreparedStatement selectPs5 = null; // SELECT를 수행하기 위한 SQL Statement

		ResultSet rs2 = null;	// DB ResultSet
		ResultSet rs3 = null;	// DB ResultSet
		ResultSet rs4 = null;	// DB ResultSet
		ResultSet rs5 = null;	// DB ResultSet
		int i = 1;				// PreparedStatement에 bind 변수를 넣을시 증가되는 변수

		int vvdCnt 	 = 0;
		String vvdLevel  = "";
		String vvdFlag   = "";

		StringBuffer selectQuery2 = new StringBuffer();
		StringBuffer selectQuery3 = new StringBuffer();
		StringBuffer selectQuery4 = new StringBuffer();
		StringBuffer selectQuery5 = new StringBuffer();

		////2.GET VVD_COUNT
		selectQuery2.append("\nSELECT COUNT(*) ");
		selectQuery2.append("\n  FROM ar_rout_rnk ");
		selectQuery2.append("\n WHERE rlane_cd = (SELECT rlane_cd ");
		selectQuery2.append("\n                     FROM agt_comm_bkg_info ");
		selectQuery2.append("\n                    WHERE bkg_no = ?) "); //:bkgNo

		////3.GET VVD_CD
		selectQuery3.append("\nSELECT 'CFDR'||SUBSTR(gl_dt,3,4)||'EE' ");
		selectQuery3.append("\n  FROM ap_inv_hdr ");
		selectQuery3.append("\n WHERE csr_no = ? "); //:csrNo 

		////4.GET VVD_COM_LVL
		selectQuery4.append("\nSELECT vvd_com_lvl lvl ");
		selectQuery4.append("\n  FROM ar_mst_rev_vvd ");
		selectQuery4.append("\n WHERE vsl_cd     = SUBSTR(?,1,4) ");	//:vvd
		selectQuery4.append("\n   AND skd_voy_no = SUBSTR(?,5,4) ");	//:vvd
		selectQuery4.append("\n   AND skd_dir_cd = SUBSTR(?,9,1) ");	//:vvd
		selectQuery4.append("\n   AND rlane_dir_cd = SUBSTR(?,10,1) ");

		////5.GET VVD_LVL_FLG
		selectQuery5.append("\nSELECT NVL(DECODE(?,'1',vvd_lvl_flg1, ");	//:vvd_level
		selectQuery5.append("\n                    '2',vvd_lvl_flg2, "); 
		selectQuery5.append("\n                    '3',vvd_lvl_flg3, ");
		selectQuery5.append("\n                    '4',vvd_lvl_flg4, ");
		selectQuery5.append("\n                    '5',vvd_lvl_flg5,vvd_lvl_flg6),'N') ");
		selectQuery5.append("\n  FROM mdm_account ");
		selectQuery5.append("\n WHERE acct_cd = ? ");	//:acctount_cd

		try
		{
			selectPs2 = new LoggableStatement(con, selectQuery2.toString());
			selectPs3 = new LoggableStatement(con, selectQuery3.toString());
			selectPs4 = new LoggableStatement(con, selectQuery4.toString());
			selectPs5 = new LoggableStatement(con, selectQuery5.toString());

			////2.CHECK VVD_COUNT
			i = 1;
			selectPs2.setString(i++, bkgNo);
			log.info("\n [createBRKGCSRDistribution]Select SQL2 : \n" + ((LoggableStatement)selectPs2).getQueryString());
			rs2 = selectPs2.executeQuery();

			while (rs2.next())
			{
				vvdCnt = rs2.getInt(1);
			}
			closeResultSet(rs2);

			if (!vvdCd.substring(1,4).equals("CNTC"))
			{
				vvdLevel = "";
				vvdFlag  = "";

				////3.GET VVD
				if (vvdCnt < 1)
				{
					i = 1;
					selectPs3.setString(i++, csrNo);
					log.info("\n [createBRKGCSRDistribution]Select SQL3 : \n" + ((LoggableStatement)selectPs3).getQueryString());
					rs3 = selectPs3.executeQuery();

					if (rs3.next())
					{
						vvdCd = rs3.getString(1);
					}
				}//if(vvdCnt < 1){				    

				////4.GET VVD_LEVEL_FLAG
				i = 1;
				selectPs4.setString(i++, vvdCd);
				selectPs4.setString(i++, vvdCd);
				selectPs4.setString(i++, vvdCd);
				selectPs4.setString(i++, vvdCd);
				log.info("\n [createBRKGCSRDistribution]Select SQL4 : \n" + ((LoggableStatement)selectPs4).getQueryString());
				rs4 = selectPs4.executeQuery();

				if (rs4.next())
				{
					vvdLevel = rs4.getString(1);
				}
				//CHECK
				if(vvdLevel == null || vvdLevel.length() < 1)
				{
					//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
					throw new DAOException((new ErrorHandler("AGT00030", new String[]{vvdCd})).getMessage());
				}

				////5.GET VVD_LVL_FLG
				i = 1;
				selectPs5.setString(i++, vvdLevel);
				selectPs5.setString(i++, (accountCd==null?"":accountCd));
				log.info("\n [createBRKGCSRDistribution]Select SQL5 : \n" + ((LoggableStatement)selectPs5).getQueryString());
				rs5 = selectPs5.executeQuery();

				if (rs5.next())
				{
					vvdFlag = rs5.getString(1);
				}

				//CHECK
				if(!vvdFlag.equals("Y"))
				{
					//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
					throw new DAOException((new ErrorHandler("AGT00030", new String[]{vvdCd})).getMessage());
				}
			}//if(!vvdCd.substring(1,4).equals("CNTN")){
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(),de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
		throw new DAOException(e.getMessage());
		}
		finally
		{
			closeResultSet(rs2);
			closeResultSet(rs3);
			closeResultSet(rs4);
			closeResultSet(rs5);
			closeStatement(selectPs2);
			closeStatement(selectPs3);
			closeStatement(selectPs4);
			closeStatement(selectPs5);
		}
	}


	/**
	 * AP_INV_HDR에 최종 결재자 정보를 저장한다.<br>
	 * @param String csrNo
	 * @param String aproNm
	 * @throws DAOException
	 * @throws EventException
	 */
	public void createBRKGAPTempTable(String csrNo, String aproNm) throws DAOException, EventException
	{
		Connection con = null;				// Connection Interface  
		PreparedStatement updatePs1 = null; // SELECT를 수행하기 위한 SQL Statement
		int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		StringBuffer updateQuery1 = new StringBuffer();

		updateQuery1.append("\n    UPDATE AP_INV_HDR ");
		updateQuery1.append("\n       SET ATTR_CTNT1 = ? "); //:aproNm
		updateQuery1.append("\n     WHERE CSR_NO     = ? "); //:csrNo

		try
		{
			con = getConnection();

			////2.UPDATE ATTR_CTNT1
			i = 1;
			updatePs1 = new LoggableStatement(con, updateQuery1.toString());
			updatePs1.setString(i++, aproNm);
			updatePs1.setString(i++, csrNo);
			log.info("\n [createBRKGAPTempTable]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
			updatePs1.executeUpdate();

		}
		catch (SQLException se)
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(),de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeStatement(updatePs1);
			closeConnection(con);
		}
	}

	
	/**
	 * CALL AGT_BKG_REV_VVD_PRC 돌려본다.<br>
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param String csrNo
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws EventException
	 */
	public void createBRKGApprovalRequesttoEPOne(
		APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO,
		String csrNo, SignOnUserAccount account) throws DAOException, EventException
	{
		Connection con = null;				// Connection Interface
		PreparedStatement selectPs1 = null;	// SELECT를 수행하기 위한 SQL Statement
		PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
		PreparedStatement updatePs2 = null; // UPDATE를 수행하기 위한 SQL Statement
		ResultSet rs1 = null;				// DB ResultSet
		int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수

		String userId = "";
		String userNm = "";
		String ofcCd = "";
		String ofcNm = "";
		String costOfc = ""; 
		String ifCnt = "";
		String vndrNo = "";
		String payDt = "";
		String currCd = "";
		String totAmt = "";
		
		StringBuffer selectQuery1 = new StringBuffer() ;
		StringBuffer updateQuery1 = new StringBuffer() ;
		StringBuffer updateQuery2 = new StringBuffer() ;
		
		////CSR INFORMATION SEARCH
		selectQuery1.append("\nSELECT a.tj_ofc_cd, ");
		selectQuery1.append("\n       (SELECT COUNT(DISTINCT attr_ctnt1) FROM ap_inv_dtrb where csr_no = a.csr_no) cnt, ");
		selectQuery1.append("\n       a.vndr_no, ");
		selectQuery1.append("\n       a.inv_term_dt, ");
		selectQuery1.append("\n       a.csr_curr_cd, ");
		selectQuery1.append("\n       a.csr_amt, ");
		selectQuery1.append("\n       a.cre_usr_id ");
		selectQuery1.append("\n  FROM ap_inv_hdr a ");
		selectQuery1.append("\n WHERE a.csr_no = ? "); //:csrNo

		////AGT_BROG_COMM UPDATE
		updateQuery1.append("\nUPDATE agt_brog_comm a ");
		updateQuery1.append("\n   SET a.comm_proc_sts_cd = 'IF', ");
		updateQuery1.append("\n       a.gl_dt            = (SELECT distinct b.gl_dt FROM ap_inv_hdr b where b.csr_no = a.csr_no), ");
		updateQuery1.append("\n       a.comm_proc_rslt_rsn = 'Approval Request!', ");

		// 2008.2.4(sunganj) Request의 경우 날짜 검색 조건을 충족하기 위해 Local Time으로 Update
		updateQuery1.append("\n       a.brog_if_dt = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,loc_cd) ");
		updateQuery1.append("\n                       FROM mdm_organization WHERE ofc_cd = a.ap_ofc_cd) ");
		updateQuery1.append("\n WHERE a.csr_no = ? "); //:csrNo
		
		////AP_INV_HDR UPDATE
//		updateQuery2.append("\nUPDATE ap_inv_hdr ");
//		updateQuery2.append("\n   SET if_dt = SYSDATE, ");
//		updateQuery2.append("\n       if_err_rsn = 'Approval Request!' ");
//		updateQuery2.append("\n WHERE csr_no = ? "); //:csrNo
		try
		{
			con = getConnection();
			selectPs1 = new LoggableStatement(con, selectQuery1.toString());
			updatePs1 = new LoggableStatement(con, updateQuery1.toString());
			//updatePs2 = new LoggableStatement(con, updateQuery2.toString());

			userId = account.getUsr_id();
			userNm = account.getUsr_nm();
			ofcCd = account.getOfc_cd();
			ofcNm = account.getOfc_eng_nm();
			actualInterfaceMasterForBRKGVO.getAproStep();
			//csrNo =(String)paramHash.get("csrNo"); 
			//끝

			////1.CSR INFORMATION SEARCH
			i = 1;
			selectPs1.setString(i++, csrNo);

			log.info("\n [createBRKGApprovalRequesttoEP]SQL1 : \n" + ((LoggableStatement)selectPs1).getQueryString());
			rs1 = selectPs1.executeQuery();

			while(rs1.next())
			{
				costOfc = rs1.getString(1);
				ifCnt = Integer.toString(rs1.getInt(2));
				vndrNo = Integer.toString(rs1.getInt(3));
				payDt = rs1.getString(4);
				currCd = rs1.getString(5);
				totAmt = Float.toString(rs1.getFloat(6));
			}
			closeResultSet(rs1);

			////2.결재선 등록
			// COM_APRO_RQST_HDR
//			ApprovalUtil approval = new ApprovalUtil();
//			// COM_APRO_RQST_HDR
//			ComAproRqstHdrVO header = new ComAproRqstHdrVO();
//			header.setSubSysCd("AGT");
//			header.setAproKndCd("CSR");		
//			header.setRqstOfcCd(ofcCd);
//			header.setRqstOfcNm(ofcNm);
//			header.setRqstUsrJbTitNm("");
//			header.setRqstUsrId(userId);
//			header.setRqstUsrNm(userNm);
//			header.setCreUsrId(userId);

			// COM_APRO_RQST_ROUT
//			route = approval.convertApprovalRoute(steps);
//			ComAproRqstRoutVO[] route = approval.convertApprovalRoute(actualInterfaceMasterForBRKGVO.getAproStep());
//			// COM_APRO_CSR_DTL
//			ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
//			csr.setCsrNo(csrNo);
//			csr.setCostOfcCd(costOfc);
//			csr.setInvKnt(ifCnt);
//			csr.setVndrSeq(vndrNo);
//			csr.setPayDueDt(payDt);
//			csr.setCurrCd(currCd);
//			csr.setAproTtlAmt(totAmt);
//			csr.setCreUsrId(userId);
//
//			// 결재 등록
//			approval.saveCsrApro(header, route, csr);

			////3.AGT_BROG_COMM UPDATE
			i = 1;
			updatePs1.setString(i++, csrNo);
			log.info("\n [createBRKGApprovalRequesttoEP]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
			updatePs1.executeUpdate();

			////4.AP_INV_HDR UPDATE
//			i = 1;
//			updatePs2.setString(i++, csrNo);
//			log.info("\n [createBRKGApprovalRequesttoEP]Update SQL2 : \n" + ((LoggableStatement)updatePs2).getQueryString());
//            updatePs2.executeUpdate();


		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch (DAOException de)
		{
			log.error(de.getMessage(), de);
			throw de;
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		finally
		{
			closeResultSet(rs1);
			closeStatement(selectPs1);
			closeStatement(updatePs1);
			closeStatement(updatePs2);
			closeConnection(con);
		}
	}


	/**
	 * CALL AGT_BKG_REV_VVD_PRC 돌려본다.<br>
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void modifyBRKGApprovalRequesttoEP(String csrNo) throws DAOException{
		Connection con = null;				// Connection Interface  
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        String userId = "AGT System";
        
        StringBuffer updateQuery1 = new StringBuffer();
        
        ////UPDATE AGT_AGN_COMM
    	updateQuery1.append("\nUPDATE agt_brog_comm ");
        updateQuery1.append("\n   SET comm_proc_sts_cd = 'IC', ");
        updateQuery1.append("\n       comm_proc_rslt_rsn = 'Approval Request Reject!', ");
        updateQuery1.append("\n       accl_flg = 'N', ");
        updateQuery1.append("\n       brog_if_usr_id = NULL, ");
        updateQuery1.append("\n       brog_if_dt = NULL, ");
        updateQuery1.append("\n       csr_no = NULL, ");
        updateQuery1.append("\n       upd_usr_id = ?, "); //userId
        updateQuery1.append("\n       upd_dt = SYSDATE ");
        updateQuery1.append("\n WHERE csr_no = ? "); //:csr_no
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	updatePs1 = new LoggableStatement(con, updateQuery1.toString());
            } else {
            	updatePs1 = con.prepareStatement(updateQuery1.toString());
            }

            
            ////4.UPDATE AGT_AGN_COMM
            i = 1;
            updatePs1.setString(i++, userId);
            updatePs1.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [modifyAGTApprovalRequesttoEP]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
            } else {
                log.info("\n [modifyAGTApprovalRequesttoEP]Update SQL1 : \n" + updateQuery1.toString() );
            }            
            updatePs1.execute();                		

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
            closeStatement(updatePs1);
            closeConnection(con);
        }
		
	}
	/**
	 * CALL AGT_BKG_REV_VVD_PRC 돌려본다.<br>
	 * @param String csrNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBRKGActualINFtoAP(String csrNo) throws DAOException{
		Connection con = null;				// Connection Interface  

        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        ResultSet rs2 = null;	// DB ResultSet

        DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
       // String ifId = "FNS008-0003";
        //String csrNo = "";
        //String csrNoVal = "?";
        //int cnt = 0;
        //String hdr_tj_ofc_cd = "";
       // String hdr_gl_dt = "";
       // String ar_hd_qtr_ofc_cd = "";
       // int gl_dt_cnt = 0;
       // String gl_dt = "";
        
        //for(int j=1; j<csrNoArray.size(); j++){csrNoVal = csrNoVal + ", ?";}
        
//        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
//        StringBuffer selectQuery3 = new StringBuffer();
//        StringBuffer selectQuery4 = new StringBuffer();
//        StringBuffer selectQuery5 = new StringBuffer();
        
        ////1.CHECK
//        selectQuery1.append("\nSELECT count(*) ");
//        selectQuery1.append("\n  FROM ap_inv_if ");
//        selectQuery1.append("\n WHERE csr_no = ? "); //:csrNo
//        selectQuery1.append("\n   AND NVL(snd_flg,'N') = 'Y' ");
//        
//        // Get hdr_tj_ofc_cd, hdr_gl_dt
//        selectQuery5.append("\nSELECT hdr_tj_ofc_cd, hdr_gl_dt ");
//        selectQuery5.append("\n  FROM ap_inv_if ");
//        selectQuery5.append("\n WHERE ap_pgm_no LIKE 'ESMAGTBRK%' ");
//        selectQuery5.append("\n   AND csr_no = ? ");	//:csr_no
//        selectQuery5.append("\n   AND NVL(snd_flg,'N') = 'N' ");
        
        // GET AR_HD_QTR_OFC_CD
        // 2008.08.21 권상준 추가 (GL Date 구할때 AP Office 조회해서 없으면 AR_HD_QTR_OFC_CD 로 다시 조회) 
//        selectQuery3.append("\nSELECT AR_HD_QTR_OFC_CD ");
//        selectQuery3.append("\n  FROM mdm_organization ");
//        selectQuery3.append("\n WHERE ofc_cd = ? ");
//        selectQuery3.append("\n   AND NVL(delt_flg,'N') = 'N' ");
//        
//        // 마감월 체크하여 gl_dt(effDt 재셋팅)
//        selectQuery4.append("\nSELECT DECODE (a.sts, 'O', ?, 'C', b.dt) ");
//        selectQuery4.append("\n  FROM (SELECT clz_sts_cd sts ");
//        selectQuery4.append("\n          FROM ap_period ");
//        selectQuery4.append("\n         WHERE sys_div_cd = 23 ");
//        // 2008.06.25 권상준 추가 (AP_PERIOD 테이블 PK 추가에 따른 SQL 수정
//        selectQuery4.append("\n           AND ar_ap_div_cd = 'P' ");
//        selectQuery4.append("\n           AND ofc_cd = ? ");
//        
//        selectQuery4.append("\n           AND eff_yrmon = SUBSTR (?, 1, 6)) a ");
//        selectQuery4.append("\n     , (SELECT MIN (eff_yrmon) || '01' dt ");
//        selectQuery4.append("\n          FROM ap_period ");
//        selectQuery4.append("\n         WHERE sys_div_cd = 23 ");
//        // 2008.06.25 권상준 추가 (AP_PERIOD 테이블 PK 추가에 따른 SQL 수정
//        selectQuery4.append("\n           AND ar_ap_div_cd = 'P' ");
//        selectQuery4.append("\n           AND ofc_cd = ? ");
//        
//        selectQuery4.append("\n           AND clz_sts_cd = 'O' AND eff_yrmon >= SUBSTR(?, 1, 6) ) b ");
        
        
        ////2.SEARCH AP_INV_IF 
//        selectQuery2.append("\nSELECT ? lif_id, ap_pgm_no||inv_seq seq, ttl_row_knt, row_knt, hdr_csr_no, hdr_csr_tp_cd, hdr_inv_dt, ");	//:ifId
////      2008.08.21 권상준 추가 (GL Date 구할때 AP Office 조회해서 없으면 AR_HD_QTR_OFC_CD 로 다시 조회)
//        //selectQuery2.append("\n       hdr_inv_term_dt, DECODE ((SELECT clz_sts_cd sts FROM ap_period WHERE sys_div_cd = 23 AND eff_yrmon = SUBSTR (hdr_gl_dt, 1, 6) AND ar_ap_div_cd = 'P' and ofc_cd = hdr_tj_ofc_cd), 'O', hdr_gl_dt, 'C', (SELECT MIN (eff_yrmon) || '01' dt FROM ap_period WHERE sys_div_cd = 23 AND clz_sts_cd = 'O' AND eff_yrmon >= SUBSTR(hdr_gl_dt, 1, 6) AND ar_ap_div_cd = 'P' and ofc_cd = hdr_tj_ofc_cd)) hdr_gl_dt, ");
//        selectQuery2.append("\n       hdr_inv_term_dt, ? hdr_gl_dt, ");
//        selectQuery2.append("\n       hdr_vndr_no, hdr_csr_amt, hdr_pay_amt, hdr_pay_dt, ");
//        selectQuery2.append("\n       hdr_csr_curr_cd, hdr_vndr_term_nm, hdr_inv_desc, hdr_attr_cate_nm, ");
//        selectQuery2.append("\n       hdr_attr_ctnt1, hdr_attr_ctnt2, hdr_attr_ctnt3, hdr_attr_ctnt4, hdr_attr_ctnt5, ");
//        selectQuery2.append("\n       hdr_attr_ctnt6, hdr_attr_ctnt7, hdr_attr_ctnt8, hdr_attr_ctnt9, hdr_attr_ctnt10, ");
//        selectQuery2.append("\n       hdr_attr_ctnt11, hdr_attr_ctnt12, hdr_attr_ctnt13, hdr_attr_ctnt14, hdr_attr_ctnt15, ");
//        selectQuery2.append("\n       hdr_glo_attr_ctnt1, hdr_glo_attr_ctnt2, hdr_glo_attr_ctnt3, hdr_glo_attr_ctnt4, ");
//        selectQuery2.append("\n       hdr_glo_attr_ctnt5, hdr_glo_attr_ctnt6, hdr_glo_attr_ctnt7, hdr_glo_attr_ctnt8, ");
//        selectQuery2.append("\n       hdr_glo_attr_ctnt9, hdr_glo_attr_ctnt10, hdr_glo_attr_ctnt11, hdr_glo_attr_ctnt12, ");
//        selectQuery2.append("\n       hdr_glo_attr_ctnt13, hdr_glo_attr_ctnt14, hdr_glo_attr_ctnt15, hdr_glo_attr_ctnt16, ");
//        selectQuery2.append("\n       hdr_glo_attr_ctnt17, hdr_glo_attr_ctnt18, hdr_src_ctnt, hdr_pay_mzd_lu_cd, ");
//        selectQuery2.append("\n       hdr_pay_grp_lu_cd, hdr_coa_co_cd, hdr_coa_rgn_cd, hdr_coa_ctr_cd, hdr_coa_acct_cd, ");
//        selectQuery2.append("\n       hdr_coa_vvd_cd, hdr_coa_inter_co_cd, hdr_coa_ftu_n1st_cd, hdr_coa_ftu_n2nd_cd, ");
//        selectQuery2.append("\n       hdr_ppd_no, hdr_ppd_dtrb_no, hdr_ppd_aply_amt, hdr_ppd_gl_dt, hdr_apro_flg, ");
//        selectQuery2.append("\n       hdr_tax_decl_flg, hdr_err_csr_no, hdr_if_flg, hdr_if_dt, hdr_if_err_rsn, ");
//        selectQuery2.append("\n       hdr_ppay_aply_flg, hdr_tj_ofc_cd, hdr_act_xch_rt, hdr_imp_err_flg, hdr_rcv_err_flg, ");
//        selectQuery2.append("\n       hdr_tax_curr_xch_flg, hdr_usr_eml, hdr_imp_err_rsn, hdr_rcv_err_rsn, hdr_ftu_use_ctnt1, ");
//        selectQuery2.append("\n       hdr_ftu_use_ctnt2, hdr_ftu_use_ctnt3, hdr_ftu_use_ctnt4, hdr_ftu_use_ctnt5, ");
//        selectQuery2.append("\n       csr_no, line_seq, line_no, line_tp_lu_cd, inv_amt, inv_desc, inv_tax_cd, dtrb_coa_co_cd, ");
//        selectQuery2.append("\n       dtrb_coa_rgn_cd, dtrb_coa_ctr_cd, dtrb_coa_acct_cd, dtrb_coa_vvd_cd, dtrb_coa_inter_co_cd, ");
//        selectQuery2.append("\n       dtrb_coa_ftu_n1st_cd, dtrb_coa_ftu_n2nd_cd, attr_cate_nm, attr_ctnt1, attr_ctnt2, ");
//        selectQuery2.append("\n       attr_ctnt3, attr_ctnt4, attr_ctnt5, attr_ctnt6, attr_ctnt7, attr_ctnt8, attr_ctnt9, ");
//        selectQuery2.append("\n       attr_ctnt10, attr_ctnt11, attr_ctnt12, attr_ctnt13, attr_ctnt14, attr_ctnt15, ");
//        selectQuery2.append("\n       bkg_no bkg_no, cntr_tpsz_cd, act_vvd_cd, pln_sctr_div_cd, so_crr_cd, yd_cd, ");
//        selectQuery2.append("\n       ftu_use_ctnt1, ftu_use_ctnt2, ftu_use_ctnt3, ftu_use_ctnt4, ftu_use_ctnt5 ");
//        selectQuery2.append("\n  FROM ap_inv_if ");
//        selectQuery2.append("\n WHERE ap_pgm_no LIKE 'ESMAGTBRK%' ");
//        selectQuery2.append("\n   AND csr_no = ? "); //:csrNo
//        selectQuery2.append("\n   AND NVL(snd_flg,'N') = 'N' ");
        
        selectQuery2.append("\n SELECT 'FNS008-0003' AS lif_id,");
        selectQuery2.append("\n '' as seq,");
        selectQuery2.append("\n (	SELECT COUNT(*)");
        selectQuery2.append("\n 	FROM ap_inv_dtrb");
        selectQuery2.append("\n 	WHERE csr_no = a.csr_no ) as TTL_ROW_KNT,");
        selectQuery2.append("\n ROWNUM as ROW_KNT,");
        selectQuery2.append("\n a.csr_no as HDR_CSR_NO,");
        selectQuery2.append("\n a.csr_tp_cd as HDR_CSR_TP_CD,");
        selectQuery2.append("\n ROUND(a.inv_dt, 2) as HDR_INV_DT,");
        selectQuery2.append("\n a.inv_term_dt as HDR_INV_TERM_DT,");
        selectQuery2.append("\n a.gl_dt as HDR_GL_DT,");
        selectQuery2.append("\n a.vndr_no as HDR_VNDR_NO,");
        selectQuery2.append("\n a.csr_amt as HDR_CSR_AMT,");
        selectQuery2.append("\n a.pay_amt as HDR_PAY_AMT,");
        selectQuery2.append("\n a.pay_dt as HDR_PAY_DT,");
        selectQuery2.append("\n a.csr_curr_cd as HDR_CSR_CURR_CD,");
        selectQuery2.append("\n a.vndr_term_nm as HDR_VNDR_TERM_NM,");
        selectQuery2.append("\n a.inv_desc as HDR_INV_DESC,");
        selectQuery2.append("\n a.attr_cate_nm as HDR_ATTR_CATE_NM,");
        selectQuery2.append("\n a.attr_ctnt1 as HDR_ATTR_CTNT1,");
        selectQuery2.append("\n a.attr_ctnt2 as HDR_ATTR_CTNT2,");
        selectQuery2.append("\n a.attr_ctnt3 as HDR_ATTR_CTNT3,");
        selectQuery2.append("\n a.attr_ctnt4 as HDR_ATTR_CTNT4,");
        selectQuery2.append("\n a.attr_ctnt5 as HDR_ATTR_CTNT5,");
        selectQuery2.append("\n a.attr_ctnt6 as HDR_ATTR_CTNT6,");
        selectQuery2.append("\n a.attr_ctnt7 as HDR_ATTR_CTNT7,");
        selectQuery2.append("\n a.attr_ctnt8 as HDR_ATTR_CTNT8,");
        selectQuery2.append("\n a.attr_ctnt9 as HDR_ATTR_CTNT9,");
        selectQuery2.append("\n a.attr_ctnt10 as HDR_ATTR_CTNT10,");
        selectQuery2.append("\n a.attr_ctnt11 as HDR_ATTR_CTNT11,");
        selectQuery2.append("\n a.attr_ctnt12 as HDR_ATTR_CTNT12,");
        selectQuery2.append("\n a.attr_ctnt13 as HDR_ATTR_CTNT13,");
        selectQuery2.append("\n a.attr_ctnt14 as HDR_ATTR_CTNT14,");
        selectQuery2.append("\n a.attr_ctnt15 as HDR_ATTR_CTNT15,");
        selectQuery2.append("\n a.glo_attr_ctnt1 as HDR_GLO_ATTR_CTNT1,");
        selectQuery2.append("\n a.glo_attr_ctnt2 as HDR_GLO_ATTR_CTNT2,");
        selectQuery2.append("\n a.glo_attr_ctnt3 as HDR_GLO_ATTR_CTNT3,");
        selectQuery2.append("\n a.glo_attr_ctnt4 as HDR_GLO_ATTR_CTNT4,");
        selectQuery2.append("\n a.glo_attr_ctnt5 as HDR_GLO_ATTR_CTNT5,");
        selectQuery2.append("\n a.glo_attr_ctnt6 as HDR_GLO_ATTR_CTNT6,");
        selectQuery2.append("\n a.glo_attr_ctnt7 as HDR_GLO_ATTR_CTNT7,");
        selectQuery2.append("\n a.glo_attr_ctnt8 as HDR_GLO_ATTR_CTNT8,");
        selectQuery2.append("\n a.glo_attr_ctnt9 as HDR_GLO_ATTR_CTNT9,");
        selectQuery2.append("\n a.glo_attr_ctnt10 as HDR_GLO_ATTR_CTNT10,");
        selectQuery2.append("\n a.glo_attr_ctnt11 as HDR_GLO_ATTR_CTNT11,");
        selectQuery2.append("\n a.glo_attr_ctnt12 as HDR_GLO_ATTR_CTNT12,");
        selectQuery2.append("\n a.glo_attr_ctnt13 as HDR_GLO_ATTR_CTNT13,");
        selectQuery2.append("\n a.glo_attr_ctnt14 as HDR_GLO_ATTR_CTNT14,");
        selectQuery2.append("\n a.glo_attr_ctnt15 as HDR_GLO_ATTR_CTNT15,");
        selectQuery2.append("\n a.glo_attr_ctnt16 as HDR_GLO_ATTR_CTNT16,");
        selectQuery2.append("\n a.glo_attr_ctnt17 as HDR_GLO_ATTR_CTNT17,");
        selectQuery2.append("\n a.glo_attr_ctnt18 as HDR_GLO_ATTR_CTNT18,");
        selectQuery2.append("\n a.src_ctnt as HDR_SRC_CTNT,");
        selectQuery2.append("\n a.pay_mzd_lu_cd as HDR_PAY_MZD_LU_CD,");
        selectQuery2.append("\n a.pay_grp_lu_cd as HDR_PAY_GRP_LU_CD,");
        selectQuery2.append("\n a.coa_co_cd as HDR_COA_CO_CD,");
        selectQuery2.append("\n a.coa_rgn_cd as HDR_COA_RGN_CD,");
        selectQuery2.append("\n a.coa_ctr_cd as HDR_COA_CTR_CD,");
        selectQuery2.append("\n a.coa_acct_cd as HDR_COA_ACCT_CD,");
        selectQuery2.append("\n a.coa_vvd_cd as HDR_COA_VVD_CD,");
        selectQuery2.append("\n a.coa_inter_co_cd as HDR_COA_INTER_CO_CD,");
        selectQuery2.append("\n a.coa_ftu_n1st_cd as HDR_COA_FTU_N1ST_CD,");
        selectQuery2.append("\n a.coa_ftu_n2nd_cd as HDR_COA_FTU_N2ND_CD,");
        selectQuery2.append("\n a.ppd_no as HDR_PPD_NO,");
        selectQuery2.append("\n a.ppd_dtrb_no as HDR_PPD_DTRB_NO,");
        selectQuery2.append("\n a.ppd_aply_amt as HDR_PPD_APLY_AMT,");
        selectQuery2.append("\n a.ppd_gl_dt as HDR_PPD_GL_DT,");
        selectQuery2.append("\n a.apro_flg as HDR_APRO_FLG,");
        selectQuery2.append("\n a.tax_decl_flg as HDR_TAX_DECL_FLG,");
        selectQuery2.append("\n a.err_csr_no as HDR_ERR_CSR_NO,");
        selectQuery2.append("\n a.if_flg as HDR_IF_FLG,");
        selectQuery2.append("\n NULL as HDR_IF_DT,");
        selectQuery2.append("\n NULL as HDR_IF_ERR_RSN,");
        selectQuery2.append("\n a.ppay_aply_flg as HDR_PPAY_APLY_FLG,");
        selectQuery2.append("\n a.tj_ofc_cd as HDR_TJ_OFC_CD,");
        selectQuery2.append("\n a.act_xch_rt as HDR_ACT_XCH_RT,");
        selectQuery2.append("\n a.imp_err_flg as HDR_IMP_ERR_FLG,");
        selectQuery2.append("\n a.rcv_err_flg as HDR_RCV_ERR_FLG,");
        selectQuery2.append("\n a.tax_curr_xch_flg as HDR_TAX_CURR_XCH_FLG,");
        selectQuery2.append("\n a.usr_eml as HDR_USR_EML,");
        selectQuery2.append("\n a.imp_err_rsn as HDR_IMP_ERR_RSN,");
        selectQuery2.append("\n a.rcv_err_rsn as HDR_RCV_ERR_RSN,");
        selectQuery2.append("\n a.ftu_use_ctnt1 as HDR_FTU_USE_CTNT1,");
        selectQuery2.append("\n a.ftu_use_ctnt2 as HDR_FTU_USE_CTNT2,");
        selectQuery2.append("\n a.ftu_use_ctnt3 as HDR_FTU_USE_CTNT3,");
        selectQuery2.append("\n a.ftu_use_ctnt4 as HDR_FTU_USE_CTNT4,");
        selectQuery2.append("\n a.ftu_use_ctnt5 as HDR_FTU_USE_CTNT5,");
        selectQuery2.append("\n b.csr_no as CSR_NO,");
        selectQuery2.append("\n b.line_seq as LINE_SEQ,");
        selectQuery2.append("\n b.line_no as LINE_NO,");
        selectQuery2.append("\n b.line_tp_lu_cd as LINE_TP_LU_CD,");
        selectQuery2.append("\n ROUND(b.inv_amt, 2) as INV_AMT,");
        selectQuery2.append("\n b.inv_desc as INV_DESC,");
        selectQuery2.append("\n b.inv_tax_cd as INV_TAX_CD,");
        selectQuery2.append("\n b.dtrb_coa_co_cd as DTRB_COA_CO_CD,");
        selectQuery2.append("\n b.dtrb_coa_rgn_cd as DTRB_COA_RGN_CD,");
        selectQuery2.append("\n b.dtrb_coa_ctr_cd as DTRB_COA_CTR_CD,");
        selectQuery2.append("\n b.dtrb_coa_acct_cd as DTRB_COA_ACCT_CD,");
        selectQuery2.append("\n b.dtrb_coa_vvd_cd as DTRB_COA_VVD_CD,");
        selectQuery2.append("\n b.dtrb_coa_inter_co_cd as DTRB_COA_INTER_CO_CD,");
        selectQuery2.append("\n b.dtrb_coa_ftu_n1st_cd as DTRB_COA_FTU_N1ST_CD,");
        selectQuery2.append("\n b.dtrb_coa_ftu_n2nd_cd as DTRB_COA_FTU_N2ND_CD,");
        selectQuery2.append("\n b.attr_cate_nm as ATTR_CATE_NM,");
        selectQuery2.append("\n b.attr_ctnt1 as ATTR_CTNT1,");
        selectQuery2.append("\n b.attr_ctnt2 as ATTR_CTNT2,");
        selectQuery2.append("\n b.attr_ctnt3 as ATTR_CTNT3,");
        selectQuery2.append("\n b.attr_ctnt4 as ATTR_CTNT4,");
        selectQuery2.append("\n b.attr_ctnt5 as ATTR_CTNT5,");
        selectQuery2.append("\n b.attr_ctnt6 as ATTR_CTNT6,");
        selectQuery2.append("\n b.attr_ctnt7 as ATTR_CTNT7,");
        selectQuery2.append("\n b.attr_ctnt8 as ATTR_CTNT8,");
        selectQuery2.append("\n b.attr_ctnt9 as ATTR_CTNT9,");
        selectQuery2.append("\n b.attr_ctnt10 as ATTR_CTNT10,");
        selectQuery2.append("\n b.attr_ctnt11 as ATTR_CTNT11,");
        selectQuery2.append("\n b.attr_ctnt12 as ATTR_CTNT12,");
        selectQuery2.append("\n b.attr_ctnt13 as ATTR_CTNT13,");
        selectQuery2.append("\n b.attr_ctnt14 as ATTR_CTNT14,");
        selectQuery2.append("\n b.attr_ctnt15 as ATTR_CTNT15,");
        selectQuery2.append("\n b.bkg_no as BKG_NO,");
        selectQuery2.append("\n b.cntr_tpsz_cd as CNTR_TPSZ_CD,");
        selectQuery2.append("\n b.act_vvd_cd as ACT_VVD_CD,");
        selectQuery2.append("\n b.pln_sctr_div_cd as PLN_SCTR_DIV_CD,");
        selectQuery2.append("\n b.so_crr_cd as SO_CRR_CD,");
        selectQuery2.append("\n b.yd_cd as YD_CD,");
        selectQuery2.append("\n b.ftu_use_ctnt1 as FTU_USE_CTNT1,");
        selectQuery2.append("\n b.ftu_use_ctnt2 as FTU_USE_CTNT2,");
        selectQuery2.append("\n b.ftu_use_ctnt3 as FTU_USE_CTNT3,");
        selectQuery2.append("\n b.ftu_use_ctnt4 as FTU_USE_CTNT4,");
        selectQuery2.append("\n b.ftu_use_ctnt5 as FTU_USE_CTNT5");
        selectQuery2.append("\n FROM ap_inv_hdr  a,");
        selectQuery2.append("\n ap_inv_dtrb b");
//        selectQuery2.append("\n (");
//        selectQuery2.append("\n 	SELECT");
//        selectQuery2.append("\n 		TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,loc_cd),'YYYYMMDD') AS local_dt");
//        selectQuery2.append("\n 	FROM mdm_organization");
//        selectQuery2.append("\n 	WHERE ofc_cd = (");
//        selectQuery2.append("\n 		SELECT"); 
//        selectQuery2.append("\n 			DECODE (vndr_cnt_cd,'CN',ar_ofc_cd,agn_cd)");
//        selectQuery2.append("\n 		FROM agt_agn_comm");
//        selectQuery2.append("\n 		WHERE csr_no = ?");
//        selectQuery2.append("\n 		AND ROWNUM = 1");
//        selectQuery2.append("\n 	)");
//        selectQuery2.append("\n 	AND NVL (delt_flg, 'N') = 'N'");
//        selectQuery2.append("\n ) c");
        selectQuery2.append("\n WHERE a.csr_no = ?");
        selectQuery2.append("\n AND a.csr_no = b.csr_no ");
        selectQuery2.append("\n AND NVL(a.if_flg, 'N') = 'N'");
        selectQuery2.append("\n ORDER BY b.csr_no,");
        selectQuery2.append("\n 	b.line_seq,");
        selectQuery2.append("\n 	b.line_no");
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                selectPs1 = new LoggableStatement(con, selectQuery1.toString());
                selectPs2 = new LoggableStatement(con, selectQuery2.toString());
//                selectPs3 = new LoggableStatement(con, selectQuery3.toString());
//                selectPs4 = new LoggableStatement(con, selectQuery4.toString());
//                selectPs5 = new LoggableStatement(con, selectQuery4.toString());
//                selectPs6 = new LoggableStatement(con, selectQuery5.toString());
            } else {
//                selectPs1 = con.prepareStatement(selectQuery1.toString());
                selectPs2 = con.prepareStatement(selectQuery2.toString());
//                selectPs3 = con.prepareStatement(selectQuery3.toString());
//                selectPs4 = con.prepareStatement(selectQuery4.toString());
//                selectPs5 = con.prepareStatement(selectQuery4.toString());
//                selectPs6 = con.prepareStatement(selectQuery5.toString());
            }

            ////변수값 세팅
            
            
            ////1.CHECK
//            i = 1;
//            selectPs1.setString(i++, csrNo);
//            
//            //Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n [searchBRKGActualINFtoAP]Select SQL1 ::::::::: \n" + ((LoggableStatement)selectPs1).getQueryString());
//            } else {
////                log.info("\n [searchBRKGActualINFtoAP]Select SQL1 : \n" + selectQuery1.toString() );
//            }            
//            rs1 = selectPs1.executeQuery();
//            
//        	if(rs1.next()) {
//        		cnt = rs1.getInt(1);
//			}
//        	
//        	//check
//			if(cnt > 0){
//				//CSR No has already Interfaced! Please check up CSR No[$]
//				throw new DAOException((new ErrorHandler("AGT00029", new String[]{csrNo})).getMessage());
//			}
//			
//			// get hdr_tj_ofc_cd, hdr_gl_dt
//			i = 1;
//            selectPs6.setString(i++, csrNo);
//            
//            //Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n [searchAgentActualINFtoAP]Select SQL1 : \n" + ((LoggableStatement)selectPs6).getQueryString());
//            } else {
////                log.info("\n [searchAgentActualINFtoAP]Select SQL1 : \n" + selectQuery5.toString() );
//            }            
//            rs6 = selectPs6.executeQuery();
//            
//        	if(rs6.next()) {
//				hdr_tj_ofc_cd = rs6.getString(1);
//				hdr_gl_dt = rs6.getString(2);
//			}
//			
//	        // 2008.08.21 권상준 추가 (GL Date 구할때 AP Office 조회해서 없으면 AR_HD_QTR_OFC_CD 로 다시 조회) 
//			i = 1;
//            selectPs3.setString(i++, hdr_tj_ofc_cd);
//            
//            //Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n [createAGTCSRHeader]Select SQL9 : \n" + ((LoggableStatement)selectPs3).getQueryString());
//            } else {
//                log.info("\n [createAGTCSRHeader]Select SQL9 : \n" + selectQuery3.toString() );
//            }            
//            rs3 = selectPs3.executeQuery();
//            
//			if (rs3.next()) {
//				ar_hd_qtr_ofc_cd = rs3.getString(1);
//			}
//            			
//            //// 마감월 체크하여 gl_dt(effDt 셋팅)
//    		i = 1;
//            selectPs4.setString(i++, hdr_gl_dt);
//            selectPs4.setString(i++, hdr_tj_ofc_cd);
//            selectPs4.setString(i++, hdr_gl_dt);
//            selectPs4.setString(i++, hdr_tj_ofc_cd);
//            selectPs4.setString(i++, hdr_gl_dt);
//            
//            //Loggable Statement 사용에 의해 추가
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n [createAGTCSRDistribution]Select SQL10 : \n" + ((LoggableStatement)selectPs4).getQueryString());
//            } else {
//                log.info("\n [createAGTCSRDistribution]Select SQL10 : \n" + selectQuery4.toString() );
//            }            
//            rs4 = selectPs4.executeQuery();
//            
//            while (rs4.next()) {
//            	gl_dt_cnt = 1;
//            	gl_dt = rs4.getString(1);
//            }
//			
//            // 2008.08.21 권상준 추가 AP Office 로 GL Date 조회시 값이 없으면 ar_hd_qtr_ofc_cd 로 다시 조회
//            if(gl_dt_cnt == 0 || gl_dt.equals("01")){
//            	 //// 마감월 체크하여 gl_dt(effDt 셋팅)
//        		i = 1;
//                selectPs5.setString(i++, hdr_gl_dt);
//                selectPs5.setString(i++, ar_hd_qtr_ofc_cd);
//                selectPs5.setString(i++, hdr_gl_dt);
//                selectPs5.setString(i++, ar_hd_qtr_ofc_cd);
//                selectPs5.setString(i++, hdr_gl_dt);
//                
//                //Loggable Statement 사용에 의해 추가
//                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                    log.info("\n [createAGTCSRDistribution]Select SQL10 : \n" + ((LoggableStatement)selectPs5).getQueryString());
//                } else {
//                    log.info("\n [createAGTCSRDistribution]Select SQL10 : \n" + selectQuery4.toString() );
//                }            
//                rs5 = selectPs5.executeQuery();
//                
//                while (rs5.next()) {
//                	gl_dt_cnt = 1;
//                	gl_dt = rs5.getString(1);
//                }
//            }
            ////////////////////////////////////////////////////////////////////////////////////////////////
            
            ////2.SEARCH Inferface Data 
            i = 1;
//            selectPs2.setString(i++, ifId);
//            selectPs2.setString(i++, gl_dt);
//            selectPs2.setString(i++, csrNo);
            selectPs2.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [searchBRKGActualINFtoAP]Select SQL2 ::::::::: \n" + ((LoggableStatement)selectPs2).getQueryString());
            } else {
                log.info("\n [searchBRKGActualINFtoAP]Select SQL2 : \n" + selectQuery2.toString() );
            }            
            rs2 = selectPs2.executeQuery();
            
            //결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs2);  
                         
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
//        	closeResultSet(rs1);
        	closeResultSet(rs2);
//        	closeResultSet(rs3);
//        	closeResultSet(rs4);
//        	closeResultSet(rs5);
//        	closeResultSet(rs6);
//        	closeStatement(selectPs1);
        	closeStatement(selectPs2);
//        	closeStatement(selectPs3);
//        	closeStatement(selectPs4);
//        	closeStatement(selectPs5);
//        	closeStatement(selectPs6);
            closeConnection(con);
        }
        
        return dRs;
	}
	/**
	 * modifyApprovalStep
	 * @param String title_name
	 * @param String csrNo
	 * @throws DAOException
	 */
	public void modifyApprovalStep(String title_name, String csrNo) throws DAOException{
		// Connection Interface
		Connection con = null;
		// 정적파싱을 지원하는 SQL Statement		
		PreparedStatement updatePs1 = null;
//		PreparedStatement updatePs2 = null;

		int i = 1;

		String update_Query1 = " UPDATE ap_inv_hdr SET                									\n" +
							" 	attr_ctnt1 = ?              											\n" +
							" 	, gl_dt = (																\n" +
							"		SELECT NVL((														\n" + 
							"			SELECT MIN (EFF_YRMON)||'01' DT									\n" +
							"			FROM AP_PERIOD													\n" +
							"			WHERE SYS_DIV_CD = DECODE(SUBSTR(CSR_NO,1,2),'14','32','15') 	\n" +
							"			AND EFF_YRMON >= SUBSTR(A.GL_DT,1,6)							\n" +
							"			AND OFC_CD IN (A.TJ_OFC_CD,(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = A.TJ_OFC_CD)) \n"+
							"			AND AR_AP_DIV_CD = 'P' \n" +
							"			AND CLZ_STS_CD='O'),'N') NEW_GL_DT \n" +
							"		FROM AP_INV_HDR A \n" +
							"		WHERE A.CSR_NO = ? ) \n" +
							" 	, apro_flg = 'Y'             				\n" +
							" 	, if_err_rsn = 'Sending...'             	\n" +
							"	WHERE                                       \n" +
							" 	csr_no = ?	                    			\n" ;
		
//		String update_Query2 = " UPDATE ap_inv_if SET                		\n" +
//							" 	hdr_attr_ctnt1 = ?              			\n" +
//							" 	, hdr_gl_dt = ?              				\n" +
//							" 	, hdr_apro_flg = 'Y'             			\n" +
//							" 	, hdr_if_err_rsn = 'Sending...'             \n" +
//							"	WHERE                                       \n" +
//							" 	hdr_csr_no = ?	                    		\n" ;		
		
		try {
			con = getConnection();
			
			// Loggable Statement 사용에 의해 추가 
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {					
				updatePs1 = new LoggableStatement(con, update_Query1);
//				updatePs2 = new LoggableStatement(con, update_Query2);
			} else {								
				updatePs1 = con.prepareStatement(update_Query1);
//				updatePs2 = con.prepareStatement(update_Query2);
			}  

            // 쿼리에 변수 세팅.
			i=1;				
			updatePs1.setString(i++, title_name);
//			updatePs1.setString(i++, hdr_gl_dt);
			updatePs1.setString(i++, csrNo);
			updatePs1.setString(i++, csrNo);			
			
            // 쿼리에 변수 세팅.
//			i=1;				
//			updatePs2.setString(i++, title_name);
//			updatePs2.setString(i++, hdr_gl_dt);
//			updatePs2.setString(i++, csr_no);			
			
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){	
				log.info("\n SQL :" + ((LoggableStatement)updatePs1).getQueryString());	
			} else {	
				log.info("\n SQL :" + update_Query1 );				
			}
			
			updatePs1.executeUpdate();
//			updatePs2.executeUpdate();	

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {			
			closeStatement(updatePs1);
//			closeStatement(updatePs2);
			closeConnection(con);
		}
		
	}
	/**
	 * modifyApprovalStep<br>
	 * 
	 * @param String csr_no
	 * @return int
	 * @throws DAOException
	 */
	public int createBRKGAcutalINFFromAPbyMSG(String csr_no) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
				param.put("csr_no", csr_no);
				velParam.put("csr_no", csr_no);
					
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate)new BRKGAuditDBDAOCreateBRKGAcutalINFFromAPbyMSGUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
	 * modifyBRKGInfo
	 * @param boolean isSuccess
	 * @param String csrNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet modifyBRKGInfo(boolean isSuccess, String csrNo) throws DAOException{
		Connection con = null;				// Connection Interface  
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        DBRowSet dRs = null;				// DB DBRowSet
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String userId = "AGT System";	//event
        //String csrNo = "";
        //String vndr = "";
        //String apOfc = "";
        
        StringBuffer updateQuery1 = new StringBuffer();
        
        ////1.AGT_AGN_COMM에 AP I/F 결과 UPDATE
        if(isSuccess){
        	//true : Interface OK
        	updateQuery1.append("\nUPDATE agt_brog_comm a ");
        	updateQuery1.append("\n   SET comm_proc_sts_cd = 'IF', ");
        	updateQuery1.append("\n       comm_proc_rslt_rsn = 'Interface OK!', ");
        	updateQuery1.append("\n       accl_flg = 'Y', ");
        	updateQuery1.append("\n       brog_if_usr_id = ?, "); //:user_id
        	updateQuery1.append("\n       brog_if_dt = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,loc_cd) ");
        	updateQuery1.append("\n                     FROM mdm_organization WHERE ofc_cd = a.ap_ofc_cd), ");
        	updateQuery1.append("\n       upd_usr_id = ?, "); //:user_id
        	updateQuery1.append("\n       upd_dt = SYSDATE ");
        	updateQuery1.append("\n WHERE csr_no = ? "); //:csrNo
        	
        }else{
        	//false : Interface FAIL
	        updateQuery1.append("\nUPDATE agt_brog_comm a ");
	        updateQuery1.append("\n   SET comm_proc_sts_cd = 'CM', ");
	        updateQuery1.append("\n       comm_proc_rslt_rsn = 'Interface FAIL!', ");
	        updateQuery1.append("\n       accl_flg = 'N', ");
        	updateQuery1.append("\n       brog_if_usr_id = ?, ");	//:userId
	        updateQuery1.append("\n       brog_if_dt = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,loc_cd) ");
        	updateQuery1.append("\n                     FROM mdm_organization WHERE ofc_cd = a.ap_ofc_cd), ");
	        updateQuery1.append("\n       upd_usr_id = ?, ");	//:userId
	        updateQuery1.append("\n       upd_dt = SYSDATE ");
	        updateQuery1.append("\n WHERE csr_no = ? "); //:csrNo
        	
        }
        
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
            } else {
                updatePs1 = con.prepareStatement(updateQuery1.toString());
            }

            ////변수값 세팅
            //userId = event.getUserId();			//USER_ID
            ////끝
            
            
        	////1.AGT_AGN_COMM에 AP I/F 결과 UPDATE
            i = 1;
            updatePs1.setString(i++, userId);
            updatePs1.setString(i++, userId);
            updatePs1.setString(i++, csrNo);
                
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [modifyBRKGInfo]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
            } else {
                log.info("\n [modifyBRKGInfo]Update SQL1 : \n" + updateQuery1.toString() );
            }            
            updatePs1.execute();
                        
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeStatement(updatePs1);
            closeConnection(con);
        }
        
        return dRs;
		
	}
	/**
	 * createCancelBRKGActualINFtoAP
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws EventException
	 */
	public DBRowSet createCancelBRKGActualINFtoAP(
			APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO, SignOnUserAccount account) throws DAOException, EventException{
		
		Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String userId = "";	//event
        String csrNoArray = null;	
        String csrNo = "";
        String ifFlag = "";
        String rcvFlag = "";
        String bkgNo = "";
        
        int brogSeq = 0;
//        double act_pre_comm_amt = 0;
//        double act_comm_amt = 0;
        double act_if_comm_amt = 0;
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();

        
        ////1.CHECK INTERFACE RESULT
        selectQuery1.append("\nSELECT if_flg, rcv_err_flg ");
        selectQuery1.append("\n  FROM ap_inv_hdr ");
        selectQuery1.append("\n WHERE csr_no = ? ");	//:csr_no
        selectQuery1.append("\n   AND ROWNUM = 1 ");
        
        ////2.SEARCH
        selectQuery2.append("\nSELECT bkg_no,  brog_seq, act_pre_comm_amt, act_comm_amt, act_if_comm_amt ");
        selectQuery2.append("\n  FROM agt_brog_comm ");
        selectQuery2.append("\n WHERE csr_no = ? ");	//:csr_no
        

		
		try {
            con = getConnection();
            
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
            	selectPs2 = new LoggableStatement(con, selectQuery2.toString());

            ////변수값 세팅
            userId = account.getUsr_id();
            log.info("\n apActualInterfaceMasterForBRKGVO.getCsrNo();="+apActualInterfaceMasterForBRKGVO.getCsrNo());
            csrNoArray = apActualInterfaceMasterForBRKGVO.getCsrNo();
            csrNo = csrNoArray;
	            
        	////1.CHECK INTERFACE RESULT
        	i = 1;
        	selectPs1.setString(i++, csrNo);
            log.info("\n [modifyCancelBRKGCommInfo]Select SQL1 : \n" + ((LoggableStatement)selectPs1).getQueryString());
            rs1 = selectPs1.executeQuery();
	        	
        	if (rs1.next())
        	{
        		ifFlag = rs1.getString(1);
        		rcvFlag = rs1.getString(2);
        	}
	
	            //ifFlag = "E";
	        	//rcvFlag = "E";
	        	////인터페이스 결과가 '정상'이라면 에러메시지 출력
	        	if ((ifFlag == null || ifFlag.equals("Y")) && (rcvFlag == null || rcvFlag.equals("Y")))
	        	{
	            	//[$s]CSR No does not cancel! Because interface status is success!
			    	throw new DAOException((new ErrorHandler("AGT00067", new String[]{csrNo})).getMessage());
	            }
	
	            
	            ////2.SEARCH
	            i = 1;
	            selectPs2.setString(i++, csrNo);
                log.info("\n [modifyCancelBRKGInfo]Select SQL2 : \n" + ((LoggableStatement)selectPs2).getQueryString());
	            rs2 = selectPs2.executeQuery();
            
	            while(rs2.next())
	            {
	            	bkgNo = rs2.getString(1);
	            	brogSeq = rs2.getInt(2);
	        		act_if_comm_amt = rs2.getDouble(5);
	            	
	        		createCancelBRKGActualINFDelete(con, bkgNo, brogSeq, act_if_comm_amt, csrNo, userId);


	            }//while(rs2.next())
        }
		catch (SQLException se)
		{
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
		catch (DAOException de)
		{
            log.error(de.getMessage(),de);
            throw de;
        }
		catch (Exception e)
		{
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
		finally
		{
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeStatement(selectPs1);
        	closeStatement(selectPs2);

            closeConnection(con);
        }
        
        return dRs;
	}

/**
 *  Looping되는 삭제부분만 가져와서 다시 만듬
 * @param con
 * @param bkgNo
 * @param brogSeq
 * @param act_if_comm_amt
 * @param csrNo
 */
	void createCancelBRKGActualINFDelete(Connection con, String bkgNo, int brogSeq, double act_if_comm_amt, String csrNo, String userId) throws DAOException, EventException
	{
		// Connection Interface  
        PreparedStatement selectPs3 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs4 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs5 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement updatePs2 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement updatePs3 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement updatePs4 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement deletePs1 = null; // DELETE를 수행하기 위한 SQL Statement
        PreparedStatement deletePs2 = null; // DELETE를 수행하기 위한 SQL Statement
        PreparedStatement deletePs3 = null; // DELETE를 수행하기 위한 SQL Statement
        PreparedStatement deletePs4 = null; // DELETE를 수행하기 위한 SQL Statement
        PreparedStatement deletePs5 = null; // DELETE를 수행하기 위한 SQL Statement
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ResultSet rs5 = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        
        double max_act_pre_comm_amt = 0;
        double max_act_comm_amt = 0;
        double max_act_if_comm_amt = 0;
        double zeroAmt = 0;		// 강제로 0으로 Update
        int cur_brog_seq = 0;
        int max_brog_seq = 0;
        int del_brog_seq = 0;
        
        StringBuffer selectQuery3 = new StringBuffer();
        StringBuffer selectQuery4 = new StringBuffer();
        StringBuffer selectQuery5 = new StringBuffer();
        StringBuffer insertQuery1 = new StringBuffer();
        StringBuffer updateQuery1 = new StringBuffer();
        StringBuffer updateQuery2 = new StringBuffer();
        StringBuffer updateQuery3 = new StringBuffer();
        StringBuffer updateQuery4 = new StringBuffer();
        StringBuffer deleteQuery1 = new StringBuffer();
        StringBuffer deleteQuery2 = new StringBuffer();
        StringBuffer deleteQuery3 = new StringBuffer();
        StringBuffer deleteQuery4 = new StringBuffer();
        StringBuffer deleteQuery5 = new StringBuffer();
        
        //3. 해당 bkg_no 가 IF 이후에 또다시 IF 된것이 있을 경우 현재 bkg_no만 Cancel 처리 추가(2007.08.20 추가)
        selectQuery3.append("\nSELECT a.cur_brog_seq cur_brog_seq, b.max_brog_seq max_brog_seq ");
        selectQuery3.append("\n  FROM (SELECT NVL (MAX (brog_seq), 0) cur_brog_seq ");
        selectQuery3.append("\n          FROM agt_brog_comm ");
        selectQuery3.append("\n         WHERE bkg_no = ? ");
        selectQuery3.append("\n           AND csr_no = ? ");
        selectQuery3.append("\n           AND cre_usr_id != 'COST' ");
        selectQuery3.append("\n           AND comm_proc_sts_cd = 'IF') a, ");
        selectQuery3.append("\n       (SELECT NVL (MAX (brog_seq), 0) max_brog_seq ");
        selectQuery3.append("\n          FROM agt_brog_comm ");
        selectQuery3.append("\n         WHERE bkg_no = ? ");
        selectQuery3.append("\n           AND csr_no != ? ");
        selectQuery3.append("\n           AND csr_no is not null ");
        selectQuery3.append("\n           AND brog_if_dt is not null ");
        selectQuery3.append("\n           AND cre_usr_id != 'COST' ");
        selectQuery3.append("\n           AND comm_proc_sts_cd = 'IF') b ");
        
        selectQuery4.append("\nSELECT act_pre_comm_amt, act_comm_amt, act_if_comm_amt ");
        selectQuery4.append("\n  FROM agt_brog_comm ");
        selectQuery4.append("\n WHERE bkg_no = ? ");
        selectQuery4.append("\n   AND brog_seq = ? ");
        
        selectQuery5.append("SELECT brog_seq " + "\n");
        selectQuery5.append("  FROM agt_brog_comm  " + "\n");
        selectQuery5.append(" WHERE bkg_no = ?  " + "\n");
        selectQuery5.append("   AND comm_proc_sts_cd IN ('CE','CS','CM','IC')  " + "\n");
        
        deleteQuery4.append("DELETE FROM agt_brog_comm  " + "\n");
		deleteQuery4.append(" WHERE bkg_no = ?  " + "\n");
		deleteQuery4.append("   AND brog_seq = ?  " + "\n");
		
		deleteQuery5.append("DELETE FROM agt_brog_comm_dtl  " + "\n");
		deleteQuery5.append(" WHERE bkg_no = ?  " + "\n");
		deleteQuery5.append("   AND brog_seq = ?  " + "\n");
        
		insertQuery1.append("\n INSERT INTO agt_brog_comm ");
		insertQuery1.append("\n    SELECT bkg_no, ");
		insertQuery1.append("\n           ? + 1, ");
		insertQuery1.append("\n           comm_occr_info_cd, ");
		insertQuery1.append("\n           ar_ofc_cd, ");
		insertQuery1.append("\n           ap_ofc_cd, ");
		insertQuery1.append("\n           comm_stnd_cost_cd, ");
		insertQuery1.append("\n           'IC', ");		//comm_proc_sts_cd
		insertQuery1.append("\n           'Interface Cancel!', ");	//comm_proc_rslt_rsn
		insertQuery1.append("\n           comm_slan_cd, ");
		insertQuery1.append("\n           comm_rlane_cd, ");
		insertQuery1.append("\n           comm_vsl_cd, ");
		insertQuery1.append("\n           comm_skd_voy_no, ");
		insertQuery1.append("\n           comm_skd_dir_cd, ");
		insertQuery1.append("\n           comm_rev_dir_cd, ");
		insertQuery1.append("\n           brog_ref_no, ");
		insertQuery1.append("\n           cust_hus_bro_no, ");
		insertQuery1.append("\n           frt_fwrd_cnt_cd, ");
		insertQuery1.append("\n           frt_fwrd_seq, ");
		insertQuery1.append("\n           vndr_cnt_cd, ");
		insertQuery1.append("\n           vndr_seq, ");
		insertQuery1.append("\n           vsl_dep_dt, ");
		insertQuery1.append("\n           brog_div_cd, ");
		insertQuery1.append("\n           brog_bkg_rt, ");
		insertQuery1.append("\n           brog_chg_ctnt, ");
		insertQuery1.append("\n           brog_bx_rt, ");
		insertQuery1.append("\n           bkg_bx_qty, ");
		insertQuery1.append("\n           brog_teu_rt, ");
		insertQuery1.append("\n           bkg_teu_qty, ");
		insertQuery1.append("\n           brog_feu_rt, ");
		insertQuery1.append("\n           bkg_feu_qty, ");
		insertQuery1.append("\n           brog_rf_rt, ");
		insertQuery1.append("\n           bkg_rf_qty, ");
		insertQuery1.append("\n           brog_knd_cd, ");
		insertQuery1.append("\n           inter_mdal_flg, ");
		insertQuery1.append("\n           ?, ");	//act_pre_comm_amt
		insertQuery1.append("\n           ?, ");	//act_comm_amt
		insertQuery1.append("\n           ?, ");	//act_if_comm_amt
		insertQuery1.append("\n           NULL, ");	//brog_if_usr_id
		insertQuery1.append("\n           NULL, ");	//brog_if_dt
		insertQuery1.append("\n           'N', ");	//accl_flg
		insertQuery1.append("\n           NULL, ");	//csr_no
		insertQuery1.append("\n           agmt_cnt_cd, ");
		insertQuery1.append("\n           agmt_cust_seq, ");
		insertQuery1.append("\n           agmt_rt_seq, ");
		insertQuery1.append("\n           cre_usr_id, ");
		insertQuery1.append("\n           cre_dt, ");
		insertQuery1.append("\n           ?, ");	//upd_usr_id
		insertQuery1.append("\n           sysdate, ");	//upd_dt
		insertQuery1.append("\n           gl_dt ");
		insertQuery1.append("\n      FROM agt_brog_comm ");
		insertQuery1.append("\n     WHERE bkg_no = ?  ");
		insertQuery1.append("\n       AND brog_seq = ? ");
		
        //3-2 강제로 금액을 변경한다.
        updateQuery2.append("\nUPDATE agt_brog_comm ");
        updateQuery2.append("\n   SET act_pre_comm_amt = ?, ");
        updateQuery2.append("\n       act_comm_amt = ?, ");
        updateQuery2.append("\n       act_if_comm_amt = ?, ");
        updateQuery2.append("\n       brog_if_dt = NULL ");
        updateQuery2.append("\n WHERE bkg_no = ? ");		//:bkg_no
        updateQuery2.append("\n   AND brog_seq = ? ");		//:brog_seq
        
        updateQuery3.append("\nUPDATE agt_brog_comm ");
        updateQuery3.append("\n   SET act_pre_comm_amt = ?, ");
        updateQuery3.append("\n       act_comm_amt = ?, ");
        updateQuery3.append("\n       act_if_comm_amt = ? ");
        updateQuery3.append("\n WHERE bkg_no = ? ");		//:bkg_no
        updateQuery3.append("\n   AND brog_seq = ? ");		//:brog_seq
		
        // 3-3 강제로 금액을 변경한다.
        updateQuery4.append("\nUPDATE agt_brog_comm_dtl ");
        updateQuery4.append("\n   SET act_usd_comm_amt = ? ");
        updateQuery4.append("\n WHERE bkg_no = ? ");		//:bkg_no
        updateQuery4.append("\n   AND brog_seq = ? ");		//:brog_seq
        
        ////4.UPDATE AGT_AGN_COMM
    	updateQuery1.append("\nUPDATE agt_brog_comm ");
        updateQuery1.append("\n   SET comm_proc_sts_cd = 'IC', ");
        updateQuery1.append("\n       comm_proc_rslt_rsn = 'Interface Cancel!', ");
        updateQuery1.append("\n       brog_if_usr_id = NULL, ");
        updateQuery1.append("\n       brog_if_dt = NULL, ");
        updateQuery1.append("\n       accl_flg = 'N', ");
        updateQuery1.append("\n       csr_no = NULL, ");
        updateQuery1.append("\n       brog_apro_no = NULL, ");
        updateQuery1.append("\n       upd_usr_id = ?, ");	//userId
        updateQuery1.append("\n       upd_dt = SYSDATE ");
        updateQuery1.append("\n WHERE bkg_no = ? ");		//:bkg_no
        updateQuery1.append("\n   AND brog_seq = ? ");		//:brog_seq
        
        ////5.DELETE AGT_AGN_COMM
        deleteQuery1.append("\nDELETE FROM agt_brog_comm ");
        deleteQuery1.append("\n WHERE bkg_no = ? ");		//:bkg_no
        deleteQuery1.append("\n   AND brog_seq > ? ");		//:brog_seq
        
		////6.Detail 삭제
		deleteQuery2.append("DELETE FROM agt_brog_comm_dtl \n");
		deleteQuery2.append("      WHERE bkg_no = ? \n");
		deleteQuery2.append("        AND brog_seq > ? \n");
        
		////6.Detail 삭제
		deleteQuery3.append("DELETE FROM agt_brog_chg_dtl \n");
		deleteQuery3.append("      WHERE bkg_no = ? \n");
		deleteQuery3.append("        AND brog_seq > ? \n");
		
		try
		{
            	selectPs3 = new LoggableStatement(con, selectQuery3.toString());
            	selectPs4 = new LoggableStatement(con, selectQuery4.toString());
            	selectPs5 = new LoggableStatement(con, selectQuery5.toString());
            	insertPs1 = new LoggableStatement(con, insertQuery1.toString());
            	updatePs1 = new LoggableStatement(con, updateQuery1.toString());
            	updatePs2 = new LoggableStatement(con, updateQuery2.toString());
            	updatePs3 = new LoggableStatement(con, updateQuery3.toString());
            	updatePs4 = new LoggableStatement(con, updateQuery4.toString());
            	deletePs2 = new LoggableStatement(con, deleteQuery2.toString());
            	deletePs3 = new LoggableStatement(con, deleteQuery3.toString());
            	deletePs4 = new LoggableStatement(con, deleteQuery4.toString());
            	deletePs5 = new LoggableStatement(con, deleteQuery5.toString());
            	deletePs1 = new LoggableStatement(con, deleteQuery1.toString());            	

	            	////3.CHECK
	            	i = 1;
	            	selectPs3.setString(i++, bkgNo);
	            	selectPs3.setString(i++, csrNo);
	            	selectPs3.setString(i++, bkgNo);
	            	selectPs3.setString(i++, csrNo);
	            	
	                //Loggable Statement 사용에 의해 추가
                    log.info("\n [modifyCancelBRKGInfo]Select SQL3 : \n" + ((LoggableStatement)selectPs3).getQueryString());
	                rs3 = selectPs3.executeQuery();
	            	
	                if (rs3.next())
	                {
	                	cur_brog_seq = rs3.getInt(1);
	            		max_brog_seq = rs3.getInt(2);
	                }
	                closeResultSet(rs3);
	            	
	                
	                ////해당 bkg_no 가 IF 이후에 또다시 IF 된것이 있을 경우 현재 bkg_no만 Cancel 처리 추가(2007.08.20 추가)
	                if ((cur_brog_seq - max_brog_seq) < 0 && (brogSeq - cur_brog_seq) == 0){
	                	//[$s]CSR No does not cancel! Because another CSR is interfaced!
				    	//throw new DAOException((new ErrorHandler("AGT00068", new String[]{csrNo})).getMessage());
	                	i = 1;
	            		selectPs4.setString(i++, bkgNo);
	            		selectPs4.setInt(i++, max_brog_seq);
	            		
	                    //Loggable Statement 사용에 의해 추가
                        log.info("\n [modifyCancelAGTCommInfo]Select SQL4 : \n" + ((LoggableStatement)selectPs4).getQueryString());
	                	rs4 = selectPs4.executeQuery();
	                	
	                	if(rs4.next()){
	                		max_act_pre_comm_amt = rs4.getDouble(1);
	                		max_act_comm_amt = rs4.getDouble(2);
	                		max_act_if_comm_amt = rs4.getDouble(3);
	                	}
	                	closeResultSet(rs4);
	                	
	                	i = 1;
	            		selectPs5.setString(i++, bkgNo);
	            		            		
                        log.info("\n [modifyCancelAGTCommInfo]Select SQL5 : \n" + ((LoggableStatement)selectPs5).getQueryString());
	                	rs5 = selectPs5.executeQuery();
	                	
	                	if(rs5.next()){
	                		del_brog_seq = rs5.getInt(1);
	                	}
	                	closeResultSet(rs5);
	                	
	                	if(del_brog_seq > 0)
	                	{
	                		
	                    	// IC 로 Insert 전에 agt_brog_chg_dtl 에 계산되어진것 삭제 처리 comm_proc_sts_cd IN ('CE','CS','CM','IC')
	                        i = 1;
	                        deletePs3.setString(i++, bkgNo);
	                        deletePs3.setInt(i++, del_brog_seq);
	                        
                            log.info("\n [modifyCancelBRKGInfo]Delete SQL1 : \n" + ((LoggableStatement)deletePs3).getQueryString());
	                        deletePs3.execute();
	                		
	                    	// IC 로 Insert 전에 agt_brog_comm_dtl 에 계산되어진것 삭제 처리 comm_proc_sts_cd IN ('CE','CS','CM','IC')
	                    	i = 1;
	            			deletePs5.setString(i++, bkgNo);
	            			deletePs5.setInt(i++, del_brog_seq);
	                        
                            log.info("\n [modifyCancelAGTCommInfo]Select SQL4 : \n" + ((LoggableStatement)deletePs5).getQueryString());
	            			deletePs5.executeUpdate();
	            			
	                    	// IC 로 Insert 전에 agt_brog_comm 에 계산되어진것 삭제 처리 comm_proc_sts_cd IN ('CE','CS','CM','IC')
	                    	i = 1;
	            			deletePs4.setString(i++, bkgNo);
	            			deletePs4.setInt(i++, del_brog_seq);
	                        
                            log.info("\n [modifyCancelAGTCommInfo]Select SQL4 : \n" + ((LoggableStatement)deletePs4).getQueryString());
	            			deletePs4.executeUpdate();
	                	}
	                	
	                	// Insert Row (comm_proc_sts_cd = 'IC')
	                	i = 1;
	                	insertPs1.setInt(i++, max_brog_seq);
	                	insertPs1.setDouble(i++, max_act_comm_amt);
	                	insertPs1.setDouble(i++, max_act_comm_amt);
	                	insertPs1.setDouble(i++, act_if_comm_amt);
	                    insertPs1.setString(i++, userId);
	                    insertPs1.setString(i++, bkgNo);
	                    insertPs1.setInt(i++, max_brog_seq);
                        log.info("\n [modifyCancelAGTCommInfo]Update SQL1 : \n" + ((LoggableStatement)insertPs1).getQueryString());
	                    insertPs1.execute();
	                    
	                    // Update agt_agn_comm (Cacncel 대상 Booking의 amount값을 '0'으로 강제 셋팅)
	                    i = 1;
	                    updatePs2.setDouble(i++, zeroAmt);
	                    updatePs2.setDouble(i++, zeroAmt);
	                    updatePs2.setDouble(i++, zeroAmt);
	                    updatePs2.setString(i++, bkgNo);
	                    updatePs2.setInt(i++, brogSeq);
                        log.info("\n [modifyCancelAGTCommInfo]Update SQL2 : \n" + ((LoggableStatement)updatePs2).getQueryString());
	                    updatePs2.execute();
	                    
	                    // Update agt_agn_comm_dtl (Cacncel 대상 Booking의 amount값을 '0'으로 강제 셋팅)
	                    i = 1;
	                    updatePs4.setDouble(i++, zeroAmt);
	                    updatePs4.setString(i++, bkgNo);
	                    updatePs4.setInt(i++, brogSeq);
	                    
                        log.info("\n [modifyCancelAGTCommInfo]Update SQL4 : \n" + ((LoggableStatement)updatePs4).getQueryString());
	                    updatePs4.execute();
	                    
	                    // Update agt_agn_comm (Cacncel 대상 이후의 IF된 ac_seq의  Booking의 amount를 보정작업)
	                    i = 1;
	                    updatePs3.setDouble(i++, max_act_pre_comm_amt);
	                    updatePs3.setDouble(i++, (max_act_comm_amt - act_if_comm_amt));
	                    updatePs3.setDouble(i++, max_act_if_comm_amt);
	                    updatePs3.setString(i++, bkgNo);
	                    updatePs3.setInt(i++, max_brog_seq);
                        log.info("\n [modifyCancelAGTCommInfo]Update SQL3 : \n" + ((LoggableStatement)updatePs3).getQueryString());
	                    updatePs3.execute();
	                	
	                }else{
	                	//4.UPDATE AGT_AGN_COMM
	                    i = 1;
	                    updatePs1.setString(i++, userId);
	                    updatePs1.setString(i++, bkgNo);
	                    updatePs1.setInt(i++, brogSeq);
	                    
                        log.info("\n [modifyCancelBRKGInfo]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
                        updatePs1.execute();
	
	                	////5.DELETE agt_brog_chg_dtl
	                    i = 1;
	                    deletePs3.setString(i++, bkgNo);
	                    deletePs3.setInt(i++, brogSeq);
	                    
                        log.info("\n [modifyCancelBRKGInfo]Delete SQL1 : \n" + ((LoggableStatement)deletePs3).getQueryString());
	                    deletePs3.execute(); 
	                    
	                	////5.DELETE AGT_AGN_COMM_DTL
	                    i = 1;
	                    deletePs2.setString(i++, bkgNo);
	                    deletePs2.setInt(i++, brogSeq);
	                    
                        log.info("\n [modifyCancelBRKGInfo]Delete SQL1 : \n" + ((LoggableStatement)deletePs2).getQueryString());
	                    deletePs2.execute(); 
	                    
	                	////6.DELETE AGT_AGN_COMM
	                    i = 1;
	                    deletePs1.setString(i++, bkgNo);
	                    deletePs1.setInt(i++, brogSeq);
                        log.info("\n [modifyCancelBRKGInfo]Delete SQL1 : \n" + ((LoggableStatement)deletePs1).getQueryString());
	                    deletePs1.execute();
	                }
        }
		catch (SQLException se)
		{
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
		catch (Exception e)
		{
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
		finally
		{
        	closeResultSet(rs3);
        	closeResultSet(rs4);
        	closeResultSet(rs5);
        	closeStatement(selectPs3);
        	closeStatement(selectPs4);
        	closeStatement(selectPs5);
        	closeStatement(insertPs1);
            closeStatement(updatePs1);
            closeStatement(updatePs2);
            closeStatement(updatePs3);
            closeStatement(updatePs4);
            closeStatement(deletePs5);
            closeStatement(deletePs4);
            closeStatement(deletePs3);
            closeStatement(deletePs2);
        	closeStatement(deletePs1);
        }
	}
	
	
	/**
	 * 
	 * @param tesTmlSoHdrVO
	 * @return
	 * @throws DAOException
	 */
	public ApPayInvVO searchBrogApPayInv(APActualInterfaceMasterForBRKGVO aPActualInterfaceMasterForBRKGVO, String usrId) throws DAOException{
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			log.debug("aPActualInterfaceMasterForBRKGVO====>"+aPActualInterfaceMasterForBRKGVO);
			if(aPActualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = aPActualInterfaceMasterForBRKGVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cre_usr_id", usrId);
				
				log.debug("velParam*************************>"+velParam.values());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchApPayInvRSQL(), param, velParam);
			log.debug("dbRowset~~~~~~~~~~~~~~>>>>>>>>>>>>>>>>>>>"+dbRowset);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}
	
	/**
	 * 
	 * @param apPayInvVO
	 * @return
	 * @throws DAOException
	 */
	public ApPayInvDtlVO[] searchBrogApPayInvDtl(APActualInterfaceMasterForBRKGVO aPActualInterfaceMasterForBRKGVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<ApPayInvDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(aPActualInterfaceMasterForBRKGVO != null){
				Map<String, String> mapVO = aPActualInterfaceMasterForBRKGVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BRKGAuditDBDAOSearchApPayInvDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO .class);
			
			ApPayInvDtlVO[] rtvos = new ApPayInvDtlVO[list.size()]; 
			
			for(int i=0 ; i<list.size();i++){
				rtvos[i] = list.get(i);
			}
			return rtvos;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * (ESM_AGT_017) Agent Commission 의 커미션 스테이터스 코드를 업데이트한다..<br>
	 * 
	 * @param String csr_no
	 * @throws DAOException
	 */

	public void modifyBrogCommProcStsCd(ApPayInvVO apPayInvVO) throws DAOException {
		log.debug("\n modifyAGTCommProcStsCd Start");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = apPayInvVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new BRKGAuditDBDAOModifyBrogCommProcStsCdUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		log.debug("\n modifyBrogCommIFBackAP End");

	}

}

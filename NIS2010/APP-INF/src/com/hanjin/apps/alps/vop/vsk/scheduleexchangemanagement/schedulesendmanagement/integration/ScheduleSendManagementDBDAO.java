package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.vo.VslSkdXchEdiHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

public class ScheduleSendManagementDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;	
	
	
	/**
	 * EDI Exchange 이력데이터 생성을 위한 SEQ 추출하기<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String createScheduleExchangeEdiSeq() throws DAOException {
		
		SQLExecuter sqlExe 		= new SQLExecuter("");
		DBRowSet	dbRowset	= new DBRowSet();
		String		sEdiSeq		= null;
		
		try {
			dbRowset	= sqlExe.executeQuery((ISQLTemplate)new ScheduleSendManagementDBDAOCreateExchangeEdiSeqRSQL(), null, null);

			if(dbRowset.next())		sEdiSeq	= dbRowset.getString(1);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return sEdiSeq;
	}	
	
	/**
	 * EDI Exchange 헤더 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs
	 * @exception DAOException
	 */
/*	public void createScheduleExchangeHeader(List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs) throws DAOException {
		
		try {
			SQLExecuter sqlExe	= new SQLExecuter("");
			
			int insCnt[] = null;
			
			if(vslSkdXchEdiHdrVOs != null && vslSkdXchEdiHdrVOs.size()>0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleSendManagementDBDAOCreateExchangeHeaderCSQL(), vslSkdXchEdiHdrVOs, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
			
			///////////////////////////////////////////////////////////////////////////
			
			

			
			///////////////////////////////////////////////////////////////////////////
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	*/	
	
	/**
	 * EDI Exchange 헤더 이력데이터 생성<br>
	 * 
	 * @param VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO
	 * @exception DAOException
	 */
	public void createScheduleExchangeHeader(VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO) throws DAOException {
		
		SQLExecuter sqlExe	= new SQLExecuter("");

		try {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.putAll(vslSkdXchEdiHdrVO.getColumnValues());
			
			if(vslSkdXchEdiHdrVO != null){
				int result  = sqlExe.executeUpdate((ISQLTemplate)new ScheduleSendManagementDBDAOCreateExchangeHeaderCSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * EDI Exchange 상세 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiDtlVO>	vslSkdXchEdiDtlVOs
	 * @exception DAOException
	 */
	public void createScheduleExchangeDetailList(VslSkdXchEdiDtlVO	vslSkdXchEdiDtlVO) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.putAll(vslSkdXchEdiDtlVO.getColumnValues());
			
			if(vslSkdXchEdiDtlVO != null){
				int result  = sqlExe.executeUpdate((ISQLTemplate)new ScheduleSendManagementDBDAOCreateExchangeDetailListCSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No SQL");
			}
			
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * EDI Exchange 상세 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiDtlVO>	vslSkdXchEdiDtlVOs
	 * @exception DAOException
	 */
/*	public void createScheduleExchangeDetailList(List<VslSkdXchEdiDtlVO>	vslSkdXchEdiDtlVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			
			int insCnt[] = null;
			
			if(vslSkdXchEdiDtlVOs != null && vslSkdXchEdiDtlVOs.size()>0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleSendManagementDBDAOCreateExchangeDetailListCSQL(), vslSkdXchEdiDtlVOs, null);
				for(int i=0; i<insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	*/
	

	/**
	 * EDI Exchange 헤더데이터 조회<br>
	 * 
	 * @param VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO
	 * @return VslSkdXchEdiHdrVO
	 * @exception SQLException
	 */
	public VslSkdXchEdiHdrVO searchScheduleExchangeHeader(VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<VslSkdXchEdiHdrVO> list 		= null;
		VslSkdXchEdiHdrVO		rtnVO		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
			if(vslSkdXchEdiHdrVO != null){
				Map<String, String> mapVO = vslSkdXchEdiHdrVO.getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleSendManagementDBDAOSearchExchangeHeaderRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdXchEdiHdrVO.class);
			
			rtnVO		= list.get(0);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnVO;
	}		
	
	
	/**
	 * EDI Exchange 상세데이터 조회<br>
	 * 
	 * @param VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO
	 * @return List<VslSkdXchEdiDtlVO>
	 * @exception DAOException
	 */
	public List<VslSkdXchEdiDtlVO> searchScheduleExchangeDetailList(VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<VslSkdXchEdiDtlVO> list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
			if(vslSkdXchEdiHdrVO != null){
				Map<String, String> mapVO = vslSkdXchEdiHdrVO.getColumnValues();
			
				param.putAll	(mapVO);
				velParam.putAll	(mapVO);
			}
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleSendManagementDBDAOSearchExchangeDetailRSQL(), param, velParam);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VslSkdXchEdiDtlVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}	
	
}

package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

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

public class ScheduleReceiveManagementDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	

	/**
	 * EDI Exchange 헤더 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs
	 * @exception DAOException
	 */
	public void createScheduleExchangeHeader(List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs) throws DAOException {
		
		SQLExecuter sqlExe	= new SQLExecuter("");

		try {
			
			int insCnt[] = null;
			
			if(vslSkdXchEdiHdrVOs != null && vslSkdXchEdiHdrVOs.size()>0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleReceiveManagementDBDAOCreateExchangeHeaderCSQL(), vslSkdXchEdiHdrVOs, null);
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
	}		
	
	
	/**
	 * EDI Exchange 상세 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiDtlVO>	vslSkdXchEdiDtlVOs
	 * @exception DAOException
	 */
	public void createScheduleExchangeDetailList(List<VslSkdXchEdiDtlVO>	vslSkdXchEdiDtlVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		try {
			
			int insCnt[] = null;
			
			if(vslSkdXchEdiDtlVOs != null && vslSkdXchEdiDtlVOs.size()>0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleReceiveManagementDBDAOCreateExchangeDetailListCSQL(), vslSkdXchEdiDtlVOs, null);
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
	}	


	/**
	 * EDI Exchange 헤더데이터 조회<br>
	 * 
	 * @param VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO
	 * @return VslSkdXchEdiHdrVO
	 * @exception SQLException
	 */
	public VslSkdXchEdiHdrVO selectVesselScheduleExchangeEdiHdr(VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO) throws DAOException {
		
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
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleReceiveManagementDBDAOSelectExchangeHeaderRSQL(), param, velParam);
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
	 * EDI Exchange 헤더데이터 조회<br>
	 * 
	 * @param VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO
	 * @return List<VslSkdXchEdiDtlVO>
	 * @exception SQLException
	 */
	public List<VslSkdXchEdiDtlVO> selectVesselScheduleExchangeEdiDtlList(VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO) throws DAOException {
		
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
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleReceiveManagementDBDAOSelectExchangeDetailListRSQL(), param, velParam);
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

	/**
	 * EDI Exchange 헤더데이터 조회<br>
	 * 
	 * @param VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO
	 * @return String
	 * @exception SQLException
	 */
	public String checkScheduleMappingProcRemark(VslSkdXchEdiHdrVO	vslSkdXchEdiHdrVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		String					rtnValue	= null;
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
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new ScheduleReceiveManagementDBDAOCheckScheduleMappingProcRemarkRSQL(), param, velParam);
			if(dbRowset.next())	rtnValue	= dbRowset.getString("EDI_PROC_RMK");
			
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
	 * EDI Exchange 헤더 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs
	 * @exception DAOException
	 */
	public void modifyScheduleExchangeHeader(List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs) throws DAOException {
		
		SQLExecuter sqlExe	= new SQLExecuter("");

		try {
			
			int insCnt[] = null;
			
			if(vslSkdXchEdiHdrVOs != null && vslSkdXchEdiHdrVOs.size()>0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleReceiveManagementDBDAOModifyExchangeHeaderUSQL(), vslSkdXchEdiHdrVOs, null);
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
	}	
	
	/**
	 * EDI Exchange 헤더 이력데이터 생성<br>
	 * 
	 * @param List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs
	 * @exception DAOException
	 */
	public int[] updateCoastalSchedulebyEDICKYH(List<VslSkdXchEdiHdrVO>	vslSkdXchEdiHdrVOs) throws DAOException {
		
		SQLExecuter sqlExe	= new SQLExecuter("");
		int 		upCnt[] = null;

		try {
			
			if(vslSkdXchEdiHdrVOs != null && vslSkdXchEdiHdrVOs.size()>0){
				upCnt = sqlExe.executeBatch((ISQLTemplate)new ScheduleReceiveManagementDBDAOUpdateCoastalSchedulebyEDICKYHUSQL(), vslSkdXchEdiHdrVOs, null);
				for(int i=0; i<upCnt.length; i++){
					if(upCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
			
			log.info("\n ::2007816::DBDAO:: update count is ["+upCnt+"] \n");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return upCnt;
	}		
	

}

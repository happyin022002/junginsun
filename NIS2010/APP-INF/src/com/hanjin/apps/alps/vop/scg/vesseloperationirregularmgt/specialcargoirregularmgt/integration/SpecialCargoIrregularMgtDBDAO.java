/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAO.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.29 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.basic.SpecialCargoIrregularMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.BKGOutputVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoInputVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrCntrVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrrFileListVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgUnNoVO;
import com.hanjin.syscommon.common.table.MdmCarrierVO;


/**
 * ALPS SpecialCargoIrregularMgtDBDAO <br>
 * - ALPS-VesselOperationIrregularMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HyunUk Kim
 * @see SpecialCargoIrregularMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class SpecialCargoIrregularMgtDBDAO extends DBDAOSupport {
	
	/**
	 * SPCL CGO Irregular 의 Sequence 를 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchIrregularMaxSeq(IrregularVO irregularVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularVO != null){
				Map<String, String> mapVO = irregularVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrregularMaxSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	 
	/**
	 * SPCL CGO Irregular 의 Container Sequence 를 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchIrrCntrMaxSeq(IrregularVO irregularVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularVO != null){
				Map<String, String> mapVO = irregularVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrCntrMaxSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	 
	/**
	 * SPCL CGO Irregular의 File Sequence 를 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchIrrFileListMaxSeq(IrregularVO irregularVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularVO != null){
				Map<String, String> mapVO = irregularVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrFileMaxSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * SPCL CGO Irregular 를 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return IrregularVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public IrregularVO searchIrregular(IrregularVO irregularVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IrregularVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularVO != null){
				Map<String, String> mapVO = irregularVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrregularVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IrregularVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new IrregularVO():list.get(0);
	}
	 
	/**
	 * SPCL CGO Irregular의 Container 를 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return List<IrrCntrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<IrrCntrVO> searchIrrCntrList(IrregularVO irregularVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IrrCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularVO != null){
				Map<String, String> mapVO = irregularVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrCntrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IrrCntrVO .class);
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
	 * SPCL CGO Irregular의 File 을 조회 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return List<IrrFileListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<IrrFileListVO> searchIrrFileList(IrregularVO irregularVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IrrFileListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularVO != null){
				Map<String, String> mapVO = irregularVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrFileListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IrrFileListVO .class);
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
	 * SPCL CGO Irregular 을 단건 생성 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @throws DAOException
	 */
	public void addIrregular(IrregularVO irregularVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = irregularVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrregularVOCSQL(), param, velParam);
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
	 * SPCL CGO Irregular의 Container 를 일괄적으로 생성 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @param irrCntrVOs List<IrrCntrVO>
	 * @throws DAOException
	 */
	public void addIrrCntr(IrregularVO irregularVO, List<IrrCntrVO> irrCntrVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("cgo_opr_cd", irregularVO.getCgoOprCd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(irrCntrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrCntrVOCSQL(), irrCntrVOs, velParam);
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
	 * SPCL CGO Irregular의 File을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param irrFileListVOs List<IrrFileListVO>
	 * @throws DAOException
	 */
	public void addIrrFile(List<IrrFileListVO> irrFileListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(irrFileListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrFileListVOCSQL(), irrFileListVOs,null);
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
	 * SPCL CGO Irregular 을 단건 수정 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyIrregular(IrregularVO irregularVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = irregularVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrregularVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modify SQL");
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
	 * SPCL CGO Irregular 의 Container 을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param irregularVO IrregularVO
	 * @param irrCntrVOs List<IrrCntrVO>
	 * @throws DAOException
	 */
	public void modifyIrrCntr(IrregularVO irregularVO, List<IrrCntrVO> irrCntrVOs) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			velParam.put("cgo_opr_cd", irregularVO.getCgoOprCd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(irrCntrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrCntrVOUSQL(), irrCntrVOs, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SPCL CGO Irregular 의 File 을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param irrFileListVOs List<IrrFileListVO>
	 * @throws DAOException
	 */
	public void modifyIrrFile(List<IrrFileListVO> irrFileListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(irrFileListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrFileListVOUSQL(), irrFileListVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
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
	 * SPCL CGO Irregular 을 단건 삭제 합니다. <br>
	 * 
	 * @param  irregularVO IrregularVO
	 * @return int 
	 * @throws DAOException
	 */
	public int removeIrregular(IrregularVO irregularVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = irregularVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrregularVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
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
	 * SPCL CGO Irregular 의 Container 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param irrCntrVOs List<IrrCntrVO>
	 * @throws DAOException
	 */
	public void removeIrrCntr(List<IrrCntrVO> irrCntrVOs) throws DAOException,Exception {
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(irrCntrVOs.size() > 0){
				velParam.put("spcl_cgo_irr_cntr_seq", irrCntrVOs.get(0).getSpclCgoIrrCntrSeq());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrCntrVODSQL(), irrCntrVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * SPCL CGO Irregular 의 File 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param irrFileListVOs List<IrrFileListVO>
	 * @throws DAOException
	 */
	public void removeIrrFile(List<IrrFileListVO> irrFileListVOs) throws DAOException,Exception {
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(irrFileListVOs.size() > 0){
				velParam.put("spcl_cgo_irr_file_seq", irrFileListVOs.get(0).getSpclCgoIrrFileSeq());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrrFileListVODSQL(), irrFileListVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * SPCL CGO Irregular 의 BKG No. 정보 를 조회 합니다. <br>
	 * 
	 * @param bkgBookingVO BkgBookingVO
	 * @return List<BKGOutputVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BKGOutputVO> searchBKGInfo(BkgBookingVO bkgBookingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGOutputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBookingVO != null){
				Map<String, String> mapVO = bkgBookingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOBKGOutputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGOutputVO .class);
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
	 * SPCL CGO Irregular 의 Container 를 조회 합니다. <br>
	 * 
	 * @param bkgBookingVO BkgBookingVO
	 * @return List<CNTRInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CNTRInfoVO> searchCNTRList(BkgBookingVO bkgBookingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CNTRInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgBookingVO != null){
				Map<String, String> mapVO = bkgBookingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOCNTRListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CNTRInfoVO .class);
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
	 * SPCL CGO Irregular 의 Container 정보를 조회 합니다. <br>
	 * 
	 * @param cNTRInfoInputVO CNTRInfoInputVO
	 * @return List<CNTRInfoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CNTRInfoVO> searchCNTRInfo(CNTRInfoInputVO cNTRInfoInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CNTRInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cNTRInfoInputVO != null){
				Map<String, String> mapVO = cNTRInfoInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOCNTRInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CNTRInfoVO .class);
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
	 * SPCL CGO Irregular List 을 조회 합니다. <br>
	 * 
	 * @param irregularsVO IrregularsVO
	 * @return List<IrregularsVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<IrregularsVO> searchIrrHistList(IrregularsVO irregularsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IrregularsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(irregularsVO != null){
				Map<String, String> mapVO = irregularsVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOIrregularsVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IrregularsVO .class);
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
	 * SPCL CGO Irregular List 의 Lane 을 조회 합니다. <br>
	 * 
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchIrrLaneList() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOMdmVslSvcLaneVORSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
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
	 * SPCL CGO Irregular List 의 Vessel 을 조회 합니다. <br>
	 * 
	 * @return List<MdmVslCntrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslCntrVO> searchIrrVslList() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslCntrVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOMdmVslCntrVORSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslCntrVO .class);
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
	 * SPCL CGO Irregular List 의  Vessel Operator 를 조회 합니다. <br>
	 * 
	 * @return List<MdmCarrierVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCarrierVO> searchIrrVslOprList() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCarrierVO> list = null;

		try{
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("crr_cd", "vsl_opr_tp_cd");
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL(), null, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCarrierVO .class);
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
	 * SPCL CGO Irregular List 의  Cargo Operator 를 조회 합니다. <br>
	 * 
	 * @return List<MdmCarrierVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCarrierVO> searchIrrCgoOprList() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCarrierVO> list = null;

		try{
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("crr_cd", "cgo_opr_cd");
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOVskCarrierVORSQL(), null, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCarrierVO .class);
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
	 * SPCL CGO Irregular List 의 Class 를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgClssCdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgImdgClssCdVO> searchIrrClassList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgClssCdVO> list = null;

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOScgImdgClssCdVORSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgClssCdVO .class);
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
	 * SPCL CGO Irregular List 의 Class Comp 를 조회 합니다. <br>
	 * 
	 * @param scgImdgClssCdVO ScgImdgClssCdVO
	 * @return List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgImdgCompGrpVO> searchIrrClassCompList(ScgImdgClssCdVO scgImdgClssCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgCompGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgClssCdVO != null){
				Map<String, String> mapVO = scgImdgClssCdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOScgImdgCompGrpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCompGrpVO .class);
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
	 * SPCL CGO Irregular List 의 UN No. 를 조회 합니다. <br>
	 * 
	 * @return List<ScgImdgUnNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgImdgUnNoVO> searchIrrUnNoList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgUnNoVO> list = null;

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOScgImdgUnNoVORSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgUnNoVO .class);
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
	 * SPCL CGO Irregular List 의 Location 를 조회 합니다. <br>
	 * 
	 * @param mdmLocationVO MdmLocationVO
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmLocationVO> searchIrrPortCdList(MdmLocationVO mdmLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmLocationVO != null){
				Map<String, String> mapVO = mdmLocationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoIrregularMgtDBDAOMdmLocationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO .class);
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
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtDAO.java
*@FileTitle : ISO Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.30 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.basic.ContainerSpecMgtBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgSccVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.EqOrgYardVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.ContainerTypeSizeCodeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MstIsoCntrTpSzVO;
import com.hanjin.syscommon.common.table.MstCntrStsVO;
import com.hanjin.syscommon.common.table.MstCntrPreStsVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.LeaseTermVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.CntrSpecListBrieflyVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo.MstCntrSpecVO;


/**
 * ALPS ContainerSpecMgtDAO <br>
 * - ALPS-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Suk Jun Kim
 * @see ContainerSpecMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerSpecMgtDBDAO extends DBDAOSupport {

	/**
	 *  EqStatusCode를 조회합니다<br>
	 * 
	 * @return List<MstCntrStsVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MstCntrStsVO> searchEqStatusCodeListData() throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<MstCntrStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchEqStatusCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstCntrStsVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	
	/**
	 * EqStatusCode를 생성합니다.<br>
	 * 
	 * @param List<MstCntrStsVO> mstCntrStsVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void addEqStatusCodeData(List<MstCntrStsVO> mstCntrStsVOs) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mstCntrStsVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOAddEqStatusCodeCSQL(), mstCntrStsVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EqStatusCode를 수정합니다.<br>
	 * 
	 * @param List<MstCntrStsVO> mstCntrStsVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void modifyEqStatusCodeData(List<MstCntrStsVO> mstCntrStsVOs) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mstCntrStsVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOModifyEqStatusCodeUSQL(), mstCntrStsVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EqPreStatusCode를 삭제합니다.<br>
	 * 
	 * @param List<MstCntrStsVO> mstCntrStsVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void removeEqPreStatusCodeAllData(List<MstCntrStsVO> mstCntrStsVOs) throws DAOException,Exception{
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");			
			if(mstCntrStsVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAORemoveEqPreStatusCodeAllDSQL(), mstCntrStsVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EqStatusCode를 삭제 합니다.<br>
	 * 
	 * @param List<MstCntrStsVO> mstCntrStsVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void removeEqStatusCodeData(List<MstCntrStsVO> mstCntrStsVOs) throws DAOException,Exception{
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");			
			if(mstCntrStsVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAORemoveEqStatusCodeDSQL(), mstCntrStsVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EqPreStatusCodeList를 조회한다.<br>
	 * 
	 * @return List<MstCntrPreStsVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MstCntrPreStsVO> searchEqPreStatusCodeListData() throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<MstCntrPreStsVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchEqPreStatusCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstCntrPreStsVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EqPreStatusCode를 생성한다.<br>
	 * 
	 * @param List<MstCntrPreStsVO> mstCntrPreStsVOs
	 * @exception DAOException
	 * @exception Exception 
	 */
	public void addEqPreStatusCodeData(List<MstCntrPreStsVO> mstCntrPreStsVOs) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mstCntrPreStsVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOAddEqPreStatusCodeCSQL(), mstCntrPreStsVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * EqPreStatusCode를 삭제한다.<br>
	 * 
	 * @param List<MstCntrPreStsVO> mstCntrPreStsVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeEqPreStatusCodeData(List<MstCntrPreStsVO> mstCntrPreStsVO) throws DAOException,Exception 
	{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(mstCntrPreStsVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAORemoveEqPreStatusCodeDSQL(), mstCntrPreStsVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ISOCodeList를 조회한다.<br>
	 * 
	 * @return List<MstIsoCntrTpSzVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MstIsoCntrTpSzVO> searchISOCodeListData() throws DAOException {
		DBRowSet dbRowset = null;
		List<MstIsoCntrTpSzVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOMstIsoCntrTpSzVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstIsoCntrTpSzVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
		
	/**
	 * ISO Code를 저장합니다.<br>
	 * 
	 * @param List<MstIsoCntrTpSzVO> mstIsoCntrTpSzVOs
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void addISOCodeData(List<MstIsoCntrTpSzVO> mstIsoCntrTpSzVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mstIsoCntrTpSzVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOAddISOCodeCSQL(), mstIsoCntrTpSzVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * ISO Code를 수정합니다.<br>
	 * 
	 * @param List<MstIsoCntrTpSzVO> mstIsoCntrTpSzVOs 
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void modifyISOCodeData(List<MstIsoCntrTpSzVO> mstIsoCntrTpSzVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mstIsoCntrTpSzVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOModifyISOCodeUSQL(), mstIsoCntrTpSzVOs,null);
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
//		try {
//			if(mstIsoCntrTpSzVOs.size() > 0)
//			{
//				// 서버 정의 Exception 사용을 위해 1건씩 처리하는 방식으로 변경.
//				// 업데이트시 업데이트대상건수가 0이면 오류발생시키고 rollback 함.
//				// 업데이트 건수가 0임은 업데이트하려는 자료가 이미 삭제된 자료임을 뜻함.
//				int modifyNum = 0;
//				for(int i = 0; i < mstIsoCntrTpSzVOs.size(); i++)
//				{
//					modifyNum = modifymanageISOCodeData(mstIsoCntrTpSzVOs.get(i));
//					if(modifyNum==0)
//					{
//						throw new DAOException(new ErrorHandler("MST00010").getMessage());
//					}
//				}
//			}
//		} catch (SQLException se) {
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
	}
	
	/**
	 * ISO Code를 삭제합니다.<br>
	 * 
	 * @param List<MstIsoCntrTpSzVO> mstIsoCntrTpSzVOs
	 * @exception DAOException
	 * @exception Exception 
	 */
	public void removeISOCodeData(List<MstIsoCntrTpSzVO> mstIsoCntrTpSzVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(mstIsoCntrTpSzVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAORemoveISOCodeDSQL(), mstIsoCntrTpSzVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EqOrgSccList를 조회합니다<br>
	 * 
	 * @return List<EqOrgSccVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqOrgSccVO> searchEqOrgSccListData() throws DAOException {
		DBRowSet dbRowset = null;
		List<EqOrgSccVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchEqOrgSccListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqOrgSccVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * EqOrgYardList를 조회합니다<br>
	 * 
	 * @param EqOrgYardVO eqOrgYardVO
	 * @return List<EqOrgYardVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EqOrgYardVO> searchEqOrgYardListData(EqOrgYardVO eqOrgYardVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqOrgYardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eqOrgYardVO != null){
				Map<String, String> mapVO = eqOrgYardVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchEqOrgYardListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqOrgYardVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	
	/**
	* Container Type/Size를 조회한다.<br>
	* 
	* @return List<ContainerTypeSizeCodeVO>
	* @exception DAOException 
	*/
	@SuppressWarnings("unchecked")
	public List<ContainerTypeSizeCodeVO> searchCntrTypeSizeCodeListData() throws DAOException {
		DBRowSet dbRowset = null;
		List<ContainerTypeSizeCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchCntrTypeSizeCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContainerTypeSizeCodeVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Container Type/Size를 수정한다.<br> 
	 * 
	 * @param List<ContainerTypeSizeCodeVO> cntrTypeSizeCodeVOs
	 * @exception DAOException 
	 */
	public void modifyCntrTypeSizeCodeData(List<ContainerTypeSizeCodeVO> cntrTypeSizeCodeVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cntrTypeSizeCodeVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOModifyCntrTypeSizeCodeBasicUSQL(), cntrTypeSizeCodeVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	

	
	/** EES_MST_0004 : retrieve<br>
	 * Lease Term Code를 조회합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004
	 * @category searchLeaseTermCodeListData    
	 * @return List<LeaseTermVO>
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public List<LeaseTermVO> searchLeaseTermCodeListData() throws DAOException {
		DBRowSet dbRowset = null;
		List<LeaseTermVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOMstLseTermVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LeaseTermVO .class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/** EES_MST_0004 : save<br>
	 * Lease Term Code를 등록합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_1
	 * @category addLeaseTermCodeData    
	 * @param List<LeaseTermVO> leaseTermVOs
	 * @exception DAOException
	 * @exception Exception  
	 */	
	public void addLeaseTermCodeData(List<LeaseTermVO> leaseTermVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(leaseTermVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOMstLseTermVOCSQL(), leaseTermVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/** EES_MST_0004 : save <br>
	 * Lease Term Code를 수정합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_2
	 * @category modifyLeaseTermCodeData    
	 * @param List<LeaseTermVO> leaseTermVOs
	 * @exception DAOException
	 * @exception Exception 
	 */	
	public void modifyLeaseTermCodeData(List<LeaseTermVO> leaseTermVOs) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(leaseTermVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOMstLseTermVOUSQL(), leaseTermVOs,null);
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
	
	}
	
	/** EES_MST_0004 : save<br> 
	 * Lease Term Code를 삭제합니다.<br> 
	 * @author LEE HO SUN
	 * @category EES_MST_0004_4
	 * @category removeLeaseTermCodeData    
	 * @param List<LeaseTermVO> leaseTermVOs
	 * @exception DAOException 
	 * @exception Exception
	 */	
	public void removeLeaseTermCodeData(List<LeaseTermVO> leaseTermVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(leaseTermVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerSpecMgtDBDAOMstLseTermVODSQL(), leaseTermVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * CntrSpec를 조회합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return MstCntrSpecVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public MstCntrSpecVO searchCntrSpecData(MstCntrSpecVO mstCntrSpecVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MstCntrSpecVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mstCntrSpecVO != null){
				Map<String, String> mapVO = mstCntrSpecVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchCntrSpecRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstCntrSpecVO .class);
			mstCntrSpecVO = list.get(0);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mstCntrSpecVO;
	}
	
	/**
	 * CntrSpec를 조회합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void createCntrSpecData(MstCntrSpecVO mstCntrSpecVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = mstCntrSpecVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerSpecMgtDBDAOMstCntrSpecVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CntrSpec를 조회합니다<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception  
	 */
	public int modifyCntrSpecData(MstCntrSpecVO mstCntrSpecVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = mstCntrSpecVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerSpecMgtDBDAOMstCntrSpecVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * CntrSpec을 삭제한다.
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @exception DAOException
	 * @exception Exception  
	 */
	public void removeCntrSpecData(MstCntrSpecVO mstCntrSpecVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = mstCntrSpecVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerSpecMgtDBDAOMstCntrSpecVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CntrSpec를 조회합니다<br>
	 * 
	 * @param CntrSpecListBrieflyVO cntrSpecListBrieflyVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrSpecListBrieflyVO> searchCntrSpecListBrieflyData(CntrSpecListBrieflyVO cntrSpecListBrieflyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrSpecListBrieflyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntrSpecListBrieflyVO != null){
				Map<String, String> mapVO = cntrSpecListBrieflyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOMstCntrSpecVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSpecListBrieflyVO .class);
			return list;			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CntrSpec 번호가 삭제가 가능한지 조회합니다.<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCntrSpecUsingCheckData(MstCntrSpecVO mstCntrSpecVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// return Value
		String strReturn = "";
		/*
		param.put("CNTR_SPEC_NO", mstCntrSpecVO.getCntrSpecNo());
		param.put("own_cntr_flg", mstCntrSpecVO.getOwnCntrFlg());
		*/
		try{
			if(mstCntrSpecVO != null){
				Map<String, String> mapVO = mstCntrSpecVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchCntrSpecUsingCheckRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
				dbRowset.next();
				strReturn = dbRowset.getString("AGMT");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}

	/**
	 * CNTR_SPEC_NO를 생성합니다.<br>
	 * 
	 * @param MstCntrSpecVO mstCntrSpecVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCntrSpecLastSeqData(MstCntrSpecVO mstCntrSpecVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// return Value
		String strReturn = "";

		try{
			if(mstCntrSpecVO != null){
				Map<String, String> mapVO = mstCntrSpecVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerSpecMgtDBDAOSearchCntrSpecLastSeqRSQL(), param, velParam);
			for (int i=0; i<dbRowset.getRowCount(); i++) {
				dbRowset.next();
				strReturn = dbRowset.getString("CNTR_SPEC_NO");
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}

}

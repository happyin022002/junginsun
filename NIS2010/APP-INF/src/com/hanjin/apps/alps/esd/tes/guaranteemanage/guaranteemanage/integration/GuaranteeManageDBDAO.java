/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageDBDAO.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.basic.GuaranteeManageBCImpl;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeCntrListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeHdrVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesGnteHdrVO;


/**
 * ALPS GuaranteeManageDBDAO <br>
 * - ALPS-GuaranteeManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see GuaranteeManageBCImpl 참조
 * @since J2EE 1.6
 */
public class GuaranteeManageDBDAO extends DBDAOSupport {

	/**
	 * [Guarantee Header] 정보를 [Select] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @return List<SearchUSGuaranteeHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUSGuaranteeHdrVO> searchUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUSGuaranteeHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tesGnteHdrVO != null){
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
				
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeManageDBDAOSearchUSGuaranteeHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSGuaranteeHdrVO .class);
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
	 * [Guarantee Header Max Seq] 정보를 [Select] 합니다.<br>
	 * 
	 * @param ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchUSGuaranteeHdrSeq(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String		grnNo		= "";
		try{
			if( ofcCd != null && !"".equals(ofcCd) ) { 
				param.put("ofc_cd", ofcCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeManageDBDAOSearchUSGuaranteeHdrSeqRSQL(), param, velParam);
			
			if ( dbRowset != null && dbRowset.next() ) {
				grnNo	= dbRowset.getString("GRN_NO");
			}
			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return grnNo;
	}

	/**
	 * [Guarantee Header] 정보를 [Insert] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if ( tesGnteHdrVO != null ) {
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
				
				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GuaranteeManageDBDAOAddUSGuaranteeHdrCSQL(), param, velParam);
			if( result == Statement.EXECUTE_FAILED )
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Guarantee Header] 정보를 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if ( tesGnteHdrVO != null ) {
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GuaranteeManageDBDAOModifyUSGuaranteeHdrUSQL(), param, velParam);
			if( result == Statement.EXECUTE_FAILED )
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Irregular Header Save 할때 Guarantee Header Info]을 [Update] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyUSGuaranteeHdr(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if ( tesGnteHdrVO != null ) {
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GuaranteeManageDBDAOModifyUSGuaranteeIrregularHdrUSQL(), param, velParam);
			if( result == Statement.EXECUTE_FAILED )
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [Guarantee Header] 정보를 [Delete] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeUSGuarantee(TesGnteHdrVO tesGnteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if ( tesGnteHdrVO != null ) {
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new GuaranteeManageDBDAORemoveUSGuaranteeUSQL(), param, velParam);
			if( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [Guarantee Container List Max Sequence] 정보를 [Select] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchUSGuaranteeCntrListSeq(TesGnteHdrVO tesGnteHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int		maxSeq	= 1;
		
		try{
			if( tesGnteHdrVO.getGnteNo() != null && !"".equals( tesGnteHdrVO.getGnteNo() ) ) {
				param.put("gnte_no", tesGnteHdrVO.getGnteNo() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL(), param, velParam);

			if ( dbRowset != null && dbRowset.next() ) {
				maxSeq	= dbRowset.getInt("SEQ");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	 
	/**
	 * [Guarantee Container List]를 [Insert] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addUSGuaranteeCntrList(List<TesGnteCntrListVO> tesGnteCntrListVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
		
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){
				TesGnteCntrListVO	tesGnteCntrListVOtmp = tesGnteCntrListVO.get(0);
				if ( tesGnteCntrListVOtmp.getGnteNo() != null && !"".equals( tesGnteCntrListVOtmp.getGnteNo() ) ) {
					velParam.put("gnte_no", tesGnteCntrListVOtmp.getGnteNo());
				}
				
				if ( tesGnteCntrListVOtmp.getIrrNo() != null && !"".equals( tesGnteCntrListVOtmp.getIrrNo() ) ) {
					velParam.put("irr_no", tesGnteCntrListVOtmp.getIrrNo());
				}
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GuaranteeManageDBDAOAddUSGuaranteeCntrListCSQL(), tesGnteCntrListVO, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * [Guarantee Container List]를 [Update] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyUSGuaranteeCntrList(List<TesGnteCntrListVO> tesGnteCntrListVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){
				TesGnteCntrListVO	tesGnteCntrListVOtmp = tesGnteCntrListVO.get(0);
				if ( tesGnteCntrListVOtmp.getGnteNo() != null && !"".equals( tesGnteCntrListVOtmp.getGnteNo() ) ) {
					velParam.put("gnte_no", tesGnteCntrListVOtmp.getGnteNo());
				}
				
				if ( tesGnteCntrListVOtmp.getIrrNo() != null && !"".equals( tesGnteCntrListVOtmp.getIrrNo() ) ) {
					velParam.put("irr_no", tesGnteCntrListVOtmp.getIrrNo());
				}

				updCnt = sqlExe.executeBatch((ISQLTemplate)new GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL(), tesGnteCntrListVO, velParam);
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
	 * [Guarantee Container List]를 [Delete] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeUSGuaranteeCntrList(List<TesGnteCntrListVO> tesGnteCntrListVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){
				TesGnteCntrListVO	tesGnteCntrListVOtmp = tesGnteCntrListVO.get(0);
				if ( tesGnteCntrListVOtmp.getGnteNo() != null && !"".equals( tesGnteCntrListVOtmp.getGnteNo() ) ) {
					velParam.put("gnte_no", tesGnteCntrListVOtmp.getGnteNo());
				}
				
				if ( tesGnteCntrListVOtmp.getIrrNo() != null && !"".equals( tesGnteCntrListVOtmp.getIrrNo() ) ) {
					velParam.put("irr_no", tesGnteCntrListVOtmp.getIrrNo());
				}
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GuaranteeManageDBDAODeleteUSGuaranteeCntrListDSQL(), tesGnteCntrListVO, velParam);
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
	 * [Guarantee Container List]을 [Select] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @return List<SearchUSGuaranteeCntrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUSGuaranteeCntrListVO> searchUSGuaranteeCntrList(TesGnteHdrVO tesGnteHdrVO) throws DAOException {
		DBRowSet			dbRowset	= null;
		List<SearchUSGuaranteeCntrListVO>	list		= null;
		
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		try{
			if(tesGnteHdrVO != null){
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeManageDBDAOSearchUSGuaranteeCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSGuaranteeCntrListVO .class);
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
	 * [Guarantee Header & Container List]을 [Select]합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUSGuaranteeListVO> searchUSGuaranteeList(TesGnteHdrVO tesGnteHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet						dbRowset	= null;
		List<SearchUSGuaranteeListVO>	list		= null;
		
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		try{
			if(tesGnteHdrVO != null){
				Map<String, String> mapVO = tesGnteHdrVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if ( guaranteeCommonVO != null ) {
				Map<String, String> mapVO = guaranteeCommonVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeManageDBDAOSearchUSGuaranteeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUSGuaranteeListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	 	 
}
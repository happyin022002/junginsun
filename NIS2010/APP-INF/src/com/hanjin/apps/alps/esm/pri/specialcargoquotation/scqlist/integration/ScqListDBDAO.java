/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAO.java
*@FileTitle : Awkward and Break Bulk Cargo Quotation List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.basic.ScqListBCImpl;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkBbVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkMnVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqBbCgoDtlVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqBbHandlingCstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ScqListDBDAO <br>
 * - ALPS-SpecialCargoQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dong-sun Moon
 * @see ScqListBCImpl 참조
 * @since J2EE 1.6
 */
public class ScqListDBDAO extends DBDAOSupport {

	
   /**
	 * Awkward & Break Bulk Cargo Quotation List 조회
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkBbVO> searchAwkBbCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkBbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkBbVO != null){
				Map<String, String> mapVO = priScqAwkBbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchAwkBbCgoQlistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkBbVO .class);
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
	 * Awkward & Break Bulk Quotation List 의 Awkward Case Detail Cargo List 조회
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkBbVO> searchAwkDtlCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkBbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkBbVO != null){
				Map<String, String> mapVO = priScqAwkBbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("\nWWWWW : "+mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchAwkDtlCgoQlistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkBbVO .class);
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
	 * Awkward & Break Bulk Quotation List 의 Break Bulk Case Detail Information List 조회
     * - Cargo Dimension, Container, Proposal & Approval Amount 
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PriScqAwkBbVO searchBbDtlCgoQlist(PriScqAwkBbVO priScqAwkBbVO) throws DAOException {
		DBRowSet dbRowset = null;
		PriScqAwkBbVO retVO= new PriScqAwkBbVO();

		List<PriScqBbCgoDtlVO> PriScqBbCgoDtlVOs = null;
		List<PriScqBbCntrVO> PriScqBbCntrVOs = null;
		List<PriScqBbHandlingCstVO> PriScqBbHandlingCstVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkBbVO != null){
				Map<String, String> mapVO = priScqAwkBbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("\nWWWWW : "+mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchBbCgoDtlListRSQL(), param, velParam);
			PriScqBbCgoDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCgoDtlVO .class);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchBbCntrListRSQL(), param, velParam);
			PriScqBbCntrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCntrVO .class);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchBbHandlingCstRSQL(), param, velParam);
			PriScqBbHandlingCstVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHandlingCstVO .class);
			
			
			retVO.setPriScqBbCgoDtlVos(PriScqBbCgoDtlVOs);
			retVO.setPriScqBbCntrVOs(PriScqBbCntrVOs);
			retVO.setPriScqBbHandlingCstVos(PriScqBbHandlingCstVOs);
			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}

	/**
	 * Awkward & Break Bulk Cargo Approval List 조회
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkBbVO> searchAwkBbCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkBbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkBbVO != null){
				Map<String, String> mapVO = priScqAwkBbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchAwkBbCgoAlistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkBbVO .class);
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
	 * Awkward & Break Bulk Approval List 의 Awkward Case Detail Cargo List 조회
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriScqAwkBbVO> searchAwkDtlCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAwkBbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkBbVO != null){
				Map<String, String> mapVO = priScqAwkBbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("\nWWWWW : "+mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchAwkDtlCgoQlistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqAwkBbVO .class);
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
	 * Awkward & Break Bulk Approval List 의 Break Bulk Case Detail Information List 조회
     * - Cargo Dimension, Container, Proposal & Approval Amount 
	 * 
	 * @param PriScqAwkBbVO priScqAwkBbVO
	 * @return List<PriScqAwkBbVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public PriScqAwkBbVO searchBbDtlCgoAlist(PriScqAwkBbVO priScqAwkBbVO) throws DAOException {
		DBRowSet dbRowset = null;
		PriScqAwkBbVO retVO= new PriScqAwkBbVO();

		List<PriScqBbCgoDtlVO> PriScqBbCgoDtlVOs = null;
		List<PriScqBbCntrVO> PriScqBbCntrVOs = null;
		List<PriScqBbHandlingCstVO> PriScqBbHandlingCstVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScqAwkBbVO != null){
				Map<String, String> mapVO = priScqAwkBbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("\nWWWWW : "+mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchBbCgoDtlListRSQL(), param, velParam);
			PriScqBbCgoDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCgoDtlVO .class);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchBbCntrListRSQL(), param, velParam);
			PriScqBbCntrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbCntrVO .class);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchBbHandlingCstRSQL(), param, velParam);
			PriScqBbHandlingCstVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScqBbHandlingCstVO .class);
			
			
			retVO.setPriScqBbCgoDtlVos(PriScqBbCgoDtlVOs);
			retVO.setPriScqBbCntrVOs(PriScqBbCntrVOs);
			retVO.setPriScqBbHandlingCstVos(PriScqBbHandlingCstVOs);
			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}
			 
	/**
	 * PRI_SCQ_ATCH_FILE  테이블 건 조회
	 * 
	 * @param PriScqAtchFileVO vo
	 * @return List<PriScqAtchFileVO>
	 * @throws DAOException
	 */
	public List<PriScqAtchFileVO> searchPriScqAtchFile(PriScqAtchFileVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriScqAtchFileVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ScqListDBDAOsearchPriScqAtchFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriScqAtchFileVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * PRI_SCQ_ATCH_FILE 테이블 건 생성
	 * 
	 * @param List<PriScqAtchFileVO> listVO
	 * @return int
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public int removePriScqAtchFile(List<PriScqAtchFileVO>  listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<PriScqAtchFileVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		PriScqAtchFileVO bkgImpImgStoVO = (PriScqAtchFileVO)list.next();
					Map<String, String> mapVO = bkgImpImgStoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new ScqListDBDAOremovePriScqAtchFileDSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * PRI_SCQ_ATCH_FILE 테이블 건 생성
	 * 
	 * @param List<PriScqAtchFileVO> listVO
	 * @return int
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public int addPriScqAtchFile(List<PriScqAtchFileVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<PriScqAtchFileVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		PriScqAtchFileVO bkgImpImgStoVO = (PriScqAtchFileVO)list.next();
					Map<String, String> mapVO = bkgImpImgStoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new ScqListDBDAOaddPriScqAtchFileCSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
				}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
		
	/**
	 * Customer List를 조회합니다. <br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmCustVO != null){
				Map<String, String> mapVO = mdmCustVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScqListDBDAOsearchMdmCustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}
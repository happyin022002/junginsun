/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EdiTransmitHistoryDBDAO.java
 *@FileTitle : DG EDI Transmit History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.15
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.10.15 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.basic.EdiTransmitHistoryBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.EdiTransmitHistoryHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo.ImdgItemBkgSummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/** 
 *  EdiTransmitHistoryDBDAO <br>
 *  EDI HISTORY.<br>
 * 
 * @author DONG SOO YANG
 * @see EdiTransmitHistoryBCImpl 참조
 * @since J2EE 1.6
 */
public class EdiTransmitHistoryDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	 /**
	 *  DG EDI Transmit History 대상 조회
	 * 
	 * @param EdiTransmitHistoryHdrVO vo
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitHistoryHdr(EdiTransmitHistoryHdrVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EdiTransmitHistoryHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EdiTransmitHistoryDBDAOSearchTrsmListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiTransmitHistoryHdrVO .class);
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
	 *  DG EDI Transmit History 대상 조회
	 * 
	 * @param EdiTransmitHistoryHdrVO vo
	 * @return List<EdiTransmitHistoryHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitHistoryDtl(EdiTransmitHistoryHdrVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EdiTransmitHistoryHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EdiTransmitHistoryDBDAOSearchDtlListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiTransmitHistoryHdrVO .class);
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
	 *  DG EDI Transmit History 대상 조회
	 * 
	 * @param ImdgItemBkgSummaryVO vo
	 * @return List<ImdgItemBkgSummaryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ImdgItemBkgSummaryVO> searchImdgItemBkgSummary(ImdgItemBkgSummaryVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ImdgItemBkgSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EdiTransmitHistoryDBDAOSearchBkgSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImdgItemBkgSummaryVO .class);
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
	  *  DG EDI Transmit History 대상 조회
      * 
	  * @param EdiTransmitHistoryHdrVO vo
	  * @return List<EdiTransmitHistoryHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	public List<EdiTransmitHistoryHdrVO> searchEdiTransmitFlatFile(EdiTransmitHistoryHdrVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EdiTransmitHistoryHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EdiTransmitHistoryDBDAOSearchFlatFileRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EdiTransmitHistoryHdrVO .class);
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


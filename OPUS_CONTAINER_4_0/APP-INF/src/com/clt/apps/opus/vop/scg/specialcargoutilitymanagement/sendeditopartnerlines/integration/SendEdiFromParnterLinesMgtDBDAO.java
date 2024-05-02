/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDAO.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.ScgPrnrSpclCgoTrsmHdrVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.vo.SendEdiFromBkgDtlVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.vo.SendEdiFromBkgHdrVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/** 
 * SendEdiFromParnterLinesMgtDBDAO <br>
 * - SPCL CGO APVL for Own BKG system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author DONG SOO YANG
 * @see SendEdiFromParnterLinesMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class SendEdiFromParnterLinesMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	 /**
	 * VSL_CD와 OUT BOUND CONSORTIUM VOYAGE값으로 VVD정보를 확인한다. 
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<ScgPrnrSpclCgoTrsmHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgPrnrSpclCgoTrsmHdrVO> searchTrsmHdr(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPrnrSpclCgoTrsmHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
			velParam.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SendEdiFromParnterLinesMgtDBDAOSearchTrsmHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPrnrSpclCgoTrsmHdrVO .class);
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
	 * flatFile header정보를 조회한다.
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendEdiFromBkgHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SendEdiFromBkgHdrVO> searchBkgHdr(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendEdiFromBkgHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
			velParam.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SendEdiFromParnterLinesMgtDBDAOSearchBkgHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendEdiFromBkgHdrVO .class);
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
	 * flatFile header정보를 조회한다.
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendEdiFromBkgHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SendEdiFromBkgHdrVO> searchAproRqstCancelForVVDChange(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendEdiFromBkgHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
			velParam.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SendEdiFromParnterLinesMgtDBDAOSearchEdiCancelForVVDChangeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendEdiFromBkgHdrVO .class);
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
	 * flatFile Detail정보를 조회한다.
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendEdiFromBkgDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SendEdiFromBkgDtlVO> searchBkgDtl(Map<String, String> mapVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SendEdiFromBkgDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
			velParam.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SendEdiFromParnterLinesMgtDBDAOSearchBkgDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SendEdiFromBkgDtlVO .class);
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
	 * 'NYKU' || LPAD(SCG_PRNR_SPCL_CGO_CNTR_DMY_SEQ.NEXTVAL, 10, '0')
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchCntrSequence() throws DAOException {
		DBRowSet dbRowset = null;
		String sequence = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SendEdiFromParnterLinesMgtDBDAOSearchCntrSequenceRSQL(), param, velParam);
			if(dbRowset.next()) sequence = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sequence;
	}
	
	/**
	 * SCG_PRNR_APRO_RQST의 상태 변경  <br>
	 * 
	 * @param Map<String, String> mapVO
	 * @throws DAOException
	 */
	public void modifyScgPrnrAproRqst(Map<String, String> mapVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			param.putAll	(mapVO);
			velParam.putAll	(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new SendEdiFromParnterLinesMgtDBDAOScgPrnrAproRqstUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyScgPrnrAproRqst SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	 /**
	 * 최초 BKG에 발송된 DG EDI's Reference No 추출하기
	 * @param SendDgEdiRequestVO sendDgEdiRequestVO
	 * @return String
	 * @throws DAOException
	 */
	public String selectOriginalFlatFileReferenceNO(SendDgEdiRequestVO sendDgEdiRequestVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		String 		sRtnValue	= null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			if(sendDgEdiRequestVO == null)	return	null;
			
			param.putAll(sendDgEdiRequestVO.getColumnValues());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL(), param, null);
			if(dbRowset.next()) sRtnValue = dbRowset.getString(1);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sRtnValue;
	}
	
}


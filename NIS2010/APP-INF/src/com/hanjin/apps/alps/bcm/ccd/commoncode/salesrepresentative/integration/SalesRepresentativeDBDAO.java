/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : salesrepresentativeDBDAO.java
*@FileTitle : sales rep.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.basic.SalesRepresentativeBCImpl;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS salesrepresentativeDBDAO <br>
 * - OPUS-commoncode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see SalesRepresentativeBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesRepresentativeDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * sls rep code로 상세 정보 조회합니다.<br>
	 * 
	 * @param String srepCd
	 * @return SalesRepVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SalesRepVO searchSlsRepCode(String srepCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SalesRepVO> list = new ArrayList<SalesRepVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(srepCd != null && !"".equals(srepCd)){
				param.put("srep_cd", srepCd);
				velParam.put("srep_cd", srepCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRepresentativeDBDAOSearchSlsRepCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SalesRepVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	 
	 
	 /**
		 * sls rep code로 상세 정보 조회합니다.<br>
		 * 
		 * @param String srepCd
		 * @return SalesRepVO
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public SalesRepIfVO searchSlsRepInterface(String srepCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<SalesRepIfVO> list = new ArrayList<SalesRepIfVO>();
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if(srepCd != null && !"".equals(srepCd)){
					param.put("srep_cd", srepCd);
					velParam.put("srep_cd", srepCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRepresentativeDBDAOSearchSlsRepInterfaceRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SalesRepIfVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			if (list.size() > 0)
				return list.get(0);
			else
				return null;
		}
		 
	/**
	 * 새로운 sls rep code 생성합니다.<br>
	 * 
	 * @param SalesRepVO salesRepVO
	 * @exception DAOException
	 */
	 public void addSlsRepCode(SalesRepVO salesRepVO) throws DAOException {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(salesRepVO != null){
				Map<String, String> mapVO = salesRepVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SalesRepresentativeDBDAOAddSlsRepCodeCSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	 /**
		 * 새로운 sls rep code 생성합니다.<br>
		 * 
		 * @param SalesRepVO salesRepVO
		 * @exception DAOException
		 */
		 public void addSlsRepRqst(SalesRepVO salesRepVO) throws DAOException {
			int creCnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(salesRepVO != null){
					Map<String, String> mapVO = salesRepVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SalesRepresentativeDBDAOAddSlsRepRqstCSQL(), param, velParam);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 }
			 
	/**
	 * 조회해 온 sls rep code의 상세정보 수정합니다.<br>
	 * 
	 * @param SalesRepVO salesRepVO
	 * @exception DAOException
	 */
	 public void modifySlsRepCode(SalesRepVO salesRepVO) throws DAOException {
		int creCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(salesRepVO != null){
				Map<String, String> mapVO = salesRepVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SalesRepresentativeDBDAOModifySlsRepCodeUSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	 /**
		 * 조회해 온 sls rep code의 상세정보 수정합니다.<br>
		 * 
		 * @param SalesRepVO salesRepVO
		 * @exception DAOException
		 */
		 public void modifySlsRepRqst(SalesRepVO salesRepVO) throws DAOException {
			int creCnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(salesRepVO != null){
					Map<String, String> mapVO = salesRepVO.getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				creCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new SalesRepresentativeDBDAOModifySlsRepRqstUSQL(), param, velParam);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 }
	 
	/**
	 * Country Code 유무를 확인.<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSlsRepMaxSeq(String cntCd, String usrId) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		String result = new String();
			try {
				if(cntCd != null){
					param.put("cnt_cd",cntCd);
					param.put("usr_id",usrId);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRepresentativeDBDAOSearchSlsRepMaxSeqRSQL(), param, null);
				if(dbRowset != null){
					if(dbRowset.next()){
						result = dbRowset.getString("srep_cd");
					}
				}
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return result;
	}
	
	/**
	 * CNT_CD 별 SREP_MAX_SEQ 정보를 추가한다.
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSrepMaxSeq(String cntCd, SignOnUserAccount account) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("cnt_cd", cntCd);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SalesRepresentativeDBDAOAddSrepMaxSeqCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CNT_CD 별 SREP_MAX_SEQ 정보를 수정한다.
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySrepMaxSeq(String cntCd, SignOnUserAccount account) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("cnt_cd", cntCd);
			param.put("upd_usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SalesRepresentativeDBDAOModifySrepMaxSeqUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
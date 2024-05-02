/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAO.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.19 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChassisMgsetAgreementBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 ChassisMgsetAgreementDBDAO <br>
 * - NIS2010-ChassisMgsetAgreementInvoice system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementBCImpl 참조
 * @since J2EE 1.4
 */
public class ChassisMgsetAgreementDBDAO extends DBDAOSupport {

	/**
	 * 입력된 Office에 속한 현재까지 저장되어 있는 Chassis의 장비 임대 계약 Agreement(CGM_AGREEMENT 테이블) <br>
	 * 정보를 가져와서 Gird 에 Agreement List를 Display 한다. [EES_CGM_1021] <br>
	 * 
	 * @param chsAreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementListMGTVO> searchCHSAgreementListData(CHSAgreementListINVO chsAreementListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementListMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chsAreementListINVO != null){
				Map<String, String> mapVO = chsAreementListINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementListMGTVO .class);
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
	 * 입력된 Office에 속한 현재까지 저장되어 있는 M.G.set의 장비 임대 계약 Agreement(CGM_AGREEMENT 테이블)  <br>
	 * 정보를 가져와서 Gird 에 Agreement List를 Display 한다. [EES_CGM_2023] <br>
	 * 
	 * @param mgsAreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception DAOException
	 */ 
	 @SuppressWarnings("unchecked")
	public List<MGSAgreementListMGTVO> searchMGSAgreementListData(MGSAgreementListINVO mgsAreementListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSAgreementListMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsAreementListINVO != null){
				Map<String, String> mapVO = mgsAreementListINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSAgreementListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSAgreementListMGTVO .class);
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
	 * ChassisMgsetAgreementDBDAO의 데이타 Chassis 에 관련된  <br>
	 * Lease Agreement List Inquiry 값을 불러온다. [EES_CGM_1117] <br>
	 * 
	 * @param chsAreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementListMGTVO> searchCHSAgreementSelectionListData(CHSAgreementListINVO chsAreementListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementListMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(chsAreementListINVO != null){
				Map<String, String> mapVO = chsAreementListINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementSelectionListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementListMGTVO .class);
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
	 * ChassisMgsetAgreementDBDAO의 데이타 Mgset 에 관련된 <br>
	 * Lease Agreement List Inquiry 값을 불러온다. [EES_CGM_2022]<br>
	 * 
	 * @param mgsAreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSAgreementListMGTVO> searchMGSAgreementSelectionListData(MGSAgreementListINVO mgsAreementListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSAgreementListMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsAreementListINVO != null){
				Map<String, String> mapVO = mgsAreementListINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSAgreementSelectionListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSAgreementListMGTVO .class);
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
	 * Agreement No로 기존에 등록된 Agreement 정보가 있는지 조회한다. [EES_CGM_1020] <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return List<CHSAgreementMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementMGTVO> searchCHSAgreementMainData(CHSAgreementINVO chsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsAgreementINVO != null){
				Map<String, String> mapVO = chsAgreementINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementMGTVO .class);
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
	 * Agreement 에 해당하는 rate 정보를 CGM_AGMT_LSE_RT 에서 조회한다. [EES_CGM_1020] <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return List<CHSAgreementMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementMGTVO> searchCHSAgreementLseRtData(CHSAgreementINVO chsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
			if(chsAgreementINVO != null){
				Map<String, String> mapVO = chsAgreementINVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementLseRtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementMGTVO .class);
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
	 * Agreement 에 해당하는 rate 정보를 CGM_AGMT_LSE_RT 에서 조회한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return List<CHSAgreementMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementMGTVO> searchCHSAgreementLseTrRtData(CHSAgreementINVO chsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
			if(chsAgreementINVO != null){
				Map<String, String> mapVO = chsAgreementINVO .getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementLseTrRtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementMGTVO .class);
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
	 * Agreement 에 해당하는 scg 정보를 CGM_AGMT_LSE_SCG 에서 조회한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return List<CHSAgreementMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementMGTVO> searchCHSAgreementLseScgData(CHSAgreementINVO chsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(chsAgreementINVO != null){
				Map<String, String> mapVO = chsAgreementINVO .getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementLseScgDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementMGTVO .class);
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
	 * 신규입력시 Agreement No 생성. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return String
	 * @exception DAOException
	 */
	public String searchCHSAgreemetAgmtSeqData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
				
		DBRowSet dbRowset = null;
		String agmtSeq = "0";
				
		try {					
			if(chsAgreementINVO != null){	
				// AgmtSeq Max 값을 구해온다.
			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSAgreementAgmtSeqDataRSQL(), null, null);
				                                                                  
				if(dbRowset.next()){
					agmtSeq = dbRowset.getString("agmt_seq");
				}					
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
				
		return agmtSeq;
	} 
	
	/** 
	 * 신규입력시 Agreement No 생성. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @return String
	 * @exception DAOException
	 */
	public String searchMGSAgreemetAgmtSeqData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {
				
		DBRowSet dbRowset = null;
		String agmtSeq = "0";
				
		try {					
			if(mgsAgreementINVO != null){	
				// AgmtSeq Max 값을 구해온다.
			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSAgreementAgmtSeqDataRSQL(), null, null);
				                                                                  
				if(dbRowset.next()){
					agmtSeq = dbRowset.getString("agmt_seq");
				}					
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
				
		return agmtSeq;
	} 
	 
	/** 
	 * Agreement 정보를 CGM_AGREEMENT 테이블에 create 한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @exception DAOException
	 */
	public void addCHSAgreemetMainData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {			
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
				
			if(chsAgreementINVO != null){		
			    //신규 입력
				//query parameter
				Map<String, String> param = chsAgreementINVO.getColumnValues();
			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOAddCHSAgreementMainDataCSQL() , param, null);
					
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
					
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
	 * Agreement 의 Lease Rate정보를 create 한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVOs List<CHSAgreementINVO> 
	 * @exception DAOException
	 */
	public void addCHSAgreementLseRtData(List<CHSAgreementINVO> chsAgreementINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsAgreementINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAgreementDBDAOAddCHSAgreementLseRtDataCSQL(), chsAgreementINVOs,null);
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
	 * Agreement 의 Surcharge 정보를 create 한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVOs List<CHSAgreementINVO> 
	 * @exception DAOException
	 */
	public void addCHSAgreementLseScgData(List<CHSAgreementINVO> chsAgreementINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsAgreementINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAgreementDBDAOAddCHSAgreementLseScgDataCSQL(), chsAgreementINVOs,null);
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
	 * Agreement 의 Lease Rate 정보를 create 한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVOs List<CHSAgreementINVO> 
	 * @exception DAOException
	 */
	public void addCHSAgreementLseTrRtData(List<CHSAgreementINVO> chsAgreementINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(chsAgreementINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAgreementDBDAOAddCHSAgreementLseTrRtDataCSQL(), chsAgreementINVOs,null);
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
	 * Agreement Master 정보를 삭제한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @exception DAOException
	 */
	public void removeCHSAgreementMainData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(chsAgreementINVO != null){
				Map<String, String> param = chsAgreementINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSAgreementMainDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * Agreement 의 Lease Rate 정보를 삭제한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @exception DAOException
	 */
	public void removeCHSAgreementLseRtData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(chsAgreementINVO != null){
				Map<String, String> param = chsAgreementINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSAgreementLseRtDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * Agreement 의 Surchage 정보를 삭제한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @exception DAOException
	 */
	public void removeCHSAgreementLseScgData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(chsAgreementINVO != null){
				Map<String, String> param = chsAgreementINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSAgreementLseScgDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * Agreement 의 Lease Rate 정보를 삭제한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @exception DAOException
	 */
	public void removeCHSAgreementLseTrRtData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(chsAgreementINVO != null){
				Map<String, String> param = chsAgreementINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSAgreementLseTrRtDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * Pool Code가 다른 Agreement 에 있는지 체크한다. 다른 Agreement 에서 사용하고 있으면 Error 처리. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return boolean
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSAgreementMGTVO> checkCHSAgreementPoolMatchData(CHSAgreementINVO chsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSAgreementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
						
		try{
			if(chsAgreementINVO != null){
				Map<String, String> mapVO = chsAgreementINVO .getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckCHSAgreementPoolMatchDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAgreementMGTVO .class);
			
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
	 * CGM_AGREEMENT 데이터를 수정한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @exception DAOException
	 */
	public void modifyCHSAgreemetMainData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");	
			if(chsAgreementINVO != null){	
				//query parameter
			    Map<String, String> param = chsAgreementINVO.getColumnValues();
	
			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOModifyCHSAgreementMainDataUSQL() , param, null);						
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
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
	 * 이전 Version 의 CGM_AGREEMENT 데이터를 수정한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @exception DAOException
	 */
	public void modifyCHSAgreemetPreviousMainData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");	
			if(chsAgreementINVO != null){	
				//query parameter
			    Map<String, String> param = chsAgreementINVO.getColumnValues();
	
			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOModifyCHSAgreementPreviousMainDataUSQL() , param, null);						
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
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
	 * CGM_AGREEMENT 에서 사용하는 장비가 있는지 체크한다.  [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkCHSAgreementUseEquipmentData(CHSAgreementINVO chsAgreementINVO) throws DAOException,Exception {
				
		DBRowSet dbRowset = null;
		boolean rtn = false;
		int cnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {					
			if(chsAgreementINVO != null){	
				
				Map<String, String> mapVO = chsAgreementINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				// AgmtSeq Max 값을 구해온다.
			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckCHSAgreementUseEquipmentDataRSQL(), param, velParam);
			    															                                         
				if(dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}					
				
				if(cnt > 0){
					rtn = true;	// 데이터가 존재함. (사용)
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
				
		return rtn;
	} 
	
	/**
	 * M.G.Set 관련 Agreement No 에 해당하는 Agreement List 정보를 불러온다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @return List<MGSAgreementMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSAgreementMGTVO> searchMGSAgreementMainData(MGSAgreementINVO mgsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSAgreementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mgsAgreementINVO != null){
				Map<String, String> mapVO = mgsAgreementINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSAgreementMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSAgreementMGTVO .class);
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
	 * M.G.Set 관련 Agreement No 에 해당하는 CGM_AGMT_LSE_RT 테이블 정보를 불러온다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @return MGSAgreementMGTVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public MGSAgreementMGTVO searchMGSAgreementLseRtData(MGSAgreementINVO mgsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSAgreementMGTVO> list = null;
		MGSAgreementMGTVO mgtVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
			if(mgsAgreementINVO != null){
				Map<String, String> mapVO = mgsAgreementINVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSAgreementLseRtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSAgreementMGTVO .class);
			
			if(list != null){
				if(list.size() > 0){
					mgtVO = (MGSAgreementMGTVO)list.get(0);
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return mgtVO;
	}
	 
	/** 
	 * CGM_AGREEMENT 데이터를 생성한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @exception DAOException
	 */
	public void addMGSAgreemetMainData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {			
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
				
			if(mgsAgreementINVO != null){		
			    //신규 입력
				//query parameter
				Map<String, String> param = mgsAgreementINVO.getColumnValues();
			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOAddMGSAgreementMainDataCSQL() , param, null);
						
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
					
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
	 * CGM_AGMT_LSE_RT 데이터를 일괄적으로 생성한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVOs List<MGSAgreementINVO>
	 * @exception DAOException
	 */
	public void addMGSAgreementLseRtData(List<MGSAgreementINVO> mgsAgreementINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mgsAgreementINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAgreementDBDAOAddMGSAgreementLseRtDataCSQL(), mgsAgreementINVOs,null);
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
	 * CGM_AGREEMENT 데이터를 삭제한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @exception DAOException
	 */
	public void removeMGSAgreementMainData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(mgsAgreementINVO != null){
				Map<String, String> param = mgsAgreementINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveMGSAgreementMainDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * CGM_AGMT_LSE_RT 데이터를 삭제한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @exception DAOException
	 */
	public void removeMGSAgreementLseRtData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(mgsAgreementINVO != null){
				Map<String, String> param = mgsAgreementINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveMGSAgreementLseRtDataDSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * CGM_AGREEMENT 데이터를 수정한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @exception DAOException
	 */
	public void modifyMGSAgreemetMainData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");	
			if(mgsAgreementINVO != null){	
				//query parameter
			    Map<String, String> param = mgsAgreementINVO.getColumnValues();
	
			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOModifyMGSAgreementMainDataUSQL() , param, null);						
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
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
	 * 이전 Version 의 CGM_AGREEMENT 데이터를 수정한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @exception DAOException
	 */
	public void modifyMGSAgreemetPreviousMainData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");	
			if(mgsAgreementINVO != null){	
				//query parameter
			    Map<String, String> param = mgsAgreementINVO.getColumnValues();
	
			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOModifyMGSAgreementPreviousMainDataUSQL() , param, null);						
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");			
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
	 * CGM_AGREEMENT. AGMT_SEQ 의 시퀀스를 생성한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkMGSAgreementUseEquipmentData(MGSAgreementINVO mgsAgreementINVO) throws DAOException,Exception {
				
		DBRowSet dbRowset = null;
		boolean rtn = false;
		int cnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {					
			if(mgsAgreementINVO != null){	
				
				Map<String, String> mapVO = mgsAgreementINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				// AgmtSeq Max 값을 구해온다.
			    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckMGSAgreementUseEquipmentDataRSQL(), param, velParam);
			    															                                         
				if(dbRowset.next()){
					cnt = dbRowset.getInt("cnt");
				}					
				
				if(cnt > 0){
					rtn = true;	// 데이터가 존재함. (사용)
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
				
		return rtn;
	}
	
	/**
	 * Chassis 에 관련 Agreement No 에 해당하는 현재 Term Change Status List 정보를 불러온다. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO
	 * @return List<CHSTermStatusMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSTermStatusMGTVO> searchCHSTermChangeEqListData(CHSTermStatusINVO chsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSTermStatusMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsTermStatusINVO != null){
				Map<String, String> mapVO = chsTermStatusINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSTermChangeEqListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSTermStatusMGTVO .class);
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
	 * Chassis 에 관련하여 Agreement No 에 속한 특정 EQ_NO 의 현재 Term Change Status 정보를 불러온다. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO
	 * @return List<CHSTermStatusMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSTermStatusMGTVO> searchCHSEqMainData(CHSTermStatusINVO chsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSTermStatusMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsTermStatusINVO != null){
				Map<String, String> mapVO = chsTermStatusINVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSEqMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSTermStatusMGTVO .class);
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
	 * M.G.Set 에 관련 Agreement No 에 해당하는 현재 Term Change Status List 정보를 불러온다. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO
	 * @return List<MGSTermStatusMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSTermStatusMGTVO> searchMGSTermChangeEqListData(MGSTermStatusINVO mgsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSTermStatusMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mgsTermStatusINVO != null){
				Map<String, String> mapVO = mgsTermStatusINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSTermChangeEqListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSTermStatusMGTVO .class);
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
	 * M.G.Set 관련 Agreement No에 속한 특정 EQ_NO 의 현재 Term Change Status 정보를 불러온다. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO
	 * @return List<MGSTermStatusMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSTermStatusMGTVO> searchMGSEqMainData(MGSTermStatusINVO mgsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSTermStatusMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mgsTermStatusINVO != null){
				Map<String, String> mapVO = mgsTermStatusINVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSEqMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSTermStatusMGTVO .class);
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
	 * Chassis 관련 Lease Term Change Inquiry 정보를 불러온다. [EES_CGM_1118]<br>
	 * 
	 * @param chsTermChangeResultINVO CHSTermChangeResultINVO
	 * @return List<CHSTermChangeResultMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSTermChangeResultMGTVO> searchCHSTermChangeResultSmryData(CHSTermChangeResultINVO chsTermChangeResultINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSTermChangeResultMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsTermChangeResultINVO != null){
				Map<String, String> mapVO = chsTermChangeResultINVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSTermChangeResultSmryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSTermChangeResultMGTVO .class);
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
	 * M.G.Set 에 관련 Lease Term Change Inquiry 정보를 불러온다. [EES_CGM_2028]<br>
	 * 
	 * @param mgsTermChangeResultINVO MGSTermChangeResultINVO
	 * @return List<MGSTermChangeResultMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSTermChangeResultMGTVO> searchMGSTermChangeResultSmryData(MGSTermChangeResultINVO mgsTermChangeResultINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSTermChangeResultMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
					
		try{
			if(mgsTermChangeResultINVO != null){
				Map<String, String> mapVO = mgsTermChangeResultINVO .getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchMGSTermChangeResultSmryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSTermChangeResultMGTVO .class);
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
	 * 해당하는 Agreement 가 Charge Creation 된 데이터인지 체크한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return boolean
	 * @exception DAOException
	 */
	 public boolean checkCHSExistChgCreDataByAgreementData(CHSAgreementINVO chsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean chkResult = false;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
							
		try{
			if(chsAgreementINVO != null){
				Map<String, String> mapVO = chsAgreementINVO .getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckCHSExistChgCreDataByAgreementDataRSQL(), param, velParam);
			
			if(dbRowset.next()){
				cnt = dbRowset.getInt("cnt");
			}					
			
			if(cnt > 0){
				chkResult = false;	// Charge Creation 된 데이터가 존재
			} else {
				chkResult = true;	// Charge Creation 된 데이터가 존재하지 않음
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chkResult;
	}	
	 
	/**
	 * 해당하는 Agreement 가 Charge Creation 된 데이터인지 체크한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @return boolean
	 * @exception DAOException
	 */
	 public boolean checkMGSExistChgCreDataByAgreementData(MGSAgreementINVO mgsAgreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean chkResult = false;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
								
		try{
			if(mgsAgreementINVO != null){
				Map<String, String> mapVO = mgsAgreementINVO .getColumnValues();
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckMGSExistChgCreDataByAgreementDataRSQL(), param, velParam);
				
			if(dbRowset.next()){
				cnt = dbRowset.getInt("cnt");
			}					
				
			if(cnt > 0){
				chkResult = false;	// Charge Creation 된 데이터가 존재
			} else {
				chkResult = true;	// Charge Creation 된 데이터가 존재하지 않음
			}
				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chkResult;
	}
	 
	/**
	 * CPS Agreement No로 기존에 등록된 CPS Agreement 정보가 있는지 조회한다. [EES_CGM_1202] <br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO
	 * @return List<CHSCpsAgreementMGTVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CHSCpsAgreementMGTVO> searchCHSCpsAgreementMainData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CHSCpsAgreementMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> mapVO = chsCpsAgreementINVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementMainDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCpsAgreementMGTVO .class);
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
	  * CPS Agreement 에 해당하는 Rate 정보를 CGM_AGMT_CPS_RT 에서 조회한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @return List<CHSCpsAgreementMGTVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CHSCpsAgreementMGTVO> searchCHSCpsAgreementRateData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CHSCpsAgreementMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> mapVO = chsCpsAgreementINVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementRateDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCpsAgreementMGTVO .class);
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
	  * CPS Agreement 에 해당하는 Condition 정보를 CGM_AGMT_CPS_COND 에서 조회한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @return List<CHSCpsAgreementMGTVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CHSCpsAgreementMGTVO> searchCHSCpsAgreementCondData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CHSCpsAgreementMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> mapVO = chsCpsAgreementINVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementCondDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCpsAgreementMGTVO .class);
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
	  * Tab2에서 입력된 Yard Code로부터 Yard Name과 Tab1의 SCC를 체크한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @return CHSCpsAgreementMGTVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CHSCpsAgreementMGTVO checkCHSCpsAgreementYardData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CHSCpsAgreementMGTVO> list = null;
		 CHSCpsAgreementMGTVO chsCpsAgreementMGTVO = new CHSCpsAgreementMGTVO();
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> mapVO = chsCpsAgreementINVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckCHSCpsAgreementYardDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCpsAgreementMGTVO .class);
			 
			 if(list.size() > 0){
				 chsCpsAgreementMGTVO = list.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return chsCpsAgreementMGTVO;
	 }
	 
	 /** 
	  * 신규입력시 NP(CP) Agreement No 생성. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @return String
	  * @exception DAOException
	  */
	 public String searchCHSCpsAgreemetAgmtSeqData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 DBRowSet dbRowset = null;
		 String agmtSeq = "0";
		 
		 try {
			 if(chsCpsAgreementINVO != null){
				 // AgmtSeq Max 값을 구해온다.
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOSearchCHSCpsAgreementAgmtSeqDataRSQL(), null, null);
				 if(dbRowset.next()){
					 agmtSeq = dbRowset.getString("agmt_seq");
				 }
			 } 
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return agmtSeq;
	 }
	 
	 /**
	  * 해당하는 NP(ZP) Agreement 가 Charge Creation 된 데이터인지 체크한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @return boolean
	  * @exception DAOException
	  */
	 public boolean checkCHSCpsExistChgCreDataByAgreementData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 boolean chkResult = false;
		 int cnt = 0;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> mapVO = chsCpsAgreementINVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckCHSCpsExistChgCreDataByAgreementDataRSQL(), param, velParam);
			 if(dbRowset.next()){
				 cnt = dbRowset.getInt("cnt");
			 }
			 if(cnt > 0){
				 chkResult = false;	// Charge Creation 된 데이터가 존재
			 } else {
				 chkResult = true;	// Charge Creation 된 데이터가 존재하지 않음
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
			 
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return chkResult;
	 }
	 
	 /**
	  * Pool Code가 다른 NP(ZP) Agreement 에 있는지 체크한다. 다른 Agreement 에서 사용하고 있으면 Error 처리. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @return List<CHSCpsAgreementMGTVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CHSCpsAgreementMGTVO> checkCHSCpsAgreementPoolMatchData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CHSCpsAgreementMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> mapVO = chsCpsAgreementINVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetAgreementDBDAOCheckCHSCpsAgreementPoolMatchDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSCpsAgreementMGTVO .class);
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
	  * NP(ZP) Agreement 정보를 CGM_AGREEMENT 테이블에 create 한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @exception DAOException
	  */
	 public void addCHSCpsAgreemetMainData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(chsCpsAgreementINVO != null){
				 //신규 입력
				 //query parameter
				 Map<String, String> param = chsCpsAgreementINVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOAddCHSCpsAgreementMainDataCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to insert SQL");
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
	  * CGM_AGREEMENT 데이터를 수정한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO
	  * @exception DAOException
	  */
	 public void modifyCHSCpsAgreemetMainData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(chsCpsAgreementINVO != null){
				 //query parameter
				 Map<String, String> param = chsCpsAgreementINVO.getColumnValues();
				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOModifyCHSCpsAgreementMainDataUSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to insert SQL");
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
	  * 이전 Version 의 CGM_AGREEMENT 데이터를 수정한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO
	  * @exception DAOException
	  */
	 public void modifyCHSCpsAgreemetPreviousMainData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(chsCpsAgreementINVO != null){
				 //query parameter
				 Map<String, String> param = chsCpsAgreementINVO.getColumnValues();
				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAOModifyCHSCpsAgreementPreviousMainDataUSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to insert SQL");
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
	  * NP(ZP) Agreement 의 Rate 정보를 삭제한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @exception DAOException
	  */
	 public void removeCHSCpsAgreementRateData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //int delCnt[] = null;
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> param = chsCpsAgreementINVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSCpsAgreementRateDataDSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to Delete SQL");
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
	  * NP(ZP) Agreement 의 Rate 정보를 create 한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVOs List<CHSCpsAgreementINVO> 
	  * @exception DAOException
	  */
	 public void addCHSCpsAgreementRateData(List<CHSCpsAgreementINVO> chsCpsAgreementINVOs) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int insCnt[] = null;
			 if(chsCpsAgreementINVOs.size() > 0){
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAgreementDBDAOAddCHSCpsAgreementRateDataCSQL(), chsCpsAgreementINVOs,null);
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
	  * NP(ZP) Agreement 의 Condition 정보를 삭제한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @exception DAOException
	  */
	 public void removeCHSCpsAgreementCondData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //int delCnt[] = null;
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> param = chsCpsAgreementINVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSCpsAgreementCondDataDSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to Delete SQL");
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
	  * NP(ZP) Agreement 의 Condition 정보를 create 한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVOs List<CHSCpsAgreementINVO> 
	  * @exception DAOException
	  */
	 public void addCHSCpsAgreementCondData(List<CHSCpsAgreementINVO> chsCpsAgreementINVOs) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int insCnt[] = null;
			 if(chsCpsAgreementINVOs.size() > 0){
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetAgreementDBDAOAddCHSCpsAgreementCondDataCSQL(), chsCpsAgreementINVOs,null);
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
	  * Agreement Master 정보를 삭제한다. [EES_CGM_1202]<br>
	  * 
	  * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	  * @exception DAOException
	  */
	 public void removeCHSCpsAgreementMainData(CHSCpsAgreementINVO chsCpsAgreementINVO) throws DAOException,Exception {
		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 //int delCnt[] = null;
			 if(chsCpsAgreementINVO != null){
				 Map<String, String> param = chsCpsAgreementINVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetAgreementDBDAORemoveCHSCpsAgreementMainDataDSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to Delete SQL");
			 }
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDAO.java
*@FileTitle : Expense Office Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.17 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.gem.common.GemUtil;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.basic.GEMMasterCodeMgtBCImpl;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInqVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInquiryVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseNameVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctExptVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctMtxVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemCngOfcVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfcHisVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfficeVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.MdmAccountVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeExptVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeInfoVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.XchRtInqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 GEMMasterCodeMgtDAO <br>
 * - NIS2010-GEMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author cjm
 * @see GEMMasterCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GEMMasterCodeMgtDBDAO extends DBDAOSupport {

	
	// J.Y.O ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM-0009] Foreign Exchange Rate Maintenance
	// ---------------------------------------------------------------------------
	
    /**
     * 일반관리비 비용계획시 사용할 계획 환율 정보<br>
     * 
     * @author J.Y.O
     * @category CPS_GEM_0009
     * @category searchExpenseInq
	 * @param String year 
	 * @param String deltFlg  
     * @return  List<GemXchRtVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemXchRtVO> searchInitialExchangeRate(String year , String deltFlg) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemXchRtVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//계획환율년
        	param.put("acct_xch_rt_yrmon", year);
        	//삭제 여부
        	param.put("delt_flg", deltFlg);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchInitialExchangeRateRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemXchRtVO.class);
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
     * 1.Excel 로 작성된 계획환율 Upload <br>
     * 2.Upload 된 Currency Code와 조직별 Currency Code를 비교하여, 누락된 조직별 Currency Code를 표시한다<br>
     * 
     * @author JIN YOON OH
     * @category CPS_GEM_0009
     * @category searchCurrencyByOffice
     * 
     * @param inCurrCd
     *           sql in 절 Currency Code List
     * @return Currency Code List
     * @throws EventException
     */
    @SuppressWarnings("unchecked")
    public List<String> searchCurrencyByOffice(List<String> inCurrCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<String> list = new ArrayList<String>();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//CurrCd
        	velParam.put("locl_curr_cd", inCurrCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchCurrencyByOfficeRSQL(), param, velParam);
            
            while (dbRowset.next()) {
				list.add(dbRowset.getString("locl_curr_cd"));
			}
            
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
	 * 일반관리비 비용실적집계시 사용할 경리 환율 정보<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category searchMonthlyExchangeRate
	 * 
	 * @param year 년 
	 * @param currCd 통화코드 (KRW, AED,USD.....) 
	 * @return List<GemXchRtVO> 환율정보 리스트
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
     public List<GemXchRtVO> searchMonthlyExchangeRate(String year , String currCd) throws DAOException {
    	  
         DBRowSet dbRowset = null;
         
         List<GemXchRtVO> list = null;
         
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{    
         	//계획환율년 YYYY
         	param.put("acct_xch_rt_yrmon", year);
         	//통화
         	param.put("curr_cd", currCd);
         	//삭제 여부
         	param.put("delt_flg", "N");
         	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchMonthlyExchangeRateRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemXchRtVO.class);            
            return list;
            
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }         

     }

    
    /**
	 * 일반관리비 환율 정보 저장  <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category addInitialExchangeRateInfos
	 *
     * @param List<GemXchRtVO> addVoList 일반관리비 환율 정보 VO 저장 리스트 
     * @return int
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
     public int addInitialExchangeRateInfo(List<GemXchRtVO> addVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
	        
	         
			int insCnt[] = null;
			if (addVoList.size() > 0) {
				//velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddInitialExchangeRateInfoCSQL(), addVoList,velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
			return insCnt.length;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
     }    
	
    
    /**
	 * 일반관리비 환율 정보 수정 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category modifyInitialExchangeRateInfo
	 * 
     * @param modifyVoList 일반관리비 환율 정보 VO 저장 리스트 
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
     public void modifyInitialExchangeRateInfo (List<GemXchRtVO> modifyVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyInitialExchangeRateInfoUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
     }       
    
    /**
	 * 환율정보 삭제 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category modifyInitialExchangeRateInfo
     * @param List<GemXchRtVO> removeVoList 일반관리비 환율 정보 VO 저장 리스트 
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
     public void removeInitialExchangeRateInfo (List<GemXchRtVO> removeVoList) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (removeVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAORemoveInitialExchangeRateInfoDSQL(), removeVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
     } 
    
    /**
	 * 입력된 Currency Code가 유효한 Code 인지 체크  <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category searchMdmCurrency
	 * 
     * @param currCd 통화코드
     * @return   존재 true  , 미존재 false
	 * @throws DAOException
	 */
    
    @SuppressWarnings("unchecked")
     public boolean searchMdmCurrency (String currCd) throws DAOException {
    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//통화
			param.put("curr_cd", currCd);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchMdmCurrencyRSQL(),
							param, velParam);

			if (dbRowset.getRowCount() > 0) {
				return true;
			}

			return false;
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         

     }     
    
    /**
	 * 입력된 Currency Code가 유효한 Code 인지 체크  <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category searchGaeCurrency
	 * 
	 * @param year 해당년도
     * @param currCd 통화코드
     * @return   존재 true  , 미존재 false
	 * @throws DAOException
	 */
    
    @SuppressWarnings("unchecked")
     public boolean searchGaeCurrency(String year, String currCd) throws DAOException {
    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	//계획환율년
        	param.put("acct_xch_rt_yrmon", year);        	
        	//통화
			param.put("curr_cd", currCd);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchGemCurrencyRSQL(),
							param, velParam);

			if (dbRowset.getRowCount() > 0) {
				return true;
			}

			return false;
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         

     }         
    
    // ---------------------------------------------------------------------------
    // [CPS_GEM_0111] Monthly Accounting Rate Interface
    // ---------------------------------------------------------------------------
    
    
    /**
	 * 일반관리비 비용실적 집계시 USD , KRW , LCL 로 환산하기 위한 경리환율을 I/F 받아 생성한다 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0111
	 * @category addExchangeRateInterface
	 * 
     * @param month 환율 년월
     * @param userId 사용자 ID
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
     public void addExchangeRateInterface (String month , String userId) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.put("acct_xch_rt_yrmon", month.substring(0,4));
	        param.put("cre_usr_id", userId);	      
	        //입력
			sqlExe.executeUpdate((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddExchangeRateInterfaceCSQL() , param, null);
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
     }      
       
    /**
	 * 일반관리비 비용실적 집계시 USD , KRW , LCL 로 환산하기 위한 경리환율을 I/F 받아 생성한다 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0111
	 * @category removeExchangeRateInterface
	 * 
     * @param month 환율 년월
     * @param userId 사용자 ID
     * @return int
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
     public int removeExchangeRateInterface (String month , String userId) throws DAOException {
    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.put("acct_xch_rt_yrmon", month.substring(0,4));
	        param.put("cre_usr_id", userId);
	        //삭제 
	        insCnt = sqlExe.executeUpdate((ISQLTemplate) new GEMMasterCodeMgtDBDAORemoveExchangeRateInterfaceDSQL() , param, null);
	        
	        return insCnt;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
     }          
    
    
    // ---------------------------------------------------------------------------
    // [CPS_GEM-0007] Expense Code Maintenance
    // ---------------------------------------------------------------------------        

    
    /**
	 * 일반관리비 비용주관팀으로 정의된 조직코드(Office Code) 정보<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseTICList
     * @return 비용주관팀으로 정의된 조직코드 리스트
     * @throws DAOException
     */
    public String[] searchExpenseTICList() throws DAOException    {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchExpenseTICListRSQL(),
							param, velParam);
			
			return GemUtil.getArrayString(dbRowset, 1);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         

    }    
    
    /**
	 * 일반관리비 비용코드 기준 정보<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseInfo
     * @param genExpnCd  비용코드
     * @param deltFlg  삭제요부
     * @return 비용코드 기준 정보 리스트
     * @throws DAOException
     */
    public GemExpenseVO searchExpenseInfo (String genExpnCd , String deltFlg ) throws DAOException    {
    
        DBRowSet dbRowset = null;
        
        List<GemExpenseVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//비용코드
        	param.put("gen_expn_cd", genExpnCd);
        	//삭제 여부
        	param.put("delt_flg", deltFlg);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchExpenseInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

    }
    
    
    /**
	 * 회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAccountInfo
	 * 
     * @param String genExpnCd  비용코드
     * @param String deltFlg  삭제요부
     * @return List<GemAcctMtxVO>
     * @throws DAOException
     */
    public List<GemAcctMtxVO> searchAccountInfo (String genExpnCd , String deltFlg )  throws DAOException   {
    
        DBRowSet dbRowset = null;
        
        List<GemAcctMtxVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//비용코드
        	param.put("gen_expn_cd", genExpnCd);
        	//삭제 여부
        	param.put("delt_flg", deltFlg);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchAccountInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemAcctMtxVO.class);
            
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }    
    
    
    /**
	 * 비용실적에 대한 재분배를 위한 예외사항 정보<br>
	 * ( 특정조직(SELTDA) 에서 회계코드(Account Code)의 실적을 발생시킬때, 매핑된 일반관리비 비용코드(Expense Code)로 집계하지않고,<br> 
     * 정의된 비용코드(Expense Code)로 집계 ) <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchDividedOfficeInfo
	 * 
     * @param String genExpnCd  비용코드
     * @param String deltFlg  삭제요부
     * @return List<GemAcctExptVO>
     * @throws DAOException
     */
    public List<GemAcctExptVO> searchDividedOfficeInfo(String genExpnCd,
			String deltFlg) throws DAOException {
    
        DBRowSet dbRowset = null;
        
        List<GemAcctExptVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//비용코드
        	param.put("gen_expn_cd", genExpnCd);
        	//삭제 여부
        	param.put("delt_flg", deltFlg);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchDividedOfficeInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemAcctExptVO.class);
            
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }      
    
    
    /**
     * 비용코드 존재 여부 체크
     * 비용코드 미존재(신규)  == 0
	 * 삭제 비용코드 존재 == > 1
	 * 사용중 비용코드 존재 ==> 2 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseInfoCheck
	 * 
     * @param genExpnCd  비용코드
     * @return
     * @throws DAOException
     */
    public String searchExpenseInfoCheck(String genExpnCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//비용코드
        	param.put("gen_expn_cd", genExpnCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchExpenseInfoCheckRSQL(), param, velParam);
            
            if (dbRowset != null && dbRowset.next()) {
            	String delFlg = dbRowset.getString("DELT_FLG");
            	if ("N".equals(delFlg) ) {
            		return "2";
            	} else {
            		return "1";
            	}
            }
            
            return "0";
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }    
    	
    }       
    
  
    
    /**
	 * 일반관리비 비용코드 기준 정보 등록<br>
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category addExpenseInfo
	 * 
     * @param gemExpenseVO  비용코드정보
     * @throws DAOException
     */
    public void addExpenseInfo(GemExpenseVO gemExpenseVO) throws DAOException {
    
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");			
	        //query parameter
	        Map<String, String> param = gemExpenseVO.getColumnValues();
	        //삭제 
	        sqlExe.executeUpdate((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddExpenseInfoCSQL() , param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }        
    
    /**
	 * 일반관리비 비용코드 기준 정보 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category modifyExpenseInfo
	 * 
     * @param gemExpenseVO  비용코드정보
     * @throws DAOException
     */
    public void modifyExpenseInfo (GemExpenseVO gemExpenseVO )  throws DAOException   {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");			
	        //query parameter
	        Map<String, String> param = gemExpenseVO.getColumnValues();	       
	        sqlExe.executeUpdate((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyExpenseInfoUSQL() , param, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    
    }         
    
    /**
	 * 회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보 생성<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category addAccountInfo
	 * 
     * @param gemAcctMtxVOs  회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보
     * @throws DAOException
     */
    public void addAccountInfo (List<GemAcctMtxVO> gemAcctMtxVOs )  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemAcctMtxVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddAccountInfoCSQL(), gemAcctMtxVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }       
    
    /**
	 * 회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보 수정<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category modifyAccountInfo
	 * 
     * @param gemAcctMtxVOs  회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보
     * @throws DAOException
     */
    public void modifyAccountInfo (List<GemAcctMtxVO> gemAcctMtxVOs )  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemAcctMtxVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyAccountInfoUSQL(), gemAcctMtxVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }       

    
    /**
	 * 회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보 삭제<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category removeAccountInfo
	 * 
     * @param gemAcctMtxVOs  회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보
     * @throws DAOException
     */
    public void removeAccountInfo (List<GemAcctMtxVO> gemAcctMtxVOs )  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemAcctMtxVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAORemoveAccountInfoDSQL(), gemAcctMtxVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }       
    
    
    /**
	 * 비용실적에 대한 재분배를 위한 예외사항 정보등록 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category addDividedOfficeInfo
	 * 
     * @param gemAcctExptVOs  비용실적에 대한 재분배를 위한 예외사항 정보
     * @throws DAOException
     */
    public void addDividedOfficeInfo (List<GemAcctExptVO> gemAcctExptVOs )  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemAcctExptVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddDividedOfficeInfoCSQL(), gemAcctExptVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    
    }
    
    /**
	 * 비용실적에 대한 재분배를 위한 예외사항 정보수정 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category modifyDividedOfficeInfo
	 * 
     * @param gemAcctExptVOs  비용실적에 대한 재분배를 위한 예외사항 정보
     * @throws DAOException
     */
    public void modifyDividedOfficeInfo (List<GemAcctExptVO> gemAcctExptVOs )  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemAcctExptVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyDividedOfficeInfoUSQL(), gemAcctExptVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    
    }     
    
    /**
	 * 비용실적에 대한 재분배를 위한 예외사항 삭제 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category removeDividedOfficeInfo
	 * 
     * @param gemAcctExptVOs  비용실적에 대한 재분배를 위한 예외사항 정보
     * @throws DAOException
     */
    public void removeDividedOfficeInfo(List<GemAcctExptVO> gemAcctExptVOs )  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (gemAcctExptVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAORemoveDividedOfficeInfoDSQL(), gemAcctExptVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }     
    
    /**
     * 회계코드(Account Code)가 사용되는 코드인지를 체크하고, 영문약어명과 한글약어명 조회
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAccountName
	 * 
     * @param acctCd  회계코드
     * @return
     * @throws DAOException
     */
    public MdmAccountVO searchAccountName (String acctCd )  throws DAOException   {
        DBRowSet dbRowset = null;
        
        List<MdmAccountVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//계정코드
        	param.put("acct_cd", acctCd);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchAccountNameRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmAccountVO.class);

            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }      
    
    
    /**
     * 일반관리비 비용코드의 Group Level[1st, 2nd, 3rd, Final]에 해당하는 Parent Code 리스트 조회<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseParentList
	 * 
     * @param genExpnGrpLvl  Parent Code(Expense Code) 리스트
     * @return Parent Code(Expense Code) 리스트
     * @throws DAOException
     */
    public List<GemExpenseVO> searchExpenseParentList(String genExpnGrpLvl)
			throws DAOException {
    
        DBRowSet dbRowset = null;
        List<GemExpenseVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//그룹레벨
        	param.put("gen_expn_grp_lvl", genExpnGrpLvl);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchExpenseParentListRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);
            return list;            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

    }    
    
    /**
     * 일반관리비 비용코드(Expense Code) 의 한글약어명, 영문약어명, 비용주관팀을 조회한다<br> 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseName
	 * 
     * @param genExpnCd  일반관리비 비용코드(Expense Code)
     * @return ExpenseNameVO 
     * @throws DAOException
     */
    public ExpenseNameVO searchExpenseName(String genExpnCd)  throws DAOException   {
        DBRowSet dbRowset = null;
        
        List<ExpenseNameVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//비용코드
        	param.put("gen_expn_cd", genExpnCd);        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchExpenseNameRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExpenseNameVO.class);

            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }       
    


    /**
     * 계정코드 존재 여부 체크
     * 계정코드 미존재(신규)  == 0
     * 삭제 계정코드 존재 == > 1
	 * 사용중 계정코드 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAcctCheck
     * @param acctCd 계정코드 
     * @return
     * @throws DAOException
     */
    public String[] searchAcctCheck(String acctCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        String[] codes = new String[2];
        
        try{    
        	//계정코드
        	param.put("acct_cd", acctCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchAcctCheckRSQL(), param, velParam);
            
            if (dbRowset != null && dbRowset.next()) {
            	String delFlg = dbRowset.getString("delt_flg");
            	String genExpnCd = dbRowset.getString("gen_expn_cd");
            	codes[1] = genExpnCd;
            	if ("N".equals(delFlg) ) {
            		codes[0] = "2";            		
            	} else {
            		codes[0] = "1";
            	}
            } else {
            	codes[0] = "0";
            	codes[1] = "";
            }
            
            return codes;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }    
    	
    }      
    
    
 
    
    /**
     * 오피스코드 존재 여부 체크
     * 오피스코드 미존재(신규)  == 0
     * 삭제 오피스코드 존재 == > 1
	 * 사용중 오피스코드 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAcctCheck
     * @param ofcCd 오피스코드 
     * @return 체크코드
     * @throws DAOException
     */
    public String searchOfcCheck(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	//오피스 코드
        	param.put("ofc_cd", ofcCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchOfcCheckRSQL(), param, velParam);
            
            if (dbRowset != null && dbRowset.next()) {
            	String delFlg = dbRowset.getString("DELT_FLG");
            	if ("N".equals(delFlg) ) {
            		return "2";
            	} else {
            		return "1";
            	}
            }
            
            return "0";
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }    
    	
    }          
    
    
    
     
    /**
     * 분리되어야 할 Budget Code 존재 여부 체크
     * 분리되어야 할 Budget Code 미존재(신규)  == 0
     * 삭제 분리되어야 할 Budget Code 존재 == > 1
	 * 사용중 분리되어야 할 Budget Code 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchGenExpnCheck 
     * @param String ofcCd
     * @param String genExpnCd
     * @param String acctCd
	 * @return String 체크코드
     * @throws DAOException
     */
    public String searchGenExpnCheck(String ofcCd, String genExpnCd, String acctCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    

        	//분리되어야 할 Budget Code 
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd", genExpnCd);
        	param.put("acct_cd", acctCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchGenExpnCheckRSQL(), param, velParam);
            
            if (dbRowset != null && dbRowset.next()) {
            	String delFlg = dbRowset.getString("DELT_FLG");
            	if ("N".equals(delFlg) ) {
            		return "2";
            	} else {
            		return "1";
            	}
            }
            
            return "0";
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }    
    	
    }              
    
	// C.J.M ===========================================================================
	
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0010] Expense Code Inquiry
	// ---------------------------------------------------------------------------
    /**
	 * 일반관리비 비용코드 조회
	 * 
	 * @author choijungmi
	 * @category searchExpenseList
	 * @return List<GemExpenseVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemExpenseVO> searchExpenseList() throws DAOException {
		DBRowSet dbRowset = null;
		List<GemExpenseVO> list = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchExpenseListRSQL(),null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);	
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}
	
	/**
	 * 일반관리비 회계계정코드 조회
	 * 
	 * @author choijungmi
	 * @category searchAccountList
	 * @return List<GemAcctMtxVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemAcctMtxVO> searchAccountList() throws DAOException {
		DBRowSet dbRowset = null;
		List<GemAcctMtxVO> list = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchAccountListRSQL(),null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemAcctMtxVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}
	
	/**
	 * 일반관리비 1st Group비용코드 조회
	 * 
	 * @author choijungmi
	 * @category searchExpenseList
	 * @return List<GemExpenseVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<GemExpenseVO> searchGroupListByExpense() throws DAOException {
		DBRowSet dbRowset = null;
		List<GemExpenseVO> list = null;
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchGroupListByExpenseRSQL(),null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemExpenseVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return list;
	}
	
    /**
	 * CPS_GEM_0010 Expense Code Inquiry 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010
	 * @category searchExpenseInq
	 * 
	 * @param ExpenseInqVO expenseInqVO
	 * @return List<ExpenseInquiryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExpenseInquiryVO> searchExpenseInq(ExpenseInqVO expenseInqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExpenseInquiryVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(expenseInqVO != null){
				 Map<String, String> mapVO = expenseInqVO.getColumnValues();			
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);				 
			 }

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOExpenseInquiryRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExpenseInquiryVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
		return list;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0011] Expense Office Inquiry
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0011의 SUMUP OFFICE코드 조회
	 * 
	 * @author choijungmi
	 * @category searchSumUpListByOffice
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchSumUpListByOffice() throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		try {
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchSumUpListByOfficeRSQL(),null, null);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0011 Expense Office Inquiry 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchOfficeInfo
	 * 
	 * @param OfficeMgtVO officeMgtVO
	 * @return List<GemOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GemOfficeVO> searchOfficeInfo(OfficeMgtVO officeMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GemOfficeVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(officeMgtVO != null){
				 
				 StringBuffer sb = new StringBuffer();
				 if(!officeMgtVO.getSchAppDivGbn().equals("") || officeMgtVO.getSchAppDivGbn() !=null) {					 
					 String arrAppDivGbn[] = officeMgtVO.getSchAppDivGbn().split(",");
					 int arrAppDivCnt = arrAppDivGbn.length - 1;
					 
					 if(arrAppDivGbn.length > 0) {						 
						 for (int i=0; i<arrAppDivGbn.length; i++) {
							 //log.info("##### arrAppDivGbn["+i+"] : "+arrAppDivGbn[i]);
							 if(!arrAppDivGbn[i].equals("null")) {
								 if(arrAppDivGbn[i].equals("0")) {
									 sb.append(" AND RQST_AUTH_FLG = 'Y' ");
									 sb.append(" AND RHQ_AUTH_FLG = 'Y' ");
									 sb.append(" AND TIC_AUTH_FLG  = 'Y' ");
									 sb.append(" AND CMIT_AUTH_FLG = 'Y' ");
									 
								 } else {
									 if(i==0) {
										 sb.append(" AND ");
										 if(arrAppDivGbn[i].equals("1")) sb.append(" RQST_AUTH_FLG = 'Y' ");
										 else if(arrAppDivGbn[i].equals("2")) sb.append(" RHQ_AUTH_FLG = 'Y' ");
										 else if(arrAppDivGbn[i].equals("3")) sb.append(" TIC_AUTH_FLG  = 'Y' ");
										 else if(arrAppDivGbn[i].equals("4")) sb.append(" CMIT_AUTH_FLG = 'Y' ");
										 
									 } else {
										 if(arrAppDivGbn[i].equals("1")) sb.append(" AND RQST_AUTH_FLG = 'Y' ");
										 else if(arrAppDivGbn[i].equals("2")) sb.append(" AND RHQ_AUTH_FLG = 'Y' ");
										 else if(arrAppDivGbn[i].equals("3")) sb.append(" AND TIC_AUTH_FLG = 'Y' ");
										 else if(arrAppDivGbn[i].equals("4")) sb.append(" AND CMIT_AUTH_FLG = 'Y' ");
									 }
									 if(i==arrAppDivCnt) {
										 sb.append("");
									 } 
								 }
							 }
						 }					 
					 }
				 }
				 //log.info("##### sb.toString() : "+sb.toString());
				 officeMgtVO.setStrAppDivSql(sb.toString());
				 
				 Map<String, String> mapVO = officeMgtVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);				 
				 
				 //log.info("##### param.toString() : "+param.toString());
				 //log.info("##### velParam.toString() : "+velParam.toString());				 
			 }

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchOfficeInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemOfficeVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
		return list;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0012] Foreign Exchange Rate Inquiry
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0012의 Open시 Currency Code 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0012
	 * @category searchCurrencyList
	 * 
	 * @param String year
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchCurrencyList(String year) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
	    	param.put("year", year);			 
			velParam.put("year", year);
			
			//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchCurrencyListRSQL(), param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0012의 Open시 USD Rate 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0012
	 * @category searchUsdRate
	 * 
	 * @param String year
	 * @return String
	 * @throws DAOException
	 */
	public String searchUsdRate(String year) throws DAOException {
		DBRowSet dbRowset = null;
		String returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			param.put("year", year);			 
			velParam.put("year",year);
			
			//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchUsdRateRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnStr = dbRowset.getString("code");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0012 Expense Office Inquiry 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0012
	 * @category searchExchangeRateInq
	 * 
	 * @param String acctXchRtYrmon
	 * @param String currCd
	 * @return List<GemXchRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<XchRtInqVO> searchExchangeRateInq(String acctXchRtYrmon, String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<XchRtInqVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( currCd != null && !currCd.equals("")) {
        		String[] str = currCd.split("\\,");
        		currCd = GemUtil.getInSqlChar(str);
        	}
			
			param.put("year", acctXchRtYrmon);
			param.put("curr_cd", currCd);
			 
			velParam.put("year",acctXchRtYrmon);
			velParam.put("curr_cd", currCd);
			 
			//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());				 

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchExchangeRateInqRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, XchRtInqVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
		return list;
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0013] Expense Matrix per Office
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0013 Expense Matrix per Office 조회(Office)
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchOfficeExpenseMatrixListByOffice
	 * 
	 * @param OfficeMgtVO officeMgtVO
	 * @return List<GemOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeInfoVO> searchOfficeExpenseMatrixListByOffice(OfficeMgtVO officeMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(officeMgtVO != null) {
				Map<String, String> mapVO = officeMgtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				 
				 
				//log.info("##### param.toString() : "+param.toString());
				//log.info("##### velParam.toString() : "+velParam.toString());				 
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByOfficeRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeInfoVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
		return list;
	}
	
	/**
	 * CPS_GEM_0013 Expense Matrix per Office 조회(Expense)
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchOfficeExpenseMatrixLIstByExpense
	 * 
	 * @param officeMgtVO
	 * @return List<GemOfficeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeInfoVO> searchOfficeExpenseMatrixListByExpense(OfficeMgtVO officeMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeInfoVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(officeMgtVO != null) {
				Map<String, String> mapVO = officeMgtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			 
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchOfficeExpenseMatrixListByExpenseRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeInfoVO.class);
		
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
        
		return list;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_01] Expense Office Maintenance - Office Code
	// ---------------------------------------------------------------------------
    
	/**
	 * CPS_GEM_0008_01 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_01
	 * @category modifyOfficeInformation
	 * 
	 * @param modifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifyOfficeInformation(List<GemOfficeVO> modifyVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyOfficeInformationUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
    /**
	 * CPS_GEM_0008_01 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_01
	 * @category removeOfficeInformation
	 * 
	 * @param removeVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void removeOfficeInformation (List<GemOfficeVO> removeVoList)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (removeVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAORemoveOfficeInformationUSQL(), removeVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0109] Office code history
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0109 Office code history
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category searchOfficeHistoryInfo
	 * 
	 * @param ofcCd
	 * @return List<GemOfcHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GemOfcHisVO> searchOfficeHistoryInfo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<GemOfcHisVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);			
			velParam.put("ofc_cd", ofcCd);
				 
			//log.info("##### param.toString() : "+param.toString());
			//log.info("##### velParam.toString() : "+velParam.toString());				 
	 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchOfficeHistoryInfoRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemOfcHisVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		return list;
	}
	
	/**
	 * CPS_GEM_0109 Office code history의 Ofc_Code에 해당하는 Ctr_Code 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category searchOfficeHistoryInfoByCtrCode
	 * 
	 * @param ofcCd
	 * @return List<GemOfcHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOfficeHistoryInfoByCtrCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnStr = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);			
			velParam.put("ofc_cd", ofcCd);
	 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchOfficeHistoryInfoByCtrCodeRSQL(),param, velParam);
			if(dbRowset.getRowCount() > 0) {
				while(dbRowset.next()) {
					returnStr = dbRowset.getString("code");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0109 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category addOfficeHistoryInfo
	 * 
	 * @param addVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
	public void addOfficeHistoryInfo(List<GemOfcHisVO> addVoList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (addVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddOfficeHistoryInfoCSQL(), addVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
	}
		
	/**
	 * CPS_GEM_0109 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category modifyOfficeHistoryInfo
	 * 
	 * @param modifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifyOfficeHistoryInfo (List<GemOfcHisVO> modifyVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyOfficeHistoryInfoUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    } 
	
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0008_02] Expense Office Maintenance - Expense Matrix per Office
	// ---------------------------------------------------------------------------
    
    /**
     * Expense Code 사용여부를 체크
 	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category searchExpenseCheck 
	 * @param schGbn
     * @param ofcCd
     * @param genExpnCd 
     * @return resultStr
     * @throws DAOException
     */
    public String searchExpenseCheck (String schGbn, String ofcCd, String genExpnCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        String resultStr = "";
        try{    
        	// query parameter
        	param.put("sch_gbn", schGbn);
        	param.put("ofc_cd", ofcCd);
        	param.put("gen_expn_cd", genExpnCd);
        	
        	velParam.put("sch_gbn", schGbn);
        	velParam.put("ofc_cd", ofcCd);
        	velParam.put("gen_expn_cd", genExpnCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMMasterCodeMgtDBDAOSearchExpenseCheckRSQL(), param, velParam);
            
            if (dbRowset != null && dbRowset.next()) {
            	resultStr = dbRowset.getString("code");
            } else {
            	resultStr = "FALSE";
            }
            
            return resultStr;
            
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }   	
    }    
    
    /**
	 * CPS_GEM_0008_02 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category addOfficeExpenseMatrix
	 * 
	 * @param addVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
	public void addOfficeExpenseMatrix(List<OfficeInfoVO> addVoList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (addVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddOfficeExpenseMatrixCSQL(), addVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
	}
		
	/**
	 * CPS_GEM_0008_02 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category modifyOfficeExpenseMatrix
	 * 
	 * @param modifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifyOfficeExpenseMatrix(List<OfficeInfoVO> modifyVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyOfficeExpenseMatrixUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0110] Expense Matrix Copy
	// ---------------------------------------------------------------------------
        
	/**
	 * CPS_GEM_0110 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0110
	 * @category addInitialCopy
	 * 
	 * @param String toOfc
	 * @param String userId
	 * @return int
	 * @throws DAOException
	 */
	public int addInitialCopy(String toOfc, String userId) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.put("to_ofc_cd", toOfc);
	        param.put("cre_usr_id", userId);
	        param.put("upd_usr_id", userId);
	        
	        //입력
	        insCnt = sqlExe.executeUpdate((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddInitialCopyCSQL() , param, null);
	        return insCnt;
					
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
	}
	
	/**
	 * CPS_GEM_0110 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0110
	 * @category addExpenseCopy 
	 * @param String fmOfc
	 * @param String toOfc
	 * @param String userId
	 * @return int
	 * @throws DAOException
	 */
	public int addExpenseCopy(String fmOfc, String toOfc, String userId) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.put("from_ofc_cd", fmOfc);
	        param.put("to_ofc_cd", toOfc);
	        param.put("cre_usr_id", userId);
	        param.put("upd_usr_id", userId);
	        
	        // Insert
	        insCnt = sqlExe.executeUpdate((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddExpenseCopyCSQL() , param, null);
	        return insCnt;
		
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_03] Expense Office Maintenance - Office Matrix per Office
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0008_03의 FROM OFFICE코드 조회
	 * 
	 * @author choijungmi
	 * @category searchFromOffice
	 * 
	 * @param String rgnOfcFlg
	 * @param String deltFlg
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchFromOffice(String rgnOfcFlg, String deltFlg) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("delt_flg", deltFlg);
			
			velParam.put("rgn_ofc_flg", rgnOfcFlg);
			velParam.put("delt_flg", deltFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchFromOfficeRSQL(), param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }		
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0008_03의 TO OFFICE코드 조회
	 * 
	 * @author choijungmi
	 * @category searchToOffice
	 * 
	 * @param String rgnOfcFlg
	 * @param String deltFlg
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchToOffice(String rgnOfcFlg, String deltFlg) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnStr = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			param.put("rgn_ofc_flg", rgnOfcFlg);
			param.put("delt_flg", deltFlg);
			
			velParam.put("rgn_ofc_flg", rgnOfcFlg);
			velParam.put("delt_flg", deltFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchToOfficeRSQL(), param, velParam);
			returnStr = GemUtil.getArrayString(dbRowset, "code");
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }		
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0008_03 Expense Office Maintenance - Office Matrix per Office 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchOfficeMatrixListByOffice
	 * 
	 * @param OfficeMgtVO officeMgtVO
	 * @return List<OfficeExptVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeExptVO> searchOfficeMatrixListByOffice(OfficeMgtVO officeMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeExptVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(officeMgtVO != null) {
				Map<String, String> mapVO = officeMgtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			 
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchOfficeMatrixListByOfficeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeExptVO.class);
		
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		return list;
	}
	
	/**
	 * CPS_GEM_0008_03의 From ~ To Office Code선택시 해당범위안의 Expense Code를 조회
	 * 
	 * @author choijungmi
	 * @category searchExptListByExpense
	 * 
	 * @param String gubun
	 * @param String sndOfcCd
	 * @param String rcvOfcCd
	 * @return List<GemExpenseVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<ExpenseNameVO> searchExptListByExpense(String gubun, String sndOfcCd , String rcvOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExpenseNameVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			param.put("gubun", gubun);
			param.put("snd_ofc_cd", sndOfcCd);
			param.put("rcv_ofc_cd", rcvOfcCd);
			
			velParam.put("gubun", gubun);
			velParam.put("snd_ofc_cd", sndOfcCd);
			velParam.put("rcv_ofc_cd", rcvOfcCd);
			
			//log.info("##### param : "+param.toString());
			//log.info("##### velParam : "+velParam.toString());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchExptListByExpenseRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ExpenseNameVO.class);
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }		
		return list;
	}
    
    /**
     * GEM_OFC_EXPT Table에 입력값을 중복 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category searchExptListByDupCheck
	 * 
	 * @param String sndOfcCd
     * @param String rcvOfcCd
     * @param String genExpnCd
	 * @return boolean
	 * @exception EventException
	 */
    public boolean searchExptListByDupCheck(String sndOfcCd , String rcvOfcCd, String genExpnCd) throws DAOException {
    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	//계획환율년
        	param.put("snd_ofc_cd", sndOfcCd);
        	param.put("rcv_ofc_cd", rcvOfcCd);
        	param.put("gen_expn_cd", genExpnCd);
        	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchExptListByDupCheckRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				return true;
			}
			return false;
           
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
	/**
	 * CPS_GEM_0008_03 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category addOfficeMatrixListByOffice
	 * 
	 * @param List<OfficeExptVO> addVoList
	 * @throws DAOException
	 */
	public void addOfficeMatrixListByOffice(List<OfficeExptVO> addVoList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (addVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddOfficeMatrixListByOfficeCSQL(), addVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
	}
		
	/**
	 * CPS_GEM_0008_03 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category modifyOfficeMatrixListByOffice
	 * 
	 * @param List<OfficeExptVO> modifyVoList
	 * @throws DAOException
	 */
    public void modifyOfficeMatrixListByOffice(List<OfficeExptVO> modifyVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyOfficeMatrixListByOfficeUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_9999] Log in Office Change Management
	// ---------------------------------------------------------------------------

    /**
	 * CPS_GEM_9999 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category searchLogInOfficeChange
	 * 
	 * @param OfficeMgtVO officeMgtVO
	 * @return List<GemCngOfcVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GemCngOfcVO> searchLogInOfficeChange(OfficeMgtVO officeMgtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GemCngOfcVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(officeMgtVO != null) {
				Map<String, String> mapVO = officeMgtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			 
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GemCngOfcVO.class);
		
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
		return list;
	}
	
	/**
     * GEM_OFFICE Table에 OFC_CD 존재여부를 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChangeByDupCheck
	 * 
	 * @param String gubun
     * @param String ofcCd
	 * @return boolean
	 * @exception EventException
	 */
    public boolean searchLogInOfficeChangeByDupCheck(String gubun, String ofcCd) throws DAOException {
    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	param.put("gubun", gubun);
        	param.put("ofc_cd", ofcCd);
        	
        	velParam.put("gubun", gubun);
        	velParam.put("ofc_cd", ofcCd);
        	        	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeByDupCheckRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				return true;
			}
			return false;           
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
    /**
     * GEM_CNG_OFC Table에 OFC_CD, CNG_OFC_CD를 중복 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChangeByOfcCdDupCheck
	 * 
	 * @param String ofcCd
     * @param String cngOfcCd
	 * @return boolean 결과값 1 신규  2, 중복
	 * @exception EventException
	 */
    public boolean searchLogInOfficeChangeByOfcCdDupCheck(String ofcCd, String cngOfcCd) throws DAOException {
    	  
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {    
        	param.put("ofc_cd", ofcCd);
        	param.put("cng_ofc_cd", cngOfcCd);
        	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeByOfcCdDupCheckRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				return true;
			}
			return false;           
        } catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
    /**
	 * CPS_GEM_9999 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category addLogInOfficeChange
	 * 
	 * @param List<GemCngOfcVO> addVoList
	 * @throws DAOException
	 */
	public void addLogInOfficeChange(List<GemCngOfcVO> addVoList) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (addVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOAddLogInOfficeChangeCSQL(), addVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
	}
		
	/**
	 * CPS_GEM_9999 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category modifyLogInOfficeChange
	 * 
	 * @param modifyVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void modifyLogInOfficeChange(List<GemCngOfcVO> modifyVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAOModifyLogInOfficeChangeUSQL(), modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
    
    /**
	 * CPS_GEM_9999 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category removeLogInOfficeChange
	 * 
	 * @param deleteVoList
	 *            데이터객체 배열
	 * @throws DAOException
	 */
    public void removeLogInOfficeChange(List<GemCngOfcVO> deleteVoList) throws DAOException {    	  
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMMasterCodeMgtDBDAODeleteLogInOfficeChangeUSQL(), deleteVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}			
		} catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        } catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler("COM10001",new String[]{}).getMessage());
        }
    }
}

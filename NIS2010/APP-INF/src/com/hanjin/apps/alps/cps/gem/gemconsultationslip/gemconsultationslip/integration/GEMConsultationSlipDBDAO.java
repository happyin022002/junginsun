/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAO.java
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.basic.GEMConsultationSlipBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulDtlVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsrHisVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrRequestHeaderVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrRequestBodyVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemCsrInfoVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemConsultationVO;


/**
 * ALPS GEMConsultationSlipDBDAO <br>
 * - ALPS-GEMConsultationSlip system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see GEMConsultationSlipBCImpl 참조
 * @since J2EE 1.6
 */
public class GEMConsultationSlipDBDAO extends DBDAOSupport {

	 /**
     * office 별 Currency Code 조회
     * @param SerachConsultaionVO serachConsultaionVO     
     * @return List<SerachConsultaionVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SerachConsultaionVO> searchCurrencyCode(SerachConsultaionVO serachConsultaionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SerachConsultaionVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO =  serachConsultaionVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchCurrencyCodeRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SerachConsultaionVO.class);
            
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
     * office 별 expense Code 조회
     * @param SerachConsultaionVO serachConsultaionVO     
     * @return List<SerachConsultaionVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SerachConsultaionVO> searchExpenseCodeOffice(SerachConsultaionVO serachConsultaionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SerachConsultaionVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO =  serachConsultaionVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchExpenseCodeOfficeRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SerachConsultaionVO.class);
            
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
	 * groupware user id 조회<br>
	 *
	 * @param String usrId
	 * @return String 
     * @throws DAOException
     */
    public String searchGwUserId(String usrId) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{

        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("usr_id", usrId);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchGwUserIdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String epId = dbRowset.getString(1);            	 
            	return epId;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
       
    } 
    

    /**
	 * 로그인 사용자의 로컬 DATE취득  YYYYMMDD  형식 
     * @param String usrOfcCd  로그인 ofc_cd
     * @return String YYYYMMDD  형식
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchLocalDate(String usrOfcCd) throws DAOException {
			
        DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
        	param.put("usr_ofc_cd",usrOfcCd );        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchLocalDateRSQL(), param, velParam);            
            if (dbRowset.next()) {
            	return dbRowset.getString("LCL_DT");
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
     * 비용계획 요청시 비용코드의 MAX(Item) 
     * @param String genExpnRqstTpCd 예산구분 (EA,EI,ET,CR)
     * @param String rqstOfcCd 요청부서
     * @return String null --> maxRqstNo 미존재  , maxRqstNo
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchMaxRqstNo(String genExpnRqstTpCd, String rqstOfcCd) throws DAOException {
        
    	DBRowSet dbRowset = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("gen_expn_rqst_tp_cd", genExpnRqstTpCd);
        	param.put("rqst_ofc_cd", rqstOfcCd);
        	        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchMaxRqstNoRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	String maxRqstNo = dbRowset.getString(1);            	
            	return maxRqstNo;
            	 
            } else {
            	return null;
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
	 * csr NO 생성 <br>
     * @param GemRequestVO gemRequestVO
     * @throws DAOException
     */
    public void addCSRRequest (GemRequestVO gemRequestVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = gemRequestVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new GEMConsultationSlipDBDAOAddCSRRequesCSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }

    /**
   	 * CSR NO 생성 후 Update<br>
   	 * 
     * @param GemRequestVO gemRequestVO  
     * @throws DAOException
     */
  public void modifyCSRRequest (GemRequestVO gemRequestVO)  throws DAOException   {
 	try {
 		SQLExecuter sqlExe = new SQLExecuter("");
 		Map<String, Object> velParam = new HashMap<String, Object>();			
 		Map<String , String> paramMap = gemRequestVO.getColumnValues();
 		velParam.putAll(paramMap);
 		sqlExe.executeUpdate((ISQLTemplate) new GEMConsultationSlipDBDAOModifyCSRRequestUSQL(), paramMap, velParam);			
   	} catch (SQLException se) {
    	log.error(se.getMessage(), se);
   		throw new DAOException(new ErrorHandler(se).getMessage());
   	} catch (Exception ex) {
   		log.error(ex.getMessage(), ex);
   		throw new DAOException(new ErrorHandler(ex).getMessage());
   	}

  }

  /**
   * 이미 저장되어 있는 CSR_NO가 있는지 확인을 한다.  
   * @param String csr_no
   * @return int
   * @throws DAOException
   */
  @SuppressWarnings("unchecked")
  public int searchSubsCsulHdrCount(String csr_no) throws DAOException {
      
  	DBRowSet dbRowset = null;        
  	int countHdr = 0;  
      //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
      
      //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

      try {
      	param.put("csr_no", csr_no);
      	        	
        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchSubsCsulHdrCountRSQL(), param, velParam);            
          
        if (dbRowset.next()) {
        	countHdr = dbRowset.getInt(1);            	
          	return countHdr;
          	 
          } else {
          	return countHdr;
          }
          
      }catch(SQLException se){
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
          log.error(ex.getMessage(),ex);
          throw new DAOException(new ErrorHandler(ex).getMessage());
      }
  }

  /**
   * 이미 저장되어 있는 CSR_NO가 있는지 확인을 한다.(DTL 테이블)  
   * @param String csr_no
   * @return int
   * @throws DAOException
   */
  @SuppressWarnings("unchecked")
  public int searchSubsCsulDtlCount(String csr_no) throws DAOException {
      
  	DBRowSet dbRowset = null;        
  	int countHdr = 0;  
      //query parameter
    Map<String, Object> param = new HashMap<String, Object>();
      
      //velocity parameter
    Map<String, Object> velParam = new HashMap<String, Object>();

      try {
      	param.put("csr_no", csr_no);
      	        	
        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchSubsCsulDtlCountRSQL(), param, velParam);            
          
        if (dbRowset.next()) {
        	countHdr = dbRowset.getInt(1);            	
          	return countHdr;
          	 
          } else {
          	return countHdr;
          }
          
      }catch(SQLException se){
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
          log.error(ex.getMessage(),ex);
          throw new DAOException(new ErrorHandler(ex).getMessage());
      }
  }
   /**
	 * GEM_SUBS_CSUL_HDR 테이블 데이터 생성<br>
	 * 
     * @param GemSubsCsulHdrVO gemSubsCsulHdrVO  
     * @throws DAOException
     */
    public void addSubsCsulHdr (GemSubsCsulHdrVO gemSubsCsulHdrVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = gemSubsCsulHdrVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new GEMConsultationSlipDBDAOAddSubsCsulHdrCSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }

    /**
	 * GEM_SUBS_CSUL_HDR 테이블 데이터 Update<br>
	 * 
     * @param GemSubsCsulHdrVO gemSubsCsulHdrVO  
     * @throws DAOException
     */
    public void modifySubsCsulHdrVO (GemSubsCsulHdrVO gemSubsCsulHdrVO)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = gemSubsCsulHdrVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new GEMConsultationSlipDBDAOModifySubsCsulHdrUSQL(), paramMap, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }
    /**
	 * GEM_SUBS_CSUL_DTL 테이블 데이터 삭제를 한다.<br>
	 * 
     * @param String csr_no  
     * @throws DAOException
     */
    public void removeSubsCsulDtl (String csr_no)  throws DAOException   {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
		    Map<String, Object> param = new HashMap<String, Object>();
		      //velocity parameter
		    Map<String, Object> velParam = new HashMap<String, Object>();
		   
		    param.put("csr_no", csr_no);
		    
			sqlExe.executeUpdate((ISQLTemplate) new GEMConsultationSlipDBDAORemoveSubsCsulDtlDSQL(), param, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

    }
   
    /**
    * GEM_SUBS_CSUL_DTL 테이블를 insert를 한다. <br>
    * @param List<GemSubsCsulDtlVO> insertVoList  
    * @throws DAOException
    */
     public void addSubsCsulDtl (List<GemSubsCsulDtlVO> insertVoList)  throws DAOException   {
    try {
    	SQLExecuter sqlExe = new SQLExecuter("");
    	int insCnt[] = null;
    	if (insertVoList.size() > 0) {
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		insCnt = sqlExe.executeBatch((ISQLTemplate) new GEMConsultationSlipDBDAOAddSubsCsulDtlCSQL(), insertVoList, velParam);
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
      * detail 테이블의 정보를 조회를 해온다.
      * @param GemSubsCsulHdrVO gemSubsCsulHdrVO    
      * @return List<GemSubsCsulDtlVO>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<GemSubsCsulDtlVO> searchConsultaionDetail(GemSubsCsulHdrVO gemSubsCsulHdrVO) throws DAOException {
         DBRowSet dbRowset = null;
         
         List<GemSubsCsulDtlVO> list = null;
         
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try {
         	
         	Map<String, String> mapVO =  gemSubsCsulHdrVO.getColumnValues();
         	param.putAll(mapVO);
         	
         	velParam.putAll(mapVO);
         	
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchConsultaionDetailRSQL(), param, velParam);            
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemSubsCsulDtlVO.class);
             
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
 	 * History table insert<br>
 	 * 
 	 * @param GemSubsCsrHisVO gemSubsCsrHisVO
      * @throws DAOException
      */
     public void saveGWhisInfo(GemSubsCsrHisVO gemSubsCsrHisVO) throws DAOException {        
     	// query parameter
         Map<String, String> param = new HashMap<String, String>();
         // velocity parameter
         Map<String, String> velParam = new HashMap<String, String>(); 
         
         int cnt = 0;
         
         try{
             if(gemSubsCsrHisVO != null){
 				Map<String, String> mapVO = gemSubsCsrHisVO.getColumnValues();
 				
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);			
 			}
             
         	cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GEMConsultationSlipDBDAOSaveGWhisInfoCSQL(), param, velParam);
                         
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
         }       
     }  

     /**
 	 * groupware 전송 xmlData Header info<br>
 	 * @param String csrNo
     * @return GemCsrRequestHeaderVO 
     * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public GemCsrRequestHeaderVO printGemCsrHeaderInfo(String csrNo) throws DAOException {
     	DBRowSet dbRowset = null;      
         List<GemCsrRequestHeaderVO> list = null;        
        
         try{    
         	// query parameter
             Map<String, Object> param = new HashMap<String, Object>();
             // velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
         	//  Cargo Claim No
         	param.put("csr_no", csrNo);
         	
         	// velocity parameter 설정 
             velParam.putAll(param);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOPrintGemCsrHeaderInfoRSQL(), param, velParam);           
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemCsrRequestHeaderVO.class);
             
             if (list != null && !list.isEmpty()) {
             	return list.get(0);
             }
             
             return null;
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
         }
     }

     /**
 	 * groupware 전송 xmlData Body info<br>
 	 * @param String csrNo
      * @return List<GemCsrRequestBodyVO>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<GemCsrRequestBodyVO> printGemCsrBodyInfo(String csrNo) throws DAOException {
     	DBRowSet dbRowset = null;     
         List<GemCsrRequestBodyVO> list = null;        
        
         try{    
         	// query parameter
             Map<String, Object> param = new HashMap<String, Object>();
             // velocity parameter
             Map<String, Object> velParam = new HashMap<String, Object>();
             
         	//  Cargo Claim No
         	param.put("csr_no", csrNo);        	
         	
         	// velocity parameter 설정 
             velParam.putAll(param);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOPrintGemCsrBodyInfoRSQL(), param, velParam);          
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemCsrRequestBodyVO.class);         
             
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
         }        
         return list;      
     }  
     /**
 	 * GW에서 결과 값 전송<br>
 	 * GEM_SUBS_CSUL_HDR 의  GW Url, Request_id 업데이트
 	 * @param csr_no
 	 * @param request_id
 	 * @param gw_url
 	 * @throws DAOException
 	 */
 	public void updateGemAproGwUrl(String csr_no, String request_id, String gw_url) throws DAOException {
 		log.debug("\n DAO.updateAproGwUrl --------------------------------------------------");
 		
 		Map<String, Object> mapVO 		= new HashMap<String, Object>();
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam 	= new HashMap<String, Object>();
 		
 		try {
 			mapVO.put("csr_no", csr_no);
 			mapVO.put("request_id", request_id);
 			mapVO.put("gw_url", gw_url);
 			
 			param.putAll(mapVO);
 			velParam.putAll(mapVO);

 			new SQLExecuter("").executeUpdate((ISQLTemplate)new GEMConsultationSlipDBDAOUpdateAproGwUrlRSQL(), param, velParam);

 		} catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch (DAOException de) {
 			log.error(de.getMessage(), de);
 			throw de;
 		} catch (Exception e) {
 			log.error(e.getMessage(), e);
 			throw new DAOException(e.getMessage());
 		}
 	}
 
 	/**
	 * CSR_NO로 OFC_CD 조회<br>
	 * 
	 * @param String csrNo
	 * @return String 
     * @throws DAOException
     */
    public String searchOfcCd(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchOfcCdRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String ofcCd = dbRowset.getString(1);            	 
            	return ofcCd;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }     
    }  

    /**
	 * CSR_No로 RQST_APRO_STEP_FLG 상태를 조회한다.<br>
	 *
	 * @param String csrNo
	 * @return String 
     * @throws DAOException
     */
    public String searchGemRqstAproStepFlg(String csrNo) throws DAOException {        
        DBRowSet dbRowset = null;
        
        try{
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, String> velParam = new HashMap<String, String>();            
        	// 조회조건
        	param.put("csr_no", csrNo);   	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchRqstAproStepFlgRSQL(), param, velParam);
            
            if (dbRowset.next()) {            	
            	String aproStepFlg = dbRowset.getString(1);            	 
            	return aproStepFlg;
            }
            
            return null;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }     
    }  
    /**
	 * GW에서 결과 값 전송 <br>
	 * GEM_SUBS_CSUL_HDR 의 GW Result 업데이트
	 * @param GemCsrInfoVO gemCsrInfoVO
	 * @throws DAOException
	 */
	public void updateGemAproGwDt(GemCsrInfoVO gemCsrInfoVO) throws DAOException {
		log.debug("\n DAO.updateGemAproGwDt --------------------------------------------------");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {

			if(gemCsrInfoVO != null){
				Map<String, String> mapVO = gemCsrInfoVO.getColumnValues();
				param.putAll(mapVO);	
				velParam.putAll(mapVO);
			}

			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GEMConsultationSlipDBDAOUpdateGemAproGwDtUSQL(), param, velParam);
			
			if(cnt == 0) {
				log.error("There is no updated data.");
				throw new DAOException("There is no updated data.");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			//throw de;
			throw new DAOException(new ErrorHandler(de).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	} 

	 /**
     * 0034화면의  정보조회
     * @param SerachConsultaionVO serachConsultaionVO     
     * @return List<GemConsultationVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemConsultationVO> searchConsultaionInquiry(SerachConsultaionVO serachConsultaionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemConsultationVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO =  serachConsultaionVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchConsultaionInquiryRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemConsultationVO.class);
            
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
     * 0036화면의  정보조회
     * @param SerachConsultaionVO serachConsultaionVO     
     * @return List<GemConsultationVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemSubsCsulHdrVO> searchCsrNoInquiry(SerachConsultaionVO serachConsultaionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemSubsCsulHdrVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO =  serachConsultaionVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchCsrNoInquiryRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset,GemSubsCsulHdrVO.class);
            
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
     * HDR정보 조회 테이블의 정보를 조회를 해온다.
     * @param GemSubsCsulHdrVO gemSubsCsulHdrVO    
     * @return List<GemSubsCsulDtlVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemSubsCsulHdrVO> searchConsultaionHdr(SerachConsultaionVO serachConsultaionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemSubsCsulHdrVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO =  serachConsultaionVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchConsultaionHdrRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemSubsCsulHdrVO.class);
            
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
     * 0035화면의  정보조회
     * @param SerachConsultaionVO serachConsultaionVO     
     * @return List<GemConsultationVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<GemConsultationVO> searchConsultaionInquiryDetail(SerachConsultaionVO serachConsultaionVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<GemConsultationVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	
        	Map<String, String> mapVO =  serachConsultaionVO.getColumnValues();
        	param.putAll(mapVO);
        	
        	velParam.putAll(mapVO);
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GEMConsultationSlipDBDAOSearchConsultaionInquiryDetailRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, GemConsultationVO.class);
            
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
     * 0033 화면에서 Delt_Flg = 'Y'로 변경을 한다..  
     * @param String csrNo
     * @param String usrId
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public int consultaionCancel(String csrNo ,String usrId) throws DAOException {
        
    	DBRowSet dbRowset = null;        
    	int cnt = 0;  
        //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	param.put("csr_no", csrNo);
        	param.put("usr_id", usrId);
        	velParam.put("csr_no", csrNo);
        	velParam.put("usr_id", usrId);
        	        	
        	cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new GEMConsultationSlipDBDAOConsultaionCancelUSQL(), param, velParam);
        	if(cnt == 0) {
				log.error("There is no updated data.");
				throw new DAOException("There is no updated data.");
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return cnt;
    }
}
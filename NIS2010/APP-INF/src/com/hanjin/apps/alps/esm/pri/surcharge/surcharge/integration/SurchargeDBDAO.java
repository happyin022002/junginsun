/*=========================================================                                                                              
*Copyright(c) 2009 CyberLogitec                                                                                                          
*@FileName : SurchargeDBDAO.java                                                                                                         
*@FileTitle : Surcharge Creation                                                                                                         
*Open Issues :                                                                                                                           
*Change history :                                                                                                                        
*@LastModifyDate : 2009.06.04                                                                                                            
*@LastModifier : 김재연                                                                                                                  
*@LastVersion : 1.0                                                                                                                      
* 2009.06.04 김재연                                                                                                                      
* 1.0 Creation                                                                                                                           
=========================================================                                                                                
* History                                                                                                                                
2012.03.07 서미진 [CHM-201216620] Surcharge Creation / Inquiry 에서 PSA 항목 추가          
* 2014.09.01 최성환 [CHM-201431588] Surcharge Inquiry 화면의 surcharge 개정 이력 관리 추가                                              
=========================================================*/                                                                              
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration;                                                                    
                                                                                                                                         
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.basic.SurchargeBCImpl;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgAuthVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
/**                                                                                                                                      
 * NIS2010 SurchargeDBDAO <br>                                                                                                           
 * - NIS2010-Surcharge system Business Logic을 처리하기 위한 JDBC 작업수행.<br>                                                          
 *                                                                                                                                       
 * @author JaeYeon Kim                                                                                                                   
 * @see SurchargeBCImpl 참조                                                                                                             
 * @since J2EE 1.6                                                                                                                       
 */                                                                                                                                      
public class SurchargeDBDAO extends DBDAOSupport {                                                                                       
                                                                                                                                         
	/**                                                                                                                              
	 * Percentage Base Code를 조회합니다. <br>                                                                                       
	 *                                                                                                                               
	 * @param PriScgPrfVO priScgPrfVO                                                                                                
	 * @return List<RsltCdListVO>                                                                                                    
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	 @SuppressWarnings("unchecked")                                                                                                  
	public List<RsltCdListVO> searchComboPctBseCdList(PriScgPrfVO priScgPrfVO) throws DAOException {                                 
		DBRowSet dbRowset = null;                                                                                                
		List<RsltCdListVO> list = null;                                                                                          
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
                                                                                                                                         
		try{                                                                                                                     
			if(priScgPrfVO != null){                                                                                         
				Map<String, String> mapVO = priScgPrfVO .getColumnValues();                                              
			                                                                                                                 
				param.putAll(mapVO);                                                                                     
				velParam.putAll(mapVO);                                                                                  
			}                                                                                                                
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgPctBseRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);                                              
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
	 * Surcharge Preferences 리스트를 조회합니다. <br>                                                                               
	 *                                                                                                                               
	 * @param PriScgPrfVO priScgPrfVO                                                                                                
	 * @return List<PriScgPrfVO>                                                                                                     
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	 @SuppressWarnings("unchecked")                                                                                                  
	public List<PriScgPrfVO> searchSurchargePreferences(PriScgPrfVO priScgPrfVO) throws DAOException {                               
		DBRowSet dbRowset = null;                                                                                                
		List<PriScgPrfVO> list = null;                                                                                           
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
                                                                                                                                         
		try{                                                                                                                     
			if(priScgPrfVO != null){                                                                                         
				Map<String, String> mapVO = priScgPrfVO .getColumnValues();                                              
			                                                                                                                 
				param.putAll(mapVO);                                                                                     
				velParam.putAll(mapVO);                                                                                  
			}                                                                                                                
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgPrfVORSQL(), param, velParam); 
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgPrfVO .class);                                               
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
	 * Surcharge Preferences를 생성합니다. <br>                                                                                      
	 *                                                                                                                               
	 * @param PriScgPrfVO priScgPrfVO                                                                                                
	 * @param SignOnUserAccount account                                                                                              
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	public void addSurchargePreferences(PriScgPrfVO priScgPrfVO,SignOnUserAccount account) throws DAOException,Exception {           
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		try {                                                                                                                    
			Map<String, String> mapVO = priScgPrfVO.getColumnValues();                                                       
			                                                                                                                 
			param.putAll(mapVO);                                                                                             
			velParam.putAll(mapVO);                                                                                          
			                                                                                                                 
			SQLExecuter sqlExe = new SQLExecuter("");                                                                        
			int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOPriScgPrfVOCSQL(), param, velParam);           
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
	 * Surcharge Preferences를 수정합니다. <br>                                                                                      
	 *                                                                                                                               
	 * @param PriScgPrfVO priScgPrfVO                                                                                                
	 * @return int                                                                                                                   
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	public int modifySurchargePreferences(PriScgPrfVO priScgPrfVO) throws DAOException,Exception {                                   
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		                                                                                                                         
		int result = 0;                                                                                                          
		try {                                                                                                                    
			Map<String, String> mapVO = priScgPrfVO.getColumnValues();                                                       
			                                                                                                                 
			param.putAll(mapVO);                                                                                             
			velParam.putAll(mapVO);                                                                                          
			                                                                                                                 
			SQLExecuter sqlExe = new SQLExecuter("");                                                                        
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOPriScgPrfVOUSQL(), param, velParam);               
			if(result == Statement.EXECUTE_FAILED)                                                                           
					throw new DAOException("Fail to insert SQL");                                                    
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
	 * Surcharge List를 조회합니다. <br>                                                                                             
	 *                                                                                                                               
	 * @param PriScgRtVO priScgRtVO                                                                                                  
	 * @return List<PriScgRtVO>                                                                                                      
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	@SuppressWarnings("unchecked")                                                                                                   
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO) throws DAOException {                                         
		DBRowSet dbRowset = null;                                                                                                
		List<PriScgRtVO> list = null;                                                                                            
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
                                                                                                                                         
		try{                                                                                                                     
			if(priScgRtVO != null){                                                                                          
				Map<String, String> mapVO = priScgRtVO .getColumnValues();                                               
				                                                                                                         
				param.putAll(mapVO);                                                                                     
				velParam.putAll(mapVO);                                                                                  
				                                                                                                         
				String sPrcCgoTpCd = priScgRtVO.getPrcCgoTpCd();                                                         
                                                                                                                                         
				if(!"".equals(JSPUtil.getNull(sPrcCgoTpCd))) {                                                           
					List<String> tempList = new ArrayList<String>();                                                 
					String[] temp = priScgRtVO.getPrcCgoTpCd().split(",");                                           
					for(int i=0; i<temp.length; i++) {                                                               
						tempList.add(temp[i]);                                                                   
					}                                                                                                
					tempList.add("NULL");                                                                            
					velParam.put("prc_cgo_tp_cd", tempList);                                                         
				}                                                                                                        
			}                                                                                                                
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgRtVORSQL(), param, velParam);  
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgRtVO .class);                                                
		}catch(SQLException se){                                                                                                 
			log.error(se.getMessage(),se);                                                                                   
			throw new DAOException(new ErrorHandler(se).getMessage());                                                       
		}catch(Exception ex){                                                                                                    
			log.error(ex.getMessage(),ex);                                                                                   
			throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
		}                                                                                                                        
		return list;                                                                                                             
	}                                                                                                                                
	                                                                                                                                 
//	public void addSurchargeRate(List<PriScgRtVO> priScgRtVO) throws DAOException,Exception {                                        
//	    try {                                                                                                                        
//	        SQLExecuter sqlExe = new SQLExecuter("");                                                                                
//	        int insCnt[] = null;                                                                                                     
//	        if(priScgRtVO.size() > 0){                                                                                               
//	            insCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgRtVOCSQL(), priScgRtVO,null);                     
//	            for(int i = 0; i < insCnt.length; i++){                                                                              
//	                if(insCnt[i]== Statement.EXECUTE_FAILED)                                                                         
//	                    throw new DAOException("Fail to insert No"+ i + " SQL");                                                     
//	            }                                                                                                                    
//	        }                                                                                                                        
//	    } catch (SQLException se) {                                                                                                  
//	        log.error(se.getMessage(),se);                                                                                           
//	        throw new DAOException(new ErrorHandler(se).getMessage());                                                               
//	    }catch(Exception ex){                                                                                                        
//	        log.error(ex.getMessage(),ex);                                                                                           
//	        throw new DAOException(new ErrorHandler(ex).getMessage());                                                               
//	    }                                                                                                                            
//	}                                                                                                                                
                                                                                                                                         
    /**                                                                                                                                  
     *  Surcharge를 생성합니다.<br>                                                                                                      
     *                                                                                                                                   
     * @param PriScgRtVO priScgRtVO                                                                                                      
     * @exception DAOException                                                                                                           
     */                                                                                                                                  
    public void addSurchargeRate(PriScgRtVO priScgRtVO) throws DAOException {                                                            
        // JDBC 버그로 인해 executeBatch 대신 executeUpdate 를 사용하게 수정                                                             
        //query parameter                                                                                                                
        Map<String, Object> param = new HashMap<String, Object>();                                                                       
        //velocity parameter                                                                                                             
        Map<String, Object> velParam = new HashMap<String, Object>();                                                                    
        try {                                                                                                                            
            Map<String, String> mapVO = priScgRtVO.getColumnValues();                                                                    
                                                                                                                                         
            param.putAll(mapVO);                                                                                                         
            velParam.putAll(mapVO);                                                                                                      
                                                                                                                                         
            SQLExecuter sqlExe = new SQLExecuter("");                                                                                    
            int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOPriScgRtVOCSQL(), param, velParam);                        
            if(result == Statement.EXECUTE_FAILED)                                                                                       
                    throw new DAOException("Fail to insert SQL");                                                                        
        } catch(SQLException se) {                                                                                                       
            throw new DAOException(new ErrorHandler(se).getMessage(), se);                                                               
        } catch(Exception ex) {                                                                                                          
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);                                                               
        }                                                                                                                                
    }                                                                                                                                    
            
    /**                                                                                                                                  
     *  Surcharge Request Rate를 생성합니다.<br>                                                                                                      
     *                                                                                                                                   
     * @param PriScgRtVO priScgRtVO                                                                                                      
     * @exception DAOException                                                                                                           
     */                                                                                                                                  
    public void addSurchargeRequestRate(PriScgRtVO priScgRtVO) throws DAOException {                                                            
        // JDBC 버그로 인해 executeBatch 대신 executeUpdate 를 사용하게 수정                                                             
        //query parameter                                                                                                                
        Map<String, Object> param = new HashMap<String, Object>();                                                                       
        //velocity parameter                                                                                                             
        Map<String, Object> velParam = new HashMap<String, Object>();                                                                    
        try {                                                                                                                            
            Map<String, String> mapVO = priScgRtVO.getColumnValues();                                                                    
                                                                                                                                         
            param.putAll(mapVO);                                                                                                         
            velParam.putAll(mapVO);                                                                                                      
                                                                                                                                         
            SQLExecuter sqlExe = new SQLExecuter("");                                                                                    
            int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOPriScgReqRtVOCSQL(), param, velParam);                        
            if(result == Statement.EXECUTE_FAILED)                                                                                       
                    throw new DAOException("Fail to insert SQL");                                                                        
        } catch(SQLException se) {                                                                                                       
            throw new DAOException(new ErrorHandler(se).getMessage(), se);                                                               
        } catch(Exception ex) {                                                                                                          
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);                                                               
        }                                                                                                                                
    }   
    
	/**                                                                                                                              
	 * Surcharge를 수정합니다. <br>                                                                                                  
	 *                                                                                                                               
	 * @param List<PriScgRtVO> priScgRtVOs                                                                                           
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	public void modifySurchargeRate(List<PriScgRtVO> priScgRtVOs) throws DAOException,Exception {                                    
		try {                                                                                                                    
			SQLExecuter sqlExe = new SQLExecuter("");                                                                        
			int updCnt[] = null;                                                                                             
			if(priScgRtVOs.size() > 0){                                                                                      
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgRtVOUSQL(), priScgRtVOs,null);        
				for(int i = 0; i < updCnt.length; i++){                                                                  
					if(updCnt[i]== Statement.EXECUTE_FAILED)                                                         
						throw new DAOException("Fail to update No"+ i + " SQL");                                 
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
	                                                                                                                                 
//	/**                                                                                                                              
//	 * 전체 Surcharge Rate를 Master의 값에 따라 설정합니다. <br>                                                                     
//	 *                                                                                                                               
//	 * @param PriScgPrfVO priScgPrfVO                                                                                                
//	 * @return int                                                                                                                   
//	 * @exception DAOException                                                                                                       
//	 */                                                                                                                              
//	public int modifySurchargeRate(PriScgPrfVO priScgPrfVO) throws DAOException,Exception {                                          
//		//query parameter                                                                                                        
//		Map<String, Object> param = new HashMap<String, Object>();                                                               
//		//velocity parameter                                                                                                     
//		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
//		                                                                                                                         
//		int result = 0;                                                                                                          
//		try {                                                                                                                    
//			Map<String, String> mapVO = priScgPrfVO.getColumnValues();                                                       
//			                                                                                                                 
//			param.putAll(mapVO);                                                                                             
//			velParam.putAll(mapVO);                                                                                          
//			                                                                                                                 
//			SQLExecuter sqlExe = new SQLExecuter("");                                                                        
//			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOAllPriScgRtVOUSQL(), param, velParam);             
//			if(result == Statement.EXECUTE_FAILED)                                                                           
//					throw new DAOException("Fail to insert SQL");                                                    
//		} catch (SQLException se) {                                                                                              
//			log.error(se.getMessage(),se);                                                                                   
//			throw new DAOException(new ErrorHandler(se).getMessage());                                                       
//		}catch(Exception ex){                                                                                                    
//			log.error(ex.getMessage(),ex);                                                                                   
//			throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
//		}                                                                                                                        
//		return result;                                                                                                           
//	}                                                                                                                                
	                                                                                                                                 
	/**                                                                                                                              
	 * Surcharge 중복을 확인합니다. <br>                                                                                             
	 *                                                                                                                               
	 * @param PriScgRtVO priScgRtVO                                                                                                  
	 * @return boolean                                                                                                               
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	public boolean searchSurchargeDuplicate(PriScgRtVO priScgRtVO)                                                                   
		throws DAOException {                                                                                                    
		DBRowSet dbRowset = null;                                                                                                
		// query parameter                                                                                                       
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		// velocity parameter                                                                                                    
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		boolean rtnVal = false;                                                                                                  
		                                                                                                                         
		try {                                                                                                                    
			if (priScgRtVO != null) {                                                                                        
				Map<String, String> mapVO = priScgRtVO.getColumnValues();                                                
		                                                                                                                         
				param.putAll(mapVO);                                                                                     
				velParam.putAll(mapVO);                                                                                  
			}                                                                                                                
			dbRowset = new SQLExecuter("").executeQuery(                                                                     
					(ISQLTemplate) new SurchargeDBDAOChkPriScgRtVORSQL(),                                            
					param, velParam);                                                                                
			                                                                                                                 
			if(dbRowset.next() && dbRowset.getInt("CNT") > 1) {                                                              
				log.debug("searchSurchargeDuplicate====cnt=="+dbRowset.getInt("CNT"));                                   
				rtnVal = true;                                                                                           
			}                                                                                                                
		                                                                                                                         
		} catch (SQLException se) {                                                                                              
			log.error(se.getMessage(), se);                                                                                  
			throw new DAOException(new ErrorHandler(se).getMessage());                                                       
		} catch (Exception ex) {                                                                                                 
			log.error(ex.getMessage(), ex);                                                                                  
			throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
		}                                                                                                                        
		return rtnVal;                                                                                                           
	}	                                                                                                                         
	                                                                                                                                 
//	/**                                                                                                                              
//	 * Surcharge 중복을 확인합니다. <br>                                                                                             
//	 *                                                                                                                               
//	 * @param PriScgRtVO priScgRtVO                                                                                                  
//	 * @return boolean                                                                                                               
//	 * @exception DAOException                                                                                                       
//	 */                                                                                                                              
//	public boolean searchSurchargeDuplicateExcel(PriScgRtVO priScgRtVO)                                                              
//		throws DAOException {                                                                                                    
//		DBRowSet dbRowset = null;                                                                                                
//		// query parameter                                                                                                       
//		Map<String, Object> param = new HashMap<String, Object>();                                                               
//		// velocity parameter                                                                                                    
//		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
//		boolean rtnVal = false;                                                                                                  
//		                                                                                                                         
//		try {                                                                                                                    
//			if (priScgRtVO != null) {                                                                                        
//				Map<String, String> mapVO = priScgRtVO.getColumnValues();                                                
//		                                                                                                                         
//				param.putAll(mapVO);                                                                                     
//				velParam.putAll(mapVO);                                                                                  
//			}                                                                                                                
//			dbRowset = new SQLExecuter("").executeQuery(                                                                     
//					(ISQLTemplate) new SurchargeDBDAOChkPriScgRtExcelVORSQL(),                                       
//					param, velParam);                                                                                
//			if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {                                                              
//				rtnVal = true;                                                                                           
//			}                                                                                                                
//		                                                                                                                         
//		} catch (SQLException se) {                                                                                              
//			log.error(se.getMessage(), se);                                                                                  
//			throw new DAOException(new ErrorHandler(se).getMessage());                                                       
//		} catch (Exception ex) {                                                                                                 
//			log.error(ex.getMessage(), ex);                                                                                  
//			throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
//		}                                                                                                                        
//		return rtnVal;                                                                                                           
//	}	                                                                                                                         
//	public boolean searchSurchargeDuplicate(PriScgRtVO priScgRtVO)                                                                   
//			throws DAOException {                                                                                            
//		DBRowSet dbRowset = null;                                                                                                
//		// query parameter                                                                                                       
//		Map<String, Object> param = new HashMap<String, Object>();                                                               
//		// velocity parameter                                                                                                    
//		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
//		boolean rtnVal = false;                                                                                                  
//		                                                                                                                         
//		try {                                                                                                                    
//			if (priScgRtVO != null) {                                                                                        
//				Map<String, String> mapVO = priScgRtVO.getColumnValues();                                                
//                                                                                                                                       
//				param.putAll(mapVO);                                                                                     
//				velParam.putAll(mapVO);                                                                                  
//			}                                                                                                                
//			dbRowset = new SQLExecuter("").executeQuery(                                                                     
//					(ISQLTemplate) new SurchargeDBDAOChkPriScgRtVORSQL(),                                            
//					param, velParam);                                                                                
//			if(dbRowset.next() && dbRowset.getInt("CNT") > 0) {                                                              
//				rtnVal = true;                                                                                           
//			}                                                                                                                
//                                                                                                                                       
//		} catch (SQLException se) {                                                                                              
//			log.error(se.getMessage(), se);                                                                                  
//			throw new DAOException(new ErrorHandler(se).getMessage());                                                       
//		} catch (Exception ex) {                                                                                                 
//			log.error(ex.getMessage(), ex);                                                                                  
//			throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
//		}                                                                                                                        
//		return rtnVal;                                                                                                           
//	}                                                                                                                                
	                                                                                                                                 
	/**                                                                                                                              
	 * Sucharge의 전체 List를 조회합니다. <br>                                                                                       
	 *                                                                                                                               
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                                            
	 * @return List<PriScgRtVO>                                                                                                      
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	 @SuppressWarnings("unchecked")                                                                                                  
	public List<PriScgRtVO> searchAllSurchargeList(CstPriScgRtVO cstPriScgRtVO) throws DAOException {                                
		DBRowSet dbRowset = null;                                                                                                
		List<PriScgRtVO> list = null;                                                                                            
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
                                                                                                                                         
		try{                                                                                                                     
			if(cstPriScgRtVO != null){                                                                                       
				Map<String, String> mapVO = cstPriScgRtVO .getColumnValues();                                            
				                                                                                                         
				param.putAll(mapVO);                                                                                     
                                                                                                                                         
		        String regexp = "[\\D]";                                                                                         
		        String input = cstPriScgRtVO.getRatUtCd();                                                                       
		        Pattern p = Pattern.compile(regexp);                                                                             
		        Matcher m = p.matcher(input);                                                                                    
		        if (m.find()) {                                                                                                  
		        	velParam.put("is_num", "N");//문자                                                                       
		        } else {                                                                                                         
		        	velParam.put("is_num", "Y");//숫자                                                                       
		        }                                                                                                                
				                                                                                                         
				//POR,DEL 모두 5자리로 입력되었을 경우 특정 Scope만 조회한다.                                            
				if (cstPriScgRtVO.getPorDefCd().length() == 5                                                            
						&& cstPriScgRtVO.getDelDefCd().length() == 5){                                           
					velParam.put("type_cd", "L");                                                                    
				}else if(cstPriScgRtVO.getPorDefCd().length() == 3                                                       
						&& cstPriScgRtVO.getDelDefCd().length() == 3){                                           
					velParam.put("type_cd", "R");                                                                    
				}else if(cstPriScgRtVO.getPorDefCd().length() == 2                                                       
						&& cstPriScgRtVO.getDelDefCd().length() == 2){                                           
					velParam.put("type_cd", "C");                                                                    
				}	                                                                                                 
				                                                                                                         
				velParam.putAll(mapVO);                                                                                  
			}                                                                                                                
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgRtRSQL(), param, velParam);    
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgRtVO .class);                                                
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
	 * SurchargeExcelList 조회한다.<br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchSurchargeExcelList(CstPriScgRtVO cstPriScgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstPriScgRtVO != null){                                                                                       
				Map<String, String> mapVO = cstPriScgRtVO.getColumnValues();                                            
				                                                                                                         
				param.putAll(mapVO);                                                                                     
                                                                                                                                         
		        String regexp = "[\\D]";                                                                                         
		        String input = cstPriScgRtVO.getRatUtCd();                                                                       
		        Pattern p = Pattern.compile(regexp);                                                                             
		        Matcher m = p.matcher(input);                                                                                    
		        if (m.find()) {                                                                                                  
		        	velParam.put("is_num", "N");//문자                                                                       
		        } else {                                                                                                         
		        	velParam.put("is_num", "Y");//숫자                                                                       
		        }                                                                                                                
				                                                                                                         
				//POR,DEL 모두 5자리로 입력되었을 경우 특정 Scope만 조회한다.                                            
				if (cstPriScgRtVO.getPorDefCd().length() == 5                                                            
						&& cstPriScgRtVO.getDelDefCd().length() == 5){                                           
					velParam.put("type_cd", "L");                                                                    
				}else if(cstPriScgRtVO.getPorDefCd().length() == 3                                                       
						&& cstPriScgRtVO.getDelDefCd().length() == 3){                                           
					velParam.put("type_cd", "R");                                                                    
				}else if(cstPriScgRtVO.getPorDefCd().length() == 2                                                       
						&& cstPriScgRtVO.getDelDefCd().length() == 2){                                           
					velParam.put("type_cd", "C");                                                                    
				}	                                                                                                 
				                                                                                                         
				velParam.putAll(mapVO);                                                                                  
			} 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgRtExcelRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}		
		 
		 
	/**                                                                                                                              
	 * Surcharge Preferences를 삭제합니다. <br>                                                                                      
	 *                                                                                                                               
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                                            
	 * @return int                                                                                                                   
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	public int removeSurchargePreferences(CstPriScgRtVO cstPriScgRtVO) throws DAOException,Exception {                               
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		                                                                                                                         
		int result = 0;                                                                                                          
		try {                                                                                                                    
			Map<String, String> mapVO = cstPriScgRtVO.getColumnValues();                                                     
			                                                                                                                 
			param.putAll(mapVO);                                                                                             
			velParam.putAll(mapVO);                                                                                          
			                                                                                                                 
			SQLExecuter sqlExe = new SQLExecuter("");                                                                        
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOPriScgPrfVODSQL(), param, velParam);               
			if(result == Statement.EXECUTE_FAILED)                                                                           
					throw new DAOException("Fail to remove SQL");                                                    
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
	 * Surcharge를 삭제합니다. <br>                                                                                                  
	 *                                                                                                                               
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                                            
	 * @return int                                                                                                                   
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	public int removeSurchargeRate(CstPriScgRtVO cstPriScgRtVO) throws DAOException,Exception {                                      
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		                                                                                                                         
		int result = 0;                                                                                                          
		try {                                                                                                                    
			Map<String, String> mapVO = cstPriScgRtVO.getColumnValues();                                                     
			                                                                                                                 
			param.putAll(mapVO);                                                                                             
			velParam.putAll(mapVO);                                                                                          
			                                                                                                                 
			SQLExecuter sqlExe = new SQLExecuter("");                                                                        
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeDBDAOPriScgRtVODSQL(), param, velParam);                
			if(result == Statement.EXECUTE_FAILED)                                                                           
					throw new DAOException("Fail to remove SQL");                                                    
		} catch(SQLException se) {                                                                                               
			log.error(se.getMessage(),se);                                                                                   
			throw new DAOException(new ErrorHandler(se).getMessage(), se);                                                   
		} catch(Exception ex) {                                                                                                  
			log.error(ex.getMessage(),ex);                                                                                   
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);                                                   
		}                                                                                                                        
		return result;                                                                                                           
	}                                                                                                                                
	                                                                                                                                 
	/**                                                                                                                              
	 * PSA Group Code를 조회합니다. <br>                                                                                             
	 *                                                                                                                               
	 * @param PriScgPrfVO priScgPrfVO                                                                                                
	 * @return List<RsltCdListVO>                                                                                                    
	 * @exception DAOException                                                                                                       
	 */                                                                                                                              
	 @SuppressWarnings("unchecked")                                                                                                  
	public List<RsltCdListVO> searchComboPsaCdList(PriScgPrfVO priScgPrfVO) throws DAOException {                                    
		DBRowSet dbRowset = null;                                                                                                
		List<RsltCdListVO> list = null;                                                                                          
		//query parameter                                                                                                        
		Map<String, Object> param = new HashMap<String, Object>();                                                               
		//velocity parameter                                                                                                     
		Map<String, Object> velParam = new HashMap<String, Object>();                                                            
                                                                                                                                         
		try{                                                                                                                     
			if(priScgPrfVO != null){                                                                                         
				Map<String, String> mapVO = priScgPrfVO .getColumnValues();                                              
			                                                                                                                 
				param.putAll(mapVO);                                                                                     
				velParam.putAll(mapVO);                                                                                  
			}                                                                                                                
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgPsaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);                                              
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
		 * Surcharge List를 request 합니다. <br>                                                                                             
		 *                                                                                                                               
		 * @param PriScgRtVO priScgRtVO                                                                                                  
		 * @return List<PriScgRtVO>                                                                                                      
		 * @exception DAOException                                                                                                       
		 */                                                                                                                              
		@SuppressWarnings("unchecked")                                                                                                   
		public void requestSurchargeList(List<PriScgRtVO> priScgRtVOs) throws DAOException {                                         
			try {                                                                                                                    
				SQLExecuter sqlExe = new SQLExecuter("");                                                                        
				int updCnt[] = null;                                                                                             
				if(priScgRtVOs.size() > 0){                                                                                      
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgRqstRt2VOUSQL(), priScgRtVOs,null);        
					for(int i = 0; i < updCnt.length; i++){                                                                  
						if(updCnt[i]== Statement.EXECUTE_FAILED)                                                         
							throw new DAOException("Fail to update No"+ i + " SQL");                                 
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
		 * Surcharge List를 조회합니다. <br>                                                                                             
		 *                                                                                                                               
		 * @param PriScgRtVO priScgRtVO                                                                                                  
		 * @return List<PriScgRtVO>                                                                                                      
		 * @exception DAOException                                                                                                       
		 */                                                                                                                              
		@SuppressWarnings("unchecked")                                                                                                   
		public List<PriScgRtVO> searchSurchargeRequestList(PriScgRtVO priScgRtVO) throws DAOException {                                         
			DBRowSet dbRowset = null;                                                                                                
			List<PriScgRtVO> list = null;                                                                                            
			//query parameter                                                                                                        
			Map<String, Object> param = new HashMap<String, Object>();                                                               
			//velocity parameter                                                                                                     
			Map<String, Object> velParam = new HashMap<String, Object>();                                                            
	                                                                                                                                         
			try{                                                                                                                     
				if(priScgRtVO != null){                                                                                          
					Map<String, String> mapVO = priScgRtVO .getColumnValues();                                               
					                                                                                                         
					param.putAll(mapVO);                                                                                     
					velParam.putAll(mapVO);                                                                                  
					                                                                                                         
					String sPrcCgoTpCd = priScgRtVO.getPrcCgoTpCd();                                                         
	                                                                                                                                         
					if(!"".equals(JSPUtil.getNull(sPrcCgoTpCd))) {                                                           
						List<String> tempList = new ArrayList<String>();                                                 
						String[] temp = priScgRtVO.getPrcCgoTpCd().split(",");                                           
						for(int i=0; i<temp.length; i++) {                                                               
							tempList.add(temp[i]);                                                                   
						}                                                                                                
						tempList.add("NULL");                                                                            
						velParam.put("prc_cgo_tp_cd", tempList);                                                         
					}                                                                                                        
				}                                                                                                                
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgRqstRtVORSQL(), param, velParam);  
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgRtVO .class);                                                
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
		 * Surcharge List를 approve 합니다. <br>                                                                                             
		 *                                                                                                                               
		 * @param PriScgRtVO priScgRtVO                                                                                                  
		 * @return List<PriScgRtVO>                                                                                                      
		 * @exception DAOException                                                                                                       
		 */                                                                                                                              
		@SuppressWarnings("unchecked")                                                                                                   
		public void approveSurchargeList(List<PriScgRtVO> priScgRtVOs) throws DAOException {                                         
			try {                                                                                                                    
				SQLExecuter sqlExe = new SQLExecuter("");                                                                        
				int updCnt[] = null;                                                                                             
				if(priScgRtVOs.size() > 0){           
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgAproRtVOUSQL(), priScgRtVOs,null);        
					for(int i = 0; i < updCnt.length; i++){                                                                  
						if(updCnt[i]== Statement.EXECUTE_FAILED)                                                         
							throw new DAOException("Fail to update No"+ i + " SQL");                                 
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
			 * Surcharge List를 request 합니다. <br>                                                                                             
			 *                                                                                                                               
			 * @param PriScgRtVO priScgRtVO                                                                                                  
			 * @return List<PriScgRtVO>                                                                                                      
			 * @exception DAOException                                                                                                       
			 */                                                                                                                              
			@SuppressWarnings("unchecked")                                                                                                   
			public void aprroveSurchargeList2(List<PriScgRtVO> priScgRtVOs) throws DAOException {                                         
				try {                                                                                                                    
					SQLExecuter sqlExe = new SQLExecuter("");                                                                        
					int updCnt[] = null;                                                                                             
					if(priScgRtVOs.size() > 0){                                                                                      
						updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgAproRt2VOUSQL(), priScgRtVOs,null);        
						for(int i = 0; i < updCnt.length; i++){                                                                  
							if(updCnt[i]== Statement.EXECUTE_FAILED)                                                         
								throw new DAOException("Fail to update No"+ i + " SQL");                                 
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
			 * Surcharge 승인 권한 조회. <br>                                                                                             
			 *                                                                                                                               
			 * @param PriScgRtVO priScgRtVO                                                                                                  
			 * @return PriScgAuthVO                                                                                                     
			 * @exception DAOException                                                                                                       
			 */                                                                                                                              
			@SuppressWarnings("unchecked")                                                                                                   
			public PriScgAuthVO searchSurchargeAuth(PriScgAuthVO priScgAuthVO) throws DAOException {                                         
				DBRowSet dbRowset = null;    
				List<PriScgAuthVO> list = null;
				PriScgAuthVO authVO = new PriScgAuthVO();
				//query parameter                                                                                                        
				Map<String, Object> param = new HashMap<String, Object>();                                                               
				//velocity parameter                                                                                                     
				Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		                                                                                                                                         
				try{                                                                                                                     
					if(priScgAuthVO != null){                                                                                          
						Map<String, String> mapVO = priScgAuthVO .getColumnValues();                                               
						                                                                                                         
						param.putAll(mapVO);                                                                                     
						velParam.putAll(mapVO);                                                                                  
						                                                                                                      
					}                                                                                                                
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgAuthVORSQL(), param, velParam);  
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgAuthVO .class); 
					if( list.size() != 0 ){
						authVO = list.get(0);
					}
				}catch(SQLException se){                                                                                                 
					log.error(se.getMessage(),se);                                                                                   
					throw new DAOException(new ErrorHandler(se).getMessage());                                                       
				}catch(Exception ex){                                                                                                    
					log.error(ex.getMessage(),ex);                                                                                   
					throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
				}                                                                                                                        
				return authVO;                                                                                                             
			}    
			
			
			/**                                                                                                                              
			 * Surcharge 권한 조회. <br>                                                                                             
			 *                                                                                                                               
			 * @param PriScgRtVO priScgRtVO                                                                                                  
			 * @return PriScgAuthVO                                                                                                     
			 * @exception DAOException                                                                                                       
			 */                                                                                                                              
			@SuppressWarnings("unchecked")                                                                                                   
			public PriScgAuthVO checkServiceScope(PriScgAuthVO priScgAuthVO) throws DAOException {                                         
				DBRowSet dbRowset = null;    
				List<PriScgAuthVO> list = null;
				PriScgAuthVO authVO = new PriScgAuthVO();
				//query parameter                                                                                                        
				Map<String, Object> param = new HashMap<String, Object>();                                                               
				//velocity parameter                                                                                                     
				Map<String, Object> velParam = new HashMap<String, Object>();                                                            
				
				try{                                                                                                                     
					if(priScgAuthVO != null){                                                                                          
						Map<String, String> mapVO = priScgAuthVO .getColumnValues();                                               
						
						param.putAll(mapVO);                                                                                     
						velParam.putAll(mapVO);                                                                                  
						
					}                                                                                                                
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgCheckScopeVORSQL(), param, velParam);  
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriScgAuthVO .class); 
					if( list.size() != 0 ){
						authVO = list.get(0);
					}
				}catch(SQLException se){                                                                                                 
					log.error(se.getMessage(),se);                                                                                   
					throw new DAOException(new ErrorHandler(se).getMessage());                                                       
				}catch(Exception ex){                                                                                                    
					log.error(ex.getMessage(),ex);                                                                                   
					throw new DAOException(new ErrorHandler(ex).getMessage());                                                       
				}                                                                                                                        
				return authVO;                                                                                                             
			}    
			
			
			
			/**                                                                                                                              
			 * Surcharge Request Rate 삭제합니다. <br>                                                                                                  
			 *                                                                                                                               
			 * @param List<PriScgRtVO> priScgRtVOs                                                                                           
			 * @return int                                                                                                                   
			 * @exception DAOException                                                                                                       
			 */                                                                                                                              
			public void deleteSurhcargeRequsetRate(List<PriScgRtVO> priScgRtVOs) throws DAOException,Exception {                                      
				try {      
					SQLExecuter sqlExe = new SQLExecuter("");                                                                        
					int updCnt[] = null;                                                                                             
					if(priScgRtVOs.size() > 0){                                                                                      
						updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgRqstRtVODSQL(), priScgRtVOs,null);        
						for(int i = 0; i < updCnt.length; i++){                                                                  
							if(updCnt[i]== Statement.EXECUTE_FAILED)                                                         
								throw new DAOException("Fail to update No"+ i + " SQL");                                 
						}                                                                                                        
					}                                                  
				} catch(SQLException se) {                                                                                               
					log.error(se.getMessage(),se);                                                                                   
					throw new DAOException(new ErrorHandler(se).getMessage(), se);                                                   
				} catch(Exception ex) {                                                                                                  
					log.error(ex.getMessage(),ex);                                                                                   
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);                                                   
				}                                                                                                                        
			}       
			
			/**                                                                                                                              
			 * Surcharge Request Rate 삭제합니다. <br>                                                                                                  
			 *                                                                                                                               
			 * @param List<PriScgRtVO> priScgRtVOs                                                                                           
			 * @return int                                                                                                                   
			 * @exception DAOException                                                                                                       
			 */                                                                                                                              
			public void deleteSurhcargeRate(List<PriScgRtVO> priScgRtVOs) throws DAOException,Exception {                                      
				try {      
					SQLExecuter sqlExe = new SQLExecuter("");                                                                        
					int updCnt[] = null;                                                                                             
					if(priScgRtVOs.size() > 0){                                                                                      
						updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeDBDAOPriScgRtVO2DSQL(), priScgRtVOs,null);        
						for(int i = 0; i < updCnt.length; i++){                                                                  
							if(updCnt[i]== Statement.EXECUTE_FAILED)                                                         
								throw new DAOException("Fail to update No"+ i + " SQL");                                 
						}                                                                                                        
					}                                                  
				} catch(SQLException se) {                                                                                               
					log.error(se.getMessage(),se);                                                                                   
					throw new DAOException(new ErrorHandler(se).getMessage(), se);                                                   
				} catch(Exception ex) {                                                                                                  
					log.error(ex.getMessage(),ex);                                                                                   
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);                                                   
				}                                                                                                                        
			}       
			
			
			/**                                                                                                                              
			 * Trade 별 Service Scope Code 를 조회합니다. <br>                                                                                             
			 *                                                                                                                               
			 * @param PriScgRtVO priScgRtVO                                                                                                  
			 * @return List<PriScgRtVO>                                                                                                      
			 * @exception DAOException                                                                                                       
			 */                                                                                                                              
			@SuppressWarnings("unchecked")                                                                                                   
			public List<RsltCdListVO> searchTradeServiceScopeCodeList(PriScgRtVO priScgRtVO) throws DAOException {                                         
				DBRowSet dbRowset = null;                                                                                                
				List<RsltCdListVO> list = null;                                                                                            
				//query parameter                                                                                                        
				Map<String, Object> param = new HashMap<String, Object>();                                                               
				//velocity parameter                                                                                                     
				Map<String, Object> velParam = new HashMap<String, Object>();                                                            
		                                                                                                                                         
				try{                                                                                                                     
					if(priScgRtVO != null){                                                                                          
						Map<String, String> mapVO = priScgRtVO .getColumnValues();                                               
						                                                                                                         
						param.putAll(mapVO);                                                                                     
						velParam.putAll(mapVO);                                                                                  
						                                                                                                         
					}                                                                                                                
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeDBDAOPriScgSearchTradeServiceScopeVORSQL(), param, velParam);  
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);                                                
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
			 * MDM_SUB_TRD 테이블을 조회합니다.<br>                                                                                   
			 *                                                                                                                        
			 * @param PriScgRtVO priScgRtVO                                                                                       
			 * @return List<PriScgRtVO>                                                                                             
			 * @exception DAOException                                                                                                
			 */                                                                                                                       
			@SuppressWarnings("unchecked")                                                                                            
			public List<PriScgRtVO> searchScgGrpCmdtCdList(PriScgRtVO priScgRtVO) throws DAOException {                         
				DBRowSet dbRowset = null;                                                                                               
				List<PriScgRtVO> list = null;                                                                                         
				// query parameter                                                                                                      
				Map<String, Object> param = new HashMap<String, Object>();                                                              
				// velocity parameter                                                                                                   
				Map<String, Object> velParam = new HashMap<String, Object>();                                                           
		                                                                                                                            
				try {                                                                                                                   
					if (priScgRtVO != null) {                                                                                           
						Map<String, String> mapVO = priScgRtVO.getColumnValues();                                                         
		                                                                                                                            
						param.putAll(mapVO);                                                                                                
						velParam.putAll(mapVO);                                                                                             
					}                                                                                                                     
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SurchargeDBDAOPriScgGrpCmdtCdListRSQL(), param, velParam);
					list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriScgRtVO.class);                                                   
				} catch (SQLException se) {                                                                                             
					log.error(se.getMessage(), se);                                                                                       
					throw new DAOException(new ErrorHandler(se).getMessage(), se);                                                        
				} catch (Exception ex) {                                                                                                
					log.error(ex.getMessage(), ex);                                                                                       
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);                                                        
				}                                                                                                                       
				return list;                                                                                                            
			}       
}                                                                                                                                        
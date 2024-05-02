/*=========================================================                                                                 
*Copyright(c) 2009 CyberLogitec                                                                                             
*@FileName : SurchargeBC.java                                                                                               
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
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing) : ESM_PRI_4033 화면 추가     
2012.03.07 서미진 [CHM-201216620] Surcharge Creation / Inquiry 에서 PSA 항목 추가                                           
=========================================================*/                                                                 
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.basic;                                                             
                                                                                                                            
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgAuthVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
                                                                                                                            
/**                                                                                                                         
 * NIS2010-Surcharge Business Logic Command Interface<br>                                                                   
 * - NIS2010-Surcharge에 대한 비지니스 로직에 대한 인터페이스<br>                                                           
 *                                                                                                                          
 * @author JaeYeon Kim                                                                                                      
 * @see Esm_pri_4003EventResponse 참조                                                                                      
 * @since J2EE 1.6                                                                                                          
 */                                                                                                                         
                                                                                                                            
public interface SurchargeBC {                                                                                              
	/**                                                                                                                 
	 * Percentage Base Code를 조회합니다. <br>                                                                          
	 *                                                                                                                  
	 * @param PriScgPrfVO priScgPrfVO                                                                                   
	 * @return List<RsltCdListVO>                                                                                       
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<RsltCdListVO> searchComboPctBseCdList(PriScgPrfVO priScgPrfVO) throws EventException;                   
	                                                                                                                    
	/**                                                                                                                 
	 * Surcharge Preferences 리스트를 조회합니다. <br>                                                                  
	 *                                                                                                                  
	 * @param PriScgPrfVO priScgPrfVO                                                                                   
	 * @return List<PriScgPrfVO>                                                                                        
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<PriScgPrfVO> searchSurchargePreferences(PriScgPrfVO priScgPrfVO) throws EventException;                 
	                                                                                                                    
	/**                                                                                                                 
	 * Surcharge Preferences를 수정합니다. <br>                                                                         
	 *                                                                                                                  
	 * @param PriScgPrfVO[] priScgPrfVOs                                                                                
	 * @param SignOnUserAccount account                                                                                 
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void manageSurchargePreferences(PriScgPrfVO[] priScgPrfVOs, SignOnUserAccount account) throws EventException;
	                                                                                                                    
	/**                                                                                                                 
	 * Surcharge를 조회합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgRtVO priScgRtVO                                                                                     
	 * @return List<PriScgRtVO>                                                                                         
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO) throws EventException;                           
	
	                                                                                  
	/**                                                                                                                 
	 * Surcharge를 수정합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgRtVO[] priScgRtVOs                                                                                  
	 * @param SignOnUserAccount account                                                                                 
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void manageSurchargeRate(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException;         
	                                                                                                                    
	/**                                                                                                                 
	 * Surcharge 중복을 확인합니다. <br>                                                                                
	 *                                                                                                                  
	 * @param PriScgRtVO[] priScgRtVOs                                                                                  
	 * @return String                                                                                                   
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public String checkSurchargeDuplicate(PriScgRtVO[] priScgRtVOs) throws EventException;                              
	                                                                                                                    
//	/**                                                                                                                 
//	 * Surcharge 중복을 확인합니다. <br>                                                                                
//	 *                                                                                                                  
//	 * @param PriScgRtVO[] priScgRtVOs                                                                                  
//	 * @return String                                                                                                   
//	 * @exception EventException                                                                                        
//	 */                                                                                                                 
//	public String checkSurchargeDuplicateExcel(PriScgRtVO[] priScgRtVOs) throws EventException;	                    
	                                                                                                                    
	/**                                                                                                                 
	 * Sucharge의 전체 List를 조회합니다. <br>                                                                          
	 *                                                                                                                  
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                               
	 * @return List<PriScgRtVO>                                                                                         
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<PriScgRtVO> searchAllSurchargeList(CstPriScgRtVO cstPriScgRtVO) throws EventException;     


	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String object) throws EventException;

	/**
	 * SurchargeExcelList 조회 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchSurchargeExcelListDoStart(CstPriScgRtVO cstPriScgRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_4011 : BackEndJob 결과 - Account별 조회 이벤트 처리<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> excelDownSurchargeList(String key) throws EventException;	
	                                                                                                                    
	/**                                                                                                                 
	 * Sucharge Preferences를 삭제합니다. <br>                                                                          
	 *                                                                                                                  
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                               
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void removeSurchargePreferences(CstPriScgRtVO cstPriScgRtVO) throws EventException;                          
	                                                                                                                    
	/**                                                                                                                 
	 * Sucharge Rate를 삭제합니다. <br>                                                                                 
	 *                                                                                                                  
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                               
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void removeSurchargeRate(CstPriScgRtVO cstPriScgRtVO) throws EventException;                                 
	                                                                                                                    
	/**                                                                                                                 
	 * PSA Group Code를 조회합니다. <br>                                                                                
	 *                                                                                                                  
	 * @param PriScgPrfVO priScgPrfVO                                                                                   
	 * @return List<RsltCdListVO>                                                                                       
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<RsltCdListVO> searchComboPsaCdList(PriScgPrfVO priScgPrfVO) throws EventException; 
	
	/**                                                                                                                 
	 * Surcharge를 request 합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgRtVO priScgRtVO                                                                                     
	 * @return List<PriScgRtVO>                                                                                         
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void requestSurchargeList(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException;                         

	
	/**                                                                                                                 
	 * Surcharge를 조회합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgRtVO priScgRtVO                                                                                     
	 * @return List<PriScgRtVO>                                                                                         
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<PriScgRtVO> searchSurchargeRequestList(PriScgRtVO priScgRtVO) throws EventException;  
	
	/**                                                                                                                 
	 * Surcharge를 request 합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgRtVO priScgRtVO                                                                                     
	 * @return List<PriScgRtVO>                                                                                         
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void approveSurchargeList(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException;                         

	
	/**                                                                                                                 
	 * Surcharge를 조회합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgAuthVO priScgAuthVO                                                                                    
	 * @return PriScgAuthVO                                                                                       
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public PriScgAuthVO searchSurchargeAuth(PriScgAuthVO priScgAuthVO, SignOnUserAccount account) throws EventException;                           
	                                  
	
	/**                                                                                                                 
	 * Surcharge를 조회합니다. <br>                                                                                     
	 *                                                                                                                  
	 * @param PriScgAuthVO priScgAuthVO                                                                                    
	 * @return PriScgAuthVO                                                                                       
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public PriScgAuthVO checkServiceScope(PriScgAuthVO priScgAuthVO) throws EventException;        
	
	/**                                                                                                                 
	 * Sucharge Request Rate를 삭제합니다. <br>                                                                                 
	 *                                                                                                                  
	 * @param PriScgRtVO[] priScgRtVOs                                                                            
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public void cancelSurchargeList(PriScgRtVO[] priScgRtVOs) throws EventException;     
	
	/**                                                                                                                 
	 * Trade 별 Service Scope List 검색 <br>                                                                                 
	 *                                                                                                                  
	 * @param PriScgRtVO priScgRtVO    
	 * @return List<RsltCdListVO>                                                                          
	 * @exception EventException                                                                                        
	 */                                                                                                                 
	public List<RsltCdListVO> searchTradeServiceScopeCodeList(PriScgRtVO priScgRtVO) throws EventException;     
	
	/**                                                                                                 
	 * Surcharge Group Commodity Code List 를 조회합니다.<br>                                         
	 *                                                                                                
	 * @param PriScgRtVO priScgRtVO                                                               
	 * @return List<RsltCdListVO>                                                                     
	 * @exception EventException                                                                      
	 */                                                                                               
	public List<PriScgRtVO> searchScgGrpCmdtCdList(PriScgRtVO priScgRtVO) throws EventException;


}                                                                                                      


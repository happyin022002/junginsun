/*=========================================================                                                                                                                                                                             
*Copyright(c) 2009 CyberLogitec                                                                                                                                                                                                         
*@FileName : SurchargeBCImpl.java                                                                                                                                                                                                       
*@FileTitle : Surcharge Creation                                                                                                                                                                                                        
*Open Issues :                                                                                                                                                                                                                          
*Change history :                                                                                                                                                                                                                       
*@LastModifyDate : 2009.06.04                                                                                                                                                                                                           
*@LastModifier : 源����                                                                                                                                                                                                                
*@LastVersion : 1.0                                                                                                                                                                                                                     
* 2009.06.04 源����                                                                                                                                                                                                                    
* 1.0 Creation                                                                                                                                                                                                                          
=========================================================                                                                                                                                                                               
* History                                                                                                                                                                                                                               
2012.03.07 ���吏�[CHM-201216620] Surcharge Creation / Inquiry ��� PSA ��ぉ 異��                                                                                                                                                       
=========================================================*/                                                                                                                                                                             
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.basic;                                                                                                                                                                         
                                                                                                                                                                                                                                        
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration.SurchargeDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgAuthVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgPrfVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.PriScgRtVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
                                                                                                                                                                                                                                        
/**                                                                                                                                                                                                                                     
 * NIS2010-Surcharge Business Logic Basic Command implementation<br>                                                                                                                                                                    
 * - NIS2010-Surcharge����� 鍮����� 濡����泥�━���.<br>                                                                                                                                                                             
 *                                                                                                                                                                                                                                      
 * @author JaeYeon Kim                                                                                                                                                                                                                  
 * @see ESM_PRI_4003EventResponse,SurchargeBC 媛�DAO �대���李몄“                                                                                                                                                                        
 * @since J2EE 1.6                                                                                                                                                                                                                      
 */                                                                                                                                                                                                                                     
public class SurchargeBCImpl extends BasicCommandSupport implements SurchargeBC {                                                                                                                                                       
                                                                                                                                                                                                                                        
	// Database Access Object                                                                                                                                                                                                       
	private transient SurchargeDBDAO dbDao = null;                                                                                                                                                                                  
                                                                                                                                                                                                                                        
	/**                                                                                                                                                                                                                             
	 * SurchargeBCImpl 媛�껜 ���<br>                                                                                                                                                                                                
	 * SurchargeDBDAO瑜�������.<br>                                                                                                                                                                                               
	 */                                                                                                                                                                                                                             
	public SurchargeBCImpl() {                                                                                                                                                                                                      
		dbDao = new SurchargeDBDAO();                                                                                                                                                                                           
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Percentage Base Code瑜�議고��⑸��� <br>                                                                                                                                                                                      
	 *                                                                                                                                                                                                                              
	 * @param PriScgPrfVO priScgPrfVO                                                                                                                                                                                               
	 * @return List<RsltCdListVO>                                                                                                                                                                                                   
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<RsltCdListVO> searchComboPctBseCdList(PriScgPrfVO priScgPrfVO) throws EventException {                                                                                                                              
		try {                                                                                                                                                                                                                   
			return dbDao.searchComboPctBseCdList(priScgPrfVO);                                                                                                                                                              
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Surcharge Preferences 由ъ��몃� 議고��⑸��� <br>                                                                                                                                                                              
	 *                                                                                                                                                                                                                              
	 * @param PriScgPrfVO priScgPrfVO                                                                                                                                                                                               
	 * @return List<PriScgPrfVO>                                                                                                                                                                                                    
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<PriScgPrfVO> searchSurchargePreferences(PriScgPrfVO priScgPrfVO) throws EventException {                                                                                                                            
		try {                                                                                                                                                                                                                   
			return dbDao.searchSurchargePreferences(priScgPrfVO);                                                                                                                                                           
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Surcharge Preferences瑜�����⑸��� <br>                                                                                                                                                                                     
	 *                                                                                                                                                                                                                              
	 * @param PriScgPrfVO[] priScgPrfVOs                                                                                                                                                                                            
	 * @param SignOnUserAccount account                                                                                                                                                                                             
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void manageSurchargePreferences(PriScgPrfVO[] priScgPrfVOs,SignOnUserAccount account) throws EventException {                                                                                                            
		try {                                                                                                                                                                                                                   
			if(priScgPrfVOs.length > 0) {                                                                                                                                                                                   
				if("I".equals(priScgPrfVOs[0].getIbflag())) {                                                                                                                                                           
					priScgPrfVOs[0].setCreUsrId(account.getUsr_id());                                                                                                                                               
					priScgPrfVOs[0].setUpdUsrId(account.getUsr_id());                                                                                                                                               
					dbDao.addSurchargePreferences(priScgPrfVOs[0],account);  
					dbDao.modifySurchargePreferences(priScgPrfVOs[0]);
				} else if("U".equals(priScgPrfVOs[0].getIbflag())){                                                                                                                                                     
					priScgPrfVOs[0].setUpdUsrId(account.getUsr_id());                                                                                                                                               
					dbDao.modifySurchargePreferences(priScgPrfVOs[0]);                                                                                                                                              
				}                                                                                                                                                                                                       
			}                                                                                                                                                                                                               
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);                                                                                                                         
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * 議고� �대깽��泥�━<br>                                                                                                                                                                                                         
	 * Surcharge��㈃����� 議고� �대깽��泥�━<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO priScgRtVO                                                                                                                                                                                                 
	 * @return List<PriScgRtVO>                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<PriScgRtVO> searchSurchargeList(PriScgRtVO priScgRtVO) throws EventException {                                                                                                                                      
		try {                                                                                                                                                                                                                   
			return dbDao.searchSurchargeList(priScgRtVO);                                                                                                                                                                   
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Surcharge瑜�����⑸��� <br>                                                                                                                                                                                                 
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO[] priScgRtVOs                                                                                                                                                                                              
	 * @param SignOnUserAccount account                                                                                                                                                                                             
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void manageSurchargeRate(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException{                                                                                                                     
		try {                                                                                                                                                                                                                   
			List<PriScgRtVO> insertVoList = new ArrayList<PriScgRtVO>();                                                                                                                                                    
			List<PriScgRtVO> updateVoList = new ArrayList<PriScgRtVO>();                                                                                                                                                    
//			List<PriScgRtVO> deleteVoList = new ArrayList<PriScgRtVO>();                                                                                                                                                    
			                                                                                                                                                                                                                
			if(priScgRtVOs == null) {                                                                                                                                                                                       
				return;                                                                                                                                                                                                 
			}                                                                                                                                                                                                               
			                                                                                                                                                                                                                
			for(int i=0; i<priScgRtVOs .length; i++) {     
				
				if(priScgRtVOs[i].getScgRqstStsCd().equals("N")) { 
					if(priScgRtVOs[i].getIbflag().equals("I")){
						priScgRtVOs[i].setCreUsrId(account.getUsr_id());                                                                                                                                                
						priScgRtVOs[i].setUpdUsrId(account.getUsr_id());                                                                                                                                                
						insertVoList.add(priScgRtVOs[i]);
					}else if(priScgRtVOs[i].getIbflag().equals("U")){
						priScgRtVOs[i].setCreUsrId(account.getUsr_id());
						priScgRtVOs[i].setUpdUsrId(account.getUsr_id());                                                                                                                                                
						updateVoList.add(priScgRtVOs[i]); 
					}
				}else if(priScgRtVOs[i].getScgRqstStsCd().equals("A")) {                                                                                                                                                            
					priScgRtVOs[i].setCreUsrId(account.getUsr_id());
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());                                                                                                                                                
					updateVoList.add(priScgRtVOs[i]);                                                                                                                                                               
				} else if(priScgRtVOs[i].getScgRqstStsCd().equals("D")) {                                                                                                                                                     
					priScgRtVOs[i].setCreUsrId(account.getUsr_id());
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());                                                                                                                                                
					priScgRtVOs[i].setDeltFlg("Y");                                                                                                                                                                 
					updateVoList.add(priScgRtVOs[i]);                                                                                                                                                                
				}
			}    
			
                                                                                                                                                                                                                                        
			if ( updateVoList.size() > 0 ) {                                                                                                                                                                                
				dbDao.modifySurchargeRate(updateVoList);                                                                                                                                                                
			}                                                                                                                                                                                                               
                                                                                                                                                                                                                                        
            if ( insertVoList.size() > 0 ) {                                                                                                                                                                                            
//                dbDao.addSurchargeRate(insertVoList);                                                                                                                                                                                 
                for (int i = 0, n = insertVoList.size() ; i < n ; i++) {                                                                                                                                                                
                    dbDao.addSurchargeRate(insertVoList.get(i));
                    dbDao.addSurchargeRequestRate(insertVoList.get(i));
                }                                                                                                                                                                                                                       
            }                                                                                                                                                                                                                           
                                                                                                                                                                                                                                        
		} catch (DAOException de) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);                                                                                                                         
		} catch (Exception de) {                                                                                                                                                                                                
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);                                                                                                                         
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Surcharge 以�났������⑸��� <br>                                                                                                                                                                                            
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO[] priScgRtVOs                                                                                                                                                                                              
	 * @return String                                                                                                                                                                                                               
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	                                                                                                                                                                                                                                
	public String checkSurchargeDuplicate(PriScgRtVO[] priScgRtVOs) throws EventException {                                                                                                                                         
		String rtnVal = "";                                                                                                                                                                                                     
		                                                                                                                                                                                                                        
		try {                                                                                                                                                                                                                   
			if(priScgRtVOs != null) {                                                                                                                                                                                       
				                                                                                                                                                                                                        
				log.debug("checkSurchargeDuplicate==priScgRtVOs = count=="+priScgRtVOs.length);                                                                                                                         
				for(int i=0; i<priScgRtVOs.length; i++ ) {                                                                                                                                                              
//					if(!"D".equals(priScgRtVOs[i].getIbflag()) && dbDao.searchSurchargeDuplicate(priScgRtVOs[i])) {                                                                                                 
//					��� 媛�� 議곌굔�쇰� Dup Check 瑜������寃쎌� 議고���紐⑤� �곗��곗� ��� ��������濡�Time Out ��諛����린 ��Ц���대� �������� ��. 2012.01.16 - �≫�吏�				
					if(("I".equals(priScgRtVOs[i].getIbflag()) || "U".equals(priScgRtVOs[i].getIbflag())) && "A".equals(priScgRtVOs[i].getScgRqstProcCd()) &&dbDao.searchSurchargeDuplicate(priScgRtVOs[i])) {                                                      
						rtnVal =  priScgRtVOs[i].getSeq();                                                                                                                                                      
						break;                                                                                                                                                                                  
					}                                                                                                                                                                                               
				}                                                                                                                                                                                                       
			}                                                                                                                                                                                                               
			return rtnVal;                                                                                                                                                                                                  
			                                                                                                                                                                                                                
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}	                                                                                                                                                                                                                        
	                                                                                                                                                                                                                                
//	/**                                                                                                                                                                                                                             
//	 * Surcharge 以�났������⑸��� <br>                                                                                                                                                                                            
//	 *                                                                                                                                                                                                                              
//	 * @param PriScgRtVO[] priScgRtVOs                                                                                                                                                                                              
//	 * @return String                                                                                                                                                                                                               
//	 * @exception EventException                                                                                                                                                                                                    
//	 */                                                                                                                                                                                                                             
//	                                                                                                                                                                                                                                
//	public String checkSurchargeDuplicateExcel(PriScgRtVO[] priScgRtVOs) throws EventException {                                                                                                                                    
//		String rtnVal = "";                                                                                                                                                                                                     
//		                                                                                                                                                                                                                        
//		try {                                                                                                                                                                                                                   
//			if(priScgRtVOs != null) {                                                                                                                                                                                       
//				for(int i=0; i<priScgRtVOs.length; i++ ) {                                                                                                                                                              
//					if(("I".equals(priScgRtVOs[i].getIbflag()) || "U".equals(priScgRtVOs[i].getIbflag())) && dbDao.searchSurchargeDuplicateExcel(priScgRtVOs[i])) {                                                 
//						rtnVal =  priScgRtVOs[i].getSeq();                                                                                                                                                      
//						break;                                                                                                                                                                                  
//					}                                                                                                                                                                                               
//				}                                                                                                                                                                                                       
//			}                                                                                                                                                                                                               
//			return rtnVal;                                                                                                                                                                                                  
//			                                                                                                                                                                                                                
//		} catch (DAOException ex) {                                                                                                                                                                                             
//			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
//		} catch (Exception ex) {                                                                                                                                                                                                
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
//		}                                                                                                                                                                                                                       
//	}		                                                                                                                                                                                                                
	                                                                                                                                                                                                                                
//	public String checkSurchargeDuplicate(PriScgRtVO[] priScgRtVOs) throws EventException {                                                                                                                                         
//		String rtnVal = "";                                                                                                                                                                                                     
//		                                                                                                                                                                                                                        
//		try {                                                                                                                                                                                                                   
//			if(priScgRtVOs != null) {                                                                                                                                                                                       
//				for(int i=0; i<priScgRtVOs.length; i++ ) {                                                                                                                                                              
//					if(("I".equals(priScgRtVOs[i].getIbflag()) || "U".equals(priScgRtVOs[i].getIbflag())) && dbDao.searchSurchargeDuplicate(priScgRtVOs[i])) {                                                      
//						rtnVal =  priScgRtVOs[i].getSeq();                                                                                                                                                      
//						break;                                                                                                                                                                                  
//					}                                                                                                                                                                                               
//				}                                                                                                                                                                                                       
//			}                                                                                                                                                                                                               
//			return rtnVal;                                                                                                                                                                                                  
//			                                                                                                                                                                                                                
//		} catch (DAOException ex) {                                                                                                                                                                                             
//			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
//		} catch (Exception ex) {                                                                                                                                                                                                
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                   
//		}                                                                                                                                                                                                                       
//	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Surcharge����껜 List瑜�議고��⑸��� <br>                                                                                                                                                                                      
	 *                                                                                                                                                                                                                              
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                                                                                                                                           
	 * @return List<PriScgRtVO>                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<PriScgRtVO> searchAllSurchargeList(CstPriScgRtVO cstPriScgRtVO) throws EventException {                                                                                                                             
		try {                                                                                                                                                                                                                   
			return dbDao.searchAllSurchargeList(cstPriScgRtVO);                                                                                                                                                             
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               

	/**
	 * BackEndJob�����媛�� 議고����.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}	
	
	/**
	 * SurchargeExcelList 議고� ��� BackEndJob���ㅽ����. <br>
	 * 
	 * @param CstPriScgRtVO cstPriScgRtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchSurchargeExcelListDoStart(CstPriScgRtVO cstPriScgRtVO, SignOnUserAccount account) throws EventException {
		SearchSurchargeExcelListBackEndJob searchSurchargeExcelListBackEndJob = new SearchSurchargeExcelListBackEndJob();
		searchSurchargeExcelListBackEndJob.setCstPriScgRtVO(cstPriScgRtVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchSurchargeExcelListBackEndJob, account.getUsr_id(), "ESM_PRI_4011 - Surcharge Excel Download");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_4015 : BackEndJob 寃곌낵 - Account蹂�議고� �대깽��泥�━<br>
	 *
	 * @param String key
	 * @return List<Object>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<Object> excelDownSurchargeList(String key) throws EventException {
		try {
			return (List<Object>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**                                                                                                                                                                                                                             
	 * Sucharge Preferences瑜�����⑸��� <br>                                                                                                                                                                                      
	 *                                                                                                                                                                                                                              
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                                                                                                                                           
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void removeSurchargePreferences(CstPriScgRtVO cstPriScgRtVO) throws EventException {                                                                                                                                     
		try {                                                                                                                                                                                                                   
			dbDao.removeSurchargePreferences(cstPriScgRtVO);                                                                                                                                                                
		} catch (DAOException ex) {                                                                                                                                                                                             
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);                                                                                                                                     
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * Sucharge Rate瑜�����⑸��� <br>                                                                                                                                                                                             
	 *                                                                                                                                                                                                                              
	 * @param CstPriScgRtVO cstPriScgRtVO                                                                                                                                                                                           
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void removeSurchargeRate(CstPriScgRtVO cstPriScgRtVO) throws EventException {                                                                                                                                            
		try {                                                                                                                                                                                                                   
			dbDao.removeSurchargeRate(cstPriScgRtVO);                                                                                                                                                                       
		} catch (DAOException ex) {                                                                                                                                                                                             
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);                                                                                                                                     
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                                                                                                                                                                                                                               
	                                                                                                                                                                                                                                
	/**                                                                                                                                                                                                                             
	 * PSA Group Code瑜�議고��⑸��� <br>                                                                                                                                                                                            
	 *                                                                                                                                                                                                                              
	 * @param PriScgPrfVO priScgPrfVO                                                                                                                                                                                               
	 * @return List<RsltCdListVO>                                                                                                                                                                                                   
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<RsltCdListVO> searchComboPsaCdList(PriScgPrfVO priScgPrfVO) throws EventException {                                                                                                                                 
		try {                                                                                                                                                                                                                   
			return dbDao.searchComboPsaCdList(priScgPrfVO);                                                                                                                                                                 
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                   
	
	
	/**                                                                                                                                                                                                                             
	 * 議고� �대깽��泥�━<br>                                                                                                                                                                                                         
	 * Surcharge��㈃��request �대깽��泥�━<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO priScgRtVO                                                                                                                                                                                                 
	 * @return List<PriScgRtVO>                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void requestSurchargeList(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException{                                                                                                                     
		try {                                                                                                                                                                                                                   
			List<PriScgRtVO> updateVoList = new ArrayList<PriScgRtVO>();                                                                                                                                                    
			if(priScgRtVOs == null) {                                                                                                                                                                                       
				return;                                                                                                                                                                                                 
			}                                                                                                                                                                                                               

			for (int i = 0; i < priScgRtVOs.length; i++) {
				if (("R").equals(priScgRtVOs[i].getScgRqstProcCd())) {
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					priScgRtVOs[i].setRqstUsrId(account.getUsr_id());
					updateVoList.add(priScgRtVOs[i]);
				}
				if (("S").equals(priScgRtVOs[i].getScgRqstProcCd())) {
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priScgRtVOs[i]);
				}
			}               
			
			if (updateVoList.size() > 0) {
				dbDao.requestSurchargeList(updateVoList);
			}
                                                                                                                                                                                                                                        
		} catch (DAOException de) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);                                                                                                                         
		} catch (Exception de) {                                                                                                                                                                                                
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);                                                                                                                         
		}                                                                                                                                                                                                                       
	}  
	
	/**                                                                                                                                                                                                                             
	 * 議고� �대깽��泥�━<br>                                                                                                                                                                                                         
	 * Surcharge��㈃��apporve �대깽��泥�━<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO priScgRtVO                                                                                                                                                                                                 
	 * @return List<PriScgRtVO>                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void approveSurchargeList(PriScgRtVO[] priScgRtVOs, SignOnUserAccount account) throws EventException{                                                                                                                     
		try {                                                                                                                                                                                                                   
			List<PriScgRtVO> updateVoList = new ArrayList<PriScgRtVO>();                                                                                                                                                    
			List<PriScgRtVO> updateVoList2 = new ArrayList<PriScgRtVO>();                                                                                                                                                    
			if(priScgRtVOs == null) {                                                                                                                                                                                       
				return;                                                                                                                                                                                                 
			}                                                                                                                                                                                                               
			
			for (int i = 0; i < priScgRtVOs.length; i++) {
				if (("A").equals(priScgRtVOs[i].getScgRqstProcCd())) {
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					priScgRtVOs[i].setAproUsrId(account.getUsr_id());
					updateVoList.add(priScgRtVOs[i]);
					if (("D").equals(priScgRtVOs[i].getScgRqstStsCd())) {
						priScgRtVOs[i].setDeltFlg("Y"); 
					}
				}
				if (("J").equals(priScgRtVOs[i].getScgRqstProcCd())) {
					priScgRtVOs[i].setUpdUsrId(account.getUsr_id());
					priScgRtVOs[i].setAproUsrId(account.getUsr_id());
					updateVoList2.add(priScgRtVOs[i]);
				}
			}      
			
			if (updateVoList.size() > 0) {
				dbDao.approveSurchargeList(updateVoList);   // rate ���釉�� Update
				dbDao.aprroveSurchargeList2(updateVoList);  //request ���釉�� Update
			}
			
			if (updateVoList2.size() > 0) { // Reject 하는 경우 Request Table만
				dbDao.aprroveSurchargeList2(updateVoList2);  //request ���釉�� Update
			}
			
		} catch (DAOException de) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);                                                                                                                         
		} catch (Exception de) {                                                                                                                                                                                                
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);                                                                                                                         
		}                                                                                                                                                                                                                       
	}   
	
	
	
	/**                                                                                                                                                                                                                             
	 * 議고� �대깽��泥�━<br>                                                                                                                                                                                                         
	 * Surcharge��㈃����� 議고� �대깽��泥�━<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO priScgRtVO                                                                                                                                                                                                 
	 * @return List<PriScgRtVO>                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<PriScgRtVO> searchSurchargeRequestList(PriScgRtVO priScgRtVO) throws EventException {                                                                                                                                      
		try {                                                                                                                                                                                                                   
			return dbDao.searchSurchargeRequestList(priScgRtVO);                                                                                                                                                                   
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                
	
	/**                                                                                                                                                                                                                             
	 * 議고� �대깽��泥�━<br>                                                                                                                                                                                                         
	 * Surcharge �뱀� 沅�� 議고�<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgAuthVO priScgAuthVO                                                                                                                                                                                                 
	 * @return PriScgAuthVO                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public PriScgAuthVO searchSurchargeAuth(PriScgAuthVO priScgAuthVO, SignOnUserAccount account) throws EventException {                                                                                                                                      
		try {       
			
			priScgAuthVO.setUsrId(account.getUsr_id());
			
			return dbDao.searchSurchargeAuth(priScgAuthVO);                                                                                                                                                                   
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	} 
	
	/**                                                                                                                                                                                                                             
	 * 議고� �대깽��泥�━<br>                                                                                                                                                                                                         
	 * Service Scope �����泥댄�<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgAuthVO priScgAuthVO                                                                                                                                                                                                 
	 * @return PriScgAuthVO                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public PriScgAuthVO checkServiceScope(PriScgAuthVO priScgAuthVO) throws EventException {                                                                                                                                      
		try {       
			return dbDao.checkServiceScope(priScgAuthVO);                                                                                                                                                                   
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                
	
	
	
	/**                                                                                                                                                                                                                             
	 * Sucharge Request Rate瑜�����⑸��� <br>                                                                                                                                                                                             
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO[] priScgRtVOs                                                                                                                                                                                        
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public void cancelSurchargeList(PriScgRtVO[] priScgRtVOs) throws EventException {                                                                                                                                            
		try {     
			
			List<PriScgRtVO> deleteVoList = new ArrayList<PriScgRtVO>(); 
			List<PriScgRtVO> deleteVoList2 = new ArrayList<PriScgRtVO>(); 
			
			if(priScgRtVOs == null) {                                                                                                                                                                                       
				return;                                                                                                                                                                                                 
			} 
			
			for (int i = 0; i < priScgRtVOs.length; i++) {
				if(("S").equals(priScgRtVOs[i].getScgRqstProcCd())){
					if (("A").equals(priScgRtVOs[i].getScgRqstStsCd()) || ("D").equals(priScgRtVOs[i].getScgRqstStsCd())) {
						deleteVoList.add(priScgRtVOs[i]);
					}
					if (("N").equals(priScgRtVOs[i].getScgRqstStsCd())) {
						deleteVoList2.add(priScgRtVOs[i]);
					}
				}
			}    
			
			if (deleteVoList.size() > 0) {
				dbDao.deleteSurhcargeRequsetRate(deleteVoList);  
			}
			if (deleteVoList2.size() > 0) {
				dbDao.deleteSurhcargeRequsetRate(deleteVoList2);  
				dbDao.deleteSurhcargeRate(deleteVoList2);  
			}
			
		} catch (DAOException ex) {                                                                                                                                                                                             
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);                                                                                                                                     
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}        
	
	/**                                                                                                                                                                                                                                                                                                                                                                                                                                      
	 * Trade 별 Service Scope 검색<br>                                                                                                                                                                                    
	 *                                                                                                                                                                                                                              
	 * @param PriScgRtVO priScgRtVO                                                                                                                                                                                                 
	 * @return List<RsltCdListVO>                                                                                                                                                                                                     
	 * @exception EventException                                                                                                                                                                                                    
	 */                                                                                                                                                                                                                             
	public List<RsltCdListVO> searchTradeServiceScopeCodeList(PriScgRtVO priScgRtVO) throws EventException {                                                                                                                                      
		try {                                                                                                                                                                                                                   
			return dbDao.searchTradeServiceScopeCodeList(priScgRtVO);                                                                                                                                                                   
		} catch (DAOException ex) {                                                                                                                                                                                             
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                         
		} catch (Exception ex) {                                                                                                                                                                                                
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);                                                                                                                                     
		}                                                                                                                                                                                                                       
	}                
	
	
	/**                                                                                                  
	 * ScgGrpCmdtCdList 를 조회합니다.<br>                                                             
	 * mdm_charge 코드,명칭 을 조회합니다.<br>                                                         
	 *                                                                                                 
	 * @param PriScgRtVO priScgRtVO                                                                
	 * @return List<PriScgRtVO>                                                                      
	 * @exception EventException                                                                       
	 */                                                                                                
	public List<PriScgRtVO> searchScgGrpCmdtCdList(PriScgRtVO priScgRtVO) throws EventException {
		try {                                                                                            
			return dbDao.searchScgGrpCmdtCdList(priScgRtVO);                                             
		} catch (DAOException ex) {                                                                      
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);      
		} catch (Exception ex) {                                                                         
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);      
		}                                                                                                
	}  
	    
}                                                                                                                                                                                                                                       
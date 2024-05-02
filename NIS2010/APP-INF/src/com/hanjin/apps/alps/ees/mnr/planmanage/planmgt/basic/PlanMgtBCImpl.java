/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtBCImpl.java
*@FileTitle : Expense Plan Creation by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.basic;

import java.util.ArrayList;
import java.util.List;

import weblogic.connector.common.Debug;


import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration.PlanMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrGuidelineVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnDtlVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnHdrVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.CustomMnrPlnTransVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.DisposalPlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.GuidelineGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.RepairExpensePlanGRPVO;
import com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo.OfficeInfoGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PlanManage Business Logic Basic Command implementation<br>
 * - alps-PlanManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author chung young hun
 * @see EES_MNR_0112EventResponse,PlanMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 * 
 */
public class PlanMgtBCImpl extends BasicCommandSupport implements PlanMgtBC {

	// Database Access Object
	private transient PlanMgtDBDAO dbDao = null;

	/**
	 * PlanMgtBCImpl 객체 생성<br>
	 * PlanMgtDBDAO를 생성한다.<br>
	 */
	public PlanMgtBCImpl() {
		dbDao = new PlanMgtDBDAO();
	}
	
	
    /**
     * [EES_MNR_0112]Expense Plan Creation by HO의 정보를 조회 합니다. <br>
     *
	 * @param RepairExpensePlanGRPVO repairExpensePlanGRPVO
	 * @return RepairExpensePlanGRPVO
	 * @exception EventException
	 */
	public RepairExpensePlanGRPVO searchRepairExpensePlanListBasic(RepairExpensePlanGRPVO repairExpensePlanGRPVO) throws EventException {
		try {
			 repairExpensePlanGRPVO.setCustomMnrPlnHdrVOLst(dbDao.searchRepairExpensePlanHeaderData(repairExpensePlanGRPVO.getRepairExpensePlanINVO()));
			 repairExpensePlanGRPVO.setCustomMnrPlnDtlVOLst(dbDao.searchRepairExpensePlanDetailData(repairExpensePlanGRPVO.getRepairExpensePlanINVO()));


			return repairExpensePlanGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Expense Plan Creation by HO] searchRepairExpensePlanListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Expense Plan Creation by HO] searchRepairExpensePlanListBasic"}).getMessage(),ex);
		}
	}
	


    /**
     * [EES_MNR_0112]Expense Plan Creation by HO의 정보를 저장 합니다. <br>
     *
	 * @param RepairExpensePlanGRPVO repairExpensePlanGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairExpensePlanBasic(RepairExpensePlanGRPVO repairExpensePlanGRPVO, SignOnUserAccount account) throws EventException{
		try {
			if(repairExpensePlanGRPVO.getRepairExpensePlanINVO().getMnrPlnFlg().equals("Y")){
				 dbDao.modifyRepairExpensePlanHeaderData(repairExpensePlanGRPVO, account);
				
			}else{
				
				//HDR (Plan Office가 SELCON일때, Sheet1, Sheet2의 모든 office를 HDR로 만든다.)
				if(repairExpensePlanGRPVO.getRepairExpensePlanINVO().getMnrPlnOfcCd().equals("SELCON")){
					CustomMnrPlnHdrVO[] hdrvos = repairExpensePlanGRPVO.getCustomMnrPlnHdrVOS();
					if(hdrvos == null) return;
					
					List<CustomMnrPlnHdrVO> insertHdrVoList   = new ArrayList<CustomMnrPlnHdrVO>();
					List<CustomMnrPlnHdrVO> deleteHdrVoList   = new ArrayList<CustomMnrPlnHdrVO>();
					List<CustomMnrPlnHdrVO> updateHdrVoList   = new ArrayList<CustomMnrPlnHdrVO>();

					
					String key1 ="";
					
					for ( int i=0; i<hdrvos .length; i++ ) {
						if(hdrvos[i] == null)break;
						
				    	if ( hdrvos[i].getIbflag().equals("D")){
								CustomMnrPlnHdrVO vo = hdrvos[i]; 
								
								if(vo.getMnrPlnSeq() != null){
									deleteHdrVoList.add(vo);
								}else{
									throw new EventException("MNR00001");
								}
					    }else{			
					           if (( hdrvos[i].getIbflag().equals("I"))){
					        	   CustomMnrPlnHdrVO vo = hdrvos[i]; 
					        	   
					        	   List<CustomMnrPlnHdrVO> hdr = dbDao.createPlanSequenceData(repairExpensePlanGRPVO.getRepairExpensePlanINVO());
					        	   
					        	   String key = "";
					        	   key = ((CustomMnrPlnHdrVO)hdr.get(0)).getMnrPlnSeq();
					        	   vo.setMnrPlnSeq(key);
					        	   
					        	   if("".equals(vo.getMnrPlnGrpNo()) || vo.getMnrPlnGrpNo() == null){
						        	   if(i==0){
						        		   key1 = ((CustomMnrPlnHdrVO)hdr.get(0)).getMnrPlnSeq();
						        	   }
					        	   }
					        	   else{
					        		   key1 = vo.getMnrPlnGrpNo();
					        	   }
					        	   
					        	   vo.setMnrPlnGrpNo(key1);
					        	   
					        	   if(vo.getMnrPlnSeq() != null){
								    	vo.setCreUsrId(account.getUsr_id());
										insertHdrVoList.add(vo);
								   }else{
									throw new EventException("MNR00001");
					        	   }
					        	   
					           } else if (( hdrvos[i].getIbflag().equals("U"))){
					        	   
					        	   CustomMnrPlnHdrVO vo = hdrvos[i];
					        	   
					        	   if(vo.getMnrPlnSeq() != null){
					        		    vo.setCreUsrId(account.getUsr_id());
										updateHdrVoList.add(vo);
									}else{
										throw new EventException("MNR00001");
									}
					           }
						 }
					}//for
					
				   if(deleteHdrVoList.size() > 0){
					   dbDao.removeRepairExpensePlanHeaderData(deleteHdrVoList);
				   }
				   if(insertHdrVoList.size() > 0){
					   dbDao.addRepairExpensePlanHeaderData(insertHdrVoList);
				   }
				   if(updateHdrVoList.size() > 0){
					   dbDao.modifyRepairExpensePlanHeaderDataList(updateHdrVoList);
					   
				   }
				}
				
				
				//DTL
				CustomMnrPlnDtlVO[]  dtlvos  = repairExpensePlanGRPVO.getCustomMnrPlnDtlVOS();
				if(dtlvos == null ) return;
				
				List<CustomMnrPlnDtlVO> insertDtlVoList  = new ArrayList<CustomMnrPlnDtlVO>();
				List<CustomMnrPlnDtlVO> deleteDtlVoList  = new ArrayList<CustomMnrPlnDtlVO>();
				List<CustomMnrPlnDtlVO> updateDtlVoList  = new ArrayList<CustomMnrPlnDtlVO>();
				List<CustomMnrPlnDtlVO> newInsertDtlVoList  = new ArrayList<CustomMnrPlnDtlVO>();

				String planOffice 	= "";
				String officeType	= "";
				
				int dtlseq = 0;
	    		boolean isCheck = false;
	    		
	    		if(dtlvos.length > 0){
				for ( int i=0; i<dtlvos.length; i++ ) {
					if(dtlvos[i] == null){
						continue;
					}else{
						planOffice 	= dtlvos[i].getMnrPlnOfcCd();
						officeType	= dtlvos[i].getOfcTpCd();
					}
					
					if(dtlvos[i] == null)break;
					CustomMnrPlnDtlVO vo = dtlvos[i]; 
					
					if ( dtlvos[i].getIbflag().equals("D")){
					    deleteDtlVoList.add(vo);
					}else{	
						
						if(planOffice.trim().equals("SELCON")){
					    	if (( dtlvos[i].getIbflag().equals("I"))){
					    		
					    		if(dtlseq == 0){
						    		if("BB".equals(dtlvos[i].getOfcTpCd()) ){
						    			dtlseq = 6;
						    			
						    		}else{
						    			dtlseq = 0;
						    		}
					    		}
					    		//ofc를 비교해 dtlSeq를 설정한다. 
					    		dtlseq = dtlseq + 1;
							    vo.setMnrPlnDtlSeq(Integer.toString(dtlseq));
							    if(i < dtlvos.length-1){
							    	if(dtlvos[i].getCtrlOfcCd() != dtlvos[i+1].getCtrlOfcCd()){
										dtlseq = 0;
									}
							    }
					    		if(vo.getMnrPlnSeq() != null){
									vo.setCreUsrId(account.getUsr_id());
									newInsertDtlVoList.add(vo);
								}else{
									throw new EventException("MNR00001");
								}
	
					    	} else if (( dtlvos[i].getIbflag().equals("U"))){
					    		int minSeq = 0;
					    		
					    		if(!isCheck){
					    			minSeq = dbDao.searchRepairExpensePlanMinSequence(dtlvos[i]);
					    			dtlseq = minSeq ;
					    			isCheck = true;
					    		}
					    		
					    		//ofc를 비교해 dtlSeq를 설정한다. 
					    		dtlseq = dtlseq + 1;
							    vo.setMnrPlnDtlSeq(Integer.toString(dtlseq));
							    if(i < dtlvos.length-1){
							    	if(dtlvos[i].getCtrlOfcCd() != dtlvos[i+1].getCtrlOfcCd()){
										dtlseq = 0;
									}
							    }
							    
				        	   if(vo.getMnrPlnSeq() != null){
				        		   vo.setCreUsrId(account.getUsr_id());
				        		   updateDtlVoList.add(vo);
								}else{
									throw new EventException("MNR00001");
								}
					    	}
						}else{

							if (i < 6)
								continue;
							
							if (( dtlvos[i].getIbflag().equals("I"))){

								int maxSeq = 0;
								
					    		if(!isCheck){
					    			String temp = "";
					    			if(!"SELCON".equals(dtlvos[0].getCtrlOfcCd())){ 
					    				temp = dtlvos[i].getCtrlOfcCd();
					    				dtlvos[i].setCtrlOfcCd(dtlvos[0].getCtrlOfcCd());
					    				maxSeq = dbDao.searchRepairExpensePlanMaxSequence(dtlvos[i]);
					    				dtlvos[i].setCtrlOfcCd(temp);
					    			}
					    			else{
					    				maxSeq = dbDao.searchRepairExpensePlanMaxSequence(dtlvos[i]);
					    			}
					    				
						    		dtlseq = maxSeq;
					    			isCheck = true;

					    		}
					    		
					    		//ofc를 비교해 dtlSeq를 설정한다. 
					    		dtlseq = dtlseq + 1;
							    vo.setMnrPlnDtlSeq(Integer.toString(dtlseq));

							    if(i < dtlvos.length-1){
							    	if(dtlvos[i].getCtrlOfcCd() != dtlvos[i+1].getCtrlOfcCd()){
							    		if(!"HQ".equals(dtlvos[0].getOfcTpCd())){ 
								    		maxSeq = dbDao.searchRepairExpensePlanMaxSequence(dtlvos[i]);
							    			dtlseq = maxSeq;
							    			isCheck = true;
							    		
							    		}
							    		
									}
							    }

					    		if(vo.getMnrPlnSeq() != null){
					    			
									vo.setCreUsrId(account.getUsr_id());
									if("SELCON".equals(dtlvos[0].getCtrlOfcCd())){
										newInsertDtlVoList.add(vo);
					    			}
									else{
										
										vo.setCreUsrId(account.getUsr_id());										
										insertDtlVoList.add(vo);
									}
								}else{
									throw new EventException("MNR00001");
								}
	
					    	} else if (( dtlvos[i].getIbflag().equals("U"))){
					    		int minSeq = 0;
					    		
					    		if(!isCheck){
					    			minSeq = dbDao.searchRepairExpensePlanMinSequence(dtlvos[i]);
					    			dtlseq = minSeq ;
					    			isCheck = true;
					    		}
					    		
					    		//ofc를 비교해 dtlSeq를 설정한다. 
					    		dtlseq = dtlseq + 1;
							    vo.setMnrPlnDtlSeq(Integer.toString(dtlseq));
							    
							    if(i < dtlvos.length-1){
							    	if(dtlvos[i].getCtrlOfcCd() != dtlvos[i+1].getCtrlOfcCd()){
							    		if(!"U".equals(dtlvos[i+1].getIbflag())){
							    			isCheck = false;
							    		}
							    		else{
							    			minSeq = dbDao.searchRepairExpensePlanMinSequence(dtlvos[i]);
							    			dtlseq = minSeq;
							    			isCheck = true;
							    		}
							    		
									}
							    }
					        	   				        	   
				        	   if(vo.getMnrPlnSeq() != null){
				        		   vo.setCreUsrId(account.getUsr_id());
				        		   updateDtlVoList.add(vo);
								}else{
									throw new EventException("MNR00001");
								}
					    	}
						}
					}
				}//for
	    		}
			    if(deleteDtlVoList.size() > 0){
			    	dbDao.removeRepairExpensePlanDetailData(deleteDtlVoList);
			    }
			    if(insertDtlVoList.size() > 0){
			       dbDao.addRepairExpensePlanDetailData(insertDtlVoList);
			    }	
			    if(newInsertDtlVoList.size() > 0){
				   dbDao.addRepairExpensePlanDetailNewData(newInsertDtlVoList);
				}
			    if(updateDtlVoList.size() > 0){
				   dbDao.modifyRepairExpensePlanDetailDataList(updateDtlVoList);
				}	

			}	
			
		} catch (EventException e){ 
		    log.error("err " + e.toString(), e);
			throw e;	
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Expense Plan Creation by HO] manageRepairExpensePlanBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Expense Plan Creation by HO] manageRepairExpensePlanBasic"}).getMessage(),ex);
		}
	}


  
  /**
   * [EES_MNR_0216]M&R Guideline & Information의 정보를 조회 합니다. <br>
   *
   * @param GuidelineGRPVO guidelineGRPVO
   * @param SignOnUserAccount account
   * @return GuidelineGRPVO
   * @exception EventException
   */
	public GuidelineGRPVO searchGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomMnrGuidelineVO> customMnrGuidelineVO = new ArrayList<CustomMnrGuidelineVO>();
			
			guidelineGRPVO.getGuidelineINVO().setOfcCd(account.getOfc_cd());
			customMnrGuidelineVO = dbDao.searchGuidelineInfoListData(guidelineGRPVO.getGuidelineINVO());
			guidelineGRPVO.setCustomMnrGuidelineLst(customMnrGuidelineVO);
			return guidelineGRPVO;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] searchGuidelineInfoListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] searchGuidelineInfoListBasic"}).getMessage(),ex);
		}
	}  

	/**
	 * [EES_MNR_0216]M&R Guideline & Information의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GuidelineGRPVO guidelineGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineInfoListBasic(GuidelineGRPVO guidelineGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			CustomMnrGuidelineVO[]  customMnrGuidelineVOs  = guidelineGRPVO.getCustomMnrGuidelineVOs();
			if(customMnrGuidelineVOs == null ) return;
			
			List<CustomMnrGuidelineVO> insertVoList   = new ArrayList<CustomMnrGuidelineVO>();
			List<CustomMnrGuidelineVO> updateVoList   = new ArrayList<CustomMnrGuidelineVO>();
			List<CustomMnrGuidelineVO> deleteVoList   = new ArrayList<CustomMnrGuidelineVO>();
			
		
			for ( int i=0; i< customMnrGuidelineVOs.length; i++ ) { 
				if(customMnrGuidelineVOs[i] == null)break;
				customMnrGuidelineVOs[i].setCreUsrId(account.getUsr_id());
				customMnrGuidelineVOs[i].setUpdUsrId(account.getUsr_id());				
				if ( customMnrGuidelineVOs[i].getIbflag().equals("I")){  
					insertVoList.add(customMnrGuidelineVOs[i]);  
				} else if ( customMnrGuidelineVOs[i].getIbflag().equals("U")){
					updateVoList.add(customMnrGuidelineVOs[i]);  
				} else if ( customMnrGuidelineVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customMnrGuidelineVOs[i]);               
				}              
			}             
			    
			if ( insertVoList.size() > 0 ) {
				dbDao.addGuidelineInfoData(insertVoList);
			} 			
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyGuidelineInfoData(updateVoList);
			}   			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGuidelineInfoData(deleteVoList);
			}  
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] manageGuidelineInfoListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Guideline & Information] manageGuidelineInfoListBasic"}).getMessage(),de);
		}
		
	}

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @return DisposalPlanGRPVO
	 * @exception EventException
	 */
	public DisposalPlanGRPVO searchDisposalPlanBasic(DisposalPlanGRPVO disposalPlanGRPVO) throws EventException {
		try { 
			List<List<CustomMnrPlnTransVO>> listCustomMnrPlnTransVOs = new ArrayList<List<CustomMnrPlnTransVO>>();
			
			List<CustomMnrPlnTransVO> listCustomMnrPlnTransVO1 = dbDao.searchDisposalPlanHeaderData(disposalPlanGRPVO);
			List<CustomMnrPlnTransVO> listCustomMnrPlnTransVO2 = dbDao.searchDisposalPlanDetailData(disposalPlanGRPVO);
			
			listCustomMnrPlnTransVOs.add(listCustomMnrPlnTransVO1); 
			listCustomMnrPlnTransVOs.add(listCustomMnrPlnTransVO2); 
			
			disposalPlanGRPVO.setListCustomMnrPlnTransVOs(listCustomMnrPlnTransVOs); 
			return disposalPlanGRPVO;        
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Planning by Headquarter] searchDisposalPlanBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Planning by Headquarter] searchDisposalPlanBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalPlanBasic(DisposalPlanGRPVO disposalPlanGRPVO, SignOnUserAccount account) throws EventException{
		List<CustomMnrPlnHdrVO> listCustomMnrPlnHdrVO = disposalPlanGRPVO.getListCustomMnrPlnHdrVO();
		List<CustomMnrPlnDtlVO> listCustomMnrPlnDtlVO = disposalPlanGRPVO.getListCustomMnrPlnDtlVO();
		
		List<CustomMnrPlnHdrVO> insertHdrVoList   = new ArrayList<CustomMnrPlnHdrVO>();
		List<CustomMnrPlnDtlVO> insertDtlVoList   = new ArrayList<CustomMnrPlnDtlVO>();
		List<CustomMnrPlnHdrVO> deleteHdrVoList   = new ArrayList<CustomMnrPlnHdrVO>();
		List<CustomMnrPlnDtlVO> deleteDtlVoList   = new ArrayList<CustomMnrPlnDtlVO>();

		try {
			String  mnrPlnSeq = listCustomMnrPlnDtlVO.get(0).getMnrPlnSeq();
            if(mnrPlnSeq.equals("") || mnrPlnSeq == null) {
            	mnrPlnSeq  = dbDao.getDisposalPlanHeaderSeqData();
            }
			//HDR
			for ( int i=0; i<listCustomMnrPlnHdrVO.size(); i++ ) {
				listCustomMnrPlnHdrVO.get(i).setMnrPlnSeq(mnrPlnSeq);
				listCustomMnrPlnHdrVO.get(i).setCreUsrId(account.getUsr_id());	
				listCustomMnrPlnHdrVO.get(i).setUpdUsrId(account.getUsr_id());	
				listCustomMnrPlnHdrVO.get(i).setMnrGrpTpCd("DSP");
				String ibFlag = listCustomMnrPlnHdrVO.get(i).getIbflag();
				if(ibFlag.equals("I") || ibFlag.equals("U")) {
					insertHdrVoList.add(listCustomMnrPlnHdrVO.get(i));
				} else if (ibFlag.equals("D")) {
					deleteHdrVoList.add(listCustomMnrPlnHdrVO.get(i));
				}
			}
			
			//DETAIL 
			int maxMnrPlnDtlSeq  = dbDao.getDisposalPlanDetailSeqData(mnrPlnSeq);

			for ( int i=0; i<listCustomMnrPlnDtlVO.size(); i++ ) {
				listCustomMnrPlnDtlVO.get(i).setMnrPlnSeq(mnrPlnSeq);

				String ibFlag = listCustomMnrPlnDtlVO.get(i).getIbflag();
				if ( ibFlag.equals("I") || ibFlag.equals("U")){  
					listCustomMnrPlnDtlVO.get(i).setCreUsrId(account.getUsr_id());
					listCustomMnrPlnDtlVO.get(i).setUpdUsrId(account.getUsr_id());
					listCustomMnrPlnDtlVO.get(i).setMnrPlnDtlSeq((maxMnrPlnDtlSeq+1+i)+"");
					insertDtlVoList.add(listCustomMnrPlnDtlVO.get(i));
				} else if ( ibFlag.equals("D")){
					deleteDtlVoList.add(listCustomMnrPlnDtlVO.get(i));
				}
			} 
			
			if ( insertHdrVoList.size() > 0 ) {
				dbDao.removeDisposalPlanHeaderData(insertHdrVoList);
				dbDao.addDisposalPlanHeaderData(insertHdrVoList);
			}
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.removeDisposalPlanDetailData(insertDtlVoList);
				dbDao.addDisposalPlanDetailData(insertDtlVoList);
			} 			
			if ( deleteHdrVoList.size() > 0 ) {
				dbDao.removeDisposalPlanHeaderData(deleteHdrVoList);
			}  
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeDisposalPlanDetailData(deleteDtlVoList);
			} 
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Planning by Headquarter] manageDisposalPlanBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Planning by Headquarter] manageDisposalPlanBasic"}).getMessage(),de);
		}
		
	}

	/**
	 * [EES_MNR_0153]Disposal Planning by Headquarter의 정보를 체크 합니다. <br>
	 *
	 * @param DisposalPlanGRPVO disposalPlanGRPVO
	 * @return DisposalPlanGRPVO
	 * @exception EventException
	 */
	public DisposalPlanGRPVO checkDisposalPlanHeaderBasic(DisposalPlanGRPVO disposalPlanGRPVO) throws EventException {
		try { 
			String cnt = "";
			cnt = dbDao.checkDisposalPlanHeaderData(disposalPlanGRPVO);
			disposalPlanGRPVO.setCnt(cnt);
			return disposalPlanGRPVO;        
			
		} catch (DAOException ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Planning by Headquarter] checkDisposalPlanHeaderBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Planning by Headquarter] checkDisposalPlanHeaderBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0212]M&R Regional Office Code Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param OfficeInfoGRPVO officeInfoGRPVO
	 * @return OfficeInfoGRPVO
	 * @exception EventException
	 */	
	public OfficeInfoGRPVO searchOfficeCodeListBasic(OfficeInfoGRPVO officeInfoGRPVO) throws EventException {
		try {	
			officeInfoGRPVO.setOfficeInfoListVOS(dbDao.searchOfficeCodeListData(officeInfoGRPVO));
			return officeInfoGRPVO;	
		} catch (DAOException ex) {	
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Performance] searchOfficeCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Performance] searchOfficeCodeListBasic"}).getMessage(),ex);
		}
	}
}
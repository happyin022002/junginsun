/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApprovalStepMgtBC.java
*@FileTitle : Approval Step
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.01.04 조경완
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration.ApprovalStepHistoryMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration.ApprovalStepMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepHistoryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomMnrAproStepVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Cho Kyoung Wan
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4      
 */
public class ApprovalStepMgtBCImpl extends BasicCommandSupport implements ApprovalStepMgtBC{
	
	// Database Access Object 
	private transient ApprovalStepMgtDBDAO dbDao1 = null;
	private transient ApprovalStepHistoryMgtDBDAO dbDao2 = null; 
		
	/** 	
	 * StatusHistoryMgtBCImpl 객체 생성<br>
	 * StatusHistoryMgtDBDAO 생성한다.<br>
	 */    
	public ApprovalStepMgtBCImpl() {  
		dbDao1 = new ApprovalStepMgtDBDAO();
		dbDao2 = new ApprovalStepHistoryMgtDBDAO();
	}
	/**
	 * [EES_MNR_0262]Approval Step 의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @return ApprovalStepGRPVO
	 * @exception EventException
	 */
	public ApprovalStepGRPVO searchApprovalStepBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException{
		try { 
			List<CustomApprovalStepVO> listCustomApprovalStepVO = null;
			approvalStepGRPVO.getApprovalStepINVO().setOfcCd(account.getOfc_cd());
			approvalStepGRPVO.getApprovalStepINVO().setAproUsrId(account.getUsr_id());
			listCustomApprovalStepVO = dbDao1.searchApprovalStepListData(approvalStepGRPVO);
			for(int i = 0; i<listCustomApprovalStepVO.size(); i++){
				if(account.getUsr_id().equals(listCustomApprovalStepVO.get(i).getAproUsrId())){
					approvalStepGRPVO.setListCustomApprovalStepVO(listCustomApprovalStepVO); 
					break;
				}
			}
			
			return approvalStepGRPVO;          
			
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0262] searchApprovalStepBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0262] searchApprovalStepBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0262]Approval Step History의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @return ApprovalStepGRPVO
	 * @exception EventException
	 */
	public ApprovalStepGRPVO searchApprovalStepHistoryBasic(ApprovalStepGRPVO approvalStepGRPVO) throws EventException{
		try { 
			List<CustomApprovalStepHistoryVO> listCustomApprovalStepHistoryVO = null; 
			
			listCustomApprovalStepHistoryVO = dbDao2.searchApprovalStepHistoryListData(approvalStepGRPVO);
				
			approvalStepGRPVO.setListCustomApprovalStepHistoryVO(listCustomApprovalStepHistoryVO);
			return approvalStepGRPVO;          
			
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0262] searchApprovalStepHistoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0262] searchApprovalStepHistoryBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0262]Approval Step History 의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageApprovalStepHistoryBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			//Header 설정//////////////////////////////////////////////////////////////////////
			List<CustomApprovalStepHistoryVO> insertHdrVo = new ArrayList<CustomApprovalStepHistoryVO>();
			List<CustomApprovalStepHistoryVO> updateHdrVo = new ArrayList<CustomApprovalStepHistoryVO>();
			List<CustomApprovalStepHistoryVO> list = new ArrayList<CustomApprovalStepHistoryVO>();
			
			ApprovalStepINVO approvalStepINVO = new ApprovalStepINVO();
			CustomApprovalStepHistoryVO[] arrCustomApprovalStepHistoryVO = approvalStepGRPVO.getCustomApprovalStepHistoryVOs();
			approvalStepINVO.setWrtfNo(approvalStepGRPVO.getWrtfNo());
			approvalStepINVO.setOfcCd(account.getOfc_cd());
			approvalStepINVO.setAproUsrId(account.getUsr_id());
			approvalStepGRPVO.setApprovalStepINVO(approvalStepINVO);
			List<CustomApprovalStepHistoryVO> chkList = dbDao2.searchApprovalStepHistoryChkData(approvalStepGRPVO);
			String wortType = approvalStepGRPVO.getWorkType();
			
			if(chkList.size() == 0){
				list = dbDao2.searchApprovalStepListData(approvalStepGRPVO);
				for(int i = 0; i<list.size(); i++){
					list.get(i).setCreUsrId(account.getUsr_id());
					list.get(i).setUpdUsrId(account.getUsr_id());
					list.get(i).setWrtfNo(approvalStepGRPVO.getWrtfNo());
					if(i == 0){
						list.get(i).setApstsCd("S");
//						list.get(i).setAproRmk(arrCustomApprovalStepHistoryVO[i].getAproRmk());
					}else{
						list.get(i).setApstsCd("W");
					}
				}
				insertHdrVo = list;
				
				if ("SAVE".equals(wortType)){
					for(int i=0; i<arrCustomApprovalStepHistoryVO.length; i++){
						if("U".equals(arrCustomApprovalStepHistoryVO[i].getIbflag())){
							arrCustomApprovalStepHistoryVO[i].setCreUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setUpdUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setApstsCd("S");
							updateHdrVo.add(arrCustomApprovalStepHistoryVO[i]);
						}
					}
				}
			}else{
				if("REQUEST".equals(wortType)){
					for(int i=0; i<arrCustomApprovalStepHistoryVO.length; i++){
						if("1".equals(arrCustomApprovalStepHistoryVO[i].getRowSeq())){
							arrCustomApprovalStepHistoryVO[i].setCreUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setUpdUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setApstsCd("R");
							updateHdrVo.add(arrCustomApprovalStepHistoryVO[i]);
						}
					}
				}else if ("SAVE".equals(wortType)){
					for(int i=0; i<arrCustomApprovalStepHistoryVO.length; i++){
						if("U".equals(arrCustomApprovalStepHistoryVO[i].getIbflag())){
							arrCustomApprovalStepHistoryVO[i].setCreUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setUpdUsrId(account.getUsr_id());
							updateHdrVo.add(arrCustomApprovalStepHistoryVO[i]);
						}
					}
				}else if ("Approval".equals(wortType)){
					for(int i=0; i<arrCustomApprovalStepHistoryVO.length; i++){
						if("U".equals(arrCustomApprovalStepHistoryVO[i].getIbflag())){
							arrCustomApprovalStepHistoryVO[i].setCreUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setUpdUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setApstsCd("V");
							updateHdrVo.add(arrCustomApprovalStepHistoryVO[i]);
						}
					}
				}else if ("Reject".equals(wortType)){
					for(int i=0; i<arrCustomApprovalStepHistoryVO.length; i++){
						if("U".equals(arrCustomApprovalStepHistoryVO[i].getIbflag())){
							arrCustomApprovalStepHistoryVO[i].setCreUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setUpdUsrId(account.getUsr_id());
							arrCustomApprovalStepHistoryVO[i].setApstsCd("J");
							updateHdrVo.add(arrCustomApprovalStepHistoryVO[i]);	
						}
					}
				}
			}
			
			if(insertHdrVo.size() > 0){
				dbDao2.addApprovalStepHistoryData(insertHdrVo);
			}
			if(updateHdrVo.size() > 0){
				dbDao2.modifyApprovalStepHistoryData(updateHdrVo);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Total Loss Request] manageTotalLossBasic"}).getMessage(),de);
		}	
	}
	
	/**
	 * [EES_MNR_0263]Approval Step 의 Office Type를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchApprovalOfcTypeBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException{
		try { 
			String ofcTpCd = "";
			ApprovalStepINVO approvalStepINVO = new ApprovalStepINVO();
			approvalStepINVO.setOfcCd(account.getOfc_cd());
			approvalStepINVO.setAproUsrId(account.getUsr_id());
			ofcTpCd = dbDao1.searchApprovalOfcTypeData(approvalStepINVO);
			
			return ofcTpCd;          
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0263] searchApprovalOfcTypeBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0263] searchApprovalOfcTypeBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0265]Approval Step을 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public ApprovalStepGRPVO searchApprovalStepRankBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException {
		try { 
//			String ofcTpCd = "";
			
			ApprovalStepINVO approvalStepINVO = new ApprovalStepINVO();
			List<CustomMnrAproStepVO> list = null;
			approvalStepINVO.setOfcCd(approvalStepGRPVO.getApprovalStepINVO().getOfcCd());
			approvalStepINVO.setAproUsrId(account.getUsr_id());
			
			list = dbDao1.searchApprovalStepRankDataList(approvalStepINVO);
			approvalStepGRPVO.setListCustomMnrAproStepVO(list);
			
			return approvalStepGRPVO; 
	
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0265] searchApprovalStepRankBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0265] searchApprovalStepRankBasic"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * Office Code 를 체크합니다 <br>
	 * 
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkOfficeBasic(ApprovalStepINVO approvalStepINVO) throws EventException {
		try {
			return dbDao1.checkOfficeData(approvalStepINVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Office Code 를 중복체크합니다 <br>
	 * 
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkAproOfcBasic(ApprovalStepINVO approvalStepINVO) throws EventException{
		try {
			return dbDao1.checkAproOfcData(approvalStepINVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0265]User Name 을 조회합니다 <br>
	 *
	 * @param ApprovalStepINVO approvalStepINVO
	 * @param SignOnUserAccount account
	 * @return List<CustomApprovalStepVO>
	 * @exception EventException
	 */
	public List<CustomApprovalStepVO> searchUserNameBasic(ApprovalStepINVO approvalStepINVO, SignOnUserAccount account) throws EventException {
		try { 
			return dbDao1.searchUserNameData(approvalStepINVO);
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0265] searchApprovalStepRankBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0265] searchApprovalStepRankBasic"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * [EES_MNR_0265]Approval Step 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageApprovalStepBasic(ApprovalStepGRPVO approvalStepGRPVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<CustomApprovalStepVO> insertList = new ArrayList<CustomApprovalStepVO>();
			CustomMnrAproStepVO[] customMnrAproStepVOS = approvalStepGRPVO.getCustomMnrAproStepVOs();
			CustomApprovalStepHistoryVO customApprovalStepHistoryVO = null;
			CustomApprovalStepVO customApprovalStepVO = null;
			CustomApprovalStepVO customApprovalStepVO1 = null;
			CustomApprovalStepVO customApprovalStepVO2 = null;
			CustomApprovalStepVO customApprovalStepVO3 = null;
			
			for(int i = 0; i < customMnrAproStepVOS.length; i++){
				customApprovalStepHistoryVO = new CustomApprovalStepHistoryVO();
				customApprovalStepHistoryVO.setOfcCd(customMnrAproStepVOS[i].getOfcCd());
				customApprovalStepHistoryVO.setCreUsrId(account.getUsr_id());
				customApprovalStepHistoryVO.setUpdUsrId(account.getUsr_id());
				
				customApprovalStepVO = new CustomApprovalStepVO();
				customApprovalStepVO1 = new CustomApprovalStepVO();
				customApprovalStepVO2 = new CustomApprovalStepVO();
				customApprovalStepVO3 = new CustomApprovalStepVO();
				
				customApprovalStepVO.setOfcCd(customMnrAproStepVOS[i].getOfcCd());
				customApprovalStepVO.setOfcTpCd(customMnrAproStepVOS[i].getOfcTpCd());
				customApprovalStepVO.setCreUsrId(account.getUsr_id());
				customApprovalStepVO.setUpdUsrId(account.getUsr_id());
				
				dbDao1.removeAproStepData(customApprovalStepVO);
				
				if(!"D".equals(customMnrAproStepVOS[i].getIbflag())){
					customApprovalStepVO.setAproStepSeq("1");
					customApprovalStepVO.setAproUsrId(customMnrAproStepVOS[i].getPic1UsrId());
					insertList.add(customApprovalStepVO);
					if(!"".equals(customMnrAproStepVOS[i].getPic2UsrId())){
						customApprovalStepVO1.setOfcCd(customMnrAproStepVOS[i].getOfcCd());
						customApprovalStepVO1.setOfcTpCd(customMnrAproStepVOS[i].getOfcTpCd());
						customApprovalStepVO1.setCreUsrId(account.getUsr_id());
						customApprovalStepVO1.setUpdUsrId(account.getUsr_id());
						customApprovalStepVO1.setAproStepSeq("2");
						customApprovalStepVO1.setAproUsrId(customMnrAproStepVOS[i].getPic2UsrId());						
						insertList.add(customApprovalStepVO1);							
						if(!"".equals(customMnrAproStepVOS[i].getPic3UsrId())){
							customApprovalStepVO2.setOfcCd(customMnrAproStepVOS[i].getOfcCd());
							customApprovalStepVO2.setOfcTpCd(customMnrAproStepVOS[i].getOfcTpCd());
							customApprovalStepVO2.setCreUsrId(account.getUsr_id());
							customApprovalStepVO2.setUpdUsrId(account.getUsr_id());
							customApprovalStepVO2.setAproStepSeq("3");
							customApprovalStepVO2.setAproUsrId(customMnrAproStepVOS[i].getPic3UsrId());							
							insertList.add(customApprovalStepVO2);
							if(!"".equals(customMnrAproStepVOS[i].getPic4UsrId())){
								customApprovalStepVO3.setOfcCd(customMnrAproStepVOS[i].getOfcCd());
								customApprovalStepVO3.setOfcTpCd(customMnrAproStepVOS[i].getOfcTpCd());
								customApprovalStepVO3.setCreUsrId(account.getUsr_id());
								customApprovalStepVO3.setUpdUsrId(account.getUsr_id());
								customApprovalStepVO3.setAproStepSeq("4");
								customApprovalStepVO3.setAproUsrId(customMnrAproStepVOS[i].getPic3UsrId());
								insertList.add(customApprovalStepVO3);
							}
						}
					}
					
					if(!"I".equals(customMnrAproStepVOS[i].getIbflag())){			//신규 데이터 입력은 HIS테이블 저장 안함
						if(!"".equals(customMnrAproStepVOS[i].getPrePic4UsrId())){
							if(!customMnrAproStepVOS[i].getPic4UsrId().equals(customMnrAproStepVOS[i].getPrePic4UsrId())){
								customApprovalStepHistoryVO.setAproUsrId(customMnrAproStepVOS[i].getPic4UsrId());
								customApprovalStepHistoryVO.setPreAproUsrId(customMnrAproStepVOS[i].getPrePic4UsrId());
								customApprovalStepHistoryVO.setOfcCd(customMnrAproStepVOS[i].getPic4Ofc());
	
								dbDao1.modifyAproStepHisData(customApprovalStepHistoryVO);
								dbDao1.removeAproStepHisData(customApprovalStepHistoryVO);
							}	
						}
						
						if(!"".equals(customMnrAproStepVOS[i].getPrePic3UsrId())){
							if(!customMnrAproStepVOS[i].getPic3UsrId().equals(customMnrAproStepVOS[i].getPrePic3UsrId())){
								customApprovalStepHistoryVO.setAproUsrId(customMnrAproStepVOS[i].getPic3UsrId());
								customApprovalStepHistoryVO.setPreAproUsrId(customMnrAproStepVOS[i].getPrePic3UsrId());
								customApprovalStepHistoryVO.setOfcCd(customMnrAproStepVOS[i].getPic3Ofc());
	
								dbDao1.modifyAproStepHisData(customApprovalStepHistoryVO);
								dbDao1.removeAproStepHisData(customApprovalStepHistoryVO);
	
							}	
						}
						
						if(!"".equals(customMnrAproStepVOS[i].getPrePic2UsrId())){
							if(!customMnrAproStepVOS[i].getPic2UsrId().equals(customMnrAproStepVOS[i].getPrePic2UsrId())){
								customApprovalStepHistoryVO.setAproUsrId(customMnrAproStepVOS[i].getPic2UsrId());
								customApprovalStepHistoryVO.setPreAproUsrId(customMnrAproStepVOS[i].getPrePic2UsrId());
								customApprovalStepHistoryVO.setOfcCd(customMnrAproStepVOS[i].getPic2Ofc());
	
								dbDao1.modifyAproStepHisData(customApprovalStepHistoryVO);
								dbDao1.removeAproStepHisData(customApprovalStepHistoryVO);
							}	
						}

						if(!"".equals(customMnrAproStepVOS[i].getPrePic1UsrId())){
							if(!customMnrAproStepVOS[i].getPic1UsrId().equals(customMnrAproStepVOS[i].getPrePic1UsrId())){
								customApprovalStepHistoryVO.setAproUsrId(customMnrAproStepVOS[i].getPic1UsrId());
								customApprovalStepHistoryVO.setPreAproUsrId(customMnrAproStepVOS[i].getPrePic1UsrId());
								customApprovalStepHistoryVO.setOfcCd(customMnrAproStepVOS[i].getPic1Ofc());
								dbDao1.modifyAproStepHisData(customApprovalStepHistoryVO);
								dbDao1.removeAproStepHisData(customApprovalStepHistoryVO);
							}
						}

//						dbDao1.removeAproStepHisData(customApprovalStepHistoryVO);
					}
				}
			}
			
			if(insertList != null && insertList.size() > 0){
				dbDao1.addApprovalStepData(insertList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0265] manageApprovalStepBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0265] manageApprovalStepBasic"}).getMessage(),de);
		}	
	}

}

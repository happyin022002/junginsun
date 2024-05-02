/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalStepSendBCImpl.java
*@FileTitle : ERP A/P로 I/F된 CSR에 대한 Approval Step 정보 I/F 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-03-08 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.basic;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.alps.FNS0080004Document;

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration.ApprovalStepSendDBDAO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration.ApprovalStepSendEAIDAO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.vo.ComComAproSndLogVO;

import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.ComAproSndMnRuleVO;
import com.hanjin.syscommon.common.table.ComCsrErrLogVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see ApprovalStepSendBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ApprovalStepSendBCImpl extends BasicCommandSupport implements ApprovalStepSendBC {

	/**
	 * 공통 CSR의 Approval Step I/F 처리용 DBDAO
	 */
	private transient ApprovalStepSendDBDAO aproStepSendDbDao = null;
	
	public ApprovalStepSendBCImpl(){
		this.aproStepSendDbDao = new ApprovalStepSendDBDAO();
	}

	/**
	 * AproStep Send 대상 초기화
	 * # 구동방식이 BATCH에 해당하는 AproStep Send RULE을 조회해서 수행 단위 ROW수만큼 수행 
	 * @param eventResponse
	 * @throws EventException
	 */
	public void initAproStepSend(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - ApprovalStepSendBCImpl - initAproStepSend ~~~~~ \n");
		
		List<ComAproSndMnRuleVO> aproSndMnRuleVOList = null;

		try {
			aproSndMnRuleVOList = getAproStepSendMainRule(APROSTEP_ACT_TP_BATCH);
			log.debug("\n **** aproSndMnRuleVOLst.size() : " + (aproSndMnRuleVOList!=null?aproSndMnRuleVOList.size():0) + " ********************************* \n");
			for (int i=0; aproSndMnRuleVOList!=null && i<aproSndMnRuleVOList.size(); i++){
				initAproStepSendDtl(aproSndMnRuleVOList.get(i));
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ec){
			throw new EventException(ec.getMessage());
		}

		eventResponse.setCustomData(APROSTEP_SND_RULE, aproSndMnRuleVOList);			
		
		log.debug("\n EEEE - ApprovalStepSendBCImpl - initAproStepSend ~~~~~ \n");
	}

	/**
	 * AproStep 대상 초기화 상세
	 * <중> 본 METHOD에서는 SRC_CTNT단위당 RULE 대상으로 처리하게 되어있어서, 한 SRC_CTNT의 RULE처이에 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 RULE 대상으로 initAproStepSend()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다.
	 * @param aproSndMnRuleVO
	 */
	public void initAproStepSendDtl(ComAproSndMnRuleVO aproSndMnRuleVO) {
		
		log.debug("\n BBBB - ApprovalStepSendBCImpl - initAproStepSendDtl ~~~~~ \n");
		
		List<ApInvHdrVO> csrLst = null;
		String aproStepSendSeqStr = null;
		ComComAproSndLogVO aproSndLogVO = null;
		ComAproRqstRoutVO comAproRqstRoutVO = null;
		ComCsrErrLogVO csrErrLogVO = null;
		
		try {
			
			csrErrLogVO = new ComCsrErrLogVO();
			
			if (aproSndMnRuleVO!=null){
				if (
					(aproSndMnRuleVO.getSrcCtnt()!=null && !aproSndMnRuleVO.getSrcCtnt().trim().equals(""))
					&&
					(aproSndMnRuleVO.getCfmFlg()!=null && aproSndMnRuleVO.getCfmFlg().trim().equals("Y"))
				){
					csrLst = getAproStepSendCsrList(aproSndMnRuleVO);
					for (int i=0; csrLst!=null && csrLst.size()>0 && i<csrLst.size(); i++){
						aproSndLogVO = new ComComAproSndLogVO();
						if (aproSndLogVO!=null){
							aproStepSendSeqStr = getAproStepSendSeq();
							log.debug("\n @@@ aproStepSendSeqStr:" + JSPUtil.getNull(aproStepSendSeqStr) + " @@@\n");
							if (aproStepSendSeqStr!=null && !aproStepSendSeqStr.trim().equals("")){
								if (csrLst.get(i)!=null){
									if (csrLst.get(i).getCsrNo()!=null && !csrLst.get(i).getCsrNo().trim().equals("")){
										aproSndLogVO.setSndLogSeq(aproStepSendSeqStr);
										aproSndLogVO.setSrcCtnt(aproSndMnRuleVO.getSrcCtnt());
										aproSndLogVO.setExeStsCd("N");
										aproSndLogVO.setExeActTpCd(aproSndMnRuleVO.getExeActTpCd());
										aproSndLogVO.setSndRmk("");
										aproSndLogVO.setCsrNo(csrLst.get(i).getCsrNo());
										aproSndLogVO.setCsrTpCd(csrLst.get(i).getCsrTpCd());
										comAproRqstRoutVO = getAproStepInfo(csrLst.get(i).getCsrNo());
										if (comAproRqstRoutVO!=null){
											if (comAproRqstRoutVO.getAproUsrId()!=null && !comAproRqstRoutVO.getAproUsrId().trim().equals("")){
												aproSndLogVO.setAproUsrId(JSPUtil.getNull(comAproRqstRoutVO.getAproUsrId()));
												aproSndLogVO.setAproOfcCd(JSPUtil.getNull(comAproRqstRoutVO.getAproOfcCd()));
												aproSndLogVO.setAproDt(JSPUtil.getNull(comAproRqstRoutVO.getAproDt()));
											} else {
												throw new Exception("Approval Step Info NOT FOUND EXCEPTION! ------------------");
											}
										} else {
											throw new Exception("Approval Step Info NULL EXCEPTION! ------------------");
										}
									} else {
										throw new Exception("CSR NO NULL EXCEPTION! ------------------");
									}
								}
							} else {
								throw new Exception("Approval Step Send Seq EXCEPTION! ------------------");
							}

							/** SND LOG에 저장 및 상태 초기화 **/
							saveAproStepSendCsr(aproSndLogVO);
						}
					}
				}
			}
				
		} catch(EventException ee){
			String err_csr_no = aproSndLogVO!=null?JSPUtil.getNull(aproSndLogVO.getCsrNo()):"";
			if (aproSndLogVO!=null){
				aproSndLogVO.setSndRmk(("["+err_csr_no+"]:"+ee.getMessage()).trim());
				try {
					logAproStepEAIErrMsg(aproSndLogVO);
				} catch (Exception ec) {
					log.error("\n ApprovalStepSendBCImpl.initAproStepSendDtl - logAproStepEAIErrMsg err: " + ec.toString(), ec);
				}				
			}
			try {
				if (csrErrLogVO==null){
					csrErrLogVO = new ComCsrErrLogVO();
				}
				csrErrLogVO.setCsrErrTpCd(CSR_ERROR_TP_APROIF);
				csrErrLogVO.setErrLogRmk(("["+err_csr_no+"]:"+ee.getMessage()).trim());
				logAproCommErrMsg(csrErrLogVO);
			} catch(Exception ec){
				log.error("\n ApprovalStepSendBCImpl.initAproStepSendDtl - logAproCommErrMsg err " + ec.toString(),ec);
			}
			log.error("["+err_csr_no+"]:"+ee.getMessage());
		} catch(Exception ex){
			String err_csr_no = aproSndLogVO!=null?JSPUtil.getNull(aproSndLogVO.getCsrNo()):"";
			if (aproSndLogVO!=null){
				aproSndLogVO.setSndRmk(("["+err_csr_no+"]:"+ex.getMessage()).trim());
				try {
					logAproStepEAIErrMsg(aproSndLogVO);
				} catch (Exception ec) {
					log.error("\n ApprovalStepSendBCImpl.initAproStepSendDtl - logAproStepEAIErrMsg err: " + ec.toString(), ec);
				}
			}
			try {
				if (csrErrLogVO==null){
					csrErrLogVO = new ComCsrErrLogVO();
				}
				csrErrLogVO.setCsrErrTpCd(CSR_ERROR_TP_APROIF);
				csrErrLogVO.setErrLogRmk(("["+err_csr_no+"]:"+ex.getMessage()).trim());
				logAproCommErrMsg(csrErrLogVO);
			} catch(Exception ec){
				log.error("\n ApprovalStepSendBCImpl.initAproStepSendDtl - logAproCommErrMsg err " + ec.toString(),ec);
			}
			log.error("["+err_csr_no+"]:"+ex.getMessage());
		}
		log.debug("\n EEEE - ApprovalStepSendBCImpl - initAproStepSendDtl ~~~~~ \n");
	}
	
	/**
	 * Approval Step info 조회
	 * @param csr_no
	 * @return ComAproRqstRoutVO
	 * @throws EventException
	 */
	public ComAproRqstRoutVO getAproStepInfo(String csr_no) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - getAproStepInfo~~~~~BBBB \n");
		
		try {
			return aproStepSendDbDao.getAproStepInfo(csr_no);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * AproStep 대상 추출 및 docReq 조합
	 * @param eventResponse
	 * @throws EventException
	 */
	public void makeAproStepDocReq(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - ApprovalStepSendBCImpl - makeAproStepDocReq ~~~~~ \n");
		
		List<ComAproSndMnRuleVO> aproSndMnRuleVOLst = eventResponse!=null?(List<ComAproSndMnRuleVO>)((GeneralEventResponse)eventResponse).getCustomData(APROSTEP_SND_RULE):null;
		List<ComComAproSndLogVO> aproSndLogVOLst = null;
		List<List<ComComAproSndLogVO>> aproSndLogVOLstLst = null;

		try {
			aproSndLogVOLstLst = new ArrayList<List<ComComAproSndLogVO>>();
			for (int i=0; aproSndMnRuleVOLst!=null && i<aproSndMnRuleVOLst.size(); i++){
				if (aproSndMnRuleVOLst.get(i).getSrcCtnt()!=null && !aproSndMnRuleVOLst.get(i).getSrcCtnt().trim().equals("")){
					if (aproSndMnRuleVOLst.get(i).getExeActTpCd()!=null && aproSndMnRuleVOLst.get(i).getExeActTpCd().trim().equals("B")){//BATCH인 경우만 해당
						aproSndLogVOLst = getAproStepSendLogList(aproSndMnRuleVOLst.get(i));
						for (int j=0; aproSndLogVOLst!=null && j<aproSndLogVOLst.size(); j++){
							makeAproStepDocReqDtl(aproSndLogVOLst.get(j), aproSndMnRuleVOLst.get(i));
						}
						if (aproSndLogVOLst!=null && aproSndLogVOLst.size()>0){
							aproSndLogVOLstLst.add(aproSndLogVOLst);
						}
					}
				}
			}
			if (aproSndLogVOLstLst!=null && aproSndLogVOLstLst.size()>0){
				eventResponse.setCustomData(APROSTEP_SND_VOS, aproSndLogVOLstLst);	
			}
			log.debug("\n  ssssssss ApprovalStepSendBCImpl - makeAproStepDocReq - aproSndLogVOLstLst.size() : "+(aproSndLogVOLstLst!=null?aproSndLogVOLstLst.size():0)+"--------------- \n");
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}

		log.debug("\n EEEE - ApprovalStepSendBCImpl - makeAproStepDocReq ~~~~~ \n");
	}
	
	/**
	 * AproStep 대상 EDI invoice 대상 추출 및 F/F 조합 상세
	 * <중> 본 METHOD에서는 CSR단위(aproSndLogVO)로 처리하게 되어있어서, 한 CSR에서 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 CSR 대상으로 makeAproStepDocReq()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다. 
	 * @param aproSndLogVO
	 * @param comAproSndMnRuleVO
	 */
	public void makeAproStepDocReqDtl(ComComAproSndLogVO aproSndLogVO, ComAproSndMnRuleVO comAproSndMnRuleVO) {
		
		log.debug("\n BBBB - ApprovalStepSendBCImpl - makeAproStepDocReqDtl ~~~~~ \n");

		DBRowSet rowset = null;
		String sub_sys_id = null;
		String csr_no = null;
		FNS0080004Document docReq = null;
		ComCsrErrLogVO csrErrLogVO = null;
		
		try {
			csrErrLogVO = new ComCsrErrLogVO();
			if (aproSndLogVO!=null && comAproSndMnRuleVO!=null){
				rowset = getAproStepInfoEAIformat(aproSndLogVO);
				if (rowset!=null){
					sub_sys_id = comAproSndMnRuleVO.getSubSysId();
					csr_no = aproSndLogVO.getCsrNo();
					docReq = new ApprovalStepSendEAIDAO().transformAproStep2EAIformat(rowset, sub_sys_id, csr_no);
					if (docReq!=null){
						aproSndLogVO.setDocReq(docReq);
					} else {
						throw new Exception(" ApprovalStepSendBCImpl - makeAproStepDocReqDtl -- docReq NULL EXCEPTION!!!!!!!");
					}
				} else {
					throw new Exception(" ApprovalStepSendBCImpl - makeAproStepDocReqDtl - APROSTEP DBRowSet NULL EXCEPTION!!!!!!!");				
				}
			} else {
				throw new Exception("ApprovalStepSendBCImpl - makeAproStepDocReqDtl -- aproSndLogVO|comAproSndMnRuleVO NULL EXCEPTION!!!!!!!");				
			}
		} catch(EventException ee){
			String err_csr_no = aproSndLogVO!=null?JSPUtil.getNull(aproSndLogVO.getCsrNo()):"";
			if (aproSndLogVO!=null){
				aproSndLogVO.setSndRmk("["+err_csr_no+"]:"+ee.getMessage().trim());
				try {
					logAproStepEAIErrMsg(aproSndLogVO);
				} catch (Exception e) {
					log.error("\n ApprovalStepSendBCImpl.makeAproStepDocReqDtl - logAproStepEAIErrMsg err: " + e.toString(), e);
				}		
			}
			try {
				if (csrErrLogVO==null){
					csrErrLogVO = new ComCsrErrLogVO();
				}
				csrErrLogVO.setCsrErrTpCd(ApprovalStepSendBC.CSR_ERROR_TP_APROIF);
				csrErrLogVO.setErrLogRmk("["+err_csr_no+"]:"+ee.getMessage().trim());
				logAproCommErrMsg(csrErrLogVO);
			} catch(Exception ec){
				log.error("\n ApprovalStepSendBCImpl.makeAproStepDocReqDtl - logAproCommErrMsg err " + ec.toString(), ec);
			}
			log.error("["+err_csr_no+"]:"+ee.getMessage());
		} catch(Exception ex){
			String err_csr_no = aproSndLogVO!=null?JSPUtil.getNull(aproSndLogVO.getCsrNo()):"";
			if (aproSndLogVO!=null){
				aproSndLogVO.setSndRmk(("["+err_csr_no+"]:"+ex.getMessage()).trim());
				try {
					logAproStepEAIErrMsg(aproSndLogVO);
				} catch (Exception e) {
					log.error("\n ApprovalStepSendBCImpl.logAproStepEAIErrMsg - logAproStepEAIErrMsg err: " + e.toString(), e);
				}
			}			
			try {
				if (csrErrLogVO==null){
					csrErrLogVO = new ComCsrErrLogVO();
				}
				csrErrLogVO.setCsrErrTpCd(ApprovalStepSendBC.CSR_ERROR_TP_APROIF);
				csrErrLogVO.setErrLogRmk(("["+err_csr_no+"]:"+ex.getMessage()).trim());
				logAproCommErrMsg(csrErrLogVO);
			} catch(Exception ec){
				log.error("\n ApprovalStepSendBCImpl.logAproCommErrMsg -  err " + ec.toString(), ec);
			}
			log.error("["+err_csr_no+"]:"+ex.getMessage());
		}

		log.debug("\n EEEE - ApprovalStepSendBCImpl - makeAproStepDocReqDtl ~~~~~ \n");
	}
	
	/**
	 * EAI 형식에 맞게 AproStep 상세 정보 조회
	 * @param aproSndLogVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet getAproStepInfoEAIformat(ComComAproSndLogVO aproSndLogVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - getAproStepInfoEAIformat~~~~~BBBB \n");

		try {
			return aproStepSendDbDao.getAproStepInfoEAIformat(aproSndLogVO);
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	
	/**
	 * AproStep 대상 전송 및 상태 UPDATE 처리
	 * @param eventResponse
	 * @throws EventException
	 */
	public void sendAproStep(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - ApprovalStepSendBCImpl - sendAproStep ~~~~~ \n");
		
		List<List<ComComAproSndLogVO>> aproSndLogVOLstLst = eventResponse!=null?(List<List<ComComAproSndLogVO>>)((GeneralEventResponse)eventResponse).getCustomData(APROSTEP_SND_VOS):null;
		List<ComComAproSndLogVO> aproSndLogVOLst = null;
		
		log.debug("\n ApprovalStepSendBCImpl - sendAproStep - aproSndLogVOLst.size() : "+(aproSndLogVOLst!=null?aproSndLogVOLst.size():0)+"--------------- \n");
		
		try {
			for (int i=0; aproSndLogVOLstLst!=null && i<aproSndLogVOLstLst.size(); i++){
				aproSndLogVOLst = aproSndLogVOLstLst.get(i);
				for (int j=0; aproSndLogVOLst!=null && j<aproSndLogVOLst.size(); j++){
					if (aproSndLogVOLst.get(j)!=null){
						sendAproStepDtl(aproSndLogVOLst.get(j));
					}
				}
			}
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
		
		log.debug("\n EEEE - ApprovalStepSendBCImpl - sendAproStep ~~~~~ \n");
	}
	
	/**
	 * AproStep 대상 단위별 상세 전송 및 상태 UPDATE 처리
	 * <중> 본 METHOD에서는 CSR단위(aproSndLogVO)로 처리하게 되어있어서, 한 CSR에서 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 CSR 대상으로 sendAproStep()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다. 
	 * @param aproSndLogVO
	 */
	public void sendAproStepDtl(ComComAproSndLogVO aproSndLogVO) {
		
		log.debug("\n BBBB - ApprovalStepSendBCImpl - sendAproStepDtl ~~~~~ \n");
		
		String chkval = null;
		String retval = null;
		String ifId = null;
		String instanceId = null;
		String strDocReq  = null;
		ComCsrErrLogVO csrErrLogVO = null;
		FNS0080004Document docReq = null;
		
		try {
			csrErrLogVO = new ComCsrErrLogVO();
			if (aproSndLogVO!=null){
				if (aproSndLogVO.getDocReq()!=null){
					if (aproSndLogVO.getSndLogSeq()!=null && !aproSndLogVO.getSndLogSeq().trim().equals("")){
						chkval = checkAproStepB4Send(aproSndLogVO);
						log.debug("\n  chkval:" + JSPUtil.getNull(chkval) + " (" + JSPUtil.getNull(aproSndLogVO.getSndLogSeq()) + " / " +  JSPUtil.getNull(aproSndLogVO.getSndLogSeq()) + ")----------------------   \n");
						if (chkval!=null && chkval.trim().equals("N")){
							docReq = aproSndLogVO.getDocReq();
							if (docReq!=null){
								ifId = "FNS008-0004";
								strDocReq	= docReq.toString();
								instanceId	= docReq.getFNS0080004()!=null?(docReq.getFNS0080004().getEAIHeader()!=null?JSPUtil.getNull(docReq.getFNS0080004().getEAIHeader().getInstanceId()):""):"";
								log.debug("\n\n"
										+"\n - ifId:"+JSPUtil.getNull(ifId)
										+"\n - instanceId:"+JSPUtil.getNull(instanceId)
										+"\n - strDocReq:"+JSPUtil.getNull(strDocReq)
										+"\n\n");
								if (strDocReq!=null && !strDocReq.trim().equals("")){
									if (instanceId!=null && !instanceId.trim().equals("")){
										retval = new ApprovalStepSendEAIDAO().transferAproStep2EAI(ifId,instanceId,strDocReq);
										log.error("\n @@@@ transferAproStep2EAI() - retval : " + JSPUtil.getNull(retval)
												+ " ---- [" + JSPUtil.getNull(aproSndLogVO.getSndLogSeq()) +  "]\n");
										if (retval!=null && retval.trim().equals("SUCCESS")){
											completeAproStepSndLogSts(aproSndLogVO);
										} else {
											aproSndLogVO.setSndRmk("transferAproStep2EAI Failure!!!");
											throw new Exception("transferAproStep2EAI Failure!!!");
										}			
									} else {
										throw new Exception("InstanceId NULL EXCEPTION!!!!!!!!!");
									}
								} else {
									throw new Exception("strDocReq NULL EXCEPTION!!!!!!!!!");
								}
							} else {
								throw new Exception("docReq NULL EXCEPTION!!!!!!!!!");
							}
						} else {
							throw new Exception("AproStep SND LOG Not Available!!!!!");
						}
					} else {
						throw new Exception("AproStep SND LOG PK EXCEPTION!!!!!!!!!");
					}
				} else {
					throw new Exception("AproStep SND LOG docReq NULL EXCEPTION!!!!!!!!!");
				}
			} else {
				throw new Exception("AproStep SND LOG NULL EXCEPTION!!!!!!!!!");
			}
		} catch(EventException ee){
			String err_csr_no = aproSndLogVO!=null?JSPUtil.getNull(aproSndLogVO.getCsrNo()):"";
			if (aproSndLogVO!=null){
				aproSndLogVO.setSndRmk(("["+err_csr_no+"]:"+ee.getMessage()).trim());
				try {
					logAproStepEAIErrMsg(aproSndLogVO);
				} catch (Exception e) {
					log.error("\n ApprovalStepSendBCImpl.sendAproStepDtl - logAproStepEAIErrMsg err: " + e.toString(), e);
				}				
			}
			try {
				if (csrErrLogVO==null){
					csrErrLogVO = new ComCsrErrLogVO();
				}
				csrErrLogVO.setCsrErrTpCd(ApprovalStepSendBC.CSR_ERROR_TP_APROIF);
				csrErrLogVO.setErrLogRmk(("["+err_csr_no+"]:"+ee.getMessage()).trim());
				logAproCommErrMsg(csrErrLogVO);
			} catch(Exception ec){
				log.error("\n ApprovalStepSendBCImpl.sendAproStepDtl - logAproCommErrMsg err: " + ec.toString(), ec);
			}
			log.error("["+err_csr_no+"]:"+ee.getMessage());
		} catch(Exception ex){
			String err_csr_no = aproSndLogVO!=null?JSPUtil.getNull(aproSndLogVO.getCsrNo()):"";
			if (aproSndLogVO!=null){
				aproSndLogVO.setSndRmk(("["+err_csr_no+"]:"+ex.getMessage()).trim());
				try {
					logAproStepEAIErrMsg(aproSndLogVO);
				} catch (Exception e) {
					log.error("\n ApprovalStepSendBCImpl.sendAproStepDtl - logAproStepEAIErrMsg err: " + e.toString(), e);
				}	
			}
			try {
				if (csrErrLogVO==null){
					csrErrLogVO = new ComCsrErrLogVO();
				}
				csrErrLogVO.setCsrErrTpCd(ApprovalStepSendBC.CSR_ERROR_TP_APROIF);
				csrErrLogVO.setErrLogRmk(("["+err_csr_no+"]:"+ex.getMessage()).trim());
				logAproCommErrMsg(csrErrLogVO);
			} catch(Exception ec){
				log.error("\n ApprovalStepSendBCImpl.sendAproStepDtl err: " + ec.toString(), ec);
			}
			log.error("["+err_csr_no+"]:"+ex.getMessage());
		}
		log.debug("\n EEEE - ApprovalStepSendBCImpl - sendAproStepDtl ~~~~~ \n");
	}
	
	/**
	 * AproStep 대상 전송 전 DB에서의 전송 대기 가능(ERROR나 CANCEL된게 아닌지) 상태를 확인한다. 
	 * @param aproSndLogVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAproStepB4Send(ComComAproSndLogVO aproSndLogVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - checkAproStepB4Send~~~~~BBBB \n");

		try {
			return aproStepSendDbDao.checkAproStepB4Send(aproSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * AproStep 전송 후 완료 표시하기
	 * @param aproSndLogVO
	 * @throws EventException
	 */
	public void completeAproStepSndLogSts(ComComAproSndLogVO aproSndLogVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - completeAproStepSndLogSts~~~~~BBBB \n");
		
		try {
			aproStepSendDbDao.completeAproStepSndLogSts(aproSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  ApprovalStepSendBCImpl - completeAproStepSndLogSts~~~~~EEEE \n");
	}

	/**
	 * AproStep Log관리 table에 Error 남기기
	 * @param aproSndLogVO
	 * @throws EventException
	 */
	public void logAproStepEAIErrMsg(ComComAproSndLogVO aproSndLogVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - logAproStepEAIErrMsg~~~~~BBBB \n");
		
		try {
			aproStepSendDbDao.logAproStepEAIErrMsg(aproSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  ApprovalStepSendBCImpl - logAproStepEAIErrMsg~~~~~EEEE \n");
	}
	
	/**
	 * 공통 Error table에 Error 남기기
	 * @param aproSndLogVO
	 * @throws EventException
	 */
	public void logAproCommErrMsg(ComCsrErrLogVO aproSndLogVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - logAproCommErrMsg~~~~~BBBB \n");
		
		try {
			aproStepSendDbDao.logAproCommErrMsg(aproSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  ApprovalStepSendBCImpl - logAproCommErrMsg~~~~~EEEE \n");
	}
	
	/**
	 * AproStep 전송 규칙 정보 조회
	 * @param act_tp_cd
	 * @return List<ComAproSndMnRuleVO>
	 * @throws EventException
	 */
	public List<ComAproSndMnRuleVO> getAproStepSendMainRule(String act_tp_cd) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - getAproStepSendMainRule~~~~~BBBB \n");
		
		try {
			return aproStepSendDbDao.getAproStepSendMainRule(act_tp_cd);
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * AproStep SEND docReq 생성 대상 조회
	 * @param aproSndMnRuleVO
	 * @return List<ComComAproSndLogVO>
	 * @throws EventException
	 */
	public List<ComComAproSndLogVO> getAproStepSendLogList(ComAproSndMnRuleVO aproSndMnRuleVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - getAproStepSendLogList~~~~~BBBB \n");
		
		try {
			return aproStepSendDbDao.getAproStepSendLogList(aproSndMnRuleVO);
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * AproStep LOG용 주 sequence 구하기
	 * @return String
	 * @throws EventException
	 */
	public String getAproStepSendSeq() throws EventException {
		log.debug("\n ApprovalStepSendBCImpl - getAproStepSendSeq~~~~~ \n");

		try {
			return JSPUtil.getNull(aproStepSendDbDao.createAproStepSendSeq());
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * AproStep 대상 EDI invoice 대상 조회
	 * @param aproSndMnRuleVO
	 * @return List<ApInvHdrVO>
	 * @throws EventException
	 */
	public List<ApInvHdrVO> getAproStepSendCsrList(ComAproSndMnRuleVO aproSndMnRuleVO)throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - getAproStepSendCsrList~~~~~BBBB \n");
		
		try {
			return aproStepSendDbDao.getAproStepSendCsrList(aproSndMnRuleVO);
		} catch(DAOException e){
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * AproStep 대상 저장 및 초기화
	 * @param aproSndLogVO
	 * @throws EventException
	 */
	public void saveAproStepSendCsr(ComComAproSndLogVO aproSndLogVO) throws EventException {
		log.debug("\n  ApprovalStepSendBCImpl - saveAproStepSendCsr~~~~~BBBB \n");
		
		try {
			aproStepSendDbDao.createAproStepSendLog(aproSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * ApprovalStepSendBCImpl 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		aproStepSendDbDao = null;
	}
}
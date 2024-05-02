/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESeBillingAckManageBCImpl.java
*@FileTitle : TES eBilling EDI ACK 처리
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-01-22 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingAckManageDBDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.integration.TESeBillingAckManageEAIDAO;
import com.hanjin.apps.alps.esd.tes.edi.ebilling.vo.ComTesEdiAckSndLogVO;

import com.hanjin.syscommon.common.table.TesEdiSoErrLogVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesEdiAckSndLogInvVO;
import com.hanjin.syscommon.common.table.TesEdiSndAckMnRuleVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see TESeBillingAckManageBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESeBillingAckManageBCImpl extends BasicCommandSupport implements TESeBillingAckManageBC {

	/**
	 * TES eBilling ACK 처리용 DBDAO
	 */
	private transient TESeBillingAckManageDBDAO ediAckDbDao = null;
	
	public TESeBillingAckManageBCImpl(){
		this.ediAckDbDao = new TESeBillingAckManageDBDAO();
	}

	/**
	 * ACK 대상 EDI invoice 대상 초기화
	 * # 구동방식이 BATCH든 EDI로 바로든지 해당하는 ACK RULE을 조회해서 수행 단위 ROW수만큼씩 
	 * @param eventResponse
	 * @throws EventException
	 */
	public void initSendAckEdiInv(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - initSendAckEdiInv ~~~~~ \n");
		
		String ack_act_tp_cd = eventResponse!=null?(String)((GeneralEventResponse)eventResponse).getCustomData(ACK_ACT_TP_CD):"";

		log.debug("\n **** ack_act_tp_cd : " + JSPUtil.getNull(ack_act_tp_cd) + " ********************************* \n");
		
		List<TesEdiSndAckMnRuleVO> tesEdiSndAckMainRuleVOLst = null;
		
		try {
			if (ack_act_tp_cd!=null && !ack_act_tp_cd.trim().equals("")){
				tesEdiSndAckMainRuleVOLst = getAckSendAckMainRule(ack_act_tp_cd);
				
				log.debug("\n **** tesEdiSndAckMainRuleVOLst.size() : " + JSPUtil.getNull(tesEdiSndAckMainRuleVOLst.size()) + " ********************************* \n");
				
				for (int a=0; tesEdiSndAckMainRuleVOLst!=null && a<tesEdiSndAckMainRuleVOLst.size(); a++){
					initSendAckEdiInvDtl(tesEdiSndAckMainRuleVOLst.get(a));
					continue;
				}
			}
		} catch(EventException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ec){
			throw new EventException(ec.getMessage());
		}

		eventResponse.setCustomData(ACK_SND_RULE, tesEdiSndAckMainRuleVOLst);			
		
		log.debug("\n EEEE - TESeBillingAckManageBCImpl - initSendAckEdiInv ~~~~~ \n");
	}

	/**
	 * ACK 대상 EDI invoice 대상 초기화 상세
	 * <중> 본 METHOD에서는 VNDR단위당 RULE 대상으로 처리하게 되어있어서, 한 VNDR의 RULE처이에 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 RULE 대상으로 initSendAckEdiInv()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다.
	 * @param tesEdiSndAckMainRuleVO
	 */
	public void initSendAckEdiInvDtl(TesEdiSndAckMnRuleVO tesEdiSndAckMainRuleVO) {
		
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - initSendAckEdiInvDtl ~~~~~ \n");
		
		List<TesEdiSoHdrVO> ediInvLst = null;
		String ackSendDtStr = null;
		String ackSendSeqStr = null;
		String ackFileSeqStr = null;
		String ackEdiHdrMsgStr = null;
		ComTesEdiAckSndLogVO tesEdiAckSndLogVO = null;
		TesEdiAckSndLogInvVO tesEdiAckSndLogInvVO = null;
		List<TesEdiAckSndLogInvVO> tesEdiAckSndLogInvVOLst = null;
		TesEdiSoErrLogVO tesEdiErrLogVO = null;
		
		try {
			tesEdiErrLogVO = new TesEdiSoErrLogVO();
			
			if (tesEdiSndAckMainRuleVO!=null){
				if (
					(tesEdiSndAckMainRuleVO.getEdiVndrSeq()!=null && !tesEdiSndAckMainRuleVO.getEdiVndrSeq().trim().equals(""))
					&&
					(tesEdiSndAckMainRuleVO.getCfmFlg()!=null && tesEdiSndAckMainRuleVO.getCfmFlg().trim().equals("Y"))
				){
					
					ediInvLst = getAckEdiInvList(tesEdiSndAckMainRuleVO);
					if (ediInvLst!=null && ediInvLst.size()>0){

						ackSendDtStr = getDtStr(tesEdiSndAckMainRuleVO.getInvOfcCd());
						log.debug("\n @@@@@ ackSendDt:"+JSPUtil.getNull(ackSendDtStr)+"------------ @@@@@ \n");
						if (ackSendDtStr!=null && !ackSendDtStr.trim().equals("") && ackSendDtStr.length()>=8){
							tesEdiAckSndLogVO = new ComTesEdiAckSndLogVO();
							if (tesEdiAckSndLogVO!=null){
								
								ackSendSeqStr = getAckSendSeq();
								log.debug("\n @@@ ackSendSeqStr:" + JSPUtil.getNull(ackSendSeqStr) + " @@@\n");
								if (ackSendSeqStr!=null && !ackSendSeqStr.trim().equals("")){
									
									tesEdiAckSndLogVO.setEdiSndDt(ackSendDtStr.substring(0,8));
									tesEdiAckSndLogVO.setSndLogSeq(ackSendSeqStr);
									tesEdiAckSndLogVO.setAckSndStsCd("N");
									tesEdiAckSndLogVO.setAckActTpCd(tesEdiSndAckMainRuleVO.getAckActTpCd());
									tesEdiAckSndLogVO.setRcvrId(tesEdiSndAckMainRuleVO.getRcvrId());
									tesEdiAckSndLogVO.setSndrId(tesEdiSndAckMainRuleVO.getSndrId());
									tesEdiAckSndLogVO.setVndrSeq(tesEdiSndAckMainRuleVO.getEdiVndrSeq());
									tesEdiAckSndLogVO.setOfcCd(tesEdiSndAckMainRuleVO.getInvOfcCd());
									
									if (tesEdiSndAckMainRuleVO.getFileSeqUseFlg()!=null && tesEdiSndAckMainRuleVO.getFileSeqUseFlg().trim().equalsIgnoreCase("Y")){ 
										/* HIT FILE SEQ를 사용여부 */
										ackFileSeqStr = getAckFileSeq();
										if (ackFileSeqStr!=null && !ackFileSeqStr.trim().equals("")){
											tesEdiAckSndLogVO.setFileSeq(ackFileSeqStr);	
										} else {
											log.error("\n ackFileSeq EXCEPTION! ------------------  \n");
										}
									}

									ackEdiHdrMsgStr = "$$$MSGSTART:" + 
													JSPUtil.getRPAD(tesEdiSndAckMainRuleVO.getSndrId(),20," ") +
													JSPUtil.getRPAD(tesEdiSndAckMainRuleVO.getRcvrId(),20," ") +
													JSPUtil.getRPAD("INVACK",10," ") +  
													("TES" + ackSendDtStr.substring(2,8) +  JSPUtil.getLPAD(ackSendSeqStr,5,"0"))
													;
									tesEdiAckSndLogVO.setEdiMsg(ackEdiHdrMsgStr);
									
									tesEdiAckSndLogInvVOLst = new ArrayList<TesEdiAckSndLogInvVO>();
									for (int j=0; ediInvLst!=null && ediInvLst.size()>0 && j<ediInvLst.size(); j++){
										if (ediInvLst.get(j)!=null){
											if ((ediInvLst.get(j).getTmlEdiSoOfcCtyCd()!=null && !ediInvLst.get(j).getTmlEdiSoOfcCtyCd().trim().equals("")) && 
												(ediInvLst.get(j).getTmlEdiSoSeq()!=null && !ediInvLst.get(j).getTmlEdiSoSeq().trim().equals(""))){
												tesEdiAckSndLogInvVO = new TesEdiAckSndLogInvVO();
												tesEdiAckSndLogInvVO.setEdiSndDt(tesEdiAckSndLogVO.getEdiSndDt());
												tesEdiAckSndLogInvVO.setSndLogSeq(tesEdiAckSndLogVO.getSndLogSeq());
												tesEdiAckSndLogInvVO.setTmlEdiSoOfcCtyCd(ediInvLst.get(j).getTmlEdiSoOfcCtyCd());
												tesEdiAckSndLogInvVO.setTmlEdiSoSeq(ediInvLst.get(j).getTmlEdiSoSeq());
												tesEdiAckSndLogInvVOLst.add(tesEdiAckSndLogInvVO);
											} else {
												log.error("\n TmlEdiSoSEQ NULL EXCEPTION! ------------------  \n");
											}
										}
									}
									
								} else {
									log.error("\n ackSendSeq EXCEPTION! ------------------  \n");
								}
							}

						} else {
							log.error("\n ackSendDt EXCEPTION! ------------------  \n");
						}
						
						if (tesEdiAckSndLogVO!=null && tesEdiAckSndLogInvVOLst!=null && tesEdiAckSndLogInvVOLst.size()>0){
							/** 저장 및 초기화 **/
							saveAckEdiInv(tesEdiAckSndLogVO, tesEdiAckSndLogInvVOLst);
						}
					}
				}
			}
				
		} catch(EventException ee){
			log.error(ee.getMessage());
			String ackSndLogKeyVal = tesEdiAckSndLogVO!=null?JSPUtil.getNull("["+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt())+"|"+JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+"]:"):"";
			if (tesEdiAckSndLogVO!=null){
				tesEdiAckSndLogVO.setEdiRmk(JSPUtil.getNull(ackSndLogKeyVal)+ee.getMessage());
				try {
					logAckEDIErrMsg(tesEdiAckSndLogVO);
				} catch (Exception ec) {
					log.error("\n TESeBillingAckManageBCImpl - logEDIErrMsg err: " + ec.toString(), ec);
				}				
			} else {
				log.error("\n ackSndLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			if (tesEdiErrLogVO==null){
				tesEdiErrLogVO = new TesEdiSoErrLogVO();
			}
			tesEdiErrLogVO.setErrLogRmk(JSPUtil.getNull(ackSndLogKeyVal)+ee.getMessage().trim());
			try {
				logAckCommErrMsg(tesEdiErrLogVO);
			} catch(Exception ec){
				log.error("\n TESeBillingAckManageBCImpl - logAckCommErrMsg err " + ec.toString(), ec);
			}
		} catch(Exception ex){
			log.error(ex.getMessage());
			String ackSndLogKeyVal = tesEdiAckSndLogVO!=null?JSPUtil.getNull("["+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt())+"|"+JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+"]:"):"";
			if (tesEdiAckSndLogVO!=null){
				tesEdiAckSndLogVO.setEdiRmk(JSPUtil.getNull(ackSndLogKeyVal)+ex.getMessage());
				try {
					logAckEDIErrMsg(tesEdiAckSndLogVO);
				} catch (Exception ec) {
					log.error("\n TESeBillingAckManageBCImpl - logEDIErrMsg err: " + ec.toString(), ec);
				}
			} else {
				log.error("\n ackSndLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			if (tesEdiErrLogVO==null){
				tesEdiErrLogVO = new TesEdiSoErrLogVO();
			}
			tesEdiErrLogVO.setErrLogRmk(JSPUtil.getNull(ackSndLogKeyVal)+ex.getMessage().trim());
			try {
				logAckCommErrMsg(tesEdiErrLogVO);
			} catch(Exception ec){
				log.error("\n TESeBillingAckManageBCImpl - logAckCommErrMsg err " + ec.toString(), ec);
			}
		}
		
		log.debug("\n EEEE - TESeBillingAckManageBCImpl - initSendAckEdiInvDtl ~~~~~ \n");
	}
	
	/**
	 * ACK 대상 EDI invoice 대상 추출 및 F/F 조합
	 * @param eventResponse
	 * @throws EventException
	 */
	public void makeFFAckEdiInv(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - makeFFAckEdiInv ~~~~~ \n");
		
		List<TesEdiSndAckMnRuleVO> tesEdiSndAckMainRuleVOLst = (List<TesEdiSndAckMnRuleVO>)((GeneralEventResponse)eventResponse).getCustomData(ACK_SND_RULE);
		List<ComTesEdiAckSndLogVO> tesEdiAckSndLogVOLst = null;
		List<List<ComTesEdiAckSndLogVO>> tesEdiAckSndLogVOLstLst = null;

		try {
			tesEdiAckSndLogVOLstLst = new ArrayList<List<ComTesEdiAckSndLogVO>>();
			for (int i=0; tesEdiSndAckMainRuleVOLst!=null && i<tesEdiSndAckMainRuleVOLst.size(); i++){
				if (tesEdiSndAckMainRuleVOLst.get(i).getEdiVndrSeq()!=null && !tesEdiSndAckMainRuleVOLst.get(i).getEdiVndrSeq().trim().equals("")){
					if (tesEdiSndAckMainRuleVOLst.get(i).getAckActTpCd()!=null && tesEdiSndAckMainRuleVOLst.get(i).getAckActTpCd().trim().equals("B")){//BATCH인 경우만 해당
						tesEdiAckSndLogVOLst = getAckFFLogList(tesEdiSndAckMainRuleVOLst.get(i));
						for (int j=0; tesEdiAckSndLogVOLst!=null && j<tesEdiAckSndLogVOLst.size(); j++){
							makeFFAckEdiInvDtl(tesEdiAckSndLogVOLst.get(j));
							continue;
						}
						if (tesEdiAckSndLogVOLst!=null && tesEdiAckSndLogVOLst.size()>0){
							tesEdiAckSndLogVOLstLst.add(tesEdiAckSndLogVOLst);
						}
					}
				}
			}
			if (tesEdiAckSndLogVOLstLst!=null && tesEdiAckSndLogVOLstLst.size()>0){
				eventResponse.setCustomData(ACK_SND_VOS, tesEdiAckSndLogVOLstLst);
			}
		} catch(EventException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}

		log.debug("\n EEEE - TESeBillingAckManageBCImpl - makeFFAckEdiInv ~~~~~ \n");
	}
	
	/**
	 * ACK 대상 EDI invoice 대상 추출 및 F/F 조합 상세
	 * <중> 본 METHOD에서는 ACK전송단위(tesEdiAckSndLogVO)로 처리하게 되어있어서, 한 ACK전송단위에서 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 ACK전송대상으로 makeFFAckEdiInv()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다. 
	 * @param tesEdiAckSndLogVO
	 */
	public void makeFFAckEdiInvDtl(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) {
		
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - makeFFAckEdiInvDtl ~~~~~ \n");

		StringBuffer ff  = null;
		StringBuffer tmp = null;
		String ackSendDt = null;
		List<TesEdiSoHdrVO>	tesEdiSoHdrVOLst = null;
		TesEdiSoErrLogVO tesEdiErrLogVO = null;
		
		try {
			tesEdiErrLogVO = new TesEdiSoErrLogVO();
			if (tesEdiAckSndLogVO!=null){
				tesEdiSoHdrVOLst = getAckFFLogInvList(tesEdiAckSndLogVO);
				if (tesEdiSoHdrVOLst!=null && tesEdiSoHdrVOLst.size()>0){

					ff = new StringBuffer();
					
					/**
					 *   <꼭> 나중에 시간되면 VNDR별로  MSG_HDR 및 TAG별로 각각이 조합하고 내부 속성과 값도 설정하게 CLASS로 분리 할것
					 *   --> ACK RULE에 등록된 IMPL TP CD를 사용요  
					 **/
					
					if (tesEdiAckSndLogVO.getEdiMsg()!=null 
							&& !tesEdiAckSndLogVO.getEdiMsg().trim().equals("")
							&& tesEdiAckSndLogVO.getEdiMsg().startsWith("$$$MSGSTART:")
					){

						/** EDI MSG HDR **/
						tmp = null;
						tmp = new StringBuffer();
						tmp.append(JSPUtil.getNull(tesEdiAckSndLogVO.getEdiMsg())).append(CHR10);
						ff.append(tmp.toString());
						
						/** HDR **/
						tmp = null;
						tmp = new StringBuffer();
						tmp.append("{HEADER_RECORD").append(CHR10);
						tmp.append("HEADER_RECORD_CODE:AAA").append(CHR10);
						tmp.append("RECORD_DESCRIPTION:ACKNOWLEDGMENT").append(CHR10);
						tmp.append("SENDER_ID:" + JSPUtil.getNull(tesEdiAckSndLogVO.getSndrId())).append(CHR10);
						tmp.append("RECIPIENT_ID:" + JSPUtil.getNull(tesEdiAckSndLogVO.getRcvrId())).append(CHR10);
						ackSendDt = getDtStr(tesEdiAckSndLogVO.getOfcCd());
						if (ackSendDt!=null && !ackSendDt.trim().equals("") && ackSendDt.length()>=8){
							tmp.append("FILE_CREATION_DATE:" + JSPUtil.getNull(ackSendDt.substring(0,8))).append(CHR10);
							tmp.append("FILE_CREATION_TIME:" + JSPUtil.getNull(ackSendDt.substring(2,8))).append(CHR10);
						}
						tmp.append("MESSAGE_TYPE:INVACK").append(CHR10);
						tmp.append("SEQUENCE_NUMBER:" + JSPUtil.getLPAD(JSPUtil.getNull(tesEdiAckSndLogVO.getFileSeq()),5,"0")).append(CHR10);
						tmp.append("}HEADER_RECORD").append(CHR10);
						ff.append(tmp.toString());
						
						/** DTL **/
						for (int v=0; tesEdiSoHdrVOLst!=null && v<tesEdiSoHdrVOLst.size(); v++){
							if (tesEdiSoHdrVOLst.get(v)!=null){
								tmp = null;
								tmp = new StringBuffer();
								tmp.append("{DETAIL_RECORD").append(CHR10);
								tmp.append("DETAIL_RECORD_CODE:DDD").append(CHR10);
								tmp.append("DOCUMENT_TYPE:O").append(CHR10);
								tmp.append("DOCUMENT_NUMBER:" + JSPUtil.getNull(tesEdiSoHdrVOLst.get(v).getInvNo())).append(CHR10);
								if (ackSendDt!=null && !ackSendDt.trim().equals("") && ackSendDt.length()>=8){
									tmp.append("DOCUMENT_DATE:" + JSPUtil.getNull(ackSendDt.substring(0,8))).append(CHR10);
								}
								tmp.append("TOTAL_NO_OF_ITEMS:").append("    ").append(CHR10);
								tmp.append("TOTAL_NO_OF_AMOUNT:").append(JSPUtil.getLPAD(tesEdiSoHdrVOLst.get(v).getTtlInvAmt(),13,"0")).append(CHR10);
								tmp.append("}DETAIL_RECORD").append(CHR10);
								ff.append(tmp.toString());
							}
						}
						
						/** TRL **/
						tmp = null;
						tmp = new StringBuffer();
						tmp.append("{TRAILER_RECORD").append(CHR10);
						tmp.append("TRAILER_RECORD_CODE:ZZZ").append(CHR10);
						tmp.append("TOTAL_NUMBER_OF_RECORDS:" + JSPUtil.getLPAD((tesEdiSoHdrVOLst!=null&&tesEdiSoHdrVOLst.size()>0?Integer.toString(tesEdiSoHdrVOLst.size()):"0"),4,"0")).append(CHR10);
						tmp.append("}TRAILER_RECORD");
						ff.append(tmp.toString());	
						
					} else {
						log.error("\n Malformed ACK SEND EDI MSG found Exception!!! \n");
						throw new Exception("\n Malformed ACK SEND EDI MSG found Exception!!! \n");						
					}
				}
			}
			
			tesEdiAckSndLogVO.setFF(ff.toString());
										
		} catch(EventException ee){
			log.error(ee.getMessage());
			String ackSndLogKeyVal = tesEdiAckSndLogVO!=null?JSPUtil.getNull("["+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt())+"|"+JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+"]:"):"";
			if (tesEdiAckSndLogVO!=null){
				tesEdiAckSndLogVO.setEdiRmk(JSPUtil.getNull(ackSndLogKeyVal)+ee.getMessage());
				try {
					logAckEDIErrMsg(tesEdiAckSndLogVO);
				} catch (Exception ec) {
					log.error("\n TESeBillingAckManageBCImpl - logEDIErrMsg err: " + ec.toString(), ec);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			if (tesEdiErrLogVO==null){
				tesEdiErrLogVO = new TesEdiSoErrLogVO();
			}
			tesEdiErrLogVO.setErrLogRmk(JSPUtil.getNull(ackSndLogKeyVal)+ee.getMessage().trim());
			try {
				logAckCommErrMsg(tesEdiErrLogVO);
			} catch(Exception ec){
				log.error("\n TESeBillingAckManageBCImpl - logAckCommErrMsg err " + ec.toString(), ec);
			}
		} catch(Exception ex){
			log.error(ex.getMessage());
			String ackSndLogKeyVal = tesEdiAckSndLogVO!=null?JSPUtil.getNull("["+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt())+"|"+JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+"]:"):"";
			if (tesEdiAckSndLogVO!=null){
				tesEdiAckSndLogVO.setEdiRmk(JSPUtil.getNull(ackSndLogKeyVal)+ex.getMessage());
				try {
					logAckEDIErrMsg(tesEdiAckSndLogVO);
				} catch (Exception ec) {
					log.error("\n TESeBillingAckManageBCImpl - logEDIErrMsg err: " + ec.toString(), ec);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			if (tesEdiErrLogVO==null){
				tesEdiErrLogVO = new TesEdiSoErrLogVO();
			}
			tesEdiErrLogVO.setErrLogRmk(JSPUtil.getNull(ackSndLogKeyVal)+ex.getMessage().trim());
			try {
				logAckCommErrMsg(tesEdiErrLogVO);
			} catch(Exception ec){
				log.error("\n TESeBillingAckManageBCImpl - logAckCommErrMsg err " + ec.toString(), ec);
			}
		}

		log.debug("\n EEEE - TESeBillingAckManageBCImpl - makeFFAckEdiInvDtl ~~~~~ \n");
	}
	
	
	/**
	 * ACK 대상 EDI invoice 대상 건당 전송 및 상태 UPDATE 처리
	 * @param eventResponse
	 * @throws EventException
	 */
	public void sendAckEdiInv(EventResponse eventResponse) throws EventException {
		
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - sendAckEdiInv ~~~~~ \n");

		List<List<ComTesEdiAckSndLogVO>> tesEdiAckSndLogVOLstLst = eventResponse!=null?(List<List<ComTesEdiAckSndLogVO>>)((GeneralEventResponse)eventResponse).getCustomData(ACK_SND_VOS):null;
		List<ComTesEdiAckSndLogVO> tesEdiAckSndLogVOLst = null;
		
		try {
			for (int i=0; tesEdiAckSndLogVOLstLst!=null && i<tesEdiAckSndLogVOLstLst.size(); i++){
				tesEdiAckSndLogVOLst = tesEdiAckSndLogVOLstLst.get(i);
				for (int j=0; tesEdiAckSndLogVOLst!=null && j<tesEdiAckSndLogVOLst.size(); j++){
					if (tesEdiAckSndLogVOLst.get(j)!=null){
						sendAckEdiInvDtl(tesEdiAckSndLogVOLst.get(j));
					}
					continue;
				}
				continue;
			}
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
		
		log.debug("\n EEEE - TESeBillingAckManageBCImpl - sendAckEdiInv ~~~~~ \n");
	}
	
	/**
	 * ACK 대상 EDI invoice 대상 건당 단위별 상세 전송 및 상태 UPDATE 처리
	 * <중> 본 METHOD에서는 ACK전송단위(tesEdiAckSndLogVO)로 처리하게 되어있어서, 한 ACK전송단위에서 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 ACK전송대상으로 sendAckEdiInv()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다. 
	 * @param tesEdiAckSndLogVO
	 */
	public void sendAckEdiInvDtl(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) {
		
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - sendAckEdiInvDtl ~~~~~ \n");
		
		String chkval = null;
		String retval = null;
		TesEdiSoErrLogVO tesEdiErrLogVO = null;
		
		try {
			tesEdiErrLogVO = new TesEdiSoErrLogVO();
			if (tesEdiAckSndLogVO!=null){
				if (tesEdiAckSndLogVO.getFF()!=null && !tesEdiAckSndLogVO.getFF().trim().equals("")){
					if (
							(tesEdiAckSndLogVO.getEdiSndDt()!=null && !tesEdiAckSndLogVO.getEdiSndDt().trim().equals(""))
							&&
							(tesEdiAckSndLogVO.getSndLogSeq()!=null && !tesEdiAckSndLogVO.getSndLogSeq().trim().equals(""))
					){
						chkval = checkAckEDILogB4Send(tesEdiAckSndLogVO);
						log.debug("\n  chkval:" + JSPUtil.getNull(chkval) + " (" + JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()) + " / " +  JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq()) + ")----------------------   \n");
						if (chkval!=null && chkval.trim().equals("N")){
							/**
							 *  ACK_SND_STS_CD : ACK 송신 상태 CODE를 참조
							 */
//							log.debug("\n  FF:\n" + JSPUtil.getNull(tesEdiAckSndLogVO.getFF()) + "----------------------   \n");
							if (tesEdiAckSndLogVO.getFF()!=null && !tesEdiAckSndLogVO.getFF().trim().equals("")){
								retval = new TESeBillingAckManageEAIDAO().sendEDIMQ(tesEdiAckSndLogVO.getFF());
								log.error("\n @@@@ sendEDIMQ() - retval : " + JSPUtil.getNull(retval) 
										+ " ---- [" + JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()) + " / " + JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq()) +  "]\n");
								if (retval!=null && retval.trim().equals("SUCCESS")){
									completeAckEdiSndLogSts(tesEdiAckSndLogVO);
								} else {
									tesEdiAckSndLogVO.setEdiRmk("sendEDIMQ Failure!!!");
									logAckEDIErrMsg(tesEdiAckSndLogVO);
								}
							}
						} else {
							log.error("\n ACK SND LOG Not Available - KEY ("+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt()) + " / " + JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+")  \n");
							throw new Exception("ACK SND LOG Not Available!!!!!");
						}
					} else {
						log.error("\n ACK SND LOG PK EXCEPTION!!!!!!!!!  \n");
						throw new Exception("ACK SND LOG PK EXCEPTION!!!!!!!!!");
					}
				}
			}
		} catch(EventException ee){
			log.error(ee.getMessage());
			String ackSndLogKeyVal = tesEdiAckSndLogVO!=null?JSPUtil.getNull("["+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt())+"|"+JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+"]:"):"";
			if (tesEdiAckSndLogVO!=null){
				tesEdiAckSndLogVO.setEdiRmk(JSPUtil.getNull(ackSndLogKeyVal)+ee.getMessage());
				try {
					logAckEDIErrMsg(tesEdiAckSndLogVO);
				} catch (Exception ec) {
					log.error("\n TESeBillingAckManageBCImpl - logEDIErrMsg err: " + ec.toString(), ec);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			if (tesEdiErrLogVO==null){
				tesEdiErrLogVO = new TesEdiSoErrLogVO();
			}
			tesEdiErrLogVO.setErrLogRmk(JSPUtil.getNull(ackSndLogKeyVal)+ee.getMessage().trim());
			try {
				logAckCommErrMsg(tesEdiErrLogVO);
			} catch(Exception ec){
				log.error("\n TESeBillingAckManageBCImpl - logAckCommErrMsg err " + ec.toString(), ec);
			}
		} catch(Exception ex){
			log.error(ex.getMessage());
			String ackSndLogKeyVal = tesEdiAckSndLogVO!=null?JSPUtil.getNull("["+JSPUtil.getNull(tesEdiAckSndLogVO.getEdiSndDt())+"|"+JSPUtil.getNull(tesEdiAckSndLogVO.getSndLogSeq())+"]:"):"";
			if (tesEdiAckSndLogVO!=null){
				tesEdiAckSndLogVO.setEdiRmk(JSPUtil.getNull(ackSndLogKeyVal)+ex.getMessage());
				try {
					logAckEDIErrMsg(tesEdiAckSndLogVO);
				} catch (Exception ec) {
					log.error("\n TESeBillingAckManageBCImpl - logEDIErrMsg err: " + ec.toString(), ec);
				}				
			} else {
				log.error("\n tesEdiErrLogVO NULL EXCEPTION!!!!!!! \n ");
			}
			if (tesEdiErrLogVO==null){
				tesEdiErrLogVO = new TesEdiSoErrLogVO();
			}
			tesEdiErrLogVO.setErrLogRmk(JSPUtil.getNull(ackSndLogKeyVal)+ex.getMessage().trim());
			try {
				logAckCommErrMsg(tesEdiErrLogVO);
			} catch(Exception ec){
				log.error("\n TESeBillingAckManageBCImpl - logAckCommErrMsg err " + ec.toString(), ec);
			}
		}
		
		log.debug("\n EEEE - TESeBillingAckManageBCImpl - sendAckEdiInvDtl ~~~~~ \n");
	}
	
	/**
	 * ACK 대상 전송 전 DB에서의 전송 대기 가능(ERROR나 CANCEL된게 아닌지) 상태를 확인한다. 
	 * @param tesEdiAckSndLogVO
	 * @return String
	 * @throws EventException
	 */
	public String checkAckEDILogB4Send(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - checkAckEDILogB4Send~~~~~BBBB \n");

		try {
			return ediAckDbDao.checkAckEDILogB4Send(tesEdiAckSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * ACK 전송 후 완료 표시하기
	 * @param tesEdiAckSndLogVO
	 * @throws EventException
	 */
	public void completeAckEdiSndLogSts(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - logAckEDIErrMsg~~~~~BBBB \n");
		
		try {
			ediAckDbDao.completeAckEdiSndLogSts(tesEdiAckSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  TESeBillingAckManageBCImpl - logAckEDIErrMsg~~~~~EEEE \n");
	}

	/**
	 * Error log로 남기기
	 * @param tesEdiAckSndLogVO
	 * @throws EventException
	 */
	public void logAckEDIErrMsg(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - logAckEDIErrMsg~~~~~BBBB \n");
		
		try {
			ediAckDbDao.logAckEDIErrMsg(tesEdiAckSndLogVO);
		} catch(DAOException ex){
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  TESeBillingAckManageBCImpl - logAckEDIErrMsg~~~~~EEEE \n");
	}
	
	/**
	 * EDI 공용 Error log로 남기기
	 * @param tesEdiErrLogVO
	 * @throws EventException
	 */
	public void logAckCommErrMsg(TesEdiSoErrLogVO tesEdiErrLogVO) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - logAckCommErrMsg~~~~~BBBB \n");
		
		try {
			new TESeBillingCommonBCImpl().logEDIErrMsg(tesEdiErrLogVO);
		} catch(EventException ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  TESeBillingAckManageBCImpl - logAckCommErrMsg~~~~~EEEE \n");
	}
	
	/**
	 * ACK 전송 규칙 정보 조회
	 * @param ack_act_tp_cd
	 * @return List<TesEdiSndAckMnRuleVO>
	 * @throws EventException
	 */
	public List<TesEdiSndAckMnRuleVO> getAckSendAckMainRule(String ack_act_tp_cd) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - getAckSendAckMainRule~~~~~BBBB \n");
		
		try {
			return ediAckDbDao.getAckSendAckMainRule(ack_act_tp_cd);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * ACK SEND F/F 생성 대상 EDI invoice 목록 조회
	 * @param tesEdiSndAckMainRuleVO
	 * @return List<ComTesEdiAckSndLogVO>
	 * @throws EventException
	 */
	public List<ComTesEdiAckSndLogVO> getAckFFLogList(TesEdiSndAckMnRuleVO tesEdiSndAckMainRuleVO) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - getAckSendAckMainRule~~~~~BBBB \n");
		
		try {
			return ediAckDbDao.getAckFFLogList(tesEdiSndAckMainRuleVO);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * ACK 대상 EDI invoice 대상 조회
	 * @param tesEdiAckSndLogVO
	 * @return List<TesEdiSoHdrVO>
	 * @throws EventException
	 */
	public List<TesEdiSoHdrVO> getAckFFLogInvList(ComTesEdiAckSndLogVO tesEdiAckSndLogVO) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - getAckFFLogInvList~~~~~BBBB \n");
		
		try {
			return ediAckDbDao.getAckFFLogInvList(tesEdiAckSndLogVO);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * 주어진 ofc에 해당하는 EDI로 전송할 날짜 구하기
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getDtStr(String ofc_cd) throws EventException {
		log.debug("\n BBBB - TESeBillingAckManageBCImpl - getIFdt~~~~~ \n");
		
		try {
			return JSPUtil.getNull(new TESCommonBCImpl().getDBdateStr(JSPUtil.getNull(ofc_cd)));
		} catch(EventException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * ACK LOG용 주 sequence 구하기
	 * @return String
	 * @throws EventException
	 */
	public String getAckSendSeq() throws EventException {
		log.debug("\n TESeBillingAckManageBCImpl - getAckSendSeq~~~~~ \n");
		
		try {
			return JSPUtil.getNull(ediAckDbDao.createAckSendSeq());
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * (HIT/YICT) ACK전문의 FILE sequence 구하기
	 * @return String
	 * @throws EventException
	 */
	public String getAckFileSeq() throws EventException {
		log.debug("\n TESeBillingAckManageBCImpl - getAckFileSeq~~~~~ \n");
		
		try {
			return JSPUtil.getNull(ediAckDbDao.createAckSendFileSeq());
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * ACK 대상 EDI invoice 대상 조회
	 * @param ackEdiSndAckMainRuleVO
	 * @return List<TesEdiSoHdrVO>
	 * @throws EventException
	 */
	public List<TesEdiSoHdrVO> getAckEdiInvList(TesEdiSndAckMnRuleVO tesEdiSndAckMainRuleVO)throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - getAckEdiInvList~~~~~BBBB \n");
		
		try {
			return ediAckDbDao.getAckSendEDIInvoiceList(tesEdiSndAckMainRuleVO);
		} catch(DAOException e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		} catch(Exception e){
			log.error(e.getMessage());
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * ACK 대상 EDI invoice 대상 저장 및 초기화
	 * @param tesEdiAckSndLogVO
	 * @param tesEdiAckSndLogInvVOLst
	 * @throws EventException
	 */
	public void saveAckEdiInv(ComTesEdiAckSndLogVO tesEdiAckSndLogVO, List<TesEdiAckSndLogInvVO> tesEdiAckSndLogInvVOLst) throws EventException {
		log.debug("\n  TESeBillingAckManageBCImpl - beginAckEdiInv~~~~~BBBB \n");
		
		try {
			ediAckDbDao.creategAckEdiLog(tesEdiAckSndLogVO);
			ediAckDbDao.creategAckEdiLogInv(tesEdiAckSndLogInvVOLst);
		} catch(DAOException ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESeBillingManageDetailType01Impl업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		ediAckDbDao = null;
	}
}
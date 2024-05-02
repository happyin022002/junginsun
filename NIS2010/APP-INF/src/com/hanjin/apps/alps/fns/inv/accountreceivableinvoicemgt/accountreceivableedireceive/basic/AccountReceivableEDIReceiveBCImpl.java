/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableEDIReceiveBCImpl.java
 *@FileTitle : Glovis EDI Submission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.12.01
 *@LastModifier : 이석준
 *@LastVersion : 1.0
 *  2011.12.01 이석준
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.12.01 이석준 [CHM-201006884] AR Inovice module내 EDI Submission기능 추가 개발(2차) to Glovis 
 * 2011.02.14 최도순 [CHM-201006644] NIKE, Invoice EDI 신규 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.basic;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.integration.AccountReceivableEDIReceiveDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.InvEdiGlovisHdrVO;
import com.hanjin.syscommon.common.table.InvEdiAckVO;

/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0113EventResponse,AccountReceivableEDIReceiveBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class AccountReceivableEDIReceiveBCImpl extends BasicCommandSupport implements AccountReceivableEDIReceiveBC {

	// Database Access Object
	private transient AccountReceivableEDIReceiveDBDAO dbDao = null;

	/**
	 * AccountReceivableEDIReceiveBCImpl 객체 생성<br>
	 * AccountReceivableEDIReceiveDBDAO를 생성한다.<br>
	 */
	public AccountReceivableEDIReceiveBCImpl() {
		dbDao = new AccountReceivableEDIReceiveDBDAO();
//		eaiDao = new AccountReceivableEDISendEAIDAO();
	}
	

	/**
	 * Glovis로부터 들어온 EDI Message 수신
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @return InvEdiGlovisHdrVO
	 * @exception EventException
	 */
	private InvEdiGlovisHdrVO makeGlovisFlatFile(String rcvMsg, String userId, String integrationId) throws EventException{
		InvEdiGlovisHdrVO invEdiGlovisHdrVO = new InvEdiGlovisHdrVO();

		try {
			String[] rcvMsgs = rcvMsg.split("\n");
			int rcvMsgLines = rcvMsgs.length;
			String[] tempEntity;

			//Header/detail brce 갯수 count			
			int header_cnt = 0, detail_cnt = 0;

			//Header/Detail brace 유무
			boolean header_ind = false,	detail_ind = false;	
			for (int i=0;i<rcvMsgLines;i++){

				// message start부분은 그대로 찍는다.
				if (i==0){					
//					log.debug(rcvMsgs[i]);
					continue;
				}
				 if(rcvMsgs[i].startsWith("{INV_HEADER"))  { 
//					 log.debug("\n{INV_HEADER");
					 header_cnt++; header_ind = true; continue; }
		    	 if(rcvMsgs[i].startsWith("}INV_HEADER"))  { 
//		    		 log.debug("\n}INV_HEADER");
		    		 header_ind       = false; continue; }
		    	 if(rcvMsgs[i].startsWith("{INV_DETAIL"))  { 
//		    		 log.debug("\n{INV_DETAIL");
		    		 detail_cnt++;  detail_ind = true; continue; }
		    	 if(rcvMsgs[i].startsWith("}INV_DETAIL"))  { 
//		    		 log.debug("\n}INV_DETAIL");
		    		 detail_ind = false;continue; }
		    	 
				 tempEntity = rcvMsgs[i].split(":");
				 
		    	 // 문서의 끝이 나오면 FOR 문을 빠져나간다
		    	 if(rcvMsgs[i].startsWith("ENDDOC")) {
//		    		 log.debug("\nENDDOC:");
		    		 break;}
		    	 
				 if(tempEntity == null || tempEntity.length==0) continue;
				 
				  //값이 없는 부분은 읽을 가치도 없다.
				  if (tempEntity.length <=1) continue;
				 
				 tempEntity[0] = (tempEntity[0] == null ? "":tempEntity[0].trim()+"");
				 tempEntity[1] = (tempEntity[1] == null ? "":tempEntity[1].trim()+"");
				 
				 if("HEADER".equals(tempEntity[0])) { 
					 //문서 종류 
//					 log.debug("\nMessageType:"+tempEntity[1].substring(0,5));
					 //Sender ID   
//					 log.debug("\nSender ID:"+tempEntity[1].substring(6,19).trim());
					 //Receiver ID
//					 log.debug("\nReceiver ID:"+tempEntity[1].substring(20,19).trim());
					 continue;}
				 if("MSGVER".equals(tempEntity[0])) {
//					 log.debug("\nMSGVER:"+tempEntity[1]);
					 continue;}
				 if("MSGNUM".equals(tempEntity[0])) {
//					 log.debug("\nMSGNUM:"+tempEntity[1]);
					 invEdiGlovisHdrVO.setGlovisEdiMsgNo(tempEntity[1]);
					 continue;}
				 if("SNDDAT".equals(tempEntity[0])) {
//					 log.debug("\nSNDDAT:"+tempEntity[1]);
					 continue;}
				

				 // Header 추출
					 if(header_ind) {
						 if("INVNUM".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("MSGGUB".equals(tempEntity[0])) {
//							 log.debug("\nMSGGUB:"+tempEntity[1]);
							 continue;}
						 if("AIRSEA".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("INOUTC".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("CSTCOD".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("CSTNAM".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("CSTTYP".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("REGNUM".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("INVYMD".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("SNDEML".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("SNDNAM".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("SNDPHN".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("RCVEML".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("RCVNAM".equals(tempEntity[0])) {
//							 log.debug("\nRECEIVER_ID:"+tempEntity[1]);
							 continue;}
						 if("INVRMK".equals(tempEntity[0])) {
//							 log.debug("\nINVRMK:"+tempEntity[1]);
//							 invEdiGlovisHdrVO.setInvRmk(tempEntity[1]);
							 continue;}
						 if("RPLTYP".equals(tempEntity[0])) {
//							 log.debug("\nRPLTYP:"+tempEntity[1]);
							 invEdiGlovisHdrVO.setReTpCd(tempEntity[1]);
							 continue;}
						 if("ERRCOD".equals(tempEntity[0])) {
//							 log.debug("\nERRCOD:"+tempEntity[1]);
							 invEdiGlovisHdrVO.setGlovisReErrCd(tempEntity[1]);
							 continue;}
						 if("ERRMSG".equals(tempEntity[0])) {
//							 log.debug("\nERRMSG:"+tempEntity[1]);
							 invEdiGlovisHdrVO.setReErrRmk(tempEntity[1]);
							 continue;}
						 if("RTNTXT".equals(tempEntity[0])) {
//							 log.debug("\nRTNTXT:"+tempEntity[1]);
							 invEdiGlovisHdrVO.setReRmk(tempEntity[1]);
							 continue;}
					 }
					 // DETAIL 추출
					 if(detail_ind) {
						 if("SEQNUM".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("FBLNUM".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("FRTCOD".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("FRTNAM".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("AGRCUR".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("PKGUNT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("UNTPRC".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("PRGCNT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("FRTAMT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("EXCRAT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("WONAMT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("VATAMT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("INVCUR".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("DETRMK".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}
						 if("RTNTXT".equals(tempEntity[0])) {
//							 log.debug("\nINVNUM:"+tempEntity[1]);
							 continue;}						 
					 }					 		    	  
			}			
			return invEdiGlovisHdrVO;			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Glovis로부터 들어온 EDI Message를 table에 저장
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @exception EventException
	 */
	public void receiveEdiFromGlovis(String rcvMsg, String userId, String integrationId) throws EventException{
		InvEdiGlovisHdrVO invEdiGlovisHdrVO = new InvEdiGlovisHdrVO();
		try {
			invEdiGlovisHdrVO = makeGlovisFlatFile(rcvMsg,userId,integrationId);
			log.error(">Glovis EDI Message NO>>>>>>>>>>>>>>>>>>"+invEdiGlovisHdrVO.getGlovisEdiMsgNo()+"<<<<<<<<<<<<<<<<<<<<<<<<");
			dbDao.modifyInvEdiGlovisHdr(invEdiGlovisHdrVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EDI Message를 table에 저장
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @exception EventException
	 */
	public void receiveCommonEdi(String rcvMsg, String userId, String integrationId) throws EventException{
		InvEdiAckVO invEdiAckVO = new InvEdiAckVO();
		
		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		ArrayList<String> tmpArray = new ArrayList<String>();
		String tmpStr = "";
		String keyAndValue[] = null;
		String regex = ":";
		int tmpArrayMaxSize = 0;
		
		String key = "";
		String value = "";
		String value2 = "";
		
		try {		
			
			while (token.hasMoreTokens()) {				
				tmpArray.add(token.nextToken());
			}
			
			tmpArrayMaxSize = tmpArray.size();
			
			if(tmpArray != null && tmpArrayMaxSize > 0) {	
				
				for ( int i=0 ; i<tmpArrayMaxSize ; i++ ){
					
					tmpStr = tmpArray.get(i).toString().trim();
					
					keyAndValue = tmpStr.split(regex);

					key = keyAndValue[0].trim();

					if(keyAndValue.length == 1) {
						value = "";
					} else if(keyAndValue.length == 2) {
						value = keyAndValue[1].trim();						
					}else if(keyAndValue.length > 2){
						value = keyAndValue[1].trim();
						value2 = keyAndValue[2].trim();
					}
					
				    if (key.equalsIgnoreCase("$$$MSGSTART")) {
				    	invEdiAckVO.setAckHdrMsg("$$$MSGSTART:"+value+":"+value2);
				    } else if (key.equalsIgnoreCase("ORG_MSG_RCV")) {
				    	invEdiAckVO.setAckSndrId(value);
				    } else if (key.equalsIgnoreCase("ORG_MSG_KEY")) {
				    	invEdiAckVO.setAckKeyNo(value);
				    } else if (key.equalsIgnoreCase("ORG_MSG_TP")) {
				    	invEdiAckVO.setAckMsgTpCd(value);
				    } else if (key.equalsIgnoreCase("MSG_UDT_FLG")) {
				    	invEdiAckVO.setAckUpdCd(value);
				    } else if (key.equalsIgnoreCase("ORG_MSG_NM")) {
				    	invEdiAckVO.setAckMsgNm(value);
				    } else if (key.equalsIgnoreCase("MSG_ACK_TP")) {
				    	invEdiAckVO.setAckTpCd(value);
				    } else if (key.equalsIgnoreCase("MSG_ACK_RSLT")) {
				    	invEdiAckVO.setAckRsltCd(value);
				    } else if (key.equalsIgnoreCase("MSG_ACK_DT")) {
				    	invEdiAckVO.setAckDt(value);
				    } else if (key.equalsIgnoreCase("REJ_REASON")) {
				    	invEdiAckVO.setAckRjctRsn(value);
				    } else if (key.equalsIgnoreCase("MSG_ACK_REF")) {
				    	invEdiAckVO.setAckRefNo(value);
				    } 
				}

/*
				invEdiAckVO.setCreUsrId("NIKE");
				invEdiAckVO.setUpdUsrId("NIKE");
*/
				// EDI 응답이 'NIKE'만 사용하다가 여러 회사로 변경 됨.
				invEdiAckVO.setCreUsrId("ACK");
				invEdiAckVO.setUpdUsrId("ACK");
			}
			
			dbDao.insertInvEdiAck(invEdiAckVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalCalculateBackEndJob.java
*@FileTitle : CM Summary List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.21 송민석
* 1.0 Creation
 * 2010.10.01 송호진 COA 상의 OPMS 결함 복구작업 [메소드명 변경] createCoaCostPkgPreCMAbc => createCoaCostPkgPreCMAbcStp
 * 2012.07.12 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 
                                       신규로 추가된 2 개의 필드 (MtyPkupYdCd,MtyPkupYdCdNode ) 를 Blank 로 세팅하여 COA Method ( Procedure ) 를 호출 하도록 해야 함
 * 2012.07.17 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 두번째 
				    Cost 계산에서 사용되는 COA 의 데이터들을 지우는 로직을 추가                                                                  
 * 2012.07.18 송호진 CHM-201218988 : PRS ROUTE CASE 비용 산출 배치 작업 요청(7월) 건에 의해 발견된 부분 수정 세번째 
				    Cost 계산에서 사용되는 COA 의 데이터들을 지우는 로직 위치를 PCTL_NO 가 유효한 경우 처리하도록 변경                                                                  
 * 2012.08.06 송호진 CHM-201216347 : ACM 프로젝트 연동 모듈 변경 작업
                    New Agent Commission ( ACM ) Project 에 의한 Agt 호출 부분 변경 			                                                                  *
 * 2012.08.19 송호진 CHM-201431603 : 8월 PRS 배치작업 요청
                    SearchCondition0153VO 변경 부분 적용 
 * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
                    SearchCondition0153VO 변경 부분 적용 
 * 2016.06.17  [CHM-201642005] TRI Amendment & Creation 상에서 Publish 버튼 클릭 후 30초가 지나도 서비스 가능하도록 시스템 개발                     
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration.TRINoteConversionProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration.TRIProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration.TRIProposalEAIDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTriRtVO;
/**
 * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
 * 
 * @author Min Seok, Song
 * @see 
 * @since J2EE 1.6
 */
public class TRIProposalPublishBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private  TRIProposalDBDAO 						dbDao 		= new TRIProposalDBDAO();
	private  TRINoteConversionProposalDBDAO 	dbNoteDao = new TRINoteConversionProposalDBDAO();
	
	//--------------------------------------------------------------
	private SignOnUserAccount account	;
	private PriTriRtVO priTriRtVO 				;
	private PriTriRtVO[] priTriRtVOs 			;

	
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * @return the priTriRtVO
	 */
	public PriTriRtVO getPriTriRtVO() {
		return priTriRtVO;
	}

	/**
	 * @param priTriRtVO the priTriRtVO to set
	 */
	public void setPriTriRtVO(PriTriRtVO priTriRtVO) {
		this.priTriRtVO = priTriRtVO;
	}
	

	/**
	 * @return the priTriRtVOs
	 */
	public PriTriRtVO[] getPriTriRtVOs() {
		PriTriRtVO[] rtnVOs = null;
		if (this.priTriRtVOs != null) {
			rtnVOs = new PriTriRtVO[priTriRtVOs.length];
			System.arraycopy(priTriRtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * @param priTriRtVOs the priTriRtVOs to set
	 */
	public void setPriTriRtVOs(PriTriRtVO[] priTriRtVOs) {
		if(priTriRtVOs != null){
			PriTriRtVO[] tmpVOs = new PriTriRtVO[priTriRtVOs.length];
			System.arraycopy(priTriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTriRtVOs = tmpVOs;
		}
	}
	
	//--------------------------------------------------------------

	/**
	 *  다건의 TRI Proposal 데이터를 BackEnd 로 통합  Publish 합니다. <br>
	 *  
	 * @return String
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		

		try {
			
			log.debug("\n 1.[publishMultiTRIRateProposal]==================================================");
			publishMultiTRIRateProposal(priTriRtVOs, account);
			
			log.debug("\n 2.[publishMultiTRINoteRateProposal]==================================================");
			publishMultiTRINoteRateProposal(priTriRtVOs, account);
			
			log.debug("\n 3.[sendMailTRIProposalPublish]==================================================");
            if (this.priTriRtVOs != null && this.priTriRtVOs.length > 0) {
                // mail 전송
                for (int i = 0; i < this.priTriRtVOs.length; i++) {
                    sendMailTRIProposalPublish(this.priTriRtVOs[i], account);
                }
            }
			
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return "";
		
	}
	
	/**
	 * 다건의 TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("F");
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyRatePublishProposal(priTriRtVOs[i]);
					dbDao.modifyRateClosePrevExpDtPostPublish(priTriRtVOs[i]);
					
					log.debug("\n 1.[publishMultiTRIRateProposal]========"+priTriRtVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRINoteRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("F");
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbNoteDao.modifyNoteConversionDurationOnPublish(priTriRtVOs[i]);
					
					log.debug("\n 2.[publishMultiTRINoteRateProposal]========"+priTriRtVOs[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * TRI Proposal 에서 Publish 할 때 담당자에게 GW 메일을 전송합니다.<br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposalPublish(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
        try {
            TriPropSendMailVO triPropSendMailVO = new TriPropSendMailVO();
            List<String> emailList = new ArrayList<String>();
            // mail 대상 조회
            String[] emails = dbDao.searchTRIPublishTargetMail(priTriRtVO);
            
            if (emails == null || emails.length == 0) {
                return;
            }
            
            for (int i = 0, n = emails.length ; i < n ; i++) {
                emailList.add(emails[i]);
            }
            
            // mail content 조회
            List<RsltTriPropListVO> list = dbDao.searchTRIPublishMailContent(priTriRtVO);
            
            if (list == null || list.size() == 0) {
                return;
            }
            
            RsltTriPropListVO rsltTriPropListVO = list.get(0);
            
            triPropSendMailVO.setFromUser(account.getUsr_eml());
            triPropSendMailVO.setFromUserNm(account.getUsr_nm());
            
            triPropSendMailVO.setSubject("Notice of TRI Publication");
            StringBuilder sbHtmlContent = new StringBuilder();
            
            sbHtmlContent.append("<html>");
            sbHtmlContent.append("<head>");
            sbHtmlContent.append("<title></title>");
            sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
            sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
            sbHtmlContent.append("</head>");
            sbHtmlContent.append("<table style=\"width:100%\" class=\"popup\" cellpadding=\"0\" border=\"0\">");
            sbHtmlContent.append("<tr><td class=\"top\"></td></tr>");
            sbHtmlContent.append("<tr><td valign=\"top\">");
            sbHtmlContent.append("<table width=\"100%\" border=\"0\">");
            sbHtmlContent.append("<tr><td style=\"font-family:verdana,arial; font-size: 14px; word-spacing:-0px; color: #FF4E00; padding-left:10;\">To whom it may concerned</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table class=\"search\">");
            sbHtmlContent.append("<tr><td class=\"bg\">");
            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;\">");

            if (priTriRtVO.getAmdtSeq().equals("0")) {
                sbHtmlContent.append("Please be advised that below Tariff Rate, you requested, is published as below.<br>");
                sbHtmlContent.append("Now you can create TAA with this TRI.");
            } else {
                sbHtmlContent.append("Please be advised that below Tariff Rate is published as following.<br>");
                sbHtmlContent.append("● If you are the one who requests below TRI, now you can create TAA with this TRI.<br>");
                sbHtmlContent.append("● If you are the one who is using this TRI in your TAA, please check the rate changes.");
            }

            sbHtmlContent.append("<br><br>");
            sbHtmlContent.append("</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"A6C3CB\" border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Tariff Code</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Tariff Rate Item<br>(TRI)</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Current<br>Status</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Commodity</td>");
            sbHtmlContent.append("<td colspan=\"4\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Route</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Per </td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Cargo<br>Type</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Cur.</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Rate</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Note</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Effective<br>Date</td>");
            sbHtmlContent.append("<td rowspan=\"2\" style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Expiration<br>Date</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Origin</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">Origin Via</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\"> Dest Via</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8EFF9; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\"> Dest</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getTrfCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getTriNo()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #ffffff; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getCurStatus()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getCmdtNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getOrgRoutPntLocNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getOrgRoutViaPortNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getDestRoutViaPortNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getDestRoutPntLocNm()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getRatUtCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getPrcCgoTpCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getCurrCd()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(JSPUtil.formatCurrency(rsltTriPropListVO.getFnlFrtRtAmt())).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #ffffff; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getNoteCtnt()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getEffDt()).append("</td>");
            sbHtmlContent.append("<td style=\"background-color: #E8E7EC; color: #313131; text-align : center; font-weight:bold; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 11px; padding-right:3px;\">").append(rsltTriPropListVO.getExpDt()).append("</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table class=\"search\" border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;\"><br>Thank you.<br>");
            sbHtmlContent.append("Best regards</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</body>");
            sbHtmlContent.append("</html>");
            triPropSendMailVO.setHtmlContent(sbHtmlContent.toString());
            
            TRIProposalEAIDAO eaiDao = new TRIProposalEAIDAO();
            eaiDao.sendMailTRIProposalPublish(triPropSendMailVO, emailList);
            
            log.debug("\n 3.[sendMailTRIProposalPublish]========");
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        }
    }	
}

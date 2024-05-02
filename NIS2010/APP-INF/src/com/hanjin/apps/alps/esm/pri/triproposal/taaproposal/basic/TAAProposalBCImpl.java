/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TAAProposalBCImpl.java
 *@FileTitle : TAA Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.18
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.11.18 문동규
 * 1.0 Creation
=========================================================
* History
* 2011-08-17 송호진 [CHM-2011128680-01][PRI] TAA화면에서 EAI(CMS013_0001)호출을 Confirm 후 Sales Rep. 변경시에도 호출 할수 있도록 변경
* 2012.09.26 원종규[CHM-201220110] 계약 변경 통보 기능 : 계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송
* 2012.11.08 원종규[CHM-201221251] 계약 변경 통보 기능 발송 메일 Header 변경: 발송 메일 제목에 적용 계약 #를 포함
* 2013.11.07 전윤주 [CHM-201327486] File 시 Revenue Audit System 수입심사 배치대상 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration.TAAProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration.TAAProposalEAIDAO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropSendMailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriTaaMnVO;
import com.hanjin.syscommon.common.table.PriTriMnVO;

/**
 * ALPS-TRIProposal Business Logic Command Interface<br>
 * - ALPS-TRIProposal에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @since J2EE 1.6
 */
public class TAAProposalBCImpl extends BasicCommandSupport implements TAAProposalBC {

    // Database Access Object
    private transient TAAProposalDBDAO dbDao = null;

    /**
     * TAAProposalBCImpl 객체 생성<br>
     * TAAProposalDBDAO를 생성한다.<br>
     */
    public TAAProposalBCImpl() {
        dbDao = new TAAProposalDBDAO();
    }

    /**
     * TRI Proposal TAA Main 및 TRI List 를 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return RsltTaaListVO
     * @exception EventException
     */
    public RsltTaaListVO searchTRIProposalTAAList (RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            RsltTaaListVO rsltTaalistVO = new RsltTaaListVO();
            List<RsltTaaMnVO> taaList = dbDao.searchTRIProposalTAAMain(rsltTaaMnVO);
            List<RsltTaaTriListVO> triList = dbDao.searchTRIProposalTAAList(rsltTaaMnVO);
            rsltTaalistVO.setRsltTaaMnVOs(taaList);
            rsltTaalistVO.setRsltTaaTriListVOs(triList);
            return rsltTaalistVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA Main 의 Amdt Seq Combo Item 을 조회합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTRIProposalTAAAmdtSeqList (RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAAAmdtSeqList (rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Customer 정보를 조회합니다.<br>
     * 
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
        try {
            return dbDao.searchProposalCustomerInfo(priSpCtrtPtyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal 신규 TAA Proposal Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAPropNo(String ofcCd) throws EventException {
        try {
            String taaPropNo = dbDao.searchTRIProposalTAAPropNo(ofcCd);
            return taaPropNo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal 신규 TAA Number 를 조회합니다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAANo(String ofcCd) throws EventException {
        try {
            String taaPropNo = dbDao.searchTRIProposalTAANo(ofcCd);
            return taaPropNo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA Header 정보를 저장합니다.<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAHeader (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException {
        try {
            for (int i = 0; i < rsltTaaMnVOs.length; i++) {
                if (rsltTaaMnVOs[i].getIbflag().equals("I")) {
                    rsltTaaMnVOs[i].setCreUsrId(account.getUsr_id());
                    rsltTaaMnVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.addmanageTRIProposalTAAHeader(rsltTaaMnVOs[i]);
                } else if (rsltTaaMnVOs[i].getIbflag().equals("D")) {
                    dbDao.removemanageTRIProposalTAAHeader(rsltTaaMnVOs[i]);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA Main 정보를 저장합니다.<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAMain (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException {
        try {
            for (int i = 0; i < rsltTaaMnVOs.length; i++) {
                if (rsltTaaMnVOs[i].getIbflag().equals("I")) {
                    rsltTaaMnVOs[i].setCreUsrId(account.getUsr_id());
                    rsltTaaMnVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.addmanageTRIProposalTAAMain(rsltTaaMnVOs[i]);
                } else if (rsltTaaMnVOs[i].getIbflag().equals("U")) {
                    rsltTaaMnVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.modifymanageTRIProposalTAAMain(rsltTaaMnVOs[i]);
                } else if (rsltTaaMnVOs[i].getIbflag().equals("D")) {
                    dbDao.removemanageTRIProposalTAAMain(rsltTaaMnVOs[i]);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA TRI List 정보를 저장합니다.<br>
     * 
     * @param RsltTaaTriListVO[] rsltTaaTriListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAList (RsltTaaTriListVO[] rsltTaaTriListVOs, SignOnUserAccount account) throws EventException {
        try {
            List<RsltTaaTriListVO> insertVoList = new ArrayList<RsltTaaTriListVO>();
            List<RsltTaaTriListVO> deleteVoList = new ArrayList<RsltTaaTriListVO>();
            for (int i = 0; i < rsltTaaTriListVOs.length; i++) {
                if (rsltTaaTriListVOs[i].getIbflag().equals("I")) {
                    rsltTaaTriListVOs[i].setCreUsrId(account.getUsr_id());
                    rsltTaaTriListVOs[i].setUpdUsrId(account.getUsr_id());
                    insertVoList.add(rsltTaaTriListVOs[i]);
                } else if (rsltTaaTriListVOs[i].getIbflag().equals("D")) {
                    deleteVoList.add(rsltTaaTriListVOs[i]);
                }
            }

            if (deleteVoList.size() > 0) {
                dbDao.removemanageTRIProposalTAAList(deleteVoList);
            }

            if (insertVoList.size() > 0) {
                dbDao.addmanageTRIProposalTAAList(insertVoList);
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA 정보를 Confirm 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            rsltTaaMnVO.setCfmFlg("Y");
            rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyConfirmTRIProposalTAA(rsltTaaMnVO);
            dbDao.modifyAmendConfirmTRIProposalTAA(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA 정보를 Confirm Cancel 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmCancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            rsltTaaMnVO.setCfmFlg("N");
            rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyConfirmTRIProposalTAA(rsltTaaMnVO);
            dbDao.modifyAmendConfirmTRIProposalTAA(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA 해당 회차 정보를 Delete 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            dbDao.removemanageTRIProposalTAAListAll(rsltTaaMnVO);
            dbDao.removemanageTRIProposalTAAMain(rsltTaaMnVO);
            if (JSPUtil.getNull(rsltTaaMnVO.getAmdtSeq()).equals("0")) {
                // 회차가 0이면 Header 삭제
                dbDao.removemanageTRIProposalTAAHeader(rsltTaaMnVO);
            } else {
                // 회차가 0이 아니면 이전회차 Duration 복원
                rsltTaaMnVO.setCfmFlg("N");
                rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
                dbDao.modifyAmendConfirmTRIProposalTAA(rsltTaaMnVO);
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA 정보를 Amend 합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            rsltTaaMnVO.setCreUsrId(account.getUsr_id());
            rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
            // TAA Main Amend
            dbDao.addAmendTRIProposalTAAMain(rsltTaaMnVO);
            // TAA TRI List Amend
            dbDao.addAmendTRIProposalTAAList(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * TRI Inquiry List 를 조회합니다. <br>
     * 
     * @param PriTriMnVO priTriMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAAInquiryList(PriTriMnVO priTriMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAAInquiryList(priTriMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal Select List 를 조회합니다.<br>
     * 
     * @param RsltTaaTriListVO rsltTaaTriListVO
     * @return List<RsltTaaTriListVO>
     * @exception EventException
     */
    public List<RsltTaaTriListVO> searchTRIProposalSelectList(RsltTaaTriListVO rsltTaaTriListVO) throws EventException {
        try {
            return dbDao.searchTRIProposalSelectList(rsltTaaTriListVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA No List 를 조회합니다. <br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAANoList(RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAANoList(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TRI Proposal TAA 정보를 Booking 에서 사용하는지 체크합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return String[]
     * @exception EventException
     */
    public String[] searchTRIProposalTAACheckUseBkg(RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAACheckUseBkg(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TAA Main 정보를 CRM으로 전송합니다.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String transferTAAMainInfo (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
    	String reEaiIfId ="";
        try {
            List<RsltTaaMnVO> list = dbDao.searchTAAMainInfo(rsltTaaMnVO);
            if (list != null && list.size() > 0) {
                TAAProposalEAIDAO eaiDao = new TAAProposalEAIDAO();
                reEaiIfId = eaiDao.transferTAAMainInfo(list.get(0));
            }
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), de);
        }
        return reEaiIfId;
    }

    /**
     * TRI Proposal TAA 승인권한을 조회합니다.<br>
     * 
     * @param PriAuthorizationVO priAuthorizationVO
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAApprovalAuth(PriAuthorizationVO priAuthorizationVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAAApprovalAuth(priAuthorizationVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * TAA 건 Confirm 이후 Sales Rep 정보의 변경 유무를 체크한다.<br>
     *
     * @param PriTaaMnVO priTaaMnVO
     * @return int
     * @exception EventException
     */
    public int searchCheckOfcSrepDiffList(PriTaaMnVO priTaaMnVO)  throws EventException {
		try {
			return dbDao.searchCheckOfcSrepDiffList(priTaaMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
    
    /**
     * TAA confirm 이후 유저에게 G/W 메일 발송한다.<br>
     *
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @return List<PriEmailTargetListVO>
     * @exception EventException
     */
    public List<PriEmailTargetListVO> sendEmail(RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException{
        try {
            TriPropSendMailVO sendMailVO = new TriPropSendMailVO();
            List<String> emailList = new ArrayList<String>();            
           
            // mail 대상 조회
            List<PriEmailTargetListVO> list = dbDao.searchEmailTargetUser(rsltTaaMnVO);
            
            if (list != null && list.size() > 0) {
	            // mail content
	            sendMailVO.setFromUser(account.getUsr_eml());
	            sendMailVO.setFromUserNm(account.getUsr_nm());
	            sendMailVO.setOfcCd(account.getOfc_cd());
	            
	            sendMailVO.setSubject("Notice of The TAA Confirm("+list.get(0).getTaaNo()+")");
	            
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
	            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">To whom it may concerned</td></tr>");
	            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : Notice of The TAA Confirm<br><br></td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("<table class=\"search\">");
	            sbHtmlContent.append("<tr><td class=\"bg\">");    
	            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 16px; word-spacing:-0px;\">");
	            
	            sbHtmlContent.append("Your contract ("+list.get(0).getTaaNo()+") for the following bookings has been amended by salesperson.<br>");
	            sbHtmlContent.append("Please, check and rerate it accordingly.<br><br>");
	            sbHtmlContent.append("Booking Number / Your ID (This mail is sent to all documentation staffs who have a B/L with the contract)<br><br>");
	            
	            // booking list 
	            sbHtmlContent.append("<table cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#ffffff\" border=\"0\" style=\"width:100%;\">");          
	            for(int i=0;i<list.size();i++){
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: Tahoma,verdana; font-size: 16px; padding-right:3px;\">"+list.get(i).getSeq()+". "+list.get(i).getBkgNo()+" / "+list.get(i).getUpdUsrId()+"</td></tr></table></td></tr>");
	            }
	            sbHtmlContent.append("</table><br>");
	        
	            sbHtmlContent.append("* This notification is automatically made by system when your contract is amended after your rating.<br>");
	            sbHtmlContent.append("Since the sender of your mail does not send the mail, you are not to reply to him and may figure out the amendment of contract thru ALPS on your own.<br>"); 
	            sbHtmlContent.append("* It may not be the amendment on amount of charges/surcharges.<br>"); 
	            
	            sbHtmlContent.append("<table class=\"search\" border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\"><br>Thank you.<br>");
	            sbHtmlContent.append("Best Regards,</td>");
	            sbHtmlContent.append("</tr>");
	            sbHtmlContent.append("</table>");            
	            sbHtmlContent.append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            sbHtmlContent.append("</html>");
	            sendMailVO.setHtmlContent(sbHtmlContent.toString());
	            
	            // mail 대상 Key(email send Seq) List 에 담기
	            String preUsrId = "";
	            for (int i = 0 ; i < list.size() ; i++) {            	
	            	if(!list.get(i).getUpdUsrId().equals(preUsrId)){
	                   emailList.add(list.get(i).getUsrEml());
	            	}            	
	            	preUsrId = list.get(i).getUpdUsrId();
	            }
	          
	              TAAProposalEAIDAO eaiDao = new TAAProposalEAIDAO();
	              eaiDao.sendEmail(sendMailVO, emailList);   
            }
            
          return list;  
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("FMS01187",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("FMS01187",new String[]{}).getMessage(), ex);
        }
    }
    
}
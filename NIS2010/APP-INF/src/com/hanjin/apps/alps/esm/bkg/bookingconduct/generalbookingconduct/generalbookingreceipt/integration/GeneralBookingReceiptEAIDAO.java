/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptEAIDAO.java
*@FileTitle : GeneralBookingReceiptEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19 
* 1.0 Creation
* ======================================================================
* History
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차) - noreply@smlines.com 추가
=========================================================
* History
*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RollOverNoticeParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.TsBkgCloseNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngDoubleCallEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdEtaCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdYardCngNoticeVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.ComUserVO;


/**
 * NIS2010 GeneralBookingReceiptEAIDAO <br>
 * - NIS2010-GeneralBookingReceiptEAIDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see GeneralBookingReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class GeneralBookingReceiptEAIDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = -1184130086564280801L;

	/**
	 * Customer EDI로 전송 BackEndJob 결과를 확인하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception Exception, DAOException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws Exception, DAOException {
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * T/S Booking의 Close에 대해서 email을 전송함.<br>
	 * 
	 * @param List<TsBkgCloseNoticeVO> tsBkgCloseNoticeVOs
	 * @param account 
	 * @exception Exception, DAOException
	 */
	public void sendTsCloseNotice(List<TsBkgCloseNoticeVO> tsBkgCloseNoticeVOs, SignOnUserAccount account) throws Exception, DAOException {
		try{
			Mail mail = null;
			for(int i=0; i < tsBkgCloseNoticeVOs.size(); i++){				
				// for origin user
				if(tsBkgCloseNoticeVOs.get(i).getOrgRcvrEml() != null
						&& tsBkgCloseNoticeVOs.get(i).getOrgRcvrEml().length() > 0){
					mail = new Mail();
					mail.setRdSubSysCd("BKG");
					mail.setFrom("noreply@smlines.com", account.getUsr_nm()); //보내는 사람 메일주소
					mail.setRecipient(tsBkgCloseNoticeVOs.get(i).getOrgRcvrEml());  //받는 사람 메일주소
					mail.setSubject("T/S CLL " + tsBkgCloseNoticeVOs.get(i).getBkgNo() 
									+ " for " + tsBkgCloseNoticeVOs.get(i).getVvd() 
									+ " has been closed. Please inform T/S side of any SKD change.");  //메일제목
					mail.setTextContent("T/S CLL " + tsBkgCloseNoticeVOs.get(i).getBkgNo() 
									+ " for " + tsBkgCloseNoticeVOs.get(i).getVvd() 
									+ " has been closed. Please inform T/S side of any SKD change."); //Text 로 된 본문 내용
					mail.send();
				}
				// for t/s user
				if(tsBkgCloseNoticeVOs.get(i).getTsRcvrEml() != null
						&& tsBkgCloseNoticeVOs.get(i).getTsRcvrEml().length() > 0){
					mail = new Mail();
					mail.setRdSubSysCd("BKG");
					mail.setFrom("noreply@smlines.com", account.getUsr_nm()); //보내는 사람 메일주소
					mail.setRecipient(tsBkgCloseNoticeVOs.get(i).getTsRcvrEml());  //받는 사람 메일주소
					mail.setSubject(tsBkgCloseNoticeVOs.get(i).getBkgNo() 
									+ " for " + tsBkgCloseNoticeVOs.get(i).getVvd() 
									+ " has been changed after closing CLL.");  //메일제목
					mail.setTextContent(tsBkgCloseNoticeVOs.get(i).getBkgNo() 
									+ " for " + tsBkgCloseNoticeVOs.get(i).getVvd() 
									+ " has been changed after closing CLL."); //Text 로 된 본문 내용
					mail.send();
				}
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * vsk_vsl_port_skd ETA 변경시 Notice를 전송함<br>
	 * 
	 * @author 		RyuDaeYoung
	 * @param 		VslSkdEtaCngNoticeVO vslSkdEtaCngNoticeVO
	 * @param       SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void sendVskSkdCngNotice(VslSkdEtaCngNoticeVO vslSkdEtaCngNoticeVO, SignOnUserAccount account) throws Exception, DAOException {
		try{
			Mail mail = null;
			if(vslSkdEtaCngNoticeVO.getUsrEml() != null){
				mail = new Mail();
				mail.setRdSubSysCd("BKG");
				mail.setFrom("noreply@smlines.com", account.getUsr_nm()); //보내는 사람 메일주소
				mail.setRecipient(vslSkdEtaCngNoticeVO.getUsrEml());  //받는 사람 메일주소
				mail.setSubject("Vessel Schedule Delay Notice");
				mail.setTextContent(" Vessel Schedule Delay Notice" + "\n\n"
								+ " POD Port : "+ vslSkdEtaCngNoticeVO.getPortCd() + "\n"
								+ " Vessel : " + vslSkdEtaCngNoticeVO.getVvd() + "\n"
								+ " Initial ETA : " + vslSkdEtaCngNoticeVO.getOldEtaDt() + "\n"
								+ " Delayed ETA : " + vslSkdEtaCngNoticeVO.getNewEtaDt() ); //Text 로 된 본문 내용
				mail.send();
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}

	/**
	 * Allocation 관련으로 StandBy되었음을 notice한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvrEml
	 * @param SignOnUserAccount account 
	 * @param String custRefNoCtnt
	 * @return List<BkgNtcHisVO>
	 * @exception Exception, DAOException
	 */
	public List<BkgNtcHisVO> sendStandByNotice(BkgBlNoVO bkgBlNoVO, String rcvrEml, SignOnUserAccount account, String custRefNoCtnt) throws Exception, DAOException {
		List<String> sndIds = null;
//		List<ComRptDsgnXptInfoVO> vos = null;
//		ArrayList<SingleMailAttachedFile> fileList = null;
//		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "noreply@smlines.com";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			
			sndIds = new ArrayList<String>();
			
//			vo = new ComRptDsgnXptInfoVO();
//			vo.setRdTmpltNm("ESM_BKG_5005G.mrd");
//			vo.setRdParaCtnt("/rv BKG_NO['"+bkgBlNoVO.getBkgNo()+"'] USR_ID["+account.getUsr_id()+"] O_PS[] P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]");
//			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
//			vo.setXptFileNm("HJSC"+bkgBlNoVO.getBkgNo()+".pdf");
//			vo.setCreUsrId(account.getUsr_id());
//			vo.setUpdUsrId(account.getUsr_id());
//			vos = new ArrayList<ComRptDsgnXptInfoVO>();
//			vos.add(vo);

			template = new TemplateMail();
			template.setBatFlg("N");
//			template.setComRptDsgnXptInfoVOs(vos);
			template.setFrom(sUsrEml,account.getUsr_nm());
			template.setRecipient(rcvrEml);
			template.setSubject("Standby Notice (BKG No : "+bkgBlNoVO.getBkgNo()+")");
//			template.setAttachedFile(fileList);
//			template.setCcRcvrEml(bkgReceiptSendVO.getCcEmail());			
			template.setHtmlTemplate("ESM_BKG_0098_03T.html");			
			template.setArg("bkgNoTitle","BKG No : "+bkgBlNoVO.getBkgNo());
			if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
				template.setArg("bkgNoBody",bkgBlNoVO.getBkgNo()+" (BKG Ref.No. : "+custRefNoCtnt+")");
			}else{
				template.setArg("bkgNoBody",bkgBlNoVO.getBkgNo());
			}
			
			sndIds.add(template.send());
			
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("SB"); // Standby 코드 추가
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(rcvrEml);
				bkgNtcHisVO.setSndId(sndIds.get(i));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;
			
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
	} 
	
	/**
	 * Allocation 관련으로 StandBy되었음을 notice한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvrEml
	 * @param SignOnUserAccount account 
	 * @param String custRefNoCtnt
	 * @return List<BkgNtcHisVO>
	 * @exception Exception, DAOException
	 */
	public List<BkgNtcHisVO> sendStandByNotice2(BkgBlNoVO bkgBlNoVO, String rcvrEml, SignOnUserAccount account, String custRefNoCtnt) throws Exception, DAOException {
		List<String> sndIds = null;
		try {
			String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			boolean isLive = false;     // Live 여부
			if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
				isLive = true;
			}
			
			sndIds = new ArrayList<String>();
			
			Mail mail = null;
				
			mail = new Mail();
			mail.setRdSubSysCd("BKG");
			mail.setFrom("noreply@smlines.com"); //보내는 사람 메일주소
			//mail.setFrom(sUsrEml,account.getUsr_nm());
			mail.setRecipient(rcvrEml);  //받는 사람 메일주소
			if(isLive){
				mail.setSubject("Standby Booking Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")");
			}else{
				mail.setSubject("[Test Mail] Standby Booking Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")");
			}
			mail.setHtmlContent("<b>SM Line Standby Booking Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")</b>" +
					"<br><br>Dear Sales representative," +
					"<br><br>Please be informed that your booking(s) below are received but," +
					"<br>booking confirmation is not available and its status falls as standby" +
					"<br>- Booking No. " + bkgBlNoVO.getBkgNo() +
					"<br><br>Furthermore, container pick up would not be available without changing its status into Firm." +
					"<br><br>Please check BKG indetail under consultation related teams for the further BKG process." +
					"<br><br>SM Line Corporation"
						); //HTML 로 된 본문 내용
			sndIds.add(mail.send());
			
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("SB"); // Standby 코드 추가
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(rcvrEml);
				bkgNtcHisVO.setSndId(sndIds.get(i));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;
			
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
	} 
	
	/**
	 * Allocation 관련으로 Confirm 되었음을 notice한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rcvrEml
	 * @param SignOnUserAccount account 
	 * @param String custRefNoCtnt
	 * @return List<BkgNtcHisVO>
	 * @exception Exception, DAOException
	 */
	public List<BkgNtcHisVO> sendStandByToConfirmNotice(BkgBlNoVO bkgBlNoVO, String rcvrEml, SignOnUserAccount account, String custRefNoCtnt) throws Exception, DAOException {
		List<String> sndIds = null;
		try {
			String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			boolean isLive = false;     // Live 여부
			if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
				isLive = true;
			}
			
			sndIds = new ArrayList<String>();
			
			Mail mail = null;
				
			mail = new Mail();
			mail.setRdSubSysCd("BKG");
			//mail.setFrom("noreply@smlines.com", account.getUsr_nm()); //보내는 사람 메일주소
			mail.setFrom("noreply@smlines.com");
			mail.setRecipient(rcvrEml);  //받는 사람 메일주소
			if(isLive){
				mail.setSubject("Booking Confirmation Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")");
			}else{
				mail.setSubject("[Test Mail] Booking Confirmation Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")");
			}
			mail.setHtmlContent("<b>Standby booking Confirmation Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")</b>" +
					"<br><br>Dear Sales representative," +
					"<br><br>Please be informed that status of your booking(s) below is changed" +
					"<br>from Standby to Firm." +
					"<br><br>- Booking No. " + bkgBlNoVO.getBkgNo() +
					"<br><br>SM Line Corporation"
						); //HTML 로 된 본문 내용
			sndIds.add(mail.send());
			
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("SF"); // Standby 코드 추가
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(rcvrEml);
				bkgNtcHisVO.setSndId(sndIds.get(i));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;
			
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
	} 	
	
	/**
	 * <br>
	 * 
	 * @author 		
	 * @param 		VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO
	 * @param 		List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs
	 * @param       SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void sendVskSkdYardCngNotice(VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO, List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs,  SignOnUserAccount account) throws Exception, DAOException {
		try{
			Mail mail = null;
			if(vslSkdYardCngNoticeVO.getEml() != null){		
				//스케쥴 String
				//" 3.   Vessel schedule \n"
				//"      KRPUSHN 2014-01-15 23:35(ETA) 2014-01-15 23:35(ETD) \n"
				StringBuffer vslSkdStrBuff = new StringBuffer(" 3.   Vessel schedule" + "\n");
				if(vslSkdCngDoubleCallEtcVOs!=null && vslSkdCngDoubleCallEtcVOs.size()>0){
					vslSkdYardCngNoticeVO.setVslSlanCd(vslSkdCngDoubleCallEtcVOs.get(0).getSlanCd());
					for(int i=0; i<vslSkdCngDoubleCallEtcVOs.size(); i++){
						vslSkdStrBuff.append("      ");
						vslSkdStrBuff.append(vslSkdCngDoubleCallEtcVOs.get(i).getYdCd()).append(" ");
						if(vslSkdCngDoubleCallEtcVOs.get(i).getVpsEtaDt()!=null)
							vslSkdStrBuff.append(vslSkdCngDoubleCallEtcVOs.get(i).getVpsEtaDt()).append("(ETA) ");
						if(vslSkdCngDoubleCallEtcVOs.get(i).getVpsEtdDt()!=null)
							vslSkdStrBuff.append(vslSkdCngDoubleCallEtcVOs.get(i).getVpsEtdDt()).append("(ETD) ");
						vslSkdStrBuff.append("\n");
					}
				}
				
				mail = new Mail();
				mail.setRdSubSysCd("BKG");
				mail.setFrom("noreply@smlines.com", account.getUsr_nm()); //보내는 사람 메일주소
				mail.setRecipient(vslSkdYardCngNoticeVO.getEml());  //받는 사람 메일주소
				mail.setSubject("[Double calling] Vessel schedule change Notice");
				mail.setTextContent(" Since the schedule of yard "+ vslSkdYardCngNoticeVO.getOldYdCd()
								+" has been changed, please check the below bookings and change them if needed." + "\n\n"
								+" 1.   Lane : " + vslSkdYardCngNoticeVO.getVslSlanCd() +"\n"
								+" 2.   VVD  : " + vslSkdYardCngNoticeVO.getVvd() +"\n"
								+vslSkdStrBuff.toString()
								+" 4.   The Booking’s current yard : " + vslSkdYardCngNoticeVO.getNewYdCd() +"\n"
								+" 5.   Booking list : " + vslSkdYardCngNoticeVO.getBkgList()+"\n"
							); //Text 로 된 본문 내용
				mail.send();
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Roll Over Notice 를 발송 한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param RollOverNoticeParamVO rollOverNoticeParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception Exception, DAOException
	 */
	public List<BkgNtcHisVO> sendRollOverNotice(BkgBlNoVO bkgBlNoVO, RollOverNoticeParamVO rollOverNoticeParamVO, SignOnUserAccount account) throws Exception, DAOException {
		List<String> sndIds = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		try {
			if(rollOverNoticeParamVO!=null && rollOverNoticeParamVO.getSrepEml()!=null && rollOverNoticeParamVO.getSrepEml().length()>0){
				String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
				boolean isLive = false;     // Live 여부
				if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
					isLive = true;
				}
				
				sndIds = new ArrayList<String>();
				
				Mail mail = null;
					
				mail = new Mail();
				mail.setRdSubSysCd("BKG");
				mail.setFrom("noreply@smlines.com"); //보내는 사람 메일주소
				//mail.setFrom(sUsrEml,account.getUsr_nm());
				mail.setRecipient(rollOverNoticeParamVO.getSrepEml());  //받는 사람 메일주소
				if(isLive){
					mail.setSubject("Roll Over Notice ("+bkgBlNoVO.getBkgNo()+" / "+rollOverNoticeParamVO.getCtrtNo()+" / "+rollOverNoticeParamVO.getCustNm()+")");
				}else{
					mail.setSubject("[Test Mail] Roll Over Notice ("+bkgBlNoVO.getBkgNo()+" / "+rollOverNoticeParamVO.getCtrtNo()+" / "+rollOverNoticeParamVO.getCustNm()+")");
				}
				mail.setHtmlContent("<b>Roll Over Notice (Booking No. "+bkgBlNoVO.getBkgNo()+")</b>" +
						"<br><br>Dear Sales representative," +
						"<br><br>Please be informed that your booking(s) below are rolled over" +
						"<br><br>- Booking No. " + bkgBlNoVO.getBkgNo() +
						"<br>- VVD : " + rollOverNoticeParamVO.getPreLane() + " " + rollOverNoticeParamVO.getPreVvd() +
						" to " + rollOverNoticeParamVO.getNewLane() + " " + rollOverNoticeParamVO.getNewVvd() +
						"<br><br>Please check with "+ rollOverNoticeParamVO.getBkgOfcCd() +" for the roll over reason." +
						"<br><br>SM Line Corporation"
							); //HTML 로 된 본문 내용
				sndIds.add(mail.send());
				
				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
				for (int i=0; i<sndIds.size(); i++) {
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
					bkgNtcHisVO.setNtcKndCd("RO"); // Standby 코드 추가
					bkgNtcHisVO.setNtcSeq("0");
					bkgNtcHisVO.setCustCntcTpCd(null);
					bkgNtcHisVO.setNtcEml(rollOverNoticeParamVO.getSrepEml());
					bkgNtcHisVO.setSndId(sndIds.get(i));
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
					bkgNtcHisVO.setDiffRmk("");
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
					bkgNtcHisVOs.add(bkgNtcHisVO);
				}
			}
			return bkgNtcHisVOs;
			
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
	} 
}

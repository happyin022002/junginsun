/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchEAIDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.13
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.13 류대영
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2010.11.17 이일민 [CHM-201006562-01] e-booking 관련 추가
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.08.03 이재위 [CHM-201218218] Simple S/I Download 기능 강화를 위한 CUP, ALPS 변경 요청
* * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차) - noreply@hanjin.com 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcFaxSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcMailSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RcvrBkgReviseNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration.BDRCorrectionDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.sms.SmsUtil;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.TblSubmitQueueVO;

/**
 * Booking Notice 관련 EAIDAO 연동 처리 트랙잭션을 처리한다.
 *
 * @author Jun Yong Jin
 * @see BDRCorrectionDBDAO
 * @since J2EE 1.4
 */
public class GeneralBookingSearchEAIDAO extends EAIDAOSupport {

	/**
	 * RD파일을 Fax로 전송
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByFax(BkgReceiptSendVO bkgReceiptSendVO,SignOnUserAccount account) throws Exception{

		FaxMetaInfo[] infos = new FaxMetaInfo[bkgReceiptSendVO.getBkgBlNoVos().length];

        try {
        	for(int i=0;i<bkgReceiptSendVO.getBkgBlNoVos().length;i++) {

				log.debug("/rv BKG_NO['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"'] USR_ID["+account.getUsr_id()+"] O_PS["+bkgReceiptSendVO.getRemarks()[i]+"] P_PORT_CARGO_CUT_DT["+bkgReceiptSendVO.getCcts()[i]+"] P_DOC_CUT_DT["+bkgReceiptSendVO.getDocCcts()[i]+"][Y]");

				infos[i] = new FaxMetaInfo("BKG"
    					,bkgReceiptSendVO.getMrdNm()+".mrd"
    					,"N"
    					,"Receipt Notice"
    					,"/rv BKG_NO['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"'] USR_ID["+account.getUsr_id()+"] O_PS["+bkgReceiptSendVO.getRemarks()[i]+"] P_PORT_CARGO_CUT_DT["+bkgReceiptSendVO.getCcts()[i]+"] P_DOC_CUT_DT["+bkgReceiptSendVO.getDocCcts()[i]+"][Y]"
    					,account.getUsr_nm() + ";" + bkgReceiptSendVO.getFaxNos()[i]
    					,account.getOfc_cd()
    					,account.getUsr_id());
        	}

			List<String> sndIds = FaxUtility.registerDB(infos);
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd("");
				bkgNtcHisVO.setNtcFaxNo(bkgReceiptSendVO.getFaxNos()[i]);
				bkgNtcHisVO.setSndId(sndIds.get(i));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk(bkgReceiptSendVO.getRemarks()[i]);
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;

        } catch (FaxSendException  faxe){
        	throw new Exception(faxe.getMessage(), faxe);
        } catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}

	/**
	 * RD Mail 전송
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param String fileKeys
 	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws MailerAppException 
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByEmail(BkgReceiptSendVO bkgReceiptSendVO, String fileKeys, SignOnUserAccount account) throws Exception{
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ArrayList<SingleMailAttachedFile> fileList = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		ComUserVO comUserVO = null;
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			} else { 
				sUsrEml ="noreply@smlines.com";
			}
			
			sndIds = new ArrayList<String>();
			if (null!=bkgReceiptSendVO.getBkgBlNoVos() && 0<bkgReceiptSendVO.getBkgBlNoVos().length) {
				for (int i=0; i<bkgReceiptSendVO.getBkgBlNoVos().length; i++) {
					log.debug("['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"']["+account.getUsr_id()+"] ["+bkgReceiptSendVO.getRemarks()[i]+"] ["+bkgReceiptSendVO.getCcts()[i]+"]["+bkgReceiptSendVO.getDocCcts()[i]+"][Y]");
					vo = new ComRptDsgnXptInfoVO();
					vo.setRdTmpltNm(bkgReceiptSendVO.getMrdNm()+".mrd");
					vo.setRdParaCtnt("/rv BKG_NO['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"'] USR_ID["+account.getUsr_id()+"] O_PS["+bkgReceiptSendVO.getRemarks()[i]+"] P_PORT_CARGO_CUT_DT["+bkgReceiptSendVO.getCcts()[i]+"] P_DOC_CUT_DT["+bkgReceiptSendVO.getDocCcts()[i]+"][Y]");
					vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					vo.setXptFileNm("SMLM"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+".pdf");
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					vos = new ArrayList<ComRptDsgnXptInfoVO>();
					vos.add(vo);

					if( fileKeys != null ){
						fileList = new ArrayList<SingleMailAttachedFile>();
						String[] file = fileKeys.split(";");
						for( String fileKey:file ){
							SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
							attachedFile.setFileKey(fileKey);
							fileList.add(attachedFile); 
						}
					}

					String [] arg = new String [2];
					arg[0] = bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo();
					StringBuilder[] content = util.getNotificationTemplated("BK", arg);
					
					template = new TemplateMail();
					template.setBatFlg("N");
					template.setComRptDsgnXptInfoVOs(vos);
//					template.setFrom(account.getUsr_eml(),account.getUsr_nm());
					template.setFrom(sUsrEml,account.getUsr_nm());
					template.setRecipient(bkgReceiptSendVO.getEmlAddrs()[i]);
					template.setAttachedFile(fileList);
					template.setCcRcvrEml(bkgReceiptSendVO.getCcEmail());
					
					template.setSubject("SM Line Booking Receipt Notice (BKG No : "+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+")");
					
					if("EN".equals(content[2].toString())){
						template.setHtmlTemplate("ESM_BKG_0098_01T.html");
						String vslNm = util.searchVesselNameByBkgNo(bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
						template.setArg("vslNmBody","- Vessel : "+vslNm);
					} else {
						template.setTextContent(content[1].toString());
					}
					template.setArg("bkgNoTitle","BKG No : "+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
					template.setArg("bkgNoBody",bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
					sndIds.add(template.send());
				}
				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
				for (int i=0; i<sndIds.size(); i++) {
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
					bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
					bkgNtcHisVO.setNtcKndCd("BK");
					bkgNtcHisVO.setNtcSeq("0");
					bkgNtcHisVO.setCustCntcTpCd(null);
					bkgNtcHisVO.setNtcEml(bkgReceiptSendVO.getEmlAddrs()[i]);
					bkgNtcHisVO.setSndId(sndIds.get(i));
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
					bkgNtcHisVO.setDiffRmk(bkgReceiptSendVO.getRemarks()[i]);
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

	/**
	 * RD Group Mail 전송
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param String fileKeys
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws MailerAppException 
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByGroupEmail(BkgReceiptSendVO bkgReceiptSendVO, String fileKeys, SignOnUserAccount account) throws Exception{
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ArrayList<SingleMailAttachedFile> fileList = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		StringBuilder strBkgNos = null;
		StringBuilder argBkgNos = null;
		int cnt = 0;
		ComUserVO comUserVO = null;
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			sndIds = new ArrayList<String>();
			strBkgNos = new StringBuilder();
			argBkgNos = new StringBuilder();
			cnt = -1;
			for (BkgBlNoVO bkgBlNoVO : bkgReceiptSendVO.getBkgBlNoVos()) {
				strBkgNos.append(bkgBlNoVO.getBkgNo()).append(", ");
				argBkgNos.append("'").append(bkgBlNoVO.getBkgNo()).append("',");
				cnt++;
			}
			strBkgNos.delete(strBkgNos.lastIndexOf(","), strBkgNos.length());
			argBkgNos.delete(argBkgNos.lastIndexOf(","), argBkgNos.length());

			log.debug("['"+argBkgNos+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[0]+"]["+bkgReceiptSendVO.getCcts()[0]+"]["+bkgReceiptSendVO.getDocCcts()[0]+"][Y]");

			vo = new ComRptDsgnXptInfoVO();
			vo.setRdTmpltNm(bkgReceiptSendVO.getMrdNm()+".mrd");
			vo.setRdParaCtnt("/rv BKG_NO["+argBkgNos+"] USR_ID["+account.getUsr_id()+"] O_PS["+bkgReceiptSendVO.getRemarks()[0]+"] P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]");
			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			vo.setXptFileNm("SMLM"+bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo()+".pdf");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setComRptDsgnXptInfoVOs(vos);
			template.setFrom(sUsrEml,account.getUsr_nm());
			fileList = new ArrayList<SingleMailAttachedFile>();
						
			if (null!=bkgReceiptSendVO.getBkgEmlEdtVo() && !"".equals(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtToEml())) {
				if( fileKeys != null ){
					String[] file = fileKeys.split(";");
					for( String fileKey:file ){
						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
						attachedFile.setFileKey(fileKey);
						fileList.add(attachedFile); 
					}
				}
				template.setAttachedFile(fileList);
				template.setRecipient(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtToEml());
				template.setCcRcvrEml(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtCcEml());
				template.setSubject(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtSubject());
//				if("EN".equals(content[2].toString())){
					template.setHtmlContent(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtContents());
//				} else {
//					template.setTextContent(content[1].toString());
//				}
			} else {
				String [] arg = new String [2];
				arg[0] = bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo();
				arg[1] = strBkgNos.toString();
				StringBuilder[] content = util.getNotificationTemplated("BK", arg);
				
				template.setRecipient(bkgReceiptSendVO.getEmlAddrs()[0]);
				template.setCcRcvrEml(bkgReceiptSendVO.getCcEmail());
				template.setSubject("SM Line Booking Receipt Notice (BKG No : "+bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo()+" and "+cnt+" bookings)"); 
				if("EN".equals(content[2].toString())){
					template.setHtmlTemplate("ESM_BKG_0098_01T.html");
				} else {
					template.setTextContent(content[1].toString());
				}
				template.setArg("bkgNoTitle","BKG No : "+bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo()+" and "+cnt+" bookings");
				template.setArg("bkgNoBody",strBkgNos.toString());
				template.setArg("vslNmBody","");
			}
			sndIds.add(template.send());

    		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (BkgBlNoVO bkgBlNoVO : bkgReceiptSendVO.getBkgBlNoVos()) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(bkgReceiptSendVO.getEmlAddrs()[0]);
				bkgNtcHisVO.setSndId(sndIds.get(0));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk(bkgReceiptSendVO.getRemarks()[0]);
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
	 * surrender notice, carrier haulage notice를 전송한다.<br>	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ntcKndCd
	 * @param String faxNo	 
	 * @param String mrdNm	 
	 * @param String param
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByFax(BkgBlNoVO bkgBlNoVO, String ntcKndCd, String faxNo, String mrdNm, String param, SignOnUserAccount account) throws Exception{
		FaxMetaInfo[] infos = new FaxMetaInfo[1];
        BookingUtil util = new BookingUtil();
		String title = "";
		String faxOfcCd = null;
		if(ntcKndCd.equals("SN")){
			title = "Original B/L Surrender Notice";
		} else if(ntcKndCd.equals("HI") || ntcKndCd.equals("HO")){
			title = "Carrier Haulage Notice";			
		}
        try {
			//Search FAX Office			
			faxOfcCd = util.searchGroupEmailAddrRSQL(bkgBlNoVO.getBkgNo(), account.getUsr_id(),"OFC", "BL");
			faxOfcCd = faxOfcCd.equals("") ? account.getOfc_cd():faxOfcCd;
			
			infos[0] = new FaxMetaInfo("BKG"
					,mrdNm+".mrd"
					,"N"
					,title // Title
					,param
					,account.getUsr_nm() + ";" + faxNo
					,faxOfcCd
					,account.getUsr_id());
			
			List<String> sndIds = FaxUtility.registerDB(infos);
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd(ntcKndCd);
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd("");
				bkgNtcHisVO.setNtcFaxNo(faxNo);
				bkgNtcHisVO.setSndId(sndIds.get(i));					
				bkgNtcHisVO.setSndOfcCd(faxOfcCd);
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
			return bkgNtcHisVOs;

        } catch (FaxSendException  faxe){
        	throw new Exception(faxe.getMessage(), faxe);
        } catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}
	
	/**
	 * surrender notice, carrier haulage notice를 전송한다.<br>	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param String mrdNm	 
	 * @param String param
	 * @param String ccEmail
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByEmail(BkgBlNoVO bkgBlNoVO, String ntcKndCd, String eml, String mrdNm, String param, String ccEmail, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws Exception { 
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ArrayList<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			sndIds = new ArrayList<String>();
			vo = new ComRptDsgnXptInfoVO();
			vo.setRdTmpltNm(mrdNm+".mrd");
			vo.setRdParaCtnt(param);
			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			vo.setXptFileNm("SMLM"+bkgBlNoVO.getBlNo()+".pdf");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setComRptDsgnXptInfoVOs(vos);

		    if( null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getFileKey())){
			     String[] file = bkgEmlEdtVO.getFileKey().split(";");
			     for( String fileKey:file ){
				      SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
				      attachedFile.setFileKey(fileKey);
				      fileList.add(attachedFile); 
			     }
			     template.setAttachedFile(fileList);
		    }
		    
			template.setFrom(sUsrEml,account.getUsr_nm());
			if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
				template.setRecipient(bkgEmlEdtVO.getEdtToEml());
				template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
				template.setSubject(bkgEmlEdtVO.getEdtSubject());
				template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
			} else {
				template.setRecipient(eml);
				template.setCcRcvrEml(ccEmail);
				if ("SN".equalsIgnoreCase(ntcKndCd)) {
					
	    			
					template.setSubject("SM Line O.B/L Surrender Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
					String lang = "";
	    			lang = util.searchBkgCustCntCd("S", bkgBlNoVO.getBkgNo());
	    			if(null != lang && "CN".equals(lang)){
	    				template.setHtmlTemplate("ESM_BKG_0095_07T.html");
	    			}else if(null != lang && "KR".equals(lang)){
	    				template.setHtmlTemplate("ESM_BKG_0095_08T.html");
	    			}else{
	    				template.setHtmlTemplate("ESM_BKG_0095_01T.html");
	    			}
					template.setArg("blNo",bkgBlNoVO.getBlNo());
				} else if ("HI".equalsIgnoreCase(ntcKndCd) || "HO".equalsIgnoreCase(ntcKndCd)) {
					template.setSubject("SM Line TRO Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
					template.setHtmlTemplate("ESM_BKG_0095_02T.html");
					template.setArg("blNo",bkgBlNoVO.getBlNo());
				}
			}
			sndIds.add(template.send());
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd(ntcKndCd);
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(eml);
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
	 * simple si notice를 전송한다.<br>	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param String fileKey	 
	 * @param String ccEmail
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgSimpleSiByEmail(BkgBlNoVO bkgBlNoVO, String ntcKndCd, String eml, String fileKey, String ccEmail, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws Exception { 
		List<String> sndIds = null;
		List<SingleMailAttachedFile> fileList = null;
		SingleMailAttachedFile atchFile = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		try {
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			sndIds = new ArrayList<String>();
			fileList = new ArrayList<SingleMailAttachedFile>();
			atchFile = new SingleMailAttachedFile();
			
			//파일 key를 이용한 파일 첨부
			atchFile.setFileKey(fileKey);
			fileList.add(atchFile);
			
			//ESM_BKG_0095 email(edit)에서 첨부된 파일
		    if(null!=bkgEmlEdtVO && bkgEmlEdtVO.getFileKey() != null ){
		        String[] file = bkgEmlEdtVO.getFileKey().split(";");
		        for( String sfileKey:file ){
		         SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
		         attachedFile.setFileKey(sfileKey);
		         fileList.add(attachedFile); 
		        }
		    }
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setAttachedFile(fileList);
			template.setFrom(sUsrEml,account.getUsr_nm());
			if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
				template.setRecipient(bkgEmlEdtVO.getEdtToEml());
				template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
				template.setSubject(bkgEmlEdtVO.getEdtSubject());
				template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
			} else {
				template.setRecipient(eml);
				template.setCcRcvrEml(ccEmail);
//				if ("SS".equalsIgnoreCase(ntcKndCd)) {
				template.setSubject("SM Line Simple S/I [B/L No : "+bkgBlNoVO.getBlNo()+"]");
				template.setHtmlTemplate("ESM_BKG_0095_03T.html");
				template.setArg("blNo",bkgBlNoVO.getBlNo());
//				} 
			}
			sndIds.add(template.send());

			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd(ntcKndCd);
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(eml);
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
	 * RD Mail 전송
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param String[] emlAddr
 	 * @param String[] remark
 	 * @param String mrdNm
 	 * @param String[] cct
 	 * @param String vslNm
 	 * @param SignOnUserAccount account
 	 * @param String title
 	 * @param String Contents
	 * @return List<BkgNtcHisVO>
	 * @throws MailerAppException 
	 */
	public List<BkgNtcHisVO> sendXterReceiptByEmail(BkgBlNoVO[] bkgBlNoVO, String[] emlAddr, String[] remark,String mrdNm,String[] cct,String vslNm,SignOnUserAccount account, String title, String Contents) throws Exception{
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
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
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			sndIds = new ArrayList<String>();
			for (int i=0; i<bkgBlNoVO.length; i++) {
				log.debug("['"+bkgBlNoVO[i].getBkgNo()+"']["+account.getUsr_id()+"]["+remark[i]+"]["+cct[i]+"][]");
				vo = new ComRptDsgnXptInfoVO();
				vo.setRdTmpltNm(mrdNm+".mrd");
				vo.setRdParaCtnt("/rv BKG_NO['"+bkgBlNoVO[i].getBkgNo()+"'] USR_ID["+account.getUsr_id()+"] O_PS["+remark[i]+"] P_PORT_CARGO_CUT_DT["+cct[i]+"] P_DOC_CUT_DT[]");
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm("SMLM"+bkgBlNoVO[i].getBkgNo()+".pdf");
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom(sUsrEml,account.getUsr_nm());
				template.setRecipient(emlAddr[i]);
				template.setSubject(title); 
				template.setHtmlTemplate("ESM_BKG_0098_01T.html");
				template.setTextContent(Contents);
				template.setComRptDsgnXptInfoVOs(vos);
				template.setArg("bkgNoTitle","BKG No : "+bkgBlNoVO[i].getBkgNo());
				template.setArg("bkgNoBody",bkgBlNoVO[i].getBkgNo());
				String vslNmBody = util.searchVesselNameByBkgNo(bkgBlNoVO[i].getBkgNo());
				template.setArg("vslNmBody","- Vessel : "+vslNmBody);
				sndIds.add(template.send());
			}
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(emlAddr[i]);
				bkgNtcHisVO.setSndId(sndIds.get(i));
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk(remark[i]);
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
	 * RD Fax를 전송한다.
	 * 
	 * @param BkgCustAvcNtcFaxSndVO bkgCustAvcNtcFaxSndVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws Exception
	 */	
    public String sendBkgCustAdvisoryNoticeByFax(BkgCustAvcNtcFaxSndVO bkgCustAvcNtcFaxSndVO, SignOnUserAccount account) throws Exception {
		String faxSndId = "";

		try{
			
			if (null!=bkgCustAvcNtcFaxSndVO.getBlNo() && !"".equals(bkgCustAvcNtcFaxSndVO.getBlNo())) {
				
				String strArgObl = "/rv ";
				
				strArgObl = strArgObl + " bl_no['" + bkgCustAvcNtcFaxSndVO.getBlNo() + "'] ";
				strArgObl = strArgObl + " bkg_no['" + bkgCustAvcNtcFaxSndVO.getBkgNo() + "'] ";
				strArgObl = strArgObl + " bkg_cust_tp_cd['" + bkgCustAvcNtcFaxSndVO.getBkgCustTpCd() + "'] ";
				strArgObl = strArgObl + " vvd['" + bkgCustAvcNtcFaxSndVO.getVvd() + "'] ";
				strArgObl = strArgObl + " ofc_cd['" + bkgCustAvcNtcFaxSndVO.getOfcCd() + "'] ";
				strArgObl = strArgObl + " cntr_no['" + bkgCustAvcNtcFaxSndVO.getCntrNo().replaceAll("\n", "#") + "'] ";
				strArgObl = strArgObl + " ctrt_eml_nm['" + bkgCustAvcNtcFaxSndVO.getCntrNm() + "'] ";
				
				
				log.debug("---------- strArgObl "+ strArgObl);
				
				FaxMetaInfo metaInfo = new FaxMetaInfo("BKG",     // 모듈명(ex.BKG)
	 		               "ESM_BKG_5039.mrd",   // MRD 파일 명 (ex.WO_NORMAL.mrd)
			               "N",  // 배치 유무(Y/N)
				           "Customer Advisory Fax Send",     // 제목
				           strArgObl, // RD Parameter (ex. [419][1][selho])
				           //faxInfo.getRcvInfo(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
				           bkgCustAvcNtcFaxSndVO.getCntrNm() + ";" + bkgCustAvcNtcFaxSndVO.getFaxNo().replaceAll("\r\n", " "),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
				           account.getOfc_cd(),    // 지역 FAX office
				           account.getUsr_id()  // 보내는 사람
				          ); 
				
				//실제 Fax 발송
				log.debug("실제 Fax 발송");
				log.debug("--------------------------------");
				faxSndId = FaxUtility.registerDB(metaInfo);
				log.debug("--------------------------------");
			}
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
		return faxSndId;
    }
    
	/**
	 * RD 메일을 전송한다.(Template 메일인 경우)
	 * 
	 * @param BkgCustAvcNtcMailSndVO bkgCustAvcNtcMailSndVO
	 * @param String urlPath
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws Exception
	 */	
    public String sendBkgCustAdvisoryNoticeByEmail(BkgCustAvcNtcMailSndVO bkgCustAvcNtcMailSndVO, String urlPath, SignOnUserAccount account) throws Exception {
		String sndId = "";
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		List<SingleMailAttachedFile> fileList = null;
		
		try{
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			
			if (null!=bkgCustAvcNtcMailSndVO.getBlNo() && !"".equals(bkgCustAvcNtcMailSndVO.getBlNo())) {
				
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom(sUsrEml,account.getUsr_nm());
				template.setSubject(bkgCustAvcNtcMailSndVO.getEmlTitNm());
				template.setRecipient(bkgCustAvcNtcMailSndVO.getRcvrEml());
				//template.setCcRcvrEml(bkgCustAvcNtcMailSndVO.getCcRcvrEml());
				
				if(bkgCustAvcNtcMailSndVO.getCntrNoViewFlg() != null && bkgCustAvcNtcMailSndVO.getCntrNoViewFlg().equals("Y")){
					template.setHtmlTemplate("ESM_BKG_0003T.html");
				}else{
					template.setHtmlTemplate("ESM_BKG_0003T_01.html");
				}
				
				String imgUrl = "http://www.smlines.com/hanjin/images/img/mail/report_customer_advisory.jpg";
				template.setArg("img", imgUrl);
				template.setArg("subject",bkgCustAvcNtcMailSndVO.getEmlTitNm());
				template.setArg("date",bkgCustAvcNtcMailSndVO.getSndDt());
				// 고객명을 html 형식으로 변환
				template.setArg("custNm",bkgCustAvcNtcMailSndVO.getRcvrNm().replaceAll("\n", "<br>"));
				template.setArg("blNo",bkgCustAvcNtcMailSndVO.getBlNo());
				
				String cntrNo = bkgCustAvcNtcMailSndVO.getCntrNo();
				cntrNo = cntrNo.replaceAll("\n", "<br>");
				cntrNo = cntrNo.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
				cntrNo = cntrNo.replaceAll("\\p{Space}", "&nbsp;");
				
				template.setArg("cntrNo",cntrNo);
				
				// 본문 내용을 html 형식으로 변환
				String rmk = bkgCustAvcNtcMailSndVO.getRmk();
				rmk = rmk.replaceAll("\n", "<br>");
				rmk = rmk.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
				rmk = rmk.replaceAll("\\p{Space}", "&nbsp;");
				template.setArg("rmk",rmk);
				
				// Attach File
				fileList = new ArrayList<SingleMailAttachedFile>();
				if( bkgCustAvcNtcMailSndVO.getFileKey() != null ){
					String[] fileKeys = bkgCustAvcNtcMailSndVO.getFileKey().split(";");
					for( String fileKey:fileKeys ){
						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
						attachedFile.setFileKey(fileKey);
						fileList.add(attachedFile); 
					}
				}
				template.setAttachedFile(fileList);

				sndId = template.send();
			}
		} catch (MailerAppException mae) {
			this.log.error(mae.getCause());
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
		return sndId;
    }


	/**
	 * @param Map<String, Object> mailSmsInfo
	 * @param String sndParam
	 * @return String
	 * @throws Exception
	 */
	public String sendMailByPodChange(Map<String, Object> mailSmsInfo, String sndParam) throws Exception {
		String sndId = "";
		ComRptDsgnXptInfoVO vo = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		try{
//			sbContents.append("\nException : " + errStr);
//			sbContents.append("\nReceive Message : " + rcvMsg);
			log.debug("\n\n sendMailByPodChange------start--------------------");
			// 메일발송
			Mail mail = new Mail();
			mail.setFrom((String) mailSmsInfo.get("FROM_EMAIL")); //보내는 사람 메일주소
			mail.setSubject((String) mailSmsInfo.get("EML_SUBJ_CTNT"));  //메일제목
			mail.setRecipient((String) mailSmsInfo.get("TO_EMAIL"));  //받는 사람 메일주소
//			mail.setRecipient("jaksal@cyberlogitec.com");  //받는 사람 메일주소
			mail.setTextContent((String) mailSmsInfo.get("TEXT")); //Text 로 된 본문 내용
			
			if("Y".equals(mailSmsInfo.get("FILE_ATCH_FLG"))){
				
				vo = new ComRptDsgnXptInfoVO();
				vo.setRdTmpltNm("ESM_BKG_0803.mrd");
				vo.setRdParaCtnt(sndParam);
				log.debug("\n\n sendMailByPodChange sndParam"+sndParam);
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm((String) mailSmsInfo.get("EML_SUBJ_CTNT")+".pdf");
				vo.setCreUsrId("SYSTEM");
				vo.setUpdUsrId("SYSTEM");
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				mail.setComRptDsgnXptInfoVOs(vos);
//				
//				ComRptDsgnXptInfoVO vo = null;
//				vo = new ComRptDsgnXptInfoVO();
//				vo.setRdTmpltNm("ESM_BKG_5005G.mrd");
//				vo.setRdParaCtnt("/rv BKG_NO['SEL468588500'] USR_ID[2000351] O_PS[] P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]");
//				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
//				vo.setXptFileNm("HJSC"+"SEL468588500"+".pdf");
//				vo.setCreUsrId("2000351");
//				vo.setUpdUsrId("2000351");
//				List<ComRptDsgnXptInfoVO> vos = new ArrayList<ComRptDsgnXptInfoVO>();
//				vos.add(vo);
//				mail.setComRptDsgnXptInfoVOs(vos);
//				List<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
//				SingleMailAttachedFile atchFile = new SingleMailAttachedFile();
//				atchFile.setFileKey("");
//				fileList.add(atchFile); 
//				mail.setAttachedFile(fileList);
			}

			sndId = mail.send();			
log.debug("\n\n sendMailByPodChange--------------------------");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sndId;
	}

	/**
	 * @param Map<String, Object> mailSmsInfo
	 * @return String
	 * @throws Exception
	 */
	public String sendSmsByPodChange(Map<String, Object> mailSmsInfo) throws Exception {
		String sndId = "";
		TblSubmitQueueVO tblSubmitQueueVO = new TblSubmitQueueVO();
		try{
//			sbContents.append("\nException : " + errStr);
//			sbContents.append("\nReceive Message : " + rcvMsg);
			// sms 발송
			tblSubmitQueueVO.setRcvPhnId((String) mailSmsInfo.get("TO_SMS"));  //받는 사람 phone 
			tblSubmitQueueVO.setSndPhnId("0237706909");  //KT용 보내는 사람 phone 
			tblSubmitQueueVO.setSndMsg((String) mailSmsInfo.get("TEXT")); //Text 로 된 본문 내용

			// Text 를 이용한 파일 첨부
/*			List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();

			SingleMailAttachedFile atchFile = new SingleMailAttachedFile();
			atchFile.setFileName("rcv_msg_" + System.currentTimeMillis() + ".txt");
			atchFile.setFileContent(rcvMsg);
			list.add(atchFile);
			mail.setAttachedFile(list);*/

			sndId = SmsUtil.send(tblSubmitQueueVO);	
			log.debug("\nsms sendId :"+ sndId);

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sndId;
	}
	
	/**
	 * Revised Rate notice를 전송한다.<br>	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String ntcKndCd
	 * @param String eml
	 * @param String mrdNm	 
	 * @param String param	 
	 * @param String ccEmail
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgRevisedRateByEmail(BkgBlNoVO bkgBlNoVO, String ntcKndCd, String eml, String mrdNm, String param, String ccEmail, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws Exception { 
		
		
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ArrayList<SingleMailAttachedFile> fileList = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			BLIssuanceBCImpl blIssuBC = new BLIssuanceBCImpl();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			String vslNm = blIssuBC.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			sndIds = new ArrayList<String>();
			vo = new ComRptDsgnXptInfoVO();
			vo.setRdTmpltNm(mrdNm+".mrd");
			vo.setRdParaCtnt(param);
			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			vo.setXptFileNm("SMLM"+bkgBlNoVO.getBlNo()+".pdf");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			fileList = new ArrayList<SingleMailAttachedFile>();
			template.setBatFlg("N");
			template.setComRptDsgnXptInfoVOs(vos);
			
			//esm_bkg_1096의 첨부파일 추가
		    if(null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getFileKey())){
		        String[] file = bkgEmlEdtVO.getFileKey().split(";");
		        for( String fileKey:file ){
			         SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
			         attachedFile.setFileKey(fileKey);
			         fileList.add(attachedFile); 
		        }
		        template.setAttachedFile(fileList);
		    }
		       
			template.setFrom(sUsrEml,account.getUsr_nm());
			template.setArg("blNoTitle", "T/VVD : "+vslNm+" / B/L No : "+bkgBlNoVO.getBkgNo());
			//contentsParam = !StringUtils.isEmpty(vo.getContents()) ? vo.getContents() : "blNoTitle;T/VVD : "+vslNm+" / B/L No : "+strBlNoTitle
			if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
				template.setRecipient(bkgEmlEdtVO.getEdtToEml());
				template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
				template.setSubject(bkgEmlEdtVO.getEdtSubject());
				template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
			} else {
				template.setRecipient(eml);
				template.setCcRcvrEml(ccEmail);
				if ("RR".equalsIgnoreCase(ntcKndCd)) {
				//template.setSubject("Draft B/L - Revised Rate [B/L No : "+bkgBlNoVO.getBlNo()+"]");
					
					template.setSubject("Draft B/L - Revised Rate (T/VVD :" +vslNm +"/ B/L No : " +bkgBlNoVO.getBlNo()+")");
					String lang = "";
	    			lang = util.searchBkgCustCntCd("S", bkgBlNoVO.getBkgNo());
	    			if(null != lang && "CN".equals(lang)){
	    				template.setHtmlTemplate("ESM_BKG_0095_05T.html");
	    			}else if(null != lang && "KR".equals(lang)){
	    				template.setHtmlTemplate("ESM_BKG_0095_06T.html");
	    			}else{
	    				template.setHtmlTemplate("ESM_BKG_0095_04T.html");
	    			}
					template.setArg("blNo",bkgBlNoVO.getBlNo());
				}
			}
			sndIds.add(template.send());
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(sndIds.size());
			for (int i=0; i<sndIds.size(); i++) {
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd(ntcKndCd);
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(eml);
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
	 * Booking Vessel Revised Notice 전송<br>
	 * @param List<RcvrBkgReviseNoticeVO> rcvBkgReviseNoticeVOs
	 * @param String vslCngRsn
	 * @param String receiptType
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgVslReviseNotice(List<RcvrBkgReviseNoticeVO> rcvBkgReviseNoticeVOs, String vslCngRsn, String receiptType, SignOnUserAccount account) throws Exception {
		try {
			List<String> sndIds = new ArrayList<String>();
			List<ComRptDsgnXptInfoVO> vos = null;
    		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			ComRptDsgnXptInfoVO vo = null;
			TemplateMail template = null;
			String [] arrBkgNos = null;
			List<BkgBlNoVO> bkgBlNoVOs = null;
			StringBuilder strBkgNos = null;
			StringBuilder argBkgNos = null;
			StringBuilder strAllBkgNos = null;
			ComUserVO comUserVO = null;
			int cnt = 0;
			
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}

			// receiver email address만큼 loop
			for(int i = 0; i < rcvBkgReviseNoticeVOs.size(); i++){
				cnt = 0;
				bkgBlNoVOs = new ArrayList<BkgBlNoVO>();
				strBkgNos = new StringBuilder();
				argBkgNos = new StringBuilder();
				strAllBkgNos = new StringBuilder();
				arrBkgNos = rcvBkgReviseNoticeVOs.get(i).getBkgNos().split(",");
				for(int j = 0; j < arrBkgNos.length; j++){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(arrBkgNos[j]);
					bkgBlNoVOs.add(bkgBlNoVO);
				}

				for (BkgBlNoVO bkgBlNoVO : bkgBlNoVOs) {
					if(cnt < 4){
						strBkgNos.append(bkgBlNoVO.getBkgNo()).append(", ");
					}
					strAllBkgNos.append(bkgBlNoVO.getBkgNo()).append(", ");
					argBkgNos.append("'").append(bkgBlNoVO.getBkgNo()).append("',");
					cnt++;
				}
				
				strBkgNos.delete(strBkgNos.lastIndexOf(","), strBkgNos.length());
				argBkgNos.delete(argBkgNos.lastIndexOf(","), argBkgNos.length());
				strAllBkgNos.delete(strAllBkgNos.lastIndexOf(","), strAllBkgNos.length());

				vo = new ComRptDsgnXptInfoVO();
				if(receiptType.equals("China")){
					vo.setRdTmpltNm("ESM_BKG_5005C.mrd");
				} else {
					vo.setRdTmpltNm("ESM_BKG_5005G.mrd");					
				}
				vo.setRdParaCtnt("/rv BKG_NO["+argBkgNos+"] USR_ID["+account.getUsr_id()+"] O_PS[] P_PORT_CARGO_CUT_DT[] P_DOC_CUT_DT[][Y]");
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm("SMLM"+bkgBlNoVOs.get(0).getBkgNo()+".pdf");
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setComRptDsgnXptInfoVOs(vos);
				template.setFrom(sUsrEml, account.getUsr_nm());				
				template.setRecipient(rcvBkgReviseNoticeVOs.get(i).getNtcEml());
				template.setCcRcvrEml(""); 
				template.setHtmlTemplate("ESM_BKG_0098_02T.html");
				if(cnt > 1){
					template.setSubject("[RVSD] SM Line Booking Receipt Notice (BKG No : "+strBkgNos+", etc. total "+cnt+" bookings)");
					template.setArg("bkgNoTitle","BKG No : "+strBkgNos+", etc. total "+cnt+" bookings");
				} else {
					template.setSubject("[RVSD] SM Line Booking Receipt Notice (BKG No : "+strBkgNos+")");
					template.setArg("bkgNoTitle","BKG No : "+strBkgNos);					
				}
				if(vslCngRsn.equals("PortSkip")){
					template.setArg("vslCngRsn","Port Skip");
				} else if(vslCngRsn.equals("RotationChange")){
					template.setArg("vslCngRsn","Rotation Change");
				} else {
					template.setArg("vslCngRsn","Vessel Phase Out");
				}
				template.setArg("bkgNoBody",strBkgNos.toString());
				sndIds.add(template.send());

				for (BkgBlNoVO bkgBlNoVO : bkgBlNoVOs) {
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
					bkgNtcHisVO.setNtcKndCd("BK");
					bkgNtcHisVO.setNtcSeq("0");
					bkgNtcHisVO.setCustCntcTpCd(null);
					bkgNtcHisVO.setNtcEml(rcvBkgReviseNoticeVOs.get(i).getNtcEml());
					bkgNtcHisVO.setSndId(sndIds.get(i));
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
					bkgNtcHisVO.setDiffRmk(vslCngRsn);
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

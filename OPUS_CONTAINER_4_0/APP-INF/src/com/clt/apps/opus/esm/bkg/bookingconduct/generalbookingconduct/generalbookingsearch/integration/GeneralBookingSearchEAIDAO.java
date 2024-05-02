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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration.BDRCorrectionDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.ComUserVO;

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
		BookingUtil util = new BookingUtil();
        try {
        	for(int i = 0; i < bkgReceiptSendVO.getBkgBlNoVos().length; i++) {

        		if(i == 0){
        			BkgRouteVO bkgRouteVO = util.searchBkgRoute(bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
    				if (0 == bkgRouteVO.getPorCd().indexOf("US")) {
    					bkgReceiptSendVO.setMrdNm("ESM_BKG_5005G_LETTER");
    				}
        		}
        		
        		log.debug("['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[i]+"]["+bkgReceiptSendVO.getCcts()[i]+"]["+bkgReceiptSendVO.getDocCcts()[i]+"][Y][][][][]");

				infos[i] = new FaxMetaInfo("BKG"
    					,bkgReceiptSendVO.getMrdNm()+".mrd"
    					,"N"
    					,"Receipt Notice(BKG#: "+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+")"
    					,"['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[i]+"]["+bkgReceiptSendVO.getCcts()[i]+"]["+bkgReceiptSendVO.getDocCcts()[i]+"][Y][][][][]"
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
 	 * @param SignOnUserAccount account
 	 * @param String type
	 * @return List<BkgNtcHisVO>
	 * @throws MailerAppException 
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByEmail(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account, String type) throws Exception{
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		ComUserVO comUserVO = null;
		BkgRouteVO bkgRouteVO = null;
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			sUsrEml = "shipment.info@notifications.nykline.com";
			
			sndIds = new ArrayList<String>();
			if (null!=bkgReceiptSendVO.getBkgBlNoVos() && 0<bkgReceiptSendVO.getBkgBlNoVos().length) {
				for (int i=0; i<bkgReceiptSendVO.getBkgBlNoVos().length; i++) {
					log.debug("['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[i]+"]["+bkgReceiptSendVO.getCcts()[i]+"]["+bkgReceiptSendVO.getDocCcts()[i]+"][Y][][][][]");
					vo = new ComRptDsgnXptInfoVO();
					
					if(bkgReceiptSendVO.getMrdNm().equals("ESM_BKG_5005G")){
						bkgRouteVO = util.searchBkgRoute(bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo());
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							bkgReceiptSendVO.setMrdNm("ESM_BKG_5005G_LETTER");
						}
					}
					
					vo.setRdTmpltNm(bkgReceiptSendVO.getMrdNm()+".mrd");
					vo.setRdParaCtnt("/rp ['"+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[i]+"]["+bkgReceiptSendVO.getCcts()[i]+"]["+bkgReceiptSendVO.getDocCcts()[i]+"][Y][][][][]");
					vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					vo.setXptFileNm(ConstantMgr.getScacCode()+bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+".pdf");
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					vos = new ArrayList<ComRptDsgnXptInfoVO>();
					vos.add(vo);
					template = new TemplateMail();
					template.setBatFlg("N");
					template.setComRptDsgnXptInfoVOs(vos);
//					template.setFrom(account.getUsr_eml(),account.getUsr_nm());
					template.setFrom(sUsrEml,"");
					template.setRecipient(bkgReceiptSendVO.getEmlAddrs()[i]);
					template.setCcRcvrEml(bkgReceiptSendVO.getCcEmail());
					
					String bccRcvrEml = util.searchBccEmailAddrRSQL("BK");
					if (!StringUtils.isBlank(bccRcvrEml)) {
						template.setBccRcvrEml(bccRcvrEml);
					} 
					
					template.setSubject(bkgReceiptSendVO.getBkgBlNoVos()[i].getBkgNo()+" - NYK Booking Receipt Notice");
					if ("0095".equals(type)) {
						template.setHtmlTemplate("ESM_BKG_0095_03T.html");
					}else{
						template.setHtmlTemplate("ESM_BKG_0098_02T.html");
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
	 * 
	 * @param bkgReceiptSendVO
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByCustGroupEmail(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws Exception{
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		try {
			ComUserVO comUserVO = null;
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			
			String bccRcvrEml = util.searchBccEmailAddrRSQL("BK");
			BkgBlNoVO[] bkgBlNoVos = bkgReceiptSendVO.getBkgBlNoVos();
			for (int j = 0; j < bkgBlNoVos.length; j++) {
				BkgBlNoVO bkgBlNoVO = bkgBlNoVos[j];
				StringBuffer rdParam = new StringBuffer("/rp ['" + bkgBlNoVO.getBkgNo() + "'][" + account.getUsr_id() + "][]");
				if("ESM_BKG_5005G".equals(bkgReceiptSendVO.getMrdNm()) || "ESM_BKG_5005G_LETTER".equals(bkgReceiptSendVO.getMrdNm())){
					if(bkgReceiptSendVO.getBkgBlNoVos() != null){
						BkgRouteVO bkgRouteVO = util.searchBkgRoute(bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo());
						if (0 == bkgRouteVO.getPorCd().indexOf("US")) {
							bkgReceiptSendVO.setMrdNm("ESM_BKG_5005G_LETTER");
						}
					}
					rdParam.append("[][][Y][][" + bkgBlNoVO.getBkgNo() + "][Y][" + bkgBlNoVO.getRemark() + "%40%23]");
				}
				ComRptDsgnXptInfoVO vo = new ComRptDsgnXptInfoVO();
				List<ComRptDsgnXptInfoVO> vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vo = new ComRptDsgnXptInfoVO();
				vo.setRdTmpltNm(bkgReceiptSendVO.getMrdNm()+".mrd");
				vo.setRdParaCtnt(rdParam.toString());
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm(ConstantMgr.getScacCode()+bkgBlNoVO.getBkgNo()+".pdf");
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vos.add(vo);
				
				TemplateMail template = new TemplateMail();
				template.setComRptDsgnXptInfoVOs(vos);
				template.setFrom(sUsrEml);
				template.setRecipient(bkgBlNoVO.getEml());
				template.setSubject("Booking Email Customer Notification (BKG No : " + bkgBlNoVO.getBkgNo() + ")");
				template.setHtmlContent(bkgReceiptSendVO.getCustBody());
				if (!StringUtils.isBlank(bccRcvrEml)) {
					template.setBccRcvrEml(bccRcvrEml);
				} 
				String sendId = template.send();
				
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M");  //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("BK");
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setNtcEml(bkgBlNoVO.getEml());
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk(bkgBlNoVO.getRemark());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
		} catch (MailerAppException mae) {
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		return bkgNtcHisVOs;
	}
	
	/**
	 * RD Group Mail 전송
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws MailerAppException 
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByGroupEmail(BkgReceiptSendVO bkgReceiptSendVO,SignOnUserAccount account) throws Exception{
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		StringBuilder strBkgNos = null;
		StringBuilder argBkgNos = null;
		StringBuilder arrBkgNos = null;
		StringBuilder strBkgNosNoQuote = null;
		StringBuilder strMultiRemark = null;
		String rdParam = null;
		int cnt = 0;
		int i =0;
		ComUserVO comUserVO = null;
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			sUsrEml = "shipment.info@notifications.nykline.com";
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			sndIds = new ArrayList<String>();
			strBkgNos = new StringBuilder();
			argBkgNos = new StringBuilder();
			arrBkgNos = new StringBuilder();
			strBkgNosNoQuote = new StringBuilder();
			strMultiRemark = new StringBuilder();
			cnt = -1;
			for (BkgBlNoVO bkgBlNoVO : bkgReceiptSendVO.getBkgBlNoVos()) {
				strBkgNos.append(bkgBlNoVO.getBkgNo()).append(", ");
				argBkgNos.append("'").append(bkgBlNoVO.getBkgNo()).append("',");
				arrBkgNos.append(bkgBlNoVO.getBkgNo()).append("; ");
				strMultiRemark.append(bkgReceiptSendVO.getRemarks()[i]).append("%40%23"); //%40%23 is @# and separator for remark to divide it by Booking No
				cnt++;
				i++;
			}
			strBkgNosNoQuote.append(strBkgNos);
			strBkgNos.delete(strBkgNos.lastIndexOf(","), strBkgNos.length());
			argBkgNos.delete(argBkgNos.lastIndexOf(","), argBkgNos.length());
			arrBkgNos.delete(arrBkgNos.lastIndexOf(";"), arrBkgNos.length());

//			log.debug("['"+argBkgNos+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[0]+"][][][Y]");
//			log.debug("['"+argBkgNos+"']["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[0]+"][][][Y][][][][]");

			rdParam = "/rp [" + argBkgNos + "][" + account.getUsr_id() + "][]";
			if("ESM_BKG_5005G".equals(bkgReceiptSendVO.getMrdNm()) || "ESM_BKG_5005G_LETTER".equals(bkgReceiptSendVO.getMrdNm())){
				if(bkgReceiptSendVO.getBkgBlNoVos() != null){
					BkgRouteVO bkgRouteVO = util.searchBkgRoute(bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo());
					if (0 == bkgRouteVO.getPorCd().indexOf("US")) {
						bkgReceiptSendVO.setMrdNm("ESM_BKG_5005G_LETTER");
					}
				}
				rdParam += "[][][Y][][" + strBkgNosNoQuote + "][Y][" + strMultiRemark + "]";
			}

			log.debug(rdParam);

			vo = new ComRptDsgnXptInfoVO();
			vo.setRdTmpltNm(bkgReceiptSendVO.getMrdNm()+".mrd");
//			vo.setRdParaCtnt("/rp ["+argBkgNos+"]["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[0]+"][][][Y]");
//			vo.setRdParaCtnt("/rp ["+argBkgNos+"]["+account.getUsr_id()+"]["+bkgReceiptSendVO.getRemarks()[0]+"][][][Y][][][][]");
			vo.setRdParaCtnt(rdParam);
			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			vo.setXptFileNm(ConstantMgr.getScacCode()+bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo()+".pdf");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setComRptDsgnXptInfoVOs(vos);
			template.setFrom(sUsrEml,"");
			
			if (null!=bkgReceiptSendVO.getBkgEmlEdtVo() && !"".equals(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtToEml())) {
				template.setRecipient(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtToEml());
				template.setCcRcvrEml(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtCcEml());
				template.setSubject(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtSubject());
				template.setHtmlContent(bkgReceiptSendVO.getBkgEmlEdtVo().getEdtContents());
			} else {
				template.setRecipient(bkgReceiptSendVO.getEmlAddrs()[0]);
				template.setCcRcvrEml(bkgReceiptSendVO.getCcEmail());
//				template.setSubject("Booking Receipt Notice (BKG No : "+bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo()+" and "+cnt+" bookings)"); 
				template.setSubject(arrBkgNos+" - NYK Booking Receipt Notice");
				
//				template.setHtmlTemplate("ESM_BKG_0098_01T.html");
				template.setHtmlTemplate("ESM_BKG_0098_02T.html");
				template.setArg("bkgNoTitle","BKG No : "+bkgReceiptSendVO.getBkgBlNoVos()[0].getBkgNo()+" and "+cnt+" bookings");
				template.setArg("bkgNoBody",strBkgNos.toString());
			}
			
			String bccRcvrEml = util.searchBccEmailAddrRSQL("BK");
			if (!StringUtils.isBlank(bccRcvrEml)) {
				template.setBccRcvrEml(bccRcvrEml);
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
		String title = "";
		String faxOfcCd = account.getOfc_cd();
		if(ntcKndCd.equals("SN")){
			title = "Original BL Surrender Notice"+"(BKG#: "+bkgBlNoVO.getBkgNo() +")";
		} else if(ntcKndCd.equals("HI") || ntcKndCd.equals("HO")){
			title = "Carrier Haulage Notice"+"(BKG#: "+bkgBlNoVO.getBkgNo() +")";			
		}
        try {
			
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
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		ComUserVO comUserVO = null;
		try {
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = "";
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			sndIds = new ArrayList<String>();
			vo = new ComRptDsgnXptInfoVO();
			vo.setRdTmpltNm(mrdNm+".mrd");
			vo.setRdParaCtnt(param);
			vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			vo.setXptFileNm(ConstantMgr.getScacCode()+bkgBlNoVO.getBlNo()+".pdf");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setComRptDsgnXptInfoVOs(vos);
			template.setAttachedFile(new ArrayList<SingleMailAttachedFile>());
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
					template.setSubject("O.B/L Surrender Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
					template.setHtmlTemplate("ESM_BKG_0095_01T.html");
					template.setArg("blNo",bkgBlNoVO.getBlNo());
				} else if ("HI".equalsIgnoreCase(ntcKndCd) || "HO".equalsIgnoreCase(ntcKndCd)) {
					template.setSubject("TRO Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
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
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
			sndIds = new ArrayList<String>();
			for (int i=0; i<bkgBlNoVO.length; i++) {
				log.debug("['"+bkgBlNoVO[i].getBkgNo()+"']["+account.getUsr_id()+"]["+remark[i]+"]["+cct[i]+"][][Y][][][][]");
				vo = new ComRptDsgnXptInfoVO();
				
				if(!"".equals(mrdNm)){
					vo.setRdTmpltNm(mrdNm+".mrd");
//					vo.setRdParaCtnt("/rp ['"+bkgBlNoVO[i].getBkgNo()+"']["+account.getUsr_id()+"]["+remark[i]+"]["+cct[i]+"][]");
					vo.setRdParaCtnt("/rp ['"+bkgBlNoVO[i].getBkgNo()+"']["+account.getUsr_id()+"]["+remark[i]+"]["+cct[i]+"][][Y][][][][]");
					vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					vo.setXptFileNm(ConstantMgr.getScacCode()+bkgBlNoVO[i].getBkgNo()+".pdf");
				}
				
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom("noreply@nykline.com");
				template.setRecipient(emlAddr[i]);
				template.setSubject(title); 
				template.setHtmlContent(Contents);
				if(!"".equals(mrdNm)){
					template.setComRptDsgnXptInfoVOs(vos);
				}
				
				template.setArg("bkgNoBody", bkgBlNoVO[i].getBkgNo());
				
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
}

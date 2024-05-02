/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCustomsReportEAIDAO.java
 *@FileTitle : CndCustomsReportEAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.basic.CndCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * NIS2010 CndCustomsReportEAIDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min Jeong
 * @see CndCustomsReportBCImpl 참조
 * @since J2EE 1.4
 */
public class CndCustomsReportEAIDAO extends EAIDAOSupport {

	/**
	 * FAX : Rd Fax 를 전송한다.
	 * 
	 * @param cndCstmsReportVOs 조회결과
	 * @param account 세션정보
	 * @return List<BkgNtcHisVO>
	 * @throws EAIException
	 */
	public List<BkgNtcHisVO> sendAvcNoteFax(List<CndCstmsReportVO> cndCstmsReportVOs, SignOnUserAccount account)
			throws EAIException {
		try
		{
			// 실제 Fax 걸기
			List<CndCstmsReportVO> faxList = new ArrayList<CndCstmsReportVO>();
			// Fax No.별 B/L No.세팅
			List<String> blList = new ArrayList<String>();
			/**********************************************************
			 * 동일한 Fax No.에 대해 한번만 팩스를 건다.<br>
			 * 동일한 Fax No.를 계속 호출하면 통화중되서 실패를 방지<br>
			 * 1. Fax No.를 소트 <br>
			 * 2. 같은 번호이면 blList에 BL No.만 add<br>
			 * 3. 동일 Fax No. 동일 BL No.가 있을 경우 blList에서 제외
			 **********************************************************/
			Comparator<CndCstmsReportVO> comparator = new Comparator<CndCstmsReportVO>() {
				public int compare(CndCstmsReportVO vo1, CndCstmsReportVO vo2) {
					return vo1.getFaxNo1().compareTo(vo2.getFaxNo1());
				}
			};
			Collections.sort(cndCstmsReportVOs, comparator);
			for (int i = 0; i < cndCstmsReportVOs.size(); i++)
			{
				CndCstmsReportVO cndCstmsReportVO = cndCstmsReportVOs.get(i);
				boolean chkFax = false;
				for (int j = 0; j < faxList.size(); j++)
				{
					if (cndCstmsReportVO.getFaxNo1().equals(faxList.get(j).getFaxNo1()))
					{
						chkFax = true;
						blList.add(cndCstmsReportVO.getBlNo());
						break;
					}
				}
				if (!chkFax)
				{
					if (i > 0 && blList.size() > 0)
					{
						List<String> list = faxList.get(faxList.size() - 1).getBlNoList();
						for (int blCnt = 0; blCnt < blList.size(); blCnt++)
						{
							list.add(blList.get(blCnt));
						}
						faxList.get(faxList.size() - 1).setBlNoList(list);
					}
					faxList.add(cndCstmsReportVO);
					blList.clear();
				}
			}
			if (blList.size() > 0)
			{
				List<String> list = faxList.get(faxList.size() - 1).getBlNoList();
				for (int i = 0; i < blList.size(); i++)
				{
					list.add(blList.get(i));
				}
				faxList.get(faxList.size() - 1).setBlNoList(list);
			}
			// 중복 BL 제거 : 동일한 BL No.에 동일한 Consignee Fax No.가 있는 경우 BL을 한번만 보냄.
			for (int i = 0; i < faxList.size(); i++)
			{
				CndCstmsReportVO cndCstmsReportVO = faxList.get(i);
				for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
				{
					if (j > 0
							&& cndCstmsReportVO.getBlNoList().get(j).equals(cndCstmsReportVO.getBlNoList().get(j - 1)))
					{
						cndCstmsReportVO.getBlNoList().remove(j);
						j--;
					}
				}
			}
			String sndId = "";
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			for (int i = 0; i < faxList.size(); i++)
			{
				CndCstmsReportVO cndCstmsReportVO = faxList.get(i);
				StringBuffer sbBlNo = new StringBuffer();
				for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
				{
					sbBlNo.append("'");
					sbBlNo.append(cndCstmsReportVO.getBlNoList().get(j));
					sbBlNo.append("'");
					if (cndCstmsReportVO.getBlNoList().size() > 0 && j < cndCstmsReportVO.getBlNoList().size() - 1)
						sbBlNo.append(",");
				}
				FaxMetaInfo faxMetaInfo = new FaxMetaInfo("BKG", // 모듈명(ex.BKG)
						"ESM_BKG_0026.mrd", // MRD 파일 명 (ex.WO_NORMAL.mrd)
						"N", // 배치 유무(Y/N)
						"Advice Notes (B/L No : " + cndCstmsReportVO.getBlNo() + ")", // 제목
						"/rv form_blNo[( " + sbBlNo.toString() + ")] form_ofcCd[" + account.getOfc_cd()
								+ "]",
						// RD Parameter (ex. [419][1][selho])
						account.getUsr_id() + ";" + cndCstmsReportVO.getFaxNo1(),
						// 이름+FAX번호 (받는 사람1;fax1,받는사람2;fax2)
						cndCstmsReportVO.getFaxOfcCd(), // 지역 FAX office
						account.getUsr_id() // 보내는 사람
				);
				// 팩스발송
				sndId = FaxUtility.registerDB(faxMetaInfo);
				/*************************************************
				 * 동일한 팩스는 다른BL이라도 동시에 발송시키지만<br>
				 * HISTORY 테이블에는 BKG NO에 따라 모두 등록시켜야 하기때문에<br>
				 * 다시 for loop 실행 
				 *************************************************/
				for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
				{
					String sBlNo = cndCstmsReportVO.getBlNoList().get(j);
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					for (int k=0; k<cndCstmsReportVOs.size(); k++)
					{
						if (sBlNo.equals(cndCstmsReportVOs.get(k).getBlNo())) {
							bkgNtcHisVO.setBkgNo(cndCstmsReportVOs.get(k).getBkgNo());
							break;
						}
					}
					bkgNtcHisVO.setNtcViaCd("F"); // F:Fax,M:Email
					bkgNtcHisVO.setNtcKndCd("AV");
					bkgNtcHisVO.setNtcSeq("0");
					bkgNtcHisVO.setCustCntcTpCd(cndCstmsReportVO.getCustCntcTpCd1());
					bkgNtcHisVO.setNtcFaxNo(cndCstmsReportVO.getFaxNo1());
					bkgNtcHisVO.setSndId(sndId);
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
					bkgNtcHisVO.setDiffRmk("Advice Notes (Canada)");
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
					bkgNtcHisVOs.add(bkgNtcHisVO);
				}
			}
			return bkgNtcHisVOs;
		}
		catch (Exception ex)
		{
			throw new EAIException(ex.getMessage(), ex);
		}
	}

	/**
	 * Mail : RDMail을 전송한다.
	 * 
	 * @param cndCstmsReportVOs 조회결과
	 * @param account 세션정보
	 * @return List<BkgNtcHisVO>
	 * @throws EAIException
	 */
	public List<BkgNtcHisVO> sendAvcNoteEmail(List<CndCstmsReportVO> cndCstmsReportVOs, SignOnUserAccount account) 
		throws EAIException {
		try
		{
			String chkAttach = cndCstmsReportVOs.get(0).getAttachFlg();
			int iAttachMaxCnt = 0;
			if ("true".equals(chkAttach))
				iAttachMaxCnt = Integer.parseInt(cndCstmsReportVOs.get(0).getAttachMaxCnt());
			List<CndCstmsReportVO> mailList = new ArrayList<CndCstmsReportVO>();
			if ("true".equals(chkAttach))
			{
				Comparator<CndCstmsReportVO> comparator = new Comparator<CndCstmsReportVO>() {
					public int compare(CndCstmsReportVO vo1, CndCstmsReportVO vo2) {
						return vo1.getNtcEml1().compareTo(vo2.getNtcEml1());
					}
				};
				Collections.sort(cndCstmsReportVOs, comparator);
				// E-Mail별 B/L을 첨부해서 송부
				List<String> blList = new ArrayList<String>();
				for (int i = 0; i < cndCstmsReportVOs.size(); i++)
				{
					CndCstmsReportVO cndCstmsReportVO = cndCstmsReportVOs.get(i);
					boolean chkMailAddr = false;
					for (int j = 0; j < mailList.size(); j++)
					{
						if (cndCstmsReportVO.getNtcEml1().equals(mailList.get(j).getNtcEml1()))
						{
							chkMailAddr = true;
							blList.add(cndCstmsReportVO.getBlNo());
							break;
						}
					}
					if (!chkMailAddr)
					{
						if (i > 0 && blList.size() > 0)
						{
							List<String> list = mailList.get(mailList.size() - 1).getBlNoList();
							for (int blCnt = 0; blCnt < blList.size(); blCnt++)
							{
								list.add(blList.get(blCnt));
							}
							mailList.get(mailList.size() - 1).setBlNoList(list);
						}
						mailList.add(cndCstmsReportVO);
						blList.clear();
					}
				}
				if (blList.size() > 0)
				{
					List<String> list = mailList.get(mailList.size() - 1).getBlNoList();
					for (int i = 0; i < blList.size(); i++)
					{
						list.add(blList.get(i));
					}
					mailList.get(mailList.size() - 1).setBlNoList(list);
				}
				

				// 중복 BL 제거
				for (int i = 0; i < mailList.size(); i++)
				{
					CndCstmsReportVO cndCstmsReportVO = mailList.get(i);
					for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
					{
						if (j > 0
								&& cndCstmsReportVO.getBlNoList().get(j).equals(cndCstmsReportVO.getBlNoList().get(j - 1)))
						{
							cndCstmsReportVO.getBlNoList().remove(j);
							j--;
						}
					}
					if (iAttachMaxCnt > 0 && cndCstmsReportVO.getBlNoList().size() > iAttachMaxCnt)
					{
						mailList.remove(i);
						i--;
						List<String> list2 = new ArrayList<String>();
						CndCstmsReportVO temp = new CndCstmsReportVO();
						temp.setNtcEml1(cndCstmsReportVO.getNtcEml1());
						for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
						{
							list2.add(cndCstmsReportVO.getBlNoList().get(j));
							if (list2.size() == iAttachMaxCnt)
							{
								temp.setBlNoList(list2);
								mailList.add(temp);
								list2 = new ArrayList<String>();
								temp = new CndCstmsReportVO();
								temp.setNtcEml1(cndCstmsReportVO.getNtcEml1());
							}
						}
						if (list2.size() > 0)
						{
							cndCstmsReportVO.setBlNoList(list2);
							mailList.add(cndCstmsReportVO);
						}
					}
				}
			}
			else
			{
				// B/L별로 각각 E-Mail 송부
				for (int i = 0; i < cndCstmsReportVOs.size(); i++)
				{
					CndCstmsReportVO cndCstmsReportVO = cndCstmsReportVOs.get(i);
					List<String> blNoList = new ArrayList<String>();
					blNoList.add(cndCstmsReportVO.getBlNo());
					cndCstmsReportVO.setBlNoList(blNoList);
					mailList.add(cndCstmsReportVO);
				}
			}
			// HISTORY TABLE INSERT위해
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			String sndId = "";
			for (int i = 0; i < mailList.size(); i++)
			{
				CndCstmsReportVO cndCstmsReportVO = mailList.get(i);
				Mail mail = new Mail();
				// 보내는사람
				mail.setFrom("noreply@smlines.com", "SM Line");
				// 제목
				StringBuffer sbBlNm = new StringBuffer();
				if (cndCstmsReportVO.getBlNoList().size() == 1)
					sbBlNm.append("[B/L No : " + cndCstmsReportVO.getBlNoList().get(0) + "] ");
				mail.setSubject(sbBlNm.toString() + "Advice Notes from SM Line");
				// 받는사람
				mail.setRecipient(cndCstmsReportVO.getNtcEml1());
				// 내용
				StringBuffer sbCtnt = new StringBuffer();
				sbCtnt.append("Dear Messrs. ");
				if (!"".equals(cndCstmsReportVO.getCustNm())) {
					sbCtnt.append("[" + (cndCstmsReportVO.getCustNm().replaceAll("\r\n", " ")).replaceAll("\n", " ") + "]");
				}
				sbCtnt.append("\n\n");
				sbCtnt.append("Thanks for using SM Line Corporation. [918P]").append("\n");
				sbCtnt.append("We hereby attached Advice Notes of your cargo.");
				if (cndCstmsReportVO.getBlNoList().size() == 1)
					sbCtnt.append(" [" + cndCstmsReportVO.getBlNo() + "]");
				sbCtnt.append("\n\n");
				sbCtnt.append("Would you please kindly find further detail with the Attached.").append("\n\n");
				sbCtnt.append("Sincerely.").append("\n\n");
				sbCtnt.append("SM Line").append("\n\n");
				mail.setTextContent(sbCtnt.toString());
				
				// 첨부파일(MRD파일)
				List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
				comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setRdTmpltNm("ESM_BKG_0026.mrd");
				// RD PARAMETER
				StringBuffer sbBlNo = new StringBuffer();
				for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
				{
					sbBlNo.append("'");
					sbBlNo.append(cndCstmsReportVO.getBlNoList().get(j));
					sbBlNo.append("'");
					if (cndCstmsReportVO.getBlNoList().size() > 0 && j < cndCstmsReportVO.getBlNoList().size() - 1)
						sbBlNo.append(",");
				}
				comRptDsgnXptInfoVO.setRdParaCtnt("/rv form_blNo[(" + sbBlNo.toString() + ")] form_ofcCd["
						+ account.getOfc_cd() + "]");
				
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				if (cndCstmsReportVO.getBlNoList().size() == 1)
					comRptDsgnXptInfoVO.setXptFileNm(cndCstmsReportVO.getBlNoList().get(0)+ ".pdf");
				else
					comRptDsgnXptInfoVO.setXptFileNm("AdviceNotes.pdf");
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
				// 청부파일
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				// 전송
				sndId = mail.send();
				
				/*************************************************
				 * 동일한 메일주소는 다른BL이라도 동시에 발송시키지만<br>
				 * HISTORY 테이블에는 BKG NO에 따라 모두 등록시켜야 하기때문에<br>
				 * 다시 for loop 실행 
				 *************************************************/
				for (int j = 0; j < cndCstmsReportVO.getBlNoList().size(); j++)
				{
					String sBlNo = cndCstmsReportVO.getBlNoList().get(j);
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					for (int k=0; k<cndCstmsReportVOs.size(); k++)
					{
						if (sBlNo.equals(cndCstmsReportVOs.get(k).getBlNo())) {
							bkgNtcHisVO.setBkgNo(cndCstmsReportVOs.get(k).getBkgNo());
							break;
						}
					}
					bkgNtcHisVO.setNtcViaCd("M"); // F:Fax,M:Email
					bkgNtcHisVO.setNtcKndCd("AV");
					bkgNtcHisVO.setNtcSeq("0");
					bkgNtcHisVO.setCustCntcTpCd(cndCstmsReportVO.getCustCntcTpCd1());
					bkgNtcHisVO.setNtcEml(cndCstmsReportVO.getNtcEml1());
					bkgNtcHisVO.setSndId(sndId);
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
					bkgNtcHisVO.setDiffRmk("Advice Notes (Canada)");
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
					bkgNtcHisVOs.add(bkgNtcHisVO);
				}
			}
			return bkgNtcHisVOs;
		}
		catch (Exception ex)
		{
			throw new EAIException(ex.getMessage(), ex);
		}
	}
}
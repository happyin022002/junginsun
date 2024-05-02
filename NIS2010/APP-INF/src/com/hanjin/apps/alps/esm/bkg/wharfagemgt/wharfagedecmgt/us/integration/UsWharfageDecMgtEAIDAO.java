/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsWharfageDecMgtEAIDAO.java
 *@FileTitle : UsWharfageDecMgtEAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.25 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.basic.UsWharfageDecMgtBCImpl;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;

/**
 * ALPS UsWharfageDecMgtEAIDAO <br>
 * - ALPS-WharfageDecMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Min jeong
 * @see UsWharfageDecMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class UsWharfageDecMgtEAIDAO extends EAIDAOSupport {

	/**
	 * FAX : Rd Fax 를 전송한다.
	 * 
	 * @param bkgUsaWhfSndHisVOs FAX정보
	 * @param account 세션정보
	 * @return List<String>
	 * @throws EAIException
	 */
	public List<String> sendWhfDeclFax(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
			throws EAIException {
		try
		{
			String sVvd = bkgUsaWhfSndHisVOs.get(0).getVslCd() + bkgUsaWhfSndHisVOs.get(0).getSkdVoyNo()
					+ bkgUsaWhfSndHisVOs.get(0).getSkdDirCd();
			FaxMetaInfo[] faxMetaInfos = new FaxMetaInfo[bkgUsaWhfSndHisVOs.size()];
			for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
			{
				FaxMetaInfo faxMetaInfo = new FaxMetaInfo();
				// 모듈명(ex.BKG)
				faxMetaInfo.setRdSubSysCd("BKG");
				// MRD 파일 명 (ex.WO_NORMAL.mrd)
				faxMetaInfo.setTmplMrd("ESM_BKG_0825.mrd");
				// 배치 유무(Y/N)
				faxMetaInfo.setBatFlg("N");
				// 제목
				faxMetaInfo.setEmlTitNm("US Wharfage Send(LGB) " + sVvd);
				// RD Parameter (ex. [419][1][selho])
				faxMetaInfo.setParaInfoCtnt("[" + sVvd + "]" + "[" + bkgUsaWhfSndHisVOs.get(0).getPortCd() + "]" + "["
						+ bkgUsaWhfSndHisVOs.get(0).getIoBndCd() + "]" + "[" + bkgUsaWhfSndHisVOs.get(0).getIbflag()
						+ "]" + "[" + account.getUsr_nm() + "]");
				// 이름+FAX번호 (받는 사람1;fax1,받는사람2;fax2)
				faxMetaInfo.setRcvrInfoCtnt(account.getUsr_id() + ";" + bkgUsaWhfSndHisVOs.get(i).getCntcFaxNo());
				faxMetaInfo.setOfcCd(account.getOfc_cd());
				faxMetaInfo.setCreUsrId(account.getUsr_id());
				faxMetaInfos[i] = faxMetaInfo;
			}
			return FaxUtility.registerDB(faxMetaInfos);
		}
		catch (Exception ex)
		{
			throw new EAIException(ex.getMessage(), ex);
		}
	}

	/**
	 * E-Mail : Rd E-Mail 를 전송한다.
	 * 
	 * @param bkgUsaWhfSndHisVOs E-Mail정보
	 * @param account 세션정보
	 * @return String
	 * @throws EAIException
	 */
	public String sendWhfDeclEml(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
			throws EAIException {
		try
		{
			// 받는사람세팅
			StringBuilder sbRecipient = new StringBuilder();
			for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
			{
				sbRecipient.append(bkgUsaWhfSndHisVOs.get(i).getCntcEml());
				if (i < bkgUsaWhfSndHisVOs.size() - 1)
				{
					sbRecipient.append(";");
				}
			}
			String sVvd = bkgUsaWhfSndHisVOs.get(0).getVslCd() + bkgUsaWhfSndHisVOs.get(0).getSkdVoyNo()
					+ bkgUsaWhfSndHisVOs.get(0).getSkdDirCd();
			boolean bLGB = false;
			if ("USLGB".equals(bkgUsaWhfSndHisVOs.get(0).getPortCd()))
				bLGB = true;
			
			Mail mail = new Mail();
			// 보내는사람
			mail.setFrom("noreply@smlines.com", "SM Line");
			// 받는사람
			mail.setRecipient(sbRecipient.toString());
			if (bLGB)
			{
				// 제목
				mail.setSubject("US Wharfage Send(LGB) " + sVvd);
				// 내용
				mail.setTextContent("US Wharfage Send(LGB) " + sVvd);
				// 첨부파일(MRD파일)
				List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
				comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setRdTmpltNm("ESM_BKG_0825.mrd");
				// RD PARAMETER
				comRptDsgnXptInfoVO.setRdParaCtnt("[" + sVvd + "]" + "[" + bkgUsaWhfSndHisVOs.get(0).getPortCd() + "]"
						+ "[" + bkgUsaWhfSndHisVOs.get(0).getIoBndCd() + "]" + "["
						+ bkgUsaWhfSndHisVOs.get(0).getIbflag() + "]" + "[" + account.getUsr_nm() + "]");
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVO.setXptFileNm(sVvd + "(USLGB).pdf");
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
				// 청부파일
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				// 전송
				return mail.send();
			}
			else
			{
				// 제목
				mail.setSubject("US Wharfage Send(OAK) " + sVvd);
				// 내용
				mail.setTextContent("US Wharfage Send(OAK) " + sVvd);
				// 첨부파일(MRD파일)
				List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
				comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
				comRptDsgnXptInfoVO.setRdTmpltNm("ESM_BKG_0752.mrd");
				// RD PARAMETER
				comRptDsgnXptInfoVO.setRdParaCtnt("[" + sVvd + "]" + "[" + bkgUsaWhfSndHisVOs.get(0).getPortCd() + "]"
						+ "[" + bkgUsaWhfSndHisVOs.get(0).getIoBndCd() + "]" + "[" + account.getUsr_nm() + "]");
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVO.setXptFileNm(sVvd + "(USOAK).pdf");
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
				// 청부파일
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				// 전송
				return mail.send();
			}
		}
		catch (Exception ex)
		{
			throw new EAIException(ex.getMessage(), ex);
		}
	}

	/**
	 * FAX : Rd Fax 를 전송한다.
	 * 
	 * @param bkgUsaWhfSndHisVOs FAX정보
	 * @param account 세션정보
	 * @param sBkgNo BKG_NO
	 * @return List<String>
	 * @throws EAIException
	 */
	public List<String> sendWhfExptTsFax(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account,
			String sBkgNo) throws EAIException {
		try
		{
			String sVvd = bkgUsaWhfSndHisVOs.get(0).getVslCd() + bkgUsaWhfSndHisVOs.get(0).getSkdVoyNo()
					+ bkgUsaWhfSndHisVOs.get(0).getSkdDirCd();
			FaxMetaInfo[] faxMetaInfos = new FaxMetaInfo[bkgUsaWhfSndHisVOs.size()];
			for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
			{
				FaxMetaInfo faxMetaInfo = new FaxMetaInfo();
				// 모듈명(ex.BKG)
				faxMetaInfo.setRdSubSysCd("BKG");
				// MRD 파일 명 (ex.WO_NORMAL.mrd)
				faxMetaInfo.setTmplMrd("ESM_BKG_5025.mrd");
				// 배치 유무(Y/N)
				faxMetaInfo.setBatFlg("N");
				// 제목
				faxMetaInfo.setEmlTitNm("US Wharfage Send with Excpt & T/S B/Ls(LGB)" + sVvd);
				// RD Parameter (ex. [419][1][selho])
				faxMetaInfo.setParaInfoCtnt("/rv form_bkgNo[" + sBkgNo + "]" + "form_userId[" + account.getUsr_id()
						+ "]" + "form_hiddeData[Y]" + "vvd[" + sVvd + "]" + "port["
						+ bkgUsaWhfSndHisVOs.get(0).getPortCd() + "]" + "bound["
						+ bkgUsaWhfSndHisVOs.get(0).getIoBndCd() + "]" + "rail["
						+ bkgUsaWhfSndHisVOs.get(0).getIbflag() + "]" + "usrnm[" + account.getUsr_nm() + "]");
				// 이름+FAX번호 (받는 사람1;fax1,받는사람2;fax2)
				faxMetaInfo.setRcvrInfoCtnt(account.getUsr_id() + ";" + bkgUsaWhfSndHisVOs.get(i).getCntcFaxNo());
				faxMetaInfo.setOfcCd(account.getOfc_cd());
				faxMetaInfo.setCreUsrId(account.getUsr_id());
				faxMetaInfos[i] = faxMetaInfo;
			}
			return FaxUtility.registerDB(faxMetaInfos);
		}
		catch (Exception ex)
		{
			throw new EAIException(ex.getMessage(), ex);
		}
	}

	/**
	 * E-Mail : Rd E-Mail 를 전송한다.
	 * 
	 * @param bkgUsaWhfSndHisVOs E-Mail정보
	 * @param account 세션정보
	 * @param sBkgNo BKG_NO
	 * @return String
	 * @throws EAIException
	 */
	public String sendWhfExptTsEml(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account,
			String sBkgNo) throws EAIException {
		try
		{
			// 받는사람세팅
			StringBuilder sbRecipient = new StringBuilder();
			for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
			{
				sbRecipient.append(bkgUsaWhfSndHisVOs.get(i).getCntcEml());
			}
			String sVvd = bkgUsaWhfSndHisVOs.get(0).getVslCd() + bkgUsaWhfSndHisVOs.get(0).getSkdVoyNo()
					+ bkgUsaWhfSndHisVOs.get(0).getSkdDirCd();
			
			Mail mail = new Mail();
			// 보내는사람
			mail.setFrom("noreply@smlines.com", "SM Line");
			// 받는사람
			mail.setRecipient(sbRecipient.toString());
			// 제목
			mail.setSubject("US Wharfage Send with Excpt & T/S B/Ls(LGB) " + sVvd);
			// 내용
			mail.setTextContent("US Wharfage Send with Excpt & T/S B/Ls(LGB) " + sVvd);
			// 첨부파일(MRD파일)
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
			comRptDsgnXptInfoVO.setCreUsrId(account.getUsr_id());
			comRptDsgnXptInfoVO.setUpdUsrId(account.getUsr_id());
			comRptDsgnXptInfoVO.setRdTmpltNm("ESM_BKG_5025.mrd");
			// RD PARAMETER
			comRptDsgnXptInfoVO.setRdParaCtnt("/rv form_bkgNo[" + sBkgNo + "]" + "form_usrId[" + account.getUsr_id()
					+ "]" + "form_hiddeData[Y]" + "vvd[" + sVvd + "]" + "port["
					+ bkgUsaWhfSndHisVOs.get(0).getPortCd() + "]" + "bound["
					+ bkgUsaWhfSndHisVOs.get(0).getIoBndCd() + "]" + "rail["
					+ bkgUsaWhfSndHisVOs.get(0).getIbflag() + "]" + "usrnm[" + account.getUsr_nm() + "]");
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setXptFileNm(sVvd + "(Excpt&T/S).pdf");
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			// 청부파일
			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			// 전송
			return mail.send();
		}
		catch (Exception ex)
		{
			throw new EAIException(ex.getMessage(), ex);
		}
	}
}
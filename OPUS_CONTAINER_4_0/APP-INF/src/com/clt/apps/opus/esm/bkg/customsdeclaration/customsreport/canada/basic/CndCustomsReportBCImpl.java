/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndCustomsReportBCImpl.java
 *@FileTitle : CndCustomsReportBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.integration.CndCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.integration.CndCustomsReportEAIDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration business logic handling<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class CndCustomsReportBCImpl extends BasicCommandSupport implements CndCustomsReportBC {
	// Database Access Object
	private transient CndCustomsReportDBDAO dbDao = null;
	private transient CndCustomsReportEAIDAO eaiDao = null;

	/**
	 * CndCustomsReportBCImpl object creation<br>
	 * CndCustomsReportDBDAO creating<br>
	 */
	public CndCustomsReportBCImpl() {
		dbDao = new CndCustomsReportDBDAO();
		eaiDao = new CndCustomsReportEAIDAO();
	}

	/**
	 * Report about custom declararion  handling
	 * 
	 * @param cstmsReportCondVO
	 * @return List<CstmsReportVO>
	 * @throws EventException
	 */
	public List<CstmsReportVO> searchCstmsReport(CstmsReportCondVO cstmsReportCondVO) throws EventException {
		try
		{
			return dbDao.searchCndAdviceNotes((CndCstmsReportCondVO) cstmsReportCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * FAX : send Rd Fax 
	 * 
	 * @param cstmsReportVOs Advice Note retrieveresult
	 * @param account session information
	 * @return List<BkgNtcHisVO>
	 * @throws Exception
	 */
	public List<BkgNtcHisVO> sendAvcNoteFax(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			log.debug("******************** BC Impl sendAvcNoteFax 시작 **********************");
			
			List<CndCstmsReportVO> listCstmsReportVO = new ArrayList<CndCstmsReportVO>();
			for (int i = 0; i < cstmsReportVOs.length; i++)
			{
				CndCstmsReportVO cndCstmsReportVO = (CndCstmsReportVO) cstmsReportVOs[i];
				// Fax 체그박스에 체크한 경우만 보냄
				if ("1".equals(cndCstmsReportVO.getFaxFlg1()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "F", cndCstmsReportVO.getFaxNo1(),
							cndCstmsReportVO.getCustCntcTpCd1()));
				}
				if ("1".equals(cndCstmsReportVO.getFaxFlg2()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "F", cndCstmsReportVO.getFaxNo2(),
							cndCstmsReportVO.getCustCntcTpCd2()));
				}
				if ("1".equals(cndCstmsReportVO.getFaxFlg3()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "F", cndCstmsReportVO.getFaxNo3(),
							cndCstmsReportVO.getCustCntcTpCd3()));
				}
				if ("1".equals(cndCstmsReportVO.getFaxFlg4()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "F", cndCstmsReportVO.getFaxNo4(),
							cndCstmsReportVO.getCustCntcTpCd4()));
				}
				if ("1".equals(cndCstmsReportVO.getFaxFlg5()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "F", cndCstmsReportVO.getFaxNo5(),
							cndCstmsReportVO.getCustCntcTpCd5()));
				}
			}

			log.debug("******************** BC Impl eaiDao.sendAvcNoteFax 호출 **********************");
			return eaiDao.sendAvcNoteFax(listCstmsReportVO, account);
		}
		catch (EAIException ex)
		{
			throw new EventException(new ErrorHandler("BKG00242", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00242", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Mail : send RDMail
	 * 
	 * @param cstmsReportVOs Advice Note retrieve result
	 * @param account session information 
	 * @return List<BkgNtcHisVO>
	 * @throws EAIException
	 */
	public List<BkgNtcHisVO> sendAvcNoteEmail(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			List<CndCstmsReportVO> listCstmsReportVO = new ArrayList<CndCstmsReportVO>();
			for (int i = 0; i < cstmsReportVOs.length; i++)
			{
				CndCstmsReportVO cndCstmsReportVO = (CndCstmsReportVO) cstmsReportVOs[i];
				// Mail 체그박스에 체크한 경우만 보냄
				if ("1".equals(cndCstmsReportVO.getEmlFlg1()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "E", cndCstmsReportVO.getNtcEml1(),
							cndCstmsReportVO.getCustCntcTpCd1()));
				}
				if ("1".equals(cndCstmsReportVO.getEmlFlg2()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "E", cndCstmsReportVO.getNtcEml2(),
							cndCstmsReportVO.getCustCntcTpCd2()));
				}
				if ("1".equals(cndCstmsReportVO.getEmlFlg3()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "E", cndCstmsReportVO.getNtcEml3(),
							cndCstmsReportVO.getCustCntcTpCd3()));
				}
				if ("1".equals(cndCstmsReportVO.getEmlFlg4()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "E", cndCstmsReportVO.getNtcEml4(),
							cndCstmsReportVO.getCustCntcTpCd4()));
				}
				if ("1".equals(cndCstmsReportVO.getEmlFlg5()))
				{
					listCstmsReportVO.add(setCndCstmsReportVO(cndCstmsReportVO, "E", cndCstmsReportVO.getNtcEml5(),
							cndCstmsReportVO.getCustCntcTpCd5()));
				}
			}
			return eaiDao.sendAvcNoteEmail(listCstmsReportVO, account);
		}
		catch (EAIException ex)
		{
			throw new EventException(new ErrorHandler("BKG00243", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00243", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  basic information for sending mail, Fax setting
	 * 
	 * @param cndCstmsReportVO retrieve result VO
	 * @param sNtcViaCd Fax, mail flag
	 * @param sValue Fax, mail value
	 * @param sCustCntcTpCd Customer type
	 * @return CndCstmsReportVO
	 */
	public CndCstmsReportVO setCndCstmsReportVO(CndCstmsReportVO cndCstmsReportVO, String sNtcViaCd, String sValue,
			String sCustCntcTpCd) {
		CndCstmsReportVO info = new CndCstmsReportVO();
		info.setBlNo(cndCstmsReportVO.getBlNo());
		info.setBkgNo(cndCstmsReportVO.getBkgNo());
		info.setCustNm(cndCstmsReportVO.getCustNm());
		info.setFaxOfcCd(cndCstmsReportVO.getFaxOfcCd());
		info.setCustCntcTpCd1(sCustCntcTpCd);
		info.setShowPuFlg(cndCstmsReportVO.getShowPuFlg());
		info.setBkgCustTpCd(cndCstmsReportVO.getBkgCustTpCd());
		if ("F".equals(sNtcViaCd))
		{
			info.setFaxNo1(sValue);
		}
		else if ("E".equals(sNtcViaCd))
		{
			info.setNtcEml1(sValue);
			info.setAttachFlg(cndCstmsReportVO.getAttachFlg());
			info.setAttachMaxCnt(cndCstmsReportVO.getAttachMaxCnt());
		}
		List<String> blNoList = new ArrayList<String>();
		blNoList.add(info.getBlNo());
		info.setBlNoList(blNoList);

		List<String> showPuFlgList = new ArrayList<String>();
		showPuFlgList.add(info.getShowPuFlg());
		info.setShowPuFlgList(showPuFlgList);
		return info;
	}
	
	/**
	 * CANADA ACI : ACI Monitoring 조회<br>
	 * 
	 * @param ACIMonitorCondVO aCIMonitorCondVO
	 * @return List<ACIMonitorCondVO>
	 * @throws EventException 
	 */
	public List<ACIMonitorListVO> searchACIMonitor(ACIMonitorCondVO aCIMonitorCondVO) throws EventException  {
		try{
			return dbDao.searchACIMonitor(aCIMonitorCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

}
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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.basic.CustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration.CndCustomsReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.integration.CndCustomsReportEAIDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min Jeong
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CndCustomsReportBCImpl extends CustomsReportBCImpl {
	// Database Access Object
	private transient CndCustomsReportDBDAO dbDao = null;
	private transient CndCustomsReportEAIDAO eaiDao = null;

	/**
	 * CndCustomsReportBCImpl 객체 생성<br>
	 * CndCustomsReportDBDAO 생성한다.<br>
	 */
	public CndCustomsReportBCImpl() {
		dbDao = new CndCustomsReportDBDAO();
		eaiDao = new CndCustomsReportEAIDAO();
	}

	/**
	 * 세관 신고와 관련된 각종 Report를 처리
	 * 
	 * @param cstmsReportCondVO 조회조건
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
	 * FAX : Rd Fax 를 전송한다.
	 * 
	 * @param cstmsReportVOs Advice Note 조회결과
	 * @param account 세션정보
	 * @return List<BkgNtcHisVO>
	 * @throws Exception
	 */
	public List<BkgNtcHisVO> sendAvcNoteFax(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
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
	 * Mail : RDMail을 전송한다.
	 * 
	 * @param cstmsReportVOs Advice Note 조회결과
	 * @param account 세션정보
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
	 * 메일, 팩스 보내기 위한 기본정보 세팅
	 * 
	 * @param cndCstmsReportVO 조회결과VO
	 * @param sNtcViaCd 팩스, 메일 flag
	 * @param sValue 팩스, 메일값
	 * @param sCustCntcTpCd Customer타입
	 * @return CndCstmsReportVO
	 */
	private CndCstmsReportVO setCndCstmsReportVO(CndCstmsReportVO cndCstmsReportVO, String sNtcViaCd, String sValue,
			String sCustCntcTpCd) {
		CndCstmsReportVO info = new CndCstmsReportVO();
		info.setBlNo(cndCstmsReportVO.getBlNo());
		info.setBkgNo(cndCstmsReportVO.getBkgNo());
		info.setCustNm(cndCstmsReportVO.getCustNm());
		info.setFaxOfcCd(cndCstmsReportVO.getFaxOfcCd());
		info.setCustCntcTpCd1(sCustCntcTpCd);
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
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param BaplieMonitorCondVO  baplieMonitorCondVO
	 * @return List<BaplieMonitorCondVO>
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchBaplieMonitor(BaplieMonitorCondVO  baplieMonitorCondVO) throws EventException{
		try	{
			return dbDao.searchBaplieMonitor(baplieMonitorCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param String vvd
	 * @return String crrCd
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchUsLastForeignPort(String vvd) throws EventException{
		try	{
			return dbDao.searchUsLastForeignPort(vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
}
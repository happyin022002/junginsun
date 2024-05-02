/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EmptyReleaseRedeliveryOrderMgtBCImpl.java
 *@FileTitle : EmptyReleaseRedeliveryOrderMgtBCImpl
 *Open Issues :
 *Change history : 2009.05.04 (김상수) - EES_CTM_0428 관련업무 최초생성
 *                 2009.07.27 (김상수) - EES_CTM_0426 관련업무 추가
 *                 2009.08.18 (김상수) - EES_CTM_0429 관련업무 추가
 *@LastModifyDate : 2009.08.18
 *@LastModifier : 김상수
 *@LastVersion : 1.1
 * 2009.05.04 김상수
 * 1.0 Creation
 * 2009.07.27 김상수
 * 1.1 Modification
 * 2009.08.18 김상수
 * 1.3 Modification 
 * --------------------------------------------------------
 * History
 * 2010.10.12 이병훈 [CHM-201006402-01] Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경]
 * 2011.09.15 나상보 [CHM-201113087] Empty Release/Redelivery Order EDI 전송 신규 추가 
 * 2014.02.27 강 환   [CHM-201429045] Empty Release-Redelivery Order  - Msg Type별  Receiver ID 각각 생성
 * 2014.03.04 강 환   [CHM-201428983] RELRED Flat File Layout 에 SHIP_OPR 추가
 * 2014.03.06 강 환   [CHM-201429214] RELRED F/F 변경 (Line change 수정, W/O 추가)
 * 2014.03.27 강 환   [CHM-201429550] RELRED FF 변경 (WO가 다르면 FF각각 생성)
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOderMgtSettledOrderBackEndJob;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtEAIDAO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.BkgDgCgoforEdiVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchFaxInfoVO;
import com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchTerritoryForMultiComboVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EmptyReleaseRedeliveryOrderMgt Business Logic Basic Command implementation<br>
 * - ALPS-EmptyReleaseRedeliveryOrderMgt에 대한 비지니스 로직을 처리<br>
 *
 * @author KIM, Sang Soo
 * @see Ees_ctm_0428EventResponse, EmptyReleaseRedeliveryOrderMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0426EventResponse, EmptyReleaseRedeliveryOrderMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0451EventResponse, EmptyReleaseRedeliveryOrderMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0429EventResponse, EmptyReleaseRedeliveryOrderMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtBCImpl extends BasicCommandSupport implements EmptyReleaseRedeliveryOrderMgtBC {

	// Database Access Object
	private transient EmptyReleaseRedeliveryOrderMgtDBDAO dbDao = null;
	private transient EmptyReleaseRedeliveryOrderMgtEAIDAO eaiDao = null;

	/**
	 * EmptyReleaseRedeliveryOrderMgtBCImpl 객체 생성<br>
	 * EmptyReleaseRedeliveryOrderMgtDBDAO를 생성<br>
	 */
	public EmptyReleaseRedeliveryOrderMgtBCImpl() {
		dbDao = new EmptyReleaseRedeliveryOrderMgtDBDAO();
		eaiDao = new EmptyReleaseRedeliveryOrderMgtEAIDAO();
	}

	/**
	 * EES_CTM_0428 : 화면에 보여질 Territory List를 조회<br>
	 *
	 * @param CimTerritoryVO cimTerritoryVO
	 * @return List<CimTerritoryVO>
	 * @exception EventException
	 */
	public List<CimTerritoryVO> searchTerritoryList(CimTerritoryVO cimTerritoryVO) throws EventException {
		try {
			return dbDao.searchTerritoryList(cimTerritoryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0428 : sheet Combo용 Country List를 조회<br>
	 *
	 * @param MdmCountryVO mdmCountryVO
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> selectComboCountry(MdmCountryVO mdmCountryVO) throws EventException {
		try {
			return dbDao.selectComboCountry(mdmCountryVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - selectComboCountry] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - selectComboCountry] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0428 : sheet Combo용 Organization List를 조회<br>
	 *
	 * @param MdmOrganizationVO mdmOrganizationVO
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> selectComboOrganization(MdmOrganizationVO mdmOrganizationVO) throws EventException {
		try {
			return dbDao.selectComboOrganization(mdmOrganizationVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - selectComboOrganization] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - selectComboOrganization] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0428 : CimTerritory에 대한 멀티이벤트를 처리<br>
	 *
	 * @param CimTerritoryVO[] cimTerritoryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerritory(CimTerritoryVO[] cimTerritoryVOs, SignOnUserAccount account) throws EventException {
		List<CimTerritoryVO> insertVoList = new ArrayList<CimTerritoryVO>();
		List<CimTerritoryVO> updateVoList = new ArrayList<CimTerritoryVO>();
		List<CimTerritoryVO> deleteVoList = new ArrayList<CimTerritoryVO>();
		try {
			for (int i=0; i<cimTerritoryVOs.length; i++) {
				cimTerritoryVOs[i].setUsrId(account.getUsr_id());
				if ( cimTerritoryVOs[i].getIbflag().equals("I")){
					insertVoList.add(cimTerritoryVOs[i]);
				} else if ( cimTerritoryVOs[i].getIbflag().equals("U")){
					updateVoList.add(cimTerritoryVOs[i]);
				} else if ( cimTerritoryVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cimTerritoryVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addManageTerritoryS(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyManageTerritoryS(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeManageTerritoryS(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : 사용자 ofcCd에 따른 Multicombo용 TerritoryList를 조회<br>
	 *
	 * @param String ofcCd
	 * @return List<SearchTerritoryForMultiComboVO>
	 * @exception EventException
	 */
    public List<SearchTerritoryForMultiComboVO> searchTerritoryForMultiCombo(String ofcCd) throws EventException {
		try {
			return dbDao.searchTerritoryForMultiCombo(ofcCd);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchTerritoryForMultiCombo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchTerritoryForMultiCombo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : CimCStock IssueList을 조회<br>
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchIssueList(CimCStockVO cimCStockVO) throws EventException {
		List<CimCStockVO> searchList = new ArrayList<CimCStockVO>();
		try {
			if (cimCStockVO.getIssued().equals("N")) {
				if (cimCStockVO.getType().equals("RLS")) {
					searchList = dbDao.searchNoIssueReleaseList(cimCStockVO);

				} else if (cimCStockVO.getType().equals("RDV")) {
					searchList = dbDao.searchNoIssueReDeliveryList(cimCStockVO);
				}

			} else if (cimCStockVO.getIssued().equals("Y")) {
				if (cimCStockVO.getType().equals("RLS")) {
					searchList = dbDao.searchIssuedReleaseList(cimCStockVO);

				} else if (cimCStockVO.getType().equals("RDV")) {
					searchList = dbDao.searchIssuedReDeliveryList(cimCStockVO);
				}
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchIssueList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchIssueList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return searchList;
	}

	/**
	 * EES_CTM_0426 : CimCStock IssuedOrder을 settle<br>
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void settleIssuedOrder(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException {
		List<CimCStockVO> settleList = new ArrayList<CimCStockVO>();
		try {
			String userLoc = dbDao.getUserLocCd(account.getUsr_id());
			/* cimCStockVOs의 length만큼 loop */
			for (int i=0; i<cimCStockVOs.length; i++) {
				/* Release */
				if (cimCStockVOs[0].getType().equals("RLS")) {
					/* TypeCD(C, M, R, S))에 따른 구분 */
					if (cimCStockVOs[i].getTypeCd().equals("C")) {
						settleList = dbDao.searchSettleReleaseCHList(cimCStockVOs[i]);

					} else if (cimCStockVOs[i].getTypeCd().equals("M")) {
						settleList = dbDao.searchSettleReleaseMHList(cimCStockVOs[i]);

					} else if (cimCStockVOs[i].getTypeCd().equals("R")) {
						settleList = dbDao.searchSettleReleaseRPList(cimCStockVOs[i]);

					} else if (cimCStockVOs[i].getTypeCd().equals("S")) {
						settleList = dbDao.searchSettleReleaseSTList(cimCStockVOs[i]);
					}

					for (int k=0; k<settleList.size(); k++) {
 						settleList.get(k).setUserId(account.getUsr_id());
						settleList.get(k).setEmptyCy(cimCStockVOs[i].getEmptyCy());
						settleList.get(k).setBd(cimCStockVOs[i].getBd());
						settleList.get(k).setTypeCd(cimCStockVOs[i].getTypeCd());
						settleList.get(k).setUserId(account.getUsr_id());
						settleList.get(k).setUserLoc(userLoc);
					}
					if ( settleList.size() > 0 ) {
						dbDao.modifySettleIssuedOrders(settleList);
					}

				/* Re-Delivery */
				} else {
					cimCStockVOs[i].setUserId(account.getUsr_id());
					cimCStockVOs[i].setUserLoc(userLoc);
					settleList.add(cimCStockVOs[i]);
				}
			}

			/* Re-Delivery */
			if ( cimCStockVOs[0].getType().equals("RDV") && cimCStockVOs.length > 0 ) {
				dbDao.modifySettleIssuedOrders(settleList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - settleIssuedOrder] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - settleIssuedOrder] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : RD에 보여질 fax내용을 조회<br>
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchRDContent(CimCStockVO[] cimCStockVOs) throws EventException {
		List<SearchFaxInfoVO> searchFaxInfoList = new ArrayList<SearchFaxInfoVO>();

		StringBuilder textForRD = new StringBuilder();
		String dl = "|&&|";
		String typeCd = "";
		String crrBkgNo = "";
		String crrBlNo = "";
		String crrWoNo = "";
		String crrShpr = "";
		String prtBkgNo = "";
		String prtBlNo = "";
		String prtWoNo = "";
		String prtShpr = "";
		int sumQty = 0;
		String crrCntrTpszDesc = "";
		String crrPdDate = "";
		String crrModeCd = "";
		String crrVndrLglEngNm = "";
		String crrSpclInst = "";
		String crrCntrNo = "";
		String tpVal = cimCStockVOs[0].getType();    // Type : RLS/RDV (화면에서 받아온 값)

//	      ===================================================================
//	      Text file 형태
//	      ===================================================================
//			EINYCNA200309260001     --  주쿼리(subpage 사용에서는 반드시 필요 동일한값이라도 상관없음)
//			expense gorup1st|&&|expnese code|&&|item no.|&&|1000|&&|   --  subpage1
//			expense gorup1st|&&|expnese code|&&|item no.|&&|2000|&&|
//			expense gorup1st|&&|expnese code|&&|item no.|&&|3000|&&|
//			expense gorup1st|&&|expnese code|&&|item no.|&&|4000|&&|
//			//EOR//
//																	   -- subpage2	데이타가 없음
//			//EOR//
//																	   -- subpage3	데이타가 없음
//			//EOR//
//			                                                           -- subpage4    데이타가 없음
//			//EOR//
//	                                                                   -- subpage5 데이타가 없음
//			//EOR//
//
//			EINYCNA200309260001     --  주쿼리(subpage 사용에서는 반드시 필요 동일한값이라도 상관없음)
//	                                                                 -- subpage1 데이타가 없음
//			//EOR//
//			RQST NO|&&|RQST_OFC|&&|30000|&&|                           -- subpage2
//			//EOR//
//			Expense gorupcd1|&&|Expense gorupcd2|&&|123456|&&|코드명|&&|001|&&|아이템명|&&|tic|&&|calculation basis|&&|request option|&&|  -- subpage3
//			//EOR//
//			1000|&&|2000|&&|0.988|&&|KOR|&&|1000|&&|                   -- subpage4
//			//EOR//
//			01|&&|2000|&&|300|&&|400|&&|1000|&&|1000|&&|               -- subpage5
//			02|&&|2010|&&|300|&&|400|&&|1000|&&|1000|&&|
//			03|&&|2030|&&|300|&&|400|&&|1000|&&|1000|&&|
//			04|&&|2050|&&|300|&&|400|&&|1000|&&|1000|&&|
//			05|&&|2070|&&|300|&&|400|&&|1000|&&|1000|&&|
//			06|&&|2090|&&|300|&&|400|&&|1000|&&|1000|&&|
//			07|&&|2110|&&|300|&&|400|&&|1000|&&|1000|&&|
//			08|&&|2130|&&|300|&&|400|&&|1000|&&|1000|&&|
//			09|&&|2150|&&|300|&&|400|&&|1000|&&|1000|&&|
//			10|&&|2170|&&|300|&&|400|&&|1000|&&|1000|&&|
//			11|&&|2190|&&|300|&&|400|&&|1000|&&|1000|&&|
//			12|&&|2210|&&|300|&&|400|&&|1000|&&|1000|&&|
//			//EOR//
//	      ===================================================================

		try {
			/* cimCStockVOs length만큼 loop 1 */
			for (int i=0; i<cimCStockVOs.length; i++) {
				cimCStockVOs[i].setUserId(cimCStockVOs[0].getUserId());
				// check logic전에 TypeCd가 M일때는 Vender name을 Merchant Haulage로 setting
				if ("M".equals(cimCStockVOs[i].getTypeCd())) {
					cimCStockVOs[i].setVndrLglEngNm("Merchant Haulage");
				}
				searchFaxInfoList.addAll(dbDao.searchFaxInfoDetailList(cimCStockVOs[i]));
			}
			if ((searchFaxInfoList == null || searchFaxInfoList.size() < 1) || (searchFaxInfoList.size() < cimCStockVOs.length)) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"user info detail list"}).getMessage());
			}

			String userLoc = dbDao.getUserLocCd(cimCStockVOs[0].getUserId());
			if (userLoc == null || "".equals(userLoc)) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"user loc code"}).getMessage());
			}
			String[] faxInfoHeader = dbDao.searchFaxInfoHeader(userLoc, cimCStockVOs[0].getUserOfc(), cimCStockVOs[0].getUserCnt());
			if (faxInfoHeader == null || faxInfoHeader.length < 1) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"RD header data"}).getMessage());
			}

			//== Header Content (S) =======================================================
			textForRD.append(tpVal + dl);
			textForRD.append(faxInfoHeader[0] + dl);    // OFC_ENG_NM
			textForRD.append(faxInfoHeader[1] + dl);    // ADDRESS
			textForRD.append(faxInfoHeader[2] + dl);    // LOCAL_TIME

			textForRD.append(searchFaxInfoList.get(0).getYdNm() + dl);
			textForRD.append(searchFaxInfoList.get(0).getYdPicNm() + dl);
			textForRD.append(searchFaxInfoList.get(0).getPhnNo() + dl);
			textForRD.append(searchFaxInfoList.get(0).getUserInfo() + dl);
			textForRD.append(cimCStockVOs[0].getEmail() + dl);
			textForRD.append(cimCStockVOs[0].getFaxNo() + dl + "\n");
			//== Header Content (E) =======================================================

			/* cimCStockVOs.length만큼 loop 2 */
			for (int i=0; i<cimCStockVOs.length; i++) {
				typeCd = cimCStockVOs[i].getTypeCd();    // Type_CD : C/M/R/D/S
				crrBkgNo = cimCStockVOs[i].getBkgNo();
				crrBlNo = cimCStockVOs[i].getBlNo();
				crrWoNo = cimCStockVOs[i].getWoNo();
				crrShpr = cimCStockVOs[i].getShpr();
				if ("RLS".equals(tpVal)) {
					sumQty = Integer.parseInt(cimCStockVOs[i].getQty());
				} else {
					sumQty = 1;
				}
				crrCntrTpszDesc = searchFaxInfoList.get(i).getCntrTpszDesc();
				crrPdDate = cimCStockVOs[i].getPdDate();
				crrModeCd = cimCStockVOs[i].getModeCd();
				crrVndrLglEngNm = cimCStockVOs[i].getVndrLglEngNm();
				crrSpclInst = cimCStockVOs[i].getSpclInst();
				crrCntrNo = cimCStockVOs[i].getCntrNo();

				boolean dupBkgBlWo = false;
				if (i < 1) {
					prtBkgNo = crrBkgNo;
					prtBlNo = crrBlNo;
					prtWoNo = crrWoNo;
					prtShpr = crrShpr;

				} else {
					// 이전 라인이 현재 라인과 동일한 BkgNo, BlNo, WoNo, Shpr를 가지고 있는지 확인
					//  RD에서 중복항목의 표기 생략을 위함
					if ("RLS".equals(tpVal)) {    // Release
						if (!"".equals(crrBkgNo)) {    // bkg_no 비교
							if (crrBkgNo.equals(cimCStockVOs[i-1].getBkgNo())) {
								dupBkgBlWo = true;
							} else {                   // wo_no 비교
								prtBkgNo = crrBkgNo;
							}
						} else {
							if (crrWoNo.equals(cimCStockVOs[i-1].getWoNo())) {
								dupBkgBlWo = true;
							} else {
								prtWoNo = crrWoNo;
							}
						}
					} else {                      // Rederivery
						if (!"".equals(crrBlNo)) {    // bkg_no 비교
							if (crrBlNo.equals(cimCStockVOs[i-1].getBlNo())) {
								dupBkgBlWo = true;
							} else {
								prtBlNo = crrBlNo;
							}
						} else {                      // wo_no 비교
							if (crrWoNo.equals(cimCStockVOs[i-1].getWoNo())) {
								dupBkgBlWo = true;
							} else {
								prtWoNo = crrWoNo;
							}
						}
					}

					if (!dupBkgBlWo && !crrShpr.equals(cimCStockVOs[i-1].getShpr())) {
						prtShpr = crrShpr;
					}
				}

				for (int k=i+1; k<cimCStockVOs.length; k++) {
					// 다음 라인이 현재 라인과 동일한 BkgNo, BlNo, WoNo를 가지고 있는지 확인
					//  동일할때만 하단의 if 구문 실행 
					boolean subDupBkgBlWo = false;
					if ("RLS".equals(tpVal)) {    // Release
						if (!"".equals(crrBkgNo)) {    // bkg_no 비교
							if (crrBkgNo.equals(cimCStockVOs[k].getBkgNo())) {
								subDupBkgBlWo = true;
							}
						} else {                       // wo_no 비교
							if (crrWoNo.equals(cimCStockVOs[k].getWoNo())) {
								subDupBkgBlWo = true;
							}
						}
					} else {                      // Rederivery
						if (!"".equals(crrBlNo)) {     // bl_no 비교
							if (crrBlNo.equals(cimCStockVOs[k].getBlNo())) {
								subDupBkgBlWo = true;
							}
						} else {                       // wo_no 비교
							if (crrWoNo.equals(cimCStockVOs[k].getWoNo())) {
								subDupBkgBlWo = true;
							}
						}
					}
					// subDupBkgBlWo면 true이면
					//  다음 라인이 현재 라인과 동일한 Type/Size, Qty, P/Up Date, Trans Mode, VndrLglEngNm, SpclInst를 가지고 있는지 Check
					if (subDupBkgBlWo &&
						crrShpr.equals(cimCStockVOs[k].getShpr()) &&
						crrCntrTpszDesc.equals(searchFaxInfoList.get(k).getCntrTpszDesc()) &&
						crrPdDate.equals(cimCStockVOs[k].getPdDate()) &&
						crrModeCd.equals(cimCStockVOs[k].getModeCd()) &&
						crrVndrLglEngNm.equals(cimCStockVOs[k].getVndrLglEngNm()) &&
						crrSpclInst.equals(cimCStockVOs[k].getSpclInst()) ) {

						//  중복된 라인이 있을경우  
						if ("RLS".equals(tpVal)) {
							sumQty = sumQty + Integer.parseInt(cimCStockVOs[k].getQty());
						} else {
							sumQty = sumQty + 1;
						}
						crrCntrNo = crrCntrNo + "          " + cimCStockVOs[k].getCntrNo();
						i = k;    // 전체 for~loop를 중복한 만큼 건너뛰게 한다.  

					} else {
						break;
					}
				}

				//== Body Content (S) =======================================================
				textForRD.append(typeCd + dl);
				textForRD.append(prtBkgNo + dl);
				textForRD.append(prtBlNo + dl);
				textForRD.append(prtWoNo + dl);
				textForRD.append(prtShpr + dl);
				textForRD.append(sumQty + dl);
				textForRD.append(crrCntrTpszDesc + dl);
				textForRD.append(crrPdDate + dl);
				textForRD.append(crrModeCd + dl);
				textForRD.append(crrVndrLglEngNm + dl);
				textForRD.append(crrSpclInst + dl);
				textForRD.append(crrCntrNo + dl + "\n");
				//== Body Content (E) =======================================================

    			prtBkgNo = "";
    			prtBlNo = "";
    			prtWoNo = "";
    			prtShpr = "";
			}

		} catch (EventException ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		log.debug("\n======================================" +
				  "\n[textForRD]" +
				  "\n======================================" +
				  "\n" + textForRD.toString() +
				  "\n======================================\n");
		return textForRD.toString();
	}

	/**
	 * EES_CTM_0426 : fax 전송후 DB에 저장할 관련데이터를 조회<br>
	 *
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	public List<CimCStockVO> searchForSendFaxEmail(CimCStockVO cimCStockVO) throws EventException {
		List<CimCStockVO> returnList = new ArrayList<CimCStockVO>();

		/*  {issue_flag} I:Issue , R:Reissue , C:cancel  */
		/*  {issue_type} F:Fax , E:EMail, P:Print, D:EDI  */
		try {
			/* Release */
			/* C */
			if (cimCStockVO.getTypeCd().equals("C")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseCIssued");
					returnList = dbDao.searchFaxEmailReleaseCIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseCReissued");
					returnList = dbDao.searchFaxEmailReleaseCReissued(cimCStockVO);
				}

			/* M */
			} else if (cimCStockVO.getTypeCd().equals("M")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseMIssued");
					returnList = dbDao.searchFaxEmailReleaseMIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseMReissued");
					returnList = dbDao.searchFaxEmailReleaseMReissued(cimCStockVO);
				}

			/* R, S */
			} else if (cimCStockVO.getTypeCd().equals("R") || cimCStockVO.getTypeCd().equals("S")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseRSIssued");
					returnList = dbDao.searchFaxEmailReleaseRSIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseRSReissued");
					returnList = dbDao.searchFaxEmailReleaseRSReissued(cimCStockVO);
				}

			/* D */
			} else if (cimCStockVO.getTypeCd().equals("D")) {
				/* Issued */
				if (cimCStockVO.getIssueFlag().equals("I")) {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseDIssued");
					returnList = dbDao.searchFaxEmailReleaseDIssued(cimCStockVO);

				/* Re-Issue : RESEND, CORRECTION, CANCEL */
				} else {
					log.info("\n\n=================================== dbDao.searchFaxEmailReleaseDReissued");
					returnList = dbDao.searchFaxEmailReleaseDReissued(cimCStockVO);
				}
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchForSendFaxEmail] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchFaxInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return returnList;
	}

	/**
	 * EES_CTM_0426 : fax결과에 대한 멀티이벤트를 처리 (STOCK테이블)<br>
	 *
	 * @param List<CimCStockVO> cimCStockVOs
	 * @exception EventException
	 */
	public void manageSTKsendFaxEmail(List<CimCStockVO> cimCStockVOs) throws EventException {
		List<CimCStockVO> insertSTKList = new ArrayList<CimCStockVO>();
		List<CimCStockVO> updateSTKList = new ArrayList<CimCStockVO>();
		List<CimCStockVO> deleteSTKList = new ArrayList<CimCStockVO>();

		/*  {issue_flag} I:Issue , R:Reissue , C:cancel  */
		/*  {issue_type} F:Fax , E:EMail, P:Print, D:EDI  */
		try {
			for (int i=0; i<cimCStockVOs.size(); i++) {
				cimCStockVOs.get(i).setSpclInst(cimCStockVOs.get(i).getSpclInst().replaceAll("'", "^#^"));

				/* ISSUE */
				if (cimCStockVOs.get(0).getIssueFlag().equals("I")) {
					insertSTKList.add(cimCStockVOs.get(i));

				/* REISSUE */
				} else {
					// Cancel 경우
					if (cimCStockVOs.get(0).getIssueFlag().equals("C")) {
						deleteSTKList.add(cimCStockVOs.get(i));

					// Resend, Update일 경우
					} else {
						updateSTKList.add(cimCStockVOs.get(i));
					}
				}
			}
			if ( insertSTKList.size() > 0 ) {
				dbDao.addManageSTKSendFaxEmails(insertSTKList);
			}
			if ( deleteSTKList.size() > 0 ) {
				dbDao.removeManageSTKSendFaxEmails(deleteSTKList);
			}
			if ( updateSTKList.size() > 0 ) {
				dbDao.modifyManageSTKSendFaxEmails(updateSTKList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageSTKsendFaxEmail] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageSTKsendFaxEmail] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : 사용자ID로 LOC_CD를 조회(fax결과에 대한 멀티이벤트를 처리용)<br>
	 *
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String getUserLocCd(String userId) throws EventException {
		try {
			return dbDao.getUserLocCd(userId);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getUserLocCd] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getUserLocCd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : Redelivery-M-Issued용 So_Ofc와 NextVAL을 조회(fax결과에 대한 멀티이벤트를 처리용)<br>
	 *
	 * @param String userOfcCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getSoOfcNextVal(String userOfcCd) throws EventException {
		try {
			return dbDao.getSoOfcNextVal(userOfcCd);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getSoOfcNextVal] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getSoOfcNextVal] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : Yard Code로 해당Yard의 FAX No와 Email가져옴<br>
	 *
	 * @param String yardCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws EventException {
		try {
			String[] returnValues = dbDao.getYardFaxEmailInfo(yardCd);
			if (returnValues[0] == null || returnValues[0].trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"yard code"}).getMessage());
			}
			return returnValues;
		} catch (EventException ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getYardFaxEmailInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBackEndJob(String key) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		} catch(Exception e){
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getUserMessage(),e);
		}
	}

    /*=========================================================
     * 2010.10.12 이병훈 [CHM-201006402-01]
     *                   Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
     *=========================================================*/
	/**
	 * EES_CTM_0429 : BackEndJob을 시작<br>
	 *
	 * @param SignOnUserAccount account
	 * @param CimCStockVO cimCStockVO
	 * @return String
	 * @exception EventException, BackEndJobException
	 */
	public String doBackEndJobSettledOrderList(SignOnUserAccount account, CimCStockVO cimCStockVO) {
		EmptyReleaseRedeliveryOderMgtSettledOrderBackEndJob backEndResult = new EmptyReleaseRedeliveryOderMgtSettledOrderBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndResult.setCimCStockVO(cimCStockVO, account);
		return backEndJobManager.execute(backEndResult, account.getUsr_id(),"EES_CTM_0429 Back End");
	}

	/**
	 * EES_CTM_0429 : CimCStock SettledOrderList를 조회<br>
	 *
	 * @param String key
	 * @return List<CimCStockVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchSettledOrderList(String key) throws EventException {
		try {
			return (List<CimCStockVO>)BackEndJobResult.loadFromFile(key);
		} catch (BackEndJobException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
	    } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024",new String[]{""}).getMessage() ,ex);
		}
	}

	/**
	 * EES_CTM_0429 : SettledOrderList에 대한 멀티이벤트를 처리 (STOCK테이블)<br>
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSTKRecovery(CimCStockVO[] cimCStockVOs, SignOnUserAccount account) throws EventException {
		List<CimCStockVO> deleteList = new ArrayList<CimCStockVO>();
		try {
			for (int i=0; i<cimCStockVOs.length; i++) {
				cimCStockVOs[i].setUserId(account.getUsr_id());
				deleteList.add(cimCStockVOs[i]);
			}

			if ( deleteList.size() > 0 ) {
				dbDao.manageSTKRecoverys(deleteList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageSTKRecovery] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0426 : RD Fax/Mail Send (EES_CTM_0451의 btn_confirm)
	 *
	 * @param String issueType
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxMailSend(String issueType, RDFaxMailEAIVO rdFaxMailEAIVO) throws EventException {
		String returnValue = "";
		try {
			// RD Content저장을 위한 Seq 조회
			String stkFaxSndNo = dbDao.getCimFaxMailSendSeq();
			// RD Content를 저장
			dbDao.addCimFaxSndInfo(stkFaxSndNo, rdFaxMailEAIVO.getRdContent(), issueType, rdFaxMailEAIVO.getSenderUsrId());
			// RD서버에서 MRD에 넘길 param설정
			rdFaxMailEAIVO.setTmplParam(rdFaxMailEAIVO.getTmplParam() + "  /rpost [stk_fax_snd_no=" + stkFaxSndNo + "]");

			if ("F".equals(issueType)) {    // RD Fax 전송
				returnValue = eaiDao.rdFaxSend(rdFaxMailEAIVO);

			} else if ("E".equals(issueType)) {    // RD Mail 전송
				// User Default Email 값이 있으면 rdFaxMailEAIVO에 추가하여 EAIDAO클래스에서 CC에 추가
				String userDefaultEmail = dbDao.getUserDefaultEmail(rdFaxMailEAIVO.getSenderUsrId());
				rdFaxMailEAIVO.setSenderUsrDefaultEml(userDefaultEmail);
				returnValue = eaiDao.rdMailSend(rdFaxMailEAIVO);
			}

			// 저장된 RD Content에 Fax/Mail키를 update
			dbDao.modifyCimFaxSndInfo(stkFaxSndNo, returnValue);

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - rdFaxMailSend] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - rdFaxMailSend] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return returnValue;
	}

	/**
	 * EES_CTM_0426 : RD Content를 조회<br>
	 *
	 * @param String stkFaxSndNo
	 * @return String
	 * @exception EventException
	 */
	public String searchCimFaxSndInfo(String stkFaxSndNo) throws EventException {
		try {
			return dbDao.searchCimFaxSndInfo(stkFaxSndNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCimFaxSndInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCimFaxSndInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * CTM Common : CTM MOVEMENT 등록시 서버가 EUR인경우 STOCK Update<br>
	 *
	 * @param CrossItemVO crossItemVO
	 */
	public void updateCimCntrStk(CrossItemVO crossItemVO) {
		try {
			dbDao.updateCimCntrStk(crossItemVO);
		} catch (DAOException ex) {
			/******************************************************
			 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
			 ******************************************************/
			log.error("\n\n[BCImpl - updateCimCntrStk] DAOException :\n" + ex.getMessage(), ex);
		} catch (Exception ex) {
			/******************************************************
			 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
			 ******************************************************/
			log.error("\n\n[BCImpl - updateCimCntrStk] Exception :\n" + ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_CTM_0426 : EDI Send (EES_CTM_0451의 btn_confirm)
	 *
	 * @param CimCStockVO[] cimCStockVOs
	 * @return String
	 * @exception EventException
	 */
	public String sendEdi(CimCStockVO[] cimCStockVOs) throws EventException {
		String returnValue = "";
		try {
			StringBuilder flatFile = new StringBuilder();
			//RCV ID 조회
			String rcvId = dbDao.searchEdiRcvId(cimCStockVOs[0].getEmptyCy());
			//SND ID 조회
			String sndId = dbDao.searchEdiSndId(rcvId);
			//header 생성
			// 2014.02.27 FRLEH의 특정 Yard는 Receive ID를 Hard Coding
			// Empty Release-Redelivery Order  - Msg Type별  Receiver ID 각각 생성 - CHM-201429045
			if(cimCStockVOs[0].getEmptyCy().equals("FRLEH01") || cimCStockVOs[0].getEmptyCy().equals("FRLEH02") || cimCStockVOs[0].getEmptyCy().equals("FRLEH03")
					  || cimCStockVOs[0].getEmptyCy().equals("FRLEH20") || cimCStockVOs[0].getEmptyCy().equals("FRLEH31") || cimCStockVOs[0].getEmptyCy().equals("FRLEHM1")
					  || cimCStockVOs[0].getEmptyCy().equals("FRLEHM2") || cimCStockVOs[0].getEmptyCy().equals("FRLEHY5") )
			{
					  if(cimCStockVOs[0].getType().equals("RLS") )
					  {
					    rcvId = "SOGET";
					  }
					  else if(cimCStockVOs[0].getType().equals("RDV") )
					  {
					    rcvId = "SOGET-COPARN";
					  }
			}
			log.debug("rcvId : " + rcvId);
			String header = dbDao.searchEdiHeader(rcvId, sndId);
			//Status 생성
			String isssueFlag = new String();
			if("I".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "";
			}else if("R".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "N";
			}else if("O".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "U";
			}else if("C".equals(cimCStockVOs[0].getIssueFlag())){
				isssueFlag = "C";
			}
			
			for(int i = 0; i < cimCStockVOs.length; i++){
				// 2014.03.27 강 환   [CHM-201429550] RELRED FF 변경 (WO가 다르면 FF각각 생성)
//				if(i == 0 || (i < cimCStockVOs.length && !(cimCStockVOs[i-1].getBkgNo().equals(cimCStockVOs[i].getBkgNo())))){
				if(i == 0 || (i < cimCStockVOs.length && ( !(cimCStockVOs[i-1].getBkgNo().equals(cimCStockVOs[i].getBkgNo())) || 
						!(cimCStockVOs[i-1].getWoNo().equals(cimCStockVOs[i].getWoNo()))) 
						) ){
					
					//각종 desc 조회
					String[] desc = dbDao.searchEdiDesc(cimCStockVOs[i].getEmptyCy(), cimCStockVOs[i].getVvd(), cimCStockVOs[i].getPol(), cimCStockVOs[i].getPod());
					String[] bkgBooking = dbDao.searchBkgBookingforEdi(cimCStockVOs[i].getBkgNo());
					
					// FLAT FILE header 생성
					flatFile.append(header + "\n");
					flatFile.append("STATUS:" + isssueFlag + "\n");
					flatFile.append("BOUND:" + cimCStockVOs[i].getBd() + "\n");
					flatFile.append("MTY_CY:" + cimCStockVOs[i].getEmptyCy() + "\n");
					flatFile.append("MTY_CY_DESC:" + desc[0] + "\n");
					flatFile.append("BKG_NO:" + cimCStockVOs[i].getBkgNo() + "\n");
					flatFile.append("BL_NO:" + cimCStockVOs[i].getBlNo() + "\n");
					// 2014.03.06 강 환   [CHM-201429214] RELRED F/F 변경 (Line change 수정, W/O 추가)
					flatFile.append("WO_NO:" + cimCStockVOs[i].getWoNo() + "\n");
					flatFile.append("VSL_CALL:" + desc[1] + "\n");
					flatFile.append("VSL_NAME:" + desc[2] + "\n");
					flatFile.append("VVD:" + cimCStockVOs[i].getVvd() + "\n");
					flatFile.append("POL:" + cimCStockVOs[i].getPol() + "\n");
					flatFile.append("POL_DESC:" + desc[3] + "\n");
					flatFile.append("POD:" + cimCStockVOs[i].getPod() + "\n");
					flatFile.append("POD_DESC:" + desc[4] + "\n");
					flatFile.append("VVD_ETD:" + desc[5] + "\n");
					flatFile.append("VVD_ETA:" + desc[6] + "\n");
					flatFile.append("SHPR:" + cimCStockVOs[i].getShpr() + "\n");
					flatFile.append("CNEE:" + cimCStockVOs[i].getCnee() + "\n");
					flatFile.append("NTFY:" + cimCStockVOs[i].getNtfy() + "\n");
					flatFile.append("HAUL_TYPE:"+ cimCStockVOs[i].getTypeCd()  + "\n");
					// 2014.03.04 강 환   [CHM-201428983] RELRED Flat File Layout 에 SHIP_OPR 추가
					flatFile.append("SHIP_OPR:"+ cimCStockVOs[i].getShipOpr()  + "\n");
					flatFile.append("DR_IND:" + bkgBooking[0] + "\n");
					flatFile.append("RF_IND:" + bkgBooking[1] + "\n");
					flatFile.append("AK_IND:" + bkgBooking[2] + "\n");
				}
				//bkg_rf_cgo 테이블 정보 조회
				String[] bkgRfCgo = dbDao.searchBkgRfCgoforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//bkg_awk_cgo 테이블 정보 조회
				String[] bkgAwkCgo = dbDao.searchBkgAwkCgoforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//bkg_container 테이블 정보 조회
				String[] bkgContainer = dbDao.searchBkgContainerforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//bkg_dg_cgo 테이블 정보 조회
				List<BkgDgCgoforEdiVO> bkgDgCgoVOs = dbDao.searchBkgDgCgoforEdi(cimCStockVOs[i].getBkgNo(), cimCStockVOs[i].getCntrNo());
				
				//PD_DT 날짜 형식 변환(yyyy-mm-dd => yyyyMMdd)
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date pdDate = format.parse(cimCStockVOs[i].getPdDate());
				format = new SimpleDateFormat("yyyyMMdd");
				String pdDt = format.format(pdDate).toString();
				
				flatFile.append("{RELRED_INFO\n");
				flatFile.append("VENDOR:" + cimCStockVOs[i].getVndrLglEngNm() + "\n");
				flatFile.append("TRANS_MODE:" + cimCStockVOs[i].getModeCd() + "\n");
				flatFile.append("PD_DT:" +  pdDt + "\n");
				flatFile.append("SPCL_INST:" + cimCStockVOs[i].getSpclInst() + "\n");
				flatFile.append("CNTR_NO:" + cimCStockVOs[i].getCntrNo() + "\n");
				flatFile.append("CNTR_TYPE:" + cimCStockVOs[i].getTp() + "\n");
				flatFile.append("CNTR_QTY:" + cimCStockVOs[i].getQty() + "\n");
				if(bkgDgCgoVOs.size() > 0){
					flatFile.append("DIND:" + bkgContainer[0] + "\n");
					flatFile.append("RIND:" + bkgContainer[1] + "\n");
					flatFile.append("AIND:" + bkgContainer[2] + "\n");
				}else{
					flatFile.append("DIND:" + "\n");
					flatFile.append("RIND:" + "\n");
					flatFile.append("AIND:" + "\n");
				}
				flatFile.append("TEMP_F:" + bkgRfCgo[0] + "\n");
				flatFile.append("TEMP_C:" + bkgRfCgo[1] + "\n");
				flatFile.append("RF_VOLTAGE:" + bkgRfCgo[2] + "\n");
				flatFile.append("VENT:" + bkgRfCgo[7] + "\n");
				flatFile.append("VENT_CMH:" + bkgRfCgo[9] + "\n");
				flatFile.append("VENT_PCT:" + bkgRfCgo[8] + "\n");
				flatFile.append("HUMID:" + bkgRfCgo[3] + "\n");
				flatFile.append("GENSET:" + bkgRfCgo[6] + "\n");
				flatFile.append("RF_REMARK:" + bkgRfCgo[4] + "\n");
				if(bkgDgCgoVOs.size() > 0){
					flatFile.append("RFDRY_IND:" + bkgContainer[3] + "\n");
				}else{
					flatFile.append("RFDRY_IND:" + "\n");
				}
				flatFile.append("RF_DRAIN:" + bkgRfCgo[5] + "\n");
				flatFile.append("OVF:" + bkgAwkCgo[0] + "\n");
				flatFile.append("OVR:" + bkgAwkCgo[1] + "\n");
				flatFile.append("OVH:" + bkgAwkCgo[2] + "\n");
				flatFile.append("OVLW:" + bkgAwkCgo[3] + "\n");
				flatFile.append("OVRW:" + bkgAwkCgo[4] + "\n");
				flatFile.append("OVWGT:" + bkgAwkCgo[9] + "\n");
				flatFile.append("VOID_SLOT:" + bkgAwkCgo[5] + "\n");
				flatFile.append("STWG_REQ:" + bkgAwkCgo[10] + "\n");
				flatFile.append("TTL_DIM_LEN:" + bkgAwkCgo[6] + "\n");
				flatFile.append("TTL_DIM_WDT:" + bkgAwkCgo[7] + "\n");
				flatFile.append("TTL_DIM_HGT:" + bkgAwkCgo[8] + "\n");
				if(bkgDgCgoVOs.size() > 0){
					for(int j = 0; j < bkgDgCgoVOs.size(); j++){
						flatFile.append("{CNTR_DANGER\n");
						flatFile.append("UNBR:" + bkgDgCgoVOs.get(j).getImdgUnNo() + "\n");
						flatFile.append("CLAS:" + bkgDgCgoVOs.get(j).getImdgClssCd() + "\n");
						flatFile.append("DESC:" + bkgDgCgoVOs.get(j).getPrpShpNm() + "\n");
						flatFile.append("PHON:" + bkgDgCgoVOs.get(j).getEmerCntcPhnNoCtnt() + "\n");
						flatFile.append("FPNT:" + bkgDgCgoVOs.get(j).getFlshPntCdoTemp() + "\n");
						flatFile.append("FPUN:C" + "\n");
						flatFile.append("DG_REMARK:" + bkgDgCgoVOs.get(j).getDiffRmk() + "\n");
						flatFile.append("EMSNO:" + bkgDgCgoVOs.get(j).getEmsNo() + "\n");
						flatFile.append("PSACLS:" + bkgDgCgoVOs.get(j).getPsaNo() + "\n");
						flatFile.append("PKGGRP:" + bkgDgCgoVOs.get(j).getImdgPckGrpCd() + "\n");
						flatFile.append("MAR_POLL:" + bkgDgCgoVOs.get(j).getMrnPolutFlg() + "\n");
						flatFile.append("HAZ_CONT:" + bkgDgCgoVOs.get(j).getHzdDesc() + "\n");
						flatFile.append("IMO_LIMIT:" + bkgDgCgoVOs.get(j).getImdgLmtQtyFlg() + "\n");
						flatFile.append("}CNTR_DANGER\n");
					}
				}else{
					flatFile.append("{CNTR_DANGER\n");
					flatFile.append("UNBR:" + "\n");
					flatFile.append("CLAS:" + "\n");
					flatFile.append("DESC:" + "\n");
					flatFile.append("PHON:" + "\n");
					flatFile.append("FPNT:" + "\n");
					flatFile.append("FPUN:C" + "\n");
					flatFile.append("DG_REMARK:" + "\n");
					flatFile.append("EMSNO:" + "\n");
					flatFile.append("PSACLS:" + "\n");
					flatFile.append("PKGGRP:" + "\n");
					flatFile.append("MAR_POLL:" + "\n");
					flatFile.append("HAZ_CONT:" + "\n");
					flatFile.append("IMO_LIMIT:"+ "\n");
					flatFile.append("}CNTR_DANGER\n");
				}
				flatFile.append("}RELRED_INFO\n");
		
				// 2014.03.27 강 환   [CHM-201429550] RELRED FF 변경 (WO가 다르면 FF각각 생성 후 각각 발송)
				if(i == (cimCStockVOs.length - 1) || (i < (cimCStockVOs.length - 1) && 
						( !(cimCStockVOs[i].getBkgNo().equals(cimCStockVOs[i+1].getBkgNo()) ) ) ||
						!(cimCStockVOs[i].getWoNo().equals(cimCStockVOs[i+1].getWoNo())))	)
//				if(i == 0 || (i < cimCStockVOs.length && ( !(cimCStockVOs[i-1].getBkgNo().equals(cimCStockVOs[i].getBkgNo())) || 
//						!(cimCStockVOs[i-1].getWoNo().equals(cimCStockVOs[i].getWoNo()))) ) 
				{
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>"+flatFile);
					eaiDao.sendEdi(flatFile.toString());
					flatFile = new StringBuilder();
				}
			}
		} catch (EAIException ex) {
			log.error("\n\n[BCImpl - sendEdi] EAIException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - sendEdi] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return returnValue;
	}
	
	/**
	 * EES_CTM_0426 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @exception EventException
	 */
	public String checkEdiYardSetup(String yardCd) throws EventException {
		try {
			//RCV ID 조회
			String rcvId = dbDao.searchEdiRcvId(yardCd);
			//SND ID 조회
			String sndId = dbDao.searchEdiSndId(rcvId);
			if(!"".equals(rcvId) && !"".equals(sndId)){
				return "Y";
			}else {
				return "N";
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchTerritoryList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
}

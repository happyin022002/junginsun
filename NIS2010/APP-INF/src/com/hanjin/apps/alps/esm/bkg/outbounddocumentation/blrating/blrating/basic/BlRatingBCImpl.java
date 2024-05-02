/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBCImpl.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
=========================================================
 * History
 * 2010.11.04 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.04 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2011.04.18 이일민 [CHM-201110112] BKG HISTORY 추가 요청 - bill type change 
 * 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 * 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
 * 2012.09.18 조정민 [CHM-201219895] [BKG] Memo split 시 Manul/ Auto 관계없이 모든 charge copy 되지 않도록 logic 수정 요청
 * 2012.12.12 조정민 [CHM-201221699] Split 01-bkg 생성및 변경시 운임 체크 경고문 발생시 BST에 Rate check status 컬럼 추가 및 조회
 * 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
 * 2013.05.27 김진주 [CHM-201324374] [TMO - Surcharge 종합 시스템 구축 ] Surcharge tariff 오토레이팅 배치 로직 요청
 * 2013.11.06 김진주 [CHM-201327427] [BKG/DOC - Revenue Audit System] 수입심사 배치대상 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MemoSplitMasterBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration.BookingHistoryMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgRevCostVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtAmtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgChgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtCustVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.GroupRatingVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateCheckNoticeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TroRevenueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAdjustmentVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.InvIfDiffVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ServiceScopeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthDetailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRefUserVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.OrganizationChartVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriEmailTargetListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingEAIDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCntrRtVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgRateVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;

/**
 * NIS2010-BlRating Business Logic Basic Command implementation<br>
 * - NIS2010-BlRating에 대한 비지니스 로직을 처리한다.<br>
 *  
 * @author Kim Youngchul
 * @see ESM_BKG_0945EventResponse,BlRatingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BlRatingBCImpl extends BasicCommandSupport implements BlRatingBC {

	// Database Access Object
	private transient BlRatingDBDAO dbDao = null;
	private transient BlRatingEAIDAO eaiDao = null;
	private transient GeneralBookingReceiptDBDAO genDbDao = null;
    private transient BookingHistoryMgtDBDAO histDao = null;

	/**
	 * BlRatingBCImpl 객체 생성<br>
	 * BlRatingDBDAO를 생성한다.<br>
	 */
	public BlRatingBCImpl() {
		dbDao = new BlRatingDBDAO();
		eaiDao = new BlRatingEAIDAO();
		genDbDao = new GeneralBookingReceiptDBDAO();
		histDao = new BookingHistoryMgtDBDAO();
	}
	
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * autoRatingHistory 데이타 모델에 해당되는 저장.<br>
	 * BKG_CHG_RT_HIS Data에 해당하는 Master정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RateInVO rateInVO
	 * @exception EventException
	 */
	public void autoRatingHistory(RateInVO rateInVO)  throws EventException{
		
		List<BkgChgRateVO> insertVoList = new ArrayList<BkgChgRateVO>();
		BkgChgRateVO[] bkgChgRateHisVOs = rateInVO.getBkgChgRateVOs();

		SignOnUserAccount account 	= rateInVO.getAccount();
		String bkgNo 				= rateInVO.getBkg_no();
		int cnt 					= bkgChgRateHisVOs.length;

		try {
			
			for (int i = 0; i < cnt; i++) {
				bkgChgRateHisVOs[i].setBkgNo(bkgNo);
				bkgChgRateHisVOs[i].setCreUsrId(account.getUsr_id());
				bkgChgRateHisVOs[i].setUpdUsrId(account.getUsr_id());
				insertVoList.add(bkgChgRateHisVOs[i]);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.autoRatingHistory(insertVoList);
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * BKG_CHG_RT Data에 해당하는 Master정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO  rateMainInfoVO 
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateMaster(RateMainInfoVO rateMainInfoVO, String caflag) throws EventException {
		try {
			dbDao.modifyChgRateMaster(rateMainInfoVO, caflag);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * PRI 에서 Audit 이후 Status 업데이트 처리한다.<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String  bkgNo
	 * @param String  audSts
	 * @param SignOnUserAccount  account
	 * @param String  caFlg
	 * @exception EventException
	 */
	public void modifyAudSts(String bkgNo, String audSts, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			dbDao.modifyAudSts(bkgNo, audSts, account.getUsr_id(), caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * 계약 Type 을 바꿀때 ctrtTpCd 를 Update 한다
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String  bkgNo
	 * @param String  ctrtTpCd
	 * @param SignOnUserAccount  account
	 * @param String  caFlg
	 * @exception EventException
	 */
	public void modifyCtrtTpCd(String bkgNo, String ctrtTpCd, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			dbDao.modifyCtrtTpCd(bkgNo, ctrtTpCd, account.getUsr_id(), caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * PRI 에서 Audit 이후 revAudDt 업데이트 처리한다.<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String  bkgNo
	 * @param String  revAudDt
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */

	public void modifyAudDt(String bkgNo, String revAudDt, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyAudDt(bkgNo, revAudDt, account.getUsr_id());

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * Contract(S/C, RFA, TAA) Amend시, amend된 Contract의 Effective Date 이전의 
	 * Application Date 정보를 가지는 BKG들에 운임 확인 요청하는 내용의 자동메일 발송됨
	 * 메일자동발행 대상 BKG을 심사 BATCH 대상에 추가하기 위해 revenue Audit Date 업데이트 처리
	 * 
	 * @author KIM JIN JOO
	 * @param List<PriEmailTargetListVO>  priEmailTargetList
	 * @exception EventException
	 */

	public void modifyAudDt(List<PriEmailTargetListVO> priEmailTargetList) throws EventException {
		try {
			int len = priEmailTargetList == null ? 0 : priEmailTargetList.size();
			
			for(int i=0; i < len; i++){
				PriEmailTargetListVO priEmailTarget = priEmailTargetList.get(i);
				dbDao.modifyAudDt(priEmailTarget.getBkgNo(), "19000101000000", "SYSTEM");
			}

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0906Event 조회 이벤트 처리<br>
	 * TRO 에서 CHG 를 넣기 위해 BKG_RATE 에 Insert 한다.<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void createRateForTro(String bkgNo, String caFlg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.createRateForTro(bkgNo, caFlg, account.getUsr_id());
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Booking customer 화면에 대한 조회 이벤트 처리<br>
	 * 화면번호 : ESM_BKG_0961 Booking customer Inquiry <<관련 Use Case UC-BKG-012:
	 * Rating Creation>>
	 * 
	 * @author LEE JIN SEO
	 * @param PpdCctCustInVO  ppdCctCustInVO
	 * @return List<PpdCctCustOutVO>
	 * @exception EventException
	 */
	public List<PpdCctCustOutVO> searchPayerCode(PpdCctCustInVO ppdCctCustInVO) throws EventException {
		try {
			return dbDao.searchPayerCode(ppdCctCustInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0270Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Note 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScNoteInVO  scNoteInVO
	 * @return List<ScNoteOutVO>
	 * @exception EventException
	 */
	public List<ScNoteOutVO> searchScNote(ScNoteInVO scNoteInVO) throws EventException {
		try {
			return dbDao.searchScNote(scNoteInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0265Event 조회 이벤트 처리<br>
	 * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String  bkg_no
	 * @param String  ca_flg
	 * @return List<ChargeRemarkVO>
	 * @exception EventException
	 */
	public List<ChargeRemarkVO> searchChargeRemark(String bkg_no, String ca_flg) throws EventException {
		try {
			return dbDao.searchChargeRemark(bkg_no, ca_flg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0265Event 조회 이벤트 처리<br>
	 * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String  bkg_no
	 * @param String  ca_flg
	 * @param String diff_rmk
	 * @param String inter_rmk
	 * @param String doc_inter_rmk
	 * @param String  user_id
	 * @exception EventException
	 */
	public void manageChargeRemark(String bkg_no, String ca_flg, String diff_rmk, String inter_rmk, String doc_inter_rmk, String user_id) throws EventException {
		try {
			dbDao.manageChargeRemark(bkg_no, ca_flg, diff_rmk, inter_rmk, doc_inter_rmk, user_id);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0264Event 조회 이벤트 처리<br>
	 * Freight & Charge_BKG Q'TY Inquiry 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String  bkg_no
	 * @return List<BkgQtyOutVO>
	 * @exception EventException
	 */
	public List<BkgQtyOutVO> searchQtyForRate(String bkg_no) throws EventException {
		try {
			return dbDao.searchQtyForRate(bkg_no);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0269Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO  scInformInVO
	 * @return ScInformOutVO
	 * @exception EventException
	 */
	public ScInformOutVO searchScInform(ScInformInVO scInformInVO) throws EventException {
		ScInformOutVO scInformOutVO = new ScInformOutVO();

		try {

			scInformOutVO.setScBkgInformVOs(dbDao.searchScBkgInform(scInformInVO));
			scInformOutVO.setScCustInformVOs(dbDao.searchScCustInform(scInformInVO));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
		return scInformOutVO;
	}

	/**
	 * EsmBkg0269Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param ScInformInVO  scInformInVO
	 * @return List<ScInformListVO>
	 * @exception EventException
	 */
	public List<ScInformListVO> searchScInformList(ScInformInVO scInformInVO) throws EventException {
		try {
			return dbDao.searchScInformList(scInformInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0739 , EsmBkg0269Event 조회 이벤트 처리<br>
	 * TP/CGO/QTY 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RateQtyVO>
	 * @exception EventException
	 */
	public List<RateQtyVO> searchRateQtyList(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchRateQtyList(bkgBlNoVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg1076Event 조회 이벤트 처리<br>
	 * Freight & Charge_TAA Information 를 조회한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param TaaInformInVO  taaInformInVO
	 * @return TaaInformOutVO
	 * @exception EventException
	 */
	public TaaInformOutVO searchTaaInform(TaaInformInVO taaInformInVO) throws EventException {
		TaaInformOutVO taaInformOutVO = new TaaInformOutVO();

		try {

			taaInformOutVO.setTaaBkgInformVOs(dbDao.searchTaaBkgInform(taaInformInVO));
			taaInformOutVO.setTaaCustInformVOs(dbDao.searchTaaCustInform(taaInformInVO));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
		return taaInformOutVO;
	}

	/**
	 * EsmBkg1076Event 조회 이벤트 처리<br>
	 * Freight & Charge_Taa Information 를 조회한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param TaaInformInVO  taaInformInVO
	 * @return List<TaaInformListVO>
	 * @exception EventException
	 */
	public List<TaaInformListVO> searchTaaInformList(TaaInformInVO taaInformInVO) throws EventException {
		try {
			return dbDao.searchTaaInformList(taaInformInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0739Event 조회 이벤트 처리<br>
	 * Freight & Charge_S/C Information 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param RfaInformInVO  rfaInformInVO
	 * @return RfaInformOutVO
	 * @exception EventException
	 */
	public RfaInformOutVO searchRfaInform(RfaInformInVO rfaInformInVO) throws EventException {
		RfaInformOutVO rfaInformVO = new RfaInformOutVO();
		try {

			rfaInformVO.setRfaBkgInformVO(dbDao.searchRfaBkgInform(rfaInformInVO));
			rfaInformVO.setRfaCustInformVO(dbDao.searchRfaCustInform(rfaInformInVO));
			// rfaInformVO.setRfaInformListVOs(dbDao.searchRfaInformList(rfaInformInVO));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
		return rfaInformVO;
	}
	
	/**
     * EsmBkg0739Event 조회 이벤트 처리<br>
     * BKG Container VGM Info를 조회한다<br>
     * 
     * @author KIM DONG HO
     * @param String bkg_no
     * @param String ca_flg
     * @return List<BkgCntrVgmInfoListVO>
     * @exception EventException
     */
	public List<BkgCntrVgmInfoListVO> searchBkgCntrVGMInfoList(String bkg_no, String ca_flg) throws EventException {
       try {
           return dbDao.searchBkgCntrVGMInfoList(bkg_no, ca_flg);
        } catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
        }
    }

	/**
	 * EsmBkg0771Event 조회 이벤트 처리<br>
	 * BKG No로 현재 Master BKG가 가지고 있는 Covered B/L No를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String   bkg_no
	 * @param String   bl_no
	 * @param String    caFlg
	 * @return List<CoveredBlListVO>
	 * @exception EventException
	 */
	public List<CoveredBlListVO> searchCoveredBl(String bkg_no, String bl_no,String caFlg) throws EventException {
		try {
			return dbDao.searchCoveredBl(bkg_no, bl_no, caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0771Event 저장 이벤트 처리<br>
	 * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다<br>
	 * 
	 * Master B/L's POR(%s) is not match for Covered B/L's (%s) [BKG00811]
	 * Master B/L's DEL(%s) is not match for Covered B/L's (%s) [BKG00812]
	 * Master B/L's shipper(%s) is not match for Covered B/L's (%s) [BKG00813]
	 * Master B/L's first VVD(%s) is not match for Covered B/L's (%s)[BKG00814]
	 * Covered B/L No(%s) Canceled [BKG00815] X ==(X 가 아니면 통과) Covered B/L
	 * No(%s) Freight Code [OFT] exists [BKG00816] NULL != (NULL 이면 통과)
	 * 
	 * @author LEE JIN SEO
	 * @param String bkg_no
	 * @param String master_bl_no
	 * @param CoveredBlListVO[] coveredBlListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCoveredBl(String bkg_no, String master_bl_no, CoveredBlListVO[] coveredBlListVOs, SignOnUserAccount account) throws EventException {

		String r_message = "";
		BookingUtil bookingUtil = new BookingUtil();

		try {

			log.debug("=============================================");
			log.debug(" [MASTER BL_NO]  BL_VALIDATION 조건 체크 ");
			log.debug("=============================================");

			for (int i = 0; i < coveredBlListVOs.length; i++) {
				String covered_bl_no = coveredBlListVOs[i].getBlNo();
				// 삭제된 행이면  continue;
				if ("D".equals(coveredBlListVOs[i].getIbflag())) continue;

				CoveredBlVO coveredBlVO = dbDao.searchMstCvrdInfo(master_bl_no, covered_bl_no);
				if (coveredBlVO == null) {
					// [%s] does not exist. Please check B/L No. again.
					throw new EventException((String) new ErrorHandler("BKG08062", new String[] { covered_bl_no }).getMessage());
				}
				if (!coveredBlVO.getMstPorCd().equals(coveredBlVO.getCoverPorCd()) || !coveredBlVO.getMstDelCd().equals(coveredBlVO.getCoverDelCd()) || !coveredBlVO.getMstVvd().equals(coveredBlVO.getCoverVvd()) 
						  //|| !coveredBlVO.getMstShipper().equals(coveredBlVO.getCoverShipper())
				) {
					// POR, DEL and first VVD should be the same. Please check
					// B/L number again.
					throw new EventException((String) new ErrorHandler("BKG08054").getMessage());
				} else if (coveredBlVO.getMstBkgSts().equals("X") || coveredBlVO.getCoverBkgSts().equals("X")) {
					// [%s] is cancelled booking. Please check B/L number again
					throw new EventException((String) new ErrorHandler("BKG08058", new String[] { covered_bl_no }).getMessage());
				}
				/**
				 * M 인경우는 return 시켜주고 메시지를 띄워줌 : [BKG08060]- Master B/L No.
				 * can't be used for covered B/L No. Please check B/L No. again
				 * by 2010.1.21 김태경
				 * by 2010.4.13 김태경  막아주세요
				 */
/*				막아주세요
 * 				BkgRateVO bkgRateVO = bookingUtil.searchBkgRate(covered_bl_no);
				if (bkgRateVO != null && bkgRateVO.getRtBlTpCd().equals("M")) {
					// Master B/L No. can't be used for covered B/L No. Please
					// check B/L No. again
					// throw new EventException((String) new ErrorHandler("BKG08060").getMessage());
				}*/
			}

			log.debug("=============================================");
			log.debug(" [save]  BKG_RATE 저장  by 김태경 ");
			log.debug("=============================================");

			String userId = account.getUsr_id();

			BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
			bkgBlNoVo.setBkgNo(bkg_no);
			bkgBlNoVo.setCaUsrId(userId);
			bkgBlNoVo = bookingUtil.searchBkgBlNoVO(bkgBlNoVo);

			String caFlg = bkgBlNoVo.getCaFlg();

			log.debug("=============================================");
			log.debug(" [save]  MstCvrdInfo 저장  ");
			log.debug("=============================================");

			List<CoveredBlListVO> insertVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> updateVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> deletetVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> masterVoList = new ArrayList<CoveredBlListVO>();

			String bl_no = null;
			for (int i = 0; i < coveredBlListVOs.length; i++) {
				// user가 입력한 신규 bl_no
				bl_no = coveredBlListVOs[i].getBlNo();

				// user가 입력한 신규 bl_no 존재여부 확인
				String exist_bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);
				if (exist_bkg_no == null || exist_bkg_no.length() == 0) {
					r_message = r_message + (String) new ErrorHandler("BKG08062", new String[] { bl_no }).getMessage() + "\r";
					continue;
				}

				if (coveredBlListVOs[i].getIbflag().equals("U")) {
					// 기존 bl_no는 null값으로 update처리
					coveredBlListVOs[i].setBkgNo(exist_bkg_no);
					coveredBlListVOs[i].setBlCvrdTpCd("N");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getOldBlNo());
					coveredBlListVOs[i].setUserId(userId);
					updateVoList.add(coveredBlListVOs[i]);

					// user가 입력한 bl_no로 신규 처리
//					coveredBlListVOs[i].setIbflag("I");
//					coveredBlListVOs[i].setBlNo(bl_no);
				}

				if (coveredBlListVOs[i].getIbflag().equals("I") || coveredBlListVOs[i].getIbflag().equals("U")) {
					// user가 입력한 신규 bl_no 처리 = master bl_no로 update함
					coveredBlListVOs[i].setBkgNo(exist_bkg_no);
					coveredBlListVOs[i].setBlCvrdTpCd("C");
					coveredBlListVOs[i].setMstCvrdBlNo(master_bl_no);
					coveredBlListVOs[i].setUserId(userId);
					coveredBlListVOs[i].setBlNo(bl_no);
					insertVoList.add(coveredBlListVOs[i]);
				}

				if (coveredBlListVOs[i].getIbflag().equals("D")) {
					coveredBlListVOs[i].setBkgNo(exist_bkg_no);
					coveredBlListVOs[i].setBlCvrdTpCd("N");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setUserId(userId);
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getBlNo());
					deletetVoList.add(coveredBlListVOs[i]);
				}
			}
			int db_cnt = 0;
			if (deletetVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(deletetVoList, caFlg);
			}
			if (insertVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(insertVoList, caFlg);
			}
			if (updateVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(updateVoList, caFlg);
			}

			log.debug("* db_cnt : " + db_cnt);

			// 마스터 정보도 업데이트 수행한다.
			CoveredBlListVO coveredBlListVO = new CoveredBlListVO();
			coveredBlListVO.setBkgNo(bookingUtil.searchBkgNoByBlNo(master_bl_no));
			coveredBlListVO.setBlCvrdTpCd("M");
			coveredBlListVO.setBlNo(master_bl_no);
			coveredBlListVO.setUserId(userId);
			masterVoList.add(coveredBlListVO);
			db_cnt = dbDao.modifyCoveredBl(masterVoList, caFlg);
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}

		return r_message;
	}

	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * BKG_CHG_RT Data에 해당하는 정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param CoveredBlListVO coveredBlListVO
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyCoveredBl(CoveredBlListVO coveredBlListVO, String caflag) throws EventException {

		try {

			List<CoveredBlListVO> coveredBlListVOs = new ArrayList<CoveredBlListVO>();
			coveredBlListVOs.add(coveredBlListVO);
			dbDao.modifyCoveredBl(coveredBlListVOs, caflag);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0945Event 조회 이벤트 처리<br>
	 * Exchange Rate 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param String     bkg_no
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchXchRt(String bkg_no) throws EventException {
		try {
			return dbDao.searchXchRt(bkg_no);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * Freight & Charge - 를 조회한다<br>
	 * 
	 * @author LEE JIN SEO
	 * @param RateInVO    rateInVO
	 * @return RateOutVO
	 * @exception EventException
	 */
	public RateOutVO searchRate(RateInVO rateInVO) throws EventException {
		RateOutVO rateOutVO = new RateOutVO();
		BookingUtil bookingUtil = new BookingUtil();

		String bkg_no = rateInVO.getBkg_no();
		String bl_no = rateInVO.getBl_no();
		String caflag = null;

		try {

			log.debug(" ========== searchRate [C/A FLAG값] ==========> ");
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setBlNo(bl_no);
			bkgBlNoVO.setCaUsrId(rateInVO.getAccount().getUsr_id());
			BkgBlNoVO blvo = bookingUtil.searchBkgBlNoVO(bkgBlNoVO);
			if (blvo == null || blvo.getBkgNo() == null)
				return rateOutVO;

			// C/A FLAG값 (Default = N)
			caflag = blvo.getCaFlg();
			rateOutVO.setCaflag(caflag);

			log.debug(" ========== searchRate [BDR FLAG값] ========== ");
			rateOutVO.setBdrflag(bookingUtil.searchBdrFlgByBkg(bkgBlNoVO));

			log.debug(" ========== searchRateMainInfo [Rate List] ========== ");
			rateOutVO.setRateMainInfoVOs(dbDao.searchRateMainInfo(bkg_no, caflag));
			rateOutVO.setRateEtcInfoVOs(dbDao.searchRateEtcInfo(bkg_no, caflag));

			/* 2010.01.21 김태경 */
			rateOutVO.setRateCntrInfoVOs(dbDao.searchRateCntrInfo(bkg_no, caflag));

			// 1. charge list 목록 표시
			List<BkgChgRateVO> rBkgChgRates = dbDao.searchChgRate(bkg_no, caflag);
			rateOutVO.setBkgChgRateVOs(rBkgChgRates);

			// charge list 목록 표시
			rateOutVO.setRateEtcInfo1VOs(dbDao.searchRateEtcInfo1(bkg_no, caflag));
			
			StringBuffer rOfc_cd = new StringBuffer();
			// 2. charge list 목록이 없을 경우
			// Pre Set 기능 추가 by 2009.11.02 신자영
			// by 2010.3.30  김태경 삭제 요청
			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@"+rBkgChgRates.size());
//			if (rBkgChgRates.size() == 0) {

				// 자동 Prepaid 값 추출
				PpdCctCustInVO ppdCctCustInVO = new PpdCctCustInVO();
				ppdCctCustInVO.setBkgNo(bkg_no);
				ppdCctCustInVO.setCallType("PPD");
				List<PpdCctCustOutVO> pList = dbDao.searchPayerCode(ppdCctCustInVO);
				if (pList.size() > 0) {
					for (PpdCctCustOutVO ppdCctCustOutVO : pList) {

						rOfc_cd.append(ppdCctCustOutVO.getOfcCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustCntCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustSeq());
						rOfc_cd.append("|");
						break;
					}
				} else {
					rOfc_cd.append("|||");
				}

				// 자동 Collect 값 추출
				ppdCctCustInVO.setCallType("CCT");
				List<PpdCctCustOutVO> cList = dbDao.searchPayerCode(ppdCctCustInVO);

				if (cList.size() > 0) {
					for (PpdCctCustOutVO ppdCctCustOutVO : cList) {

						rOfc_cd.append(ppdCctCustOutVO.getOfcCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustCntCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustSeq());
						break;
					}
				} else {
					rOfc_cd.append("||");
				}
//			}
			// init 최초 ofc_cd 값 셋팅
			rateOutVO.setROfc_cd(rOfc_cd.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}

		return rateOutVO;
	}

	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * BlRatingDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 다건의 BKG_CHG_RT Data에 해당하는 정보를 처리한다.
	 * 
	 * @author LEE JIN SEO
	 * @param RateInVO    rateInVO
	 * @exception EventException
	 */
	public void manageRate(RateInVO rateInVO) throws EventException {

		BookingUtil bookingUtil = new BookingUtil();
		try {
			// 01. validation을 수행한다.
			BkgChgRateVO[] bkgChgRateVOs = rateInVO.getBkgChgRateVOs();
			RateMainInfoVO[] rateMainInfoVOs = rateInVO.getRateMainInfoVOs();
			// RateMainInfoVO[] rateMainInfoVOs =rateInVO.getRateMainInfoVOs();
			SignOnUserAccount account = rateInVO.getAccount();
			String bkgNo = rateInVO.getBkg_no();
			String bl_no = rateInVO.getBl_no();
			String caflag = rateInVO.getCaflag();
			String autoRate = rateInVO.getAutoRate();
			String removeAll = rateInVO.getRemoveAll();
			String covered_bl = rateInVO.getCovered_bl();

			// [기능추가] 2009.11.23 by 신자영 BDR 상태인경우 HIDE 상태만 저장
			BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
			bkgBlNoVo.setBkgNo(bkgNo);
			String bdrFlag = bookingUtil.searchBdrFlgByBkg(bkgBlNoVo);
			if ("Y".equalsIgnoreCase(bdrFlag) && "N".equalsIgnoreCase(caflag)) {
				if (bkgChgRateVOs == null)
					return;
				int cnt = bkgChgRateVOs.length;
				List<BkgChgRateVO> updateVoList = new ArrayList<BkgChgRateVO>();

				for (int i = 0; i < cnt; i++) {
					if (bkgChgRateVOs[i].getIbflag().equals("U")) {
						bkgChgRateVOs[i].setBkgNo(bkgNo);
						bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(bkgChgRateVOs[i]);
					}
				}
				// UPDATE 만 가능하다.
				if (updateVoList.size() > 0) {
					dbDao.modifyChgRate(updateVoList, caflag);
				}
				return;
			}

			// [체크대상] c와 m인경우 에만 체크 함 .
			String rt_bl_tp_cd = rateMainInfoVOs[0].getRtBlTpCd();
			if (rt_bl_tp_cd.equalsIgnoreCase("C")) {
				log.debug("=============================================");
				log.debug(" [VALIDATION BL_NO]  BL_VALIDATION 조건 체크 ");
				log.debug("=============================================");

				String master_bl_no = bl_no;
				String covered_bl_no = covered_bl;

				// [C]인경우 covered 대상이 mater bl이 된다.
				if (rt_bl_tp_cd.equalsIgnoreCase("C")) {
					master_bl_no = covered_bl;
					covered_bl_no = bl_no;
				}

				if (master_bl_no.equals(covered_bl_no)) {
					// Master B/L No. can't be used for covered B/L No. Please
					// check B/L No. again.
					throw new EventException((String) new ErrorHandler("BKG08060", new String[] { covered_bl_no }).getMessage());
				}
				// validation checked
				CoveredBlVO coveredBlVO = dbDao.searchMstCvrdInfo(master_bl_no, covered_bl_no);
				if (coveredBlVO == null) {
					// [%s] does not exist. Please check B/L No. again.
					throw new EventException((String) new ErrorHandler("BKG08062", new String[] { covered_bl_no }).getMessage());
				}
				if (!coveredBlVO.getMstPorCd().equals(coveredBlVO.getCoverPorCd()) || !coveredBlVO.getMstDelCd().equals(coveredBlVO.getCoverDelCd()) || !coveredBlVO.getMstVvd().equals(coveredBlVO.getCoverVvd()) 
						 //|| !coveredBlVO.getMstShipper().equals(coveredBlVO.getCoverShipper())
						) {
					// POR, DEL and first VVD should be the same. Please check
					// B/L number again.
					throw new EventException((String) new ErrorHandler("BKG08054").getMessage());
				} else if (coveredBlVO.getMstBkgSts().equals("X") || coveredBlVO.getCoverBkgSts().equals("X")) {
					// [%s] is cancelled booking. Please check B/L number again
					throw new EventException((String) new ErrorHandler("BKG08058", new String[] { covered_bl_no }).getMessage());
				}
				/**
				 * M 인경우는 return 시켜주고 메시지를 띄워줌 : [BKG08060]- Master B/L No.
				 * can't be used for covered B/L No. Please check B/L No. again
				 * by 2010.1.21 김태경 
				 * by 2010.4.13 김태경 막아주세요
				 */
//				BkgRateVO bkgRateVO = bookingUtil.searchBkgRate(covered_bl_no);
//				if (bkgRateVO != null && bkgRateVO.getRtBlTpCd().equals("M")) {
					// Master B/L No. can't be used for covered B/L No. Please
					// check B/L No. again
					// throw new EventException((String) new ErrorHandler("BKG08060").getMessage());
//				}
			}

			log.debug("=============================================");
			log.debug(" [MainInfo]  Main 조회조건의 값이 변경되면 수정 ");
			log.debug("=============================================");

			// Session user_id setting
			rateMainInfoVOs[0].setUserId(account.getUsr_id());

			// ChgRateBkgRate 변경된값 저장
			dbDao.modifyChgRateBkgRate(rateMainInfoVOs[0], caflag);

			
			// AUTO RATING 인경우 일괄삭제후 저장
			if ("Y".equals(autoRate)||"Y".equals(removeAll)) {
				log.debug("=============================================");
				log.debug(" AUTO RATING 인경우 일괄삭제후 저장 ");
				log.debug("=============================================");
				/* 2010.01.29 Manual Rate 는 삭제 로직에서 뺀다 */
				dbDao.removeChgRateAll(bkgNo, caflag); // 쿼리에 ANDAUTO_RAT_CD <>'M' 추가
			}
			
			log.debug("=============================================");
			log.debug(" [ChgRate] CHARGE SHEET에 존재하는 값 변경 수정   " + caflag);
			log.debug("=============================================");

			if (bkgChgRateVOs != null) {
				int cnt = bkgChgRateVOs.length;
				// 02. 비즈니스 로직 수행
				List<BkgChgRateVO> insertVoList = new ArrayList<BkgChgRateVO>();
				List<BkgChgRateVO> updateVoList = new ArrayList<BkgChgRateVO>();
				List<BkgChgRateVO> deleteVoList = new ArrayList<BkgChgRateVO>();

				log.debug("=============================================");
				log.debug(" [validation 추가] 외부에서 접근 저장되지 말아야 항목추가   by신자영  ");
				log.debug("=============================================");
				
				for (int i = 0; i < cnt; i++) {
					String sCharge = bkgChgRateVOs[i].getChgCd();
					String sCurrency = bkgChgRateVOs[i].getCurrCd();
					String sPerCode = bkgChgRateVOs[i].getRatUtCd();
					// 삭제모드에서는 체크 무의미 
					if (!bkgChgRateVOs[i].getIbflag().equals("D")) {
						String rCharge = bookingUtil.existChargeCode(sCharge);
						String rCurrency = bookingUtil.existCurrencyCode(sCurrency);
						String rPerCode = bookingUtil.existPerCode(sPerCode);
						if (!"Y".equals(rCharge)) {
							throw new EventException((String) new ErrorHandler("BKG08142", new String[] { sCharge }).getMessage());
						}
						if (!"Y".equals(rCurrency)) {
							throw new EventException((String) new ErrorHandler("BKG08143", new String[] { sCurrency }).getMessage());
						}
						if (!"Y".equals(rPerCode)) {
							throw new EventException((String) new ErrorHandler("BKG08144", new String[] { sPerCode }).getMessage());
						}
					}

					//[오토모드 ] autoRating 인경우  모두 U인상태로  전송 (I)
					if ("Y".equals(autoRate)) {
						if (bkgChgRateVOs[i].getIbflag().equals("U")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							bkgChgRateVOs[i].setCreUsrId(account.getUsr_id());
							bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList.add(bkgChgRateVOs[i]);
						}
					//[일반모드]
					}else{
						// 신규등록 i상태에서 수정했을때 u로 들어올경우 보안 
						if (bkgChgRateVOs[i].getIbflag().equals("U")) {
							String bkg_no = bkgChgRateVOs[i].getBkgNo();
							if(bkg_no == null || bkg_no.equals("")){
								bkgChgRateVOs[i].setIbflag("I");
							}
						}
						if (bkgChgRateVOs[i].getIbflag().equals("I")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							bkgChgRateVOs[i].setCreUsrId(account.getUsr_id());
							bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList.add(bkgChgRateVOs[i]);
						} else if (bkgChgRateVOs[i].getIbflag().equals("U")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
							updateVoList.add(bkgChgRateVOs[i]);
						} else if (bkgChgRateVOs[i].getIbflag().equals("D")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							deleteVoList.add(bkgChgRateVOs[i]);
						}
					}
				}

				if (deleteVoList.size() > 0) {
					dbDao.removeChgRate(deleteVoList, caflag);
				}
				if (insertVoList.size() > 0) {
					dbDao.addChgRate(insertVoList, caflag);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyChgRate(updateVoList, caflag);
				}		

				//[CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가
				// ITS/방지경 대리 요청으로 추후 반영
				//Charge Amend 권한 사용을 저장한다.
				//CA인 상태일 경우에도 1회만 사용 가능하므로, BDR Flag에 관계없이 사용 여부를 저장함.
				//dbDao.modifyChargeAmendAuthUseFlag(bkgNo, account);  jj수정
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * removeCntrRateByCntr
	 * CntrRateByCntr 데이타 모델에 해당되는 값을 삭제한다.<br>
	 * @param String  bkgNo
	 * @param String cntrNo
	 * @param String cntrRtSeq
	 * @exception EventException
	 */
	public void removeCntrRateByCntr(String bkgNo, String cntrNo, String cntrRtSeq) throws EventException {
		try {
			dbDao.removeCntrRateByCntr(bkgNo, cntrNo, cntrRtSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * changeCntrRate
	 * CntrRateByCntr 데이타 모델에 해당되는 값을 수정한다.<br>
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrNoOld
	 * @exception EventException
	 */
	public void changeCntrRate(String bkgNo, String cntrNo, String cntrNoOld) throws EventException {
		try {
			List<BkgCntrRtVO> list = dbDao.searchCntrRateByCntr(bkgNo, cntrNoOld, "");
			dbDao.removeCntrRateByCntr(bkgNo, cntrNoOld, "");

			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					BkgCntrRtVO bkgCntrRtVO = list.get(i);
					bkgCntrRtVO.setCntrNo(cntrNo);
					dbDao.insertCntrRateByCntr(bkgCntrRtVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Cargo Receiving Date 
	 * Cargo Receiving Date 데이타 모델에 해당되는 값을 수정한다.<br>
	 * @param bkgNo
	 * @param crdDt
	 * @param caFlg
	 * @exception EventException
	 */
	public void manageCrdDt(String bkgNo, String crdDt, String caFlg) throws EventException {
		try {
			dbDao.manageCrdDt(bkgNo, crdDt, caFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * booking split 시 bkg_rate 테이블과 bkg_chg_rate 테이블의 manual rate 부분을 복사한다. <br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @param String splitRsnCd
	 * @throws EventException
	 */
	public void copyManualChgByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SignOnUserAccount account, String splitRsnCd) throws EventException {
		try {
			for (int i = 0; i < targetBkg.length; i++) {
				if (!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())) {
					dbDao.copyBkgRateByBkg(sourceBkg, targetBkg[i], account);
					dbDao.createRateForTro(targetBkg[i].getBkgNo(),"N", account.getUsr_id());
					if("C".equals(splitRsnCd)){
						dbDao.copyManualChg(sourceBkg, targetBkg[i], account);
					}
				}
			}
		} catch (DAOException de) {
			// log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * booking ESM_BKG_0079_02c 화면의 confirm팝업에서, confirm시 처리.(ESM_BKG_0906) :
	 * boundCd == 'I' 일때만 실행됨<br>
	 * 
	 * @author Lee NamKyung
	 * @param TroCfmVO  troCfmVO
	 * @param SignOnUserAccount  account
	 * @return String
	 * @exception EventException
	 */
	public String createCHRevenue(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException {
		try {
			String strMasterBkgNo = "";
			BookingUtil command = new BookingUtil();

			String payerCntCd = "";
			String payerSeq = "";
			String bkgNo = "";
			String ofcCd = "";
			String ioBndCd = "";

			EurPayerVO eurPayerVO = troCfmVO.getEurPayerVO();
			if (eurPayerVO != null) {
				payerCntCd = eurPayerVO.getPayerCntCd();
				payerSeq = eurPayerVO.getPayerSeq();
				bkgNo = eurPayerVO.getBkgNo();
				ofcCd = eurPayerVO.getCctOfcCd();
				ioBndCd = eurPayerVO.getIoBndCd();
			}

			// 1) searchMdmCust check
			if (payerCntCd.length() > 0)
				command.searchMdmCust(payerCntCd, payerSeq, "N");
			
			// 1-1)office code check
			MdmOrganizationVO mdmOrganizationVO = command.searchMdmOrzByOfcCd(ofcCd);
			if(mdmOrganizationVO == null && null != ofcCd && !"".equals(ofcCd)) {
				throw new EventException(new ErrorHandler("BKG00905").getMessage());
			}

			// 2) memoSplitBkgNo find
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			MemoSplitMasterBkgVO memoSplitMasterBkgVO = command.searchMemoSplitMstBkg(bkgBlNoVO);
			if (memoSplitMasterBkgVO == null) {
				strMasterBkgNo = bkgNo;
			} else {
				String strSplitBkgNo = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getBkgNo());
				String strSplitRsnCd = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getSplitRsnCd());
				if (!"".equals(strSplitBkgNo)) {
					while (!"".equals(strSplitBkgNo)) {
						bkgBlNoVO.setBkgNo(strSplitBkgNo);
						memoSplitMasterBkgVO = command.searchMemoSplitMstBkg(bkgBlNoVO);
						if (memoSplitMasterBkgVO == null) {
							strMasterBkgNo = strSplitBkgNo;
							break;
						}
						strSplitBkgNo = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getBkgNo());
						strSplitRsnCd = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getSplitRsnCd());
						if ("M".equals(strSplitRsnCd)) {
							strMasterBkgNo = strSplitBkgNo;
						}
					}
				} else {
					strMasterBkgNo = bkgNo;
				}
			}
			// currency, rate가 없는 건이 있으면 처리하지 않고 skip
			TroListForCfmVO[] arrTroListForCfmVO = troCfmVO.getArrTroListForCfmVO();

			// for (int i=0; i<arrTroListForCfmVO.length; i++){
			// if(arrTroListForCfmVO[i].getCurrCd()==null||arrTroListForCfmVO[i].getCurrCd().length()==0
			// ||arrTroListForCfmVO[i].getTrnsRevAmt()==null||arrTroListForCfmVO[i].getTrnsRevAmt().length()==0){
			// hasRevenue = false;
			// break;
			// }
			// }
			// if(!hasRevenue){
			// return strMasterBkgNo;
			// }

			bkgBlNoVO.setBkgNo(strMasterBkgNo);

			// 3) 기존에 입력된 TRO관련 rate를 delete : BKG_CHG_RT delete
			// dbDao.removeCHRevenue(bkgBlNoVO);

			// 4) rate에 입력할 ofc_cd를 조회
			// 2010.02.25 rate ofc를 UI에 입력된 값으로 결정하기 위해 해당 로직 제외
			// String rateOfc = dbDao.searchCHRateOfc(bkgBlNoVO, ofcCd);

			// 5) BKG_CHG_RT insert
			for (int i = 0; i < arrTroListForCfmVO.length; i++) {
				// if(arrTroListForCfmVO[i].getCurrCd()=="EUR" &&
				// arrTroListForCfmVO[i].getCurrCd().length()!=0){
				if (!"Yes".equals(arrTroListForCfmVO[i].getAllInRtCd())) {
					// 5-1) currency code를 확인 & 변경
					String currCd = command.searchMdmCurr(arrTroListForCfmVO[i].getCurrCd());
					if ("".equals(currCd)) {
						throw new EventException(new ErrorHandler("BKG00898").getMessage());
					}

					// 5-2) cntr별 rate를 insert : BKG_CHG_RT insert
					TroRevenueVO troRevenueVO = new TroRevenueVO();
					troRevenueVO.setBkgNo(strMasterBkgNo);
					troRevenueVO.setHaulageCd(arrTroListForCfmVO[i].getHlgTpCd());
					troRevenueVO.setCurrCd(currCd);
					troRevenueVO.setRate(arrTroListForCfmVO[i].getTrnsRevAmt());
					troRevenueVO.setCntrNo(arrTroListForCfmVO[i].getCntrNo());
					troRevenueVO.setCltOfcCd(ofcCd);
					troRevenueVO.setPayerCntCd(payerCntCd);
					troRevenueVO.setPayerCustSeq(payerSeq);
					troRevenueVO.setCreUsrId(account.getUsr_id());
					troRevenueVO.setUpdUsrId(account.getUsr_id());
					troRevenueVO.setIoBndCd(ioBndCd);
					troRevenueVO.setChgCd("A");
					troRevenueVO.setCntrTpszCd(arrTroListForCfmVO[i].getCntrTpszCd());
					troRevenueVO.setTroSeq(arrTroListForCfmVO[i].getTroSeq());
					
					if (arrTroListForCfmVO[i].getTrnsRevAmt() != null && arrTroListForCfmVO[i].getTrnsRevAmt().length() > 0 
//							&& Double.parseDouble(arrTroListForCfmVO[i].getTrnsRevAmt()) > 0.00  R4J 결함 복구
							&& 0 < Double.compare(Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0")), 0.00d)
							&& arrTroListForCfmVO[i].getIoBndCd() != null
							&& arrTroListForCfmVO[i].getCntrTpszCd() != null) {
						// by 2010.02.26 신자영
						// bkg_rate(mother 생성)
						// ALPS Open 이후 BKG_RATE 테이블은 Booking 생성시 Create 되어 해당 로직 제거s
						//dbDao.createRateForTro(bkgNo, account.getUsr_id());
						// real T1 revenue add
						dbDao.addT1Revenue(troRevenueVO);
					}
					// 5-3) vatRate 계산
//					log.debug("@@@@@:"+JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0"));
					double rate = Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0"));
					if ("Yes".equals(arrTroListForCfmVO[i].getVatFlg())
							&& arrTroListForCfmVO[i].getCntrTpszCd() != null) {
						double vatRevenue = 0.00;
						if (!"EUR".equals(currCd)) {
							vatRevenue = dbDao.searchVATtoEur(currCd, rate);
						} else {
							vatRevenue = Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0"));
						}
						if (vatRevenue > 0) {
							// 5-4) vatRate insert : BKG_CHG_RT insert
							TroRevenueVO vatRevenueVO = new TroRevenueVO();
							vatRevenueVO.setBkgNo(strMasterBkgNo);
							vatRevenueVO.setCntrNo(arrTroListForCfmVO[i].getCntrNo());
							vatRevenueVO.setCltOfcCd(ofcCd);
							vatRevenueVO.setPayerCntCd(payerCntCd);
							vatRevenueVO.setPayerCustSeq(payerSeq);
							vatRevenueVO.setCreUsrId(account.getUsr_id());
							vatRevenueVO.setUpdUsrId(account.getUsr_id());
							vatRevenueVO.setCntrTpszCd(arrTroListForCfmVO[i].getCntrTpszCd());
							vatRevenueVO.setChgCd("A");
							vatRevenueVO.setIoBndCd(ioBndCd);
							dbDao.addVATRevenue(vatRevenue, vatRevenueVO, ofcCd);
						}
					}
				}
				
                String[] addRevAmt =new String[3];
                String[] addRevChgCd =new String[3];
                
                addRevAmt[0] = arrTroListForCfmVO[i].getAddRevAmt();
                addRevAmt[1] = arrTroListForCfmVO[i].getAddRevAmt2();
                addRevAmt[2] = arrTroListForCfmVO[i].getAddRevAmt3();
                
                addRevChgCd[0] = arrTroListForCfmVO[i].getAddRevChgCd();
                addRevChgCd[1] = arrTroListForCfmVO[i].getAddRevChgCd2();
                addRevChgCd[2] = arrTroListForCfmVO[i].getAddRevChgCd3();
                
                 for (int j = 0; j < addRevAmt.length; j++) {
                        // interface additional revenue
                        if (addRevAmt[j] != null && addRevAmt[j].length() > 0 
//                                           && Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getAddRevAmt(),"0"))> 0.00  2010.10.26 R4J 결함 복구
                                       && 0 < Double.compare(Double.parseDouble(JSPUtil.getNullNoTrim(addRevAmt[j],"0")), 0.00d)  
                                       && addRevChgCd[j].length() > 0
                                       && arrTroListForCfmVO[i].getCntrTpszCd() != null) {
                               
                               String currCd = command.searchMdmCurr(arrTroListForCfmVO[i].getCurrCd());
                               if ("".equals(currCd)) {
                                       throw new EventException(new ErrorHandler("BKG00898").getMessage());
                               }
                               
                               log.debug("\n ################################# additional charge 생성 !! ");
                               TroRevenueVO addRevenueVO = new TroRevenueVO();
                               addRevenueVO.setBkgNo(strMasterBkgNo);
                               addRevenueVO.setCurrCd(currCd);
                               addRevenueVO.setRate(addRevAmt[j]);
                               addRevenueVO.setCntrNo(arrTroListForCfmVO[i].getCntrNo());
                               addRevenueVO.setCltOfcCd(ofcCd);
                               addRevenueVO.setPayerCntCd(payerCntCd);
                               addRevenueVO.setPayerCustSeq(payerSeq);
                               addRevenueVO.setCreUsrId(account.getUsr_id());
                               addRevenueVO.setUpdUsrId(account.getUsr_id());
                                log.debug("\n ######################### arrTroListForCfmVO[i].getCntrTpszCd()" + arrTroListForCfmVO[i].getCntrTpszCd());
                                addRevenueVO.setCntrTpszCd(arrTroListForCfmVO[i].getCntrTpszCd());
                               addRevenueVO.setIoBndCd(ioBndCd);
                               addRevenueVO.setChgCd(addRevChgCd[j]);
                               dbDao.addT1Revenue(addRevenueVO); 
                        }
                }

				// }
			}

			return strMasterBkgNo;

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * bkg_cod_cost에서 bkg_chg_rt 로 rehandling charge를 복사한다.
	 * 
	 * @param String   codRqstSeq
	 * @param BkgBlNoVO   bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addCodRehandlingChg(String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.addCodRehandlingChg(codRqstSeq, bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * sourceBkg의 bkg_chg_rt정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * 
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void copyChgRateByBkg(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
		try {
			if (sourceBkg != null) {
				for (int i = 0; i < sourceBkg.length; i++) {
					dbDao.copyChgRateByBkg(sourceBkg[i], targetBkg, account);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * C/A를 위해 해당 bkg의 table들을 복사한다.
	 * 
	 * @author Lee NamKyung
	 * @param BkgBlNoVO   bkgBlNoVO
	 * @param String   copyTypeCd
	 * @exception EventException
	 */
	public void createRateCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			if ("BKG".equals(copyTypeCd)) {
				// 01.
				dbDao.removeChgRateCA(bkgBlNoVO, copyTypeCd);
				// 02.
				dbDao.removeTariffSurchargeRateCA(bkgBlNoVO, copyTypeCd);
				// 03.
				dbDao.removeRateCA(bkgBlNoVO, copyTypeCd);
			}

			// 01.
			dbDao.createRateCA(bkgBlNoVO, copyTypeCd);
			// 02.
			dbDao.createChgRateCA(bkgBlNoVO, copyTypeCd);
			//03.
			dbDao.createTariffSurchargeRateCA(bkgBlNoVO, copyTypeCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * C/A를 위해 해당 bkg의 table들을 삭제한다.
	 * 
	 * @author Lee NamKyung
	 * @param BkgBlNoVO  bkgBlNoVO
	 * @param String  copyTypeCd
	 * @exception EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			// 01.
			dbDao.removeChgRateCA(bkgBlNoVO, copyTypeCd);
			// 01.
			dbDao.removeTariffSurchargeRateCA(bkgBlNoVO, copyTypeCd);
			// 02.
			dbDao.removeRateCA(bkgBlNoVO, copyTypeCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Container Rate를 조회하는 메소드.
	 * 
	 * @author KimYoungchul
	 * @param bkgNo
	 * @return CntrRtOutVO
	 * @exception EventException
	 */
	public CntrRtOutVO searchCntrRate(String bkgNo) throws EventException {
		CntrRtOutVO cntrRtOutVO = new CntrRtOutVO();
		try {
			CntrRtBkgInfoVO cntrRtBkgInfoVO = dbDao.searchCntrRtBkgInfo(bkgNo);
			List<CntrRtQtyVO> cntrRtQtyVOs = dbDao.searchCntrRtQty(bkgNo);
			List<CntrRtVO> cntrRtVOs = dbDao.searchCntrRt(bkgNo);
			List<CntrRtAmtVO> cntrRtAmtVOs = dbDao.searchCntrRtAmt(bkgNo);
			List<CntrRtCustVO> cntrRtCustVOs = dbDao.searchCntrRtCust(bkgNo);

			cntrRtOutVO.setCntrRtBkgInfoVO(cntrRtBkgInfoVO);
			cntrRtOutVO.setCntrRtQtyVOs(cntrRtQtyVOs);
			cntrRtOutVO.setCntrRtVOs(cntrRtVOs);
			cntrRtOutVO.setCntrRtAmtVOs(cntrRtAmtVOs);
			cntrRtOutVO.setCntrRtCustVOs(cntrRtCustVOs);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
		return cntrRtOutVO;
	}

	/**
	 * Container Rate를 수정하는 메소드.
	 * 
	 * @author KimYoungchul
	 * @param cntrRtVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageCntrRate(List<CntrRtVO> cntrRtVOs, SignOnUserAccount account) throws EventException {
		try {
			// BKG_CHARGE_RATE의 값과 비교하여 이상이 없을 경우 저장한다.
			// 비교단위 : Charge code, Currency code, P/C 구분, Third Payer 별 운임 합계
			// ChargeForCntrRateVO[] chargeForCntrRateVOs =
			// dbDao.searchChargeForCntrRate ( cntrRtVO.getBkgNo() );

			List<CntrRtVO> updateVoList = new ArrayList<CntrRtVO>();
			int len = cntrRtVOs == null ? 0 : cntrRtVOs.size();
			for (int i = 0; i < len; i++) {
				CntrRtVO cntrRtVO = cntrRtVOs.get(i);

				cntrRtVO.setCreUsrId(account.getUsr_id());
				cntrRtVO.setUpdUsrId(account.getUsr_id());
				log.debug("CntrRtVO -> " + cntrRtVO.getIbflag() + " : " + cntrRtVO.getBkgNo() + " : " + cntrRtVO.getCntrNo());
				updateVoList.add(cntrRtVO);
				// if ("U".equals(cntrRtVO.getIbflag())) {
				// dbDao.modifyCntrRate(cntrRtVO);
				// }else if ("I".equals(cntrRtVO.getIbflag())) {
				// dbDao.addCntrRate(cntrRtVO);
				// }else if ("D".equals(cntrRtVO.getIbflag())) {
				// dbDao.removeCntrRate(cntrRtVO);
				// }
			}

			if (updateVoList.size() > 0) {
				dbDao.manageCntrRate(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * booking copy시 ppd ofc와 cct ofc를 copy해준다.
	 * 
	 * @author Kim Byung Kyu
	 * @param BkgBlNoVO  sourceBkg
	 * @param BkgBlNoVO  targetBkg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyPpdCctByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.copyPpdCctByBkg(sourceBkg, targetBkg, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Container 별 Rate 배분.
	 * 
	 * @author KimYoungchul
	 * @param bkgNo
	 * @param account
	 * @exception EventException
	 */
	public void distributeCntrRate(String bkgNo, SignOnUserAccount account) throws EventException {

		BookingUtil utilCmd = new BookingUtil();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		BkgBlNoVO bkgBlNoOut = null;

		try {

			List<CntrRtBkgNoVO> cntrRtBkgNoVOs = dbDao.searchCntrRtBkgNo(bkgNo, "N");
			int len = cntrRtBkgNoVOs == null ? 0 : cntrRtBkgNoVOs.size();
			log.debug("********** cnrRtBkgNoVOs.size():" + len);

			/* check booking_confirm_flag */
			boolean checkBkgCfrm = false;
			for (int i = 0; i < len; i++) {
				String tmp = dbDao.checkCntrCfrmByBkg(cntrRtBkgNoVOs.get(i).getBkgNo(), "N");
				
				if ("CNTCFM".equals(tmp)) {
					checkBkgCfrm = true;
					break;
				}
				
				/* temporary exception */
//				String tmp2 = ((List<BkgBookingVO>)utilCmd.searchBookingSplitNo(cntrRtBkgNoVOs.get(i).getBkgNo())).get(0).getCreDt();
//				log.debug("\n$$$$:"+tmp2.substring(0,10));
//				if(tmp2 != null && tmp2.substring(0,10).compareTo("2010-03-01") < 0) {
//					checkBkgCfrm = true;
//					break;
//				}
			}

			if (checkBkgCfrm) {

				// remove old
				dbDao.removeCntrRt(cntrRtBkgNoVOs);

//				for (int i = 0; i < len; i++) {
				// Master Covered 한번에 처리되어 한번만 처리하게 변경
				for (int i = 0; i < 1; i++) {
				
					String bkg_no = cntrRtBkgNoVOs.get(i).getBkgNo();
					String bl_cvrd_tp_cd = null;
					if ("M".equals(cntrRtBkgNoVOs.get(i).getBlCvrdTpCd()) || "C".equals(cntrRtBkgNoVOs.get(i).getBlCvrdTpCd())) {
						bl_cvrd_tp_cd = "Y";
					} else {
						bl_cvrd_tp_cd = "N";
					}

					// set bkg_no
					bkgBlNoIN.setBkgNo(bkg_no);
					bkgBlNoIN.setCaUsrId(account.getUsr_id());

					// search Bkg_No
					bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);

					if (bkgBlNoOut == null || bkgBlNoOut.getBkgNo() == null) {
						throw new RuntimeException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
					}
					if ("X".equals(bkgBlNoOut.getBkgStsCd())) {
						throw new RuntimeException((String)new ErrorHandler("BKG00433", new String[] { bkg_no }).getMessage());
					}
					if ("Y".equals(bkgBlNoOut.getCaFlg())) {
						throw new RuntimeException((String)new ErrorHandler("BKG08036", new String[] { bkg_no }).getMessage());
					}

					log.debug("********** distributeCharge:" + bkgBlNoOut.getBkgNo() + ":cnt~" + i);
					// Distribution
					this.distributeCharge(bkgBlNoOut.getBkgNo(), bl_cvrd_tp_cd, bkgBlNoOut.getCaFlg(), account.getUsr_id());
				}
			} else {
				log.debug("!!Not Confirmed Booking!! [" + bkgNo + "]");
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Container 별 Charge 배분.
	 * 
	 * @param bkgNo
	 * @param mstFlag
	 * @param caFlag
	 * @param userId
	 * @throws EventException
	 */
	private void distributeCharge(String bkgNo, String mstFlag, String caFlag, String userId) throws EventException {

		List<BkgCntrRtVO> cntrRtVOs = new ArrayList<BkgCntrRtVO>();
		List<CntrRtBkgChgVO> chgRateVOs = null;
		List<CntrRtCntrVO> cntrVOs = null;
		List<CntrRtBkgQtyVO> qtyVOs = null;

		float bkg_ttl_amt = 0F;
		float cntr_ttl_amt = 0F;

		// CNTR Type 40일 경우의 컨테이너의 정확한 분배를 위하여, D5.D4 계열의 Type이 나왔을 경우 
		// 이전 상태를 저장하기 위한 Flag
		String flag45 = "";   // Before Container Type 
		String bfChgCd = ""; // Before Chg Cd

		try {
			/* 1. search bkg_charge_rate */
			chgRateVOs = dbDao.searchChgRateByBkg(bkgNo, mstFlag, caFlag);

			/**********************************************************
			 * 연산을 위해 Sort 순서를 바꾼다(D5>D4>40)<br>
			 * 1. CHG_CD 를 소트 <br>
			 * 2. 같은 CHG_CD이면 RAT_UT_CD를 내림차순으로 소트.<br>
			 **********************************************************/
			Comparator<CntrRtBkgChgVO> comparator1 = new Comparator<CntrRtBkgChgVO>() {
				public int compare(CntrRtBkgChgVO vo1, CntrRtBkgChgVO vo2) {
					int retInt = vo1.getChgCd().compareTo(vo2.getChgCd()); 
					if( retInt == 0 ){
						return (vo2.getRatUtCd().compareTo(vo1.getRatUtCd()));
					}
					return retInt;
				}
			};
			Collections.sort(chgRateVOs, comparator1);
			
			int rtCnt = chgRateVOs == null ? 0 : chgRateVOs.size();
			log.debug("***** 1. CHG_RT_CNT : " + rtCnt);
			if (rtCnt == 0)
				return;

			/* 2. search bkg_container */
			cntrVOs = dbDao.searchContainerByBkg(bkgNo, mstFlag, caFlag);
			int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
			log.debug("***** 2. CNTR_CNT : " + cntrCnt);
			if (cntrCnt == 0)
				return;
			float cntrTtlVol = 0F;
			for (int i = 0; i < cntrCnt; i++) {
				cntrTtlVol += (cntrVOs.get(i).getCntrVolQty() == null || "".equals(cntrVOs.get(i).getCntrVolQty())) ? 0 : Float.parseFloat(cntrVOs.get(i).getCntrVolQty());
			}
			log.debug("         CNTR_TTL_VOL : " + cntrTtlVol);

			/* 3. eq-substitution */
			qtyVOs = dbDao.searchBkgQty(bkgNo, caFlag);
			int qtyCnt = qtyVOs == null ? 0 : qtyVOs.size();
			log.debug("***** 3. QTY_CNT : " + qtyCnt);
			for (int i = 0; i < qtyCnt; i++) {
				String cntrTpszCd = qtyVOs.get(i).getCntrTpszCd();
				// float opCntrQty =
				// Float.parseFloat(qtyVOs.get(i).getOpCntrQty());
				String eqSubstCntrTpszCd = qtyVOs.get(i).getEqSubstCntrTpszCd();
				float eqSubstCgoQty = Float.parseFloat(qtyVOs.get(i).getEqSubstCgoQty());
				float cntrVolQty = 0F;

				// if(opCntrQty < eqSubstCgoQty){
				// throw new
				// RuntimeException("!! ERROR !! - Container Q'ty is smaller than EQ-Substitution Q'ty.");
				// continue;
				// }

				for (int j = 0; j < cntrCnt; j++) {
					if (eqSubstCgoQty <= 0)
						break;
					if (cntrTpszCd.equals(cntrVOs.get(j).getCntrTpszCd())) {
						cntrVolQty = (cntrVOs.get(j).getCntrVolQty() == null || "".equals(cntrVOs.get(j).getCntrVolQty())) ? 0 : Float.parseFloat(cntrVOs.get(j).getCntrVolQty());
						eqSubstCgoQty -= cntrVolQty;
						cntrVOs.get(j).setEqSubstTpszCd(eqSubstCntrTpszCd);
						cntrVOs.get(j).setEqSubstFlg("Y");
						log.debug("         EQ-SUBST : " + cntrTpszCd + " (" + cntrVolQty + ")  -> " + eqSubstCntrTpszCd + " : " + eqSubstCgoQty);
					}
				}
			}

			/* 4. search cntr tpsz */
			// String cntrTpszs =
			// "A2,A4,D2,D3,D4,D5,D7,D8,D9,DW,DX,F2,F4,F5,O2,O4,P2,P4,Q2,Q4,R2,R4,R5,R7,S2,S4,T2,T4";
			String cntrTpszs = dbDao.searchCntrTpsz();
			log.debug("***** 4. CNTR_TPSZ : " + cntrTpszs);

			/* 정확한 Container 분배를 위해 해당 Chg_Cd별 Container를 Map에 담음. (ex. OFT[CNTR1,CNTR2... ] 의 형태) */
			HashMap<String, List<String>> ratUtCdMap = new HashMap<String, List<String>>();
			List<String> ratUtCdList = null;
			
			for (int x = 0; x < rtCnt; x++){
				CntrRtBkgChgVO chgRateVO = chgRateVOs.get(x);
				
				String chg_cd = chgRateVO.getChgCd();
				
				ratUtCdList = new ArrayList<String>();
				for (int j = 0; j < cntrCnt; j++) {
					ratUtCdList.add(cntrVOs.get(j).getCntrTpszCd());
				}
				ratUtCdMap.put(chg_cd, ratUtCdList);
			}
			
			/* 5. distribute rate */
			for (int i = 0; i < rtCnt; i++) {
				CntrRtBkgChgVO chgRateVO = chgRateVOs.get(i);
				// getter
				String chg_cd = chgRateVO.getChgCd();
				String rat_ut_cd = chgRateVO.getRatUtCd();
				String cgo_cate_cd = chgRateVO.getCgoCateCd();
				float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
				float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
				float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
				// total amount of booking
				bkg_ttl_amt += chg_amt;
				log.debug("***** 5. BkgChgRateVO : ChgCd = " + chg_cd + ", RatUtCd = " + rat_ut_cd + ", CgoCateCd = " + cgo_cate_cd + ", ChgUtAmt = " + chg_ut_amt + ", RatAsQty = " + rat_as_qty + ", ChgAmt = " + chg_amt);

				// Pertype이 TPSZ가 아닌경우
				if (cntrTpszs.indexOf(rat_ut_cd) == -1) {
					// 'B' Type
					if ("BL".equals(rat_ut_cd) || "SD".equals(rat_ut_cd)) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_vol){
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'B' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'B' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// 'C' Type
						// }else if("PC".equals(rat_ut_cd) ||
						// "PI".equals(rat_ut_cd) || "PA".equals(rat_ut_cd) ||
						// "PO".equals(rat_ut_cd) || "PD".equals(rat_ut_cd) ||
						// "PF".equals(rat_ut_cd)){
					} else if ("PC".equals(rat_ut_cd)) {
						// float oft_rate = 0F;
						// float oft_rate_as = 0F;
						float oft_amt = 0F;
						float oft_sum = 0F;
						String oft_per_type = null;
						String oft_cgo_type = null;

						// OFT Summary
						for (int k = 0; k < rtCnt; k++) {
							if ("OFT".equals(chgRateVOs.get(k).getChgCd())) {
								oft_sum += (chgRateVOs.get(k).getChgAmt() == null || "".equals(chgRateVOs.get(k).getChgAmt())) ? 0 : Float.parseFloat(chgRateVOs.get(k).getChgAmt());
							}
						}

						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tmpCntrRtVOs = new ArrayList<BkgCntrRtVO>();
						for (int k = 0; k < rtCnt; k++) {
							if ("OFT".equals(chgRateVOs.get(k).getChgCd())) {
								// oft_rate =
								// (chgRateVOs.get(k).getChgUtAmt()==null ||
								// "".equals(chgRateVOs.get(k).getChgUtAmt())) ?
								// 0 :
								// Float.parseFloat(chgRateVOs.get(k).getChgUtAmt());
								// oft_rate_as =
								// (chgRateVOs.get(k).getRatAsQty()==null ||
								// "".equals(chgRateVOs.get(k).getRatAsQty())) ?
								// 0 :
								// Float.parseFloat(chgRateVOs.get(k).getRatAsQty());
								oft_amt = (chgRateVOs.get(k).getChgAmt() == null || "".equals(chgRateVOs.get(k).getChgAmt())) ? 0 : Float.parseFloat(chgRateVOs.get(k).getChgAmt());
								oft_per_type = chgRateVOs.get(k).getRatUtCd();
								oft_cgo_type = chgRateVOs.get(k).getCgoCateCd();

								float cntr_vol_sum = 0F;
								ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
								for (int m = 0; m < cntrCnt; m++) {
									CntrRtCntrVO cntrVO = cntrVOs.get(m);
									// 'DG' Cargo
									if ("DG".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getDcgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'RF' Cargo
									} else if ("RF".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getRcFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'AK' Cargo
									} else if ("AK".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getAwkCgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'BB' Cargo
									} else if ("BB".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getBbCgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'DR' Cargo
									} else {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
									}
								}

								if (cntr_vol_sum > 0) {
									List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByPercent(chgRateVO, oft_amt, oft_sum, cntr_vol_sum, al);
									for (int n = 0; n < tempRtVOs.size(); n++) {
										tmpCntrRtVOs.add(tempRtVOs.get(n));
									}
								} else {
									// 컨테이너 재검색
									cntr_vol_sum = 0F;
									al = new ArrayList<CntrRtCntrVO>();
									for (int m = 0; m < cntrCnt; m++) {
										CntrRtCntrVO cntrVO = cntrVOs.get(m);
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
									}

									if (cntr_vol_sum > 0) {
										List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByPercent(chgRateVO, oft_amt, oft_sum, cntr_vol_sum, al);
										for (int n = 0; n < tempRtVOs.size(); n++) {
											tmpCntrRtVOs.add(tempRtVOs.get(n));
										}
									} else {
										List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByPercent(chgRateVO, oft_amt, oft_sum, cntrTtlVol, cntrVOs);
										for (int n = 0; n < tempRtVOs.size(); n++) {
											tmpCntrRtVOs.add(tempRtVOs.get(n));
										}
									}
								}
							}// end of IF
						}// end of FOR

						// check sum
						float chk_sum1 = 0F;
						float chk_sum2 = 0F;
						float cntr_ut_amt = 0F;
						float cntr_amt = 0F;
						int tmpCnt = tmpCntrRtVOs.size();
						for (int k = 0; k < tmpCnt; k++) {
							BkgCntrRtVO cntrRtVO = tmpCntrRtVOs.get(k);
							// log.debug("* PC : " + cntrRtVO.getRatUtCd() +
							// " - "+ cntrRtVO.getChgUtAmt() + " / " +
							// cntrRtVO.getChgAmt());
							cntr_ut_amt = (cntrRtVO.getChgUtAmt() == null || "".equals(cntrRtVO.getChgUtAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgUtAmt());
							cntr_amt = (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// check the last ratio
							if ((k + 1) == tmpCnt) {
								cntrRtVO.setChgUtAmt(String.valueOf(oft_sum - chk_sum1));
								cntrRtVO.setChgAmt(String.valueOf(chg_amt - chk_sum2));
							}
							// dist. volumn
							cntr_dist_vol += cntr_amt;
							// rearrange VO
							cntrRtVOs.add(cntrRtVO);
							// check sum
							chk_sum1 += cntr_ut_amt;
							chk_sum2 += cntr_amt;
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_vol){
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'C' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'C' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// Void Type (Q2)
					} else if ("Q2".equals(rat_ut_cd)) {
						// 컨테이너 검색
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							// 컨테이너 재 검색. Special Flag 를 무시하고 Cntr Tpsz 만 비교.
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								// 컨테이너 재 검색. Cntr Tpsz 무시.
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// Void Type (Q4)
					} else if ("Q4".equals(rat_ut_cd)) {
						// 컨테이너 검색
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							// 컨테이너 재 검색. Special Flag 를 무시하고 Cntr Tpsz 만 비교.
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								// 컨테이너 재 검색. Cntr Tpsz 무시.
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'E' Type
					} else if ("20".equals(rat_ut_cd)) {
						// 컨테이너 검색
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							// 'DG' Cargo
							if ("DG".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getDcgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'RF' Cargo
							} else if ("RF".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getRcFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'AK' Cargo
							} else if ("AK".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'BB' Cargo
							} else if ("BB".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'DR' Cargo
							} else {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							// 컨테이너 재 검색. Special Flag 를 무시하고 Cntr Tpsz 만 비교.
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								// 컨테이너 재 검색. Cntr Tpsz 무시.
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'E' Type
					} else if ("40".equals(rat_ut_cd)) {
						// 컨테이너 검색
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						ArrayList<String> ratUtCd40List = (ArrayList<String>)ratUtCdMap.get(chg_cd);
			
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							// 'DG' Cargo
							if ("DG".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getDcgoFlg())) {
									// Next Container Type이 40이 아닌 경우엔 flag45, bfChgCd를 초기화 함.  
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									// 앞서 D5,D4가 이미 계산된 경우, 해당 Container를 제외시킴.
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;

									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'RF' Cargo
							} else if ("RF".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getRcFlg())) {
									// Next Container Type이 40이 아닌 경우엔 flag45, bfChgCd를 초기화 함.
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;
									// 앞서 D5,D4가 이미 계산된 경우, 해당 Container를 제외시킴.
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'AK' Cargo
							} else if ("AK".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
									// Next Container Type이 40이 아닌 경우엔 flag45, bfChgCd를 초기화 함.
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;
									// 앞서 D5,D4가 이미 계산된 경우, 해당 Container를 제외시킴.
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'BB' Cargo
							} else if ("BB".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getBbCgoFlg())) {
									// Next Container Type이 40이 아닌 경우엔 flag45, bfChgCd를 초기화 함.
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;
									// 앞서 D5,D4가 이미 계산된 경우, 해당 Container를 제외시킴.
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'DR' Cargo
							} else {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
									// Next Container Type이 40이 아닌 경우엔 flag45, bfChgCd를 초기화 함.
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}

									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd()))){
										continue;
									}
									// 앞서 D5,D4가 이미 계산된 경우, 해당 Container를 제외시킴.
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}
						}
						
						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							// 컨테이너 재 검색. Special Flag 를 무시하고 Cntr Tpsz 만 비교.
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								// 컨테이너 재 검색. Cntr Tpsz 무시.
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'E' Type
					} else if ("45".equals(rat_ut_cd)) {
						// 컨테이너 검색
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							// 'DG' Cargo
							if ("DG".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getDcgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'RF' Cargo
							} else if ("RF".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getRcFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'AK' Cargo
							} else if ("AK".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getAwkCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'BB' Cargo
							} else if ("BB".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'DR' Cargo
							} else {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							// 컨테이너 재 검색. Special Flag 를 무시하고 Cntr Tpsz 만 비교.
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("7")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								// 컨테이너 재 검색. Cntr Tpsz 무시.
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								// if(chg_amt == cntr_dist_vol){
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'P' Type
					} else if ("BX".equals(rat_ut_cd) || "UN".equals(rat_ut_cd) || "CT".equals(rat_ut_cd)) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_vol){
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'P' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'P' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// 'R' Type
					} else if ("RM".equals(rat_ut_cd)) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_vol){
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'R' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'R' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// 'W' Type
					} else if ("MT".equals(rat_ut_cd) || "ST".equals(rat_ut_cd) || "TN".equals(rat_ut_cd) || "LB".equals(rat_ut_cd)) {
						float cntr_wgt_sum = 0F;
						for (int m = 0; m < cntrCnt; m++) {
							cntr_wgt_sum += (cntrVOs.get(m).getCntrWgt() == null || "".equals(cntrVOs.get(m).getCntrWgt())) ? 0 : Float.parseFloat(cntrVOs.get(m).getCntrWgt());
						}

						float cntr_dist_wgt = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByWeight(chgRateVO, cntr_wgt_sum, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_wgt += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_wgt){
						if (Float.compare(chg_amt, cntr_dist_wgt) == 0) {
							log.debug("!!! 'W' Type - OK : " + chg_amt + " = " + cntr_dist_wgt);
						} else {
							log.debug("!!! 'W' Type - NO : " + chg_amt + " = " + cntr_dist_wgt);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_wgt;

						// 'M' Type
					} else if ("CM".equals(rat_ut_cd) || "BM".equals(rat_ut_cd)) {
						float cntr_meas_sum = 0F;
						for (int m = 0; m < cntrCnt; m++) {
							cntr_meas_sum += (cntrVOs.get(m).getMeasQty() == null || "".equals(cntrVOs.get(m).getMeasQty())) ? 0 : Float.parseFloat(cntrVOs.get(m).getMeasQty());
						}

						float cntr_dist_meas = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByMeasure(chgRateVO, cntr_meas_sum, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_meas += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_meas){
						if (Float.compare(chg_amt, cntr_dist_meas) == 0) {
							log.debug("!!! 'M' Type - OK : " + chg_amt + " = " + cntr_dist_meas);
						} else {
							log.debug("!!! 'M' Type - NO : " + chg_amt + " = " + cntr_dist_meas);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_meas;

						// error!
					} else {
						// log.error("! ERROR ! - '" + rat_ut_cd +
						// "' Is Invalid Rating Unit!!!");
					}

					// Per Type이 TPSZ인 경우 Special Cargo 별로 배분한다.
				} else {
					// 컨테이너 검색
					float cntr_vol_sum = 0F;
					ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();

					for (int m = 0; m < cntrCnt; m++) {
						CntrRtCntrVO cntrVO = cntrVOs.get(m);

						// 'DG' Cargo
						if ("DG".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getDcgoFlg())) {
								// Cntr Type이 D5,D4 계열일 경우, 컨테이너의 정확한 계산을 위해 Before 값을 셋팅.
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'RF' Cargo
						} else if ("RF".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getRcFlg())) {
								// Cntr Type이 D5,D4 계열일 경우, 컨테이너의 정확한 계산을 위해 Before 값을 셋팅.
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'AK' Cargo
						} else if ("AK".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getAwkCgoFlg())) {
								// Cntr Type이 D5,D4 계열일 경우, 컨테이너의 정확한 계산을 위해 Before 값을 셋팅.
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}
								
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'BB' Cargo
						} else if ("BB".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getBbCgoFlg())) {
								// Cntr Type이 D5,D4 계열일 경우, 컨테이너의 정확한 계산을 위해 Before 값을 셋팅.
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'DR' Cargo
						} else {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
								// Cntr Type이 D5,D4 계열일 경우, 컨테이너의 정확한 계산을 위해 Before 값을 셋팅.
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + "->" + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") -" + cntr_vol_sum + ")");
							}
						}
					}

					if (cntr_vol_sum > 0) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						// if(chg_amt == cntr_dist_vol){
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;
					} else {
						// 컨테이너 재 검색. Special Flag 를 무시하고 Cntr Tpsz 만 비교.
						cntr_vol_sum = 0F;
						al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd())) {
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug(":::::add>" + cntrVO.getCntrNo() + ":" + cntrVO.getCntrTpszCd() + "(" + cntr_vol_sum + ")");
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							// 컨테이너 재 검색. Cntr Tpsz 무시.
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						}
					}
				}// end of IF - CntrTpsz
			} // end of FOR

			/* 6. validate rate amount */
			log.debug("***** 6. VALIDATE CHARGE AMOUNT");

			/* 7. update/insert bkg_cntr_rt */

			if (cntrRtVOs.size() > 0) {
				// remove CntrRate
				for (int m = 0; m < cntrRtVOs.size(); m++) {
					log.debug("***** 7. BkgChgRateVO : ChgCd = " + cntrRtVOs.get(m).getChgCd() + ", CurrCd = " + cntrRtVOs.get(m).getCurrCd() + ", ChgUtAmt = " + cntrRtVOs.get(m).getChgUtAmt() + ", RatAsQty = " + cntrRtVOs.get(m).getRatAsQty() + ", RatUtCd = " + cntrRtVOs.get(m).getRatUtCd()
							+ ", ChgAmt = " + cntrRtVOs.get(m).getChgAmt() + ", FrtTermCd = " + cntrRtVOs.get(m).getFrtTermCd() + ", CgoCateCd = " + cntrRtVOs.get(m).getCgoCateCd() + ", ImdgClssCd = " + cntrRtVOs.get(m).getImdgClssCd() + ", MstBkgNo = " + cntrRtVOs.get(m).getMstBkgNo());
					// set user id
					cntrRtVOs.get(m).setCreUsrId(userId);
					// create new
					dbDao.addCntrRt(cntrRtVOs.get(m), caFlag);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Volumn 
	 * Volumn 배분한다
	 * @param chgRateVO
	 * @param cntr_vol_sum
	 * @param cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByVolumn(CntrRtBkgChgVO chgRateVO, float cntr_vol_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_vol = 0F;
		float cntr_amt = 0F;
		float cntr_rate = 0F;
		float chk_sum1 = 0F;
		float chk_sum2 = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			log.debug("distributeChargeByVolumn :"+m+":"+cntrVO.getBkgNo()+":"+cntrVO.getCntrVolQty()+":"+chgRateVO.getChgCd());

			cntr_vol = (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());

			// check the last ratio
			if ((m + 1) == cntrCnt) {
				cntr_rate = rat_as_qty - chk_sum1;
				cntr_amt = chg_amt - chk_sum2;
			} else {
				cntr_rate = Math.round(rat_as_qty * cntr_vol / cntr_vol_sum * 1000) / 1000F;
				cntr_amt = chg_ut_amt * cntr_rate;
			}
			log.debug("# volumn : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + rat_as_qty + " * " + cntr_vol + " / " + cntr_vol_sum + " = " + cntr_rate);
			log.debug("           " + rat_ut_cd + " -> " + chg_ut_amt + " * " + cntr_rate + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(chg_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(cntr_rate));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
			// check sum
			chk_sum1 += cntr_rate;
			chk_sum2 += cntr_amt;
		}

		return tempRtVOs;
	}

	/**
	 * Weight 
	 * Weight 배분한다
	 * @param chgRateVO
	 * @param cntr_vol_sum
	 * @param cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByWeight(CntrRtBkgChgVO chgRateVO, float cntr_wgt_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_wgt = 0F;
		float cntr_amt = 0F;
		float cntr_rate = 0F;
		float chk_sum1 = 0F;
		float chk_sum2 = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			cntr_wgt = (cntrVO.getCntrWgt() == null || "".equals(cntrVO.getCntrWgt())) ? 0 : Float.parseFloat(cntrVO.getCntrWgt());

			// check the last ratio
			if ((m + 1) == cntrCnt) {
				cntr_rate = rat_as_qty - chk_sum1;
				cntr_amt = chg_amt - chk_sum2;
			} else {
				cntr_rate = Math.round(rat_as_qty * cntr_wgt / cntr_wgt_sum * 1000) / 1000F;
				cntr_amt = chg_ut_amt * cntr_rate;
			}
			log.debug("# weight : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + rat_as_qty + " * " + cntr_wgt + " / " + cntr_wgt_sum + " = " + cntr_rate);
			log.debug("           " + rat_ut_cd + " -> " + chg_ut_amt + " * " + cntr_rate + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(chg_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(cntr_rate));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
			// check sum
			chk_sum1 += cntr_rate;
			chk_sum2 += cntr_amt;
		}

		return tempRtVOs;
	}

	/**
	 * Measure 
	 * Measure 배분한다
	 * @param chgRateVO
	 * @param cntr_vol_sum
	 * @param cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByMeasure(CntrRtBkgChgVO chgRateVO, float cntr_meas_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_meas = 0F;
		float cntr_amt = 0F;
		float cntr_rate = 0F;
		float chk_sum1 = 0F;
		float chk_sum2 = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			cntr_meas = (cntrVO.getMeasQty() == null || "".equals(cntrVO.getMeasQty())) ? 0 : Float.parseFloat(cntrVO.getMeasQty());

			// check the last ratio
			if ((m + 1) == cntrCnt) {
				cntr_rate = rat_as_qty - chk_sum1;
				cntr_amt = chg_amt - chk_sum2;
			} else {
				cntr_rate = Math.round(rat_as_qty * cntr_meas / cntr_meas_sum * 1000) / 1000F;
				cntr_amt = chg_ut_amt * cntr_rate;
			}
			log.debug("# measure : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + rat_as_qty + " * " + cntr_meas + " / " + cntr_meas_sum + " = " + cntr_rate);
			log.debug("            " + rat_ut_cd + " -> " + chg_ut_amt + " * " + cntr_rate + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(chg_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(cntr_rate));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
			// check sum
			chk_sum1 += cntr_rate;
			chk_sum2 += cntr_amt;
		}

		return tempRtVOs;
	}

	/**
	 * Percent 
	 * Percent 배분한다 
	 * 
	 * @param CntrRtBkgChgVO chgRateVO
	 * @param float oft_amt
	 * @param float oft_sum
	 * @param float cntr_vol_sum
	 * @param List   <CntrRtCntrVO> cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByPercent(CntrRtBkgChgVO chgRateVO, float oft_amt, float oft_sum, float cntr_vol_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		// float chg_ut_amt = (chgRateVO.getChgUtAmt()==null ||
		// "".equals(chgRateVO.getChgUtAmt())) ? 0 :
		// Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_vol = 0F;
		float cntr_ut_amt = 0F;
		float cntr_amt = 0F;
		// float cntr_rate = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			// container volumn
			cntr_vol = (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
			// check the last ratio
			cntr_amt = Math.round(oft_amt * chg_amt / oft_sum * cntr_vol / cntr_vol_sum * 100) / 100F;
			cntr_ut_amt = Math.round(cntr_amt * 100 / rat_as_qty * 100) / 100F;
			log.debug("# percent : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_amt + " * 100 / " + rat_as_qty + " = " + cntr_ut_amt);
			log.debug("            " + rat_ut_cd + " -> " + oft_amt + " * " + chg_amt + " / " + oft_sum + " * " + cntr_vol + " / " + cntr_vol_sum + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(cntr_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(rat_as_qty));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
		}

		return tempRtVOs;
	}

	/**
	 * B/L별 한국 Wharfage 면제 사유 및 면제 화주 등록 정보 수정
	 * 
	 * @param BlKrWhfExptVO  blKrWhfExptVO
	 * @param SignOnUserAccount  account
	 * @exception EventException
	 */
	@Override
	public void modifyBlKrWhfExpt(BlKrWhfExptVO blKrWhfExptVO, SignOnUserAccount account) throws EventException {
		try {

			blKrWhfExptVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyBlKrWhfExpt(blKrWhfExptVO);

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Wharfage 정보를 조회한 후 존재하면 UPDATE, 존재하지 않으면 INSERT 처리
	 * 
	 * @param BkgRateVO  bkgRateVO
	 * @exception EventException
	 */
	public void manageWhfExptInfo(BkgRateVO bkgRateVO) throws EventException {

		try {
			// 정보가 존재하는지 체크
			BkgRateVO rateVO = dbDao.searchWhfExptInfo(bkgRateVO);
			if (rateVO == null) {
				// INSERT
				dbDao.addWhfExptInfo(bkgRateVO);
			} else {
				// UPDATE
				dbDao.modifyWhfExptInfo(bkgRateVO);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * manageFrtTerm
	 * FrtTerm 정보를 수정한다.
	 * @author KimYoungchul
	 * @param String bkgNo
	 * @param String frtTermCd
	 * @param String frtTermPrnFlg
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageFrtTerm(String bkgNo, String frtTermCd, String frtTermPrnFlg, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			if (dbDao.modifyFrtTerm(bkgNo, frtTermCd, frtTermPrnFlg, account.getUsr_id(), caFlg) == 0) {
				dbDao.addFrtTerm(bkgNo, frtTermCd, frtTermPrnFlg, account.getUsr_id(), caFlg);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EsmBkg1077 조회 이벤트 처리<br>
	 * Booking no에 해당되는 cntr 별 Application Date 조회
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchRatingApplyDateVO>
	 * @exception EventException
	 */

	public List<SearchRatingApplyDateVO> searchRatingApplyDate(String bkgNo,String caFlg) throws EventException {
		try {
			List<SearchRatingApplyDateVO> list1 = dbDao.searchRatingApplyDateList(bkgNo,caFlg);
			return list1;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EsmBkg1084 조회 이벤트 처리<br>
	 * 
	 * @param String  bkgNo
	 * @param String   ntcSeq
	 * @return List<SearchTpbInfoVO>
	 * @exception EventException
	 */
	public List<SearchTpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException {
		try {
			return dbDao.searchTpbInfo(bkgNo, ntcSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg007908Event 조회 이벤트 처리<br>
	 * Collect AMT, 3rd Collect Amt 를 조회 한다
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchFocByFreightListVO>
	 * @exception EventException
	 */
	public List<SearchFocByFreightListVO> searchFocByFreightList(String bkgNo, String caFlg) throws EventException {
		try {
			List<SearchFocByFreightListVO> list1 = dbDao.searchFocByFreightList(bkgNo,caFlg);
			return list1;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * PPD, CLT CNT_CODE UPDATE 를 한다<br>
	 * 
	 * @author KIM TAE KYOUNG
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyRateCntCd(String bkgNo, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			dbDao.modifyRateCntCd(bkgNo, account.getUsr_id(), caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * callBkgModiIssOfcPrc 프러시져 호출
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiIssOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException {
		try {
			dbDao.callBkgModiIssOfcPrc(bkgModiOfcPrcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	 * callBkgModiChgOfcPrc 프러시져 호출
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiChgOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException {
		try {
			dbDao.callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 **  Freight & Charge 화면(ESM_BKG_0079_08)화면에서 SC No. or RFA No. or TAA No.
	 *  옆 검색 버튼을 누를 때 팝업을 연결하기 위한 필수조건인 Amend Sequend를 조회한다.
	 *  
	 * @author 		Cho wonjoo
	 * @param  		String ctrtType
	 * @param  		String ctrtNo
	 * @param  		String applicationDate
	 * @return 		String 
	 * @exception   EventException
	 */	
	public String searchAmdtSeq(String ctrtType, String ctrtNo, String applicationDate) throws EventException {
		try {
			return  dbDao.searchAmdtSeq(ctrtType, ctrtNo, applicationDate);
		
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

	/**
	 * bkg info 조회 
	 *  
	 * @author 		jsy
	 * @param  		BkgBlNoVO schBkgBlNoVO
	 * @return 		BkgBookingInfoVO 
	 * @exception   EventException
	 */	
	public BkgBookingInfoVO searchBkgBookingInfo(BkgBlNoVO schBkgBlNoVO)
			throws EventException {
		try {
			return genDbDao.searchBkgBookingInfo(schBkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
		
	}
	
	/**OFT Rating 가능여부, 사용자, 날짜를 BKG RATE에 저장한다.
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String oftMssFlg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void moidfyOftPrecheckResult(String bkgNo, String caFlg, String oftMssFlg, SignOnUserAccount account ) throws EventException{
		try {
			dbDao.moidfyOftPrecheckResult(bkgNo, caFlg, oftMssFlg, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/** CMPB산출을 위해 BKG Creation/Update시 BKG Volume에 해당되는 최저 Revenue만 남기고 나머지 정보는 삭제함
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void modifyChargeRateTempForCMPB(String bkgNo) throws EventException{
		try {
			dbDao.modifyChargeRateTempForCMPB(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * DHF Adjustment Location을 조회한다<br>
	 * 
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return ChargeAdjustmentVO
	 * @exception EventException
	 */
	public ChargeAdjustmentVO searchDHFAdjustment(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.searchDHFAdjustment(bkgNo, caFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *DDC Adjustment Currency를 조회한다<br>
	 * 
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return ChargeAdjustmentVO
	 * @exception EventException
	 */
	public ChargeAdjustmentVO searchDDCAdjustment(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.searchDDCAdjustment(bkgNo, caFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * DHF Adjustment Location 저장
	 * 
	 * @param ChargeAdjustmentVO vo
	 * @throws EventException
	 */
	public void modifyDHFAdjustment(ChargeAdjustmentVO vo) throws EventException{
		try {
			dbDao.modifyDHFAdjustment(vo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * DDC Adjustment Currency 저장
	 * 
	 * @param ChargeAdjustmentVO vo
	 * @throws EventException
	 */
	public void modifyDDCAdjustment(ChargeAdjustmentVO vo) throws EventException{
		try {
			dbDao.modifyDDCAdjustment(vo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg007908Event 저장 이벤트 처리<br>
	 * Tariff Surcharge 정보를 저장.<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param String caFlag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addTariffSurchargeRate(List<SearchScOftAutoratingListVO> surList, String caFlag, SignOnUserAccount account)  throws EventException{
		try {
			dbDao.removeTariffSurchargeRate(surList, caFlag);
			dbDao.addTariffSurchargeRate(surList, caFlag, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * EsmBkg2006Event 조회 이벤트 처리<br>
	 * Invoice I/F Temp테이블과 BKG_CHG_RT 테이블을 비교하여 Diff발생한 BKG을 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param InvIfDiffVO  vo
	 * @return List<InvIfDiffVO>
	 * @exception EventException
	 */
	public List<InvIfDiffVO> searchInvoiceInterfaceDifference(InvIfDiffVO vo) throws EventException {
		try {
			return dbDao.searchInvoiceInterfaceDifference(vo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * BKG에 해당되는 Service Scope 목록 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return List<ServiceScopeVO>
	 * @exception EventException
	 */
	public List<ServiceScopeVO> searchServiceScopeList(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.searchServiceScopeList(bkgNo, caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	



	/**
	 * BKG에 해당되는 Service Scope 목록 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @return List<RateMainInfoVO>
	 * @exception EventException
	 */
	public List<RateMainInfoVO> searchRateMainInfo(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.searchRateMainInfo(bkgNo, caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * BKG에 해당되는 Prepaid Charge Amout 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPpdChgAmt(String bkgNo) throws EventException {
		try {
			return dbDao.searchPpdChgAmt(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Email 전송을 위한 Prepaid 정보 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @param String  usrId
	 * @return List<EmailPpdInfoVO>
	 * @exception EventException
	 */
	public List<EmailPpdInfoVO> searchPpdChgInfo(String bkgNo, String usrId) throws EventException {
		try {
			return dbDao.searchPpdChgInfo(bkgNo, usrId);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Email 전송을 위한 대상자 Email 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPpdChgRlsEmail(String bkgNo) throws EventException {
		try {
			return dbDao.searchPpdChgRlsEmail(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Email 전송 - Prepaid Amount 변경시 BL Issue 담당자에게 Email 전송<br>
	 * 
	 * @author JIN JOO KIM
	 * @param List<EmailPpdInfoVO> vos
	 * @param String usrEml
	 * @param String accoutUsrEml
	 * @param String accountUsrNm
	 * @exception EventException
	 */
	public void sendEmailPpdAmount(List<EmailPpdInfoVO> vos, String usrEml, String accoutUsrEml, String accountUsrNm) throws EventException {
		try {
			String retEmailSndId = null;
			retEmailSndId = eaiDao.sendPpdChangeInfoByEmail(vos, usrEml, accoutUsrEml, accountUsrNm);	
			//필요시 Email 전송내역저장 아래에 추가
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG에 해당되는 Prepaid Charge Amout 변경여부 조회<br>
	 * 
	 * @author JIN JOO KIM
	 * @param String  bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPpdChgAmtFlg(String bkgNo) throws EventException {
		try {
			return dbDao.searchPpdChgAmtFlg(bkgNo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG에 해당되는 Retroactive Flag 수정<br>
	 * 
	 * @param String  bkgNo
	 * @param String  rtroKndCd
	 * @param String  caflag
	 * @exception EventException
	 */
	public void modifyRtroactiveKindCd(String bkgNo, String rtroKndCd, String caflag) throws EventException {
		try {
			 dbDao.modifyRtroactiveKindCd(bkgNo, rtroKndCd, caflag);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Booking에 저장되어 있는 OFT 목록을 조회합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String chgCd
	 * @return List<ChgAmdAuthDtlVO>
	 * @exception EventException
	 */
	public List<ChargeAmendAuthDetailVO> searchCurrentOftList(String bkgNo, String chgCd)
			throws EventException {
		try {
			return dbDao.searchCurrentOftList(bkgNo, chgCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00627",
					new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627",
					new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Charge Amend 승인 요청을 생성하고 승인자에거 메일을 발송한다.
	 * 
	 * @param ChargeAmendAuthRequestVO request
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createChargeAmendAuthRequest(ChargeAmendAuthRequestVO request, SignOnUserAccount account) throws EventException {
		try {

			// 승인 요청은 PCT이후 OFT 변경, Autorating시 매번 해야하며,
			// 승인권한은 1회만 사용 가능하다. (Insert만 있고 Update는 없음)

			ChargeAmendAuthVO authVO = request.getChargeAmendAuthVO();
			ChargeAmendAuthDetailVO[] dtlVOs = request.getChargeAmendAuthDetailVOs();
			List<ChargeAmendAuthDetailVO> dtlVO = new ArrayList<ChargeAmendAuthDetailVO>();
			ChargeAmendAuthRefUserVO[] usrVOs = request.getChargeAmendAuthRefUserVOs();
			List<ChargeAmendAuthRefUserVO> usrVO = new ArrayList<ChargeAmendAuthRefUserVO>();

			authVO.setRqstUsrId(account.getUsr_id());
			authVO.setRqstOfcCd(account.getOfc_cd());
			authVO.setCreUsrId(account.getUsr_id());
			authVO.setUpdUsrId(account.getUsr_id());
			dbDao.addChargeAmendAuthRequest(authVO);

			int cnt = dtlVOs.length;
			for (int i = 0; i < cnt; i++) {
				dtlVOs[i].setCreUsrId(account.getUsr_id());
				dtlVOs[i].setUpdUsrId(account.getUsr_id());
				dtlVO.add(dtlVOs[i]);
			}
			dbDao.addChargeAmendAuthRequestDetail(dtlVO);

			cnt = usrVOs.length;
			for (int i = 0; i < cnt; i++) {
				usrVOs[i].setCreUsrId(account.getUsr_id());
				usrVOs[i].setUpdUsrId(account.getUsr_id());
				usrVO.add(usrVOs[i]);
			}
			dbDao.addChargeAmendAuthRequestRefUser(usrVO);

			// 승인권자에게 승인 요청 메일을 전송한다.
			String mailBody = dbDao.searchApprovalRequestMailBody(request.getBkgNo(), request.getChgCd(), "Q");  // Q: Request
			request.setMailBody(mailBody);
			eaiDao.sendChargeAmendAuthRequest(request, account);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629",
					new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629",
					new String[] {}).getMessage(), ex);
		}
	}
    
    /**
     *  Charge Amend 요청에 대한 Approval/Reject 권한을 가진 사용자인지 조회한다.<br>
     * @param 	SignOnUserAccount account
     * @return	String
	 * @throws Exception
	 * @throws EventException
     */
    public String searchChargeAmendApprovalAuth(SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchChargeAmendApprovalAuth(account);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

	/**
	 * Charge Amend권한 승인 요청 목록을 조회<br>
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @param SignOnUserAccount account
	 * @return List<ChargeAmendAuthRequestListVO>
	 * @exception EventException
	 */
	public List<ChargeAmendAuthRequestListVO> searchChargeAmendAuthRequestList(ChargeAmendAuthRequestListVO vo, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchChargeAmendAuthRequestList(vo, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Charge Amend 승인 요청을 생성하고 승인자에거 메일을 발송한다.
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @param String authType
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyChargeAmendAuthRequestStatus(ChargeAmendAuthRequestListVO vo, String authType, SignOnUserAccount account) throws EventException {
		try {

			// 승인 요청은 PCT이후 OFT 변경, Autorating시 매번 해야하며,
			// 승인권한은 1회만 사용 가능하다. (Insert만 있고 Update는 없음)

			List<ChargeAmendAuthRequestListVO> rqstVO = new ArrayList<ChargeAmendAuthRequestListVO>();
			
			String mailBody = dbDao.searchApprovalRequestMailBody(vo.getBkgNo(), vo.getChgCd(), authType); 
			vo.setMailBody(mailBody);
			
			if("A".equals(authType)){
				vo.setMailTitle("[Notice] Your "+vo.getChgCd()+" exemption request has been approved ("+vo.getBkgNo()+")");
			}else if("R".equals(authType)){
				vo.setMailTitle("[Notice] Your "+vo.getChgCd()+" exemption request has been rejected ("+vo.getBkgNo()+")");
			}
			
			vo.setChgAmdRqstStsCd(authType);
			vo.setAproUsrId(account.getUsr_id());
			vo.setAproOfcCd(account.getOfc_cd());
							
			rqstVO.add(vo);
			dbDao.modifyChargeAmendAuthRequestStatus(rqstVO);

			// 승인권자에게 승인 요청 메일을 전송한다.
			eaiDao.sendChargeAmendAuthResult(rqstVO, account);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629",
					new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629",
					new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Exempt Request 승인받은 Interface된 Charge를 삭제
	 * 
	 * @param ChargeAmendAuthRequestListVO vo
	 * @throws EventException
	 */
	public void removeInterfaceCharge(ChargeAmendAuthRequestListVO vo) throws EventException {
		try {

			dbDao.removeInterfaceCharge(vo);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629",
					new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629",
					new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param OrganizationChartVO organizationChartVO
	 * @return List<OrganizationChartVO>
	 * @exception EventException
	 */
	public List<OrganizationChartVO> searchOrganizationChart(OrganizationChartVO organizationChartVO) throws EventException {
		try {
			return dbDao.searchOrganizationChart(organizationChartVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}
    
    /**
     *  이전에 산출한 Revenue와  Revenue를 비교한다.
     *  두 값이 다른 경우에만  CMPB INSERT<br>
     * @param  BkgRevCostVO revCostVO
     * @return String
	 * @throws Exception
	 * @throws EventException
     */
    public String checkRevenueAmountDifference(BkgRevCostVO revCostVO) throws EventException {
        try {
            return dbDao.checkRevenueAmountDifference(revCostVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }    
    
    /**
     *  TEMP테이블상 저장된 Revenue Amount를 조회한다.
     *  Application Date / 경리 환율 기준으로 USD 환산한 값
     * @param  BkgRevCostVO revCostVO
     * @return BkgRevCostVO
	 * @throws Exception
	 * @throws EventException
     */
    public BkgRevCostVO searchRevenueAmount(BkgRevCostVO revCostVO) throws EventException {
        try {
            return dbDao.searchRevenueAmount(revCostVO);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }

	/**
	 * Revenue Amount 상세정보를 조회 <br>
	 * 
	 * @param SignOnUserAccount account
	 * @return List<BkgChgRateVO>
	 * @exception EventException
	 */
	public List<BkgChgRateVO> searchRevenueAmountDetail(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchRevenueAmountDetail(account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}    

	
	/**
	 * Revenue와 BKG TEU Qty를 Insert한다
	 * 
	 * @param BkgRevCostVO revCostVO
	 * @throws EventException
	 */
	public void createRevenueAmount(BkgRevCostVO revCostVO) throws EventException{
		try {
			dbDao.createRevenueAmount(revCostVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	} 

	
	/**
	 * Revenue Amount 상세정보를 저장한다.
	 * 
	 * @param List<BkgChgRateVO> revDtlVOs
	 * @throws EventException
	 */
	public void createRevenueAmountDetail(List<BkgChgRateVO> revDtlVOs) throws EventException{
		try {
			dbDao.createRevenueAmountDetail(revDtlVOs);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	
	/**
	 * Group & Multi B/L Rating을 위한  목록 조회<br>
	 * 
	 * @param GroupRatingVO vo
	 * @return List<GroupRatingVO>
	 * @exception EventException
	 */
	public List<GroupRatingVO> searchGroupRatingList(GroupRatingVO vo) throws EventException {
		try {
			return dbDao.searchGroupRatingList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Group & Multi B/L Rating Self Check저장
	 * 
	 * @param GroupRatingVO ratinglist
	 * @throws EventException
	 */
	public void modifyGroupRatingList(GroupRatingVO ratinglist) throws EventException{
		try {
			
			dbDao.modifyGroupRatingList(ratinglist);
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg1605Event 저장 이벤트 처리<br>
	 * BKG_AUTO_RT_HIS 정보를 저장
	 * 
	 * @param String bkgNo
	 * @exception EventException
	 */
	public void autoRatingHistory(String bkgNo)  throws EventException{
		try {
			dbDao.autoRatingHistory(bkgNo);			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg1605Event GroupRating 이벤트 처리<br>
	 * BKG_RATE와 BKG_CHG_RT 를 저장한다.
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupRating(RateMainInfoVO rateMainInfoVO, SignOnUserAccount account) throws EventException {

		try {
			List<BkgChgRateVO> insertVoList = new ArrayList<BkgChgRateVO>();
			String bkgNo = rateMainInfoVO.getBkgNo();
			
			// ChgRateBkgRate 변경된값 저장
			dbDao.modifyBkgRate(rateMainInfoVO);

			// Temp테이블에 저장된 데이터, 기존에 Rating된 Manual/Interface Charge 조회
			insertVoList = dbDao.searchGroupRatingCharge(bkgNo, account);
			
			// ChargeRate 저장 전 이전 데이터 전체 삭제
			dbDao.removeChgRateAll(bkgNo, "N");
			
			//Charge Rate테이블에 Insert
			dbDao.addChgRate(insertVoList, "N");
			
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

    
    /**
     *  조회한 운임으로 Group Rating 가능한 상태인지 확인<br>
     * @param  String bkgNo
     * @return String
	 * @throws Exception
	 * @throws EventException
     */
    public String searchGroupRatingStatus(String bkgNo) throws EventException {
        try {
            return dbDao.searchGroupRatingStatus(bkgNo);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    

	
	/**
	 * Group Rating 상태저장
	 * 성공/실패여부, 실패시 실패사유 저장
	 * 
	 * @param String bkgNo
	 * @param String grpRatRsltCd
	 * @param String grpRatFailRsnCd
	 * @throws EventException
	 */
	public void modifyGroupRatingStatus(String bkgNo, String grpRatRsltCd, String grpRatFailRsnCd) throws EventException{
		try {
			dbDao.modifyGroupRatingStatus(bkgNo, grpRatRsltCd, grpRatFailRsnCd);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
    

	
	/**
	 * TPF Interface
	 * Group Rating에서는 I/F여부를 사용자에게 확인받지 않고 무조건 I/F진행.
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTPFSurcharge(String bkgNo, String caFlg, SignOnUserAccount account) throws EventException{
		try {
			dbDao.manageTPFSurcharge(bkgNo, caFlg, account);
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg007901 checkOftRateMatch 조회 이벤트 처리
	 * SC OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendRateCheckNotice(String bkgNo, SignOnUserAccount account) throws EventException{
		try {
			String sndId = "";
			RateCheckNoticeVO rateCheckNoticeVO = dbDao.searchRateCheckNotice(bkgNo);
			
			// OFT Missing Flag가 N에서 Y로 변경될 경우 Contract, Loading Rep에게 메일 발송
			if(rateCheckNoticeVO != null && "N".equals(rateCheckNoticeVO.getOftMssFlg())){
				//log.debug("메일 전송 대상입니다!!");
				sndId = eaiDao.sendCRateCheckNotice(rateCheckNoticeVO);
				
				//내역 기록
        		BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
        		bkgNtcHisVO.setSndId(sndId);
    			bkgNtcHisVO.setBkgNo(bkgNo);
    			bkgNtcHisVO.setNtcViaCd("M"); // M = eMail
    			bkgNtcHisVO.setNtcKndCd("OM"); // Rate Check Notice(OFT_MSS_FLG)
    			bkgNtcHisVO.setNtcEml(rateCheckNoticeVO.getSrepEml());
    			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
    			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
    			bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
    			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
    			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
        		histDao.addBkgNtcHis(bkgNtcHisVO);
			}
			 
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("BKG00629").getUserMessage(),ex);
		}
		
	}
	
	/**
     * Charge Rate 삭제
     * 
     * @param List<BkgChgRateVO> listVO
     * @param String caflag
     * @throws EventException
     */
    public void removeChgRate(List<BkgChgRateVO> listVO, String caflag) throws EventException{
           try{
                   dbDao.removeChgRate(listVO, caflag);
                    
           } catch (DAOException de) {
                   throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
           } catch (Exception ex) {
                   throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
           }
     }
    
    
	/**
	 * BKG_AUTO_RT_OCN_FRT_TMP 가 생성
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void createOcnFrtTmpByChgRt(String bkgNo) throws EventException{
		try {
			dbDao.createOcnFrtTmpByChgRt(bkgNo);
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

}

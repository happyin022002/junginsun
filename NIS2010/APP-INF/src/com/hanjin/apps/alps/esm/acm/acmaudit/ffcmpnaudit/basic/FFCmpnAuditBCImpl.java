/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditBCImpl.java
*@FileTitle : FFCmpnAuditBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.15 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration.FFCmpnAuditDBDAO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnAuditVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailBasicbyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailChargebyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailHistorybyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnRateInfoVO;
import com.hanjin.apps.alps.esm.acm.acmcalculation.ACMCalculationSC;
import com.hanjin.apps.alps.esm.agt.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.agt.common.basic.CommonBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0027Event,FFCmpnAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FFCmpnAuditBCImpl extends BasicCommandSupport implements FFCmpnAuditBC {

	// Database Access Object
	private transient FFCmpnAuditDBDAO dbDao = null;

	/**
	 * FFCmpnAuditBCImpl 객체 생성<br>
	 * FFCmpnAuditDBDAO를 생성한다.<br>
	 */
	public FFCmpnAuditBCImpl() {
		dbDao = new FFCmpnAuditDBDAO();
	}

	/**
	 * [ESM_ACM_0027]
	 * FF Compensation Audit 목록을 조회<br>
	 *
	 * @param FFCmpnAuditVO ffcmpnAuditVO
	 * @return List<FFCmpnAuditVO>
	 * @exception EventException
	 */
	public List<FFCmpnAuditVO> searchFFCmpnAudit(FFCmpnAuditVO ffcmpnAuditVO) throws EventException {
		try {
			return dbDao.searchFFCmpnAudit(ffcmpnAuditVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0027]
	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
	 *
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalculateFFAudit(String bkg_no, SignOnUserAccount account) throws EventException{
		// FAC Commission 계산을 위한 객체
		ACMCalculationSC acmCalcSC = new ACMCalculationSC();
		try {
			acmCalcSC.reCalculateFFComm(bkg_no, account);
			//acmCalcSC.reCalculateFFComm("GOA71150060","  ");
			return null;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면의 Reject 저장<br>
	 *
	 * @param FFCmpnAuditVO[] ffcmpnAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFCmpnAudit(FFCmpnAuditVO[] ffcmpnAuditVOs, SignOnUserAccount account) throws EventException{
		List<FFCmpnAuditVO> updateVoList01 = null;
		List<FFCmpnAuditVO> updateVoList02 = null;
		List<FFCmpnAuditVO> updateVoList03 = null;
		List<FFCmpnAuditVO> updateVoList04 = null;
		try {
			CommonBC commonBC = new CommonBCImpl();

			for (int i=0; i<ffcmpnAuditVOs.length; i++) {
				if (ffcmpnAuditVOs[i].getIbflag().equals("U")) {
					String[] cust_cd = commonBC.searchCodeList("C", "C", new String[]{ffcmpnAuditVOs[i].getFrtFwrdCntSeq()});	//Freight Forwarder Customer Code
					String[] vndr_cd = commonBC.searchCodeList("V", "C", new String[]{ffcmpnAuditVOs[i].getVndrCntSeq()});		//Vendor Code;

					ffcmpnAuditVOs[i].setBkgFfCntCd(cust_cd[0].substring(0, 2));
					ffcmpnAuditVOs[i].setBkgFfSeq(cust_cd[0].substring(2));
					ffcmpnAuditVOs[i].setVndrCntCd(vndr_cd[0].substring(0, 2));
					ffcmpnAuditVOs[i].setVndrSeq(vndr_cd[0].substring(2));
					ffcmpnAuditVOs[i].setUsrId(account.getUsr_id());

					//BkgInfolist.getVndrCntSeq()
					String vendor = dbDao.searchVndrSeqCheck(ffcmpnAuditVOs[i].getVndrSeq());

					//log.debug("\n vendor==>" + vendor);
					if (vendor == null || vendor.length() < 1) {
						new ErrorHandler("ACM00039", new String[]{ ffcmpnAuditVOs[i].getBkgFfSeq()}).getUserMessage();
						return;
					}

					updateVoList01 = new ArrayList<FFCmpnAuditVO>();
					updateVoList02 = new ArrayList<FFCmpnAuditVO>();
					updateVoList03 = new ArrayList<FFCmpnAuditVO>();
					updateVoList04 = new ArrayList<FFCmpnAuditVO>();

					if (ffcmpnAuditVOs[i].getFfCmpnStsCd().equals("CE")) {
						if (ffcmpnAuditVOs[i].getFfCmpnRmk().equals("Calculation Success!")) {
							updateVoList01.add(ffcmpnAuditVOs[i]);
							dbDao.modifyFFCmpnAuditCalSuccess(updateVoList01);
						} else {
							updateVoList02.add(ffcmpnAuditVOs[i]);
							dbDao.modifyFFCmpnAuditCalFail(updateVoList02);
						}
					} else {
						updateVoList03.add(ffcmpnAuditVOs[i]);
						dbDao.modifyFFCmpnAuditStsCe(updateVoList03);
					}
					updateVoList04.add(ffcmpnAuditVOs[i]);
					dbDao.modifyFFCmpnAuditBkgInfo(updateVoList04);
					
					
				}
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0117]-01
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailBasicbyBlVO>
	 * @exception EventException
	 */
	public List<FFCmpnDetailBasicbyBlVO> searchFFCmpnDetailBasicbyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws EventException {
		try {
			return dbDao.searchFFCmpnDetailBasicbyBlList(ffCmpnDetailBasicbyBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0117]-02
	 * FF Compensation Details &amp; History for B/L 상세 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailHistorybyBlVO>
	 * @exception EventException
	 */
	public List<FFCmpnDetailHistorybyBlVO> searchFFCmpnDetailHistorybyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws EventException {
		try {
			return dbDao.searchFFCmpnDetailHistorybyBlList(ffCmpnDetailBasicbyBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0117]-03
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO
	 * @return List<FFCmpnDetailChargebyBlVO>
	 * @exception EventException
	 */
	public List<FFCmpnDetailChargebyBlVO> searchFFCmpnDetailChargebyBlList(FFCmpnDetailBasicbyBlVO ffCmpnDetailBasicbyBlVO) throws EventException {
		try {
			return dbDao.searchFFCmpnDetailChargebyBlList(ffCmpnDetailBasicbyBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0117]-04
	 * FF Compensation Details &amp; History for B/L 기본 목록을 조회<br>
	 *
	 * @param FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO
	 * @return List<FFCmpnRateInfoVO>
	 * @exception EventException
	 */
	public List<FFCmpnRateInfoVO> searchFFCmpnRateInfoList(FFCmpnDetailHistorybyBlVO ffCmpnDetailHistorybyBlVO) throws EventException {
		try {
			return dbDao.searchFFCmpnRateInfoList(ffCmpnDetailHistorybyBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
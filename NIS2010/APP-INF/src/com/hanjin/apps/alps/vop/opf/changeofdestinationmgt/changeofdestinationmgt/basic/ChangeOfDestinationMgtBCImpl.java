/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtBCImpl.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
*=========================================================
* History
* 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration.ChangeOfDestinationMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeBoxBlVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodOldNewPodVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.OpfCodDvsFeeVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * ALPS-ChangeOfDestinationMgt Business Logic Basic Command implementation<br>
 * - ALPS-ChangeOfDestinationMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0033EventResponse,ChangeOfDestinationMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChangeOfDestinationMgtBCImpl extends BasicCommandSupport implements ChangeOfDestinationMgtBC {

	// Database Access Object
	private transient ChangeOfDestinationMgtDBDAO dbDao = null;

	/**
	 * ChangeOfDestinationMgtBCImpl 객체 생성<br>
	 * ChangeOfDestinationMgtDBDAO를 생성한다.<br>
	 */
	public ChangeOfDestinationMgtBCImpl() {
		dbDao = new ChangeOfDestinationMgtDBDAO();
	}
	/**
	 * COD Approval을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestListVO>
	 * @exception EventException
	 */
	public List<CODRequestListVO> searchCODRequestList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODRequestList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}		
	}
	
	 /**
	 * RSO, LANE 별 EMAIL 을 조회 합니다.<br>
	 * 2010.07.23 추가 by WJK<br>
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODEmailsendList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODEmailsendList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
	}
	
	 /**
	 * 해당 VVD의 CARRIER CODE 를 조회 합니다.<br>
	 * 2010.07.23 추가 by WJK<br>
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODCarrierCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
	try {
		return dbDao.searchCODCarrierCd(changeOfDestinationMgtConditionVO);
    } catch (DAOException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
	}		
}
	
	 /**
	 * 해당 BKG의 NEW,OLD POD CODE 를 조회 합니다.<br>
	 * 2010.07.23 추가 by WJK<br>
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODNewOldPODCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
	try {
		return dbDao.searchCODNewOldPODCd(changeOfDestinationMgtConditionVO);
    } catch (DAOException ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
    } catch (Exception ex) {
        log.error("err " + ex.toString(), ex);
        throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
	}		
}
	
	/**
	 * RSO 콤보생성을 조회 합니다.<br>
	 *
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchRsoCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchRsoCombo(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기
	 * 2010.07.26 추가 by LHJ<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcRso(SignOnUserAccount account) throws EventException {
		String rso = "";
		try {
			List<ScgRgnShpOprCdVO> list = dbDao.searchOfcRso(account);
			
			if( list.size() > 0 ) {
				rso = list.get(0).getRgnShpOprCd();
			}
			return rso;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}


	/**
	 * Freight & Charges for COD에 CUR 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrCdCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCurrCdCombo(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}
	}

	/**
	 * COD Condition 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchCodCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCodCombo(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * Auth Result 콤보생성을 조회 합니다.
	 * 2010.07.23 추가 by LHJ<br>
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchAuthCombo() throws EventException {
		try {
			return dbDao.searchAuthCombo();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * COD Reason 콤보생성을 조회 합니다.
	 * 2010.07.23 추가 by LHJ<br>
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchCodRsnCombo() throws EventException {
		try {
			return dbDao.searchCodRsnCombo();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval"}).getMessage(), ex);
		}
	}
	
	/**
	 * Reject Reason 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<OpfCodRjctCdVO>
	 * @exception EventException
	 */
	public List<OpfCodRjctCdVO> searchCODRejectCodeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODRejectCodeList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}
	}
	
	/**
	 * COD Request Information 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODDetail(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}
	}
		
	/**
	 * Approval Information 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ApprovalInformationVO>
	 * @exception EventException
	 */ 
	public List<ApprovalInformationVO> searchRsoDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchRsoDetail(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Freight & Charges for COD 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostVO> searchRehandlingList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchRehandlingList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}
	}
	
	/**
	 * Row Add 시 CHR, CUR, Rate 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostListVO> searchRehandlingQTY(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws EventException {
		
		try {
			return dbDao.searchRehandlingQTY(changeOfDestinationMgtConditionVO, codRehandlingInfoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}
	}	
	
	/**
	 * CNTR Q'ty 시 Container List 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostListVO> searchRehandlingContainerList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws EventException {
		
		try {
			return dbDao.searchRehandlingContainerList(changeOfDestinationMgtConditionVO, codRehandlingInfoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}
	}
	
	/**
	 * CNTR Type/SIZE시 유효성 체크를 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostVO> searchRatUtCdCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchRatUtCdCheck(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}
	}
	
	/**
	 * CHR, CUR, Rate 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param String strCurrCd
	 * @param String strRate
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostVO> searchRehandlingRate(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, String strCurrCd, String strRate) throws EventException {
		try {
			return dbDao.searchRehandlingRate(changeOfDestinationMgtConditionVO, strCurrCd, strRate);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Bay Plan 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ChangeOfDestinationMgtConditionVO>
	 * @exception EventException
	 */
	public List<ChangeOfDestinationMgtConditionVO> searchBayPlanCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchBayPlanCheck(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Region COD MIN. Tariff 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeVO> searchDiversionList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchDiversionList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Tariff Registration"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Tariff Registration"}).getMessage(), ex);
		}
	}	
	
	/**
	 * Region COD MIN. Tariff View 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeViewVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeViewVO> searchDiversionViewList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchDiversionViewList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Tariff Registration"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Tariff Registration"}).getMessage(), ex);
		}
	}
	
	/**
	 * Region COD MIN. Tariff 을 저장 합니다.<br>
	 * 
	 * @param OpfCodDvsFeeVO[] opfCodDvsFeeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodDivFee(OpfCodDvsFeeVO[] opfCodDvsFeeVO, SignOnUserAccount account) throws EventException{
		try {
			List<OpfCodDvsFeeVO> insertVoList = new ArrayList<OpfCodDvsFeeVO>();
			List<OpfCodDvsFeeVO> updateVoList = new ArrayList<OpfCodDvsFeeVO>();
			List<OpfCodDvsFeeVO> deleteVoList = new ArrayList<OpfCodDvsFeeVO>();
			for ( int i=0; i<opfCodDvsFeeVO .length; i++ ) {
				if ( opfCodDvsFeeVO[i].getIbflag().equals("I")){
					opfCodDvsFeeVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(opfCodDvsFeeVO[i]);
				} else if ( opfCodDvsFeeVO[i].getIbflag().equals("U")){
					opfCodDvsFeeVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfCodDvsFeeVO[i]);
				} else if ( opfCodDvsFeeVO[i].getIbflag().equals("D")){
					deleteVoList.add(opfCodDvsFeeVO[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.modifysearchDiversionListS(updateVoList);
			}
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Region COD MIN. Tariff"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Region COD MIN. Tariff"}).getMessage(), ex);
		}			
	}
	
	/**
	 * OpfCodDvsFeeBoxBl 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeBoxBlVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeBoxBlVO> searchCodDiversionFeeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCodDiversionFeeList(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"OpfCodDvsFeeBoxBl"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"OpfCodDvsFeeBoxBl"}).getMessage(), ex);
		}
	}
	
 	/**
 * 인터페이스 이벤트 처리<br>
 * OPF에서 요청된 Port에서 Re-handling될 화물의 Cost를 산출조회.<br>
 *
 * @param List<BkgCodCostListVO> searchList
 * @return List<List<BkgCodCostVO>>
 * @exception EventException
 */
public List<List<BkgCodCostVO>> searchRehandlingCost(List<BkgCodCostListVO> searchList) throws EventException {
	List<List<BkgCodCostVO>>				list	= new ArrayList<List<BkgCodCostVO>>();

	try {
		for( int i = 0; searchList != null && i < searchList.size(); i++ ) {
			list.add( dbDao.searchRehandlingCost( (BkgCodCostListVO)searchList.get(i) ) );
		}
		
		return list;
		
	} catch (DAOException de) {
		log.error("err " + de.toString(), de);
		throw new EventException(de.getMessage());
	}
}
	
	/**
	 * Old POD ETA & New POD ETA & CNTR TP/SZ & QTY조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodOldNewPodVO>
	 * @exception EventException
	 */
	public List<OpfCodOldNewPodVO> searchOldNewPodCntr(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchOldNewPodCntr(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"OldNewPodCntr"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"OldNewPodCntr"}).getMessage(), ex);
		}
	}
		
}
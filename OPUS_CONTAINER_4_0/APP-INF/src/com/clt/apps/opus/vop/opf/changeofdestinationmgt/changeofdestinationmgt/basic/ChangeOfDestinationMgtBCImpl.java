/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtBCImpl.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
*=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration.ChangeOfDestinationMgtDBDAO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * OPUS-ChangeOfDestinationMgt Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of  VOP_OPF_0033EventResponse,ChangeOfDestinationMgtBC 
 * @since J2EE 1.6
 */
public class ChangeOfDestinationMgtBCImpl extends BasicCommandSupport implements ChangeOfDestinationMgtBC {

	// Database Access Object
	private transient ChangeOfDestinationMgtDBDAO dbDao = null;

	/**
	 * Creating object ChangeOfDestinationMgtBCImpl <br>
	 * Creating ChangeOfDestinationMgtDBDAO<br>
	 */
	public ChangeOfDestinationMgtBCImpl() {
		dbDao = new ChangeOfDestinationMgtDBDAO();
	}
	/**
	 * Retrieve COD Approval<br>
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
	 * Retrieve EMAIL by RSO, LANE <br>
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
	 * Retrieve CARRIER CODE of VVD chosen<br>
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
	 * Retrieve NEW,OLD POD CODE of BKG chosen<br>
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
	 * Retrieve creating Combo of RSO<br>
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
	 * Search RSO corresponding to office of login user 
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
	 * Retrieve creating Combo of CUR in Freight & Charges for COD<br>
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
	 * Retrieve creating Combo of COD Condition <br>
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
	 * Retrieve creating Combo of Auth Result 
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
	 * Retrieve creating Combo of COD Reason 
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
	 * Retrieve creating Combo of Reject Reason <br>
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
	 * Retrieve COD Request Information .<br>
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
	 * Retrieve Approval Information .<br>
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
	 * Retrieve Freight & Charges for COD .<br>
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
	 * Retrieve CHR, CUR, Rate in case of Row Add <br>
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
	 * Retrieve Container List in case of CNTR Q'ty .<br>
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
	 * Check validation in case of CNTR Type/SIZE<br>
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
	 * Retrieve CHR, CUR, Rate .<br>
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
	 * Retrieve Bay Plan .<br>
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
	 *Retrieve Region COD MIN. Tariff .<br>
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
	 * Retrieve Region COD MIN. Tariff View .<br>
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
	 * Save Region COD MIN. Tariff <br>
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
	 * COD Diversion Rate 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostVO> searchCODDiversionChargeCalc(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchCODDiversionChargeCalc(changeOfDestinationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Freight & Charges for COD"}).getMessage(), ex);
		}
	}
	
	/**
	 * Save Remark<br>
	 * 
	 * @param CodAuthVO codAuthVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void saveRemark(CodAuthVO codAuthVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.saveRemark(codAuthVO,account.getUpd_usr_id());
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Region COD MIN. Tariff"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Region COD MIN. Tariff"}).getMessage(), ex);
		}			
	}
}
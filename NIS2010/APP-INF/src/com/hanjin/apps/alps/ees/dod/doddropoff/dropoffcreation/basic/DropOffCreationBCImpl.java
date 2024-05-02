/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationBCImpl.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration.DropOffCreationDBDAO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.DropOffDiscountDetailVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalHeaderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
//import com.hanjin.framework.component.backend.core.BackEndJobManager;
//import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-DodDropOff Business Logic Command Interface<br>
 * - ALPS-DodDropOff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Son, Jin-Hwan
 * @since J2EE 1.6
 */
public class DropOffCreationBCImpl extends BasicCommandSupport implements DropOffCreationBC {

	// Database Access Object
	private transient DropOffCreationDBDAO dbDao = null;

	/**
	 * DropOffCreationBCImpl 객체 생성<br>
	 * DropOffCreationDBDAO를 생성한다.<br>
	 */
	public DropOffCreationBCImpl() {
		dbDao = new DropOffCreationDBDAO();
	}

	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchDodDrpOffChgVOList(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList2(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchDodDrpOffChgVOList2(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 면재 대상 목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOExptList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchDodDrpOffChgVOExptList(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 면제 대상]을 DOD_DRP_OFF_CHG테이블에 저장]합니다.<br>
	 * 
	 * @param List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageDodDrpOffChgVOExptList(List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOs, String usrId) throws EventException {

		try {

			SearchDodDrpOffChgVO searchDodDrpOffChgVO2 = new SearchDodDrpOffChgVO();
			
			for (int i = 0; i < searchDodDrpOffChgVOs.size(); i++) {
				
				searchDodDrpOffChgVO2.setBkgNo(searchDodDrpOffChgVOs.get(i).getBkgNo());
				searchDodDrpOffChgVO2.setCntrNo(searchDodDrpOffChgVOs.get(i).getCntrNo());
				searchDodDrpOffChgVO2.setDrpOffChgSeq(searchDodDrpOffChgVOs.get(i).getDrpOffChgSeq());
				searchDodDrpOffChgVO2.setInvSrcNo(searchDodDrpOffChgVOs.get(i).getInvSrcNo());
				searchDodDrpOffChgVO2.setArIfNo(searchDodDrpOffChgVOs.get(i).getArIfNo());
				
				searchDodDrpOffChgVO2.setDrpOffChgTrfSeq(searchDodDrpOffChgVOs.get(i).getDrpOffChgTrfSeq());
				searchDodDrpOffChgVO2.setDrpOffChgMnlFlg(searchDodDrpOffChgVOs.get(i).getDrpOffChgMnlFlg());
				searchDodDrpOffChgVO2.setCntrTpszCd(searchDodDrpOffChgVOs.get(i).getCntrTpszCd());
				searchDodDrpOffChgVO2.setTroIbCfmOfcCd(searchDodDrpOffChgVOs.get(i).getTroIbCfmOfcCd());
				searchDodDrpOffChgVO2.setTroIbCfmDt(searchDodDrpOffChgVOs.get(i).getTroIbCfmDt());
				
				searchDodDrpOffChgVO2.setDelCd(searchDodDrpOffChgVOs.get(i).getDelCd());
				searchDodDrpOffChgVO2.setCntrRtnYdCd(searchDodDrpOffChgVOs.get(i).getCntrRtnYdCd());
				searchDodDrpOffChgVO2.setCntrRtnDt(searchDodDrpOffChgVOs.get(i).getCntrRtnDt());
				searchDodDrpOffChgVO2.setCustCntCd(searchDodDrpOffChgVOs.get(i).getCustCntCd());
				searchDodDrpOffChgVO2.setCustSeq(searchDodDrpOffChgVOs.get(i).getCustSeq());
				searchDodDrpOffChgVO2.setSpclCustCntCd(searchDodDrpOffChgVOs.get(i).getSpclCustCntCd());
				searchDodDrpOffChgVO2.setSpclCustSeq(searchDodDrpOffChgVOs.get(i).getSpclCustSeq());
				searchDodDrpOffChgVO2.setCurrCd(searchDodDrpOffChgVOs.get(i).getCurrCd());
				
				searchDodDrpOffChgVO2.setGenTrfAmt(searchDodDrpOffChgVOs.get(i).getGenTrfAmt());
				searchDodDrpOffChgVO2.setSpclTrfAmt(searchDodDrpOffChgVOs.get(i).getSpclTrfAmt());
				searchDodDrpOffChgVO2.setDcAmt(searchDodDrpOffChgVOs.get(i).getDcAmt());
				searchDodDrpOffChgVO2.setSvcFeeAmt(searchDodDrpOffChgVOs.get(i).getSvcFeeAmt());
				searchDodDrpOffChgVO2.setTtlAmt(searchDodDrpOffChgVOs.get(i).getTtlAmt());
				searchDodDrpOffChgVO2.setDcRmk(searchDodDrpOffChgVOs.get(i).getDcRmk());
				searchDodDrpOffChgVO2.setDeltFlg(searchDodDrpOffChgVOs.get(i).getDeltFlg());
				
				searchDodDrpOffChgVO2.setCreUsrId(searchDodDrpOffChgVOs.get(i).getCreUsrId());
				searchDodDrpOffChgVO2.setUpdUsrId(searchDodDrpOffChgVOs.get(i).getUpdUsrId());
				searchDodDrpOffChgVO2.setTroIbCxlFlg(searchDodDrpOffChgVOs.get(i).getTroIbCxlFlg());
				searchDodDrpOffChgVO2.setDrpOffChgTrfSpclSeq(searchDodDrpOffChgVOs.get(i).getDrpOffChgTrfSpclSeq());
				searchDodDrpOffChgVO2.setAtchFileLnkId(searchDodDrpOffChgVOs.get(i).getAtchFileLnkId());
				searchDodDrpOffChgVO2.setDrpOffXterRmk(searchDodDrpOffChgVOs.get(i).getDrpOffXterRmk());
				searchDodDrpOffChgVO2.setDrpOffCustRefRmk(searchDodDrpOffChgVOs.get(i).getDrpOffCustRefRmk());
				searchDodDrpOffChgVO2.setDrpOffChgMnlFlg(searchDodDrpOffChgVOs.get(i).getDrpOffChgMnlFlg());
				
				dbDao.manageArInvList(searchDodDrpOffChgVO2, usrId);
			}	
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EES_DOD_0001 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageArInvList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId) throws EventException {
		
		String drpOffChgSeq = "";
		String invSrcNo = "";
		
		List<SearchDodDrpOffChgVO> addVoList = new ArrayList<SearchDodDrpOffChgVO>();
		
		try {
			for(int i = 0; i < searchDodDrpOffChgVOs.length; i ++) {
				//drp_off_chg_seq채번
				drpOffChgSeq = dbDao.searchDrpOffChgSeq(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo());
				//inv_src_no채번
				invSrcNo = dbDao.searchInvSrcNo(searchDodDrpOffChgVOs[i].getTroIbCfmOfcCd());
				
				searchDodDrpOffChgVOs[i].setDrpOffChgSeq(drpOffChgSeq);
				searchDodDrpOffChgVOs[i].setInvSrcNo(invSrcNo);
				searchDodDrpOffChgVOs[i].setCreUsrId(usrId);
				searchDodDrpOffChgVOs[i].setUpdUsrId(usrId);
				searchDodDrpOffChgVOs[i].setDrpOffChgMnlFlg("N");
				searchDodDrpOffChgVOs[i].setSvcFeeAmt("0");
				searchDodDrpOffChgVOs[i].setTroIbCxlFlg("N");
				if(!"".equals(searchDodDrpOffChgVOs[i].getDrpOffChgTrfSpclSeq()) ){
					searchDodDrpOffChgVOs[i].setDrpOffChgTrfSeq("");
					searchDodDrpOffChgVOs[i].setGenTrfAmt("");
				}else{
					searchDodDrpOffChgVOs[i].setDrpOffChgTrfSpclSeq("");
					searchDodDrpOffChgVOs[i].setSpclTrfAmt("");
				}
				dbDao.manageArInvList(searchDodDrpOffChgVOs[i], usrId);
				addVoList.add(searchDodDrpOffChgVOs[i]);
			}
			/*
			if(addVoList.size() > 0) {
				dbDao.manageArInvList(addVoList, usrId);				
			}
			*/
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), ex);
		}
		return addVoList;
	}
	
	/**
	 * EES_DOD_0002 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchMnlDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchMnlDodDrpOffChgVOList(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EES_DOD_0002 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @param String spclCdSeq
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY(String bkgNo, String cntrNo, String cntrRtnYdCd, String spclCdSeq) throws EventException {
		try {
			return dbDao.searchTariffForRTNCY(bkgNo, cntrNo, cntrRtnYdCd, spclCdSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * EES_DOD_0002 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @param ofcCd String 
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageMnlArInvList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId, String ofcCd) throws EventException {
		
		String drpOffChgSeq = "";
		String invSrcNo = "";
		
		List<SearchDodDrpOffChgVO> addVoList = new ArrayList<SearchDodDrpOffChgVO>();
		
		try {
			for(int i = 0; i < searchDodDrpOffChgVOs.length; i ++) {
				//drp_off_chg_seq채번
				drpOffChgSeq = dbDao.searchDrpOffChgSeq(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo());
				//inv_src_no채번
				invSrcNo = dbDao.searchInvSrcNo(ofcCd);
				
				searchDodDrpOffChgVOs[i].setDrpOffChgSeq(drpOffChgSeq);
				searchDodDrpOffChgVOs[i].setInvSrcNo(invSrcNo);
				searchDodDrpOffChgVOs[i].setCreUsrId(usrId);
				searchDodDrpOffChgVOs[i].setUpdUsrId(usrId);
				searchDodDrpOffChgVOs[i].setDrpOffChgMnlFlg("Y");
				searchDodDrpOffChgVOs[i].setSvcFeeAmt("0");
				searchDodDrpOffChgVOs[i].setTroIbCxlFlg("N");
				if(!"".equals(searchDodDrpOffChgVOs[i].getDrpOffChgTrfSpclSeq()) ){
					searchDodDrpOffChgVOs[i].setDrpOffChgTrfSeq("");
					searchDodDrpOffChgVOs[i].setGenTrfAmt("");
				}else{
					searchDodDrpOffChgVOs[i].setDrpOffChgTrfSpclSeq("");
					searchDodDrpOffChgVOs[i].setSpclTrfAmt("");
				}
				dbDao.manageArInvList(searchDodDrpOffChgVOs[i], usrId);
				addVoList.add(searchDodDrpOffChgVOs[i]);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), ex);
		}
		return addVoList;
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH]<br>
	 * [EES_DOD_0001에서 호출하여 AR INV 보내기전 RTN CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchCrrDodDrpOffChgVO(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchCrrDodDrpOffChgVO(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH01]<br>
	 * [EES_DOD_0004에서 호출하여 AR INV 보내고 난 후 CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> searchCrrDodDrpOffChgVOList(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchCrrDodDrpOffChgVOList(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH02]<br>
	 * [Correction AR INV 수행 전에 이전 AR INV 수행 건에 대한 I/F 상태값]을 [조회]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO	searchDodDrpOffChgVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInvErpIfStsCd(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		try {
			return dbDao.searchInvErpIfStsCd(searchDodDrpOffChgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH08]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY1(String bkgNo, String cntrNo, String cntrRtnYdCd) throws EventException {
		try {
			return dbDao.searchTariffForRTNCY1(bkgNo, cntrNo, cntrRtnYdCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrRtnYdCd
	 * @return SearchDodDrpOffChgVO
	 * @exception EventException
	 */
	public SearchDodDrpOffChgVO searchTariffForRTNCY2(String bkgNo, String cntrNo, String cntrRtnYdCd) throws EventException {
		try {
			return dbDao.searchTariffForRTNCY2(bkgNo, cntrNo, cntrRtnYdCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EES_DOD_0013 : [MULTI]<br>
	 * [Drop Off Charge대상목록]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @param opener String
	 * @param ofcCd String
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageCrrArInvList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId, String opener, String ofcCd) throws EventException {
		List<SearchDodDrpOffChgVO> addVoList = new ArrayList<SearchDodDrpOffChgVO>();
		SearchDodDrpOffChgVO searchDodDrpOffChgVO = null;
		
		String drpOffChgSeq = "";
		String invSrcNo = "";
		log.debug("\r Opner : " + opener);
		try {
			if("EES_DOD_0004".equals(opener)) {// after  AR INV : EES_DOD_0004 : Invoice Inquiry
				// Invoice가 이미 발행되고 난 후에 변경하는 것이므로 기존 발행된 Invoice의 TTL_AMT를 -하고 Correction한 Invoice의 TTL_AMT를 추가 발행한다.
				for (int i = 0; i < searchDodDrpOffChgVOs.length; i++) {
					searchDodDrpOffChgVO = dbDao.searchDodDrpOffChgVO(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo(), searchDodDrpOffChgVOs[i].getDrpOffChgSeq());
					//drp_off_chg_seq채번
					drpOffChgSeq = dbDao.searchDrpOffChgSeq(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo());

					searchDodDrpOffChgVO.setDrpOffChgSeq(drpOffChgSeq);
					
					log.debug("\r Final Amount : " + searchDodDrpOffChgVO.getTtlAmt());
					searchDodDrpOffChgVO.setTtlAmt(String.format("%.2f", Double.parseDouble(searchDodDrpOffChgVO.getTtlAmt()) * -1d ) );
					
					if(!"-0.00".equals(searchDodDrpOffChgVO.getTtlAmt()) ){	
						dbDao.manageArInvList(searchDodDrpOffChgVO, usrId); // 기 발행 건 TTL_AMT (-)한놈
						addVoList.add(searchDodDrpOffChgVO);
					}
					
					//drp_off_chg_seq채번
					drpOffChgSeq = dbDao.searchDrpOffChgSeq(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo());

					searchDodDrpOffChgVOs[i].setDrpOffChgSeq(drpOffChgSeq);
					
					if(!"-0.00".equals(searchDodDrpOffChgVO.getTtlAmt()) ){	
						searchDodDrpOffChgVOs[i].setInvSrcNo(searchDodDrpOffChgVO.getInvSrcNo());
					}
					else {
						invSrcNo = dbDao.searchInvSrcNo(ofcCd);
						searchDodDrpOffChgVOs[i].setInvSrcNo(invSrcNo);
					}
					
					searchDodDrpOffChgVOs[i].setTroIbCfmDt(searchDodDrpOffChgVO.getTroIbCfmDt());
					searchDodDrpOffChgVOs[i].setCntrRtnDt(searchDodDrpOffChgVO.getCntrRtnDt());
//					searchDodDrpOffChgVOs[i].setCustCntCd(searchDodDrpOffChgVO.getCustCntCd());
//					searchDodDrpOffChgVOs[i].setCustSeq(searchDodDrpOffChgVO.getCustSeq());
					searchDodDrpOffChgVOs[i].setSpclCustCntCd(searchDodDrpOffChgVO.getSpclCustCntCd());
					searchDodDrpOffChgVOs[i].setSpclCustSeq(searchDodDrpOffChgVO.getSpclCustSeq());
					searchDodDrpOffChgVOs[i].setCreUsrId(usrId);
					searchDodDrpOffChgVOs[i].setUpdUsrId(usrId);
					searchDodDrpOffChgVOs[i].setDrpOffChgMnlFlg(searchDodDrpOffChgVO.getDrpOffChgMnlFlg());
					searchDodDrpOffChgVOs[i].setTroIbCxlFlg("N");
					
					if(!"".equals(searchDodDrpOffChgVOs[i].getDrpOffChgTrfSpclSeq()) ){
						searchDodDrpOffChgVOs[i].setDrpOffChgTrfSeq("");
						searchDodDrpOffChgVOs[i].setGenTrfAmt("");
					}else{
						searchDodDrpOffChgVOs[i].setDrpOffChgTrfSpclSeq("");
						searchDodDrpOffChgVOs[i].setSpclTrfAmt("");
					}
					
					log.debug("\r caller EES_DOD_0004 >>> Special Seq : " + searchDodDrpOffChgVOs[i].getDrpOffChgTrfSpclSeq() 
							+ " | " + searchDodDrpOffChgVOs[i].getSpclTrfAmt() 
							+ " -- General Seq : " + searchDodDrpOffChgVOs[i].getDrpOffChgTrfSeq() 
							+ " | " + searchDodDrpOffChgVOs[i].getGenTrfAmt());

					dbDao.manageArInvList(searchDodDrpOffChgVOs[i], usrId); // Correction 한놈
					addVoList.add(searchDodDrpOffChgVOs[i]);
				}
				
			}else{// before AR INV : EES_DOD_0001 : Invoice Creation & Correction
				// Correction한 Invoice를 생성
				for(int j = 0; j < searchDodDrpOffChgVOs.length; j ++) {
					//drp_off_chg_seq채번
					drpOffChgSeq = dbDao.searchDrpOffChgSeq(searchDodDrpOffChgVOs[j].getBkgNo(), searchDodDrpOffChgVOs[j].getCntrNo());
					//inv_src_no채번
					invSrcNo = dbDao.searchInvSrcNo(ofcCd);
					
					searchDodDrpOffChgVOs[j].setDrpOffChgSeq(drpOffChgSeq);
					searchDodDrpOffChgVOs[j].setInvSrcNo(invSrcNo);
					searchDodDrpOffChgVOs[j].setCreUsrId(usrId);
					searchDodDrpOffChgVOs[j].setUpdUsrId(usrId);
					searchDodDrpOffChgVOs[j].setDrpOffChgMnlFlg("N");
					searchDodDrpOffChgVOs[j].setTroIbCxlFlg("N");
					
					if(!"".equals(searchDodDrpOffChgVOs[j].getDrpOffChgTrfSpclSeq()) ){
						searchDodDrpOffChgVOs[j].setDrpOffChgTrfSeq("");
						searchDodDrpOffChgVOs[j].setGenTrfAmt("");
					}else{
						searchDodDrpOffChgVOs[j].setDrpOffChgTrfSpclSeq("");
						searchDodDrpOffChgVOs[j].setSpclTrfAmt("");
					}
					
					log.debug("\r caller EES_DOD_0001 >>> Special Seq : " + searchDodDrpOffChgVOs[j].getDrpOffChgTrfSpclSeq() 
							+ " | " + searchDodDrpOffChgVOs[j].getSpclTrfAmt() 
							+ " -- General Seq : " + searchDodDrpOffChgVOs[j].getDrpOffChgTrfSeq() 
							+ " | " + searchDodDrpOffChgVOs[j].getGenTrfAmt());
					
					dbDao.manageArInvList(searchDodDrpOffChgVOs[j], usrId);
					addVoList.add(searchDodDrpOffChgVOs[j]);
				}
				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), ex);
		}
		return addVoList;
	}
	
    /**
     * [AR Interface]에 전달할 내용을 [조회]한다.
     * 
     * @param SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
	public ARInterfaceCreationVO searchARInterfaceInvoice(SearchDodDrpOffChgVO searchDodDrpOffChgVO) throws EventException {
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
    	InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
    	List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
    	List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>();
    	
		try {
			
			invArIfMnVO = dbDao.searchARInterfaceInvoice(searchDodDrpOffChgVO);
			invArIfChgVOs = dbDao.searchInterfaceCharge(searchDodDrpOffChgVO);
			invArIfCntrVOs = dbDao.searchInterfaceContainer(searchDodDrpOffChgVO);

    		arInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
    		arInterfaceCreationVO.setInvArIfChgVOs(invArIfChgVOs);
    		arInterfaceCreationVO.setInvArIfCntrVOs(invArIfCntrVOs);
    		
        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00006").getUserMessage());	
        }
    	return arInterfaceCreationVO;
	}
	
    /**
     * [AR Interface No]을 [DOD_DRP_OFF_CHG 테이블에 Update]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @param String arIfNo
	 * @param String invSrcNo
     * @throws EventException
     */
	public void modifyARInterface(String bkgNo, String cntrNo, String drpOffChgSeq, String arIfNo, String invSrcNo) throws EventException {
		try {
			dbDao.modifyARInterface(bkgNo, cntrNo, drpOffChgSeq, arIfNo, invSrcNo);
		} catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00004").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00004").getUserMessage());	
        }
	}

    /**
     * [AUTH_APRO_RQST_NO]을 [DOD_DRP_OFF_CHG 테이블에 Update]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @param String authAproRqstNo
     * @throws EventException
     */
	public void modifyARInterfaceAuth(String bkgNo, String cntrNo, String drpOffChgSeq, String authAproRqstNo) throws EventException {
		try {
			dbDao.modifyARInterfaceAuth(bkgNo, cntrNo, drpOffChgSeq, authAproRqstNo);
		} catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00004").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00004").getUserMessage());	
        }
	}

    /**
     * [AR Interface 전송 실패한 대상]을 [DOD_DRP_OFF_CHG 테이블에서 Delete]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @throws EventException
     */
	public void deleteDodDrpOffChg(String bkgNo, String cntrNo, String drpOffChgSeq) throws EventException {
		try {
			dbDao.deleteDodDrpOffChg(bkgNo, cntrNo, drpOffChgSeq);
		} catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00005").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DOD00005").getUserMessage());	
        }
	}

    /**
 	 * 해당 Back End Job을 실행시킨다.
 	 * 
 	 * @param SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs
 	 * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
	/*
    public String doBackEndJob(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, SignOnUserAccount account) throws EventException {
    	try {
    		DropOffCreationBackEndJob backEndJob = new DropOffCreationBackEndJob();
	    	BackEndJobManager backEndJobManager = new BackEndJobManager();
	    	
	    	String backendjobId = searchDodDrpOffChgVOs[0].getBackendjobId();
	    	
	    	backEndJob.setJobCommand(backendjobId);
	    	backEndJob.setSearchDodDrpOffChgVOs(searchDodDrpOffChgVOs);
	    	backEndJob.setAccount(account);
	    	
	    	String jobMessage = "DOD " + backendjobId + " Back End";
	    			
	    	return backEndJobManager.execute(backEndJob, account.getUsr_id(), jobMessage);
    	} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"execute DOD_DRP_OFF_CHG save backend job"}).getMessage());
    	}
    }
    */
	/**
	 * 해당 Back End Job의 상태를 리턴한다.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	/*
    public String[] checkBackEndJob(String key) throws EventException {
		DBRowSet rowSet;
		try {
			String[] result = new String[2];
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			
			if(rowSet.next()) {
				//Thread.sleep(1000);
				result[0] = rowSet.getString("jb_sts_flg");
				result[1] = rowSet.getString("jb_usr_err_msg");
			}
			return result;
		} catch(Exception e){
			log.error("[Exception]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{"BackEndJob Status"}).getUserMessage(),e);
		}
    }
    */
    /**
     * [Booking TRO에서 Cancel하면 기 발행한 Invoice에 TTL_AMT를 -하고 TRO_IB_CXL_FLG컬럼을 Y로 업데이트 ]한다.
     * 
     * @param String bkgNo
	 * @param String cntrNo
     * @param String drpOffChgSeq
     * @param String usrId
     * @throws EventException
     */
    public void manageDodDrpOffChgByBookingTRO(String bkgNo, String cntrNo, String usrId) throws EventException {
    	GeneralARInvoiceCreationBC commandAR = new GeneralARInvoiceCreationBCImpl();
    	
    	List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
		SearchDodDrpOffChgVO searchDodDrpOffChgVO = null;
		
		String ar_if_no = "";
		String drpOffChgSeq = "";
		String newDrpOffChgSeq = "";
		
		try {
			// Booking Cancel한 데이터 조회
			searchDodDrpOffChgVO = dbDao.searchDodDrpOffChgVOByBookingTRO(bkgNo, cntrNo);
			drpOffChgSeq = searchDodDrpOffChgVO.getDrpOffChgSeq(); // 기 발행된 Invoice의 Charge Seq
			
			//현재 상태가 BKG TRO 에서 Cancel 한 상태인데,  다시 Cancel 이 들어올때 Return 함
			if(searchDodDrpOffChgVO.getTroIbCxlFlg().equals("Y")) {
				return;
			}
			
			// DOD_DRP_OFF_CHG의 TRO_IB_CXL_FLG컬럼 'Y'로 업데이트
			dbDao.modifyARInterfaceByBookingTRO(bkgNo, cntrNo, searchDodDrpOffChgVO.getDrpOffChgSeq(), "Y");
			
			//drp_off_chg_seq채번
			newDrpOffChgSeq = dbDao.searchDrpOffChgSeq(bkgNo, cntrNo);

			searchDodDrpOffChgVO.setDrpOffChgSeq(newDrpOffChgSeq);
			searchDodDrpOffChgVO.setInvSrcNo(searchDodDrpOffChgVO.getInvSrcNo());
			searchDodDrpOffChgVO.setTroIbCxlFlg("Y");
			searchDodDrpOffChgVO.setCreUsrId(usrId);
			searchDodDrpOffChgVO.setUpdUsrId(usrId);
			searchDodDrpOffChgVO.setTtlAmt(String.valueOf(Double.parseDouble(searchDodDrpOffChgVO.getTtlAmt()) * -1));
			
			dbDao.manageArInvList(searchDodDrpOffChgVO, usrId); // 기 발행된 Invoice의 TTL_AMT를 (-) 처리 한놈
			
			genIfVOs = new ArrayList<ARInterfaceCreationVO>();
			arInterfaceCreationVO = searchARInterfaceInvoice(searchDodDrpOffChgVO);
			
			genIfVOs.add(arInterfaceCreationVO);
			
			//--Start--> AR INTERFACE CALL
			rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
			ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
			// <--End-- AR INTERFACE CALL
			
			if(ar_if_no == null || ar_if_no.equals("")) {
				log.error("\n AR_IF_NO NULL===============>["+arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()+"]");
				dbDao.modifyARInterfaceByBookingTRO(bkgNo, cntrNo, drpOffChgSeq, "N");
				dbDao.deleteDodDrpOffChg(bkgNo, cntrNo, newDrpOffChgSeq);
			}else{
				String ar_if_no_arr[] = ar_if_no.split("::");
				if(ar_if_no_arr[0].equals("S")){
					
					// DOD_DRP_OFF_CHG table update
					modifyARInterface(searchDodDrpOffChgVO.getBkgNo(), searchDodDrpOffChgVO.getCntrNo(), searchDodDrpOffChgVO.getDrpOffChgSeq(), ar_if_no_arr[1], arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo());

					// send ERP
					commandAR.interfaceARInvoiceToERPAR(ar_if_no_arr[1]);
					
				}else{
					log.debug("\n AR_IF_ERROR MSG===============>["+arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()+"]"+ar_if_no_arr[1]);
					dbDao.modifyARInterfaceByBookingTRO(bkgNo, cntrNo, drpOffChgSeq, "N");
					dbDao.deleteDodDrpOffChg(bkgNo, cntrNo, newDrpOffChgSeq);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), ex);
		}
    }
    
	/**
	 * DropOff Invoice Inquiry Detail List
	 * 
	 * @category EES_DOD_0012
	 * @param String
	 * @return List<DropOffDiscountDetailVO>
	 * @throws EventException
	 */
    public List<DropOffDiscountDetailVO> searchDropOffDiscountDetail(String authAproRqstNo) throws EventException {
		try {
			List<DropOffDiscountDetailVO> list = dbDao.searchDropOffDiscountDetail(authAproRqstNo);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
    
    /**
	 * EES_DOD_0001 : [MULTI01]<br>
	 * [Drop Off Charge대상]을 [AR로 보내지 않고 GOASC 오피스만 저장한다]합니다.<br>
	 * 
	 * @param SearchDodDrpOffChgVO[]	searchDodDrpOffChgVOs
	 * @param usrId String 
	 * @return List<SearchDodDrpOffChgVO>
	 * @exception EventException
	 */
	public List<SearchDodDrpOffChgVO> manageRemarkList(SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs, String usrId) throws EventException {
		
		String drpOffChgSeq = "";
		String invSrcNo = "";
		
		List<SearchDodDrpOffChgVO> addVoList = new ArrayList<SearchDodDrpOffChgVO>();
		
		try {
			for(int i = 0; i < searchDodDrpOffChgVOs.length; i ++) {
				//drp_off_chg_seq채번
				drpOffChgSeq = dbDao.searchDrpOffChgSeq(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo());
				//inv_src_no채번
				invSrcNo = dbDao.searchInvSrcNo(searchDodDrpOffChgVOs[i].getTroIbCfmOfcCd());
				
				searchDodDrpOffChgVOs[i].setDrpOffChgSeq(drpOffChgSeq);
				searchDodDrpOffChgVOs[i].setInvSrcNo(invSrcNo);
				searchDodDrpOffChgVOs[i].setCreUsrId(usrId);
				searchDodDrpOffChgVOs[i].setUpdUsrId(usrId);
				searchDodDrpOffChgVOs[i].setDrpOffChgMnlFlg("N");
				searchDodDrpOffChgVOs[i].setSvcFeeAmt("0");
				searchDodDrpOffChgVOs[i].setTroIbCxlFlg("N");
				if(!"".equals(searchDodDrpOffChgVOs[i].getDrpOffChgTrfSpclSeq()) ){
					searchDodDrpOffChgVOs[i].setDrpOffChgTrfSeq("");
					searchDodDrpOffChgVOs[i].setGenTrfAmt("");
				}else{
					searchDodDrpOffChgVOs[i].setDrpOffChgTrfSpclSeq("");
					searchDodDrpOffChgVOs[i].setSpclTrfAmt("");
				}
				dbDao.manageArInvList(searchDodDrpOffChgVOs[i], usrId);
				addVoList.add(searchDodDrpOffChgVOs[i]);
			}
			/*
			if(addVoList.size() > 0) {
				dbDao.manageArInvList(addVoList, usrId);				
			}
			*/
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DOD00002",new String[]{}).getMessage(), ex);
		}
		return addVoList;
	}

}
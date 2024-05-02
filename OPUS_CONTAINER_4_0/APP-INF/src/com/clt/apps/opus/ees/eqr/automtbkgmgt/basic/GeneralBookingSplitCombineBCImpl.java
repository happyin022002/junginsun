/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineBCImpl.java
*@FileTitle : DG Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.15 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration.GeneralBookingSplitCombineDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration.GeneralBookingSplitCombineEAIDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForVslSkdCngNoticeVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CustCdSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.LastSplitNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.ValidateCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - OPUS-GeneralBookingConduct business logic handling.<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0709EventResponse,GeneralBookingSplitCombineBC each DAO class reference
 * @since J2EE 1.6
 */
public class GeneralBookingSplitCombineBCImpl extends BasicCommandSupport implements GeneralBookingSplitCombineBC { 

	// Database Access Object
	private transient GeneralBookingSplitCombineDBDAO dbDao = null;
	private transient GeneralBookingSplitCombineEAIDAO eaiDao = null;

	/**
	 * GeneralBookingSplitCombineBCImpl object creation<br>
	 * GeneralBookingSplitCombineDBDAO creation.<br>
	 */
	public GeneralBookingSplitCombineBCImpl() {
		dbDao = new GeneralBookingSplitCombineDBDAO();
		eaiDao = new GeneralBookingSplitCombineEAIDAO();
	}
	/**
	 * when split dg cargo, reference data retrieve.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<DgSplitVO>
	 * @exception EventException
	 */
	public List<DgSplitVO> searchDgSplit(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchDgSplit(bkgBlNoVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * when split reefer cargo, reference data retrieve.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<RfSplitVO>
	 * @exception EventException
	 */
	public List<RfSplitVO> searchRfSplit (BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchRfSplit(bkgBlNoVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * when split awkward cargo, reference data retrieve.<br>	
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<AkSplitVO>
	 * @exception EventException
	 */
	public List<AkSplitVO> searchAkSplit(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchAkSplit(bkgBlNoVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}

	/**
	 * when split awkward cargo, reference data retrieve.<br>	
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BbSplitVO>
	 * @exception EventException
	 */
	public List<BbSplitVO> searchBbSplit(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchBbSplit(bkgBlNoVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}


	/**
	 * when tro split, reference data retrieve.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroSplitVO>
	 * @exception EventException
	 */
	public List<TroSplitVO> searchTroSplit(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchTroSplit(bkgBlNoVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * when split in booking split screen, reference data retrieve.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @return BkgForSplitVO
	 * @exception EventException
	 */
	public BkgForSplitVO searchBkgForSplit(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException{
		try {
			BkgForSplitVO bkgForSplitVO = new BkgForSplitVO();
			bkgForSplitVO.setBkgBlForSplitVO(dbDao.searchBkgForSplit(bkgBlNoVO));
			bkgForSplitVO.setBkgQuantityVO(dbDao.searchQtyForSplit(bkgBlNoVO));
			bkgForSplitVO.setCntrSpclTroSelectVO(dbDao.searchCntrForSplit(bkgBlNoVO));
			bkgForSplitVO.setSpclSeqForSplitVO(dbDao.searchSpclSeqForSplit(bkgBlNoVO)); 
			if(bkgBlNoVO.getBkgNo().length()==12){
				bkgForSplitVO.setLastSplitNoVO(dbDao.searchLastSplitNo(bkgBlNoVO)); 
			}else{
				BookingUtil util = new BookingUtil();
				LastSplitNoVO lastSplitNoVO = new LastSplitNoVO();
				lastSplitNoVO.setCustsplitno("00");
				lastSplitNoVO.setMemosplitno("91"); 
				
				String ofcCd = util.searchBkgOfcByBkg(bkgBlNoVO);
				lastSplitNoVO.setBkgsplitno(util.manageBkgNumberGeneration("BKG", ofcCd, account.getUsr_id()).getBkgNo());
				
				List<LastSplitNoVO> list = new ArrayList<LastSplitNoVO>();
				list.add(lastSplitNoVO);
				bkgForSplitVO.setLastSplitNoVO(list);
			}
			return bkgForSplitVO;
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Booking Split Validate
	 * 
	 * @param SplitBkgVO splitBkgVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 */
	public String validateSplit(SplitBkgVO splitBkgVO,BkgBlNoVO bkgBlNoVO) throws EventException{

		String rtnFlag=null;
		try {
			BookingUtil util = new BookingUtil();
			rtnFlag = util.searchPoNoLength(bkgBlNoVO);
			if("N".equals(rtnFlag)){
				throw new EventException((String)new ErrorHandler("BKG00081", new String[]{}).getMessage());				
			}
			
//			UtilBc.searchAlertCust(bkgBlNoVO);
			return rtnFlag;

        } catch (EventException ex) {
            throw ex;                 
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Cod split retrieve<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @return CodSplitVO
	 * @exception EventException
	 */
	public CodSplitVO searchCodSplit(BkgBlNoVO bkgBlNoVO,String codRqstSeq,SignOnUserAccount account) throws EventException{
		CodSplitVO codSplitVO = new CodSplitVO();  
		try {
			 codSplitVO.setBkgBlForSplitVO(dbDao.searchBkgForSplit(bkgBlNoVO));
			 codSplitVO.setBkgQuantityVO(dbDao.searchQtyForSplit(bkgBlNoVO));
			 codSplitVO.setCntrSpclTroSelectVO(dbDao.searchCodCntrForSplit(bkgBlNoVO,codRqstSeq));
			 codSplitVO.setCodQtyForSplitVO(dbDao.searchCodQtyForSplit(bkgBlNoVO,codRqstSeq));
			 codSplitVO.setSpclSeqForSplitVO(dbDao.searchSpclSeqForSplit(bkgBlNoVO));
			 if(bkgBlNoVO.getBkgNo().length()==12){
				 codSplitVO.setLastSplitNoVO(dbDao.searchLastSplitNo(bkgBlNoVO)); 
				}else{
					List<LastSplitNoVO> list = new ArrayList<LastSplitNoVO>();
					LastSplitNoVO lastSplitNoVO = new LastSplitNoVO();
					lastSplitNoVO.setCustsplitno("00");
					lastSplitNoVO.setMemosplitno("91"); 
					BookingUtil util = new BookingUtil();
					String ofcCd=util.searchBkgOfcByBkg(bkgBlNoVO);
					lastSplitNoVO.setBkgsplitno(util.manageBkgNumberGeneration("BKG",ofcCd,account.getUsr_id()).getBkgNo());
					list.add(lastSplitNoVO);
					codSplitVO.setLastSplitNoVO(list);
				}
			 String pctlNo = dbDao.searchCodPctlNo(bkgBlNoVO, codRqstSeq);
			 log.debug("cod_split_pctl_no:"+pctlNo);
			 codSplitVO.getBkgBlForSplitVO().get(0).setPctlNo(pctlNo);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return codSplitVO;
	}
	
	 

	/**
	 * using changed VVD,POL, Booking retrieve.
	 * @author	Kim Byung Kyu
	 * @param 	List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs
	 * @exception EventException
	 */
	public void sendVslSkdCngNotice(List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs) throws EventException{
		try {
			for(int icnt=0;icnt<vslSkdCngNoticeVOs.size();icnt++){
				VslSkdCngNoticeVO vslSkdCngNoticeVO = vslSkdCngNoticeVOs.get(icnt);
				
				//vslSkdCngNoticeVO.getTypeCd() : CD01831
				List<BkgListForVslSkdCngNoticeVO> bkgListForVslSkdCngNoticeVOs = dbDao.searchBkgListForVslSkdCngNotice(vslSkdCngNoticeVO);
				if(bkgListForVslSkdCngNoticeVOs != null && bkgListForVslSkdCngNoticeVOs.size() > 0){
					eaiDao.sendVslSkdCngNotice(bkgListForVslSkdCngNoticeVOs);
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);			
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BKG container list retrieve.(ESM_BKG_0732)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<CntrListForCombineVO>
	 * @exception EventException
	 */
	public List<CntrListForCombineVO> searchCntrListForCombine(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchCntrListForCombine(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Combine Booking List retrieve.(ESM_BKG_0974)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO[] bkgBlNoVOs
	 * @return List<BkgListForMstBkgSelectVO>
	 * @exception EventException
	 */
	public List<BkgListForMstBkgSelectVO> searchBkgListForMstBkgSelect(BkgBlNoVO[] bkgBlNoVOs) throws EventException{
		try {
			return dbDao.searchBkgListForMstBkgSelect(bkgBlNoVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Combine  Booking list retrieve. - by Route(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param CombineCommonInputVO combineCommonInputVO
	 * @param CombineByRouteInputVO combineByRouteInputVO
	 * @return List<BkgListForCombineVO>
	 * @exception EventException
	 */
	public List<BkgListForCombineVO> searchBkgListForCombineByRoute(CombineCommonInputVO combineCommonInputVO, CombineByRouteInputVO combineByRouteInputVO) throws EventException{
		try {
			return dbDao.searchBkgListForCombineByRoute(combineCommonInputVO, combineByRouteInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Combine  Booking list retrieve.. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param CombineCommonInputVO combineCommonInputVO
	 * @param CombineByBkgInputVO[] CombineByBkgInputVOs
	 * @return List<BkgListForCombineVO>
	 * @exception EventException
	 */
	public List<BkgListForCombineVO> searchBkgListForCombineByBkg(CombineCommonInputVO combineCommonInputVO, CombineByBkgInputVO[] CombineByBkgInputVOs) throws EventException{
		try {
			return dbDao.searchBkgListForCombineByBkg(combineCommonInputVO, CombineByBkgInputVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Combine Booking Validate check. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return ValidateCombineVO
	 * @exception EventException
	 */
	public ValidateCombineVO validateCombine(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			List<CustCdSeqVO> custCdSeqVO = null;
			ValidateCombineVO validateCombineVO = new ValidateCombineVO();
			String tmpMsg = "";
			String alertMsg = "";
			BookingUtil util = new BookingUtil();

			if ( bkgBlNoVO != null ) {
				custCdSeqVO = dbDao.searchBkgCustForCombine(bkgBlNoVO);
				for (int i=0;i<custCdSeqVO.size();i++) {
					tmpMsg = util.searchAlertCust(custCdSeqVO.get(i).getCustCntCd(), custCdSeqVO.get(i).getCustSeq());
					if(tmpMsg != null && tmpMsg.length() > 0){
						alertMsg = alertMsg + ((String)new ErrorHandler("BKG00055").getMessage());
						alertMsg = alertMsg + tmpMsg;
					}
				}
			}
			validateCombineVO.setAlertMsg(alertMsg);
			return validateCombineVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Empty Booking Split No creation.
	 * 
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   SignOnUserAccount account
	 * @return 	BkgForSplitVO
	 * @exception EventException
	 */
	public BkgBlNoVO searchMtySplitBkgNo(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException{
		BkgBlNoVO splitBkgBlNoVO = new BkgBlNoVO();
		try {
			if(bkgBlNoVO.getBkgNo().length() == 12){
				List<LastSplitNoVO> lastSplitNo = dbDao.searchLastSplitNo(bkgBlNoVO);
				int custSplitNo = Integer.parseInt(lastSplitNo.get(0).getCustsplitno());
				String newCustSplitNo = "";
				if(custSplitNo >= 9){
					newCustSplitNo = bkgBlNoVO.getBkgNo().substring(0,10) + (custSplitNo+1);
				}else{
					newCustSplitNo = bkgBlNoVO.getBkgNo().substring(0,10) + "0" + (custSplitNo+1);
				}
				splitBkgBlNoVO.setBkgNo(newCustSplitNo);
				splitBkgBlNoVO.setBlNo(newCustSplitNo);				
			}else{
				BookingUtil util = new BookingUtil();
				String ofcCd = util.searchBkgOfcByBkg(bkgBlNoVO);
				BkgBlNoVO newBkgBlNoVO = util.manageBkgNumberGeneration("BKG", ofcCd, account.getUsr_id());
				
				splitBkgBlNoVO.setBkgNo(newBkgBlNoVO.getBkgNo()+"01");
				splitBkgBlNoVO.setBlNo(newBkgBlNoVO.getBkgNo()+"01");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return splitBkgBlNoVO;
	}	
	
	/** 
	 * when split, route info retrieve.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	String
	 * @exception 	EventException
	 */
	public String searchNewTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			return dbDao.searchNewTsRoute(bkgBlNoVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param bkgNo
	 * @param tagetBkgNo
	 * @param blSplitNo
	 * @throws EventException
	 */
	@Override
	public void bkgXterRqstMstUpdate(String bkgNo, String tagetBkgNo, String blSplitNo) throws EventException {
		try {
			dbDao.bkgXterRqstMstUpdate(bkgNo, tagetBkgNo, blSplitNo);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
}
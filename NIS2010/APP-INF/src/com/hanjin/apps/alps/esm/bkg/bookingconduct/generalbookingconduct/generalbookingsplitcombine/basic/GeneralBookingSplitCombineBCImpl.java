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
* -------------------------------------------------------
* history
* 2011.06.15 김영철 [CHM-201111434-01] 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
* 2011.06.28 김영철 [] hitchment 인 경우에는 전체 VVD 및 Location, Yard 비교 제외
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2012.05.23 조정민 [CHM-201217938] VSK Coastal SKD과 업데이트와 연동된 BKG 로직 Back End Job전환
* 2013.05.09 최문환 [CHM-201324474] BKG/DOC Module에서의 MT BKG Split 제한 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration.GeneralBookingSplitCombineDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CustCdSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.LastSplitNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.ValidateCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-GeneralBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0709EventResponse,GeneralBookingSplitCombineBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class GeneralBookingSplitCombineBCImpl extends BasicCommandSupport implements GeneralBookingSplitCombineBC {

	// Database Access Object
	private transient GeneralBookingSplitCombineDBDAO dbDao = null;

	/**
	 * GeneralBookingSplitCombineBCImpl 객체 생성<br>
	 * GeneralBookingSplitCombineDBDAO를 생성한다.<br>
	 */
	public GeneralBookingSplitCombineBCImpl() {
		dbDao = new GeneralBookingSplitCombineDBDAO();
	}
	/**
	 * dg cargo split시 참고할 data를 조회한다.<br>
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
	 * reefer cargo split시 참고할 data를 조회한다.<br>
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
	 * awkward cargo split시 참고할 data를 조회한다.<br>
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
	 * break bulk cargo split시 참고할 data를 조회한다.<br>
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
	 * tro split시 참고할 data를 조회한다.<br>
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
	 * booking split 화면에서 split시 참고할 data를 조회한다.<br>
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
			
			if(bkgForSplitVO.getBkgBlForSplitVO() == null || bkgForSplitVO.getBkgBlForSplitVO().size() < 1){
				throw new EventException((String)new ErrorHandler("BKG00889").getMessage());
			}
			if("P".equals(bkgForSplitVO.getBkgBlForSplitVO().get(0).getBkgCgoTpCd())){
				throw new EventException((String)new ErrorHandler("BKG00092").getMessage());
			}
			
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
		} catch(EventException ex) {
			throw ex;
		}catch (DAOException de) {
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
			
			// ALOC_STS_CD Firm 어어야 함
			String alocStsCd = util.searchAlocStsCd(bkgBlNoVO);
			if(alocStsCd != null && "S".equals(alocStsCd)){
				throw new EventException((String)new ErrorHandler("BKG08349", new String[]{}).getMessage());
			}
			
			//추후적용
//			UtilBc.searchAlertCust(bkgBlNoVO);
			return rtnFlag;

        } catch (EventException ex) {
            throw ex;                 
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Cod split를 조회한다<br>
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
	 * 변경된 VVD,POL로 기존에 생성되어 있는 Booking을 조회한다.
	 * @author	Kim Byung Kyu
	 * @param 	List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs
	 * @exception EventException
	 */
	public void sendVslSkdCngNotice(List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs) throws EventException{
        try {
            SendVslSkdCngNoticeBackEndJob SendVslSkdCngNotice = new SendVslSkdCngNoticeBackEndJob();
            BackEndJobManager backEndJobManager = new BackEndJobManager(); // <-- Framework에서 제공하는 back end job manager

            SendVslSkdCngNotice.setVslSkdCngNoticeVOs(vslSkdCngNoticeVOs);
            backEndJobManager.execute(SendVslSkdCngNotice, "SYSTEM", "SendVslSkdCngNoticeBackEndJob"); 
    	} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
    	}
	}

	/**
	 * BKG의 컨테이너 목록을 조회한다.(ESM_BKG_0732)
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
	 * Combine할 Booking List를 조회한다.(ESM_BKG_0974)
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
	 * Combine할 Booking 목록을 조회한다. - by Route(ESM_BKG_0076)
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
	 * Combine할 Booking 목록을 조회한다. - by BKG(ESM_BKG_0076)
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
	 * Combine할 Booking의 Validate을 검사한다. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param sourceBkg
	 * @param bkgBlNoVO
	 * @param hitchmentYn
	 * @return ValidateCombineVO
	 * @exception EventException
	 */
	public ValidateCombineVO validateCombine(BkgBlNoVO[] sourceBkg, BkgBlNoVO bkgBlNoVO, String hitchmentYn) throws EventException{
		try {
			List<CustCdSeqVO> custCdSeqVO = null;
			ValidateCombineVO validateCombineVO = new ValidateCombineVO();
			String tmpMsg = "";
			String alertMsg = "";
			BookingUtil util = new BookingUtil();
			int sourceBkgLen = sourceBkg.length;
			
			if ( !"Y".equals(hitchmentYn)){
				for(int i = 0 ; i < sourceBkgLen ; i++){
					// 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
					if(!"Y".equals(dbDao.searchVvdDiff(sourceBkg[i].getBkgNo(), bkgBlNoVO.getBkgNo()))){
						throw new EventException((String)new ErrorHandler("BKG02084").getMessage());
					}				
				}
			}

			if ( bkgBlNoVO != null ) {
				custCdSeqVO = dbDao.searchBkgCustForCombine(bkgBlNoVO);
				for (int i=0;i<custCdSeqVO.size();i++) {
					tmpMsg = util.searchAlertCust(custCdSeqVO.get(i).getCustCntCd(), custCdSeqVO.get(i).getCustSeq());
					if(tmpMsg != null && tmpMsg.length() > 0){
						// Alert Cust 메지시가 있는 경우 BKG00055 메시지 추가
						alertMsg = alertMsg + ((String)new ErrorHandler("BKG00055").getMessage());
						alertMsg = alertMsg + tmpMsg;
					}
				}
			}
			validateCombineVO.setAlertMsg(alertMsg);
			
			// ALOC_STS_CD 같아야 함
			String mstAlocStsCd = util.searchAlocStsCd(bkgBlNoVO);
			for(int i = 0 ; i < sourceBkgLen ; i++){
				String srcAlocStsCd = util.searchAlocStsCd(sourceBkg[i]);
				if(srcAlocStsCd!=null && mstAlocStsCd!=null && !srcAlocStsCd.equals(mstAlocStsCd)){
					throw new EventException((String)new ErrorHandler("BKG08348").getMessage());
				}				
			}
			
			return validateCombineVO;
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Empty Booking Split번호를 생성한다.
	 * 
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   SignOnUserAccount account
	 * @return 	BkgForSplitVO
	 * @exception EventException
	 */
	public BkgBlNoVO searchMtySplitBkgNo(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException{
		BkgBlNoVO splitBkgBlNoVO = new BkgBlNoVO();
		try {
			// 3. 원본 BkgNo가 12자리인 경우
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
	 * split시 변경된 route의 정보를 조회한다.
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
}
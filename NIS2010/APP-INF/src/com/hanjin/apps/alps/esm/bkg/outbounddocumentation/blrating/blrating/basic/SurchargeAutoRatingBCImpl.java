/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
 * 2013.03.25 김진주 [CHM-201323559] Split 01-BCC Auto-Interface 기능 구현 요청
 * 2013.05.27 김진주 [CHM-201324374] [TMO - Surcharge 종합 시스템 구축 ] Surcharge tariff 오토레이팅 배치 로직 요청
 * 2013.06.24 김진주 [CHM-201325123] BCC Auto-Interface 기능 보완 요청
 * 2013.10.10 김진주 [CHM-201326749] 3rd party office 관련 surcharge 부과 (TPF) auto interface 로직 개발 요청
 * 2015.06.30 이한나 [CHM-201535756] 한국 WHF 면제/조정 기능 간소화 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.math.BigDecimal;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.SurchargeAutoRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgObsSurchargeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgSurchargeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchChgRateByLBPVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchSurchargeAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ThirdPartyOfcByLbpVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgRateVO;

/**
 * NIS2010-SurchargeAutoRating Business Logic Command Interface<br>
 * - NIS2010-SurchargeAutoRating 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_0269EventResponse 참조
 * @since J2EE 1.6
 */

public class SurchargeAutoRatingBCImpl extends BasicCommandSupport implements SurchargeAutoRatingBC{

	// Database Access Object
	private transient SurchargeAutoRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl 객체 생성<br>
	 * BlRatingDBDAO를 생성한다.<br>
	 */
	public SurchargeAutoRatingBCImpl() {
		dbDao = new SurchargeAutoRatingDBDAO();
	}
	
	/**
	 * EsmBkg0269 조회 이벤트 처리<br>
	 * Booking Surcharge AutoRating  화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 각 지역별 특화된 Surcharge (추가[특별] 요금, 할증료, 추징금, 부가금[세] )를 찾아오는 서비스
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchSurchargeAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchSurchargeAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd ,String cmdtCd, String ctrtTpCd) throws EventException {
		try {
			return dbDao.searchSurchargeAutoratingList(bkgNo,caFlag,scpCd, cmdtCd,ctrtTpCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * EsmBkg0400Event Modify 이벤트 처리<br>
	 * O/BL Surrender 처리시 OBS Charge 정보가 존재하는지 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return BkgObsSurchargeRateVO retBkgObsChgVO
	 * @exception EventException
	 */
    public BkgObsSurchargeRateVO searchSurchargeRatingByObs(String bkgNo, SignOnUserAccount account) throws EventException {
    	BkgObsSurchargeRateVO retBkgObsChgVO=null;
    	
    	try {
    		retBkgObsChgVO = dbDao.searchSurchargeRatingByObs(bkgNo, account.getOfc_cd()); //2011.07.01 인자추가(로그인 오피스코드)
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return retBkgObsChgVO;
    }

	/**
	 *  M(Merchant Request)에 의한 CA Issue 시 Surcharge Table의 조건에 따라 BCC 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @return BkgObsSurchargeRateVO retBkgObsChgVO
	 * @exception EventException
	 */
    public BkgSurchargeRateVO searchSurchargeRatingByBcc(String bkgNo, String caFlg, SignOnUserAccount account) throws EventException {
    	BkgSurchargeRateVO retBkgChgVO=null;
    	
    	try {
    		retBkgChgVO = dbDao.searchSurchargeRatingByBcc(bkgNo, caFlg, account.getOfc_cd()); //2011.07.01 인자추가(로그인 오피스코드)
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return retBkgChgVO;
    }
    
    /**
	 * EsmBkg007909Event Modify 이벤트 처리<br>
	 * O/BL Release 처리시 LBP Charge 정보가 존재하는지 체크한다.<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return SearchChgRateByLBPVO searchChgRateByLBPVO
	 * @exception EventException
	 */
    public SearchChgRateByLBPVO searchSurchargeRatingByLbp(String bkgNo, SignOnUserAccount account) throws EventException {
    	SearchChgRateByLBPVO searchChgRateByLBPVO=null;
    	
    	try {
    		searchChgRateByLBPVO = dbDao.searchSurchargeRatingByLbp(bkgNo, account.getOfc_cd());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return searchChgRateByLBPVO;
    }
    
   
    
	/**
	 * EsmBkg0400Event Modify 이벤트 처리<br>
	 * O/BL Surrender 처리시 OBS Charge 정보가 존재할 경우 OBS Charge 항목을 추가한다.<br>
	 * 
	 * @param BkgObsSurchargeRateVO bkgObsSurchargeRateVO
	 * @param SignOnUserAccount account
	 * @return BkgObsChgVO retBkgObsChgVO
	 * @exception EventException
	 */
    public BkgObsSurchargeRateVO manageObsSurchargeRating(BkgObsSurchargeRateVO bkgObsSurchargeRateVO, SignOnUserAccount account) throws EventException {
    	BkgObsSurchargeRateVO retBkgObsChgVO=null;
    	BlRatingDBDAO ratingDAO = new BlRatingDBDAO();
		
    	try {
    		BkgObsSurchargeRateVO bkgObsChgRtVo = dbDao.searchSurchargeRatingByObs(bkgObsSurchargeRateVO.getBkgNo(), account.getOfc_cd()); //2011.07.01 인자추가(로그인 오피스코드)
			if(bkgObsChgRtVo != null){
				bkgObsChgRtVo.setCreUsrId(account.getUsr_id());
				bkgObsChgRtVo.setUpdUsrId(account.getUsr_id());
				bkgObsChgRtVo.setChgCd("OBS");
				
				// OBS Charge 정보가 존재하지 않을 경우만 Insert 함
				if("N".equals(dbDao.checkObsSurchargeRating(bkgObsChgRtVo.getBkgNo()))){
					if( bkgObsChgRtVo.getScgAmt() != null && Integer.parseInt(bkgObsChgRtVo.getScgAmt()) != 0){
						BkgRateVO bkgRateVO = ratingDAO.searchBkgRate(bkgObsChgRtVo.getBkgNo());
						bkgObsChgRtVo.setCltOfcCd(bkgRateVO.getCltOfcCd());
						bkgObsChgRtVo.setPpdOfc(bkgRateVO.getPpdRcvOfcCd());
						
						dbDao.addObsSurchargeRating(bkgObsChgRtVo);
						retBkgObsChgVO = bkgObsChgRtVo;
					}
				}
				
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return retBkgObsChgVO;
    }
    
   
    
	/**
	 * M(Merchant Request)에 의한 CA Issue 시 Surcharge Table의 조건에 따라 BCC 반영 <br>
	 * 
	 * @param BkgSurchargeRateVO bkgSurchargeRateVO
	 * @param SignOnUserAccount account
	 * @return BkgSurchargeRateVO retBkgChgVO
	 * @exception EventException
	 */
    public BkgSurchargeRateVO manageBccSurchargeRating(BkgSurchargeRateVO bkgSurchargeRateVO, SignOnUserAccount account) throws EventException {
    	BkgSurchargeRateVO retBkgChgVO=null;
    	BlRatingDBDAO ratingDAO = new BlRatingDBDAO();
		
    	try {
    		BkgSurchargeRateVO bkgChgRtVo = dbDao.searchSurchargeRatingByBcc(bkgSurchargeRateVO.getBkgNo(), "N", account.getOfc_cd()); //2011.07.01 인자추가(로그인 오피스코드)
			                                 // CA Complete 후 조회하는 것 이기 때문에 caFlg는 N으로 고정
    		if(bkgChgRtVo != null){
				bkgChgRtVo.setCreUsrId(account.getUsr_id());
				bkgChgRtVo.setUpdUsrId(account.getUsr_id());
				bkgChgRtVo.setChgCd("BCC");
				
				if( bkgChgRtVo.getScgAmt() != null && Integer.parseInt(bkgChgRtVo.getScgAmt()) != 0){
					BkgRateVO bkgRateVO = ratingDAO.searchBkgRate(bkgChgRtVo.getBkgNo());
					bkgChgRtVo.setCltOfcCd(bkgRateVO.getCltOfcCd());
					bkgChgRtVo.setPpdOfc(bkgRateVO.getPpdRcvOfcCd());
					
					dbDao.addSurchargeRating(bkgChgRtVo);
					retBkgChgVO = bkgChgRtVo;
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return retBkgChgVO;
    }
    
    /**
	 * EsmBkg007909Event Modify 이벤트 처리<br>
	 * O/BL Release 처리시 LBP Charge 정보가 존재할 경우 LBP Charge 항목을 추가한다.<br>
	 * 
	 * @param SearchChgRateByLBPVO searchChgRateByLBPVO
	 * @param SignOnUserAccount account
	 * @return SearchChgRateByLBPVO retSearchChgRateByLBPVO
	 * @exception EventException
	 */
    public SearchChgRateByLBPVO manageLbpSurchargeRating(SearchChgRateByLBPVO searchChgRateByLBPVO, SignOnUserAccount account) throws EventException {
    	SearchChgRateByLBPVO retSearchChgRateByLBPVO=null;
    	BlRatingDBDAO ratingDAO = new BlRatingDBDAO();
		
    	try {
    		
    		searchChgRateByLBPVO = dbDao.searchSurchargeRatingByLbp(searchChgRateByLBPVO.getBkgNo(), account.getOfc_cd());
    		
    		searchChgRateByLBPVO.setLoginOffice(account.getOfc_cd());
    		searchChgRateByLBPVO.setCreUsrId(account.getUsr_id());
    		searchChgRateByLBPVO.setUpdUsrId(account.getUsr_id());
    		searchChgRateByLBPVO.setChgCd("LBP");
    		
    		
		    BkgRateVO bkgRateVO = ratingDAO.searchBkgRate(searchChgRateByLBPVO.getBkgNo());
			searchChgRateByLBPVO.setCltOffice(bkgRateVO.getCltOfcCd());
			searchChgRateByLBPVO.setPpdOffice(bkgRateVO.getPpdRcvOfcCd());
			
			ThirdPartyOfcByLbpVO thirdPartyOfcByLbpVO = dbDao.searchThirdPartyOfcByLbp(searchChgRateByLBPVO.getBkgNo(),searchChgRateByLBPVO.getLoginOffice());
			//3rd Party : Login OFC가 SELBB, PUSBS 일 경우 PPD OFC와 비교해서 적용 2012.01.20 조원주
			
			if(thirdPartyOfcByLbpVO == null){
				searchChgRateByLBPVO.setThirdPartyOfc(""); 
				searchChgRateByLBPVO.setRepCustCntCd("");
				searchChgRateByLBPVO.setRepCustSeq("");
				searchChgRateByLBPVO.setFrtTermCd(searchChgRateByLBPVO.getFrtTermCd());
			}else{
			searchChgRateByLBPVO.setThirdPartyOfc(thirdPartyOfcByLbpVO.getThirdPartyOfc()); 
			searchChgRateByLBPVO.setRepCustCntCd(thirdPartyOfcByLbpVO.getRepCustCntCd());
			searchChgRateByLBPVO.setRepCustSeq(thirdPartyOfcByLbpVO.getRepCustSeq());
			searchChgRateByLBPVO.setFrtTermCd(searchChgRateByLBPVO.getFrtTermCd());
			}
			
				dbDao.addLbpSurchargeRating(searchChgRateByLBPVO);
				retSearchChgRateByLBPVO = searchChgRateByLBPVO;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return retSearchChgRateByLBPVO;
    }
    
    /**
	 * EsmBkg007909Event  이벤트 처리<br>
	 * LBP Surcharge 정보에 해당하는 Third Party Office 정보를 구한다.<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return ThirdPartyOfcByLbpVO thirdPartyOfcByLbpVO
	 * @exception EventException
	 */
    public ThirdPartyOfcByLbpVO searchThirdPartyOfcByLbp(String bkgNo, SignOnUserAccount account) throws EventException{
    	   ThirdPartyOfcByLbpVO thirdPartyOfcByLbpVO=null;
    	
    	try {
    		thirdPartyOfcByLbpVO = dbDao.searchThirdPartyOfcByLbp(bkgNo, account.getOfc_cd());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return thirdPartyOfcByLbpVO;
    }
    /**
	 * EsmBkg007908Event  이벤트 처리<br>
	 * TPF Surcharge 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlag
	 * @return BkgChgRateVO bkgChgRateVO
	 * @exception EventException
	 */
    public BkgChgRateVO searchTPFSurcharge(String bkgNo, String caFlag) throws EventException{
        BkgChgRateVO bkgChgRateVO = null;
        
        try {
        	bkgChgRateVO = dbDao.searchTPFSurcharge(bkgNo, caFlag);
        	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return bkgChgRateVO;
    }
    
    /**
     * Korae WHF 금액 조정
     * @param List<BkgChgRateVO> listVO
     * @throws EventException
     */
    public void modifyWhfChgRate(List<BkgChgRateVO> listVO) throws EventException{
		try{
			dbDao.modifyWhfChgRate(listVO);
			 
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	 }
}
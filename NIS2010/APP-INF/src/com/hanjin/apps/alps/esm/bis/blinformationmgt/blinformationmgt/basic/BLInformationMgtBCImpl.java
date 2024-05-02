/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtBCImpl.java
*@FileTitle : C/A Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.14 강동윤
* 1.0 Creation
* History
* 2012.08.22 김기택 [CHM-201219155-01j] B/L Preview 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration.BLInformationMgtDBDAO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisManualListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisMonitorListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaBkgInfoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaChargeVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaCustVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaDetailVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaGeneralVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaInfoByBkgVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaListByBkgVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportInVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportOutVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtInVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtOutVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-BLInformationMgt Business Logic Command Interface<br>
 * - ALPS-BLInformationMgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kang dong yun
 * @see Ui_bkg-0079-04EventResponse 참조
 * @since J2EE 1.6
 */
public class BLInformationMgtBCImpl extends BasicCommandSupport implements BLInformationMgtBC {

	// Database Access Object
	private transient BLInformationMgtDBDAO dbDao = null;

	/**
	 * BLInformationMgtBCImpl 객체 생성<br>
	 * BLInformationMgtDBDAO를 생성한다.<br>
	 */
	public BLInformationMgtBCImpl() {
		dbDao = new BLInformationMgtDBDAO();
	}


	/**
	 * C/A Summary Report 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */
	public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws EventException {

		try {
			return dbDao.searchCaSummaryReport(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * C/A Summary Report BL List 결과를 조회한다. (ESM_BKG_0174)<br>
	 * 
	 * @param CaSummaryReportInVO vo
	 * @return List<CaSummaryReportOutVO>
	 * @throws EventException
	 */
	public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws EventException {

		try {			
			return dbDao.searchCaSummaryReportBLList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

    /**
     * 조회 이벤트 처리
     *  MultiCombo 조회 이벤트 처리 ESM_BKG_0278
     *
     * @param bkgComboVO
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws EventException {
        try {
            return dbDao.searchSRouteFromList(bkgComboVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리
     *  ESM_BKG_0280화면에 대한 조회 이벤트 처리
     *
     * @param grpBlPrtInVO
     * @return GrpBlPrtOutVO
     * @exception EventException
     */
    public GrpBlPrtOutVO searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws EventException {
        //컨테이너 vo
        GrpBlPrtOutVO grpBlPrtOutVO = new GrpBlPrtOutVO();
        try {
            List<GrpBlPrtVO> grpBlPrt = dbDao.searchBkgListForGrpBlPr(grpBlPrtInVO);

            // 컨테이너vo에 담는다.
            grpBlPrtOutVO.setGrpBlPrts(grpBlPrt);

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
        }
        return grpBlPrtOutVO;
    }
        
    /**
     * bkg별 기본 정보와 C/A 변경 list를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaInfoByBkgVO 
     * @exception EventException
     */
    public CaInfoByBkgVO searchCaInfoByBkg(BkgBlNoVO bkgBlNoVO) throws EventException { 
    	try {
    		CaInfoByBkgVO caInfoByBkgVO = new CaInfoByBkgVO();
    		
    		CaBkgInfoVO         caBkgInfoVO    = dbDao.searchCaBkgInfo  (bkgBlNoVO); 
    		if (caBkgInfoVO != null) {
    			bkgBlNoVO.setBkgNo(caBkgInfoVO.getBkgNo());
    			bkgBlNoVO.setBlNo (caBkgInfoVO.getBlNo());
    			bkgBlNoVO.setCaNo (caBkgInfoVO.getCaNo());
    		}
    		List<CaListByBkgVO> caListByBkgVOs = dbDao.searchCaListByBkg(bkgBlNoVO); 
    		
    		caInfoByBkgVO.setCaBkgInfoVO   (caBkgInfoVO);
    		caInfoByBkgVO.setCaListByBkgVOs(caListByBkgVOs);
    	
    		return caInfoByBkgVO;
    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
    }

    /**
     *  C/A 변경 건 별 상세 정보를 조회한다.<br>
     * @author Lee NamKyung 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return CaDetailVO 
     * @exception EventException
     */
    public CaDetailVO searchCaDetail(BkgBlNoVO bkgBlNoVO) throws EventException { 
    	try {
    		CaDetailVO caDetailVO = new CaDetailVO();
    		
    		List<CaGeneralVO>   caGeneralVOs = dbDao.searchCaGeneral(bkgBlNoVO); 
    		List<CaChargeVO>    caChargeVOs  = dbDao.searchCaCharge (bkgBlNoVO); 
    		List<CaCustVO>      caCustVOs    = dbDao.searchCaCust   (bkgBlNoVO); 
    		
    		caDetailVO.setCaGeneralVOs(caGeneralVOs);
    		caDetailVO.setCaChargeVOs (caChargeVOs);
    		caDetailVO.setCaCustVOs   (caCustVOs);
    	
    		return caDetailVO;
    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}	
    }
    /**
     *  BIS MonitorList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @return List<BisMonitorListVO>  
     * @exception EventException
     */
    public List<BisMonitorListVO> searchBisMonitorList(String fromDt,String toDt) throws EventException{
    	try{
    		return dbDao.searhMonitorList(fromDt, toDt);	
    	}catch(DAOException ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}catch(Exception ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}
    }
    
    /**
     *  BIS MonitorList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @return List<BisMonitorListVO>  
     * @exception EventException
     */
    public List<BisManualListVO> searchBisManualList(String fromDt,String toDt) throws EventException{
    	try{
    		return dbDao.searchBisManualList(fromDt, toDt);	
    	}catch(DAOException ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}catch(Exception ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}
    }
    
    /**
     *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0000)<br>
     * @author KIM TAE KYOUNG 
     * @param  BisManualListVO bisManualListVO
     * @exception EventException
     */
    public void manageBisBkgManual(BisManualListVO bisManualListVO) throws EventException{
    	try{
    		dbDao.manageBisBkgManual(bisManualListVO);
    		dbDao.manageBisBkgHisManual(bisManualListVO);
    		dbDao.manageBkgBisFlg(bisManualListVO);
    	}catch(DAOException ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}catch(Exception ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}
    }

	/**
     *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0000)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @exception EventException
     */
    public void manageBisManual(String fromDt,String toDt) throws EventException{
    	try{
    		dbDao.manageBisManual(fromDt, toDt);	
    	}catch(DAOException ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}catch(Exception ex){
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
    	}
    }  
    
    /**
     * 조회 이벤트 처리
     *  Rider 여부판단 ESM_BIS_0927
     *
     * @param String bkg_no
     * @param String hiddenData
     * @param String rate
     * @param String cntr
     * @param String corr_no
     * @return String
     * @exception EventException
     */
    public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws EventException {
        try {
            return dbDao.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 조회 이벤트 처리
     *  HouseB/L 여부판단 ESM_BIS_0927
     *
     * @param bkg_no
     * @return String
     * @exception EventException
     */
    public String searchHouseBlYn(String bkg_no) throws EventException {
        try {
            return dbDao.searchHouseBlYn(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BIS_0927<br>
     *
     * @param String bkg_no
     * @return String
     * @exception EventException
     */
    public String searchOblIssFlg(String bkg_no) throws EventException {
        try {
            return dbDao.searchOblIssFlg(bkg_no);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
}
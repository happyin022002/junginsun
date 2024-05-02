/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtBCImpl.java
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration.DemDetTariffMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffMonitorVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffNotiListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSL01VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSL02VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLMapSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent02VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent03VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent04VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent05VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent06VO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentMapSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchUserRoleInfoListVO; 
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffCombinationVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRegionVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.DmtUsrRoleMtchVO;

/**
 * alps-DMTMasterDataMgt Business Logic Basic Command implementation<br>
 * - alps-DMTMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Tae Kyun
 * @see EesDmt1003EventResponse,EesDmt1004EventResponse,EesDmt1001EventResponse,DemDetTariffMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DemDetTariffMgtBCImpl extends BasicCommandSupport implements DemDetTariffMgtBC {

	// Database Access Object
	private transient DemDetTariffMgtDBDAO dbDao = null;
	
	/**
	 * DemDetTariffMgtBCImpl 객체 생성<br>
	 * DemDetTariffMgtDBDAO를 생성한다.<br>
	 */
	public DemDetTariffMgtBCImpl() {
		dbDao = new DemDetTariffMgtDBDAO();
	}
	/**
	 * [BasicTariffSummryList]를 [search]합니다.<br>
	 * 
	 * @param SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO
	 * @return List<SearchBasicTariffSummaryListVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffSummaryListVO> searchBasicTariffSummuryList(SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO) throws EventException {
		try {
			return dbDao.searchBasicTariffSummuryList(searchBasicTariffSummaryParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	/**
	 * [Basic Tariff Detail(s)]를 [search]합니다.<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchContinentVO>
	 * @exception EventException
	 */
	public List<SearchContinentVO> searchBasicTariffDetailList(SearchContinentParamVO searchContinentParamVO) throws EventException {
		try {
			return dbDao.searchBasicTariffDetailList(searchContinentParamVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	
    /**
     * [Basic Tariff Detail(s)]를 [search]합니다.<br>
     * 
     * @param SearchContinentParamVO searchContinentParamVO
     * @return List<SearchContinentVO>
     * @exception EventException
     */
    public List<SearchContinentVO> searchBasicTariffDetailList02 ( SearchContinentParamVO searchContinentParamVO ) throws EventException {
        
        try {
            
            List<SearchContinentVO> rtnLst   = new ArrayList<SearchContinentVO>();
            List<SearchContinent02VO> list02 = null;
            list02 = dbDao.searchBasicTariffDetailList02(searchContinentParamVO);
            SearchContinentVO vo = null;

            int x = 0; // return vo row count
            for( int i02 = 0 ; i02 < list02.size(); i02++){
                
                SearchContinent02VO vos = new SearchContinent02VO();
                vos  = (SearchContinent02VO)list02.get(i02);
                
                String tVal01 = vos.getDmdtTrfCd();
                String tVal02 = vos.getCovrg();
                String tVal03 = vos.getOrgDest();
                String tVal04 = vos.getTrfGrpSeq();
                String tVal05 = vos.getEffDt();
                String tVal06 = vos.getDmdtDeTermCd();
                
                log.debug("\n ####### searchBasicTariffDetailList02 tVal01 [" + tVal01 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal02 [" + tVal02 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal03 [" + tVal03 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal04 [" + tVal04 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal05 [" + tVal05 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal06 [" + tVal06 + "] \n" 
                         );

                SearchContinentMapSetVO list = dbDao.searchBasicTariffDetailList03( tVal01 , tVal02 , tVal03 , tVal04 , tVal05 , tVal06, searchContinentParamVO ); // Map Set VO            

                List<SearchContinent03VO> list03 = list.getSearchContinent03VO(); // CNTR & Cargo
                List<SearchContinent04VO> list04 = list.getSearchContinent04VO(); // F/T Commence & Exclusion
                List<SearchContinent05VO> list05 = list.getSearchContinent05VO(); // Free Time
                List<SearchContinent06VO> list06 = list.getSearchContinent06VO(); // Rate per Day
                
                int tManLgh = list03.size();
                if ( tManLgh < list04.size() ) { tManLgh = list04.size(); }
                if ( tManLgh < list05.size() ) { tManLgh = list05.size(); }
                if ( tManLgh < list06.size() ) { tManLgh = list06.size(); }
                
                log.debug("\n ####### searchBasicTariffDetailList02 list03.size() [" + list03.size() + "] " +
                          "\n ####### searchBasicTariffDetailList02 list04.size() [" + list04.size() + "] " +
                          "\n ####### searchBasicTariffDetailList02 list05.size() [" + list05.size() + "] " +
                          "\n ####### searchBasicTariffDetailList02 list06.size() [" + list06.size() + "] " +
                          "\n ####### searchBasicTariffDetailList02 tManLgh       [" + tManLgh       + "] \n" 
                         );

//                String tCNTR = "";
//                String tCARGO = "";
//                String tFTC = "";
//                String tSTA = "";
//                String tSUN = "";
//                String tHOL = "";
//                String tFT = "";
//                String tFD = "";
                
                for ( int i18 = 0 ; i18 < tManLgh ; i18++ ) {
                    
                    log.debug("\n ############## xtc x ["+x+"] start");
                    vo = new SearchContinentVO();
                    String tGrpNm = vos.getDmdtBzcTrfGrpNm ();
                    
                    // basic tariff group info set
                    vo.setDmdtTrfCd       ( vos.getDmdtTrfCd       () );
                    vo.setCovrg           ( vos.getCovrg           () );
                    vo.setOrgDest         ( vos.getOrgDest         () );
                    vo.setTrfGrpSeq       ( vos.getTrfGrpSeq       () );
                    vo.setDmdtDeTermCd    ( vos.getDmdtDeTermCd    () );
                    vo.setDmdtDeTermNm    ( vos.getDmdtDeTermNm    () );
                    vo.setDmdtBzcTrfGrpNm ( vos.getDmdtBzcTrfGrpNm () );
                    vo.setEffDt           ( vos.getEffDt           () );
                    vo.setExpDt           ( vos.getExpDt           () );
                    
                    // CNTR & Cargo info set

                    if ( i18 < list03.size() ) {
                        log.debug("\n ####### xtc list03 ["+i18+"] true");
                        vo.setDmdtCntrTpCd ( list03.get(i18).getDmdtCntrTpCd () );
                        vo.setDmdtCgoTpCd  ( list03.get(i18).getDmdtCgoTpCd  () );
//                        tCNTR  = list03.get(i18).getDmdtCntrTpCd ();
//                        tCARGO = list03.get(i18).getDmdtCgoTpCd  ();
                    } else {
                        log.debug("\n ####### xtc list03 ["+i18+"] false");
                        vo.setDmdtCntrTpCd ( ""  );
                        vo.setDmdtCgoTpCd  ( "" );
                    }
                    
                    // F/T Commence & Exclusion info set

                    if ( i18 < list04.size() ) {
                        log.debug("\n ####### xtc list04 ["+i18+"] true");
                        if ( tGrpNm.equals("Exempted") ) {
                            vo.setDmdtChgCmncTpCd ( "-" );
                            vo.setXcldSatFlg      ( "-" );
                            vo.setXcldSunFlg      ( "-" );
                            vo.setXcldHolFlg      ( "-" );                            
                        } else {
                            vo.setDmdtChgCmncTpCd ( list04.get(i18).getDmdtChgCmncTpCd () );                            
                            vo.setXcldSatFlg      ( list04.get(i18).getXcldSatFlg      () );
                            vo.setXcldSunFlg      ( list04.get(i18).getXcldSunFlg      () );
                            vo.setXcldHolFlg      ( list04.get(i18).getXcldHolFlg      () );
                        }
                        vo.setWknd1           ( list04.get(i18).getWknd1           () );
                        vo.setWknd2           ( list04.get(i18).getWknd2           () );
//                        tFTC = list04.get(i18).getDmdtChgCmncTpCd ();
//                        tSTA = list04.get(i18).getXcldSatFlg      ();
//                        tSUN = list04.get(i18).getXcldSunFlg      ();
//                        tHOL = list04.get(i18).getXcldHolFlg      ();
                    } else {
                        log.debug("\n ####### xtc list04 ["+i18+"] false");
                        vo.setDmdtChgCmncTpCd ( "" );
                        vo.setXcldSatFlg      ( "" );
                        vo.setXcldSunFlg      ( "" );
                        vo.setXcldHolFlg      ( "" );
                        vo.setWknd1           ( "" );
                        vo.setWknd2           ( "" );
                    }
                    
                    // Free Time info set

                    if ( i18 < list05.size() ) {
                        log.debug("\n ####### xtc list05 ["+i18+"] true");
                        if ( tGrpNm.equals("Exempted") ) {
                            vo.setFreeTime ( "-" );
                            vo.setFtDys    ( "-" );
                        } else {
                            vo.setFreeTime ( list05.get(i18).getFreeTime() );
                            vo.setFtDys    ( list05.get(i18).getFtDys   () );
                        }
//                        tFT = list05.get(i18).getFreeTime();
//                        tFD = list05.get(i18).getFtDys   ();
                    } else {
                        log.debug("\n ####### xtc list05 ["+i18+"] false");
                        vo.setFreeTime ( "" );
                        vo.setFtDys    ( "" );
                    }
                    
                    // Rate per Day info set
                    if ( i18 < list06.size() ) {
                        log.debug("\n ####### xtc list06 ["+i18+"] true");
                        if ( i18 == 0 ) {
                            if ( tGrpNm.equals("Exempted") ) {
                                vo.setCurrCd        ( "-" );
                            } else {
                                vo.setCurrCd        ( list06.get(i18).getCurrCd        () );
                            }
                        } else {
                            vo.setCurrCd        ( "" );
                        }
                        if ( tGrpNm.equals("Exempted") ) {
                            vo.setOverDay       ( "-" );
                            vo.setCntr20ftRtAmt ( "-" );
                            vo.setCntr40ftRtAmt ( "-" );
                            vo.setCntrHcRtAmt   ( "-" );
                            vo.setCntr45ftRtAmt ( "-" );
                            vo.setCntrR9RtAmt   ( "-" );
                        } else {
                            vo.setOverDay       ( list06.get(i18).getOverDay       () );
                            vo.setCntr20ftRtAmt ( list06.get(i18).getCntr20ftRtAmt () );
                            vo.setCntr40ftRtAmt ( list06.get(i18).getCntr40ftRtAmt () );
                            vo.setCntrHcRtAmt   ( list06.get(i18).getCntrHcRtAmt   () );
                            vo.setCntr45ftRtAmt ( list06.get(i18).getCntr45ftRtAmt () );
                            vo.setCntrR9RtAmt   ( list06.get(i18).getCntrR9RtAmt   () );
                        }
                    } else {
                        log.debug("\n ####### xtc list06 ["+i18+"] false");
                        vo.setCurrCd        ( "" );
                        vo.setOverDay       ( "" );
                        vo.setCntr20ftRtAmt ( "" );
                        vo.setCntr40ftRtAmt ( "" );
                        vo.setCntrHcRtAmt   ( "" );
                        vo.setCntr45ftRtAmt ( "" );
                        vo.setCntrR9RtAmt   ( "" );
                    }
                    
                    log.debug("\n ############## xtc x ["+x+"] end");
                    // set add return list vo
                    rtnLst.add(x, vo);
                    x++;
                    
                } // end for for ( int i18 = 0 ; i18 < tManLgh ; i18++ ) {
                
            } // end for for( int i02 = 0 ; i02 < list02.size(); i02++){

            return rtnLst;
        } catch (DAOException ex) {
            log.error(ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
    }
	
	/**
	 * [BasicTariff]를 [search]합니다.<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @exception EventException
	 */
	public List<BasicTariffVO> searchBasicTariff(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
		try {
			return dbDao.searchBasicTariff(dmtTariffTypeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	
    /**
     * [BasicTariff]를 [search]합니다.<br>
     * 
     * @param DmtTariffTypeVO dmtTariffTypeVO
     * @return List<SearchContinentVO>
     * @exception EventException
     */
    public List<SearchContinentVO> searchBasicTariffXSL(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
        try {

            List<SearchContinentVO> rtnLst   = new ArrayList<SearchContinentVO>();
            List<SearchBasicTariffXSLVO> list02 = null;
            list02 = dbDao.searchBasicTariffXSL(dmtTariffTypeVO);
            SearchContinentVO vo = null;
            StringBuffer logStr = new StringBuffer(1000);
            
            int x = 0; // return vo row count
            for( int i02 = 0 ; i02 < list02.size(); i02++){
                
                SearchBasicTariffXSLVO vos = new SearchBasicTariffXSLVO();
                vos  = (SearchBasicTariffXSLVO)list02.get(i02);
                
                String tVal01 = vos.getSvrId();
                String tVal02 = vos.getDmdtTrfCd();
                String tVal03 = vos.getTrfSeq();
                String tVal04 = vos.getTrfGrpSeq();
                
                log.debug("\n ####### searchBasicTariffxsl tVal01 [" + tVal01 + "] " +
                          "\n ####### searchBasicTariffxsl tVal02 [" + tVal02 + "] " +
                          "\n ####### searchBasicTariffxsl tVal03 [" + tVal03 + "] " +
                          "\n ####### searchBasicTariffxsl tVal04 [" + tVal04 + "] \n" 
                         );
                
                SearchBasicTariffXSLMapSetVO list = dbDao.searchBasicTariffXSL02( tVal01 , tVal02 , tVal03 , tVal04 , dmtTariffTypeVO ); // Map Set VO            

                List<SearchBasicTariffXSL01VO>       list03 = list.getSearchBasicTariffXSL01VO      (); // CNTR & Cargo
                List<SearchBasicTariffXSL02VO>       list04 = list.getSearchBasicTariffXSL02VO      (); // F/T Commence & Exclusion
                List<SearchBasicTariffXSLFreeTimeVO> list05 = list.getSearchBasicTariffXSLFreeTimeVO(); // Free Time
                List<SearchBasicTariffXSLRateVO>     list06 = list.getSearchBasicTariffXSLRateVO    (); // Rate per Day
                
                int tManLgh = list03.size();
                if ( tManLgh < list04.size() ) { tManLgh = list04.size(); }
                if ( tManLgh < list05.size() ) { tManLgh = list05.size(); }
                if ( tManLgh < list06.size() ) { tManLgh = list06.size(); }
                
                log.debug("\n ####### searchBasicTariffxsl list03.size() [" + list03.size() + "] " +
                          "\n ####### searchBasicTariffxsl list04.size() [" + list04.size() + "] " +
                          "\n ####### searchBasicTariffxsl list05.size() [" + list05.size() + "] " +
                          "\n ####### searchBasicTariffxsl list06.size() [" + list06.size() + "] " +
                          "\n ####### searchBasicTariffxsl tManLgh       [" + tManLgh       + "] \n" 
                         );
                
                for ( int i18 = 0 ; i18 < tManLgh ; i18++ ) {
                    
                    logStr.append("\n ############## xtc x ["+x+"] start");
                    vo = new SearchContinentVO();
                    String tGrpNm = vos.getDmdtBzcTrfGrpNm ();
                    String tCurCd = vos.getCurrCd();
                    
                    // basic tariff group info set
                    vo.setDmdtTrfCd       ( vos.getDmdtTrfCd       () );
                    vo.setCovrg           ( vos.getCovrg           () );
                    vo.setOrgDest         ( vos.getOrgDest         () );
                    vo.setDmdtDeTermNm    ( vos.getDmdtDeTermNm    () );
                    vo.setTrfGrpSeq       ( vos.getTrfGrpSeq       () );
                    vo.setDmdtBzcTrfGrpNm ( vos.getDmdtBzcTrfGrpNm () );
                    vo.setEffDt           ( vos.getEffDt           () );
                    vo.setExpDt           ( vos.getExpDt           () );
                    
                    // CNTR & Cargo info set

                    if ( i18 < list03.size() ) {
                        logStr.append("\n ####### xtc list03 ["+i18+"] true");
                        vo.setDmdtCntrTpCd ( list03.get(i18).getDmdtCntrTpNm() );
                        vo.setDmdtCgoTpCd  ( list03.get(i18).getDmdtCgoTpNm () );
                    } else {
                        logStr.append("\n ####### xtc list03 ["+i18+"] false");
                        vo.setDmdtCntrTpCd ( ""  );
                        vo.setDmdtCgoTpCd  ( "" );
                    }
                    
                    // F/T Commence & Exclusion info set

                    if ( i18 < list04.size() ) {
                        logStr.append("\n ####### xtc list04 ["+i18+"] true");
                        if ( tGrpNm.equals("Exempted") ) {
                            vo.setDmdtChgCmncTpCd ( "-" );
                            vo.setXcldSatFlg      ( "-" );
                            vo.setXcldSunFlg      ( "-" );
                            vo.setXcldHolFlg      ( "-" );                            
                        } else {
                            vo.setDmdtChgCmncTpCd ( list04.get(i18).getDmdtChgCmncTpNm () );                            
                            vo.setXcldSatFlg      ( list04.get(i18).getXcldSatFlg () );
                            vo.setXcldSunFlg      ( list04.get(i18).getXcldSunFlg () );
                            vo.setXcldHolFlg      ( list04.get(i18).getXcldHolFlg () );
                        }
                        vo.setWknd1           ( list04.get(i18).getWknd1 () );
                        vo.setWknd2           ( list04.get(i18).getWknd2 () );
                    } else {
                        logStr.append("\n ####### xtc list04 ["+i18+"] false");
                        vo.setDmdtChgCmncTpCd ( "" );
                        vo.setXcldSatFlg      ( "" );
                        vo.setXcldSunFlg      ( "" );
                        vo.setXcldHolFlg      ( "" );
                        vo.setWknd1           ( "" );
                        vo.setWknd2           ( "" );
                    }
                    
                    // Free Time info set

                    if ( i18 < list05.size() ) {
                        logStr.append("\n ####### xtc list05 ["+i18+"] true");
                        if ( tGrpNm.equals("Exempted") ) {
                            vo.setFreeTime ( "-" );
                            vo.setFtDys    ( "-" );
                        } else {
                            vo.setFreeTime ( list05.get(i18).getFreeTime() );
                            vo.setFtDys    ( list05.get(i18).getFtDys   () );
                        }
                    } else {
                        logStr.append("\n ####### xtc list05 ["+i18+"] false");
                        vo.setFreeTime ( "" );
                        vo.setFtDys    ( "" );
                    }
                    
                    // Rate per Day info set
                    if ( i18 < list06.size() ) {
                        logStr.append("\n ####### xtc list06 ["+i18+"] true");
                        if ( i18 == 0 ) {
                            if ( tGrpNm.equals("Exempted") ) {
                                vo.setCurrCd        ( "-" );
                            } else {
                                vo.setCurrCd        ( tCurCd );
                            }
                        } else {
                            vo.setCurrCd        ( "" );
                        }
                        if ( tGrpNm.equals("Exempted") ) {
                            vo.setOverDay       ( "-" );
                            vo.setCntr20ftRtAmt ( "-" );
                            vo.setCntr40ftRtAmt ( "-" );
                            vo.setCntrHcRtAmt   ( "-" );
                            vo.setCntr45ftRtAmt ( "-" );
                            vo.setCntrR9RtAmt	( "-" );
                        } else {
                            vo.setOverDay       ( list06.get(i18).getOverDay       () );
                            vo.setCntr20ftRtAmt ( list06.get(i18).getCntr20ftRtAmt () );
                            vo.setCntr40ftRtAmt ( list06.get(i18).getCntr40ftRtAmt () );
                            vo.setCntrHcRtAmt   ( list06.get(i18).getCntrHcRtAmt   () );
                            vo.setCntr45ftRtAmt ( list06.get(i18).getCntr45ftRtAmt () );
                            vo.setCntrR9RtAmt	( list06.get(i18).getCntrR9RtAmt   () );
                        }
                    } else {
                        logStr.append("\n ####### xtc list06 ["+i18+"] false");
                        vo.setCurrCd        ( "" );
                        vo.setOverDay       ( "" );
                        vo.setCntr20ftRtAmt ( "" );
                        vo.setCntr40ftRtAmt ( "" );
                        vo.setCntrHcRtAmt   ( "" );
                        vo.setCntr45ftRtAmt ( "" );
                        vo.setCntrR9RtAmt   ( "" );
                    }
                    logStr.append("\n ############## xtc x ["+x+"] end");
                    log.debug(logStr.toString());
                    // set add return list vo
                    rtnLst.add(x, vo);
                    x++;
                    
                } // end for for ( int i18 = 0 ; i18 < tManLgh ; i18++ ) {
                
            } // END OF FOR for( int i02 = 0 ; i02 < list02.size(); i02++){
            
            return rtnLst;
            
        } catch (DAOException ex) {
            log.error(ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
    }

	/**
	 * [BasicTariffFreeTime]을 [search]합니다.<br>
	 *  
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffFreeTimesVO>
	 * @exception EventException
	 */
	public List<TariffFreeTimeVO> searchBasicTariffFreeTime(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
		try {
			return dbDao.searchBasicTariffFreeTime(dmtTariffTypeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	/**
	 * [BasicTariffRate]를 [search]합니다.<br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffRateVO>
	 * @exception EventException
	 */
	public List<TariffRateVO> searchBasicTariffRate(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
		try {
			return dbDao.searchBasicTariffRate(dmtTariffTypeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		} 
	}
	/**
	 * [BasicTariff]를 [confirm]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmBasicTariff(BasicTariffVO basicTariffVO) throws EventException {
		try {
			dbDao.confirmTariffGroup(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
		
	}

	/**
	 * [BasicTariff]를 [confirmCancel]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmCancelBasicTariff(BasicTariffVO basicTariffVO) throws EventException {
		try {
			dbDao.confirmCancelTariffGroup(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	
	/**
	 * [BasicTariff]를 [confirmRgn]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmRgnBasicTariff(BasicTariffVO basicTariffVO) throws EventException {
		try {
			dbDao.confirmTariffRegion(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	
	/**
	 * [BasicTariff]를 [confirmCancelRgn]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void confirmCancelRgnBasicTariff(BasicTariffVO basicTariffVO) throws EventException {
		try {
			dbDao.confirmCancelTariffRegion(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	
	/**
	 * [BasicTariff]를 [remove]합니다.<br>
	 * @param BasicTariffVO[] basicTariffVOs
	 * @throws EventException
	 */
	public void removeBasicTariff(BasicTariffVO[] basicTariffVOs) throws EventException {
		log.debug("bc removeBasicTariff()");
		
		BasicTariffVO basicTariffVO = new BasicTariffVO();

		try {
			if( basicTariffVOs.length > 0) {
				basicTariffVO = basicTariffVOs[0];
				
				//CMB 삭제
				TariffCombinationVO tariffCombinationVO = new TariffCombinationVO();
				tariffCombinationVO.setSvrId(basicTariffVO.getSvrId());
				tariffCombinationVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
				tariffCombinationVO.setTrfSeq(basicTariffVO.getTrfSeq());
				tariffCombinationVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
				tariffCombinationVO.setTrfGrpSeq(basicTariffVO.getTrfGrpSeq());
				dbDao.removeTariffCombination(tariffCombinationVO);
				
				//FREE_TM 삭제
				TariffFreeTimeVO tariffFreeTimeVO = new TariffFreeTimeVO();
				tariffFreeTimeVO.setSvrId(basicTariffVO.getSvrId());
				tariffFreeTimeVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
				tariffFreeTimeVO.setTrfSeq(basicTariffVO.getTrfSeq());
				tariffFreeTimeVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
				tariffFreeTimeVO.setTrfGrpSeq(basicTariffVO.getTrfGrpSeq());
				tariffFreeTimeVO.setTrfFtSeq("");
				dbDao.removeTariffFreeTime(tariffFreeTimeVO);
				
				//RT 삭제
				TariffRateVO tariffRateVO = new TariffRateVO();
				tariffRateVO.setSvrId(basicTariffVO.getSvrId());
				tariffRateVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
				tariffRateVO.setTrfSeq(basicTariffVO.getTrfSeq());
				tariffRateVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
				tariffRateVO.setTrfGrpSeq(basicTariffVO.getTrfGrpSeq());
				tariffRateVO.setTrfRtSeq("");
				dbDao.removeTariffRate(tariffRateVO);
				
				//Grp 삭제
				dbDao.removeTariffGroup(basicTariffVO);
				
				//RGN 삭제 체크 로직
				//1. GRP가 존재하는가?
				String grp_yn = dbDao.searchGrpYNByRgn(basicTariffVO);
				//2. CMDT_GRP가 존재하는가?
				String cmdt_yn = dbDao.searchCmdtYNByRgn(basicTariffVO);
				
				if(grp_yn.equals("N") && cmdt_yn.equals("N")) {
					//RGN 삭제
					dbDao.removeTariffRegion(basicTariffVO);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}

	/**
	 * [TrfRgnCfmHis]를 [add]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void addTrfRgnCfmHis(BasicTariffVO basicTariffVO) throws EventException{
		try {
			dbDao.addTrfRgnCfmHis(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}	

	/**
	 * [TrfGrpCfmHis]를 [add]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws EventException
	 */
	public void addTrfGrpCfmHis(BasicTariffVO basicTariffVO) throws EventException{
		try {
			dbDao.addTrfGrpCfmHis(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}	
	
	/**
	 * [DMT_TRF_RGN_CFM_HIS의 RGN_CFM_SEQ의 max값]를 [search]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return int
	 * @throws EventException
	 */
	public int searchTrfRgnCfmSeq(BasicTariffVO basicTariffVO) throws EventException{
		try {
			return dbDao.searchTrfRgnCfmSeq(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	
	/**
	 * [국가별 WeekEnd]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchWeekEnd(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
		try {
			return dbDao.searchWeekEnd(dmtTariffTypeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
		
	}
	
	/**
	 * [CombinationSet]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
		try {
			return dbDao.searchCombinationSet(dmtTariffTypeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	
	/**
	 * [Update CombinationSet]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchUpdateCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws EventException {
		try {
			return dbDao.searchUpdateCombinationSet(dmtTariffTypeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}	
	
	/**
	 * [Tariff Combination]를 [search]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<BasicTariffVO>
	 * @throws EventException
	 */
	public List<BasicTariffVO> searchTariffCombination(BasicTariffVO basicTariffVO) throws EventException {
		try {
			return dbDao.searchTariffCombination(basicTariffVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}

	/**
	 * [DmtTrfGrp]를 [search]합니다.<br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<TariffGroupVO>
	 * @throws EventException
	 */
	public List<TariffGroupVO> searchDmtTrfGrp(BasicTariffVO basicTariffVO) throws EventException{
		try {
			return dbDao.searchDmtTrfGrp(basicTariffVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	
	/**
	 * [BasicTariff]를 [create]합니다.<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException{
		String 	sResult = "";
		String 	svr_id = "";
		int 	trf_seq = 0;
		String	dmdt_de_term_cd = "";
		int 	trf_grp_seq = 0;
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		TariffRegionVO tariffRegionVO = new TariffRegionVO();
		List<BasicTariffVO> checkBasicTariffVOList	= null;
		BasicTariffVO checkBasicTariffVO = new BasicTariffVO();
		
		try {
			if(tariffMgtVO == null) throw new Exception("");
			
			//Tariff Group 객체 List
			TariffGroupVO tariffGroupVO 					= tariffMgtVO.getTariffGroupVO();
			DmtTariffTypeVO dmtTariffTypeVO 				= tariffMgtVO.getDmtTariffTypeVO();
			List<TariffCombinationVO> tariffCombinationVOs 	= tariffMgtVO.getTariffCombinationVOs();
			List<TariffFreeTimeVO> tariffFreeTimeVOs 		= tariffMgtVO.getTariffFreeTimeVOs();
			List<TariffRateVO> tariffRateVOs 				= tariffMgtVO.getTariffRateVOs();
			
			dmdt_de_term_cd = tariffGroupVO.getDmdtDeTermCd();
			
			//
//			String bound 	= dmtTariffTypeVO.getDmdtTrfCd().substring(2, 3);
//			String calcTpCd = dmtTariffTypeVO.getDmdtTrfCd().substring(0, 1);
//			
//			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
//			calcVO.setDmdtCalcTpCd(calcTpCd);
//			calcVO.setIoBndCd(bound);
//			calcVO.setCntCd(dmtTariffTypeVO.getCvrgCntCd());
//			calcVO.setRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
//			calcVO.setSteCd(dmtTariffTypeVO.getCvrgSteCd());
//			calcVO.setLocCd(dmtTariffTypeVO.getCvrgLocCd());
//			
////log.debug("------------------------------------------");
////log.debug(dmtTariffTypeVO.getCvrgCntCd());
////log.debug(dmtTariffTypeVO.getCvrgRgnCd());
////log.debug(dmtTariffTypeVO.getCvrgSteCd());
////log.debug(dmtTariffTypeVO.getCvrgLocCd());
////log.debug("------------------------------------------");
//			
//			
//			//심천(4014)인 경우 체크로직 제외
//			if(dmtTariffTypeVO.getUiCode().equals("1001")) {
//				//1. checkCalcType
//				boolean checkCalc = dbDaoCheck.checkCalcType(calcVO);
//				if(!checkCalc) {
//					sResult = "Calculation Type unmatch";
//					return sResult;
//					//throw new EventException("Calculation Type unmatch");//DMT06011
//				}
//			}
			
			
//			int iEffDt = 0;
//			int iExpDt = 0;
//			
//			if(checkBasicTariffVOList != null) {
//				for(int i = 0 ; i < checkBasicTariffVOList.size() ; i++){
//					checkBasicTariffVO = (BasicTariffVO)checkBasicTariffVOList.get(i);
//					
//					if(checkBasicTariffVO.getExpDt().equals(" "))	continue;
//					
//					iEffDt = Integer.parseInt(JSPUtil.replace(tariffGroupVO.getEffDt(), "-", ""));
//					iExpDt = Integer.parseInt(JSPUtil.replace(checkBasicTariffVO.getExpDt(), "-", ""));
//					
//					if(iExpDt >= iEffDt ) {
//						sResult = "Date Duplicated! Please check To Tariff!\n"+
//								  "CNTR-Cargo Type ["+checkBasicTariffVO.getDmdtCntrTpNm()+"-"+checkBasicTariffVO.getDmdtCgoTpNm()+"]\n"+
//								  "Effective Date ["+checkBasicTariffVO.getEffDt()+"]\n"+
//								  "Expiration Date ["+checkBasicTariffVO.getExpDt()+"]";
//						return sResult;
//
//					}
//					
//				}
//			}
			
			//1-2. eff_date check logic 추가
			dmtTariffTypeVO.setAllFlg("Y");
			int iEffDt = 0;
			int iExpDt = 0;
			
			//1-2. combination eff_date check logic
			for(int i = 0 ; i < tariffCombinationVOs.size() ; i++ ) {
				TariffCombinationVO tariffCombinationVO = (TariffCombinationVO)tariffCombinationVOs.get(i);
				dmtTariffTypeVO.setDmdtCntrTpCd(tariffCombinationVO.getDmdtCntrTpCd());
				dmtTariffTypeVO.setDmdtCgoTpCd(tariffCombinationVO.getDmdtCgoTpCd());
				
				checkBasicTariffVOList = dbDao.searchBasicTariff(dmtTariffTypeVO);
				iEffDt = 0;
				iExpDt = 0;
				
				if(checkBasicTariffVOList != null) {
					//이전에 생성된 값과 비교하기 위해 조회한다.
					for(int j = 0 ; j < checkBasicTariffVOList.size() ; j++){
						checkBasicTariffVO = (BasicTariffVO)checkBasicTariffVOList.get(j);
						
						if(checkBasicTariffVO.getExpDt().equals(" "))	continue;
						
						iEffDt = Integer.parseInt(JSPUtil.replace(tariffGroupVO.getEffDt(), "-", ""));
						iExpDt = Integer.parseInt(JSPUtil.replace(checkBasicTariffVO.getExpDt(), "-", ""));
						
						if(iExpDt >= iEffDt ) {
//							sResult = "Date Duplicated! Please check To Tariff!\n"+
//							  "CNTR-Cargo Type ["+checkBasicTariffVO.getDmdtCntrTpNm()+"-"+checkBasicTariffVO.getDmdtCgoTpNm()+"]\n"+
//							  "Effective Date ["+checkBasicTariffVO.getEffDt()+"]\n"+
//							  "Expiration Date ["+checkBasicTariffVO.getExpDt()+"]";
							
							sResult = new ErrorHandler("DMT06027").getUserMessage();
							sResult = JSPUtil.replace(sResult, "XXXXXXXX", checkBasicTariffVO.getDmdtCntrTpNm());
							sResult = JSPUtil.replace(sResult, "YYYYYYYY", checkBasicTariffVO.getDmdtCgoTpNm());
							sResult = JSPUtil.replace(sResult, "EFFYYYYMMDD", checkBasicTariffVO.getEffDt());
							sResult = JSPUtil.replace(sResult, "EXPYYYYMMDD", checkBasicTariffVO.getExpDt());
							
							return sResult;
						}
					}
				}
			}
			
			
			//2. svr_id 조회
			svr_id = dbDao.searchComNisSvrId(dmtTariffTypeVO.getCntCd());
			
			if(svr_id == null || svr_id.equals("")) 
				throw new Exception("");
			
			//3. search TrfRgn
			int count = dbDao.searchTariffRegionCount(dmtTariffTypeVO);
			
			dmtTariffTypeVO.setSvrId(svr_id);

			//4. max trf_region sequence
			basicTariffVO.setSvrId(svr_id);
			basicTariffVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
			basicTariffVO.setDmdtDeTermCd(dmdt_de_term_cd);
			
			if(count == 0) {
				
				trf_seq = dbDao.searchTrfRgnSequence(basicTariffVO);	
				
				trf_seq = trf_seq + 1;
				
				tariffRegionVO.setSvrId(svr_id);
				tariffRegionVO.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
				tariffRegionVO.setTrfSeq(String.valueOf(trf_seq));
				tariffRegionVO.setCvrgContiCd(dmtTariffTypeVO.getCvrgContiCd());
				tariffRegionVO.setCvrgCntCd(dmtTariffTypeVO.getCvrgCntCd());
				tariffRegionVO.setCvrgRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
				tariffRegionVO.setCvrgSteCd(dmtTariffTypeVO.getCvrgSteCd());
				tariffRegionVO.setCvrgLocCd(dmtTariffTypeVO.getCvrgLocCd());
				tariffRegionVO.setCvrgYdCd(dmtTariffTypeVO.getCvrgYdCd());
				tariffRegionVO.setOrgDestContiCd(dmtTariffTypeVO.getOrgDestContiCd());
				tariffRegionVO.setOrgDestCntCd(dmtTariffTypeVO.getOrgDestCntCd());
				tariffRegionVO.setOrgDestRgnCd(dmtTariffTypeVO.getOrgDestRgnCd());
				tariffRegionVO.setOrgDestSteCd(dmtTariffTypeVO.getOrgDestSteCd());
				tariffRegionVO.setOrgDestLocCd(dmtTariffTypeVO.getOrgDestLocCd());
				tariffRegionVO.setCurrCd(tariffGroupVO.getCurrCd());
				tariffRegionVO.setOfcCd(account.getOfc_cd());
				tariffRegionVO.setUsrId(account.getUsr_id());
				tariffRegionVO.setUiCode(dmtTariffTypeVO.getUiCode());	//심천 구분(1001:N, 4014:Y)
				
				//5. Triff Region Creation.
				dbDao.addDmtTrfRgn(tariffRegionVO);
				
				log.debug("====> addDmtTrfRgn");

				trf_grp_seq = 1;
			}else {
				
				//4. max sequence
				trf_seq = dbDao.searchTrfRgnMaxSequence(dmtTariffTypeVO);
				
				log.debug("====> searchTrfRgnMaxSequence");			

				log.debug("--------------start-------------");
				//1. Tariff Region Confirm Cancel
				basicTariffVO.setUsrId(account.getUsr_id());
				basicTariffVO.setOfcCd(account.getOfc_cd());
				basicTariffVO.setTrfSeq(String.valueOf(trf_seq));
				dbDao.confirmCancelTariffRegion(basicTariffVO);
				
				log.debug("--------------1-------------");								
				//2. Tariff Region History Insert
				basicTariffVO.setCrntCfmFlg("N");
				dbDao.addTrfRgnCfmHis(basicTariffVO);
				
				basicTariffVO.setTrfSeq(String.valueOf(trf_seq));
				
				//6. max trf_group sequece
				trf_grp_seq = dbDao.searchTrfGrpSequence(basicTariffVO);

				log.debug("====> searchTrfGrpSequence");

				trf_grp_seq = trf_grp_seq + 1;
			}
			
			if(tariffGroupVO.getXcldHolFlg().equals("")) {
				tariffGroupVO.setXcldHolFlg("N");
			}
			if(tariffGroupVO.getXcldSatFlg().equals("")) {
				tariffGroupVO.setXcldSatFlg("N");
			}
			if(tariffGroupVO.getXcldSunFlg().equals("")) {
				tariffGroupVO.setXcldSunFlg("N");
			}
			
			tariffGroupVO.setSvrId(svr_id);
			tariffGroupVO.setTrfSeq(String.valueOf(trf_seq));
			tariffGroupVO.setTrfGrpSeq(String.valueOf(trf_grp_seq));
			tariffGroupVO.setUsrId(account.getUsr_id());
			tariffGroupVO.setOfcCd(account.getOfc_cd());

			
			
			//6. Triff Group Creation.
			dbDao.addDmtTrfGrp(tariffGroupVO);
			
			log.debug("====> addDmtTrfGrp");
			
			for(int i = 0 ; i < tariffCombinationVOs.size() ; i++ ) {
				TariffCombinationVO tariffCombinationVO = (TariffCombinationVO)tariffCombinationVOs.get(i);
				
				tariffCombinationVO.setTrfSeq(String.valueOf(trf_seq));
				tariffCombinationVO.setDmdtDeTermCd(dmdt_de_term_cd);
				tariffCombinationVO.setTrfGrpSeq(String.valueOf(trf_grp_seq));
				tariffCombinationVO.setUsrId(account.getUsr_id());
				tariffCombinationVO.setOfcCd(account.getOfc_cd());

				if(tariffCombinationVO.getIbflag().equals("U")) {
					tariffCombinationVO.setSvrId(svr_id);
					tariffCombinationVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
					// 7. Tariff Group Combination Creation
					dbDao.addDmtTrfCmb(tariffCombinationVO);
					log.debug("====> addDmtTrfCmb");
				}
			}
			
			
			if(tariffFreeTimeVOs != null) {
log.debug("tariffFreeTimeVOs.size()...................."+tariffFreeTimeVOs.size());
				for(int i = 0 ; i < tariffFreeTimeVOs.size(); i++) {
					TariffFreeTimeVO tariffFreeTimeVO = (TariffFreeTimeVO)tariffFreeTimeVOs.get(i);
					
					tariffFreeTimeVO.setTrfSeq(String.valueOf(trf_seq));
					tariffFreeTimeVO.setDmdtDeTermCd(dmdt_de_term_cd);
					tariffFreeTimeVO.setTrfGrpSeq(String.valueOf(trf_grp_seq));
					tariffFreeTimeVO.setUsrId(account.getUsr_id());
					tariffFreeTimeVO.setOfcCd(account.getOfc_cd());
					
log.debug("tariffFreeTimeVO.getIbflag()...................."+tariffFreeTimeVO.getIbflag());
log.debug("tariffFreeTimeVO.getTrfSeq()...................."+tariffFreeTimeVO.getTrfSeq());
log.debug("tariffFreeTimeVO.getTrfGrpSeq()...................."+tariffFreeTimeVO.getTrfGrpSeq());
					//if(tariffFreeTimeVO.getIbflag().equals("I")) {
						tariffFreeTimeVO.setSvrId(svr_id);
						tariffFreeTimeVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
						//8. Tariff Free Time Creation
						dbDao.addDmtTrfFreeTm(tariffFreeTimeVO);
						
						log.debug("====> addDmtTrfFreeTm");
						
					//}
				}
			}
			
			if(tariffRateVOs != null) {
log.debug("tariffRateVOs.size()...................."+tariffRateVOs.size());
				
				for(int i = 0 ; i < tariffRateVOs.size(); i++) {
					TariffRateVO tariffRateVO = (TariffRateVO)tariffRateVOs.get(i);
					tariffRateVO.setTrfSeq(String.valueOf(trf_seq));
					tariffRateVO.setDmdtDeTermCd(dmdt_de_term_cd);
					tariffRateVO.setTrfGrpSeq(String.valueOf(trf_grp_seq));
					tariffRateVO.setUsrId(account.getUsr_id());
					tariffRateVO.setOfcCd(account.getOfc_cd());
log.debug("tariffRateVO.getIbflag()...................."+tariffRateVO.getIbflag());
log.debug("tariffRateVO.getTrfSeq()...................."+tariffRateVO.getTrfSeq());
log.debug("tariffRateVO.getTrfGrpSeq()...................."+tariffRateVO.getTrfGrpSeq());
					
					//if(tariffRateVO.getIbflag().equals("I")) {
						tariffRateVO.setSvrId(svr_id);
						tariffRateVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
						//8. Tariff Free Rate Creation
						dbDao.addDmtTrfRt(tariffRateVO);

						log.debug("====> addDmtTrfRt");
						//}
				}
			}
			sResult = "OK";
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}	
		return sResult;
		
	}

	/**
	 * [BasicTariff]를 [modify]합니다.<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String modifyBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException {
		String sResult = "";
		List<BasicTariffVO> checkBasicTariffVOList	= null;
		BasicTariffVO checkBasicTariffVO = new BasicTariffVO();
		log.debug("............start modify................");
		
		String svr_id 			= "";
		String dmdt_trf_cd 		= "";
		String trf_seq 			= "";
		String dmdt_de_term_cd 	= "";
		String trf_grp_seq 		= "";

		try {
			if(tariffMgtVO == null) throw new Exception("");
			
			//Tariff Group 객체 List
			TariffGroupVO tariffGroupVO 					= tariffMgtVO.getTariffGroupVO();
			DmtTariffTypeVO dmtTariffTypeVO 				= tariffMgtVO.getDmtTariffTypeVO();
			List<TariffCombinationVO> tariffCombinationVOs 	= tariffMgtVO.getTariffCombinationVOs();
			List<TariffFreeTimeVO> tariffFreeTimeVOs 		= tariffMgtVO.getTariffFreeTimeVOs();
			List<TariffRateVO> tariffRateVOs 				= tariffMgtVO.getTariffRateVOs();
			
			//키값을 조회한다.
			svr_id = tariffGroupVO.getSvrId();
			dmdt_trf_cd = tariffGroupVO.getDmdtTrfCd();
			trf_seq = tariffGroupVO.getTrfSeq();
			dmdt_de_term_cd = tariffGroupVO.getDmdtDeTermCd();
			trf_grp_seq = tariffGroupVO.getTrfGrpSeq();
			
			if(tariffGroupVO.getXcldHolFlg().equals("")) {
				tariffGroupVO.setXcldHolFlg("N");
			}
			if(tariffGroupVO.getXcldSatFlg().equals("")) {
				tariffGroupVO.setXcldSatFlg("N");
			}
			if(tariffGroupVO.getXcldSunFlg().equals("")) {
				tariffGroupVO.setXcldSunFlg("N");
			}
			tariffGroupVO.setUsrId(account.getUsr_id());
			tariffGroupVO.setOfcCd(account.getOfc_cd());
			
			//1-2. eff_date check logic 추가
			dmtTariffTypeVO.setAllFlg("Y");
			int iEffDt = 0;
			int iExpDt = 0;
			
			//1-2. combination eff_date check logic
			for(int i = 0 ; i < tariffCombinationVOs.size() ; i++ ) {
				TariffCombinationVO tariffCombinationVO = (TariffCombinationVO)tariffCombinationVOs.get(i);
				dmtTariffTypeVO.setDmdtCntrTpCd(tariffCombinationVO.getDmdtCntrTpCd());
				dmtTariffTypeVO.setDmdtCgoTpCd(tariffCombinationVO.getDmdtCgoTpCd());
				
				checkBasicTariffVOList = dbDao.searchBasicTariff(dmtTariffTypeVO);
				iEffDt = 0;
				iExpDt = 0;
				
				if(checkBasicTariffVOList != null) {
					//이전에 생성된 값과 비교하기 위해 조회한다.
					for(int j = 0 ; j < checkBasicTariffVOList.size() ; j++){
						checkBasicTariffVO = (BasicTariffVO)checkBasicTariffVOList.get(j);
						
						if(checkBasicTariffVO.getExpDt().equals(" "))	continue;
						
						if( !checkBasicTariffVO.getSvrId().equals(dmtTariffTypeVO.getSvrId())
						 && !checkBasicTariffVO.getTrfSeq().equals(dmtTariffTypeVO.getTrfSeq())
						 && !checkBasicTariffVO.getTrfGrpSeq().equals(dmtTariffTypeVO.getTrfGrpSeq())
								) {
							iEffDt = Integer.parseInt(JSPUtil.replace(tariffGroupVO.getEffDt(), "-", ""));
							iExpDt = Integer.parseInt(JSPUtil.replace(checkBasicTariffVO.getExpDt(), "-", ""));
							
							if(iExpDt >= iEffDt ) {
								sResult = new ErrorHandler("DMT06027").getUserMessage();
								sResult = JSPUtil.replace(sResult, "XXXXXXXX", checkBasicTariffVO.getDmdtCntrTpNm());
								sResult = JSPUtil.replace(sResult, "YYYYYYYY", checkBasicTariffVO.getDmdtCgoTpNm());
								sResult = JSPUtil.replace(sResult, "EFFYYYYMMDD", checkBasicTariffVO.getEffDt());
								sResult = JSPUtil.replace(sResult, "EXPYYYYMMDD", checkBasicTariffVO.getExpDt());
								return sResult;
							}
						}
					}
				}
			}
			
			dbDao.modifyTariffGroup(tariffGroupVO);
			
			if(tariffCombinationVOs != null) {
				//전체를 삭제한다.
				TariffCombinationVO tariffCombinationVO = new TariffCombinationVO();
				
				tariffCombinationVO.setSvrId(svr_id);
				tariffCombinationVO.setDmdtTrfCd(dmdt_trf_cd);
				tariffCombinationVO.setTrfSeq(trf_seq);
				tariffCombinationVO.setDmdtDeTermCd(dmdt_de_term_cd);
				tariffCombinationVO.setTrfGrpSeq(trf_grp_seq);
				
				dbDao.removeTariffCombination(tariffCombinationVO);
				
				//신규를 생성한다.
				
				//2. Tariff Group Combination process
				for(int i = 0 ; i < tariffCombinationVOs.size() ; i++ ) {
					log.debug("............2................");
					tariffCombinationVO = (TariffCombinationVO)tariffCombinationVOs.get(i);
					
					tariffCombinationVO.setSvrId(svr_id);
					tariffCombinationVO.setDmdtTrfCd(dmdt_trf_cd);
					tariffCombinationVO.setTrfSeq(trf_seq);
					tariffCombinationVO.setDmdtDeTermCd(dmdt_de_term_cd);
					tariffCombinationVO.setTrfGrpSeq(trf_grp_seq);
					tariffCombinationVO.setUsrId(account.getUsr_id());
					tariffCombinationVO.setOfcCd(account.getOfc_cd());
	
					dbDao.addDmtTrfCmb(tariffCombinationVO);
					log.debug("\n............2-1................");
				}
			}
			
			if(tariffFreeTimeVOs != null) {
				log.debug("............3................");
				TariffFreeTimeVO tariffFreeTimeVO = new TariffFreeTimeVO();
				//Group Seq 전체 삭제한다.
				tariffFreeTimeVO.setSvrId(tariffGroupVO.getSvrId());
				tariffFreeTimeVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
				tariffFreeTimeVO.setTrfSeq(tariffGroupVO.getTrfSeq());
				tariffFreeTimeVO.setDmdtDeTermCd(tariffGroupVO.getDmdtDeTermCd());
				tariffFreeTimeVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
				
				dbDao.removeTariffFreeTime(tariffFreeTimeVO);
				
				//3. Tariff Free Time process
				for(int i = 0 ; i < tariffFreeTimeVOs.size(); i++) {
					tariffFreeTimeVO = (TariffFreeTimeVO)tariffFreeTimeVOs.get(i);
					
					tariffFreeTimeVO.setSvrId(tariffGroupVO.getSvrId());
					tariffFreeTimeVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
					tariffFreeTimeVO.setTrfSeq(tariffGroupVO.getTrfSeq());
					tariffFreeTimeVO.setDmdtDeTermCd(tariffGroupVO.getDmdtDeTermCd());
					tariffFreeTimeVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
					tariffFreeTimeVO.setUsrId(account.getUsr_id());
					tariffFreeTimeVO.setOfcCd(account.getOfc_cd());
					
					dbDao.addDmtTrfFreeTm(tariffFreeTimeVO);
				}
			}
			
			if(tariffRateVOs != null) {
				log.debug("............4................");
				TariffRateVO tariffRateVO = new TariffRateVO();
				//Group Seq 전체 삭제한다.
				tariffRateVO.setSvrId(tariffGroupVO.getSvrId());
				tariffRateVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
				tariffRateVO.setTrfSeq(tariffGroupVO.getTrfSeq());
				tariffRateVO.setDmdtDeTermCd(tariffGroupVO.getDmdtDeTermCd());
				tariffRateVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
				
				dbDao.removeTariffRate(tariffRateVO);

				//4. Tariff Rate process
				for(int i = 0 ; i < tariffRateVOs.size(); i++) {
					tariffRateVO = (TariffRateVO)tariffRateVOs.get(i);
					
					tariffRateVO.setSvrId(tariffGroupVO.getSvrId());
					tariffRateVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
					tariffRateVO.setTrfSeq(tariffGroupVO.getTrfSeq());
					tariffRateVO.setDmdtDeTermCd(tariffGroupVO.getDmdtDeTermCd());
					tariffRateVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
					tariffRateVO.setUsrId(account.getUsr_id());
					tariffRateVO.setOfcCd(account.getOfc_cd());
					
					dbDao.addDmtTrfRt(tariffRateVO);
				}
			}
			sResult = "OK";
			
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}	
		return sResult;
				
	}
	
	/**
	 * [BasicTariff]를 [Expire]합니다.<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBasicTariffExpire(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException {
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		try {
			if(tariffMgtVO == null) throw new Exception("");
			
			//Tariff Group 객체 List
			TariffGroupVO tariffGroupVO = tariffMgtVO.getTariffGroupVO();
			DmtTariffTypeVO dmtTariffTypeVO = tariffMgtVO.getDmtTariffTypeVO();
			
			
			if(tariffGroupVO.getXcldHolFlg().equals("")) {
				tariffGroupVO.setXcldHolFlg("N");
			}
			if(tariffGroupVO.getXcldSatFlg().equals("")) {
				tariffGroupVO.setXcldSatFlg("N");
			}
			if(tariffGroupVO.getXcldSunFlg().equals("")) {
				tariffGroupVO.setXcldSunFlg("N");
			}
log.debug("--------------start-------------");
			//1. Tariff Region Confirm Cancel
			basicTariffVO.setSvrId(dmtTariffTypeVO.getSvrId());
			basicTariffVO.setUsrId(account.getUsr_id());
			basicTariffVO.setOfcCd(account.getOfc_cd());
			basicTariffVO.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
			basicTariffVO.setTrfSeq(dmtTariffTypeVO.getTrfSeq());
			dbDao.confirmCancelTariffRegion(basicTariffVO);
log.debug("--------------1-------------");
				
			//2. Tariff Region History Insert
			basicTariffVO.setCrntCfmFlg("N");
			dbDao.addTrfRgnCfmHis(basicTariffVO);
log.debug("--------------2-------------");
				
			//3. Tariff Group ExpDt Update
			tariffGroupVO.setUsrId(account.getUsr_id());
			tariffGroupVO.setOfcCd(account.getOfc_cd());
			dbDao.modifyTariffGroup(tariffGroupVO);
log.debug("--------------3-------------");
				
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}
	}
	/**
	 * [BasicTariff]를 [copy]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @param ToDmtTariffTypeVO toDmtTariffTypeVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String copyBasicTariff(DmtTariffTypeVO dmtTariffTypeVO, ToDmtTariffTypeVO toDmtTariffTypeVO, SignOnUserAccount account) throws EventException {
		String sResult = "";
		int trfSeq = 0;
		int trfGrpSeq = 0;
		TariffRegionVO toTariffRegionVO 	= new TariffRegionVO();		//To TariffRegion
		BasicTariffVO toBasicTariffVO 		= new BasicTariffVO();		//To TariffGroup 조회용
		BasicTariffVO basicTariffVO 		= new BasicTariffVO();		//From TariffGroup 조회용
		List<BasicTariffVO> fromBasicTariffVOList	= null;				//From BasicTariff
		List<BasicTariffVO> toBasicTariffVOList		= null;
		TariffGroupVO tariffGroupVO 		= new TariffGroupVO();
		TariffCombinationVO combinationVO	= new TariffCombinationVO();
		TariffFreeTimeVO freeTimeVO			= new TariffFreeTimeVO();
		TariffRateVO rateVO					= new TariffRateVO();
		String fromTrfSeq = "";
		String fromDmdtDeTermCd = "";
		String fromTrfGrpSeq = "";
		String svr_id = "";
		
		try {
			if(dmtTariffTypeVO == null) throw new Exception("");
			
			//------------- From Tariff Mode Checking
			fromBasicTariffVOList = dbDao.searchBasicTariff(dmtTariffTypeVO);
			
log.debug("\n fromBasicTariffVOList size-------------------->"+fromBasicTariffVOList.size());

			//------------- To Tariff Empty Checking
			DmtTariffTypeVO dmtTariffTypeVO2 = new DmtTariffTypeVO();
			dmtTariffTypeVO2.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
			dmtTariffTypeVO2.setCvrgContiCd(toDmtTariffTypeVO.getToCvrgContiCd());
			dmtTariffTypeVO2.setCvrgCntCd(toDmtTariffTypeVO.getToCvrgCntCd());
			dmtTariffTypeVO2.setCvrgRgnCd(toDmtTariffTypeVO.getToCvrgRgnCd());
			dmtTariffTypeVO2.setCvrgSteCd(toDmtTariffTypeVO.getToCvrgSteCd());
			dmtTariffTypeVO2.setCvrgLocCd(toDmtTariffTypeVO.getToCvrgLocCd());
			dmtTariffTypeVO2.setCvrgYdCd(toDmtTariffTypeVO.getToCvrgYdCd());
			dmtTariffTypeVO2.setDmdtDeTermCd(toDmtTariffTypeVO.getToDmdtDeTermCd());
			dmtTariffTypeVO2.setOrgDestContiCd(toDmtTariffTypeVO.getToOrgDestContiCd());
			dmtTariffTypeVO2.setOrgDestCntCd(toDmtTariffTypeVO.getToOrgDestCntCd());
			dmtTariffTypeVO2.setOrgDestRgnCd(toDmtTariffTypeVO.getToOrgDestRgnCd());
			dmtTariffTypeVO2.setOrgDestSteCd(toDmtTariffTypeVO.getToOrgDestSteCd());
			dmtTariffTypeVO2.setOrgDestLocCd(toDmtTariffTypeVO.getToOrgDestLocCd());
			dmtTariffTypeVO2.setCntCd(toDmtTariffTypeVO.getToCvrgCntCd());
			dmtTariffTypeVO2.setAllFlg("Y");
			dmtTariffTypeVO2.setUiCode(dmtTariffTypeVO.getUiCode());	//심천 구분용

			toBasicTariffVOList = dbDao.searchBasicTariff(dmtTariffTypeVO2);
			
log.debug("\n toBasicTariffVOList size-------------------->"+toBasicTariffVOList.size());
			int toTariffCheck 	= 0; 
			int expDtCnt	  	= 0;
			
			//exp_dt 체크
			//1. To tariff 없을때
			if(toBasicTariffVOList == null || toBasicTariffVOList.size() == 0) {
				toTariffCheck = 1;	//TO TARIFF 존재
				
			//2. To tariff 있을때
			} else {
				for(int i=0; i < toBasicTariffVOList.size(); i++) {
					toBasicTariffVO = (BasicTariffVO)toBasicTariffVOList.get(i);
					if(!toBasicTariffVO.getExpDt().equals(" ")) {
						expDtCnt++;
					}
				}
log.debug("\n---------------1-------------------->");
				
				String to_exp_dt = "";
				String from_eff_dt = "";
				// exp_dt가 존재할때
				if(expDtCnt > 0) {
log.debug("\n---------------2-------------------->");
					for(int i=0; i < toBasicTariffVOList.size(); i++) {
						toBasicTariffVO = (BasicTariffVO)toBasicTariffVOList.get(i);
						
						if(toBasicTariffVO.getExpDt().equals(" ")) {
							continue;
						}
						
						to_exp_dt = JSPUtil.replace(toBasicTariffVO.getExpDt(), "-", "");

						//from
						for(int j=0; j < fromBasicTariffVOList.size(); j++) {
							//to_exp_dt > from_eff_dt
							basicTariffVO = (BasicTariffVO)fromBasicTariffVOList.get(j);
							
							from_eff_dt = JSPUtil.replace(basicTariffVO.getEffDt(), "-", "");
							
							int dayCheck = DateTime.daysBetween(from_eff_dt, to_exp_dt);
							
							if(dayCheck >= 0) {
//								sResult = " Date Duplicated!\n Please check To Tariff!\n CNTR-Cargo Type ["+toBasicTariffVO.getDmdtCntrTpNm()+"-"+toBasicTariffVO.getDmdtCgoTpNm()+"]\n Effective Date["+toBasicTariffVO.getEffDt()+"]\n Expiration Date ["+toBasicTariffVO.getExpDt()+"]";
								sResult = new ErrorHandler("DMT06027").getUserMessage();
								sResult = JSPUtil.replace(sResult, "XXXXXXXX", toBasicTariffVO.getDmdtCntrTpNm());
								sResult = JSPUtil.replace(sResult, "YYYYYYYY", toBasicTariffVO.getDmdtCgoTpNm());
								sResult = JSPUtil.replace(sResult, "EFFYYYYMMDD", toBasicTariffVO.getEffDt());
								sResult = JSPUtil.replace(sResult, "EXPYYYYMMDD", toBasicTariffVO.getExpDt());
								
								return sResult;
							}
						}	
					}
				}
				// exp_dt가 없는 데이터가 존재할때
				if(toBasicTariffVOList.size() - expDtCnt > 0){
log.debug("\n---------------3------------------->");
					sResult = "To Tariff already exists!";	//DMT06023  To Tariff already exists!
					return sResult;
				}
				toTariffCheck = 2;	// TO TRIFF 미존재
			}
			
			if(toTariffCheck == 1) {
log.debug("\n---------------4-------------------->");
				
				//2-1. To svr_id 조회
				svr_id = dbDao.searchComNisSvrId(dmtTariffTypeVO2.getCntCd());
				
				BasicTariffVO basicTariffVO2 = new BasicTariffVO();
				basicTariffVO2.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
				basicTariffVO2.setSvrId(svr_id);
				
				//3-1. To max rgn sequence 조회
				trfSeq = dbDao.searchTrfRgnSequence(basicTariffVO2) + 1;
				
				toTariffRegionVO = new TariffRegionVO();
				
				toTariffRegionVO.setSvrId(svr_id);
				toTariffRegionVO.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
				toTariffRegionVO.setTrfSeq(String.valueOf(trfSeq));
				toTariffRegionVO.setCvrgContiCd(dmtTariffTypeVO2.getCvrgContiCd());
				toTariffRegionVO.setCvrgCntCd(dmtTariffTypeVO2.getCvrgCntCd());
				toTariffRegionVO.setCvrgRgnCd(dmtTariffTypeVO2.getCvrgRgnCd());
				toTariffRegionVO.setCvrgSteCd(dmtTariffTypeVO2.getCvrgSteCd());
				toTariffRegionVO.setCvrgLocCd(dmtTariffTypeVO2.getCvrgLocCd());
				toTariffRegionVO.setCvrgYdCd(dmtTariffTypeVO2.getCvrgYdCd());
				toTariffRegionVO.setOrgDestContiCd(dmtTariffTypeVO2.getOrgDestContiCd());
				toTariffRegionVO.setOrgDestCntCd(dmtTariffTypeVO2.getOrgDestCntCd());
				toTariffRegionVO.setOrgDestRgnCd(dmtTariffTypeVO2.getOrgDestRgnCd());
				toTariffRegionVO.setOrgDestSteCd(dmtTariffTypeVO2.getOrgDestSteCd());
				toTariffRegionVO.setOrgDestLocCd(dmtTariffTypeVO2.getOrgDestLocCd());
				toTariffRegionVO.setUsrId(account.getUsr_id());
				toTariffRegionVO.setOfcCd(account.getOfc_cd());
				toTariffRegionVO.setUiCode(dmtTariffTypeVO2.getUiCode());	//심천 구분(1001:N, 4014:Y)
				
				//4-1. To add Tariff Rgn
				dbDao.addDmtTrfRgn(toTariffRegionVO);

				//toDmtTariffTypeVO => dmtTariffTypeVO2
				
log.debug("\n---------------5------------------->");
				//search From Tariff Group
				for(int i = 0; i < fromBasicTariffVOList.size() ; i++) {
log.debug("\n---------------6-------------------->");
					basicTariffVO =(BasicTariffVO)fromBasicTariffVOList.get(i);
					
					if(fromTrfGrpSeq.equals(basicTariffVO.getTrfGrpSeq())) {
						continue;
					}
					
					fromTrfSeq = basicTariffVO.getTrfSeq();
					fromDmdtDeTermCd = basicTariffVO.getDmdtDeTermCd();						// From 에 해당하는 To_Dmdt_De_Term_Cd
					fromTrfGrpSeq = basicTariffVO.getTrfGrpSeq();
					
					basicTariffVO.setDmdtDeTermCd(toDmtTariffTypeVO.getToDmdtDeTermCd()); 	// To 에 해당하는 Dmdt_De_Term_Cd
					basicTariffVO.setTrfSeq(String.valueOf(trfSeq));
					
					//6-1. max TO trf_grp_seq
					trfGrpSeq = dbDao.searchTrfGrpSequence(basicTariffVO) + 1; // 확인 완료
					
					tariffGroupVO = new TariffGroupVO();
					tariffGroupVO.setSvrId(basicTariffVO.getSvrId());
					tariffGroupVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					tariffGroupVO.setTrfSeq(basicTariffVO.getTrfSeq());
					tariffGroupVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					
					tariffGroupVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					tariffGroupVO.setDmdtBzcTrfGrpNm(basicTariffVO.getDmdtBzcTrfGrpNm());
					tariffGroupVO.setEffDt(basicTariffVO.getEffDt());
					tariffGroupVO.setDmdtTrfGrpTpCd(basicTariffVO.getDmdtTrfGrpTpCd());
					tariffGroupVO.setExpDt(basicTariffVO.getExpDt());
					tariffGroupVO.setXcldSatFlg(basicTariffVO.getXcldSatFlg());
					tariffGroupVO.setXcldSunFlg(basicTariffVO.getXcldSunFlg());
					tariffGroupVO.setXcldHolFlg(basicTariffVO.getXcldHolFlg());
					tariffGroupVO.setDmdtChgCmncTpCd(basicTariffVO.getDmdtChgCmncTpCd());
					tariffGroupVO.setCmncHr(basicTariffVO.getCmncHr());
					tariffGroupVO.setCurrCd(basicTariffVO.getCurrCd());
					tariffGroupVO.setUsrId(account.getUsr_id());
					tariffGroupVO.setOfcCd(account.getOfc_cd());
					
					//7-1. add TO Tariff Group
					dbDao.addDmtTrfGrp(tariffGroupVO); // 확인 완료
					
					combinationVO = new TariffCombinationVO();
					combinationVO.setSvrId(basicTariffVO.getSvrId());
					combinationVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					combinationVO.setTrfSeq(basicTariffVO.getTrfSeq());
					combinationVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd()); //
					combinationVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					combinationVO.setUsrId(account.getUsr_id());
					combinationVO.setOfcCd(account.getOfc_cd());
					
					//8-1. add TO Tariff Combination
					dbDao.addListDmtTrfCmb(combinationVO, fromTrfSeq, fromDmdtDeTermCd, fromTrfGrpSeq);
					
					freeTimeVO = new TariffFreeTimeVO();
					freeTimeVO.setSvrId(basicTariffVO.getSvrId());
					freeTimeVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					freeTimeVO.setTrfSeq(basicTariffVO.getTrfSeq());
					freeTimeVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					freeTimeVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					freeTimeVO.setUsrId(account.getUsr_id());
					freeTimeVO.setOfcCd(account.getOfc_cd());
					
					//9-1. add TO Tariff Free Time
					dbDao.addListDmtTrfFreeTm(freeTimeVO, fromTrfSeq, fromDmdtDeTermCd, fromTrfGrpSeq);

					rateVO = new TariffRateVO();
					rateVO.setSvrId(basicTariffVO.getSvrId());
					rateVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					rateVO.setTrfSeq(basicTariffVO.getTrfSeq());
					rateVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					rateVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					rateVO.setUsrId(account.getUsr_id());
					rateVO.setOfcCd(account.getOfc_cd());
					
					//10-1. add TO Tariff Rate
					dbDao.addListDmtTrfRt(rateVO, fromTrfSeq, fromDmdtDeTermCd, fromTrfGrpSeq);
				}
			}
			else{
				//To Tariff가 존재한다고 할때 To Tariff Seq 조회
				
				dmtTariffTypeVO2.setAllFlg("");
				svr_id = dbDao.searchComNisSvrId(dmtTariffTypeVO2.getCntCd());
				dmtTariffTypeVO2.setSvrId(svr_id);
				
				trfSeq = dbDao.searchTrfRgnMaxSequence(dmtTariffTypeVO2);
				
//				log.debug("-----------------------------------------------------");
//				log.debug("svr_id--->"+dmtTariffTypeVO2.getSvrId());
//				log.debug("dmdt_trf_cd--->"+dmtTariffTypeVO2.getDmdtTrfCd());
//				log.debug("cvrg_conti_cd--->"+dmtTariffTypeVO2.getCvrgContiCd());
//				log.debug("cvrg_cnt_cd--->"+dmtTariffTypeVO2.getCvrgCntCd());
//				log.debug("cvrg_rgn_cd--->"+dmtTariffTypeVO2.getCvrgRgnCd());
//				log.debug("cvrg_ste_cd--->"+dmtTariffTypeVO2.getCvrgSteCd());
//				log.debug("cvrg_loc_cd--->"+dmtTariffTypeVO2.getCvrgLocCd());
//				log.debug("cvrg_yd_cd--->"+dmtTariffTypeVO2.getCvrgYdCd());
//				log.debug("org_dest_conti_cd--->"+dmtTariffTypeVO2.getOrgDestContiCd());
//				log.debug("org_dest_cnt_cd--->"+dmtTariffTypeVO2.getOrgDestCntCd());
//				log.debug("org_dest_rgn_cd--->"+dmtTariffTypeVO2.getOrgDestRgnCd());
//				log.debug("org_dest_ste_cd--->"+dmtTariffTypeVO2.getOrgDestSteCd());
//				log.debug("org_dest_loc_cd--->"+dmtTariffTypeVO2.getOrgDestLocCd());
//				
//				log.debug("-----------------------------------------------------");
//				log.debug("trfSeq--->"+trfSeq);
				
				
				
log.debug("\n---------------7-------------------->");
				//search From Tariff Group
				for(int i = 0; i < fromBasicTariffVOList.size() ; i++) {
log.debug("\n---------------8-------------------->");
					basicTariffVO = (BasicTariffVO)fromBasicTariffVOList.get(i);
					
					
					if(fromTrfGrpSeq.equals(basicTariffVO.getTrfGrpSeq())) {
						continue;
					}
					
					fromTrfSeq = basicTariffVO.getTrfSeq();
					fromDmdtDeTermCd = basicTariffVO.getDmdtDeTermCd();						// From 에 해당하는 To_Dmdt_De_Term_Cd
					fromTrfGrpSeq = basicTariffVO.getTrfGrpSeq();
					
					basicTariffVO.setDmdtDeTermCd(toDmtTariffTypeVO.getToDmdtDeTermCd()); 	// To 에 해당하는 Dmdt_De_Term_Cd
					//To Tariff seq 조회 후 셋팅
					basicTariffVO.setTrfSeq(String.valueOf(trfSeq));
					
					//max trf_grp_seq
					trfGrpSeq = dbDao.searchTrfGrpSequence(basicTariffVO) + 1;
					
					tariffGroupVO = new TariffGroupVO();
					tariffGroupVO.setSvrId(basicTariffVO.getSvrId());
					tariffGroupVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					tariffGroupVO.setTrfSeq(basicTariffVO.getTrfSeq());
					tariffGroupVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					tariffGroupVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					tariffGroupVO.setDmdtBzcTrfGrpNm(basicTariffVO.getDmdtBzcTrfGrpNm());
					tariffGroupVO.setEffDt(basicTariffVO.getEffDt());
					tariffGroupVO.setDmdtTrfGrpTpCd(basicTariffVO.getDmdtTrfGrpTpCd());
					tariffGroupVO.setExpDt(basicTariffVO.getExpDt());
					tariffGroupVO.setXcldSatFlg(basicTariffVO.getXcldSatFlg());
					tariffGroupVO.setXcldSunFlg(basicTariffVO.getXcldSunFlg());
					tariffGroupVO.setXcldHolFlg(basicTariffVO.getXcldHolFlg());
					tariffGroupVO.setDmdtChgCmncTpCd(basicTariffVO.getDmdtChgCmncTpCd());
					tariffGroupVO.setCmncHr(basicTariffVO.getCmncHr());
					tariffGroupVO.setCurrCd(basicTariffVO.getCurrCd());
					tariffGroupVO.setUsrId(account.getUsr_id());
					tariffGroupVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Group
					dbDao.addDmtTrfGrp(tariffGroupVO);
					
					combinationVO = new TariffCombinationVO();
					combinationVO.setSvrId(basicTariffVO.getSvrId());
					combinationVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					combinationVO.setTrfSeq(basicTariffVO.getTrfSeq());
					combinationVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					combinationVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					combinationVO.setUsrId(account.getUsr_id());
					combinationVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Combination
					dbDao.addListDmtTrfCmb(combinationVO, fromTrfSeq, fromDmdtDeTermCd, fromTrfGrpSeq);
					
					freeTimeVO = new TariffFreeTimeVO();
					freeTimeVO.setSvrId(basicTariffVO.getSvrId());
					freeTimeVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					freeTimeVO.setTrfSeq(basicTariffVO.getTrfSeq());
					freeTimeVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					freeTimeVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					freeTimeVO.setUsrId(account.getUsr_id());
					freeTimeVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Free Time
					dbDao.addListDmtTrfFreeTm(freeTimeVO, fromTrfSeq, fromDmdtDeTermCd, fromTrfGrpSeq);

					rateVO = new TariffRateVO();
					rateVO.setSvrId(basicTariffVO.getSvrId());
					rateVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					rateVO.setTrfSeq(basicTariffVO.getTrfSeq());
					rateVO.setDmdtDeTermCd(basicTariffVO.getDmdtDeTermCd());
					rateVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					rateVO.setUsrId(account.getUsr_id());
					rateVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Rate
					dbDao.addListDmtTrfRt(rateVO, fromTrfSeq, fromDmdtDeTermCd, fromTrfGrpSeq);
				}
			}
log.debug("\n---------------9-------------------->");
			//
			sResult = "OK";

		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}	
		return sResult;
		
	}
	
	/**
	 * [CommodityTariffList]를 [search]합니다.<br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<CommodityTariffVO>
	 * @throws EventException
	 */
	public List<CommodityTariffVO> searchCommodityTariffList(DmtTariffTypeVO dmtTariffTypeVO) throws EventException{
		List<TariffRegionVO> tariffRegionVOList = null;
		List<CommodityTariffVO> commodityTariffVOList = null;
		
		try {
			String dmdtTrfCd = dmtTariffTypeVO.getSelDmdtTrfCd();
			dmtTariffTypeVO.setDmdtTrfCd(dmdtTrfCd);
			
//			String bound 	= dmtTariffTypeVO.getDmdtTrfCd().substring(2, 3);
//			String calcTpCd = dmtTariffTypeVO.getDmdtTrfCd().substring(0, 1);
//			
//			CalculationTypeParmVO calcVO = new CalculationTypeParmVO();
//			calcVO.setDmdtCalcTpCd(calcTpCd);
//			calcVO.setIoBndCd(bound);
//			calcVO.setCntCd(dmtTariffTypeVO.getCvrgCntCd());
//			calcVO.setRgnCd(dmtTariffTypeVO.getCvrgRgnCd());
//			calcVO.setSteCd(dmtTariffTypeVO.getCvrgSteCd());
//			calcVO.setLocCd(dmtTariffTypeVO.getCvrgLocCd());
//			log.debug("------------------------------------------");
//			log.debug(dmtTariffTypeVO.getCvrgCntCd());
//			log.debug(dmtTariffTypeVO.getCvrgRgnCd());
//			log.debug(dmtTariffTypeVO.getCvrgSteCd());
//			log.debug(dmtTariffTypeVO.getCvrgLocCd());
//			log.debug("------------------------------------------");
//			
//			//1. checkCalcType
//			boolean checkCalc = dbDaoCheck.checkCalcType(calcVO);
//			
//			if(!checkCalc) {
////				throw new EventException("Calculation Type unmatch");//DMT06011
//				CommodityTariffVO commodityTariffVO = new CommodityTariffVO();
//				commodityTariffVO.setReturnCd("ERROR");
//				commodityTariffVO.setReturnMsg("Calculation Type unmatch");
//	
//				commodityTariffVOList = new ArrayList<CommodityTariffVO>();
//				commodityTariffVOList.add(0, commodityTariffVO);
//				return commodityTariffVOList;
//			}
			
			//2. DMT_TRF_RGN 조회
			tariffRegionVOList = dbDao.checkBasicTariff(dmtTariffTypeVO);
			
			if(tariffRegionVOList == null || tariffRegionVOList.size() ==  0 ) {
				//throw new EventException("Basic Tariff not registered for this coverage!");
				
				CommodityTariffVO commodityTariffVO = new CommodityTariffVO();
				commodityTariffVO.setReturnCd("DMT06031");
	
				commodityTariffVOList = new ArrayList<CommodityTariffVO>();
				commodityTariffVOList.add(0, commodityTariffVO);
				
				return commodityTariffVOList;
			}
			
			//3. 실제 Commodity Exception 조회
			return dbDao.searchCommodityTariffList(dmtTariffTypeVO);			
			
		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} 
		catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		}	
	}
	
	/**
	 * [CommodityTariff]를 [생성]합니다.<br>
	 * @param CommodityTariffVO[] commodityTariffVOs
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyCommodityTariff(CommodityTariffVO[] commodityTariffVOs, DmtTariffTypeVO dmtTariffTypeVO, SignOnUserAccount account) throws EventException {
		try {
			List<CommodityTariffVO> insertVOList = new ArrayList<CommodityTariffVO>();
			List<CommodityTariffVO> updateVOList = new ArrayList<CommodityTariffVO>();
			List<CommodityTariffVO> deleteVOList = new ArrayList<CommodityTariffVO>();

			String dmdtTrfCd = dmtTariffTypeVO.getSelDmdtTrfCd();
			dmtTariffTypeVO.setDmdtTrfCd(dmdtTrfCd);
			
			List<TariffRegionVO> tariffRegionVOList = dbDao.checkBasicTariff(dmtTariffTypeVO);
			TariffRegionVO tariffRegionVO = new TariffRegionVO();
			String iSvrID 		= "";
			String iDmdtTrfCd 	= "";
			String iTrfSeq 		= "";
			
			if(tariffRegionVOList != null) {
				if(tariffRegionVOList.size() > 0) {
					tariffRegionVO = (TariffRegionVO)tariffRegionVOList.get(0);
					iSvrID 		= tariffRegionVO.getSvrId();
					iDmdtTrfCd 	= tariffRegionVO.getDmdtTrfCd();
					iTrfSeq 	= tariffRegionVO.getTrfSeq();
				}
			}
			log.debug("VOs.length==>"+commodityTariffVOs.length);
			
			for ( int i=0; i<commodityTariffVOs.length; i++ ) {
				if ( commodityTariffVOs[i].getIbflag().equals("I")){
					commodityTariffVOs[i].setDeltFlg("N");
					commodityTariffVOs[i].setSvrId(iSvrID);
					commodityTariffVOs[i].setDmdtTrfCd(iDmdtTrfCd);
					commodityTariffVOs[i].setTrfSeq(iTrfSeq);
					commodityTariffVOs[i].setUsrId(account.getUsr_id());
					commodityTariffVOs[i].setOfcCd(account.getOfc_cd());
					insertVOList.add(commodityTariffVOs[i]);
				} else if ( commodityTariffVOs[i].getIbflag().equals("U")){
					commodityTariffVOs[i].setDeltFlg("N");
					commodityTariffVOs[i].setUsrId(account.getUsr_id());
					commodityTariffVOs[i].setOfcCd(account.getOfc_cd());
					updateVOList.add(commodityTariffVOs[i]);
				} else if ( commodityTariffVOs[i].getIbflag().equals("D")){
					commodityTariffVOs[i].setUsrId(account.getUsr_id());
					commodityTariffVOs[i].setOfcCd(account.getOfc_cd());
					deleteVOList.add(commodityTariffVOs[i]);
				}
				
			}
			
			if(insertVOList.size() > 0 ) {
				
				log.debug(" #### INSERT COMMDITY ####  "+insertVOList.size());
				dbDao.addCommodityTariff(insertVOList);
			}
			if(updateVOList.size() > 0 ) {
				log.debug(" #### UPDATE COMMDITY ####  "+updateVOList.size());
				dbDao.modifyCommodityTariff(updateVOList);
				dbDao.addCommodityTariff(updateVOList);
			}
			if(deleteVOList.size() > 0 ) {
				log.debug(" #### DELETE COMMDITY ####  "+deleteVOList.size());
				dbDao.removeCommodityTariff(deleteVOList);
			}

		}catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}	
				
	}	
	
	/**
	 * [CommodityTariffRegionList]를 [search]합니다.<br>
	 * @param CommodityTariffRegionParamVO commodityTariffRegionParamVO
	 * @return List<CommodityTariffRegionVO>
	 * @throws EventException
	 */
	public List<CommodityTariffRegionVO> searchCommodityTariffRegionList(CommodityTariffRegionParamVO commodityTariffRegionParamVO) throws EventException {
		try {
			return dbDao.searchCommodityTariffRegionList(commodityTariffRegionParamVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		}
	}
	
	
	/**
	 * 사용자의 Role정보를 조회 합니다.<br>
	 * @param SearchUserRoleInfoListVO searchUserRoleInfoListVO
	 * @return List<SearchUserRoleInfoListVO>
	 * @throws EventException
	 */
	public List<SearchUserRoleInfoListVO> searchDMTUserRoleInfoList(SearchUserRoleInfoListVO searchUserRoleInfoListVO) throws EventException {
		try {
			return dbDao.searchDMTUserRoleInfoList(searchUserRoleInfoListVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		}
	}
	
	/**
	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
	 * 
	 * @param DmtUsrRoleMtchVO[] dmtUsrRoleMtchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDMTUserRoleInfoList(DmtUsrRoleMtchVO[] dmtUsrRoleMtchVOs, SignOnUserAccount account) throws EventException{
		try {
			List<DmtUsrRoleMtchVO> 	insertVoList 	= new ArrayList<DmtUsrRoleMtchVO>();
			List<DmtUsrRoleMtchVO> 	deleteVoList 	= new ArrayList<DmtUsrRoleMtchVO>();
			
			if (dmtUsrRoleMtchVOs != null) {
				for (int i = 0 ; i < dmtUsrRoleMtchVOs.length ; i++) {
					if (dmtUsrRoleMtchVOs[i].getIbflag().equals("I")){
						dmtUsrRoleMtchVOs[i].setCreUsrId(account.getUsr_id());
						
						insertVoList.add(dmtUsrRoleMtchVOs[i]);
					} 
					else if (dmtUsrRoleMtchVOs[i].getIbflag().equals("D")){
						deleteVoList.add(dmtUsrRoleMtchVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addDMTUserRoleInfoList(insertVoList);
				}
	
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeDMTUserRoleInfoList(deleteVoList);
				}
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}	
	}
	

	
//	/**
//	 * Approval Information List 조회.<br>
//	 * @param SearchApproSetupInfoListVO searchApproSetupInfoListVO
//	 * @return String
//	 * @throws EventException
//	 */
//	public String searchApproSetupValidation(SearchApproSetupInfoListVO searchApproSetupInfoListVO) throws EventException {
//		try {
//			return dbDao.searchApproSetupValidation(searchApproSetupInfoListVO);
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//	}
//	
//	/**
//	 * 사용자의 Role정보를 조회 합니다.<br>
//	 * @param ApproSetupVO ApproSetupVO
//	 * @return List<SearchUserRoleInfoListVO>
//	 * @throws EventException
//	 */
//	public List<SearchApproSetupInfoListVO> searchApproSetupInfoList(ApproSetupVO ApproSetupVO) throws EventException {
//		try {
//			return dbDao.searchApproSetupInfoList(ApproSetupVO);
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//	}
//
//	/**
//	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchApproSetupInfoListVO[] searchApproSetupInfoListVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageApproSetupInfoList(SearchApproSetupInfoListVO[] searchApproSetupInfoListVOs, SignOnUserAccount account) throws EventException{
//		try {
//			List<SearchApproSetupInfoListVO> 	insertVoList 	= new ArrayList<SearchApproSetupInfoListVO>();
//			List<SearchApproSetupInfoListVO> 	deleteVoList 	= new ArrayList<SearchApproSetupInfoListVO>();
//			
//			if (searchApproSetupInfoListVOs != null) {
//				for (int i = 0 ; i < searchApproSetupInfoListVOs.length ; i++) {
//					if (searchApproSetupInfoListVOs[i].getIbflag().equals("D")){
//						deleteVoList.add(searchApproSetupInfoListVOs[i]);
//					} else {
//						searchApproSetupInfoListVOs[i].setUpdUsrId(account.getUsr_id());						
//						insertVoList.add(searchApproSetupInfoListVOs[i]);
//					}
//				}
//				
//				if ( insertVoList.size() > 0 ) {
//					dbDao.addApproSetupInfoList(insertVoList);
//				}
//	
//				if ( deleteVoList.size() > 0 ) {
//					dbDao.removeApproSetupInfoList(deleteVoList);
//				}
//			}
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		}	
//	}
//	
//	
//	/**
//	 * 승인 기준정보별로 설정된 승인 경로를 조회합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathSetupVO searchApprovalPathSetupVO
//	 * @return List<ApprovalPathSetupVO>
//	 * @exception EventException
//	 */
//	public List<SearchApprovalPathSetupVO> searchApprovalPathSetupList(SearchApprovalPathSetupVO searchApprovalPathSetupVO) throws EventException {
//				
//		try {
//			return dbDao.searchApprovalPathSetupList(searchApprovalPathSetupVO);
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//		
//		
//	}
//	
//	/**
//	 * 승인 기준정보별로 설정된 승인 경로를 생성, 수정, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathSetupVO[] searchApprovalPathSetupVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageApprovalPathSetup(SearchApprovalPathSetupVO[] searchApprovalPathSetupVOs, SignOnUserAccount account) throws EventException {
//		
//		try {
//			List<SearchApprovalPathSetupVO> 	insertVoList 	= new ArrayList<SearchApprovalPathSetupVO>();
//			List<SearchApprovalPathSetupVO> 	deleteVoList 	= new ArrayList<SearchApprovalPathSetupVO>();
//			List<SearchApprovalPathSetupVO> 	updateVoList 	= new ArrayList<SearchApprovalPathSetupVO>();
//			List<SearchApprovalPathSetupVO> 	historyVoList 	= new ArrayList<SearchApprovalPathSetupVO>();
//			
//			if (searchApprovalPathSetupVOs != null) {
//				
//				// 화면에서 입력된 데이터 중, 변경이 필요한 정보에 대해서 변경작업을 진행한다.
//				this.convertApprovalPathSetup(searchApprovalPathSetupVOs, account);
//				
//				// 트랜잭션별로 데이터를 분리한다.
//				for (SearchApprovalPathSetupVO searchApprovalPathSetupVO : searchApprovalPathSetupVOs) {
//				
//					if ("D".equals(searchApprovalPathSetupVO.getIbflag())) {
//						deleteVoList.add(searchApprovalPathSetupVO);
//						historyVoList.add(searchApprovalPathSetupVO);
//					} 
//					else if ("I".equals(searchApprovalPathSetupVO.getIbflag())) {
//						insertVoList.add(searchApprovalPathSetupVO);
//					} 
//					else if ("U".equals(searchApprovalPathSetupVO.getIbflag())) {
//						updateVoList.add(searchApprovalPathSetupVO);
//						historyVoList.add(searchApprovalPathSetupVO);
//					}							
//				}
//
//				// 필수입력여부 및 입력값 유효체크는 신규입력항목에 대해서만 실행합니다.
//				if (insertVoList.size() > 0) {
//					// 1. 필수입력여부 체크
//					this.checkMandatoryApprovalPathSetup(insertVoList);
//				}
//				
//				// 이력을 생성한다.
//				if (historyVoList.size() > 0) {
//					dbDao.addApprovalPathSetupHis(historyVoList); //승인경로 이력 추가
//				}
//								
//				// 삭제작업을 제일 먼저 실행한다.
//				if (deleteVoList.size() > 0) {
//					dbDao.removeApprovalPathSetup(deleteVoList); //승인경로 설정 삭제					
//				}
//				// 변경작업을 실행한다.
//				if (updateVoList.size() > 0) {
//					dbDao.modifyApprovalPathSetup(updateVoList); //승인경로 설정 수정					
//				}		
//				// 등록작업을 실행한다.
//				if (insertVoList.size() > 0) {
//					this.addApprovalPathSetup(insertVoList);
//				}	
//			}
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		} 
//		catch (EventException ex) {
//			log.error(ex.getMessage());
//			throw ex;
//		} 		
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		}			
//	}
//	
//	/**
//	 * 화면에서 입력된 정보 중 특정항목에 대한 값을 변경해준다. 
//	 * 
//	 * @param List<SearchApprovalPathSetupVO> listApprovalPathSetup
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	private void convertApprovalPathSetup(SearchApprovalPathSetupVO[] approvalPathSetupVOs, SignOnUserAccount account) throws EventException {
//		
//		String strDmdtCntrCgoTpCd = null;
//		
//		for (SearchApprovalPathSetupVO approvalPathSetup : approvalPathSetupVOs) {
//			
//			approvalPathSetup.setUsrId(account.getUsr_id());
//			approvalPathSetup.setCreOfcCd(account.getOfc_cd());
//			approvalPathSetup.setUpdOfcCd(account.getOfc_cd());
//			
//			if ("I".equals(approvalPathSetup.getIbflag())) {
//				strDmdtCntrCgoTpCd = approvalPathSetup.getDmdtCntrCgoTpCd();
//			}
//			else {
//				strDmdtCntrCgoTpCd = approvalPathSetup.getDmdtCntrCgoTpCdHidden();
//			}
//			
//			if (!StringUtil.isEmpty(strDmdtCntrCgoTpCd)) {
//				// Contract Exception Type 이 'S'(S/C) 인 경우
//				if ("S".equals(approvalPathSetup.getDmdtCtrtExptTpCd())) {
//					approvalPathSetup.setDmdtCntrTpCd(strDmdtCntrCgoTpCd);
//					approvalPathSetup.setDmdtCgoTpCd(" ");
//				}
//				// Contract Exception Type 이 'B'(RFA) 인 경우
//				else {
//					String[] arrCgoTpCd = strDmdtCntrCgoTpCd.split(":");
//					
//					approvalPathSetup.setDmdtCntrTpCd(arrCgoTpCd[0]);
//					approvalPathSetup.setDmdtCgoTpCd(arrCgoTpCd[1]);							
//				}
//			}
//			// Cargo 를 all 선택시(한자리 공백 입력)
//			else {
//				approvalPathSetup.setDmdtCntrTpCd(" ");
//				approvalPathSetup.setDmdtCgoTpCd(" ");						
//			}
//			
//			// 테스트 코드#####################
//			this.log(approvalPathSetup);
//			//################################
//		}
//	}

//	/*################################
//	 * 테스트 메소드
//	 * ################################
//	 */
//	private void log(SearchApprovalPathSetupVO approvalPathSetup) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("\n[convertApprovalPathSetup] TRD_CD : '" + approvalPathSetup.getTrdCd()).append("' ");
//		sb.append(",DMDT_EXPT_TRD_DIR_CD : '" + approvalPathSetup.getDmdtExptTrdDirCd()).append("' ");
//		sb.append(",DMDT_CTRT_EXPT_TP_CD : '" + approvalPathSetup.getDmdtCtrtExptTpCd()).append("' ");
//		sb.append(",DMDT_CALC_TP_CD : '" + approvalPathSetup.getDmdtCalcTpCd()).append("' ");
//		sb.append(",DMDT_CNTR_CGO_TP_CD : '" + approvalPathSetup.getDmdtCntrCgoTpCd()).append("' ");
//		sb.append(",DMDT_CNTR_CGO_TP_CD_HID : '" + approvalPathSetup.getDmdtCntrCgoTpCdHidden()).append("' ");
//		sb.append(",DMDT_CNTR_TP_CD : '" + approvalPathSetup.getDmdtCntrTpCd()).append("' ");
//		sb.append(",DMDT_CGO_TP_CD : '" + approvalPathSetup.getDmdtCgoTpCd()).append("' ");
//		log.debug(sb.toString());
//	}
//	
//	/**
//	 * 화면에서 입력된 정보 중 필수입력항목에 대해서 체크를 수행합니다. <br> 
//	 * 
//	 * @param List<SearchApprovalPathSetupVO> listApprovalPathSetup
//	 * @exception EventException
//	 */
//	private void checkMandatoryApprovalPathSetup(List<SearchApprovalPathSetupVO> listApprovalPathSetup) throws EventException {
//		
//		// 입력정보가 존재할 경우, 필수 입력 및 입력유효성을 체크한다.
//		for (SearchApprovalPathSetupVO approvalPathSetup : listApprovalPathSetup) {
//			
//			// 1. 필수입력값 체크
//			// 1) TRADE
//			if (StringUtil.isEmpty(approvalPathSetup.getTrdCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"TRADE"}).getUserMessage());
//			}
//			// 2) BOUND(E : E/B, W : W/B)
//			else if (StringUtil.isEmpty(approvalPathSetup.getDmdtExptTrdDirCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"BOUND"}).getUserMessage());
//			}
//			// 3) CONTRACT EXCEPTION TYPE (S : S/C, B : BEFORE) ### 추가요건에서는 Contract Exception Type 을 사용하지 않음. 2014.12.18
////			else if (StringUtil.isEmpty(approvalPathSetup.getDmdtCtrtExptTpCd())) {
////				// COM12201 : ($s) is mandatory. Please enter ($s).
////				throw new EventException(new ErrorHandler("COM12201", new String[]{"CTRT TYPE"}).getUserMessage());				
////			}
//			// 4) TYPE (C : Combined, D : Dual)
//			else if (StringUtil.isEmpty(approvalPathSetup.getDmdtCalcTpCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"TYPE"}).getUserMessage());				
//			}
//			// 5) CARGO 										### 추가요건에서는 Cargo Type 을 사용하지 않음. 2014.12.18
////			else if (StringUtil.isEmpty(approvalPathSetup.getDmdtCntrCgoTpCd())) {
////				// COM12201 : ($s) is mandatory. Please enter ($s).
////				throw new EventException(new ErrorHandler("COM12201", new String[]{"CARGO"}).getUserMessage());					
////			}
//			// 6) FREE TIME (A : Add, T : Total)
//			else if (StringUtil.isEmpty(approvalPathSetup.getTrdCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"FREE TIME"}).getUserMessage());					
//			}
//			// 7) Eff (From)
//			else if (StringUtil.isEmpty(approvalPathSetup.getEffDt())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"EFF DATE(From)"}).getUserMessage());					
//			}
//			// 8) Eff (To)  									### 추가요건에서는 Eff(To) 는 필수입력항목이 아님. 2014.12.18
////			else if (StringUtil.isEmpty(approvalPathSetup.getExpDt())) {
////				// COM12201 : ($s) is mandatory. Please enter ($s).
////				throw new EventException(new ErrorHandler("COM12201", new String[]{"EFF DATE(To)"}).getUserMessage());					
////			}			
//			// 9) Days
//			else if (StringUtil.isEmpty(approvalPathSetup.getFtFmDys())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"DAYS(From)"}).getUserMessage());						
//			}
//			// 10) 승인경로는 반드시 1개 이상 존재해야 합니다.
//			else if (StringUtil.isEmpty(approvalPathSetup.getDmdtBrncFlg()) 	// Branch Office
//					&& StringUtil.isEmpty(approvalPathSetup.getDmdtRhqFlg()) 	// Regional HQ (V.P)
//					&& StringUtil.isEmpty(approvalPathSetup.getDmdtRhqPicFlg())	// Regional HQ (PIC)
//					&& StringUtil.isEmpty(approvalPathSetup.getDmdtHoFlg())) {	// Head Office
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"Branch Office or Regional HQ or Head Office"}).getUserMessage());				
//			}			
//		}
//	}
//	
//	/**
//	 * 화면에서 입력된 정보 중 유효값인지여부를 체크합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathSetupVO searchApprovalPathSetupVO
//	 * @exception EventException
//	 */	
//	private void checkValidateApprovalPathSetup(SearchApprovalPathSetupVO searchApprovalPathSetupVO) throws EventException {
//		
//		try {
//			// IAS 는 Bound 는 존재하지 않는다.
//			if ("IAS".equals(searchApprovalPathSetupVO.getTrdCd()) && !" ".equals(searchApprovalPathSetupVO.getDmdtExptTrdDirCd())) {
//				// IAS 는 Bound 가 존재하지 않는다.
//				throw new EventException(new ErrorHandler("DMT06044", new String[]{searchApprovalPathSetupVO.getTrdCd(), "bound"}).getUserMessage());
//			}
//			
//			// 중복입력 여부를 체크합니다. (Cargo 유효성을 포함한 중복된 날짜가 존재하는지 여부)
//			// 동일한 조건에 Cargo 가 'D' 이고, 신규 행이 'All' 은 입력불가하다. 그 반대의 경우도 동일.
//
//			// 중복입력된 행에서 Free time Days 가 가장 큰 행을 찾아온다.
//			List<SearchApprovalPathSetupVO> resultVOList = dbDao.searchDuplicateApprovalPathSetup(searchApprovalPathSetupVO);
//			
//			// 조회결과가 존재할 경우, 중복된 행이 존재합니다.
//			if (resultVOList != null && resultVOList.size() > 0) {
//
//				// 중복된 조회결과가 존재할 경우, Freetime Days(To) 가 존재할 경우
//				if (!StringUtils.isEmpty(resultVOList.get(0).getFtToDys())) {
//					int iDupFtToDys = Integer.valueOf(resultVOList.get(0).getFtToDys());
//					int iInpFtFmDys = Integer.valueOf(searchApprovalPathSetupVO.getFtFmDys());
//
//					if (iInpFtFmDys <= iDupFtToDys) {
//						// 중복된 데이터가 존재합니다.
//						// DMT02048 : The duplicated data exists. $s
//						StringBuilder sb = new StringBuilder();
//						sb.append("\n");
//						sb.append("     ").append("TRADE").append(" = '").append(searchApprovalPathSetupVO.getTrdCd()).append("'").append("\n");
//						sb.append("     ").append("Bound").append(" = '").append(searchApprovalPathSetupVO.getDmdtExptTrdDirCd()).append("'").append("\n");
//						sb.append("     ").append("Type").append(" = '").append(searchApprovalPathSetupVO.getDmdtCalcTpCd()).append("'").append("\n");
//						sb.append("     ").append("Free Time").append(" = '").append(searchApprovalPathSetupVO.getDmdtFtTpCd()).append("'").append("\n");
//						sb.append("     ").append("EFF Date(From)").append(" = '").append(searchApprovalPathSetupVO.getEffDt()).append("'").append("\n");
//						sb.append("     ").append("EFF Date(To)").append(" = '").append(searchApprovalPathSetupVO.getExpDt()).append("'").append("\n");
//						sb.append("     ").append("Days(From)").append(" = '").append(searchApprovalPathSetupVO.getFtFmDys()).append("'").append("\n");
//						sb.append("     ").append("Days(To)").append(" = '").append(searchApprovalPathSetupVO.getFtToDys()).append("'").append("\n");
//						throw new EventException(new ErrorHandler("DMT02048", new String[]{sb.toString()}).getUserMessage());						
//					}
//					else if (iInpFtFmDys > iDupFtToDys+1) {
//						// Free time Days(From) 은  30 만 입력가능합니다.
//						// DMT06045 : You can enter only $s free time days(From). $s
//						StringBuilder sb = new StringBuilder();
//						sb.append("\n");
//						sb.append("     ").append("TRADE").append(" = '").append(searchApprovalPathSetupVO.getTrdCd()).append("'").append("\n");
//						sb.append("     ").append("Bound").append(" = '").append(searchApprovalPathSetupVO.getDmdtExptTrdDirCd()).append("'").append("\n");
//						sb.append("     ").append("Type").append(" = '").append(searchApprovalPathSetupVO.getDmdtCalcTpCd()).append("'").append("\n");
//						sb.append("     ").append("Free Time").append(" = '").append(searchApprovalPathSetupVO.getDmdtFtTpCd()).append("'").append("\n");
//						sb.append("     ").append("EFF Date(From)").append(" = '").append(searchApprovalPathSetupVO.getEffDt()).append("'").append("\n");
//						sb.append("     ").append("EFF Date(To)").append(" = '").append(searchApprovalPathSetupVO.getExpDt()).append("'").append("\n");
//						sb.append("     ").append("Days(From)").append(" = '").append(searchApprovalPathSetupVO.getFtFmDys()).append("'").append("\n");
//						sb.append("     ").append("Days(To)").append(" = '").append(searchApprovalPathSetupVO.getFtToDys()).append("'").append("\n");
//						throw new EventException(new ErrorHandler("DMT06045", new String[]{String.valueOf(iDupFtToDys+1), sb.toString()}).getUserMessage());						
//					}
//				}
//				// 중복된 조회결과가 존재할 경우, Freetime Days(To) 가 존재하지 않을 경우.
//				else {
//					// 기등록된 데이터의 Free time Days(To) 값을 먼저 입력하세요.
//					// DMT06046 : first, check up free time days(To) of registered setup information. $s
//					StringBuilder sb = new StringBuilder();
//					sb.append("\n");
//					sb.append("     ").append("TRADE").append(" = '").append(resultVOList.get(0).getTrdCd()).append("'").append("\n");
//					sb.append("     ").append("Bound").append(" = '").append(resultVOList.get(0).getDmdtExptTrdDirCd()).append("'").append("\n");
//					sb.append("     ").append("Type").append(" = '").append(resultVOList.get(0).getDmdtCalcTpCd()).append("'").append("\n");
//					sb.append("     ").append("Free Time").append(" = '").append(resultVOList.get(0).getDmdtFtTpCd()).append("'").append("\n");
//					sb.append("     ").append("EFF Date(From)").append(" = '").append(resultVOList.get(0).getEffDt()).append("'").append("\n");
//					sb.append("     ").append("EFF Date(To)").append(" = '").append(resultVOList.get(0).getExpDt()).append("'").append("\n");
//					sb.append("     ").append("Days(From)").append(" = '").append(resultVOList.get(0).getFtFmDys()).append("'").append("\n");
//					sb.append("     ").append("Days(To)").append(" = '").append(resultVOList.get(0).getFtToDys()).append("'").append("\n");
//					throw new EventException(new ErrorHandler("DMT06046", new String[]{sb.toString()}).getUserMessage());						
//				}
//			}
//		}
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} 
//		catch (EventException ex) {
//			log.error(ex.getMessage());
//			throw ex;
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
	
//	/**
//	 * 승인 경로별로 설정된 승인 대행자를 조회합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO
//	 * @return List<SearchApprovalPathAgentSetupVO>
//	 * @exception EventException
//	 */
//	public List<SearchApprovalPathAgentSetupVO> searchApprovalPathAgentSetupList(SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO) throws EventException {
//		
//		try {
//			return dbDao.searchApprovalPathAgentSetupList(searchApprovalPathAgentSetupVO);
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}	
//
//	}
//
//	/**
//	 * 고객별로 설정된 승인자 및 승인 대행자를 조회합니다. <br> 
//	 * 
//	 * @param SearchCustApprovalSetupVO searchCustApprovalSetupVO
//	 * @return List<SearchCustApprovalSetupVO>
//	 * @exception EventException
//	 */
//	public List<SearchCustApprovalSetupVO> searchCustApprovalSetupList(SearchCustApprovalSetupVO searchCustApprovalSetupVO) throws EventException {
//	
//		try {
//			return dbDao.searchCustApprovalSetupList(searchCustApprovalSetupVO);
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
//	
//	/**
//	 * 승인 경로별로 설정된 승인 대행자를 생성, 수정, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO[] searchApprovalPathAgentSetupVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageApprovalPathAgentSetup(SearchApprovalPathAgentSetupVO[] searchApprovalPathAgentSetupVOs, SignOnUserAccount account) throws EventException {
//		
//		try {
//			List<SearchApprovalPathAgentSetupVO> 	insertVoList 	= new ArrayList<SearchApprovalPathAgentSetupVO>();
//			List<SearchApprovalPathAgentSetupVO> 	deleteVoList 	= new ArrayList<SearchApprovalPathAgentSetupVO>();
//			List<SearchApprovalPathAgentSetupVO> 	updateVoList 	= new ArrayList<SearchApprovalPathAgentSetupVO>();
//			List<SearchApprovalPathAgentSetupVO> 	historyVoList   = new ArrayList<SearchApprovalPathAgentSetupVO>(); // update 이력용 vo-list
//			
//			if (searchApprovalPathAgentSetupVOs != null) {
//				
//				for (SearchApprovalPathAgentSetupVO vo : searchApprovalPathAgentSetupVOs) {
//					
//					vo.setUsrId(account.getUsr_id());
//					vo.setCreOfcCd(account.getOfc_cd());
//					vo.setUpdOfcCd(account.getOfc_cd());
//					
//					// 트랜잭션별로 데이터를 분리한다.
//					if ("D".equals(vo.getIbflag())) {
//						deleteVoList.add(vo);
//						historyVoList.add(vo);
//					} 
//					else if("I".equals(vo.getIbflag())) {		
//						
//						/** 대행자(1,2,3) 데이터 구성 **/
//						insertVoList.addAll(this.getApprovalPathAgentSetupVOList(vo));
//					} 
//					else if("U".equals(vo.getIbflag())) {	
//						
//						/** 대행자(1,2,3) 데이터 구성 **/
//						updateVoList.addAll(this.getApprovalPathAgentSetupVOList(vo));
//						historyVoList.add(vo); //수정시 이력 등록용 vo 설정
//					}
//				}
//				
//				// 필수입력여부 및 입력값 유효체크는 신규입력항목에 대해서만 실행합니다.
//				if (insertVoList.size() > 0) {
//					// 1. 필수입력여부 체크
//					this.checkMandatoryApprovalPathAgentSetup(insertVoList);
//					// 2. 입력값 유효성 체크
//					this.checkValidateApprovalPathAgentSetup(insertVoList);
//				}				
//				
//				// 이력을 생성한다.
//				if (historyVoList.size() > 0) {
//					dbDao.addApprovalPathAgentSetupHis(historyVoList); 	//승인경로별 승인대행자 이력 추가
//				}
//								
//				// 삭제작업을 제일 먼저 실행한다.
//				if (deleteVoList.size() > 0) {
//					dbDao.removeApprovalPathAgentSetup(deleteVoList); 	//승인경로별 승인대행자 삭제					
//				}
//				// 변경작업을 실행한다.
//				if (updateVoList.size() > 0) {
//					dbDao.removeApprovalPathAgentSetup(updateVoList);	//승인경로별 승인대행자 삭제
//					dbDao.addApprovalPathAgentSetup(updateVoList);		//승인경로별 승인대행자 추가					
//				}		
//				// 등록작업을 실행한다.
//				if (insertVoList.size() > 0) {
//					dbDao.addApprovalPathAgentSetup(insertVoList); 		//승인경로별 승인대행자 추가
//				}	
//			}
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		}	
//		
//	}
//	
//	/**
//	 * 등록, 수정, 삭제 대상 목록에 승인경로 대행자설정 정보를 추가해준다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO vo
//	 * @return List<SearchApprovalPathAgentSetupVO>
//	 */
//	private List<SearchApprovalPathAgentSetupVO> getApprovalPathAgentSetupVOList(SearchApprovalPathAgentSetupVO vo) {
//		
//		List<SearchApprovalPathAgentSetupVO> list = new ArrayList<SearchApprovalPathAgentSetupVO>();
//		
//		if (!StringUtil.isEmpty(vo.getAproAgn1Id())) {
//			list.add(this.getApprovalPathAgentSetupVO(vo, 1));	// 1번째 대행자
//		}
//		if (!StringUtil.isEmpty(vo.getAproAgn2Id())) {
//			list.add(this.getApprovalPathAgentSetupVO(vo, 2));	// 2번째 대행자
//		}
//		if (!StringUtil.isEmpty(vo.getAproAgn3Id())) {
//			list.add(this.getApprovalPathAgentSetupVO(vo, 3));	// 3번째 대행자
//		}
//		
//		return list;
//	}
//	
//	/**
//	 * 승인대행자 정보객체를 생성해서 반환한다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO vo
//	 * @param int order
//	 * @return SearchApprovalPathAgentSetupVO
//	 */
//	private SearchApprovalPathAgentSetupVO getApprovalPathAgentSetupVO(SearchApprovalPathAgentSetupVO vo, int order) {
//		
//		String strAproAgnId = null;
//
//		switch (order) {
//			case 1: strAproAgnId = vo.getAproAgn1Id(); break;
//			case 2: strAproAgnId = vo.getAproAgn2Id(); break;
//			case 3: strAproAgnId = vo.getAproAgn3Id(); break;
//		}
//		
//		SearchApprovalPathAgentSetupVO agentSetupVO = new SearchApprovalPathAgentSetupVO();
//		agentSetupVO.setTrdCd(vo.getTrdCd());
//		agentSetupVO.setDmdtExptTrdDirCd(vo.getDmdtExptTrdDirCd());
//		agentSetupVO.setDmdtExptAproPathCd(vo.getDmdtExptAproPathCd());
//		agentSetupVO.setDmdtCtrtExptTpCd(vo.getDmdtCtrtExptTpCd());
//		agentSetupVO.setAproOfcCd(vo.getAproOfcCd());
//		agentSetupVO.setAproAgnId(strAproAgnId);
//		agentSetupVO.setDmdtExptAproAgnOrdNo(String.valueOf(order));
//		agentSetupVO.setUsrId(vo.getUsrId());
//		agentSetupVO.setCreOfcCd(vo.getCreOfcCd());
//		agentSetupVO.setUpdOfcCd(vo.getUpdOfcCd());
//		
//		return agentSetupVO;
//	}
//	
//	/**
//	 * 화면에서 입력된 정보 중 필수입력항목에 대해서 체크를 수행합니다. <br> 
//	 * 
//	 * @param List<SearchApprovalPathAgentSetupVO> listApprovalPathAgentSetup
//	 * @exception EventException
//	 */
//	private void checkMandatoryApprovalPathAgentSetup(List<SearchApprovalPathAgentSetupVO> listApprovalPathAgentSetup) throws EventException {
//		
//		// 입력정보가 존재할 경우, 필수 입력 및 입력유효성을 체크한다.
//		for (SearchApprovalPathAgentSetupVO approvalPathAgentSetup : listApprovalPathAgentSetup) {
//			
//			// 1. 필수입력값 체크
//			if (StringUtil.isEmpty(approvalPathAgentSetup.getAproOfcCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"Office Code"}).getUserMessage());				
//			}
//			else if (StringUtil.isEmpty(approvalPathAgentSetup.getAproAgnId())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"Deputy Code"}).getUserMessage());				
//			}
//			else if (StringUtil.isEmpty(approvalPathAgentSetup.getDmdtExptAproAgnOrdNo())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"Deputy Order"}).getUserMessage());				
//			}			
//		}
//	}
//	
//	/**
//	 * 화면에서 입력된 정보 중 유효값인지여부를 체크합니다. <br> 
//	 * 
//	 * @param List<SearchApprovalPathAgentSetupVO> listApprovalPathAgentSetup
//	 * @exception EventException
//	 */	
//	private void checkValidateApprovalPathAgentSetup(List<SearchApprovalPathAgentSetupVO> listApprovalPathAgentSetup) throws EventException {
//		
//		try {
//			// 입력정보가 존재할 경우, 필수 입력 및 입력유효성을 체크한다.
//			for (SearchApprovalPathAgentSetupVO approvalPathAgentSetup : listApprovalPathAgentSetup) {
//				
//				// 1. 중복입력 여부를 체크합니다.
//				if (dbDao.isDuplicatetApprovalPathAgentSetup(approvalPathAgentSetup)) {
//					// The approver of ($s) customer is already registered.
//					throw new EventException(new ErrorHandler("DMT02043", new String[]{approvalPathAgentSetup.getAproAgnId()}).getUserMessage());
//				}			
//			}
//		}
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}				
//	}
//	
//	/**
//	 * 고객별로 설정된 승인자 및 승인 대행자를 생성, 수정, 삭제 합니다. <br> 
//	 * 
//	 * @param SearchCustApprovalSetupVO[] searchCustApprovalSetupVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageCustApprovalSetup(SearchCustApprovalSetupVO[] searchCustApprovalSetupVOs, SignOnUserAccount account) throws EventException {
//		try {
//			List<SearchCustApprovalSetupVO> 	insertVoList 	= new ArrayList<SearchCustApprovalSetupVO>();
//			List<SearchCustApprovalSetupVO> 	deleteVoList 	= new ArrayList<SearchCustApprovalSetupVO>();
//			List<SearchCustApprovalSetupVO> 	updateVoList 	= new ArrayList<SearchCustApprovalSetupVO>();
//			List<SearchCustApprovalSetupVO> 	historyVOList	= new ArrayList<SearchCustApprovalSetupVO>();
//			
//			if (searchCustApprovalSetupVOs != null) {
//				
//				for (SearchCustApprovalSetupVO vo : searchCustApprovalSetupVOs) {
//					
//					vo.setUsrId(account.getUsr_id());
//					vo.setCreOfcCd(account.getOfc_cd());
//					vo.setUpdOfcCd(account.getOfc_cd());
//					
//					// 트랜잭션별로 데이터를 분리한다.
//					if ("D".equals(vo.getIbflag())) {
//						
//						vo.setHisSeq(dbDao.searchCustApprovalSetupHisSeq(vo)); 			// 이력 순번 채번 후 설정
//						deleteVoList.add(vo);											// 고객별 승인자 정보
//					} 
//					else if("I".equals(vo.getIbflag())) {		
//						
//						insertVoList.add(vo);											// 고객별 승인자 정보
//					} 
//					else if("U".equals(vo.getIbflag())) {
//						
//						vo.setHisSeq(dbDao.searchCustApprovalSetupHisSeq(vo)); 			// 이력 순번 채번 후 설정
//						updateVoList.add(vo);											// 고객별 승인자 정보
//					}							
//				}
//				
//				// 필수입력여부 및 입력값 유효체크는 신규입력항목에 대해서만 실행합니다.
//				if (insertVoList.size() > 0) {
//					log.debug("\n[manageCustApprovalSetup] >>>>>. 필수입력여부 체크");
//					// 1. 필수입력여부 체크
//					this.checkMandatoryCustApprovalSetup(insertVoList);
//					log.debug("\n[manageCustApprovalSetup] >>>>>. 입력값 유효성 체크");
//					// 2. 입력값 유효성 체크
//					this.checkValidateCustApprovalSetup(insertVoList);
//				}
//				
//				// 이력 정보 관리
//				historyVOList.addAll(deleteVoList);
//				historyVOList.addAll(updateVoList);
//				
//				// 이력을 생성한다.
//				if (historyVOList.size() > 0) {
//					log.debug("\n[manageCustApprovalSetup] >>>>>. 이력 생성");
//					dbDao.addCustApprovalSetupHis(historyVOList); 		//마스터 정보 이력 추가
//				}
//				
//				// 삭제작업을 제일 먼저 실행한다.
//				if (deleteVoList.size() > 0) { 	//삭제
//					log.debug("\n[manageCustApprovalSetup] >>>>>. 삭제");
//					//실제 데이터 삭제
//					dbDao.removeCustApprovalSetup(deleteVoList); 		//마스터 정보 삭제
//				}
//				
//				// 변경작업을 실행한다.
//				if (updateVoList.size() > 0) { 	//수정
//					log.debug("\n[manageCustApprovalSetup] >>>>>. 수정");
//					//실제 데이터 수정
//					dbDao.modifyCustApprovalSetup(updateVoList);		//마스터 정보 수정				
//				}	
//				// 등록작업을 실행한다.
//				if (insertVoList.size() > 0) { //등록
//					log.debug("\n[manageCustApprovalSetup] >>>>>. 등록");
//					dbDao.addCustApprovalSetup(insertVoList); 			//마스터 정보 추가
//				}
//			}
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		}
//		catch (EventException ex) {
//			log.error(ex.getMessage());
//			throw ex;
//		} 		
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
//		}				
//	}
//
//	/**
//	 * 화면에서 입력된 정보 중 필수입력항목에 대해서 체크를 수행합니다. <br> 
//	 * 
//	 * @param List<SearchCustApprovalSetupVO> listCustApprovalSetupVO
//	 * @exception EventException
//	 */
//	private void checkMandatoryCustApprovalSetup(List<SearchCustApprovalSetupVO> listCustApprovalSetupVO) throws EventException {
//		
//		// 입력정보가 존재할 경우, 필수 입력 및 입력유효성을 체크한다.
//		for (SearchCustApprovalSetupVO custApprovalSetupVO : listCustApprovalSetupVO) {
//			
//			// 1. 필수입력값 체크
//			if (StringUtil.isEmpty(custApprovalSetupVO.getCustCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"Customer Code"}).getUserMessage());				
//			}			
//			else if (StringUtil.isEmpty(custApprovalSetupVO.getAproOfcCd())) {
//				// COM12201 : ($s) is mandatory. Please enter ($s).
//				throw new EventException(new ErrorHandler("COM12201", new String[]{"Office Code"}).getUserMessage());				
//			}
////			else if (StringUtil.isEmpty(custApprovalSetupVO.getAproUsrId())) {
////				// COM12201 : ($s) is mandatory. Please enter ($s).
////				throw new EventException(new ErrorHandler("COM12201", new String[]{"Approver Code"}).getUserMessage());				
////			}
//		}
//	}
//	
//	/**
//	 * 화면에서 입력된 정보 중 유효값인지여부를 체크합니다. <br> 
//	 * 
//	 * @param List<SearchCustApprovalSetupVO> listCustApprovalSetupVO
//	 * @exception EventException
//	 */	
//	private void checkValidateCustApprovalSetup(List<SearchCustApprovalSetupVO> listCustApprovalSetupVO) throws EventException {
//		
//		try {
//			// 입력정보가 존재할 경우, 필수 입력 및 입력유효성을 체크한다.
//			for (SearchCustApprovalSetupVO custApprovalSetupVO : listCustApprovalSetupVO) {
//				
//				// 1. 중복입력 여부를 체크합니다.
//				if (dbDao.isDuplicateCustApprovalPathSetup(custApprovalSetupVO)) {
//					// The approver of ($s) customer is already registered.
//					throw new EventException(new ErrorHandler("DMT02043", new String[]{custApprovalSetupVO.getCustCd()}).getUserMessage());
//				}
//			}
//		}
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//		catch (EventException ex) {
//			log.error(ex.getMessage());
//			throw ex;
//		}		
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
//	
//	/**
//	 * Office 에 소속되어 있는 사용자인지 조회한다. <br> 
//	 * 
//	 * @param SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO
//	 * @return String
//	 * @throws EventException
//	 */
//	public String searchOfcCustCheck(SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO) throws EventException {
//		try {
//			return dbDao.searchOfcCustCheck(searchApprovalPathAgentSetupVO);
//		} catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//	}	
//	
//	/**
//	 * S/C Exception 승인처리를 위해 등록된 승인경로정보를 조회한다. <br> 
//	 * 
//	 * @param SCExceptionApprovalPathVO sCExceptionApprovalPathVO
//	 * @return List<SCExceptionApprovalPathVO>
//	 * @exception EventException
//	 */	
//	public List<SCExceptionApprovalPathVO> searchSCExptAproPathList(SCExceptionApprovalPathVO sCExceptionApprovalPathVO) throws EventException {
//		
//		try {
//			return dbDao.searchSCExptAproPathList(sCExceptionApprovalPathVO);
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
//	
//	/**
//	 * RFA Exception 승인처리를 위해 등록된 승인경로정보를 조회한다. <br> 
//	 * 
//	 * @param RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO
//	 * @return List<RFAExceptionApprovalPathVO>
//	 * @exception EventException
//	 */	
//	public List<RFAExceptionApprovalPathVO> searchRFAExptAproPathList(RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO) throws EventException {
//		
//		try {
//			return dbDao.searchRFAExptAproPathList(rFAExceptionApprovalPathVO);
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}			
//	}
//	
//	/**
//	 * S/C Exception 승인처리를 위해 등록된 승인자 및 승인대행자를 조회한다. <br> 
//	 * 
//	 * @param SCExceptionApprovalPathVO sCExceptionApprovalPathVO
//	 * @return List<SCExceptionApprovalPathUserVO>
//	 * @exception EventException
//	 */	
//	public List<SCExceptionApprovalPathUserVO> searchSCExptAproUserListByAproPath(SCExceptionApprovalPathVO sCExceptionApprovalPathVO) throws EventException {
//		
//		try {
//			return dbDao.searchSCExptAproUserListByAproPath(sCExceptionApprovalPathVO);
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}			
//	}
//	
//	/**
//	 * RFA Exception 승인처리를 위해 등록된 승인자 및 승인대행자를 조회한다. <br> 
//	 * 
//	 * @param RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO
//	 * @return List<RFAExceptionApprovalPathUserVO>
//	 * @exception EventException
//	 */	
//	public List<RFAExceptionApprovalPathUserVO> searchRFAExptAproUserListByAproPath(RFAExceptionApprovalPathVO rFAExceptionApprovalPathVO) throws EventException {
//
//		try {
//			return dbDao.searchRFAExptAproUserListByAproPath(rFAExceptionApprovalPathVO);
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
//	
//	/**
//	 * Approval Path 에 해당되는 유효한 Office 인지 조회
//	 * @param SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO
//	 * @return String
//	 * @throws EventException
//	 */
//	public String searchValidOfficeForAproPath(SearchApprovalPathAgentSetupVO searchApprovalPathAgentSetupVO) throws EventException {
//
//		try {
//			return dbDao.searchValidOfficeForAproPath(searchApprovalPathAgentSetupVO);
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
//	
//	/**
//	 * 입력될 승인경로SETUP 정보에 시퀀스를 설정해서 등록처리한다.
//	 * @param List<SearchApprovalPathSetupVO> searchApprovalPathSetupVOList
//	 * @throws EventException
//	 */	
//	private void addApprovalPathSetup(List<SearchApprovalPathSetupVO> searchApprovalPathSetupVOList) throws EventException {
//
//		try {
//			for (SearchApprovalPathSetupVO searchApprovalPathSetupVO: searchApprovalPathSetupVOList) {
//				
//				// 1. 승인경로SETUP 입력정보 유효성 체크
//				this.checkValidateApprovalPathSetup(searchApprovalPathSetupVO);
//				
//				// 2. 승인경로SETUP 입력정보 등록
//				dbDao.addApprovalPathSetup(searchApprovalPathSetupVO);
//			}
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}
//		catch (EventException ex) {
//			log.error(ex.getMessage());
//			throw ex;
//		}
//		catch (Exception ex) {
//			log.error(ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
//		}		
//	}
	

	/**
	 * [Basic Tariff Monitor]를 [search]합니다.<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchBasicTariffMonitorVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffMonitorVO> searchBasicTariffMonitor(SearchContinentParamVO searchContinentParamVO) throws EventException {
		try {
			return dbDao.searchBasicTariffMonitor(searchContinentParamVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	

	/**
	 * [Basic Tariff Monitor]를 [search]합니다.<br>
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchBasicTariffNotiListVO>
	 * @exception EventException
	 */
	public List<SearchBasicTariffNotiListVO> searchBasicTariffNotiList(SearchContinentParamVO searchContinentParamVO) throws EventException {
		try {
			return dbDao.searchBasicTariffNotiList(searchContinentParamVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	

	/**
	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
	 * 
	 * @param SearchBasicTariffNotiListVO[] searchBasicTariffNotiListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBasicTariffNotiList(SearchBasicTariffNotiListVO[] searchBasicTariffNotiListVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchBasicTariffNotiListVO> 	updateVoList 	= new ArrayList<SearchBasicTariffNotiListVO>();
			
			if (searchBasicTariffNotiListVOs != null) {
				for (int i = 0 ; i < searchBasicTariffNotiListVOs.length ; i++) {
					if (searchBasicTariffNotiListVOs[i].getIbflag().equals("U")){
						searchBasicTariffNotiListVOs[i].setUpdUsrId(account.getUpd_usr_id());
						searchBasicTariffNotiListVOs[i].setUpdOfcCd(account.getOfc_cd());
						updateVoList.add(searchBasicTariffNotiListVOs[i]);
					} 
				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.updateBasicTariffNotiList(updateVoList);
				}
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		}	
	}
	

	/**
	 * [trf_rule_no]를 [search]합니다.<br>
	 * @return List<CommodityTariffVO>
	 * @throws EventException
	 */
	public List<CommodityTariffVO> searchCommodityTrfRuleNo() throws EventException {
		try {
			return dbDao.searchCommodityTrfRuleNo();
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		}
	}
}
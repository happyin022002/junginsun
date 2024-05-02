/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtBCImpl.java
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic;

import java.util.List;
import java.util.ArrayList;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration.DemDetTariffMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffRegionVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.CommodityTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSL01VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSL02VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLMapSetVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLRateVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffXSLVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent02VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent03VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent04VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent05VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinent06VO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentMapSetVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffCombinationVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRegionVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ToDmtTariffTypeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * DMTMasterDataMgt Business Logic Basic Command implementation<br>
 *
 * @author
 * @see reference DAO class of EesDmt1003EventResponse,EesDmt1004EventResponse,EesDmt1001EventResponse,DemDetTariffMgtBC
 * @since J2EE 1.4
 */
public class DemDetTariffMgtBCImpl extends BasicCommandSupport implements DemDetTariffMgtBC {

	// Database Access Object
	private transient DemDetTariffMgtDBDAO dbDao = null;
	
	/**
	 * DemDetTariffMgtBCImpl Create object<br>
	 * DemDetTariffMgtDBDAO Create.<br>
	 */
	public DemDetTariffMgtBCImpl() {
		dbDao = new DemDetTariffMgtDBDAO();
	}
	/**
	 * search BasicTariffSummryList <br>
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
	 * search Basic Tariff Detail(s) <br>
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
     * [Basic Tariff Detail(s)] [search]<br>
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
                
                log.debug("\n ####### searchBasicTariffDetailList02 tVal01 [" + tVal01 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal02 [" + tVal02 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal03 [" + tVal03 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal04 [" + tVal04 + "] " +
                          "\n ####### searchBasicTariffDetailList02 tVal05 [" + tVal05 + "] \n" 
                         );

                SearchContinentMapSetVO list = dbDao.searchBasicTariffDetailList03( tVal01 , tVal02 , tVal03 , tVal04 , tVal05 , searchContinentParamVO ); // Map Set VO            

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
                        } else {
                            vo.setOverDay       ( list06.get(i18).getOverDay       () );
                            vo.setCntr20ftRtAmt ( list06.get(i18).getCntr20ftRtAmt () );
                            vo.setCntr40ftRtAmt ( list06.get(i18).getCntr40ftRtAmt () );
                            vo.setCntrHcRtAmt   ( list06.get(i18).getCntrHcRtAmt   () );
                            vo.setCntr45ftRtAmt ( list06.get(i18).getCntr45ftRtAmt () );
                        }
                    } else {
                        log.debug("\n ####### xtc list06 ["+i18+"] false");
                        vo.setCurrCd        ( "" );
                        vo.setOverDay       ( "" );
                        vo.setCntr20ftRtAmt ( "" );
                        vo.setCntr40ftRtAmt ( "" );
                        vo.setCntrHcRtAmt   ( "" );
                        vo.setCntr45ftRtAmt ( "" );
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
	 * [BasicTariff] [search]<br>
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
     * [BasicTariff] [search]<br>
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
                        } else {
                            vo.setOverDay       ( list06.get(i18).getOverDay       () );
                            vo.setCntr20ftRtAmt ( list06.get(i18).getCntr20ftRtAmt () );
                            vo.setCntr40ftRtAmt ( list06.get(i18).getCntr40ftRtAmt () );
                            vo.setCntrHcRtAmt   ( list06.get(i18).getCntrHcRtAmt   () );
                            vo.setCntr45ftRtAmt ( list06.get(i18).getCntr45ftRtAmt () );
                        }
                    } else {
                        logStr.append("\n ####### xtc list06 ["+i18+"] false");
                        vo.setCurrCd        ( "" );
                        vo.setOverDay       ( "" );
                        vo.setCntr20ftRtAmt ( "" );
                        vo.setCntr40ftRtAmt ( "" );
                        vo.setCntrHcRtAmt   ( "" );
                        vo.setCntr45ftRtAmt ( "" );
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
	 * [BasicTariffFreeTime] [search]<br>
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
	 * [BasicTariffRate] [search]<br>
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
	 * [BasicTariff] [confirm]<br>
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
	 * [BasicTariff] [confirmCancel]<br>
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
	 * [BasicTariff] [confirmRgn]<br>
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
	 * [BasicTariff] [confirmCancelRgn]<br>
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
	 * [BasicTariff] [remove]<br>
	 * @param BasicTariffVO[] basicTariffVOs
	 * @throws EventException
	 */
	public void removeBasicTariff(BasicTariffVO[] basicTariffVOs) throws EventException {
		log.debug("bc removeBasicTariff()");
		
		BasicTariffVO basicTariffVO = new BasicTariffVO();

		try {
			if( basicTariffVOs.length > 0) {
				basicTariffVO = basicTariffVOs[0];
				
				//CMB Delete
				TariffCombinationVO tariffCombinationVO = new TariffCombinationVO();
				tariffCombinationVO.setSvrId(basicTariffVO.getSvrId());
				tariffCombinationVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
				tariffCombinationVO.setTrfSeq(basicTariffVO.getTrfSeq());
				tariffCombinationVO.setTrfGrpSeq(basicTariffVO.getTrfGrpSeq());
				dbDao.removeTariffCombination(tariffCombinationVO);
				
				//FREE_TM Delete
				TariffFreeTimeVO tariffFreeTimeVO = new TariffFreeTimeVO();
				tariffFreeTimeVO.setSvrId(basicTariffVO.getSvrId());
				tariffFreeTimeVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
				tariffFreeTimeVO.setTrfSeq(basicTariffVO.getTrfSeq());
				tariffFreeTimeVO.setTrfGrpSeq(basicTariffVO.getTrfGrpSeq());
				tariffFreeTimeVO.setTrfFtSeq("");
				dbDao.removeTariffFreeTime(tariffFreeTimeVO);
				
				//RT Delete
				TariffRateVO tariffRateVO = new TariffRateVO();
				tariffRateVO.setSvrId(basicTariffVO.getSvrId());
				tariffRateVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
				tariffRateVO.setTrfSeq(basicTariffVO.getTrfSeq());
				tariffRateVO.setTrfGrpSeq(basicTariffVO.getTrfGrpSeq());
				tariffRateVO.setTrfRtSeq("");
				dbDao.removeTariffRate(tariffRateVO);
				
				//Grp Delete
				dbDao.removeTariffGroup(basicTariffVO);
				
				// check RGN Delete
				//1.check GRP is exist.
				String grp_yn = dbDao.searchGrpYNByRgn(basicTariffVO);
				//2. checking CMDT_GRP is exist.
				String cmdt_yn = dbDao.searchCmdtYNByRgn(basicTariffVO);
				
				if(grp_yn.equals("N") && cmdt_yn.equals("N")) {
					//RGN Delete
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
	 * [TrfRgnCfmHis] [add]<br>
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
	 * [TrfGrpCfmHis] [add]<br>
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
	 * [ MAX RGN_CFM_SEQ of DMT_TRF_RGN_CFM_HIS ] [search]<br>
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
	 * [ search WeekEnd by Cnt_cd ]<br>
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
	 * [CombinationSet] [search]<br>
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
	 * [Update CombinationSet] [search]<br>
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
	 * [Tariff Combination] [search]<br>
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
	 * [DmtTrfGrp] [search]<br>
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
	 * [BasicTariff] [Create]<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createBasicTariff(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException{
		String sResult = "";
		String svr_id = "";
		int trf_seq = 0;
		int trf_grp_seq = 0;
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		TariffRegionVO tariffRegionVO = new TariffRegionVO();
		List<BasicTariffVO> checkBasicTariffVOList	= null;
		BasicTariffVO checkBasicTariffVO = new BasicTariffVO();
		
		try {
			if(tariffMgtVO == null) throw new Exception("");
			
			//Tariff Group object List
			TariffGroupVO tariffGroupVO 					= tariffMgtVO.getTariffGroupVO();
			DmtTariffTypeVO dmtTariffTypeVO 				= tariffMgtVO.getDmtTariffTypeVO();
			List<TariffCombinationVO> tariffCombinationVOs 	= tariffMgtVO.getTariffCombinationVOs();
			List<TariffFreeTimeVO> tariffFreeTimeVOs 		= tariffMgtVO.getTariffFreeTimeVOs();
			List<TariffRateVO> tariffRateVOs 				= tariffMgtVO.getTariffRateVOs();

			
			//1-2. eff_date check logic 
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
					//Search previous Created value for compareing.
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
			
			
			//2. svr_id Search
			svr_id = dbDao.searchComNisSvrId(dmtTariffTypeVO.getCntCd());
			
			if(svr_id == null || svr_id.equals("")) 
				throw new Exception("");
			
			//3. search TrfRgn
			int count = dbDao.searchTariffRegionCount(dmtTariffTypeVO);
			
			dmtTariffTypeVO.setSvrId(svr_id);

			//4. max trf_region sequence
			basicTariffVO.setSvrId(svr_id);
			basicTariffVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
			
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
				tariffRegionVO.setUiCode(dmtTariffTypeVO.getUiCode());	
				
				if (tariffRegionVO.getCurrCd()==null || "".equals(tariffRegionVO.getCurrCd())) {
					sResult = "Currency Code does not exists!";	//2016.06.17
					return sResult;
				}
				
				//5. Triff Region Creation.
				dbDao.addDmtTrfRgn(tariffRegionVO);
				
				log.debug("====> addDmtTrfRgn");

				trf_grp_seq = 1;
			}else {
				
				//4. max sequence
				trf_seq = dbDao.searchTrfRgnMaxSequence(dmtTariffTypeVO);
				
				log.debug("====> searchTrfRgnMaxSequence");

				
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
	 * [BasicTariff] [modify]<br>
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
		
		String svr_id = "";
		String dmdt_trf_cd = "";
		String trf_seq = "";
		String trf_grp_seq = "";

		try {
			if(tariffMgtVO == null) throw new Exception("");
			
			//Tariff Group  List
			TariffGroupVO tariffGroupVO 					= tariffMgtVO.getTariffGroupVO();
			DmtTariffTypeVO dmtTariffTypeVO 				= tariffMgtVO.getDmtTariffTypeVO();
			List<TariffCombinationVO> tariffCombinationVOs 	= tariffMgtVO.getTariffCombinationVOs();
			List<TariffFreeTimeVO> tariffFreeTimeVOs 		= tariffMgtVO.getTariffFreeTimeVOs();
			List<TariffRateVO> tariffRateVOs 				= tariffMgtVO.getTariffRateVOs();
			
			// Search key values
			svr_id = tariffGroupVO.getSvrId();
			dmdt_trf_cd = tariffGroupVO.getDmdtTrfCd();
			trf_seq = tariffGroupVO.getTrfSeq();
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
			
			//1-2. eff_date check logic 
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
					//Search previous Created value for compareing.
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
			dbDao.modifyTariffGroup(tariffGroupVO);
			
			if(tariffCombinationVOs != null) {
				//Delete all.
				TariffCombinationVO tariffCombinationVO = new TariffCombinationVO();
				
				tariffCombinationVO.setSvrId(svr_id);
				tariffCombinationVO.setDmdtTrfCd(dmdt_trf_cd);
				tariffCombinationVO.setTrfSeq(trf_seq);
				tariffCombinationVO.setTrfGrpSeq(trf_grp_seq);
				
				dbDao.removeTariffCombination(tariffCombinationVO);
				
				// Create new.
				
				//2. Tariff Group Combination process
				for(int i = 0 ; i < tariffCombinationVOs.size() ; i++ ) {
					log.debug("............2................");
					tariffCombinationVO = (TariffCombinationVO)tariffCombinationVOs.get(i);
					
					tariffCombinationVO.setSvrId(svr_id);
					tariffCombinationVO.setDmdtTrfCd(dmdt_trf_cd);
					tariffCombinationVO.setTrfSeq(trf_seq);
					tariffCombinationVO.setTrfGrpSeq(trf_grp_seq);
					tariffCombinationVO.setUsrId(account.getUsr_id());
					tariffCombinationVO.setOfcCd(account.getOfc_cd());
	
					dbDao.addDmtTrfCmb(tariffCombinationVO);
				}
			}
			
			if(tariffFreeTimeVOs != null) {
				log.debug("............3................");
				TariffFreeTimeVO tariffFreeTimeVO = new TariffFreeTimeVO();
				//Delete all Group Seq.
				tariffFreeTimeVO.setSvrId(tariffGroupVO.getSvrId());
				tariffFreeTimeVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
				tariffFreeTimeVO.setTrfSeq(tariffGroupVO.getTrfSeq());
				tariffFreeTimeVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
				dbDao.removeTariffFreeTime(tariffFreeTimeVO);
				
				//3. Tariff Free Time process
				for(int i = 0 ; i < tariffFreeTimeVOs.size(); i++) {
					tariffFreeTimeVO = (TariffFreeTimeVO)tariffFreeTimeVOs.get(i);
					
					tariffFreeTimeVO.setSvrId(tariffGroupVO.getSvrId());
					tariffFreeTimeVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
					tariffFreeTimeVO.setTrfSeq(tariffGroupVO.getTrfSeq());
					tariffFreeTimeVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
					tariffFreeTimeVO.setUsrId(account.getUsr_id());
					tariffFreeTimeVO.setOfcCd(account.getOfc_cd());
					
					dbDao.addDmtTrfFreeTm(tariffFreeTimeVO);
				}
			}
			
			if(tariffRateVOs != null) {
				log.debug("............4................");
				TariffRateVO tariffRateVO = new TariffRateVO();
				//Delete all Group Seq.
				tariffRateVO.setSvrId(tariffGroupVO.getSvrId());
				tariffRateVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
				tariffRateVO.setTrfSeq(tariffGroupVO.getTrfSeq());
				tariffRateVO.setTrfGrpSeq(tariffGroupVO.getTrfGrpSeq());
				
				dbDao.removeTariffRate(tariffRateVO);

				//4. Tariff Rate process
				for(int i = 0 ; i < tariffRateVOs.size(); i++) {
					tariffRateVO = (TariffRateVO)tariffRateVOs.get(i);
					
					tariffRateVO.setSvrId(tariffGroupVO.getSvrId());
					tariffRateVO.setDmdtTrfCd(tariffGroupVO.getDmdtTrfCd());
					tariffRateVO.setTrfSeq(tariffGroupVO.getTrfSeq());
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
	 * [BasicTariff] [Expire]<br>
	 * @param TariffMgtVO tariffMgtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyBasicTariffExpire(TariffMgtVO tariffMgtVO, SignOnUserAccount account) throws EventException {
		BasicTariffVO basicTariffVO = new BasicTariffVO();
		try {
			if(tariffMgtVO == null) throw new Exception("");
			
			//Tariff Group List
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
	 * [BasicTariff] [copy]<br>
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
		BasicTariffVO toBasicTariffVO 		= new BasicTariffVO();		//To TariffGroup Search용
		BasicTariffVO basicTariffVO 		= new BasicTariffVO();		//From TariffGroup Search용
		List<BasicTariffVO> fromBasicTariffVOList	= null;				//From BasicTariff
		List<BasicTariffVO> toBasicTariffVOList		= null;
		TariffGroupVO tariffGroupVO 		= new TariffGroupVO();
		TariffCombinationVO combinationVO	= new TariffCombinationVO();
		TariffFreeTimeVO freeTimeVO			= new TariffFreeTimeVO();
		TariffRateVO rateVO					= new TariffRateVO();
		String fromTrfSeq = "";
		String fromTrfGrpSeq = "";
		String svr_id = "";
		
		try {
			if(dmtTariffTypeVO == null) throw new Exception("");
			
			//------------- From Tariff Mode Checking
			fromBasicTariffVOList = dbDao.searchBasicTariff(dmtTariffTypeVO);
			
log.debug("fromBasicTariffVOList size-------------------->"+fromBasicTariffVOList.size());

			//------------- To Tariff Empty Checking
			DmtTariffTypeVO dmtTariffTypeVO2 = new DmtTariffTypeVO();
			dmtTariffTypeVO2.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
			dmtTariffTypeVO2.setCvrgContiCd(toDmtTariffTypeVO.getToCvrgContiCd());
			dmtTariffTypeVO2.setCvrgCntCd(toDmtTariffTypeVO.getToCvrgCntCd());
			dmtTariffTypeVO2.setCvrgRgnCd(toDmtTariffTypeVO.getToCvrgRgnCd());
			dmtTariffTypeVO2.setCvrgSteCd(toDmtTariffTypeVO.getToCvrgSteCd());
			dmtTariffTypeVO2.setCvrgLocCd(toDmtTariffTypeVO.getToCvrgLocCd());
			dmtTariffTypeVO2.setCvrgYdCd(toDmtTariffTypeVO.getToCvrgYdCd());
			dmtTariffTypeVO2.setOrgDestContiCd(toDmtTariffTypeVO.getToOrgDestContiCd());
			dmtTariffTypeVO2.setOrgDestCntCd(toDmtTariffTypeVO.getToOrgDestCntCd());
			dmtTariffTypeVO2.setOrgDestRgnCd(toDmtTariffTypeVO.getToOrgDestRgnCd());
			dmtTariffTypeVO2.setOrgDestSteCd(toDmtTariffTypeVO.getToOrgDestSteCd());
			dmtTariffTypeVO2.setOrgDestLocCd(toDmtTariffTypeVO.getToOrgDestLocCd());
			dmtTariffTypeVO2.setCntCd(toDmtTariffTypeVO.getToCvrgCntCd());
			dmtTariffTypeVO2.setAllFlg("Y");
			dmtTariffTypeVO2.setUiCode(dmtTariffTypeVO.getUiCode());
			dmtTariffTypeVO2.setCurrCd(fromBasicTariffVOList.get(0).getCurrCd());

			if (dmtTariffTypeVO2.getCurrCd()==null || "".equals(dmtTariffTypeVO2.getCurrCd())) {
				sResult = "Currency Code does not exists!";	//2016.06.17
				return sResult;
			}
			
			toBasicTariffVOList = dbDao.searchBasicTariff(dmtTariffTypeVO2);
			
log.debug("toBasicTariffVOList size-------------------->"+toBasicTariffVOList.size());
			int toTariffCheck 	= 0; 
			int expDtCnt	  	= 0;
			
			// check exp_dt 
			//1. no To tariff 
			if(toBasicTariffVOList == null || toBasicTariffVOList.size() == 0) {
				toTariffCheck = 1;	//TO TARIFF exists
				
			//2. To tariff exists
			} else {
				for(int i=0; i < toBasicTariffVOList.size(); i++) {
					toBasicTariffVO = (BasicTariffVO)toBasicTariffVOList.get(i);
					if(!toBasicTariffVO.getExpDt().equals(" ")) {
						expDtCnt++;
					}
				}
log.debug("---------------1-------------------->");
				
				
				String to_exp_dt = "";
				String from_eff_dt = "";
				// exp_dt exists
				if(expDtCnt > 0) {
log.debug("---------------2-------------------->");
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
				//no exp_dt of data exists
				if(toBasicTariffVOList.size() - expDtCnt > 0){
log.debug("---------------3------------------->");
					sResult = "To Tariff already exists!";	//DMT06023  To Tariff already exists!
					return sResult;
				}
				toTariffCheck = 2;	// TO TRIFF not exists
			}
			
			if(toTariffCheck == 1) {
log.debug("---------------4-------------------->");
				
				//2-1. To svr_id Search
				svr_id = dbDao.searchComNisSvrId(dmtTariffTypeVO2.getCntCd());
				
				BasicTariffVO basicTariffVO2 = new BasicTariffVO();
				basicTariffVO2.setDmdtTrfCd(dmtTariffTypeVO.getDmdtTrfCd());
				basicTariffVO2.setSvrId(svr_id);
				
				//3-1. To max rgn sequence Search
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
				toTariffRegionVO.setUiCode(dmtTariffTypeVO2.getUiCode());	// (1001:N, 4014:Y)
				toTariffRegionVO.setCurrCd(dmtTariffTypeVO2.getCurrCd());

				if (toTariffRegionVO.getCurrCd()==null || "".equals(toTariffRegionVO.getCurrCd())) {
					sResult = "Currency Code does not exists!";	//2016.06.17
					return sResult;
				}
				
				//4-1. To add Tariff Rgn
				dbDao.addDmtTrfRgn(toTariffRegionVO);

log.debug("---------------5------------------->");
				//search From Tariff Group
				for(int i = 0; i < fromBasicTariffVOList.size() ; i++) {
log.debug("---------------6-------------------->");
					basicTariffVO =(BasicTariffVO)fromBasicTariffVOList.get(i);
					
					if(fromTrfGrpSeq.equals(basicTariffVO.getTrfGrpSeq())) {
						continue;
					}
					
					fromTrfSeq = basicTariffVO.getTrfSeq();
					fromTrfGrpSeq = basicTariffVO.getTrfGrpSeq();
					
					basicTariffVO.setTrfSeq(String.valueOf(trfSeq));
					
					//6-1. max TO trf_grp_seq
					trfGrpSeq = dbDao.searchTrfGrpSequence(basicTariffVO) + 1;
					
					tariffGroupVO = new TariffGroupVO();
					tariffGroupVO.setSvrId(basicTariffVO.getSvrId());
					tariffGroupVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					tariffGroupVO.setTrfSeq(basicTariffVO.getTrfSeq());
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
					
					if (tariffGroupVO.getCurrCd()==null || "".equals(tariffGroupVO.getCurrCd())) {
						sResult = "Currency Code does not exists!";	//2016.06.17
						return sResult;
					}
					
					//7-1. add TO Tariff Group
					dbDao.addDmtTrfGrp(tariffGroupVO);
					
					combinationVO = new TariffCombinationVO();
					combinationVO.setSvrId(basicTariffVO.getSvrId());
					combinationVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					combinationVO.setTrfSeq(basicTariffVO.getTrfSeq());
					combinationVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					combinationVO.setUsrId(account.getUsr_id());
					combinationVO.setOfcCd(account.getOfc_cd());
					
					//8-1. add TO Tariff Combination
					dbDao.addListDmtTrfCmb(combinationVO, fromTrfSeq, fromTrfGrpSeq);
					
					freeTimeVO = new TariffFreeTimeVO();
					freeTimeVO.setSvrId(basicTariffVO.getSvrId());
					freeTimeVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					freeTimeVO.setTrfSeq(basicTariffVO.getTrfSeq());
					freeTimeVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					freeTimeVO.setUsrId(account.getUsr_id());
					freeTimeVO.setOfcCd(account.getOfc_cd());
					
					//9-1. add TO Tariff Free Time
					dbDao.addListDmtTrfFreeTm(freeTimeVO, fromTrfSeq, fromTrfGrpSeq);

					rateVO = new TariffRateVO();
					rateVO.setSvrId(basicTariffVO.getSvrId());
					rateVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					rateVO.setTrfSeq(basicTariffVO.getTrfSeq());
					rateVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					rateVO.setUsrId(account.getUsr_id());
					rateVO.setOfcCd(account.getOfc_cd());
					
					//10-1. add TO Tariff Rate
					dbDao.addListDmtTrfRt(rateVO, fromTrfSeq, fromTrfGrpSeq);
				}
			}
			else{
				//if To Tariff exists, then Search To Tariff Seq
				
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
				
				
				
log.debug("---------------7-------------------->");
				//search From Tariff Group
				for(int i = 0; i < fromBasicTariffVOList.size() ; i++) {
log.debug("---------------8-------------------->");
					basicTariffVO = (BasicTariffVO)fromBasicTariffVOList.get(i);
					
					
					if(fromTrfGrpSeq.equals(basicTariffVO.getTrfGrpSeq())) {
						continue;
					}
					
					fromTrfSeq = basicTariffVO.getTrfSeq();
					fromTrfGrpSeq = basicTariffVO.getTrfGrpSeq();
					
					//To Tariff seq Search and set
					basicTariffVO.setTrfSeq(String.valueOf(trfSeq));
					
					//max trf_grp_seq
					trfGrpSeq = dbDao.searchTrfGrpSequence(basicTariffVO) + 1;
					
					tariffGroupVO = new TariffGroupVO();
					tariffGroupVO.setSvrId(basicTariffVO.getSvrId());
					tariffGroupVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					tariffGroupVO.setTrfSeq(basicTariffVO.getTrfSeq());
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
					
					if (tariffGroupVO.getCurrCd()==null || "".equals(tariffGroupVO.getCurrCd())) {
						sResult = "Currency Code does not exists!";	//2016.06.17
						return sResult;
					}
					
					//add Tariff Group
					dbDao.addDmtTrfGrp(tariffGroupVO);
					
					combinationVO = new TariffCombinationVO();
					combinationVO.setSvrId(basicTariffVO.getSvrId());
					combinationVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					combinationVO.setTrfSeq(basicTariffVO.getTrfSeq());
					combinationVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					combinationVO.setUsrId(account.getUsr_id());
					combinationVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Combination
					dbDao.addListDmtTrfCmb(combinationVO, fromTrfSeq, fromTrfGrpSeq);
					
					freeTimeVO = new TariffFreeTimeVO();
					freeTimeVO.setSvrId(basicTariffVO.getSvrId());
					freeTimeVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					freeTimeVO.setTrfSeq(basicTariffVO.getTrfSeq());
					freeTimeVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					freeTimeVO.setUsrId(account.getUsr_id());
					freeTimeVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Free Time
					dbDao.addListDmtTrfFreeTm(freeTimeVO, fromTrfSeq, fromTrfGrpSeq);

					rateVO = new TariffRateVO();
					rateVO.setSvrId(basicTariffVO.getSvrId());
					rateVO.setDmdtTrfCd(basicTariffVO.getDmdtTrfCd());
					rateVO.setTrfSeq(basicTariffVO.getTrfSeq());
					rateVO.setTrfGrpSeq(String.valueOf(trfGrpSeq));
					rateVO.setUsrId(account.getUsr_id());
					rateVO.setOfcCd(account.getOfc_cd());
					
					//add Tariff Rate
					dbDao.addListDmtTrfRt(rateVO, fromTrfSeq, fromTrfGrpSeq);
				}
			}
log.debug("---------------9-------------------->");
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
	 * [CommodityTariffList] [search]<br>
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
			
			//2. DMT_TRF_RGN Search
			tariffRegionVOList = dbDao.checkBasicTariff(dmtTariffTypeVO);
			
			if(tariffRegionVOList == null || tariffRegionVOList.size() ==  0 ) {
				//throw new EventException("Basic Tariff not registered for this coverage!");
				
				CommodityTariffVO commodityTariffVO = new CommodityTariffVO();
				commodityTariffVO.setReturnCd("DMT06031");
	
				commodityTariffVOList = new ArrayList<CommodityTariffVO>();
				commodityTariffVOList.add(0, commodityTariffVO);
				
				return commodityTariffVOList;
			}
			
			//3. Commodity Exception Search
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
	 * [CommodityTariff] [Create]<br>
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
	 * [CommodityTariffRegionList] [search]<br>
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
}

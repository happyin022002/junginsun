/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAO.java
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.basic.DemDetTariffMgtBCImpl;
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
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRegionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * DemDetTariffMgtDBDAO <br>
 * - DMTMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Tae Kyun
 * @see DemDetTariffMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class DemDetTariffMgtDBDAO extends DBDAOSupport {

	/**
	 * [BasicTariffSummuryList] 정보를 [search]합니다. <br> 
	 * 
	 * @param SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO
	 * @return List<SearchBasicTariffSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBasicTariffSummaryListVO> searchBasicTariffSummuryList(SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicTariffSummaryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchBasicTariffSummaryParamVO != null){
				Map<String, String> mapVO = searchBasicTariffSummaryParamVO .getColumnValues();
				
				//Tariff Type
				String dmdtTrfCdList = (String)searchBasicTariffSummaryParamVO.getDmdtTrfCdList();
				
				//log.debug("dmdtTrfCdList===>"+dmdtTrfCdList);
				List<String> arydmdtTrfCd = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(dmdtTrfCdList, ",");
				String tempS = "";
				String inFlag = "Y";
			    while (st.hasMoreTokens()) {
			    	tempS = st.nextToken(); 
			    	if(tempS.equals("All")) {
			    		continue;
			    	}
			    	
			    	arydmdtTrfCd.add(tempS);
			    }

			    if(arydmdtTrfCd.size() == 0) {
		    		inFlag = "N";
			    }
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("dmdt_trf_cd_list", arydmdtTrfCd);
	    		velParam.put("dmdt_trf_cd_in", inFlag);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffSummaryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicTariffSummaryListVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	/**
	 * [Basic Tariff Detail(s)] 정보를 [search]합니다. <br> 
	 * 
	 * @param SearchContinentParamVO searchContinentParamVO
	 * @return List<SearchContinentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchContinentVO> searchBasicTariffDetailList(SearchContinentParamVO searchContinentParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContinentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;
		String tempS = "";
		String tempS2 = "";
		
		String inFlag = "Y";
		List<String> aryTrfCd = new ArrayList();
		List<String> aryCntrCd = new ArrayList();
		List<String> aryCgoCd = new ArrayList();
		
		try{
			if(searchContinentParamVO != null){
				Map<String, String> mapVO = searchContinentParamVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Tariff Type
				String dmdtTrfCdList = (String)searchContinentParamVO.getDmdtTrfCdList();
				
				st1 = new StringTokenizer(dmdtTrfCdList, ",");
			    while (st1.hasMoreTokens()) {
			    	tempS = st1.nextToken(); 
			    	if(tempS.equals("All")) {
			    		continue;
			    	}
			    	aryTrfCd.add(tempS);
			    }
			    if(dmdtTrfCdList.length()==0) {
		    		inFlag = "N";
			    }
			    
			    
				velParam.put("dmdt_trf_cd_list", aryTrfCd);
	    		velParam.put("dmdt_trf_cd_in", inFlag);
			    
			    //Containter & Cargo Type
			    String cntrCgoList = (String)searchContinentParamVO.getDmdtCntrCgoList();
			    
			    inFlag = "Y";
			    
			    st1 = new StringTokenizer(cntrCgoList, ",");
			    
			    int i = 0;
			    while (st1.hasMoreTokens()) {
			    	tempS = st1.nextToken();
			    	
			    	if(tempS.equals("All")) {
			    		continue;
			    	}
			    	
			    	i = 0;
			    	
			    	st2 = new StringTokenizer(tempS, ":");
			    	while(st2.hasMoreTokens()) {
			    		tempS2 = st2.nextToken();
			    		if(i == 0) {
			    			aryCntrCd.add(tempS2);
			    		} else {
			    			aryCgoCd.add(tempS2);
			    		}
				    	i++;
			    	}
			    }
			    if(cntrCgoList.length()==0) {
		    		inFlag = "N";
			    }
			    
				velParam.put("dmdt_cntr_tp_list", aryCntrCd);
	    		velParam.put("dmdt_cntr_tp_cd_in", inFlag);
	    		velParam.put("dmdt_cgo_tp_list", aryCgoCd);
	    		velParam.put("dmdt_cgo_tp_cd_in", inFlag);
	    		
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContinentVO .class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	
    /**
     * [Basic Tariff Detail(s)] 정보를 [search]합니다. <br> 
     * 
     * @param SearchContinentParamVO searchContinentParamVO
     * @return List<SearchContinentVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchContinent02VO> searchBasicTariffDetailList02 ( SearchContinentParamVO searchContinentParamVO ) throws DAOException {
        DBRowSet dbRowset02 = null;
        List<SearchContinent02VO> list02 = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        StringTokenizer st1 = null;
        StringTokenizer st2 = null;
        String tempS = "";
        String tempS2 = "";
        
        String inFlag = "Y";
        List<String> aryTrfCd = new ArrayList();
        
        try{
            if(searchContinentParamVO != null){
                Map<String, String> mapVO = searchContinentParamVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                //Tariff Type
                String dmdtTrfCdList = (String)searchContinentParamVO.getDmdtTrfCdList();
                
                if(mapVO.get("ui_code").equals("1004")){
                	st1 = new StringTokenizer(dmdtTrfCdList, ",");
                    while (st1.hasMoreTokens()) {
                        tempS = st1.nextToken(); 

                        aryTrfCd.add(tempS);
                    }
                    if(dmdtTrfCdList.length()==0) {
                        inFlag = "N";
                    }
                    
                    velParam.put("dmdt_trf_cd_list", aryTrfCd);
                    velParam.put("dmdt_trf_cd_in", inFlag);
                    param.put("dmdt_trf_cd_list", aryTrfCd);
                
                }else if(mapVO.get("ui_code").equals("4015")){

                	velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                    velParam.put("dmdt_trf_cd_in", inFlag);
                    param.put("dmdt_trf_cd_list", dmdtTrfCdList);
                }
                
                //Containter & Cargo Type
                String cntrCgoList = (String)searchContinentParamVO.getDmdtCntrCgoList();
                
                inFlag = "Y";
                
                st1 = new StringTokenizer(cntrCgoList, ",");
                String[] arr_cntr = new String[10];
                String[] arr_cgo = new String[10];
                
                //초기화
                for(int i = 0 ; i < arr_cntr.length ; i++) {
                	arr_cntr[i] = "";
                	arr_cgo[i] = "";
                }
                int len = 0;
                int temp_size = 0;
                
                while (st1.hasMoreTokens()) {
                	tempS = st1.nextToken();
                	
                	if(tempS.equals("All")) {
                		continue;
                	}
                	len = 0;
                	
                	st2 = new StringTokenizer(tempS, ":");
                	while(st2.hasMoreTokens()) {
                		tempS2 = st2.nextToken();
                		if(len == 0) {
                			arr_cntr[temp_size] = tempS2;
                		} else {
                			arr_cgo[temp_size] = tempS2;
                		}
                		len++;
                	}
                	temp_size++;
                }
                
                if(cntrCgoList.length() == 0 ){
                	inFlag = "N"; 
                }
                	
                velParam.put("dmdt_cntr_cgo_cd_in", inFlag);
                velParam.put("dmdt_cntr_cgo_cd_size", String.valueOf(temp_size));
                
                param.put("dmdt_cntr_tp_cd1", arr_cntr[0]);
                param.put("dmdt_cntr_tp_cd2", arr_cntr[1]);
                param.put("dmdt_cntr_tp_cd3", arr_cntr[2]);
                param.put("dmdt_cntr_tp_cd4", arr_cntr[3]);
                param.put("dmdt_cntr_tp_cd5", arr_cntr[4]);
                param.put("dmdt_cntr_tp_cd6", arr_cntr[5]);
                param.put("dmdt_cntr_tp_cd7", arr_cntr[6]);
                param.put("dmdt_cntr_tp_cd8", arr_cntr[7]);
                param.put("dmdt_cntr_tp_cd9", arr_cntr[8]);
                param.put("dmdt_cntr_tp_cd10", arr_cntr[9]);
                
                param.put("dmdt_cgo_tp_cd1", arr_cgo[0]);
                param.put("dmdt_cgo_tp_cd2", arr_cgo[1]);
                param.put("dmdt_cgo_tp_cd3", arr_cgo[2]);
                param.put("dmdt_cgo_tp_cd4", arr_cgo[3]);
                param.put("dmdt_cgo_tp_cd5", arr_cgo[4]);
                param.put("dmdt_cgo_tp_cd6", arr_cgo[5]);
                param.put("dmdt_cgo_tp_cd7", arr_cgo[6]);
                param.put("dmdt_cgo_tp_cd8", arr_cgo[7]);
                param.put("dmdt_cgo_tp_cd9", arr_cgo[8]);
                param.put("dmdt_cgo_tp_cd10", arr_cgo[9]);
                
            }
        
            dbRowset02 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffDetailList02RSQL(), param, velParam); // Basic Tariff Group
            
            list02 = (List)RowSetUtil.rowSetToVOs(dbRowset02, SearchContinent02VO .class);

        }catch(SQLException ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list02;
    }
	
    /**
     * [Basic Tariff Detail(s)] 정보를 [search]합니다. <br> 
     * 
     * @param String tVal01 
     * @param String tVal02 
     * @param String tVal03 
     * @param String tVal04 
     * @param String tVal05 
     * @param SearchContinentParamVO searchContinentParamVO
     * @return SearchContinentMapSetVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public SearchContinentMapSetVO searchBasicTariffDetailList03 ( String tVal01 , String tVal02 , String tVal03 , String tVal04 , String tVal05 , SearchContinentParamVO searchContinentParamVO ) throws DAOException {

        DBRowSet dbRowset03 = null;
        DBRowSet dbRowset04 = null;
        DBRowSet dbRowset05 = null;
        DBRowSet dbRowset06 = null;

        List<SearchContinent03VO> list03 = null;
        List<SearchContinent04VO> list04 = null;
        List<SearchContinent05VO> list05 = null;
        List<SearchContinent06VO> list06 = null;
        SearchContinentMapSetVO list = new SearchContinentMapSetVO();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        StringTokenizer st1 = null;
        StringTokenizer st2 = null;
        String tempS = "";
        String tempS2 = "";
        
        String inFlag = "Y";
        List<String> aryTrfCd = new ArrayList();
        
        try{
            if(searchContinentParamVO != null){
                Map<String, String> mapVO = searchContinentParamVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                //Tariff Type
                String dmdtTrfCdList = (String)searchContinentParamVO.getDmdtTrfCdList();
                
                if(mapVO.get("ui_code").equals("1004")){
                	st1 = new StringTokenizer(dmdtTrfCdList, ",");
                    while (st1.hasMoreTokens()) {
                        tempS = st1.nextToken(); 

                        aryTrfCd.add(tempS);
                    }
                    if(dmdtTrfCdList.length()==0) {
                        inFlag = "N";
                    }
                    
                    velParam.put("dmdt_trf_cd_list", aryTrfCd);
                    velParam.put("dmdt_trf_cd_in", inFlag);
                    param.put("dmdt_trf_cd_list", aryTrfCd);
                
                }else if(mapVO.get("ui_code").equals("4015")){

                	velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                    velParam.put("dmdt_trf_cd_in", inFlag);
                    param.put("dmdt_trf_cd_list", dmdtTrfCdList);
                }

                //Containter & Cargo Type
                String cntrCgoList = (String)searchContinentParamVO.getDmdtCntrCgoList();
                
                inFlag = "Y";
                
                st1 = new StringTokenizer(cntrCgoList, ",");
                String[] arr_cntr = new String[10];
                String[] arr_cgo = new String[10];
                
                //초기화
                for(int i = 0 ; i < arr_cntr.length ; i++) {
                	arr_cntr[i] = "";
                	arr_cgo[i] = "";
                }
                int len = 0;
                int temp_size = 0;
                
                while (st1.hasMoreTokens()) {
                	tempS = st1.nextToken();
                	
                	if(tempS.equals("All")) {
                		continue;
                	}
                	len = 0;
                	
                	st2 = new StringTokenizer(tempS, ":");
                	while(st2.hasMoreTokens()) {
                		tempS2 = st2.nextToken();
                		if(len == 0) {
                			arr_cntr[temp_size] = tempS2;
                		} else {
                			arr_cgo[temp_size] = tempS2;
                		}
                		len++;
                	}
                	temp_size++;
                }
                
                if(cntrCgoList.length() == 0 ){
                	inFlag = "N"; 
                }
                	
                velParam.put("dmdt_cntr_cgo_cd_in", inFlag);
                velParam.put("dmdt_cntr_cgo_cd_size", String.valueOf(temp_size));
                
                param.put("dmdt_cntr_tp_cd1", arr_cntr[0]);
                param.put("dmdt_cntr_tp_cd2", arr_cntr[1]);
                param.put("dmdt_cntr_tp_cd3", arr_cntr[2]);
                param.put("dmdt_cntr_tp_cd4", arr_cntr[3]);
                param.put("dmdt_cntr_tp_cd5", arr_cntr[4]);
                param.put("dmdt_cntr_tp_cd6", arr_cntr[5]);
                param.put("dmdt_cntr_tp_cd7", arr_cntr[6]);
                param.put("dmdt_cntr_tp_cd8", arr_cntr[7]);
                param.put("dmdt_cntr_tp_cd9", arr_cntr[8]);
                param.put("dmdt_cntr_tp_cd10", arr_cntr[9]);
                
                param.put("dmdt_cgo_tp_cd1", arr_cgo[0]);
                param.put("dmdt_cgo_tp_cd2", arr_cgo[1]);
                param.put("dmdt_cgo_tp_cd3", arr_cgo[2]);
                param.put("dmdt_cgo_tp_cd4", arr_cgo[3]);
                param.put("dmdt_cgo_tp_cd5", arr_cgo[4]);
                param.put("dmdt_cgo_tp_cd6", arr_cgo[5]);
                param.put("dmdt_cgo_tp_cd7", arr_cgo[6]);
                param.put("dmdt_cgo_tp_cd8", arr_cgo[7]);
                param.put("dmdt_cgo_tp_cd9", arr_cgo[8]);
                param.put("dmdt_cgo_tp_cd10", arr_cgo[9]);                
                
                

            }
        
            param.put( "xVal01" , tVal01 );
            param.put( "xVal02" , tVal02 );
            param.put( "xVal03" , tVal03 );
            param.put( "xVal04" , tVal04 );
            param.put( "xVal05" , tVal05 );
            
            dbRowset03 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffDetailList03RSQL(), param, velParam); // CNTR & Cargo
            dbRowset04 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffDetailList04RSQL(), param, velParam); // F/T Commence & Exclusion
            dbRowset05 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffDetailList05RSQL(), param, velParam); // Free Time CNTR QTY & Free Day
            dbRowset06 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffDetailList06RSQL(), param, velParam); // Rate per Day
            
            list03 = (List)RowSetUtil.rowSetToVOs(dbRowset03, SearchContinent03VO .class);
            list04 = (List)RowSetUtil.rowSetToVOs(dbRowset04, SearchContinent04VO .class);
            list05 = (List)RowSetUtil.rowSetToVOs(dbRowset05, SearchContinent05VO .class);
            list06 = (List)RowSetUtil.rowSetToVOs(dbRowset06, SearchContinent06VO .class);
            
            list.setSearchContinent03VO(list03);
            list.setSearchContinent04VO(list04);
            list.setSearchContinent05VO(list05);
            list.setSearchContinent06VO(list06);
            
        }catch(SQLException ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
    }
    
	/**
	 * [BasicTariff] 정보를 [search]합니다. <br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BasicTariffVO> searchBasicTariff(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BasicTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();
				

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }
	
    /**
     * [BasicTariff] 정보를 [search]합니다. <br>
     * 
     * @param DmtTariffTypeVO dmtTariffTypeVO
     * @return List<SearchBasicTariffXSLVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SearchBasicTariffXSLVO> searchBasicTariffXSL(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchBasicTariffXSLVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if( dmtTariffTypeVO != null) {
                Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();
                

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffXSLRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicTariffXSLVO.class);
        }catch(SQLException ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
     }
    
    /**
     * [BasicTariff] 정보를 [search]합니다. <br>
     * 
     * @param String tVal01 
     * @param String tVal02
     * @param String tVal03
     * @param String tVal04
     * @param DmtTariffTypeVO dmtTariffTypeVO
     * @return SearchBasicTariffXSLMapSetVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public SearchBasicTariffXSLMapSetVO searchBasicTariffXSL02( String tVal01 , String tVal02 , String tVal03 , String tVal04 , DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
        
        DBRowSet dbRowset01 = null;
        DBRowSet dbRowset02 = null;
        DBRowSet dbRowset03 = null;
        DBRowSet dbRowset04 = null;

        List<SearchBasicTariffXSL01VO> list01 = null;
        List<SearchBasicTariffXSL02VO> list02 = null;
        List<SearchBasicTariffXSLFreeTimeVO> list03 = null;
        List<SearchBasicTariffXSLRateVO> list04 = null;
        SearchBasicTariffXSLMapSetVO list = new SearchBasicTariffXSLMapSetVO();
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if( dmtTariffTypeVO != null) {
                Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();
                

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
            param.put( "svr_id"      , tVal01 );
            param.put( "dmdt_trf_cd" , tVal02 );
            param.put( "trf_seq"     , tVal03 );
            param.put( "trf_grp_seq" , tVal04 );            
            
            dbRowset01 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffXSL01RSQL      () , param, velParam);
            dbRowset02 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffXSL02RSQL      () , param, velParam);
            dbRowset03 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffXSLFreeTimeRSQL() , param, velParam);
            dbRowset04 = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffXSLRateRSQL    () , param, velParam);
            
            list01 = (List)RowSetUtil.rowSetToVOs(dbRowset01, SearchBasicTariffXSL01VO       .class);
            list02 = (List)RowSetUtil.rowSetToVOs(dbRowset02, SearchBasicTariffXSL02VO       .class);
            list03 = (List)RowSetUtil.rowSetToVOs(dbRowset03, SearchBasicTariffXSLFreeTimeVO .class);
            list04 = (List)RowSetUtil.rowSetToVOs(dbRowset04, SearchBasicTariffXSLRateVO     .class);
            
            list.setSearchBasicTariffXSL01VO      (list01);
            list.setSearchBasicTariffXSL02VO      (list02);
            list.setSearchBasicTariffXSLFreeTimeVO(list03);
            list.setSearchBasicTariffXSLRateVO    (list04);
            
        }catch(SQLException ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(ex.getMessage(), ex);
        }
        return list;
     }

	/**
	 * [BasicTariffFreeTime] 정보를 [search]합니다. <br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffFreeTimeVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<TariffFreeTimeVO> searchBasicTariffFreeTime(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffFreeTimeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffFreeTimeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffFreeTimeVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }
	/**
	 * [BasicTariffRate] 정보를 [search]합니다. <br>
	 * 
	 * @param DmtTariffTypeVO dmtTariffTypeVO		
	 * @return List<TariffRateVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<TariffRateVO> searchBasicTariffRate(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffRateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffRateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffRateVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }
	/**
	 * [TariffGroup] 정보를 [confirm]합니다. <br>
	 * 
	 * @param BasicTariffVO basicTariffVO	
	 * @throws DAOException		
	 */
	public void confirmTariffGroup(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOConfirmBasicTariffUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to confirmTariffGroup SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [TariffGroup] 정보를 [confirmCancel]합니다. <br>
	 * 
	 * @param BasicTariffVO basicTariffVO	
	 * @throws DAOException		
	 */
	public void confirmCancelTariffGroup(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOConfirmCancelBasicTariffUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to confirmCancelTariffGroup SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [TariffRegion] 정보를 [confirm]합니다. <br>
	 * 
	 * @param BasicTariffVO basicTariffVO
	 * @throws DAOException		
	 */
	public void confirmTariffRegion(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOConfirmRgnBasicTariffUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to confirmTariffRegion SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [TariffRegion] 정보를 [confirmCancel]합니다. <br>
	 * 
	 * @param BasicTariffVO basicTariffVO
	 * @throws DAOException		
	 */
	public void confirmCancelTariffRegion(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOConfirmCancelRgnBasicTariffUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to confirmCancelTariffRegion SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [TariffGroup] 정보를 [remove]합니다. <br>
	 * 
	 * @param BasicTariffVO basicTariffVO	
	 * @throws DAOException		
	 */
	public void removeTariffGroup(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAORemoveTariffGroupDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to removeTariffGroup SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [TariffCombination] 정보를 [remove]합니다. <br>
	 * 
	 * @param TariffCombinationVO tariffCombinationVO	
	 * @throws DAOException		
	 */
	public void removeTariffCombination(TariffCombinationVO tariffCombinationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffCombinationVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAORemoveTariffCombinationDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to removeTariffCombinations SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [TariffFreeTime] 정보를 [remove]합니다. <br>
	 * 
	 * @param TariffFreeTimeVO tariffFreeTimeVO	
	 * @throws DAOException		
	 */
	public void removeTariffFreeTime(TariffFreeTimeVO tariffFreeTimeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffFreeTimeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAORemoveTariffFreeTimeDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to removeTariffFreeTimes SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [TariffRate] 정보를 [remove]합니다. <br>
	 * 
	 * @param TariffRateVO tariffRateVO	
	 * @throws DAOException		
	 */
	public void removeTariffRate(TariffRateVO tariffRateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffRateVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAORemoveTariffRateDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to removeTariffRates SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [TariffRegion] 정보를 [remove]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeTariffRegion(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAORemoveTariffRegionDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to removeTariffRegion SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [TrfRgnCfmHis] 정보를 [add]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addTrfRgnCfmHis(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddTrfRgnCfmHisCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addTrfRgnCfmHis SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [TrfGrpCfmHis] 정보를 [add]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addTrfGrpCfmHis(BasicTariffVO basicTariffVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = basicTariffVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddTrfGrpCfmHisCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addTrfGrpCfmHis SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * [TrfRgnCfmSeq] 정보를 [search]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchTrfRgnCfmSeq(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchTrfRgnCfmSeqRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt("rgn_cfm_seq");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	/**
	 * [WeekEnd] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO	
	 * @return List<BasicTariffVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<BasicTariffVO> searchWeekEnd(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BasicTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchWeekEndRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }	
	/**
	 * [CombinationSet] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<BasicTariffVO> searchCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BasicTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchCombinationSetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }	
	
	/**
	 * [Update CombinationSet] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<BasicTariffVO> searchUpdateCombinationSet(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BasicTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchUpdateCombinationSetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }	
	/**
	 * [TariffCombination] 정보를 [search]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @return List<BasicTariffVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<BasicTariffVO> searchTariffCombination(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BasicTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchTariffCombinationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}	
	/**
	 * [DmtTrfRgn] 정보를 [add]합니다. <br>
	 * @param TariffRegionVO tariffRegionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDmtTrfRgn(TariffRegionVO tariffRegionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffRegionVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddDmtTrfRgnCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addDmtTrfRgn SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [DmtTrfGrp] 정보를 [add]합니다. <br>
	 * @param TariffGroupVO tariffGroupVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDmtTrfGrp(TariffGroupVO tariffGroupVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffGroupVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddDmtTrfGrpCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addDmtTrfGrp SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [DmtTrfCmb] 정보를 [add]합니다. <br>
	 * @param TariffCombinationVO tariffCombinationVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDmtTrfCmb(TariffCombinationVO tariffCombinationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffCombinationVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddDmtTrfCmbCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addDmtTrfCmb SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [DmtTrfFreeTm] 정보를 [add]합니다. <br>
	 * @param TariffFreeTimeVO tariffFreeTimeVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDmtTrfFreeTm(TariffFreeTimeVO tariffFreeTimeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffFreeTimeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddDmtTrfFreeTmCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addDmtTrfFreeTm SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [DmtTrfRt] 정보를 [add]합니다. <br>
	 * 
	 * @param TariffRateVO tariffRateVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDmtTrfRt(TariffRateVO tariffRateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffRateVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddDmtTrfRtCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addDmtTrfRt SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [DmtTrfGrp] 정보를 [search]합니다. <br>
	 * 
	 * @param BasicTariffVO basicTariffVO
	 * @return List<TariffGroupVO>
	 * @throws DAOException		
	 */
	@SuppressWarnings("unchecked")
	public List<TariffGroupVO> searchDmtTrfGrp(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffGroupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchDmtTrfGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffGroupVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }	

	/**
	 * [TariffRegionCount] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchTariffRegionCount(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchTariffRegionCountRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt("cnt");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	/**
	 * [Country의 SYSTEM AREA GROUP ID] 정보를 [search]합니다. <br>
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchComNisSvrId(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		String sResult = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if (cntCd != null) {
				param.put("cnt_cd", cntCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchComNisSvrIdRSQL(), param, null);
			if (dbRowset.next())
				sResult = dbRowset.getString("svr_id");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sResult;
		
	}
	
	/**
	 * [TrfRgnSequence] 정보를 [search]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchTrfRgnSequence(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchTrfRgnSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt("trf_seq");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [TrfGrpSequence] 정보를 [search]합니다. <br>
	 * @param BasicTariffVO basicTariffVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchTrfGrpSequence(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchTrfGrpSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt("trf_grp_seq");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * [TariffGroup] 정보를 [modify]합니다. <br>
	 * @param TariffGroupVO tariffGroupVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTariffGroup(TariffGroupVO tariffGroupVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffGroupVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOmodifyTariffGroupUSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyTariffGroup SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [TariffCombination] 정보를 [modify]합니다. <br>
	 * @param TariffCombinationVO tariffCombinationVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTariffCombination(TariffCombinationVO tariffCombinationVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffCombinationVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOmodifyTariffCombinationUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyTariffGroup SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [TariffFreeTime] 정보를 [modify]합니다. <br>
	 * @param TariffFreeTimeVO tariffFreeTimeVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTariffFreeTime(TariffFreeTimeVO tariffFreeTimeVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffFreeTimeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOmodifyTariffFreeTimeUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyTariffFreeTime SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [TariffRate] 정보를 [modify]합니다. <br>
	 * @param TariffRateVO tariffRateVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyTariffRateUSQL(TariffRateVO tariffRateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffRateVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOmodifyTariffRateUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyTariffRateUSQL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [TrfRgnMaxSequence] 정보를 [search]합니다. <br> 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchTrfRgnMaxSequence(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchTrfRgnMaxSequenceRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt("trf_seq");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [TariffRegionConfirm] 정보를 [search]합니다. <br> 
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkTariffRegionConfirm(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sResult = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOCheckTariffRegionConfirmRSQL(), param, velParam);
			if (dbRowset.next())
				sResult = dbRowset.getString("cfm_flg");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sResult;

	}
	/**
	 * [TariffRegionConfirm] 정보를 [search]합니다. <br>
	 * @param TariffRegionVO tariffRegionVO	
	 * @return DBRowSet
	 * @throws DAOException		
	 */
	public TariffRegionVO searchTariffRegion(TariffRegionVO tariffRegionVO) throws DAOException {
		DBRowSet dbRowset = null;
		TariffRegionVO resultTariffRegionVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( tariffRegionVO != null) {
				Map<String, String> mapVO = tariffRegionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOTariffRegionRSQL(), param, velParam);
			resultTariffRegionVO = (TariffRegionVO)RowSetUtil.rowSetToVOs(dbRowset, TariffRegionVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return resultTariffRegionVO;
	 }
	
	/**
	 * [DmtTrfCmb List] 정보를 [add]합니다. <br>
	 * @param TariffCombinationVO tariffCombinationVO
	 * @param String fromTrfSeq
	 * @param String fromTrfGrpSeq
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addListDmtTrfCmb(TariffCombinationVO tariffCombinationVO, String fromTrfSeq, String fromTrfGrpSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffCombinationVO.getColumnValues();
			param.putAll(mapVO);
			param.put("from_trf_seq", fromTrfSeq);
			param.put("from_trf_grp_seq", fromTrfGrpSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddListDmtTrfCmbCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addListDmtTrfCmb SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [DmtTrfFreeTm List] 정보를 [add]합니다. <br>
	 * @param TariffFreeTimeVO tariffFreeTimeVO
	 * @param String fromTrfSeq
	 * @param String fromTrfGrpSeq
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addListDmtTrfFreeTm(TariffFreeTimeVO tariffFreeTimeVO, String fromTrfSeq, String fromTrfGrpSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffFreeTimeVO.getColumnValues();
			param.putAll(mapVO);
			param.put("from_trf_seq", fromTrfSeq);
			param.put("from_trf_grp_seq", fromTrfGrpSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddListDmtTrfFreeTmCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to AddListDmtTrfFreeTm SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [DmtTrfRt List] 정보를 [add]합니다. <br>
	 * @param TariffRateVO tariffRateVO
	 * @param String fromTrfSeq
	 * @param String fromTrfGrpSeq
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addListDmtTrfRt(TariffRateVO tariffRateVO, String fromTrfSeq, String fromTrfGrpSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tariffRateVO.getColumnValues();
			param.putAll(mapVO);
			param.put("from_trf_seq", fromTrfSeq);
			param.put("from_trf_grp_seq", fromTrfGrpSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DemDetTariffMgtDBDAOAddListDmtTrfRtCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to AddListDmtTrfRt SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [CommodityTariffList] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<CommodityTariffVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CommodityTariffVO> searchCommodityTariffList(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<CommodityTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchCommodityTariffListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommodityTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
		
	}
	/**
	 * [BasicTariff] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<TariffRegionVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<TariffRegionVO> checkBasicTariff(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<TariffRegionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOCheckBasicTariffRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TariffRegionVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
		
	}
	
	/**
	 * [Combination에 해당하는 Tariff Group의 존재갯수] 정보를 [search]합니다. <br>
	 *  
	 * @param TariffCombinationVO tariffCombinationVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkTariffGroup(TariffCombinationVO tariffCombinationVO) throws DAOException {
		DBRowSet dbRowset = null;
		int iResult = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (tariffCombinationVO != null) {
				Map<String, String> mapVO = tariffCombinationVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOCheckTariffGroupRSQL(), param, velParam);
			if (dbRowset.next())
				iResult = dbRowset.getInt("cnt");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return iResult;

	}	
	/**
	 * [CommodityTariff] 정보를 [add]합니다. <br>
	 * @param List<CommodityTariffVO> commodityTariffVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCommodityTariff(List<CommodityTariffVO> commodityTariffVOs) throws DAOException,Exception {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(commodityTariffVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DemDetTariffMgtDBDAOAddCommodityTariffCSQL(), commodityTariffVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addCommodityTariff No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [CommodityTariff] 정보를 [modify]합니다. <br>
	 * @param List<CommodityTariffVO> commodityTariffVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCommodityTariff(List<CommodityTariffVO> commodityTariffVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(commodityTariffVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DemDetTariffMgtDBDAOModifyCommodityTariffUSQL(), commodityTariffVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyCommodityTariff No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [CommodityTariff] 정보를 [remove]합니다. <br>
	 * @param List<CommodityTariffVO> commodityTariffVOs		
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCommodityTariff(List<CommodityTariffVO> commodityTariffVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(commodityTariffVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DemDetTariffMgtDBDAORemoveCommodityTariffDSQL(), commodityTariffVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeCommodityTariff No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [CommodityTariffRegionLis] 정보를 [search]합니다. <br>
	 * @param CommodityTariffRegionParamVO commodityTariffRegionParamVO
	 * @return List<CommodityTariffRegionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CommodityTariffRegionVO> searchCommodityTariffRegionList(CommodityTariffRegionParamVO commodityTariffRegionParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommodityTariffRegionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		StringTokenizer st1 = null;
		String tempS = "";
		
		String inFlag = "Y";
		List<String> aryTrfCd = new ArrayList();
		
		try{
			if(commodityTariffRegionParamVO != null){
				Map<String, String> mapVO = commodityTariffRegionParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Tariff Type
				String dmdtTrfCdList = (String)commodityTariffRegionParamVO.getDmdtTrfCdList();
				
				st1 = new StringTokenizer(dmdtTrfCdList, ",");
			    while (st1.hasMoreTokens()) {
			    	tempS = st1.nextToken(); 
			    	if(tempS.equals("All")) {
			    		continue;
			    	}
			    	aryTrfCd.add(tempS);
			    }
			    if(dmdtTrfCdList.length()==0) {
		    		inFlag = "N";
			    }
			    
				velParam.put("dmdt_trf_cd_list", aryTrfCd);
	    		velParam.put("dmdt_trf_cd_in", inFlag);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchCommodityTariffRegionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommodityTariffRegionVO .class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}	 	

	/**
	 * [BasicTariffGrp] 정보를 [search]합니다. <br>
	 * @param DmtTariffTypeVO dmtTariffTypeVO
	 * @return List<BasicTariffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BasicTariffVO> searchBasicTariffGrp(DmtTariffTypeVO dmtTariffTypeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BasicTariffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if( dmtTariffTypeVO != null) {
				Map<String, String> mapVO = dmtTariffTypeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchBasicTariffGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicTariffVO.class);
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	 }
	
	/**
	 * RGN에 대한 하위 DMT_TRF_GRP 존재 여부 확인합니다. <br> 
	 * @param BasicTariffVO basicTariffVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchGrpYNByRgn(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sResult = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchGrpYNByRgnRSQL(), param, velParam);
			if (dbRowset.next())
				sResult = dbRowset.getString("grp_yn");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sResult;

	}	
	/**
	 * RGN에 대한 하위 DMT_CMDT_GRP 존재 여부 확인합니다. <br> 
	 * @param BasicTariffVO basicTariffVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCmdtYNByRgn(BasicTariffVO basicTariffVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sResult = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (basicTariffVO != null) {
				Map<String, String> mapVO = basicTariffVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DemDetTariffMgtDBDAOSearchCmdtYNByRgnRSQL(), param, velParam);
			if (dbRowset.next())
				sResult = dbRowset.getString("cmdt_yn");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sResult;

	}		
}

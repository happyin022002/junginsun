/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportDBDAO.java
*@FileTitle : RailTransitReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 2009-02-19 iskim
* 	(1) N200902130040	[SCEM] RTR 조회 대상 보완 요청 
* 		delt_flg = 'Y' 인건은 조회 되지 않게 수정
* 2009-03-04 iskim
* 	(1) R200903040003	2월 소스품질 검토 결과 follow-up
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
* 2011.07.25 손은주 [CHM-201112118-01]	Rail Transit Report의 Remark Column 이원화 및 활성화 요청.
* 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing(객체에 NULL이 배정된 이후 객체에 대한 참조를 하지 말아야 한다
* 2012.03.29 박찬민 [CHM-201216948] 개발-Rail Transit Report상의 일부항목 변경 및 보완
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;
   
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration.CustomerEdiDBDAOSearchMdmLocationRSQL;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0045Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListPopVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBKGNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBLNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputCntrVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputVVDVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRListVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyDtlVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyListVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchTRCListOptionsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seong-mun Kang
 * @see COPSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class RailTransitReportDBDAO extends DBDAOSupport {
	
	/*============================================= 강성문 =========================================================*/
	/**
     * Car Location Message 총조회수
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return int
     * @throws DAOException
     */
  public int searchCLMCount(SearchCLMListOptionsVO schClmlOpts)throws DAOException{
  	log.info("searchCLMCount 실행합니다.");
  	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schClmlOpts != null) {
				Map<String, String> mapVO = schClmlOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//log.info("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMCountRSQL(),
					param, velParam);
		    if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
		    }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
    
    /**
     * Car Location Message 조회 리스트
     * 
     * @param SearchCLMListOptionsVO schClmlOpts
     * @return DBRowSet
     * @throws DAOException
     */
    
    public DBRowSet searchCLMList(SearchCLMListOptionsVO schClmlOpts)throws DAOException{
    	
    	log.info("searchCLMListR를 실행합니다.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schClmlOpts != null) {
				Map<String, String> mapVO = schClmlOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//log.info("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}						
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMListRSQL(),
					param, velParam);
			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
    
    /**
     * Car Location Message (POP-UP) 총조회수
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return int
     * @throws DAOException
     */
    public int searchCLMCountPop(SearchRTRInfoVO rtrInfo) throws DAOException {
    	DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (rtrInfo != null) {
				Map<String, String> mapVO = rtrInfo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			log.info("param==" + param);
			log.info("velParam==" + velParam);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMCountPopRSQL(),
					param, velParam);
			
			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				log.info("temp === " + temp);
				return temp;
        	}
			return 0;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
     * Car Location Message (POP-UP) 조회 리스트
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @return List<SearchCLMListPopVO>
     * @throws DAOException
     */
    public List<SearchCLMListPopVO> searchCLMListPop(SearchRTRInfoVO rtrInfo) throws DAOException {
    	log.info("searchCLMListPop-을 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchCLMListPopVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	if (rtrInfo != null) {
				Map<String, String> mapVO = rtrInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.info("PARAM:"+ param);
			    log.info("velParam:"+ velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchCLMListPopRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchCLMListPopVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
    }
    
    /**
     * Train & Rail Car 조회 리스트
     * 
     * @param SearchTRCListOptionsVO schTrclOpts
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchTRCList(SearchTRCListOptionsVO schTrclOpts) throws DAOException {
    	log.info("searchTRCList를 실행합니다.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (schTrclOpts != null) {
				Map<String, String> mapVO = schTrclOpts.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//log.info("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}						
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchTRCListRSQL(),
					param, velParam);
			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset; 
    }
    
    
    /**
     * Rail Transit Report 총조회수
     * 
     * @param SearchRTRInfoVO rtrInfo
     * @param String searchType
     * @return int
     * @throws DAOException
     */
    public int searchRTRCount(SearchRTRInfoVO rtrInfo, String searchType) throws DAOException {
    	DBRowSet dbRowset = null;
//		List<SearchRTRCountVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();                

        try {
        	if (rtrInfo != null) {
				Map<String, String> mapVO = rtrInfo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReprotDBDAOSearchRTRCountRSQL(),
					param, velParam);

			int temp = 0;
			if(dbRowset.next()) {
				temp = dbRowset.getInt(1);
				return temp;
        	}
			return 0;
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
     * Rail Transit Report 조회 리스트(multi)
	 * 2009-02-19 iskim
	 * 	(1) N200902130040	[SCEM] RTR 조회 대상 보완 요청 
	 * 		delt_flg = 'Y' 인건은 조회 되지 않게 수정
	 * 2009-03-04 iskim
	 * 	(1) R200903040003	2월 소스품질 검토 결과 follow-up     *
	 *  
     * @param SearchRTRInfoVO rtrInfo
     * @param SearchRTRListVO[] rtrLists
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchRTRList(SearchRTRInfoVO rtrInfo, SearchRTRListVO[] rtrLists) throws DAOException {
    	log.info("searchRTRList(multi)-을 실행합니다.");
//    	Collection<SearchRTRListVO> seModels = new ArrayList<SearchRTRListVO>();
    	DBRowSet dbRowset = null;
//    	List<SearchRTRListVO>list = null;
    	
    	// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try{
    		
    		log.info("###EsdSce0045 - Param[cur_page] : " + rtrInfo.getCurPage());
    		if (!JSPUtil.getNull(rtrInfo.getBkgNo()).equals("")) { // CHM-201216948 개발-Rail Transit Report상의 일부항목 변경 및 보완-Bkg_No, Bl_No, Eq_No 싱글 및 멀티 처리 가능
    			rtrInfo.setBkgNo("'" + rtrInfo.getBkgNo().replaceAll(",", "','") + "'");
			}
    		if (!JSPUtil.getNull(rtrInfo.getBlNo()).equals("")) {
    			rtrInfo.setBlNo("'" + rtrInfo.getBlNo().replaceAll(",", "','") + "'");
			}
    		if (!JSPUtil.getNull(rtrInfo.getEqNo()).equals("")) {
    			rtrInfo.setEqNo("'" + rtrInfo.getEqNo().replaceAll(",", "','") + "'");
			}
            String sIpage  = rtrInfo.getCurPage();
			int iPage = 0;
			if(sIpage == null || sIpage.equals("") || sIpage.equals("0") ){
				iPage = 1;
			}else{
				iPage = Integer.parseInt(sIpage);
			}
			   		
    		int cnt = rtrLists.length;
    		Map<String, String> mapVO = rtrInfo.getColumnValues();
    		
    		param.putAll(mapVO); // single condition
			velParam.putAll(mapVO); // single condition
			
    		Map fieldNm = rtrLists[0].getFieldNames();
    		Set names = fieldNm.keySet();
    		
    		// multi condition start...
    		Iterator it = names.iterator();
    		while (it.hasNext()){
    			String name = it.next().toString();
    			List multiParams = new ArrayList();
	    		for(int i=0;i<cnt;i++){
	    			Map colVal = rtrLists[i].getColumnValues();
	    			String value = (String)colVal.get(name);
	    			if( value != null  && !value.equals("") )
	    				multiParams.add(value);
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("eq_no"))	name = "cntr_no";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("mst_bl_no"))	name = "bl_no";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("vvd_cd"))	name = "vvd";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("nod_cd"))	name = "polpod";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("fm_nod_cd"))	name = "origin";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("to_nod_cd"))	name = "dest";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
	    		if(!multiParams.isEmpty()){
	    			if(name.equals("sc_no"))	name = "scno";
		    		param.put("r_"+name, multiParams.toArray()); 
		    		velParam.put("r_"+name, multiParams.toArray()); 
	    		}
    		}
    		// multi condition end...
			
			log.info("velParam===>"+velParam);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchRTRListRSQL(),
					param, velParam);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
    // single
    /**
     * Rail Transit Report 조회 리스트  
	 *  
     * @param SearchRTRInfoVO rtrInfo
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchRTRList(SearchRTRInfoVO rtrInfo) throws DAOException {
    	
    	log.info("searchRTRList(single)-을 실행합니다.");
    	DBRowSet dbRowset = null;
//		List<SearchRTRListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
        	log.info("###EsdSce0045 - Param[cur_page] : " + rtrInfo.getCurPage());
            String sIpage  = rtrInfo.getCurPage();
			int iPage = 0;
			if(sIpage == null || sIpage.equals("") || sIpage.equals("0") ){
				iPage = 1;
			}else{
				iPage = Integer.parseInt(sIpage);
			}
			
        	if (rtrInfo != null) {
        		if (!JSPUtil.getNull(rtrInfo.getBkgNo()).equals("")) {// CHM-201216948 개발-Rail Transit Report상의 일부항목 변경 및 보완-Bkg_No, Bl_No, Eq_No 싱글 및 멀티 처리 가능
        			rtrInfo.setBkgNo("'" + rtrInfo.getBkgNo().replaceAll(",", "','") + "'");
    			}
        		
        		if (!JSPUtil.getNull(rtrInfo.getBlNo()).equals("")) {
        			rtrInfo.setBlNo("'" + rtrInfo.getBlNo().replaceAll(",", "','") + "'");
    			}
        		
        		if (!JSPUtil.getNull(rtrInfo.getEqNo()).equals("")) {
        			rtrInfo.setEqNo("'" + rtrInfo.getEqNo().replaceAll(",", "','") + "'");
    			}
        		
        		if (!JSPUtil.getNull(rtrInfo.getCntrTpsz()).equals("")) {
        			rtrInfo.setCntrTpsz("'" + rtrInfo.getCntrTpsz().replaceAll(",", "','") + "'");
    			}
        		
				Map<String, String> mapVO = rtrInfo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if (velParam.get("bkg_ofc_cd") != null && !velParam.get("bkg_ofc_cd").equals("")) {
					param.put("bkg_ofc_cd", ((String) velParam.get("bkg_ofc_cd")).split(","));
					velParam.put("bkg_ofc_cd", ((String) velParam.get("bkg_ofc_cd")).split(","));
				}
				
			    log.info("velParam:"+ velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchRTRListRSQL(),
					param, velParam);
			//list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchRTRListVO.class);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
    


    /**
     * Multi Input Container 조회
     * 
     * @param SearchMultiInputCntrVO[] cntrInfos
     * @return List<SearchMultiInputCntrVO>
     * @throws DAOException
     */
    public List<SearchMultiInputCntrVO> searchMultiInputCntr(SearchMultiInputCntrVO[] cntrInfos) throws DAOException {
    	Collection<SearchMultiInputCntrVO> seModels = new ArrayList<SearchMultiInputCntrVO>();
    	
//    	List<SearchMultiInputCntrVO> list = null;
		List<SearchMultiInputCntrVO> listAll = new ArrayList<SearchMultiInputCntrVO>();

    	if (cntrInfos == null) {
    		log.info("cntrInfos is null");
//    		return list;
    	}
    	log.info("searchMultiInputCntr을 실행합니다.");
    	DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SearchMultiInputCntrVO model = null;	
			int cnt = cntrInfos!=null?cntrInfos.length:0;
			log.info("cnt===" + cnt);
			
			for(int i=0;i<cnt;i++){
				model = (SearchMultiInputCntrVO)cntrInfos[i];
							
				log.info("seModels.size()==="+ seModels.size());
				Map<String, String> mapVO = model.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("velParam===>"+velParam);
				
				dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchMultiInputCntrRSQL(),
					param, velParam);
				
				SearchMultiInputCntrVO ret = new SearchMultiInputCntrVO();
				if(dbRowset.getRowCount()>0){
			    	dbRowset.next();
			    	ret.setCntrNo(dbRowset.getString(1));
			    	if (dbRowset.getString(2).equals("Y")) {
			    		ret.setRemark("Clear");
			    	}
			    }else{
			    	ret.setCntrNo(model.getCntrNo());
			    	ret.setRemark("No Data Found");
			    }
				listAll.add(ret);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return listAll;
    }

    /**
     * Multi Input BKG No 조회
     * 
     * @param SearchMultiInputBKGNoVO[] bkgInfos
     * @return List<SearchMultiInputBKGNoVO>
     * @throws DAOException
     */
    public List<SearchMultiInputBKGNoVO> searchMultiInputBKGNo(SearchMultiInputBKGNoVO[] bkgInfos) throws DAOException {
    	Collection<SearchMultiInputBKGNoVO> seModels = new ArrayList<SearchMultiInputBKGNoVO>();
    	
//    	List<SearchMultiInputBKGNoVO> list = null;
		List<SearchMultiInputBKGNoVO> listAll = new ArrayList<SearchMultiInputBKGNoVO>();
		
    	if (bkgInfos == null) {
    		log.info("bkgInfos is null");
//    		return list;
    	}
    	log.info("searchMultiInputCntr을 실행합니다.");
    	DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SearchMultiInputBKGNoVO model = null;	
			int cnt = bkgInfos!=null?bkgInfos.length:0;
			log.info("cnt===" + cnt);
			
			for(int i=0;i<cnt;i++){
				model = (SearchMultiInputBKGNoVO)bkgInfos[i];
							
				log.info("seModels.size()==="+ seModels.size());
				Map<String, String> mapVO = model.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("velParam===>"+velParam);
				
				dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchMultiInputBKGNoRSQL(),
					param, velParam);
				
				SearchMultiInputBKGNoVO ret = new SearchMultiInputBKGNoVO();
				if(dbRowset.getRowCount()>0){
			    	dbRowset.next();
			    	ret.setBkgNo(dbRowset.getString(1));
			    	if (dbRowset.getString(2).equals("Y")) {
			    		ret.setRemark("Clear");
			    	}
			    }else{
			    	ret.setBkgNo(model.getBkgNo());
			    	ret.setRemark("No Data Found");
			    }
				listAll.add(ret);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return listAll;
    }
    
    /**
     * Multi Input B/L No 조회
     * 
     * @param SearchMultiInputBLNoVO[] blnoInfos
     * @return List<SearchMultiInputBLNoVO>
     * @throws DAOException
     */
    public List<SearchMultiInputBLNoVO> searchMultiInputBlNo(SearchMultiInputBLNoVO[] blnoInfos) throws DAOException {
    	
    	Collection<SearchMultiInputBLNoVO> seModels = new ArrayList<SearchMultiInputBLNoVO>();
    	
//    	List<SearchMultiInputBLNoVO> list = null;
		List<SearchMultiInputBLNoVO> listAll = new ArrayList<SearchMultiInputBLNoVO>();
		
    	if (blnoInfos == null) {
    		log.info("blnoInfos is null");
//    		return list;
    	}
    	log.info("searchMultiInputBlNo를 실행합니다.");
    	DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SearchMultiInputBLNoVO model = null;	
			int cnt =  blnoInfos!=null?blnoInfos.length:0;
			log.info("cnt===" + cnt);
			
			for(int i=0;i<cnt;i++){
				model = (SearchMultiInputBLNoVO)blnoInfos[i];
							
				log.info("seModels.size()==="+ seModels.size());
				Map<String, String> mapVO = model.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("velParam===>"+velParam);
				
				dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchMultiInputBLNoRSQL(),
					param, velParam);
				
				SearchMultiInputBLNoVO ret = new SearchMultiInputBLNoVO();
				if(dbRowset.getRowCount()>0){
			    	dbRowset.next();
			    	ret.setBlNo(dbRowset.getString(1));
			    	if (dbRowset.getString(2).equals("Y")) {
			    		ret.setRemark("Clear");
			    	}
			    }else{
			    	ret.setBlNo(model.getBlNo());
			    	ret.setRemark("No Data Found");
			    }
				listAll.add(ret);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return listAll;
    }
    
    /**
     * Multi Input VVD 조회
     * 
     * @param SearchMultiInputVVDVO[] vvdInfos
     * @return List<SearchMultiInputVVDVO>
     * @throws DAOException
     */
    public List<SearchMultiInputVVDVO> searchMultiInputVVD(SearchMultiInputVVDVO[] vvdInfos) throws DAOException {
    	
    	Collection<SearchMultiInputVVDVO> seModels = new ArrayList<SearchMultiInputVVDVO>();
    	
//    	List<SearchMultiInputVVDVO> list = null;
		List<SearchMultiInputVVDVO> listAll = new ArrayList<SearchMultiInputVVDVO>();
		
    	if (vvdInfos == null) {
    		log.info("vvdInfos is null");
//    		return list;
    	}
    	log.info("searchMultiInputVVD를 실행합니다.");
    	DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SearchMultiInputVVDVO model = null;	
			int cnt = vvdInfos!=null?vvdInfos.length:0;
			log.info("cnt===" + cnt);
			
			for(int i=0;i<cnt;i++){
				model = (SearchMultiInputVVDVO)vvdInfos[i];
							
				log.info("seModels.size()==="+ seModels.size());
				Map<String, String> mapVO = model.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.info("velParam===>"+velParam);
				
				dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchMultiInputVVDRSQL(),
					param, velParam);
				
				SearchMultiInputVVDVO ret = new SearchMultiInputVVDVO();
				if(dbRowset.getRowCount()>0){
			    	dbRowset.next();
			    	ret.setVvd(dbRowset.getString(1));
			    	if (dbRowset.getString(2).equals("Y")) {
			    		ret.setRemark("Clear");
			    	}
			    }else{
			    	ret.setVvd(model.getVvd());
			    	ret.setRemark("No Data Found");
			    }
				listAll.add(ret);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return listAll;
    }
    
    /**
	 * Missing Origin Gate In Dt를 수정한다<br>
	 * 
	 * @param SearchRTRListVO[] models
	 * @throws DAOException
	 */
	public void modifyRTRReport(SearchRTRListVO[] models) throws DAOException {
		
		log.info("RailTransitReportDBDAO - modifyRTRReport");
		
		Collection<SearchRTRListVO> updModels =new ArrayList<SearchRTRListVO>();
 
		try {
		
			SearchRTRListVO model = null;
			int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (SearchRTRListVO)models[i];
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("U")) {
						updModels.add(model);
					} 
				}
			}
			
			int updCnt = 0;

			SQLExecuter sqlExe = new SQLExecuter("");

			if(updModels.size()>0){
//				updCnt = sqlExe.executeBatch(new RailTransitReportDBDAOModifyRTRReportUSQL(), updModels, null);
				Iterator<SearchRTRListVO> it = updModels.iterator();
				for(;it.hasNext();){
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(((SearchRTRListVO)it.next()).getColumnValues());					
					updCnt = sqlExe.executeUpdate(new RailTransitReportDBDAOModifyRTRReportUSQL(), param, param);
					
					if(updCnt== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
					
//					for(int i=0;i<updCnt.length;i++){
//						if(updCnt[i]== Statement.EXECUTE_FAILED)
//							throw new DAOException("Fail to update No"+ i + " SQL");
//					}
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
	 * Upload Excel을 통한 Current Remark를 수정한다<br>
	 * 
	 * @param SearchRTRListVO[] models
	 * @throws DAOException
	 */
	public void modifyRTRReportRemark(SearchRTRListVO[] models) throws DAOException {
		
		log.info("RailTransitReportDBDAO - modifyRTRReport");
		
		Collection<SearchRTRListVO> updModels =new ArrayList<SearchRTRListVO>();
 
		try {
		
			SearchRTRListVO model = null;
			int cnt = models.length;
			for(int i=0;i<cnt;i++){
				model = (SearchRTRListVO)models[i];
				if (model.getIbflag().length() > 0) {
					if (model.getIbflag().equals("U")) {
						updModels.add(model);
					} 
				}
			}
			
			int updCnt = 0;

			SQLExecuter sqlExe = new SQLExecuter("");

			if(updModels.size()>0){
//				updCnt = sqlExe.executeBatch(new RailTransitReportDBDAOModifyRTRReportUSQL(), updModels, null);
				Iterator<SearchRTRListVO> it = updModels.iterator();
				for(;it.hasNext();){
					Map<String, Object> param = new HashMap<String, Object>();
					param.putAll(((SearchRTRListVO)it.next()).getColumnValues());					
					updCnt = sqlExe.executeUpdate(new RailTransitReportDBDAOModifyRTRReportRemarkUSQL(), param, param);
					
					if(updCnt== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
					
//					for(int i=0;i<updCnt.length;i++){
//						if(updCnt[i]== Statement.EXECUTE_FAILED)
//							throw new DAOException("Fail to update No"+ i + " SQL");
//					}
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
     * RTR Summary List 조회
     * 
     * @param Event e
     * @return DBRowSet
     * @throws DAOException
     */
    public List<SearchRTRSmmyListVO> searchRTRSmmyList(Event e) throws DAOException {
    		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		EsdSce0045Event event         = (EsdSce0045Event)e ;
		SearchRTRSmmyInfoVO [] searchRTRSmmyInfos = event.getSearchRTRSmmyInfos();
		String fmDate = event.getFmDate();
		String toDate = event.getToDate();
		String dateKind = event.getDateKind();
		String chkPeriod = event.getChkPeriod();
		String scNo = event.getScNo();
		
		List<SearchRTRSmmyListVO> lists = new ArrayList<SearchRTRSmmyListVO>();

        try {

	        velParam.put("fm_date", fmDate);
	        velParam.put("to_date", toDate);
	        velParam.put("date_kind", dateKind);
	        velParam.put("chk_period", chkPeriod);
	        velParam.put("sc_no", scNo);
	        
	        for(int i=0; searchRTRSmmyInfos!=null && searchRTRSmmyInfos.length > i; i++){

	        	SearchRTRSmmyInfoVO model = searchRTRSmmyInfos[i];

	        	velParam.put("fm_nod_cd", model.getCFmNodCd());
	        	velParam.put("to_nod_cd", model.getCToNodCd());
	        	velParam.put("cgo_tp_cd", model.getCCgoTpCd());
	        	velParam.put("trsp_bnd_cd", model.getCTrspBndCd());
	        	//LOOP를 돌기때문에 각 쿼리문에서 조회된 RANK가 중복된다. UNIQUE한 RANK를 만들기 위해서는  PREFIX를 추가함.
	        	velParam.put("rank_prefix", (i)+"_"); 	        	
	        	
		        param.putAll(velParam);

		        //ROUTE 조건은 AND 조건이 아니라 각각의 REPORT에 대한 합집합 조건이다. 즉 중복되거나 교집합 조건이 있어도 각각 조회되야 한다.
		        //그런 이유로 LOOP를 돌면서 각각의 ROUTE 조건에 대한 조회결과를 구한뒤 합친다.
		        DBRowSet dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new RailTransitReportDBDAOSearchRTRSmmyListRSQL(),param,velParam);
					
		        List<SearchRTRSmmyListVO> voList = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchRTRSmmyListVO.class);
		        
		        lists.addAll(voList);				
	        }

        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return lists;
    }
    
	/**
     * RTR Summary Detail 조회
     * 
     * @param Event e
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchRTRSmmyDetail(Event e) throws DAOException {
    	
    	DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		EsdSce0045Event event         = (EsdSce0045Event)e ;
		SearchRTRSmmyDtlVO [] searchRTRSmmyDtls = event.getSearchRTRSmmyDtls();

		String dateKind = event.getDateKind();
		String curPage = event.getCurPage();
		String parentScNo = event.getParentScNo();
		
		List<SearchRTRSmmyDtlVO> listVo = new ArrayList<SearchRTRSmmyDtlVO>();

        try {
        	
        	for(int i=0; searchRTRSmmyDtls!=null && searchRTRSmmyDtls.length > i; i++){
        		SearchRTRSmmyDtlVO model = searchRTRSmmyDtls[i];
        		listVo.add(model);
        	}
        	
        	velParam.put("cur_page", curPage);
	        velParam.put("date_kind", dateKind);
	        velParam.put("summary", "Y");
	        velParam.put("parentScNo", parentScNo);

	        if(searchRTRSmmyDtls != null && searchRTRSmmyDtls.length > 0 ){
	        	velParam.put("rout_info", listVo);
	        }
	        param.putAll(velParam);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RailTransitReportDBDAOSearchRTRListRSQL(),param,velParam);

        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
    }
}
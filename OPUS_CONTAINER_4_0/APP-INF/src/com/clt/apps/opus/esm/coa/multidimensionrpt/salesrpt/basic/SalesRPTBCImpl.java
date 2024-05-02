/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTBCImpl.java
*@FileTitle : Monthly Average U/C(PFMC-Based) 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
===========================================================
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration.SalesRPTDBDAO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoRtnVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.MultiSetForm059SeqVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchRptItemVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaRptItmInfoDtlVO;
import com.clt.syscommon.common.table.CoaRptItmInfoMstVO;
import java.util.StringTokenizer; 						//SJH.20140806.ADD

/**
 * OPUS-MultiDimensionRPT Business Logic Basic Command implementation<br>
 *
 * @author
 * @see ESM_COA_0057EventResponse,SalesRPTBC reference the each DAO class 
 * @since J2EE 1.6
 */
public class SalesRPTBCImpl extends BasicCommandSupport implements SalesRPTBC {

	// Database Access Object
	private transient SalesRPTDBDAO dbDao = null;

	/**
	 * SalesRPTBCImpl Object creation<br>
	 * SalesRPTDBDAO Creation<br>
	 */
	public SalesRPTBCImpl() {
		dbDao = new SalesRPTDBDAO();
	}	

	/**
	 * EsmCoa0035: Header Handling the inquiry event<br>
* Handling the inquiry event<br>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCntrTpSzList(SalesOffiRepoConditionVO vo) throws EventException {
		
		try {			
			return dbDao.searchCntrTpSzList(vo);	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}			
	}
	
	/**
* Handling the inquiry event<br>
* Handling the inquiry event<br>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return List<Object>
	 * @exception EventException
	 */
	public List<Object> searchInqSrcDtAcct0035List(SalesOffiRepoConditionVO vo) throws EventException {
		DBRowSet rowSetHD = null; //  DB ResultSet
		DBRowSet rowSet = null;
		List<Object> sList = new ArrayList();
		List<String> cols  = new ArrayList();
		
		int colCnt = 0;
		String[] sTitle = null;
		String[] sColum = null;
		
		try {
			rowSetHD = dbDao.searchCntrTpSzList(vo);			
			if (rowSetHD != null) {
				while (rowSetHD.next()) {
					cols.add(rowSetHD.getString("spcl_cntr_tpsz_cd"));
				} 
			}
			
			rowSet = dbDao.searchInqSrcDtAcct0035List(vo, cols);			
			sList.add( rowSet );
			
			//excell Header
			if("Y".equals(vo.getFExcel())){
				rowSet.next();
				colCnt = rowSet.getMetaData().getColumnCount();
				sTitle = new String[colCnt];
				sColum = new String[colCnt];
								
				for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
					sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
					sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
				}
				sList.add( sTitle );
				sList.add( sColum );
			}
			
			return sList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}			
	}
	
	/**
	 * ESM_COA_035: Handling the inquiry event<br>
	 * About the Inquiry By Source Data : Type Size, Handling the inquiry event<br>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @exception EventException
	 */
	public List<Object> searchInqSrcDtTpSz0035List(SalesOffiRepoConditionVO vo) throws EventException {
		DBRowSet rowSetHD = null; //  DB ResultSet
		DBRowSet rowSet = null;
		List<Object> sList = new ArrayList();
		String[] sTitle = null; // excell
		String[] sColum = null; //db column
		int colCnt = 0;
		List<String> cols  = new ArrayList();
		
		try {
			rowSetHD = dbDao.searchCntrTpSzList(vo);			
			if (rowSetHD != null) {
				while (rowSetHD.next()) {
					cols.add(rowSetHD.getString("spcl_cntr_tpsz_cd"));
				} 
			}
			
			rowSet = dbDao.searchInqSrcDtTpsz0035List(vo, cols);			
			sList.add( rowSet );
			
			//엑셀다운 로드시 Header 세팅..
			if("Y".equals(vo.getFExcel())){
				rowSet.next();
				colCnt = rowSet.getMetaData().getColumnCount();
				sTitle = new String[colCnt];
				sColum = new String[colCnt];
								
				for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
					sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
					sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
				}
				sList.add( sTitle );
				sList.add( sColum );
			}
			
			return sList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}			
	}	 
	
	/**
	 * <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BkgRpt0061VO>
	 * @exception EventException
	 */
	public List<BkgRpt0061VO> searchBKG0061List(SearchConditionVO searchConditionVO) throws EventException {
		boolean isDeleted = false;
		try {

			isDeleted = dbDao.isDeletedBooking(searchConditionVO.getFBkgNo());
			if (isDeleted) {
				throw new DAOException(new ErrorHandler("COA00018").getMessage());
			} else {
				return dbDao.searchBKG0061List(searchConditionVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG0061List2(SearchConditionVO searchConditionVO) throws EventException {
		DBRowSet dbRowSet = null;
		StringBuffer header = new StringBuffer();
		int cnt = 1;
		
		try {
			dbRowSet = dbDao.searchRptItem3(searchConditionVO);
        	if(dbRowSet != null){
        		while(dbRowSet.next()){
        			header.append(dbRowSet.getString("cntr_tpsz_cd"));
        			if(cnt != dbRowSet.getRowCount()) header.append("|"); 
        			cnt++;
    			}
        	}
			return dbDao.searchBKG0061List2(searchConditionVO, header.toString() );
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Inquiry By BKG Report(Sheet3)<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG0061List3(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchBKG0061List3(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
     * Weekly Sales Report By Office1 Handling the inquiry event.<br>
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070List11(SalesOffiRepoConditionVO vo) throws EventException {
		//CommonBC commonBC = new CommonBCImpl();
		try {
//			vo.setFPrevWeek( commonBC.searchPreWeek(vo.getFYear2(), vo.getFWk()) );
//			vo.setFCurrWeek( vo.getFYear2() + vo.getFWk() );
			
			return dbDao.searchRPTbyOfc0070List11(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
		
    /**
     * 1. Function :  Weekly Sales Report By Office1 Handling the inquiry event<p>
     *
     * @param     SalesOffiRepoConditionVO vo
     * @return    DBRowSet
     * @exception EventException
     */
	public DBRowSet searchRPTbyOfc0070List12(SalesOffiRepoConditionVO vo) throws EventException {
		try {
			return dbDao.searchRPTbyOfc0070List12(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
    
	/**
	 * Inquiry by BKG Cost Remark]<br>
	 * About the ESM_COA_0170, Handling the inquiry event<br>
	 * 
	 * @param vo SearchConditionVO
	 * @return list List<SearchBkgRmk0170ListVO> 
	 * @throws EventException
	 */
	public List<SearchBkgRmk0170ListVO> searchBkgRemarkList(SearchConditionVO vo) throws EventException {
		try {
			return dbDao.searchBkgRemarkList(vo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	
    /**
     * group code list Inquiry <br>
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @return List<SearchSetForm059ListVO>
     * @exception EventException
     */	
    public List<SearchSetForm059ListVO> searchSetForm059List(SearchConditionVO searchVo, SalesRPTCommonVO vo) throws EventException {
        try {
        	
            HashMap<String, String> qParam = new HashMap<String, String>();
	        vo.setIndirectColumnValues(qParam);

            return dbDao.searchSetForm059List(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }    

    /**
	 * Handling the inquiry event<br>
	 * About the MultiDimension, Handling the inquiry event<br>
	 * 
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param SignOnUserAccount account
     * @return List<SearchSetForm059List2VO>
     * @exception EventException	 
	 */
    public List<SearchSetForm059List2VO> searchSetForm059List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, SignOnUserAccount account) throws EventException {
        try {
        	
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("cre_usr_id"       , account.getUsr_id());
            qParam.put("slct_itm_fom_seq" , searchVo.getFSelgroup());
            vo.setIndirectColumnValues(qParam);       
        	
            return dbDao.searchSetForm059List2(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }      

    /**
	 * Handling multi event<br>
	 * About the ESM_COA_003(So Cost Code), Handling multi event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param SalesRPTCommonVO[] vos
	 * @param CoaRptItmInfoMstVO[] tVos
	 * @param CoaRptItmInfoDtlVO[] tVos2
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiSetForm059(SearchConditionVO searchVo, SalesRPTCommonVO vo, SalesRPTCommonVO[] vos, CoaRptItmInfoMstVO[] tVos, CoaRptItmInfoDtlVO[] tVos2, SignOnUserAccount account) throws EventException{
        try{
            List createMasterList = null;
            List createDetailList = null;
            List deleteMasterList = null;
            List deleteDetailList = null;
        	
            String fom_seq  = searchVo.getFSelgroup();
            String fom_desc = searchVo.getFGroup();
            String savename = searchVo.getFSavename(); 
            String divideName = searchVo.getFDividename(); 
            
            //log.debug("fom_seq = "+fom_seq);
            //log.debug("fom_desc = "+fom_desc);
            //log.debug("savename = "+savename);
            //log.debug("divideName = "+divideName);
    		
    		if(divideName.trim().equals("save")){
    			
        		//SEQ ---------------------------------- START
                if(fom_seq.trim().equals("") || (!fom_seq.trim().equals("") && !fom_desc.trim().equals(savename))){
                    HashMap<String, String> qParam = new HashMap<String, String>();
                    qParam.put("cre_usr_id", account.getUsr_id());
                    vo.setIndirectColumnValues(qParam);
                    
                    List<MultiSetForm059SeqVO> list = dbDao.multiSetForm059Seq(vo);
                    int listCnt = list.size();
                    if(listCnt > 0){
                    	fom_seq = ((MultiSetForm059SeqVO)list.get(0)).getSeq();
                    }
                    
                    if(listCnt == 0){
                    	fom_seq = "1";
                    }
                }

        		//SEQ ---------------------------------- END    
                
                if(searchVo.getFSelgroup().trim().equals("")){

    				if(searchVo.getFSelgroup().trim().equals("")){
    	            	//Master(INSERT) ---------------------------------- START
    	                //query parameter
    	                HashMap<String, String> param = new HashMap<String, String>();
    	                param.put("cre_usr_id", account.getUsr_id());
    	                param.put("upd_usr_id", account.getUsr_id());
    	                param.put("slct_itm_fom_seq", fom_seq); 
    	                param.put("slct_itm_fom_desc", savename); 
    	                
    	                createMasterList = new ArrayList();
          
    	                createMasterList.add(param);   

    	                vo.setMultiCreateList(createMasterList);
    	                
    	                
    	                dbDao.multiSetForm059RegistMaster(vo);
    	                //Master(INSERT) ---------------------------------- END    					
    				}                	
                }
                else{
                	if(!fom_desc.trim().equals(savename)){ 
    	            	//Master(INSERT) ---------------------------------- START
    	                //query parameter
    	                HashMap<String, String> param = new HashMap<String, String>();
    	                param.put("cre_usr_id", account.getUsr_id());
    	                param.put("upd_usr_id", account.getUsr_id());
    	                param.put("slct_itm_fom_seq", fom_seq); 
    	                param.put("slct_itm_fom_desc", savename); 
    	                
    	                createMasterList = new ArrayList();
    	                
    	                createMasterList.add(param);   
    	                
    	                vo.setMultiCreateList(createMasterList);
    	                
    	                
    	                dbDao.multiSetForm059RegistMaster(vo);
    	                //Master(INSERT) ---------------------------------- END                  		
                	}
                }
                //Detail(DELETE) ---------------------------------- START
                deleteDetailList = new ArrayList();
                
            	log.debug("slct_itm_fom_seq = "+fom_seq);
            	log.debug("cre_usr_id = "+account.getUsr_id());
            	log.debug("\n");
            	
                //query parameter
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("slct_itm_fom_seq", fom_seq); 
                param.put("cre_usr_id", account.getUsr_id()); 
                                       
                // -------------------------------------------                            
                deleteDetailList.add(param);     
                
                vo.setMultiDeleteList(deleteDetailList);
                
                
                dbDao.multiSetForm059RemoveDetail(vo);                   
        		//Detail(DELETE)---------------------------------- END   
        		
        		//Detail(INSERT) ---------------------------------- START
                if(vos.length > 0){
                	createDetailList = new ArrayList(); 
                    for(int i = 0 ; i < vos.length ; i++){   
                    	if (vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("R")) {
                            //query parameter
                            HashMap<String, String> iParam = new HashMap<String, String>();
                            iParam.put("slct_itm_fom_seq", fom_seq);
                            iParam.put("rpt_itm_cd", vos[i].getRptItmCd());  
                            iParam.put("rpt_itm_desc", vos[i].getRptItmDesc()); 
                            iParam.put("rpt_itm_col_nm", vos[i].getRptItmColNm()); 
                            iParam.put("cre_usr_id", account.getUsr_id()); 
                            iParam.put("upd_usr_id", account.getUsr_id()); 

                            // -------------------------------------------                            
                            createDetailList.add(iParam);
                    	} 
                    }
                }    	
                //SJH.20150508.소스품질
                if(createDetailList != null) {
                	vo.setMultiCreateList(createDetailList);
                } else {
                	vo.setMultiCreateList(null);
                }                
                
                dbDao.multiSetForm059RegistDetail(vo);                  
        		//Detail(INSERT)---------------------------------- END       
    		}

    		else{   	
                //query parameter
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("slct_itm_fom_seq", fom_seq); 
                param.put("cre_usr_id", account.getUsr_id());
                
                deleteMasterList = new ArrayList();
                deleteDetailList = new ArrayList();
                
                // Masert table Delete
                // -------------------------------------------                            
                deleteMasterList.add(param);
                
                //velocity parameter
                HashMap<String, Object> vParam = new HashMap<String, Object>();
                vParam.put("rpt_itm_cd", "");                       
                
                // Detail table Delete
                // -------------------------------------------                            
                deleteDetailList.add(param);
                
                vo.setMultiDeleteList(deleteDetailList);
                vo.setIndirectVariableValues(vParam);
                vo.setMultiDeleteList(deleteMasterList);                
                
                
                dbDao.multiSetForm059RemoveDetail(vo);    
                
                
                dbDao.multiSetForm059RemoveMaster(vo);                 
    		}

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            eventResponse.setETCData("selGroup", fom_seq);
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	
	
	
	/**
	 * Handling the inquiry event<br>
	 * About the MultiDimension, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return SalesRPTCommonVO
	 * @exception EventException
	 */
    public SalesRPTCommonVO searchInqByCondition060List(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {
            int headerCnt = 0;
            String[] headers = null;    
            
            String chkPrd  		= searchVo.getFChkprd();

            String txtYear    	= searchVo.getFYear().trim();
            String txtFmMonth 	= searchVo.getFFmMon().trim();
            String txtToMonth 	= searchVo.getFToMon().trim();
            String txtFmWeek  	= searchVo.getFFmWk().trim();
            String txtToWeek  	= searchVo.getFToWk().trim();
            String txtSlsMonth  = searchVo.getFSlsMon().trim();

            String pro_vw  		= searchVo.getFProVw();
            String ofc_vw  		= searchVo.getFOfcVw();
            String pro_lvl 		= searchVo.getFProLvl();

            // by Office
            String f_rhq_cd     = searchVo.getFRhqCd().trim();
            String f_sls_ofc_cd = searchVo.getFSlsOfcCd().trim();

            // by route
            String f_trd_cd     = searchVo.getFTrdCd().trim();
            String f_rlane_cd   = searchVo.getFRlaneCd().trim();
            String f_skd_dir_cd = searchVo.getFSkdDirCd().trim();

            // VVD
            String f_vsl_cd     = searchVo.getFVslCd().trim();
            String f_skd_voy_no = searchVo.getFSkdVoyNo().trim();
            String f_dir_cd     = searchVo.getFDirCd().trim();

            String f_bkg_por_cd = searchVo.getFBkgPorCd().trim();
            String f_bkg_pod_cd = searchVo.getFBkgPodCd().trim();
            String f_bkg_pol_cd = searchVo.getFBkgPolCd().trim();
            String f_rev_pol_cd = searchVo.getFRevPolCd().trim();
            String f_rev_pod_cd = searchVo.getFRevPodCd().trim();
            String f_bkg_del_cd = searchVo.getFBkgDelCd().trim();
          
            // by Customer
            String f_shpr_cd  	= searchVo.getFShipper().trim();
            String f_sc_no    	= searchVo.getFScNo().trim();
            String f_rfa_no   	= searchVo.getFRfaNo().trim();

            String f_key_acct_group  = searchVo.getFKeyAcctGroupCd().trim();
            String f_key_acct_group1 = "";

            String f_key_acc  = searchVo.getFKeyAcctIndvlCd().trim();
            String f_key_acc1 = "";
            String f_key_acc2 = "";
            String f_key_acc3 = "";

            String f_mlt_trd_group_cd  = searchVo.getFMltTrdGroupCd().trim();
            String f_mlt_trd_group1 = "";

            String f_mlt_trd_indvl_cd  = searchVo.getFMltTrdIndvlCd().trim();
            String f_mlt_trd_acc1 = "";
            String f_mlt_trd_acc2 = "";
            String f_mlt_trd_acc3 = "";

            String f_taa_no   = searchVo.getFTaaNo().trim();

            if (!f_key_acc.equals("") && !f_key_acc1.equals("All")) {
                f_key_acc1 = f_key_acc.substring(0, 2);
                f_key_acc2 = f_key_acc.substring(2);
                f_key_acc3 = "Y";
            }
            if ( !f_key_acct_group.equals("") && !f_key_acct_group.equals("All") && f_key_acc.equals("") ) {
                f_key_acct_group1 = f_key_acct_group;
            }

            if (!f_mlt_trd_indvl_cd.equals("") && !f_mlt_trd_acc1.equals("All")) {
            	f_mlt_trd_acc1 = f_mlt_trd_indvl_cd.substring(0, 2);
            	f_mlt_trd_acc2 = f_mlt_trd_indvl_cd.substring(2);
            	f_mlt_trd_acc3 = "Y";
            }
            if ( !f_mlt_trd_group_cd.equals("") && !f_mlt_trd_group_cd.equals("All") && f_mlt_trd_indvl_cd.equals("") ) {
            	f_mlt_trd_group1 = f_mlt_trd_group_cd;
            }

            // by Others
            String f_cmdt_cd        = searchVo.getFCmdtCd().trim();
            String f_usa_bkg_mod_cd = searchVo.getFUsaBkgModCd().trim();
            String f_cntr_tpsz_cd   = searchVo.getFCntrTpszCd().trim();
            String f_svc_scp_cd		= searchVo.getFSvcScpCd().trim();
            String view_tpSz        = searchVo.getFViewTpsz();
            String f_bkg_no         = searchVo.getFBkgNo().trim();
            
            String bkg_sts  = JSPUtil.getNull(searchVo.getFBkgSts());
            String dir_sts  = JSPUtil.getNull(searchVo.getFDirSts());
            String wk_sts   = JSPUtil.getNull(searchVo.getFWkSts());
            String soc_sts  = JSPUtil.getNull(searchVo.getFSocSts());
            String excl_sts = JSPUtil.getNull(searchVo.getFExclSts());

            String col_nm = searchVo.getFHeadernm();
            headers = col_nm.split("[|]");
            headerCnt = headers.length;
            if (col_nm.equals("")) {
                headerCnt = 0;
            }
            
            String[] tempColNm = col_nm.split("[|]");
            for(int j=0; j<tempColNm.length; j++){
            	tempColNm[j] = tempColNm[j].trim().toLowerCase();
            }               
            col_nm = vo.mergeParameterForArray(tempColNm, "[|]");
            
            vo.setIteratorList(vo.seperationParameter(col_nm, "[|]"));
            
            HashMap<String, Object> vParam = new HashMap<String, Object>();
            vParam.put("keyList1"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList2"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList3"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("keyList4"        , vo.getIteratorList()==null?"":vo.getIteratorList().iterator());
            vParam.put("key_acct_group" , f_key_acct_group );
            vParam.put("key_acc"        , f_key_acc        );
            vParam.put("soc_sts"        , soc_sts          );
            vParam.put("trd_cd"         , f_trd_cd         );
            vParam.put("rlane_cd"       , f_rlane_cd       );
            vParam.put("dir_cd"         , f_dir_cd         );
            vParam.put("vsl_cd"         , f_vsl_cd         );
            vParam.put("skd_voy_no"     , f_skd_voy_no     );
            vParam.put("skd_dir_cd"     , f_skd_dir_cd     );
            vParam.put("bkg_por_cd"     , f_bkg_por_cd     );
            vParam.put("bkg_pol_cd"     , f_bkg_pol_cd     );
            vParam.put("bkg_pod_cd"     , f_bkg_pod_cd     );
            vParam.put("rev_pol_cd"     , f_rev_pol_cd     );
            vParam.put("rev_pod_cd"     , f_rev_pod_cd     );
            vParam.put("bkg_del_cd"     , f_bkg_del_cd     );
            vParam.put("sc_no"          , f_sc_no          );
            vParam.put("rfa_no"         , f_rfa_no         );
            vParam.put("taa_no"         , f_taa_no         );
            vParam.put("shpr_cnt_cd"    , f_shpr_cd        );
            vParam.put("cmdt_cd"        , f_cmdt_cd        );
            vParam.put("usa_bkg_mod_cd" , f_usa_bkg_mod_cd );
            vParam.put("svc_scp_cd" 	, f_svc_scp_cd );
            vParam.put("bkg_no"         , f_bkg_no         );
            //SJH.20140806.ADD
			if(!f_bkg_no.equals("")) {
				String bkgNo = f_bkg_no;
				List<String> bkgNoList = new ArrayList<String>();
				StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
			    while (st3.hasMoreTokens()) {
			    	bkgNoList.add(st3.nextToken());
			    }			    
			    vParam.put("bkg_no_list", bkgNoList);
			}            
           // vParam.put("cntr_tpsz_cd"   , f_cntr_tpsz_cd   );
            if (f_cntr_tpsz_cd.indexOf("All") > -1) f_cntr_tpsz_cd = "";
            vParam.put("cntr_tpsz_cd", vo.seperationParameter(f_cntr_tpsz_cd, ","));
            vParam.put("key_acct_group1", f_key_acct_group1);
            vParam.put("key_acc1"       , f_key_acc1       );
            vParam.put("key_acc2"       , f_key_acc2       );
            vParam.put("key_acc3"       , f_key_acc3       );
            vParam.put("period"         , chkPrd           );
            vParam.put("sls_ofc_cd"     , f_sls_ofc_cd     );
            vParam.put("excl_sts"       , excl_sts         );   
            vParam.put("sls_month"      , txtSlsMonth      );
            vParam.put("pro_vw"         , pro_vw           );
            if (chkPrd.equals("M")) {
            	vParam.put("fm_mon", txtFmMonth);
            	vParam.put("to_mon", txtToMonth);
            }
            else if(chkPrd.equals("W")) {
            	vParam.put("fm_mon", txtSlsMonth);
            	vParam.put("to_mon", ""         );
            }            
            vParam.put("to_wk"          , txtToWeek    );
            vParam.put("wk_sts"         , wk_sts       );
            vParam.put("bkg_sts"        , bkg_sts      );
            vParam.put("tpsz_sts"       , view_tpSz    );
            vParam.put("ofc_vw"         , ofc_vw       );
            vParam.put("pro_lvl"        , pro_lvl      );
            vParam.put("fm_wk"          , txtFmWeek    );
            vParam.put("ofc_lvl"        , f_rhq_cd     );
            vParam.put("ofc_cd"         , f_sls_ofc_cd );
            vParam.put("dir_sts"        , dir_sts      );
            vParam.put("year"			, txtYear	   );
             
//            vParam.put("ias_sub_grp_cd"        , f_ias_sub_grp_cd     );
//            vParam.put("mlt_trd_group_cd"      , f_mlt_trd_group_cd );
//            vParam.put("mlt_trd_indvl_cd"      , f_mlt_trd_indvl_cd      );
//            vParam.put("mdm_charge_cd"		   , f_mdm_charge_cd	   );
//            vParam.put("mdm_charge_type_cd"		   , f_mdm_charge_type_cd	   );
            vParam.put("mlt_trd_group"   	, f_mlt_trd_group_cd	   );
            vParam.put("mlt_trd_group1"		, f_mlt_trd_group1	   );
            vParam.put("mlt_trd_indvl"		, f_mlt_trd_indvl_cd	   );
            vParam.put("mlt_trd_acc1"		, f_mlt_trd_acc1	   );
            vParam.put("mlt_trd_acc2"		, f_mlt_trd_acc2	   );
            vParam.put("mlt_trd_acc3"		, f_mlt_trd_acc3	   );

            vo.setIndirectVariableValues(vParam);        	
        	
        	SalesRPTCommonVO retVo = new SalesRPTCommonVO();

            retVo = dbDao.searchInqByCondition060List(vo);
            retVo.setHeader(searchVo.getFHeader());
            retVo.setHeaderNM(searchVo.getFHeadernm());					
            
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }    
    
    /**
     * MultiDimensionRPT, release internal object <br>
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param String userId
     * @return SalesRPTCommonVO
     * @exception EventException
     */    
    public SalesRPTCommonVO searchInqByCondition060List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {
        	String[] strItem = new String[2];
        	StringBuffer tempBuffer1 = new StringBuffer();
        	StringBuffer tempBuffer2 = new StringBuffer();
        	
        	if(!searchVo.getFSelgroup().equals("")){
        		List<SearchRptItemVO> list = searchRptItem1(searchVo, vo, userId);
        		
        		int listCnt = list.size();
    			if (listCnt > 0) {
    				for(int i=0; i<listCnt; i++){
    					tempBuffer1.append(((SearchRptItemVO)list.get(i)).getRptItmDesc());
    					tempBuffer2.append(((SearchRptItemVO)list.get(i)).getRptItmColNm());
    					if(listCnt - 1 != i ){
    						tempBuffer1.append("|");
    						tempBuffer2.append("|");  						
    					}
    				}
    			}
        		
    			strItem[0] = tempBuffer1.toString();
    			strItem[1] = tempBuffer2.toString();
        	}
        	else{
        		strItem[0] = "";
        		strItem[1] = "";
        	}
        	vo.setHeader(strItem[0]);
        	vo.setHeaderNM(strItem[1]);
            return vo;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }     
    
	/**
	 * group code list Inquiry 
	 * 
	 * @param  SearchConditionVO searchVo
	 * @param  SalesRPTCommonVO vo
	 * @param  String userId
	 * @return List<SearchRptItemVO>
	 * @throws EventException
	 */
    public List<SearchRptItemVO> searchRptItem1(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException {
        try {      	
            HashMap<String, String> qParam = new HashMap<String, String>();
            qParam.put("user_id", userId);
            qParam.put("slct_itm_fom_seq", searchVo.getFSelgroup());
            vo.setIndirectColumnValues(qParam);
            return dbDao.searchRptItem(vo);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
    
	/**
	 *MDM COSTOMER table, Customer Information Inquiry<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<ShipperVO>
	 * @exception EventException
	 */
	public List<ShipperVO> searchShipperList(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchShipperList(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

}
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CostStructureBC.java
*@FileTitle : Register code for the logistics cost and accounts list
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration.CostStructureDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureCommonVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.MainGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.NodLnkCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0139ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SubGrpCostCodeVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.TableColumnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaSpclRepoCntrRgstVO;
import com.clt.syscommon.common.table.CoaStndAcctVO;
import com.clt.syscommon.common.table.CoaTrnsFdrTermVO;
import com.clt.syscommon.common.table.CoaTrnsTermCalcVO;
import com.clt.syscommon.common.table.CoaUsaSvcModVO;
import com.clt.syscommon.common.table.CoaWkPrdVO;


/**
 * COA Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESM_COA_002EventResponse,CostStructureBC reference the each DAO class 
 * @since J2EE 1.4
 */
public class CostStructureBCImpl extends BasicCommandSupport implements CostStructureBC {

	// Database Access Object
	private transient CostStructureDBDAO dbDao=null;
	
	//EAI object
	//private transient CostStructureEAIDAO eaiDao = null;

	/**
	 * CostStructureBCImpl Object creation<br>
	 * CostStructureDBDAO Creation<br> 
	 */
	public CostStructureBCImpl(){
		dbDao = new CostStructureDBDAO();
		//eaiDao = new CostStructureEAIDAO();
	}

	/**
	 * Handling the inquiry event<br>
	 * ESM_COA_0001(Set List Box) About the  Handling the inquiry event<br>
	 * 
	 * @return List<SpclRepoCntrVO>
	 * @exception EventException
	 */
	public List<SpclRepoCntrVO> searchSpclRepoCntrList() throws EventException {
		try {
			return dbDao.searchSpclRepoCntrList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Handling multi event<br>
	 * ESM_COA_0001(Set List Box), Handling multi event<br>
	 * 
	 * @param CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpclRepoCntr(CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaSpclRepoCntrRgstVO> insertVoList = new ArrayList<CoaSpclRepoCntrRgstVO>();
			List<CoaSpclRepoCntrRgstVO> updateVoList = new ArrayList<CoaSpclRepoCntrRgstVO>();
			List<CoaSpclRepoCntrRgstVO> deleteVoList = new ArrayList<CoaSpclRepoCntrRgstVO>();
			
			for ( int i=0; i<coaSpclRepoCntrRgstVO.length; i++ ) {
				if ( coaSpclRepoCntrRgstVO[i].getIbflag().equals("I")){
					coaSpclRepoCntrRgstVO[i].setRepoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getRepoFlg()));
					coaSpclRepoCntrRgstVO[i].setSpclCgoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getSpclCgoFlg()));
					coaSpclRepoCntrRgstVO[i].setDeltFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getDeltFlg()));
					coaSpclRepoCntrRgstVO[i].setCreUsrId(account.getUsr_id());
					coaSpclRepoCntrRgstVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(coaSpclRepoCntrRgstVO[i]);
				} else if ( coaSpclRepoCntrRgstVO[i].getIbflag().equals("U")){
					coaSpclRepoCntrRgstVO[i].setRepoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getRepoFlg()));
					coaSpclRepoCntrRgstVO[i].setSpclCgoFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getSpclCgoFlg()));
					coaSpclRepoCntrRgstVO[i].setDeltFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getDeltFlg()));
					coaSpclRepoCntrRgstVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaSpclRepoCntrRgstVO[i]);
				} else if ( coaSpclRepoCntrRgstVO[i].getIbflag().equals("D")){
					coaSpclRepoCntrRgstVO[i].setDeltFlg(Utils.change10ToYN(coaSpclRepoCntrRgstVO[i].getDeltFlg()));
					deleteVoList.add(coaSpclRepoCntrRgstVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpclRepoCntr(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpclRepoCntr(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpclRepoCntr(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Handling the inquiry event<br>
	 * ESM_COA_0002(Cost Element), Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO  searchVo
	 * @return List<SearchCostCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCostCodeListVO> searchCostCodeList(SearchConditionVO searchVo) throws EventException {
		try {
			CostStructureCommonVO vo = new CostStructureCommonVO();
			vo.setIndirectColumnValues(searchVo.getColumnValues());
			return dbDao.searchCostCodeList(vo);
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
	 * ESM_COA_0002(Cost Element), Handling multi event<br>
	 * 
	 * @param CoaStndAcctVO[] vos
	 * @param String userId
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCostCode(CoaStndAcctVO[] vos, String userId) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		try{
			List createList = new ArrayList();
			List updateList = new ArrayList();
			List deleteList = new ArrayList();	     

			// 
			//----------------------------------------------------
            if(vos.length > 0){
                for(int i = 0 ; i < vos.length ; i++){

                    if(vos[i].getIbflag().equals("I")) {
                        //query parameter
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("stnd_cost_cd"	  , vos[i].getStndCostCd()	);
                        param.put("stnd_cost_nm"	  , vos[i].getStndCostNm()	);
                        param.put("mgrp_cost_cd"	  , vos[i].getMgrpCostCd()	);
                        param.put("sgrp_cost_cd"	  , vos[i].getSgrpCostCd()	);
                        param.put("perf_vw_cd"        , vos[i].getPerfVwCd()	);
                        param.put("ra_stnd_cost_desc" , vos[i].getRaStndCostDesc());
                        param.put("ra_acct_cd"        , vos[i].getRaAcctCd()	);
                        param.put("ra_mn_cost_cd"     , vos[i].getRaMnCostCd()	);
                        param.put("ra_sgrp_cost_cd"   , vos[i].getRaSgrpCostCd());
                        param.put("ra_perf_vw_cd"     , vos[i].getRaPerfVwCd()	);
                        param.put("hir_scp_flg"       , Utils.change10ToYN(vos[i].getHirScpFlg()));	
                        param.put("acct_dp_seq"      , vos[i].getAcctDpSeq()     );
                        param.put("upd_usr_id"        , userId					);
                        createList.add(param);
                    }
                    else if(vos[i].getIbflag().equals("U")) {
                    	
                        //query parameter
                    	HashMap<String, String> param = new HashMap<String, String>();
                    	param.put("delt_flg"          , Utils.change10ToYN(vos[i].getDeltFlg()));
                    	param.put("stnd_cost_nm"      , vos[i].getStndCostNm()     );
                    	param.put("mgrp_cost_cd"      , vos[i].getMgrpCostCd()     );
                    	param.put("sgrp_cost_cd"      , vos[i].getSgrpCostCd()     );
                    	param.put("perf_vw_cd"        , vos[i].getPerfVwCd()       );
                    	param.put("ra_stnd_cost_desc" , vos[i].getRaStndCostDesc() );
                    	param.put("ra_acct_cd"        , vos[i].getRaAcctCd()       );
                    	param.put("ra_mn_cost_cd"     , vos[i].getRaMnCostCd()     );
                    	param.put("ra_sgrp_cost_cd"   , vos[i].getRaSgrpCostCd()   );
                	  	param.put("ra_perf_vw_cd"     , vos[i].getRaPerfVwCd()     );
                	  	param.put("hir_scp_flg"       , Utils.change10ToYN(vos[i].getHirScpFlg()));
                	  	param.put("upd_usr_id"        , userId                     );
                	  	param.put("stnd_cost_cd"      , vos[i].getStndCostCd()     );
                	  	param.put("acct_dp_seq"      , vos[i].getAcctDpSeq()     );
                        updateList.add(param);
                    }
                    else if(vos[i].getIbflag().equals("D")) {
                        //query parameter
                    	HashMap<String, String> param = new HashMap<String, String>();
                    	param.put("upd_usr_id"  , userId                );
                        param.put("stnd_cost_cd", vos[i].getStndCostCd());
                    	deleteList.add(param);
                    }                        
                }
            }    
            
            CostStructureCommonVO vo = new CostStructureCommonVO();
            vo.setMultiCreateList(createList);
            vo.setMultiUpdateList(updateList);
            vo.setMultiDeleteList(deleteList);				
			
			dbDao.multiCostCode(vo);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse; // "SUCCESS"
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	


	/**
	 * Header <br>
	 * ESM_COA_003(So Cost Code), Handling the inquiry event<br>
	 * 
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList() throws EventException {
		CostStructureSoCodeRtnVO returnVal = new CostStructureSoCodeRtnVO();
		DBRowSet rowSet2 = null;
		StringBuffer headerCode = new  StringBuffer();
		StringBuffer headerText = new  StringBuffer();
		try {
			rowSet2 = dbDao.getVariableHeader();

			int total = rowSet2.getRowCount();

			while(rowSet2.next()){
				headerCode.append(rowSet2.getString("code"));
				headerText.append(rowSet2.getString("name"));
				if(--total != 0){
					headerCode.append("|");
					headerText.append("|");
				}
			}
			
			returnVal.setHeaderCode(headerCode.toString());
			returnVal.setHeaderText(headerText.toString());

			return returnVal;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Handling the inquiry event<br>
	 * ESM_COA_003(So Cost Code), Handling the inquiry event<br>
	 * 
	 * @param CostStructureConditionVO vo
	 * @param String userId
	 * @return CostStructureSoCodeRtnVO
	 * @exception EventException
	 */
	public CostStructureSoCodeRtnVO searchSoCodeList(CostStructureConditionVO vo, String userId) throws EventException {
		CostStructureSoCodeRtnVO returnVal = new CostStructureSoCodeRtnVO();
		
		DBRowSet rowSet = null; //  DB ResultSet
		DBRowSet rowSet2 = null;
		
		StringBuffer headerCode = new  StringBuffer();
		StringBuffer headerText = new  StringBuffer();
		
		try {
			rowSet = dbDao.searchSoCodeList(vo, userId);	
			returnVal.setRowSet(rowSet);
			
			if("".equals(vo.getFHeaderCode()) || vo.getFHeaderCode()==null) {
				rowSet2 = dbDao.getVariableHeader();
			
				int total = rowSet2.getRowCount();	
				while(rowSet2.next()){
					headerCode.append(rowSet2.getString("code"));
					headerText.append(rowSet2.getString("name"));
					if(--total != 0){
						headerCode.append("|");
						headerText.append("|");
					}
				}
				returnVal.setHeaderCode(headerCode.toString());
				returnVal.setHeaderText(headerText.toString());
			}else{
				returnVal.setHeaderCode(vo.getFHeaderCode());
				returnVal.setHeaderText(vo.getFHeaderText());
			}
			return returnVal;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Handling multi event<br>
	 * ESM_COA_003(So Cost Code), Handling multi event<br>
	 * 
	 * @param SearchSoCodeListVO vo
	 * @param SearchSoCodeListVO[] vos
	 * @param String userId
	 * @exception EventException
	 */
	public void multiSoCode(SearchSoCodeListVO vo, SearchSoCodeListVO[] vos, String userId) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		List saveList = new ArrayList();
		List saveList2 = new ArrayList();
		String[] hdCdArr = null;
				
		try {
			hdCdArr = (vo.getHashAttribute("f_header_code")[0]).replace('|', ',').split(","); 
			if(vos.length > 0){
				HashMap<String, String> param = null;
				HashMap<String, String> param2 = null;
				
                for(int i = 0 ; i < vos.length ; i++){
                	if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")) {
	                	//query parameter
	                    param = vos[i].getColumnValues();
	                    param.put("user_id"   , userId);
	                    

	                    param.put("bkg_full_soc_cgo_flg", Utils.change10ToYN(vos[i].getBkgFullSocCgoFlg()));
                    	param.put("bkg_mcgo_flg"		, Utils.change10ToYN(vos[i].getBkgMcgoFlg()));
                    	param.put("bkg_rev_mcgo_flg"	, Utils.change10ToYN(vos[i].getBkgRevMcgoFlg()));
                    	param.put("spcl_cgo_dg_flg"		, Utils.change10ToYN(vos[i].getSpclCgoDgFlg()));
                    	param.put("spcl_cgo_bb_flg"		, Utils.change10ToYN(vos[i].getSpclCgoBbFlg()));
                    	param.put("spcl_cgo_awk_flg"	, Utils.change10ToYN(vos[i].getSpclCgoAwkFlg()));
                    	param.put("spcl_cgo_rf_flg"		, Utils.change10ToYN(vos[i].getSpclCgoRfFlg()));
                    	param.put("delt_flg"			, Utils.change10ToYN(vos[i].getDeltFlg()));
                    	
                    	saveList.add(param);
//                    	log.debug("saveList===" + saveList.toString());

                    	for(int k = 0 ; k < hdCdArr.length ; k++){
                    		
                    		param2 = new HashMap();
                    		param2.put("cost_act_grp_cd", hdCdArr[k]);  
                    		param2.put("coa_cost_src_cd", vos[i].getCoaCostSrcCd());
                    		param2.put("cost_aply_flg", Utils.change10ToYN( vo.getHashAttribute(hdCdArr[k].toLowerCase())[i])); 
                    		param2.put("user_id", userId);
                    		                    		
                    		saveList2.add(param2);                    		
                    	}
                    }                 
                }
            }			
            vo.setMultiSaveList(saveList);
            vo.setMultiSaveList2(saveList2);
			
			dbDao.multiSoCodeSrcAcct(vo);
			dbDao.multiSoCodeCostMapg(vo);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * Feeder Term<br>
	 * ESM_COA_0139
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchCostStructure0139ListVO>
	 * @exception EventException
	 */
	public List<SearchCostStructure0139ListVO> searchCostStructure0139List(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchCostStructure0139List(searchConditionVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * <br>
	 * 
	 * @param CoaTrnsFdrTermVO[] coaTrnsFdrTermVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0139(CoaTrnsFdrTermVO[] coaTrnsFdrTermVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaTrnsFdrTermVO> insertupdateVoList = new ArrayList<CoaTrnsFdrTermVO>();			
			List<CoaTrnsFdrTermVO> deleteVoList = new ArrayList<CoaTrnsFdrTermVO>();
			
			for ( int i=0; i<coaTrnsFdrTermVO .length; i++ ) {
				if ( coaTrnsFdrTermVO[i].getIbflag().equals("I")){
					 coaTrnsFdrTermVO[i].setCreUsrId(account.getUsr_id());
					 coaTrnsFdrTermVO[i].setUpdUsrId(account.getUsr_id());
					 insertupdateVoList.add(coaTrnsFdrTermVO[i]);
				} else if ( coaTrnsFdrTermVO[i].getIbflag().equals("U")){
					coaTrnsFdrTermVO[i].setUpdUsrId(account.getUsr_id());									
					insertupdateVoList.add(coaTrnsFdrTermVO[i]);
				} else if ( coaTrnsFdrTermVO[i].getIbflag().equals("D")){
					deleteVoList.add(coaTrnsFdrTermVO[i]);
				}
			}
			
			if ( insertupdateVoList.size() > 0 ) {
				dbDao.modifyCostStructure0139(insertupdateVoList);
			}			
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCostStructure0139(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * <br>
	 * 
	 * @param SearchCostStructure0140ListVO searchCostStructure0140List
	 * @param SearchConditionVO searchCondition
	 * @return List<SearchCostStructure0140ListVO>
	 * @exception EventException
	 */
	public List<SearchCostStructure0140ListVO> searchCostStructure0140List(SearchCostStructure0140ListVO searchCostStructure0140List
			                                                              ,SearchConditionVO searchCondition) throws EventException {
		try {
			return dbDao.searchCostStructure0140List(searchCostStructure0140List, searchCondition);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * <br>
	 * 
	 * @param CoaTrnsTermCalcVO[] coaTrnsTermCalcVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0140(CoaTrnsTermCalcVO[] coaTrnsTermCalcVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaTrnsTermCalcVO> insertupdateVoList = new ArrayList<CoaTrnsTermCalcVO>();			
			List<CoaTrnsTermCalcVO> deleteVoList = new ArrayList<CoaTrnsTermCalcVO>();
			for ( int i=0; i<coaTrnsTermCalcVO .length; i++ ) {
				if ( coaTrnsTermCalcVO[i].getIbflag().equals("I")||coaTrnsTermCalcVO[i].getIbflag().equals("U")){
					coaTrnsTermCalcVO[i].setCreUsrId(account.getUsr_id());
					coaTrnsTermCalcVO[i].setUpdUsrId(account.getUsr_id());
					insertupdateVoList.add(coaTrnsTermCalcVO[i]);
				} else if ( coaTrnsTermCalcVO[i].getIbflag().equals("D")){
					deleteVoList.add(coaTrnsTermCalcVO[i]);
				}
			}
			
			if ( insertupdateVoList.size() > 0 ) {
				dbDao.modifyCostStructure0140(insertupdateVoList);
			}			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCostStructure0140(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 *Sheet1 column list Inquiry(NODE, LINK))<br>
	 * 
	 * @param String fTableName
	 * @return List<TableColumnVO>
	 * @exception EventException
	 */
	public List<TableColumnVO> searchCostStructure0137List(String fTableName ) throws EventException {
		try {
			return dbDao.searchCostStructure0137List(fTableName);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * NODE,LINK unit cost Inquiry<br>
	 * 
	 * @param String fTableName
	 * @param TableColumnVO[] tableColumnVOs
	 * @return List<NodLnkCostCodeVO>
	 * @exception EventException
	 */
	public List<NodLnkCostCodeVO> searchCostStructure0137List2(String fTableName, TableColumnVO[] tableColumnVOs) throws EventException {
		try {
			return dbDao.searchCostStructure0137List2( fTableName,  tableColumnVOs);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * NODE, LINK unit cost, Creation/Update/Delete<br>
	 * 
	 * @param String fTableName
	 * @param NodLnkCostCodeVO[] nodLnkCostCodeVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCostStructure0137(String fTableName, NodLnkCostCodeVO[] nodLnkCostCodeVOs, SignOnUserAccount account) throws EventException{
		try {
			List<NodLnkCostCodeVO> mergeVoList = new ArrayList<NodLnkCostCodeVO>();
			List<NodLnkCostCodeVO> deleteVoList = new ArrayList<NodLnkCostCodeVO>();
			for ( int i=0; i<nodLnkCostCodeVOs .length; i++ ) {
				if ( nodLnkCostCodeVOs[i].getIbflag().equals("I")){
					nodLnkCostCodeVOs[i].setCreUsrId(account.getUsr_id());
					nodLnkCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(nodLnkCostCodeVOs[i]);
				} else if ( nodLnkCostCodeVOs[i].getIbflag().equals("U")){
					nodLnkCostCodeVOs[i].setCreUsrId(account.getUsr_id());
					nodLnkCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(nodLnkCostCodeVOs[i]);
				} else if ( nodLnkCostCodeVOs[i].getIbflag().equals("D")){
					deleteVoList.add(nodLnkCostCodeVOs[i]);
				}
			}
			
			if ( mergeVoList.size() > 0) {
				dbDao.modifyCostStructure0137(fTableName, mergeVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCostStructure0137(fTableName, deleteVoList);
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
	 * Create a office in the "Register C/A Code"<br>
	 * 
	 * @param  SearchConditionVO searchconditionVO
	 * @exception EventException
	 */
	public void createOfficeLevel(SearchConditionVO searchconditionVO) throws EventException{
		try {
			dbDao.addOfficeLevel(searchconditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Year month Inquiry<br>
	 * 
	 * @return String
	 * @exception EventException
	 */	
	public String searchYearMonthValue() throws EventException{
		try {
			return dbDao.searchYearMonthValue();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Year month  Update<br>
	 * 
	 * @param  SearchConditionVO searchconditionVO
	 * @exception EventException
	 */	
	public void multiYearMonthValue(SearchConditionVO searchconditionVO) throws EventException{
		try {
			dbDao.modifyYearMonthValue(searchconditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Main Group Cost Code retrieve<br>
	 * 
	 * @param  String stndCostTpCd
	 * @return List<MainGrpCostCodeVO>
	 * @exception EventException
	 */	
	public List<MainGrpCostCodeVO> searchMainGrpCostCode(String stndCostTpCd) throws EventException {
		try {
			return dbDao.searchMainGrpCostCode(stndCostTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * Main Group Cost Code add/modify/remove<br>
	 * 
	 * @param  MainGrpCostCodeVO[] mainGrpCostCodeVOs
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String multiMainGrpCostCode(MainGrpCostCodeVO[] mainGrpCostCodeVOs, SignOnUserAccount account) throws EventException {
		String result = "S";
		try {
			List<MainGrpCostCodeVO> insertVoList = new ArrayList<MainGrpCostCodeVO>();
			List<MainGrpCostCodeVO> updateVoList = new ArrayList<MainGrpCostCodeVO>();
			List<MainGrpCostCodeVO> deleteVoList = new ArrayList<MainGrpCostCodeVO>();

			for(int i=0; i<mainGrpCostCodeVOs.length;i++){
			
				if(mainGrpCostCodeVOs[i].getIbflag().equals("I")){
					int checkCnt = dbDao.checkAddMainGrpCostCode(mainGrpCostCodeVOs[i]); // code dup
					int checkDescCnt = dbDao.checkMainGrpCostCodeDesc(mainGrpCostCodeVOs[i]); // code description dup
					if(checkCnt == 0 && checkDescCnt == 0){
						mainGrpCostCodeVOs[i].setCreUsrId(account.getUsr_id());
						mainGrpCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(mainGrpCostCodeVOs[i]);
					}else if(checkCnt == 0 && checkDescCnt != 0){
						result = "DescDup";
					}else {
						result = "Dup";
					}
				}
				else if(mainGrpCostCodeVOs[i].getIbflag().equals("U")){
					int checkDescCnt = dbDao.checkMainGrpCostCodeDesc(mainGrpCostCodeVOs[i]); // code description dup
					if(checkDescCnt == 0){
						mainGrpCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(mainGrpCostCodeVOs[i]);
					}else {
						result = "DescDup";
					}					
				}
				else if(mainGrpCostCodeVOs[i].getIbflag().equals("D")){

					int subCheckCnt = dbDao.checkSubGrpCostCodeFromMain(mainGrpCostCodeVOs[i]);
					if(subCheckCnt == 0){
						deleteVoList.add(mainGrpCostCodeVOs[i]);
					}else{
						result = "SubEx";
					}
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addMainGrpCostCode(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyMainGrpCostCode(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeMainGrpCostCode(deleteVoList);
			}

			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * Sub Group Cost Code retrieve<br>
	 * 
	 * @param  String stndCostTpCd
	 * @param  String mainGroupCostCd
	 * @return List<SubGrpCostCodeVO>
	 * @exception EventException
	 */	
	public List<SubGrpCostCodeVO> searchSubGrpCostCode(String stndCostTpCd, String mainGroupCostCd) throws EventException {
		try {
			return dbDao.searchSubGrpCostCode(stndCostTpCd,mainGroupCostCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * Sub Group Cost Code add/modify/remove<br>
	 * 
	 * @param  SubGrpCostCodeVO[] subGrpCostCodeVOs
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String multiSubGrpCostCode(SubGrpCostCodeVO[] subGrpCostCodeVOs, SignOnUserAccount account) throws EventException {

		String result = "S";
		try {
			List<SubGrpCostCodeVO> insertVoList = new ArrayList<SubGrpCostCodeVO>();
			List<SubGrpCostCodeVO> updateVoList = new ArrayList<SubGrpCostCodeVO>();
			List<SubGrpCostCodeVO> deleteVoList = new ArrayList<SubGrpCostCodeVO>();

			for(int i=0; i<subGrpCostCodeVOs.length;i++){
			
				if(subGrpCostCodeVOs[i].getIbflag().equals("I")){
					int checkCnt = dbDao.checkSubGrpCostCode(subGrpCostCodeVOs[i]);// code dup
					int checkDescCnt = dbDao.checkSubGrpCostCodeDesc(subGrpCostCodeVOs[i]);// code desc dup
					if(checkCnt == 0 && checkDescCnt == 0){
						log.debug(subGrpCostCodeVOs[i]);
						subGrpCostCodeVOs[i].setCreUsrId(account.getUsr_id());
						subGrpCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(subGrpCostCodeVOs[i]);
					}else if(checkCnt == 0 && checkDescCnt != 0){
						result = "DescDup";
					}else {
						result = "Dup";
					}
				}
				else if(subGrpCostCodeVOs[i].getIbflag().equals("U")){
					int checkDescCnt = dbDao.checkSubGrpCostCodeDesc(subGrpCostCodeVOs[i]); // code description dup
					if(checkDescCnt == 0){
						subGrpCostCodeVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(subGrpCostCodeVOs[i]);
					}else {
						result = "DescDup";
					}		
				}
				else if(subGrpCostCodeVOs[i].getIbflag().equals("D")){
					int caCheckCnt = dbDao.checkCaCodeFromSub(subGrpCostCodeVOs[i]);
					if(caCheckCnt == 0){
						deleteVoList.add(subGrpCostCodeVOs[i]);
					}else{
						result = "CaEx";
					}
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addSubGrpCostCode(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifySubGrpCostCode(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeSubGrpCostCode(deleteVoList);
			}

			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * Retrieving USA Service Mode<br>
	 * 
	 * @param String orgRgnCd
	 * @param String destRgnCd
	 * @param String svcModCd   
	 * @return List<CoaUsaSvcModVO>
	 * @exception EventException
	 */
	public List<CoaUsaSvcModVO> searchUsaServiceMode(String orgRgnCd, String destRgnCd, String svcModCd) throws EventException {
		try {
			return dbDao.searchUsaServiceModeListData(orgRgnCd, destRgnCd, svcModCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Saving USA Service Mode<br>
	 * 
	 * @param CoaUsaSvcModVO[] coaUsaSvcModVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiUsaServiceMode(CoaUsaSvcModVO[] coaUsaSvcModVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CoaUsaSvcModVO> insertVoList = new ArrayList<CoaUsaSvcModVO>();
			List<CoaUsaSvcModVO> updateVoList = new ArrayList<CoaUsaSvcModVO>();
			List<CoaUsaSvcModVO> deleteVoList = new ArrayList<CoaUsaSvcModVO>();
			for ( int i=0; i<coaUsaSvcModVOs .length; i++ ) {
				if ( coaUsaSvcModVOs[i].getIbflag().equals("I")){
					coaUsaSvcModVOs[i].setCreUsrId(account.getUsr_id());
					coaUsaSvcModVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(coaUsaSvcModVOs[i]);
				} else if ( coaUsaSvcModVOs[i].getIbflag().equals("U")){
					coaUsaSvcModVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaUsaSvcModVOs[i]);
				} else if ( coaUsaSvcModVOs[i].getIbflag().equals("D")){
					deleteVoList.add(coaUsaSvcModVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addUsaServiceModeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyUsaServiceModeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeUsaServiceModeData(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Retrieving Week Period<br>
	 * 
	 * @param String costYr
	 * @param String costWkFm
	 * @param String costWkTo   
	 * @return List<CoaWkPrdVO>
	 * @exception EventException
	 */
	public List<CoaWkPrdVO> searchWeekPeriod(String costYr, String costWkFm, String costWkTo) throws EventException {
		try {
			return dbDao.searchWeekPeriodListData(costYr, costWkFm, costWkTo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * Saving Week Period<br>
	 * 
	 * @param CoaWkPrdVO[] coaWkPrdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiWeekPeriod(CoaWkPrdVO[] coaWkPrdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CoaWkPrdVO> insertVoList = new ArrayList<CoaWkPrdVO>();
			List<CoaWkPrdVO> updateVoList = new ArrayList<CoaWkPrdVO>();
			List<CoaWkPrdVO> deleteVoList = new ArrayList<CoaWkPrdVO>();
			for ( int i=0; i<coaWkPrdVOs .length; i++ ) {
				if ( coaWkPrdVOs[i].getIbflag().equals("I")){
					coaWkPrdVOs[i].setCreUsrId(account.getUsr_id());
					coaWkPrdVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(coaWkPrdVOs[i]);
				} else if ( coaWkPrdVOs[i].getIbflag().equals("U")){
					coaWkPrdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaWkPrdVOs[i]);
				} else if ( coaWkPrdVOs[i].getIbflag().equals("D")){
					deleteVoList.add(coaWkPrdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addWeekPeriodData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyWeekPeriodData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeWeekPeriodData(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}





/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : OPMasterBCImpl.java
*@FileTitle      : Route Creation/Inquiry/Update
*Open Issues     :
*Change history  :
*@LastModifyDate :
*@LastModifier   :
*@LastVersion    : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.apps.opus.esm.coa.common.basic.CommonBC;
import com.clt.apps.opus.esm.coa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.MultiHistVSLInfoVslSeqVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.MultiOmPortMngVO;				//20150519.ADD
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaLaneRgstVO;
import com.clt.syscommon.common.table.CoaLaneTpHisVO;
import com.clt.syscommon.common.table.CoaVslRgstVO;
import com.clt.syscommon.common.table.CoaVslSubTrdCapaVO;

/**
 * COA Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESM_COA_036EventResponse,OPMasterBC reference the each DAO class 
 * @since J2EE 1.4
 */
public class OPMasterBCImpl extends BasicCommandSupport implements OPMasterBC {

	// Database Access Object
	private transient OPMasterDBDAO dbDao = null;

	/**
	 * OPMasterBCImpl Object creation<br>
	 * OPMasterDBDAO Creation<br>
	 */
	public OPMasterBCImpl() {
		dbDao = new OPMasterDBDAO();
	}


    /**
     * 1. Function : OPMaster route management, Handling the inquiry event<p>
     *         ( UI - ESM_COA_0036 )
     * 2. Overview : <p>
     *    - route management에 대한 리스트 inquiry
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @param SignOnUserAccount account
     * @return List<SearchRgstLaneListVO>
     * @exception EventException
     */
    public List<SearchRgstLaneListVO> searchRgstLaneList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
        try {           
            return dbDao.searchRgstLaneList(searchVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

    /**
	 * OPMaster route management, 멀티처리한다.<br>
	 * ESM_COA_0036, event handling<br>
	 * 
	 * @param SearchConditionVO searchVo
     * @param CoaLaneRgstVO[] coaLaneRgstVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
	 */
    public EventResponse multiRgstLane(SearchConditionVO searchVo, CoaLaneRgstVO[] coaLaneRgstVOs, SignOnUserAccount account) throws EventException{
        try{
            List<CoaLaneRgstVO> insertRgstLaneVOList = new ArrayList<CoaLaneRgstVO>();
            List<CoaLaneRgstVO> updateRgstLaneVOList = new ArrayList<CoaLaneRgstVO>();
            List<CoaLaneRgstVO> deleteRgstLaneVOList = new ArrayList<CoaLaneRgstVO>();
            
            String stupFlg		= null;
            String sctrPrcFlg	= null;
            String lodSplCngFlg	= null;
            String pctlLaneChkFlg=null;
            
			for( int i =0; i < coaLaneRgstVOs.length; i++ ){
				stupFlg		   = Utils.change10ToYN(coaLaneRgstVOs[i].getStupFlg());
				sctrPrcFlg	   = Utils.change10ToYN(coaLaneRgstVOs[i].getSctrPrcFlg());
				lodSplCngFlg   = Utils.change10ToYN(coaLaneRgstVOs[i].getLodSplCngFlg());
				pctlLaneChkFlg = Utils.change10ToYN(coaLaneRgstVOs[i].getPctlLaneChkFlg());
//				stupFlg		= Utils.iif(coaLaneRgstVOs[i].getStupFlg().equals("1"), "Y", "N");
//				sctrPrcFlg	= Utils.iif(coaLaneRgstVOs[i].getSctrPrcFlg().equals("1"), "Y", "N");
//				lodSplCngFlg= Utils.iif(coaLaneRgstVOs[i].getLodSplCngFlg().equals("1"), "Y", "N");
//				pctlLaneChkFlg= Utils.iif(coaLaneRgstVOs[i].getPctlLaneChkFlg().equals("1"), "Y", "N");
				
				if(coaLaneRgstVOs[i].getIbflag().equals("I")) {
					coaLaneRgstVOs[i].setStupFlg(stupFlg);
					coaLaneRgstVOs[i].setSctrPrcFlg(sctrPrcFlg);
					coaLaneRgstVOs[i].setCreUsrId(account.getUsr_id());
					coaLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					coaLaneRgstVOs[i].setLodSplCngFlg(lodSplCngFlg);
					coaLaneRgstVOs[i].setPctlLaneChkFlg(pctlLaneChkFlg);
					insertRgstLaneVOList.add(coaLaneRgstVOs[i]);
				} else if(coaLaneRgstVOs[i].getIbflag().equals("U")) {					
					coaLaneRgstVOs[i].setStupFlg(stupFlg);
					coaLaneRgstVOs[i].setSctrPrcFlg(sctrPrcFlg);
					coaLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					coaLaneRgstVOs[i].setLodSplCngFlg(lodSplCngFlg);
					coaLaneRgstVOs[i].setPctlLaneChkFlg(pctlLaneChkFlg);
					updateRgstLaneVOList.add(coaLaneRgstVOs[i]);
				} else if(coaLaneRgstVOs[i].getIbflag().equals("D")) {
					//20150812.MOD
					coaLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					deleteRgstLaneVOList.add(coaLaneRgstVOs[i]);
				}
			}
			
			if( insertRgstLaneVOList.size() > 0 ){ 
				dbDao.addRgstLane(insertRgstLaneVOList);
			}
			if( updateRgstLaneVOList.size() > 0 ){
				dbDao.modifyRgstLane(updateRgstLaneVOList);
			}
			if ( deleteRgstLaneVOList.size() > 0 ){
				dbDao.deleteRgstLane(deleteRgstLaneVOList);
			}

            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
	    } catch (DAOException de) {
	        log.error("err "+de.toString(),de);
	        throw new EventException(de.getMessage());
		} catch (Exception et) {
			log.error("err " + et.toString(), et);
			throw new EventException(et.getMessage());
		}	
    }	

    	

    /**
     * 1. Function : OPMaster route management, Handling multi event(ESM_COA_0037)<p>
     * 2. Overview : <p>
     *    - OPMaster에 대한 list를 inquiry
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * 
     * 명칭 변경 multiVSLInfo --->  multiVslRgst
     * @param SearchConditionVO searchVo
     * @param CommonCoaRsVO commonCoaRsVO
     * @param CoaVslRgstVO[] coaVslRgstVOs
     * @param CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiVslRgst(SearchConditionVO searchVo, CommonCoaRsVO commonCoaRsVO, CoaVslRgstVO[] coaVslRgstVOs, CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException{
        try{
            List<CoaVslRgstVO> insertMstVOList = new ArrayList<CoaVslRgstVO>();
            List<CoaVslRgstVO> updateMstVOList = new ArrayList<CoaVslRgstVO>();
            List<CoaVslRgstVO> deleteMstVOList = new ArrayList<CoaVslRgstVO>();

            List<CoaVslSubTrdCapaVO> insertDetailVOList = new ArrayList<CoaVslSubTrdCapaVO>();
            List<CoaVslSubTrdCapaVO> updateDetailVOList = new ArrayList<CoaVslSubTrdCapaVO>();
            List<CoaVslSubTrdCapaVO> deleteDetailVOList = new ArrayList<CoaVslSubTrdCapaVO>();

    		String vslCd = null;
			HashMap<String, String> qParam = new HashMap<String, String>();
			String header = searchVo.getFHeader();
			String[] subTrdCd = header.split("[|]");
			
			int subTrdCount = 0;
			if (!header.equals("")) {
				subTrdCount = subTrdCd.length;
			}

			if ( coaVslRgstVOs.length > 0 ){
				for(int i = 0 ; i < coaVslRgstVOs.length ; i++){
					if(coaVslRgstVOs[i].getIbflag().equals("I")) {
						coaVslRgstVOs[i].setCreUsrId(account.getUsr_id());
						coaVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						insertMstVOList.add(coaVslRgstVOs[i]);
					} else if(coaVslRgstVOs[i].getIbflag().equals("U")) {
						coaVslRgstVOs[i].setCreUsrId(account.getUsr_id());
						coaVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						updateMstVOList.add(coaVslRgstVOs[i]);
					} else if(coaVslRgstVOs[i].getIbflag().equals("D")) {
						coaVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						deleteMstVOList.add(coaVslRgstVOs[i]);
					}
				}
			}
			
            if(coaVslSubTrdCapaVOs.length > 0){
            	for(int i = 0 ; i < coaVslSubTrdCapaVOs.length ; i++){					
            		if(coaVslSubTrdCapaVOs[i].getIbflag().equals("I") || coaVslSubTrdCapaVOs[i].getIbflag().equals("U")) {
            			for (int j = 0; j < subTrdCount; j++) {
            				String[] subTrdCapa = commonCoaRsVO.getHashAttribute(subTrdCd[j]);
            				vslCd = coaVslSubTrdCapaVOs[i].getVslCd();
    						
    						if (!subTrdCapa[i].equals("")) {
    							CoaVslSubTrdCapaVO coaVslSubTrdCapaVO = new CoaVslSubTrdCapaVO();

    							coaVslSubTrdCapaVO.setVslCd(vslCd);
    							coaVslSubTrdCapaVO.setVslSeq(coaVslSubTrdCapaVOs[i].getVslSeq());
    							coaVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
    							coaVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);
    							coaVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
    							coaVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
    							
    							insertDetailVOList.add(coaVslSubTrdCapaVO);
    							updateDetailVOList.add(coaVslSubTrdCapaVO);
    							deleteDetailVOList.add(coaVslSubTrdCapaVOs[i]);
    						}
    					}			
            		}
            	}
            }
            
            // Insert
			if ( insertMstVOList.size() > 0 ){
				/////////////////////////////////////////
				//Insert 전 Vessel 등록 유무 check 후 진행
				List<SearchVslInfoListVO> vslCount = null;				
				for(int i=0; i<insertMstVOList.size(); i++ ) {
					vslCount = dbDao.searchVslCount(insertMstVOList.get(i));
					
					if(vslCount.size() > 0) {
						throw new EventException(new ErrorHandler("COA10043",new String[]{insertMstVOList.get(i).getVslCd()}).getMessage());
					}
				}	
				/////////////////////////////////////////
				
				dbDao.addVslRgst(insertMstVOList);
				dbDao.addVSLSubTRDCapa(insertDetailVOList);
				
				// 추가 데이터는 VSL_SEQ가 1이기 때문에 아래 로직은 필요없으므로 주석처리
				// Insert 후 이전 Data의 LST_FLG='N'으로 만들어 주기 위해 로직 추가..
				/*qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
				
				dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
				
				qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
				dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
				*/
				
			}
    		// Update
    		if ( updateMstVOList.size() > 0 ){
    			dbDao.modifyVslRgst(updateMstVOList);
    			
    			// COA_VSL_SUB_TRD_CAPA Table은 삭제후 Insert
    			dbDao.deleteVSLSubTRDCapa(deleteDetailVOList);
				dbDao.addVSLSubTRDCapa(insertDetailVOList);
				
				qParam = new HashMap<String, String>();				
				qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");
				if(vslCd != null) {										//SJH.20150508.소스품질
					qParam.put("vsl_cd", vslCd);
				}				
				qParam.put("operator", "NOT IN");				
				qParam.put("lst_flg", "N");				
				commonCoaRsVO.setHMap(qParam);				
				dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    		}

    		// Delete
    		if ( deleteMstVOList.size() > 0 ){
    			// COA_VSL_RGST 테이블은 삭제하지 않고 Delt_Flg만 'Y'로 Update
    			dbDao.modifyVslRgstDeltFlg(deleteMstVOList);
    		}        
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
        
    }	
    
    /**
	 * OPMaster 선박관리, 조회한다.<br>
	 * ESM_COA_0037, Handling the inquiry event<br>
	 * 
	 * 명칭변경(2009.09.30) : searchVSLInfoList ---> searchVslRgstList 
	 * @param SearchConditionVO searchVo
     * @return CommonCoaRsVO
     * @exception EventException
	 */
    public CommonCoaRsVO searchVslRgstList(SearchConditionVO searchVO) throws EventException {
        try {
        	DBRowSet rowSet=null; 
        	CommonBC cBc = new CommonBCImpl();
        	int cnt = 0;
        	//String header = "";
        	StringBuffer sb = new StringBuffer();        	
        	
        	//rowSet = cBc.searchVSLSubTradeList("Y");
        	rowSet = cBc.searchVSLSubTradeList();
        	
			if(rowSet != null){
				while(rowSet.next()){
					sb.append(rowSet.getString("code"));					
					//header = header + rowSet.getString("code");
					//if(cnt != rowSet.getRowCount()-1) header = header + "|";
					if(cnt != rowSet.getRowCount()-1) {
						//header = header + "|";
						sb.append("|");
					}
					
					cnt++;
				}
			}
			
			CommonCoaRsVO retVo = new CommonCoaRsVO();
			retVo.setHeader(sb.toString());
            retVo = dbDao.searchVslRgstList(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
	
    /**
     * 1. Function : OPMaster 선박관리, Handling the inquiry event(ESM_COA_038)<p>
     * 2. Overview : <p>
     *    - 선박관리에 대한 리스트 inquiry
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * 
     * @return CommonCoaRsVO
     * @exception EventException
     */
    public CommonCoaRsVO searchVSLSubTradeList() throws EventException {
        try {            
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
            
            CommonBC common = new CommonBCImpl();
            DBRowSet rowSet = common.searchVSLSubTradeList();
            retVo.setDbRowset(rowSet);
  
            return retVo;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	


    /**
     * 1. Function : OPMaster 선박관리, Handling multi event(ESM_COA_038)<p>
     * 2. Overview : <p>
     *    - OPMaster 선박관리에 대한 list를 inquiry
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * @param e ESM_COA_038Event
     * @return EventResponse ESM_COA_038EventResponse
     * @exception EventException
     */

//	public EventResponse modifyVSLSubTrade(Event e) throws EventException{
//		// PDTO(Data Transfer Object including Parameters)
//		ESM_COA_038Event event=(ESM_COA_038Event)e;
//
//		try {
//			dbDao.modifyVSLSubTrade(event);
//			return null;
//			
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		} catch (Exception ex){
//			log.error("err "+ex.toString(),ex);
//			throw new EventException(ex.getMessage());
//		}
//	}



	/**
	 * 	OPMaster 선박관리, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<SearchVslInfoListVO>
	 * @exception EventException
	 */
	public List<SearchVslInfoListVO> searchVslInfoList(SearchConditionVO searchVO) throws EventException {
		try {
			return dbDao.searchVslInfoList(searchVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * 1. Function : OPMaster BSA용 선박관리, Handling the inquiry event(ESM_COA_037)<p>
     * 2. Overview : <p>
     *    - BSA용 선박 대한 리스트 inquiry
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @return CommonCoaRsVO
     * @exception EventException
     */
    public CommonCoaRsVO searchHistVslInfoList(SearchConditionVO searchVO) throws EventException {
        try {
    		CommonBC cBc = new CommonBCImpl();    
    		DBRowSet rowSet = cBc.searchVSLSubTradeList(); //  DB ResultSet
    		//String header = "";
    		StringBuffer sb = new StringBuffer();
    		int cnt = 0;
			if(rowSet != null){
				while(rowSet.next()){
					//header = header + rowSet.getString("code");
					sb.append(rowSet.getString("code"));
					//if(cnt != rowSet.getRowCount()-1) header = header + "|";
					if(cnt != rowSet.getRowCount()-1) {
						//header = header + "|";
						sb.append("|");
					}					
					cnt++;
				}
			}
			CommonCoaRsVO retVo = new CommonCoaRsVO();
			retVo.setHeader(sb.toString());
			            
			retVo = dbDao.searchHistVSLInfoList(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	

    /**
     * 1. Function :  Route management for the OPMaster BSA, Handling multi event(ESM_COA_0146)<p>
     * 2. Overview : <p>
     * 3. Caution : <p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @param CommonCoaRsVO commonCoaRsVO
     * @param CoaVslRgstVO[] coaVslRgstVOs
     * @param CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiHistVSLInfo(SearchConditionVO searchVo, CommonCoaRsVO commonCoaRsVO, CoaVslRgstVO[] coaVslRgstVOs, CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException {
        try{
            List<CoaVslRgstVO> insertMstVOList = new ArrayList<CoaVslRgstVO>();
            List<CoaVslRgstVO> updateMstVOList = new ArrayList<CoaVslRgstVO>();
            List<CoaVslRgstVO> deleteMstVOList = new ArrayList<CoaVslRgstVO>();

            List<CoaVslSubTrdCapaVO> insertDetailVOList = new ArrayList<CoaVslSubTrdCapaVO>();
            List<CoaVslSubTrdCapaVO> updateDetailVOList = new ArrayList<CoaVslSubTrdCapaVO>();
            List<CoaVslSubTrdCapaVO> deleteDetailVOList = new ArrayList<CoaVslSubTrdCapaVO>();
            
            String header = searchVo.getFHeader();
            String[] subTrdCd = header.split("[|]");
            int len = subTrdCd.length;	            

    		int vslMaxSeq = 0;
    		int insertCnt = 0;
    		String vslCd = null;
    		String vslSeq = null;

			HashMap<String, String> qParam = new HashMap<String, String>();
			
    		if ( coaVslRgstVOs.length > 0 && coaVslSubTrdCapaVOs.length > 0 ) {
    			// COA_VSL_RGST Table
	            for ( int i=0; i<coaVslRgstVOs .length; i++ ) {
					if ( coaVslRgstVOs[i].getIbflag().equals("I")){

						vslCd = coaVslRgstVOs[i].getVslCd();


						if(insertCnt==0){       
	                		List<MultiHistVSLInfoVslSeqVO> list = dbDao.maxVslSeq(vslCd); 
	                		vslMaxSeq = Integer.parseInt(((MultiHistVSLInfoVslSeqVO)list.get(0)).getSeq());   
	                		vslMaxSeq++;
						} else {
							vslMaxSeq++;
						}
						vslSeq = String.valueOf(vslMaxSeq);
						
                		coaVslRgstVOs[i].setVslSeq(vslSeq);
                		coaVslRgstVOs[i].setVslRetnFmDt(coaVslRgstVOs[i].getVslRetnFmDt().replaceAll("-", ""));
                		coaVslRgstVOs[i].setVslRetnToDt(coaVslRgstVOs[i].getVslRetnToDt().replaceAll("-", ""));
						coaVslRgstVOs[i].setCreUsrId(account.getUsr_id());
						coaVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						insertMstVOList.add(coaVslRgstVOs[i]);
						insertCnt++;
						
						// COA_VSL_SUB_TRD_CAPA
						for (int j=0; j < len; j++ ){
							CoaVslSubTrdCapaVO coaVslSubTrdCapaVO = new CoaVslSubTrdCapaVO();
	                		String[] subTrdCapa = commonCoaRsVO.getHashAttribute(subTrdCd[j]);
	                		vslCd	= coaVslSubTrdCapaVOs[i].getVslCd();
	                		
	                		coaVslSubTrdCapaVO.setVslCd(vslCd);
	                		coaVslSubTrdCapaVO.setVslSeq(vslSeq);
							coaVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
							coaVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
							coaVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
							coaVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);

							insertDetailVOList.add(coaVslSubTrdCapaVO);
						}
					} else if (coaVslRgstVOs[i].getIbflag().equals("U") ){
						coaVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						updateMstVOList.add(coaVslRgstVOs[i]);
						
						// COA_VSL_SUB_TRD_CAPA
						deleteDetailVOList.add(coaVslSubTrdCapaVOs[i]);
						
						for (int j=0; j < len; j++ ){
							CoaVslSubTrdCapaVO coaVslSubTrdCapaVO = new CoaVslSubTrdCapaVO();
	                		String[] subTrdCapa = commonCoaRsVO.getHashAttribute(subTrdCd[j]);
	                		vslCd	= coaVslSubTrdCapaVOs[i].getVslCd();
	                		vslSeq	= coaVslSubTrdCapaVOs[i].getVslSeq();
	                		
	                		coaVslSubTrdCapaVO.setVslCd(vslCd);
	                		coaVslSubTrdCapaVO.setVslSeq(vslSeq);
							coaVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
							coaVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
							coaVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
							coaVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);

							updateDetailVOList.add(coaVslSubTrdCapaVO);
						}
					} else if (coaVslRgstVOs[i].getIbflag().equals("D")) {
						coaVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						deleteMstVOList.add(coaVslRgstVOs[i]);
						deleteDetailVOList.add(coaVslSubTrdCapaVOs[i]);
						
						// COA_VSL_SUB_TRD_CAPA
						for (int j=0; j < len; j++ ){
							CoaVslSubTrdCapaVO coaVslSubTrdCapaVO = new CoaVslSubTrdCapaVO();
	                		String[] subTrdCapa = commonCoaRsVO.getHashAttribute(subTrdCd[j]);
	                		vslCd	= coaVslSubTrdCapaVOs[i].getVslCd();
	                		vslSeq	= coaVslSubTrdCapaVOs[i].getVslSeq();
	                		
	                		coaVslSubTrdCapaVO.setVslCd(vslCd);
	                		coaVslSubTrdCapaVO.setVslSeq(vslSeq);
							coaVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
							coaVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
							coaVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
							coaVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);
						}
					}
	            }
    		}
    		
    		// Delete
    		if ( deleteDetailVOList.size() > 0 ){
    			dbDao.deleteHistVSLSubTRDCapa(deleteDetailVOList);
    			/*
    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "=");
				qParam.put("lst_flg", "Y");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
        		*/
    			
        		if(updateDetailVOList.size() > 0){
        			dbDao.addVSLSubTRDCapa(updateDetailVOList);
        		}
        		
        		qParam = new HashMap<String, String>();				
        		qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");				
				if(vslCd != null) {										//SJH.20150508.소스품질
					qParam.put("vsl_cd", vslCd);	
				}				
        		qParam.put("operator", "NOT IN");				
        		qParam.put("lst_flg", "N");				
        		commonCoaRsVO.setHMap(qParam);				
        		dbDao.modifyMultiHistLstFlg(commonCoaRsVO);				

    		}
    		if ( deleteMstVOList.size() > 0 ){    			
    			dbDao.deleteHistVslRgst(deleteMstVOList);

    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_RGST");
				if(vslCd != null) {										//SJH.20150508.소스품질
					qParam.put("vsl_cd", vslCd);	
				}				
				qParam.put("operator", "=");
				qParam.put("lst_flg", "Y");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    			
    			qParam = new HashMap<String, String>();				
    			qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");	
				if(vslCd != null) {										//SJH.20150508.소스품질
					qParam.put("vsl_cd", vslCd);		
				}		
    			qParam.put("operator", "=");				
    			qParam.put("lst_flg", "Y");				
    			commonCoaRsVO.setHMap(qParam);				
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);				
    			
    		}
    		
    		// Insert
    		if ( insertMstVOList.size() > 0 && insertDetailVOList.size() > 0 ){
				dbDao.addHistVslRgst(insertMstVOList);
    			dbDao.addVSLSubTRDCapa(insertDetailVOList);
    			


				qParam.put("table_name", "COA_VSL_RGST");
				if(vslCd != null) {										//SJH.20150508.소스품질
					qParam.put("vsl_cd", vslCd);
				}				
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    			
    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");
				if(vslCd != null) {										//SJH.20150508.소스품질
					qParam.put("vsl_cd", vslCd);
				}
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    		}
    		
    		// Update
    		if ( updateMstVOList.size() > 0 ){
    			dbDao.modifyHistVslRgst(updateMstVOList);
    		}
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }    
	
	
	/**
	 * Lane History Handling the inquiry event<br>
	 * Create Lane Table Popup,  Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SignOnUserAccount account
	 * @return List<SearchHistoryLaneListVO> 
	 * @exception EventException
	 */
    public List<SearchHistoryLaneListVO> searchHistoryLaneList(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchHistoryLaneList(searchVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
	
	/**
	 * Lane History, Handling the update event<br>
	 * Create Lane Table Popup, Handling the update event<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param CoaLaneTpHisVO[] coaLaneTpHisVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiHistoryLane(SearchConditionVO searchVo, CoaLaneTpHisVO[] coaLaneTpHisVOs, SignOnUserAccount account) throws EventException{
        try{
            List<CoaLaneTpHisVO> insertHistLaneVOList = new ArrayList<CoaLaneTpHisVO>();
            List<CoaLaneTpHisVO> updateHistLaneVOList = new ArrayList<CoaLaneTpHisVO>();
            List<CoaLaneTpHisVO> deleteHistLaneVOList = new ArrayList<CoaLaneTpHisVO>();
            List<CoaLaneTpHisVO> updateMainLaneVOList = new ArrayList<CoaLaneTpHisVO>();		//20150522.ADD : 메인원장 한번에 UPDATE, INS/UPD/DEL 상관없이 최종버전 UPD
            
            for(int i=0; i < coaLaneTpHisVOs.length; i++){
            	if(coaLaneTpHisVOs[i].getIbflag().equals("I")){
            		coaLaneTpHisVOs[i].setCreUsrId(account.getUsr_id());
            		coaLaneTpHisVOs[i].setUpdUsrId(account.getUsr_id());
            		insertHistLaneVOList.add(coaLaneTpHisVOs[i]);            		
            	} else if(coaLaneTpHisVOs[i].getIbflag().equals("U")){
            		coaLaneTpHisVOs[i].setUpdUsrId(account.getUsr_id());
            		updateHistLaneVOList.add(coaLaneTpHisVOs[i]);
            	} else if(coaLaneTpHisVOs[i].getIbflag().equals("D")){
            		deleteHistLaneVOList.add(coaLaneTpHisVOs[i]);
            		coaLaneTpHisVOs[i].setUpdUsrId(account.getUsr_id());						//20150522.ADD
            	}
            	if(i==0) updateMainLaneVOList.add(coaLaneTpHisVOs[i]);							//20150522.ADD
            }
            
            if( deleteHistLaneVOList.size() > 0 ){
            	dbDao.deleteHistoryLane(deleteHistLaneVOList);
            }
            
            if( updateHistLaneVOList.size() > 0 ){
            	dbDao.modifyHistoryLane(updateHistLaneVOList);
            }
            
            if( insertHistLaneVOList.size() > 0 ){
            	dbDao.addHistoryLane(insertHistLaneVOList);
            }
            
            if( updateMainLaneVOList.size() > 0 ){
            	dbDao.modifyMainLane(updateMainLaneVOList);
            }            
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4009화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20150519.ADD
	 */
    public CommonCoaRsVO searchOmPortMngList(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchOmPortMngList(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4009화면 대한 멀티 이벤트 처리<br>
     * 
     * @param MultiOmPortMngVO[] multiOmPortMngVO
     * @param SearchConditionVO searchConditionVO
     * @param SignOnUserAccount account 
     * @return String
     * @exception EventException
     * @author 20150519.ADD
     */
    public String multiOmPortMngInfo(MultiOmPortMngVO[] multiOmPortMngVO, SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException{
		try {
			String result = "S";
			int checkCnt = 0;
			
			for ( int i=0; i<multiOmPortMngVO .length; i++ ) {
				log.debug("============ i : "+multiOmPortMngVO[i]);
				if ( multiOmPortMngVO[i].getIbflag().equals("I")){
					 multiOmPortMngVO[i].setCreUsrId(account.getUsr_id());
					 multiOmPortMngVO[i].setUpdUsrId(account.getUsr_id());	
					 checkCnt = dbDao.checkOmPortMng(multiOmPortMngVO[i]);		//Dup Check, get Max Seq 
					 if(checkCnt == 0){ 
						 dbDao.addMultiOmPortMng(multiOmPortMngVO[i]);
					 }else{
						result = "Dup";
					 }
				} else if ( multiOmPortMngVO[i].getIbflag().equals("U")){
					multiOmPortMngVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyMultiOmPortMng(multiOmPortMngVO[i]);
				} else if ( multiOmPortMngVO[i].getIbflag().equals("D")){
					multiOmPortMngVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.removeMultiOmPortMng(multiOmPortMngVO[i]);
				}
			}
			
			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}     
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4010화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20150619.ADD
	 */
    public CommonCoaRsVO searchCrsChkCoaBkgPeriod(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchCrsChkCoaBkgPeriod(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	
    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_4010화면 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 * @author 20150619.ADD
	 */
    public CommonCoaRsVO searchCrsChkCoaBkgVVD(SearchConditionVO searchVO) throws EventException {
        try {
        	CommonCoaRsVO retVo = new CommonCoaRsVO();
			            
			retVo = dbDao.searchCrsChkCoaBkgVVD(searchVO, retVo);
            return retVo;
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }	    
	
}
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : OPMasterBCImpl.java
*@FileTitle      : 항로 생성/조회/변경
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-10-12
*@LastModifier   : Park Eun Ju
*@LastVersion    : 1.0
* 2006-10-12 Park Eun Ju
* 1.0 최초 생성
* 2009.09.30 김기대 0036 화면 New FrameWork 적용
* 2009.09.30 김기대 0037 화면 New FrameWork 적용
* 2009.09.30 김기대 0038 화면 New FrameWork 적용
* 2009.09.30 김기대 0145 화면 New FrameWork 적용
* 2009.09.30 김기대 0146 화면 New FrameWork 적용
* 2009.12.18 최인경 0026 화면 기능점검 수정
* 2009.12.23 최인경 0036 화면 IBSHEET컬럼 2개 추가
* 2010.01.29 이행지 0037, 0146화면에 대한 로직 수정
* 2010.06.17 이행지 Lane History Insert시 Seq를 기존 DB에서 MAX+1 하던 것을 화면상의 Seq로 대체해서 저장하도록 변경
* 2011.08.16 최성민 [CHM-201112855-01] [MAS]Create VSL table Operator 정보 표시
* 2012.09.17 이석준[CHM-201220161] 실시간 영업현황 관련 UI- Create Lane Table 기능 추가
* 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.mas.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration.OPMasterDBDAO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.MultiHistVSLInfoVslSeqVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasLaneRgstVO;
import com.hanjin.syscommon.common.table.MasLaneTpHisVO;
import com.hanjin.syscommon.common.table.MasVslRgstVO;
import com.hanjin.syscommon.common.table.MasVslSubTrdCapaVO;

/**
 * eNIS-MAS Business Logic Basic Command implementation<br>
 * - eNIS-MAS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Eun Ju
 * @see ESM_MAS_036EventResponse,OPMasterBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OPMasterBCImpl extends BasicCommandSupport implements OPMasterBC {

	// Database Access Object
	private transient OPMasterDBDAO dbDao = null;

	/**
	 * OPMasterBCImpl 객체 생성<br>
	 * OPMasterDBDAO를 생성한다.<br>
	 */
	public OPMasterBCImpl() {
		dbDao = new OPMasterDBDAO();
	}


    /**
     * 1. 기능 : OPMaster 항로관리 화면에 대한 조회 이벤트 처리<p>
     *         ( UI - ESM_MAS_0036 )
     * 2. 처리개요 : <p>
     *    - 항로관리에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.12<br>
     * ===================================<br>
     * 5. 수정사항 <p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
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
     * @param SearchConditionVO searchVo
     * @param SignOnUserAccount account
     * @return List<SearchRgstLaneListVO>
     * @exception EventException
     */
    public List<SearchRgstLaneListVO> searchDataForDateCheckOfLaneHistory(SearchConditionVO searchVO, SignOnUserAccount account) throws EventException {
        try {           
            return dbDao.searchDataForDateCheckOfLaneHistory(searchVO);
        } catch (DAOException ex) {
            log.error("err "+ex.toString(),ex);
            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(ex.getMessage(),ex);
        }
    }

    /**
	 * OPMaster 항로관리 화면에 대한 멀티처리한다.<br>
	 * ESM_MAS_0036화면에 대한 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
     * @param MasLaneRgstVO[] masLaneRgstVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
	 */
    public EventResponse multiRgstLane(SearchConditionVO searchVo, MasLaneRgstVO[] masLaneRgstVOs, SignOnUserAccount account) throws EventException{
        try{
            List<MasLaneRgstVO> insertRgstLaneVOList = new ArrayList<MasLaneRgstVO>();
            List<MasLaneRgstVO> updateRgstLaneVOList = new ArrayList<MasLaneRgstVO>();
            List<MasLaneRgstVO> deleteRgstLaneVOList = new ArrayList<MasLaneRgstVO>();
            
            String stupFlg		= null;
            String sctrPrcFlg	= null;
            String lodSplCngFlg	= null;
            String pctlLaneChkFlg = null;
            String rvsBndFlg     = null;
            String mktRtFlg      = null;
            
			for( int i =0; i < masLaneRgstVOs.length; i++ ){
				stupFlg		= Utils.iif(masLaneRgstVOs[i].getStupFlg().equals("1"), "Y", "N");
				sctrPrcFlg	= Utils.iif(masLaneRgstVOs[i].getSctrPrcFlg().equals("1"), "Y", "N");
				lodSplCngFlg= Utils.iif(masLaneRgstVOs[i].getLodSplCngFlg().equals("1"), "Y", "N");
				pctlLaneChkFlg= Utils.iif(masLaneRgstVOs[i].getPctlLaneChkFlg().equals("1"), "Y", "N");
				rvsBndFlg =  Utils.iif(masLaneRgstVOs[i].getRvsBndFlg().equals("1"), "Y", "N");
				mktRtFlg  = Utils.iif(masLaneRgstVOs[i].getMktRtFlg().equals("1"), "Y", "N");
				
				
				if(masLaneRgstVOs[i].getIbflag().equals("I")) {
					masLaneRgstVOs[i].setStupFlg(stupFlg);
					masLaneRgstVOs[i].setSctrPrcFlg(sctrPrcFlg);
					masLaneRgstVOs[i].setCreUsrId(account.getUsr_id());
					masLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					masLaneRgstVOs[i].setLodSplCngFlg(lodSplCngFlg);
					masLaneRgstVOs[i].setPctlLaneChkFlg(pctlLaneChkFlg);
					masLaneRgstVOs[i].setRvsBndFlg(rvsBndFlg);
					masLaneRgstVOs[i].setMktRtFlg(mktRtFlg);
					insertRgstLaneVOList.add(masLaneRgstVOs[i]);
				} else if(masLaneRgstVOs[i].getIbflag().equals("U")) {					
					masLaneRgstVOs[i].setStupFlg(stupFlg);
					masLaneRgstVOs[i].setSctrPrcFlg(sctrPrcFlg);
					masLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					masLaneRgstVOs[i].setLodSplCngFlg(lodSplCngFlg);
					masLaneRgstVOs[i].setPctlLaneChkFlg(pctlLaneChkFlg);
					masLaneRgstVOs[i].setRvsBndFlg(rvsBndFlg);
					masLaneRgstVOs[i].setMktRtFlg(mktRtFlg);
					updateRgstLaneVOList.add(masLaneRgstVOs[i]);
				} else if(masLaneRgstVOs[i].getIbflag().equals("D")) {
					deleteRgstLaneVOList.add(masLaneRgstVOs[i]);
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
	 * OPMaster 선박관리 화면에 대한 조회한다.<br>
	 * ESM_MAS_0037화면에 대한 조회 이벤트 처리<br>
	 * 
	 * 명칭변경(2009.09.30) : searchVSLInfoList ---> searchVslRgstList 
	 * @param SearchConditionVO searchVo
     * @return CommonMasRsVO
     * @exception EventException
	 */
    public CommonMasRsVO searchVslRgstList(SearchConditionVO searchVO) throws EventException {
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
					if(cnt != rowSet.getRowCount()-1) {
						//header = header + "|";
						sb.append("|");
					}
					cnt++;
				}
			}
			
			CommonMasRsVO retVo = new CommonMasRsVO();
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
	 * @param SearchConditionVO searchVo
     * @return CommonMasRsVO
     * @exception EventException
	 */
    public CommonMasRsVO searchDataForDateCheckOfVesselHistory(SearchConditionVO searchVO) throws EventException {
        try {
//        	DBRowSet rowSet=null; 
//        	CommonBC cBc = new CommonBCImpl();
//        	int cnt = 0;
        	//String header = "";
//        	StringBuffer sb = new StringBuffer();
        	
        	//rowSet = cBc.searchVSLSubTradeList("Y");
//        	rowSet = cBc.searchVSLSubTradeList();
//        	
//			if(rowSet != null){
//				while(rowSet.next()){
//					sb.append(rowSet.getString("code"));
//					//header = header + rowSet.getString("code");
//					if(cnt != rowSet.getRowCount()-1) {
//						//header = header + "|";
//						sb.append("|");
//					}
//					cnt++;
//				}
//			}
			
			CommonMasRsVO retVo = new CommonMasRsVO();
//			retVo.setHeader(sb.toString());
			
            retVo = dbDao.searchDataForDateCheckOfVesselHistory(searchVO, retVo);
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
     * 1. 기능 : OPMaster 항로관리 화면에 대한 멀티 이벤트 처리(ESM_MAS_0037)<p>
     * 2. 처리개요 : <p>
     *    - OPMaster에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * 명칭 변경 multiVSLInfo --->  multiVslRgst
     * @param SearchConditionVO searchVo
     * @param CommonMasRsVO commonMasRsVO
     * @param MasVslRgstVO[] masVslRgstVOs
     * @param MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiVslRgst(SearchConditionVO searchVo, CommonMasRsVO commonMasRsVO, MasVslRgstVO[] masVslRgstVOs, MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException{
        try{
            List<MasVslRgstVO> insertMstVOList = new ArrayList<MasVslRgstVO>();
            List<MasVslRgstVO> updateMstVOList = new ArrayList<MasVslRgstVO>();
            List<MasVslRgstVO> deleteMstVOList = new ArrayList<MasVslRgstVO>();
            List<MasVslRgstVO> insertMstAutoFlgVOList = new ArrayList<MasVslRgstVO>();

            List<MasVslSubTrdCapaVO> insertDetailVOList = new ArrayList<MasVslSubTrdCapaVO>();
            List<MasVslSubTrdCapaVO> updateDetailVOList = new ArrayList<MasVslSubTrdCapaVO>();
            List<MasVslSubTrdCapaVO> deleteDetailVOList = new ArrayList<MasVslSubTrdCapaVO>();

    		String vslCd = null;
			HashMap<String, String> qParam = new HashMap<String, String>();
			String header = searchVo.getFHeader();
			String[] subTrdCd = header.split("[|]");
			
			int subTrdCount = 0;
			if (!header.equals("")) {
				subTrdCount = subTrdCd.length;
			}

			if ( masVslRgstVOs.length > 0 ){
				for(int i = 0 ; i < masVslRgstVOs.length ; i++){
					if(masVslRgstVOs[i].getIbflag().equals("I")) {
						masVslRgstVOs[i].setCreUsrId(account.getUsr_id());
						masVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						insertMstVOList.add(masVslRgstVOs[i]);
					} else if(masVslRgstVOs[i].getIbflag().equals("U")) {
						masVslRgstVOs[i].setCreUsrId(account.getUsr_id());
						masVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						if(masVslRgstVOs[i].getAutoFlg().equals("Y")){
							insertMstAutoFlgVOList.add(masVslRgstVOs[i]);
						}else{
							updateMstVOList.add(masVslRgstVOs[i]);
						}
					} else if(masVslRgstVOs[i].getIbflag().equals("D")) {
						masVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						deleteMstVOList.add(masVslRgstVOs[i]);
					}
				}
			}
			
            if(masVslSubTrdCapaVOs.length > 0){
            	for(int i = 0 ; i < masVslSubTrdCapaVOs.length ; i++){					
            		if(masVslSubTrdCapaVOs[i].getIbflag().equals("I") || masVslSubTrdCapaVOs[i].getIbflag().equals("U")) {
            			for (int j = 0; j < subTrdCount; j++) {
            				String[] subTrdCapa = commonMasRsVO.getHashAttribute(subTrdCd[j]);
            				vslCd = masVslSubTrdCapaVOs[i].getVslCd();
    						
    						if (!subTrdCapa[i].equals("")) {
    							MasVslSubTrdCapaVO masVslSubTrdCapaVO = new MasVslSubTrdCapaVO();

    							masVslSubTrdCapaVO.setVslCd(vslCd);
    							masVslSubTrdCapaVO.setVslSeq(masVslSubTrdCapaVOs[i].getVslSeq());
    							masVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
    							masVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);
    							masVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
    							masVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
    							masVslSubTrdCapaVO.setAutoFlg(masVslSubTrdCapaVOs[i].getAutoFlg());
    							
    							insertDetailVOList.add(masVslSubTrdCapaVO);
    							updateDetailVOList.add(masVslSubTrdCapaVO);
    							deleteDetailVOList.add(masVslSubTrdCapaVOs[i]);
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
						throw new EventException(new ErrorHandler("MAS10043",new String[]{insertMstVOList.get(i).getVslCd()}).getMessage());
					}
				}	
				/////////////////////////////////////////
				
				dbDao.addVslRgst(insertMstVOList);
				
				log.debug("\n insertDetailVOListinsertDetailVOList 111: "+insertDetailVOList);
				
				
				dbDao.addVSLSubTRDCapa(insertDetailVOList);
				
				// 추가 데이터는 VSL_SEQ가 1이기 때문에 아래 로직은 필요없으므로 주석처리
				// Insert 후 이전 Data의 LST_FLG='N'으로 만들어 주기 위해 로직 추가..
				/*qParam = new HashMap<String, String>();
				qParam.put("table_name", "MAS_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonMasRsVO.setHMap(qParam);
				
				dbDao.modifyMultiHistLstFlg(commonMasRsVO);
				
				qParam = new HashMap<String, String>();
				qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonMasRsVO.setHMap(qParam);
				dbDao.modifyMultiHistLstFlg(commonMasRsVO);
				*/
				
			}
    		// Update
    		if ( updateMstVOList.size() > 0 ){
    			dbDao.modifyVslRgst(updateMstVOList);
    			
    			// MAS_VSL_SUB_TRD_CAPA Table은 삭제후 Insert
    			dbDao.deleteVSLSubTRDCapa(deleteDetailVOList);
				dbDao.addVSLSubTRDCapa(insertDetailVOList);
				
				qParam = new HashMap<String, String>();				
				qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");				
				qParam.put("vsl_cd", vslCd);				
				qParam.put("operator", "NOT IN");				
				qParam.put("lst_flg", "N");				
				commonMasRsVO.setHMap(qParam);				
				dbDao.modifyMultiHistLstFlg(commonMasRsVO);
    		}

    		// Delete
    		if ( deleteMstVOList.size() > 0 ){
    			// MAS_VSL_RGST 테이블은 삭제하지 않고 Delt_Flg만 'Y'로 Update
    			dbDao.modifyVslRgstDeltFlg(deleteMstVOList);
    		}  
    		
    		// AutoFlag용 insert
    		if ( insertMstAutoFlgVOList.size() > 0 ){
    			// 해당하는 vessel의 MAS_VSL_RGST.VSL_APLY_FM_DT에 sysdate가 있는 경우에는 update, 아닌 경우에는 insert
//    			dbDao.searchHistVslRgstDecideUpdateOrInsert(insertMstAutoFlgVOList);
    			
    			dbDao.addHistVslRgst(insertMstAutoFlgVOList, updateDetailVOList);
//    			dbDao.addVSLSubTRDCapa(updateDetailVOList);
    			
    			// Insert 후 이전 Data의 LST_FLG='N'으로 만들어 주기 위해 로직 추가..

				qParam.put("table_name", "MAS_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonMasRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);
    			
    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonMasRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);
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
     * 1. 기능 : OPMaster 선박관리 화면에 대한 조회 이벤트 처리(ESM_MAS_038)<p>
     * 2. 처리개요 : <p>
     *    - 선박관리에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @return CommonMasRsVO
     * @exception EventException
     */
    public CommonMasRsVO searchVSLSubTradeList() throws EventException {
        try {            
        	CommonMasRsVO retVo = new CommonMasRsVO();
            
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
     * 1. 기능 : OPMaster 선박관리 화면에 대한 멀티 이벤트 처리(ESM_MAS_038)<p>
     * 2. 처리개요 : <p>
     *    - OPMaster 선박관리에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.18<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * @param e ESM_MAS_038Event
     * @return EventResponse ESM_MAS_038EventResponse
     * @exception EventException
     */
	// ALPS 변환 후 저장 038번 화면 저장로직 제거
//	public EventResponse modifyVSLSubTrade(Event e) throws EventException{
//		// PDTO(Data Transfer Object including Parameters)
//		ESM_MAS_038Event event=(ESM_MAS_038Event)e;
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
	 * 	OPMaster 선박관리화면에 대한 조회 이벤트 처리<br>
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
     * 1. 기능 : OPMaster BSA용 선박관리 화면에 대한 조회 이벤트 처리(ESM_MAS_037)<p>
     * 2. 처리개요 : <p>
     *    - BSA용 선박 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : LeeHoIk /2007.07.25<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @return CommonMasRsVO
     * @exception EventException
     */
    public CommonMasRsVO searchHistVslInfoList(SearchConditionVO searchVO) throws EventException {
        try {
    		CommonBC cBc = new CommonBCImpl();    
    		DBRowSet rowSet = cBc.searchVSLSubTradeList(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    		//String header = "";
    		StringBuffer sb = new StringBuffer();
    		
    		int cnt = 0;
			if(rowSet != null){
				while(rowSet.next()){
					//header = header + rowSet.getString("code");
					sb.append(rowSet.getString("code"));
					if(cnt != rowSet.getRowCount()-1) {
						//header = header + "|";
						sb.append("|");
					}
					cnt++;
				}
			}
			CommonMasRsVO retVo = new CommonMasRsVO();
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
     * 1. 기능 : OPMaster BSA용 항로관리 화면에 대한 멀티 이벤트 처리(ESM_MAS_0146)<p>
     * 2. 처리개요 : <p>
     *    - OPMaster에 대한 리스트를 조회
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Lee Ho Ik /2007.07.25<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @param CommonMasRsVO commonMasRsVO
     * @param MasVslRgstVO[] masVslRgstVOs
     * @param MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse multiHistVSLInfo(SearchConditionVO searchVo, CommonMasRsVO commonMasRsVO, MasVslRgstVO[] masVslRgstVOs, MasVslSubTrdCapaVO[] masVslSubTrdCapaVOs, SignOnUserAccount account) throws EventException {
        try{
            List<MasVslRgstVO> insertMstVOList = new ArrayList<MasVslRgstVO>();
            List<MasVslRgstVO> updateMstVOList = new ArrayList<MasVslRgstVO>();
            List<MasVslRgstVO> deleteMstVOList = new ArrayList<MasVslRgstVO>();

            List<MasVslSubTrdCapaVO> insertDetailVOList = new ArrayList<MasVslSubTrdCapaVO>();
            List<MasVslSubTrdCapaVO> updateDetailVOList = new ArrayList<MasVslSubTrdCapaVO>();
            List<MasVslSubTrdCapaVO> deleteDetailVOList = new ArrayList<MasVslSubTrdCapaVO>();
            
            String header = searchVo.getFHeader();
            String[] subTrdCd = header.split("[|]");
            int len = subTrdCd.length;	            

    		int vslMaxSeq = 0;
    		int insertCnt = 0;
    		String vslCd = null;
    		String vslSeq = null;

			HashMap<String, String> qParam = new HashMap<String, String>();
			
    		if ( masVslRgstVOs.length > 0 && masVslSubTrdCapaVOs.length > 0 ) {
    			// MAS_VSL_RGST Table
	            for ( int i=0; i<masVslRgstVOs .length; i++ ) {
					if ( masVslRgstVOs[i].getIbflag().equals("I")){

						vslCd = masVslRgstVOs[i].getVslCd();

	              		// VSL Seq 구하기..
						if(insertCnt==0){       
	                		List<MultiHistVSLInfoVslSeqVO> list = dbDao.maxVslSeq(vslCd); 
	                		vslMaxSeq = Integer.parseInt(((MultiHistVSLInfoVslSeqVO)list.get(0)).getSeq());   
	                		vslMaxSeq++;
						} else {
							vslMaxSeq++;
						}
						vslSeq = String.valueOf(vslMaxSeq);
						
                		masVslRgstVOs[i].setVslSeq(vslSeq);
                		masVslRgstVOs[i].setVslRetnFmDt(masVslRgstVOs[i].getVslRetnFmDt().replaceAll("-", ""));
                		masVslRgstVOs[i].setVslRetnToDt(masVslRgstVOs[i].getVslRetnToDt().replaceAll("-", ""));
						masVslRgstVOs[i].setCreUsrId(account.getUsr_id());
						masVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						insertMstVOList.add(masVslRgstVOs[i]);
						insertCnt++;
						
						// MAS_VSL_SUB_TRD_CAPA
						for (int j=0; j < len; j++ ){
							MasVslSubTrdCapaVO masVslSubTrdCapaVO = new MasVslSubTrdCapaVO();
	                		String[] subTrdCapa = commonMasRsVO.getHashAttribute(subTrdCd[j]);
	                		vslCd	= masVslSubTrdCapaVOs[i].getVslCd();
	                		
	                		masVslSubTrdCapaVO.setVslCd(vslCd);
	                		masVslSubTrdCapaVO.setVslSeq(vslSeq);
							masVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
							masVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
							masVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
							masVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);

							insertDetailVOList.add(masVslSubTrdCapaVO);
						}
					} else if (masVslRgstVOs[i].getIbflag().equals("U") ){
						masVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						updateMstVOList.add(masVslRgstVOs[i]);
						
						// MAS_VSL_SUB_TRD_CAPA
						deleteDetailVOList.add(masVslSubTrdCapaVOs[i]);
						
						for (int j=0; j < len; j++ ){
							MasVslSubTrdCapaVO masVslSubTrdCapaVO = new MasVslSubTrdCapaVO();
	                		String[] subTrdCapa = commonMasRsVO.getHashAttribute(subTrdCd[j]);
	                		vslCd	= masVslSubTrdCapaVOs[i].getVslCd();
	                		vslSeq	= masVslSubTrdCapaVOs[i].getVslSeq();
	                		
	                		masVslSubTrdCapaVO.setVslCd(vslCd);
	                		masVslSubTrdCapaVO.setVslSeq(vslSeq);
							masVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
							masVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
							masVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
							masVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);

							updateDetailVOList.add(masVslSubTrdCapaVO);
						}
					} else if (masVslRgstVOs[i].getIbflag().equals("D")) {
						masVslRgstVOs[i].setUpdUsrId(account.getUsr_id());
						deleteMstVOList.add(masVslRgstVOs[i]);
						deleteDetailVOList.add(masVslSubTrdCapaVOs[i]);
						
						// MAS_VSL_SUB_TRD_CAPA
						for (int j=0; j < len; j++ ){
							MasVslSubTrdCapaVO masVslSubTrdCapaVO = new MasVslSubTrdCapaVO();
	                		String[] subTrdCapa = commonMasRsVO.getHashAttribute(subTrdCd[j]);
	                		vslCd	= masVslSubTrdCapaVOs[i].getVslCd();
	                		vslSeq	= masVslSubTrdCapaVOs[i].getVslSeq();
	                		
	                		masVslSubTrdCapaVO.setVslCd(vslCd);
	                		masVslSubTrdCapaVO.setVslSeq(vslSeq);
							masVslSubTrdCapaVO.setCreUsrId(account.getUsr_id());
							masVslSubTrdCapaVO.setUpdUsrId(account.getUsr_id());
							masVslSubTrdCapaVO.setSubTrdCd(subTrdCd[j]);
							masVslSubTrdCapaVO.setSubTrdCapa(subTrdCapa[i]);
						}
					}
	            }
    		}
    		
    		// Delete
    		if ( deleteDetailVOList.size() > 0 ){
    			dbDao.deleteHistVSLSubTRDCapa(deleteDetailVOList);
    			/*
    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "=");
				qParam.put("lst_flg", "Y");
				commonMasRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);
        		*/
    			
        		if(updateDetailVOList.size() > 0){
        			dbDao.addVSLSubTRDCapa(updateDetailVOList);
        		}
        		
        		qParam = new HashMap<String, String>();				
        		qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");				
        		qParam.put("vsl_cd", vslCd);				
        		qParam.put("operator", "NOT IN");				
        		qParam.put("lst_flg", "N");				
        		commonMasRsVO.setHMap(qParam);				
        		dbDao.modifyMultiHistLstFlg(commonMasRsVO);				

    		}
    		if ( deleteMstVOList.size() > 0 ){    			
    			dbDao.deleteHistVslRgst(deleteMstVOList);

    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "MAS_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "=");
				qParam.put("lst_flg", "Y");
				commonMasRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);
    			
    			qParam = new HashMap<String, String>();				
    			qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");				
    			qParam.put("vsl_cd", vslCd);				
    			qParam.put("operator", "=");				
    			qParam.put("lst_flg", "Y");				
    			commonMasRsVO.setHMap(qParam);				
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);				
    			
    		}
    		
    		// Insert
    		if ( insertMstVOList.size() > 0 && insertDetailVOList.size() > 0 ){
				dbDao.addHistVslRgst(insertMstVOList, insertDetailVOList);
//    			dbDao.addVSLSubTRDCapa(insertDetailVOList); //addHistVslRgst안에서 함께 처리되도록 변경
    			
    			// Insert 후 이전 Data의 LST_FLG='N'으로 만들어 주기 위해 로직 추가..

				qParam.put("table_name", "MAS_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonMasRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);
    			
    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonMasRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonMasRsVO);
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
	 * Lane History 조회 이벤트 처리<br>
	 * Create Lane Table화면의 Popup 대한 조회 이벤트 처리<br>
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
	 * Lane History 수정 이벤트 처리<br>
	 * Create Lane Table화면의 Popup 대한 수정 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param MasLaneTpHisVO[] masLaneTpHisVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiHistoryLane(SearchConditionVO searchVo, MasLaneTpHisVO[] masLaneTpHisVOs, SignOnUserAccount account) throws EventException{
        try{
            List<MasLaneTpHisVO> insertHistLaneVOList = new ArrayList<MasLaneTpHisVO>();
            List<MasLaneTpHisVO> updateHistLaneVOList = new ArrayList<MasLaneTpHisVO>();
            List<MasLaneTpHisVO> deleteHistLaneVOList = new ArrayList<MasLaneTpHisVO>();
            
            for(int i=0; i < masLaneTpHisVOs.length; i++){
            	if(masLaneTpHisVOs[i].getIbflag().equals("I")){
            		masLaneTpHisVOs[i].setCreUsrId(account.getUsr_id());
            		masLaneTpHisVOs[i].setUpdUsrId(account.getUsr_id());
            		insertHistLaneVOList.add(masLaneTpHisVOs[i]);
            	} else if(masLaneTpHisVOs[i].getIbflag().equals("U")){
            		masLaneTpHisVOs[i].setUpdUsrId(account.getUsr_id());
            		updateHistLaneVOList.add(masLaneTpHisVOs[i]);
            	} else if(masLaneTpHisVOs[i].getIbflag().equals("D")){
            		deleteHistLaneVOList.add(masLaneTpHisVOs[i]);
            	}
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
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
    
    /**
	 * Lane History 수정 이벤트 처리<br> Create Lane Table에서 변경된 내역을 자동으로 쌓을 때
	 * Create Lane Table화면의 Popup 대한 수정 이벤트 처리<br>
	 * 
	 * @param MasLaneTpHisVO[] masLaneTpHisVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
    public EventResponse multiAutomaticHistoryLane(MasLaneTpHisVO[] masLaneTpHisVOs, SignOnUserAccount account) throws EventException{
        try{
            List<MasLaneTpHisVO> insertHistLaneVOList = new ArrayList<MasLaneTpHisVO>();
            String autoF = "";
            for(int i=0; i < masLaneTpHisVOs.length; i++){
            	if( masLaneTpHisVOs[i].getAutoFlg()!= null && autoF.equals("") )
            		continue;
//            	if( i > 0 && !autoF.equals("") )
//            		masLaneTpHisVOs[i].setAutoFlg( autoF );
        		masLaneTpHisVOs[i].setCreUsrId(account.getUsr_id());
        		masLaneTpHisVOs[i].setUpdUsrId(account.getUsr_id());
//        		if(masLaneTpHisVOs[i].getRlaneCd()!= null && !masLaneTpHisVOs[i].getRlaneCd().equals("")){
        			insertHistLaneVOList.add(masLaneTpHisVOs[i]);
//        		}
            }
            
            if( insertHistLaneVOList.size() > 0 ){

            	dbDao.addHistoryLane(insertHistLaneVOList);
            }
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
	
}
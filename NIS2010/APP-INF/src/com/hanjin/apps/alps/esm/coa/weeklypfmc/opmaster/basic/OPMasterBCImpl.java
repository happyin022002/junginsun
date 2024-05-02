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
* 2011.08.16 최성민 [CHM-201112855-01] [COA]Create VSL table Operator 정보 표시
* 2012.09.17 이석준[CHM-201220161] 실시간 영업현황 관련 UI- Create Lane Table 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.Utils;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBC;
import com.hanjin.apps.alps.esm.coa.common.basic.CommonBCImpl;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.integration.OPMasterDBDAO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.MultiHistVSLInfoVslSeqVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchHistoryLaneListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchRgstLaneListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo.SearchVslInfoListVO;
import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaLaneRgstVO;
import com.hanjin.syscommon.common.table.CoaLaneTpHisVO;
import com.hanjin.syscommon.common.table.CoaVslRgstVO;
import com.hanjin.syscommon.common.table.CoaVslSubTrdCapaVO;

/**
 * eNIS-COA Business Logic Basic Command implementation<br>
 * - eNIS-COA에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Eun Ju 
 * @see ESM_COA_036EventResponse,OPMasterBC 각 DAO 클래스 참조
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
     *         ( UI - ESM_COA_0036 )
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
	 * OPMaster 항로관리 화면에 대한 멀티처리한다.<br>
	 * ESM_COA_0036화면에 대한 이벤트 처리<br>
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
            String pctlLaneChkFlg = null;
            String rvsBndFlg     = null;
            String mktRtFlg      = null;
            
			for( int i =0; i < coaLaneRgstVOs.length; i++ ){
				stupFlg		= Utils.iif(coaLaneRgstVOs[i].getStupFlg().equals("1"), "Y", "N");
				sctrPrcFlg	= Utils.iif(coaLaneRgstVOs[i].getSctrPrcFlg().equals("1"), "Y", "N");
				lodSplCngFlg= Utils.iif(coaLaneRgstVOs[i].getLodSplCngFlg().equals("1"), "Y", "N");
				pctlLaneChkFlg= Utils.iif(coaLaneRgstVOs[i].getPctlLaneChkFlg().equals("1"), "Y", "N");
				rvsBndFlg =  Utils.iif(coaLaneRgstVOs[i].getRvsBndFlg().equals("1"), "Y", "N");
				mktRtFlg  = Utils.iif(coaLaneRgstVOs[i].getMktRtFlg().equals("1"), "Y", "N");
				
				
				if(coaLaneRgstVOs[i].getIbflag().equals("I")) {
					coaLaneRgstVOs[i].setStupFlg(stupFlg);
					coaLaneRgstVOs[i].setSctrPrcFlg(sctrPrcFlg);
					coaLaneRgstVOs[i].setCreUsrId(account.getUsr_id());
					coaLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					coaLaneRgstVOs[i].setLodSplCngFlg(lodSplCngFlg);
					coaLaneRgstVOs[i].setPctlLaneChkFlg(pctlLaneChkFlg);
					coaLaneRgstVOs[i].setRvsBndFlg(rvsBndFlg);
					coaLaneRgstVOs[i].setMktRtFlg(mktRtFlg);
					insertRgstLaneVOList.add(coaLaneRgstVOs[i]);
				} else if(coaLaneRgstVOs[i].getIbflag().equals("U")) {					
					coaLaneRgstVOs[i].setStupFlg(stupFlg);
					coaLaneRgstVOs[i].setSctrPrcFlg(sctrPrcFlg);
					coaLaneRgstVOs[i].setUpdUsrId(account.getUsr_id());
					coaLaneRgstVOs[i].setLodSplCngFlg(lodSplCngFlg);
					coaLaneRgstVOs[i].setPctlLaneChkFlg(pctlLaneChkFlg);
					coaLaneRgstVOs[i].setRvsBndFlg(rvsBndFlg);
					coaLaneRgstVOs[i].setMktRtFlg(mktRtFlg);
					updateRgstLaneVOList.add(coaLaneRgstVOs[i]);
				} else if(coaLaneRgstVOs[i].getIbflag().equals("D")) {
					deleteRgstLaneVOList.add(coaLaneRgstVOs[i]);
				}
			}
			
			if( insertRgstLaneVOList.size() > 0 ){ 
				dbDao.addRgstLane(insertRgstLaneVOList);
				dbDao.addRgstLaneMas(insertRgstLaneVOList);	// MAS 테이블에 동시 작업(한시적)
			}
			if( updateRgstLaneVOList.size() > 0 ){
				dbDao.modifyRgstLane(updateRgstLaneVOList);
				dbDao.modifyRgstLaneMas(updateRgstLaneVOList);	// MAS 테이블에 동시 작업(한시적)
			}
			if ( deleteRgstLaneVOList.size() > 0 ){
				dbDao.deleteRgstLane(deleteRgstLaneVOList);
				dbDao.deleteRgstLaneMas(deleteRgstLaneVOList);		// MAS 테이블에 동시 작업(한시적)
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
	 * ESM_COA_0037화면에 대한 조회 이벤트 처리<br>
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
     * 1. 기능 : OPMaster 항로관리 화면에 대한 멀티 이벤트 처리(ESM_COA_0037)<p>
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
				
				//MAS 테이블로 동시 작업 (한시적)
				dbDao.addVslRgstMas(insertMstVOList);
				dbDao.addVSLSubTRDCapaMas(insertDetailVOList);
				//MAS 테이블로 동시 작업 (한시적) - 끝
				
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
    			dbDao.modifyVslRgstMas(updateMstVOList);		//MAS 테이블 동시 저장(한시적)
    			
    			// COA_VSL_SUB_TRD_CAPA Table은 삭제후 Insert
    			dbDao.deleteVSLSubTRDCapa(deleteDetailVOList);
				dbDao.addVSLSubTRDCapa(insertDetailVOList);
				
				//MAS 테이블 동시 저장(한시적)
    			dbDao.deleteVSLSubTRDCapaMas(deleteDetailVOList);
				dbDao.addVSLSubTRDCapaMas(insertDetailVOList);
				//MAS 테이블 동시 저장(한시적) - 끝
				
				qParam = new HashMap<String, String>();				
				qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");				
				qParam.put("vsl_cd", vslCd);				
				qParam.put("operator", "NOT IN");				
				qParam.put("lst_flg", "N");				
				commonCoaRsVO.setHMap(qParam);				
				dbDao.modifyMultiHistLstFlg(commonCoaRsVO);	

				//MAS 테이블로 동시 작업 (한시적)		
				qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");				
				qParam.put("vsl_cd", vslCd);				
				qParam.put("operator", "NOT IN");				
				qParam.put("lst_flg", "N");				
				commonCoaRsVO.setHMap(qParam);				
				dbDao.modifyMultiHistLstFlgMas(commonCoaRsVO);	
				//MAS 테이블로 동시 작업 (한시적) - 끝
    		}

    		// Delete
    		if ( deleteMstVOList.size() > 0 ){
    			// COA_VSL_RGST 테이블은 삭제하지 않고 Delt_Flg만 'Y'로 Update
    			dbDao.modifyVslRgstDeltFlg(deleteMstVOList);
    			dbDao.modifyVslRgstDeltFlgMas(deleteMstVOList);	// MAS 테이블 동시 작업(한시적)
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
     * 1. 기능 : OPMaster 선박관리 화면에 대한 조회 이벤트 처리(ESM_COA_038)<p>
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
     * 1. 기능 : OPMaster 선박관리 화면에 대한 멀티 이벤트 처리(ESM_COA_038)<p>
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
     * @param e ESM_COA_038Event
     * @return EventResponse ESM_COA_038EventResponse
     * @exception EventException
     */
	// ALPS 변환 후 저장 038번 화면 저장로직 제거
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
     * 1. 기능 : OPMaster BSA용 선박관리 화면에 대한 조회 이벤트 처리(ESM_COA_037)<p>
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
     * @return CommonCoaRsVO
     * @exception EventException
     */
    public CommonCoaRsVO searchHistVslInfoList(SearchConditionVO searchVO) throws EventException {
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
     * 1. 기능 : OPMaster BSA용 항로관리 화면에 대한 멀티 이벤트 처리(ESM_COA_0146)<p>
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

	              		// VSL Seq 구하기..
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
    			dbDao.deleteHistVSLSubTRDCapaMas(deleteDetailVOList);		// MAS 테이블 동시 저장(한시적)
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
        			dbDao.addVSLSubTRDCapaMas(updateDetailVOList);		// MAS 테이블 동시 저장(한시적)
        		}
        		
        		qParam = new HashMap<String, String>();				
        		qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");				
        		qParam.put("vsl_cd", vslCd);				
        		qParam.put("operator", "NOT IN");				
        		qParam.put("lst_flg", "N");				
        		commonCoaRsVO.setHMap(qParam);				
        		dbDao.modifyMultiHistLstFlg(commonCoaRsVO);				
        		
        		qParam = new HashMap<String, String>();				
        		qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");				
        		qParam.put("vsl_cd", vslCd);				
        		qParam.put("operator", "NOT IN");				
        		qParam.put("lst_flg", "N");				
        		commonCoaRsVO.setHMap(qParam);				
        		dbDao.modifyMultiHistLstFlgMas(commonCoaRsVO);		// MAS 테이블 동시 저장(한시적)

    		}
    		if ( deleteMstVOList.size() > 0 ){    			
    			dbDao.deleteHistVslRgst(deleteMstVOList);
    			dbDao.deleteHistVslRgstMas(deleteMstVOList);		// MAS 테이블 동시 저장(한시적)

    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "=");
				qParam.put("lst_flg", "Y");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    			
    			qParam.put("table_name", "MAS_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "=");
				qParam.put("lst_flg", "Y");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlgMas(commonCoaRsVO);		// MAS 테이블 동시 저장(한시적)
    			
    			qParam = new HashMap<String, String>();				
    			qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");				
    			qParam.put("vsl_cd", vslCd);				
    			qParam.put("operator", "=");				
    			qParam.put("lst_flg", "Y");				
    			commonCoaRsVO.setHMap(qParam);				
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);				
    			
    			qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");				
    			qParam.put("vsl_cd", vslCd);				
    			qParam.put("operator", "=");				
    			qParam.put("lst_flg", "Y");				
    			commonCoaRsVO.setHMap(qParam);				
    			dbDao.modifyMultiHistLstFlgMas(commonCoaRsVO);		// MAS 테이블 동시 저장(한시적)
    			
    		}
    		
    		// Insert
    		if ( insertMstVOList.size() > 0 && insertDetailVOList.size() > 0 ){
				dbDao.addHistVslRgst(insertMstVOList);
    			dbDao.addVSLSubTRDCapa(insertDetailVOList);
    			
    			dbDao.addHistVslRgstMas(insertMstVOList);		// MAS 테이블 동시 저장(한시적)
    			dbDao.addVSLSubTRDCapaMas(insertDetailVOList);		// MAS 테이블 동시 저장(한시적)
    			
    			// Insert 후 이전 Data의 LST_FLG='N'으로 만들어 주기 위해 로직 추가..

				qParam.put("table_name", "COA_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    			
    			qParam.put("table_name", "MAS_VSL_RGST");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlgMas(commonCoaRsVO);		// MAS 테이블 동시 저장(한시적)
    			
    			qParam = new HashMap<String, String>();
				qParam.put("table_name", "COA_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlg(commonCoaRsVO);
    			
    			qParam.put("table_name", "MAS_VSL_SUB_TRD_CAPA");
				qParam.put("vsl_cd", vslCd);
				qParam.put("operator", "NOT IN");
				qParam.put("lst_flg", "N");
				commonCoaRsVO.setHMap(qParam);
    			dbDao.modifyMultiHistLstFlgMas(commonCoaRsVO);		// MAS 테이블 동시 저장(한시적)
    		}
    		
    		// Update
    		if ( updateMstVOList.size() > 0 ){
    			dbDao.modifyHistVslRgst(updateMstVOList);
    			dbDao.modifyHistVslRgstMas(updateMstVOList);		// MAS 테이블 동시 저장(한시적)
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
            	}
            }
            
            if( deleteHistLaneVOList.size() > 0 ){
            	dbDao.deleteHistoryLane(deleteHistLaneVOList);
            	dbDao.deleteHistoryLaneMas(deleteHistLaneVOList);	//MAS 테이블에 동시 저장(한시적)
            }
            
            if( updateHistLaneVOList.size() > 0 ){
            	dbDao.modifyHistoryLane(updateHistLaneVOList);
            	dbDao.modifyHistoryLaneMas(updateHistLaneVOList);		//MAS 테이블에 동시 저장(한시적)
            }
            
            if( insertHistLaneVOList.size() > 0 ){
            	dbDao.addHistoryLane(insertHistLaneVOList);
            	dbDao.addHistoryLaneMas(insertHistLaneVOList);		//MAS 테이블에 동시 저장(한시적)
            }
            
            GeneralEventResponse eventResponse = new GeneralEventResponse();
            return eventResponse; // "SUCCESS"
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }
	
}
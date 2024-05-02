/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContainerSelectPopupDBDAO.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-31 kim_sang_geun
* 1.0 최초 생성
* --------------------------------------------------------
* history
* 2011.04.05 김영철 [CHM-201109654-01] Frustrate 처리된 CNTR 에 대해 두번이상 S/O 가 난 건들의 Invoice 처리 가능하도록 수정요청 ( TRO_SEQ 컬럼 추가 )
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.basic.ContainerSelectPopupBCImpl;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.event.EsdTrs0908Event;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.vo.SearchContainerSelectMainListVO;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.vo.SearchContainerSelectSubListBkgVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kim_sang_geun
 * @see ContainerSelectPopupBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerSelectPopupDBDAO extends DBDAOSupport {

	/**
	 * ContainerSelectPopup의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContainerSelectPopup(EsdTrs0908Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

//		StringTokenizer st = null;
		ArrayList arrBkgno = new ArrayList();
	
		String[] bkg_no = event.getBkgNos();
		if( bkg_no.length > 0 ){
			for(int i = 0; i<bkg_no.length; i++){
				arrBkgno.add(i++,  bkg_no[i]);
			}
		}		

		param.put("arrBkgno", arrBkgno);

		try {
			dRs = new SQLExecuter("").executeQuery(new ContainerSelectPopupDBDAOSearchContainerSelectPopupRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
		
	}
	
	/**
	 * ContainerSelectPopup의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public GeneralEventResponse searchContainerSelectMainList(EsdTrs0908Event event) throws DAOException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet dRs = null;
		List<SearchContainerSelectMainListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();		
		TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOs();
		
		try {
			for(int k=0; trsTrspSvcOrdVOs!=null && k<trsTrspSvcOrdVOs.length; k++){

				param.put("trspSoOfcCtyCd", trsTrspSvcOrdVOs[k].getTrspSoOfcCtyCd());
				param.put("trspSoSeq", trsTrspSvcOrdVOs[k].getTrspSoSeq());
				
				dRs = new SQLExecuter("").executeQuery(new ContainerSelectPopupDBDAOSearchContainerSelectMainListRSQL(), param,param);
				List<SearchContainerSelectMainListVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, SearchContainerSelectMainListVO.class);

				if(list == null){
					list = listTemp;
				}else{
					list.addAll(listTemp);
				}
			}
			eventResponse.setRsVoList(list);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * ContainerSelectPopup의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public GeneralEventResponse searchContainerSelectSubList(EsdTrs0908Event event) throws DAOException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		DBRowSet dRs			= null;
		DBRowSet dRsSub			= null;

//		ArrayList rowSetList	= null;
		ArrayList bkgList		= null;
		String applySoSeq		= null;
		
		List<SearchContainerSelectSubListBkgVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = event.getTrsTrspSvcOrdVOs();
		
		try {
			/* bkg no와 revise bkg no를 중복되지 않게 저장한다 */
			for(int k=0; trsTrspSvcOrdVOs!=null && k<trsTrspSvcOrdVOs.length; k++){
				if(k==0){
					bkgList = new ArrayList();
				}
				
				TrsTrspSvcOrdVO elem = (TrsTrspSvcOrdVO) trsTrspSvcOrdVOs[k];
				if( elem.getBkgNo() != null && !"".equals(elem.getBkgNo())){
					if(!contains(bkgList, elem.getBkgNo())){
						bkgList.add(elem.getBkgNo());
					}
				}
				if( elem.getOrgBkgNo() != null && !"".equals(elem.getOrgBkgNo())){					
					if(!contains(bkgList, elem.getOrgBkgNo())){
						bkgList.add(elem.getOrgBkgNo());
					}
				}
			}
			param.put("arr_bkgNo", bkgList);
			//			for(int k=0; bkgList!=null && k<bkgList.size(); k++){
			//				param.put("bkgNo", (String) bkgList.get(k));

			dRs = new SQLExecuter("").executeQuery(new ContainerSelectPopupDBDAOSearchContainerSelectSubListBkgRSQL(), param,param);

			List<SearchContainerSelectSubListBkgVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, SearchContainerSelectSubListBkgVO.class);

			for(int k=0; bkgList!=null && k<bkgList.size(); k++){
				param.put("bkgNo", (String) bkgList.get(k));
				for(int m=0; listTemp != null && m<listTemp.size(); m++){
					SearchContainerSelectSubListBkgVO voTemp = listTemp.get(m);

					param.put("eqNo", voTemp.getEqNo());
					param.put("troSeq", voTemp.getTroSeq());

					dRsSub = new SQLExecuter("").executeQuery(new ContainerSelectPopupDBDAOSearchContainerSelectSubListRSoRSQL(), param,param);

					applySoSeq = getAppliedSoNo(dRsSub);
					if (!applySoSeq.equals("")) {
						voTemp.setApplySoSeq(applySoSeq);
						voTemp.setOrgApplySoSeq(applySoSeq);
					}
					listTemp.set(m, voTemp);					
				}

//				if(list == null){
					list = listTemp;
//				}else{
//					list.addAll(listTemp);
//				}								
			}
			eventResponse.setRsVoList(list);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return eventResponse;
	}
	
	/**
	 * ContainerSelectPopup의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContainerSelectReplaceTPSZList(EsdTrs0908Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		try {
			dRs = new SQLExecuter("").executeQuery(new ContainerSelectPopupDBDAOSearchContainerSelectReplaceTPSZListRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;

	}
	
	/**
	 * ContainerSelectPopup의 split bkg, current bkg list를 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSplitBkgList(EsdTrs0908Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
//		ArrayList arrBkgno = new ArrayList();
		param.put("orgBkgNo", event.getOrgBkgNo());
		param.put("bkgNo", event.getBkgNo());

		try {
			dRs = new SQLExecuter("").executeQuery(new ContainerSelectPopupDBDAOSearchSplitBkgListRRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
		
	}
	
	/**
	 * @param src
	 * @param elem
	 * @return
	 */
	public boolean contains(ArrayList src, String elem){
		
		boolean result = false;
		for(int i=0; src != null && i< src.size(); i++){
			if(elem.equals((String)src.get(i))){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * @param rowSet
	 * @return
	 * @throws Exception
	 */
	private String getAppliedSoNo(DBRowSet rowSet) throws Exception{

		StringBuffer returnStr = new StringBuffer();
		int cnt = 0;
		while(rowSet != null && rowSet.next()){
			if(cnt == 0){
				returnStr.append(rowSet.getString("APPLY_SO_SEQ"));
			}else{
				returnStr.append(", ");
				returnStr.append(rowSet.getString("APPLY_SO_SEQ"));
			}
			cnt++;
		}
		return returnStr.toString();
	}
	
}
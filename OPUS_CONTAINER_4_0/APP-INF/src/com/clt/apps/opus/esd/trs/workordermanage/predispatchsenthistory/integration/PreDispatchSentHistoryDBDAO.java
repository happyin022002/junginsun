/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PreDispatchSentHistoryDBDAO.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-19
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-19 kim_sang_geun
* 1.0 최초 생성
* 2010.10.12 정선용 [CHM-201006425]  MDM 상 EQ control office 변경에 따른 Pick up No. 관련 data 오류 수정
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.basic.PreDispatchSentHistoryBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.event.EsdTrs0021Event;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.vo.SearchPreDispatchSentHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgPkupNtcPkupNoVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim_sang_geun
 * @see PreDispatchSentHistoryBCImpl 참조
 * @since J2EE 1.4
 */
public class PreDispatchSentHistoryDBDAO extends DBDAOSupport {

	/**
	 * PreDispatchSentHistory의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPreDispatchSentHistory(EsdTrs0021Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList arr_wo_no   = new ArrayList();
		ArrayList arr_bkg_no  = new ArrayList();
		ArrayList arr_bill_no = new ArrayList();
		ArrayList arr_cntr_no = new ArrayList();
	
		try{
			SearchPreDispatchSentHistoryVO model = event.getSearchPreDispatchSentHistoryVO();
			
			if( model != null ){
				
				Map<String, String> condiParams = model.getColumnValues();
				
				if(model.getWoNo()   != null) arr_wo_no   = this.seperationParameter(condiParams.get("wo_no")  , ",");
				if(model.getBkgNo()  != null) arr_bkg_no  = this.seperationParameter(condiParams.get("bkg_no") , ",");
				if(model.getBillNo() != null) arr_bill_no = this.seperationParameter(condiParams.get("bill_no"), ",");
				if(model.getCntrNo() != null) arr_cntr_no = this.seperationParameter(condiParams.get("cntr_no"), ",");
				
				param.put("rad_wonotic"       , condiParams.get("rad_wonotic"));
				param.put("hid_frmdate"       , condiParams.get("hid_frmdate"));
				param.put("hid_todate"        , condiParams.get("hid_todate"));
				param.put("ctrl_ofc_cd"       , condiParams.get("ctrl_ofc_cd"));
				param.put("reference_no"      , condiParams.get("reference_no"));
				param.put("wo_iss_ofc_cd"     , condiParams.get("wo_iss_ofc_cd"));
				param.put("combo_svc_provider", condiParams.get("combo_svc_provider"));
				param.put("arr_wo_no"         , arr_wo_no);
				param.put("arr_bkg_no"        , arr_bkg_no);
				param.put("arr_bill_no"       , arr_bill_no);
				param.put("arr_cntr_no"       , arr_cntr_no);
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new PreDispatchSentHistoryDBDAOSearchPreDispatchSentHistoryRSQL(), param, param);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}

	/**
	 * PreDispatchSentHistory의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search01PreDispatchSentHistory(EsdTrs0021Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			SearchPreDispatchSentHistoryVO model = event.getSearchPreDispatchSentHistoryVO();
			
			if( model != null ){
				
				Map<String, String> condiParams = model.getColumnValues();
				
				param.put("trsp_so_ofc_cty_cd" , condiParams.get("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq"        , condiParams.get("trsp_so_seq")       );
				param.put("trsp_wo_seq"        , condiParams.get("trsp_wo_seq")       );
				param.put("trsp_wo_ofc_cty_cd" , condiParams.get("trsp_wo_ofc_cty_cd"));
				param.put("wo_iss_knt" , condiParams.get("wo_iss_knt"));
				param.put("trsp_dis_ref_no" , condiParams.get("trsp_dis_ref_no"));
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new PreDispatchSentHistoryDBDAOSearch01PreDispatchSentHistoryRSQL(), param, param);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * PreDispatchSentHistory의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param voList
	 * @return
	 * @throws DAOException
	 */
	public List batchPreDispatchSentHistory(List<TrsTrspSvcOrdVO> voList) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		List<SearchPreDispatchSentHistoryVO> rsList = null;
		
		try {
			if(voList != null ){
				
				param.put("soArr", voList);
				dRs = new SQLExecuter("DEFAULT").executeQuery(new PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryRSQL(), param,param);
				List<SearchPreDispatchSentHistoryVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, SearchPreDispatchSentHistoryVO.class);
				
				if(rsList == null){
					rsList = listTemp;
				}else{
					rsList.addAll(listTemp);
				}
				
				while( dRs.next() ){
					param.clear();
					param.put("vndr_seq", dRs.getString("VNDR_SEQ"));
					param.put("trsp_so_ofc_cty_cd", dRs.getString("TRSP_SO_OFC_CTY_CD"));
					param.put("trsp_so_seq", dRs.getString("TRSP_SO_SEQ"));
					new SQLExecuter("DEFAULT").executeUpdate(new PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryCSQL(), param,param);
					new SQLExecuter("DEFAULT").executeUpdate(new PreDispatchSentHistoryDBDAOBatchPreDispatchSentHistoryUSQL(), param,param);
					
				}

			}
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return rsList;
	}
	
	/**
	 * PreDispatchSentHistory의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param faxresponse_array
	 * @param emlresponse_array
	 * @throws DAOException
	 */
	public void updatePRE_DISPATCHSENTHISTORY(ArrayList faxresponse_array, ArrayList emlresponse_array) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Collection<SearchPreDispatchSentHistoryVO> faxModels = faxresponse_array;
			Collection<SearchPreDispatchSentHistoryVO> emlModels = emlresponse_array;
			
			new SQLExecuter("DEFAULT").executeBatch(new PreDispatchSentHistoryDBDAOUpdatePRE_DISPATCHSENTHISTORYFaxUSQL(), faxModels, param, param);
			new SQLExecuter("DEFAULT").executeBatch(new PreDispatchSentHistoryDBDAOUpdatePRE_DISPATCHSENTHISTORYEmlUSQL(), emlModels, param, param);
		
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		
	}
	
	/**
	 *  모든 목록을 가져온다.<br>
	 * 
	 * @param bkgPkupNtcNoVOS
	 * @return
	 * @throws DAOException
	 */
	public List searchServiceOrderManage(ArrayList<BkgPkupNtcPkupNoVO> bkgPkupNtcNoVOS) throws DAOException {
		
		DBRowSet dRs = null;		
		Map<String, Object> param = new HashMap<String, Object>();
		List<TrsTrspSvcOrdVO> rsList = null;
		
		try {
			
			if(bkgPkupNtcNoVOS != null ){
				for(int i=0; i<bkgPkupNtcNoVOS.size(); i++){
					param.put("cntr_no", (bkgPkupNtcNoVOS.get(i)).getCntrNo());
					param.put("bkg_no", (bkgPkupNtcNoVOS.get(i)).getBkgNo());
					param.put("pkup_yd_cd", (bkgPkupNtcNoVOS.get(i)).getPkupYdCd());
					dRs = new SQLExecuter("DEFAULT").executeQuery(new PreDispatchSentHistoryDBDAOSearchServiceOrderManageRSQL(), param,param);
					List<TrsTrspSvcOrdVO> listTemp = (List)RowSetUtil.rowSetToVOs(dRs, TrsTrspSvcOrdVO.class);
					param.clear();
					if(rsList == null){
						rsList = listTemp;
					}else{
						rsList.addAll(listTemp);
					}
				}				
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		
		return rsList;
		 
	}
	
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail INQUITY Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate)  {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
}
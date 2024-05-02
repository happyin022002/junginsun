/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailSoManageBCImpl.java
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성 
* 1.34 2010.11.23 이재위 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
* 2012.01.16 금병주 [CHM-201215713] [TRS] S/O 다중작업에 의한 COP status 오류 방지로직 추가요청 (US rail)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
//import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
//import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageHdrVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration.RailSoManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrInlndTrspExePlnQtyVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspExePlnVO;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.SearchRailSoManageHdrVO;
import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.vo.EqrRepoExeSoIfVO;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kim_sang_geun
 * @see ESD_TRS_201EventResponse,RailSoManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailSoManageBCImpl   extends BasicCommandSupport implements RailSoManageBC {

	// Database Access Object
	private transient RailSoManageDBDAO dbDao=null;

	/**
	 * RailSoManageBCImpl 객체 생성<br>
	 * RailSoManageDBDAO를 생성한다.<br>
	 */
	public RailSoManageBCImpl(){
		dbDao = new RailSoManageDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search01RailSoManageSel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e; 
		
		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();

		try {
			trsTrspRailBilOrdVO=dbDao.search01RailSoManageSel(event);
			return trsTrspRailBilOrdVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);			
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String search01RailSoManageSeq() throws EventException {
		String lSeq = "";

		try {
			lSeq = dbDao.search01RailSoManageSeq();
			return lSeq;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @exception EventException
	 */
	public void search01RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException {
		
		try {
			dbDao.search01RailSoManageIns(vo, lSeq, sCtrlUserId);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search01RailSoManageUpd(String lSeq) throws EventException {
		
		try {
			dbDao.search01RailSoManageUpd(lSeq);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search01RailSoManage(String lSeq) throws EventException {

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search01RailSoManage(lSeq);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search01RailSoManageDel(String lSeq) throws EventException {
		
		try {
			dbDao.search01RailSoManageDel(lSeq);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search06RailSoManageSel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		List<TrsTrspRailBilOrdVO> trsTrspRailBilOrdVO = new ArrayList<TrsTrspRailBilOrdVO>();

		try {
			trsTrspRailBilOrdVO=dbDao.search06RailSoManageSel(event);
			return trsTrspRailBilOrdVO;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @exception EventException
	 */
	public void search06RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException {

		try {
			dbDao.search06RailSoManageIns(vo, lSeq, sCtrlUserId);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search06RailSoManageUpd(String lSeq) throws EventException {

		try {
			dbDao.search06RailSoManageUpd(lSeq);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search06RailSoManage(String lSeq) throws EventException {

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search06RailSoManage(lSeq);
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @exception EventException
	 */
	public void search06RailSoManageDel(String lSeq) throws EventException {

		try {
			dbDao.search06RailSoManageDel(lSeq);	
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * BKG,COP CNTR List search <br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailsoBybkgcntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.searchRailsoBybkgcntr(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search08RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search08RailSoManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search09RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		ArrayList  eqr_overplan_al = null;

//		CntrRepoExecutionPlanEstablishBC command = new CntrRepoExecutionPlanEstablishBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		int i=0;
		HashMap tempMap		= new HashMap();
		
		ArrayList arr_ref_id=null;
		ArrayList arr_fm_nod_cd=null;
		ArrayList arr_to_nod_cd=null;
		ArrayList arr_eq_tpsz=null;
		ArrayList arr_more_qty=null;
		
		String[] aref_id=null;
		String[] afm_nod_cd=null;
		String[] ato_nod_cd=null;
		String[] aeq_tpsz_cd=null;
		String[] amore_qty=null;
		
		String ref_id = event.getHidRefId();
		String fm_nod_cd = event.getHidFmNodCd();
		String to_nod_cd = event.getHidToNodCd();
		String eq_tpsz_cd = event.getHidEqTpszCd();
		String more_qty= event.getHidMoreQty();
		String curr_dt= event.getHidCurrDt();

		String overPlan_refid = "";
		String pln_yrwk="";
		String repo_pln_id="";
		String trsp_mod_cd = "R";
		
		arr_ref_id = CommonUtil.seperationParameter(ref_id, ",");			
		arr_fm_nod_cd = CommonUtil.seperationParameter(fm_nod_cd, ",");			
		arr_to_nod_cd = CommonUtil.seperationParameter(to_nod_cd, ",");			
		arr_eq_tpsz = CommonUtil.seperationParameter(eq_tpsz_cd, ",");			
		arr_more_qty = CommonUtil.seperationParameter(more_qty, ",");			

		if( arr_ref_id != null ) {
			aref_id = new String[arr_ref_id.size()];
			for( int n = 0; n < arr_ref_id.size(); n++ ) {
				aref_id[n] = (String) arr_ref_id.get(n);
			}
		}
		if( arr_fm_nod_cd != null ) {
			afm_nod_cd = new String[arr_fm_nod_cd.size()];
			for( int n = 0; n < arr_fm_nod_cd.size(); n++ ) {
				afm_nod_cd[n] = (String) arr_fm_nod_cd.get(n);
			}
		}
		if( arr_to_nod_cd != null ) {
			ato_nod_cd = new String[arr_to_nod_cd.size()];
			for( int n = 0; n < arr_to_nod_cd.size(); n++ ) {
				ato_nod_cd[n] = (String) arr_to_nod_cd.get(n);
			}
		}
		if( arr_eq_tpsz != null ) {
			aeq_tpsz_cd = new String[arr_eq_tpsz.size()];
			for( int n = 0; n < arr_eq_tpsz.size(); n++ ) {
				aeq_tpsz_cd[n] = (String) arr_eq_tpsz.get(n);
			}
		}
		if( arr_more_qty != null ) {
			amore_qty = new String[arr_more_qty.size()];
			for( int n = 0; n < arr_more_qty.size(); n++ ) {
				amore_qty[n] = (String) arr_more_qty.get(n);
			}
		}
		

		try {
			for(i=0 ; arr_fm_nod_cd != null && i < arr_fm_nod_cd.size() ;i++ ) {
								
				if( Integer.parseInt(amore_qty[i])  > 0 ) {  // EQR overplan 대상 qty 가 0 이상일 때만.
					
					//inlandWrsTrsSOIF 오버플랜 함수 ( year week. yyyymmdd / fmnode / tonode / 'R' / tpsz / qty  
//					eqr_overplan_al = ((CntrRepoExecutionPlanEstablishBCImpl) command).inlandWrsTrsSOIF(  curr_dt  ,afm_nod_cd[i]   , ato_nod_cd[i] , "R", aeq_tpsz_cd[i] , Integer.parseInt(amore_qty[i]) );
					eqr_overplan_al = inlandWrsTrsSOIF(  curr_dt  ,afm_nod_cd[i]   , ato_nod_cd[i] , trsp_mod_cd, aeq_tpsz_cd[i] , Integer.parseInt(amore_qty[i]),repo_pln_id, pln_yrwk, ref_id);
		
					if(eqr_overplan_al != null) {
					      String[] arr = null;
					      for(int z=0; z<eqr_overplan_al.size(); z++) {
					          arr = (String[])eqr_overplan_al.get(z);	         
						  }
					      if(i ==0 ) overPlan_refid = overPlan_refid + arr[2];
					      else  overPlan_refid = overPlan_refid + ","+ arr[2];
					      
					      // 생성된 REF_ID 도 조회되도록 ref_id 리스트 추가.
					      tempMap.put("hid_ref_id",     event.getHidRefId() + ","+ arr[2]);  
				    	  tempMap.put("hid_eq_tpsz_cd", event.getHidEqTpszCd() + ","+ aeq_tpsz_cd[i]);

					}
				} else{
					if(i ==0 ) overPlan_refid = overPlan_refid + "nl"; 
				      else  overPlan_refid = overPlan_refid + ","+ "nl"; 
				}
				
			}
			
			rowSet=dbDao.search09RailSoManage(event);
						
			eventResponse.setRsVo(rowSet);
			eventResponse.setETCData("overplan_ref_id", overPlan_refid);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
    /**
	 * WRSTRS_SOIF 를 통해서 INLAND 데이터를 입력
	 * EQR_INLND_TRSP_PLN, EQR_INLND_TRSP_EXE_PLN, EQR_REPO_EXE_SO_IF 테이블에 데이터 입력
	 * 
	 * @param current_date	String
	 * @param fm_yd_cd		String
	 * @param to_yd_cd		String
	 * @param trsp_mod_cd	String
	 * @param cntr_tpsz_cd	String
	 * @param qty			int
	 * @param repo_pln_id 	String
	 * @param pln_yrwk		String	
	 * @param ref_id		String
	 * @return ArrayList
     * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList inlandWrsTrsSOIF(String current_date, String fm_yd_cd, String to_yd_cd, String trsp_mod_cd, String cntr_tpsz_cd, int qty, String repo_pln_id, String pln_yrwk, String ref_id) throws EventException {

        String etd_date     = "";
        String eta_date     = "";
        
        ArrayList soifList = new ArrayList();
        String[] soifArr  = null;
        
        String plnSeq = "0";
        String ref_seq = "0";
        DBRowSet rowSet = null;
        
		try {			
			// repo pln id
			etd_date        = current_date;
			eta_date        = dbDao.searchEtaDate(etd_date, fm_yd_cd, to_yd_cd, trsp_mod_cd);

			if(eta_date.equals("")) eta_date = etd_date;
			
			String office_code = "";
			String chk_us_rail = "N";
			
			SearchRailSoManageHdrVO hdrVO = new SearchRailSoManageHdrVO();
			hdrVO.setFmLocCd(fm_yd_cd.substring(0, 5));
			hdrVO.setTrspModCd(trsp_mod_cd);
			
			//미주 RAIL운송인지 체크한다
			chk_us_rail = dbDao.checkUsRail(hdrVO);
			
			// REQ_SEQ채번
			ref_seq = dbDao.searchGetRefSeq(repo_pln_id, pln_yrwk, plnSeq, ref_id);
			
			if(chk_us_rail.equals("Y")) { // USNYC, RAIL은 PHXSA로 하드코딩 - 멕시코는 제외
				office_code = "PHXSA";
		    }    
			// EQR_REPO_EXE_SO_IF 테이블의 REF_SEQ (ref_id 별로 1부터 시작) 
	       	for(int j=0; j<qty; j++) {    // qty만큼 insert 합니다.  
	       		EqrRepoExeSoIfVO eqrRepoExeSoIfVO = new EqrRepoExeSoIfVO();
		       	eqrRepoExeSoIfVO.setRepoPlnId(repo_pln_id);
		       	eqrRepoExeSoIfVO.setPlnYrwk(pln_yrwk);
		       	eqrRepoExeSoIfVO.setRefId(ref_id);
		       	eqrRepoExeSoIfVO.setPlnSeq(plnSeq);
		       	eqrRepoExeSoIfVO.setCntrTpszCd(cntr_tpsz_cd);
		       	eqrRepoExeSoIfVO.setTrspModCd(trsp_mod_cd);
		       	eqrRepoExeSoIfVO.setSoIfDivCd(trsp_mod_cd);
		       	eqrRepoExeSoIfVO.setFmYdCd(fm_yd_cd);
		       	eqrRepoExeSoIfVO.setToYdCd(to_yd_cd);
		       	eqrRepoExeSoIfVO.setFmDt(etd_date);
		       	eqrRepoExeSoIfVO.setToDt(eta_date);
		       	eqrRepoExeSoIfVO.setWoExeFlg("N");
		       	eqrRepoExeSoIfVO.setEqCtrlOfcCd(office_code);
	       		eqrRepoExeSoIfVO.setRefSeq(ref_seq);
	       		dbDao.insertInlandWrsTrsSOIF(eqrRepoExeSoIfVO,"TRS_SOIF");//INSERT INTO EQR_REPO_EXE_SO_IF 
	       	}			
			// soif pk search
			rowSet = dbDao.searchInlandWrsTrsSOIF(repo_pln_id, pln_yrwk, plnSeq , ref_id );
			
				
			int i =1;
			if (rowSet != null) {
				while (rowSet.next()) {
					soifArr = new String[4];
					for(int j=0; j<rowSet.getMetaData().getColumnCount(); j++) {
						soifArr[j] = rowSet.getString(i++);
					}
					i = 1;
					soifList.add(soifArr);
				}
			}
			
			return soifList;
		} catch (SQLException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch(Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(e.getMessage());
		}		
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailSoCorrectionTargetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event = (EsdTrs0201Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet	= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet = dbDao.searchRailSoCorrectionTargetList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search11RailSoManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search11RailSoManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * IN BOUND Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search02RailSoManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search02RailSoManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search04RailSoManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSetIrgAdjust   = null;

		try {			
			rowSetIrgAdjust    = dbDao.search04RailSoManage(event);
			eventResponse.setRsVo(rowSetIrgAdjust);			
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	
	
		
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchIrgCandidate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet= null;

		try {
			rowSet =dbDao.searchIrgCandidate(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search07RailSoManage(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			rowSet=dbDao.search07RailSoManage(soffice_cd, event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search13RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.search13RailSoManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search14RailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.search14RailSoManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_201 에 대한 추가 이벤트 처리<br>
	 * US Rail Billing - Correction
	 * 
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyRailSoManage(Event e, int row) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event 	event	= (EsdTrs0201Event)e;
		ArrayList 			arrSeq	= null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			arrSeq 	= dbDao.modifyTrsTrspRailBillingVos(event, row);
			eventResponse.setCustomData("arrTrspSoSeq", arrSeq);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_201 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailSoManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		ArrayList arrSeq = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			arrSeq = dbDao.removeTrsTrspRailBillingVos(event);
			eventResponse.setCustomData("arrTrspSoSeq", arrSeq);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	
	/**
	 * ESD_TRS_0203: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeEmptyRepoPlanForRail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			SearchRailSoManageHdrVO[] hdrVOs = event.getSearchRailSoManageHdrVos();
			for(int i=0; hdrVOs.length > 0 && i<hdrVOs.length; i++){
				if(hdrVOs[i].getChk1().equals("1")){
					dbDao.removeEmptyRepoPlanForRail(hdrVOs[i]);
				}
			}
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_201 에 대한 추가 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailSoManageForSpp(String soffice_cd, Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		ArrayList arrSeq = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			arrSeq = dbDao.removeTrsTrspRailBillingVosForSpp(soffice_cd, event);
			eventResponse.setCustomData("arrTrspSoSeq", arrSeq);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRailSoManage(Event e, int row) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		//Seqence 값을 전송하기 위해서 사용함.
		ArrayList arrSeq = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			arrSeq = dbDao.multiTrsTrspRailBillingVos(event, row);
			eventResponse.setCustomData("arrTrspSoSeq", arrSeq);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String multiRailSoCandidate(Event e, SignOnUserAccount account) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

//		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String chk_us_rail = "N";
		String rtn_ref_no = "";
		
		try {
			SearchRailSoManageHdrVO[] hdrVOs = event.getSearchRailSoManageHdrVos();
			for(int i=0; hdrVOs.length > 0 && i<hdrVOs.length; i++){
				if(hdrVOs[i].getIbflag().equals("I")){
					
					if(hdrVOs[i].getTrspModCd().equals("R")){// Rail 일 경우에만
						chk_us_rail = dbDao.checkUsRail(hdrVOs[i]);// From Node가 US Rail에 해당하는지 체크한다.
					}else{
						throw new EventException((new ErrorHandler("TRS00099",new String[]{"Please check Trans Mode."})).getMessage());
					}
					
					if(chk_us_rail.equals("Y")){
						rtn_ref_no = rtn_ref_no+dbDao.multiRailSoCandidate(hdrVOs[i],account)+",";
					}else{
						throw new EventException((new ErrorHandler("TRS00099",new String[]{"Please check the inputted from node."})).getMessage());
					}
					
				}
			}
			
			return rtn_ref_no;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());	
		}
	}

	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_203 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		//Seqence 값을 전송하기 위해서 사용함.
		ArrayList arrSeq = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			arrSeq = dbDao.multi02TrsTrspRailBillingVos(event);
			eventResponse.setCustomData("arrTrspSoSeq", arrSeq);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_203 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManageForNoTranjection(Event e, int row) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;

		//Seqence 값을 전송하기 위해서 사용함.
		ArrayList arrSeq = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			arrSeq 	= dbDao.multi02TrsTrspRailBillingVosForNoTranjection(event, row);
			eventResponse.setCustomData("arrTrspSoSeq", arrSeq);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_959 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @param suer_ctl_id
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01RailSoManage(String soffice_cd, String suer_ctl_id, Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multi01TrsTrspRailBillingVos(soffice_cd, suer_ctl_id, event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiProcRailSoManage(String soffice_cd) throws EventException{
		try {
			dbDao.multiProcTrsTrspRailBillingVos(soffice_cd);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param customData
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiProcRailSoManageForNoTranjection(Map<String, Object> customData, String soffice_cd) throws EventException{
		try {
			dbDao.multiProcTrsTrspRailBillingVosForNoTranjection(customData, soffice_cd);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @param row
	 * @param customData
	 * @param soffice_cd
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multiProcRailSoManageForWRS(Event e, int row, Map<String, Object> customData, String soffice_cd) throws EventException{
		EsdTrs0201Event event=(EsdTrs0201Event)e;
		try {
			dbDao.multiProcRailSoManageForWRS(event, row, customData, soffice_cd);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * S/O correction 시 S/O가 delete 됬는지 여부 체크
	 * 
	 * @param sofficeCd
	 * @param event
	 * @return String S/O NO.
	 * @throws EventException
	 */
	public String verifyRailSoManageDeltChk(String sofficeCd, EsdTrs0201Event event) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.verifyRailSoManageDeltChk(sofficeCd,event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * RailSoManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}
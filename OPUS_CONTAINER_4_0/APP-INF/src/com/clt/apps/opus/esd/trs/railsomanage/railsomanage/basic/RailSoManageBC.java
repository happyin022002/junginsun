/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : RailSoManageBC.java
 *@FileTitle : USA Rail Billing S/O create
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;

/**
 * Business Logic Command Interface<br>
 * An interface to the business logic for RailSoManage<br>
 * 
 * @author
 * @see Refer to EsdTrs0201EventResponse
 * @since
 */
public interface RailSoManageBC {

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search01RailSoManageSel(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public String search01RailSoManageSeq() throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @throws EventException
	 */
	public void search01RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search01RailSoManageUpd(String lSeq) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search01RailSoManage(String lSeq, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search01RailSoManageDel(String lSeq) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search06RailSoManageSel(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @throws EventException
	 */
	public void search06RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search06RailSoManageUpd(String lSeq) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search06RailSoManage(String lSeq, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search06RailSoManageDel(String lSeq) throws EventException;

	/**
	 * retrieve event process<br>
	 * BKG,COP CNTR List search<br>
	 * COP Out Bound<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailsoBybkgcntr(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search08RailSoManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Repo<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search09RailSoManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Empty Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search11RailSoManage(String soffice_cd, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * IN BOUND Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search02RailSoManage(String soffice_cd, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * Correction<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailSoCorrectionTargetList(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search04RailSoManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchIrgCandidate(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	// public EventResponse search05RailSoManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * RailSoManage retrieve event process<br>
	 * 
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search07RailSoManage(String soffice_cd, Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * Request Service Provider Inquiry retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search13RailSoManage(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * Request Empty Container Check retrieve event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search14RailSoManage(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_201 event process<br>
	 * US Rail Billing - Correction
	 * 
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse modifyRailSoManage(Event e, int row) throws EventException;

	/**
	 * delete event process<br>
	 * ESD_TRS_029 event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailSoManage(Event e) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiRailSoManage(Event e, int row) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_203 multi event process<br>
	 * 
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManage(Event e) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_203 multi event process<br>
	 * 
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi02RailSoManageForNoTranjection(Event e, int row) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_959 multi event process<br>
	 * 
	 * @param soffice_cd
	 * @param suer_ctl_id
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi01RailSoManage(String soffice_cd, String suer_ctl_id, Event e) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiProcRailSoManage(String soffice_cd) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param customData
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiProcRailSoManageForNoTranjection(Map<String, Object> customData, String soffice_cd) throws EventException;

	/**
	 * multi event process<br>
	 * ESD_TRS_201 multi event process<br>
	 * 
	 * @param e
	 * @param row
	 * @param customData
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiProcRailSoManageForWRS(Event e, int row, Map<String, Object> customData, String soffice_cd) throws EventException;

	/**
	 * WRSTRS_SOIF 를 통해서 INLAND 데이터를 입력
	 * EQR_INLND_TRSP_PLN, EQR_INLND_TRSP_EXE_PLN, EQR_REPO_EXE_SO_IF 테이블에 데이터 입력
	 * 로즈모델 품질관련 수정 2014.07.22 SHIN DONG IL, BCIMPL만 사용함.
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
	public ArrayList inlandWrsTrsSOIF(String current_date, String fm_yd_cd, String to_yd_cd, String trsp_mod_cd, String cntr_tpsz_cd, int qty, String repo_pln_id, String pln_yrwk, String ref_id) throws EventException;
}
/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OffdockCYInvoiceManageBCImpl.java
 *@FileTitle : Off-dock CY Invoice 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-10-09
 *@LastModifier : byungheeyoo
 *@LastVersion : 1.0
 * 2006-09-14 byungheeyoo
 * 1.0 최초 생성
 * 2009-05-29 [N200905280100]   : TPB I/F 누락 방지 추가
 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
 * 2011.08.08 윤태승 [CHM-201111829-1] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
 * 2015-03-24 김영신 [CHM-201534788]GW Agmt Link 기준 변경 (SAve->Confirm) 
 =========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.tescommon.util.TESUtil;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0004Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0018Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9030Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9034Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9050Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9074Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9075Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9150Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9233Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9240Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9253Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration.OffdockCYInvoiceManageDBDAO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoRvisListVO;

/**
 * ENIS-ESD Business Logic Basic Command implementation<br> - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author byungheeyoo
 * @see ESD_TES_004EventResponse,OffdockCYInvoiceManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OffdockCYInvoiceManageBCImpl extends BasicCommandSupport implements OffdockCYInvoiceManageBC {

	private transient OffdockCYInvoiceManageDBDAO dbDao = null;

	/**
	 * OffdockCYInvoiceManageBCImpl 객체 생성<br>
	 * OffdockCYInvoiceManageDBDAO를 생성한다.<br>
	 */
	public OffdockCYInvoiceManageBCImpl() {
		dbDao = new OffdockCYInvoiceManageDBDAO();
	}

	/**
	 * Cost Calc. 계산하기
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse calOffdockCYInvoiceCost(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		String tml_cost_grp_cd = "";
		String tml_calc_ind_cd = "";

		try {
			//Auto Calculation 전에 delete button으로 flag만 업데이트 한 데이타 delete 처리
		    //dbDao.removeOffdockCYInvoiceAutoCalcDeleteData(event.getTesTmlSoHdrVO());
			
			tml_cost_grp_cd = event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			tml_calc_ind_cd = event.getOffdockCYInvoiceManageVO().getTmlCalcIndCd();

			log.debug("at calOffdockCYInvoiceCost [tml_cost_grp_cd "+tml_cost_grp_cd+"], [tml_calc_ind_cd "+tml_calc_ind_cd+"]");
			
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
					if (tml_calc_ind_cd != null && tml_calc_ind_cd.equals("TP")) {
						dbDao.calOffdockCYInvoiceCostTMNLUpdate( event.getTesTmlSoHdrVO() );
						rsList.add( dbDao.calOffdockCYInvoiceCostTMNL(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
					} else if (tml_calc_ind_cd != null && tml_calc_ind_cd.equals("SP")) {
						dbDao.calOffdockCYInvoiceCostTMNLUpdate( event.getTesTmlSoHdrVO() );
						rsList.add( dbDao.calOffdockCYInvoiceCostTMNLseparate(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
					} else {
						rsList.add( new DBRowSet() );
					}
				}
				else {
					rsList.add( new DBRowSet() );
				}
				
				if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
					rsList.add( dbDao.calOffdockCYInvoiceCostByDay(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
				}
				else {
					rsList.add( new DBRowSet() );
				}
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;
				
			} else {
				return null;
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param e Event 
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(Event e)
			throws EventException {
		try
		{
			EsdTes9140Event event = (EsdTes9140Event)e;
			
			OffdockCYInvoiceManageBackEndJob backEndJob = new OffdockCYInvoiceManageBackEndJob();
			backEndJob.setEvent(event);
			String resultStr = "";
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob, event.getSignOnUserAccount().getUsr_id(), "off dock verify");
			
			return resultStr;
			// DAO 호출이 없으므로 DAOException을 catch하는 부분은 생략한다.
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * OffDock CY Invoice Container List Import File Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		
		int ins_idx = 0;	
		String strTmlSoOfcCtyCd = "";
		String strTmlSoSeq = "";
		String strVndrSeq = "";
		String strYdCd = "";
		String strRcvDt = "";
		String strFmPrdDt = "";
		String strToPrdDt = "";
		String strCreUsrId = "";
		String strUpdUsrId = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesFileImpTmpVO[] tesFileImpTmpVOs = null;		
		List<TesFileImpTmpVO> insertVOList = new ArrayList<TesFileImpTmpVO>();
		
		try {		
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesFileImpTmpVOs = event.getTesFileImpTmpVOs();
			
			strTmlSoOfcCtyCd= tesTmlSoHdrVO.getTmlSoOfcCtyCd();
			strTmlSoSeq     = tesTmlSoHdrVO.getTmlSoSeq();
			strVndrSeq      = tesTmlSoHdrVO.getVndrSeq();
			strYdCd         = tesTmlSoHdrVO.getYdCd();
			strRcvDt		= JSPUtil.replace( tesTmlSoHdrVO.getRcvDt(), "-", "" );
			strFmPrdDt      = JSPUtil.replace( event.getTesTmlSoHdrVO().getFmPrdDt(), "-", "" );
			strToPrdDt      = JSPUtil.replace( event.getTesTmlSoHdrVO().getToPrdDt(), "-", "" );
			strCreUsrId     = event.getSignOnUserAccount().getUsr_id();
			strUpdUsrId     = event.getSignOnUserAccount().getUsr_id();	
			
			for( int i=0; tesFileImpTmpVOs!=null && i<tesFileImpTmpVOs.length; i++){
				
				if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_FILE_IMP_TMP", "TML_SO_TMP_SEQ");
				
				tesFileImpTmpVOs[i].setTmlSoOfcCtyCd(strTmlSoOfcCtyCd);
				tesFileImpTmpVOs[i].setTmlSoSeq(strTmlSoSeq);
				tesFileImpTmpVOs[i].setTmlSoTmpSeq((String.valueOf(++ins_idx)));
				tesFileImpTmpVOs[i].setVndrSeq(strVndrSeq);
				tesFileImpTmpVOs[i].setYdCd(strYdCd);
				tesFileImpTmpVOs[i].setRcvDt(strRcvDt);
				tesFileImpTmpVOs[i].setFmPrdDt(strFmPrdDt);
				tesFileImpTmpVOs[i].setToPrdDt(strToPrdDt);
				tesFileImpTmpVOs[i].setCreUsrId(strCreUsrId);
				tesFileImpTmpVOs[i].setUpdUsrId(strUpdUsrId);
				
				insertVOList.add(tesFileImpTmpVOs[i]);
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createTES_FILE_IMP_TMP(insertVOList);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * OffDock CY Invoice Container List Import File Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;

		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * insertOffdockCYInvoiceContainerList 에 내용을 포함시켰음
	 * alps 에서는 더이상 사용안함
	 * verify하기 - verify하고 그 결과를 바로 cntr_list에 때려 넣는다.
	 * OffDock CY Invoice Container List Verify
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOffdockCYInvoiceVolume(Event e) throws EventException {
		log.debug("\n\n BC.verifyOffdockCYInvoiceVolume++++++++++++++++++++\n");

		EsdTes9140Event event = (EsdTes9140Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.verifyOffdockCYInvoiceVolume(event.getTesTmlSoHdrVO()) );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
	}

	/**
	 * OffDock CY Invoice Container List Verify Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public int insertOffdockCYInvoiceContainerList(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		DBRowSet rowSet = null;
		int insCnt = 0;
		
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		List<TesTmlSoCntrListVO> voList = new ArrayList<TesTmlSoCntrListVO>();
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		String strTmlSoOfcCtyCd = "";
		String strTmlSoSeq = "";	
		String strUsrId = "";
		String strOfcCd = "";
		int ins_idx = 0;
		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			
			strTmlSoOfcCtyCd = tesTmlSoHdrVO.getTmlSoOfcCtyCd(); 
			strTmlSoSeq = tesTmlSoHdrVO.getTmlSoSeq();
			strUsrId = event.getSignOnUserAccount().getUsr_id();
			strOfcCd = event.getSignOnUserAccount().getOfc_cd();
			
			rowSet = event.getRowSet();
			
			if (rowSet != null){
				if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
				while (rowSet.next()) {	
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(strTmlSoOfcCtyCd);
					tesTmlSoCntrListVO.setTmlSoSeq(strTmlSoSeq); 
					tesTmlSoCntrListVO.setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					tesTmlSoCntrListVO.setVrfyRsltIndCd( rowSet.getString("VRFY_RSLT_IND_CD") );
					tesTmlSoCntrListVO.setDscrIndCd( rowSet.getString("DSCR_IND_CD") );
					tesTmlSoCntrListVO.setVslCd( rowSet.getString("VSL_CD") );
					tesTmlSoCntrListVO.setSkdVoyNo( rowSet.getString("SKD_VOY_NO") );
					tesTmlSoCntrListVO.setSkdDirCd( rowSet.getString("SKD_DIR_CD") );
					tesTmlSoCntrListVO.setIoBndCd( rowSet.getString("IO_BND_CD") );
					tesTmlSoCntrListVO.setCntrNo( rowSet.getString("CNTR_NO") );
					tesTmlSoCntrListVO.setCntrTpszCd( rowSet.getString("CNTR_TPSZ_CD") );
					tesTmlSoCntrListVO.setCntrStyCd( rowSet.getString("CNTR_STY_CD") );
					tesTmlSoCntrListVO.setLoclTsIndCd( rowSet.getString("LOCL_TS_IND_CD") );
					tesTmlSoCntrListVO.setMvmtGateInDt( rowSet.getString("MVMT_GATE_IN_DT") );
					tesTmlSoCntrListVO.setInvGateInDt( rowSet.getString("INV_GATE_IN_DT") );
					tesTmlSoCntrListVO.setGateInTdDys( rowSet.getString("GATE_IN_TD_DYS") );
					tesTmlSoCntrListVO.setMvmtGateOutDt( rowSet.getString("MVMT_GATE_OUT_DT") );
					tesTmlSoCntrListVO.setInvGateOutDt( rowSet.getString("INV_GATE_OUT_DT") );
					tesTmlSoCntrListVO.setGateOutTdDys( rowSet.getString("GATE_OUT_TD_DYS") );
					tesTmlSoCntrListVO.setMvmtStayDys( rowSet.getString("MVMT_STAY_DYS") );
					tesTmlSoCntrListVO.setInvStayDys( rowSet.getString("INV_STAY_DYS") );
					tesTmlSoCntrListVO.setStayDiffDys( rowSet.getString("STAY_DIFF_DYS") );
					tesTmlSoCntrListVO.setDcgoClssCd( rowSet.getString("DCGO_CLSS_CD") );
					tesTmlSoCntrListVO.setBbCgoFlg( rowSet.getString("BB_CGO_FLG") );
					tesTmlSoCntrListVO.setBkgNo( rowSet.getString("BKG_NO") );
					tesTmlSoCntrListVO.setBlNo( rowSet.getString("BL_NO") );
					tesTmlSoCntrListVO.setAwkCgoFlg( rowSet.getString("AWK_CGO_FLG") );
					tesTmlSoCntrListVO.setRcFlg( rowSet.getString("RC_FLG") );
					tesTmlSoCntrListVO.setCntrRmk( rowSet.getString("CNTR_RMK") );
					tesTmlSoCntrListVO.setTmlTrnsModCd( rowSet.getString("TML_TRNS_MOD_CD") );
					tesTmlSoCntrListVO.setCreUsrId(strUsrId);
					tesTmlSoCntrListVO.setUpdUsrId(strUsrId);
					tesTmlSoCntrListVO.setLoclCreDt(strOfcCd);
					tesTmlSoCntrListVO.setLoclUpdDt(strOfcCd);
					
					voList.add(tesTmlSoCntrListVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				//삭제 후 삽입
				dbDao.removeOffdockCYInvoiceContainerList(tesTmlSoHdrVO);
				insCnt = dbDao.insertOffdockCYInvoiceContainerList(voList);
			}	
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}	
	}

	/**
	 * OffDock CY Invoice Container List Import File By Pool Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMPByPool(Event e) throws EventException {
		
		EsdTes9150Event event = (EsdTes9150Event) e;
		
		int ins_idx = 0;
	
		OffdockCYInvoiceManageVO[] offdockCYInvoiceManageVOs = null;
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesFileImpTmpVO[] tesFileImpTmpVOs = null;		
		List<TesFileImpTmpVO> insertVOList = new ArrayList<TesFileImpTmpVO>();
		
		try {
			offdockCYInvoiceManageVOs = event.getOffdockCYInvoiceManageVOs();
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesFileImpTmpVOs = event.getTesFileImpTmpVOs();
			
			for( int i=0; tesFileImpTmpVOs!=null && i<tesFileImpTmpVOs.length; i++){
				if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_FILE_IMP_TMP", "TML_SO_TMP_SEQ");
				
				tesFileImpTmpVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesFileImpTmpVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesFileImpTmpVOs[i].setTmlSoTmpSeq((String.valueOf(++ins_idx)));
				tesFileImpTmpVOs[i].setVndrSeq(tesTmlSoHdrVO.getVndrSeq());
				tesFileImpTmpVOs[i].setYdCd(tesTmlSoHdrVO.getYdCd());
				
				tesFileImpTmpVOs[i].setWrkDt(offdockCYInvoiceManageVOs[i].getWrkDt());
				tesFileImpTmpVOs[i].setInvVolQty(offdockCYInvoiceManageVOs[i].getInvVolQty());
				tesFileImpTmpVOs[i].setFmPrdDt(JSPUtil.replace( tesTmlSoHdrVO.getFmPrdDt(), "-", ""));
				tesFileImpTmpVOs[i].setToPrdDt(JSPUtil.replace( tesTmlSoHdrVO.getToPrdDt(), "-", ""));
				tesFileImpTmpVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
				tesFileImpTmpVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				
				insertVOList.add(tesFileImpTmpVOs[i]);
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createTES_FILE_IMP_TMPByPool(insertVOList);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Container List Import File By Pool Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMPByPool(Event e) throws EventException {
		EsdTes9150Event event = (EsdTes9150Event) e;

		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Container List Verify By Pool
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOffdockCYInvoiceCostByPool(Event e) throws EventException {
		log.debug("\n\n BC.verifyOffdockCYInvoiceCostByPool++++++++++++++++++++\n");
		EsdTes9150Event event = (EsdTes9150Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.verifyOffdockCYInvoiceCostByPool(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * OffDock CY Invoice Cost Calculation List Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public int insertOffdockCYInvoiceDetail(Event e) throws EventException {
		EsdTes9150Event event = (EsdTes9150Event) e;
		int insCnt = 0;
		DBRowSet rowSet = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;
		List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		String strTmlSoOfcCtyCd = "";
		String strTmlSoSeq = "";
		
		int ins_idx = 0;

		try {
			rowSet = event.getRowSet();
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			
			strTmlSoOfcCtyCd = tesTmlSoHdrVO.getTmlSoOfcCtyCd(); 
			strTmlSoSeq = tesTmlSoHdrVO.getTmlSoSeq();
			
			if (rowSet != null){
				if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_DTL", "TML_SO_DTL_SEQ");
				while (rowSet.next()) {	
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setTmlSoOfcCtyCd(strTmlSoOfcCtyCd);
					tesTmlSoDtlVO.setTmlSoSeq(strTmlSoSeq); 
					tesTmlSoDtlVO.setTmlSoDtlSeq(String.valueOf(++ins_idx));
					tesTmlSoDtlVO.setCalcCostGrpCd(rowSet.getString("CALC_COST_GRP_CD"));
					tesTmlSoDtlVO.setCalcTpCd(rowSet.getString("CALC_TP_CD"));
					tesTmlSoDtlVO.setLgsCostCd(rowSet.getString("LGS_COST_CD"));
					tesTmlSoDtlVO.setAcctCd(rowSet.getString("ACCT_CD"));
					tesTmlSoDtlVO.setFpCalcPrdCd(rowSet.getString("FP_CALC_PRD_CD"));
					tesTmlSoDtlVO.setWrkDt(rowSet.getString("WRK_DT"));
					tesTmlSoDtlVO.setStkVolQty(rowSet.getString("STK_VOL_QTY"));
					tesTmlSoDtlVO.setFpTeuQty(rowSet.getString("FP_TEU_QTY"));
					tesTmlSoDtlVO.setInvVolQty(rowSet.getString("INV_VOL_QTY"));
					tesTmlSoDtlVO.setDiffVolQty(rowSet.getString("DIFF_VOL_QTY"));
					tesTmlSoDtlVO.setOvrVolQty(rowSet.getString("OVR_VOL_QTY"));
					tesTmlSoDtlVO.setVolTrUtCd(rowSet.getString("VOL_TR_UT_CD"));
					tesTmlSoDtlVO.setCtrtRt(rowSet.getString("CTRT_RT"));
					tesTmlSoDtlVO.setCalcAmt(rowSet.getString("CALC_AMT"));
					tesTmlSoDtlVO.setInvAmt(rowSet.getString("INV_AMT"));
					tesTmlSoDtlVO.setTmlAgmtOfcCtyCd(rowSet.getString("TML_AGMT_OFC_CTY_CD"));
					tesTmlSoDtlVO.setTmlAgmtSeq(rowSet.getString("TML_AGMT_SEQ"));
					tesTmlSoDtlVO.setTmlAgmtVerNo(rowSet.getString("TML_AGMT_VER_NO"));
					tesTmlSoDtlVO.setCurrCd(rowSet.getString("CURR_CD"));
					tesTmlSoDtlVO.setInvXchRt(rowSet.getString("INV_XCH_RT"));
					tesTmlSoDtlVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoDtlVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					voList.add(tesTmlSoDtlVO);
				}
			}		
			
			if ( voList.size() > 0 ) {
				insCnt = dbDao.insertOffdockCYInvoiceDetail(voList);
			}				
			
			return insCnt;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}			
	}

	/**
	 * OffDock CY Invoice Container Number Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException {

		EsdTes9140Event event = (EsdTes9140Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		

		try {
			eventResponse.setRs( dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OffDock CY Invoice Container Number Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		DBRowSet rowSet = null;
		TesFileImpTmpVO tesFileImpTmpVO = null;
		List<TesFileImpTmpVO> voList = new ArrayList<TesFileImpTmpVO>();

		try {
			rowSet = dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO());
			
			if (rowSet != null){
				while (rowSet.next()) {
					tesFileImpTmpVO = new TesFileImpTmpVO();
					tesFileImpTmpVO.setCntrNo( JSPUtil.getNull( rowSet.getString("CNTR_NO") ) );
					tesFileImpTmpVO.setTmlSoOfcCtyCd( JSPUtil.getNull( rowSet.getString("TML_SO_OFC_CTY_CD") ) );
					tesFileImpTmpVO.setTmlSoSeq( JSPUtil.getNull( rowSet.getString("TML_SO_SEQ") ) );
					tesFileImpTmpVO.setTmlSoTmpSeq( JSPUtil.getNull( rowSet.getString("TML_SO_TMP_SEQ") ) );	
					voList.add(tesFileImpTmpVO);
				}
			}
			if ( voList.size() > 0 ) {
				dbDao.updateCNTRNumber( voList );
			}			 
			return null;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}		
	}

	/**
	 * OffDock CY Invoice Container Number Update
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber2(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		DBRowSet rowSet = null;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		List<TesTmlSoCntrListVO> voList = new ArrayList<TesTmlSoCntrListVO>();

		try {
			rowSet = dbDao.searchCNTRNumber2(tesTmlSoHdrVO);
			
			if (rowSet != null){
				while (rowSet.next()) {
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					tesTmlSoCntrListVO.setCntrNo( JSPUtil.getNull( rowSet.getString("CNTR_NO") ) );
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd( JSPUtil.getNull( rowSet.getString("TML_SO_OFC_CTY_CD") ) );
					tesTmlSoCntrListVO.setTmlSoSeq( JSPUtil.getNull( rowSet.getString("TML_SO_SEQ") ) );
					tesTmlSoCntrListVO.setTmlSoCntrListSeq( JSPUtil.getNull( rowSet.getString("TML_SO_CNTR_LIST_SEQ") ) );	
					voList.add(tesTmlSoCntrListVO);
				}
			}
			if ( voList.size() > 0 ) {
				dbDao.updateCNTRNumber2( voList );
			}			 
			return null;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		}		
	}
	
	/**
	 * OffDock CY Invoice Container List Import File Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRs( dbDao.searchTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock Invoice Detail 정보 조회
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceDetail(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String tml_cost_grp_cd = "";	
		String dtl_by_pool_only_mode = "";		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 		
		try {
			tml_cost_grp_cd = (String) event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			dtl_by_pool_only_mode = (String) event.getOffdockCYInvoiceManageVO().getDtlByPoolOnlyMode();
						
			log.debug("########   tml_cost_grp_cd : "+tml_cost_grp_cd+", dtl_by_pool_only_mode : "+dtl_by_pool_only_mode);
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (dtl_by_pool_only_mode != null && dtl_by_pool_only_mode.equals("Y")) {
					rsList.add( dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()) );
				} else {
					if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
						rsList.add( dbDao.searchCalcCostTMNLList(event.getTesTmlSoHdrVO()) );
					}
					else rsList.add(null);
					
					if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
						rsList.add( dbDao.searchCalcCostByDayList(event.getTesTmlSoHdrVO()) );
					}
					else rsList.add(null);
					
					rsList.add( dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()) );
				}
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;

			} else {
				return null;
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice All Data Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceAllSheets(Event e) throws EventException {

		log.debug("\n\n BC.searchOffdockCYInvoiceAllSheets() - @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String tml_cost_grp_cd = "";	
		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {

			tml_cost_grp_cd = (String)event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			log.debug("\n - tml_cost_grp_cd:" + tml_cost_grp_cd + " -------\n");

			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "CO"));
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "DC"));
					
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
					rsList.add(dbDao.searchCalcCostTMNLList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}

				if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
					rsList.add(dbDao.searchCalcCostByDayList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}
				
				rsList.add(dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()));				
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;
			} else {
				return null;
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}			
	}

	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolume(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String calc_tp_cd = "";

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug("at BC.searchRevisedVolume >> calc_tp_cd >> "+calc_tp_cd);
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				eventResponse.setRs( dbDao.searchRevisedVolume(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
			else if (calc_tp_cd != null && (calc_tp_cd.equals("M") || calc_tp_cd.equals("S"))) {
				eventResponse.setRs( dbDao.searchRevisedVolumeManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolumeForTMRFMO(Event e) throws EventException {
		EsdTes9034Event event = (EsdTes9034Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String calc_tp_cd = "";

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug("at BC.searchRevisedVolumeForTMRFMO >> calc_tp_cd >> "+calc_tp_cd);
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				eventResponse.setRs( dbDao.searchRevisedVolume(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
			else if (calc_tp_cd != null && (calc_tp_cd.equals("M") || calc_tp_cd.equals("S"))) {
				eventResponse.setRs( dbDao.searchRevisedVolumeManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolumeSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String calc_tp_cd = "";

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparate(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
			else if (calc_tp_cd != null && (calc_tp_cd.equals("M") || calc_tp_cd.equals("S"))) {
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparateManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			}
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Revised Volume Double Billing check
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public String[] searchOffdockRevisedVolumeDoubleBillChk(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		
		try {
			return dbDao.searchOffdockRevisedVolumeDoubleBillChk(event.getTesTmlSoHdrVO(), event.getTesTmlSoCntrListVOs(), event.getTesTmlSoRvisListVOs());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolume2(Event e) throws EventException {
		
		EsdTes9074Event event = (EsdTes9074Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String calc_tp_cd = "";
		
		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug(">>>>>>>>>>>>> BCImpl [calc_tp_cd - "+calc_tp_cd+"]");
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {			
				eventResponse.setRs( dbDao.searchRevisedVolume(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			} else if (calc_tp_cd != null && calc_tp_cd.equals("M")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			}
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRevisedVolumeSeparate2(Event e) throws EventException {
		
		EsdTes9075Event event = (EsdTes9075Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		String calc_tp_cd = "";
		
		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug(">>>>>>>>>>>>> BCImpl [calc_tp_cd - "+calc_tp_cd+"] fm prd dt : "+event.getOffdockCYInvoiceManageVO().getFmPrdDt());
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {			
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparate(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			} else if (calc_tp_cd != null && calc_tp_cd.equals("M")) {
				eventResponse.setRs( dbDao.searchRevisedVolumeSeparateManual(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()));
			}
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OffDock CY Invoice 수동시 revise mode TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYReviseMode(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYReviseModeSeparate(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice 수동시 revise mode TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYReviseModeForTMRFMO(Event e) throws EventException {
		EsdTes9034Event event = (EsdTes9034Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYReviseModeSeparate(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice 수동시 revise mode Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYReviseModeSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYReviseModeSeparate(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData("successFlag", "SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(N) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchOffdockCYRvisCntrListCdN(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdN() );
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * OffDock CY Invoice revise mode(N) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchOffdockCYRvisCntrListCdNSeparate(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdN() );
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdMT(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {			
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdMT(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdMTForTMRFMO(Event e) throws EventException {
		EsdTes9034Event event = (EsdTes9034Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {			
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdMT(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdMTSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdMT(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdDG(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdDG(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdDGForTMRFMO(Event e) throws EventException {
		EsdTes9034Event event = (EsdTes9034Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdDG(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
			
	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdDGSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdDG(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdRF(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdRF(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
	}

	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdRFForTMRFMO(Event e) throws EventException {
		EsdTes9034Event event = (EsdTes9034Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdRF(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
	}
	
	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdRFSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {			
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdRF(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdAK(Event e) throws EventException {
		EsdTes9030Event event = (EsdTes9030Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdAK(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdAKForTMRFMO(Event e) throws EventException {
		EsdTes9034Event event = (EsdTes9034Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdAK(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYRvisCntrListCdAKSeparate(Event e) throws EventException {
		EsdTes9240Event event = (EsdTes9240Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYRvisCntrListCdAK(event.getTesTmlSoHdrVO(), event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlistOnly(Event e) throws EventException {
		EsdTes9253Event event = (EsdTes9253Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		

		try {
			eventResponse.setRs( dbDao.searchOffdock3rdIFlistOnly(event.getOffdockCYInvoiceManageVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlist(Event e) throws EventException {
		EsdTes9233Event event = (EsdTes9233Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		DBRowSet rowSet = null;
		String calc_tp_cd = null;

		try {
			calc_tp_cd = event.getOffdockCYInvoiceManageVO().getCalcTpCd();
			
			log.debug("\nBC.calc_tp_cd:" + calc_tp_cd + "\n");
			
			if (calc_tp_cd != null && calc_tp_cd.equals("A")) {
				rowSet = dbDao.searchOffdock3rdIFlist(event.getOffdockCYInvoiceManageVO());
			} else if (calc_tp_cd != null && calc_tp_cd.equals("M")) {
				rowSet = dbDao.searchOffdock3rdIFlistManual(event.getOffdockCYInvoiceManageVO());
			}
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice 3rd party 목록 ByDay Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlistByDay(Event e) throws EventException {
		EsdTes9233Event event = (EsdTes9233Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		DBRowSet rowSet = null;
		String calc_tp_cd = null;
		OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = event.getOffdockCYInvoiceManageVO(); 
		
		try {
			
			calc_tp_cd = JSPUtil.getNull( offdockCYInvoiceManageVO.getCalcTpCd() );
			log.debug("\nBC.calc_tp_cd:" + calc_tp_cd + "\n");
			
			if (calc_tp_cd != null && "A".equals(calc_tp_cd)) {
				rowSet = dbDao.searchOffdock3rdIFlistByDay(offdockCYInvoiceManageVO);
			} else if (calc_tp_cd != null && "M".equals(calc_tp_cd)) {
				rowSet = dbDao.searchOffdock3rdIFlistByDayManual(offdockCYInvoiceManageVO);
			}
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * OffDock CY Invoice Total Amount Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYTotalAmount(Event e) throws EventException {
		EsdTes9050Event event = (EsdTes9050Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		
		try {
			eventResponse.setRs( dbDao.searchOffdockCYTotalAmount(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

	/**
	 * OffDock CY Container List Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYContainerList(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "CO"));
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "DC"));

			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * off-dock invoice header 정보 조회
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceBasicInfo(Event e) throws EventException {
		log.debug("at BC.searchOffdockCYInvoiceBasicInfo");
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		

		try {
			eventResponse.setRs( dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * OffDock CY Invoice Reject Info Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceRejectInfo(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	

		try {
			eventResponse.setRs( dbDao.searchOffdockCYInvoiceRejectInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * confirm 정보 수정
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffdockCYInvoiceConfirm(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		String chkAmt = "";

		try {
			TESInvoiceCommonBC	invCom	= new TESInvoiceCommonBCImpl();
			
			chkAmt = dbDao.checkSOInvAmt(event.getTesTmlSoHdrVO());
			log.error("\n DONE - modifyStorageInvoiceConfirm.checkInvAmt:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			if (chkAmt == null || (chkAmt != null && !chkAmt.equals("Y"))) {
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new DAOException(new ErrorHandler("TES00088").getMessage());
			}
			
			// TPB I/F N3PTY_FLG 누락 방지 ( 2009-06-03 ) 
			// 1. SO_DTL N3PTY_FLG 값 check 
			invCom.checkDetailTpb(event.getTesTmlSoHdrVO());
			
			// 2. check결과 업데이트
			dbDao.modifyOffdockCYInvoiceConfirm(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * confirm 취소
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelOffdockCYInvoiceConfirm(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		// String return_flag = "N";
		// DBRowSet rowSetList = null;

		try {
			dbDao.cancelOffdockCYInvoiceConfirm(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Reject Cancel.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelOffdockCYInvoiceReject(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.cancelOffdockCYInvoiceReject(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Account Code Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateOffdockCYAccountCode(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		DBRowSet rowSet = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;

		List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();
		
		Map<String, String> etcMap = new HashMap<String, String>();
		
		try {
			
			etcMap.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			etcMap.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
			
			rowSet = dbDao.searchOffdockCYAccountCode(event.getTesTmlSoHdrVO());
			
			if (rowSet != null){
				while( rowSet.next() ) {
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setAcctCd( JSPUtil.getNull( rowSet.getString("ACCT_CD") ) );
					tesTmlSoDtlVO.setLgsCostCd( JSPUtil.getNull( rowSet.getString("LGS_COST_CD") ) );
					tesTmlSoDtlVO.setTmlSoOfcCtyCd( JSPUtil.getNull( rowSet.getString("TML_SO_OFC_CTY_CD") ) );
					tesTmlSoDtlVO.setTmlSoSeq( JSPUtil.getNull( rowSet.getString("TML_SO_SEQ") ) );
					tesTmlSoDtlVO.setTmlSoDtlSeq( JSPUtil.getNull( rowSet.getString("TML_SO_DTL_SEQ") ) );
					
					voList.add(tesTmlSoDtlVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				dbDao.updateOffdockCYAccountCode(voList, etcMap);
			}
			 
			return null;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage());
		} 
	}

	/**
	 * 호출되는곳 안보임.(2010-02-08)
	 * OffDock CY Cost Calculation Status Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYCostCalcSts(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createOffdockCYInvoiceBasicInfo(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;

		DBRowSet rowSet = null;

		try {
			rowSet = dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			if (rowSet.getRowCount() != 0) { // 중복 확인
//				throw new DAOException("DUP --> addOffdockCYInvoiceManage() ");
				throw new DAOException(new ErrorHandler("TES00095").getMessage());

			}
			
			/**
			 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
			 */
			java.util.HashMap<String, String> hm = new java.util.HashMap<String, String>();
			hm.put("vndr_seq",event.getTesTmlSoHdrVO().getVndrSeq());
			hm.put("inv_no",event.getTesTmlSoHdrVO().getInvNo());
			new TESInvoiceCommonBCImpl().checkEDIInvoiceDup(hm);
			
			dbDao.createOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * confirm 정보 수정
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffdockCYInvoice(Event e) throws EventException {
		EsdTes0004Event event = (EsdTes0004Event) e;
		log.debug(">>>>>>>>>>>>>> BC.modifyOffdockCYInvoice() - "+event.getSignOnUserAccount().getUsr_id()+" - "+event.getSignOnUserAccount().getOfc_cd());
		try {
			dbDao.modifyOffdockCYInvoice(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Reject Invoice 정보 수정
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOffdockCYInvoiceReject(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.modifyOffdockCYInvoiceReject(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Container List Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceContainerList(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceContainerList(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Detail TMNL List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailTMNL(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "TM");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Detail By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailByDay(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "SD");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Detail By Pool List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailByPool(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceDetail(event.getTesTmlSoHdrVO(), "SP");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Revise List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceRvis(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceRvis(event.getTesTmlSoHdrVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 3rd list(TMNL, FD) 삭제
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceN3rd01(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "TM");
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "SD");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 3rd list(FP) 삭제
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceN3rd02(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceN3rd(event.getTesTmlSoHdrVO(), "SP");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Invoice Auto Calculation TMNL Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYAutoCalcTMNL(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(), "TM");
			dbDao.removeOffdockCYInvoiceAutoCalcData(event.getTesTmlSoHdrVO(), "TM");			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Auto Calculation By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYAutoCalcByDay(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(), "SD");
			dbDao.removeOffdockCYInvoiceAutoCalcData(event.getTesTmlSoHdrVO(), "SD");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * OffDock CY Auto Calculation By Pool List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYAutoCalcByPool(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			dbDao.removeOffdockCYInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(), "SP");
			dbDao.removeOffdockCYInvoiceAutoCalcData(event.getTesTmlSoHdrVO(), "SP");
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - Container List Insert
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createOffdockCYInvoiceContainerList(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;
		
		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
		
		Map<String, String> etcMap = new HashMap<String, String>();

		try {
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );	
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();		
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE : "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq((String.valueOf(++ins_idx)));
					
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					updateVOList.add(tesTmlSoCntrListVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceContainerListInsert(insertVOList, etcMap);
			} 
			
			if ( updateVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceContainerListUpdate(updateVOList, etcMap);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolume(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		
		try {
						
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolume >> tesTmlSoCntrListVOs.length >> "+tesTmlSoCntrListVOs.length);
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++ ){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolume >> sIbFlag >> "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					
					tesTmlSoCntrListVOs[i].setCntrTpszCd(event.getOffdockCYInvoiceManageVO().getParamCntrTpszCd());
					tesTmlSoCntrListVOs[i].setDcgoClssCd(event.getOffdockCYInvoiceManageVO().getDcgoClssCd());
					tesTmlSoCntrListVOs[i].setRcFlg(event.getOffdockCYInvoiceManageVO().getRcFlg());
					                    	
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoCntrListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		
		try {
						
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeForTMRFMO >> tesTmlSoCntrListVOs.length >> "+tesTmlSoCntrListVOs.length);
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++ ){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeForTMRFMO >> sIbFlag >> "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					
					tesTmlSoCntrListVOs[i].setCntrTpszCd(event.getOffdockCYInvoiceManageVO().getParamCntrTpszCd());
					tesTmlSoCntrListVOs[i].setDcgoClssCd(event.getOffdockCYInvoiceManageVO().getDcgoClssCd());
					tesTmlSoCntrListVOs[i].setRcFlg(event.getOffdockCYInvoiceManageVO().getRcFlg());
					                    	
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoCntrListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeM(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;

		try {

			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoRvisListVOs = event.getTesTmlSoRvisListVOs();
			
			List<TesTmlSoRvisListVO> insertVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updateVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> deleteVOList = new ArrayList<TesTmlSoRvisListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeM >> tesTmlSoRvisListVOs.length >> "+tesTmlSoRvisListVOs.length);
			
			for( int i=0; tesTmlSoRvisListVOs!=null && i<tesTmlSoRvisListVOs.length; i++ ){
				sIbFlag = tesTmlSoRvisListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeM >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoRvisListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoRvisListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_RVIS_LIST", "TML_SO_RVIS_LIST_SEQ");
					
					tesTmlSoRvisListVOs[i].setTmlSoRvisListSeq(String.valueOf(++ins_idx));
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk()); 
					insertVOList.add(tesTmlSoRvisListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());   				
					
					updateVOList.add(tesTmlSoRvisListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoRvisListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeMForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;

		try {

			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoRvisListVOs = event.getTesTmlSoRvisListVOs();
			
			List<TesTmlSoRvisListVO> insertVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updateVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> deleteVOList = new ArrayList<TesTmlSoRvisListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeMForTMRFMO >> tesTmlSoRvisListVOs.length >> "+tesTmlSoRvisListVOs.length);
			
			for( int i=0; tesTmlSoRvisListVOs!=null && i<tesTmlSoRvisListVOs.length; i++ ){
				sIbFlag = tesTmlSoRvisListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeMForTMRFMO >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoRvisListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoRvisListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_RVIS_LIST", "TML_SO_RVIS_LIST_SEQ");
					
					tesTmlSoRvisListVOs[i].setTmlSoRvisListSeq(String.valueOf(++ins_idx));
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk()); 
					insertVOList.add(tesTmlSoRvisListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());   				
					
					updateVOList.add(tesTmlSoRvisListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoRvisListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Revise Calculated Volume Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;

		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeSeparate >> tesTmlSoCntrListVOs.length >> "+tesTmlSoCntrListVOs.length);
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++ ){
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeSeparate >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(String.valueOf(++ins_idx));
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());  									
					updateVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "D".equals(sIbFlag) ) {		//delete
					
					tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());  						
					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revise Calculated Volume Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiReviseCalculatedVolumeSeparateM(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		int ins_idx = 0;
		String sIbFlag = "";

		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;

		try {
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoRvisListVOs = event.getTesTmlSoRvisListVOs();
			
			List<TesTmlSoRvisListVO> insertVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> updateVOList = new ArrayList<TesTmlSoRvisListVO>();
			List<TesTmlSoRvisListVO> deleteVOList = new ArrayList<TesTmlSoRvisListVO>();
			
			Map<String, String> etcMap = new HashMap<String,String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );		
			
			log.debug("at BC.multiReviseCalculatedVolumeSeparateM >> tesTmlSoRvisListVOs.length >> "+tesTmlSoRvisListVOs.length);
			
			for( int i=0; tesTmlSoRvisListVOs!=null && i<tesTmlSoRvisListVOs.length; i++ ){
				sIbFlag = tesTmlSoRvisListVOs[i].getIbflag();
				
				log.debug("at BC.multiReviseCalculatedVolumeSeparateM >> sIbFlag >> "+sIbFlag);   				
				
				tesTmlSoRvisListVOs[i].setTmlSoOfcCtyCd( tesTmlSoHdrVO.getTmlSoOfcCtyCd() );
				tesTmlSoRvisListVOs[i].setTmlSoSeq( tesTmlSoHdrVO.getTmlSoSeq() );
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_RVIS_LIST", "TML_SO_RVIS_LIST_SEQ");
					
					tesTmlSoRvisListVOs[i].setTmlSoRvisListSeq(String.valueOf(++ins_idx));
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());					                    	
					insertVOList.add(tesTmlSoRvisListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update		
					
					tesTmlSoRvisListVOs[i].setTmlInvTpCd(tesTmlSoHdrVO.getTmlInvTpCd());
					tesTmlSoRvisListVOs[i].setCalcCostGrpCd(tesTmlSoHdrVO.getTmlCostGrpCd());
					tesTmlSoRvisListVOs[i].setRvisIndFlg(event.getTesTmlSoCntrListVOs()[i].getTmlRvisIndFlg());
					
					tesTmlSoRvisListVOs[i].setRvisRmk(event.getTesTmlSoCntrListVOs()[i].getCntrRmk());   				
					
					updateVOList.add(tesTmlSoRvisListVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoRvisListVOs[i]);
				}					
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMInsert(insertVOList, etcMap);
			}
			if ( updateVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMUpdate(updateVOList, etcMap);
			}
			if ( deleteVOList.size() > 0 ) {
				dbDao.multiRevCalcVolContainerListMDelete(deleteVOList, etcMap);
			}			
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
	}

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCount(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		try {
			
			tesTmlSoCntrListVO = event.getTesTmlSoCntrListVO();
			
			String sIbFlag = tesTmlSoCntrListVO.getIbflag();
			
			if ( "U".equals(sIbFlag) ) 
				dbDao.recalculateRevisedVolumeCount( tesTmlSoCntrListVO, event.getOffdockCYInvoiceManageVO() );
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event) e;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		try {
			
			tesTmlSoCntrListVO = event.getTesTmlSoCntrListVO();
			
			String sIbFlag = tesTmlSoCntrListVO.getIbflag();
			
			if ( "U".equals(sIbFlag) ) 
				dbDao.recalculateRevisedVolumeCount( tesTmlSoCntrListVO, event.getOffdockCYInvoiceManageVO() );
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountM(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountM( event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountMForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountM( event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountSeparate(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountSeparateM(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		try {
			dbDao.recalculateRevisedVolumeCountSeparateM(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Cost Amount
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateOffdocCYInvoiceCostAmount(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;

		try {
			
			tesTmlSoCntrListVO = event.getTesTmlSoCntrListVO();
			
			String sIbFlag = tesTmlSoCntrListVO.getIbflag();
			
			if ( "U".equals(sIbFlag) ) {	
				dbDao.recalculateOffdocCYInvoiceCostAmount( tesTmlSoCntrListVO, event.getOffdockCYInvoiceManageVO() );
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Recalculated OffDock Invoice Cost Amount
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateOffdocCYInvoiceCostAmountForTMRFMO(Event e) throws EventException {

		EsdTes9034Event event = (EsdTes9034Event) e;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;

		try {
			
			tesTmlSoCntrListVO = event.getTesTmlSoCntrListVO();
			
			String sIbFlag = tesTmlSoCntrListVO.getIbflag();
			
			if ( "U".equals(sIbFlag) ) {	
				dbDao.recalculateOffdocCYInvoiceCostAmount( tesTmlSoCntrListVO, event.getOffdockCYInvoiceManageVO() );
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Recalculated OffDock Invoice Cost Amount Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateOffdocCYInvoiceCostAmountSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		try {
			dbDao.recalculateOffdocCYInvoiceCostAmount(event.getTesTmlSoCntrListVO(), event.getOffdockCYInvoiceManageVO());
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - Cost Calculation(Detail) List Insert
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createOffdockCYInvoiceDetail(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;
		
		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoDtlVO[] tesTmlSoDtlVOs = null;
		
		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoDtlVOs = event.getTesTmlSoDtlVOs();
			
			List<TesTmlSoDtlVO> insertVOList = new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> updateVOList = new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> deleteVOList = new ArrayList<TesTmlSoDtlVO>();
			
			Map<String, String> etcMap = new HashMap<String, String>();
			
			etcMap.put( "ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			etcMap.put( "usr_id", event.getSignOnUserAccount().getUsr_id() );			

			// TES CSR I/F의 "AGMNT LINK"에 대해 Link되어있는 모든 계약서 load (4347-11-27)
			etcMap.put( "yd_cd", event.getTesTmlSoHdrVO().getYdCd() );			
			etcMap.put( "vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );	
			
			// [CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 (2016-02-16)
			etcMap.put( "to_prd_dt", event.getTesTmlSoHdrVO().getToPrdDt() );	
			
			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++){
				
				sIbFlag = tesTmlSoDtlVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoDtlVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesTmlSoDtlVOs[i].setCalcRmk( TESUtil.convertText(tesTmlSoDtlVOs[i].getCalcRmk()) );
				
				if("S".equals(tesTmlSoDtlVOs[i].getCalcTpCd())){
					tesTmlSoDtlVOs[i].setCalcTpCd("M");
				}
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_DTL", "TML_SO_DTL_SEQ");
					tesTmlSoDtlVOs[i].setTmlSoDtlSeq((String.valueOf(++ins_idx)));

					insertVOList.add(tesTmlSoDtlVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoDtlVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoDtlVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceDetailInsert(insertVOList, etcMap);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceDetailUpdate(updateVOList, etcMap);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.createOffdockCYInvoiceDetailDeleteN3rd(deleteVOList, etcMap);
				dbDao.createOffdockCYInvoiceDetailDeleteRvis(deleteVOList, etcMap);
				dbDao.createOffdockCYInvoiceDetailDeleteDtl(deleteVOList, etcMap);
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/** Moon. Off-duck CY Container List - 시작 * */
	/**
	 * OffDock CY Invoice Basic(Header) Info Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceBasicInfoInquiry(Event e) throws EventException {
		EsdTes0018Event event = (EsdTes0018Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		try {
			eventResponse.setRs(dbDao.searchOffdockCYInvoiceBasicInfo(event.getTesTmlSoHdrVO()));
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}


	/**
	 * OffDock CY Invoice All Data Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdockCYInvoiceAllSheetsInquiry(Event e) throws EventException {

		log.debug("\n\n BC.searchOffdockCYInvoiceAllSheetsInquiry() - @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		
		EsdTes0018Event event = (EsdTes0018Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		String tml_cost_grp_cd = "";	
		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {

			tml_cost_grp_cd = (String)event.getOffdockCYInvoiceManageVO().getTmlCostGrpCd();
			log.debug("\n - tml_cost_grp_cd:" + tml_cost_grp_cd + " -------\n");

			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "CO"));
			rsList.add(dbDao.searchOffdockCYContainerList(event.getTesTmlSoHdrVO(), "DC"));
					
			if (tml_cost_grp_cd != null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length() == 2) {
				if (tml_cost_grp_cd.substring(0, 1).equals("T")) {
					rsList.add(dbDao.searchCalcCostTMNLList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}

				if (tml_cost_grp_cd.substring(1, 2).equals("D")) {
					rsList.add(dbDao.searchCalcCostByDayList(event.getTesTmlSoHdrVO()));
				}
				else {
					rsList.add( new DBRowSet());
				}
				
				rsList.add(dbDao.searchCalcCostByPoolList(event.getTesTmlSoHdrVO()));				
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );
				
				return eventResponse;
			} else {
				return null;
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}			
	}

	/**
	 * OffDock CY Invoice 3rd Party Insert, Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOffdock3rdIFlist(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event) e;
		int ins_idx = 0;
		String sIbFlag = "";
		
		String sOfcCd = event.getSignOnUserAccount().getOfc_cd();
		String sUserId = event.getSignOnUserAccount().getUsr_id();
		
		log.debug("sOfcCd : "+sOfcCd+", sUserID : "+sUserId);
		
		OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
		OffdockCYInvoiceManageVO[] offdockCYInvoiceManageVOs = null;
		TesN3rdPtyIfVO tesN3rdPtyIfVO = null;
		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		
		try {
			offdockCYInvoiceManageVO = event.getOffdockCYInvoiceManageVO();
			offdockCYInvoiceManageVOs = event.getOffdockCYInvoiceManageVOs();
			tesN3rdPtyIfVO = event.getTesN3rdPtyIfVO();
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
			
			List<TesN3rdPtyIfVO> insertVOList = new ArrayList<TesN3rdPtyIfVO>();
			List<OffdockCYInvoiceManageVO> updateCNTRVOList = new ArrayList<OffdockCYInvoiceManageVO>();		// 	Update TES_TML_SO_CNTR_LIST (자동 계산 수정 ) 
			
			List<TesN3rdPtyIfVO> updateVOList = new ArrayList<TesN3rdPtyIfVO>();
			
			List<TesN3rdPtyIfVO> deleteVOList = new ArrayList<TesN3rdPtyIfVO>();
			
			List<TesN3rdPtyIfVO> deleteTPBVOList = new ArrayList<TesN3rdPtyIfVO>();
			
			for( int i=0; tesN3rdPtyIfVOs!=null && i<tesN3rdPtyIfVOs.length; i++){
				
				sIbFlag = tesN3rdPtyIfVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0)ins_idx = dbDao.searchOffdockCYN3rdTableMaxSeq(sOfcCd);
					
					tesN3rdPtyIfVOs[i].setTmlIfOfcCd(sOfcCd);
					tesN3rdPtyIfVOs[i].setTmlIfSeq(String.valueOf(++ins_idx));
					tesN3rdPtyIfVOs[i].setTmlN3ptyIfStsCd("N");
					tesN3rdPtyIfVOs[i].setCalcCostGrpCd( JSPUtil.getNull(tesN3rdPtyIfVO.getCalcCostGrpCd()) );					
					tesN3rdPtyIfVOs[i].setTmlInvTpCd( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlInvTpCd()) );
					tesN3rdPtyIfVOs[i].setInvNo( JSPUtil.getNull(tesN3rdPtyIfVO.getInvNo()) );
					tesN3rdPtyIfVOs[i].setVndrSeq( JSPUtil.getNull(tesN3rdPtyIfVO.getVndrSeq()) );
					tesN3rdPtyIfVOs[i].setYdCd( JSPUtil.getNull(tesN3rdPtyIfVO.getYdCd()) );					
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlSoOfcCtyCd()) );
					tesN3rdPtyIfVOs[i].setTmlSoSeq( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlSoSeq()) );
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq( JSPUtil.getNull(tesN3rdPtyIfVO.getTmlSoDtlSeq()) );					
					tesN3rdPtyIfVOs[i].setCurrCd( JSPUtil.getNull(tesN3rdPtyIfVO.getCurrCd()) );
					tesN3rdPtyIfVOs[i].setCxlFlg("N");
					
					tesN3rdPtyIfVOs[i].setCreUsrId(sUserId);
					tesN3rdPtyIfVOs[i].setUpdUsrId(sUserId);
					tesN3rdPtyIfVOs[i].setLoclCreDt(sOfcCd);
					tesN3rdPtyIfVOs[i].setLoclUpdDt(sOfcCd);
					
					insertVOList.add(tesN3rdPtyIfVOs[i]);
					
					//Auto
					
					log.debug("ibflag : I ==> "+offdockCYInvoiceManageVO.getCalcTpCd()+", "+offdockCYInvoiceManageVO.getTmlSoCntrListSeq());
					
					if( offdockCYInvoiceManageVO.getCalcTpCd()!=null && "A".equals(offdockCYInvoiceManageVO.getCalcTpCd()) && 
						offdockCYInvoiceManageVO.getTmlSoCntrListSeq()!=null && !"".equals(offdockCYInvoiceManageVO.getTmlSoCntrListSeq().trim()) ){ 
						
						offdockCYInvoiceManageVOs[i].setTmlIfSeq( String.valueOf(ins_idx) );
						offdockCYInvoiceManageVOs[i].setTmlSoOfcCtyCd(offdockCYInvoiceManageVO.getTmlSoOfcCtyCd());
						offdockCYInvoiceManageVOs[i].setTmlSoSeq(offdockCYInvoiceManageVO.getTmlSoSeq());
						
						updateCNTRVOList.add(offdockCYInvoiceManageVOs[i]); 
					}
					
				} else if( "U".equals(sIbFlag) ) {		//update	
					tesN3rdPtyIfVOs[i].setCurrCd( tesN3rdPtyIfVO.getCurrCd() );
					tesN3rdPtyIfVOs[i].setUpdUsrId(sUserId);
					tesN3rdPtyIfVOs[i].setLoclUpdDt(sOfcCd);		
					tesN3rdPtyIfVOs[i].setErrInvNo("");
					updateVOList.add(tesN3rdPtyIfVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete					
					deleteVOList.add(tesN3rdPtyIfVOs[i]);
				}
							
			}
			
			String	delIfSeq	= JSPUtil.getNull( offdockCYInvoiceManageVO.getDelIfSeq() );
			String	delCntrSeq	= JSPUtil.getNull( offdockCYInvoiceManageVO.getDelCntrSeq() );

			log.debug(">>>>>>>>>>>>>>> delIfSeq : "+delIfSeq+", delCntrSeq : "+delCntrSeq);
			
			//[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
			if ( delIfSeq != null && !delIfSeq.trim().equals("") ) {
				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrIfSeq	= delIfSeq.split("\\|");
				
				delCntrSeq	= delCntrSeq.substring( 0, delCntrSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrCntrSeq	= delCntrSeq.split("\\|");
				TesN3rdPtyIfVO[] tpbVOs = new TesN3rdPtyIfVO[arrIfSeq.length];
				OffdockCYInvoiceManageVO[] offdockVOs = new OffdockCYInvoiceManageVO[arrIfSeq.length];
				
				updateCNTRVOList = new ArrayList<OffdockCYInvoiceManageVO>();
				
				for ( int j = 0; j < arrIfSeq.length; j++ ) {

					tpbVOs[j] = new TesN3rdPtyIfVO();					       
					tpbVOs[j].setTmlIfOfcCd(sOfcCd);
					tpbVOs[j].setTmlIfSeq(arrIfSeq[j]);
					tpbVOs[j].setTmlSoOfcCtyCd( offdockCYInvoiceManageVO.getTmlSoOfcCtyCd() );
					tpbVOs[j].setTmlSoSeq( offdockCYInvoiceManageVO.getTmlSoSeq() );
					tpbVOs[j].setTmlSoDtlSeq( offdockCYInvoiceManageVO.getTmlSoDtlSeq() );					
					deleteTPBVOList.add(tpbVOs[j]);
					
					offdockVOs[j] = new OffdockCYInvoiceManageVO();
					offdockVOs[j].setTmlIfSeq("");
					offdockVOs[j].setTmlSoOfcCtyCd(offdockCYInvoiceManageVO.getTmlSoOfcCtyCd());
					offdockVOs[j].setTmlSoSeq(offdockCYInvoiceManageVO.getTmlSoSeq());
					offdockVOs[j].setTmlSoCntrListSeq((arrCntrSeq!=null&&arrCntrSeq.length>0&&j<arrCntrSeq.length?(arrCntrSeq[j]!=null?arrCntrSeq[j]:""):""));
					
					updateCNTRVOList.add(offdockVOs[j]);
					
				}
				
			}

			if ( deleteTPBVOList.size() > 0 ) {

				dbDao.multiOffdock3rdIFlistNewTPBDelete(deleteTPBVOList);
				
				int iCnt = dbDao.updateOffdockDetailN3rdFlagSearch(offdockCYInvoiceManageVO);
				
				log.debug("updateOffdockDetailN3rdFlagSearch result is "+iCnt);
				
				if( iCnt < 1 ) {
					offdockCYInvoiceManageVO.setN3ptyFlg("");
					dbDao.updateOffdockDetailN3rdFlag(offdockCYInvoiceManageVO);
				}

			}
			
			if ( updateCNTRVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewCNTRUpdate(updateCNTRVOList);
			}	
			
			log.debug(">>>>>>>>>>>>>>>>>>> insertVOList.size() "+insertVOList.size());
			if ( insertVOList.size() > 0 ) {
				/*
				 * 1. insert into TES_N3RD_PTY_IF (insertVOList)
				 * 2. Update TES_TML_SO_CNTR_LIST (updateCNTRVOList)
				 * 3. Update TES_TML_SO_DTL DTL - (OffdockCYInvoiceManageVO)
				 */				
				
				dbDao.multiOffdock3rdIFlistNewInsert(insertVOList);
				dbDao.multiOffdock3rdIFlistNewCNTRUpdate(updateCNTRVOList);
				
				offdockCYInvoiceManageVO.setN3ptyFlg("Y");
				dbDao.multiOffdock3rdIFlistNewDTLUpdate(offdockCYInvoiceManageVO);
				dbDao.updateOffdockDetailN3rdFlag(offdockCYInvoiceManageVO);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewUpdate(updateVOList);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.multiOffdock3rdIFlistNewDelete(deleteVOList);
			}				
			
			return null;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err Exception de" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/** Moon. Off-duck CY Container List - 끝 * */

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * OffdockCYInvoiceManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
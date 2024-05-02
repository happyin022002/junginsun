/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageBCImpl.java
*@FileTitle : Marine Terminal Strorage Invoice관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-09
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-27 byungheeyoo
* 1.0 최초 생성
 * 2009-05-29 [N200905280100]   : TPB I/F 누락 방지 추가
 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
 * 2011.08.08 윤태승 [CHM-201111829-1] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
 * 2015-03-24 : 김영신 [CHM-201534788]GW Agmt Link 기준 변경 (SAve->Confirm) 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.tescommon.util.TESUtil;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0019Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9142Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9152Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9234Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9254Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration.MarineTerminalStorageInvoiceManageDBDAO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
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


/**
 * ENIS-ESD Business Logic Basic Command implementation<br>
 * - ENIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author byungheeyoo
 * @see ESD_TES_009EventResponse,MarineTerminalStorageInvoiceManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MarineTerminalStorageInvoiceManageBCImpl   extends BasicCommandSupport implements MarineTerminalStorageInvoiceManageBC {

	// Database Access Object
	private transient MarineTerminalStorageInvoiceManageDBDAO dbDao=null;
	
	/**
	 * MarineTerminalStorageInvoiceManageBCImpl 객체 생성<br>
	 * MarineTerminalStorageInvoiceManageDBDAO를 생성한다.<br>
	 */
	public MarineTerminalStorageInvoiceManageBCImpl(){
		dbDao = new MarineTerminalStorageInvoiceManageDBDAO();
	}

	
	/** YOO - 시작 **/
	
	/**
	 * storage invoice header정보 조회
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse searchStorageInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		try {
			eventResponse.setRs( dbDao.searchStorageInvoiceBasicInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 * reject 정보 조회
	 * @param  e Event
	 * @return EventResponse
	 */
	public EventResponse searchStorageInvoiceRejectInfo(Event e) throws EventException {

		log.debug("\n\n BC.searchStorageInvoiceRejectInfo \n");
		
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		
		try {
			eventResponse.setRs( dbDao.searchStorageInvoiceRejectInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
			
		} catch (DAOException de) {	
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * container 목록 제거
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceContainerList(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceContainerList(event.getTesTmlSoHdrVO());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * detail 목록 제거 ByDay
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceDetailByDay(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * detail 목록 제거 ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceDetailByPool(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * detail 목록 제거 ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceN3rd01(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceN3rd(event.getTesTmlSoHdrVO(),"SD");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * detail 목록 제거 ByPool 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageInvoiceN3rd02(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceN3rd(event.getTesTmlSoHdrVO(),"SP");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  detail 목록 제거 ByDay 자동 계산 부분만
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageAutoCalcByDay(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeStorageInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(),"SD");
			dbDao.removeStorageInvoiceAutoCalcData(event.getTesTmlSoHdrVO(),"SD");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 *  detail 목록 제거 ByPool 자동 계산 부분만
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeStorageAutoCalcByPool(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			dbDao.removeStorageInvoiceAutoCalcDataN3rd(event.getTesTmlSoHdrVO(),"SP");
			dbDao.removeStorageInvoiceAutoCalcData(event.getTesTmlSoHdrVO(),"SP");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Storage Container 목록 구하기
	 * @param Event e
	 * @return EventResponse 
	 */
	public EventResponse searchStorageContainerList(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageContainerList\n");
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 
		
		try {
//			dbDao.searchStorageContainerList(event.getTES_TML_SO_HDR(),"CO");
//			dbDao.searchStorageContainerList(event.getTES_TML_SO_HDR(),"DC");
			
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"CO") );
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"DC") );

			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  Storage detail 목록 구하기 
	 * @param Event e
	 * @return EventResponse
	 */	
	public EventResponse searchStorageInvoiceDetail(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageInvoiceDetail\n");
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		
		String tml_cost_grp_cd = "";
		String dtl_by_day_only_mode = "";
		String dtl_by_pool_only_mode = "";
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 
		
		try {
			log.debug(" BC.searchStorageInvoiceDetail formCommand - "+event.getFormCommand().getCommand() + "<<<<<<<<<<<<<<<<<<<<");
			tml_cost_grp_cd = event.getTesTmlSoHdrVO().getTmlCostGrpCd();
			dtl_by_day_only_mode = event.getMarineTerminalStorageInvoiceManageVO().getDtlByDayOnlyMode();
			dtl_by_pool_only_mode = event.getMarineTerminalStorageInvoiceManageVO().getDtlByPoolOnlyMode();
			
			if (tml_cost_grp_cd!=null && !tml_cost_grp_cd.equals("") && tml_cost_grp_cd.length()==2){
				log.debug(" BC.tml_cost_grp_cd - "+tml_cost_grp_cd.substring(0,1) + " / " + tml_cost_grp_cd.substring(1,2) + "<<<<<<<<<<<<<<<<<<<<<");
				log.debug(" BC.dtl_by_pool_only_mode - "+dtl_by_pool_only_mode + "<<<<<<<<<<<<<<<<<<<<<");
				if (dtl_by_day_only_mode!=null && dtl_by_day_only_mode.equals("Y")){
					log.debug("DDDDDDDDDDDDDD");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); //ByDay
				} else if (dtl_by_pool_only_mode!=null && dtl_by_pool_only_mode.equals("Y")){
					log.debug("PPPPPPPPPPPPP");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); //ByPool
				} else {
					log.debug("DDDDDDDDDDDDDD");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); //ByDay
					log.debug("PPPPPPPPPPPPP");
					rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); //ByPool
				}
				
				eventResponse.setRsList(rsList);
				eventResponse.setETCData( "successFlag", "SUCCESS" );	
				
				return eventResponse;
				
			} else {
				return eventResponse;
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *  화면의 조회시 sheet 목록 구하기 
	 * @param Event e
	 * @return EventResponse
	 */	
	public EventResponse searchStorageInvoiceAllSheets(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageInvoiceAllSheets\n");
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 
		try {
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"CO") ); //COINCIDENCE
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"DC") ); //DISCREPANCY
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); //ByDay
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); //ByPool
			
			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * storage header정보 생성/수정/삭제
	 * @param Event e
	 * @return EventResponse
	 */
	@SuppressWarnings("unchecked")
	public EventResponse createStorageInvoiceBasicInfo(Event e) throws EventException {
		EsdTes0009Event event=(EsdTes0009Event)e;
//		String return_flag = "N";
		DBRowSet rowSet = null;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			rowSet = dbDao.searchStorageInvoiceBasicInfo(event.getTesTmlSoHdrVO());
			if (rowSet.getRowCount()> 0){ //중복 확인
//				throw new DAOException("이미 등록된 header정보 입니다.");
				throw new DAOException(new ErrorHandler("TES00097").getMessage());

			}			

			/**
			 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
			 */
			java.util.HashMap hm = new java.util.HashMap();
			hm.put("vndr_seq",event.getTesTmlSoHdrVO().getVndrSeq());
			hm.put("inv_no",event.getTesTmlSoHdrVO().getInvNo());
			new TESInvoiceCommonBCImpl().checkEDIInvoiceDup(hm);
			
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
			tesTmlSoHdrVO.setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclCreDt( event.getSignOnUserAccount().getOfc_cd() );
			
			dbDao.createStorageInvoiceBasicInfo( tesTmlSoHdrVO );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 계산하기 ByDay
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse calStorageInvoiceCost(Event e) throws EventException {
		log.debug("\n\nBC.calStorageInvoiceCost\n");
		EsdTes0009Event event=(EsdTes0009Event)e;		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		try {
			eventResponse.setRs( dbDao.calStorageInvoiceCost(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );		
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}		
	}
	
	/**
	 * verify시 임시 data생성  
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9142Event event=(EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

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
				
				if(ins_idx == 0)ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_FILE_IMP_TMP", "TML_SO_TMP_SEQ");
				
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
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());			
		}

//		try {
//			dbDao.createTES_FILE_IMP_TMP(event.getTES_TML_SO_HDR(), event.getTES_TML_SO_CNTR_LISTS(), event.getParams());
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}

	/**
	 * verify시 임시 data제거  
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9142Event event=(EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Offdock 화면에 대한 조회 이벤트 처리<br>
	 * 사용안함
	 * @param e EsdTes9142Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException {

		EsdTes9142Event event = (EsdTes9142Event)e;
		@SuppressWarnings("unused")
		DBRowSet rowSet = null;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			rowSet = dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO());
			//return new ESD_TES_9142EventResponse(rowSet,"SUCCESS");
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * Offdock 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event)e;
		DBRowSet rowSet = null;
		TesFileImpTmpVO tesFileImpTmpVO = null;
		List<TesFileImpTmpVO> voList = new ArrayList<TesFileImpTmpVO>();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			rowSet = dbDao.searchCNTRNumber(event.getTesTmlSoHdrVO());
			//tesFileImpTmpVO = event.getTesFileImpTmpVO();
			
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
			return eventResponse;
			
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
	 * 조회 이벤트 처리<br>
	 * EDI로 받은 CNTR목록 조회 - eBilling
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerList(Event e) throws EventException {
		
		EsdTes9142Event event = (EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchEDIStorageInvoiceContainerList(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	
	
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EDI로 받은 FreePool CNTR목록 조회 - eBilling
	 *
	 * @param e EsdTes9152Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerListFreePool(Event e) throws EventException {

		log.debug("\n\n BCimpl.searchEDIStorageInvoiceContainerListFreePool ----------------------------- \n");
		
		EsdTes9152Event event = (EsdTes9152Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

		try {
			eventResponse.setRs( dbDao.searchEDIStorageInvoiceContainerListFreePool(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Offdock 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9142Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event)e;
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
	 * Storage verify하기 ByDay
	 * 
	 * @param Event e
	 * @return EventResponse
	 */
	public EventResponse verifyStorageInvoiceVolumne(Event e) throws EventException {
		log.debug("\n\nBC.verifyStorageInvoiceVolumne ------------- \n");
		EsdTes9142Event event=(EsdTes9142Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.verifyStorageInvoiceVolumne(event.getTesTmlSoHdrVO()) );
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}

//	/**
//	 * verify시 임시 data생성  
//	 */
//	public int insertStorageInvoiceContainerList(Event e) throws EventException {
//		EsdTes9142Event event=(EsdTes9142Event)e;
//		int insCnt = 0;
//		
//		try {
//			insCnt = dbDao.insertStorageInvoiceContainerList(event.getTES_TML_SO_HDR(),
//					   event.getRowSet(),
//					   event.getSignOnUserAccount().getUsr_id(),
//					   event.getSignOnUserAccount().getOfc_cd());
//			return insCnt;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/** 컨테이너 조회
	 *  @param Event e
	 *  @return int
	 *  @throws EventException
	 */
	public int insertStorageInvoiceContainerList(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event) e;
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
			
			//rowSet = dbDao.verifyStorageInvoiceVolumne(event.getTesTmlSoHdrVO());
			rowSet = event.getRowSet();
				
			if (rowSet != null){
				if(ins_idx == 0)ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
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
					tesTmlSoCntrListVO.setCreUsrId(strUsrId);
					tesTmlSoCntrListVO.setUpdUsrId(strUsrId);
					tesTmlSoCntrListVO.setLoclCreDt(strOfcCd);
					tesTmlSoCntrListVO.setLoclUpdDt(strOfcCd);
					
					voList.add(tesTmlSoCntrListVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				//삭제 후 삽입
				dbDao.removeStorageInvoiceContainerList(tesTmlSoHdrVO);
				insCnt = dbDao.insertStorageInvoiceContainerList(voList);
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
	 * ByPool verify시 임시 data생성  
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */	
	public EventResponse createTES_FILE_IMP_TMPByPool(Event e) throws EventException {
		EsdTes9152Event event=(EsdTes9152Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();

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
				
				if(ins_idx == 0)ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_FILE_IMP_TMP", "TML_SO_TMP_SEQ");
				
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
				dbDao.createTES_FILE_IMP_TMPByPool(insertVOList);
			}
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());			
		}

	}	
//	public EventResponse createTES_FILE_IMP_TMPByPool(Event e) throws EventException {
//		EsdTes9152Event event=(EsdTes9152Event)e;
//
//		try {
//			dbDao.createTES_FILE_IMP_TMPByPool(event.getTES_TML_SO_HDR(), event.getTES_TML_SO_DTLS(), event.getParams());
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * ByPool verify시 임시 data제거  
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMPByPool(Event e) throws EventException {
		EsdTes9152Event event=(EsdTes9152Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.removeTES_FILE_IMP_TMP(event.getTesTmlSoHdrVO());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Storage verify하기 ByPool
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse verifyStorageInvoiceCostByPool(Event e) throws EventException {
		EsdTes9152Event event = (EsdTes9152Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.verifyStorageInvoiceCostByPool(event.getTesTmlSoHdrVO(), event.getMode()) );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * verify시 임시 data생성  
	 *  @param Event e
	 *  @return int
	 *  @throws EventException
	 */
	public int insertStorageInvoiceDetail(Event e) throws EventException {
		EsdTes9152Event event=(EsdTes9152Event)e;
		DBRowSet rowSet = null;
		int insCnt = 0;
		
		TesTmlSoDtlVO tesTmlSoDtlVO = null;
		List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();
		
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
				if(ins_idx == 0)ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
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
					tesTmlSoDtlVO.setCtrtRt(rowSet.getString("CTRT_RT"));
					tesTmlSoDtlVO.setCalcAmt(rowSet.getString("CALC_AMT"));
					tesTmlSoDtlVO.setInvAmt(rowSet.getString("INV_AMT"));
					tesTmlSoDtlVO.setTmlAgmtOfcCtyCd(rowSet.getString("TML_AGMT_OFC_CTY_CD"));
					tesTmlSoDtlVO.setTmlAgmtSeq(rowSet.getString("TML_AGMT_SEQ"));
					tesTmlSoDtlVO.setTmlAgmtVerNo(rowSet.getString("TML_AGMT_VER_NO"));
					tesTmlSoDtlVO.setCurrCd(rowSet.getString("CURR_CD"));
					tesTmlSoDtlVO.setInvXchRt(rowSet.getString("INV_XCH_RT"));
					tesTmlSoDtlVO.setVolTrUtCd(rowSet.getString("VOL_TR_UT_CD"));
					tesTmlSoDtlVO.setCreUsrId(strUsrId);
					tesTmlSoDtlVO.setUpdUsrId(strUsrId);
					tesTmlSoDtlVO.setLoclCreDt(strOfcCd);
					tesTmlSoDtlVO.setLoclUpdDt(strOfcCd);
					
					voList.add(tesTmlSoDtlVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				//dbDao.removeStorageInvoiceContainerList(tesTmlSoHdrVO);
				insCnt = dbDao.insertStorageInvoiceDetail(voList);
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
//		int insCnt = 0;
//		
//		try {
//			insCnt = dbDao.insertStorageInvoiceDetail(event.getTES_TML_SO_HDR(),
//					   event.getRowSet(),
//					   event.getSignOnUserAccount().getUsr_id(),
//					   event.getSignOnUserAccount().getOfc_cd());
//			return insCnt;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}
	
	/**
	 * storage invoice 수정하기
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse modifyStorageInvoice(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
			
			dbDao.modifyStorageInvoice( tesTmlSoHdrVO );
			//dbDao.modifyStorageInvoice(event.getTES_TML_SO_HDR(),event.getSignOnUserAccount().getUsr_id(),event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * confirm 내역 수정
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse modifyStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n\nBC.modifyStorageInvoiceConfirm\n");	
		EsdTes0009Event event=(EsdTes0009Event)e;
		String chkAmt = "";
		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TESInvoiceCommonBC	invCom	= new TESInvoiceCommonBCImpl();
			
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );	
			
			chkAmt = dbDao.checkSOInvAmt(tesTmlSoHdrVO);
			log.error("\n DONE - modifyStorageInvoiceConfirm.checkInvAmt:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			if (chkAmt==null || (chkAmt!=null && !chkAmt.equals("Y"))){
//				throw new DAOException("\n\n Invoice header amout don't match invoice detail amount. \n\n Please, contact COL.");
				throw new DAOException(new ErrorHandler("TES00088").getMessage());
			}
			// TPB I/F N3PTY_FLG 누락 방지 ( 2009-06-03 ) 
			// 1. SO_DTL N3PTY_FLG 값 check 
			//invCom.checkDetailTpb(event.getTES_TML_SO_HDR().getTml_so_ofc_cty_cd(), event.getTES_TML_SO_HDR().getTml_so_seq() );			
			invCom.checkDetailTpb(tesTmlSoHdrVO);
			
			// 2. check결과 업데이트
			dbDao.modifyStorageInvoiceConfirm(tesTmlSoHdrVO);
						
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * confirm 취소
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse cancelStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n\nBC.modifyStorageInvoiceConfirm\n");	
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
			
			dbDao.cancelStorageInvoiceConfirm(tesTmlSoHdrVO);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * account code update 하기
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse updateStorageAccountCode(Event e) throws EventException {
		log.debug("\n\nBC.updateStorageAccountCode\n");	
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		DBRowSet rowSet = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;
		List<TesTmlSoDtlVO> voList = new ArrayList<TesTmlSoDtlVO>();
		
		try {
			rowSet = dbDao.searchStorageAccountCode(event.getTesTmlSoHdrVO());
			
			if (rowSet != null){
				while (rowSet.next()){
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setAcctCd( rowSet.getString("acct_cd") );
					tesTmlSoDtlVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
					tesTmlSoDtlVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );
					tesTmlSoDtlVO.setLgsCostCd( rowSet.getString("lgs_cost_cd") );
					tesTmlSoDtlVO.setTmlSoOfcCtyCd(rowSet.getString("tml_so_ofc_cty_cd") );
					tesTmlSoDtlVO.setTmlSoSeq(rowSet.getString("tml_so_seq") );
					tesTmlSoDtlVO.setTmlSoDtlSeq(rowSet.getString("tml_so_dtl_seq") );
					voList.add(tesTmlSoDtlVO);
				}
			}
			
			if ( voList.size() > 0 ) {
				dbDao.updateStorageAccountCode( voList );
			}
			return eventResponse;
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
	 * reject 내역 수정
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse modifyStorageInvoiceReject(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );	
			dbDao.modifyStorageInvoiceReject( tesTmlSoHdrVO );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * reject 취소
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse cancelStorageInvoiceReject(Event e) throws EventException {

		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoHdrVO.setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
			tesTmlSoHdrVO.setLoclUpdDt( event.getSignOnUserAccount().getOfc_cd() );			
			dbDao.cancelStorageInvoiceReject(tesTmlSoHdrVO);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * container 목록 생성/수정/삭제
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse createStorageInvoiceContainerList(Event e) throws EventException{

		log.debug("\n\n BC.createStorageInvoiceContainerList \n");
		
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		int ins_idx = 0;
		String sIbFlag = "";
		
		TesTmlSoHdrVO tesTmlSoHdrVO = null;
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
		
		try {
			
			tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
			tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();
			
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();
//			List<TesTmlSoCntrListVO> deleteVOList = new ArrayList<TesTmlSoCntrListVO>();
			
			String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			String usr_id = event.getSignOnUserAccount().getUsr_id();			
			
			for( int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){
				
				sIbFlag = tesTmlSoCntrListVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesTmlSoCntrListVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoCntrListVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesTmlSoCntrListVOs[i].setCreUsrId(usr_id);
				tesTmlSoCntrListVOs[i].setUpdUsrId(usr_id);
				tesTmlSoCntrListVOs[i].setLoclCreDt(ofc_cd);
				tesTmlSoCntrListVOs[i].setLoclUpdDt(ofc_cd);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0) ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq((String.valueOf(++ins_idx)));
					insertVOList.add(tesTmlSoCntrListVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoCntrListVOs[i]);
//				} else if( "D".equals(sIbFlag) ) {		//delete
//					deleteVOList.add(tesTmlSoCntrListVOs[i]);
				}
				
			}
			
			if ( insertVOList.size() > 0 ) {
				dbDao.addStorageInvoiceContainerList(insertVOList);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.modifyStorageInvoiceContainerList(updateVOList);
			}

//			if ( deleteVOList.size() > 0 ) {
//				dbDao.removeStorageInvoiceContainerList(deleteVOList);
//			}
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

//		try {
//			dbDao.createStorageInvoiceContainerList(event.getTES_TML_SO_HDR(), event.getTES_TML_SO_CNTR_LISTS(), event.getSignOnUserAccount().getUsr_id(),event.getSignOnUserAccount().getOfc_cd());
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
		
	}

	/**
	 * detail 목록 생성/수정/삭제
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	@SuppressWarnings("null")
	public EventResponse createStorageInvoiceDetail(Event e) throws EventException{

		log.debug("\n\n BC.createStorageInvoiceDetail \n");
		
		EsdTes0009Event event=(EsdTes0009Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
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
			
			String ofc_cd = event.getSignOnUserAccount().getOfc_cd();
			String usr_id = event.getSignOnUserAccount().getUsr_id();			
			
			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++){
				
				sIbFlag = tesTmlSoDtlVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd(tesTmlSoHdrVO.getTmlSoOfcCtyCd());
				tesTmlSoDtlVOs[i].setTmlSoSeq(tesTmlSoHdrVO.getTmlSoSeq());
				tesTmlSoDtlVOs[i].setCreUsrId(usr_id);
				tesTmlSoDtlVOs[i].setUpdUsrId(usr_id);
				tesTmlSoDtlVOs[i].setLoclCreDt(ofc_cd);
				tesTmlSoDtlVOs[i].setLoclUpdDt(ofc_cd);
				
				tesTmlSoDtlVOs[i].setCalcRmk( TESUtil.convertText(tesTmlSoDtlVOs[i].getCalcRmk()) );
				
				String revYrmon = JSPUtil.getNull(tesTmlSoDtlVOs[i].getRevYrmon());
				
				if(revYrmon!=null && !revYrmon.equals("")){
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>> revYrmon : "+revYrmon);
					revYrmon = revYrmon.substring(0,6);
				}
				
				//[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
				//revYrmon = revYrmon!=null||revYrmon.trim().equals("")?revYrmon:revYrmon.substring(0,6);
				
				tesTmlSoDtlVOs[i].setRevYrmon( revYrmon );				
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					if(ins_idx == 0) ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_DTL", "TML_SO_DTL_SEQ");

					tesTmlSoDtlVOs[i].setTmlSoDtlSeq((String.valueOf(++ins_idx)));
					insertVOList.add(tesTmlSoDtlVOs[i]);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesTmlSoDtlVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesTmlSoDtlVOs[i]);
				}
				
			}

			// TES CSR I/F의 "AGMNT LINK"에 대해 Link되어있는 모든 계약서 load (4347-11-27)
			Map<String, String> etcMap = new HashMap<String, String>();
			etcMap.put( "yd_cd", event.getTesTmlSoHdrVO().getYdCd() );			
			etcMap.put( "vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );	
			
			// [CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 (2016-02-16)
			etcMap.put( "to_prd_dt", event.getTesTmlSoHdrVO().getToPrdDt() );	
			
			if ( insertVOList.size() > 0 ) {
//				dbDao.addStorageInvoiceDetail(insertVOList);
				dbDao.addStorageInvoiceDetail(insertVOList, etcMap);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.modifyStorageInvoiceDetail(updateVOList);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.removeStorageInvoiceDetailDeleteN3rd(deleteVOList);
				dbDao.removeStorageInvoiceDetailDeleteRvis(deleteVOList);
				dbDao.removeStorageInvoiceDetailDeleteDtl(deleteVOList);
			}
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		
		
//		try {			
//			dbDao.createStorageInvoiceDetail(event.getTES_TML_SO_HDR(), 
//											 event.getTES_TML_SO_DTLS(), 
//											 event.getStorageInvoiceDTLseqs(), 
//											 event.getStorageInvoiceN3rdPtyIFs(),
//											 event.getSignOnUserAccount().getOfc_cd(),
//											 event.getSignOnUserAccount().getUsr_id());
//			
//			return null;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
	}	

	/**
	 * 3rd 목록 조회 ByDay
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse searchStorage3rdIFlistOnly(Event e) throws EventException {
		log.debug("BC.searchStorage3rdIFlistOnly ###############################");
		EsdTes9254Event event=(EsdTes9254Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
//		DBRowSet rowSet=null; 
		
		try {
			eventResponse.setRs( dbDao.searchStorage3rdIFlistOnly(event.getTesN3rdPtyIfVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 3rd 목록 조회 ByDay
	 */
//	public EventResponse searchStorage3rdIFlist(Event e) throws EventException {
//		log.debug("BC.searchStorage3rdIFlist ###############################");
//		EsdTes9234Event event=(EsdTes9234Event)e;
//		DBRowSet rowSet=null; 
//		String calc_tp_cd = null;
//		
//		try {
//			calc_tp_cd = event.getMarineTerminalStorageInvoiceManageVO().getCalcTpCd();
//
//			GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
//			
//			if (calc_tp_cd!=null && calc_tp_cd.equals("A")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlist(event.getMarineTerminalStorageInvoiceManageVO()) );		
//			} else if (calc_tp_cd!=null && calc_tp_cd.equals("M")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlistManual(event.getMarineTerminalStorageInvoiceManageVO()) );
//			}			
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			return eventResponse;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * 3rd 목록 조회 ByDay
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse searchStorage3rdIFlistByDay(Event e) throws EventException {
		log.debug("BC.searchStorage3rdIFlistByDay ###############################");
		EsdTes9234Event event=(EsdTes9234Event)e;
		String calc_tp_cd = null;
		
		try {
			calc_tp_cd = event.getMarineTerminalStorageInvoiceManageVO().getCalcTpCd();
			
			GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
				
			if (calc_tp_cd!=null && calc_tp_cd.equals("A")){
				eventResponse.setRs( dbDao.searchStorage3rdIFlistByDay(event.getMarineTerminalStorageInvoiceManageVO()) );		
			} else if (calc_tp_cd!=null && calc_tp_cd.equals("M")){
				eventResponse.setRs( dbDao.searchStorage3rdIFlistByPoolManual(event.getMarineTerminalStorageInvoiceManageVO()) );
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
	 * 3rd 목록 조회 ByPool
	 */
//	public EventResponse searchStorage3rdIFlistByPool(Event e) throws EventException {
//		log.debug("BC.searchStorage3rdIFlistByPool ###############################");
//		EsdTes9234Event event=(EsdTes9234Event)e;
//		String calc_tp_cd = null;
//		
//		try {
//			calc_tp_cd = event.getMarineTerminalStorageInvoiceManageVO().getCalcTpCd();
//			
//			GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
//				
//			if (calc_tp_cd!=null && calc_tp_cd.equals("A")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlistByPool(event.getMarineTerminalStorageInvoiceManageVO()) );
//			} else if (calc_tp_cd!=null && calc_tp_cd.equals("M")){
//				eventResponse.setRs( dbDao.searchStorage3rdIFlistByPoolManual(event.getMarineTerminalStorageInvoiceManageVO()) );
//			}	
//			
//			eventResponse.setETCData( "successFlag", "SUCCESS" );
//			
//			return eventResponse;
//		} catch (DAOException ex) {
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}
	/** YOO - 끝 **/
	

	
	/** JINJOO - 시작 **/
	/**
	 * header 정보 조회 (main sheet)
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */	
	public EventResponse searchStorageInvoiceBasicInfo2(Event e) throws EventException {

		EsdTes0019Event event=(EsdTes0019Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();	
		try {
			eventResponse.setRs( dbDao.searchStorageInvoiceBasicInfo(event.getTesTmlSoHdrVO()) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Storage Container 목록 구하기
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse searchStorageContainerList2(Event e) throws EventException {

		EsdTes0019Event event=(EsdTes0019Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		List<DBRowSet> rsList = new ArrayList<DBRowSet>(); 

		try {
			
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"CO") );	//Coincidence
			rsList.add( dbDao.searchStorageContainerList(event.getTesTmlSoHdrVO(),"DC") );	//Discrepancy
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SD") ); 	//ByDay
			rsList.add( dbDao.searchStorageInvoiceDetail(event.getTesTmlSoHdrVO(),"SP") ); 	//ByPool

			eventResponse.setRsList(rsList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	
	}

// 사용안함 - 이정혜
//	/**
//	 * Storage detail 목록 구하기
//	 */
//	public EventResponse searchStorageInvoiceDetail2(Event e) throws EventException {
//		log.debug("\n\nBC.searchStorageInvoiceDetail\n");
//		EsdTes0019Event event=(EsdTes0019Event)e;
//		DBRowSet[] rowSetArr = new DBRowSet[2];
//		int curr_idx = 0;
//
//		try {
//			log.debug(" BC.searchStorageInvoiceDetail formCommand - "+event.getFormCommand().getCommand() + "<<<<<<<<<<<<<<<<<<<<");
//
//			rowSetArr[curr_idx++] = dbDao.searchStorageInvoiceDetail(event.getTES_TML_SO_HDR(),"SD"); //ByDay
//			//rowSetArr[curr_idx++] = dbDao.searchStorageInvoiceDetail(event.getTES_TML_SO_HDR(),event.getParams(),"SP"); //ByPool
//
//			return new ESD_TES_019EventResponse(rowSetArr,"SUCCESS");
//
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	/** JINJOO - 끝 **/
	
	/** multiStorage3rdIFlist TPB 조회
	 *  @param Event e
	 *  @return EventResponse
	 *  @throws EventException
	 */
	public EventResponse multiStorage3rdIFlist(Event e) throws EventException {

		EsdTes9234Event event = (EsdTes9234Event) e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO = null;
		MarineTerminalStorageInvoiceManageVO[] marineTerminalStorageInvoiceManageVOs = null;
		TesN3rdPtyIfVO tesN3rdPtyIfVO = null;
		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		TesTmlSoDtlVO tesTmlSoDtlVO = null;
		
		String sIbFlag = "";
		try {
			marineTerminalStorageInvoiceManageVO = event.getMarineTerminalStorageInvoiceManageVO();
			marineTerminalStorageInvoiceManageVOs = event.getMarineTerminalStorageInvoiceManageVOs();
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
			
			List<TesN3rdPtyIfVO> insertVOList = new ArrayList<TesN3rdPtyIfVO>();
			List<TesN3rdPtyIfVO> updateVOList = new ArrayList<TesN3rdPtyIfVO>();
			List<TesN3rdPtyIfVO> deleteVOList = new ArrayList<TesN3rdPtyIfVO>();

			List<TesTmlSoCntrListVO> updateCntrList = new ArrayList<TesTmlSoCntrListVO>();
			List<TesTmlSoDtlVO> updateDtlList = new ArrayList<TesTmlSoDtlVO>();

			List<TesN3rdPtyIfVO> deleteTpbPsList = new ArrayList<TesN3rdPtyIfVO>();
			List<TesTmlSoCntrListVO> updateCntrList2 = new ArrayList<TesTmlSoCntrListVO>();
			
			String sOfcCd = event.getSignOnUserAccount().getOfc_cd();
			String sUsrId = event.getSignOnUserAccount().getUsr_id();			
			int insIdx = 0;
					
			for( int i=0; tesN3rdPtyIfVOs!=null && i<tesN3rdPtyIfVOs.length; i++){
				
				sIbFlag = tesN3rdPtyIfVOs[i].getIbflag();
				
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> TYPE["+i+"] - "+sIbFlag);
				
				tesN3rdPtyIfVOs[i].setTmlIfOfcCd(sOfcCd);
				tesN3rdPtyIfVOs[i].setCreUsrId(sUsrId);
				tesN3rdPtyIfVOs[i].setUpdUsrId(sUsrId);
				tesN3rdPtyIfVOs[i].setLoclCreDt(sOfcCd);
				tesN3rdPtyIfVOs[i].setLoclUpdDt(sOfcCd);
				
				if ( "I".equals(sIbFlag) ) {			//insert
					
					//if(ins_idx == 0) ins_idx = dbDao.searchStorageTableMaxSeq(tesTmlSoHdrVO, "TES_TML_SO_CNTR_LIST", "TML_SO_CNTR_LIST_SEQ");
					
					if(insIdx == 0) insIdx = dbDao.searchStorageN3rdTableMaxSeq(sOfcCd);
					
					tesN3rdPtyIfVOs[i].setTmlN3ptyIfStsCd("N");
					tesN3rdPtyIfVOs[i].setTmlIfSeq((String.valueOf(++insIdx)));
					tesN3rdPtyIfVOs[i].setInvNo( marineTerminalStorageInvoiceManageVO.getInvNo() );
					tesN3rdPtyIfVOs[i].setYdCd( marineTerminalStorageInvoiceManageVO.getYdCd() );
					tesN3rdPtyIfVOs[i].setCxlFlg("N");
					insertVOList.add(tesN3rdPtyIfVOs[i]);
					
					//자동계산유형('A')이면서 CNTR_LIST_SEQ가 존재하면 CNTR LIST의 3RD SEQ(TML_IF_SEQ)를 UPDATE한다.
					if ( marineTerminalStorageInvoiceManageVO.getCalcTpCd()!=null
							&& "A".equals( marineTerminalStorageInvoiceManageVO.getCalcTpCd() )							
							&& marineTerminalStorageInvoiceManageVOs[i].getTmlSoCntrListSeq()!=null
							&& marineTerminalStorageInvoiceManageVOs[i].getTmlSoCntrListSeq()!="" ){
							//(String)param_map.get("calc_tp_cd")!=null && ((String)param_map.get("calc_tp_cd")).equals("A") && model.getTml_so_cntr_list_seq()!=null && !model.getTml_so_cntr_list_seq().trim().equals("")){
						tesTmlSoCntrListVO = new TesTmlSoCntrListVO();						
						tesTmlSoCntrListVO.setTmlIfSeq( (String.valueOf(insIdx)) );
						tesTmlSoCntrListVO.setTmlSoOfcCtyCd(marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd());
						tesTmlSoCntrListVO.setTmlSoSeq(marineTerminalStorageInvoiceManageVO.getTmlSoSeq());
						tesTmlSoCntrListVO.setTmlSoCntrListSeq( marineTerminalStorageInvoiceManageVOs[i].getTmlSoCntrListSeq() );
						updateCntrList.add( tesTmlSoCntrListVO );
					}
					
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setN3ptyFlg("Y");
					tesTmlSoDtlVO.setTmlSoOfcCtyCd( marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd() );
					tesTmlSoDtlVO.setTmlSoSeq( marineTerminalStorageInvoiceManageVO.getTmlSoSeq() );
					tesTmlSoDtlVO.setTmlSoDtlSeq( marineTerminalStorageInvoiceManageVO.getTmlSoDtlSeq() );
					updateDtlList.add(tesTmlSoDtlVO);
					
				} else if( "U".equals(sIbFlag) ) {		//update				
					updateVOList.add(tesN3rdPtyIfVOs[i]);
				} else if( "D".equals(sIbFlag) ) {		//delete
					deleteVOList.add(tesN3rdPtyIfVOs[i]);
				}
				
			}
			
//			 TPB IF DATA Delete 추가 - ( 2009-06-02 )
			String	delIfSeq	= JSPUtil.getNull( marineTerminalStorageInvoiceManageVO.getDelIfSeq() );
			String	delCntrSeq	= JSPUtil.getNull( marineTerminalStorageInvoiceManageVO.getDelCntrSeq() );

log.debug(">>>>>>>>>>>>>>> delIfSeq : "+delIfSeq+", delCntrSeq : "+delCntrSeq);
			
			if ( delIfSeq.length() > 0 ) {
				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrIfSeq	= delIfSeq.split("\\|");
				delCntrSeq	= delCntrSeq.substring( 0, delCntrSeq.length() - 1 ); //.replaceAll("\\|", ",");
				String	[]	arrCntrSeq	= delCntrSeq.split("\\|");
				
				for ( int j = 0; j < arrIfSeq.length; j++ ) {
					tesN3rdPtyIfVO = new TesN3rdPtyIfVO();
					tesN3rdPtyIfVO.setTmlIfOfcCd(sOfcCd);
					tesN3rdPtyIfVO.setTmlIfSeq(arrIfSeq[j]);
					tesN3rdPtyIfVO.setTmlSoOfcCtyCd(marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd());
					tesN3rdPtyIfVO.setTmlSoSeq(marineTerminalStorageInvoiceManageVO.getTmlSoSeq());
					tesN3rdPtyIfVO.setTmlSoDtlSeq(marineTerminalStorageInvoiceManageVO.getTmlSoDtlSeq());
					deleteTpbPsList.add(tesN3rdPtyIfVO);
					
					// Container List TML_IF_SEQ Update		
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();						
					tesTmlSoCntrListVO.setTmlIfSeq( "" );
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(marineTerminalStorageInvoiceManageVO.getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(marineTerminalStorageInvoiceManageVO.getTmlSoSeq());
					tesTmlSoCntrListVO.setTmlSoCntrListSeq((arrCntrSeq!=null&&arrCntrSeq.length>0&&j<arrCntrSeq.length?(arrCntrSeq[j]!=null?arrCntrSeq[j]:""):""));
					updateCntrList2.add( tesTmlSoCntrListVO );
				}
			}
			
			if ( deleteTpbPsList!=null && deleteTpbPsList.size() > 0 ) {
				
				dbDao.removeStorage3rdIFlistTPB(deleteTpbPsList);

				int iCnt = dbDao.searchStorageN3rdFlag(marineTerminalStorageInvoiceManageVO);
				
				log.debug("updateOffdockDetailN3rdFlagSearch result is "+iCnt);
				
				if( iCnt<1 ) dbDao.modifyStorageN3rdFlag(marineTerminalStorageInvoiceManageVO);
			}
			
			if( updateCntrList2!=null && updateCntrList2.size() > 0 )	dbDao.modifyStorage3rdIFlistCNTR(updateCntrList2);
			
			if ( insertVOList!=null && insertVOList.size() > 0 ) {
				dbDao.addStorage3rdIFlist(insertVOList);
				if( updateCntrList!=null && updateCntrList.size() > 0 )	dbDao.modifyStorage3rdIFlistCNTR(updateCntrList);
				if( updateDtlList!=null && updateDtlList.size() > 0 )	dbDao.modifyStorage3rdIFlistDTL(updateDtlList);
			}

			if ( updateVOList.size() > 0 ) {
				dbDao.modifyStorage3rdIFlist(updateVOList);
			}

			if ( deleteVOList.size() > 0 ) {
				dbDao.removeStorage3rdIFlist(deleteVOList);
			}
			
			//dbDao.multiStorage3rdIFlist(event.getTES_N3RD_PTY_IFS(), event.getParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err Exception de" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * MarineTerminalStorageInvoiceManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
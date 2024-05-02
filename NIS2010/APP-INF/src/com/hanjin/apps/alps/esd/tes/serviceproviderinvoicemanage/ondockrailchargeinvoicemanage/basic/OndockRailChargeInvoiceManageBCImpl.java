/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageBCImpl.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
* 2015-03-24 : 김영신 [CHM-201534788]GW Agmt Link 기준 변경 (SAve->Confirm) 	
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCntcBkgNoCntrListVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0064Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0068Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9031Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9060Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9130Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9231Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9251Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration.OndockRailChargeInvoiceManageDBDAO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
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
 * eNIS-ESD Business Logic Basic Command implementation<br>
 * - eNIS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author parkyeonjin
 * @see ESD_TES_064EventResponse,OndockRailChargeInvoiceManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 * 2011.07.18 윤태승 [CHM-201111696-01] TES의 BKG no. 참조로직 변경을 위한 타당성 검토 및 변경요청(ioBndCd DB Insert)
 */
public class OndockRailChargeInvoiceManageBCImpl   extends BasicCommandSupport implements OndockRailChargeInvoiceManageBC {

	// Database Access Object
	private transient OndockRailChargeInvoiceManageDBDAO dbDao=null;
//	// Database Access Object
//	private transient MarineTerminalInvoiceManageDBDAO  importDbDao=null;

	/**
	 * OndockRailChargeInvoiceManageBCImpl 객체 생성<br>
	 * OndockRailChargeInvoiceManageDBDAO를 생성한다.<br>
	 */
	public OndockRailChargeInvoiceManageBCImpl(){
		dbDao = new OndockRailChargeInvoiceManageDBDAO();
//		importDbDao = new MarineTerminalInvoiceManageDBDAO();
	}


	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeBasicInfo(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("========== BC . searchOndockRailChargeBasicInfo() ============");
		EsdTes0064Event event=(EsdTes0064Event)e;
		
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
//		ArrayList<DBRowSet> 	arrList 		= new ArrayList<DBRowSet>();
		HashMap<String, String> etcData 		= new HashMap<String, String>();
//		String tpszCode = "";
//		String costCode = "";
		StringBuilder		sbuTpszCode	= new StringBuilder();
		StringBuilder		sbuCostCode		= new StringBuilder();
		  

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet					= null;
		DBRowSet cntrTypeSizeRowSet	= null;
		DBRowSet costCodeRowSet		= null;

		try {
			rowSet					= dbDao.searchOndockRailChargeBasicInfo(event.getTesTmlSoHdrVO());
			cntrTypeSizeRowSet 	= dbDao.searchCntrTypeSizeList();
			costCodeRowSet 		= dbDao.searchCostCodeList();
			
			if (cntrTypeSizeRowSet != null && cntrTypeSizeRowSet.getRowCount() > 0) {
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
				while(cntrTypeSizeRowSet.next()){
//					tpszCode = tpszCode + cntrTypeSizeRowSet.getString("cntr_tpsz_cd")+"|";
					sbuTpszCode.append(cntrTypeSizeRowSet.getString("cntr_tpsz_cd")).append("|");
				}
			}
			
			if (costCodeRowSet != null && costCodeRowSet.getRowCount() > 0) {
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
				while(costCodeRowSet.next()){
//					costCode = costCode + costCodeRowSet.getString("lgs_cost_cd")+"|";
					sbuCostCode.append(costCodeRowSet.getString("lgs_cost_cd")).append("|");
				}
			}

			eventResponse.setRs(rowSet);
			// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
//			eventResponse.setETCData("tpszCode", tpszCode);
//			eventResponse.setETCData("costCode", costCode);
			eventResponse.setETCData("tpszCode", sbuTpszCode.toString() );
			eventResponse.setETCData("costCode", sbuCostCode.toString() );
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	/**
	 * Create 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 Create 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createOndockRailChargeBasicInfo(Event e) throws EventException {
		EsdTes0064Event event=(EsdTes0064Event)e;
		DBRowSet rowSet = null;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();

		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageBCImpl    createOndockRailChargeBasicInfo() ============");

		try {
			rowSet = dbDao.searchOndockRailChargeBasicInfo(event.getTesTmlSoHdrVO());
			if (rowSet!=null && rowSet.getRowCount()>0){ //중복 확인
//				throw new DAOException("DUP --> addOn-DockInvoiceManage() ");
				throw new DAOException(new ErrorHandler("TES00098", new String[]{}).getMessage());
			}
			
			/**
			 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
			 */
			java.util.HashMap hm = new java.util.HashMap();
			hm.put("vndr_seq",event.getTesTmlSoHdrVO().getVndrSeq());
			hm.put("inv_no",event.getTesTmlSoHdrVO().getInvNo());
			new TESInvoiceCommonBCImpl().checkEDIInvoiceDup(hm);
			
			dbDao.createOndockRailChargeBasicInfo(event.getTesTmlSoHdrVO(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Modify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 Modify 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOndockRailChargeBasicInfo(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("========== OndockRailChargeInvoiceManageBCImpl    modifyOndockRailChargeBasicInfo() ============");

		EsdTes0064Event event=(EsdTes0064Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		int modiDtlCnt = 0;

		try {
			if(event.getTesTmlSoHdrVO().getTmlInvStsCd().equals("C")){
				modiDtlCnt = dbDao.modifyCntrListForTerminalInvoiceConfirm(event);
			}
			dbDao.modifyOndockRailChargeBasicInfo(event);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
	 *
	 * @param e EsdTes9130Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException {
		log.debug("start createTES_FILE_IMP_TMP===============================");
		
		EsdTes9130Event 		event				=(EsdTes9130Event)e;
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		
		TesFileImpTmpVO[]		tesFileImpTmpVOs	= event.getTesFileImpTmpVOs();
		List<TesFileImpTmpVO> 	insVoList 			= new ArrayList<TesFileImpTmpVO>();
		int maxSeq = 0;
		
		try {
			maxSeq = dbDao.onDockRailChargeInvoiceCommonSeq("TML_SO_TMP_SEQ", "TES_FILE_IMP_TMP", "TML_SO_OFC_CTY_CD", "TML_SO_SEQ", event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd(), event.getTesTmlSoHdrVO().getTmlSoSeq());
			
log.debug("maxSeq======>"+maxSeq);
log.debug("tesFileImpTmpVOs======>"+tesFileImpTmpVOs);

			for(int i=0; tesFileImpTmpVOs!=null && i<tesFileImpTmpVOs.length; i++){
				tesFileImpTmpVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesFileImpTmpVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesFileImpTmpVOs[i].setTmlSoTmpSeq(maxSeq+"");
				tesFileImpTmpVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
				tesFileImpTmpVOs[i].setRcvDt(event.getTesTmlSoHdrVO().getRcvDt());
				tesFileImpTmpVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
				
				tesFileImpTmpVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
				tesFileImpTmpVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				
				insVoList.add(tesFileImpTmpVOs[i]);
				maxSeq++;
			}
			
			dbDao.createTES_FILE_IMP_TMP(insVoList);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리 verifyOndockRailChargeContainerList <br>
	 *
	 * @param e EsdTes9130Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOndockRailChargeContainerList(Event e) throws EventException {
		EsdTes9130Event 		event			=(EsdTes9130Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		DBRowSet rowSet = null;
		
		try {
			rowSet = dbDao.verifyOndockRailChargeContainerList(event);
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리 createOndockRailChargeContainerList<br>
	 *
	 * @param e EsdTes9130Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createOndockRailChargeContainerList(Event e) throws EventException {
		EsdTes9130Event 		event			=(EsdTes9130Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		DBRowSet 				dbRowSet		= null;
		TesTmlSoCntrListVO		tesTmlSoCntrListVO	= null;	
		int						maxSeq				= 0;	
		
		try {
			maxSeq = dbDao.onDockRailChargeInvoiceCommonSeq("TML_SO_CNTR_LIST_SEQ", "TES_TML_SO_CNTR_LIST", "TML_SO_OFC_CTY_CD", "TML_SO_SEQ", event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd(), event.getTesTmlSoHdrVO().getTmlSoSeq());

			dbRowSet = event.getRowSet();
			List<TesTmlSoCntrListVO> insertVOList = new ArrayList<TesTmlSoCntrListVO>();		

		    if(dbRowSet != null){
		    	log.debug("dbRowSet.getRowCount()====>"+dbRowSet.getRowCount());
		    	log.debug("dbRowSet"+dbRowSet);
		    	log.debug("event.getTesTmlSoHdrVO()===>"+event.getTesTmlSoHdrVO());
		    	log.debug("event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd===>"+event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());

		    	
		    	while (dbRowSet.next()) {
					tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
					
					tesTmlSoCntrListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoCntrListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoCntrListVO.setTmlSoCntrListSeq(maxSeq+"");
					
					tesTmlSoCntrListVO.setVrfyRsltIndCd(dbRowSet.getString("vrfy_rslt_ind_cd")) ;	
					tesTmlSoCntrListVO.setDscrIndCd(dbRowSet.getString("dscr_ind_cd"));		
					tesTmlSoCntrListVO.setVslCd(dbRowSet.getString("vsl_cd"));			
					tesTmlSoCntrListVO.setSkdVoyNo(dbRowSet.getString("skd_voy_no"));		
					tesTmlSoCntrListVO.setSkdDirCd(dbRowSet.getString("skd_dir_cd"));								
					tesTmlSoCntrListVO.setCntrNo(dbRowSet.getString("cntr_no"));			
					tesTmlSoCntrListVO.setCntrTpszCd(dbRowSet.getString("cntr_tpsz_cd"));		
					tesTmlSoCntrListVO.setCntrStyCd(dbRowSet.getString("cntr_sty_cd"));		
					tesTmlSoCntrListVO.setDcgoClssCd(dbRowSet.getString("dcgo_clss_cd"));					
					tesTmlSoCntrListVO.setWrkDt(dbRowSet.getString("wrk_dt"));
					tesTmlSoCntrListVO.setClmDt(dbRowSet.getString("clm_dt"));
					tesTmlSoCntrListVO.setRailBilDt(dbRowSet.getString("rail_bil_dt"));
					tesTmlSoCntrListVO.setBkgNo(dbRowSet.getString("bkg_no"));						
					tesTmlSoCntrListVO.setBlNo(dbRowSet.getString("bl_no"));				
					tesTmlSoCntrListVO.setCntrRmk(dbRowSet.getString("cntr_rmk"));
					tesTmlSoCntrListVO.setIoBndCd(dbRowSet.getString("io_bnd_cd")); 
					
					tesTmlSoCntrListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insertVOList.add(tesTmlSoCntrListVO);
					maxSeq++;
				}
		    }
			
			dbDao.createOndockRailChargeContainerList(insertVOList);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

//	/**
//	 * ContainerList Verify시 삭제 <br>
//	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
//	 *
//	 * @param e EsdTes9130Event
//	 * @return EventResponse ESD_TES_913EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse deleteOndockRailChargeContainerList(Event e) throws EventException {
//		EsdTes9130Event event=(EsdTes9130Event)e;
//		try {
//			dbDao.deleteOndockRailChargeContainerList(event.getParams());
//			return new ESD_TES_913EventResponse("SUCCESS");
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
	
	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
	 *
	 * @param e EsdTes9130Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException {
		EsdTes9130Event 		event			= (EsdTes9130Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		try {
			dbDao.removeTES_FILE_IMP_TMP(event);
			eventResponse.setETCData("successFlag", "SUCCESS");
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


//	/**
//	 * ContainerList Verify 이벤트 처리<br>
//	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
//	 *
//	 * @param e EsdTes9130Event
//	 * @return EventResponse ESD_TES_913EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse verifyOndockRailChargeContainerList(Event e) throws EventException {
//		EsdTes9130Event event=(EsdTes9130Event)e;
//		try {
//			Iterator itr = event.getTerminalInvoceContainers().iterator();
//			TerminalInvoceContainer model = null;
//			int length = event.getTerminalInvoceContainers().size();
//			DBRowSet[] rowSets = new DBRowSet[length];
//			if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageBCImpl    verifyOndockRailChargeContainerList() event.getTerminalInvoceContainers().size()============" +event.getTerminalInvoceContainers().size());
//			int i = 0;
//			while (itr.hasNext()) {
//				model = (TerminalInvoceContainer)itr.next();
//				rowSets[i++] = dbDao.verifyOndockRailChargeContainerList(model, event.getParams());
//			}
//
//
//			return new ESD_TES_913EventResponse(rowSets,"SUCCESS");
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}


	/**
	 * OndockRailChargeContainerList Multi 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage event에 대한 OndockRailChargeContainerList Multi 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeContainerList(Event e) throws EventException {
		log.debug("start multiOndockRailChargeContainerList=================== ");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event	=	(EsdTes0064Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		int maxSeq = 0;
		List<TesTmlSoCntrListVO> insVoList = new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoCntrListVO> updVoList = new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoCntrListVO> delVoList = new ArrayList<TesTmlSoCntrListVO>();
		
		TesTmlSoHdrVO		 tesTmlSoHdrVO		 = event.getTesTmlSoHdrVO();
		TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = event.getTesTmlSoCntrListVOs();

		log.debug("event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd()==========>"+event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
		log.debug("event.getTesTmlSoHdrVO().getTmlSoSeq()==========>"+event.getTesTmlSoHdrVO().getTmlSoSeq());

		
		try {
			maxSeq = dbDao.multiOndockRailChargeContainerListSeq(tesTmlSoHdrVO);
			
			log.debug("maxSeq========>"+maxSeq);
			log.debug("tesTmlSoCntrListVOs========>"+tesTmlSoCntrListVOs);

			for(int i=0; tesTmlSoCntrListVOs!=null && i<tesTmlSoCntrListVOs.length; i++){
				log.debug("tesTmlSoCntrListVOs.length===>"+tesTmlSoCntrListVOs.length);
				log.debug("tesTmlSoCntrListVOs[i].getIbflag()===>"+tesTmlSoCntrListVOs[i].getIbflag());


				if(tesTmlSoCntrListVOs[i].getIbflag().equals("I")){
					tesTmlSoCntrListVOs[i].setTmlSoCntrListSeq(maxSeq+"");
					tesTmlSoCntrListVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoCntrListVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insVoList.add(tesTmlSoCntrListVOs[i]);
					maxSeq++;
					
				}else if(tesTmlSoCntrListVOs[i].getIbflag().equals("U")){
					tesTmlSoCntrListVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoCntrListVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updVoList.add(tesTmlSoCntrListVOs[i]);
					
				}else if(tesTmlSoCntrListVOs[i].getIbflag().equals("D")){
					delVoList.add(tesTmlSoCntrListVOs[i]);
					
				}
			}
			
			
			dbDao.multiOndockRailChargeContainerListInsert(insVoList);
			dbDao.multiOndockRailChargeContainerListUpdate(updVoList);
			dbDao.multiOndockRailChargeContainerListDelete(delVoList);
			
			//dbDao.multiOndockRailChargeContainerList(event.getTesTmlSoCntrListVOs(), event.getEventParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * OndockRailChargeContainerList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage event에 대한 OndockRailChargeContainerList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

		try {
			rowSet=dbDao.searchOndockRailChargeContainerList(event);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * OndockRailChargeCostCalculationList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage event에 대한 OndockRailChargeCostCalcurationList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeCostCalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event=(EsdTes0064Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();

		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;

log.debug("event.getOndockRailChargeInvoiceCommonVO().getCostCalcMode()===>"+event.getOndockRailChargeInvoiceCommonVO().getCostCalcMode());

		try {
			if(event.getOndockRailChargeInvoiceCommonVO().getCostCalcMode().equals("R")){ //cost calculation mode (R : 기존저장된 calc list read)
				rowSet=dbDao.searchOndockRailChargeCostCalculationList(event);
			}else{// cost calculation mode ( N: New Calculation )
				rowSet=dbDao.searchOndockRailChargeCostCalculationListNew(event);
			}
			
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * CostCalcComboCodeList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage 대한 searchOnDockChargeInvoiceCostCalcComboCodeList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return  EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockChargeInvoiceCostCalcComboCodeList(Event e) throws EventException {
		EsdTes0064Event event=(EsdTes0064Event)e;
		DBRowSet				cntrTypeSizeRowSet	= null;
		DBRowSet				costCodeRowSet		= null;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
//		String tpszCode = "";
//		String costCode = "";
		StringBuilder		sbuTpszCode = new StringBuilder();
		StringBuilder		sbuCostCode = new StringBuilder();
		
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageBCImpl    searchOnDockChargeInvoiceCostCalcComboCodeList() ============event.getParams => "+event.getEventParams());

		try {
			cntrTypeSizeRowSet 	= dbDao.searchCntrTypeSizeList();
			costCodeRowSet 		= dbDao.searchCostCodeList();
			
			if (cntrTypeSizeRowSet != null && cntrTypeSizeRowSet.getRowCount() > 0) {
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
				while(cntrTypeSizeRowSet.next()){
//					tpszCode = tpszCode + cntrTypeSizeRowSet.getString("cntr_tpsz_cd")+"|";
					sbuTpszCode.append(cntrTypeSizeRowSet.getString("cntr_tpsz_cd")).append("|");
				}
			}
			
			if (costCodeRowSet != null && costCodeRowSet.getRowCount() > 0) {
				// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
				while(costCodeRowSet.next()){
//					costCode = costCode + costCodeRowSet.getString("lgs_cost_cd")+"|";
					sbuCostCode.append(costCodeRowSet.getString("lgs_cost_cd")).append("|");
				}
			}
//log.debug("\n\n[][][] >>>>>>>>>>>>>>>>>> costCode = " + costCode);
//log.debug("\n\n[][][] >>>>>>>>>>>>>>>>>> sbuCostCode.toString() = " + sbuCostCode.toString());
//log.debug("\n\n[][][] >>>>>>>>>>>>>>>>>> tpszCode = " + tpszCode);
//log.debug("\n\n[][][] >>>>>>>>>>>>>>>>>> sbuTpszCode.toString() = " + sbuTpszCode.toString());
			// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
//			eventResponse.setETCData("tpszCode", tpszCode);
//			eventResponse.setETCData("costCode", costCode);
			eventResponse.setETCData("tpszCode", sbuTpszCode.toString() );
			eventResponse.setETCData("costCode", sbuCostCode.toString() );
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}  catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}
	/**
	 * InvoiceDetail 멀티 이벤트 처리<br>
	 * ESD_TES_0064 화면에 대한 InvoiceDetail 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TES_0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */

	public EventResponse multiOndockRailChargeInvoiceDetail(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();

		try {
//			if(log.isDebugEnabled())log.debug("OndockRailChargeInvoiceManageBCImpl getTES_TML_SO_DTLS size  			:	" + event.getTES_TML_SO_DTLS().size());
//			if(log.isDebugEnabled())log.debug("OndockRailChargeInvoiceManageBCImpl getTerminalInvoiceN3ptyLists size  	:	" + event.getTesN3ptyIfs().size());
//			if(log.isDebugEnabled())log.debug("OndockRailChargeInvoiceManageBCImpl getTempN3ptyLists size   			:	" + event.getTempN3ptyIfs().size());
			
			TesTmlSoDtlVO[] 	tesTmlSoDtlVOs = event.getTesTmlSoDtlVOs();
			
			List<TesTmlSoDtlVO> insVoList 	= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> updVoList 	= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> del1VoList 	= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> del2VoList 	= new ArrayList<TesTmlSoDtlVO>();
			List<TesTmlSoDtlVO> del3VoList 	= new ArrayList<TesTmlSoDtlVO>();

			int maxSeq = dbDao.onDockRailChargeInvoiceCommonSeq("TML_SO_DTL_SEQ", "TES_TML_SO_DTL", "TML_SO_OFC_CTY_CD", "TML_SO_SEQ", event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd(), event.getTesTmlSoHdrVO().getTmlSoSeq());

log.debug("tesTmlSoDtlVOs===>"+tesTmlSoDtlVOs);			
			for( int i=0; tesTmlSoDtlVOs!=null && i<tesTmlSoDtlVOs.length; i++ ){
log.debug("tesTmlSoDtlVOs[i].getIbflag()=====>"+tesTmlSoDtlVOs[i].getIbflag());	

				if("S".equals(tesTmlSoDtlVOs[i].getCalcTpCd())){
					tesTmlSoDtlVOs[i].setCalcTpCd("M");
				}

				if(tesTmlSoDtlVOs[i].getIbflag().equals("I")){
					tesTmlSoDtlVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() );
					tesTmlSoDtlVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoDtlVOs[i].setTmlSoDtlSeq(maxSeq+"");
					
					tesTmlSoDtlVOs[i].setFmTrVolVal(JSPUtil.getNull(tesTmlSoDtlVOs[i].getFmTrVolVal().equals("")?"1":tesTmlSoDtlVOs[i].getFmTrVolVal()));
					tesTmlSoDtlVOs[i].setFmTrVolVal(JSPUtil.getNull(tesTmlSoDtlVOs[i].getToTrVolVal().equals("")?"99999":tesTmlSoDtlVOs[i].getToTrVolVal()));
					
					tesTmlSoDtlVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					insVoList.add(tesTmlSoDtlVOs[i]);
					maxSeq++;
					
				}else if(tesTmlSoDtlVOs[i].getIbflag().equals("U")){
					tesTmlSoDtlVOs[i].setFmTrVolVal(JSPUtil.getNull(tesTmlSoDtlVOs[i].getFmTrVolVal().equals("")?"1":tesTmlSoDtlVOs[i].getFmTrVolVal()));
					tesTmlSoDtlVOs[i].setFmTrVolVal(JSPUtil.getNull(tesTmlSoDtlVOs[i].getToTrVolVal().equals("")?"99999":tesTmlSoDtlVOs[i].getToTrVolVal()));
					tesTmlSoDtlVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesTmlSoDtlVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					
					updVoList.add(tesTmlSoDtlVOs[i]);
				}else if(tesTmlSoDtlVOs[i].getIbflag().equals("D")){
					del1VoList.add(tesTmlSoDtlVOs[i]);
					del2VoList.add(tesTmlSoDtlVOs[i]);
					del3VoList.add(tesTmlSoDtlVOs[i]);
				}
			}	

			// TES CSR I/F의 "AGMNT LINK"에 대해 Link되어있는 모든 계약서 load (4347-11-27)
			Map<String, String> etcMap = new HashMap<String, String>();
			etcMap.put( "yd_cd", event.getTesTmlSoHdrVO().getYdCd() );			
			etcMap.put( "vndr_seq", event.getTesTmlSoHdrVO().getVndrSeq() );	
			
			// [CHM-201640117]유효 AGMT 판단 Date와 Invoice Confirm시 가져오는 GW AGMT date 일치 (2016-02-16)
			etcMap.put( "min_wrk_dt", event.getOndockRailChargeInvoiceCommonVO().getMinWrkDt() );	
			etcMap.put( "max_wrk_dt", event.getOndockRailChargeInvoiceCommonVO().getMaxWrkDt() );
			
//			dbDao.multiOndockRailChargeInvoiceDetailInsert(insVoList);
			dbDao.multiOndockRailChargeInvoiceDetailInsert(insVoList, etcMap);
			dbDao.multiOndockRailChargeInvoiceDetailUpdate(updVoList);
			dbDao.multiOndockRailChargeInvoiceDetailDelete01(del1VoList);
			dbDao.multiOndockRailChargeInvoiceDetailDelete02(del2VoList);
			dbDao.multiOndockRailChargeInvoiceDetailDelete03(del3VoList);
			
			//dbDao.multiOndockRailChargeInvoiceDetail(event.getTES_TML_SO_DTLS(), event.getTesN3ptyIfs(),  event.getTempN3ptyIfs(), event.getParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}

	
	/**
	 * InvoiceDetail 멀티 이벤트 처리<br>
	 * ESD_TES_0064 화면에 대한 InvoiceDetail 멀티 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeOndockRailChargeInvoiceCost(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event=(EsdTes0064Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		try {
			if(log.isDebugEnabled())log.debug("\n===============OndockRailChargeInvoiceManageBCImpl removeOndockRailChargeInvoiceCost ");
				dbDao.removeTerminalInvoiceRvisList(event);
				dbDao.removeTerminalInvoiceN3RDList(event);
				dbDao.removeTerminalInvoiceCostCalculation(event);
				return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


//	/**
//	 * TerminalInvoiceN3rdPartyIF LIST 조회 이벤트 처리<br>
//	 * OndockRailChargeInvoiceManageDBDAO 대한 TerminalInvoiceN3rdPartyIF LIST 조회 이벤트 처리<br>
//	 *
//	 * @param e EsdTes0064Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceN3ptyList(Event e) throws EventException {
//
//		EsdTes0064Event event=(EsdTes0064Event)e;
//		DBRowSet rowSet=null;
//		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageBCImpl    searchOndockRailChargeInvoiceN3ptyList() ============event.getParams => "+event.getEventParams());
//
//		try {
//			rowSet = dbDao.searchOndockRailChargeInvoiceN3ptyList(event.getEventParams());
//			return new ESD_TES_064EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}
//	
//	/**
//	 * TML_SO_RVIS_LIST 조회 이벤트 처리<br>
//	 * OndockRailChargeInvoiceManageDBDAO 대한 TML_SO_RVIS_LIST 조회 이벤트 처리<br>
//	 *
//	 * @param e EsdTes0064Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceRvisList(Event e) throws EventException {
//
//		EsdTes0064Event event=(EsdTes0064Event)e;
//		DBRowSet rowSet=null;
//		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageBCImpl    searchOndockRailChargeInvoiceRvisList() ============event.getParams => "+event.getEventParams());
//
//		try {
//			rowSet = dbDao.searchOndockRailChargeInvoiceRvisList(event.getEventParams());
//			return new ESD_TES_064EventResponse(rowSet, "SUCCESS");
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}
//	}


	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_9031Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException {
		EsdTes9031Event event=(EsdTes9031Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 		= new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    searchAutoRevisedVolume() ============");

		try {
			rowSet = dbDao.searchAutoRevisedVolume(event);
			eventResponse.setRs(rowSet);
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_0001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TES_9031Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse updateOnDockContainerListRvisFlg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9031Event 	event				=(EsdTes9031Event)e;
		TesTmlSoDtlVO 		tesTmlSoDtlVO 		= null;
		TesTmlSoCntrListVO 	tesTmlSoCntrListVO 	= null;
		OndockRailChargeInvoiceCommonVO[] ondockRailChargeInvoiceCommonVOs = null;
		
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    updateContainerListRvisFlg() ============");

		try {
			
			tesTmlSoDtlVO 						= event.getTesTmlSoDtlVO();
			ondockRailChargeInvoiceCommonVOs 	= event.getOndockRailChargeInvoiceCommonVOs();
			
			List<TesTmlSoCntrListVO> voList = new ArrayList<TesTmlSoCntrListVO>();

			for( int i=0; ondockRailChargeInvoiceCommonVOs!=null && i<ondockRailChargeInvoiceCommonVOs.length; i++ ){
				tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
log.debug("ondockRailChargeInvoiceCommonVOs[i].getRvisIndFlg()=====>"+ondockRailChargeInvoiceCommonVOs[i].getRvisIndFlg());	

				//rvis_ind_flg
				tesTmlSoCntrListVO.setRvisIndFlg(ondockRailChargeInvoiceCommonVOs[i].getRvisIndFlg());
				tesTmlSoCntrListVO.setTmlSoOfcCtyCd(tesTmlSoDtlVO.getTmlSoOfcCtyCd() );
				tesTmlSoCntrListVO.setTmlSoSeq(tesTmlSoDtlVO.getTmlSoSeq() );
				tesTmlSoCntrListVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
				tesTmlSoCntrListVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				tesTmlSoCntrListVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
				tesTmlSoCntrListVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
				tesTmlSoCntrListVO.setTmlSoCntrListSeq(ondockRailChargeInvoiceCommonVOs[i].getRvisTmlSoCntrListSeq());
				
				voList.add(tesTmlSoCntrListVO);
			}	
			
			dbDao.updateOnDockContainerListRvisFlg(voList, event.getTesTmlSoDtlVO().getLgsCostCd());
			//dbDao.updateOnDockContainerListRvisFlg(event.getTES_TML_SO_CNTR_LISTS(), event.getParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			dbDao.updateOnDockRvisVol(event);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManageDBDAO 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_9031Event
	 * @return  EventResponse GeneralEventResponse
	 * @exception EventException
	 */

	public EventResponse searchTerminalInvoiceRevisedVolume(Event e) throws EventException {
		EsdTes9031Event 		event			=(EsdTes9031Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 		= new HashMap<String, String>();
		DBRowSet rowSet	=	null;
		
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    searchTerminalInvoiceRevisedVolume() ============");

		try {
			rowSet = dbDao.searchTerminalInvoiceRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO());
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9031Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume9031(Event e) throws EventException {
		EsdTes9031Event 		event			=(EsdTes9031Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 		= new HashMap<String, String>();
		
		DBRowSet rowSet=null;
		
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    searchTerminalInvoiceRevisedVolume903_1() ============");

		try {
			rowSet = dbDao.searchTerminalInvoiceRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO());
			eventResponse.setRs(rowSet);
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * TerminalInvoiceN3ptyAutoCntrList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 TerminalInvoiceN3ptyAutoCntrList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9231Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyAutoCntrList(Event e) throws EventException {
		EsdTes9231Event event=(EsdTes9231Event)e;
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n========== OndockRailChargeInvoiceManageBCImpl    searchTerminalInvoiceN3ptyAutoCntrList() ============");

		try {
			rowSet = dbDao.searchTerminalInvoiceRevisedVolume(event.getTesTmlSoCntrListVO(), event.getTesTmlSoDtlVO());
			etcData.put("successFlag", "SUCCESS");
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * total amount 조회
	 * @param Event e
	 * @return  EventResponse GeneralEventResponse
	 */
	public EventResponse searchOnDockTotalAmount(Event e) throws EventException {
		log.debug("\n\nBC.searchStorageTotalAmount\n");
		EsdTes9060Event 		event			=(EsdTes9060Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
//		HashMap<String, String> etcData			= new HashMap<String, String>();
		
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
		    log.debug(" BC.searchStorageTotalAmount formCommand - "+event.getFormCommand().getCommand() + "<<<<");
			rowSet=dbDao.searchStorageTotalAmount(event.getTesTmlSoHdrVO());
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData("successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	


	/**
	 * TerminalInvoiceN3ptyManualCntrList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 TerminalInvoiceN3ptyManualCntrList 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9231Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyManualCntrList(Event e) throws EventException {

		EsdTes9231Event event=(EsdTes9231Event)e;
		DBRowSet rowSet=null;
		GeneralEventResponse  eventResponse = new GeneralEventResponse();
		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    searchTerminalInvoiceN3ptyManualCntrList() ============");

		try {
			rowSet = dbDao.searchRehandlingVolume(event);
			etcData.put("successFlag", "SUCCESS");
			
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한3rd Party 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes9251Event
	 * @return eventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockTrdPartyVolume(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap();
		EsdTes9251Event 		event			=(EsdTes9251Event)e;
		
		DBRowSet rowSet=null;
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageBCImpl    searchOnDockTrdPartyVolume() ============");

		try {
			
			rowSet = dbDao.searchOnDockTrdPartyVolume(event.getTesN3rdPtyIfVO());
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/*******************************************************************************************
	 * 								kimjinjoo 개발부분 시작
	 ******************************************************************************************/

	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailCharge Container List 조회 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0068Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeBasicInfo2(Event e) throws EventException {
		EsdTes0068Event 		event			=(EsdTes0068Event)e;
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
				
		DBRowSet rowSet = null;

		if(log.isDebugEnabled()) log.debug("\n\n===============OndockRailChargeInvoiceManageBCImpl :::::: searchOndockRailChargeBasicInfo2()======================\n");
		try{
			rowSet 	= dbDao.searchOndockRailChargeBasicInfo(event.getTesTmlSoHdrVO());
			etcData.put("successFlag", "SUCCESS" );
			eventResponse.setRs(rowSet);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
		}catch(DAOException de){
			log.error("err"+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailCharge Container List 조회 화면에 대한 Container List(Coincidency/Discrepancy)조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0068Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeContainerList2(Event e) throws EventException {
		//Data전송을 위해 구현한 DBResultSet을 ArrayList에 담는다.
		EsdTes0068Event event=(EsdTes0068Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList<DBRowSet>  arrList 	= new ArrayList<DBRowSet>();
		
		Map<String, String>		etcData			= new HashMap<String, String>();		
		
//		DBRowSet[] rowSetArr = new DBRowSet[3];

		if(log.isDebugEnabled()) log.debug("\n\n================OndockRailChargeInvoiceManageBCImpl :::::: searchOndockRailChargeContainerList2()======================\n");
		if(log.isDebugEnabled())log.debug("\n\n============event.getParams => "+event.getTesTmlSoHdrVO());
		try{
			arrList.add(dbDao.searchOndockRailChargeContainerList2(event.getTesTmlSoHdrVO(),"CO"));
			arrList.add(dbDao.searchOndockRailChargeContainerList2(event.getTesTmlSoHdrVO(),"DC"));
			arrList.add(dbDao.searchOndockCostCalculationList(event.getTesTmlSoHdrVO()));
//			rowSetArr[2] = dbDao.searchOndockCostCalculationList(event.getTES_TML_SO_HDR(),"ON");
			
			etcData.put("successFlag", "SUCCESS" );
			
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);			

			return eventResponse;
//		}catch(SQLException se){
//			throw new SQLException(se.getMessage());
		}catch(DAOException de){
			log.error("err"+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/*******************************************************************************************
	 * 								kimjinjoo 개발부분 끝
	 ******************************************************************************************/

	/**
	 * InvoiceDetail 멀티 이벤트 처리<br>
	 * ESD_TES_9231 화면에 대한 InvoiceDetail 멀티 이벤트 처리<br>
	 *
	 * @param e EsdTes0064Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
log.debug("start multiTerminalInvoiceN3rdParyIF ################### ");

		EsdTes9231Event event = (EsdTes9231Event)e;
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
//		HashMap<String, String> etcData 	= new HashMap<String, String>();
		
		TesN3rdPtyIfVO[] 		tesN3rdPtyIfVOs 		= event.getTesN3rdPtyIfVOs();
		TesTmlSoCntrListVO[] 	tesTmlSoCntrListVOs 	= event.getTesTmlSoCntrListVOs();
		
		TesTmlSoCntrListVO		tesTmlSoCntrListVO  	= null;
		TesTmlSoDtlVO			tesTmlSoDtlVO			= null;
		TesN3rdPtyIfVO 			tesN3rdPtyIfVO			= null;
		
		List<TesN3rdPtyIfVO> 		insVoList 			= new ArrayList<TesN3rdPtyIfVO>();
		List<TesN3rdPtyIfVO> 		delVoList 			= new ArrayList<TesN3rdPtyIfVO>();
		List<TesN3rdPtyIfVO> 		updVoList 			= new ArrayList<TesN3rdPtyIfVO>();
		List<TesTmlSoCntrListVO> 	upd2VoList 			= new ArrayList<TesTmlSoCntrListVO>();
		List<TesTmlSoDtlVO> 		upd3VoList 			= new ArrayList<TesTmlSoDtlVO>();
		
		int maxSeq = 0;

		try {
			
			maxSeq = dbDao.onDockRailChargeInvoiceCommonSeq("TML_IF_SEQ", "TES_N3RD_PTY_IF", "TML_IF_OFC_CD", "", event.getTesTmlSoHdrVO().getInvOfcCd(), "");
			String	flgYn	= JSPUtil.getNull(event.getOndockRailChargeInvoiceCommonVO().getFlgYn());
			
			for(int i=0; tesN3rdPtyIfVOs!=null && i<tesN3rdPtyIfVOs.length; i++ ){
				tesN3rdPtyIfVOs[i].setTmlIfOfcCd(event.getSignOnUserAccount().getOfc_cd());
				
				log.debug("tesN3rdPtyIfVOs.length==>"+tesN3rdPtyIfVOs.length);				
				log.debug("tesN3rdPtyIfVOs[i].getIbflag()==>"+tesN3rdPtyIfVOs[i].getIbflag());

				if("I".equals(tesN3rdPtyIfVOs[i].getIbflag())){
					tesN3rdPtyIfVOs[i].setTmlIfSeq(maxSeq+"");
					tesN3rdPtyIfVOs[i].setTmlInvTpCd(event.getTesTmlSoHdrVO().getTmlInvTpCd());
					tesN3rdPtyIfVOs[i].setInvNo(event.getTesTmlSoHdrVO().getInvNo());
					tesN3rdPtyIfVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
					tesN3rdPtyIfVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
			
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesN3rdPtyIfVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					                
					tesN3rdPtyIfVOs[i].setCurrCd(event.getOndockRailChargeInvoiceCommonVO().getOrgCurrCd());
					
					tesN3rdPtyIfVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					 
					insVoList.add(tesN3rdPtyIfVOs[i]);

					if(event.getTesTmlSoDtlVO().getCalcTpCd()!=null && event.getTesTmlSoDtlVO().getCalcTpCd().equals("A") && tesTmlSoCntrListVOs[i].getTmlSoCntrListSeq()!=null && !tesTmlSoCntrListVOs[i].getTmlSoCntrListSeq().trim().equals("")){
						tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
						tesTmlSoCntrListVO.setTmlIfSeq(maxSeq+"");
						tesTmlSoCntrListVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
						tesTmlSoCntrListVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
						tesTmlSoCntrListVO.setTmlSoCntrListSeq(tesTmlSoCntrListVOs[i].getTmlSoCntrListSeq());

						upd2VoList.add(tesTmlSoCntrListVO);
					}
					
					tesTmlSoDtlVO = new TesTmlSoDtlVO();
					tesTmlSoDtlVO.setN3ptyFlg("Y");
					tesTmlSoDtlVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesTmlSoDtlVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesTmlSoDtlVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					
					upd3VoList.add(tesTmlSoDtlVO);
					
					maxSeq++;
					
				}else if("U".equals(tesN3rdPtyIfVOs[i].getIbflag())){
					tesN3rdPtyIfVOs[i].setCalcCostGrpCd(event.getTesTmlSoDtlVO().getCalcCostGrpCd());
					tesN3rdPtyIfVOs[i].setTmlInvTpCd(event.getTesTmlSoHdrVO().getTmlInvTpCd());
					tesN3rdPtyIfVOs[i].setVndrSeq(event.getTesTmlSoHdrVO().getVndrSeq());
					tesN3rdPtyIfVOs[i].setYdCd(event.getTesTmlSoHdrVO().getYdCd());
					tesN3rdPtyIfVOs[i].setAcctCd(event.getTesTmlSoDtlVO().getAcctCd());
					tesN3rdPtyIfVOs[i].setCurrCd(event.getOndockRailChargeInvoiceCommonVO().getOrgCurrCd());
					                
					tesN3rdPtyIfVOs[i].setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					tesN3rdPtyIfVOs[i].setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					tesN3rdPtyIfVOs[i].setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());

					tesN3rdPtyIfVOs[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
					tesN3rdPtyIfVOs[i].setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVOs[i].setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
					 
					updVoList.add(tesN3rdPtyIfVOs[i]);					
					
				}			
			}
			
			if(flgYn.equals("")){
				tesTmlSoDtlVO		= new TesTmlSoDtlVO();
				tesTmlSoDtlVO.setN3ptyFlg("");
				tesTmlSoDtlVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesTmlSoDtlVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesTmlSoDtlVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
				tesTmlSoDtlVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
				tesTmlSoDtlVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
				upd3VoList.add(tesTmlSoDtlVO);
			}	
			
			dbDao.multiTerminalInvoiceN3rdParyIFInsert(insVoList);
			dbDao.multiTerminalInvoiceN3rdParyIFUpdate1(updVoList);
			dbDao.multiTerminalInvoiceN3rdParyIFUpdate2(upd2VoList);
			dbDao.multiTerminalInvoiceN3rdParyIFUpdate3(upd3VoList);
			
			//dbDao.multiTerminalInvoiceN3rdParyIF(event.getTES_N3RD_PTY_IFS(), event.getParams(), event.getSignOnUserAccount().getUsr_id(), event.getSignOnUserAccount().getOfc_cd());
			
			//#### TPB IF DATA Delete 추가 - ( 2009-06-02 ) #####
			String	delIfSeq	= JSPUtil.getNull(event.getOndockRailChargeInvoiceCommonVO().getDelIfSeq());

			if ( delIfSeq.length() > 0 ) {
				delIfSeq	= delIfSeq.substring( 0, delIfSeq.length() - 1 ); 		//.replaceAll("\\|", ",");
				String	[]	arrIfSeq	= delIfSeq.split("\\|");

				delVoList 		= new ArrayList<TesN3rdPtyIfVO>();  // 초기화 시켜줌
				
				for ( int j = 0; j < arrIfSeq.length; j++ ) {
					tesN3rdPtyIfVO		= new TesN3rdPtyIfVO();
					tesN3rdPtyIfVO.setTmlIfOfcCd(event.getSignOnUserAccount().getOfc_cd());
					tesN3rdPtyIfVO.setTmlIfSeq(arrIfSeq[j]);
					//tesN3rdPtyIfVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
					//tesN3rdPtyIfVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
					//tesN3rdPtyIfVO.setTmlSoDtlSeq(event.getTesTmlSoDtlVO().getTmlSoDtlSeq());
					delVoList.add(tesN3rdPtyIfVO);
				}
				
			}
			
			dbDao.multiTerminalInvoiceN3rdParyIFDelete(delVoList);
			
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * TRS에서 찾은 BKG No.의 Status가 Cancelled인 경우에는 BKG 테이블에서 최신 BKG No. 찾기
	 * 
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return List<TesTmlSoCntrListVO>
	 * @throws EventException
	 */
	public List<TesTmlSoCntrListVO> searchBkgNoContainerList(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
		DBRowSet dbRowSet	= null;
		
		try {
			List<TesTmlSoCntrListVO> updateVOList = new ArrayList<TesTmlSoCntrListVO>();	
			
			if ( tesTmlSoHdrVO != null ) {
				List<SearchCntcBkgNoCntrListVO> rsList	= dbDao.searchNotBkgNoCntrList(tesTmlSoHdrVO);
				
				if ( rsList != null && rsList.size() > 0 ) {	
					for ( SearchCntcBkgNoCntrListVO listVo : rsList) {
						tesTmlSoCntrListVO = new TesTmlSoCntrListVO();
						
						if ( StringUtil.isEmpty( listVo.getBkgNo() ) && "NH".equals( listVo.getDscrIndCd() ) ) {
							String cancelledBkgNo = dbDao.getCancelledBkgNoInfo(listVo);	//Cancelled BKG 
							
							if ( cancelledBkgNo != null ) {
								dbRowSet = dbDao.getNotCancelledBkgNoInfo(cancelledBkgNo);
								
								ObjectCloner.build(listVo, tesTmlSoCntrListVO);
								
								if(dbRowSet != null && dbRowSet.next()){
									tesTmlSoCntrListVO.setVrfyRsltIndCd("CO");
									tesTmlSoCntrListVO.setDscrIndCd("");
									tesTmlSoCntrListVO.setBkgNo(dbRowSet.getString("bkg_no"));	
									tesTmlSoCntrListVO.setBlNo(dbRowSet.getString("bl_no"));		
									tesTmlSoCntrListVO.setVslCd(dbRowSet.getString("vsl_cd"));
									tesTmlSoCntrListVO.setSkdVoyNo(dbRowSet.getString("skd_voy_no"));
									tesTmlSoCntrListVO.setSkdDirCd(dbRowSet.getString("skd_dir_cd"));
	
									updateVOList.add(tesTmlSoCntrListVO);
								}
							}
						}
					}
				}
			}
			
			return updateVOList;
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Not Cancelled BKG No UPDATE
	 *
	 * @param updVoList List<TesTmlSoCntrListVO>
	 * @exception EventException
	 */
	public void updateBkgNoContainerList(List<TesTmlSoCntrListVO> updVoList) throws EventException {
		try {
			
			if ( updVoList != null && updVoList.size() > 0 ) {
				dbDao.multiOndockRailChargeContainerListUpdate(updVoList);
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * OndockRailChargeInvoiceManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}
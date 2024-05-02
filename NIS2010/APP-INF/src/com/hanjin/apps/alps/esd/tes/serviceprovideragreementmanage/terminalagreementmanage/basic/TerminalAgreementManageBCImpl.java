/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalAgreementManageBCImpl.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성
* 
*@ALPSModifyDate : 2009.08.10
*@ALPSModifier : yOng hO lEE
*@ALPSVersion : 1.0
* 2009.08.10 yOng hO lEE
* 
* 2009-03-13 [R200903110001] : Tariff 전송시 시간 초과로 인한 트랜젝션 발생 롤백 현상 원인 분석용
* 2010.10.13 박재흥 [] 소스품질 적용

=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0034Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0039Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0040Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9070Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9160Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9170Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9180Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9200Event;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration.TerminalAgreementManageDBDAO;
import com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtAplyDyVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtDgCgoClssVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtDtlVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtHdrVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtThrpCostVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtTpSzVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtVrfyMzdVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmCostVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmMzdVO;
import com.hanjin.syscommon.common.table.TesTmlSoAccmYdVO;

/**
 * ALPS-ServiceProviderAgreementManage Business Logic Basic Command implementation<br>
 * - ALPS-ServiceProviderAgreementManage 대한 비지니스 로직을 처리한다.<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_0039EventResponse,TerminalAgreementManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TerminalAgreementManageBCImpl   extends BasicCommandSupport implements TerminalAgreementManageBC {

	// Database Access Object
	private transient TerminalAgreementManageDBDAO dbDao=null;
	// Use Agreement Container Type Size Setting.
	// TES에서만 사용하는 Type Size 처리하기 위함.
	private String	[]	arrCntrTpSz	= {"D2", "D4", "D5", "D7", "D8", "D9", "DW", "DX"
									, "R2", "R4", "R5", "R7", "R8", "R9"
									, "F2", "F4", "F5"
									, "O2", "O4", "O5", "O7"
									, "S2", "S4"
									, "T2", "T4"
									, "A2", "A4", "A5"
									, "P2", "P4"
									, "C2", "C4"};
	
	/**
	 * TerminalAgreementManageBCImpl 객체 생성<br>
	 * TerminalAgreementManageDBDAO를 생성한다.<br>
	 */
	public TerminalAgreementManageBCImpl(){
		dbDao = new TerminalAgreementManageDBDAO();
	}


	/**
	 * Throughput Cost Code List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchThoroughputCC(Event e) throws EventException {

		List<DBRowSet>			rsVoList		= new ArrayList<DBRowSet>();
		EsdTes9180Event			event			= (EsdTes9180Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			rsVoList.add( dbDao.searchCostCodeList() );
			rsVoList.add( dbDao.searchThoroughputCC() );
			
			eventResponse.setRsList(rsVoList);

			eventResponse.setETCData( "thrp_cost_cd", (String)dbDao.searchThrpflg( event.getTesTmlAgmtThrpCostVO() ) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Header Info List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementPopUpList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9070Event			event			= (EsdTes9070Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			
			eventResponse.setRsVoList( dbDao.searchAgreementPopUpList( event ) );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Header Info Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgreementYardVendor(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchAgreementYardVendor(event.getTesTmlAgmtHdrVO() ) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Summary List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreeementSummaryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0039Event			event			= (EsdTes0039Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		

		try {
			eventResponse.setRs( dbDao.searchTerminalAgreeementSummaryList(event) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Agreement Header Info Select<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event			event			= (EsdTes0034Event)e;
		DBRowSet				yardFlgRS		= null;
		
		List<DBRowSet>			rsVoList		= new ArrayList<DBRowSet>();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			
			yardFlgRS	= dbDao.searchYardFlg(event.getTesTmlAgmtHdrVO());
			
			MdmYardVO	mdmYardVO	= new MdmYardVO();
			if( yardFlgRS != null ){
				
				while( yardFlgRS.next() ){
					mdmYardVO.setYdChrCd			( yardFlgRS.getString("yd_chr_cd") );
					mdmYardVO.setYdFctyTpMrnTmlFlg	( yardFlgRS.getString("yd_fcty_tp_mrn_tml_flg") );
					mdmYardVO.setYdFctyTpCyFlg		( yardFlgRS.getString("yd_fcty_tp_cy_flg") );
					mdmYardVO.setYdFctyTpCfsFlg		( yardFlgRS.getString("yd_fcty_tp_cfs_flg") );
					mdmYardVO.setYdFctyTpRailRmpFlg	( yardFlgRS.getString("yd_fcty_tp_rail_rmp_flg") );
				}
			}

			rsVoList.add( dbDao.searchAgreementCost	( mdmYardVO ) );	// Cost Code
			rsVoList.add( dbDao.searchCurrencyList	( event.getSignOnUserAccount().getOfc_cd() ) );	// Currency Code
			rsVoList.add( dbDao.searchLaneList		( event.getTesTmlAgmtHdrVO() ) );	// Lane Code
			rsVoList.add( dbDao.searchTypeList		( ) );	// Type Code
			rsVoList.add( dbDao.searchSizeList		( ) );	// Size Code
			rsVoList.add( dbDao.searchCostCodeList	( ) );	// Cost Code

			eventResponse.setRsList(rsVoList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;

		} catch (SQLException se) {
            log.error("err "+se.toString(),se);
            throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Agreement Terminal Detail List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchTerminalAgreementInfo( event.getTesTmlAgmtHdrVO(), event.getTesTmlAgmtDtlVO() ) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Cost Code Verify List Select.<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCodeVerifyList(Event e) throws EventException {

		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			
			eventResponse.setRs( dbDao.searchCostCodeVerifyList( event.getTesAgreementManageCommonVO().getLgsCostCd() ) );
			
			eventResponse.setETCData( "thrp_cost_cd", dbDao.searchThrpExitsFlg(event.getTesTmlAgmtDtlVO()) );
			eventResponse.setETCData( "successFlag"		, "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}

	/**
	 * Throughput Cost Code List Select.<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchThorougputCostCode(Event e) throws EventException {

		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		
		try {
			
			if ( !"".equals( event.getTesTmlAgmtThrpCostVO().getTmlAgmtVerNo() )) {
				event.getTesTmlAgmtThrpCostVO().setTmlAgmtVerNo( event.getTesTmlAgmtThrpCostVO().getTmlAgmtVerNo().replaceAll("\\.", "") );
			}
			
			eventResponse.setRs( dbDao.searchThorougputCostCode( event.getTesTmlAgmtThrpCostVO() ) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Terminal Detail List Select.<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementDetail(Event e) throws EventException {
		
		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			
			eventResponse.setRs( dbDao.searchTerminalAgreementDetail( event.getTesTmlAgmtHdrVO() ) );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			eventResponse.setETCData( "sheet_prefix", event.getTesAgreementManageCommonVO().getSheetPrefix() );
			
			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Storage Detail List Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchStorageAgreementDetail(Event e) throws EventException {
		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchStorageAgreementDetail(event.getTesTmlAgmtHdrVO() ) );
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			eventResponse.setETCData( "sheet_prefix", event.getTesAgreementManageCommonVO().getSheetPrefix() );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Terminal Detail Verify List Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifySheetTerminalAgreement(Event e) throws EventException {

		EsdTes0034Event			event					= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse			= new GeneralEventResponse();
		
		TesTmlAgmtVrfyMzdVO	[]	tesTmlAgmtVrfyMzdVOs	= event.getTesTmlAgmtVrfyMzdVOs();
		TesTmlAgmtVrfyMzdVO		tesTmlAgmtVrfyMzdVO		= null;
		List<DBRowSet>			rsVoList				= new ArrayList<DBRowSet>();

		
		try {
			log.debug("\n[TerminalAgreementManageBCImpl][verifySheetTerminalAgreement formCommand - " + event.getFormCommand().getCommand() + " <<<<");

			for( int i = 0; i < tesTmlAgmtVrfyMzdVOs.length; i++ ) {
				tesTmlAgmtVrfyMzdVO	= tesTmlAgmtVrfyMzdVOs[i];
				rsVoList.add( dbDao.verifyExcelAgreement(tesTmlAgmtVrfyMzdVO) );
			}
			
			eventResponse.setRsVoList(rsVoList);
			
			return eventResponse; 
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Agreement Terminal Detail Verify List Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyExcelTerminalAgreement(Event e) throws EventException {

		List<DBRowSet>			rsVoList		= new ArrayList<DBRowSet>();
		EsdTes9160Event			event			= (EsdTes9160Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		TesTmlAgmtVrfyMzdVO		tesTmlAgmtVrfyMzdVO	= null;
		TesTmlAgmtVrfyMzdVO[]	tesTmlAgmtVrfyMzdVOs= null;
		
		try {
			log.debug(" [TerminalAgreementManageBCImpl][verifyExcelTerminalAgreement] formCommand - "+event.getFormCommand().getCommand() + "<<<<");
			
			tesTmlAgmtVrfyMzdVOs	= (TesTmlAgmtVrfyMzdVO[])event.getTesTmlAgmtVrfyMzdVOs();
			
			for( int i = 0; i < tesTmlAgmtVrfyMzdVOs.length; i++ ) {
				tesTmlAgmtVrfyMzdVO	= (TesTmlAgmtVrfyMzdVO)tesTmlAgmtVrfyMzdVOs[i];
				rsVoList.add( dbDao.verifyExcelAgreement(tesTmlAgmtVrfyMzdVO) );
			}
			eventResponse.setRsList(rsVoList);

			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Storage Detail Verify Flag List Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyExcelStorageAgreement(Event e) throws EventException {

		List<DBRowSet>			rsVoList		= new ArrayList<DBRowSet>();
		EsdTes9170Event			event			= (EsdTes9170Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		TesTmlAgmtVrfyMzdVO		tesTmlAgmtVrfyMzdVO	= null;
		TesTmlAgmtVrfyMzdVO[]	tesTmlAgmtVrfyMzdVOs= null;

		
		try {
			log.debug(" [TerminalAgreementManageBCImpl][verifyExcelStorageAgreement] formCommand - "+event.getFormCommand().getCommand() + "<<<<");
			
			tesTmlAgmtVrfyMzdVOs = (TesTmlAgmtVrfyMzdVO[])event.getTesTmlAgmtVrfyMzdVOs();
			
			for ( int i = 0; i < tesTmlAgmtVrfyMzdVOs.length; i++ ) {
				tesTmlAgmtVrfyMzdVO	= (TesTmlAgmtVrfyMzdVO)tesTmlAgmtVrfyMzdVOs[i];
				rsVoList.add( dbDao.verifyExcelAgreement(tesTmlAgmtVrfyMzdVO) );
			}
			
			eventResponse.setRsList(rsVoList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Throughput Cost Code Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse deleteThoroughputCC(Event e) throws EventException {
		EsdTes9180Event	event	= (EsdTes9180Event)e;
		
		try {
			dbDao.deleteThoroughputCC( event.getTesTmlAgmtThrpCostVO() );
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Throughput Cost Code Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createThoroughputCC(Event e) throws EventException {
		EsdTes9180Event		event	= (EsdTes9180Event)e;

		TesTmlAgmtThrpCostVO		tesTmlAgmtThrpCostVO	= null;
		TesTmlAgmtThrpCostVO	[]	tesTmlAgmtThrpCostVOs	= null;
		List<TesTmlAgmtThrpCostVO>	insertList				= new ArrayList<TesTmlAgmtThrpCostVO>();
		
		int			maxSeq		= 0;
		
		try {

			maxSeq	= dbDao.createThoroughputCCSeq( event.getTesTmlAgmtThrpCostVO() );
			tesTmlAgmtThrpCostVO	= event.getTesTmlAgmtThrpCostVO();
			tesTmlAgmtThrpCostVOs	= event.getTesTmlAgmtThrpCostVOs();
			
			for( int i = 0; i < tesTmlAgmtThrpCostVOs.length; i++ ) {
				
				if ( "U".equals( tesTmlAgmtThrpCostVOs[i].getIbflag() ) ) {

					tesTmlAgmtThrpCostVOs[i].setTmlAgmtOfcCtyCd( tesTmlAgmtThrpCostVO.getTmlAgmtOfcCtyCd() );
					tesTmlAgmtThrpCostVOs[i].setTmlAgmtSeq( tesTmlAgmtThrpCostVO.getTmlAgmtSeq() );
					tesTmlAgmtThrpCostVOs[i].setTmlAgmtVerNo( tesTmlAgmtThrpCostVO.getTmlAgmtVerNo() );
					tesTmlAgmtThrpCostVOs[i].setThrpSeq( String.valueOf(maxSeq++) );
					tesTmlAgmtThrpCostVOs[i].setLgsCostCd( tesTmlAgmtThrpCostVO.getLgsCostCd() );
					tesTmlAgmtThrpCostVOs[i].setCreUsrId( tesTmlAgmtThrpCostVO.getCreUsrId() );
					insertList.add( tesTmlAgmtThrpCostVOs[i] );
				}
			}

			if ( insertList.size() > 0 ) {
				dbDao.createThoroughputCCInsert( insertList, event.getSignOnUserAccount().getOfc_cd());
			}
			
			return null;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Checked Agreement Before Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse regBeforeCheck(Event e) throws EventException {
		EsdTes0034Event			event			= (EsdTes0034Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		String					thrpFlag		= "";
		String					accmFlag		= "";
		//String					accmUomFlag		= "";
		
		try {
			
			thrpFlag = dbDao.regBeforeCheckThrp(event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO() );
			accmFlag = dbDao.regBeforeCheckAccm(event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO() );
			//accmUomFlag = dbDao.regBeforeCheckAccmUom(event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO() );
			
			//eventResponse.setETCData("regFlg", thrpFlag + "|" + accmFlag + "|" + accmUomFlag);
			eventResponse.setETCData("regFlg", thrpFlag + "|" + accmFlag );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement Info register Confirm.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse registerAgreementConfirm(Event e) throws EventException {
		EsdTes0034Event		event	= (EsdTes0034Event)e;

		try {
			// Tariff 전송시 시간 초과로 인한 트랜젝션 발생 롤백 현상 원인 분석용 ( 2009-03-13 )
			StringBuffer	sAgmt	= new StringBuffer();
			sAgmt.append("OFC : " + event.getTesTmlAgmtHdrVO().getTmlAgmtOfcCtyCd() )
				 .append(" : VerNo : " + event.getTesTmlAgmtHdrVO().getTmlAgmtVerNo() + " : ");
			
			//1. agreement reg 처리 sts를 C로 update
			log.error("\n[TerminalAgreementManageBCImp][registerAgreementConfirm][registerAgreementConfirm][START] >>>>> " + sAgmt.toString() +((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			
			dbDao.registerAgreementConfirm( event.getTesTmlAgmtHdrVO() );

			log.error("\n[TerminalAgreementManageBCImp][registerAgreementConfirm][registerAgreementConfirm][DONE] >>>>> " + sAgmt.toString() +((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			

			return null;

		}catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}catch (Exception e1) {
			log.error("err "+e1.toString(),e1);
			e1.printStackTrace();
			throw new EventException();
		}
	}

	/**
	 * Agreement Basic(Header) Info Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalAgreementBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event	event	= (EsdTes0034Event)e;

		try {
			log.error("\n START - [TerminalAgreementManageBCImpl][createTerminalAgreementBasicInfo] : "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			
			dbDao.createTerminalAgreementBasicInfo(event.getTesTmlAgmtHdrVO(), event.getSignOnUserAccount().getOfc_cd());
			//}
			log.error("\n END - [TerminalAgreementManageBCImpl][createTerminalAgreementBasicInfo] : "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");			
			return null;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * Agreement No Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalAgreementNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event		= (EsdTes0034Event)e;
		try {
			if ( !"".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ) {
				event.getTesTmlAgmtDtlVO().setTmlAgmtTpCd( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() );
			}

			if ( "".equals( event.getTesTmlAgmtDtlVO().getLgsCostCd() ) ) {
				dbDao.searchTerminalAgreementInfoCheckHdr( event.getTesTmlAgmtHdrVO() );
			} else if ( !"".equals( event.getTesTmlAgmtDtlVO().getLgsCostCd() ) ) {
				dbDao.searchTerminalAgreementInfoCheckHdrDtl( event.getTesTmlAgmtHdrVO(), event.getTesTmlAgmtDtlVO() );
			}
			
			dbDao.createTerminalAgreementNo(event.getTesTmlAgmtDtlVO(), event.getSignOnUserAccount().getOfc_cd());
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement No Update.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalAgreementInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();

		try {
			dbDao.modifyTerminalAgreementInfo(event.getTesTmlAgmtHdrVO(), event.getSignOnUserAccount().getOfc_cd());
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Agreement GW Link Update.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalAgreementContractInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event			event				= (EsdTes0034Event)e;
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();
		
		try {
			dbDao.modifyTerminalAgreementContractInfo(event.getTesTmlAgmtHdrVO(), event.getSignOnUserAccount().getOfc_cd());
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Agreement No Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalAgreementDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;

		try {
			dbDao.modifyTerminalAgreementDelete( event.getTesTmlAgmtHdrVO() );
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * insertAgmtListThrpInsert 의 Throughput Cost 에 Insert 하기 위한 List VO설정 처리.<br>
	 * 
	 * @param tmlAgmtOfcCtyCd
	 * @param tmlAgmtSeq
	 * @param tmlAgmtVerNo
	 * @param tesTmlAgmtDtlVOList
	 * @param tesTmlAgmtHdrVO
	 * @param thrpMaxSeq
	 * @return insertList List<TesTmlAgmtThrpCostVO>
	 * @exception EventException
	 */
	public List<TesTmlAgmtThrpCostVO> insertAgmtListThrpInsertSet(String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, List<TesTmlAgmtDtlVO> tesTmlAgmtDtlVOList, TesTmlAgmtHdrVO tesTmlAgmtHdrVO, int thrpMaxSeq) throws EventException{
		
		List<TesTmlAgmtThrpCostVO>	insertList		= new ArrayList<TesTmlAgmtThrpCostVO>();
		
		TesTmlAgmtDtlVO				tesTmlAgmtDtlVO			= null;
		TesTmlAgmtThrpCostVO		tesTmlAgmtThrpCostVO	= null;
	
		int		j		= 1;
		
		String[] tpndflAr = {"SVLDFL", "TMNDFL"};
		String[] tpndmtAr = {"SVLDMT", "TMNDMT"};
		String[] tpndtsAr = {"SVLDTS", "TMNDTS"};
		//TPNDTM 로직 수정 (SVLDMT, TMNDMT로 되어 있었지만 SVLDTM 하나임)
		String[] tpndtmAr = {"SVLDTM"};

		
		for ( int i = 0; i < tesTmlAgmtDtlVOList.size(); i++ ) {
			tesTmlAgmtDtlVO = tesTmlAgmtDtlVOList.get(i);
			
			if ( !"".equals(tesTmlAgmtDtlVO.getLgsCostCd()) && !"NaN".equals(tesTmlAgmtDtlVO.getLgsCostCd()) &&
				("TPNDFL".equals(tesTmlAgmtDtlVO.getLgsCostCd()) || "TPNDMT".equals(tesTmlAgmtDtlVO.getLgsCostCd()) || 
				 "TPNDTS".equals(tesTmlAgmtDtlVO.getLgsCostCd()) || "TPNDTM".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) ) {
				// TPNDTM 로직 수정 (SVLDMT, TMNDMT로 되어 있었지만 SVLDTM 하나임)
				// TPNDTM의 경우 SVLDTM 1 가지 밖에 없으므로 for 문의 limit 를 변수를 이용해 조정함 - 2007.09.07
				int count = 2;
				if( "TPNDTM".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) {
					count = 1;
				}
				
				for( j = 0; j < count; j++) {
					tesTmlAgmtThrpCostVO	= new TesTmlAgmtThrpCostVO();
					
					tesTmlAgmtThrpCostVO.setTmlAgmtOfcCtyCd	(tmlAgmtOfcCtyCd);
					tesTmlAgmtThrpCostVO.setTmlAgmtSeq		(tmlAgmtSeq);
					tesTmlAgmtThrpCostVO.setTmlAgmtVerNo	(tmlAgmtVerNo);
					tesTmlAgmtThrpCostVO.setThrpSeq			(String.valueOf(thrpMaxSeq++));
					tesTmlAgmtThrpCostVO.setLgsCostCd		(tesTmlAgmtDtlVO.getLgsCostCd());
					if ( "TPNDFL".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) {
						tesTmlAgmtThrpCostVO.setThrpLgsCostCd(tpndflAr[j]);
					} else if ("TPNDMT".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) {
						tesTmlAgmtThrpCostVO.setThrpLgsCostCd(tpndmtAr[j]);								
					} else if ("TPNDTS".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) {
						tesTmlAgmtThrpCostVO.setThrpLgsCostCd(tpndtsAr[j]);								
					} else if ("TPNDTM".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) {
						tesTmlAgmtThrpCostVO.setThrpLgsCostCd(tpndtmAr[j]);
					} else {
						tesTmlAgmtThrpCostVO.setThrpLgsCostCd("");
					}
					tesTmlAgmtThrpCostVO.setCreUsrId		(tesTmlAgmtHdrVO.getCreUsrId());
					
					insertList.add(tesTmlAgmtThrpCostVO);
				}

			} else if( !"".equals(tesTmlAgmtDtlVO.getLgsCostCd()) && !"NaN".equals(tesTmlAgmtDtlVO.getLgsCostCd()) &&
				("TPNDFL".equals(tesTmlAgmtDtlVO.getThrpLgsCostCd()) || "TPNDMT".equals(tesTmlAgmtDtlVO.getThrpLgsCostCd()) || 
				 "TPNDTS".equals(tesTmlAgmtDtlVO.getThrpLgsCostCd()) || "TPNDTM".equals(tesTmlAgmtDtlVO.getThrpLgsCostCd()) ) ) {
				// TPNDTM 로직 수정 (SVLDMT, TMNDMT로 되어 있었지만 SVLDTM 하나임)
				// TPNDTM의 경우 SVLDTM 1 가지 밖에 없으므로 for 문의 limit 를 변수를 이용해 조정함 - 2007.09.07
				int count = 2;
				if( "TPNDTM".equals(tesTmlAgmtDtlVO.getLgsCostCd()) ) {
					count = 1;
				}
				
				for( j = 0; j < count; j++) {
					tesTmlAgmtThrpCostVO	= new TesTmlAgmtThrpCostVO();
					
					tesTmlAgmtThrpCostVO.setTmlAgmtOfcCtyCd	(tmlAgmtOfcCtyCd);
					tesTmlAgmtThrpCostVO.setTmlAgmtSeq		(tmlAgmtSeq);
					tesTmlAgmtThrpCostVO.setTmlAgmtVerNo	(tmlAgmtVerNo);
					tesTmlAgmtThrpCostVO.setThrpSeq			(String.valueOf(thrpMaxSeq++));
					tesTmlAgmtThrpCostVO.setLgsCostCd		(tesTmlAgmtDtlVO.getThrpLgsCostCd());
					tesTmlAgmtThrpCostVO.setThrpLgsCostCd	(tesTmlAgmtDtlVO.getLgsCostCd());
					tesTmlAgmtThrpCostVO.setCreUsrId		(tesTmlAgmtHdrVO.getCreUsrId());
					
					insertList.add(tesTmlAgmtThrpCostVO);
				}
			}
		}
		
		return insertList;
	}
	
	/**
	 * Agreement Terminal Rate List Data Insert 하기 위한 List Setting.
	 *  
	 * @param event
	 * @param dtlMaxSeq
	 * @param tmlAgmtVerNo
	 * @return List
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List insertTerminalAgreementInsertSet(EsdTes0034Event event, int dtlMaxSeq, String tmlAgmtVerNo) throws EventException{
		List						insertList			= new ArrayList();
		
		List<TesTmlAgmtDtlVO>		insertListDtl		= new ArrayList<TesTmlAgmtDtlVO>();
		List<TesTmlAgmtTpSzVO>		insertListTpSz		= new ArrayList<TesTmlAgmtTpSzVO>();
		List<TesTmlAgmtAplyDyVO>	insertListAplyDy	= new ArrayList<TesTmlAgmtAplyDyVO>();
		List<TesTmlAgmtDgCgoClssVO>	insertListDgCgoClss	= new ArrayList<TesTmlAgmtDgCgoClssVO>();
		
		TesTmlAgmtHdrVO				tesTmlAgmtHdrVO			= null;
		TesTmlAgmtDtlVO				tesTmlAgmtDtlVO			= null;
		TesTmlAgmtAplyDyVO			tesTmlAgmtAplyDyVO 		= null;
		TesTmlAgmtTpSzVO			tesTmlAgmtTpSzVO		= null;
		TesTmlAgmtDgCgoClssVO		tesTmlAgmtDgCgoClssVO	= null;

		TesAgreementManageCommonVO	tesAgreementManageCommonVO	= new TesAgreementManageCommonVO();

		TesTmlAgmtDtlVO				[]	tesTmlAgmtDtlVOs	= null;
		TesTmlAgmtAplyDyVO			[]	tesTmlAgmtAplyDyVOs	= null;
		TesTmlAgmtDgCgoClssVO		[]	tesTmlAgmtDgCgoClssVOs		= null;
		TesAgreementManageCommonVO	[]	tesAgreementManageCommonVOs	= null;

		

		String	[]		arrAgmtRtTmp	= null;
		String			tmpTsRt			= "";
		String			cntrAplyTpCd	= "";
		
		try {
			tesTmlAgmtHdrVO				= event.getTesTmlAgmtHdrVO();
			tesTmlAgmtDtlVOs			= event.getTesTmlAgmtDtlVOs();
			tesTmlAgmtAplyDyVOs			= event.getTesTmlAgmtAplyDyVOs();
			tesTmlAgmtDgCgoClssVOs		= event.getTesTmlAgmtDgCgoClssVOs();
			tesAgreementManageCommonVOs	= event.getTesAgreementManageCommonVOs();
			
			for ( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
	
				if (tesTmlAgmtDtlVOs[i].getIbflag().length() > 0) {
					// 1. Agreement Detail.
					tesTmlAgmtDtlVO		= new TesTmlAgmtDtlVO();
					
					tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
					tesTmlAgmtDtlVO.setTmlAgmtSeq		(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
					tesTmlAgmtDtlVO.setTmlAgmtVerNo		(tmlAgmtVerNo);
					tesTmlAgmtDtlVO.setTmlAgmtDtlSeq	(String.valueOf(++dtlMaxSeq));
					tesTmlAgmtDtlVO.setTmlAgmtTpCd		(event.getTesTmlAgmtDtlVO().getTmlAgmtTpCd());
					tesTmlAgmtDtlVO.setLgsCostCd		(tesTmlAgmtDtlVOs[i].getLgsCostCd() );
					tesTmlAgmtDtlVO.setAutoCalcFlg		(tesTmlAgmtDtlVOs[i].getAutoCalcFlg() );
					if ( !"".equals(tesTmlAgmtDtlVOs[i].getThrpLgsCostCd()) ) {
						tesTmlAgmtDtlVO.setThrpCostCdFlg("Y");
					} else {
						tesTmlAgmtDtlVO.setThrpCostCdFlg("");
					}
					tesTmlAgmtDtlVO.setTmlAgmtVolUtCd	(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() );
					tesTmlAgmtDtlVO.setCurrCd			(tesTmlAgmtDtlVOs[i].getCurrCd() );
					tesTmlAgmtDtlVO.setIoBndCd			(tesTmlAgmtDtlVOs[i].getIoBndCd() );
					tesTmlAgmtDtlVO.setTmlTrnsModCd		(tesTmlAgmtDtlVOs[i].getTmlTrnsModCd() );
					if ( "Y".equals( tesTmlAgmtAplyDyVOs[i].getWkdyFlg() )&& 
						 "Y".equals( tesTmlAgmtAplyDyVOs[i].getSatFlg() ) &&
						 "Y".equals( tesTmlAgmtAplyDyVOs[i].getSunFlg() ) &&
						 "Y".equals( tesTmlAgmtAplyDyVOs[i].getHolFlg() ) ) {
						tesTmlAgmtDtlVO.setTmlDyAplyTpCd("S");
						
					} else if ( "Y".equals( tesTmlAgmtAplyDyVOs[i].getWkdyFlg() )|| 
							  "Y".equals( tesTmlAgmtAplyDyVOs[i].getSatFlg() ) ||
							  "Y".equals( tesTmlAgmtAplyDyVOs[i].getSunFlg() ) ||
							  "Y".equals( tesTmlAgmtAplyDyVOs[i].getHolFlg() ) ) {
						tesTmlAgmtDtlVO.setTmlDyAplyTpCd("P");
						
					} else {
						tesTmlAgmtDtlVO.setTmlDyAplyTpCd("");
					}
					tesTmlAgmtDtlVO.setLaneCd(tesTmlAgmtDtlVOs[i].getLaneCd());
					if ( "".equals( tesTmlAgmtDtlVOs[i].getDcgoAplyTpCd() ) ) {
						if ( "Y".equals( tesAgreementManageCommonVOs[i].getDgNone() ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("N");
							
						} else if ( "Y".equals( tesAgreementManageCommonVOs[i].getSameDgNone() ) || 
									"Y".equals( tesAgreementManageCommonVOs[i].getSameDg() ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("A");
							
						} else if ( "".equals( tesAgreementManageCommonVOs[i].getDgNone() ) &&
									"".equals( tesAgreementManageCommonVOs[i].getSameDgNone() ) && 
									"".equals( tesAgreementManageCommonVOs[i].getSameDg() ) && 
									("Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN1stClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN2ndClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN3rdClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN4thClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN5thClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN6thClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN7thClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN8thClssFlg()) ||
									"Y".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN9thClssFlg()) ||
									"Y".equals(tesAgreementManageCommonVOs[i].getSepDgNone() )
									) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("S");
							
						} else {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("");
						}
						
					} else if( !"".equals( tesTmlAgmtDtlVOs[i].getDcgoAplyTpCd() ) ) {
						tesTmlAgmtDtlVO.setDcgoAplyTpCd(tesTmlAgmtDtlVOs[i].getDcgoAplyTpCd());
					}
					tesTmlAgmtDtlVO.setTmlStoAgmtTpCd(tesTmlAgmtDtlVOs[i].getTmlStoAgmtTpCd());
					tesTmlAgmtDtlVO.setTmlVolAplyTpCd(tesTmlAgmtDtlVOs[i].getTmlVolAplyTpCd());
					tesTmlAgmtDtlVO.setFmTrVolVal(tesTmlAgmtDtlVOs[i].getFmTrVolVal());
					tesTmlAgmtDtlVO.setToTrVolVal( "MAX".equals(tesTmlAgmtDtlVOs[i].getToTrVolVal() ) ? "9999999" : tesTmlAgmtDtlVOs[i].getToTrVolVal() );
					tesTmlAgmtDtlVO.setTmlDysAplyTpCd(tesTmlAgmtDtlVOs[i].getTmlDysAplyTpCd());
					tesTmlAgmtDtlVO.setFmTrDys(tesTmlAgmtDtlVOs[i].getFmTrDys());
					tesTmlAgmtDtlVO.setToTrDys(tesTmlAgmtDtlVOs[i].getToTrDys());
					tesTmlAgmtDtlVO.setXcldDyAplyTpCd(tesTmlAgmtDtlVOs[i].getXcldDyAplyTpCd());
					tesTmlAgmtDtlVO.setCmncHrmnt(tesTmlAgmtDtlVOs[i].getCmncHrmnt());
					tesTmlAgmtDtlVO.setTmlOvtShftCd(tesTmlAgmtDtlVOs[i].getTmlOvtShftCd());
					tesTmlAgmtDtlVO.setThcTpCd(tesTmlAgmtDtlVOs[i].getThcTpCd());
					tesTmlAgmtDtlVO.setIocCd(tesTmlAgmtDtlVOs[i].getIocCd());
	
					if ( "T".equals(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt(tesAgreementManageCommonVOs[i].getTeuRate() );
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)						
					} else if ( "B".equals(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt(tesAgreementManageCommonVOs[i].getBoxRate() );
					} else if ( "W".equals(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt(tesAgreementManageCommonVOs[i].getTonRate() );
					} else if ( "M".equals(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt(tesAgreementManageCommonVOs[i].getMoveRate() );
	
					} else if ( "G".equals(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt(tesAgreementManageCommonVOs[i].getGangHourRate() );
					} else {
						tesTmlAgmtDtlVO.setAgmtUtRt("0.00" );
					}
					
					tesTmlAgmtDtlVO.setFpCalcPrdCd(tesTmlAgmtDtlVOs[i].getFpCalcPrdCd());
					tesTmlAgmtDtlVO.setFtDys(tesTmlAgmtDtlVOs[i].getFtDys());
					tesTmlAgmtDtlVO.setFpTeuQty(tesTmlAgmtDtlVOs[i].getFpTeuQty());
					tesTmlAgmtDtlVO.setAgmtDtlRmk(tesTmlAgmtDtlVOs[i].getAgmtDtlRmk());
					tesTmlAgmtDtlVO.setThrpLgsCostCd(tesTmlAgmtDtlVOs[i].getThrpLgsCostCd());
					tesTmlAgmtDtlVO.setTmpSavFlg(tesTmlAgmtDtlVOs[i].getTmpSavFlg());
					tesTmlAgmtDtlVO.setCreUsrId(tesTmlAgmtHdrVO.getCreUsrId());
					insertListDtl.add(tesTmlAgmtDtlVO);
					
					// 2. Agreement Type Size.
					tesAgreementManageCommonVO	= tesAgreementManageCommonVOs[i];
					
					if ( "C".equals( tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						if ("T".equals( event.getTesTmlAgmtDtlVO().getTmlAgmtTpCd() ) || 
							"S".equals( event.getTesTmlAgmtDtlVO().getTmlAgmtTpCd() ) ) {
							cntrAplyTpCd	= "R";
						}
						
						arrAgmtRtTmp	= null;
						tmpTsRt			= "";
						if ( "###############################".equals( tesAgreementManageCommonVO.getTsRt() ) ) {
							tmpTsRt = "#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0";
							arrAgmtRtTmp = tmpTsRt.split("#");
						} else {
							arrAgmtRtTmp = tesAgreementManageCommonVO.getTsRt().split("#");
						}
						
						int		j	= 1;
						for ( int k = 0; k < arrCntrTpSz.length; k++ ) {
							tesTmlAgmtTpSzVO	= new TesTmlAgmtTpSzVO();
							
							tesTmlAgmtTpSzVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
							tesTmlAgmtTpSzVO.setTmlAgmtSeq		(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
							tesTmlAgmtTpSzVO.setTmlAgmtVerNo	(tmlAgmtVerNo);
							tesTmlAgmtTpSzVO.setTmlAgmtDtlSeq	(String.valueOf(dtlMaxSeq));
							tesTmlAgmtTpSzVO.setCntrTpszCd		(arrCntrTpSz[k]);	// dbRowset.getString("cntr_tpsz_cd"));
							tesTmlAgmtTpSzVO.setCntrAplyTpCd	(cntrAplyTpCd);
							tesTmlAgmtTpSzVO.setAgmtRt			(arrAgmtRtTmp[j]);
							tesTmlAgmtTpSzVO.setAgmtDys			(tesTmlAgmtDtlVOs[i].getAgmtUtRt());
							tesTmlAgmtTpSzVO.setCreUsrId		(tesTmlAgmtHdrVO.getCreUsrId());
							tesTmlAgmtTpSzVO.setUpdUsrId		(tesTmlAgmtHdrVO.getCreUsrId());
							j++;
							insertListTpSz.add(tesTmlAgmtTpSzVO);								
						}//for..[]
					}
					
					// 3. Agreement Apply Day.
					tesTmlAgmtAplyDyVO	= new TesTmlAgmtAplyDyVO();
					
					if (!"".equals( tesTmlAgmtAplyDyVOs[i].getWkdyFlg() ) || !"".equals( tesTmlAgmtAplyDyVOs[i].getSatFlg() ) ||
						!"".equals( tesTmlAgmtAplyDyVOs[i].getSunFlg() ) || !"".equals( tesTmlAgmtAplyDyVOs[i].getHolFlg() ) ) {
						tesTmlAgmtAplyDyVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
						tesTmlAgmtAplyDyVO.setTmlAgmtSeq		(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
						tesTmlAgmtAplyDyVO.setTmlAgmtVerNo		(tmlAgmtVerNo);
						tesTmlAgmtAplyDyVO.setTmlAgmtDtlSeq		(String.valueOf(dtlMaxSeq));
						tesTmlAgmtAplyDyVO.setTmlRtDyAplyTpCd	("A");
						tesTmlAgmtAplyDyVO.setWkdyFlg			(tesTmlAgmtAplyDyVOs[i].getWkdyFlg());
						tesTmlAgmtAplyDyVO.setSatFlg			(tesTmlAgmtAplyDyVOs[i].getSatFlg());
						tesTmlAgmtAplyDyVO.setSunFlg			(tesTmlAgmtAplyDyVOs[i].getSunFlg());
						tesTmlAgmtAplyDyVO.setHolFlg			(tesTmlAgmtAplyDyVOs[i].getHolFlg());
						tesTmlAgmtAplyDyVO.setCreUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						tesTmlAgmtAplyDyVO.setUpdUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						insertListAplyDy.add(tesTmlAgmtAplyDyVO);
					}
					
					// 4. Agreement Danger Cargo Class.
					tesTmlAgmtDgCgoClssVO	= new TesTmlAgmtDgCgoClssVO();
					
					if (!"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN1stClssFlg()) || !"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN2ndClssFlg()) || 
						!"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN3rdClssFlg()) || !"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN4thClssFlg()) || 
						!"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN5thClssFlg()) || !"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN6thClssFlg()) || 
						!"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN7thClssFlg()) || !"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN8thClssFlg()) || 
						!"".equals(tesTmlAgmtDgCgoClssVOs[i].getDcgoN9thClssFlg()) || !"".equals(tesAgreementManageCommonVOs[i].getSameDgNone()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getSepDgNone()) || !"".equals(tesAgreementManageCommonVOs[i].getSameDg()) ) {
						tesTmlAgmtDgCgoClssVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
						tesTmlAgmtDgCgoClssVO.setTmlAgmtSeq			(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
						tesTmlAgmtDgCgoClssVO.setTmlAgmtVerNo		(tmlAgmtVerNo);
						tesTmlAgmtDgCgoClssVO.setTmlAgmtDtlSeq		(String.valueOf(dtlMaxSeq));
						tesTmlAgmtDgCgoClssVO.setDcgoAplyTpCd		("R");
						tesTmlAgmtDgCgoClssVO.setDcgoN1stClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN1stClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN2ndClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN2ndClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN3rdClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN3rdClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN4thClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN4thClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN5thClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN5thClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN6thClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN6thClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN7thClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN7thClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN8thClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN8thClssFlg());
						tesTmlAgmtDgCgoClssVO.setDcgoN9thClssFlg	(tesTmlAgmtDgCgoClssVOs[i].getDcgoN9thClssFlg());
						if("Y".equals(tesAgreementManageCommonVOs[i].getSameDgNone()) || "Y".equals(tesAgreementManageCommonVOs[i].getSepDgNone()) ) {
							tesTmlAgmtDgCgoClssVO.setDcgoNonClssFlg		("Y");
						} else {
							tesTmlAgmtDgCgoClssVO.setDcgoNonClssFlg		("");
						}
						
						if("Y".equals(tesAgreementManageCommonVOs[i].getSameDg()) ) {
							tesTmlAgmtDgCgoClssVO.setDcgoSamClssFlg		("Y");
						} else {
							tesTmlAgmtDgCgoClssVO.setDcgoSamClssFlg		("");							
						}
						tesTmlAgmtDgCgoClssVO.setCreUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						tesTmlAgmtDgCgoClssVO.setUpdUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						insertListDgCgoClss.add(tesTmlAgmtDgCgoClssVO);
					}
				}//if..[]
			}//for..[]
			
			insertList.add(insertListDtl);
			insertList.add(insertListTpSz);
			insertList.add(insertListAplyDy);
			insertList.add(insertListDgCgoClss);

		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return insertList;	
	}
	
	
	
	
	
	/**
	 * Agreement Storage Rate List Data Insert 하기 위한 List Setting.
	 * 
	 * @param event
	 * @param dtlMaxSeq
	 * @param tmlAgmtVerNo
	 * @return List
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List insertStorageAgreementInsertSet(EsdTes0034Event event, int dtlMaxSeq, String tmlAgmtVerNo) throws EventException{
		List						insertList				= new ArrayList();
		
		List<TesTmlAgmtDtlVO>		insertListDtl			= new ArrayList<TesTmlAgmtDtlVO>();
		List<TesTmlAgmtTpSzVO>		insertListTpSz			= new ArrayList<TesTmlAgmtTpSzVO>();
		List<TesTmlAgmtAplyDyVO>	insertListAplyDy		= new ArrayList<TesTmlAgmtAplyDyVO>();
		List<TesTmlAgmtDgCgoClssVO>	insertListDgCgoClss		= new ArrayList<TesTmlAgmtDgCgoClssVO>();
		
		TesTmlAgmtHdrVO				tesTmlAgmtHdrVO			= null;
		TesTmlAgmtDtlVO				tesTmlAgmtDtlVO			= null;
		TesTmlAgmtTpSzVO			tesTmlAgmtTpSzVO		= null;
		TesTmlAgmtAplyDyVO			tesTmlAgmtAplyDyVO 		= null;
		TesTmlAgmtDgCgoClssVO		tesTmlAgmtDgCgoClssVO	= null;

		TesAgreementManageCommonVO	tesAgreementManageCommonVO	= new TesAgreementManageCommonVO();

		TesTmlAgmtDtlVO				[]	tesTmlAgmtDtlVOs			= null;
		TesAgreementManageCommonVO	[]	tesAgreementManageCommonVOs	= null;
		
		String	[]		arrAgmtRtTmp	= null;
		String			tmpTsRt			= "";

		try {
			tesTmlAgmtHdrVO				= event.getTesTmlAgmtHdrVO();
			tesTmlAgmtDtlVOs			= event.getTesTmlAgmtDtlVOs();
			tesAgreementManageCommonVOs	= event.getTesAgreementManageCommonVOs();
			
			for ( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
	
				if (tesTmlAgmtDtlVOs[i].getIbflag().length() > 0) {
					// 1, Agreement Detail.
					tesTmlAgmtDtlVO	= null;
					tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO(); 
					tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
					tesTmlAgmtDtlVO.setTmlAgmtSeq		(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
					tesTmlAgmtDtlVO.setTmlAgmtVerNo		(tmlAgmtVerNo);
					tesTmlAgmtDtlVO.setTmlAgmtDtlSeq	(String.valueOf(dtlMaxSeq));
					tesTmlAgmtDtlVO.setTmlAgmtTpCd		(event.getTesTmlAgmtDtlVO().getTmlAgmtTpCd());
					tesTmlAgmtDtlVO.setLgsCostCd		(tesTmlAgmtDtlVOs[i].getLgsCostCd() );
					tesTmlAgmtDtlVO.setAutoCalcFlg		("Y" );	// (Storage는 전부 Y)
					tesTmlAgmtDtlVO.setThrpCostCdFlg	("");
					tesTmlAgmtDtlVO.setTmlAgmtVolUtCd	(tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() );
					tesTmlAgmtDtlVO.setCurrCd			(tesTmlAgmtDtlVOs[i].getCurrCd() );
					tesTmlAgmtDtlVO.setIoBndCd			(tesTmlAgmtDtlVOs[i].getIoBndCd() );
//					tesTmlAgmtDtlVO.setTmlTrnsModCd		(tesTmlAgmtDtlVOs[i].getTmlTrnsModCd() );
					tesTmlAgmtDtlVO.setTmlDyAplyTpCd	("");
					tesTmlAgmtDtlVO.setLaneCd			("");
					
					if ( "F".equals( tesTmlAgmtDtlVOs[i].getFtDys() ) ) {
						if ( "Y".equals( tesAgreementManageCommonVOs[i].getDgNoneFd() ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("N");
							
						} else if ( "Y".equals( tesAgreementManageCommonVOs[i].getSameDgNoneFd() ) || 
									"Y".equals( tesAgreementManageCommonVOs[i].getSameDgFd() ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("A");
							
						} else if ( "".equals( tesAgreementManageCommonVOs[i].getDgNoneFd() ) && 
									"".equals( tesAgreementManageCommonVOs[i].getSameDgNoneFd() ) &&
									"".equals( tesAgreementManageCommonVOs[i].getSameDgFd() ) &&
									("Y".equals( tesAgreementManageCommonVOs[i].getDcgoN1stClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN2ndClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN3rdClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN4thClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN5thClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN6thClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN7thClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN8thClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN9thClssFlgFd() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getSepDgNoneFd() ) ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("S");
							
						} else {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("");
							
						}
					} else if ( "".equals( tesTmlAgmtDtlVOs[i].getFtDys() ) ) {
						if ( "Y".equals( tesAgreementManageCommonVOs[i].getDgNoneR() ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("N");
							
						} else if ( "Y".equals( tesAgreementManageCommonVOs[i].getSameDgNoneR() ) || 
									"Y".equals( tesAgreementManageCommonVOs[i].getSameDgR() ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("A");
							
						} else if ( "".equals( tesAgreementManageCommonVOs[i].getDgNoneR() ) && 
									"".equals( tesAgreementManageCommonVOs[i].getSameDgNoneR() ) &&
									"".equals( tesAgreementManageCommonVOs[i].getSameDgR() ) &&
									("Y".equals( tesAgreementManageCommonVOs[i].getDcgoN1stClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN2ndClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN3rdClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN4thClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN5thClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN6thClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN7thClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN8thClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getDcgoN9thClssFlgR() ) ||
									"Y".equals( tesAgreementManageCommonVOs[i].getSepDgNoneR() ) ) ) {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("S");
							
						} else {
							tesTmlAgmtDtlVO.setDcgoAplyTpCd("");
						}
					} else {
						tesTmlAgmtDtlVO.setDcgoAplyTpCd("");
					}
					
					tesTmlAgmtDtlVO.setTmlStoAgmtTpCd(tesTmlAgmtDtlVOs[i].getTmlStoAgmtTpCd());
					tesTmlAgmtDtlVO.setTmlVolAplyTpCd("");	// (Tier Volume 적용 단위 구분)
					tesTmlAgmtDtlVO.setFmTrVolVal	("");
					tesTmlAgmtDtlVO.setToTrVolVal	("");
					if ( "F".equals(tesTmlAgmtDtlVOs[i].getFtDys() ) ) {
						tesTmlAgmtDtlVO.setTmlFreeDysTpCd("D");
					} else if ( "".equals(tesTmlAgmtDtlVOs[i].getFtDys() ) ) {
						tesTmlAgmtDtlVO.setTmlFreeDysTpCd("R");
					} else {
						tesTmlAgmtDtlVO.setTmlFreeDysTpCd("");
					}

					if ( "1".equals(tesTmlAgmtDtlVOs[i].getFmTrDys() ) && "MAX".equals( tesTmlAgmtDtlVOs[i].getToTrDys().toUpperCase()) ) {
						tesTmlAgmtDtlVO.setTmlDysAplyTpCd("N");
					} else if ( ( !"1".equals(tesTmlAgmtDtlVOs[i].getFmTrDys() ) && !"".equals(tesTmlAgmtDtlVOs[i].getFmTrDys() ) ) &&
							(!"MAX".equals( tesTmlAgmtDtlVOs[i].getToTrDys().toUpperCase()) && !"".equals(tesTmlAgmtDtlVOs[i].getToTrDys() ) ) ) {
						tesTmlAgmtDtlVO.setTmlDysAplyTpCd("S");
						
					} else if ( "".equals(tesTmlAgmtDtlVOs[i].getFmTrDys() ) && "".equals( tesTmlAgmtDtlVOs[i].getToTrDys() ) ) {
						tesTmlAgmtDtlVO.setTmlDysAplyTpCd("");
						
					} else {
						tesTmlAgmtDtlVO.setTmlDysAplyTpCd("");
						
					}
					tesTmlAgmtDtlVO.setFmTrDys(tesTmlAgmtDtlVOs[i].getFmTrDys());
					tesTmlAgmtDtlVO.setToTrDys("MAX".equals(tesTmlAgmtDtlVOs[i].getToTrDys().toUpperCase() ) ? "999" : tesTmlAgmtDtlVOs[i].getToTrDys() );

					if ("Y".equals( tesAgreementManageCommonVOs[i].getSatFlgFd() ) ||  "Y".equals( tesAgreementManageCommonVOs[i].getSunFlgFd() ) ||
						"Y".equals( tesAgreementManageCommonVOs[i].getHolFlgFd() ) ) {
						tesTmlAgmtDtlVO.setXcldDyAplyTpCd("S");
					} else {
						tesTmlAgmtDtlVO.setXcldDyAplyTpCd("N");
					}
					
					tesTmlAgmtDtlVO.setCmncHrmnt	( tesTmlAgmtDtlVOs[i].getCmncHrmnt() );
					tesTmlAgmtDtlVO.setTmlOvtShftCd	("");
					tesTmlAgmtDtlVO.setThcTpCd		("");
					tesTmlAgmtDtlVO.setIocCd		("");

					if ( "T".equals( tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt	(tesAgreementManageCommonVOs[i].getTeuRate());
					// CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
					} else if ( "B".equals( tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt	(tesAgreementManageCommonVOs[i].getBoxRate());
					} else if ( "W".equals( tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt	(tesAgreementManageCommonVOs[i].getTonRate());
					} else if ( "M".equals( tesTmlAgmtDtlVOs[i].getTmlAgmtVolUtCd() ) ) {
						tesTmlAgmtDtlVO.setAgmtUtRt	(tesAgreementManageCommonVOs[i].getMoveRate());
					} else {
						tesTmlAgmtDtlVO.setAgmtUtRt	("0.00");
					}
					tesTmlAgmtDtlVO.setFpCalcPrdCd(tesTmlAgmtDtlVOs[i].getFpCalcPrdCd());
					tesTmlAgmtDtlVO.setFtDys		("");	// (우선 null처리)
					tesTmlAgmtDtlVO.setFpTeuQty		(tesTmlAgmtDtlVOs[i].getFpTeuQty());
					tesTmlAgmtDtlVO.setAgmtDtlRmk	(tesTmlAgmtDtlVOs[i].getAgmtDtlRmk());
					tesTmlAgmtDtlVO.setThrpLgsCostCd("");
					tesTmlAgmtDtlVO.setTmpSavFlg	("");
					
					tesTmlAgmtDtlVO.setCreUsrId		(tesTmlAgmtHdrVO.getCreUsrId());	//tesTmlAgmtDtlVOs[i]
					tesTmlAgmtDtlVO.setUpdUsrId		(tesTmlAgmtHdrVO.getCreUsrId());
					
					insertListDtl.add(tesTmlAgmtDtlVO );
					
					
					// 2. Agreement Type Size
					tesAgreementManageCommonVO	= tesAgreementManageCommonVOs[i];
					
					if ((!"#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0".equals(tesAgreementManageCommonVO.getTsRt()) && 
						!"###############################".equals(tesAgreementManageCommonVO.getTsRt() ) ) ||
						"F".equals(tesTmlAgmtDtlVOs[i].getFtDys()) ) {
						arrAgmtRtTmp	= null;
						tmpTsRt			= "";
						if ("###############################".equals(tesAgreementManageCommonVO.getTsRt()) ) {
							tmpTsRt = "#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0";
							arrAgmtRtTmp = tmpTsRt.split("#");
						} else {
							arrAgmtRtTmp = tesAgreementManageCommonVO.getTsRt().split("#");
						}
						
						int		j	= 1;
						for ( int k = 0; k < arrCntrTpSz.length; k++ ) {
							tesTmlAgmtTpSzVO	= new TesTmlAgmtTpSzVO();
							tesTmlAgmtTpSzVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
							tesTmlAgmtTpSzVO.setTmlAgmtSeq		(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
							tesTmlAgmtTpSzVO.setTmlAgmtVerNo	(tmlAgmtVerNo);
							tesTmlAgmtTpSzVO.setTmlAgmtDtlSeq	(String.valueOf(dtlMaxSeq));
							tesTmlAgmtTpSzVO.setCntrTpszCd		(arrCntrTpSz[k]);	// dbRowset.getString("cntr_tpsz_cd"));
							
							if ( "".equals(tesTmlAgmtDtlVOs[i].getFtDys() ) ) {
								tesTmlAgmtTpSzVO.setCntrAplyTpCd("R");
								tesTmlAgmtTpSzVO.setAgmtRt(arrAgmtRtTmp[j]);
								tesTmlAgmtTpSzVO.setAgmtDys("");
								
							} else if ( "F".equals(tesTmlAgmtDtlVOs[i].getFtDys() ) ) {
								tesTmlAgmtTpSzVO.setCntrAplyTpCd("D");
								tesTmlAgmtTpSzVO.setAgmtRt("");
								tesTmlAgmtTpSzVO.setAgmtDys(arrAgmtRtTmp[j]);
								
							} else {
								tesTmlAgmtTpSzVO.setCntrAplyTpCd("R");
								tesTmlAgmtTpSzVO.setAgmtRt(arrAgmtRtTmp[j]);
								tesTmlAgmtTpSzVO.setAgmtDys("");
							}
							tesTmlAgmtTpSzVO.setCreUsrId(tesTmlAgmtHdrVO.getCreUsrId());
							tesTmlAgmtTpSzVO.setUpdUsrId(tesTmlAgmtHdrVO.getCreUsrId());
							j++;
							insertListTpSz.add(tesTmlAgmtTpSzVO);
						}//for..[]
					}//if..[]
					
					// 3. Agreement Apply Days
					tesTmlAgmtAplyDyVO	= new TesTmlAgmtAplyDyVO();
					
					if (!"".equals( tesAgreementManageCommonVOs[i].getSatFlgFd() ) ||
						!"".equals( tesAgreementManageCommonVOs[i].getSunFlgFd() ) || 
						!"".equals( tesAgreementManageCommonVOs[i].getHolFlgFd() ) ) {
						tesTmlAgmtAplyDyVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
						tesTmlAgmtAplyDyVO.setTmlAgmtSeq		(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
						tesTmlAgmtAplyDyVO.setTmlAgmtVerNo		(tmlAgmtVerNo);
						tesTmlAgmtAplyDyVO.setTmlAgmtDtlSeq		(String.valueOf(dtlMaxSeq));
						if ("T".equals(event.getTesTmlAgmtDtlVO().getTmlAgmtTpCd() ) ) {
							tesTmlAgmtAplyDyVO.setTmlRtDyAplyTpCd("A");
						} else if ("S".equals(event.getTesTmlAgmtDtlVO().getTmlAgmtTpCd() ) ) {
							tesTmlAgmtAplyDyVO.setTmlRtDyAplyTpCd("E");
						} else {
							tesTmlAgmtAplyDyVO.setTmlRtDyAplyTpCd("E");
						}
						tesTmlAgmtAplyDyVO.setWkdyFlg			(tesAgreementManageCommonVOs[i].getWkdyFlgFd());
						tesTmlAgmtAplyDyVO.setSatFlg			(tesAgreementManageCommonVOs[i].getSatFlgFd());
						tesTmlAgmtAplyDyVO.setSunFlg			(tesAgreementManageCommonVOs[i].getSunFlgFd());
						tesTmlAgmtAplyDyVO.setHolFlg			(tesAgreementManageCommonVOs[i].getHolFlgFd());
						tesTmlAgmtAplyDyVO.setCreUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						tesTmlAgmtAplyDyVO.setUpdUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						insertListAplyDy.add(tesTmlAgmtAplyDyVO);
					}
					
					// 4. Agreement Danger Cargo Class
					tesTmlAgmtDgCgoClssVO	= new TesTmlAgmtDgCgoClssVO();
					
					if (!"".equals(tesAgreementManageCommonVOs[i].getDcgoN1stClssFlgFd()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN2ndClssFlgFd()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN3rdClssFlgFd()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN4thClssFlgFd()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN5thClssFlgFd()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN6thClssFlgFd()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN7thClssFlgFd()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN8thClssFlgFd()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN9thClssFlgFd()) || !"".equals(tesAgreementManageCommonVOs[i].getSameDgNoneFd()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getSepDgNoneFd()) || !"".equals(tesAgreementManageCommonVOs[i].getSameDgFd()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN1stClssFlgR()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN2ndClssFlgR()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN3rdClssFlgR()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN4thClssFlgR()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN5thClssFlgR()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN6thClssFlgR()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN7thClssFlgR()) || !"".equals(tesAgreementManageCommonVOs[i].getDcgoN8thClssFlgR()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getDcgoN9thClssFlgR()) || !"".equals(tesAgreementManageCommonVOs[i].getSameDgNoneR()) || 
						!"".equals(tesAgreementManageCommonVOs[i].getSepDgNoneR()) || !"".equals(tesAgreementManageCommonVOs[i].getSameDgR())
					) {
						
						tesTmlAgmtDgCgoClssVO.setTmlAgmtOfcCtyCd	(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3));
						tesTmlAgmtDgCgoClssVO.setTmlAgmtSeq			(event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8));
						tesTmlAgmtDgCgoClssVO.setTmlAgmtVerNo		(tmlAgmtVerNo);
						tesTmlAgmtDgCgoClssVO.setTmlAgmtDtlSeq		(String.valueOf(dtlMaxSeq));
						
						if ( "F".equals(tesTmlAgmtDtlVOs[i].getFtDys() )) {
							tesTmlAgmtDgCgoClssVO.setDcgoAplyTpCd	("D");
							tesTmlAgmtDgCgoClssVO.setDcgoN1stClssFlg(tesAgreementManageCommonVOs[i].getDcgoN1stClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN2ndClssFlg(tesAgreementManageCommonVOs[i].getDcgoN2ndClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN3rdClssFlg(tesAgreementManageCommonVOs[i].getDcgoN3rdClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN4thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN4thClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN5thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN5thClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN6thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN6thClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN7thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN7thClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN8thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN8thClssFlgFd());
							tesTmlAgmtDgCgoClssVO.setDcgoN9thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN9thClssFlgFd());
							if("Y".equals(tesAgreementManageCommonVOs[i].getSameDgNoneFd()) || "Y".equals(tesAgreementManageCommonVOs[i].getSepDgNoneFd()) ) {
								tesTmlAgmtDgCgoClssVO.setDcgoNonClssFlg("Y");
							} else {
								tesTmlAgmtDgCgoClssVO.setDcgoNonClssFlg("");
							}
							if("Y".equals(tesAgreementManageCommonVOs[i].getSameDgFd()) ) {
								tesTmlAgmtDgCgoClssVO.setDcgoSamClssFlg("Y");
							} else {
								tesTmlAgmtDgCgoClssVO.setDcgoSamClssFlg("");							
							}

						} else if ( "".equals(tesTmlAgmtDtlVOs[i].getFtDys() )) {
							tesTmlAgmtDgCgoClssVO.setDcgoAplyTpCd	("R");
							tesTmlAgmtDgCgoClssVO.setDcgoN1stClssFlg(tesAgreementManageCommonVOs[i].getDcgoN1stClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN2ndClssFlg(tesAgreementManageCommonVOs[i].getDcgoN2ndClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN3rdClssFlg(tesAgreementManageCommonVOs[i].getDcgoN3rdClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN4thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN4thClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN5thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN5thClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN6thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN6thClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN7thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN7thClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN8thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN8thClssFlgR());
							tesTmlAgmtDgCgoClssVO.setDcgoN9thClssFlg(tesAgreementManageCommonVOs[i].getDcgoN9thClssFlgR());
							if("Y".equals(tesAgreementManageCommonVOs[i].getSameDgNoneR()) || "Y".equals(tesAgreementManageCommonVOs[i].getSepDgNoneR()) ) {
								tesTmlAgmtDgCgoClssVO.setDcgoNonClssFlg("Y");
							} else {
								tesTmlAgmtDgCgoClssVO.setDcgoNonClssFlg("");
							}
							if("Y".equals(tesAgreementManageCommonVOs[i].getSameDgR()) ) {
								tesTmlAgmtDgCgoClssVO.setDcgoSamClssFlg("Y");
							} else {
								tesTmlAgmtDgCgoClssVO.setDcgoSamClssFlg("");							
							}
						}
						tesTmlAgmtDgCgoClssVO.setCreUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						tesTmlAgmtDgCgoClssVO.setUpdUsrId			(tesTmlAgmtHdrVO.getCreUsrId());
						insertListDgCgoClss.add(tesTmlAgmtDgCgoClssVO);
					}
				}//if..[]
				dtlMaxSeq++;
			}//for..[]

			insertList.add(insertListDtl);
			insertList.add(insertListTpSz);
			insertList.add(insertListAplyDy);
			insertList.add(insertListDgCgoClss);
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return insertList;
	}
	
	
	
	/**
	 * Agreement Info Insert, Update.<br>
	 *
	 * @param e EsdTes0034Event
	 * @param invoiceUseFlg String
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse mutilAgreement(Event e, String invoiceUseFlg) throws EventException{
		
		EsdTes0034Event				event			= (EsdTes0034Event)e;
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();
		
		DBRowSet					dbRowset		= null;
		
		List						insertList		= null;
		
		List<TesTmlAgmtDtlVO>		selectDtlList	= new ArrayList<TesTmlAgmtDtlVO>();
		List<TesTmlAgmtDtlVO>		insertDtlList	= new ArrayList<TesTmlAgmtDtlVO>();
		List<TesTmlAgmtDtlVO>		updateDtlList	= new ArrayList<TesTmlAgmtDtlVO>();
		
		List<TesTmlAgmtTpSzVO>		insertTpSzList	= new ArrayList<TesTmlAgmtTpSzVO>();
		List<TesTmlAgmtAplyDyVO>	insertAplyList	= new ArrayList<TesTmlAgmtAplyDyVO>();
		List<TesTmlAgmtDgCgoClssVO>	insertDgCgoList	= new ArrayList<TesTmlAgmtDgCgoClssVO>();
		List<TesTmlAgmtThrpCostVO>	insertThrpList	= new ArrayList<TesTmlAgmtThrpCostVO>();

		TesTmlAgmtHdrVO				tesTmlAgmtHdrVO	= (TesTmlAgmtHdrVO)event.getTesTmlAgmtHdrVO();
		TesTmlAgmtDtlVO				tesTmlAgmtDtlVO	= null;
		TesAgreementManageCommonVO	tesAgreementManageCommonVO	= (TesAgreementManageCommonVO)event.getTesAgreementManageCommonVO();
		
		String					agmtConfirmFlg	= tesAgreementManageCommonVO.getAgmtConfirmFlg();
		
		String					tmlAgmtNo		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd();
		String					tmlAgmtStsCd	= tesTmlAgmtHdrVO.getTmlAgmtStsCd();
		
		String					tmlAgmtOfcCtyCd	= tmlAgmtNo.substring(0, 3);
		String					tmlAgmtSeq		= tmlAgmtNo.substring(3, 8);
		String					tmlAgmtVerNo	= tesTmlAgmtHdrVO.getTmlAgmtVerNo();
		
		String					n1stNo			= tmlAgmtVerNo.substring(0,2);
		String					n1stNoNew		= n1stNo;
		String					n2ndNo			= tmlAgmtVerNo.substring(3,5);
		String					n2ndNoNew		= String.valueOf( Integer.parseInt(n2ndNo) + 1 );
		n2ndNoNew	= JSPUtil.customString( "", 2-JSPUtil.getNull(n2ndNoNew).length()) + n2ndNoNew;
		tmlAgmtVerNo= n1stNo + n2ndNo;
		
		String					maxVer			= "";
		String					agmtVer			= "";
		String					tmlAgmtVerNoNew	= "";
		
		int		thrpMaxSeq		= 0;
		int		dtlMaxSeq		= 0;
		
		
		try {
			maxVer	= dbDao.searchMaxAgmtVer(tmlAgmtNo);
			

			if( "level1".equals(agmtConfirmFlg) && "C".equals(tmlAgmtStsCd) ) {
				n1stNoNew = String.valueOf( Integer.parseInt( maxVer.substring(0,2) ) + 1 );
				n1stNoNew = JSPUtil.customString("", 2 - JSPUtil.getNull(n1stNoNew).length()) + n1stNoNew;
				n2ndNoNew = "01";
				
				tmlAgmtVerNoNew	= n1stNoNew + n2ndNoNew;

				dbDao.agreementHistoryHDR(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, tesTmlAgmtHdrVO,
						"N", "Y", event.getSignOnUserAccount().getOfc_cd(), event.getSignOnUserAccount().getUsr_id() );
				dbDao.agreementHistoryDTL(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
						event.getSignOnUserAccount().getUsr_id() );
				dbDao.agreementHistoryTS(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
						event.getSignOnUserAccount().getUsr_id());
				dbDao.agreementHistoryAD(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
						event.getSignOnUserAccount().getUsr_id());
				dbDao.agreementHistoryDCC(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
						event.getSignOnUserAccount().getUsr_id());
				dbDao.agreementHistoryThrp(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
						event.getSignOnUserAccount().getUsr_id());
				
				selectDtlList = dbDao.searchThrpTerminalAgreement(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew);
				
				thrpMaxSeq = dbDao.insertAgmtListThrpSeq(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew );
				
				// Throughput Insert 하기 위한 List VO 설정.
				insertThrpList	= insertAgmtListThrpInsertSet( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew, selectDtlList, tesTmlAgmtHdrVO, thrpMaxSeq );
				
				if ( insertThrpList.size() > 0 ) {
					dbDao.insertAgmtListThrpInsert( insertThrpList, event.getSignOnUserAccount().getOfc_cd() );
				}
				
				dbRowset = dbDao.insertAgmtListThrpList( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew );
				
				if ( dbRowset != null ) {
					while ( dbRowset.next() ) {
						tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
						
						tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(dbRowset.getString("tml_agmt_ofc_cty_cd"));
						tesTmlAgmtDtlVO.setTmlAgmtSeq		(dbRowset.getString("tml_agmt_seq"));
						tesTmlAgmtDtlVO.setTmlAgmtVerNo		(dbRowset.getString("tml_agmt_ver_no"));
						tesTmlAgmtDtlVO.setLgsCostCd		(dbRowset.getString("lgs_cost_cd"));
						tesTmlAgmtDtlVO.setThrpLgsCostCd	(dbRowset.getString("thrp_lgs_cost_cd"));
						updateDtlList.add(tesTmlAgmtDtlVO);
					}
				}
				
				if ( updateDtlList.size() > 0 ) {
					dbDao.insertAgmtListThrpUpdate(updateDtlList);
				}

				agmtVer = n1stNoNew + "." + n2ndNoNew;
				
			} else if( "level2".equals(agmtConfirmFlg) && "C".equals(tmlAgmtStsCd)) {
				//[CHM-201640354]발행된 인보이스 없어도 이전 버전 agreement rewrite 안되고 유지되도록 설정 변경
//				if( "Y".equals(invoiceUseFlg) ) {
					n1stNoNew = maxVer.substring(0,2);
					n2ndNoNew = String.valueOf( Integer.parseInt( maxVer.substring(2,4) ) + 1 );
					n2ndNoNew = JSPUtil.customString( "", 2 - JSPUtil.getNull(n2ndNoNew).length()) + n2ndNoNew;
					tmlAgmtVerNoNew	= n1stNoNew + n2ndNoNew;
					
					dbDao.agreementHistoryHDR(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, tesTmlAgmtHdrVO,
							"N", "Y", event.getSignOnUserAccount().getOfc_cd(), event.getSignOnUserAccount().getUsr_id() );
					dbDao.agreementHistoryDTL(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id() );
					dbDao.agreementHistoryTS(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryAD(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryDCC(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryThrp(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					
					selectDtlList = dbDao.searchThrpTerminalAgreement(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew);
					
					thrpMaxSeq = dbDao.insertAgmtListThrpSeq(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew );
					
					// Throughput Insert 하기 위한 List VO 설정.
					insertThrpList	= insertAgmtListThrpInsertSet( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew, selectDtlList, tesTmlAgmtHdrVO, thrpMaxSeq );
					
					if ( insertThrpList.size() > 0 ) {
						dbDao.insertAgmtListThrpInsert( insertThrpList, event.getSignOnUserAccount().getOfc_cd() );
					}
					
					dbRowset = dbDao.insertAgmtListThrpList( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew );
					
					if ( dbRowset != null ) {
						while ( dbRowset.next() ) {
							tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
							
							tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(dbRowset.getString("tml_agmt_ofc_cty_cd"));
							tesTmlAgmtDtlVO.setTmlAgmtSeq		(dbRowset.getString("tml_agmt_seq"));
							tesTmlAgmtDtlVO.setTmlAgmtVerNo		(dbRowset.getString("tml_agmt_ver_no"));
							tesTmlAgmtDtlVO.setLgsCostCd		(dbRowset.getString("lgs_cost_cd"));
							tesTmlAgmtDtlVO.setThrpLgsCostCd	(dbRowset.getString("thrp_lgs_cost_cd"));
							updateDtlList.add(tesTmlAgmtDtlVO);
						}
					}
					
					if ( updateDtlList.size() > 0 ) {
						dbDao.insertAgmtListThrpUpdate(updateDtlList);
					}
					
					agmtVer = n1stNoNew + "." + n2ndNoNew;
//				} else if("N".equals( invoiceUseFlg ) ) {
//					dbDao.modifyTerminalAgreementInfo( tesTmlAgmtHdrVO, event.getSignOnUserAccount().getOfc_cd() );
//
//					selectDtlList = dbDao.searchThrpTerminalAgreement(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo);
//
//					thrpMaxSeq = dbDao.insertAgmtListThrpSeq(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo );
//					
//					// Throughput Insert 하기 위한 List VO 설정.
//					insertThrpList	= insertAgmtListThrpInsertSet( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, selectDtlList, tesTmlAgmtHdrVO, thrpMaxSeq );
//					
//					if ( insertThrpList.size() > 0 ) {
//						dbDao.insertAgmtListThrpInsert( insertThrpList, event.getSignOnUserAccount().getOfc_cd() );
//					}
//					
//					dbRowset = dbDao.insertAgmtListThrpList( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo );
//					
//					if ( dbRowset != null ) {
//						while ( dbRowset.next() ) {
//							tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
//							
//							tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(dbRowset.getString("tml_agmt_ofc_cty_cd"));
//							tesTmlAgmtDtlVO.setTmlAgmtSeq		(dbRowset.getString("tml_agmt_seq"));
//							tesTmlAgmtDtlVO.setTmlAgmtVerNo		(dbRowset.getString("tml_agmt_ver_no"));
//							tesTmlAgmtDtlVO.setLgsCostCd		(dbRowset.getString("lgs_cost_cd"));
//							tesTmlAgmtDtlVO.setThrpLgsCostCd	(dbRowset.getString("thrp_lgs_cost_cd"));
//							updateDtlList.add(tesTmlAgmtDtlVO);
//						}
//					}
//					
//					if ( updateDtlList.size() > 0 ) {
//						dbDao.insertAgmtListThrpUpdate(updateDtlList);
//					}
//
//		    		agmtVer = n1stNo + "." + n2ndNo;
//				
//				}
			} else if("sheet".equals(agmtConfirmFlg) && "C".equals(tmlAgmtStsCd) ) {
				if( "Y".equals(invoiceUseFlg) ) {
					//1. 기존 버전 Agreement 데이터 새로 insert
					//   HDR 버전 레벨 UP
					//   STS_CD 'P'로 수정
					n1stNoNew =  maxVer.substring(0, 2);
					n2ndNoNew = String.valueOf(Integer.parseInt(maxVer.substring(2,4)) + 1);
					n2ndNoNew = JSPUtil.customString("",2-JSPUtil.getNull(n2ndNoNew).length())+ n2ndNoNew;
					tmlAgmtVerNoNew	= n1stNoNew + n2ndNoNew;
	
					dbDao.agreementHistoryHDR(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, tesTmlAgmtHdrVO,
							"N", "Y", event.getSignOnUserAccount().getOfc_cd(), event.getSignOnUserAccount().getUsr_id() );
					dbDao.agreementHistoryDTL(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id() );
					dbDao.agreementHistoryTS(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryAD(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryDCC(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryThrp(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
	
		    		
					//2. Agreement 데이터 delete --- 수정 해야 함 버전 no도 넘겨야 함
					tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
					tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	( event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3) );
					tesTmlAgmtDtlVO.setTmlAgmtSeq		( event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8) );
					tesTmlAgmtDtlVO.setTmlAgmtVerNo		( tmlAgmtVerNoNew );
					tesTmlAgmtDtlVO.setTmlAgmtTpCd		( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() );
		    		dbDao.deleteAgreement_modifyDelete01( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete02( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete03( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete04( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete05( tesTmlAgmtDtlVO );
		    		
	    		
					//3. Agreement 데이터 insert
					if( "T".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ) {
						dtlMaxSeq	= dbDao.insertTerminalAgreementSeq	( event.getTesTmlAgmtDtlVO(), tmlAgmtVerNoNew );
						
						insertList	= insertTerminalAgreementInsertSet(event, dtlMaxSeq, tmlAgmtVerNoNew);	// , tpSzRowset );
						
						insertDtlList	= (List<TesTmlAgmtDtlVO>)insertList.get(0);	// insertTerminalAgreementDTLInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );
						insertTpSzList	= (List<TesTmlAgmtTpSzVO>)insertList.get(1);	// insertTerminalAgreementTPSZInsertSet	( event, tpSzRowset, dtlMaxSeq, tmlAgmtVerNoNew );
						insertAplyList	= (List<TesTmlAgmtAplyDyVO>)insertList.get(2);	// insertTerminalAgreementAPLYDYInsertSet( event, dtlMaxSeq, tmlAgmtVerNoNew );
						insertDgCgoList	= (List<TesTmlAgmtDgCgoClssVO>)insertList.get(3);	// insertTerminalAgreementDGCGOInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );
						
						dbDao.insertTerminalAgreementDTLInsert		(insertDtlList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementTPSZInsert		(insertTpSzList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementAPLYDYInsert	(insertAplyList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementDGCGOInsert	(insertDgCgoList, event.getSignOnUserAccount().getOfc_cd());
						
					}else if("S".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ){
						dtlMaxSeq	= dbDao.insertTerminalAgreementSeq	( event.getTesTmlAgmtDtlVO(), tmlAgmtVerNoNew );
						if ( event.getTesTmlAgmtDtlVOs()!=null && event.getTesTmlAgmtDtlVOs().length > 0 ) {
							insertList	= insertStorageAgreementInsertSet(event, dtlMaxSeq, tmlAgmtVerNoNew);	//, tpSzRowset );
							
							insertDtlList	= (List<TesTmlAgmtDtlVO>) insertList.get(0);	// insertStorageAgreementDTLInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );
							insertTpSzList	= (List<TesTmlAgmtTpSzVO>) insertList.get(1);	// insertStorageAgreementTPSZInsertSet	( event, tpSzRowset, dtlMaxSeq, tmlAgmtVerNoNew );
							insertAplyList	= (List<TesTmlAgmtAplyDyVO>) insertList.get(2);	// insertStorageAgreementAPLYDYInsertSet( event, dtlMaxSeq, tmlAgmtVerNoNew );
							insertDgCgoList	= (List<TesTmlAgmtDgCgoClssVO>) insertList.get(3);	// insertStorageAgreementDGCGOInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );
						}
						
						dbDao.insertStorageAgreementDTLInsert	(insertDtlList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementTPSZInsert	(insertTpSzList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementAPLYDYInsert(insertAplyList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementDGCGOInsert	(insertDgCgoList, event.getSignOnUserAccount().getOfc_cd());
						
					}

					selectDtlList = dbDao.searchThrpTerminalAgreement(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew);
					
					thrpMaxSeq = dbDao.insertAgmtListThrpSeq(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew );
					
					// Throughput Insert 하기 위한 List VO 설정.
					insertThrpList	= insertAgmtListThrpInsertSet( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew, selectDtlList, tesTmlAgmtHdrVO, thrpMaxSeq );
					
					if ( insertThrpList.size() > 0 ) {
						dbDao.insertAgmtListThrpInsert( insertThrpList, event.getSignOnUserAccount().getOfc_cd() );
					}
					
					dbRowset = dbDao.insertAgmtListThrpList( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNoNew );
					
					if ( dbRowset != null ) {
						while ( dbRowset.next() ) {
							tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
							
							tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(dbRowset.getString("tml_agmt_ofc_cty_cd"));
							tesTmlAgmtDtlVO.setTmlAgmtSeq		(dbRowset.getString("tml_agmt_seq"));
							tesTmlAgmtDtlVO.setTmlAgmtVerNo		(dbRowset.getString("tml_agmt_ver_no"));
							tesTmlAgmtDtlVO.setLgsCostCd		(dbRowset.getString("lgs_cost_cd"));
							tesTmlAgmtDtlVO.setThrpLgsCostCd	(dbRowset.getString("thrp_lgs_cost_cd"));
							updateDtlList.add(tesTmlAgmtDtlVO);
						}
					}
					
					if ( updateDtlList.size() > 0 ) {
						dbDao.insertAgmtListThrpUpdate(updateDtlList);
					}
					
		    		agmtVer = n1stNoNew+"."+n2ndNoNew;

				} else if("N".equals( invoiceUseFlg ) ) {
					//1. STS_CD 'P'로 수정
					dbDao.modifySTSAgreement(tesTmlAgmtHdrVO, event.getSignOnUserAccount().getOfc_cd());
					
					//2. Agreement 데이터 delete  --- 수정 해야 함 버전 no도 넘겨야 함
					tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
					tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	( event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3) );
					tesTmlAgmtDtlVO.setTmlAgmtSeq		( event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8) );
					tesTmlAgmtDtlVO.setTmlAgmtVerNo		( tmlAgmtVerNo );
					tesTmlAgmtDtlVO.setTmlAgmtTpCd		( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() );
		    		dbDao.deleteAgreement_modifyDelete01( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete02( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete03( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete04( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete05( tesTmlAgmtDtlVO );

					//3. Agreement 데이터 insert
		    		if( "T".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ) {
						dtlMaxSeq	= dbDao.insertTerminalAgreementSeq	( event.getTesTmlAgmtDtlVO(), tmlAgmtVerNo );
						insertList	= insertTerminalAgreementInsertSet(event, dtlMaxSeq, tmlAgmtVerNo);	//, tpSzRowset );
						
						insertDtlList	= (List<TesTmlAgmtDtlVO>)insertList.get(0);
						insertTpSzList	= (List<TesTmlAgmtTpSzVO>)insertList.get(1);
						insertAplyList	= (List<TesTmlAgmtAplyDyVO>)insertList.get(2);
						insertDgCgoList	= (List<TesTmlAgmtDgCgoClssVO>)insertList.get(3);
						
						dbDao.insertTerminalAgreementDTLInsert		(insertDtlList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementTPSZInsert		(insertTpSzList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementAPLYDYInsert	(insertAplyList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementDGCGOInsert	(insertDgCgoList, event.getSignOnUserAccount().getOfc_cd());

						
					}else if( "S".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ) {
						dtlMaxSeq	= dbDao.insertTerminalAgreementSeq	( event.getTesTmlAgmtDtlVO(), tmlAgmtVerNo );
						
						if ( event.getTesTmlAgmtDtlVOs()!=null && event.getTesTmlAgmtDtlVOs().length > 0 ) {
							insertList	= insertStorageAgreementInsertSet(event, dtlMaxSeq, tmlAgmtVerNo);	//, tpSzRowset );
							
							insertDtlList	= (List<TesTmlAgmtDtlVO>) insertList.get(0);	// insertStorageAgreementDTLInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );
							insertTpSzList	= (List<TesTmlAgmtTpSzVO>) insertList.get(1);	// insertStorageAgreementTPSZInsertSet	( event, tpSzRowset, dtlMaxSeq, tmlAgmtVerNoNew );
							insertAplyList	= (List<TesTmlAgmtAplyDyVO>) insertList.get(2);	// insertStorageAgreementAPLYDYInsertSet( event, dtlMaxSeq, tmlAgmtVerNoNew );
							insertDgCgoList	= (List<TesTmlAgmtDgCgoClssVO>) insertList.get(3);	// insertStorageAgreementDGCGOInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );

						}						
						dbDao.insertStorageAgreementDTLInsert	(insertDtlList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementTPSZInsert	(insertTpSzList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementAPLYDYInsert(insertAplyList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementDGCGOInsert	(insertDgCgoList, event.getSignOnUserAccount().getOfc_cd());

					}
					selectDtlList = dbDao.searchThrpTerminalAgreement(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo);

					thrpMaxSeq = dbDao.insertAgmtListThrpSeq(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo );
					
					// Throughput Insert 하기 위한 List VO 설정.
					insertThrpList	= insertAgmtListThrpInsertSet( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, selectDtlList, tesTmlAgmtHdrVO, thrpMaxSeq );
					
					if ( insertThrpList.size() > 0 ) {
						dbDao.insertAgmtListThrpInsert( insertThrpList, event.getSignOnUserAccount().getOfc_cd() );
					}
					
					dbRowset = dbDao.insertAgmtListThrpList( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo );
					
					if ( dbRowset != null ) {
						while ( dbRowset.next() ) {
							tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
							
							tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(dbRowset.getString("tml_agmt_ofc_cty_cd"));
							tesTmlAgmtDtlVO.setTmlAgmtSeq		(dbRowset.getString("tml_agmt_seq"));
							tesTmlAgmtDtlVO.setTmlAgmtVerNo		(dbRowset.getString("tml_agmt_ver_no"));
							tesTmlAgmtDtlVO.setLgsCostCd		(dbRowset.getString("lgs_cost_cd"));
							tesTmlAgmtDtlVO.setThrpLgsCostCd	(dbRowset.getString("thrp_lgs_cost_cd"));
							updateDtlList.add(tesTmlAgmtDtlVO);
						}
					}
					
					if ( updateDtlList.size() > 0 ) {
						dbDao.insertAgmtListThrpUpdate(updateDtlList);
					}
					
		    		agmtVer = n1stNo+"."+n2ndNo;
				}
				
				
			} else if("P".equals(tmlAgmtStsCd)) {
				//1. HDR정보 수정
				dbDao.modifyTerminalAgreementInfo( tesTmlAgmtHdrVO, event.getSignOnUserAccount().getOfc_cd() );

				if ( "1".equals( event.getTesAgreementManageCommonVO().getSelectTab()) || "3".equals( event.getTesAgreementManageCommonVO().getSelectTab()) ) {
					//2. Agreement 데이터 delete
					tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
					
					tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	( event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(0, 3) );
					tesTmlAgmtDtlVO.setTmlAgmtSeq		( event.getTesTmlAgmtDtlVO().getTmlAgmtOfcCtyCd().substring(3, 8) );
					tesTmlAgmtDtlVO.setTmlAgmtVerNo		( tmlAgmtVerNo );
					tesTmlAgmtDtlVO.setTmlAgmtTpCd		( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() );
		    		dbDao.deleteAgreement_modifyDelete01( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete02( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete03( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete04( tesTmlAgmtDtlVO );
		    		dbDao.deleteAgreement_modifyDelete05( tesTmlAgmtDtlVO );

					//3. Agreement 데이터 insert
		    		if( "T".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ) {
						dtlMaxSeq	= dbDao.insertTerminalAgreementSeq	( event.getTesTmlAgmtDtlVO(), tmlAgmtVerNo );
						insertList	= insertTerminalAgreementInsertSet(event, dtlMaxSeq, tmlAgmtVerNo);	//, tpSzRowset );
						
						insertDtlList	= (List<TesTmlAgmtDtlVO>)insertList.get(0);
						insertTpSzList	= (List<TesTmlAgmtTpSzVO>)insertList.get(1);
						insertAplyList	= (List<TesTmlAgmtAplyDyVO>)insertList.get(2);
						insertDgCgoList	= (List<TesTmlAgmtDgCgoClssVO>)insertList.get(3);

						dbDao.insertTerminalAgreementDTLInsert		(insertDtlList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementTPSZInsert		(insertTpSzList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementAPLYDYInsert	(insertAplyList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertTerminalAgreementDGCGOInsert	(insertDgCgoList, event.getSignOnUserAccount().getOfc_cd());
		    			
		    		} else if( "S".equals( event.getTesAgreementManageCommonVO().getTmlAgmtTpCd() ) ) {
						dtlMaxSeq	= dbDao.insertTerminalAgreementSeq	( event.getTesTmlAgmtDtlVO(), tmlAgmtVerNo );

						if ( event.getTesTmlAgmtDtlVOs() !=null && event.getTesTmlAgmtDtlVOs().length > 0 ) {
							insertList	= insertStorageAgreementInsertSet(event, dtlMaxSeq, tmlAgmtVerNo);	//, tpSzRowset );
							
							insertDtlList	= (List<TesTmlAgmtDtlVO>) insertList.get(0);	// insertStorageAgreementDTLInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );
							insertTpSzList	= (List<TesTmlAgmtTpSzVO>) insertList.get(1);	// insertStorageAgreementTPSZInsertSet	( event, tpSzRowset, dtlMaxSeq, tmlAgmtVerNoNew );
							insertAplyList	= (List<TesTmlAgmtAplyDyVO>) insertList.get(2);	// insertStorageAgreementAPLYDYInsertSet( event, dtlMaxSeq, tmlAgmtVerNoNew );
							insertDgCgoList	= (List<TesTmlAgmtDgCgoClssVO>) insertList.get(3);	// insertStorageAgreementDGCGOInsertSet	( event, dtlMaxSeq, tmlAgmtVerNoNew );

						}
						dbDao.insertStorageAgreementDTLInsert	(insertDtlList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementTPSZInsert	(insertTpSzList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementAPLYDYInsert(insertAplyList	, event.getSignOnUserAccount().getOfc_cd());
						dbDao.insertStorageAgreementDGCGOInsert	(insertDgCgoList, event.getSignOnUserAccount().getOfc_cd());
					}
				}
				selectDtlList = dbDao.searchThrpTerminalAgreement(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo);

				thrpMaxSeq = dbDao.insertAgmtListThrpSeq(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo );
				
				// Throughput Insert 하기 위한 List VO 설정.
				insertThrpList	= insertAgmtListThrpInsertSet( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, selectDtlList, tesTmlAgmtHdrVO, thrpMaxSeq );
				
				if ( insertThrpList.size() > 0 ) {
					dbDao.insertAgmtListThrpInsert( insertThrpList, event.getSignOnUserAccount().getOfc_cd() );
				}
				
				dbRowset = dbDao.insertAgmtListThrpList( tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo );
				
				if ( dbRowset != null ) {
					while ( dbRowset.next() ) {
						tesTmlAgmtDtlVO	= new TesTmlAgmtDtlVO();
						
						tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd	(dbRowset.getString("tml_agmt_ofc_cty_cd"));
						tesTmlAgmtDtlVO.setTmlAgmtSeq		(dbRowset.getString("tml_agmt_seq"));
						tesTmlAgmtDtlVO.setTmlAgmtVerNo		(dbRowset.getString("tml_agmt_ver_no"));
						tesTmlAgmtDtlVO.setLgsCostCd		(dbRowset.getString("lgs_cost_cd"));
						tesTmlAgmtDtlVO.setThrpLgsCostCd	(dbRowset.getString("thrp_lgs_cost_cd"));
						updateDtlList.add(tesTmlAgmtDtlVO);
					}
				}
				
				if ( updateDtlList.size() > 0 ) {
					dbDao.insertAgmtListThrpUpdate(updateDtlList);
				}

	    		agmtVer = n1stNo + "." + n2ndNo;
			} else if("agmtRmk".equals( agmtConfirmFlg ) ) {
				//	1. HDR정보 수정
				dbDao.modifyTerminalAgreementInfo( tesTmlAgmtHdrVO, event.getSignOnUserAccount().getOfc_cd() );
				
				agmtVer = n1stNo + "." + n2ndNo;
			}
			eventResponse.setETCData( "agmt_ver", agmtVer );
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (SQLException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} 
	}

	
	/**
	 * Agreement Detail Delete 하기 위한 List Vo 설정 처리.<br>
	 * 
	 * @param tesTmlAgmtDtlVOs
	 * @param tesTmlAgmtHdrVO
	 * @param tmlAgmtVerNo
	 * @return insertList
	 * @exception EventException
	 */
	public List<TesTmlAgmtDtlVO> removeAgreementDTLSet(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String tmlAgmtVerNo) throws EventException{
		
		TesTmlAgmtDtlVO			tesTmlAgmtDtlVO		= null;
		List<TesTmlAgmtDtlVO>	deleteList			= new ArrayList<TesTmlAgmtDtlVO>();
		
		String					tmlAgmtOfcCtyCd		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3);
		String					tmlAgmtSeq			= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8);
	
		try {
			
			for( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
				if ( "".equals( tmlAgmtVerNo ) ) {
					tmlAgmtVerNo	= tesTmlAgmtDtlVOs[i].getTmlAgmtVerNo();
				}
				
				if ( tesTmlAgmtDtlVOs[i].getIbflag().length() > 0 ) {
					tesTmlAgmtDtlVO		= new TesTmlAgmtDtlVO();
					
					tesTmlAgmtDtlVO.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd);
					tesTmlAgmtDtlVO.setTmlAgmtSeq(tmlAgmtSeq);
					tesTmlAgmtDtlVO.setTmlAgmtVerNo(tmlAgmtVerNo);
					tesTmlAgmtDtlVO.setTmlAgmtDtlSeq(tesTmlAgmtDtlVOs[i].getTmlAgmtDtlSeq());
					deleteList.add(tesTmlAgmtDtlVO);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

		return deleteList;
	}
	
	/**
	 * Agreement Type Size Delete 하기 위한 List Vo 설정 처리.<br>
	 * 
	 * @param tesTmlAgmtDtlVOs TesTmlAgmtDtlVO[]
	 * @param tesTmlAgmtHdrVO TesTmlAgmtHdrVO
	 * @param tmlAgmtVerNo String
	 * @return insertList List<TesTmlAgmtTpSzVO>
	 * @exception EventException
	 */
	public List<TesTmlAgmtTpSzVO> removeAgreementTPSZSet(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String tmlAgmtVerNo) throws EventException{
		
		TesTmlAgmtTpSzVO		tesTmlAgmtTpSzVO	= null;
		List<TesTmlAgmtTpSzVO>	deleteList			= new ArrayList<TesTmlAgmtTpSzVO>();
		
		String					tmlAgmtOfcCtyCd		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3);
		String					tmlAgmtSeq			= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8);
	
		try {
			
			for( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
				if ( "".equals( tmlAgmtVerNo ) ) {
					tmlAgmtVerNo	= tesTmlAgmtDtlVOs[i].getTmlAgmtVerNo();
				}
				
				if ( tesTmlAgmtDtlVOs[i].getIbflag().length() > 0 ) {
					tesTmlAgmtTpSzVO	= new TesTmlAgmtTpSzVO();
					
					tesTmlAgmtTpSzVO.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd);
					tesTmlAgmtTpSzVO.setTmlAgmtSeq(tmlAgmtSeq);
					tesTmlAgmtTpSzVO.setTmlAgmtVerNo(tmlAgmtVerNo);
					tesTmlAgmtTpSzVO.setTmlAgmtDtlSeq(tesTmlAgmtDtlVOs[i].getTmlAgmtDtlSeq());
					deleteList.add(tesTmlAgmtTpSzVO);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

		return deleteList;
	}
	
	/**
	 * Agreement Apply Day Delete 하기 위한 List Vo 설정 처리.<br>
	 * 
	 * @param tesTmlAgmtDtlVOs
	 * @param tesTmlAgmtHdrVO
	 * @param tmlAgmtVerNo
	 * @return insertList List<TesTmlAgmtAplyDyVO>
	 * @exception EventException
	 */
	public List<TesTmlAgmtAplyDyVO> removeAgreementAPLYDYSet(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String tmlAgmtVerNo) throws EventException{
		
		TesTmlAgmtAplyDyVO			tesTmlAgmtAplyDyVO	= null;
		List<TesTmlAgmtAplyDyVO>	deleteList			= new ArrayList<TesTmlAgmtAplyDyVO>();
		
		String					tmlAgmtOfcCtyCd		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3);
		String					tmlAgmtSeq			= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8);
	
		try {
			
			for( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
				if ( "".equals( tmlAgmtVerNo ) ) {
					tmlAgmtVerNo	= tesTmlAgmtDtlVOs[i].getTmlAgmtVerNo();
				}
				
				if ( tesTmlAgmtDtlVOs[i].getIbflag().length() > 0 ) {
					tesTmlAgmtAplyDyVO	= new TesTmlAgmtAplyDyVO();
					
					tesTmlAgmtAplyDyVO.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd);
					tesTmlAgmtAplyDyVO.setTmlAgmtSeq(tmlAgmtSeq);
					tesTmlAgmtAplyDyVO.setTmlAgmtVerNo(tmlAgmtVerNo);
					tesTmlAgmtAplyDyVO.setTmlAgmtDtlSeq(tesTmlAgmtDtlVOs[i].getTmlAgmtDtlSeq());
					deleteList.add(tesTmlAgmtAplyDyVO);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

		return deleteList;
	}
	
	/**
	 * Agreement Throughput Cost 에 Delete 하기 위한 List Vo 설정 처리.<br>
	 * 
	 * @param tesTmlAgmtDtlVOs
	 * @param tesTmlAgmtHdrVO
	 * @param tmlAgmtVerNo
	 * @return insertList List<TesTmlAgmtDgCgoClssVO>
	 * @exception EventException
	 */
	public List<TesTmlAgmtDgCgoClssVO> removeAgreementTHRPCOSTSet(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String tmlAgmtVerNo) throws EventException{
		
		TesTmlAgmtDgCgoClssVO	tesTmlAgmtDgCgoClssVO	= null;

		List<TesTmlAgmtDgCgoClssVO>	deleteList		= new ArrayList<TesTmlAgmtDgCgoClssVO>();
		
		String					tmlAgmtOfcCtyCd		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3);
		String					tmlAgmtSeq			= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8);
	
		try {
			
			for( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
				if ( "".equals( tmlAgmtVerNo ) ) {
					tmlAgmtVerNo	= tesTmlAgmtDtlVOs[i].getTmlAgmtVerNo();
				}
				
				if ( tesTmlAgmtDtlVOs[i].getIbflag().length() > 0 ) {
					tesTmlAgmtDgCgoClssVO	= new TesTmlAgmtDgCgoClssVO();
					
					tesTmlAgmtDgCgoClssVO.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd);
					tesTmlAgmtDgCgoClssVO.setTmlAgmtSeq(tmlAgmtSeq);
					tesTmlAgmtDgCgoClssVO.setTmlAgmtVerNo(tmlAgmtVerNo);
					tesTmlAgmtDgCgoClssVO.setTmlAgmtDtlSeq(tesTmlAgmtDtlVOs[i].getTmlAgmtDtlSeq());
					deleteList.add(tesTmlAgmtDgCgoClssVO);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

		return deleteList;
	}
	
	/**
	 * Agreement DG Cargo Class Delete 하기 위한 List Vo 설정 처리.<br>
	 * 
	 * @param tesTmlAgmtDtlVOs
	 * @param tesTmlAgmtHdrVO
	 * @param tmlAgmtVerNo
	 * @return insertList List<TesTmlAgmtDgCgoClssVO>
	 * @exception EventException
	 */
	public List<TesTmlAgmtDgCgoClssVO> removeAgreementDGCGOSet(TesTmlAgmtDtlVO[] tesTmlAgmtDtlVOs, TesTmlAgmtHdrVO tesTmlAgmtHdrVO, String tmlAgmtVerNo) throws EventException{
		
		TesTmlAgmtDgCgoClssVO		tesTmlAgmtDgCgoClssVO	= null;
		List<TesTmlAgmtDgCgoClssVO>	deleteList				= new ArrayList<TesTmlAgmtDgCgoClssVO>();
		
		
		String tmlAgmtOfcCtyCd	= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(0, 3);
		String tmlAgmtSeq		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd().substring(3, 8);
	
		try {
			
			for( int i = 0; tesTmlAgmtDtlVOs!=null && i < tesTmlAgmtDtlVOs.length; i++ ) {
				if ( "".equals( tmlAgmtVerNo ) ) {
					tmlAgmtVerNo	= tesTmlAgmtDtlVOs[i].getTmlAgmtVerNo();
				}
				
				if ( tesTmlAgmtDtlVOs[i].getIbflag().length() > 0 ) {
					tesTmlAgmtDgCgoClssVO	= new TesTmlAgmtDgCgoClssVO();
					
					tesTmlAgmtDgCgoClssVO.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd);
					tesTmlAgmtDgCgoClssVO.setTmlAgmtSeq(tmlAgmtSeq);
					tesTmlAgmtDgCgoClssVO.setTmlAgmtVerNo(tmlAgmtVerNo);
					tesTmlAgmtDgCgoClssVO.setTmlAgmtDtlSeq(tesTmlAgmtDtlVOs[i].getTmlAgmtDtlSeq());
					deleteList.add(tesTmlAgmtDgCgoClssVO);
				}
			}
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

		return deleteList;
	}
	
	/**
	 * Agreement Info Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeAgreement(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;

		List<TesTmlAgmtDtlVO>		deleteDtlList	= new ArrayList<TesTmlAgmtDtlVO>();
		List<TesTmlAgmtTpSzVO>		deleteTpSzList	= new ArrayList<TesTmlAgmtTpSzVO>();
		List<TesTmlAgmtAplyDyVO>	deleteAplyList	= new ArrayList<TesTmlAgmtAplyDyVO>();
		List<TesTmlAgmtDgCgoClssVO>	deleteCostList	= new ArrayList<TesTmlAgmtDgCgoClssVO>();
		List<TesTmlAgmtDgCgoClssVO>	deleteDgCgoList	= new ArrayList<TesTmlAgmtDgCgoClssVO>();

		GeneralEventResponse		eventResponse	= new GeneralEventResponse();

		TesTmlAgmtHdrVO				tesTmlAgmtHdrVO	= event.getTesTmlAgmtHdrVO();
		
		String			tmlAgmtNo		= tesTmlAgmtHdrVO.getTmlAgmtOfcCtyCd();
		String			tmlAgmtStsCd	= tesTmlAgmtHdrVO.getTmlAgmtStsCd();
		String			tmlAgmtOfcCtyCd	= tmlAgmtNo.substring(0, 3);
		String			tmlAgmtSeq		= tmlAgmtNo.substring(3, 8);
		String			tmlAgmtVerNo	= tesTmlAgmtHdrVO.getTmlAgmtVerNo();
		String			n1stNo			= tmlAgmtVerNo.substring(0,2);
		String			n1stNoNew		= n1stNo;
		String			n2ndNo			= tmlAgmtVerNo.substring(3,5);
		String			n2ndNoNew		= String.valueOf( Integer.parseInt(n2ndNo) + 1 );
		n2ndNoNew	= JSPUtil.customString( "", 2-JSPUtil.getNull(n2ndNoNew).length()) + n2ndNoNew;
		tmlAgmtVerNo= n1stNo + n2ndNo;

		String			maxVer			= "";
		String			agmtVer			= "";
		String			invoiceUseFlg	= "";
		String			tmlAgmtVerNoNew	= "";

		try {
			invoiceUseFlg	= dbDao.searchInvoiceHDR(tmlAgmtNo, tmlAgmtVerNo);
			maxVer = dbDao.searchMaxAgmtVer(tmlAgmtNo);
			
			if ( "C".equals( tmlAgmtStsCd ) ) {
				if( "Y".equals(invoiceUseFlg) ) {
					//1. 기존 버전 Agreement 데이터 새로 insert
					//   HDR 버전 레벨 UP
					//   STS_CD 'P'로 수정
					n1stNoNew = maxVer.substring(0, 2);
					n2ndNoNew = String.valueOf(Integer.parseInt(maxVer.substring(2, 4)) + 1);
					n2ndNoNew = JSPUtil.customString("", 2-JSPUtil.getNull(n2ndNoNew).length()) + n2ndNoNew;
					tmlAgmtVerNoNew	= n1stNoNew + n2ndNoNew; 

		    		dbDao.agreementHistoryHDR	(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, tesTmlAgmtHdrVO,
							"N", "Y", event.getSignOnUserAccount().getOfc_cd(), event.getSignOnUserAccount().getUsr_id() );
					dbDao.agreementHistoryDTL	(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id() );
					dbDao.agreementHistoryTS	(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryAD	(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryDCC	(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					dbDao.agreementHistoryThrp	(tmlAgmtOfcCtyCd, tmlAgmtSeq, tmlAgmtVerNo, tmlAgmtVerNoNew, event.getSignOnUserAccount().getOfc_cd(),
							event.getSignOnUserAccount().getUsr_id());
					
		    		//2. Agreement 데이터 delete --- 수정 해야 함 버전 no도 넘겨야 함
					deleteDtlList	= removeAgreementDTLSet		( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNoNew);
					deleteTpSzList	= removeAgreementTPSZSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNoNew);
					deleteAplyList	= removeAgreementAPLYDYSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNoNew);
					deleteCostList	= removeAgreementTHRPCOSTSet( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNoNew);
					deleteDgCgoList	= removeAgreementDGCGOSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNoNew);
					
					if ( deleteTpSzList.size() > 0 ) {
						dbDao.removeAgreementTPSZ(deleteTpSzList);
					}
					
					if ( deleteAplyList.size() > 0 ) {
						dbDao.removeAgreementAPLYDY(deleteAplyList);
					}
					
					if ( deleteCostList.size() > 0 ) {
						dbDao.removeAgreementTHRPCOST(deleteCostList);
					}
					
					if ( deleteDgCgoList.size() > 0 ) {
						dbDao.removeAgreementDGCGO(deleteDgCgoList);
					}
					
					if ( deleteDtlList.size() > 0 ) {
						dbDao.removeAgreementDTL(deleteDtlList);
					}

		    		agmtVer = n1stNoNew + "." + n2ndNoNew;
				} else if ( "N".equals( invoiceUseFlg ) ) {
					
					dbDao.modifySTSAgreement(event.getTesTmlAgmtHdrVO(), event.getSignOnUserAccount().getOfc_cd());

					deleteDtlList	= removeAgreementDTLSet		( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
					deleteTpSzList	= removeAgreementTPSZSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
					deleteAplyList	= removeAgreementAPLYDYSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
					deleteCostList	= removeAgreementTHRPCOSTSet( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
					deleteDgCgoList	= removeAgreementDGCGOSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
					
					if ( deleteTpSzList.size() > 0 ) {
						dbDao.removeAgreementTPSZ(deleteTpSzList);
					}
					
					if ( deleteAplyList.size() > 0 ) {
						dbDao.removeAgreementAPLYDY(deleteAplyList);
					}
					
					if ( deleteCostList.size() > 0 ) {
						dbDao.removeAgreementTHRPCOST(deleteCostList);
					}
					
					if ( deleteDgCgoList.size() > 0 ) {
						dbDao.removeAgreementDGCGO(deleteDgCgoList);
					}
					
					if ( deleteDtlList.size() > 0 ) {
						dbDao.removeAgreementDTL(deleteDtlList);
					}

					agmtVer = n1stNo + "." + n2ndNo;
				}
			} else if ( "P".equals( tmlAgmtStsCd ) ) {
				
				deleteDtlList	= removeAgreementDTLSet		( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
				deleteTpSzList	= removeAgreementTPSZSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
				deleteAplyList	= removeAgreementAPLYDYSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
				deleteCostList	= removeAgreementTHRPCOSTSet( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
				deleteDgCgoList	= removeAgreementDGCGOSet	( event.getTesTmlAgmtDtlVOs(), event.getTesTmlAgmtHdrVO(), tmlAgmtVerNo);
				
				if ( deleteTpSzList.size() > 0 ) {
					dbDao.removeAgreementTPSZ(deleteTpSzList);
				}
				
				if ( deleteAplyList.size() > 0 ) {
					dbDao.removeAgreementAPLYDY(deleteAplyList);
				}
				
				if ( deleteCostList.size() > 0 ) {
					dbDao.removeAgreementTHRPCOST(deleteCostList);
				}
				
				if ( deleteDgCgoList.size() > 0 ) {
					dbDao.removeAgreementDGCGO(deleteDgCgoList);
				}

				if ( deleteDtlList.size() > 0 ) {
					dbDao.removeAgreementDTL(deleteDtlList);
				}
				
				agmtVer = n1stNo + "." + n2ndNo;
			}
			eventResponse.setETCData("agmt_ver", agmtVer);

			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}




	//===== Vol. Accumulate Method ========================================================

	//----- Method ------------------------------------------------------------------------
	/**
	 * Volume Accumulate Method 조회 이벤트 처리<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVolumeAccumulatedMethod(Event e) throws EventException{

		List<DBRowSet>			rsVoList		= new ArrayList<DBRowSet>();
		EsdTes9200Event			event			= (EsdTes9200Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			rsVoList.add( dbDao.searchVolumeAccumulatedMethod		(event.getTesAgreementManageCommonVO() ) );
			rsVoList.add( dbDao.searchListVolumeAccumulatedCostCode	(event.getTesAgreementManageCommonVO() ) );
			rsVoList.add( dbDao.searchListVolumeAccumulatedYard		(event.getTesAgreementManageCommonVO() ) );
			
			eventResponse.setRsList(rsVoList);
			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	/**
	 * Volume Accumulate Method Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeVolumeAccumulatedMethod(Event e) throws EventException{

		EsdTes9200Event		event	= (EsdTes9200Event)e;

		try {
			if(log.isDebugEnabled()) log.debug("\n[TerminalAgreementManageBCImpl][removeVolumeAccumulatedMethod] >>>>>>>>>>> START");
			dbDao.removeVolumeAccumulatedMethod(event.getTesAgreementManageCommonVO());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Volume Accumulate Method Insert, Update, Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedMethod(Event e) throws EventException{

		EsdTes9200Event				event				= (EsdTes9200Event)e;
		
		List<TesTmlSoAccmMzdVO>		insertList			= new ArrayList<TesTmlSoAccmMzdVO>();
		List<TesTmlSoAccmMzdVO>		updateList			= new ArrayList<TesTmlSoAccmMzdVO>();
		List<TesTmlSoAccmMzdVO>		deleteList			= new ArrayList<TesTmlSoAccmMzdVO>();

		TesTmlSoAccmMzdVO	[]		tesTmlSoAccmMzdVOs	= null;

		try {
			
			tesTmlSoAccmMzdVOs	= event.getTesTmlSoAccmMzdVOs();
			
			
			if ( tesTmlSoAccmMzdVOs != null ) {
				
				for( int i = 0; i < tesTmlSoAccmMzdVOs.length; i++ ) {
					if ( "I".equals( tesTmlSoAccmMzdVOs[i].getIbflag() ) ) {
						tesTmlSoAccmMzdVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmMzdVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						tesTmlSoAccmMzdVOs[i].setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
						tesTmlSoAccmMzdVOs[i].setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
						insertList.add( tesTmlSoAccmMzdVOs[i] );
						
					} else if ( "U".equals( tesTmlSoAccmMzdVOs[i].getIbflag() ) ) {
						tesTmlSoAccmMzdVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmMzdVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						tesTmlSoAccmMzdVOs[i].setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
						tesTmlSoAccmMzdVOs[i].setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
						updateList.add( tesTmlSoAccmMzdVOs[i] );
						
					} else if ( "D".equals( tesTmlSoAccmMzdVOs[i].getIbflag() ) ) {
						tesTmlSoAccmMzdVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmMzdVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						deleteList.add( tesTmlSoAccmMzdVOs[i] );
					}
				}
				
	
				if ( insertList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedMethodInsert(event.getTesAgreementManageCommonVO(), insertList );
				}
				
				if ( updateList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedMethodUpdate(event.getTesAgreementManageCommonVO(), updateList );
				}
				
				if ( deleteList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedMethodDelete(deleteList );
				}
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * Volume Accumulate Method Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeVolumeAccumulate(Event e) throws EventException{

		EsdTes9200Event		event	= (EsdTes9200Event)e;

		try {
			if(log.isDebugEnabled())log.debug("\n[TerminalAgreementManageBCImpl][removeVolumeAccumulate] >>>>>>>>>> START");

			dbDao.removeVolumeAccm(event.getTesAgreementManageCommonVO());
			dbDao.removeListVolumeAccumulatedCostCode	(event.getTesAgreementManageCommonVO());
			dbDao.removeListVolumeAccumulatedYard		(event.getTesAgreementManageCommonVO());
			dbDao.removeVolumeAccumulatedMethod			(event.getTesAgreementManageCommonVO());
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}



	//----- Cost Code ---------------------------------------------------------------------

	/**
	 * Volume Accumulate CostCode List Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeListVolumeAccumulatedCostCode(Event e) throws EventException{

		EsdTes9200Event		event	= (EsdTes9200Event)e;

		try {
			dbDao.removeListVolumeAccumulatedCostCode(event.getTesAgreementManageCommonVO());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}

	/**
	 * Volume Accumulate CostCode List Insert.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedCostCode(Event e) throws EventException{

		EsdTes9200Event		event	= (EsdTes9200Event)e;

		List<TesTmlSoAccmCostVO>	insertList	= new ArrayList<TesTmlSoAccmCostVO>();
		TesTmlSoAccmCostVO	[]		tesTmlSoAccmCostVOs	= null;
		
		try {
			tesTmlSoAccmCostVOs	= event.getTesTmlSoAccmCostVOs();
				
			if ( tesTmlSoAccmCostVOs != null ) {
				
				for( int i = 0; i < tesTmlSoAccmCostVOs.length; i++ ) {
					if ( "I".equals( tesTmlSoAccmCostVOs[i].getIbflag() ) ) {
						tesTmlSoAccmCostVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmCostVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						tesTmlSoAccmCostVOs[i].setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
						tesTmlSoAccmCostVOs[i].setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
						insertList.add( tesTmlSoAccmCostVOs[i] );
					}
				}
				
				if ( insertList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedCostCode(event.getTesAgreementManageCommonVO(), insertList );
				}
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	/**
	 * Volume Accumulate Method Uom 조회 이벤트 처리<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchVolumeAccumulatedMethodUom(Event e) throws EventException{
//		EsdTes9200Event		event	= (EsdTes9200Event)e;
//		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
//		
//		String accmUomFlg = "";
//		
//		try {
//			accmUomFlg = dbDao.searchVolumeAccumulatedMethodUom(event.getTesAgreementManageCommonVO().getVndrSeq(), 
//					                                           event.getTesAgreementManageCommonVO().getYdCd(),
//					                                           event.getTesTmlSoAccmMzdVO().getTmlAccmUtCd(),
//					                                           event.getTesTmlSoAccmCostVO().getLgsCostCd());
//			 
//			 eventResponse.setETCData("accmUomFlg", accmUomFlg);
//			 return eventResponse;
//		} catch (DAOException de) {
//			log.error("err "+de.toString(),de);
//			throw new EventException(de.getMessage());
//		}		
//	}

	//----- Yard ---------------------------------------------------------------------

	/**
	 * Volume Accumulate Yard List Insert, Update, Delete.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulatedYard(Event e) throws EventException{

		EsdTes9200Event				event				= (EsdTes9200Event)e;

		List<TesTmlSoAccmYdVO>		insertList			= new ArrayList<TesTmlSoAccmYdVO>();
		List<TesTmlSoAccmYdVO>		updateList			= new ArrayList<TesTmlSoAccmYdVO>();
		List<TesTmlSoAccmYdVO>		deleteList			= new ArrayList<TesTmlSoAccmYdVO>();

		TesTmlSoAccmYdVO	[]		tesTmlSoAccmYdVOs	= null;

		try {
			tesTmlSoAccmYdVOs	= event.getTesTmlSoAccmYdVOs();
			
			if ( tesTmlSoAccmYdVOs != null ) {
				
				for( int i = 0; i < tesTmlSoAccmYdVOs.length; i++ ) {
					if ( "I".equals( tesTmlSoAccmYdVOs[i].getIbflag() ) ) {
						tesTmlSoAccmYdVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmYdVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						tesTmlSoAccmYdVOs[i].setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
						tesTmlSoAccmYdVOs[i].setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
						insertList.add( tesTmlSoAccmYdVOs[i] );
						
					} else if ( "U".equals( tesTmlSoAccmYdVOs[i].getIbflag() ) ) {
						tesTmlSoAccmYdVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmYdVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						tesTmlSoAccmYdVOs[i].setCreUsrId( event.getSignOnUserAccount().getUsr_id() );
						tesTmlSoAccmYdVOs[i].setUpdUsrId( event.getSignOnUserAccount().getUsr_id() );
						updateList.add( tesTmlSoAccmYdVOs[i] );
						
					} else if ( "D".equals( tesTmlSoAccmYdVOs[i].getIbflag() ) ) {
						tesTmlSoAccmYdVOs[i].setVndrSeq( event.getTesAgreementManageCommonVO().getVndrSeq() );
						tesTmlSoAccmYdVOs[i].setAccmSeq( event.getTesAgreementManageCommonVO().getAccmSeq() );
						deleteList.add( tesTmlSoAccmYdVOs[i] );
					}
				}
				
	
				if ( insertList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedYardInsert(event.getTesAgreementManageCommonVO(), insertList );
				}
				
				if ( updateList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedYardUpdate(event.getTesAgreementManageCommonVO(), updateList );
				}
				
				if ( deleteList.size() > 0 ) {
					dbDao.multiVolumeAccumulatedYardDelete(deleteList );
				}
			}
			
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}

	/**************************************************************************************
	 * kimjinjoo부분 시작
	 *************************************************************************************/



	/*******	  TerminalAgreement 조회화면 -Detail(Terminal Rate) 시작 		*********/



	/**
	 * Agreement No (Header) Info Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementManage(Event e) throws EventException {
		
		EsdTes0040Event			event			= (EsdTes0040Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try {
			
			eventResponse.setRs( dbDao.searchTerminalAgreementManage(event) );
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * Agreement No (Terminal Rate List, Storage Rate List) Info Select.<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalAgreementTerminalRateDetail(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n\n [TerminalAgreementManageBCImp][searchTerminalAgreementTerminalRate(Detail)]");

		List<DBRowSet>			rsVoList		= new ArrayList<DBRowSet>();
		EsdTes0040Event			event			= (EsdTes0040Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		
		try {
			
			rsVoList.add( dbDao.searchTerminalAgreementDetail	( event.getTesTmlAgmtHdrVO() ) );
			rsVoList.add( dbDao.searchStorageAgreementDetail	( event.getTesTmlAgmtHdrVO() ) );
			
			eventResponse.setRsList(rsVoList);
			
			eventResponse.setETCData( "successFlag", "SUCCESS" );

			return eventResponse;

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/*******	  TerminalAgreement 조회화면 -Detail(Terminal Rate) 끝 		*********/



	/**************************************************************************************
	 * kimjinjoo부분 끝
	 *************************************************************************************/

	/**
	 * I/F 처리<br>
	 * agreementmanageList reg confirm시 이벤트 처리<br>
	 *
	 * @param e EsdTes0034Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public String searchInvoiceHDR(Event e) throws EventException {
		EsdTes0034Event		event			= (EsdTes0034Event)e;
		String				invoiceUseFlg	= "";
		
		try {
			
			invoiceUseFlg = dbDao.searchInvoiceHDR(event.getTesTmlAgmtHdrVO().getTmlAgmtOfcCtyCd(), event.getTesTmlAgmtHdrVO().getTmlAgmtVerNo().replaceAll("\\.", "") );
			return invoiceUseFlg;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * 인터페이스 이벤트 처리<br>
	 * OPF에서 요청된 Port에서 Re-handling될 화물의 Cost를 산출조회.<br>
	 *
	 * @param BkgCodCostListVO bkgCodCostListVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingCost(BkgCodCostListVO bkgCodCostListVO) throws EventException {
		log.debug("\n\n=================== [TerminalAgreementManageBCImpl][searchRehandlingCost]============\n");

		try {
			log.debug("\n\n=================== [TerminalAgreementManageBCImpl][searchRehandlingCost]============ bkgCodCostListVO /n" + bkgCodCostListVO);
			
			return dbDao.searchRehandlingCost(bkgCodCostListVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * 인터페이스 이벤트 처리<br>
	 * OPF에서 요청된 Port에서 Re-handling될 화물의 Cost를 산출조회.<br>
	 *
	 * @param List<BkgCodCostListVO> searchList
	 * @return List<List<BkgCodCostVO>>
	 * @exception EventException
	 */
	public List<List<BkgCodCostVO>> searchRehandlingCost(List<BkgCodCostListVO> searchList) throws EventException {
		log.debug("\n\n=================== [TerminalAgreementManageBCImpl][searchRehandlingCost]============\n");
		List<List<BkgCodCostVO>>				list	= new ArrayList<List<BkgCodCostVO>>();

		try {
			for( int i = 0; searchList != null && i < searchList.size(); i++ ) {
				list.add( dbDao.searchRehandlingCost( (BkgCodCostListVO)searchList.get(i) ) );
			}
			
			return list;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TerminalAgreementManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
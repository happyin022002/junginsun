/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtBCImpl.java 
*@FileTitle : Booking Creation 1_MT P/UP CY inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.04 김기종
* 1.0 Creation
* 2010.10.04 전성진 [CHM-201006261] [ESM-BKG] Manual Booking Number Max 값 초과시 메시지 표시
* 2010.12.17 김영철 [] R4J 메소드 주석 기술 수정 ( Line 504 )
* 2011.01.20 전성진 [CHM-201007855] EDI Setup 삭제 I/F 추가
* 2011.03.25 정선용 [CHM-201108941-01] edi.hanjin.com customer type 별 전송 로직 추가 요청
* 2011.10.21 조원주 [CHM-201113594-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 Doc Center Office Hour 개발
* 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
* 2014.04.01 신규정 [CHM-201429292 ]  Manual BDR 권한 설정 메뉴 신규 개발
* 2014.06.10 문동선 [CHM-201430335] 미주 bkg handling office 지정을 위한 set up 메뉴 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic;  

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingMasterMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BdrAccessAuthorityInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsChnAgnCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDpcsOfcTmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiPrnrPortLaneVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiSubLnkMsgVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiTrdPrnrSubLnkVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMapgVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSlsRepVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtDupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.xmldocuments.XMLDocumentException;
import com.hanjin.framework.component.util.xmldocuments.XMLDocumentUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enisEsd.ESD0320001Document;
import com.hanjin.irep.enisEsd.ESD0320001Document.ESD0320001.DataArea.EDIGroupCollection.EDIGroup;
import com.hanjin.irep.enisEsd.ESD0340001Document;
import com.hanjin.irep.enisEsd.ESD0340001Document.ESD0340001.DataArea.EDIGrpCustCollection.EDIGrpCust;
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnAgnStupVO;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImpImgStoVO;
import com.hanjin.syscommon.common.table.BkgMTPickupCYVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;

/**
 * NIS2010-BookingMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-BookingMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Ki Jong
 * @see esm_bkg_0082EventResponse,BookingMasterMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BookingMasterMgtBCImpl extends BasicCommandSupport implements BookingMasterMgtBC {

	// Database Access Object
	private transient BookingMasterMgtDBDAO dbDao = null;

	/**
	 * BookingMasterMgtBCImpl 객체 생성<br>
	 * BookingMasterMgtDBDAO를 생성한다.<br>
	 */
	public BookingMasterMgtBCImpl() {
		dbDao = new BookingMasterMgtDBDAO();
	}

	/**
	 * Booking Creation 1_MT P/UP CY inquiry (ESM_BKG-0082)<br>
	 * 
	 * @param String YardCode
	 * @param String Today
	 * @return List<BkgMTPickupCYVO>
	 * @exception EventException
	 */
	public List<BkgMTPickupCYVO> searchMTPickUpCY(String YardCode,String Today) throws EventException {
		try {
			return dbDao.searchMTPickUpCY(YardCode,Today);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}

	}
	/**
	 * 수정/저장/삭제 이벤트 처리<br>
	 * HTS (Harmonized Tariff Schedule) Code Creation (ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO[] bkgHamoTrfVos
	 * @param String usrId
	 * @exception EventException, DAOException
	 */
	public void manageHtsCode(BkgHamoTrfVO[] bkgHamoTrfVOs, String usrId ) throws EventException, DAOException {
		// 파라메터 객체 변환
		try {			
			// 작업 구분 분할
			for(int i=0; i < bkgHamoTrfVOs.length; i++) {

				if (bkgHamoTrfVOs[i].getIbflag().equals("D")) {
					dbDao.removeHtsCode(bkgHamoTrfVOs[i],usrId);
				}else if (bkgHamoTrfVOs[i].getIbflag().equals("I")) {
					dbDao.addHtsCode(bkgHamoTrfVOs[i],usrId);
				}else if (bkgHamoTrfVOs[i].getIbflag().equals("U")) {
					dbDao.modifyHtsCode(bkgHamoTrfVOs[i],usrId);

				}
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	

	/**
	 * 조회 이벤트 처리<br>
	 * HTS (Harmonized Tariff Schedule) Code (ESM_BKG-0607)<br>
	 * 
	 * @param BkgHamoTrfVO   vo
	 * @param int iPage
	 * @return List<BkgHamoTrfVO>
	 * @exception EventException
	 */
	public List<BkgHamoTrfVO> searchHTSCode(BkgHamoTrfVO vo ,int iPage) throws EventException {
		try {
			return dbDao.searchHTSCode(vo, iPage);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Customer Inquiry Save 이벤트 처리(ESM_BKG_0652)<br>
	 * Customer Person 정보를 관리한다.<br>
	 * 
	 * @param BkgCustCntcPsonVO[] bkgCustCntcPsonVOs
	 * @param String userId
	 * @exception EventException
	 */	
	public void manageCustContact(	BkgCustCntcPsonVO[] bkgCustCntcPsonVOs, 
														String userId) throws EventException {
		try {
			for ( int i=0; i<bkgCustCntcPsonVOs.length; i++ ) {
				if ( bkgCustCntcPsonVOs[i].getIbflag().equals("I")){
					bkgCustCntcPsonVOs[i].setCreUsrId(userId);
					bkgCustCntcPsonVOs[i].setUpdUsrId(userId);
					
					dbDao.addCustContact(bkgCustCntcPsonVOs[i]);					
				} else if ( bkgCustCntcPsonVOs[i].getIbflag().equals("U")){
					bkgCustCntcPsonVOs[i].setUpdUsrId(userId);
					
					dbDao.modifyCustContact(bkgCustCntcPsonVOs[i]);
				} else if ( bkgCustCntcPsonVOs[i].getIbflag().equals("D")){
				
					dbDao.removeCustContact(bkgCustCntcPsonVOs[i]);
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}    
	}	
	
	/**
	 * Vessel code 및 SKD 조회 <br>
	 *  
	 * @param VskVslPortSkdConditionVO   vo
	 * @return List<VskVslPortSkdConditionVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdConditionVO> searchEtbEtdEta(VskVslPortSkdConditionVO vo) throws EventException {
		try {
			return dbDao.searchEtbEtdEta(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Package Code 및 Description을 검색 및 조회(ESM_BKG_0755,ESM_BKG_0696)  <br>
	 * 
	 * @param MdmPckTpVO   vo
	 * @return List<MdmPckTpVO>
	 * @exception EventException
	 */
	public List<MdmPckTpVO> searchPackageCode(MdmPckTpVO vo) throws EventException {
		try {
			return dbDao.searchPackageCode(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Commodity Code를 입력하기 위해 Code를 검색(ESM_BKG_0653)  <br>
	 *  
	 * @param SearchCmdtCdRepCmdtCdVO   vo
	 * @return List<SearchCmdtCdRepCmdtCdVO>
	 * @exception EventException
	 */
	public List<SearchCmdtCdRepCmdtCdVO> searchCmdtCdRepCmdtCd(SearchCmdtCdRepCmdtCdVO vo) throws EventException {
		try {
			return dbDao.searchCmdtCdRepCmdtCd(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Warehouse (Bonded Area) Creation 조회(ESM_BKG_0554)  <br>
	 *  
	 * @param String cuntryCd
	 * @param String wareHouse
	 * @return List<SearchWareHouseVO>
	 * @exception EventException
	 */
	public List<SearchWareHouseVO> searchWareHouse(String cuntryCd , String wareHouse) throws EventException {
		try {
			return dbDao.searchWareHouse(cuntryCd,wareHouse);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}

	/**
	 * Warehouse (Bonded Area) Creation 저장 이벤트 처리(ESM_BKG_0554)<br>
	 * Warehouse (Bonded Area) 정보를 관리한다.<br>
	 * 
	 * @param SearchWareHouseVO vo
	 * @exception EventException
	 */	
	public void manageWareHouse(	SearchWareHouseVO vo) throws EventException {
		try {
			
			if ( vo.getIbflag().equals("I")){
				dbDao.addWareHouse(vo);		
			} else if ( vo.getIbflag().equals("U")){
				dbDao.modifyWareHouse(vo);
			} else if ( vo.getIbflag().equals("D")){
				dbDao.removeWareHouse(vo);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException((String)new ErrorHandler("COM12240").getUserMessage(),ex);
		}     
	}	
	
	
	/**
	 * 조회-Manual로 BDR을 처리하는 화면(ESM_BKG_0596)  <br>
	 * 
	 * @param SearchBDRTimeVO   vo
	 * @return List<SearchBDRTimeVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeVO> searchBDRTime(SearchBDRTimeVO vo) throws EventException {
		try {
			return dbDao.searchBDRTime(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Vessesl Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR을 처리.
	 * 
	 * @param SearchBDRTimeVO vo
	 * @exception EventException
	 */
	public void modifyBDRLog(SearchBDRTimeVO vo) throws EventException {
		try {
			dbDao.modifyBDRLog(vo);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * vvd check (ESM_BKG_0596)<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @return boolean
	 * @throws EventException
	 */
	public boolean checkBDRVVDPOL(SearchBDRTimeVO vo) throws EventException {
		try {
			return dbDao.checkBDRVVDPOL(vo);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	
	/**
	 * booking close for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void closeBKGForBayPlan(BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				
				if ( bkgCoffTmVOs[i].getIbflag().equals("I")){
					//중복확인
					BkgCoffTmVO bkgCoffTmChkVO = new BkgCoffTmVO();
					bkgCoffTmChkVO.setVslCd(bkgCoffTmVOs[i].getVslCd());
					bkgCoffTmChkVO.setSkdVoyNo(bkgCoffTmVOs[i].getSkdVoyNo());
					bkgCoffTmChkVO.setSkdDirCd(bkgCoffTmVOs[i].getSkdDirCd());
					bkgCoffTmChkVO.setPolCd(bkgCoffTmVOs[i].getPolCd());
					bkgCoffTmChkVO.setClptIndSeq(bkgCoffTmVOs[i].getClptIndSeq());
					bkgCoffTmChkVO.setBkgOfcCd(bkgCoffTmVOs[i].getBkgOfcCd());
					if("Y".equalsIgnoreCase(dbDao.searchBkgCoffTmDup(bkgCoffTmChkVO))){
						throw new EventException(new ErrorHandler("BKG01126", new String[]{}).getMessage());
					}
					
					bkgCoffTmVOs[i].setCreUsrId(account.getUsr_id());
					dbDao.addBkgCoffTm(bkgCoffTmVOs[i]);					
				} else if ( bkgCoffTmVOs[i].getIbflag().equals("U")){
					bkgCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgCoffTm(bkgCoffTmVOs[i]);
				} 
			}
			
		} catch(EventException ex) {
			throw new EventException(ex.getMessage());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	/**
	 * booking reopen for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reopenBkgForBayPlan(BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				
				if ( bkgCoffTmVOs[i].getIbflag().equals("U")){
					bkgCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgCoffTm(bkgCoffTmVOs[i]);
				} 
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * DPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다(ESM_BKG_1004)<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @exception EventException
	 */
	public List<BkgDpcsUsrGrpVO> searchDPSCUserGroup(String usrId,String dpcsWrkGrpCd,BkgDpcsUsrGrpVO vo) throws EventException {
		try {
			return dbDao.searchDPSCPicUserGroup(usrId, dpcsWrkGrpCd, vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	/**
	 * DPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다(ESM_BKG_0592)<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO vo
	 * @return List<SearchBDRTimeVO>
	 * @exception EventException
	 */
	public List<BkgDpcsUsrGrpVO> searchDPCSUserGroup(String usrId,String dpcsWrkGrpCd,BkgDpcsUsrGrpVO vo) throws EventException {
		try {
			return dbDao.searchDPCSUserGroup(usrId, dpcsWrkGrpCd, vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	
	/**
	 * User Group Creation를 관리한다(ESM_BKG_0592).<br>
	 * DPCS - S/R 업무처리 담당자 Group 정보를 관리한다. <br>
	 * DPSC의 해당 User그룹을 담당자별 작업내역을 할단하주고 그것을 그룹핑해 놓은  Table임<br>
	 * 
	 * @param BkgDpcsUsrGrpVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageDPSCUserGroup(BkgDpcsUsrGrpVO[] vos,SignOnUserAccount account) throws EventException {
		try {
			for ( int i=0; i<vos.length; i++ ) {
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());
				
				if ( vos[i].getIbflag().equals("I")){
					dbDao.addDPSCUserGroup(vos[i]);
				}
				if ( vos[i].getIbflag().equals("U")){
					dbDao.modifyDPSCUserGroup(vos[i]);
				}
				if ( vos[i].getIbflag().equals("D")){
					dbDao.removeDPSCUserGroup(vos[i]);
				}
				
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * BDR TIME 등록화면 Lane조회(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return List<SearchBDRPolVO>
	 * @exception EventException
	 */
	public List<SearchBDRPolVO> searchBDRPol(SearchBDRPolVO vo) throws EventException {
		try {
			return dbDao.searchBDRPol(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BDR Time Table 조회 이벤트 처리(ESM_BKG_0073) <br>
	 * 
	 * @param SearchBDRTimeTableVO   vo
	 * @return List<SearchBDRTimeTableVO>
	 * @exception EventException
	 */
	public List<SearchBDRTimeTableVO> searchBDRTimeTable(SearchBDRTimeTableVO vo) throws EventException {
		try {
			if (vo.getOptSelBdr().equals("Lane")){
				return dbDao.searchLaneBDRTime(vo);
			}else{
				return dbDao.searchVVDBDRTime(vo);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * BDR Time 관리 저장 이벤트 처리.(ESM_BKG_0073)<br>
	 * BDR의 기준이 되는 BDR Time을 등록하는 화면에서... <br>
	 * Lane/Bound/From Location/To Location 기준으로 등록된 BDR Time을 관리.<br>
	 * 
	 * @param SearchBDRPolVO[] vos1
	 * @param SearchBDRTimeTableVO[] vos2
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageVVDBDRTime(SearchBDRPolVO[] vos1,SearchBDRTimeTableVO[] vos2,SignOnUserAccount account) throws EventException {
		try {
			
			if (vos1 != null && vos1.length >0){
				for ( int i=0; i<vos1.length; i++ ) {
					vos1[i].setCreUsrId(account.getUsr_id());
					vos1[i].setUpdUsrId(account.getUsr_id());
					if ( vos1[i].getIbflag().equals("I")){
						dbDao.addBDRTime(vos1[i]);
					}
					if ( vos1[i].getIbflag().equals("U")){
						dbDao.modifyBDRTime(vos1[i]);
					}
					if ( vos1[i].getIbflag().equals("D")){
						dbDao.removeBDRTime(vos1[i]);
					}
				}
			}
			if (vos2 != null && vos2.length >0){
				for ( int i=0; i<vos2.length; i++ ) {
					vos2[i].setCreUsrId(account.getUsr_id());
					vos2[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos2[i].getIbflag().equals("U")){
						dbDao.modifyVVDBDRLog(vos2[i]);
					}
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Equalization Port 등록 화면 조회 이벤트 처리(ESM_BKG_0253)<br>

	 * @param BkgEqlzPortVO vo
	 * @return List<BkgEqlzPortVO>
	 * @throws EventException
	 */
	public List<BkgEqlzPortVO> searchEqualizetionPortCD (BkgEqlzPortVO vo) throws EventException{
		try {
			return dbDao.searchEqualizetionPortCD(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	 
	 /**
	 * Equalization Port 등록 관리 저장 이벤트 처리(ESM_BKG-0253) <br>
	 * 
	 * @param BkgEqlzPortVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageEqualizationPort(BkgEqlzPortVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addEqualizationPort(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyEqualizationPort(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeEqualizationPort(vos[i]);
					}
					
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 중국 Booking Agent 정보 등록 화면-조회 이벤트 처리 (ESM_BKG-0153)<br>
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return List<BkgChinaAgentVO>
	 * @throws EventException
	 */
	public List<BkgChinaAgentVO> searchChinaAgentCodeList (BkgChinaAgentVO vo) throws EventException {
		try {
			return dbDao.searchChinaAgentCodeList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}  
	
	 /**
	 * 중국 Booking Agent 정보 등록 화면 저장 이벤트 처리(ESM_BKG-0153) <br>

	 * @param BkgChinaAgentVO[] vos
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageChinaAgentCode(BkgChinaAgentVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			log.debug("vos.length:"+vos.length);
			BookingUtil utilCmd = new BookingUtil();
			
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					if(vos[i].getBkgBlckFlg().equals("0")){
						vos[i].setBkgBlckFlg("N");
					} else if(vos[i].getBkgBlckFlg().equals("1")){
						vos[i].setBkgBlckFlg("Y");	
					}
					if (vos[i].getAutoDpChkFlg().equals("")){
						vos[i].setAutoDpChkFlg("N");
					}
					if ( vos[i].getIbflag().equals("I")){
						if (utilCmd.checkChnAgnCd(vos[i].getChnAgnCd(),"Y").equals("Y")){
							throw new EventException(new ErrorHandler("BKG03833", new String[]{"Agent Code: ["+vos[i].getChnAgnCd() + "]"}).getMessage());
						} 
						dbDao.addChinaAgentCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyChinaAgentCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeChinaAgentCode(vos[i]);
					}
				}
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  0192 B/L Customer Information in CRM 조회 <br>		
	 *  
	 * @param SearchInBoundCustListVO searchInBoundCustListVO
	 * @return List<SearchInBoundCustListVO>
	 * @throws EventException
	 */
	public List<SearchInBoundCustListVO> searchInBoundCustList(SearchInBoundCustListVO searchInBoundCustListVO) throws EventException {
		 
		try {
			return dbDao.searchInBoundCustList(searchInBoundCustListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	 }
		 
	 /**
	  *  0192 B/L Customer Information in CRM Template 조회 <br>			 
	  * @param BkgCustTmpltVO bkgCustTmpltVO
	  * @return List<BkgCustTmpltVO>
	  * @throws EventException
	  */
	 public List<BkgCustTmpltVO> searchInBoundCustTmpltList(BkgCustTmpltVO bkgCustTmpltVO) throws EventException {
		 
		 try {
			 return dbDao.searchInBoundCustTmpltList(bkgCustTmpltVO);
		 } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	 }
	 
	/**
     * 멀티 이벤트 처리<br>
     * 0192 B/L Customer Information in CRM Template 트랜잭션 처리 <br>
     * 
     * @param BkgCustTmpltVO[] bkgCustTmpltVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageInBoundCustList(BkgCustTmpltVO[] bkgCustTmpltVO,SignOnUserAccount account) throws EventException{
    	
    	if(bkgCustTmpltVO == null)
			return;
		try { 
			List<BkgCustTmpltVO> insertVoList = new ArrayList<BkgCustTmpltVO>();
			List<BkgCustTmpltVO> updateVoList = new ArrayList<BkgCustTmpltVO>();
			List<BkgCustTmpltVO> deleteVoList = new ArrayList<BkgCustTmpltVO>();
			
			for ( int i=0; i<bkgCustTmpltVO.length; i++ ) {
				
				bkgCustTmpltVO[i].setCreUsrId(account.getUsr_id());
				bkgCustTmpltVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( bkgCustTmpltVO[i].getIbflag().equals("I")){
					insertVoList.add(bkgCustTmpltVO[i]);
				} else if ( bkgCustTmpltVO[i].getIbflag().equals("U")){
					updateVoList.add(bkgCustTmpltVO[i]);
				} else if ( bkgCustTmpltVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgCustTmpltVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeInBoundCustList(deleteVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInBoundCustList(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInBoundCustList(insertVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException((String)new ErrorHandler("BKG00391").getUserMessage(),de);
		}    	
    }
    
    /**
	 * Vessel Port Schedule 변경에 의한 BKG_VVD_BDR_LOG TABLE 저장이벤트 처리<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception EventException
	 */
	public void manageBkgVVDBdrLog(String vslCd, String skdVoyNo, String skdDirCd) throws EventException{
		
		List<BkgVvdBdrLogVO> stsList 	= null;
		List<BkgVvdBdrLogVO> skdList 	= null;
		List<BkgVvdBdrLogVO> timeList 	= null;
		List<BkgVvdBdrLogVO> flgList 	= null;
		
		BkgVvdBdrLogVO actVo 		= null;
		BkgVvdBdrLogVO polVo 		= null;
		BkgVvdBdrLogVO podVo 		= null;
		BkgVvdBdrLogVO conVo 		= new BkgVvdBdrLogVO();
		BkgVvdBdrLogVO timeVo 		= null;
		
		String slanTpCd = "";
		String actDepDt = "";
		
		try {
			stsList = dbDao.searchVVDStatus(vslCd, skdVoyNo, skdDirCd);
			
			if (stsList.size() > 0){
				
				actVo = (BkgVvdBdrLogVO)stsList.get(0);
				
				/**********************************************************************************
				* Vessel Schedule Status Select for Activate Check	
				* Lane Code와 Activated 여부를 확인 한다.
				***********************************************************************************/				
				if (actVo.getSkdStsCd().equals("ACT")){
					
					/***************************************************************************
					* Vessel이 Trunk, Feeder인지 확인.
					* Trunk 이면 : 'M'.
					* Feeder 이면 : 'P'.
					***************************************************************************/
					slanTpCd = dbDao.searchSvcTpCd(actVo.getSlanCd());
					
					/***************************************************************************
					* V.V.D에 걸려 있는 모든 SKD를 Select하여, ETA로 Sorting 한다.
					* BDR LOG를 Pair로 만들 위해 사전 작업.
					***************************************************************************/
					skdList = dbDao.searchVslPortSkd(vslCd, skdVoyNo, skdDirCd);
					log.debug("champ......................1");
					for (int i = 0 ; i < (skdList.size()-1) ; i++){
						
						for (int j = 1 ; j < skdList.size() ; j++){
							log.debug("champ......................2");
							polVo = (BkgVvdBdrLogVO)skdList.get(i);
							podVo = (BkgVvdBdrLogVO)skdList.get(j);
							
							//등록정보 셋팅 
							conVo.setVslCd(vslCd);
							conVo.setSkdVoyNo(skdVoyNo);
							conVo.setSkdDirCd(skdDirCd);
							conVo.setPolCd(polVo.getVpsPortCd());
							conVo.setPodCd(podVo.getVpsPortCd());
							conVo.setPolClptIndSeq(polVo.getClptIndSeq());
							conVo.setPodClptIndSeq(podVo.getClptIndSeq());
							conVo.setVpsEtdDt(polVo.getVpsEtdDt());
							conVo.setSlanCd(polVo.getSlanCd());
							conVo.setCreUsrId(polVo.getCreUsrId());
							conVo.setUpdUsrId(polVo.getUpdUsrId());
							conVo.setTrnkBdrCreUsrId(polVo.getCreUsrId());
							conVo.setFdrBdrCreUsrId(polVo.getCreUsrId());
							log.debug("champ......................3");
							/********************************************************************************************
							*<BDR LOG>를 만들지 않는 조건을 Checking 한다.
							* 1.POL은 Discharging Port가 될 수 없다.(Turing Port는 BDR LOG를 만들지 않는다.)
							* 2.POL은 Skip된 Port가 될 수 없다.(Skip Calling는 해당 Port에 기항하지 않는다.)
							* 3.POL과 POD는 동일할 수 없다.(Second Calling 이하는 BDR LOG를 만들지 않는다.)								
							********************************************************************************************/
							if (polVo.getTurnPortIndCd().equals("D") || polVo.getTurnPortIndCd().equals("F") ||
								polVo.getTurnPortIndCd().equals("D") || polVo.getSkdCngStsCd().equals("S") ||
								podVo.getSkdCngStsCd().equals("S")){
								
								continue;
							}
							log.debug("champ......................4");
							/*********************************************************************************
							* BDR Estemated Date를 구하는데, BDR_TIME Table를 참조 한다.
							* 참고 : 
							*		<Trunk Lane일 경우>
							*			Trunk  - POL & POD가 BDR_TIME Table에 없는 경우 Null로 Creation된다.
							*			Feeder - POL & POD가 BDR_TIME Table에 없는 경우 +2로 Creation된다.
							*		<Feeder Lane일 경우>
							* 			Trunk  - POL & POD가 BDR_TIME Table에 없는 경우 +2로 Creation된다.
							*  			Feeder - POL & POD가 BDR_TIME Table에 없는 경우 +bdr_days로 Creation된다.
							*********************************************************************************/
							timeList = dbDao.searchBdrTime(polVo.getVpsEtdDt(), polVo.getSlanCd(), polVo.getSkdDirCd(), polVo.getVpsPortCd(), podVo.getVpsPortCd());
							
							//등록정보 셋팅 >>> SLAN_TP_CD
							conVo.setSlanTpCd(slanTpCd);
							log.debug("champ......................5");
							if (timeList.size() == 0){
								
								/***************************************************************************
								* BDR Time이 없는 경우는 OFF LANE 인 경우는 (TYPE = 'P')
								* BDR DT를 ETD + 2,Feeder의 BDR DT 는 ETD + bdr_days로 Setting
								* User의 요청으로 BDR MAX day를 bdr_days일로 수정함 (updated by J.E.Y)
								***************************************************************************/
								if (slanTpCd.equals("P")){
									
									timeVo = dbDao.searchBdrTimeP(polVo.getVpsEtdDt());																			
								}else{
									
									timeVo = dbDao.searchBdrTimeM(polVo.getVpsEtdDt());
								}
							}else{
								
								timeVo = (BkgVvdBdrLogVO)timeList.get(0);
							}
							
							//등록정보 셋팅 >>> TRNK_ESTM_BDR_DT, FDR_ESTM_BDR_DT
							conVo.setTrnkEstmBdrDt(timeVo.getUpdDt());
							conVo.setFdrEstmBdrDt(timeVo.getCreDt());
							
							//BKG_VVD_BDR_LOG TABLE 에  기존정보  조회
							flgList = dbDao.searchBkgVVDBdrLogFlg(conVo);
							
							//기존정보가 없는 경우 >>> INSERT
							if (flgList.size() == 0){
								
								/****************************************************************************
								* Actual Report(Departue)가 입력 돼었는지를 확인한다.
								****************************************************************************/
								actDepDt = dbDao.searchVskActPortSkd(conVo);
								
								//Actual 일 경우
								if (!actDepDt.equals("")){
									
									//<Trunk Lane일 경우>
									if (slanTpCd.equals("M")){
										
										//등록정보 셋팅
										conVo.setTrnkBdrFlg("Y");
										conVo.setTrnkAutoBdrFlg("Y");
										conVo.setTrnkAutoBdrDt(actDepDt);
										conVo.setTrnkMnlBdrFlg("N");
										conVo.setTrnkMnlBdrDt("");
										conVo.setFdrBdrFlg("N");
										conVo.setFdrAutoBdrFlg("N");
										conVo.setFdrAutoBdrDt("");
										conVo.setFdrMnlBdrFlg("N");
										conVo.setFdrMnlBdrDt("");
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}
									//<Feeder Lane일 경우>
									else{
										
										//등록정보 셋팅
										conVo.setTrnkBdrFlg("N");
										conVo.setTrnkAutoBdrFlg("N");
										conVo.setTrnkAutoBdrDt("");
										conVo.setTrnkMnlBdrFlg("N");
										conVo.setTrnkMnlBdrDt("");
										conVo.setFdrBdrFlg("Y");
										conVo.setFdrAutoBdrFlg("Y");
										conVo.setFdrAutoBdrDt(actDepDt);
										conVo.setFdrMnlBdrFlg("N");
										conVo.setFdrMnlBdrDt("");
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}																			
								}
								//Manual 일 경우 
								else{
									
									//<Trunk Lane일 경우>
									if (slanTpCd.equals("M")){
										
										//등록정보 셋팅
										conVo.setTrnkBdrFlg("Y");
										conVo.setTrnkAutoBdrFlg("N");
										conVo.setTrnkAutoBdrDt("");
										conVo.setTrnkMnlBdrFlg("Y");
										conVo.setTrnkMnlBdrDt(actDepDt);
										conVo.setFdrBdrFlg("N");
										conVo.setFdrAutoBdrFlg("N");
										conVo.setFdrAutoBdrDt("");
										conVo.setFdrMnlBdrFlg("N");
										conVo.setFdrMnlBdrDt("");
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}
									//<Feeder Lane일 경우>
									else{
										
										//등록정보 셋팅
										conVo.setTrnkBdrFlg("N");
										conVo.setTrnkAutoBdrFlg("N");
										conVo.setTrnkAutoBdrDt("");
										conVo.setTrnkMnlBdrFlg("N");
										conVo.setTrnkMnlBdrDt("");
										conVo.setFdrBdrFlg("Y");
										conVo.setFdrAutoBdrFlg("N");
										conVo.setFdrAutoBdrDt("");
										conVo.setFdrMnlBdrFlg("Y");
										conVo.setFdrMnlBdrDt(actDepDt);
										conVo.setFdrBdrUpdDt("");
										conVo.setBdrVslChkFlg("");
									}						
								}
								
								dbDao.addBkgVVDBdrLog(conVo);
							}
							//기존정보가 있는 경우 >>> UPDATE
							else{
								
								//<Trunk Lane일 경우>
								if (slanTpCd.equals("M")){
									
									//등록정보 셋팅
									conVo.setTrnkBdrFlg("Y");
									conVo.setTrnkAutoBdrFlg("N");
									conVo.setTrnkAutoBdrDt("");
									conVo.setTrnkMnlBdrFlg("Y");
									conVo.setTrnkMnlBdrDt(actDepDt);
									conVo.setFdrBdrFlg("N");
									conVo.setFdrAutoBdrFlg("N");
									conVo.setFdrAutoBdrDt("");
									conVo.setFdrMnlBdrFlg("N");
									conVo.setFdrMnlBdrDt("");
									conVo.setFdrBdrUpdDt("");
									conVo.setBdrVslChkFlg("");
								}
								//<Feeder Lane일 경우>
								else{
									
									//등록정보 셋팅
									conVo.setTrnkBdrFlg("N");
									conVo.setTrnkAutoBdrFlg("N");
									conVo.setTrnkAutoBdrDt("");
									conVo.setTrnkMnlBdrFlg("N");
									conVo.setTrnkMnlBdrDt("");
									conVo.setFdrBdrFlg("Y");
									conVo.setFdrAutoBdrFlg("N");
									conVo.setFdrAutoBdrDt("");
									conVo.setFdrMnlBdrFlg("Y");
									conVo.setFdrMnlBdrDt(actDepDt);
									conVo.setFdrBdrUpdDt("");
									conVo.setBdrVslChkFlg("");
								}						
							
								dbDao.modifyBkgVVDBdrLog(conVo);
							}//end if
							
							/*************************************************************************************
							* 현 VVD로  Creation했던 BDR Data를 Check해 놓고 마지막에 가서 Check되어 있지 않은 
							* Data는 기존에 만든 것으로 생각하여 (불필요한 Data이므로 간주)  모두 지운다.
							*************************************************************************************/								
							conVo.setChkFlg("Y");
							conVo.setBdrVslChkFlg("Y");
							dbDao.modifyBdrVslChkFlg(conVo);
						}//end for
					}//end for
				
					/*****************************************************************************************
					* 현 VVD로 Creation했던 BDR LOG Data를 남겨 두고, 나머지는 삭제 한다.
					* 기존에 만든 BDR LOG 데이터는 필요가 없다.
					*****************************************************************************************/
					dbDao.removeBkgVVDBdrLog(conVo);
					
					/*****************************************************************************************
					* 원 상태로, BDR_VSL_CHK_FLG을 Null로 변경한다.
					*****************************************************************************************/
					conVo.setChkFlg("N");
					conVo.setBdrVslChkFlg(" ");
					dbDao.modifyBdrVslChkFlg(conVo);
				}//end if
			}//end if
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Customer Sales Rep 연동 관리 <br>
	 * 
	 * @param String message
	 * @exception EventException
	 * @throws XMLDocumentException 
	 */
	public void manageBkgCustSlsRep(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> message parsing <<<<<<<<<<<<<<<<<<<< ");
		Element element = null;
		
		String instanceId		= null;
		String msgId 			= null;
		String msgEtt			= null;
		String srcSysCd			= null;
		String msgCreDt			= null;
		String opCd				= null;
		String cntCd			= null;
		String custSeq			= null;
		String srepCd			= null;
		String objRowId			= null;
		String userKdy			= null;
		String parObjRowId		= null; 
		String srepCustClssCd 	= null;
		
		CustSlsRepVO vo = new CustSlsRepVO();
		
		try {
			element = XMLDocumentUtils.getRootElement(new ByteArrayInputStream(message.getBytes("UTF-8")));
			instanceId		= XMLDocumentUtils.getTagValue(element, "InstanceId");
			msgId 			= XMLDocumentUtils.getTagValue(element, "MSGID");
			msgEtt 			= XMLDocumentUtils.getTagValue(element, "MSGETT");
			srcSysCd 		= XMLDocumentUtils.getTagValue(element, "SRCSYSCD");
			msgCreDt 		= XMLDocumentUtils.getTagValue(element, "MSGCREDT");
			opCd 			= XMLDocumentUtils.getTagValue(element, "OPCD");
			cntCd 			= XMLDocumentUtils.getTagValue(element, "CNTCD");
			custSeq 		= XMLDocumentUtils.getTagValue(element, "CUSTSEQ");
			srepCd 			= XMLDocumentUtils.getTagValue(element, "SREPCD");
			objRowId 		= XMLDocumentUtils.getTagValue(element, "OBJROWID");
			userKdy 		= XMLDocumentUtils.getTagValue(element, "USERKEY");
			parObjRowId 	= XMLDocumentUtils.getTagValue(element, "PAROBJROWID");
			srepCustClssCd	= XMLDocumentUtils.getTagValue(element, "DATACHECK");
			
			log.debug("InstanceId >>> " + instanceId);
			log.debug("MsgId >>> " + msgId);
			log.debug("MsgEtt >>> " + msgEtt);
			log.debug("SrcSysCd >>> " + srcSysCd);
			log.debug("MsgCreDt >>> " + msgCreDt);
			log.debug("OpCd >>> " + opCd);
			log.debug("CntCd >>> " + cntCd);
			log.debug("CustSeq >>> " + custSeq);
			log.debug("SrepCd >>> " + srepCd);
			log.debug("ObjRowId >>> " + objRowId);
			log.debug("UserKdy >>> " + userKdy);
			log.debug("ParObjRowId >>> " + parObjRowId);
			log.debug("srepCustClssCd(DATACHECK) >>> " + srepCustClssCd);
			
			vo.setInstanceId(instanceId);
			vo.setMsgCreDt(msgCreDt);
			vo.setSrepCd(srepCd);
			vo.setCustCntCd(cntCd);
			vo.setCustSeq(custSeq);
			vo.setUpdUsrId("SYSTEM");
			vo.setCreUsrId("SYSTEM");
			vo.setSrepCustClssCd(srepCustClssCd);
			
			if (opCd.equals("D")){
				
				vo.setDeltFlg("Y");
			}else{
				
				vo.setDeltFlg("N");
			}							
			
			List<CustSlsRepVO> list = dbDao.searchBkgCustSlsRep(vo);
			
			if (list.size() > 0 ){
				
				dbDao.modifyBkgCustSlsRep(vo);
			}else{
				
				dbDao.addBkgCustSlsRep(vo);
			}
			
		}catch(XMLDocumentException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_DOC_CLZ_SET TABLE(Documentation Cut-off Time)  조회<br>
	 * 
	 * @param String ydCd
	 * @param String vslSlanCd
	 * @return List<BkgdocClzSetListVO>
	 * @exception EventException
	 */
	public List<BkgdocClzSetListVO> searchDocCutOffTimeList(String ydCd, String vslSlanCd) throws EventException{
		
		try {
			 return dbDao.searchDocCutOffTimeList(ydCd, vslSlanCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * COUNTRY CODE,NAME  조회<br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCntCdNm() throws EventException{
		
		try {
			 return dbDao.searchCntCdNm();
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Documentation Cut-off Time 을 SAVE 처리합니다.<br>
	 * 
	 * @param BkgdocClzSetVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDocCutOffTimeList(BkgdocClzSetVO[] vos,SignOnUserAccount account) throws EventException{
		
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addDocCutOffTime(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyDocCutOffTime(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeDocCutOffTime(vos[i]);
					}
					if(!"ALL".equals(vos[i].getVvdCd()) && vos[i].getVvdCd().length() == 9)
						dbDao.updateDocCutOffTimeByVvd(vos[i]);
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Mandatory Item(s) Setup for Customized Service 을 SAVE 처리합니다.<br>
	 * 
	 * @param MandatoryItemSetupListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMandatoryItemSetupList(MandatoryItemSetupListVO[] vos,SignOnUserAccount account) throws EventException{
		
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addMandatoryItemSetupList (vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyMandatoryItemSetupList(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeMandatoryItemSetupList(vos[i]);
					}
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Mandatory Item(s) Setup for Customized Service 을 Retrieve 처리합니다.<br>
	 * 
	 * @param BkgMdtItmVO vo
	 * @return List<BkgMdtItmVO>
	 * @exception EventException
	 */
	public List<BkgMdtItmVO> searchMandatoryItemSetupList(BkgMdtItmVO vo) throws EventException{
		
		try {
			 return dbDao.searchMandatoryItemSetupList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK 연동을 처리합니다.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveBkgEdiTrdPrnrSubLnk(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiTrdPrnrSubLnk Start <<<<<<<<<<<<<<<<<<<< ");
		BkgEdiTrdPrnrSubLnkVO vo             = null;
		String trdPrnrSubLnkSeq              = null;
		String prnrSubLnkDivCd               = null;
		String prnrSubLnkCd                  = null;
		String sndrTrdPrnrId                 = null;
		String rcvrTrdPrnrId                 = null;
		String prnrPortCd                    = null;
		String ediSndFlg                     = null;
		String creUsrId                      = null;
		String eaiStatus                     = null;
		List<BkgEdiTrdPrnrSubLnkVO> list     = null;
		List<Element>               dataList = null;
		try {
			dataList = XMLDocumentUtils.getChildElementList(
				XMLDocumentUtils.getRootElement(
					new ByteArrayInputStream(message.getBytes("UTF-8"))
				), "E_SUBLINK");
			if (null!=dataList && 0<dataList.size()) {
				for (Element element : dataList) {
					eaiStatus        = XMLDocumentUtils.getTagValue(element, "EAI_STS");
					trdPrnrSubLnkSeq = XMLDocumentUtils.getTagValue(element, "TRD_PRNR_SUB_LNK_SEQ");
					prnrSubLnkDivCd  = XMLDocumentUtils.getTagValue(element, "PRNR_SUB_LNK_DIV_CD");
					prnrSubLnkCd     = XMLDocumentUtils.getTagValue(element, "PRNR_SUB_LNK_CD");
					sndrTrdPrnrId    = XMLDocumentUtils.getTagValue(element, "SNDR_TRD_PRNR_ID");
					rcvrTrdPrnrId    = XMLDocumentUtils.getTagValue(element, "RCVR_TRD_PRNR_ID");
					prnrPortCd       = XMLDocumentUtils.getTagValue(element, "PRNR_PORT_CD");
					ediSndFlg        = XMLDocumentUtils.getTagValue(element, "EDI_SND_FLG");
					creUsrId         = XMLDocumentUtils.getTagValue(element, "CRE_USR_ID");
					vo = new BkgEdiTrdPrnrSubLnkVO();
					vo.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq);
					vo.setPrnrSubLnkDivCd(prnrSubLnkDivCd);
					vo.setPrnrSubLnkCd(prnrSubLnkCd);
					vo.setSndrTrdPrnrId(sndrTrdPrnrId);
					vo.setRcvrTrdPrnrId(rcvrTrdPrnrId);
					vo.setPrnrPortCd(prnrPortCd);
					vo.setEdiSndFlg(ediSndFlg);
					vo.setCreUsrId(creUsrId);
					vo.setUpdUsrId("SYSTEM");
					list = dbDao.searchBkgEdiTrdPrnrSubLnk(vo);
					if (0<list.size()) {
						if("D".equals(eaiStatus)) {
							dbDao.removeBkgEdiTrdPrnrSubLnk(vo);
						} else {
							dbDao.modifyBkgEdiTrdPrnrSubLnk(vo);
						}
					} else {
						dbDao.addBkgEdiTrdPrnrSubLnk(vo);
					}
				}
			}
			log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiTrdPrnrSubLnk End <<<<<<<<<<<<<<<<<<<< ");
		} catch(XMLDocumentException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BKG_EDI_SUB_LNK_MSG 연동을 처리합니다.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveBkgEdiSubLnkMsg(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiSubLnkMsg Start <<<<<<<<<<<<<<<<<<<< ");
		BkgEdiSubLnkMsgVO vo                 = null;
		String trdPrnrSubLnkSeq              = null;
		String ediMsgTpId                    = null;
		String ediMsgIndCd                   = null;
		String msgTpDesc                     = null;
		String ediStupNo                     = null;
		String eaiStatus                     = null;
		List<BkgEdiSubLnkMsgVO>     list     = null;
		List<Element>               dataList = null;
		try {
			dataList = XMLDocumentUtils.getChildElementList(
				XMLDocumentUtils.getRootElement(
					new ByteArrayInputStream(message.getBytes("UTF-8"))
				), "E_SUBLINK_MSG_IND");
			if (null!=dataList && 0<dataList.size()) {
				for (Element element : dataList) {
					eaiStatus        = XMLDocumentUtils.getTagValue(element, "EAI_STS");
					log.debug("\n\n\n\n\n\n =======> eaiStatus: " + eaiStatus);
					trdPrnrSubLnkSeq = XMLDocumentUtils.getTagValue(element, "TRD_PRNR_SUB_LNK_SEQ");
					ediMsgTpId  = XMLDocumentUtils.getTagValue(element, "EDI_MSG_TP_ID");
					ediMsgIndCd = XMLDocumentUtils.getTagValue(element, "EDI_MSG_IND_CD");
					msgTpDesc   = XMLDocumentUtils.getTagValue(element, "MSG_TP_DESC");
					ediStupNo   = XMLDocumentUtils.getTagValue(element, "EDI_STUP_NO");
					vo = new BkgEdiSubLnkMsgVO();
					vo.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq);
					vo.setEdiMsgTpId(ediMsgTpId);
					vo.setEdiMsgIndCd(ediMsgIndCd);
					vo.setMsgTpDesc(msgTpDesc);
					vo.setEdiStupNo(ediStupNo);
					vo.setCreUsrId("SYSTEM");
					vo.setUpdUsrId("SYSTEM");
					list = dbDao.searchBkgEdiSubLnkMsg(vo);
					if (0<list.size()) {
						if("D".equals(eaiStatus)) {
							dbDao.removeBkgEdiSubLnkMsg(vo);
						} else {
							dbDao.modifyBkgEdiSubLnkMsg(vo);
						}
					} else {
						dbDao.addBkgEdiSubLnkMsg(vo);
					}
				}
			}
			log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiSubLnkMsg End <<<<<<<<<<<<<<<<<<<< ");
		} catch(XMLDocumentException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BKG_EDI_PRNR_PORT_LANE 연동을 처리합니다.
	 * 
	 * @param String message
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveBkgEdiPrnrPortLane(String message) throws EventException {
		log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiPrnrPortLane Start <<<<<<<<<<<<<<<<<<<< ");
		BkgEdiPrnrPortLaneVO vo              = null;
		String trdPrnrSubLnkSeq              = null;
		String slanCd                        = null;
		List<BkgEdiPrnrPortLaneVO>  list     = null;
		List<Element>               dataList = null;
		try {
			dataList = XMLDocumentUtils.getChildElementList(
				XMLDocumentUtils.getRootElement(
					new ByteArrayInputStream(message.getBytes("UTF-8"))
				), "E_PORT_LANE");
			if (null!=dataList && 0<dataList.size()) {
				for (Element element : dataList) {
					trdPrnrSubLnkSeq = XMLDocumentUtils.getTagValue(element, "TRD_PRNR_SUB_LNK_SEQ");
					slanCd = XMLDocumentUtils.getTagValue(element, "SLAN_CD");
					vo = new BkgEdiPrnrPortLaneVO();
					vo.setTrdPrnrSubLnkSeq(trdPrnrSubLnkSeq);
					vo.setSlanCd(slanCd);
					vo.setCreUsrId("SYSTEM");
					vo.setUpdUsrId("SYSTEM");
					list = dbDao.searchBkgEdiPrnrPortLane(vo);
					if (0<list.size()) {
						dbDao.modifyBkgEdiPrnrPortLane(vo);
					} else {
						dbDao.addBkgEdiPrnrPortLane(vo);
					}
				}
			}
			log.debug(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> receiveBkgEdiPrnrPortLane End <<<<<<<<<<<<<<<<<<<< ");
		} catch(XMLDocumentException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 북중국 Manual Booking No 생성 현황 조회<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	public List<BkgChnBkgNoGenVO> searchChnMnlBkgNoGenList(
			ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) throws EventException {
		try {
			return dbDao.searchChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * 북중국 Agent용 Booking Number를 선 채번 한다<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception EventException
	 */
	@Override
	public List<BkgChnBkgNoGenVO> createChnMnlBkgNoGenList(
			ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO, SignOnUserAccount account)
			throws EventException {
		List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs = new ArrayList<BkgChnBkgNoGenVO>();
		try {
			BookingUtil utilCmd = new BookingUtil();
			int noOfBkg = Integer.parseInt(chnMnlBkgNoGenCondVO.getNoOfBkg());

			// 북중국 지점에 해당 대리점이 존재하는지 확인
			String creOfcCd = account.getOfc_cd();
			String chnAgnCd = chnMnlBkgNoGenCondVO.getactChnAgnCd();
			
			// 존재하지 않으면 Exception 발생
			if ("N".equals(dbDao.searchChnOfcAgn(creOfcCd, chnAgnCd))) {
				throw new EventException((String) new ErrorHandler("BKG08064", new String []{creOfcCd, chnAgnCd}).getMessage());
			}
			
			// 북중국 BKG No Prefix를 구함 (Office Code 앞 2자리 + 북중국 Agent Code  2자리)
			
			String nchnBkgNoPrefix = "";
			if (creOfcCd.equals("NBOSC")){
				nchnBkgNoPrefix = "NJ" + chnAgnCd;
			}else{
				nchnBkgNoPrefix = creOfcCd.substring(0, 2) + chnAgnCd;
			}
			

			for (int i = 0; i < noOfBkg; i++) {
				BkgBlNoVO bkgBlNoVO = utilCmd.manageBkgNumberGeneration("NCB",
						nchnBkgNoPrefix, account.getUsr_id());
				
				log.info("bkgBlNoVO.getNcbNo()=[" + bkgBlNoVO.getNcbNo() + "]");
				if ("MAX_OVER".equals(bkgBlNoVO.getNcbNo())) {
					log.info("MAX_OVER~!!!!!!!!!!");
					throw new EventException((String) new ErrorHandler("BKG02067").getMessage());
				}
				BkgChnBkgNoGenVO bkgChnBkgNoGenVO = new BkgChnBkgNoGenVO();
				bkgChnBkgNoGenVO.setBkgNo(bkgBlNoVO.getNcbNo() + "00");
				bkgChnBkgNoGenVO.setBkgNoUseFlg("N");
				bkgChnBkgNoGenVO.setChnAgnCd(chnMnlBkgNoGenCondVO.getactChnAgnCd());
				// 사용자가 속한 Office의 Local Time으로 Creation Date/Time 셋팅
				bkgChnBkgNoGenVO.setBkgCreDt(utilCmd.searchTimeLocalOfcFnc(chnMnlBkgNoGenCondVO.getActCreOfcCd()));
				bkgChnBkgNoGenVO.setCreOfcCd(account.getOfc_cd());
				bkgChnBkgNoGenVO.setCreUsrId(account.getUsr_id());
				
				bkgChnBkgNoGenVOs.add(bkgChnBkgNoGenVO);
			}

			if (bkgChnBkgNoGenVOs.size() > 0) {
				dbDao.addBkgChnBkgNoGenList(bkgChnBkgNoGenVOs);
			}
			
			return bkgChnBkgNoGenVOs;
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * 사전 생성한 북중국 BKG NO 사용시 사용 표시<br>
	 * 
	 * @param List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs
	 * @param String bkgPorCd 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void modifyChnBkgNoUseFlgOnList(List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs, String bkgPorCd, SignOnUserAccount account) throws EventException {
		try {
			if (bkgChnBkgNoGenVOs.size() > 0) {
				for (int i = 0; i < bkgChnBkgNoGenVOs.size(); i++) {
					bkgChnBkgNoGenVOs.get(i).setDocUsrId(account.getUsr_id());
					bkgChnBkgNoGenVOs.get(i).setUpdUsrId(account.getUsr_id());
				}
				dbDao.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVOs, bkgPorCd);
			}
		
			return;
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

	/**
	 * manageBkgEdiGrp<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrp(String str) throws EventException {
        EDIGroup[] group_array = null;
		List<BkgEdiGrpVO> list = null;
		BkgEdiGrpVO bkgEdiGrpVO = null;
		try {
            group_array = ESD0320001Document.Factory.parse(str).getESD0320001().getDataArea().getEDIGroupCollection().getEDIGroupArray();
            list = new ArrayList<BkgEdiGrpVO>();
	        for (EDIGroup ediGroup : group_array) {
				bkgEdiGrpVO = new BkgEdiGrpVO();
				bkgEdiGrpVO.setEsvcGrpCd     (ediGroup.getGROUPCD  ());
				bkgEdiGrpVO.setCoCd          (ediGroup.getCOMPANYCD());
				bkgEdiGrpVO.setEsvcGrpNm     (ediGroup.getGROUPNM  ());
				bkgEdiGrpVO.setCustTrdPrnrId (ediGroup.getCUSTTPID ());
				bkgEdiGrpVO.setMchnTrdPrnrId (ediGroup.getHOSTTPID ());
				bkgEdiGrpVO.setEsvcGrpDeltFlg(ediGroup.getDELIND   ());
	        	bkgEdiGrpVO.setEaiSts        (ediGroup.getEAISTS   ());
				list.add(bkgEdiGrpVO);
	        }
			dbDao.manageBkgEdiGrp(list);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

	/**
	 * manageBkgEdiGrpCust<br>
	 * 
	 * @param String str
	 * @exception EventException
	 */
	public void manageBkgEdiGrpCust(String str) throws EventException {
    	EDIGrpCust [] group_cust_array = null;
		List<BkgEdiGrpCustVO> list = null;
		BkgEdiGrpCustVO bkgEdiGrpCustVO = null;
		try {
            group_cust_array = ESD0340001Document.Factory.parse(str).getESD0340001().getDataArea().getEDIGrpCustCollection().getEDIGrpCustArray();
            list = new ArrayList<BkgEdiGrpCustVO>();
	        for (EDIGrpCust ediGrpCust : group_cust_array) {
	        	bkgEdiGrpCustVO = new BkgEdiGrpCustVO();
	        	bkgEdiGrpCustVO.setEsvcGrpCd    (ediGrpCust.getGROUPCD     ());
	        	bkgEdiGrpCustVO.setCoCd         (ediGrpCust.getCOMPANYCD   ());
	        	bkgEdiGrpCustVO.setCntCd        (ediGrpCust.getCNTCD       ());
	        	bkgEdiGrpCustVO.setCustSeq      (ediGrpCust.getCUSTCD      ());
	        	bkgEdiGrpCustVO.setScNo         (ediGrpCust.getSCNO        ());
	        	bkgEdiGrpCustVO.setBkgCfmFlg    (ediGrpCust.getBOKCONYN    ());
	        	bkgEdiGrpCustVO.setBkgCfmAutoFlg(ediGrpCust.getBCAUTOIND   ());
	        	bkgEdiGrpCustVO.setBlDrftAutoFlg(ediGrpCust.getBLAUTOIND   ());
	        	bkgEdiGrpCustVO.setBlDrftFlg    (ediGrpCust.getBLDRFTYN    ());
	        	bkgEdiGrpCustVO.setCgoTrakFlg   (ediGrpCust.getCGOTRKYN    ());
	        	bkgEdiGrpCustVO.setAnFlg        (ediGrpCust.getARVNTSYN    ());
	        	bkgEdiGrpCustVO.setEsvcBlTpCd   (ediGrpCust.getBLTYPECD    ());
	        	bkgEdiGrpCustVO.setBkgCtrtTpCd  (ediGrpCust.getBKGCTRTDIVCD());
	        	bkgEdiGrpCustVO.setDeltFlg      (ediGrpCust.getDELYN       ());
	        	bkgEdiGrpCustVO.setEaiSts       (ediGrpCust.getEAISTS      ());
	        	bkgEdiGrpCustVO.setBkgCustTpDesc(ediGrpCust.getCUSTTYPES());
	        	bkgEdiGrpCustVO.setBlDrftAutoDys(ediGrpCust.getBLAUTODAYS());
	        	bkgEdiGrpCustVO.setBlDrftAutoOnceSndFlg(ediGrpCust.getBLAUTOONCYN());
	        	bkgEdiGrpCustVO.setUltiNewAsiaCustFlg(ediGrpCust.getULTPNEWASA());
	        	bkgEdiGrpCustVO.setUltiTrnsCustFlg(ediGrpCust.getULTPTRANS());
	        	
	        	list.add(bkgEdiGrpCustVO);
	        }
			dbDao.manageBkgEdiGrpCust(list);
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}

	/**
	 * BKG의 VVD의 BDR LOG FLAG를  조회한다. <br>
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @param String rdoTrunkFeeder
	 * @return String
	 * @throws EventException
	 */
	public String checkVvdBdrLog(String vvdCd,String polCd,String podCd,String rdoTrunkFeeder) throws EventException {
		try {
			return  dbDao.checkVvdBdrLog(vvdCd,polCd,podCd,rdoTrunkFeeder);
		
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * bkgNo가 china agent bkg no인지 조회한다.<br>
	 * 
	 * @param 	String bkgNo
	 * @return 	String 
	 * @exception EventException
	 */	
	public String searchIsChnMnlBkgNo(String bkgNo) throws EventException {
		try {
			return  dbDao.searchIsChnMnlBkgNo(bkgNo);
		
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	/**
	 * Retrieve 처리합니다.<br>
	 * 
	 * @param ZipCdSchVO vo
	 * @param int iPage
	 * @return List<ZipCdListVO>
	 * @exception EventException
	 */
	public List<ZipCdListVO> searchZipCode(ZipCdSchVO vo,int iPage) throws EventException{
		
	try {
			 return dbDao.searchZipCode(vo, iPage);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
 	
	/**
	 * zip code 을 SAVE 처리합니다.<br>
	 * 
	 * @param ZipCdListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageZipCode(ZipCdListVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {

					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					vos[i].setEvntUsrId(account.getUsr_id());
					vos[i].setEvntOfcCd(account.getOfc_cd());
					
					if ( vos[i].getIbflag().equals("I")){						
						dbDao.mergeZipCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.mergeZipCode(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeZipCode(vos[i]);
					}
				}
			}
            
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Agent List Retrieve.<br>
	 * 
	 * @param BkgCstmsChnAgnCdVO vo
	 * @return List<BkgCstmsChnAgnCdVO>
	 * @exception EventException
	 */
	public List<BkgCstmsChnAgnCdVO> searchCstmsChnAgnCdList(BkgCstmsChnAgnCdVO vo) throws EventException{
		
	try {
			 return dbDao.searchCstmsChnAgnCdList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieve 처리.<br>
	 * 
	 * @param BkgCstmsChnAgnCdVO vo
	 * @return List<BkgCstmsChnAgnCdVO>
	 * @exception EventException
	 */
	public List<BkgCstmsChnAgnStupVO> searchCstmsChnAgnStup(BkgCstmsChnAgnCdVO vo) throws EventException{
		
	try {
			 return dbDao.searchCstmsChnAgnStup(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
 	
	/**
	 * zip code 을 SAVE 처리합니다.<br>
	 * 
	 * @param BkgCstmsChnAgnStupVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsChnAgnStup(BkgCstmsChnAgnStupVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {

					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						vos[i].setCreOfcCd(account.getOfc_cd());
						dbDao.addCstmsChnAgnStup(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyCstmsChnAgnStup(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeCstmsChnAgnStup(vos[i]);
					}
				}
			}
            
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_BKG_1130] Import Restricted Commodities Set-up 화면조회
	 * Retrieve 처리.<br>
	 * 
	 * @param RestrictCmdtListVO vo
	 * @return List<RestrictCmdtListVO>
	 * @exception EventException
	 */
	public List<RestrictCmdtListVO> searchRestrictCmdtList(RestrictCmdtListVO vo) throws EventException{
		
	try {
			 return dbDao.searchRestrictCmdtList(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_BKG_1130] 
	 * Restricted, Prohibited 를 중복체크 한다.<br> 
	 *Import Restricted Commodities Set-up<br>
	 * 
	 * @param RestrictCmdtListVO vo
	 * @return List<RestrictCmdtDupListVO>
	 * @exception EventException
	 */
	public List<RestrictCmdtDupListVO> searchRestrictCmdtDupList(RestrictCmdtListVO vo) throws EventException{
		
		try {
				 return dbDao.searchRestrictCmdtDupList(vo);
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
			}
		}
	
	/**
	 * [ESM_BKG_1130] Import Restricted Commodities Set-up 화면조회
	 * Save 처리.<br>
	 * 
	 * @param RestrictCmdtListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRetrictCmdtList(RestrictCmdtListVO[] vos,SignOnUserAccount account) throws EventException{
		try {
			List<BkgImpImgStoVO> list = new ArrayList<BkgImpImgStoVO>();

			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {

					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addRestrictCmdt(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyRestrictCmdt(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeRestrictCmdt(vos[i]);
						// BKG_IMP_IMG_STO 내용도 삭제.
						BkgImpImgStoVO imgStoVO = new BkgImpImgStoVO();
						imgStoVO.setRgnOfcCd(vos[i].getRgnOfcCd());
						imgStoVO.setLocCd(vos[i].getLocCd());
						imgStoVO.setDpSeq(vos[i].getDpSeq());
						list.add(imgStoVO);
						dbDao.removeRestrictCmdtFile(list); 
					}
				}
			}
        
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_BKG_1131] Import Restricted Commodities File Upload
	 * Retrieve 처리.<br>
	 * 
	 * @param RestrictCmdtFileVO vo
	 * @return List<BkgImpImgStoVO>
	 * @exception EventException
	 */
	public List<BkgImpImgStoVO> searchRestrictCmdtFile(RestrictCmdtFileVO vo) throws EventException{
		
	try {
		return dbDao.searchRestrictCmdtFile(vo);
		
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_BKG_1131] Import Restricted Commodities File Upload
	 * Save 처리.<br>
	 * 
	 * @param RestrictCmdtFileVO restrictCmdtFileVO
	 * @exception EventException
	 */
	public void manageRestrictCmdtFile(RestrictCmdtFileVO restrictCmdtFileVO) throws EventException{
		try {
			
			log.debug("[START:: BookingMasterMgtBCImpl == manageRestrictCmdtFile  ]==========");
			BkgImpImgStoVO[] bkgImpImgStoVO = restrictCmdtFileVO.getBkgImpImgStoVOs();
			SignOnUserAccount account = restrictCmdtFileVO.getAccount();
			String[] fileSavId = restrictCmdtFileVO.getKeys();
			String rgnOfcCd = restrictCmdtFileVO.getRgnOfcCd();
			String locCd = restrictCmdtFileVO.getLocCd();
			String cntCd = restrictCmdtFileVO.getCntCd();
			String dpSeq = restrictCmdtFileVO.getDpSeq();
			
			List<BkgImpImgStoVO> insertVoList = new ArrayList<BkgImpImgStoVO>();
			List<BkgImpImgStoVO> deleteVoList = new ArrayList<BkgImpImgStoVO>();
			List<BkgImpImgStoVO> updateVoList = new ArrayList<BkgImpImgStoVO>();
			int save_id_cnt = 0;
			
			if(bkgImpImgStoVO != null) {
				for ( int i=0; i<bkgImpImgStoVO.length; i++ ) {
					
					// 공통 파라미터 설정
					bkgImpImgStoVO[i].setRgnOfcCd(rgnOfcCd);
					bkgImpImgStoVO[i].setLocCd(locCd);
					bkgImpImgStoVO[i].setCntCd(cntCd);
					bkgImpImgStoVO[i].setDpSeq(dpSeq);
					if (bkgImpImgStoVO[i].getIbflag().equals("U")) {
						log.debug("[START:: BookingMasterMgtBCImpl]updateVoList=====" + bkgImpImgStoVO[i].getFileSavId());
						deleteVoList.add(bkgImpImgStoVO[i]);
						bkgImpImgStoVO[i].setIbflag("I");
					}
					
					if (bkgImpImgStoVO[i].getIbflag().equals("D")) {
						log.debug("[START:: BookingMasterMgtBCImpl]deleteVoList=====" + bkgImpImgStoVO[i].getFileSavId());
						deleteVoList.add(bkgImpImgStoVO[i]);
						UpdateFileMetaInfo.delete(bkgImpImgStoVO[i].getFileSavId());
						
					} else if (bkgImpImgStoVO[i].getIbflag().equals("I")) {
						log.debug("[START:: BookingMasterMgtBCImpl]insertVoList=====" + bkgImpImgStoVO[i].getFileSavId());
	
						if (bkgImpImgStoVO[i].getFileSavId() == null || bkgImpImgStoVO[i].getFileSavId().length() == 0) {
							bkgImpImgStoVO[i].setFileSavId(fileSavId[save_id_cnt++]);
						}
	
						bkgImpImgStoVO[i].setCreUsrId(account.getUsr_id());
						bkgImpImgStoVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(bkgImpImgStoVO[i]);
					}
				}
			}
				
				if (deleteVoList.size() > 0) {

					dbDao.removeRestrictCmdtFile(deleteVoList);
				}
				if (insertVoList.size() > 0) {
					dbDao.addRestrictCmdtFile(insertVoList);

					// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
					updateVoList.add(bkgImpImgStoVO[0]);
					dbDao.modifyRestrictCmdtFile(updateVoList);
				}
            
		} catch(DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * DPCS - Office 별 시간을 조회 한다.(ESM_BKG_0441)<br>
	 * 
	 * @param BkgDpcsOfcTmVO vo
	 * @return List<BkgDpcsOfcTmVO>
	 * @exception EventException
	 */
	public List<BkgDpcsOfcTmVO> searchDpcsOfcTm(BkgDpcsOfcTmVO vo) throws EventException {
		try {
			return dbDao.searchDpcsOfcTm(vo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	/**
	 * DPCS - Office 별 시간을 관리한다.(ESM_BKG_0441)<br>
	 * 
	 * @param BkgDpcsOfcTmVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageDpcsOfcTm(BkgDpcsOfcTmVO[] vos,SignOnUserAccount account) throws EventException {
		try {
			for ( int i=0; i< vos.length; i++ ) {
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());
				
				if ( vos[i].getIbflag().equals("I")){
					dbDao.addDpcsOfcTm(vos[i]);
				}
				if ( vos[i].getIbflag().equals("U")){
					dbDao.modifyDpcsOfcTm(vos[i]);
				}
				if ( vos[i].getIbflag().equals("D")){
					dbDao.removeDpcsOfcTm(vos[i]);
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * 타선사와 VVD 표현 방식이 다른 경우 매핑되는 데이터를 조회한다.(ESM_BKG_1150).<br>
	 * @param BkgMapgVvdVO bkgMapgVvdVO
	 * @return List<BkgMapgVvdVO>
	 * @throws EventException
	 */
	public List<BkgMapgVvdVO> searchMapgVvd(BkgMapgVvdVO bkgMapgVvdVO) throws EventException{
		try {
			return dbDao.searchMapgVvd(bkgMapgVvdVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
	}
	
	
	/**
	 * 타선사와 VVD 표현 방식이 다른 경우 매핑되는 데이터를 저장한다.(ESM_BKG_1150).<br>
	 * @param BkgMapgVvdVO[] bkgMapgVvdVOs
	 * @throws EventException
	 */
	public void manageMapgVvd(BkgMapgVvdVO[] bkgMapgVvdVOs) throws EventException{
		
		BookingUtil utilCmd = new BookingUtil();
		BkgMapgVvdVO bkgMapgVvdVO = null;
		List<BkgMapgVvdVO> chkbkgMapgVvdVOs = null;

		try {

			for(int i=0; i < bkgMapgVvdVOs.length; i++) {
				
				bkgMapgVvdVO = bkgMapgVvdVOs[i];
				
				// VALID CHECK
				if(!utilCmd.validateVvd (bkgMapgVvdVO.getVslCd(),bkgMapgVvdVO.getSkdVoyNo(),bkgMapgVvdVO.getSkdDirCd())){
					throw new EventException((String)new ErrorHandler("BKG00163").getMessage()); 
				}				
				// ADD
				if (bkgMapgVvdVO.getIbflag().equals("I")) {
					chkbkgMapgVvdVOs = dbDao.searchMapgVvd(bkgMapgVvdVO);
					if(chkbkgMapgVvdVOs != null && chkbkgMapgVvdVOs.size() > 0) {
						throw new EventException((String)new ErrorHandler("BKG00488", new String[]{"VVD:"+bkgMapgVvdVOs[i].getVslCd()
																										 +bkgMapgVvdVOs[i].getSkdVoyNo()
																										 +bkgMapgVvdVOs[i].getSkdDirCd()}).getMessage());
					}
					
					dbDao.addMapgVvd(bkgMapgVvdVO);
				}
				// MODIFY  
				if (bkgMapgVvdVO.getIbflag().equals("U")) 
					dbDao.modifyMapgVvd(bkgMapgVvdVO);
				// DELETE
				if (bkgMapgVvdVO.getIbflag().equals("D"))
					dbDao.deleteMapgVvd(bkgMapgVvdVO);
				
			}
		}catch(EventException e){
			throw e;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}	
	}
	
    /**
     * select Hard Coding Setup List
     * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
     * @return List<BkgHrdCdgDescVO>
     * @throws EventException
     */	
    public List<BkgHrdCdgDescVO> searchHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO) throws EventException{
    	try {
			 return dbDao.searchHrdCdgDesc(bkgHrdCdgDescVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
	/**Hard Coding Setup List Insert, Update, Delete.
	 * @param BkgHrdCdgDescVO[] bkgHrdCdgDescVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHrdCdgDesc(BkgHrdCdgDescVO[] bkgHrdCdgDescVOs,SignOnUserAccount account) throws EventException {
		// 파라메터 객체 변환
		try {			
			// 작업 구분 분할
			
			if(bkgHrdCdgDescVOs!=null && bkgHrdCdgDescVOs.length>0){
				for(int i=0; i<bkgHrdCdgDescVOs.length; i++) {
	
					if (bkgHrdCdgDescVOs[i].getIbflag().equals("I")) {
						dbDao.addHrdCdgDesc(bkgHrdCdgDescVOs[i],account);					
					}else if (bkgHrdCdgDescVOs[i].getIbflag().equals("D")) {
//						dbDao.removeHrdCdgChild(bkgHrdCdgDescVOs[i],account);
						dbDao.removeHrdCdgDesc(bkgHrdCdgDescVOs[i],account);
					}else if (bkgHrdCdgDescVOs[i].getIbflag().equals("U")) {
						dbDao.modifyHrdCdgDesc(bkgHrdCdgDescVOs[i],account);
	
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	/**
	 * select Hard Coding Contents List
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */	
    public List<BkgHrdCdgCtntVO> searchHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws EventException{
    	try {
			 return dbDao.searchHrdCdgCtnt(bkgHrdCdgCtntVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
    
	/**
	 * Hard Coding contents List Insert, Update, Delete.
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */    
	public void manageHrdCdgCtnt(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs,SignOnUserAccount account) throws EventException{
		
		try {			
			// 작업 구분 분할
			
			if(bkgHrdCdgCtntVOs!=null && bkgHrdCdgCtntVOs.length>0){
				for(int i=0; i<bkgHrdCdgCtntVOs.length; i++) {
					
					if (bkgHrdCdgCtntVOs[i].getIbflag().equals("I")) {
						dbDao.addHrdCdgCtnt(bkgHrdCdgCtntVOs[i],account);					
					}else if (bkgHrdCdgCtntVOs[i].getIbflag().equals("D")) {
						dbDao.removeHrdCdgCtnt(bkgHrdCdgCtntVOs[i],account);
					}else if (bkgHrdCdgCtntVOs[i].getIbflag().equals("U")) {
						dbDao.modifyHrdCdgCtnt(bkgHrdCdgCtntVOs[i],account);
	
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	/**check if there is the same Hardcoding Id in DB
	 * @param String hrdCdgId
	 * @return String
	 * @throws EventException
	 */	
	public String checkHrdCdgId(String hrdCdgId) throws EventException {
		

		DBRowSet rowSet = null;							
        String retVal = "";
        try {
            rowSet=dbDao.checkHrdCdgId(hrdCdgId);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}	

	/**check if there is data on Hard coding contents
	 * @param hrdCdgId
	 * @return String
	 * @throws EventException
	 */
	public String checkChildCnt(String hrdCdgId) throws EventException{
		
		DBRowSet rowSet = null;							
        String retVal = "";
        try {
            rowSet=dbDao.checkChildCnt(hrdCdgId);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
		
	}	
	
	/**
	 * booking close for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgTsCoffTmVO[] bkgTsCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void closeTsBkgForBayPlan(BkgTsCoffTmVO[] bkgTsCoffTmVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<bkgTsCoffTmVOs.length; i++ ) {
				
				if ( bkgTsCoffTmVOs[i].getIbflag().equals("I")){
					bkgTsCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addBkgTsCoffTm(bkgTsCoffTmVOs[i]);					
				} else if ( bkgTsCoffTmVOs[i].getIbflag().equals("U")){
					bkgTsCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgTsCoffTm(bkgTsCoffTmVOs[i]);
				} 
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}

	}
	/**
	 * booking reopen for bayplan 정보를 저장한다.<br>
	 * 
	 * @param BkgTsCoffTmVO[] bkgTsCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void reopenTsBkgForBayPlan(BkgTsCoffTmVO[] bkgTsCoffTmVOs, SignOnUserAccount account) throws EventException{
		try {
			for ( int i=0; i<bkgTsCoffTmVOs.length; i++ ) {
				
				if ( bkgTsCoffTmVOs[i].getIbflag().equals("U")){
					bkgTsCoffTmVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgTsCoffTm(bkgTsCoffTmVOs[i]);
				} 
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * select BDR Access Authority List
	 * @param BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO
	 * @return List<BdrAccessAuthorityInfoVO>
	 * @throws EventException
	 */	
	 public List<BdrAccessAuthorityInfoVO> searchBdrAccessAuthority(BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) throws EventException{
    	try {
			 return dbDao.searchBdrAccessAuthority(bdrAccessAuthorityInfoVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    }
	
	 /**
		 * BDR Access Authority List Insert, Update, Delete.
		 * @param BdrAccessAuthorityInfoVO[] bdrAccessAuthorityInfoVOs
		 * @param SignOnUserAccount account
		 * @throws EventException
		 */    
		public void manageBdrAccessAuthority(BdrAccessAuthorityInfoVO[] bdrAccessAuthorityInfoVOs, SignOnUserAccount account) throws EventException{
			
			try {			
				// 작업 구분 분할
				
				if(bdrAccessAuthorityInfoVOs!=null && bdrAccessAuthorityInfoVOs.length>0){
					for(int i=0; i<bdrAccessAuthorityInfoVOs.length; i++) {
						bdrAccessAuthorityInfoVOs[i].setUpdUsrId(account.getUsr_id());
						bdrAccessAuthorityInfoVOs[i].setCreUsrId(account.getUsr_id());
						
						if (bdrAccessAuthorityInfoVOs[i].getIbflag().equals("I")) {
							dbDao.addBdrAccessAuthority(bdrAccessAuthorityInfoVOs[i]);					
						}else if (bdrAccessAuthorityInfoVOs[i].getIbflag().equals("D")) {
							dbDao.deleteBdrAccessAuthority(bdrAccessAuthorityInfoVOs[i]);
						}else if (bdrAccessAuthorityInfoVOs[i].getIbflag().equals("U")) {
							dbDao.modifyBdrAccessAuthority(bdrAccessAuthorityInfoVOs[i]);
		
						}
					}
				}
			} catch (DAOException de) {
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
			}
		}
		
	/**
	 * E-BKG Handling Office 등록 화면 - 조회
	 * @param BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO
	 * @return List<BkgHandlingOfficeSetupVO>
	 * @throws EventException
	 */	
	 public List<BkgHandlingOfficeSetupVO> searchHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws EventException{
    	try {
			 return dbDao.searchHandlingOffice(bkgHandlingOfficeSetupVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
    } 
	 
	/**
     * E-BKG Handling Office 등록 화면 - 등록/수정/삭제<br>	
	 * 화면 ESM_BKG_1180
     * 
	 * @param BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageHandlingOffice(BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVO, SignOnUserAccount account) throws EventException{
    	
    	if(bkgHandlingOfficeSetupVO == null)
			return;
    	
		try {
			
			List<BkgHandlingOfficeSetupVO> insertVoList = new ArrayList<BkgHandlingOfficeSetupVO>();
			List<BkgHandlingOfficeSetupVO> updateVoList = new ArrayList<BkgHandlingOfficeSetupVO>();
			List<BkgHandlingOfficeSetupVO> deleteVoList = new ArrayList<BkgHandlingOfficeSetupVO>();
			List<BkgHandlingOfficeSetupVO> dupChkVoList = new ArrayList<BkgHandlingOfficeSetupVO>();
			
			for ( int i=0; i<bkgHandlingOfficeSetupVO.length; i++ ) {
				
				bkgHandlingOfficeSetupVO[i].setUpdUsrId(account.getUsr_id());

				if ( bkgHandlingOfficeSetupVO[i].getIbflag().equals("I")){
					insertVoList.add(bkgHandlingOfficeSetupVO[i]);
					dupChkVoList.add(bkgHandlingOfficeSetupVO[i]);
				} else if ( bkgHandlingOfficeSetupVO[i].getIbflag().equals("U")){
					updateVoList.add(bkgHandlingOfficeSetupVO[i]);
					dupChkVoList.add(bkgHandlingOfficeSetupVO[i]);
				} else if ( bkgHandlingOfficeSetupVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgHandlingOfficeSetupVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeHandlingOffice(deleteVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyHandlingOffice(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addHandlingOffice(insertVoList);
			}
			
			if ( dupChkVoList.size() > 0 ) {
				boolean dupChk = dbDao.checkHandlingOfficeDup(dupChkVoList);
				if(dupChk)
					throw new EventException(new ErrorHandler("BKG01126", new String[]{}).getMessage());
			}
			
			
		} catch(EventException ex) {
			throw ex;	
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}	
    }	 
    
	/**
	 * BKG_VRFD_WGT_CLZ_SET TABLE(Documentation Cut-off Time)  조회<br>
	 * 
	 * @param String locCd
	 * @param String vslSlanCd
	 * @return List<BkgVGMClzSetListVO>
	 * @exception EventException
	 */
	public List<BkgVgmClzSetListVO> searchVgmCutOffTimeList(String locCd, String vslSlanCd) throws EventException{
		
		try {
			 return dbDao.searchVgmCutOffTimeList(locCd, vslSlanCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * VGM Cut-off Time 을 SAVE 처리합니다.<br>
	 * 
	 * @param BkgVgmClzSetVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVgmCutOffTimeList(BkgVgmClzSetVO[] vos,SignOnUserAccount account) throws EventException{
	 	 
		try {
			if (vos != null && vos.length >0){
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					
					if ( vos[i].getIbflag().equals("I")){
						dbDao.addVgmCutOffTime(vos[i]);
					}
					if ( vos[i].getIbflag().equals("U")){
						dbDao.modifyVgmCutOffTime(vos[i]);
					}
					if ( vos[i].getIbflag().equals("D")){
						dbDao.removeVgmCutOffTime(vos[i]);
					}
					if(!"ALL".equals(vos[i].getVvdCd()) && vos[i].getVvdCd().length() == 9)
						dbDao.updateVgmCutOffTimeByVvd(vos[i]);
				}
			}
            
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
    
    
}
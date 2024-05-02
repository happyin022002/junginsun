/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITurnTimePerformanceFinderBCBCImpl.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration.CIMCommonDBDAO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.ComIntgCdListDataVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.CommonComboSetVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchEdiVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CimTpSzDpSeqVO;

/**
 * OPUS--CNTROperatioNPerformanceMgt Business Logic Basic Command implementation
 *
 * @author 
 * @see CIMCommonBC DAO class reference
 * @since J2EE 1.6
 */

public class CIMCommonBCImpl extends BasicCommandSupport implements CIMCommonBC {

	// Database Access Object
	private transient CIMCommonDBDAO dbDao = null;

	/**
	 * creating CIMCommonBCImpl object
	 * creating CIMCommonBCDBDAO
	 */
	public CIMCommonBCImpl() {
		dbDao = new CIMCommonDBDAO();
	}
	/**
	 * retrieving TPSZSequence List
	 * 
	 * @return List<TypeSizeSequenceVO>
	 * @exception EventException
	 */
	public List<TypeSizeSequenceVO> searchTPSZSequenceList() throws EventException {
		try {
			return dbDao.searchTPSZSequenceList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21003",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * checking Location
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException 
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException {
		String check = null;
		try {
		//	if("Y".equals(locLevel)){
		//		check = dbDao.checkLocationYardr(locLevel ,locCD);
		//	}
		//	else if("O".equals(locLevel) || "C".equals(locLevel) || "P".equals(locLevel)){
				check = dbDao.checkLocation(locLevel ,locCD);
		//	}
		//	else{
		//		check = dbDao.checkLocationEqOrzCht(locLevel ,locCD);
		//	}
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21017",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	/**
	 * checking VVD
	 * 
	 * @param vvd 
	 * @return String
	 * @exception EventException 
	 */
	public String checkVVD(String vvd) throws EventException {
		String check = null;
		try {
			check = dbDao.checkVVD(vvd);
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21009",new String[]{""}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}	
	
	/**
	 * retrieving Port List
	 * 
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchPortList() throws EventException {
		String[] arrPort = null;
		try {
			arrPort = dbDao.searchPortList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21011",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}	

	/**
	 * retrieving Lane List by trade
	 *  
	 * @param trade
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchLaneList(String trade) throws EventException {
		String[] arrPort = null;
		try {
			arrPort = dbDao.searchLaneList(trade);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21007",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}
	
	/**
	 * validating inputed lane code
	 * 
	 * @param lane 
	 * @return String
	 * @exception EventException 
	 */
	public String checkLane(String lane) throws EventException {
		String check = null;
		try {
			check = dbDao.checkLane(lane);
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21008",new String[]{""}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}		
	
	/**
	 * retrieving Rcc List
	 * 
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchRCCList() throws EventException {
		String[] arrPort = null;
		try {
			arrPort = dbDao.searchRCCList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21010",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}		
	
	/**
	 * retrieving Combo in PortTurnTime screen
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException 
	 */
	public CommonComboSetVO searchPortTurnTimeCombo() throws EventException {
		String[] sPort = null;
		String[] sLane = null;
		List<TypeSizeSequenceVO> list = null;
		CommonComboSetVO sReturn = new CommonComboSetVO();
		try {
			sPort = dbDao.searchPortList();
			sLane = dbDao.searchLaneList(null);
			list = dbDao.searchTPSZSequenceList();
			sReturn.setSPort(sPort);
			sReturn.setSLane(sLane);
			sReturn.setTypeSizeSequenceVO(list);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21011",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sReturn;
	}	
	
	/**
	 * retrieving CntrTypeSize List
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCntrTypeSizeList() throws EventException {
		// implementing object for DB ResutlSet to transmit data
		String[] arrTpsz = null;

		try {
			arrTpsz = dbDao.searchCntrTypeSizeList();

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrTpsz;
	}
	
	
	/**
	 * retrieving Trade List
	 * 
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchTradeList() throws EventException {
		String[] arrTrade = null;
		try {
			arrTrade = dbDao.searchTradeList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21015",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrTrade;
	}		
	
	/**
	 * retrieving Combo in  AroundTurnTime screen
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException 
	 */
	public CommonComboSetVO searchAroundTurnTimeCombo() throws EventException {
		String[] sTrade = null;
		//String[] sLane = null;
		String[] sTpsz = null;
		CommonComboSetVO sReturn = new CommonComboSetVO();
		
		try {
			sTrade = dbDao.searchTradeList();
		//	sLane = dbDao.searchLaneList();
			sTpsz = dbDao.searchCntrTypeSizeList();
			
			sReturn.setSTrade(sTrade);
			sReturn.setSTpsz(sTpsz);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21011",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sReturn;
	}		
	
	/**
	 * retrieving Combo in REPOResultByPort screen
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException 
	 */
	public CommonComboSetVO searchREPOResultByPortCombo() throws EventException {
		String[] sPort = null;
		String[] sLane = null;
		String[] sRcc = null;
		List<TypeSizeSequenceVO> list = null;
		CommonComboSetVO sReturn = new CommonComboSetVO();
//		Map<String, Object> sReturn = new HashMap<String, Object>();
		try {
			sPort = dbDao.searchPortList();
			sLane = dbDao.searchLaneList(null);
			sRcc = dbDao.searchRCCList();
			list = dbDao.searchTPSZSequenceList();
			sReturn.setSPort(sPort);
			sReturn.setSLane(sLane);
			sReturn.setSRcc(sRcc);
			sReturn.setTypeSizeSequenceVO(list);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sReturn;
	}
	
	/**
	 * retrieving COM_INTG_CD
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<ComIntgCdListDataVO>
	 * @exception EventException
	 */	
	public List<ComIntgCdListDataVO> searchComIntgCdListBasic(String intgCdId, String intgCdVal) throws EventException {
		try {
			return dbDao.searchComIntgCdListData(intgCdId,intgCdVal);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	
	/**
	 * retrieving COM_INTG_CD
	 * @return List<ComIntgCdListDataVO>
	 * @exception EventException
	 */	
	public List<ComIntgCdListDataVO> searchComAreaGrpIdListBasic() throws EventException {
		try {
			return dbDao.searchComAreaGrpIdListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("",new String[]{}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	

	/**
	 * Retrieving Container Type Size Division<br>
	 * 
	 * @return List<CimTpSzDpSeqVO>
	 * @exception EventException
	 */
	public List<CimTpSzDpSeqVO> searchCntrTypeSizeDivListBasic() throws EventException {
		try {
			return dbDao.searchCntrTypeSizeDivListData();
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("CIM00013", new String[]{"Container Type Size Division List Search"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("CIM00013", new String[]{"Container Type Size Division List Search"}).getMessage(),de);
		}
	}



	/**
	 * Saving Container Type Size Division<br>
	 * 
	 * @param CimTpSzDpSeqVO[] cimTpSzDpSeqVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCntrTypeSizeDivBasic(CimTpSzDpSeqVO[] cimTpSzDpSeqVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CimTpSzDpSeqVO> insertVoList = new ArrayList<CimTpSzDpSeqVO>();
			List<CimTpSzDpSeqVO> updateVoList = new ArrayList<CimTpSzDpSeqVO>();
			List<CimTpSzDpSeqVO> deleteVoList = new ArrayList<CimTpSzDpSeqVO>();
			for ( int i=0; i<cimTpSzDpSeqVOs .length; i++ ) {
				if ( cimTpSzDpSeqVOs[i].getIbflag().equals("I")){
					cimTpSzDpSeqVOs[i].setCreUsrId(account.getUsr_id());
					cimTpSzDpSeqVOs[i].setUpdUsrId(account.getUsr_id());
					cimTpSzDpSeqVOs[i].setCreOfcCd(account.getOfc_cd());
					cimTpSzDpSeqVOs[i].setUpdOfcCd(account.getOfc_cd());
					insertVoList.add(cimTpSzDpSeqVOs[i]);
				} else if ( cimTpSzDpSeqVOs[i].getIbflag().equals("U")){
					cimTpSzDpSeqVOs[i].setUpdUsrId(account.getUsr_id());
					cimTpSzDpSeqVOs[i].setUpdOfcCd(account.getOfc_cd());
					updateVoList.add(cimTpSzDpSeqVOs[i]);
				} else if ( cimTpSzDpSeqVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cimTpSzDpSeqVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCntrTypeSizeDivData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrTypeSizeDivData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntrTypeSizeDivData(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("CIM00013", new String[]{"Container Type Size Division Manage"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("CIM00013", new String[]{"Container Type Size Division Manage"}).getMessage(),de);
		}
	}
	
	
	/**
	 * Booking Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarBookingInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException {
		try {
			return dbDao.bookingInformationListData ( oscarBookingSearchVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Vessel Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarVesselInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException {
		try {
			return dbDao.vesselInformationListData ( oscarBookingSearchVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Container Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarContainerInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException {
		try {
			return dbDao.containerInformationListData ( oscarBookingSearchVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Movement Information<br>
	 *
	 * @param  SearchMovementListByContainerVO searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByContainerVO> searchOscarMovementInformationListBasic(SearchMovementListByContainerVO searchMovementListByContainerVO) throws EventException {
		try {
			return dbDao.movementHistoryInformationListData ( searchMovementListByContainerVO ); 
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Movement Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarMovementEdiErrInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException {
		try {
			return dbDao.movementEdiErrInformationListData ( oscarBookingSearchVO ); 
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Movement Information<br>
	 *
	 * @param  SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @exception EventException
	 */
	public List<SearchEDIMovementListVO> searchOscarEdiMessageInformationListBasic(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		try {
			return dbDao.ediMessageHistoryInformationListData ( searchEDIMovementListVO ); 
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Container Status Information<br>
	 *
	 * @param  CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusOptionVO>
	 * @exception EventException
	 */
	public List<CntrStatusListVO> searchOscarCntrStatusInformationListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException {
		try {
			return dbDao.cntrStatusInquiryListData ( cntrStatusOptionVO ); 
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * EES_CIM_2001 : save <br>
	 * saving Movement Maintenace
	 * @author Park Young Jin
	 * @category EES_CIM_2001
	 * @category actionOscarMovementBasic 
	 * @param OscarBookingSearchVO[] oscarBookingSearchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	@Override
	public void actionOscarMovementBasic(OscarBookingSearchVO[] oscarBookingSearchVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OscarBookingSearchVO> insertVoList = new ArrayList<OscarBookingSearchVO>();
			List<OscarBookingSearchVO> updateVoList = new ArrayList<OscarBookingSearchVO>();
			List<OscarBookingSearchVO> updateOkVoList = new ArrayList<OscarBookingSearchVO>();
			List<OscarBookingSearchVO> deleteVoList = new ArrayList<OscarBookingSearchVO>();
			List<OscarBookingSearchVO> deleteOkVoList = new ArrayList<OscarBookingSearchVO>();
			
			int RowNum = 0;
			int RowNext = 0;
			for (int i = 0; i < oscarBookingSearchVOs.length; i++) {
				if (oscarBookingSearchVOs[i].getIbflag().equals("U")) {
					RowNum = RowNext + 1;
					
					oscarBookingSearchVOs[i].setRowNum(Integer.toString(RowNum));
							
					/*if(oscarBookingSearchVOs[i].getMvmtEdiTpCd() == null) oscarBookingSearchVOs[i].setMvmtEdiTpCd("0");
					if(oscarBookingSearchVOs[i].getMvmtEdiMsgTpId() == null) oscarBookingSearchVOs[i].setMvmtEdiMsgTpId("0");
					if(oscarBookingSearchVOs[i].getMvmtEdiMsgAreaCd() == null) oscarBookingSearchVOs[i].setMvmtEdiMsgAreaCd("0");
					if(oscarBookingSearchVOs[i].getMvmtEdiMsgYrmondy() == null) oscarBookingSearchVOs[i].setMvmtEdiMsgYrmondy("0");
					if(oscarBookingSearchVOs[i].getMvmtEdiMsgSeq() == null) oscarBookingSearchVOs[i].setMvmtEdiMsgSeq("0");*/
					
					/*log.debug(">>>>>>"+oscarBookingSearchVOs[i].getMvmtEdiTpCd());
					log.debug(">>>>>>"+oscarBookingSearchVOs[i].getMvmtEdiMsgTpId());
					log.debug(">>>>>>"+oscarBookingSearchVOs[i].getMvmtEdiMsgAreaCd());
					log.debug(">>>>>>"+oscarBookingSearchVOs[i].getMvmtEdiMsgYrmondy());
					log.debug(">>>>>>"+oscarBookingSearchVOs[i].getMvmtEdiMsgSeq());					
					log.debug(">>>>>>"+oscarBookingSearchVOs[i].getStatus());
					log.debug(">>>>>>"+oscarBookingSearchVOs[i].getBkgNo());
					
					log.debug("ORG_YD_CD>>>>>>"+oscarBookingSearchVOs[i].getOrgYdCd());
					log.debug("CRNT_VSL_CD>>>>>>"+oscarBookingSearchVOs[i].getCrntVslCd());
					log.debug("CRNT_SKD_VOY_NO>>>>>>"+oscarBookingSearchVOs[i].getCrntSkdVoyNo());
					log.debug("CRNT_SKD_DIR_CD>>>>>>"+oscarBookingSearchVOs[i].getCrntSkdDirCd());
					*/
					if("O.K".equals(oscarBookingSearchVOs[i].getStatus())) {
						updateOkVoList.add(oscarBookingSearchVOs[i]);
					}else{
						updateVoList.add(oscarBookingSearchVOs[i]);
						RowNext = RowNext+1;
					}
				}
				
				if (oscarBookingSearchVOs[i].getIbflag().equals("I")) {
					insertVoList.add(oscarBookingSearchVOs[i]);
				}
				
				if (oscarBookingSearchVOs[i].getIbflag().equals("D")) {
					if("O.K".equals(oscarBookingSearchVOs[i].getStatus())) {
						deleteOkVoList.add(oscarBookingSearchVOs[i]);
					}else{
						deleteVoList.add(oscarBookingSearchVOs[i]);
					}
					
				}
			}
			
			// 1 Insert CTM_MOVEMENT
			// 2 UPDATE MST_CONTAINER
			// 3 UPDATE BKG_CONTRAINER
			// 4 UPDATE CTM_MVMT_EDI_MSG
			// 5 INSERT CTM_MVMT_EDI_RSLT
			if (updateVoList.size() > 0) {
				dbDao.addCtmMovementData(updateVoList);
				dbDao.modifyCtmMovementforSplitNoData(updateVoList);
				dbDao.modifyMstContainerData(updateVoList);
				dbDao.modifyBkgContainerData(updateVoList);
				dbDao.modifyBkgContainerEtcData(updateVoList);
				dbDao.modifyCtmBkgContainerData(updateVoList);
				dbDao.modifyCtmMvmtEdiMsgData(updateVoList);

				equipmentMovementMgtChk(updateVoList, account);
				dbDao.addCtmMvmtEdiRsltData(updateVoList);
			}

			// OK 처리인경우.
			if (updateOkVoList.size() > 0) {
				dbDao.modifyCtmMovementData(updateOkVoList);
				dbDao.modifyMstContainerData(updateOkVoList);
				dbDao.modifyBkgContainerData(updateOkVoList);
				dbDao.modifyBkgContainerEtcData(updateOkVoList);
				dbDao.modifyCtmBkgContainerData(updateOkVoList);
			}

			
			if (insertVoList.size() > 0) {
				dbDao.addCtmMovementData(insertVoList); // Update와 같다.
				dbDao.modifyCtmMovementforSplitNoData(insertVoList);
				dbDao.modifyMstContainerData(insertVoList);
				dbDao.modifyBkgContainerData(insertVoList);
				dbDao.modifyBkgContainerEtcData(insertVoList);
				dbDao.modifyCtmBkgContainerData(insertVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.modifyResultAsDelForMvmtEdiMsgData(deleteVoList);
				dbDao.modifyCtmMovementEdiMsgData(deleteVoList);
			}

			if (deleteOkVoList.size() > 0) {
				dbDao.addCtmMvmtCorrData(deleteOkVoList);
				dbDao.removeCtmMovementData(deleteOkVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024").getMessage(), ex);
		}
	}	
	
	
	
	/**
	 * EES_CIM_2001 : save <br>
	 * saving Movement Master Change
	 * @author Park Young Jin
	 * @category EES_CIM_2001
	 * @category actionOscarMovementBasic 
	 * @param List<OscarBookingSearchVO> oscarBookingSearchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void equipmentMovementMgtChk(List<OscarBookingSearchVO> oscarBookingSearchVOs, SignOnUserAccount account) throws EventException {
		
		CrossItemVO item = new CrossItemVO();
		String[] rtnStr = new String[4];
		CusCtmMovementVO cusVo = new CusCtmMovementVO();
		CusCtmMovementVO sel_cusVo = new CusCtmMovementVO();
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		
		try {	
			for (int i = 0; i < oscarBookingSearchVOs.size(); i++) {
				//Set Setting##################################
				//Select 조회쿼리			
				
				cusVo.setMvmtStsCd(oscarBookingSearchVOs.get(i).getMvmtStsCd());
				cusVo.setOrgYdCd(oscarBookingSearchVOs.get(i).getOrgYdCd());
				cusVo.setCntrTpszCd(oscarBookingSearchVOs.get(i).getCntrTpszCd());
				cusVo.setCntrNo(oscarBookingSearchVOs.get(i).getCntrNo());				
				cusVo.setBkgNo(oscarBookingSearchVOs.get(i).getBkgNo());
				
				cusVo.setFcntrFlg(oscarBookingSearchVOs.get(i).getFcntrFlg());
				cusVo.setBkgCgoTpCd(oscarBookingSearchVOs.get(i).getBkgCgoTpCd());
				cusVo.setCnmvEvntDt(oscarBookingSearchVOs.get(i).getCnmvEvntDt());
				cusVo.setMvmtEdiMsgTpId(oscarBookingSearchVOs.get(i).getMvmtEdiMsgTpId());
				cusVo.setMvmtCreTpCd(oscarBookingSearchVOs.get(i).getMvmtCreTpCd());
				cusVo.setCreUsrId(oscarBookingSearchVOs.get(i).getCreUsrId());
				cusVo.setVndrSeq(oscarBookingSearchVOs.get(i).getVndrSeq());
				cusVo.setCrntVslCd(oscarBookingSearchVOs.get(i).getCrntVslCd());
				
				cusVo.setCrntSkdVoyNo(oscarBookingSearchVOs.get(i).getCrntSkdVoyNo());
				cusVo.setCrntSkdDirCd(oscarBookingSearchVOs.get(i).getCrntSkdDirCd());
				cusVo.setIbflag(oscarBookingSearchVOs.get(i).getIbflag());
				cusVo.setCnmvCycNo(oscarBookingSearchVOs.get(i).getCnmvCycNo());				
				cusVo.setUpdUsrId(oscarBookingSearchVOs.get(i).getUpdUsrId());
				cusVo.setWoNo(oscarBookingSearchVOs.get(i).getWoNo());
				
				cusVo.setMvmtEdiMsgAreaCd(oscarBookingSearchVOs.get(i).getMvmtEdiMsgAreaCd());
				cusVo.setMvmtEdiMsgSeq(oscarBookingSearchVOs.get(i).getMvmtEdiMsgSeq());
				cusVo.setMvmtEdiMsgYrmondy(oscarBookingSearchVOs.get(i).getMvmtEdiMsgYrmondy());
				cusVo.setMvmtEdiTpCd(oscarBookingSearchVOs.get(i).getMvmtEdiTpCd());
				
				
				//데이타조회...
				
					sel_cusVo = dbDao.getCntrMvmtInfo(cusVo);
					
				
					cusVo.setCnmvYr(sel_cusVo.getCnmvYr());
					cusVo.setCnmvIdNo(sel_cusVo.getCnmvIdNo());
					cusVo.setCnmvSeq(sel_cusVo.getCnmvSeq());
					cusVo.setCnmvSplitNo(sel_cusVo.getCnmvSplitNo());			
					cusVo.setImdtExtFlg(sel_cusVo.getImdtExtFlg());	//CTM_MOVEMENT TABLE IMDT_EXT_FLG 
					cusVo.setCntrSvrId(sel_cusVo.getCntrSvrId()); //CTR.SYS_AREA_GRP_ID AS CNTR_SVR_ID,
					item.setPrevSts("");		//BKG_CONTAINER테이블의 CNMV_STS_CD 값이 PREV_STS_CD 이다.
					item.setMnrCallYN("N");	
					item.setCusCtmMovementVO(cusVo);
					
					log.debug("strCntrNo>>>>>>>>>>"+item.getCusCtmMovementVO().getCntrNo());
					
					
					String preSts = (item.getPrevSts() == null ? "": item.getPrevSts());
					if ( "EUR".equals(cusVo.getCntrSvrId()) ) {
						String stsCd = (cusVo.getMvmtStsCd() == null ? "": cusVo.getMvmtStsCd());
						log.info("PREV ::: " + preSts + stsCd);
						if ("VL".equals(stsCd) || "XX".equals(stsCd) || "OP".equals(stsCd) || "MT".equals(stsCd) || ( ("EN".equals(stsCd) || "TN".equals(stsCd)) && "MT".equals(preSts)) ){
							com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC emptyCommand =
								new com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl();
							emptyCommand.updateCimCntrStk(item);
						}
					}
					
					// committing even though failure of calling COP
					String fCntr = item.getCusCtmMovementVO().getFcntrFlg();
					
					log.debug("fCntr>>>>>>>>>>>>>>>>>"+fCntr);
					log.debug("oscarBookingSearchVOs.get(i).getFcntrFlg()>>>>>>>>>>>>>>>>>"+oscarBookingSearchVOs.get(i).getFcntrFlg());
					log.debug("cusVo.getBkgCgoTpCd()>>>>>>>>>>>>>>>>>"+cusVo.getBkgCgoTpCd());
					log.debug("oscarBookingSearchVOs.get(i).getBkgCgoTpCd()>>>>>>>>>>>>>>>>>"+oscarBookingSearchVOs.get(i).getBkgCgoTpCd());
					log.debug("cusVo.getBkgNo()>>>>>>>>>>>>>>>>>"+cusVo.getBkgNo());
					log.debug("cusVo.getCntrNo()>>>>>>>>>>>>>>>>>"+cusVo.getCntrNo());
					log.debug("cusVo.getBkgNo()>>>>>>>>>>>>>>>>>"+cusVo.getBkgNo());
					log.debug("cusVo.getOrgYdCd()>>>>>>>>>>>>>>>"+cusVo.getOrgYdCd());
					log.debug("cusVo.getMvmtStsCd()>>>>>>>>>>>>>"+cusVo.getMvmtStsCd());
					log.debug("cusVo.getCnmvEvntDt()>>>>>>>>>>>>"+cusVo.getCnmvEvntDt());
					log.debug("cusVo.getMvmtEdiMsgTpId()>>>>>>>>"+cusVo.getMvmtEdiMsgTpId());
					log.debug("cusVo.getMvmtCreTpCd()>>>>>>>>>>"+cusVo.getMvmtCreTpCd());
					log.debug("cusVo.getCreUsrId()>>>>>>>>>>>>>>"+cusVo.getCreUsrId());
					log.debug("cusVo.getVndrSeq()>>>>>>>>>>>>>>"+cusVo.getVndrSeq());
					log.debug("cusVo.getCrntVslCd()>>>>>>>>>>>>>"+cusVo.getCrntVslCd());
					log.debug("cusVo.getCrntSkdVoyNo()>>>>>>>>>>"+cusVo.getCrntSkdVoyNo());
					log.debug("cusVo.getCrntSkdDirCd()>>>>>>>>>>>"+cusVo.getCrntSkdDirCd());
					
					log.debug("cusVo.getCnmvYr()>>>>>>>>>>>>>>>>>"+cusVo.getCnmvYr());
					log.debug("cusVo.getCnmvIdNo()>>>>>>>>>>>>>>>>>"+cusVo.getCnmvIdNo());
					log.debug("cusVo.getCnmvSeq()>>>>>>>>>>>>>>>>>"+cusVo.getCnmvSeq());
					log.debug("cusVo.getCnmvSplitNo()>>>>>>>>>>>>>>>>>"+cusVo.getCnmvSplitNo());
					log.debug("cusVo.getCnmvCycNo()>>>>>>>>>>>>>>>>>"+cusVo.getCnmvCycNo());
					log.debug("cusVo.getImdtExtFlg()>>>>>>>>>>>>>>>>>"+cusVo.getImdtExtFlg());
					
					log.debug("cusVo.getMvmtEdiMsgAreaCd()>>>>>>>>>>>>>>>>>"+cusVo.getMvmtEdiMsgAreaCd());
					log.debug("cusVo.getMvmtEdiMsgSeq()>>>>>>>>>>>>>>>>>"+cusVo.getMvmtEdiMsgSeq());
					log.debug("cusVo.getMvmtEdiMsgYrmondy()>>>>>>>>>>>>>>>>>"+cusVo.getMvmtEdiMsgYrmondy());
					log.debug("cusVo.getMvmtEdiTpCd()>>>>>>>>>>>>>>>>>"+cusVo.getMvmtEdiTpCd());
					log.debug("cusVo.getMvmtEdiMsgTpId()>>>>>>>>>>>>>>>>>"+cusVo.getMvmtEdiMsgTpId());
					
					if ( (("F".equals(fCntr) || "Y".equals(fCntr)) || "F".equals(cusVo.getBkgCgoTpCd()) || "R".equals(cusVo.getBkgCgoTpCd())) && cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo()) && cusVo.getBkgNo().length()==12) {
		
						com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO sceVO =
							new com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO();
						com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand =
							new com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
						
						sceVO.setCntrNo(cusVo.getCntrNo());
						sceVO.setBkgNo(cusVo.getBkgNo());
						sceVO.setNodCd(cusVo.getOrgYdCd());
						sceVO.setActStsMapgCd(cusVo.getMvmtStsCd());
						sceVO.setActDt(cusVo.getCnmvEvntDt());
						sceVO.setEdiMsgTpCd(cusVo.getMvmtEdiMsgTpId());
						sceVO.setCreTpCd(cusVo.getMvmtCreTpCd());
						sceVO.setCreUsrId(cusVo.getCreUsrId());
						sceVO.setVndrSeq(cusVo.getVndrSeq());
						sceVO.setVslCd(cusVo.getCrntVslCd());
						sceVO.setSkdVoyNo(cusVo.getCrntSkdVoyNo());
						sceVO.setSkdDirCd(cusVo.getCrntSkdDirCd());
						sceVO.setBndVskdSeqCd(cusVo.getIbflag());
		
						sceVO.setCnmvYr(cusVo.getCnmvYr());
						sceVO.setCnmvIdNo(cusVo.getCnmvIdNo());
						sceVO.setCnmvSeq(cusVo.getCnmvSeq());
						sceVO.setCnmvSplitNo(cusVo.getCnmvSplitNo());
						sceVO.setCnmvCycNo(cusVo.getCnmvCycNo());
						sceVO.setImdtExtFlg(cusVo.getImdtExtFlg());
		
						sceCommand.createCOPMVMT(sceVO);
					}
					
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>2");
					boolean modifyCntrOpResult = false;
					// saving ctm_mvmt_irr in case return is ture after saving bkg_container by BKG request (default return is false)
					String rtn = command.updateEtcModule(item, modifyCntrOpResult);
					if (rtn.equals("N")) {
						rtnStr[0] = "N";
						rtnStr[1] = "Insert irr fail!";
					}
					
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>3");
					// calling MNR in case item.getMnrCallYN() = 'Y' only 2010.09.03
					// setting flag to call MNR in case status of manageStsOperation is OP and Damage Flag from MST_CONTAINER is Y
					if ("Y".equals(item.getMnrCallYN()) && item.getBkgNo().length() == 12) {
	
						com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC mnrCommand =
							new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl();
						com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO customMnrEqStsVO =
							new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO();
	
						/* mandatory input value
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  matching table :  MNR_EQ_STS*/
						 
						customMnrEqStsVO.setMnrDmgFlg("0");    // flaging : '1', unflaging '0'
						customMnrEqStsVO.setEqKndCd("U");    // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(item.getCusCtmMovementVO().getCntrNo());    // Container No
						customMnrEqStsVO.setEqTpszCd(item.getCusCtmMovementVO().getCntrTpszCd());    // Type/Size
						customMnrEqStsVO.setMnrDmgFlgYdCd(item.getCusCtmMovementVO().getOrgYdCd());    // yard code occurring OP
	
						mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
					}
					
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>4");
					CusCtmMovementVO movementVO = item.getCusCtmMovementVO();
					if(movementVO != null) {
						//try {
							new WorkOrderManagementBCImpl().modifyWorkOrderExecuteDate(movementVO.getCntrNo(),  movementVO.getCnmvEvntDt(),  movementVO.getWoNo(),  movementVO.getOrgYdCd(), movementVO.getMvmtStsCd(), movementVO.getBkgNo(),  movementVO.getUpdUsrId());
						//} catch(Exception e) {
						//	log.error("Error-[TRS]modifyWorkOrderExecuteDate " + e.toString(), e);
						//}
					}
				}
		
		} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024").getMessage(), ex);
		}
	}
	
	
	/**
	 * EES_CIM_2001 : save <br>
	 * saving Cyc Change Maintenace
	 * @author Park Young Jin
	 * @category EES_CIM_2001
	 * @category actionOscarMovementBasic 
	 * @param OscarBookingSearchVO[] oscarBookingSearchVOs
	 * @exception EventException
	 */		
	@Override
	public void actionBookingCycChangeBasic(OscarBookingSearchVO[] oscarBookingSearchVOs) throws EventException {
		try {
			for (int i = 0; i < oscarBookingSearchVOs.length; i++) {
				if (oscarBookingSearchVOs[i].getIbflag().equals("U")) {
					dbDao.modifyBookingCycChangeData(oscarBookingSearchVOs[i]); 
				}
			}
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024").getMessage(), ex);
		}
	}	
	
	
	/**
	 * EdiError Total
	 * 
	 * @param OscarBookingSearchEdiVO oscarBookingSearchEdiVO
	 * @return int
	 * @exception EventException 
	 */
	public int searchEdiErrorTotalCnt(OscarBookingSearchEdiVO oscarBookingSearchEdiVO) throws EventException {
		int totalCnt = 0;
		try {
			totalCnt = dbDao.searchEdiErrorTotalCnt(oscarBookingSearchEdiVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
		
		return totalCnt;
	}
	
	
	/**
	 * EdiError Information<br>
	 *
	 * @param  OscarBookingSearchEdiVO oscarBookingSearchEdiVO
	 * @return List<OscarBookingSearchEdiVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchEdiVO> searchOscarEdiErrorListBasic(OscarBookingSearchEdiVO oscarBookingSearchEdiVO) throws EventException {
		try {
			return dbDao.ediErrorInformationListData ( oscarBookingSearchEdiVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}
	
}
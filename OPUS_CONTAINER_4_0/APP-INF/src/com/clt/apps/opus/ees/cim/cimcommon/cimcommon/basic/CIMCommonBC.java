/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITurnTimePerformanceFinderBC.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.ComIntgCdListDataVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.CommonComboSetVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchEdiVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CimTpSzDpSeqVO;

/**
 * OPUS-Cntroperationperformancemgt Business Logic Command Interface
 *
 * @author
 * @see Ui_cim_1001EventResponse reference
 * @since J2EE 1.4
 */

public interface CIMCommonBC {
	/**
	 * retrieving TPSZSequence List
	 * 
	 * @return List<TypeSizeSequenceVO>
	 * @exception EventException
	 */
	public List<TypeSizeSequenceVO> searchTPSZSequenceList() throws EventException;
	
	/**
	 * checking Location
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException;
	
	/**
	 * checking VVD
	 * 
	 * @param vvd
	 * @return String
	 * @exception EventException
	 */
	public String checkVVD(String vvd) throws EventException;
	
	

	/**
	 * retrieving Port List
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPortList() throws EventException;	
	
	/**
	 * retrieving lane list by trade
	 * 
	 * @param trade
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchLaneList(String trade) throws EventException;	
	
	
	/**
	 * validating inputed lane code
	 * 
	 * @param lane
	 * @return String
	 * @exception EventException
	 */
	public String checkLane(String lane) throws EventException;

	
	/**
	 * retrieving Rcc List
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchRCCList() throws EventException;		
	
	/**
	 * retrieving Combo list in PortTurnTime screen
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException
	 */
	public CommonComboSetVO searchPortTurnTimeCombo() throws EventException;	
	
	
	/**
	 * retrieving CntrTypeSize List
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCntrTypeSizeList() throws EventException;		
	
	
	/**
	 * retrieving Trade List
	 * 
	 * @return String[]
	 * @exception EventException
	 */ 
	public String[] searchTradeList() throws EventException;	
	
	/**
	 * retrieving Combo in AroundTurnTime screen
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException
	 */
	public CommonComboSetVO searchAroundTurnTimeCombo() throws EventException;	
	
	
	/**
	 * retrieving Combo REPOResultByPort screen
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException
	 */
	public CommonComboSetVO searchREPOResultByPortCombo() throws EventException;	
	
	/**
	 * retrieving COM_INTG_CD
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<ComIntgCdListDataVO>
	 * @exception EventException
	 */	
	public List<ComIntgCdListDataVO> searchComIntgCdListBasic(String intgCdId, String intgCdVal) throws EventException;
	
	
	/**
	 * Retrieving Container Type Size Division<br>
	 * 
	 * @return List<CimTpSzDpSeqVO>
	 * @exception EventException
	 */
	public List<CimTpSzDpSeqVO> searchCntrTypeSizeDivListBasic() throws EventException;



	/**
	 * Saving Container Type Size Division<br>
	 * 
	 * @param CimTpSzDpSeqVO[] cimTpSzDpSeqVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCntrTypeSizeDivBasic(CimTpSzDpSeqVO[] cimTpSzDpSeqVOs,SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * Booking Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarBookingInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException;
	
	
	/**
	 * Vessel Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarVesselInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException;
	
	
	/**
	 * Container Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarContainerInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException;
	
	/**
	 * Movement Information<br>
	 *
	 * @param  SearchMovementListByContainerVO searchMovementListByContainerVO
	 * @return List<SearchMovementListByContainerVO>
	 * @exception EventException
	 */
	public List<SearchMovementListByContainerVO> searchOscarMovementInformationListBasic(SearchMovementListByContainerVO searchMovementListByContainerVO) throws EventException;
	
	/**
	 * Movement Information<br>
	 *
	 * @param  OscarBookingSearchVO oscarBookingSearchVO
	 * @return List<OscarBookingSearchVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchVO> searchOscarMovementEdiErrInformationListBasic(OscarBookingSearchVO oscarBookingSearchVO) throws EventException;
	
	
	/**
	 * Movement Information<br>
	 *
	 * @param  SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @exception EventException
	 */
	public List<SearchEDIMovementListVO> searchOscarEdiMessageInformationListBasic(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException;
	
	
	/**
	 * Container Status Information<br>
	 *
	 * @param  CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusListVO>
	 * @exception EventException
	 */
	public List<CntrStatusListVO> searchOscarCntrStatusInformationListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;
	
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
	public void actionOscarMovementBasic(OscarBookingSearchVO[] oscarBookingSearchVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * EES_CIM_2001 : save <br>
	 * saving Cyc Change Maintenace
	 * @author Park Young Jin
	 * @category EES_CIM_2001
	 * @category actionOscarMovementBasic 
	 * @param OscarBookingSearchVO[] oscarBookingSearchVOs
	 * @exception EventException
	 */
	public void actionBookingCycChangeBasic(OscarBookingSearchVO[] oscarBookingSearchVOs) throws EventException;
	
	
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
	public void equipmentMovementMgtChk(List<OscarBookingSearchVO> oscarBookingSearchVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * retrieving COM_INTG_CD
	 * @return List<ComIntgCdListDataVO>
	 * @exception EventException
	 */	
	public List<ComIntgCdListDataVO> searchComAreaGrpIdListBasic() throws EventException ;
	
	
	/**
	 * EdiError Information<br>
	 *
	 * @param  OscarBookingSearchEdiVO oscarBookingSearchEdiVO
	 * @return List<OscarBookingSearchEdiVO>
	 * @exception EventException
	 */
	public List<OscarBookingSearchEdiVO> searchOscarEdiErrorListBasic(OscarBookingSearchEdiVO oscarBookingSearchEdiVO) throws EventException;
	
	/**
	 * EdiError Total
	 * 
	 * @param OscarBookingSearchEdiVO oscarBookingSearchEdiVO
	 * @return int
	 * @exception EventException 
	 */
	public int searchEdiErrorTotalCnt(OscarBookingSearchEdiVO oscarBookingSearchEdiVO) throws EventException;
	
}
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : locationsBC.java
*@FileTitle : contient
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.basic;
 
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.CountryVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LseComYardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.RegionVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.SubContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.EqOrgChartVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneGroupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Commoncode Business Logic Command Interface<br>
 * An interface to the business logic for Common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface LocationBC {

	/**
	 * Continent retrieve.<br>
	 * 
	 * @param String contiCd
	 * @return ContinentVO
	 * @exception EventException
	 */
	public ContinentVO searchContiCode(String contiCd) throws EventException;
	
	/**
	 * Continent save.<br>
	 * 
	 * @param ContinentVO continentVO
	 * @exception EventException
	 */
	public void manageContiCode(ContinentVO continentVO) throws EventException;
	
	/**
	 * Sub Continent retrieve.<br>
	 * 
	 * @param String scontiCd
	 * @return SubContinentVO
	 * @exception EventException
	 */
	public SubContinentVO searchSubContiCode(String scontiCd) throws EventException;
	
	/**
	 * Sub Continent save.<br>
	 * 
	 * @param SubContinentVO subContinentVO
	 * @exception EventException
	 */
	public void manageSubContiCode(SubContinentVO subContinentVO) throws EventException;
	
	/**
	 * Country retrieve.<br>
	 * 
	 * @param String cntCd
	 * @return ContinentVO
	 * @exception EventException
	 */
	public CountryVO searchCountryCode(String cntCd) throws EventException;
	
	/**
	 * Country save.<br>
	 * 
	 * @param CountryVO countryVO
	 * @exception EventException
	 */
	public void manageCountryCode(CountryVO countryVO) throws EventException;
	
	/**
	 * Region retrieve.<br>
	 * 
	 * @param String rgnCd
	 * @return ContinentVO
	 * @exception EventException
	 */
	public RegionVO searchRegionCode(String rgnCd) throws EventException;
	
	/**
	 * Region save.<br>
	 * 
	 * @param RegionVO rgnVO
	 * @exception EventException
	 */
	public void manageRegionCode(RegionVO rgnVO) throws EventException;
	
	/**
	 * State retrieve.<br>
	 * 
	 * @param String steCd
	 * @param String cntCd
	 * @return StateVO
	 * @exception EventException
	 */
	public StateVO searchStateCode(String steCd, String cntCd) throws EventException;
	
	/**
	 * State save.<br>
	 * 
	 * @param StateVO steVO
	 * @exception EventException
	 */
	public void manageStateCode(StateVO steVO) throws EventException;
	
	/**
	 * Location retrieve.<br>
	 * 
	 * @param String locCd
	 * @return LocationVO
	 * @exception EventException
	 */
	public LocationVO searchLocCode(String locCd) throws EventException;
	
	/**
	 * Location retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return LocationVO
	 * @exception EventException
	 */
	public LocationVO searchLocCodeRqst(String rqstNo) throws EventException;
	
	/**
	 * Location save.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception EventException
	 */
	public void manageLocCode(LocationVO locVO) throws EventException;
	
	/**
	 * Location save.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception EventException
	 */
	public void manageLocCodeRqst(LocationVO locVO) throws EventException;
	
	/**
	 * Yard retrieve.<br>
	 * 
	 * @param String ydCd
	 * @return YardVO
	 * @exception EventException
	 */
	public YardVO searchYardCode(String ydCd) throws EventException;
	
	/**
	 * Yard retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return YardVO
	 * @exception EventException
	 */
	public YardVO searchYardRqst(String rqstNo) throws EventException;
	
	/**
	 * Yard save.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception EventException
	 */
	public void manageYardCode(YardVO ydVO) throws EventException;
	
	/**
	 * Yard save.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception EventException
	 */
	public void manageYardRqst(YardVO ydVO) throws EventException;
	
	/**
	 * Equipment ORG Chart retrieve.<br>
	 * 
	 * @param String locType
	 * @param String location
	 * @param String deltFlg
	 * @return List<EqOrgChartVO>
	 * @exception EventException
	 */
	public List<EqOrgChartVO> searchEqOrgChtList(String locType, String location, String deltFlg) throws EventException;
	
	/**
	 * EQ ORZ CHT Del Validation
	 * @param String sccCd
	 * @return String
	 * @exception EventException
	 */
	public String checkDelValidation(String sccCd) throws EventException;
	
	/**
	 * Equipment ORG Chart save.<br>
	 * 
	 * @param EqOrgChartVO[] eqOrgChartVOs
	 * @param SignOnUserAccount account
	 * @return List<EqOrgChartVO>
	 * @exception EventException
	 */
	public List<EqOrgChartVO> manageEqOrgCht(EqOrgChartVO[] eqOrgChartVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Leasing Company Yard retrieve.<br>
	 * 
	 * @param String lseCoYdCd
	 * @return LseComYardVO
	 * @exception EventException
	 */
	public LseComYardVO searchLseCoYd(String lseCoYdCd) throws EventException;
	
	/**
	 * Leasing Company Yard save.<br>
	 * 
	 * @param LseComYardVO lseCoYdVO
	 * @exception EventException
	 */
	public void manageLseCoYd(LseComYardVO lseCoYdVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * DayLight Saving Time  retrieve.<br>
	 * 
	 * @param String dstId
	 * @return DaySavingTimeVO
	 * @exception EventException
	 */
	public DaySavingTimeVO searchDyLgtSavTm(String dstId) throws EventException;
	
	/**
	 * DayLight Saving Time save.<br>
	 * 
	 * @param DaySavingTimeVO dystVO
	 * @exception EventException
	 */
	public void manageDyLgtSavTm(DaySavingTimeVO dystVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Zone retrieve.<br>
	 * 
	 * @param String znCd
	 * @return ZoneGroupVO
	 * @exception EventException
	 */
	public ZoneGroupVO searchZoneCode(String znCd) throws EventException;
	
	/**
	 * Zone retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return ZoneGroupVO
	 * @exception EventException
	 */
	public ZoneGroupVO searchZoneRqst(String rqstNo) throws EventException;
	
	/**
	 * Zone save.<br>
	 * 
	 * @param ZoneGroupVO zoneGroupVO
	 * @exception EventException
	 */
	public void manageZoneCode(ZoneGroupVO zoneGroupVO) throws EventException;
	
	/**
	 * Zone save.<br>
	 * 
	 * @param ZoneGroupVO zoneGroupVO
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageZoneRqst(ZoneGroupVO zoneGroupVO, String rqstNo) throws EventException;
	
	/**
	 * Zone save.<br>
	 * 
	 * @param ZoneGroupVO zoneGroupVO
	 * @exception EventException
	 */
	public void manageZoneRqst(ZoneGroupVO zoneGroupVO) throws EventException;
	
	/**
	 * Country Info retrieve.<br>
	 * 
	 * @param String rgnCd
	 * @return LocationVO
	 * @exception EventException
	 */
	public LocationVO searchCountryInfo(String rgnCd) throws EventException;
	
	/**
	 * Call EQR_CREATE_LOC_LVL_PRC Procedure.<br>
	 * 
	 * @param String usrId
	 * @exception EventException
	 */
	public void callEqrLocLvl(String usrId) throws EventException;
	
	/**
	 * LOCATION & EQ SCC Validation<br>
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkLocSccValidation(String locCd) throws EventException;
	
	/**
	 * DayLight Saving Time save.<br>
	 * exce load save
	 * @param DaySavingTimeVO dystVO
	 * @exception EventException
	 */
	public void manageExcelDyLgtSavTm(DaySavingTimeVO dystVO) throws EventException;
	
	/**
	 * Transfer Location Info To EAI 
	 * 
	 * @param locCd
	 * @param usrId
	 * @param creFlag
	 * @throws EventException
	 */
	public void sendLocToEai(String locCd, String usrId, String creFlag) throws EventException;

	/**
	 * Transfer Yard Info To EAI
	 * 
	 * @param ydCd
	 * @param usrId
	 * @param creFlag
	 * @throws EventException
	 */
	public void sendYardToEai(String ydCd, String usrId, String creFlag) throws EventException; 

	/**
	 * New DayLight Saving Time Code
	 * 
	 * @param ydCd
	 * @param usrId
	 * @param creFlag
	 * @throws EventException
	 */
	public String searchNewDstCode(String fnDstId, String dstNotAplySteCd) throws EventException;
	
	/**
	 * Prd Node 중복체크<br>
	 * 
	 * @param String z nCd
	 * @return ZoneGroupVO
	 * @exception EventException
	 */
	public String searchPrdNod(String nodCd) throws EventException; 

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtBC.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.GeneralCodeSearchGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.OfficeInfoListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.UnitPriceGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
	
/**
 * COM-Mnrcommon Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_initEventResponse reference
 * @since J2EE 1.4
 */
 
public interface GeneralCodeSearchMgtBC {
	/**
	 * [EES_MNR_0011] getting default Unit Of Measure per EQ TYPE of standard tarrif. <br>
	 *
	 * @param DefaultUnitOfMeasureVO InDefaultUnitOfMeasureVO
	 * @return DefaultUnitOfMeasureVO
	 * @exception EventException 
	 */  
	public DefaultUnitOfMeasureVO searchDEFUnitOfMeasureBasic(DefaultUnitOfMeasureVO inDefaultUnitOfMeasureVO) throws EventException;
	
	/**
	 * [EES_MNR_0189] retrieving M&R Service Provider Inquiry_Pop Up. <br>
	 *
	 * @param ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO
	 * @return ServiceProviderInfoListGRPVO
	 * @exception EventException
	 */
	public ServiceProviderInfoListGRPVO searchServiceProviderInfoListBasic(ServiceProviderInfoListGRPVO serviceProviderInfoListGRPVO) throws EventException ;
	/**
	 * [MNR_COMMON] retrieving common combo.<br>
	 * 
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @param SignOnUserAccount 	 account
	 * @return GeneralCodeSearchGRPVO 
	 * @exception EventException
	 */  
	public GeneralCodeSearchGRPVO searchComboInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0223] retrieving MNR PFMC by VNDR/Manufacturer. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchCommonInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;
	/**
	 * [EES_MNR_0226] retrieving Total Loss Request. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */
	public GeneralCodeSearchGRPVO searchEQGeneralInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0226] retrieving Simple W/O Inquiry Pop Up. <br>
	 *
	 * @param AGMTRtGRPVO agmtRtGRPVO
	 * @return AGMTRtGRPVO
	 * @exception EventException
	 */
	public AGMTRtGRPVO searchAgmtRtInfoBasic(AGMTRtGRPVO agmtRtGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023] retrieving Repair Estimate Creation. <br>
	 *
	 * @param CostCodeGRPVO costCodeGRPVO
	 * @return CostCodeGRPVO
	 * @exception EventException
	 */		 
	public CostCodeGRPVO searchCostCodeBasic(CostCodeGRPVO costCodeGRPVO) throws EventException;

	/**
	 * [EES_MNR_0194] retrieving Vessel Reefer Spare Part Purchase W/O Creation. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */		 
	public GeneralCodeSearchGRPVO searchVesselInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;

	/**
	 * [EES_MNR_0155] retrieving Disposal Buyer Management. <br>
	 *
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @return GeneralCodeSearchGRPVO
	 * @exception EventException
	 */		 
	public GeneralCodeSearchGRPVO searchCustomerInfoBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0157] retrieving Disposal Request. <br>
	 *
	 * @param UnitPriceGRPVO unitPriceGRPVO
	 * @return UnitPriceGRPVO
	 * @exception EventException
	 */
	public UnitPriceGRPVO searchUnitPriceBasic(UnitPriceGRPVO unitPriceGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0041] retrieving Curr rate to Conversion.  <br>
	 *
	 * @param UnitPriceGRPVO unitPriceGRPVO
	 * @return UnitPriceGRPVO
	 * @exception EventException
	 */
	public UnitPriceGRPVO searchCurrXchRtInfoBasic(UnitPriceGRPVO unitPriceGRPVO) throws EventException;
	
	/**
     * [EES_MNR_0019] Searching rfUnitMaker<br>
     * 
     * @param String eqNo
     * @return CustomMnrEqStsVVO
     * @throws EventException
     */
	public CustomMnrEqStsVVO searchRfUnitMakerBasic(String eqNo) throws EventException;
	
	/**
     * [EES_MNR_0052] Searching Bkg Code, Trade Code<br>
     * 
     * @param BkgTrdCodeVO bkgTrdCodeVO
     * @return List<BkgTrdCodeVO>
     * @throws EventException
     */
	public List<BkgTrdCodeVO> searchBkgTrdCdBasic(BkgTrdCodeVO bkgTrdCodeVO) throws EventException;
	
	/**
     * Searching LCC CODE<br>
     * 
     * @param CustomerInfoVO customerInfoVO
     * @return String
     * @throws EventException
     */
	public String searchOfcLccCdBasic(CustomerInfoVO customerInfoVO) throws EventException;
	
	/**
     * Searching RHQ OFC<br>
     * 
     * @param OfficeInfoListVO officeInfoListVO
     * @return String
     * @throws EventException
     */
	public String searchRhqOfcFmOfcCdBasic(OfficeInfoListVO officeInfoListVO) throws EventException;
	
	/**
     * [EES_MNR_0018] Searching Agreement Group<br>
     * 
     * @param  String eqType
     * @return List<CustomCostCodeVO>
     * @throws EventException
     */
	public List<CustomCostCodeVO> searchAgmtGrpBasic(String eqType) throws EventException;
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalfinderBC.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeParamVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCommonVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.OtherCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchDefaultDateVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-FMSCommon Business Logic Command Interface<br>
 * - OPUS-FMSCommon Biz Logic Interface<br>
 *
 * @author 
 * @see Esm_Fms_0022EventResponse 
 * @since J2EE 1.5
 */

public interface ExternalFinderBC {
	/**
	 * Handling retrieving event of Externalfinder<br>
	 * 
	 * @param searchVesselVO SearchVesselVO
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeList(SearchVesselVO searchVesselVO) throws EventException;
	
	/**
	 * Retrieving Owner Code of Owner Ship/Charter In/Hire Out<br>
	 * Getting Vessel Name information on Vessel Code at FMS UI<br>
	 * 
	 * @param vslCd String
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeName(String vslCd) throws EventException;
	
	/**
	 * Getting Location Name information on Location Code<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchLocCdName(String locCd) throws EventException;
	
	/**
	 * Getting Name information relevant to Flag Code<br>
	 * 
	 * @param vslCntCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchFlag(String vslCntCd) throws EventException;
	

	/**
	 * Retrieving Account Code<br>
	 * Generate Account Code Popup at FMS UI<br>
	 * 
	 * @param acctCd String
	 * @param acctGb String
	 * @return List<SearchMdmAccountCodeListVO>
	 * @exception EventException
	 */
	public List<SearchMdmAccountCodeListVO> searchMdmAccountCodeList(String acctCd,String acctGb) throws EventException ;

	/**
	 * Handling retrieving event in case inputting Location Code at D/Dock Schedule Input <br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException ;

	/**
	 *  Handling retrieving event in case inputting Lane Code at D/Dock Schedule Review-Graph<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLaneCode(String laneCd) throws EventException ;
	
	/**
	 * Handling retrieving event in case inputting VVD <br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkMdmVvdCode(String vvdCd) throws EventException;

	/**
	 * Carrier Code Selection - Window at FMS UI <br>
	 * 
	 * @param carrNm String
	 * @return List<SearchCarrierCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCarrierCodeListVO> searchCarrierCodeList(String carrNm) throws EventException;

	/**
	 * Lane Code Search - Window at FMS UI<br>
	 * 
	 * @param searchLaneCodeListVO SearchLaneCodeListVO
	 * @return List<SearchLaneCodeList>
	 * @exception EventException
	 */
	public List<SearchLaneCodeListVO> searchLaneCodeList(SearchLaneCodeListVO searchLaneCodeListVO) throws EventException;

	/**
	 *  Handling event in case inputting Revenue Lane Code<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkRevenueLaneCode(String laneCd) throws EventException ;
	
	/**
	 * Getting Carrier Code<br>
	 * 
	 * @param crrCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckCarrierCode(String crrCd) throws EventException;

	/**
	 * Retrieving Effective Date<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @param csrType String
	 * @return String
	 * @throws EventException
	 */
	public SearchDefaultDateVO checkEffectiveDate(String slpOfcCd, String effDt, String csrType) throws EventException ;
	
	/**
	 * Retrieving Center Code / City Code<br>
	 * 
	 * @param slpOfcCd String
	 * @return List<SearchCenterCodeVO>
	 * @exception EventException
	 */
	public List<SearchCenterCodeVO> searchCenterCode(String slpOfcCd) throws EventException ;
	
	/**
	 * Retrieving Office Code / Officd Name <br>
	 * 
	 * @return List<searchPaymenetOfficeCodeList>
	 * @exception EventException
	 */
	public List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeList() throws EventException ;
	
	/**
	 * Retrieving Currency rate<br>
	 * 
	 * @param acctXchRtYrmon String
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(String acctXchRtYrmon) throws EventException ;
	
	/**
	 * VVD Level Check for each Account<br>
	 * Handling retrieving voyage level event on UI in case inputing VVD code<br>
	 * 
	 * @param acctCd String
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkAcctCdVvdLevel(String acctCd, String vvdCd) throws EventException;

	/**
	 * Retrieve Other Code List <br>
	 * 
	 * @param codeTp String
	 * @return List<OtherCodeListVO>
	 * @exception EventException
	 */
	public List<OtherCodeListVO> searchOtherCodeList(String codeTp) throws EventException ;

	/**
	 * Save Other Code (insert / modify / remove)<br>
	 * 
	 * @param otherCodeListVOs OtherCodeListVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOtherCode(OtherCodeListVO[] otherCodeListVOs, String usrId) throws EventException;

	/**
	 * Default Eff Date <br>
	 * 
	 * @param vo SearchDefaultDateVO
	 * @return List<SearchDefaultDateVO>
	 * @exception EventException
	 */
	public List<SearchDefaultDateVO> searchDefaultDateInfo(SearchDefaultDateVO vo) throws EventException ;

	/**
	 * Contract No Search.
	 * @param vo
	 * @return List<SearchContractNoVO>
	 * @throws EventException
	 */
	public List<SearchContractNoVO> searchContractNoInfo(SearchContractNoVO vo) throws EventException ;
	
	/**
	 * FMS Contract Search.
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchContractInfoVO> searchContractInfo(SearchContractInfoVO vo) throws EventException;
	
	/**
	 * Search FMS Vendor By Contract no.<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchContractInfoVO> searchVendorByContractNo(SearchContractInfoVO vo) throws EventException ;
	
	/**
	 * Search Custmer By Vendor.<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchContractInfoVO> searchCustomerListByVendor(SearchContractInfoVO vo) throws EventException;
	
	/**
	 * Search Tax Type<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<FmsCodeInfoVO> searchTaxTypeList(FmsCodeParamVO vo) throws EventException;
	
	/**
	 * TI/TO 공통에 땨란 VVD 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFmsVvdByFletCtrtNo(FmsCommonVO fmsCommonVO) throws EventException;
	
	/**
	 * AR_FIN_DIR_CONV 에 존재 여부.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchArFincDirConvUsedFlag(FmsCommonVO fmsCommonVO) throws EventException;
	
	/**
	 * Service Lane direction 에 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchServiceLaneDirection(FmsCommonVO fmsCommonVO) throws EventException;
	
	/**
	 * Fin direction 에 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchFinDirection(FmsCommonVO fmsCommonVO) throws EventException;
}
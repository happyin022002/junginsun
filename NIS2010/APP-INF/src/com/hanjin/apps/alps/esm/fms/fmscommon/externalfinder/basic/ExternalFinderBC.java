/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalfinderBC.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.24 정윤태
* 1.0 Creation
* 2010.08.16 윤진영 CHM-201005318 searchMdmAccountCodeList 에서 account_code와 account_name으로 조회가능하도록 수정
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchSplRgstNoVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-FMSCommon Business Logic Command Interface<br>
 * - ALPS-FMSCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon-Tae, Jung
 * @see Esm_Fms_0022EventResponse 참조
 * @since J2EE 1.5
 */

public interface ExternalFinderBC {
	/**
	 * Externalfinder화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchVesselVO SearchVesselVO
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeList(SearchVesselVO searchVesselVO) throws EventException;
	
	/**
	 * 사선/용선/대선에 대한 Owner Code 조회<br>
	 * FMS 화면에서 Vessel Code에 대한 Vessel Name 정보 가져오기<br>
	 * 
	 * @param vslCd String
	 * @return List<SearchVesselVO>
	 * @exception EventException
	 */
	public List<SearchVesselVO> searchVesselCodeName(String vslCd) throws EventException;
	
	/**
	 * location Code에 대한 location Name 정보 가져오기<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchLocCdName(String locCd) throws EventException;
	
	/**
	 * Flag 코드에 해당하는 Name 정보 조회<br>
	 * 
	 * @param vslCntCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchFlag(String vslCntCd) throws EventException;
	

	/**
	 * Account Code 조회<br>
	 * FMS 화면에서                     Account Code Popup<br>
	 * 
	 * @param acctCd String 
	 * @param acctGb String
	 * @return List<SearchMdmAccountCodeListVO>
	 * @exception EventException
	 */
	public List<SearchMdmAccountCodeListVO> searchMdmAccountCodeList(String acctCd,String acctGb) throws EventException ;

	/**
	 *  D/Dock Schedule Input에서  Location Code 입력시 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException ;

	/**
	 *  D/Dock Schedule Review-Graph에서  Lane Code 입력시)화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLaneCode(String laneCd) throws EventException ;
	
	/**
	 * 화면에서 VVD Code 입력시 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkMdmVvdCode(String vvdCd) throws EventException;

	/**
	 * Carrier Code Selection - Window 조회<br>
	 * FMS 화면에서                     Carrier Code Selection - Window<br>
	 * 
	 * @param carrNm String
	 * @return List<SearchCarrierCodeListVO>
	 * @exception EventException
	 */
	public List<SearchCarrierCodeListVO> searchCarrierCodeList(String carrNm) throws EventException;

	/**
	 * Lane Code Search - Window 조회<br>
	 * FMS 화면에서Lane Code Search - Window<br>
	 * 
	 * @param searchLaneCodeListVO SearchLaneCodeListVO
	 * @return List<SearchLaneCodeList>
	 * @exception EventException
	 */
	public List<SearchLaneCodeListVO> searchLaneCodeList(SearchLaneCodeListVO searchLaneCodeListVO) throws EventException;

	/**
	 *  Revenue Lane Code 입력시 이벤트 처리<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkRevenueLaneCode(String laneCd) throws EventException ;
	
	/**
	 * Carrier Code 가져오기<br>
	 * 
	 * @param crrCd String
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckCarrierCode(String crrCd) throws EventException;

	/**
	 * Effective Date 조회<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @return String
	 * @exception EventException
	 */
	public String checkEffectiveDate(String slpOfcCd, String effDt) throws EventException ;
	
	/**
	 * Center Code / City Code 를 조회한다<br>
	 * 
	 * @param slpOfcCd String
	 * @return List<SearchCenterCodeVO>
	 * @exception EventException
	 */
	public List<SearchCenterCodeVO> searchCenterCode(String slpOfcCd) throws EventException ;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Office Code / Officd Name 을 조회한다<br>
	 * 
	 * @return List<SearchCenterCodeVO>
	 * @exception EventException
	 */
	public List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeList() throws EventException ;
	
	/**
	 * 사업자 등록 번호를 조회한다<br>
	 * 
	 * @param String splRgstNo
	 * @return List<SearchSplRgstNoVO>
	 * @exception EventException
	 */
	public List<SearchSplRgstNoVO> searchSplRgstNo(String splRgstNo) throws EventException ;
	
	/**
	 * 환율 조회<br>
	 * 
	 * @param acctXchRtYrmon String
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(String acctXchRtYrmon) throws EventException ;
	
	/**
	 * Account 별 VVD Level Check<br>
	 * 화면에서 VVD Code 입력시 화면에 대한 항차 레벨 조회 이벤트 처리<br>
	 * 
	 * @param acctCd String
	 * @param vvdCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkAcctCdVvdLevel(String acctCd, String vvdCd) throws EventException;
	
	/**
	 * Contract 존재하는 체크를 합니다 (Notice 에서 사용).<br>
	 * 
	 * @param String agmtNo
	 * @return String
	 * @exception EventException
	 */		
	public String searchContractCtrtNtcInfo(String agmtNo) throws EventException;
	
	/**
	 * Contract No Search.
	 * 
	 * @param vo
	 * @return List<SearchContractNoVO>
	 * @throws EventException 
	 */
	public List<SearchContractNoVO> searchContractNoInfo(SearchContractNoVO vo) throws EventException ;
	
	/**
	 * Pay Term Search by Supplier
	 * 
	 * @param String sValue
	 * @return String
	 * @throws EventException
	 */
	public String searchPayTermByVndrSeq(String sValue) throws EventException ;
	
	/**
	 * Rgst No Search by Supplier
	 * 
	 * @param String sValue
	 * @return String
	 * @throws EventException
	 */
	public String searchRgstNoByVndrSeq(String sValue) throws EventException ;

}
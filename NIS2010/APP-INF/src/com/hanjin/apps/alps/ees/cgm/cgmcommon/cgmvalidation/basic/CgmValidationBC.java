/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationBC.java
*@FileTitle : cgm_validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.21 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Cgmcommon Business Logic Command Interface<br>
 * - ALPS-Cgmcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM CHANG SIK
 * @see Cgm_validationEventResponse 참조
 * @since J2EE 1.6
 */

public interface CgmValidationBC {

	/**
	 * 입력한 Office code 가 유효한지 체크 . Retrieve. <br>
	 * 
	 * @param officeINVO OfficeINVO 
	 * @return List<OfficeMGTVO>
	 * @exception EventException
	 */
	public List<OfficeMGTVO> checkOfficeBasic(OfficeINVO officeINVO) throws EventException;

	/**
	 * 입력 yard code 가 valid 한지 체크  . Retrieve. <br>
	 * 
	 * @param yardINVO YardINVO 
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardBasic(YardINVO yardINVO) throws EventException;
	
	/**
	 * 입력 available yard code 가 valid 한지 체크  . Retrieve. <br>
	 * 
	 * @param yardINVO YardINVO 
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardAvailableYardBasic(YardINVO yardINVO) throws EventException;	
	
	/**
	 * Agreement 가 등록되어있는지 체크한다 . Retrieve. <br>
	 * 
	 * @param agrementINVO AgrementINVO 
	 * @return List<AgrementMGTVO>
	 * @exception EventException
	 */
	public List<AgrementMGTVO> checkAgreementBasic(AgrementINVO agrementINVO) throws EventException;
	
	/**
	 * CGM EQUIPMENT 테이블로부터  Chassis 마스터 정보를 조회한다 . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO ChsMasterMGTVO 
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCGMMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException;
	
	/**
	 * DM_VENDOR 테이블에서 Vendor 정보 조회한다 . Retrieve. <br>
	 * 
	 * @param mdmVendorMGTVO MdmVendorMGTVO 
	 * @return List<MdmVendorMGTVO>
	 * @exception EventException
	 */
	public List<MdmVendorMGTVO> searchVendorListBasic(MdmVendorMGTVO mdmVendorMGTVO) throws EventException;

	/**
	 * CGM_EQ_TP_SZ 테이블로부터  정보를 조회한다 . Retrieve. <br>
	 * 
	 * @param tpSzDupChkINVO TpSzDupChkINVO 
	 * @return List<TpSzDupChkMGTVO>
	 * @exception EventException
	 */
	public List<TpSzDupChkMGTVO> searchEqTpSzDupChkBasic(TpSzDupChkINVO tpSzDupChkINVO) throws EventException;

	/**
	 * MST_CONTAINER 정보를 조회한다 . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO ChsMasterMGTVO 
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCNTRMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException;
	
	/**
	 * Location Code가 유효한지 체크한다 . Retrieve. <br>
	 * 
	 * @param locationMGTVO LocationMGTVO 
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> checkLocationBasic(LocationMGTVO locationMGTVO) throws EventException;
	
	/**
	 * CGM_CHSS_POOL 테이블 정보를 조회한다 Retrieve. <br>
	 * 
	 * @param cgmChssPoolINVO CgmChssPoolINVO 
	 * @return List<CgmChssPoolMGTVO>
	 * @exception EventException
	 */
	public List<CgmChssPoolMGTVO> seachChssPoolListBasic(CgmChssPoolINVO cgmChssPoolINVO) throws EventException;


	/**
	 * MDM_CURRENCY 테이블 정보를 조회한다 Retrieve. <br>
	 * 
	 * @param mdmCurrencyMGTVO MdmCurrencyMGTVO 
	 * @return List<MdmCurrencyMGTVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyMGTVO> searchMDMCurrencyBasic(MdmCurrencyMGTVO mdmCurrencyMGTVO) throws EventException;
	
	/**
	 * Location Code가 유효한지 체크한다 . Retrieve. <br>
	 * 
	 * @param locationMGTVO LocationMGTVO 
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> searchOfficeYardControlOfficeMatchBasic(LocationMGTVO locationMGTVO) throws EventException;
	
	/**
	 * CGM 공통 조회 기능 <br>
	 * OFFICE CODE 의 AGMT NO 를 조회하여 AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @param String ofc_cd
	 * @return String return_agmt_no
	 * @exception EventException
	 */
	public String searchCgmAgmtNoBasic(String agmt_no, String ofc_cd) throws EventException;		

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireBC.java
*@FileTitle : Chassis Specification Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.04.28 박의수
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundAutoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.OnOffHireSummarybyMonthVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ReportSearchConditionVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Chassismgsetmgt Business Logic Command Interface<br>
 * - ALPS-Chassismgsetmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Eui-su Park
 * @see ees_cgm_1002EventResponse 참조
 * @since J2EE 1.4
 */

public interface ChassisMgsetOnOffhireBC {

	/**
	 * chassis 장비의 Type Size List 를 조회한다. Retrieve [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeListBasic(CHSEqTpSzINVO cHSEqTpSzINVO) throws EventException;

	/**
	 * chassis 장비의 Type Size를 수정한다. Manage [EES_CGM_1001]<br>
	 *
	 * @param CHSEqTpSzINVOs CHSEqTpSzINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSEqTypeSizeBasic(CHSEqTpSzINVO[] CHSEqTpSzINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * M.G.Set 장비의 Type Size List 를 조회한다. Retrieve [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeListBasic(MGSEqTpSzINVO mGSEqTpSzINVO) throws EventException;


	/**
	 * chassis 및 M.G.Set 장비의 Type Size를 가진 장비가 있는지(CGM_EQUIPMENT) 조회한다. Retrieve [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeInEqChkBasic(CHSEqTpSzINVO cHSEqTpSzINVO) throws EventException;

	/**
	 * chassis 및 M.G.Set 장비의 Type Size를 가진 장비가 있는지(CGM_EQUIPMENT) 조회한다. Retrieve [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeInEqChkBasic(MGSEqTpSzINVO mGSEqTpSzINVO) throws EventException;

	/**
	 * M.G.Set 장비의 Type Size를 수정한다. Manage [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVOs MGSEqTpSzINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSEqTypeSizeBasic(MGSEqTpSzINVO[] mGSEqTpSzINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * chassis의 Eq spec 정보를 조회한다. Retrieve [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqSpecMGTVO> searchCHSEqSpecBasic(CHSEqSpecINVO cHSEqSpecINVO) throws EventException;

	/**
	 * chassis의 Eq spec 에 해당하는 장비들이 있는지 조회한다. Retrieve [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqSpecMGTVO> searchCHSEqInEqSpecBasic(CHSEqSpecINVO cHSEqSpecINVO) throws EventException;

	/**
	 * chassis의 Eq spec 정보를 생성 및 수정한다. Manage [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSPECINVOs CHSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqSpecBasic(CHSEqSpecINVO[] cHSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * chassis의 Eq spec 정보를 삭제한다. Remove [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSPECINVOs CHSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeCHSEqSpecBasic(CHSEqSpecINVO[] cHSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq Master 기본 정보를 조회한다. Retrieve. [EES_CGM_1009]<br>
	 *
	 * @param chsOffHireINVO CHSOffHireINVO
	 * @return List<CHSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOffHireMGTVO> searchCHSOffhireInfoBasic(CHSOffHireINVO chsOffHireINVO) throws EventException;


	/**
	 * Eq Off-hire 수행에 필요한 Verify [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireMGTVOs CHSOffHireMGTVO[]
	 * @return List<CHSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOffHireMGTVO> verifyCHSOffhireBasic(CHSOffHireMGTVO[] cHSOffHireMGTVOs) throws EventException;

	/**
	 * 장비 반납(Eq Offhire) 수행한다. Off-Hire Confim [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireMGTVOs CHSOffHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void manageCHSOffhireEquipmentBasic(CHSOffHireMGTVO[] cHSOffHireMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq Master 기본 정보를 조회한다. Retrieve. [EES_CGM_2011]<br>
	 *
	 * @param mgsOffHireINVO MGSOffHireINVO
	 * @return List<MGSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOffHireMGTVO> searchMGSOffhireInfoBasic(MGSOffHireINVO mgsOffHireINVO) throws EventException;

	/**
	 * Eq Off-hire 수행에 필요한 Verify [EES_CGM_2011]<br>
	 *
	 * @param mgsOffHireINVOs MGSOffHireMGTVO[]
	 * @return  List<MGSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOffHireMGTVO> verifyMGSOffhireBasic(MGSOffHireMGTVO[] mgsOffHireINVOs) throws EventException;

	/**
	 * 장비 반납(Eq Offhire) 수행한다. Off-Hire Confim [EES_CGM_2011]<br>
	 *
	 * @param mGSOffHireMGTVOs MGSOffHireMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void manageMGSOffhireEquipmentBasic(MGSOffHireMGTVO[] mGSOffHireMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 정보를 조회한다. Retrieve [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqSpecMGTVO> searchMGSEqSpecBasic(MGSEqSpecINVO mGSEqSpecINVO) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 정보가 중복되는지 조회한다. Retrieve [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqSpecMGTVO> searchMGSEqSpecDupBasic(MGSEqSpecINVO mGSEqSpecINVO) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 정보를 생성 및 수정한다. Manage [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSPECINVOs MGSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSEqSpecBasic(MGSEqSpecINVO[] mGSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 정보를 삭제한다. Remove [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSPECINVOs MGSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMGSEqSpecBasic(MGSEqSpecINVO[] mGSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq On-hire, Off-hire 내역을 조회한다 Retrieve. [EES_CGM_1010]<br>
	 *
	 * @param cHSOnOffhireSummaryINVO CHSOnOffhireSummaryINVO
	 * @return List<CHSOnOffhireSummaryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public  List<CHSOnOffhireSummaryMGTVO> searchCHSOnOffhireBasic(CHSOnOffhireSummaryINVO cHSOnOffhireSummaryINVO) throws EventException;

	/**
	 * Chassis 의 Registration 정보를 조회한다. Retrieve [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEquipmentMGTVO> searchCHSEqRegistrationBasic(CHSEquipmentINVO cHSEquipmentINVO) throws EventException;

	/**
	 * 서버에 중복된 Alias No 존재 여부 조회. Retrieve [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEquipmentMGTVO> searchCHSAliasNoBasic(CHSEquipmentINVO cHSEquipmentINVO) throws EventException;

	/**
	 * Chassis 의 Registration 정보를 생성 및 수정한다. Manage [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVOs CHSEquipmentINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqRegistrationBasic(CHSEquipmentINVO[] cHSEquipmentINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq On-hire, Off-hire 내역을 조회한다. Retrieve. [EES_CGM_2012]<br>
	 *
	 * @param mgsOnOffhireSummaryINVO MGSOnOffhireSummaryINVO
	 * @return List<MGSOnOffhireSummaryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public  List<MGSOnOffhireSummaryMGTVO> searchMGSOnOffhireBasic(MGSOnOffhireSummaryINVO mgsOnOffhireSummaryINVO) throws EventException;


//	/**
//	 * 타업무에서 호출
//	 * 멀티 이벤트 처리<br>
//	 * In화면에 대한 멀티 이벤트 처리 <br>
//	 *
//	 * @param IFMnrFlagVO List<IFMnrFlagVO>
//	 * @exception EventException
//	 */
//	public void createMNRStatusBasic(List<IFMnrFlagVO> IFMnrFlagVOs) throws EventException;

	/**
	 * chassis Pool 을 조회한다. Retrieve [EES_CGM_1007]<br>
	 *
	 * @param cHSEqPoolInfoINVO CHSEqPoolInfoINVO
	 * @return List<CHSEqPoolInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqPoolInfoMGTVO> searchCHSEqiPoolListBasic(CHSEqPoolInfoINVO cHSEqPoolInfoINVO) throws EventException;

	/**
	 * chassis Pool 을 Manage 한다. Manage [EES_CGM_1007]<br>
	 *
	 * @param cHSEquPoolInfoINVOs CHSEqPoolInfoINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqPoolListBasic(CHSEqPoolInfoINVO[] CHSEquPoolInfoINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq Master 기본 정보를 조회한다 Retrieve. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostINVO CHSFoundLostINVO
	 * @return List<CHSFoundLostMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSFoundLostMGTVO> searchCHSInfoBasic(CHSFoundLostINVO cHSFoundLostINVO) throws EventException;

	/**
	 * 장비분실시 Lost  처리 한다.. SAVE. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostMGTVO CHSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSLostBasic(CHSFoundLostMGTVO cHSFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Lost 장비 를 Found 처리 한다. SAVE. [EES_CGM_1017]<br>
	 *
	 * @param chsEqFoundLostMGTVO CHSFoundLostMGTVO
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSFoundBasic(CHSFoundLostMGTVO chsEqFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Eq Master 기본 정보를 조회한다 Retrieve. [EES_CGM_2019]<br>
	 *
	 * @param mGSFoundLostINVO MGSFoundLostINVO
	 * @return List<MGSFoundLostMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSFoundLostMGTVO> searchMGSInfoBasic(MGSFoundLostINVO mGSFoundLostINVO) throws EventException;

	/**
	 * 장비분실시 Lost  처리 한다.. SAVE. [EES_CGM_2019]<br>
	 *
	 * @param mgsEqFoundLostMGTVO MGSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSLostBasic(MGSFoundLostMGTVO mgsEqFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Lost 장비 를 Found 처리 한다. SAVE. [EES_CGM_2019]<br>
	 *
	 * @param mgsEqFoundLostMGTVO MGSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSFoundBasic(MGSFoundLostMGTVO mgsEqFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Chassis Eq Master 기본 정보를 조회한다. Retrieve [EES_CGM_1003]<br>
	 *
	 * @param cHSMasterInfoINVO CHSMasterInfoINVO
	 * @return List<CHSMasterInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSMasterInfoMGTVO> searchCHSMasterInfoBasic(CHSMasterInfoINVO cHSMasterInfoINVO) throws EventException;

	/**
	 * 장비 Lost 내역 summary 를 조회한다. Retrieve. [EES_CGM_1019]<br>
	 *
	 * @param chsLostResultINVO CHSLostResultINVO
	 * @return List<CHSLostResultMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSLostResultMGTVO> searchCHSLostResultBasic(CHSLostResultINVO chsLostResultINVO) throws EventException;

	/**
	 * M.G.Set Eq Master 기본 정보를 조회한다. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEquipmentMGTVO> searchMGSEquipmentBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException;


	/**
	 * M.G.Set Eq Master At/Dt 정보를 조회한다. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtHistoryBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException;


	/**
	 * ChassisMgsetOnOffhire의 MGSET에 ATTACH된 샤시를 조회한다. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEquipmentMGTVO> searchMGSEquipmentAtChssBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException;

	/**
	 * M.G.Set Eq Master 기본 정보를 수정한다. Manage [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVOs MGSEquipmentINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSEquipmentBasic(MGSEquipmentINVO[] mGSEquipmentINVOs, SignOnUserAccount account)throws EventException;

	/**
	 * 장비 Lost 내역 summary 를 조회한다. Retrieve. [EES_CGM_2020]<br>
	 *
	 * @param mGSLostResultINVO MGSLostResultINVO
	 * @return List<MGSLostResultMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSLostResultMGTVO> searchMGSLostResultBasic(MGSLostResultINVO mGSLostResultINVO) throws EventException;


	/**
	 * Spec정보에 대한 Valiation Check를 수행한다. [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchEqSpecChkBasic(CHSSpecINVO cHSSpecINVO) throws EventException;

	/**
	 * chassis 및 M.G.Set 장비의 SerialNo FM-TO 중복 체크. Retrieve [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchEqSpecChkFmToBasic(CHSSpecINVO cHSSpecINVO) throws EventException;


	/**
	 * Eq spec 정보를 조회한다. [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchCHSSpecBasic(CHSSpecINVO cHSSpecINVO) throws EventException;

	/**
	 * Eq Own Master(LOT) 리스트를 조회한다.[EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchCHSOwnMasterListBasic(CHSSpecINVO cHSSpecINVO) throws EventException;

	/**
	 * Own Master(Lot 정보) 생성시 해당 LOT 정보를 생성 및 Update 를 수행한다. [UI_CGM_1005, UI_CGM_2004]<br>
	 *
	 * @param cHSSpecINVOs CHSSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void  manageCHSOwnMasterBasic(CHSSpecINVO[] cHSSpecINVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  장비 현황(status) History 를 조회한다. Retrieve. [EES_CGM_1016]<br>
	 *
	 * @param chsStatusInfoINVO CHSStatusInfoINVO
	 * @return List<CHSStatusInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSStatusInfoMGTVO> searchCHSStatusBasic(CHSStatusInfoINVO chsStatusInfoINVO) throws EventException;

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Found Creation. [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoMGTVOs CHSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSStatusBasic(CHSStatusInfoMGTVO[] cHSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Delete [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoMGTVOs CHSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @return CHSStatusInfoMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public CHSStatusInfoMGTVO removeCHSStatusBasic(CHSStatusInfoMGTVO[] cHSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  장비 현황(status) History 를 조회한다. Retrieve. [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoINVO MGSStatusInfoINVO
	 * @return List<MGSStatusInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSStatusInfoMGTVO> searchMGSStatusBasic(MGSStatusInfoINVO mGSStatusInfoINVO) throws EventException;

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Found Creation. [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoMGTVOs MGSStatusInfoMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSStatusBasic(MGSStatusInfoMGTVO[] mGSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Delete [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoMGTVOs MGSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMGSStatusBasic(MGSStatusInfoMGTVO[] mGSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 중복 여부를 조회한다. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSSpecChkBasic(MGSSpecINVO mGSSpecINVO) throws EventException;

	/**
	 * M.G.Set 장비의 Eq Own Master(LOT) 리스트를 조회한다. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSOwnMasterListBasic(MGSSpecINVO mGSSpecINVO) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 정보를 조회한다. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSSpecBasic(MGSSpecINVO mGSSpecINVO) throws EventException;

	/**
	 * M.G.Set 장비의 Eq spec 정보를 생성 및 수정한다. Manage [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSOwnMasterBasic(MGSSpecINVO[] mGSSpecINVO, SignOnUserAccount account) throws EventException;

	/**
	 *  On-Hire 시킬 Chassis No가 유효한지 Eq Master 에서 기본정보 및 상태를 조회한다.. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOnHireStatusChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException;

	/**
	 *  On-Hire 시 기존에 등록되어 있는 Chassis 의 chss_veh_id_no, chss_tit_no, chss_als_no 가 있는지 체크한다. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOnHireDupChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException;

	/**
	 *  O(자가, 임대 장비 확인용 메소드. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOwnLeaseChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException;

	/**
	 * 장비 임차(Eq Onhire) 수행한다. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVOs CHSOnHireMGTVO[]
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> verifyCHSOnhireBasic(CHSOnHireMGTVO[] cHSOnHireINVOs) throws EventException;

	/**
	 *  Eq On-hire 수행에 필요한 Verify 처리. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVOs CHSOnHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSOnhireBasic(CHSOnHireMGTVO[] cHSOnHireINVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  On-Hire 시킬 M.GSET No가 유효한지 Eq Master 에서 기본정보 및 상태를 조회한다... [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVO MGSOnHireINVO
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> searchMGSOnHireStatusChkBasic(MGSOnHireINVO mGSOnHireINVO) throws EventException;


	/**
	 *  On-Hire 시킬  On-Hire 를 시킬 Model No. 를 바꾸면 해당하는 voltage, fuel capacity  조회한다. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVO MGSOnHireINVO
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> searchMGSOnHireEqSpecNoChkBasic(MGSOnHireINVO mGSOnHireINVO) throws EventException;

	/**
	 *  Eq On-hire 수행에 필요한 Verify 처리. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireMGTVOs MGSOnHireMGTVO[]
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> verifyMGSOnhireBasic(MGSOnHireMGTVO[] mGSOnHireMGTVOs) throws EventException;

	/**
	 * 장비 임차(Eq Onhire) 수행한다. 처리. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVOs MGSOnHireMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void manageMGSOnhireBasic(MGSOnHireMGTVO[] mGSOnHireINVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  ERP FA I/F  의 event에 대한 특정 리스트. Retrieve [EES_CGM_1146]<br>
	 *
	 * @param erpFaInterfaceMGTVO ErpFaInterfaceMGTVO
	 * @return List<ErpFaInterfaceMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<ErpFaInterfaceMGTVO> searchErpFACandidateListBasic(ErpFaInterfaceMGTVO erpFaInterfaceMGTVO) throws EventException;

	/**
	 * ERP FA I/F  의 event에 대한 특정 리스트. FNS026-0001 send. [IF_CGM_002]<br>
	 * @param erpFaInterfaceINVOs ErpFaInterfaceINVO[]
	 * @param account		SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void sendToFABasic(ErpFaInterfaceINVO[] erpFaInterfaceINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ERP FA I/F  의 event에 대한 특정 리스트. FNS026-R001 Receive. [IF_CGM_003]<br>
	 * @param cntrMasterUpdateIFVOs		CntrMasterUpdateIFVO[]
	 * @param account	SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void receiveFABasic(CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Lost되었던 Chassis가 시스템상에 Movement가 EDI로 들어올 경우 Found 처리하기 위해 조회. Retrieve [EES_CGM_1018]<br>
	 *
	 * @param cHSFoundAutoMGTVO CHSFoundAutoMGTVO
	 * @return List<CHSFoundAutoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSFoundAutoMGTVO> searchCHSFoundAutoBasic(CHSFoundAutoMGTVO cHSFoundAutoMGTVO) throws EventException;

	/**
	 *  Lost되었던 Chassis가 시스템상에 Movement가 EDI로 들어올 경우 Found 처리하기 위해 조회. Delete [EES_CGM_1018]<br>
	 *
	 * @param cHSFoundAutoMGTVOs CHSFoundAutoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSFoundAutoBasic(CHSFoundAutoMGTVO[] cHSFoundAutoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Term Change (Chassis) - 정보 저장 Manage [EES_CGM_1026]<br>
	 *
	 * @param cHSTermStatusINVOS CHSTermStatusINVO[]
	 * @param cHSTermStatusINVO CHSTermStatusINVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSTermChangeBasic(CHSTermStatusINVO[] cHSTermStatusINVOS, CHSTermStatusINVO cHSTermStatusINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Term Change (Mgset) 화면에 대한 정보 저장 Manage [EES_CGM_2026]<br>
	 *
	 * @param mGSTermStatusINVOs MGSTermStatusINVO[]
	 * @param mGSTermStatusINVO MGSTermStatusINVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSTermChangeBasic(MGSTermStatusINVO[] mGSTermStatusINVOs, MGSTermStatusINVO mGSTermStatusINVO, SignOnUserAccount account) throws EventException;


	/**
	 *  Movement 에 의해 Eq Master 정보를 수정한다.개별 Chassis의 Master Data Update<br>
	 *
	 * @param cHSMasterMGTVO CHSMasterMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSCgmEquipmentBasic(CHSMasterMGTVO cHSMasterMGTVO) throws EventException;

	/**
	 *  LMNR 으로부터 호출받아 장비의 Damage, disposal 등의  Flagging 관리.. SAVE  [MNR 호출]<br>
	 *  MNR 으로부터 호출받아 장비의 Retirement 관련 처리. SAVE  [MNR 호출]<br>
	 *
	 * @param iFMnrFlagVOs List<IFMnrFlagVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createMNRStatusBasic(List<IFMnrFlagVO> iFMnrFlagVOs) throws EventException;

	/**
	 * Lease Term Change (Chassis) - 정보 저장(BackEndJob) Manage [EES_CGM_1026]<br>
	 *
	 * @param  CHSTermStatusINVO[] cHSTermStatusINVOs
	 * @param  CHSTermStatusINVO cHSTermStatusINVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String backEndCHSTermChangeListBasic(CHSTermStatusINVO[] cHSTermStatusINVOs, CHSTermStatusINVO cHSTermStatusINVO, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
	
	/**
	 * 월별로 반납한 실적을 조회.<br>
	 *
	 * @param ReportSearchConditionVO reportSearchConditionVO
	 * @return OnOffHireSummarybyMonthVO
	 * @exception EventException
	 */
	public OnOffHireSummarybyMonthVO searchCHSOffHireReportbyMonthSummaryBasic (ReportSearchConditionVO reportSearchConditionVO) throws EventException;
	
	/**
	 * 월별로 임차한 실적을 조회.<br>
	 *
	 * @param ReportSearchConditionVO reportSearchConditionVO
	 * @return OnOffHireSummarybyMonthVO
	 * @exception EventException
	 */
	public OnOffHireSummarybyMonthVO searchCHSOnHireReportbyMonthSummaryBasic (ReportSearchConditionVO reportSearchConditionVO) throws EventException;
	
 	/**
 	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status History (M.G.Set) 삭제 처리 [MNR 호출]<br>
 	 *
  	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
 	 * @exception EventException
  	 */
 	public void removeMGSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException;

 	/**
 	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status (M.G.Set) 수정 처리 [MNR 호출]<br>
 	 *
  	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
 	 * @exception EventException
  	 */
 	public void modifyMGSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException;
 	
  	/**
  	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status History (Chassis) 삭제 처리 [MNR 호출]<br>
  	 *
   	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
  	 * @exception EventException
   	 */
  	public void removeCHSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException;

  	/**
  	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status (Chassis) 수정 처리 [MNR 호출]<br>
  	 *
   	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
  	 * @exception EventException
   	 */
  	public void modifyCHSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException; 	

}

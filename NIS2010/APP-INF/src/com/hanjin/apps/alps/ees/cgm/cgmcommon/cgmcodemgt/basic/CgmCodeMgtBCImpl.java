/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CgmCodeMgtBCImpl.java
 *@FileTitle : CgmCodeMgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.03
 *@LastModifier : 김상수
 *@LastVersion : 1.24
 *
 * 2009.05.12 김창식
 *     1.0 Creation
 *
 * 2010.08.03 김상수
 *     [CHM-201004960-01] Genset Ineventory Logic error 수정건
 *         : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
 * 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청 
 *               Amend 완료후 최종 입력된 Effective Date(Filed Date)에 맞게 이전 Version의 Chassis S/C Exception List 의 Expire Date를 1일 전까지로 변경하는 로직 (신규) 추가 및 Bug Fix
 * 2014-06-17 BY JUSTIN HAN NEW CSR ID : CHM-201430737, TITLE ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
 *                S/C Exception List 의 Expiry date를 PRI 와 같은 Date로 수정, Accept 상태 Exception에 대해서만 Effective Date를 수정하도록 Proproal no, Sequence별 최종 Status Check
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration.CgmCodeMgtDBDAO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssSCExceptionGRPVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionHisVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionDeleteVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CgmCommon Business Logic Basic Command implementation<br>
 * - ALPS-CgmCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM CHANG SIK 
 * @see CgmCodeMgtEventResponse,CgmCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CgmCodeMgtBCImpl extends BasicCommandSupport implements CgmCodeMgtBC {

	// Database Access Object
	private transient CgmCodeMgtDBDAO dbDao = null;

	/**
	 * CgmCodeMgtBCImpl 객체 생성<br>
	 * CgmCodeMgtDBDAO를 생성한다.<br>
	 */
	public CgmCodeMgtBCImpl() {
		dbDao = new CgmCodeMgtDBDAO(); 
	}
	
	/**
	 * Chassis Pool 로 등록된 Agreement 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchAgreementByPoolBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchAgreementByPoolData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *   Chassis Pool 로 등록된 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchPoolListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchPoolListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 * CGM_EQ_SPEC 테이블에서 Spec No 리스트를 조회한다. [NO_ID]<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchSpecListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchSpecListData(comboINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 * Chassis 또는 M.G.Set 의 Type Size 목록을 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchEqTpszListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchEqTpszListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	
	/**
	 * MDM 테이블에서 Manufacture리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchManuListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchManuListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 *  Neutral Pool 로 등록된 Agreement 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMgsetNoFindBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchMgsetNoFindData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 *  CGM에서 사용하는 공통코드 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCommonCodeListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchCommonCodeListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  MDM_VENDOR 테이블에서 Vendor Code 및 Name 을 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchVendorCodeListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchVendorCodeListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}

	/**
	 *  MDM_STATE 테이블에서 미주지역의 State 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchStateCodeListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchStateCodeListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 * CGM_EQ_LOT 에 등록된 Cert No 리스트를 조회한다. [EES_CGM_1005]<br>
	 *
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCertChassisListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchCertChassisListData(comboINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 * CGM_EQ_LOT 에 등록된 Cert No 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param mdmOrganizationINVO MdmOrganizationINVO
	 * @return MdmOrganizationMGTVO
	 * @exception EventException
	 */
	public MdmOrganizationMGTVO searchOrganizationBasic(MdmOrganizationINVO mdmOrganizationINVO) throws EventException{
		// Response 객체를 담기위한 Map 객체
		MdmOrganizationMGTVO mdmOrganizationMGTVO = new MdmOrganizationMGTVO();
		
		try {
			// ETCDATA 설정
			List<MdmOrganizationMGTVO> orglist = dbDao.searchOrganizationData(mdmOrganizationINVO);
			
			
			if(orglist != null){
				if(orglist.size() > 0){
					for(int i = 0; i < orglist.size(); i++){
						mdmOrganizationMGTVO = (MdmOrganizationMGTVO)orglist.get(0);
					}
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		
		return mdmOrganizationMGTVO;
	}

	/**
	 * MDM 테이블에서 Financing Company리스트를 조회한다. [NO_ID]<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchFinancingCoBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchFinancingCoData(comboINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 * Agreement No가 유효한지 체크한다 조회한다. [NO_ID] <br>
	 * 
	 * @param agreementINVO AgreementINVO
	 * @return List<AgreementMGTVO>
	 * @exception EventException
	 */
	public List<AgreementMGTVO> searchAgreementMainBasic(AgreementINVO agreementINVO) throws EventException{
		try {
			return dbDao.searchAgreementMainData(agreementINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		
		//return agreementList;
	}
	
	/**
	 * mdm_mvmt_sts 테이블 정보를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMovementStatusListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchMovementStatusListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}	
	
	/**
	 *  Neutral Pool 로 등록된 Agreement 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchNuPoolListBasic(ComboINVO comboINVO) throws EventException{
		try {
			return dbDao.searchNuPoolListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  WEEK와 해당하는 FROM DATE, TO DATE 를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */	
	public List<ComboMGTVO> searchWeekFmToDateBasic(ComboINVO comboINVO) throws EventException{
		try {
			
			String tmp_inq_dys = comboINVO.getEqSpecNo();
			
			tmp_inq_dys = tmp_inq_dys.replaceAll("-", "");
			comboINVO.setEqSpecNo(tmp_inq_dys);
			
			return dbDao.searchWeekFmToDateData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}	

	/**
	 *  YEAR-WEEK로 WEEK와 해당하는 FROM DATE, TO DATE 를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateByWeekBasic(ComboINVO comboINVO) throws EventException{
		try {
			
			String tmp_inq_dys = comboINVO.getEqSpecNo();
			
			tmp_inq_dys = tmp_inq_dys.replaceAll("-", "");
			
			comboINVO.setEqSpecNo(tmp_inq_dys.substring(0, 4));
			comboINVO.setEqKndCd(tmp_inq_dys.substring(4, 6));
			
			return dbDao.searchWeekFmToDateByWeekData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}	
	
	/**
	 *  RCC,LCC,SCC 조회 및 Validation 체크. Retrieve. <br>
	 * 
	 * @param eqOrzChtINVO EqOrzChtINVO 
	 * @return List<EqOrzChtMGTVO>
	 * @exception EventException
	 */
	public List<EqOrzChtMGTVO> searchEqOrzChtBasic(EqOrzChtINVO eqOrzChtINVO) throws EventException {
		try {
			if ("LCCSCC".equals(eqOrzChtINVO.getEqOrzChtChktype())) {
				String crntLccCd = eqOrzChtINVO.getEqOrzChtLccCd();
				if (crntLccCd != null && !crntLccCd.equals("")){
					crntLccCd = "'" + crntLccCd.replaceAll(",", "', '") + "'";
					eqOrzChtINVO.setEqOrzChtLccCd(crntLccCd);
				}
			}
			return dbDao.searchEqOrzChtData(eqOrzChtINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 * COST COFFICE CODE 를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCostOfficeBasic(ComboINVO comboINVO) throws EventException{
		try {
			return dbDao.searchCostOfficeData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  Invoice Service Provier를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchInvSerProviderBasic(ComboINVO comboINVO) throws EventException{
		try {
			comboINVO.setCostYrmon(comboINVO.getCostYrmon().replaceAll("-", ""));
			return dbDao.searchInvSerProviderData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  Office Code 로 Local Time 을 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO 
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchLocalTimeByOfficeBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchLocalTimeByOfficeData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  S/C Exception으로 등록된 리스트를 조회한다. Retrieve. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return List<CPSScExptListMGTVO>
	 * @exception EventException
	 */
	public List<CPSScExptListMGTVO> searchCPSScExptListBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException {
		try {
			String effYrmon = cpsScExptListINVO.getEffYrmon().replaceAll("-", "");
			cpsScExptListINVO.setEffYrmon(effYrmon);
			return dbDao.searchCPSScExptListData(cpsScExptListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  입력된 Customer Code로부터 Customer Name을 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptCustNameBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException {
		try {
			return dbDao.checkCPSScExptCustNameData(cpsScExptListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  입력된 SCC가 유효한 값인지 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptListSccBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException {
		try {
			return dbDao.checkCPSScExptListSccData(cpsScExptListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  입력된 SC NO., E.Month, SCC로부터 중복을 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptListDupBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException {
		try {
			return dbDao.checkCPSScExptListDupData(cpsScExptListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  입력된 Group Customer Code로부터 Group Customer Name을 체크한다. <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSScExptGroupCustNameBasic(CPSScExptListINVO cpsScExptListINVO) throws EventException {
		try {
			return dbDao.checkCPSScExptGroupCustNameData(cpsScExptListINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  S/C Exception List를 입력하거나 수정한다. <br>
	 * 
	 * @param cpsScExptListINVOS CPSScExptListINVO[] 
	 * @param account SignOnUserAccount
	 * @return List<CPSScExptListINVO>
	 * @exception EventException
	 */
	public List<CPSScExptListINVO> manageCPSScExptListBasic(CPSScExptListINVO[] cpsScExptListINVOS, SignOnUserAccount account) throws EventException {
		List<CPSScExptListINVO> retVoList = new ArrayList<CPSScExptListINVO>();
		try {
			CPSScExptListINVO tmpCPSScExptList = new CPSScExptListINVO();
			CPSScExptListINVO validCPSScExptList = new CPSScExptListINVO();
			
			for(int i=0; i<cpsScExptListINVOS.length; i++){
				if(cpsScExptListINVOS[i].getIbflag().equals("I")){
					cpsScExptListINVOS[i].setCreOfcCd(account.getOfc_cd());
					cpsScExptListINVOS[i].setCreUsrId(account.getUsr_id());
					cpsScExptListINVOS[i].setUpdUsrId(account.getUsr_id());
					if(!"".equals(cpsScExptListINVOS[i].getCustCd())){
						cpsScExptListINVOS[i].setCustCntCd(cpsScExptListINVOS[i].getCustCd().substring(0, 2));
						cpsScExptListINVOS[i].setCustSeq(cpsScExptListINVOS[i].getCustCd().substring(2));
					}
					tmpCPSScExptList = cpsScExptListINVOS[i];
					validCPSScExptList = dbDao.validationCPSScExptListData(cpsScExptListINVOS[i]);
					if("".equals(validCPSScExptList.getRhqCd())){
						tmpCPSScExptList.setErr1("B");
					} else {
						tmpCPSScExptList.setRhqCd(validCPSScExptList.getRhqCd());
						tmpCPSScExptList.setErr1("");
					}
					if("".equals(validCPSScExptList.getCustGrpNm()) && !"".equals(validCPSScExptList.getCustLglEngNm())){
						tmpCPSScExptList.setCustGrpId(cpsScExptListINVOS[i].getCustCd());
						tmpCPSScExptList.setCustGrpNm(validCPSScExptList.getCustLglEngNm());
					} else {
						tmpCPSScExptList.setCustGrpNm(validCPSScExptList.getCustGrpNm());
					}
					if("".equals(validCPSScExptList.getCustLglEngNm())){
						tmpCPSScExptList.setErr3("B");
					} else {
						tmpCPSScExptList.setCustLglEngNm(validCPSScExptList.getCustLglEngNm());
						tmpCPSScExptList.setErr3("");
					}
					if("".equals(validCPSScExptList.getSccCd())){
						tmpCPSScExptList.setErr4("B");
					} else {
						tmpCPSScExptList.setErr4("");
					}
					if("Y".equals(validCPSScExptList.getDup())){
						tmpCPSScExptList.setInsflg("E");
					}
					if (!tmpCPSScExptList.getErr1().equals("B") &&
						!tmpCPSScExptList.getErr3().equals("B") &&
						!tmpCPSScExptList.getErr4().equals("B") &&
						!tmpCPSScExptList.getInsflg().equals("E")){
						int result= dbDao.addCPSScExptListData(tmpCPSScExptList);
							
						if (result!=1)	tmpCPSScExptList.setInsflg("E");
					}
					retVoList.add(tmpCPSScExptList);
				}else if(cpsScExptListINVOS[i].getIbflag().equals("U")){
					cpsScExptListINVOS[i].setCreOfcCd(account.getOfc_cd());
					cpsScExptListINVOS[i].setUpdUsrId(account.getUsr_id());
					if(!"".equals(cpsScExptListINVOS[i].getCustCd())){
						cpsScExptListINVOS[i].setCustCntCd(cpsScExptListINVOS[i].getCustCd().substring(0, 2));
						cpsScExptListINVOS[i].setCustSeq(cpsScExptListINVOS[i].getCustCd().substring(2));
					}
					tmpCPSScExptList = cpsScExptListINVOS[i];
					validCPSScExptList = dbDao.validationCPSScExptListData(cpsScExptListINVOS[i]);
					if("".equals(validCPSScExptList.getCustGrpNm()) ||
							"".equals(validCPSScExptList.getRhqCd()) ||
							"".equals(validCPSScExptList.getCustLglEngNm())){
						tmpCPSScExptList.setUpdflg("E");
					}
					if (!tmpCPSScExptList.getUpdflg().equals("E")){
						int result= dbDao.modifyCPSScExptListData(tmpCPSScExptList);
							
						if (result!=1)	tmpCPSScExptList.setUpdflg("E");
					}
					retVoList.add(tmpCPSScExptList);
				}else if(cpsScExptListINVOS[i].getIbflag().equals("D")){
					tmpCPSScExptList = cpsScExptListINVOS[i];
					int result= dbDao.removeCPSScExptListData(tmpCPSScExptList);
					
					if (result!=1) tmpCPSScExptList.setUpdflg("E");
					retVoList.add(tmpCPSScExptList);
				}else{
					retVoList.add(tmpCPSScExptList);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
		return retVoList;
	}
	
	/**
	 *  CPS Neutral Pool로 등록된 업체를 조회한다. Retrieve. <br>
	 * 
	 * @param cpsCHSSPoolINVO CPSCHSSPoolINVO 
	 * @return List<CPSCHSSPoolMGTVO>
	 * @exception EventException
	 */
	public List<CPSCHSSPoolMGTVO> searchCPSCHSSPoolBasic(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws EventException {
		try {
			return dbDao.searchCPSCHSSPoolData(cpsCHSSPoolINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 * CPS Chassis Pool List를 조회한다. Retrieve. <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCPSCHSSPoolListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchCPSCHSSPoolListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  입력된 Pool Code의 중복을 체크한다. <br>
	 * 
	 * @param cpsCHSSPoolINVO CPSCHSSPoolINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSCHSSPoolCodeDupBasic(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws EventException {
		try {
			return dbDao.checkCPSCHSSPoolCodeDupData(cpsCHSSPoolINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  입력된 Vendor Code로부터 Vendor Name을 체크한다. <br>
	 * 
	 * @param cpsCHSSPoolINVO CPSCHSSPoolINVO 
	 * @return String
	 * @exception EventException
	 */
	public String checkCPSCHSSPoolVndrNameBasic(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws EventException {
		try {
			return dbDao.checkCPSCHSSPoolVndrNameData(cpsCHSSPoolINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 *  CPS Neutral Pool을 입력하거나 수정한다. <br>
	 * 
	 * @param cpsCHSSPoolINVOS CPSCHSSPoolINVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCPSCHSSPoolBasic(CPSCHSSPoolINVO[] cpsCHSSPoolINVOS, SignOnUserAccount account) throws EventException {
		try {
			List<CPSCHSSPoolINVO> insertVoList = new ArrayList<CPSCHSSPoolINVO>();
			List<CPSCHSSPoolINVO> updateVoList = new ArrayList<CPSCHSSPoolINVO>();
			List<CPSCHSSPoolINVO> deleteVoList = new ArrayList<CPSCHSSPoolINVO>();
			
			for(int i=0; i<cpsCHSSPoolINVOS.length; i++){
				if(cpsCHSSPoolINVOS[i].getIbflag().equals("I")){
					cpsCHSSPoolINVOS[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(cpsCHSSPoolINVOS[i]);
				}else if(cpsCHSSPoolINVOS[i].getIbflag().equals("U")){
					cpsCHSSPoolINVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cpsCHSSPoolINVOS[i]);
				}else if(cpsCHSSPoolINVOS[i].getIbflag().equals("D")){
					deleteVoList.add(cpsCHSSPoolINVOS[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addCPSCHSSPoolData(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyCPSCHSSPoolData(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeCPSCHSSPoolData(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
	 	}
	}
	
	/**
	 * Proposal No. 에 해당되는 SC No.와 Customer Code, Customer Name을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNoBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return dbDao.searchSCNoCustomerByProposalNoData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Proposal No 의 S/C Duration 데이터를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception EventException
	 */
	public SCExceptionParmVO searchSCDurationBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return dbDao.searchSCDurationData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회한다.
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasAcceptAuthBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return dbDao.hasAcceptAuthData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Proposal No. 에 해당하는 Commodity 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @exception EventException
	 */
	public List<SCExceptionCommodityVO> searchCommodityListBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCommodityVO> list = null;
		try {
			list = dbDao.searchCommodityListBySCData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Proposal No. 에 해당하는 Version 목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionVersionVO>
	 * @exception EventException
	 */
	public List<CHSSSCExceptionVersionVO> searchSCVersionByProposalNoBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<CHSSSCExceptionVersionVO> list = null;
		try {
			list = dbDao.searchSCVersionByProposalNo(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * S/C Exception Entry를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<ChssScExceptionVO>
	 * @exception EventException
	 */
	public List<ChssScExceptionVO> searchSCExceptionBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<ChssScExceptionVO> sCExceptionVOs = null;
		try {
			sCExceptionVOs = dbDao.searchSCExceptionData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sCExceptionVOs;
	}
	
	/**
	 * Proposal No. 에 해당하는 Actual Customer 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<SCExceptionCustomerVO> searchCustomerListBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		List<SCExceptionCustomerVO> custList = null;
		
		try {
			custList = dbDao.searchCustomerListBySCBasic(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return custList;
	}
	
	/**
	 * S/C Exception 을 수정 합니다. <br>
	 * 
	 * @param ChssSCExceptionGRPVO chssSCExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifySCExceptionBasic(ChssSCExceptionGRPVO chssSCExceptionGRPVO, SignOnUserAccount account) throws EventException {
		String 	groupSeq 	= "";
		
		try {
			//S/C Exception Tariff Version =============================================================================================
			CHSSSCExceptionVersionVO 			sCExceptionVersionVO 		= chssSCExceptionGRPVO.getsCExceptionVersionVO();
			
			sCExceptionVersionVO.setCreUsrId(account.getUsr_id());
			sCExceptionVersionVO.setCreOfcCd(account.getOfc_cd());
			sCExceptionVersionVO.setUpdUsrId(account.getUsr_id());
			sCExceptionVersionVO.setUpdOfcCd(account.getOfc_cd());			
			//==========================================================================================================================
			
			//S/C Exception Tariff Terms Entry =========================================================================================
			ChssScExceptionVO					chssScExceptionVO				= null;
			List<ChssScExceptionVO>	 			chssScExceptionVOs 				= chssSCExceptionGRPVO.getChssScExceptionVOS();
			
			if (chssScExceptionVOs != null || sCExceptionVersionVO != null) {
				
				//S/C Exception 의 Version 정보가 존재하는지 조회 합니다.
				if (!dbDao.existSCExceptionVersionData(sCExceptionVersionVO)) {
					//Version 정보가 없으면 생성 합니다.
					dbDao.addSCExceptionVersionData(sCExceptionVersionVO);
				}
				else {
					//Version 정보가 있다면, 상태를 'Temp.Saved' 으로 Version 의 상태를 갱신한다.
					dbDao.modifyVersionStsData(sCExceptionVersionVO);
				}
				
				//Version Prog 테이블에 Temp 상태의 이력을 쌓는다.
				//만일, 현재 버전의 상태가 'Temp.Saved' 일 경우에는 갱신해주고 그렇지 않다면 생성해준다.
				if (dbDao.isTempSavedStatusOfLastVersionProgData(sCExceptionVersionVO)) {
					dbDao.modifyLastVersionProgData(sCExceptionVersionVO);
				}
				else {
					dbDao.addSCExceptionVersionProgData(sCExceptionVersionVO);
				}
				
				if(chssScExceptionVOs != null){
					for(int i = 0; i < chssScExceptionVOs.size(); i++){
						chssScExceptionVO = chssScExceptionVOs.get(i);
						if("ALL".equals(chssScExceptionVO.getChssCntrCgoTpCd())){
							chssScExceptionVO.setChssCntrCgoTpCd("");
						}
						
						if("ALL".equals(chssScExceptionVO.getCmdtCd())){
							chssScExceptionVO.setCmdtCd("");
						}
							
						if ("I".equals(chssScExceptionVO.getIbflag())) {
							chssScExceptionVO.setCreUsrId(account.getUsr_id());
							chssScExceptionVO.setCreOfcCd(account.getOfc_cd());
	
							//S/C Exception Tariff 정보를 생성 합니다.
							dbDao.addSCExceptionGroupData(chssScExceptionVO);
						}
						else if ("U".equals(chssScExceptionVO.getIbflag())) {
							chssScExceptionVO.setUpdUsrId(account.getUsr_id());
							chssScExceptionVO.setUpdOfcCd(account.getOfc_cd());
							
							//S/C Exception Tariff 정보를 수정 합니다.	
							dbDao.modifySCExceptionGroupData(chssScExceptionVO);
						}
						else if ("D".equals(chssScExceptionVO.getIbflag())){
							dbDao.removeScExceptionData(chssScExceptionVO);
						}
					}
				}
			}
			
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		return groupSeq;
	}
	
	/**
	 * Customer Name 정보를 조회한다.
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerNameBasic(CustomerVO customerVO) throws EventException {
		String custNm = null;
		try {
			custNm = dbDao.searchCustomerNameData(customerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return custNm;
	}
	
	/**
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isCustomerByPriMnBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return dbDao.isCustomerByPriMnData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
     * commodity 정보를 조회한다.
     * 
     * @param String cmdtCd
     * @return String
     * @exception EventException
     */ 
    public String searchCommodityNameBasic(String cmdtCd) throws EventException {
        try {
            return dbDao.searchCommodityNameData(cmdtCd);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
    
    /**
	 * Update 버튼 클릭시 'Live'상태의 S/C Exception 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByUpdateBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			//1.신규 버전 정보를 조회한다.
			String versionSeq = dbDao.searchSCExceptionVersionSeqData(sCExceptionParmVO.getPropNo());
			List<ChssScExceptionVO> chssScExceptionVOS = dbDao.searchChssSCExptListData(sCExceptionParmVO);

			//2.Version, Version Prog 정보를 생성하기 위한 Version 객체를 생성 합니다.
			CHSSSCExceptionVersionVO	sCExceptionVersionVO	= new CHSSSCExceptionVersionVO();
			
			sCExceptionVersionVO.setPropNo(			sCExceptionParmVO.getPropNo()				);
			sCExceptionVersionVO.setScExptVerSeq(		versionSeq									);
			sCExceptionVersionVO.setCreUsrId(			sCExceptionParmVO.getCreUsrId()			);
			sCExceptionVersionVO.setCreOfcCd(			sCExceptionParmVO.getCreOfcCd()			);
			sCExceptionVersionVO.setFtFlg(				sCExceptionParmVO.getFtFlg()				);
			sCExceptionVersionVO.setChssExptVerStsCd(	sCExceptionParmVO.getChssExptVerStsCd()	);
			
			SCExceptionParmVO durationVO = dbDao.searchSCDurationData(sCExceptionParmVO);
			
			sCExceptionVersionVO.setEffDt(durationVO.getEffDt());
			sCExceptionVersionVO.setExpDt(durationVO.getExpDt());
			
			//2-1.S/C Exception Tariff 에 신규 채번된 Version Seq. 를 설정 합니다.
			sCExceptionParmVO.setScExptVerSeq(versionSeq);
			
			//3.신규 버전에 대한 정보를 'Temp' 상태로 Version 에 생성 합니다.
			dbDao.addSCExceptionVersionData(sCExceptionVersionVO);
			
			
			//4.신규 버전에 대한 정보를 'Temp' 상태로 Version Prog 에 생성 합니다.
			dbDao.addSCExceptionVersionProgData(sCExceptionVersionVO);
			
			for(int i = 0; i < chssScExceptionVOS.size(); i++){
				//5.이전 버전의 모든 S/C Exception Tariff Group 정보를 신규 버전으로 생성 합니다.
				chssScExceptionVOS.get(i).setCreOfcCd(sCExceptionParmVO.getCreOfcCd());
				chssScExceptionVOS.get(i).setCreUsrId(sCExceptionParmVO.getCreUsrId());
				chssScExceptionVOS.get(i).setScExptVerSeq(versionSeq);
				chssScExceptionVOS.get(i).setEffDt(sCExceptionVersionVO.getEffDt());
				chssScExceptionVOS.get(i).setExpDt(sCExceptionVersionVO.getExpDt());
				dbDao.addSCExceptionOfPrevVersionData(chssScExceptionVOS.get(i));
			}
		} catch (DAOException ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @exception EventException
	 */
	public void modifyVersionSTSBasic(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws EventException {
		try {
			SCExceptionParmVO sCExceptionParmVO = new SCExceptionParmVO();
			sCExceptionParmVO.setPropNo(sCExceptionVersionVO.getPropNo());
			
			//버전의 상태를 변경한다.
			dbDao.modifyVersionSTSData(sCExceptionVersionVO);
			//상태를 변경한 로그를 기록한다.
			dbDao.addSCExceptionVersionProgData(sCExceptionVersionVO);
			
			//만일 상태가 Live 로 변경될 경우, 이하버전의 Expire date 를 조정한다 
			if ("L".equals(sCExceptionVersionVO.getChssExptVerStsCd()) 
					&& 1 < Integer.parseInt(sCExceptionVersionVO.getScExptVerSeq())) {
				dbDao.modifyUnderVersionDelSTSData(sCExceptionVersionVO);
				//상태를 변경한 로그를 기록한다.
				dbDao.addUnderVersionPROGData(sCExceptionVersionVO);				
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionParamVO
	 * @exception EventException
	 */
	public void modifyVersionSTSByAdmtBasic(CHSSSCExceptionVersionVO sCExceptionVersionParamVO) throws EventException {
		try {
			List<CHSSSCExceptionVersionVO> list = dbDao.searchSCVersionByAdmtData(sCExceptionVersionParamVO.getPropNo());
			
			// 2014-06-17 by Chang Young Kim
			String chssExptVerStsCdOfBeforeSeq = null;
			
			if(list.size() == 1){
				CHSSSCExceptionVersionVO sCExceptionVersionVO = list.get(0);
				sCExceptionVersionVO.setChssExptVerStsCd("L");
				sCExceptionVersionVO.setUpdUsrId(sCExceptionVersionParamVO.getUpdUsrId());
				sCExceptionVersionVO.setUpdOfcCd(sCExceptionVersionParamVO.getUpdOfcCd());
				sCExceptionVersionVO.setCreUsrId(sCExceptionVersionParamVO.getCreUsrId());
				sCExceptionVersionVO.setCreOfcCd(sCExceptionVersionParamVO.getCreOfcCd());
				sCExceptionVersionVO.setExpDt(sCExceptionVersionParamVO.getExpDt());
				
				// 2014-06-17 by Chang Young Kim : Table CGM_SC_EXPT_VER_PROG에서 PROP_NO와 SC_EXPT_VER_SEQ에 해당하는 Max(PROG_SEQ)의 CHSS_EXPT_VER_STS_CD를 조회.
				chssExptVerStsCdOfBeforeSeq = dbDao.searchChssExptVerStsCdOfBeforeSeq(sCExceptionVersionParamVO.getPropNo(), sCExceptionVersionVO.getScExptVerSeq());
				// 2014-06-17 by Chang Young Kim : 직전 SEQ의 CHSS_EXPT_VER_STS_CD가 A일 경우
				if(chssExptVerStsCdOfBeforeSeq.equals("A")) {
					//버전의 상태를 변경한다.
					dbDao.modifyVersionSTSData(sCExceptionVersionVO);
					//2014-04-04 by Jonghee HAN List 상태 변경로직 신규 추가
					dbDao.modifyListSTSData(sCExceptionVersionVO);
				} else {
					// 2014-06-18 by Chang Young Kim 직전 SEQ의 CHSS_EXPT_VER_STS_CD가 A가 아닐 경우 버전의 상태를 변경한다.
					dbDao.modifyVersionSTSDataOnlyExpDt(sCExceptionVersionVO);
					// 2014-06-17 by Chang Young Kim 직전 SEQ의 CHSS_EXPT_VER_STS_CD가 A가 아닐 경우 리스트의 상태를 변경한다.
					dbDao.modifyListSTSDataOnlyExpDt(sCExceptionVersionVO);
				}
				
				//상태를 변경한 로그를 기록한다.
				dbDao.addSCExceptionVersionProgData(sCExceptionVersionVO);
				
				//만일 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 변경한다.
				if ("L".equals(sCExceptionVersionVO.getChssExptVerStsCd()) 
						&& 1 < Integer.parseInt(sCExceptionVersionVO.getScExptVerSeq())) {					
					
					//2014-04-04 by Jonghee HAN 변경된 Chassis S/C Exception List 정보 다시 조회 로직 신규 추가
					list = null;
					sCExceptionVersionVO = null;
					
					list = dbDao.searchSCVersionByAdmtData(sCExceptionVersionParamVO.getPropNo());
					sCExceptionVersionVO = list.get(0);
					sCExceptionVersionVO.setChssExptVerStsCd("L");
					sCExceptionVersionVO.setUpdUsrId(sCExceptionVersionParamVO.getUpdUsrId());
					sCExceptionVersionVO.setUpdOfcCd(sCExceptionVersionParamVO.getUpdOfcCd());
					sCExceptionVersionVO.setCreUsrId(sCExceptionVersionParamVO.getCreUsrId());
					sCExceptionVersionVO.setCreOfcCd(sCExceptionVersionParamVO.getCreOfcCd());
					
					dbDao.modifyUnderVersionDelSTSData(sCExceptionVersionVO);
					//2014-04-04 by Jonghee HAN List 이전 Version의 Expire Date 변경 로직 신규 추가
					dbDao.modifyUnderListDelSTSData(sCExceptionVersionVO);
					//상태를 변경한 로그를 기록한다.
					dbDao.addUnderVersionPROGData(sCExceptionVersionVO);				
				}
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * S/C Exception Version를 삭제상태로 수정 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void removeSCExceptionByVerBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			dbDao.removeSCExceptionByVerData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}		
	}
	
	/**
	 * S/C 가 Filed Status 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkFiledBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			return dbDao.checkFiledBySCData(sCExceptionParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Prop No. 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String propNo
	 * @return List<ChssScExceptionHisVO>
	 * @exception EventException
	 */
	public List<ChssScExceptionHisVO> searchSCExceptionListByPropNoBasic(String propNo) throws EventException {
		try {
			return dbDao.searchSCExceptionListByPropNoData(propNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 S/C Exception Tariff History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @exception EventException
	 */
	public void createSCExceptionByHistoryCopyBasic(SCExceptionParmVO sCExceptionParmVO) throws EventException {
		try {
			//1.Version, Version Prog 정보를 생성하기 위한 Version 객체를 생성 합니다.
			CHSSSCExceptionVersionVO	sCExceptionVersionVO	= new CHSSSCExceptionVersionVO();
			SCExceptionDeleteVO		sCExceptionDeleteVO		= null;
			
			sCExceptionVersionVO.setPropNo(				sCExceptionParmVO.getPropNo()			);
			sCExceptionVersionVO.setScExptVerSeq(		sCExceptionParmVO.getScExptVerSeq()		);
			sCExceptionVersionVO.setCreUsrId(			sCExceptionParmVO.getCreUsrId()			);
			sCExceptionVersionVO.setCreOfcCd(			sCExceptionParmVO.getCreOfcCd()			);
			sCExceptionVersionVO.setUpdUsrId(			sCExceptionParmVO.getUpdUsrId()			);
			sCExceptionVersionVO.setUpdOfcCd(			sCExceptionParmVO.getUpdOfcCd()			);
			sCExceptionVersionVO.setChssExptVerStsCd(	sCExceptionParmVO.getChssExptVerStsCd()	);
			
			//현재 버전의 S/C Exception Tariff 정보가 있다면 삭제 합니다.
			if (dbDao.existSCExceptionData(sCExceptionParmVO)) {
				sCExceptionDeleteVO = new SCExceptionDeleteVO();
				sCExceptionDeleteVO.setDelPropNo(			sCExceptionParmVO.getPropNo()		);
				sCExceptionDeleteVO.setDelScExptVerSeq(		sCExceptionParmVO.getScExptVerSeq()	);
				
				dbDao.removeSCExceptionListByVerData(sCExceptionDeleteVO);
			}
			
			//2.현재 버전의 상태를 'Temp.Saved' 로 수정 합니다.
			if (!dbDao.existSCExceptionVersionData(sCExceptionVersionVO)) {
				//Version 정보가 없으면 생성 합니다.
				dbDao.addSCExceptionVersionData(sCExceptionVersionVO);
			}
			else {
				//Version 정보가 있다면, 상태를 'Temp.Saved' 으로 Version 의 상태를 갱신한다.
				dbDao.modifyVersionSTSData(sCExceptionVersionVO);
			}
			
			//3.현재 버전에 대한 정보를 'Temp.Saved' 상태로 Version Prog 에 생성 합니다.
			if (dbDao.isTempSavedStatusOfLastVersionProgData(sCExceptionVersionVO)) {
				dbDao.modifyLastVersionProgData(sCExceptionVersionVO);
			}
			else {
				dbDao.addSCExceptionVersionProgData(sCExceptionVersionVO);
			}			
			
			//4.이전 버전의 모든 S/C Exception Tariff Group 정보를 신규 버전으로 생성 합니다.
			dbDao.addSCExceptionGroupOfHistVersionData(sCExceptionParmVO);
			
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
}

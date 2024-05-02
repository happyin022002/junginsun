/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonBCImpl.java
*@FileTitle : ACM_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.07 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration.ACMCommonDBDAO;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.CommonVO;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.LocationSelectionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMCommon Business Logic Command Interface<br>
 * - ALPS-ACMCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_CommonEvent,ACMCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMCommonBCImpl extends BasicCommandSupport implements ACMCommonBC {

	// Database Access Object
	private transient ACMCommonDBDAO dbDao = null;

	/**
	 * ACMCommonBCImpl 객체 생성<br>
	 * ACMCommonDBDAO를 생성한다.<br>
	 */
	public ACMCommonBCImpl() {
		dbDao = new ACMCommonDBDAO();
	}

	/**
	 * 공통 : A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeFromBkgChnAgnList(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getAROfficeFromBkgChnAgnList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : China Anegt info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getBkgChnAgnInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getBkgChnAgnInfo(commonVO);
			if ("EXIST".equals(commonVO.getValue9())) {    // 존재한다면 정상리턴, 0건이면 에러
				if (commonVOlist.size() < 1) {
					throw new EventException(new ErrorHandler("ACM00005", new String[]{"Agent [" + commonVO.getValue0() + "]"}).getMessage());
				}
			} else {    // 존재하지 않는다면 정상리턴, 0건 이상이면 에러
				if (commonVOlist.size() > 0) {
					// [ACM00004] - $s is duplicated. Please check $s again!
					throw new EventException(new ErrorHandler("ACM00004", new String[]{"Agent [" + commonVO.getValue0() + "]", "Agent"}).getMessage());
				}
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM ORGANIZATION info 단건/목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmOrganizationInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmOrganizationInfo(commonVO);
			if (commonVOlist.size() < 1) {
				if ("".equals(commonVO.getValue8())) {    // 기본 Err Msg
					throw new EventException(new ErrorHandler("ACM00002", new String[]{"Office Code [" + commonVO.getValue0() + "]", "Office Code"}).getMessage());
				} else {    // 기본 Err Msg를 대체할 단어
					throw new EventException(new ErrorHandler("ACM00002", new String[]{commonVO.getValue8() + " [" + commonVO.getValue0() + "]", commonVO.getValue8()}).getMessage());
				}
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM VENDOR info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmVendorInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmVendorInfo(commonVO);
			if (commonVOlist.size() < 1) {
				throw new EventException(new ErrorHandler("ACM00002", new String[]{"Vendor Code [" + commonVO.getValue0() + "]", "Vendor Code"}).getMessage());
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM LOCATION info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmLocationInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmLocationInfo(commonVO);
			if (commonVOlist.size() < 1) {
				if ("".equals(commonVO.getValue8())) {    // 기본 Err Msg
					throw new EventException(new ErrorHandler("ACM00002", new String[]{"Location [" + commonVO.getValue0() + "]", "Location"}).getMessage());
				} else {    // 기본 Err Msg를 대체할 단어
					throw new EventException(new ErrorHandler("ACM00002", new String[]{commonVO.getValue8() + " [" + commonVO.getValue0() + "]", commonVO.getValue8()}).getMessage());
				}
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM VESSEL SERVICE LANE info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmVslSvcLaneInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmVslSvcLaneInfo(commonVO);
			if (commonVOlist.size() < 1) {
				throw new EventException(new ErrorHandler("ACM00002", new String[]{"Lane [" + commonVO.getValue0() + "]", "Lane"}).getMessage());
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM ORGANIZATION에서 RHQ 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getRhqLevelFromMdmOrganizationInfo(SignOnUserAccount account) throws EventException {
		CommonVO commonVO = new CommonVO();
		commonVO.setValue0(account.getUsr_id());
		try {
			return dbDao.getRhqLevelFromMdmOrganizationInfo(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : 로그인한 사용자의 ofc_cd에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeByUserOfficeList(SignOnUserAccount account) throws EventException {
		CommonVO commonVO = new CommonVO();
		commonVO.setValue0(account.getOfc_cd());
		try {
			List<CommonVO> mdmOrgVOlist = dbDao.getMdmOrganizationInfo(commonVO);
			// ofc_knd_cd가 1(본사 USER) 또는 2(RHQ USER), 9(CLT USER)라면
			if ("1".equals(mdmOrgVOlist.get(0).getValue2()) || "2".equals(mdmOrgVOlist.get(0).getValue2()) || "9".equals(mdmOrgVOlist.get(0).getValue2())) {
				//  Value0에 AR_HD_QTR_OFC_CD Setting
				commonVO.setValue0(mdmOrgVOlist.get(0).getValue7());
				return dbDao.getAROfficeByRhqLevelHighList(commonVO);
			}
			// 아니라면(지점 USER)
			else {
				// Value0에 OFC_CD Setting되어 있슴
				return dbDao.getAROfficeByUserOfficeList(commonVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : 사용자의 Office Code에 따른 AGN 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAgnByAROfficeList(CommonVO commonVO, SignOnUserAccount account) throws EventException {
		try {
			commonVO.setValue1(account.getOfc_cd());
			return dbDao.getAgnByAROfficeList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM_CHARGE info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmChageInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmChageInfo(commonVO);
			if (commonVOlist.size() < 1) {
				throw new EventException(new ErrorHandler("ACM00002", new String[]{"Charge Code [" + commonVO.getValue0() + "]", "Charge Code"}).getMessage());
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM_SVC_SCP info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmServiceScopeInfo(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getMdmServiceScopeInfo(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : ACM_COMM_TP_CD_MAPG info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAcmCommTpCdMapg(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getAcmCommTpCdMapg(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : ACM_OFC_INFO에서 AGN 목록/단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAgnFromAcmOfcInfoList(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getAgnFromAcmOfcInfoList(commonVO);
			if (commonVOlist.size() < 1) {
				throw new EventException(new ErrorHandler("ACM00044", new String[]{commonVO.getValue0()}).getMessage());
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : ACM_OFC_INFO에서 RHQ 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getRhqFromAcmOfcInfoList(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getRhqFromAcmOfcInfoList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM CURRENCY info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmCurrencyInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmCurrencyInfo(commonVO);
			if (commonVOlist.size() < 1) {
				throw new EventException(new ErrorHandler("ACM00002", new String[]{"Currency Code [" + commonVO.getValue0() + "]", "Currency Code"}).getMessage());
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : 로그인한 사용자의 ofc_cd로 Sales Office 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getSalesOfficeFromMdmOrganizationList(SignOnUserAccount account) throws EventException {
		CommonVO commonVO = new CommonVO();
		commonVO.setValue0(account.getOfc_cd());
		try {
			return dbDao.getSalesOfficeFromMdmOrganizationList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : [ESM_ACM_0029]Special Compensation Audit 의 Office Code 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeAgmtCmpnInfoList(SignOnUserAccount account) throws EventException {
		CommonVO commonVO = new CommonVO();
		commonVO.setValue0(account.getOfc_cd());
		try {
			return dbDao.getAROfficeAgmtCmpnInfoList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM_CUSTOMER에서 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmCustomerInfo(CommonVO commonVO) throws EventException {
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmCustomerInfo(commonVO);
			if (commonVOlist.size() < 1) {
				throw new EventException(new ErrorHandler("ACM00002", new String[]{"Customer Code [" + commonVO.getValue0() + "]", "Customer Code"}).getMessage());
			}
			return commonVOlist;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : RHQ Level에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAROfficeByRhqLevelList(CommonVO commonVO, SignOnUserAccount account) throws EventException {
		try {
			// value1(ofc_knd_cd)이 1(본사 USER) 또는 2(RHQ USER), 9(CLT USER)라면
			if ("1".equals(commonVO.getValue1()) || "2".equals(commonVO.getValue1()) || "9".equals(commonVO.getValue1())) {
				// Value0에 rhq_cd Setting되어 있슴
				return dbDao.getAROfficeByRhqLevelHighList(commonVO);
			}
			// 아니라면(지점 USER)
			else {
				// Value0에 User ID Setting
				commonVO.setValue0(account.getUsr_id());
				return dbDao.getAROfficeByRhqLevelLowList(commonVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM_REP_CMDT 혹은 MDM_COMMODITY에서 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getMdmCommodityInfo(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getMdmCommodityInfo(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : [ESM_ACM_0023]FF Compensation Agreement Creation 저장 전 "Charge(Only for BS)"항목 체크<br>
	 * (MDM_CHARGE의 ERR_CNT 가 0인지 아닌지 조회)
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getFfChgCtntChkList(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getFfChgCtntChkList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : 입력된 코드가 MDM_CNTR_TP 에 존재하는지 체크<br>
	 *
	 * @param CommonVO commonVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getMdmCntrTpChkList(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getMdmCntrTpChkList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : 입력된 office code 가 상계 정산 대리점(operational)인지 체크.(리턴값 => operational : Y, else : N)<br>
	 *
	 * @param CommonVO commonVO
	 * @return String
	 * @exception EventException
	 */
	public String getOffSetFlag(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getOffSetFlag(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(1. Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectConti(LocationSelectionVO locationSelectionVO) throws EventException {
		try {
			return dbDao.searchLocSelectConti(locationSelectionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(2. Sub Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectSubConti(LocationSelectionVO locationSelectionVO) throws EventException {
		try {
			return dbDao.searchLocSelectSubConti(locationSelectionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(3. Country)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectCountry(LocationSelectionVO locationSelectionVO) throws EventException {
		try {
			return dbDao.searchLocSelectCountry(locationSelectionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(4. Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception EventException
	 */
	public List<LocationSelectionVO> searchLocSelectLocation(LocationSelectionVO locationSelectionVO) throws EventException {
		try {
			return dbDao.searchLocSelectLocation(locationSelectionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : RHQ에 따른 Agent Code 목록을 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getAgnByRhqList(SignOnUserAccount account) throws EventException {
		CommonVO commonVO1 = new CommonVO();
		commonVO1.setValue0(account.getOfc_cd());
		CommonVO commonVO2 = new CommonVO();
		try {
			List<CommonVO> commonVOlist = dbDao.getMdmOrganizationInfo(commonVO1);
			commonVO2.setValue0(commonVOlist.get(0).getValue7());
			return dbDao.getAgnByRhqList(commonVO2);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : MDM_TRADE 테이블의 TRD_CD 목록을 조회<br>
	 *
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getMdmTradeList() throws EventException {
		try {
			return dbDao.getMdmTradeList();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : COA_LANE_RGST 테이블의 RLANE_CD 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	public List<CommonVO> getCoaLaneRgstList(CommonVO commonVO) throws EventException {
		try {
			return dbDao.getCoaLaneRgstList(commonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
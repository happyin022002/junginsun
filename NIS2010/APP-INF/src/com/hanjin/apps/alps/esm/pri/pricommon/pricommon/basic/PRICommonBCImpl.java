/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRICommonBCImpl.java
 *@FileTitle : PRICommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
 * 1.0 Creation
=========================================================
 * History
 * 2011-08-18 송호진 [CHM-2011128680-01]관련 EAI Send Log 생성부분 추가
 * 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchCheckRfaCtrtRqstOfc Method 추가
 * 2013.04.29 김보배 [CHM-201324375] Publish 기능 이전 요청
 * 2013.10.16 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
 * 2015.04.22 송호진 [CHM-201535019] Customer Type = A 에 Actual Customer 란 활성화 요청
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.09.07 [CHM-201642825] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 (정식방식)
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration.PRICommonDBDAO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PriCommonVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltChkRatePortVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltPriMdmSlsRepVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUpldFileVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.PriAuthorizationVO;
import com.hanjin.syscommon.common.table.PriEaiSndLogVO;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriTariffVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * NIS2010-PRICommon Business Logic Basic Command implementation<br>
 * - NIS2010-PRICommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sungsoo
 * @see PRICommonEventResponse,PRICommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */


public class PRICommonBCImpl extends BasicCommandSupport implements PRICommonBC {

	// Database Access Object
	private transient PRICommonDBDAO dbDao = null;

	/**
	 * PRICommonBCImpl 객체 생성<br>
	 * PRICommonDBDAO를 생성한다.<br>
	 */
	public PRICommonBCImpl() {
		dbDao = new PRICommonDBDAO();
	}

	/**
	 * Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CurrencyCodeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCurrencyCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCurrencyCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PerCodeList 를 조회합니다.<br>
	 * Per Type 코드,명칭 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPerCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPerCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Sub-continent 코드리스트<br>
	 * Combo List에서 사용하는 코드를 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubcontinentCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSubcontinentCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Service Scope Detail Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param String svcScpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchServiceScopeCodeDetailName(String svcScpCd) throws EventException {
		try {
			return dbDao.searchServiceScopeCodeDetailName(svcScpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Location Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			List<RsltCdListVO> list = null;
			if (rsltCdlistVo.getNm() != null && ("rg".equals(rsltCdlistVo.getNm()) || "rpscp".equals(rsltCdlistVo.getNm()) || "rqscp".equals(rsltCdlistVo.getNm()))) {
				list = dbDao.searchRFALocationName(rsltCdlistVo);
			} else {
				list = dbDao.searchLocationName(rsltCdlistVo);
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Country Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryName(String cntCd) throws EventException {
		try {
			return dbDao.searchCountryName(cntCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param String cmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityName(String cmdtCd) throws EventException {
		try {
			return dbDao.searchCommodityName(cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rep Commodity Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param String repCmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRepCommodityName(String repCmdtCd) throws EventException {
		try {
			return dbDao.searchRepCommodityName(repCmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SurchargeCodeList 를 조회합니다.<br>
	 * Surcharge 코드,명칭 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSurchargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSurchargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity Group Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodityGroupName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			String cmdtNm = null;
			if (rsltCdlistVo.getNm() != null && "proposal".equals(rsltCdlistVo.getNm())) {
				cmdtNm = dbDao.searchSpCommodityGroupName(rsltCdlistVo);
			} else if (rsltCdlistVo.getNm() != null && "rg".equals(rsltCdlistVo.getNm())) {
				cmdtNm = dbDao.searchRgCommodityGroupName(rsltCdlistVo);
			} else if (rsltCdlistVo.getNm() != null && "rpscp".equals(rsltCdlistVo.getNm())) {
				cmdtNm = dbDao.searchRpCommodityGroupName(rsltCdlistVo);
			} else if (rsltCdlistVo.getNm() != null && "cmpb".equals(rsltCdlistVo.getNm())) {
				// CMPB [PRS]
				cmdtNm = dbDao.searchCmpbCommodityGroupName(rsltCdlistVo);
			} else if (rsltCdlistVo.getNm() != null && "sq".equals(rsltCdlistVo.getNm())) {
				// SQ [PRS]
				cmdtNm = dbDao.searchSqCommodityGroupName(rsltCdlistVo);
			} else if (rsltCdlistVo.getNm() != null && "rq".equals(rsltCdlistVo.getNm())) {
				// RQ [PRS]
				cmdtNm = dbDao.searchRqCommodityGroupName(rsltCdlistVo);
			} else {
				cmdtNm = dbDao.searchCommodityGroupName(rsltCdlistVo);
			}

			return cmdtNm;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Location Group Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationGroupName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			String locNm = null;
			if (rsltCdlistVo.getNm() != null && "rg".equals(rsltCdlistVo.getNm())) {
				locNm = dbDao.searchRgLocationGroupName(rsltCdlistVo);
			} else if (rsltCdlistVo.getNm() != null && "rpscp".equals(rsltCdlistVo.getNm())) {
				locNm = dbDao.searchRpLocationGroupName(rsltCdlistVo);
				// CMPB [PRS]
			} else if (rsltCdlistVo.getNm() != null && "cmpb".equals(rsltCdlistVo.getNm())) {
				locNm = dbDao.searchCmpbLocationGroupName(rsltCdlistVo);
				// SQ [PRS]
			} else if (rsltCdlistVo.getNm() != null && "sq".equals(rsltCdlistVo.getNm())) {
				locNm = dbDao.searchSqLocationGroupName(rsltCdlistVo);
				// RQ [PRS]
			} else if (rsltCdlistVo.getNm() != null && "rq".equals(rsltCdlistVo.getNm())) {
				locNm = dbDao.searchRqLocationGroupName(rsltCdlistVo);
			} else {
				locNm = dbDao.searchLocationGroupName(rsltCdlistVo);
			}

			return locNm;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * MdmCntrSzCodeList 를 조회합니다.<br>
	 * mdm_cntr_sz 코드,명칭 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMdmCntrSzCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchMdmCntrSzCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SpScpServiceScopeCodeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSpScpServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * OfficeCodeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchOfficeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchOfficeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SalesRepByOfficeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepByOfficeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepByOfficeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SalesRepByMultiOfficeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepByMultiOfficeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepByMultiOfficeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * SpScpMqcServiceScopeCodeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSpScpMqcServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSpScpMqcServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RasOrganizationList 를 조회합니다.<br>
	 * 조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRasOrganizationList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * UsExangeAmount 를 조회합니다.<br>
	 * 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchUsExangeAmount(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * unmatch type code List 를 조회합니다.<br>
	 * BKG_REV_UMCH_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchTpList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * unmatch sub type code List 를 조회합니다.<br>
	 * BKG_REV_UMCH_SUB_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchSubTpList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SalesRepCodeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SpScopeGroupLocationName 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public String searchSpScopeGroupLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSpScopeGroupLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SubTrdCdList 를 조회합니다.<br>
	 * mdm_sub_trd 코드,명칭 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSubTrdCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSubTrdCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SvcScpLaneCdList 를 조회합니다.<br>
	 * mdm_svc_scp_lane 코드,명칭 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpLaneCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSvcScpLaneCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CustomerName 를 조회합니다.<br>
	 * CustomerName 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustomerName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCustomerName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ChargeCdList 를 조회합니다.<br>
	 * mdm_charge 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchChargeCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ScgGrpCmdtCdList 를 조회합니다.<br>
	 * mdm_charge 코드,명칭 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScgGrpCmdtCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchScgGrpCmdtCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SurchargeGroupLocationName 를 조회합니다.<br>
	 * pri_scg_grp_loc 명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchSurchargeGroupLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSurchargeGroupLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Region Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRegionName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRegionName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Authorization을 조회합니다.<br>
	 * 
	 * @param PriAuthorizationVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthorization(PriAuthorizationVO vo) throws EventException {
		try {
			return dbDao.searchAuthorization(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Tariff Code로 PRI_AUTHORIZATION 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO vo
	 * @return List<PriAuthorizationVO>
	 * @exception EventException
	 */
	public List<PriAuthorizationVO> searchAuthByTariff(RsltCdListVO vo) throws EventException {
		try {
			return dbDao.searchAuthByTariff(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ScopeChargeCodeList 를 조회합니다.<br>
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScopeChargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchScopeChargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS에서 사용하는 ScopeChargeCodeList 를 조회합니다.<br>
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPRSScopeChargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPRSScopeChargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AllCurrencyCodeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllCurrencyCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchAllCurrencyCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SvcScpPptMapgList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSvcScpPptMapgList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSvcScpPptMapgList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AllPerCodeList 를 조회합니다.<br>
	 * Per Type 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAllPerCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchAllPerCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * NoteConvRuleMapgList 를 조회합니다.<br>
	 * Note Conversion Rule 코드,명칭 CONVERSION TYPE별로 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConvRuleMapgList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchNoteConvRuleMapgList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Request Office Name 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRequestOfficeName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRequestOfficeName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CustBySaleRepList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustBySaleRepList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCustBySaleRepList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Sales Rep Code 로 Office Code 와 Sales Rep Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCustByReqOffice(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCustByReqOffice(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ApprovalOfficeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchApprovalOfficeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 기존의 office코드와 함께 ApprovalOfficeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalOfficeAllList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchApprovalOfficeAllList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Location, Group Location, Country, Region Name을 조회합니다.<br>
	 * Code 의 자리수로 구분해서 Name 을 조회한다.
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTotalLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTotalLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PrsExchangeRateYrMon 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsExchangeRateYrMon(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPrsExchangeRateYrMon(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PrsExchangeRateYrMon 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsTPExchangeRateYrMon(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPrsTPExchangeRateYrMon(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RqExchangeRateYrMon 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsRqExchangeRateYrMon(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPrsRqExchangeRateYrMon(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PrsRpExchangeRateYrMon 를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsRpExchangeRateYrMon(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPrsRpExchangeRateYrMon(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PrsSqExchangeRateYrMon를 조회합니다.<br>
	 * 해당 Exchange Rate 년월을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchPrsSqExchangeRateYrMon(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchPrsSqExchangeRateYrMon(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VESSEL SERVICE LANE의 코드명을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVesselServiceLaneName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchVesselServiceLaneName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VSK VESSEL SCHEDULE 코드를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchVskVesselScheduleCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchVskVesselScheduleCode(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Actual Customer 리스트 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchActualCustomerList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchActualCustomerList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * IMDG Class 리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchImdgClassCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchImdgClassCode(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Location Code 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeLocationCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchServiceScopeLocationCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * cmpb group commodity Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchCmpbGroupCommodityName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCmpbGroupCommodityName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * cmpb group location Name<br>
	 * 코드에 해당하는 이름을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchCmpbGroupLocationName(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCmpbGroupLocationName(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRpScpServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRpScpServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SYS_GUID()값을 조회한다.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchSysGuid() throws EventException {
		try {
			return dbDao.searchSysGuid();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 공통 코드,명칭 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect(rsltCdlistVo.getCd(), 0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
			// CD01701
			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rowVo = new RsltCdListVO();
				rowVo.setCd(cdList.get(i).getCode());
				rowVo.setNm(cdList.get(i).getName());

				list.add(rowVo);
			}
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 공통 코드,명칭을 한번에 조회합니다.<br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect(paramCdlistvo.getCd(), 0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rsltCdlistVo = new RsltCdListVO();
				rsltCdlistVo.setCd(cdList.get(i).getCode());

				if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01701")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
				} else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01714")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
				} else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02128")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
				} else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02141")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
				} else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02085")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
				} else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02202")) {
					rsltCdlistVo.setNm(cdList.get(i).getCode() + "\t" + cdList.get(i).getName());
				} else {
					rsltCdlistVo.setNm(cdList.get(i).getName());
				}

				list.add(rsltCdlistVo);
			}

			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * DMT S/C EXCEPTION GROUP에서 PROP_NO가 존재하는지 조회합니다.<br>
	 * 
	 * @param rsltCdlistVo RsltCdListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDmtScExptGrpCount(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchDmtScExptGrpCount(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * CHSS S/C EXCEPTION LIST에서 PROP_NO가 존재하는지 조회합니다.<br>
	 * 
	 * @param rsltCdlistVo RsltCdListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchChssScExptListCount(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchChssScExptListCount(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rep Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRepChargeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * S/C No prefix 리스트 를 조회합니다.<br>
	 * 공통 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchScPrefixList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchScPrefixList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * S/C RHQ 리스트 를 조회합니다.<br>
	 * 공통 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRHQList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRHQList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Batch Job 실행후 jobid와 상태를 program no(etc1)와 parameter(etc2)로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public RsltCdListVO searchBatchScheduleJobIdAndStatus(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			RsltCdListVO rtn = new RsltCdListVO();
			rsltCdlistVo.setEtc2(rsltCdlistVo.getEtc2().replaceAll("\\|", " "));
			String jobId = dbDao.searchBatchScheduleJobId(rsltCdlistVo);
			int status = 0;
			/*
			 * status 0 <NULL> 알수없음 status 1 RUNNING 수행중 status 3 STARTING 시작(시스템) status 4 SUCCESS 성공 status 5 FAILURE 실패 status 6 TERMINATED 강제종료 status 7 ON_ICE 논리삭제
			 * status 8 INACTIVE 실행대기 status 9 ACTIVATED 활성화(시스템) status 10 RESTART 시작시에러 status 11 ON_HOLD 일시정지 status 12 QUE_WAIT 로드밸런싱 대기
			 */
			if (jobId != null) {
				ScheduleUtil su = new ScheduleUtil();
				// ScheduleUtil에서 parameter 가 하나 늘어나서 임시로 parameter 추가함
				status = su.getJobStatus(jobId, "QT");
			}
			rtn.setCd(jobId);
			rtn.setNm(String.valueOf(status));
			return rtn;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * TermTypeList 조회 이벤트 처리<br>
	 * S/C Term Type 을 조회한다.<br>
	 * 
	 * @param rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTermTypeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * TermTypeList 조회 이벤트 처리<br>
	 * RFA Term Type 을 조회한다.<br>
	 * 
	 * @param rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRfaTermTypeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRfaTermTypeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Trade Code를 조회 이벤트 처리<br>
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTradeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTradeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Surcharge Trade Code를 조회 이벤트 처리<br>
	 * Trade 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSurchargeTradeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSurchargeTradeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RLane을 조회 이벤트 처리<br>
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRLaneCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRLaneCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param ComOrganizationVO comOrganizationVO
	 * @return List<ComOrganizationVO>
	 * @exception EventException
	 */
	public List<ComOrganizationVO> searchOrganizationList(ComOrganizationVO comOrganizationVO) throws EventException {
		try {
			return dbDao.searchOrganizationList(comOrganizationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * charge 리스트를 조회합니다.<br>
	 * 
	 * @param MdmChargeVO mdmChargeVO
	 * @return List<MdmChargeVO>
	 * @exception EventException
	 */
	public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException {
		try {
			return dbDao.searchChargeList(mdmChargeVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 로그인 사용자의 SELECT 권한 정보와 REQUEST OFFICE를 조회합니다.[PRS용]<br>
	 * 
	 * @param RsltPriAuthorizationVO priAuthorizationVO
	 * @param SignOnUserAccount account
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO searchAuthorizationOffice(RsltPriAuthorizationVO priAuthorizationVO, SignOnUserAccount account) throws EventException {
		try {
			RsltCdListVO returnVO = new RsltCdListVO();
			returnVO.setCd("X");// 일반사용자.
			List<RsltPriMdmSlsRepVO> mdmSlsRepVO = dbDao.searchMdmSlsRep(account.getUsr_id());
			if (mdmSlsRepVO.size() > 0 && mdmSlsRepVO.get(0).getOfcCd() != null && mdmSlsRepVO.get(0).getOfcCd().length() != 0) {
				returnVO.setCd("S");// Sales Rep 사용자
				returnVO.setNm(mdmSlsRepVO.get(0).getOfcCd());// request office
			} else {
				List<RsltPriAuthorizationVO> authVO = dbDao.searchPriAuthorization(priAuthorizationVO);
				if (authVO != null && authVO.size() > 0) {
					returnVO.setCd("A");// 승인권자.
				}
			}
			return returnVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Sales Rep Code 로 User 정보를 조회합니다.<br>
	 * 
	 * @param MdmSlsRepVO mdmSlsRepVO
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchSalesRepInfo(MdmSlsRepVO mdmSlsRepVO) throws EventException {
		try {
			return dbDao.searchSalesRepInfo(mdmSlsRepVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS BATCH table에 parameter와 program id, batch id를 저장합니다.<br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addPrsBatch(PriPrsBatVO priPrsBatVO, SignOnUserAccount account) throws EventException {
		try {
			priPrsBatVO.setCreUsrId(account.getUsr_id());
			priPrsBatVO.setUpdUsrId(account.getUsr_id());
			dbDao.addPrsBatch(priPrsBatVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS BATCH table에 prs_bat_id 값을 update한다. <br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @exception EventException
	 */
	public void modifyPrsBatchMaxRotation(PriPrsBatVO priPrsBatVO) throws EventException {
		try {
			dbDao.modifyPrsBatchMaxRotation(priPrsBatVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS BATCH table에 log 값을 update한다. <br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @exception EventException
	 */
	public void modifyPrsBatchLog(PriPrsBatVO priPrsBatVO) throws EventException {
		try {
			dbDao.modifyPrsBatchLog(priPrsBatVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS BATCH table에서 parameter와 program id를 이용해 batch id를 조회합니다.<br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @return PrsBatchVO
	 * @exception EventException
	 */
	public PrsBatchVO searchPrsBatchMaxRotation(PriPrsBatVO priPrsBatVO) throws EventException {
		try {
			return dbDao.searchPrsBatchMaxRotation(priPrsBatVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS BATCH table에서 parameter와 program id를 이용해 batch id를 조회합니다.<br>
	 * 
	 * @param PriPrsBatVO priPrsBatVO
	 * @return PrsBatchVO
	 * @exception EventException
	 */
	public PrsBatchVO searchPrsBatch(PriPrsBatVO priPrsBatVO) throws EventException {
		try {
			return dbDao.searchPrsBatch(priPrsBatVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Tariff Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTariffCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Service Scope Code 로 Tariff Code 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeByServiceScopeCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTariffCodeByServiceScopeCode(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Actual Customer 리스트 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRFAActualCustomerList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchRFAActualCustomerList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Tariff Code 가 존재하는 Service Scope Code List 전체를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffServiceScopeCodeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTariffServiceScopeCodeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob의 상태를 조회합니다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
	 * 
	 * @param ComUpldFileVO comUpldFileVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExcelTemplateFileKey(ComUpldFileVO comUpldFileVO) throws EventException {
		try {
			return dbDao.searchExcelTemplateFileKey(comUpldFileVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Compensation Charge Combo list 리스트를 조회한다.<br>
	 * DHF, CMS, NMS, ODF 조회.<br>
	 * 
	 * @param RsltCompensationChargeComboListVO pVo
	 * @return List<RsltCompensationChargeComboListVO>
	 * @exception EventException
	 */
	public List<RsltCompensationChargeComboListVO> searchCompensationChargeComboList(RsltCompensationChargeComboListVO pVo) throws EventException {
		try {
			return dbDao.searchCompensationChargeComboList(pVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Sales Rep 에 대한 Customer List 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepListByCustOnly(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepListByCustOnly(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Region Code, Contry Code가 MDM_SVC_SCP_LMT 에 Origin, Dest에 맞춰서 존재 하는지 확인한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckServiceScopeOriginDestRegionList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCheckServiceScopeOriginDestRegionList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 화면 조회이후 upd_dt가 변경되었는지 확인한다.<br>
	 * 
	 * @param CheckUpdateDateVO checkUpdateDate
	 * @return CheckUpdateDateVO
	 * @exception DAOException
	 */
	public CheckUpdateDateVO searchCheckUpdateDate(CheckUpdateDateVO checkUpdateDate) throws EventException {
		try {
			checkUpdateDate.setTableName(checkUpdateDate.getTableName().toUpperCase());
			return dbDao.searchCheckUpdateDate(checkUpdateDate);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 입력한 Tariff Code에 해당하는 Tariff Name 조회
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	public List<PriTariffVO> searchTariffCodeName(PriTariffVO priTariffVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchTariffCodeName(priTariffVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SYSDATE의 정보를 YYYYMMDD포멧으로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchSystemDate(RsltCdListVO rsltCdlistVo) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchSystemDate(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Pricing EAI Send Log 정보를 저장합니다.<br>
	 * 
	 * @param PriEaiSndLogVO priEaiSndLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addEaiSendLog(PriEaiSndLogVO priEaiSndLogVO, SignOnUserAccount account) throws EventException {
		try {
			if (priEaiSndLogVO != null) {
				priEaiSndLogVO.setCreUsrId(account.getUsr_id());
				dbDao.addEaiSendLog(priEaiSndLogVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 해당 RFA No,Proposal No가 BA Office에서 생성된것인지 확인<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRfaCtrtRqstOfc(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCheckRfaCtrtRqstOfc(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 2012.05.22 추가 <br>
	 * 구주 Hinterland 프로젝트에 따른 변경 사항 <br>
	 * 구주 Hinterland 프로젝트 오픈 이전에 발생한 AEW, AEE에 대해서는 Ament 불가<br>
	 * 
	 * @param rsltCdlistVo
	 * @return int
	 * @throws EventException
	 */
	public int searchCheckForBeforeAmend(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCheckForBeforeAmend(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal Creation-Rate[Load Excel] <br>
	 * SERVICE SCOPE 가 AEE, AEW인경우 PORT 코드 체크를 위한 메소드 <BR>
	 * 
	 * @return List<RsltChkRatePortVO>
	 * @throws EventException
	 */
	public List<RsltChkRatePortVO> searchCheckRatePort() throws EventException {
		try {
			return dbDao.searchCheckRatePort();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 환율 변환 ==> USD ==> Local Currency
	 * 
	 * @param PriCommonVO priCommonVO
	 * @return String
	 * @throws EventException
	 */
	public String searchFromUsdToEtcCurrency(PriCommonVO priCommonVO) throws EventException {
		try {
			return dbDao.searchFromUsdToEtcCurrency(priCommonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RHQ 별 Service Scope 리스트 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeByRhqOfc(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchServiceScopeByRhqOfc(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RHQ 별 Service Scope 리스트 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffIhcExceptionCyLocation(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchTariffIhcExceptionCyLocation(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Service Scope 별 Bound 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBoundByServiceScope(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchBoundByServiceScope(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * US Country 정보를 조회합니다. ( FOR Add-on management T/F Project ) <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchUSInlandCountryCode(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchUSInlandCountryCode(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Copy 이전의 Duration 날짜 조회. <br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchDurationDateForRateCopy(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchDurationDateForRateCopy(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * To Date 조회 <br>
	 * 
	 * @return String 
	 * @exception EventException
	 */
	public String searchToDate() throws EventException {
		try {
			return dbDao.searchToDate();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Mapping 을 위한 Country 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchAocTariffCountryList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchAocTariffCountryList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Percent Base CHG Creation 화면에서 사용할 ChargeList 를 조회합니다.<br>
	 * mdm_charge 코드,명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeListForPctBse (RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchChargeListForPctBse(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 2015.04.13 추가 <br>
	 * Shipper's Association S/C 에서 Actual Customer 를 입력할 때 
	 * Affiliate 로 등재 되어있는 지를 체크한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return int
	 * @throws EventException
	 */
	public int searchCheckValidAfil(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchCheckValidAfil(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 2016.04.15 추가 <br>
	 * Master RFA의 Route Note Conversion 코드를 조회한다.
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMstNoteConvChgCdList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchMstNoteConvChgCdList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * SalesRepRoleByOfficeList 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchSalesRepRoleByOfficeList(RsltCdListVO rsltCdlistVo) throws EventException {
		try {
			return dbDao.searchSalesRepRoleByOfficeList(rsltCdlistVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * S/C File Cancel 권한 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkFileCancelAuth(RsltCdListVO rsltCdlistVo, SignOnUserAccount account) throws EventException {
		try {
			rsltCdlistVo.setEtc2(account.getUsr_id());
			return dbDao.checkFileCancelAuth(rsltCdlistVo);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}	
	

	/**
	 * 2016.05.02 추가 <br>
	 * Master RFA의 권한을 조회한다.
	 * 
	 * @param String usr_id
	 * @return RsltCdListVO rsltCdlistVo
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchMstRfaAuthList(String usr_id) throws EventException {
		try {
			return dbDao.searchMstRfaAuthList(usr_id);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
}
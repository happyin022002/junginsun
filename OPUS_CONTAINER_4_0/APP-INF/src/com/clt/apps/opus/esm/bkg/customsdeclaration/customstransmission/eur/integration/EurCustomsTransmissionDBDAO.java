/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BrcsCustomsTransmissionDBDAO.java
 *@FileTitle : CustomsTransmission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.25 경종윤
 * 1.0 Creation
 * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
 *    1) EU CTA : searchBlCustomerInfo  메소드내에 bkgNo 가지고 오늘 로직 추가
 *    2) SITPRO : EU MNR 정보를 가지고 오는 searchEuMrnByBkg 메소드 추가
 *-------------------------------------------------------
 * History
 * 2011.02.23 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
 * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
 * 2011.11.15 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
 * 2013.11.29 김보배 [CHM-201327231] [EU Manifest] EU customs EDI 화면상 export (outbound) 전송 버튼 추가 요청
 * 2013.12.23 김보배 [CHM-201327974] Sitpro 항목 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration.BrcsCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrBlLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrCntrRfAkBrCgoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrMndDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoTTLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrRateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrVslCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsBlLodFctrLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsEurDgEdiRspnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsEurDgSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.BkgCstmsEurDgSndVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurBkgNoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurBkgVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurEtaInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProBkgQtyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCmDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCmInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCntrRfAkBrCgoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCntrSealListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCommodityVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProDgInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProELNumberInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProEuMrnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProMsnInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProPoStkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProRateAmountTTLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProRateAmountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslEtcInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitproEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration.SpecialManifestDBDAOaddAckCSQL;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration.SpecialManifestDBDAOaddAckDtlCSQL;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration.SpecialManifestDBDAOsearchRcvLogSeqRSQL;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgDtlVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;

/**
 * NIS2010 BrcsCustomsTransmissionDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see BrcsCustomsTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public class EurCustomsTransmissionDBDAO extends BrcsCustomsTransmissionDBDAO {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	BrVslCondVO brVslCondVO =  null;
	
	public EurCustomsTransmissionDBDAO() {
		brVslCondVO = new BrVslCondVO();
		brVslCondVO.setCntGubun("EUR");
	}

	/**
	 * GB지역 UVI정보를 찾아온다.<br>
	 * 
	 * @param  String vvdCd
	 * @param  String polCd
	 * @param  String podCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchUviByVvdPort(String vvdCd, String polCd, String podCd) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !vvdCd.equals("") && ( !polCd.equals("") || !podCd.equals("") ) ) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("vvd_cd", vvdCd);
				mapVO.put("pol_cd", polCd);
				mapVO.put("pod_cd", podCd);

				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchUviRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	/**
	 * 헤더정보를 조회한다.<br>
	 * 
	 * @param  EurManifestTransmitVO eurManifestTransmitVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchHeader(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (eurManifestTransmitVO != null) {
				Map<String, String> mapVO = eurManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchHeaderRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	/**
	 * BKG VVD 정보를 조회한다.<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return EurBkgVvdInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public EurBkgVvdInfoVO searchBkgVvdByVvd(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		EurBkgVvdInfoVO eurBkgVvdInfoVO = new EurBkgVvdInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (eurManifestTransmitVO != null)
			{
				Map<String, String> mapVO = eurManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBkgVvdByVvdRSQL(), param, velParam);
			
			List<EurBkgVvdInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,EurBkgVvdInfoVO.class);
			
			if (list != null && list.size() > 0) {
				eurBkgVvdInfoVO = (EurBkgVvdInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eurBkgVvdInfoVO;
	}
	

	/**
	 * 대상 BKG_NO 리스트를 조회한다.<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<EurBkgNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurBkgNoListVO> searchBkgNoList(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		List<EurBkgNoListVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (eurManifestTransmitVO != null)
			{
				Map<String, String> mapVO = eurManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// exist_search_flag : "Y" => 존재여부만 조회, exist_search_flag : "N" => 대상 리스트를 조회 
				param.put("exist_search_flag", "N");
				velParam.put("exist_search_flag", "N");
				
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBkgNoListRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,EurBkgNoListVO.class);

			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 대상 BKG_NO 리스트 존재여부를 조회한다.<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchExistBkgNoList(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		String retVal = "N";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (eurManifestTransmitVO != null)
			{
				Map<String, String> mapVO = eurManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// exist_search_flag : "Y" => 존재여부만 조회, exist_search_flag : "N" => 대상 리스트를 조회 
				param.put("exist_search_flag", "Y");
				velParam.put("exist_search_flag", "Y");
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EurCustomsTransmissionDBDAOsearchBkgNoListRSQL(), param, velParam);
			
			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = "Y";
				}
			} 
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	/**
	 * B/L정보를 조회한다.<br>
	 * 브라질쪽 searchBlLocInfo 메서드를 사용함<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return BrBlLocInfoVO
	 * @throws Exception
	 */
	public BrBlLocInfoVO searchBlCustomerInfo(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {

		BrBlLocInfoVO brBlLocInfoVO = null;
		
		try {
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			brVslCondVO.setVvdCd(eurManifestTransmitVO.getVvdCd());
			brVslCondVO.setSearchPodCd(eurManifestTransmitVO.getSearchPodCd());
			brVslCondVO.setModeType(eurManifestTransmitVO.getModeType());
			brVslCondVO.setReceiverId(eurManifestTransmitVO.getReceiverId());
			
			brBlLocInfoVO = (BrBlLocInfoVO) super.searchBlLocInfo(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return brBlLocInfoVO;
		
	}
	
	
	
	
	/**
	 * Rate 정보를 조회한다.<br>
	 * 브라질쪽 searchRateAmount 메서드를 사용함<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<BrRateInfoVO>
	 * @throws DAOException
	 */
	public List<BrRateInfoVO> searchRateAmount(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {

		List<BrRateInfoVO> list = null;

		try {
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			
			list = (List<BrRateInfoVO>) super.searchRateAmount(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
		
	}
	
	
	/**
	 * Rate TOTAL 정보를 조회한다.<br>
	 * 브라질쪽 searchRateAmountTTL 메서드를 사용함<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<BrRateInfoTTLVO>
	 * @throws Exception
	 */
	public List<BrRateInfoTTLVO> searchRateAmountTTL(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {

		List<BrRateInfoTTLVO> list = null;

		try {
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			
			list = (List<BrRateInfoTTLVO>) super.searchRateAmountTTL(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
		
	}
	

	/**
	 * BKG의 Mark/Desc 정보를 조회한다.<br>
	 * 브라질쪽 searchMarkDescInfo 메서드를 사용함<br>
	 * 
	 * @param  EurManifestTransmitVO eurManifestTransmitVO
	 * @return BrMndDescInfoVO
	 * @throws DAOException
	 */
	public BrMndDescInfoVO searchMarkDescInfo(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		BrMndDescInfoVO brMndDescInfoVO = null;
		
		try {
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			
			brMndDescInfoVO = (BrMndDescInfoVO) super.searchMarkDescInfo(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return brMndDescInfoVO;
		
	}
	
	
	/**
	 * Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.<br>
	 * 브라질쪽 searchCntrRfAkBrCgo 메서드를 사용함<br>
	 * 
	 * @param  EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<BrCntrRfAkBrCgoInfoVO>
	 * @throws DAOException
	 */
	public List<BrCntrRfAkBrCgoInfoVO> searchCntrRfAkBrCgo(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		List<BrCntrRfAkBrCgoInfoVO> list = null;

		try {
			brVslCondVO.setBlNo(eurManifestTransmitVO.getBlNo());
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			brVslCondVO.setBkgCgoTp(eurManifestTransmitVO.getBkgCgoTp());
			brVslCondVO.setBkgSpeRf(eurManifestTransmitVO.getBkgSpeRf());
			brVslCondVO.setBkgSpeDg(eurManifestTransmitVO.getBkgSpeDg());
			brVslCondVO.setBkgSpeAk(eurManifestTransmitVO.getBkgSpeAk());
			brVslCondVO.setBkgSpeBb(eurManifestTransmitVO.getBkgSpeBb());
			brVslCondVO.setCmdtDesc(eurManifestTransmitVO.getCmdtDesc());
			brVslCondVO.setCmdtCd(eurManifestTransmitVO.getCmdtCd());
			brVslCondVO.setReceiverId(eurManifestTransmitVO.getReceiverId());
			
			
			list = (List<BrCntrRfAkBrCgoInfoVO>) super.searchCntrRfAkBrCgo(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
		
	}

	/**
	 * BrDgInfoVO -> 위험물 정보를 조회한다.<br>
	 * 브라질쪽 searchDangerCgo 메서드를 사용함<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return BrDgInfoVO
	 * @throws DAOException
	 */
	public List<BrDgInfoVO> searchDangerCgo(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		List<BrDgInfoVO> list = null;
		
		try {
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			brVslCondVO.setCntrNo(eurManifestTransmitVO.getCntrCd());
			
			list = super.searchDangerCgo(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
		
	}
	
	/**
	 * CNTR_DESC 정보 조회한다.<br>
	 * 
	 * @param  EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<EurCmVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurCmVO> searchCM(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		List<EurCmVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			if (eurManifestTransmitVO != null)
			{
				Map<String, String> mapVO = eurManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchCMRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,EurCmVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
	}

	/**
	 * BKG Qty를 조회한다.<br>
	 * 브라질쪽 eurManifestTransmitVO 메서드를 사용함<br>
	 * 
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<BkgQtyVO>
	 * @throws DAOException
	 */
	public List<BkgQtyVO> searchBkgQty(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		
		List<BkgQtyVO> list = null;
		try {
			brVslCondVO.setBkgNo(eurManifestTransmitVO.getBkgNo());
			brVslCondVO.setPolCd(eurManifestTransmitVO.getPolCd());
			brVslCondVO.setPodCd(eurManifestTransmitVO.getPodCd());
			
			list = super.searchBkgQty(brVslCondVO);
			
		} catch (DAOException de) {
			throw de;
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
		
	}
	
	/**
	 * Vessel 정보, Vessel ETA 정보를 조회한다.<br>
	 *  
	 * @param EurManifestTransmitVO eurManifestTransmitVO
	 * @return List<EurEtaInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurEtaInfoVO> searchVslInfoVsl(EurManifestTransmitVO eurManifestTransmitVO) throws DAOException {
		List<EurEtaInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (eurManifestTransmitVO != null)
			{
				Map<String, String> mapVO = eurManifestTransmitVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchVslInfoVslRSQL(), param, velParam);
			
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset,EurEtaInfoVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
		
		
	}
	
	/**
	 * 수신정보 키값(MSG_SND_NO) 조회<br>
	 * 
	 * @param String msgTpId
	 * @param String keyType
	 * @param String vvdCd
	 * @param String portCd
	 * @param String dType
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiHistoryKey(String msgTpId, String keyType, String vvdCd, String portCd, String dType) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (msgTpId != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("msgTpId", msgTpId);
				mapVO.put("keyType", keyType);
				mapVO.put("vvdCd", vvdCd);
				mapVO.put("portCd", portCd);
				mapVO.put("dType", dType);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchEdiHistoryKeyRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * 구주  SIT PRO프로그램에서 조회 메서드로 사용함<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return List<SitProCargoManifesDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProCargoManifesDetailVO> searchSitProList(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws DAOException {
		List<SitProCargoManifesDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitProCargoManifestCondForEdiVO != null)
			{
				Map<String, String> mapVO = sitProCargoManifestCondForEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchSitProListRSQL(), param, velParam);
			
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProCargoManifesDetailVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
		
		
	}
	
	/**
	 *구주  SIT PRO - EDI SEND ID 조회<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiSendId(SitproEdiVO sitproEdiVO) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchEdiSendIdRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}

	/**
	 *구주  SIT PRO - LOC_NM 조회 -- 사용안함 삭제예정<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocDesc(SitproEdiVO sitproEdiVO) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchLocDescRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	
	
	
	/**
	 * 구주  SIT PRO - BKG VVD 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProVslInfoVO searchVslEtaEtd(SitproEdiVO sitproEdiVO) throws DAOException {
		SitProVslInfoVO sitProVslInfoVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchVslEtaEtdRSQL(), param, velParam);
			
			List<SitProVslInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProVslInfoVO.class);
			
			if (list != null && list.size() > 0) {
				sitProVslInfoVO = (SitProVslInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProVslInfoVO;
	}

	/**
	 * 구주  SIT PRO - BKG VVD 정보를 조회한다.(booking vvd, pol, pod로)<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProVslInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProVslInfoVO searchBookingVslInfo(SitproEdiVO sitproEdiVO) throws DAOException {
		SitProVslInfoVO sitProVslInfoVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBookingVslInfoRSQL(), param, velParam);
			
			List<SitProVslInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProVslInfoVO.class);
			
			if (list != null && list.size() > 0) {
				sitProVslInfoVO = (SitProVslInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProVslInfoVO;
	}
	
	
	/**
	 *구주  SIT PRO - MRN_NO 조회<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchMrnByVvdPort(SitproEdiVO sitproEdiVO) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchMrnByVvdPortRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	/**
	 *구주  SIT PRO - CM Desc 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProCmDescInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProCmDescInfoVO searchBlCmDesc(SitproEdiVO sitproEdiVO) throws DAOException {
		SitProCmDescInfoVO sitProCmDescInfoVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBlCmDescRSQL(), param, velParam);

			List<SitProCmDescInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProCmDescInfoVO.class);
			
			if (list != null && list.size() > 0) {
				sitProCmDescInfoVO = (SitProCmDescInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProCmDescInfoVO;
	}
	
	/**
	 *구주  SIT PRO - EU MRN 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProEuMrnInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	
	public List<SitProEuMrnInfoVO> searchEuMrnByBkg(SitproEdiVO sitproEdiVO) throws DAOException {
			
			List<SitProEuMrnInfoVO> list = null;
			DBRowSet dbRowset = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try
			{
				if (sitproEdiVO != null)
				{
					Map<String, String> mapVO = sitproEdiVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchEuMrnByVvdBlRSQL(), param, velParam);
				
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProEuMrnInfoVO.class);

				
				
			} catch (SQLException se) {
				log.error(se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
	
	/**
	 * 구주  SIT PRO -  commodity desc정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProCommodityVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProCommodityVO searchCommodityDescByBkgNo(SitproEdiVO sitproEdiVO) throws DAOException {
		
		SitProCommodityVO sitProCommodityVO = new SitProCommodityVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchCommodityDescByBkgNoRSQL(), param, velParam);

			List<SitProCommodityVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProCommodityVO.class);
			
			if (list != null && list.size() > 0) {
				sitProCommodityVO = (SitProCommodityVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProCommodityVO;
	}
	
	/**
	 * 구주  SIT PRO -  B/L정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProBlInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProBlInfoVO searchBlCustomerInfo(SitproEdiVO sitproEdiVO) throws DAOException {
		
		SitProBlInfoVO sitProBlInfoVO = new SitProBlInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBlCustomerInfoRSQL(), param, velParam);

			List<SitProBlInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProBlInfoVO.class);
			
			if (list != null && list.size() > 0) {
				sitProBlInfoVO = (SitProBlInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProBlInfoVO;
	}
	
	/**
	 * 구주  SIT PRO -  msn정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProMsnInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProMsnInfoVO searchMsnByBkg(SitproEdiVO sitproEdiVO) throws DAOException {
		
		SitProMsnInfoVO sitProMsnInfoVO = new SitProMsnInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchMsnByBkgRSQL(), param, velParam);

			List<SitProMsnInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProMsnInfoVO.class);
			
			if (list != null && list.size() > 0) {
			sitProMsnInfoVO = (SitProMsnInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProMsnInfoVO;
	}
	
	/**
	 * 구주  SIT PRO - Rate 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return List<SitRateAmountVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProRateAmountVO> searchRateAmount(SitproEdiVO sitproEdiVO) throws DAOException {
		
		List<SitProRateAmountVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchRateAmountRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProRateAmountVO.class);

			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * PPD_USD 조회<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPpdUsd(SitproEdiVO sitproEdiVO) throws DAOException {
		String retVal = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchPpdUsdRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * CCT_USD 조회<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCctUsd(SitproEdiVO sitproEdiVO) throws DAOException {
		String retVal = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchCctUsdRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
	
	/**
	 * 구주  SIT PRO - Rate TOTAL 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return List<SitProRateAmountTTLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProRateAmountTTLVO> searchRateAmountTTL(SitproEdiVO sitproEdiVO) throws DAOException {
		
		List<SitProRateAmountTTLVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchRateAmountTTLRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProRateAmountTTLVO.class);

			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 구주  SIT PRO - Container 정보 및 Reefer, Break bulk, Akward정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return List<SitProCntrRfAkBrCgoInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProCntrRfAkBrCgoInfoVO> searchCntrRfAkCgo(SitproEdiVO sitproEdiVO) throws DAOException {
		
		List<SitProCntrRfAkBrCgoInfoVO> list = null;
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchCntrRfAkCgoRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProCntrRfAkBrCgoInfoVO.class);

			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 구주  SIT PRO -  위험물 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProDgInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProDgInfoVO> searchDangerCgo(SitproEdiVO sitproEdiVO) throws DAOException {
		
		List<SitProDgInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchDangerCgoRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProDgInfoVO.class);
			
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 구주  SIT PRO -  CNTR Desc 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return List<SitProCmInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProCmInfoVO> searchCmByCntr(SitproEdiVO sitproEdiVO) throws DAOException {
		
		List<SitProCmInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchCmByCntrRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProCmInfoVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 구주  SIT PRO -  PO 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProPoStkVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProPoStkVO searchPoStkByCntr(SitproEdiVO sitproEdiVO) throws DAOException {
		
		SitProPoStkVO sitProPoStkVO = new SitProPoStkVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchDangerCgoRSQL(), param, velParam);

			List<SitProPoStkVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProPoStkVO.class);
			
			if (list != null && list.size() > 0) {
				sitProPoStkVO = (SitProPoStkVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProPoStkVO;
	}
	
	/**
	 * 구주  SIT PRO -  qty 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProBkgQtyVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProBkgQtyVO searchBkgQty(SitproEdiVO sitproEdiVO) throws DAOException {
		
		SitProBkgQtyVO sitProBkgQtyVO = new SitProBkgQtyVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBkgQtyRSQL(), param, velParam);

			List<SitProBkgQtyVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProBkgQtyVO.class);
			
			if (list != null && list.size() > 0) {
				sitProBkgQtyVO = (SitProBkgQtyVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProBkgQtyVO;
	}

	/**
	 * 구주  SIT PRO -  Vessel 정보, Vessel ETA 정보를 조회한다.<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return List<SitProVslEtcInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProVslEtcInfoVO> searchVslEtcInfoVsl(SitproEdiVO sitproEdiVO) throws DAOException {
		
		List<SitProVslEtcInfoVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchVslEtcInfoVslRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProVslEtcInfoVO.class);
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 구주  SIT PRO -  EL Number를 조회한다..<br>
	 * 
	 * @param  SitproEdiVO sitproEdiVO
	 * @return SitProELNumberInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SitProELNumberInfoVO searchELNumberByBkg(SitproEdiVO sitproEdiVO) throws DAOException {
		
		SitProELNumberInfoVO sitProELNumberInfoVO = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sitproEdiVO != null)
			{
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EurCustomsTransmissionDBDAOsearchELNumberByBkgRSQL(), param, velParam);

			List<SitProELNumberInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProELNumberInfoVO.class);
			
			if (list != null && list.size() > 0) {
				sitProELNumberInfoVO = (SitProELNumberInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sitProELNumberInfoVO;
	}
	
	/**
	 * 수신정보 키값(RCV_LOG_SEQ) 조회<br>
	 * 
	 * @param  String msgTpId
	 * @param  String msgRevNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchRcvLogSeq(String msgTpId, String msgRevNo) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if (msgRevNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("msg_tp_id", msgTpId);
				mapVO.put("key_val", msgRevNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchRcvLogSeqRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
	
	/**
	 * 수신데이타 저장 (수신 마스터 테이블)<Br>
	 * 
	 * @param  EurRcvMsgVO eurRcvMsgVO
	 * @throws DAOException
	 */
	public void addAck(EurRcvMsgVO eurRcvMsgVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(eurRcvMsgVO != null) {
	            Map<String, String> mapVO = eurRcvMsgVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddAckCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 *  수신데이타 저장 (수신 Detail)<Br>
	 *  
	 * @param List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAckDtl(List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        EurRcvMsgDtlVO eurRcvMsgDtlVO = null;
        
        int result = 0;
        
        try {
        	for(int i = 0; i < eurRcvMsgDtlVOs.size(); i++) {
        	
        		eurRcvMsgDtlVO = eurRcvMsgDtlVOs.get(i);
	        	if(eurRcvMsgDtlVO != null) {
		            Map<String, String> mapVO = eurRcvMsgDtlVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddAckDtlCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
        	} // end for(i)
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}
	
	
	/**
	 * 대상 BKG_NO 리스트 존재여부를 조회한다.<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchExistVvdPort(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO) throws DAOException {
		
		String retVal = "N";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sitProCargoManifestCondForEdiVO != null) {
				Map<String, String> mapVO = sitProCargoManifestCondForEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate)new EurCustomsTransmissionDBDAOsearchExistVvdPortRSQL(), param, velParam);
			
			if(dbRowset.getRowCount() > 0) {
				//if (dbRowset.next()) {
					retVal = "Y";
				//}
			} 
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}
	
	/**
	 * 구주 SIT PRO프로그램에서 ENS Download 메서드로 사용함<br>
	 * 
	 * @param SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO
	 * @param String[] bkgNos
	 * @return List<SitProENSDownExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProENSDownExcelVO> searchENSDownExcel(SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO,String[] bkgNos) throws DAOException {
		List<SitProENSDownExcelVO> list = null;
		Map<String, Object> param = null;
		Map<String, Object> velParam = null;
		Map<String, String> mapVO = null;
		try {
			if (null != sitProCargoManifestCondForEdiVO) {
				param = new HashMap<String, Object>();
				velParam = new HashMap<String, Object>();
				mapVO = sitProCargoManifestCondForEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("bkg_nos", bkgNos);
				velParam.put("bkg_nos", bkgNos);
				list = (List)RowSetUtil.rowSetToVOs(new SQLExecuter("").executeQuery((ISQLTemplate)new EurCustomsTransmissionDBDAOsearchENSDownExcelRSQL(), param, velParam),SitProENSDownExcelVO.class);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	
	/**
	 * 2011.08.23 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - 세부 고객정보 추가 (ENS구조참조)
	 * 구주 24시 BL 고객 정보 조회<br>
	 * 
	 * @param String blNo 
	 * @param String vslCd 
	 * @param String skdVoyNo
	 * @param String skdDirCd 
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCustListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCustListVO>  searchBlCust ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd)throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCustListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			param.put("bl_no", blNo);
			param.put("vsl_cd", vslCd);
			param.put("skd_voy_no", skdVoyNo);
			param.put("skd_dir_cd", skdDirCd);
			param.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBlCustRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCustListVO.class);
		}
		catch (SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 수신데이타 저장 (수신 마스터 테이블)<Br>
	 * Customs Reference# I/F from Local System to ALPS (스페인, 포르투갈)<br>
	 * 
	 * @param  List<EurCrnRcvMsgVO> eurCrnRcvMsgDetailVOs
	 * @param  String msgFlag
	 * @throws DAOException
	 */
	public void addEurCrnAck(List<EurCrnRcvMsgVO> eurCrnRcvMsgDetailVOs, String msgFlag)  {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    	
		SQLExecuter sqlExe = new SQLExecuter("");
		int result = 0;
		int cnt[] = null;
		int voSize =0;
		EurCrnRcvMsgVO eurCrnRcvMsgVO = null;
		
		try {
			voSize = eurCrnRcvMsgDetailVOs.size();
		} catch(Exception e) {
			log.error("[EUR-SPAIN-CRN_RCV-]" +  e.getMessage());
		}
		
		if (voSize > 0) {
			
			/*
			 * 수신된 CRN 정보를 등록한다.
			 */
			
			for(int i = 0; i < voSize; i++) {
				
				
				try {
					eurCrnRcvMsgVO = eurCrnRcvMsgDetailVOs.get(i);
		        	if(eurCrnRcvMsgVO != null) {
			            Map<String, String> mapVO = eurCrnRcvMsgVO.getColumnValues();
			            
			            param.putAll(mapVO);
			            velParam.putAll(mapVO);
		        	}
					
		            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new EurCustomsTransmissionDBDAOaddEurCrnAckCSQL(), param, velParam);

		            if(result == Statement.EXECUTE_FAILED) {
		           		log.error("[EUR-SPAIN-CRN_RCV (his 생성)] Fail to insert No" + i + " SQL :" + eurCrnRcvMsgVO.getBlNo());
		            }

				
					/*
					 * 수신된 msg status에 따라 
					 * 최종 사용될 status : F(Fixed) 형태의 데이타를 생성한다.
					 */
					eurCrnRcvMsgVO.setMsgFuncId("F");
					
					if("N".equals(msgFlag) || "A".equals(msgFlag) || "U".equals(msgFlag)) {
						
				        	if(eurCrnRcvMsgVO != null) {
				        		
				        		if("N".equals(msgFlag)) {
				        			eurCrnRcvMsgVO.setUpdUsrId("N");
				        		} else if("A".equals(msgFlag)) {
				        			eurCrnRcvMsgVO.setUpdUsrId("A");
				        		} else {
				        			eurCrnRcvMsgVO.setUpdUsrId("U");
				        		}
				        		
					            Map<String, String> mapVO = eurCrnRcvMsgVO.getColumnValues();
					            
					            param.putAll(mapVO);
					            velParam.putAll(mapVO);
				        	}
								// MSG_FUNC_ID = 'F' 로 신규 INSERT / UPDATE 한다.
					            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new EurCustomsTransmissionDBDAOaddEurCrnAckCSQL(), param, velParam);
	
					            if(result == Statement.EXECUTE_FAILED) {
					           		log.error("[EUR-SPAIN-CRN_RCV-F(Fixed) 형태의 데이타를 생성 (N, A, U)] Fail to insert No" + i + " SQL :" + eurCrnRcvMsgVO.getBlNo());
					            }
								
								
					} else if("D".equals(msgFlag)) {
						// MSG_FUNC_ID = 'F' 이면서 KEY 값에 해당하는 데이타의 값을 DELETE 한다.
						cnt = sqlExe.executeBatch(
								(ISQLTemplate) new EurCustomsTransmissionDBDAOdeleteEurCrnAckDSQL(), eurCrnRcvMsgDetailVOs, null);
						for (int j = 0; j < cnt.length; j++) {
							if (cnt[j] == Statement.EXECUTE_FAILED) {
								log.error("[EUR-SPAIN-CRN_RCV-F(Fixed) 형태의 데이타를 생성 (D)] Fail to insert No" + j + " SQL :" + eurCrnRcvMsgDetailVOs.get(j).getBlNo());
							}
						}
						
					}
				} catch(Exception e) {
					log.error("[EUR-SPAIN-CRN_RCV-] [" + i + "] => " + eurCrnRcvMsgVO.getBlNo());
				}
				
			} // end for(i)
		
		}


	}
	
	
	/**
	 * 2011.11.15 김보배 [CHM-201114279] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
	 * EU 세관 전송을 위한 VVD 와 POD 별 B/L 내역 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchEurManifestList(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EurCustomsTransmissionDBDAOsearchEurManifestListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EurManifestListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * 구주 SIT PRO - 해당 B/L 의 모든 Seal No 를 조회한다.<br>
	 * 
	 * @param SitproEdiVO sitproEdiVO
	 * @return List<SitProCntrSealListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SitProCntrSealListVO> searchCntrSealNo(SitproEdiVO sitproEdiVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SitProCntrSealListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sitproEdiVO != null){
				Map<String, String> mapVO = sitproEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EurCustomsTransmissionDBDAOSearchSitProCntrSealNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SitProCntrSealListVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Send log 등록
	 * 
	 * @param snd
	 * @param sndLog
	 * @param rspnList
	 * @throws DAOException
	 */
	public void addSndLog(BkgCstmsEurDgSndVO snd, List<BkgCstmsEurDgSndLogVO> sndLog, List<BkgCstmsEurDgEdiRspnVO> rspnList) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {

			if (snd != null) {
				Map<String, String> mapVO = snd.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new EurCustomsTransmissionDBDAOaddBkgCstmsEurDgSndCSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException(new ErrorHandler("BKG06088", new String[] {}).getMessage());
				}
			}

			if (sndLog != null && sndLog.size() > 0) {
				
				int result[] = new SQLExecuter("").executeBatch((ISQLTemplate) new EurCustomsTransmissionDBDAOaddBkgCstmsEurDgSndLogCSQL(), sndLog, null);
				for (int i = 0; i < result.length; i++) {
					if (result[i] == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("BKG06088", new String[] {}).getMessage());
				}
			}

			if (rspnList != null && rspnList.size() > 0) {
				
				int result[] = new SQLExecuter("").executeBatch((ISQLTemplate) new EurCustomsTransmissionDBDAOaddBkgCstmsEurDgEdiRspnCSQL(), rspnList, null);
				for (int i = 0; i < result.length; i++) {
					if (result[i] == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("BKG06088", new String[] {}).getMessage());
				}
			}
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * BL LDF 다운로드 시 로그등록<Br>
	 * @param bkgCstmsBlLodFctrLogVOs List<BkgCstmsBlLodFctrLogVO>
	 * @throws DAOException
	 */
	public void addBkgCstmsBlLodFctrLog(List<BkgCstmsBlLodFctrLogVO> bkgCstmsBlLodFctrLogVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsBlLodFctrLogVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new EurCustomsTransmissionDBDAOaddBkgCstmsBlLodFctrLogCSQL(), bkgCstmsBlLodFctrLogVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SitPro BL LDF 다운로드 후 수정된 BL 조회<br>
	 * 
	 * @return List<EurManifestTransmitVO>
	 * @throws DAOException
	 */
	public List<EurManifestTransmitVO> searchBlLdfBatch() throws DAOException {
		List<EurManifestTransmitVO> list = null;
		
		try {
			
			list = (List) RowSetUtil.rowSetToVOs(new SQLExecuter("").executeQuery((ISQLTemplate) new EurCustomsTransmissionDBDAOsearchBlLdfBatchRSQL(), null, null), EurManifestTransmitVO.class);
		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}

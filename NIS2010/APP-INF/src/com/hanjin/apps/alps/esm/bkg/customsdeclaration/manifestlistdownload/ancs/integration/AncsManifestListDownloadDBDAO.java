/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AncsManifestListDownloadDBDAO.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.04.29 정재엽
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.10.24 김보배 [CHM-201114022] [BKG] ANCS > BL inquiry< Download 버튼 제거
 * 2012.07.19 김보배 [CHM-201219043] [BKG] [ANCS] B/L inquiry - 복수의 Row ADD시 에러 수정
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic.AncsManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsAnrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCmdtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsEdiHisInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtl2VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdDtlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.BkgCstmsNtfyAddrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.BkgCstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsAnrBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCmdtVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrNtfyVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrVvdVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * NIS2010 AncsManifestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeong Jay Yoeb
 * @see AncsManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class AncsManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * 벨기에 세관 신고 대상 VVD 목록 조회 <br>
	 * 
	 * 1. VVD 가 입력된 경우 SSR No 및 ETA 조회 됨 <br>
	 * 2. SSR No가 입력 된 경우 VVD 및 ETA 조회 됨 <br>
	 * 
	 * @param AncsCstmsVvdListCondVO ancsCstmsVvdListCondVO
	 * @return List<CstmsVvdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsVvdVO> searchAncsCstmsVvdList(
			AncsCstmsVvdListCondVO ancsCstmsVvdListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsVvdVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsVvdListCondVO != null) {
				Map<String, String> mapVO = ancsCstmsVvdListCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsVvdListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AncsManifestModificationVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD 의 인자로 ANCS 세관 조회 <br>
	 * 
	 * VVD별 Port Pair (POL-POD) 구간 별 B/L 개수와 ANCS 세관용 B/L 개수 비교 <br>
	 * 
	 * @param AncsCstmsVvdDtlListCondVO ancsCstmsVvdDtlListCondVO
	 * @return List<CstmsVvdDtlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsVvdDtlVO> searchAncsCstmsVvdDtlList(
			AncsCstmsVvdDtlListCondVO ancsCstmsVvdDtlListCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsVvdDtlVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsVvdDtlListCondVO != null) {
				Map<String, String> mapVO = ancsCstmsVvdDtlListCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsVvdDtlListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AncsCstmsVvdDtlListVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VVD에 SSR No가 입력되었는지 확인 <br>
	 * - NO DATA FOUND이거나 조회 된 SSR NO의 길이가 = 0인 경우 FALSE <br>
	 *   RETURN 그 외는 TRUE RETURN <br>
	 * 
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkIfSsrNoExist(String vslCd, String skdVoyNo,
			String skdDirCd) throws DAOException {

		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String sSsrNo = "";
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOcheckIfSsrNoExistRSQL(),
							param, velParam);

			if (dbRowset.next()) {
				sSsrNo = dbRowset.getString(1);
			} else {
				sSsrNo = "";
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sSsrNo;
	}

	/**
	 * BL 정보를 읽어 바로 벨기에 세관 용 BL 정보 생성
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void addSelectBkgCstmsAnrBl(
			AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();


			if ("blno".equals(sDaoGbn)) {
				String sBkgNo = ancsCstmsModiVO.getBkgNo();
				if (!sBkgNo.equals("") || sBkgNo != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();
					
//					Map<String, String> mapVO = new HashMap<String, String>();
//					mapVO.put("bkg_no", sBkgNo);
//					mapVO.put("snd_usr_id", ancsCstmsModiVO.getSndUsrId());
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBl2CSQL(),
									param, velParam);

				}

			} else {

				String vvd = ancsCstmsModiVO.getVvd();
//				String vslCd = vvd.substring(0, 4);
//				String skdVoyNo = vvd.substring(4, 8);
//				String skdDirCd = vvd.substring(8, 9);

				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();

//					Map<String, String> mapVO = new HashMap<String, String>();
//					mapVO.put("vsl_cd", vslCd);
//					mapVO.put("skd_voy_no", skdVoyNo);
//					mapVO.put("skd_dir_cd", skdDirCd);
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());
//					mapVO.put("ssr_no", ancsCstmsModiVO.getSsrNo());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrBlCSQL(),
									param, velParam);

				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 벨기에 세관 용 BL 정보 제거
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void deleteSelectBkgCstmsAnrBl(AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (!"blno".equals(sDaoGbn)) {
				String vvd = ancsCstmsModiVO.getVvd();
				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("").executeUpdate((ISQLTemplate) new AncsManifestListDownloadDBDAOremoveBkgCstmsAnrBlDSQL(),	param, velParam);
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 신고용 B/L별 Notify Address 정보 생성
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void addSelectBkgCstmsAnrNtfy(
			AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if ("blno".equals(sDaoGbn)) {
				String sBkgNo = ancsCstmsModiVO.getBkgNo();
				if (!sBkgNo.equals("") || sBkgNo != null) {
					
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();
//					Map<String, String> mapVO = new HashMap<String, String>();
//					mapVO.put("bkg_no", sBkgNo);
//					mapVO.put("snd_usr_id", ancsCstmsModiVO.getSndUsrId());
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrNtfy2CSQL(),
									param, velParam);

				}
			} else {

				String vvd = ancsCstmsModiVO.getVvd();
//				String vslCd = vvd.substring(0, 4);
//				String skdVoyNo = vvd.substring(4, 8);
//				String skdDirCd = vvd.substring(8, 9);

				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();
//					Map<String, String> mapVO = new HashMap<String, String>();
//					mapVO.put("vsl_cd", vslCd);
//					mapVO.put("skd_voy_no", skdVoyNo);
//					mapVO.put("skd_dir_cd", skdDirCd);
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrNtfyCSQL(),
									param, velParam);

				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 벨기에 세관 신고용 B/L별 Notify Address 정보 제거
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void deleteSelectBkgCstmsAnrNtfy(AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (!"blno".equals(sDaoGbn)) {
				String vvd = ancsCstmsModiVO.getVvd();
				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("").executeUpdate((ISQLTemplate) new AncsManifestListDownloadDBDAOremoveBkgCstmsAnrNtfyDSQL(),	param, velParam);
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL 정보를 읽어 바로 벨기에 세관 용 Container 정보 생성
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void addSelectBkgCstmsAnrCntr(
			AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if ("blno".equals(sDaoGbn)) {
				String sBkgNo = ancsCstmsModiVO.getBkgNo();
				if (!sBkgNo.equals("") || sBkgNo != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();
//					Map<String, String> mapVO = new HashMap<String, String>();
//					mapVO.put("bkg_no", sBkgNo);
//					mapVO.put("snd_usr_id", ancsCstmsModiVO.getSndUsrId());
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCnrt2CSQL(),
									param, velParam);

				}
			} else {

				String vvd = ancsCstmsModiVO.getVvd();
//				String pol = ancsCstmsModiVO.getPol();
//				String vslCd = vvd.substring(0, 4);
//				String skdVoyNo = vvd.substring(4, 8);
//				String skdDirCd = vvd.substring(8, 9);

				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();
//					Map<String, String> mapVO = new HashMap<String, String>();
					
//					mapVO.put("vsl_cd", vslCd);
//					mapVO.put("skd_voy_no", skdVoyNo);
//					mapVO.put("skd_dir_cd", skdDirCd);
//					mapVO.put("pol_cd", pol);
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);
					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCntrCSQL(),
									param, velParam);

				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 벨기에 세관 용 Container 정보 제거
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void deleteSelectBkgCstmsAnrCntr(AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (!"blno".equals(sDaoGbn)) {
				String vvd = ancsCstmsModiVO.getVvd();
				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("").executeUpdate((ISQLTemplate) new AncsManifestListDownloadDBDAOremoveBkgCstmsAnrCntrDSQL(),	param, velParam);
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BL 정보를 읽어 바로 벨기에 세관 용 C/M(Container Manifest) 정보 생성
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void addSelectBkgCstmsAnrCmdt(
			AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {

			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if ("blno".equals(sDaoGbn)) {
				String sBkgNo = ancsCstmsModiVO.getBkgNo();
				if (!sBkgNo.equals("") || sBkgNo != null) {
					Map<String, String> mapVO = new HashMap<String, String>();
					mapVO.put("bkg_no", sBkgNo);
					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCmdt2CSQL(),
									param, velParam);

				}
			} else {

				String vvd = ancsCstmsModiVO.getVvd();
//				String pol = ancsCstmsModiVO.getPol();
//
//				String vslCd = vvd.substring(0, 4);
//				String skdVoyNo = vvd.substring(4, 8);
//				String skdDirCd = vvd.substring(8, 9);

				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();
//					Map<String, String> mapVO = new HashMap<String, String>();
//					mapVO.put("vsl_cd", vslCd);
//					mapVO.put("skd_voy_no", skdVoyNo);
//					mapVO.put("skd_dir_cd", skdDirCd);
//					mapVO.put("pol_cd", pol);
//					mapVO.put("cre_usr_id", ancsCstmsModiVO.getCreUsrId());
//					mapVO.put("upd_usr_id", ancsCstmsModiVO.getUpdUsrId());
//					mapVO.put("cre_ofc_cd", ancsCstmsModiVO.getCreOfcCd());
//					mapVO.put("upd_ofc_cd", ancsCstmsModiVO.getUpdOfcCd());

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOaddSelectBkgCstmsAnrCmdtCSQL(),
									param, velParam);

				}
			}

		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 벨기에 세관 용 C/M(Container Manifest) 정보 제거
	 * 
	 * @param AncsManifestModificationVO ancsCstmsModiVO
	 * @throws DAOException
	 */
	public void deleteSelectBkgCstmsAnrCmdt(AncsManifestModificationVO ancsCstmsModiVO) throws DAOException {
		try {
			String sDaoGbn = ancsCstmsModiVO.getDaoGbn();

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (!"blno".equals(sDaoGbn)) {
				String vvd = ancsCstmsModiVO.getVvd();
				if (!vvd.equals("") || vvd != null) {
					Map<String, String> mapVO = ancsCstmsModiVO.getColumnValues();

					velParam.putAll(mapVO);
					param.putAll(mapVO);

					
					new SQLExecuter("").executeUpdate((ISQLTemplate) new AncsManifestListDownloadDBDAOremoveBkgCstmsAnrCmdt2DSQL(),	param, velParam);
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 입항 신고를 위한 VVD 별 입항 정보 조회
	 * 
	 * @param AncsCstmsVesselArrivalCondVO ancsCstmsVesselArrivalCondVO
	 * @return List<AncsCstmsVesselArrivalVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsVesselArrivalVO> searchAncsCstmsVesselArrival(
			AncsCstmsVesselArrivalCondVO ancsCstmsVesselArrivalCondVO)
			throws DAOException {

		DBRowSet dbRowset = null;
		List<AncsCstmsVesselArrivalVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsVesselArrivalCondVO != null) {
				Map<String, String> mapVO = ancsCstmsVesselArrivalCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsVesselArrivalRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AncsCstmsVesselArrivalVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 벨기에 세관 신고를 위한 VVD별 정보 업데이트
	 * 
	 * @param List<BkgCstmsAnrVvdVO> bkgCstmsAnrVvdVO
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrVvd(List<BkgCstmsAnrVvdVO> bkgCstmsAnrVvdVO)
			throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrVvdVO.size() > 0) {
				BkgCstmsAnrVvdVO bkgCstmsAnrVvdVO2 = bkgCstmsAnrVvdVO.get(0);
				if ("Y".equals(bkgCstmsAnrVvdVO2.getRcv())) {
					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, Object> velParam = new HashMap<String, Object>();

					Map<String, String> mapVO = bkgCstmsAnrVvdVO2
							.getColumnValues();
					velParam.putAll(mapVO);
					param.putAll(mapVO);

					new SQLExecuter("")
							.executeUpdate(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdUSQL(),
									param, velParam);

				} else {
					updCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdCSQL(),
									bkgCstmsAnrVvdVO, null);
					for (int i = 0; i < updCnt.length; i++) {
						if (updCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modify No" + i
									+ " SQL");
					}
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 신고를 위한 VVD별 정보 업데이트
	 * 
	 * @param BkgCstmsAnrVvdVO bkgCstmsAnrVvdVO
	 * @throws DAOException
	 */
	public void modifyBkgCstmsAnrVvd(BkgCstmsAnrVvdVO bkgCstmsAnrVvdVO)
			throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = bkgCstmsAnrVvdVO.getColumnValues();
			velParam.putAll(mapVO);
			param.putAll(mapVO);

			new SQLExecuter("")
					.executeUpdate(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrVvdUSQL(),
							param, velParam);

		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ANCS 세관 신고용 VVD 정보 조회
	 * 
	 * @param AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO
	 * @return List<CstmsVvdInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsVvdInfoVO> searchAncsCstmsVvdInfo(
			AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsVvdInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsVvdInfoCondVO != null) {
				Map<String, String> mapVO = ancsCstmsVvdInfoCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsVvdInfoRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AncsCstmsVvdInfoVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ANCS 세관 신고용 VVD 정보 조회
	 * 
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHrdCdgCtntVO> searchAncsLane() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;

		
		try {
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAnceLaneRSQL(),
							null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgHrdCdgCtntVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * VVD,Port 등 입력 후 ANCS 세관 신고 대상 List를 조회한다.
	 * 
	 * @param AncsCstmsMfListCondVO ancsCstmsMfListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchAncsCstmsMfList(
			AncsCstmsMfListCondVO ancsCstmsMfListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsMfListCondVO != null) {
				Map<String, String> mapVO = ancsCstmsMfListCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsMfListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AncsCstmsMfVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 세관 적하 목록 상세 정보를 조회
	 * 
	 * @param AncsCstmsMfDtlCondVO ancsCstmsMfDtlCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchAncsCstmsMfDtlList(
			AncsCstmsMfDtlCondVO ancsCstmsMfDtlCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsMfDtlCondVO != null) {
				Map<String, String> mapVO = ancsCstmsMfDtlCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsMfDtlListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AncsCstmsMfDtl2VO.class);

			String blNo = "";
			int blKnt = 0;
			for (int i = 0; i < list.size(); i++) {
				AncsCstmsMfDtl2VO vo = (AncsCstmsMfDtl2VO) list.get(i);
				if (!blNo.equals(vo.getBlNo())) {
					blNo = vo.getBlNo();
					blKnt++;
				}
				vo.setSeq("" + blKnt);
				vo.setKind("N");
			}

		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 벨기에 세관 신고용 다운로드 받은 B/L 정보를 가져옴
	 * 
	 * @param AncsCstmsBlCondVO ancsCstmsBlCondVO
	 * @return List<AncsCstmsBlInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsBlInfoVO> searchAncsCstmsBl(
			AncsCstmsBlCondVO ancsCstmsBlCondVO) throws DAOException {

		DBRowSet dbRowset0 = null;
		List<AncsCstmsBlInfoVO> ancsCstmsBlVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = null;

			if (ancsCstmsBlCondVO != null) {
				mapVO = ancsCstmsBlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset0 = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsBlRSQL(),
							param, velParam);
			ancsCstmsBlVOs = (List) RowSetUtil.rowSetToVOs(dbRowset0,
					AncsCstmsBlInfoVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ancsCstmsBlVOs;
	}

	/**
	 * 벨기에 세관 신고용 다운로드 받은 CNTR 정보를 가져옴
	 * 
	 * @param AncsCstmsBlCondVO ancsCstmsBlCondVO
	 * @return List<AncsCstmsCntrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsCntrVO> searchAncsCstmsCntr(
			AncsCstmsBlCondVO ancsCstmsBlCondVO) throws DAOException {

		DBRowSet dbRowset0 = null;
		List<AncsCstmsCntrVO> ancsCstmsCntrVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = null;
			if (ancsCstmsBlCondVO != null) {
				mapVO = ancsCstmsBlCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset0 = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsCntrRSQL(),
							param, velParam);
			ancsCstmsCntrVOs = (List) RowSetUtil.rowSetToVOs(dbRowset0,
					AncsCstmsCntrVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ancsCstmsCntrVOs;
	}

	/**
	 * 벨기에 세관 신고용 다운로드 받은 CMDT 정보를 가져옴
	 * 
	 * @param AncsCstmsBlCondVO ancsCstmsBlCondVO
	 * @return List<AncsCstmsCmdtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AncsCstmsCmdtVO> searchAncsCstmsCmdt(
			AncsCstmsBlCondVO ancsCstmsBlCondVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<AncsCstmsCmdtVO> ancsCstmsCmdtVOs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = null;

			if (ancsCstmsBlCondVO != null) {
				mapVO = ancsCstmsBlCondVO.getColumnValues();
				mapVO.put("vvd", ancsCstmsBlCondVO.getVvd());
				mapVO.put("bkg_no", ancsCstmsBlCondVO.getBkgNo());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsCmdtRSQL(),
							param, velParam);
			ancsCstmsCmdtVOs = (List) RowSetUtil.rowSetToVOs(dbRowset,
					AncsCstmsCmdtVO.class);

		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ancsCstmsCmdtVOs;
	}

	/**
	 * 벨기에 세관 B/L별 Notify 정보를 정정
	 * 
	 * @param BkgCstmsAnrNtfyVO bkgCstmsAnrNtfyVO
	 * @throws DAOException
	 */
	public void modifyBkgCstmsRtmNtfyAddr(BkgCstmsAnrNtfyVO bkgCstmsAnrNtfyVO)
			throws DAOException {
		try {
			String bkgNo = bkgCstmsAnrNtfyVO.getBkgNo();
			String bkgNoSplit = bkgCstmsAnrNtfyVO.getBkgNoSplit();
			String faxNo = bkgCstmsAnrNtfyVO.getFaxNo();
			String ntfyEml = bkgCstmsAnrNtfyVO.getNtfyEml();
			String ntfyNm = bkgCstmsAnrNtfyVO.getNtfyNm();
			String ntfyAddr = bkgCstmsAnrNtfyVO.getNtfyAddr();

			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (!bkgNo.equals("") || bkgNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO = bkgCstmsAnrNtfyVO.getColumnValues();

				mapVO.put("fax_no", faxNo);
				mapVO.put("ntfy_eml", ntfyEml);
				mapVO.put("ntfy_nm", ntfyNm);
				mapVO.put("ntfy_addr", ntfyAddr);
				mapVO.put("bkg_no", bkgNo);
				mapVO.put("bkg_no_split", bkgNoSplit);

				velParam.putAll(mapVO);
				param.putAll(mapVO);

				new SQLExecuter("")
						.executeUpdate(
								(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrNtfyUSQL(),
								param, velParam);
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 B/L 별 CNTR 정보를 정정
	 * 
	 * @param List<BkgCstmsAnrCntrVO> bkgCstmsAnrCntrVOs
	 * @throws DAOException
	 * 
	 */
	public void modifyBkgCstmsAnrCntr(List<BkgCstmsAnrCntrVO> bkgCstmsAnrCntrVOs)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrCntrVOs.size() > 0) {

				// Flat 파일 수신시...
				if ("Y".equals(bkgCstmsAnrCntrVOs.get(0).getRcv())) {
					updCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrCntr2USQL(),
									bkgCstmsAnrCntrVOs, null);
				} else {
					updCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrCntrUSQL(),
									bkgCstmsAnrCntrVOs, null);
				}

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 B/L 마스타 정보를 정정
	 * 
	 * @param List<BkgCstmsAnrBlVO> bkgCstmsAnrBlVOs
	 * @throws DAOException
	 * 
	 */
	public void modifyBkgCstmsAnrBl(List<BkgCstmsAnrBlVO> bkgCstmsAnrBlVOs)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrBlVOs.size() > 0) {
				if (bkgCstmsAnrBlVOs.get(0) instanceof AncsCstmsAnrBlVO) {

					if ("O".equals(((AncsCstmsAnrBlVO) bkgCstmsAnrBlVOs.get(0)).getSndSts())) {
						updCnt = sqlExe
								.executeBatch(
										(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBl2USQL(),
										bkgCstmsAnrBlVOs, null);
					} else if ("C".equals(((AncsCstmsAnrBlVO) bkgCstmsAnrBlVOs.get(0)).getSndSts())) {
						
						/*
						 * 전송 type : Cancel 일 경우 만
						 * Article No 를 max + 1 (ssr단위 max)
						 * 2011.10.7 김보배
						 */
						updCnt = sqlExe
								.executeBatch(
										(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBl3USQL(),
										bkgCstmsAnrBlVOs, null);
					}
				} else {
					updCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrBlUSQL(),
									bkgCstmsAnrBlVOs, null);
				}

				if( updCnt != null) {
					for (int i = 0; i < updCnt.length; i++) {
						if (updCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modify No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Antwerp 세관 신고를 위해 다운로드 받은 BL별 C/M(Container Manfiest)정보를 삭제
	 * 
	 * @param List<BkgCstmsAnrCmdtVO> bkgCstmsAnrCmdtVOs
	 * @throws DAOException
	 * 
	 */
	public void removeBkgCstmsAnrCmdt(List<BkgCstmsAnrCmdtVO> bkgCstmsAnrCmdtVOs)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (bkgCstmsAnrCmdtVOs.size() > 0) {
				delCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new AncsManifestListDownloadDBDAOremoveBkgCstmsAnrCmdtDSQL(),
								bkgCstmsAnrCmdtVOs, null);

			}

			for (int i = 0; i < delCnt.length; i++) {
				if (delCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + i + " SQL");
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 B/L 별 C/M(Container Manifest) 정보를 저장
	 * 
	 * @param List<BkgCstmsAnrCmdtVO> bkgCstmsAnrCmdtVOs
	 * @throws DAOException
	 * 
	 */
	public void addBkgCstmsAnrCmdt(List<BkgCstmsAnrCmdtVO> bkgCstmsAnrCmdtVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
				
			BkgCstmsAnrCmdtVO bkgCstmsAnrCmdtVO = null;

			if (bkgCstmsAnrCmdtVOs.size() > 0) {
				for(int i = 0 ; i < bkgCstmsAnrCmdtVOs.size(); i++) {
				
					bkgCstmsAnrCmdtVO = bkgCstmsAnrCmdtVOs.get(i);
					Map<String, String> mapVO = bkgCstmsAnrCmdtVO.getColumnValues();
				
					param.putAll(mapVO);
					
					insCnt = sqlExe
						.executeUpdate((ISQLTemplate) new AncsManifestListDownloadDBDAOaddBkgCstmsAnrCmdtCSQL(), param, null);
					
					if(insCnt == Statement.EXECUTE_FAILED) {
		           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
		            }
				}
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 벨기에 세관 B/L 별 C/M(Container Manifest) 정보를 수정
	 * 
	 * @param List<BkgCstmsAnrCmdtVO> bkgCstmsAnrCmdtVOs
	 * @throws DAOException
	 * 
	 */
	public void modifyBkgCstmsAnrCmdt(List<BkgCstmsAnrCmdtVO> bkgCstmsAnrCmdtVOs)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bkgCstmsAnrCmdtVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsAnrCmdtUSQL(),
								bkgCstmsAnrCmdtVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}

			for (int i = 0; i < insCnt.length; i++) {
				if (insCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No" + i + " SQL");
			}
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * 벨기에 세관 신고용 B/L별 Notify Address 정보 조회
	 * 
	 * @param BkgCstmsNtfyAddrCondVO bkgCstmsNtfyAddrCondVO
	 * @return List<CstmsNtfyAddrVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsNtfyAddrVO> searchAncsCstmsNtfyAddr(
			BkgCstmsNtfyAddrCondVO bkgCstmsNtfyAddrCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CstmsNtfyAddrVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgCstmsNtfyAddrCondVO != null) {
				Map<String, String> mapVO = bkgCstmsNtfyAddrCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsNtfyAddrRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgCstmsNtfyAddrVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 벨기에 세관 신고용 B/L별 Notify Address 정보 생성
	 * 
	 * @param BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO
	 * @throws DAOException
	 * 
	 */
	public void addBkgCstmsNtfyAddr(BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO ) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCstmsNtfyAddrVO != null) {
				Map<String, String> mapVO = bkgCstmsNtfyAddrVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe
					.executeUpdate(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOaddBkgCstmsNtfyAddrCSQL(),
							param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 신고용 B/L별 Notify Address 정보 정정
	 * 
	 * @param BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO
	 * @throws DAOException
	 * 
	 */
	public void modifyBkgCstmsNtfyAddr(BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCstmsNtfyAddrVO != null) {
				Map<String, String> mapVO = bkgCstmsNtfyAddrVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");

			int insCnt = sqlExe
					.executeUpdate(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyBkgCstmsNtfyAddrUSQL(),
							param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 벨기에 세관 신고용 B/L별 Notify Address 정보 삭제
	 * 
	 * @param BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO
	 * @throws DAOException
	 * 
	 */
	public void removeBkgCstmsNtfyAddr(BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO)
			throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCstmsNtfyAddrVO != null) {
				Map<String, String> mapVO = bkgCstmsNtfyAddrVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe
					.executeUpdate(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOremoveBkgCstmsNtfyAddrDSQL(),
							param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI 이력 정보 조회
	 * 
	 * @param AncsCstmsVvdInfoCondVO ancsCstmsVvdInfoCondVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsAnrEdiHisVO> searchAncsCstmsEdiHisInfo(
			AncsCstmsEdiHisInfoCondVO ancsCstmsVvdInfoCondVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsAnrEdiHisVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ancsCstmsVvdInfoCondVO != null) {
				Map<String, String> mapVO = ancsCstmsVvdInfoCondVO
						.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOsearchAncsCstmsEdiHisRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgCstmsAnrEdiHisVO.class);
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 입력한 PRV Port (=Previous Port)가 유효한지 확인
	 * 
	 * @param AncsCstmsVesselArrivalVO ancsCstmsVesselArrivalVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkIfPrvPortValid(
			AncsCstmsVesselArrivalVO ancsCstmsVesselArrivalVO)
			throws DAOException {
	    boolean boolean1 = false;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ancsCstmsVesselArrivalVO
					.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new AncsManifestListDownloadDBDAOcheckIfPrvPortValidRSQL(),
							param, velParam);

			if (dbRowset.next()) {
				String sIsVslCd = dbRowset.getString(1);
				if (Integer.parseInt(sIsVslCd) == 1)
					boolean1 = true;
			}

			return boolean1;
		} catch (SQLException se) {
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 2011.10.24 김보배 [CHM-201114022] [BKG] ANCS > BL inquiry< Download 버튼 제거
	 * 중복된 Article No 를 기존 Article No 의 Max 값 + 1 로 업데이트
	 * 
	 * @param bkgCstmsAnrVvdVO
	 * @throws DAOException
	 */
	public void modifyAncsCstmsArtNo(List<BkgCstmsAnrVvdVO> bkgCstmsAnrVvdVO) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCstmsAnrVvdVO.size() > 0) {

					updCnt = sqlExe
							.executeBatch(
									(ISQLTemplate) new AncsManifestListDownloadDBDAOmodifyAncsCstmsArtNoUSQL(),
									bkgCstmsAnrVvdVO, null);
			}
			
			if( updCnt != null) {
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
}
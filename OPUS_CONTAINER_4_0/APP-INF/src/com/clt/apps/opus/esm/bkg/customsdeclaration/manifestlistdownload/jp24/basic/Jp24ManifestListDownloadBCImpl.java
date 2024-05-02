/*=========================================================
Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadBCImpl.java
*@FileTitle : Jp24ManifestListDownloadBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpCustomerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.BllSprtCmbnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Jp24ManifestListDownload Business Logic Command implementation<br>
 * - OPUS-Jp24ManifestListDownload handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class Jp24ManifestListDownloadBCImpl extends BasicCommandSupport implements Jp24ManifestListDownloadBC {
	// Database Access Object
	private transient Jp24ManifestListDownloadDBDAO dbDao = null;

	/**
	 * Jp24ManifestListDownloadBCImpl 객체 생성
	 * Jp24ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public Jp24ManifestListDownloadBCImpl() {
		dbDao = new Jp24ManifestListDownloadDBDAO();

	}

	/**
	 * [ESM_BKG_1501]
	 * Advance Cargo Information Download & Transmit - Header 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoHeaderVO>
	 * @exception EventException
	 */
	public List<CargoInfoHeaderVO> searchCargoInfoHeader(CargoInfoHeaderVO cargoInfoHeaderVO) throws EventException {

		try {
			return dbDao.searchCargoInfoHeader(cargoInfoHeaderVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		String result = "";
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			while (rowSet.next()) result = rowSet.getObject("jb_sts_flg").toString();
			return result;
		} catch(BackEndJobException ex) {
			log.error("\n\nBackEndJobException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(SQLException ex) {
			log.error("\n\nSQLException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, SignOnUserAccount account) throws EventException {
		Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob backEndJob = new Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1501 - Retrieve");
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param String backEndJobKey
	 * @return List<CargoInfoDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CargoInfoDetailVO> resultBackEndJobSearchCargoInfoDetail(String backEndJobKey) throws EventException {

		try {
			return(List<CargoInfoDetailVO>) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("\n\nBackEndJobException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501]
	 * VSL_CD로 Call Sing No.를 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getCallSignByVsl(CargoInfoHeaderVO cargoInfoHeaderVO) throws EventException {

		try {
			return dbDao.getCallSignByVsl(cargoInfoHeaderVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobManageCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account) throws EventException {
		Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob backEndJob = new Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
			backEndJob.setCargoInfoDetailVOs(cargoInfoDetailVOs);
			backEndJob.setAccount(account);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1501 - Save");
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManageCargoInfoDetail(String backEndJobKey) throws EventException {

		try {
			return(String) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpBlVO>
	 * @exception EventException
	 */
	public List<AdvJpBlVO> searchBLInquiry(AdvJpBlVO advJpBlVO) throws EventException {

		try {
			return dbDao.searchBLInquiry(advJpBlVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 의 Tab2에 해당하는 Container목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpContainerVO>
	 * @exception EventException
	 */
	public List<AdvJpContainerVO> searchBLInquiryContainer(AdvJpBlVO advJpBlVO) throws EventException {

		try {
			return dbDao.searchBLInquiryContainer(advJpBlVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 의 Tab3에 해당하는 Mark & Desc목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpMarkDescVO>
	 * @exception EventException
	 */
	public List<AdvJpMarkDescVO> searchBLInquiryMarkDesc(AdvJpBlVO advJpBlVO) throws EventException {

		try {
			return dbDao.searchBLInquiryMarkDesc(advJpBlVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * Customer입력창에서 버튼클릭 시 MDM_CUSTOMER 정보 조회<br>
	 *
	 * @param GetMdmCustomerVO getMdmCustomerVO
	 * @return List<GetMdmCustomerVO>
	 * @exception EventException
	 */
	public List<GetMdmCustomerVO> getMdmCustomer(GetMdmCustomerVO getMdmCustomerVO) throws EventException {

		try {
			List<GetMdmCustomerVO> list = dbDao.getMdmCustomer(getMdmCustomerVO);
			if (list.size() > 0) {
				// FINC_STS_LVL_CD = Y
				if ("Y".equals(list.get(0).getFincStsLvlCd())) {
					throw new EventException(new ErrorHandler("BKG00354", new String[] {getMdmCustomerVO.getCustCntCd(), getMdmCustomerVO.getCustLglEngNm() }).getMessage());
				}
				// DELT_FLG = Y
				if ("Y".equals(list.get(0).getDeltFlg())) {
					throw new EventException(new ErrorHandler("BKG00354", new String[] {getMdmCustomerVO.getCustCntCd(), getMdmCustomerVO.getCustLglEngNm() }).getMessage());
				}
			} else {
				throw new EventException(new ErrorHandler("BKG00458").getMessage());
			}
			return list;
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 저장<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param AdvJpContainerVO[] advJpContainerVOs
	 * @param AdvJpMarkDescVO[] advJpMarkDescVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBLInquiry(AdvJpBlVO advJpBlVO, AdvJpContainerVO[] advJpContainerVOs, AdvJpMarkDescVO[] advJpMarkDescVOs, SignOnUserAccount account) throws EventException {
		AdvJpCustomerVO advJpCustomerVO = null;
		List<AdvJpCustomerVO> insertAdvJpCustomerVOList = new ArrayList<AdvJpCustomerVO>();
		List<AdvJpContainerVO> insertAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();
		List<AdvJpContainerVO> updateAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();
		List<AdvJpContainerVO> deleteAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();
		List<AdvJpMarkDescVO> updateAdvJpMarkDescVOList = new ArrayList<AdvJpMarkDescVO>();

		try {
			// B/L Inquiry의 HTML Oblect Value 저장
			if (advJpBlVO != null && "Y".equals(advJpBlVO.getOnchangeFlag())) {
				advJpBlVO.setUsrId(account.getUsr_id());
				dbDao.modifyBLInquiry(advJpBlVO);
				// Shpper 정보
				advJpCustomerVO = new AdvJpCustomerVO();
				advJpCustomerVO.setBlNo(advJpBlVO.getBlNo());
				advJpCustomerVO.setBlSplitNo(advJpBlVO.getBlSplitNo());
				advJpCustomerVO.setBkgCustTpCd("S");
				advJpCustomerVO.setCustCntCd(advJpBlVO.getShprCntCd());
				advJpCustomerVO.setCustSeq(advJpBlVO.getShprSeq());
				advJpCustomerVO.setPhnNo(advJpBlVO.getShprPhnNo());
				advJpCustomerVO.setFaxNo(advJpBlVO.getShprFaxNo());
				advJpCustomerVO.setCustNm(advJpBlVO.getShprNm());
				advJpCustomerVO.setCustAddr(advJpBlVO.getShprAddr());
				advJpCustomerVO.setUsrId(advJpBlVO.getUsrId());
				insertAdvJpCustomerVOList.add(advJpCustomerVO);
				// Cnee 정보
				advJpCustomerVO = new AdvJpCustomerVO();
				advJpCustomerVO.setBlNo(advJpBlVO.getBlNo());
				advJpCustomerVO.setBlSplitNo(advJpBlVO.getBlSplitNo());
				advJpCustomerVO.setBkgCustTpCd("C");
				advJpCustomerVO.setCustCntCd(advJpBlVO.getCneeCntCd());
				advJpCustomerVO.setCustSeq(advJpBlVO.getCneeSeq());
				advJpCustomerVO.setPhnNo(advJpBlVO.getCneePhnNo());
				advJpCustomerVO.setFaxNo(advJpBlVO.getCneeFaxNo());
				advJpCustomerVO.setCustNm(advJpBlVO.getCneeNm());
				advJpCustomerVO.setCustAddr(advJpBlVO.getCneeAddr());
				advJpCustomerVO.setUsrId(advJpBlVO.getUsrId());
				insertAdvJpCustomerVOList.add(advJpCustomerVO);
				// Notofy 정보
				advJpCustomerVO = new AdvJpCustomerVO();
				advJpCustomerVO.setBlNo(advJpBlVO.getBlNo());
				advJpCustomerVO.setBlSplitNo(advJpBlVO.getBlSplitNo());
				advJpCustomerVO.setBkgCustTpCd("N");
				advJpCustomerVO.setCustCntCd(advJpBlVO.getNtfyCntCd());
				advJpCustomerVO.setCustSeq(advJpBlVO.getNtfySeq());
				advJpCustomerVO.setPhnNo(advJpBlVO.getNtfyPhnNo());
				advJpCustomerVO.setFaxNo(advJpBlVO.getNtfyFaxNo());
				advJpCustomerVO.setCustNm(advJpBlVO.getNtfyNm());
				advJpCustomerVO.setCustAddr(advJpBlVO.getNtfyAddr());
				advJpCustomerVO.setUsrId(advJpBlVO.getUsrId());
				insertAdvJpCustomerVOList.add(advJpCustomerVO);

				dbDao.modifyBLInquiryCustomer(insertAdvJpCustomerVOList);
			}

			// B/L Inquiry의 2번째 Tab의 Container 목록 저장
			if (advJpContainerVOs != null) {
				for(AdvJpContainerVO advJpContainerVO : advJpContainerVOs) {
					if ("I".equals(advJpContainerVO.getIbflag())) {
						advJpContainerVO.setUsrId(account.getUsr_id());
						insertAdvJpContainerVOList.add(advJpContainerVO);
					} else if ("U".equals(advJpContainerVO.getIbflag())) {
						advJpContainerVO.setUsrId(account.getUsr_id());
						updateAdvJpContainerVOList.add(advJpContainerVO);
					} else if ("D".equals(advJpContainerVO.getIbflag())) {
						deleteAdvJpContainerVOList.add(advJpContainerVO);
					}
				}
				if (insertAdvJpContainerVOList.size() > 0) dbDao.addAdvJpContainer(insertAdvJpContainerVOList);
				if (updateAdvJpContainerVOList.size() > 0) dbDao.modifyBLInquiryContainer(updateAdvJpContainerVOList);
				if (deleteAdvJpContainerVOList.size() > 0) dbDao.removeBLInquiryContainer(deleteAdvJpContainerVOList);
			}

			// B/L Inquiry의 3번째 Tab의 Mark & Desc 목록
			if (advJpMarkDescVOs != null) {
				for(AdvJpMarkDescVO advJpMarkDescVO : advJpMarkDescVOs) {
					if ("U".equals(advJpMarkDescVO.getIbflag())) {
						advJpMarkDescVO.setUsrId(account.getUsr_id());
						updateAdvJpMarkDescVOList.add(advJpMarkDescVO);
					}
				}
				if (updateAdvJpMarkDescVOList.size() > 0) dbDao.modifyBLInquiryMarkDesc(updateAdvJpMarkDescVOList);
			}
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - Original B/L 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception EventException
	 */
	public List<BllSprtCmbnVO> searchOrgBlForBll(BllSprtCmbnVO bllSprtCmbnVO) throws EventException {

		try {
			return dbDao.searchOrgBlForBll(bllSprtCmbnVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 목록 조회
	 *
	 * @param String bllSndStsCd
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception EventException
	 */
	public List<BllSprtCmbnVO> searchNewBlForBll(String bllSndStsCd, BllSprtCmbnVO bllSprtCmbnVO) throws EventException {
		List<BllSprtCmbnVO> bllSprtCmbnVOList = new ArrayList<BllSprtCmbnVO>();

		try {
			if ("".equals(bllSndStsCd)) {
				bllSprtCmbnVOList = dbDao.searchNewBlForBllByNonSent(bllSprtCmbnVO);
			} else {
				bllSprtCmbnVOList = dbDao.searchNewBlForBllBySent(bllSprtCmbnVO);
			}
			return bllSprtCmbnVOList;
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 단건 조회
	 *
	 * @param BllSprtCmbnVO bllSprtCmbnVO
	 * @return List<BllSprtCmbnVO>
	 * @exception EventException
	 */
	public List<BllSprtCmbnVO> searchNewBlForBllRowSearch(BllSprtCmbnVO bllSprtCmbnVO) throws EventException {

		try {
			return dbDao.searchNewBlForBllRowSearch(bllSprtCmbnVO);
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1526]
	 * Association B/L Separate - New B/L 목록 저장<br>
	 *
	 * @param BllSprtCmbnVO[] bllSprtCmbnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBllSeparate(BllSprtCmbnVO[] bllSprtCmbnVOs, SignOnUserAccount account) throws EventException {
		List<BllSprtCmbnVO> bllSprtCmbnVOList = new ArrayList<BllSprtCmbnVO>();

		try {
			if (bllSprtCmbnVOs != null) {
				dbDao.removeAdvJpBlRlt(bllSprtCmbnVOs[0]);

				for (BllSprtCmbnVO bllSprtCmbnVO : bllSprtCmbnVOs) {
					if (!"D".equals(bllSprtCmbnVO.getIbflag())) {
						bllSprtCmbnVO.setUsrId(account.getUsr_id());
						bllSprtCmbnVOList.add(bllSprtCmbnVO);
					}
				}

				if (bllSprtCmbnVOList.size() > 0) {
					dbDao.removeAdvJpBlRlt(bllSprtCmbnVOList.get(0));
					dbDao.addAdvJpBlRlt(bllSprtCmbnVOList);
				}
			}
		} catch(DAOException ex) {
			log.error("\n\nDAOException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\nException ex : " + new ErrorHandler(ex).getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


}

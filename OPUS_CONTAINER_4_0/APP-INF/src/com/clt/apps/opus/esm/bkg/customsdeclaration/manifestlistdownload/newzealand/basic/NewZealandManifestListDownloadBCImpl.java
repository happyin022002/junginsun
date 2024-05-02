/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandManifestListDownloadBCImpl.java
*@FileTitle : NewZealandManifestListDownloadBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration.NewZealandManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdRefNoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdRefNoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsCndVslVO;


/**
 * OPUS-NewZealandManifestListDownload Business Logic Command implementation<br>
 * - OPUS-NewZealandManifestListDownload handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class NewZealandManifestListDownloadBCImpl extends BasicCommandSupport implements NewZealandManifestListDownloadBC {

	// Database Access Object
	private transient NewZealandManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl 객체 생성<br>
	 * ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public NewZealandManifestListDownloadBCImpl() {
		dbDao = new NewZealandManifestListDownloadDBDAO();
	}

	/**
	 * NewZealand 세관 신고용 VVD 정보 조회
	 *
	 * @param NewZealandCstmsVvdInfoCondVO manifestListCondVO
	 * @return List<NewZealandCstmsVvdInfoCondVO>
	 * @throws EventException
	 */
	public List<NewZealandCstmsVvdInfoCondVO> searchCstmsVvdInfo(NewZealandCstmsVvdInfoCondVO manifestListCondVO) throws EventException {
		try {
			return dbDao.searchCstmsVvdInfo(manifestListCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 *
	 * @param NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO
	 * @return List<NewZealandCstmsMfVO>
	 * @throws EventException
	 */
	public List<NewZealandCstmsMfVO> searchManifestList(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) throws EventException {
		try {
			return dbDao.searchCstmsMfList(newZealandCstmsMfDtlCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  세관 적하 목록 상세 정보를 조회
	 *
	 * @param NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO
	 * @return List<NewZealandCstmsMfDtl2VO>
	 * @exception EventException
	 */
	public List<NewZealandCstmsMfDtl2VO> searchCstmsMfDtlList(NewZealandCstmsMfDtlCondVO newZealandCstmsMfDtlCondVO) throws EventException {
		try {
			return dbDao.searchCstmsMfDtlList(newZealandCstmsMfDtlCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 관련 VVD 정보 생성, 수정, 삭제
	 *
	 * @param NewZealandCstmsVvdInfoVO[] cstmsVvdInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsVvdInfo(NewZealandCstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<BkgCstmsCndVslVO> addVoList = new ArrayList<BkgCstmsCndVslVO>();
			for (int i = 0; i < cstmsVvdInfoVOs.length; i++) {
				List<BkgCstmsCndVslVO> chkVoList = new ArrayList<BkgCstmsCndVslVO>();
				BkgCstmsCndVslVO vslVO = new BkgCstmsCndVslVO();
				vslVO.setIbflag("0013");
				vslVO.setVslCd(cstmsVvdInfoVOs[i].getVslCd());
				vslVO.setSkdVoyNo(cstmsVvdInfoVOs[i].getSkdVoyNo());
				vslVO.setSkdDirCd(cstmsVvdInfoVOs[i].getSkdDirCd());
				vslVO.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
				vslVO.setUpdUsrId(account.getUsr_id());
				// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
				vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
				addVoList.add(vslVO);
				chkVoList.add(vslVO);
				// 동일한 CRN허용 : SKD_DIR_CD만 다른경우
				vslVO = new BkgCstmsCndVslVO();
				vslVO.setVslCd(cstmsVvdInfoVOs[i].getVslCd());
				vslVO.setSkdVoyNo(cstmsVvdInfoVOs[i].getSkdVoyNo());
				vslVO.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
				vslVO.setUpdUsrId(account.getUsr_id());
				if ("E".equals(cstmsVvdInfoVOs[i].getSkdDirCd())) {
					vslVO.setSkdDirCd("W");
				} else if ("W".equals(cstmsVvdInfoVOs[i].getSkdDirCd())) {
					vslVO.setSkdDirCd("E");
				}
				// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
				vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
				addVoList.add(vslVO);
				chkVoList.add(vslVO);
				/****************************************************
				 * 2010.05.20 : ETA의 경우 동일한 CRN허용하는거에서 제외
				 ****************************************************/
				// 동일한 CRN허용
//				vslVO.setEtaDt(cstmsVvdInfoVOs[i].getVpsEtaDt());
				// ETA와 Vessel은 같고 VoyNo는 다른 VVD 조회
//				List<BkgCstmsCndVslVO> vslList = dbDao.searchBkgCstmsCndVsl(vslVO);
//				for (int j = 0; j < vslList.size(); j++)
//				{
//					BkgCstmsCndVslVO vsl2 = (BkgCstmsCndVslVO) vslList.get(j);
//					vsl2.setCvyRefNo(cstmsVvdInfoVOs[i].getCvyRefNo());
//					vsl2.setUpdUsrId(account.getUsr_id());
//					// 중복 CRN체크를 위해 에러메시지 3번 인덱스를 위해 잠시 세팅
//					vslVO.setAckDt(cstmsVvdInfoVOs[i].getCrrCd());
//					addVoList.add(vsl2);
//					chkVoList.add(vsl2);
//				}
				// 중복된 VVD조회
				String duplicateVvdCd = dbDao.searchDuplicateVvd(chkVoList);
				if (!"".equals(cstmsVvdInfoVOs[i].getCvyRefNo()) && !"".equals(duplicateVvdCd)) {
					String arr[] = new String[3];
					arr[0] = cstmsVvdInfoVOs[i].getCvyRefNo();
					arr[1] = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo() + cstmsVvdInfoVOs[i].getSkdDirCd();
					arr[2] = duplicateVvdCd;
					throw new EventException(new ErrorHandler("BKG01027", arr).getMessage());
				}
			}
			// 입력받은 데이타중 중복된 CRN체크
			String vvd_cd = "";
			String crn_no = "";
			String vvd_cd2 = "";
			String crn_no2 = "";
			for (int i = 0; i < cstmsVvdInfoVOs.length; i++) {
				vvd_cd = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo() + cstmsVvdInfoVOs[i].getSkdDirCd();
				crn_no = cstmsVvdInfoVOs[i].getCvyRefNo();
				for (int j = 0; j < cstmsVvdInfoVOs.length; j++) {
					vvd_cd2 = cstmsVvdInfoVOs[j].getVslCd() + cstmsVvdInfoVOs[j].getSkdVoyNo() + cstmsVvdInfoVOs[j].getSkdDirCd();
					crn_no2 = cstmsVvdInfoVOs[j].getCvyRefNo();
					if (i != j && !crn_no.equals("") && !crn_no2.equals("")) {
						if (!vvd_cd.equals(vvd_cd2) && crn_no.equals(crn_no2)) {
							String arr[] = new String[3];
							arr[0] = cstmsVvdInfoVOs[j].getCvyRefNo();
							arr[1] = cstmsVvdInfoVOs[j].getVslCd() + cstmsVvdInfoVOs[j].getSkdVoyNo() + cstmsVvdInfoVOs[j].getSkdDirCd();
							arr[2] = cstmsVvdInfoVOs[i].getVslCd() + cstmsVvdInfoVOs[i].getSkdVoyNo() + cstmsVvdInfoVOs[i].getSkdDirCd();
							throw new EventException(new ErrorHandler("BKG01027", arr).getMessage());
						}
					}
				}
			}
			// CRN 번호 수정
			dbDao.addBkgCstmsCndVsl(addVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * 세관 신고용 VVD별 Reference No 생성
	 *
	 * @param NewZealandCstmsVvdRefNoCondVO cstmsVvdRefNoCondVO
	 * @return NewZealandCstmsVvdRefNoVO
	 * @throws EventException
	 */
	public NewZealandCstmsVvdRefNoVO createCstmsVvdRefNo(NewZealandCstmsVvdRefNoCondVO cstmsVvdRefNoCondVO) throws EventException {
		try {
			NewZealandCstmsVvdRefNoVO cstmsVvdRefNoVO = new NewZealandCstmsVvdRefNoVO();
			cstmsVvdRefNoVO.setNewCrn(dbDao.createCndCstmsVvdRefNo(""));
			return cstmsVvdRefNoVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00392", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00392", new String[] {}).getMessage(), ex);
		}
	}

}
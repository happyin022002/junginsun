/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaManifestDownloadBCImpl.java
 *@FileTitle : UI_BKG-1141
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.07 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration.MalaysiaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.ImpStsSpclCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaAddVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaVvdVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author LIM JAE TAEK
 * @see EventResponse,MalaysiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MalaysiaManifestDownloadBCImpl extends BasicCommandSupport implements MalaysiaManifestDownloadBC {
	// Database Access Object
	private transient MalaysiaManifestListDownloadDBDAO dbDao = null;

	/**
	 * MalaysiaManifestDownloadBCImpl 객체 생성<br>
	 * MalaysiaManifestDownloadBCImpl 생성한다.<br>
	 */
	public MalaysiaManifestDownloadBCImpl() {
		dbDao = new MalaysiaManifestListDownloadDBDAO();
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
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CustomsDeclaration화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param MalaysiaManifestListCondVO malaysiaManifestListCondVO
	 * @return MalaysiaManifestListVO
	 * @exception EventException
	 */
	public MalaysiaManifestListVO searchManifestList(MalaysiaManifestListCondVO malaysiaManifestListCondVO) throws EventException {
		MalaysiaManifestListVO malaysiaManifestListVO = new MalaysiaManifestListVO();

		try {
			malaysiaManifestListVO.setMalaysiaManifestListBlInfoVOList(dbDao.searchCustomsBlInfo(malaysiaManifestListCondVO));
			malaysiaManifestListVO.setMalaysiaManifestListCntrInfoVOList(dbDao.searchCustomsCNTRInfo(malaysiaManifestListCondVO));
			return malaysiaManifestListVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Import Status I/F 조회
	 *
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 * @return MalaysiaImpStsVO
	 * @exception EventException
	 */
	public MalaysiaImpStsVO searchImpSts(MalaysiaImpStsVO malaysiaImpStsVO) throws EventException {
		// 처리결과를 넘길 객체
		MalaysiaImpStsVO outVO = new MalaysiaImpStsVO();
		// TP Count 조회
		String cnt = "0";
		// VSL Name, Dir 조회
		MalaysiaVvdVO malaysiaVvdVO = new MalaysiaVvdVO();
		// List 조회
		MalaysiaImpStsVO[] malaysiaImpStsVOs = null;
		MalaysiaAddVO malaysiaAddVO = new MalaysiaAddVO();
		// Add Container 조회 결과
		MalaysiaImpStsVO[] addContainerVOs = null;
		// 조회결과를 담을 List
		List<MalaysiaImpStsVO> listMalaysiaImpStsVO = new ArrayList<MalaysiaImpStsVO>();

		try {
			// Count 조회
			cnt = dbDao.searchTpCnt(malaysiaImpStsVO);
			if (cnt == null) cnt = "0";

			// List 조회
			malaysiaImpStsVOs = dbDao.searchImpStsInfoList(malaysiaImpStsVO);
			if (malaysiaImpStsVOs != null) listMalaysiaImpStsVO.addAll((List<MalaysiaImpStsVO>)Arrays.asList(malaysiaImpStsVOs));

			// 조회 결과 0 건이고, TP Count 가 0보다 크면 예외처리
			if ((malaysiaImpStsVOs == null || malaysiaImpStsVOs.length < 1) && !cnt.equals("0")) {
				outVO = new MalaysiaImpStsVO();
			} else {
				malaysiaAddVO.setVslCd(malaysiaImpStsVO.getVslCd());
				malaysiaAddVO.setSkdVoyNo(malaysiaImpStsVO.getSkdVoyNo());
				malaysiaAddVO.setSkdDirCd(malaysiaImpStsVO.getSkdDirCd());
				malaysiaAddVO.setPodCd(malaysiaImpStsVO.getPodCd());

				// 조회 결과 건수가 0 보다 크면
				if (malaysiaImpStsVOs != null && malaysiaImpStsVOs.length > 0) {
					// 컨테이너 번호 목록 조회 : Container No 만큼 반복
					List<MalaysiaImpStsVO> malaysiaImpStsVOList = new ArrayList<MalaysiaImpStsVO>();
/*
					for (String cntrNO : dbDao.searchAddCNTRList(malaysiaAddVO)) {
						malaysiaImpStsAddVO = new MalaysiaImpStsAddVO();
						ObjectCloner.build(malaysiaAddVO, malaysiaImpStsAddVO);
						malaysiaImpStsAddVO.setCntrNo(cntrNO);
						MalaysiaImpStsVO[] tempVOs = dbDao.searchImpStsInfoAddList(malaysiaImpStsAddVO);
						if (tempVOs != null && tempVOs.length > 0) malaysiaImpStsVOList.add(tempVOs[0]);
					}
*/
					addContainerVOs = malaysiaImpStsVOList.toArray(new MalaysiaImpStsVO[0]);

				} else {
					// 조회 결과 건수가 0건인 경우
					malaysiaImpStsVO.setCntrNo(null);
					addContainerVOs = dbDao.searchImpStsInfoAddList(malaysiaImpStsVO);
					if (addContainerVOs != null && addContainerVOs.length > 0) {
						List<MalaysiaImpStsVO> malaysiaImpStsVOList = new ArrayList<MalaysiaImpStsVO>();
						for (int i=0; i < addContainerVOs.length; i++) {
							if (i > 0) {
								if (addContainerVOs[i].getCntrNo().equals(addContainerVOs[i-1].getCntrNo())) continue;
							}
							malaysiaImpStsVOList.add(addContainerVOs[i]);
						}
						addContainerVOs = malaysiaImpStsVOList.toArray(new MalaysiaImpStsVO[0]);
					}
				}

				// TS 판단 후 LIST에 추가
				if (addContainerVOs != null) {
					for (MalaysiaImpStsVO MalaysiaImpStsVO : addContainerVOs) {
						if (MalaysiaImpStsVO == null) continue;
						// Next VVD가 비어있거나, VVD와 같으면
						if (("".equals(MalaysiaImpStsVO.getNextVslCd()) &&
							 "".equals(MalaysiaImpStsVO.getNextSkdVoyNo()) &&
							 "".equals(MalaysiaImpStsVO.getNextSkdDirCd())) ||(MalaysiaImpStsVO.getVslCd().equals(MalaysiaImpStsVO.getNextVslCd()) &&
							 MalaysiaImpStsVO.getSkdVoyNo().equals(MalaysiaImpStsVO.getNextSkdVoyNo()) &&
							 MalaysiaImpStsVO.getSkdDirCd().equals(MalaysiaImpStsVO.getNextSkdDirCd()))) {

							MalaysiaImpStsVO.setTsTpCd("L");
						}
					}
				}
				if (addContainerVOs!=null && addContainerVOs.length > 0) listMalaysiaImpStsVO.addAll(Arrays.asList(addContainerVOs));
				// 결과 객체에 담기
				outVO.setListMalaysiaImpStsVO(listMalaysiaImpStsVO);
			}

			// VVD Name Dir 조회
			malaysiaVvdVO = dbDao.searchVslNameDir(malaysiaImpStsVO.getVslCd() + malaysiaImpStsVO.getSkdVoyNo() + malaysiaImpStsVO.getSkdDirCd());
			outVO.setMalaysiaVvdVO(malaysiaVvdVO);

		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return outVO;
	}

	/**
	 * ESM_BKG_1522 : Save - Back End Job 시작<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param MalaysiaImpStsVO[] malaysiaImpStsVOs
	 * @param SignOnUserAccount account
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobManageImpSts(MalaysiaImpStsVO[] malaysiaImpStsVOs, SignOnUserAccount account, String pgmNo) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		MalaysiaManifestDownloadBackEndJob backEndJob = new MalaysiaManifestDownloadBackEndJob();
		try {
			backEndJob.setMalaysiaImpStsVOs(malaysiaImpStsVOs);
			backEndJob.setPgmNo(pgmNo);
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), pgmNo);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param MalaysiaImpStsVO[] malaysiaImpStsVOs
	 * @exception EventException
	 */
	public void manageImpSts(MalaysiaImpStsVO[] malaysiaImpStsVOs) throws EventException {
		try {
			// Vessel validation Check
			String vslCnt = dbDao.searchVslCount(malaysiaImpStsVOs[0].getVslCd(), malaysiaImpStsVOs[0].getSkdVoyNo(), malaysiaImpStsVOs[0].getSkdDirCd());
			// 결과 건수가 1건 이하인 경우 예외처리
			if (vslCnt == null || vslCnt.compareTo("1") < 0) {
				throw new EventException(new ErrorHandler("BKG01122", new String[] { malaysiaImpStsVOs[0].getVslCd()+malaysiaImpStsVOs[0].getSkdVoyNo()+malaysiaImpStsVOs[0].getSkdDirCd() }).getMessage());
			}

			// GRID LOOP
			for (MalaysiaImpStsVO malaysiaImpStsVO : malaysiaImpStsVOs) {
				// 작업 구분에 따른 처리(I:추가 , U:수정, D:삭제)
				if (malaysiaImpStsVO.getIbflag().equals("I")) {
					// INSERT
					dbDao.addImpStsInfo(malaysiaImpStsVO);
					dbDao.removeImpStsSpclInfo(malaysiaImpStsVO);

//					if ("1".equals(malaysiaImpStsVO.getSpc())) {    // Special일때만 저장
						// 2015-12-08 무조건 저장되도록 변경
						ImpStsSpclCgoVO searchImpStsSpclCgoVO = new ImpStsSpclCgoVO();
						ObjectCloner.build(malaysiaImpStsVO, searchImpStsSpclCgoVO);
						ImpStsSpclCgoVO resultImpStsSpclCgoVO = dbDao.searchBKGImpStsSpclCgo(searchImpStsSpclCgoVO);
						resultImpStsSpclCgoVO.setDcgoFlg(malaysiaImpStsVO.getDcgoFlg());
						resultImpStsSpclCgoVO.setRcFlg(malaysiaImpStsVO.getRcFlg());
						resultImpStsSpclCgoVO.setAwkCgoFlg(malaysiaImpStsVO.getAwkCgoFlg());
						resultImpStsSpclCgoVO.setBbCgoFlg(malaysiaImpStsVO.getBbCgoFlg());
						resultImpStsSpclCgoVO.setRdCgoFlg(malaysiaImpStsVO.getRdCgoFlg());
						resultImpStsSpclCgoVO.setUserId(malaysiaImpStsVO.getUserId());
						dbDao.addImpStsSpclCgo(resultImpStsSpclCgoVO);
//					}

				} else if (malaysiaImpStsVO.getIbflag().equals("U")) {
					// UPDATE
					dbDao.modifyImpStsInfo(malaysiaImpStsVO);

					ImpStsSpclCgoVO searchImpStsSpclCgoVO = new ImpStsSpclCgoVO();
					ObjectCloner.build(malaysiaImpStsVO, searchImpStsSpclCgoVO);
					ImpStsSpclCgoVO resultImpStsSpclCgoVO = dbDao.searchImpStsSpclCgo(searchImpStsSpclCgoVO);
					if (resultImpStsSpclCgoVO != null && !"".equals(resultImpStsSpclCgoVO.getLdIns())) {
						dbDao.modifyStwgIdOfImpStsSpclCgo(malaysiaImpStsVO);
					}

				} else if (malaysiaImpStsVO.getIbflag().equals("D")) {
					// DELETE
					dbDao.removeImpStsInfo(malaysiaImpStsVO);
					dbDao.removeImpStsSpclInfo(malaysiaImpStsVO);
				}
			}// END GRID LOOP

		} catch(EventException evx) {
			throw evx;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1522 : Save - Back End Job 결과<br>
	 * Malaysia Import Status I/F 추가/수정/삭제 처리
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManageImpSts(String backEndJobKey) throws EventException {
		try {
			return(String) BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Malaysia Vessel 정보 조회
	 *
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return MalaysiaVvdVO[]
	 * @exception EventException
	 */
	public MalaysiaVvdVO[] searchVslRegist(MalaysiaVvdVO malaysiaVvdVO) throws EventException {
		try {
			return dbDao.searchVslRegist(malaysiaVvdVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Vessel Name 조회
	 *
	 * @param MalaysiaVvdVO malaysiaVvdVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVslName(MalaysiaVvdVO malaysiaVvdVO) throws EventException {
		try {
			return dbDao.searchVslName(malaysiaVvdVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Vessel 정보 수정
	 *
	 * @param MalaysiaVvdVO[] malaysiaVvdVOs
	 * @exception EventException
	 */
	public void manageVVDInfo(MalaysiaVvdVO[] malaysiaVvdVOs) throws EventException {
		// Grid 에서 넘어오는 객체
		MalaysiaVvdVO malaysiaVvdVO = null;
		// ValidCheck1
		String validCheck1 = null;
		// ValidCheck2
		String validCheck2 = null;
		// ValidCheck3
		String validCheck3 = null;

		try {

			// LOOP
			for (int i=0; i < malaysiaVvdVOs.length; i++) {
				malaysiaVvdVO = malaysiaVvdVOs[i];
				// VALID CHECK
				validCheck1 = dbDao.searchVslPortSkdValidCheck(malaysiaVvdVO.getVslCd(), malaysiaVvdVO.getSkdVoyNo(), malaysiaVvdVO.getSkdDirCd());
				if (validCheck1==null || validCheck1.equals("0"))
					// "INVALID VESSEL PORT SCHEDULE" 오류 처리
					throw new EventException(new ErrorHandler("BKG01120", new String[] {}).getMessage());
				// Validation Check 후 MODE 를 변경함에 따라 Else if 문을 쓰지 않고 if 문으로 처리함

				// ADD
				if (malaysiaVvdVO.getIbflag().equals("I")) {
					// Validation Check2
					validCheck2 = dbDao.searchVVDValidCheck(malaysiaVvdVO);

					// 결과가 0이면 진행, 0보다 크면 UPDATE 로 처리
					if (validCheck2==null || validCheck2.equals("0")) {
						// INSERT
						dbDao.addVVDInfo(malaysiaVvdVO);
					} else {
						// 데이터가 존재하면 Modify 할수 있도록 mode 변경 처리
						malaysiaVvdVO.setIbflag("U");
					}
				}

				// MODIFY
				if (malaysiaVvdVO.getIbflag().equals("U")) dbDao.modifyVVDInfo(malaysiaVvdVO);

				// DELETE
				if (malaysiaVvdVO.getIbflag().equals("D")) {
					// Send Check 후 데이터가 존재하지 않는 경우만 삭제 처리
					validCheck3 = dbDao.searchSendValidCheck(malaysiaVvdVO);
					if (validCheck3==null || validCheck3.equals("0")) dbDao.removeVVDInfo(malaysiaVvdVO);
				}
			}
		}catch(EventException evx) {
			throw evx;
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Import Status Special Cargo의 정보를 조회
	 *
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @exception EventException
	 */
	public ImpStsSpclCgoVO searchImpoStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException {
		// 조회 결과 객체
		ImpStsSpclCgoVO outVO = null;
		try {
			// Malaysia 에서 조회
			outVO = dbDao.searchImpStsSpclCgo(impStsSpclCgoVO);
			// 조회 결과가 NULL 이면 BKG 에서 조회
			if (outVO==null) outVO = dbDao.searchBKGImpStsSpclCgo(impStsSpclCgoVO);
			if (outVO==null) {
				throw new EventException(new ErrorHandler("BKG00889").getMessage());
			}
		} catch(EventException evx) {
			throw evx;
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return outVO;
	}

	/**
	 * Malaysia Import Status Special Cargo 정보 추가/수정/삭제 처리
	 *
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception EventException
	 */
	public void manageImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws EventException {
		try {
			// INSERT
			if (impStsSpclCgoVO.getTypeCd().equals("I")) {
				if (dbDao.getImpStsSpclCgoPK(impStsSpclCgoVO) < 1) {
					dbDao.addImpStsSpclCgo(impStsSpclCgoVO);

				} else {
					// UPDATE
					dbDao.modifyImpStsSpclCgo(impStsSpclCgoVO);
					dbDao.modifyStwgIdOfImpSts(impStsSpclCgoVO);
				}

			} else if (impStsSpclCgoVO.getTypeCd().equals("D")) {
				// DELETE
				dbDao.removeImpStsSpclCgo(impStsSpclCgoVO);
			}
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Malaysia Vessel Import Schedule 조회
	 *
	 * @param String portCd
	 * @param String etbDt1
	 * @param String etbDt2
	 * @return MalaysiaVvdVO[]
	 * @exception EventException
	 */
	public MalaysiaVvdVO[] searchVVD(String portCd, String etbDt1, String etbDt2) throws EventException {
		// 조회용 객체
		MalaysiaVvdVO condVO = new MalaysiaVvdVO();
		// 조회 결과
		MalaysiaVvdVO[] malaysiaVvdVOs = null;
		try {
			condVO.setPortCd(portCd);
			condVO.setEtbDt1(etbDt1);
			condVO.setEtbDt2(etbDt2);
			malaysiaVvdVOs = dbDao.searchVVD(condVO);
		}catch(DAOException de) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return malaysiaVvdVOs;
	}

}


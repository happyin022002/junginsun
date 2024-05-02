/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManilaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0234
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration.ManilaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerSaveVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCtnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchGenVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescTempVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkTempVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hexiong.jdbf.DBFWriter;
import com.hexiong.jdbf.JDBFException;
import com.hexiong.jdbf.JDBField;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author LIM JAE TAEK
 * @see EventResponse,ManilaManifestListDownloadBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ManilaManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient ManilaManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManilaManifestListDownloadBCImpl 객체 생성<br>
	 */
	public ManilaManifestListDownloadBCImpl() {
		dbDao = new ManilaManifestListDownloadDBDAO();
	}

	/**
	 * Philippines를 통과하는 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		ManilaManifestListCondVO manilaManifestListCondVO = (ManilaManifestListCondVO) manifestListCondVO;

		List<ManilaSearchVvdDtlVO> manilasearchVvdDtlVOs = null;
		List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs = null;
		List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs = null;
		List<ManilaSearchCtnVO> manilaSearchCtnVOS = null;
		List<ManilaSearchGenVO> manilaSearchGenVOS = null;
		List<ManilaSearchBolVO> manilaSearchBolVOS = null;

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		ManilaContainerVO manilaContainerVO = new ManilaContainerVO();

		try {
			String sheetgubun = manilaManifestListCondVO.getSheetgubun();
			String pod = manilaManifestListCondVO.getPodCd();
			String pol = manilaManifestListCondVO.getPolCd();

			// 입력된 POD 등록여부 체크
			if (!pod.equals("")) {
				List<ManilaSearchCheckPodVO> manilaSearchCheckPodVOs = dbDao.searchCheckPod(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCheckPodVOs(manilaSearchCheckPodVOs);
			}
			// 입력된 POL 등록여부 체크
			if (!pol.equals("")) {
				List<ManilaSearchCheckPolVO> manilaSearchCheckPolVOs = dbDao.searchCheckPol(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCheckPolVOs(manilaSearchCheckPolVOs);
			}
			// 입력된 VVD 등록여부 체크
			List<ManilaSearchCheckVvdVO> manilaSearchCheckVvdVOs = dbDao.searchCheckVvd(manilaManifestListCondVO);
			manilaContainerVO.setManilaSearchCheckVvdVOs(manilaSearchCheckVvdVOs);

			if (sheetgubun.startsWith("t1")) {
				manilaSearchBolVOS = dbDao.searchBol(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchBolVOS(manilaSearchBolVOS);
			} else if (sheetgubun.startsWith("t2")) {
				manilaSearchGenVOS = dbDao.searchGen(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchGenVOS(manilaSearchGenVOS);
			} else if (sheetgubun.startsWith("t3")) {
				manilaSearchCtnVOS = dbDao.searchCtn(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCtnVOS(manilaSearchCtnVOS);
			} else if (sheetgubun.startsWith("t4")) {
				manilasearchVvdDtlVOs = dbDao.searchVvdDtl(manilaManifestListCondVO);
				manilaContainerVO.setManilasearchVvdDtlVOs(manilasearchVvdDtlVOs);
			} else if (sheetgubun.startsWith("t5")) {
				manilaSearchBlInfoVOs = dbDao.searchBlInfo(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchBlInfoVOs(manilaSearchBlInfoVOs);
			} else if (sheetgubun.startsWith("t6")) {
				manilaSearchCntrInfoVOs = dbDao.searchCntrInfo(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCntrInfoVOs(manilaSearchCntrInfoVOs);
			} else if (sheetgubun.startsWith("t7")) {
				manilaContainerVO.setManilaSearchPkgDescTempVOs(searchPkgDesc(manilaManifestListCondVO));
			} else if (sheetgubun.startsWith("t8")) {
				manilaContainerVO.setManilaSearchPkgTempMarkVOs(searchPkgMark(manilaManifestListCondVO));
			} 
			manifestListDetailVO.add((ManifestListDetailVO) manilaContainerVO);
			return manifestListDetailVO;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ManilaSearchPkgDescVO 리스트를 조회하여 데이터 처리 후 반환한다.<br>
	 * 
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchPkgDescTempVO>
	 * @exception EventException
	 */
	private List<ManilaSearchPkgDescTempVO> searchPkgDesc(ManilaManifestListCondVO manilaManifestListCondVO)
			throws EventException {
		List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOs = new ArrayList<ManilaSearchPkgDescTempVO>();
		ManilaSearchPkgDescTempVO tempvo = null;
		String descGood = "";
		String array[];
		String array1[];
		int seqCnt = 0;

		try {
			List<ManilaSearchPkgDescVO> manilaSearchPkgDescVOs = dbDao.searchPkgDesc(manilaManifestListCondVO);

			for (int j = 0; j < manilaSearchPkgDescVOs.size(); j++) {
				ManilaSearchPkgDescVO manilaSearchPkgDescVO = manilaSearchPkgDescVOs.get(j);
				descGood = manilaSearchPkgDescVO.getDescGood().toString();
				String[] ss = descGood.split("\r\n");
				array1 = new String[ss.length];
				for (int i = 0; i < ss.length; i++) {
					array1[i] = ss[i];
				}

				seqCnt = 0;
				for (int k = 0; k < array1.length; k++) {
					if (array1[k].length() < 36) {
						tempvo = new ManilaSearchPkgDescTempVO();
						tempvo.setSeq(manilaSearchPkgDescVO.getSeq());
						if (k + 1 <= seqCnt) {
							tempvo.setSeq2(Integer.toString(seqCnt + 1));
						} else {
							tempvo.setSeq2(Integer.toString(k + 1));
						}
						tempvo.setBlNo3(manilaSearchPkgDescVO.getBlNo3());
						tempvo.setIbflag(manilaSearchPkgDescVO.getIbflag());
						tempvo.setDescGood(array1[k].toString());
						tempvo.setPackageType(manilaSearchPkgDescVO.getPackageType());
						tempvo.setPckQty(manilaSearchPkgDescVO.getPckQty());
						tempvo.setRegNumber4(manilaSearchPkgDescVO.getRegNumber4());
						tempvo.setMaxRows(manilaSearchPkgDescVO.getMaxRows());
						tempvo.setMark(manilaSearchPkgDescVO.getMark());
						tempvo.setPagerows(manilaSearchPkgDescVO.getPagerows());
						manilaSearchPkgDescTempVOs.add(tempvo);
						seqCnt = Integer.parseInt(tempvo.getSeq2());
					}
					if (array1[k].length() > 35) {
						int kk = array1[k].length() / 35;
						array = new String[kk];
						for (int i = 0; i < kk; i++) {
							if (i == 0)
								array[i] = array1[k].substring(i, 35);
							else
								array[i] = array1[k].substring(i * 35, i * 35 + 35);
						}
						for (int i = 0; i < array.length; i++) {
							tempvo = new ManilaSearchPkgDescTempVO();
							tempvo.setSeq(manilaSearchPkgDescVO.getSeq());
							if (k + 1 <= seqCnt) {
								tempvo.setSeq2(Integer.toString(seqCnt + 1));
							} else {
								tempvo.setSeq2(Integer.toString(k + 1 + i));
							}
							tempvo.setBlNo3(manilaSearchPkgDescVO.getBlNo3());
							tempvo.setIbflag(manilaSearchPkgDescVO.getIbflag());
							tempvo.setDescGood(array[i].toString());
							tempvo.setPackageType(manilaSearchPkgDescVO.getPackageType());
							tempvo.setPckQty(manilaSearchPkgDescVO.getPckQty());
							tempvo.setRegNumber4(manilaSearchPkgDescVO.getRegNumber4());
							tempvo.setMaxRows(manilaSearchPkgDescVO.getMaxRows());
							tempvo.setMark(manilaSearchPkgDescVO.getMark());
							tempvo.setPagerows(manilaSearchPkgDescVO.getPagerows());
							manilaSearchPkgDescTempVOs.add(tempvo);
							seqCnt = Integer.parseInt(tempvo.getSeq2());
						}
						tempvo = new ManilaSearchPkgDescTempVO();
						tempvo.setSeq(manilaSearchPkgDescVO.getSeq());
						if (k + 1 <= seqCnt) {
							tempvo.setSeq2(Integer.toString(seqCnt + 1));
						} else {
							tempvo.setSeq2(Integer.toString(k + 1 + array.length));
						}
						tempvo.setBlNo3(manilaSearchPkgDescVO.getBlNo3());
						tempvo.setIbflag(manilaSearchPkgDescVO.getIbflag());
						tempvo.setDescGood(array1[k].substring(kk * 35));
						tempvo.setPackageType(manilaSearchPkgDescVO.getPackageType());
						tempvo.setPckQty(manilaSearchPkgDescVO.getPckQty());
						tempvo.setRegNumber4(manilaSearchPkgDescVO.getRegNumber4());
						tempvo.setMaxRows(manilaSearchPkgDescVO.getMaxRows());
						tempvo.setMark(manilaSearchPkgDescVO.getMark());
						tempvo.setPagerows(manilaSearchPkgDescVO.getPagerows());
						manilaSearchPkgDescTempVOs.add(tempvo);
						seqCnt = Integer.parseInt(tempvo.getSeq2());
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return manilaSearchPkgDescTempVOs;
	}

	/**
	 * ManilaSearchPkgMarkVO 리스트를 조회하여 데이터 처리 후 반환한다.<br>
	 * 
	 * @param manilaManifestListCondVO ManilaManifestListCondVO
	 * @return List<ManilaSearchPkgMarkTempVO>
	 * @exception EventException
	 */
	private List<ManilaSearchPkgMarkTempVO> searchPkgMark(ManilaManifestListCondVO manilaManifestListCondVO)
			throws EventException {
		List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarTempkVOs = new ArrayList<ManilaSearchPkgMarkTempVO>();
		ManilaSearchPkgMarkTempVO tempvo = null;
		String descGood = "";
		String array1[];
		String array2[];

		try {
			List<ManilaSearchPkgMarkVO> manilaSearchPkgMarkVOs = dbDao.searchPkgMark(manilaManifestListCondVO);
			for (int j = 0; j < manilaSearchPkgMarkVOs.size(); j++) {
				ManilaSearchPkgMarkVO manilaSearchPkgMarkVO = manilaSearchPkgMarkVOs.get(j);
				descGood = manilaSearchPkgMarkVO.getDescGood2().toString();
				String[] ss = descGood.split("\r\n");
				array1 = new String[ss.length];
				for (int i = 0; i < ss.length; i++) {
					array1[i] = ss[i];
				}
				for (int k = 0; k < array1.length; k++) {
					if (array1[k].length() < 16) {
						tempvo = new ManilaSearchPkgMarkTempVO();
						tempvo.setSeq(manilaSearchPkgMarkVO.getSeq());
						tempvo.setBlNo4(manilaSearchPkgMarkVO.getBlNo4());
						tempvo.setIbflag(manilaSearchPkgMarkVO.getIbflag());
						tempvo.setDescGood2(array1[k].toString());
						tempvo.setRegNumber5(manilaSearchPkgMarkVO.getRegNumber5());
						tempvo.setMark2(manilaSearchPkgMarkVO.getMark2());
						tempvo.setMaxRows(manilaSearchPkgMarkVO.getMaxRows());
						tempvo.setPagerows(manilaSearchPkgMarkVO.getPagerows());
						manilaSearchPkgMarTempkVOs.add(tempvo);
					}
					if (array1[k].length() > 15) {
						int kk = array1[k].length() / 15;
						array2 = new String[kk];
						for (int i = 0; i < kk; i++) {
							if (i == 0)
								array2[i] = array1[k].substring(i, 15);
							else
								array2[i] = array1[k].substring(i * 15, i * 15 + 15);
						}
						for (int i = 0; i < array2.length; i++) {
							tempvo = new ManilaSearchPkgMarkTempVO();
							tempvo.setSeq(manilaSearchPkgMarkVO.getSeq());
							tempvo.setBlNo4(manilaSearchPkgMarkVO.getBlNo4());
							tempvo.setIbflag(manilaSearchPkgMarkVO.getIbflag());
							tempvo.setDescGood2(array2[i].toString());
							tempvo.setRegNumber5(manilaSearchPkgMarkVO.getRegNumber5());
							tempvo.setMaxRows(manilaSearchPkgMarkVO.getMaxRows());
							tempvo.setMark2(manilaSearchPkgMarkVO.getMark2());
							tempvo.setPagerows(manilaSearchPkgMarkVO.getPagerows());
							manilaSearchPkgMarTempkVOs.add(tempvo);
						}
						tempvo = new ManilaSearchPkgMarkTempVO();
						tempvo.setSeq(manilaSearchPkgMarkVO.getSeq());
						tempvo.setBlNo4(manilaSearchPkgMarkVO.getBlNo4());
						tempvo.setIbflag(manilaSearchPkgMarkVO.getIbflag());
						tempvo.setDescGood2(array1[k].substring(kk * 15));
						tempvo.setRegNumber5(manilaSearchPkgMarkVO.getRegNumber5());
						tempvo.setMaxRows(manilaSearchPkgMarkVO.getMaxRows());
						tempvo.setPagerows(manilaSearchPkgMarkVO.getPagerows());
						tempvo.setMark2(manilaSearchPkgMarkVO.getMark2());
						manilaSearchPkgMarTempkVOs.add(tempvo);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return manilaSearchPkgMarTempkVOs;
	}

	/**
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 * 
	 * @param manifestListDetailVO ManifestListDetailVO
	 * @return String 다운로드 생성 파일 이름
	 * @exception EventException
	 */
	public String downloadManifest(ManifestListDetailVO manifestListDetailVO) throws EventException {

		ManilaContainerSaveVO manilaContainerSaveVO = (ManilaContainerSaveVO) manifestListDetailVO;

		ManilaManifestListCondVO manilaManifestListCondVO = manilaContainerSaveVO.getManilaManifestListCondVO();
		String sheetgubun = manilaManifestListCondVO.getSheetgubun();

		ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOList = manilaContainerSaveVO.getManilasearchVvdDtlVO();
		ManilaSearchVvdDtlVO manilasearchVvdDtlVO = null;

		ManilaSearchBlInfoVO[] manilaSearchBlInfoVOList = manilaContainerSaveVO.getManilaSearchBlInfoVO();
		ManilaSearchBlInfoVO manilaSearchBlInfoVO = null;

		ManilaSearchPkgDescVO[] manilaSearchPkgDescVOList = manilaContainerSaveVO.getManilaSearchPkgDescVO();
		ManilaSearchPkgDescTempVO manilaSearchPkgDescTempVO = null;

		ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOList = manilaContainerSaveVO.getManilaSearchPkgMarkVO();
		ManilaSearchPkgMarkTempVO manilaSearchPkgMarkTempVO = null;

		ManilaSearchBolVO[] manilaSearchBolVOList = manilaContainerSaveVO.getManilaSearchBolVOs();
		ManilaSearchGenVO[] manilaSearchGenVOList = manilaContainerSaveVO.getManilaSearchGenVOs();
		ManilaSearchCtnVO[] manilaSearchCtnVOList = manilaContainerSaveVO.getManilaSearchCtnVOs();
		
		String filename = null;
		int arrCnt = 0;
		StringBuffer flatFile = new StringBuffer();
		
		try {
			if (sheetgubun.equals("sheet1_")) {
				if(manilaSearchBolVOList != null) {
					for(int i=0; i<manilaSearchBolVOList.length; i++) {
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getOfcCd(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getRegNo(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getBlNo(), false));
						flatFile.append(manilaSearchBolVOList[i].getBlLineNo()+",");
						flatFile.append(manilaSearchBolVOList[i].getBlSubLineNo()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getBlSts(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getPreDoc(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getBlTp(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getBlNtCd(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getUqRefNo(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getShprNm(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getShprAddr1(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getShprAddr2(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getShprAddr3(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getShprAddr4(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCneeCd(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCneeNm(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCneeAddr1(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCneeAddr2(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCneeAddr3(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCneeAddr4(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getNtfyCd(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getNtfyNm(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getNtfyAddr1(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getNtfyAddr2(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getNtfyAddr3(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getNtfyAddr4(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getPorCd(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getDelCd(), false));
						flatFile.append(manilaSearchBolVOList[i].getTotCntr()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getPckTp(), false));
						flatFile.append(manilaSearchBolVOList[i].getPckQty()+",");
						flatFile.append(manilaSearchBolVOList[i].getWgt()+",");
						flatFile.append(manilaSearchBolVOList[i].getVol()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc1(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc2(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc3(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc4(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc5(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc6(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc7(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc8(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc9(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getMkDesc10(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getGdsDesc1(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getGdsDesc2(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getGdsDesc3(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getGdsDesc4(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getGdsDesc5(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getFreInd(), false));
						flatFile.append(manilaSearchBolVOList[i].getFreVal()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getFreCur(), false));
						flatFile.append(manilaSearchBolVOList[i].getCstmsVal()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getCstmsCur(), false));
						flatFile.append(manilaSearchBolVOList[i].getTrspVal()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getTrspCur(), false));
						flatFile.append(manilaSearchBolVOList[i].getInsurVal()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getInsurCur(), false));
						flatFile.append(manilaSearchBolVOList[i].getTotSubBl()+",");
						flatFile.append(manilaSearchBolVOList[i].getTotSeal()+",");
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getDelMod(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getInfo1(), false));
						flatFile.append(setFlatFile(manilaSearchBolVOList[i].getInfo2(), true));
					}
					filename = flatFile.toString();
				}
			}
			
			if (sheetgubun.equals("sheet2_")) {
				if(manilaSearchGenVOList != null) {
					for(int i=0; i<manilaSearchGenVOList.length; i++) {
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getOfcCd(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getRegNo(), false));
						flatFile.append(manilaSearchGenVOList[i].getEtaDt()+",");
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getEtaTm(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getPorCd(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getDelCd(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getCrrCd(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getCrrNm(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getCrrAddr1(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getCrrAddr2(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getCrrAddr3(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getCrrAddr4(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getTrspMod(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getTrspId(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getTrspNtlt(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getPlzReg(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getTrspRegNo(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getTrspRegDt(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getVvd(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getPor(), false));
						flatFile.append(setFlatFile(manilaSearchGenVOList[i].getMstInfo2(), false));
						flatFile.append(manilaSearchGenVOList[i].getNetTon()+",");
						flatFile.append(manilaSearchGenVOList[i].getGrsTon()+",");
						flatFile.append(manilaSearchGenVOList[i].getTotBl()+",");
						flatFile.append(manilaSearchGenVOList[i].getTotCntr()+"\n");
					}
					filename = flatFile.toString();
				}
			}
			
			if (sheetgubun.equals("sheet3_")) {
				if(manilaSearchCtnVOList != null) {
					for(int i=0; i<manilaSearchCtnVOList.length; i++) {
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getOfcCd(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getRegNo(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getBlNo(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getCntrNo(), false));
						if(manilaSearchCtnVOList[i].getCntrTpsz() != null) {
							if(manilaSearchCtnVOList[i].getCntrTpsz().substring(1,2).equals("2")) {
								manilaSearchCtnVOList[i].setCntrTpsz("20");
							} else if(manilaSearchCtnVOList[i].getCntrTpsz().substring(1,2).equals("4")) {
								manilaSearchCtnVOList[i].setCntrTpsz("40");
							}
						}
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getCntrTpsz(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getCgoTp(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getCntrSealNo(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getCntrSealNo2(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getCntrSealNo3(), false));
						flatFile.append(setFlatFile(manilaSearchCtnVOList[i].getSealPtyCd(), true));
					}
					filename = flatFile.toString();
				}
			}
			
			if (sheetgubun.equals("sheet4_")) {
				List<ManilaSearchVvdDtlVO> manilaSearchVvdDtlVOs = dbDao.searchVvdDtl(manilaManifestListCondVO);
				for (int i = 0; i < manilaSearchVvdDtlVOs.size(); i++) {
					manilasearchVvdDtlVO = manilaSearchVvdDtlVOs.get(i);

					if (manilasearchVvdDtlVOList.length > 0) {
						if (manilasearchVvdDtlVO.getSeq().equals(manilasearchVvdDtlVOList[arrCnt].getSeq())) {
							manilasearchVvdDtlVO.setDischarge(manilasearchVvdDtlVOList[arrCnt].getDischarge());
							if (arrCnt < manilasearchVvdDtlVOList.length - 1)
								arrCnt++;
						}
					}
				}
				filename = makeDbfwriter("ManilaSearchVvdDtlVO", manilaSearchVvdDtlVOs);
			}

			if (sheetgubun.equals("sheet5_")) {
				List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs = dbDao.searchBlInfo(manilaManifestListCondVO);
				for (int i = 0; i < manilaSearchBlInfoVOs.size(); i++) {
					manilaSearchBlInfoVO = manilaSearchBlInfoVOs.get(i);

					if (manilaSearchBlInfoVOList.length > 0) {
						if (manilaSearchBlInfoVO.getSeq().equals(manilaSearchBlInfoVOList[arrCnt].getSeq())) {
							manilaSearchBlInfoVO.setCargoType(manilaSearchBlInfoVOList[arrCnt].getCargoType());
							manilaSearchBlInfoVO.setPod(manilaSearchBlInfoVOList[arrCnt].getPod());
							if (arrCnt < manilaSearchBlInfoVOList.length - 1)
								arrCnt++;
						}
					}
				}
				filename = makeDbfwriter("ManilaSearchBlInfoVO", manilaSearchBlInfoVOs);
			}

			if (sheetgubun.equals("sheet6_")) {
				List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs = dbDao.searchCntrInfo(manilaManifestListCondVO);
				filename = makeDbfwriter("ManilaSearchCntrInfoVO", manilaSearchCntrInfoVOs);
			}

			if (sheetgubun.equals("sheet7_")) {
				List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOs = searchPkgDesc(manilaManifestListCondVO);
				for (int i = 0; i < manilaSearchPkgDescTempVOs.size(); i++) {
					manilaSearchPkgDescTempVO = manilaSearchPkgDescTempVOs.get(i);

					if (manilaSearchPkgDescVOList.length > 0) {
						if (manilaSearchPkgDescTempVO.getSeq().equals(manilaSearchPkgDescVOList[arrCnt].getSeq())
								&& manilaSearchPkgDescTempVO.getSeq2().equals(
										manilaSearchPkgDescVOList[arrCnt].getSeq2())) {
							manilaSearchPkgDescTempVO.setDescGood(manilaSearchPkgDescVOList[arrCnt].getDescGood());
							if (arrCnt < manilaSearchPkgDescVOList.length - 1)
								arrCnt++;
						}
					}
				}
				filename = makeDbfwriter("ManilaSearchPkgDescVO", manilaSearchPkgDescTempVOs);
			}

			if (sheetgubun.equals("sheet8_")) {

				List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarTempkVOs = searchPkgMark(manilaManifestListCondVO);
				for (int i = 0; i < manilaSearchPkgMarTempkVOs.size(); i++) {
					manilaSearchPkgMarkTempVO = manilaSearchPkgMarTempkVOs.get(i);

					if (manilaSearchPkgMarkVOList.length > 0) {
						if (manilaSearchPkgMarkTempVO.getSeq().equals(manilaSearchPkgMarkVOList[arrCnt].getSeq())) {
							manilaSearchPkgMarkTempVO.setDescGood2(manilaSearchPkgMarkVOList[arrCnt].getDescGood2());
							if (arrCnt < manilaSearchPkgMarkVOList.length - 1)
								arrCnt++;
						}
					}
				}
				filename = makeDbfwriter("ManilaSearchPkgMarkVO", manilaSearchPkgMarTempkVOs);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return filename;
	}

	/**
	 * 파일 생성을 위한 VO 리스트를 받아 .DBF 파일생성하여 파일 경로를 반환한다.<br>
	 * 
	 * @param clsName String
	 * @param obj String
	 * @return String 다운로드 생성 파일 이름
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private String makeDbfwriter(String clsName, Object obj) throws EventException {
		DBFWriter dbfwriter = null;
		String filename = null;

		try {
			if (clsName.equalsIgnoreCase("ManilaSearchVvdDtlVO")) {

				List<ManilaSearchVvdDtlVO> manilaSearchVvdDtlVOs = (List<ManilaSearchVvdDtlVO>) obj;
				ManilaSearchVvdDtlVO manilaSearchVvdDtlVO = manilaSearchVvdDtlVOs.get(0);

				filename = "/tmp/" + manilaSearchVvdDtlVO.getRegNumber().toString() + "1" + ".dbf";

				JDBField[] fields = { new JDBField("IFM_REGNO", 'C', 7, 0), new JDBField("IFM_ARIVAL", 'C', 8, 0),
						new JDBField("IFM_VESSEL", 'C', 15, 0), new JDBField("IFM_ORIGIN", 'C', 2, 0),
						new JDBField("IFM_PORT", 'C', 1, 0), new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (int i = 0; i < manilaSearchVvdDtlVOs.size(); i++) {
					manilaSearchVvdDtlVO = manilaSearchVvdDtlVOs.get(i);

					String strDate = manilaSearchVvdDtlVO.getEtadt().toString();
					DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					DateFormat outputDateFormat = new SimpleDateFormat("MM-dd-yy", Locale.ENGLISH);
					strDate = outputDateFormat.format(inputDateFormat.parse(strDate));

					Object[] records = { manilaSearchVvdDtlVO.getRegNumber(), strDate, manilaSearchVvdDtlVO.getVname(),
							manilaSearchVvdDtlVO.getPolcd(), manilaSearchVvdDtlVO.getDischarge(), 0 };

					dbfwriter.addRecord(records);
				} // for end
			}

			if (clsName.equalsIgnoreCase("ManilaSearchBlInfoVO")) {

				List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs = (List<ManilaSearchBlInfoVO>) obj;
				ManilaSearchBlInfoVO manilaSearchBlInfoVO = manilaSearchBlInfoVOs.get(0);

				filename = "/tmp/" + manilaSearchBlInfoVO.getRegNumber2().toString() + "2" + ".dbf";

				JDBField[] fields = { new JDBField("IFM_YS", 'N', 2, 0), new JDBField("IFM_REGNO", 'C', 7, 0),
						new JDBField("IFM_BL", 'C', 22, 0), new JDBField("IFM_CARGO", 'N', 3, 0),
						new JDBField("IFM_SHIPR", 'C', 40, 0), new JDBField("IFM_SADD1", 'C', 40, 0),
						new JDBField("IFM_SADD2", 'C', 40, 0), new JDBField("IFM_SADD3", 'C', 40, 0),
						new JDBField("IFM_SADD4", 'C', 40, 0), new JDBField("IFM_CNSGN", 'C', 40, 0),
						new JDBField("IFM_ADD1", 'C', 40, 0), new JDBField("IFM_ADD2", 'C', 40, 0),
						new JDBField("IFM_ADD3", 'C', 40, 0), new JDBField("IFM_ADD4", 'C', 40, 0),
						new JDBField("IFM_NOTIFY", 'C', 40, 0), new JDBField("IFM_NADD1", 'C', 40, 0),
						new JDBField("IFM_NADD2", 'C', 40, 0), new JDBField("IFM_NADD3", 'C', 40, 0),
						new JDBField("IFM_NADD4", 'C', 40, 0), new JDBField("IFM_NOCNTR", 'N', 3, 0),
						new JDBField("IFM_WEIGHT", 'N', 15, 0), new JDBField("IFM_SIZE", 'C', 11, 0),
						new JDBField("IFM_ORG", 'C', 2, 0), new JDBField("IFM_DES", 'C', 3, 0),
						new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (int i = 0; i < manilaSearchBlInfoVOs.size(); i++) {
					manilaSearchBlInfoVO = manilaSearchBlInfoVOs.get(i);

					Object[] records = {
							manilaSearchBlInfoVO.getYear() == null ? 0 : Integer.parseInt(manilaSearchBlInfoVO
									.getYear()),
							manilaSearchBlInfoVO.getRegNumber2(),
							manilaSearchBlInfoVO.getBlNo(),
							manilaSearchBlInfoVO.getCargoType() == null ? 0 : Integer.parseInt(manilaSearchBlInfoVO
									.getCargoType()),
							manilaSearchBlInfoVO.getShipperName(),
							manilaSearchBlInfoVO.getShipperAddress1(),
							manilaSearchBlInfoVO.getShipperAddress2(),
							manilaSearchBlInfoVO.getShipperAddress3(),
							manilaSearchBlInfoVO.getShipperAddress4(),
							manilaSearchBlInfoVO.getConsigneeName(),
							manilaSearchBlInfoVO.getConsigneeAddress1(),
							manilaSearchBlInfoVO.getConsigneeAddress2(),
							manilaSearchBlInfoVO.getConsigneeAddress3(),
							manilaSearchBlInfoVO.getConsigneeAddress4(),
							manilaSearchBlInfoVO.getNotifyName(),
							manilaSearchBlInfoVO.getNotifyAddress1(),
							manilaSearchBlInfoVO.getNotifyAddress2(),
							manilaSearchBlInfoVO.getNotifyAddress3(),
							manilaSearchBlInfoVO.getNotifyAddress4(),
							manilaSearchBlInfoVO.getTotalCntr() == null ? 0 : Integer.parseInt(manilaSearchBlInfoVO
									.getTotalCntr()),
							manilaSearchBlInfoVO.getWeight() == null ? 0 : Math.round(Float
									.parseFloat(manilaSearchBlInfoVO.getWeight())), manilaSearchBlInfoVO.getVolume(),
							manilaSearchBlInfoVO.getCountryOrigin(), manilaSearchBlInfoVO.getPod(), 0 };

					dbfwriter.addRecord(records);
				} // for end
			}

			if (clsName.equalsIgnoreCase("ManilaSearchCntrInfoVO")) {

				List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs = (List<ManilaSearchCntrInfoVO>) obj;
				ManilaSearchCntrInfoVO manilaSearchCntrInfoVO = manilaSearchCntrInfoVOs.get(0);

				filename = "/tmp/" + manilaSearchCntrInfoVO.getRegNumber3().toString() + "4" + ".dbf";

				JDBField[] fields = { new JDBField("IFM_REGNO", 'C', 7, 0), new JDBField("IFM_BL", 'C', 22, 0),
						new JDBField("IFM_CNTRNO", 'C', 12, 0), new JDBField("IFM_SIZE", 'C', 2, 0),
						new JDBField("IFM_SEALNO", 'C', 30, 0), new JDBField("IFM_SMODE", 'N', 1, 0),
						new JDBField("MARKER", 'N', 1, 0) };

				dbfwriter = new DBFWriter(filename, fields);

				for (int i = 0; i < manilaSearchCntrInfoVOs.size(); i++) {
					manilaSearchCntrInfoVO = manilaSearchCntrInfoVOs.get(i);
					int delivertype = 0;

					if (manilaSearchCntrInfoVO.getDeliveryType().toString().equalsIgnoreCase("YY"))
						delivertype = 1;
					else if (manilaSearchCntrInfoVO.getDeliveryType().toString().equalsIgnoreCase("YS"))
						delivertype = 2;
					else if (manilaSearchCntrInfoVO.getDeliveryType().toString().equalsIgnoreCase("SY"))
						delivertype = 3;
					else if (manilaSearchCntrInfoVO.getDeliveryType().toString().equalsIgnoreCase("SS"))
						delivertype = 4;
					else
						delivertype = 0;

					Object[] records = { manilaSearchCntrInfoVO.getRegNumber3().toString(),
							manilaSearchCntrInfoVO.getBlNo2().toString(),
							manilaSearchCntrInfoVO.getContainerNo().toString(),
							manilaSearchCntrInfoVO.getTypeSize().toString(),
							manilaSearchCntrInfoVO.getCntrRealNo().toString(), delivertype, 0 };
					dbfwriter.addRecord(records);
				} // for end
			}

			if (clsName.equalsIgnoreCase("ManilaSearchPkgDescVO")) {

				List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescVOs = (List<ManilaSearchPkgDescTempVO>) obj;
				ManilaSearchPkgDescTempVO manilaSearchPkgDescVO = manilaSearchPkgDescVOs.get(0);

				filename = "/tmp/" + manilaSearchPkgDescVO.getRegNumber4().toString() + "5" + ".dbf";

				JDBField[] fields = { new JDBField("IFM_REGNO", 'C', 7, 0), new JDBField("IFM_BL", 'C', 22, 0),
						new JDBField("IFM_UNIT", 'C', 5, 0), new JDBField("IFM_NOPCKG", 'N', 8, 0),
						new JDBField("IFM_DESC", 'C', 35, 0), new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (int i = 0; i < manilaSearchPkgDescVOs.size(); i++) {
					manilaSearchPkgDescVO = manilaSearchPkgDescVOs.get(i);

					Object[] records = {
							manilaSearchPkgDescVO.getRegNumber4(),
							manilaSearchPkgDescVO.getBlNo3(),
							manilaSearchPkgDescVO.getPackageType(),
							(manilaSearchPkgDescVO.getPckQty() == null || manilaSearchPkgDescVO.getPckQty() == null) ? 0
									: Integer.parseInt(manilaSearchPkgDescVO.getPckQty()),
							manilaSearchPkgDescVO.getDescGood(), Integer.parseInt(manilaSearchPkgDescVO.getMark()) };
					dbfwriter.addRecord(records);
				} // for end
			}

			if (clsName.equalsIgnoreCase("ManilaSearchPkgMarkVO")) {

				List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarkVOs = (List<ManilaSearchPkgMarkTempVO>) obj;
				ManilaSearchPkgMarkTempVO manilaSearchPkgMarkVO = manilaSearchPkgMarkVOs.get(0);

				filename = "/tmp/" + manilaSearchPkgMarkVO.getRegNumber5().toString() + "6" + ".dbf";

				JDBField[] fields = { new JDBField("IFM_REGNO", 'C', 7, 0), new JDBField("IFM_BL", 'C', 22, 0),
						new JDBField("IFM_DESC", 'C', 35, 0), new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (int i = 0; i < manilaSearchPkgMarkVOs.size(); i++) {
					manilaSearchPkgMarkVO = manilaSearchPkgMarkVOs.get(i);

					Object[] records = {
							manilaSearchPkgMarkVO.getRegNumber5(),
							manilaSearchPkgMarkVO.getBlNo4(),
							manilaSearchPkgMarkVO.getDescGood2(),
							(manilaSearchPkgMarkVO.getMark2() == null || manilaSearchPkgMarkVO.getMark2() == "") ? 0
									: Integer.parseInt(manilaSearchPkgMarkVO.getMark2()) };
					dbfwriter.addRecord(records);
				} // for end
			}

			return filename;

		} catch (JDBFException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (ParseException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} finally {
			try {
				if (dbfwriter != null)
					dbfwriter.close();
			} catch (JDBFException ex) {
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
		}
	}
	
	/**
	 * Flat File String 앞뒤에 \" 붙이기
	 * 
	 * @param str
	 * @return
	 */
	private String setFlatFile(String str, boolean end) {
		String doubleQuataionStr = "\"";
		String commaStr = ",";
		StringBuffer sb = new StringBuffer();
		sb.append(doubleQuataionStr);
		sb.append(str);
		sb.append(doubleQuataionStr);
		if (end)
			sb.append("\n");
		else
			sb.append(commaStr);
		return sb.toString();
	}
}

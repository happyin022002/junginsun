/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManilaManifestListDownloadBCImpl.java
 *@FileTitle : UI_BKG-0234
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration.ManilaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerSaveVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPodVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPolVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescTempVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkTempVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.hexiong.jdbf.DBFWriter;
import com.hexiong.jdbf.JDBFException;
import com.hexiong.jdbf.JDBField;

/**
 * OPUS-ManilaManifestListDownload Business Logic Command implementation<br>
 * - OPUS-ManilaManifestListDownload handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class ManilaManifestListDownloadBCImpl extends BasicCommandSupport implements ManilaManifestListDownloadBC {
	// Database Access Object
	private transient ManilaManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManilaManifestListDownloadBCImpl Object Creation<br>
	 */
	public ManilaManifestListDownloadBCImpl() {
		dbDao = new ManilaManifestListDownloadDBDAO();
	}

	/**
	 * Retrieve Manifest list about Cargo pass to Philippines.<br>
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

		List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();

		ManilaContainerVO manilaContainerVO = new ManilaContainerVO();

		try {
			String sheetgubun = manilaManifestListCondVO.getSheetgubun();
			String pod = manilaManifestListCondVO.getPodCd();
			String pol = manilaManifestListCondVO.getPolCd();

			// Check register or not about inputed POD
			if (!"".equals(pod)) {
				List<ManilaSearchCheckPodVO> manilaSearchCheckPodVOs = dbDao.searchCheckPod(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCheckPodVOs(manilaSearchCheckPodVOs);
			}
			// Check register or not about inputed POL
			if (!"".equals(pol)) {
				List<ManilaSearchCheckPolVO> manilaSearchCheckPolVOs = dbDao.searchCheckPol(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCheckPolVOs(manilaSearchCheckPolVOs);
			}
			// Check register or not about inputed VVD
			List<ManilaSearchCheckVvdVO> manilaSearchCheckVvdVOs = dbDao.searchCheckVvd(manilaManifestListCondVO);
			manilaContainerVO.setManilaSearchCheckVvdVOs(manilaSearchCheckVvdVOs);

			if (sheetgubun.startsWith("t1")) {
				manilasearchVvdDtlVOs = dbDao.searchVvdDtl(manilaManifestListCondVO);
				manilaContainerVO.setManilasearchVvdDtlVOs(manilasearchVvdDtlVOs);
			} else if (sheetgubun.startsWith("t2")) {
				manilaSearchBlInfoVOs = dbDao.searchBlInfo(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchBlInfoVOs(manilaSearchBlInfoVOs);
			} else if (sheetgubun.startsWith("t3")) {
				manilaSearchCntrInfoVOs = dbDao.searchCntrInfo(manilaManifestListCondVO);
				manilaContainerVO.setManilaSearchCntrInfoVOs(manilaSearchCntrInfoVOs);
			} else if (sheetgubun.startsWith("t4")) {
				manilaContainerVO.setManilaSearchPkgDescTempVOs(this.searchPkgDesc(manilaManifestListCondVO));
			} else if (sheetgubun.startsWith("t5")) {
				manilaContainerVO.setManilaSearchPkgTempMarkVOs(this.searchPkgMark(manilaManifestListCondVO));
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
	 * Return after retrieve ManilaSearchPkgDescVO and Processing data.<br>
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
				String[] ss = descGood.split("\n");
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
	 * return after ritrieve ManilaSearchPkgMarkVO list and processing data.<br>
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
				String[] ss = descGood.split("\n");
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
	 * DBF file create and return file path to local .<br>
	 *
	 * @param manifestListDetailVO ManifestListDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifest(ManifestListDetailVO manifestListDetailVO) throws EventException {

		ManilaContainerSaveVO manilaContainerSaveVO = (ManilaContainerSaveVO) manifestListDetailVO;
		ManilaManifestListCondVO manilaManifestListCondVO = manilaContainerSaveVO.getManilaManifestListCondVO();
		String sheetgubun = manilaManifestListCondVO.getSheetgubun();

		ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOs = manilaContainerSaveVO.getManilasearchVvdDtlVO();
		ManilaSearchBlInfoVO[] manilaSearchBlInfoVOs = manilaContainerSaveVO.getManilaSearchBlInfoVO();
		ManilaSearchPkgDescVO[] manilaSearchPkgDescVOs = manilaContainerSaveVO.getManilaSearchPkgDescVO();
		ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOs = manilaContainerSaveVO.getManilaSearchPkgMarkVO();

		String filename = null;
		int arrCnt = 0;

		try {

			if (sheetgubun.equals("sheet1_")) {
				List<ManilaSearchVvdDtlVO> manilaSearchVvdDtlVOList = dbDao.searchVvdDtl(manilaManifestListCondVO);
				for (ManilaSearchVvdDtlVO manilasearchVvdDtlVO : manilaSearchVvdDtlVOList) {
					if (manilasearchVvdDtlVOs.length > 0) {
						if (manilasearchVvdDtlVO.getSeq().equals(manilasearchVvdDtlVOs[arrCnt].getSeq())) {
							manilasearchVvdDtlVO.setDischarge(manilasearchVvdDtlVOs[arrCnt].getDischarge());
							if (arrCnt < manilasearchVvdDtlVOs.length - 1) arrCnt++;
						}
					}
				}
				filename = this.makeDbfwriter("ManilaSearchVvdDtlVO", manilaSearchVvdDtlVOList);
			}

			if (sheetgubun.equals("sheet2_")) {
				List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOList = dbDao.searchBlInfo(manilaManifestListCondVO);
				for (ManilaSearchBlInfoVO manilaSearchBlInfoVO : manilaSearchBlInfoVOList) {
					if (manilaSearchBlInfoVOs.length > 0) {
						if (manilaSearchBlInfoVO.getSeq().equals(manilaSearchBlInfoVOs[arrCnt].getSeq())) {
							manilaSearchBlInfoVO.setCargoType(manilaSearchBlInfoVOs[arrCnt].getCargoType());
							manilaSearchBlInfoVO.setPod(manilaSearchBlInfoVOs[arrCnt].getPod());
							if (arrCnt < manilaSearchBlInfoVOs.length - 1) arrCnt++;
						}
					}
				}
				filename = this.makeDbfwriter("ManilaSearchBlInfoVO", manilaSearchBlInfoVOList);
			}

			if (sheetgubun.equals("sheet3_")) {
				List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs = dbDao.searchCntrInfo(manilaManifestListCondVO);
				filename = this.makeDbfwriter("ManilaSearchCntrInfoVO", manilaSearchCntrInfoVOs);
			}

			if (sheetgubun.equals("sheet4_")) {
				List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOList = searchPkgDesc(manilaManifestListCondVO);
				for (ManilaSearchPkgDescTempVO manilaSearchPkgDescTempVO : manilaSearchPkgDescTempVOList) {
					if (manilaSearchPkgDescVOs.length > 0) {
						if (manilaSearchPkgDescTempVO.getSeq().equals(manilaSearchPkgDescVOs[arrCnt].getSeq())
							&& manilaSearchPkgDescTempVO.getSeq2().equals(manilaSearchPkgDescVOs[arrCnt].getSeq2())) {
								manilaSearchPkgDescTempVO.setDescGood(manilaSearchPkgDescVOs[arrCnt].getDescGood());
								if (arrCnt < manilaSearchPkgDescVOs.length - 1) arrCnt++;
						}
					}
				}
				filename = this.makeDbfwriter("ManilaSearchPkgDescVO", manilaSearchPkgDescTempVOList);
			}

			if (sheetgubun.equals("sheet5_")) {

				List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarTempkVOList = this.searchPkgMark(manilaManifestListCondVO);
				for (ManilaSearchPkgMarkTempVO manilaSearchPkgMarkTempVO : manilaSearchPkgMarTempkVOList) {
					if (manilaSearchPkgMarkVOs.length > 0) {
						if (manilaSearchPkgMarkTempVO.getSeq().equals(manilaSearchPkgMarkVOs[arrCnt].getSeq())) {
							manilaSearchPkgMarkTempVO.setDescGood2(manilaSearchPkgMarkVOs[arrCnt].getDescGood2());
							if (arrCnt < manilaSearchPkgMarkVOs.length - 1) arrCnt++;
						}
					}
				}
				filename = this.makeDbfwriter("ManilaSearchPkgMarkVO", manilaSearchPkgMarTempkVOList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return filename;
	}

	/**
	 * receive vo list for file create and return file path after DBF file create.<br>
	 *
	 * @param clsName String
	 * @param Object obj
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private String makeDbfwriter(String clsName, Object obj) throws EventException {
		DBFWriter dbfwriter = null;
		String filename = null;

		try {
			if (clsName.equalsIgnoreCase("ManilaSearchVvdDtlVO")) {
				List<ManilaSearchVvdDtlVO> manilaSearchVvdDtlVOList = (List<ManilaSearchVvdDtlVO>) obj;
				filename = "/tmp/" + manilaSearchVvdDtlVOList.get(0).getRegNumber().toString() + "1" + ".dbf";
				JDBField[] fields = { new JDBField("IFM_REGNO", 'C', 7, 0),
									  new JDBField("IFM_ARIVAL", 'C', 8, 0),
									  new JDBField("IFM_VESSEL", 'C', 15, 0),
									  new JDBField("IFM_ORIGIN", 'C', 5, 0),
									  new JDBField("IFM_PORT", 'C', 1, 0),
									  new JDBField("IFM_GTON", 'N', 10, 0),
									  new JDBField("IFM_NTON", 'N', 10, 0),
									  new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (ManilaSearchVvdDtlVO manilaSearchVvdDtlVO : manilaSearchVvdDtlVOList) {
					String strDate = manilaSearchVvdDtlVO.getEtadt().toString();
					DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					DateFormat outputDateFormat = new SimpleDateFormat("MM-dd-yy", Locale.ENGLISH);
					strDate = outputDateFormat.format(inputDateFormat.parse(strDate));

					Object[] records = { manilaSearchVvdDtlVO.getRegNumber(),
										 strDate,
										 manilaSearchVvdDtlVO.getVname(),
										 manilaSearchVvdDtlVO.getPolcd(),
										 manilaSearchVvdDtlVO.getDischarge(),
										 Integer.valueOf(manilaSearchVvdDtlVO.getGTongWgt()),
										 Integer.valueOf(manilaSearchVvdDtlVO.getNTongWgt()),
										 0 };
					dbfwriter.addRecord(records);
				} // for end


			} else if (clsName.equalsIgnoreCase("ManilaSearchBlInfoVO")) {
				List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOList = (List<ManilaSearchBlInfoVO>) obj;
				filename = "/tmp/" + manilaSearchBlInfoVOList.get(0).getRegNumber2().toString() + "2" + ".dbf";

				JDBField[] fields = {new JDBField("IFM_YS", 'N', 2, 0),
									 new JDBField("IFM_REGNO", 'C', 7, 0),
									 new JDBField("IFM_BL", 'C', 22, 0),
									 new JDBField("IFM_CARGO", 'C', 4, 0),
									 new JDBField("IFM_SHIPR1", 'C', 35, 0),
									 new JDBField("IFM_SHIPR2", 'C', 35, 0),
									 new JDBField("IFM_SADD1", 'C', 35, 0),
									 new JDBField("IFM_SADD2", 'C', 35, 0),
									 new JDBField("IFM_SADD3", 'C', 35, 0),
									 new JDBField("IFM_SADD4", 'C', 35, 0),
									 new JDBField("IFM_CNSGN1", 'C', 35, 0),
									 new JDBField("IFM_CNSGN2", 'C', 35, 0),
									 new JDBField("IFM_ADD1", 'C', 35, 0),
									 new JDBField("IFM_ADD2", 'C', 35, 0),
									 new JDBField("IFM_ADD3", 'C', 35, 0),
									 new JDBField("IFM_ADD4", 'C', 35, 0),
									 new JDBField("IFM_NOTI1", 'C', 35, 0),
									 new JDBField("IFM_NOTI2", 'C', 35, 0),
									 new JDBField("IFM_NADD1", 'C', 35, 0),
									 new JDBField("IFM_NADD2", 'C', 35, 0),
									 new JDBField("IFM_NADD3", 'C', 35, 0),
									 new JDBField("IFM_NADD4", 'C', 35, 0),
									 new JDBField("IFM_NOCNTR", 'N', 3, 0),
									 new JDBField("IFM_WEIGHT", 'C', 15, 0),
									 new JDBField("IFM_SIZE", 'C', 11, 0),
									 new JDBField("IFM_ORG", 'C', 5, 0),
									 new JDBField("IFM_DES", 'C', 5, 0),
									 new JDBField("IFM_NTCOD", 'C', 3, 0),
									 new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (ManilaSearchBlInfoVO manilaSearchBlInfoVO : manilaSearchBlInfoVOList) {
					String delCd = dbDao.searchDelCdFrBkg(manilaSearchBlInfoVO.getBlNo().substring(4));
					String blNatureCd = "";
					if (delCd != null && delCd.length()> 4) {
						if (!"PH".equals(delCd.substring(0, 2))) {
							blNatureCd = "28";
						} else{
							if (!"PHMNL".equals(delCd)) {
								blNatureCd = "24";
							} else{
								blNatureCd = "23";
							}
						}
					}

					Object[] records = {
							Integer.parseInt(manilaSearchBlInfoVO.getYear()),
							manilaSearchBlInfoVO.getRegNumber2(),
							manilaSearchBlInfoVO.getBlNo(),
							manilaSearchBlInfoVO.getCargoType(),
							manilaSearchBlInfoVO.getShipperName1(),
							manilaSearchBlInfoVO.getShipperName2(),
							manilaSearchBlInfoVO.getShipperAddress1(),
							manilaSearchBlInfoVO.getShipperAddress2(),
							manilaSearchBlInfoVO.getShipperAddress3(),
							manilaSearchBlInfoVO.getShipperAddress4(),
							manilaSearchBlInfoVO.getConsigneeName1(),
							manilaSearchBlInfoVO.getConsigneeName2(),
							manilaSearchBlInfoVO.getConsigneeAddress1(),
							manilaSearchBlInfoVO.getConsigneeAddress2(),
							manilaSearchBlInfoVO.getConsigneeAddress3(),
							manilaSearchBlInfoVO.getConsigneeAddress4(),
							manilaSearchBlInfoVO.getNotifyName1(),
							manilaSearchBlInfoVO.getNotifyName2(),
							manilaSearchBlInfoVO.getNotifyAddress1(),
							manilaSearchBlInfoVO.getNotifyAddress2(),
							manilaSearchBlInfoVO.getNotifyAddress3(),
							manilaSearchBlInfoVO.getNotifyAddress4(),
							Integer.parseInt(manilaSearchBlInfoVO.getTotalCntr()),
							manilaSearchBlInfoVO.getWeight(),
							manilaSearchBlInfoVO.getVolume(),
							manilaSearchBlInfoVO.getCountryOrigin(),
							manilaSearchBlInfoVO.getPod(),
							blNatureCd,
							0 };
					dbfwriter.addRecord(records);
				} // for end


			} else if (clsName.equalsIgnoreCase("ManilaSearchCntrInfoVO")) {
				List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOList = (List<ManilaSearchCntrInfoVO>) obj;
				filename = "/tmp/" + manilaSearchCntrInfoVOList.get(0).getRegNumber3().toString() + "4" + ".dbf";

				JDBField[] fields = { new JDBField("IFM_REGNO", 'C', 7, 0),
									  new JDBField("IFM_BL", 'C', 22, 0),
									  new JDBField("IFM_CNTRNO", 'C', 12, 0),
									  new JDBField("IFM_SIZE", 'C', 2, 0),
									  new JDBField("IFM_SEAL1", 'C', 10, 0),
									  new JDBField("IFM_SEAL2", 'C', 10, 0),
									  new JDBField("IFM_SEAL3", 'C', 10, 0),
									  new JDBField("IFM_SMODE", 'C', 2, 0),
									  new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (ManilaSearchCntrInfoVO manilaSearchCntrInfoVO : manilaSearchCntrInfoVOList) {
					Object[] records = { manilaSearchCntrInfoVO.getRegNumber3().toString(),
										 manilaSearchCntrInfoVO.getBlNo2().toString(),
										 manilaSearchCntrInfoVO.getContainerNo().toString(),
										 manilaSearchCntrInfoVO.getTypeSize().toString(),
										 manilaSearchCntrInfoVO.getCntrSealNo1().toString(),
										 manilaSearchCntrInfoVO.getCntrSealNo2().toString(),
										 manilaSearchCntrInfoVO.getCntrSealNo3().toString(),
										 manilaSearchCntrInfoVO.getDeliveryType().toString(),
										 0 };
					dbfwriter.addRecord(records);
				} // for end


			} else if (clsName.equalsIgnoreCase("ManilaSearchPkgDescVO")) {
				List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescVOList = (List<ManilaSearchPkgDescTempVO>) obj;
				filename = "/tmp/" + manilaSearchPkgDescVOList.get(0).getRegNumber4().toString() + "5" + ".dbf";

				JDBField[] fields = {	new JDBField("IFM_REGNO", 'C', 7, 0), new JDBField("IFM_BL", 'C', 22, 0),
										new JDBField("IFM_UNIT", 'C', 5, 0), new JDBField("IFM_NOPCKG", 'N', 8, 0),
										new JDBField("IFM_DESC", 'C', 35, 0), new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				for (ManilaSearchPkgDescTempVO manilaSearchPkgDescVO : manilaSearchPkgDescVOList) {
					Object[] records = {
							manilaSearchPkgDescVO.getRegNumber4(),
							manilaSearchPkgDescVO.getBlNo3(),
							manilaSearchPkgDescVO.getPackageType(),
							(manilaSearchPkgDescVO.getPckQty() == null || manilaSearchPkgDescVO.getPckQty() == null) ? 0 : Integer.parseInt(manilaSearchPkgDescVO.getPckQty()),
							manilaSearchPkgDescVO.getDescGood(), Integer.parseInt(manilaSearchPkgDescVO.getMark()) };
					dbfwriter.addRecord(records);
				} // for end


			} else if (clsName.equalsIgnoreCase("ManilaSearchPkgMarkVO")) {
				List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarkVOList = (List<ManilaSearchPkgMarkTempVO>) obj;
				filename = "/tmp/" + manilaSearchPkgMarkVOList.get(0).getRegNumber5().toString() + "6" + ".dbf";

				JDBField[] fields = {	new JDBField("IFM_REGNO", 'C', 7, 0), new JDBField("IFM_BL", 'C', 22, 0),
										new JDBField("IFM_DESC", 'C', 35, 0), new JDBField("MARKER", 'N', 1, 0) };
				dbfwriter = new DBFWriter(filename, fields);

				
				for (ManilaSearchPkgMarkTempVO manilaSearchPkgMarkVO : manilaSearchPkgMarkVOList) {
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

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (JDBFException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (ParseException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} finally {
			try {
				if (dbfwriter != null) dbfwriter.close();
			} catch (JDBFException ex) {
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
		}
	}
}

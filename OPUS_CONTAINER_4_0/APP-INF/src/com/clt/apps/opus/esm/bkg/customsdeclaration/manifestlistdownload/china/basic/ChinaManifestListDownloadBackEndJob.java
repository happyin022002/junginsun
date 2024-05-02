/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChinaManifestListDownloadBackEndJob.java
 *@FileTitle : ChinaManifestListDownloadBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration.ChinaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChnBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsChnAwkVO;
import com.clt.syscommon.common.table.BkgCstmsChnBlVO;
import com.clt.syscommon.common.table.BkgCstmsChnCntrVO;
import com.clt.syscommon.common.table.BkgCstmsChnCustVO;
import com.clt.syscommon.common.table.BkgCstmsChnDgCgoVO;
import com.clt.syscommon.common.table.BkgCstmsChnMkVO;
import com.clt.syscommon.common.table.BkgCstmsChnRfVO;
import com.clt.syscommon.common.table.BkgCstmsChnVvdVO;
import com.clt.syscommon.common.table.BkgCstmsSealNoVO;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Subin
 * @see ESM_BKG_0216EventResponse,ChinaManifestListDownloadBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChinaManifestListDownloadBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestListDetailVO[] manifestListDetailVOs;
	private SignOnUserAccount account;

	// Database Access Object
	private transient ChinaManifestListDownloadDBDAO dbDao = new ChinaManifestListDownloadDBDAO();

	/**
	 * 다운로드 할 데이터 세팅
	 *
	 * @param ManifestListDetailVO[] detailVOs
	 * @param SignOnUserAccount account
	 */
	public void setManifestListDetailVO(ManifestListDetailVO[] detailVOs, SignOnUserAccount account) {
		if (detailVOs != null) {
			ManifestListDetailVO[] tmpVOs = Arrays.copyOf(detailVOs, detailVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
		this.account = account;
	}

	/**
	 * 세관에 적하목록을 신고하기 위해 B/L Manifest 정보를 세관 테이블로 Download 한다.<br>
	 * @return Object
	 * @exception EventException
	 */
	public Object doStart() throws EventException {
		try {
			ChinaManifestListDetailVO[] chinaManifestListDetailVOs = (ChinaManifestListDetailVO[])this.manifestListDetailVOs;
			ChinaManifestListDetailVO detailVO = chinaManifestListDetailVOs[0];

			String strVvd = detailVO.getVvd();
			String strVvd2 = detailVO.getVvd2();
			String strTransMode = detailVO.getTransMode();
			String strLocCd = detailVO.getLocCd();
			String strBkgCgoTpCd = detailVO.getBkgCgoTpCd();

			ChnBlKeyVO chnBlKeyVO = new ChnBlKeyVO();
			List<ChnBlKeyVO> blKeyVOs = new ArrayList<ChnBlKeyVO>();

			List<String> bkgNoList = this.generateBkgNoList(chinaManifestListDetailVOs);
			List<String> blNoList = this.generateBlNoList(chinaManifestListDetailVOs);

			for(int i=0; i<bkgNoList.size(); i++) {
				chnBlKeyVO = new ChnBlKeyVO();
				// 조회 데이터
				chnBlKeyVO.setVvd(strVvd);
				chnBlKeyVO.setVvd2(strVvd2);
				chnBlKeyVO.setTransMode(strTransMode);
				chnBlKeyVO.setLocCd(strLocCd);
				chnBlKeyVO.setBkgCgoTpCd(strBkgCgoTpCd);
				// insert 시 등록자 이름 저장
				chnBlKeyVO.setUsrId(account.getUsr_id());
				// select 시 조회 데이터
				chnBlKeyVO.setBkgNo(bkgNoList.get(i));
				// delete 시 조회 데이터
				chnBlKeyVO.setBlNo(blNoList.get(i));
				blKeyVOs.add(chnBlKeyVO);
			}
			String transMode = chinaManifestListDetailVOs[0].getTransMode();

			/*==============================================================*/
			/* VVD 기본 정보 GET -> Download                                */
			/*==============================================================*/
			String bkgVvd = strVvd2;
			if ("".equals(bkgVvd)) bkgVvd = strVvd;
			if ("D".equals(transMode)) {
				List<BkgCstmsChnVvdVO> bkgCstmsChnVvdVOList = dbDao.searchVslInfoList ( blKeyVOs );
				if (bkgCstmsChnVvdVOList.size() > 0) {
					dbDao.removeVslInfoList (blKeyVOs , transMode);
					for (BkgCstmsChnVvdVO bkgCstmsChnVvdVO : bkgCstmsChnVvdVOList) {
						bkgCstmsChnVvdVO.setBkgVslCd(bkgVvd.substring(0, 4));
						bkgCstmsChnVvdVO.setBkgSkdVoyNo(bkgVvd.substring(4, 8));
						bkgCstmsChnVvdVO.setBkgSkdDirCd(bkgVvd.substring(8, 9));
					}
					dbDao.addVslInfoList (bkgCstmsChnVvdVOList);
				}
			} else {
				BkgCstmsChnVvdVO bkgCstmsChnVvdVO = dbDao.searchVslInfo (chnBlKeyVO);
				if (bkgCstmsChnVvdVO != null) {
					dbDao.removeCncusVslInfo (chnBlKeyVO, transMode);
					bkgCstmsChnVvdVO.setBkgVslCd(bkgVvd.substring(0, 4));
					bkgCstmsChnVvdVO.setBkgSkdVoyNo(bkgVvd.substring(4, 8));
					bkgCstmsChnVvdVO.setBkgSkdDirCd(bkgVvd.substring(8, 9));
					dbDao.addVslInfo(bkgCstmsChnVvdVO);
				}
			}

			dbDao.removeBlAllList(blKeyVOs, transMode);
			dbDao.removeBlCustAllList(blKeyVOs, transMode);
			dbDao.removeBlCntrAllList(blKeyVOs, transMode);
			dbDao.removeBlCntrSealNoAllList(blKeyVOs , transMode);
			dbDao.removeBlMdList2(blKeyVOs, transMode);
			/*==============================================================*/
			/* BL 정보 GET -> Download                                       */
			/*==============================================================*/
			List<BkgCstmsChnBlVO> bkgCstmsChnBlVOList = dbDao.searchBlList ( blKeyVOs );

			if (bkgCstmsChnBlVOList.size() > 0) {
				String[] blData = null;

				// 하나의 컬럼으로 넘어온 B/L 정보를 각각의 데이터로 잘라서 셋팅
				for (BkgCstmsChnBlVO bkgCstmsChnBlVO : bkgCstmsChnBlVOList) {
					blData = bkgCstmsChnBlVO.getBlNo().split("\t");

					bkgCstmsChnBlVO.setBlNo(blData[1]);
					bkgCstmsChnBlVO.setVslCd(blData[3]);
					bkgCstmsChnBlVO.setSkdVoyNo(blData[4]);
					bkgCstmsChnBlVO.setSkdDirCd(blData[5]);
					bkgCstmsChnBlVO.setPortCd(blData[32]);
					bkgCstmsChnBlVO.setBkgPolCd(blData[6]);
					bkgCstmsChnBlVO.setBkgPodCd(blData[7]);
					bkgCstmsChnBlVO.setPorCd(blData[8]);
					bkgCstmsChnBlVO.setPolCd(blData[9]);
					bkgCstmsChnBlVO.setPodCd(blData[10]);
					bkgCstmsChnBlVO.setDelCd(blData[11]);
					bkgCstmsChnBlVO.setBlIssDt(blData[12]);
					bkgCstmsChnBlVO.setBlObrdDt(blData[13]);
					bkgCstmsChnBlVO.setChnCstmsTrspModCd(blData[14]);
					bkgCstmsChnBlVO.setRcvTermCd(blData[15]);
					bkgCstmsChnBlVO.setDeTermCd(blData[16]);
					bkgCstmsChnBlVO.setFrtTermCd(blData[17]);
					bkgCstmsChnBlVO.setCstmsDesc(blData[18]);
					bkgCstmsChnBlVO.setPckQty(blData[19]);
					bkgCstmsChnBlVO.setPckTpCd(blData[20]);
					bkgCstmsChnBlVO.setActWgt(blData[21]);
					bkgCstmsChnBlVO.setWgtUtCd(blData[22]);
					bkgCstmsChnBlVO.setMeasQty(blData[23]);
					bkgCstmsChnBlVO.setMeasUtCd(blData[24]);
					bkgCstmsChnBlVO.setBkgCgoTpCd(blData[25]);
					bkgCstmsChnBlVO.setDcgoFlg(blData[26]);
					bkgCstmsChnBlVO.setRcFlg(blData[27]);
					bkgCstmsChnBlVO.setBlIssOfcCd(blData[28]);
					bkgCstmsChnBlVO.setChnMfSndIndCd(blData[29]);
					bkgCstmsChnBlVO.setBlPodEtaDt(blData[30]);
					bkgCstmsChnBlVO.setPodYdCd(blData[31]);
					bkgCstmsChnBlVO.setBkgVslCd(blData[33]);
					bkgCstmsChnBlVO.setBkgSkdVoyNo(blData[34]);
					bkgCstmsChnBlVO.setBkgSkdDirCd(blData[35]);
					bkgCstmsChnBlVO.setPodRoutDesc(dbDao.searchPodRoutDesc(bkgCstmsChnBlVO));
					bkgCstmsChnBlVO.setCreUsrId(chnBlKeyVO.getUsrId());
					bkgCstmsChnBlVO.setUpdUsrId(chnBlKeyVO.getUsrId());
				}

				dbDao.removeBlList ( blKeyVOs , transMode );
				dbDao.removeBlDlHis ( blKeyVOs , transMode, account.getUsr_id());
				dbDao.addBlList ( bkgCstmsChnBlVOList );
				dbDao.addBlDlHis ( bkgCstmsChnBlVOList );
			}

			/*==============================================================*/
			/* CUST 정보 GET -> Download                                     */
			/*==============================================================*/
			List<BkgCstmsChnCustVO> bkgCstmsChnCustVOs = dbDao.searchBlCustList ( blKeyVOs );
			if (bkgCstmsChnCustVOs.size() > 0) {
				dbDao.removeBlCustList ( blKeyVOs , transMode );
				dbDao.addBlCustList ( bkgCstmsChnCustVOs );
			}

			/*==============================================================*/
			/* CNTR 정보 GET -> Download                                     */
			/*==============================================================*/
			List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs = dbDao.searchBkgCntr ( blKeyVOs );
			if (bkgCstmsChnCntrVOs.size() > 0) {
				dbDao.removeBlCntrList ( blKeyVOs , transMode );
				dbDao.addBlCntrList ( bkgCstmsChnCntrVOs );

				// TO-BE 에서 별도로 분리된 BKG_CSTMS_SEAL_NO 테이블에 데이터 조회 및 다운로드
				List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs = dbDao.searchBkgCntrSealNo ( blKeyVOs );
				if (bkgCstmsSealNoVOs.size() > 0) {
					dbDao.removeBlCntrSealNoList ( blKeyVOs , transMode );
					dbDao.addBlCntrSealNoList ( bkgCstmsSealNoVOs );
				}
			}

			/*==============================================================*/
			/* Danger Cargo 정보 GET -> Download                             */
			/*==============================================================*/
			List<BkgCstmsChnDgCgoVO> bkgCstmsChnDgCgoVOs = dbDao.searchCntrDgList ( blKeyVOs );
			if (bkgCstmsChnDgCgoVOs.size() > 0) {
				dbDao.removeBlCntrDgList ( blKeyVOs , transMode );
				dbDao.addBlCntrDgList ( bkgCstmsChnDgCgoVOs );
			}

			/*==============================================================*/
			/* Awkward 정보 GET -> Download                                  */
			/*==============================================================*/
			List<BkgCstmsChnAwkVO> bkgCstmsChnAwkVOs = dbDao.searchCntrAkList ( blKeyVOs );
			if (bkgCstmsChnAwkVOs.size() > 0) {
				dbDao.removeBlCntrAkList ( blKeyVOs , transMode );
				dbDao.addBlCntrAkList ( bkgCstmsChnAwkVOs );
			}

			/*==============================================================*/
			/* Reefer Cargo 정보 GET -> Download                             */
			/*==============================================================*/
			List<BkgCstmsChnRfVO> bkgCstmsChnRfVOs = dbDao.searchCntrRfList ( blKeyVOs );
			if (bkgCstmsChnRfVOs.size() > 0) {
				dbDao.removeBlCntrRfList ( blKeyVOs , transMode );
				dbDao.addBlCntrRfList ( bkgCstmsChnRfVOs );
			}

			/*==============================================================*/
			/* Mark Desc 정보 GET -> Download                                */
			/*==============================================================*/
			List<BkgCstmsChnMkVO> bkgCstmsChnMkVOs = dbDao.searchBlMdList ( blKeyVOs );

			if (bkgCstmsChnMkVOs.size() > 0) {
				String[] blData = null;
				BkgCstmsChnMkVO chnMkVO = null;

				// 하나의 컬럼으로 넘어온 MK 정보를 각각의 데이터로 잘라서 셋팅
				for(int i=0; i<bkgCstmsChnMkVOs.size(); i++) {
					chnMkVO = bkgCstmsChnMkVOs.get(i);
					blData = chnMkVO.getBlNo().split("\t");

					chnMkVO.setBlNo(blData[0]);
					chnMkVO.setBlMkSeq(blData[1]);
					chnMkVO.setChnMfSndIndCd(blData[2]);
				}
				dbDao.removeBlMdList ( blKeyVOs , transMode );
				dbDao.addBlMdList ( bkgCstmsChnMkVOs );
			}

			return null;

		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 *  IN 절에 들어갈 BKG_NO 문자열로 생성
	 *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
	 *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
	 *
	 * @param ChinaManifestListDetailVO[] detailVOs
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<String> generateBkgNoList(ChinaManifestListDetailVO[] detailVOs) throws EventException {
		try {
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = detailVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;

			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {
					if (j == i*1000-1000) {
						sb.append("'").append(detailVOs[j].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[j].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			if (restCnt > 0) {
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {
					if (i == quotaCnt*1000) {
						sb.append("'").append(detailVOs[i].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[i].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			return arrString;
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 *  IN 절에 들어갈 BL_NO 문자열로 생성
	 *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
	 *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
	 *
	 * @param ChinaManifestListDetailVO[] detailVOs
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<String> generateBlNoList(ChinaManifestListDetailVO[] detailVOs) throws EventException {
		try {
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = detailVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;

			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {
					if (j == i*1000-1000) {
						sb.append("'").append(detailVOs[j].getBlNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[j].getBlNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			if (restCnt > 0) {
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {
					if (i == quotaCnt*1000) {
						sb.append("'").append(detailVOs[i].getBlNo()).append("'");
					}else{
						sb.append(",'").append(detailVOs[i].getBlNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			return arrString;
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}
}
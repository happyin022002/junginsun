/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadBCImpl.java
*@FileTitle : ChinaManifestListDownloadBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
*
* 2011.06.16 민정호 [CHM-201111127] Split 03-Split 08-OPUS Error 처리 요청
* 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.basic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration.ChinaManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaVslRgstVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChnBlKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsChnAwkVO;
import com.clt.syscommon.common.table.BkgCstmsChnBlVO;
import com.clt.syscommon.common.table.BkgCstmsChnCntrVO;
import com.clt.syscommon.common.table.BkgCstmsChnCustVO;
import com.clt.syscommon.common.table.BkgCstmsChnDgCgoVO;
import com.clt.syscommon.common.table.BkgCstmsChnMkVO;
import com.clt.syscommon.common.table.BkgCstmsChnRfVO;
import com.clt.syscommon.common.table.BkgCstmsSealNoVO;
/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChinaManifestListDownloadBCImpl extends BasicCommandSupport implements ChinaManifestListDownloadBC {
	// Database Access Object
	private transient ChinaManifestListDownloadDBDAO dbDao = null;
	/**
	 * ChinaManifestListDownloadBCImpl 객체 생성<br>
	 * ChinaManifestListDownloadDBDAO 생성한다.<br>
	 */
	public ChinaManifestListDownloadBCImpl() {
		dbDao = new ChinaManifestListDownloadDBDAO();
	}

	/**
	 * 세관에 신고할 대상 Manifest 정보(Download 받을 데이터) 를 조회한다.<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {
			ChinaManifestListCondVO condVO = (ChinaManifestListCondVO) manifestListCondVO;
			ChinaManifestListDetailVO chinaManifestListDetailVO = new ChinaManifestListDetailVO();
			List<ManifestListDetailVO> manifestListDetailVOlist = new ArrayList<ManifestListDetailVO>();
			if ("csv".equals(condVO.getGubun())) {
				// CSV 다운로드 시 데이터 총 개수 조회
				chinaManifestListDetailVO.setTotal(dbDao.searchManifestDetailListCount(condVO));
			} else {
				// Vessel Info 조회
				chinaManifestListDetailVO = dbDao.searchVvdInfo(condVO);
				// B/L list 조회
				manifestListDetailVOlist = dbDao.searchManifestList(condVO);
			}
			manifestListDetailVOlist.add(0, chinaManifestListDetailVO);
			return manifestListDetailVOlist;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 세관에 적하목록을 신고하기 위해 B/L Manifest 정보를 세관 테이블로 다운받는 작업을 BackEndJob으로 등록한다.<br>
	 *
	 * @param manifestListDetailVOs ManifestListDetailVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException {
		try {
			//BackEndJob
			ChinaManifestListDownloadBackEndJob chinaBackEndJob = new ChinaManifestListDownloadBackEndJob();
			chinaBackEndJob.setManifestListDetailVO(manifestListDetailVOs, account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(chinaBackEndJob, account.getUsr_id(), "China Data Download(D/L) ");
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 세관에 신고할 대상 Manifest 정보(CSV 저장용 데이터) 를 조회한 후<br>
	 * 서버에.CSV  파일생성해서 로컬로 다운로드<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {
			List<ManifestListDetailVO> list = dbDao.searchManifestDetailList((ChinaManifestListCondVO) manifestListCondVO);
			Map<String, String> fieldNames = new ChinaManifestDetailListVO().getFieldNames();
			Object[] obj = fieldNames.keySet().toArray();
			String[] strArr = new String[obj.length-2];	// ibflag, pagerows 자동 생성 컬럼 제외
			String[] strArrTitle = new String[obj.length-2];
			strArr[0] = "svc_pvd";
			strArr[1] = "bl";
			strArr[2] = "por";
			strArr[3] = "pol";
			strArr[4] = "pod";
			strArr[5] = "del";
			strArr[6] = "wgt";
			strArr[7] = "pck";
			strArr[8] = "meas";
			strArr[9] = "shpr";
			strArr[10] = "cnee";
			strArr[11] = "ntfy";
			strArr[12] = "mk_desc";
			strArr[13] = "cmdt_desc";
			strArr[14] = "cstms_desc";
			strArr[15] = "cn_cmdt";
			strArr[16] = "hs_cd";
			strArr[17] = "cntr_opt";
			strArr[18] = "cntr_no";
			strArr[19] = "cntr_tpsz_cd";
			strArr[20] = "seal_no";
			strArr[21] = "cntr_wgt";
			strArr[22] = "cntr_meas";
			strArr[23] = "cdo_temp";
			strArr[24] = "imdg_clss_cd";
			strArr[25] = "imdg_un_no";
			strArr[26] = "ovr_fwrd_len";
			strArr[27] = "ovr_bkwd_len";
			strArr[28] = "ovr_hgt";
			strArr[29] = "ovr_lf_len";
			strArr[30] = "ovr_rt_len";

			strArrTitle[0] = "SERVICE PROVIDER";
			strArrTitle[1] = "BL NO.";
			strArrTitle[2] = "POR";
			strArrTitle[3] = "POL";
			strArrTitle[4] = "POD";
			strArrTitle[5] = "DEL";
			strArrTitle[6] = "Weight";
			strArrTitle[7] = "PKG QTY";
			strArrTitle[8] = "Measure QTY";
			strArrTitle[9] = "Shipper Address";
			strArrTitle[10] = "Consignee Address";
			strArrTitle[11] = "Notify Address";
			strArrTitle[12] = "Marks Description";
			strArrTitle[13] = "Commodity Description";
			strArrTitle[14] = "Customs Description";
			strArrTitle[15] = "Chiness Commodity";
			strArrTitle[16] = "HS Code";
			strArrTitle[17] = "CNTR Operator";
			strArrTitle[18] = "CNTR NO.";
			strArrTitle[19] = "CNTR Type";
			strArrTitle[20] = "Seal NO.";
			strArrTitle[21] = "CNTR Weight";
			strArrTitle[22] = "CNTR Measure";
			strArrTitle[23] = "Celsius Temperature";
			strArrTitle[24] = "IMDG Class Code";
			strArrTitle[25] = "IMDG UN NO.";
			strArrTitle[26] = "Over Forward Length";
			strArrTitle[27] = "Over Backward Length";
			strArrTitle[28] = "Over Height";
			strArrTitle[29] = "Over Left Length";
			strArrTitle[30] = "Over Right Length";
			if (list.size() > 0) {
				return this.generateCsv(list, strArrTitle, strArr);
			}else {
				return "";
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 객체를 CSV 파일로 변환하고 파일명을 반환한다.
	 * @param vos ValueObject 리스트를 담은 객체
	 * @param title 엑셀에서 컬럼의 TITLE 을 정의한 스트링 배열 객체
	 * @param columns 엑셀데이터용 컬럼명 배열
	 * @return String Excel 저장한 파일명
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private String generateCsv(List vos, String[] title, String[] columns) throws EventException {
		Map valueMap = null;
		StringBuilder header = new StringBuilder();
		StringBuilder body = new StringBuilder();
		StringBuilder sReturn = new StringBuilder();
		String columnValue = null;

		for(int i=0; i<title.length; i++) {
			header.append(title[i]);
			if (i<title.length) {
				header.append(",");
			}
		}
		header.append("\n");
		sReturn.append(header.toString());

		for(int i=0; i<vos.size(); i++) {
			valueMap =((AbstractValueObject) vos.get(i)).getColumnValues();
			body.append(""); // cell start
			for(int j=0; j<columns.length; j++) {
				columnValue =(String) valueMap.get(columns[j]);
				if ("null".equals(columnValue) || columnValue == null) columnValue = "";
				body.append("\"").append(columnValue).append("\"");
				if (j<columns.length) {
					body.append(",");
				}
			}
			body.append("\n");
			sReturn.append(body.toString());
			body.setLength(0);
		}
		return sReturn.toString();

//		String fileName = "/tmp/" + "China Cross Check and Download_" + System.currentTimeMillis() + ".csv";
//		File f = new File(fileName);
//		BufferedOutputStream bo = null;
//		try {
//			bo = new BufferedOutputStream(new FileOutputStream(f));
//			Map valueMap = null;
//			StringBuffer header = new StringBuffer();
//			StringBuffer body = new StringBuffer();
//			String columnValue = null;
//
//			// TITLE 생성
//			header.append(""); // cell start
//			for( int i=0; i<title.length; i++) {
//				header.append(title[i]);
//				if ( i<title.length) {
//					header.append(", ");
//				}
//			}
//			header.append("\n");
//			bo.write(header.toString().getBytes());
//
//			// BODY 생성
//			for( int i=0; i<vos.size(); i++) {
//				valueMap =((AbstractValueObject) vos.get(i)).getColumnValues();
//				body.append(""); // cell start
//				for( int j=0; j<columns.length; j++) {
//					columnValue =(String) valueMap.get(columns[j]);
//					if ("null".equals(columnValue) || columnValue == null) columnValue = "";
//					body.append("\"").append(columnValue).append("\"");
//					if ( j<columns.length) {
//						body.append(", ");
//					}
//				}
//				body.append("\n");
//				bo.write(body.toString().getBytes());
//				bo.flush();
//				body.setLength(0);
//			}
//		} catch(Exception e) {
//            log.error("err " + e.toString(), e);
//            throw new EventException(new ErrorHandler(e).getMessage(), e);
//		}finally {
//			try {
//				bo.close();
//			} catch(Exception e) {
//	log.error("err " + e.toString(), e);
//	throw new EventException(new ErrorHandler(e).getMessage(), e);
//			}
//		}
//		return fileName;
	}

	/**
	 * 세관 테이블에 Customer, Container 등의 B/L 정보를 등록, 수정, 삭제한다
	 *
	 * @param ChinaBlInfoVO chinaBlInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBlInfo(ChinaBlInfoVO chinaBlInfoVO, SignOnUserAccount account) throws EventException {
		try {
			/**
			 * 화면에서 넘어온 데이터를 각각의 Table VO에 담아 Dao에 파라미터로 넘긴다.
			 */
			//ChinaBlInfoVO chinaBlInfoVO =(ChinaBlInfoVO) blInfoVO;
			ChinaBlGeneralListVO generalVO = chinaBlInfoVO.getChinaBlGeneralListVO();
			ChinaBlCntrListVO[] cntrVOs = chinaBlInfoVO.getBlCntrListVOs();
			BkgCstmsChnCustVO[] custVOs = chinaBlInfoVO.getBkgCstmsChnCustVOs();
			ChinaBlDangerCntrListVO[] dgCntrVOs = chinaBlInfoVO.getBlDangerCntrListVOs();
			ChnBlKeyVO chnBlKeyVO = null;
			List<ChnBlKeyVO> blKeyVOs = new ArrayList<ChnBlKeyVO>();
			String blNo = generalVO.getBlNo();
			String transMode = generalVO.getChnMfSndIndCd();
			String usrId = account.getUsr_id();
			/*==============================================================*/
			/* B/L 기본 정보를 Update                                         */
			/*==============================================================*/
			/* Update SHA Manifest B/L 테이블								 */
			/*==============================================================*/
			// BKG_CSTMS_CHN_BL - TableVO 생성
			BkgCstmsChnBlVO bkgCstmsChnBlVO = new BkgCstmsChnBlVO();
			bkgCstmsChnBlVO.setBlNo(blNo);
			bkgCstmsChnBlVO.setChnMfSndIndCd(transMode);
			bkgCstmsChnBlVO.setBkgPolCd(generalVO.getBkgPolCd());
			bkgCstmsChnBlVO.setBkgPodCd(generalVO.getBkgPodCd());
			bkgCstmsChnBlVO.setPorCd(generalVO.getPorCd());
			bkgCstmsChnBlVO.setPolCd(generalVO.getPolCd());
			bkgCstmsChnBlVO.setPodCd(generalVO.getPodCd());
			bkgCstmsChnBlVO.setDelCd(generalVO.getDelCd());
			bkgCstmsChnBlVO.setBlIssDt(generalVO.getBlIssDt());
			bkgCstmsChnBlVO.setBlObrdDt(generalVO.getBlObrdDt());
			bkgCstmsChnBlVO.setChnCstmsTrspModCd(generalVO.getTrspModId());
			bkgCstmsChnBlVO.setRcvTermCd(generalVO.getRcvTermCd());
			bkgCstmsChnBlVO.setDeTermCd(generalVO.getDeTermCd());
			bkgCstmsChnBlVO.setFrtTermCd(generalVO.getFrtTermCd());
			bkgCstmsChnBlVO.setCstmsDesc(generalVO.getCstmsDesc());
			bkgCstmsChnBlVO.setPckQty(generalVO.getPckQty());
			bkgCstmsChnBlVO.setPckTpCd(generalVO.getPckTpCd());
			bkgCstmsChnBlVO.setActWgt(generalVO.getActWgt());
			bkgCstmsChnBlVO.setWgtUtCd(generalVO.getWgtUtCd());
			bkgCstmsChnBlVO.setMeasQty(generalVO.getMeasQty());
			bkgCstmsChnBlVO.setMeasUtCd(generalVO.getMeasUtCd());
			bkgCstmsChnBlVO.setUpdUsrId(usrId);
			dbDao.modifyBlGeneral(bkgCstmsChnBlVO);
			/**
			 * [TO-BE] BKG_CSTMS_CHN_RF 테이블 분리로 로직 추가
			 * Temp Unit 이 'F'-> FDO_TEMP, 'C'-> CDO_TEMP 에 Temp 데이터 저장
			 */
			// BKG_CSTMS_CHN_RF - TableVO 생성
			BkgCstmsChnRfVO bkgCstmsChnRfVO = new BkgCstmsChnRfVO();
			String tempUnit = generalVO.getTempUnit();
			if ("F".equals(tempUnit)) {
				bkgCstmsChnRfVO.setFdoTemp(generalVO.getTemp());
			}else {
				bkgCstmsChnRfVO.setCdoTemp(generalVO.getTemp());
			}
			bkgCstmsChnRfVO.setBlNo(blNo);
			bkgCstmsChnRfVO.setChnMfSndIndCd(transMode);
			bkgCstmsChnRfVO.setRfSeqNo(generalVO.getRfSeqNo());
			bkgCstmsChnRfVO.setCreUsrId(usrId);
			bkgCstmsChnRfVO.setUpdUsrId(usrId);
			chnBlKeyVO = new ChnBlKeyVO();
			// 조회 데이터
			chnBlKeyVO.setTransMode(transMode);
			chnBlKeyVO.setBkgCgoTpCd(generalVO.getBkgCgoTpCd());
			chnBlKeyVO.setUsrId(usrId);
			chnBlKeyVO.setBkgNo("'"+generalVO.getBkgNo() +"'");
			blKeyVOs.add(chnBlKeyVO);
			List<BkgCstmsChnRfVO> bkgCstmsChnRfVOs = dbDao.searchCntrRfList( blKeyVOs);
			if (bkgCstmsChnRfVOs.size() > 0) {
				// 테이블에 해당 B/L 정보가 있으면 Update, 없으면 Insert
				dbDao.modifyBlReeferCntr(bkgCstmsChnRfVO);
			}
			/*==============================================================*/
			/* MARKS 정보를 Update	 */
			/*==============================================================*/
			/* Marks 정보는 삭제 후 Insert로 Update를 수행						 */
			/* 입력된 Marks 정보가 없으면 수행 안함						 */
			/*==============================================================*/
			if (!"".equals(generalVO.getBlMkDesc())) {
				dbDao.removeBlMarkDesc(blNo, transMode);
				// BKG_CSTMS_CHN_MK - TableVO 생성
				BkgCstmsChnMkVO bkgCstmsChnMkVO = new BkgCstmsChnMkVO();
				bkgCstmsChnMkVO.setBlNo(blNo);
				bkgCstmsChnMkVO.setChnMfSndIndCd(transMode);
				bkgCstmsChnMkVO.setBlMkDesc(generalVO.getBlMkDesc());
				bkgCstmsChnMkVO.setCreUsrId(usrId);
				bkgCstmsChnMkVO.setUpdUsrId(usrId);
				dbDao.addBlMarkDesc(bkgCstmsChnMkVO);
			}
			/*==============================================================*/
			/* B/L별 Container, AK CNTR  정보 Update	 */
			/*==============================================================*/
			/* Container 관련 정보도 삭제 후 Insert로 Update 수행(Awkward)		 */
			/*==============================================================*/
			dbDao.removeBlCntr(blNo, transMode);
			dbDao.removeBlAwkardCntr(blNo, transMode);
			if (cntrVOs != null) {
				// Insert 를 위한 TableVO 변수
				List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs	= new ArrayList<BkgCstmsChnCntrVO>();
				List<BkgCstmsChnAwkVO>  bkgCstmsChnAwkVOs	= new ArrayList<BkgCstmsChnAwkVO>();
				List<BkgCstmsSealNoVO>  bkgCstmsSealNoVOs	= new ArrayList<BkgCstmsSealNoVO>();
				BkgCstmsChnCntrVO		bkgCstmsChnCntrVO	= null;
				BkgCstmsChnAwkVO		bkgCstmsChnAwkVO	= null;
				BkgCstmsSealNoVO		bkgCstmsSealNoVO	= null;
				//BkgCstmsSealNoVO[]	arrSealNoVO = null;
				StringBuffer strAwk = new StringBuffer();
				ChinaBlCntrListVO cntrVO = null;
				for(int i=0; i<cntrVOs.length; i++) {
					cntrVO = cntrVOs[i];
					// Delete한 Row는 제외
					if ("D".equals(cntrVO.getIbflag())) continue;
					// BKG_CSTMS_CHN_CNTR - TableVO 생성
					bkgCstmsChnCntrVO = new BkgCstmsChnCntrVO();
					// TableVO 에 저장 데이터 셋팅
					bkgCstmsChnCntrVO.setChnMfSndIndCd(transMode);
					bkgCstmsChnCntrVO.setBlNo(blNo);
					bkgCstmsChnCntrVO.setCntrNo(cntrVO.getCntrNo());
					bkgCstmsChnCntrVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
					bkgCstmsChnCntrVO.setFullMtyCd(cntrVO.getFullMtyCd());
					bkgCstmsChnCntrVO.setCntrWgt(cntrVO.getCntrWgt());
					bkgCstmsChnCntrVO.setWgtUtCd(cntrVO.getWgtUtCd());
					bkgCstmsChnCntrVO.setCntrMeasQty(cntrVO.getCntrMeasQty());
					bkgCstmsChnCntrVO.setMeasUtCd(cntrVO.getMeasUtCd());
					bkgCstmsChnCntrVO.setPckQty(cntrVO.getPckQty());
					bkgCstmsChnCntrVO.setPckTpCd(cntrVO.getPckTpCd());
					bkgCstmsChnCntrVO.setCreUsrId(usrId);
					bkgCstmsChnCntrVO.setUpdUsrId(usrId);
					// TableVO List에 등록
					bkgCstmsChnCntrVOs.add(bkgCstmsChnCntrVO);
					/**
					 * Awkward Cargo 이나 Awkward 정보가 없는 경우 Insert 안 함
					 */
					strAwk.delete(0, strAwk.length());
					strAwk.append(cntrVO.getOvrDimFntLen())
							.append(cntrVO.getOvrDimRearLen())
							.append(cntrVO.getOvrHgt())
							.append(cntrVO.getOvrDimLfLen())
							.append(cntrVO.getOvrDimRtLen());
					if (!"".equals(strAwk.toString())) {
						// BKG_CSTMS_CHN_AWK - TableVO 생성
						bkgCstmsChnAwkVO = new BkgCstmsChnAwkVO();
						// TableVO 에 저장 데이터 셋팅
						bkgCstmsChnAwkVO.setChnMfSndIndCd(transMode);
						bkgCstmsChnAwkVO.setBlNo(blNo);
						bkgCstmsChnAwkVO.setCntrNo(cntrVO.getCntrNo());
						bkgCstmsChnAwkVO.setOvrDimFntLen(cntrVO.getOvrDimFntLen());
						bkgCstmsChnAwkVO.setOvrDimRearLen(cntrVO.getOvrDimRearLen());
						bkgCstmsChnAwkVO.setOvrHgt(cntrVO.getOvrHgt());
						bkgCstmsChnAwkVO.setOvrDimLfLen(cntrVO.getOvrDimLfLen());
						bkgCstmsChnAwkVO.setOvrDimRtLen(cntrVO.getOvrDimRtLen());
						bkgCstmsChnAwkVO.setCreUsrId(usrId);
						bkgCstmsChnAwkVO.setUpdUsrId(usrId);
						// TableVO List에 등록
						bkgCstmsChnAwkVOs.add(bkgCstmsChnAwkVO);
					}
					/**
					 * [TO-BE] SEAL NO 테이블 분리로 로직 추가
					 * Seal No 정보가 있으면 저장
					 */
					if (!"".equals(cntrVO.getSealNo())) {
						// BKG_CSTMS_SEAL_NO - TableVO 생성
						bkgCstmsSealNoVO = new BkgCstmsSealNoVO();
						// TableVO 에 저장 데이터 셋팅
						bkgCstmsSealNoVO.setCntCd(CountryCode.CN);
						bkgCstmsSealNoVO.setBlNo(blNo);
						bkgCstmsSealNoVO.setCntrNo(cntrVO.getCntrNo());
						bkgCstmsSealNoVO.setSealNo(cntrVO.getSealNo());
						bkgCstmsSealNoVO.setSealKndCd(cntrVO.getSealKndCd());
						bkgCstmsSealNoVO.setSealPtyTpCd(cntrVO.getSealPtyTpCd());
						bkgCstmsSealNoVO.setSealPtyNm(cntrVO.getSealPtyNm());
						bkgCstmsSealNoVO.setCreUsrId(usrId);
						bkgCstmsSealNoVO.setUpdUsrId(usrId);
						/**
						 * Container에 해당하는 Seal No 를 Insert, Update 할 TableVO List에 등록
						 */
						bkgCstmsSealNoVOs.add(bkgCstmsSealNoVO);
					}
				}// for end : cntrVOs
				dbDao.addBlCntr(bkgCstmsChnCntrVOs);
				if (bkgCstmsChnAwkVOs.size() > 0) {
					for(int i=0; i<bkgCstmsChnAwkVOs.size(); i++) {
						if (dbDao.searchPKBlAwkardCntr(bkgCstmsChnAwkVOs.get(i)) == 0) {
							dbDao.addBlAwkardCntr(bkgCstmsChnAwkVOs.get(i));
						}
					}
				}
				// Insert 할 Seal No 정보가 있는지 확인 후 저장
				if (bkgCstmsSealNoVOs.size() > 0) {
				for(int i=0; i<bkgCstmsSealNoVOs.size(); i++) {
					bkgCstmsSealNoVO = bkgCstmsSealNoVOs.get(i);
						// Container 에 해당하는 Seal No 가 없으면 Insert
						if (dbDao.modifyBlCntrSeal(bkgCstmsSealNoVO) < 1) {
							dbDao.addBlCntrSeal(bkgCstmsSealNoVO);
						}
				}
				}
			}// if end : cntrVOs
			/*==============================================================*/
			/* B/L별 Customer 정보 Update	 */
			/*==============================================================*/
			if (custVOs != null) {
				// BKG_CSTMS_CHN_CUST - TableVO 넘김
				for(int i=0; i<custVOs.length; i++) {
					custVOs[i].setUpdUsrId(usrId);
					dbDao.modifyBlCust(custVOs[i]);
				}
			}
			/*==============================================================*/
			/* B/L별 Dangerous Cargo  정보 Update	 */
			/*==============================================================*/
			/* Dangerous 정보도 Delete후 Insert로 Update 수행					 */
			/*==============================================================*/
			dbDao.removeBlDangerCntr(blNo, transMode);
			if (dgCntrVOs != null) {
				List<BkgCstmsChnDgCgoVO> bkgCstmsChnDgCgoVOList = new ArrayList<BkgCstmsChnDgCgoVO>();
				BkgCstmsChnDgCgoVO bkgCstmsChnDgCgoVO = null;
				ChinaBlDangerCntrListVO dgCntrVO = null;
				for(int i=0; i<dgCntrVOs.length; i++) {
					dgCntrVO = dgCntrVOs[i];
					// Delete한 Row는 제외
					if ("I".equals(dgCntrVO.getIbflag()) || "U".equals(dgCntrVO.getIbflag())) {
						// BKG_CSTMS_CHN_DG_CGO - TableVO 생성
						bkgCstmsChnDgCgoVO = new BkgCstmsChnDgCgoVO();
						// TableVO 에 저장 데이터 셋팅
						bkgCstmsChnDgCgoVO.setChnMfSndIndCd(transMode);
						bkgCstmsChnDgCgoVO.setBlNo(blNo);
						bkgCstmsChnDgCgoVO.setCntrNo(dgCntrVO.getCntrNo());
						bkgCstmsChnDgCgoVO.setImdgUnNo(dgCntrVO.getImdgUnNo());
						bkgCstmsChnDgCgoVO.setImdgClssCd(dgCntrVO.getImdgClssCd());
						//bkgCstmsChnDgCgoVO.setImdgPgNo(dgCntrVO.getImdgPgNo());
						bkgCstmsChnDgCgoVO.setImdgSubsRskLblCd(dgCntrVO.getImdgSubsRskLblCd());
						bkgCstmsChnDgCgoVO.setCreUsrId(usrId);
						bkgCstmsChnDgCgoVO.setUpdUsrId(usrId);
						// TableVO List에 등록
						bkgCstmsChnDgCgoVOList.add(bkgCstmsChnDgCgoVO);
					}
				}
				if (bkgCstmsChnDgCgoVOList.size() > 0) dbDao.addBlDangerCntr(bkgCstmsChnDgCgoVOList);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 세관 테이블의 Customer, Container 등의 BL 정보를 삭제한다
	 *
	 * @param ChinaBlInfoListVO[] chinaBlInfoListVOs
	 * @exception EventException
	 */
	public void manageBlByVvd(ChinaBlInfoListVO[] chinaBlInfoListVOs) throws EventException {
		try {
			String transMode = chinaBlInfoListVOs[0].getTransMode();
			String blNo = "";
			for(int i=0; i<chinaBlInfoListVOs.length; i++) {
				blNo = chinaBlInfoListVOs[i].getBlNo();
				dbDao.removeBlGeneral(blNo, transMode);
				dbDao.removeBlCust(blNo, transMode);
				dbDao.removeBlCntr(blNo, transMode);
				dbDao.removeBlAwkardCntr(blNo, transMode);
				dbDao.removeBlDangerCntr(blNo, transMode);
				dbDao.removeBlReeferCntr(blNo, transMode);
				dbDao.removeBlMarkDesc(blNo, transMode);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * B/L 정보를 수정한다.<br>
	 *
	 * @param List<TransKeyVO> transKeyVOs
	 * @exception EventException
	 */
	public void modifyBl( List<TransKeyVO> transKeyVOs) throws EventException {
		try {
			dbDao.modifyBl(transKeyVOs);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * B/L 테이블에 전송 내역 데이터를 업데이트한다.<br>
	 *
	 * @param List<TransKeyVO> transKeyVOs
	 * @param String pol
	 * @exception EventException
	 */
	public void modifyBl2( List<TransKeyVO> transKeyVOs, String pol) throws EventException {
		try {
			dbDao.modifyBl2(transKeyVOs, pol);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * VVD 테이블에 전송 내역 데이터를 업데이트한다.<br>
	 *
	 * @param TransKeyVO transKeyVO
	 * @param String pol
	 * @exception EventException
	 */
	public void modifyVvd( TransKeyVO transKeyVO, String pol) throws EventException {
		try {
			dbDao.modifyVvd(transKeyVO, pol);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508]
	 * Vessel Registration 목록 조회<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @return List<VslRgstVO>
	 * @exception EventException
	 */
	public List<ChinaVslRgstVO> searchChinaVslRgst(ChinaVslRgstVO chinaVslRgstVO) throws EventException {
		List<ChinaVslRgstVO> chinaVslRgstVOList = null;
		try {
			if ("PORT".equals(chinaVslRgstVO.getSearchDiv())) {
				chinaVslRgstVOList = dbDao.searchVslRgstFromVskPortSkd(chinaVslRgstVO);
			} else if ("PUBLIC".equals(chinaVslRgstVO.getSearchDiv())) {
				chinaVslRgstVOList = dbDao.searchVslRgstFromChnCorrVvd(chinaVslRgstVO);
			}
			return chinaVslRgstVOList;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508]
	 * Vessel Registration 목록 저장<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @param ChinaVslRgstVO[] chinaVslRgstVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChinaVslRgst(ChinaVslRgstVO chinaVslRgstVO, ChinaVslRgstVO[] chinaVslRgstVOs, SignOnUserAccount account) throws EventException {
		List<ChinaVslRgstVO> insertVoList = new ArrayList<ChinaVslRgstVO>();
		List<ChinaVslRgstVO> updateVoList = new ArrayList<ChinaVslRgstVO>();
		List<ChinaVslRgstVO> deleteVoList = new ArrayList<ChinaVslRgstVO>();
		try {
			for(ChinaVslRgstVO saveVO : chinaVslRgstVOs) {
				saveVO.setPortCd(chinaVslRgstVO.getPortCd());
				saveVO.setUsrId(account.getUsr_id());
				if ("PORT".equals(chinaVslRgstVO.getSearchDiv())) {
					deleteVoList.add(saveVO);    // delete후 insert 목적
					insertVoList.add(saveVO);
				} else {
					if ("I".equals(saveVO.getIbflag())) {
						deleteVoList.add(saveVO);    // delete후 insert 목적
						insertVoList.add(saveVO);
					} else if ("U".equals(saveVO.getIbflag())) {
						updateVoList.add(saveVO);
					} else if ("D".equals(saveVO.getIbflag())) {
						deleteVoList.add(saveVO);
					}
				}
			}
			if (updateVoList.size() > 0) dbDao.modifyChinaVslRgst(updateVoList);
			// delete후 insert에 유의
			if (deleteVoList.size() > 0) dbDao.removeChinaVslRgst(deleteVoList);
			if (insertVoList.size() > 0) dbDao.addChinaVslRgst(insertVoList);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}

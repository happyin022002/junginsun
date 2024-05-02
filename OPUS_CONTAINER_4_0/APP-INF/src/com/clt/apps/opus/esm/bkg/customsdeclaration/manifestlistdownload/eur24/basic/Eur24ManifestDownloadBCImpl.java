/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Eur24ManifestDownloadBCImpl.java
 *@FileTitle : Eur24ManifestDownloadBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.19 김경섭
 * 1.0 Creation
 *------------------------------------------------------
 * History
 * 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
 * 2011.04.05 이재위 [CHM-201109537-01] [BKG] Manifest : ENS Monotiring Function화면 개발 
 * 2012.03.05 김보배 [CHM-201216338] [BKG] [EXS- ES, PT] BL inquiry Prev. Doc 컬럼 추가
 * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
 * 2012.06.25 김보배 [CHM-201218404] [BKG] [EXS] "Hold Release" Manual Update 기능
 * 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
 * 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration.Eur24CustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration.Eur24ManifestDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrMFListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrSealNoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlGeneralInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 *Eur24ManifestDownloadBCImpl Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public class Eur24ManifestDownloadBCImpl extends BasicCommandSupport implements Eur24ManifestDownloadBC {
	// Database Access Object
	private transient Eur24ManifestDownloadDBDAO dbDao = null;
	private transient Eur24CustomsTransmissionDBDAO dbTransDao = null;

	/**
	 * Eur24ManifestDownloadBCImpl 객체 생성<br>
	 */
	public Eur24ManifestDownloadBCImpl(){
		dbDao = new Eur24ManifestDownloadDBDAO();
		dbTransDao = new Eur24CustomsTransmissionDBDAO();
	}
	
	/**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException {
		try{
			/* 조회로직 변경으로 BL No로만 조회는 UI에서 먼저 VVD 및 Pofe를 가져와 조회한다.
			if(JSPUtil.getNull(((EurManifestListCondVO)manifestListCondVO).getPVvdCd()).equals("")){
				List<ManifestListDetailVO> list = dbDao.search1stEUvvdByBL(manifestListCondVO);
				
				if(JSPUtil.getNull(((EurManifestListCondVO)manifestListCondVO).getPBlNo()).equals("") ) return new ArrayList<ManifestListDetailVO>();
				if(list.size() == 0 ) return new ArrayList<ManifestListDetailVO>();
				
				Eu24ManifestListVO vo = (Eu24ManifestListVO)list.get(0);
				((EurManifestListCondVO)manifestListCondVO).setPVvdCd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
				((EurManifestListCondVO)manifestListCondVO).setPPodCd(vo.getEu1stPort());
				((EurManifestListCondVO)manifestListCondVO).setPPodYardCd(vo.getEu1stPortYdCd());
				((EurManifestListCondVO)manifestListCondVO).setPPolCd(vo.getPol());
				((EurManifestListCondVO)manifestListCondVO).setPPolYardCd(vo.getPolYdCd());
				
			}
			*/

			return dbDao.searchEur24BlManifestList(manifestListCondVO,account);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	 
	/**
	 * ENS쪽 정보를 세관쪽 테이블로 저장한다.(BKG_CSTMS_EUR_BL,BKG_CSTMS_EUR_CNTR,BKG_CSTMS_EUR_CNTR_MF,BKG_CSTMS_EUR_DG_CGO,BKG_CSTMS_EUR_SEAL_NO,BKG_CSTMS_EUR_CUST) <br>
	 * 
	 * @param manifestListDetailVOs ManifestListDetailVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException {
		if (manifestListDetailVOs == null || manifestListDetailVOs.length == 0) return "";
		
		Eu24ManifestListVO[] eu24ManifestListVOs = new Eu24ManifestListVO[1];
		eu24ManifestListVOs[0] = (Eu24ManifestListVO)manifestListDetailVOs[0]; 
		eu24ManifestListVOs[0].setCreUsrId(account.getUsr_id());
		try {
			dbDao.removeBkgCstmsEu24Bl(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24Cntr(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24CntrMf(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24CntrSeal(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24Cust(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24DgCntr(eu24ManifestListVOs);

			dbDao.addBkgCstmsEu24Bl(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24Cntr(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24CntrMf(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24CntrSeal(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24Cust(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24DgCntr(eu24ManifestListVOs);;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "Y";
	}
	
	/**
	 * ENS쪽 정보를 세관쪽 테이블에서 삭제한다.(BKG_CSTMS_EUR_BL,BKG_CSTMS_EUR_CNTR,BKG_CSTMS_EUR_CNTR_MF,BKG_CSTMS_EUR_DG_CGO,BKG_CSTMS_EUR_SEAL_NO,BKG_CSTMS_EUR_CUST) <br>
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @exception EventException
	 */
	public String deleteManifest(ManifestListDetailVO[] manifestListDetailVOs) throws EventException {
		
		Eu24ManifestListVO[] eu24ManifestListVOs = new Eu24ManifestListVO[1];
		eu24ManifestListVOs[0] = (Eu24ManifestListVO)manifestListDetailVOs[0];
		try { 
			dbDao.removeBkgCstmsEu24Bl(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24Cntr(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24CntrMf(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24CntrSeal(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24Cust(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24DgCntr(eu24ManifestListVOs);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "Y";
	}
	
	/**
	 * EXS 정보를 세관쪽 테이블에서 삭제한다.(BKG_CSTMS_EUR_BL,BKG_CSTMS_EUR_CNTR,BKG_CSTMS_EUR_CNTR_MF,BKG_CSTMS_EUR_DG_CGO,BKG_CSTMS_EUR_SEAL_NO,BKG_CSTMS_EUR_CUST) <br>
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @exception EventException
	 */
	public String deleteManifestEXS(ManifestListDetailVO[] manifestListDetailVOs) throws EventException {
		
		Eu24ManifestListVO[] eu24ManifestListVOs = new Eu24ManifestListVO[1];
		eu24ManifestListVOs[0] = (Eu24ManifestListVO)manifestListDetailVOs[0];
		try {
			dbDao.removeBkgCstmsEu24OBBl(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCntr(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCntrMf(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCntrSeal(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCust(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBDgCntr(eu24ManifestListVOs);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "Y";
	}
	
	/**
	 * 구주 OB쪽 정보를 세관쪽 테이블로 저장한다.(BKG_CSTMS_EUR_IO_BL,BKG_CSTMS_EUR_IO_CNTR,BKG_CSTMS_EUR_IO_CNTR_MF,BKG_CSTMS_EUR_IO_DG_CGO,BKG_CSTMS_EUR_IO_SEAL_NO,BKG_CSTMS_EUR_IO_CUST) <br>
	 * 
	 * @param manifestListDetailVOs ManifestListDetailVO[]
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManifestOB(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException {
		if (manifestListDetailVOs == null || manifestListDetailVOs.length == 0) return "";
		
		Eu24ManifestListVO[] eu24ManifestListVOs = new Eu24ManifestListVO[1];
		eu24ManifestListVOs[0] = (Eu24ManifestListVO)manifestListDetailVOs[0]; 
		eu24ManifestListVOs[0].setCreUsrId(account.getUsr_id());
		try {
			dbDao.removeBkgCstmsEu24OBBl(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCntr(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCntrMf(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCntrSeal(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBCust(eu24ManifestListVOs);
			dbDao.removeBkgCstmsEu24OBDgCntr(eu24ManifestListVOs);

			dbDao.addBkgCstmsEu24OBBl(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24OBCntr(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24OBCntrMf(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24OBCntrSeal(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24OBCust(eu24ManifestListVOs);
			dbDao.addBkgCstmsEu24OBDgCntr(eu24ManifestListVOs);;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		return "Y";
	}	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @param SignOnUserAccount account
	 * @return Eur24BlInfoVO
	 * @throws EventException
	 */
	public Eur24BlInfoVO searchBlInfo(Eur24BlInfoCondVO eur24BlInfoCondVO, SignOnUserAccount account) throws EventException {
		try{
			// 파라메터 변환
			Eur24BlInfoCondVO condVO = (Eur24BlInfoCondVO)eur24BlInfoCondVO;
			// 리턴 VO
			Eur24BlInfoVO blInfoVO = new Eur24BlInfoVO();
			String blNo = condVO.getBlNo();
			String vvd = condVO.getVvd();
			if(JSPUtil.getNull(eur24BlInfoCondVO.getCstmsYdCd()) == "") return blInfoVO;
			String cstmsPortCd = eur24BlInfoCondVO.getCstmsYdCd().substring(0,5);
			String cstmsYdCd = eur24BlInfoCondVO.getCstmsYdCd();
			
			Eur24BlGeneralInfoVO eur24BlGeneralInfoVO = dbDao.searchBlGeneral(blNo, vvd, cstmsPortCd,cstmsYdCd, account);
			if(eur24BlGeneralInfoVO != null){
				//cstmsPortCd = eur24BlGeneralInfoVO.getCstmsPortCd();
				if(StringUtils.isEmpty(vvd))
					vvd = eur24BlGeneralInfoVO.getVvd();
				if(StringUtils.isEmpty(cstmsPortCd))
					cstmsPortCd = eur24BlGeneralInfoVO.getCstmsPortCd();
				blInfoVO.setEur24BlGeneralInfoVO(eur24BlGeneralInfoVO);
			}
			
			Eur24BlCustVO					eur24BlCustVO				= dbDao.searchBlCust(blNo, vvd, cstmsPortCd);
			List<Eur24BlCntrListVO>			eur24BlCntrListVOs			= dbDao.searchBlCntr(blNo, vvd, cstmsPortCd);
			List<Eur24BlDangerCntrListVO>	eur24BlDangerCntrListVOs 	= dbDao.searchBlDangerCntr(blNo, vvd, cstmsPortCd);
			List<Eur24BlCntrMFListVO>		eur24BlCntrMFListVOs 		= dbDao.searchBlCntrMF(blNo, vvd, cstmsPortCd);
			List<Eur24BlCntrSealNoListVO>	eur24BlCntrSealNoListVOs 	= dbDao.searchBlCntrSealNo(blNo, vvd, cstmsPortCd);
			
			if(eur24BlCustVO != null) blInfoVO.setEur24BlCustVO(eur24BlCustVO);
			blInfoVO.setEur24BlCntrListVOs(eur24BlCntrListVOs);
			blInfoVO.setEur24BlDangerCntrListVOs(eur24BlDangerCntrListVOs);
			blInfoVO.setEur24BlCntrMFListVOs(eur24BlCntrMFListVOs);
			blInfoVO.setEur24BlCntrSealNoListVOs(eur24BlCntrSealNoListVOs);
			return (Eur24BlInfoVO)blInfoVO;
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}	

	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @param SignOnUserAccount account
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselArrival(Eur24VesselArrivalCondVO vesselArrivalCondVO, SignOnUserAccount account) throws EventException {
		try{
			return dbDao.searchVesselArrival(vesselArrivalCondVO, account);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselByBL(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		try{
			return dbDao.searchVesselByBL(vesselArrivalCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 입력한다.
	 * 
	 * @param Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageVesselArrival(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			HashMap<String, String> originalHm = eur24VesselArrivalNoticeDetailVO.getColumnValues();

			String flag = originalHm.get("ibflag");
			List<Eur24VesselArrivalNoticeDetailVO> crnList = dbDao.searchCRN(eur24VesselArrivalNoticeDetailVO);
			for(VesselArrivalDetailVO vo : crnList){
				if(vo == null) continue;

				HashMap<String, String> hm =  vo.getColumnValues();
				if(!originalHm.get("vsl_cd").equals(hm.get("vsl_cd")) ||
						!originalHm.get("skd_voy_no").equals(hm.get("skd_voy_no")) ||
						!originalHm.get("skd_dir_cd").equals(hm.get("skd_dir_cd"))){
					throw new EventException(new ErrorHandler("BKG01027").getMessage());
				}
			}
			
			// ENS ETA 가 변경된 경우에만 해당 값 업데이트
			String ensEtaflag = originalHm.get("init_eta_dt_modi_flg");
			if(!ensEtaflag.equals("N")){
				dbDao.modifyArrivalNoticeEnsEta(eur24VesselArrivalNoticeDetailVO, account);
			}
			
			if(flag.equals("I"))
				dbDao.addArrivalNotice(eur24VesselArrivalNoticeDetailVO, account);
			else
				dbDao.modifyArrivalNotice(eur24VesselArrivalNoticeDetailVO, account);
			
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvd(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			if(dbDao.searchENSBL(manifestListCondVO).size() > 0 ){
				return dbDao.searchEU24ENSPOFEbyVVD(manifestListCondVO);
			}
			return dbDao.searchEu1stPortByVvd(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.
	  * Arrival Notice용<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvdForAN(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			return dbDao.searchEu1stPortByVvd(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	 
	 
	/**
	 * Europe Advanced Manifest - ENS Report 조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EnsListVO> searchENSReport(Eu24EnsListVO eu24EnsListVO) throws EventException  {
		try{
			/* 조회로직 변경으로 BL No로만 조회는 UI에서 먼저 VVD 및 Pofe를 가져와 조회한다.  
			if(JSPUtil.getNull(eu24EnsListVO.getPVvd()).equals("")    && 
			   JSPUtil.getNull(eu24EnsListVO.getPFromDt()).equals("") && 	
			   JSPUtil.getNull(eu24EnsListVO.getPToDt()).equals("")   && 	
			   !JSPUtil.getNull(eu24EnsListVO.getPBlNo()).equals("") ){
				EurManifestListCondVO pvo = new EurManifestListCondVO();
				pvo.setPBlNo(eu24EnsListVO.getPBlNo());
				List<ManifestListDetailVO> list = dbDao.search1stEUvvdByBL(pvo);
				if(list.size() == 0 )  return new ArrayList<Eu24EnsListVO>();
			
				Eu24ManifestListVO vo = (Eu24ManifestListVO)list.get(0);
				eu24EnsListVO.setPVvd(vo.getVslCd()+vo.getSkdVoyNo()+vo.getSkdDirCd());
				eu24EnsListVO.setPLane(vo.getSlanCd());
				//--yard_cd로만 조회해도 됨
				//eu24EnsListVO.setPPofe(vo.getEu1stPort());
				String tempyd ="";
				
				if(list.size() == 1 ){
					tempyd += ((Eu24ManifestListVO)list.get(0)).getEu1stPortYdCd();
				}else{
				
					for (int i = 0; i < list.size(); i++) {
						if(i == list.size() -1 )
							tempyd += "'"+((Eu24ManifestListVO)list.get(i)).getEu1stPortYdCd()+"'";
						else
							tempyd += "'"+((Eu24ManifestListVO)list.get(i)).getEu1stPortYdCd()+"',";
					}
					eu24EnsListVO.setPMultiPopeYn("Y");
				}
				eu24EnsListVO.setPPofeYd(tempyd);
				eu24EnsListVO.setPPol(vo.getPol());
				eu24EnsListVO.setPPolYd(vo.getPolYdCd());
				
			}
			*/
			return dbDao.searchENSReport(eu24EnsListVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	 
	
	/**
	 * Europe Advanced Manifest - ENS Monitoring 조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EnsListVO> searchENSMonitoring(Eu24EnsListVO eu24EnsListVO) throws EventException  {
		try{
			return dbDao.searchENSMonitoring(eu24EnsListVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	 
	
	 /**
	  * BL로 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> search1stEUvvdByBL(ManifestListCondVO manifestListCondVO) throws EventException {
			try{
				return dbDao.search1stEUvvdByBL(manifestListCondVO);
			}catch (DAOException ex){
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}catch (Exception ex){
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
	}	
	
	/**
	 * Europe Advanced Manifest - Europe Customs 등록 코드 조회<br>
	 * @param CustomsSetupVO customsSetupVO
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchCustomsSetupList(CustomsSetupVO customsSetupVO) throws EventException {	
		try{
			return dbDao.searchCustomsSetupList(customsSetupVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	 
	
	/**
	 * Europe Customs 코드를 관리한다.<br>
	 * @param CustomsSetupVO[] customsSetupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageEU24CustomsSetup(CustomsSetupVO[] customsSetupVOs,SignOnUserAccount account) throws EventException {
		try {
			//삭제 후 신규, 수정 작업을 한다. 
			for ( int i=0; i<customsSetupVOs.length; i++ ) {
				if ( customsSetupVOs[i].getIbflag().equals("D")){
					dbDao.removeCustomsSetup(customsSetupVOs[i]);
				}
			}
			
			BookingUtil bkgUtil = new BookingUtil();
			for ( int i=0; i<customsSetupVOs.length; i++ ) {
				customsSetupVOs[i].setCreUsrId(account.getUsr_id());
				customsSetupVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( customsSetupVOs[i].getIbflag().equals("I")){
					customsSetupVOs[i].setPPort(customsSetupVOs[i].getPortCd());
	                if(bkgUtil.searchMdmLocName(customsSetupVOs[i].getPortCd()).equals("")){ //입력시 PORT CD가 유효한지 확인
	                	throw new EventException(new ErrorHandler("BKG00651").getMessage().replaceAll("\\$s", "Port Code("+customsSetupVOs[i].getPortCd()+")"));
	                }
	                MdmYardVO mvo = new MdmYardVO();
	                mvo.setLocCd(customsSetupVOs[i].getPortCd());
	                mvo.setYdCd(customsSetupVOs[i].getTmlCd());
	                if(!customsSetupVOs[i].getTmlCd().equals("ALL") && bkgUtil.searchYardCode(mvo).size() < 1){ //TML 유효성 확인
	                    throw new EventException(new ErrorHandler("BKG00651").getMessage().replaceAll("\\$s", "Port Code("+customsSetupVOs[i].getPortCd()+")- Terminal("+customsSetupVOs[i].getTmlCd()+")"));
	                }
	                
	                if(customsSetupVOs[i].getTmlCd().equals("ALL")){//TML이 ALL이면 같은 PORT로 등록된것이 없어야 한다.
	                	if(dbDao.searchCustomsSetupList(customsSetupVOs[i]).size() > 0){
		                    throw new EventException(new ErrorHandler("COM12115").getMessage().replaceAll("\\(\\$s\\)", "Port Code("+customsSetupVOs[i].getPortCd()+") Terminal(ALL - Terminal must not exists but 'ALL') "));
		                }
	                }else{
	                	customsSetupVOs[i].setPTml("ALL");// ALL이 아니면 ALL이 이전에 등록 되어 있는지 확인
	                	if(dbDao.searchCustomsSetupList(customsSetupVOs[i]).size() > 0){
		                    throw new EventException(new ErrorHandler("COM12115").getMessage().replaceAll("\\(\\$s\\)", "Port Code("+customsSetupVOs[i].getPortCd()+") Terminal(ALL - 'ALL' already exists)"));
		                }
	                }
					customsSetupVOs[i].setPTml(customsSetupVOs[i].getTmlCd());//같은 터미널로 기등록 되어 있는지 검사
	                if(dbDao.searchCustomsSetupList(customsSetupVOs[i]).size() > 0){
	                    throw new EventException(new ErrorHandler("COM12115").getMessage().replaceAll("\\(\\$s\\)", "Port Code("+customsSetupVOs[i].getPortCd()+") Terminal("+customsSetupVOs[i].getTmlCd()+")"));
	                }
	                
					dbDao.addCustomsSetup(customsSetupVOs[i]);
				}
				
				if ( customsSetupVOs[i].getIbflag().equals("U")){
					/*
					// TERMINAL이 기존에는 키값이 아이어서 체크를 하였으나 현재는 키값이므로 수정되지 않는다. 따라서 유효성 체크는 안해도 된다.
	                MdmYardVO mvo = new MdmYardVO();
	                mvo.setLocCd(customsSetupVOs[i].getPortCd());
	                if(!customsSetupVOs[i].getTmlCd().equals("ALL")){
	                		mvo.setYdCd(customsSetupVOs[i].getTmlCd());
	                }
	                if(bkgUtil.searchYardCode(mvo).size() < 1){
	                    throw new EventException(new ErrorHandler("BKG00651").getMessage().replaceAll("\\$s", "Port Code("+customsSetupVOs[i].getPortCd()+")- Terminal("+customsSetupVOs[i].getTmlCd()+")"));
	                }

	                */
					dbDao.modifyCustomsSetup(customsSetupVOs[i]);
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * MDM LOCATION 조회<br>
	 * 
	 * @param String cntCd
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchMdmLocationPort(String cntCd) throws EventException {
		try{
			return dbDao.searchMdmLocationPort(cntCd);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	 
	
	/**
	 * MDM YARD 조회<br>
	 * @param String portCd
	 * @return List<CustomsSetupVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchMdmYardTmlcode(String portCd) throws EventException{
		try{
			return dbDao.searchMdmYardTmlcode(portCd);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * @param  String blNo 
	 * @param  String vvd 
	 * @param  String cntrNo 
	 * @return List<Eur24BlCntrMFListVO>
	 * @throws EventException
	 */
	public List<Eur24BlCntrMFListVO> searchContainerMF(String blNo, String vvd, String cntrNo) throws EventException {
		try{
			return dbDao.searchBlCntrMF(blNo, vvd, cntrNo);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24BlInfoVO eur24BlInfoVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void manageBlInfo(Eur24BlInfoVO eur24BlInfoVO, SignOnUserAccount account) throws EventException {
		try {
			Eur24BlGeneralInfoVO general = eur24BlInfoVO.getEur24BlGeneralInfoVO();
			dbDao.modifyBlInfo(general, account);

			Eur24BlCustVO cust = eur24BlInfoVO.getEur24BlCustVO();
			dbDao.addBlCust(cust, account);
			dbDao.modifyBlCust(cust, account);
			dbDao.removeBlCust(cust, account);
			List<Eur24BlCntrListVO> eur24BlCntrListVOs = eur24BlInfoVO.getEur24BlCntrListVOs();

			for(Eur24BlCntrListVO cntr : eur24BlCntrListVOs){
				String ibFlag = cntr.getIbflag();
				if(ibFlag.equals("D"))	dbDao.removeBlCntr(cntr, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntr(cntr, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntr(cntr, account);
			}
			List<Eur24BlCntrMFListVO> eur24BlCntrMFListVOs = eur24BlInfoVO.getEur24BlCntrMFListVOs();
			for(Eur24BlCntrMFListVO cntrMF : eur24BlCntrMFListVOs){
				String ibFlag = cntrMF.getIbflag();
				if(ibFlag.equals("D"))	dbDao.removeBlCntrMF(cntrMF, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrMF(cntrMF, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrMF(cntrMF, account);
			}
			
			List<Eur24BlDangerCntrListVO> eur24BlDangerCntrListVOs = eur24BlInfoVO.getEur24BlDangerCntrListVOs();
			for(Eur24BlDangerCntrListVO danger : eur24BlDangerCntrListVOs){
				String ibFlag = danger.getIbflag();
				if(ibFlag.equals("D"))	dbDao.removeBlCntrDanger(danger, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrDanger(danger, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrDanger(danger, account);
			}
			
			List<Eur24BlCntrSealNoListVO> eur24BlCntrSealNoListVOs = eur24BlInfoVO.getEur24BlCntrSealNoListVOs();
			for(Eur24BlCntrSealNoListVO seal : eur24BlCntrSealNoListVOs){
				String ibFlag = seal.getIbflag();
				seal.setVvd(general.getVvd());
				seal.setCstmsPortCd(general.getCstmsPortCd());
				seal.setBlNo(general.getBlNo());

				if(ibFlag.equals("D"))	dbDao.removeBlCntrSealNo(seal, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrSealNo(seal, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrSealNo(seal, account);
			}
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}

	/**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24RcvMsgVO>  
	 * @throws EventException
	 * @exception EventException
	 */
	public List<Eur24RcvMsgVO> searchCstmsRcvMsg(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		try{
			return dbDao.searchCstmsRcvMsg(vesselArrivalCondVO);
	    }catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	/**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param String rvis_n1st_clpt_cd  
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException 
	 * @exception EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchCstmsOfficeIdByPort(String rvis_n1st_clpt_cd) throws EventException {
		try{
			return dbDao.searchCstmsOfficeIdByPort(rvis_n1st_clpt_cd);
	    }catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	
	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryVO> searchEU24EDIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws EventException  {
		try{
			return dbDao.searchEU24EDIHistory(eU24EDIHistoryVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryVO> searchEU24EDIFIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws EventException  {
		try{
			return dbDao.searchEU24EDIFIHistory(eU24EDIHistoryVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ENS화면 - POL이 EU 포트인지 체크를 위해 EU포트 조회<br>
	 * @param Eu24CountryListVO eu24CountryListVO
	 * @return List<Eu24CountryListVO>
	 * @throws DAOException
	 */
	public List<Eu24CountryListVO> searchEU24CountryList (Eu24CountryListVO  eu24CountryListVO) throws EventException  {
		try{
			return dbDao.searchEU24CountryList(eu24CountryListVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Europe Advanced Manifest-Error Code Table 조회<br>
	 * @param EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO
	 * @return List<EU24RcvErrorCodeTableVO>
	 * @throws EventException
	 */
	public List<EU24RcvErrorCodeTableVO> searchEU24RcvErrorCodeTable(EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO) throws EventException {
		try{
			return dbDao.searchEU24RcvErrorCodeTable(eU24RcvErrorCodeTableVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchCstmsENSPofeList(ManifestListCondVO manifestListCondVO) throws EventException  {
		try{
			return dbDao.searchCstmsENSPofeList(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEuPolByVvd(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			return dbDao.searchEuPolByVvd(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * 
	 * @param manifestListCondVO 조건
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestOBList(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			return dbDao.searchEur24BlManifestOBList(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	
	 /**
	  * EXS용(1121) BL 정보 조회를 위해 BL_NO로 VVD,POL,POD 등을 먼저 조회한다.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchEuOBVvdByBL(ManifestListCondVO manifestListCondVO) throws EventException {
			try{
				return dbDao.searchEuOBVvdByBL(manifestListCondVO);
			}catch (DAOException ex){
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}catch (Exception ex){
				throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
			}
	}	
	
	/**
	 * Europe Advanced Manifest - EXS Report 조회<br>
	 * 
	 * @param Eu24ExsListOBVO eu24ExsListOBVO
	 * @return List<Eu24ExsListOBVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24ExsListOBVO> searchEXSReportOB(Eu24ExsListOBVO eu24ExsListOBVO) throws EventException  {
		try{
			return dbDao.searchEXSReportOB(eu24ExsListOBVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	 
	/**
	 * Transmit / Receive History 조회<br>
	 * 
	 * @param EU24EDIHistoryOBVO eU24EDIHistoryOBVO
	 * @return List<EU24EDIHistoryOBVO>
	 * @throws EventException
	 */
	public List<EU24EDIHistoryOBVO> searchEU24EDIHistoryOB(EU24EDIHistoryOBVO eU24EDIHistoryOBVO) throws EventException {
		try{
			return dbDao.searchEU24EDIHistoryOB(eU24EDIHistoryOBVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24RcvMsgVO>  
	 * @throws EventException
	 * @exception EventException
	 */
	public List<Eur24RcvMsgVO> searchCstmsRcvMsgOB(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		try{
			return dbDao.searchCstmsRcvMsgOB(vesselArrivalCondVO);
	    }catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @return Eur24BlInfoVO
	 * @throws EventException
	 */
	public Eur24BlInfoVO searchBlInfoOB(Eur24BlInfoCondVO eur24BlInfoCondVO) throws EventException {
		try{
			// 파라메터 변환
			Eur24BlInfoCondVO condVO = (Eur24BlInfoCondVO)eur24BlInfoCondVO;
			// 리턴 VO
			Eur24BlInfoVO blInfoVO = new Eur24BlInfoVO();
			
			String blNo = condVO.getBlNo();
			String vvd = condVO.getVvd();
			if(JSPUtil.getNull(eur24BlInfoCondVO.getCstmsYdCd()) == "") return blInfoVO;
			String cstmsPortCd = eur24BlInfoCondVO.getCstmsYdCd().substring(0,5);
			String cstmsYdCd = eur24BlInfoCondVO.getCstmsYdCd();

			Eur24BlGeneralInfoVO eur24BlGeneralInfoVO = dbDao.searchBlGeneralOB(blNo, vvd, cstmsPortCd,cstmsYdCd);
			if(eur24BlGeneralInfoVO != null){
				//cstmsPortCd = eur24BlGeneralInfoVO.getCstmsPortCd();
				if(StringUtils.isEmpty(vvd))
					vvd = eur24BlGeneralInfoVO.getVvd();
				if(StringUtils.isEmpty(cstmsPortCd))
					cstmsPortCd = eur24BlGeneralInfoVO.getCstmsPortCd();
				blInfoVO.setEur24BlGeneralInfoVO(eur24BlGeneralInfoVO);
			}
			
			Eur24BlCustVO					eur24BlCustVO				= dbDao.searchBlCustOB(blNo, vvd, cstmsPortCd);
			List<Eur24BlCntrListVO>			eur24BlCntrListVOs			= dbDao.searchBlCntrOB(blNo, vvd, cstmsPortCd);
			List<Eur24BlDangerCntrListVO>	eur24BlDangerCntrListVOs 	= dbDao.searchBlDangerCntrOB(blNo, vvd, cstmsPortCd);
			List<Eur24BlCntrMFListVO>		eur24BlCntrMFListVOs 		= dbDao.searchBlCntrMFOB(blNo, vvd, "", cstmsPortCd);
			List<Eur24BlCntrSealNoListVO>	eur24BlCntrSealNoListVOs 	= dbDao.searchBlCntrSealNoOB(blNo, vvd, cstmsPortCd, "");
			
			if(eur24BlCustVO != null) blInfoVO.setEur24BlCustVO(eur24BlCustVO);
			blInfoVO.setEur24BlCntrListVOs(eur24BlCntrListVOs);
			blInfoVO.setEur24BlDangerCntrListVOs(eur24BlDangerCntrListVOs);
			blInfoVO.setEur24BlCntrMFListVOs(eur24BlCntrMFListVOs);
			blInfoVO.setEur24BlCntrSealNoListVOs(eur24BlCntrSealNoListVOs);
			return (Eur24BlInfoVO)blInfoVO;
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselByBLOB(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		try{
			return dbDao.searchVesselByBLOB(vesselArrivalCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * 세관 테이블에 Customer, Container, Container MF, DG Cargo 등의 B/L 정보를 등록, 수정, 삭제한다
	 * 
	 * @param Eur24BlInfoVO eur24BlInfoVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void manageBlInfoOB(Eur24BlInfoVO eur24BlInfoVO, SignOnUserAccount account) throws EventException {
		try {
			Eur24BlGeneralInfoVO general = eur24BlInfoVO.getEur24BlGeneralInfoVO();
			dbDao.modifyBlInfoOB(general, account);
			
			// Hold(Doc) / Hold(Phys) / Hold Release
			List<Eu24RcvMsgVO> keyVo = null;
			Eu24RcvMsgVO eu24RcvMsgVO = null;
			
			String ackCd = general.getAckCd();
			String msgFuncHold = general.getMsgFuncHold();
			if( !ackCd.equals(msgFuncHold)){
				keyVo = dbTransDao.searchEur24EdiRcvKey();
				if(keyVo == null || keyVo.size() == 0 ) return;

				eu24RcvMsgVO = new Eu24RcvMsgVO();
				
				eu24RcvMsgVO.setEdiRcvDt(keyVo.get(0).getEdiRcvDt());
				eu24RcvMsgVO.setEdiRcvSeq(keyVo.get(0).getEdiRcvSeq());
				eu24RcvMsgVO.setBlNo(general.getBlNo());
				eu24RcvMsgVO.setAckRcvStsCd(msgFuncHold);
				eu24RcvMsgVO.setCreUsrId(account.getUsr_id());
				eu24RcvMsgVO.setUpdUsrId(account.getUsr_id());
				
				dbTransDao.addMnlRcvLogMstOB(eu24RcvMsgVO);
			}
			
			/*
			 * EXS B/L Inquiry 화면에서 선택된 Prev. Doc No를 최종 사용 값으로 업데이트 한다. 
			 */
//			String prevDocNo = general.getPrevDocNo();
//			if(prevDocNo != null && !prevDocNo.equals(general.getSearchPrevDocNo())) {
//				if(general.getPolCd().startsWith("ES") || general.getPolCd().startsWith("PT") ) {
//					EurCrnRcvMsgVO eurCrnRcvMsgVO = new EurCrnRcvMsgVO();
//	
//					String mfNo = "";
//					String gdsItmNm = "";
//					 
//					if(general.getPolCd().startsWith("ES")) {
//						eurCrnRcvMsgVO.setCntCd("ES");
//						eurCrnRcvMsgVO.setMsgSndOfcCd("VLCBB");
//						mfNo = prevDocNo.substring(0, 11);
//						gdsItmNm = prevDocNo.substring(11);
//					} else {
//						eurCrnRcvMsgVO.setCntCd("PT");
//						eurCrnRcvMsgVO.setMsgSndOfcCd("LISBA");
//						gdsItmNm = prevDocNo;
//					}
//					
//					eurCrnRcvMsgVO.setBlNo(general.getBlNo()); 
//					eurCrnRcvMsgVO.setMfNo(mfNo);
//					eurCrnRcvMsgVO.setMsgFuncId("F");
//					eurCrnRcvMsgVO.setRefGdsItmNm(gdsItmNm);
//					eurCrnRcvMsgVO.setCreUsrId("M");
//					eurCrnRcvMsgVO.setUpdUsrId("M");
//					
//					dbDao.addEurPrevDocNo(eurCrnRcvMsgVO);
//				}
//			}
			
			Eur24BlCustVO cust = eur24BlInfoVO.getEur24BlCustVO();
			dbDao.addBlCustOB(cust, account);
			dbDao.modifyBlCustOB(cust, account);
			dbDao.removeBlCustOB(cust, account);
			List<Eur24BlCntrListVO> eur24BlCntrListVOs = eur24BlInfoVO.getEur24BlCntrListVOs();

			for(Eur24BlCntrListVO cntr : eur24BlCntrListVOs){
				String ibFlag = cntr.getIbflag();
				if(ibFlag.equals("D"))	dbDao.removeBlCntrOB(cntr, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrOB(cntr, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrOB(cntr, account);
			}
			List<Eur24BlCntrMFListVO> eur24BlCntrMFListVOs = eur24BlInfoVO.getEur24BlCntrMFListVOs();
			for(Eur24BlCntrMFListVO cntrMF : eur24BlCntrMFListVOs){
				String ibFlag = cntrMF.getIbflag();
				if(ibFlag.equals("D"))	dbDao.removeBlCntrMFOB(cntrMF, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrMFOB(cntrMF, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrMFOB(cntrMF, account);
			}
			
			List<Eur24BlDangerCntrListVO> eur24BlDangerCntrListVOs = eur24BlInfoVO.getEur24BlDangerCntrListVOs();
			for(Eur24BlDangerCntrListVO danger : eur24BlDangerCntrListVOs){
				String ibFlag = danger.getIbflag();
				if(ibFlag.equals("D"))	dbDao.removeBlCntrDangerOB(danger, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrDangerOB(danger, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrDangerOB(danger, account);
			}
			
			List<Eur24BlCntrSealNoListVO> eur24BlCntrSealNoListVOs = eur24BlInfoVO.getEur24BlCntrSealNoListVOs();
			for(Eur24BlCntrSealNoListVO seal : eur24BlCntrSealNoListVOs){
				String ibFlag = seal.getIbflag();
				seal.setVvd(general.getVvd());
				seal.setCstmsPortCd(general.getCstmsPortCd());
				seal.setBlNo(general.getBlNo());

				if(ibFlag.equals("D"))	dbDao.removeBlCntrSealNoOB(seal, account);
				if(ibFlag.equals("I"))	dbDao.addBlCntrSealNoOB(seal, account);
				if(ibFlag.equals("U"))	dbDao.modifyBlCntrSealNoOB(seal, account);
			}
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	/**
	 * ESM_BKG_1107 : MULTI02 <br>
	 * 메뉴얼 MRN 삭제 <br>
	 *  
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @exception EventException
	 */
	public void manageMrnNo(Eur24BlInfoCondVO eur24BlInfoCondVO) throws EventException {
		try {
			dbDao.modifyMrnNo(eur24BlInfoCondVO);	
			dbDao.addMrnNoHis(eur24BlInfoCondVO);
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	/**
	 * ESM_BKG_1107 : MULTI03 <br>
	 * 메뉴얼 MRN 재입력 <br>
	 * 
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @exception EventException
	 */
	public void reactivateMrnNo(Eur24BlInfoCondVO eur24BlInfoCondVO) throws EventException {
		try {
			dbDao.reactivateMrnNo(eur24BlInfoCondVO);	
			dbDao.addMrnNoHis(eur24BlInfoCondVO);
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}

	/**
	 * ESM_BKG_1146 : MULTI02 <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Save & Select <br>
	 * 
	 * @param EurCrnRcvMsgVO[] eurCrnRcvMsgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePrevDocNo(EurCrnRcvMsgVO[] eurCrnRcvMsgVOs, SignOnUserAccount account) throws EventException {
		try {
			
			List<EurCrnRcvMsgVO> insertVoList = new ArrayList<EurCrnRcvMsgVO>();
					
			for ( int i=0; i<eurCrnRcvMsgVOs .length; i++ ) {
				if ( eurCrnRcvMsgVOs[i].getIbflag().equals("I")){
					insertVoList.add(eurCrnRcvMsgVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addEurPrevDocNo(insertVoList);
			}
			
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	
	
	/**
	 * ESM_BKG_1146 : SEARCH <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No pop-up 조회<br>
	 * 
	 * @param EurCrnRcvMsgVO eurCrnRcvMsgVO
	 * @return List<EurCrnRcvMsgVO>
	 * @throws EventException
	 */
	public List<EurCrnRcvMsgVO> searchPrevDocNo(EurCrnRcvMsgVO eurCrnRcvMsgVO)throws EventException {
		try {
			return dbDao.searchPrevDocNo(eurCrnRcvMsgVO);	
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
	
	
	/**
	 * Europe Advanced Manifest - EXS Monitoring 조회<br>
	 * 
	 * @param Eu24EXSListVO eu24EXSListVO
	 * @return List<Eu24EXSListVO>
	 * @throws EventException 
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EXSListVO> searchEXSMonitoring(Eu24EXSListVO eu24EXSListVO) throws EventException {
		try{
			return dbDao.searchEXSMonitoring(eu24EXSListVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	
	 /**
	  * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws EventException
	  */
	 public List<ManifestListDetailVO> searchPreEUportByVvd(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
//			if(dbDao.searchENSBL(manifestListCondVO).size() > 0 ){
//				return dbDao.searchEU24ENSPOFEbyVVD(manifestListCondVO);
//			}
			return dbDao.searchPreEUportByVvd(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Finland (IE344) / BL 로 해당하는 vvd 의 pre EU Port 를 조회
	 * @param  ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchPreEUvvdByBL(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			return dbDao.searchPreEUvvdByBL(manifestListCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselFIArrivalCondVO
	 * @return List<Eur24VesselFIArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselFIArrivalNoticeDetailVO> searchVesselFIArrival(Eur24VesselArrivalCondVO vesselFIArrivalCondVO) throws EventException {
		try{
			return dbDao.searchVesselFIArrival(vesselFIArrivalCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 조회한다.
	 * 
	 * @param Eur24VesselArrivalCondVO vesselFIArrivalCondVO
	 * @return List<Eur24VesselFIArrivalNoticeDetailVO>
	 * @throws EventException
	 */
	public List<Eur24VesselFIArrivalNoticeDetailVO> searchBlFIArrival(Eur24VesselArrivalCondVO vesselFIArrivalCondVO) throws EventException {
		try{
			return dbDao.searchBlFIArrival(vesselFIArrivalCondVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No를 저장한다. (ESM_BKG_1171)
	 * 
	 * @param Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageFIVesselArrival(Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		try	{
			HashMap<String, String> originalHm = eur24VesselFIArrivalNoticeDetailVO.getColumnValues();

			String flag = originalHm.get("ibflag");
//			List<Eur24VesselFIArrivalNoticeDetailVO> crnList = dbDao.searchCRN(eur24VesselFIArrivalNoticeDetailVO);
//			for(VesselArrivalDetailVO vo : crnList){
//				if(vo == null) continue;
//
//				HashMap<String, String> hm =  vo.getColumnValues();
//				if(!originalHm.get("vsl_cd").equals(hm.get("vsl_cd")) ||
//						!originalHm.get("skd_voy_no").equals(hm.get("skd_voy_no")) ||
//						!originalHm.get("skd_dir_cd").equals(hm.get("skd_dir_cd"))){
//					throw new EventException(new ErrorHandler("BKG01027").getMessage());
//				}
//			}
			if(flag.equals("I"))
				dbDao.addFIArrivalNotice(eur24VesselFIArrivalNoticeDetailVO, account);
			else
				dbDao.modifyFIArrivalNotice(eur24VesselFIArrivalNoticeDetailVO, account);
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * EU A/N (ESM_BKG_1104) 에서 구주스탭이 해당 VVD 의 모든 MRN 을 삭제
	 * 
	 * @param eur24VesselArrivalNoticeDetailVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteAllMrn(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException {
		try	{
			dbDao.deleteAllMrn(eur24VesselArrivalNoticeDetailVO, account);
		} catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
	    }
	}
 
	
	
}
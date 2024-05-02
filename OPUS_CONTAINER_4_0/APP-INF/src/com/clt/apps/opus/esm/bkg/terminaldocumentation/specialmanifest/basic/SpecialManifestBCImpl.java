/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestBCImpl.java
*@FileTitle : SpecialManifestBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier :
*@LastVersion : 1.0
* 2009.04.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration.SpecialManifestDBDAO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.CntrBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.CntrCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DeclBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgBayRcvMsgDtlVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgBayRcvMsgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCargoCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCntrInfoListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgInqModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgSendDtlHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgSendHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgValidationCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgHisVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgSummaryListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgDtlVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederNameVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.MainMeansVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.MainPartiesVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialContainerSaveVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialContainerVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsEurDgVO;

/**
 * OPUS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - OPUS-TerminalDocumentation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see SpecialManifestDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class SpecialManifestBCImpl extends BasicCommandSupport implements SpecialManifestBC {

	// Database Access Object
	private transient SpecialManifestDBDAO dbDao = null;

	/**
	 * FullReleaseOrderBCImpl 객체 생성<br>
	 * FullReleaseOrderDBDAO를 생성한다.<br>
	 */
	public SpecialManifestBCImpl() {
		dbDao = new SpecialManifestDBDAO();
	}

	/**
	 * 포워더 코드 및 desc정보를 조회한다.<br>
	 *
	 * @param fwdrListCondVO   FwdrListCondVO
	 * @return List<FwdrListVO>
	 * @exception EventException
	 */
	public List<FwdrListVO> searchForwarderList(FwdrListCondVO fwdrListCondVO) throws EventException {

		List<FwdrListVO> list = null;

		try {
			list = dbDao.searchForwarderListByCdNm(fwdrListCondVO);


		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 포워더 코드 및 desc정보를 입력한다.<br>
	 *
	 * @param  FwdrListVO[] fwdrListModiVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageForwarderList(FwdrListVO[] fwdrListModiVO, SignOnUserAccount account) throws EventException {
		try {
			List<FwdrListVO> insertVoList = new ArrayList<FwdrListVO>();
			List<FwdrListVO> updateVoList = new ArrayList<FwdrListVO>();
			List<FwdrListVO> deleteVoList = new ArrayList<FwdrListVO>();

			for ( int i=0; i<fwdrListModiVO .length; i++ ) {
				if ( fwdrListModiVO[i].getIbflag().equals("I")){
					fwdrListModiVO[i].setCreUsrId(account.getUsr_id());
					fwdrListModiVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(fwdrListModiVO[i]);
				} else if ( fwdrListModiVO[i].getIbflag().equals("U")){
					fwdrListModiVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(fwdrListModiVO[i]);
				} else if ( fwdrListModiVO[i].getIbflag().equals("D")){
					deleteVoList.add(fwdrListModiVO[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addForwarderList(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.removeForwarderList(updateVoList);
				dbDao.addForwarderList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeForwarderList(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Bay plan 정보를 조회한다.<Br>
	 *
	 * @return List<BayPlanListVO>
	 * @throws EventException
	 */
	public List<BayPlanListVO> searchBayPlanList() throws EventException {
		List<BayPlanListVO> list = null;

		try {
			list = dbDao.searchBayPlanListByVvdPort();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;

	}

	/**
	 * Bay plan 상세 정보를 조회한다.<Br>
	 *
	 * @param BayPlanCondVO bayPlanCondVO
	 * @return List<BayPlanListDetailVO>
	 * @throws EventException
	 */
	public List<BayPlanListDetailVO> searchBayPlanDetailListByBaiId(BayPlanCondVO bayPlanCondVO) throws EventException {
		List<BayPlanListDetailVO> list = null;

		try {
			list = dbDao.searchBayPlanDetailListByBaiId(bayPlanCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;

	}


	/**
	 * VVD와 Port를 가지고 Bay Plan에서 Cell position을 자동으로 가져 왔는 지 여부를 조회 한다.<Br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return String
	 * @throws EventException
	 */
	public String searchIstowageInfo(DgListCondVO dgListCondVO) throws EventException {
		String retVal = "";

		try {
			retVal = dbDao.searchBayPlanInfo(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return retVal;

	}

	/**
	 * 수출,수입, T/S, Barge별로 전송 대상을 조회한다.<Br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return List<DgListDetailVO>
	 * @throws EventException
	 */
	public List<DgListDetailVO> searchDgManifestList(DgListCondVO dgListCondVO) throws EventException {

		SpecialContainerVO specialContainerVO = new SpecialContainerVO();
		List<DgListDetailVO> retVOList = new ArrayList<DgListDetailVO>();

		boolean copyFlag = false;
		// 0965화면에서 DG LIST COPY 체크박스가 체크되면...
		if ("ESM_BKG_0965".equals(dgListCondVO.getUiType()) && "Y".equals(dgListCondVO.getDgListCopyFlag())) {
			String dType = dgListCondVO.getDType();

			if ("D".equals(dType)) {
				dgListCondVO.setDType("DO");
			} else if ("DO".equals(dType)) {
				dgListCondVO.setDType("D");
			} else if ("L".equals(dType)) {
				dgListCondVO.setDType("PL");
			} else if ("PL".equals(dType)) {
				dgListCondVO.setDType("L");
			}
			copyFlag = true;
		}

		try {
			// 1. vessel 정보 조회 (BKG_CSTMS_EUR_DG_VSL_SKD)
			DgListDetailVO vslInfo = dbDao.searchVslInfo(dgListCondVO);

			if (vslInfo == null) {
				// 세관데이타 없으면 스케줄에서 조회 (VSK_VSL_PORT_SKD)
				vslInfo = dbDao.serachVslAtCommon(dgListCondVO);
				if (vslInfo == null) vslInfo = new DgListDetailVO();
			}

			if (copyFlag) {
				vslInfo.setLocalDbYn("N");
				vslInfo.setSvcRqstNo(dbDao.searchSSRNo(dgListCondVO));
			}
			// Vessel 정보 set
			specialContainerVO.setVslInfo(vslInfo);

			// 2. 위험물 데이타 조회 (BKG_CSTMS_EUR_DG)
			List<DgListDetailVO> list = dbDao.searchDgInfoAtLocal(dgListCondVO);
			specialContainerVO.setDgListLocalYn("Y");
			String chkRst = null; // Transit에서 Load인지 Discharge인지 판별
			if (list.size() == 0) {
				// 세관데이타 없으면 booking 데이타 조회 (NYK 부킹 : BKG_DG_CGO, 타사 부킹 : SCG_PRNR_APRO_RQST_CGO)
				if(dgListCondVO.getDType().equals("T")){
					 chkRst = dbDao.searchDgLoadorDischarge(dgListCondVO); // Transit 데이터 중 이것이 Discharge 인지 Load 인지 판별하는 데이터
					 list = dbDao.searchDgInfoAtBkgDgTransit(dgListCondVO,chkRst); // Transit을 선택 했을 때만
					 specialContainerVO.setDgListLocalYn("N");
				}else{
					dgListCondVO.setAppendFlag("N");
					list = dbDao.searchDgInfoAtBkgDg(dgListCondVO);
					specialContainerVO.setDgListLocalYn("N");
				}
			}
			// 위험물 목록 Set
			specialContainerVO.setDetailList(list);

			// Auo-Transmit 자동 전송 여부를 조회한다.
			specialContainerVO.setAutoSentFlag(dbDao.searchAutoSentInfo(dgListCondVO));

			// EDI전송 결과를 조회 해 온다.
			specialContainerVO.setEdiSentStatus(dbDao.searchEdiSentStatus(dgListCondVO));

			retVOList.add(specialContainerVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return retVOList;
	}

	/**
	 * 위험물 대상을 조회해한(세관 쪽에 등록이 안된 booking쪽 데이타만 조회한다.<Br>
	 * booking쪽 데이타를 추가 하가위해<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return List<DgListDetailVO>
	 * @throws EventException
	 */
	public List<DgListDetailVO> searchAppendDgInfoAtBkgDg(DgListCondVO dgListCondVO) throws EventException {
		List<DgListDetailVO> list = null;

		try {
			dgListCondVO.setAppendFlag("Y");
			if(dgListCondVO.getDType().equals("T")){
				 String chkRst = dbDao.searchDgLoadorDischarge(dgListCondVO); // Transit 데이터 중 이것이 Discharge 인지 Load 인지 판별하는 데이터
				 list = dbDao.searchDgInfoAtBkgDgTransit(dgListCondVO,chkRst); // Transit을 선택 했을 때만
			}else{
				list = dbDao.searchDgInfoAtBkgDg(dgListCondVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;

	}


	/**
	 * UN No별 special 정보를 관리한다.<br>
	 *
	 * @param SpecialListCondVO specialListCondVO
	 * @return List<SpecialListDetailVO>
	 * @exception EventException
	 */
	public List<SpecialListDetailVO> searchSpecialList(SpecialListCondVO specialListCondVO) throws EventException {

		List<SpecialListDetailVO> list = null;

		try {
			list = dbDao.searchSpecialListByCdNm(specialListCondVO);


		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * special 정보를 입력한다.<br>
	 *
	 * @param  SpecialListVO[] specialListVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageSpecialList(SpecialListVO[] specialListVO, SignOnUserAccount account) throws EventException {
		try {
			List<SpecialListVO> insertVoList = new ArrayList<SpecialListVO>();
			List<SpecialListVO> updateVoList = new ArrayList<SpecialListVO>();
			List<SpecialListVO> deleteVoList = new ArrayList<SpecialListVO>();

			for ( int i=0; i<specialListVO .length; i++ ) {
				specialListVO[i].setCreUsrId(account.getUsr_id());
				specialListVO[i].setUpdUsrId(account.getUsr_id());

				if ( specialListVO[i].getIbflag().equals("I")){
					insertVoList.add(specialListVO[i]);
				} else if ( specialListVO[i].getIbflag().equals("U")){
					updateVoList.add(specialListVO[i]);
				} else if ( specialListVO[i].getIbflag().equals("D")){
					deleteVoList.add(specialListVO[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addSpecialList(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.removeSpecialList(updateVoList);
				dbDao.addSpecialList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpecialList(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * 구주 위험물 저장 시 Cell Position & Cntr No 중복여부를 체크한다.<br>
	 *
	 * @param  DgListModiVO[] dgListModiVOs
	 * @param  SignOnUserAccount account
	 * @return List<DgListModiVO>
	 * @throws EventException
	 */
	public List<DgListModiVO> manageDgManifestDupChkList(DgListModiVO[] dgListModiVOs, SignOnUserAccount account) throws EventException {
		
		List<DgListModiVO> dupCntrDgVOList= new ArrayList<DgListModiVO>();
		
		try {
			SpecialContainerSaveVO containerSaveVO = (SpecialContainerSaveVO) dgListModiVOs[0];
			
			
			DgListModiVO[] dgModiDgVOs 	= containerSaveVO.getDgMOdiList();	
			boolean dupChk = false;
			
			for (DgListModiVO dgListModiVO : dgModiDgVOs) { // 데이터 중복 발견 시 
				dgListModiVO.setVvdCd(containerSaveVO.getVvdCd());
				if(dgListModiVO.getIbflag().equals("I") || dgListModiVO.getIbflag().equals("U")){
					String cntr = dbDao.searchDuplicatedCntrNo(dgListModiVO);
					if ("Y".equals(dbDao.searchDuplicatedCntr(dgListModiVO, "cntr", cntr))) { // 컨테이너 중복
						dgListModiVO.setDupCntr("Y");
						dupChk=true;
					}
					if("Y".equals(dbDao.searchDuplicatedCntr(dgListModiVO, "cell_psn", cntr))) { // 셀포지션 중복
						dgListModiVO.setDupCell("Y");
						dupChk=true;
					}
					dupCntrDgVOList.add(dgListModiVO);
				}else{
					dupCntrDgVOList.add(dgListModiVO);
				}
			}
				if(!dupChk){
					dupCntrDgVOList = new ArrayList<DgListModiVO>(); 
				}
			// 이후 port의 cell position no 다른거 수정
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return dupCntrDgVOList;
	}

	/**
	 * 위험물 정보들을 저장한다.<br>
	 *
	 * @param  DgListModiVO[] dgListModiVOs
	 * @param  SignOnUserAccount account
	 * @return List<DgListModiVO>
	 * @throws EventException
	 */
	public List<DgListModiVO> manageDgManifestList(DgListModiVO[] dgListModiVOs, SignOnUserAccount account) throws EventException {
		
		List<DgListModiVO> insertDgVOList = new ArrayList<DgListModiVO>();
		List<DgListModiVO> updateDgVOList = new ArrayList<DgListModiVO>();
		List<DgListModiVO> deleteDgVOList = new ArrayList<DgListModiVO>();
		List<DgListModiVO> hisDgVOList    = new ArrayList<DgListModiVO>();
		List<DgListModiVO> dupCntrDgVOList= new ArrayList<DgListModiVO>();
		
		try {
			SpecialContainerSaveVO containerSaveVO = (SpecialContainerSaveVO) dgListModiVOs[0];

			
			String oldBlNo = "";
			String oldCntrNo = "";

			DgListModiVO[] vslInfoDgVOs 	= containerSaveVO.getVslInfoList();		// 상단 Master 정보
			DgListModiVO[] dgModiDgVOs 	= containerSaveVO.getDgMOdiList();		// 그리드 정보
			
			
			 //상단 Vessel 정보 저장
			if (vslInfoDgVOs != null && vslInfoDgVOs.length == 1) {
				vslInfoDgVOs[0].setDType(containerSaveVO.getDType());
				vslInfoDgVOs[0].setVvdCd(containerSaveVO.getVvdCd());
				vslInfoDgVOs[0].setPortCd(containerSaveVO.getPortCd());

				vslInfoDgVOs[0].setCreUsrId(account.getUsr_id());
				vslInfoDgVOs[0].setUpdUsrId(account.getUsr_id());

				if("Y".equals(vslInfoDgVOs[0].getLocalDbYn())) {
					dbDao.modifyVslInfo(vslInfoDgVOs[0]);
				} else {
					dbDao.addVslInfo(vslInfoDgVOs[0]);
				}
			}
			
			
				for (int i = 0; i < dgModiDgVOs.length; i++) {
					dgModiDgVOs[i].setDType(containerSaveVO.getDType());
					dgModiDgVOs[i].setVvdCd(containerSaveVO.getVvdCd());
					dgModiDgVOs[i].setPortCd(containerSaveVO.getPortCd());
					dgModiDgVOs[i].setCreUsrId(account.getUsr_id());
					dgModiDgVOs[i].setUpdUsrId(account.getUsr_id());
					if ("Y".equals(containerSaveVO.getDgListLocalYn())) { // 저장한 이후에는 update
						if (dgModiDgVOs[i].getIbflag().equals("I")) {
							insertDgVOList.add(dgModiDgVOs[i]);
						} else if (dgModiDgVOs[i].getIbflag().equals("U")) {
							updateDgVOList.add(dgModiDgVOs[i]);
						} else if (dgModiDgVOs[i].getIbflag().equals("D")) {
							deleteDgVOList.add(dgModiDgVOs[i]);
						}
					} else { // 저장하지 않은 경우 insert
						
						
//						if (dgModiDgVOs[i].getIbflag().equals("D")) continue;
//						insertDgVOList.add(dgModiDgVOs[i]);
					
						if (dgModiDgVOs[i].getIbflag().equals("I")) {
							insertDgVOList.add(dgModiDgVOs[i]);
						}else if (dgModiDgVOs[i].getIbflag().equals("D")) {
							deleteDgVOList.add(dgModiDgVOs[i]);
						}
					}
	
					if (!("".equals(dgModiDgVOs[i].getBlNo())) && !("".equals(dgModiDgVOs[i].getCntrNo()))) {
						if (!(oldBlNo.equals(dgModiDgVOs[i].getBlNo())) || !(oldCntrNo.equals(dgModiDgVOs[i].getCntrNo()))) {
							hisDgVOList.add(dgModiDgVOs[i]);
						}
					}
					oldBlNo = dgModiDgVOs[i].getBlNo();
					oldCntrNo = dgModiDgVOs[i].getCntrNo();
				}
					if(insertDgVOList.size() > 0) {
						dbDao.addDgList(insertDgVOList);
						dbDao.modifyCellPsnNo(insertDgVOList);
					}
					if(updateDgVOList.size() > 0) {
						dbDao.modifyDgList(updateDgVOList);
						dbDao.modifyCellPsnNo(updateDgVOList);
					}
					if(deleteDgVOList.size() > 0) {
						if ("Y".equals(containerSaveVO.getDgListLocalYn())) { // 저장이 되어야만 EU DG 테이블에 가서 데이터 삭제
							dbDao.removeDgList(deleteDgVOList);
							dbDao.removeDgHisList(deleteDgVOList);
						}
					for (int i = 0; i < dgModiDgVOs.length; i++) {
						if(dgModiDgVOs[i].getCgoOprCd().equals("NYK")){ //Cgo_Oper_Cd의 값이 NYK이면 BKG_DG_CGO 테이블의 Except Flag에 값을 넣는다.
							if(deleteDgVOList.get(0).getDType().equals("L")){ // 이 때 Export 화면일때만 해당한다.
								dbDao.updateBkgDgCgoList(deleteDgVOList);
							}
						}
						else{ //Cgo_Oper_Cd의 값이 NYK가 아니면 SCG_PRNR_APRO_RQST_CGO 테이블의 Except Flag에 값을 넣는다.//Cgo_Oper_Cd의 값이 NYK 이면 SCG_PRNR_APRO_RQST_CGO 테이블의 Except Flag에 값을 넣는다.
							if(deleteDgVOList.get(0).getDType().equals("L")){ // 이때 Export 화면 일때만 해당한다. 
								dbDao.updateSpclCgoList(deleteDgVOList); 
								}
							}
						}
					}
					if(hisDgVOList.size() > 0) {
						dbDao.addDgListHis(hisDgVOList);
					}
			// 이후 port의 cell position no 다른거 수정
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return dupCntrDgVOList;
	}
	
	/**
	 * Danger cargo 컨테이너 목록 조회<br>
	 *
	 * @param dgCargoCondVO
	 * @return List<BkgCstmsEurDgVO>
	 * @throws EventException
	 */
	public List<BkgCstmsEurDgVO> searchBkgCstmsEurDgList(DgCargoCondVO dgCargoCondVO) throws EventException {
		try {
			return dbDao.searchBkgCstmsEurDgList(dgCargoCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
	 *
	 * @param dgCargoCondVO
	 * @return DgInqModiVO
	 * @throws EventException
	 */
	public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException {
		try {
			return dbDao.searchDgInfoinquiry(dgCargoCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * Vessel Code롤 Name울 조회한다.<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws EventException
	 */
	public String searchVesselName(DgListCondVO dgListCondVO) throws EventException {
		try {
			return dbDao.searchVesselNameByCd(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Berth Code로 YardName을 조회한다.<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws EventException
	 */
	public String searchYardName(DgListCondVO dgListCondVO) throws EventException {
		try {
			return dbDao.searchYardNameByCd(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 	Forward Code로 Forward Name을 조회한다.<br>
	 *
	 * @param dgListCondVO
	 * @return
	 * @throws EventException
	 */
	public String searchForwarderName(DgListCondVO dgListCondVO) throws EventException {
		try {
			return dbDao.searchForwarderNameByCd(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * UN NO로 NAME을 조회한다.<br>
	 *
	 * @param dgListCondVO
	 * @return
	 * @throws EventException
	 */
	public String searchUnnoName(DgListCondVO dgListCondVO) throws EventException {
		try {
			return dbDao.searchUnnoNameByCd(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	 *
	 * @param dgCargoCondVO
	 * @return List<DgCntrInfoListVO>
	 * @throws EventException
	 */
	public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws EventException {
		try {
			return dbDao.searchCntrInfoListByBl(dgCargoCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	 *
	 * @param dgCargoCondVO
	 * @return List<DgCntrInfoListVO>
	 * @throws EventException
	 */
	public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws EventException {
		try {
			return dbDao.searchCgoSeqListByCntr(dgCargoCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 위험물 상세 정보들을 저장한다.<br>
	 *
	 * @param  DgInqModiVO dgInqModiVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyDgInquiry(DgInqModiVO dgInqModiVO, SignOnUserAccount account) throws EventException {

		try {

			if(dgInqModiVO != null) {
//				dgInqModiVO.unDataFormat();				
				dgInqModiVO.setCreUsrId(account.getUsr_id());
				dgInqModiVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyDgInqBySeq(dgInqModiVO);
				
				//Create History
				dbDao.addDgInquiryHis(dgInqModiVO);
			}


		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * 위험물 Sent결과를 조회해 온다.<br>
	 *
	 * @param  SendHistoryCondVO sendHistoryCondVO
	 * @return List<SendHistoryDetailVO>
	 * @throws EventException
	 */
	public List<SendHistoryDetailVO> searchSendHistory(SendHistoryCondVO sendHistoryCondVO) throws EventException {
		try {
			return dbDao.searchSendHistoryByCntrNo(sendHistoryCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * 구주위험물 세관신고 위해 FlatFile을 생성 및 전송
	 *
	 * @param  DgEdiVO[] dgEdiVOs
	 * @param  SignOnUserAccount account
	 * @param  String ediPreview
	 * @return List<String>
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> sendDgManifestList(DgEdiVO[] dgEdiVOs, SignOnUserAccount account, String ediPreview) throws EventException {
		// ORIGINAL 전송 VO
		List<DgEdiVO> originalDgEdiVO = new ArrayList<DgEdiVO>();
		// UPDATE 전송 VO
		List<DgEdiVO> updateDgEdiVO = new ArrayList<DgEdiVO>();
		// CANCEL 전송 VO
		List<DgEdiVO> cancelDgEdiVO = new ArrayList<DgEdiVO>();
		// UPDATE VO LIST
		List updateDgEdiVOList = new ArrayList();
		// 생성된 FlatFile String 리스트 : 위험물 하단에 임시로 생성된 FlatFile을 보여주기 위해사용
		List<String> retList = new ArrayList<String>();

		String originalFlatFile = "";
		String updateFlatFile = "";
		List<String> updateFlatFileList = new ArrayList<String>();
		String cancelFlatFile = "";

		DgEdiVO dgEdiVO = null;

		// 위험물 대상 총건수
		int dgEdiVOsMaxSize = 0;

		// 해당 port
		String comPortCd = "";

		/*
		 * 전송 type : 화면에서 눌려진 전송 버튼 구분(EDI Transmit / EDI Cancel)
		 * => 이후 다음과 같이 다시 셋팅함 (O->ORIGIN,U->UPDATE,C->CANCEL,AC->AUTO CANCEL)
		 */
		String transType = "";

		try {

			dgEdiVOsMaxSize = dgEdiVOs.length;

			for (int i = 0; i < dgEdiVOsMaxSize; i++) {
				dgEdiVO = dgEdiVOs[i];

				if (i != 0) {
					dgEdiVO.setVvdCd(dgEdiVOs[0].getVvdCd());
					dgEdiVO.setPortCd(dgEdiVOs[0].getPortCd());
					dgEdiVO.setDType(dgEdiVOs[0].getDType());
					dgEdiVO.setUiType(dgEdiVOs[0].getUiType());
					dgEdiVO.setKeyType(dgEdiVOs[0].getKeyType());
					dgEdiVO.setTransType(transType);

				} else {
					transType = dgEdiVOs[0].getTransType();
					comPortCd = dgEdiVO.getPortCd().substring(2, 5);
				}

				if (transType.equalsIgnoreCase("CANCEL_SEND")) {
					dgEdiVO.setTransType("C");
					cancelDgEdiVO.add(dgEdiVO);

				} else {
					if(dgEdiVO.getSendType().equals("")) {
						dgEdiVO.setTransType("O");
						originalDgEdiVO.add(dgEdiVO);
					} else if(dgEdiVO.getSendType().equals("C")) {
						/*
						 * SEND TYPE이 CANCEL일 경우
						 *
						 * HAM => UPDATE
						 * RTM, FXT, FOS, ANR => ORGINAL
						 */
						if(comPortCd.equals("HAM")) {
							dgEdiVO.setTransType("U");
							updateDgEdiVO.add(dgEdiVO);
						} else if(comPortCd.equals("RTM") || comPortCd.equals("FXT") || comPortCd.equals("THP") || comPortCd.equals("FOS") || comPortCd.equals("ANR")|| comPortCd.equals("ZEE")) {
							dgEdiVO.setTransType("O");
							originalDgEdiVO.add(dgEdiVO);
						}

					} else if(dgEdiVO.getSendType().equals("O") || dgEdiVO.getSendType().equals("U") || dgEdiVO.getSendType().equals("AC")) {
						if(!dgEdiVO.getSendType().equals("AC")) {
							dgEdiVO.setTransType("U");
						} else { // Auto Cancel일 경우
							dgEdiVO.setTransType("AC");
						}
						updateDgEdiVO.add(dgEdiVO);

					}
				}
			} // end for(i)

			String preFirstMsnNo = "";
			String currFirstMsnNo = "";

			// 업데이트일경우 - First_Ref_No별 업데이트 flatfile 나누기
			int updateDgEdiVOMaxSize = updateDgEdiVO.size();
			List<DgEdiVO> updateTmpDgEdiVO = new ArrayList<DgEdiVO>();

			for(int i = 0; i < updateDgEdiVOMaxSize; i++) {
				dgEdiVO = updateDgEdiVO.get(i);
				currFirstMsnNo = dgEdiVO.getFirstMsgSndNo();
				if(!preFirstMsnNo.equals(currFirstMsnNo)) {
					if(!preFirstMsnNo.equals("")) {
						updateDgEdiVOList.add(updateTmpDgEdiVO);
						updateTmpDgEdiVO = new ArrayList<DgEdiVO>();
					}
				}

				dgEdiVO.setTransType("U");
				updateTmpDgEdiVO.add(dgEdiVO);
				preFirstMsnNo = currFirstMsnNo;

				if(i == updateDgEdiVOMaxSize - 1) { // 맨 마지막이면 무조건 list에 add한다.
					updateDgEdiVOList.add(updateTmpDgEdiVO);
				}
			} // end for(i)

			// Update 전송
			List<DgEdiVO> updateVO = null;
			if (updateDgEdiVOList != null && updateDgEdiVOList.size() > 0) {
				for(int i =0; i < updateDgEdiVOList.size(); i++) {
					updateVO = (List<DgEdiVO>) updateDgEdiVOList.get(i);
					updateFlatFile = this.sendFlatFile(updateVO, account, ediPreview);
					updateFlatFileList.add(updateFlatFile);
				}
			}

			// Original 전송
			if (originalDgEdiVO != null && originalDgEdiVO.size() > 0) {
				originalFlatFile = this.sendFlatFile(originalDgEdiVO, account, ediPreview);
			}

			// Cancel 전송
			if (cancelDgEdiVO != null && cancelDgEdiVO.size() > 0) {
				cancelFlatFile = this.sendFlatFile(cancelDgEdiVO, account, ediPreview);
			}

			retList.add(originalFlatFile);

			// 리턴 FF에 구분선 넣어주기
			updateFlatFile = "";
			for (int i =0; i < updateFlatFileList.size(); i++) {
//				updateFlatFile = (updateFlatFile + "[" + (i+1) + "]===============================\n");
				updateFlatFile = (updateFlatFile + updateFlatFileList.get(i));
			}

			retList.add(updateFlatFile);
			retList.add(cancelFlatFile);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return retList;
	}

	/**
	 * FlatFile을 생성한다.<br>
	 *
	 * @param List<DgEdiVO> dgEdiVOs
	 * @param SignOnUserAccount account
	 * @param String ediPreview
	 * @return
	 * @throws EventException
	 */
	private String sendFlatFile(List<DgEdiVO> dgEdiVOs, SignOnUserAccount account, String ediPreview) throws EventException {

		StringBuffer flatFile = null;
		String header = "";

		boolean inFlag = true;
		boolean inFlag2 = true;

		int dgEdiVOsMaxSize = 0;
		int mainPartiesVOsMaxSize = 0;

		DeclBaseInfoVO declBaseInfoVO = null;
		DgEdiVO dgEdiVO = null;

		List<MainPartiesVO> mainPartiesVOs = null;
		MainPartiesVO mainPartiesVO = null;

		MainMeansVO mainMeansVO = null;

		String currBlNo = "";
		String prevBlNo = "";

		String vvdCd = "";
		String portCd = "";
		String dType = "";
		String transType = ""; // 전송 Type ("O" - 최초전송, "U" - 재전송, "C" - 취소전송, "AC" - AUTO CANCEL)
		String transId = "";
		CntrBaseInfoVO cntrBaseInfoVO = null;
		List<CntrBaseInfoVO> cntrBaseInfoByBlVOs = null;
		List<CntrBaseInfoVO> cntrBaseInfoVOs = new ArrayList<CntrBaseInfoVO>();

		List<CntrCgoVO> cntrCgoVOs = null;
		CntrCgoVO cntrCgoVO = null;

		String oldUserRefNo = "";
		String firstUserRefNo = "";

		String ofcCd = ""; // office code
		String usrId = ""; // User Id
		String keyType = "";
		String msgTpId = "";
//		String senderId = "";
//		String receiverId = "";
//		String headerType = "";

		String secFileNbr = "";

		String uiType = ""; // client 화면 구분

		BookingUtil command = null;

		/* log 저장 vo 선언  시작*/
		DgSendHistoryVO dgSendHistoryVO = null; // send
		DgSendHistoryVO dgAutoCancelSendHistoryVO = null; // send(Auto Cancel만 해당)
		DgSendDtlHistoryVO dgSendDtlHistoryVO = null;
		List<DgSendDtlHistoryVO> dgSendDtlHistoryVOs = new ArrayList<DgSendDtlHistoryVO>(); // send detail list
		List<DgSendDtlHistoryVO> dgAutoCancelSendDtlHistoryVOs = new ArrayList<DgSendDtlHistoryVO>(); // send detail list(Auto Cancel만 해당)
		DgSendHistoryVO dgSendFlatFileHistoryVO = null; // FlatFile Log
		List<DgSendHistoryVO> dgSendFlatFileHistoryVOs = new ArrayList<DgSendHistoryVO>(); // FlatFile Log list
		/* log 저장 vo 선언  끝*/

		String sndKey = ""; // MSG_SND_NO
		DecimalFormat fmt = new DecimalFormat("00");

		boolean consignmentEmptyFlag = false;
		String conVVd = "";
		
		try {
			command = new BookingUtil();
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
			
			ofcCd = account.getOfc_cd(); // office code
			usrId = account.getUsr_id();
			flatFile = new StringBuffer();

			dgEdiVOsMaxSize = dgEdiVOs.size();
			
			for (int i = 0; i < dgEdiVOsMaxSize; i++) {
				dgEdiVO = dgEdiVOs.get(i);
				currBlNo = dgEdiVO.getBlNo();

				if (inFlag) {
					vvdCd = dgEdiVO.getVvdCd();
					portCd = dgEdiVO.getPortCd();
					dType = dgEdiVO.getDType();

					uiType = dgEdiVO.getUiType();
					String comPortCd = portCd.substring(2, 5);
					transId = dbDao.searchTransType(dgEdiVO); // 수신받은 것 중에 한 번이라도 Accpeted를 받은적이 있으면 Y를 리턴
					transType = dgEdiVO.getTransType();
//					if (uiType.equalsIgnoreCase("ESM_BKG_0965") && transType.equals("C")) { // ANR이면서 취소전송일경우
//						headerType = "CANMES";
//					} else { // 기타
//						headerType = "IFTDGN";
//					}
					// Cancel전송이면서 지역이  "BRV" or "LEH" 이면 with empty consignment info
					if (transType.equals("C") && (comPortCd.equals("BRV") || comPortCd.equals("LEH")) ) {
						consignmentEmptyFlag = true;
						transType = "U";
					} else {
						consignmentEmptyFlag = false;
						if("DEHAM".equals(dgEdiVO.getPortCd())){
							if("Y".equals(transId)){ // Port가 DEHAM인 경우 이전에 세관에서 Accepeted를 한 번이라도 받았으면 그 후의 전송은 항상 Update로 전송
								transType = "U";
							}else{
								transType = "O";
							}
						}
					}

//					if (uiType.equalsIgnoreCase("ESM_BKG_0965")) { // ANR, ZEE
//						senderId = "NYK";
//						receiverId = "102401_D03A";
//						if(comPortCd.equals("ANR")) {
//							receiverId = "102401_D03A";
//						} else if(comPortCd.equals("ZEE")) {
//							receiverId = "128001";
//						}
//
//					} else { // 기타
//						if(comPortCd.equals("BRV")) {
//							senderId = "NYK";
//							receiverId = "DEBRV";
//						} else if(comPortCd.equals("HAM")) {
//							senderId = "NYK";
//							receiverId = "DEHAM";
////						} else if((comPortCd.equals("FXT")) || (comPortCd.equals("THP"))) {
////							senderId = "NYK";
////							receiverId = "FCPHJN";
//						} else if(comPortCd.equals("LEH")) {
//							senderId = "NYK";
//							receiverId = "FRLEH";
////						} else if(comPortCd.equals("FOS")) {
////							senderId = "NYK";
////							if ("D".equals(dType)) {
////								receiverId = "APPLUS-D03A";
////							} else {
////								receiverId = "APPLUS";
////							}
//						} else if(comPortCd.equals("RTM")) {
//							senderId = "NYK";
//							receiverId = "NLRTM";
//						} else {
//							throw new EventException(new ErrorHandler("BKG06143",new String[]{}).getMessage());
//						}
//					}

					// FlatFile Header를 생성한다.
					header = command.searchCstmsEdiHeaderNew("EUDG_" + portCd);
					
					
					flatFile.append(header).append("\n");
					flatFile.append("{DECL").append("\n");

					dgEdiVO.setOfcCd(ofcCd);
					// decl 기본정보를 조회한다.
					declBaseInfoVO = dbDao.searchDeclBaseInfo(dgEdiVO);

					if (uiType.equalsIgnoreCase("ESM_BKG_0965")) {
						keyType = "ANR";
						msgTpId = "ANRDGN";
					} else {
						keyType = "ETC";
						msgTpId = "IFTDGN" + vvdCd + portCd.substring(2, portCd.length()) + dType;
					}

					if (uiType.equalsIgnoreCase("ESM_BKG_0965") && (transType.equals("U") || transType.equals("C") || transType.equals("AC")) ) { // ANR + (UPDATE OR CANCEL OR AC)
						// PORT가 ANR이면서.  전송타입이 UPDATE전송일 경우.. MSG_SND_NO를 신규로 만들 않고 맨뒤 2자리만 증가한다.
						String oldMsgSndNo = dgEdiVO.getMsgSndNo();
						String newSeq = fmt.format( Integer.parseInt(oldMsgSndNo.substring(15, 17)) + 1 );
						sndKey = oldMsgSndNo.substring(0, 15) + newSeq;

					} else {
						// 신규로 MSG_SND_NO 키값을 만든다.
						sndKey = dbDao.searchEdiHistoryKey(msgTpId, keyType, vvdCd, portCd, dType);
					}

					if (declBaseInfoVO != null) {

						flatFile.append("DOC_NAME:")				.append(declBaseInfoVO.getDocName()).append("\n");
						flatFile.append("DECL_TYPE:")				.append(declBaseInfoVO.getDeclType()).append("\n");
						flatFile.append("HANDLING:")				.append(declBaseInfoVO.getHandling()).append("\n");

						/* Send Master log VO 셋팅 */
						dgSendHistoryVO = new DgSendHistoryVO();
						dgSendHistoryVO.setEurEdiMsgTpId("IFD");
						dgSendHistoryVO.setMsgSndNo(sndKey);
						dgSendHistoryVO.setSndUsrId(usrId);
						dgSendHistoryVO.setAutoSndTpCd("M");
						dgSendHistoryVO.setEurDgDeclTpCd(declBaseInfoVO.getHandling());
						dgSendHistoryVO.setVvdCd(vvdCd);
						dgSendHistoryVO.setPortCd(portCd);
						dgSendHistoryVO.setCreUsrId(usrId);
						dgSendHistoryVO.setUpdUsrId(usrId);

						dgSendHistoryVO.setMsgFuncId(transType.equals("AC") ? "U" : transType);

						flatFile.append("STATUS:")					.append(transType.equals("AC") ? "U" : transType).append("\n");
						flatFile.append("REASON:")					.append(declBaseInfoVO.getReason()).append("\n");
						flatFile.append("USER_REF:")				.append(dgSendHistoryVO.getMsgSndNo()).append("\n");

						if(!transType.equals("O")) { // 최초전송이 아닐 경우만   OLD_USER_REF, FIRST_USER_REF값을 조회한다.
							oldUserRefNo 	= dgEdiVO.getMsgSndNo();
							firstUserRefNo 	= dgEdiVO.getFirstMsgSndNo();
							secFileNbr = declBaseInfoVO.getSecFileNbr();
						} else { // 최초전송일 경우  FIRST_USER_REF  = dgSendHistoryVO.getMsgSndNo()로 셋팅한다.
							firstUserRefNo = dgSendHistoryVO.getMsgSndNo();
							oldUserRefNo   = "";
							secFileNbr = "";
						}

						flatFile.append("OLD_USER_REF:")			.append(oldUserRefNo).append("\n");
						flatFile.append("FIRST_USER_REF:")			.append(firstUserRefNo).append("\n");
						flatFile.append("SEC_FILE_NBR:")			.append(secFileNbr).append("\n");
						flatFile.append("FF_REF:")					.append(declBaseInfoVO.getFfRef()).append("\n");

						// MAIN PARTIES 정보를 조회한다.
						dgEdiVO.setUsrId(usrId);
						mainPartiesVOs = dbDao.searchMainParties(dgEdiVO);

						if(mainPartiesVOs != null) {

							mainPartiesVOsMaxSize = mainPartiesVOs.size();
							for(int idx =0; idx < mainPartiesVOsMaxSize; idx++) {

								mainPartiesVO = mainPartiesVOs.get(idx);

								flatFile.append("{MAIN_PARTIES").append("\n");
								if(mainPartiesVO != null) {

									flatFile.append("PARTY_TYPE:")					.append(mainPartiesVO.getPartyType()).append("\n");
									flatFile.append("PARTY_ID:")					.append(mainPartiesVO.getPartyId()).append("\n");
									flatFile.append("AUTHORIZED:")					.append(mainPartiesVO.getAuthorized()).append("\n");
									flatFile.append("ADDRESS1:")					.append(mainPartiesVO.getAddress1()).append("\n");
									flatFile.append("ADDRESS2:")					.append(mainPartiesVO.getAddress2()).append("\n");
									flatFile.append("ADDRESS3:")					.append(mainPartiesVO.getAddress3()).append("\n");
									flatFile.append("ADDRESS4:")					.append(mainPartiesVO.getAddress4()).append("\n");
									flatFile.append("ADDRESS5:")					.append(mainPartiesVO.getAddress5()).append("\n");
									flatFile.append("CONTACT:")						.append(mainPartiesVO.getContact()).append("\n");
									flatFile.append("PHONE:")						.append(mainPartiesVO.getPhone()).append("\n");
									flatFile.append("FAX:")							.append(mainPartiesVO.getFax()).append("\n");
									flatFile.append("REF:")							.append(mainPartiesVO.getRef1()).append("\n");

								} else {
									flatFile.append("PARTY_TYPE:")					.append("").append("\n");
									flatFile.append("PARTY_ID:")					.append("").append("\n");
									flatFile.append("AUTHORIZED:")					.append("").append("\n");
									flatFile.append("ADDRESS1:")					.append("").append("\n");
									flatFile.append("ADDRESS2:")					.append("").append("\n");
									flatFile.append("ADDRESS3:")					.append("").append("\n");
									flatFile.append("ADDRESS4:")					.append("").append("\n");
									flatFile.append("ADDRESS5:")					.append("").append("\n");
									flatFile.append("CONTACT:")						.append("").append("\n");
									flatFile.append("PHONE:")						.append("").append("\n");
									flatFile.append("FAX:")							.append("").append("\n");
									flatFile.append("REF:")							.append("").append("\n");
								}

								flatFile.append("}MAIN_PARTIES").append("\n");
							} // end for(idx)
						}


						// MAIN MEANS 정보를 조회한다.
						mainMeansVO = dbDao.searchMainMeans(dgEdiVO);

						if(mainMeansVO != null) {
							flatFile.append("{MAIN_MEANS").append("\n");
								flatFile.append("MAIN_MEANS_TYPE:")				.append(mainMeansVO.getMainMeansType()).append("\n");
								flatFile.append("MAIN_VVD:")					.append(mainMeansVO.getMainVvd()).append("\n");
								if("D".equals(dType)){
									conVVd = comBc.searchConVvd(mainMeansVO.getMainVvd(), portCd, "I"); 
								}else if("L".equals(dType)){
									conVVd = comBc.searchConVvd(mainMeansVO.getMainVvd(), portCd, "O");
								}else{
									conVVd = "";
								}
								flatFile.append("CON_MAIN_VVD:")				.append(conVVd).append("\n");
								flatFile.append("MAIN_MODE:")					.append(mainMeansVO.getMainMode()).append("\n");
								flatFile.append("MAIN_NAME:")					.append(mainMeansVO.getMainName()).append("\n");
								flatFile.append("MAIN_SSR:")					.append(mainMeansVO.getMainSsr()).append("\n");
								flatFile.append("{MAIN_IDS").append("\n");
									flatFile.append("MAIN_ID_TYPE:")				.append(mainMeansVO.getLMainIdType()).append("\n");
									flatFile.append("MAIN_ID:")						.append(mainMeansVO.getLMainId()).append("\n");
								flatFile.append("}MAIN_IDS").append("\n");
								flatFile.append("{MAIN_IDS").append("\n");
									flatFile.append("MAIN_ID_TYPE:")				.append(mainMeansVO.getCMainIdType()).append("\n");
									flatFile.append("MAIN_ID:")						.append(mainMeansVO.getCMainId()).append("\n");
								flatFile.append("}MAIN_IDS").append("\n");
								flatFile.append("MAIN_NATION:")						.append(mainMeansVO.getMainNation()).append("\n");
								flatFile.append("MAIN_LICENSE:")					.append(mainMeansVO.getMainLicense()).append("\n");
							flatFile.append("}MAIN_MEANS").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEta1()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEta1()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEtd1()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEtd1()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEtd0()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEtd0()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");

							flatFile.append("{MAIN_DATES").append("\n");
								flatFile.append("BKG_DATE_TYPE:")					.append(mainMeansVO.getBkgDateTypeEta2()).append("\n");
								flatFile.append("BKG_DATE:")						.append(mainMeansVO.getBkgDateEta2()).append("\n");
							flatFile.append("}MAIN_DATES").append("\n");


							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeBer()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocBer()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");

							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeLc1()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocLc1()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");

							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeLc0()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocLc0()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");

							flatFile.append("{MAIN_LOCS").append("\n");
								flatFile.append("BKG_LOC_TYPE:")					.append(mainMeansVO.getBkgLocTypeLc2()).append("\n");
								flatFile.append("BKG_LOC:")							.append(mainMeansVO.getBkgLocLc2()).append("\n");
							flatFile.append("}MAIN_LOCS").append("\n");
						}
					}
					inFlag = false;
				} // end if(inFlag)

				if("AC".equals(dgEdiVO.getSendType())) { // Auto Cancel일경우
					if(inFlag2) {
						/* Send Master log VO 셋팅 */
						dgAutoCancelSendHistoryVO = new DgSendHistoryVO();
						dgAutoCancelSendHistoryVO.setEurEdiMsgTpId("IFD");
						dgAutoCancelSendHistoryVO.setMsgSndNo(sndKey + "AC"); // 전송된 MsgSndNo + "AC"
						dgAutoCancelSendHistoryVO.setSndUsrId(usrId);
						dgAutoCancelSendHistoryVO.setAutoSndTpCd("M");
						dgAutoCancelSendHistoryVO.setEurDgDeclTpCd(declBaseInfoVO.getHandling());
						dgAutoCancelSendHistoryVO.setVvdCd(vvdCd);
						dgAutoCancelSendHistoryVO.setPortCd(portCd);
						dgAutoCancelSendHistoryVO.setCreUsrId(usrId);
						dgAutoCancelSendHistoryVO.setUpdUsrId(usrId);
						dgAutoCancelSendHistoryVO.setMsgFuncId("C");

						inFlag2 = false;
					}

					// detail log
					dgSendDtlHistoryVO = new DgSendDtlHistoryVO();
					dgSendDtlHistoryVO.setEurEdiMsgTpId("IFD");
					dgSendDtlHistoryVO.setMsgSndNo(sndKey + "AC"); // 전송된 MsgSndNo + "AC"
					dgSendDtlHistoryVO.setBlNo(dgEdiVO.getBlNo());
					dgSendDtlHistoryVO.setCntrNo(dgEdiVO.getCntrNo());
					dgSendDtlHistoryVO.setCntrCgoSeq(dgEdiVO.getCntrCgoSeq());
					dgSendDtlHistoryVO.setDgBlRefNo("");
					dgSendDtlHistoryVO.setDgItmRefNo("");
					dgSendDtlHistoryVO.setCreUsrId(usrId);
					dgSendDtlHistoryVO.setUpdUsrId(usrId);

					dgAutoCancelSendDtlHistoryVOs.add(dgSendDtlHistoryVO);

				}


				if(!currBlNo.equals("")) {

					if(prevBlNo.equals(currBlNo)) continue;

					dgEdiVO.setVvdCd(vvdCd);
					dgEdiVO.setPortCd(portCd);
					dgEdiVO.setDType(dType);

					// 컨테이터 기본정보를 조회한다.
					if(!"AC".equals(dgEdiVO.getSendType())) { // Aouto Cancel을 제외한 전송을 한 경우 ("O" - 최초전송, "U" - 재전송, "C" - 취소전송, "AC" - AUTO CANCEL)
						cntrBaseInfoByBlVOs = dbDao.searchCntrBaseInfo(dgEdiVO);
						cntrBaseInfoVOs.addAll(cntrBaseInfoByBlVOs);
					}
					
				}

				prevBlNo = currBlNo;

			} // end for(i)


			if (cntrBaseInfoVOs != null) {

				int cntrBaseInfoVOsMaxSize = cntrBaseInfoVOs.size();
				for(int idx = 0; idx < cntrBaseInfoVOsMaxSize; idx++) {
					cntrBaseInfoVO = cntrBaseInfoVOs.get(idx);

					flatFile.append("{CNTR").append("\n");
						flatFile.append("CNTRNO:")				.append(cntrBaseInfoVO.getCntrNo()).append("\n");
						flatFile.append("CNTRTS_CD:")			.append(cntrBaseInfoVO.getCntrtsCd()).append("\n");
						flatFile.append("ISO:")					.append(cntrBaseInfoVO.getIso()).append("\n");
						flatFile.append("IMEX:")				.append(cntrBaseInfoVO.getImex()).append("\n");
					flatFile.append("}CNTR").append("\n");

				} // end for(idx)

				String currBkgId = "";
				String preBkgId = "";

				int bkgCnt = 0;
				// bl list로 loop를 돌린다(중복 BL은 continue)
				for(int idx = 0; idx < cntrBaseInfoVOsMaxSize; idx++) {

					cntrBaseInfoVO = cntrBaseInfoVOs.get(idx);

					currBkgId = cntrBaseInfoVO.getLBkgId();

					if(preBkgId.equals(currBkgId)) continue;

					bkgCnt++; // booking 카운트

					flatFile.append("{CONSIGNMENTS").append("\n");

						if(!consignmentEmptyFlag) {

							flatFile.append("{SUB_PARTIES").append("\n");
								flatFile.append("SUB_PARTY_TYPE:")			.append(cntrBaseInfoVO.getSubPartyType()).append("\n");
								flatFile.append("SUB_PARTY_ID:")			.append(cntrBaseInfoVO.getSubPartyId()).append("\n");
								flatFile.append("SUB_AUTHORIZED:")			.append(cntrBaseInfoVO.getSubAuthorized()).append("\n");
								flatFile.append("SUB_ADDRESS1:")			.append(cntrBaseInfoVO.getSubAddress1()).append("\n");
								flatFile.append("SUB_ADDRESS2:")			.append(cntrBaseInfoVO.getSubAddress2()).append("\n");
								flatFile.append("SUB_ADDRESS3:")			.append(cntrBaseInfoVO.getSubAddress3()).append("\n");
								flatFile.append("SUB_ADDRESS4:")			.append(cntrBaseInfoVO.getSubAddress4()).append("\n");
								flatFile.append("SUB_ADDRESS5:")			.append(cntrBaseInfoVO.getSubAddress5()).append("\n");
								flatFile.append("SUB_CONTACT:")				.append(cntrBaseInfoVO.getSubContact()).append("\n");
								flatFile.append("SUB_PHONE:")				.append(cntrBaseInfoVO.getSubPhone()).append("\n");
								flatFile.append("SUB_FAX:")					.append(cntrBaseInfoVO.getSubFax()).append("\n");
								flatFile.append("SUB_REF:")					.append(cntrBaseInfoVO.getSubRef()).append("\n");
							flatFile.append("}SUB_PARTIES").append("\n");

							flatFile.append("{SUB_MEANS").append("\n");
								flatFile.append("SUB_MEANS_TYPE:")			.append(cntrBaseInfoVO.getSubMeansType()).append("\n");
								flatFile.append("SUB_VVD:")					.append(cntrBaseInfoVO.getSubVvd()).append("\n");
								
								if("D".equals(dType)){
									conVVd = comBc.searchConVvd(cntrBaseInfoVO.getSubVvd(), portCd, "I"); 
								}else if("L".equals(dType)){
									conVVd = comBc.searchConVvd(cntrBaseInfoVO.getSubVvd(), portCd, "O");
								}else{
									conVVd = "";
								}
								flatFile.append("SUB_CON_VVD:")				.append(conVVd).append("\n");
								flatFile.append("SUB_MODE:")				.append(cntrBaseInfoVO.getSubMode()).append("\n");
								flatFile.append("SUB_NAME:")				.append(cntrBaseInfoVO.getSubName()).append("\n");
								flatFile.append("SUB_SSR:")					.append(cntrBaseInfoVO.getSubSsr()).append("\n");

								flatFile.append("{SUB_IDS").append("\n");
									flatFile.append("SUB_ID_TYPE:")					.append(cntrBaseInfoVO.getSubIdType()).append("\n");
									flatFile.append("SUB_ID:")						.append(cntrBaseInfoVO.getSubId()).append("\n");
								flatFile.append("}SUB_IDS").append("\n");

								flatFile.append("SUB_NATION:")			.append(cntrBaseInfoVO.getSubNation()).append("\n");
								flatFile.append("SUB_LICENSE:")			.append(cntrBaseInfoVO.getSubLicense()).append("\n");
							flatFile.append("}SUB_MEANS").append("\n");

							flatFile.append("{BOOKINGS").append("\n");

								flatFile.append("{BKG_IDS").append("\n");
									flatFile.append("BKG_ID_TYPE:")			.append(cntrBaseInfoVO.getLBkgIdType()).append("\n");
									flatFile.append("BKG_ID:")				.append(cntrBaseInfoVO.getLBkgId()).append("\n");
								flatFile.append("}BKG_IDS").append("\n");

								flatFile.append("{BKG_IDS").append("\n");
									flatFile.append("BKG_ID_TYPE:")			.append(cntrBaseInfoVO.getBBkgIdType()).append("\n");
									flatFile.append("BKG_ID:")				.append(cntrBaseInfoVO.getBBkgId()).append("\n");
								flatFile.append("}BKG_IDS").append("\n");

								flatFile.append("{BKG_IDS").append("\n");
									flatFile.append("BKG_ID_TYPE:")			.append("S").append("\n");
									flatFile.append("BKG_ID:")				.append(bkgCnt).append("\n");
								flatFile.append("}BKG_IDS").append("\n");

								flatFile.append("{BKG_DATES").append("\n");
									flatFile.append("BKG_DATE_TYPE:")			.append(cntrBaseInfoVO.getBkgDateType()).append("\n");
									flatFile.append("BKG_DATE:")				.append(cntrBaseInfoVO.getBkgDate()).append("\n");
								flatFile.append("}BKG_DATES").append("\n");

								flatFile.append("{BKG_LOCS").append("\n");
									flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPolBkgLocType()).append("\n");
									flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPolBkgLoc()).append("\n");
								flatFile.append("}BKG_LOCS").append("\n");

								flatFile.append("{BKG_LOCS").append("\n");
									flatFile.append("BKG_LOC_TYPE:")			.append(cntrBaseInfoVO.getPodBkgLocType()).append("\n");
									flatFile.append("BKG_LOC:")					.append(cntrBaseInfoVO.getPodBkgLoc()).append("\n");
								flatFile.append("}BKG_LOCS").append("\n");

						} else {

							// empty

							flatFile.append("{SUB_PARTIES").append("\n");
								flatFile.append("SUB_PARTY_TYPE:")			.append("\n");
								flatFile.append("SUB_PARTY_ID:")			.append("\n");
								flatFile.append("SUB_AUTHORIZED:")			.append("\n");
								flatFile.append("SUB_ADDRESS1:")			.append("\n");
								flatFile.append("SUB_ADDRESS2:")			.append("\n");
								flatFile.append("SUB_ADDRESS3:")			.append("\n");
								flatFile.append("SUB_ADDRESS4:")			.append("\n");
								flatFile.append("SUB_ADDRESS5:")			.append("\n");
								flatFile.append("SUB_CONTACT:")				.append("\n");
								flatFile.append("SUB_PHONE:")				.append("\n");
								flatFile.append("SUB_FAX:")					.append("\n");
								flatFile.append("SUB_REF:")					.append("\n");
							flatFile.append("}SUB_PARTIES").append("\n");

							flatFile.append("{SUB_MEANS").append("\n");
								flatFile.append("SUB_MEANS_TYPE:")			.append("\n");
								flatFile.append("SUB_VVD:")					.append("\n");
								flatFile.append("SUB_MODE:")				.append("\n");
								flatFile.append("SUB_NAME:")				.append("\n");
								flatFile.append("SUB_SSR:")					.append("\n");

								flatFile.append("{SUB_IDS").append("\n");
									flatFile.append("SUB_ID_TYPE:")					.append("\n");
									flatFile.append("SUB_ID:")						.append("\n");
								flatFile.append("}SUB_IDS").append("\n");

								flatFile.append("SUB_NATION:")			.append("\n");
								flatFile.append("SUB_LICENSE:")			.append("\n");
							flatFile.append("}SUB_MEANS").append("\n");

							flatFile.append("{BOOKINGS").append("\n");

								flatFile.append("{BKG_IDS").append("\n");
									flatFile.append("BKG_ID_TYPE:")			.append("\n");
									flatFile.append("BKG_ID:")				.append("\n");
								flatFile.append("}BKG_IDS").append("\n");

								flatFile.append("{BKG_IDS").append("\n");
									flatFile.append("BKG_ID_TYPE:")			.append("\n");
									flatFile.append("BKG_ID:")				.append("\n");
								flatFile.append("}BKG_IDS").append("\n");

								flatFile.append("{BKG_IDS").append("\n");
									flatFile.append("BKG_ID_TYPE:")			.append("\n");
									flatFile.append("BKG_ID:")				.append("\n");
								flatFile.append("}BKG_IDS").append("\n");

								flatFile.append("{BKG_DATES").append("\n");
									flatFile.append("BKG_DATE_TYPE:")			.append("\n");
									flatFile.append("BKG_DATE:")				.append("\n");
								flatFile.append("}BKG_DATES").append("\n");

								flatFile.append("{BKG_LOCS").append("\n");
									flatFile.append("BKG_LOC_TYPE:")			.append("\n");
									flatFile.append("BKG_LOC:")					.append("\n");
								flatFile.append("}BKG_LOCS").append("\n");

								flatFile.append("{BKG_LOCS").append("\n");
									flatFile.append("BKG_LOC_TYPE:")			.append("\n");
									flatFile.append("BKG_LOC:")					.append("\n");
								flatFile.append("}BKG_LOCS").append("\n");

						}
							// bl단위로 컨테이터 item정보를 조회하도록 변경
							cntrCgoVOs = dbDao.searchCntrCgoByCntrBase(cntrBaseInfoVO);

							if(cntrCgoVOs != null) {
								for(int j = 0; j < cntrCgoVOs.size(); j++) {
									cntrCgoVO = cntrCgoVOs.get(j);

									if(cntrCgoVO != null) {

										flatFile.append("{ITEMS").append("\n");

											if(!consignmentEmptyFlag) {

												flatFile.append("ITEM_NBR:")			.append(cntrCgoVO.getItemNbr()).append("\n");
												flatFile.append("PKG_QTY:")				.append(cntrCgoVO.getPkgQty()).append("\n");
												flatFile.append("OUTPKG_QTY:")			.append(cntrCgoVO.getOutpkgQty()).append("\n");
												flatFile.append("INPKG_QTY:")			.append(cntrCgoVO.getInpkgQty()).append("\n");
												flatFile.append("PKG_TP:")				.append(cntrCgoVO.getPkgTp()).append("\n");
												flatFile.append("OUTPKG_TP:")			.append(cntrCgoVO.getOutpkgTp()).append("\n");
												flatFile.append("INPKG_TP:")			.append(cntrCgoVO.getInpkgTp()).append("\n");
												flatFile.append("PKG_DESC:")			.append(cntrCgoVO.getPkgDesc()).append("\n");
												flatFile.append("OUTPKG_DESC:")			.append(cntrCgoVO.getOutpkgDesc()).append("\n");
												flatFile.append("INPKG_DESC:")			.append(cntrCgoVO.getInpkgDesc()).append("\n");
												flatFile.append("HAZ_CONT:")			.append(cntrCgoVO.getHazCont()).append("\n");
												flatFile.append("PROP_SHIP_NM:")		.append(cntrCgoVO.getPropShipNm()).append("\n");
												flatFile.append("IMO_CLASS:")			.append(cntrCgoVO.getImoClass()).append("\n");
												flatFile.append("SUB_CLASS1:")			.append(cntrCgoVO.getSubClass1()).append("\n");
												flatFile.append("SUB_CLASS2:")			.append(cntrCgoVO.getSubClass2()).append("\n");
												flatFile.append("SUB_CLASS3:")			.append(cntrCgoVO.getSubClass3()).append("\n");
												flatFile.append("SUB_CLASS4:")			.append(cntrCgoVO.getSubClass4()).append("\n");
												flatFile.append("IMO_COMP:")			.append(cntrCgoVO.getImoComp()).append("\n");
												flatFile.append("IMO_PAGE:")			.append(cntrCgoVO.getImoPage()).append("\n");
												flatFile.append("UN_NBR:")				.append(cntrCgoVO.getUnNbr()).append("\n");
												flatFile.append("UN_NBR_SEQ:")			.append(cntrCgoVO.getUnNbrSeq()).append("\n");

												flatFile.append("FLASH:")				.append(cntrCgoVO.getFlash()).append("\n");
												flatFile.append("FLASH_UNIT:")			.append(cntrCgoVO.getFlashUnit()).append("\n");
												flatFile.append("PKG_GROUP:")			.append(cntrCgoVO.getPkgGroup()).append("\n");
												flatFile.append("EMS_NBR:")				.append(cntrCgoVO.getEmsNbr()).append("\n");
												flatFile.append("MFAG:")				.append(cntrCgoVO.getMfag()).append("\n");
												flatFile.append("ESPN:")				.append(cntrCgoVO.getEspn()).append("\n");
												flatFile.append("ADD_REMARKS:")			.append(cntrCgoVO.getDiffRmk()).append("\n");
												flatFile.append("POLLUTANT:")			.append(cntrCgoVO.getPollutant()).append("\n");
												flatFile.append("IMO_LIMIT:")			.append(cntrCgoVO.getImoLimit()).append("\n");
												flatFile.append("HCDG:")				.append(cntrCgoVO.getHcdg()).append("\n");
												flatFile.append("GROSSWGT:")			.append(cntrCgoVO.getGrosswgt()).append("\n");
												flatFile.append("GROSSWGT_UNIT:")		.append(cntrCgoVO.getGrosswgtUnit()).append("\n");
												flatFile.append("NETWGT:")				.append(cntrCgoVO.getNetwgt()).append("\n");
												flatFile.append("NETWGT_UNIT:")			.append(cntrCgoVO.getNetwgtUnit()).append("\n");

												flatFile.append("NW_EXPLOSIVE:")		.append(cntrCgoVO.getNwExplosive()).append("\n");
												flatFile.append("NW_EXP_UNIT:")			.append(cntrCgoVO.getNwExpUnit()).append("\n");
//												flatFile.append("NW_EXPLOSIVE:")		.append("").append("\n");
//												flatFile.append("NW_EXP_UNIT:")			.append("").append("\n");

												flatFile.append("CNTRNBR:")				.append(cntrCgoVO.getCntrnbr()).append("\n");
												flatFile.append("STOWPOS:")				.append(cntrCgoVO.getStowpos()).append("\n");

											} else {
												flatFile.append("ITEM_NBR:")			.append("\n");
												flatFile.append("PKG_QTY:")				.append("\n");
												flatFile.append("OUTPKG_QTY:")			.append("\n");
												flatFile.append("INPKG_QTY:")			.append("\n");
												flatFile.append("PKG_TP:")				.append("\n");
												flatFile.append("OUTPKG_TP:")			.append("\n");
												flatFile.append("INPKG_TP:")			.append("\n");
												flatFile.append("PKG_DESC:")			.append("\n");
												flatFile.append("OUTPKG_DESC:")			.append("\n");
												flatFile.append("INPKG_DESC:")			.append("\n");
												flatFile.append("HAZ_CONT:")			.append("\n");
												flatFile.append("PROP_SHIP_NM:")		.append("\n");
												flatFile.append("IMO_CLASS:")			.append("\n");
												flatFile.append("SUB_CLASS1:")			.append("\n");
												flatFile.append("SUB_CLASS2:")			.append("\n");
												flatFile.append("SUB_CLASS3:")			.append("\n");
												flatFile.append("SUB_CLASS4:")			.append("\n");
												flatFile.append("IMO_PAGE:")			.append("\n");
												flatFile.append("UN_NBR:")				.append("\n");
												flatFile.append("UN_NBR_SEQ:")			.append("\n");

												flatFile.append("FLASH:")				.append("\n");
												flatFile.append("FLASH_UNIT:")			.append("\n");
												flatFile.append("PKG_GROUP:")			.append("\n");
												flatFile.append("EMS_NBR:")				.append("\n");
												flatFile.append("MFAG:")				.append("\n");
												flatFile.append("ESPN:")				.append("\n");
												flatFile.append("ADD_REMARKS:")			.append("\n");
												flatFile.append("POLLUTANT:")			.append("\n");
												flatFile.append("IMO_LIMIT:")			.append("\n");
												flatFile.append("HCDG:")				.append("\n");
												flatFile.append("GROSSWGT:")			.append("\n");
												flatFile.append("GROSSWGT_UNIT:")		.append("\n");
												flatFile.append("NETWGT:")				.append("\n");
												flatFile.append("NETWGT_UNIT:")			.append("\n");

												flatFile.append("NW_EXPLOSIVE:")		.append("\n");
												flatFile.append("NW_EXP_UNIT:")			.append("\n");

												flatFile.append("CNTRNBR:")				.append("\n");
												flatFile.append("STOWPOS:")				.append("\n");

											}


										flatFile.append("}ITEMS").append("\n");

										/* send log detail VO 저장 */
										dgSendDtlHistoryVO = new DgSendDtlHistoryVO();
										dgSendDtlHistoryVO.setEurEdiMsgTpId("IFD");
										dgSendDtlHistoryVO.setMsgSndNo(sndKey);
										dgSendDtlHistoryVO.setBlNo(cntrBaseInfoVO.getLBkgId());
										dgSendDtlHistoryVO.setCntrNo(cntrCgoVO.getCntrnbr());
										dgSendDtlHistoryVO.setCntrCgoSeq(cntrCgoVO.getItemNbr());
										dgSendDtlHistoryVO.setDgBlRefNo("");
										dgSendDtlHistoryVO.setDgItmRefNo("");
										dgSendDtlHistoryVO.setCreUsrId(usrId);
										dgSendDtlHistoryVO.setUpdUsrId(usrId);

										dgSendDtlHistoryVOs.add(dgSendDtlHistoryVO);
									}
								} // end for(j)
							}
						flatFile.append("}BOOKINGS").append("\n");
					flatFile.append("}CONSIGNMENTS").append("\n");


					preBkgId = currBkgId;

				} // end for(idx)

			}

			flatFile.append("}DECL").append("\n");



			///////////////////////////////////
			// EDI_PREVIEW일때는 저장하지 않음
			///////////////////////////////////
			if (!"Y".equals(ediPreview)) {
				/* FlatFile을 4000Byte씩 나눈다 - start*/
				int divisor = 3900;
				int totLength = flatFile.length();
				int quotient = totLength / divisor;
				int remainder = totLength % divisor;

				int loopCnt = 0;
				int start = 0;
				int end = 0;

				if(remainder > 0) {
					loopCnt = quotient + 1;
				} else {
					loopCnt = quotient;
				}

				String[] fFiles = new String[loopCnt];

				for(int i = 0; i < loopCnt; i++) {
					if(i == loopCnt-1) {
						end = remainder;
					} else {
						end = divisor;
					}

					start = i * divisor;

					fFiles[i] = flatFile.substring(start, start+end);

					/* send Flat File log VO 셋팅*/
					dgSendFlatFileHistoryVO = new DgSendHistoryVO(); // send
					dgSendFlatFileHistoryVO.setMsgSndNo(dgSendHistoryVO.getMsgSndNo());
					dgSendFlatFileHistoryVO.setEurEdiMsgTpId(dgSendHistoryVO.getEurEdiMsgTpId());
					dgSendFlatFileHistoryVO.setCreUsrId(dgSendHistoryVO.getCreUsrId());
					dgSendFlatFileHistoryVO.setUpdUsrId(dgSendHistoryVO.getUpdUsrId());
					dgSendFlatFileHistoryVO.setMsgDesc(fFiles[i]);

					dgSendFlatFileHistoryVOs.add(dgSendFlatFileHistoryVO);
				}

				// bkg_cstms_eur_snd_log 테이블에 FlatFile을 (4000byte씩)통으로 저장한다.
				if(dgSendFlatFileHistoryVOs != null) {
					dbDao.addSendFlatFileLog(dgSendFlatFileHistoryVOs);
				}

				log.debug("Auto Cancel이 아닌 경우만 -------------------------------------------------------");
				// 전송로그를 저장한다. (MASTER) - Auto Cancel이 아닌 경우만
				if(dgSendHistoryVO != null) {
					dbDao.addSendLog(dgSendHistoryVO);
				}
				// 전송로그를 저장한다. (DETAIL) - Auto Cancel이 아닌 경우만
				if(dgSendDtlHistoryVOs != null && dgSendDtlHistoryVOs.size() > 0) {
					dbDao.addSendDtlLog(dgSendDtlHistoryVOs);
				}

				log.debug("Auto Cancel인 경우만 -------------------------------------------------------");
				// 전송로그를 저장한다. (MASTER) - Auto Cancel인 경우만
				if(dgAutoCancelSendHistoryVO != null ) {
					dbDao.addSendLog(dgAutoCancelSendHistoryVO);
				}
				// 전송로그를 저장한다. (DETAIL) - Auto Cancel인 경우만
				if(dgAutoCancelSendDtlHistoryVOs != null && dgAutoCancelSendDtlHistoryVOs.size() > 0) {
					dbDao.addSendDtlLog(dgAutoCancelSendDtlHistoryVOs);
				}

				// MQ로 전송한다.
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EURDG.IBMMQ.QUEUE"));

				FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

				if ( flatFileAckVO.getAckStsCd().equals("E") ) {
					throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				}
			}

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			throw ee;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return flatFile.toString();
	}

	/**
	 * RECEIVE받은 FLAT FILE을 수신 구분별로 분기한다.<br>
	 * @param rcvMsg
	 * @param rcvGubun
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String rcvGubun) throws EventException {

		if(rcvGubun.equalsIgnoreCase("OpusBkgTEurbaplieEvent")) { // BAPLIE 수신
			this.loadBaplieRcvMsg(rcvMsg);
		} else if(rcvGubun.equalsIgnoreCase("OpusBkgTEurcusAckEven")) { // 구주위험물 신고 응답메시지 수신
			this.loadAperakRcvMsg(rcvMsg);
		}

	}


	/**
	 * RECEIVE받은 BAPLIE 수신 FLAT FILE을 로그테이블에 생성한다.  <br>
	 *
	 * @param String rcvMsg
	 * @throws EventException
	 */
	private void loadBaplieRcvMsg(String rcvMsg) throws EventException {

		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		ArrayList<String> tmpArray = new ArrayList<String>();
		String tmpStr = "";
		String keyAndValue[] = null;
		String regex = ":";
		int tmpArrayMaxSize = 0;
		String bayPlnId = "";

		String key = "";
		String value = "";

		String rcvId = "";

		DgBayRcvMsgVO dgBayRcvMsgVO = null;
		DgBayRcvMsgDtlVO dgBayRcvMsgDtlVO = null;
		List<DgBayRcvMsgDtlVO> dgBayRcvMsgDtlVOs = new ArrayList<DgBayRcvMsgDtlVO>();

		try {

			dgBayRcvMsgVO = new DgBayRcvMsgVO();

			while (token.hasMoreTokens()) {

				tmpArray.add(token.nextToken());
			}

			tmpArrayMaxSize = tmpArray.size();

			if(tmpArray != null && tmpArrayMaxSize > 0) {


				for ( int i=0 ; i<tmpArrayMaxSize ; i++ ){

					tmpStr = tmpArray.get(i).toString().trim();



					if(tmpStr.equalsIgnoreCase("{EQ")) {
						dgBayRcvMsgDtlVO = new DgBayRcvMsgDtlVO();
						dgBayRcvMsgDtlVO.setBayPlnId(bayPlnId);

						dgBayRcvMsgDtlVO.setCreUsrId(rcvId);
						dgBayRcvMsgDtlVO.setUpdUsrId(rcvId);
					}

					if(tmpStr.equalsIgnoreCase("}EQ")) {
						dgBayRcvMsgDtlVOs.add(dgBayRcvMsgDtlVO);

					}


					if(tmpStr.equalsIgnoreCase("{VSL") || tmpStr.equalsIgnoreCase("}VSL")
							|| tmpStr.equalsIgnoreCase("{EQ") || tmpStr.equalsIgnoreCase("}EQ") )
						continue;

					keyAndValue = tmpStr.split(regex);

					key = keyAndValue[0].trim();

					if(keyAndValue.length == 1) {
						value = "";
					} else if(keyAndValue.length >= 2) {
						value = keyAndValue[1].trim();
					}

					//value = (keyAndValue[1].length() > 0) ? keyAndValue[1].trim() : "";

					if(key.equalsIgnoreCase("MSG_SENDER")) {
						dgBayRcvMsgVO.setMsgSndrCtnt(value);

						rcvId = value;

						dgBayRcvMsgVO.setCreUsrId(rcvId);
						dgBayRcvMsgVO.setUpdUsrId(rcvId);


					} else if(key.equalsIgnoreCase("VOYAGE")) {
						dgBayRcvMsgVO.setVslVoyDirNo(value);
					} else if(key.equalsIgnoreCase("CALL_SIGN")) {
						dgBayRcvMsgVO.setEurDgCallSgnNo(value);

						// bay_pln_id를 조회한다.
						bayPlnId = dbDao.searchDgBayPlnId(value);
						dgBayRcvMsgVO.setBayPlnId(bayPlnId);

					} else if(key.equalsIgnoreCase("VESSEL")) {
						dgBayRcvMsgVO.setVslNm(value);
					} else if(key.equalsIgnoreCase("CARRIER")) {
						dgBayRcvMsgVO.setCrrId(value);
					} else if(key.equalsIgnoreCase("PORT_OF_DEP")) {
						dgBayRcvMsgVO.setEurDgDepPortCd(value);
					} else if(key.equalsIgnoreCase("NEXT_PORT")) {
						dgBayRcvMsgVO.setEurDgNxtPortCd(value);
					} else if(key.equalsIgnoreCase("ARR_DT")) {
						dgBayRcvMsgVO.setEtaDt(value);
					} else if(key.equalsIgnoreCase("DEP_DT")) {
						dgBayRcvMsgVO.setEtdDt(value);

					} else if(key.equalsIgnoreCase("STORAGE_CELL")) {
						dgBayRcvMsgDtlVO.setCellPsnNo(value);
					} else if(key.equalsIgnoreCase("MEA_U")) {
						dgBayRcvMsgDtlVO.setCntrWgtUtCd(value);
					} else if(key.equalsIgnoreCase("MEA_V")) {
						dgBayRcvMsgDtlVO.setGrsWgt(value);
					} else if(key.equalsIgnoreCase("LOC")) {
						dgBayRcvMsgDtlVO.setPolCd(value);
					} else if(key.equalsIgnoreCase("POD")) {
						dgBayRcvMsgDtlVO.setPodCd(value);
					} else if(key.equalsIgnoreCase("DEL")) {
						dgBayRcvMsgDtlVO.setDelCd(value);
					} else if(key.equalsIgnoreCase("EQ_NO")) {
						dgBayRcvMsgDtlVO.setEurDgCntrId(value);
					} else if(key.equalsIgnoreCase("ISO_TPSZ")) {
						dgBayRcvMsgDtlVO.setIsoCntrTpszCd(value);
					} else if(key.equalsIgnoreCase("FULL_EMPTY")) {
						dgBayRcvMsgDtlVO.setEurDgFullMtyCd(value);
					} else if(key.equalsIgnoreCase("SUB_CARRIER")) {
						dgBayRcvMsgDtlVO.setCntrOprId(value);
					} else if(key.equalsIgnoreCase("HAZARD_CD")) {
						dgBayRcvMsgDtlVO.setImdgClssCd(value);
					} else if(key.equalsIgnoreCase("IMDG_NBR")) {
						dgBayRcvMsgDtlVO.setImdgUnNo(value);
					}


				} // end for(i)


				if(dgBayRcvMsgVO.getBayPlnId() == null || "".equals(dgBayRcvMsgVO.getBayPlnId())) {
					log.error("err>> [Parsing Error]BayPlnId is null!");
					throw new EventException("[Parsing Error]BayPlnId is null!");
				}

				// 수신마스터 저장
				dbDao.addDgBayAck(dgBayRcvMsgVO);

				// 수신 디테일 저장
				dbDao.addDgBayAckDtl(dgBayRcvMsgDtlVOs);
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 구주위험물 수신
	 * RECEIVE받은 APERAK 수신 FLAT FILE을 로그테이블에 생성한다.  <br>
	 *
	 * @param rcvMsg
	 * @throws EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadAperakRcvMsg(String rcvMsg) throws EventException {

		StringTokenizer token = new StringTokenizer(rcvMsg, "\n");

		ArrayList tmpArray = new ArrayList();
		String tmpStr = "";
		String keyAndValue[] = null;
		int keyAndValueMaxSize = 0;
		String regex = ":";
		int tmpArrayMaxSize = 0;
		String rcvLogSeq = "";

		String key = "";
		String value = "";

		String rcvId = "";

		String msgTpId = "IFD";
		EurRcvMsgVO eurRcvMsgVO = null;
		EurRcvMsgDtlVO eurRcvMsgDtlVO = null;
		List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs = new ArrayList();

		try {

			eurRcvMsgVO = new EurRcvMsgVO();

			while (token.hasMoreTokens()) {

				tmpArray.add(token.nextToken());
			}

			tmpArrayMaxSize = tmpArray.size();

			if(tmpArray != null && tmpArrayMaxSize > 0) {

				eurRcvMsgVO.setMsgTpId(msgTpId);

				for ( int i=0 ; i<tmpArrayMaxSize ; i++ ){


					tmpStr = tmpArray.get(i).toString().trim();

					if(tmpStr.equalsIgnoreCase("{ERRORS")) {
						eurRcvMsgDtlVO = new EurRcvMsgDtlVO();
						eurRcvMsgDtlVO.setKeyVal(eurRcvMsgVO.getKeyVal());
						eurRcvMsgDtlVO.setMsgTpId(msgTpId);
						eurRcvMsgDtlVO.setCreUsrId(rcvId);
						eurRcvMsgDtlVO.setUpdUsrId(rcvId);

					}

					if(tmpStr.equalsIgnoreCase("}ERRORS")) {
						eurRcvMsgDtlVOs.add(eurRcvMsgDtlVO);
					}


					if(tmpStr.equalsIgnoreCase("{ERRORS") || tmpStr.equalsIgnoreCase("}ERRORS") ) continue;

					keyAndValue = tmpStr.split(regex);

					key = keyAndValue[0].trim();

					keyAndValueMaxSize = keyAndValue.length;
					if(keyAndValueMaxSize == 1) {
						value = "";
					} else if(keyAndValueMaxSize >= 2) {
						value = keyAndValue[1].trim();
						if(keyAndValueMaxSize > 2) {
							value = value + " : " + keyAndValue[2].trim();
						}
					}

					if(key.equalsIgnoreCase("ORG_MSG_RCV")) {

						rcvId = value;
						eurRcvMsgVO.setCreUsrId(rcvId);
						eurRcvMsgVO.setUpdUsrId(rcvId);

					} else if(key.equalsIgnoreCase("ORG_MSG_KEY")) {
						eurRcvMsgVO.setKeyVal(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_TP")) {
						eurRcvMsgVO.setOrgMsgTp(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_NM")) {
						eurRcvMsgVO.setOrgMsgNm(value);
					} else if(key.equalsIgnoreCase("MSG_UDT_FLG")) {
						eurRcvMsgVO.setMsgUdtFlg(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_TP")) {
						eurRcvMsgVO.setMsgAckTp(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_RSLT")) {
						eurRcvMsgVO.setMsgAckRslt(value);
					} else if(key.equalsIgnoreCase("MSG_ACK_DT")) {
						eurRcvMsgVO.setMsgAckDt(value);
					} else if(key.equalsIgnoreCase("MSG_APPROVE_DT")) {
						eurRcvMsgVO.setMsgApproveDt(value);
					} else if(key.equalsIgnoreCase("MSG_PHONE")) {
						eurRcvMsgVO.setMsgPhone(value);
					} else if(key.equalsIgnoreCase("MSG_FAX")) {
						eurRcvMsgVO.setMsgFax(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_CNTR")) {
						eurRcvMsgVO.setOrgMsgCntr(value);
					} else if(key.equalsIgnoreCase("ORG_MSG_BL")) {
						eurRcvMsgVO.setOrgMsgBl(value);
					} else if(key.equalsIgnoreCase("ERR_CODE")) {
						eurRcvMsgDtlVO.setCstmsErrId(value);
					} else if(key.equalsIgnoreCase("ERR_MSG")) {
						eurRcvMsgDtlVO.setCstmsErrMsg(value);
					} else if(key.equalsIgnoreCase("ERR_RFF_1")) {
						eurRcvMsgDtlVO.setCstmsErrRefNo1(value);
					} else if(key.equalsIgnoreCase("ERR_RFF_2")) {
						eurRcvMsgDtlVO.setCstmsErrRefNo2(value);
					} else if(key.equalsIgnoreCase("SEC_FILE_NBR")) {
						eurRcvMsgVO.setSecFileNbr(value);
					} else if(key.equalsIgnoreCase("MSG_ACCEPT_REF")) {
						eurRcvMsgVO.setMsgAcceptRef(value);
					}




				} // end for(i)

				rcvLogSeq = dbDao.searchRcvLogSeq("IFD", eurRcvMsgVO.getKeyVal()); 	// rcv_log_seq

				// 수신마스터 저장
				eurRcvMsgVO.setRcvLogSeq(rcvLogSeq);
				dbDao.addAck(eurRcvMsgVO);

				for(int i = 0; i < eurRcvMsgDtlVOs.size(); i++) {
					eurRcvMsgDtlVOs.get(i).setRcvLogSeq(rcvLogSeq);
				}

				// 수신 디테일 저장
				dbDao.addAckDtl(eurRcvMsgDtlVOs);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}


	}


	/**
	 * bl_no / pol_cd / pod_cd를 입력시 validation<br>
	 *
	 * @param dgValidationCondVO
	 * @return DgListDetailVO
	 * @throws DAOException
	 */
	public DgListDetailVO searchDgValidationByVvdKey(DgValidationCondVO dgValidationCondVO) throws EventException {

		try {
			return dbDao.searchDgValidationByVvdKey(dgValidationCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * cntr_no를 입력시 validation<br>
	 *
	 * @param dgValidationCondVO
	 * @return DgListDetailVO
	 * @throws DAOException
	 */
	public DgListDetailVO searchDgValidationByCntrKey(DgValidationCondVO dgValidationCondVO) throws EventException {

		try {
			return dbDao.searchDgValidationByCntrKey(dgValidationCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * pol_cd, pod_cd를 입력시 validation<br>
	 *
	 * @param dgValidationCondVO
	 * @return DgListDetailVO
	 * @throws DAOException
	 */
	public String searchDgValidationByPort(DgValidationCondVO dgValidationCondVO) throws EventException {

		try {
			return dbDao.searchDgValidationByPort(dgValidationCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}
	
	

	/**
	 * vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.<br>
	 *
	 * @param  DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgLocalSaveYn(DgListCondVO dgListCondVO) throws EventException {

		List<DgListDetailVO> dgListDetailVOs = null;
		String retVal = "";

		try {
			dgListDetailVOs =  dbDao.searchDgInfoAtLocal(dgListCondVO);

			if(dgListDetailVOs != null) {

				if(dgListDetailVOs.size() > 0) {
					retVal = "Y"; // local data
				} else {
					retVal = "N"; // booking data

				}
			}


		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return retVal;

	}

	/**
	 * B/L No.로 BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return List<DgListDetailVO>
	 * @throws EventException
	 */
	public List<DgListDetailVO> searchDgInfoAtBkgDgByBlNo(DgListCondVO dgListCondVO) throws EventException {
		try {
			return dbDao.searchDgInfoAtBkgDg(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.<br>
	 * Loading(L) -> Loading(L)+Pre-carriage(P) 가 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
	 * Loading(L)+Pre-carriage(P) -> Loading(L) 이 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
	 * Discharging(D) -> Discharging(D)+On-Carriage(O) 가 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
	 * Discharging(D)+On-Carriage(O) -> Discharging(D)이 등록되었는지를 판다.있으면 return "Y" 없으면 return "N"<br>
	 * Transit(T) -> return "N"<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws EventException
	 */
	public String searchDgListCopyYn(DgListCondVO dgListCondVO) throws EventException {
		try {
			return dbDao.searchDgListCopyYn(dgListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Feeder Name, Lloyd No를 조회한다.<br>
	 *
	 * @return List<FeederNameVO>
	 * @throws EventException
	 */
	public List<FeederNameVO> searchDgFeederNameList() throws EventException {
		try {
			return dbDao.searchDgFeederNameList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Feeder 정보를 조회한다.<br>
	 *
	 * @param FeederInfoVO feederInfoVO
	 * @return List<FeederInfoVO>
	 * @exception EventException
	 */
	public List<FeederInfoVO> searchFeederInfoList(FeederInfoVO feederInfoVO) throws EventException {

		List<FeederInfoVO> list = null;

		try {
			list = dbDao.searchFeederInfoList(feederInfoVO);


		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * feeder 정보를 추가, 수정, 삭제 한다.<br>
	 *
	 * @param  FeederInfoVO[] feederInfoVOs
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageFeederInfoList(FeederInfoVO[] feederInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<FeederInfoVO> insertVoList = new ArrayList<FeederInfoVO>();
			List<FeederInfoVO> updateVoList = new ArrayList<FeederInfoVO>();
			List<FeederInfoVO> deleteVoList = new ArrayList<FeederInfoVO>();

			for ( int i=0; i<feederInfoVOs .length; i++ ) {
				if ( feederInfoVOs[i].getIbflag().equals("I")){
					feederInfoVOs[i].setCreUsrId(account.getUsr_id());
					feederInfoVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(feederInfoVOs[i]);
				} else if ( feederInfoVOs[i].getIbflag().equals("U")){
					feederInfoVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(feederInfoVOs[i]);
				} else if ( feederInfoVOs[i].getIbflag().equals("D")){
					feederInfoVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(feederInfoVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addFeederInfoList(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.updateFeederInfoList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFeederInfoList(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	
	/**
	 * 위험물 정보중 파트너 부킹정보를 마감한다..<br>
	 *
	 * @param  DgListCondVO dgListCondVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCloseScg(DgListCondVO dgListCondVO, SignOnUserAccount account) throws EventException {

		String dType = "";

		boolean copyFlag = false;

		// 0965화면에서 DG LIST COPY 체크박스가 체크되면...
		if("ESM_BKG_0965".equals(dgListCondVO.getUiType()) && "Y".equals(dgListCondVO.getDgListCopyFlag())) {
			dType = dgListCondVO.getDType();

			if("D".equals(dType)) {
				dgListCondVO.setDType("DO");
			} else if("DO".equals(dType)) {
				dgListCondVO.setDType("D");
			} else if("L".equals(dType)) {
				dgListCondVO.setDType("PL");
			} else if("PL".equals(dType)) {
				dgListCondVO.setDType("L");

			}

			copyFlag = true;
		}

		try {
			dgListCondVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyCloseScg(dgListCondVO);
			

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * Eur Dg Port Retrieve<br>
	 *
	 * @param EurDgListVO eurDgListVO
	 * @return List<EurDgListVO>
	 * @exception EventException
	 */
	public List<EurDgListVO> searchEurDgPortList(EurDgListVO eurDgListVO) throws EventException {
		List<EurDgListVO> list = null;
		
		try {
			list = dbDao.searchEurDgPortList(eurDgListVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Eur Dg Port Multi<br>
	 *
	 * @param  EurDgListVO[] eurDgListVOs
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageEurDgPortList(EurDgListVO[] eurDgListVOs, SignOnUserAccount account) throws EventException {
		try {			
			List<EurDgListVO> updateVoList = new ArrayList<EurDgListVO>();
			List<EurDgListVO> deleteVoList = new ArrayList<EurDgListVO>();

			for ( int i=0; i<eurDgListVOs .length; i++ ) {
				if ( eurDgListVOs[i].getIbflag().equals("I")){
					eurDgListVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(eurDgListVOs[i]);
				} else if ( eurDgListVOs[i].getIbflag().equals("U")){
					eurDgListVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(eurDgListVOs[i]);
				} else if ( eurDgListVOs[i].getIbflag().equals("D")){
					eurDgListVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(eurDgListVOs[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.updateEurDgPortList(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEurDgPortList(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * Eur Dg Send Email.<br>
	 *
	 * @param  EurDgListVO eurDgListVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendEurDgEmail(EurDgListVO eurDgListVO, SignOnUserAccount account) throws EventException {
		try {			
			dbDao.sendEurDgEmail(eurDgListVO, account);			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * Eur Dg Port Excel List Retrieve<br> 
	 *
	 * @param EurDgListVO eurDgListVO
	 * @return List<EurDgListVO>
	 * @exception EventException
	 */
	public List<EurDgListVO> searchEurDgExcelList(EurDgListVO eurDgListVO) throws EventException {
		List<EurDgListVO> list = null;
		
		try {
			list = dbDao.searchEurDgExcelList(eurDgListVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Eur Dg Port Summary Excel List Retrieve<br> 
	 *
	 * @param EurDgSummaryListVO eurDgSummaryListVO
	 * @return List<EurDgSummaryListVO>
	 * @exception EventException
	 */
	public List<EurDgSummaryListVO> searchEurDgSummaryExcelList(EurDgSummaryListVO eurDgSummaryListVO) throws EventException {
		List<EurDgSummaryListVO> list = null;
		
		try {
			list = dbDao.searchEurSummaryDgExcelList(eurDgSummaryListVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Return the data of BKG_CSTMS_EUR_DG_HIS<br> 
	 *
	 * @param EurDgHisVO eurDgHisVO
	 * @return List<EurDgHisVO> 
	 * @exception EventException
	 */
	public List<EurDgHisVO> searchEurDgHis(EurDgHisVO eurDgHisVO) throws EventException {
		List<EurDgHisVO> list = null;
		int select_seq = 0;
		
		String old_his_seq = "";
		try {
			list = dbDao.searchEurDgHis(eurDgHisVO);
			
			if(list !=null && list.size() > 0){
					
				EurDgHisVO eurDgHisVOTemp = new EurDgHisVO();
				for (int i=0; i < list.size(); i++) {
					
					if( !(old_his_seq.equals(list.get(i).getHisSeq())) ){
						select_seq++;
					}
					
					old_his_seq = list.get(i).getHisSeq();
					eurDgHisVOTemp = list.get(i);
					//Change the his_seq to retrieve sequence via eurDgHisVOTemp
					eurDgHisVOTemp.setHisSeq(String.valueOf(select_seq));
					
					
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}
}
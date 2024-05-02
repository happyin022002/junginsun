/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RestuffingContainerRegistrationBCImpl.java
 *@FileTitle : Restuffing Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 우경민
 *@LastVersion : 1.0
 * 2009.04.27 우경민
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
 * 2011.01.05 김상수 [CHM-201108153-01] [CTM] Restuffing Creation 기능 보완 관련
 *                    1. Restuffing 관련 된 부분의 data는 과거 data를 기반으로 반영
 *                    2. Movement 관련 된 부분의 data는 현재 진행 되는 data에 id를 증가시켜 반영
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration.RestuffingContainerRegistrationDBDAO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMvmtXchDtlVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.InsCtmMvmtXchVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.UpdMstCntrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-RestuffingMgt Business Logic Basic Command implementation<br>
 * - ALPS-RestuffingMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KyungMin Woo
 * @see UI_CTM_0423EventResponse,RestuffingContainerRegistrationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RestuffingContainerRegistrationBCImpl extends BasicCommandSupport implements RestuffingContainerRegistrationBC {

	// Database Access Object
	private transient RestuffingContainerRegistrationDBDAO dbDao = null;

	/**
	 * RestuffingContainerRegistrationBCImpl 객체 생성<br>
	 * RestuffingContainerRegistrationDBDAO를 생성한다.<br>
	 */
	public RestuffingContainerRegistrationBCImpl() {
		dbDao = new RestuffingContainerRegistrationDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 *  Restuffing대상 목록 조회..<br>
	 *
	 * @param RetuffingListVO   RetuffingListVO
	 * @return List<CtmMvmtXchVO>
	 * @exception EventException
	 */
	public List<RetuffingListVO> searchRestuffingList(RetuffingListVO retuffingListVO) throws EventException {
		try {
			return dbDao.searchRestuffingList(retuffingListVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("COM10001", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("COM10001", new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * 0445 POPUP화면을 위한 조회이벤트 처리. <br>
	 *
	 * @param CtmMovementHistoryVO ctmMovementHistoryVO
	 * @param String flg
	 * @return List<CTMRestuffingVO>
	 * @exception EventException
	 */
	public List<CTMRestuffingVO> searchOBJMVMT(CtmMovementHistoryVO ctmMovementHistoryVO, String flg) throws EventException {
		try {
			return dbDao.searchOBJMVMT(ctmMovementHistoryVO, flg);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{"Select container movement history list error!"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{"Select container movement history list error!"}).getMessage(), ex);
		}
	}

	/**
	 * 0422 CTM_MOVEMENT Restuffing SAVE.<br>
	 *
	 * @param  CtmRestuffingDetailVO[] ctmRestuffingDetailVOs
	 * @param  SignOnUserAccount account
	 * @return UpdMstCntrVO
	 * @exception EventException
	 */
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public UpdMstCntrVO createRestuffingContainer(CtmRestuffingDetailVO[] ctmRestuffingDetailVOs, SignOnUserAccount account) throws EventException{
		boolean notUseFlg = false;

		//Master Container Update List
		CusCtmMovementVO[] mstUpd = new CusCtmMovementVO[ctmRestuffingDetailVOs.length + 1];
		CusCtmMovementVO[] ctmUpd = new CusCtmMovementVO[ctmRestuffingDetailVOs.length + 1];

		UpdMstCntrVO updVo = new UpdMstCntrVO();
		Map map = new HashMap();

		CtmRestuffingDetailVO cVO = null;
		CusCtmMovementVO   ctmMov = null;
		CtmRestuffingDetailVO   srcVo = null;
		String status = null;
		String resSeq = null;
		String cntrNo = null;
		String cnmvYr = null;
		String yardCd = null;
		String cnmvIdNo = null;
		String cnmvCycNo = null;
		String loc = null;
		String rcc = null;
		String lcc = null;
		String office = null;
		String flgDisp = null;
		String flgDmg = null;
		String flgRef = null;
		String lvlCd = null;
		String lstCnmvId = null;
		String lstCnmvYr = "";
		String mvmtStsCd = null;
		MstContainerInfoVO cntrVO = null;
		String yr = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

		int mstidx = 0;
		int ctmidx = 0;
		boolean fndCd = false;

		for (int x = 0; x < ctmRestuffingDetailVOs.length; x++) {
			try {
				if ("D".equals(ctmRestuffingDetailVOs[x].getSaveFlg()) || "P".equals(ctmRestuffingDetailVOs[x].getSaveFlg())) {
					srcVo = ctmRestuffingDetailVOs[x];

					cntrNo = srcVo.getCntrNo() + srcVo.getCheckDigit();
					cnmvYr = srcVo.getCnmvYr();
					cnmvIdNo = srcVo.getCnmvIdNo();
					yardCd = srcVo.getOrgYdCd();
					mvmtStsCd = srcVo.getMvmtStsCd();
					log.info("야드 " +yardCd);
					map = srcVo.getColumnValues();
					map.put("cntr_no", cntrNo);
					log.info("MAP PRINT");
					/***********************************************************
					 * MST_CONTAINER에서 해당 컨테이너의 모든 정보를 가져온다. *
					 ***********************************************************/
					/***********************************
					 * 컨테이너의 이동정보를 얻어온다  *
					 ***********************************/
					ctmMov = dbDao.getMovementInfo(cntrNo, cnmvIdNo, cnmvYr);
					cnmvCycNo = ctmMov.getCnmvCycNo();
					cntrVO = dbDao.getCntrInfo(cntrNo);
					// Restuffing Sequence
					resSeq = dbDao.searchRSFSEQ(cntrNo, cnmvIdNo, cnmvYr);
					String[] lccRcc = dbDao.getLocationInfo(yardCd);
					if (lccRcc != null && lccRcc[0] != null && !lccRcc[0].equals("")) {
						loc = lccRcc[0];
						lcc = lccRcc[1];
						rcc = lccRcc[2];
					}
					office = dbDao.getOfcCdByYard(yardCd);
				}
				ctmRestuffingDetailVOs[x].setCnmvYr(yr);

			} catch (Exception ex) {
				throw new EventException(ex.getMessage(),ex);
			}
		}

		for (int x = 0; x < ctmRestuffingDetailVOs.length; x++) {
			// Sheet2("D"가 아닌row)이면서 CntrNo가 같거나, UI에서 팝업으로 넘어온 row가 있으면 Update만 하는 Flag를 설정
			if ( (cntrNo.equals(ctmRestuffingDetailVOs[x].getCntrNo() + srcVo.getCheckDigit()) && !"D".equals(ctmRestuffingDetailVOs[x].getSaveFlg()))
				|| "P".equals(ctmRestuffingDetailVOs[x].getSaveFlg()) ) {
				fndCd = true;   // Update만
			}
		}


		for (int idx = 0; idx < ctmRestuffingDetailVOs.length; idx++) {
			CusCtmMovementVO iVo = new CusCtmMovementVO();
			cVO = null;
			cVO = ctmRestuffingDetailVOs[idx];
			cVO.setCntrNo(cVO.getCntrNo() + cVO.getCheckDigit());
			InsCtmMvmtXchVO xchVo = new InsCtmMvmtXchVO();

			try {
				status = cVO.getSaveFlg();

				String reson = cVO.getResonCd();
				String[] resonCd = reson.split(",");

				for (int i = 0; i < resonCd.length; i++) {
					if ("DM".equals(resonCd[i])) {
						flgDmg = "Y";
					} else if ("DP".equals(resonCd[i])) {
						flgDisp = "Y";
					} else if ("RP".equals(resonCd[i])){
						flgRef = "Y";
					}
				}

				int idNo  = Integer.parseInt(dbDao.getContainerMaxId(ctmRestuffingDetailVOs[idx].getCntrNo(), lstCnmvYr));
				int idSeq = Integer.parseInt(dbDao.getContainerMaxSeq(ctmRestuffingDetailVOs[idx].getCntrNo(), lstCnmvYr));

				// iVo에 자료 대입. 대입 완료 후 ctm_movement 생성.
				iVo = new CusCtmMovementVO();

				if ("D".equals(status) || "P".equals(status)) {    ////////////////////////
					// 삭제될  컨테이너.
					iVo.setBkgCgoTpCd(  ctmMov.getBkgCgoTpCd());
					iVo.setBkgNo(       ctmMov.getBkgNo());
					iVo.setChssNo(      ctmMov.getChssNo());
					iVo.setCnmvCycNo(   ctmMov.getCnmvCycNo());
					iVo.setCnmvEvntDt(  ctmMov.getCnmvEvntDt());
					iVo.setCnmvEvntDt(  ctmMov.getCnmvEvntDt());
					idNo  = idNo + 1;
					idSeq = idSeq + 1;
					iVo.setCnmvIdNo(    String.valueOf(idNo));
					iVo.setCnmvSeq(     String.valueOf(idSeq));

					iVo.setCnmvLvlNo(   ctmMov.getCnmvLvlNo());
					//iVo.setCnmvRmk(     ctmMov.getCnmvRmk());
					iVo.setCnmvRmk(   "Restuffing : " +    cVO.getXchRmk());
					//iVo.setCnmvSeq(     ctmMov.getCnmvSeq());
					iVo.setCnmvSplitNo( ctmMov.getCnmvSplitNo());
					iVo.setBkgRcvTermCd( ctmMov.getBkgRcvTermCd() );
					iVo.setBkgKnt(      ctmMov.getBkgKnt());
					iVo.setMvmtInpTpCd(   "MAN");
					iVo.setCtrtOfcCtyCd("HHO");
					iVo.setCtrtSeq(ctmMov.getCtrtSeq());

					iVo.setCnmvYr(      yr);
					iVo.setCntrActCd(   ctmMov.getCntrActCd());
					iVo.setCntrNo(      ctmMov.getCntrNo());
					iVo.setCntrSealNo(  ctmMov.getCntrSealNo());
					iVo.setCntrSvrId(   ctmMov.getCntrSvrId());
					iVo.setCntrTpszCd(  ctmMov.getCntrTpszCd());
					iVo.setDestYdCd(    ctmMov.getDestYdCd());
					iVo.setFcntrFlg(    ctmMov.getFcntrFlg());
					iVo.setIbflag(      ctmMov.getIbflag());
					iVo.setMgstNo(      ctmMov.getMgstNo());
					iVo.setMvmtStsCd(   ctmMov.getMvmtStsCd());
					iVo.setObCntrFlg(   ctmMov.getObCntrFlg());
					iVo.setOrgYdCd(     ctmMov.getOrgYdCd());
					iVo.setPType1(      ctmMov.getPType1());
					iVo.setPType2(      ctmMov.getPType2());
					iVo.setPagerows(    ctmMov.getPagerows());
					iVo.setPodCd(       ctmMov.getPodCd());
					iVo.setPolCd(       ctmMov.getPolCd());
					iVo.setSpclCgoFlg(  ctmMov.getSpclCgoFlg());
					iVo.setTrnkSkdDirCd(ctmMov.getTrnkSkdDirCd());
					iVo.setTrnkSkdVoyNo(ctmMov.getTrnkSkdVoyNo());
					iVo.setTrnkVslCd(   ctmMov.getTrnkVslCd());
					iVo.setVndrSeq(     ctmMov.getVndrSeq());
					iVo.setBlNo(        ctmMov.getBlNo());
					iVo.setOfcCd(       account.getOfc_cd());
					iVo.setCntrXchCd("F");

					iVo.setCntrDispFlg(flgDisp);
					iVo.setCntrDmgFlg(flgDmg);
					iVo.setCntrRfubFlg(flgRef);
					iVo.setCntrHngrRckFlg("N");
					iVo.setImdtExtFlg(cntrVO.getImdtExtFlg());
					iVo.setCntrNo(cntrNo);
					iVo.setMvmtStsCd(mvmtStsCd);
					iVo.setCnmvYr(yr);
					iVo.setUpdUsrId(account.getUsr_id());

					CusCtmMovementVO ss = (CusCtmMovementVO) iVo.clone();
					ss.setCntrRfubFlg("N");
					ss.setCnmvYr(cnmvYr);
					ss.setCntrDispFlg("N");
					ss.setCntrDmgFlg("N");
					ss.setCnmvIdNo(cnmvIdNo);
					updVo.setUpdCtm(ss);    // Update 목록 setting

					iVo.setCnmvYr(yr);
					for (int j = 0; j < ctmRestuffingDetailVOs.length; j++) {
						if (cntrNo.equals(ctmRestuffingDetailVOs[j].getCntrNo())) {
							if (!ctmRestuffingDetailVOs[j].getSaveFlg().equals("D"))
								notUseFlg = true;
						}
					}
					lstCnmvId = cVO.getCnmvIdNo();
					lstCnmvYr = cVO.getCnmvYr();

					if ((cnmvYr.equals(ctmMov.getCnmvYr()) && cnmvIdNo.equals(lstCnmvId)) && fndCd == false) {
						// 마지막 정보
						lvlCd = dbDao.getCNTRMovSeqRSQL(ctmMov.getBkgCgoTpCd(), "MT").getCnmvLvlNo();
						if (lvlCd == null) lvlCd = "0";
						if ("R".equals(ctmMov.getBkgCgoTpCd().substring(0,1))) {
							iVo.setMvmtStsCd("XX");
							// XX를  생성할 때 IB FLG를 N으로 세팅.
							iVo.setObCntrFlg("N");
							iVo.setFcntrFlg("M");
						} else {
							iVo.setMvmtStsCd("MT");
							iVo.setObCntrFlg("N");
							iVo.setFcntrFlg("M");
						}
						iVo.setCnmvLvlNo(lvlCd);
						iVo.setOrgYdCd(cVO.getOrgYdCd());
						iVo.setCnmvEvntDt(cVO.getCnmvEvntDt());
						iVo.setCreUsrId(account.getUsr_id());
						iVo.setUpdUsrId(account.getUsr_id());
						iVo.setUsrNm(account.getUsr_nm());

						ctmUpd[ctmidx] = iVo;    // Insert 대상목록
						ctmidx++;
						iVo.setCnmvYr(yr);

						mstUpd[mstidx] = iVo;
						mstidx++;
					}

				} else {    // "D".equals(status)
					// 대체될 컨테이너
					// XCH 테이블에 입력.
					xchVo.setCntrNo((String)map.get("cntr_no"));
					xchVo.setCnmvYr(cnmvYr);
					xchVo.setCnmvIdNo((String)map.get("cnmv_id_no"));
					xchVo.setCntrXchRefSeq(resSeq);
					xchVo.setCntrXchSeq(String.valueOf(idx));
					xchVo.setCntrTpszCd((String)map.get("cntr_tpsz_cd"));
					xchVo.setCnmvCycNo(cnmvCycNo);
					xchVo.setCnmvStsCd((String)map.get("mvmt_sts_cd"));
					xchVo.setXchCntrNo(cVO.getCntrNo());
					xchVo.setXchCntrYr(cnmvYr);
					xchVo.setXchCntrTpszCd(cVO.getCntrTpszCd());
					xchVo.setPreCnmvStsCd (cVO.getMvmtStsCd());
					xchVo.setXchOfcCd(account.getOfc_cd());

					xchVo.setOrgYdCd((String)map.get("org_yd_cd"));
					xchVo.setCreUsrId(account.getUsr_id());
					xchVo.setUpdUsrId(account.getUsr_id());
					xchVo.setXchRmk(cVO.getXchRmk());
					dbDao.addCtmMvmtXch(xchVo);
					//String xchSeq = dbDao.getMaxCntrXchSeq(cntrNo);
					for (int i = 0; i < resonCd.length; i++) {
						// CTM_MVMT_XCH_DTL에 자료 입력.
						CtmMvmtXchDtlVO dtlVo = new CtmMvmtXchDtlVO();
						dtlVo.setCnmvIdNo(cVO.getCnmvIdNo());
						dtlVo.setCnmvYr(cnmvYr);
						dtlVo.setCntrNo(cntrNo);
						dtlVo.setIbflag(cVO.getIbflag());
						dtlVo.setCntrXchRefSeq(resSeq);
						dtlVo.setCntrXchRsnSeq(String.valueOf(i));
						dtlVo.setXchRsnCd(resonCd[i]);
						dtlVo.setUpdUsrId(account.getUsr_id());
						dtlVo.setCreUsrId(account.getUsr_id());
						dtlVo.setCntrXchSeq(String.valueOf(idx));
						dbDao.addCtmMvmtXchDtl(dtlVo);
					}

					if (cntrNo.equals(cVO.getCntrNo())) continue;

					iVo.setBkgCgoTpCd(  ctmMov.getBkgCgoTpCd());
					iVo.setBkgNo(       ctmMov.getBkgNo());
					iVo.setBlNo (       ctmMov.getBlNo());
					iVo.setChssNo(      ctmMov.getChssNo());
					iVo.setCnmvCycNo(   ctmMov.getCnmvCycNo());
					iVo.setCnmvEvntDt(  cVO.getCnmvEvntDt());
					iVo.setCnmvEvntDt(  ctmMov.getCnmvEvntDt());
					idNo  = idNo + 1;
					idSeq = idSeq + 1;
					iVo.setCnmvIdNo(    String.valueOf(idNo));
					iVo.setCnmvSeq(     String.valueOf(idSeq));

					iVo.setCnmvLvlNo(   ctmMov.getCnmvLvlNo());
					iVo.setCnmvRmk( "Restuffing : " +   srcVo.getXchRmk());
					iVo.setCnmvSplitNo( ctmMov.getCnmvSplitNo());
					iVo.setBkgRcvTermCd(ctmMov.getBkgRcvTermCd() );
					iVo.setBkgKnt(      ctmMov.getBkgKnt());
					iVo.setMvmtInpTpCd(   "MAN");
					iVo.setCtrtOfcCtyCd("HHO");
					iVo.setCtrtSeq(ctmMov.getCtrtSeq());

					iVo.setCnmvYr(yr);
					iVo.setCntrActCd(   ctmMov.getCntrActCd());
					iVo.setCntrNo(      ctmMov.getCntrNo() + ctmMov.getCheckDigit());
					iVo.setCntrSealNo(  ctmMov.getCntrSealNo());
					iVo.setCntrSvrId(   ctmMov.getCntrSvrId());
					iVo.setCntrTpszCd(  ctmMov.getCntrTpszCd());
					iVo.setDestYdCd(    ctmMov.getDestYdCd());
					iVo.setFcntrFlg(    ctmMov.getFcntrFlg());
					iVo.setIbflag(      ctmMov.getIbflag());
					iVo.setMgstNo(      ctmMov.getMgstNo());
					iVo.setMvmtStsCd(   ctmMov.getMvmtStsCd());
					iVo.setObCntrFlg(   ctmMov.getObCntrFlg());
					iVo.setOrgYdCd(     ctmMov.getOrgYdCd());
					iVo.setPType1(      ctmMov.getPType1());
					iVo.setPType2(      ctmMov.getPType2());
					iVo.setPagerows(    ctmMov.getPagerows());
					iVo.setPodCd(       ctmMov.getPodCd());
					iVo.setPolCd(       ctmMov.getPolCd());
					iVo.setSpclCgoFlg(  ctmMov.getSpclCgoFlg());
					iVo.setTrnkSkdDirCd(ctmMov.getTrnkSkdDirCd());
					iVo.setTrnkSkdVoyNo(ctmMov.getTrnkSkdVoyNo());
					iVo.setTrnkVslCd(   ctmMov.getTrnkVslCd());
					iVo.setVndrSeq(     ctmMov.getVndrSeq());
					iVo.setOfcCd(account.getOfc_cd());
					iVo.setCntrXchCd("T");

					String cntr = cVO.getCntrNo();

					iVo.setCntrTpszCd(cVO.getCntrTpszCd());
					iVo.setCntrNo(cntr);
					iVo.setCnmvEvntDt(cVO.getCnmvEvntDt());
					iVo.setCreUsrId(account.getUsr_id());
					iVo.setUpdUsrId(account.getUsr_id());
					iVo.setUsrNm(account.getUsr_nm());
					// 컨테이너가 원본과 동일할 경우 CycNo 유지. 그렇지 않으면 CycNo + 1
					if (!cntrNo.equals(cVO.getCntrNo())) {
						String cycNo = dbDao.getMaxCntrCycNo(cVO.getCntrNo());
						iVo.setCnmvCycNo(cycNo);
					}

					ctmUpd[ctmidx] = iVo;
					ctmidx++;
					mstUpd[mstidx] = iVo;
					mstidx++;
				}

				updVo.setCtmUpd(ctmUpd);    // Insert 목록 setting
				updVo.setMstUpd(mstUpd);

			} catch (DAOException ex) {
				log.error(ex.getMessage(),ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{"Save container movement history list error!"}).getMessage(), ex);
			} catch (Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{"Save container movement history list error!"}).getMessage(), ex);
			}
		}
		return updVo;
	}

	/**
	 * BKG_CONTAINER 에서 SPLIT된 부킹을 찾아온다.<br>
	 *
	 * @param  String cntrNo
	 * @return String
	 * @exception EventException
	 */
	public String getBkgSplitRSQL(String cntrNo) throws EventException {
		try {
			return dbDao.getBkgSplitRSQL(cntrNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

}
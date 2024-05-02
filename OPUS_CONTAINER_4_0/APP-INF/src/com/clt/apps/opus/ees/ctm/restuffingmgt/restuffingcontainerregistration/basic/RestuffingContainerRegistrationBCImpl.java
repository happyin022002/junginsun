/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RestuffingContainerRegistrationBCImpl.java
 *@FileTitle : Restuffing Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration.RestuffingContainerRegistrationDBDAO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMvmtXchDtlVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.InsCtmMvmtXchVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.UpdMstCntrVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;


/**
 * OPUS-RestuffingMgt Business Logic Basic Command implementation<br>
 *
 * @author
 * @see UI_CTM_0423EventResponse,RestuffingContainerRegistrationBC DAO class reference
 * @since J2EE 1.4
 */

public class RestuffingContainerRegistrationBCImpl extends BasicCommandSupport implements RestuffingContainerRegistrationBC {

	// Database Access Object
	private transient RestuffingContainerRegistrationDBDAO dbDao = null;

	/**
	 * creating RestuffingContainerRegistrationBCImpl Object
	 * creating RestuffingContainerRegistrationDBDAO
	 */
	public RestuffingContainerRegistrationBCImpl() {
		dbDao = new RestuffingContainerRegistrationDBDAO();
	}

	/**
	 * handling retrieve event
	 * retrieving Restuffing list
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
	 * handling retrieve event for 0445 POPUP
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
//		String lstCnmvYr = null;
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

					cntrNo = srcVo.getCntrNo();
					cnmvYr = srcVo.getCnmvYr();
					cnmvIdNo = srcVo.getCnmvIdNo();
					yardCd = srcVo.getOrgYdCd();
					mvmtStsCd = srcVo.getMvmtStsCd();
					log.info("야드 " +yardCd);
					map = srcVo.getColumnValues();
					map.put("cntr_no", cntrNo);
					log.info("MAP PRINT");
					/***********************************************************
					 * getting container information from MST_CONTAINER        *
					 ***********************************************************/
					/***********************************
					 * getting container movement  *
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

			//[2015.05.28]소스품질 Modify
			//if ( (cntrNo.equals(ctmRestuffingDetailVOs[x].getCntrNo() + srcVo.getCheckDigit()) && !"D".equals(ctmRestuffingDetailVOs[x].getSaveFlg()))
			if ( (null != cntrNo && null != srcVo && cntrNo.equals(ctmRestuffingDetailVOs[x].getCntrNo()) && !"D".equals(ctmRestuffingDetailVOs[x].getSaveFlg()))
				|| "P".equals(ctmRestuffingDetailVOs[x].getSaveFlg()) ) {
				fndCd = true;   // 
			}
		}


		for (int idx = 0; idx < ctmRestuffingDetailVOs.length; idx++) {
			CusCtmMovementVO iVo = new CusCtmMovementVO();
			cVO = ctmRestuffingDetailVOs[idx];
			if(cVO == null) {
				continue;
			}
//			cVO.setCntrNo(cVO.getCntrNo() + cVO.getCheckDigit());
			InsCtmMvmtXchVO xchVo = new InsCtmMvmtXchVO();
			try {
				status = cVO.getSaveFlg();
				String reson = CheckUtilities.isNullOrNullStringReplacement(cVO.getResonCd(), "");
				String[] resonCd = reson.split(Pattern.quote(","));
				for (int i = 0; i < resonCd.length; i++) {
					if ("DM".equals(resonCd[i])) {
						flgDmg = "Y";
					} else if ("DP".equals(resonCd[i])) {
						flgDisp = "Y";
					} else if ("RP".equals(resonCd[i])){
						flgRef = "Y";
					}
				}	
				
//				int idNo  = 0;
//				int idSeq  = 0;
//				if(lstCnmvYr != null ){
					int idNo = Integer.parseInt(dbDao.getContainerMaxId(ctmRestuffingDetailVOs[idx].getCntrNo(), lstCnmvYr));
					int idSeq = Integer.parseInt(dbDao.getContainerMaxSeq(ctmRestuffingDetailVOs[idx].getCntrNo(), lstCnmvYr));
//				}

				iVo = new CusCtmMovementVO();

				if ("D".equals(status) || "P".equals(status)) {    ////////////////////////
					// container to be deleted
					if(ctmMov != null) iVo.setBkgCgoTpCd(  ctmMov.getBkgCgoTpCd());
					if(ctmMov != null) iVo.setBkgNo(       ctmMov.getBkgNo());
					if(ctmMov != null) iVo.setChssNo(      ctmMov.getChssNo());
					if(ctmMov != null) iVo.setCnmvCycNo(   ctmMov.getCnmvCycNo());
					if(ctmMov != null) iVo.setCnmvEvntDt(  ctmMov.getCnmvEvntDt());
					if(ctmMov != null) iVo.setCnmvEvntDt(  ctmMov.getCnmvEvntDt());
					idNo  = idNo + 1;
					idSeq = idSeq + 1;
					iVo.setCnmvIdNo(    String.valueOf(idNo));
					iVo.setCnmvSeq(     String.valueOf(idSeq));

					if(ctmMov != null) iVo.setCnmvLvlNo(   ctmMov.getCnmvLvlNo());
					//iVo.setCnmvRmk(     ctmMov.getCnmvRmk());
					iVo.setCnmvRmk(   "Restuffing : " +    cVO.getXchRmk());
					//iVo.setCnmvSeq(     ctmMov.getCnmvSeq());
					if(ctmMov != null) iVo.setCnmvSplitNo( ctmMov.getCnmvSplitNo());
					if(ctmMov != null) iVo.setBkgRcvTermCd( ctmMov.getBkgRcvTermCd() );
					if(ctmMov != null) iVo.setBkgKnt(      ctmMov.getBkgKnt());
					iVo.setMvmtInpTpCd(   "MAN");
					iVo.setCtrtOfcCtyCd("HHO");
					if(ctmMov != null) iVo.setCtrtSeq(ctmMov.getCtrtSeq());

					iVo.setCnmvYr(      yr);
					if(ctmMov != null) iVo.setCntrActCd(   ctmMov.getCntrActCd());
					if(ctmMov != null) iVo.setCntrNo(      ctmMov.getCntrNo());
					//SealNo 받아오는 부분 수정
					if(cVO != null) iVo.setCntrSealNo( 	   cVO.getCntrSealNo()); 
					if(ctmMov != null) iVo.setCntrSvrId(   ctmMov.getCntrSvrId());
					if(ctmMov != null) iVo.setCntrTpszCd(  ctmMov.getCntrTpszCd());
					if(ctmMov != null) iVo.setDestYdCd(    ctmMov.getDestYdCd());
					if(ctmMov != null) iVo.setFcntrFlg(    ctmMov.getFcntrFlg());
					if(ctmMov != null) iVo.setIbflag(      ctmMov.getIbflag());
					if(ctmMov != null) iVo.setMgstNo(      ctmMov.getMgstNo());
					if(ctmMov != null) iVo.setMvmtStsCd(   ctmMov.getMvmtStsCd());
					if(ctmMov != null) iVo.setObCntrFlg(   ctmMov.getObCntrFlg());
					if(ctmMov != null) iVo.setOrgYdCd(     ctmMov.getOrgYdCd());
					if(ctmMov != null) iVo.setPType1(      ctmMov.getPType1());
					if(ctmMov != null) iVo.setPType2(      ctmMov.getPType2());
					if(ctmMov != null) iVo.setPagerows(    ctmMov.getPagerows());
					if(ctmMov != null) iVo.setPodCd(       ctmMov.getPodCd());
					if(ctmMov != null) iVo.setPolCd(       ctmMov.getPolCd());
					if(ctmMov != null) iVo.setSpclCgoFlg(  ctmMov.getSpclCgoFlg());
					if(ctmMov != null) iVo.setTrnkSkdDirCd(ctmMov.getTrnkSkdDirCd());
					if(ctmMov != null) iVo.setTrnkSkdVoyNo(ctmMov.getTrnkSkdVoyNo());
					if(ctmMov != null) iVo.setTrnkVslCd(   ctmMov.getTrnkVslCd());
					if(ctmMov != null) iVo.setVndrSeq(     ctmMov.getVndrSeq());
					if(ctmMov != null) iVo.setBlNo(        ctmMov.getBlNo());
					if(account.getUsr_id().equalsIgnoreCase("ESVCUSER")) {
						if(ctmMov != null) iVo.setOfcCd(       dbDao.getOfcCdByYard(ctmMov.getOrgYdCd()));
					}else {
						iVo.setOfcCd(       account.getOfc_cd());
					}
					iVo.setCntrXchCd("F");

					if(flgDisp != null) iVo.setCntrDispFlg(flgDisp);
					if(flgDmg != null) iVo.setCntrDmgFlg(flgDmg);
					if(flgRef != null) iVo.setCntrRfubFlg(flgRef);
					iVo.setCntrHngrRckFlg("N");
					if(cntrVO != null) iVo.setImdtExtFlg(cntrVO.getImdtExtFlg());
					if(cntrNo != null) iVo.setCntrNo(cntrNo);
					if(mvmtStsCd != null) iVo.setMvmtStsCd(mvmtStsCd);
					iVo.setCnmvYr(yr);
					iVo.setUpdUsrId(account.getUsr_id());

					CusCtmMovementVO ss = (CusCtmMovementVO) iVo.clone();
					ss.setCntrRfubFlg("N");
					if(cnmvYr != null) ss.setCnmvYr(cnmvYr);
					ss.setCntrDispFlg("N");
					ss.setCntrDmgFlg("N");
					if(cnmvIdNo != null) ss.setCnmvIdNo(cnmvIdNo);
					updVo.setUpdCtm(ss);    // setting Update list

					iVo.setCnmvYr(yr);
					for (int j = 0; j < ctmRestuffingDetailVOs.length; j++) {
						if(cntrNo != null) {
							if (cntrNo.equals(ctmRestuffingDetailVOs[j].getCntrNo())) {
								if (!ctmRestuffingDetailVOs[j].getSaveFlg().equals("D"))
									notUseFlg = true;
							}
						}
					}
					lstCnmvId = cVO.getCnmvIdNo();
					lstCnmvYr = cVO.getCnmvYr();
					
					//[2015.05.28]소스품질 Modify
					//if ((cnmvYr.equals(ctmMov.getCnmvYr()) && cnmvIdNo.equals(lstCnmvId)) && fndCd == false) {					
					if ((StringUtils.isNotEmpty(cnmvYr) && null != ctmMov && cnmvYr.equals(ctmMov.getCnmvYr()) && cnmvIdNo.equals(lstCnmvId)) && fndCd == false) {
						// final information
						lvlCd = dbDao.getCNTRMovSeqRSQL(ctmMov.getBkgCgoTpCd(), "MT").getCnmvLvlNo();
						if (lvlCd == null) lvlCd = "0";
						if ("R".equals(ctmMov.getBkgCgoTpCd().substring(0,1))) {
							iVo.setMvmtStsCd("XX");
							// setting IB FLG as 'N' when creating XX
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

						ctmUpd[ctmidx] = iVo;    // Insert list
						ctmidx++;
						iVo.setCnmvYr(yr);

						mstUpd[mstidx] = iVo;
						mstidx++;
					}

				} else {    // "D".equals(status)
					//2014.12.30
					xchVo.setCntrNo((String)map.get("cntr_no"));
					//xchVo.setCntrNo(cVO.getCntrNo());
					
					if(cnmvYr != null) xchVo.setCnmvYr(cnmvYr);
					//2014.12.30
					//xchVo.setCnmvIdNo((String)map.get("cnmv_id_no"));
					xchVo.setCnmvIdNo(cVO.getCnmvIdNo());
					
					if(resSeq != null) xchVo.setCntrXchRefSeq(resSeq);
					xchVo.setCntrXchSeq(String.valueOf(idx));
					xchVo.setCntrTpszCd((String)map.get("cntr_tpsz_cd"));
					if(cnmvCycNo != null) xchVo.setCnmvCycNo(cnmvCycNo);
					xchVo.setCnmvStsCd((String)map.get("mvmt_sts_cd"));
					xchVo.setXchCntrNo(cVO.getCntrNo());
					if(cnmvYr != null) xchVo.setXchCntrYr(cnmvYr);
					xchVo.setXchCntrTpszCd(cVO.getCntrTpszCd());
					xchVo.setPreCnmvStsCd (cVO.getMvmtStsCd());
					//2014.12.30
					//xchVo.setXchOfcCd(account.getOfc_cd());
					//[2015.05.28]소스품질 Modify
					//if(account.getUsr_id().equalsIgnoreCase("ESVCUSER")) {
					if(account.getUsr_id().equalsIgnoreCase("ESVCUSER") && null != ctmMov) {
						xchVo.setXchOfcCd(       dbDao.getOfcCdByYard(ctmMov.getOrgYdCd()));
					}else {
						xchVo.setXchOfcCd(       account.getOfc_cd());
					}

					xchVo.setOrgYdCd((String)map.get("org_yd_cd"));
					xchVo.setCreUsrId(account.getUsr_id());
					xchVo.setUpdUsrId(account.getUsr_id());
					xchVo.setXchRmk(cVO.getXchRmk());
					dbDao.addCtmMvmtXch(xchVo);
					//String xchSeq = dbDao.getMaxCntrXchSeq(cntrNo);
					for (int i = 0; i < resonCd.length; i++) {
						// inserting into CTM_MVMT_XCH_DTL
						CtmMvmtXchDtlVO dtlVo = new CtmMvmtXchDtlVO();
						dtlVo.setCnmvIdNo(cVO.getCnmvIdNo());
						if(cnmvYr != null) dtlVo.setCnmvYr(cnmvYr);
						//2014.12.30
						if(cntrNo != null) dtlVo.setCntrNo(cntrNo);
						//dtlVo.setCntrNo(cVO.getCntrNo());
						
						dtlVo.setIbflag(cVO.getIbflag());
						if(resSeq != null) dtlVo.setCntrXchRefSeq(resSeq);
						dtlVo.setCntrXchRsnSeq(String.valueOf(i));
						dtlVo.setXchRsnCd(resonCd[i]);
						dtlVo.setUpdUsrId(account.getUsr_id());
						dtlVo.setCreUsrId(account.getUsr_id());
						dtlVo.setCntrXchSeq(String.valueOf(idx));
						dbDao.addCtmMvmtXchDtl(dtlVo);
					}

					//[2015.05.28]소스품질 Modify
					//if (cntrNo.equals(cVO.getCntrNo())) continue;
					if (StringUtils.isNotEmpty(cntrNo) && null != cVO && cntrNo.equals(cVO.getCntrNo())) continue;
					
					if(ctmMov != null) iVo.setBkgCgoTpCd(  ctmMov.getBkgCgoTpCd());
					if(ctmMov != null) iVo.setBkgNo(       ctmMov.getBkgNo());
					if(ctmMov != null) iVo.setBlNo (       ctmMov.getBlNo());
					if(ctmMov != null) iVo.setChssNo(      ctmMov.getChssNo());
					if(ctmMov != null) iVo.setCnmvCycNo(   ctmMov.getCnmvCycNo());
					iVo.setCnmvEvntDt(  cVO.getCnmvEvntDt());
					if(ctmMov != null) iVo.setCnmvEvntDt(  ctmMov.getCnmvEvntDt());
					idNo  = idNo + 1;
					idSeq = idSeq + 1;
					iVo.setCnmvIdNo(    String.valueOf(idNo));
					iVo.setCnmvSeq(     String.valueOf(idSeq));

					if(ctmMov != null) iVo.setCnmvLvlNo(   ctmMov.getCnmvLvlNo());
					if(srcVo != null) iVo.setCnmvRmk( "Restuffing : " +   srcVo.getXchRmk());
					if(ctmMov != null) iVo.setCnmvSplitNo( ctmMov.getCnmvSplitNo());
					if(ctmMov != null) iVo.setBkgRcvTermCd(ctmMov.getBkgRcvTermCd() );
					if(ctmMov != null) iVo.setBkgKnt(      ctmMov.getBkgKnt());
					iVo.setMvmtInpTpCd(   "MAN");
					iVo.setCtrtOfcCtyCd("HHO");
					iVo.setCtrtSeq(ctmMov.getCtrtSeq());

					iVo.setCnmvYr(yr);
					if(ctmMov != null) iVo.setCntrActCd(   ctmMov.getCntrActCd());
					if(ctmMov != null) iVo.setCntrNo(      ctmMov.getCntrNo());
					//sealNo 받아오는 부분 수정
					if(cVO != null) iVo.setCntrSealNo( 	   cVO.getCntrSealNo()); 
					if(ctmMov != null) iVo.setCntrSvrId(   ctmMov.getCntrSvrId());
					if(ctmMov != null) iVo.setCntrTpszCd(  ctmMov.getCntrTpszCd());
					if(ctmMov != null) iVo.setDestYdCd(    ctmMov.getDestYdCd());
					if(ctmMov != null) iVo.setFcntrFlg(    ctmMov.getFcntrFlg());
					if(ctmMov != null) iVo.setIbflag(      ctmMov.getIbflag());
					if(ctmMov != null) iVo.setMgstNo(      ctmMov.getMgstNo());
					if(ctmMov != null) iVo.setMvmtStsCd(   ctmMov.getMvmtStsCd());
					if(ctmMov != null) iVo.setObCntrFlg(   ctmMov.getObCntrFlg());
					if(ctmMov != null) iVo.setOrgYdCd(     ctmMov.getOrgYdCd());
					if(ctmMov != null) iVo.setPType1(      ctmMov.getPType1());
					if(ctmMov != null) iVo.setPType2(      ctmMov.getPType2());
					if(ctmMov != null) iVo.setPagerows(    ctmMov.getPagerows());
					if(ctmMov != null) iVo.setPodCd(       ctmMov.getPodCd());
					if(ctmMov != null) iVo.setPolCd(       ctmMov.getPolCd());
					if(ctmMov != null) iVo.setSpclCgoFlg(  ctmMov.getSpclCgoFlg());
					if(ctmMov != null) iVo.setTrnkSkdDirCd(ctmMov.getTrnkSkdDirCd());
					if(ctmMov != null) iVo.setTrnkSkdVoyNo(ctmMov.getTrnkSkdVoyNo());
					if(ctmMov != null) iVo.setTrnkVslCd(   ctmMov.getTrnkVslCd());
					if(ctmMov != null) iVo.setVndrSeq(     ctmMov.getVndrSeq());
					//iVo.setOfcCd(account.getOfc_cd());
					if(account.getUsr_id().equalsIgnoreCase("ESVCUSER")) {
						iVo.setOfcCd(       dbDao.getOfcCdByYard(ctmMov.getOrgYdCd()));
					}else {
						iVo.setOfcCd(       account.getOfc_cd());
					}
					iVo.setCntrXchCd("T");

					String cntr = cVO.getCntrNo();

					iVo.setCntrTpszCd(cVO.getCntrTpszCd());
					iVo.setCntrNo(cntr);
					iVo.setCnmvEvntDt(cVO.getCnmvEvntDt());
					iVo.setCreUsrId(account.getUsr_id());
					iVo.setUpdUsrId(account.getUsr_id());
					iVo.setUsrNm(account.getUsr_nm());
					// maintaining cycle no in case container is same with original or set cycle no +1
					if (!cntrNo.equals(cVO.getCntrNo())) {
						String cycNo = dbDao.getMaxCntrCycNo(cVO.getCntrNo());
						iVo.setCnmvCycNo(cycNo);
					}

					ctmUpd[ctmidx] = iVo;
					ctmidx++;
					mstUpd[mstidx] = iVo;
					mstidx++;
				}

				updVo.setCtmUpd(ctmUpd);    // setting Insert list 
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
	 * searching SPLIT booking from BKG_CONTAINER 
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
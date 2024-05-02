/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageBCImpl.java 
*@FileTitle : Bkg Cop Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : Kim In-soo
*@LastVersion : 1.0
* 2011.11.29 조풍연 [CHM-201114752] [SCEM] TRO cancel 시 COP replan 로직보완 요청
*
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration.BkgCopManageDBDAO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.CntrDiffVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.CopHdrToBeCopiedVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.ManRplnRsltVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SceActTmlRtvVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.Search315VEToBeSentVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchCopCntLimitVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchCopVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchDiffCntrListVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchDiffQtyListVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchIBDoorDtlVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchPorForSendBFVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.ValidateTROSequenceVO;
import com.hanjin.apps.alps.esd.sce.common.SCEConstants;
import com.hanjin.apps.alps.esd.sce.common.util.integration.CodeUtilDBDAO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceCopSkdHisVO;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgEurTroDtlVO;
import com.hanjin.syscommon.common.table.BkgEurTroVO;
import com.hanjin.syscommon.common.table.BkgTroDtlVO;
import com.hanjin.syscommon.common.table.BkgTroVO;
import com.hanjin.syscommon.common.table.LeaCntrBkgHisVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.PrdBkgCopMapVO;
import com.hanjin.syscommon.common.table.SceBkgOpHisVO;
import com.hanjin.syscommon.common.table.SceBkgOpParaVO;
import com.hanjin.syscommon.common.table.SceCopDtlVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.syscommon.common.table.ScePlnSoListVO;
import com.hanjin.syscommon.common.table.SceTroMapgVO;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForVVDChgVO;
/**
 * Bkg 에서 호출되는 COP 변경 업무에 대한 Interface 의 구현
 * @author 2002701
 * @see BkgCopManageBC
 * @since J2EE 1.4
 */
public class BkgCopManageBCImpl extends BasicCommandSupport implements BkgCopManageBC {

	// Database Access Object
	private transient BkgCopManageDBDAO dbDao = null;
	

	private transient CodeUtilDBDAO dbUtilDao = null;

	// BC--> BC call case
	private transient ReplanManageBC replanManageBC = null;
	private transient CopDetailReceiveBC copDetailReceiveBC = null;
	private transient Edi315SendBC edi315BC = null;
	private transient ProductCatalogCreateBC prdBC = null;

	/**
	 * ExceptionSearchBCImpl 객체 생성<br>
	 * ExceptionSearchDBDAO를 생성한다.<br>
	 */
	public BkgCopManageBCImpl() {
		dbDao = new BkgCopManageDBDAO();
		dbUtilDao = new CodeUtilDBDAO();
		
		copDetailReceiveBC = new CopDetailReceiveBCImpl();
		replanManageBC = new ReplanManageBCImpl();
		edi315BC = new Edi315SendBCImpl();
		prdBC = new ProductCatalogCreateBCImpl();
		
	}

	
	/**
	 * 구주 TRO / I, 구주 TRO / O, 미주 TRO / O 가 confirm 될 때 호출됨
	 * 구주 TRO 는 TRO SEQ 별로, 미주 TRO 는 TRO_SUB_SEQ 별로 mapping 될 COP 를 지정한다.
	 * 지정된 COP 를 넘겨 받은 pctl_no 로 replan 하여 Door S/O 생성 대상을 관리할 수 있게 한다.
	 * 또한 Door arrival date (estimate) 값을 받아 해당 skd 을 COP Detail 에 적용한다.
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param pctl_no
	 * @param area_conti_cd
	 * @throws DAOException 
	 */
	public void confirmTro(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String pctl_no, String area_conti_cd) throws EventException {
		try {
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(bkg_no);
			tmp.setTroSeq(tro_seq);
			tmp.setTroSubSeq(tro_sub_seq);
			tmp.setIoBndCd(io_bnd_cd);
			tmp.setPctlNo(pctl_no);
			tmp.setContiCd(area_conti_cd);
			
			tmp.setBkgEvntTpCd("TC"); // confirm TRO
			tmp.setBkgEvntRmk("Confirm TRO : bkg_no = " + bkg_no + " / tro_seq = " + tro_seq + " / tro_sub_seq = " + tro_sub_seq + " / io_bnd_cd = " + io_bnd_cd + " / pctl_no = " + pctl_no + " / area_conti_cd = " + area_conti_cd);
			
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), tro_seq);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), tro_sub_seq);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), io_bnd_cd);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), pctl_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), area_conti_cd);
			
			// sce_cop_hdr 의 ib_tro_flg, ob_tro_flg 를 update 할 list
			List<SceCopHdrVO> toBeUpdCopHdrList = new ArrayList<SceCopHdrVO>();
			List<SceTroMapgVO> sceTroMapgVOs = new ArrayList<SceTroMapgVO>();
			
			Map<String, String> rtnTroMap = searchTroInfo(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, area_conti_cd);
			
			List<ValidateTROSequenceVO> validateTROSequenceVOs = dbDao.validateTROSequence(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, area_conti_cd);

			if (validateTROSequenceVOs != null && validateTROSequenceVOs.size() != 0) {
				// tro 처리 오류 (기 처리 된 건임)
				ValidateTROSequenceVO tmpVO = validateTROSequenceVOs.get(0);
				dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), io_bnd_cd.equals("O") ? "OI" : "II", "systro", "systro", "N");
				
				SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
				sceCopHdrVO.setCopNo(tmpVO.getCopNo());
				sceCopHdrVO.setCopUpdRmk("TROCnfmCancel(Dup) / bkg_no = " + bkg_no + " / tro_seq = " + tro_seq + " / tro_sub_seq = " + tro_sub_seq + " / io_bnd_cd = " + io_bnd_cd + " / area_conti_cd = " + area_conti_cd);
				toBeUpdCopHdrList.add(sceCopHdrVO);
				
			} else {
				// 일단 TRO 가 mapping 될 COP 를 찾고 해당 COP 가 없다면 넘어온 PCTL_NO 또는 최근의 PCTL_NO 로 신규 COP 를 생성한다.
				List<SearchCopVO> searchCopVOs = new ArrayList<SearchCopVO>();
				if (io_bnd_cd.equals("O")) {
					searchCopVOs = dbDao.searchOBCop(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, area_conti_cd);

				} else {
					searchCopVOs = dbDao.searchIBCop(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, area_conti_cd);
				}
				
				// mapping 될 대상 COP 가 미존재시 COP 를 생성한다.
				if (searchCopVOs == null || searchCopVOs.size() == 0) {
					// 신규 생성될 cop header 정보를 가져옴
//					if (pctl_no == null || pctl_no.equals(""))
//						pctl_no = dbDao.searchRepPctlNo(bkg_no, rtnTroMap.get("cntr_tpsz_cd"));
//					
//					if (pctl_no != null && !pctl_no.equals("")) {
//						// pc no 가 존재시 cop 를 신규 생성하고 이를 searchCopVOs list 에 담는다.
//						// 이쪽 logic 은 수행될 일이 없다. TRO 생성시에는 BKG QTY 개수 만큼만 생성할 수 있으므로 COP 개수가 초과 생성되지 않는다.
//						List<SceCopHdrVO> toBeCreatedCopHdr = dbDao.searchCopHdrToBeCreated(bkg_no, rtnTroMap.get("cntr_no"), rtnTroMap.get("cntr_tpsz_cd"), pctl_no, null);
//						replanManageBC.createNewCop(toBeCreatedCopHdr);
//
//						List<SceCopHdrVO> tmpList = dbDao.searchCopHdr(bkg_no, rtnTroMap.get("cntr_no"));
//						
//						ObjectCloner.build(tmpList, searchCopVOs);
//					}
					
					// COP 를 찾지 못했을 경우에는 error message 보내줌
					// ????
					
					throw new EventException(new ErrorHandler("SCE00050",new String[]{}).getMessage());
				} else { // mapping 될 cop 가 존재할 경우 해당 cop 를 pctl_no 가 존재시 해당 pctl_no 로 replan 한다.
					if (io_bnd_cd.equals("O")) {
						SearchCopVO rtnVO = null;
						String mst_bkg_no = "";
						for (int i = 0; i < searchCopVOs.size(); i ++) {
							SearchCopVO tmpVO = searchCopVOs.get(i);
							if (tmpVO.getMstFlg() != null && tmpVO.getMstFlg().equals("Y")) {
								rtnVO = searchCopVOs.get(0);
								break;
							} 
							// vo 를 다 돌아서 master 인게 없으면 오류 발생
						}
						
						if (searchCopVOs.size() > 0 && rtnVO == null) {
							throw new EventException((String)new ErrorHandler("SCE00051", new String[]{tro_seq, tro_sub_seq, mst_bkg_no}).getMessage());
						}
					}
					
					if (pctl_no != null && !pctl_no.equals("")) {
						SearchCopVO searchCopVO = searchCopVOs.get(0);
						
						// sce_tro_mapg insert 시작
						SceTroMapgVO sceTroMapgVO = new SceTroMapgVO();
						sceTroMapgVO.setCopNo(searchCopVO.getCopNo());
						sceTroMapgVO.setIoBndCd(io_bnd_cd);
						sceTroMapgVO.setAreaContiCd(area_conti_cd);
						sceTroMapgVO.setBkgNo(bkg_no);
						sceTroMapgVO.setTroSeq(tro_seq);
						sceTroMapgVO.setTroSubSeq(tro_sub_seq);

						sceTroMapgVOs.add(sceTroMapgVO);
						
						if (sceTroMapgVOs.size() != 0) {
							dbDao.addTroInfo(sceTroMapgVOs);
						}

						boolean isRplnNeeded = true;
						if (area_conti_cd.equals("X") && io_bnd_cd.equals("O")) {// 미주 O/B TRO 일 경우
							// in / out bound 별로 구분하여 route 를 check 
							//pkup_yd_cd
							//rtn_yd_cd
							//zn_cd
							// pickup - zn - rtn
							String mtPkup = searchCopVO.getMtyPkupYdCd() == null ? "" : searchCopVO.getMtyPkupYdCd();
							String fullRtn = searchCopVO.getFullRtnYdCd() == null ? "" : searchCopVO.getFullRtnYdCd();
							String por = searchCopVO.getPorNodCd() == null ? "" : searchCopVO.getPorNodCd();
							
							String troMtPkup = rtnTroMap.get("pkup_yd_cd") == null ? "" : rtnTroMap.get("pkup_yd_cd");
							String troPor = rtnTroMap.get("zn_cd") == null ? "" : rtnTroMap.get("zn_cd");
							String troFullRtn = rtnTroMap.get("rtn_yd_cd") == null ? "" : rtnTroMap.get("rtn_yd_cd");
							
							if (mtPkup.equals(troMtPkup) && por.equals(troPor) && fullRtn.equals(troFullRtn)) {
								// 세 node 중 하나라도 다르면 replan 시도
								isRplnNeeded = false;
							}
						}
						if (isRplnNeeded) {
							SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
							
							ObjectCloner.build(searchCopVO, sceCopHdrVO);
							sceCopHdrVO.setPctlNo(pctl_no);
							sceCopHdrVO.setBkgNo(bkg_no);
							sceCopHdrVO.setCntrNo(searchCopVO.getCntrNo());
							
							if (io_bnd_cd.equals("O")) {
								sceCopHdrVO.setObTroFlg("Y");
								sceCopHdrVO.setCfmObDorArrDt(rtnTroMap.get("dor_arr_dt"));
							} else {
								sceCopHdrVO.setIbTroFlg("Y");
								sceCopHdrVO.setCfmApntDt(rtnTroMap.get("dor_arr_dt"));
							}
							
							
							replanManageBC.replanCop(sceCopHdrVO, "TroCnfm");
//							dbDao.modifyCopHdr(sceCopHdrVO); // 임시 데이터 처리 
							
						}
					}
				}

//				for (int i = 0; i < searchCopVOs.size(); i++) {
					SearchCopVO searchCopVO = searchCopVOs.get(0);

					// sce_cop_hdr update 시작
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(searchCopVO.getCopNo());

					if (io_bnd_cd.equals("O")) {
						sceCopHdrVO.setObTroFlg("Y");
						sceCopHdrVO.setCfmObDorArrDt(rtnTroMap.get("dor_arr_dt"));
					} else {
						sceCopHdrVO.setIbTroFlg("Y");
						sceCopHdrVO.setCfmApntDt(rtnTroMap.get("dor_arr_dt"));
					}
					
					// CHM-201003981 : [ALPS] TRO frustration 과 연계한 COP / TRS 기능변경 요청
					// W/O frustrate 후 다시 tro confim 된 case 를 대비 S/O route 가 frustrate 된 경우 이를 복구 시켜 준다.
					// 단 TRO / I 는 TRO Frustrate 되면 동일 container 로 다시 tro 를 낼 수 없기 때문에 하기 로직을 수행되지 않는다.
					if (dbDao.modifySoListFrstByTroCnfm(searchCopVO.getCopNo(), io_bnd_cd) > 0) {
						sceCopHdrVO.setCopUpdRmk("TroCnfm:SoStsChg:F-P");
					}
//					String railChk = dbDao.searchCopRailChk(searchCopVO.getCopNo());
//					sceCopHdrVO.setCopRailChkCd(railChk);
						
					/**
					 * TRO confirm 시의 miscellaneous 업무
					 * <outbound>
					 *  1. header 의 cop 의 PCTL_NO 를 신규 PC no 로 수정
					 *  2. outbound 의 exception 을 O, R 을 X 로 변경하고 ntfd_flg = 'N'
					 *  3. SCE_PLN_SO_LIST 재생성시에는 SO 의 정보를 보존하여 주어야 함
					 *  4. replan 에서의 actual mapping 을 수행하여야 함
					 *  5. OD 의 Frustrated 된 S/O status 를 'P' 로 변경함
					 *  6. pol 과 pol 의 departure node 가 다를 경우 pol 로 pol departure 의 node 를 변경 (?) : 필요한가?
					 *  7. MOTZAD 의 estimated date 를 TRO 의 door date 와 비교하여 날짜가 지연됬을 경우 re-scheduling / 줄었을 경우 기존 시간차를 반영하여 수정
					 *  8. pc no 가 없거나 기존과 같을 경우 에 TRO 에 MTY Pick up yard,등의 정보를 cop 에 update : 할 필요 없음 --> PC 에서 해당 case 에 관리
					 *  	구주는 BKG_EUR_TRO, 기타지역은 BKG_TRO_DTL 참조해야 할듯
					 *  COP 생성 및 관리는 replan 으로 넘긴다. 
					 */
					
					
					//exception cancel 부분
					if (io_bnd_cd.equals("O")) 
						dbDao.cancelObExptMst(sceCopHdrVO.getCopNo());
					else
						dbDao.cancelIbExptMst(sceCopHdrVO.getCopNo());

					toBeUpdCopHdrList.add(sceCopHdrVO);
					// COP Detail 의 door arrival date 반영
					String estm_dt = "";
//					String cop_dtl_seq = "";
//					String pre_estm_dt = "";
					String post_estm_dt = "";
					String before_act_dt = "";
					
					if (io_bnd_cd.equals("O")) {
						List<SceCopDtlVO> sceCopDtlVOList = dbDao.searchOBDoorDtl(sceCopHdrVO.getCopNo());
						
						if (sceCopDtlVOList.size() > 0) {
							SceCopDtlVO sceCopDtlVO = sceCopDtlVOList.get(0);
							estm_dt = sceCopDtlVO.getEstmDt();
							before_act_dt = sceCopDtlVO.getActCd();
//							cop_dtl_seq = sceCopDtlVO.getCopDtlSeq();
							
							if (estm_dt != null && !estm_dt.equals("") && estm_dt.length() == "YYYYMMDDHHMISS".length()) {
								String dor_arr_dt = rtnTroMap.get("dor_arr_dt");
								
								Calendar dtlEstm = setStrIntoCalendar(estm_dt);
								Calendar troEstm = setStrIntoCalendar(dor_arr_dt);
								
								if (dtlEstm != null && troEstm != null) {
									if (troEstm.compareTo(dtlEstm) > 0) { // tro 에서 입수된 estimated date 가 detail 의 estimated date 보다 이후일 경우
										// rescheduling
										SceCopSkdHisVO copSkdHisVO = new SceCopSkdHisVO();
										copSkdHisVO.setCopNo(sceCopDtlVO.getCopNo());
										copSkdHisVO.setFmCopDtlSeq(sceCopDtlVO.getCopDtlSeq());
										copSkdHisVO.setAftEstmDt(dor_arr_dt);
										copSkdHisVO.setCreUsrId("TRO");
										copSkdHisVO.setBfrActDt(before_act_dt);
										copSkdHisVO.setRcvEvntProcFlg("OE");
										copSkdHisVO.setSkdRcvDt(null);
										copSkdHisVO.setSkdVoyNo(null);
										copDetailReceiveBC.scheduleCopDetailBound(copSkdHisVO);
										
									} else if (troEstm.compareTo(dtlEstm) < 0) {
										// 단순 update
										dbDao.modifyOBMtEstmDt(sceCopDtlVO.getCopNo(), estm_dt, dor_arr_dt);
									}
								} else {
									log.info("While TRO Rescheduling, estm_Dt size error occurred!!!");
								}
							}
						}
					} else {
						List<SearchIBDoorDtlVO> sceCopDtlVOList = dbDao.searchIBDoorDtl(sceCopHdrVO.getCopNo());
						
						if (sceCopDtlVOList.size() > 0) {
							SearchIBDoorDtlVO searchIBDoorDtlVO = sceCopDtlVOList.get(0);
							estm_dt = searchIBDoorDtlVO.getEstmDt();
//							cop_dtl_seq = searchIBDoorDtlVO.getCopDtlSeq();
//							pre_estm_dt = searchIBDoorDtlVO.getPreEstmDt();
							post_estm_dt = searchIBDoorDtlVO.getPostEstmDt();
							
							//if (estm_dt != "" && estm_dt.length() == "YYYYMMDDHHMISS".length()) {
							if (estm_dt != null && !estm_dt.equals("") && estm_dt.length() == "YYYYMMDDHHMISS".length()) {
								String dor_arr_dt = rtnTroMap.get("dor_arr_dt");
								
								Calendar dtlEstm = setStrIntoCalendar(estm_dt);
								Calendar troEstm = setStrIntoCalendar(dor_arr_dt);
								
								if (dtlEstm != null && troEstm != null) {
									if (troEstm.compareTo(dtlEstm) > 0) { // tro 에서 입수된 estimated date 가 detail 의 estimated date 보다 이후일 경우
										// rescheduling
										SceCopSkdHisVO copSkdHisVO = new SceCopSkdHisVO();
										copSkdHisVO.setCopNo(sceCopHdrVO.getCopNo());
										copSkdHisVO.setFmCopDtlSeq(searchIBDoorDtlVO.getCopDtlSeq());
										copSkdHisVO.setAftEstmDt(dor_arr_dt);
										copSkdHisVO.setCreUsrId("TRO");
										copSkdHisVO.setRcvEvntProcFlg("IE");
										copSkdHisVO.setSkdRcvDt(null);
										copSkdHisVO.setSkdVoyNo(null);
										copDetailReceiveBC.scheduleCopDetailBound(copSkdHisVO);
										
									} else if (troEstm.compareTo(dtlEstm) < 0) {
										// 단순 update
										dbDao.modifyIBMtEstmDt(sceCopHdrVO.getCopNo(), estm_dt, dor_arr_dt, post_estm_dt);
									}
								} else {
									log.info("While TRO Rescheduling, estm_Dt size error occurred!!!");
								}
							}
						}
					}
//				}
				
				/**
				 * 
				 * 날짜 정보 mapping(ASIS)		구주	 O/B				구주 I/B					미/아주 O/B						미/아주 I/B
				 * EMPTY RETURN YARD CODE		TRM_PICKUP_CY			TRM_RETURN_CY			TRD_PICKUP_LOC||TRD_PICKUP_CY	TRD_RETURN_LOC||TRD_RETURN_CY
				 * DOOR NODE CODE				TRD_DOOR_LOC||ZN_CD		TRD_DOOR_LOC||ZN_CD		TRD_DOOR_LOC||ZN_CD				TRD_DOOR_LOC||ZN_CD
				 * CONTAINER RETURN DATE		TRM_RETURN_DT			TRM_PICKUP_DT			N/A								N/A
				 * DOOR ARRIVAL DATE			TRD_DOOR_DT				TRD_DOOR_DT				TRD_DT							TRD_DT
				 * 
				 * 
				 * 날짜 정보 mapping(TOBE)		구주	 O/B				구주 I/B					미/아주 O/B						미/아주 I/B
				 * EMPTY RETURN YARD CODE		TRM_PICKUP_CY			TRM_RETURN_CY			PKUP_LOC_CD||PKUPLOC_CD			RTN_LOC_CD||RTN_YD_CD
				 * DOOR NODE CODE				TRD_DOOR_LOC||ZN_CD		TRD_DOOR_LOC||ZN_CD		TRD_DOOR_LOC||ZN_CD				TRD_DOOR_LOC||ZN_CD
				 * CONTAINER RETURN DATE		TRM_RETURN_DT			TRM_PICKUP_DT			N/A								N/A
				 * DOOR ARRIVAL DATE			TRD_DOOR_DT				TRD_DOOR_DT				DOR_ARR_DT						DOR_ARR_DT
				 */
			}
			if (toBeUpdCopHdrList.size() != 0) {
				dbDao.modifyCopHdr(toBeUpdCopHdrList);
				for (int i = 0; i < toBeUpdCopHdrList.size(); i ++) {
					SceCopHdrVO tmpVO = toBeUpdCopHdrList.get(i);
					dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), io_bnd_cd.equals("O") ? "OI" : "II", "systro", "systro", "Y");
				}
			}
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}

	}

	/**
	 * 미주 / 구주 별로 나눠 TRO 정보를 조회하고 필요한 값을 Map 으로 return 한다.
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return Map<String, String>
	 * @throws DAOException
	 */
	private Map<String, String> searchTroInfo(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String area_conti_cd) throws DAOException {
		
		Map<String, String> rtnMap = new HashMap<String, String> ();
		rtnMap.put("bkg_no", bkg_no);
		rtnMap.put("tro_seq", tro_seq);
		rtnMap.put("tro_sub_seq", tro_sub_seq);
		rtnMap.put("io_bnd_cd", io_bnd_cd);
		rtnMap.put("area_conti_cd", area_conti_cd);
		
		BkgEurTroVO bkgEurTroVO = null;
		BkgEurTroDtlVO bkgEurTroDtlVO = null;
		
		BkgTroDtlVO bkgTroDtl = null;
		
		if (area_conti_cd.equals("E")) {
			List<BkgEurTroVO> bkgEurTroVOList = dbDao.searchBkgEurTro(bkg_no, tro_seq, io_bnd_cd);
			List<BkgEurTroDtlVO> bkgEurTroDtlVOList = dbDao.searchBkgEurTroDtl(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd);
			if (bkgEurTroVOList.size() != 0) {
				bkgEurTroVO = bkgEurTroVOList.get(0);
				rtnMap.put("cntr_tpsz_cd", bkgEurTroVO.getCntrTpszCd());
			}
			
			if (bkgEurTroDtlVOList.size() != 0) {
				bkgEurTroDtlVO = bkgEurTroDtlVOList.get(0);
				rtnMap.put("dor_arr_dt", bkgEurTroDtlVO.getArrDt());
			}
				
		} else {
			List<BkgTroVO> bkgTroVOList = dbDao.searchBkgTro(bkg_no, tro_seq, io_bnd_cd);
			List<BkgTroDtlVO> bkgTroDtlVOList = dbDao.searchBkgTroDtl(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd);
			if (bkgTroDtlVOList.size() != 0) {
				bkgTroDtl = bkgTroDtlVOList.get(0);
				rtnMap.put("cntr_tpsz_cd", bkgTroDtl.getCntrTpszCd());
				rtnMap.put("dor_arr_dt", bkgTroDtl.getDorArrDt());
				rtnMap.put("pkup_yd_cd", bkgTroDtl.getPkupYdCd());
				rtnMap.put("rtn_yd_cd", bkgTroDtl.getRtnYdCd());
				 
			}
			if (bkgTroVOList != null && bkgTroVOList.size() != 0) {
				BkgTroVO bkgTro = bkgTroVOList.get(0);
				rtnMap.put("zn_cd", bkgTro.getZnCd()); 	
			}
		}
		
		return rtnMap;
	}

	/**
	 * @param bkg_no
	 * @param pctl_no
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#createBkg(java.lang.String, java.lang.String)
	 */
	public void createBkg(String bkg_no, String pctl_no) throws EventException {
		try {
			
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(bkg_no);
			tmp.setPctlNo(pctl_no);
			tmp.setBkgEvntTpCd("IC"); // create bkg
			tmp.setBkgEvntRmk("Create Booking : bkg_no = " + bkg_no + " / pctl_no = " + pctl_no);
			
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);
			
			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), pctl_no);
			
//			[PRD] Actual Dwell Time 적용 SKD
//			String actDwlTimeRslt = dbDao.callPrdSetActDwTimePrc(pctl_no, "I", "N", "SYS");
			dbDao.callPrdSetActDwTimePrc(pctl_no, "I", "N", "SYS");

			List<SceCopHdrVO> rtnList = dbDao.searchCopInfo(bkg_no, pctl_no);
			
			List<SceCopHdrVO> distilled_list = new ArrayList<SceCopHdrVO> ();

			if (rtnList != null && rtnList.size() != 0) {
				for (int i = 0; i < rtnList.size() ; i++) {
					SceCopHdrVO rowVO = rtnList.get(i);
					
					if (rowVO.getCntrTpszCd() != null && rowVO.getCntrTpszCd().startsWith("Q")) {
						continue;
					}
					
					String copRailChk = dbDao.searchCopRailChk(rowVO.getPctlNo());
					rowVO.setCopRailChkCd(copRailChk);
//					List<SceCopHdrVO> railrcvList = dbDao.searchRailRcvCoffDt(bkg_no);
//					
//					if (railrcvList.size() > 0) {
//						SceCopHdrVO tmpVO = railrcvList.get(0);
//						rowVO.setRailRcvCoffFmDt(tmpVO.getRailRcvCoffFmDt());
//						rowVO.setRailRcvCoffToDt(tmpVO.getRailRcvCoffToDt());
//					}
					
					rowVO.setMstCopNo(rowVO.getCopNo());
					rowVO.setObTroFlg("N");
					rowVO.setIbTroFlg("N");
					
					rowVO.setCopUpdRmk("Created");
					
					distilled_list.add(rowVO);
				}
				dbDao.addCopHdr(distilled_list);
				dbDao.addSoList(distilled_list);
				dbDao.addCopDtl(distilled_list);
			}
			List<SceCopHdrVO> sceCopHdrVO = dbDao.searchCopHdr(bkg_no);
			for (int i = 0; i < sceCopHdrVO.size(); i++) {
				SceCopHdrVO rowVO = sceCopHdrVO.get(i);
				dbUtilDao.addSceCopHistory(rowVO.getCopNo(), "CC", "SysBkg", "SysBkg", "Y");
			}
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
		
	}
	/**
	 * @param bkg_no
	 * @param io_bnd_cd
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#unconfirmTro(java.lang.String, java.lang.String)
	 */
	public void unconfirmTro(String bkg_no, String io_bnd_cd) throws EventException {
		try {
			
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(bkg_no);
			tmp.setIoBndCd(io_bnd_cd);
			
			tmp.setBkgEvntTpCd("TX"); // unconfirm tro
			tmp.setBkgEvntRmk("Uncomfirm TRO : bkg_no = " + bkg_no +  " / io_bnd_cd = " + io_bnd_cd);
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), io_bnd_cd);
			
			List<ValidateTROSequenceVO> validateTROSequenceVOs = dbDao.validateTROSequence(bkg_no, io_bnd_cd, "");
			
			Map<String, String> rsltMap = new HashMap<String, String>();
			
			if (validateTROSequenceVOs != null && validateTROSequenceVOs.size() != 0) {
//				dbDao.removeTroMapInfo(validateTROSequenceVOs);

				ListIterator<ValidateTROSequenceVO> litor = validateTROSequenceVOs.listIterator();

				List<SceCopHdrVO> sceCopHdrVOs = new ArrayList<SceCopHdrVO>();
				while (litor.hasNext()) {
					ValidateTROSequenceVO validateTROSequenceVO = litor.next();
					
					List<TrsTrspSvcOrdVO> odsoList = dbDao.searchOdSoByCop(validateTROSequenceVO.getCopNo());
					if (odsoList != null && odsoList.size() > 0) {
						// OD-SO 가 발행된 COP 에 mapping 된 TRO -- unconfirm skip
						SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
						sceCopHdrVO.setCopNo(validateTROSequenceVO.getCopNo());
						sceCopHdrVO.setCopUpdRmk("Uncnfm skipped by ODSO!");
						
						sceCopHdrVOs.add(sceCopHdrVO);
						
						rsltMap.put(sceCopHdrVO.getCopNo(), "N");
					} else {
						SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();

						sceCopHdrVO.setCopNo(validateTROSequenceVO.getCopNo());

						if (validateTROSequenceVO.getIoBndCd().equals("I")) {
							sceCopHdrVO.setIbTroFlg("N");
							sceCopHdrVO.setCfmApntDt("");
						} else if (validateTROSequenceVO.getIoBndCd().equals(
								"O")) {
							sceCopHdrVO.setObTroFlg("N");
							sceCopHdrVO.setCfmObDorArrDt("");
						}
						sceCopHdrVOs.add(sceCopHdrVO);	
						dbDao.removeTroMapInfo(validateTROSequenceVO);
						rsltMap.put(sceCopHdrVO.getCopNo(), "Y");
					}
					String pctl_no = prdBC.createSceSoReplanByBkgInfo(validateTROSequenceVO.getCopNo(), "T", "unCfmTro");
					if( pctl_no != null && !pctl_no.equals("")){
						SceCopHdrVO replanSceCopHdrVO = new SceCopHdrVO();
						replanSceCopHdrVO.setCopNo(validateTROSequenceVO.getCopNo());
						replanSceCopHdrVO.setPctlNo(pctl_no);
						replanSceCopHdrVO.setBkgNo(bkg_no);
						replanManageBC.replanCop(replanSceCopHdrVO, "1.unCfmTro");
					}
				}
				if (sceCopHdrVOs.size() > 0) {
					dbDao.modifyCopHdr(sceCopHdrVOs);
					for (int i = 0; i < sceCopHdrVOs.size(); i++) {
						SceCopHdrVO tmpVO = sceCopHdrVOs.get(i);
						dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), io_bnd_cd.equals("O") ? "OD" : "ID", "systro", "systro", (String)rsltMap.get(tmpVO.getCopNo()));
					}
				}
				
			}

		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}  catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#unconfirmTro(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void unconfirmTro(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd) throws EventException {
		try {
			
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(bkg_no);
			tmp.setTroSeq(tro_seq);
			tmp.setTroSubSeq(tro_sub_seq);
			tmp.setIoBndCd(io_bnd_cd);
			
			tmp.setBkgEvntTpCd("TX"); // unconfirm tro
			tmp.setBkgEvntRmk("Uncomfirm TRO : bkg_no = " + bkg_no + " / tro_seq = " + tro_seq + " / tro_sub_seq = " + tro_sub_seq + " / io_bnd_cd = " + io_bnd_cd);
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), tro_seq);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), tro_sub_seq);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), io_bnd_cd);
			
			Map<String, String> rsltMap = new HashMap<String, String>();
			
			List<ValidateTROSequenceVO> validateTROSequenceVOs = dbDao.validateTROSequence(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, "");
		
			List<SceCopHdrVO> sceCopHdrVOs = new ArrayList<SceCopHdrVO>();
					
			if (validateTROSequenceVOs != null && validateTROSequenceVOs.size() != 0) {
				dbDao.removeTroMapInfo(validateTROSequenceVOs);

				ListIterator<ValidateTROSequenceVO> litor = validateTROSequenceVOs.listIterator();

				while (litor.hasNext()) {
					ValidateTROSequenceVO validateTROSequenceVO = litor.next();
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();

					sceCopHdrVO.setCopNo(validateTROSequenceVO.getCopNo());

					if (validateTROSequenceVO.getIoBndCd().equals("I")) {
						sceCopHdrVO.setIbTroFlg("N");
						sceCopHdrVO.setCfmApntDt("");
					} else if (validateTROSequenceVO.getIoBndCd().equals(
							"O")) {
						sceCopHdrVO.setObTroFlg("N");
						sceCopHdrVO.setCfmObDorArrDt("");
					}

					rsltMap.put(sceCopHdrVO.getCopNo(), "Y");

					sceCopHdrVOs.add(sceCopHdrVO);

					String pctl_no = prdBC.createSceSoReplanByBkgInfo(validateTROSequenceVO.getCopNo(), "T", "unCfmTro");

					if( pctl_no != null && !pctl_no.equals("")){
						SceCopHdrVO replanSceCopHdrVO = new SceCopHdrVO();
						replanSceCopHdrVO.setCopNo(validateTROSequenceVO.getCopNo());
						replanSceCopHdrVO.setPctlNo(pctl_no);
						replanSceCopHdrVO.setBkgNo(bkg_no);
						replanSceCopHdrVO.setCntrNo(validateTROSequenceVO.getCntrNo());
						replanManageBC.replanCop(replanSceCopHdrVO, "2.unCfmTro");
					}
				}
			}

			// TRO 가 unconfirm 되었을 때 Carrier's haulage 일 경우 등 기존 TRO 로 반영된 PC no
			// 가 존재한다면
			// tro mapping 의 정보를 삭제한 후 replan 을 돌려야하는데.... transaction 의 문제가
			// 있다...			
			if (sceCopHdrVOs.size() > 0) {
				dbDao.modifyCopHdr(sceCopHdrVOs);
				for (int i = 0; i < sceCopHdrVOs.size(); i++) {
					SceCopHdrVO tmpVO = sceCopHdrVOs.get(i);
					dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), io_bnd_cd.equals("O") ? "OD" : "ID", "systro", "systro", rsltMap.get(tmpVO.getCopNo()));
				}
			}
			
			List <SceCopHdrVO> sceCopHdrList = dbDao.searchNoCntrObTroCopsRSQL(bkg_no);
			for (int i = 0 ; i < sceCopHdrList.size(); i++) {
				SceCopHdrVO tmpVO = sceCopHdrList.get(i);
				moveTroInfo(tmpVO.getCopNo(), SCEConstants.CONTAINER_DETACH);
			}
			
			
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}  catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}

	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param partialFlag
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#detachCntr(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void detachCntr(String bkg_no, String cntr_no, String partialFlag) throws EventException {
		log.info("\n[poong] detachCntr start");
		log.info("\n[poong] detachCntr bkg_no"+bkg_no+"/cntr_no="+cntr_no+"/partialFlag="+partialFlag);
	    SceBkgOpHisVO tmp = new SceBkgOpHisVO();
		tmp.setBkgNo(bkg_no);
		tmp.setCntrNo(cntr_no);
		tmp.setPrtFlg(partialFlag);
		
		tmp.setBkgEvntTpCd("CD"); // container detach
		tmp.setBkgEvntRmk("Detach Cntr : bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " / partial flag = " + partialFlag);
		SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

		int rowNum = 1;
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), cntr_no);
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), partialFlag);
		
		try {
			detachCntrMain(bkg_no, cntr_no, partialFlag);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param partialFlag
	 * @return SceCopHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	private SceCopHdrVO detachCntrMain(String bkg_no, String cntr_no, String partialFlag) throws DAOException, Exception {
		
		List<SceCopHdrVO> toBeCops = new ArrayList<SceCopHdrVO>();
		log.info("\n[poong] detachCntrMain start");
		log.info("\n[poong] detachCntrMain bkg_no"+bkg_no+"/cntr_no="+cntr_no+"/partialFlag="+partialFlag);
		List<SceCopHdrVO> toBeDetachedList = dbDao.searchCopHdr(bkg_no, cntr_no);
		if (toBeDetachedList.size() == 0) {
			return null;
		}
		SceCopHdrVO toBeDetached = toBeDetachedList.get(0);
		
		SceCopHdrVO changedMst = null;

		// partial 일 경우이며 master cop 를 detach 할 경우 
		// (partialFlag != null && partialFlag.equals("Y")) &&  조건 제거 : partial 간의 합이 1이 보장 안되는 관계로 최초 등록한 container 가 detach 될 때 partial 이 있음에도 'N'
		// 이 들어오는 경우가 있다.
		if (toBeDetached.getCopNo().equals(toBeDetached.getMstCopNo())) {// partial 이며 Master 인 COP 의 container 가 detach 될 경우
			/**
			 * master flag 를 옮긴다. trnk_vsl_cd, trnk_skd_voy_no,
			 * trnk_skd_dir_cd, cntr_no, pol_cd, bkg_cgo_tp_cd 가 동일한 COP 를
			 * 찾아낸다. 없을 경우에는 booking 에서 해당 case 를 다시 찾아보고 찾을 수 없을 경우에는 flag
			 * 가 잘못 넘어온것으로 판단하고 FCL 로직으로 간다.
			 * 
			 * S/O 는 detach 전 booking 에서 validation 하므로 신경 쓰지 않는다. TRO /
			 * OD-SO 는 Booking 관련이므로 그냥 둔다.
			 * 
			 * CA (Correction advice) 의 경우도 마찬가지로 S/O validation 은 있으모로 신경
			 * 안써도 된다. (CA 는 단지 update 불가를 화면단위에서 푸는 것으로 세부 로직은 동일하다)
			 */

//			List<SceCopHdrVO> sceCopHdrVOs = dbDao.searchPartialCop(bkg_no, cntr_no);
//			if (sceCopHdrVOs != null && sceCopHdrVOs.size() != 0) {
//				SceCopHdrVO sceCopHdrVO = sceCopHdrVOs.get(0);
				String old_cop_no = toBeDetached.getCopNo();
				String old_mst_cop_no = toBeDetached.getMstCopNo();
				
				if (old_mst_cop_no != null && !old_mst_cop_no.equals("")) {
					if (old_cop_no.equals(old_mst_cop_no)) {
						// detach 대상이 master 일 경우 :
						// 1. partail cop no 들을 조회
						// 2. 대상 cop 를 update 대상으로 잡는다.
						List<SceCopHdrVO> partialCops = dbDao.searchToBeMaster(toBeDetached);
						String toBeMstCopNo = ""; // next Master 가 될 cop no

						if (partialCops.size() >= 1) {
							ListIterator<SceCopHdrVO> listIterator = partialCops.listIterator();
							boolean mstChk = true;
							while (listIterator.hasNext()) {
//								if (!mstChk)
//									break;
								
								SceCopHdrVO partialCop = listIterator.next();

								if (mstChk) {
									toBeMstCopNo = partialCop.getCopNo();
									mstChk = false;
								}
								SceCopHdrVO tmpVo = new SceCopHdrVO();
								tmpVo.setCopNo(partialCop.getCopNo());
								tmpVo.setBkgNo(partialCop.getBkgNo());
								tmpVo.setMstCopNo(toBeMstCopNo);

								toBeCops.add(tmpVo);
								
								if (mstChk && !old_cop_no.equals("")) {
									// Master 의 S/O 이동 작업
									BkgBookingVO bkgVO = dbDao.searchBkgBooking(partialCop.getBkgNo());
									String bl_no = bkgVO.getBlNo();
									
									List<ScePlnSoListVO> oldSoList = dbDao.searchPlnSoList(old_cop_no);
									
									TrsTrspSvcOrdVO svcOrdVO = new TrsTrspSvcOrdVO();
									svcOrdVO.setBkgNo(tmpVo.getBkgNo());
									svcOrdVO.setBlNo(bl_no);
									svcOrdVO.setCopNo(old_cop_no);
									dbDao.modifySvcOrdByCop(tmpVo.getMstCopNo(), svcOrdVO);	
									
									
									TrsTrspRailBilOrdVO railBilVO = new TrsTrspRailBilOrdVO();
									railBilVO.setBkgNo(tmpVo.getBkgNo());
									railBilVO.setBlNo(bl_no);
									railBilVO.setCopNo(old_cop_no);
									dbDao.modifyRailBilOrdByCop(tmpVo.getMstCopNo(), railBilVO);
									
									if (dbDao.searchDiffRoute(old_cop_no, tmpVo.getMstCopNo())) {
										String pctl_no = prdBC.createSceSoReplan(tmpVo.getCopNo(), "T", "Detach");
										tmpVo.setPctlNo(pctl_no);
										tmpVo.setCopUpdRmk(cntr_no + " CD, MST / Rpln");
										replanManageBC.replanCop(tmpVo, "DtchCntr");
									}
									
									List<ScePlnSoListVO> newSoList = dbDao.searchPlnSoList(tmpVo.getCopNo());
									List<ScePlnSoListVO> distilled_soList = new ArrayList<ScePlnSoListVO> ();
									
									for (int i = 0; i < oldSoList.size(); i ++) {
										ScePlnSoListVO oldSo = oldSoList.get(i);
										String n1st_nod_cd = oldSo.getN1stNodCd() == null ? "" : oldSo.getN1stNodCd();
										String n2nd_nod_cd = oldSo.getN2ndNodCd() == null ? "" : oldSo.getN2ndNodCd();
										String n3rd_nod_cd = oldSo.getN3rdNodCd() == null ? "" : oldSo.getN3rdNodCd();
										String n4th_nod_cd = oldSo.getN4thNodCd() == null ? "" : oldSo.getN4thNodCd();
										String trsp_mod_cd = oldSo.getTrspModCd() == null ? "" : oldSo.getTrspModCd();
										String cost_act_grp_cd = oldSo.getCostActGrpCd() == null ? "" : oldSo.getCostActGrpCd();
//										String cost_act_grp_seq = rowVO.getCostActGrpSeq() == null ? "" : rowVO.getCostActGrpSeq();
										

										for (int j = 0; j < newSoList.size(); j ++) {
											ScePlnSoListVO newSo = newSoList.get(j);
											
											String new_n1st_nod_cd = newSo.getN1stNodCd() == null ? "" : newSo.getN1stNodCd();
											String new_n2nd_nod_cd = newSo.getN2ndNodCd() == null ? "" : newSo.getN2ndNodCd();
											String new_n3rd_nod_cd = newSo.getN3rdNodCd() == null ? "" : newSo.getN3rdNodCd();
											String new_n4th_nod_cd = newSo.getN4thNodCd() == null ? "" : newSo.getN4thNodCd();
											String new_trsp_mod_cd = newSo.getTrspModCd() == null ? "" : newSo.getTrspModCd();
											String new_cost_act_grp_cd = newSo.getCostActGrpCd() == null ? "" : newSo.getCostActGrpCd();
//												String new_cost_act_grp_seq = newSo.getCostActGrpSeq() == null ? "" : newSo.getCostActGrpSeq();

											if (oldSo.getTrspSoStsCd() != null && !oldSo.getTrspSoStsCd().equals(SCEConstants.SO_PLANNED)) {
											
												if (
														n1st_nod_cd.equals(new_n1st_nod_cd) &&
														n2nd_nod_cd.equals(new_n2nd_nod_cd) &&
														n3rd_nod_cd.equals(new_n3rd_nod_cd) &&
														n4th_nod_cd.equals(new_n4th_nod_cd) &&
														cost_act_grp_cd.equals(new_cost_act_grp_cd) &&
														trsp_mod_cd.equals(new_trsp_mod_cd) 
												) {
													// route 정보 및 운송 형태 / cost type 가 동일한 경우
													newSo.setTrspSoStsCd(oldSo.getTrspSoStsCd());
													
													oldSoList.remove(i); 
												}
											}
											
											distilled_soList.add(newSo);
										}
									}
								}
								
								changedMst = tmpVo;
							}
//							sceCopHdrVO.setMstCopNo(sceCopHdrVO.getCopNo());
//							sceCopHdrVO.setCnmvYr("");
//							sceCopHdrVO.setCntrNo(SCEConstants.PSEUDO_CNTR_NO);
//							toBeCops.add(sceCopHdrVO);
						}
					} 
//					else if (!old_cop_no.equals(old_mst_cop_no)) {
						// detach 대상이 master 가 아닐 경우
//						sceCopHdrVO.setCntrNo(SCEConstants.PSEUDO_CNTR_NO);
//						sceCopHdrVO.setCnmvYr("");
//						sceCopHdrVO.setMstCopNo(sceCopHdrVO.getCopNo());
//						toBeCops.add(sceCopHdrVO);
//					}
					// 대상 부킹이 BDR 이후에 detach 된 case 라면 cancel 시켜야 하는지 확인 필요

				}
//			} else {
				// detach 대상이 없을 경우

//			}

		} else { // partial 이 아니거나  detach 될 cop 가 slave 인 경우


		}
		
		moveTroInfo(toBeDetached.getCopNo(), SCEConstants.CONTAINER_DETACH);
		toBeDetached.setObTroFlg(""); // 상기에서 tro 가 이동되었을 때를 대비하여 ob_tro_flg 를 초기화 해 modifyCopHdr 에서 원복 안되게 함

		// detach 될  cop 의 tpsz 와 동일한 (flex height 감안) COP 들 중 detach 될 cop 를 제외한 cop 개수가 bkg qty (flex height 감안) 개수 보다 클 경우 detach 될 cop 를 cancel 한다. 
		boolean rslt = dbDao.checkCopToBeCanceled(toBeDetached.getCopNo());
		if (rslt)
			toBeDetached.setCopStsCd(SCEConstants.COP_CANCELED);
		
		toBeDetached.setCntrNo(SCEConstants.PSEUDO_CNTR_NO);
		toBeDetached.setMstCopNo(toBeDetached.getCopNo());
		toBeDetached.setCnmvYr("");
		toBeDetached.setCopUpdRmk("CD : " + cntr_no);
		toBeCops.add(toBeDetached);
		
		// master 여부와 관계없이 detach 대상이 존재할 경우에는 detach 실행하고 master flag 가 변경될
		// 대상도 역시 변경
		if (toBeCops.size() != 0) {
			dbDao.modifyCopHdr(toBeCops);
			for (int i = 0; i < toBeCops.size(); i ++) {
				SceCopHdrVO tmpVO = toBeCops.get(i);
				if (tmpVO != null && !tmpVO.getCopNo().equals("")) {
					dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), "CD", "SysCop", "SysDthCop", "Y");
				}
			}

		}
		log.info("\n[poong] detachCntrMain end changedMst="+changedMst);
		return changedMst;
	}

	/**
	 * @param bkg_no
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#cancelBkg(java.lang.String)
	 */
	public void cancelBkg(String bkg_no) throws EventException {
		try {
			
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(bkg_no);
			tmp.setBkgEvntTpCd("UX"); // cancel booking
			tmp.setBkgEvntRmk("Cancel Bkg : bkg_no = " + bkg_no);
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
			
			cancelBkgMain(bkg_no, sceBkgOpHisVO);

		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * @param bkg_no
	 * @param sceBkgOpHisVO
	 * @throws EventException
	 * @throws DAOException
	 */
	private void cancelBkgMain(String bkg_no, SceBkgOpHisVO sceBkgOpHisVO) throws EventException, DAOException {

		List<SceCopHdrVO> sceCopHdrVOList = dbDao.searchCopHdr(bkg_no);

//		List<SceCopDtlVO> toBeUpdtCopDtlList = new ArrayList<SceCopDtlVO>();
//		List<SceCopHdrVO> toBeUpdtCopHdrList = new ArrayList<SceCopHdrVO>();
		if (sceCopHdrVOList != null && sceCopHdrVOList.size() != 0) {
			for (int i = 0; i < sceCopHdrVOList.size(); i++) {
				SceCopHdrVO sceCopHdrVO = sceCopHdrVOList.get(i);

				//3. COP Header 의 Cancel 처리
				SceCopHdrVO tempVO = new SceCopHdrVO();
				tempVO.setCopNo(sceCopHdrVO.getCopNo());
				tempVO.setCopStsCd("X");
				tempVO.setUpdUsrId("SYS");
				
				tempVO.setCopUpdRmk("CnclByBkg");
				
//				toBeUpdtCopHdrList.add(tempVO);
				int rowCnt = dbDao.modifyCopHdr(tempVO);
				if (rowCnt != Statement.EXECUTE_FAILED) {
					dbUtilDao.addSceCopHistory(tempVO.getCopNo(), "CN", "SysCop", "SysCelCop", "Y");
				} else {
					dbUtilDao.addSceCopHistory(tempVO.getCopNo(), "CN", "SysCop", "SysCelCop", "N");
				}
				
				// 내부적으로 master flag 정리
				if (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))
					replanManageBC.arrangeMstCopNo(bkg_no, sceCopHdrVO.getCntrNo(), sceCopHdrVO.getCopNo());
				
				
			}
//			dbDao.modifyCopDtl(toBeUpdtCopDtlList);
		}
		// 3. master 로 지정된 cop 가 cancel 되었을 경우 다른 COP 를 master 로 변경하고
		// SO 의 cop 정보를 변경하여 준다.

		// REPLAN BCIMPL 호출 필요
	}

	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @param isPartial
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#attachCntr(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void attachCntr(String bkg_no, String cntr_no, String isPartial) throws EventException {
		/**
		 * 1. attach 되려는 container 가 다른 cop 에 attach 되어 있고 finish 되지 않았으며
		 * Inbouond 까지 진행 되었고 vvd 가 다를 경우는 finish 시키고 exception resolve, MT 전송
		 * 여부 확인 후 edi 전송 등을 시도
		 * 
		 * 2. attach 되려는 container 가 동일 vvd 로 다른 cop 에 쓰이고 있다면 partial 이므로
		 * master cop no 를 가져온다.
		 * 
		 * 3. prov_cntr_no prov_cntr_no 가 선 할당된 cop 에 먼저 붙인다. prov_cntr_no 가 할당된
		 * cop 가 master 가 되어야 하는 법인듯..
		 * 
		 * 4. cntr type size 를 고려하여 attach 될 대상 cop 를 찾는다.
		 * 
		 * 5. 대상 cop 가 없을 경우 동일 cntr type size 의 cop 의 pc no 를 찾아 신규 cop 를 생성한다.
		 * 
		 * 6. 대상 cop 가 존재 할 경우 header 를 update 한다.
		 * 
		 */
	    log.info("\n[poong] attachCntr bkg_no"+bkg_no+"/cntr_no="+cntr_no+"/isPartial="+isPartial);
		SceBkgOpHisVO tmp = new SceBkgOpHisVO();
		tmp.setBkgNo(bkg_no);
		tmp.setBkgEvntTpCd("CA");
		tmp.setBkgEvntRmk("Container attach / Bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " / partial = " + isPartial);
		tmp.setCntrNo(cntr_no);
		tmp.setPrtFlg(isPartial);
		SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

		int rowNum = 1;
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), cntr_no);
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), isPartial);
		
		try {
			// Manual 작업을 위해 null / "" 일 경우 partial 여 부 재확인
			if (isPartial == null || isPartial.equals("")) {
				List<SceCopHdrVO> rtnList = dbDao.searchPartialCops(bkg_no, cntr_no, "C");
				if (rtnList != null && rtnList.size() > 1)
					isPartial = "Y";
				else
					isPartial = "N";
			}
			
			attachCntrMain(bkg_no, cntr_no, isPartial);

		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	/**
	 *  Mixed term 이다.
	 *  attach 될 container 의 receive term 이 door 이다 : attach 대상을 tro confirm 된 것을 찾는다. 없으면 임의의 cop. 
	 *  									  yard 이다 : attach 대상을 tro confirm 되지 않은 것을 찾는다. 모두 tro confirm 되어 있다면 새로 COP 생성!
	 * @param bkg_no
	 * @param cntr_no
	 * @param isPartial
	 * @throws DAOException
	 * @throws Exception
	 */
	private void attachCntrMain(String bkg_no, String cntr_no, String isPartial) throws DAOException, Exception {
//		log.info("********* ATTACH-CNTR-MAIN Called! bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " isPartial = " + isPartial);
	    log.info("\n[poong] attachCntrMain start");
	    log.info("\n[poong] attachCntrMain bkg_no"+bkg_no+"/cntr_no="+cntr_no+"/isPartial="+isPartial);
	    BkgBookingVO bkgBookingVO = dbDao.searchBkgBooking(bkg_no);
		List<BkgContainerVO> bkgContainerVOList = dbDao.searchBkgContainer(
				bkg_no, cntr_no);
		BkgContainerVO bkgContainerVO = new BkgContainerVO();
		
		boolean isMixed = false;
		
		SceCopHdrVO attachCopHdr = null; //container 가 attach 될 최종 결정된 COP VO
		
		if (bkgContainerVOList.size() == 0) {
			return;
		} else {
			bkgContainerVO = bkgContainerVOList.get(0);
		}
		log.info("\n attachCntrMain Log 1");
		//container tpsz 가 조회가 안된 case 의 보완 부분 : mst_container 를 재 조회
		if (bkgContainerVO != null && (bkgContainerVO.getCntrTpszCd() == null || bkgContainerVO.getCntrTpszCd().equals(""))) {
			List<MstContainerVO> mstCntrList = dbDao.searchMstContainer(cntr_no);
			if (mstCntrList != null && mstCntrList.size() > 0) {
				MstContainerVO tmp = mstCntrList.get(0);
				bkgContainerVO.setCntrTpszCd(tmp.getCntrTpszCd());
			}
		}
		log.info("\n attachCntrMain Log 2");
		final String org_cntrTpszCd = (bkgContainerVO!=null?bkgContainerVO.getCntrTpszCd():"");

		Set<String> cntrTpszCdSet = new HashSet<String>();

		cntrTpszCdSet.add(org_cntrTpszCd);
		
		String bkg_evnt_dt = (bkgContainerVO!=null?bkgContainerVO.getCreDt():"");
		log.info("\n bkgBookingVO.getBkgCgoTpCd(): "+bkgBookingVO.getBkgCgoTpCd());
		// Repositioning cargo booking 에 대해서는 처리하지 않는다.
		if (bkgBookingVO.getBkgCgoTpCd().equals("P")) {
			// history set
			return;
		}

		// 혹시 기 처리된 operation 이 다시 들어왔을 경우에는 재처리 하지 않는다.
		log.info("\n attachCntrMain Log 3");
		List<SceCopHdrVO> crntCop = dbDao.searchCopHdr(bkg_no, cntr_no);
		if (crntCop.size() >= 1) {
			SceCopHdrVO tmp = crntCop.get(0);
			dbUtilDao.addSceCopHistory(tmp.getCopNo(), "CA", "SYS", "SYS", "N");
			
			SceCopHdrVO updVO = new SceCopHdrVO();
			updVO.setCopNo(tmp.getCopNo());
			
			if ( !tmp.getCntrTpszCd().equals(org_cntrTpszCd) ) {
				updVO.setCntrTpszCd(org_cntrTpszCd);
				updVO.setCopUpdRmk("CA Skip(DUP)- COP TPSZ : " + tmp.getCntrTpszCd() + " BKG TPSZ : " + org_cntrTpszCd);
			} else {
				updVO.setCopUpdRmk("CA Skip(DUP)");
			}
					
			dbDao.modifyCopHdr(updVO);
			
			return;
		}
		log.info("\n attachCntrMain Log 4");
		// flex height flag = 'Y' 일 경우 붙이려는 container 와 호환되는 cntr tpsz 의 cop
		// 에도 attach 가능
		if (bkgBookingVO.getFlexHgtFlg().equals("Y")) {
			Set<String> repoTpsz = dbDao.searchRepoRule(org_cntrTpszCd);
			if (repoTpsz != null && repoTpsz.size() > 0) {
				cntrTpszCdSet.addAll(repoTpsz);
			}
		}
		
		if (bkgBookingVO !=null && bkgContainerVO != null && (("M".equals(bkgBookingVO.getRcvTermCd()) && !"D".equals(bkgContainerVO.getRcvTermCd())) ||
				("M".equals(bkgBookingVO.getDeTermCd()) && !bkgContainerVO.getDeTermCd().equals("D")))
		) {
			isMixed = true;
		}
		


		// BkgBlDocVO bkgBlDocVO = dbDao.searchBkgBlDoc(bkg_no);
		//			
		// // BDR 일 경우
		// if (bkgBlDocVO.getBdrFlg().equals("Y")) {
		//				
		// }
		
		log.info("\n attachCntrMain Log 5");
		// 하기 조회된 값으로 상기 1번 사항을 수행한다.  해당 CNTR의 현재 C,T 상태인 Partial Booking List를 모두 조회한다.
		List<SceCopHdrVO> sceCopHdrVOs = dbDao.searchCopToBeClosed(bkg_no,cntr_no);
		ListIterator<SceCopHdrVO> listItr = sceCopHdrVOs.listIterator();

		List<SceCopHdrVO> updateCopHdrVOs = new ArrayList<SceCopHdrVO>();
		
		while (listItr.hasNext()) {
			SceCopHdrVO toBeClosedCop = listItr.next();

			// close 될 대상 cop 가 Inbound 운송이 되지 않았다면 skip
			if (!dbDao.searchCopBnd(toBeClosedCop.getCopNo()).getCopBndCd().equals("I")) {
				log.info("\n attachCntrMain Log 5-1");
				continue;
			}

			// MT 전송 내역이 존재하지 않을 경우
			if (dbDao.validateEdiSndRslt(toBeClosedCop.getBkgNo(), cntr_no, "MT") == 0) {
				// TODO : CX edi 전송시도
				log.info("\n attachCntrMain Log 5-2");
				SceCopDtlVO dtlVO = dbDao.searchNodSysDtForCX(toBeClosedCop.getBkgNo(), toBeClosedCop.getCntrNo());
				
				Edi315SendVO edi315SendVO = new Edi315SendVO();
				
				edi315SendVO.setCntrNo(toBeClosedCop.getCntrNo());
				edi315SendVO.setBkgNo(toBeClosedCop.getBkgNo());
				edi315SendVO.setCopNo(toBeClosedCop.getCopNo());
				edi315SendVO.setEdiStatus("CX");
				edi315SendVO.setCallFrom("COP");
//				edi315SendVO.setCurrVvd(dtlVO.getVslCd() + dtlVO.getSkdVoyNo() + dtlVO.getSkdDirCd()); // ??
				edi315SendVO.setEventDt(dtlVO.getActDt());
				edi315SendVO.setEventYard(dtlVO.getNodCd());
				edi315SendVO.setCreId("CntrAttach");
				edi315SendVO.setUpdId("CntrAttach");
				
				double starttime = System.currentTimeMillis();
				
				log.info("Start CX EDI 315 SEND!!! = " +  starttime);
				
				edi315BC.edi315Send(edi315SendVO);
				
				double endtime = System.currentTimeMillis();
				
				log.info("Start CX EDI 315 SEND!!! = " + endtime + " / elapse time = " + (endtime - starttime)  );
				
			}
			// 대상 cop 는 close 시킨다.
			SceCopHdrVO updateCopHdrVO = new SceCopHdrVO();
			updateCopHdrVO.setCopNo(toBeClosedCop.getCopNo());
			updateCopHdrVO.setCopStsCd("F");
			log.info("\n attachCntrMain Log 5-2-1");
			updateCopHdrVO.setCopFshDt(dbDao.searchMaxActDt(toBeClosedCop.getCopNo()));
			log.info("\n attachCntrMain Log 5-2-2");
			updateCopHdrVO.setCopUpdRmk("CLZ BY CA : " + cntr_no + "/fsh_dt = " + updateCopHdrVO.getCopFshDt());

			updateCopHdrVOs.add(updateCopHdrVO);
		}
		if (updateCopHdrVOs.size() != 0) {
			log.info("\n attachCntrMain Log 5-3");
			dbDao.modifyCopHdr(updateCopHdrVOs); // 미리 update 하고 종료
			updateCopHdrVOs = new ArrayList<SceCopHdrVO>();
			log.info("\n attachCntrMain Log 5-3-1");
		}

		// 3. provider 가 제공한 container no 를 mapping 한 cop 가 있을 경우 해당 cop 에
		// container attach
		// 하고 partial 관계일 경우 master 로 지정하여 준다.
		
		// 단, SMCU0000000 인 COP 만 찾는다. (20100406 iskim)
		log.info("\n attachCntrMain Log 6");
		List<SceCopHdrVO> sceCopHdrVOList = dbDao.searchProvCntr(bkg_no,
				cntr_no);

		Calendar cal = Calendar.getInstance();
		if (sceCopHdrVOList.size() >= 1) {
			log.info("\n attachCntrMain Log 6-1");
			SceCopHdrVO rowVO = sceCopHdrVOList.get(0);
			// provider cntr no 가 존재할 경우
			attachCopHdr = new SceCopHdrVO();
			attachCopHdr.setCopNo(rowVO.getCopNo());
			attachCopHdr.setCntrNo(cntr_no);
			attachCopHdr.setCntrTpszCd(bkgContainerVO!=null?bkgContainerVO.getCntrTpszCd():"");
			attachCopHdr.setCnmvYr(cal.get(Calendar.YEAR) + "");
			attachCopHdr.setUpdUsrId("SYSTEM");
			
			attachCopHdr.setCopUpdRmk("ProvCntr:" + cntr_no);
			
			updateCopHdrVOs.add(attachCopHdr);
			log.info("\n attachCntrMain Log 6-1-1");
		} else {
			// provider cntr no 가 존재 하지 않을 경우
			log.info("\n attachCntrMain Log 6-2");
			List<SceCopHdrVO> attachCopHdrVOs = dbDao.searchAttachCopInfo(bkg_no, cntrTpszCdSet, org_cntrTpszCd);
//			ListIterator<SceCopHdrVO> attachCopHdrVOItr = attachCopHdrVOs.listIterator();
			
			// mixed term 의 door receive term 의 container
			if (bkgBookingVO !=null && bkgContainerVO != null && "M".equals(bkgBookingVO.getRcvTermCd()) && "D".equals(bkgContainerVO.getRcvTermCd())) {
				log.info("\n attachCntrMain Log 6-2-1");
				log.info("\n 6-2-1 bkgBookingVO.getRcvTermCd() : "+bkgBookingVO.getRcvTermCd());
				log.info("\n 6-2-1 bkgContainerVO.getRcvTermCd() : "+bkgContainerVO.getRcvTermCd());
				log.info("\n 6-2-1 bkgContainerVO.getRcvTermCd() : "+bkgContainerVO.getRcvTermCd());
				for (int i = 0; i < attachCopHdrVOs.size(); i++) {
					SceCopHdrVO rowTmp = attachCopHdrVOs.get(i);
					// tro confirm 되고 od-so 여부는 중요하지 않다.. 나던 안나던....
					if (rowTmp.getCntrTpszCd().equals(org_cntrTpszCd)
							&& (rowTmp.getObTroFlg().equals("Y"))) {
						attachCopHdr = rowTmp;
						break;
					}
				}
			} else if (bkgBookingVO !=null && bkgContainerVO != null && "M".equals(bkgBookingVO.getRcvTermCd()) && !"M".equals(bkgContainerVO.getRcvTermCd())) {
				// tro confirm 되지 않은 COP 를 찾고 
				log.info("\n attachCntrMain Log 6-2-2");
				log.info("\n 6-2-2 bkgBookingVO.getRcvTermCd() : "+bkgBookingVO.getRcvTermCd());
				log.info("\n 6-2-2 bkgContainerVO.getRcvTermCd() : "+bkgContainerVO.getRcvTermCd());
				log.info("\n 6-2-2 bkgContainerVO.getRcvTermCd() : "+bkgContainerVO.getRcvTermCd());
				for (int i = 0; i < attachCopHdrVOs.size(); i++) {
					SceCopHdrVO rowTmp = attachCopHdrVOs.get(i);
					// tro confirm 되고 od-so 여부는 중요하지 않다.. 나던 안나던....
					if (rowTmp.getCntrTpszCd().equals(org_cntrTpszCd)
							&& (rowTmp.getObTroFlg() == null || rowTmp.getObTroFlg().equals("N"))) {
						attachCopHdr = rowTmp;
						break;
					}
				}
				
			}
			
			log.info("\n attachCntrMain Log 7");
			log.info("\n attachCntrMain 7 attachCopHdr :"+attachCopHdr);
			if (attachCopHdr == null) {
				log.info("\n attachCntrMain Log 7-1");
				for (int i = 0; i < attachCopHdrVOs.size(); i++) {
					SceCopHdrVO rowTmp = attachCopHdrVOs.get(i);
					log.info("\n rowTmp.getCntrTpszCd() : "+rowTmp.getCntrTpszCd());
					log.info("\n org_cntrTpszCd : "+org_cntrTpszCd);
					// 1. 원래 container type size 와 동일한가 ? attachCopHdrVOs 조회시 org_cntrTpszCd 와 동일한 COP 가 먼저 나오므로 여기서 처음 처리 될 확률이 높다.
					if (attachCopHdr == null && rowTmp.getCntrTpszCd().equals(org_cntrTpszCd)) {
						log.info("\n attachCntrMain Log 7-1-1");
						attachCopHdr = rowTmp;
					}
					
					// 2. COP 가 원래 container tpsz 와 동일하지 않지만 flex height 감안한 호환 case 에 포함 된다면 일단 선정
					if (attachCopHdr == null && cntrTpszCdSet.contains((String) rowTmp.getCntrTpszCd())) {
						log.info("\n attachCntrMain Log 7-1-2");
						attachCopHdr = rowTmp;
						attachCopHdr.setCntrTpszCd(org_cntrTpszCd); // 호환되는 type size 이므로 bkg_container 의 tpsz 로 변경
					}
					// 3. 원래 container type size 와 동일하고 TRO 가 발행된 cop 가 최우선이므로 막판 뒤집기 한다.
					if (rowTmp.getCntrTpszCd().equals(org_cntrTpszCd)
							&& (rowTmp.getObTroFlg().equals("Y"))) {
						log.info("\n attachCntrMain Log 7-1-3");
						attachCopHdr = rowTmp;
						break;
					}
				}
			}
			
			// cop 신규 생성
			log.info("\n attachCntrMain Log 8");
			log.info("\n attachCntrMain 8 attachCopHdr :"+attachCopHdr);
			if (attachCopHdr == null) {
				// 대표 PC 를 가져온다.
//				String pctl_no = dbDao.searchRepPctlNo(bkg_no, org_cntrTpszCd);
				String pctl_no = bkgBookingVO.getPctlNo() == null ? "" : bkgBookingVO.getPctlNo();
				log.info("\n attachCntrMain 8 pctl_no : "+pctl_no);
				if (pctl_no.equals("") || pctl_no.startsWith("N")) {
					pctl_no = dbDao.searchRepPctlNo(bkg_no, org_cntrTpszCd);
				}
				
				// cntr_no 와 cntr_tpsz_cd 를 set 한 SCE_COP_HDR 입력 대상 정보 조회
				List<SceCopHdrVO> tobeCrtCopHdrVOs = dbDao.searchCopHdrToBeCreated(bkg_no, cntr_no, org_cntrTpszCd, pctl_no, null);
				
				log.info("\n[poong] createNewCop tobeCrtCopHdrVOs="+tobeCrtCopHdrVOs);
				// cntr_no 가 붙은 채로 cop 가 생성된다.
				replanManageBC.createNewCop(tobeCrtCopHdrVOs);
				log.info("\n attachCntrMain Log 8-1");
				for (int i = 0 ; i < tobeCrtCopHdrVOs.size(); i ++) {
					SceCopHdrVO rowVO = tobeCrtCopHdrVOs.get(i);
					if (isMixed) {
						pctl_no = "";
						String bnd_tp_cd = "";
						
						if (bkgBookingVO.getRcvTermCd().equals("M") && bkgBookingVO.getDeTermCd().equals("M"))
							bnd_tp_cd = "T";
						else if (bkgBookingVO.getRcvTermCd().equals("M") && !bkgBookingVO.getDeTermCd().equals("M"))
							bnd_tp_cd = "O";
						else if (!bkgBookingVO.getRcvTermCd().equals("M") && bkgBookingVO.getDeTermCd().equals("M")) 
							bnd_tp_cd = "I";
						
						pctl_no = prdBC.createSceSoReplan(rowVO.getCopNo(), bnd_tp_cd, "AttachCntr");
						log.info("\n attachCntrMain 8-2 pctl_no : "+pctl_no);
						if (pctl_no != null && !pctl_no.equals("")) {
							rowVO.setPctlNo(pctl_no);
							rowVO.setBkgNo(bkg_no);
							log.info("\n attachCntrMain Log 8-3");
							replanManageBC.replanCop(rowVO, "AtchCntr");
							log.info("\n attachCntrMain Log 8-4");
						}
					}
					SceCopHdrVO tempVO = new SceCopHdrVO();
					tempVO.setCopNo(rowVO.getCopNo());
					tempVO.setCopUpdRmk("CA(COP CRT):" + rowVO.getCntrNo());
					
					updateCopHdrVOs.add(tempVO);
				}
				log.info("\n attachCntrMain Log 8-5");
				attachCopHdr = tobeCrtCopHdrVOs.get(0); //searchCopHdrToBeCreated 쿼리 특성상 1개의 COP 만이 return 된다.
				log.info("\n attachCntrMain Log 8-6");
			} else { // 기 존재하는 COP 에 container number update
				log.info("\n attachCntrMain Log 8-7");
				attachCopHdr.setCntrNo(cntr_no);
				attachCopHdr.setCnmvYr(cal.get(Calendar.YEAR) + "");
				attachCopHdr.setUpdUsrId("SYSTEM");
				
				attachCopHdr.setCopUpdRmk("CA:" + cntr_no);
				
				updateCopHdrVOs.add(attachCopHdr);
//				dbDao.modifyCopHdr(updateCopHdrVOs);
			}
		}
		cal = null;
		log.info("\n attachCntrMain Log 9");
		log.info("\n attachCntrMain Log 9 updateCopHdrVOs"+updateCopHdrVOs);
		if (updateCopHdrVOs.size() != 0) {
			// booking 의 receive term 이 mixed 이고 container 의 term 이 Door 가 아니거나 booking 의 delivery term 이 mixed 이고 container 의 term 이 Door 가 아닐 경우
			// pc 호출 하여 cop 별 replan 수행
			log.info("\n attachCntrMain Log 9 isMixed : "+isMixed);
			if (isMixed) {
				for (int i = 0 ; i < updateCopHdrVOs.size(); i ++) { // updateCopHdrVOs 는 무조건 size() = 1 이어야 한다.
					SceCopHdrVO rowVO = updateCopHdrVOs.get(i);
					
					String bnd_tp_cd = "";
					
					// 
					if (bkgBookingVO.getRcvTermCd().equals("M") && bkgBookingVO.getDeTermCd().equals("M"))
						bnd_tp_cd = "T";
					else if (bkgBookingVO.getRcvTermCd().equals("M") && !bkgBookingVO.getDeTermCd().equals("M"))
						bnd_tp_cd = "O";
					else if (!bkgBookingVO.getRcvTermCd().equals("M") && bkgBookingVO.getDeTermCd().equals("M")) 
						bnd_tp_cd = "I";
					
					String pctl_no = prdBC.createSceSoReplan(rowVO.getCopNo(), bnd_tp_cd, "AttachCntr");
					log.info("\n attachCntrMain Log 9-1");
					log.info("\n attachCntrMain Log 9-1 pctl_no :"+pctl_no);
					if (pctl_no != null && !pctl_no.equals("")) { // 적절한 route 가 존재하면 replan
						rowVO.setPctlNo(pctl_no);
						rowVO.setBkgNo(bkg_no);
						log.info("\n attachCntrMain Log 9-2");
						replanManageBC.replanCop(rowVO, "AtchCntr(Mixed)");
						log.info("\n attachCntrMain Log 9-3");
					} else {
						dbDao.modifyCopHdr(updateCopHdrVOs);
						for (int j = 0; j < updateCopHdrVOs.size(); j ++) {
							SceCopHdrVO tmpVO = updateCopHdrVOs.get(j);
							if (tmpVO != null && !tmpVO.getCopNo().equals("")) {
								log.info("\n attachCntrMain Log 9-4");
								dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), "CA", "SysCop", "SysAttCop", "Y");
								log.info("\n attachCntrMain Log 9-5");
							}
						}
					}
					// partial 관계가 성립했을 수도 있으므로 master flag 정리
					log.info("first arrangeMstCopNo ***********");
					log.info("bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " / cop_no = " + rowVO.getCopNo());
					replanManageBC.arrangeMstCopNo(bkg_no, cntr_no, rowVO.getCopNo());
					log.info("first arrangeMstCopNo END ***********");
				}
			} else {
				log.info("\n attachCntrMain Log 9-6");
				dbDao.modifyCopHdr(updateCopHdrVOs);
				log.info("\n attachCntrMain Log 9-7");
				for (int j = 0; j < updateCopHdrVOs.size(); j ++) {
					SceCopHdrVO tmpVO = updateCopHdrVOs.get(j);
					
					// partial 관계가 성립했을 수도 있으므로 master flag 정리
					log.info("second arrangeMstCopNo ***********");
					log.info("bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " / cop_no = " + tmpVO.getCopNo());
					replanManageBC.arrangeMstCopNo(bkg_no, cntr_no, tmpVO.getCopNo());
					log.info("second arrangeMstCopNo END ***********");
					dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), "CA", "SysCop", "SysAttCop", "Y");
					log.info("second addSceCopHistory END ***********");
				}
			}
			// actual 등을 찾는 방법 : 받을 수 있는 모든 정보.. : 현재 돌지 않는다...
			// container 와 관련된 모든 booking 의 history : split / combine / attach / partial
//			for (int i = 0 ; i < updateCopHdrVOs.size(); i ++) {
//				SceCopHdrVO sceCopHdrVO = updateCopHdrVOs.get(i);
//				
//				if (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) {
//					List<String> bkgList = new ArrayList<String> ();
//					
//					// 1. partial list
//					List<SceCopHdrVO> ptlList = dbDao.searchPartialCops(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo(), "C");
//					
//					if (ptlList != null && ptlList.size() > 1) {
//						if (ptlList.size() == 0) {
//							bkgList.add(sceCopHdrVO.getBkgNo());
//						} else {
//							for (int k = 0; k < ptlList.size(); k ++) {
//								SceCopHdrVO tmpHdrVOPrtl = ptlList.get(k);
//								bkgList.add (tmpHdrVOPrtl.getBkgNo());
//							}	
//						}
//					}
//					if (bkgList.size() > 0) {
//						dbDao.modifyCopDtlForActReMap(sceCopHdrVO.getCopNo());
//						dbDao.addSceActRcvIfBySplit(sceCopHdrVO, bkgList);
//					}
//						
//					
//					// 2. 최종 cycle no 를 가져와 
//					
////					List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo(), sceCopHdrVO.getCopNo());
////					for (int j = 0; j < actualList.size(); j ++) {
////						SceActRcvIfVO actVO = actualList.get(j);
////						copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
////					}	
//				}
//			}
		}
		
		// attachCntrHdr 에 대해서 BF status edi 전송
		log.info("\n attachCntrMain Log 10");
		log.info("\n attachCntrMain Log 10 attachCopHdr :"+attachCopHdr);
		if (attachCopHdr != null) {
			List<SearchPorForSendBFVO> porList = dbDao.searchPorForSendBF(bkg_no, attachCopHdr.getCntrNo());
			log.info("\n attachCntrMain Log 10-1 porList :"+porList);
			if (porList != null && porList.size() > 0) {
				for (int i = 0; i < porList.size(); i ++) {
					SearchPorForSendBFVO rowVO = porList.get(i);
					
					Edi315SendVO edi315SendVO = new Edi315SendVO();
					
					edi315SendVO.setCntrNo(rowVO.getCntrNo());
					edi315SendVO.setBkgNo(rowVO.getBkgNo());
					edi315SendVO.setCopNo(rowVO.getCopNo());
					edi315SendVO.setEdiStatus(rowVO.getEdiStndStsCd()); // BF
					edi315SendVO.setCallFrom("COP");
//					edi315SendVO.setCurrVvd(veRow.getVslCd() + veRow.getSkdVoyNo() + veRow.getSkdDirCd());
					edi315SendVO.setEventDt(rowVO.getActDt());
					edi315SendVO.setEventYard(rowVO.getNodCd());
					edi315SendVO.setCreId("CntrAttach");
					edi315SendVO.setUpdId("CntrAttach");
					
					double starttime = System.currentTimeMillis();
					
					log.info("Start BF EDI 315 SEND!!! = " +  starttime);
					
					edi315BC.edi315Send(edi315SendVO);
					
					double endtime = System.currentTimeMillis();
					
					log.info("Start BF EDI 315 SEND!!! = " + endtime + " / elapse time = " + (endtime - starttime)  );
				}
			}
			log.info("\n attachCntrMain Log 10-2");
			SceCopDtlVO dtlVO = dbDao.searchVDLSendHistory(bkg_no, attachCopHdr.getCntrNo());
			log.info("\n attachCntrMain Log 10-3");
//			if (dtlVO.getCopNo() == null) {
//				log.info("dtlVO.getCopNo() is null ! > Bkg_no = " +bkg_no + " / getCntrNo	 = "  + attachCopHdr.getCntrNo());
//			} else {
//				log.info("dtlVO cop_no exists = " + dtlVO.getCopNo());
//			}
			log.info("\n attachCntrMain Log 11");
			if (dtlVO.getCopNo() != null && !dtlVO.getCopNo().equals("")) {
				Edi315SendVO edi315SendVO = new Edi315SendVO();
				log.info("\n attachCntrMain Log 11-1");
				String act_dt = dbDao.searchLstATDForSendVDL(dtlVO);
//				log.info("act_Dt = !! " + act_dt);
				log.info("\n attachCntrMain Log 11-1 act_dt : "+act_dt);
				log.info("\n attachCntrMain Log 11-2");
				if (act_dt != null && !act_dt.equals("")) {
					edi315SendVO.setCntrNo(attachCopHdr.getCntrNo());
					edi315SendVO.setBkgNo(bkg_no);
					edi315SendVO.setCopNo(dtlVO.getCopNo());
					edi315SendVO.setEdiStatus(dtlVO.getStndEdiStsCd()); // BF
					edi315SendVO.setCallFrom("COP");
					edi315SendVO.setCurrVvd(dtlVO.getVslCd() + dtlVO.getSkdVoyNo() + dtlVO.getSkdDirCd());
					edi315SendVO.setEventDt(act_dt);
					edi315SendVO.setEventYard(dtlVO.getNodCd());
					edi315SendVO.setVdlByCntrAttach("Y");
					edi315SendVO.setCreId("CntrAttach");
					edi315SendVO.setUpdId("CntrAttach");
					edi315SendVO.setCopDtlSeq(dtlVO.getCopDtlSeq());
					
					double starttime = System.currentTimeMillis();
					
					log.info("Start BF EDI 315 SEND!!! = " +  starttime);
					
					edi315BC.edi315Send(edi315SendVO);
					
					double endtime = System.currentTimeMillis();
					
					log.info("Start BF EDI 315 SEND!!! = " + endtime + " / elapse time = " + (endtime - starttime)  );
				}
			}
		}
		// lea_bkg_cntr_his_prc 호출
		log.info("LEA_BKG_CNTR_HIS_PRC STATRTS!! : bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " / bkg_evnt_dt = " + bkg_evnt_dt);
		interfaceLeaCntrBkgHis(bkg_no, cntr_no);
		log.info("LEA_BKG_CNTR_HIS_PRC ENDS!!");
		log.info("\n[poong] attachCntrMain end");
	}

	/**
	 * @param org_bkg_no
	 * @param combined_bkg_no
	 * @param combineTroNewSeqVOs
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#combineBkg(java.lang.String[], java.lang.String, java.util.List)
	 */
	public void combineBkg(String[] org_bkg_no, String combined_bkg_no, List<CombineTroNewSeqVO> combineTroNewSeqVOs) throws EventException {
		try {

		    log.info("\n[poong] combineBkg start");
		    
		    for(int i=0; i < org_bkg_no.length; i++){
		        log.info("\n[poong] org_bkg_no["+i+"]="+org_bkg_no[i]);
		    }
		    log.info("\n[poong] combined_bkg_no"+combined_bkg_no);
		    
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(combined_bkg_no);
			tmp.setBkgEvntTpCd("BC"); // booking combine
			tmp.setBkgEvntRmk("Combine Bkg : org_bkg_no = " + transArrayIntoString(org_bkg_no) + " / combined_bkg_no = " + combined_bkg_no);
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);

			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), transArrayIntoString(org_bkg_no));
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), combined_bkg_no);
			
			List<SceCopHdrVO> toBeHdrUpdtList = new ArrayList<SceCopHdrVO>();
			List<TrsTrspSvcOrdVO> toBeSoUpdtList = new ArrayList<TrsTrspSvcOrdVO>();

//			List<SceCopHdrVO> replanNeedList = new ArrayList<SceCopHdrVO>();
			// replan 필요 여부 판단 : container 별로 master 가 org_bkg_no 내에 있고
			// combined_bkg_no 에 있으면 OK
			// 만약 아무데도 없어도 OK, combined_bkg_no 에 없으면 combined_bkg_no 로 master
			// 옮기고 S/O Replan

//			ArrayUtils.removeElement(org_bkg_no, combined_bkg_no);
			
//			int toBeDelIdx = Arrays.binarySearch(org_bkg_no, combined_bkg_no);
			int toBeDelIdx = 0;
			
			for (int i = 0; i < org_bkg_no.length; i ++) {
				if (org_bkg_no[i].equals(combined_bkg_no)) {
					toBeDelIdx = i;
					break;
				}
			}
			log.info("toBeDelIdx = " + toBeDelIdx);
			log.info("org_bkg_no.length = " + org_bkg_no.length);
			String org_bkg_expt_comb[] = new String[org_bkg_no.length - 1];
			int tmpCnt = 0;
			for (int i = 0; i < org_bkg_no.length; i ++) {
				if (i != toBeDelIdx) {
					org_bkg_expt_comb[tmpCnt] = org_bkg_no[i];
					tmpCnt ++;
				}
			}
			
			List<SceCopHdrVO> slaveBkgCopList = dbDao.searchCopHdrByBkgNos(org_bkg_expt_comb);  // combine 되어 없어질 booking(가칭 : slave booking)  으로 생성된 COP List
			List<SceCopHdrVO> mstBkgCopList = dbDao.searchCopHdr(combined_bkg_no);		// combine 된 후 존재할 booking (master booking) 으로 생성된 COP List

			BkgBookingVO bkgVO = dbDao.searchBkgBooking(combined_bkg_no); // combine 된 booking 의 VO 를 조회
			
			
			if (mstBkgCopList.size() == 0 ) {
				throw new EventException ("To be combined Cops are not found!!");
			} 
			
			log.info("\n[poong] slaveBkgCopList"+slaveBkgCopList);
			/* COMBINE 실행전에 ORG_BKG의 Partial BKG List를 조회한다. */
			/* COMBINE이 실행되면 Container NO가 변경되는 경우 Org BKG의 Partial List를 조회하는게 불가능해지기 때문이다. */
			List<SceCopHdrVO> oldBkgList = new ArrayList<SceCopHdrVO> ();
			for (int i = 0; i < slaveBkgCopList.size(); i++) {
                 SceCopHdrVO sceCopHdrVO = slaveBkgCopList.get(i);
                 if (sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)) { // pseudo container 가 아닐때만 actual mapping 시도

                     List<SceCopHdrVO> prtlList = dbDao.searchPartialCops(sceCopHdrVO.getBkgNo(), sceCopHdrVO.getCntrNo(), "C");
                     
                     if (prtlList.size() == 0) {
                         oldBkgList.add(sceCopHdrVO);
                     } else {
                         for (int k = 0; k < prtlList.size(); k ++) {
                             SceCopHdrVO tmpHdrVOPrtl = prtlList.get(k);
                             oldBkgList.add(tmpHdrVOPrtl);
                         }   
                     }

                 }
            }
			
			/* Combine시에는 Combine target bkg에 source bkg에 속한 Cntr가 존재하지 않을수도 있기때문에 
			 * Source bkg와 비교하여 속하지 않은 CNTR의 경우 Source cop를 Actual Event copy 대상으로 추가한다.
			 * 단 Actual Event copy시 bkg no는 Combine target bkg로 변경한다.
			 * */
			List<SceCopHdrVO> copyActRcvIfList = new ArrayList<SceCopHdrVO>();
			copyActRcvIfList.addAll(mstBkgCopList); // combine 된 후 존재할 booking (master booking) 으로 생성된 COP List
            for(SceCopHdrVO sceCopHdrVO : slaveBkgCopList ){
                if(sceCopHdrVO.getCntrNo() != null && !sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO)){
                    boolean isNewCntrNo = true;
                    
                    for( SceCopHdrVO mstSceCopHdrVO : copyActRcvIfList){
                        if(sceCopHdrVO.getCntrNo().equals(mstSceCopHdrVO.getCntrNo())){
                            isNewCntrNo = false;
                            break;
                        }
                    }
                    
                    if(isNewCntrNo) {
                        copyActRcvIfList.add(sceCopHdrVO);
                    }
                }
            }
            
            log.info("\n[poong] copyActRcvIfList"+copyActRcvIfList);
			
			// master booking 으로 생성된 cop 들에서  mst_cop_no set, cntr_no set, cop_no set 을 생성한다. (차후 비교 logic 에서 사용)
			Set<String> toBeMstCopSet = new HashSet<String> ();
			Set<String> toBeCombCntrNoSet = new HashSet<String> ();
			Set<String> toBeCombCopNoSet = new HashSet<String> ();
			for (int i = 0; i < mstBkgCopList.size(); i ++) {
				SceCopHdrVO tmpVO = mstBkgCopList.get(i);
				String cop_no = tmpVO.getCopNo();
				String mst_cop_no = tmpVO.getMstCopNo();
				String cntr_no = tmpVO.getCntrNo();
				
				toBeMstCopSet.add(mst_cop_no);
				toBeCombCntrNoSet.add(cntr_no);
				toBeCombCopNoSet.add(cop_no);
			}
			// slave booking 으로 생성된 cop 들에서  mst_cop_no set, cntr_no set, cop_no set 을 생성한다. (차후 비교 logic 에서 사용)			
			Set<String> wasMstCopSet = new HashSet<String> ();
			Set<String> wasCntrNoSet = new HashSet<String> ();
			Set<String> wasCopNoSet = new HashSet<String> ();
			Map<String, String> wasSlaveBkgMstCop = new HashMap<String, String> ();
			
			Set<String> processedCntrNo = new HashSet<String> ();
			
			for (int i = 0; i < slaveBkgCopList.size() ; i ++) {
				SceCopHdrVO tmpVO = slaveBkgCopList.get(i);
				String cop_no = tmpVO.getCopNo();
				String mst_cop_no = tmpVO.getMstCopNo();
				String cntr_no = tmpVO.getCntrNo();
				
				// slave bkg 에 의한 cop 지만  master cop 일 경우에는 만약 partial 끼리 combine 할 때 우선 살려둘 대상이 된다.
				if (tmpVO.getCopNo().equals(tmpVO.getMstCopNo())) { 
					wasSlaveBkgMstCop.put(cntr_no, cop_no);
				}
				
				wasMstCopSet.add(mst_cop_no);
				wasCntrNoSet.add(cntr_no);
				wasCopNoSet.add(cop_no);
			}
			List<SearchCopCntLimitVO> copCntLimitList = dbDao.searchCopCntLimit(combined_bkg_no);
			Map<String, Integer> copCntLimit = new HashMap<String, Integer> ();
			
			for (int i = 0; i < copCntLimitList.size(); i ++) {
				SearchCopCntLimitVO copCntLimitVO = copCntLimitList.get(i);
				copCntLimit.put(copCntLimitVO.getCntrTpszCd(), new Integer(copCntLimitVO.getCopLimit()));
			}

			// slave booking 으로 생성된 COP 들에 대한 to-do job choose
			int survivedCnt = 0; // tro 나 odso 가 존재하여 cancel 대상이 되지 않는 cop 개수
			for (int i = 0; i < slaveBkgCopList.size(); i++) {
				SceCopHdrVO slaveCop = slaveBkgCopList.get(i);
				
				if (slaveCop.getCntrNo() != null && (slaveCop.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO) || slaveCop.getCntrNo().equals(""))) {
//				1. container 가 attach 되지 않은 slave booking 의 cop 에 대해 booking no update 수행
					// TODO : qty check 작업을 통해 불필요한 cop 정리 작업을 진행하여야 한다.
					// bkg_quantity 와 bkg_container 를 비교하여 empty cop 가 필요한지 판단한다.
					
					SceCopHdrVO tmpVO = new SceCopHdrVO();
					if (copCntLimit.containsKey(slaveCop.getCntrTpszCd())) {
						int cnt = copCntLimit.get(slaveCop.getCntrTpszCd()).intValue();
						
						if (slaveCop.getObTroFlg().equals("Y") || slaveCop.getIbTroFlg().equals("Y")) {// tro 가 연계된 case
							log.info("TRO connected!! : " + slaveCop.getCopNo());
							tmpVO.setCopUpdRmk("BC:TRO:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
							tmpVO.setCopNo(slaveCop.getCopNo());
							tmpVO.setBkgNo(combined_bkg_no);
							
							toBeHdrUpdtList.add(tmpVO);	
							
							TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
							toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
							toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
							toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
							toBeSoUpdtList.add(toBeUpdSoVO);
							
							
							survivedCnt ++;
						} else { // tro 가 연계 되지 않았지만 ODSO 가 연관된 case
							List<TrsTrspSvcOrdVO> svcOrdList = dbDao.searchOdSoByCop(slaveCop.getCopNo());
							if (svcOrdList.size() > 0) {
								log.info("ODSO Connected !! : " + slaveCop.getCopNo());
								tmpVO.setCopUpdRmk("BC:ODSO:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
								tmpVO.setCopNo(slaveCop.getCopNo());
								tmpVO.setBkgNo(combined_bkg_no);

								TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
								toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
								toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
								toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
								toBeSoUpdtList.add(toBeUpdSoVO);
								
								toBeHdrUpdtList.add(tmpVO);	
								survivedCnt ++;
							} else {
								if (survivedCnt < cnt) {
									tmpVO.setCopUpdRmk("BC2:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
									tmpVO.setCopNo(slaveCop.getCopNo());
									tmpVO.setBkgNo(combined_bkg_no);

									TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
									toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
									toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
									toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
									toBeSoUpdtList.add(toBeUpdSoVO);
									
									toBeHdrUpdtList.add(tmpVO);		
									
									survivedCnt ++;
									log.info ("Survived : " + slaveCop.getCopNo() + " / cnt = " + survivedCnt);
		
								} else {
									tmpVO.setCopUpdRmk("BC2-2:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +"):Cncl");
									tmpVO.setCopNo(slaveCop.getCopNo());
									tmpVO.setCopStsCd("X");
									TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
									toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
									toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
									toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
									toBeSoUpdtList.add(toBeUpdSoVO);
									
									toBeHdrUpdtList.add(tmpVO);	
									
									log.info ("Canceled : " + slaveCop.getCopNo() + " / cnt = " + survivedCnt);
								}
							}
						}
					} else {
						tmpVO.setCopUpdRmk("BC3:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
						tmpVO.setCopNo(slaveCop.getCopNo());
						tmpVO.setBkgNo(combined_bkg_no);
						toBeHdrUpdtList.add(tmpVO);			
						
						TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
						toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
						toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
						toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
						toBeSoUpdtList.add(toBeUpdSoVO);
						
						survivedCnt ++;
					}
				} else {
//				2. container 가 attach 된 cop 를 처리한다
					//2-1. slave booking 으로 생성된 cop 가 master 일 경우
					if (slaveCop.getMstCopNo() != null && (slaveCop.getMstCopNo().equals(slaveCop.getCopNo()))) { 
						if (toBeCombCntrNoSet.contains(slaveCop.getCntrNo())) {
							// 2-1-1. master booking 에 해당하는 cop 중에 slave booking 이 가진  container 가 존재 할 경우 master 될 cop 를 master 로 변경 시키고 cop replan 진행. 자기 자신은 cancel
							
							// 자기 자신의 cancel
							SceCopHdrVO tmpVO = new SceCopHdrVO();
							tmpVO.setCopNo(slaveCop.getCopNo());
							tmpVO.setCopStsCd("X");
							tmpVO.setCopUpdRmk("CnclByCmb");
							toBeHdrUpdtList.add(tmpVO);
							
							for (int k = 0; k < mstBkgCopList.size(); k ++) {
								SceCopHdrVO mstCop = mstBkgCopList.get(k);
								if (mstCop.getCntrNo().equals(slaveCop.getCntrNo())) {
									tmpVO = new SceCopHdrVO();
									tmpVO.setCopNo(mstCop.getCopNo());
									tmpVO.setPctlNo(slaveCop.getPctlNo());
									tmpVO.setMstCopNo(mstCop.getCopNo());
							
									tmpVO.setBkgNo(mstCop.getBkgNo()); // bkg no setting 추가
							
									tmpVO.setCopUpdRmk("MstByCmb:Rpln = " + slaveCop.getPctlNo());
									
									TrsTrspRailBilOrdVO trsTrspRailBilOrdVO = new TrsTrspRailBilOrdVO();
									TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
									
									trsTrspRailBilOrdVO.setCopNo(slaveCop.getCopNo());
									trsTrspRailBilOrdVO.setBkgNo(mstCop.getBkgNo());
									trsTrspRailBilOrdVO.setBlNo(bkgVO.getBlNo());
									
									trsTrspSvcOrdVO.setCopNo(slaveCop.getCopNo());
									trsTrspSvcOrdVO.setBkgNo(mstCop.getBkgNo());
									trsTrspSvcOrdVO.setBlNo(bkgVO.getBlNo());
									
									dbDao.modifyRailBilOrdByCop(mstCop.getCopNo(), trsTrspRailBilOrdVO);
									dbDao.modifySvcOrdByCop(mstCop.getCopNo(), trsTrspSvcOrdVO);
									if (!mstCop.getPctlNo().equals(slaveCop.getPctlNo())) {// pctl_no 가 서로 상이할 경우에만 replan 수행
//										replanNeedList.add(tmpVO);										
										replanManageBC.replanCop (tmpVO, "BkgCmb");
									} else {
										// replan 이 불필요 한 경우 cop header 만 update
										toBeHdrUpdtList.add(tmpVO);
									}
									break;
								}
							}
						} else {
							// 2. 자기 자신이 master 이면서 combined_bkg_no 에 해당하는 cop 중에 자기 자신이 가진 container 가 없을 경우 update bkg no 하고  so 의 bkg no 변경과 COA notice 진행
							SceCopHdrVO tmpVO = new SceCopHdrVO();
							tmpVO.setCopUpdRmk("BC4:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
							tmpVO.setBkgNo(combined_bkg_no);
							tmpVO.setCopNo(slaveCop.getCopNo());
							
							toBeHdrUpdtList.add(tmpVO);
							
							toBeCombCntrNoSet.add(slaveCop.getCntrNo());
							
							TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
							toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
							toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
							toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
							toBeSoUpdtList.add(toBeUpdSoVO);
						}
					} else { // slave booking 의  cop 가  master cop 가 아니다.
						// 자기 자신이 master 가 아닐 경우 combined_bkg_no 에 해당하는 cop 중에 자기 자신이 가진 container 가 존재하고 그 cop 가 master 일 경우 자기 자신을 cancel 시킨다.
						// 자기 자신이 master 가 아닐 경우 combined_bkg_no 에 해당하는 cop 중에 자기 자신이 가진 container 가 존재하고 그 cop 가 master 가 아닐 경우 역시 자기 자신을cancel
						// 자기 자신이 master 가 아닐 경우 combined_bkg_no 에 해당하는 cop 중에 자기 자신이 가진 container 가 존재지 않는다면 update bkg no 하고 master cop no 정제 필요
						
						// 자기 자신이 master 가 아닐 경우 combined_bkg_no 에 해당하는 cop 중에 자기
						
						if (toBeCombCntrNoSet.contains(slaveCop.getCntrNo()) && (processedCntrNo.size() >= 1 && processedCntrNo.contains(slaveCop.getCntrNo()))) {
							// 자기 자신의 cancel
							SceCopHdrVO tmpVO = new SceCopHdrVO();
							tmpVO.setCopUpdRmk("BC5:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
							tmpVO.setCopNo(slaveCop.getCopNo());
							tmpVO.setCopStsCd("X");
							toBeHdrUpdtList.add(tmpVO);
						} else if (!toBeCombCntrNoSet.contains(slaveCop.getCntrNo()) && (processedCntrNo.size() >= 1 && processedCntrNo.contains(slaveCop.getCntrNo()))) {
							// master bkg 에 cntr 가 없지만 기 처리된 내역이 있으면 cancel
							// 자기 자신의 cancel
							SceCopHdrVO tmpVO = new SceCopHdrVO();
							tmpVO.setCopUpdRmk("BC6:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
							tmpVO.setCopNo(slaveCop.getCopNo());
							tmpVO.setCopStsCd("X");
							toBeHdrUpdtList.add(tmpVO);
						} else if (toBeCombCntrNoSet.contains(slaveCop.getCntrNo())) {
							// master bkg 에 cntr 가 있기만 해도 cancel
							SceCopHdrVO tmpVO = new SceCopHdrVO();
							tmpVO.setCopUpdRmk("BC7:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
							tmpVO.setCopNo(slaveCop.getCopNo());
							tmpVO.setCopStsCd("X");
							toBeHdrUpdtList.add(tmpVO);
						} else if (!toBeCombCntrNoSet.contains(slaveCop.getCntrNo())) {
//							slave cop set 에 mst_cop 인 cop 가 존재할 경우는 cancel 시킨다.
							if (wasSlaveBkgMstCop.containsKey(slaveCop.getCntrNo())) {
								SceCopHdrVO tmpVO = new SceCopHdrVO();
								tmpVO.setCopUpdRmk("BC9:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
								tmpVO.setCopNo(slaveCop.getCopNo());
								tmpVO.setCopStsCd("X");
								toBeHdrUpdtList.add(tmpVO);
							} else { // mst cop 인 COP 가 slave bkg 내에 미 존재할 경우는 slave cop 의 bkg no 를 변경한다.
								SceCopHdrVO tmpVO = new SceCopHdrVO();
								tmpVO.setCopUpdRmk("BC10:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
								tmpVO.setBkgNo(combined_bkg_no);
								tmpVO.setCopNo(slaveCop.getCopNo());
								toBeHdrUpdtList.add(tmpVO);
							}
						} else {
							SceCopHdrVO tmpVO = new SceCopHdrVO();
							tmpVO.setCopUpdRmk("BC8:FM(" + slaveCop.getBkgNo()+")-TO(" + combined_bkg_no +")");
							tmpVO.setCopNo(slaveCop.getCopNo());
							tmpVO.setBkgNo(combined_bkg_no);
							toBeHdrUpdtList.add(tmpVO);
							
							TrsTrspSvcOrdVO toBeUpdSoVO = new TrsTrspSvcOrdVO();
							toBeUpdSoVO.setCopNo(tmpVO.getCopNo());
							toBeUpdSoVO.setBkgNo(tmpVO.getBkgNo());
							toBeUpdSoVO.setBlNo(bkgVO.getBlNo());
							toBeSoUpdtList.add(toBeUpdSoVO);
						}

					}
					dbDao.modifyCopDtlForActReMap(slaveCop.getCopNo()); // container 가 있는 slave cop 의 detail 정보를 초기화
				}
				processedCntrNo.add(slaveCop.getCntrNo());
			}
			
			// TRO 정리작업 진행 : 세번째 parameter 인 List<CombineTroNewSeqVO> combineTroNewSeqVOs 를 활용하여
			// combine 되면서 bkg_no 가 통합되고 sequence 가 다시 생성된 내역을 정리한다. (SCE_TRO_MAPG)
			// tro_seq 만 변경됨
//			dbDao.modifyTroMapgByBkg(org_bkg_no, combined_bkg_no);
			
			if (combineTroNewSeqVOs != null && combineTroNewSeqVOs.size() > 0) { // 정리할 TRO 가 존재시
				dbDao.modifyTroMapgByNewSeqVO(combineTroNewSeqVOs);
				dbDao.modifyOdSoByNewVO(combineTroNewSeqVOs);
			}
			
			// TODO : combine 된 cop 에서 master cop number 정리 및 동일 booking_no 와 container no 로 된 cop 가 여러개 존재 시 이를 정리한다.
			if (toBeHdrUpdtList.size() != 0) {
				dbDao.modifyCopHdr(toBeHdrUpdtList);
			}
			
			
			if (toBeSoUpdtList.size() != 0) {
				dbDao.modifyRailBilOrdBkgNo(toBeSoUpdtList);
				dbDao.modifySvcOrdBkgNo(toBeSoUpdtList);
			}
			
	        /* Org BKG + Org BKG Partial List 에서 발생된 Actual Event를 New BKG로 복사한다. 이미 복사한경우는 복사하지 않는다. */

			int insertCnt = 0;
			for (int i = 0; i < copyActRcvIfList.size(); i++) {
                SceCopHdrVO sceCopHdrVO = copyActRcvIfList.get(i);
                sceCopHdrVO.setBkgNo(combined_bkg_no);
                log.info("\n[poong] i="+i+"/sceCopHdrVO="+sceCopHdrVO);
                if (oldBkgList.size() > 0){
                    insertCnt = dbDao.copySceActRcvIfBySplit(sceCopHdrVO, oldBkgList, "CrtByCombine");
                    log.info("\n[poong] copySceActRcvIfBySplit insertCnt="+insertCnt);
                    /* copy 하지 못했다는 의미는 partial bkg중 하나에 대해 actual 정보가 존재한다는 의미다 
                     * 이경우 new bkg에 대해 actual 정보가 존재하는 경우가 아니면 1회성으로만 mapping 하도록 한다 
                     * replan 과 개별 event mapping 시에는 partial bkg 모두에 대해서 mapping 되지만 이전 발생 event에 대해서는
                     * 자동 mapping이 되지 않기 때문이다. */
                    if(insertCnt==0){
                        insertCnt =  dbDao.copySceActRcvIfByOneTime(sceCopHdrVO, oldBkgList, "CrtBy1TimeCmbn");
                        log.info("\n[poong] copySceActRcvIfByOneTime insertCnt="+insertCnt);
                    }
                }
	        }
			
			interfaceLeaCntrBkgHis(org_bkg_no, new String[] {combined_bkg_no});
			
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	/**
	 * @param org_bkg_no
	 * @param new_bkg_no
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#splitBkg(java.lang.String, java.lang.String[])
	 */
	public void splitBkg(String org_bkg_no, String[] new_bkg_no) throws EventException {
		splitBkg(org_bkg_no, new_bkg_no, new String[] {});
	}
	/**
	 * 2010.08.18 : split 시 COP 의 BKG_NO 가 변경될 경우 이전 / 이후 bkg_no 로 SCE_TRO_MAPG 의 BKG_NO 를 변경하여 준다.
	 * 				또한 기 발생된 OD/S 포함 모든 bkg 의 BKG_NO / BL_NO 역시 변경시킨다.
	 * @param org_bkg_no
	 * @param new_bkg_no
	 * @param mapg_seq
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#splitBkg(java.lang.String, java.lang.String[], java.lang.String[])
	 */
	public void splitBkg(String org_bkg_no, String[] new_bkg_no, String[] mapg_seq) throws EventException {
	    log.info("\n[poong] splitBkg start");
	    log.info("\n[poong] splitBkg org_bkg_no="+org_bkg_no+"/new_bkg_no="+new_bkg_no);
		try {
			// split 되는 case 의 작업 내역을 조회한다.
			// C CREATION
			// X CANCEL
			// N NO CHANGE
			// P PRD CHANGE
			// B BKG NO CHANGE

			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(org_bkg_no);
			tmp.setBkgEvntTpCd("SP");
			tmp.setBkgEvntRmk("Booking Split : org_bkg_no = " + org_bkg_no + " / new_bkg_no = " + transArrayIntoString(new_bkg_no) + " / mapg_seq = " + transArrayIntoString(mapg_seq));
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);
			
			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), org_bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), transArrayIntoString(new_bkg_no));

			List<PrdBkgCopMapVO> prdBkgCopMapVOs = dbDao.searchPrdMap(new_bkg_no, mapg_seq); // memo split 일 경우에도 map 에는 new_bkg_no 만 존재한다.
			
			List<SceCopHdrVO> toBeUpdCopHdrList = new ArrayList<SceCopHdrVO>();
			
			List<TrsTrspSvcOrdVO> toBeSoUpdList = new ArrayList<TrsTrspSvcOrdVO>();

			List<SceTroMapgVO> toBeTroMapgList = new ArrayList<SceTroMapgVO>();
			
			BkgBookingVO orgVO = dbDao.searchBkgBooking(org_bkg_no);
			
			List <SceCopHdrVO> bfPrtlList = new ArrayList<SceCopHdrVO>();
			List <SceCopHdrVO> copyActRcvIfList = new ArrayList<SceCopHdrVO>();
			
			if (orgVO.getSplitRsnCd() != null && orgVO.getSplitRsnCd().equals("M")) { // memo split 의 경우 split 되기 전 COP 의 정보를 cancel 한 상태로 생성 해 놓는다.					
				copyCop(org_bkg_no, "X", "memo-split");
			}

			/* Split되면서 Partial CNTR의 Master Cop가 변경되었을때 이전 Bkg로 발생된 Actual Event를 변경된 Master Bkg로 복사하기 위해서*/
			/* Split이 진행되면서 original cop에서 CNTR 번호가 Detach 되면 관련된 org bkg 와 partial된 bkg list를 찾을수 없으므로 split을 진행하기 전에 list를 조회한다. */
			for(int i=0; i < prdBkgCopMapVOs.size(); i++){
			    PrdBkgCopMapVO prdBkgCopMap = (PrdBkgCopMapVO) prdBkgCopMapVOs.get(i);
                
                if(org_bkg_no.equals(prdBkgCopMap.getBkgNo())){ /* org bkg의 partial bkg만 조회하면 된다. */
                    List <SceCopHdrVO> tmpList = dbDao.searchPartialBkgBfBkgSplit(prdBkgCopMap);
                    if(tmpList != null && tmpList.size()>0){
                        bfPrtlList.addAll(tmpList);
                    }else{ /* 신규 생성 COP라면 조회가 불가능하므로 Map에서 조회한 정보를 그대로 list로 추가 */
                        SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
                        sceCopHdrVO.setCopNo(prdBkgCopMap.getCopNo());
                        sceCopHdrVO.setBkgNo(prdBkgCopMap.getBkgNo());
                        bfPrtlList.add(sceCopHdrVO);
                    }
                }
                
                /* Actual Event를 복사할 new bkg list 를 추가한다. */
                if(!org_bkg_no.equals(prdBkgCopMap.getBkgNo()) && !SCEConstants.PSEUDO_CNTR_NO.equals(prdBkgCopMap.getCntrNo()) && prdBkgCopMap.getCntrNo() != null ){
                    SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
                    sceCopHdrVO.setBkgNo(prdBkgCopMap.getBkgNo());
                    sceCopHdrVO.setCopNo(prdBkgCopMap.getCopNo());
                    sceCopHdrVO.setCntrNo(prdBkgCopMap.getCntrNo());
                    
                    log.info("\n[poong] sceCopHdrVO="+sceCopHdrVO);
                    copyActRcvIfList.add(sceCopHdrVO);
                }
            }
			log.info("\n[poong] bfPrtlList="+bfPrtlList);
			log.info("\n[poong] copyActRcvIfList="+copyActRcvIfList);
			
			for (int i = 0; i < prdBkgCopMapVOs.size(); i ++) {
				
				PrdBkgCopMapVO prdBkgCopMapVO = prdBkgCopMapVOs.get(i);
				String cop_op_tp_cd = prdBkgCopMapVO.getCopOpTpCd();
				
				String cntr_tpsz_cd = prdBkgCopMapVO.getCntrTpszCd();
				
				BkgBookingVO bkgVO = dbDao.searchBkgBooking(prdBkgCopMapVO.getBkgNo());
				String bl_no = bkgVO.getBlNo();
				log.info("\n[poong] splitBkg cop_op_tp_cd="+cop_op_tp_cd);
				if (cop_op_tp_cd.equals(SCEConstants.CREATION_FRM_MAP)) {
					if (prdBkgCopMapVO.getCntrTpszCd() != null && prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
						continue;
					}
					
//					[PRD] Actual Dwell Time 적용 SKD
					dbDao.callPrdSetActDwTimePrc(prdBkgCopMapVO.getPctlNo(), "I", "N", "SYS");
					
					List<SceCopHdrVO> tobeCrtCopHdrList = dbDao.searchCopHdrToBeCreated(prdBkgCopMapVO.getBkgNo(), prdBkgCopMapVO.getCntrNo(), 
							prdBkgCopMapVO.getCntrTpszCd(), prdBkgCopMapVO.getPctlNo(), prdBkgCopMapVO.getCopNo());
					
					if (tobeCrtCopHdrList.size() != 0) {
						replanManageBC.createNewCop(tobeCrtCopHdrList);
					}
					
					for (int j = 0; j < tobeCrtCopHdrList.size(); j ++) {
						SceCopHdrVO tmpVO = tobeCrtCopHdrList.get(j);
						
						SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
						sceCopHdrVO.setCopNo(tmpVO.getCopNo());
						sceCopHdrVO.setBkgNo(tmpVO.getBkgNo());
						sceCopHdrVO.setCntrNo(tmpVO.getCntrNo());
						sceCopHdrVO.setCopUpdRmk("SplitBkg:NewCOPCrt");
						
						dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), "CC", "SysBkg", "SysBkg", "Y");
						
						toBeUpdCopHdrList.add(sceCopHdrVO);
					}
					
				} else if (cop_op_tp_cd.equals(SCEConstants.CANCEL_FRM_MAP)) {
					boolean isSkipNeed = false;
					// 마지막 event 가 아니고 다음 event 이후에 동일한 COP 로 BKG No Update event 가 존재한다면 cancel 작업을 skip 한다.
					if (i != prdBkgCopMapVOs.size() - 1) {
						for (int j = i + 1 ; j < prdBkgCopMapVOs.size(); j ++) {
							PrdBkgCopMapVO rowVO = prdBkgCopMapVOs.get(j);
							if (rowVO.getCopNo().equals(prdBkgCopMapVO.getCopNo()) && rowVO.getCopOpTpCd().equals(SCEConstants.BKG_NO_CHANGE_FRM_MAP)) {
								isSkipNeed = true;
								break;
							}
						}
					}
					
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();	
					sceCopHdrVO.setCopNo(prdBkgCopMapVO.getCopNo());
					sceCopHdrVO.setCntrNo(prdBkgCopMapVO.getCntrNo());
					sceCopHdrVO.setBkgNo(prdBkgCopMapVO.getBkgNo());
					if (isSkipNeed) {
						sceCopHdrVO.setCopUpdRmk("SplitBkg:CnclSkip");
						toBeUpdCopHdrList.add(sceCopHdrVO);
						continue;
					}
									
					sceCopHdrVO.setCopStsCd("X");
					sceCopHdrVO.setCopUpdRmk("SplitBkg:Cncl");
					
					dbUtilDao.addSceCopHistory(sceCopHdrVO.getCopNo(), "CN", "SysCop", "SysCelCop", "Y");
					
					toBeUpdCopHdrList.add(sceCopHdrVO);
				} else if (cop_op_tp_cd.equals(SCEConstants.NO_CHANGE_FRM_MAP)) {
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(prdBkgCopMapVO.getCopNo());
	                sceCopHdrVO.setCntrNo(prdBkgCopMapVO.getCntrNo());
	                sceCopHdrVO.setBkgNo(prdBkgCopMapVO.getBkgNo());
					sceCopHdrVO.setCntrTpszCd(cntr_tpsz_cd); // 2010-05-02 container tpsz 를 map 에 들어온 대로 update
					
					if (cntr_tpsz_cd.startsWith("Q")) {
						sceCopHdrVO.setCopStsCd("X");
						sceCopHdrVO.setCopUpdRmk("SplitBkg:NoChg:Cncl Q tp");
					} else {
						sceCopHdrVO.setCopUpdRmk("SplitBkg:NoChg");
					}
					
					toBeUpdCopHdrList.add(sceCopHdrVO);
					
				} else if (cop_op_tp_cd.equals(SCEConstants.PRD_CHANGE_FRM_MAP)) {
					if (prdBkgCopMapVO.getCntrTpszCd() != null && prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
						continue;
					}
					
//					[PRD] Actual Dwell Time 적용 SKD
					dbDao.callPrdSetActDwTimePrc(prdBkgCopMapVO.getPctlNo(), "I", "N", "SYS"); // bkg 요청으로 commit 하지 않기로 함
					
					//replan
					replanManageBC.replanCopByPrdMap(prdBkgCopMapVO);
					
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(prdBkgCopMapVO.getCopNo());
					sceCopHdrVO.setCntrNo(prdBkgCopMapVO.getCntrNo());
	                sceCopHdrVO.setBkgNo(prdBkgCopMapVO.getBkgNo());
					sceCopHdrVO.setCopUpdRmk("SplitBkg:Rpln = " + prdBkgCopMapVO.getPctlNo());
					
					toBeUpdCopHdrList.add(sceCopHdrVO);
					
				} else if (cop_op_tp_cd.equals(SCEConstants.BKG_NO_CHANGE_FRM_MAP)) {
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(prdBkgCopMapVO.getCopNo());
					sceCopHdrVO.setBkgNo(prdBkgCopMapVO.getBkgNo());
					sceCopHdrVO.setCntrTpszCd(cntr_tpsz_cd); // 2010-05-02 container tpsz 를 map 에 들어온 대로 update 
					if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
						sceCopHdrVO.setCopStsCd("X");
						sceCopHdrVO.setCopUpdRmk("SplitBkg:BkgNoChg:Cncl Q tpsz");						
					} else {
						sceCopHdrVO.setCopUpdRmk("SplitBkg:BkgNoChg");
					}
					
//					// sce_tro_mapg 의 bkg_no 역시 변경 시켜 준다.
					SceTroMapgVO sceTroMapgVO = new SceTroMapgVO();
					sceTroMapgVO.setCopNo(sceCopHdrVO.getCopNo());
					sceTroMapgVO.setBkgNo(prdBkgCopMapVO.getBkgNo());
					toBeTroMapgList.add(sceTroMapgVO);
					
					TrsTrspSvcOrdVO toBeSoUpdVO = new TrsTrspSvcOrdVO();
					toBeSoUpdVO.setCopNo(sceCopHdrVO.getCopNo());
					toBeSoUpdVO.setBkgNo(sceCopHdrVO.getBkgNo());
					toBeSoUpdVO.setBlNo(bl_no);
					toBeSoUpdList.add(toBeSoUpdVO);
									
					sceCopHdrVO.setCntrNo(prdBkgCopMapVO.getCntrNo());
                    toBeUpdCopHdrList.add(sceCopHdrVO);
					
					dbDao.modifyCopDtlForActReMap(prdBkgCopMapVO.getCopNo());
					
					log.info("\n[poong] sceCopHdrVO="+sceCopHdrVO);
					copyActRcvIfList.add(sceCopHdrVO);
//					toBeEdiSentList.add(sceCopHdrVO);
				}
			}
			
			if (toBeUpdCopHdrList.size() != 0) {
				dbDao.modifyCopHdr(toBeUpdCopHdrList);
			}
			
			/* new bkg list 에 대해서 Actual Evnet를 copy 한다.*/
			int insertCnt = 0 ;
			for(int i=0; i < copyActRcvIfList.size(); i++){
			    SceCopHdrVO sceCopHdrVO = (SceCopHdrVO) copyActRcvIfList.get(i);
			    if(bfPrtlList != null && bfPrtlList.size() > 0 ){
			        insertCnt = dbDao.copySceActRcvIfBySplit(sceCopHdrVO, bfPrtlList, "CrtBySplit");
			        log.info("\n[poong] copySceActRcvIfBySplit insertCnt="+insertCnt);
			        /* copy 하지 못했다는 의미는 partial bkg중 하나에 대해 actual 정보가 존재한다는 의미다 
                     * 이경우 new bkg에 대해 actual 정보가 존재하는 경우가 아니면 1회성으로만 mapping 하도록 한다 
                     * replan 과 개별 event mapping 시에는 partial bkg 모두에 대해서 mapping 되지만 이전 발생 event에 대해서는
                     * 자동 mapping이 되지 않기 때문이다. */
			        if(insertCnt==0){
			            insertCnt =  dbDao.copySceActRcvIfByOneTime(sceCopHdrVO, bfPrtlList, "CrtBy1TimeSplt");
			            log.info("\n[poong] copySceActRcvIfByOneTime insertCnt="+insertCnt);
			        }
			        
			    }
			}


			
			if (toBeSoUpdList.size() != 0) {
				dbDao.modifyRailBilOrdBkgNoInclODSO(toBeSoUpdList);
				dbDao.modifySvcOrdBkgNoInclODSO(toBeSoUpdList);
			}
			
			if (toBeTroMapgList.size() != 0) {
				dbDao.modifyTroMapgByCop(toBeTroMapgList);
			}
			
			interfaceLeaCntrBkgHis(new String[] {org_bkg_no}, new_bkg_no);
			
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	
	
	/**
	 * @param bkgNoSet
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#interfaceMasDailyBtch(java.util.Set)
	 */
	public void interfaceCoaDailyBtch(Set<String> bkgNoSet) throws EventException {
		try {
			dbDao.mergeCoaCopIfMgmt(bkgNoSet);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * @param org_bkg_no
	 * @param new_bkg_no
	 * @throws DAOException
	 */
	private void interfaceLeaCntrBkgHis(String[] org_bkg_no, String[] new_bkg_no) throws DAOException {
		for (int i = 0; i < org_bkg_no.length; i ++) {
			BkgBookingVO oldBkgVO = dbDao.searchBkgBooking(org_bkg_no[i]);
			
			for (int j = 0; j < new_bkg_no.length; j ++){
				BkgBookingVO newBkgVO = dbDao.searchBkgBooking(new_bkg_no[j]);
				List<BkgContainerVO> bkgCntrList = dbDao.searchBkgContainer(new_bkg_no[j]);
				for (int k = 0; k < bkgCntrList.size(); k++) {
					BkgContainerVO tmpCntrVO = bkgCntrList.get(k);
					String cntr_no = tmpCntrVO.getCntrNo();
					
					int valCnt = dbDao.validateLeaCntrBkgHis(new_bkg_no[j], cntr_no);
					
					if (valCnt > 0) // 해당 history 가 존재할 경우 lea_cntr_bkg_his 에 insert skip
						continue;

					log.info("LEA_BKG_CNTR_HIS_PRC STATRTS!! : bkg_no = " + new_bkg_no[j] + " / cntr_no = " + cntr_no + " / cntr_no = " + cntr_no);
					
					LeaCntrBkgHisVO leaCntrBkgHisVO = new LeaCntrBkgHisVO();
					leaCntrBkgHisVO.setBkgNo(new_bkg_no[j]);
					leaCntrBkgHisVO.setBkgStsCd(newBkgVO.getBkgStsCd());
					leaCntrBkgHisVO.setCntrNo(cntr_no);
					leaCntrBkgHisVO.setOldBkgNo(org_bkg_no[i]);
					leaCntrBkgHisVO.setOldBkgStsCd(oldBkgVO.getBkgStsCd());
					
					dbDao.addLeaCntrBkgHis(leaCntrBkgHisVO);
					
					List<SceCopHdrVO> sceCopHdrList = dbDao.searchPrivBkgCntr(new_bkg_no[j], cntr_no);
					
					if (sceCopHdrList.size() > 0) {
						SceCopHdrVO tmpVO = sceCopHdrList.get(0);
						String priv_bkg_no = tmpVO.getBkgNo();
						String priv_cop_sts_cd = tmpVO.getCopStsCd();
						
						if (priv_cop_sts_cd != null && priv_cop_sts_cd.equals("F")) {
							dbDao.modifyLeaCntrBkgHis(priv_bkg_no, cntr_no, priv_cop_sts_cd);
						}
					}
					
					
					log.info("LEA_BKG_CNTR_HIS_PRC ENDS!!");	
				}
			}
		}
	}
	
	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @throws DAOException
	 */
	private void interfaceLeaCntrBkgHis(String bkg_no, String cntr_no) throws DAOException {
		BkgBookingVO bkgVO = dbDao.searchBkgBooking(bkg_no);
		
		int valCnt = dbDao.validateLeaCntrBkgHis(bkg_no, cntr_no);
		
		if (valCnt > 0) // 해당 history 가 존재할 경우 lea_cntr_bkg_his 에 insert skip
			return;

		log.info("LEA_BKG_CNTR_HIS_PRC STATRTS!! : bkg_no = " + bkg_no + " / cntr_no = " + cntr_no + " / cntr_no = " + cntr_no);
		
		LeaCntrBkgHisVO leaCntrBkgHisVO = new LeaCntrBkgHisVO();
		leaCntrBkgHisVO.setBkgNo(bkg_no);
		leaCntrBkgHisVO.setBkgStsCd(bkgVO.getBkgStsCd());
		leaCntrBkgHisVO.setCntrNo(cntr_no);
		
		dbDao.addLeaCntrBkgHis(leaCntrBkgHisVO);
		
		List<SceCopHdrVO> sceCopHdrList = dbDao.searchPrivBkgCntr(bkg_no, cntr_no);
		
		if (sceCopHdrList.size() > 0) {
			SceCopHdrVO tmpVO = sceCopHdrList.get(0);
			String priv_bkg_no = tmpVO.getBkgNo();
			String priv_cop_sts_cd = tmpVO.getCopStsCd();
			
			if (priv_cop_sts_cd != null && priv_cop_sts_cd.equals("F")) {
				dbDao.modifyLeaCntrBkgHis(priv_bkg_no, cntr_no, priv_cop_sts_cd);
			}
		}
		log.info("LEA_BKG_CNTR_HIS_PRC ENDS!!");	
	}
	
	/**
	 * @param org_bkg_no
	 * @param dest_bkg_no
	 * @param cntr_no
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#moveCntr(java.lang.String, java.lang.String[], java.lang.String)
	 */
	public void moveCntr(String org_bkg_no, String[] dest_bkg_no, String cntr_no) throws EventException {
	    log.info("\n[poong] moveCntr org_bkg_no="+org_bkg_no+"/cntr_no="+cntr_no);
	    for(int i=0; dest_bkg_no != null && i<dest_bkg_no.length; i++){
	        log.info("\n[poong] moveCntr dest_bkg_no["+i+"]="+dest_bkg_no[i]);
	    }
	    
	    
		try {
			String prtl_flg =  (dest_bkg_no!=null && dest_bkg_no.length > 1 ? "Y" : "N"); // 하나의 cntr 을 여러 bkg 으로 나누면 일단 partial 로 본다.  
			// partial --> partial 로 옮겨가는 경우도 있으므로 mst_cop_no 정리를 위해 partial flag 를 재 점검 해야 하낟.
			if (prtl_flg.equals("N")) {
				List<SceCopHdrVO> sceCopHdrList = dbDao.searchPartialCops(org_bkg_no, cntr_no, "C");
				if (sceCopHdrList != null && sceCopHdrList.size() > 1)
					prtl_flg = "Y";
			}
			
			SceBkgOpHisVO tmp = new SceBkgOpHisVO();
			tmp.setBkgNo(org_bkg_no);
			tmp.setCntrNo(cntr_no);
			tmp.setBkgEvntTpCd("MC"); // move container
			
			tmp.setBkgEvntRmk("Container Move : Origin = " + org_bkg_no + " / Dest = " + transArrayIntoString(dest_bkg_no) + " / cntr_no = " + cntr_no + " / partial = " + prtl_flg);
			// tmp.setPctlNo(pctl_no);
			SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);
			
			int rowNum = 1;
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), org_bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), dest_bkg_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), cntr_no);
			addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), prtl_flg);
					
			// detach 이전 원 cop 정보를 가져온다.
			List<SceCopHdrVO> orgCopList = dbDao.searchCopHdr(org_bkg_no, cntr_no);
			
			SceCopHdrVO oldCop = new SceCopHdrVO();
			if (orgCopList != null && orgCopList.size() > 0) {
				oldCop = orgCopList.get(0);
			} else {
				
			}
			List<ScePlnSoListVO> orgPlnList = dbDao.searchPlnSoList(oldCop.getCopNo());
			
			//attach cntr 와 detach cntr 를 차례로 호출
			SceCopHdrVO changedMst = detachCntrMain(org_bkg_no, cntr_no, prtl_flg) ;
			
			// S/O 가 없는 Master 가 detach 되어 master cop 가 변경되었을 경우 (Move 작업으로 만 발생할 수 있음)
//			List<TrsTrspSvcOrdVO> svcList = new ArrayList<TrsTrspSvcOrdVO> ();
//			List<TrsTrspRailBilOrdVO> railList = new ArrayList<TrsTrspRailBilOrdVO> ();
			
			for (int i = 0; dest_bkg_no != null && i < dest_bkg_no.length; i ++) {
				attachCntrMain(dest_bkg_no[i], cntr_no, prtl_flg);
				interfaceLeaCntrBkgHis(dest_bkg_no[i], cntr_no);
			}
			
			// null 이 아닌 경우는 다른 partial 로 S/O 가 이동되었으므로 S/O 재이동이 필요 없음. null 은 partial 이 없다는 것으로 기존
			// null 일 경우는 S/O 가 없어질 위험이므로 기 조회된 S/O 의 bkg_no, bl_no, cop_no 를  새로 master 가 된 COP 의 정보로 변경해야 한다.
			if (changedMst == null) { 
				
				// dest_bkg_no 가 여러개 이더라도 partial 로 갔을 때 master 는 하나이므로 for 로 순환문 돌릴 필요가 없음
				List<SceCopHdrVO> bfCopList = dbDao.searchMstCopByBkgs(dest_bkg_no, cntr_no);
				if (bfCopList != null && bfCopList.size() > 0) {
					SceCopHdrVO mstCop = bfCopList.get(0);
					
					TrsTrspSvcOrdVO newSo = new TrsTrspSvcOrdVO();
					BkgBookingVO bkgVO = dbDao.searchBkgBooking(mstCop.getBkgNo());
					newSo.setBkgNo(mstCop.getBkgNo());
					newSo.setBlNo(bkgVO.getBlNo());
					newSo.setCopNo(mstCop.getCopNo());
					
					// SO 정리작업					
					// 2010.08.31 수정 : OD-SO 는 옮기지 않고 기존 SO 만 옮긴다.
					dbDao.modifySvcOrdByMvCntr(newSo, oldCop);
					dbDao.modifyRailBilOrdByMvCntr(newSo, oldCop);
					
					// detach 된 COP 와 attach 된 master cop 가 서로 route 가 상이할 경우  replan
					if (dbDao.searchDiffRoute(oldCop.getCopNo(), mstCop.getCopNo())) {
						String pctl_no = prdBC.createSceSoReplan(mstCop.getCopNo(), "T", "MvCntr");
						if (pctl_no != null && !pctl_no.equals("")) {
							mstCop.setPctlNo(pctl_no);
							mstCop.setCopUpdRmk("MvCntr:Rpln pctl_no=" + pctl_no);
							
							replanManageBC.replanCop(mstCop, "MvCntr");
						}
					} 
					// TRSP_SO_STS_CD 를 기존의 값으로 유지 
					List<ScePlnSoListVO> toBePlnSoList = dbDao.searchPlnSoList(mstCop.getCopNo());
					List<ScePlnSoListVO> toBeUpdatedVO = new ArrayList<ScePlnSoListVO> ();
					// TRSP_SO_STS_CD 와 CTRL_OFC_CD 를 기존의 값으로 유지
					for (int i = 0 ; i < toBePlnSoList.size(); i ++) {
						ScePlnSoListVO toBeRowVO = toBePlnSoList.get(i);
						
						for (int j = 0 ; j < orgPlnList.size(); j ++) {
							ScePlnSoListVO toBeSoVO = new ScePlnSoListVO();
							
							ScePlnSoListVO crntRowVO = orgPlnList.get(j);
							if (crntRowVO.getCostActGrpSeq().equals(toBeRowVO.getCostActGrpSeq()) ) {
								// so 가 발생한 cop 의 cost_act_grp_seq 에 대해서 so status 를 변경
								if (crntRowVO.getTrspSoStsCd() != null && !crntRowVO.getTrspSoStsCd().equals("") && !crntRowVO.getTrspSoStsCd().equals("P"))						
									toBeRowVO.setTrspSoStsCd (crntRowVO.getTrspSoStsCd());
//									toBeRowVO.setCreUsrId(crntRowVO.getCreUsrId());
//									toBeRowVO.setCreDt(crntRowVO.getCreDt());
								toBeSoVO.setCopNo(toBeRowVO.getCopNo());
								toBeSoVO.setCostActGrpSeq(toBeRowVO.getCostActGrpSeq());
								toBeSoVO.setTrspSoStsCd(toBeRowVO.getTrspSoStsCd());
								
								toBeUpdatedVO.add(toBeSoVO);
							}
							
							if (crntRowVO.getTrspSoStsCd() != null && !crntRowVO.getTrspSoStsCd().equals(SCEConstants.SO_PLANNED)) {
								toBeSoVO = new ScePlnSoListVO();
								toBeSoVO.setCopNo(crntRowVO.getCopNo());
								toBeSoVO.setCostActGrpSeq(crntRowVO.getCostActGrpSeq());
								toBeSoVO.setTrspSoStsCd(SCEConstants.SO_PLANNED);
							}
							toBeUpdatedVO.add(toBeSoVO);							
							
						}
					}
					if (toBeUpdatedVO.size() > 0)
						dbDao.modifySoStsByMvCntr(toBeUpdatedVO);
				}
			}
			log.info("\n[poong] moveCntr end");
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return SearchCopVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchCopNoFrmPrdByTro(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public SearchCopVO searchCopNoFrmPrdByTro(String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String area_conti_cd) throws EventException {
		List<SearchCopVO> searchCopVOs = new ArrayList<SearchCopVO> ();
		
		SearchCopVO rtnVO = null;
		try {
		
			if (io_bnd_cd.equals("I")) {
				searchCopVOs = dbDao.searchIBCop(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, area_conti_cd);
				
				if (searchCopVOs == null || searchCopVOs.size() == 0) {
					throw new EventException(new ErrorHandler("SCE00050").getMessage());
				}
				
				rtnVO = searchCopVOs.get(0);
			} else if (io_bnd_cd.equals("O")) {
				String mst_bkg_no = "";
				searchCopVOs = dbDao.searchOBCop(bkg_no, tro_seq, tro_sub_seq, io_bnd_cd, area_conti_cd);
				
				for (int i = 0; i < searchCopVOs.size(); i ++) {
					SearchCopVO tmpVO = searchCopVOs.get(i);
					mst_bkg_no = tmpVO.getMstBkgNo();
					if (tmpVO.getMstFlg() != null && tmpVO.getMstFlg().equals("Y")) {
						rtnVO = searchCopVOs.get(0);
						break;
					} 
					// vo 를 다 돌아서 master 인게 없으면 오류 발생
				}
				
				if (searchCopVOs.size() > 0 && rtnVO == null) {
					throw new EventException((String)new ErrorHandler("SCE00051", new String[]{tro_seq, tro_sub_seq, mst_bkg_no}).getMessage());
				}
			}
			
			if (searchCopVOs == null || searchCopVOs.size() == 0) {
				throw new EventException(new ErrorHandler("SCE00050").getMessage());
			}
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
		
		return rtnVO;
	}
	
	
	/**
	 * VVD 변경시 VCL EDI EVNET 발송
	 * @param updBkgForVVDChgVO
	 * @throws EventException
	 */
	public void updateBkgForVVDChange(UpdBkgForVVDChgVO updBkgForVVDChgVO) throws EventException {
	    log.info("\n[poong] updateBkgForVVDChange updBkgForVVDChgVO="+updBkgForVVDChgVO);
		try {
			dbDao.addSceEdiHisForVCL(updBkgForVVDChgVO);
		}  catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * BKG COD시 SCE COD 데이터 생성
	 * @param updBkgForBkgCodVO
	 * @throws EventException
	 */
	public void updateBkgForBkgCod(UpdBkgForBkgCodVO updBkgForBkgCodVO) throws EventException {
	    log.info("\n updateBkgForBkgCOD updBkgForBkgCodVO="+updBkgForBkgCodVO);
		try {
			dbDao.addSceCodHisForBkgCod(updBkgForBkgCodVO);
		}  catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
	}
	
	
	/**
	 * @param prdBkgCopMapVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#updateBkg(com.hanjin.syscommon.common.table.PrdBkgCopMapVO)
	 */
	public void updateBkg(PrdBkgCopMapVO prdBkgCopMapVO) throws EventException {
	    log.info("\n[poong] updateBkg prdBkgCopMapVO="+prdBkgCopMapVO);
		replanManageBC.replanCopByPrdMap(prdBkgCopMapVO);
	}
	
	/**
	 * @param bkg_no
	 * @param mapg_seq
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#updateBkg(java.lang.String, java.lang.String)
	 */
	public void updateBkg(String bkg_no, String mapg_seq) throws EventException {
		log.info("\n[poong] updateBkg bkg_no="+bkg_no+"/mapg_seq="+mapg_seq);
		
		boolean backEndFlg = false;
		SceBkgOpHisVO tmp = new SceBkgOpHisVO();
		tmp.setBkgNo(bkg_no);
		tmp.setBkgEvntTpCd("UR"); // Update Bkg
		tmp.setBkgEvntRmk("Update Bkg : bkg_no = " + bkg_no + " / mapg_seq = " + mapg_seq);
		// tmp.setPctlNo(pctl_no);
		SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);
		
		int rowNum = 1;
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), mapg_seq);
		
		List<Search315VEToBeSentVO> veList = null;
		String [] pctlNoArray = null;
		
		try {

			List<PrdBkgCopMapVO> prdBkgCopMapVOList = dbDao.searchPrdMap(new String[]{bkg_no}, new String[]{mapg_seq});
			List<String> rplnCopList = new ArrayList<String> ();
			
			//back end job으로 actual mapping + vip 315 를 실행할지  여부를 조회한다. COP DTL 삭제 전에 조회해야한다.
			backEndFlg = dbDao.checkExecBackEndJob(bkg_no);
			
			for (int i = 0; i < prdBkgCopMapVOList.size(); i ++) {
				
				PrdBkgCopMapVO prdBkgCopMapVO = prdBkgCopMapVOList.get(i);

				String tgt_bkg_no = prdBkgCopMapVO.getBkgNo();
				String pctl_no = prdBkgCopMapVO.getPctlNo();
				String cop_no = prdBkgCopMapVO.getCopNo();
				String cntr_no = prdBkgCopMapVO.getCntrNo();
				String cntr_tpsz_cd = prdBkgCopMapVO.getCntrTpszCd();
				String cop_op_tp_cd = prdBkgCopMapVO.getCopOpTpCd();
				
				// 수정 대상이 될 table list
				List<SceCopHdrVO> toBeUpdtCopList = new ArrayList<SceCopHdrVO> ();
				List<SceTroMapgVO> toBeUpdtTroMapgList = new ArrayList<SceTroMapgVO> ();
							
//				if (!cop_op_tp_cd.equals(SCEConstants.CREATION_FRM_MAP)) {
//					boolean rslt = dbDao.checkCopToBeCanceled(cop_no);
//					if (rslt) {
//						if (moveTroInfo(cop_no, SCEConstants.CANCEL_FRM_MAP)) {
//							cop_op_tp_cd = SCEConstants.CANCEL_FRM_MAP;	
//						}
//					}	
//				}
				
				
				if (cop_op_tp_cd.equals(SCEConstants.PRD_CHANGE_FRM_MAP) || cop_op_tp_cd.equals(SCEConstants.PSEUDO_VVD_UPDATE_FRM_MAP)) {
//					[PRD] Actual Dwell Time 적용 SKD
					
					// 동일 BKG에 대해 PCTL NO가 중복되는 경우 Dwell Time을 계산할 필요가 없다. 
					if(!isPctlNoContains(pctlNoArray, pctl_no)){
						dbDao.callPrdSetActDwTimePrc(pctl_no, "I", "N", "SYS");
						pctlNoArray = addPctlNos(pctlNoArray, pctl_no);		
//						for(String pctlNo : pctlNoArray){
//							log.info("poong isPctlNoContains END pctlNoArray:"+pctlNo);
//						}
					}
					
					// PCTL_NO 를 변경하여 REPLAN 수행				
					replanManageBC.replanCopByPrdMap(prdBkgCopMapVO);
					
					if (prdBkgCopMapVO.getCntrNo() != null && !prdBkgCopMapVO.getCntrNo().equals("") && !prdBkgCopMapVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))
						rplnCopList.add(prdBkgCopMapVO.getCopNo());

				} else if (cop_op_tp_cd.equals(SCEConstants.CREATION_FRM_MAP)) {
					if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
						continue;
					}
					
					if(!isPctlNoContains(pctlNoArray, pctl_no)){
//						[PRD] Actual Dwell Time 적용 SKD
						dbDao.callPrdSetActDwTimePrc(pctl_no, "I", "Y", "SYS");
						pctlNoArray = addPctlNos(pctlNoArray, pctl_no);
					}
					
					// cop no 를 부여하여 신규 COP 를 생성 
					List<SceCopHdrVO> toBeCrtHdrList = dbDao.searchCopHdrToBeCreated(tgt_bkg_no, cntr_no, cntr_tpsz_cd, pctl_no, cop_no);
					addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), "Loop ="+ (i+1)+"/Creat Header start");
					replanManageBC.createNewCop(toBeCrtHdrList);
					addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), "Loop ="+ (i+1)+"/Created Header size="+toBeCrtHdrList.size());
					
					for (int j = 0; j < toBeCrtHdrList.size(); j ++) {
						SceCopHdrVO tmpVO = toBeCrtHdrList.get(j);
						
						SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
						sceCopHdrVO.setCopNo(tmpVO.getCopNo());
						sceCopHdrVO.setCopUpdRmk("UpdBkg:Crt:" + prdBkgCopMapVO.getPctlNo());
						
						dbUtilDao.addSceCopHistory(tmpVO.getCopNo(), "CC", "SysBkg", "SysBkg", "Y");
						
						toBeUpdtCopList.add(sceCopHdrVO);
					}
					
				} else if (cop_op_tp_cd.equals(SCEConstants.NO_CHANGE_FRM_MAP)) {
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(cop_no);
					if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
						sceCopHdrVO.setCopStsCd("X");
						sceCopHdrVO.setCopUpdRmk("UpdBkg:NoChg:Cncl Q tpsz");						
					} else {
						sceCopHdrVO.setCopUpdRmk("UpdBkg:NoChg");
					}
					toBeUpdtCopList.add(sceCopHdrVO);
					
				} else if (cop_op_tp_cd.equals(SCEConstants.BKG_NO_CHANGE_FRM_MAP)) {
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(cop_no);
					sceCopHdrVO.setBkgNo(bkg_no);

					sceCopHdrVO.setCopUpdRmk("UpdBkg:BkgNoChg");
					
					if (prdBkgCopMapVO.getCntrTpszCd().startsWith("Q")) {
						sceCopHdrVO.setCopStsCd("X");
						sceCopHdrVO.setCopUpdRmk("UpdBkg:BkgNoChg:Cncl Q tpsz");						
					} else {
						sceCopHdrVO.setCopUpdRmk("UpdBkg:BkgNoChg");
					}
					
					toBeUpdtCopList.add(sceCopHdrVO);
					
					SceTroMapgVO sceTroMapgVO = new SceTroMapgVO();
					sceTroMapgVO.setBkgNo(tgt_bkg_no);
					sceTroMapgVO.setCopNo(cop_no);
					
					toBeUpdtTroMapgList.add(sceTroMapgVO);
					
				} else if (cop_op_tp_cd.equals(SCEConstants.CANCEL_FRM_MAP)) {
					    moveTroInfo(cop_no, SCEConstants.CANCEL_FRM_MAP); // cancel 시킬 cop 가 tro 를 가지고 있다면 tro 이동을 시도한다. 만약 tro 이동이 불가하면 cancel 을 skip 한다.
						
						// cancel operation 호출 : 단 cop 한건만 cancel 한다. (추가작업)
						SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
						sceCopHdrVO.setCopNo(cop_no);
						sceCopHdrVO.setCopStsCd("X");
						
						sceCopHdrVO.setCopUpdRmk("UpdBkg:Cncl");
						toBeUpdtCopList.add(sceCopHdrVO);
						
						dbUtilDao.addSceCopHistory(sceCopHdrVO.getCopNo(), "CN", "SysCop", "SysCelCop", "Y");						
	
				} else if (cop_op_tp_cd.equals(SCEConstants.PC_CREATE_FAIL_FRM_MAP)) {
					// booking replan 시 COP 에 기 생성된 S/O 가 존재한다며 해당 S/O 의 route 가 booking replan 에서 변경된 POR, POL, POD, DEL 과
					// 다를 수 있다. 이때 다른 부분이 Bkg 별 COP 중 다수가 아니라면 해당 COP 의 PC 는 생성되지 않는다.
					// PRD_BKG_COP_MAP 에 pctl_no 가 존재하기는 하지만 이 것은 변경된 Route 를 포함하지 않는다.
					// 이에 PC 를 COP 별로 재 생성해서 replan 해야 한다.
					
					// S/O 생성을 위해 무조건 IRG 가 필요하게 됨에따라 하기 로직은 발생 안할 수도 있음
					SceCopHdrVO sceCopHdrVO = new SceCopHdrVO();
					sceCopHdrVO.setCopNo(cop_no);
					List<SceCopHdrVO> toBeReplnCopList = dbDao.searchCopHdr(sceCopHdrVO);
					
					if (toBeReplnCopList != null && toBeReplnCopList.size() > 0) {
						sceCopHdrVO = toBeReplnCopList.get(0);
					}
					
					String regen_pctl_no = prdBC.createSceSoReplanByBkgInfo(cop_no, "T", "BkgRpln");
					if (regen_pctl_no != null && !regen_pctl_no.equals("")) {
						SceCopHdrVO rplnVO = new SceCopHdrVO();
						rplnVO.setCopNo(cop_no);
						rplnVO.setPctlNo(regen_pctl_no);
						rplnVO.setBkgNo(bkg_no);
						rplnVO.setCopUpdRmk("UpdBkg:PC regen=" + pctl_no);	
						replanManageBC.replanCop(rplnVO, "UpdBkg(F)");
					} else {
						SceCopHdrVO rplnVO = new SceCopHdrVO();
						rplnVO.setCopNo(cop_no);
						rplnVO.setCopUpdRmk("UpdBkg(F):PC regen fail");
						
						toBeUpdtCopList.add(rplnVO);
					}
				}
//				else if (cop_op_tp_cd.equals(SCEConstants.PSEUDO_VVD_UPDATE_FRM_MAP)) {
//					// pseudo vvd 가 update 되는 case 는 3가지가 있음
//					// 1. booking main 에서 trunk vvd 를 pseudo 로 생성
//					// 2. booking main 에서 t/s vvd 를 pseudo vvd 로 수정
//					// 3. group vvd assign 에서 vvd 를 수정 : trunk 는 불가, t/s 만 수정
//					// 1,2 case 에서는 replan 을 수행하므로 다른 필요가 없고
//					// 3 case 에서는 'V' 로 prd_bkg_cop_map 에 row 가 생성되고 prd_prod_ctl_rout_dtl 에서 pseudo vvd
//					// 인 구간을 찾아 (from ~ to) cop detail 에 update 한다.
//				} 
				
				if (toBeUpdtTroMapgList.size() > 0)
					dbDao.modifyTroMapgByCop(toBeUpdtTroMapgList);
				
				if (toBeUpdtCopList.size() > 0) {
					dbDao.modifyCopHdr(toBeUpdtCopList);
				}
				if(i==prdBkgCopMapVOList.size()-1) {
					addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), "Map Loop end");
				}
			}
//			Back End Job 에서 실행 2011.09.28/poong
			if(backEndFlg){
				//back end job 으로 실행되야 할 경우
				BkgCopManageBackEndJobBCImpl backEndJobCommand = new BkgCopManageBackEndJobBCImpl(); 
				
				List<List> actualListArray = new ArrayList();
//				log.info("poong backendjop before loop start");
				for (int k = 0; k < rplnCopList.size(); k ++) {
					List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(rplnCopList.get(k));
					actualListArray.add(actualList);
//					for(SceActRcvIfVO actVo :actualList) {
////					log.info(k+":poong backendjop before="+actVo.getVslCd()+actVo.getSkdVoyNo()+actVo.getSkdDirCd());
//					}
				}
				veList = dbDao.search315VEToBeSent(bkg_no);
				
				((BkgCopManageBackEndJobBCImpl) backEndJobCommand).setBkgNo(bkg_no);
				((BkgCopManageBackEndJobBCImpl) backEndJobCommand).setRplnCopList(rplnCopList);
				((BkgCopManageBackEndJobBCImpl) backEndJobCommand).setActualListArray(actualListArray);
				((BkgCopManageBackEndJobBCImpl) backEndJobCommand).setVeList(veList);

				backEndJobCommand.doStart();
			}else{
				veList = dbDao.search315VEToBeSent(bkg_no);
				
				for (int k = 0; k < rplnCopList.size(); k ++) {
					List<SceActRcvIfVO> actualList = dbDao.searchActualToBeUpdated(rplnCopList.get(k));
	//				public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException METHOD 사용!
					for (int i = 0; i < actualList.size(); i ++) {
						SceActRcvIfVO actVO = actualList.get(i);
						copDetailReceiveBC.copDetailReceiveREPLAN(actVO);
					}
				}
				
				for (int i = 0; i < veList.size(); i ++) {
					Search315VEToBeSentVO veRow = veList.get(i);
					if (veRow.getSendEdi() != null && veRow.getSendEdi().equals("Y")) {
						Edi315SendVO edi315SendVO = new Edi315SendVO();
						edi315SendVO.setCntrNo(veRow.getCntrNo());
						edi315SendVO.setBkgNo(veRow.getBkgNo());
						edi315SendVO.setCopNo(veRow.getCopNo());
						edi315SendVO.setEdiStatus("VE");
						edi315SendVO.setCallFrom("COP");
						edi315SendVO.setCurrVvd(veRow.getVslCd() + veRow.getSkdVoyNo() + veRow.getSkdDirCd());
						edi315SendVO.setEventDt(veRow.getPcPodArrTime());
						edi315SendVO.setEventYard(veRow.getPcPod());
						edi315SendVO.setCreId("REP");
						edi315SendVO.setUpdId("REP");
						
						double starttime = System.currentTimeMillis();
						log.info("Start VE EDI 315 SEND!!! = " +  starttime);
						
						edi315BC.edi315Send(edi315SendVO);
						double endtime = System.currentTimeMillis();
						
						log.info("Start VE EDI 315 SEND!!! = " + endtime + " / elapse time = " + (endtime - starttime)  );
					}
				}
			}
			
		}  catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			throw new EventException(e.getMessage());
		}
		
	}
	
	/**
	 * @param bkg_no
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#confirmCntr(java.lang.String)
	 */
	public void confirmCntr (String bkg_no) throws EventException {
		SceBkgOpHisVO tmp = new SceBkgOpHisVO();
		tmp.setBkgNo(bkg_no);
		tmp.setBkgEvntTpCd("CF"); // Confirm Cntr
		tmp.setBkgEvntRmk("Contirm Cntr : bkg_no = " + bkg_no);
		// tmp.setPctlNo(pctl_no);
		SceBkgOpHisVO sceBkgOpHisVO = addBkgOpHis(tmp);
		
		int rowNum = 1;
		addBkgOpPara(sceBkgOpHisVO, new Integer(rowNum ++).toString(), bkg_no);
		
		try {
			BkgBookingVO bkgVO = dbDao.searchBkgBooking(bkg_no);
			if (bkgVO != null && bkgVO.getSplitRsnCd() != null && bkgVO.getSplitRsnCd().equals("M")) {
				return;
			}
			
			// 1. attach 되지 않은 cntr 의 attach / detach 되지 않은 cntr 의 detach
			List<SearchDiffCntrListVO> diffCntrList = dbDao.searchDiffCntrList(bkg_no);
			for (int i = 0; i < diffCntrList.size(); i ++) {
				SearchDiffCntrListVO rowVO = diffCntrList.get(i);
				if (rowVO.getBkgEvntTpCd().equals(SCEConstants.CONTAINER_ATTACH)) {
					List<SceCopHdrVO> rtnList = dbDao.searchPartialCops(rowVO.getBkgNo(), rowVO.getCntrNo(), "C");
					attachCntrMain(bkg_no, rowVO.getCntrNo(), rtnList.size() == 1 || rtnList.size() == 0 ? "N" : "Y" );
				} else if (rowVO.getBkgEvntTpCd().equals(SCEConstants.CONTAINER_DETACH)) {
					List<SceCopHdrVO> rtnList = dbDao.searchPartialCops(rowVO.getBkgNo(), rowVO.getCntrNo(), "C");
					detachCntrMain(bkg_no, rowVO.getCntrNo(), rtnList.size() == 1 || rtnList.size() == 0 ? "N" : "Y" );
				}
			}
			
			// 2. pseudo container 로 생성되어 있는 cop 의 정리
			// booking 은 실제 booking 의 qty 와 booking 당시의 qty 가 있고...
			// 두 qty 간에 관계는 없다.
			
			//	1. cop 정보 (SMCU0000000) 를 가져와 해당 cop 가 bkg_quantity - bkg_container 의 범위 내에 존재하는지 check
			//	2. 존재하지 않는 경우 cancel 대상이나.. odso 나 tro 가 confirm 되어 있는 경우는 일단 놔둔다..
			List<SceCopHdrVO> pseudoCntrCopList = dbDao.searchCopHdr(bkg_no, SCEConstants.PSEUDO_CNTR_NO);
			List<SearchDiffQtyListVO> diffList = dbDao.searchDiffQtyList(bkg_no);
			
			Map<String, Integer> tpszMap = new HashMap<String, Integer> ();
			
			int toBeCheckedCopCnt = 0;
			
			for (int j = 0; j < diffList.size(); j ++) {
				SearchDiffQtyListVO rowVO = diffList.get(j);
				int pseudo_qty = rowVO.getPseudoCnt() == null || rowVO.getPseudoCnt().equals("") ? 0 : new Integer(rowVO.getPseudoCnt()).intValue(); //pseudo cntr 가 달린 cop 개수
//				int attach_qty = rowVO.getAttachCnt() == null || rowVO.getAttachCnt().equals("") ? 0 : new Integer(rowVO.getAttachCnt()).intValue(); //container 가 달린 cop 개수
				int cntr_qty = rowVO.getCntrCnt() == null || rowVO.getCntrCnt().equals("") ? 0 : new Integer(rowVO.getCntrCnt()).intValue(); // bkg_container 의 tpsz 별 개수
				int qty = rowVO.getQty() == null || rowVO.getQty().equals("") ? 0 : new Integer(rowVO.getQty()).intValue(); // bkg_quantity 의 
				/**
				 * attach 된 cop 와 container 의 qty 가 같으면 pseudo_qty 는 모두 search 대상
				 *   
				 */
				if (qty >= cntr_qty ) {
					toBeCheckedCopCnt = qty - cntr_qty < 0 ? 0 : qty - cntr_qty;
					toBeCheckedCopCnt = pseudo_qty - toBeCheckedCopCnt < 0 ? 0 : pseudo_qty - toBeCheckedCopCnt;
				}
//				
//				if (qty == 0 && pseudo_qty != 0) { // bkg qty 에 아예 없는 tpsz 는 모두 cancel 시킬 대상
//					toBeCheckedCopCnt = pseudo_qty;
//				}
				if (toBeCheckedCopCnt != 0)
					tpszMap.put(rowVO.getCntrTpszCd(), new Integer(toBeCheckedCopCnt + ""));
			}
			if (tpszMap.size() != 0) {
				List<SceCopHdrVO> updList = new ArrayList<SceCopHdrVO> ();
				
				int tpszCnt = 0;
				
				for (int i = 0; i < pseudoCntrCopList.size(); i ++) {
					SceCopHdrVO tmpRow = new SceCopHdrVO();

					SceCopHdrVO sceCopHdrVO = pseudoCntrCopList.get(i);
					
					if (!tpszMap.containsKey(sceCopHdrVO.getCntrTpszCd()))
						continue;
					
					tpszCnt = new Integer(tpszMap.get(sceCopHdrVO.getCntrTpszCd())).intValue();

					if (sceCopHdrVO.getCntrNo() == null || (sceCopHdrVO.getCntrNo().equals("") || sceCopHdrVO.getCntrNo().equals(SCEConstants.PSEUDO_CNTR_NO))) {
						List<TrsTrspSvcOrdVO> svcOrdList = dbDao.searchOdSoByCop(sceCopHdrVO.getCopNo());
						if (svcOrdList != null && svcOrdList.size() > 0) {
							tmpRow.setCopNo(sceCopHdrVO.getCopNo());
							tmpRow.setCopUpdRmk("NotCncl:ODSO");
						} else if ((sceCopHdrVO.getObTroFlg() != null && sceCopHdrVO.getObTroFlg().equals("Y")) || (sceCopHdrVO.getIbTroFlg() != null && sceCopHdrVO.getIbTroFlg().equals("Y")) ){
							tmpRow.setCopNo(sceCopHdrVO.getCopNo());
							tmpRow.setCopUpdRmk("NotCncl:CnfmTRO");
						} else {
							if (tpszCnt > 0) {
								tpszMap.put(sceCopHdrVO.getCntrTpszCd(), new Integer((--tpszCnt) + ""));
								
								tmpRow.setCopNo(sceCopHdrVO.getCopNo());
								tmpRow.setCopUpdRmk("CnclByCntrCnfm");
								tmpRow.setCopStsCd("X");
							}
						}
						updList.add(tmpRow);
					}
				}
				if (updList.size() > 0)
					dbDao.modifyCopHdr(updList);
			}
			
			/**.
			 *  TRO 의 정리 작업 진행
			 *  (1) bkg_eur_tro_dtl, bkg_tro 와 상호 비교 작업
			 *  (2) ob_tro_flg, ib_tro_flg 정리 
			 */
			
			// 3. S/O 정리 작업 진행 :
			
			
			// 3. TRO, S/O 와 무관하고 bkg_quantity 와의 개수 비교시 추가로 생성되어 있는 COP 의 Cancel 작업
			
			// 4. 
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e);
			throw new EventException(e.getMessage());
		}
		
	}

	/**
	 * @param cop_no
	 * @return ManRplnRsltVO
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchPresetBfRpln(java.lang.String)
	 */
	public ManRplnRsltVO searchPresetBfRpln(String cop_no) throws EventException {
		ManRplnRsltVO rsltVO = new ManRplnRsltVO();

		try {
			SceCopHdrVO tmp = new SceCopHdrVO();
			tmp.setCopNo(cop_no);
			List<SceCopHdrVO> copList = dbDao.searchCopHdr (tmp);
			if (copList != null && copList.size() > 0) {
				ObjectCloner.build(copList.get(0), rsltVO);
			}
			
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}

		return rsltVO;
	}
	
	/**
	 * 
	 * @param copsList
	 * @return
	 */
	// private String searchMstCop(List<SceCopHdrVO> copsList) {
	//		
	// List<SceCopHdrVO> clonedList = new ArrayList<SceCopHdrVO> ();
	// ObjectCloner.build(copsList, clonedList);
	//		
	// String mstCopNo = "";
	//		
	// ListIterator <SceCopHdrVO> itr = clonedList.listIterator();
	// while (itr.hasNext()) {
	// SceCopHdrVO sceCopHdrVO = itr.next();
	//			
	// if (sceCopHdrVO.getMstCopNo() != null &&
	// (sceCopHdrVO.getMstCopNo().equals(sceCopHdrVO.getCopNo()))) {
	// mstCopNo = sceCopHdrVO.getMstCopNo();
	// }
	// }
	// return mstCopNo;
	// }
	/**
	 * @param vo
	 * @return SceBkgOpHisVO
	 * @throws EventException
	 */
	private SceBkgOpHisVO addBkgOpHis(Object vo) throws EventException {
		SceBkgOpHisVO pkVO = null;
		try {
			pkVO = dbDao.searchBkgRcvNo();
			ObjectCloner.build(vo, pkVO);

			dbDao.addBkgOpHis(pkVO);

		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
		return pkVO;
	}

	/**
	 * @param sceBkgOpHisVO
	 * @param param_seq
	 * @param paramAry
	 * @throws EventException
	 */
	private void addBkgOpPara(SceBkgOpHisVO sceBkgOpHisVO, String param_seq,
			String[] paramAry) throws EventException {
		String bkg_para_ctnt = transArrayIntoString(paramAry);

		addBkgOpPara(sceBkgOpHisVO, param_seq, bkg_para_ctnt);
	}

	/**
	 * @param sceBkgOpHisVO
	 * @param param_seq
	 * @param param
	 * @throws EventException
	 */
	private void addBkgOpPara(SceBkgOpHisVO sceBkgOpHisVO, String param_seq,
			String param) throws EventException {

		SceBkgOpParaVO sceBkgOpParaVO = new SceBkgOpParaVO();

		sceBkgOpParaVO.setBkgRcvDt(sceBkgOpHisVO.getBkgRcvDt());
		sceBkgOpParaVO.setBkgRcvNo(sceBkgOpHisVO.getBkgRcvNo());
		sceBkgOpParaVO.setBkgParaSeq(param_seq);
		sceBkgOpParaVO.setBkgParaCtnt(param);

		try {
			dbDao.addBkgOpPara(sceBkgOpParaVO);
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * @param obj
	 * @return String
	 */
	private String transArrayIntoString(String[] obj) {
		StringBuffer rtnStrBf = new StringBuffer();
		for (int i = 0; i < obj.length; i++) {
			rtnStrBf.append(obj[i]);
			if (i != obj.length - 1)
				rtnStrBf.append(",");
		}
		return rtnStrBf.toString();
	}
	
	/**
	 * @param yyyymmddhh24miss
	 * @return Calendar
	 */
	private Calendar setStrIntoCalendar(String yyyymmddhh24miss) {
		Calendar cal = Calendar.getInstance();
//		20091226093000
		if (yyyymmddhh24miss.length() == "YYYYMMDDHHMISS".length()) {
			cal.set(Calendar.YEAR, new Integer(yyyymmddhh24miss.substring(0, 4)).intValue() );
			cal.set(Calendar.MONTH, new Integer(yyyymmddhh24miss.substring(4, 6)).intValue() - 1);
			cal.set(Calendar.DAY_OF_MONTH, new Integer(yyyymmddhh24miss.substring(6, 8)).intValue());
			cal.set(Calendar.HOUR_OF_DAY, new Integer(yyyymmddhh24miss.substring(8, 10)).intValue());
			cal.set(Calendar.MINUTE, new Integer(yyyymmddhh24miss.substring(10, 12)).intValue());
			cal.set(Calendar.SECOND, new Integer(yyyymmddhh24miss.substring(12, 14)).intValue());			
		} else {
			cal = null;
		}
		
		return cal;
	}
	
	/**
	 * @param bkg_no
	 * @param rail_rcv_coff_fm_dt
	 * @param rail_rcv_coff_to_dt
	 * @param upd_usr_id
	 * @return int
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#modifyRailRcvCoffDt(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int modifyRailRcvCoffDt(String bkg_no, String rail_rcv_coff_fm_dt, String rail_rcv_coff_to_dt, String upd_usr_id) throws EventException {
		int rowCnt = 0;
		try {
			rowCnt = dbDao.modifyRailRcvCoffDt(bkg_no, rail_rcv_coff_fm_dt, rail_rcv_coff_to_dt, upd_usr_id);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * @param bkg_no
	 * @param cntr_no
	 * @return int
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#initializeSceActRcvIf(java.lang.String, java.lang.String)
	 */
	public int initializeSceActRcvIf(String bkg_no, String cntr_no) throws EventException {
		int rowCnt = 0;
		try {
			rowCnt = dbDao.initializeSceActRcvIf(bkg_no, cntr_no);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rowCnt;
	}
	
	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceActTmlRtvVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchActTmlIfDtl(java.lang.String, java.lang.String)
	 */
	public List<SceActTmlRtvVO> searchActTmlIfDtl(String fm_dt, String to_dt) throws EventException {
		
		List<SceActTmlRtvVO> rtnList = null;
		try {
			rtnList = dbDao.searchActTmlIfDtl(fm_dt, to_dt);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
		
	}
	
	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceCopHdrVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchMstCopNoDiff(java.lang.String, java.lang.String)
	 */
	public List<SceCopHdrVO> searchMstCopNoDiff(String fm_dt, String to_dt) throws EventException {
		
		List<SceCopHdrVO> rtnList = null;
		try {
			rtnList = dbDao.searchMstCopNoDiff(fm_dt, to_dt);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
	}
	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<CntrDiffVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#searchCntrDiff(java.lang.String, java.lang.String)
	 */
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws EventException {
		
		List<CntrDiffVO> rtnList = null;
		try {
			rtnList = dbDao.searchCntrDiff(fm_dt, to_dt);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return rtnList;
	}
	/**
	 * @param bkg_no
	 * @param cop_sts_cd
	 * @param cop_upd_rmk
	 * @return List<CopHdrToBeCopiedVO>
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#copyCop(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<CopHdrToBeCopiedVO> copyCop(String bkg_no, String cop_sts_cd, String cop_upd_rmk) throws EventException {
		/**
		 * 신규 생성될 COP_NO 와 기존 COP_NO 를 가지는 COPY 대상 HEADER 정보를 조회
		 * 조회된 정보로 ORG_COP_NO 의 정보를 조회해 신규 COP DETAIL 과 PLN SO LIST 를 생성한다
		 */
		List<CopHdrToBeCopiedVO> toBeCopiedList = new ArrayList<CopHdrToBeCopiedVO> ();
		try {
			toBeCopiedList = dbDao.searchCopHdrToBeCopied(bkg_no, cop_sts_cd, cop_upd_rmk );
			for (int i = 0; i < toBeCopiedList.size(); i ++) {
				CopHdrToBeCopiedVO newVO = toBeCopiedList.get(i);
				String org_cop_no = newVO.getOrgCopNo();
				String cop_no = newVO.getCopNo();
				
				SceCopHdrVO newHdr = new SceCopHdrVO();
				
				ObjectCloner.build(newVO, newHdr);
				int rowCnt = dbDao.addCopHdr(newHdr);
				if (rowCnt > 0) {
					dbDao.copyPlnSoList(cop_no, org_cop_no);
					dbDao.copyCopDtl(cop_no, org_cop_no);
				}
			}
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
		return toBeCopiedList;
	}
	/**
	 * 정리할 tro 는 O/B 것만이 대상이된다. ib tro 가 존재시는 cntr 와 match 되기 때문에 qty 정리 대상이나 cop cancel,
	 * container detach 대상이 될 수 없기 때문이다.
	 * 
	 * container detach 또는 booking replan 의 Cancel event 시 호출되어 (단, cop 에 tro 가 mapping 되어 있어야 함)
	 * container detach 시에는 flex height 를 감안한 tpsz 호환 가능한 container 가 존재하는 COP 를 찾고 (TRO 가 미 mapping)
	 * booking replan 시의 cancel event 도 역시 flex height 를 감안한 tpsz 호환 가능한 container 가 존재하는 cop 를 찾고  
	 * (tro 가 미 mapping)
	 * from -> to cop 관계를 생성한 후 아래의 작업을 진행한다.
	 * 
	 * 1. from cop 의 tro flag 를 'N', to cop 의 tro flag 를 'Y' 로 수정
	 * 2. sce_tro_mapg 의 from cop 를 to cop 로 변경
	 * 3. od-so 의 cop_no 를 from cop 에서 to cop 로 변경
	 * 4. to cop 가 so 의 from ~ via -door -to (or from door via to) 경로를 가지고 있지 않을 경우 cop 를 replan
	 * 5. replan 된 cop 를 대상으로 from cop 의 so status 를 변경함
	 * 6. 이동 성공 여부를 return (성공시 container detach 시에는 해당 tpsz 가 booking qty 에 미 존재시 cancel,
	 * 	booking replan 의 cancel 시에는 단순 cancel 처리 한다) 
	 * 
	 * 대표적인 case >
	 * bkg qty 는 D4 이어 tro 를 모두 d4 로 냈으나 container 가 추가로 붙고 tro 가 존재하는 cop 에 mapping 된 container 를 detach
	 * 
	 * 
	 * @param String cop_no
	 * @return boolean
	 */
	private boolean moveTroInfo(String cop_no, String src_cd) throws EventException {
		boolean rtnVal = false;
		
		SceCopHdrVO modCopVO = new SceCopHdrVO();
		List<SceCopHdrVO> modCopList = new ArrayList<SceCopHdrVO> ();
		
		try {
			SceCopHdrVO to_cop = dbDao.searchCopToRcvTro(cop_no, src_cd);
			
			if (to_cop != null && to_cop.getCopNo() != null && !to_cop.getCopNo().equals("") ) {
				// 1. tro flag 정리
				modCopVO.setCopNo(cop_no);
				modCopVO.setObTroFlg("N");
				modCopVO.setCopUpdRmk("tro moved to " + to_cop.getCopNo());
				modCopList.add(modCopVO);
				
				modCopVO = new SceCopHdrVO();
				modCopVO.setCopNo(to_cop.getCopNo());
				modCopVO.setObTroFlg("Y");
				modCopVO.setCfmObDorArrDt(to_cop.getCfmObDorArrDt());
				modCopVO.setCopUpdRmk("tro moved from " + cop_no);
				modCopList.add(modCopVO);
				
				dbDao.modifyCopHdr(modCopList);
				modCopList.clear();
				modCopVO = new SceCopHdrVO();
				
				// 2. sce_tro_mapg 정리
				dbDao.modifyTroMapgCopNoByCop(cop_no, to_cop.getCopNo(), "O");
				
				// 3. od-so 의 cop_no 를 변경
				dbDao.modifyOdSoCopNo(cop_no, to_cop.getCopNo());
				
				// 4. od route 정보가 다르면 replan
				if (dbDao.checkOdRouteDiff(cop_no, to_cop.getCopNo())) {
					replanManageBC.replanCop (to_cop, "tro moved / replan");
				}
				
				// 5. so status 에 대한 정리 작업
				dbDao.modifyPlnSoListSoSts(cop_no, to_cop.getCopNo()); // to_cop 의 Od-so 의 status 를 변경
				dbDao.modifyOdSoStsPlned(cop_no); // cop 의 status 를 planned 로 원복
				// 6. 남는 COP 에 대한 CANCEL
				
				rtnVal = true; // 옮겨질 대상이 있어 처리가 되면 true
			} 
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		} catch (EventException e) {
			log.error(e);
			throw e;
		}
		
		return rtnVal;
		
	}

	/**
	 * @param String bkg_no
	 * @throws EventException
	 * @see com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC#reviveCopsByBkgRqst(java.lang.String)
	 */
	public void reviveCopsByBkgRqst(String bkg_no) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.reviveCopsByBkgRqst(bkg_no);
			
			confirmCntr(bkg_no);
		} catch (DAOException de) {
			log.error(de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * PCTL NO가 포함됐는지 여부 확인
	 * @param String[] pctlNos, String curPctlNo
	 * @return boolean
	 */
	private boolean isPctlNoContains(String[] pctlNos, String curPctlNo){
		boolean returnFlag = false;
		if(pctlNos != null){
			for(String pctlNo : pctlNos){
				if(curPctlNo != null && pctlNo.equals(curPctlNo)){
					returnFlag = true;
					break;
				}
			}
		}
		return returnFlag;
	}
	
	/**
	 * PCTL NO가 포함됐는지 여부를 확인한뒤 LIST에 추가
	 * @param String[] pctlNos, String curPctlNo
	 * @return String[]
	 */	
	private String[] addPctlNos(String[] pctlNos, String curPctlNo){
		String [] tempArray2 = null;
		int i=0;
		if(pctlNos == null){
			tempArray2 = new String[1];
			tempArray2[0] = curPctlNo;
		}else{
		    tempArray2 = new String [pctlNos.length+1];
		    for(String pctlNo : pctlNos){
		    	tempArray2[i++] = pctlNo;
			}
		    tempArray2[i] = curPctlNo;
		}
		return tempArray2;
	}
}

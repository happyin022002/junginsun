/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDownloadBCImpl.java
*@FileTitle : KorManifestListDownloadBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.DateVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.HjtRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorBkgCstmsVvdSmryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManiCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration.KorManifestListDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.*;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DiscCYBondInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.EmpAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiDGMTransVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestAmdManiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestEditListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnBondInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnNoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SndCorrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.TmpBlBkgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsKrCustVO;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.clt.syscommon.common.table.BkgCstmsKrXptLicVO;
import com.clt.syscommon.common.table.BkgRateVO;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0329EventResponse,KorManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class KorManifestListDownloadBCImpl extends BasicCommandSupport implements KorManifestListDownloadBC {

	private transient KorManifestListDBDAO dbDao = null;

	/**
	 * KorManifestListDownloadBCImpl 객체 생성<br>
	 * KorManifestListDBDAO 생성한다.<br>
	 */
	public KorManifestListDownloadBCImpl() {
		dbDao = new KorManifestListDBDAO();
	}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회
	 *
	 * @param KorMrnNoVO korMrnNoVO
	 * @return KorContainerVO
	 * @throws EventException
	 */
	public KorContainerVO searchManifestInfo(KorMrnNoVO korMrnNoVO) throws EventException {
		BkgCstmsKrDlHisVO checkParam = new BkgCstmsKrDlHisVO();
		String bldl 	= korMrnNoVO.getBlDl();
		String in_bound = korMrnNoVO.getInBound();
		String sel_type = korMrnNoVO.getSelType();
		String in_pod 	= korMrnNoVO.getInPod();
		String in_pol 	= korMrnNoVO.getInPol();
		String port_cd 	= "";
		if ("O".equals(in_bound)) {
			port_cd = korMrnNoVO.getInPolTmnl();
		} else{
			port_cd = korMrnNoVO.getInPodTmnl();
		}

		int cntr_local 	= 0;
		int cntr_ts		= 0;
		int cntr_empty 	= 0;
		int cntr_total 	= 0;
		int bl_local 	= 0;
		int bl_ts 		= 0;
		int bl_empty 	= 0;
		int bl_total 	= 0;

		KorContainerVO korContainerVO = new KorContainerVO();
		List<KorManifestInfoVO> list = null;
		List<KorBkgCntrQtyInfoVO> bkgCntrQtyInfo = null;
		BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO = new BkgCstmsKrDlHisVO();

		if ("O".equals(in_bound)) {
			korMrnNoVO.setKtPort(in_pol);
		} else {
			korMrnNoVO.setKtPort(in_pod);
		}

		try {
			if ("bl".equals(bldl)) {

				// REDOWN 여부 조회
				bkgCstmsKrDlHisVO.setVvd	(korMrnNoVO.getInVvd()	);
				bkgCstmsKrDlHisVO.setInBound(korMrnNoVO.getInBound());
				bkgCstmsKrDlHisVO.setKtPort	(port_cd					);
				bkgCstmsKrDlHisVO.setPolLoc	(in_pol						);
				bkgCstmsKrDlHisVO.setPodLoc	(in_pod						);

				KorMrnNoVO tempMrnNoVO = dbDao.searchMrnNo(korMrnNoVO);
				if (tempMrnNoVO == null) return null;

				korMrnNoVO.setMrnNo(tempMrnNoVO.getMrnNo());
				korMrnNoVO.setMrnChkNo(tempMrnNoVO.getMrnChkNo());

				korContainerVO.setKorMrnNoVO(tempMrnNoVO);
				list = dbDao.searchManifestInfoList(korMrnNoVO);
				korContainerVO.setKorManifestInfoVOs(list);

				bl_total = list.size();
				for (int i=0;i<list.size();i++) {
					String cntr_cnt = "0";

					KorManifestInfoVO node = (KorManifestInfoVO)list.get(i);
					String fE = node.getFe();
					String tP = node.getTp();

					String vvd_pol 		= node.getHidden1().substring(0,5);
					String vvd_pod 		= node.getHidden2().substring(0,5);
					String bkg_pol 		= node.getPol().substring(0,5);
					String bkg_pod 		= node.getPod().substring(0,5);
					String bkg_cgo_tp2 	= node.getFe();
					String bkg_no    	= node.getABkgNo();
					String bkg_split 	= node.getABkgNoSplit();

					if ("O".equals(in_bound)) {

						if (vvd_pol.equals(bkg_pol)) node.setTp("E");
						else						node.setTp("R");

						if (!vvd_pol.equals(bkg_pol)) {
							node.setCreatedType("C");

						} else {
							node.setCreatedType("B");//"P".equals(bkg_cgo_tp2) -> M
						}

						if ("B".equals(sel_type)) {
							if ("C".equals(node.getCreatedType())) {
								list.remove(i);
								i--;
								continue;
							}
						} else if ("C".equals(sel_type)) {
							if ("B".equals(node.getCreatedType())) {
								list.remove(i);
								i--;
								continue;
							}
						}

//						else if ("M".equals(sel_type))
//						{
//							if ("A".equals(node.getCreatedType()) || "B".equals(node.getCreatedType())||"C".equals(node.getCreatedType()))
//							{
//								list.remove(i);
//								i--;
//								continue;
//							}
//						}

						if ("C".equals(sel_type)) {
							node.setHidden4(" ");
						}
					} else if ("I".equals(in_bound)) {
//						node.setCreatedType("N");
						if (in_pod.equals(bkg_pod)) {
							 if ("P".equals(bkg_cgo_tp2)) {
								 node.setCreatedType("M");
							 } else {

								 node.setCreatedType("A");//"P".equals(bkg_cgo_tp2) -> M
							 }
						}

						if ("A".equals(sel_type)) {
							if (!"A".equals(node.getCreatedType())) {
								list.remove(i);
								i--;
								continue;
							} else {
								if ("P".equals(bkg_cgo_tp2)) {
									list.remove(i);
									i--;
									continue;
								}
							}
						} else if("M".equals(sel_type)) {
							if (!"M".equals(node.getCreatedType())) {
								list.remove(i);
								i--;
								continue;
							}
						}
						else {
							node.setCreatedType("N");//type 선택 안됐을 때
						}

//						// Inbound이고 A:Local Type인 경우 T/S가 'I'인 데이터만 검색되게 설정한다.
						if ("I".equals(in_bound) && "A".equals(sel_type)) {

							node.setTp("I");
						} else {
							if (bkg_pod.equals(vvd_pod)) node.setTp("I");
							else						node.setTp("T");
						}

						node.setFrobCheck(" ");
					}

					// DOWNLOAD 여부 조회
					checkParam.setInBound	(korMrnNoVO.getInBound()	);
					checkParam.setVvdCd		(korMrnNoVO.getInVvd()		);
					checkParam.setPolLoc	(korMrnNoVO.getInPol()		);
					checkParam.setPodLoc	(korMrnNoVO.getInPod()		);
					checkParam.setBkgNo		(bkg_no							);
					checkParam.setKcdTp		(node.getTp()					);
					if (korMrnNoVO.getInBound().equals("O")) {
						checkParam.setKtPort(korMrnNoVO.getInPol()		);
					} else {
						checkParam.setKtPort(korMrnNoVO.getInPod()		);
					}
					String downCount = dbDao.searchDownHistCheck(checkParam);
					if (downCount==null || downCount.compareTo("0")==0) {
						node.setDownYn("N");
					} else {
						node.setDownYn("Y");
					}

					if (korMrnNoVO.getInBound().equals("O")) {
						// OutBound 경우 다른 항차로 다운로드 여부 체크
						KorDownCheckVO downCheckVO = new KorDownCheckVO();
						downCheckVO.setPolCd		(korMrnNoVO.getInPol()		);
						downCheckVO.setPodCd		(korMrnNoVO.getInPod()		);
						downCheckVO.setIoBndCd		(korMrnNoVO.getInBound()	);
						downCheckVO.setBkgNo		(bkg_no							);
						downCheckVO.setCstmsDeclTpCd(node.getTp()					);
						downCheckVO = dbDao.searchDownCheck(downCheckVO);

						// OUT BOUND 의 경우 화면의 VVD 와 쿼리결과 VVD 가 다르면 오류(X)로 처리
						if (downCheckVO != null && !downCheckVO.getVvd().trim().equals(korMrnNoVO.getInVvd().trim())) {
							node.setRoChk("X");
							node.setOtherVvd(downCheckVO.getVvd());
						} else {
							node.setRoChk("");
						}
					}

					// CUSTOMER TYPE 조회
					//String custType = dbDao.searchCustType(bkg_no);
					String custType = node.getSc();
					node.setCustType(custType);

					if ("O".equals(in_bound) && node.getSc().equals("N")) {
						if (custType.equals("N")) node.setSc("C");
						if (custType.equals("B")) node.setSc("S");
					}


					bkgCntrQtyInfo = dbDao.searchCntrInfo(bkg_no, bkg_split);
					korContainerVO.addKorBkgCntrQtyInfoVO(bkgCntrQtyInfo);
					//컨테이너 카운트
					cntr_total += bkgCntrQtyInfo.size();
					cntr_cnt = Integer.toString(bkgCntrQtyInfo.size());
					node.setCntr(Integer.toString(bkgCntrQtyInfo.size()));
					for (int m=0;m<bkgCntrQtyInfo.size();m++) {
						if ("P".equals(bkg_cgo_tp2) || "R".equals(bkg_cgo_tp2)) {
							bkgCntrQtyInfo.get(m).setCntrType("E");
							cntr_empty ++;
						} else {
							if ("E".equals(node.getTp()) || "I".equals(node.getTp())) {
								bkgCntrQtyInfo.get(m).setCntrType("L");
								cntr_local ++;
							} else {
								bkgCntrQtyInfo.get(m).setCntrType("T");
								cntr_ts ++;
							}
						}
					}

					tP = node.getTp();
					if ("P".equals(fE) || "R".equals(fE)) bl_empty++;
					else if ("I".equals(tP) || "E".equals(tP)) bl_local++;
					else bl_ts++;

					if ("R".equals(node.getTp())) node.setSc("S");

					if ("E".equals(node.getTp())) {
						if ("S".equals(node.getSc())) {
							KorExportNoVO exportNoVO = dbDao.searchExportInfo(bkg_no, bkg_split);
							if (exportNoVO == null) {
								//1403
								node.setElnoWgtCheck("U");
							} else {
								String elno_wgt = exportNoVO.getMfWgt().substring(0, 8);
								node.setElNoCheck(exportNoVO.getXptLicNo());
								String act_wgt = node.getActWgt().substring(0, 8);

								if (elno_wgt.equals(act_wgt) && node.getPckQty().equals(exportNoVO.getPckQty())) {
									if ("E".equals(exportNoVO.getXptLicNo())) node.setElnoWgtCheck("U");
									else									 node.setElnoWgtCheck("M");
								} else {
									node.setElnoWgtCheck("U");
								}
							}
						} else {
							KorExportCheckInfoVO exportCheckVO = dbDao.searchExportCheckInfo(bkg_no, bkg_split);
							if (exportCheckVO != null) {
								if ("".equals(exportCheckVO.getBkgCheck())) exportCheckVO.setBkgCheck(" ");
							}
							node.setElnoWgtCheck(" ");

							if ("".equals(node.getElNoCheck())) node.setElNoCheck(" ");
							node.setElnoWgtCheck(" ");
						}
					} else {
						node.setElNoCheck(" ");
						node.setElnoWgtCheck(" ");
					}

					node.setElnoA(node.getElNoCheck());
					node.setElnoB(node.getElnoWgtCheck());

					KorCustInfoVO korCustInfoVO = dbDao.searchCustInfo(in_bound, bkg_no, bkg_split);
					if (korCustInfoVO != null) {
						node.setShprN(korCustInfoVO.getShprName());
						node.setShprA(korCustInfoVO.getShprAddr());
						node.setCneeN(korCustInfoVO.getCneeName());
						node.setCneeA(korCustInfoVO.getCneeAddr());
						node.setNtfyN(korCustInfoVO.getNtfyName());
						node.setNtfyA(korCustInfoVO.getNtfyAddr());
						node.setCustName(korCustInfoVO.getUsrs14().replaceAll("\n", " "));
					}
					KorCgoDescVO vo = new KorCgoDescVO();
					vo.setABkgNo(node.getABkgNo());
					String korCargoDescVO = dbDao.searchCargoDesc(vo);

					if ("".equals(korCargoDescVO)) korCargoDescVO = "N";
					node.setDescCode(korCargoDescVO);

					String cnt_cd = "";
					String cust_cd = "";

					/*
					 *
					 * Congignee Name이 TO THE ORDER OF 이면
					 * Notify의 상호를 biz no로 셋팅 하기 위한 변수
					 */
					boolean notifyBzNoFlag = false;
					String custNm = "";

					if ("E".equals(node.getTp()) || "R".equals(node.getTp())) {
						String biz_no = dbDao.searchOBBizNo(vo);
						if ("".equals(biz_no) || biz_no == null) {
							KorCustVO biz_01 = dbDao.searchCntCdTpS(node.getABkgNo(), node.getABkgNoSplit());
							if (biz_01 != null) {
								cnt_cd = biz_01.getCntCd();
								cust_cd = biz_01.getCustCd();
							}
						}
					} else {
						KorCustVO biz_01 = dbDao.searchCntCdTpC(node.getABkgNo(), node.getABkgNoSplit());
						if (biz_01 != null) {
							cnt_cd = biz_01.getCntCd();
							cust_cd = biz_01.getCustCd();
							custNm = biz_01.getCustNm();

							/**
							 * 2010.11.15 경종윤 [CHM-201007078] 화주의 사업자등록번호 기재 보완요청
							 * 2011.11.15 김현화 [] TO THE ORDER OF 에서 ORDER로 변경 -AA안정선
							 */

							//if (Pattern.compile("TO.*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNm.toUpperCase()).matches()) {
							if (Pattern.compile(".*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNm.toUpperCase()).matches()) {

							//if (custNm.toUpperCase().trim().startsWith("TO THE ORDER OF")) {
								notifyBzNoFlag = true;
								biz_01 = dbDao.searchCntCdTpN(node.getABkgNo(), node.getABkgNoSplit());
								cnt_cd = biz_01.getCntCd();
								cust_cd = biz_01.getCustCd();
							}


							/*
							 * 추가 부분
							 */
						}
					}

					if (cnt_cd.length() == 2 || notifyBzNoFlag) {
						String rtn = dbDao.searchRegNo(cnt_cd, cust_cd);
						if (rtn == null) node.setBz("N");
						else			node.setBz(rtn);
					} else {
						node.setBz("N");
					}

					if ("N".equals(node.getMsn()) ||
					   "N".equals(node.getDescCode()) ||
					   "N".equals(node.getShprA()) ||
					   "N".equals(node.getShprN()) ||
					   "N".equals(node.getCneeN()) ||
					   "N".equals(node.getCneeA()) ||
					   "N".equals(node.getBz()) ||
					   "0".equals(cntr_cnt) ||
					   "0".equals(node.getPkgValue()) ||
					   "0".equals(node.getWgtValue()) ) {
						node.setErrChk("E");
					} else {
						if ("I".equals(node.getTp()) || "T".equals(node.getTp())) {
							if ("I".equals(node.getTp()) && "N".equals(node.getWh())) {
								node.setErrChk("E");
							} else if ("N".equals(node.getBac()) || "N".equals(node.getCneeA()) || "N".equals(node.getNtfyN())) {
								node.setErrChk("E");
							} else {
								node.setErrChk("N");
							}
						} else {
							if (node.getElnoA() != null && node.getElnoB() != null && node.getElnoA().equals("Y") && node.getElnoB().equals("U")) {
								node.setErrChk("E");
							} else 	if (node.getSc().equals("C") && node.getElnoA() != null && node.getElnoA().equals("Y")) {
								node.setErrChk("E");
							} else if (node.getSc().equals("S") && node.getElnoA() != null && node.getElnoA().equals("N")) {
								node.setErrChk("E");
							} else {
								node.setErrChk("N");
							}
						}
					}

				} // for Loop
			}
//			else if ("dl".equals(bldl))
			else {
				if (!"A".equals(sel_type) && !"B".equals(sel_type) && !"C".equals(sel_type) && !"D".equals(sel_type) && !"M".equals(sel_type) && !"T".equals(sel_type) && !"R".equals(sel_type)) {
					korMrnNoVO.setSelType("N");
					sel_type = "N";
				}

				String etbDt = "";
				if ("O".equals(in_bound)) {
					korMrnNoVO.setKtPort(in_pol);
					etbDt = dbDao.searchEtbDate(korMrnNoVO.getInVvd(), in_pol);
				} else {
					korMrnNoVO.setKtPort(in_pod);
					// * Inbound의 경우는 OB_DECL_TP_CD = 'N' 이므로 MRN No 검색을 위하여 임의로 sel_type을 N으로 설정한다.
					//if (!"M".equals(sel_type)) manifestInfoVO.setSelType("N");
				}

				KorMrnVO korMrnVO = dbDao.searchMrnNoKor(korMrnNoVO);
				if (korMrnVO == null) return null;

				korMrnNoVO.setMrnNo(korMrnVO.getMrnNo());
				korMrnNoVO.setMrnChkNo(korMrnVO.getMrnChkNo());
				korMrnNoVO.setEtaEtd(korMrnVO.getEtaEtd());
				korMrnNoVO.setEtdDt(korMrnVO.getEtdDt());
				korMrnNoVO.setEtbDt(etbDt);

				korContainerVO.setKorMrnNoVO(korMrnNoVO);

				// Inbound의 경우 *에서 설정한 원래의 sel_type을 되돌린다.
				if ("I".equals(in_bound)) {
					korMrnNoVO.setSelType(sel_type);
				}

				list = dbDao.searchManifestInfoKorList(korMrnNoVO);

				if (list == null) return null;
				korContainerVO.setKorManifestInfoVOs(list);

				bl_total = list.size();
				for (int i=0;i<list.size();i++) {
					KorManifestInfoVO node = (KorManifestInfoVO)list.get(i);
					String kt_us_bound = node.getHidden5();
					node.setInVvd(korMrnNoVO.getInVvd());
					String fE = node.getFe();
					String tP = node.getTp();

					// Container 목록 조회
					bkgCntrQtyInfo =  dbDao.searchCNTRCntInfoList(node.getABkgNo(), node.getTp(), korMrnNoVO.getKtPort(), korMrnNoVO.getInVvd(), node.getCBlNo());
					korContainerVO.addKorBkgCntrQtyInfoVO(bkgCntrQtyInfo);

					if ("O".equals(in_bound)) {
						node.setKtPort(in_pol);

						//jjang
						if ("B".equals(sel_type)) {
							if ("C".equals(kt_us_bound)) {
								list.remove(i);
								i--;
								continue;
							}
						} else if ("C".equals(sel_type)) {
							if ("B".equals(kt_us_bound)) {
								list.remove(i);
								i--;
								continue;
							}
						}

						if ("C".equals(kt_us_bound)) node.setBac(" ");

						KorManifestInfoVO iBManifest = dbDao.searchIBManifestInfoKor(in_pol, node);
						if (iBManifest != null) {
							node.setPkgValue(iBManifest.getPkgValue());
							node.setPkgCode(iBManifest.getPkgCode());
							node.setWgtValue(iBManifest.getWgtValue());
							node.setWgtCode(iBManifest.getWgtCode());
							node.setMatch(iBManifest.getMatch());
							node.setPreVvd(iBManifest.getPreVvd());
						}
					} else if ("I".equals(in_bound)) {
						if ("A".equals(sel_type)) {
							if (!node.getPod().equals(in_pod)) {
								list.remove(i);
								i--;
								continue;
							} else {
								if ("P".equals(fE)) {
									list.remove(i);
									i--;
									continue;
								}
							}
						} else if ("M".equals(sel_type)) {
							node.setCreatedType("M");
						} else {
							node.setCreatedType("N");
						}

						node.setKtPort(in_pod);
						if ("T".equals(node.getTp())) node.setWh(" ");
					}

					if ("P".equals(fE) || "R".equals(fE)) bl_empty++;
					else if ("I".equals(tP) || "E".equals(tP)) bl_local++;
					else bl_ts++;

					KorManifestInfoVO custInfo = dbDao.searchCustInfoKor(node);

					if (custInfo != null) {
						node.setShprN(custInfo.getShprN());
						node.setShprA(custInfo.getShprA());
						node.setCneeN(custInfo.getCneeN());
						node.setCneeA(custInfo.getCneeA());
						node.setNtfyN(custInfo.getNtfyN());
						node.setNtfyA(custInfo.getNtfyA());
						node.setCustName(custInfo.getCustName());
					}

					// CUSTOMER TYPE 조회
					//String custType = dbDao.searchCustType(node.getABkgNo());
					String custType = node.getSc();
					node.setCustType(custType);

					String checkValue = dbDao.searchCustInfoCheck(node);
					if ("N".equals(checkValue)) node.setShprA("N");

					//컨테이너 토탈카운트
					String cntr_cnt = dbDao.searchCntrTtlCntKor(node);
					//컨테이너 Count
					node.setCntr(cntr_cnt);
					node.setCntrCnt(cntr_cnt);

					String elno_wgt_check = null;
					String elno_check = null;

					if ("E".equals(node.getTp())) {
						if ("S".equals(node.getSc())) {
							KorExportNoVO pExportInfo = dbDao.searchExportInfoKor(node);

							if (pExportInfo == null) {
								elno_wgt_check = "U";
							} else if (node.getHidden4().substring(0, 8).equals(pExportInfo.getElnoWgt().substring(0, 8)) &&
									 node.getHidden6().equals(pExportInfo.getPckQty())) {
								elno_wgt_check = "M";
								elno_check = pExportInfo.getElnoCheck();
							} else {
								elno_wgt_check = "U";
								elno_check = pExportInfo.getElnoCheck();
							}
						} else {
							elno_wgt_check = " ";
							elno_check = " ";
						}
					} else {
						elno_wgt_check = " ";
						elno_check = " ";
					}

					node.setElnoWgtCheck(elno_wgt_check);
					node.setElNoCheck(elno_check);
					node.setElnoA(node.getElNoCheck());
					node.setElnoB(node.getElnoWgtCheck());

					//에러필드 체크
					if ("N".equals(node.getMsn()) ||
					   "N".equals(node.getDescCode()) ||
					   "N".equals(node.getShprA()) ||
					   "N".equals(node.getShprN()) ||
					   "N".equals(node.getCneeA()) ||
					   "N".equals(node.getCneeN()) ||
					   "N".equals(node.getBz()) ||
					   "0".equals(cntr_cnt) ||
					   "0".equals(node.getPkgValue()) ||
					   "0".equals(node.getWgtValue()) ) {
						node.setErrChk("E");
					} else {
						if ("I".equals(node.getTp()) || "T".equals(node.getTp())) {
							if ("I".equals(node.getTp()) && "N".equals(node.getWh())) {
								node.setErrChk("E");
							} else if ("N".equals(node.getBac()) || "N".equals(node.getCneeA())) {
								node.setErrChk("E");
							} else {
								node.setErrChk("N");
							}
						} else {
							if (node.getElnoA() != null && node.getElnoB() != null && node.getElnoA().equals("Y") && node.getElnoB().equals("U")) {
								node.setErrChk("E");
							} else 	if (node.getSc().equals("C") && node.getElnoA() != null && node.getElnoA().equals("Y")) {
								node.setErrChk("E");
							} else if (node.getSc().equals("S") && node.getElnoA() != null && node.getElnoA().equals("N")) {
								node.setErrChk("E");
							} else {
								node.setErrChk("N");
							}
						}
					}

				} //Main Query For Loop
			}

			korMrnNoVO.setCntrLocal(Integer.toString(cntr_local));
			korMrnNoVO.setCntrTs(Integer.toString(cntr_ts));
			korMrnNoVO.setCntrEmpty(Integer.toString(cntr_empty));
			korMrnNoVO.setCntrTotal(Integer.toString(cntr_total));
			korMrnNoVO.setBlLocal(Integer.toString(bl_local));
			korMrnNoVO.setBlEmpty(Integer.toString(bl_empty));
			korMrnNoVO.setBlTotal(Integer.toString(bl_total));
			korMrnNoVO.setBlTs(Integer.toString(bl_ts));

			// Manifest Check 인 경우, Diff(Package, Weight)가 발생한 경우만 List에 담는다.
			// 단, 패키지 포장 단위는 비교 대상에서 제외한다.
			if ("mc".equals(bldl)) {
				List<KorManifestInfoVO> diffList = korContainerVO.getKorManifestInfoVOs();
				List<KorManifestInfoVO> diffNewList = new ArrayList<KorManifestInfoVO>();

				if (diffList != null) {
					for (int i=0; i<diffList.size(); i++) {
						KorManifestInfoVO diffVO = diffList.get(i);
						if ("Y".equals(diffVO.getPckQtyChk()) || "Y".equals(diffVO.getCntrTtlWgtChk()) || "Y".equals(diffVO.getWgtUtCdChk())) {
							diffNewList.add(diffVO);
						}
					}

					korContainerVO.setKorManifestInfoVOs(diffNewList);
				}
			}
//			else if ("cr".equals(bldl)) {
//
//				List<KorManifestCrsChkInfoVO> diffList = container.getKorManifestCrsChkInfoVOs();
//				List<KorManifestCrsChkInfoVO> diffNewList = new ArrayList<KorManifestCrsChkInfoVO>();
//
//				if (diffList != null) {
//					for (int i=0; i<diffList.size(); i++) {
//						KorManifestCrsChkInfoVO diffVO = diffList.get(i);
//						//if ("Y".equals(diffVO.getMfDlDiffFlg()) && "N".equals(diffVO.getMfSndFlg())) {
//							diffNewList.add(diffVO);
//						//}
//					}
//
//					container.setKorManifestCrsChkInfoVOs(diffNewList);
//				}
//			}
		}
		catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korContainerVO;
	}	//End

	/**
	 * ESM_BKG_0329 - BackEndJob 시작
	 *
	 * @param SignOnUserAccount account
	 * @param KorDlContainerVO korDlContainerVO
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobDownloadCstmsBlList(SignOnUserAccount account, KorDlContainerVO korDlContainerVO) throws EventException {
		KorManifestListDownloadBackEndJob backEndJob = new KorManifestListDownloadBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			backEndJob.setAccount(account);
			backEndJob.setKorDlContainerVO(korDlContainerVO);
			backEndJob.setPgmNo("ESM_BKG_0329");
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Manifest Download BackEnd Job!");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 이미 다운로드 되었던 Manifest에 대해서 만약 아직 전송이 되지 않은 상태일 경우에 대해서 manage한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return int
	 * @exception EventException
	 */
	public int manageManifest(ManifestListCondVO manifestListCondVO)throws EventException {
		KorDlContainerVO condition = (KorDlContainerVO) manifestListCondVO;

		KorMrnNoVO condData = condition.getKorMrnNoVO();
		KorManifestInfoVO[] condList = condition.getKorManifestInfoVOs();
		int delcount = 0;

		try {
			if ("dl".equals(condData.getBlDl())) {
				for (int i=0;i<condList.length;i++) {

					BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();

					String kcd_tp = condList[i].getTp();
					String kt_port = "";
					String trans_seq = condList[i].getHidden3();

					if ("O".equals(condData.getInBound())) {
						kt_port = condData.getInPol();
					} else {
						kt_port = condData.getInPod();
					}

					bkgCstmsKrBlVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrBlVO.setKcdTp(kcd_tp);
					bkgCstmsKrBlVO.setKtSeq(trans_seq);
					bkgCstmsKrBlVO.setKtPort(kt_port);
					bkgCstmsKrBlVO.setUsrId(condition.getUser_id());

					String cnt = dbDao.searchKorMainSndCount(bkgCstmsKrBlVO);

					if ("".equals(cnt)) cnt = "0";
					int i_cnt = Integer.parseInt(cnt);

					if (i_cnt > 0) {
						dbDao.modifyDelMarkKor(bkgCstmsKrBlVO);
						continue;
					}

					BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
					bkgCstmsKrCntrVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrCntrVO.setKcdTp(kcd_tp);
					bkgCstmsKrCntrVO.setKtSeq(trans_seq);
					bkgCstmsKrCntrVO.setKtPort(kt_port);
					bkgCstmsKrCntrVO.setCBlNo(condList[i].getCBlNo());
					int deleteCount = dbDao.removeCNTRInfoKor(bkgCstmsKrCntrVO);

					BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
					bkgCstmsKrXptLicVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrXptLicVO.setKcdTp(kcd_tp);
					bkgCstmsKrXptLicVO.setKtSeq(trans_seq);
					bkgCstmsKrXptLicVO.setKtPort(kt_port);
					deleteCount = dbDao.removeElNoInfoKor(bkgCstmsKrXptLicVO);

					BkgCstmsKrCustVO bkgCstmsKrCustVO = new BkgCstmsKrCustVO();
					bkgCstmsKrCustVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrCustVO.setKcdTp(kcd_tp);
					bkgCstmsKrCustVO.setKtSeq(trans_seq);
					bkgCstmsKrCustVO.setKtPort(kt_port);
					deleteCount = dbDao.removeCustInfoKor(bkgCstmsKrCustVO);
					deleteCount = dbDao.removeBlInfoKor(bkgCstmsKrBlVO);
					String maxseq = dbDao.searchMaxSeqDownHistKor(condData.getMrnNo() + condData.getMrnChkNo(), condData.getInVvd());

					if ("".equals(maxseq) || maxseq == null)maxseq = "0";
					Long i_maxseq = Long.parseLong(maxseq);
					i_maxseq ++;
					BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO = new BkgCstmsKrDlHisVO();

					bkgCstmsKrDlHisVO.setMrnNbr(condData.getMrnNo());
					bkgCstmsKrDlHisVO.setMrnChk(condData.getMrnChkNo());
					bkgCstmsKrDlHisVO.setKdhSeq(Long.toString(i_maxseq));
					bkgCstmsKrDlHisVO.setPol(condData.getInPol());
					bkgCstmsKrDlHisVO.setPod(condData.getInPod());
					bkgCstmsKrDlHisVO.setUserName(condition.getUser_id());
					bkgCstmsKrDlHisVO.setDeleteBlCnt(Integer.toString(deleteCount));
					bkgCstmsKrDlHisVO.setVvd(condData.getInVvd());
					bkgCstmsKrDlHisVO.setUserName(condition.getUser_id());
					bkgCstmsKrDlHisVO.setOffice(condition.getOffice());
					//BKG_CSTMS_KR_DL_HIS
					dbDao.addDownHistKor(bkgCstmsKrDlHisVO);
					delcount++;
				}
			}
		}
		catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return delcount;
	}

	/**
	 * ManifestList 한국세관쪽으로 다운로드
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> downloadCstmsBlList(ManifestListCondVO manifestListCondVO , SignOnUserAccount account) throws EventException {
		// 파라메터 객체 변환
		KorDlContainerVO condition = (KorDlContainerVO) manifestListCondVO;

		KorMrnNoVO condData = condition.getKorMrnNoVO();
		// 화면에서 넘어온 ManifestList
		KorManifestInfoVO[] condList = condition.getKorManifestInfoVOs();
		// PORT
		String kt_port = null;
		// Down 여부 판단
		String downCount = null;
		// DownLoad 전의 MRN, DATE 들 조회용
		KorMrnVslSysEtaEtdVO mrnVslSysEtaEtdCondVO = new KorMrnVslSysEtaEtdVO();
		KorMrnVslSysEtaEtdVO mrnVslSysEtaEtdVO = null;
		// Cargo Desc 조회용 객체
		KorCgoDescVO cargoParam = new KorCgoDescVO();
		// CREATE TYPE
		String createType = null;
		// Download 여부 CHECK
		BkgCstmsKrDlHisVO checkParam = new BkgCstmsKrDlHisVO();
		// KCD_TP
		String kcd_tp = null;
		// VVD, POL, POD 비교용 임시 변수
		String down_vvd_pol = null;
		String down_vvd_pod = null;
		String down_bkg_pol = null;
		String down_bkg_pod = null;
		String wh_whf_ind   = null;
		// 최초 DOWN 의 경우
		KorManifestDNVO[] korMainfestDNVOs = null;
		KorManifestDNVO down = null;
		// ReDown 의 경우
		KorManifestInfoVO reDownNode = null;
		// 위험여부 정보 조회
		String dangerInfo[] = null;
		// Container 조회관련 객체
		KorBkgCntrVO paramNode = null;
		KorBkgCntrVO korBkgCntrVO = null;
		BkgCstmsKrCntrVO param1 = new BkgCstmsKrCntrVO();
		List<KorBkgCntrVO> korBkgCntrVOs = null;
		// Export Info 조회용 객체
		List<KorExportInfoDNVO> exportList = null;
		// Customer Info 조회용 객체
		List<KorBkgCustVO> custInfoList = null;
		// VVD Summary 조회용 객체
		KorBkgCstmsVvdSmryVO paramVO = new KorBkgCstmsVvdSmryVO();
		// Transmit Check 용 객체
		BkgCstmsKrBlVO searchTransMit = null;
		BkgCstmsKrBlVO transParam = new BkgCstmsKrBlVO();
		BkgCstmsKrBlVO seqNSndHistParam = new BkgCstmsKrBlVO();
		BkgCstmsKrBlVO seqNSndHisKor = null;
		// 전송 SEQ 조회
		List<BkgCstmsKrBlVO> seqNSndHisKors = null;
		// BIZ No 조회
		KorBizNoVO korBizNoVO = new KorBizNoVO();
		// EL No 조회
		ElNoMakeVO elNoMakeVO = new ElNoMakeVO();
		// Trans Type 조회
		KorIbTransWhfVO ibTransWhfVO = null;
		KorObTransWhfVO obTransWhfVO = null;
		String transTypeStr = null;
		String transTypeChg = null;
		// Container Full Empty Check
		String cntrFe = null;
		// Ts Empty 관련 객체
		KorIbMtInfoVO korIbMtInfoVO = null;
//		KorCblVO korCblVO = new KorCblVO();
//		String cntr_kcd_tp = null;
		KorKcdVO korkcdVO = new KorKcdVO();
		String[] cust_kcd_tp = null;
		KorCblCntrVO cblCntrVO = null;
		String newCBlNo = null;

		String bbChk = null;
		String bbBkgNo = null;
		String bbBlNo = null;

		// 다운로드 전체 건수
		long totalDownloadCnt = 0;
		// 삭제 전체 건수
		long totalDeleteCnt = 0;
		// Mrn Number Modify 여부
		boolean ifModifyMrnNo = false;

		try {
			// InBound, OutBound 에 따른 PORT
			kt_port = condData.getInPod();
			if ("O".equals(condData.getInBound())) kt_port = condData.getInPol();

			// MRN No, Eta/Etd/Current Date 조회
			mrnVslSysEtaEtdCondVO.setInVvd	(condData.getInVvd()	);
			mrnVslSysEtaEtdCondVO.setInBound(condData.getInBound()	);
			mrnVslSysEtaEtdCondVO.setInPol	(condData.getInPol()	);
			mrnVslSysEtaEtdCondVO.setInPod	(condData.getInPod()	);
			// 조회
			mrnVslSysEtaEtdVO = dbDao.searchMrnVslSysDtEtaEtdDt(mrnVslSysEtaEtdCondVO);

			// 조회 결과가 없을 경우 MAX 값을 다시 조회
			if (mrnVslSysEtaEtdVO==null) {
				mrnVslSysEtaEtdVO = dbDao.searchMrnVslSysDtEtaEtdMaxDt(mrnVslSysEtaEtdCondVO);
			}

			// MRN 정보 셋팅
			condData.setMrnNo	(mrnVslSysEtaEtdVO.getMrnNo()	);
			condData.setMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());

			for (int idx=0; idx<condList.length; idx++) {
				KorManifestInfoVO node = condList[idx];
				// BL, BKG No 셋팅
				condData.setBlNo	(node.getBlNo()		);
				condData.setInBkgNo	(node.getBkgNo()	);
				createType = "N";

				// DOWNLOAD 여부 조회
				checkParam.setInBound	(condData.getInBound()	);
				checkParam.setVvdCd		(condData.getInVvd()	);
				checkParam.setPolLoc	(condData.getInPol()	);
				checkParam.setPodLoc	(condData.getInPod()	);
				checkParam.setBkgNo		(node.getABkgNo()		);
				checkParam.setKcdTp		(node.getTp()			);
				checkParam.setKtPort	(kt_port				);
				downCount = dbDao.searchDownHistCheck(checkParam);

				if (downCount==null || downCount.compareTo("0") == 0) {
					// 최초DownLoad
					kcd_tp = "T";

					node.setInVvd		(condData.getInVvd()		);
					node.setInBound		(condData.getInBound()		);
					node.setInBlno		(condData.getBlNo()			);
					node.setKtPort		(kt_port					);
					node.setMrnNbr		(condData.getMrnNo()		);
					node.setInPol		(condData.getInPol()		);
					node.setInPod		(condData.getInPod()		);
					node.setInPodTmnl	(condData.getInPodTmnl()	);
					node.setInPolTmnl	(condData.getInPolTmnl()	);
					korMainfestDNVOs = dbDao.searchDownManifestInfo(node);

					if (korMainfestDNVOs == null)	continue;

					for (int idxDn=0; idxDn < korMainfestDNVOs.length; idxDn++) {

						down = korMainfestDNVOs[idxDn];

						down_vvd_pol = down.getHidden1().substring(0, 5);
						down_vvd_pod = down.getHidden2().substring(0, 5);
						down_bkg_pol = down.getPol().substring(0, 5);
						down_bkg_pod = down.getPod().substring(0, 5);
						wh_whf_ind = "";

						if ("O".equals(condData.getInBound())) {
							//OutBound
							kt_port = down.getHidden1();

							if (down_vvd_pol.equals(down_bkg_pol)) {
								KorRateHeadVO rh = dbDao.searchExemptWhf(node.getBkgNo());
								if (rh == null) {
									kcd_tp = "E";
								} else {
									wh_whf_ind = rh.getWhfInd();
									kcd_tp = rh.getKcdTp();
								}
							} else {
								kcd_tp = "R";
							}

							//jjang
							if ( down_vvd_pol.equals(down_bkg_pol) ) {

								down.setCreatedType("B");
								createType = "B";

							} else if (!down_vvd_pol.equals(down_bkg_pol)) {
								down.setCreatedType("C");
								createType = "C";
							}


							if ("B".equals(condData.getSelType())) {
								if ("C".equals(down.getCreatedType())) continue;

							}
							if ("C".equals(condData.getSelType())) {
								if ("B".equals(down.getCreatedType())) continue;

								down.setBac("");
							}

							//String custType = dbDao.searchCustType(down.getABkgNo());
							String custType = down.getSc();

							if (down.getSc().equals("N")) {
								if (custType.equals("N")) down.setSc("C");
								if (custType.equals("B")) down.setSc("S");
							}
						} else {
							//InBound

							kt_port = down.getHidden2();

							if (down_vvd_pod.equals(down_bkg_pod)) {
								kcd_tp = "I";
								down.setTp("I");
							} else {
								if ("KRPUS".equals(down_vvd_pod) || "KRKAN".equals(down_vvd_pod)) {
									if (down.getPod().startsWith("KR"))  {
										kcd_tp = "I";
										down.setTp("I");
									} else {
										kcd_tp = "T";
										down.setTp("T");
									}
								} else {
									kcd_tp = "T";
									down.setTp("T");
								}
							}
							//InBound의 경우 CreatedType은 항상 N
//							down.setCreatedType("N");
//							createType = "N";

							if("P".equals(down.getFe())){
								if(kcd_tp.equals("T")){
									down.setCreatedType("T");
									createType = "T";
								}else{
									down.setCreatedType("M");
									createType = "M";
								}

							}else{
								if(kcd_tp.equals("T")){
									down.setCreatedType("R");
									createType = "R";
								}else{
									down.setCreatedType("A");
									createType = "A";
								}

							}

							if ("N".equals(condData.getSelType())) {
								down.setCreatedType("N");
								createType = "N";

							}

							down.setFfordCd(" ");


//							if ("P".equals(down.getFe())) {
//								down.setCreatedType("M");
//								createType = "M";
//							} else {
//								down.setCreatedType("N");
//								createType = "N";
//							}
//							down.setFfordCd(" ");
						}

						dangerInfo = dbDao.searchDangerInfo(down.getABkgNo(), down.getABkgNoSplit());
						korBkgCntrVOs = dbDao.searchBKGCNTRList(down.getABkgNo(), down.getABkgNoSplit());

						if ("P".equals(down.getFe()) || "R".equals(down.getFe())) {
							cntrFe = "E";
						} else {
							cntrFe = "F";
						}

						if ("R".equals(kcd_tp) && !"Y".equals(wh_whf_ind))	down.setSc("S");

						exportList = null;
						if ("E".equals(kcd_tp) && "S".equals(down.getSc())) {
							//OutBound Simple일 경우
							exportList = dbDao.searchExportInfoDNList(down.getABkgNo(), down.getABkgNoSplit());
						}

						custInfoList = dbDao.searchCustomerInfoList(down.getABkgNo(), down.getABkgNoSplit());


						cargoParam.setABkgNo(down.getABkgNo());
						cargoParam = dbDao.searchCargoDescDN(cargoParam);

						if ("I".equals(kcd_tp) || "T".equals(kcd_tp)) 		kt_port = down.getHidden2();  //vvd_pod = Hidden2
						else if ("E".equals(kcd_tp) || "R".equals(kcd_tp)) 	kt_port = down.getHidden1();	//vvd_pol = Hidden1

						String expt_kcd_tp = "";
						String temp_kcd_type = "";

						// 추가된 컨테이너 번호가 존재하고 KCD_TP 가 E이거나 R이면
						korIbMtInfoVO = null;
						if (down.getCntrNo() != null && down.getCntrNo().length() > 1 &&
							(kcd_tp.equals("E") || kcd_tp.equals("R")) ) {
							korIbMtInfoVO = dbDao.searchIbTsMtInfo(down.getCntrNo());

							// 조회 결과 세팅
							if (korIbMtInfoVO != null && korIbMtInfoVO.getInCgoTp().equals("P")) {

								down.setIbMtyBkgNo		(korIbMtInfoVO.getInBkg()	);
								down.setIbMtyBlNo		(korIbMtInfoVO.getInCBl()	);
								down.setIbTrnsSeq		(korIbMtInfoVO.getInSeq()	);
								down.setIbCstmsDeclTpCd	(korIbMtInfoVO.getInTpCd()	);
								down.setIbDmstPortCd	(korIbMtInfoVO.getInPort()	);
								down.setIbVslCd			(korIbMtInfoVO.getInVsl()	);
								down.setIbSkdVoyNo		(korIbMtInfoVO.getInVoy()	);
								down.setIbSkdDirCd		(korIbMtInfoVO.getInDir()	);
								down.setIbEtaDt			(korIbMtInfoVO.getInEta()	);
							}

						}

						// 전송된 데이터의 SEQ 조회
						seqNSndHistParam.setBkgNo		(down.getABkgNo()		);
						if (korIbMtInfoVO != null && korIbMtInfoVO.getInCgoTp().equals("P")) {
							seqNSndHistParam.setKcdTp	("R"					);
						} else {
							seqNSndHistParam.setKcdTp	(kcd_tp					);
						}
						seqNSndHistParam.setKtPort		(kt_port				);
						seqNSndHistParam.setCBlNo		(down.getCBlNo()		);
						seqNSndHisKors = dbDao.searchSeqNSndHistKor(seqNSndHistParam);

						int i_seq = 0;
						if (seqNSndHisKors != null) {
							if (seqNSndHisKors.size() > 0) {
								seqNSndHisKor = seqNSndHisKors.get(0);
								String seq = seqNSndHisKor.getKtSeq();
								String chk = seqNSndHisKor.getKtSndDtChk();

								if (seq==null || "".equals(seq)) seq = "0";
								if (chk==null || "".equals(chk)) chk = "0";

								i_seq = Integer.parseInt(seq);
								int i_chk = Integer.parseInt(chk);
								// FE 가 P 가 아니거나 P 이면 idxDN이 0인 경우만 처리
								if (!down.getFe().equals("P") || (down.getFe().equals("P") && idxDn==0)) {
									if (i_seq > 0 && i_chk == 0) continue;
								}
							}
						}

						if (i_seq > 0) {

							// TransType 및 ExemptWhf 조회
							if ("O".equals(condData.getInBound())) {
								// OUT-Bound 시
								obTransWhfVO = new KorObTransWhfVO();
								obTransWhfVO.setBkgNo	(down.getABkgNo()		);
								obTransWhfVO.setKcdTp	(kcd_tp					);
								obTransWhfVO.setKtSeq	(String.valueOf(i_seq)	);
								obTransWhfVO.setKtPort	(kt_port				);
								obTransWhfVO = dbDao.searchObTransTpExpWhf(obTransWhfVO);

								// 조회 값 저장
								if (obTransWhfVO != null) {
									temp_kcd_type = obTransWhfVO.getTransType();
									expt_kcd_tp   = obTransWhfVO.getExptKcdTp();
								}
							} else {
								// IN-Bound 시
								ibTransWhfVO = new KorIbTransWhfVO();
								ibTransWhfVO.setBkgNo	(down.getABkgNo()		);
								ibTransWhfVO.setKcdTp	(kcd_tp					);
								ibTransWhfVO.setKtSeq	(String.valueOf(i_seq)	);
								ibTransWhfVO.setKtPort	(kt_port				);
								ibTransWhfVO = dbDao.searchIbTransTpExpWhf(ibTransWhfVO);

								// 조회 값 저장
								if (ibTransWhfVO != null) {
									temp_kcd_type = ibTransWhfVO.getTransType();
									expt_kcd_tp   = ibTransWhfVO.getExptKcdTp();
								}
							}

							if (temp_kcd_type != null) {
								if (!temp_kcd_type.equals(kcd_tp) && !"".equals(temp_kcd_type)) {
									kcd_tp = temp_kcd_type;
								}
							}

							if ("R".equals(expt_kcd_tp) || "T".equals(expt_kcd_tp)) {
								kcd_tp = expt_kcd_tp;
							}
						}

						// FE 가 P가 아니거나 P 이면서 처음1건만 + 처리
						if (!down.getFe().equals("P") || (down.getFe().equals("P") && kt_port.equals("KRPUS") && idxDn==0)
							|| (down.getFe().equals("P") && !kt_port.equals("KRPUS"))
							|| (i_seq == 0) ) i_seq++;

						// 추가된 컨테이너 번호가 존재하고 KCD_TP 가 E이거나 R이면
						if (down.getCntrNo() != null && down.getCntrNo().length() > 1 &&
							(kcd_tp.equals("E") || kcd_tp.equals("R")) ) {
							// 조회 결과 세팅
							if (korIbMtInfoVO != null) {
								// 값이 존재하고 IN_CGO_TP가 P 이면 EXPT_KCD_TP를 R로 변경
								if (korIbMtInfoVO.getInCgoTp().equals("P")) expt_kcd_tp = "R";
							}
						}

						down.setAImoClass1(dangerInfo[0]);
						down.setAImoClass2(dangerInfo[1]);
						down.setAImoClass3(dangerInfo[2]);
						down.setDesc1(cargoParam.getDescCode1());
						down.setDesc2(cargoParam.getDescCode2());
						down.setKtSeq(Integer.toString(i_seq));
						down.setKcdTp(kcd_tp);
						down.setExptKcdTp(expt_kcd_tp);
						down.setKtPort(kt_port);
						down.setUsBound(down.getCreatedType());
						down.setUsername(account.getUsr_id());
						down.setVvdCd(condData.getInVvd());
						down.setVvdPod(down.getHidden2());
						down.setVvdPol(down.getHidden1());
						down.setBkgPol(node.getPol());
						down.setBkgPod(node.getPod());
						down.setMsnBltp(down.getSc());
						down.setBkgCgoTp(down.getFe());

						down.setBkgPkgCd(node.getPckTpCd());
						down.setBkgActwgtTp(node.getWgtUtCd());
						down.setBkgActwgtTp(down.getWgtUtCd());
						down.setBkgMeaTp(node.getMeasUtCd());
						//cmdt_rep
						down.setCmdtRep(down.getCm());
						down.setBondAreaCode(down.getBac());
						down.setWhouse(down.getWh());
						down.setWhouseDesc(down.getWhdesc());

						down.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
						down.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());
						down.setKtSts("");
						down.setSelType(node.getSelType());

						bbChk = dbDao.searchBreakBulkCheck(checkParam);  //break bulk 포함 여부 체크

						if (bbChk.compareTo("2") == 0) {

							String tBkgNo = down.getBkgNo();
							String tBlNo = down.getBlNo();
							String tCBlNo = down.getCBlNo();
							String tBkgCgoTp = down.getBkgCgoTp();
//							String tExptKcdTp = down.getExptKcdTp();
							String tPckQty = down.getPckQty();
							String tActWgt = down.getActWgt();
							String tMeasQty = down.getMeasQty();
							String tMsnBltp = down.getMsnBltp();
//							String tKcdTp = down.getKcdTp();
							String tCgoDesc1 = down.getDesc1();
							String tCgoDesc2 = down.getDesc2();
							String tCmdtRep = down.getCmdtRep();
							String tMsn = down.getMsn();
							String tBoundAreaCode = down.getBondAreaCode();
							String tWhouse = down.getWhouse();

							down.setBkgCgoTp("B");	  //Cargo Type: Break Bulk, Bulk WGT, Bulk MEA 추가
							dbDao.addBlInfoKor(down); // 기존  bkg no 생성 BKG_CSTMS_KR_BL

//							bbBkgNo = dbDao.searchFirstTmpBkgNoAssign(account.getOfc_cd(), account.getUsr_id());
//							bbBlNo = dbDao.searchFirstTmpBlNoAssign();

							bbBlNo = "SEM"+tBlNo.substring(3);
							bbBkgNo = bbBlNo;

							down.setBkgNo(bbBkgNo);
//							down.setBlNo(bbBlNo);
							down.setCBlNo(bbBlNo);
							down.setBkgCgoTp("R");
//							down.setExptKcdTp("E");
							down.setPckQty("0");
							down.setActWgt("0");
							down.setMeasQty("0");
							down.setMsnBltp("E");
//							down.setKcdTp("E");
							down.setDesc1("EMPTY CONTAINER");
							down.setDesc2("");
							down.setCmdtRep("860900");

							if (!"O".equals(condData.getInBound())) {
								down.setMsn("");
								down.setBondAreaCode("ST03077006");
								down.setWhouse("R");
							}


							dbDao.addBlInfoKor(down); //신규 bkg no, 신규bl no로 생성 BKG_CSTMS_KR_BL

							down.setBkgNo(tBkgNo);
//							down.setBlNo(tBlNo);
							down.setCBlNo(tCBlNo);
							down.setBkgCgoTp(tBkgCgoTp);
//							down.setExptKcdTp(tExptKcdTp);
							down.setPckQty(tPckQty);
							down.setActWgt(tActWgt);
							down.setMeasQty(tMeasQty);
							down.setMsnBltp(tMsnBltp);
//							down.setKcdTp(tKcdTp);
							down.setDesc1(tCgoDesc1);
							down.setDesc2(tCgoDesc2);
							down.setCmdtRep(tCmdtRep);

							if (!"O".equals(condData.getInBound())) {
								down.setMsn(tMsn);
								down.setBondAreaCode(tBoundAreaCode);
								down.setWhouse(tWhouse);
							}


						} else {
							dbDao.addBlInfoKor(down);
						}

						totalDownloadCnt++;

//						// C_BL 별 KCD_TP 재조회
//						korCblVO.setBkgNo		(down.getABkgNo()	);
//						korCblVO.setTrnsSeq		(down.getKtSeq()	);
//						korCblVO.setDmstPortCd	(down.getKtPort()	);
//						korCblVO.setCBlNo		(down.getCBlNo()	);
//						korCblVO.setVvd			(down.getVvdCd()	);
//
//						cntr_kcd_tp = dbDao.searchCblKcdTp(korCblVO);

						if (bbChk.equals("2")) {	   //Break Bulk와 섞여 있는 경우

							if (down.getFe().equals("P") && down.getKtPort().equals("KRPUS")) {
								paramNode = korBkgCntrVOs.get(idxDn);
								if (paramNode.getBBbCgoFlg().equals("Y")) {
									param1.setBkgNo		(bbBkgNo					);
									param1.setCBlNo		(bbBlNo						);
									param1.setFeInd		("E"						);
									param1.setCntrPkgQty("0"						);
									param1.setCntrWgtQty("0"						);
									param1.setCntrMeaQty("0"						);
									param1.setSealNo1	("");
									param1.setSealNo2	("");
								} else {
									param1.setBkgNo		(down.getABkgNo()			);
									param1.setCBlNo		(down.getCBlNo()			);
									param1.setFeInd		(cntrFe						);
									param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
									param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
									param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
									param1.setSealNo1	(paramNode.getBCntrSealNo1());
									param1.setSealNo2	(paramNode.getBCntrSealNo2());
								}

								param1.setKtSeq		(down.getKtSeq()			);
								param1.setBkgNoSplit(down.getABkgNoSplit()		);
								param1.setExptKcdTp	(expt_kcd_tp				);
//								param1.setKcdTp		(cntr_kcd_tp				);
								param1.setKcdTp		(kcd_tp      				);
								param1.setCntrNo	(paramNode.getBCntrNo()		);
								param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
								param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
								param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
								param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
								param1.setKtPort	(kt_port					);
								param1.setUsername	(account.getUsr_id()		);

								dbDao.addCNTRInfoKor(param1);

							} else {

								for (int j=0;j<korBkgCntrVOs.size();j++) {
									paramNode = korBkgCntrVOs.get(j);

									if (paramNode.getBBbCgoFlg().equals("Y")) {
										param1.setBkgNo		(bbBkgNo					);
										param1.setCBlNo		(bbBlNo			            );
										param1.setFeInd		("E"						);
										param1.setCntrPkgQty("0"						);
										param1.setCntrWgtQty("0"						);
										param1.setCntrMeaQty("0"						);
										param1.setSealNo1	("");
										param1.setSealNo2	("");
									} else {
										param1.setBkgNo		(down.getABkgNo()			);
										param1.setCBlNo		(down.getCBlNo()			);
										param1.setFeInd		(cntrFe						);
										param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
										param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
										param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
										param1.setSealNo1	(paramNode.getBCntrSealNo1());
										param1.setSealNo2	(paramNode.getBCntrSealNo2());
									}
										param1.setKtSeq		(down.getKtSeq()			);
										param1.setBkgNoSplit(down.getABkgNoSplit()		);
										param1.setExptKcdTp	(expt_kcd_tp				);
//										param1.setKcdTp		(cntr_kcd_tp				);
										param1.setKcdTp		(kcd_tp      				);
										param1.setCntrNo	(paramNode.getBCntrNo()		);
										param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
										param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
										param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
										param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
										param1.setKtPort	(kt_port					);
										param1.setUsername	(account.getUsr_id()		);

										dbDao.addCNTRInfoKor(param1); //기존 컨테이너 추가

									}
								}

							param1.setBkgNo		(down.getABkgNo()			);
							param1.setCBlNo		(down.getCBlNo()			);
							param1.setKtSeq		(down.getKtSeq()			);
							param1.setBkgNoSplit(down.getABkgNoSplit()		);
							param1.setKtPort	(kt_port					);
							param1.setUsername	(account.getUsr_id()		);
							param1.setExptKcdTp	(expt_kcd_tp				);
							param1.setKcdTp		(kcd_tp      				);
							param1.setCntrNo	("IN BULK");
							param1.setFeInd		("");
							param1.setCntrPkgQty("0");
							param1.setCntrWgtQty("0");
							param1.setCntrMeaQty("0");
//							param1.setKcdTp		(cntr_kcd_tp				);
							param1.setSealNo1	("");
							param1.setSealNo2	("");
							param1.setCntrtsCd	("");
							param1.setCntrPkgCd	("");
							param1.setCntrWgtTp	("");
							param1.setCntrMeaTp	("");


							dbDao.addCNTRInfoKor(param1);


						} else {		//break Bulk가 섞여 있지 않은 경우
						// Empty BL 인경우 CNTR는 하나씩 할당
						//down.getFe().equals("X") 로 한 이유: 과거 cntr 1개당 b/1 1개 생성 했던 로직, 2014 07 부로 로직 제거, 일단 안타게.
						if (down.getFe().equals("X") && down.getKtPort().equals("KRPUS")) {
							paramNode = korBkgCntrVOs.get(idxDn);

							param1.setKtSeq		(down.getKtSeq()			);
							param1.setBkgNo		(down.getABkgNo()			);
							param1.setBkgNoSplit(down.getABkgNoSplit()		);
							param1.setExptKcdTp	(expt_kcd_tp				);
//							param1.setKcdTp		(cntr_kcd_tp				);
							param1.setKcdTp		(kcd_tp      				);
							param1.setCntrNo	(paramNode.getBCntrNo()		);
							param1.setFeInd		(cntrFe						);
							param1.setSealNo1	(paramNode.getBCntrSealNo1());
							param1.setSealNo2	(paramNode.getBCntrSealNo2());
							param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
							param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
							param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
							param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
							param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
							param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
							param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
							param1.setKtPort	(kt_port					);
							param1.setUsername	(account.getUsr_id()		);
							param1.setCBlNo		(down.getCBlNo()			);

							dbDao.addCNTRInfoKor(param1);

						} else {

							for (int j=0;j<korBkgCntrVOs.size();j++) {

								paramNode = korBkgCntrVOs.get(j);

									param1.setKtSeq		(down.getKtSeq()			);
									param1.setBkgNo		(down.getABkgNo()			);
									param1.setBkgNoSplit(down.getABkgNoSplit()		);
									param1.setExptKcdTp	(expt_kcd_tp				);
//									param1.setKcdTp		(cntr_kcd_tp				);
									param1.setKcdTp		(kcd_tp      				);
									param1.setCntrNo	(paramNode.getBCntrNo()		);
									param1.setFeInd		(cntrFe						);
									param1.setSealNo1	(paramNode.getBCntrSealNo1());
									param1.setSealNo2	(paramNode.getBCntrSealNo2());
									param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
									param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
									param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
									param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
									param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
									param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
									param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
									param1.setKtPort	(kt_port					);
									param1.setUsername	(account.getUsr_id()		);
									param1.setCBlNo		(down.getCBlNo()			);

									dbDao.addCNTRInfoKor(param1); //기존 컨테이너 추가

								}

							}

						} //break Bulk가 섞여 있지 않은 경우

							if (!"MAIL BOX".equals(cargoParam.getDescCode1())) {
								if ("O".equals(condData.getInBound())) {
									if ("R".equals(kcd_tp)) {
										KorElNoKorVO elNoVO = new KorElNoKorVO();
										elNoVO.setBkgNo(down.getABkgNo());
										elNoVO.setBkgNoSplit(down.getABkgNoSplit());
										elNoVO.setKtPort(kt_port);
										String elNo = dbDao.searchElNoKor(elNoVO);
										if (elNo != null) {
											KorMailBoxVO korMailBoxVO = new KorMailBoxVO();
											korMailBoxVO.setBmeElno(elNo);
											korMailBoxVO.setBkgNo(down.getABkgNo());
											korMailBoxVO.setExptKdTp(expt_kcd_tp);
											korMailBoxVO.setKcdTp(kcd_tp);
											korMailBoxVO.setKtSeq(Integer.toString(i_seq));
											korMailBoxVO.setKtPort(kt_port);
											korMailBoxVO.setBkgPkgQty("");
											korMailBoxVO.setBkgActwgtQty(down.getActWgt());
											korMailBoxVO.setBkgActwgtTp(down.getWgtUtCd());
											korMailBoxVO.setBkgPkgQty(down.getPckQty());
											korMailBoxVO.setBkgPkgCd(down.getPckTpCd());
											korMailBoxVO.setCBlNo(down.getCBlNo());
											korMailBoxVO.setUsername(account.getUsr_id());
											dbDao.addExportNo(korMailBoxVO);



										} else {

											/*
											 * 2010년 6월 29일 화요일 경종윤
											 * 수출 T/S 화물의 면장은 아래와 같이 Other Reference No에 입력하면 적하목록 Download 시   Export License coulmn에 적용이 되게 적용
											 * (elNo 값이 없을시 TS_REF_NO값으로 대체한다.
											 */
											List<KorExportInfoDNVO> exportList1 = null;
											exportList1 = dbDao.searchExportInfoDNList(down.getABkgNo(), down.getABkgNoSplit());

											if (exportList1 != null && exportList1.size() > 0) {

												elNo = exportList1.get(0).getEBmeElno();
												if (elNo != null && elNo.length() > 0) {

													KorMailBoxVO korMailBoxVO = new KorMailBoxVO();
													korMailBoxVO.setBmeElno(elNo);
													korMailBoxVO.setBkgNo(down.getABkgNo());
													korMailBoxVO.setExptKdTp(expt_kcd_tp);
													korMailBoxVO.setKcdTp(kcd_tp);
													korMailBoxVO.setKtSeq(Integer.toString(i_seq));
													korMailBoxVO.setKtPort(kt_port);
													korMailBoxVO.setBkgPkgQty("");
													korMailBoxVO.setBkgActwgtQty(down.getActWgt());
													korMailBoxVO.setBkgActwgtTp(down.getWgtUtCd());
													korMailBoxVO.setBkgPkgQty(down.getPckQty());
													korMailBoxVO.setBkgPkgCd(down.getPckTpCd());
													korMailBoxVO.setCBlNo(down.getCBlNo());
													korMailBoxVO.setUsername(account.getUsr_id());
													dbDao.addExportNo(korMailBoxVO);
												}
											}
										}
									}
								}
							} else {

								KorMailBoxVO korMailBoxVO = new KorMailBoxVO();
								korMailBoxVO.setBkgNo(down.getABkgNo());
								korMailBoxVO.setExptKdTp(expt_kcd_tp);
								korMailBoxVO.setKcdTp(kcd_tp);
								korMailBoxVO.setKtSeq(Integer.toString(i_seq));
								korMailBoxVO.setKtPort(kt_port);
								korMailBoxVO.setBkgPkgQty("");
								korMailBoxVO.setBkgActwgtQty(down.getActWgt());
								korMailBoxVO.setBkgActwgtTp(down.getWgtUtCd());
								korMailBoxVO.setBkgPkgQty(down.getPckQty());
								korMailBoxVO.setBkgPkgCd(down.getPckTpCd());
								korMailBoxVO.setBmeElno("NCV");
								korMailBoxVO.setUsername(account.getUsr_id());
								korMailBoxVO.setCBlNo(down.getCBlNo());
								dbDao.addExportNoMailBoxKor(korMailBoxVO);
							}


						if (exportList != null) {
							for (int j=0;j<exportList.size(); j++) {
								KorExportInfoDNVO exportNode = exportList.get(j);
								// ELNO 가 없으면 SKIP 처리
								if (exportNode.getEBmeElno()==null || exportNode.getEBmeElno().trim().length() < 1) continue;
								BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
								exportNoParam.setBkgNo	   (down.getABkgNo()			);
								exportNoParam.setExptKcdTp (expt_kcd_tp					);
								exportNoParam.setKcdTp	   (kcd_tp						);
								exportNoParam.setKtSeq	   (Integer.toString(i_seq)		);
								exportNoParam.setKtPort	   (kt_port						);
								exportNoParam.setBmeElno   (exportNode.getEBmeElno()	);
								exportNoParam.setBmePkgQty (exportNode.getEBmePkgQty()	);
								exportNoParam.setBmePkgCd  (exportNode.getEBmePkgTp()	);
								exportNoParam.setBmeWgtQty (exportNode.getEBmeWgtQty()	);
								exportNoParam.setBmeWgtTp  (exportNode.getEBmeWgtTp()	);
								exportNoParam.setBmeDivInd (exportNode.getEBmeDivInd()	);
								exportNoParam.setBmeDivSeq (exportNode.getEBmeDivSeq()	);
								exportNoParam.setBmeDpkgQty(exportNode.getEBmeDpkgQty()	);
								exportNoParam.setBmeDpkgCd (exportNode.getEBmeDpkgTp()	);
								exportNoParam.setBmeDwgtQty(exportNode.getEBmeDwgtQty()	);
								exportNoParam.setBmeDwgtTp (exportNode.getEBmeDwgtTp()	);
								exportNoParam.setBmeSmpSeq (exportNode.getEBmeSmpSeq()	);
								exportNoParam.setCBlNo	   (down.getCBlNo()          	);
								exportNoParam.setUsername  (account.getUsr_id()			);
								dbDao.addExportNoKor(exportNoParam);
							}
						}


						String biz_CntCd = "";
						String biz_CustCd = "";
						/*
						 *
						 * Congignee Name이 TO THE ORDER OF 이면
						 * Notify의 상호를 biz no로 셋팅 하기 위한 변수
						 */
						boolean notifyBzNoFlag = false;

						// KCD_TP 재조회
						korkcdVO.setBkgNo		(down.getABkgNo()	);
						korkcdVO.setTrnsSeq		(down.getKtSeq()	);
						korkcdVO.setDmstPortCd	(down.getKtPort()	);
						korkcdVO.setVvd			(down.getVvdCd()	);
						cust_kcd_tp = dbDao.searchKcdTpCust(korkcdVO);


						if (custInfoList != null) {

							for (int j=0;j<custInfoList.size();j++) {
								KorBkgCustVO custNode = custInfoList.get(j);
								BkgCstmsKrCustVO custParam = new BkgCstmsKrCustVO();
								custParam.setInBound(condData.getInBound());


								if ("S".equals(custNode.getCBcsTp()) && " ".equals(custNode.getCCustAddr())) {
									custNode.setCCustAddr(".");
								}

								if (cust_kcd_tp != null) {
									// 조회된 KCD_TP 만큼 LOOP
									for (int k=0; k < cust_kcd_tp.length; k++) {

										custParam.setBkgNo(down.getABkgNo());
										custParam.setExptKcdTp(expt_kcd_tp);
										custParam.setKcdTp(cust_kcd_tp[k]);
										custParam.setKtSeq(Integer.toString(i_seq));
										custParam.setBcsTp(custNode.getCBcsTp());
										custParam.setCntCd(custNode.getCCntCd());
										custParam.setCustCd(custNode.getCCustCd());
										custParam.setBkgCgoTp(down.getFe());

										custParam.setCustName(custNode.getCCustName().replaceAll("\n", " "));
										custParam.setCustAddr(custNode.getCCustAddr().replaceAll("\n", " "));
										custParam.setCustTel(custNode.getCCustTel());
										custParam.setKtPort(kt_port);
										custParam.setUsername(account.getUsr_id());


										// 존재여부를 체크하여 있으면 skip
										KorCustExistVO custExistVO = new KorCustExistVO();
										custExistVO.setBkgNo(down.getABkgNo());
										if (expt_kcd_tp != null && (expt_kcd_tp.equals("R") || expt_kcd_tp.equals("T")) ) {
											custExistVO.setCstmsDeclTpCd(expt_kcd_tp);
										} else {
											custExistVO.setCstmsDeclTpCd(cust_kcd_tp[k]);
										}
										custExistVO.setDmstPortCd(kt_port);
										custExistVO.setTrnsSeq(String.valueOf(i_seq));
										custExistVO.setBkgCustTpCd(custNode.getCBcsTp());
										String custCnt = dbDao.searchCustExistCnt(custExistVO);
										if ( custCnt.equals("0") ) dbDao.addCustInfoKor(custParam);

										if (bbChk.equals("2")) {
											custExistVO.setBkgNo(bbBkgNo);
											custParam.setBkgNo(bbBkgNo);
											String bcustCnt = dbDao.searchCustExistCnt(custExistVO);
											if ( bcustCnt.equals("0") ) dbDao.addBbCustInfoKor(custParam);
										}

									}
								}


								if ("E".equals(kcd_tp) || "R".equals(kcd_tp)) {
									if ("S".equals(custNode.getCBcsTp())) {
										biz_CntCd = custParam.getCntCd();
										biz_CustCd = custParam.getCustCd();
									}
								} else {
									if ("C".equals(custNode.getCBcsTp())) {
										biz_CntCd = custParam.getCntCd();
										biz_CustCd = custParam.getCustCd();

										/**
										 * 2010.11.15 경종윤 [CHM-201007078] 화주의 사업자등록번호 기재 보완요청
										 * 2011.11.15 김현화 [] TO THE ORDER OF 에서 ORDER로 변경 -AA안정선
										 */

										if (Pattern.compile(".*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNode.getCCustName().toUpperCase()).matches()) {
									  //if (custNode.getCCustName().toUpperCase().trim().startsWith("TO THE ORDER OF")) {
											notifyBzNoFlag = true;
										}
									}

									if (biz_CntCd.length() < 2 || notifyBzNoFlag) {
										if ("N".equals(custNode.getCBcsTp())) {
											biz_CntCd = custParam.getCntCd();
											biz_CustCd = custParam.getCustCd();
										}
									}
								}
							}//for (int j=0;j<custInfoList.size();j++)
						}//if (custInfoList != null)



						BkgRateVO voParam = new BkgRateVO();
						voParam.setBkgNo(down.getABkgNo());

						String biz_no = "";
						if ("E".equals(kcd_tp) || "R".equals(kcd_tp)) {
							biz_no = dbDao.searchBizNo(voParam);
						}

						if ("".equals(biz_no) || biz_no == null) {
							if (biz_CntCd.length() == 2) {
								korBizNoVO.setBizCntCd(biz_CntCd);
								korBizNoVO.setBizCustCd(biz_CustCd);
								biz_no = dbDao.searchCustRegNo(korBizNoVO);
							}
						}



						if (!"".equals(biz_no)) {
							BkgCstmsKrBlVO updParam = new BkgCstmsKrBlVO();
							updParam.setBizNo(biz_no);
							updParam.setBkgNo(down.getABkgNo());
							updParam.setBkgNoSplit(down.getABkgNoSplit());
							updParam.setKcdTp(kcd_tp);
							updParam.setExptKcdTp(expt_kcd_tp);
							updParam.setKtPort(kt_port);
							updParam.setKtSeq(Integer.toString(i_seq));
							updParam.setUsername(account.getUsr_id());
							dbDao.modifyBizNo(updParam);
							if (bbChk.equals("2")) {
								updParam.setBkgNo(bbBkgNo);
								dbDao.modifyBizNo(updParam);

							}
						}

						paramVO.setNewMrnNo(mrnVslSysEtaEtdVO.getMrnNo());
						paramVO.setNewMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());
						paramVO.setVvdCd(condData.getInVvd());
						paramVO.setBound(condData.getInBound());
						if (mrnVslSysEtaEtdVO.getEtaDt() != null) {
							paramVO.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
							paramVO.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());
						} else {
							paramVO.setEtaDt(mrnVslSysEtaEtdVO.getActionTime());
							paramVO.setEtdDt(mrnVslSysEtaEtdVO.getActionTime());
						}

						paramVO.setVslCallSign(mrnVslSysEtaEtdVO.getVslCallSign());
						paramVO.setVslEngNm(mrnVslSysEtaEtdVO.getVslEngNm());
						paramVO.setVslFlag(mrnVslSysEtaEtdVO.getVslFlag());
						paramVO.setJointCnt("3");
						paramVO.setVvdPodTmnlCd(down.getVvdPodTmnlCd().trim());
						paramVO.setVvdPolTmnlCd(down.getVvdPolTmnlCd().trim());
						paramVO.setUsername(account.getUsr_id());
						paramVO.setMrnPort(kt_port);
						paramVO.setCreatedtype(createType);

						String max_seq = "";

						KorBkgCstmsVvdSmryVO korBkgCstmsVvdSmryVO = new KorBkgCstmsVvdSmryVO();
						korBkgCstmsVvdSmryVO.setVvdCd		(condData.getInVvd()			);
						korBkgCstmsVvdSmryVO.setMrnPort		(kt_port						);
						korBkgCstmsVvdSmryVO.setBound		(condData.getInBound()			);
						korBkgCstmsVvdSmryVO.setNewMrnNo	(mrnVslSysEtaEtdVO.getMrnNo()	);
						korBkgCstmsVvdSmryVO.setNewMrnChkNo	(mrnVslSysEtaEtdVO.getMrnChkNo());
						korBkgCstmsVvdSmryVO.setCreatedtype	(createType						);
						korBkgCstmsVvdSmryVO.setInBound		(condData.getInBound()			);
						korBkgCstmsVvdSmryVO.setPodTml		(down.getVvdPodTmnlCd()			);
						korBkgCstmsVvdSmryVO.setPolTml		(down.getVvdPolTmnlCd()			);
						max_seq = dbDao.searchMaxSeqVVDKor(korBkgCstmsVvdSmryVO);

						if (max_seq == null || max_seq.equals("")) max_seq = "0";
						int i_max_seq = Integer.parseInt(max_seq);

						if (i_max_seq == 0) {
							i_max_seq ++;
							paramVO.setKvSeq(Integer.toString(i_max_seq));

							dbDao.addVVDInfo(paramVO);
						} else if (i_max_seq > 0) {
							String y_chk = dbDao.searchMaxSeqVVDYard(paramVO);
							if ("N".equals(y_chk)) {
								i_max_seq ++;
								paramVO.setKvSeq(Integer.toString(i_max_seq));
								dbDao.addVVDInfo(paramVO);
							} else {
								String mf_snd_dt = dbDao.searchMaxSendCheckKor(paramVO);
								if ("Y".equals(mf_snd_dt)) {
									i_max_seq ++;
									paramVO.setKvSeq(Integer.toString(i_max_seq));
									dbDao.addVVDInfo(paramVO);
								}
							}
						}

					} // END DOWNLOAD INFO LOOP
				} else {
					//ReDownLoad
					kcd_tp = "";
					wh_whf_ind = "";
					condData.setKtPort(kt_port);
					List<KorManifestInfoVO> reDownList = dbDao.searchReManifestInfoList(condData);
					if (reDownList == null) continue;

//					reDownList.get(0).getWhouse().length();

					KorBkgCstmsVvdSmryVO mrnKorParam = new KorBkgCstmsVvdSmryVO();
					KorBkgCstmsVvdSmryVO oldMrnKor = new KorBkgCstmsVvdSmryVO();;

					if (ifModifyMrnNo==false) {
						mrnKorParam.setVvdCd(condData.getInVvd());
						mrnKorParam.setMrnPort(kt_port);
						mrnKorParam.setBound(condData.getInBound());
						oldMrnKor = dbDao.searchMrnKor(mrnKorParam);

						if (oldMrnKor != null) {
							oldMrnKor.setVvdCd(condData.getInVvd());
							oldMrnKor.setMrnPort(kt_port);
							oldMrnKor.setBound(condData.getInBound());
							oldMrnKor.setNewMrnNo(mrnVslSysEtaEtdVO.getMrnNo());
							oldMrnKor.setNewMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());

							if (!oldMrnKor.getOldMrnNo().trim().equals(mrnVslSysEtaEtdVO.getMrnNo().trim())) {
								int updateCount = dbDao.modifyMrnNoKor(oldMrnKor);
								String sHisSeq  = dbDao.searchMaxSeqDownHistKor(mrnVslSysEtaEtdVO.getMrnNo()+mrnVslSysEtaEtdVO.getMrnChkNo(), condData.getInVvd());
								KorDownHistVO korDownHistVO = new KorDownHistVO();
								korDownHistVO.setMrnNbr(mrnVslSysEtaEtdVO.getMrnNo());
								korDownHistVO.setMrnChk(mrnVslSysEtaEtdVO.getMrnChkNo());
								korDownHistVO.setVvdCd(condData.getInVvd());
								korDownHistVO.setKdhSeq(sHisSeq);
								korDownHistVO.setBound(condData.getInBound());
								korDownHistVO.setMrnPort(kt_port);
								korDownHistVO.setActionTime(mrnVslSysEtaEtdVO.getActionTime());
								korDownHistVO.setOffice(account.getOfc_cd());
								korDownHistVO.setUsername(account.getUsr_id());
								korDownHistVO.setMrnUpdateCnt(Integer.toString(updateCount));
								dbDao.addDownHist(korDownHistVO);
								ifModifyMrnNo = true;
							}
						}
					}

					for (int idxDn =0; idxDn < reDownList.size(); idxDn++) {
						reDownNode = reDownList.get(idxDn);

						bbChk = dbDao.searchBreakBulkCheck(checkParam);  //[ReDownload]break bulk 포함 여부 체크

						if (condData.getInPodTmnl().length() == 7) reDownNode.setInPodTmnl(condData.getInPodTmnl());
						if (condData.getInPolTmnl().length() == 7) reDownNode.setInPolTmnl(condData.getInPolTmnl());
						// NODE 값 적용
						reDownNode.setPckTpCd(node.getPckTpCd());
						reDownNode.setPckQty(node.getPckQty());
						reDownNode.setWgtValue(node.getWgtValue());

						down_vvd_pol = reDownNode.getHidden1().substring(0, 5);
						down_vvd_pod = reDownNode.getHidden2().substring(0, 5);
						down_bkg_pol = reDownNode.getPol().substring(0, 5);
						down_bkg_pod = reDownNode.getPod().substring(0, 5);

						if ("O".equals(condData.getInBound())) {

							//OutBound
							kt_port = reDownNode.getHidden1();

							if (down_vvd_pol.equals(down_bkg_pol)) {
								KorRateHeadVO rh = dbDao.searchExemptWhf(node.getBkgNo());
								if (rh == null) {
									kcd_tp = "E";
								} else {
									wh_whf_ind = rh.getWhfInd();
									kcd_tp = rh.getKcdTp();
								}
							} else {
								kcd_tp = "R";
							}

							//jjang
							if (down_vvd_pol.equals(down_bkg_pol) ) {
								reDownNode.setCreatedType("B");
								createType = "B";
							} else if (!down_vvd_pol.equals(down_bkg_pol)) {
								reDownNode.setCreatedType("C");
								createType = "C";
							}


							if ("B".equals(condData.getSelType())) {
								if ("C".equals(reDownNode.getCreatedType())) continue;

							}
							if ("C".equals(condData.getSelType())) {
								if ("B".equals(reDownNode.getCreatedType())) continue;
								reDownNode.setBac("");
							}

							//String custType = dbDao.searchCustType(reDownNode.getABkgNo());
							String custType = reDownNode.getSc();

							if (reDownNode.getSc().equals("N")) {
								if (custType.equals("N")) reDownNode.setSc("C");
								if (custType.equals("B")) reDownNode.setSc("S");
							}
						} else {
							//InBound

							kt_port = reDownNode.getHidden2();

							if (down_vvd_pod.equals(down_bkg_pod)) {
								kcd_tp = "I";
								reDownNode.setTp("I");
							} else {
								kcd_tp = "T";
								reDownNode.setTp("T");
							}
							//InBound의 경우 CreatedType은 항상 N
//							if ("P".equals(reDownNode.getFe())) {
//								reDownNode.setCreatedType("M");
//								createType = "M";
//							} else {
//								reDownNode.setCreatedType("N");
//								createType = "N";
//							}
//
//							if ("N".equals(condData.getSelType())) {
//								reDownNode.setCreatedType("N");
//								createType = "N";
//							}


							if("P".equals(reDownNode.getFe())){
								if(kcd_tp.equals("T")){
									reDownNode.setCreatedType("T");
									createType = "T";
								}else{
									reDownNode.setCreatedType("M");
									createType = "M";
								}

							}else{
								if(kcd_tp.equals("T")){
									reDownNode.setCreatedType("R");
									createType = "R";
								}else{
									reDownNode.setCreatedType("A");
									createType = "A";
								}

							}

							if ("N".equals(condData.getSelType())) {
								reDownNode.setCreatedType("N");
								createType = "N";
							}
						}

						reDownNode.setKcdTp(kcd_tp);
						reDownNode.setKtPort(kt_port);
						reDownNode.setWh(wh_whf_ind);

						dangerInfo = dbDao.searchDangerInfo(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());
						korBkgCntrVOs = dbDao.searchBKGCNTRList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());

						if ("R".equals(reDownNode.getKcdTp()) && !"Y".equals(wh_whf_ind)) reDownNode.setSc("S");	//a_msn_bltp = sc

						exportList = null;
						if ("E".equals(reDownNode.getKcdTp()) && "S".equals(reDownNode.getSc())) {
							exportList = dbDao.searchExportInfoDNList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());
						}

						custInfoList = dbDao.searchCustomerInfoList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());

						cargoParam.setABkgNo(reDownNode.getABkgNo());
						cargoParam = dbDao.searchCargoDescDN(cargoParam);


						korIbMtInfoVO = null;
						if (reDownNode.getCntrNo() != null && reDownNode.getCntrNo().length() > 1 &&
								(reDownNode.getKcdTp().equals("E") || reDownNode.getKcdTp().endsWith("R")) ) {
							korIbMtInfoVO = dbDao.searchIbTsMtInfo(reDownNode.getCntrNo());
						}

						transParam.setBkgNo		(reDownNode.getABkgNo()		);
						transParam.setBlNo		(reDownNode.getBlNo()		);
						transParam.setKcdTp		(reDownNode.getKcdTp()		);
						transParam.setKtPort	(reDownNode.getKtPort()		);
						transParam.setInBound	(reDownNode.getInBound()	);
						transParam.setPodTml	(reDownNode.getInPodTmnl()	);
						transParam.setPolTml	(reDownNode.getInPolTmnl()	);
						transParam.setCBlNo		(reDownNode.getCBlNo()		);

						if (korIbMtInfoVO != null && korIbMtInfoVO.getInCgoTp().equals("P")) transParam.setKcdTp("R");


						// EMPTY BL 인 경우 CSTMS_BL_NO 를 다시 조회하여 셋팅
						if (reDownNode.getFe().equals("P") && reDownNode.getKtPort().equals("KRPUS")) {

							cblCntrVO = new KorCblCntrVO();
							cblCntrVO.setBkgNo			(transParam.getBkgNo()	);
							cblCntrVO.setCstmsDeclTpCd	(transParam.getKcdTp()	);
							cblCntrVO.setDmstPortCd		(transParam.getKtPort()	);
							cblCntrVO.setCntrNo			(reDownNode.getCntrNo()	);
							newCBlNo = dbDao.searchCblNo(cblCntrVO);
							if (newCBlNo != null) {
								reDownNode.setCBlNo(newCBlNo);
								transParam.setCBlNo(newCBlNo);
							}
						}

						searchTransMit = dbDao.searchTransmitCheckKor(transParam);
						String kt_seq = "0";
						int before_tr_count = 0;
						String kt_sts = "";
						String kt_vvd = condData.getInVvd();
						if (searchTransMit != null) kt_vvd = searchTransMit.getVslCd();

						String kt_pkg_qty = "";
						String kt_wgt_qty = "";
						String kt_wgt_tp = "";
						String kt_pkg_cd = "";
						String bkg_pkg_qty = "";
						String bkg_actwgt_qty = "";
						String bkg_actwgt_tp = "";
						String bkg_pkg_cd = "";

						bkg_pkg_qty = reDownNode.getPckQty();
						bkg_actwgt_qty = reDownNode.getActWgt();
						bkg_actwgt_tp = reDownNode.getWgtUtCd();
						bkg_pkg_cd = reDownNode.getPckTpCd();

						if (searchTransMit != null) {
							kt_pkg_qty = searchTransMit.getPckQty();
							kt_wgt_qty = searchTransMit.getCntrTtlWgt();
							kt_wgt_tp = searchTransMit.getWgtUtCd();
							kt_pkg_cd = searchTransMit.getPckTpCd();
							kt_seq = searchTransMit.getTrnsSeq();

							if ("".equals(kt_seq) || kt_seq == null) kt_seq = "0";
							before_tr_count = Integer.parseInt(kt_seq);
						}

						if (before_tr_count > 0) {
							if ("X".equals(reDownNode.getBkgsts())) {
								kt_sts = "X";
								List<BkgCstmsKrBlVO> bkgStsKor = dbDao.searchBkgStsKorList(transParam);
								// 결과가 X 이면 SKIP
								if (bkgStsKor != null) {
									BkgCstmsKrBlVO stsNode = bkgStsKor.get(0);
									if (stsNode != null && stsNode.getKrBlAmdtStsCd() != null && stsNode.getKrBlAmdtStsCd().equals("X")) {
										continue;
									}
								}
							}

							if ("".equals(kt_sts) &&
								(!condData.getInVvd().equals(kt_vvd) ||
								 !searchTransMit.getTsPolCd().equals(reDownNode.getHidden1()) ||
								 !searchTransMit.getTsPodCd().equals(reDownNode.getHidden2()))) {
								kt_sts = "V";
							} else if ("".equals(kt_sts) &&
								(!kt_pkg_qty.equals(bkg_pkg_qty) ||
								 !kt_wgt_qty.equals(bkg_actwgt_qty) ||
								 (kt_pkg_qty.equals(bkg_pkg_qty) && !kt_pkg_cd.equals(bkg_pkg_cd)) ||
								 (kt_wgt_qty.equals(bkg_actwgt_qty) && !kt_wgt_tp.equals(bkg_actwgt_tp)))) {
								kt_sts = "U";
							} else {
								if (exportList != null) {
									BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
									String changeflag = "N";
									for (int i=0;i<exportList.size();i++) {
										KorExportInfoDNVO exNode = exportList.get(i);
										// ELNO 가 없으면 SKIP 처리
										if (exNode.getEBmeElno()==null || exNode.getEBmeElno().trim().length() < 1) continue;
										bkgCstmsKrXptLicVO.setBkgNo		(reDownNode.getABkgNo()	);
										bkgCstmsKrXptLicVO.setKcdTp		(reDownNode.getKcdTp()	);
										bkgCstmsKrXptLicVO.setKtPort	(reDownNode.getKtPort()	);
										bkgCstmsKrXptLicVO.setKtSeq		(kt_seq					);
										bkgCstmsKrXptLicVO.setBmeElno	(exNode.getEBmeElno()	);
										bkgCstmsKrXptLicVO.setBmePkgQty	(exNode.getEBmePkgQty()	);
										bkgCstmsKrXptLicVO.setBmePkgCd	(exNode.getEBmePkgTp()	);
										bkgCstmsKrXptLicVO.setBmeWgtQty	(exNode.getEBmeWgtQty()	);
										bkgCstmsKrXptLicVO.setBmeWgtTp	(exNode.getEBmeWgtTp()	);
										bkgCstmsKrXptLicVO.setCBlNo		(reDownNode.getCBlNo()	);

										String checkResult = dbDao.searchExportChk(bkgCstmsKrXptLicVO);
										if (!"X".equals(checkResult)) {
											changeflag = "Y";
											break;
										}
									}
									if ("Y".equals(changeflag)) kt_sts = "U";
								}
								// OLD CHECK 추가
								KorOldExpChkVO oldExpChkVO = new KorOldExpChkVO();
								oldExpChkVO.setBkgNo			(reDownNode.getABkgNo()		);
								oldExpChkVO.setCstmsDeclTpCd	(reDownNode.getKcdTp()		);
								oldExpChkVO.setDmstPortCd		(reDownNode.getKtPort()		);
								oldExpChkVO.setTrnsSeq			(kt_seq						);
								oldExpChkVO.setCstmsBlNo		(reDownNode.getCBlNo()		);
								String oldExpChkCnt = dbDao.searchOldExportChk(oldExpChkVO);
								if ("".equals(kt_sts) && oldExpChkCnt != null && oldExpChkCnt.compareTo("0") > 0) kt_sts = "U";

							}
						} else {
							if ("X".equals(reDownNode.getBkgsts())) {
								kt_sts = "X";
							} else {
								kt_sts = "";
							}
						}
						transParam.setKtSts(kt_sts);

						int notTransCount = dbDao.searchNotTransmitCheck(transParam);
						int blDeleteCount = 0;
						if (notTransCount > 0) {
							String maxSeq = dbDao.searchMaxTransSeqKor(transParam);
							transParam.setKtSeq(maxSeq);

							BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
							bkgCstmsKrCntrVO.setBkgNo	(transParam.getBkgNo()	);
							bkgCstmsKrCntrVO.setKcdTp	(transParam.getKcdTp()	);
							bkgCstmsKrCntrVO.setKtPort	(transParam.getKtPort()	);
							bkgCstmsKrCntrVO.setKtSeq	(transParam.getKtSeq()	);
							bkgCstmsKrCntrVO.setCBlNo	(transParam.getCBlNo()	);
							dbDao.removeCNTRMaxInfoKor(bkgCstmsKrCntrVO);

							BkgCstmsKrCustVO bkgCstmsKrCustVO = new BkgCstmsKrCustVO();
							bkgCstmsKrCustVO.setBkgNo(transParam.getBkgNo());
							bkgCstmsKrCustVO.setBkgNoSplit(transParam.getBkgNoSplit());
							bkgCstmsKrCustVO.setKcdTp(transParam.getKcdTp());
							bkgCstmsKrCustVO.setKtPort(transParam.getKtPort());
							bkgCstmsKrCustVO.setKtSeq(transParam.getKtSeq());
							dbDao.removeCustMaxInfoKor(bkgCstmsKrCustVO);

							BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
							bkgCstmsKrXptLicVO.setBkgNo	(transParam.getBkgNo()	);
							bkgCstmsKrXptLicVO.setKcdTp	(transParam.getKcdTp()	);
							bkgCstmsKrXptLicVO.setKtPort(transParam.getKtPort()	);
							bkgCstmsKrXptLicVO.setKtSeq	(transParam.getKtSeq()	);
							bkgCstmsKrXptLicVO.setCBlNo	(transParam.getCBlNo()	);
							dbDao.removeElNoMaxInfoKor(bkgCstmsKrXptLicVO);

							blDeleteCount = dbDao.removeBlMaxInfoKor(transParam);
							totalDeleteCnt = totalDeleteCnt + blDeleteCount;

							if (searchTransMit != null)searchTransMit.setBKtSeq(Integer.toString(notTransCount));
						}


						if (bbChk.equals("2")) {
							int bnotTransCount = dbDao.searchBbNotTransmitCheck(transParam);
							int bblDeleteCount = 0;
							if (bnotTransCount > 0) {
								String maxSeq = dbDao.searchBbMaxTransSeqKor(transParam);
								transParam.setKtSeq(maxSeq);

								BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
								bkgCstmsKrCntrVO.setBkgNo	(transParam.getBkgNo()	);
								bkgCstmsKrCntrVO.setKcdTp	(transParam.getKcdTp()	);
								bkgCstmsKrCntrVO.setKtPort	(transParam.getKtPort()	);
								bkgCstmsKrCntrVO.setKtSeq	(transParam.getKtSeq()	);
								bkgCstmsKrCntrVO.setCBlNo	(transParam.getCBlNo()	);
								dbDao.removeBbCNTRMaxInfoKor(bkgCstmsKrCntrVO);

								BkgCstmsKrCustVO bkgCstmsKrCustVO = new BkgCstmsKrCustVO();
								bkgCstmsKrCustVO.setBkgNo(transParam.getBkgNo());
								bkgCstmsKrCustVO.setBkgNoSplit(transParam.getBkgNoSplit());
								bkgCstmsKrCustVO.setKcdTp(transParam.getKcdTp());
								bkgCstmsKrCustVO.setKtPort(transParam.getKtPort());
								bkgCstmsKrCustVO.setKtSeq(transParam.getKtSeq());
								dbDao.removeBbCustMaxInfoKor(bkgCstmsKrCustVO);

								BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
								bkgCstmsKrXptLicVO.setBkgNo	(transParam.getBkgNo()	);
								bkgCstmsKrXptLicVO.setKcdTp	(transParam.getKcdTp()	);
								bkgCstmsKrXptLicVO.setKtPort(transParam.getKtPort()	);
								bkgCstmsKrXptLicVO.setKtSeq	(transParam.getKtSeq()	);
								bkgCstmsKrXptLicVO.setCBlNo	(transParam.getCBlNo()	);
								dbDao.removeBbElNoMaxInfoKor(bkgCstmsKrXptLicVO);

								bblDeleteCount = dbDao.removeBbBlMaxInfoKor(transParam);
								totalDeleteCnt = totalDeleteCnt + bblDeleteCount;

//								if (searchTransMit != null)searchTransMit.setBKtSeq(Integer.toString(notTransCount));
							}
						}

						if (before_tr_count != 0 || !"X".equals(transParam.getKtSts())) {
							paramVO.setNewMrnNo(mrnVslSysEtaEtdVO.getMrnNo());
							paramVO.setNewMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());
							paramVO.setVvdCd(reDownNode.getInVvd());
							paramVO.setVslFlag(mrnVslSysEtaEtdVO.getVslFlag());
							paramVO.setVslEngNm(mrnVslSysEtaEtdVO.getVslEngNm());
							paramVO.setVslCallSign(mrnVslSysEtaEtdVO.getVslCallSign());
							paramVO.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
							paramVO.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());
							paramVO.setMrnPort(kt_port);
							paramVO.setUsername(account.getUsr_id());
							paramVO.setVvdPodTmnlCd(reDownNode.getInPodTmnl());
							paramVO.setVvdPolTmnlCd(reDownNode.getInPolTmnl());
							paramVO.setVvdCd(condData.getInVvd());
							paramVO.setInBound(condData.getInBound());
							paramVO.setBound(condData.getInBound());
							paramVO.setJointCnt("3");
							paramVO.setUsername(account.getUsr_id());
							paramVO.setMrnPort(kt_port);
							paramVO.setCreatedtype(createType);
							paramVO.setPodTml(reDownNode.getInPodTmnl());
							paramVO.setPolTml(reDownNode.getInPolTmnl());

							String max_seq = dbDao.searchMaxSeqVVDKor(paramVO);

							if ("".equals(max_seq)) max_seq = "0";
							int seq_val = Integer.parseInt(max_seq);

							if (seq_val == 0) {
								paramVO.setKvSeq(Integer.toString(seq_val + 1));
								dbDao.addVVDInfo(paramVO);
							} else if (seq_val > 0) {
								paramVO.setKvSeq(max_seq);
								String y_chk = dbDao.searchMaxSeqVVDYard(paramVO);

								if ("N".equals(y_chk)) {
									paramVO.setKvSeq(Integer.toString(seq_val + 1));
									dbDao.addVVDInfo(paramVO);
								} else {
									String sendCheck = dbDao.searchSendCheckKor(paramVO);
									if ("Y".equals(sendCheck)) {
										paramVO.setKvSeq(Integer.toString(seq_val + 1));
										dbDao.addVVDInfo(paramVO);
									}
								}
							}

							transTypeStr = null;
							transTypeChg = null;

							if (searchTransMit != null) kt_seq=searchTransMit.getTrnsSeq();
							if (kt_seq == null || kt_seq.equals(""))kt_seq = "0";
							int i_kt_seq = Integer.parseInt(kt_seq);
							if (i_kt_seq > 0) {
								// TRANS TYPE, TRANS TYPE CHANGE 조회
								if ("I".equals(kcd_tp) || "T".equals(kcd_tp)) {
									ibTransWhfVO = new KorIbTransWhfVO();
									ibTransWhfVO.setBkgNo	(reDownNode.getABkgNo()		);
									ibTransWhfVO.setKtPort	(kt_port					);
									ibTransWhfVO.setKtSeq	(String.valueOf(i_kt_seq)	);
									ibTransWhfVO.setInBound	("I"						);
									ibTransWhfVO = dbDao.searchIBTransTypeChg(ibTransWhfVO);

									transTypeStr = ibTransWhfVO.getTransType();
									transTypeChg = ibTransWhfVO.getTransTypeChg();
								} else if ("E".equals(kcd_tp) || "R".equals(kcd_tp)) {
									obTransWhfVO = new KorObTransWhfVO();
									obTransWhfVO.setBkgNo	(reDownNode.getABkgNo()		);
									obTransWhfVO.setKtPort	(kt_port					);
									obTransWhfVO.setKtSeq	(String.valueOf(i_kt_seq)	);
									obTransWhfVO = dbDao.searchOBTransTypeChg(obTransWhfVO);

									transTypeStr = obTransWhfVO.getTransType();
									transTypeChg = obTransWhfVO.getTransTypeChg();
								}

								if (!kcd_tp.equals(transTypeStr)) kcd_tp = transTypeStr;
								if ("R".equals(transTypeChg) || "T".equals(transTypeChg)) {
									if (!"".equals(transTypeChg)) kcd_tp = transTypeChg;
								}
							}

							i_kt_seq ++;

							// 추가된 컨테이너 번호가 존재하고 KCD_TP 가 E이거나 R이면
							if (reDownNode.getCntrNo() != null && reDownNode.getCntrNo().length() > 1 &&
								(reDownNode.getKcdTp().equals("E") || reDownNode.getKcdTp().endsWith("R")) ) {
								// 조회 결과 세팅
								if (korIbMtInfoVO != null && korIbMtInfoVO.getInCgoTp().equals("P")) {

									reDownNode.setIbMtyBkgNo		(korIbMtInfoVO.getInBkg()	);
									reDownNode.setIbMtyBlNo			(korIbMtInfoVO.getInCBl()	);
									reDownNode.setIbTrnsSeq			(korIbMtInfoVO.getInSeq()	);
									reDownNode.setIbCstmsDeclTpCd	(korIbMtInfoVO.getInTpCd()	);
									reDownNode.setIbDmstPortCd		(korIbMtInfoVO.getInPort()	);
									reDownNode.setIbVslCd			(korIbMtInfoVO.getInVsl()	);
									reDownNode.setIbSkdVoyNo		(korIbMtInfoVO.getInVoy()	);
									reDownNode.setIbSkdDirCd		(korIbMtInfoVO.getInDir()	);
									reDownNode.setIbEtaDt			(korIbMtInfoVO.getInEta()	);

									// 값이 존재하고 IN_CGO_TP가 P 이면 EXPT_KCD_TP를 R로 변경
									if (korIbMtInfoVO.getInCgoTp().equals("P")) {
										transTypeChg = "R";
									}
								}

							}

							KorManifestDNVO korManifestDNVO = new KorManifestDNVO();
							korManifestDNVO.setABkgNo(reDownNode.getABkgNo());
							korManifestDNVO.setBkgNo(reDownNode.getABkgNo());
							korManifestDNVO.setABkgNoSplit(reDownNode.getABkgNoSplit());
							korManifestDNVO.setExptKcdTp(transTypeChg);
							korManifestDNVO.setKcdTp(kcd_tp);
							korManifestDNVO.setKtSeq(Integer.toString(i_kt_seq));
							korManifestDNVO.setKtSts(kt_sts);
							korManifestDNVO.setBlNo(reDownNode.getBlNo());
							korManifestDNVO.setBkgPor(reDownNode.getBkgPor());
							korManifestDNVO.setBkgDel(reDownNode.getBkgDel());
							korManifestDNVO.setMsnBltp(reDownNode.getSc());
							korManifestDNVO.setPkgValue(reDownNode.getPkgValue());
							korManifestDNVO.setBkgPol(reDownNode.getPol());
							korManifestDNVO.setBkgPod(reDownNode.getPod());
							korManifestDNVO.setMsnNbr(reDownNode.getMsn());
							korManifestDNVO.setVvdCd(condData.getInVvd());
							korManifestDNVO.setVvdPol(reDownNode.getHidden1());
							korManifestDNVO.setVvdPod(reDownNode.getHidden2());
							korManifestDNVO.setVvdPodTmnlCd(condData.getInPodTmnl());
							korManifestDNVO.setVvdPolTmnlCd(condData.getInPolTmnl());
							korManifestDNVO.setBkgPkgQty(reDownNode.getPckQty());
							korManifestDNVO.setBkgPkgCd(reDownNode.getPckTpCd());
							korManifestDNVO.setBkgActwgtQty(reDownNode.getActWgt());
							korManifestDNVO.setBkgActwgtTp(reDownNode.getWgtUtCd());
							korManifestDNVO.setBkgMeaQty(reDownNode.getMeasQty());
							korManifestDNVO.setBkgMeaTp(reDownNode.getMeasUtCd());

							korManifestDNVO.setBondAreaCode(reDownNode.getBac());

							korManifestDNVO.setAImoClass1(dangerInfo[0]);
							korManifestDNVO.setAImoClass2(dangerInfo[1]);
							korManifestDNVO.setAImoClass3(dangerInfo[2]);
							korManifestDNVO.setWhouse(reDownNode.getWhouse());
							korManifestDNVO.setWhouseDesc(reDownNode.getWhouseDesc());
							korManifestDNVO.setDesc1(cargoParam.getDescCode1());
							korManifestDNVO.setDesc2(cargoParam.getDescCode2());
							korManifestDNVO.setUsername(account.getUsr_id());
							korManifestDNVO.setFfordCd("");
							korManifestDNVO.setBkgCgoTp(reDownNode.getFe());
							korManifestDNVO.setUsBound(reDownNode.getCreatedType());
							korManifestDNVO.setKtPort(kt_port);
							korManifestDNVO.setCmdtRep(reDownNode.getCm());
							korManifestDNVO.setSc(reDownNode.getSc());
							korManifestDNVO.setMsnBltp(reDownNode.getSc());

							korManifestDNVO.setCBlNo(reDownNode.getCBlNo());
							korManifestDNVO.setIbMtyBkgNo(reDownNode.getIbMtyBkgNo());
							korManifestDNVO.setIbMtyBlNo(reDownNode.getIbMtyBlNo());
							korManifestDNVO.setIbTrnsSeq(reDownNode.getIbTrnsSeq());
							korManifestDNVO.setIbCstmsDeclTpCd(reDownNode.getIbCstmsDeclTpCd());
							korManifestDNVO.setIbDmstPortCd(reDownNode.getIbDmstPortCd());
							korManifestDNVO.setIbVslCd(reDownNode.getIbVslCd());
							korManifestDNVO.setIbSkdVoyNo(reDownNode.getIbSkdVoyNo());
							korManifestDNVO.setIbSkdDirCd(reDownNode.getIbSkdDirCd());
							korManifestDNVO.setIbEtaDt(reDownNode.getIbEtaDt());
							korManifestDNVO.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
							korManifestDNVO.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());


//							dbDao.addBlInfoKor(korManifestDNVO);



							if (bbChk.compareTo("2") == 0) {

								String tBkgNo = korManifestDNVO.getBkgNo();
								String tBlNo = korManifestDNVO.getBlNo();
								String tCBlNo = korManifestDNVO.getCBlNo();
								String tBkgCgoTp = korManifestDNVO.getBkgCgoTp();
//								String tExptKcdTp = korManifestDNVO.getExptKcdTp();
								String tPckQty = korManifestDNVO.getBkgPkgQty();
								String tActWgt = korManifestDNVO.getBkgActwgtQty();
								String tMeasQty = korManifestDNVO.getBkgMeaQty();
								String tMsnBltp = korManifestDNVO.getMsnBltp();
//								String tKcdTp = korManifestDNVO.getKcdTp();
								String tCgoDesc1 = korManifestDNVO.getDesc1();
								String tCgoDesc2 = korManifestDNVO.getDesc2();
								String tCmdtRep = korManifestDNVO.getCmdtRep();
								String tMsnNbr = korManifestDNVO.getMsnNbr();
								String tBoundAreaCode = korManifestDNVO.getBondAreaCode();
								String tWhouse = korManifestDNVO.getWhouse();


								korManifestDNVO.setBkgCgoTp("B");	  //Cargo Type: Break Bulk, Bulk WGT, Bulk MEA 추가

								dbDao.addReBlInfoKor(korManifestDNVO); // 기존  bkg no 생성 BKG_CSTMS_KR_BL

//								bbBkgNo = dbDao.searchFirstTmpBkgNoAssign(account.getOfc_cd(), account.getUsr_id());
//								bbBlNo = dbDao.searchFirstTmpBlNoAssign();

								bbBlNo = "SEM"+tBlNo.substring(3);
								bbBkgNo = bbBlNo;

								korManifestDNVO.setBkgNo(bbBkgNo);
//								korManifestDNVO.setBlNo(bbBlNo);
								korManifestDNVO.setCBlNo(bbBlNo);
								korManifestDNVO.setBkgCgoTp("R");
//								korManifestDNVO.setExptKcdTp("E");
								korManifestDNVO.setBkgPkgQty("0");
								korManifestDNVO.setBkgActwgtQty("0");
								korManifestDNVO.setBkgMeaQty("0");
								korManifestDNVO.setMsnBltp("E");
//								korManifestDNVO.setKcdTp("E");
								korManifestDNVO.setDesc1("EMPTY CONTAINER");
								korManifestDNVO.setDesc2("");
								korManifestDNVO.setCmdtRep("860900");

								if (!"O".equals(condData.getInBound())) {
									korManifestDNVO.setMsnNbr("");
									korManifestDNVO.setBondAreaCode("ST03077006");
									korManifestDNVO.setWhouse("R");
								}

								dbDao.addReBlInfoKor(korManifestDNVO); //신규 bkg no, 신규bl no로 생성 BKG_CSTMS_KR_BL

								korManifestDNVO.setBkgNo(tBkgNo);
//								korManifestDNVO.setBlNo(tBlNo);
								korManifestDNVO.setCBlNo(tCBlNo);
								korManifestDNVO.setBkgCgoTp(tBkgCgoTp);
//								korManifestDNVO.setExptKcdTp(tExptKcdTp);
								korManifestDNVO.setBkgPkgQty(tPckQty);
								korManifestDNVO.setBkgActwgtQty(tActWgt);
								korManifestDNVO.setBkgMeaQty(tMeasQty);
								korManifestDNVO.setMsnBltp(tMsnBltp);
//								korManifestDNVO.setKcdTp(tKcdTp);
								korManifestDNVO.setDesc1(tCgoDesc1);
								korManifestDNVO.setDesc2(tCgoDesc2);
								korManifestDNVO.setCmdtRep(tCmdtRep);

								if (!"O".equals(condData.getInBound())) {
									korManifestDNVO.setMsnNbr(tMsnNbr);
									korManifestDNVO.setBondAreaCode(tBoundAreaCode);
									korManifestDNVO.setWhouse(tWhouse);
								}

							} else {

								dbDao.addReBlInfoKor(korManifestDNVO);
							}
							totalDownloadCnt++;

//							// C_BL 별 KCD_TP 재조회
//							korCblVO.setBkgNo		(reDownNode.getABkgNo()		);
//							korCblVO.setTrnsSeq		(Integer.toString(i_kt_seq)	);
//							korCblVO.setDmstPortCd	(reDownNode.getKtPort()		);
//							korCblVO.setCBlNo		(reDownNode.getCBlNo()		);
//							korCblVO.setVvd			(reDownNode.getVvdCd()		);
//
//							cntr_kcd_tp = dbDao.searchCblKcdTp(korCblVO);

							if (korBkgCntrVOs != null) {

								if ("P".equals(reDownNode.getFe()) || "R".equals(reDownNode.getFe())) {
									cntrFe = "E";
								} else {
									cntrFe = "F";
								}
								if (bbChk.equals("2")) {	  //Break Bulk와 섞여 있는 경우
									//reDownNode.getFe().equals("X") 로 한 이유: 과거 cntr 1개당 b/1 1개 생성 했던 로직, 2014 07 부로 로직 제거, 일단 안타게. P->X
									if (reDownNode.getFe().equals("X") && reDownNode.getKtPort().equals("KRPUS")) {
										korBkgCntrVO = korBkgCntrVOs.get(idxDn);

										if (korBkgCntrVO.getBBbCgoFlg().equals("Y")) {
											param1.setBkgNo		(bbBkgNo					);
											param1.setCBlNo		(bbBlNo						);
											param1.setFeInd		("E"						);
											param1.setCntrPkgQty("0"						);
											param1.setCntrWgtQty("0"						);
											param1.setCntrMeaQty("0"						);
											param1.setSealNo1("");
											param1.setSealNo2("");
										} else {
											param1.setBkgNo(reDownNode.getABkgNo());
											param1.setCBlNo(reDownNode.getCBlNo());
											param1.setFeInd		(cntrFe						);
											param1.setCntrPkgQty(korBkgCntrVO.getBCntrPkgQty());
											param1.setCntrWgtQty(korBkgCntrVO.getBCntrWgtQty());
											param1.setCntrMeaQty(korBkgCntrVO.getBCntrMeaQty());
											param1.setSealNo1(korBkgCntrVO.getBCntrSealNo1());
											param1.setSealNo2(korBkgCntrVO.getBCntrSealNo2());
										}

										param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
										param1.setExptKcdTp(transTypeChg);
//										param1.setKcdTp(cntr_kcd_tp);
										param1.setKcdTp(kcd_tp);
										param1.setKtSeq(Integer.toString(i_kt_seq));
										param1.setCntrNo(korBkgCntrVO.getBCntrNo());
										param1.setCntrtsCd(korBkgCntrVO.getBCntrtsCd());
										param1.setCntrPkgCd(korBkgCntrVO.getBCntrPkgCd());
										param1.setCntrWgtTp(korBkgCntrVO.getBCntrWgtTp());
										param1.setCntrMeaTp(korBkgCntrVO.getBCntrMeaTp());
										param1.setKtPort(kt_port);
										param1.setUsername(account.getUsr_id());
										dbDao.addCNTRInfoKor(param1);
									} else {
										for (int m=0;m<korBkgCntrVOs.size();m++) {
											korBkgCntrVO = korBkgCntrVOs.get(m);

											if (korBkgCntrVO.getBBbCgoFlg().equals("Y")) {
												param1.setBkgNo		(bbBkgNo					);
												param1.setCBlNo		(bbBlNo						);
												param1.setFeInd		("E"						);
												param1.setCntrPkgQty("0"						);
												param1.setCntrWgtQty("0"						);
												param1.setCntrMeaQty("0"						);
												param1.setSealNo1("");
												param1.setSealNo2("");
											} else {
												param1.setBkgNo(reDownNode.getABkgNo());
												param1.setCBlNo(reDownNode.getCBlNo());
												param1.setFeInd		(cntrFe						);
												param1.setCntrPkgQty(korBkgCntrVO.getBCntrPkgQty());
												param1.setCntrWgtQty(korBkgCntrVO.getBCntrWgtQty());
												param1.setCntrMeaQty(korBkgCntrVO.getBCntrMeaQty());
												param1.setSealNo1(korBkgCntrVO.getBCntrSealNo1());
												param1.setSealNo2(korBkgCntrVO.getBCntrSealNo2());
											}

											param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
											param1.setExptKcdTp(transTypeChg);
//											param1.setKcdTp(cntr_kcd_tp);
											param1.setKcdTp(kcd_tp);
											param1.setKtSeq(Integer.toString(i_kt_seq));
											param1.setCntrNo(korBkgCntrVO.getBCntrNo());
											param1.setCntrtsCd(korBkgCntrVO.getBCntrtsCd());
											param1.setCntrPkgCd(korBkgCntrVO.getBCntrPkgCd());
											param1.setCntrWgtTp(korBkgCntrVO.getBCntrWgtTp());
											param1.setCntrMeaTp(korBkgCntrVO.getBCntrMeaTp());
											param1.setKtPort(kt_port);
											param1.setUsername(account.getUsr_id());
											dbDao.addCNTRInfoKor(param1);
										}
									}
									param1.setBkgNo(reDownNode.getABkgNo());
									param1.setCBlNo(reDownNode.getCBlNo());
									param1.setKtSeq(Integer.toString(i_kt_seq));
									param1.setKtPort	(kt_port					);
									param1.setKcdTp		(kcd_tp      				);
									param1.setUsername	(account.getUsr_id()		);
									param1.setCntrNo	("IN BULK");
									param1.setExptKcdTp	("");
									param1.setFeInd		("");
									param1.setCntrPkgQty("0");
									param1.setCntrWgtQty("0");
									param1.setCntrMeaQty("0");
//									param1.setKcdTp		(cntr_kcd_tp				);
									param1.setSealNo1	("");
									param1.setSealNo2	("");
									param1.setCntrtsCd	("");
									param1.setCntrPkgCd	("");
									param1.setCntrWgtTp	("");
									dbDao.addCNTRInfoKor(param1);

								} else {	//Break Bulk와 섞여 있지 않은 경우 - 로직 안타게 하기위해 하나만 보내는로직 삭제
									if (reDownNode.getFe().equals("X") && reDownNode.getKtPort().equals("KRPUS")) {
										korBkgCntrVO = korBkgCntrVOs.get(idxDn);
										param1.setBkgNo(reDownNode.getABkgNo());
										param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
										param1.setExptKcdTp(transTypeChg);
//										param1.setKcdTp(cntr_kcd_tp);
										param1.setKcdTp(kcd_tp);
										param1.setKtSeq(Integer.toString(i_kt_seq));
										param1.setCntrNo(korBkgCntrVO.getBCntrNo());
										param1.setFeInd(cntrFe);
										param1.setSealNo1(korBkgCntrVO.getBCntrSealNo1());
										param1.setSealNo2(korBkgCntrVO.getBCntrSealNo2());
										param1.setCntrtsCd(korBkgCntrVO.getBCntrtsCd());
										param1.setCntrPkgQty(korBkgCntrVO.getBCntrPkgQty());
										param1.setCntrPkgCd(korBkgCntrVO.getBCntrPkgCd());
										param1.setCntrWgtQty(korBkgCntrVO.getBCntrWgtQty());
										param1.setCntrWgtTp(korBkgCntrVO.getBCntrWgtTp());
										param1.setCntrMeaQty(korBkgCntrVO.getBCntrMeaQty());
										param1.setCntrMeaTp(korBkgCntrVO.getBCntrMeaTp());
										param1.setKtPort(kt_port);
										param1.setUsername(account.getUsr_id());
										param1.setCBlNo(reDownNode.getCBlNo());
										dbDao.addCNTRInfoKor(param1);
									} else {
										for (int m=0;m<korBkgCntrVOs.size();m++) {
											korBkgCntrVO = korBkgCntrVOs.get(m);
											param1.setBkgNo(reDownNode.getABkgNo());
											param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
											param1.setExptKcdTp(transTypeChg);
//											param1.setKcdTp(cntr_kcd_tp);
											param1.setKcdTp(kcd_tp);
											param1.setKtSeq(Integer.toString(i_kt_seq));
											param1.setCntrNo(korBkgCntrVO.getBCntrNo());
											param1.setFeInd(cntrFe);
											param1.setSealNo1(korBkgCntrVO.getBCntrSealNo1());
											param1.setSealNo2(korBkgCntrVO.getBCntrSealNo2());
											param1.setCntrtsCd(korBkgCntrVO.getBCntrtsCd());
											param1.setCntrPkgQty(korBkgCntrVO.getBCntrPkgQty());
											param1.setCntrPkgCd(korBkgCntrVO.getBCntrPkgCd());
											param1.setCntrWgtQty(korBkgCntrVO.getBCntrWgtQty());
											param1.setCntrWgtTp(korBkgCntrVO.getBCntrWgtTp());
											param1.setCntrMeaQty(korBkgCntrVO.getBCntrMeaQty());
											param1.setCntrMeaTp(korBkgCntrVO.getBCntrMeaTp());
											param1.setKtPort(kt_port);
											param1.setUsername(account.getUsr_id());
											param1.setCBlNo(reDownNode.getCBlNo());
											dbDao.addCNTRInfoKor(param1);
										}
									}
								}
							}

							String biz_CntCd = "";
							String biz_CustCd = "";
							/*
							 *
							 * Congignee Name이 TO THE ORDER OF 이면
							 * Notify의 상호를 biz no로 셋팅 하기 위한 변수
							 */
							boolean notifyBzNoFlag = false;
							if (custInfoList != null) {
								// KCD_TP 재조회
								korkcdVO.setBkgNo		(reDownNode.getABkgNo()		);
								korkcdVO.setTrnsSeq		(Integer.toString(i_kt_seq)	);
								korkcdVO.setDmstPortCd	(reDownNode.getKtPort()		);
								korkcdVO.setVvd			(reDownNode.getVvdCd()		);
								cust_kcd_tp = dbDao.searchKcdTpCust(korkcdVO);

								for (int i=0;i<custInfoList.size();i++) {
									KorBkgCustVO custNode = custInfoList.get(i);
									if ("S".equals(custNode.getCBcsTp()) && " ".equals(custNode.getCCustAddr())) {
										custNode.setCCustAddr(".");
									}
									BkgCstmsKrCustVO custParam = new BkgCstmsKrCustVO();

									if (cust_kcd_tp != null) {
										for (int k=0; k < cust_kcd_tp.length; k++) {

											custParam.setBkgNo(reDownNode.getABkgNo());
											custParam.setExptKcdTp(transTypeChg);
											custParam.setKcdTp(cust_kcd_tp[k]);
											custParam.setKtSeq(Integer.toString(i_kt_seq));
											custParam.setBcsTp(custNode.getCBcsTp());
											custParam.setCntCd(custNode.getCCntCd());
											custParam.setCustCd(custNode.getCCustCd());
											custParam.setBkgCgoTp(reDownNode.getFe());
											custParam.setCustName(custNode.getCCustName().replaceAll("\n", " "));
											custParam.setCustAddr(custNode.getCCustAddr().replaceAll("\n", " "));
											custParam.setCustTel(custNode.getCCustTel());
											custParam.setKtPort(kt_port);
											custParam.setUsername(account.getUsr_id());

											// 존재여부를 체크하여 있으면 skip
											KorCustExistVO custExistVO = new KorCustExistVO();
											custExistVO.setBkgNo(reDownNode.getABkgNo());
											if (transTypeChg != null && (transTypeChg.equals("R") || transTypeChg.equals("T")) ) {
												custExistVO.setCstmsDeclTpCd(transTypeChg);
											} else {
												custExistVO.setCstmsDeclTpCd(cust_kcd_tp[k]);
											}
											custExistVO.setDmstPortCd(kt_port);
											custExistVO.setBkgCustTpCd(custNode.getCBcsTp());
											custExistVO.setTrnsSeq(String.valueOf(i_kt_seq));
											String custCnt = dbDao.searchCustExistCnt(custExistVO);
											if ( custCnt.equals("0") ) dbDao.addCustInfoKor(custParam);
											if (bbChk.equals("2")) {
												custExistVO.setBkgNo(bbBkgNo);
												custParam.setBkgNo(bbBkgNo);
												String bcustCnt = dbDao.searchCustExistCnt(custExistVO);
												if ( bcustCnt.equals("0") ) dbDao.addBbCustInfoKor(custParam);
											}
										}
									}
									if ("E".equals(kcd_tp) || "R".equals(kcd_tp)) {
										if ("S".equals(custNode.getCBcsTp())) {
											biz_CntCd = custParam.getCntCd();
											biz_CustCd = custParam.getCustCd();
										}
									} else {
										if ("C".equals(custNode.getCBcsTp())) {
											biz_CntCd = custParam.getCntCd();
											biz_CustCd = custParam.getCustCd();
											/**
											 * 2010.11.15 경종윤 [CHM-201007078] 화주의 사업자등록번호 기재 보완요청
											 * 2011.11.15 김현화 [] TO THE ORDER OF 에서 ORDER로 변경 -AA안정선
											 */
											if (Pattern.compile(".*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNode.getCCustName().toUpperCase()).matches()) {
										  //if (custNode.getCCustName().toUpperCase().trim().startsWith("TO THE ORDER OF")) {
												notifyBzNoFlag = true;
											}

										}

										if (biz_CntCd.length() < 2 || notifyBzNoFlag) {
											if ("N".equals(custNode.getCBcsTp())) {
												biz_CntCd = custParam.getCntCd();
												biz_CustCd = custParam.getCustCd();
											}
										}
									}
								}
							}

							BkgRateVO voParam = new BkgRateVO();
							voParam.setBkgNo(reDownNode.getABkgNo());
							String biz_no = "";
							if ("E".equals(kcd_tp) || "R".equals(kcd_tp)) {
								biz_no = dbDao.searchBizNo(voParam);
							}

							if ("".equals(biz_no) || biz_no == null) {
								if (biz_CntCd.length() == 2) {
									korBizNoVO.setBizCntCd(biz_CntCd);
									korBizNoVO.setBizCustCd(biz_CustCd);
									biz_no = dbDao.searchCustRegNo(korBizNoVO);
								}
							}

							if (!"".equals(biz_no)) {
								BkgCstmsKrBlVO updParam = new BkgCstmsKrBlVO();
								updParam.setBizNo(biz_no);
								updParam.setBizNo(biz_no);
								updParam.setBkgNo(reDownNode.getABkgNo());
								updParam.setBkgNoSplit(reDownNode.getABkgNoSplit());
								updParam.setKcdTp(kcd_tp);
								updParam.setExptKcdTp(transTypeChg);
								updParam.setKtPort(kt_port);
								updParam.setKtSeq(Integer.toString(i_kt_seq));
								updParam.setUsername(account.getUsr_id());
								dbDao.modifyBizNo(updParam);
								if (bbChk.equals("2")) {
									updParam.setBkgNo(bbBkgNo);
									dbDao.modifyBizNo(updParam);

								}
							}


							if (!"MAIL BOX".equals(cargoParam.getDescCode1())) {

								if ("R".equals(reDownNode.getKcdTp())) {
									elNoMakeVO.setBkgNo(reDownNode.getABkgNo());
									elNoMakeVO.setBkgNoSplit(reDownNode.getABkgNoSplit());
									elNoMakeVO.setKtPort(kt_port);
									String elno = dbDao.searchElNoMake(elNoMakeVO);
									if (elno != null) {
										BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
										exportNoParam.setBkgNo		(reDownNode.getABkgNo()		);
										exportNoParam.setExptKcdTp	(transTypeChg				);
										exportNoParam.setKcdTp		(kcd_tp						);
										exportNoParam.setKtSeq		(Integer.toString(i_kt_seq) );
										exportNoParam.setBmeElno	(elno						);
										exportNoParam.setBmeWgtQty	(bkg_actwgt_qty				);
										exportNoParam.setBmePkgQty	(bkg_pkg_qty				);
										exportNoParam.setBmePkgCd	(bkg_pkg_cd					);
										exportNoParam.setBmeWgtTp	(bkg_actwgt_tp				);
										exportNoParam.setKtPort		(kt_port					);
										exportNoParam.setUsername	(account.getUsr_id()		);
										exportNoParam.setCBlNo		(reDownNode.getCBlNo()		);
										dbDao.addExportNoMake(exportNoParam);
									} else {
										/*
										 * 2010년 6월 29일 화요일 경종윤
										 * 수출 T/S 화물의 면장은 아래와 같이 Other Reference No에 입력하면 적하목록 Download 시   Export License coulmn에 적용이 되게 적용
										 * (elNo 값이 없을시 TS_REF_NO값으로 대체한다.
										 */
										List<KorExportInfoDNVO> exportList1 = null;
										exportList1 = dbDao.searchExportInfoDNList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());

										if (exportList1 != null && exportList1.size() > 0) {

											elno = exportList1.get(0).getEBmeElno();
											if (elno != null && elno.length() > 0) {

												BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
												exportNoParam.setBkgNo		(reDownNode.getABkgNo()		);
												exportNoParam.setExptKcdTp	(transTypeChg				);
												exportNoParam.setKcdTp		(kcd_tp						);
												exportNoParam.setKtSeq		(Integer.toString(i_kt_seq) );
												exportNoParam.setBmeElno	(elno						);
												exportNoParam.setBmeWgtQty	(bkg_actwgt_qty				);
												exportNoParam.setBmePkgQty	(bkg_pkg_qty				);
												exportNoParam.setBmePkgCd	(bkg_pkg_cd					);
												exportNoParam.setBmeWgtTp	(bkg_actwgt_tp				);
												exportNoParam.setKtPort		(kt_port					);
												exportNoParam.setUsername	(account.getUsr_id()		);
												exportNoParam.setCBlNo		(reDownNode.getCBlNo()		);
												dbDao.addExportNoMake(exportNoParam);
											}
										}

									}
								}

							} else {

								/*
								 * 2010년 6월 29일 화요일 경종윤
								 * 재 다운로드시에도  Gargo Code1값이  "MAIL BOX"로 되어 있는 것들은 EXPORT LICENSE 번호에   NCV로 자동 입력 되게 수정
								 *
								 */
								KorMailBoxVO korMailBoxVO = new KorMailBoxVO();
								korMailBoxVO.setBkgNo(reDownNode.getABkgNo());
								korMailBoxVO.setExptKdTp(transTypeChg);
								korMailBoxVO.setKcdTp(kcd_tp);
								korMailBoxVO.setKtSeq(Integer.toString(i_kt_seq));
								korMailBoxVO.setKtPort(kt_port);
								korMailBoxVO.setBkgPkgQty("");
								korMailBoxVO.setBkgActwgtQty(reDownNode.getActWgt());
								korMailBoxVO.setBkgActwgtTp(reDownNode.getWgtUtCd());
								korMailBoxVO.setBkgPkgQty(reDownNode.getPckQty());
								korMailBoxVO.setBkgPkgCd(reDownNode.getPckTpCd());
								korMailBoxVO.setBmeElno("NCV");
								korMailBoxVO.setUsername(account.getUsr_id());
								korMailBoxVO.setCBlNo(reDownNode.getCBlNo());
								dbDao.addExportNoMailBoxKor(korMailBoxVO);

							}


							if (exportList != null) {
								KorExportInfoDNVO korExportInfoDNVO = null;
								BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
								for (int i=0;i<exportList.size();i++) {
									korExportInfoDNVO = exportList.get(i);
									// ELNO 없는 경우 SKIP 처리
									if (korExportInfoDNVO.getEBmeElno()==null || korExportInfoDNVO.getEBmeElno().trim().length() < 1) continue;
									exportNoParam.setBkgNo(reDownNode.getABkgNo());
									exportNoParam.setBkgNoSplit(reDownNode.getABkgNoSplit());
									exportNoParam.setExptKcdTp(transTypeChg);
									exportNoParam.setKcdTp(kcd_tp);
									exportNoParam.setKtSeq(Integer.toString(i_kt_seq));
									exportNoParam.setBmeElno(korExportInfoDNVO.getEBmeElno());
									exportNoParam.setBmePkgQty(korExportInfoDNVO.getEBmePkgQty());
									exportNoParam.setBmePkgCd(korExportInfoDNVO.getEBmePkgTp());
									exportNoParam.setBmeWgtQty(korExportInfoDNVO.getEBmeWgtQty());
									exportNoParam.setBmeWgtTp(korExportInfoDNVO.getEBmeWgtTp());
									exportNoParam.setKtPort(kt_port);
									exportNoParam.setBmeDivInd(korExportInfoDNVO.getEBmeDivInd());
									exportNoParam.setBmeDivSeq(korExportInfoDNVO.getEBmeDivSeq());
									exportNoParam.setBmeDpkgQty(korExportInfoDNVO.getEBmeDpkgQty());
									exportNoParam.setBmeDpkgCd(korExportInfoDNVO.getEBmeDpkgTp());
									exportNoParam.setBmeDwgtQty(korExportInfoDNVO.getEBmeDwgtQty());
									exportNoParam.setBmeDwgtTp(korExportInfoDNVO.getEBmeDwgtTp());
									exportNoParam.setCBlNo(reDownNode.getCBlNo());
									exportNoParam.setBmeSmpSeq(korExportInfoDNVO.getEBmeSmpSeq());
									exportNoParam.setUsername(account.getUsr_id());

									dbDao.addExportNoKor(exportNoParam);
								}
							}


						}
					}
				}

			} //MainFor Loop

			// History Add
			String maxSeq = dbDao.searchMaxSeqDownHistKor(paramVO.getNewMrnNo()+paramVO.getNewMrnChkNo(), paramVO.getVvdCd());
			if (totalDownloadCnt > 0) {
				KorDownHistVO addDownParam = new KorDownHistVO();
				addDownParam.setActionTime(mrnVslSysEtaEtdVO.getActionTime());
				addDownParam.setMrnNbr(paramVO.getNewMrnNo());
				addDownParam.setVvdCd(paramVO.getVvdCd());
				addDownParam.setMrnChk(paramVO.getNewMrnChkNo());
				addDownParam.setBound(paramVO.getBound());
				addDownParam.setMrnPort(paramVO.getMrnPort());
				addDownParam.setKdhSeq(maxSeq);
				addDownParam.setOffice(account.getOfc_cd());
				addDownParam.setUsername(account.getUsr_id());
				addDownParam.setBlKnt(Long.toString(totalDownloadCnt));
				dbDao.addDownHistSeq(addDownParam);
				maxSeq = String.valueOf(Integer.parseInt(maxSeq)+1);
			}

			// ADD DELETE History
			if (totalDeleteCnt > 0) {
				BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO = new BkgCstmsKrDlHisVO();
				bkgCstmsKrDlHisVO.setMrnNbr(mrnVslSysEtaEtdVO.getMrnNo()+mrnVslSysEtaEtdVO.getMrnChkNo());
				bkgCstmsKrDlHisVO.setMrnChk(mrnVslSysEtaEtdVO.getMrnChkNo());
				bkgCstmsKrDlHisVO.setVvd(condData.getInVvd());
				bkgCstmsKrDlHisVO.setVvdCd(condData.getInVvd());
				bkgCstmsKrDlHisVO.setActionTime(mrnVslSysEtaEtdVO.getActionTime());
				bkgCstmsKrDlHisVO.setPol(condData.getInPol());
				bkgCstmsKrDlHisVO.setPod(condData.getInPod());
				bkgCstmsKrDlHisVO.setOffice(account.getOfc_cd());
				bkgCstmsKrDlHisVO.setUserName(account.getUsr_id());
				bkgCstmsKrDlHisVO.setDeleteBlCnt(Long.toString(totalDeleteCnt));
				bkgCstmsKrDlHisVO.setKdhSeq(maxSeq);
				dbDao.addDownHistKor(bkgCstmsKrDlHisVO);
			}
		}
		catch (DAOException de) {
			log.error("err " + de.toString(), de);
			if (de.getMessage().startsWith("BKG01125")) { // 무결성 에러일 경우
				throw new EventException(new ErrorHandler("BKG01125", new String[] { de.getMessage().split("@")[1] }).getMessage(), de);
			}
			throw new EventException(new ErrorHandler("BKG95019", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG95019", new String[] {}).getMessage(), ex);
		}
		return null;
	}

	/**
	 * 세관 신고대상 내역 조회
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {

		// 최종 결과 리스트
		List<ManifestListDetailVO> manifestListDetailVOs = null;
		// 최종 결과 객체
		KorMSNCreateContainerVO container = new KorMSNCreateContainerVO();
		// 파라메터 객체 변환
		KorMsnCreateVO korMsnCreateVO = (KorMsnCreateVO)manifestListCondVO;
		// MRN 정보 조회용 객체 생성
		KorMrnInfoVO inKorMrnInfoVO  = new KorMrnInfoVO();
		// MRN 정보 조회 결과 객체 생성
		KorMrnInfoVO outKorMrnInfoVO = new KorMrnInfoVO();
		// IBBkgInfo 조회용 객체 생성
		KorBkgInfoVO inKorBkgInfoVO = new KorBkgInfoVO();
		// CUSTOMER TYPE 조회용 객체 생성
		KorCntCustVO inKorCntCustVO = new KorCntCustVO();
		// Discharging Location 조회용 객체
		KorDiscLocVO korDiscLocVO = new KorDiscLocVO();
		// Discharging Location
		String discCd;
		// MSN INFO 조회용 객체
		KorMsnInfoVO inKorMsnInfoVO = new KorMsnInfoVO();
		// MSN INFO 조회 결과 객체
		KorMsnInfoVO outKorMsnInfoVO = null;
		// EDI 전송 체크
		String updateChk = null;
		// MRN_NO 조회용 객체
		KorMrnNoVO inKorMrnNoVO = new KorMrnNoVO();
		// MRN_NO 객체
		KorMrnNoVO outKorMrnNoVO = null;
		// LOCAL의 BL TYPE COUNT 조회용 객체
		KorBlTypeCntVO inKorBlTypeCntVO = new KorBlTypeCntVO();
		// LOCAL의 BL TYPE COUNT 객체
		KorBlTypeCntVO localKorBlTypeCntVO = null;
		// TS의 BL TYPE COUNT 객체
		KorBlTypeCntVO tsKorBlTypeCntVO = null;
		// 최종  MSN INFO용 객체
		KorMsnInfoVO finalKorMsnInfoVO = new KorMsnInfoVO();
		// LOCAL 리스트용 객체
		List<KorMsnInfoVO> localMsnInfoVOs = new ArrayList<KorMsnInfoVO>();
		// TS 리스트용 객체
		List<KorMsnInfoVO> tsMsnInfoVOs = new ArrayList<KorMsnInfoVO>();
		// BL Type 조회결과
		String blTp = "S";

		// MRN INFO 조회용 파라메터 값 매핑
		inKorMrnInfoVO.setInMrnMode 	  (korMsnCreateVO.getInMrnMode()	);
		inKorMrnInfoVO.setInMrnNo   	  (korMsnCreateVO.getInMrnNo()  	);
		inKorMrnInfoVO.setMrnChkNo   	  (korMsnCreateVO.getInMrnChkNo()  	);
		inKorMrnInfoVO.setInPort    	  (korMsnCreateVO.getInPort()   	);
		inKorMrnInfoVO.setInSkdDirCd	  (korMsnCreateVO.getInSkdDirCd()	);
		inKorMrnInfoVO.setInSkdVoyageNo   (korMsnCreateVO.getInSkdVoyageNo());
		inKorMrnInfoVO.setInVslCd		  (korMsnCreateVO.getInVslCd()		);

		try {
			outKorMrnInfoVO = dbDao.searchMrnInfoByVVD(inKorMrnInfoVO);
			if (outKorMrnInfoVO==null) {
				// VVD,PORT 조회가 안되면 MRN 으로 조회
				outKorMrnInfoVO = dbDao.searchMrnInfoByMRN(inKorMrnInfoVO);
			}
			// 조회가 된 경우에만 처리
			if (outKorMrnInfoVO != null) {
				// MRN 정보 담기
				container.setKorMrnInfoVO(outKorMrnInfoVO);

				// IN-BOUND의 경우 조회
				if (inKorMrnInfoVO.getInMrnMode().equals("I")) {

					// IBBkgInfo 조회용 객체에 PARAMETER 설정
					inKorBkgInfoVO.setVvdVslCd   (outKorMrnInfoVO.getVvd().substring(0,4));
					inKorBkgInfoVO.setVvdSkdVoyNo(outKorMrnInfoVO.getVvd().substring(4,8));
					inKorBkgInfoVO.setVvdSkdDirCd(outKorMrnInfoVO.getVvd().substring(8,9));
					inKorBkgInfoVO.setVvdPodCd   (outKorMrnInfoVO.getPortCd()            );
					// IBBkgInfo 리스트 조회 - 루프
					for (KorBkgInfoVO korBkgInfoVO : dbDao.searchIBBkgInfoList(inKorBkgInfoVO)) {

						// MODE 구분  ( BKG_POD 와 VVD_POD 가 동일하면 LOCAL, 그렇지 않으면 TS로 설정 )
						if (korBkgInfoVO.getBkgPodCd().equals(korBkgInfoVO.getVvdPodCd()))
							korBkgInfoVO.setLocalTs("I");
						else
							korBkgInfoVO.setLocalTs("T");

						// CUST TP COUNT 추출
						inKorCntCustVO.setBkgNo(korBkgInfoVO.getBkgBkgNo());

						// BL TYPE 조회
						blTp = dbDao.searchBlTp(korBkgInfoVO.getBkgBkgNo());
						// 조회결과 반영
						korBkgInfoVO.setBlTp(blTp);

						// CUSTOMER TYPE 기본값 설정 (GT)
						korBkgInfoVO.setCstmTpCd("GT");

						// Discharging Location 조회
						korDiscLocVO.setPortCd  (korBkgInfoVO.getVvdPodCd()   );
						korDiscLocVO.setSlanCd  (korBkgInfoVO.getVvdSlanCd()  );
						korDiscLocVO.setSkdDirCd(inKorBkgInfoVO.getVvdSkdDirCd() );
						discCd = dbDao.searchDiscLoc(korDiscLocVO);

						// MSN INFO 조회
						inKorMsnInfoVO.setBkgNo	 (korBkgInfoVO.getBkgBkgNo()	);
						inKorMsnInfoVO.setMfRefNo(outKorMrnInfoVO.getMrnNo()	);
						inKorMsnInfoVO.setMrnChk (outKorMrnInfoVO.getMrnChkNo()	);
						outKorMsnInfoVO = dbDao.searchMSNInfo(inKorMsnInfoVO);
						// 조회결과가 없을 경우
						if (outKorMsnInfoVO==null) {
							if (!korBkgInfoVO.getBkgStsCd().equals("X") &&
								!korBkgInfoVO.getBkgStsCd().equals("S")) {
								// MSN 추가용 파라메터 설정
								inKorMsnInfoVO.setBkgNo			(korBkgInfoVO.getBkgBkgNo()			);
								inKorMsnInfoVO.setMrnNbr		(outKorMrnInfoVO.getMrnNo()				);
								inKorMsnInfoVO.setMrnChk		(outKorMrnInfoVO.getMrnChkNo()			);
								inKorMsnInfoVO.setLocalTs		(korBkgInfoVO.getLocalTs()			);
								inKorMsnInfoVO.setBlTp			(korBkgInfoVO.getBlTp()				);
								inKorMsnInfoVO.setIcdCstmTp		(korBkgInfoVO.getCstmTpCd()			);
								inKorMsnInfoVO.setDiscCd		(discCd									);
								inKorMsnInfoVO.setIcdCstmLoc	(null									);
								inKorMsnInfoVO.setIcdCstmWh		(null									);
								inKorMsnInfoVO.setVslCd			(outKorMrnInfoVO.getVvd().substring(0,4));
								inKorMsnInfoVO.setSkdVoyageNo	(outKorMrnInfoVO.getVvd().substring(4,8));
								inKorMsnInfoVO.setSkdDirCd		(outKorMrnInfoVO.getVvd().substring(8,9));
								inKorMsnInfoVO.setUserid		(korMsnCreateVO.getUserid()				);
								// MSN 추가
								dbDao.addMSNInfo(inKorMsnInfoVO);
							}
						} else {
							// 조회 결과가 있을 경우
							outKorMsnInfoVO.setMrnNbr	(inKorMsnInfoVO.getMfRefNo()	);
							outKorMsnInfoVO.setBkgNo 	(inKorMsnInfoVO.getBkgNo()		);
							outKorMsnInfoVO.setMrnChk	(inKorMsnInfoVO.getMrnChk()		);
							outKorMsnInfoVO.setLocalTs	(korBkgInfoVO.getLocalTs()	);

							if (korBkgInfoVO.getBkgStsCd().equals("X") ||
								korBkgInfoVO.getBkgStsCd().equals("S")) {
								// MSN INFO 삭제 처리
								dbDao.removeMSNInfo(outKorMsnInfoVO);
							} else if (!korBkgInfoVO.getBkgStsCd().equals("X") &&
									  !korBkgInfoVO.getBkgStsCd().equals("S")) {
								// EDI 전송 체크 조회
								updateChk = dbDao.searchMSNUpdtChk(inKorMsnInfoVO);
								if (updateChk==null || updateChk.trim().length() < 1)
									updateChk = "Y";
								else
									updateChk = "N";
								outKorMsnInfoVO.setUpdateChk(updateChk);
								// MSN INFO Update
								dbDao.modifyMSNInfo(outKorMsnInfoVO);
							}
						}
					} // IBBkgInfo 조회루프 종료

				} // IN-BOUND 처리 종료

				// MRN_NO 조회
				inKorMrnNoVO.setInVvd	(outKorMrnInfoVO.getVvd()		);
				inKorMrnNoVO.setInBound	(outKorMrnInfoVO.getIoBndCd()	);
				inKorMrnNoVO.setInPod	(outKorMrnInfoVO.getPortCd()	);
				inKorMrnNoVO.setInPol	(outKorMrnInfoVO.getPortCd()	);
				outKorMrnNoVO = dbDao.searchMrnNo(inKorMrnNoVO);


				// MRN_NO 조회값이 없으면 다른 방법으로 조회
				// 해당 객체에 OUT 속성 몇개가 존재하지 않아 IN 속성에 할당하도록 함
				if (outKorMrnNoVO == null) {
					inKorMrnNoVO.setMrnNo	(outKorMrnInfoVO.getMrnNo()		);
					inKorMrnNoVO.setInBound	(outKorMrnInfoVO.getIoBndCd()	);
					outKorMrnNoVO = dbDao.searchMrn(inKorMrnNoVO);
				} else {
					outKorMrnNoVO.setInVvd	(outKorMrnInfoVO.getVvd()		);
					outKorMrnNoVO.setInBound(outKorMrnInfoVO.getIoBndCd()	);
					outKorMrnNoVO.setInPod	(outKorMrnInfoVO.getPortCd()	);
					outKorMrnNoVO.setInPol	(outKorMrnInfoVO.getPortCd()	);
				}

				// IN-BOUND 처리
				if (outKorMrnNoVO.getInBound().equals("I")) {
					// Type COUNT 조회용 파라메터 셋팅
					inKorBlTypeCntVO.setVslCd	(outKorMrnNoVO.getInVvd().substring(0,4));
					inKorBlTypeCntVO.setSkdVoyNo(outKorMrnNoVO.getInVvd().substring(4,8));
					inKorBlTypeCntVO.setSkdDirCd(outKorMrnNoVO.getInVvd().substring(8,9));
					inKorBlTypeCntVO.setMrnNbr	(outKorMrnNoVO.getMrnNo()				);
					inKorBlTypeCntVO.setMrnPort	(outKorMrnNoVO.getInPod()				);
					// LOCAL BL Type COUNT 조회
					localKorBlTypeCntVO = dbDao.searchIBLocBlTpCnt(inKorBlTypeCntVO);
					container.setLocalBlTpCnt(localKorBlTypeCntVO);
					// TS BL Type COUNT 조회
					tsKorBlTypeCntVO = dbDao.searchIBTSBlTpCnt(inKorBlTypeCntVO);
					container.setTsBlTpCnt(tsKorBlTypeCntVO);

					// MSN INFO 조회 (실제 Sheet에 뿌려질 객체)
					finalKorMsnInfoVO.setVslCd		(outKorMrnNoVO.getInVvd().substring(0,4));
					finalKorMsnInfoVO.setSkdVoyageNo(outKorMrnNoVO.getInVvd().substring(4,8));
					finalKorMsnInfoVO.setSkdDirCd	(outKorMrnNoVO.getInVvd().substring(8,9));
					finalKorMsnInfoVO.setPodCd		(outKorMrnNoVO.getInPod()				);
					finalKorMsnInfoVO.setMrnNbr		(outKorMrnNoVO.getMrnNo()				);
					// 최종 MSN INFO 리스트 조회 - LOCAL / TS 구분에 따라 담기
					for (KorMsnInfoVO korMsnInfoVO : dbDao.searchIBMSNInfoList(finalKorMsnInfoVO)) {
						if (korMsnInfoVO.getLocalTs().equals("I")) {
							localMsnInfoVOs.add(korMsnInfoVO);
						} else {
							tsMsnInfoVOs.add(korMsnInfoVO);
						}
					}

					// 컨테이너에 담기
					container.setLocalMsnInfoVOs(localMsnInfoVOs);
					container.setTsMsnInfoVOs(tsMsnInfoVOs);
				}// IN-BOUND 처리 종료

				// 최종 결과 리스트에 담기
				manifestListDetailVOs = new ArrayList<ManifestListDetailVO>();
				manifestListDetailVOs.add(container);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return manifestListDetailVOs;
	}

	/**
	 * Discharge CY, Bonded Warehouse, Bonded Type등을 조회
	 *
	 * @param discCYBondInfoVO
	 * @return
	 * @exception EventException
	 */
	public DiscCYBondInfoVO searchDiscCYBondInfo(DiscCYBondInfoVO discCYBondInfoVO) throws EventException {
		// 화면에서 넘어온 파라메터 변환
		KorDiscCYBondInfoVO inKorDiscCYBondInfoVO  = (KorDiscCYBondInfoVO)discCYBondInfoVO;
		// B/L, BKG_NO 조회용 객체
		KorDiscBondVO korDiscBondVO = new KorDiscBondVO();
		// 처리결과 최종 객체
		KorDiscCYBondInfoVO outKorDiscCYBondInfoVO = new KorDiscCYBondInfoVO();
		// Consignee, Notify 조회용 파라메터 객체
		KorCntCustVO inKorCntCustVO = new KorCntCustVO();
		KorCntCustVO outKorCntCustVO = null;
		// Warfage 조회용 객체
		KorWhfExptVO korWhfExptVO = new KorWhfExptVO();
		// DelTerminal 조회용 객체
		KorDelTermVO korDelTermVO = new KorDelTermVO();
		// Lane, Dir code 조회용 객체
		KorBkgVvdVO korBkgVvdVO = new KorBkgVvdVO();
		// Group Msn 조회용 객체
		KorGrpMsnVO korGrpMsnVO = null;

		String blNo 		= null;
		String bkgNo 	 	= null;
		String cstmsDesc 	= null;
		String cnee			= null;
		String nfty			= null;
		String whfExptCd    = null;
		String whfShprRgstNo= null;
		String cltOfcCd 	= null;
		String locNm	    = "";

		try {

			// B/L NO 로 조회할지 BKG_NO로 조회할지 선택
			if (inKorDiscCYBondInfoVO.getSearchType().equals("search_by_bl_no")) {
				// B/L NO로 조회
				// 넘어온 B/L No 복사
				korDiscBondVO.setBlNo(inKorDiscCYBondInfoVO.getBlNo());
				korDiscBondVO = dbDao.searchBkgNoByBl(korDiscBondVO);
				// 결과 처리
				if (korDiscBondVO==null) return null;
				blNo  = inKorDiscCYBondInfoVO.getBlNo();
				bkgNo = korDiscBondVO.getBkgNo();
			} else {
				// BKG NO로 조회
				// 넘어온 BKG No 복사
				korDiscBondVO.setBkgNo(inKorDiscCYBondInfoVO.getBkgNo());
				korDiscBondVO = dbDao.searchBlNoByBkg(korDiscBondVO);
				// 결과 처리
				if (korDiscBondVO==null) return null;
				blNo  = korDiscBondVO.getBlNo();
				bkgNo = inKorDiscCYBondInfoVO.getBkgNo();
			}


			// BKG_NO, BL_NO 셋팅
			inKorDiscCYBondInfoVO.setBkgNo(bkgNo);
			inKorDiscCYBondInfoVO.setBlNo (blNo );
			inKorCntCustVO.setBkgNo(bkgNo);
			korWhfExptVO.setBkgNo(bkgNo);
			korBkgVvdVO.setBkgNo(bkgNo);

			// Description 조회
			outKorDiscCYBondInfoVO = dbDao.searchDesc(inKorDiscCYBondInfoVO);
			// Description 결과 저장
			cstmsDesc = outKorDiscCYBondInfoVO.getCstmsDesc();
			outKorDiscCYBondInfoVO = null;

			// 최종 리턴할 데이터 조회
			outKorDiscCYBondInfoVO = dbDao.searchDiscCYBondInfo(inKorDiscCYBondInfoVO);
			if (outKorDiscCYBondInfoVO==null) return null;

			// Consignee 조회
			outKorCntCustVO = dbDao.searchCntCustTpC(inKorCntCustVO);
			if (outKorCntCustVO != null) cnee = outKorCntCustVO.getCustNm();

			// Notify 조회
			outKorCntCustVO = dbDao.searchCntCustTpN(inKorCntCustVO);
			if (outKorCntCustVO != null) nfty = outKorCntCustVO.getCustNm();

			// Warefage 조회
			korWhfExptVO = dbDao.searchWhfExptInfo(korWhfExptVO);
			if (korWhfExptVO != null) {
				whfExptCd 		= korWhfExptVO.getBkgRtWhfExptCd();
				whfShprRgstNo 	= korWhfExptVO.getWhfShprRgstNo();
				cltOfcCd 		= korWhfExptVO.getCltOfcCd();
			}

			// Del Term 조회
			korDelTermVO = dbDao.searchDelTermInfo(bkgNo);
			//D/O No., Update Time 조회
			String[] result = dbDao.searchDoNoUptTm(bkgNo);
			outKorDiscCYBondInfoVO.setDoNo(result[0]);
			outKorDiscCYBondInfoVO.setEvntDt(result[1]);

			// BKG_VVD 테이블에서 Lane / Dir Code 추출하여 LOC_NM 조회
			korBkgVvdVO = dbDao.searchBKGVVD(korBkgVvdVO);
			if (korBkgVvdVO != null) {
				outKorDiscCYBondInfoVO.setYard(korBkgVvdVO.getYard());
				KorDiscLocVO discLocVO = new KorDiscLocVO();
				discLocVO.setOtrDchgCd	(outKorDiscCYBondInfoVO.getCstmsDchgLocWhCd()	);
				discLocVO.setSlanCd		(korBkgVvdVO.getSlanCd()						);
				discLocVO.setSkdDirCd	(korBkgVvdVO.getSkdDirCd()						);
				locNm = dbDao.searchDiscLocName(discLocVO);
			}

			// 조회값 적용
			outKorDiscCYBondInfoVO.setBlNo			(blNo						);
			outKorDiscCYBondInfoVO.setBkgNo			(bkgNo						);
			outKorDiscCYBondInfoVO.setCstmsDesc		(cstmsDesc					);
			outKorDiscCYBondInfoVO.setCnee			(cnee						);
			outKorDiscCYBondInfoVO.setNfty			(nfty						);
			outKorDiscCYBondInfoVO.setBkgRtWhfExptCd(whfExptCd					);
			outKorDiscCYBondInfoVO.setWhfShprRgstNo	(whfShprRgstNo				);
			outKorDiscCYBondInfoVO.setCltOfcCd		(cltOfcCd					);
			outKorDiscCYBondInfoVO.setLocNm			(locNm						);
			outKorDiscCYBondInfoVO.setBkgDelCd		(korDelTermVO.getBkgDelCd()	);
			outKorDiscCYBondInfoVO.setMdmLocNm		(korDelTermVO.getMdmLocNm()	);
			outKorDiscCYBondInfoVO.setDelTermCd		(korDelTermVO.getDelTermCd());

			// Group Msn 조회
			korGrpMsnVO = dbDao.searchInfoForGrpMsn(bkgNo);
			String viaWebMsg = "";
			String updUsrId = "";
			if (korGrpMsnVO != null) {
				outKorDiscCYBondInfoVO.setKorGrpMsnVO	(korGrpMsnVO				);
				//WEB에서 I/F 받아온 경우에 Warehouse Assign by B/L 화면의 Bonded Type 코드 옆에
				//Assigned by the customer (Via Web) YYYY-MM-DD HH24:MI 형식으로 표시 하기 위해 세팅.
				if ("Y".equals(korGrpMsnVO.getViaWebFlg())) {
					viaWebMsg = "Assigned by the customer (Via Web) " + korGrpMsnVO.getViaWebDt();
				}
				updUsrId = korGrpMsnVO.getUpdUsrId();
			}
			outKorDiscCYBondInfoVO.setViaWebMsg		(viaWebMsg					);
			outKorDiscCYBondInfoVO.setUpdUsrId		(updUsrId					);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return outKorDiscCYBondInfoVO;
	}

	/**
	 * INBOUND DETAIL UPDATE
	 *
	 * @param discCYBondInfoVO
	 * @return DiscCYBondInfoVO
	 * @exception EventException
	 */
	public DiscCYBondInfoVO manageDiscCYBondInfo(DiscCYBondInfoVO discCYBondInfoVO) throws EventException {
		// 최종 결과물 객체
		KorDiscCYBondInfoVO outKorDiscCYBondInfoVO = new KorDiscCYBondInfoVO();

		// 화면에서 넘어온 파라메터 변환
		KorDiscCYBondInfoVO inKorDiscCYBondInfoVO = (KorDiscCYBondInfoVO)discCYBondInfoVO;

		// Update 여부
		String updateChk = "N";
		// NEW DISC LOC
		String newMsnDiscloc = inKorDiscCYBondInfoVO.getCstmsDchgLocWhCd() + "/" +
							   inKorDiscCYBondInfoVO.getCstmsClrTpCd() + "/" +
							   inKorDiscCYBondInfoVO.getCstmsClrWhCd();
		// OLD DISC LOC
		KorOldDiscLocVO korOldDiscLocVO = new KorOldDiscLocVO();
		// History Seq 객체
		KorBkgHistVO inKorBkgHistVO = new KorBkgHistVO();
		KorBkgHistVO outKorBkgHistVO = new KorBkgHistVO();
		int bkgSeq = 0;
		KorBkgHistVO outKorBkgHistDtlVO = new KorBkgHistVO();

		try {
			// UPDATE CHECK
			updateChk = dbDao.searchIBUpdateChk(inKorDiscCYBondInfoVO);
			if (updateChk != null) updateChk = "Y";
			inKorDiscCYBondInfoVO.setUpdateChk(updateChk);

			// OLD DISC LOC 조회
			korOldDiscLocVO = dbDao.searchOldDiscLoc(inKorDiscCYBondInfoVO.getBkgNo(), inKorDiscCYBondInfoVO.getMfRefNo());

			// OLD 와 NEW 값이 다를 경우
			if (korOldDiscLocVO == null || (korOldDiscLocVO != null && !korOldDiscLocVO.getOldMsnDiscloc().equals(newMsnDiscloc))) {
				// BKG_NO 셋팅
				inKorBkgHistVO.setBkgNo(inKorDiscCYBondInfoVO.getBkgNo());
				outKorBkgHistVO = dbDao.searchMaxBKGHistSeq(inKorBkgHistVO);
				// 처리결과 Sequence 증가 셋팅
				if (outKorBkgHistVO != null) {
					bkgSeq = Integer.parseInt(outKorBkgHistVO.getHistSeq());
					bkgSeq++;
					outKorBkgHistVO.setHistSeq(String.valueOf(bkgSeq));
					outKorBkgHistVO.setBkgNo(inKorDiscCYBondInfoVO.getBkgNo());
					outKorBkgHistVO.setUsrId(inKorDiscCYBondInfoVO.getUsrId());
					// History 객체에 추가
					outKorDiscCYBondInfoVO.setBkgHistVO(outKorBkgHistVO);
					// History Detail Sequence 추출
					inKorBkgHistVO.setHistSeq(outKorBkgHistVO.getHistSeq());
				}

				bkgSeq =0;
				outKorBkgHistDtlVO = dbDao.searchMaxBKGHistSeqDtl(inKorBkgHistVO);
				// 처리결과 Sequence 증가 셋팅
				if (outKorBkgHistDtlVO != null) {
					bkgSeq = Integer.parseInt(outKorBkgHistDtlVO.getHistDtlSeq());
					bkgSeq++;
					// History Detail 추가
					// BKG_NO 셋팅
					outKorBkgHistDtlVO.setBkgNo(inKorDiscCYBondInfoVO.getBkgNo());
					// USER_ID 셋팅
					outKorBkgHistDtlVO.setUsrId(inKorDiscCYBondInfoVO.getUsrId());
					// SEQ 셋팅
					outKorBkgHistDtlVO.setHistSeq(inKorBkgHistVO.getHistSeq());
					outKorBkgHistDtlVO.setHistDtlSeq(String.valueOf(bkgSeq));
					// MSN_DISCLOC 정보 셋팅
					if (korOldDiscLocVO != null) {
						outKorBkgHistDtlVO.setOldMsnDiscloc(korOldDiscLocVO.getOldMsnDiscloc());
					}
					outKorBkgHistDtlVO.setNewMsnDiscloc(newMsnDiscloc);
					// Detail history 객체 추가
					outKorDiscCYBondInfoVO.setBkgHistDtlVO(outKorBkgHistDtlVO);
				}
			}

			// Discharge CY, Bonded Warehouse, Bonded Type 등 UPDATE
			dbDao.modifyDiscCYBondInfo(inKorDiscCYBondInfoVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return outKorDiscCYBondInfoVO;
	}

	/**
	 * 세관 B/L 관련 정보 조회
	 * @param ManifestEditListCondVO manifestEditListCondVO
	 * @return ManifestEditListVO
	 * @exception EventException
	 */
	public ManifestEditListVO searchManifestEditList(ManifestEditListCondVO manifestEditListCondVO) throws EventException {
		// 최종 리턴 객체
		KorManifestEditListVO korManifestEditListVO = new KorManifestEditListVO();
		// 파라메터 객체 변환
		KorManifestEditListCondVO condVO = (KorManifestEditListCondVO)manifestEditListCondVO;

		// 파라메터 객체
		KorBlInqInfoVO 		blCondVO 	= new KorBlInqInfoVO();
		KorCntrInqInfoVO	cntrCondVO 	= new KorCntrInqInfoVO();
		KorCustInqInfoVO	custCondVO  = new KorCustInqInfoVO();
		KorElnoInqInfoVO	elnoCondVO 	= new KorElnoInqInfoVO();

		// BL 용 객체
		KorBlInqInfoVO 		blInqInfoVO 	= new KorBlInqInfoVO();
		// Container 용 객체 배열
		KorCntrInqInfoVO[] 	cntrInqInfoVOs 	= null;
		// Customer Info 용 객체
		KorCustInqInfoVO 	custInqInfoVO 	= new KorCustInqInfoVO();
		// Export Licence 용 객체 배열
		KorElnoInqInfoVO[] 	elnoInqInfoVOs 	= null;
		// Cargo Spec 용 객체
		KorCgoSpecVO cgoSpecVO = new KorCgoSpecVO();
		String cgoSpec = null;

		try {
			// BL 정보 조회
			// 파라메터 셋팅
			blCondVO.setTransTp			(condVO.getTransTp()		);
			blCondVO.setBlNo			(condVO.getBlNo()			);
			blCondVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
			blCondVO.setPortCd			(condVO.getPortCd()			);

			// 조회
			blInqInfoVO = dbDao.searchBlInqInfo(blCondVO);
			if (blInqInfoVO != null) {
				korManifestEditListVO.setKorBlInqInfoVO(blInqInfoVO);

				if (blInqInfoVO.getCgoTrspCd().trim().length() < 1) {
					// Cargo Spec 정보 조회
					cgoSpecVO.setBkgNo(blInqInfoVO.getBkgNo());
					cgoSpec = dbDao.searchCgoSpec(cgoSpecVO);
					// 조회값 체크
					if (cgoSpec != null && cgoSpec.compareTo("0") > 0 ) {
						// IN BOUND 시에만 처리
						if (condVO.getCstmsDeclTpCd().equals("I")) {
							cgoSpec = "1";
						} else if (condVO.getCstmsDeclTpCd().equals("T")) {
							if (blInqInfoVO.getDelCd().startsWith("KR")) {
								cgoSpec = "1";
							} else {
								cgoSpec = "2";
							}
						} else {
							// OutBound 는 빈칸 처리
							cgoSpec = "";
						}
					} else {
						cgoSpec = "";
					}
				} else {
					cgoSpec = blInqInfoVO.getCgoTrspCd();
				}

				korManifestEditListVO.setCargoSpec(cgoSpec);

				// Container 정보 조회
				// 파라메터 셋팅
				cntrCondVO.setBkgNo			(blInqInfoVO.getBkgNo()		);
				cntrCondVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
				cntrCondVO.setPortCd		(condVO.getPortCd()			);
				cntrCondVO.setVvd			(blInqInfoVO.getVvd()		);
				cntrCondVO.setBlNo			(condVO.getBlNo()			);
				// 조회
				cntrInqInfoVOs = dbDao.searchCNTRinqInfoList(cntrCondVO);
				if (cntrInqInfoVOs != null && cntrInqInfoVOs.length > 0) korManifestEditListVO.setKorCntrInqInfoVOs(cntrInqInfoVOs);

				// CUSTOMER INFO 조회
				// 파라메터 셋팅
				custCondVO.setBkgNo			(blInqInfoVO.getBkgNo()		);
				custCondVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
				custCondVO.setPortCd		(condVO.getPortCd()			);
				custCondVO.setVvd			(blInqInfoVO.getVvd()		);
				// 조회
				custInqInfoVO = dbDao.searchCustInqInfo(custCondVO);
				if (custInqInfoVO != null) korManifestEditListVO.setKorCustInqInfoVO(custInqInfoVO);

				// Export Licence No 조회
				// 파라메터 셋팅
				elnoCondVO.setBkgNo			(blInqInfoVO.getBkgNo()		);
				elnoCondVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
				elnoCondVO.setPortCd		(condVO.getPortCd()			);
				elnoCondVO.setBlNo			(condVO.getBlNo()			);
				// 조회
				elnoInqInfoVOs = dbDao.searchElnoInqInfoList(elnoCondVO);
				if (elnoInqInfoVOs != null && elnoInqInfoVOs.length > 0) korManifestEditListVO.setKorElnoInqInfoVOs(elnoInqInfoVOs);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return korManifestEditListVO;
	}

	/**
	 * Package / 품목 Code 조회
	 * @param CodeCondVO codeCondVO
	 * @return CodeVO[]
	 * @exception EventException
	 */
	public CodeVO[] searchCodeInfo(CodeCondVO codeCondVO) throws EventException {
		// Package Code
		KorPckInfoVO[] korPckInfoVOs = null;
		// 품목 Code
		KorCmdtVO[] korCmdtVOs = null;
		// 컨테이너 TYPE
		KorCntrTpSzVO[] korCntrTpSzVOs = null;

		// 전체를 담는 객체
		KorCodeVO[] korCodeVOs = new KorCodeVO[1];
		KorCodeVO korCodeVO = new KorCodeVO();

		try {

			korPckInfoVOs = dbDao.searchPckInfo		(new KorPckInfoVO()	);
			korCmdtVOs    = dbDao.searchKorCmdtInfo	(new KorCmdtVO()	);
			korCntrTpSzVOs= dbDao.searchCntrTpSz    (new KorCntrTpSzVO());

			// 처리 결과 담기
			korCodeVO.setKorPckInfoVOs	(korPckInfoVOs	);
			korCodeVO.setKorCmdtVOs		(korCmdtVOs		);
			korCodeVO.setKorCntrTpSzVOs (korCntrTpSzVOs	);

			korCodeVOs[0] = korCodeVO;


		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korCodeVOs;
	}

	/**
	 * B/L, Container, E/L 정보들을 추가/수정/삭제 처리
	 * @param ManifestModificationVO manifestModificationVO
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO manifestModificationVO) throws EventException {

		// 객체 분리
		KorManifestEditModificationVO condVO = (KorManifestEditModificationVO)manifestModificationVO;

		KorBlInqInfoVO 		korBlInqInfoVO 		= condVO.getKorBlInqInfoVO();
		KorCntrInqInfoVO[]	korCntrInqInfoVOs	= condVO.getKorCntrInqInfoVOs();
		KorCntrInqInfoVO	korCntrInqInfoVO	= null;
		KorCustInqInfoVO	korCustInqInfoVO	= condVO.getKorCustInqInfoVO();
		KorElnoInqInfoVO[]	korElnoInqInfoVOs	= condVO.getKorElnoInqInfoVOs();
		KorElnoInqInfoVO	korElnoInqInfoVO	= null;
		KorKcdTpChgVO		korKcdTpChgVO		= null;
		KorMsnNoInfoVO		korMsnNoInfoVO 		= null;
		KorKcdTpCntrVO		korKcdTpCntrVO		= null;
		KorCustCntVO		korCustCntVO		= null;
		KorCustInqVO		korCustInqVO		= null;
		KorKcdTpElnoVO		korKcdTpElnoVO 		= null;

		String transTp 	= korBlInqInfoVO.getCstmsDeclTpCd();
		String podCd	= korBlInqInfoVO.getPodCd();
		String polCd	= korBlInqInfoVO.getPolCd();
		String cargoTp  = korBlInqInfoVO.getBkgCgoTpCd();
		String mode		= korBlInqInfoVO.getMode();
		String tsPodCd  = "";
		String tsPolCd  = "";
		String usaBndFlg= "";
		String custCnt	= "0";
		int	   seq		= 0;

		korBlInqInfoVO.setUserId(condVO.getUserId());

		try {

			// MODE 에 따른 처리 구분
			if (mode.equals("ADD")) {
				// ADD 시
				if (transTp.equals("I") || transTp.equals("T")) {
					usaBndFlg = "N";
				} else if (transTp.equals("R") || cargoTp.equals("P")) {
					usaBndFlg = "C";
				} else if (podCd != null && "|US|CA|MX|GT".indexOf(podCd.substring(0,2))>0) {
					usaBndFlg = "A";
				} else {
					usaBndFlg = "B";
				}
				tsPodCd = podCd;
				tsPolCd = polCd;

				korBlInqInfoVO.setUsaBndFlg(usaBndFlg);
				korBlInqInfoVO.setTsPodCd(tsPodCd);
				korBlInqInfoVO.setTsPolCd(tsPolCd);
				if (korBlInqInfoVO.getPodTmlCd() != null)
					korBlInqInfoVO.setPodTmlCd(korBlInqInfoVO.getPodTmlCd().trim());

				// B/L 정보 INSERT
				dbDao.addBlInqInfo(korBlInqInfoVO);

				// Max Sequence 추출
				BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
				bkgCstmsKrBlVO.setBkgNo	(korBlInqInfoVO.getBkgNo()			);
				bkgCstmsKrBlVO.setKtPort(korBlInqInfoVO.getPortCd()			);
				bkgCstmsKrBlVO.setKcdTp	(korBlInqInfoVO.getCstmsDeclTpCd()	);

				seq = Integer.parseInt(dbDao.searchMaxSeq(bkgCstmsKrBlVO));
				if (seq < 1) seq++;

				// Customer 정보 INSERT
				korCustInqInfoVO.setTrnsSeq(String.valueOf(seq));
				korCustInqInfoVO.setUserId(condVO.getUserId());
				dbDao.addCustInqInfo(korCustInqInfoVO);

			} else {
				// EDIT 시

				// BL 정보 UPDATE
				dbDao.modifyBlInqInfo(korBlInqInfoVO);

				// KCD TP UPDATE
				korKcdTpChgVO = new KorKcdTpChgVO();
				ObjectCloner.build(korBlInqInfoVO, korKcdTpChgVO);
				dbDao.modifyKcdTpByInVVD(korKcdTpChgVO);

				// MSN No UPDATE
				korMsnNoInfoVO = new KorMsnNoInfoVO();
				ObjectCloner.build(korBlInqInfoVO, korMsnNoInfoVO);
				dbDao.modifyMsnNoInfo(korMsnNoInfoVO);

				// Container KCD TP Update
				korKcdTpCntrVO = new KorKcdTpCntrVO();
				ObjectCloner.build(korBlInqInfoVO, korKcdTpCntrVO);
				dbDao.modifyKcdTpInCntr(korKcdTpCntrVO);

				// ELNO KCD TP Update
				korKcdTpElnoVO = new KorKcdTpElnoVO();
				ObjectCloner.build(korBlInqInfoVO, korKcdTpElnoVO);
				dbDao.modifyKcdTpInElno(korKcdTpElnoVO);

				// Max Sequence 추출
				BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
				bkgCstmsKrBlVO.setBkgNo	(korBlInqInfoVO.getBkgNo()			);
				bkgCstmsKrBlVO.setKtPort(korBlInqInfoVO.getPortCd()			);
				bkgCstmsKrBlVO.setKcdTp	(korBlInqInfoVO.getCstmsDeclTpCd()	);

				seq = Integer.parseInt(dbDao.searchMaxSeq(bkgCstmsKrBlVO));
				if (seq < 1) seq++;

				// Cust CNT 조회
				korCustCntVO = new KorCustCntVO();
				ObjectCloner.build(korBlInqInfoVO, korCustCntVO);
				custCnt = dbDao.searchCustCnt(korCustCntVO);

				// Customer Count 가 0 인경우
				if (custCnt.equals("0")) {
					// Customer 정보 UPDATE
					korCustInqInfoVO.setCstmsDeclTpCd	(korBlInqInfoVO.getCstmsDeclTpCd()		);
					korCustInqInfoVO.setOldCstmsDeclTpCd(korBlInqInfoVO.getOldCstmsDeclTpCd()	);
					korCustInqInfoVO.setUserId			(condVO.getUserId()						);
					dbDao.modifyCustInqInfo(korCustInqInfoVO);
				} else {
					// Customer Count 가 0이 아닌 경우
					korCustInqVO = new KorCustInqVO();
					ObjectCloner.build(korCustInqInfoVO, korCustInqVO);
					korCustInqVO.setCstmsDeclTpCd(korBlInqInfoVO.getCstmsDeclTpCd());
					dbDao.modifyCustInq(korCustInqVO);
				}


			}

			// Container 처리
			if (korCntrInqInfoVOs != null) {
				// Container 정보가 존재하면 모두 제거
				korCntrInqInfoVO = korCntrInqInfoVOs[0];
				korCntrInqInfoVO.setUserId			(condVO.getUserId()					);
				korCntrInqInfoVO.setKcBkgNo			(korBlInqInfoVO.getBkgNo()			);
				korCntrInqInfoVO.setKcCstmsDeclTpCd	(korBlInqInfoVO.getOldCstmsDeclTpCd());
				korCntrInqInfoVO.setPortCd			(korBlInqInfoVO.getPortCd()			);
				korCntrInqInfoVO.setTrnsSeq			(String.valueOf(seq)				);
				korCntrInqInfoVO.setBlNo			(korBlInqInfoVO.getBlNo()			);
				dbDao.removeCNTRInqInfo(korCntrInqInfoVO);
				// Container 정보 다시 INSERT
				for (int i=0; i < korCntrInqInfoVOs.length; i++) {
					korCntrInqInfoVO = korCntrInqInfoVOs[i];
					if (korCntrInqInfoVO.getKcCntrNo()==null || korCntrInqInfoVO.getKcCntrNo().trim().length() < 1) continue;
					korCntrInqInfoVO.setUserId			(condVO.getUserId()					);
					korCntrInqInfoVO.setKcBkgNo			(korBlInqInfoVO.getBkgNo()			);
					korCntrInqInfoVO.setKcCstmsDeclTpCd	(korBlInqInfoVO.getCstmsDeclTpCd()	);
					korCntrInqInfoVO.setPortCd			(korBlInqInfoVO.getPortCd()			);
					korCntrInqInfoVO.setTrnsSeq			(String.valueOf(seq)				);
					korCntrInqInfoVO.setBlNo			(korBlInqInfoVO.getBlNo()			);
					// Flag 가 'D'가 아닌 경우만 INSERT
					if (!korCntrInqInfoVO.getKcIbflag().equals("D")) dbDao.addCNTRInqInfo(korCntrInqInfoVO);
				}
			}
			// Export Lic No 처리
			if (korElnoInqInfoVOs != null) {
				// EL 정보가 존재하면 모두 제거
				korElnoInqInfoVO = korElnoInqInfoVOs[0];
				korElnoInqInfoVO.setUserId			(condVO.getUserId()					);
				korElnoInqInfoVO.setKeTrnsSeq		(String.valueOf(seq)				);
				korElnoInqInfoVO.setKeBkgNo			(korBlInqInfoVO.getBkgNo()			);
				korElnoInqInfoVO.setPortCd			(korBlInqInfoVO.getPortCd()			);
				korElnoInqInfoVO.setKeCstmsDeclTpCd	(korBlInqInfoVO.getOldCstmsDeclTpCd());
				korElnoInqInfoVO.setBlNo			(korBlInqInfoVO.getBlNo()			);
				dbDao.removeElnoInqInfo(korElnoInqInfoVO);
				// EL 정보 다시 INSERT
				for (int i=0; i < korElnoInqInfoVOs.length; i++) {
					korElnoInqInfoVO = korElnoInqInfoVOs[i];
					if (korElnoInqInfoVO.getKeXptLicNo()==null || korElnoInqInfoVO.getKeXptLicNo().trim().length() < 1) continue;
					korElnoInqInfoVO.setUserId			(condVO.getUserId()					);
					korElnoInqInfoVO.setKeTrnsSeq		(String.valueOf(seq)				);
					korElnoInqInfoVO.setKeBkgNo			(korBlInqInfoVO.getBkgNo()			);
					korElnoInqInfoVO.setPortCd			(korBlInqInfoVO.getPortCd()			);
					korElnoInqInfoVO.setKeCstmsDeclTpCd	(korBlInqInfoVO.getCstmsDeclTpCd()	);
					korElnoInqInfoVO.setBlNo			(korBlInqInfoVO.getBlNo()			);
					// Flag 가 'D' 가 아닌 경우만 INSERT
					if (!korElnoInqInfoVO.getIbflag().equals("D")) dbDao.addElnoInqInfo(korElnoInqInfoVO);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * BKG_NO, B/L_NO 자동 생성
	 * @param TmpBlBkgVO tmpBlBkgVO
	 * @return  TmpBlBkgVO
	 * @exception EventException
	 */
	public TmpBlBkgVO searchTempBlNoNBkgNoAssign(TmpBlBkgVO tmpBlBkgVO) throws EventException {
		// 처리 결과 객체
		KorTmpBlBkgVO korTmpBlBkgVO = (KorTmpBlBkgVO)tmpBlBkgVO;

		try {
			String bkgNo = "";
			String blNo = dbDao.searchFirstTmpBlNoAssign();
			BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
			bkgCstmsKrBlVO.setBlNo(blNo);
			int blCnt = dbDao.searchTmpBlExistKor(bkgCstmsKrBlVO);

			if (blCnt > 0) {
				// 조회건수가 있으면 1초후에 다시 생성
				Thread.sleep(1000);
				blNo = dbDao.searchFirstTmpBlNoAssign();
			}

			// BKG NO 생성
			bkgNo = dbDao.searchFirstTmpBkgNoAssign(korTmpBlBkgVO.getOfcCd(), korTmpBlBkgVO.getUserId());

			// 최종 결과 담기
			korTmpBlBkgVO.setBkgNo(bkgNo);
			korTmpBlBkgVO.setBlNo(blNo);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korTmpBlBkgVO;
	}

	/**
	 * MSN Bonded Info 조회
	 * @param MsnBondInfoVO msnBondInfoVO
	 * @return MsnBondInfoVO[]
	 * @exception EventException
	 */
	public MsnBondInfoVO[] searchMsnBondedInfo(MsnBondInfoVO msnBondInfoVO) throws EventException {
		// 최종 리턴 객체배열
		KorMsnBondInfoVO[] korMsnBondInfoVOs = new KorMsnBondInfoVO[1];
		KorMsnBondInfoVO   korMsnBondInfoVO  = new KorMsnBondInfoVO();
		// 파라메터 변환
		KorMsnBondInfoVO   condVO = (KorMsnBondInfoVO)msnBondInfoVO;

		try {
			// 조회용 객체생성
			BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO = new BkgCstmsKrMfSeqNoVO();
			BkgCstmsKrMfRefNoVO bkgCstmsKrMfRefNoVO = new BkgCstmsKrMfRefNoVO();
			KorBondedInfoVO korBondedInfoVO			= new KorBondedInfoVO();
			// 파라메터 셋팅
			bkgCstmsKrMfSeqNoVO.setMrnNo(condVO.getMrnNo()	);
			bkgCstmsKrMfSeqNoVO.setVvd  (condVO.getVvd()	);
			bkgCstmsKrMfRefNoVO.setMrnNo(condVO.getMrnNo()	);
			bkgCstmsKrMfRefNoVO.setVvd	(condVO.getVvd()	);
			korBondedInfoVO.setMrnNo	(condVO.getMrnNo()	);
			korBondedInfoVO.setVvd		(condVO.getVvd()	);
			korBondedInfoVO.setPod		(condVO.getPod()	);
			korBondedInfoVO.setPol		(condVO.getPol()	);
			korBondedInfoVO.setYard		(condVO.getYard()	);
			korBondedInfoVO.setBkgNo	(condVO.getBkgNo()	);

			// MAX MSN 조회
			String msnNo 	= dbDao.searchMaxMsnNo(bkgCstmsKrMfSeqNoVO);
			korMsnBondInfoVO.setMsnNo(msnNo);
			// MRN MODE 조회
			String mrnMode 	= dbDao.searchMrnMode(bkgCstmsKrMfRefNoVO);
			korBondedInfoVO.setMrnMode(mrnMode);

			// LOCAl / T/S 에 따른 작업 분리
			if (condVO.getType().equalsIgnoreCase("LOCAL")) {
				korBondedInfoVO.setMrnMode("I");
				// 데이터 리스트 조회
				KorBondLocalInfoVO[] korBondLocalInfoVOs = dbDao.searchBondLocalInfoList(korBondedInfoVO);
				// 리턴될 객체에 담기
				korMsnBondInfoVO.setBondLocalInfoVOs(korBondLocalInfoVOs);

				// 최종 배열에 담기
				korMsnBondInfoVOs[0] = korMsnBondInfoVO;

			} else {
				korBondedInfoVO.setMrnMode("T");
				// 데이터 리스트 조회
				KorBondTsInfoVO[] korBondTsInfoVOs = dbDao.searchBondTsInfoList(korBondedInfoVO);
				// 리턴될 객체에 담기
				korMsnBondInfoVO.setBondTsInfoVOs(korBondTsInfoVOs);

				// 최종 배열에 담기
				korMsnBondInfoVOs[0] = korMsnBondInfoVO;
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korMsnBondInfoVOs;
	}

	/**
	 * MRN Bonded Info Update
	 *
	 * @param MsnBondInfoVO msnBondInfoVO
	 * @return BkgCstmsKrMfSeqNoVO[]
	 * @exception EventException
	 */
	public BkgCstmsKrMfSeqNoVO[] modifyMsnBondedInfo(MsnBondInfoVO msnBondInfoVO) throws EventException {
		// 리턴용 LIST
		List<BkgCstmsKrMfSeqNoVO> list = new ArrayList<BkgCstmsKrMfSeqNoVO>();

		// 파라메터 변환
		KorMsnBondInfoVO korMsnBondInfoVO = (KorMsnBondInfoVO)msnBondInfoVO;
		// 넘어온 리스트
		KorBondTsInfoVO[] bondInfoVOs = korMsnBondInfoVO.getBondTsInfoVOs();

		// MSN UPDATE 조회용 파라메터
		BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO = new BkgCstmsKrMfSeqNoVO();

		String locCd	 = "";
		String updateChk = "Y";

		try {
			// LOOP
			for (int i=0; i < bondInfoVOs.length; i++) {
				locCd = "";
				// Bonded W/H 에 값이 있는 경우 LOC_CD 조회
				if (bondInfoVOs[i].getCstmsClrWhCd() != null && bondInfoVOs[i].getCstmsClrWhCd().trim().length() > 0) {
					locCd = dbDao.searchWareHouseLoc(bondInfoVOs[i].getCstmsClrWhCd());
				}
				// MSN UPDATE 조회 용 파라메터 셋팅
				bkgCstmsKrMfSeqNoVO.setBkgNo			(bondInfoVOs[i].getBkgNo()				);
				bkgCstmsKrMfSeqNoVO.setMrnNo			(bondInfoVOs[i].getMfRefNo()			);
				bkgCstmsKrMfSeqNoVO.setCstmsClrTpCd		(bondInfoVOs[i].getCstmsClrTpCd()		);
				bkgCstmsKrMfSeqNoVO.setCstmsClrWhCd		(bondInfoVOs[i].getCstmsClrWhCd()		);
				bkgCstmsKrMfSeqNoVO.setCstmsDchgLocWhCd	(bondInfoVOs[i].getCstmsDchgLocWhCd()	);
				bkgCstmsKrMfSeqNoVO.setBdTpCd			(bondInfoVOs[i].getBdTpCd()				);
				bkgCstmsKrMfSeqNoVO.setBlTpCd			(bondInfoVOs[i].getKrCstmsBlTpCd()		);
				bkgCstmsKrMfSeqNoVO.setMsnCfmFlg		(bondInfoVOs[i].getMfCfmFlg()			);
				bkgCstmsKrMfSeqNoVO.setMfSeqNo			(bondInfoVOs[i].getMfSeqNo()			);

				// CFM Y가 아니면 N으로 강제 설정
				if (bkgCstmsKrMfSeqNoVO.getMsnCfmFlg()==null || !bkgCstmsKrMfSeqNoVO.getMsnCfmFlg().equals("Y"))
					bkgCstmsKrMfSeqNoVO.setMsnCfmFlg("N");

				// MSN UPDATE 조회
				updateChk = dbDao.searchMsnUpdate(bkgCstmsKrMfSeqNoVO);

				// Bonded Info UPDATE 용 파라메터 셋팅
				bkgCstmsKrMfSeqNoVO.setCstmsClrLocCd	(locCd		);
				bkgCstmsKrMfSeqNoVO.setUpdateChk		(updateChk	);

				// Bonded Info UPDATE
				dbDao.modifyBondedInfo(bkgCstmsKrMfSeqNoVO);

				list.add(bkgCstmsKrMfSeqNoVO);

			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

		return list.toArray(new BkgCstmsKrMfSeqNoVO[0]);
	}

	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회
	 * @param ContainerCondVO containerCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerType(ContainerCondVO containerCondVO) throws EventException {
		String tpszCd = "";

		try {

			tpszCd = dbDao.searchContainerType((KorContainerCondVO)containerCondVO);
			if (tpszCd==null) tpszCd = "";

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return tpszCd;
	}

	/**
	 * BL 정보 조회
	 * @param BlInfoCondVO blInfoCondVO
	 * @return BlInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchBlInfo(BlInfoCondVO blInfoCondVO) throws EventException {
		// 파라메터 변환
		KorBlInfoCondVO condVO = (KorBlInfoCondVO)blInfoCondVO;

		// 최종 리턴 객체
		KorBlInfoVO korBlInfoVO = new KorBlInfoVO();

		// PORT
		String portCd = null;

		// AmendInfo 조회용 객체
		KorAmendInfoVO korAmendInfoVO = new KorAmendInfoVO();
		// Cust CNT, CODE 조회용 객체
		KorCntCustVO korCntCustVO = new KorCntCustVO();
		// BIZ NO 조회용 객체
		KorBizNoVO korBizNoVO = new KorBizNoVO();
		String bizNo = null;
		// MRN, VVD 조회용 객체
		KorMrnVvdInfoVO korMrnVvdInfoVO = new KorMrnVvdInfoVO();
		// SUB_NO 체크용 객체
		KorCorrVO korCorrVO = new KorCorrVO();
		String submitCheck = null;
		// BL Correction 정보 조회용 객체
		KorCorrTransVO korCorrTransVO = new KorCorrTransVO();
		// Cargo Spec 조회용 객체
		KorCgoSpecVO korCgoSpecVO = new KorCgoSpecVO();
		String cgoSpec = null;
		// BL 별 Container 정보 조회용 객체
		KorCntrCorrVO korCntrCorrVO = new KorCntrCorrVO();
		KorCntrCorrVO[] korCntrCorrVOs = null;
		// CUSTOMER 정보 조회용 객체
		KorCustCorrVO korCustCorrVO = new KorCustCorrVO();
		// Export License 정보 조회용 객체
		KorExpCorrVO korExpCorrVO = new KorExpCorrVO();
		KorExpCorrVO[] korExpCorrVOs = null;
		// CORR LIST 조회용 객체
		KorCorrListVO korCorrListVO = new KorCorrListVO();
		KorCorrListVO[] korCorrListVOs = null;

		try {
			// PORT 처리
			if (condVO.getIoBndCd().equals("I")) {
				portCd = condVO.getPodCd();
			} else {
				portCd = condVO.getPolCd();
			}
			portCd = condVO.getPortCd();

			// AmendInfo 조회
			korAmendInfoVO.setBlNo			(condVO.getBlNo()			);
			korAmendInfoVO.setPortCd		(portCd						);
			korAmendInfoVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
			korAmendInfoVO.setVvd			(condVO.getVvd()			);
			korAmendInfoVO = dbDao.searchAmendInfo(korAmendInfoVO);

			// IN Bound 의 경우
			if (condVO.getIoBndCd().equals("I")) {
				// Cust CNT, CODE 조회
				korCntCustVO.setBlNo			(condVO.getBlNo()			);
				korCntCustVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
				korCntCustVO.setPortCd			(portCd						);
				korCntCustVO.setBkgNo			(condVO.getBkgNo()			);
				korCntCustVO = dbDao.searchIBCntCustTypeC(korCntCustVO);
				// CNT 가 "" 인 경우 Type N 조회
				if (korCntCustVO==null || korCntCustVO.getCustCntCd().equals("")) {
					korCntCustVO = new KorCntCustVO();
					korCntCustVO.setBlNo			(condVO.getBlNo()			);
					korCntCustVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
					korCntCustVO.setPortCd			(portCd						);
					korCntCustVO = dbDao.searchIBCntCustTypeN(korCntCustVO);
				}
				// CNT_CD 가 구해진 경우 BIZ NO 조회
				if (korCntCustVO != null && korCntCustVO.getCustCntCd().length() > 1) {
					korBizNoVO.setBizCntCd	(korCntCustVO.getCustCntCd());
					korBizNoVO.setBizCustCd	(korCntCustVO.getCustSeq()	);
					bizNo = dbDao.searchCustRegNo(korBizNoVO);
				}
				// MRN VVD 조회
				korMrnVvdInfoVO.setPortCd	(portCd			);
				korMrnVvdInfoVO.setVvd		(condVO.getVvd());
				korMrnVvdInfoVO = dbDao.searchIBMRNVVDInfo(korMrnVvdInfoVO);

			} else {
				// OUT BOUND 의 경우
				// Cust CNT, CODE 조회
				korCntCustVO.setBlNo			(condVO.getBlNo()			);
				korCntCustVO.setBkgNo			(condVO.getBkgNo()			);
				korCntCustVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
				korCntCustVO.setPortCd			(portCd						);
				korCntCustVO = dbDao.searchOBCntCustTypeS(korCntCustVO);

				// CNT_CD 가 구해진 경우 BIZ NO 조회
				if (korCntCustVO != null && korCntCustVO.getCustCntCd().length() > 1) {
					korBizNoVO.setBizCntCd	(korCntCustVO.getCustCntCd());
					korBizNoVO.setBizCustCd	(korCntCustVO.getCustSeq()	);
					bizNo = dbDao.searchCustRegNo(korBizNoVO);
				}
				// MRN VVD 조회
				korMrnVvdInfoVO.setPortCd	(portCd			);
				korMrnVvdInfoVO.setVvd		(condVO.getVvd());
				korMrnVvdInfoVO = dbDao.searchOBMRNVVDInfo(korMrnVvdInfoVO);
			}

			// SUBMIT NO CHECK
			korCorrVO.setBlNo			(condVO.getBlNo()			);
			korCorrVO.setPortCd			(portCd						);
			korCorrVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()	);
			korCorrVO.setVvd			(condVO.getVvd()			);
			submitCheck = dbDao.searchSubmitNoCheck(korCorrVO);
			// 조회 결과가 없거나 값이 비어있으면 N 으로 설정
			if (submitCheck==null || submitCheck.equals("")) submitCheck = "N";

			// BL Correction 정보 조회용 파라메터 설정
			korCorrTransVO.setSubmitChk		(submitCheck						);
			korCorrTransVO.setVvd			(condVO.getVvd()					);
			korCorrTransVO.setIoBndCd		(condVO.getIoBndCd()				);
			korCorrTransVO.setCstmsDeclTpCd	(condVO.getCstmsDeclTpCd()			);
			korCorrTransVO.setMrnNo			(korMrnVvdInfoVO.getMrnNo()			);
			korCorrTransVO.setVslCallSgnCd	(korMrnVvdInfoVO.getVslCallSgnCd()	);
			korCorrTransVO.setEtaDt			(korMrnVvdInfoVO.getEtaDt()			);
			korCorrTransVO.setCallKnt		(korMrnVvdInfoVO.getCallKnt()		);
			korCorrTransVO.setVslNm			(korMrnVvdInfoVO.getVslNm()			);
			korCorrTransVO.setVslCntCd		(korMrnVvdInfoVO.getVslCntCd()		);
			korCorrTransVO.setIoTmlLocCd	(korMrnVvdInfoVO.getIoTmlLocCd()	);
			korCorrTransVO.setBlNo			(condVO.getBlNo()					);
			korCorrTransVO.setPortCd		(portCd								);
			korCorrTransVO.setBizRgstNo		(bizNo								);

			// Trans Check 이 Y 인 경우
			if (korAmendInfoVO != null && korAmendInfoVO.getTransChk() != null && korAmendInfoVO.getTransChk().equals("Y")) {
				// BL Correction 정보 조회
				korCorrTransVO.setTransChk("Y");
				if (dbDao.searchBlCorrTransY(korCorrTransVO) != null)
					korCorrTransVO = dbDao.searchBlCorrTransY(korCorrTransVO);

			} else {
				// Trans Check 이 N인 경우
				// BL Correction 정보 조회
				korCorrTransVO.setTransChk("N");
				if (dbDao.searchBlCorrTransN(korCorrTransVO) != null)
					korCorrTransVO = dbDao.searchBlCorrTransN(korCorrTransVO);

			}

			// 조회 결과 DELT_FLG 이 Y 인 경우 오류 처리
			if (korCorrTransVO != null && korCorrTransVO.getDeltFlg() != null && korCorrTransVO.getDeltFlg().equals("Y")) {
				throw new EventException(new ErrorHandler("BKG01112").getMessage());
			}

			if (korCorrTransVO.getCgoTrspCd()==null || korCorrTransVO.getCgoTrspCd().trim().length() < 1) {
				// Cargo Spec 조회
				korCgoSpecVO.setBkgNo(korCorrTransVO.getBkgNo());
				cgoSpec = dbDao.searchCgoSpec(korCgoSpecVO);
				// 조회 결과가 1이상인 경우 처리
				if (cgoSpec != null && cgoSpec.compareTo("0") > 0) {
					// In Bound 만 해당
					if (condVO.getIoBndCd().equals("I")) {
						if (condVO.getCstmsDeclTpCd().equals("I")) {
							cgoSpec = "1";
						} else {
							if (korCorrTransVO.getDelCd() != null && korCorrTransVO.getDelCd().startsWith("KR")) {
								cgoSpec = "1";
							} else {
								cgoSpec = "2";
							}
						}
					} else {
						cgoSpec = "";
					}
				}
			} else {
				cgoSpec = korCorrTransVO.getCgoTrspCd();
			}

			// BL 별 Container 정보 조회
			korCntrCorrVO.setBkgNo			(korCorrTransVO.getBkgNo()			);
			korCntrCorrVO.setCstmsDeclTpCd	(korCorrTransVO.getCstmsDeclTpCd()	);
			korCntrCorrVO.setPortCd			(portCd								);
			korCntrCorrVO.setVvd			(korCorrTransVO.getVvd()			);
			korCntrCorrVO.setSmtAmdNo		(korCorrTransVO.getSmtAmdNo()		);
			korCntrCorrVO.setBlNo			(korCorrTransVO.getBlNo()			);
			korCntrCorrVOs = dbDao.searchCNTRCorrInfo(korCntrCorrVO);

			// CUSTOMER 정보 조회
			korCustCorrVO.setBkgNo			(korCorrTransVO.getBkgNo()			);
			korCustCorrVO.setPortCd			(portCd								);
			korCustCorrVO.setCstmsDeclTpCd	(korCorrTransVO.getCstmsDeclTpCd()	);
			korCustCorrVO = dbDao.searchCustCorrInfo(korCustCorrVO);

			// Export License 정보 조회
			korExpCorrVO.setBkgNo			(korCorrTransVO.getBkgNo()			);
			korExpCorrVO.setCstmsDeclTpCd	(korCorrTransVO.getCstmsDeclTpCd()	);
			korExpCorrVO.setPortCd			(portCd								);
			korExpCorrVO.setSmtAmdNo		(korCorrTransVO.getSmtAmdNo()		);
			korExpCorrVO.setBlNo			(korCorrTransVO.getBlNo()			);
			korExpCorrVOs = dbDao.searchExportCorrInfo(korExpCorrVO);

			// CORRECTION LIST 조회
			korCorrListVO.setSmtAmdNo(korCorrTransVO.getSmtAmdNo());
			korCorrListVOs = dbDao.searchCorrList(korCorrListVO);

			// 최종 리턴 객체에 담기
			korBlInfoVO.setCgoSpec(cgoSpec);
			korBlInfoVO.setKorCorrTransVO(korCorrTransVO);
			korBlInfoVO.setKorCntrCorrVOs(korCntrCorrVOs);
			korBlInfoVO.setKorCustCorrVO(korCustCorrVO);
			korBlInfoVO.setKorExpCorrVOs(korExpCorrVOs);
			korBlInfoVO.setKorCorrListVOs(korCorrListVOs);
			korBlInfoVO.setKorAmendInfoVO(korAmendInfoVO);

		} catch (EventException evx) {
			log.error("err " + evx.toString(), evx);
			throw evx;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return korBlInfoVO;
	}

	/**
	 * Amendment Manifest 정보 추가/수정/삭제
	 * @param ManifestAmdManiVO manifestAmdManiVO
	 * @exception EventException
	 */
	public void manageAmdManifest(ManifestAmdManiVO manifestAmdManiVO) throws EventException {
		// 파라메터 객체 변환
		KorManifestAmdManiVO condVO = (KorManifestAmdManiVO)manifestAmdManiVO;
		KorBlAmdVO korBlAmdVO = condVO.getKorBlAmdVO();
		KorCntrCorrVO[] korCntrCorrVOs = condVO.getKorCntrCorrVOs();
		KorCustCorrVO korCustCorrVO = condVO.getKorCustCorrVO();
		KorExpCorrVO[] korExpCorrVOs = condVO.getKorExpCorrVOs();
		KorCorrListVO[] korCorrListVOs = condVO.getKorCorrListVOs();

		// MODE 구분
		String mode = condVO.getMode();
		// TYPE 구분
		String inType = condVO.getInType();
		// PORT 구분
		String portCd = "";
		// PORT
		String polLoc = condVO.getPolLoc();
		String podLoc = condVO.getPodLoc();
		// BL_NO
		String blNo = korBlAmdVO.getBlNo();
		String orgBlNo = korBlAmdVO.getOrgBlNo();
		// SEQ 조회
		String seq = null;
		BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();
		// Container 삭제용 객체
		BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
		// Container 추가용 객체
		KorCntrInqInfoVO korCntrInqInfoVO = new KorCntrInqInfoVO();
		// Customer 추가용 객체
		KorCustInqInfoVO korCustInqInfoVO = new KorCustInqInfoVO();
		// Export License 처리용 객체
		KorElnoInqInfoVO korElnoInqInfoVO = new KorElnoInqInfoVO();
		// 전송여부 체크
		String transChk = "N";
		KorCorrTransVO korCorrTransVO = new KorCorrTransVO();
		// Submit No
		String subNo = null;
		KorMakeSubNoVO korMakeSubNoVO = new KorMakeSubNoVO();
		// Correction 정정 정보 추가용 VO
		KorCorrInfoVO korCorrInfoVO = new KorCorrInfoVO();
		// BL Correction 세부 정보 추가용 VO
		KorBlCorrVO korBlCorrVO = new KorBlCorrVO();
		// Container Correction 세부 정보 추가용 VO
		KorCntrCorrVO korCntrCorrVO = new KorCntrCorrVO();
		// Export License 세부 정보 추가용 VO
		KorExportCorrVO korExportCorrVO = new KorExportCorrVO();


		try {

			if (mode.equals("ADD")) {
				// ADD B/L의 경우

				// IN TYPE 처리
				if (korBlAmdVO.getIoBndCd().equals("I")) {
					inType = "N";
				} else {
					if (korBlAmdVO.getCstmsDeclTpCd().equals("R") || korBlAmdVO.getBkgCgoTpCd().equals("P")) {
						inType = "C";
					} else if (korBlAmdVO.getPodCd() != null &&
							  (korBlAmdVO.getPodCd().startsWith("US") || korBlAmdVO.getPodCd().startsWith("CA") ||
							   korBlAmdVO.getPodCd().startsWith("MX") || korBlAmdVO.getPodCd().startsWith("GT")) ) {
						inType = "A";
					} else {
						inType = "B";
					}
				}

				// PORT 처리
				if (polLoc==null || polLoc.length() < 5) polLoc = korBlAmdVO.getPolCd();
				if (podLoc==null || podLoc.length() < 5) podLoc = korBlAmdVO.getPodCd();
				if (korBlAmdVO.getIoBndCd().equals("I")) {
					portCd = podLoc;
				} else {
					portCd = polLoc;
				}

				// BL AmdInfo ADD
				korBlAmdVO.setUserId		(condVO.getUserId()	);
				korBlAmdVO.setPortCd		(portCd				);
				korBlAmdVO.setKrCstmsBndCd	(inType				);
				// BL Info INSERT
				dbDao.addBlAmdInfo(korBlAmdVO);

				// SEQ 조회
				bkgCstmsKrBlVO.setBkgNo	(korBlAmdVO.getBkgNo()			);
				bkgCstmsKrBlVO.setKcdTp	(korBlAmdVO.getCstmsDeclTpCd()	);
				bkgCstmsKrBlVO.setKtPort(korBlAmdVO.getPortCd()			);
				seq = dbDao.searchMaxSeq(bkgCstmsKrBlVO);
				if (seq==null || seq.equals("0")) seq = "1";

				// Container Tab 처리
				if (korCntrCorrVOs != null && korCntrCorrVOs.length > 0 ) {
					// Container 정보 삭제
					bkgCstmsKrCntrVO.setBkgNo	(korBlAmdVO.getBkgNo()			);
					bkgCstmsKrCntrVO.setKcdTp	(korBlAmdVO.getCstmsDeclTpCd()	);
					bkgCstmsKrCntrVO.setKtPort	(korBlAmdVO.getPortCd()			);
					bkgCstmsKrCntrVO.setKtSeq	(seq							);
					bkgCstmsKrCntrVO.setCBlNo	(korBlAmdVO.getBlNo()			);
					dbDao.removeCNTRInfoKor(bkgCstmsKrCntrVO);

					// Container 정보 추가
					korCntrInqInfoVO.setKcBkgNo			(korBlAmdVO.getBkgNo()			);
					korCntrInqInfoVO.setKcCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
					korCntrInqInfoVO.setTrnsSeq			(seq							);
					korCntrInqInfoVO.setPortCd			(portCd							);
					korCntrInqInfoVO.setUserId			(condVO.getUserId()				);
					// LOOP
					for (int i=0; i < korCntrCorrVOs.length; i++ ) {
						// Add Container ( Flag가 D 가 아닌 경우INSERT )
						if (korCntrCorrVOs[i].getIbflag().equals("D")) continue;
						// SHEET 값 매핑
						korCntrInqInfoVO.setKcCntrNo		(korCntrCorrVOs[i].getCntrNo()		);
						korCntrInqInfoVO.setKcFullMtyCd		(korCntrCorrVOs[i].getFullMtyCd()	);
						korCntrInqInfoVO.setKcCntrSealNo1	(korCntrCorrVOs[i].getCntrSealNo1()	);
						korCntrInqInfoVO.setKcCntrSealNo2	(korCntrCorrVOs[i].getCntrSealNo2()	);
						korCntrInqInfoVO.setKcPckQty		(korCntrCorrVOs[i].getPckQty()		);
						korCntrInqInfoVO.setKcPckTpCd		(korCntrCorrVOs[i].getPckTpCd()		);
						korCntrInqInfoVO.setKcCntrWgt		(korCntrCorrVOs[i].getCntrWgt()		);
						korCntrInqInfoVO.setKcWgtUtCd		(korCntrCorrVOs[i].getWgtUtCd()		);
						korCntrInqInfoVO.setKcMeasQty		(korCntrCorrVOs[i].getMeasQty()		);
						korCntrInqInfoVO.setKcMeasUtCd		(korCntrCorrVOs[i].getMeasUtCd()	);
						korCntrInqInfoVO.setKcCntrTpszCd	(korCntrCorrVOs[i].getCntrTpszCd()	);
						korCntrInqInfoVO.setBlNo			(blNo								);
						// INSERT
						dbDao.addCNTRInqInfo(korCntrInqInfoVO);
					}
				} // End Container

				// CUSTOMER TAB 처리
				korCustInqInfoVO.setUserId			(condVO.getUserId()				);
				korCustInqInfoVO.setBkgNo			(korBlAmdVO.getBkgNo()			);
				korCustInqInfoVO.setCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				korCustInqInfoVO.setPortCd			(portCd							);
				korCustInqInfoVO.setTrnsSeq			(seq							);
				korCustInqInfoVO.setSCustNm			(korCustCorrVO.getSCustNm()		);
				korCustInqInfoVO.setSCustAddr		(korCustCorrVO.getSCustAddr()	);
				korCustInqInfoVO.setCCustNm			(korCustCorrVO.getCCustNm()		);
				korCustInqInfoVO.setCCustAddr		(korCustCorrVO.getCCustAddr()	);
				korCustInqInfoVO.setNCustNm			(korCustCorrVO.getNCustNm()		);
				korCustInqInfoVO.setNCustAddr		(korCustCorrVO.getNCustAddr()	);
				// CUSTOMER 정보 INSERT
				dbDao.addCustInqInfo(korCustInqInfoVO);

				// Export License TAB 처리
				korElnoInqInfoVO.setKeBkgNo			(korBlAmdVO.getBkgNo()			);
				korElnoInqInfoVO.setKeCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				korElnoInqInfoVO.setPortCd			(portCd							);
				korElnoInqInfoVO.setKeTrnsSeq		(seq							);
				korElnoInqInfoVO.setUserId			(condVO.getUserId()				);
				// Export License 삭제
				dbDao.removeElnoInqInfo(korElnoInqInfoVO);


				if (korExpCorrVOs != null) {
					// Loop
					for (int i=0; i < korExpCorrVOs.length; i++) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korExpCorrVOs[i].getIbflag().equals("D")) continue;
						// SHEET 값 매핑
						korElnoInqInfoVO.setKeXptLicNo		(korExpCorrVOs[i].getXptLicNo()		);
						korElnoInqInfoVO.setKePckQty		(korExpCorrVOs[i].getPckQty()		);
						korElnoInqInfoVO.setKePckTpCd		(korExpCorrVOs[i].getPckTpCd()		);
						korElnoInqInfoVO.setKeCntrWgt		(korExpCorrVOs[i].getCntrWgt()		);
						korElnoInqInfoVO.setKeWgtUtCd		(korExpCorrVOs[i].getWgtUtCd()		);
						korElnoInqInfoVO.setKePrtLodgFlg	(korExpCorrVOs[i].getPrtLodgFlg()	);
						korElnoInqInfoVO.setKePrtLodgSeq	(korExpCorrVOs[i].getPrtLodgSeq()	);
						korElnoInqInfoVO.setKeDivdPckQty	(korExpCorrVOs[i].getDivdPckQty()	);
						korElnoInqInfoVO.setKeDivdPckUtCd	(korExpCorrVOs[i].getDivdPckUtCd()	);
						korElnoInqInfoVO.setKeKrXptPckId	(korExpCorrVOs[i].getKrXptPckId()	);
						korElnoInqInfoVO.setBlNo			(blNo								);

						// Export License INSERT
						dbDao.addElnoInqInfo(korElnoInqInfoVO);
					}
				}

				// 전송여부 Check
				korCorrTransVO.setBlNo			(orgBlNo						);
				korCorrTransVO.setPortCd		(portCd							);
				korCorrTransVO.setCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				transChk = dbDao.searchCorrTransChk(korCorrTransVO);
				if (transChk==null) transChk = "N";

				if (subNo==null || subNo.trim().length() < 1 || transChk.equals("Y")) {
					// Submit No 생성
					korMakeSubNoVO.setVvd		(korBlAmdVO.getVvd()	);
					korMakeSubNoVO.setIoBndCd	(korBlAmdVO.getIoBndCd());
					korMakeSubNoVO.setPolLoc	(condVO.getPolLoc()		);
					korMakeSubNoVO.setPodLoc	(condVO.getPodLoc()		);
					subNo = dbDao.searchMakeSubNo(korMakeSubNoVO);
				}

				// 정정 정보 삭제
				dbDao.removeCorrInfo(subNo);

				// 정정 정보 추가
				korCorrInfoVO.setSubNo			(subNo							);
				korCorrInfoVO.setBkgNo			(korBlAmdVO.getBkgNo()			);
				korCorrInfoVO.setCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				korCorrInfoVO.setBlNo			(orgBlNo						);
				korCorrInfoVO.setCBlNo			(blNo							);
				korCorrInfoVO.setKrCstmsCorrId	(korBlAmdVO.getKrCstmsCorrId()	);
				korCorrInfoVO.setCorrRsn		(korBlAmdVO.getCorrRsn()		);
				korCorrInfoVO.setUserId			(condVO.getUserId()				);
				korCorrInfoVO.setTrnsSeq		(seq							);
				korCorrInfoVO.setPortCd			(portCd							);
				korCorrInfoVO.setAmdtRcvrFlg	(korBlAmdVO.getAmdtRcvrFlg()	);
				korCorrInfoVO.setKrVslCallSgnCd	(korBlAmdVO.getVslCallSgnCd()	);
				korCorrInfoVO.setCallYr			(korBlAmdVO.getEtaDt()			);
				korCorrInfoVO.setCallKnt		(korBlAmdVO.getCallKnt()		);
				korCorrInfoVO.setVslNm			(korBlAmdVO.getVslNm()			);
				korCorrInfoVO.setVslRgstCntCd	(korBlAmdVO.getVslCntCd()		);
				korCorrInfoVO.setIoTmlLocCd		(korBlAmdVO.getIoTmlLocCd()		);
				korCorrInfoVO.setDchgMzdCd		(korBlAmdVO.getDchgMzdCd()		);
				korCorrInfoVO.setVvd			(korBlAmdVO.getVvd()			);
				// INSERT
				dbDao.addCorrInfo(korCorrInfoVO);

				// BL CorrInfo 추가
				korBlCorrVO.setSubNo	(subNo				);
				korBlCorrVO.setPortCd	(portCd				);
				korBlCorrVO.setUserId	(condVO.getUserId()	);
				if (korCorrListVOs != null) {
					// LOOP
					for (int i=0; i < korCorrListVOs.length; i++) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korCorrListVOs[i].getIbflag().equals("D")) continue;
						// 파라메터 셋팅
						korBlCorrVO.setTrnsSeq		(String.valueOf(i)						);
						korBlCorrVO.setKrCstmsCorrId(korCorrListVOs[i].getKrCstmsCorrId()	);
						korBlCorrVO.setCorrRsn		(korCorrListVOs[i].getCorrRsn()			);
						korBlCorrVO.setCrntCtnt1	(korCorrListVOs[i].getCrntCtnt1()		);
						korBlCorrVO.setCrntCtnt2	(korCorrListVOs[i].getCrntCtnt2()		);
						korBlCorrVO.setCrntCtnt3	(korCorrListVOs[i].getCrntCtnt3()		);
						korBlCorrVO.setCrntCtnt4	(korCorrListVOs[i].getCrntCtnt4()		);
						korBlCorrVO.setPreCtnt1		(korCorrListVOs[i].getPreCtnt1()		);
						korBlCorrVO.setPreCtnt2		(korCorrListVOs[i].getPreCtnt2()		);
						korBlCorrVO.setPreCtnt3		(korCorrListVOs[i].getPreCtnt3()		);
						korBlCorrVO.setPreCtnt4		(korCorrListVOs[i].getPreCtnt4()		);
						// BL Correction INSERT
						dbDao.addBlCorrInfo(korBlCorrVO);
					}
				}

				// Container 정정 정보 삭제
				dbDao.removeCNTRCorrInfo(subNo);

				// Container 정정 세부 정보 추가
				korCntrCorrVO.setUserId		(condVO.getUserId()	);
				korCntrCorrVO.setSmtAmdNo	(subNo				);
				korCntrCorrVO.setPortCd		(portCd				);
				if (korCntrCorrVOs != null) {
					// LOOP
					for (int i=0; i < korCntrCorrVOs.length; i++ ) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korCntrCorrVOs[i].getIbflag().equals("D")) continue;
						// 파라메터 셋팅
						korCntrCorrVO.setCntrNo			(korCntrCorrVOs[i].getCntrNo()			);
						korCntrCorrVO.setKrCstmsCorrId	(korCntrCorrVOs[i].getKrCstmsCorrId()	);
						korCntrCorrVO.setCorrRsn		(korCntrCorrVOs[i].getCorrRsn()			);
						korCntrCorrVO.setCntrSealNo1	(korCntrCorrVOs[i].getCntrSealNo1()		);
						korCntrCorrVO.setCntrSealNo2	(korCntrCorrVOs[i].getCntrSealNo2()		);
						korCntrCorrVO.setPreDatCtnt		(korCntrCorrVOs[i].getPreDatCtnt()		);
						korCntrCorrVO.setCrntDatCtnt	(korCntrCorrVOs[i].getCrntDatCtnt()		);
						korCntrCorrVO.setKrCstmsCorrId2	(korCntrCorrVOs[i].getKrCstmsCorrId2()	);
						korCntrCorrVO.setPreCntrNo		(korCntrCorrVOs[i].getPreCntrNo()		);
						// CNTR Correction INSERT
						dbDao.addCNTRCorrInfo(korCntrCorrVO);
					}
				}

				// Export License 정보 삭제
				dbDao.removeExportCorrInfo(subNo);

				// BL CorrInfo 삭제
				dbDao.removeBlCorrInfo(subNo);

				// Export License 정정 세부 정보 추가
				korExportCorrVO.setSmtAmdNo	(subNo				);
				korExportCorrVO.setPortCd	(portCd				);
				korExportCorrVO.setUserId	(condVO.getUserId()	);
				if (korExpCorrVOs != null) {
					// LOOP
					for (int i=0; i < korExpCorrVOs.length; i++) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korExpCorrVOs[i].getIbflag().equals("D")) continue;
						// 파라메터 셋팅
						korExportCorrVO.setXptLicNo		(korExpCorrVOs[i].getXptLicNo()		);
						korExportCorrVO.setKrCstmsCorrId(korExpCorrVOs[i].getKrCstmsCorrId());
						korExportCorrVO.setCorrRsn		(korExpCorrVOs[i].getCorrRsn()		);
						korExportCorrVO.setPckQty		(korExpCorrVOs[i].getPckQty()		);
						korExportCorrVO.setPckTpCd		(korExpCorrVOs[i].getPckTpCd()		);
						korExportCorrVO.setCntrWgt		(korExpCorrVOs[i].getCntrWgt()		);
						korExportCorrVO.setWgtUtCd		(korExpCorrVOs[i].getWgtUtCd()		);
						korExportCorrVO.setPrtLodgFlg	(korExpCorrVOs[i].getPrtLodgFlg()	);
						korExportCorrVO.setPrtLodgSeq	(korExpCorrVOs[i].getPrtLodgSeq()	);
						korExportCorrVO.setDivdPckQty	(korExpCorrVOs[i].getDivdPckQty()	);
						korExportCorrVO.setDivdPckUtCd	(korExpCorrVOs[i].getDivdPckUtCd()	);
						korExportCorrVO.setDivdWgt		("0"								);
						korExportCorrVO.setDivdWgtUtCd	(korExpCorrVOs[i].getDivdWgtUtCd()	);
						korExportCorrVO.setKrXptPckId	(korExpCorrVOs[i].getKrXptPckId()	);
						korExportCorrVO.setPreXptLicNo	(korExpCorrVOs[i].getPreXptLicNo()	);
						// Export License Correction INSERT
						dbDao.addExportCorrInfo(korExportCorrVO);
					}
				}

			} else {
				// EDIT B/L의 경우

				// PORT 처리
				if (korBlAmdVO.getIoBndCd().equals("I")) {
					portCd = podLoc;
				} else {
					portCd = polLoc;
				}
				// SUB NO
				subNo = korBlAmdVO.getSubNo();

				// BL 정보 UPDATE
				korBlAmdVO.setUserId(condVO.getUserId()	);
				korBlAmdVO.setPortCd(portCd				);
				dbDao.modifyBlAmdInfo(korBlAmdVO);

				// Container KCD TP Update
				KorKcdTpCntrVO korKcdTpCntrVO = new KorKcdTpCntrVO();
				ObjectCloner.build(korBlAmdVO, korKcdTpCntrVO);
				dbDao.modifyKcdTpInCntr(korKcdTpCntrVO);

				// ELNO KCD TP Update
				KorKcdTpElnoVO korKcdTpElnoVO = new KorKcdTpElnoVO();
				ObjectCloner.build(korBlAmdVO, korKcdTpElnoVO);
				dbDao.modifyKcdTpInElno(korKcdTpElnoVO);

				// SEQ 조회
				bkgCstmsKrBlVO.setBkgNo	(korBlAmdVO.getBkgNo()			);
				bkgCstmsKrBlVO.setKcdTp	(korBlAmdVO.getCstmsDeclTpCd()	);
				bkgCstmsKrBlVO.setKtPort(korBlAmdVO.getPortCd()			);
				seq = dbDao.searchMaxSeq(bkgCstmsKrBlVO);
				if (seq==null || seq.equals("0")) seq = "1";

				// Container Tab 처리
				if (korCntrCorrVOs != null && korCntrCorrVOs.length > 0 ) {
					// Container 정보 삭제
					bkgCstmsKrCntrVO.setBkgNo	(korBlAmdVO.getBkgNo()			);
					//bkgCstmsKrCntrVO.setKcdTp	(korBlAmdVO.getCstmsDeclTpCd()	);
					bkgCstmsKrCntrVO.setKcdTp	(korBlAmdVO.getOldCstmsDeclTpCd()	);
					bkgCstmsKrCntrVO.setKtPort	(korBlAmdVO.getPortCd()			);
					bkgCstmsKrCntrVO.setKtSeq	(seq							);
					bkgCstmsKrCntrVO.setCBlNo	(korBlAmdVO.getBlNo()			);
					dbDao.removeCNTRInfoKor(bkgCstmsKrCntrVO);

					// Container 정보 추가
					korCntrInqInfoVO.setKcBkgNo			(korBlAmdVO.getBkgNo()			);
					korCntrInqInfoVO.setKcCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
					korCntrInqInfoVO.setTrnsSeq			(seq					 		);
					korCntrInqInfoVO.setPortCd			(portCd							);
					korCntrInqInfoVO.setUserId			(condVO.getUserId()				);
					korCntrInqInfoVO.setBlNo			(korBlAmdVO.getBlNo()			);
					// LOOP
					for (int i=0; i < korCntrCorrVOs.length; i++ ) {
						// Add Container ( Flag가 D 가 아닌 경우INSERT )
						if (korCntrCorrVOs[i].getIbflag().equals("D")) continue;
						// SHEET 값 매핑
						korCntrInqInfoVO.setKcCntrNo		(korCntrCorrVOs[i].getCntrNo()		);
						korCntrInqInfoVO.setKcFullMtyCd		(korCntrCorrVOs[i].getFullMtyCd()	);
						korCntrInqInfoVO.setKcCntrSealNo1	(korCntrCorrVOs[i].getCntrSealNo1()	);
						korCntrInqInfoVO.setKcCntrSealNo2	(korCntrCorrVOs[i].getCntrSealNo2()	);
						korCntrInqInfoVO.setKcPckQty		(korCntrCorrVOs[i].getPckQty()		);
						korCntrInqInfoVO.setKcPckTpCd		(korCntrCorrVOs[i].getPckTpCd()		);
						korCntrInqInfoVO.setKcCntrWgt		(korCntrCorrVOs[i].getCntrWgt()		);
						korCntrInqInfoVO.setKcWgtUtCd		(korCntrCorrVOs[i].getWgtUtCd()		);
						korCntrInqInfoVO.setKcMeasQty		(korCntrCorrVOs[i].getMeasQty()		);
						korCntrInqInfoVO.setKcMeasUtCd		(korCntrCorrVOs[i].getMeasUtCd()	);
						korCntrInqInfoVO.setKcCntrTpszCd	(korCntrCorrVOs[i].getCntrTpszCd()	);
						// INSERT
						dbDao.addCNTRInqInfo(korCntrInqInfoVO);
					}
				} // End Container

				// CUSTOMER TAB 처리
				korCustInqInfoVO.setBkgNo			(korBlAmdVO.getBkgNo()			 );
				korCustInqInfoVO.setCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	 );
				korCustInqInfoVO.setOldCstmsDeclTpCd(korBlAmdVO.getOldCstmsDeclTpCd());
				korCustInqInfoVO.setPortCd			(portCd							 );
				korCustInqInfoVO.setTrnsSeq			(seq							 );
				korCustInqInfoVO.setSCustNm			(korCustCorrVO.getSCustNm()		 );
				korCustInqInfoVO.setSCustAddr		(korCustCorrVO.getSCustAddr()	 );
				korCustInqInfoVO.setCCustNm			(korCustCorrVO.getCCustNm()		 );
				korCustInqInfoVO.setCCustAddr		(korCustCorrVO.getCCustAddr()	 );
				korCustInqInfoVO.setNCustNm			(korCustCorrVO.getNCustNm()		 );
				korCustInqInfoVO.setNCustAddr		(korCustCorrVO.getNCustAddr()	 );
				korCustInqInfoVO.setUserId			(condVO.getUserId()				 );

				// Cust CNT 조회
				KorCustCntVO korCustCntVO = new KorCustCntVO();
				ObjectCloner.build(korBlAmdVO, korCustCntVO);
				String custCnt = dbDao.searchCustCnt(korCustCntVO);

				// Customer Count 가 0 인경우
				if (custCnt.equals("0")) {
					// Customer 정보 UPDATE
					dbDao.modifyCustInqInfo(korCustInqInfoVO);
				} else {
					// Customer Count 가 0이 아닌 경우
					KorCustInqVO korCustInqVO = new KorCustInqVO();
					ObjectCloner.build(korCustInqInfoVO, korCustInqVO);
					korCustInqVO.setCstmsDeclTpCd(korBlAmdVO.getCstmsDeclTpCd());
					dbDao.modifyCustInq(korCustInqVO);
				}

				// 전송여부 Check
				korCorrTransVO.setBlNo			(orgBlNo						);
				korCorrTransVO.setPortCd		(portCd							);
				korCorrTransVO.setCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				transChk = dbDao.searchCorrTransChk(korCorrTransVO);
				if (transChk==null) transChk = "N";

				if (subNo==null || subNo.trim().length() < 1 || transChk.equals("Y")) {
					// Submit No 생성
					korMakeSubNoVO.setVvd		(korBlAmdVO.getVvd()	);
					korMakeSubNoVO.setIoBndCd	(korBlAmdVO.getIoBndCd());
					korMakeSubNoVO.setPolLoc	(condVO.getPolLoc()		);
					korMakeSubNoVO.setPodLoc	(condVO.getPodLoc()		);
					subNo = dbDao.searchMakeSubNo(korMakeSubNoVO);
				}

				// Export License TAB 처리
				korElnoInqInfoVO.setKeBkgNo			(korBlAmdVO.getBkgNo()			);
				//korElnoInqInfoVO.setKeCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				korElnoInqInfoVO.setKeCstmsDeclTpCd	(korBlAmdVO.getOldCstmsDeclTpCd()	);
				korElnoInqInfoVO.setPortCd			(portCd							);
				korElnoInqInfoVO.setKeTrnsSeq		(seq							);
				korElnoInqInfoVO.setUserId			(condVO.getUserId()				);
				korElnoInqInfoVO.setBlNo			(blNo							);

				// Export License 삭제
				dbDao.removeElnoInqInfo(korElnoInqInfoVO);

				if (korExpCorrVOs != null) {
					// Loop
					for (int i=0; i < korExpCorrVOs.length; i++) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korExpCorrVOs[i].getIbflag().equals("D")) continue;

						// SHEET 값 매핑
						korElnoInqInfoVO.setKeXptLicNo		(korExpCorrVOs[i].getXptLicNo()		);
						korElnoInqInfoVO.setKePckQty		(korExpCorrVOs[i].getPckQty()		);
						korElnoInqInfoVO.setKePckTpCd		(korExpCorrVOs[i].getPckTpCd()		);
						korElnoInqInfoVO.setKeCntrWgt		(korExpCorrVOs[i].getCntrWgt()		);
						korElnoInqInfoVO.setKeWgtUtCd		(korExpCorrVOs[i].getWgtUtCd()		);
						korElnoInqInfoVO.setKePrtLodgFlg	(korExpCorrVOs[i].getPrtLodgFlg()	);
						korElnoInqInfoVO.setKePrtLodgSeq	(korExpCorrVOs[i].getPrtLodgSeq()	);
						korElnoInqInfoVO.setKeDivdPckQty	(korExpCorrVOs[i].getDivdPckQty()	);
						korElnoInqInfoVO.setKeDivdPckUtCd	(korExpCorrVOs[i].getDivdPckUtCd()	);
						korElnoInqInfoVO.setKeKrXptPckId	(korExpCorrVOs[i].getKrXptPckId()	);
						korElnoInqInfoVO.setBlNo			(blNo								);
						korElnoInqInfoVO.setKeCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);  //추가
						// Export License INSERT
						dbDao.addElnoInqInfo(korElnoInqInfoVO);
					}
				}

				// BL CorrInfo 삭제
				dbDao.removeBlCorrInfo(subNo);

				// Container 정정 정보 삭제
				dbDao.removeCNTRCorrInfo(subNo);

				// Export License 정보 삭제
				dbDao.removeExportCorrInfo(subNo);

				// 정정 정보 삭제
				dbDao.removeCorrInfo(subNo);

				// 정정 정보 추가
				korCorrInfoVO.setSubNo			(subNo							);
				korCorrInfoVO.setBkgNo			(korBlAmdVO.getBkgNo()			);
				korCorrInfoVO.setCstmsDeclTpCd	(korBlAmdVO.getCstmsDeclTpCd()	);
				korCorrInfoVO.setBlNo			(orgBlNo						);
				korCorrInfoVO.setCBlNo			(blNo							);
				korCorrInfoVO.setKrCstmsCorrId	(korBlAmdVO.getKrCstmsCorrId()	);
				korCorrInfoVO.setCorrRsn		(korBlAmdVO.getCorrRsn()		);
				korCorrInfoVO.setUserId			(condVO.getUserId()				);
				korCorrInfoVO.setTrnsSeq		(seq							);
				korCorrInfoVO.setPortCd			(portCd							);
				korCorrInfoVO.setAmdtRcvrFlg	(korBlAmdVO.getAmdtRcvrFlg()	);
				korCorrInfoVO.setKrVslCallSgnCd	(korBlAmdVO.getVslCallSgnCd()	);
				korCorrInfoVO.setCallYr			(korBlAmdVO.getEtaDt()			);
				korCorrInfoVO.setCallKnt		(korBlAmdVO.getCallKnt()		);
				korCorrInfoVO.setVslNm			(korBlAmdVO.getVslNm()			);
				korCorrInfoVO.setVslRgstCntCd	(korBlAmdVO.getVslCntCd()		);
				korCorrInfoVO.setIoTmlLocCd		(korBlAmdVO.getIoTmlLocCd()		);
				korCorrInfoVO.setDchgMzdCd		(korBlAmdVO.getDchgMzdCd()		);
				korCorrInfoVO.setVvd			(korBlAmdVO.getVvd()			);
				// INSERT
				dbDao.addCorrInfo(korCorrInfoVO);

				// BL CorrInfo 추가
				korBlCorrVO.setSubNo	(subNo				);
				korBlCorrVO.setPortCd	(portCd				);
				korBlCorrVO.setUserId	(condVO.getUserId()	);
				if (korCorrListVOs != null) {
					// LOOP
					for (int i=0; i < korCorrListVOs.length; i++) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korCorrListVOs[i].getIbflag().equals("D")) continue;
						// 파라메터 셋팅
						korBlCorrVO.setTrnsSeq		(String.valueOf(i)						);
						korBlCorrVO.setKrCstmsCorrId(korCorrListVOs[i].getKrCstmsCorrId()	);
						korBlCorrVO.setCorrRsn		(korCorrListVOs[i].getCorrRsn()			);
						korBlCorrVO.setCrntCtnt1	(korCorrListVOs[i].getCrntCtnt1()		);
						korBlCorrVO.setCrntCtnt2	(korCorrListVOs[i].getCrntCtnt2()		);
						korBlCorrVO.setCrntCtnt3	(korCorrListVOs[i].getCrntCtnt3()		);
						korBlCorrVO.setCrntCtnt4	(korCorrListVOs[i].getCrntCtnt4()		);
						korBlCorrVO.setPreCtnt1		(korCorrListVOs[i].getPreCtnt1()		);
						korBlCorrVO.setPreCtnt2		(korCorrListVOs[i].getPreCtnt2()		);
						korBlCorrVO.setPreCtnt3		(korCorrListVOs[i].getPreCtnt3()		);
						korBlCorrVO.setPreCtnt4		(korCorrListVOs[i].getPreCtnt4()		);
						// BL Correction INSERT
						dbDao.addBlCorrInfo(korBlCorrVO);
					}
				}

				// Container 정정 세부 정보 추가
				korCntrCorrVO.setUserId		(condVO.getUserId()	);
				korCntrCorrVO.setSmtAmdNo	(subNo				);
				korCntrCorrVO.setPortCd		(portCd				);
				if (korCntrCorrVOs != null) {
					// LOOP
					for (int i=0; i < korCntrCorrVOs.length; i++ ) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korCntrCorrVOs[i].getIbflag().equals("D")) continue;
						// 파라메터 셋팅
						korCntrCorrVO.setCntrNo			(korCntrCorrVOs[i].getCntrNo()			);
						korCntrCorrVO.setKrCstmsCorrId	(korCntrCorrVOs[i].getKrCstmsCorrId()	);
						korCntrCorrVO.setCorrRsn		(korCntrCorrVOs[i].getCorrRsn()			);
						korCntrCorrVO.setCntrSealNo1	(korCntrCorrVOs[i].getCntrSealNo1()		);
						korCntrCorrVO.setCntrSealNo2	(korCntrCorrVOs[i].getCntrSealNo2()		);
						korCntrCorrVO.setPreDatCtnt		(korCntrCorrVOs[i].getPreDatCtnt()		);
						korCntrCorrVO.setCrntDatCtnt	(korCntrCorrVOs[i].getCrntDatCtnt()		);
						korCntrCorrVO.setKrCstmsCorrId2	(korCntrCorrVOs[i].getKrCstmsCorrId2()	);
						korCntrCorrVO.setPreCntrNo		(korCntrCorrVOs[i].getPreCntrNo()		);
						// CNTR Correction INSERT
						dbDao.addCNTRCorrInfo(korCntrCorrVO);
					}
				}

				// Export License 정정 세부 정보 추가
				korExportCorrVO.setSmtAmdNo	(subNo				);
				korExportCorrVO.setPortCd	(portCd				);
				korExportCorrVO.setUserId	(condVO.getUserId()	);
				if (korExpCorrVOs != null) {
					// LOOP
					for (int i=0; i < korExpCorrVOs.length; i++) {
						// Flag 가 D가 아닌 경우만 INSERT
						if (korExpCorrVOs[i].getIbflag().equals("D")) continue;
						// 파라메터 셋팅
						korExportCorrVO.setXptLicNo		(korExpCorrVOs[i].getXptLicNo()		);
						korExportCorrVO.setKrCstmsCorrId(korExpCorrVOs[i].getKrCstmsCorrId());
						korExportCorrVO.setCorrRsn		(korExpCorrVOs[i].getCorrRsn()		);
						korExportCorrVO.setPckQty		(korExpCorrVOs[i].getPckQty()		);
						korExportCorrVO.setPckTpCd		(korExpCorrVOs[i].getPckTpCd()		);
						korExportCorrVO.setCntrWgt		(korExpCorrVOs[i].getCntrWgt()		);
						korExportCorrVO.setWgtUtCd		(korExpCorrVOs[i].getWgtUtCd()		);
						korExportCorrVO.setPrtLodgFlg	(korExpCorrVOs[i].getPrtLodgFlg()	);
						korExportCorrVO.setPrtLodgSeq	(korExpCorrVOs[i].getPrtLodgSeq()	);
						korExportCorrVO.setDivdPckQty	(korExpCorrVOs[i].getDivdPckQty()	);
						korExportCorrVO.setDivdPckUtCd	(korExpCorrVOs[i].getDivdPckUtCd()	);
						korExportCorrVO.setDivdWgt		("0"								);
						korExportCorrVO.setDivdWgtUtCd	(korExpCorrVOs[i].getDivdWgtUtCd()	);
						korExportCorrVO.setKrXptPckId	(korExpCorrVOs[i].getKrXptPckId()	);
						korExportCorrVO.setPreXptLicNo	(korExpCorrVOs[i].getPreXptLicNo()	);
						// Export License Correction INSERT
						dbDao.addExportCorrInfo(korExportCorrVO);
					}
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * DG Cargo Manifest List 조회
	 * @param DgCgoManifestVO dgCgoManifestVO
	 * @return DgCgoManifestVO
	 * @exception EventException
	 */
	public DgCgoManifestVO searchDgCgoManifestList(DgCgoManifestVO dgCgoManifestVO) throws EventException {
		// 파라메터 변환
		KorDgCgoManifestVO condVO = (KorDgCgoManifestVO)dgCgoManifestVO;
		// 최종 결과 객체
		KorDgCgoManifestVO returnVO = new KorDgCgoManifestVO();
		// Bound 구분
		String ioBndCd = null;
		// MRN CHECK용 객체
		KorMrnValidVO korMrnValidVO = new KorMrnValidVO();
		String mrnCnt = null;
		// Container Count 조회용 객체
		KorBkgDgCntrVO korBkgDgCntrVO = new KorBkgDgCntrVO();
		String cntrCnt = null;
		// MRN NO 조회용 객체
		KorMrnNoVO korMrnNoVO = new KorMrnNoVO();
		// DG Cargo List 조회용 객체
		KorBkgDgCgoVO[] korBkgDgCgoVOs = null;
		KorBkgDgCgoVO korBkgDgCgoVO = new KorBkgDgCgoVO();
		// Loop 시 처리할 변수
		double totalWgt = 0d;
		String substance = null;
		String jobCode2 = "3";
		// VVD INFO 조회용 객체
		KorBkgDgVvdVO korBkgDgVvdVO =  new KorBkgDgVvdVO();
		KorDgVvdVO korDgVvdVO = new KorDgVvdVO();
		String[] vvdTokens = null;
		// InBound DG Cargo List 조회용 객체
		KorIbDgCgoVO[] korIbDgCgoVOs = null;
		KorIbDgCgoVO korIbDgCgoVO = new KorIbDgCgoVO();
		// OutBound DG Cargo List 조회용 객체
		KorObDgCgoVO[] korObDgCgoVOs = null;
		KorObDgCgoVO korObDgCgoVO = new KorObDgCgoVO();


		try {

			if (condVO.getPolCd() != null && condVO.getPolCd().trim().length() == 5) {
				ioBndCd = "O";
			} else {
				ioBndCd = "I";
			}

			// CURRENT 인경우
			if (condVO.getCurrentCheck().equals("C")) {

				// MRN Validation Check
				korMrnValidVO.setVvd	(condVO.getVvd()	);
				korMrnValidVO.setPolCd	(condVO.getPolCd()	);
				korMrnValidVO.setPodCd	(condVO.getPodCd()	);
				korMrnValidVO.setIoBndCd(ioBndCd			);
				mrnCnt = dbDao.searchMrnValidChk(korMrnValidVO);

				// MRN 이 0건이면 오류
				if (mrnCnt==null || mrnCnt.equals("0")) {
					throw new EventException(new ErrorHandler("BKG00689").getMessage());
				} else if (mrnCnt.compareTo("1") > 0) {
					// MRN 이 2건이상이면 오류
					throw new EventException(new ErrorHandler("BKG00689").getMessage());
				}

				// Container Count 조회
				ObjectCloner.build(korMrnValidVO, korBkgDgCntrVO);
				cntrCnt = dbDao.searchBkgDgCntrCnt(korBkgDgCntrVO);

				// MRN_NO 조회
				korMrnNoVO.setInVvd		(condVO.getVvd()	);
				korMrnNoVO.setInBound	(ioBndCd			);
				korMrnNoVO.setInPol		(condVO.getPolCd()	);
				korMrnNoVO.setInPod		(condVO.getPodCd()	);
				korMrnNoVO = dbDao.searchMrnNo(korMrnNoVO);

				// DG Cargo List 조회
				korBkgDgCgoVO.setVvd	(condVO.getVvd()	);
				korBkgDgCgoVO.setIoBndCd(ioBndCd			);
				korBkgDgCgoVO.setPolCd	(condVO.getPolCd()	);
				korBkgDgCgoVO.setPodCd	(condVO.getPodCd()	);
				korBkgDgCgoVO.setMrnNo	(korMrnNoVO.getMrnNo() + korMrnNoVO.getMrnChkNo());
				korBkgDgCgoVOs = dbDao.searchBkgDgCgoList(korBkgDgCgoVO);

				if (korBkgDgCgoVOs==null || korBkgDgCgoVOs.length < 1) {
//					throw new EventException(new ErrorHandler("BKG00889").getMessage());
					totalWgt = 0;
					DecimalFormat dformat = new DecimalFormat("#####0.000");
					substance = "T.B.N";

					// VVD 정보 조회
					korBkgDgVvdVO.setVvd		(condVO.getVvd()			);
					korBkgDgVvdVO.setIoBndCd	(ioBndCd					);
					korBkgDgVvdVO.setPolCd		(condVO.getPolCd()			);
					korBkgDgVvdVO.setPodCd		(condVO.getPodCd()			);
					korBkgDgVvdVO.setTotalCntr	(cntrCnt					);
					korBkgDgVvdVO.setTotalWgt	(dformat.format(totalWgt) 	);
					korBkgDgVvdVO.setSubstance	(substance					);
					korBkgDgVvdVO.setJobCode2	(jobCode2					);
					korBkgDgVvdVO.setUserId(condVO.getUserId());
				} else {

					// LOOP
					for (int i=0; i < korBkgDgCgoVOs.length; i++) {
						if (korBkgDgCgoVOs[i].getJob().equals("9")) jobCode2 = "9";
						// Weight 계산
						totalWgt = totalWgt + Double.valueOf(korBkgDgCgoVOs[i].getCalcWeight());
					}
					DecimalFormat dformat = new DecimalFormat("#####0.000");
					substance = korBkgDgCgoVOs[0].getPrpShpNm();

					// VVD 정보 조회
					korBkgDgVvdVO.setVvd		(condVO.getVvd()			);
					korBkgDgVvdVO.setIoBndCd	(ioBndCd					);
					korBkgDgVvdVO.setPolCd		(condVO.getPolCd()			);
					korBkgDgVvdVO.setPodCd		(condVO.getPodCd()			);
					korBkgDgVvdVO.setTotalCntr	(cntrCnt					);
					korBkgDgVvdVO.setTotalWgt	(dformat.format(totalWgt) 	);
					korBkgDgVvdVO.setSubstance	(substance					);
					korBkgDgVvdVO.setJobCode2	(jobCode2					);
					korBkgDgVvdVO.setUserId(condVO.getUserId());
				}
				korBkgDgVvdVO = dbDao.searchBkgDgVVDInfo(korBkgDgVvdVO);
				// CHAR(9) 로 묶인 부분 풀기
				vvdTokens = korBkgDgVvdVO.getData().split( String.valueOf(((char)9)) );
				// 처리 시작
				korBkgDgVvdVO.setData		(null);
				korBkgDgVvdVO.setMrnNo		(vvdTokens[0] );
				korBkgDgVvdVO.setVvd		(vvdTokens[1] );
				korBkgDgVvdVO.setPortCd		(vvdTokens[3] );
				korBkgDgVvdVO.setIoBndCd	(vvdTokens[4] );
				korBkgDgVvdVO.setVslEngNm	(vvdTokens[5] );
				korBkgDgVvdVO.setCallSgnNo	(vvdTokens[6] );
				korBkgDgVvdVO.setSndDt		(vvdTokens[7] );
				korBkgDgVvdVO.setSndTm		(vvdTokens[8] );
				korBkgDgVvdVO.setDocNo		(vvdTokens[9] );
				korBkgDgVvdVO.setAuthority	(vvdTokens[10]);
				korBkgDgVvdVO.setIo			(vvdTokens[11]);
				korBkgDgVvdVO.setCallKnt	(vvdTokens[12]);
				korBkgDgVvdVO.setArvDt		(vvdTokens[13]);
				korBkgDgVvdVO.setTransCode	(vvdTokens[14]);
				korBkgDgVvdVO.setDchgComCd	(vvdTokens[15]);
				korBkgDgVvdVO.setDschComNm	(vvdTokens[16]);
				korBkgDgVvdVO.setTotalCntr	(vvdTokens[17]);
				korBkgDgVvdVO.setTotalWgt	(vvdTokens[18]);
				korBkgDgVvdVO.setJobCode1	(vvdTokens[19]);
				korBkgDgVvdVO.setJobCode2	(vvdTokens[20]);
				korBkgDgVvdVO.setFromDt		(vvdTokens[21]);
				korBkgDgVvdVO.setToDt		(vvdTokens[22]);
				korBkgDgVvdVO.setPrePort	(vvdTokens[23]);
				korBkgDgVvdVO.setPortArea	(vvdTokens[24]);
				korBkgDgVvdVO.setPortAnch	(vvdTokens[25]);
				korBkgDgVvdVO.setPortDesc	(vvdTokens[26]);
				korBkgDgVvdVO.setSubstance	(vvdTokens[27]);
				korBkgDgVvdVO.setContact	(vvdTokens[28]);
				korBkgDgVvdVO.setPolCd		(vvdTokens[29]);
				korBkgDgVvdVO.setPodCd		(vvdTokens[30]);
				korBkgDgVvdVO.setIoDt		(vvdTokens[31]);
				// 처리 종료
				vvdTokens = null;

				// 최종 객체에 담기
				returnVO.setKorBkgDgVvdVO	(korBkgDgVvdVO	);
				returnVO.setKorBkgDgCgoVOs	(korBkgDgCgoVOs	);

			} else {

				// DOWNLOADED 인 경우

				// VVD 기본 정보 조회
				korDgVvdVO.setIoBndCd	(ioBndCd			);
				korDgVvdVO.setVvd		(condVO.getVvd()	);
				korDgVvdVO.setPolCd		(condVO.getPolCd()	);
				korDgVvdVO.setPodCd		(condVO.getPodCd()	);
				korDgVvdVO = dbDao.searchKorDgVVDInfo(korDgVvdVO);
				if (korDgVvdVO==null || korDgVvdVO.getData() == null || korDgVvdVO.getData().trim().length() < 1) {
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}
				// CHAR(9) 로 묶인 부분 풀기
				vvdTokens = korDgVvdVO.getData().split( String.valueOf(((char)9)) );
				// 처리 시작
				korDgVvdVO.setData(null);
				korDgVvdVO.setMrnNo		(vvdTokens[0] );
				korDgVvdVO.setVvd		(vvdTokens[1] );
				korDgVvdVO.setVvdSeq	(vvdTokens[2] );
				korDgVvdVO.setPortCd	(vvdTokens[3] );
				korDgVvdVO.setIoBndCd	(vvdTokens[4] );
				korDgVvdVO.setVslEngNm	(vvdTokens[5] );
				korDgVvdVO.setCallSgnCd	(vvdTokens[6] );
				korDgVvdVO.setSendDt	(vvdTokens[7] );
				korDgVvdVO.setSendTm	(vvdTokens[8] );
				korDgVvdVO.setDocNo		(vvdTokens[9] );
				korDgVvdVO.setAuthority	(vvdTokens[10]);
				korDgVvdVO.setIo		(vvdTokens[11]);
				korDgVvdVO.setCallKnt	(vvdTokens[12]);
				korDgVvdVO.setArvDt		(vvdTokens[13]);
				korDgVvdVO.setTransCode	(vvdTokens[14]);
				korDgVvdVO.setDchgComCd	(vvdTokens[15]);
				korDgVvdVO.setDschComNm	(vvdTokens[16]);
				korDgVvdVO.setTotalCntr	(vvdTokens[17]);
				DecimalFormat dformat = new DecimalFormat("#####0.000");
				korDgVvdVO.setTotalWgt	(dformat.format(new Double(vvdTokens[18])));
				korDgVvdVO.setJobCode1	(vvdTokens[19]);
				korDgVvdVO.setJobCode2	(vvdTokens[20]);
				korDgVvdVO.setFromDt	(vvdTokens[21]);
				korDgVvdVO.setToDt		(vvdTokens[22]);
				korDgVvdVO.setPrePort	(vvdTokens[23]);
				korDgVvdVO.setPortArea	(vvdTokens[24]);
				korDgVvdVO.setPortAnch	(vvdTokens[25]);
				korDgVvdVO.setPortDesc	(vvdTokens[26]);
				korDgVvdVO.setSubstance	(vvdTokens[27]);
				korDgVvdVO.setContact	(vvdTokens[28]);
				korDgVvdVO.setPolCd		(vvdTokens[29]);
				korDgVvdVO.setPodCd		(vvdTokens[30]);
				korDgVvdVO.setIoDt		(vvdTokens[31]);
				korDgVvdVO.setDgcoSeq	(vvdTokens[32]);
				korDgVvdVO.setTmlVvd	(vvdTokens[33].trim());
				korDgVvdVO.setTmlSkdVoyNo(vvdTokens[34].trim());
				// 처리 종료
				vvdTokens = null;


				// 최종 객체에 담기
				returnVO.setKorDgVvdVO	 (korDgVvdVO	);

				// InBound 의 경우
				if (ioBndCd.equals("I")) {
					korIbDgCgoVO.setVvd		(condVO.getVvd()			);
					korIbDgCgoVO.setIoBndCd	(ioBndCd					);
					korIbDgCgoVO.setCntrSeq	(korDgVvdVO.getMaxVvdSeq()	);
					korIbDgCgoVO.setPolCd		(condVO.getPolCd()	);
					korIbDgCgoVO.setPodCd		(condVO.getPodCd()	);
					korIbDgCgoVOs = dbDao.searchKorIBDgCgoList(korIbDgCgoVO);
					// 최종 객체에 담기
					returnVO.setKorIbDgCgoVOs(korIbDgCgoVOs);
				} else {
					// OutBound 의 경우
					korObDgCgoVO.setVvd		(condVO.getVvd()			);
					korObDgCgoVO.setCntrSeq	(korDgVvdVO.getMaxVvdSeq()	);
					korObDgCgoVO.setPolCd		(condVO.getPolCd()	);
					korObDgCgoVO.setPodCd		(condVO.getPodCd()	);
					korObDgCgoVOs = dbDao.searchKorOBDgCgoList(korObDgCgoVO);
					// 최종 객체에 담기
					returnVO.setKorObDgCgoVOs(korObDgCgoVOs);
				}
			}
		} catch (EventException evx) {
			log.error("err " + evx.toString(), evx);
			throw evx;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}


		return returnVO;
	}

	/**
	 * DG Cargo Manifest 정보 수정
	 * @param DgCgoManifestCondVO dgCgoManifestCondVO
	 * @exception EventException
	 */
	public void manageDgCgoManifest(DgCgoManifestCondVO dgCgoManifestCondVO) throws EventException {

		// 파라메터 변환
		KorDgCgoManifestCondVO condVO = (KorDgCgoManifestCondVO)dgCgoManifestCondVO;
		// VVD 정보
		BkgCstmsKrDgCgoVvdVO bkgCstmsKrDgCgoVvdVO = condVO.getBkgCstmsKrDgCgoVvdVO();
		// Container 정보
		BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs = condVO.getBkgCstmsKrDgCgoVOs();

		// Container 갯수
		String totalCntr = "0";
		// Bound 구분
		String ioBndCd = null;
		// Port
		String portCd = null;
		// Max SEQ
		String maxVvdSeq = null;
		KorDgSeqVO korDgSeqVO = null;
		// 전송여부
		String sendCheck = "N";
		// 컨테이너 처리용 객체
		BkgCstmsKrDgCgoVO bkgCstmsKrDgCgoVO = new BkgCstmsKrDgCgoVO();
		HashMap<String, String> cntrMap = new HashMap<String, String>();
		KorCntrCertiVO korCntrCertiVO = new KorCntrCertiVO();

		try {

			// Bound 및 Port 구분 처리
			if (bkgCstmsKrDgCgoVvdVO.getPolCd() != null && bkgCstmsKrDgCgoVvdVO.getPolCd().trim().length() == 5) {
				ioBndCd = "O";
				portCd = bkgCstmsKrDgCgoVvdVO.getPolCd();
			} else {
				ioBndCd = "I";
				portCd = bkgCstmsKrDgCgoVvdVO.getPodCd();
			}
			// SEQ
			maxVvdSeq = bkgCstmsKrDgCgoVvdVO.getMaxVvdSeq();
			// Total Count 계산
			if (bkgCstmsKrDgCgoVOs != null) {
				for (int i=0; i < bkgCstmsKrDgCgoVOs.length; i++) {
					if (cntrMap.containsKey(bkgCstmsKrDgCgoVOs[i].getCntrNo())) continue;
					cntrMap.put(bkgCstmsKrDgCgoVOs[i].getCntrNo(), "Y");
				}
			}
			totalCntr = String.valueOf(cntrMap.size());
			// 화면에서 TOTAL COUNT 를 입력하지 않은 경우는 계산된 값으로, 입력한 경우는 입력값으로 대체
			if (bkgCstmsKrDgCgoVvdVO.getTotalCntr().trim().equals("")) bkgCstmsKrDgCgoVvdVO.setTotalCntr(totalCntr);

			// 날짜와 시간 필드 합치기
			bkgCstmsKrDgCgoVvdVO.setSndDt	(bkgCstmsKrDgCgoVvdVO.getSndDt() + " " + bkgCstmsKrDgCgoVvdVO.getSndTm()  );
			bkgCstmsKrDgCgoVvdVO.setIoDt	(bkgCstmsKrDgCgoVvdVO.getIoDt() + " " + bkgCstmsKrDgCgoVvdVO.getIoTm()	  );
			bkgCstmsKrDgCgoVvdVO.setArvDt	(bkgCstmsKrDgCgoVvdVO.getArvDt() + " " + bkgCstmsKrDgCgoVvdVO.getArvTm()  );
			bkgCstmsKrDgCgoVvdVO.setFromDt	(bkgCstmsKrDgCgoVvdVO.getFromDt() + " " + bkgCstmsKrDgCgoVvdVO.getFromTm());
			bkgCstmsKrDgCgoVvdVO.setToDt	(bkgCstmsKrDgCgoVvdVO.getToDt() + " " + bkgCstmsKrDgCgoVvdVO.getToTm()	  );
			// 파라메터 설정
			bkgCstmsKrDgCgoVvdVO.setPortCd	(portCd				);
			bkgCstmsKrDgCgoVvdVO.setIoBndCd	(ioBndCd			);
			bkgCstmsKrDgCgoVvdVO.setUserId	(condVO.getUserId()	);

			if (maxVvdSeq != null && maxVvdSeq.compareTo("0") > 0) {
				// Modify VVD
				dbDao.modifyDgVVDInfo(bkgCstmsKrDgCgoVvdVO);
			} else {

				// Danger VVD의 Max Seq 조회
				korDgSeqVO = new KorDgSeqVO();
				korDgSeqVO.setVvd	(bkgCstmsKrDgCgoVvdVO.getVvd()	);
				korDgSeqVO.setMrnNo	(bkgCstmsKrDgCgoVvdVO.getMrnNo());
				maxVvdSeq = dbDao.searchMaxDgVvdSeq(korDgSeqVO);

				// VVD 정보 INSERT
				bkgCstmsKrDgCgoVvdVO.setMaxVvdSeq(maxVvdSeq);
				dbDao.addDgVVDInfo(bkgCstmsKrDgCgoVvdVO);
			}

			// 전송 여부 체크
			sendCheck = dbDao.searchDgSendDate(bkgCstmsKrDgCgoVvdVO);
			if (sendCheck==null) sendCheck = "N";

//			[CHM-201110118-01]DG CARGO MANIFEST 오류 관련 로직 주석처리 20110420 조원주
// 			전송이 되지 않은 경우 삭제후 INSERT
//			if (sendCheck.equals("N")) {
//				// 컨테이너 정보 삭제
//				bkgCstmsKrDgCgoVO.setVvd		(bkgCstmsKrDgCgoVvdVO.getVvd()	);
//				bkgCstmsKrDgCgoVO.setMaxVvdSeq	(maxVvdSeq						);
//				bkgCstmsKrDgCgoVO.setIoBndCd	(ioBndCd						);
//				dbDao.removeDgCNTRInfoKor(bkgCstmsKrDgCgoVO);
//			}

			if ("Y".equals(condVO.getDeleteBtnChkYN())) {
				// 컨테이너 정보 삭제
				bkgCstmsKrDgCgoVO.setVvd                  (bkgCstmsKrDgCgoVvdVO.getVvd() );
				bkgCstmsKrDgCgoVO.setMaxVvdSeq         (maxVvdSeq);
				bkgCstmsKrDgCgoVO.setIoBndCd  (ioBndCd);
				dbDao.removeDgCNTRInfoKor(bkgCstmsKrDgCgoVO);
			 }


			// CONTAINER GRID LOOP
			if (bkgCstmsKrDgCgoVOs != null) {

				for (int i=0; i < bkgCstmsKrDgCgoVOs.length; i++) {
					// 삭제가 아닌 경우만 처리
					if (bkgCstmsKrDgCgoVOs[i].getIbflag().equals("D")) continue;

					// 파라메터 값 설정
					bkgCstmsKrDgCgoVOs[i].setMaxVvdSeq	(maxVvdSeq						);
					bkgCstmsKrDgCgoVOs[i].setCntrSeq	(maxVvdSeq						);
					bkgCstmsKrDgCgoVOs[i].setCertiSeqNo	(String.valueOf(i+1)			);
					bkgCstmsKrDgCgoVOs[i].setVvd		(bkgCstmsKrDgCgoVvdVO.getVvd()	);
					bkgCstmsKrDgCgoVOs[i].setUserId		(condVO.getUserId()				);

					// OutBound 의 경우 InBound 의 Seq, Mrn 을 이용
					if (ioBndCd.equals("O")) {
						korCntrCertiVO.setPortCd	(portCd									);
						korCntrCertiVO.setBkgNo		(bkgCstmsKrDgCgoVOs[i].getBkgNo()		);
						korCntrCertiVO.setCntrNo	(bkgCstmsKrDgCgoVOs[i].getCntrNo()		);
						korCntrCertiVO.setImdgUnNo	(bkgCstmsKrDgCgoVOs[i].getImdgUnNo()	);
						korCntrCertiVO.setImdgClssCd(bkgCstmsKrDgCgoVOs[i].getImdgClssCd()	);
						korCntrCertiVO = dbDao.searchCntrCertiNoList(korCntrCertiVO);
						// 조회값 적용
						if (korCntrCertiVO != null) {
							bkgCstmsKrDgCgoVOs[i].setCertiNo	(korCntrCertiVO.getCertiNo()	);
							bkgCstmsKrDgCgoVOs[i].setCertiSeqNo	(korCntrCertiVO.getCertiSeqNo()	);
						}
					}

					// UPDATE 후 처리건수가 0건이면 INSERT
					if (dbDao.modifyDgCNTRInfo(bkgCstmsKrDgCgoVOs[i]) < 1) {
						dbDao.addDgCNTRInfo(bkgCstmsKrDgCgoVOs[i]);
					}
				} // END FOR
			} // END LOOP

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Discharging CY에 대한 Validation Check
	 * @param String dischCy
	 * @return String
	 * @throws EventException
	 */
	public String searchDischCyValChk(String dischCy) throws EventException {
		String result = "";
		try {
			result = dbDao.searchDischCyValChk(dischCy);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return result;
	}

	/**
	 * MSN 배정을 위한 Validation Check
	 * @param BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchMsnValChk(BkgCstmsKrMfSeqNoVO bkgCstmsKrMfSeqNoVO) throws EventException {
		String result = "";
		try {
			result = dbDao.searchMsnValChk(bkgCstmsKrMfSeqNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Manifest Summary 정보 수정
	 *
	 * @param KorManifestSmryCondVO korManifestSmryCondVO
	 * @exception EventException
	 */
	public void modifyManifestSummaryInfo(KorManifestSmryCondVO korManifestSmryCondVO) throws EventException {
		// POL TML 생성
		String polTml = "";
		if (!"".equals(korManifestSmryCondVO.getPolYdCd())) polTml = korManifestSmryCondVO.getPolCd() + korManifestSmryCondVO.getPolYdCd();
		// POD TML 생성
		String podTml = "";
		if (!"".equals(korManifestSmryCondVO.getTmlCd())) podTml = korManifestSmryCondVO.getPodCd() + korManifestSmryCondVO.getTmlCd();
		// IN TYPE 처리
		String inType = korManifestSmryCondVO.getInType();
		if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = korManifestSmryCondVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(korManifestSmryCondVO.getIoBndCd())) {
			portCd = korManifestSmryCondVO.getPolCd();
		}
		// BOND CD UPDATE를 위한 객체
		KorBondCdVO korBondCdVO = new KorBondCdVO();
		// Summary UPDATE를 위한 객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();

		try {

			// TYPE에 따른 처리
			if (inType.equals("A")) {
				// A인 경우
				// 파라메터 셋팅
				korBondCdVO.setVvd		(korManifestSmryCondVO.getVvd()		);
				korBondCdVO.setBdAreaCd	(korManifestSmryCondVO.getBdAreaCd()	);
				korBondCdVO.setUserId	(korManifestSmryCondVO.getUserId()		);
				korBondCdVO.setPortCd	(portCd					);
				korBondCdVO.setInType	(inType					);
				korBondCdVO.setIoBndCd	(korManifestSmryCondVO.getIoBndCd()	);
				korBondCdVO.setPolCd	(korManifestSmryCondVO.getPolCd()		);
				korBondCdVO.setPolTml	(polTml					);
				korBondCdVO.setPodCd	(korManifestSmryCondVO.getPodCd()		);
				korBondCdVO.setPodTml	(podTml					);
				// UPDATE
				dbDao.modifyBondCdKor(korBondCdVO);

			}

			// 파라메터 셋팅
			bkgCstmsKrVvdSmryVO.setVvd			 (korManifestSmryCondVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (korManifestSmryCondVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (korManifestSmryCondVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (korManifestSmryCondVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (korManifestSmryCondVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (korManifestSmryCondVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (korManifestSmryCondVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (korManifestSmryCondVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (korManifestSmryCondVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (korManifestSmryCondVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (korManifestSmryCondVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (korManifestSmryCondVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(korManifestSmryCondVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (korManifestSmryCondVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (korManifestSmryCondVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			// UPDATE
			dbDao.modifyManifestSmryInfo(bkgCstmsKrVvdSmryVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Manifest 정보 삭제
	 *
	 * @param KorManiSumCondVO korManiSumCondVO
	 * @throws EventException
	 */
	public void manageManifestSummaryInfo(KorManiSumCondVO korManiSumCondVO) throws EventException {
		try {
			// POL TML 생성
			String polTml = "";
			if (!"".equals(korManiSumCondVO.getPolYdCd())) polTml = korManiSumCondVO.getPolCd() + korManiSumCondVO.getPolYdCd();
			// POD TML 생성
			String podTml = "";
			if (!"".equals(korManiSumCondVO.getTmlCd())) podTml = korManiSumCondVO.getPodCd() + korManiSumCondVO.getTmlCd();
			// IN TYPE 처리
			String inType = korManiSumCondVO.getInType();
			//if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
			// PORT CD 처리
			String portCd = korManiSumCondVO.getPodCd();
//			if ("|A|B|C|D".indexOf(condVO.getInType()) > 0) portCd = condVO.getPolCd();
			if ( "O".equals(korManiSumCondVO.getIoBndCd())) {
				portCd = korManiSumCondVO.getPolCd();
			}

			// VVD 삭제용 객체
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
			// BL Info 삭제용 객체
			KorBlInfoKorVO korBlInfoKorVO = new KorBlInfoKorVO();
			// Container 삭제용 객체
			KorCntrDataVO korCntrDataVO = new KorCntrDataVO();
			// Customer 삭제용 객체
			KorBlCustInfoVO korBlCustInfoVO = new KorBlCustInfoVO();
			// Export License 삭제용 객체
			KorExpDataVO korExpDataVO = new KorExpDataVO();
			// 삭제 SEQ
			String dlSeq = "0";
			// 삭제 건수
			int delCnt = 0;

			KorDnHistVO korDnHistVO = new KorDnHistVO();

			// VVD INFO 삭제
			bkgCstmsKrVvdSmryVO.setVvd		(korManiSumCondVO.getVvd()	);
			bkgCstmsKrVvdSmryVO.setMrnNo	(korManiSumCondVO.getMrnNo()	);
			bkgCstmsKrVvdSmryVO.setVvdSeq	(korManiSumCondVO.getVvdSeq()	);
			bkgCstmsKrVvdSmryVO.setInType	(inType				);
			// 삭제
			dbDao.removeVvdInfoKor(bkgCstmsKrVvdSmryVO);

			// Container DATA 삭제
			korCntrDataVO.setVvd	(korManiSumCondVO.getVvd()	);
			korCntrDataVO.setPortCd	(portCd				);
			korCntrDataVO.setInType	(inType				);
			korCntrDataVO.setIoBndCd(korManiSumCondVO.getIoBndCd());
			korCntrDataVO.setPodCd	(korManiSumCondVO.getPodCd()	);
			korCntrDataVO.setPodTml	(podTml				);
			korCntrDataVO.setPolCd	(korManiSumCondVO.getPolCd()	);
			korCntrDataVO.setPolTml	(polTml				);
			// 삭제
			dbDao.removeCNTRDataKor(korCntrDataVO);

			// CUSTOMER 정보 삭제
			korBlCustInfoVO.setVvd		(korManiSumCondVO.getVvd()	);
			korBlCustInfoVO.setPortCd	(portCd				);
			korBlCustInfoVO.setInType	(inType				);
			korBlCustInfoVO.setIoBndCd	(korManiSumCondVO.getIoBndCd());
			korBlCustInfoVO.setPodCd	(korManiSumCondVO.getPodCd()	);
			korBlCustInfoVO.setPodTml	(podTml				);
			korBlCustInfoVO.setPolCd	(korManiSumCondVO.getPolCd()	);
			korBlCustInfoVO.setPolTml	(polTml				);
			// 삭제
			dbDao.removeBlCustInfoKor(korBlCustInfoVO);

			// Export DATA 삭제
			korExpDataVO.setVvd		(korManiSumCondVO.getVvd()	);
			korExpDataVO.setPortCd	(portCd				);
			korExpDataVO.setInType	(inType				);
			korExpDataVO.setIoBndCd	(korManiSumCondVO.getIoBndCd());
			korExpDataVO.setPolCd	(korManiSumCondVO.getPolCd()	);
			korExpDataVO.setPolTml	(polTml				);
			korExpDataVO.setPodCd	(korManiSumCondVO.getPodCd()	);
			korExpDataVO.setPodTml	(podTml				);
			// 삭제
			dbDao.removeExportDataKor(korExpDataVO);

			// B/L INFO 삭제
			korBlInfoKorVO.setVvd		(korManiSumCondVO.getVvd()	);
			korBlInfoKorVO.setPortCd	(portCd				);
			korBlInfoKorVO.setInType	(inType				);
			korBlInfoKorVO.setIoBndCd	(korManiSumCondVO.getIoBndCd());
			korBlInfoKorVO.setPolCd		(korManiSumCondVO.getPolCd()	);
			korBlInfoKorVO.setPolTml	(polTml				);
			korBlInfoKorVO.setPodCd		(korManiSumCondVO.getPodCd()	);
			korBlInfoKorVO.setPodTml	(podTml				);
			// 삭제
			delCnt = dbDao.removeBlInfo(korBlInfoKorVO);

			// 삭제 HISTORY 를 위한 SEQ 조회
			korDnHistVO.setMrnNo(korManiSumCondVO.getMrnNo()	);
			korDnHistVO.setVvd	(korManiSumCondVO.getVvd()	);
			// SEQ 조회
			dlSeq = dbDao.searchMaxSeqDnHistKor(korDnHistVO);
			if (dlSeq == null) dlSeq="1";
			// 조회 결과 담기
			korDnHistVO.setDlSeq	(dlSeq					);
			korDnHistVO.setDelCnt	(String.valueOf(delCnt)	);
			korDnHistVO.setUserId	(korManiSumCondVO.getUserId()		);
			korDnHistVO.setOfcCd	(korManiSumCondVO.getOfcCd()		);
			korDnHistVO.setPodCd	(korManiSumCondVO.getPodCd()		);
			korDnHistVO.setPolCd	(korManiSumCondVO.getPolCd()		);
			// Download History 에 삭제 기록을 남김
			dbDao.addDnHistKor(korDnHistVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG01020", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG01020", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException {

		try {
			// 파라메터 변환
			KorDischManifestTransmitVO condVO = (KorDischManifestTransmitVO)dischManifestTransmitVO;

			// IN TYPE 처리
			String inType = condVO.getInType();
			if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
			// PORT CD 처리
			String portCd = condVO.getPodCd();
//			if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
			if ( "O".equals(condVO.getIoBndCd())) {
				portCd = condVO.getPolCd();
			}
			String podTml = portCd + condVO.getPodTml();

			// VVD Summary Update용 객체
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();

			// SEND DATE UPDATE 용 객체
			KorBlInfoKorVO korBlInfoKorVO = new KorBlInfoKorVO();

			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (condVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (condVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (condVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (condVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (condVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (condVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (condVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (condVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (condVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (condVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (condVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (condVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(condVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (condVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (condVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			// UPDATE
			dbDao.modifyDiscVVDSmryKorInfo(bkgCstmsKrVvdSmryVO);

			// SEND DATE UPDATE
			korBlInfoKorVO.setVvd		(condVO.getVvd()	);
			korBlInfoKorVO.setInType	(inType				);
			korBlInfoKorVO.setPortCd	(portCd				);
			korBlInfoKorVO.setPolCd		(condVO.getPolCd()	);
			korBlInfoKorVO.setPodCd		(condVO.getPodCd()	);
			korBlInfoKorVO.setIoBndCd	(condVO.getIoBndCd());
			korBlInfoKorVO.setUserId	(condVO.getUserId()	);
			korBlInfoKorVO.setPodTml	(podTml				);
			dbDao.modifyDiscSendDate(korBlInfoKorVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Manifest를 전송 후 정보 UPDATE
	 *
	 * @param KorManifestTransmitVO korManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitManifest(KorManifestTransmitVO korManifestTransmitVO) throws EventException {

		try {
			// POD TML 생성
			String podTml = korManifestTransmitVO.getPodCd() + korManifestTransmitVO.getTmlCd();
			// IN TYPE 처리
			String inType = korManifestTransmitVO.getInType();
			//if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
			// PORT CD 처리
			String portCd = korManifestTransmitVO.getPodCd();
//			if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
			if ( "O".equals(korManifestTransmitVO.getIoBndCd())) {
				portCd = korManifestTransmitVO.getPolCd();
			}

			// BOND CD UPDATE를 위한 객체
			KorBondCdVO korBondCdVO = new KorBondCdVO();
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();

			korBondCdVO.setVvd		(korManifestTransmitVO.getVvd()	);
			korBondCdVO.setPortCd	(portCd				);
			korBondCdVO.setInType	(inType				);
			korBondCdVO.setIoBndCd	(korManifestTransmitVO.getIoBndCd());
			korBondCdVO.setPolCd	(korManifestTransmitVO.getPolCd()	);
			korBondCdVO.setPodCd	(korManifestTransmitVO.getPodCd()	);
			korBondCdVO.setPodTml	(podTml				);
			korBondCdVO.setUserId	(korManifestTransmitVO.getUserId()	);
			korBondCdVO.setBdAreaCd (korManifestTransmitVO.getBdAreaCd());
			korBondCdVO.setMfSndRcvrId (korManifestTransmitVO.getInReceiver());

			// TYPE A 의 경우
			if (inType.equals("A")) {
				// Bond Code UPDATE
				dbDao.modifyBondCdKor(korBondCdVO);
			}

			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (korManifestTransmitVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (korManifestTransmitVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (korManifestTransmitVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (korManifestTransmitVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (korManifestTransmitVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (korManifestTransmitVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (korManifestTransmitVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (korManifestTransmitVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (korManifestTransmitVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (korManifestTransmitVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (korManifestTransmitVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (korManifestTransmitVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(korManifestTransmitVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (korManifestTransmitVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (korManifestTransmitVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			bkgCstmsKrVvdSmryVO.setMfSndRcvrId   (korManifestTransmitVO.getInReceiver());

			// UPDATE
			dbDao.modifyVVDSendKor(bkgCstmsKrVvdSmryVO);

			// 전송 일시, USERID UPDATE
			dbDao.modifyKorManiSndDateUser(korBondCdVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EDI 수신 메시지 처리
	 *
	 * @param RcvMsgVO rcvMsgVO
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) throws EventException {
		String[] lines = null;
		try {
			lines = ((KorRcvMsgVO)rcvMsgVO).getFlatFile().split("\n");

			// 헤더에 따른 작업 구분
			// ENTRY 처리
			if (lines[0].trim().equals("IFHJT2HJS!MFTRES!")) {
				// UPDATE용 객체
				HjtRcvMsgVO hjtRcvMsgVO = new HjtRcvMsgVO();
				// 배정정보 수신 처리
				hjtRcvMsgVO.setMrnNo		(lines[1].trim().substring(7));
				hjtRcvMsgVO.setSndDt		(lines[2].trim().substring(7));
				hjtRcvMsgVO.setRsltAckDt	(lines[3].trim().substring(7));
				hjtRcvMsgVO.setTrsmMsgTpId	(lines[4].trim().substring(7));
				if (lines.length > 5) hjtRcvMsgVO.setErrMsg(lines[5].trim().substring(7));
				// UPDATE
				dbDao.modifyHJTResponse(hjtRcvMsgVO);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Amendment Transmit 후 전송일시 UPDATE
	 *
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @throws EventException
	 */
	public void transAmdManifest(KorBlInfoKorVO korBlInfoKorVO) throws EventException {
		try {
			// MODIFY TRANSMIT DATE
			if (korBlInfoKorVO.getTrnsSeq() != null && korBlInfoKorVO.getTrnsSeq().endsWith("N") ) dbDao.modifyTransmitDate(korBlInfoKorVO);
			// CORR INFO UPDATE
			dbDao.modifyCorrInfo(korBlInfoKorVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * MFT Manifest EDI 전송후 UPDATE
	 *
	 * @param ManiCondVO maniCondVO
	 * @throws EventException
	 */
	public void transmitKorMFTManifest(ManiCondVO maniCondVO) throws EventException {

		try {

			// 파라메터 변환
			KorManiCondVO condVO = (KorManiCondVO)maniCondVO;

			// 전송시간 UPDATE 용 객체
			KorEdiMrnVO korEdiMrnVO = new KorEdiMrnVO();
			KorEdiMsnVO korEdiMsnVO = new KorEdiMsnVO();

			// 전송시간 UPDATE
			ObjectCloner.build(condVO, korEdiMrnVO);
			ObjectCloner.build(condVO, korEdiMsnVO);
			dbDao.modifyEDIMrn(korEdiMrnVO);
			dbDao.modifyEDIMsn(korEdiMsnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * MRN CHK DIGIT 생성
	 * @param String mrnNo
	 * @return String
	 */
	private String makeMrnChkDigitNo(String mrnNo) {
		// 최종 결과
		String chkDigit = "";
		// MRN 배열
		char[] mrnArray = mrnNo.toCharArray();
		// 입력받은 MRN 길이
		int mrnLen = mrnArray.length;
		// 가수 데이터
		int[] gasu = new int[] {3,7,9,3,7,9,3,7,9,3};
		// 계산 변수
		int calcu=0;
		// 체크 값
		int check = 0;

		// Loop
		for (int i=0; i<mrnLen; i++) {
			calcu = ( mrnArray[i] * gasu[i] ) % mrnLen;
			check = check + calcu;
		}

		if (mrnLen > 0) {
			chkDigit = String.valueOf(check % mrnLen);
		} else {
			chkDigit = "";
		}

		return chkDigit;
	}

	/**
	 * MRN Creation 정보 INSERT
	 *
	 * @param KorMrnCreateInfoVO[] korMrnCreateInfoVOs
	 * @param SignOnUserAccount account
	 * @param String ffDiv  //◁◁◁◁◁◁◁◁◁◁///////////////////////////
	 * @throws EventException
	 */
	public void manageMrnCreateInfo(KorMrnCreateInfoVO[] korMrnCreateInfoVOs, SignOnUserAccount account, String ffDiv) throws EventException {  //◁◁◁◁◁◁◁◁◁◁///////////////////////////
		List<KorMrnCreateInfoVO> insertMrnCreateInfoVOList = new ArrayList<KorMrnCreateInfoVO>();

		try {
			for (KorMrnCreateInfoVO korMrnCreateInfoVO : korMrnCreateInfoVOs) {
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
				if ("3G".equalsIgnoreCase(ffDiv)) {
					korMrnCreateInfoVO.setMrnChkNo(makeMrnChkDigitNo(korMrnCreateInfoVO.getMrnNo()));
				} else {    // [4G]로 fix될 경우, 화면에서 E,I가 넘어오도록 수정할 것
					if ("O".equalsIgnoreCase(korMrnCreateInfoVO.getIoBndCd())) {
						korMrnCreateInfoVO.setMrnChkNo("E");
					} else {
						korMrnCreateInfoVO.setMrnChkNo("I");
					}
				}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
				korMrnCreateInfoVO.setUserId(account.getUsr_id());
				insertMrnCreateInfoVOList.add(korMrnCreateInfoVO);
			}
			// MSN 정보 등록
			if (insertMrnCreateInfoVOList.size() > 0) dbDao.addMrnCreateInfo(insertMrnCreateInfoVOList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * MRN MSN 정보 삭제
	 *
	 * @param KorMrnCreateInfoVO[] korMrnCreateInfoVOs
	 * @throws EventException
	 */
	public void removeMrnMsnCreateInfo(KorMrnCreateInfoVO[] korMrnCreateInfoVOs) throws EventException {
		List<KorMrnCreateInfoVO> deleteMrnCreateInfoVOList = new ArrayList<KorMrnCreateInfoVO>();

		try {
			for (KorMrnCreateInfoVO korMrnCreateInfoVO : korMrnCreateInfoVOs) {
				deleteMrnCreateInfoVOList.add(korMrnCreateInfoVO);
			}
			if (deleteMrnCreateInfoVOList.size() > 0) {
				// MSN 정보 삭제
				dbDao.removeMsnCreateInfo(deleteMrnCreateInfoVOList);
				// MRN 정보 삭제
				dbDao.removeMrnCreateInfo(deleteMrnCreateInfoVOList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG01020", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG01020", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * DGM Manifest 전송후 VVD, Container 정보 UPDATE
	 *
	 * @param ManiDGMTransVO maniDGMTransVO
	 * @throws EventException
	 */
	public void transmitDGMManifest(ManiDGMTransVO maniDGMTransVO) throws EventException {

		try {

			BkgCstmsKrDgCgoVO[] bkgCstmsKrDgCgoVOs = maniDGMTransVO.getBkgCstmsKrDgCgoVOs();

			if (bkgCstmsKrDgCgoVOs != null) {

				for (int i=0; i < bkgCstmsKrDgCgoVOs.length; i++) {
					// Modify SEQ
					dbDao.modifyDgCgoSeq(bkgCstmsKrDgCgoVOs[i]);
				}

			}

			dbDao.modifyDgEdiVVDInfo(maniDGMTransVO.getBkgCstmsKrDgCgoVvdVO());

			dbDao.modifyDgEdiCNTRInfo(maniDGMTransVO.getBkgCstmsKrDgCgoVO());

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VSL, Manifest 정보 조회
	 *
	 * @param KorVslInfoNManifestCondVO korVslInfoNManifestCondVO
	 * @return VslInfoNManifestVO
	 * @throws EventException
	 */
	public VslInfoNManifestVO manageVslInfoNManifestList(KorVslInfoNManifestCondVO korVslInfoNManifestCondVO) throws EventException {
		// 최종 리턴 객체
		KorVslInfoNManifestVO korVslInfoNManifestVO = new KorVslInfoNManifestVO();

		// POL TML 생성
		String polTml = "";
		if (!"".equals(korVslInfoNManifestCondVO.getPolYdCd())) polTml = korVslInfoNManifestCondVO.getPolCd() + korVslInfoNManifestCondVO.getPolYdCd();
		// POD TML 생성
		String podTml = "";
		if (!"".equals(korVslInfoNManifestCondVO.getTmlCd())) podTml = korVslInfoNManifestCondVO.getPodCd() + korVslInfoNManifestCondVO.getTmlCd();
		// IN TYPE 처리
		String inType = korVslInfoNManifestCondVO.getInType();
		if ("|A|B|C|D|M|T|R".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = korVslInfoNManifestCondVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(korVslInfoNManifestCondVO.getIoBndCd()))  portCd = korVslInfoNManifestCondVO.getPolCd();

		// MRN INFO 조회용 객체
		KorMrnInfoKorVO korMrnInfoKorVO = new KorMrnInfoKorVO();
		// 전송할 데이터 체크용 객체
		KorExistCntVO korExistCntVO = new KorExistCntVO();
		String dataCnt = "0";
		// SummaryInfo 조회용 객체
		KorSumVO korSumVO = new KorSumVO();
		KorSumVO korSumFullEmptyVO = new KorSumVO();
		// BL SummaryInfo 조회용 객체
		BlSummaryCondVO blSummaryCondVO = new BlSummaryCondVO();
		BlSummaryVO blSummaryVO = new BlSummaryVO();
		// VVD SEQ 조회 및 조회된 결과들을 담을  객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
		bkgCstmsKrVvdSmryVO.setUserId(korVslInfoNManifestCondVO.getUserId());
		// VVD SEQ
		String vvdSeq = "0";
		// VVD SEND CHECK
		String oldSndChk="N";
		// Bond Area Code 조회를 위한 객체
		BkgCstmsKrBlCondVO bkgCstmsKrBlCondVO = new BkgCstmsKrBlCondVO();
		String bondAreaCd = "";
		// SEND DATE 조회결과 객체
		DateVO dateVO = new DateVO();
		// C TYPE 전송기록
		String transPreCnt = "0";
		// 최종 화면으로 넘어갈 객체
		BkgCstmsKrVvdSmryVO outVO = new BkgCstmsKrVvdSmryVO();
		// Full Empty 조회용
		KorFullEmpSumVO korFullEmpSumVO = new KorFullEmpSumVO();

		try {

			// Type E의 경우 B/L 없는 공동 VVD 인지 체크
			if ("E".equals(korVslInfoNManifestCondVO.getInType())) {
				String noneBlPortCd = korVslInfoNManifestCondVO.getPolCd();
				if (noneBlPortCd == null || "".equals(noneBlPortCd)) {
					noneBlPortCd = korVslInfoNManifestCondVO.getPodCd();
				}
				int cntNoneBL = dbDao.searchNoneBLCheck(korVslInfoNManifestCondVO.getVvd(), noneBlPortCd, korVslInfoNManifestCondVO.getPolCd());

				// B/L 이 없는 공동 VVD일 경우
				if (cntNoneBL == 0) {

					// VVD 정보 조회
					bkgCstmsKrVvdSmryVO.setPortCd(noneBlPortCd);
					bkgCstmsKrVvdSmryVO.setVvd(korVslInfoNManifestCondVO.getVvd());
					bkgCstmsKrVvdSmryVO.setIoBndCd(korVslInfoNManifestCondVO.getIoBndCd());
					outVO = dbDao.searchNoneBLInfo(bkgCstmsKrVvdSmryVO);

					if (outVO == null) {
						throw new EventException(new ErrorHandler("BKG00889").getMessage());
					}
					// Type 을 'E'로 설정
					outVO.setNoneBlInType("E");

				// Type E이고 공동 VVD가 아닌 경우 데이터가 없다는 에러
				} else {
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}

			// Type E 이외의 경우
			} else {

				// MRN INFO 조회
				korMrnInfoKorVO.setVvd		(korVslInfoNManifestCondVO.getVvd()	);
				korMrnInfoKorVO.setInType	(inType				);
				korMrnInfoKorVO.setPolCd	(korVslInfoNManifestCondVO.getPolCd()	);
				korMrnInfoKorVO.setPolTml	(polTml				);
				korMrnInfoKorVO.setPodCd	(korVslInfoNManifestCondVO.getPodCd()	);
				korMrnInfoKorVO.setPodTml	(podTml				);
				korMrnInfoKorVO = dbDao.searchMrnInfoKor(korMrnInfoKorVO);

				// 전송할 데이터 유무 체크
				korExistCntVO.setVvd	(korVslInfoNManifestCondVO.getVvd()	);
				korExistCntVO.setInType	(inType				);
				korExistCntVO.setPortCd	(portCd				);
				korExistCntVO.setIoBndCd(korVslInfoNManifestCondVO.getIoBndCd());
				korExistCntVO.setPolCd	(korVslInfoNManifestCondVO.getPolCd()	);
				korExistCntVO.setPolTml	(polTml				);
				korExistCntVO.setPodCd	(korVslInfoNManifestCondVO.getPodCd()	);
				korExistCntVO.setPodTml	(podTml				);
				dataCnt = dbDao.searchExistCntKor(korExistCntVO);
				if (korMrnInfoKorVO==null || dataCnt==null || dataCnt.equals("0")) {
					// 전송할 데이터 없음 예외 처리
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}

				// Summary Info 조회
				korSumVO.setVvd		(korVslInfoNManifestCondVO.getVvd()	);
				korSumVO.setInType	(inType				);
				korSumVO.setPortCd	(portCd				);
				korSumVO.setIoBndCd	(korVslInfoNManifestCondVO.getIoBndCd());
				korSumVO.setPolCd	(korVslInfoNManifestCondVO.getPolCd()	);
				korSumVO.setPolTml	(polTml				);
				korSumVO.setPodCd	(korVslInfoNManifestCondVO.getPodCd()	);
				korSumVO.setPodTml	(podTml				);
				ObjectCloner.build(korSumVO, korSumFullEmptyVO);
				korSumVO = dbDao.searchSummaryInfo(korSumVO);

				// Full/Empty Info 조회
				korFullEmpSumVO = dbDao.searchFullEmpCntrSum(korSumFullEmptyVO);
				// 조회 결과 처리
				if ("".equals(korFullEmpSumVO.getCntFull()) && "".equals(korFullEmpSumVO.getCntEmpty())) {
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}
				korSumVO.setCntFull(korFullEmpSumVO.getCntFull());
				korSumVO.setCntEmpty(korFullEmpSumVO.getCntEmpty());

				// BL Summary Info 조회
				blSummaryCondVO.setVvd		(korVslInfoNManifestCondVO.getVvd()	);
				blSummaryCondVO.setInType	(inType				);
				blSummaryCondVO.setPortCd	(portCd				);
				blSummaryCondVO.setIoBndCd	(korVslInfoNManifestCondVO.getIoBndCd());
				blSummaryCondVO.setPolCd	(korVslInfoNManifestCondVO.getPolCd()	);
				blSummaryCondVO.setPolTml	(polTml				);
				blSummaryCondVO.setPodCd	(korVslInfoNManifestCondVO.getPodCd()	);
				blSummaryCondVO.setPodTml	(podTml				);
				blSummaryVO = dbDao.searchBlSummaryInfo(blSummaryCondVO);

				// VVD SEQ 조회
				bkgCstmsKrVvdSmryVO.setIoBndCd		(korVslInfoNManifestCondVO.getIoBndCd()			);
				bkgCstmsKrVvdSmryVO.setVvd			(korVslInfoNManifestCondVO.getVvd()				);
				bkgCstmsKrVvdSmryVO.setInType		(inType							);
				bkgCstmsKrVvdSmryVO.setPolCd		(korVslInfoNManifestCondVO.getPolCd()				);
				bkgCstmsKrVvdSmryVO.setPolTml		(polTml				);
				bkgCstmsKrVvdSmryVO.setPodCd		(korVslInfoNManifestCondVO.getPodCd()				);
				bkgCstmsKrVvdSmryVO.setPodTml		(podTml							);
				vvdSeq = dbDao.searchVVDSeqKor(bkgCstmsKrVvdSmryVO);

				if (vvdSeq == null || vvdSeq.trim().length() < 1) vvdSeq = "0";

				// 조회된 정보들로 Summary Info 객체 값 매핑
				bkgCstmsKrVvdSmryVO.setMrnNo			(korMrnInfoKorVO.getMrnNo()		);
				bkgCstmsKrVvdSmryVO.setMrnChkNo			(korMrnInfoKorVO.getMrnChkNo()	);
				bkgCstmsKrVvdSmryVO.setVvdSeq			(vvdSeq							);
				// BL Summary Info 값 매핑
				bkgCstmsKrVvdSmryVO.setMstBlKnt			(blSummaryVO.getBlTotCnt()		);
				bkgCstmsKrVvdSmryVO.setCnslBlKnt		(blSummaryVO.getBlCCnt()		);
				bkgCstmsKrVvdSmryVO.setMtyBlKnt			(blSummaryVO.getBlECnt()		);
				bkgCstmsKrVvdSmryVO.setTtlWgt			(blSummaryVO.getWgtQty()		);
				bkgCstmsKrVvdSmryVO.setTtlMeasQty		(blSummaryVO.getMeasQty()		);
				bkgCstmsKrVvdSmryVO.setTtlPckQty		(blSummaryVO.getPckQty()		);
				// Summary Info 값 매핑
				bkgCstmsKrVvdSmryVO.setTtlFullKnt		(korSumVO.getCntFull()			);
				bkgCstmsKrVvdSmryVO.setTtlMtyKnt		(korSumVO.getCntEmpty()			);
				bkgCstmsKrVvdSmryVO.setTtlLcTeuQty		(korSumVO.getCntLc20()			);
				bkgCstmsKrVvdSmryVO.setTtlLcFeuQty		(korSumVO.getCntLc40()			);
				bkgCstmsKrVvdSmryVO.setTtlLc45ftQty		(korSumVO.getCntLc45()			);
				bkgCstmsKrVvdSmryVO.setTtlTsTeuQty		(korSumVO.getCntTs20()			);
				bkgCstmsKrVvdSmryVO.setTtlTsFeuQty		(korSumVO.getCntTs40()			);
				bkgCstmsKrVvdSmryVO.setTtlTs45ftQty		(korSumVO.getCntTs45()			);
				bkgCstmsKrVvdSmryVO.setTtlMtyTeuQty		(korSumVO.getCntEc20()			);
				bkgCstmsKrVvdSmryVO.setTtlMtyFeuQty		(korSumVO.getCntEc40()			);
				bkgCstmsKrVvdSmryVO.setTtlMty45ftQty	(korSumVO.getCntEc45()			);
				bkgCstmsKrVvdSmryVO.setTtlTsMtyTeuQty	(korSumVO.getCntTsEc20()		);
				bkgCstmsKrVvdSmryVO.setTtlTsMtyFeuQty	(korSumVO.getCntTsEc40()		);
				bkgCstmsKrVvdSmryVO.setTtlTsMty45ftQty	(korSumVO.getCntTsEc45()		);

				// VVD SEND CHECK
				oldSndChk = dbDao.searchVVDSendCheck(bkgCstmsKrVvdSmryVO);
				// 조회 결과가 없으면 INSER
				if (oldSndChk==null) {
					dbDao.addVVDInfoInKorCstm(bkgCstmsKrVvdSmryVO);
					// INSERT 후 SEQ 증가 처리
					vvdSeq = String.valueOf( Integer.parseInt(vvdSeq) + 1 );
					bkgCstmsKrVvdSmryVO.setVvdSeq(vvdSeq);
				} else {
					// 조회 결과가 있으면 UPDATE 처리
					dbDao.modifyVVDInfoKor(bkgCstmsKrVvdSmryVO);
				}

				// OUT-Bound 이고 TYPE이 'A' 인 경우  Bond Area Code 조회
				if (korVslInfoNManifestCondVO.getIoBndCd().equals("O") && inType.equals("A")) {
					bkgCstmsKrBlCondVO.setVvd	(korVslInfoNManifestCondVO.getVvd()	);
					bkgCstmsKrBlCondVO.setPortCd(portCd				);
					bkgCstmsKrBlCondVO.setPolCd	(korVslInfoNManifestCondVO.getPolCd()	);
					bondAreaCd = dbDao.searchBondAreaCd(bkgCstmsKrBlCondVO);
				}
				bkgCstmsKrVvdSmryVO.setBdAreaCd(bondAreaCd);

				// SEND DATE 조회
				dateVO = dbDao.searchSendDate(bkgCstmsKrVvdSmryVO);
				if (dateVO != null) {
					bkgCstmsKrVvdSmryVO.setFDate(dateVO.getFDate());
					bkgCstmsKrVvdSmryVO.setTDate(dateVO.getTDate());
					bkgCstmsKrVvdSmryVO.setMfSndRcvrId(dateVO.getMfSndRcvrId());
				}

				// A,B TYPE의 경우 C TYPE의 전송기록이 있는지 체크
				if (inType.equals("A") || inType.equals("B")) {
					transPreCnt = dbDao.searchTransPreCnt(bkgCstmsKrVvdSmryVO);
				}
				bkgCstmsKrVvdSmryVO.setTransPreCnt(transPreCnt);
				bkgCstmsKrVvdSmryVO.setSmpBlKnt(blSummaryVO.getBlSCnt());

				// 화면의 Inbound VVD 가 X 가 아닌 경우 조회
				if (!korVslInfoNManifestCondVO.getIbVvd().equals("X")) {
					String whfNotice = dbDao.searchWhfNotice(korVslInfoNManifestCondVO.getIbVvd());
					bkgCstmsKrVvdSmryVO.setWhfNotice(whfNotice);
				}

				// 화면에 넘어갈  VVD INFO 조회
				outVO = dbDao.searchVVDInfoKor(bkgCstmsKrVvdSmryVO);
				if (outVO == null) {
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}

				outVO.setOldSndChk(oldSndChk);
			}
			korVslInfoNManifestVO.setBkgCstmsKrVvdSmryVO(outVO);

		} catch (EventException evx) {
			log.error("err " + evx.toString(), evx);
			throw evx;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return korVslInfoNManifestVO;
	}

	/**
	 * OutBound 의 경우 MSN 정보 추가 처리
	 *
	 * @param ObMsnInfoCondVO obMsnInfoCondVO
	 * @throws EventException
	 */
	public void manageObMsnInfo(ObMsnInfoCondVO obMsnInfoCondVO) throws EventException {

		// MRN 정보 조회용 객체 생성
		KorMrnInfoVO inKorMrnInfoVO  = new KorMrnInfoVO();
		// MRN 정보 조회 결과 객체 생성
		KorMrnInfoVO outKorMrnInfoVO = new KorMrnInfoVO();
		// OBBkgInfo 조회용 객체 생성
		KorBkgInfoVO korBkgInfoVO = new KorBkgInfoVO();
		// OBBkgInfo 조회 결과 리스트
		KorBkgInfoVO[] korBkgInfoVOs = null;
		// MRN Check 용 객체
		KorMsnInfoVO korMsnInfoVO = null;
		KorMsnInfoVO korMsnInfoVOcheck = null;

		try {


			// MRN INFO 조회용 파라메터 값 매핑
			inKorMrnInfoVO.setInMrnMode 	  ("O"								);
			inKorMrnInfoVO.setInMrnNo   	  (obMsnInfoCondVO.getMrnNo()	  	);
			inKorMrnInfoVO.setInPort    	  (obMsnInfoCondVO.getPortCd()   	);
			inKorMrnInfoVO.setInSkdDirCd	  (obMsnInfoCondVO.getSkdDirCd()	);
			inKorMrnInfoVO.setInSkdVoyageNo   (obMsnInfoCondVO.getSkdVoyNo()	);
			inKorMrnInfoVO.setInVslCd		  (obMsnInfoCondVO.getVslCd()		);

			outKorMrnInfoVO = dbDao.searchMrnInfoByVVD(inKorMrnInfoVO);

			// VVD,PORT 조회가 안되면 MRN 으로 조회
			if (outKorMrnInfoVO==null) outKorMrnInfoVO = dbDao.searchMrnInfoByMRN(inKorMrnInfoVO);

			if (outKorMrnInfoVO != null) {
				// BKG LIST 조회
				korBkgInfoVO.setVvdVslCd	(obMsnInfoCondVO.getVslCd()		);
				korBkgInfoVO.setVvdSkdVoyNo	(obMsnInfoCondVO.getSkdVoyNo()	);
				korBkgInfoVO.setVvdSkdDirCd	(obMsnInfoCondVO.getSkdDirCd()	);
				korBkgInfoVO.setVvdPolCd	(obMsnInfoCondVO.getPortCd()	);

				korBkgInfoVOs = dbDao.searchOBBkgInfoList(korBkgInfoVO);

				// 조회 결과 LOOP
				if (korBkgInfoVOs != null) {

					for (int i=0; i < korBkgInfoVOs.length; i++) {
						// MODE 구분 처리
						if (!korBkgInfoVOs[i].getBkgPolCd().equals(korBkgInfoVOs[i].getVvdPolCd())) {
							korBkgInfoVOs[i].setLocalTs("R");
							korBkgInfoVOs[i].setBlTp("S");
						} else {
							korBkgInfoVOs[i].setLocalTs("E");
							korBkgInfoVOs[i].setBlTp(korBkgInfoVOs[i].getKrCstmsCustTpCd());
						}

						// BKG_NO CHECKING
						korMsnInfoVO = new KorMsnInfoVO();
						korMsnInfoVO.setBkgNo		(korBkgInfoVOs[i].getBkgBkgNo()	);
						korMsnInfoVO.setVslCd		(obMsnInfoCondVO.getVslCd()		);
						korMsnInfoVO.setSkdVoyageNo	(obMsnInfoCondVO.getSkdVoyNo()	);
						korMsnInfoVO.setSkdDirCd	(obMsnInfoCondVO.getSkdDirCd()	);
						korMsnInfoVO.setMrnNbr		(outKorMrnInfoVO.getMrnNo()		);
						korMsnInfoVO.setMfRefNo		(outKorMrnInfoVO.getMrnNo()		);
						korMsnInfoVO.setMrnChk		(outKorMrnInfoVO.getMrnChkNo()	);
						korMsnInfoVO.setUserid		(obMsnInfoCondVO.getUserId()	);
						korMsnInfoVO.setLocalTs		(korBkgInfoVOs[i].getLocalTs()	);
						korMsnInfoVO.setBlTp		(korBkgInfoVOs[i].getBlTp()		);

						korMsnInfoVOcheck = dbDao.searchObMsnBkgNoChk(korMsnInfoVO);

						if (korMsnInfoVOcheck == null) {

							if (!korBkgInfoVOs[i].getBkgStsCd().equals("X") && !korBkgInfoVOs[i].getBkgStsCd().equals("S")) {
								// ADD MSN
								dbDao.addMSNInfo(korMsnInfoVO);
							}

						} else {

							if (korBkgInfoVOs[i].getBkgStsCd().equals("X") || korBkgInfoVOs[i].getBkgStsCd().equals("S")) {
								// REMOVE MSN
								dbDao.removeMSNInfo(korMsnInfoVO);
							}
						}

					} // END FOR

				} // END IF
			}


		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * InBound Empty MSN 저장
	 * @param MsnNoCondVO[] msnNoCondVOs
	 * @throws EventException
	 */
	public void manageMsnNo(MsnNoCondVO[] msnNoCondVOs) throws EventException {
		// 화면에서 넘어온 데이터
		KorMsnNoCondVO[] condVOs = (KorMsnNoCondVO[])msnNoCondVOs;
		// MSN NO 객체
		KorMsnNoCondVO korMsnNoCondVO = null;
		// MSN NO
		int msnNo = 0;
		// MSN Count
		String msnExistCheck = "0";
		// MSN No Update 용 객체
		KorMsnNoVO korMsnNoVO = new KorMsnNoVO();


		if (condVOs != null && condVOs.length > 0) {

			try {

				msnNo = Integer.parseInt(condVOs[0].getMsnStartNum());

				for (int i=0; i < condVOs.length; i++) {

					korMsnNoCondVO = condVOs[i];

					// MSN 에 이미 값이 있으면 SKIP
					if (korMsnNoCondVO.getMsn() != null && korMsnNoCondVO.getMsn().trim().length() > 1) continue;

					// TP가 I이고 FE 가 P인 경우만 처리
					if (korMsnNoCondVO.getFe().equals("P") && korMsnNoCondVO.getTp().equals("I")) {

						// MSN 존재여부 체크
						msnExistCheck = dbDao.searchMsnExistCnt(korMsnNoCondVO.getInVvd(), korMsnNoCondVO.getPod(), String.valueOf(msnNo));
						// MSN 번호가 이미 존재하면 오류 처리
						if (!msnExistCheck.equals("0")) throw new EventException(new ErrorHandler("BKG95024", new String[] {String.valueOf(msnNo)}).getMessage());
						// 존재하지 않으면 UPDATE 처리
						ObjectCloner.build(korMsnNoCondVO, korMsnNoVO);
						korMsnNoVO.setMsnStartNum(String.valueOf(msnNo));
						dbDao.modifyMsnNo(korMsnNoVO);
						msnNo++;
					}
				}
			} catch (EventException evx) {
				log.error("err " + evx.toString(), evx);
				throw evx;
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
			}

		}
	}

	/**
	 * 한국세관 InBound Empty Amend 전송을 위한 처리
	 * @param EmpAmdManiVO[] empAmdManiVOs
	 * @return EmpAmdManiVO[]
	 * @throws EventException
	 */
	public EmpAmdManiVO[] manageEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException {

		// 파라메터 변환
		KorEmpAmdManiVO[] korEmpAmdManiVOs = (KorEmpAmdManiVO[])empAmdManiVOs;
		// BL_NO, TML_CD 조회용 객체
		KorOrgBlVO korOrgBlVO = null;
		// SUB_NO 조회용
		KorSubNoVO korSubNoVO = new KorSubNoVO();
		String subNo = null;
		// Correction 추가용
		KorEmptyCorrInfoVO korEmptyCorrInfoVO = new KorEmptyCorrInfoVO();

		try {

			if (korEmpAmdManiVOs != null) {
				for (int i=0; i < korEmpAmdManiVOs.length; i++) {

					// Original BL_NO 조회
					korOrgBlVO = dbDao.searchOrgBlNo(korEmpAmdManiVOs[i].getIbTsCblno());

					// SUB_NO 조회
					korSubNoVO.setInVvd		(korEmpAmdManiVOs[i].getIbTsVvd()	);
					korSubNoVO.setIbPort	(korEmpAmdManiVOs[i].getIbTsPort()	);
					korSubNoVO.setPodTmlCd	(korOrgBlVO.getPortTmlCd()			);
					subNo = dbDao.searchSubNo(korSubNoVO);

					// SUB_NO 삭제
					dbDao.removeSubNo(subNo);

					// CORRECTION 정보 추가
					korEmptyCorrInfoVO.setSubNo		(subNo								);
					korEmptyCorrInfoVO.setBkgNo		(korEmpAmdManiVOs[i].getIbTsBkgno()	);
					korEmptyCorrInfoVO.setBlNo		(korOrgBlVO.getBlNo()				);
					korEmptyCorrInfoVO.setUsrId		(korEmpAmdManiVOs[i].getUsrId()		);
					korEmptyCorrInfoVO.setCltSeq	(korEmpAmdManiVOs[i].getIbTsSeq()	);
					korEmptyCorrInfoVO.setPortCd	(korEmpAmdManiVOs[i].getIbTsPort()	);
					korEmptyCorrInfoVO.setVvdCd		(korEmpAmdManiVOs[i].getIbTsVvd()	);
					korEmptyCorrInfoVO.setCstmsBlNo	(korEmpAmdManiVOs[i].getIbTsCblno()	);
					korEmptyCorrInfoVO.setCorrCd	("B"								);
					korEmptyCorrInfoVO.setCorrReason("Empty B/L Type 정정"				);
					dbDao.addEmptyCorrInfo(korEmptyCorrInfoVO);

					// Transmit 전달을 위한 조회값 저장
					korEmpAmdManiVOs[i].setSubNo		(subNo					);
					korEmpAmdManiVOs[i].setBlNo			(korOrgBlVO.getBlNo()	);
					korEmpAmdManiVOs[i].setCorrCd		("B"					);
					korEmpAmdManiVOs[i].setCorrReason	("Empty B/L Type 정정"	);
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

		return korEmpAmdManiVOs;
	}

	/**
	 * 한국세관 InBound Empty Amend 전송후 UPDATE 처리
	 *
	 * @param EmpAmdManiVO[] empAmdManiVOs
	 * @throws EventException
	 */
	public void transmitEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException {
		// 파라메터 변환
		KorEmpAmdManiVO[] korEmpAmdManiVOs = (KorEmpAmdManiVO[])empAmdManiVOs;

		// 전송일시 UPDATE 용
		KorEmpBlInfoVO korEmpBlInfoVO = new KorEmpBlInfoVO();

		try {

			if (korEmpAmdManiVOs != null) {
				for (int i=0; i < korEmpAmdManiVOs.length; i++) {

					// BL 전송일시 UPDATE
					korEmpBlInfoVO.setUsrId			(korEmpAmdManiVOs[i].getUsrId()		);
					korEmpBlInfoVO.setCstmsBlNo		(korEmpAmdManiVOs[i].getIbTsCblno()	);
					korEmpBlInfoVO.setCstmsDeclTpCd	(korEmpAmdManiVOs[i].getIbTsType()	);
					korEmpBlInfoVO.setDmstPortCd	(korEmpAmdManiVOs[i].getIbTsPort()	);
					korEmpBlInfoVO.setTrnsSeq		(korEmpAmdManiVOs[i].getIbTsSeq()	);
					dbDao.modifyEmpTransmitDate(korEmpBlInfoVO);

					// CORR 전송일시 UPDATE
					korEmpBlInfoVO.setSubNo(korEmpAmdManiVOs[i].getSubNo());
					dbDao.modifyEmpCorrInfo(korEmpBlInfoVO);
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Correction 전송후 SendDate Update
	 *
	 * @param SndCorrVO sndCorrVO
	 * @throws EventException
	 */
	public void addSndDtCorrInfo(SndCorrVO sndCorrVO) throws EventException {

		try {
			// Paramter 변환
			KorCorrInfoVO korCorrInfoVO = (KorCorrInfoVO)sndCorrVO;

			// INSERT
			dbDao.addCorrInfo(korCorrInfoVO);
			// UPDATE
			dbDao.modifySndDtCorrInfo(korCorrInfoVO.getUserId(), korCorrInfoVO.getSubNo());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Web Service EAI용(WEB_001_0001)<br>
	 * Bonded type 을 업데이트<br>
	 *
	 * @param BkgWebServiceVO webVo
	 * @exception EventException
	 */
	public void modifyWeb0010001Control(BkgWebServiceVO webVo) throws EventException {
		try {

			// UPDATE
			dbDao.modifyBondType(webVo);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_0329]cross check 관련 result remark 저장<br>
	 * @param KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs
	 * @param SignOnUserAccount account
	 * @return KorManifestCrsChkInfoVO
	 * @exception EventException
	 */
	public KorManifestCrsChkInfoVO manageCrossCheck(KorManifestCrsChkInfoVO[] korManifestCrsChkInfoVOs, SignOnUserAccount account) throws EventException{
		KorManifestCrsChkInfoVO korManifestCrsChkInfoVO = new KorManifestCrsChkInfoVO();
		try {
			for ( int i=0; i<korManifestCrsChkInfoVOs.length; i++ ) {
				if (korManifestCrsChkInfoVOs[i].getIbflag().equals("U")) {
					dbDao.modifyCrossInfoKor(korManifestCrsChkInfoVOs[i]);
				} else if (korManifestCrsChkInfoVOs[i].getIbflag().equals("I")) {
					dbDao.addCrossInfoKor(korManifestCrsChkInfoVOs[i], account);

				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return korManifestCrsChkInfoVO;

	}

	/**
	 * Amendment Transmit 이후에 MF_SND_FLG  UPDATE
	 *
	 * @param KorBlInfoKorVO korBlInfoKorVO
	 * @throws EventException
	 */
	public void modifySndFlg(KorBlInfoKorVO korBlInfoKorVO) throws EventException {
		try {

			dbDao.modifySndFlg(korBlInfoKorVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 한국세관에 Cross Chk 화면 조회
	 *
	 * @param KorMrnNoVO manifestInfoVO
	 * @return List<KorManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public List<KorManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(KorMrnNoVO manifestInfoVO) throws EventException {
		try {

			String in_bound = manifestInfoVO.getInBound();
			String sel_type = manifestInfoVO.getSelType();
			String in_pod 	= manifestInfoVO.getInPod();
			String in_pol 	= manifestInfoVO.getInPol();


			if ("O".equals(in_bound)) {
				manifestInfoVO.setKtPort(in_pol);

			} else {
				manifestInfoVO.setKtPort(in_pod);
				// * Inbound의 경우는 OB_DECL_TP_CD = 'N' 이므로 MRN No 검색을 위하여 임의로 sel_type을 N으로 설정한다.
				if (!"M".equals(sel_type)) manifestInfoVO.setSelType("N");
			}
			return dbDao.searchManifestCrsChkInfoKorList(manifestInfoVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 한국세관에 Cross Chk 화면 Sum 조회
	 *
	 * @param KorMrnNoVO manifestInfoVO
	 * @return List<KorManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public KorMrnNoVO searchManifestCrsChkInfoSumKorList(KorMrnNoVO manifestInfoVO) throws EventException {
		try {

			String in_bound = manifestInfoVO.getInBound();
			String sel_type = manifestInfoVO.getSelType();
			String in_pod 	= manifestInfoVO.getInPod();
			String in_pol 	= manifestInfoVO.getInPol();


			if ("O".equals(in_bound)) {
				manifestInfoVO.setKtPort(in_pol);

			} else {
				manifestInfoVO.setKtPort(in_pod);
				// * Inbound의 경우는 OB_DECL_TP_CD = 'N' 이므로 MRN No 검색을 위하여 임의로 sel_type을 N으로 설정한다.
				if (!"M".equals(sel_type)) manifestInfoVO.setSelType("N");
			}
			return dbDao.searchManifestCrsChkInfoSumKorList(manifestInfoVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
}
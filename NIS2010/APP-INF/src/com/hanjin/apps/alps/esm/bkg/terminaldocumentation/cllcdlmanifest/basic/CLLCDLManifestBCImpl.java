/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CLLCDLManifestBCImpl.java
 *@FileTitle : ESM_BKG_0930
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 김승민
 **@LastVersion : 1.0
 * 2009.07.10 김승민
 * * 1.0 Creation
 * -----------------------------------------------------------
 * History 
 * 2010.10.19 경종윤 [CHM-201006576] COPRAR-discharge incomplete cntrs in flat file.
 * 					CLL/CDL for EDI (ESM_BKG_0723) 화면에서 전송시 수신 터미널이(NLRTMECTEMX,NLRTMECTDCD2, NLRTMECTHCD1) 인 경우는
 *		  			1개 FLAT FILE 생성 전송 하도록 수정
 * 2011.02.21 김영철 [CHM-201108462-01] GOH 체크 후 조회 시 해당 항목만 조회(조회 그리드 Special Cargo 항목에 "Hanger" Text 보여줌)
 * 2011.06.21 김봉균 [SRM-201117303] Corrupted flat file / COPRAR CLL
 * 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
 * 2012.08.17 김보배 [CHM-201219430] [BKG] COPRAR (Pre-S/O) EDI 보완건
 * 2012.09.21 김보배 [CHM-201220211] [BKG] Load Summary by POD 상 Special Stowage Type 추가
 * 2012.10.30 채창호 [CHM-201220810][BKG][CLL/CDL] W/O Flag추가, Transmission MSG변경
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import sun.misc.Sort;
import weblogic.auddi.util.Logger;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration.CLLCDLManifestDBDAO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestBkgQtyByCntrtsInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCdlForODCYVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllCntrDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllDgByCntrUnInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllDgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCllQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEdiTerminalInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestEtaEtdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestKorCllRemarkInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestLoadSumByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSearchVvdCdForRecieveInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclCgoSumByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclCgoTotalByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestSpclStowRqstByPodDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestStowDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestTbnTbxInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CLLCDLManifestVslSkdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlEdiDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CdlEdiListForSplitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCheckUsaVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllDgCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllRfAkCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllSpclCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CntrListForImportDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrBkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCntrSpecialInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCrossChkCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllLoadSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllModifyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllRemarkVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllRtvOptionVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoContainerVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclCgoSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetail2VO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetail3VO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSpclStowRqstDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSppVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllSumDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceManifestListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.PreAdviceVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.SpclCgoEtcDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TerminalCllVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TransmitCRCCFVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlCllDgCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlCllVO;
import com.hanjin.syscommon.common.table.BkgCstmsTmlEurVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;

/**
 * ALPS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - ALPS-TerminalDocumentation대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Seung Min
 * @see ESM_BKG_0930EventResponse,CLLCDLManifestBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CLLCDLManifestBCImpl extends BasicCommandSupport implements CLLCDLManifestBC{
	// Database Access Object
	private transient CLLCDLManifestDBDAO dbDao = null; 
	/**
	 * CLLCDLManifestBCImpl 객체 생성.<br>
	 * CLLCDLManifestDBDAO 생성한다.<br>
	 */ 
	public CLLCDLManifestBCImpl(){
		dbDao = new CLLCDLManifestDBDAO();
	}
 
	/**
	 * POL 터미널에 전송할 Container Loading List(Korea) 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllDetailVO>
	 * @exception EventException
	 */
	public List<KorCllDetailVO> searchKorCll(KorCllCondVO korCllCondVO) throws EventException{
		String tVslCd = "";
		String vvdCdNm = "";
		String polCdPrint = "";
		String vpsETD = "";
		List<KorCllDetailVO> korCllDetailVOs = null;
		List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs = null;
		try{
			String inVvdCd = korCllCondVO.getInVvdCd();
			// inVvdCd.substring()을 너무 자주 호출해서 추가하였다.
			String inVsl = inVvdCd.substring(0, 4);
			String inVoy = inVvdCd.substring(4, 8);
			String inDir = inVvdCd.substring(8);
			
			String inPolCd = korCllCondVO.getInPolCd();
			String inPolYdCd = korCllCondVO.getInPolYdCd();
			String inCllType = korCllCondVO.getInCllType();
			String inBkgStsCd = korCllCondVO.getInBkgStsCd();
			String inCntrCfmFlg = korCllCondVO.getInCntrCfmFlg();
			String inSortType = korCllCondVO.getInSortType();
			String inWhereGubun = korCllCondVO.getInWhereGubun();
			String inPolCntCd = ""; 
			if(inPolCd.length() > 2)
				inPolCntCd = korCllCondVO.getInPolCd().substring(0,2);

			tVslCd = dbDao.searchTmnlVslCd(inVsl);

			cLLCDLManifestVslSkdInfoVOs = dbDao.searchVslSkd(korCllCondVO);

			if(cLLCDLManifestVslSkdInfoVOs.size() == 0){
				throw new EventException(new ErrorHandler("BKG00889", new String[]{}).getMessage());
			}else{
				vvdCdNm = cLLCDLManifestVslSkdInfoVOs.get(0).getVvdCd2();
				polCdPrint = inPolCd;
				vpsETD = cLLCDLManifestVslSkdInfoVOs.get(0).getVpsEtdDt();
			}

			// Container Loading List(Korea) Final EDI Date를 조회한다.
			String maxEdiSndDt = dbDao.searchKorCllFinalEdiDt(inVsl, inVoy, inDir, inPolCd, inPolYdCd);
			
			if(inCllType.equals("CLL")){ 
				//Container Loading List(Korea) Data를 조회한다.
				korCllDetailVOs = dbDao.searchKorCllList(inVsl, inVoy, inDir, inPolCd, inPolYdCd, inSortType, inBkgStsCd, inCntrCfmFlg);
			}else{
				if(inCllType.equals("TS")){ 
					//Container Loading List(Korea) T/S Cargo Data를 조회한다.
					korCllDetailVOs = dbDao.searchKorCllTsList(inVsl, inVoy, inDir, inPolCd, inPolYdCd, inBkgStsCd, inCntrCfmFlg, inSortType, inPolCntCd);
				}else if(inCllType.equals("LOCAL")){ 
					//Container Loading List(Korea) Local Cargo Data를 조회한다.
					korCllDetailVOs = dbDao.searchKorCllLocalList(inVsl, inVoy,	inDir, inPolCd, inPolYdCd, inBkgStsCd, inCntrCfmFlg, inSortType, inPolCntCd);
				}else if(inCllType.equals("EMPTY")){ 
					//Container Loading List(Korea) Empty Cargo Data를 조회한다.
					korCllDetailVOs = dbDao.searchKorCllEmptyList(inVsl, inVoy, inDir, inPolCd, inPolYdCd, inBkgStsCd, inCntrCfmFlg, inSortType, inPolCntCd);
				}

				//String bkgTempNo = "";
				for(int i = 0; i < korCllDetailVOs.size(); i++){
					KorCllDetailVO korCllDetailVO = korCllDetailVOs.get(i);

					if(!korCllDetailVO.getCllRmk3().equals("")){
						korCllDetailVO.setCllRmk2(korCllDetailVO.getCllRmk2()+"("+korCllDetailVO.getCllRmk3()+")");
					}
					/*if(inCllType.equals("TS")){ 
						//double calling된 Yard Code가 있는 지 체크한다.
						int count = 0;
						if(korCllDetailVO.getTsVvdCd().equals("") || korCllDetailVO.getTsVvdCd() == null)
						{
							count = dbDao.searchDoubleCallYd(korCllDetailVO.getVslCd(), korCllDetailVO.getSkdVoyNo(),
								korCllDetailVO.getSkdDirCd(), "", "", "", inPolCd);
						}else{
							count = dbDao.searchDoubleCallYd(korCllDetailVO.getVslCd(), korCllDetailVO.getSkdVoyNo(),
									korCllDetailVO.getSkdDirCd(), korCllDetailVO.getTsVvdCd().substring(0, 4),
									korCllDetailVO.getTsVvdCd().substring(4, 8), korCllDetailVO.getTsVvdCd().substring(8),
									inPolCd);						
						}
						if(count > 0){
							korCllDetailVO.setTsFlg("TT");
						}else{
							korCllDetailVO.setTsFlg("TS");
						}
					}*/

					//Danger Cargo 존재 여부를 체크한다.
					String dGExist = dbDao.searchDgCgo(korCllDetailVO.getBkgNo(), korCllDetailVO.getCntrNo());
					if(!dGExist.equals("")){
						korCllDetailVO.setKrTmlPrctId("");
					}
					
					if(!korCllDetailVO.getCdoTemp().equals("")){
						korCllDetailVO.setKrTmlPrctId("");
					}

					//AWKWARD Cargo 존재 여부를 체크한다.
					String awkNo = dbDao.searchAwkCgo(korCllDetailVO.getBkgNo(), korCllDetailVO.getCntrNo());
					if(!awkNo.equals("")){
						korCllDetailVO.setCllRmk1(awkNo);
						korCllDetailVO.setKrTmlPrctId("");
					}else{
						//Reefer Dry Cargo 존재 여부를 체크한다.
						String rdExist = dbDao.searchRdCgo(korCllDetailVO.getBkgNo(), korCllDetailVO.getCntrNo());
						if(!rdExist.equals("")){
							korCllDetailVO.setCllRmk1("RD");
							korCllDetailVO.setKrTmlPrctId("");
						}
						//if(!bkgTempNo.equals(korCllDetailVO.getBkgNo())){
							//Break Bulk Cargo 정보로 구성된 Break Bulk No 를 조회한다.
							String bbExist = dbDao.searchBbCgo(korCllDetailVO.getBkgNo(), korCllDetailVO.getCntrNo());
							if(!bbExist.equals("")){
								korCllDetailVO.setCllRmk1(bbExist);
								korCllDetailVO.setKrTmlPrctId("");
							}
							//bkgTempNo = korCllDetailVO.getBkgNo();
						//}
						//Stowage, Danger Cargo 존재 여부를 체크한다.
						List<CLLCDLManifestStowDgInfoVO> cLLCDLManifestStowDgInfoVOs = dbDao.searchStowDg(korCllDetailVO.getBkgNo());
						if(cLLCDLManifestStowDgInfoVOs.size() > 0){ 
							korCllDetailVO.setKrTmlPrctId("");
						}
					}
					
					//if(korCllDetailVO.getCllRmk1().trim().equals("INGU"))
					//	korCllDetailVO.setStwgCd("");
					
					korCllDetailVOs.set(i, korCllDetailVO);
				}
			}

			List<KorCllDetailVO> korCllDetailVOs2 = new ArrayList<KorCllDetailVO>();
			//POL, POD 그룹화하여 표시줄 삽입
			if(inSortType.equals("") || inSortType.equals("1") || inSortType.equals("2")){
				String tempCd = "";
				int totalCount = 0;
				for(int i = 0; i < korCllDetailVOs.size(); i++){
					KorCllDetailVO korCllDetailVO = korCllDetailVOs.get(i);
					KorCllDetailVO korCllDetailVO2 = new KorCllDetailVO();

					// if(inSortType.equals("")){
					if(inCllType.equals("TS")){
						if(!tempCd.equals(korCllDetailVOs.get(i).getPodCd())){
							korCllDetailVO2.setCntrNo("POL : " + korCllDetailVO.getBkgPolCd());
							if(inWhereGubun.equals("931")){
								korCllDetailVO2.setBkgNo("POD : " + korCllDetailVO.getPodCd());
							}else{
								korCllDetailVO2.setSealNo("POD : " + korCllDetailVO.getPodCd());
							}
							
							if(i == 0){
								korCllDetailVOs2.add(i, korCllDetailVO2);
								totalCount++;
								for(int j = i; j < korCllDetailVOs.size(); j++){
									korCllDetailVOs2.add(j + totalCount, korCllDetailVOs.get(j));
								}
							}else{
								korCllDetailVOs2.set(i + totalCount, korCllDetailVO2);

								for(int j = i + totalCount + 1; j - totalCount - 1 < korCllDetailVOs.size(); j++){
									if(j >= korCllDetailVOs2.size())
										korCllDetailVOs2.add(j, korCllDetailVOs.get(j - totalCount - 1));
									else
										korCllDetailVOs2.set(j, korCllDetailVOs.get(j - totalCount - 1));
								}
								totalCount++;
							}
							tempCd = korCllDetailVO.getPodCd();
						}
					}else if(inCllType.equals("CLL")){
						if(!tempCd.equals(korCllDetailVOs.get(i).getPodCd())){
							korCllDetailVO2.setCntrNo("POL : " + korCllDetailVO.getPolCd());
							if(inWhereGubun.equals("931")){
								korCllDetailVO2.setBkgNo("POD : " + korCllDetailVO.getPodCd());
							}else{
								korCllDetailVO2.setSealNo("POD : " + korCllDetailVO.getPodCd());
							}

							if(i == 0){
								korCllDetailVOs2.add(i, korCllDetailVO2);
								totalCount++;
								for(int j = i; j < korCllDetailVOs.size(); j++){
									korCllDetailVOs2.add(j + totalCount, korCllDetailVOs.get(j));
								}
							}else{
								korCllDetailVOs2.set(i + totalCount, korCllDetailVO2);

								for(int j = i + totalCount + 1; j - totalCount - 1 < korCllDetailVOs.size(); j++){
									if(j >= korCllDetailVOs2.size())
										korCllDetailVOs2.add(j, korCllDetailVOs.get(j - totalCount - 1));
									else
										korCllDetailVOs2.set(j, korCllDetailVOs.get(j - totalCount - 1));
								}
								totalCount++;
							}
							tempCd = korCllDetailVO.getPodCd();
						}
					}else{
						if(!tempCd.equals(korCllDetailVOs.get(i).getPodCd())){

							korCllDetailVO2.setCntrNo("POL : " + korCllDetailVO.getBkgPolCd());
							if(inWhereGubun.equals("931"))
								korCllDetailVO2.setBkgNo("POD : " + korCllDetailVO.getPodCd());
							else
								korCllDetailVO2.setSealNo("POD : " + korCllDetailVO.getPodCd());

							if(i == 0){
								korCllDetailVOs2.add(i, korCllDetailVO2);
								totalCount++;
								for(int j = i; j < korCllDetailVOs.size(); j++){
									korCllDetailVOs2.add(j + totalCount, korCllDetailVOs.get(j));
								}
							}else{
								korCllDetailVOs2.set(i + totalCount, korCllDetailVO2);

								for(int j = i + totalCount + 1; j - totalCount - 1 < korCllDetailVOs.size(); j++){
									if(j >= korCllDetailVOs2.size())
										korCllDetailVOs2.add(j, korCllDetailVOs.get(j - totalCount - 1));
									else
										korCllDetailVOs2.set(j, korCllDetailVOs.get(j - totalCount - 1));
								}
								totalCount++;
							}
							tempCd = korCllDetailVO.getPodCd();
						}
					}
				}
				korCllDetailVOs = korCllDetailVOs2;

			}
			if(korCllDetailVOs.size() != 0){
				korCllDetailVOs.get(0).setTVslCd(tVslCd);
				korCllDetailVOs.get(0).setVvdCdNm(vvdCdNm);
				korCllDetailVOs.get(0).setPolCdPrint(polCdPrint);
				korCllDetailVOs.get(0).setVpsEtd(vpsETD);
				korCllDetailVOs.get(0).setMaxEdiSndDt(maxEdiSndDt);
			}
			return korCllDetailVOs;
		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 터미널에 전송할 Container Loading List(Korea)의 Summay 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return List<KorCllSumDetailVO>
	 * @exception EventException
	 */
	public List<KorCllSumDetailVO> searchKorCllSummary(KorCllCondVO korCllCondVO) throws EventException{
		try{
			List<KorCllSumDetailVO> korCllSumDetailVOs = new ArrayList<KorCllSumDetailVO>();
			List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs = null;
			List<CLLCDLManifestLoadSumByPodDetailVO> cLLCDLManifestLoadSumByPodDetailVOs = null;
			List<CLLCDLManifestSpclCgoSumByPodDetailVO> cLLCDLManifestSpclCgoSumByPodDetailVOs = null;
//			List<CLLCDLManifestSpclStowRqstByPodDetailVO> cLLCDLManifestSpclStowRqstByPodDetailVOs = null;
			List<KorCllLoadSumDetailVO> korCllLoadSumDetailVOs = new ArrayList<KorCllLoadSumDetailVO>();	// 2015.04.24 소스 보안[CWE-476]으로 스정
			List<KorCllSpclCgoSumDetailVO> korCllSpclCgoSumDetailVOs = new ArrayList<KorCllSpclCgoSumDetailVO>(); // 2015.04.24 소스 보안[CWE-476]으로 스정
			List<KorCllSpclStowRqstDetailVO> korCllSpclStowRqstDetailVOs = new ArrayList<KorCllSpclStowRqstDetailVO>(); // 2015.04.24 소스 보안[CWE-476]으로 스정
			List<KorCllSpclStowRqstDetail2VO> korCllSpclStowRqstDetail2VOs = new ArrayList<KorCllSpclStowRqstDetail2VO>(); // 2015.04.24 소스 보안[CWE-476]으로 스정
			List<KorCllSpclStowRqstDetail3VO> korCllSpclStowRqstDetail3VOs = new ArrayList<KorCllSpclStowRqstDetail3VO>(); // 2015.04.24 소스 보안[CWE-476]으로 스정
			List<CLLCDLManifestKorCllRemarkInfoVO> cLLCDLManifestKorCllRemarkInfoVOs = null;
			KorCllSumDetailVO korCllSumDetailVO = new KorCllSumDetailVO();

			//팝업이면
			if(korCllCondVO.getInUiType().equals("P")){
				//Container Loading List(Korea) 관련 Vessel Schedule 정보를 조회한다.
				cLLCDLManifestVslSkdInfoVOs = dbDao.searchVslSkd(korCllCondVO);

				//Container Loading List(Korea) Loading Summary By POD 정보를 조회한다.
				cLLCDLManifestLoadSumByPodDetailVOs = dbDao.searchLoadSumByPod(korCllCondVO);
				//Container Loading List(Korea) Special Cargo Summary By POD 정보를 조회한다.
				cLLCDLManifestSpclCgoSumByPodDetailVOs = dbDao.searchSpclCgoSumByPod(korCllCondVO);
				//Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.
//				cLLCDLManifestSpclStowRqstByPodDetailVOs = dbDao.searchSpclStowRqstByPod(korCllCondVO);
				korCllSpclStowRqstDetailVOs = dbDao.searchCllSpclStowRqstByPod(korCllCondVO);
				korCllSpclStowRqstDetail2VOs = dbDao.searchCllSpclStowRqst2ByPod(korCllCondVO);
				korCllSpclStowRqstDetail3VOs = dbDao.searchCllSpclStowRqst3ByPod(korCllCondVO);

				korCllSumDetailVO.setCLLCDLManifestVslSkdInfoVOs(cLLCDLManifestVslSkdInfoVOs);
				korCllSumDetailVO.setCLLCDLManifestLoadSumByPodDetailVOs(cLLCDLManifestLoadSumByPodDetailVOs);
				korCllSumDetailVO.setCLLCDLManifestSpclCgoSumByPodDetailVOs(cLLCDLManifestSpclCgoSumByPodDetailVOs);
//				korCllSumDetailVO.setCLLCDLManifestSpclStowRqstByPodDetailVOs(cLLCDLManifestSpclStowRqstByPodDetailVOs);
				if(korCllSpclStowRqstDetailVOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclStowRqstDetailVOs(korCllSpclStowRqstDetailVOs);
				if(korCllSpclStowRqstDetail2VOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclStowRqstDetail2VOs(korCllSpclStowRqstDetail2VOs);
				if(korCllSpclStowRqstDetail3VOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclStowRqstDetail3VOs(korCllSpclStowRqstDetail3VOs);
			//메인이면
			}else if(korCllCondVO.getInUiType().equals("M")){
				//Container Loading List(Korea) 관련 Vessel Schedule 정보를 조회한다.
				cLLCDLManifestVslSkdInfoVOs = dbDao.searchVslSkd(korCllCondVO);
				korCllCondVO.setInVslCd(korCllCondVO.getInVvdCd().substring(0, 4));
				korCllCondVO.setInSkdVoyNo(korCllCondVO.getInVvdCd().substring(4, 8));
				korCllCondVO.setInSkdDirCd(korCllCondVO.getInVvdCd().substring(8));

				//By POD
				if(korCllCondVO.getInByType().equals("P")){
					//Container Loading List(Korea) Loading Summary By POD 정보를 조회한다.
					korCllLoadSumDetailVOs = dbDao.searchCllLoadSumByPod(korCllCondVO);
					//Container Loading List(Korea) Special Cargo Summary By POD 정보를 조회한다.
					korCllSpclCgoSumDetailVOs = dbDao.searchCllSpclCgoSumByPod(korCllCondVO);
					//Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.
					korCllSpclStowRqstDetailVOs = dbDao.searchCllSpclStowRqstByPod(korCllCondVO);
					korCllSpclStowRqstDetail2VOs = dbDao.searchCllSpclStowRqst2ByPod(korCllCondVO);
					korCllSpclStowRqstDetail3VOs = dbDao.searchCllSpclStowRqst3ByPod(korCllCondVO);
				//By A.POD
				}else if(korCllCondVO.getInByType().equals("A")){
					//Container Loading List(Korea) Loading Summary By POD 정보를 조회한다.
					korCllLoadSumDetailVOs = dbDao.searchLoadSumByActPod(korCllCondVO);
					//Container Loading List(Korea) Special Cargo Summary By POD 정보를 조회한다.
					korCllSpclCgoSumDetailVOs = dbDao.searchSpclCgoSumByActPod(korCllCondVO);
					//Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.
					korCllSpclStowRqstDetailVOs = dbDao.searchSpclStowRqstByActPod(korCllCondVO);
				//By MLB
				}else if(korCllCondVO.getInByType().equals("M")){
					//Container Loading List(Korea) Loading Summary By MLB 정보를 조회한다.
					korCllLoadSumDetailVOs = dbDao.searchLoadSumByMlb(korCllCondVO);
					//Container Loading List(Korea) Special Cargo Summary By MLB 정보를 조회한다..
					korCllSpclCgoSumDetailVOs = dbDao.searchSpclCgoSumByMlb(korCllCondVO);
					//Container Loading List(Korea) Special Stowage Request MLB 정보를 조회한다.
					korCllSpclStowRqstDetailVOs = dbDao.searchSpclStowRqstByMlb(korCllCondVO);
					korCllSpclStowRqstDetail2VOs = dbDao.searchSpclStowRqst2ByMlb(korCllCondVO);
					korCllSpclStowRqstDetail3VOs = dbDao.searchSpclStowRqst3ByMlb(korCllCondVO);
				}

				korCllSumDetailVO.setCLLCDLManifestVslSkdInfoVOs(cLLCDLManifestVslSkdInfoVOs);
				if(korCllLoadSumDetailVOs.size() != 0)
					korCllSumDetailVO.setKorCllLoadSumDetailVOs(korCllLoadSumDetailVOs);
				if(korCllSpclCgoSumDetailVOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclCgoSumDetailVOs(korCllSpclCgoSumDetailVOs);
				if(korCllSpclStowRqstDetailVOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclStowRqstDetailVOs(korCllSpclStowRqstDetailVOs);
				if(korCllSpclStowRqstDetail2VOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclStowRqstDetail2VOs(korCllSpclStowRqstDetail2VOs);
				if(korCllSpclStowRqstDetail3VOs.size() != 0)
					korCllSumDetailVO.setKorCllSpclStowRqstDetail3VOs(korCllSpclStowRqstDetail3VOs);
			}

			//Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.
			cLLCDLManifestKorCllRemarkInfoVOs = dbDao.searchKorCllRemark(korCllCondVO);
			if(cLLCDLManifestKorCllRemarkInfoVOs.size() != 0)
				korCllSumDetailVO.setCLLCDLManifestKorCllRemarkInfoVOs(cLLCDLManifestKorCllRemarkInfoVOs);

			korCllSumDetailVOs.add(korCllSumDetailVO);

			return korCllSumDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 터미널에 전송할 Container Loading List(Korea)의 Summay 정보를 조회한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @return KorCllSpclCgoContainerVO
	 * @exception EventException
	 */
	public KorCllSpclCgoContainerVO searchKorCllSpecialCgo(KorCllCondVO korCllCondVO) throws EventException{
		try{
			KorCllSpclCgoContainerVO korCllSpclCgoContainerVO = new KorCllSpclCgoContainerVO();
			List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs = null;
			List<KorCllSpclCgoDetailVO> korCllSpclCgoDetailVOs = null;
			List<CLLCDLManifestSpclCgoTotalByPodDetailVO> cLLCDLManifestSpclCgoTotalByPodDetailVOs = null;
			List<SpclCgoEtcDetailVO> spclCgoEtcDetailVOs = null;

			//Container Loading List(Korea) 관련 Vessel Schedule 정보를 조회한다.
			cLLCDLManifestVslSkdInfoVOs = dbDao.searchVslSkd(korCllCondVO);

			
			//Container Loading List(Korea) Specail Cargo Data를 조회한다.
			korCllSpclCgoDetailVOs = dbDao.searchSpclCgoDtl(korCllCondVO);
			//Container Loading List(Korea) Special Cargo Total By POD 정보를 조회한다.
			cLLCDLManifestSpclCgoTotalByPodDetailVOs = dbDao.searchSpclCgoTotalByPod(korCllCondVO);
			//Container Loading List(Korea) Special Cargo R/D, PC, STOW 정보를 조회한다.
			spclCgoEtcDetailVOs = dbDao.searchSpclCgoEtc(korCllCondVO);

			//시퀀스 세팅
			if(korCllCondVO.getInSortType().equals("1") || korCllCondVO.getInSortType().equals("2")){
				if(korCllSpclCgoDetailVOs.size() != 0){
					String bkgNo = korCllSpclCgoDetailVOs.get(0).getBkgNo();
					int seqNumber = 1;
					String newRemark = "";
					for(int i = 0; i < korCllSpclCgoDetailVOs.size(); i++){
						if(korCllSpclCgoDetailVOs.get(i).getBkgNo().equals(bkgNo)){
							korCllSpclCgoDetailVOs.get(i).setSeq(seqNumber + "");
						}else{
							bkgNo = korCllSpclCgoDetailVOs.get(i).getBkgNo();
							korCllSpclCgoDetailVOs.get(i).setSeq(++seqNumber + "");
						}
						if(korCllSpclCgoDetailVOs.get(i).getCgoType().equals("AK") 
								&& korCllSpclCgoDetailVOs.get(i).getVoId().equals("0"))
						{
							
							//korCllSpclCgoDetailVOs.get(i).setRemark(korCllSpclCgoDetailVOs.get(i).getRemark()+korCllSpclCgoDetailVOs.get(i).getRemark()==null?"":" "+"INGAUGE");
							
							
							/*
							 * 2010.12.27 경종윤
							 * korCllSpclCgoDetailVOs.get(i).setRemark(newRemark) <= setRemark 값 변경
							 */
							newRemark = korCllSpclCgoDetailVOs.get(i).getRemark();
							if(null == newRemark || "".equals(newRemark)) {
								newRemark = " INGAUGE";
							}
							korCllSpclCgoDetailVOs.get(i).setRemark(newRemark);
							
							
						}
					}
				}
			}

			List<KorCllSpclCgoDetailVO> korCllSpclCgoDetailVOs2 = new ArrayList<KorCllSpclCgoDetailVO>();
			//POL, POD 삽입줄 넣기
			if(korCllCondVO.getInSortType().equals("1")){
				String tempCd = "";
				int totalCount = 0;
				for(int i = 0; i < korCllSpclCgoDetailVOs.size(); i++){
					KorCllSpclCgoDetailVO korCllSpclCgoDetailVO = korCllSpclCgoDetailVOs.get(i);
					KorCllSpclCgoDetailVO korCllSpclCgoDetailVO2 = new KorCllSpclCgoDetailVO();

					if(!tempCd.equals(korCllSpclCgoDetailVO.getPod())){

						korCllSpclCgoDetailVO2.setCgoType("POL : " + korCllSpclCgoDetailVO.getPol());
						korCllSpclCgoDetailVO2.setBkgNo("POD : " + korCllSpclCgoDetailVO.getPod());

						if(i == 0){
							korCllSpclCgoDetailVOs2.add(i, korCllSpclCgoDetailVO2);
							totalCount++;
							for(int j = i; j < korCllSpclCgoDetailVOs.size(); j++){
								korCllSpclCgoDetailVOs2.add(j + totalCount, korCllSpclCgoDetailVOs.get(j));
							}
						}else{
							korCllSpclCgoDetailVOs2.set(i + totalCount, korCllSpclCgoDetailVO2);

							for(int j = i + totalCount + 1; j - totalCount - 1 < korCllSpclCgoDetailVOs.size(); j++){
								if(j >= korCllSpclCgoDetailVOs2.size())
									korCllSpclCgoDetailVOs2.add(j, korCllSpclCgoDetailVOs.get(j - totalCount - 1));
								else
									korCllSpclCgoDetailVOs2.set(j, korCllSpclCgoDetailVOs.get(j - totalCount - 1));
							}
							totalCount++;
						}
						tempCd = korCllSpclCgoDetailVO.getPod();
					}
				}
				korCllSpclCgoDetailVOs = korCllSpclCgoDetailVOs2;
			}

			korCllSpclCgoContainerVO.setCLLCDLManifestVslSkdInfoVOs(cLLCDLManifestVslSkdInfoVOs);
			korCllSpclCgoContainerVO.setKorCllSpclCgoDetailVO(korCllSpclCgoDetailVOs);
			korCllSpclCgoContainerVO
					.setCLLCDLManifestSpclCgoTotalByPodDetailVOs(cLLCDLManifestSpclCgoTotalByPodDetailVOs);
			korCllSpclCgoContainerVO
			.setSpclCgoEtcDetailVOs(spclCgoEtcDetailVOs);

			return korCllSpclCgoContainerVO;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다. <br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return KorCllCdlDetailContainerVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public KorCllCdlDetailContainerVO searchKorCllCdl(KorCllCdlCondVO korCllCdlCondVO) throws EventException{

		List<KorCllCdlDetailVO> korCllCdlDetailVOs = null;
		List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs = null;
		KorCllCdlDetailContainerVO korCllCdlDetailContainerVO = new KorCllCdlDetailContainerVO();
		try{
			KorCllCondVO korCllCondVO = new KorCllCondVO();
			korCllCondVO.setInVvdCd(korCllCdlCondVO.getInVvdCd());
			if(korCllCdlCondVO.getInListType().equals("L")){
				korCllCondVO.setInPolCd(korCllCdlCondVO.getInPolCd());
				korCllCondVO.setInPolYdCd(korCllCdlCondVO.getInPolYdCd());
				korCllCondVO.setInSplitNo(korCllCdlCondVO.getPolSplitNo()); // Add. 2014.02.02
			}else{
				korCllCondVO.setInPolCd(korCllCdlCondVO.getInPodCd());
				korCllCondVO.setInPolYdCd(korCllCdlCondVO.getInPodYdCd());
				korCllCondVO.setInSplitNo(korCllCdlCondVO.getPodSplitNo()); // Add. 2014.02.02
			}
			cLLCDLManifestVslSkdInfoVOs = dbDao.searchVslSkd(korCllCondVO);
			
			if(korCllCdlCondVO.getInBkgCgoTpCd().length()>0
					 && !korCllCdlCondVO.getInBkgCgoTpCd().equals("A"))
			{
				ArrayList  tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(korCllCdlCondVO.getInBkgCgoTpCd(), ",");
				StringBuffer inBkgCgoTpCd = new StringBuffer();
				while(token.hasMoreTokens()){
					tmpArray.add(token.nextToken());
				}
				for(int i=0; i<tmpArray.size() ; i++)
				{
					inBkgCgoTpCd.append("'").append(tmpArray.get(i).toString()).append("',");
				}
				korCllCdlCondVO.setInBkgCgoTpCd(inBkgCgoTpCd.toString().substring(0,inBkgCgoTpCd.toString().length()-1));
			}	
		
			if(korCllCdlCondVO.getInCntrTpszCd().length()>0)
			{
				ArrayList  tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(korCllCdlCondVO.getInCntrTpszCd(), ",");
				StringBuffer inCntrTpszCd = new StringBuffer();
				while(token.hasMoreTokens()){
					tmpArray.add(token.nextToken());
				}
				for(int i=0; i<tmpArray.size() ; i++)
				{
					inCntrTpszCd.append("'").append(tmpArray.get(i).toString()).append("',");
				}

				korCllCdlCondVO.setInCntrTpszCd(inCntrTpszCd.toString().substring(0,inCntrTpszCd.toString().length()-1));
			}	
			
			if(korCllCdlCondVO.getInRcvTermCd().length()>0)
			{
				ArrayList  tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(korCllCdlCondVO.getInRcvTermCd(), ",");
				StringBuffer inRcvTermCd = new StringBuffer();
				while(token.hasMoreTokens()){
					tmpArray.add(token.nextToken());
				}
				for(int i=0; i<tmpArray.size() ; i++)
				{
					inRcvTermCd.append("'").append(tmpArray.get(i).toString()).append("',");
				}
				korCllCdlCondVO.setInRcvTermCd(inRcvTermCd.toString().substring(0,inRcvTermCd.toString().length()-1));
			}		
			
			if(korCllCdlCondVO.getInDeTermCd().length()>0)
			{
				ArrayList  tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(korCllCdlCondVO.getInDeTermCd(), ",");
				StringBuffer inDeTermCd = new StringBuffer();
				while(token.hasMoreTokens()){
					tmpArray.add(token.nextToken());
				}
				for(int i=0; i<tmpArray.size() ; i++)
				{
					inDeTermCd.append("'").append(tmpArray.get(i).toString()).append("',");
				}
				korCllCdlCondVO.setInDeTermCd(inDeTermCd.toString().substring(0,inDeTermCd.toString().length()-1));
			}	
			
			if(korCllCdlCondVO.getInOrgTrnsSvdModCd().length()>0)
			{
				ArrayList  tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(korCllCdlCondVO.getInOrgTrnsSvdModCd(), ",");
				StringBuffer inOrgTrnsSvdModCd = new StringBuffer();
				while(token.hasMoreTokens()){
					tmpArray.add(token.nextToken());
				}
				for(int i=0; i<tmpArray.size() ; i++)
				{
					inOrgTrnsSvdModCd.append("'").append(tmpArray.get(i).toString()).append("',");
				}
				korCllCdlCondVO.setInOrgTrnsSvdModCd(inOrgTrnsSvdModCd.toString().substring(0,inOrgTrnsSvdModCd.toString().length()-1));
			}
			
			if(korCllCdlCondVO.getInDestTrnsSvcModCd().length()>0)
			{
				ArrayList  tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(korCllCdlCondVO.getInDestTrnsSvcModCd(), ",");
				StringBuffer inDestTrnsSvcModCd = new StringBuffer();
				while(token.hasMoreTokens()){
					tmpArray.add(token.nextToken());
				}
				for(int i=0; i<tmpArray.size() ; i++)
				{
					inDestTrnsSvcModCd.append("'").append(tmpArray.get(i).toString()).append("',");
				}
				korCllCdlCondVO.setInDestTrnsSvcModCd(inDestTrnsSvcModCd.toString().substring(0,inDestTrnsSvcModCd.toString().length()-1));
			}				
			
			if(korCllCdlCondVO.getInCntrMatch().equals("Y"))
			{

				korCllCdlDetailVOs = dbDao.searchCllCdl(korCllCdlCondVO);
				
				if(korCllCdlCondVO.getInListType().equals("D")) 
				{
					if(korCllCdlCondVO.getInPodCd().substring(0,2).equals("KR")) 
					{
						for(int i=0 ; i<korCllCdlDetailVOs.size() ; i++) 
						{
							//korCllCdlDetailVOs.get(i);
							if(korCllCdlDetailVOs.get(i).getTsCd().equals("T")){
								if(!korCllCdlDetailVOs.get(i).getVvdCd().equals("")
									 && korCllCdlDetailVOs.get(i).getVvdCd() != null)
								{
									int count = dbDao.searchDoubleCallYd(korCllCdlCondVO.getInVvdCd().substring(0,4), 
																		 korCllCdlCondVO.getInVvdCd().substring(4,8),
																		 korCllCdlCondVO.getInVvdCd().substring(8),
																		 korCllCdlDetailVOs.get(i).getVvdCd().substring(0, 4),
																		 korCllCdlDetailVOs.get(i).getVvdCd().substring(4, 8), 
																		 korCllCdlDetailVOs.get(i).getVvdCd().substring(8),
																		 korCllCdlCondVO.getInPodCd());
									if(count > 0){
										korCllCdlDetailVOs.get(i).setTsCd("TT");
									}else{
										korCllCdlDetailVOs.get(i).setTsCd("TL");
									}
								}
								
							}
						}
					}
				}					
				
	            for(int i = 0; i < korCllCdlDetailVOs.size(); i++){
					KorCllCdlDetailVO korCllCdlDetailVO = korCllCdlDetailVOs.get(i);

					String spclCgoDescType = "";
					String spclCgoDesc = "";
					String spclCgoDesc1 = "";
					String spclCgoDesc2 = "";
					String spclCgoDesc3 = "";
					String spclCgoDesc4 = "";
					String spclCgoDesc5 = "";
					String spclCgoDesc6 = "";
					String spclCgoDesc7 = "";
					int totalCount = 0;
					StringBuffer sb = new StringBuffer();
					korCllCdlCondVO.setInCntrNo(korCllCdlDetailVO.getCntrNo());
					korCllCdlCondVO.setInBkgNo(korCllCdlDetailVO.getBkgNo());
		
					if(korCllCdlDetailVO.getDcgoFlg().equals("Y")){
						korCllCdlCondVO.setInSpclCgoType("D");
						spclCgoDescType = "D";
						spclCgoDesc1 = dbDao.searchSpecialCgo(korCllCdlCondVO);
						totalCount++;
					}
					if(korCllCdlDetailVO.getRcFlg().equals("Y")){
						korCllCdlCondVO.setInSpclCgoType("R");
						spclCgoDescType = "R";
						spclCgoDesc2 = dbDao.searchSpecialCgo(korCllCdlCondVO);
						totalCount++;
					}
					if(korCllCdlDetailVO.getAwkCgoFlg().equals("Y")){
						korCllCdlCondVO.setInSpclCgoType("A");
						spclCgoDescType = "A";
						spclCgoDesc3 = dbDao.searchSpecialCgo(korCllCdlCondVO);
						totalCount++;
					}
					
					if("".equals(korCllCdlCondVO.getThaiOfc()) || "N".equals(korCllCdlCondVO.getThaiOfc()) ){
						if(korCllCdlDetailVO.getPrctFlg().equals("Y")){
							spclCgoDescType = "P";

							spclCgoDesc4 = "Precaution cargo";
							totalCount++;
						}
					}
					if(korCllCdlDetailVO.getRdCgoFlg().equals("Y")){
						spclCgoDescType = "RD";

						spclCgoDesc5 = "Reefer Dry";
						totalCount++;
					}
					if(korCllCdlDetailVO.getHngrFlg().equals("Y")){
						spclCgoDescType = "GOH";

						spclCgoDesc6 = "Hanger";
						totalCount++;
					}
					if(korCllCdlCondVO.getThaiOfc().equals("Y")){
						if(korCllCdlDetailVO.getBbCgoFlg().equals("Y")){
						spclCgoDesc7 = "Break Bulk";
						}
					}else{
						spclCgoDesc7 = "";
					}
					
					if(totalCount > 1){
						spclCgoDescType = "M";
						if(!spclCgoDesc1.equals(""))
							sb.append(spclCgoDesc1).append(" / ");
						if(!spclCgoDesc2.equals(""))
							sb.append(spclCgoDesc2).append(" / ");
						if(!spclCgoDesc3.equals(""))
							sb.append(spclCgoDesc3).append(" / ");
						if(!spclCgoDesc4.equals(""))
							sb.append(spclCgoDesc4).append(" / ");
						if(!spclCgoDesc5.equals(""))
							sb.append(spclCgoDesc5).append(" / ");
						if(!spclCgoDesc6.equals(""))
							sb.append(spclCgoDesc6).append(" / ");
						if(!spclCgoDesc7.equals(""))
							sb.append(spclCgoDesc7).append(" / ");
						spclCgoDesc = sb.toString();
						spclCgoDesc = spclCgoDesc.substring(0, sb.toString().length() - 3);
					}else{
						if(!spclCgoDesc1.equals(""))
							spclCgoDesc = spclCgoDesc1;
						if(!spclCgoDesc2.equals(""))
							spclCgoDesc = spclCgoDesc2;
						if(!spclCgoDesc3.equals(""))
							spclCgoDesc = spclCgoDesc3;
						if(!spclCgoDesc4.equals(""))
							spclCgoDesc = spclCgoDesc4;
						if(!spclCgoDesc5.equals(""))
							spclCgoDesc = spclCgoDesc5;
						if(!spclCgoDesc6.equals(""))
							spclCgoDesc = spclCgoDesc6;
						if(!spclCgoDesc7.equals(""))
							spclCgoDesc = spclCgoDesc7;
					}
					korCllCdlDetailVOs.get(i).setSpclCgoDescType(spclCgoDescType);
					korCllCdlDetailVOs.get(i).setSpclCgoDesc(spclCgoDesc);

				}				
				List<KorCllCdlDetailVO> korCllCdlDetailVOs2 = new ArrayList<KorCllCdlDetailVO>();
				if(korCllCdlCondVO.getInOrderByType().equals("")){
					String tempCd = "";
					String tempCd2 = "";
					int totalCount = 0;
					if(korCllCdlDetailVOs != null){
						for(int i = 0; i < korCllCdlDetailVOs.size(); i++){
							KorCllCdlDetailVO korCllCdlDetailVO = korCllCdlDetailVOs.get(i);
							KorCllCdlDetailVO korCllCdlDetailVO2 = new KorCllCdlDetailVO();

							if(tempCd2.equals(korCllCdlDetailVO.getPolCd())){
								if(!tempCd.equals(korCllCdlDetailVO.getPodCd())){

									korCllCdlDetailVO2.setCntrNo("A/POL : " + korCllCdlDetailVO.getPolCd() + "   A/POD : "
											+ korCllCdlDetailVO.getPodCd());

									if(i == 0){
										korCllCdlDetailVOs2.add(i, korCllCdlDetailVO2);
										totalCount++;
										for(int j = i; j < korCllCdlDetailVOs.size(); j++){
											korCllCdlDetailVOs2.add(j + totalCount, korCllCdlDetailVOs.get(j));
										}
									}else{
										korCllCdlDetailVOs2.set(i + totalCount, korCllCdlDetailVO2);

										for(int j = i + totalCount + 1; j - totalCount - 1 < korCllCdlDetailVOs.size(); j++){
											if(j >= korCllCdlDetailVOs2.size())
												korCllCdlDetailVOs2.add(j, korCllCdlDetailVOs.get(j - totalCount - 1));
											else
												korCllCdlDetailVOs2.set(j, korCllCdlDetailVOs.get(j - totalCount - 1));
										}
										totalCount++;
									}
									tempCd = korCllCdlDetailVO.getPodCd();
									tempCd2 = korCllCdlDetailVO.getPolCd();
								}
							}else{
								tempCd = "";
								if(!tempCd.equals(korCllCdlDetailVO.getPodCd())){

									korCllCdlDetailVO2.setCntrNo("A/POL : " + korCllCdlDetailVO.getPolCd() + "   A/POD : "
											+ korCllCdlDetailVO.getPodCd());

									if(i == 0){
										korCllCdlDetailVOs2.add(i, korCllCdlDetailVO2);
										totalCount++;
										for(int j = i; j < korCllCdlDetailVOs.size(); j++){
											korCllCdlDetailVOs2.add(j + totalCount, korCllCdlDetailVOs.get(j));
										}
									}else{
										korCllCdlDetailVOs2.set(i + totalCount, korCllCdlDetailVO2);

										for(int j = i + totalCount + 1; j - totalCount - 1 < korCllCdlDetailVOs.size(); j++){
											if(j >= korCllCdlDetailVOs2.size())
												korCllCdlDetailVOs2.add(j, korCllCdlDetailVOs.get(j - totalCount - 1));
											else
												korCllCdlDetailVOs2.set(j, korCllCdlDetailVOs.get(j - totalCount - 1));
										}
										totalCount++;
									}
									tempCd = korCllCdlDetailVO.getPodCd();
									tempCd2 = korCllCdlDetailVO.getPolCd();
								}
							}
						}
						korCllCdlDetailVOs = korCllCdlDetailVOs2;
					}
				}
			}else{
				korCllCdlDetailVOs = dbDao.searchCllCdlNoCntr(korCllCdlCondVO);
			}
			korCllCdlDetailContainerVO.setCLLCDLManifestVslSkdInfoVOs(cLLCDLManifestVslSkdInfoVOs);
			korCllCdlDetailContainerVO.setKorCllCdlDetailVO(korCllCdlDetailVOs);
			
			List<KorCllCdlDetailVO> lclList = new ArrayList<KorCllCdlDetailVO>();
			List<KorCllCdlDetailVO> sortCntrList = new ArrayList<KorCllCdlDetailVO>();
			sortCntrList.addAll(korCllCdlDetailVOs);
			
			Comparator<KorCllCdlDetailVO> comparator = new Comparator<KorCllCdlDetailVO>(){
				public int compare(KorCllCdlDetailVO vo1, KorCllCdlDetailVO vo2){
					return vo1.getCntrNo().compareTo(vo2.getCntrNo());
				}
			};
			Collections.sort(sortCntrList, comparator);
			String lclCntrNo = "";
			for(int i=0; i<sortCntrList.size(); i++){
				if(lclCntrNo.equals(sortCntrList.get(i).getCntrNo())){
					KorCllCdlDetailVO vo = new KorCllCdlDetailVO();
					vo.setCntrNo(sortCntrList.get(i).getCntrNo());
					vo.setIbflag("N");
					lclList.add(vo);
				}
				lclCntrNo = sortCntrList.get(i).getCntrNo();
			}
			korCllCdlDetailContainerVO.setLclKorCllCdlDetailVO(lclList);
			
			return korCllCdlDetailContainerVO;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다. <br>
	 * 
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @return List<CLLCDLManifestCllCdlForODCYVO>
	 * @exception EventException
	 */
	public List<CLLCDLManifestCllCdlForODCYVO> searchCllCdlForODCY(KorCllCdlCondVO korCllCdlCondVO) throws EventException{
		List<CLLCDLManifestCllCdlForODCYVO> cLLCDLManifestCllCdlForODCYVOs = null;
		try{
			cLLCDLManifestCllCdlForODCYVOs = dbDao.searchCllCdlForODCY(korCllCdlCondVO);
			
			return cLLCDLManifestCllCdlForODCYVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다. <br>
	 * 
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchMdmCntrTpSz() throws EventException{
		List<MdmCntrTpSzVO> mdmCntrTpSzVOs = null;
		try{
			//Terminal EDI Transmit 대상 Contanier Loading/Discharging List를 조회한다.
			mdmCntrTpSzVOs = dbDao.searchMdmCntrTpSz();

			return mdmCntrTpSzVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 터미널에 전송할 Container Loading List 정보를 조회한다.<br>
	 * 
	 * @param CllCondVO cllCondVO
	 * @return List<CllDetailVO>
	 * @exception EventException
	 */
	public List<CllDetailVO> searchCll(CllCondVO cllCondVO) throws EventException{
		try{
			List<CllDetailVO> cllDetailVOs = null;

			//Container Loading List(Korea) Data를 조회한다.

			cllDetailVOs = dbDao.searchCllList(cllCondVO.getInVvdCd(), cllCondVO.getInPolCd(),
					cllCondVO.getInLocalTs(), cllCondVO.getUpdUsrId(), cllCondVO.getInPolSplitNo(),cllCondVO.getCntrVgmOnly(),cllCondVO.getLocalType(), cllCondVO.getTsType());

			return cllDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 터미널에 전송할 Container Loading List - Danger Cargo 정보를 조회한다.<br>
	 * 
	 * @param CllSpclCondVO cllSpclCondVO
	 * @return List<CllDgCgoDetailVO>
	 * @exception EventException
	 */
	public List<CllDgCgoDetailVO> searchCllDgCgo(CllSpclCondVO cllSpclCondVO) throws EventException{
		try{
			List<CllDgCgoDetailVO> cllDgCgoDetailVOs = null;

			//Container Loading List - Danger Cargo Data를 조회한다.
			cllDgCgoDetailVOs = dbDao.searchCllDgCgo(cllSpclCondVO);

			return cllDgCgoDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry 및 Select
	 * 
	 * @programId ESM_BKG_1056 - search
	 * @param String entryTp
	 * @return List<KorCllSppDetailVO>
	 * @exception EventException
	 * @author Son Yun Seuk
	 */
	public List<KorCllSppDetailVO> searchKorCllSppList(String entryTp) throws EventException{
		List<KorCllSppDetailVO> list = null;

		try{
			if(entryTp == null)
				entryTp = "ALL";
			if("".equals(entryTp))
				entryTp = "ALL";
			//한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Select
			list = dbDao.searchKorCllSppList(entryTp);
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 조회한다.<br>
	 * 
	 * @param CllSpclCondVO cllSpclCondVO
	 * @return List<CllDgCgoDetailVO>
	 * @exception EventException
	 */
	public List<CllRfAkCgoDetailVO> searchCllRfAkCgo(CllSpclCondVO cllSpclCondVO) throws EventException{
		try{
			List<CllRfAkCgoDetailVO> cllRfAkCgoDetailVOs = null;

			//Container Loading List - Reefer, Awkward Cargo Data를 조회한다.
			cllRfAkCgoDetailVOs = dbDao.searchCllRfAkCgo(cllSpclCondVO);

			return cllRfAkCgoDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Container Discharging List EDI 전송을 위한 Terminal Yard Code, EDI Receiver ID, EDI Sender ID를 조회한다. <br>
	 * 
	 * @param String inPortCd
	 * @param String inListType
	 * @return List<CLLCDLManifestEdiTerminalInfoVO>
	 * @exception EventException
	 */
	public List<CLLCDLManifestEdiTerminalInfoVO> searchEdiTerminal(String inPortCd, String inListType) throws EventException{
		try{
			List<CLLCDLManifestEdiTerminalInfoVO> cLLCDLManifestEdiTerminalInfoVOs = null;
			//Container Discharging List EDI 전송을 위한 Termial Yard Code, EDI Receiver ID, EDI Sender ID를 조회한다.
			cLLCDLManifestEdiTerminalInfoVOs = dbDao.searchEdiTerminal(inPortCd.substring(0, 2), inListType);

			return cLLCDLManifestEdiTerminalInfoVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Container Discharging List 정보를 조회한다.<br>
	 * 
	 * @param CdlCondVO cdlCondVO
	 * @return List<CdlDetailVO>
	 * @exception EventException
	 */
	public List<CdlDetailVO> searchCdl(CdlCondVO cdlCondVO) throws EventException{
		try{
			List<CdlDetailVO> cdlDetailVOs = null;
			//Container Discharging List 정보를 조회한다.
			cdlDetailVOs = dbDao.searchCdlList(cdlCondVO);

			return cdlDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param CllCdlCheckCondVO cllCdlCheckCondVO
	 * @return List<CllCdlCheckListDetailVO>
	 * @exception EventException
	 */
	public List<CllCdlCheckListDetailVO> searchCllCdlCheckList(CllCdlCheckCondVO cllCdlCheckCondVO)
			throws EventException{
		try{
			List<CllCdlCheckListDetailVO> cllCdlCheckListDetailVOs = null;
			//CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 NIS 데이터를 조회한다.
			cllCdlCheckListDetailVOs = dbDao.searchCllCdlCheckList(cllCdlCheckCondVO);

			return cllCdlCheckListDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Booking 메인에서 Import 전송을 위한 조회<br>
	 * 
	 * @param String bkgNo
	 * @return List<CntrListForImportDetailVO>
	 * @exception EventException
	 */
	public List<CntrListForImportDetailVO> searchCntrListForImport(String bkgNo)
			throws EventException{
		try{
			List<CntrListForImportDetailVO> cntrListForImportDetailVOs = null;
			//CLL, CDL 테이블에 저장되어 있는 데이터와 비교할 NIS 데이터를 조회한다.
			cntrListForImportDetailVOs = dbDao.searchCntrListForImport(bkgNo);

			return cntrListForImportDetailVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVO(String key) throws EventException{
		DBRowSet rowSet;
		try{
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return(String) rowSet.getObject("jb_sts_flg");
		}catch(BackEndJobException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(SQLException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(InterruptedException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 터미널에 전송할 Container Loading List(Korea) 정보를 수정한다..<br>
	 * 
	 * @param KorCllModifyVO[] korCllModifyVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageKorCll(KorCllModifyVO[] korCllModifyVOs, SignOnUserAccount account) throws EventException{
		String inVslCd = "";
		String inSkdVoyNo = "";
		String inSkdDirCd = "";
		String inPolCd = "";
		String inPolYdCd = "";
		String inCllType = "";
		String inKtmlCd = "";  

		try{
			if(korCllModifyVOs.length > 0){
				inVslCd = korCllModifyVOs[0].getInVvdCd().substring(0, 4);
				inSkdVoyNo = korCllModifyVOs[0].getInVvdCd().substring(4, 8);
				inSkdDirCd = korCllModifyVOs[0].getInVvdCd().substring(8);
				inPolCd = korCllModifyVOs[0].getInPolCd();
				inPolYdCd = korCllModifyVOs[0].getInPolYdCd();
				inCllType = korCllModifyVOs[0].getInCllType();
				inKtmlCd = korCllModifyVOs[0].getInKtmlCd();

				//Container Loading List(Korea) Data를 삭제한다.
				dbDao.removeKorCll(inVslCd, inSkdVoyNo, inSkdDirCd, inPolCd, inPolYdCd, inCllType);

				for(int i = 0; i < korCllModifyVOs.length; i++){ 

					if(!korCllModifyVOs[i].getCntrTpszCd().equals("") && korCllModifyVOs[i].getCntrTpszCd() != null){
						if(!korCllModifyVOs[i].getTsVvdCd().equals("") && korCllModifyVOs[i].getTsVvdCd() != null){
							korCllModifyVOs[i].setTsVslCd(korCllModifyVOs[i].getTsVvdCd().substring(0, 4));
							korCllModifyVOs[i].setTsSkdVoyNo(korCllModifyVOs[i].getTsVvdCd().substring(4, 8));
							korCllModifyVOs[i].setTsSkdDirCd(korCllModifyVOs[i].getTsVvdCd().substring(8));
						}
						if(korCllModifyVOs[i].getRcvTermCd().length() == 2){
							korCllModifyVOs[i].setDeTermCd(korCllModifyVOs[i].getRcvTermCd().substring(1));
							korCllModifyVOs[i].setRcvTermCd(korCllModifyVOs[i].getRcvTermCd().substring(0, 1));
						}
						korCllModifyVOs[i].setCreUsrId(account.getUsr_id());
						String cntrListNo = inVslCd + inSkdVoyNo.substring(1, 4) + inSkdDirCd + inPolCd.substring(2);
						korCllModifyVOs[i].setCntrListNo(cntrListNo);
						
						if(!korCllModifyVOs[i].getIbflag().equals("D"))
							dbDao.addKorCll(korCllModifyVOs[i]);//Container Loading List(Korea) Data를 생성한다.
					}
				}

				//Container Loading List(Korea) 관련 터미널 Vessel Code를 수정한다.
				if(dbDao.modifyTmnlVslCd(inVslCd, inKtmlCd, account.getUsr_id()) == 0){
					//Container Loading List(Korea) 관련 터미널 Vessel Code를 생성한다.
					dbDao.addTmnlVslCd(inVslCd, inKtmlCd, account.getUsr_id());
				}

			}
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * VVD가 출항전에 Container Loading List를 각 Port의 Terminal에 전송하기 위해, 전송 전 자체 Table에 대상 데이터를 저장한다.<br>
	 * 
	 * @param TerminalCllVO[] terminalCllVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCllForDownload(TerminalCllVO[] terminalCllVOs, SignOnUserAccount account) throws EventException{
		String inWGT = "";

		List<CLLCDLManifestEtaEtdInfoVO> cLLCDLManifestEtaEtdInfoVOs = null;
		List<CLLCDLManifestTbnTbxInfoVO> cLLCDLManifestTbnTbxInfoVOs = null;
		List<CLLCDLManifestBkgQtyByCntrtsInfoVO> cLLCDLManifestBkgQtyByCntrtsInfoVOs = null;
		List<CLLCDLManifestCllDgByCntrUnInfoVO> cLLCDLManifestCllDgByCntrUnInfoVOs = null;
		try{
			if(terminalCllVOs.length > 0){
				TerminalCllVO searchTerminalCllVO = terminalCllVOs[0];

				//Container Loading List 데이터 다운로드 관련 POL ETA, ETD 를 조회한다.
				cLLCDLManifestEtaEtdInfoVOs = dbDao.searchEtaEtd(searchTerminalCllVO);

				searchTerminalCllVO.setInUsrId(account.getUsr_id());
				//Container Loading List 데이터 다운로드 수행 전에 기존에 저장되어 있던 CLL Danger Cargo 데이터를 삭제한다.
				dbDao.removeCllDgForDownload(searchTerminalCllVO);
				//Container Loading List 데이터 다운로드 수행 전에 기존에 저장되어 있던 CLL Main 데이터를 삭제한다.
				dbDao.removeCllMainForDownload(searchTerminalCllVO);

				for(int i = 0; i < terminalCllVOs.length; i++){
					TerminalCllVO terminalCllVO = terminalCllVOs[i];

					if(!terminalCllVO.getBkgNo().equals("") && terminalCllVO.getBkgNo() != null){
						//Container Loading List 데이터 다운로드를 위한 TBN, TBX를 구한다.
						cLLCDLManifestTbnTbxInfoVOs = dbDao.searchTbnTbx();
						//Container Loading List 데이터 다운로드를 위한 컨테이너 Weight 정보를 구한다.
						cLLCDLManifestBkgQtyByCntrtsInfoVOs = dbDao.searchBkgQtyByCntrts(terminalCllVO);

						if(cLLCDLManifestBkgQtyByCntrtsInfoVOs.size() > 0){
							terminalCllVO.setInTeu(cLLCDLManifestBkgQtyByCntrtsInfoVOs.get(0).getInTeu());
							terminalCllVO.setInFeu(cLLCDLManifestBkgQtyByCntrtsInfoVOs.get(0).getInFeu());
							terminalCllVO.setInQty(cLLCDLManifestBkgQtyByCntrtsInfoVOs.get(0).getInQty());
						}

						//Container Loading List 데이터 다운로드를 위한 컨테이너 Weight 정보를 구한다.
						inWGT = dbDao.searchCntrWgt(terminalCllVO);

						if(inWGT.length() > 5){
							throw new EventException(new ErrorHandler("BKG06119", new String[]{terminalCllVO.getBkgNo()}).getMessage());
						}

						if(cLLCDLManifestEtaEtdInfoVOs.size() > 0){
							terminalCllVO.setVpsEtaDt(cLLCDLManifestEtaEtdInfoVOs.get(0).getVpsEtaDt());
							terminalCllVO.setVpsEtdDt(cLLCDLManifestEtaEtdInfoVOs.get(0).getVpsEtdDt());
						}
						if(cLLCDLManifestTbnTbxInfoVOs.size() > 0){
							terminalCllVO.setTbxSeq(cLLCDLManifestTbnTbxInfoVOs.get(0).getTbxSeq());
							terminalCllVO.setTbnSeq(cLLCDLManifestTbnTbxInfoVOs.get(0).getTbnSeq());
						}
						terminalCllVO.setCntrTpszCd(terminalCllVO.getCntrTpszCd());
						
						terminalCllVO.setInVvdCd(searchTerminalCllVO.getInVvdCd());
						terminalCllVO.setInPolCd(searchTerminalCllVO.getInPolCd());
						terminalCllVO.setInPolTs(searchTerminalCllVO.getInPolTs());
						terminalCllVO.setInUsrId(account.getUsr_id());
						terminalCllVO.setPolSplitNo(searchTerminalCllVO.getPolSplitNo());  // Add. 2015.02.09. CHM-201533845
						
						//Container Loading List 전송을 위한 Data를 CLL 테이블로 Download 한다.
						dbDao.addCllMainForDownload(terminalCllVO);

						//Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.
						cLLCDLManifestCllDgByCntrUnInfoVOs = dbDao.searchCllDgByCntrUn(terminalCllVO);

						for(int j = 0; j < cLLCDLManifestCllDgByCntrUnInfoVOs.size(); j++){
							CLLCDLManifestCllDgByCntrUnInfoVO cLLCDLManifestCllDgByCntrUnInfoVO = cLLCDLManifestCllDgByCntrUnInfoVOs
									.get(j);

							BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO = new BkgCstmsTmlCllDgCgoVO();
							bkgCstmsTmlCllDgCgoVO.setVslCd(searchTerminalCllVO.getInVvdCd().substring(0, 4));
							bkgCstmsTmlCllDgCgoVO.setSkdVoyNo(searchTerminalCllVO.getInVvdCd().substring(4, 8));
							bkgCstmsTmlCllDgCgoVO.setSkdDirCd(searchTerminalCllVO.getInVvdCd().substring(8));
							bkgCstmsTmlCllDgCgoVO.setPortCd(searchTerminalCllVO.getInPolCd());
							bkgCstmsTmlCllDgCgoVO.setBkgNo(terminalCllVO.getBkgNo());
							bkgCstmsTmlCllDgCgoVO.setClptIndSeq(searchTerminalCllVO.getPolSplitNo());  // Add. 2015.02.09. CHM-201533845
							
							String tbxSeq = "";
							String tbnSeq = "";
							if(cLLCDLManifestTbnTbxInfoVOs.size() > 0){
								tbxSeq = cLLCDLManifestTbnTbxInfoVOs.get(0).getTbxSeq();
								tbnSeq = cLLCDLManifestTbnTbxInfoVOs.get(0).getTbnSeq();
							}
							if(terminalCllVO.getCntrNo().indexOf("T.B.N.") != -1)
								bkgCstmsTmlCllDgCgoVO.setCntrNo(tbxSeq);
							else
								bkgCstmsTmlCllDgCgoVO.setCntrNo(terminalCllVO.getCntrNo());

							bkgCstmsTmlCllDgCgoVO.setCllDgSeq(j + "");
							bkgCstmsTmlCllDgCgoVO.setImdgUnNo(cLLCDLManifestCllDgByCntrUnInfoVO.getImdgUnNo().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setImdgClssCd(cLLCDLManifestCllDgByCntrUnInfoVO.getImdgClssCd().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setDgDesc(cLLCDLManifestCllDgByCntrUnInfoVO.getPrpShpNm().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setEmerCntcPhnNo(cLLCDLManifestCllDgByCntrUnInfoVO
									.getEmerCntcPhnNoCtnt().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setImdgPgNo(cLLCDLManifestCllDgByCntrUnInfoVO.getImdgPgNo().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setDgRmk(cLLCDLManifestCllDgByCntrUnInfoVO.getDiffRmk().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setEmerPrcNo(cLLCDLManifestCllDgByCntrUnInfoVO.getEmsNo().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setDgPckGrpCd(cLLCDLManifestCllDgByCntrUnInfoVO.getImdgPckGrpCd().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setPolutFlg(cLLCDLManifestCllDgByCntrUnInfoVO.getMrnPolutFlg().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setDgLblCd(cLLCDLManifestCllDgByCntrUnInfoVO.getImdgSubsRskLblCd().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setPckQty(cLLCDLManifestCllDgByCntrUnInfoVO.getPckQty().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setTmlPckUtId(cLLCDLManifestCllDgByCntrUnInfoVO.getTmlPckUtId().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setNetWgt(cLLCDLManifestCllDgByCntrUnInfoVO.getNetWgt().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setNetWgtUtCd(cLLCDLManifestCllDgByCntrUnInfoVO.getNetWgtCd().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setGrsCntrWgt(cLLCDLManifestCllDgByCntrUnInfoVO.getGrsWgt().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setGrsWgtUtCd(cLLCDLManifestCllDgByCntrUnInfoVO.getGrsWgtCd().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setMeasQty(cLLCDLManifestCllDgByCntrUnInfoVO.getMeasQty().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setMeasUtCd(cLLCDLManifestCllDgByCntrUnInfoVO.getMeasQtyCd().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setHzdCtnt(cLLCDLManifestCllDgByCntrUnInfoVO.getHzdDesc().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setStwgDesc(cLLCDLManifestCllDgByCntrUnInfoVO.getSpclStwgRqstDesc().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setDgCntrSeq(cLLCDLManifestCllDgByCntrUnInfoVO.getDgCntrSeq().replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setCntrLodgNo(tbnSeq.replace("'", "''"));
							bkgCstmsTmlCllDgCgoVO.setCreUsrId(account.getUsr_id());
							//Container Loading List(Korea) Special Stowage Request POD 정보를 조회한다.
							dbDao.addCllDgForDownload(bkgCstmsTmlCllDgCgoVO);
						}
						/****************************************************************************************************/
						// 2012.09.12 - RF, AWK CGO - CNTR No가 존재하지 않는 경우에 Type Size가 동일한 것에 매칭시켜 Update 하도록 함.
						// 윤여진대리 요청으로 수정 [CHM-201220078] - [COPRAR EDI] CNTR# 없는 Case- Special Cargo정보 매칭 처리
						/****************************************************************************************************/
						CllSpclCondVO cllSpclCondVO = new CllSpclCondVO();
						cllSpclCondVO.setInVslCd(searchTerminalCllVO.getInVvdCd().substring(0, 4));
						cllSpclCondVO.setInSkdVoyNo(searchTerminalCllVO.getInVvdCd().substring(4, 8));
						cllSpclCondVO.setInSkdDirCd(searchTerminalCllVO.getInVvdCd().substring(8));
						cllSpclCondVO.setInPortCd(searchTerminalCllVO.getInPolCd());
						cllSpclCondVO.setPolSplitNo(searchTerminalCllVO.getPolSplitNo());  // Add. 2015.02.09. CHM-201533845
						cllSpclCondVO.setInBkgNo(terminalCllVO.getBkgNo());
						String cntrLodgNo = "";
						if(cLLCDLManifestTbnTbxInfoVOs.size() > 0){
							cntrLodgNo = cLLCDLManifestTbnTbxInfoVOs.get(0).getTbnSeq();
						}
						cllSpclCondVO.setInCntrLodgNo(cntrLodgNo.replace("'", "''"));
						if(terminalCllVO.getCntrNo().indexOf("T.B.N.") != -1)
							cllSpclCondVO.setInCntrNo(terminalCllVO.getTbxSeq());
						else
							cllSpclCondVO.setInCntrNo(terminalCllVO.getCntrNo());
						
						List<CllRfAkCgoDetailVO> cllRfAkCgoDetailVOs = null;

						//Container Loading List - Reefer, Awkward Cargo Data를 조회한다.
						cllRfAkCgoDetailVOs = dbDao.searchCllRfAkCgo(cllSpclCondVO);
						
						List<CllRfAkCgoDetailVO> cllRfAkCgoDetailVORs = null;
						List<CllRfAkCgoDetailVO> cllRfAkCgoDetailVOAs = null;
						
						for(int ra = 0; ra < cllRfAkCgoDetailVOs.size(); ra++){
							CllRfAkCgoDetailVO cllRfAkCgoDetailVO = cllRfAkCgoDetailVOs.get(ra);
							
							cllRfAkCgoDetailVO.setClptIndSeq(searchTerminalCllVO.getPolSplitNo());  // Add. 2015.02.09. CHM-201533845
							
							cllRfAkCgoDetailVORs = null;
							cllRfAkCgoDetailVOAs = null;
							
							cllRfAkCgoDetailVORs = dbDao.searchCllBkgRfCgo(cllRfAkCgoDetailVO);
							
							if ( cllRfAkCgoDetailVORs.size() > 0 ){
								cllRfAkCgoDetailVO.setRcSeq(cllRfAkCgoDetailVORs.get(0).getRcSeq());
								cllRfAkCgoDetailVO.setFdoTemp(cllRfAkCgoDetailVORs.get(0).getFdoTemp());
								cllRfAkCgoDetailVO.setCdoTemp(cllRfAkCgoDetailVORs.get(0).getCdoTemp());
								cllRfAkCgoDetailVO.setCntrVentRto(cllRfAkCgoDetailVORs.get(0).getCntrVentRto());
							}

							cllRfAkCgoDetailVOAs = dbDao.searchCllBkgAkCgo(cllRfAkCgoDetailVO);

							if ( cllRfAkCgoDetailVOAs.size() > 0 ){
								cllRfAkCgoDetailVO.setAwkCgoSeq(cllRfAkCgoDetailVOAs.get(0).getAwkCgoSeq());
								cllRfAkCgoDetailVO.setOvrFwrdLen(cllRfAkCgoDetailVOAs.get(0).getOvrFwrdLen());
								cllRfAkCgoDetailVO.setOvrBkwdLen(cllRfAkCgoDetailVOAs.get(0).getOvrBkwdLen());
								cllRfAkCgoDetailVO.setOvrHgt(cllRfAkCgoDetailVOAs.get(0).getOvrHgt());
								cllRfAkCgoDetailVO.setOvrPortLen(cllRfAkCgoDetailVOAs.get(0).getOvrPortLen());
								cllRfAkCgoDetailVO.setOvrSdLen(cllRfAkCgoDetailVOAs.get(0).getOvrSdLen());
								cllRfAkCgoDetailVO.setOvrWgtUtCd(cllRfAkCgoDetailVOAs.get(0).getOvrWgtUtCd());
								cllRfAkCgoDetailVO.setOvrCntrWgt(cllRfAkCgoDetailVOAs.get(0).getOvrCntrWgt());
							}
							
							//Container Loading List - Reefer, Awkward Cargo Data를 업데이트 한다.
							dbDao.modifyCllRfAkCgoFlag(cllRfAkCgoDetailVO);
						}
						/****************************************************************************************************/
					}
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 터미널에 전송할 Container Loading List(Korea) Remark 정보를 수정한다.<br>
	 * 
	 * @param KorCllRemarkVO korCllRemarkVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageKorCllRemark(KorCllRemarkVO korCllRemarkVO, SignOnUserAccount account) throws EventException{
		String cntrListNo = "";

		try{
			cntrListNo = korCllRemarkVO.getInVvdCd().substring(0, 4) + korCllRemarkVO.getInVvdCd().substring(5, 8)
					+ korCllRemarkVO.getInVvdCd().substring(8) + korCllRemarkVO.getInPolCd().substring(2);
			korCllRemarkVO.setCntrListNo(cntrListNo);
			korCllRemarkVO.setCreUsrId(account.getUsr_id());
			korCllRemarkVO.setUpdUsrId(account.getUsr_id());

			korCllRemarkVO.setKrTmlRmkTpId("TO");
			korCllRemarkVO.setDiffRmk(korCllRemarkVO.getSetTo());
			if(dbDao.modifyKorCllRemark(korCllRemarkVO) == 0)//Container Loading List(Korea) Remark Data를 수정한다.
				dbDao.addKorCllRemark(korCllRemarkVO);//Container Loading List(Korea) Remark Data를 생성한다.

			korCllRemarkVO.setKrTmlRmkTpId("FM");
			korCllRemarkVO.setDiffRmk(korCllRemarkVO.getSetFm());
			if(dbDao.modifyKorCllRemark(korCllRemarkVO) == 0)//Container Loading List(Korea) Remark Data를 수정한다.
				dbDao.addKorCllRemark(korCllRemarkVO);//Container Loading List(Korea) Remark Data를 생성한다.

			korCllRemarkVO.setKrTmlRmkTpId("RMK");
			korCllRemarkVO.setDiffRmk(korCllRemarkVO.getRemark());
			if(dbDao.modifyKorCllRemark(korCllRemarkVO) == 0)//Container Loading List(Korea) Remark Data를 수정한다.
				dbDao.addKorCllRemark(korCllRemarkVO);//Container Loading List(Korea) Remark Data를 생성한다.
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 터미널에 전송할 Container Loading List 정보를 수정한다.<br>
	 * 
	 * @param CllDetailVO[] cllDetailVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCll(CllDetailVO[] cllDetailVOs, SignOnUserAccount account) throws EventException{
		String inVvdCd = "";
		String inPolCd = "";
		String updUsrId = "";
		String inPolSplitNo = "";  // Add. 2015.02.09
		
		List<CLLCDLManifestCntrInfoVO> cLLCDLManifestCntrInfoVOs = null;
		try{
			if(cllDetailVOs.length > 0){
				inVvdCd = cllDetailVOs[0].getInVvdCd();
				inPolCd = cllDetailVOs[0].getInPolCd();
				updUsrId = cllDetailVOs[0].getUpdUsrId();
				inPolSplitNo = cllDetailVOs[0].getInPolSplitNo();  // Add. 2015.02.09
			}
			for(int i = 0; i < cllDetailVOs.length; i++){
				CllDetailVO cllDetailVO = cllDetailVOs[i];

				if(cllDetailVOs[i].getIbflag().equals("I")){
					//Container Loading List(Korea) Data를 조회한다.
					cLLCDLManifestCntrInfoVOs = dbDao.searchCntrInfo(cllDetailVO.getBkgNo2(), cllDetailVO.getCntrNo(),
							cllDetailVO.getPolCd(), cllDetailVO.getPodCd());
					BkgCstmsTmlCllVO bkgCstmsTmlCllVO = new BkgCstmsTmlCllVO();
					CLLCDLManifestCntrInfoVO cLLCDLManifestCntrInfoVO = new CLLCDLManifestCntrInfoVO();

					if(cLLCDLManifestCntrInfoVOs.size() > 0)
						cLLCDLManifestCntrInfoVO = cLLCDLManifestCntrInfoVOs.get(0);
					bkgCstmsTmlCllVO.setTrnkVvdId(cLLCDLManifestCntrInfoVO.getTrnkVvdId());
					bkgCstmsTmlCllVO.setCfmFlg(cllDetailVO.getCfmFlg());
					bkgCstmsTmlCllVO.setTeuCntrQty(cllDetailVO.getTeuCntrQty());
					bkgCstmsTmlCllVO.setFeuCntrQty(cllDetailVO.getFeuCntrQty());
					bkgCstmsTmlCllVO.setRcFlg(cllDetailVO.getRcFlg());
					bkgCstmsTmlCllVO.setDcgoFlg(cllDetailVO.getDcgoFlg());
					bkgCstmsTmlCllVO.setAwkCgoFlg(cllDetailVO.getAwkCgoFlg());
					bkgCstmsTmlCllVO.setBbCgoFlg(cllDetailVO.getBbCgoFlg());
					bkgCstmsTmlCllVO.setRdCgoFlg(cllDetailVO.getRdCgoFlg());
					bkgCstmsTmlCllVO.setBlRmk(cLLCDLManifestCntrInfoVO.getBlRmk());
					bkgCstmsTmlCllVO.setCreUsrId(updUsrId);
					bkgCstmsTmlCllVO.setUpdUsrId(updUsrId);
					bkgCstmsTmlCllVO.setVslCd(inVvdCd.substring(0, 4));
					bkgCstmsTmlCllVO.setSkdVoyNo(inVvdCd.substring(4, 8));
					bkgCstmsTmlCllVO.setSkdDirCd(inVvdCd.substring(8));
					bkgCstmsTmlCllVO.setPortCd(inPolCd);
					bkgCstmsTmlCllVO.setClptIndSeq(inPolSplitNo);  // Add. 2015.02.09
					bkgCstmsTmlCllVO.setBkgNo(cllDetailVO.getBkgNo2());
					bkgCstmsTmlCllVO.setCntrNo(cllDetailVO.getCntrNo());
					bkgCstmsTmlCllVO.setCntrLodgNo(cllDetailVO.getCntrLodgNo());
					bkgCstmsTmlCllVO.setEtaDt(cllDetailVO.getEtaDt());
					bkgCstmsTmlCllVO.setEtdDt(cllDetailVO.getEtdDt());
					bkgCstmsTmlCllVO.setBlNo(cLLCDLManifestCntrInfoVO.getBlNo());
					bkgCstmsTmlCllVO.setBlTpCd(cLLCDLManifestCntrInfoVO.getBlTpCd());
					bkgCstmsTmlCllVO.setPorCd(cllDetailVO.getPorCd());
					bkgCstmsTmlCllVO.setPolCd(cllDetailVO.getPolCd());
					bkgCstmsTmlCllVO.setPodCd(cllDetailVO.getPodCd());
					bkgCstmsTmlCllVO.setDelCd(cllDetailVO.getDelCd());
					bkgCstmsTmlCllVO.setShprCntCd(cLLCDLManifestCntrInfoVO.getShprCntCd());
					bkgCstmsTmlCllVO.setShprSeq(cLLCDLManifestCntrInfoVO.getShprSeq());
					bkgCstmsTmlCllVO.setShprNm1(cLLCDLManifestCntrInfoVO.getShprNm1());
					bkgCstmsTmlCllVO.setShprNm2(cLLCDLManifestCntrInfoVO.getShprNm2());
					bkgCstmsTmlCllVO.setShprNm3(cLLCDLManifestCntrInfoVO.getShprNm3());
					bkgCstmsTmlCllVO.setShprNm4(cLLCDLManifestCntrInfoVO.getShprNm4());
					bkgCstmsTmlCllVO.setShprNm5(cLLCDLManifestCntrInfoVO.getShprNm5());
					bkgCstmsTmlCllVO.setCneeCntCd(cLLCDLManifestCntrInfoVO.getCneeCntCd());
					bkgCstmsTmlCllVO.setCneeSeq(cLLCDLManifestCntrInfoVO.getCneeSeq());
					bkgCstmsTmlCllVO.setCneeNm1(cLLCDLManifestCntrInfoVO.getCneeNm1());
					bkgCstmsTmlCllVO.setCneeNm2(cLLCDLManifestCntrInfoVO.getCneeNm2());
					bkgCstmsTmlCllVO.setCneeNm3(cLLCDLManifestCntrInfoVO.getCneeNm3());
					bkgCstmsTmlCllVO.setCneeNm4(cLLCDLManifestCntrInfoVO.getCneeNm4());
					bkgCstmsTmlCllVO.setCneeNm5(cLLCDLManifestCntrInfoVO.getCneeNm5());
					bkgCstmsTmlCllVO.setNtfyCntCd(cLLCDLManifestCntrInfoVO.getNtfyCntCd());
					bkgCstmsTmlCllVO.setNtfySeq(cLLCDLManifestCntrInfoVO.getNtfySeq());
					bkgCstmsTmlCllVO.setNtfyNm1(cLLCDLManifestCntrInfoVO.getNtfyNm1());
					bkgCstmsTmlCllVO.setNtfyNm2(cLLCDLManifestCntrInfoVO.getNtfyNm2());
					bkgCstmsTmlCllVO.setNtfyNm3(cLLCDLManifestCntrInfoVO.getNtfyNm3());
					bkgCstmsTmlCllVO.setNtfyNm4(cLLCDLManifestCntrInfoVO.getNtfyNm4());
					bkgCstmsTmlCllVO.setNtfyNm5(cLLCDLManifestCntrInfoVO.getNtfyNm5());
					bkgCstmsTmlCllVO.setAntfyCntCd(cLLCDLManifestCntrInfoVO.getAntfyCntCd());
					bkgCstmsTmlCllVO.setAntfySeq(cLLCDLManifestCntrInfoVO.getAntfySeq());
					bkgCstmsTmlCllVO.setAntfyNm1(cLLCDLManifestCntrInfoVO.getAntfyNm1());
					bkgCstmsTmlCllVO.setAntfyNm2(cLLCDLManifestCntrInfoVO.getAntfyNm2());
					bkgCstmsTmlCllVO.setAntfyNm3(cLLCDLManifestCntrInfoVO.getAntfyNm3());
					bkgCstmsTmlCllVO.setAntfyNm4(cLLCDLManifestCntrInfoVO.getAntfyNm4());
					bkgCstmsTmlCllVO.setAntfyNm5(cLLCDLManifestCntrInfoVO.getAntfyNm5());
					bkgCstmsTmlCllVO.setFfCntCd(cLLCDLManifestCntrInfoVO.getFfCntCd());
					bkgCstmsTmlCllVO.setFfCustSeq(cLLCDLManifestCntrInfoVO.getFfCustSeq());
					bkgCstmsTmlCllVO.setFfNm1(cLLCDLManifestCntrInfoVO.getFfNm1());
					bkgCstmsTmlCllVO.setFfNm2(cLLCDLManifestCntrInfoVO.getFfNm2());
					bkgCstmsTmlCllVO.setFfNm3(cLLCDLManifestCntrInfoVO.getFfNm3());
					bkgCstmsTmlCllVO.setFfNm4(cLLCDLManifestCntrInfoVO.getFfNm4());
					bkgCstmsTmlCllVO.setFfNm5(cLLCDLManifestCntrInfoVO.getFfNm5());
					bkgCstmsTmlCllVO.setCntrTpszCd(cllDetailVO.getCntrTpszCd());
					bkgCstmsTmlCllVO.setSocFlg(cllDetailVO.getSocFlg());
					bkgCstmsTmlCllVO.setFullMtyCd(cllDetailVO.getFullMtyCd());
					if(cllDetailVO.getRcvDeTermCd().length() == 2){
						bkgCstmsTmlCllVO.setRcvTermCd(cllDetailVO.getRcvDeTermCd().substring(0, 1));
						bkgCstmsTmlCllVO.setDeTermCd(cllDetailVO.getRcvDeTermCd().substring(1));
					}
					bkgCstmsTmlCllVO.setPckQty(cllDetailVO.getPckQty());
					bkgCstmsTmlCllVO.setPckTpCd(cllDetailVO.getPckTpCd());
					bkgCstmsTmlCllVO.setCntrWgt(cllDetailVO.getCntrWgt());
					bkgCstmsTmlCllVO.setWgtTpCd(cllDetailVO.getWgtTpCd());
					bkgCstmsTmlCllVO.setGrsCntrWgt(cllDetailVO.getGrsCntrWgt());
					bkgCstmsTmlCllVO.setGrsWgtUtCd(cllDetailVO.getGrsWgtUtCd());
					bkgCstmsTmlCllVO.setMeasQty(cllDetailVO.getMeasQty());
					bkgCstmsTmlCllVO.setCntrMeasUtCd(cllDetailVO.getCntrMeasUtCd());
					bkgCstmsTmlCllVO.setOvrFwrdLen(cllDetailVO.getOvrFwrdLen());
					bkgCstmsTmlCllVO.setOvrBkwdLen(cllDetailVO.getOvrBkwdLen());
					bkgCstmsTmlCllVO.setOvrHgt(cllDetailVO.getOvrHgt());
					bkgCstmsTmlCllVO.setOvrPortLen(cllDetailVO.getOvrPortLen());
					bkgCstmsTmlCllVO.setOvrSdLen(cllDetailVO.getOvrSdLen());
					bkgCstmsTmlCllVO.setOvrWgtUtCd(cllDetailVO.getOvrWgtUtCd());
					bkgCstmsTmlCllVO.setOvrCntrWgt(cllDetailVO.getOvrCntrWgt());
					bkgCstmsTmlCllVO.setFdoTemp(cllDetailVO.getFdoTemp());
					bkgCstmsTmlCllVO.setCdoTemp(cllDetailVO.getCdoTemp());
					bkgCstmsTmlCllVO.setCntrVentRto(cllDetailVO.getCntrVentRto());
					bkgCstmsTmlCllVO.setCntrSealNo(cllDetailVO.getCntrSealNo());
					bkgCstmsTmlCllVO.setTsCgoCd(cllDetailVO.getTsCgoCd());
					bkgCstmsTmlCllVO.setTareCntrWgt(cLLCDLManifestCntrInfoVO.getTareCntrWgt());
					bkgCstmsTmlCllVO.setTsVvdId(cLLCDLManifestCntrInfoVO.getTsVvdId());
					bkgCstmsTmlCllVO.setTsPolCd(cLLCDLManifestCntrInfoVO.getPolCd());
					bkgCstmsTmlCllVO.setTsPodCd(cLLCDLManifestCntrInfoVO.getPodCd());
					bkgCstmsTmlCllVO.setCmdtCd(cLLCDLManifestCntrInfoVO.getCmdtCd());
					bkgCstmsTmlCllVO.setCmdtDesc(cLLCDLManifestCntrInfoVO.getCmdtNm());
					bkgCstmsTmlCllVO.setRepCmdtCd(cLLCDLManifestCntrInfoVO.getRepCmdtCd());
					bkgCstmsTmlCllVO.setRepCmdtDesc(cLLCDLManifestCntrInfoVO.getRepCmdtNm());

					//Container Loading List Data를 생성한다.
					dbDao.addCll(bkgCstmsTmlCllVO);
				}else if(cllDetailVOs[i].getIbflag().equals("U")){
					cllDetailVO.setInVvdCd(inVvdCd);
					cllDetailVO.setInPolCd(inPolCd);
					cllDetailVO.setUpdUsrId(updUsrId);
					cllDetailVO.setInPolSplitNo(inPolSplitNo);  // Add. 2015.02.09

					//Container Loading List Data를 업데이트 한다.
					dbDao.modifyCll(cllDetailVO);
				}else if(cllDetailVOs[i].getIbflag().equals("D")){
					//Container Loading List Data(Danger Cargo)를 삭제한다.
					dbDao.removeCllDg(inVvdCd, inPolCd, cllDetailVO.getBkgNo2(), cllDetailVO.getCntrNo(), updUsrId, inPolSplitNo);
					//Container Loading List Data를 삭제한다.
					dbDao.removeCllMain(inVvdCd, inPolCd, cllDetailVO.getBkgNo2(), cllDetailVO.getCntrNo(), updUsrId, inPolSplitNo);
				}
			}
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 터미널에 전송할 Container Loading List - Danger Cargo 정보를 수정한다.<br>
	 * 
	 * @param BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCllDgCgo(BkgCstmsTmlCllDgCgoVO[] bkgCstmsTmlCllDgCgoVOs, SignOnUserAccount account)
			throws EventException{
		try{
			if(bkgCstmsTmlCllDgCgoVOs.length > 0)
				dbDao.removeCllDgGgo(bkgCstmsTmlCllDgCgoVOs[0]);//Container Loading List - Danger Cargo Data를 삭제한다.

			if(bkgCstmsTmlCllDgCgoVOs.length != 1 || !bkgCstmsTmlCllDgCgoVOs[0].getCllDgSeq().equals("0")){
				for(int i = 0; i < bkgCstmsTmlCllDgCgoVOs.length; i++){
					BkgCstmsTmlCllDgCgoVO bkgCstmsTmlCllDgCgoVO = bkgCstmsTmlCllDgCgoVOs[i];
					bkgCstmsTmlCllDgCgoVO.setCreUsrId(account.getUsr_id());
					bkgCstmsTmlCllDgCgoVO.setUpdUsrId(account.getUsr_id());
					//Container Loading List - Danger Cargo Data를 생성한다.
					dbDao.addCllDgCgo(bkgCstmsTmlCllDgCgoVO);
				}
			}
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry 및 Select
	 * 
	 * @programId ESM_BKG_1056 - manage(modify, insert)
	 * @param KorCllSppVO[] korCllSppVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author Son Yun Seuk
	 */
	public void manageKorCllSppList(KorCllSppVO[] korCllSppVOs, SignOnUserAccount account) throws EventException{
		ArrayList<KorCllSppVO> updList = new ArrayList<KorCllSppVO>();
		try{
			for(int i = 0; i < korCllSppVOs.length; i++){
				KorCllSppVO node = korCllSppVOs[i];

				if(node.getIbflag().equals("I")){
					node.setCreUsrId(account.getUsr_id());
					node.setUpdUsrId(account.getUsr_id());
					//한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry
					dbDao.addKorCllSppList(node);
				}else{
					node.setUpdUsrId(account.getUsr_id());
					updList.add(node);
				}
			}
			//한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry
			dbDao.modifyKorCllSppList(updList);
			updList.clear();
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 한국의 Container Loading 대상 목록의 Summary 화면에서의 SPP Code를 Creation, Inquiry 및 Select
	 * 
	 * @programId manage(modify, insert, delete)
	 * @param BkgCstmsCdConvCtntVO[] bkgCstmsCdConvCtntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCdConvCtnt(BkgCstmsCdConvCtntVO[] bkgCstmsCdConvCtntVOs, SignOnUserAccount account) throws EventException{
		try{
			List<BkgCstmsCdConvCtntVO> addList = new ArrayList<BkgCstmsCdConvCtntVO>();
			List<BkgCstmsCdConvCtntVO> modList = new ArrayList<BkgCstmsCdConvCtntVO>();
			List<BkgCstmsCdConvCtntVO> remList = new ArrayList<BkgCstmsCdConvCtntVO>();
			for(int i = 0; i < bkgCstmsCdConvCtntVOs.length; i++)
			{
				bkgCstmsCdConvCtntVOs[i].setCreUsrId(account.getUsr_id());
				bkgCstmsCdConvCtntVOs[i].setUpdUsrId(account.getUsr_id());
				if("D".equals(bkgCstmsCdConvCtntVOs[i].getIbflag()))
				{
					remList.add(bkgCstmsCdConvCtntVOs[i]);
				}
				else if("U".equals(bkgCstmsCdConvCtntVOs[i].getIbflag()))
				{
					modList.add(bkgCstmsCdConvCtntVOs[i]);
				}
				else
				{
					addList.add(bkgCstmsCdConvCtntVOs[i]);
				}
			}
			dbDao.addCdConvCtnt(addList);
			dbDao.modifyCdConvCtnt(modList);
			dbDao.removeCdConvCtnt(remList);
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * 터미널에 전송할 Container Loading List - Reefer, Awkward Cargo 정보를 수정한다.<br>
	 * 
	 * @param CllRfAkCgoDetailVO[] cllRfAkCgoDetailVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCllRfAkCgo(CllRfAkCgoDetailVO[] cllRfAkCgoDetailVOs, SignOnUserAccount account)
			throws EventException{
		try{
			for(int i = 0; i < cllRfAkCgoDetailVOs.length; i++){
				CllRfAkCgoDetailVO cllRfAkCgoDetailVO = cllRfAkCgoDetailVOs[i];
				cllRfAkCgoDetailVO.setUpdUsrId(account.getUsr_id());
				//Container Loading List - Reefer, Awkward Cargo Data를 업데이트 한다.
				dbDao.modifyCllRfAkCgo(cllRfAkCgoDetailVO);
			}
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06087", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Container Loading List(Korea) 정보를 POL 터미널에 전송한다.<br>
	 * 
	 * @param KorCllCondVO korCllCondVO
	 * @param SignOnUserAccount account
	 * @return String realFlatFile
	 * @exception EventException
	 */
	public String transmitKorCll(KorCllCondVO korCllCondVO, SignOnUserAccount account) throws EventException{
		StringBuffer realFlatFile = new StringBuffer();
		String header = "";
		List<CLLCDLManifestCntrDetailVO> cLLCDLManifestCntrDetailVOs = null;
		String footer = "";
		String generalInfo = "";
		BookingUtil bkgUtil = null;
		try{
			String inVslCd = korCllCondVO.getInVvdCd().substring(0, 4);
			String inSkdVoyNo = korCllCondVO.getInVvdCd().substring(4, 8);
			String inSkdDirCd = korCllCondVO.getInVvdCd().substring(8);
			String inPolCd = korCllCondVO.getInPolCd();
			String inPolYdCd = korCllCondVO.getInPolYdCd();
			String inRcvId = korCllCondVO.getInRcvId();
			String inKtmlCd = korCllCondVO.getInKtmlCd();

			bkgUtil = new BookingUtil();

			header = bkgUtil.searchEdiHeader("SMLMM010", inRcvId, "COLDLT");
			
			if(dbDao.modifyTmnlVslCd(inVslCd, inKtmlCd, account.getUsr_id()) == 0){//Container Loading List(Korea) 관련 터미널 Vessel Code를 수정한다.
				//Container Loading List(Korea) 관련 터미널 Vessel Code를 생성한다.
				dbDao.addTmnlVslCd(inVslCd, inKtmlCd, account.getUsr_id());
			}	
			
			//Container Loading List(Korea) General Data를 조회한다.
			generalInfo = dbDao.searchGeneralInfo(inVslCd, inSkdVoyNo, inSkdDirCd, inPolCd, inPolYdCd, inRcvId,
					header.substring(71));

			//Container Loading List(Korea) Container Detail 정보를 조회한다.
			cLLCDLManifestCntrDetailVOs = dbDao.searchCntrDetail(inVslCd, inSkdVoyNo, inSkdDirCd, inPolCd, inPolYdCd,
					inRcvId);

			footer = "{14\n16\n" + cLLCDLManifestCntrDetailVOs.size() + "\nCH\n}14\n";

			realFlatFile.append(header).append("\n");
			realFlatFile.append(generalInfo);
			for(int i = 0; i < cLLCDLManifestCntrDetailVOs.size(); i++){
				realFlatFile.append(cLLCDLManifestCntrDetailVOs.get(i).getCntrDetail());
			}
			realFlatFile.append(footer);

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(realFlatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CDL.IBMMQ.QUEUE"));

			FlatFileAckVO flatFileAckVO = bkgUtil.sendFlatFile(sendFlatFileVO);

			if(flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());

			//Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.
			dbDao.modifyUpdateDt(inVslCd, inSkdVoyNo, inSkdDirCd, inPolCd);
			
			// EDI 전송 Log를 입력한다.
			KorCllRtvOptionVO korCllRtvOptionVO = new KorCllRtvOptionVO();
			korCllRtvOptionVO.setVslCd(inVslCd);
			korCllRtvOptionVO.setSkdVoyNo(inSkdVoyNo);
			korCllRtvOptionVO.setSkdDirCd(inSkdDirCd);
			korCllRtvOptionVO.setPolCd(inPolCd);
			korCllRtvOptionVO.setPolYdCd(inPolYdCd);
			korCllRtvOptionVO.setFnlEdiSndFlg(korCllCondVO.getInFinalEdiFlg());
			String headerSubStr = "";
			if(header.length() >= 100){
				headerSubStr = header.substring(100);
			} else {
				headerSubStr = header;
			}
			korCllRtvOptionVO.setEdiHdrRmk(headerSubStr);
			korCllRtvOptionVO.setCreUsrId(account.getUsr_id());
			korCllRtvOptionVO.setUpdUsrId(account.getUsr_id());
			
			
			dbDao.addKorCllEdiSendLog( korCllRtvOptionVO );

		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		return realFlatFile.toString();
	}

	
	/**
	 * Flatfile 생성을 VVD 별로 할 것인지 BL 별로 할 것인지 구분<br>
	 * 
	 * @param CllCdlTransmitVO[] cllCdlTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String transmitCllCdlGate(CllCdlTransmitVO[] cllCdlTransmitVOs, SignOnUserAccount account) throws EventException{
		
		String inVvdFlg = "";
		String inBlFlg = "";
		String inListType = "";
		String inLocNm = "";
		String inRcvId = "";
		String inSndId = "";
		String inVvdCd = "";  
		String inPolCd = "";
		String inPodCd = "";
		String inEtcEuid = "";
		String inDestSvrCd = "";
		String inAreaId = "";
		String inWhereGubun = "";
		String inPolSplitNo = "";
		String inPodSplitNo = ""; // Add. 2015.02.09
		
		int woCnt = 0;
	    int suessCntr = 0;
	    int woflgCnt = 0;
	    int tmpCnt = 0;
	    int failCnt = 0;
		String message = "";
		
		CllCdlTransmitVO cllCdlTrsVO = cllCdlTransmitVOs[0];
		inVvdFlg = cllCdlTrsVO.getInVvdFlg();
		inBlFlg = cllCdlTrsVO.getInBlFlg();
		inRcvId = cllCdlTrsVO.getInRcvId();
		inSndId = cllCdlTrsVO.getInSndId();
		inListType = cllCdlTrsVO.getInListType();
		inLocNm = cllCdlTrsVO.getInLocNm();
		inVvdCd = cllCdlTrsVO.getInVvdCd();
		inPolCd = cllCdlTrsVO.getInPolCd();
		inPodCd = cllCdlTrsVO.getInPodCd();
		inEtcEuid = cllCdlTrsVO.getInEtcEuid();
		inDestSvrCd = cllCdlTrsVO.getInDestSvrCd();
		inAreaId = cllCdlTrsVO.getInAreaId();
		inWhereGubun = cllCdlTrsVO.getInWhereGubun();
		inPolSplitNo = cllCdlTrsVO.getInPolSplitNo(); // Add. 2015.02.09
		inPodSplitNo = cllCdlTrsVO.getInPodSplitNo(); // Add. 2015.02.09
		
		try {
			// VVD 단위로 Flatfile 생성
			if(inVvdFlg.equals("Y")) {
				
				transmitCllCdl(cllCdlTransmitVOs, account);
				// 전송 건수 count
				suessCntr = cllCdlTransmitVOs.length;
				
			}
			
			// BL 단위로 Flatfile 생성
			CllCdlTransmitVO[] sendBlVO = null;
			ArrayList blVO = new ArrayList();
			ArrayList blVOs = new ArrayList();
			
			CllCdlTransmitVO temp = null;
			
			if(inBlFlg.equals("Y")) {
				// blVO 판단로직 돌리기 => blVOs 완성
				String preBL = "";
				String currBL  = "";
				String woFlg = "";
				
				// BL 별로 내림차순 정렬
				for(int i = 0; i < cllCdlTransmitVOs.length; i++) {
					for(int j = 0; j < cllCdlTransmitVOs.length; j++) {
						if(cllCdlTransmitVOs[i].getBkgNo().compareTo(cllCdlTransmitVOs[j].getBkgNo()) > 0){
							temp = cllCdlTransmitVOs[i];
							cllCdlTransmitVOs[i] = cllCdlTransmitVOs[j];
							cllCdlTransmitVOs[j] = temp;
						}
					}
				}
				
				// 같은 BL 끼리 그룹핑하여 blVOs 에 담기
				for(int i = 0; i < cllCdlTransmitVOs.length; i++) {
					currBL = cllCdlTransmitVOs[i].getBkgNo();
					if(i == 0) {
						preBL = currBL;
					}
					
					if(!preBL.equals(currBL)) {
						blVOs.add(blVO);
						blVO = new ArrayList();
					}

					blVO.add(cllCdlTransmitVOs[i]);
					
					preBL = currBL;

					if(i == cllCdlTransmitVOs.length - 1) {
						blVOs.add(blVO);
					}
				} // end for(i)
				
				
				// blVOs에 담긴 값들을 그룹핑 된 BL 단위로 분리
				for(int i = 0; i < blVOs.size(); i++) {
					blVO = (ArrayList<CllCdlTransmitVO>) blVOs.get(i);
					sendBlVO = new CllCdlTransmitVO[blVO.size()];
					woCnt = 0;
					tmpCnt = 0;
					
					for(int j= 0; j<blVO.size(); j++) {
						sendBlVO[j] = (CllCdlTransmitVO) blVO.get(j);
						sendBlVO[j].setInRcvId(inRcvId);
						sendBlVO[j].setInSndId(inSndId);
						sendBlVO[j].setInListType(inListType);  
						sendBlVO[j].setInLocNm(inLocNm);
						sendBlVO[j].setInVvdCd(inVvdCd);
						sendBlVO[j].setInPolCd(inPolCd);
						sendBlVO[j].setInPodCd(inPodCd);
						sendBlVO[j].setInEtcEuid(inEtcEuid);
						sendBlVO[j].setInDestSvrCd(inDestSvrCd);
						sendBlVO[j].setInAreaId(inAreaId);
						sendBlVO[j].setInWhereGubun(inWhereGubun);
						woFlg = dbDao.searchWOFlag(sendBlVO[j].getBkgNo(), sendBlVO[j].getInListType(), sendBlVO[j].getInPolCd(), sendBlVO[j].getInPodCd());
						woCnt ++;
					}
				
					   tmpCnt = woCnt;
				   // Work Order 생성여부가 Y인 경우는 EDI 전송하지 않음
					if (!woFlg.equals("Y")){
						suessCntr =  suessCntr + tmpCnt;
						// EDI 전송
						transmitCllCdl(sendBlVO, account);
						// CDL인 경우 tmp 테이블의 데이터 삭제
						if (inListType.equals("D")){
							dbDao.removeEdiTmpTbl("EDI_TMP");
							dbDao.removeEdiTmpTbl("EDI_GEN_TMP");
						}
					}else {
						failCnt = failCnt + tmpCnt ;
						woflgCnt ++;
						
					}
					
					woFlg = "";
				} // for 문 종료
				
			}
			message = "Success: " + Integer.toString(suessCntr)+ " CNTRs transmitted successfully!" ;
			if (woflgCnt > 0) {
			   	message = message + " \n W/O: "+Integer.toString(failCnt)+" CNTRs not transmitted";
			 }
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		return message;

	}
	
	/**
	 * 스케줄이 변경된 대상 B/L을 검색해 EDI전송 후 History 내역 Flatfile을 생성한다.<br>
	 * 
	 * @param List<TransmitCRCCFVO> transmitCRCCFVOs
	 * @return String
	 * @exception EventException
	 */
	public String transmitCRCCF(List<TransmitCRCCFVO> transmitCRCCFVOs) throws EventException {
		StringBuffer realFlatFile = new StringBuffer();
		
		String vvd = "";
		String port = "";
		String cntr = "";
		String header = "";
		
		// VVD가 달라도 이전 PORT와 현재 PORT의 ID가 동일하여 PORT가 출력되지 않는 문제를 대비하기 위한 값
		boolean diffVvdYn = false;
		
		TransmitCRCCFVO crccfTransmitEntity = null;
		BookingUtil bkgUtil = null; 
		FlatFileAckVO flatFileAckVO = null;
		
		try {
			if(transmitCRCCFVOs.size() > 0) {
				bkgUtil = new BookingUtil();
				TransmitCRCCFVO transmitCRCCFVO = transmitCRCCFVOs.get(0);
				vvd = transmitCRCCFVO.getVvd();
				port = transmitCRCCFVO.getPortCd();
				cntr = transmitCRCCFVO.getCntrNo();
				
				header = bkgUtil.searchEdiHeader("SMLINE", "CRCCF", "CRCCF");
				
				// head
				//realFlatFile.append("$$$MSGSTART:SMLM                SJSG                315       SCM40717568202").append("\n");
				realFlatFile.append(header).append("\n");
				// 첫줄은 출력한다.
				realFlatFile.append("VVD:").append(transmitCRCCFVOs.get(0).getVvd()).append("\n");
				// Add. 2014.12 CHM-201433005
				realFlatFile.append("LANE:").append(transmitCRCCFVOs.get(0).getLane()).append("\n");
				realFlatFile.append("OPR:").append(transmitCRCCFVOs.get(0).getOpr()).append("\n");
				// End
				realFlatFile.append("VSL_LLOYDCODE:").append(transmitCRCCFVOs.get(0).getLloydNo()).append("\n");
				realFlatFile.append("VSL_FULLNAME:").append(transmitCRCCFVOs.get(0).getVslEngNm()).append("\n");
				realFlatFile.append("{PORTS").append("\n");
				realFlatFile.append("PORT:").append(transmitCRCCFVOs.get(0).getPortCd()).append("\n");
				realFlatFile.append("PORT_NAME:").append(transmitCRCCFVOs.get(0).getLocNm()).append("\n");
				realFlatFile.append("PORT_AMS:").append(transmitCRCCFVOs.get(0).getLocAmsPortCd()).append("\n");
				realFlatFile.append("PORT_FIRMS:").append(transmitCRCCFVOs.get(0).getFirms()).append("\n");
				realFlatFile.append("YDCD:").append(transmitCRCCFVOs.get(0).getYdCd()).append("\n");
				realFlatFile.append("DATE_ATA:").append(transmitCRCCFVOs.get(0).getVpsEtaDt()).append("\n");
				realFlatFile.append("DATE_ATD:").append(transmitCRCCFVOs.get(0).getVpsEtdDt()).append("\n");
				realFlatFile.append("{CONTAINER").append("\n");
				realFlatFile.append("CNTRNBR:").append(transmitCRCCFVOs.get(0).getCntrNo()).append("\n");
				realFlatFile.append("BKGNBR:").append(transmitCRCCFVOs.get(0).getBkgNo()).append("\n");
				realFlatFile.append("BLNBR:").append(transmitCRCCFVOs.get(0).getBlNo()).append("\n");
				realFlatFile.append("CNTRWGT:").append(transmitCRCCFVOs.get(0).getCntrWgt()).append("\n");
				realFlatFile.append("CNTRWGT_UNIT:").append(transmitCRCCFVOs.get(0).getWgtUtCd()).append("\n");
				realFlatFile.append("CNTRTRWGT:").append(transmitCRCCFVOs.get(0).getTareWgt()).append("\n");
				realFlatFile.append("CNTRTYPE:").append(transmitCRCCFVOs.get(0).getCntrTpszCd()).append("\n");
				realFlatFile.append("ACTION:").append(transmitCRCCFVOs.get(0).getFlg()).append("\n");
				
				// Add. 2015.01.05 CHM-201433436
				realFlatFile.append("POR:").append(transmitCRCCFVOs.get(0).getPorCd()).append("\n");
				realFlatFile.append("POL:").append(transmitCRCCFVOs.get(0).getPolCd()).append("\n");
				realFlatFile.append("POD:").append(transmitCRCCFVOs.get(0).getPodCd()).append("\n");
				realFlatFile.append("DEL:").append(transmitCRCCFVOs.get(0).getDelCd()).append("\n");
				// End
				
				realFlatFile.append("}CONTAINER").append("\n");
				
				for(int i = 1; i < transmitCRCCFVOs.size(); i++) {
					crccfTransmitEntity = transmitCRCCFVOs.get(i);
					
					if(!vvd.equals(crccfTransmitEntity.getVvd())) {
						realFlatFile.append("}PORTS").append("\n");
						
						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(realFlatFile.toString());
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CDL.IBMMQ.QUEUE"));
						
						flatFileAckVO = bkgUtil.sendFlatFile(sendFlatFileVO);

						if(flatFileAckVO.getAckStsCd().equals("E"))
							throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
						
						// VVD 별로 나오기 위해 새파일 생성
						realFlatFile = new StringBuffer();
						realFlatFile.append(header).append("\n");
						realFlatFile.append("VVD:").append(crccfTransmitEntity.getVvd()).append("\n");
						// Add. 2014.12 CHM-201433005
						realFlatFile.append("LANE:").append(crccfTransmitEntity.getLane()).append("\n");
						realFlatFile.append("OPR:").append(crccfTransmitEntity.getOpr()).append("\n");
						// End
						realFlatFile.append("VSL_LLOYDCODE:").append(crccfTransmitEntity.getLloydNo()).append("\n");
						realFlatFile.append("VSL_FULLNAME:").append(crccfTransmitEntity.getVslEngNm()).append("\n");
						
						vvd = crccfTransmitEntity.getVvd();
						diffVvdYn = true;
					} else {
						diffVvdYn = false;
					}
					
					// port
					if(diffVvdYn || !port.equals(crccfTransmitEntity.getPortCd())) {
						realFlatFile.append("{PORTS").append("\n");
						realFlatFile.append("PORT:").append(crccfTransmitEntity.getPortCd()).append("\n");
						realFlatFile.append("PORT_NAME:").append(crccfTransmitEntity.getLocNm()).append("\n");
						realFlatFile.append("PORT_AMS:").append(crccfTransmitEntity.getLocAmsPortCd()).append("\n");
						realFlatFile.append("PORT_FIRMS:").append(crccfTransmitEntity.getFirms()).append("\n");
						realFlatFile.append("YDCD:").append(crccfTransmitEntity.getYdCd()).append("\n");						
						realFlatFile.append("DATE_ATA:").append(crccfTransmitEntity.getVpsEtaDt()).append("\n");
						realFlatFile.append("DATE_ATD:").append(crccfTransmitEntity.getVpsEtdDt()).append("\n");
						
						port = crccfTransmitEntity.getPortCd();
					}
					
					// cntr
					//if(!cntr.equals(crccfTransmitEntity.getCntrNo())) { SPLIT된 BOOKING의 경우 CNTR NO는 같다. 2014 08 27 주석처리 
						realFlatFile.append("{CONTAINER").append("\n");
						realFlatFile.append("CNTRNBR:").append(crccfTransmitEntity.getCntrNo()).append("\n");
						realFlatFile.append("BKGNBR:").append(crccfTransmitEntity.getBkgNo()).append("\n");
						realFlatFile.append("BLNBR:").append(crccfTransmitEntity.getBlNo()).append("\n");
						realFlatFile.append("CNTRWGT:").append(crccfTransmitEntity.getCntrWgt()).append("\n");
						realFlatFile.append("CNTRWGT_UNIT:").append(crccfTransmitEntity.getWgtUtCd()).append("\n");
						realFlatFile.append("CNTRTRWGT:").append(crccfTransmitEntity.getTareWgt()).append("\n");
						realFlatFile.append("CNTRTYPE:").append(crccfTransmitEntity.getCntrTpszCd()).append("\n");
						realFlatFile.append("ACTION:").append(crccfTransmitEntity.getFlg()).append("\n");
						// Add. 2015.01.05 CHM-201433436
						realFlatFile.append("POR:").append(crccfTransmitEntity.getPorCd()).append("\n");
						realFlatFile.append("POL:").append(crccfTransmitEntity.getPolCd()).append("\n");
						realFlatFile.append("POD:").append(crccfTransmitEntity.getPodCd()).append("\n");
						realFlatFile.append("DEL:").append(crccfTransmitEntity.getDelCd()).append("\n");
						// End
						realFlatFile.append("}CONTAINER").append("\n");
						
						//cntr = crccfTransmitEntity.getCntrNo();
					//}
				}
				
				// last row
				realFlatFile.append("}PORTS").append("\n");
				
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(realFlatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CDL.IBMMQ.QUEUE"));
				
				flatFileAckVO = bkgUtil.sendFlatFile(sendFlatFileVO);

				if(flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
				
			}
			
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		
		return realFlatFile.toString();
	}
	
	/**
	 * Container Loading/Discharging List 정보를 Terminal에 EDI 전송하기 위한 Flatfile을 생성한다.<br>
	 * 
	 * @param CllCdlTransmitVO[] cllCdlTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String realFlatFile
	 * @exception EventException
	 */
	public String transmitCllCdl(CllCdlTransmitVO[] cllCdlTransmitVOs, SignOnUserAccount account) throws EventException{
		StringBuffer realFlatFile = new StringBuffer();
		String inListType = "";
		String inLocNm = "";
		String pseudoVvd = "";
		String localIpi = "";
		String inRcvId = "";
		String inSndId = "";
		String inVvdCd = "";  
		String inPolCd = "";
		String inPodCd = "";
		String inMsgId = "COPRAR";
		String header = "";
		String bkgNo = "";
		String cmdtCd = "";
		String cmdtDesc = "";
		String inEtcEuid = "";
		String inDestSvrCd = "";
		//String inYdCd = "";
		String localTime = ""; 
		String inAreaId = "";
		String inWhereGubun = "";
		
		String inPolSplitNo = "";   // Add. 2015.02.09.
		String inPodSplitNo = "";   // Add. 2015.02.09.
		
		int gubunja = 0;
		List<CLLCDLManifestCllBlInfoVO> cLLCDLManifestCllBlInfoVOs = null;
		List<CllCdlCntrInfoVO> cllCdlCntrInfoVOs = null;
		List<CLLCDLManifestCllDgCntrInfoVO> cLLCDLManifestCllDgCntrInfoVOs = null;
		List<CLLCDLManifestCllCntrDescInfoVO> cLLCDLManifestCllCntrDescInfoVOs = null;
		List<CLLCDLManifestCllQtyInfoVO> cLLCDLManifestCllQtyInfoVOs = null;
		List<CLLCDLManifestCllBkgVvdInfoVO> cLLCDLManifestCllBkgVvdInfoVOs = null;

		BookingUtil bkgUtil = null; 
		//FlatFileAckVO flatFileAckVO = null;   //2015.04.24 소스 보안[CWE-476]으로 수정
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO(); //2015.04.24 소스 보안[CWE-476]으로 수정
		try{
			if(cllCdlTransmitVOs.length > 0){
				CllCdlTransmitVO cllCdlTransmitVO = cllCdlTransmitVOs[0];
				inSndId = cllCdlTransmitVO.getInSndId();
				inRcvId = cllCdlTransmitVO.getInRcvId();
				inVvdCd = cllCdlTransmitVO.getInVvdCd();
				inPolCd = cllCdlTransmitVO.getInPolCd();
				inPodCd = cllCdlTransmitVO.getInPodCd();
				inDestSvrCd = cllCdlTransmitVO.getInDestSvrCd();
				inListType = cllCdlTransmitVO.getInListType();
				//inYdCd = cllCdlTransmitVO.getInYdCd();
				inWhereGubun = cllCdlTransmitVO.getInWhereGubun();
				inAreaId = cllCdlTransmitVO.getInAreaId();
				inPolSplitNo = cllCdlTransmitVO.getInPolSplitNo(); // Add. 2015.02.09.
				inPodSplitNo = cllCdlTransmitVO.getInPodSplitNo(); // Add. 2015.02.09.				
				
				bkgUtil = new BookingUtil();
				
				//localTime = dbDao.searchLocalTime(inYdCd.substring(0,5));
				if(inListType.equals("L")){
					

					localTime = dbDao.searchLocalTime(inPolCd);
					header = bkgUtil.searchEdiHeader(inSndId, inRcvId, inMsgId);

					realFlatFile.append(header).append("\n");

					inEtcEuid = header.substring(62);

					//Container Loading List 전송 관련 Location Description 정보를 조회한다.
					inLocNm = dbDao.searchCllLocDesc(cllCdlTransmitVO);

					cllCdlTransmitVO.setInLocNm(inLocNm);

					//Container Loading List 전송 관련 Vessel 정보를 조회한다.
					pseudoVvd = dbDao.searchCllVslInfo(cllCdlTransmitVO);

					if(pseudoVvd.length() < 12)
						pseudoVvd = dbDao.searchCllPseudoVslInfo(cllCdlTransmitVO);//Container Loading List 전송 관련 PSEUDO VVD 정보를 조회한다.

					realFlatFile.append(pseudoVvd);

					for(int i = 0; i < cllCdlTransmitVOs.length; i++){
						CllCdlTransmitVO cllCdlTransmitEntity = cllCdlTransmitVOs[i];

						cllCdlTransmitEntity.setInVvdCd(inVvdCd);
						cllCdlTransmitEntity.setInPolCd(inPolCd);
						cllCdlTransmitEntity.setInAreaId(inAreaId);
						cllCdlTransmitEntity.setInDestSvrCd(inDestSvrCd);
						cllCdlTransmitEntity.setInLocNm(inLocNm);
						cllCdlTransmitEntity.setCreUsrId(account.getUsr_id());
						cllCdlTransmitEntity.setInPolSplitNo(inPolSplitNo);		// Add. 2015.02.09.

						//Container Loading List 전송 관련 Local IPI 정보를 조회한다.
						localIpi = dbDao.searchCllLocalIpi(cllCdlTransmitEntity);

						cllCdlTransmitEntity.setInLocalIpi(localIpi);

						//Container Loading List 전송 관련 B/L 정보를 조회한다.
						cLLCDLManifestCllBlInfoVOs = dbDao.searchCllBl(cllCdlTransmitEntity);

						if(cLLCDLManifestCllBlInfoVOs.size() > 0){
							realFlatFile.append(cLLCDLManifestCllBlInfoVOs.get(0).getBlInfo());
							bkgNo = cLLCDLManifestCllBlInfoVOs.get(0).getBkgNo();
							cmdtCd = cLLCDLManifestCllBlInfoVOs.get(0).getCmdtCd();
							cmdtDesc = cLLCDLManifestCllBlInfoVOs.get(0).getCmdtDesc();
						}

						cllCdlTransmitEntity.setCmdtCd(cmdtCd);
						cllCdlTransmitEntity.setCmdtDesc(cmdtDesc.replace("'", "''"));
						//Container Loading List 전송 관련 Container 정보를 조회한다.
						cllCdlCntrInfoVOs = dbDao.searchCllCntr(cllCdlTransmitEntity);

						String multiCntrSealNo = "";
						String[] cntrSealNo = null;
						StringBuffer multiSealBuf = null;
						String cntrInfo = "";

						for(int j = 0; j < cllCdlCntrInfoVOs.size(); j++){
							gubunja = 1;

							CllCdlCntrInfoVO cllCdlCntrInfoVO = cllCdlCntrInfoVOs.get(j);
							cntrInfo = cllCdlCntrInfoVO.getCntrInfo();
							cllCdlCntrInfoVO.setInVvdCd(inVvdCd);
							cllCdlCntrInfoVO.setInPolCd(inPolCd);
							cllCdlCntrInfoVO.setBkgNo(bkgNo);
							cllCdlCntrInfoVO.setCreUsrId(account.getUsr_id());
							cllCdlCntrInfoVO.setInPolSplitNo(inPolSplitNo);		// Add. 2015.02.09.
							/*
							 * 2010.1.20 경종윤 [CHM-201108213] CLL/CDL EDI 기능에 Multi Seal 지원 로직 추가
							 */
							multiCntrSealNo = cllCdlCntrInfoVO.getCntrSealNo();
							cntrSealNo = multiCntrSealNo.split("@");
							int cntrSealNOMaxCnt = cntrSealNo.length;
						
							// Container 정보 
							realFlatFile.append(cntrInfo);
							
							if(cntrSealNOMaxCnt > 0 && !"".equals(cntrSealNo[0])) {
								multiSealBuf = new StringBuffer();
								for(int sealIdx = 0; sealIdx < cntrSealNOMaxCnt; sealIdx++) {
									multiSealBuf.append("{CNTR_SEAL_NO").append("\n");
									multiSealBuf.append("SEAL_NO:").append(cntrSealNo[sealIdx]).append("\n");
									multiSealBuf.append("}CNTR_SEAL_NO").append("\n");
								}
								realFlatFile.append(multiSealBuf.toString());
							}
							

							//Container Loading List 전송 관련 Danger Container 정보를 조회한다.
							cLLCDLManifestCllDgCntrInfoVOs = dbDao.searchCllDgCntr(cllCdlCntrInfoVO);

							for(int k = 0; k < cLLCDLManifestCllDgCntrInfoVOs.size(); k++)
								realFlatFile.append(cLLCDLManifestCllDgCntrInfoVOs.get(k).getCntrDgInfo());

							//Container Loading List 전송 관련 Container Description 정보를 조회한다.
							cLLCDLManifestCllCntrDescInfoVOs = dbDao.searchCllCntrDesc(cllCdlCntrInfoVO);

							for(int k = 0; k < cLLCDLManifestCllCntrDescInfoVOs.size(); k++){
								realFlatFile.append(cLLCDLManifestCllCntrDescInfoVOs.get(k).getCntrDesc());
								realFlatFile.append(cLLCDLManifestCllCntrDescInfoVOs.get(k).getCusMark());
								realFlatFile.append(cLLCDLManifestCllCntrDescInfoVOs.get(k).getCntrDescEnd());
							}

							if(gubunja == 1){
								realFlatFile.append("}CNTR_INFO").append("\n");
								gubunja = 0;
							}
						}

						CllCdlCntrInfoVO cllCdlCntrInfoVO2 = new CllCdlCntrInfoVO();
						cllCdlCntrInfoVO2.setBkgNo(bkgNo);

						//Container Loading List 전송 관련 BKG QTY 정보를 조회한다.
						cLLCDLManifestCllQtyInfoVOs = dbDao.searchCllQty(cllCdlCntrInfoVO2);

						for(int k = 0; k < cLLCDLManifestCllQtyInfoVOs.size(); k++)
							realFlatFile.append(cLLCDLManifestCllQtyInfoVOs.get(k).getBkgQtyInfo());

						//Container Loading List 전송 관련 BKG VVD 정보를 조회한다.
						cLLCDLManifestCllBkgVvdInfoVOs = dbDao.searchCllBkgVvd(cllCdlCntrInfoVO2);

						for(int k = 0; k < cLLCDLManifestCllBkgVvdInfoVOs.size(); k++)
							realFlatFile.append(cLLCDLManifestCllBkgVvdInfoVOs.get(k).getBkgVvdInfo());
						//2011.06.21 김봉균 조건문추가(BL_INFO값이 없을 경우 append하지 않게 처리)
						if(cLLCDLManifestCllBlInfoVOs.size() > 0){
							realFlatFile.append("}BL_INFO").append("\n");
						}

					}
					

					
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(realFlatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CDL.IBMMQ.QUEUE"));

					flatFileAckVO = bkgUtil.sendFlatFile(sendFlatFileVO);

					if(flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());

					cllCdlTransmitVO.setInEtcEuid(inEtcEuid);
					cllCdlTransmitVO.setUpdUsrId(account.getUsr_id());

					//Container Discharging List 전송 관련 전송 정보를 저장한다.
					dbDao.modifyTmnlCllSendLog(cllCdlTransmitVO);
					
					BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
					List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					String tempBkgCd = "";
					for(int i = 0; i < cllCdlTransmitVOs.length; i++){
						
						if(!tempBkgCd.equals(cllCdlTransmitVOs[i].getBkgNo()))
						{
							BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
	
							bkgNtcHisVO.setBkgNo(cllCdlTransmitVOs[i].getBkgNo());
							bkgNtcHisVO.setNtcViaCd("E"); // F:Fax,M:Email
							bkgNtcHisVO.setNtcKndCd("LL"); // BL : Draft B/L -- 우선 BL을 사용 추후에 수정요망
							bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
							bkgNtcHisVO.setSndUsrId(account.getUsr_id());
							bkgNtcHisVO.setEdiId(inRcvId);
							bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
							bkgNtcHisVO.setSndId(inSndId);
							bkgNtcHisVO.setSndDt(localTime);
							bkgNtcHisVO.setSndRqstDt(localTime);
							bkgNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
	
							bkgNtcHisVOs.add(bkgNtcHisVO);
							
							tempBkgCd = cllCdlTransmitVOs[i].getBkgNo();
						}
					}
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
					
				} else {
					
					// Discharing 일 경우
					
					localTime = dbDao.searchLocalTime(inPodCd);
					
					for(int i =0 ; i<cllCdlTransmitVOs.length ; i++)
					{
						CllCdlTransmitVO cllCdlTransmitEntity = cllCdlTransmitVOs[i];
						cllCdlTransmitEntity.setInVvdCd(inVvdCd);
						cllCdlTransmitEntity.setInPodCd(inPodCd);
						dbDao.addCdlEdiList(cllCdlTransmitEntity);
					}
					
					List<CdlEdiListForSplitVO> cdlEdiListForSplitVOs = dbDao.searchCdlEdiListForSplit();
					
					String tempBkgNo = "";
					int tempIndex = 1;
					ArrayList<Integer> loopCount = new ArrayList<Integer>();
					int cdlEdiListForSplitVOsSize = cdlEdiListForSplitVOs.size();
					CdlEdiListForSplitVO cdlEdiListForSplitVO = null;
					
						for(int i = 0 ; i < cdlEdiListForSplitVOsSize ; i++) {
							
							if(i == cdlEdiListForSplitVOsSize - 1) {
								loopCount.add(i+1);		//끝번호
								break;
							}
							
							cdlEdiListForSplitVO = cdlEdiListForSplitVOs.get(i);
							
							if(!tempBkgNo.equals(cdlEdiListForSplitVO.getBkgNo())) {
								
								if(!"NLRTMECTEMX".equals(inRcvId) && !"NLRTMECTEMX".equals(inRcvId) && !"NLRTMECTEMX".equals(inRcvId)) {
	
									if(tempIndex > 500) {
										loopCount.add(i);
										tempIndex = 1;
									}
								}
								
								
								tempBkgNo = cdlEdiListForSplitVO.getBkgNo();
							}
							
							tempIndex++;
						}
					
					cllCdlTransmitVO.setInPolCd("");
					dbDao.addCdlEdiMain(cllCdlTransmitVO);
					dbDao.addCdlEdiMnd();
					
					ArrayList<Integer> finalLoopCount = new ArrayList<Integer>();
					for(int i=0; i<loopCount.size(); i++){
						if("ESALGY2".equals(cllCdlTransmitVOs[0].getInYdCd())){
							finalLoopCount.add(loopCount.get(loopCount.size()-i-1));
						}else{
							finalLoopCount.add(loopCount.get(i));
						}
					}

					int startIndex = 1;
					int startIndex2 = 1;
					int endIndex = 0;
					int lCount = 1;
					int cdlEdiDetailVOSize = 0;
					CdlEdiDetailVO cdlEdiDetailVO = null;
					List<CdlEdiDetailVO> cdlEdiDetailVOs = null;
					for(int i = 0; i<finalLoopCount.size(); i++){
						realFlatFile = new StringBuffer();

						int iteratorCount = finalLoopCount.get(i);
						if(!"ESALGY2".equals(cllCdlTransmitVOs[0].getInYdCd())){
							if(lCount == 1){
								startIndex = 1;
							}else{
								startIndex = startIndex2;
							}
							startIndex2 = iteratorCount+1;
							lCount++;
	
							
						}else if("ESALGY2".equals(cllCdlTransmitVOs[0].getInYdCd())){
							if(i+1!=finalLoopCount.size()){
								startIndex = finalLoopCount.get(i+1)+1;
							}else if(i+1==finalLoopCount.size()){
								startIndex=1;
							}
						}
						endIndex = iteratorCount;
						
						String ediSndId = "";
						if(inSndId.length() > 0){
							ediSndId = inSndId;
						}else{
							//Container Discharging List 전송 관련 Sender ID 정보를 조회한다.
							ediSndId = dbDao.searchCdlSenderId(cllCdlTransmitVO);
						}

						header = bkgUtil.searchEdiHeader(ediSndId, inRcvId, inMsgId);

						realFlatFile.append(header).append("\n");
						
						if("ESALGY2".equals(cllCdlTransmitVOs[0].getInYdCd()) && i==1){
							dbDao.updateCdlEdiHdr();
						}
						
						cdlEdiDetailVOs = dbDao.searchCdlEdi(startIndex+"", endIndex+"");
						cdlEdiDetailVOSize = cdlEdiDetailVOs.size();
						for(int j = 0 ; j<cdlEdiDetailVOSize ; j++)
						{
							cdlEdiDetailVO = cdlEdiDetailVOs.get(j);
							realFlatFile.append(cdlEdiDetailVO.getStr());
						}
					
						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(realFlatFile.toString());
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CDL.IBMMQ.QUEUE"));

						flatFileAckVO = bkgUtil.sendFlatFile(sendFlatFileVO);

						if(flatFileAckVO.getAckStsCd().equals("E"))
							throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
					}
					
					BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
					List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					String tempBkgCd = "";
					int cllCdlTransmitVOsLength = cllCdlTransmitVOs.length;
					cllCdlTransmitVO = null;
					for(int i = 0; i < cllCdlTransmitVOsLength; i++){
						
						cllCdlTransmitVO = cllCdlTransmitVOs[i];
						
						if(!tempBkgCd.equals(cllCdlTransmitVO.getBkgNo()))
						{
							BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
	
							bkgNtcHisVO.setBkgNo(cllCdlTransmitVO.getBkgNo());
							bkgNtcHisVO.setNtcViaCd("E"); // F:Fax,M:Email
							if(inWhereGubun.equals("BKG"))
							{
								bkgNtcHisVO.setNtcKndCd("IM"); // BL : Draft B/L -- 우선 BL을 사용 추후에 수정요망
							}else{
								bkgNtcHisVO.setNtcKndCd("DL"); // BL : Draft B/L -- 우선 BL을 사용 추후에 수정요망
							}
							bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
							bkgNtcHisVO.setSndUsrId(account.getUsr_id());
							bkgNtcHisVO.setEdiId(inRcvId);
							bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
							bkgNtcHisVO.setSndId(inSndId);
							bkgNtcHisVO.setSndDt(localTime);
							bkgNtcHisVO.setSndRqstDt(localTime);
							bkgNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
	
							bkgNtcHisVOs.add(bkgNtcHisVO);
							
							tempBkgCd = cllCdlTransmitVO.getBkgNo();
						}
					}
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
					
				}
			}

		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		return realFlatFile.toString();
	}

	/**
	 * Terminal 에 EDI 전송할 Export Container List 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String polCd
	 * @return List<ExCntrTransmitVO>
	 * @exception EventException
	 */
	public List<ExCntrTransmitVO> searchCntrExportInfo(String bkgNo, String polCd) throws EventException{
		try{
			//Terminal 에 EDI 전송할 Export Container List 정보를 조회한다.
			List<ExCntrTransmitVO> exCntrTransmitVOs = null;
			exCntrTransmitVOs =  dbDao.searchCntrExportInfo(bkgNo, polCd);
			if(exCntrTransmitVOs.size() == 0)
			{
				exCntrTransmitVOs = dbDao.searchCntrExportInfo2(bkgNo, polCd);
			}
			
			return exCntrTransmitVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Export Container List 정보를 Terminal 에 EDI 전송하기 위한 Flatfile을 생성한다.<br>
	 * 
	 * @param ExCntrTransmitCondVO exCntrTransmitCondVO
	 * @param String rcvId
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String transmitCntrExportEdi(ExCntrTransmitCondVO exCntrTransmitCondVO, String rcvId, SignOnUserAccount account) throws EventException{

		StringBuffer flatFile = new StringBuffer(1000000);
		String specialFlag = "";
		String bbFlag = "";
		String akFlag = "";
		String dgFlag = "";
		String rcFlag = "";
		String header = "";

		BookingUtil bkgUtil = null;

		List<ExCntrVvdInfoVO> exCntrVvdInfoVOs = null;

		List<ExCntrTransmitBlInfoVO> exCntrTransmitBlInfoVOs = null;
		ExCntrTransmitBlInfoVO exCntrTransmitBlInfoVO = null;

		List<ExCntrTransmitCntrInfoVO> exCntrTransmitCntrInfoVOs = null;
		ExCntrTransmitCntrInfoVO exCntrTransmitCntrInfoVO = null;

		List<ExCntrTransmitCntrDescInfoVO> exCntrTransmitCntrDescInfoVOs = null;
		ExCntrTransmitCntrDescInfoVO exCntrTransmitCntrDescInfoVO = null;

		List<ExCntrTransmitCntrSpecialInfoVO> exCntrTransmitCntrSpecialInfoVOs = null;
		ExCntrTransmitCntrSpecialInfoVO exCntrTransmitCntrSpecialInfoVO = null;

		List<ExCntrTransmitCntrDgInfoVO> exCntrTransmitCntrDgInfoVOs = null;
		ExCntrTransmitCntrDgInfoVO exCntrTransmitCntrDgInfoVO = null;

		List<ExCntrTransmitCntrQtyInfoVO> exCntrTransmitCntrQtyInfoVOs = null;
		ExCntrTransmitCntrQtyInfoVO exCntrTransmitCntrQtyInfoVO = null;

		List<ExCntrTransmitCntrBkgVvdInfoVO> exCntrTransmitCntrBkgVvdInfoVOs = null;
		ExCntrTransmitCntrBkgVvdInfoVO exCntrTransmitCntrBkgVvdInfoVO = null;

		try{
			String rfTemp = dbDao.searchCntrExportRfTemp(exCntrTransmitCondVO.getFormBkgNo());
			
			if(rfTemp.equals("N"))
			{
				throw new EventException(new ErrorHandler("BKG00611", new String[]{}).getMessage());
			}
			
			//1. BKG_CSTMS_VVD_TML 존재여부 에 따른 처리
			String cnt = dbDao.searchCntrExportTml(exCntrTransmitCondVO);
			
			exCntrTransmitCondVO.setCreUsrId(account.getUsr_id());
			exCntrTransmitCondVO.setUpdUsrId(account.getUsr_id());
			
			if("0".equals(cnt)) // 존재하지 않으면
				dbDao.addCntrExportTml(exCntrTransmitCondVO);
			else                  // 존재하면
				dbDao.modifyCntrExportTml(exCntrTransmitCondVO);
			
			//2. BKG_CSTMS_TML_EUR_ORG_LOCL 존재여부에 따른 처리
			String cnt2 = dbDao.searchCntrExportTmlDtl(exCntrTransmitCondVO);
			
			if("0".equals(cnt2)) // 존재하지 않으면
				dbDao.addCntrExportTmlDtl(exCntrTransmitCondVO);
			else                  // 존재하면
				dbDao.modifyCntrExportTmlDtl(exCntrTransmitCondVO);
			
			GeneralBookingReceiptDBDAO dbDao2 = new GeneralBookingReceiptDBDAO();
			ExCntrTransmitCondVO exCntrTransmitCondVO2 = null;
			
			ArrayList cntrType = new ArrayList();
			StringTokenizer token = new StringTokenizer(exCntrTransmitCondVO.getFormCntrType(), "|");
			while(token.hasMoreTokens()){
				cntrType.add(token.nextToken());
			}
			ArrayList cntrGwt = new ArrayList();
			StringTokenizer token2 = new StringTokenizer(exCntrTransmitCondVO.getFormGrsWgt(), "|");
			while(token2.hasMoreTokens()){
				cntrGwt.add(token2.nextToken());
			}
			for(int i=0 ; i<cntrType.size(); i++){
				exCntrTransmitCondVO2 = new ExCntrTransmitCondVO();
				exCntrTransmitCondVO2.setFormBkgNo(exCntrTransmitCondVO.getFormBkgNo());
				exCntrTransmitCondVO2.setFormCntrType(cntrType.get(i).toString());
				if(cntrGwt.get(i).toString().equals("`"))
					exCntrTransmitCondVO2.setFormGrsWgt("");
				else
					exCntrTransmitCondVO2.setFormGrsWgt(cntrGwt.get(i).toString());
				dbDao2.modifyCntrExportTmlGW(exCntrTransmitCondVO2);
			}
			
			bkgUtil = new BookingUtil();
			header = bkgUtil.searchEdiHeader("SMLINE", rcvId, "ADEMAR");
			flatFile.append(header).append("\n");

			//구주 Container Export EDI 전송시 필요한 VVD DATA를 조회 한다.
			exCntrVvdInfoVOs = dbDao.searchCntrExportVvd(exCntrTransmitCondVO);

			if(exCntrVvdInfoVOs != null){
				//구주 Container Export EDI 전송시 필요한 BL DATA를 조회 한다.
				exCntrTransmitBlInfoVOs = dbDao.searchCntrExportTranmitBl(exCntrTransmitCondVO);
				exCntrTransmitBlInfoVO = exCntrTransmitBlInfoVOs.get(0);

				flatFile.append("VVD:").append(exCntrVvdInfoVOs.get(0).getVvd()).append("\n");
				flatFile.append("VSL_CALLSIGN:").append(exCntrVvdInfoVOs.get(0).getVslCallsign()).append("\n");
				flatFile.append("VSL_LLOYDCODE:").append(exCntrVvdInfoVOs.get(0).getVslLloydcode()).append("\n");
				flatFile.append("VSL_FULLNAME:").append(exCntrVvdInfoVOs.get(0).getVslFullname()).append("\n");
				flatFile.append("TERM_VSL_CD:").append(exCntrVvdInfoVOs.get(0).getTermVslCd()).append("\n");
				flatFile.append("TERM_VOY_CD:").append(exCntrVvdInfoVOs.get(0).getTermVoyCd()).append("\n");
				flatFile.append("TERM_CALLSIGN:").append(exCntrVvdInfoVOs.get(0).getTermCallsign()).append("\n");
				flatFile.append("TERM_BERTH_CD:").append(exCntrVvdInfoVOs.get(0).getTermBerthCd()).append("\n");
				flatFile.append("TERM_REMARK:").append(exCntrVvdInfoVOs.get(0).getTermRemark()).append("\n");
				flatFile.append("PORT:").append(exCntrVvdInfoVOs.get(0).getPort()).append("\n");
				flatFile.append("PORTNAME:").append(exCntrVvdInfoVOs.get(0).getPortname()).append("\n");
				flatFile.append("ETA:").append(exCntrVvdInfoVOs.get(0).getEta()).append("\n");
				flatFile.append("ETD:").append(exCntrVvdInfoVOs.get(0).getEtd()).append("\n");
				flatFile.append("NEXTPORT:").append(exCntrVvdInfoVOs.get(0).getNextport()).append("\n");
				flatFile.append("NEXTPORT_ETA:").append(exCntrVvdInfoVOs.get(0).getNextportEta()).append("\n");
				flatFile.append("PREVPORT:").append(exCntrVvdInfoVOs.get(0).getPrevport()).append("\n");
				flatFile.append("PREVPORT_ETD:").append(exCntrVvdInfoVOs.get(0).getPrevportEtd()).append("\n");
				flatFile.append("IO_IND:").append(exCntrVvdInfoVOs.get(0).getIoInd()).append("\n");
				flatFile.append("COMP_ID:").append(exCntrVvdInfoVOs.get(0).getCompId()).append("\n");
				flatFile.append("MRN:").append(exCntrVvdInfoVOs.get(0).getMrn()).append("\n");
				flatFile.append("{BL_INFO").append("\n");
				flatFile.append("BLNBR:").append(exCntrTransmitBlInfoVO.getBlnbr()).append("\n");
				flatFile.append("BLPOL:").append(exCntrTransmitBlInfoVO.getPol()).append("\n");
				flatFile.append("POL_AMS:").append(exCntrTransmitBlInfoVO.getPolAms()).append("\n");
				flatFile.append("POL_FULLNAME:").append(exCntrTransmitBlInfoVO.getPolFullname()).append("\n");
				flatFile.append("BLPOD:").append(exCntrTransmitBlInfoVO.getBlpod()).append("\n");
				flatFile.append("POD_AMS:").append(exCntrTransmitBlInfoVO.getPodAms()).append("\n");
				flatFile.append("POD_FULLNAME:").append(exCntrTransmitBlInfoVO.getPodFullname()).append("\n");
				flatFile.append("BLPOR:").append(exCntrTransmitBlInfoVO.getBlpor()).append("\n");
				flatFile.append("POR_AMS:").append(exCntrTransmitBlInfoVO.getPorAms()).append("\n");
				flatFile.append("POR_FULLNAME:").append(exCntrTransmitBlInfoVO.getPorFullname()).append("\n");
				flatFile.append("BLDEL:").append(exCntrTransmitBlInfoVO.getBldel()).append("\n");
				flatFile.append("DEL_AMS:").append(exCntrTransmitBlInfoVO.getDelAms()).append("\n");
				flatFile.append("DEL_FULLNAME:").append(exCntrTransmitBlInfoVO.getDelFullname()).append("\n");
				flatFile.append("BLRLY:").append(exCntrTransmitBlInfoVO.getBlrly()).append("\n");
				flatFile.append("RLY_AMS:").append(exCntrTransmitBlInfoVO.getRlyAms()).append("\n");
				flatFile.append("RLY_FULLNAME:").append(exCntrTransmitBlInfoVO.getRlyFullname()).append("\n");
				flatFile.append("BLPLACE:").append(exCntrTransmitBlInfoVO.getBlplace()).append("\n");
				flatFile.append("BLDATE:").append(exCntrTransmitBlInfoVO.getBldate()).append("\n");
				flatFile.append("BRAC:").append(exCntrTransmitBlInfoVO.getBrac()).append("\n");
				flatFile.append("POL:").append(exCntrTransmitBlInfoVO.getPol()).append("\n");
				flatFile.append("POD:").append(exCntrTransmitBlInfoVO.getPod()).append("\n");
				flatFile.append("HAUL_MODE:").append(exCntrTransmitBlInfoVO.getHaulMode()).append("\n");
				flatFile.append("TRAN_MODE:").append(exCntrTransmitBlInfoVO.getTranMode()).append("\n");
				flatFile.append("FORWARD_CD:").append(exCntrTransmitBlInfoVO.getForwardCd()).append("\n");
				flatFile.append("SALES_OFFICE:").append(exCntrTransmitBlInfoVO.getSalesOffice()).append("\n");
				flatFile.append("SALES_NAME:").append(exCntrTransmitBlInfoVO.getSalesName()).append("\n");
				flatFile.append("CONTACT_NAME:").append(exCntrTransmitBlInfoVO.getContactName()).append("\n");
				flatFile.append("SHPRCN:").append(exCntrTransmitBlInfoVO.getShprcn()).append("\n");
				flatFile.append("SHPRCD:").append(exCntrTransmitBlInfoVO.getShprcd()).append("\n");
				flatFile.append("SHPR1:").append(exCntrTransmitBlInfoVO.getShpr1()).append("\n");
				flatFile.append("SHPR2:").append(exCntrTransmitBlInfoVO.getShpr2()).append("\n");
				flatFile.append("SHPR3:").append(exCntrTransmitBlInfoVO.getShpr3()).append("\n");
				flatFile.append("SHPR4:").append(exCntrTransmitBlInfoVO.getShpr4()).append("\n");
				flatFile.append("SHPR5:").append(exCntrTransmitBlInfoVO.getShpr5()).append("\n");
				flatFile.append("CNEECN:").append(exCntrTransmitBlInfoVO.getCneecn()).append("\n");
				flatFile.append("CNEECD:").append(exCntrTransmitBlInfoVO.getCneecd()).append("\n");
				flatFile.append("CNEE1:").append(exCntrTransmitBlInfoVO.getCnee1()).append("\n");
				flatFile.append("CNEE2:").append(exCntrTransmitBlInfoVO.getCnee2()).append("\n");
				flatFile.append("CNEE3:").append(exCntrTransmitBlInfoVO.getCnee3()).append("\n");
				flatFile.append("CNEE4:").append(exCntrTransmitBlInfoVO.getCnee4()).append("\n");
				flatFile.append("CNEE5:").append(exCntrTransmitBlInfoVO.getCnee5()).append("\n");
				flatFile.append("NTFYCN:").append(exCntrTransmitBlInfoVO.getNtfycn()).append("\n");
				flatFile.append("NTFYCD:").append(exCntrTransmitBlInfoVO.getNtfycd()).append("\n");
				flatFile.append("NTFY1:").append(exCntrTransmitBlInfoVO.getNtfy1()).append("\n");
				flatFile.append("NTFY2:").append(exCntrTransmitBlInfoVO.getNtfy2()).append("\n");
				flatFile.append("NTFY3:").append(exCntrTransmitBlInfoVO.getNtfy3()).append("\n");
				flatFile.append("NTFY4:").append(exCntrTransmitBlInfoVO.getNtfy4()).append("\n");
				flatFile.append("NTFY5:").append(exCntrTransmitBlInfoVO.getNtfy5()).append("\n");
				flatFile.append("NTFY2CN:").append(exCntrTransmitBlInfoVO.getNtfy2cn()).append("\n");
				flatFile.append("NTFY2CD:").append(exCntrTransmitBlInfoVO.getNtfy2cd()).append("\n");
				flatFile.append("NTFY21:").append(exCntrTransmitBlInfoVO.getNtfy21()).append("\n");
				flatFile.append("NTFY22:").append(exCntrTransmitBlInfoVO.getNtfy22()).append("\n");
				flatFile.append("NTFY23:").append(exCntrTransmitBlInfoVO.getNtfy23()).append("\n");
				flatFile.append("NTFY24:").append(exCntrTransmitBlInfoVO.getNtfy24()).append("\n");
				flatFile.append("NTFY25:").append(exCntrTransmitBlInfoVO.getNtfy25()).append("\n");
				flatFile.append("FFWDCN:").append(exCntrTransmitBlInfoVO.getFfwdcn()).append("\n");
				flatFile.append("FFWDCD:").append(exCntrTransmitBlInfoVO.getFfwdcd()).append("\n");
				flatFile.append("FFWD1:").append(exCntrTransmitBlInfoVO.getFfwd1()).append("\n");
				flatFile.append("FFWD2:").append(exCntrTransmitBlInfoVO.getFfwd2()).append("\n");
				flatFile.append("FFWD3:").append(exCntrTransmitBlInfoVO.getFfwd3()).append("\n");
				flatFile.append("FFWD4:").append(exCntrTransmitBlInfoVO.getFfwd4()).append("\n");
				flatFile.append("FFWD5:").append(exCntrTransmitBlInfoVO.getFfwd5()).append("\n");
				flatFile.append("EXPOCN:").append(exCntrTransmitBlInfoVO.getExpocn()).append("\n");
				flatFile.append("EXPOCD:").append(exCntrTransmitBlInfoVO.getExpocd()).append("\n");
				flatFile.append("EXPO1:").append(exCntrTransmitBlInfoVO.getExpo1()).append("\n");
				flatFile.append("EXPO2:").append(exCntrTransmitBlInfoVO.getExpo2()).append("\n");
				flatFile.append("EXPO3:").append(exCntrTransmitBlInfoVO.getExpo3()).append("\n");
				flatFile.append("EXPO4:").append(exCntrTransmitBlInfoVO.getExpo4()).append("\n");
				flatFile.append("EXPO5:").append(exCntrTransmitBlInfoVO.getExpo5()).append("\n");
				flatFile.append("BLCOPY:").append(exCntrTransmitBlInfoVO.getBlcopy()).append("\n");
				flatFile.append("BLORG:").append(exCntrTransmitBlInfoVO.getBlorg()).append("\n");
				flatFile.append("BLPKG:").append(exCntrTransmitBlInfoVO.getBlpkg()).append("\n");
				flatFile.append("BLPKGU:").append(exCntrTransmitBlInfoVO.getBlpkgu()).append("\n");
				flatFile.append("BLWGT:").append(exCntrTransmitBlInfoVO.getBlwgt()).append("\n");
				flatFile.append("BL_WGT_UNIT:").append(exCntrTransmitBlInfoVO.getBlWgtUnit()).append("\n");
				flatFile.append("BLMEA:").append(exCntrTransmitBlInfoVO.getBlmea()).append("\n");
				flatFile.append("BL_MEA_UNIT:").append(exCntrTransmitBlInfoVO.getBlMeaUnit()).append("\n");
				flatFile.append("RDTYPE:").append(exCntrTransmitBlInfoVO.getRdtype()).append("\n");
				flatFile.append("CARGOTYPE:").append(exCntrTransmitBlInfoVO.getCargotype()).append("\n");
				flatFile.append("COMMODITY:").append(exCntrTransmitBlInfoVO.getCommodity()).append("\n");
				flatFile.append("BLCMD:").append(exCntrTransmitBlInfoVO.getBlcmd()).append("\n");
				flatFile.append("BLREPCMDCD:").append(exCntrTransmitBlInfoVO.getBlrepcmdcd()).append("\n");
				flatFile.append("BLREPCMD:").append(exCntrTransmitBlInfoVO.getBlrepcmd()).append("\n");
				flatFile.append("REMARK:").append(exCntrTransmitBlInfoVO.getRemark()).append("\n");
				flatFile.append("AUS_QUAR:").append(exCntrTransmitBlInfoVO.getAusQuar()).append("\n");
				flatFile.append("SRNBR:").append(exCntrTransmitBlInfoVO.getSrnbr()).append("\n");
				flatFile.append("BKGNBR:").append(exCntrTransmitBlInfoVO.getBkgnbr()).append("\n");
				flatFile.append("RGN_BKGNBR:").append(exCntrTransmitBlInfoVO.getRgnBkgnbr()).append("\n");
				flatFile.append("PPDOFC:").append(exCntrTransmitBlInfoVO.getPpdofc()).append("\n");
				flatFile.append("CCTOFC:").append(exCntrTransmitBlInfoVO.getCctofc()).append("\n");
				flatFile.append("THDOFC:").append("\n");
				flatFile.append("SCNO:").append(exCntrTransmitBlInfoVO.getScno()).append("\n");
				flatFile.append("RFANO:").append(exCntrTransmitBlInfoVO.getRfano()).append("\n");
				flatFile.append("WAYBILL_IND:").append(exCntrTransmitBlInfoVO.getWaybillInd()).append("\n");
				flatFile.append("CUSTREF_NUM:").append(exCntrTransmitBlInfoVO.getCustrefNum()).append("\n");
				flatFile.append("FINAL_ETA:").append(exCntrTransmitBlInfoVO.getFinalEta()).append("\n");
				flatFile.append("FUNC_CODE:").append(exCntrTransmitBlInfoVO.getFuncCode()).append("\n");
				flatFile.append("ONBOARD:").append(exCntrTransmitBlInfoVO.getOnboard()).append("\n");
				flatFile.append("INV_NO:").append(exCntrTransmitBlInfoVO.getInvNo()).append("\n");
				flatFile.append("BLTS:").append(exCntrTransmitBlInfoVO.getBlts()).append("\n");
				flatFile.append("BLTP:").append(exCntrTransmitBlInfoVO.getBltp()).append("\n");
				flatFile.append("MSN:").append(exCntrTransmitBlInfoVO.getMsn()).append("\n");
				flatFile.append("MSNCFM:").append(exCntrTransmitBlInfoVO.getMsncfm()).append("\n");
				flatFile.append("CMDESC:").append(exCntrTransmitBlInfoVO.getCmdesc()).append("\n");
				flatFile.append("LOCAL_IPI:").append(exCntrTransmitBlInfoVO.getLocalIpi()).append("\n");
				flatFile.append("EQREL:").append(exCntrTransmitBlInfoVO.getEqrel()).append("\n");
				flatFile.append("EQPICKDT:").append(exCntrTransmitBlInfoVO.getEqpickdt()).append("\n");
				flatFile.append("EQRTN:").append(exCntrTransmitBlInfoVO.getEqrtn()).append("\n");

				bbFlag = exCntrTransmitBlInfoVO.getBbFlag();
				akFlag = exCntrTransmitBlInfoVO.getAkFlag();
				rcFlag = exCntrTransmitBlInfoVO.getRcFlag();
				dgFlag = exCntrTransmitBlInfoVO.getDgFlag();

				//구주 Container Export EDI 전송시 필요한 Container DATA를 조회 한다.
				exCntrTransmitCntrInfoVOs = dbDao.searchCntrExportTransmitCntr(exCntrTransmitCondVO);

				for(int i = 0; i < exCntrTransmitCntrInfoVOs.size(); i++){
					exCntrTransmitCntrInfoVO = exCntrTransmitCntrInfoVOs.get(i);

					flatFile.append("{CNTR_INFO").append("\n");
					flatFile.append("CNTRNBR:").append(exCntrTransmitCntrInfoVO.getCntrnbr()).append("\n");
					flatFile.append("PUNIT:").append(exCntrTransmitCntrInfoVO.getPunit()).append("\n");
					flatFile.append("PKG:").append(exCntrTransmitCntrInfoVO.getPkg()).append("\n");
					flatFile.append("CNTRWGT:").append(exCntrTransmitCntrInfoVO.getCntrwgt()).append("\n");
					flatFile.append("CNTRGWGT:").append(exCntrTransmitCntrInfoVO.getCntrgwgt()).append("\n");
					flatFile.append("CNTR_WGT_UNIT:").append(exCntrTransmitCntrInfoVO.getCntrWgtUnit()).append("\n");
					flatFile.append("CNTRTRW:").append(exCntrTransmitCntrInfoVO.getCntrtrw()).append("\n");
					flatFile.append("CNTRTYPE:").append(exCntrTransmitCntrInfoVO.getCntrtype()).append("\n");
					
					flatFile.append("VGM_VRF_DATE:").append(exCntrTransmitCntrInfoVO.getVgmVrfyDt()).append("\n");
					flatFile.append("VGM_WGTQTY:").append(exCntrTransmitCntrInfoVO.getVgmWgt()).append("\n");
					flatFile.append("VGM_WGTCD:").append(exCntrTransmitCntrInfoVO.getVgmWgtUtCd()).append("\n");
					flatFile.append("VGM_METHOD:").append(exCntrTransmitCntrInfoVO.getVgmMzdTpCd()).append("\n");
					flatFile.append("VGM_SIGNATURE:").append(exCntrTransmitCntrInfoVO.getVgmVrfySigCtnt()).append("\n");
					
					
					flatFile.append("SEALNBR:").append(exCntrTransmitCntrInfoVO.getSealnbr()).append("\n");
					flatFile.append("FM_IND:").append(exCntrTransmitCntrInfoVO.getFmInd()).append("\n");
					flatFile.append("RF_IND:").append(exCntrTransmitCntrInfoVO.getRfInd()).append("\n");
					flatFile.append("DG_IND:").append(exCntrTransmitCntrInfoVO.getDgInd()).append("\n");
					flatFile.append("AK_IND:").append(exCntrTransmitCntrInfoVO.getAkInd()).append("\n");
					flatFile.append("BK_IND:").append(exCntrTransmitCntrInfoVO.getBkInd()).append("\n");
					flatFile.append("TEMP:").append(exCntrTransmitCntrInfoVO.getTemp()).append("\n");
					flatFile.append("TUNIT:").append(exCntrTransmitCntrInfoVO.getTunit()).append("\n");
					flatFile.append("VENT:").append(exCntrTransmitCntrInfoVO.getVent()).append("\n");
					flatFile.append("MEASURE:").append(exCntrTransmitCntrInfoVO.getMeasure()).append("\n");
					flatFile.append("MEASURE_UNIT:").append(exCntrTransmitCntrInfoVO.getMeasureUnit()).append("\n");
					flatFile.append("RDTYPE:").append(exCntrTransmitCntrInfoVO.getRdtype()).append("\n");
					flatFile.append("CMDT_DESC:").append(exCntrTransmitCntrInfoVO.getCmdtDesc()).append("\n");
					flatFile.append("CMDTCD:").append(exCntrTransmitCntrInfoVO.getCmdtcd()).append("\n");
					flatFile.append("RF_REMARK:").append(exCntrTransmitCntrInfoVO.getRfRemark()).append("\n");
					flatFile.append("RFDRY_IND:").append(exCntrTransmitCntrInfoVO.getRfdryInd()).append("\n");
					flatFile.append("OVF:").append(exCntrTransmitCntrInfoVO.getOvf()).append("\n");
					flatFile.append("OVR:").append(exCntrTransmitCntrInfoVO.getOvr()).append("\n");
					flatFile.append("OVH:").append(exCntrTransmitCntrInfoVO.getOvh()).append("\n");
					flatFile.append("OVLW:").append(exCntrTransmitCntrInfoVO.getOvlw()).append("\n");
					flatFile.append("OVRW:").append(exCntrTransmitCntrInfoVO.getOvrw()).append("\n");
					flatFile.append("OVWGT:").append(exCntrTransmitCntrInfoVO.getOvwgt()).append("\n");
					flatFile.append("OVWGT_UNIT:").append(exCntrTransmitCntrInfoVO.getOvwgtUnit()).append("\n");
					flatFile.append("VOID_SLOT:").append(exCntrTransmitCntrInfoVO.getVoidSlot()).append("\n");
					flatFile.append("STWG_REQ:").append(exCntrTransmitCntrInfoVO.getStwgReq()).append("\n");
					flatFile.append("SOCIND:").append(exCntrTransmitCntrInfoVO.getSocind()).append("\n");
					flatFile.append("HAULAGE:").append(exCntrTransmitCntrInfoVO.getHaulage()).append("\n");
					flatFile.append("BKWGT:").append(exCntrTransmitCntrInfoVO.getBkwgt()).append("\n");
					flatFile.append("BKWGTU:").append(exCntrTransmitCntrInfoVO.getBkwgtu()).append("\n");
					flatFile.append("BKW:").append(exCntrTransmitCntrInfoVO.getBkw()).append("\n");
					flatFile.append("BKH:").append(exCntrTransmitCntrInfoVO.getBkh()).append("\n");
					flatFile.append("BKL:").append(exCntrTransmitCntrInfoVO.getBkl()).append("\n");
					flatFile.append("CNTROWN:").append(exCntrTransmitCntrInfoVO.getCntrown()).append("\n");
					flatFile.append("CNTRTRM:").append(exCntrTransmitCntrInfoVO.getCntrtrm()).append("\n");

					exCntrTransmitCondVO.setInCntrNo(exCntrTransmitCntrInfoVO.getCntrnbr());
					//구주 Container Export EDI 전송시 필요한 Container Description DATA를 조회 한다.
					exCntrTransmitCntrDescInfoVOs = dbDao.searchCntrExportTransmitCntrDesc(exCntrTransmitCondVO);

					if(exCntrTransmitCntrDescInfoVOs != null && exCntrTransmitCntrDescInfoVOs.size() > 0){
						int exCntrTransmitCntrDescInfoVOsMaxSize = exCntrTransmitCntrDescInfoVOs.size();
						for(int k = 0; k < exCntrTransmitCntrDescInfoVOsMaxSize; k++){
							exCntrTransmitCntrDescInfoVO = exCntrTransmitCntrDescInfoVOs.get(k);
							flatFile.append("{CNTR_DESC").append("\n");
							flatFile.append("D_CMDT:").append(exCntrTransmitCntrDescInfoVO.getDCmdt()).append("\n");
							flatFile.append("D_PUNIT:").append(exCntrTransmitCntrDescInfoVO.getDPunit()).append("\n");
							flatFile.append("D_PKG:").append(exCntrTransmitCntrDescInfoVO.getDPkg()).append("\n");
							flatFile.append("D_WGT:").append(exCntrTransmitCntrDescInfoVO.getDWgt()).append("\n");
							flatFile.append("D_MEAS:").append(exCntrTransmitCntrDescInfoVO.getDMeas()).append("\n");
							flatFile.append("D_DESC:").append(exCntrTransmitCntrDescInfoVO.getDDesc()).append("\n");

							if(exCntrTransmitCntrDescInfoVO.getDMark().length() > 0){
								flatFile.append("{CUS_MARK").append("\n");
								flatFile.append("D_DESC:").append(exCntrTransmitCntrDescInfoVO.getDMark()).append("\n");
								flatFile.append("}CUS_MARK").append("\n");
								flatFile.append("}CNTR_DESC").append("\n");
							}else{
								flatFile.append("}CNTR_DESC").append("\n");
							}
						}

					}

					flatFile.append("}CNTR_INFO").append("\n");
				}

				for(int j = 1; j <= 4; j++){
					switch(j){
					case 1:
						if(akFlag.equals("Y")){
							specialFlag = "AK";
						}else{
							continue;
						}
						break;
					case 2:
						if(bbFlag.equals("Y")){
							specialFlag = "BB";
						}else{
							continue;
						}
						break;
					case 3:
						if(rcFlag.equals("Y")){
							specialFlag = "RC";
						}else{
							continue;
						}
						break;
					case 4:
						if(dgFlag.equals("Y")){
							specialFlag = "DG";
						}else{
							continue;
						}
						break;
					}
					                     
					exCntrTransmitCondVO.setInSpecialFlag(specialFlag);
					//구주 Container Export EDI 전송시 필요한 Container speccial cargoDATA를 조회 한다.
					exCntrTransmitCntrSpecialInfoVOs = dbDao.searchCntrExportTransmitCntrSpecial(exCntrTransmitCondVO);

					int exCntrTransmitCntrSpecialInfoVOsMaxSize = exCntrTransmitCntrSpecialInfoVOs.size();

					for(int k = 0; k < exCntrTransmitCntrSpecialInfoVOsMaxSize; k++){
						exCntrTransmitCntrSpecialInfoVO = exCntrTransmitCntrSpecialInfoVOs.get(k);

						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(exCntrTransmitCntrSpecialInfoVO.getCntrnbr()).append("\n");
						flatFile.append("PUNIT:").append(exCntrTransmitCntrSpecialInfoVO.getPunit()).append("\n");
						flatFile.append("PKG:").append(exCntrTransmitCntrSpecialInfoVO.getPkg()).append("\n");
						flatFile.append("CNTRWGT:").append(exCntrTransmitCntrSpecialInfoVO.getCntrwgt()).append("\n");
						flatFile.append("CNTRGWGT:").append(exCntrTransmitCntrSpecialInfoVO.getCntrgwgt()).append("\n");
						flatFile.append("CNTR_WGT_UNIT:").append(exCntrTransmitCntrSpecialInfoVO.getCntrWgtUnit())
								.append("\n");
						flatFile.append("CNTRTRW:").append(exCntrTransmitCntrSpecialInfoVO.getCntrtrw()).append("\n");
						flatFile.append("CNTRTYPE:").append(exCntrTransmitCntrSpecialInfoVO.getCntrtype()).append("\n");
						flatFile.append("SEALNBR:").append(exCntrTransmitCntrSpecialInfoVO.getSealnbr()).append("\n");
						flatFile.append("FM_IND:").append(exCntrTransmitCntrSpecialInfoVO.getFmInd()).append("\n");
						flatFile.append("RF_IND:").append(exCntrTransmitCntrSpecialInfoVO.getRfInd()).append("\n");
						flatFile.append("DG_IND:").append(exCntrTransmitCntrSpecialInfoVO.getDgInd()).append("\n");
						flatFile.append("AK_IND:").append(exCntrTransmitCntrSpecialInfoVO.getAkInd()).append("\n");
						flatFile.append("BK_IND:").append(exCntrTransmitCntrSpecialInfoVO.getBkInd()).append("\n");
						flatFile.append("TEMP:").append(exCntrTransmitCntrSpecialInfoVO.getTemp()).append("\n");
						flatFile.append("TUNIT:").append(exCntrTransmitCntrSpecialInfoVO.getTunit()).append("\n");
						flatFile.append("VENT:").append(exCntrTransmitCntrSpecialInfoVO.getVent()).append("\n");
						flatFile.append("MEASURE:").append(exCntrTransmitCntrSpecialInfoVO.getMeasure()).append("\n");
						flatFile.append("MEASURE_UNIT:").append(exCntrTransmitCntrSpecialInfoVO.getMeasureUnit())
								.append("\n");
						flatFile.append("RDTYPE:").append(exCntrTransmitCntrSpecialInfoVO.getRdtype()).append("\n");
						flatFile.append("CMDT_DESC:").append(exCntrTransmitCntrSpecialInfoVO.getCmdtDesc())
								.append("\n");
						flatFile.append("CMDTCD:").append(exCntrTransmitCntrSpecialInfoVO.getCmdtcd()).append("\n");
						flatFile.append("RF_REMARK:").append(exCntrTransmitCntrSpecialInfoVO.getRfRemark())
								.append("\n");
						flatFile.append("RFDRY_IND:").append(exCntrTransmitCntrSpecialInfoVO.getRfdryInd())
								.append("\n");
						flatFile.append("OVF:").append(exCntrTransmitCntrSpecialInfoVO.getOvf()).append("\n");
						flatFile.append("OVR:").append(exCntrTransmitCntrSpecialInfoVO.getOvr()).append("\n");
						flatFile.append("OVH:").append(exCntrTransmitCntrSpecialInfoVO.getOvh()).append("\n");
						flatFile.append("OVLW:").append(exCntrTransmitCntrSpecialInfoVO.getOvlw()).append("\n");
						flatFile.append("OVRW:").append(exCntrTransmitCntrSpecialInfoVO.getOvrw()).append("\n");
						flatFile.append("OVWGT:").append(exCntrTransmitCntrSpecialInfoVO.getOvwgt()).append("\n");
						flatFile.append("OVWGT_UNIT:").append(exCntrTransmitCntrSpecialInfoVO.getOvwgtUnit()).append(
								"\n");
						flatFile.append("VOID_SLOT:").append(exCntrTransmitCntrSpecialInfoVO.getVoidSlot())
								.append("\n");
						flatFile.append("STWG_REQ:").append(exCntrTransmitCntrSpecialInfoVO.getStwgReq()).append("\n");
						flatFile.append("SOCIND:").append(exCntrTransmitCntrSpecialInfoVO.getSocind()).append("\n");
						flatFile.append("HAULAGE:").append(exCntrTransmitCntrSpecialInfoVO.getHaulage()).append("\n");
						flatFile.append("BKWGT:").append(exCntrTransmitCntrSpecialInfoVO.getBkwgt()).append("\n");
						flatFile.append("BKWGTU:").append(exCntrTransmitCntrSpecialInfoVO.getBkwgtu()).append("\n");
						flatFile.append("BKW:").append(exCntrTransmitCntrSpecialInfoVO.getBkw()).append("\n");
						flatFile.append("BKH:").append(exCntrTransmitCntrSpecialInfoVO.getBkh()).append("\n");
						flatFile.append("BKL:").append(exCntrTransmitCntrSpecialInfoVO.getBkl()).append("\n");
						flatFile.append("CNTROWN:").append(exCntrTransmitCntrSpecialInfoVO.getCntrown()).append("\n");
						flatFile.append("CNTRTRM:").append(exCntrTransmitCntrSpecialInfoVO.getCntrtrm()).append("\n");

						if(specialFlag.equals("DG")){
							exCntrTransmitCondVO.setInCntrNo(exCntrTransmitCntrSpecialInfoVO.getCntrnbr());
							exCntrTransmitCondVO.setInDcgoSeq(Integer.toString(k + 1));

							//구주 Container Export EDI 전송시 필요한 Danger Cgo정보를 조회 한다.
							exCntrTransmitCntrDgInfoVOs = dbDao.searchCntrExportTransmitCntrDg(exCntrTransmitCondVO);
							int exCntrTransmitCntrDgInfoVOsMaxSize = exCntrTransmitCntrDgInfoVOs.size();

							if(exCntrTransmitCntrDgInfoVOs != null && exCntrTransmitCntrDgInfoVOsMaxSize > 0){
								exCntrTransmitCntrDgInfoVO = exCntrTransmitCntrDgInfoVOs.get(0);

								flatFile.append("{CNTR_DANGER").append("\n");
								flatFile.append("UNNBR:").append(exCntrTransmitCntrDgInfoVO.getUnnbr()).append("\n");
								flatFile.append("CLASS:").append(exCntrTransmitCntrDgInfoVO.getDclass()).append("\n");
								flatFile.append("DG_DESC:").append(exCntrTransmitCntrDgInfoVO.getDgDesc()).append("\n");
								flatFile.append("PHONE:").append(exCntrTransmitCntrDgInfoVO.getPhone()).append("\n");
								flatFile.append("PAGE:").append(exCntrTransmitCntrDgInfoVO.getPage()).append("\n");
								flatFile.append("FLSH_TEMP:").append(exCntrTransmitCntrDgInfoVO.getFlshTemp()).append(
										"\n");
								flatFile.append("FLSH_UNIT:").append(exCntrTransmitCntrDgInfoVO.getFlshUnit()).append(
										"\n");
								flatFile.append("DG_REMARK:").append(exCntrTransmitCntrDgInfoVO.getDgRemark()).append(
										"\n");
								flatFile.append("EMSNO:").append(exCntrTransmitCntrDgInfoVO.getEmsno()).append("\n");
								flatFile.append("PSACLS:").append(exCntrTransmitCntrDgInfoVO.getPsacls()).append("\n");
								flatFile.append("PKGGRP:").append(exCntrTransmitCntrDgInfoVO.getPkggrp()).append("\n");
								flatFile.append("MFAG1:").append(exCntrTransmitCntrDgInfoVO.getMfag1()).append("\n");
								flatFile.append("MFAG2:").append(exCntrTransmitCntrDgInfoVO.getMfag2()).append("\n");
								flatFile.append("MAR_POLL:").append(exCntrTransmitCntrDgInfoVO.getMarPoll()).append(
										"\n");
								flatFile.append("LABEL_CD:").append(exCntrTransmitCntrDgInfoVO.getLabelCd()).append(
										"\n");
								flatFile.append("LABEL_DESC:").append(exCntrTransmitCntrDgInfoVO.getLabelDesc())
										.append("\n");
								flatFile.append("D_PKG:").append(exCntrTransmitCntrDgInfoVO.getDPkg()).append("\n");
								flatFile.append("D_PKGUNIT:").append(exCntrTransmitCntrDgInfoVO.getDPkgunit()).append(
										"\n");
								flatFile.append("NWGT:").append(exCntrTransmitCntrDgInfoVO.getNwgt()).append("\n");
								flatFile.append("NWGT_UNIT:").append(exCntrTransmitCntrDgInfoVO.getNwgtUnit()).append(
										"\n");
								flatFile.append("GWGT:").append(exCntrTransmitCntrDgInfoVO.getGwgt()).append("\n");
								flatFile.append("GWGT_UNIT:").append(exCntrTransmitCntrDgInfoVO.getGwgtUnit()).append(
										"\n");
								flatFile.append("MEA:").append(exCntrTransmitCntrDgInfoVO.getMea()).append("\n");
								flatFile.append("MEA_UNIT:").append(exCntrTransmitCntrDgInfoVO.getMeaUnit()).append(
										"\n");
								flatFile.append("HAZ_CONT:").append(exCntrTransmitCntrDgInfoVO.getHazCont()).append(
										"\n");
								flatFile.append("STWG:").append(exCntrTransmitCntrDgInfoVO.getStwg()).append("\n");
								flatFile.append("LABEL:").append(exCntrTransmitCntrDgInfoVO.getLabel()).append("\n");
								flatFile.append("}CNTR_DANGER").append("\n");
							}
						}

						exCntrTransmitCondVO.setInCntrNo(exCntrTransmitCntrSpecialInfoVO.getCntrnbr());
						//구주 Container Export EDI 전송시 필요한 Container Description DATA를 조회 한다.
						exCntrTransmitCntrDescInfoVOs = dbDao.searchCntrExportTransmitCntrDesc(exCntrTransmitCondVO);

						if(exCntrTransmitCntrDescInfoVOs != null && exCntrTransmitCntrDescInfoVOs.size() > 0){
							int exCntrTransmitCntrDescInfoVOsMaxSize = exCntrTransmitCntrDescInfoVOs.size();
							for(int m = 0; m < exCntrTransmitCntrDescInfoVOsMaxSize; m++){
								exCntrTransmitCntrDescInfoVO = exCntrTransmitCntrDescInfoVOs.get(m);
								flatFile.append("{CNTR_DESC").append("\n");
								flatFile.append("D_CMDT:").append(exCntrTransmitCntrDescInfoVO.getDCmdt()).append("\n");
								flatFile.append("D_PUNIT:").append(exCntrTransmitCntrDescInfoVO.getDPunit()).append(
										"\n");
								flatFile.append("D_PKG:").append(exCntrTransmitCntrDescInfoVO.getDPkg()).append("\n");
								flatFile.append("D_WGT:").append(exCntrTransmitCntrDescInfoVO.getDWgt()).append("\n");
								flatFile.append("D_MEAS:").append(exCntrTransmitCntrDescInfoVO.getDMeas()).append("\n");
								flatFile.append("D_DESC:").append(exCntrTransmitCntrDescInfoVO.getDDesc()).append("\n");

								if(exCntrTransmitCntrDescInfoVO.getDMark().length() > 0){
									flatFile.append("{CUS_MARK").append("\n");
									flatFile.append("D_DESC:").append(exCntrTransmitCntrDescInfoVO.getDMark()).append(
											"\n");
									flatFile.append("}CUS_MARK").append("\n");
									flatFile.append("}CNTR_DESC").append("\n");
								}else{
									flatFile.append("}CNTR_DESC").append("\n");
								}
							}

						}

						flatFile.append("}CNTR_INFO").append("\n");
					}
				}

				//구주 Container Export EDI 전송시 필요한 Container Type별 Qty를 조회 한다.
				exCntrTransmitCntrQtyInfoVOs = dbDao.searchCntrExportTransmitCntrQty(exCntrTransmitCondVO);
				int exCntrTransmitCntrQtyInfoVOsMaxSize = exCntrTransmitCntrQtyInfoVOs.size();

				if(exCntrTransmitCntrQtyInfoVOs != null && exCntrTransmitCntrQtyInfoVOsMaxSize > 0){

					for(int k = 0; k < exCntrTransmitCntrQtyInfoVOsMaxSize; k++){
						exCntrTransmitCntrQtyInfoVO = exCntrTransmitCntrQtyInfoVOs.get(k);
						flatFile.append("{QTY").append("\n");
						flatFile.append("HANTYPE:").append(exCntrTransmitCntrQtyInfoVO.getHantype()).append("\n");
						flatFile.append("COUNT:").append(exCntrTransmitCntrQtyInfoVO.getCount()).append("\n");
						flatFile.append("QTYWGT:").append(exCntrTransmitCntrQtyInfoVO.getQtywgt()).append("\n");
						flatFile.append("}QTY").append("\n");
					}
				}

				//구주 Container Export EDI 전송시 필요한 Booking no별 VVD정보를 조회 한다.
				exCntrTransmitCntrBkgVvdInfoVOs = dbDao.searchCntrExportTransmitCntrBkgVvd(exCntrTransmitCondVO);
				int exCntrTransmitCntrBkgVvdInfoVOsMaxSize = exCntrTransmitCntrBkgVvdInfoVOs.size();

				if(exCntrTransmitCntrBkgVvdInfoVOs != null && exCntrTransmitCntrBkgVvdInfoVOsMaxSize > 0){

					for(int k = 0; k < exCntrTransmitCntrBkgVvdInfoVOsMaxSize; k++){
						exCntrTransmitCntrBkgVvdInfoVO = exCntrTransmitCntrBkgVvdInfoVOs.get(k);
						flatFile.append("{BKGVVD").append("\n");
						flatFile.append("BVVD1:").append(exCntrTransmitCntrBkgVvdInfoVO.getBvvd1()).append("\n");
						flatFile.append("VSL_CALLSIGN1:").append(exCntrTransmitCntrBkgVvdInfoVO.getVslCallsign1())
								.append("\n");
						flatFile.append("VSL_LLOYDCODE1:").append(exCntrTransmitCntrBkgVvdInfoVO.getVslLloydcode1())
								.append("\n");
						flatFile.append("VSL_FULLNAME1:").append(exCntrTransmitCntrBkgVvdInfoVO.getVslFullname1())
								.append("\n");
						flatFile.append("BLPOL1:").append(exCntrTransmitCntrBkgVvdInfoVO.getBlpol1()).append("\n");
						flatFile.append("POL_FULLNAME1:").append(exCntrTransmitCntrBkgVvdInfoVO.getPolFullname1())
								.append("\n");
						flatFile.append("BLPOD1:").append(exCntrTransmitCntrBkgVvdInfoVO.getBlpod1()).append("\n");
						flatFile.append("POD_FULLNAME1:").append(exCntrTransmitCntrBkgVvdInfoVO.getPodFullname1())
								.append("\n");
						flatFile.append("POLETA1:").append(exCntrTransmitCntrBkgVvdInfoVO.getPoleta1()).append("\n");
						flatFile.append("POLETD1:").append(exCntrTransmitCntrBkgVvdInfoVO.getPoletd1()).append("\n");
						flatFile.append("PODETA1:").append(exCntrTransmitCntrBkgVvdInfoVO.getPodeta1()).append("\n");
						flatFile.append("PODETD1:").append(exCntrTransmitCntrBkgVvdInfoVO.getPodetd1()).append("\n");
						flatFile.append("OP_CODE:").append(exCntrTransmitCntrBkgVvdInfoVO.getOpCode()).append("\n");
						flatFile.append("}BKGVVD").append("\n");
					}
				}
				flatFile.append("}BL_INFO").append("\n");

				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_VENDOR.IBMMQ.QUEUE"));

				FlatFileAckVO flatFileAckVO = bkgUtil.sendFlatFile(sendFlatFileVO);

				if(flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[]{}).getMessage());
				
				BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(exCntrTransmitCondVO.getFormBkgNo());
				bkgNtcHisVO.setNtcViaCd("E");
				bkgNtcHisVO.setNtcKndCd("EX");
				bkgNtcHisVO.setEdiId(rcvId);
				bkgNtcHisVO.setBkgNtcSndRsltCd(flatFileAckVO.getAckStsCd());
				bkgNtcHisVO.setSndId("SMLINE");
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
				
				bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
		
			}
			
			
		}catch(EventException ex){
			throw ex;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * 미주 터미널에 보낼 엑셀 형식의 데이터와 비교할 NIS 데이터를 조회한다.<br>
	 * 
	 * @param CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO
	 * @return List<CllCdlCheckUsaVO>
	 * @exception EventException
	 */
	public List<CllCdlCheckUsaVO> searchCllCdlCheckForUS(CllCdlCheckUsaCondVO cllCdlCheckUsaCondVO)
			throws EventException{
		try{
			//미주 터미널에 보낼 엑셀 형식의 데이터와 비교할 NIS 데이터를 조회한다.
			return dbDao.searchCllCdlCheckForUS(cllCdlCheckUsaCondVO);
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param KorCllCdlCondVO korCllCdlCondVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, KorCllCdlCondVO korCllCdlCondVO, String pgmNo) throws EventException{
		CLLCDLManifestBackEndJob backEndJob = new CLLCDLManifestBackEndJob();
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try{
			if(pgmNo.equals("ESM_BKG_0159_SEARCH")){
				backEndJob.setKorCllCdlCondVO(korCllCdlCondVO);
				backEndJob.setSignOnUserAccount(account);
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "CLLCDL Search.");
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		return resultStr;
	}

	/**
	 * 전송 이벤트 처리<br>
	 * CLL 수신 처리.<br>
	 * 
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void receiveUdevhjsAlpsBkgCllAck(String flatFile, SignOnUserAccount account) throws EventException{
		try{
			StringTokenizer token = new StringTokenizer(flatFile, "\n");
			ArrayList tmpArray = new ArrayList();
			while(token.hasMoreTokens()){
				tmpArray.add(token.nextToken());
			}

			String userId = flatFile.substring(12, 32).trim();

			if(flatFile.substring(0, 6).equals("$$$MSG")){
				for(int i = 1; i < tmpArray.size(); i++){
					String lineString = tmpArray.get(i).toString();
					if(lineString.length() > 270){
						String inHeader = lineString.substring(0, 18);
						String inSender = lineString.substring(18, 38);
						String inYard = lineString.substring(38, 45);
						String inData = lineString.substring(45, 48);
						String inVvd = lineString.substring(48, 57);
						String inCall = lineString.substring(57, 66);
						String inVslname = lineString.substring(66, 96);
						String inPol = lineString.substring(96, 101);
						String inPod = lineString.substring(101, 106);
						String inBkg = lineString.substring(106, 119);
						String inCntr = lineString.substring(119, 130);
						String inSeala = lineString.substring(130, 140);
						String inSealb = lineString.substring(140, 150);
						String inDate = lineString.substring(150, 162);
						String inStwg = lineString.substring(162, 182);
						//String inStra = lineString.substring(182, 186);
						//String inStrl = lineString.substring(186, 194);
						String inTran = lineString.substring(194, 195);
						String inFpod = lineString.substring(195, 200);
						String inCntrio = lineString.substring(200, 201);
						//String inUnit = lineString.substring(201, 204);
						String inGross = lineString.substring(204, 222);
						String inTare = lineString.substring(222, 226);
						String inCntrfm = lineString.substring(226, 227);
						String inImo = lineString.substring(227, 228);
						String inRf = lineString.substring(228, 229);
						String inImocd = lineString.substring(229, 236);
						String inCarr = lineString.substring(236, 246);
						String inCntrts = lineString.substring(246, 248);
						String inDam = lineString.substring(248, 249);
						String inCusdec = lineString.substring(249, 269);
						//String inEol = lineString.substring(269, 272);

						
						String inTemp = "";

						if(inCntrfm.equals("5") && inImo.equals("N") && inRf.equals("N"))
							inTemp = "0";
						if(inCntrfm.equals("5") && inImo.equals("N") && inRf.equals("Y"))
							inTemp = "1";
						if(inCntrfm.equals("5") && inImo.equals("Y") && inRf.equals("N"))
							inTemp = "2";
						if(inCntrfm.equals("4"))
							inTemp = "9";

						if(inData.equals("CDL") && inPol.equals(""))
							inPol = "XXXXX";

						String inVvdcll = "";

						//CLL 수신처리시 VSL_CD 찾기
						inVvdcll = dbDao.searchVslCdForReceive("1", inCall);

						if(inVvdcll.equals(""))
							inVvdcll = dbDao.searchVslCdForReceive("2", inVslname);
						if(inVvdcll.equals(""))
							inVvdcll = dbDao.searchVslCdForReceive("3", inVslname);
						if(inVvdcll.equals(""))
							inVvdcll = dbDao.searchVslCdForReceive("4", inCall);
						if(inVvdcll.equals(""))
							inVvdcll = dbDao.searchVslCdForReceive("5", inCall);
						if(inVvdcll.equals(""))
							inVvdcll = dbDao.searchVslCdForReceive("6", inVslname);

						//CLL 수신처리시 VVD_CD 찾기
						List<CLLCDLManifestSearchVvdCdForRecieveInfoVO> cLLCDLManifestSearchVvdCdForRecieveInfoVOs = dbDao
								.searchVvdCdForRecieve(inVvdcll, inVvd);
						String inVslcd = "";
						String inVslvoy = "";
						String inVsldir = "";

						if(cLLCDLManifestSearchVvdCdForRecieveInfoVOs.size() > 0){
							if(cLLCDLManifestSearchVvdCdForRecieveInfoVOs.get(0).getInVslcd().length() != 4)
								inVslcd = inVvdcll;
							else 
								inVslcd = cLLCDLManifestSearchVvdCdForRecieveInfoVOs.get(0).getInVslcd();
							
							if(cLLCDLManifestSearchVvdCdForRecieveInfoVOs.get(0).getInVslvoy().length() != 4)
								inVslvoy = inVvd.substring(0, 4);
							else
								inVslvoy = cLLCDLManifestSearchVvdCdForRecieveInfoVOs.get(0).getInVslvoy();
							
							if(cLLCDLManifestSearchVvdCdForRecieveInfoVOs.get(0).getInVsldir().length() != 1)
								inVsldir = inVvd.substring(4, 5);
							else
								inVsldir = cLLCDLManifestSearchVvdCdForRecieveInfoVOs.get(0).getInVsldir();
						}else{
							inVslcd = inVvdcll;
							inVslvoy = inVvd.substring(0, 4);
							inVsldir = inVvd.substring(4, 5);
						}

						if(!inData.equals("CDL") && cLLCDLManifestSearchVvdCdForRecieveInfoVOs.size() > 0){
							//CLL 수신처리시 Data 존재여부 Search
							if(dbDao.searchDataExist(inVslcd, inVslvoy, inVsldir, inCntr) < 1){
								//CLL 수신처리시 Data 존재여부 Search2
								if(dbDao.searchDataExist2(inVslcd, inVslvoy, inVsldir) > 0){
									BkgCstmsTmlCllVO bkgCstmsTmlCllVO = new BkgCstmsTmlCllVO();
									bkgCstmsTmlCllVO.setVslCd(inVslcd);
									bkgCstmsTmlCllVO.setSkdVoyNo(inVslvoy);
									bkgCstmsTmlCllVO.setSkdDirCd(inVsldir);
									bkgCstmsTmlCllVO.setPortCd(inPol);
									bkgCstmsTmlCllVO.setBkgNo(inBkg);
									bkgCstmsTmlCllVO.setCntrNo(inCntr);
									bkgCstmsTmlCllVO.setCreUsrId(userId);

									//CLL 수신처리시 Terminal Cll 등록
									dbDao.addTmlCllForRecieve(bkgCstmsTmlCllVO);
								}
							}else{
								//Container Loading List(Korea) 전송 후 CLL Update Date를 업데이트 한다.
								dbDao.modifyCllForRecieve(inVslcd, inVslvoy, inVsldir, inCntr, userId);
							}
						}

						if(inData.equals("CLL")){
							//CLL 수신처리시 Data 존재여부 Search
							if(dbDao.searchDataExist(inVslcd, inVslvoy, inVsldir, inCntr) < 1){
								BkgCstmsTmlEurVO bkgCstmsTmlEurVO = new BkgCstmsTmlEurVO();
								bkgCstmsTmlEurVO.setEdiSndrId(inSender);
								bkgCstmsTmlEurVO.setEvntYdCd(inYard);
								bkgCstmsTmlEurVO.setTmlVvdId(inVslcd + inVslvoy + inVsldir);
								bkgCstmsTmlEurVO.setPolCd(inPol);
								bkgCstmsTmlEurVO.setPodCd(inPod);
								bkgCstmsTmlEurVO.setCntrNo(inCntr);
								bkgCstmsTmlEurVO.setCoRptId(inCarr);
								bkgCstmsTmlEurVO.setCallSgnNo(inCall);
								bkgCstmsTmlEurVO.setVslNm(inVslname);
								bkgCstmsTmlEurVO.setBkgNo(inBkg);
								bkgCstmsTmlEurVO.setCntrSealNo(inSeala);
								bkgCstmsTmlEurVO.setCntrLdisDt(inDate);
								bkgCstmsTmlEurVO.setStwgCellNo(inStwg);
								bkgCstmsTmlEurVO.setEdiRptHdrMsg(inHeader);
								bkgCstmsTmlEurVO.setEdiRptMsg(lineString);
								bkgCstmsTmlEurVO.setCrrCd(inCarr);
								bkgCstmsTmlEurVO.setCntrTpszCd(inCntrts);
								bkgCstmsTmlEurVO.setCntrSealNo2(inSealb);
								bkgCstmsTmlEurVO.setCgoStsId(inCntrio);
								bkgCstmsTmlEurVO.setN1stPodCd(inFpod);
								bkgCstmsTmlEurVO.setGrsWgt(inGross);
								bkgCstmsTmlEurVO.setCgoTpCd(inTemp);
								bkgCstmsTmlEurVO.setImdgClssId(inImocd);
								bkgCstmsTmlEurVO.setEurTmlDmgId(inDam);
								bkgCstmsTmlEurVO.setTrspModId(inTran);
								bkgCstmsTmlEurVO.setExpDt(inDate);
								bkgCstmsTmlEurVO.setCstmsDeclNo(inCusdec);
								bkgCstmsTmlEurVO.setCntrTareWgt(inTare);
								bkgCstmsTmlEurVO.setTmlMsgMtchId("R");
								bkgCstmsTmlEurVO.setCntrLodgDchgCd("L");
								bkgCstmsTmlEurVO.setCreUsrId(userId);

								//CLL 수신처리시 Terminal Eur 등록
								dbDao.addTmlEurForRecieve(bkgCstmsTmlEurVO);
							}else{
								//CLL 수신처리시 Data 존재여부 Search3
								if(dbDao.searchDataExist3(inVslcd, inVslvoy, inVsldir, inCntr) > 0){
									BkgCstmsTmlEurVO bkgCstmsTmlEurVO = new BkgCstmsTmlEurVO();
									bkgCstmsTmlEurVO.setEdiSndrId(inSender);
									bkgCstmsTmlEurVO.setEvntYdCd(inYard);
									bkgCstmsTmlEurVO.setTmlVvdId(inVslcd + inVslvoy + inVsldir);
									bkgCstmsTmlEurVO.setPolCd(inPol);
									bkgCstmsTmlEurVO.setPodCd(inPod);
									bkgCstmsTmlEurVO.setCntrNo(inCntr);
									bkgCstmsTmlEurVO.setCoRptId(inCarr);
									bkgCstmsTmlEurVO.setCallSgnNo(inCall);
									bkgCstmsTmlEurVO.setVslNm(inVslname);
									bkgCstmsTmlEurVO.setBkgNo(inBkg);
									bkgCstmsTmlEurVO.setCntrSealNo(inSeala);
									bkgCstmsTmlEurVO.setCntrLdisDt(inDate);
									bkgCstmsTmlEurVO.setStwgCellNo(inStwg);
									bkgCstmsTmlEurVO.setEdiRptHdrMsg(inHeader);
									bkgCstmsTmlEurVO.setEdiRptMsg(lineString);
									bkgCstmsTmlEurVO.setCrrCd(inCarr);
									bkgCstmsTmlEurVO.setCntrTpszCd(inCntrts);
									bkgCstmsTmlEurVO.setCntrSealNo2(inSealb);
									bkgCstmsTmlEurVO.setCgoStsId(inCntrio);
									bkgCstmsTmlEurVO.setN1stPodCd(inFpod);
									bkgCstmsTmlEurVO.setGrsWgt(inGross);
									bkgCstmsTmlEurVO.setCgoTpCd(inTemp);
									bkgCstmsTmlEurVO.setImdgClssId(inImocd);
									bkgCstmsTmlEurVO.setEurTmlDmgId(inDam);
									bkgCstmsTmlEurVO.setTrspModId(inTran);
									bkgCstmsTmlEurVO.setExpDt(inDate);
									bkgCstmsTmlEurVO.setCstmsDeclNo(inCusdec);
									bkgCstmsTmlEurVO.setCntrTareWgt(inTare);
									bkgCstmsTmlEurVO.setTmlMsgMtchId("R");
									bkgCstmsTmlEurVO.setCntrLodgDchgCd("L");
									bkgCstmsTmlEurVO.setCreUsrId(userId);

									//CLL 수신처리시 Terminal Eur 등록
									dbDao.addTmlEurForRecieve(bkgCstmsTmlEurVO);
								}else{
									BkgCstmsTmlEurVO bkgCstmsTmlEurVO = new BkgCstmsTmlEurVO();
									bkgCstmsTmlEurVO.setEdiSndrId(inSender);
									bkgCstmsTmlEurVO.setEvntYdCd(inYard);
									bkgCstmsTmlEurVO.setTmlVvdId(inVslcd + inVslvoy + inVsldir);
									bkgCstmsTmlEurVO.setPolCd(inPol);
									bkgCstmsTmlEurVO.setPodCd(inPod);
									bkgCstmsTmlEurVO.setCntrNo(inCntr);
									bkgCstmsTmlEurVO.setCoRptId(inCarr);
									bkgCstmsTmlEurVO.setCallSgnNo(inCall);
									bkgCstmsTmlEurVO.setVslNm(inVslname);
									bkgCstmsTmlEurVO.setBkgNo(inBkg);
									bkgCstmsTmlEurVO.setCntrSealNo(inSeala);
									bkgCstmsTmlEurVO.setCntrLdisDt(inDate);
									bkgCstmsTmlEurVO.setStwgCellNo(inStwg);
									bkgCstmsTmlEurVO.setEdiRptHdrMsg(inHeader);
									bkgCstmsTmlEurVO.setEdiRptMsg(lineString);
									bkgCstmsTmlEurVO.setCrrCd(inCarr);
									bkgCstmsTmlEurVO.setCntrTpszCd(inCntrts);
									bkgCstmsTmlEurVO.setCntrSealNo2(inSealb);
									bkgCstmsTmlEurVO.setCgoStsId(inCntrio);
									bkgCstmsTmlEurVO.setN1stPodCd(inFpod);
									bkgCstmsTmlEurVO.setGrsWgt(inGross);
									bkgCstmsTmlEurVO.setCgoTpCd(inTemp);
									bkgCstmsTmlEurVO.setImdgClssId(inImocd);
									bkgCstmsTmlEurVO.setEurTmlDmgId(inDam);
									bkgCstmsTmlEurVO.setTrspModId(inTran);
									bkgCstmsTmlEurVO.setExpDt(inDate);
									bkgCstmsTmlEurVO.setCstmsDeclNo(inCusdec);
									bkgCstmsTmlEurVO.setCntrTareWgt(inTare);
									bkgCstmsTmlEurVO.setTmlMsgMtchId("M");
									bkgCstmsTmlEurVO.setCntrLodgDchgCd("L");
									bkgCstmsTmlEurVO.setCreUsrId(userId);

									//CLL 수신처리시 Terminal Eur 등록
									dbDao.addTmlEurForRecieve(bkgCstmsTmlEurVO);
								}
							}
						}else if(inData.equals("CDL")){
							BkgCstmsTmlEurVO bkgCstmsTmlEurVO = new BkgCstmsTmlEurVO();
							bkgCstmsTmlEurVO.setEdiSndrId(inSender);
							bkgCstmsTmlEurVO.setEvntYdCd(inYard);
							bkgCstmsTmlEurVO.setTmlVvdId(inVslcd + inVslvoy + inVsldir);
							bkgCstmsTmlEurVO.setPolCd(inPol);
							bkgCstmsTmlEurVO.setPodCd(inPod);
							bkgCstmsTmlEurVO.setCntrNo(inCntr);
							bkgCstmsTmlEurVO.setCoRptId(inCarr);
							bkgCstmsTmlEurVO.setCallSgnNo(inCall);
							bkgCstmsTmlEurVO.setVslNm(inVslname);
							bkgCstmsTmlEurVO.setBkgNo(inBkg);
							bkgCstmsTmlEurVO.setCntrSealNo(inSeala);
							bkgCstmsTmlEurVO.setCntrLdisDt(inDate);
							bkgCstmsTmlEurVO.setStwgCellNo(inStwg);
							bkgCstmsTmlEurVO.setEdiRptHdrMsg(inHeader);
							bkgCstmsTmlEurVO.setEdiRptMsg(lineString);
							bkgCstmsTmlEurVO.setCrrCd(inCarr);
							bkgCstmsTmlEurVO.setCntrTpszCd(inCntrts);
							bkgCstmsTmlEurVO.setCntrSealNo2(inSealb);
							bkgCstmsTmlEurVO.setCgoStsId(inCntrio);
							bkgCstmsTmlEurVO.setN1stPodCd(inFpod);
							bkgCstmsTmlEurVO.setGrsWgt(inGross);
							bkgCstmsTmlEurVO.setCgoTpCd(inTemp);
							bkgCstmsTmlEurVO.setImdgClssId(inImocd);
							bkgCstmsTmlEurVO.setEurTmlDmgId(inDam);
							bkgCstmsTmlEurVO.setTrspModId(inTran);
							bkgCstmsTmlEurVO.setExpDt(inDate);
							bkgCstmsTmlEurVO.setCstmsDeclNo(inCusdec);
							bkgCstmsTmlEurVO.setCntrTareWgt(inTare);
							bkgCstmsTmlEurVO.setTmlMsgMtchId("");
							bkgCstmsTmlEurVO.setCntrLodgDchgCd("D");
							bkgCstmsTmlEurVO.setCreUsrId(userId);

							//CLL 수신처리시 Terminal Eur 등록
							dbDao.addTmlEurForRecieve(bkgCstmsTmlEurVO);
						}
					}
				}
			}
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob을 실행. 
	 * 
	 * @param SignOnUserAccount account
	 * @param CllCdlTransmitVO[] cllCdlTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, CllCdlTransmitVO[] cllCdlTransmitVOs, String pgmNo)
			throws EventException{
		CLLCDLManifestBackEndJob backEndJob = new CLLCDLManifestBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try{
			if(pgmNo.equals("ESM_BKG_0723")){
				backEndJob.setCllCdlTransmitVOs(cllCdlTransmitVOs);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "CLLCDL Transmit.");
			}

		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}

		return resultStr;
	}	
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param TerminalCllVO[] terminalCllVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, TerminalCllVO[] terminalCllVOs, String pgmNo)
			throws EventException{
		CLLCDLManifestBackEndJob backEndJob = new CLLCDLManifestBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try{
			if(pgmNo.equals("ESM_BKG_0159")){
				backEndJob.setTerminalCllVOs(terminalCllVOs);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "CLL Download.");
			}
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		return resultStr;
	}	
	
	
	/**
	 * EDI 로 전송된 CLL 상의 Booking 데이터와 B/L Data Input Cross-Check 상의 Booking 데이터를 대조하여 Un-match된 항목을 보여준다. <br>
	 * 
	 * @param KorCllCrossChkCondVO korCllCrossChkCondVO
	 * @return List<KorCllCrossChkCondVO>
	 * @exception EventException
	 */
	public List<KorCllCrossChkCondVO> searchKorCllCrossCheck(KorCllCrossChkCondVO korCllCrossChkCondVO) throws EventException{		
		List<KorCllCrossChkCondVO> korCllCrossChkCondVOs = null;
		try{			
			korCllCrossChkCondVOs = dbDao.searchKorCllCrossCheck(korCllCrossChkCondVO);
			
			return korCllCrossChkCondVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 *  ESM_BKG_1153 : SEARCH <br>
	 *  VVD 정보 조회<br>
	 * 
	 * @param PreAdviceVO preAdviceVO
	 * @return List<PreAdviceVvdInfoVO>
	 * @exception EventException
	 */
	public List<PreAdviceVvdInfoVO> searchPreAdviceVvdInfo(PreAdviceVO preAdviceVO) throws EventException{		
		List<PreAdviceVvdInfoVO> preAdviceVvdInfoVOs = null;
		try{			
			preAdviceVvdInfoVOs = dbDao.searchPreAdviceVvdInfo(preAdviceVO);
			
			return preAdviceVvdInfoVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  ESM_BKG_1153 : SEARCH01 <br>
	 *  VVD 정보 조회<br>
	 * 
	 * @param PreAdviceVO preAdviceVO
	 * @return List<PreAdviceManifestListVO>
	 * @exception EventException
	 */
	public List<PreAdviceManifestListVO> searchPreAdviceManifestList(PreAdviceVO preAdviceVO) throws EventException{		
		List<PreAdviceManifestListVO> preAdviceManifestListVOs = null;
		try{			
			preAdviceManifestListVOs = dbDao.searchPreAdviceManifestList(preAdviceVO);
			
			return preAdviceManifestListVOs;
		}catch(DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
	}
}
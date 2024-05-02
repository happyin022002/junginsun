/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ContainerMovementMgtBCImpl.java
 * @FileTitle : CNTR History Update
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.05.08
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.05.08 우경민 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.03 김상수 [소스품질관리] 중첩try문 3건 제거
 *                   - 연관파일 ContainerMovementMgtDBDAO.java도 수정
 * 2010.09.09 김상수 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
 *                   - autoCre, manageStsOperation 2개 메서드 수정
 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
 *                     자동생성 로직이 탈수있도록 소스수정
 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
 * 2011.01.06 김상수 [CHM-201108196-01] [CTM] Domestic Movement Creation 과거 data 입력 관련 보완
 *                    Domestic Movement 생성기능에서 과거년도 Data를 수동으로 입력할때 Movement Data년도도 과거년도로 저장되는 오류수정
 *                    1. Domestic Movement 관련된 부분의 data는 과거 data를 기반으로 반영
 *                    2. Movement 관련된 부분의 data는 현재 진행되는 data에 id를 증가시켜 반영
 * 2011.01.19 김상수 [CHM-201108428-01] [CTM] Domestic Movement Street Turn 보완
 *                    - ID status 이후 CO status 입력시 Domestic Booking 생성일을 기준으로
 *                      data 생성 시 사용되는 DateTime포맷 변경
 * 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
 * 2011.10.28 신자영 [CHM-201114074-01] [CTM] VL/VD시 Origin Yard code 입력오류 확인 기능 추가
 * 2012.05.11 문동선 [CHM-201217638-01] [CTM] Cntr가 VD/MT 상태에서(MT BKG), OP/OC 없이 O/B에 attach되어 있을 경우, 
 * 											Cntr를 O/B Bkg에서 dettach 한 후 VD delete하도록 보완
 * 2013.01.14 문동선 [CHM-201222197-01] [CTM] MT-EN이후 동일한 LCC에서 MT 생성시, 이미 생성한 EN은 TN으로 auto update
 * 2013.03.07 강  환 [CHM-201323292-01] 현재 Movement가 OC이고, 전전 Movement가 MT면 직전 Movement를 변경하지 않는다
 * 2013.03.13 문동선 [CHM-201323498-01] ALPS Maater-Status에서 SOC 장비의 OC/OP상태에서 Movement XX 처리 로직 Upgarde 요청
 * 2013.03.26 강  환 [CHM-201323424-01] ID이후 CP/CO가 생성되어 MT가 auto 생성되는 경우  MT는 직전  Movement 의  Bkg로 처리   
 * 2013.04.17 김현화 [CHM-201324017-01] Movement 화면상 Manual 수정대상 I/F 로직 보완
 * 2013.08.02 강  환 [CHM-201325779] Auto 생성된  MVMT의 Bkg 과 B/L을 동일하게 유지  
 * 2013.09.11 강  환 [CHM-201325902] VVD 변경시에도 SCE로 I/F 하도록 로직 수정
 * 2013.09.24 강  환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF) 
 * 2013.11.21 최덕우 [CHM-201327563] Master 모듈에서 SCE를 호출하여 Data I/F 할 수 있도록 Return 처리
 * 2014.01.13 최덕우 [CHM-201327924-01] [CTM]  VL/VD Correction by VVD 수정가능 항목 추가
 * 2015.10.16 김상현 [CHM-201538334] CTM : OP-> CP 변경 logic추가
 *                   - 이전 단계가 OP이고, 현재 단계가 CD, CE, CI, CO, CP이면 OP → CP로 변환하는 Logic 추가
 * 2015.12.28 김상현 [CHM-201539302] CP이후 Domestic Bkg이 없는 경우, 이후 Domestic Mvvement 추가
 * 2016.02.12 김상현 [CHM-201639830] CTM: Domestic MVMT CM 자동생성 logic 변경
 * 2016.02.17 김상현 [CHM-201640053] 동일 CYC#의 mvmt는 최신 Bkg으로 Update
 * 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
 * 2015.09.22 김상현 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
 * 2016.07.29 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CheckBookingVO;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CntrMvmtSeqInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtEAIDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgContainerLastVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgVVDInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmMovementHisColVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.EventDateUpdateHistoryParmVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MultiBkgNoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.NextShipExistsVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EquipmentMovementMgt Business Logic Command Interface
 * - ALPS-EquipmentMovementMgt에 대한 비지니스 로직에 대한 인터페이스
 * @author 우경민
 * @see Ees_ctm_0404EventResponse, ContainerMovementMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0406EventResponse, ContainerMovementMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0409EventResponse, ContainerMovementMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0422EventResponse, ContainerMovementMgtBC 각 DAO 클래스 참조
 * @see Ees_ctm_0456EventResponse, ContainerMovementMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.5
 * 2009.4.24
*/
public class ContainerMovementMgtBCImpl extends BasicCommandSupport implements ContainerMovementMgtBC {

	// Database Access Object
	private transient ContainerMovementMgtDBDAO dbDao = null;

	/**
	 * ContainerMovementMgtBCImpl 객체 생성<br>
	 * ContainerMovementMgtDBDAO를 생성한다.<br>
	 */
	public ContainerMovementMgtBCImpl() {
		dbDao = new ContainerMovementMgtDBDAO();
	}

	/**
	 * Container Movement Histoy Retrive Button Event. <br>
	 * 컨테이너 이동정보 조회
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws EventException
	 */
	public List<MVMTHistoryListVO> searchMVMTHistoryList(MVMTHistoryListVO mvmtHistoryListVO) throws EventException {
		try {
			return dbDao.searchMVMTHistoryList(mvmtHistoryListVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Container Movement Histoy Retrive Button Event. <br>
	 * Container 이동정보의 Booking 정보 조회
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @param String cntCd
	 * @return List<MVMTBookingInfoVO>
	 * @throws EventException
	 */
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTHistoryListVO, String cntCd) throws EventException {
		try {
			return dbDao.searchBookingInfoList(mVMTHistoryListVO, cntCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Container Movement Histoy Save Button Event. <br>
	 * 컨테이너 이동정보 갱신
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @param MVMTBookingInfoVO[] mvmtBookingInfoVOs
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @exception EventException
	 */
	public CrossItemVO modifyMVMTHistory(CusCtmMovementVO[] cusCtmMovementVOs, MVMTBookingInfoVO[] mvmtBookingInfoVOs, SignOnUserAccount account) throws EventException {
		CrossItemVO nVO = new CrossItemVO();
		log.info("HISTORY 시작 ::: " + cusCtmMovementVOs.length);
		String sendEdiSts = "";
		try {
			List<CusCtmMovementVO> insertVoList = new ArrayList<CusCtmMovementVO>();
			List<CusCtmMovementVO> updateVoList = new ArrayList<CusCtmMovementVO>();
			List<CusCtmMovementVO> deleteVoList = new ArrayList<CusCtmMovementVO>();
			int insertCnt = 1;

			CusCtmMovementVO mstVO = new CusCtmMovementVO();
			List<CusCtmMovementVO> cgmVo = new ArrayList<CusCtmMovementVO>();
			List<SceActRcvIfVO> sceVOs = new ArrayList<SceActRcvIfVO>();
			/**********************************************************************
			 * VO List의 마지막이 삭제인지 확인 후 삭제일 경우 최종 자료인지 확인한다 *
			 **********************************************************************/
			int lstFlgLine = -1;
			// 마지막 Row를 찾기위해서 앞에서부터 lstFlgLine을 체크
			nVO.setBkgVO(null);
			for (int i=0; i < cusCtmMovementVOs.length; i++) {
				if ("1".equals(mvmtBookingInfoVOs[i].getLstFlg()) || "X".equals(mvmtBookingInfoVOs[i].getLstFlg())) {
					lstFlgLine = i;
					break;
				} else if ("O".equals(mvmtBookingInfoVOs[i].getLstFlg())) {
					// 최초 생성된 OC가 변경 되었을 경우 Booking을 호출해준다.
					nVO.setBkgVO(cusCtmMovementVOs[i]);
				}
			}

			String cntrNo = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getCntrNo();
			boolean sendEdiFlg = false;
			String lstStsCd = "";
			CusCtmMovementVO ediSendVO = null;
			nVO.setFinalCfm("0");
			nVO.setFinalCfm("E");
			
			

			// 마지막 Row를 읽고 (lstFlgLine이 1로세팅되어있으면 마지막으로 간주한다)
			// Booking에서 Final Confirm되어있는지 체크한다. OP/VL에서만 해당하고 그렇지 않은 경우 패스한다.
			// FinalConfirm되어있는 경우 삭제되더라도 Rollback 시켜야 한다.
			if (lstFlgLine >= 0) {
				lstStsCd = mvmtBookingInfoVOs[lstFlgLine].getMvmtStsCd();
				String cmdFlg = mvmtBookingInfoVOs[lstFlgLine].getIbflag();
				String lstFlg = mvmtBookingInfoVOs[lstFlgLine].getLstFlg();
				String bkgTp = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getBkgCgoTpCd();
				String bkgNo = mvmtBookingInfoVOs[lstFlgLine].getBkgNo();
				String cycNo = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getCnmvCycNo();
				String areaCd = (mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getOrgYdCd() == null ? "" : subStr(mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getOrgYdCd().trim(), 0, 2));
				String cnmvYr = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getCnmvYr();
				String[] finalCfm = null;

				// lstStsCd가 VL/VD이고, OrgYard 앞2자리가 KR일때 EDI를 전송
				if ("KR".equals(areaCd) && ("VL".equals(lstStsCd) || "VD".equals(lstStsCd)) && ("1".equals(lstFlg) || "X".equals(lstFlg))) {
					sendEdiFlg = true;
					sendEdiSts = lstStsCd;
					if ("VD".equals(lstStsCd)) {
						ediSendVO = dbDao.getPrevCntrInfo(cntrNo, "2");
					} else {
						ediSendVO = dbDao.getPrevCntrInfo(cntrNo, "1");
					}
				}
				
				if ("D".equals(cmdFlg) && ("1".equals(lstFlg) || "X".equals(lstFlg))) {
					
					if ("VL".equals(lstStsCd) && "P".equals(bkgTp)) {
						// 부킹이 최종 Confirm되어있는지 체크
						finalCfm = dbDao.checkFinalConfirm(bkgNo);
						if (finalCfm != null && "Y".equals(finalCfm[0])) {
							nVO.setFinalCfm("1");
						} else {
							nVO.setFinalCfm("V");
							nVO.setCaFlg(finalCfm[1]);
							nVO.setBkgNo(bkgNo);
							nVO.setCntrNo(cntrNo);
							nVO.setCycNo(cycNo);
							nVO.setCnmvYr(cnmvYr);
						}

					} else if ("OP".equals(lstStsCd)) {
						// bkgNo가 없다면
						if (bkgNo == null || "".equals(bkgNo)) {
							// FinalCfm을 X로 setting (SC에서 BKG모듈 호출없이 Commit)
							nVO.setFinalCfm("X");

						} else {
							// 부킹이 최종 Confirm되어있는지 체크
							finalCfm = dbDao.checkFinalConfirm(bkgNo);
							if (finalCfm != null && "Y".equals(finalCfm[0])) {
								// BKG_CONTAINER에 컨테이너가 존재하는지 Check
								String bkgCntrExist = dbDao.checkBkgCntrExist(cntrNo, bkgNo, cycNo);
								if (bkgCntrExist != null && !"".equals(bkgCntrExist)) {
									// FinalCfm을 1로 setting (SC에서 모든 행위 중지하고 RollBack)
									nVO.setFinalCfm("1");
								} else {
									// FinalCfm을 X로 setting (SC에서 BKG모듈 호출없이 Commit)
									nVO.setFinalCfm("X");
								}
							} else {
								nVO.setFinalCfm("O");
								nVO.setCaFlg(finalCfm[1]);
								nVO.setBkgNo(bkgNo);
								nVO.setCntrNo(cntrNo);
								nVO.setCycNo(cycNo);
								nVO.setCnmvYr(cnmvYr);
							}
						}
					} else if ("VD".equals(lstStsCd)||"MT".equals(lstStsCd)){
						// Cntr가 VD/MT 상태에서(MT BKG), OP/OC 없이 O/B에 attach되어 있을 경우, Cntr를 O/B Bkg에서 dettach 한 후 VD delete하도록 보완
						List<BkgContainerLastVO> bkgCntr = null;
						BkgContainerLastVO   bkgCntrInfo = null;

						bkgCntr = dbDao.getBkgContainerLastInfo(cntrNo, null);
						
						if(bkgCntr != null && bkgCntr.size() != 0){
							bkgCntrInfo = bkgCntr.get(0);
							if("9999".equals(bkgCntrInfo.getCnmvCycNo()) ){
								// FinalCfm을 2로 setting (SC에서 모든 행위 중지하고 RollBack)
								nVO.setFinalCfm("2");
								nVO.setBkgNo(bkgCntrInfo.getBkgNo());
							}
						}					
					}
						
				}
				lstStsCd = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getMvmtStsCd();
			}

			// 넘어온 자료를 처음부터 끝까지 하나씩 LOOP로 처리한다
			for (int i = cusCtmMovementVOs.length - 1; i >= 0 ; i--) {
				mstVO = new CusCtmMovementVO();
				cusCtmMovementVOs[i].setCreUsrId(account.getUsr_id());
				cusCtmMovementVOs[i].setUpdUsrId(account.getUsr_id());
				cusCtmMovementVOs[i].setUsrNm(account.getUsr_nm());
				cusCtmMovementVOs[i].setOfcCd(account.getOfc_cd());
				if ("I".equals(cusCtmMovementVOs[i].getIbflag())) {
					log.debug("\n신규 항목 추가 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt());
					if (cusCtmMovementVOs[i].getVvdCd() != null && !"".equals(cusCtmMovementVOs[i].getVvdCd()) && cusCtmMovementVOs[i].getVvdCd().trim().length() >= 8) {
						cusCtmMovementVOs[i].setTrnkVslCd(subStr(cusCtmMovementVOs[i].getVvdCd(), 0, 4));
						cusCtmMovementVOs[i].setTrnkSkdVoyNo(subStr(cusCtmMovementVOs[i].getVvdCd(), 4, 8));
						cusCtmMovementVOs[i].setTrnkSkdDirCd(subStr(cusCtmMovementVOs[i].getVvdCd(), 8, 9));
					}
					cusCtmMovementVOs[i].setCtrtOfcCtyCd("HHO");
					cusCtmMovementVOs[i].setMvmtInpTpCd("MAN");
					String lvlCd = dbDao.getCNTRMovSeqRSQL(cusCtmMovementVOs[i].getBkgCgoTpCd(), cusCtmMovementVOs[i].getMvmtStsCd()).getCnmvLvlNo();
					cusCtmMovementVOs[i].setCnmvLvlNo(lvlCd);

					// 2010-07-08 : 화면으로 부터 호출되는 경우 cnmv_yr을 화면으로 부터 받아와서 최종 container ID를 구함 - Rqst by IHJang
					String idNo = dbDao.getContainerMaxIdForMVMTHistory(cntrNo, mvmtBookingInfoVOs[i].getCnmvYr());
					if (idNo == null || "".equals(idNo)) {
						idNo = "0";
					} else {
						idNo = String.valueOf(Integer.parseInt(idNo)+insertCnt);
						insertCnt++;
					}
					cusCtmMovementVOs[i].setCnmvIdNo(idNo);

					log.info (cusCtmMovementVOs[i].getCnmvIdNo());
					log.info (cusCtmMovementVOs[i].getCnmvSeq());
					insertVoList.add(cusCtmMovementVOs[i]);
					/*
					//VD일 경우 POD와 Origin Yard를 비교하여 같으면 IC, 다르면 TS 자동 생성
					if("VD".equals(cusCtmMovementVOs[i].getMvmtStsCd())){
						CusCtmMovementVO tempVO = new CusCtmMovementVO();
						char ch = cusCtmMovementVOs[i].getCnmvSplitNo().charAt(0);
						int nextCh = (int)ch+1;
						Character cr  = new Character((char)nextCh);
						String nextStr = cr.toString();
						
						tempVO.setIbflag(cusCtmMovementVOs[i].getIbflag());
						tempVO.setFcntrFlg(cusCtmMovementVOs[i].getFcntrFlg());
						tempVO.setObCntrFlg(cusCtmMovementVOs[i].getObCntrFlg());
						tempVO.setVndrSeq(cusCtmMovementVOs[i].getVndrSeq());
						tempVO.setSpclCgoFlg(cusCtmMovementVOs[i].getSpclCgoFlg());
						tempVO.setBkgNo(cusCtmMovementVOs[i].getBkgNo());
						tempVO.setBkgKnt(cusCtmMovementVOs[i].getBkgKnt());
						tempVO.setBlNo(cusCtmMovementVOs[i].getBlNo());
						tempVO.setCntrDispFlg(cusCtmMovementVOs[i].getCntrDispFlg());
						tempVO.setImdtExtFlg(cusCtmMovementVOs[i].getImdtExtFlg());
						tempVO.setCntrXchCd(cusCtmMovementVOs[i].getCntrXchCd());
						tempVO.setOrgYdCd(cusCtmMovementVOs[i].getOrgYdCd());
						tempVO.setCreUsrId(cusCtmMovementVOs[i].getCreUsrId());
						tempVO.setUsrNm(cusCtmMovementVOs[i].getUsrNm());
						tempVO.setCntrNo(cusCtmMovementVOs[i].getCntrNo());
						tempVO.setCnmvYr(cusCtmMovementVOs[i].getCnmvYr());
						tempVO.setCnmvIdNo(cusCtmMovementVOs[i].getCnmvIdNo()+1);
						tempVO.setCnmvSeq(cusCtmMovementVOs[i].getCnmvSeq());
						tempVO.setCnmvSplitNo(nextStr);
						tempVO.setMvmtStsCd(cusCtmMovementVOs[i].getMvmtStsCd());
						tempVO.setBkgCgoTpCd(cusCtmMovementVOs[i].getBkgCgoTpCd());
						tempVO.setCnmvCycNo(cusCtmMovementVOs[i].getCnmvCycNo());
						tempVO.setCnmvEvntDt(cusCtmMovementVOs[i].getCnmvEvntDt());
						tempVO.setDestYdCd(cusCtmMovementVOs[i].getDestYdCd());
						tempVO.setChssNo(cusCtmMovementVOs[i].getChssNo());
						tempVO.setMgstNo(cusCtmMovementVOs[i].getMgstNo());
						tempVO.setCntrDmgFlg(cusCtmMovementVOs[i].getCntrDmgFlg());
						tempVO.setCntrId(cusCtmMovementVOs[i].getCntrId());
						tempVO.setTrnkVslCd(cusCtmMovementVOs[i].getTrnkVslCd());
						tempVO.setTrnkSkdVoyNo(cusCtmMovementVOs[i].getTrnkSkdVoyNo());
						tempVO.setTrnkSkdDirCd(cusCtmMovementVOs[i].getTrnkSkdDirCd());
						tempVO.setCntrTpszCd(cusCtmMovementVOs[i].getCntrTpszCd());
						tempVO.setMvmtCreTpCd(cusCtmMovementVOs[i].getMvmtCreTpCd());
						tempVO.setCntrSvrId(cusCtmMovementVOs[i].getCntrSvrId());
						tempVO.setOfcCd(cusCtmMovementVOs[i].getOfcCd());
						tempVO.setCnmvRmk(cusCtmMovementVOs[i].getCnmvRmk());
						tempVO.setCntrSealNo(cusCtmMovementVOs[i].getCntrSealNo());
						tempVO.setCnmvLvlNo(cusCtmMovementVOs[i].getCnmvLvlNo());
						tempVO.setBkgRcvTermCd(cusCtmMovementVOs[i].getBkgRcvTermCd());
						tempVO.setMvmtInpTpCd(cusCtmMovementVOs[i].getMvmtInpTpCd());
						tempVO.setCtrtOfcCtyCd(cusCtmMovementVOs[i].getCtrtOfcCtyCd());
						tempVO.setCtrtSeq(cusCtmMovementVOs[i].getCtrtSeq());
						tempVO.setMvmtTrspModCd(cusCtmMovementVOs[i].getMvmtTrspModCd());
						tempVO.setMvmtEdiTpCd(cusCtmMovementVOs[i].getMvmtEdiTpCd());
						tempVO.setMvmtEdiMsgTpId(cusCtmMovementVOs[i].getMvmtEdiMsgAreaCd());
						tempVO.setMvmtEdiMsgYrmondy(cusCtmMovementVOs[i].getMvmtEdiMsgYrmondy());
						tempVO.setMvmtEdiMsgSeq(cusCtmMovementVOs[i].getMvmtEdiMsgSeq());
						tempVO.setPreStsFlg(cusCtmMovementVOs[i].getPreStsFlg());						
						
						String[] bkgPod = new String[4];
						bkgPod = dbDao.searchPolPodLccCd(tempVO.getBkgNo(), tempVO.getCntrId());
						if(bkgPod[3].equals(tempVO.getOrgYdCd())){
							tempVO.setMvmtStsCd("IC");
						}else{
							tempVO.setMvmtStsCd("TS");
						}
						tempVO.setMvmtCreTpCd("C");
						tempVO.setCntrId("");
						insertVoList.add(tempVO);
					}
					*/
				 // 2013.04.17 [CHM-201324017-01]신규 Movement 생성인 경우도 SCE I/F되도록 함
				 //                              Event Date외 Movement Status, Yard Code도 변경시에는 I/F하도록 수정
					CusCtmMovementVO cusVo = cusCtmMovementVOs[i];
					String fCntr = cusCtmMovementVOs[i].getFcntrFlg();
					// 2013.09.11 [CHM-201325902] VVD 변경시에도 SCE로 I/F 하도록 로직 수정
					String tmpVvdCd = cusCtmMovementVOs[i].getCntrId();

					if ((("F".equals(fCntr) || "Y".equals(fCntr)) || "F".equals(cusVo.getBkgCgoTpCd()) || "R".equals(cusVo.getBkgCgoTpCd())) && cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo())) {
						String evntDtFlg = dbDao.checkEvntDt(cusVo.getCnmvEvntDt(), cusVo.getCntrNo(), cusVo.getCnmvYr(), cusVo.getCnmvIdNo(), cusVo.getMvmtStsCd(), cusVo.getOrgYdCd(), tmpVvdCd);
						
						if("F".equals(evntDtFlg)){
							SceActRcvIfVO sceVO =new SceActRcvIfVO();
							
							sceVO.setCntrNo(cusVo.getCntrNo());
							sceVO.setBkgNo(cusVo.getBkgNo());
							sceVO.setNodCd(cusVo.getOrgYdCd());
							sceVO.setActStsMapgCd(cusVo.getMvmtStsCd());
							sceVO.setActDt(cusVo.getCnmvEvntDt());
							sceVO.setEdiMsgTpCd(cusVo.getMvmtEdiMsgTpId());
							sceVO.setCreTpCd(cusVo.getMvmtCreTpCd());
							sceVO.setCreUsrId(cusVo.getCreUsrId());
							sceVO.setVndrSeq(cusVo.getVndrSeq());
							// 2013.09.11 [CHM-201325902] VVD 변경시에도 SCE로 I/F 하도록 로직 수정
//							sceVO.setVslCd(cusVo.getCrntVslCd());
//							sceVO.setSkdVoyNo(cusVo.getCrntSkdVoyNo());
//							sceVO.setSkdDirCd(cusVo.getCrntSkdDirCd());
							sceVO.setVslCd(subStr(cusVo.getCntrId(), 0, 4));
							sceVO.setSkdVoyNo(subStr(cusVo.getCntrId(), 4, 8));
							sceVO.setSkdDirCd(subStr(cusVo.getCntrId(), 8, 9));
							
							sceVO.setBndVskdSeqCd(cusVo.getIbflag());
	
							sceVO.setCnmvYr(cusVo.getCnmvYr());
							sceVO.setCnmvIdNo(cusVo.getCnmvIdNo());
							sceVO.setCnmvSeq(cusVo.getCnmvSeq());
							sceVO.setCnmvSplitNo(cusVo.getCnmvSplitNo());
							sceVO.setCnmvCycNo(cusVo.getCnmvCycNo());
							//2011.03.25 나상보 Immedate Exit Flag 추가
							sceVO.setImdtExtFlg(cusVo.getImdtExtFlg());
	
							sceVOs.add(sceVO);
						}
					}

					// 2016.03.05 김상현 [CHM-201639990] CTM 내 CNTR History Update 화면 및 Movement Correction Monitoring 메뉴 추가개발
					String maxHisSeq = dbDao.searchMaxMovementHisSeq(cusCtmMovementVOs[i]);
					cusCtmMovementVOs[i].setCnmvHisSeq(maxHisSeq);
					cusCtmMovementVOs[i].setModiTp("I");
					cusCtmMovementVOs[i].setDatDivFlg("T");
					cusCtmMovementVOs[i].setInpDivFlg("C");
					dbDao.addInsertCtmMvmtMnlHis(cusCtmMovementVOs[i]);
				} else if ("U".equals(cusCtmMovementVOs[i].getIbflag())) {
					log.debug("\n\n기존 항목  수정 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt() + "\n");
					updateVoList.add(cusCtmMovementVOs[i]);
					// 2012.10.25 나상보 - Movement Event Date 변경시에 SEC로 Data가 넘어가도록 해당 Operation 호출을 추가

					CusCtmMovementVO cusVo = cusCtmMovementVOs[i];
					String fCntr = cusCtmMovementVOs[i].getFcntrFlg();
					// 2013.09.11 [CHM-201325902] VVD 변경시에도 SCE로 I/F 하도록 로직 수정
					String tmpVvdCd = cusCtmMovementVOs[i].getCntrId();
					if ((("F".equals(fCntr) || "Y".equals(fCntr)) || "F".equals(cusVo.getBkgCgoTpCd()) || "R".equals(cusVo.getBkgCgoTpCd())) && cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo())) {
						// 2013.04.17 [CHM-201324017-01] Event Date외 Movement Status, Yard Code도 변경시에는 I/F하도록 수정
						String evntDtFlg = dbDao.checkEvntDt(cusVo.getCnmvEvntDt(), cusVo.getCntrNo(), cusVo.getCnmvYr(), cusVo.getCnmvIdNo(), cusVo.getMvmtStsCd(), cusVo.getOrgYdCd(), tmpVvdCd);
						
						if("F".equals(evntDtFlg)){
							SceActRcvIfVO sceVO =new SceActRcvIfVO();
							
							sceVO.setCntrNo(cusVo.getCntrNo());
							sceVO.setBkgNo(cusVo.getBkgNo());
							sceVO.setNodCd(cusVo.getOrgYdCd());
							sceVO.setActStsMapgCd(cusVo.getMvmtStsCd());
							sceVO.setActDt(cusVo.getCnmvEvntDt());
							sceVO.setEdiMsgTpCd(cusVo.getMvmtEdiMsgTpId());
							sceVO.setCreTpCd(cusVo.getMvmtCreTpCd());
							sceVO.setCreUsrId(cusVo.getCreUsrId());
							sceVO.setVndrSeq(cusVo.getVndrSeq());
							// 2013.09.11 [CHM-201325902] VVD 변경시에도 SCE로 I/F 하도록 로직 수정
//							sceVO.setVslCd(cusVo.getCrntVslCd());
//							sceVO.setSkdVoyNo(cusVo.getCrntSkdVoyNo());
//							sceVO.setSkdDirCd(cusVo.getCrntSkdDirCd());
							
							sceVO.setVslCd(subStr(cusVo.getCntrId(), 0, 4));
							sceVO.setSkdVoyNo(subStr(cusVo.getCntrId(), 4, 8));
							sceVO.setSkdDirCd(subStr(cusVo.getCntrId(), 8, 9));
							sceVO.setBndVskdSeqCd(cusVo.getIbflag());
	
							sceVO.setCnmvYr(cusVo.getCnmvYr());
							sceVO.setCnmvIdNo(cusVo.getCnmvIdNo());
							sceVO.setCnmvSeq(cusVo.getCnmvSeq());
							sceVO.setCnmvSplitNo(cusVo.getCnmvSplitNo());
							sceVO.setCnmvCycNo(cusVo.getCnmvCycNo());
							//2011.03.25 나상보 Immedate Exit Flag 추가
							sceVO.setImdtExtFlg(cusVo.getImdtExtFlg());
	
							sceVOs.add(sceVO);
						}
					}

					// 2016.03.05 김상현 [CHM-201639990] CTM 내 CNTR History Update 화면 및 Movement Correction Monitoring 메뉴 추가개발
					String maxHisSeq = dbDao.searchMaxMovementHisSeq(cusCtmMovementVOs[i]);
					CusCtmMovementVO prevMovementVO = dbDao.searchMovementInfo(cusCtmMovementVOs[i]);
					ArrayList<String> columNames = new ArrayList<String>();
					if (cusCtmMovementVOs[i].getFcntrFlg() != null && !cusCtmMovementVOs[i].getFcntrFlg().equals(prevMovementVO.getFcntrFlg())) { columNames.add("FCNTR_FLG"); }
					if (cusCtmMovementVOs[i].getObCntrFlg() != null && !cusCtmMovementVOs[i].getObCntrFlg().equals(prevMovementVO.getObCntrFlg())) { columNames.add("OB_CNTR_FLG"); }
					if (cusCtmMovementVOs[i].getVndrSeq() != null && !cusCtmMovementVOs[i].getVndrSeq().equals(prevMovementVO.getVndrSeq())) { columNames.add("VNDR"); }
					if (cusCtmMovementVOs[i].getCnmvRmk() != null && !cusCtmMovementVOs[i].getCnmvRmk().equals(prevMovementVO.getCnmvRmk())) { columNames.add("CNMV_RMK"); }
//					if (cusCtmMovementVOs[i].getUsrNm() != null && !cusCtmMovementVOs[i].getUsrNm().equals(prevMovementVO.getUsrNm())) { columNames.add("USR_NM"); }
					if (cusCtmMovementVOs[i].getWblNo() != null && !cusCtmMovementVOs[i].getWblNo().equals(prevMovementVO.getWblNo())) { columNames.add("WBL_NO"); }
					if (cusCtmMovementVOs[i].getPkupNo() != null && !cusCtmMovementVOs[i].getPkupNo().equals(prevMovementVO.getPkupNo())) { columNames.add("PKUP_NO"); }
					if (cusCtmMovementVOs[i].getCnmvCoCd() != null && !cusCtmMovementVOs[i].getCnmvCoCd().equals(prevMovementVO.getCnmvCoCd())) { columNames.add("CNMV_CO_CD"); }
					if (cusCtmMovementVOs[i].getCnmvSplitNo() != null && !cusCtmMovementVOs[i].getCnmvSplitNo().equals(prevMovementVO.getCnmvSplitNo().equals(" ") ? "" : prevMovementVO.getCnmvSplitNo())) { columNames.add("CNMV_SPLIT_NO"); }
					if (cusCtmMovementVOs[i].getMvmtStsCd() != null && !cusCtmMovementVOs[i].getMvmtStsCd().equals(prevMovementVO.getMvmtStsCd())) { columNames.add("MVMT_STS_CD"); }
					if (cusCtmMovementVOs[i].getBkgNo() != null && !cusCtmMovementVOs[i].getBkgNo().equals(prevMovementVO.getBkgNo())) { columNames.add("BKG_NO"); }
					if (cusCtmMovementVOs[i].getBlNo() != null && !cusCtmMovementVOs[i].getBlNo().equals(prevMovementVO.getBlNo())) { columNames.add("BL_NO"); }
					if (cusCtmMovementVOs[i].getCnmvCycNo() != null && !cusCtmMovementVOs[i].getCnmvCycNo().equals(prevMovementVO.getCnmvCycNo())) { columNames.add("CNMV_CYC_NO"); }
					if (cusCtmMovementVOs[i].getBkgCgoTpCd() != null && !cusCtmMovementVOs[i].getBkgCgoTpCd().equals(prevMovementVO.getBkgCgoTpCd())) { columNames.add("BKG_CGO_TP_CD"); }
					if (cusCtmMovementVOs[i].getDestYdCd() != null && !cusCtmMovementVOs[i].getDestYdCd().equals(prevMovementVO.getDestYdCd())) { columNames.add("DEST_YD_CD"); }
//					if (cusCtmMovementVOs[i].getInpYdCd() != null && !cusCtmMovementVOs[i].getInpYdCd().equals(prevMovementVO.getInpYdCd())) { columNames.add("INP_YD_CD"); }
					if (cusCtmMovementVOs[i].getOrgYdCd() != null && !cusCtmMovementVOs[i].getOrgYdCd().equals(prevMovementVO.getOrgYdCd())) { columNames.add("ORG_YD_CD"); }
					if (cusCtmMovementVOs[i].getChssNo() != null && !cusCtmMovementVOs[i].getChssNo().equals(prevMovementVO.getChssNo())) { columNames.add("CHSS_NO"); }
					if (cusCtmMovementVOs[i].getMgstNo() != null && !cusCtmMovementVOs[i].getMgstNo().equals(prevMovementVO.getMgstNo())) { columNames.add("MGST_NO"); }
					if (cusCtmMovementVOs[i].getCntrId() != null && !cusCtmMovementVOs[i].getCntrId().equals(prevMovementVO.getCntrId())) { columNames.add("VVD"); }
					if (cusCtmMovementVOs[i].getCntrSealNo() != null && !cusCtmMovementVOs[i].getCntrSealNo().equals(prevMovementVO.getCntrSealNo())) { columNames.add("CNTR_SEAL_NO"); }
					if (cusCtmMovementVOs[i].getCntrDmgFlg() != null && !cusCtmMovementVOs[i].getCntrDmgFlg().equals(prevMovementVO.getCntrDmgFlg())) { columNames.add("CNTR_DMG_FLG"); }
					if (cusCtmMovementVOs[i].getCntrDispFlg() != null && !cusCtmMovementVOs[i].getCntrDispFlg().equals(prevMovementVO.getCntrDispFlg())) { columNames.add("CNTR_DISP_FLG"); }
					if (cusCtmMovementVOs[i].getImdtExtFlg() != null && !cusCtmMovementVOs[i].getImdtExtFlg().equals(prevMovementVO.getImdtExtFlg())) { columNames.add("IMDT_EXT_FLG"); }
					if (cusCtmMovementVOs[i].getCntrXchCd() != null && !cusCtmMovementVOs[i].getCntrXchCd().equals(prevMovementVO.getCntrXchCd())) { columNames.add("CNTR_XCH_CD"); }
					if (cusCtmMovementVOs[i].getSpclCgoFlg() != null && !cusCtmMovementVOs[i].getSpclCgoFlg().equals(prevMovementVO.getSpclCgoFlg())) { columNames.add("SPCL_CGO_FLG"); }
					if (cusCtmMovementVOs[i].getCnmvEvntDt() != null && !cusCtmMovementVOs[i].getCnmvEvntDt().equals(prevMovementVO.getCnmvEvntDt())) { columNames.add("CNMV_EVNT_DT"); }
					if (cusCtmMovementVOs[i].getMvmtTrspModCd() != null && !cusCtmMovementVOs[i].getMvmtTrspModCd().equals(prevMovementVO.getMvmtTrspModCd())) { columNames.add("MVMT_TRSP_MOD_CD"); }
					if (cusCtmMovementVOs[i].getMvmtEdiMsgTpId() != null && !cusCtmMovementVOs[i].getMvmtEdiMsgTpId().equals(prevMovementVO.getMvmtEdiMsgTpId())) { columNames.add("MVMT_EDI_MSG_TP_ID"); }
					if (cusCtmMovementVOs[i].getMvmtCreTpCd() != null && !cusCtmMovementVOs[i].getMvmtCreTpCd().equals(prevMovementVO.getMvmtCreTpCd())) { columNames.add("MVMT_CRE_TP_CD"); }
//					if (cusCtmMovementVOs[i].getOfcCd() != null && !cusCtmMovementVOs[i].getOfcCd().equals(prevMovementVO.getOfcCd())) { columNames.add("OFC_CD"); }

					// 2016.05.17 김상현 [CHM-201641462] Correction reason 컨테이너 list 기능 보완 (no highlighted)
					//  - 변경 사항이 있는 수정 data만 history 남김.
					if (columNames.size() > 0) {
						for (int j=0; j<columNames.size(); j++) {
							CtmMovementHisColVO ctmMovementHisColVO = new CtmMovementHisColVO();
							ctmMovementHisColVO.setCntrNo(cusCtmMovementVOs[i].getCntrNo());
							ctmMovementHisColVO.setCnmvYr(cusCtmMovementVOs[i].getCnmvYr());
							ctmMovementHisColVO.setCnmvIdNo(cusCtmMovementVOs[i].getCnmvIdNo());
							ctmMovementHisColVO.setCnmvHisSeq(maxHisSeq);
							ctmMovementHisColVO.setCnmvHisColSeq(String.valueOf(j + 1));
							ctmMovementHisColVO.setCnmvHisColNm(columNames.get(j));
							ctmMovementHisColVO.setCreUsrId(cusCtmMovementVOs[i].getUpdUsrId());
							dbDao.addCtmMvmtMnlHisCol(ctmMovementHisColVO);
						}
						cusCtmMovementVOs[i].setCnmvHisSeq(maxHisSeq);
						cusCtmMovementVOs[i].setModiTp("U");
						cusCtmMovementVOs[i].setDatDivFlg("F");
						cusCtmMovementVOs[i].setInpDivFlg("C");
						dbDao.addPrevCtmMvmtMnlHis(cusCtmMovementVOs[i]);
						cusCtmMovementVOs[i].setDatDivFlg("T");
						dbDao.addUpdateCtmMvmtMnlHis(cusCtmMovementVOs[i]);
					}
				} else if ("D".equals(cusCtmMovementVOs[i].getIbflag())) {
					log.debug("\n기존 항목  삭제 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt());

					// 2016.03.05 김상현 [CHM-201639990] CTM 내 CNTR History Update 화면 및 Movement Correction Monitoring 메뉴 추가개발
					String maxHisSeq = dbDao.searchMaxMovementHisSeq(cusCtmMovementVOs[i]);
					cusCtmMovementVOs[i].setCnmvHisSeq(maxHisSeq);
					cusCtmMovementVOs[i].setModiTp("D");
					cusCtmMovementVOs[i].setDatDivFlg("T");
					cusCtmMovementVOs[i].setInpDivFlg("C");
					dbDao.addPrevCtmMvmtMnlHis(cusCtmMovementVOs[i]);

					deleteVoList.add(cusCtmMovementVOs[i]);
				}

				log.info("\n\n서버 아이디 : " + cusCtmMovementVOs[i].getCntrSvrId());
				mstVO.setIbflag(cusCtmMovementVOs[i].getIbflag());
				mstVO.setCntrNo(cusCtmMovementVOs[i].getCntrNo());
				mstVO.setCnmvIdNo(cusCtmMovementVOs[i].getCnmvIdNo());
				mstVO.setCnmvSeq(cusCtmMovementVOs[i].getCnmvSeq());
				mstVO.setCnmvSplitNo(cusCtmMovementVOs[i].getCnmvSplitNo());
				mstVO.setCnmvCycNo(cusCtmMovementVOs[i].getCnmvCycNo());
				mstVO.setCnmvEvntDt(cusCtmMovementVOs[i].getCnmvEvntDt());
				mstVO.setFcntrFlg(cusCtmMovementVOs[i].getFcntrFlg());
				mstVO.setOrgYdCd(cusCtmMovementVOs[i].getOrgYdCd());
				mstVO.setBkgNo(cusCtmMovementVOs[i].getBkgNo());
				mstVO.setBkgKnt(cusCtmMovementVOs[i].getBkgKnt());
				mstVO.setDestYdCd(cusCtmMovementVOs[i].getDestYdCd());
				mstVO.setMvmtStsCd(cusCtmMovementVOs[i].getMvmtStsCd());
				mstVO.setUpdUsrId(cusCtmMovementVOs[i].getUpdUsrId());
				mstVO.setCnmvYr(cusCtmMovementVOs[i].getCnmvYr());
				mstVO.setChssNo(cusCtmMovementVOs[i].getChssNo());
				mstVO.setCntrSvrId(cusCtmMovementVOs[i].getCntrSvrId());
				mstVO.setMgstNo(cusCtmMovementVOs[i].getMgstNo());
				mstVO.setCnmvRmk(cusCtmMovementVOs[i].getCnmvRmk());
				if (cusCtmMovementVOs[i].getVvdCd() != null && !"".equals(cusCtmMovementVOs[i].getVvdCd()) && cusCtmMovementVOs[i].getVvdCd().trim().length() >= 9) {
					mstVO.setTrnkVslCd(subStr(cusCtmMovementVOs[i].getVvdCd(), 0, 4));
					mstVO.setTrnkSkdVoyNo(subStr(cusCtmMovementVOs[i].getVvdCd(), 4, 8));
					mstVO.setTrnkSkdDirCd(subStr(cusCtmMovementVOs[i].getVvdCd(), 8, 9));
				}

				cgmVo.add(mstVO);
				log.info("\n\n서버 아이디 : " + cgmVo.get(cgmVo.size()-1).getCntrSvrId());
			}

			mstVO = new CusCtmMovementVO();
			nVO.setCusCtmMovementVOs(cgmVo);
			nVO.setSceActRcvIfVOs(sceVOs);

			// 0 : STATUS. 1 : COUNT
			if (updateVoList.size() > 0 || deleteVoList.size() > 0) {
				if (updateVoList.size() > 0) {
					dbDao.addMvmtEventDateHistory(updateVoList);
					dbDao.modifyCtmMovementVOS(updateVoList);
				}
				// 삭제할 대상이 있는 경우 삭제 할 내용도 Update 해준다.
				if (deleteVoList.size() > 0) {
					dbDao.modifyCtmMovementBefDelVOS(deleteVoList);
				}
			}

			// Insert 실행 후 나머지 항목에 대하여 일괄 Update 한다.
			if (insertVoList.size() > 0) {
				log.info("INSERT LIST :" + insertVoList.size());
				dbDao.addCtmMovementVOS(insertVoList);
			}

			// 나머지 항목에 대하여 일괄 Delete 한다.
			if (deleteVoList.size() > 0) {
				// LEVEL을 얻어온다. 1일 경우 추가로직을실행 하도록 한다.
				// 이전 완료 후 삭제한다.
				dbDao.insertCtmMovementVOS(deleteVoList);
				dbDao.removeCtmMovementVOS(deleteVoList);
			}

			// 현재 마지막 Status를 가져온다. Param = CNTR_NO
			String lastStatus = dbDao.getCntrStatus(cntrNo);
			log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
					  "\n 마지막 Status  :" + lastStatus +
					  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			// 마지막 Status가 변경 되었음. 마스터를 업데이트 한다.
			// 현재 최종 데이타를 읽어오기 위해 SQL을 실행 한다. 단 코드 재사용을 위해 아래의 정보를 호출한다.
			// 최종 상태값을 확인하지 않고 변경 하는 것으로 순서 바꿈.
			MVMTBookingInfoVO db = dbDao.searchMovementStatus(cntrNo, cusCtmMovementVOs[0].getEvntDt());
			log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
					  "\n마지막 Row가 변경 되었다. Container Master 와 Chassis 정보를 Update" +
					  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			if (db != null ) {
				mstVO = new CusCtmMovementVO();
				mstVO.setCntrNo(db.getCntrNo());
				mstVO.setCnmvIdNo(db.getCnmvIdNo());
				mstVO.setCnmvSeq(db.getCnmvSeq());
				mstVO.setCnmvSplitNo(db.getCnmvSplitNo());
				mstVO.setCnmvCycNo(db.getCnmvCycNo());
				mstVO.setCnmvEvntDt(db.getCnmvEvntDt());
				mstVO.setFcntrFlg(db.getFcntrFlg());
				mstVO.setOrgYdCd(db.getOrgYdCd());
				mstVO.setBkgNo(db.getBkgNo());
				mstVO.setBkgKnt(db.getBkgKnt());
				mstVO.setDestYdCd(db.getDestYdCd());
				mstVO.setMvmtStsCd(db.getMvmtStsCd());
				mstVO.setUpdUsrId(db.getUpdUsrId());
				mstVO.setCreUsrId(db.getUpdUsrId());
				mstVO.setCnmvYr(db.getCnmvYr());
				mstVO.setChssNo(db.getChssNo());
				mstVO.setCnmvRmk(db.getCnmvRmk());
				mstVO.setCntrSvrId(db.getCntrSvrId());

				// lastStatus가 XX일때는 Active/Inactive Code를 "I"로 넘겨준다.
				if ("XX".equals(lastStatus)) {
					mstVO.setAciacDivCd("I");
				}

				mstVO.setNewFlg("");     // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제

				/**** XX삭제관련 MST호출에 사용될 NewFlg setting (S) - 2010-04-30 ********************************/
				/**** [CHM-201429756] XX삭제관련 MST호출에 사용될 NewFlg setting - 해당 로직 재수정 필요 - 2014-04-14 - 강환 ********************************/
//				if (deleteVoList.size() > 1) {
//					// 삭제될 마지막 row가 [XX(C) <- 이전MT(C) <- 이전VD] 이거나 [XX(C) <- 이전ID] 일때 NewFlg를 Y로 setting하여 MST호출
//					// 마지막 row의 MvmtStsCd
//					String lstSts = deleteVoList.get(deleteVoList.size() - 1).getMvmtStsCd();
//					// 마지막 row의 자동생성flag
//					String lstAf = deleteVoList.get(deleteVoList.size() - 1).getMvmtCreTpCd();
//					if ("XX".equals(lstSts) && "C".equals(lstAf)) {
//						// 이전 row의 MvmtStsCd
//						String preSts = deleteVoList.get(deleteVoList.size() - 2).getMvmtStsCd();
//						// 이전 row의 자동생성flag
//						String preAf = deleteVoList.get(deleteVoList.size() - 2).getMvmtCreTpCd();
//						if ("ID".equals(preSts)) {
//							mstVO.setNewFlg("Y");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
//						} else if (deleteVoList.size() > 2 && "MT".equals(preSts) && "C".equals(preAf)) {
//							// 전전 row의 MvmtStsCd
//							String ppvSts = deleteVoList.get(deleteVoList.size() - 3).getMvmtStsCd();
//							if ("VD".equals(ppvSts)) {
//								mstVO.setNewFlg("Y");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
//							}
//						}
//					}
//				}
				if (deleteVoList.size() > 1) {
					// 삭제될 마지막 row가 [XX(C) <- 이전MT(C) <- 이전VD] 이거나 [XX(C) <- 이전ID] 일때 NewFlg를 Y로 setting하여 MST호출
					// 마지막 row의 MvmtStsCd
					String lstSts = deleteVoList.get(deleteVoList.size() - 2).getMvmtStsCd();
					// 마지막 row의 자동생성flag
					String lstAf = deleteVoList.get(deleteVoList.size() - 2).getMvmtCreTpCd();
					if ("XX".equals(lstSts) && "C".equals(lstAf)) {
						// 이전 row의 MvmtStsCd
						String preSts = deleteVoList.get(deleteVoList.size() - 1).getMvmtStsCd();
						// 이전 row의 자동생성flag
						String preAf = deleteVoList.get(deleteVoList.size() - 1).getMvmtCreTpCd();
						if ("ID".equals(preSts)) {
							mstVO.setNewFlg("Y");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
						} else if (deleteVoList.size() > 2 && "MT".equals(preSts) && "C".equals(preAf)) {
							// 전전 row의 MvmtStsCd
							String ppvSts = deleteVoList.get(deleteVoList.size() - 3).getMvmtStsCd();
							if ("VD".equals(ppvSts)) {
								mstVO.setNewFlg("Y");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
							}
						}
					}
				}

				/**** XX삭제관련 MST호출에 사용될 NewFlg setting (E) - 2010-04-30 ********************************/
				mstVO.setCrntVslCd(db.getCrntVslCd());
				mstVO.setCrntSkdVoyNo(db.getCrntSkdVoyNo());
				mstVO.setCrntSkdDirCd(db.getCrntSkdDirCd());
				mstVO.setCntrId(db.getCrntVslCd() + db.getCrntSkdVoyNo() + db.getCrntSkdDirCd());
				mstVO.setPreStsFlg(db.getPreStsFlg());
				db = null;

				// Start : 2014.08.05 Add Script TN/EN-> MT를 OP-OC로 수정시 BKG No.에 CNTR Attach
				// String cmdFlg = mvmtBookingInfoVOs[lstFlgLine].getIbflag();
				// if("U".equals(cmdFlg) && "OC".equals(lstStsCd)){
				if (lstFlgLine >= 0) {
					if (cusCtmMovementVOs[lstFlgLine].getMvmtStsCd().equals("OP") || cusCtmMovementVOs[lstFlgLine].getMvmtStsCd().equals("OC")) {
						List<BkgContainerLastVO> bkgCntr = null;
						// 2016.04.26 김상현 [CHM-201640944] OC movement 삭제허용 logic 추가
						//  - OP, OC가 booking No.가 다른 경우 오류 발생 되는 부분 처리
						if ("OP".equals(mstVO.getMvmtStsCd()) && "OC".equals(cusCtmMovementVOs[lstFlgLine].getMvmtStsCd())
								&& !mstVO.getBkgNo().equals(cusCtmMovementVOs[lstFlgLine].getBkgNo())) {
							bkgCntr = dbDao.getBkgContainerLastInfo(mstVO.getCntrNo(), mstVO.getBkgNo());
						} else {
							bkgCntr = dbDao.getBkgContainerLastInfo(cusCtmMovementVOs[lstFlgLine].getCntrNo(), cusCtmMovementVOs[lstFlgLine].getBkgNo());
						}
						if (bkgCntr == null || bkgCntr.size() == 0) {
							nVO.setFindBkgCntr(false);
						} else {
							nVO.setFindBkgCntr(true);
						}
				    }
				}
				/* End : 2014.08.05 Add Script TN/EN-> MT를 OP-OC로 수정시 BKG No.에 CNTR Attach */
								
				nVO.setCusCtmMovementVO(mstVO);
				nVO.setUpdateMaster(true);

			} else if ("MT".equals(mvmtBookingInfoVOs[0].getMvmtStsCd()) && "1".equals(mvmtBookingInfoVOs[0].getCnmvCycNo()) && "1".equals(mvmtBookingInfoVOs[0].getCnmvSeq()) ) {
				MVMTBookingInfoVO vo = mvmtBookingInfoVOs[0];
				// 신조 장비로 돌려준다.
				log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
						  "\n가지고 있는 Container 정보가 없다. 신조장비임" +
						  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				mstVO = new CusCtmMovementVO();
				mstVO.setCntrNo(vo.getCntrNo());
				mstVO.setCnmvIdNo(vo.getCnmvIdNo());
				mstVO.setCnmvSeq(vo.getCnmvSeq());
				mstVO.setCnmvSplitNo(vo.getCnmvSplitNo());
				mstVO.setCnmvCycNo(vo.getCnmvCycNo());
				mstVO.setCnmvEvntDt(vo.getCnmvEvntDt());
				mstVO.setFcntrFlg(vo.getFcntrFlg());
				mstVO.setOrgYdCd(vo.getOrgYdCd());
				mstVO.setBkgNo(vo.getBkgNo());
				mstVO.setBkgKnt(vo.getBkgKnt());
				mstVO.setDestYdCd(vo.getDestYdCd());
				mstVO.setMvmtStsCd(vo.getMvmtStsCd());
				mstVO.setUpdUsrId(account.getUsr_id());
				mstVO.setChssNo(vo.getChssNo());
				mstVO.setCnmvYr(vo.getCnmvYr());
				mstVO.setCnmvRmk(vo.getCnmvRmk());

				mstVO.setNewFlg("C");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
				vo = null;

				nVO.setCusCtmMovementVO(mstVO);
				nVO.setUpdateMaster(true);

			} else {
				throw new EventException(new ErrorHandler("There is no delete data.").getMessage());
			}

			if (sendEdiFlg) sendEdiToKor(ediSendVO,"D"+ sendEdiSts, ediSendVO.getLstmCd());

		} catch (EventException ex) {
			log.error("\n\n [BCImpl - modifyMVMTHistory] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - modifyMVMTHistory] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - modifyMVMTHistory] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return nVO;
	}

	/**
	 * EES_CTM_0404 조회 이벤트<br>
	 * EDI Movement의 List를 조회한다<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws EventException
	 */
	public List<SearchEDIMovementListVO> searchEDIMovementList(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		try {
			return dbDao.searchEDIMovementList(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEDIMovementList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEDIMovementList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0404 조회 이벤트<br>
	 * EDI Movement List의 Count를 조회한다.<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchEDIMovementCount(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		try {
			return dbDao.searchEDIMovementCount(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - SearchEDIMovementListVO] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - SearchEDIMovementListVO] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0406 Retrive<br>
	 * International의 VL/VD 조회에 대한 이벤트 처리<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return List<SearchCLMInfoVO>
	 * @exception EventException
	 */
	public List<SearchCLMInfoVO> searchVLVDList(SearchCLMInfoVO searchCLMInfoVo) throws EventException {
		try {
			return dbDao.searchVLVDList(searchCLMInfoVo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchVLVDList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchVLVDList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * EDI Container Message 리스트를 조회한다.<br>
	 *
	 * @param SearchEDIByContainerVO searchEDIByContainerVO
	 * @return List<SearchEDIByContainerVO>
	 * @throws EventException
	 */
	public List<SearchEDIByContainerVO> searchEDIByContainer(SearchEDIByContainerVO searchEDIByContainerVO) throws EventException {
		try {
			return dbDao.searchEDIByContainer(searchEDIByContainerVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEDIByContainer] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEDIByContainer] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 조회 이벤트 처리<br>
	 * EDI Result Remark 리스트를 조회한다.<br>
	 *
	 * @param SearchEDIByResultRemarkVO searchEDIByResultRemarkVO
	 * @return List<SearchEDIByResultRemarkVO>
	 * @throws EventException
	 */
	public List<SearchEDIByResultRemarkVO> searchEDIByResultRemark(SearchEDIByResultRemarkVO searchEDIByResultRemarkVO) throws EventException {
		try {
			return dbDao.searchEDIByResultRemark(searchEDIByResultRemarkVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEDIByResultRemark] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEDIByResultRemark] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0406<br>
	 * Container번호 조회 후 해당 컨테이너에 예약되어있는 부킹 리스트를 조회한다<br>
	 *
	 * @param SearchBkgCntrListVO searchBkgCntrListVO
	 * @return List<SearchBkgCntrListVO>
	 * @exception EventException
	 */
	public List<SearchBkgCntrListVO> searchBkgCntrList(SearchBkgCntrListVO searchBkgCntrListVO) throws EventException {
		try {
			return dbDao.searchBkgCntrList(searchBkgCntrListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchBkgCntrList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchBkgCntrList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0406: ETA/ETD 조회<br>
	 * VSL/YARD가 입력되어있을 때 ETA/ETD Time을 조회한다<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return String
	 * @exception EventException
	 */
	public String getEtaEtdTime(SearchCLMInfoVO searchCLMInfoVo) throws EventException {
		try {
			return dbDao.getEtaEtdTime(searchCLMInfoVo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getEtaEtdTime] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getEtaEtdTime] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * VL Pre Check에대한 유효성 검사<br>
	 * VL저장 전 Pre Check버튼에 대한 이벤트 처리<br>
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVOs
	 * @param SignOnUserAccount account
	 * @return String[][]
	 * @exception EventException
	 */
	public String[][] checkPREVLVD(CtmCntrMovInfoVO[] ctmCntrMovInfoVOs, SignOnUserAccount account) {
		String[][] rtnStr = new String[ctmCntrMovInfoVOs.length][2];
		List<BkgContainerLastVO> bkgCntr = null;
		BkgContainerLastVO   bkgCntrInfo = null;
		int errCnt = 0;
		for (int i = 0; i < ctmCntrMovInfoVOs.length; i++) {
			CtmCntrMovInfoVO vo = ctmCntrMovInfoVOs[i];
			// Exception이 발생 할 경우 Throw 없이 다음 컨테이너 체크 시작.
			try {
				bkgCntr = dbDao.getPreChkValue(vo.getCntrNo(), vo.getCheckDigit());
				if (bkgCntr == null || bkgCntr.size() == 0) {
					rtnStr[i][0] = "No Data Found";
					errCnt++;
					continue;
				}
				bkgCntrInfo = bkgCntr.get(0);
			} catch (DAOException e) {
				/*******************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 *******************************************************/
				log.error(e.getMessage(),e);
				rtnStr[i][0] = "Booking Select Error";
				errCnt++;
				continue;
			}
			vo.setBkgNo(bkgCntrInfo.getBkgNo());
			if (vo.getMvmtStsCd().equals("VL")) {
				/******************************************************
				 * MST_CONTAINER에서 해당 컨테이너의 모든 정보를 가져온다. **
				 ******************************************************/
				String cntrNo = vo.getCntrNo();
				String checkDgt = vo.getCheckDigit();
				String evntDt = vo.getCnmvEvntDt();
				String yardCd = vo.getOrgYdCd();
				String stsCd = vo.getMvmtStsCd();
				String svrId = "";
				if (checkDgt == null || checkDgt.equals("null") || checkDgt.equals("")) checkDgt = "";
				// Exception이 발생 할 경우 Throw 없이 다음 컨테이너 체크 시작.
				try {
					svrId = dbDao.searchSvrId(yardCd);
				} catch (DAOException e) {
					/*******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 *******************************************************/
					log.error(e.getMessage(),e);
					rtnStr[i][0] = "Select Server Error!";
					continue;
				}

				// Exception이 발생 할 경우 Throw 없이 다음 컨테이너 체크 시작.
				try {
					MstContainerInfoVO cntrVO = dbDao.getCntrInfo(cntrNo + checkDgt, evntDt, yardCd);
					if (!svrId.equals(cntrVO.getSvrId()) && !stsCd.equals("VD")) {
						rtnStr[i][0] = "Container Is Not Located In This Area " + svrId + ":" + cntrVO.getSvrId();
						errCnt++;
						continue;
					}
				} catch (Exception ex) {
					/*******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 *******************************************************/
					rtnStr[i][0] = "Select CONTAINER Table Error!";
					errCnt++;
					log.error(ex.getMessage(),ex);
					continue;
				}

				// Exception이 발생 할 경우 Throw 없이 다음 컨테이너 체크 시작.
				try {
					String[] mvmtStsCd = dbDao.getMovementHistoryLast3(vo.getCntrNo()+ vo.getCheckDigit());

					if (mvmtStsCd == null || mvmtStsCd[0] == null) {
						rtnStr[i][0] = "There is no previous status. Please create \"MT\" status first  from container master.";
						continue;
					}
					if (mvmtStsCd[0].equals("EN") || mvmtStsCd[0].equals("TN")) {
						if (!mvmtStsCd[1].equals("MT") && !mvmtStsCd[1].equals("OP") && !mvmtStsCd[1].equals("OC") && !mvmtStsCd[1].equals("TS") && !mvmtStsCd[1].equals("IC") && !mvmtStsCd[1].equals("CM")) {
							rtnStr[i][0] = "1,VL Status Creation Error!!";
							errCnt++;
							continue;
						}
					} else {
						if (!mvmtStsCd[0].equals("MT") && !mvmtStsCd[0].equals("OP") && !mvmtStsCd[0].equals("OC") && !mvmtStsCd[0].equals("TS") && !mvmtStsCd[0].equals("IC") && !mvmtStsCd[0].equals("CM")) {
							rtnStr[i][0] = "2,VL Status Creation Error!!";
							errCnt++;
							continue;
						}
					}
				} catch (Exception e) {
					/*******************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 *******************************************************/
					log.error(e.getMessage(),e);
					rtnStr[i][0] = "Container Movement Select Error";
					errCnt++;
					continue;
				}
			}

			// Exception이 발생 할 경우 Throw 없이 다음 컨테이너 체크 시작.
			try {
				String checkVVD = dbDao.checkBkgVVD(vo);
				if (checkVVD == null) {
					rtnStr[i][0] = "Booking VVD Select Error";
					errCnt++;
					continue;
				}
			} catch (Exception e) {
				/*******************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 *******************************************************/
				log.error(e.getMessage(),e);
				rtnStr[i][0] = "Booking POL_LOC Error";
				errCnt++;
				continue;
			}

			// Exception이 발생 할 경우 Throw 없이 다음 컨테이너 체크 시작.
			try {
				String cnt = dbDao.getBkgDupCount(vo.getCntrNo()+ vo.getCheckDigit(), vo.getMvmtStsCd(), bkgCntrInfo.getCnmvCycNo());
				if (Integer.parseInt(cnt) > 1) {
					List<MultiBkgNoVO> multiBkg = dbDao.searchMultiBkgNoList(vo.getCntrNo()+ vo.getCheckDigit(), bkgCntrInfo.getCnmvCycNo(), vo.getMvmtStsCd(), "");
					// String bkgNos = "";
					// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
					StringBuffer bkgNos = new StringBuffer();
					for (int idxMul = 0; idxMul < multiBkg.size(); idxMul++) {
//						bkgNos = bkgNos + multiBkg.get(idxMul).getBkgNo() + " ";
						bkgNos.append(multiBkg.get(idxMul).getBkgNo());
						bkgNos.append(" "); 
						if (idxMul < multiBkg.size() - 1) 
//							bkgNos = bkgNos + ", ";
							bkgNos.append(", ");
					}
					rtnStr[i][0] = "There are different trunk VVD in another Booking![" + bkgNos + "]";
					errCnt++;
					continue;
				}
			} catch (Exception e) {
				/*******************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 *******************************************************/
				log.error(e.getMessage(),e);
				rtnStr[i][0] = "Duplicated Booking Check Error";
				errCnt++;
				continue;
			}
			if ("VD".equals(vo.getMvmtStsCd())) {
				String bkgNo = bkgCntrInfo.getBkgNo();

				String mtySplit = bkgCntrInfo.getMtySplitAvalCd();
				if (mtySplit == null) mtySplit= "";

				if (bkgCntrInfo.getBkgCgoTpCd().equals("P") && mtySplit.equals("W")) {
					if (bkgNo.length() < 11 || bkgNo.length() > 13)
						rtnStr[i][0] = "[VD]Please split MTY REPO BKG No firstly to update VD movement!";

				} else if (bkgCntrInfo.getBkgCgoTpCd().equals("P") &&  !mtySplit.equals("W")) {

					if (bkgNo.length() == 11) {
						rtnStr[i][0] = "[VD]Please split MTY REPO BKG No firstly to update VD movement!";
					} else if (bkgNo.length() == 12 && subStr(bkgNo, 10, 12).equals("00")) {
						rtnStr[i][0] = "[VD]Please split MTY REPO BKG No firstly to update VD movement!";
					} else if (bkgNo.length() < 11 || bkgNo.length() > 13)
						rtnStr[i][0] = "[VD]Please split MTY REPO BKG No firstly to update VD movement!";
				}

			}

		}
		rtnStr[0][1] = String.valueOf(errCnt);
		return rtnStr;
	}

	/**
	 * EES_CTM_0406 : 부킹번호에 딸려있는 부킹 컨테이너의 타입 사이즈별 갯수 리턴<br>
	 * 부킹번호에 대한 POPUP 조회 이벤트  <br>
	 *
	 * @param BookingQTYVO bookingQTYVO
	 * @return List<BookingQTYVO>
	 * @exception EventException
	 */
	public List<BookingQTYVO> searchBookingQTY(BookingQTYVO bookingQTYVO) throws EventException {
		try {
			return dbDao.searchBookingQTY(bookingQTYVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchBookingQTY] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchBookingQTY] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 부킹번호에 딸려있는 부킹 컨테이너의 타입 사이즈별 갯수 리턴<br>
	 *
	 * @param BkgCNTRListVO bkgCNTRListVO
	 * @return List<BkgCNTRListVO>
	 * @exception EventException
	 */
	public List<BkgCNTRListVO> searchCNTRList(BkgCNTRListVO bkgCNTRListVO) throws EventException {
		try {
			return dbDao.searchCNTRList(bkgCNTRListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCNTRList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCNTRList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * VL/VD 예약이벤트 처리<br>
	 * CTM_MVMT_RSV 테이블에 예약 정보를 등록한다<br>
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void resMovement(CtmCntrMovInfoVO[] ctmCntrMovInfoVO, SignOnUserAccount account) throws EventException {
		try {
			List<CtmCntrMovInfoVO> insertVoList = new ArrayList<CtmCntrMovInfoVO>();
			for ( int i=0; i< ctmCntrMovInfoVO.length; i++ ) {
				ctmCntrMovInfoVO[i].setCreUsrId(account.getUsr_id());
				ctmCntrMovInfoVO[i].setUpdUsrId(account.getUsr_id());
				ctmCntrMovInfoVO[i].setUsrNm   (account.getUsr_nm());
				ctmCntrMovInfoVO[i].setOfcCd   (account.getOfc_cd());
				insertVoList.add(ctmCntrMovInfoVO[i]);
			}
			if ( insertVoList.size() > 0 ) {
				log.debug("INSERT ROW");
				dbDao.addCtmMvmtRsv(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - resMovement] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - resMovement] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * VL Pre Check에대한 유효성 검사<br>
	 * VL저장 전 Pre Check버튼에 대한 이벤트 처리<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String checkVLVDPreChk(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws EventException {
		try {
			return dbDao.checkVLVDPreChk(ctmCntrMovInfoVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - checkVLVDPreChk] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - checkVLVDPreChk] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * VVD와 Yard 간의 유효성 검사<br>
	 * VVD,Yard 변경시 자동 조회<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVVDYardCd(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws EventException {
		try {
			return dbDao.checkVVDYardCd(ctmCntrMovInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	/**
	 * Domestic Movement 에서 신규 입력되는 Movement 정보 입력
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String cntCd
	 * @return CrossItemVO
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	public CrossItemVO manageDomesticMVMT(CusCtmMovementVO cusCtmMovementVO, String cntCd) throws EventException {
		String[] strRtn = new String[3];
		strRtn[0] = "";
		strRtn[1] = "";
		strRtn[2] = "";

		CrossItemVO item = new CrossItemVO();
		// SERVER NAME을 얻어온다. D : DEN 그외 : ENT
		String yardCd = cusCtmMovementVO.getOrgYdCd();
		String svrId  = null;
		String chkDgt = cusCtmMovementVO.getCheckDigit();
		String cntrNo = cusCtmMovementVO.getCntrNo();
		if (chkDgt != null && !chkDgt.equals("") && !chkDgt.equals("null")) {
			cntrNo = cusCtmMovementVO.getCntrNo() + chkDgt;
		}
		cusCtmMovementVO.setCntrNo(cntrNo);
		cusCtmMovementVO.setCheckDigit("");
		String evntDt = cusCtmMovementVO.getCnmvEvntDt();
		String mvmtStsCd = cusCtmMovementVO.getMvmtStsCd();
		String fmFlag = null;
		String cycNo = null;
		String idNo = null;
		String idSeq = null;
		String inpType = null;
		String[] lccRcc = null;
		String[] localTime = null;
		MstContainerInfoVO cntrVO = null;          // MST 컨테이너 정보 (MST_CONTAINER)
		CusCtmMovementVO ctmMov = null;            // 마지막 MOVEMENT 정보 (CTM_MOVEMENT)
		CtmCntrMovInfoVO ediVO = null;             // 전전 컨테이너 정보 (CTM_MOVEMENT)
		cusCtmMovementVO.setCntrNo(cusCtmMovementVO.getCntrNo() + cusCtmMovementVO.getCheckDigit());
		List<AutoCreItemVO> autoItem = null;       // 자동생성될 부킹리스트
		String userId = cusCtmMovementVO.getUpdUsrId();
		String userNm = cusCtmMovementVO.getUsrNm();
		String yy = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		cusCtmMovementVO.setCnmvYr(yy);    // 2011.01.06 김상수 - vo에 담겨있는 연도를 사용하지 않고 현재연도를 setting
		String ofcCd = "";
		String errMsg = "";
		if (userId == null || userId.equals("")) {
			userId = cusCtmMovementVO.getCreUsrId();
			userNm = cusCtmMovementVO.getUsrNm();
			if (userNm == null) userNm = userId;
			cusCtmMovementVO.setUsrNm(userNm);
		}

		if (userId.equals("ESVCUSER") || userId.equals("EDIUSER")) {
			try {
				ofcCd = dbDao.getOfcCdByYard(yardCd);
				if (ofcCd.equals("E")) {
					strRtn[0] = "N";
					strRtn[1] = "Office select error!";
					item.setRtnStr(strRtn); return item;
				}
				if (userId.equals("ESVCUSER")) {
					inpType = "SPP";
					cusCtmMovementVO.setMvmtEdiMsgTpId("SPP");
				} else {
					inpType = "EDI";
				}
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("Office select error!").getMessage(), ex);
			}
		} else {
			if (cusCtmMovementVO.getMvmtEdiTpCd() != null && !"".equals(cusCtmMovementVO.getMvmtEdiTpCd().trim())) {
				inpType = "EDI";
			} else {
				inpType = "MAN";
			}
		}
		cusCtmMovementVO.setOfcCd(ofcCd);
		cusCtmMovementVO.setMvmtInpTpCd(inpType);

		// 컨테이너마스터 정보를 읽어온다
		try {
			cntrVO = dbDao.getCntrInfo(cntrNo, evntDt, yardCd);
			if (cntrVO == null) {
				strRtn[0] = "N";
				strRtn[1] = "Container Select Error!!";
				item.setRtnStr(strRtn); return item;
			}
			if (cntrVO.getAciacDivCd().equals("I")) {
				strRtn[0] = "N";
				strRtn[1] = "Inactive container!";
				item.setRtnStr(strRtn); return item;
			}
			if (cntrVO.getCnmvStsCd().equals("CP") && cntrVO.getImdtExtFlg().equals("Y")) {
				strRtn[0] = "N";
				strRtn[1] = "Immediately Exit Container![CP]";
				item.setRtnStr(strRtn); return item;
			}
			if (cntrVO.getCnmvStsCd().equals("CI") || cntrVO.getCnmvStsCd().equals("CD") || cntrVO.getCnmvStsCd().equals("CE") || cntrVO.getCnmvStsCd().equals("CT")) {
				// INTO :cnmv_seal_no
				cusCtmMovementVO.setCntrSealNo("");
			}
			cusCtmMovementVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Container master]").getMessage(), ex);
		}

		try {
			svrId = dbDao.searchSvrId(yardCd);
			String svrCd = dbDao.searchSvrId(cntCd);
			if (!svrId.equals(svrCd)) {
				strRtn[0] = "N";
				strRtn[1] = "Container is not located in this area " + svrId + ":" + cntrVO.getSvrId();
				item.setRtnStr(strRtn); return item;
			}

			if (svrId.equals("E")) {
				strRtn[0] = "N";
				strRtn[1] = "Select server name error";
				item.setRtnStr(strRtn); return item;
			} else if ("D".equals(subStr(svrId, 0, 1))) svrId = "DEN";
			else svrId = "USA";

		} catch (Exception e) {
			throw new EventException(new ErrorHandler("Area does not exist [" + ofcCd + "]!").getMessage(), e);
		}

		try {
			lccRcc = dbDao.getLccRccCode(yardCd);
			if (lccRcc == null) {
				strRtn[0] = "N";
				strRtn[1] = "Loc_cd select err";
				item.setRtnStr(strRtn); return item;
			}
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("Loc_cd select err").getMessage(), e);
		}

		try {

			localTime = dbDao.getLocalTime(yardCd, evntDt, mvmtStsCd);
			if (lccRcc == null) {
				strRtn[0] = "N";
				strRtn[1] = "Date compare error!";
				item.setRtnStr(strRtn); return item;
			} else {
				if (localTime.equals("1")) {
					strRtn[0] = "N";
					strRtn[1] = "Input date must be later than system date!";
					item.setRtnStr(strRtn); return item;
				}
			}
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("Date Compare Error!").getMessage(), e);
		}

		// 마지막 MOVEMENT 정보를 얻어온다.
		/******************************************
		 *   컨테이너이동정보 마지막 정보를 읽어온다 *
		 ******************************************/
		try {
			ctmMov = dbDao.searchMovementStatusMst(cntrNo, evntDt);
			if (ctmMov != null) {
				cusCtmMovementVO.setCnmvCycNo(ctmMov.getCnmvCycNo());
				// ID, SEQ의 MAX는 MOVEMENT의 마지막과 다르다...
				idNo  = dbDao.getContainerMaxId(cntrNo, yy);
				idSeq = dbDao.getContainerMaxSeq(cntrNo, yy);
				cycNo = ctmMov.getCnmvCycNo();

				if (ctmMov.getMvmtStsCd().equals("XX")) {
					strRtn[0] = "N";
					strRtn[1] = "XX Container!";
					item.setRtnStr(strRtn); return item;
				} 

				if (Long.parseLong(cntrVO.getEvntDt()) > Long.parseLong(cntrVO.getCompDt())) {
					if (mvmtStsCd.equals("VL") || mvmtStsCd.equals("VD")) {
						strRtn[0] = "N";
						strRtn[1] = "Previous event date(VL-VD) is later than current event date.";
						item.setRtnStr(strRtn); return item;
					} else {
						strRtn[0] = "N";
						strRtn[1] = "Previous event date is later than current event date.";
						item.setRtnStr(strRtn); return item;
					}
				}

				/**
				 * 2015.11.19 Logic 추가.
				 * 사용자 manual 입력시 이전 booking no 복사
				 * By Sang-Hyun Kim
				 */
				if ("MAN".equals(cusCtmMovementVO.getMvmtInpTpCd()) && !"CP".equals(cusCtmMovementVO.getMvmtStsCd())) {
					cusCtmMovementVO.setBkgNo(ctmMov.getBkgNo());
					cusCtmMovementVO.setBlNo(ctmMov.getBlNo());
				}
			} else {
				strRtn[0] = "N";
				strRtn[1] = "There is no previous status. Please create \"MT\" status first.";
				item.setRtnStr(strRtn); return item;
			}
			// 미주지역 ALRL처리를 위해 날짜비교 처리를 제거한다
			if (mvmtStsCd.equals("CE") && mvmtStsCd.equals(ctmMov.getMvmtStsCd()) && yardCd.equals(ctmMov.getOrgYdCd())) {
				strRtn[0] = "N";
				strRtn[1] = "The same data already existed!!";
				item.setRtnStr(strRtn); return item;
			} else if (!mvmtStsCd.equals("CM") && mvmtStsCd.equals(ctmMov.getMvmtStsCd()) && yardCd.equals(ctmMov.getOrgYdCd()) && subStr(evntDt, 0, 8).equals(subStr(ctmMov.getCnmvEvntDt(), 0, 8))) {
				strRtn[0] = "N";
				strRtn[1] = "The same data already existed!!";
				item.setRtnStr(strRtn); return item;
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DOM - container movement select error").getMessage(), ex);
		}

		try {
			ediVO = dbDao.searchMovementStatusVD(cntrNo, 2);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("There is no previous(2) container movement!").getMessage(), e);
		}
		/*******************
		 * Cycle 정보 조회 *
		 *******************/
		cycNo = ctmMov.getCnmvCycNo();

		// FULL/EMPTY 정보 지정
		if (mvmtStsCd.equals("CP") || mvmtStsCd.equals("CM")) {
			fmFlag = "N";
		} else {
			fmFlag = "Y";
		}

		// 전 상태가 ID 이고 입력할 대상이 CO일때 DOM BOOKING의 ST_TURN_FLG를 조회한다
		String checkFlg = "N";
		String evntDtBak = cusCtmMovementVO.getCnmvEvntDt();
		if (ctmMov.getMvmtStsCd().equals("ID") && mvmtStsCd.equals("CO")) {
			try {
				checkFlg = dbDao.checkDomBooking(cntrNo, evntDtBak, ctmMov.getCnmvEvntDt());
			} catch (Exception ex) {
				// 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음
				log.error("err " + ex.toString(), ex);
			}
		}

		String preMvmtStsCd = ""; // OP -> CP 처리를 위한 이전 상태 변수
		// 자동생성 로직 실행
		try {
			String yardCdEq = null;

			if (yardCd.equals(ctmMov.getOrgYdCd())) {
				yardCdEq = "S";
			} else {
				yardCdEq = "D";
			}

			String ppSts = "";
			if (ediVO != null && ediVO.getMvmtStsCd() != null) {
				ppSts = ediVO.getMvmtStsCd();
			}

			String message[] = getErrMsg(ctmMov.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag, cusCtmMovementVO);
			errMsg = message[0];
			// 이전 단계가 'OP'일 경우, Domestic status일 때 정상 처리 되록 수정.
			if ("NONE".equals(errMsg)) {
				preMvmtStsCd = new String(ctmMov.getMvmtStsCd());
				ctmMov.setMvmtStsCd("CP");
			}

			/**
			 * 2015.12.15 Logic 추가 by Sang-Hyun Kim
			 * CP 다음에 Full + Gate in이면 CO을 처리하고
			 * CO이후에는 CT를 생성하고 (CI생성시 LCC가 다르면 CE로 변경)
			 * CT이후 CI 생성
			 * CI이후 CD 생성 (Full + Gate in 추가 발생시 CD->CT로 변경)
			 * CM 발생시 CT->CD로 변경
			 */
			// 현재 Booking No.가 invalid이면 logic 수행.
			String checkBkgNo = (new ContainerMovementMgtForGateNewDBDAO()).checkBkgExist(cusCtmMovementVO.getBkgNo());
			if (checkBkgNo == null) {
				if ("CO".equals(cusCtmMovementVO.getMvmtStsCd())) {
					if ("CP".equals(ctmMov.getMvmtStsCd())) {
						cusCtmMovementVO.setMvmtStsCd("CO");
					} else if ("CT".equals(ctmMov.getMvmtStsCd()) || "CE".equals(ctmMov.getMvmtStsCd()) || "CD".equals(ctmMov.getMvmtStsCd())) {
						mvmtStsCd = "CI";
						String eventLccRcc[] = dbDao.getLccRccCode(ctmMov.getOrgYdCd());
						String preStsCd = "";
						if (eventLccRcc[3].equals(lccRcc[3])) {
							preStsCd = "CD";
							cusCtmMovementVO.setMvmtStsCd("CM");
						} else if (eventLccRcc[2].equals(lccRcc[2])) {
							preStsCd = "CT";
						} else {
							preStsCd = "CE";
						}
						if (!preStsCd.equals(ctmMov.getMvmtStsCd())) {
							ctmMov.setMvmtStsCd(preStsCd);
							dbDao.updateCtmMovementDomestic(ctmMov);
						}
					} else if ("CD".equals(ctmMov.getMvmtStsCd())) {
						mvmtStsCd = "CM";
					}
				} else if ("CT".equals(cusCtmMovementVO.getMvmtStsCd())) {
					if ("CO".equals(ctmMov.getMvmtStsCd())) {
						mvmtStsCd = "CT";
					} else if ("CI".equals(ctmMov.getMvmtStsCd())) {
						mvmtStsCd = "CD";
					}
				}
			}

			/*
			 * 2015.12.30 Logic 추가 by Sang-Hyun Kim
			 * Domestic booking의 경우, Full/Empty에 대한 EDI data가 제대로 입력되지 않아서 현재 status에 따라서 Full/Empty flag 값을 setting하도록 수정
			 */
			if ("CP".equals(mvmtStsCd) || "CM".equals(mvmtStsCd)) {
				cusCtmMovementVO.setFcntrFlg("M");
				fmFlag = "N";
			} else {
				cusCtmMovementVO.setFcntrFlg("F");
				fmFlag = "Y";
			}

			// 2016.03.16 김상현 [CHM-201640355] Last Bkg 생성/Update logic 변경2
			//  - Domestic booking NBR과 B/L NBR이 다를 경우 동일하게 변경
			if (cusCtmMovementVO.getBkgNo() != null && !cusCtmMovementVO.getBkgNo().equals(cusCtmMovementVO.getBlNo())) {
				cusCtmMovementVO.setBlNo(cusCtmMovementVO.getBkgNo().length() > 12 ? cusCtmMovementVO.getBkgNo().substring(0, 12) : cusCtmMovementVO.getBkgNo());
			}


			autoItem = dbDao.checkAutoCreItem(mvmtStsCd, ctmMov.getMvmtStsCd(), ppSts, yardCdEq, fmFlag, ctmMov.getFcntrFlg());

			AutoCreItemVO act = null;
			if ((JSPUtil.getNull(autoItem) == null || autoItem.size() == 0)) {
				// 처리할 내역이 없다. ERROR.
				if (autoItem.size() == 0) {
					strRtn[0] = "N";
					strRtn[1] = errMsg;
					item.setRtnStr(strRtn); return item;
				}
			} else {
				CusCtmMovementVO cusVO = null;
				String tmpBkgNo = cusCtmMovementVO.getBkgNo();
				String tmpBlNo = cusCtmMovementVO.getBlNo();
				for (int i = 0; i < autoItem.size(); i++) {
					act = autoItem.get(i);
					String autoSts = subStr(act.getAuto(), 0, 2);
					if (act.getTar().equals("C")) {
						cusVO = cusCtmMovementVO;
					} else {
						// 직전 컨테이너 정보 조회
						errMsg = "There is no previous(1) container movement!";
						cusVO = dbDao.getPrevCntrInfo(cntrNo, "1");
					}
					cusVO.setDestYdCd("");
					if (autoSts.equals("CT")) autoSts = "CE";
					if (autoSts.equals("CE") || autoSts.equals("CT")) {
						String locationCd = null;
						errMsg = "Unexpected system error occurred during data processing. [" + yardCd + "/" + ctmMov.getOrgYdCd() + "]";
						locationCd = dbDao.checkLocationCd(yardCd, ctmMov.getOrgYdCd());
						if (locationCd == null) {
							strRtn[0] = "N";
							strRtn[1] = "Location code does not exist!";
							item.setRtnStr(strRtn); return item;
						} else if (locationCd.equals("N")) {
							autoSts = "CE";
						} else {
							autoSts = "CT";
						}
					}

					cusVO.setCtrtOfcCtyCd(cntrVO.getAgmtCtyCd());
					cusVO.setCtrtSeq(cntrVO.getAgmtSeq());

					// autoItem에서 지정 하는 수 만큼 반복하면서 이전 Sts Cd를 자동 생성 한다.
					if (!act.getResult().equals("OK")) {
						strRtn[0] = "N";
						// strRtn[1] = "Movement creation error [auto creation][" + ctmMov.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
						String messages[] = getErrMsg(ctmMov.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag, cusCtmMovementVO);
						strRtn[1] = messages[0];
						strRtn[2] = messages[1];
						item.setRtnStr(strRtn);
						return item;
					}

					if ("CY".equals(subStr(act.getAuto(), 3, 5))) {
						cusVO.setOrgYdCd(ctmMov.getOrgYdCd());
					} else {
						cusVO.setOrgYdCd(yardCd);
					}
					/**************************************
					 *  Dom에서는 Inbound 처리. Empty 처리 *
					 **************************************/
					cusVO.setFcntrFlg("M");
					cusVO.setIbflag("N");

					if (act.getTar().equals("C")) {
						cusVO.setMvmtStsCd(autoSts);
						if (autoSts.equals("MT") || autoSts.equals("CM") || autoSts.equals("CP")) {
							cusVO.setFcntrFlg("M");
							cusVO.setTrnkVslCd("");
							cusVO.setTrnkSkdVoyNo("");
							cusVO.setTrnkSkdDirCd("");
						} else {
							cusVO.setFcntrFlg("F");
						}

						// 자동생성 Status가 [CM, MT]가 아닐때는 현재 받은 컨테이너 정보의 bkg_no를 setting
						// 2016.03.16 김상현 [CHM-201640355] Last Bkg 생성/Update logic 변경2
						//  - 'MT'가 아니면 Booking No., B/L No. 입력하도록 변경
						if (!autoSts.equals("MT")) {
							cusVO.setBkgNo(cusCtmMovementVO.getBkgNo());
							cusVO.setBlNo(cusCtmMovementVO.getBlNo());
						}
						cusVO.setCnmvEvntDt(evntDt);
						cusVO.setCnmvCycNo(cycNo);
						String lvlCd = null;
						String cgoTp = "";
						errMsg = "Full flag is null";
						lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, cusVO.getMvmtStsCd()).getCnmvLvlNo();
						errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
						if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
						cusVO.setCnmvLvlNo(lvlCd);
						cusVO.setBkgCgoTpCd(cgoTp);
						cusVO.setMvmtCreTpCd("A");
						cusVO.setMvmtInpTpCd(inpType);
						cusVO.setOfcCd(ofcCd);
						cusVO.setCreUsrId(userId);
						cusVO.setUpdUsrId(userId);
						cusVO.setCntrSvrId(svrId);
						cusVO.setUsrNm(userNm);
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						cusVO.setCnmvIdNo(idNo);
						cusVO.setCnmvSeq(idSeq);
						cusVO.setCnmvYr(yy);

						if (!"N".equals(checkFlg)) {
							cusVO.setCnmvEvntDt(checkFlg);    // DAO에서 return된 checkFlg => 'N' 또는 EventDate
						}

						// 2016.03.20 김상현 [CHM-201640355] Last Bkg 생성/Update logic 변경2
						//  - Domestic booking NBR에서 MT에는 값을 넣지 않음.
						if (cusVO.getMvmtStsCd().equals("MT") && autoSts.equals("MT")) {
							cusVO.setBkgNo("");
							cusVO.setBlNo("");
						}

						dbDao.addCtmMovement(cusVO);

						if (cusVO.getMvmtStsCd().equals("MT") && autoSts.equals("MT")) {
							cusVO.setBkgNo(tmpBkgNo);
							cusVO.setBlNo(tmpBlNo);

							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
							List<SceActRcvIfVO> sceVOs = new ArrayList<SceActRcvIfVO>();
							SceActRcvIfVO sceVO =new SceActRcvIfVO();
							
							sceVO.setCntrNo(cusVO.getCntrNo());
							sceVO.setBkgNo(ctmMov.getBkgNo());
							sceVO.setNodCd(cusVO.getOrgYdCd());
							sceVO.setActStsMapgCd(cusVO.getMvmtStsCd());
							sceVO.setActDt(cusVO.getCnmvEvntDt());
							sceVO.setEdiMsgTpCd(cusVO.getMvmtEdiMsgTpId());
							sceVO.setCreTpCd(cusVO.getMvmtCreTpCd());
							sceVO.setCreUsrId(cusVO.getCreUsrId());
							sceVO.setVndrSeq(cusVO.getVndrSeq());
							
							sceVO.setVslCd(cusVO.getCrntVslCd());
							sceVO.setSkdVoyNo(cusVO.getCrntSkdVoyNo());
							sceVO.setSkdDirCd(cusVO.getCrntSkdDirCd());
							
							sceVO.setBndVskdSeqCd(cusVO.getIbflag());
	
							sceVO.setCnmvYr(cusVO.getCnmvYr());
							sceVO.setCnmvIdNo(cusVO.getCnmvIdNo());
							sceVO.setCnmvSeq(cusVO.getCnmvSeq());
							sceVO.setCnmvSplitNo(cusVO.getCnmvSplitNo());
							sceVO.setCnmvCycNo(cusVO.getCnmvCycNo());
							//2011.03.25 나상보 Immedate Exit Flag 추가
							sceVO.setImdtExtFlg(cusVO.getImdtExtFlg());
							
							sceVOs.add(sceVO);
							
							item.setSceActRcvIfVOs(sceVOs);
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
						}
					} else if (act.getTar().equals("U1")) {
						errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" update error(1)]";
						cusVO.setMvmtStsCd(autoSts);
						if (subStr(act.getAuto(), 3, 5).equals("CY")) {
							cusVO.setOrgYdCd(ctmMov.getOrgYdCd());
						} else {
							cusVO.setOrgYdCd(yardCd);
						}
						dbDao.updateContainer(cusVO, "1", "");
					} else if (act.getTar().equals("U2")) {
						errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" update error(2)]";
						// 전전 상태 업데이트
						cusVO.setCnmvYr(ediVO.getCnmvYr());
						cusVO.setMvmtStsCd(autoSts);
						cusVO.setMvmtCreTpCd("A");
						if (subStr(act.getAuto(), 3, 5).equals("CY")) {
							cusVO.setOrgYdCd(ediVO.getOrgYdCd());
						} else {
							cusVO.setOrgYdCd(yardCd);
						}
						dbDao.updateContainer(cusVO, "2", "");
					} else {
						// SKIP
					}
				}
			}
		} catch (DAOException er) {
			throw new EventException(new ErrorHandler(errMsg).getMessage(), er);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(errMsg).getMessage(), e);
		}

		/*
		 * 2015.12.30 Logic 추가 by Sang-Hyun Kim
		 * Domestic booking의 경우, Full/Empty에 대한 EDI data가 제대로 입력되지 않아서 현재 status에 따라서 Full/Empty flag 값을 setting하도록 수정
		 * 기존 Empty 처리 logic 삭제
		 */
		// Dom에서는 Inbound 처리. Empty 처리
//		cusCtmMovementVO.setFcntrFlg("M");
		cusCtmMovementVO.setIbflag("N");
		cusCtmMovementVO.setObCntrFlg("N");
		cusCtmMovementVO.setCntrXchCd("N");
		cusCtmMovementVO.setPreStsFlg("N");
		cusCtmMovementVO.setCntrSvrId(svrId);
		cusCtmMovementVO.setUsrNm(userNm);
		cusCtmMovementVO.setMvmtStsCd(mvmtStsCd);
		cusCtmMovementVO.setOrgYdCd(yardCd);
		cusCtmMovementVO.setCtrtOfcCtyCd("HHO");

		try {
			if (mvmtStsCd.equals("CM") && ctmMov.getMvmtStsCd().equals("CM") && ctmMov.getMvmtCreTpCd().equals("C")) {
				// 지운다.
				errMsg = "Unexpected system error occurred during data processing. ["+ctmMov.getMvmtStsCd()+" delete error(2)]";
				dbDao.deleteCtmMovement(ctmMov);
			}
			if (ctmMov.getMvmtStsCd().equals("ID") && mvmtStsCd.equals("CO")) {
				/* ****************************************************
				 * ID 이후 CO가 들어올 경우 DOM_BOOKING테이블을 조회한다.    *
				 * DOM_BOOKING의 ST_TURN_FLG가 Y인 경우 MT, CP를 자동생성    *
				 ******************************************************/
				if (!"N".equals(checkFlg)) {
					errMsg = "Unexpected system error occurred during data processing. [CO creation error]";
					cusCtmMovementVO.setMvmtStsCd("CO");
					cusCtmMovementVO.setMvmtCreTpCd("");
					idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
					idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
					cusCtmMovementVO.setCnmvIdNo(idNo);
					cusCtmMovementVO.setCnmvSeq(idSeq);
					cusCtmMovementVO.setCnmvEvntDt(evntDtBak);

					dbDao.addCtmMovement(cusCtmMovementVO);

				} else {
					errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" creation error]";
					cusCtmMovementVO.setMvmtCreTpCd("");
					idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
					idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
					cusCtmMovementVO.setCnmvIdNo(idNo);
					cusCtmMovementVO.setCnmvSeq(idSeq);

					dbDao.addCtmMovement(cusCtmMovementVO);
				}
			} else	if ((ctmMov.getMvmtStsCd().equals("EN") || ctmMov.getMvmtStsCd().equals("TN")) && mvmtStsCd.equals("CO")) {
				/* ****************************************************
                 * 2015.02.09. ADD                                    *
				 * EN/TN 이후 CO를 insert할 경우 EN/TN -> CP로 mvmtStscd Change   *
				 * CO의 Domestic BKg No를 CP로 Copy                   *
				 ******************************************************/
					ctmMov.setMvmtStsCd("CP");
					ctmMov.setBkgNo(cusCtmMovementVO.getBkgNo());
					
					idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
					idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
					cusCtmMovementVO.setCnmvIdNo(idNo);
					cusCtmMovementVO.setCnmvSeq(idSeq);
					
					// 2015.02.09 New Query, EN/TN -> CP, Bkg No Update
					dbDao.updateMovementBkgVO(ctmMov);
					// CO Creation
					dbDao.addCtmMovement(cusCtmMovementVO);
			} else if (preMvmtStsCd.equals("OP")
					&& (mvmtStsCd.equals("CD") || mvmtStsCd.equals("CE") || mvmtStsCd.equals("CI") || mvmtStsCd.equals("CO"))) {
				/*
				 * 2015.10.19 Logic 추가.
				 * 이전 단계가 OP이고 현재 단계가 CD, CE, CI, CO 중에 하나일 경우, Domestic booking 확인 후 'OP' -> 'CP'로 변경 처리 및 CI~CD 정상 처리 Logic 추가
				 * By Sang-Hyun Kim
				 */

				String checkValue = dbDao.checkCntrExist(ctmMov);
				if (checkValue != null && !"".equals(checkValue)) {
					strRtn[0] = "N";
					strRtn[1] = "This container is not Domestic Bkg.";
					item.setRtnStr(strRtn);
					return item;
				}

				ctmMov.setMvmtStsCd("CP");
				ctmMov.setBkgNo(cusCtmMovementVO.getBkgNo());
				dbDao.updateCtmMovementDomestic(ctmMov); // OP -> CP 변경 처리 by Sang-Hyun Kim

				idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
				idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
				cusCtmMovementVO.setCnmvIdNo(idNo);
				cusCtmMovementVO.setCnmvSeq(idSeq);

				dbDao.addCtmMovement(cusCtmMovementVO);
			} else {
				errMsg = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " creation error]";
				idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
				idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
				cusCtmMovementVO.setCnmvIdNo(idNo);
				cusCtmMovementVO.setCnmvSeq(idSeq);

				// 2016.03.16 김상현 [CHM-201640355] Last Bkg 생성/Update logic 변경2
				//  - 'MT'일 경우, Booking No. B/L No. 입력하지 않음.
				if ("MT".equals(cusCtmMovementVO.getMvmtStsCd())) {
					cusCtmMovementVO.setBkgNo("");
					cusCtmMovementVO.setBkgKnt("0");
					cusCtmMovementVO.setBlNo("");
				}

				dbDao.addCtmMovement(cusCtmMovementVO);
				if (mvmtStsCd.equals("CD")) { // Lease Term 이 SH일 경우 XX 생성.
					if ("SH".equals(cntrVO.getLstmCd())) {
						cusCtmMovementVO.setMvmtStsCd("XX");
						item.setEdiSendLstrmCd(cntrVO.getLstmCd()); // sendEDIToKOR을 위한 LstrmCd setting try
						cusCtmMovementVO.setMvmtCreTpCd("C");
						cusCtmMovementVO.setCntrDispFlg("Y");
						cusCtmMovementVO.setAciacDivCd("I");
						cusCtmMovementVO.setNewFlg("X");

						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						cusCtmMovementVO.setCnmvIdNo(idNo);
						cusCtmMovementVO.setCnmvSeq(idSeq);
						dbDao.addCtmMovement(cusCtmMovementVO);
					}
/*
					// 2016.02.12 Sang-Hyun Kim [CHM-201639830] CTM: Domestic MVMT CM 자동생성 logic 변경
					// 'CD'일 경우, 'CM' 자동 생성 logic 삭제 처리. 'MT'일 때 'CM' 생성하도록 변경
					} else { // CM을 생성해준다.
						errMsg = "Unexpected system error occurred during data processing. [CM creation error]";
						cusCtmMovementVO.setMvmtStsCd("CM");
						cusCtmMovementVO.setFcntrFlg("M");
						cusCtmMovementVO.setMvmtCreTpCd("C");
					}
*/
				}
			}
			// CrossItem으로 세팅
			item.setUpdateMaster(true);
			item.setCusCtmMovementVO(cusCtmMovementVO);
			item.setRtnStr(strRtn);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageDomesticMVMT] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageDomesticMVMT] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return item;
	}

	/**
	 * CTM 공통.. 외부 모듈 호출 및 테스트<br>
	 *
	 * @param CrossItemVO crossItemVO
	 * @param boolean modifyCntrOpResult
	 * @return String
	 * @exception EventException
	 */
	public String updateEtcModule(CrossItemVO crossItemVO, boolean modifyCntrOpResult) throws EventException {
		try {
			// 상황에 따라 param을 달리하여 2번 호출
			if (crossItemVO.getMstCtmMvmtIrrInsert()) {
				dbDao.mstCtmMvmtIrrInsert(crossItemVO.getCntrNo(), "A");
			}
			if (modifyCntrOpResult) {
				dbDao.mstCtmMvmtIrrInsert(crossItemVO.getCntrNo(), "C");
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - updateEtcModule] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - updateEtcModule] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return "S";

	}

	/**
	 * 0422 에서 넘겨받은 Movement Update<br>
	 * 컨테이너 이동정보 수정. 대상 컨테이너에 대한 이력 수정<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @exception EventException
	 */
	public void updateUpdateMvmt(CusCtmMovementVO cusCtmMovementVO) throws EventException {
		try {
			dbDao.updateMovementVO(cusCtmMovementVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - updateUpdateMvmt] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - updateUpdateMvmt] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 0422 에서 넘겨받은 Movement Update<br>
	 * 컨테이너이동 정보 등록<br>
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @exception EventException
	 */
	public void updateAddMvmt(CusCtmMovementVO[] cusCtmMovementVOs) throws EventException {
		try {
			dbDao.updateAddMvmt(cusCtmMovementVOs);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - updateAddMvmt] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - updateAddMvmt] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * [MST에서 호출] Container Movement Creation / Delete<br>
	 * Container Movement Creation / Deletebr>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @throws EventException
	 */
	public CrossItemVO manageCntrInfoFromMst(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException {
		CrossItemVO crossItemVO = new CrossItemVO();
		CusCtmMovementVO rVo = new CusCtmMovementVO();
		try {
			cusCtmMovementVO.setCreUsrId(account.getUsr_id());
			cusCtmMovementVO.setUpdUsrId(account.getUsr_id());
			cusCtmMovementVO.setOfcCd(account.getOfc_cd());
			cusCtmMovementVO.setUsrNm(account.getUsr_nm());
			cusCtmMovementVO.setCntrNo(cusCtmMovementVO.getCntrNo() == null ? "" : cusCtmMovementVO.getCntrNo().trim());
			cusCtmMovementVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd() == null ? "" : cusCtmMovementVO.getMvmtStsCd().trim());
			cusCtmMovementVO.setCnmvYr(cusCtmMovementVO.getCnmvYr() == null ? "" : cusCtmMovementVO.getCnmvYr().trim());
			cusCtmMovementVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo() == null ? "" : cusCtmMovementVO.getCnmvIdNo().trim());
			cusCtmMovementVO.setCnmvRmk(cusCtmMovementVO.getCnmvRmk() == null ? "" : cusCtmMovementVO.getCnmvRmk().trim());

			if ("D".equals(cusCtmMovementVO.getIbflag())) {
				/**********  Delete 일때  **********/
				// CTM_MOVEMENT의 최종정보가 Argument로 받은 값과 같은지 Check
				MVMTBookingInfoVO db = dbDao.searchMovementStatus(cusCtmMovementVO.getCntrNo(), "");

				log.debug("### MvmtStsCd1 :: " + cusCtmMovementVO.getMvmtStsCd());
				log.debug("### CnmvYr1 :: " + cusCtmMovementVO.getMvmtStsCd());
				log.debug("### CnmvIdNo1 :: " + cusCtmMovementVO.getMvmtStsCd());
				log.debug("### MvmtStsCd2 :: " + db.getMvmtStsCd());
				log.debug("### CnmvYr2 :: " + db.getMvmtStsCd());
				log.debug("### CnmvIdNo2 :: " + db.getMvmtStsCd());
				
				if (cusCtmMovementVO.getMvmtStsCd().equals(db.getMvmtStsCd()) &&
					cusCtmMovementVO.getCnmvYr().equals(db.getCnmvYr()) &&
					cusCtmMovementVO.getCnmvIdNo().equals(db.getCnmvIdNo())) {

					List<CusCtmMovementVO> deleteVoList = new ArrayList<CusCtmMovementVO>();
					deleteVoList.add(cusCtmMovementVO);

					dbDao.insertCtmMovementFromMst(deleteVoList);          // insert CTM_MVMT_CORR into select CTM_MOVEMENT
					dbDao.removeCtmMovementVOS(deleteVoList);          // delete CTM_MOVEMENT

				} else {
					throw new EventException(new ErrorHandler("There is no container movement last data.").getMessage());
				}

			} else {
				/**********  Insert 일때 (Ibflag값이 없어도 기본Insert) **********/
				rVo = dbDao.getCntrInfoFromMst(cusCtmMovementVO);
				String idNo  = dbDao.getContainerMaxId(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());
				String idSeq = dbDao.getContainerMaxSeq(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());

				if (idNo == null || idNo.equals("")) idNo = "0";
				if (idSeq == null || idSeq.equals("")) idSeq = "0";
				rVo.setCnmvIdNo(String.valueOf(Integer.parseInt(idNo) + 1));
				rVo.setCnmvSeq(String.valueOf(Integer.parseInt(idSeq) + 1));
				rVo.setMvmtCreTpCd(cusCtmMovementVO.getMvmtCreTpCd());
				
				if (cusCtmMovementVO.getIoFixFlag()!= null && cusCtmMovementVO.getIoFixFlag().equals("Y")){ 
					rVo.setObCntrFlg("Y");//[CHM-201322696][CHM-201323498]
				}else{
					rVo.setObCntrFlg("N");
				}
				
				// 2013.09.25 searchXXBkgNo
				// 2013.09.25 LSO, SBO, TLL시 "XX" Movement의 이전 Movement가 IC나 ID면 해당 BKG No.가 XX Movement에 입력되록 조회한다.
				if ("XX".equals(rVo.getMvmtStsCd()))
				{
					String tmpBkgNo;
					tmpBkgNo = dbDao.searchXXBkgNo(rVo.getCntrNo());
					if(tmpBkgNo != null && !tmpBkgNo.equals(""))
					{
						rVo.setBkgNo(tmpBkgNo);
						rVo.setBlNo(tmpBkgNo);
					}
				}
				
				dbDao.addCtmMovement(rVo);

				// StsCd가 "XX"이고, OrgYard 앞2자리가 KR일때 EDI를 전송
				String areaCd = (rVo.getOrgYdCd() == null ? "" : subStr(rVo.getOrgYdCd().trim(), 0, 2));
				if ("XX".equals(rVo.getMvmtStsCd()) && "KR".equals(areaCd)) {
					log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%% sendEdiToKor %%%%%%%%%%%%%%%%%%%%%%%%%%");
					sendEdiToKor(rVo, rVo.getMvmtStsCd(), rVo.getLstmCd());
				}
				
				// 2013.11.26 [CHM-201327563] 작업	
				crossItemVO.setCusCtmMovementVO(rVo);	
				
				List<SceActRcvIfVO> sceActRcvIfVOList = new ArrayList<SceActRcvIfVO>(); 
				SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();

				sceActRcvIfVO.setCntrNo(rVo.getCntrNo()); 
				sceActRcvIfVO.setBkgNo(rVo.getBkgNo()); 
				sceActRcvIfVO.setNodCd(rVo.getOrgYdCd()); 
				sceActRcvIfVO.setActStsMapgCd(rVo.getMvmtStsCd());
				sceActRcvIfVO.setActDt(rVo.getCnmvEvntDt().substring(0,8)); 
				sceActRcvIfVO.setEdiMsgTpCd(rVo.getMvmtEdiMsgTpId()); 
				sceActRcvIfVO.setCreTpCd(rVo.getMvmtCreTpCd()); 
				sceActRcvIfVO.setCreUsrId(account.getUsr_id()); 
				sceActRcvIfVO.setVndrSeq(rVo.getVndrSeq()); 
				sceActRcvIfVO.setVslCd(rVo.getCrntVslCd()); 
				sceActRcvIfVO.setSkdVoyNo(rVo.getCrntSkdVoyNo()); 
				sceActRcvIfVO.setSkdDirCd(rVo.getCrntSkdDirCd()); 
				sceActRcvIfVO.setBndVskdSeqCd(rVo.getIbflag()); 
				sceActRcvIfVO.setCnmvYr(rVo.getCnmvYr()); 
				sceActRcvIfVO.setCnmvIdNo(rVo.getCnmvIdNo()); 
				sceActRcvIfVO.setCnmvSeq(rVo.getCnmvSeq()); 
				sceActRcvIfVO.setCnmvSplitNo(rVo.getCnmvSplitNo()); 
				sceActRcvIfVO.setCnmvCycNo(rVo.getCnmvCycNo()); 
				sceActRcvIfVO.setImdtExtFlg(rVo.getImdtExtFlg());
				sceActRcvIfVOList.add(sceActRcvIfVO);

				crossItemVO.setSceActRcvIfVOs(sceActRcvIfVOList);
			}
			
		} catch (EventException ex) {
			log.error("\n\n [BCImpl - manageCntrInfoFromMst] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - manageCntrInfoFromMst] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - manageCntrInfoFromMst] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return crossItemVO;
	}

	/**
	 * SPP처리를 위한 BKG NO CHECK<br>
	 * Container Movement Creation<br>
	 * 
	 * @param String cntrNo
	 * @param String bkgNo
	 * @param String blNo
	 * @return String[]
	 * @exception EventException
	 */
	private String[] checkBkgNoFrSpp(String cntrNo, String bkgNo, String blNo) throws EventException {
		CheckBookingVO checkBookingVO = null;
		String[] rtn = new String[3];
		if (bkgNo != null && !bkgNo.equals("")) {
			//public CheckBookingVO checkBooking 부킹번호를 체크하기 위한 펑션.
			try {
				checkBookingVO = dbDao.checkBooking(bkgNo);
				rtn[2] = checkBookingVO.getBkgNo();
				if (checkBookingVO == null || checkBookingVO.getBkgNo() == null || checkBookingVO.getBkgNo().equals("")) {
					rtn[0] = "N";
					rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
					return rtn;
				}
			} catch (DAOException ex) {
				rtn[0] = "N";
				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);
			} catch (Exception ex) {
				rtn[0] = "N";
				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);
			}

		} else if (blNo != null && !blNo.equals("")) {
			try {
				checkBookingVO = dbDao.checkBlNo(blNo);
				rtn[2] = checkBookingVO.getBkgNo();
				if (checkBookingVO == null || checkBookingVO.getBkgNo() == null || checkBookingVO.getBkgNo().equals("")) {
					rtn[0] = "N";
					rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
					return rtn;
				}
			} catch (DAOException ex) {
				rtn[0] = "N";
				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);
			} catch (Exception ex) {
				rtn[0] = "N";
				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);			}
		} else {
			return rtn;
		}

		String bkg = subStr(checkBookingVO.getBkgNo(), 0, 4);
		rtn[2] = checkBookingVO.getBkgNo();
		/*
		 * 2015.12.24 추가 by Sang-Hyun Kim
		 * "TMAT", "TIND", "TESI", "THYI" Domestic booking으로 판별하도록 추가.
		 *  - HJL이 아닌 타 업체 booking no.
		 */
		if (bkg.equals("DLAX") || bkg.equals("DCHI") || bkg.equals("DHOU") || bkg.equals("DMEM") || bkg.equals("DNYC") || bkg.equals("DSEA")
				|| bkg.equals("TCHI") || bkg.equals("DHJI") || bkg.equals("THJI") || bkg.equals("TMAT") || bkg.equals("TIND") || bkg.equals("TESI")
				|| bkg.equals("THYI")) {
			rtn[0] = "N";
			rtn[1] = "Domestic BKG Error!";
			return rtn;
		}
		if (bkg.equals("POOL") || subStr(bkg, 0, 3).equals("REP")) {
			rtn[0] = "N";
			rtn[1] = "MT Repo BKG Error!";
			return rtn;
		}
		return rtn;
	}

	/**
	 * EDI에서 넘어온 자료의 Movement Status 판정 로직 INBOUND<br>
	 *
	 * @param String ibFlg
	 * @param String bkgNo
	 * @param String orgYd
	 * @param String destYd
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private String checkProcessIn(String ibFlg, String bkgNo, String orgYd, String destYd) throws EventException{
		String mvmtCd = null;
		String delCd, rcvTermCd, podCd;
		String orgScc, orgLcc, dstScc, dstLcc, delLcc, delScc;
		orgScc = orgLcc = dstScc = dstLcc = delLcc = delScc = "";
		try {
			String[] bkg = dbDao.getBkgInfoFrSpp(bkgNo);
			if (bkg == null) {
				return "Select Del_loc, Term by BKG (e-Tracker) Error(1)!";
			}
			delCd = bkg[0];
			rcvTermCd = bkg[1];
			podCd = bkg[2];
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("Select Del_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("Select Del_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
		}
		try {
			String[] lcc = dbDao.getLccRccCode(subStr(orgYd, 0, 5));
			if (lcc == null) {
				return "Select EVENT_LCC/SCC (e-Tracker) Error(1)!";
			}
			orgLcc = lcc[2];
			orgScc = lcc[3];
		} catch (DAOException e) {
			throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
		}
		if (destYd != null && !"".equals(destYd)) {
			try {
				String[] lcc = dbDao.getLccRccCode(destYd.length() < 5 ? "" : subStr(destYd, 0, 5));
				if (lcc == null) {
					return "Select DEST_LCC/SCC (e-Tracker) Error(1)!";
				}
				dstLcc = lcc[2];
				dstScc = lcc[3];
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			} catch (Exception e) {
				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			}
		}
		if (JSPUtil.getNull(delCd) != null && !"".equals(delCd)) {
			try {
				String[] lcc = dbDao.getLccRccCode(subStr(delCd, 0, 5));
				if (lcc == null) {
					return "Select DEL_LCC/SCC (e-Tracker) Error(1)!";
				}
				delLcc = lcc[2];
				delScc = lcc[3];
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("Select DEL_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			} catch (Exception e) {
				throw new EventException(new ErrorHandler("Select DEL_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			}
		}
		if (destYd == null || "".equals(destYd) || (destYd.length() > 4 && subStr(destYd, 0, 5).equals(delCd))) {
			if (orgScc.equals(delScc)) {
				mvmtCd = "ID";
			} else if (orgLcc.equals(delLcc)) {
				if (rcvTermCd.equals("D") && ibFlg.equals("I") ) {
					if (subStr(orgYd, 0, 2).equals("US")) {
						if (delCd.equals(orgYd)
								|| (orgScc.equals("USLGB") && delScc.equals("USLAX"))
								|| (orgYd.equals("USORF") && delCd.equals("USGSA")) ) {

							mvmtCd = "ID";

						} else {
							try {
								String vcnt = dbDao.getCountOrgDesYd(delCd, podCd );
								if (!vcnt.equals("0"))
									mvmtCd = "TN";
								else
									mvmtCd = "ID";
							} catch (DAOException ex) {
								/***************************************************************
								 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
								 ***************************************************************/
								mvmtCd = "ID";
								log.error("err " + ex.toString(), ex);
							} catch (Exception ex) {
								/***************************************************************
								 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
								 ***************************************************************/
								mvmtCd = "ID";
								log.error("err " + ex.toString(), ex);
							}
						}
					} else {
						mvmtCd = "ID";
					}
				} else {
					mvmtCd = "TN";
				}
			} else {
				mvmtCd = "EN";
			}
		} else {
			if (orgLcc.equals(dstLcc)) {
				mvmtCd = "TN";
			} else {
				mvmtCd = "EN";
			}
		}
		return mvmtCd;
	}

	/**
	 * EDI에서 넘어온 자료의 Movement Status 판정 로직 OUTBOUND<br>
	 *
	 * @param String ibFlg
	 * @param String fCntr
	 * @param String bkgNo
	 * @param String orgYd
	 * @param String destYd
	 * @return String
	 * @exception EventException
	 */
	private String checkProcessOut(String ibFlg, String fCntr, String bkgNo, String orgYd, String destYd) throws EventException{
		String mvmtCd = null;
		String polCd;
		String orgLcc,  dstLcc;
		 orgLcc = dstLcc = "";

		if (fCntr.equals("M") || fCntr.equals("N")) mvmtCd = "TN";
		else {
			try {
				String[] bkg = dbDao.getBkgInfoFrSpp(bkgNo);
				if (bkg == null) {
					return "Select Del_loc, Term by BKG (e-Tracker) Error(1)!";
				}
				polCd = bkg[3];
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("Select POL_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
			} catch (Exception e) {
				throw new EventException(new ErrorHandler("Select POL_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
			}

			if (destYd == null || destYd.equals("")) destYd = polCd;

			try {
				String[] lcc = dbDao.getLccRccCode(subStr(orgYd, 0, 5));
				if (lcc == null) {
					return "Select EVENT_LCC/SCC (e-Tracker) Error(1)!";
				}
				orgLcc = lcc[2];
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			} catch (Exception e) {
				throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			}
			try {
				String[] lcc = dbDao.getLccRccCode(destYd.length() < 5 ? "" : subStr(destYd, 0, 5));
				if (lcc == null) {
					return "Select DEST_LCC/SCC (e-Tracker) Error(1)!";
				}
				dstLcc = lcc[2];
			} catch (DAOException e) {
				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			} catch (Exception e) {
				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
			}
			if (orgLcc.equals(dstLcc)) {
				mvmtCd = "TN";
			} else {
				mvmtCd = "EN";
			}
		}
		return mvmtCd;
	}

	/**
	 * EES_CTM_0456 : PreVLVD List를 Search합니다.<br>
	 *
	 * @param SearchPreVLVDListVO searchPreVLVDListVO
	 * @return List<SearchPreVLVDListVO>
	 * @exception EventException
	 */
	public List<SearchPreVLVDListVO> searchPreVLVDList(SearchPreVLVDListVO searchPreVLVDListVO) throws EventException {
		try {
			return dbDao.searchPreVLVDList(searchPreVLVDListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchPreVLVDList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchPreVLVDList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

	}

	/**
	 * EES_CTM_0456 : PreVLVD List를 updade/delete합니다.<br>
	 *
	 * @param SearchPreVLVDListVO[] searchPreVLVDListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePreVLVD(SearchPreVLVDListVO[] searchPreVLVDListVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SearchPreVLVDListVO> updateVoList = new ArrayList<SearchPreVLVDListVO>();
			List<SearchPreVLVDListVO> deleteVoList = new ArrayList<SearchPreVLVDListVO>();
			for ( int i=0; i<searchPreVLVDListVOs .length; i++ ) {
				searchPreVLVDListVOs[i].setUserId(account.getUsr_id());
					if ( searchPreVLVDListVOs[i].getIbflag().equals("U")){
						searchPreVLVDListVOs[i].setRemark(searchPreVLVDListVOs[i].getRemark().replaceAll("'", "^#^"));
						updateVoList.add(searchPreVLVDListVOs[i]);
					} else if ( searchPreVLVDListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(searchPreVLVDListVOs[i]);
					}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyManagePreVLVDs(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeManagePreVLVDs(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - managePreVLVD] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - managePreVLVD] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EAI 전송
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String ediSts
	 * @param String lstrmCd
	 * @return String
	 * @throws EventException
	 */
	public String sendEdiToKor(CusCtmMovementVO cusCtmMovementVO, String ediSts, String lstrmCd) throws EventException{
		log.info("\n\n%%%%%%%%%%%%%%%%%  sendEdiToKor Hanjin  %%%%%%%%%%%%%%%%%\n");
		// OrgYardCd 앞2자리가 KR일때 EDI를 전송
		if (!"KR".equals(subStr(cusCtmMovementVO.getOrgYdCd(), 0, 2))) {
			log.info("\n\nYardCode Location ::: " + subStr(cusCtmMovementVO.getOrgYdCd(), 0, 2) + " (not KR!!)");
			return "";
		}

		try {
			// BOOKING에서 POL, POR, POD, DEL Location을 얻어온다.
			String bkgNo = cusCtmMovementVO.getBkgNo() ;
			String polCd = "     ";
			String podCd = "     ";
			String porCd = "     ";
			String delCd = "     ";
			if (bkgNo != null && !"".equals(bkgNo)) {
				String[] locatonInfo = dbDao.getLocationInfo(bkgNo);
				polCd = locatonInfo[0];
				porCd = locatonInfo[1];
				podCd = locatonInfo[2];
				delCd = locatonInfo[3];
			}
			// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
			StringBuffer cntrNo = new StringBuffer();
			cntrNo.append(cusCtmMovementVO.getCntrNo());
			String checkDgt = cusCtmMovementVO.getCheckDigit();
			String fmFlg = cusCtmMovementVO.getFcntrFlg();
			if (fmFlg == null || "".equals(fmFlg.trim()) || "N".equals(fmFlg.trim()) || "M".equals(fmFlg.trim()) || "E".equals(fmFlg.trim())) {
				fmFlg = "M";
			} else {
				fmFlg = "F";
			}
			if (checkDgt != null && !"".equals(checkDgt) && !"null".equals(checkDgt)) {
				// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
//				cntrNo = cntrNo + checkDgt;
				cntrNo.append(checkDgt);
			}
			if (cntrNo.length() < 11)
				for (int i = cntrNo.length(); i <= 11; i++)
//					cntrNo = cntrNo + " ";
					// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
					cntrNo.append(" ");
			String actionDt = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			if (polCd.length() < 5) polCd = "     ";
			if (podCd.length() < 5) podCd = "     ";
			if (porCd.length() < 5) porCd = "     ";
			if (delCd.length() < 5) delCd = "     ";
			String evntDt = cusCtmMovementVO.getCnmvEvntDt().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "") + "00";
			// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
			StringBuffer sealNo = new StringBuffer();
			sealNo.append(cusCtmMovementVO.getCntrSealNo() == null ? "" : cusCtmMovementVO.getCntrSealNo().trim());
//			String sealNo = (cusCtmMovementVO.getCntrSealNo() == null ? "" : cusCtmMovementVO.getCntrSealNo().trim());
			for (int i=sealNo.length(); i < 10; i++) {
				// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
//				sealNo = sealNo + " ";
				sealNo.append(" ");
			}

			// FLAT FILE 생성
			StringBuilder flatFile = new StringBuilder();
			if ("VL".equals(ediSts)) {
				flatFile.append("INTHJSEQMVL");          // Header
				flatFile.append(cusCtmMovementVO.getOrgYdCd());        // Origin Yard Code
				flatFile.append("       ");              // Terminal
				flatFile.append(cntrNo);                 // Container No
				flatFile.append("   ");                  // Space
				flatFile.append(actionDt);               // Action Date
				flatFile.append("  ");                   // T/S
				flatFile.append(cusCtmMovementVO.getCrntVslCd());      // Vessel Code
				flatFile.append(cusCtmMovementVO.getCrntSkdVoyNo());   // Schedule Voyage No
				flatFile.append(cusCtmMovementVO.getCrntSkdDirCd());   // Schedule Direction Code
				flatFile.append("        ");             // Vendor
				flatFile.append(polCd);                  // POL Location
				flatFile.append(podCd);                  // POD Location
				flatFile.append(porCd);                  // POR Location
				flatFile.append(delCd);                  // DEL Location
				flatFile.append(sealNo);                 // Seal Number
				flatFile.append(subStr(evntDt, 0, 14));                 // Event Date Time
				flatFile.append("       ");              // Departure
				flatFile.append("     ");                // Destination
				flatFile.append("       ");              // Arrival
				flatFile.append(" ");                    // Transfer Ship
				flatFile.append("         ");            // FVVD
				flatFile.append(fmFlg);       // F/M Flag
				flatFile.append(" ");                    // Shipper's Own
				flatFile.append("            ");         // Service Order No
				flatFile.append("       ");              // Customer Name
				flatFile.append("              ");       // Pick-up Date
				flatFile.append(" ");                    // Hanger
				flatFile.append(" ");                    // I/O
				flatFile.append("  ");                   // Substination
				flatFile.append(" ");                    // Trans Mode
				flatFile.append("N");                    // Delete Tag
				for (int i = 0; i < 390; i++) {
					flatFile.append(" ");
				}
				flatFile.append("####");                 // ####

			} else if ("VD".equals(ediSts)) {
				flatFile.append("INTHJSEQMVD");          // Header
				flatFile.append(cusCtmMovementVO.getOrgYdCd());        // Origin Yard Code
				flatFile.append("       ");              // Terminal
				flatFile.append(cntrNo);                 // Container No
				flatFile.append("   ");                  // Space
				flatFile.append(actionDt);                 // Action Date
				flatFile.append("  ");                   // T/S
				flatFile.append(cusCtmMovementVO.getCrntVslCd());      // Vessel Code
				flatFile.append(cusCtmMovementVO.getCrntSkdVoyNo());   // Schedule Voyage No
				flatFile.append(cusCtmMovementVO.getCrntSkdDirCd());   // Schedule Direction Code
				flatFile.append("        ");             // Vendor
				flatFile.append(polCd);                  // POL Location
				flatFile.append(podCd);                  // POD Location
				flatFile.append(porCd);                  // POR Location
				flatFile.append(delCd);                  // DEL Location
				flatFile.append(sealNo);                 // Seal Number
				flatFile.append(subStr(evntDt, 0, 14));                 // Event Date Time
				flatFile.append("       ");              // Departure
				flatFile.append("     ");                // Destination
				flatFile.append("       ");              // Arrival
				flatFile.append(" ");                    // Transfer Ship
				flatFile.append("         ");            // FVVD
				flatFile.append(fmFlg);       // F/M Flag
				if ("SH".equals(lstrmCd)) {
					flatFile.append("Y");                    // Shipper's Own
				} else {
					flatFile.append("N");                    // Shipper's Own
				}
				flatFile.append("            ");         // Service Order No
				flatFile.append("       ");              // Customer Name
				flatFile.append("              ");       // Pick-up Date
				flatFile.append(" ");                    // Hanger
				flatFile.append(" ");                    // I/O
				if ("Y".equals(cusCtmMovementVO.getImdtExtFlg())) {
					flatFile.append("Y ");                   // Substination
				} else {
					flatFile.append("N ");                   // Substination
				}
				flatFile.append(" ");                    // Trans Mode
				flatFile.append("N");                    // Delete Tag
				for (int i = 0; i < 390; i++) flatFile.append(" ");
				flatFile.append("####");

			} else if ("ID".equals(ediSts) || "XX".equals(ediSts)) {
				// ID XX 시 원래는 H였으나 스팩 변경 됨. 2010.2.16
				flatFile.append("INTHJSEQM");         // Company Indicator
				flatFile.append("UI");                // UI
				flatFile.append(cusCtmMovementVO.getOrgYdCd());     // Origin Yard Code
				flatFile.append(cntrNo);              // Container No
				flatFile.append("   ");               // Space
				flatFile.append(actionDt);            // Action Date
				flatFile.append(cusCtmMovementVO.getCntrTpszCd());  // Container Type Size Code
				if ("ID".equals(ediSts)) {
					flatFile.append("A");             // "ID"일때 Active/Inactive
				} else if ("XX".equals(ediSts)) {
					flatFile.append("I");             // "XX"일때 Active/Inactive
				}
				if ("Y".equals(lstrmCd)) {
					flatFile.append("Y");             // UI Immediately Exit Flag
				} else {
					flatFile.append("N");             // UI Immediately Exit Flag
				}
				if ("SH".equals(lstrmCd)) {
					log.info("SH:Y ");
					flatFile.append("Y");                    // Shipper's Own
				} else {
					log.info("SH:N ");
					flatFile.append("N");                    // Shipper's Own
				}
				flatFile.append("                    "); // Space
				flatFile.append("###");

			} else if ("DVL".equals(ediSts) || "DVD".equals(ediSts)) {
				flatFile.append("INTHJSEQM");                        // Header
				flatFile.append(subStr(ediSts, 1, 3));                // Mvmt Sts Cd
				flatFile.append(cusCtmMovementVO.getOrgYdCd());        // Origin Yard Code
				flatFile.append("       ");                            // Terminal (Author)
				flatFile.append(cntrNo);                               // Container No
				flatFile.append("   ");                                // Space
				flatFile.append(actionDt);                             // Action Dt
				flatFile.append("  ");                                 // T/S
				flatFile.append(cusCtmMovementVO.getCrntVslCd());      // Vessel Code
				flatFile.append(cusCtmMovementVO.getCrntSkdVoyNo());   // Schedule Voyage No
				flatFile.append(cusCtmMovementVO.getCrntSkdDirCd());   // Schedule Direction Code
				flatFile.append("        ");             // Departure
				flatFile.append(cusCtmMovementVO.getVndrSeq());        // Vender
				flatFile.append(polCd);                  // POL Location
				flatFile.append(podCd);                  // POD Location
				flatFile.append(porCd);                  // POR Location
				flatFile.append(delCd);                  // DEL Location
				flatFile.append(sealNo);                 // Seal Number
				flatFile.append(subStr(evntDt, 0, 14)); // Evnt Dt
				flatFile.append("       ");              // Departure
				flatFile.append("     ");                // Destination
				flatFile.append("       ");              // Arrival
				flatFile.append(" ");                    // Transfer Ship
				flatFile.append("         ");            // FVVD
				flatFile.append(fmFlg);       // F/M Flag
				if ("SH".equals(lstrmCd)) {
					log.info("SH:Y ");
					flatFile.append("Y");                    // Shipper's Own
				} else {
					log.info("SH:N ");
					flatFile.append("N");                    // Shipper's Own
				}
				flatFile.append("            ");         // Service Order No
				flatFile.append("       ");              // Customer Name
				flatFile.append("              ");       // Pick-up Date
				flatFile.append(" ");                    // Hanger
				flatFile.append(" ");                    // I/O
				if ("Y".equals(cusCtmMovementVO.getImdtExtFlg())) {
					flatFile.append("Y ");                   // Substination
				} else {
					flatFile.append("N ");                   // Substination
				}
				flatFile.append(" ");                    // Trans Mode
				flatFile.append("Y");                    // Delete Tag
				for (int i = 0; i < 390; i++) {
					flatFile.append(" ");
				}
				flatFile.append("####");

			} else {
				flatFile = new StringBuilder();
			}

			if ("".equals(flatFile.toString())) {
				log.error("\n\n%%%%%%%%%%%%%%%%%  sendEdiToKor : flatFile is null  %%%%%%%%%%%%%%%%%\n");
				return "";
			} else {
				ContainerMovementMgtEAIDAO eaiDao = new ContainerMovementMgtEAIDAO();
				log.info("\n\n%%%%%%%%%%%%%%%%% flatFile : " + flatFile.toString() + "\n");
				return eaiDao.sendEdiContainerMovementdo(flatFile.toString());
			}

		} catch (DAOException  ex) {
			log.error("\n\n [BCImpl - sendEdiToKor] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("EDI SEND ERROR!").getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - sendEdiToKor] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("EDI SEND ERROR!").getMessage(), ex);
		}
	}

	/**
	 * BKG
	 * CTM_MVMT_IRR의 STL FLG Update.<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNo
	 * @throws EventException
	 */
	public void updateCtmMvmtIrrFromBkg(String cntrNo, String bkgNo) throws EventException {
		try {
			dbDao.updateCtmMvmtIrrFromBkg(cntrNo, bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - updateCtmMvmtIrrFromBkg] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - updateCtmMvmtIrrFromBkg] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 신조장비의 MT상태 처리<br>
	 * Container Movement  MT Status Creation<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @return CusCtmMovementVO
	 * @throws EventException
	 */
	public CusCtmMovementVO insCntrInfoFromMtSts(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException {
		CusCtmMovementVO rVo = new CusCtmMovementVO();
		try {
			cusCtmMovementVO.setCreUsrId(account.getUsr_id());
			cusCtmMovementVO.setUpdUsrId(account.getUsr_id());
			cusCtmMovementVO.setOfcCd(account.getOfc_cd());
			cusCtmMovementVO.setUsrNm(account.getUsr_nm());
			if (cusCtmMovementVO.getCheckDigit() != null && !cusCtmMovementVO.getCheckDigit().equals(""))
				cusCtmMovementVO.setCntrNo(cusCtmMovementVO.getCntrNo() + cusCtmMovementVO.getCheckDigit());
			// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
			StringBuffer evntDt = new StringBuffer();
			evntDt.append(cusCtmMovementVO.getCnmvEvntDt());
//			String evntDt = cusCtmMovementVO.getCnmvEvntDt();
			StringBuffer evntBk = new StringBuffer();
			evntBk.append(evntDt);
//			String evntBk = evntDt;
//			evntDt = subStr(evntDt, 0, 4) + "-" + subStr(evntDt, 4, 6) + "-" + subStr(evntDt, 6, 8);
			evntDt.insert(0, evntDt.substring(0, 4));
			evntDt.append("-");
			evntDt.append(evntDt.substring(4, 6));
			evntDt.append("-");
			evntDt.append(evntDt.substring(6, 8));
			String idNo  = dbDao.getContainerMaxId(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());
			String idSeq = dbDao.getContainerMaxSeq(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());
			if (idNo == null || idNo.equals("")) idNo = "0";
			if (idSeq == null || idSeq.equals("")) idSeq = "0";
			idNo  = String.valueOf(Integer.parseInt(idNo)+1);
			idSeq = String.valueOf(Integer.parseInt(idSeq)+1);
			cusCtmMovementVO.setCnmvEvntDt(evntDt.toString());
			cusCtmMovementVO.setCnmvIdNo(idNo);
			cusCtmMovementVO.setCnmvSeq(idSeq);
			rVo = dbDao.getCntrInfoFromMst(cusCtmMovementVO);
			dbDao.addCtmMovement(rVo);
			cusCtmMovementVO.setCnmvEvntDt(evntBk.toString());
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - insCntrInfoFromMtSts] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - insCntrInfoFromMtSts] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return rVo;
	}

	/**
	 * EES_CTM_0404<br>
	 * Container No와 EDI키값으로 Bkg list를 가져오기<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] getBkgNoByEDICntrInfo(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		try {
			return dbDao.getBkgNoByEDICntrInfo(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - getBkgNoByEDICntrInfo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - getBkgNoByEDICntrInfo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * VL/VD Correction 정보를 조회한다.<br>
	 *
	 * @param CorrectionVLVDListVO correctionVLVDListVO
	 * @return List<CorrectionVLVDListVO>
	 * @throws EventException
	 */
	public List<CorrectionVLVDListVO> searchCorrectionVLVDListByVVD(CorrectionVLVDListVO correctionVLVDListVO) throws EventException {
		try {
			return dbDao.searchCorrectionVLVDListByVVD(correctionVLVDListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - searchCorrectionVLVDListByVVD] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - searchCorrectionVLVDListByVVD] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

    /*=========================================================
     * 2010.09.09 김상수 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
     *                   - 자동생성 Status가 OP가 발생하면 상위 메서드인 manageStsOperation에 값을 return
	 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
	 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
	 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
	 *                     자동생성 로직이 탈수있도록 소스수정
	 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
	 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
	 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
	 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
	 * 2013.08.02 강   환 [CHM-201325779] Auto 생성된  MVMT의 Bkg 과 B/L을 동일하게 유지
     *=========================================================*/
	/**
	 * CTM MOVEMENT COMMON 자동 생성 로직<br>
	 * Container Movement Auto Creation<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVo 	: 입력할 Movement
	 * @param CusCtmMovementVO prevCtmMovementVO	: 현재 입력된 마지막 Movement
	 * @param MstContainerInfoVO mstContainerInfoVO	: 마스터 컨테이너
	 * @param BkgBookingInfoVO bkgBookingInfoVO		: BkgBooking
	 * @param CheckBookingVO checkBookingVO			: 용도 없음
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO		: 전전 Movement
	 * @param String[] autoParam					: 내용은 본문 참조
	 * @return String[]
	 * @exception DAOException
	 * @exception EventException
	 */
	private String[] autoCre(CusCtmMovementVO cusCtmMovementVo, CusCtmMovementVO prevCtmMovementVO, MstContainerInfoVO mstContainerInfoVO, BkgBookingInfoVO bkgBookingInfoVO, CheckBookingVO checkBookingVO, CtmCntrMovInfoVO ctmCntrMovInfoVO, String[] autoParam) throws EventException {
		String cycNo     = autoParam[0]  ;	// 사이클 번호
		String idNo   	 = autoParam[1]  ;	// 최종 CNTR_ID_NO
		String idSeq  	 = autoParam[2]  ;	// 최종 CNTR_ID_SEQ
		String fmFlag 	 = autoParam[3]  ;	// Full/Empty Flag
		String yardCdEq	 = autoParam[4]  ;	// 최종 Yard와 입력 대싱 Yard의 동일여부
		String ofcCd  	 = autoParam[5]  ;	// Office Code
		String userId 	 = autoParam[6]  ;	// User ID		: Session에서 얻어옴
		String userNm 	 = autoParam[7]  ;	// User Name	: Session에서 얻어옴.
		String svrId  	 = autoParam[8]  ;	// 야드가 속해있는 서버아이디
		String inpType	 = autoParam[9]  ;	// 생성되는 속성
		String vslCd 	 = autoParam[10] ;	// VVD CODE
		String skdVoyCd  = autoParam[11] ;	// VVD CODE
		String skdDirCd  = autoParam[12] ;	// VVD CODE
		String blNo	     = autoParam[13] ;	// BL CODE
		String errMsg    = "";

		List<AutoCreItemVO> autoItem = null;
		CusCtmMovementVO cusCtmMovementVO = (CusCtmMovementVO)cusCtmMovementVo.clone();

		String mvmtStsCd = cusCtmMovementVO.getMvmtStsCd(); // MOVEMENT STATUS
		String yardCd    = cusCtmMovementVO.getOrgYdCd();
		String evntDt    = cusCtmMovementVO.getCnmvEvntDt();

		String[] rtnVal = new String[6];
		rtnVal[0] = "";
		rtnVal[1] = "";
		rtnVal[2] = "";   // 자동생성시 OP가 발생되었을 경우 상위 메서드인 manageStsOperation(동일 BCImpl)으로 구분값 return
		rtnVal[3] = "";
		rtnVal[4] = idNo;
		rtnVal[5] = idSeq;

		boolean i_ignore_VVD = false;

		try {
			/****************************************************
			 * 자동생성시 Booking Cntr을 찾지 않도록 조정. 10.15  *
			 ****************************************************/
			String ppSts = "";
			if (ctmCntrMovInfoVO != null && ctmCntrMovInfoVO.getMvmtStsCd() != null) {
				ppSts = ctmCntrMovInfoVO.getMvmtStsCd();
			}
			// 이전 Sts가 ID이고 현재 Sts가 (MT)VL 일때 메세지를 분리
			if ("ID".equals(prevCtmMovementVO.getMvmtStsCd()) && "VL".equals(mvmtStsCd) && "M".equals(fmFlag)) {
				errMsg = "Please create MT status first.";
			} else {
				// errMsg= "Movement creation error [auto creation][" + prevCtmMovementVO.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
				String messages[] = getErrMsg(prevCtmMovementVO.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag, cusCtmMovementVo);
				errMsg = messages[0];
			}

			log.info("\n\n      STS : " + mvmtStsCd +
					   "\n PREV STS : " + prevCtmMovementVO.getMvmtStsCd() +
					   "\n PPRV STS : " + ppSts +
					   "\n YARD EQ  : " + yardCdEq +
					   "\n FULL FLG : " + fmFlag +
					   "\n PREV FLG : " + prevCtmMovementVO.getFcntrFlg() +
					   "\n BBLK FLG : " + cusCtmMovementVo.getBbulkFlg() + "\n");

			if ("MT".equals(prevCtmMovementVO.getMvmtStsCd()) && "VL".equals(mvmtStsCd) && "Y".equals(cusCtmMovementVo.getBbulkFlg())) {
				// 2010-10-18 : MT -> VL(Full && B.Bulk)일 경우 OP,OC가 자동생성되도록 setting - Rqsty by IHJang
				autoItem = new ArrayList<AutoCreItemVO>();
				AutoCreItemVO autoCreItemVO = null;

				for (int i=0; i<2; i++) {
					autoCreItemVO = new AutoCreItemVO();
					if (i == 0) {
						autoCreItemVO.setAuto("OP(CY)");
						autoCreItemVO.setAsSts("OC");
					} else {
						autoCreItemVO.setAuto("OC(AY)");
						autoCreItemVO.setAsSts("VL");
					}
					autoCreItemVO.setTar("C");
					autoCreItemVO.setResult("OK");
					autoCreItemVO.setCreUsrId("test");

					autoItem.add(autoCreItemVO);
				}

			} else {
				// 그 외 모든 일반적인 경우
				/**  dbDao.checkAutoCreItem(현재Status, 이전Status, 전전Status, YARD EQ, 현재F/M Flag, 이전F/M Flag)  **/
				autoItem = dbDao.checkAutoCreItem(("TN".equals(mvmtStsCd) ? "EN" : mvmtStsCd), prevCtmMovementVO.getMvmtStsCd(), ppSts, yardCdEq, fmFlag, prevCtmMovementVO.getFcntrFlg());
			}

			AutoCreItemVO act = null;
			// 결과 집합이 아무것도 없는 경우 (NULL) 에러로 간주된다. 최소한 1개 이상 나와야 한다
			// 결과 집합을 가져올때 입력할 MVMT_STS_CD가 TN인 경우 EN으로 입력해서 결과를 받아온다.
			if (JSPUtil.getNull(autoItem) == null || autoItem.size() == 0) {
				// 처리할 내역이 없다. ERROR.
				if (autoItem.size() == 0) {
					rtnVal[0] = "N";
					// rtnVO[1] = "Movement creation error [auto creation][" + prevCtmMovementVO.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
					String messages[] = getErrMsg(prevCtmMovementVO.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag, cusCtmMovementVo);
					rtnVal[1] = messages[0];
					rtnVal[2] = messages[1];
					return rtnVal;
				}

			} else {

				CusCtmMovementVO cVO = null;
				// autoItem에서 지정 하는 수 만큼 반복하면서 이전 Sts Cd를 자동 생성 한다.
				for (int i=0; i<autoItem.size(); i++) {
					act = autoItem.get(i);
					String autoSts = subStr(act.getAuto(), 0, 2);
					String asSts = act.getAsSts();
					if (!asSts.equals(mvmtStsCd) && !"TN".equals(mvmtStsCd) && !"VL".equals(mvmtStsCd)) {
						rtnVal[0] = "Y";
						rtnVal[1] = asSts;
					}
					// 생성하는 유형이 (Tar) C인 경우와 그렇지 않은 경우로 구분한다.
					// C인경우는 신규 입력 : 생성해야 하는 STS에서 데이터를 넘겨받는다
					// 그렇지 않은 경우 이미 입력된 MVMT의 마지막 데이터를 넘겨받는다
					// BKG BL 등등을 모두 입력받기 위해 처리하는 부분임.
					if (act.getTar() != null && "C".equals(act.getTar())) {
						cVO = cusCtmMovementVO;
						if ("VL".equals(autoSts) || "VD".equals(autoSts)) {
							cVO.setCrntVslCd(cVO.getTrnkVslCd());
							cVO.setCrntSkdVoyNo(cVO.getTrnkSkdVoyNo());
							cVO.setCrntSkdDirCd(cVO.getTrnkSkdDirCd());
						} else {
							if ((cVO.getTrnkVslCd() == null || cVO.getTrnkVslCd().equals(""))) {
								cVO.setTrnkVslCd(vslCd);
								cVO.setTrnkSkdVoyNo(skdVoyCd);
								cVO.setTrnkSkdDirCd(skdDirCd);
								cVO.setBlNo(blNo);
							}
						}
						cVO.setCtrtOfcCtyCd(mstContainerInfoVO.getAgmtCtyCd());
						cVO.setCtrtSeq(mstContainerInfoVO.getAgmtSeq());
						// nBkgNoFlg가 False일 경우에만 부킹번호를 입력해 준다. True = MT VL임
						if (cVO.getFcntrFlg() == null || cVO.getFcntrFlg().equals("")) {
							cVO.setFcntrFlg(fmFlag);
						}
					} else {
						log.info ("부킹........ 이전것");
						cVO =(CusCtmMovementVO) prevCtmMovementVO.clone();
					}
					if ("TN".equals(autoSts)) {
						autoSts = "EN";
					}
					// 자동생성 해야하는 STS가 TN일경우 EN과 TN을 판별한다
					if (autoSts.equals("EN") || autoSts.equals("TN")) {
						String locationCd = null;
						errMsg = "EN/TN same location";
						locationCd = dbDao.checkLocationCd(yardCd, prevCtmMovementVO.getOrgYdCd());
						if (locationCd == null) {
							rtnVal[0] = "N";
							rtnVal[1] = "EN/TN same location";
							return rtnVal;
						} else if ("N".equals(locationCd)) {
							autoSts = "EN";
						} else {
							autoSts = "TN";
						}
					}
					log.info("AUTO RESULT " + act.getResult());
					if (!act.getResult().equals("OK")) {
						rtnVal[0] = "N";
						// rtnVO[1] = "Movement creation error [auto creation][" + prevCtmMovementVO.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
						String messages[] = getErrMsg(prevCtmMovementVO.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag, cusCtmMovementVo);
						rtnVal[1] = messages[0];
						rtnVal[2] = messages[1];
						return rtnVal;
					}
					if ("CY".equals(subStr(act.getAuto(), 3, 5))) {
						cVO.setOrgYdCd(prevCtmMovementVO.getOrgYdCd());
					} else {
						cVO.setOrgYdCd(yardCd);
					}
					// 2015.02.09 Add EN/TN - OC(Auto Creation) - EN/TN , OC yacd code set post yard code
					if ("OC".equals(autoSts)) cVO.setOrgYdCd(yardCd);
					cVO.setOfcCd(ofcCd);

					if ("clear".equals(act.getCreUsrId())) {
						// TRUNK 초기화
						cVO.setCrntSkdDirCd("");
						cVO.setCrntSkdVoyNo("");
						cVO.setCrntVslCd("");
						cVO.setTrnkSkdDirCd("");
						cVO.setTrnkSkdVoyNo("");
						cVO.setTrnkVslCd("");
						// BOOKING 초기화
						cVO.setBlNo("");
						cVO.setBkgNo("");
						// 기타 초기화
						cVO.setBkgCgoTpCd("");
						cVO.setFcntrFlg("M");
						cVO.setCnmvLvlNo("0");
					}
					log.info("자동생성" + autoSts);
					cVO.setCreUsrId(userId);
					cVO.setUpdUsrId(userId);
					cVO.setUsrNm(userNm);

					if ("C".equals(act.getTar())) {
						// 신규 입력
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" Creation error][Auto]";
						cVO.setMvmtStsCd(autoSts);
						cVO.setCnmvEvntDt(evntDt);
						cVO.setObCntrFlg(prevCtmMovementVO.getObCntrFlg());

						if ("OP".equals(autoSts)) {
							cVO.setObCntrFlg("O");
							cVO.setFcntrFlg("M");
							// 자동생성시 OP가 발생되었을 경우 상위 메서드인 manageStsOperation(동일 BCImpl)으로 구분값 return
//							rtnVal[2] = "OP";    2010.10.15 임시주석처리

						} else if ("OC".equals(autoSts)) {
							cVO.setObCntrFlg("O");
							cVO.setFcntrFlg("F");
						}

						if (!"clear".equals(act.getCreUsrId())) {
							if (blNo != null && !"".equals(blNo)) {
								cVO.setBlNo(blNo);
							} else if (!prevCtmMovementVO.getBlNo().equals("")) {
								cVO.setBlNo(prevCtmMovementVO.getBlNo());
							}
						}

						// VL VD는 자동생성 되지 않는다! Crnt VSL은 절대 입력되지 않도록 제거해준다.
						// (VL/VD인경우 넘겨받기 때문)
						cVO.setCrntVslCd("");
						cVO.setCrntSkdVoyNo("");
						cVO.setCrntSkdDirCd("");
						// Crnt는 입력되지 않으나 Trnk는 입력해야 한다.
						// 경우에 따라 입력하는 값이 달라질 수 있기 때문에 별도로 처리.
						if (!act.getCreUsrId().equals("clear") && cusCtmMovementVO.getBkgRcvTermCd() != null && !cusCtmMovementVO.getBkgRcvTermCd().equals("")) {
							cVO.setBkgRcvTermCd(cusCtmMovementVO.getBkgRcvTermCd());
						} else if (!act.getCreUsrId().equals("clear") && prevCtmMovementVO != null && prevCtmMovementVO.getBkgRcvTermCd() != null && !prevCtmMovementVO.getBkgRcvTermCd().equals("")) {
							cVO.setBkgRcvTermCd(prevCtmMovementVO.getBkgRcvTermCd());
						}
						if (cVO.getBkgNo() == null || cVO.getBkgNo().equals("")) {
							cVO.setBkgRcvTermCd("");
						}
						if (!act.getCreUsrId().equals("clear") && cusCtmMovementVO.getTrnkVslCd() != null && !cusCtmMovementVO.getTrnkVslCd().equals("")) {
							cVO.setTrnkVslCd(cusCtmMovementVO.getTrnkVslCd());
							cVO.setTrnkSkdVoyNo(cusCtmMovementVO.getTrnkSkdVoyNo());
							cVO.setTrnkSkdDirCd(cusCtmMovementVO.getTrnkSkdDirCd());
						} else if(!act.getCreUsrId().equals("clear")){
							cVO.setTrnkVslCd(prevCtmMovementVO.getTrnkVslCd());
							cVO.setTrnkSkdVoyNo(prevCtmMovementVO.getTrnkSkdVoyNo());
							cVO.setTrnkSkdDirCd(prevCtmMovementVO.getTrnkSkdDirCd());
						}

						if ("OP".equals(autoSts)) {
							if (cVO.getTrnkVslCd() != null && !cVO.getTrnkVslCd().equals("")
									&& (!cVO.getTrnkVslCd().equals(prevCtmMovementVO.getTrnkVslCd())
											|| !cVO.getTrnkSkdDirCd().equals(prevCtmMovementVO.getTrnkSkdDirCd())
											|| !cVO.getTrnkSkdVoyNo().equals(prevCtmMovementVO.getTrnkSkdVoyNo())
											|| !cVO.getBkgNo().equals(prevCtmMovementVO.getBkgNo())
											|| i_ignore_VVD == true)) {
								if (!cVO.getMvmtStsCd().equals("VD")) {
									cycNo = (String.valueOf(Integer.parseInt(prevCtmMovementVO.getCnmvCycNo()) + 1));
								}
							}
						} else {
							if (cVO.getTrnkVslCd() != null && !cVO.getTrnkVslCd().equals("") &&
									(!cVO.getTrnkVslCd().equals(prevCtmMovementVO.getTrnkVslCd()) || !cVO.getTrnkSkdDirCd().equals(prevCtmMovementVO.getTrnkSkdDirCd()) || !cVO.getTrnkSkdVoyNo().equals(prevCtmMovementVO.getTrnkSkdVoyNo()) || i_ignore_VVD == true)) {
								if (!cVO.getBkgNo().equals(prevCtmMovementVO.getBkgNo()) ) {
									if (prevCtmMovementVO.getFcntrFlg().equals("Y") && (prevCtmMovementVO.getBkgNo() == null || prevCtmMovementVO.getBkgNo().equals("") ) && cVO.getBkgNo().equals(ctmCntrMovInfoVO.getBkgNo()) ) {
										log.info("Full EN : BKG NO IS NOT CHANGE");
									} else {
										// 2013.07.03 [CHM-201325252] VL 이후 VVD 변경시 CYC 관련 logic 수정
										//  - 'VL'이후 'VD' 생성시  VVD 변경은 Cyc +1을 추가하지 않는다
										if (!cVO.getMvmtStsCd().equals("VD")) {
											cycNo = (String.valueOf(Integer.parseInt(prevCtmMovementVO.getCnmvCycNo()) + 1));
										}
									}
								}
							}
						}
						cVO.setCnmvCycNo(cycNo);

						String lvlCd = null;
						String cgoTp = prevCtmMovementVO.getBkgCgoTpCd();
						errMsg = "Full flag is null";
						lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, cVO.getMvmtStsCd()).getCnmvLvlNo();
						if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
						cVO.setCnmvLvlNo(lvlCd);

						if (!"clear".equals(act.getCreUsrId())) {
							if (bkgBookingInfoVO == null && !"MT".equals(mvmtStsCd) && !"TN".equals(mvmtStsCd) && !"EN".equals(mvmtStsCd)){
								rtnVal[0] = "N";
								rtnVal[1] = "Booking infomation does not exist[Auto creation]";
								return rtnVal;
							}
							errMsg = "Booking cgo type is null";
							if (bkgBookingInfoVO != null) {
								cgoTp = bkgBookingInfoVO.getBkgCgoTpCd();
								cVO.setBkgCgoTpCd(cgoTp);
							}
						}

						if ("MT".equals(autoSts)) {
							cVO.setFcntrFlg("N");
							if(prevCtmMovementVO.getObCntrFlg().equals("N")){
						        cVO.setBkgNo(prevCtmMovementVO.getBkgNo()); 
						        cVO.setBlNo(prevCtmMovementVO.getBlNo()); 
						    }
						} else if (("MT".equals(prevCtmMovementVO.getMvmtStsCd()) || "CM".equals(prevCtmMovementVO.getMvmtStsCd()))
								&& ("EN".equals(autoSts) || "TN".equals(autoSts))) {
							cVO.setTrnkSkdDirCd("");
							cVO.setTrnkSkdVoyNo("");
							cVO.setTrnkVslCd("");
							cVO.setBkgCgoTpCd("");
							cVO.setBkgRcvTermCd("");
							cVO.setBlNo("");
							cVO.setBkgNo("");
							cVO.setFcntrFlg("N");
						}
						else if("ID".equals(autoSts)) { // 2013.08.02 강환 - Auto 생성된  MVMT의 Bkg 과 B/L을 동일하게 유지 [CHM-201325779]
					        cVO.setBlNo(cVO.getBkgNo());
					        cVO.setFcntrFlg("Y"); // 2013.10.04 강환 - ID Movement는 Full로만 생성됨
						}
						cVO.setMvmtCreTpCd("A");
						cVO.setMvmtInpTpCd(inpType);
						cVO.setCntrSvrId(svrId);
						cVO.setBkgKnt(prevCtmMovementVO.getBkgKnt());
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" create error][Auto]";
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						cVO.setCnmvIdNo(idNo);
						cVO.setCnmvSeq(idSeq);
						dbDao.addCtmMovement(cVO);

					} else if ("U1".equals(act.getTar())) {
						// 이전 상태 업데이트
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" update(1) error][Auto]";
						cVO.setMvmtStsCd(autoSts);
						if ("CY".equals(subStr(act.getAuto(), 3, 5))) {
							cVO.setOrgYdCd(prevCtmMovementVO.getOrgYdCd());
						} else {
							cVO.setOrgYdCd(yardCd);
						}
						
						//CTM_MVMT_EVNT_DT_HIS Table에 Insert
						dbDao.addComMvmtEventDateHistory(cVO);
						
						if ("OP".equals(autoSts)) {    //**** 전전:MT/전:EN/입력:OC이고, 전:EN을 OP로 Update시 *****
							// TRUNK Setting
							cVO.setCrntSkdDirCd(cusCtmMovementVo.getCrntSkdDirCd());
							cVO.setCrntSkdVoyNo(cusCtmMovementVo.getCrntSkdVoyNo());
							cVO.setCrntVslCd(cusCtmMovementVo.getCrntVslCd());
							cVO.setTrnkSkdDirCd(cusCtmMovementVo.getTrnkSkdDirCd());
							cVO.setTrnkSkdVoyNo(cusCtmMovementVo.getTrnkSkdVoyNo());
							cVO.setTrnkVslCd(cusCtmMovementVo.getTrnkVslCd());
							// BOOKING Setting
							cVO.setBlNo(cusCtmMovementVo.getBlNo());
							cVO.setBkgNo(cusCtmMovementVo.getBkgNo());
							// 기타 Setting
							cVO.setCnmvCycNo(cusCtmMovementVo.getCnmvCycNo());
							cVO.setBkgCgoTpCd(cusCtmMovementVo.getBkgCgoTpCd());
							cVO.setFcntrFlg("N");
							cVO.setObCntrFlg("Y");
							cVO.setCnmvLvlNo("1");

							dbDao.updateContainer(cVO, "1", "1");

							// 자동생성시 OP가 발생되었을 경우 상위 메서드인 manageStsOperation(동일 BCImpl)으로 구분값 return
//							rtnVal[2] = "OP";    2010.10.15 임시주석처리

						} else {
							dbDao.updateContainer(cVO, "1", "");
						}

					} else if ("U2".equals(act.getTar())) {
						// 전전 상태 업데이트
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" update(2) error][Auto]";
						cVO.setCnmvYr(ctmCntrMovInfoVO.getCnmvYr());
						cVO.setMvmtStsCd(autoSts);
						cVO.setMvmtCreTpCd("A");
						if ("CY".equals(subStr(act.getAuto(), 3, 5))) {
							cVO.setOrgYdCd(ctmCntrMovInfoVO.getOrgYdCd());
						} else {
							cVO.setOrgYdCd(yardCd);
						}
						
						//CTM_MVMT_EVNT_DT_HIS Table에 Insert
						dbDao.addComMvmtEventDateHistory(cVO);
						
						dbDao.updateContainer(cVO, "2", "");

					} else {
					}

				}
			}
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - autoCre] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - autoCre] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
		}
		rtnVal[4] = idNo;
		rtnVal[5] = idSeq;
		return rtnVal;
	}

	/*=========================================================
	 * 2010.09.03 김상수 [소스품질관리] 중첩try문 3건 제거
	 *                   (연관파일 ContainerMovementMgtDBDAO.java도 수정)
	 * 2010.09.09 김상수 [CHM-201005675-01] Split 01-M&R SYSTEM에서 Damage Flag 자동 제거
	 *                   autoCre메서드에서 return된 값에 OP Status가 있고
	 *                   MST_CONTAINER의 dmg_flg가 Y이면 상위SC에서 MNR호출
	 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
	 *                   - private autoCre()에서 사용하는 DBDAO메서드의 수정으로
	 *                     현재 메서드에서의 연관된 사용법 변경
	 * 2013.03.07 강   환 [CHM-201323292-01] 현재 Movement가 OC이고, 
	 * 					전전 Movement가 MT면 직전 Movement를 변경하지 않는다                    
	 *=========================================================*/
	/**
	 * 컨테이너 이동 정보 등록<br>
	 * Container Movement Status Insert<br>
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @param String user_Id
	 * @param String user_Nm
	 * @param String ofc_Cd
	 * @param int endCount
	 * @param boolean nBkgNoFlg
	 * @return CrossItemVO
	 * @exception EventException
	 */
	public CrossItemVO manageStsOperation(CusCtmMovementVO[] cusCtmMovementVOs, String user_Id, String user_Nm, String ofc_Cd, int endCount, boolean nBkgNoFlg) throws EventException {

		String[] rtnVO = new String[3];
		// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
		StringBuffer tmpRtnVO = new StringBuffer();

		CusCtmMovementVO crrCntrInfo = null;       // 입력받은 컨테이너 정보
		MstContainerInfoVO mstCntrInfo = null;     // MST 컨테이너 정보 (MST_CONTAINER)
		CusCtmMovementVO pstCntrInfo = null;       // 직전 컨테이너 정보 (CTM_MOVEMENT)
		CtmCntrMovInfoVO atbCntrInfo = null;       // 전전 컨테이너 정보 (CTM_MOVEMENT)
		BkgBookingInfoVO bkgInfo = null;           // 부킹정보
		List<MultiBkgNoVO> multiBkg = null;        // 멀티부킹 체크
		List<BkgContainerLastVO> bkgCntr = null;   // 부킹컨테이너
		BkgContainerLastVO bkgCntrInfo = null;     // 부킹컨테이너
		List<BkgVVDInfoVO> vvdVO = null;           // 부킹 VVD
		BkgVVDInfoVO vvdInfo = null;               // 부킹 VVD

		String cntrNoAft = null;
		String cntrNoBef = null;
		String vslOld = "";
		String voyOld = "";
		String dirOld = "";
		String userNm = null;
		boolean isConfirm = false;
		boolean sameCntr = false;
		String errMsg = "";
		CrossItemVO crossItem = new CrossItemVO();
		boolean isFirst = true;

		for (int ord = 0; ord < endCount; ord++) {
			crrCntrInfo = cusCtmMovementVOs[ord];
			if (crrCntrInfo == null) {
				crossItem.setRtnStr(rtnVO);
				return crossItem;
			}

			cntrNoAft = crrCntrInfo.getCntrNo();               // 컨테이너 번호
			String mvmtStsCd = crrCntrInfo.getMvmtStsCd();     // 입력 될 이동 상태 (받아온 Status)
			String bkgNo = crrCntrInfo.getBkgNo();             // 부킹 번호
			log.info("BKGNO IS :" + bkgNo + ":");
			String svrId = crrCntrInfo.getCntrSvrId();         // 컨테이너가 위치하고있는 서버 아이디
			String cycNo = crrCntrInfo.getCnmvCycNo();         // 입력될 사이클 번호 (널로 넘어옴)
			String idNo  = "";
			String idSeq = "";
			String cgoTp = crrCntrInfo.getBkgCgoTpCd();        // 부킹 카고타입 (널로 넘어옴)
			String yardCd = crrCntrInfo.getOrgYdCd();          // Original YARD
			String evntDt = crrCntrInfo.getCnmvEvntDt();       // EVENT DATE
			String fmFlag = crrCntrInfo.getFcntrFlg();         // FULL EMPTY FLAG
			String ofcCd = null;                               // USER OFFICE
			String lvlCd = null;                               // STS LEVEL
			String spclBkg = null;                             // SPCIAL 부킹 FLAG
			String userId = crrCntrInfo.getUpdUsrId();         // 사용자 아이디
			String blNo = "";
			String inpType = null;                             // 생성 유형 (MAN/EDI/SPP)
			String msgId ="";
			boolean isFindBkg = true;                          // 부킹정보 여부
			boolean findBkgCntr = false;
			String cntrPrtFlg = null;
			List<BkgBookingInfoVO> bkgList = null;
			crossItem.setEdiSendStsCd(mvmtStsCd);              // sendEDIToKOR을 위한 입력 Status setting

			/*********************************************************
			 * MST_CONTAINER에서 해당 컨테이너의 모든 정보를 가져온다. *
			 *********************************************************/
			try {
				mstCntrInfo = dbDao.getCntrInfo(cntrNoAft, evntDt, yardCd);

				// 컨테이너 정보를 얻어오는데 실패했을 경우.
				if (mstCntrInfo == null) {
					rtnVO[0] = "N";
					rtnVO[1] = "Select CONTAINER Table Error!";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				crrCntrInfo.setLstrmCd(mstCntrInfo.getLstmCd());

				// 2016.06.16 김상현 [CHM-201641824] Movement update 설정 요청
				// - USPHXT5, USPHXY1, USPHXY3, USPHXY5 4개 Yard에서 event가 발생 될 경우,
				//  Inbound 이고 door term일 때 "MT" 허용
				//  "OP" status 일 경우 생성 허용
				//  "MT", "OP"외 status 발생시 처리 예외
				if ("USPHXT5".equals(crrCntrInfo.getOrgYdCd()) || "USPHXY1".equals(crrCntrInfo.getOrgYdCd()) || "USPHXY3".equals(crrCntrInfo.getOrgYdCd()) || "USPHXY5".equals(crrCntrInfo.getOrgYdCd())) {
					if (!"OP".equals(mvmtStsCd) && !"MT".equals(mvmtStsCd)) {
						rtnVO[0] = "I";
						rtnVO[1] = "Only 'OP' and 'MT' are allowed for these yards(USPHXT5, USPHXY1, USPHXY3, USPHXY5).";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					} else if ("MT".equals(mvmtStsCd)) {
						List<BkgBookingInfoVO> list = dbDao.searchBkgBookingList(bkgNo);

						if (list == null || list.size() < 1) {
							rtnVO[0] = "N";
							rtnVO[1] = "Booking no does not exist";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						BkgBookingInfoVO info = list.get(0);

						if (!"D".equals(info.getDeTermCd())) {
							rtnVO[0] = "I";
							rtnVO[1] = "Only 'OP' and 'MT' are allowed for these yards(USPHXT5, USPHXY1, USPHXY3, USPHXY5).";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					}
				}

				if ("OP".equals(mvmtStsCd)) {
					if ("Y".equals(mstCntrInfo.getImdtExtFlg())) {
						// 2016.06.02 김상현 [CHM-201641817] OP생성시 Immediately exit 확인 logic 제거
//						rtnVO[0] = "N";
//						rtnVO[1] = "Immediately exit container![OP]";
//						crossItem.setRtnStr(rtnVO);
//						return crossItem;
						crrCntrInfo.setCnmvRmk("Immediately exit container!");
					} else if ("Y".equals(mstCntrInfo.getDmgFlg())) {
						// Status가 OP이고 MST_CONTAINER에서 불러온 Damage Flag가 Y일때 SC에서 MNR을 호출하게하기 위한 flag
						crossItem.setMnrCallYN("Y");

					}
				}

				if (svrId == null || "".equals(svrId)) {
					svrId = dbDao.searchSvrId(yardCd);
				}

				if (!svrId.equals(mstCntrInfo.getSvrId()) && !"VD".equals(mvmtStsCd)) {
					if ("MT".equals(mvmtStsCd) && "Y".equals(mstCntrInfo.getHjsCreFlg())) {
						// 신조장비의 MT
						log.info("신조 장비 임");

					} else {
						rtnVO[0] = "N";
						rtnVO[1] = "Container is not located in this area " + svrId + ":" + mstCntrInfo.getSvrId();
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					}
				}

				if ("Y".equals(mstCntrInfo.getHjsCreFlg()) && "I".equals(mstCntrInfo.getAciacDivCd()) && "MT".equals(mvmtStsCd)) {
					/* 신조장비인 경우 Inactive일 경우 return없이 다음로직 수행 */
					rtnVO[1] = "B";
					rtnVO[0] = "Y";
				} else if ("I".equals(mstCntrInfo.getAciacDivCd()) && !"Y".equals(mstCntrInfo.getHjsCreFlg())) {
					/* inactive 상태인지 체크한다. */
					rtnVO[0] = "N";
					rtnVO[1] = "It can't be saved because this container is inactive status.";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				crrCntrInfo.setLstrmCd(mstCntrInfo.getLstmCd());
				/******************************************
				 * VL Creationi시 SAME DATA 관련 ERR MSG *
				 ******************************************/
				pstCntrInfo = dbDao.searchMovementStatusMst(cntrNoAft, evntDt);
				if (pstCntrInfo == null) {
					if ("MT".equals(mvmtStsCd) && "Y".equals(mstCntrInfo.getHjsCreFlg())) {
						rtnVO[1] = "B";
						rtnVO[0] = "Y";
						idNo = "0";
						idSeq = "0";
						cycNo = "1";
						crrCntrInfo.setCnmvCycNo(cycNo);
					} else {
						rtnVO[0] = "N";
						//rtnVO[1] = "It Can't Be Saved Because This Container is Inactive Status.";
						rtnVO[1] = "There is no previous status. Please create \"MT\" status first from container master.";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
				}

				if ("VL".equals(mvmtStsCd) && (pstCntrInfo != null && "VL".equals(pstCntrInfo.getMvmtStsCd())) && yardCd.equals(mstCntrInfo.getCrntYdCd())) {
					msgId = pstCntrInfo.getMvmtInpTpCd();
					if (msgId.equals("MAN") || msgId.equals("SPP")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Already created by manual!";

						// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
						//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
						String message = checkVgmData(crrCntrInfo);
						if (message != null) {
//							rtnVO[1] = message;
							rtnVO[1] = rtnVO[1] != null ? rtnVO[1].concat(message) : message;
							rtnVO[2] = "VGM"; // VGM data update를 하기 위해 값 setting
						}
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					} else {
						rtnVO[0] = "N";
						rtnVO[1] = "The same data already existed!";

						// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
						//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
						String message = checkVgmData(crrCntrInfo);
						if (message != null) {
//							rtnVO[1] = message;
							rtnVO[1] = rtnVO[1] != null ? rtnVO[1].concat(message) : message;
							rtnVO[2] = "VGM";
						}
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
				}

				if ("VD".equals(mvmtStsCd) && ("MT".equals(mstCntrInfo.getCnmvStsCd()) || "IC".equals(mstCntrInfo.getCnmvStsCd()) || "TS".equals(mstCntrInfo.getCnmvStsCd()))&& yardCd.equals(mstCntrInfo.getCrntYdCd())) {
					atbCntrInfo = dbDao.searchMovementStatusVD(cntrNoAft, 2);
					if (atbCntrInfo != null && "VD".equals(atbCntrInfo.getMvmtStsCd())&& yardCd.equals(atbCntrInfo.getOrgYdCd())) {
						if (atbCntrInfo.getCmMsgId().equals("MAN")|| atbCntrInfo.getCmMsgId().equals("SPP")) {
							rtnVO[0] = "N";
							rtnVO[1] = "Already created by manual!";

							// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
							//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
							String message = checkVgmData(crrCntrInfo);
							if (message != null) {
//								rtnVO[1] = message;
								rtnVO[1] = rtnVO[1] != null ? rtnVO[1].concat(message) : message;
								rtnVO[2] = "VGM";
							}							
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						} else {
							rtnVO[0] = "N";
							rtnVO[1] = "The same data already existed!";

							// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
							//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
							String message = checkVgmData(crrCntrInfo);
							if (message != null) {
//								rtnVO[1] = message;
								rtnVO[1] = rtnVO[1] != null ? rtnVO[1].concat(message) : message;
								rtnVO[2] = "VGM";
							}
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					}
				}

				// VD-IC이후 VL처리 허용 안함 valiadtion 추가 - CHM-201326735
				if ("VL".equals(mvmtStsCd))
				{
					atbCntrInfo = dbDao.searchMovementStatusVD(cntrNoAft, 2);
					if (atbCntrInfo != null && "VD".equals(atbCntrInfo.getMvmtStsCd()) && yardCd.equals(atbCntrInfo.getOrgYdCd())
						&& ( pstCntrInfo != null && "IC".equals(pstCntrInfo.getMvmtStsCd())) ) 
					{
						rtnVO[0] = "N";
						rtnVO[1] = "Previous ststus IC,  You can create only ID/TN/EN!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
//						Previous ststus "IC",  You can create only "ID/TN/EN"!
					}
				}
				/***************************************************
				 * 이전 상태값이 VL이면 VD만 가능하도록 한다 * 566 Line *
				 ***************************************************/
				if ("VL".equals(mstCntrInfo.getCnmvStsCd())) {
					if (!"VD".equals(mvmtStsCd)) {
						rtnVO[0] = "N";
						rtnVO[1] = "Previous status is 'VL', You can create only 'VD'!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
				}

				if (Long.parseLong(mstCntrInfo.getEvntDt()) > Long.parseLong(mstCntrInfo.getCompDt())) {
					if ("VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd)) {
						rtnVO[0] = "N";
						rtnVO[1] = "Previous event date(VL-VD) is later than current event date.";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					} else {
						rtnVO[0] = "N";
						rtnVO[1] = "Previous event date is later than current event date.";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
				}
			} catch (Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Container master]").getMessage(), ex);
			}

			/******************************************
			 *   컨테이너이동정보 마지막 정보를 읽어온다 *
			 ******************************************/
			try {
				if (cntrNoBef != null && cntrNoAft.equals(cntrNoBef)) {
					sameCntr = true;
				} else {
					sameCntr = false;
				}
				if (pstCntrInfo != null) {
					// ID, SEQ의 MAX는 MOVEMENT의 마지막과 다르다.
					idNo  = dbDao.getContainerMaxId(cntrNoAft, crrCntrInfo.getCnmvYr());
					idSeq = dbDao.getContainerMaxSeq(cntrNoAft, crrCntrInfo.getCnmvYr());
					cycNo = pstCntrInfo.getCnmvCycNo();
					crrCntrInfo.setCnmvCycNo(cycNo);
				}
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("There is no previous(1) container movement!").getMessage(), ex);
			}

			try {
				// OP에서만 체크하도록 변경. 2009-11-20
				if (!sameCntr) {
					if ("MT".equals(mvmtStsCd) && "IC".equals(mstCntrInfo.getCnmvStsCd()) && "SH".equals(mstCntrInfo.getLstmCd())) {
						rtnVO[0] = "N";
						rtnVO[1] = "The MT status without ID is impossible !(SOC)";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}

					// 미주지역 ALRL처리를 위해 SAME DATA 변경. 시간을 무시하고 SAME DATA 처리한다.
					// STS가 EN/TN이고 이전 STS가 EN/TN일 경우 Common에서는 Error로 처리하고 GateNew에서는 Ig로 처리한다. 2010.2.12
					if ("USA".equals(svrId) && ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) && pstCntrInfo != null && pstCntrInfo.getOrgYdCd() != null && crrCntrInfo.getOrgYdCd().equals(pstCntrInfo.getOrgYdCd()) && ("EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd()) )) {
						rtnVO[0] = "N";
						rtnVO[1] = "The same data already existed!";

						// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
						//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
						String message = checkVgmData(crrCntrInfo);
						if (message != null) {
//							rtnVO[1] = message;
							rtnVO[1] = rtnVO[1] != null ? rtnVO[1].concat(message) : message;
							rtnVO[2] = "VGM";
						}
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					} else if (pstCntrInfo != null && pstCntrInfo.getOrgYdCd() != null && mvmtStsCd.equals(pstCntrInfo.getMvmtStsCd()) && crrCntrInfo.getOrgYdCd().equals(pstCntrInfo.getOrgYdCd()) && subStr(crrCntrInfo.getCnmvEvntDt(), 0, 8).equals(subStr(pstCntrInfo.getCnmvEvntDt(), 0, 8))) {
						rtnVO[0] = "N";
						rtnVO[1] = "The same data already existed!";

						// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
						//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, VGM 데이터 업데이트 처리
						String message = checkVgmData(crrCntrInfo);
						if (message != null) {
//							rtnVO[1] = message;
							rtnVO[1] = rtnVO[1] != null ? rtnVO[1].concat(message) : message;
							rtnVO[2] = "VGM";
						}
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					}
				}

				/***********************************************
				 * VD 등록시 동일 자료가 반복 생성되지 않도록 막는다. *
				 ***********************************************/
				userId = crrCntrInfo.getUpdUsrId();
				userNm = crrCntrInfo.getUsrNm();
				if (userId == null || userId.equals("")) {
					userId = user_Id;
				}
				if (userNm == null || userNm.equals("")) {
					userNm = user_Nm;
				}
				crrCntrInfo.setUsrNm(user_Nm);
				crrCntrInfo.setUpdUsrId(userId);
				crrCntrInfo.setCreUsrId(userId);
				crrCntrInfo.setPreStsFlg("N");

				/******************************************
				 *   CREATION TYPE 판별. MAN/EDI/SPP      *
				 ******************************************/
				/* 사용자가 EDI이거나 SPP 일 경우만 실행 */
				if ("ESVCUSER".equals(userId) || "EDIUSER".equals(userId) || "BATCH".equals(userId)) {
					ofcCd = dbDao.getOfcCdByYard(yardCd);
					if (ofcCd.equals("E")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Office select error!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}

					if ("ESVCUSER".equals(userId)) {
						inpType = "SPP";
						crrCntrInfo.setMvmtEdiMsgTpId("SPP");
						if ("WW".equals(mvmtStsCd) && "M".equals(fmFlag)) {
							// 2010-04-06 로직상 불필요하여 주석처리 (IH.Jang) - 추후 로직추가 예정 (2010년 6월중)
							// rtnVO[0] = "I";
							// rtnVO[1] = "[Empty Container EN/TN : Booking Check SKIP!]";
							// - 추후 로직 추가되면 삭제할것 (S)
							if (!"WW".equals(mvmtStsCd) && !"M".equals(fmFlag)) {
								// fake logic
								return crossItem;
							}
							// - 추후 로직 추가되면 삭제할것 (E)
						} else {
							// 부킹번호 체크 WW_BKG_CHECK. 별도 함수로 만들어서 돌림. FUNC1
							String[] rtn = checkBkgNoFrSpp(cntrNoAft, bkgNo, crrCntrInfo.getBlNo());
							bkgNo = rtn[2];             // 부킹 번호
							crrCntrInfo.setBkgNo(rtn[2]);     // 부킹 번호
							if ("N".equals(rtn[0])) {
								rtnVO[0] = "N";
								rtnVO[1] = "[ESVC] Booking/BL No Select Error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						}
					} else {
						inpType = "EDI";
					}
				} else {
					ofcCd = ofc_Cd;
					if  (crrCntrInfo.getMvmtEdiTpCd() != null && !"".equals(crrCntrInfo.getMvmtEdiTpCd().trim())) {
						inpType = "EDI";
					} else {
						inpType = "MAN";
					}
				}

				crrCntrInfo.setOfcCd(ofcCd);
				if (crrCntrInfo.getMvmtCreTpCd() == null || !"R".equals(crrCntrInfo.getMvmtCreTpCd()))
					crrCntrInfo.setMvmtCreTpCd("");

			} catch (Exception e) {
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Booking no]").getMessage(), e);
			}

			/**************************************************************************
			 * e-SVC Tracking 에서 EAI를 통해 Interface 되는 Data ==> 명확한 MVMT Status 없이
			 * WW로 들어올 경우 - ID, EN, TN 판별 e-SVC에서는 Multi BKG으로 입력되지 않고 한건씩 입력된다.
			 ****************************************************************************/
			try {
				if ("ESVCUSER".equals(userId)) {
					if ("WW".equals(mvmtStsCd)) {
						String ioBound = crrCntrInfo.getObCntrFlg();
						if ("O".equals(crrCntrInfo.getObCntrFlg())) {
							String stsCd = checkProcessOut(crrCntrInfo.getObCntrFlg(), crrCntrInfo.getFcntrFlg(), bkgNo, yardCd, crrCntrInfo.getDestYdCd());
							if (stsCd.length() != 2) {
								rtnVO[0] = "N";
								rtnVO[1] = "[ESVC] Outbound EN-TN determine error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								mvmtStsCd = stsCd;
								crrCntrInfo.setMvmtStsCd(stsCd);
							}
						} else if ("I".equals(ioBound)) {
							String stsCd = checkProcessIn(crrCntrInfo.getObCntrFlg(), bkgNo, yardCd, crrCntrInfo.getDestYdCd());
							if (stsCd.length() != 2) {
								rtnVO[0] = "N";
								rtnVO[1] = "[ESVC] Inbound ID-EN-TN determine error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								mvmtStsCd = stsCd;
								crrCntrInfo.setMvmtStsCd(stsCd);
							}
						}
					}
				}
			} catch (EventException e) {
				log.info("ERRS" + e.getMessage());
				throw new EventException(new ErrorHandler(e.getMessage()).getMessage(), e);
			} catch (Exception e) {
				throw new EventException(new ErrorHandler(e.getMessage()).getMessage(), e);
			}

			try {
				atbCntrInfo = dbDao.searchMovementStatusVD(cntrNoAft, 2);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("There is no previous(2) container movement!").getMessage(), ex);
			}

			// 자동생성에 넘겨줄 데이터 모음... 나머지는 상황별로 달라지기 때문에 각 STS에 존재함.
			// VVD. Bkg No. BlNo등
			String[] autoParam = new String[14];
			autoParam[0] = cycNo;
			autoParam[1] = idNo;
			autoParam[2] = idSeq;
			autoParam[3] = fmFlag;
			autoParam[4] = "D";
			autoParam[5] = ofcCd;
			autoParam[6] = userId;
			autoParam[7] = userNm;
			autoParam[8] = svrId;
			autoParam[9] = inpType;

			if (pstCntrInfo != null) {
				String yardCdEq = "";
				if (crrCntrInfo.getOrgYdCd().equals(pstCntrInfo.getOrgYdCd())) {
					yardCdEq = "S";
				} else {
					yardCdEq = "D";
				}
				autoParam[4] = yardCdEq;
				autoParam[10] = crrCntrInfo.getTrnkVslCd();
				autoParam[11] = crrCntrInfo.getTrnkSkdVoyNo();
				autoParam[12] = crrCntrInfo.getTrnkSkdDirCd();
				autoParam[13] = crrCntrInfo.getBlNo();
			}
			crrCntrInfo.setCntrSvrId(svrId);
			// 자동생성 시작 이전 Movement 및 Bkg의 기본 정보들을 얻어온다.
			// 모든 STS가 끝나면 Auto Creation을 진행하고 진행 완료 후 원 STS를 입력.
			if ("MT".equals(mvmtStsCd)) {
				if (!"Y".equals(mstCntrInfo.getHjsCreFlg())) {
					crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
					/**************************************
					 * 부킹사이클정보를 얻어온다.         *
					 * CTM_MOVEMENT에서 MAX값을 가져온다  *
					 **************************************/
					cycNo = pstCntrInfo.getCnmvCycNo();
					crrCntrInfo.setCnmvCycNo(cycNo);
					// IC. ID. TS 다음 들어오는 MT는 부킹을 쓰도록 변경한다. 2009.12.17
					if (pstCntrInfo.getMvmtStsCd().equals("ID") || pstCntrInfo.getMvmtStsCd().equals("IC") || pstCntrInfo.getMvmtStsCd().equals("TS")) {
						bkgNo = pstCntrInfo.getBkgNo();
						log.info("MT BOOKING ::" + bkgNo);
						crrCntrInfo.setBkgNo(bkgNo);
						crrCntrInfo.setBlNo(pstCntrInfo.getBlNo());
						crrCntrInfo.setFcntrFlg(pstCntrInfo.getFcntrFlg());
						/***************************************
						 * BKG_BOOKING에서 부킹정보를 얻어온다. *
						 * BkgInfo VO에 정보를 저장하고 사용함  *
						 ***************************************/
						try {
							// MT에서 이전 STS가 ID이고 BKG가 없을 경우 찾아오도록 로직을 변경한다. 2009-11-23
							if (bkgNo == null || bkgNo.equals("")) {
								String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
								bkgNo = returnValues[0];
							}
							bkgList = dbDao.searchBkgBookingList(bkgNo);

							if (bkgList == null || bkgList.size() < 1) {
								rtnVO[0] = "N";
								rtnVO[1] = "Booking no does not exist";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							bkgInfo = bkgList.get(0);
							cgoTp = bkgInfo.getBkgCgoTpCd();

						} catch (Exception e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Booking no]").getMessage(), e);
						}
					} else {
						bkgNo = "";
						crrCntrInfo.setBkgNo("");
					}
					/* CNTR FULL/EMPTY FLAG SETTING */
					if (crrCntrInfo.getFcntrFlg() == null || crrCntrInfo.getFcntrFlg().equals(""))
						crrCntrInfo.setFcntrFlg(fmFlag);

				}
			} else if (mvmtStsCd.equals("OP") || mvmtStsCd.equals("OC")) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());

				// 부킹사이클정보를 얻어온다. CTM_MOVEMENT에서 MAX값을 가져온다.
				cycNo = pstCntrInfo.getCnmvCycNo();
				crrCntrInfo.setCnmvCycNo(cycNo);

				// BKG_BOOKING에서 부킹정보를 얻어온다. BkgInfo VO에 정보를 저장하고 사용함
				try {
					bkgList = dbDao.searchBkgBookingList(bkgNo);
					svrId = dbDao.searchSvrId(yardCd);

					if (bkgList == null || bkgList.size() < 1) {
						rtnVO[0] = "N";
						rtnVO[1] = "Booking no does not exist(" + mvmtStsCd + "/" + bkgNo + ")";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					bkgInfo = bkgList.get(0);
					cgoTp = bkgInfo.getBkgCgoTpCd();
					isConfirm = true;
					if (bkgInfo.getBkgCfm().equals("Y")) {
						isConfirm = true;
					} else {
						isConfirm = false;
					}
					if (crrCntrInfo.getTrnkVslCd() == null || "".equals(crrCntrInfo.getTrnkVslCd())) {
						crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
					}

					// 2016.01.11 Logic 추가 by Sang-Hyun Kim
					//  - Booking No. And VVD가 이전 status하고 다르거나, VVD는 동일하지만 Booking No.가 다르고 Outbound(OP, OC)이면, "OP", "OC", "VL"일 때 Cycle +1 처리
					// 2016.04.21 김상현 [CHM-201640819] 이전 단계의 status와 현재 status를 비교해서 cyc# 증가 로직을 분리 처리
					//  - 이전 단계의 status와 현재 status를 비교해서 cyc# 증가 로직을 분리 처리
					//  - 현재 Status가 "OP" 일 경우, BKG_NO, VVD 둘 중 한 개라도 변경이 있으면 cyc# +1 증가
					//  - 현재 Status가 "OC" 일 경우,
					//   ▷ 이전 Status가 "ID"이면 동일 BKG_NO, VVD 둘 중 한 개라도 변경이 있으면 cyc# +1 증가
					//   ▷ 이전 Status가 "ID"가 아니면 BKG_NO, VVD 두 개가 모두 변경 되어야만 cyc# +1 증가
					//  - 자동 생성되는 "OC"도 동일 로직 적용
					if (mvmtStsCd.equals("OP") || (mvmtStsCd.equals("OC") && "ID".equals(pstCntrInfo.getMvmtStsCd()))) {
						if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd())
								|| !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())
								|| !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())
								|| !bkgNo.equals(pstCntrInfo.getBkgNo())) {
							cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
							crrCntrInfo.setCnmvCycNo(cycNo);
						}
					} else {
						if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd())
								|| !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())
								|| !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
							if (!bkgNo.equals(pstCntrInfo.getBkgNo())) {
								// 2013.07.03 [CHM-201325252] VL 이후 VVD 변경시 CYC 관련 logic 수정
								//  - 'VL' 이후 'VD' 생성시 VVD 변경은 Cyc +1을 추가하지 않는다.
								if (!crrCntrInfo.getMvmtStsCd().equals("VD")) {
									cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
									crrCntrInfo.setCnmvCycNo(cycNo);
								}
							}
						}
					}

					if (cntrNoBef != null && cntrNoAft.equals(cntrNoBef)) {
						if (!vslOld.equals(bkgInfo.getVslCd()) || !voyOld.equals(bkgInfo.getSkdVoyNo()) || !dirOld.equals(bkgInfo.getSkdDirCd())) {
							rtnVO[0] = "N";
							rtnVO[1] = "Different trunk VVDs were matched to one container!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					}
				} catch (Exception e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [" + mvmtStsCd + "/" + bkgNo + "]").getMessage(), e);
				}

				try {
					multiBkg = dbDao.searchMultiBkgNo(cntrNoAft, cycNo, mvmtStsCd, bkgNo);

					if (multiBkg != null && multiBkg.size() > 0) {
						MultiBkgNoVO multi = (MultiBkgNoVO) multiBkg.get(0);
						if (multiBkg.size() > 1) {
							// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
							StringBuffer bkgStr = new StringBuffer();
//							String bkgStr = "";
							for (int idxBkg = 0; idxBkg < multiBkg.size(); idxBkg++) {
								if (!bkgNo.equals(multiBkg.get(idxBkg).getBkgNo()) ){
									// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
//									bkgStr = bkgStr + "," + multiBkg.get(idxBkg).getBkgNo();
									bkgStr.append(",").append(multiBkg.get(idxBkg).getBkgNo());
//									bkgStr.append(",");
//									bkgStr.append(multiBkg.get(idxBkg).getBkgNo());
								}
							}
							rtnVO[0] = "N";
							rtnVO[1] = "There are different trunk VVD in another booking![" + bkgStr + "]";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						cgoTp = multi.getBkgCgoTpCd();

						if (bkgInfo.getSkdVoyNo().length() > 0 && bkgInfo.getSkdDirCd().length() > 0 && bkgInfo.getVslCd().length() > 0 && multi.getVslCd().length() > 0 && multi.getSkdVoyNo().length() > 0 && multi.getSkdDirCd().length() > 0) {
							if (!bkgInfo.getVslCd().trim().equals(multi.getVslCd().trim()) || !bkgInfo.getSkdVoyNo().trim().equals(multi.getSkdVoyNo().trim()) || !bkgInfo.getSkdDirCd().trim().equals(multi.getSkdDirCd().trim()) || !bkgInfo.getBkgCgoTpCd().trim().equals(multi.getBkgCgoTpCd().trim())) {
								rtnVO[0] = "N";
								rtnVO[1] = "There are different trunk VVD in another booking! [" + multi.getBkgNo() + "]";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							cgoTp = multi.getBkgCgoTpCd();
						}
						bkgCntrInfo = new BkgContainerLastVO();
						bkgCntrInfo.setBkgCgoTpCd(multi.getBkgCgoTpCd());
						bkgCntrInfo.setBkgNo(multi.getBkgNo());
						bkgCntrInfo.setPodCd(multi.getPodCd());
						bkgCntrInfo.setSkdDirCd(multi.getSkdDirCd());
						bkgCntrInfo.setSkdVoyNo(multi.getSkdVoyNo());
						bkgCntrInfo.setVslCd(multi.getVslCd());
						bkgCntrInfo.setDelCd(multi.getDelCd());
						bkgCntrInfo.setCnmvCycNo(cycNo);

					} else {
						/*******************************************************************
						 * BKG_CONTAINER , BKG_BOOKING에 자료가 없을 땐 부킹으로 대체한다  *
						 *******************************************************************/
						bkgCntrInfo = new BkgContainerLastVO();
						bkgCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						bkgCntrInfo.setBkgNo(bkgInfo.getBkgNo());
						bkgCntrInfo.setPodCd(bkgInfo.getPodCd());
						bkgCntrInfo.setSkdDirCd(bkgInfo.getSkdDirCd());
						bkgCntrInfo.setSkdVoyNo(bkgInfo.getSkdVoyNo());
						bkgCntrInfo.setVslCd(bkgInfo.getVslCd());
						bkgCntrInfo.setDelCd(bkgInfo.getDelCd());
						bkgCntrInfo.setCnmvCycNo(cycNo);
					}
				} catch (Exception e) {
					log.error(e.getMessage(),e);
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Multi " + bkgNo + "]").getMessage(), e);
				}

				/***************************************
				 *   스페셜 부킹의 속성을 얻어온다     *
				 ***************************************/
				if (crrCntrInfo.getSpclCgoFlg() != null && !crrCntrInfo.getSpclCgoFlg().equals("") && !crrCntrInfo.getSpclCgoFlg().equals("null")) {
					try {
						spclBkg = dbDao.searchSpclBkg(cntrNoAft, bkgCntrInfo.getCnmvCycNo(), crrCntrInfo.getCnmvCycNo());

						if (spclBkg == null || spclBkg.equals("") || spclBkg.equals("-1")) {
							crrCntrInfo.setSpclCgoFlg("N");
						} else {
							crrCntrInfo.setSpclCgoFlg("Y");
						}
					} catch (Exception e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Spcial cargo]").getMessage(), e);
					}
				}

				crrCntrInfo.setObCntrFlg("Y");
				crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
				/********************************************
				 * VVD 비교를 위한 VSL자료를 얻어온다.      *
				 * EN/TN은 제외. VSL CODE가 없는경우도 제외 *
				 ********************************************/
				try {
					crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
					crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
					crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
					crrCntrInfo.setBlNo(bkgInfo.getBlNo());
					autoParam[13] = bkgInfo.getBlNo();

					vvdVO = dbDao.getMstInfo(crrCntrInfo);
					if (vvdVO == null || vvdVO.size() == 0) {
						rtnVO[0] = "N";
						rtnVO[1] = "Container does not exist [" + cntrNoAft + "]";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					vvdInfo = vvdVO.get(0);
				} catch (Exception e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Container:" + cntrNoAft + "]").getMessage(), e);
				}

				CntrMvmtSeqInfoVO cntrMovSeqVO = new CntrMvmtSeqInfoVO();
				try {
					cntrMovSeqVO = dbDao.getCNTRMovSeqRSQL(cgoTp, mvmtStsCd);
					if (cntrMovSeqVO == null) {
						if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
							lvlCd = "0";
						} else {
							rtnVO[0] = "N";
							rtnVO[1] = "Cargo Type and Status Unmatch Error!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					} else
						lvlCd = cntrMovSeqVO.getCnmvLvlNo();
					if ("ID".equals(pstCntrInfo.getMvmtStsCd())) {
						if ("MT".equals(mvmtStsCd)) {
							cgoTp = pstCntrInfo.getBkgCgoTpCd();
						}
					}
				} catch (Exception e) {
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [" + cgoTp + "/" + mvmtStsCd + "]").getMessage(), e);
				}

				try {
					if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg()))
						fmFlag = crrCntrInfo.getFcntrFlg();
					else if (fmFlag==null || fmFlag.equals(""))
						fmFlag = cntrMovSeqVO.getFcntrFlg();
				} catch (Exception e) {
					log.error(e.getMessage(),e);
					throw new EventException(new ErrorHandler("Full flag is null").getMessage(), e);
				}
				// SH 장비의 ERROR처리 변경. 2009-11-20
				if ("SH".equals(mstCntrInfo.getLstmCd()) && "P".equals(cgoTp)) {
					rtnVO[0] = "N";
					rtnVO[1] = "This Container is Shipper's Own Container, You can't create empty repo status!";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

			} else if ("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
				/*******************************************
				 * 부킹정보를 얻어온다                     *
				 * 부킹 번호가 없을 때만 실행 하도록 한다. *
				 *******************************************/
				try {
					String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
					bkgNo = returnValues[0];
					if ("MT".equals(mvmtStsCd) && (bkgNo == null || "".equals(bkgNo))) {
						crrCntrInfo.setBkgNo("");
					} else if (bkgNo == null || bkgNo.equals("")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Booking no does not exist [" + mvmtStsCd + "!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					} else {
						crrCntrInfo.setBkgNo(bkgNo);
					}

				} catch (DAOException e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Search booking no " + cntrNoAft + "]").getMessage(), e);
				}

				/**************************************
				 * 부킹사이클정보를 얻어온다.         *
				 * CTM_MOVEMENT에서 MAX값을 가져온다  *
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();

				/******************************************
				 * STS가 OP일 경우 Cycle No를 1 증가한다. *
				 ******************************************/
				crrCntrInfo.setCnmvCycNo(cycNo);

				/****************************************
				 * BKG_BOOKING에서 부킹정보를 얻어온다. *
				 * BkgInfo VO에 정보를 저장하고 사용함  *
				 ****************************************/
				try {
					svrId = dbDao.searchSvrId(yardCd);
				} catch (Exception e) {
					throw new EventException(new ErrorHandler("Area does not exist [" + yardCd + "]!").getMessage(), e);
				}

				try {
					bkgList = dbDao.searchBkgBookingList(bkgNo);

					if (bkgList == null || bkgList.size() < 1) {
						rtnVO[0] = "N";
						rtnVO[1] = "Booking infomation does not exists [" + bkgNo + "]";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					bkgInfo = bkgList.get(0);
					/* 20160427 logic추가 by HongSeongPil
					 * ID 생성시 현재(ID) BKG정보와 이전상태(IC)BKG정보가 다르고, 현재YD_CD와 현재 BKG의 DEL_CD가 다르면 이전상태(IC)의 BKG정보를 ID를 생성한다.
					 */
					if("ID".equals(mvmtStsCd) && pstCntrInfo != null){
						if (!bkgInfo.getVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !bkgInfo.getSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())
								|| !bkgInfo.getSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
							if (!bkgNo.equals(pstCntrInfo.getBkgNo())) {
								if(bkgInfo.getDelCd() != null && !bkgInfo.getDelCd().equals("")){
									if(!bkgInfo.getDelCd().equals(crrCntrInfo.getOrgYdCd())){
										List<BkgBookingInfoVO> bkgListTmp = null;
										bkgListTmp = dbDao.searchBkgBookingList(pstCntrInfo.getBkgNo());
										if(bkgListTmp != null && bkgListTmp.size() > 0){
											bkgNo = pstCntrInfo.getBkgNo();
											crrCntrInfo.setBkgNo(bkgNo);
											bkgInfo = bkgListTmp.get(0);
											bkgList = bkgListTmp;
										}
									}
								}
							}
						}
					}
					
					autoParam[13] = bkgInfo.getBlNo();
					cgoTp = bkgInfo.getBkgCgoTpCd();
					isConfirm = true;
					if (bkgInfo.getBkgCfm().equals("Y"))
						isConfirm = true;
					else
						isConfirm = false;
					if (crrCntrInfo.getTrnkVslCd() == null || "".equals(crrCntrInfo.getTrnkVslCd())) {
						crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
					}

					if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())
							|| !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
						if (!bkgNo.equals(pstCntrInfo.getBkgNo())) {
							// 2013.07.03 [CHM-201325252] VL 이후 VVD 변경시 CYC 관련 logic 수정
							//  - VL이후  'VD' 생성시  VVD 변경은 Cyc +1을 추가하지 않는다
							if (!crrCntrInfo.getMvmtStsCd().equals("VD")) {
								cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
								crrCntrInfo.setCnmvCycNo(cycNo);
							}
						}
					}
				} catch (DAOException e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Search booking list" + bkgNo+ "]").getMessage(), e);
				}
				/**********************************************************
				 * MVMT STS가 ID이거나 IC이고 야드가 KREIWY1혹은 KRJCWY1 일
				 * 경우 진행하지 않고 무시하도록 변경한다. 2010.2.18
				 **********************************************************/
				try {
					if ("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd)) {
						if (yardCd.equals("KREIWY1") || yardCd.equals("KRJCWY1")) {
							String val = dbDao.checkBkgIDIC(bkgNo);
							if (val != null && !"".equals(val)) {
								rtnVO[0] = "I";
								rtnVO[1] = "Not Accept Movement! (SM DLS Data)";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						}
					}
				} catch (DAOException e) {
					throw new EventException(new ErrorHandler("Not Accept Movement! (SM DLS Data)").getMessage(), e);
				}
				crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
				/********************************************
				 *  VVD 비교를 위한 VSL자료를 얻어온다.      *
				 *  EN/TN은 제외. VSL CODE가 없는경우도 제외 *
				 ********************************************/
				try {
					crrCntrInfo.setTrnkSkdDirCd(pstCntrInfo.getTrnkSkdDirCd());
					crrCntrInfo.setTrnkSkdVoyNo(pstCntrInfo.getTrnkSkdVoyNo());
					crrCntrInfo.setTrnkVslCd(pstCntrInfo.getTrnkVslCd());
					crrCntrInfo.setBkgRcvTermCd(pstCntrInfo.getBkgRcvTermCd());
					crrCntrInfo.setCntrActCd(pstCntrInfo.getCntrActCd());
					crrCntrInfo.setCntrDispFlg(pstCntrInfo.getCntrDispFlg());
					crrCntrInfo.setCntrDmgFlg(pstCntrInfo.getCntrDmgFlg());
					crrCntrInfo.setCntrHngrRckFlg(pstCntrInfo.getCntrHngrRckFlg());
					crrCntrInfo.setCntrRfubFlg(pstCntrInfo.getCntrRfubFlg());
					crrCntrInfo.setImdtExtFlg(pstCntrInfo.getImdtExtFlg());
					crrCntrInfo.setCnmvCycNo(pstCntrInfo.getCnmvCycNo());
					crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());
					crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
					crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
					crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());

					vvdVO = dbDao.getMstInfo(crrCntrInfo);
					if (vvdVO == null || vvdVO.size() == 0) {
						rtnVO[0] = "N";
						rtnVO[1] = "Container infomation does not exist! [" + cntrNoAft + "]";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					vvdInfo = vvdVO.get(0);
				} catch (Exception e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Container infomation does not exist! [" + cntrNoAft + "]").getMessage(), e);
				}
				lvlCd = "0";
				/****************************************
				 *  STS에 따른 LEVEL값을 얻어온다.       *
				 ****************************************/
				CntrMvmtSeqInfoVO cntrMovSeqVO = new CntrMvmtSeqInfoVO();
				try {
					cntrMovSeqVO = dbDao.getCNTRMovSeqRSQL(cgoTp, mvmtStsCd);
					if (cntrMovSeqVO == null) {
						if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
							lvlCd = "0";
						} else {
							rtnVO[0] = "N";
							rtnVO[1] = "Cargo Type and Status Unmatch Error!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					} else {
						lvlCd = cntrMovSeqVO.getCnmvLvlNo();
					}
					if ("ID".equals(pstCntrInfo.getMvmtStsCd())) {
						if ("MT".equals(mvmtStsCd)) {
							cgoTp = pstCntrInfo.getBkgCgoTpCd();
						}
					}
				} catch (Exception ex) {
					/***************************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 ***************************************************************/
					log.info("GET LEVEL FAIL");
					log.error("err " + ex.toString(), ex);
				}

				try {
					if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg())) {
						fmFlag = crrCntrInfo.getFcntrFlg();
					} else if (fmFlag==null || fmFlag.equals("")) {
						fmFlag = cntrMovSeqVO.getFcntrFlg();
					}
				} catch (Exception ex) {
					/***************************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 ***************************************************************/
					log.info("ERROR GET FMFLAG");
					log.error("err " + ex.toString(), ex);
				}

				/* CNTR FULL/EMPTY FLAG SETTING */
				if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
					crrCntrInfo.setFcntrFlg(fmFlag);
				try {
					errMsg = "Full flag is null";
					String[] mvmtSeq = dbDao.getCtmMvmtSeq(mvmtStsCd, cgoTp);
					if (!"TS".equals(mvmtStsCd) && !"ID".equals(mvmtStsCd)) {
						if (mvmtSeq == null) {
							rtnVO[0] = "N";
							rtnVO[1] = "Full status(OC/IC) can't be created for revenue or emtpy repo booking.";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
							crrCntrInfo.setFcntrFlg(mvmtSeq[0]);
					} else if (!"TS".equals(mvmtStsCd) && !"ID".equals(mvmtStsCd)) {
						if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
							crrCntrInfo.setFcntrFlg("F");
					}
					// 2013.10.04 강환 - ID Movement는 Full로만 생성됨
					if ("ID".equals(mvmtStsCd)) 
					{
						crrCntrInfo.setFcntrFlg("Y");
					}

					crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
					crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
					crrCntrInfo.setBlNo(bkgInfo.getBlNo());
					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
					crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
					crrCntrInfo.setCntrHngrRckFlg(vvdInfo.getCntrHngrRckCd());
					crrCntrInfo.setCntrRfubFlg(vvdInfo.getRfubFlg());
					crrCntrInfo.setCntrSvrId(svrId);
					crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					crrCntrInfo.setMvmtInpTpCd(inpType);
					crrCntrInfo.setObCntrFlg("I");
					crrCntrInfo.setOfcCd(ofcCd);
					crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
					crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
					crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
					crrCntrInfo.setUpdUsrId(userId);
					crrCntrInfo.setUsrNm(userNm);
					crrCntrInfo.setCntrActCd(vvdInfo.getAgmtCtyCd());
					crrCntrInfo.setImdtExtFlg(vvdInfo.getImdtExtFlg());
					autoParam[13] = bkgInfo.getBlNo();
				
					// 2013.10.11 [CHM-201326585] MVMT status 변경 logic 추가 (VD-TS-ID - VD-IC-ID) 외 1건
					// 로직 추가 필요
					if ("TS".equals(pstCntrInfo.getMvmtStsCd()) && "ID".equals(mvmtStsCd)) 
					{
						pstCntrInfo.setMvmtStsCd("IC");
						dbDao.updateMovementVO(pstCntrInfo);
					}
				} catch (Exception e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Container infomation does not exist! [" + cntrNoAft + "]").getMessage(), e);
				}
				
			} else if ("VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd)) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
				/*******************************************
				 * 부킹정보를 얻어온다                     *
				 * 부킹 번호가 없을 때만 실행 하도록 한다. *
				 *******************************************/
				if (!nBkgNoFlg) {
					try {
						//  if (bkgNo == null || bkgNo.equals(""))   // 2010-06-01 : EDI로부터 받은 BKG No있어도 다시 구함.
						String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
						bkgNo = returnValues[0];
						crrCntrInfo.setBbulkFlg(returnValues[1]);    // 2010-10-18 : Break Bulk Flag 추가

						if ("MT".equals(mvmtStsCd) && (bkgNo == null || "".equals(bkgNo))) {
							crrCntrInfo.setBkgNo("");
						} else if ("VD".equals(mvmtStsCd) && (bkgNo == null || "".equals(bkgNo))) {
							rtnVO[0] = "N";
							rtnVO[1] = "Booking no does not exist!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						} else if ("VL".equals(mvmtStsCd) && (bkgNo == null || "".equals(bkgNo))) {
							crrCntrInfo.setBkgNo("");
						} else {
							crrCntrInfo.setBkgNo(bkgNo);
						}

					} catch (DAOException e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Booking no does not exist!").getMessage(), e);
					}
				}

				/**************************************
				 * 부킹사이클정보를 얻어온다.         *
				 * CTM_MOVEMENT에서 MAX값을 가져온다  *
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();

				/*****************************************
				 * STS가 OP일 경우 Cycle No를 1 증가한다.*
				 *****************************************/
				crrCntrInfo.setCnmvCycNo(cycNo);
				if (!nBkgNoFlg) {
					/****************************************
					 * BKG_BOOKING에서 부킹정보를 얻어온다. *
					 * BkgInfo VO에 정보를 저장하고 사용함  *
					 ****************************************/
					try {
						svrId = dbDao.searchSvrId(yardCd);
					}catch (Exception e) {
						throw new EventException(new ErrorHandler("Area does not exist [" + yardCd + "]!").getMessage(), e);
					}
					try {
						bkgList = dbDao.searchBkgBookingList(bkgNo);

						if (bkgList == null || bkgList.size() < 1) {
							rtnVO[0] = "N";
							rtnVO[1] = "Booking no does not exist [" + bkgNo + "]!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						bkgInfo = bkgList.get(0);
						cgoTp = bkgInfo.getBkgCgoTpCd();

						// 2010-07-07 : VL이면서 cgoTp이 R(Revenue장비)이면 자동생성시 error가 되지 않도록 fmFlag를 M으로 setting - Rqst by IHJang
						if ("VL".equals(mvmtStsCd) && "R".equals(cgoTp)) {
							fmFlag = "M";
							crrCntrInfo.setFcntrFlg(fmFlag);
						}

						isConfirm = true;
						if (bkgInfo.getBkgCfm().equals("Y")) {
							isConfirm = true;
						} else{
							isConfirm = false;
						}
						if (crrCntrInfo.getTrnkVslCd() == null || crrCntrInfo.getTrnkVslCd().equals("")) {
							crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
							crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
							crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
						}
						if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo()) || !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
							if (!bkgNo.equals(pstCntrInfo.getBkgNo())) {
								// 2013.07.03 [CHM-201325252] VL 이후 VVD 변경시 CYC 관련 logic 수정
								//  - VL이후  'VD' 생성시 VVD 변경은 Cyc +1을 추가하지 않는다
								if (!crrCntrInfo.getMvmtStsCd().equals("VD")) {
									cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
									crrCntrInfo.setCnmvCycNo(cycNo);
								}
							}
						}
					} catch (DAOException e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Booking no does not exist [" + bkgNo + "]!").getMessage(), e);
					}

					// SH 장비의 ERROR처리 변경. 2009-11-20
					if ("SH".equals(mstCntrInfo.getLstmCd()) && "P".equals(cgoTp)) {
						rtnVO[0] = "N";
						rtnVO[1] = "This container is shipper's own container, You can't create empty repo status!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					/********************************************
					 *  VVD 비교를 위한 VSL자료를 얻어온다.      *
					 *  EN/TN은 제외. VSL CODE가 없는경우도 제외 *
					 ********************************************/
					try {
						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						vvdVO = dbDao.getVVDInfo(crrCntrInfo);
						if ((vvdVO == null || vvdVO.size() == 0) && !yardCd.equals("SGSINKA") && !yardCd.equals("LKCMBY2")) {
							rtnVO[0] = "N";
							rtnVO[1] = "Booking vvd does not exist [" + bkgNo + "]!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						vvdInfo = vvdVO.get(0);
					} catch (Exception e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Booking vvd does not exist [" + bkgNo + "]!").getMessage(), e);
					}

					/*******************************************************************
					 *   부킹컨테이너의 마지막 정보를 얻어온다                         *
					 *   STS CD가 VL VD일때만 해당한다. (OP, OC에서 없을 수 있기 때문) *
					 *******************************************************************/
					if ("VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd)) {
						if (crrCntrInfo.getCrntVslCd() == null || crrCntrInfo.getCrntVslCd().equals("")) {
							rtnVO[0] = "N";
							rtnVO[1] = "Input vvd does not exist";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}

						try {
							bkgCntr = dbDao.getBkgContainerLastInfo(cntrNoAft, bkgNo);
							if (bkgCntr == null || bkgCntr.size() == 0) {
								rtnVO[0] = "N";
								rtnVO[1] = "Booking container does not exist [" + cntrNoAft + "]/[" + bkgNo + "]!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							findBkgCntr = true;
							bkgCntrInfo = bkgCntr.get(0);
						} catch (DAOException e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler("Booking container does not exist [" + cntrNoAft + "]/[" + bkgNo + "]!").getMessage(), e);
						}
					}

					/*******************************************************************
					 *   BKG_CONTAINER , BKG_BOOKING에서 최종 자료를 얻어온다(예약포함)  *
					 *******************************************************************/
					try {
						multiBkg = dbDao.searchMultiBkgNo(cntrNoAft, cycNo, mvmtStsCd, bkgNo);

						if (multiBkg != null && multiBkg.size() > 0) {
							MultiBkgNoVO multi = (MultiBkgNoVO) multiBkg.get(0);
							if (multiBkg.size() > 1) {
								// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
								StringBuffer bkgStr = new StringBuffer();
//								String bkgStr = "";
								for (int idxBkg = 0; idxBkg < multiBkg.size(); idxBkg++) {
									if (!bkgNo.equals(multiBkg.get(idxBkg).getBkgNo()) ){
										// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
//										bkgStr = bkgStr + "," + multiBkg.get(idxBkg).getBkgNo();
										bkgStr.append(",").append(multiBkg.get(idxBkg).getBkgNo());
//										bkgStr.append(",");
//										bkgStr.append(multiBkg.get(idxBkg).getBkgNo());
									}
								}
								rtnVO[0] = "N";
								rtnVO[1] = "There are different trunk VVD in another booking![" + bkgStr + "]";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							cgoTp = multi.getBkgCgoTpCd();

							if (bkgInfo.getSkdVoyNo().length() > 0 && bkgInfo.getSkdDirCd().length() > 0 && bkgInfo.getVslCd().length() > 0 && multi.getVslCd().length() > 0 && multi.getSkdVoyNo().length() > 0 && multi.getSkdDirCd().length() > 0) {
								if (!bkgInfo.getVslCd().trim().equals(multi.getVslCd().trim()) || !bkgInfo.getSkdVoyNo().trim().equals(multi.getSkdVoyNo().trim()) || !bkgInfo.getSkdDirCd().trim().equals(multi.getSkdDirCd().trim()) || !bkgInfo.getBkgCgoTpCd().trim().equals(multi.getBkgCgoTpCd().trim())) {
									rtnVO[0] = "N";
									rtnVO[1] = "There are different trunk VVD in another booking![" + multi.getBkgNo() + "]";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
								cgoTp = multi.getBkgCgoTpCd();
							}

						}
					} catch (Exception e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("There are different trunk VVD in another booking! [Multi booking info is null]").getMessage(), e);
					}

					/***************************************
					 *   스페셜 부킹의 속성을 얻어온다       *
					 ***************************************/
					if (crrCntrInfo.getSpclCgoFlg() != null && !crrCntrInfo.getSpclCgoFlg().equals("") && !crrCntrInfo.getSpclCgoFlg().equals("null")) {
						try {
							spclBkg = dbDao.searchSpclBkg(cntrNoAft, bkgCntrInfo.getCnmvCycNo(), crrCntrInfo.getCnmvCycNo());

							if (spclBkg == null || spclBkg.equals("") || spclBkg.equals("-1")) {
								crrCntrInfo.setSpclCgoFlg("N");
							} else {
								crrCntrInfo.setSpclCgoFlg("Y");
							}
						} catch (Exception e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Spcial cargo]").getMessage(), e);
						}
					}

					/***********************************************
					 *   한 컨테이너에 붙어있는 중복 갯수를 구한다 *
					 *   멀티부킹이 여러 VVD에 있으면 에러로 처리한다*
					 ***********************************************/
					try {
						String[] dupBkg = null;
						//String newCycNo = "";
						dupBkg = dbDao.getDupBkgCount(cntrNoAft, bkgCntrInfo.getCnmvCycNo(), cycNo);
						if ("VL".equals(mvmtStsCd))
							if (dupBkg == null) {
								rtnVO[0] = "N";
								rtnVO[1] = "Booking container read Dup check error! [" + cntrNoAft + "]";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								if(!dupBkg[0].equals("0") && !dupBkg[0].equals("1")) {
									rtnVO[0] = "N";
									multiBkg = dbDao.searchMultiBkgNoList(cntrNoAft, cycNo, mvmtStsCd, bkgNo);
									// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
									StringBuffer bkgNos = new StringBuffer();
//									String bkgNos = "";
									for (int idxMul = 0; idxMul < multiBkg.size(); idxMul++) {
										bkgNos.append(multiBkg.get(idxMul).getBkgNo()).append(" ");
//										bkgNos.append();
//										bkgNos.append(" ");
										
//										bkgNos = bkgNos + multiBkg.get(idxMul).getBkgNo() + " ";
										if (idxMul < multiBkg.size() - 1){
//											bkgNos = bkgNos + ", ";
											bkgNos.append(", ");
										}
									}
									rtnVO[1] = "There are different trunck VVD in another Booking.It may be processed in Can't be VL/VD window. [" + bkgNos + "]";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
					} catch (Exception e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Booking container read Dup check error! [" + cntrNoAft + "]").getMessage(), e);
					}
					crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
					/****************************************
					 *  STS에 따른 LEVEL값을 얻어온다.       *
					 ****************************************/
					CntrMvmtSeqInfoVO cntrMovSeqVO = new CntrMvmtSeqInfoVO();
					try {
						cntrMovSeqVO = dbDao.getCNTRMovSeqRSQL(cgoTp, mvmtStsCd);
						if (cntrMovSeqVO == null) {
							if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
								lvlCd = "0";
							} else {
								rtnVO[0] = "N";
								rtnVO[1] = "Cargo Type and Status Unmatch Error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						} else
							lvlCd = cntrMovSeqVO.getCnmvLvlNo();
						if ("ID".equals(pstCntrInfo.getMvmtStsCd())) {
							if ("MT".equals(mvmtStsCd)) {
								cgoTp = pstCntrInfo.getBkgCgoTpCd();
							}
						}
					} catch (DAOException e) {
						/***************************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
						 ***************************************************************/
						log.info("Unexpected system error occurred during data processing. [" + cgoTp + "/" + mvmtStsCd + "]");
						log.error(e.getMessage(),e);
					}

					/***************************************************************
					 * FULL/EMPTY FLAG를 얻어옴. 오류는 무시. 오류시 Empty로 설정함  *
					 ***************************************************************/
					try {
						if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg()))
							fmFlag = crrCntrInfo.getFcntrFlg();
						else if (fmFlag==null || fmFlag.equals(""))
							fmFlag = cntrMovSeqVO.getFcntrFlg();
					} catch (Exception e) {
						/***************************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
						 ***************************************************************/
						log.info("Full flag is null");
						log.error(e.getMessage(),e);
					}

					/* CNTR FULL/EMPTY FLAG SETTING */
					if (crrCntrInfo.getFcntrFlg() == null || crrCntrInfo.getFcntrFlg().equals(""))
						crrCntrInfo.setFcntrFlg(fmFlag);

					try {
						errMsg = "Full flag is null";
						String[] mvmtSeq = dbDao.getCtmMvmtSeq(mvmtStsCd, cgoTp);
						if (mvmtSeq == null) {
							crrCntrInfo.setFcntrFlg("M");
						} else {
							crrCntrInfo.setFcntrFlg(mvmtSeq[0]);
						}

						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
						crrCntrInfo.setBlNo(bkgInfo.getBlNo());
						crrCntrInfo.setCnmvLvlNo(lvlCd);
						crrCntrInfo.setCnmvCycNo(cycNo);
						crrCntrInfo.setCntrActCd(vvdInfo.getAgmtCtyCd());
						crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
						crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
						crrCntrInfo.setCntrHngrRckFlg(vvdInfo.getCntrHngrRckCd());
						crrCntrInfo.setCntrRfubFlg(vvdInfo.getRfubFlg());
						crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
						crrCntrInfo.setCntrSvrId(svrId);
						crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
						crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());

						crrCntrInfo.setMvmtInpTpCd(inpType);
						crrCntrInfo.setObCntrFlg("O");
						crrCntrInfo.setOfcCd(ofcCd);
						crrCntrInfo.setCreUsrId(userId);
						crrCntrInfo.setUpdUsrId(userId);

						crrCntrInfo.setUsrNm(userNm);
						crrCntrInfo.setImdtExtFlg(vvdInfo.getImdtExtFlg());

						autoParam[13] = bkgInfo.getBlNo();
						} catch (Exception e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler(errMsg).getMessage(), e);
						}
				}
				if ("VD".equals(mvmtStsCd)) {
					if (!"VL".equals(pstCntrInfo.getMvmtStsCd())) {
						rtnVO[0] = "N";
						rtnVO[1] = "[VD] Previous status is not 'VL'. Please request origin office to create VL";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					// bkg_emp_flg 용도 확인 필요.
					String mtySplit = bkgInfo.getMtySplitAvalCd();
					if (mtySplit == null) mtySplit= "";
					log.info("BKGNO IS :" + bkgNo + ":");
					if (bkgNo != null && bkgNo.length() > 0 && "P".equals(bkgCntrInfo.getBkgCgoTpCd())) {
						if ("W".equals(mtySplit)) {
							if (bkgNo.length() < 11 || bkgNo.length() > 13) {
								rtnVO[0] = "N";
								rtnVO[1] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}

						} else {
							if (bkgNo.length() == 11) {
								rtnVO[0] = "N";
								rtnVO[1] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else if (bkgNo.length() == 12 && subStr(bkgNo, 10, 12).equals("00")) {
								rtnVO[0] = "N";
								rtnVO[1] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else if (bkgNo.length() < 11 || bkgNo.length() > 13) {
								rtnVO[0] = "N";
								rtnVO[1] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						}
					}
					autoParam[13] = bkgInfo.getBlNo();
				}
			} else if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
				String vslCd 	 = "";
				String skdVoyCd  = "";
				String skdDirCd  = "";

				/*******************************************
				 *   부킹정보를 얻어온다                    *
				 *   부킹 번호가 없을 때만 실행 하도록 한다. *
				 *   OP OC에서는 없을 수 있다.              *
				 *******************************************/
				try {
					bkgNo = pstCntrInfo.getBkgNo();
					if (bkgNo == null) bkgNo = "";
					String prevSts = pstCntrInfo.getMvmtStsCd();

					log.info("PREV :::" + prevSts);
					log.info("FULL :::" + crrCntrInfo.getFcntrFlg());
					log.info("FULL :::" + pstCntrInfo.getFcntrFlg());

					if ("N".equals(crrCntrInfo.getFcntrFlg()) || "M".equals(crrCntrInfo.getFcntrFlg())) {
						bkgNo = "";
						crrCntrInfo.setBkgNo("");
						crrCntrInfo.setBkgKnt("0");
					} else if ("Y".equals(crrCntrInfo.getFcntrFlg()) || "F".equals(crrCntrInfo.getFcntrFlg())) {
						// bkgNo = dbDao.getBkgNoByCntrNo(cntrNoAft);  - BKG No다시 찾지 않음 : 2010-06-08
						crrCntrInfo.setBkgNo(bkgNo);
					} else if ("MT".equals(prevSts) || "CM".equals(prevSts) || (("EN".equals(prevSts) || "TN".equals(prevSts)) && "N".equals(pstCntrInfo.getFcntrFlg())) ) {
						bkgNo = "";
						crrCntrInfo.setBkgNo("");
						crrCntrInfo.setBkgKnt("0");
					} else {
						if ("C".equals(subStr(prevSts, 0, 1))) {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");
						} else if (("EN".equals(prevSts) || "TN".equals(prevSts)) && "Y".equals(pstCntrInfo.getFcntrFlg()) && (bkgNo == null || "".equals(bkgNo))) {
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
						}
						crrCntrInfo.setBkgNo(bkgNo);
					}
				} catch(Exception e) {
					throw new EventException(new ErrorHandler("Booking no check error! [" + cntrNoAft + "]").getMessage(), e);
				}
				log.info("부킹 번호 :" + bkgNo);
				/**************************************
				 * 부킹사이클정보를 얻어온다.         *
				 * CTM_MOVEMENT에서 MAX값을 가져온다. *
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();

				/****************************************
				 * STS가 OP일 경우 Cycle No를 1 증가한다.*
				 ****************************************/
				crrCntrInfo.setCnmvCycNo(cycNo);

				/***************************************
				 * BKG_BOOKING에서 부킹정보를 얻어온다. *
				 * BkgInfo VO에 정보를 저장하고 사용함  *
				 ***************************************/
				if (bkgNo != null && !bkgNo.equals("")) {
					try {
						svrId = dbDao.searchSvrId(yardCd);
					}catch (Exception e) {
						throw new EventException(new ErrorHandler("Area does not exist [" + yardCd + "]!").getMessage(), e);
					}
					try {
						//bkgList = dbDao.searchBkgBookingList(bkgNo);
						// Cancel체크 삭제 2010-0420
						bkgList = dbDao.searchBkgBookingAllList(bkgNo);

						if (bkgList == null || bkgList.size() < 1) {
							rtnVO[0] = "N";
							rtnVO[1] = "Booking no does not exist [" + bkgNo + "]!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						bkgInfo = bkgList.get(0);
						cgoTp = bkgInfo.getBkgCgoTpCd();
						isConfirm = true;
						if ("Y".equals(bkgInfo.getBkgCfm()))
							isConfirm = true;
						else
							isConfirm = false;
						if (crrCntrInfo.getTrnkVslCd() == null || crrCntrInfo.getTrnkVslCd().equals("")) {
							crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
							crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
							crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
						}
						if ( (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo()) || !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) ) {
							if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
								if (pstCntrInfo.getFcntrFlg().equals("Y") && (pstCntrInfo.getBkgNo() == null || "".equals(pstCntrInfo.getBkgNo())) && bkgNo.equals(atbCntrInfo.getBkgNo())) {
									log.info("Full EN : BKG NO IS NOT CHANGE");
								} else {
									cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
								}
							}
							crrCntrInfo.setCnmvCycNo(cycNo);
						}
						blNo = bkgInfo.getBlNo();
						vslCd = bkgInfo.getVslCd();
						skdVoyCd = bkgInfo.getSkdVoyNo();
						skdDirCd = bkgInfo.getSkdDirCd();

					} catch (DAOException e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Booking no does not exist [" + bkgNo + "]!").getMessage(), e);
					}

					try {
						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						crrCntrInfo.setTrnkSkdDirCd(pstCntrInfo.getTrnkSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(pstCntrInfo.getTrnkSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(pstCntrInfo.getTrnkVslCd());
						crrCntrInfo.setBkgRcvTermCd(pstCntrInfo.getBkgRcvTermCd());
						crrCntrInfo.setCntrActCd(pstCntrInfo.getCntrActCd());
						crrCntrInfo.setCntrDispFlg(pstCntrInfo.getCntrDispFlg());
						crrCntrInfo.setCntrDmgFlg(pstCntrInfo.getCntrDmgFlg());
						crrCntrInfo.setCntrHngrRckFlg(pstCntrInfo.getCntrHngrRckFlg());
						crrCntrInfo.setCntrRfubFlg(pstCntrInfo.getCntrRfubFlg());
						crrCntrInfo.setImdtExtFlg(pstCntrInfo.getImdtExtFlg());
						crrCntrInfo.setCnmvCycNo(pstCntrInfo.getCnmvCycNo());
						crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());

						vvdVO = dbDao.getMstInfo(crrCntrInfo);
						if (vvdVO == null || vvdVO.size() == 0) {
							rtnVO[0] = "N";
							rtnVO[1] = "Container infomation does not exist! [" + cntrNoAft + "]";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						vvdInfo = vvdVO.get(0);
					} catch (Exception e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Container infomation does not exist! [" + cntrNoAft + "]").getMessage(), e);
					}
				}

				/**********************************************************
				 * MVMT STS가 EN이거나 TN이고 야드가 KREIWY1혹은 KRJCWY1 일
				 * 경우 진행하지 않고 무시하도록 변경한다. 2014.1.07 - CHM-201328132
				 **********************************************************/
				try {
					if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
						com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO dbDaoMgt = new com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO();

						String temp_pod_del[] = new String[2];
						temp_pod_del = dbDaoMgt.getPodDel(bkgNo);
						String temp_pod = "";
						String temp_del = "";

						if (temp_pod_del != null && temp_pod_del[0] != null && temp_pod_del[1] != null) {
							temp_pod = temp_pod_del[0];
							temp_del = temp_pod_del[1];
						}

						if ((yardCd.equals("KREIWY1") || yardCd.equals("KRJCWY1")) && (fmFlag.equals("F") || fmFlag.equals("Y"))) {
							if (((temp_pod.equals("KRPTK")) && (temp_del.equals("KRPTK"))) || ((temp_pod.equals("KRPUS")) && (temp_del.equals("KRPUS"))) || ((temp_pod.equals("KRKAN")) && (temp_del.equals("KRKAN"))) || ((temp_pod.equals("KRINC")) && (temp_del.equals("KRINC")))) {
								String val = dbDao.checkBkgIDIC(bkgNo);

								if (val != null && !"".equals(val)) {
									rtnVO[0] = "I";
									rtnVO[1] = "Not Accept Movement! (HJ DLS Data)";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
						}

						if ("IC".equals(pstCntrInfo.getMvmtStsCd()) && temp_pod.equals("KRGIN") && temp_del.equals("KRINC")) {
							mvmtStsCd = "ID";
							crrCntrInfo.setMvmtStsCd(mvmtStsCd);
							crrCntrInfo.setFcntrFlg("Y");
							crrCntrInfo.setObCntrFlg("I");
						}
					}
				} catch (DAOException e) {
					throw new EventException(new ErrorHandler("Not Accept Movement! (SM DLS Data)").getMessage(), e);
				}

				lvlCd = "0";
				CntrMvmtSeqInfoVO cntrMovSeqVO = new CntrMvmtSeqInfoVO();

				try {
					cntrMovSeqVO = dbDao.getCNTRMovSeqRSQL(cgoTp, mvmtStsCd);
					if (cntrMovSeqVO == null) {
						if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
							lvlCd = "0";
						} else {
							rtnVO[0] = "N";
							rtnVO[1] = "Cargo type and status unmatch error!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					} else
						lvlCd = cntrMovSeqVO.getCnmvLvlNo();
					if ("ID".equals(pstCntrInfo.getMvmtStsCd())) {
						if ("MT".equals(mvmtStsCd)) {
							cgoTp = pstCntrInfo.getBkgCgoTpCd();
						}
					}
					if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg()))
						fmFlag = crrCntrInfo.getFcntrFlg();
					else if (fmFlag==null || fmFlag.equals(""))
						fmFlag = pstCntrInfo.getFcntrFlg();
				} catch (Exception e) {
					/***************************************************************
					 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
					 ***************************************************************/
					log.info(e.getMessage());
					log.error(e.getMessage(),e);
				}
				// STOCK UPDATE를 위한 Prev Sts 저장
				crossItem.setPrevSts(pstCntrInfo.getMvmtStsCd());

				autoParam[13] = blNo;
				autoParam[10] = vslCd;
				autoParam[11] = skdVoyCd;
				autoParam[12] = skdDirCd;
			}

			/***************************************************************
			 * 자동생성 호출 - BCImpl.autoCre()
			 ***************************************************************/
			if (!"Y".equals(mstCntrInfo.getHjsCreFlg()) && isFirst) {
				//CheckBookingVO bkgVO = null;
				CheckBookingVO bkgVO = new CheckBookingVO();
				autoParam[3] = fmFlag;
				String[] autoCreRtnVal = new String[6];
				try {
					autoCreRtnVal = autoCre(crrCntrInfo, pstCntrInfo, mstCntrInfo, bkgInfo, bkgVO, atbCntrInfo, autoParam);
					if (autoCreRtnVal[0] != null && autoCreRtnVal[0].equals("N")) {
						crossItem.setRtnStr(autoCreRtnVal);
						return crossItem;
					}

					if ("OP".equals(autoCreRtnVal[2]) && "Y".equals(mstCntrInfo.getDmgFlg())) {
						// Status가 OP이고 MST_CONTAINER에서 불러온 Damage Flag가 Y일때 SC에서 MNR을 호출하게하기 위한 flag
						crossItem.setMnrCallYN("Y");
					}

					idNo  = autoCreRtnVal[4];
					idSeq = autoCreRtnVal[5];

					if ("Y".equals(autoCreRtnVal[0]) && autoCreRtnVal[1] != null && !"".equals(autoCreRtnVal[1])) {
						mvmtStsCd = autoCreRtnVal[1];
						crrCntrInfo.setMvmtStsCd(mvmtStsCd);
					}
				} catch (Exception e) {
					throw new EventException(new ErrorHandler(e.getMessage()).getMessage());
				}

				isFirst = false;
			}
			/***************************************************************
			 * 자동생성 종료 - BCImpl.autoCre()
			 ***************************************************************/

			crossItem.setEdiSendVslCd(crrCntrInfo.getCrntVslCd());          // sendEDIToKOR을 위한 VslCd setting
			crossItem.setEdiSendSkdVoyNo(crrCntrInfo.getCrntSkdVoyNo());    // sendEDIToKOR을 위한 SkdVoyNo setting
			crossItem.setEdiSendSkdDirCd(crrCntrInfo.getCrntSkdDirCd());    // sendEDIToKOR을 위한 SkdDirCd setting

			// 자동생성이 종료 된 이후
			if ("MT".equals(mvmtStsCd)) {
				if (cntrNoAft.equals(cntrNoBef)) continue;
				if ("Y".equals(mstCntrInfo.getHjsCreFlg())) {
					crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
					crrCntrInfo.setBkgNo("");
					try {
						if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg())) {
							fmFlag = crrCntrInfo.getFcntrFlg();
						}
					} catch (Exception e) {
						/***************************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
						 ***************************************************************/
						log.info("ERROR GET FMFLAG");
						log.error(e.getMessage(),e);
					}
					/* CNTR FULL/EMPTY FLAG SETTING */
					if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg())) {
						crrCntrInfo.setFcntrFlg(fmFlag);
					}
					crrCntrInfo.setBkgRcvTermCd("");
					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					crrCntrInfo.setCntrSvrId(svrId);
					crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					crrCntrInfo.setMvmtInpTpCd(inpType);
					crrCntrInfo.setObCntrFlg("I");
					crrCntrInfo.setOfcCd(ofcCd);
					crrCntrInfo.setUpdUsrId(userId);
					crrCntrInfo.setCreUsrId(userId);
					crrCntrInfo.setUsrNm(userNm);
					crrCntrInfo.setFcntrFlg("M");
					crrCntrInfo.setPreStsFlg("N");
					crrCntrInfo.setIbflag("I");
					crrCntrInfo.setBkgKnt("0");

					crossItem.setMstBkgCntrOpUpdate(true);

					try {
						errMsg = "Unexpected system error occurred during data processing. [Full/Empty flag]";
						String[] mvmtSeq = dbDao.getCtmMvmtSeq(mvmtStsCd, cgoTp);
						if (mvmtSeq == null) {
							crrCntrInfo.setFcntrFlg("M");
							crrCntrInfo.setCnmvLvlNo("0");
						} else {
							crrCntrInfo.setFcntrFlg(mvmtSeq[0]);
							crrCntrInfo.setCnmvLvlNo(mvmtSeq[1]);
						}
						errMsg = "Unexpected system error occurred during data processing. [Add " + mvmtStsCd +"]";
						if (sameCntr == false) {
							idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
							idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
							crrCntrInfo.setCnmvIdNo(idNo);
							crrCntrInfo.setCnmvSeq(idSeq);
							dbDao.addCtmMovement(crrCntrInfo);

							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setUpdateMaster(true);

						}
					} catch (Exception ex) {
						log.error(ex.getMessage(),ex);
						throw new EventException(new ErrorHandler(errMsg).getMessage());
					}

				} else {
					crrCntrInfo.setFcntrFlg("M");
					try {
						pstCntrInfo = dbDao.searchMovementStatusMst(cntrNoAft, evntDt);
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Last movement(Auto)]").getMessage(), ex);
					}

					if ("ID".equals(pstCntrInfo.getMvmtStsCd())) {
						try {
						bkgNo = pstCntrInfo.getBkgNo();
						// MT에서 이전 STS가 ID이고 BKG가 없을 경우 찾아오도록 로직을 변경한다. 2009-11-23
						if (bkgNo == null || "".equals(bkgNo)) {
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
						}
						crrCntrInfo.setBkgNo(bkgNo);
						crrCntrInfo.setBlNo(pstCntrInfo.getBlNo());
						crrCntrInfo.setFcntrFlg(pstCntrInfo.getFcntrFlg());

						crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());
						/********************************************
						 *  VVD 비교를 위한 VSL자료를 얻어온다.      *
						 *  EN/TN은 제외. VSL CODE가 없는경우도 제외 *
						 ********************************************/
						crrCntrInfo.setTrnkSkdDirCd(pstCntrInfo.getTrnkSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(pstCntrInfo.getTrnkSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(pstCntrInfo.getTrnkVslCd());
						crrCntrInfo.setBkgRcvTermCd(pstCntrInfo.getBkgRcvTermCd());
						crrCntrInfo.setCntrActCd(pstCntrInfo.getCntrActCd());
						crrCntrInfo.setCntrDispFlg(pstCntrInfo.getCntrDispFlg());
						crrCntrInfo.setCntrDmgFlg(pstCntrInfo.getCntrDmgFlg());
						crrCntrInfo.setCntrHngrRckFlg(pstCntrInfo.getCntrHngrRckFlg());
						crrCntrInfo.setCntrRfubFlg(pstCntrInfo.getCntrRfubFlg());
						crrCntrInfo.setImdtExtFlg(pstCntrInfo.getImdtExtFlg());
						crrCntrInfo.setCnmvCycNo(pstCntrInfo.getCnmvCycNo());
						crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());
						} catch (Exception e) {
							log.error(e.getMessage(),e);
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), e);
						}
					}

					lvlCd = "0";
					/****************************************
					 *  STS에 따른 LEVEL값을 얻어온다.       *
					 ****************************************/
					CntrMvmtSeqInfoVO cntrMovSeqVO = new CntrMvmtSeqInfoVO();
					try {
						cntrMovSeqVO = dbDao.getCNTRMovSeqRSQL(cgoTp, mvmtStsCd);
						if (cntrMovSeqVO == null) {
							if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
								lvlCd = "0";
							} else {
								rtnVO[0] = "N";
								rtnVO[1] = "Cargo type and status unmatch error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						} else
							lvlCd = cntrMovSeqVO.getCnmvLvlNo();
						if ("ID".equals(pstCntrInfo.getMvmtStsCd())) {
							if ("MT".equals(mvmtStsCd)) {
								cgoTp = pstCntrInfo.getBkgCgoTpCd();
							}
						}
					} catch (Exception e) {
						/***************************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
						 ***************************************************************/
						log.debug("GET LEVEL FAIL");
						log.error(e.getMessage(),e);
					}

					try {
						if (crrCntrInfo.getFcntrFlg() != null && !crrCntrInfo.getFcntrFlg().equals(""))
							fmFlag = crrCntrInfo.getFcntrFlg();
						else if (fmFlag==null || fmFlag.equals(""))
							fmFlag = cntrMovSeqVO.getFcntrFlg();
					} catch (Exception e) {
						/***************************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
						 ***************************************************************/
						log.info("ERROR GET FMFLAG");
						log.error(e.getMessage(),e);
					}

					// 전 상태에서 물려받는다.
					if (pstCntrInfo != null && ("OP".equals(pstCntrInfo.getMvmtStsCd()) || "EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd()))) {
						crrCntrInfo.setFcntrFlg("M");
						crrCntrInfo.setTrnkSkdDirCd("");
						crrCntrInfo.setTrnkSkdVoyNo("");
						crrCntrInfo.setTrnkVslCd("");
						crrCntrInfo.setBkgCgoTpCd("");
						crrCntrInfo.setBkgNo("");
						crrCntrInfo.setBlNo("");
						crrCntrInfo.setBkgKnt("0");

					} else {
						if (bkgInfo != null) {
							crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
							crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
							crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
							crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
							crrCntrInfo.setBlNo(bkgInfo.getBlNo());
							crrCntrInfo.setBkgNo(bkgNo);
						}
						if (crrCntrInfo.getTrnkVslCd() == null || crrCntrInfo.getTrnkVslCd().equals("")) {
							crrCntrInfo.setTrnkVslCd(pstCntrInfo.getTrnkVslCd());
							crrCntrInfo.setTrnkSkdVoyNo(pstCntrInfo.getTrnkSkdVoyNo());
							crrCntrInfo.setTrnkSkdDirCd(pstCntrInfo.getTrnkSkdDirCd());
						}
						crossItem.setMstBkgCntrOpUpdate(true);
					}

					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					crrCntrInfo.setCntrSvrId(svrId);
					crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					crrCntrInfo.setMvmtInpTpCd(inpType);
					crrCntrInfo.setObCntrFlg("I");
					crrCntrInfo.setOfcCd(ofcCd);
					crrCntrInfo.setUpdUsrId(userId);
					crrCntrInfo.setUsrNm(userNm);

					crrCntrInfo.setIbflag("I");
					// STOCK UPDATE를 위한 Prev Sts 저장
					crossItem.setPrevSts(pstCntrInfo.getMvmtStsCd());
					
					try {
						String[] mvmtSeq = dbDao.getCtmMvmtSeq(mvmtStsCd, cgoTp);
						if (mvmtSeq == null) {

							crrCntrInfo.setFcntrFlg("M");
							crrCntrInfo.setCnmvLvlNo("0");
						} else {
							crrCntrInfo.setFcntrFlg(mvmtSeq[0]);
							crrCntrInfo.setCnmvLvlNo(mvmtSeq[1]);
						}
						if (sameCntr == false) {
							idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
							idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
							crrCntrInfo.setCnmvIdNo(idNo);
							crrCntrInfo.setCnmvSeq(idSeq);
							dbDao.addCtmMovement(crrCntrInfo);
							//dbDao.updateMstContainer(ctmVO);
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setUpdateMaster(true);

						}
						log.debug("888888888888881111111111111 MT 자동생성 이후"); 
						// 추가 로직 2012.12.03 TN을 EN으로 변경 
						if ("TN".equals(pstCntrInfo.getMvmtStsCd())) { // [CHM-201222197-01]
							String orgLcc = ""; 
							String dstLcc = ""; 
							try { 
								String[] lcc = dbDao.getLccRccCode(subStr(crrCntrInfo.getOrgYdCd(), 0, 5)); 
								if (lcc != null && !lcc[2].equals("")) { 
									orgLcc = lcc[2];  
								} 
								
							} catch (DAOException e) { 
								throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
							} catch (Exception e) { 
								throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} 
							try { 
								String[] lcc = dbDao.getLccRccCode(subStr(pstCntrInfo.getOrgYdCd(), 0, 5)); 
								if (lcc != null && !lcc[2].equals("")) { 
									dstLcc = lcc[2];  
								} 
								
							} catch (DAOException e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} catch (Exception e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} 
							try {
								if (!orgLcc.equals(dstLcc)) {            
									pstCntrInfo.setMvmtStsCd("EN");      
									pstCntrInfo.setCreUsrId(userId); 
									dbDao.updateContainer(pstCntrInfo, "2", ""); 
								}
							} catch (DAOException e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} catch (Exception e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} 
						}
						
						// 추가 로직 2013.01.14 EN을 TN으로 변경 추가 [CHM-201222197-01]						
						if ("EN".equals(pstCntrInfo.getMvmtStsCd())) { // [CHM-201222197-01]
							String orgLcc = ""; 
							String dstLcc = ""; 
							try { 
								String[] lcc = dbDao.getLccRccCode(subStr(crrCntrInfo.getOrgYdCd(), 0, 5)); 
								if (lcc != null && !lcc[2].equals("")) { 
									orgLcc = lcc[2];  
								} 
								
							} catch (DAOException e) { 
								throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
							} catch (Exception e) { 
								throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} 
							try { 
								String[] lcc = dbDao.getLccRccCode(subStr(pstCntrInfo.getOrgYdCd(), 0, 5)); 
								if (lcc != null && !lcc[2].equals("")) { 
									dstLcc = lcc[2];  
								} 
								
							} catch (DAOException e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} catch (Exception e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} 
							try {
								if (orgLcc.equals(dstLcc)) {             
									pstCntrInfo.setMvmtStsCd("TN");      
									pstCntrInfo.setCreUsrId(userId);     
									dbDao.updateContainer(pstCntrInfo, "2", ""); 
								}
							} catch (DAOException e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} catch (Exception e) { 
								throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
							} 
						}
						if ("CM".equals(pstCntrInfo.getMvmtStsCd()) && "C".equals(pstCntrInfo.getMvmtCreTpCd())) {
							crrCntrInfo.setMvmtStsCd("CM");
							crrCntrInfo.setMvmtCreTpCd("");
							dbDao.updateContainer(crrCntrInfo, "2", "3");
							// CM Update후 MST에 전송할 Status를 MT로 setting
							crrCntrInfo.setMvmtStsCd("MT");
						}
					} catch (Exception ex) {
						log.error(ex.getMessage(),ex);
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), ex);
					}
				}

			} else if ("OP".equals(mvmtStsCd) || "OC".equals(mvmtStsCd)) {
				/****************************************
				 *  STS에 따른 LEVEL값을 얻어온다.       *
				 ****************************************/
				if ("OP".equals(mvmtStsCd) && "SH".equals(mstCntrInfo.getLstmCd()) && "F".equals(cgoTp)) {
					rtnVO[0] = "N";
					rtnVO[1] = "This Container is Shipper's Own Container, You can't create OP status!";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				/* CNTR FULL/EMPTY FLAG SETTING */
				if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
					crrCntrInfo.setFcntrFlg(fmFlag);

				if ("S".equals(bkgInfo.getBkgStsCd()) || "X".equals(bkgInfo.getBkgStsCd())) {
					rtnVO[0] = "N";
					rtnVO[1] = "Cancled Or Splited Booking!";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				if (svrId == null || "E".equals(svrId)) {
					rtnVO[0] = "N";
					rtnVO[1] = "Can't find Server";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				if (!bkgInfo.getSvrId().equals(svrId)) {
					rtnVO[0] = "N";
					rtnVO[1] = "You can't create " + mvmtStsCd + " status with booking no created from other area.";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				if (cntrNoAft.equals(cntrNoBef)) continue;

				String[] bkgCntrStr = null;
				try {
					bkgCntrStr = dbDao.searchBKGCNTR(bkgNo, cntrNoAft);

					if (bkgCntrStr == null) {
						log.info("NO DATA CHANGE 1512");
						findBkgCntr = false;
						// BKG 요청으로 N으로 강제 세팅함. 2009-11-12
						cntrPrtFlg  = "N";
					} else {
						findBkgCntr = true;
						cntrPrtFlg  = bkgCntrStr[3];
					}
				} catch (Exception e) {
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [" + bkgNo + "/" + cntrNoAft + "]").getMessage(), e);
				}

				/*****************************
				 * BKG 에서 CONFIRM을 가져 옴 *
				 *****************************/
				try {
					String[] mvmtSeq = dbDao.getCtmMvmtSeq(mvmtStsCd, cgoTp);
					if (mvmtSeq == null && !"ID".equals(mvmtStsCd)) {
						rtnVO[0] = "N";
						rtnVO[1] = "Full status(OC/IC) can't be created for revenue or emtpy repo booking.";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					} else if ("ID".equals(mvmtStsCd)) {
						if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
							crrCntrInfo.setFcntrFlg("F");
					} else {
						if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
							crrCntrInfo.setFcntrFlg(mvmtSeq[0]);
					}

					/******************************
					 *  DATA 입력 전 파라미터 설정 *
					 ******************************/
					crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
					crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
					crrCntrInfo.setBlNo(bkgInfo.getBlNo());
					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
					crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
					crrCntrInfo.setCntrHngrRckFlg(vvdInfo.getCntrHngrRckCd());
					crrCntrInfo.setCntrRfubFlg(vvdInfo.getRfubFlg());
					crrCntrInfo.setCntrSvrId(svrId);
					crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());

					crrCntrInfo.setMvmtInpTpCd(inpType);
					crrCntrInfo.setObCntrFlg("O");
					crrCntrInfo.setOfcCd(ofcCd);
					crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
					crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
					crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
					crrCntrInfo.setUpdUsrId(userId);
					crrCntrInfo.setUsrNm(userNm);
					crrCntrInfo.setCntrActCd(vvdInfo.getAgmtCtyCd());
					crrCntrInfo.setImdtExtFlg(vvdInfo.getImdtExtFlg());

					if (sameCntr == false) {
						// CTM_MOVEMENT 에 입력.
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						crrCntrInfo.setCnmvIdNo(idNo);
						crrCntrInfo.setCnmvSeq(idSeq);
						
						// 2013.05.13 [CHM-201324248] CTM: ID이후 OP 생성시(EDI msg)  ID/OP간 동일 Bkg여부 확인 
						if ("ID".equals(pstCntrInfo.getMvmtStsCd()) && "OP".equals(mvmtStsCd)) {
							log.debug(" error 666666666666666666666 OP INSERT");
							if(pstCntrInfo.getBkgNo().equals(crrCntrInfo.getBkgNo())){
								crrCntrInfo.setFcntrFlg("M");
								crrCntrInfo.setBkgCgoTpCd("");
								crrCntrInfo.setBkgRcvTermCd("");
								crrCntrInfo.setBlNo("");
								crrCntrInfo.setBkgNo("");
								crrCntrInfo.setCnmvLvlNo("");
								crrCntrInfo.setMvmtStsCd("TN");
								crrCntrInfo.setTrnkSkdDirCd("");
								crrCntrInfo.setTrnkSkdVoyNo("");
								crrCntrInfo.setTrnkVslCd("");
								crrCntrInfo.setBkgKnt("");
							}
							
						}

						dbDao.addCtmMovement(crrCntrInfo);
						// MST_CONTAINER 입력.
						// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
						tmpRtnVO = new StringBuffer();
						tmpRtnVO.append(rtnVO[2]);
						tmpRtnVO.append("U");
						rtnVO[2] = tmpRtnVO.toString();
//						rtnVO[2] = rtnVO[2] + "U";
						crossItem.setCusCtmMovementVO(crrCntrInfo);
						crossItem.setUpdateMaster(true);
						//dbDao.MstCntrUpdateLast(cntrNoAft);
					}
				} catch (Exception ex) {
					log.error(ex.getMessage(),ex);
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), ex);
				}

				if (!isFindBkg) {
					if (!isConfirm) {
						// Confirm Check가 True이면 Insert Into Bkg_Cntr
						crossItem.setMstBkgCntrOpUpdate(true);
						crossItem.setFindBkgCntr(findBkgCntr);
						crossItem.setCntrPrtFlg(cntrPrtFlg);
					} else {
						crossItem.setMstCtmMvmtIrrInsert(true);
						crossItem.setMstBkgCntrOpUpdate(false);
						crossItem.setCntrPrtFlg(cntrPrtFlg);
					}
					crossItem.setCntrNo(cntrNoAft);

				} else {
					// Confirm Check는 Default true로 지정 함.
					if ("OP".equals(mvmtStsCd)) {
						if (!isConfirm) {
							// Confirm Check가 True이면 Insert Into Bkg_Cntr
							crossItem.setMstBkgCntrOpUpdate(true);
							crossItem.setFindBkgCntr(findBkgCntr);
							crossItem.setCntrPrtFlg(cntrPrtFlg);
						} else {
							if (findBkgCntr == true) {
								crossItem.setMstCtmMvmtIrrInsert(false);
								crossItem.setMstBkgCntrOpUpdate(true);
							} else {
								crossItem.setMstCtmMvmtIrrInsert(true);
								crossItem.setMstBkgCntrOpUpdate(false);
							}
						}
						crossItem.setCntrNo(cntrNoAft);

					} else if ("OC".equals(mvmtStsCd)) {
						crrCntrInfo.getCntrTpszCd();
						try {
							if (!isConfirm) {
								// Confirm Check가 True이면 Insert Into Bkg_Cntr
								crossItem.setMstBkgCntrOpUpdate(true);
								crossItem.setFindBkgCntr(findBkgCntr);
								crossItem.setCntrPrtFlg(cntrPrtFlg);
							} else {
								if (findBkgCntr == true) {
									crossItem.setMstCtmMvmtIrrInsert(false);
									crossItem.setMstBkgCntrOpUpdate(true);
								} else {
									crossItem.setMstCtmMvmtIrrInsert(true);
									crossItem.setMstBkgCntrOpUpdate(false);
								}
							}
							crossItem.setCntrNo(cntrNoAft);

						} catch (Exception ex) {
							throw new EventException(new ErrorHandler("There is no previous(2) container movement!").getMessage(), ex);
						}
					}
				}
				// 추가 로직 2013.01.14 TN을 EN으로 변경 
				// 2013.03.07 강   환 [CHM-201323292-01] 현재 Movement가 OC이고, 전전 Movement가 MT면 직전 Movement를 변경하지 않는다
				log.debug(" error 55555555555555555555");
				
				if(atbCntrInfo != null )	// 전전  MT가 없는 경우 Check하지 않도록 수정
				{
				
				if(!"MT".equals(atbCntrInfo.getMvmtStsCd()) && !"OC".equals(crrCntrInfo.getMvmtStsCd()))
				{

				if ("TN".equals(pstCntrInfo.getMvmtStsCd())) { // [CHM-201222197-01]
					String orgLcc = ""; 
					String dstLcc = ""; 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(crrCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							orgLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(pstCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							dstLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try {
						if (!orgLcc.equals(dstLcc)) {            
							pstCntrInfo.setMvmtStsCd("EN");      
							pstCntrInfo.setCreUsrId(userId); 
							dbDao.updateContainer(pstCntrInfo, "2", ""); 
						}
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
				}
				
				// 추가 로직 2013.01.14 EN을 TN으로 변경 추가 [CHM-201222197-01]
				log.debug("777777777777777777777777 : " + pstCntrInfo.getMvmtStsCd());
				if ("EN".equals(pstCntrInfo.getMvmtStsCd())) {
					String orgLcc = ""; 
					String dstLcc = ""; 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(crrCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							orgLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(pstCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							dstLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try {
						if (orgLcc.equals(dstLcc)) {             
							pstCntrInfo.setMvmtStsCd("TN");      
							pstCntrInfo.setCreUsrId(userId);     
							dbDao.updateContainer(pstCntrInfo, "2", ""); 
						}
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
				}
				}  //!"MT".equals(atbCntrInfo.getMvmtStsCd()) && !"OC".equals(crrCntrInfo.getMvmtStsCd())
				}  // 전전  MT가 없는 경우 Check하지 않도록 수정 2013.03.08
				
			} else if ("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {

				if (cntrNoAft.equals(cntrNoBef)) continue;

				try {
					errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
					if (sameCntr == false) {
						// CTM_MOVEMENT 에 입력.
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						crrCntrInfo.setCnmvIdNo(idNo);
						crrCntrInfo.setCnmvSeq(idSeq);
						crrCntrInfo.setMvmtInpTpCd(inpType);
						crrCntrInfo.setCntrSvrId(svrId);
						crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());

						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
						crrCntrInfo.setBlNo(bkgInfo.getBlNo());
						crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());

						crrCntrInfo.setCnmvLvlNo(lvlCd);
						crrCntrInfo.setCnmvCycNo(cycNo);
						crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
						crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
						crrCntrInfo.setCntrHngrRckFlg(vvdInfo.getCntrHngrRckCd());
						crrCntrInfo.setCntrRfubFlg(vvdInfo.getRfubFlg());
						crrCntrInfo.setCntrSvrId(svrId);
						crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
						crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
						crrCntrInfo.setMvmtInpTpCd(inpType);

						//IHJANG 2010/05/11
						//TS일 경우 전단계의 이력을 사용 한다.
						if ("TS".equals(mvmtStsCd)) {
							crrCntrInfo.setObCntrFlg(pstCntrInfo.getObCntrFlg());
							crrCntrInfo.setFcntrFlg(pstCntrInfo.getFcntrFlg());
						}
						// 2013.10.04 강환 - ID Movement는 Full로만 생성됨
						else if ("ID".equals(mvmtStsCd)) 
						{
							crrCntrInfo.setFcntrFlg("Y");
						}
						else {
							crrCntrInfo.setObCntrFlg("I");
						}

						crrCntrInfo.setOfcCd(ofcCd);
						crrCntrInfo.setUpdUsrId(userId);
						crrCntrInfo.setUsrNm(userNm);
						crrCntrInfo.setCntrActCd(vvdInfo.getAgmtCtyCd());
						crrCntrInfo.setImdtExtFlg(vvdInfo.getImdtExtFlg());
						crrCntrInfo.setPreStsFlg("N");
						dbDao.addCtmMovement(crrCntrInfo);
						// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
						tmpRtnVO = new StringBuffer();
						tmpRtnVO.append(rtnVO[2]);
						tmpRtnVO.append("U");
						rtnVO[2] = tmpRtnVO.toString();
//						rtnVO[2] = rtnVO[2] + "U";
						crossItem.setCusCtmMovementVO(crrCntrInfo);
						crossItem.setUpdateMaster(true);
					}
					crossItem.setMstBkgCntrOpUpdate(true);

				} catch (DAOException e) {
					throw new EventException(new ErrorHandler(errMsg).getMessage(), e);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
				}

				if ("ID".equals(mvmtStsCd)) {
					// SH장비인 경우 XX를 생성한다.(2010-05-24 : BkgCgoTpCd가 R인 OR조건 삭제)
					if ("SH".equals(mstCntrInfo.getLstmCd())) {
						crrCntrInfo.setMvmtStsCd("XX");
						crossItem.setEdiSendLstrmCd(mstCntrInfo.getLstmCd());    // sendEDIToKOR을 위한 LstrmCd setting
						try {
							crrCntrInfo.setMvmtCreTpCd("C");
							crrCntrInfo.setCntrDispFlg("Y");
							crrCntrInfo.setAciacDivCd("I");
							idNo = String.valueOf(Integer.parseInt(idNo) + 1);
							idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
							crrCntrInfo.setCnmvIdNo(idNo);
							crrCntrInfo.setCnmvSeq(idSeq);
							dbDao.addCtmMovement(crrCntrInfo);

							crrCntrInfo.setNewFlg("X");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setUpdateMaster(true);
						} catch (DAOException e) {
							/***************************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
							 ***************************************************************/
							log.error(e.getMessage(),e);
							rtnVO[0] = "N";
							rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						} catch (Exception ex) {
							/***************************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
							 ***************************************************************/
							log.error(ex.getMessage(),ex);
							rtnVO[0] = "N";
							rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						// 2013.10.11 [CHM-201326585] MVMT status 변경 logic 추가 (VD-TS-ID - VD-IC-ID) 외 1건
						// 로직 추가 필요
						if ("TS".equals(pstCntrInfo.getMvmtStsCd()) && "ID".equals(mvmtStsCd)) 
						{
							try {
								pstCntrInfo.setMvmtStsCd("IC");
								dbDao.updateMovementVO(pstCntrInfo);
							}
							catch (DAOException e) {
								/***************************************************************
								 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
								 ***************************************************************/
								log.error(e.getMessage(),e);
								rtnVO[0] = "N";
								rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} catch (Exception ex) {
								/***************************************************************
								 * 	실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
								 ***************************************************************/
								log.error(ex.getMessage(),ex);
								rtnVO[0] = "N";
								rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						}

					} else {
						crossItem.setEdiSendLstrmCd("N");    // sendEDIToKOR을 위한 LstrmCd setting
					}
				}

				// 추가 로직 2013.01.14 TN을 EN으로 변경 
				if ("TN".equals(pstCntrInfo.getMvmtStsCd())) { // [CHM-201222197-01]
					String orgLcc = ""; 
					String dstLcc = ""; 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(crrCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							orgLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(pstCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							dstLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try {
						if (!orgLcc.equals(dstLcc)) {            
							pstCntrInfo.setMvmtStsCd("EN");      
							pstCntrInfo.setCreUsrId(userId); 
							dbDao.updateContainer(pstCntrInfo, "2", ""); 
						}
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
				}
				// 추가 로직 2013.01.14 EN을 TN으로 변경 추가 [CHM-201222197-01]						
				if ("EN".equals(pstCntrInfo.getMvmtStsCd())) {
					String orgLcc = ""; 
					String dstLcc = ""; 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(crrCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							orgLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try { 
						String[] lcc = dbDao.getLccRccCode(subStr(pstCntrInfo.getOrgYdCd(), 0, 5)); 
						if (lcc != null && !lcc[2].equals("")) { 
							dstLcc = lcc[2];  
						} 
						
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
					try {
						if (orgLcc.equals(dstLcc)) {             
							pstCntrInfo.setMvmtStsCd("TN");      
							pstCntrInfo.setCreUsrId(userId);     
							dbDao.updateContainer(pstCntrInfo, "2", ""); 
						}
					} catch (DAOException e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} catch (Exception e) { 
						throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e); 
					} 
				}

			} else if ("VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd)){
				if (cntrNoAft.equals(cntrNoBef)) continue;

				/*************************************************************
				 * VL 이면서 Booking No가 없을 경우 아래의 로직을 모두 생략한다 *
				 **************************************************************/
				if (nBkgNoFlg && "VL".equals(mvmtStsCd)) {

					if ("VL".equals(mvmtStsCd)) {
						try {
							if (fmFlag == null || "".equals(fmFlag)) {
								crrCntrInfo.setFcntrFlg("M");
							} else {
								crrCntrInfo.setFcntrFlg(fmFlag);
							}
							crrCntrInfo.setBkgCgoTpCd("P");
							crrCntrInfo.setBkgRcvTermCd("");
							crrCntrInfo.setBlNo("");
							crrCntrInfo.setCnmvLvlNo("");
							crrCntrInfo.setCnmvCycNo(String.valueOf(Integer.parseInt(cycNo) + 1));
							crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
							crrCntrInfo.setCntrSvrId(svrId);
							crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
							crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
							crrCntrInfo.setMvmtInpTpCd(inpType);
							crrCntrInfo.setObCntrFlg("O");
							crrCntrInfo.setOfcCd(ofcCd);
							crrCntrInfo.setCreUsrId(userId);
							crrCntrInfo.setUpdUsrId(userId);
							crrCntrInfo.setUsrNm(userNm);
							crrCntrInfo.setImdtExtFlg("N");
							crrCntrInfo.setPreStsFlg("Y");
							crrCntrInfo.setTrnkVslCd(crrCntrInfo.getCrntVslCd());
							crrCntrInfo.setTrnkSkdVoyNo(crrCntrInfo.getCrntSkdVoyNo());
							crrCntrInfo.setTrnkSkdDirCd(crrCntrInfo.getCrntSkdDirCd());

							if (sameCntr == false) {
								idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
								idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
								crrCntrInfo.setCnmvIdNo(idNo);
								crrCntrInfo.setCnmvSeq(idSeq);
								dbDao.addCtmMovement(crrCntrInfo);
								crossItem.setEdiSendLstrmCd("N");    // sendEDIToKOR을 위한 LstrmCd setting

								// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
								tmpRtnVO = new StringBuffer();
								tmpRtnVO.append(rtnVO[2]);
								tmpRtnVO.append("U");
								rtnVO[2] = tmpRtnVO.toString();
//								rtnVO[2] = rtnVO[2] + "U";
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}

							// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
							tmpRtnVO = new StringBuffer();
							tmpRtnVO.append(rtnVO[2]);
							tmpRtnVO.append("U");
							rtnVO[2] = tmpRtnVO.toString();
//							rtnVO[2] = rtnVO[2] + "U";
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setMstBkgCntrOpUpdate(false);
							crossItem.setFindBkgCntr(true);

						} catch (DAOException e) {
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), e);
						} catch (Exception ex) {
							rtnVO[1] = "Unexpected system error occurred during data processing.["+mvmtStsCd+" Creation error]";
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), ex);
						}
					}
				} else {

					if ("VL".equals(mvmtStsCd)) {
						try {
							if ("S".equals(subStr(vvdInfo.getVslPrePstCd(), 0, 1)) || "T".equals(subStr(vvdInfo.getVslPrePstCd(), 0, 1))) {
								crrCntrInfo.setObCntrFlg("O");
							} else {
								crrCntrInfo.setObCntrFlg("I");
							}
							errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
							if (sameCntr == false) {
								crrCntrInfo.setCnmvIdNo(String.valueOf(Integer.parseInt(idNo) + 1));
								crrCntrInfo.setCnmvSeq(String.valueOf(Integer.parseInt(idSeq) + 1));
								dbDao.addCtmMovement(crrCntrInfo);
								crossItem.setEdiSendLstrmCd("N");   // sendEDIToKOR을 위한 LstrmCd setting
								// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
								tmpRtnVO = new StringBuffer();
								tmpRtnVO.append(rtnVO[2]);
								tmpRtnVO.append("U");
								rtnVO[2] = tmpRtnVO.toString();
//								rtnVO[2] = rtnVO[2] + "U";
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}
							// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
							tmpRtnVO = new StringBuffer();
							tmpRtnVO.append(rtnVO[2]);
							tmpRtnVO.append("U");
							rtnVO[2] = tmpRtnVO.toString();
//							rtnVO[2] = rtnVO[2] + "U";
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setMstBkgCntrOpUpdate(true);
							crossItem.setFindBkgCntr(true);

						} catch (Exception ex) {
							log.error(ex.getMessage(),ex);
							throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
						}

					} else {
						// 다음 배의 존재 여부 판별 필요
						/* Booking V.V.D Order S -> T -> U */
						// vvdInfo
						String vsl = crrCntrInfo.getCrntVslCd();
						String voy = crrCntrInfo.getCrntSkdVoyNo();
						String dir = crrCntrInfo.getCrntSkdDirCd();
						String pol = crrCntrInfo.getPolCd();
						String pod = crrCntrInfo.getPodCd();
						String nxtVd = null;
						String extVd = null;
						try {
							List<NextShipExistsVO> nextShipVo = null;
							nextShipVo = dbDao.getNextShip(bkgNo, vsl, voy, dir, pol, pod);
							if (nextShipVo == null || nextShipVo.size() == 0) {
								rtnVO[0] = "N";
								rtnVO[1] = "Booking vvd does not exist";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							NextShipExistsVO voNxtShip = nextShipVo.get(0);
							nxtVd = voNxtShip.getVslPrePstCd();
							extVd = voNxtShip.getNxtship();
							if (nxtVd == null) {
								rtnVO[0] = "N";
								rtnVO[1] = "Select VVD Code Error";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						} catch (Exception e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+bkgNo+" Booking vvd]").getMessage(), e);
						}

						try {
							if ("VD".equals(mvmtStsCd)) {
								if ("S".equals(subStr(nxtVd, 0, 1))) {
									crrCntrInfo.setObCntrFlg("O");
								} else {
									crrCntrInfo.setObCntrFlg("I");
								}
							} else {
								if (nxtVd.equals("S") || nxtVd.equals("T")) {
									crrCntrInfo.setObCntrFlg("O");
								} else {
									crrCntrInfo.setObCntrFlg("I");
								}
							}
							errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
							if (sameCntr == false) {
								idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
								idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
								crrCntrInfo.setCnmvIdNo(idNo);
								crrCntrInfo.setCnmvSeq(idSeq);
								dbDao.addCtmMovement(crrCntrInfo);
								crossItem.setEdiSendLstrmCd("N");   // sendEDIToKOR을 위한 LstrmCd setting
							}
						} catch (Exception ex) {
							throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
						}

						if ("Y".equals(extVd)) {
							crrCntrInfo.setMvmtStsCd("TS");
						} else {
							try {
								crrCntrInfo.setMvmtCreTpCd("C");
								crrCntrInfo.setCrntSkdDirCd("");
								crrCntrInfo.setCrntSkdVoyNo("");
								crrCntrInfo.setCrntVslCd("");
								if ("Y".equals(bkgCntrInfo.getBbCgoFlg())) {
									// IC add
									errMsg = "Full flag is null [IC]";
									crrCntrInfo.setMvmtStsCd("IC");
									lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
									errMsg = "Unexpected system error occurred during data processing. [IC Creation error]";
									idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
									idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
									crrCntrInfo.setCnmvIdNo(idNo);
									crrCntrInfo.setCnmvSeq(idSeq);
									dbDao.addCtmMovement(crrCntrInfo);
									// ID add
									errMsg = "Full flag is null [ID]";
									crrCntrInfo.setMvmtStsCd("ID");
									lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
									errMsg = "Unexpected system error occurred during data processing. [ID Creation error]";
									idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
									idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
									crrCntrInfo.setCnmvIdNo(idNo);
									crrCntrInfo.setCnmvSeq(idSeq);
									dbDao.addCtmMovement(crrCntrInfo);

									if("SH".equals(mstCntrInfo.getLstmCd())){// CHM-201221934 BB이고 SH인 CNTR이 VD되면  XX처리 하는 것으로 로직 변경
										crrCntrInfo.setMvmtStsCd("XX");
									}else{
										crrCntrInfo.setMvmtStsCd("MT");
									}
									crrCntrInfo.setFcntrFlg("M");

								} else if ("P".equals(bkgCntrInfo.getBkgCgoTpCd()) || "B".equals(bkgCntrInfo.getBkgCgoTpCd()) || ("R".equals(bkgCntrInfo.getBkgCgoTpCd()) && "SH".equals(mstCntrInfo.getLstmCd()))) {
									crrCntrInfo.setMvmtStsCd("MT");

								} else {
									crrCntrInfo.setMvmtStsCd("IC");
								}
							} catch (Exception ex) {
								throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
							}
						}

						try {
							errMsg = "Full flag is null ["+crrCntrInfo.getMvmtStsCd()+"]";
							lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
							if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
							crrCntrInfo.setCnmvLvlNo(lvlCd);
							crrCntrInfo.setMvmtCreTpCd("C");
							crrCntrInfo.setCrntSkdDirCd("");
							crrCntrInfo.setCrntSkdVoyNo("");
							crrCntrInfo.setCrntVslCd("");
							errMsg = "Unexpected system error occurred during data processing. ["+crrCntrInfo.getMvmtStsCd()+" Creation error]";
							if (sameCntr == false) {
								idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
								idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
								crrCntrInfo.setCnmvIdNo(idNo);
								crrCntrInfo.setCnmvSeq(idSeq);
								dbDao.addCtmMovement(crrCntrInfo);

								// BkgCgoTpCd가 R이고 LstmCd가 SH일때 XX생성 (이전sts가 TS일때는 제외)
								if (!"TS".equals(crrCntrInfo.getMvmtStsCd()) && ("R".equals(bkgCntrInfo.getBkgCgoTpCd()) && "SH".equals(mstCntrInfo.getLstmCd()))) {
									crrCntrInfo.setMvmtStsCd("XX");
									crossItem.setEdiSendLstrmCd(mstCntrInfo.getLstmCd());   // sendEDIToKOR을 위한 LstrmCd setting

									crrCntrInfo.setMvmtCreTpCd("C");
									crrCntrInfo.setCntrDispFlg("Y");
									crrCntrInfo.setAciacDivCd("I");
									idNo = String.valueOf(Integer.parseInt(idNo) + 1);
									idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
									crrCntrInfo.setCnmvIdNo(idNo);
									crrCntrInfo.setCnmvSeq(idSeq);

									int rowEffected = dbDao.addCtmMovement(crrCntrInfo);
									if (rowEffected < 1) {
										rtnVO[0] = "N";
										rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
										crossItem.setRtnStr(rtnVO);
										return crossItem;
									}

									crrCntrInfo.setNewFlg("X");    // B: 신조 MT생성 / C: 신조 MT삭제 / X: XX생성 / Y: VL,IC의 XX삭제
									crossItem.setCusCtmMovementVO(crrCntrInfo);
									crossItem.setUpdateMaster(true);
								}
								// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
								tmpRtnVO = new StringBuffer();
								tmpRtnVO.append(rtnVO[2]);
								tmpRtnVO.append("U");
								rtnVO[2] = tmpRtnVO.toString();
//								rtnVO[2] = rtnVO[2] + "U";
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}

							// 2014.04.17 R4J 관련 String을 StringBuffer로 수정해서 사용
							tmpRtnVO = new StringBuffer();
							tmpRtnVO.append(rtnVO[2]);
							tmpRtnVO.append("U");
							rtnVO[2] = tmpRtnVO.toString();
//							rtnVO[2] = rtnVO[2] + "U";
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setMstBkgCntrOpUpdate(true);
							crossItem.setFindBkgCntr(true);
						} catch (Exception ex) {
							throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
						}
					}
				}

			} else if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
				if (cntrNoAft.equals(cntrNoBef)) continue;

				try {
					pstCntrInfo = dbDao.searchMovementStatusMst(cntrNoAft, evntDt);
					String prevSts = pstCntrInfo.getMvmtStsCd();
					if ("N".equals(crrCntrInfo.getFcntrFlg()) || "M".equals(crrCntrInfo.getFcntrFlg())) {
						bkgNo = "";
						crrCntrInfo.setBkgNo("");
						crrCntrInfo.setBkgKnt("0");
					} else if ("Y".equals(crrCntrInfo.getFcntrFlg()) || "F".equals(crrCntrInfo.getFcntrFlg())) {
						String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
						bkgNo = returnValues[0];
					} else if ("MT".equals(prevSts) || (("EN".equals(prevSts) || "TN".equals(prevSts)) && "N".equals(pstCntrInfo.getFcntrFlg()))) {
						bkgNo = "";
						crrCntrInfo.setBkgNo("");
						crrCntrInfo.setBkgKnt("0");
					} else {
						if ("C".equals(subStr(prevSts, 0, 1))) {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");
						} else if (("EN".equals(prevSts) || "TN".equals(prevSts)) && "Y".equals(pstCntrInfo.getFcntrFlg()) && "".equals(bkgNo)) {
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
						}
						crrCntrInfo.setBkgNo(bkgNo);
					}
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Last movement(Auto)]").getMessage(), ex);
				}

				/* CNTR FULL/EMPTY FLAG SETTING */
				if (crrCntrInfo.getFcntrFlg() == null || crrCntrInfo.getFcntrFlg().equals("")) {
					crrCntrInfo.setFcntrFlg(fmFlag);
				}
				try {
					errMsg = "Unexpected system error occurred during data processing. [Full/Empty flag]";
					String[] mvmtSeq = dbDao.getCtmMvmtSeq(mvmtStsCd, cgoTp);

					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					crrCntrInfo.setCntrSvrId(svrId);
					crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
					crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
					if (crrCntrInfo.getFcntrFlg() == null || crrCntrInfo.getFcntrFlg().equals("")) {
						crrCntrInfo.setFcntrFlg("M");
					}
					crrCntrInfo.setMvmtInpTpCd(inpType);
					if (crrCntrInfo.getObCntrFlg() == null || crrCntrInfo.getObCntrFlg().equals("")) {
						crrCntrInfo.setObCntrFlg(pstCntrInfo.getObCntrFlg());
					}
					crrCntrInfo.setOfcCd(ofcCd);
					errMsg = "Unexpected system error occurred during data processing. [Movement data setting]";
					if ("MT".equals(pstCntrInfo.getMvmtStsCd()) ||  (bkgNo == null || "".equals(bkgNo) || "null".equals(bkgNo))) {
						crrCntrInfo.setTrnkSkdDirCd("");
						crrCntrInfo.setTrnkSkdVoyNo("");
						crrCntrInfo.setTrnkVslCd("");
						crrCntrInfo.setBkgCgoTpCd("");
						crrCntrInfo.setBkgKnt("0");
						crrCntrInfo.setBlNo("");
					} else {
						crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
						crrCntrInfo.setBlNo(bkgInfo.getBlNo());
						crrCntrInfo.setCntrActCd(vvdInfo.getAgmtCtyCd());
						crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
						crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
						crrCntrInfo.setCntrHngrRckFlg(vvdInfo.getCntrHngrRckCd());
						crrCntrInfo.setCntrRfubFlg(vvdInfo.getRfubFlg());
						crrCntrInfo.setImdtExtFlg(vvdInfo.getImdtExtFlg());
					}

					crrCntrInfo.setUpdUsrId(userId);
					crrCntrInfo.setUsrNm(user_Nm);

					if (mvmtSeq == null) {
						if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
							crrCntrInfo.setFcntrFlg("M");
						crrCntrInfo.setCnmvLvlNo("0");
					} else {
						crrCntrInfo.setFcntrFlg(mvmtSeq[0]);
						crrCntrInfo.setCnmvLvlNo(mvmtSeq[1]);
					}

					errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
					if (sameCntr == false) {
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						crrCntrInfo.setCnmvIdNo(idNo);
						crrCntrInfo.setCnmvSeq(idSeq);
						dbDao.addCtmMovement(crrCntrInfo);

						crossItem.setCusCtmMovementVO(crrCntrInfo);
						crossItem.setUpdateMaster(true);
					}

					crossItem.setCusCtmMovementVO(crrCntrInfo);
					if ("MT".equals(pstCntrInfo.getMvmtStsCd()) || (("EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd())) && "".equals(pstCntrInfo.getBkgNo()))) {
						crossItem.setMstBkgCntrOpUpdate(false);
					} else {
						crossItem.setMstBkgCntrOpUpdate(true);
					}
					crossItem.setFindBkgCntr(true);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
				}

			} else {
				rtnVO[0] = "N";
				rtnVO[1] = "Not exist status code";
				crossItem.setRtnStr(rtnVO);
				return crossItem;
			}
			cntrNoBef = cntrNoAft;
			crossItem.setBkgNo(bkgNo);
			if (bkgInfo != null) {
				vslOld = bkgInfo.getVslCd();
				voyOld = bkgInfo.getSkdVoyNo();
				dirOld = bkgInfo.getSkdDirCd();
			}
		}
		crossItem.setRtnStr(rtnVO);
		return crossItem;
	}

	/**
	 * BKG
	 * PRE VL UPDATE.<br>
	 *
	 * @param CusCtmMovementVO ctmMovementVO
	 * @throws EventException
	 */
	public void modifyMovementFromBkgForPreVL(CusCtmMovementVO ctmMovementVO) throws EventException {
		try {
			dbDao.modifyMovementFromBkgForPreVLToMvmt(ctmMovementVO);
			dbDao.modifyMovementFromBkgForPreVLToEdi(ctmMovementVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - modifyMovementFromBkgForPreVL] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - modifyMovementFromBkgForPreVL] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 동일한 Container No, CycNo를 가지는 모든 Booking List를 반환한다.
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @param String cnmvYr
	 * @return String[]
	 * @throws EventException
	 */
	public String[] getBookingListByCycle(String cntrNo, String cycNo, String cnmvYr) throws EventException {
		try {
			return dbDao.getBookingListByCycle(cntrNo, cycNo, cnmvYr);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getBookingListByCycle] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getBookingListByCycle] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * CGM
	 * XX Create.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws EventException
	 * @return int
	 */
	public int modifyMovementFromCgmForCreXX(CusCtmMovementVO cusCtmMovementVO) throws EventException {
		try {
			return dbDao.modifyMovementFromCgmForCreXX(cusCtmMovementVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - modifyMovementFromCgmForCreXX] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - modifyMovementFromCgmForCreXX] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Event Date가 변경된 Movement 내역을 저장.<br>
	 *
	 * @param AutoCreStsListVO[] autoCreStsListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @return List<SceActRcvIfVO>
	 */
	public List<SceActRcvIfVO> manageAutoCreSts(AutoCreStsListVO[] autoCreStsListVOs,SignOnUserAccount account) throws EventException {
		try {
			List<AutoCreStsListVO> updateVoList = new ArrayList<AutoCreStsListVO>();
			List<SceActRcvIfVO> sceVOs = new ArrayList<SceActRcvIfVO>();
			for ( int i=0; i<autoCreStsListVOs .length; i++ ) {
				autoCreStsListVOs[i].setUpdUsrId(account.getUsr_id());
				autoCreStsListVOs[i].setOfcCd(account.getOfc_cd());
				autoCreStsListVOs[i].setUsrNm(account.getUsr_nm());
				log.info("CNTR NO :::" + autoCreStsListVOs[i].getCntrNo());
				log.info("CNMV NO :::" + autoCreStsListVOs[i].getCnmvId());

				CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
				cusCtmMovementVO.setCntrNo(autoCreStsListVOs[i].getCntrNo());
				cusCtmMovementVO.setCnmvYr(autoCreStsListVOs[i].getCnmvYr());
				cusCtmMovementVO.setCnmvIdNo(autoCreStsListVOs[i].getCnmvId());
				cusCtmMovementVO.setCnmvEvntDt(autoCreStsListVOs[i].getTarDate());
				cusCtmMovementVO.setOfcCd(autoCreStsListVOs[i].getOfcCd());
				cusCtmMovementVO.setOrgYdCd(autoCreStsListVOs[i].getYdCd());
				cusCtmMovementVO.setCnmvRmk(autoCreStsListVOs[i].getCnmvRmk());
				cusCtmMovementVO.setUsrNm(autoCreStsListVOs[i].getUsrNm());
				cusCtmMovementVO.setUpdUsrId(autoCreStsListVOs[i].getUpdUsrId());
				cusCtmMovementVO.setCnmvCorrRsn(autoCreStsListVOs[i].getCnmvCorrRsn());
				cusCtmMovementVO.setAtchFileSavId(autoCreStsListVOs[i].getAtchFileSavId());

				String maxHisSeq = dbDao.searchMaxMovementHisSeq(cusCtmMovementVO);
				CusCtmMovementVO prevMovementVO = dbDao.searchMovementInfo(cusCtmMovementVO);
				ArrayList<String> columNames = new ArrayList<String>();
				if (cusCtmMovementVO.getCnmvEvntDt() != null && !cusCtmMovementVO.getCnmvEvntDt().equals(prevMovementVO.getCnmvEvntDt())) { columNames.add("CNMV_EVNT_DT"); }
				if (cusCtmMovementVO.getOfcCd() != null && !cusCtmMovementVO.getOfcCd().equals(prevMovementVO.getOfcCd())) { columNames.add("OFC_CD"); }

				// 2016.05.17 김상현 [CHM-201641462] Correction reason 컨테이너 list 기능 보완 (no highlighted)
				//  - 변경 사항이 있는 수정 data만 history 남김.
				if (columNames.size() > 0) {
					for (int j=0; j<columNames.size(); j++) {
						CtmMovementHisColVO ctmMovementHisColVO = new CtmMovementHisColVO();
						ctmMovementHisColVO.setCntrNo(cusCtmMovementVO.getCntrNo());
						ctmMovementHisColVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
						ctmMovementHisColVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
						ctmMovementHisColVO.setCnmvHisSeq(maxHisSeq);
						ctmMovementHisColVO.setCnmvHisColSeq(String.valueOf(j + 1));
						ctmMovementHisColVO.setCnmvHisColNm(columNames.get(j));
						ctmMovementHisColVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
						dbDao.addCtmMvmtMnlHisCol(ctmMovementHisColVO);
					}

					cusCtmMovementVO.setCnmvHisSeq(maxHisSeq);
					cusCtmMovementVO.setModiTp("U");
					cusCtmMovementVO.setDatDivFlg("F");
					cusCtmMovementVO.setInpDivFlg("A");
					dbDao.addPrevCtmMvmtMnlHis(cusCtmMovementVO);
					cusCtmMovementVO.setDatDivFlg("T");
					dbDao.addAutoStsUpdateCtmMvmtMnlHis(cusCtmMovementVO);
				}

				updateVoList.add(autoCreStsListVOs[i]);
				//2012.10.25 나상보 - Movement Event Date 변경시에 SEC로 Data가 넘어가도록 해당 Operation 호출을 추가
				// 2013.09.11 [CHM-201325902] VVD 변경시에도 SCE로 I/F 하도록 로직 수정
				String tmpVvdCd = autoCreStsListVOs[i].getCrntVslCd() + autoCreStsListVOs[i].getCrntSkdVoyNo() + autoCreStsListVOs[i].getCrntSkdDirCd();
				
				if ((("F".equals(autoCreStsListVOs[i].getFcntrFlg()) || "Y".equals(autoCreStsListVOs[i].getFcntrFlg())) || "F".equals(autoCreStsListVOs[i].getBkgCgoTpCd()) || "R".equals(autoCreStsListVOs[i].getBkgCgoTpCd())) && autoCreStsListVOs[i].getBkgNo() != null && !"".equals(autoCreStsListVOs[i].getBkgNo())) {
					// 2013.04.17 [CHM-201324017-01] Event Date외 Movement Status, Yard Code도 변경시에는 I/F하도록 수정
					String evntDtFlg = dbDao.checkEvntDt(autoCreStsListVOs[i].getTarDate(), autoCreStsListVOs[i].getCntrNo(), autoCreStsListVOs[i].getCnmvYr(), autoCreStsListVOs[i].getCnmvId(), autoCreStsListVOs[i].getMvmtStsCd(), autoCreStsListVOs[i].getYdCd(), tmpVvdCd);
					
					if("F".equals(evntDtFlg)){
						SceActRcvIfVO sceVO =new SceActRcvIfVO();
						
						sceVO.setCntrNo(autoCreStsListVOs[i].getCntrNo());
						sceVO.setBkgNo(autoCreStsListVOs[i].getBkgNo());
						sceVO.setNodCd(autoCreStsListVOs[i].getYdCd());
						sceVO.setActStsMapgCd(autoCreStsListVOs[i].getStsCd());
						sceVO.setActDt(autoCreStsListVOs[i].getTarDate());
						sceVO.setEdiMsgTpCd(autoCreStsListVOs[i].getMvmtEdiMsgTpId());
						sceVO.setCreTpCd(autoCreStsListVOs[i].getMvmtCreTpCd());
						sceVO.setCreUsrId(account.getUsr_id());
						sceVO.setVndrSeq(autoCreStsListVOs[i].getVndrSeq());
						sceVO.setVslCd(autoCreStsListVOs[i].getCrntVslCd());
						sceVO.setSkdVoyNo(autoCreStsListVOs[i].getCrntSkdVoyNo());
						sceVO.setSkdDirCd(autoCreStsListVOs[i].getCrntSkdDirCd());
						sceVO.setBndVskdSeqCd(autoCreStsListVOs[i].getIbflag());

						sceVO.setCnmvYr(autoCreStsListVOs[i].getCnmvYr());
						sceVO.setCnmvIdNo(autoCreStsListVOs[i].getCnmvId());
						sceVO.setCnmvSeq(autoCreStsListVOs[i].getCnmvSeq());
						sceVO.setCnmvSplitNo(autoCreStsListVOs[i].getCnmvSplitNo());
						sceVO.setCnmvCycNo(autoCreStsListVOs[i].getCnmvCycNo());
						//2011.03.25 나상보 Immedate Exit Flag 추가
						sceVO.setImdtExtFlg(autoCreStsListVOs[i].getImdtExtFlg());

						sceVOs.add(sceVO);
					}
				}
			}
			if (updateVoList.size() > 0) {
				dbDao.addAutoMvmtEventDateHistory(updateVoList);
				dbDao.modifygetAutoCreStsS(updateVoList);
			}
			return sceVOs;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 지정한 subString수보다 전체글자수가 작으면 전체글자수만큼 subString 반환<BR>
	 *
	 * @param String str
	 * @param int beginIndex
	 * @param int endIndex
	 * @return String
	 */
	private String subStr(String str, int beginIndex, int endIndex) {
		str = ((str == null || "".equals(str.trim())) ? "" : str.trim());
		int firstIndex = str.length() < beginIndex ? str.length() : beginIndex;
		int lastIndex = str.length() < endIndex ? str.length() : endIndex;
		return str.substring(firstIndex, lastIndex);
	}

	/**
	 * 이전 Sts와 현재 Sta에 따른 errMsg 분류 (autoCreation에서 사용)
	 * @param preSts
	 * @param currSts
	 * @param yardCdEq
	 * @param fullEmptyFlag
	 * @param cusCtmMovementVO
	 * @return String
	 */
	private String[] getErrMsg(String preSts, String currSts, String yardCdEq, String fullEmptyFlag, CusCtmMovementVO cusCtmMovementVO) throws EventException {
		preSts = (preSts == null) ? "" : preSts.trim();
		currSts = (currSts == null) ? "" : currSts.trim();
		yardCdEq = (yardCdEq == null) ? "" : yardCdEq.trim();
		String errMsg[] = new String[2];
		boolean checkVgmUpdate = false; // VGM data update 필요 여부.

		// 이전 Sts와 현재 Sts에 따른 errMsg 분류
		if ("CE".equals(preSts)) {
			if ("CD".equals(currSts) || "MT".equals(currSts) || "OC".equals(currSts) || "OP".equals(currSts) || "TN".equals(currSts)) {
				errMsg[0] = "Please create 'CI' status and retry";
			}
		} else if ("CI".equals(preSts)) {
			if ("MT".equals(currSts) || "OP".equals(currSts) || "TN".equals(currSts)) {
				errMsg[0] = "Please create 'CD' status and retry";
			}
		} else if ("CP".equals(preSts)) {
			if ("CD".equals(currSts) || "CI".equals(currSts)) {
				errMsg[0] = "Please create 'CO' status and retry";
			} else if ("EN".equals(currSts) || "OC".equals(currSts)) {
				errMsg[0] = "Please create 'MT' or 'CO' status and retry";
			}
		} else if ("EN".equals(preSts)) {
			if ("TN".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'EN/TN' status at same yard";
				checkVgmUpdate = true;
			}
		} else if ("IC".equals(preSts)) {
			if ("IC".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'IC' status at same yard";
				checkVgmUpdate = true;
			} else if ("OC".equals(currSts) || "OP".equals(currSts)) {
				errMsg[0] = "Please create 'ID' and 'MT' status and retry";
			}
		} else if ("ID".equals(preSts)) {
			if ("ID".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'ID' status at same yard";
				checkVgmUpdate = true;
			}
		} else if ("MT".equals(preSts)) {
			if ("MT".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'MT' status at same yard";
				checkVgmUpdate = true;
			} else if ("VL".equals(currSts) && ("F".equals(fullEmptyFlag) || "Y".equals(fullEmptyFlag))) {
				// 이전이 MT이고, 현재가 VL(F)일때 (Break Bulk일 경우는 상위 로직에서 제외됨)
				errMsg[0] = "Please create 'OP/OC' status and retry";
			}
		} else if ("OC".equals(preSts)) {
			if ("OC".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'OC' status at same yard";
				checkVgmUpdate = true;
			}
		} else if ("OP".equals(preSts)) {
			if ("CD".equals(currSts) || "CE".equals(currSts) || "CI".equals(currSts) || "CO".equals(currSts) || "CP".equals(currSts)) {
				// 이전 단계가 OP이고 Domestic status 입력시 정상 처리 하도록 변경 - CHM-201538334
//				errMsg = "Please create 'MT' status and retry";
				errMsg[0] = "NONE";
			} else if ("OP".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'OP' status at same yard";
				checkVgmUpdate = true;
			}
		} else if ("TN".equals(preSts)) {
			if ("TN".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'EN/TN' status at same yard";
				checkVgmUpdate = true;
			}
		} else if ("TS".equals(preSts)) {
			if ("TS".equals(currSts) && "S".equals(yardCdEq)) {
				errMsg[0] = "Already 'TS' status at same yard";
				checkVgmUpdate = true;
			}
		}

		if ("".equals(errMsg)) {
			errMsg[0] = "Movement creation error [auto creation] [" + preSts + "],[" + currSts + "]";
		}

		// 2016.07.07 김상현 [CHM-201642556] 동일한 MVMT에서 VGM이 나중에 EDI 수신되어 오류처리되는 경우, VGM 소급 update logic 추가
		//  - 동일한 Movement에 대해서 VGM 데이터가 없을 경우, EDI 데이터 중에 VGM 데이터만 업데이트 처리
		if (checkVgmUpdate) {
			String message = checkVgmData(cusCtmMovementVO);
			if (message != null) {
//				errMsg[0] = message;
				errMsg[0] = errMsg[0] != null ? errMsg[0].concat(message) : message;
				errMsg[1] = "VGM";
			}
		}

		return errMsg;
	}
	
	/**
	 * VVD의 POL / POD LCC를 조회한다<br>
	 *
	 * @param String bkgNo
	 * @param String cntrId
	 * @return String[]
	 */
	public String[] searchPolPodLccCd(String bkgNo, String cntrId) throws EventException { 
		try {
			return dbDao.searchPolPodLccCd(bkgNo, cntrId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * EES_CTM_0463<br>
	 * Modified event date history Inquiry 리스트를 조회한다<br>
	 *
	 * @param EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO
	 * @return List<EventDateUpdateHistoryParmVO>
	 * @exception EventException
	 */
	public List<EventDateUpdateHistoryParmVO> searchEventDateUpdateHistory(EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO) throws EventException {
		try {
			return dbDao.searchEventDateUpdateHistory(eventDateUpdateHistoryParmVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEventDateUpdateHistory] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEventDateUpdateHistory] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}	
	
	/**
	 * VL/VD Yard Cd 정보를 조회한다.<br>
	 *
	 * @param CorrectionVLVDListVO correctionVLVDListVO
	 * @return List<CorrectionVLVDListVO>
	 * @throws EventException
	 */
	public List<CorrectionVLVDListVO> searchVLVDYardCode(CorrectionVLVDListVO correctionVLVDListVO) throws EventException {
		try {
			return dbDao.searchVLVDYardCode(correctionVLVDListVO);
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - searchCorrectionVLVDListByVVD] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - searchCorrectionVLVDListByVVD] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Last BKG_NO update 처리
	 * @param lastBkgNo
	 * @param lastBlNo
	 * @param cusCtmMovementVO
	 * @throws EventException
	 */
	public void modifyLastBkgNo(String lastBkgNo, String lastBlNo, CusCtmMovementVO cusCtmMovementVO) throws EventException {
		try {
			dbDao.modifyLastBkgNo(lastBkgNo, lastBlNo, cusCtmMovementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * VGM data를 업데이트 해야 하는지 아닌지 check.
	 * @param cusCtmMovementVO
	 * @return String
	 * @throws EventException
	 */
	public String checkVgmData(CusCtmMovementVO cusCtmMovementVO) throws EventException {
		String message		= null;
		String mvmtStsCdChk = "OP,OC,TS,VL,VD,TN,EN";
		String mvmtStsCd	= cusCtmMovementVO.getMvmtStsCd();
		String vgmWgtUtCd	= cusCtmMovementVO.getVgmWgtUtCd();
		String vgmWgtQty	= cusCtmMovementVO.getVgmWgtQty();
		try {
			//VGM Update 조건 확인 2016.08.17
			if(mvmtStsCd != null && !"".equals(mvmtStsCd) && mvmtStsCdChk.contains(mvmtStsCd)){
				
				// VGM_WGT_UT_CD(Unit단위), VGM_WGT_QTY 있는지 확인 2016.08.17
				if(vgmWgtUtCd != null && !"".equals(vgmWgtUtCd) && vgmWgtQty != null && !"".equals(vgmWgtQty)){
					
					// 이전 VGM data 조회
					CusCtmMovementVO prevMovementVO = dbDao.searchPreVgmData(cusCtmMovementVO.getCntrNo());
					
					if(prevMovementVO != null && (!vgmWgtUtCd.equals(prevMovementVO.getVgmWgtUtCd()) || !vgmWgtQty.equals(prevMovementVO.getVgmWgtQty()))) {
//						message = "Only VGM updated into previous movement by system.";
						
						// 현의 MVMT_STS_CD 가 TN, EN 이면
						if (("TN".equals(mvmtStsCd) || "EN".equals(mvmtStsCd))){
							// 이전 의  OB_CNTR_FLG 가 Y 인것
							if(prevMovementVO.getObCntrFlg() != null && "Y".equals(prevMovementVO.getObCntrFlg())){
								message = "(VGM Updated)";
							}
						}else{
							message = "(VGM Updated)";
						}
					}
				}
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return message;
	}

	/**
	 * VGM data update 처리 로직
	 * @param cusCtmMovementVOs
	 * @throws EventException
	 */
	public void updateVgmData(CusCtmMovementVO cusCtmMovementVOs[]) throws EventException {
		try {
			if (cusCtmMovementVOs.length > 0) {
				dbDao.updatePreVgmData(cusCtmMovementVOs[0]);

				if ("OC".equals(cusCtmMovementVOs[0].getMvmtStsCd()) || "VL".equals(cusCtmMovementVOs[0].getMvmtStsCd())) {
					CrossItemVO item = null;
					BLDocumentationCMBC blDocumentationCMBC = new BLDocumentationCMBCImpl();
					for (int i=0; i<cusCtmMovementVOs.length; i++) {
						item = new CrossItemVO();
						item.setCusCtmMovementVO(cusCtmMovementVOs[i]);
						blDocumentationCMBC.updateVGMForOnlyMVMT(item);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 조회된 마지막 시간을 저장해 놓기 위해 system date 조회.
	 * @return String
	 * @throws EventException
	 */
	public String searchSystemDate() throws EventException {
		String systemDateStr = null;

		try {
			systemDateStr = dbDao.searchSystemDate();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return systemDateStr;
	}

	/**
	 * 마지막 retrieve 이후에 수정된 데이터가 있는데 확인
	 * @param cntrNo
	 * @param lastRetrieveDate
	 * @return int
	 * @throws EventException
	 */
	public int searchModifiedDataCount(String cntrNo, String lastRetrieveDate) throws EventException {
		int rowCount = 0;

		try {
			rowCount = dbDao.searchModifiedDataCount(cntrNo, lastRetrieveDate);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return rowCount;
	}
	
	
	/**
	 * OP, VL이 삭제로 booking 정보를 초기화 시 해당 BKG_NO가 정상적으로 입력된 이전 movement가 존재하는지 조회
	 * @param bkgNo
	 * @param cntrNo
	 * @return int
	 * @throws EventException
	 */
	public int searchSamBkgPriorMvmtKnt(String bkgNo, String cntrNo) throws EventException {
		int rtnVal = 999; // Booking 데이터 초기화 방지를 위해 0 보다 큰 임의의 수 입력

		try {
			rtnVal = dbDao.searchSamBkgPriorMvmtKnt(bkgNo, cntrNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return rtnVal;
	}
	
	/**
	 * BKG 에 CNTR 이 Attach 안 된 상태에서 OP 가 들어온 경우 MVMT 상태는 TN 이 됩니다.
	 * 이후, BKG 에 CNTR 가 Attach 될 경우, TN 상태를 OP 로 변경해 줌 ( BKG 에서만 사용하는 메소드임 )
	 * @param String bkgNo 
	 * @param String cntrNo
	 * @param String usrId
	 * @return CrossItemVO
	 * @throws EventException
	 */	
	public CrossItemVO modifyMvmtStsByAtchCntrToBkg(String bkgNo, String cntrNo, String usrId) throws EventException {
		CrossItemVO item = new CrossItemVO();
		
		try {
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// LOGIC-1. Search MVMT 1ST, 2ND Info.
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++			
			// 최종 / 최종 2번째 MVMT 정보 조회 ( MST Container 정보를 갱신하기 위한 정보 )
			CusCtmMovementVO ctmVO = dbDao.searchN1stN2ndMvmtStsInfo(cntrNo);
			
			// 조회결과가 존재하지 않거나, MVMT 최종 상태가 MT -> TN 이 아닐경우 종료합니다.
			if (ctmVO == null || !"MT".equals(ctmVO.getN2ndMvmtStsCd()) || !"TN".equals(ctmVO.getMvmtStsCd())) return item;
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// LOGIC-2. Update Movement Status
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// TN -> OP 로 변경되기 위해서는 MT Cycle No + 1 이 되어야 함.
			int opCnmvCycNo = Integer.parseInt(ctmVO.getN2ndCnmvCycNo()) + 1;
			
			// OP 정보 설정
			ctmVO.setCnmvCycNo(String.valueOf(opCnmvCycNo));
			ctmVO.setMvmtStsCd("OP");
			ctmVO.setFcntrFlg("N");
			ctmVO.setObCntrFlg("Y");
			ctmVO.setCnmvLvlNo("1");
			
			// Search BKG Info.
			List<BkgBookingInfoVO> bkgInfoList = dbDao.searchBkgBookingList(bkgNo);
			if (bkgInfoList == null || bkgInfoList.size() == 0) return item;
			
			// BKG 정보 설정
			ctmVO.setTrnkSkdDirCd(bkgInfoList.get(0).getSkdDirCd());
			ctmVO.setTrnkSkdVoyNo(bkgInfoList.get(0).getSkdVoyNo());
			ctmVO.setTrnkVslCd(bkgInfoList.get(0).getVslCd());
			ctmVO.setBlNo(bkgInfoList.get(0).getBlNo());
			ctmVO.setBkgNo(bkgInfoList.get(0).getBkgNo());
			ctmVO.setBkgCgoTpCd(bkgInfoList.get(0).getBkgCgoTpCd());
			ctmVO.setCreUsrId(usrId);

			dbDao.updateContainer(ctmVO, "1", "1");
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// LOGIC-3. Call MST ( for updating container info )
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// MST_CONTAINER 갱신될 CTM 정보 --------------------------------
			// MST 모듈 호출하기 위한 파라미터VO
			item.setCusCtmMovementVO(ctmVO);
			item.setUpdateMaster(true);
			
			ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
			mstCommand.updateCntrMasterByMvmtBasic(item);
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			// BKG 모듈에서 MVMT 상태변경에 따른 후처리에 필요한 값 설정
			item.setAttchCd("C");
			item.setMstBkgCntrOpUpdate(true);
			ctmVO.setBkgNo(bkgNo);
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} 
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		
		return item;
	}
}

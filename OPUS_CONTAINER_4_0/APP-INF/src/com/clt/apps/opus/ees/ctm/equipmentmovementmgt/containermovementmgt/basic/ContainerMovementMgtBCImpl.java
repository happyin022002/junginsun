/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerMovementMgtBCImpl.java
 *@FileTitle : CNTR History Update
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CheckBookingVO;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CntrMvmtSeqInfoVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgContainerLastVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgVVDInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTListbyDMGEvntDateVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MultiBkgNoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.NextShipExistsVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-EquipmentMovementMgt Business Logic Command Interface<br>
 *
 * @author
 * @see Ees_ctm_0404EventResponse, ContainerMovementMgtBC DAO class reference
 * @see Ees_ctm_0406EventResponse, ContainerMovementMgtBC DAO class reference
 * @see Ees_ctm_0409EventResponse, ContainerMovementMgtBC DAO class reference
 * @see Ees_ctm_0422EventResponse, ContainerMovementMgtBC DAO class reference
 * @see Ees_ctm_0456EventResponse, ContainerMovementMgtBC DAO class reference
 * @since J2EE 1.5
 * 2009.4.24
*/
public class ContainerMovementMgtBCImpl extends BasicCommandSupport implements ContainerMovementMgtBC {

	// Database Access Object
	private transient ContainerMovementMgtDBDAO dbDao = null;
	private transient EmptyReleaseRedeliveryOrderMgtDBDAO dbDao2 = null;
	private transient ContainerMovementMgtForGateNewDBDAO dbDao3 = null;

	/**
	 * creating ContainerMovementMgtBCImpl Object
	 * creating ContainerMovementMgtDBDAO
	 */
	public ContainerMovementMgtBCImpl() {
		dbDao = new ContainerMovementMgtDBDAO();
		dbDao2 = new EmptyReleaseRedeliveryOrderMgtDBDAO(); 
		dbDao3 = new ContainerMovementMgtForGateNewDBDAO();
	}

	/**
	 * Container Movement History Retrieve Button Event
	 * retrieving container movement information
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
	 * Container Movement History Retrieve Button Event
	 * retrieving booking information of Container movement information
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
	 * Container Movement History Save Button Event
	 * updating container movement information 
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
		//String sendEdiSts = "";
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
			// checking lstFlgLine from top for searching last row
			nVO.setBkgVO(null);
			for (int i=0; i < cusCtmMovementVOs.length; i++) {
				if ("1".equals(mvmtBookingInfoVOs[i].getLstFlg()) || "X".equals(mvmtBookingInfoVOs[i].getLstFlg())) {
					lstFlgLine = i;
					break;
				} else if ("O".equals(mvmtBookingInfoVOs[i].getLstFlg())) {
					// calling Booking in case of changing first created OC
					nVO.setBkgVO(cusCtmMovementVOs[i]);
				}
			}

			String cntrNo = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getCntrNo();
			//boolean sendEdiFlg = false;
			String lstStsCd = "";
			//CusCtmMovementVO ediSendVO = null;
			nVO.setFinalCfm("0");
			nVO.setFinalCfm("E");

			// checking Final Confirm in Booking in case of OP/VL
			// Rollback even if deleted in case of FinalConfirm
			if (lstFlgLine >= 0) {
				lstStsCd = mvmtBookingInfoVOs[lstFlgLine].getMvmtStsCd();
				String cmdFlg = mvmtBookingInfoVOs[lstFlgLine].getIbflag();
				String lstFlg = mvmtBookingInfoVOs[lstFlgLine].getLstFlg();
				String bkgTp = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getBkgCgoTpCd();
				String bkgNo = mvmtBookingInfoVOs[lstFlgLine].getBkgNo();
				String cycNo = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getCnmvCycNo();
				//String areaCd = (mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getOrgYdCd() == null ? "" : subStr(mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getOrgYdCd().trim(), 0, 2));
				String cnmvYr = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getCnmvYr();
				String[] finalCfm = null;

				// send EDI when lstStsCd is VL/VD and first two chars of OrgYard is KR
//				if ("KR".equals(areaCd) && ("VL".equals(lstStsCd) || "VD".equals(lstStsCd)) && ("1".equals(lstFlg) || "X".equals(lstFlg))) {
//					sendEdiFlg = true;
//					sendEdiSts = lstStsCd;
//					if ("VD".equals(lstStsCd)) {
//						ediSendVO = dbDao.getPrevCntrInfo(cntrNo, "2");
//					} else {
//						ediSendVO = dbDao.getPrevCntrInfo(cntrNo, "1");
//					}
//				}
				
				if ("D".equals(cmdFlg) && ("1".equals(lstFlg) || "X".equals(lstFlg))) {
					if ("VL".equals(lstStsCd) && "P".equals(bkgTp)) {
						// checking Final Confirm in Booking
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
						// without bkgNo
						if (bkgNo == null || "".equals(bkgNo)) {
							// setting X in FinalCfm (committing in SC without calling BKG module)
							nVO.setFinalCfm("X");

						} else {
							List<BkgContainerLastVO> bkgCntr = null;
							BkgContainerLastVO   bkgCntrInfo = null;
							String[] crntFinalCfm = null;
							String crntBkgNo = "";
							String crntCycNo = "";
							String crntCnmvYr = "";
							
							bkgCntr = dbDao.getBkgContainerLastInfo(cntrNo, null);
							
							if (bkgCntr != null && bkgCntr.size()>0) {
								bkgCntrInfo = bkgCntr.get(0);
								crntBkgNo = bkgCntrInfo.getBkgNo();
								crntCycNo = bkgCntrInfo.getCnmvCycNo();
								crntCnmvYr = bkgCntrInfo.getCnmvYr();
								
								if (crntCycNo == null || Integer.parseInt(crntCycNo) < Integer.parseInt(cycNo)) {
									crntBkgNo = "";
									crntCycNo = "";
									crntCnmvYr = "";
								}
							}
							
							// checking Final Confirm in Booking
							finalCfm = dbDao.checkFinalConfirm(bkgNo);
							crntFinalCfm = dbDao.checkFinalConfirm(crntBkgNo);
							if (finalCfm != null && "Y".equals(finalCfm[0])) {
								// checking container existence in BKG_CONTAINER
								String bkgCntrExist = dbDao.checkBkgCntrExist(cntrNo, bkgNo, cycNo);
								if (bkgCntrExist != null && !"".equals(bkgCntrExist)) {
									// setting 1 in FinalCfm(RollBack after stopping all actions)
									nVO.setFinalCfm("1");
								} else if ("N".equals(crntFinalCfm[0])) {
									nVO.setFinalCfm("O");
									nVO.setCaFlg(crntFinalCfm[1]);
									nVO.setBkgNo(crntBkgNo);
									nVO.setCntrNo(cntrNo);
									nVO.setCycNo(crntCycNo);
									nVO.setCnmvYr(crntCnmvYr);
								} else {
									// setting 1 in FinalCfm(committing in SC without calling BKG module)
									nVO.setFinalCfm("X");
								}
							} else if (crntFinalCfm == null) {
								nVO.setFinalCfm("X");
							} else if ("Y".equals(crntFinalCfm[0])) {
								// checking container existence in BKG_CONTAINER
								String bkgCntrExist = dbDao.checkBkgCntrExist(cntrNo, bkgNo, cycNo);
								if (bkgCntrExist != null && !"".equals(bkgCntrExist)) {
									if (dbDao.checkBooking(bkgNo) == null) {
										nVO.setFinalCfm("X");
									} else {
										// setting 1 in FinalCfm(RollBack after stopping all actions)
										nVO.setFinalCfm("1");
									}
								} else {
									nVO.setFinalCfm("X");
								}
							} else {
								nVO.setFinalCfm("O");
								nVO.setCaFlg(finalCfm[1]);
								nVO.setBkgNo(crntBkgNo);
								nVO.setCntrNo(cntrNo);
								nVO.setCycNo(crntCycNo);
								nVO.setCnmvYr(crntCnmvYr);
							}
						}
					} else if ("VD".equals(lstStsCd)||"MT".equals(lstStsCd)){//[CLT-121108469-01]
						// CNTR dettach from O/B Bkg. And VD delete
						// in case of CNTR is VD/MT status(MT BKG) and attached into O/B without OP/OC. 
						List<BkgContainerLastVO> bkgCntr = null;
						BkgContainerLastVO   bkgCntrInfo = null;

						bkgCntr = dbDao.getBkgContainerLastInfo(cntrNo, null);
						
						if(bkgCntr != null && bkgCntr.size() != 0){
							bkgCntrInfo = bkgCntr.get(0);
							if("9999".equals(bkgCntrInfo.getCnmvCycNo()) ){
								// FinalCfm setting to "2" (all process stop and RollBack at SC)
								nVO.setFinalCfm("2");
								nVO.setBkgNo(bkgCntrInfo.getBkgNo());
							}
						}	
					}
				}
				lstStsCd = mvmtBookingInfoVOs[cusCtmMovementVOs.length -1].getMvmtStsCd();
			}

			for (int i = cusCtmMovementVOs.length - 1; i >= 0 ; i--) {
				mstVO = new CusCtmMovementVO();
				cusCtmMovementVOs[i].setCreUsrId(account.getUsr_id());
				cusCtmMovementVOs[i].setUpdUsrId(account.getUsr_id());
				cusCtmMovementVOs[i].setUsrNm(account.getUsr_nm());
				cusCtmMovementVOs[i].setOfcCd(account.getOfc_cd());

				if ("I".equals(cusCtmMovementVOs[i].getIbflag())) {
					log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
							  "\n신규 항목 추가 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt() +
							  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					if (cusCtmMovementVOs[i].getVvdCd() != null && !"".equals(cusCtmMovementVOs[i].getVvdCd()) && cusCtmMovementVOs[i].getVvdCd().trim().length() >= 8) {
						cusCtmMovementVOs[i].setTrnkVslCd(subStr(cusCtmMovementVOs[i].getVvdCd(), 0, 4));
						cusCtmMovementVOs[i].setTrnkSkdVoyNo(subStr(cusCtmMovementVOs[i].getVvdCd(), 4, 8));
						cusCtmMovementVOs[i].setTrnkSkdDirCd(subStr(cusCtmMovementVOs[i].getVvdCd(), 8, 9));
					}
					cusCtmMovementVOs[i].setCtrtOfcCtyCd("HHO");
					cusCtmMovementVOs[i].setMvmtInpTpCd("MAN");
					String lvlCd = "";
					
					if(dbDao.getCNTRMovSeqRSQL(cusCtmMovementVOs[i].getBkgCgoTpCd(), cusCtmMovementVOs[i].getMvmtStsCd()) != null) {
						lvlCd=dbDao.getCNTRMovSeqRSQL(cusCtmMovementVOs[i].getBkgCgoTpCd(), cusCtmMovementVOs[i].getMvmtStsCd()).getCnmvLvlNo();
				    } else {
				    	if ("EN".equals(cusCtmMovementVOs[i].getMvmtStsCd()) || "TN".equals(cusCtmMovementVOs[i].getMvmtStsCd())) {
				    		lvlCd="0";
				    	}
				    }
					cusCtmMovementVOs[i].setCnmvLvlNo(lvlCd);
					
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
					nVO.setUpdateTrs(true);
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
					
					

				} else if ("U".equals(cusCtmMovementVOs[i].getIbflag())) {
					log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
							  "\n기존 항목  수정 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt() +
							  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					updateVoList.add(cusCtmMovementVOs[i]);
					nVO.setUpdateTrs(true);
					//2012.10.25 나상보 - Movement Event Date 변경시에 SEC로 Data가 넘어가도록 해당 Operation 호출을 추가
					
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

				} else if ("D".equals(cusCtmMovementVOs[i].getIbflag())) {
					log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
							  "\n기존 항목  삭제 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt() +
							  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
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
				mstVO.setCntrDmgFlg(cusCtmMovementVOs[i].getCntrDmgFlg());
				mstVO.setDmgFlgDt(cusCtmMovementVOs[i].getDmgFlgDt());
				mstVO.setDmgUnflgDt(cusCtmMovementVOs[i].getDmgUnflgDt());
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
					//dbDao.addMvmtEventDateHistory(updateVoList);
					dbDao.modifyCtmMovementVOS(updateVoList);
				}
			
				if (deleteVoList.size() > 0) {
					dbDao.modifyCtmMovementBefDelVOS(deleteVoList);
				}
			}


			if (insertVoList.size() > 0) {
				log.info("INSERT LIST :" + insertVoList.size());
				dbDao.addCtmMovementVOS(insertVoList);
			}


			if (deleteVoList.size() > 0) {
				dbDao.insertCtmMovementVOS(deleteVoList);
				dbDao.removeCtmMovementVOS(deleteVoList);
			}

			// getting last status. Param = CNTR_NO
			String lastStatus = dbDao.getCntrStatus(cntrNo);
			log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
					  "\n 마지막 Status  :" + lastStatus +
					  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

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

				// setting I as Active/Inactive Code in case lastStatus = XX
				if ("XX".equals(lastStatus)) {
					mstVO.setAciacDivCd("I");
				}

				mstVO.setNewFlg("");     // B: creating new MT / C: deleting new  MT / X: creating XX  / Y: deleting XX in VL,IC

//				if (deleteVoList.size() > 1) {
//					// last row's MvmtStsCd
//					String lstSts = deleteVoList.get(deleteVoList.size() - 1).getMvmtStsCd();
//					// auto creating last row's flag
//					String lstAf = deleteVoList.get(deleteVoList.size() - 1).getMvmtCreTpCd();
//					if ("XX".equals(lstSts) && "C".equals(lstAf)) {
//						// previous row's MvmtStsCd
//						String preSts = deleteVoList.get(deleteVoList.size() - 2).getMvmtStsCd();
//						// auto creating previous row's flag
//						String preAf = deleteVoList.get(deleteVoList.size() - 2).getMvmtCreTpCd();
//						if ("ID".equals(preSts)) {
//							mstVO.setNewFlg("Y");    // B: creating new MT / C: deleting new  MT / X: creating XX  / Y: deleting XX in VL,IC
//						} else if (deleteVoList.size() > 2 && "MT".equals(preSts) && "C".equals(preAf)) {
//							
//							String ppvSts = deleteVoList.get(deleteVoList.size() - 3).getMvmtStsCd();
//							if ("VD".equals(ppvSts)) {
//								mstVO.setNewFlg("Y");   // B: creating new MT / C: deleting new  MT / X: creating XX  / Y: deleting XX in VL,IC
//							}
//						}
//					}
//				}
				if (deleteVoList.size() > 1) {
					// last row's MvmtStsCd
					String lstSts = deleteVoList.get(deleteVoList.size() - 2).getMvmtStsCd();
					// auto creating last row's flag
					String lstAf = deleteVoList.get(deleteVoList.size() - 2).getMvmtCreTpCd();
					if ("XX".equals(lstSts) && "C".equals(lstAf)) {
						// previous row's MvmtStsCd
						String preSts = deleteVoList.get(deleteVoList.size() - 1).getMvmtStsCd();
						// auto creating previous row's flag
						String preAf = deleteVoList.get(deleteVoList.size() - 1).getMvmtCreTpCd();
						if ("ID".equals(preSts)) {
							mstVO.setNewFlg("Y");    // B: creating new MT / C: deleting new  MT / X: creating XX  / Y: deleting XX in VL,IC
						} else if (deleteVoList.size() > 2 && "MT".equals(preSts) && "C".equals(preAf)) {
							String ppvSts = deleteVoList.get(deleteVoList.size() - 3).getMvmtStsCd();
							if ("VD".equals(ppvSts)) {
								mstVO.setNewFlg("Y");    // B: creating new MT / C: deleting new  MT / X: creating XX  / Y: deleting XX in VL,IC
							}
						}
					}
				}
				mstVO.setCrntVslCd(db.getCrntVslCd());
				mstVO.setCrntSkdVoyNo(db.getCrntSkdVoyNo());
				mstVO.setCrntSkdDirCd(db.getCrntSkdDirCd());
				mstVO.setCntrId(db.getCrntVslCd() + db.getCrntSkdVoyNo() + db.getCrntSkdDirCd());
				mstVO.setPreStsFlg(db.getPreStsFlg());
				db = null;

				/* Start : 2014.08.05 Add Script TN/EN-> MT를 OP-OC로 수정시 BKG No.에 CNTR Attach */
				//String cmdFlg = mvmtBookingInfoVOs[lstFlgLine].getIbflag();
				//if("U".equals(cmdFlg) && "OC".equals(lstStsCd)){
				if(lstFlgLine >= 0) {
					if(cusCtmMovementVOs[lstFlgLine].getMvmtStsCd().equals("OP") || cusCtmMovementVOs[lstFlgLine].getMvmtStsCd().equals("OC")){
	
				      //boolean findBkgCntr = false;
				      List<BkgContainerLastVO> bkgCntr = null;
				      
				      bkgCntr = dbDao.getBkgContainerLastInfo(cusCtmMovementVOs[lstFlgLine].getCntrNo(), cusCtmMovementVOs[lstFlgLine].getBkgNo());
				      if (bkgCntr == null || bkgCntr.size() == 0) {
				    	  nVO.setFindBkgCntr(false);
				      } else
				    	  nVO.setFindBkgCntr(true);
				    }
				}
				/* End : 2014.08.05 Add Script TN/EN-> MT를 OP-OC로 수정시 BKG No.에 CNTR Attach */
				
				nVO.setCusCtmMovementVO(mstVO);
				nVO.setUpdateMaster(true);

			} else if ("MT".equals(mvmtBookingInfoVOs[0].getMvmtStsCd()) && "1".equals(mvmtBookingInfoVOs[0].getCnmvCycNo()) && "1".equals(mvmtBookingInfoVOs[0].getCnmvSeq()) ) {
				MVMTBookingInfoVO vo = mvmtBookingInfoVOs[0];

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

				mstVO.setNewFlg("C");    // B: creating new MT / C: deleting new  MT / X: creating XX  / Y: deleting XX in VL,IC
				vo = null;

				nVO.setCusCtmMovementVO(mstVO);
				nVO.setUpdateMaster(true);

			} else {
				throw new EventException(new ErrorHandler("There is no delete data.").getMessage());
			}

			//if (sendEdiFlg) sendEdiToKor(ediSendVO,"D"+ sendEdiSts, ediSendVO.getLstmCd());

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
	 * Container Status Change
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @exception EventException
	 */
	public CrossItemVO modifyCNTRStatus(CusCtmMovementVO[] cusCtmMovementVOs, SignOnUserAccount account) throws EventException {
		CrossItemVO nVO = new CrossItemVO();
		String[] rtnVO = new String[3];
		String user_Id;
		log.info("STATUS CHANGE 시작 ::: " + cusCtmMovementVOs.length);
		//String sendEdiSts = "";
		try {
			List<CusCtmMovementVO> updateVoList = new ArrayList<CusCtmMovementVO>();

			CusCtmMovementVO mstVO = new CusCtmMovementVO();
			
			nVO.setBkgVO(null);

			for (int i = cusCtmMovementVOs.length - 1; i >= 0 ; i--) {
				List<MVMTListbyDMGEvntDateVO> listVO = new ArrayList<MVMTListbyDMGEvntDateVO>();
				
				if (cusCtmMovementVOs[i] == null) {
					nVO.setRtnStr(rtnVO);
					return nVO;
				}
				
				if (cusCtmMovementVOs[0].getCreUsrId() != null && !cusCtmMovementVOs[0].getCreUsrId().equals("")) {
					user_Id = cusCtmMovementVOs[0].getCreUsrId();
				} else if (account != null) {
					user_Id = account.getUsr_id();
				} else {
					user_Id = "ETCUSER";
				}
				
				String damageFlg = "";
				String cnmvEvntDt = "";
				String userId = cusCtmMovementVOs[i].getUpdUsrId();
				String ofcCd = "";
				
				if (userId == null || userId.equals("")) {
					userId = user_Id;
				}
				
				if ("ESVCUSER".equals(userId)) {
					cusCtmMovementVOs[i].setMvmtInpTpCd("SPP");
					nVO.setMnrCallYN("SPP");
				} else if ("EDIUSER".equals(userId)) {
					cusCtmMovementVOs[i].setMvmtInpTpCd("EDI");
					nVO.setMnrCallYN("EDI");
				} else {
					if ("COD".equals(cusCtmMovementVOs[i].getMvmtEdiMsgTpId()) || "322".equals(cusCtmMovementVOs[i].getMvmtEdiMsgTpId())) {
						cusCtmMovementVOs[i].setMvmtInpTpCd("EDI");
						nVO.setMnrCallYN("EDI");
					} else if ("SPP".equals(cusCtmMovementVOs[i].getMvmtEdiMsgTpId())) {
						cusCtmMovementVOs[i].setMvmtInpTpCd("SPP");
						nVO.setMnrCallYN("SPP");
					} else {
						cusCtmMovementVOs[i].setMvmtInpTpCd("MNR");
						nVO.setMnrCallYN("MNR");
					}
				}
				
				if ("ESVCUSER".equals(userId) || "EDIUSER".equals(userId)) {
					ofcCd = dbDao.getOfcCdByYard(cusCtmMovementVOs[i].getOrgYdCd());
					if (ofcCd.equals("E")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Office select error!";
						nVO.setRtnStr(rtnVO);
						return nVO;
					}
				} else {
					ofcCd = account.getOfc_cd();
				}
				
				if ("Y".equals(cusCtmMovementVOs[i].getCntrDmgFlg())) {
					cnmvEvntDt = cusCtmMovementVOs[i].getDmgFlgDt();
				} else {
					cnmvEvntDt = cusCtmMovementVOs[i].getDmgUnflgDt();
				}

				log.debug("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
						  "\n기존 항목  수정 시작  : " + cusCtmMovementVOs[i].getCnmvEvntDt() +
						  "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrDamageFlg(cntrNumber, EventDate, EventYard)" +
						  "\n===============================================================\n");
				damageFlg = dbDao3.getCntrDamageFlg(cusCtmMovementVOs[i].getCntrNo(),cnmvEvntDt, cusCtmMovementVOs[i].getOrgYdCd());
				
				if (damageFlg == null || damageFlg.equals("")) {
					rtnVO[0] = "N";
					rtnVO[1] = "Container does not exist in "+cusCtmMovementVOs[i].getOrgYdCd()+ " on "+cnmvEvntDt+".";
					nVO.setRtnStr(rtnVO);
					return nVO;
				} else {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.checkMVMTListbyDMGEventDate(CntrNo, evntdate, evntYard, cntrDmgFlg, LastFlg:N)" +
							  "\n===============================================================\n");
					listVO = dbDao.checkMVMTListbyDMGEventDate(cusCtmMovementVOs[i].getCntrNo(), cnmvEvntDt, cusCtmMovementVOs[i].getOrgYdCd(), cusCtmMovementVOs[i].getCntrDmgFlg(), "N");
					
					if (listVO == null || listVO.size() == 0) {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.checkMVMTListbyDMGEventDate(CntrNo, evntdate, evntYard, cntrDmgFlg, LastFlg:NN)" +
								  "\n===============================================================\n");
						listVO = dbDao.checkMVMTListbyDMGEventDate(cusCtmMovementVOs[i].getCntrNo(), cnmvEvntDt, cusCtmMovementVOs[i].getOrgYdCd(), cusCtmMovementVOs[i].getCntrDmgFlg(), "NN");
					}
				}
				
				if (listVO == null || listVO.size() == 0) {
					rtnVO[0] = "N";
					rtnVO[1] = "Container does not exist in "+cusCtmMovementVOs[i].getOrgYdCd()+ " on "+cnmvEvntDt+".";
					nVO.setRtnStr(rtnVO);
					return nVO;
				}
				
				for (int j = 0; j <= listVO.size() - 1 ; j++) {
					mstVO = new CusCtmMovementVO();
					
					mstVO.setCntrNo(cusCtmMovementVOs[i].getCntrNo());
					mstVO.setCntrTpszCd(listVO.get(j).getCntrTpszCd());
					mstVO.setUpdUsrId(userId);
					mstVO.setOfcCd(ofcCd);
					mstVO.setCnmvYr(listVO.get(j).getCnmvYr());
					mstVO.setCnmvIdNo(listVO.get(j).getCnmvIdNo());
					mstVO.setOrgYdCd(listVO.get(j).getOrgYdCd());
					mstVO.setMvmtStsCd(listVO.get(j).getMvmtStsCd());
					if (cusCtmMovementVOs[i].getCnmvRmk() == null || "".equals(cusCtmMovementVOs[i].getCnmvRmk())) {
						mstVO.setCnmvRmk(cusCtmMovementVOs[i].getMvmtInpTpCd()+": DM Change");
					} else {
						mstVO.setCnmvRmk(cusCtmMovementVOs[i].getMvmtInpTpCd()+": DM Change / "+cusCtmMovementVOs[i].getCnmvRmk());
					}
					mstVO.setCntrDmgFlg(cusCtmMovementVOs[i].getCntrDmgFlg());
					mstVO.setNewFlg("");
					
					log.info(mstVO.getCntrDmgFlg());
					log.info(listVO.get(0).getDmg());
					
					if ("Y".equals(mstVO.getCntrDmgFlg())) {
//						if ("1".equals(listVO.get(0).getDmg()) && listVO.size() == 1) {
//							mstVO.setDmgFlgDt(listVO.get(0).getDmgFlgDt());
//						} else {
							mstVO.setDmgFlgDt(cusCtmMovementVOs[i].getDmgFlgDt());
//							nVO.setMnrCallYN("1"); // only Flagging
//						}
						mstVO.setDmgUnflgDt("");
						
						if (j > 0 && listVO.size() != 1) {
							if (!listVO.get(0).getOrgYdCd().equals(listVO.get(j).getOrgYdCd()) || !listVO.get(0).getCntrEvntDt().equals(listVO.get(j).getCntrEvntDt())) {
								if (!mstVO.getCntrDmgFlg().equals(listVO.get(j).getCntrDmgFlg())) {
									mstVO.setCntrDmgFlg(listVO.get(j).getCntrDmgFlg());
									if (listVO.get(j).getDmgUnflgDt() == null || "".equals(listVO.get(j).getDmgUnflgDt())) {
										mstVO.setDmgUnflgDt(listVO.get(j).getCntrEvntDt());
									} else {
										mstVO.setDmgUnflgDt(listVO.get(j).getDmgUnflgDt());
									}
//									nVO.setMnrCallYN("2"); // Flagging & Unflagging by Flagging
								}
							}
						}
					} else {
						if ("0".equals(listVO.get(0).getDmg())) {
							mstVO.setDmgFlgDt(listVO.get(0).getCntrEvntDt());
//							nVO.setMnrCallYN("2"); // Flagging & Unflagging by Unflagging
						} else {
							mstVO.setDmgFlgDt(listVO.get(j).getDmgFlgDt());
//							nVO.setMnrCallYN("1"); // only Unflagging
						}
						mstVO.setDmgUnflgDt(cusCtmMovementVOs[i].getDmgUnflgDt());
						
						if (j > 0 && listVO.size() != 1) {			
							if (!listVO.get(0).getOrgYdCd().equals(listVO.get(j).getOrgYdCd()) || !listVO.get(0).getCntrEvntDt().equals(listVO.get(j).getCntrEvntDt())) {
								mstVO.setCntrDmgFlg(listVO.get(j).getCntrDmgFlg());
								mstVO.setDmgFlgDt(listVO.get(j).getNextEvntDt());
								mstVO.setDmgUnflgDt(listVO.get(j).getDmgUnflgDt());
								
								if (listVO.get(j).getCntrDmgFlg().equals("Y")) {
									mstVO.setDmgUnflgDt("");
//									nVO.setMnrCallYN("3"); // Unflagging & Flagging by unflagging
								} else {
									if (listVO.get(j).getNextEvntDt()==null || "".equals(listVO.get(j).getNextEvntDt())) {
										mstVO.setDmgFlgDt("");
										mstVO.setDmgUnflgDt("");
//										nVO.setMnrCallYN("1"); // only Unflagging
									} else {
//										nVO.setMnrCallYN("4"); // Unflagging & Flagging & Unflagging by unflagging
									}
								}
							}
						}
					}
					
					log.info("\n\n===============================================================" +
							  "\n DmgFlg : " + mstVO.getCntrDmgFlg() + " | MVMT STS CD : " + mstVO.getMvmtStsCd() +
							  "\n===============================================================\n");
					
//					if ("Y".equals(mstVO.getCntrDmgFlg()) && "OP".equals(mstVO.getMvmtStsCd())) {
//						rtnVO[0] = "N";
//						rtnVO[1] = "Can't update OP status with damage flag as 'Y'!";
//						nVO.setRtnStr(rtnVO);
//						return nVO;
//					} 
					
					rtnVO[0] = "X";
					rtnVO[1] = "STATUS CHANGE";
					
					updateVoList.add(mstVO);
				}
			}
			
			nVO.setCusCtmMovementVOs(updateVoList);

			// 0 : STATUS. 1 : COUNT
			if (updateVoList.size() > 0 ) {
				dbDao.modifyCtmStatusVOS(updateVoList);
			}

		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - modifyCNTRStatus] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - modifyCNTRStatus] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		nVO.setRtnStr(rtnVO);
		return nVO;
	}

	/**
	 * DMG History Update
	 *
	 * @param CrossItemVO crossItemVO
	 * @param SignOnUserAccount account
	 * @return CrossItemVO
	 * @exception EventException
	 */
	public CrossItemVO modifyDMGHistory(CrossItemVO crossItemVO, SignOnUserAccount account) throws EventException {
		CrossItemVO nVO = new CrossItemVO();
		String[] rtnVO = new String[3];
		
		log.info("DMG History Update 시작 ::: ");
		//String sendEdiSts = "";
		try {
			List<CusCtmMovementVO> cusCtmMovementVOs = crossItemVO.getCusCtmMovementVOs();
			CusCtmMovementVO mnrVO = new CusCtmMovementVO();
			List<CusCtmMovementVO> cgmVo = new ArrayList<CusCtmMovementVO>();
			String[] dmgHis = new String[7];
			
			com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC mnrCommand =
				new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl();
			com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO customMnrEqStsVO =
				new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO();
			
			nVO.setBkgVO(null);

			for (int i = 0 ; i < cusCtmMovementVOs.size() ; i++) {
				mnrVO = new CusCtmMovementVO();
				
				String cntrNo = cusCtmMovementVOs.get(i).getCntrNo();
				String cntrTpSz = cusCtmMovementVOs.get(i).getCntrTpszCd();
				String cntrDmgFlg = cusCtmMovementVOs.get(i).getCntrDmgFlg();
				String dmgFlagDt = cusCtmMovementVOs.get(i).getDmgFlgDt();
				String dmgUnflagDt = cusCtmMovementVOs.get(i).getDmgUnflgDt();
				String evntYd = cusCtmMovementVOs.get(i).getOrgYdCd();
				String mvmtSts = cusCtmMovementVOs.get(i).getMvmtStsCd();
				String evntDt = "";
				String MvmtInpTpCd = crossItemVO.getMnrCallYN();
				String userId = cusCtmMovementVOs.get(i).getUpdUsrId();
				String ofcCd = "";
				
				if ("ESVCUSER".equals(userId) || "EDIUSER".equals(userId)) {
					ofcCd = dbDao.getOfcCdByYard(evntYd);
					if (ofcCd.equals("E")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Office select error!";
						nVO.setRtnStr(rtnVO);
						return nVO;
					}
				} else {
					ofcCd = account.getOfc_cd();
				}
				
				if(i==0) {
					if ("EDI".equals(MvmtInpTpCd)) {
						if ("Y".equals(cntrDmgFlg)) {
							cntrDmgFlg = "1";
							evntDt = dmgFlagDt;
						} else {
							cntrDmgFlg = "0";
							evntDt = dmgUnflagDt;
						}
						
						mnrVO.setCntrNo(cntrNo);
						mnrVO.setCntrTpszCd(cntrTpSz);
						mnrVO.setOrgYdCd(evntYd);
						mnrVO.setCntrDmgFlg(cntrDmgFlg);
						mnrVO.setCnmvEvntDt(evntDt);
						mnrVO.setMvmtStsCd(mvmtSts);
						mnrVO.setCnmvRmk("V");
						mnrVO.setUpdUsrId(userId);
						mnrVO.setOfcCd(ofcCd);
						
						log.info("\n\n===============================================================" +
								  "\n MNR 호출()" +
								  "\n===============================================================\n");
						
						/* mandatory input value
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  customMnrEqStsVO.setMnrFlgInpDt(***);
						 *  customMnrEqStsVO.setMnrFlgRmk(***);
						 *  customMnrEqStsVO.setMnrFlgInpTpCd(***);
						 *  matching table :  MNR_EQ_STS
						 */
						
						customMnrEqStsVO.setEqKndCd("U");    // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(mnrVO.getCntrNo());    // Container No
						customMnrEqStsVO.setEqTpszCd(mnrVO.getCntrTpszCd());    // Type/Size
						customMnrEqStsVO.setMnrDmgFlg(mnrVO.getCntrDmgFlg());    // flaging : '1', unflaging '0'
						customMnrEqStsVO.setMnrDmgFlgYdCd(mnrVO.getOrgYdCd());    // yard code occurring damage flagging/unflagging
						customMnrEqStsVO.setMnrFlgInpDt(mnrVO.getCnmvEvntDt());
						
						customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+mnrVO.getMvmtStsCd()+")");
						customMnrEqStsVO.setMnrFlgInpTpCd("V"); //V:Movement, M:Manual

						if (customMnrEqStsVO.getEqNo() != null && !"".equals(customMnrEqStsVO.getEqNo()) && customMnrEqStsVO.getMnrFlgInpDt() != null && !"".equals(customMnrEqStsVO.getMnrFlgInpDt())) {
							log.info("\n\n===============================================================" +
									  "\n customMnrEqStsVO.getEqNo : " + customMnrEqStsVO.getEqNo() +
									  "\n customMnrEqStsVO.getEqTpszCd : " + customMnrEqStsVO.getEqTpszCd() +
									  "\n customMnrEqStsVO.getMnrDmgFlg : " + customMnrEqStsVO.getMnrDmgFlg() +
									  "\n customMnrEqStsVO.getMnrDmgFlgYdCd : " + customMnrEqStsVO.getMnrDmgFlgYdCd() +
									  "\n customMnrEqStsVO.getMnrFlgInpDt : " + customMnrEqStsVO.getMnrFlgInpDt() +
									  "\n customMnrEqStsVO.getMnrFlgRmk : " + customMnrEqStsVO.getMnrFlgRmk() +
									  "\n customMnrEqStsVO.getMnrFlgInpTpCd : " + customMnrEqStsVO.getMnrFlgInpTpCd() +
									  "\n===============================================================\n");

							if(account == null || "".equals(account)){
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
								String today = formatter.format(new java.util.Date());
								account = new SignOnUserAccount(mnrVO.getUpdUsrId(),null,null,null,null,null,null,null, mnrVO.getUpdUsrId(), today , mnrVO.getUpdUsrId(), today, mnrVO.getOfcCd(), null, null, null, null, null, null, null, null, null);									
							}
							
							mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
						}

						cgmVo.add(mnrVO);
					} else {
						if ("Y".equals(cntrDmgFlg)) {
							cntrDmgFlg = "1";
							evntDt = dmgFlagDt;
						} else {
							cntrDmgFlg = "0";
							evntDt = dmgUnflagDt;
						}
						
						mnrVO.setCntrNo(cntrNo);
						mnrVO.setCntrTpszCd(cntrTpSz);
						mnrVO.setOrgYdCd(evntYd);
						mnrVO.setCntrDmgFlg(cntrDmgFlg);
						mnrVO.setCnmvEvntDt(evntDt);
						mnrVO.setMvmtStsCd(mvmtSts);
						mnrVO.setCnmvRmk("V");
						mnrVO.setUpdUsrId(userId);
						mnrVO.setOfcCd(ofcCd);

						cgmVo.add(mnrVO);
					}
				} else { // if (i>0)
					String preCntrDmgFlg = cusCtmMovementVOs.get(i-1).getCntrDmgFlg();
					
					if (!(cntrDmgFlg).equals(preCntrDmgFlg)) {
						if ("Y".equals(cntrDmgFlg)) {
							cntrDmgFlg = "1";
							evntDt = dmgFlagDt;
						} else {
							cntrDmgFlg = "0";
							evntDt = dmgUnflagDt;
						}
						
						mnrVO.setCntrNo(cntrNo);
						mnrVO.setCntrTpszCd(cntrTpSz);
						mnrVO.setOrgYdCd(evntYd);
						mnrVO.setCntrDmgFlg(cntrDmgFlg);
						mnrVO.setCnmvEvntDt(evntDt);
						mnrVO.setMvmtStsCd(mvmtSts);
						mnrVO.setUpdUsrId(userId);
						mnrVO.setOfcCd(ofcCd);
						
						if ("MNR".equals(MvmtInpTpCd)) {
							mnrVO.setCnmvRmk("N");
						} else {
							mnrVO.setCnmvRmk("V");
						}
						
						log.info("\n\n===============================================================" +
								  "\n MNR 호출()" +
								  "\n===============================================================\n");
						
						/* mandatory input value
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  customMnrEqStsVO.setMnrFlgInpDt(***);
						 *  customMnrEqStsVO.setMnrFlgRmk(***);
						 *  customMnrEqStsVO.setMnrFlgInpTpCd(***);
						 *  matching table :  MNR_EQ_STS
						 */
						
						customMnrEqStsVO.setEqKndCd("U");    // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(mnrVO.getCntrNo());    // Container No
						customMnrEqStsVO.setEqTpszCd(mnrVO.getCntrTpszCd());    // Type/Size
						customMnrEqStsVO.setMnrDmgFlg(mnrVO.getCntrDmgFlg());    // flaging : '1', unflaging '0'
						customMnrEqStsVO.setMnrDmgFlgYdCd(mnrVO.getOrgYdCd());    // yard code occurring damage flagging/unflagging
						customMnrEqStsVO.setMnrFlgInpDt(mnrVO.getCnmvEvntDt());
						
						if ("V".equals(mnrVO.getCnmvRmk())) {
							customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+mnrVO.getMvmtStsCd()+")");
							customMnrEqStsVO.setMnrFlgInpTpCd("V"); //V:Movement, M:Manual
						} else if ("N".equals(mnrVO.getCnmvRmk())) {
							customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+mnrVO.getMvmtStsCd()+")");
							customMnrEqStsVO.setMnrFlgInpTpCd("M"); //V:Movement, M:Manual
						}

						if (customMnrEqStsVO.getEqNo() != null && !"".equals(customMnrEqStsVO.getEqNo()) && customMnrEqStsVO.getMnrFlgInpDt() != null && !"".equals(customMnrEqStsVO.getMnrFlgInpDt())) {
							log.info("\n\n===============================================================" +
									  "\n customMnrEqStsVO.getEqNo : " + customMnrEqStsVO.getEqNo() +
									  "\n customMnrEqStsVO.getEqTpszCd : " + customMnrEqStsVO.getEqTpszCd() +
									  "\n customMnrEqStsVO.getMnrDmgFlg : " + customMnrEqStsVO.getMnrDmgFlg() +
									  "\n customMnrEqStsVO.getMnrDmgFlgYdCd : " + customMnrEqStsVO.getMnrDmgFlgYdCd() +
									  "\n customMnrEqStsVO.getMnrFlgInpDt : " + customMnrEqStsVO.getMnrFlgInpDt() +
									  "\n customMnrEqStsVO.getMnrFlgRmk : " + customMnrEqStsVO.getMnrFlgRmk() +
									  "\n customMnrEqStsVO.getMnrFlgInpTpCd : " + customMnrEqStsVO.getMnrFlgInpTpCd() +
									  "\n===============================================================\n");

							if(account == null || "".equals(account)){
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
								String today = formatter.format(new java.util.Date());
								account = new SignOnUserAccount(mnrVO.getUpdUsrId(),null,null,null,null,null,null,null, mnrVO.getUpdUsrId(), today , mnrVO.getUpdUsrId(), today, mnrVO.getOfcCd(), null, null, null, null, null, null, null, null, null);									
							}
							
							mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
						}

						cgmVo.add(mnrVO);
					}
				}
			}
			
			if (cgmVo.size() > 0) {
				int k = cgmVo.size()-1;
				for (int i=0; i <= k; i++) {
					
					log.debug("\n\n===============================================================" +
							  "\n dbDao.checkDMGHistory(cntrNumber, evntDt, cntrDmgFlg)" +
							  cusCtmMovementVOs.get(0).getCntrNo() +
							  cgmVo.get(k).getCnmvEvntDt() +
							  cgmVo.get(k).getCntrDmgFlg() +
							  "\n===============================================================\n");
					dmgHis = dbDao.checkDMGHistory(cusCtmMovementVOs.get(0).getCntrNo(), cgmVo.get(k).getCnmvEvntDt(), cgmVo.get(k).getCntrDmgFlg(), k);
					//dmgHis[0] = EQ_NO
					//dmgHis[1] = MNR_STS_FLG
					//dmgHis[2] = MNR_FLG_YD_CD
					//dmgHis[3] = MNR_FLG_INP_DT
					//dmgHis[4] = MNR_FLG_RMK
					
					if (dmgHis != null && !"".equals(dmgHis) && !dmgHis[1].equals(cgmVo.get(k).getCntrDmgFlg()) && !dmgHis[3].equals(cgmVo.get(k).getCnmvEvntDt())) {
						mnrVO = new CusCtmMovementVO();
						mnrVO.setCntrNo(dmgHis[0]);
						mnrVO.setCntrTpszCd(cusCtmMovementVOs.get(0).getCntrTpszCd());
						mnrVO.setOrgYdCd(dmgHis[2]);
						mnrVO.setCnmvEvntDt(dmgHis[3]);
						mnrVO.setCnmvRmk(dmgHis[4]);
						mnrVO.setOfcCd(dmgHis[5]);
						mnrVO.setUpdUsrId(dmgHis[6]);
						
						if ("Y".equals(dmgHis[1])) {
							mnrVO.setCntrDmgFlg("1");
						} else {
							mnrVO.setCntrDmgFlg("0");
						}
						
						log.info("\n\n===============================================================" +
								  "\n MNR 호출()" +
								  "\n===============================================================\n");
						
						/* mandatory input value
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  customMnrEqStsVO.setMnrFlgInpDt(***);
						 *  customMnrEqStsVO.setMnrFlgRmk(***);
						 *  customMnrEqStsVO.setMnrFlgInpTpCd(***);
						 *  matching table :  MNR_EQ_STS
						 */
						
						customMnrEqStsVO.setEqKndCd("U");    // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(mnrVO.getCntrNo());    // Container No
						customMnrEqStsVO.setEqTpszCd(mnrVO.getCntrTpszCd());    // Type/Size
						customMnrEqStsVO.setMnrDmgFlg(mnrVO.getCntrDmgFlg());    // flaging : '1', unflaging '0'
						customMnrEqStsVO.setMnrDmgFlgYdCd(mnrVO.getOrgYdCd());    // yard code occurring damage flagging/unflagging
						customMnrEqStsVO.setMnrFlgInpDt(mnrVO.getCnmvEvntDt());
						
						if ("V".equals(mnrVO.getCnmvRmk())) {
							customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+mnrVO.getMvmtStsCd()+")");
							customMnrEqStsVO.setMnrFlgInpTpCd("V"); //V:Movement, M:Manual
						} else if ("N".equals(mnrVO.getCnmvRmk())) {
							customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+mnrVO.getMvmtStsCd()+")");
							customMnrEqStsVO.setMnrFlgInpTpCd("M"); //V:Movement, M:Manual
						} else {
							customMnrEqStsVO.setMnrFlgRmk(mnrVO.getCnmvRmk());
							customMnrEqStsVO.setMnrFlgInpTpCd("M"); //V:Movement, M:Manual
						}

						if (customMnrEqStsVO.getEqNo() != null && !"".equals(customMnrEqStsVO.getEqNo())) {
							log.info("\n\n===============================================================" +
									  "\n customMnrEqStsVO.getEqNo : " + customMnrEqStsVO.getEqNo() +
									  "\n customMnrEqStsVO.getEqTpszCd : " + customMnrEqStsVO.getEqTpszCd() +
									  "\n customMnrEqStsVO.getMnrDmgFlg : " + customMnrEqStsVO.getMnrDmgFlg() +
									  "\n customMnrEqStsVO.getMnrDmgFlgYdCd : " + customMnrEqStsVO.getMnrDmgFlgYdCd() +
									  "\n customMnrEqStsVO.getMnrFlgInpDt : " + customMnrEqStsVO.getMnrFlgInpDt() +
									  "\n customMnrEqStsVO.getMnrFlgRmk : " + customMnrEqStsVO.getMnrFlgRmk() +
									  "\n customMnrEqStsVO.getMnrFlgInpTpCd : " + customMnrEqStsVO.getMnrFlgInpTpCd() +
									  "\n===============================================================\n");

							if(account == null || "".equals(account)){
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
								String today = formatter.format(new java.util.Date());
								account = new SignOnUserAccount(mnrVO.getUpdUsrId(),null,null,null,null,null,null,null, mnrVO.getUpdUsrId(), today , mnrVO.getUpdUsrId(), today, mnrVO.getOfcCd(), null, null, null, null, null, null, null, null, null);									
							}
							
							mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
						}

						cgmVo.add(mnrVO);
						
						if (k != 0 || !"N".equals(dmgHis[3])) {
							k++;
						}
					} else {
						// break
					}
				}
			}			

			rtnVO[0] = "X";
			rtnVO[1] = "STATUS CHANGE";
		
			nVO.setCusCtmMovementVOs(cgmVo);

		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - modifyDMGHistory] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - modifyDMGHistory] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		nVO.setRtnStr(rtnVO);
		return nVO;
	}

	/**
	 * EES_CTM_0404 retrieve event
	 * retrieving EDI Movement List
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws EventException
	 */
	public List<SearchEDIMovementListVO> searchEDIMovementList(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		try {			
			String returnValue = dbDao.checkSearchCondition(searchEDIMovementListVO);
			if (returnValue.equals("1")) {
				return dbDao.searchEDIMovementListWithIndex(searchEDIMovementListVO);
			} else {
				return dbDao.searchEDIMovementList(searchEDIMovementListVO);
			}
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchEDIMovementList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchEDIMovementList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0404 retrieve event
	 * retrieve event EDI Movement List Count
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
	 * EES_CTM_0406 Retrieve
	 * handling event for retrieving International VL/VD 
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @param String oscaBkgFlg
	 * @return List<SearchCLMInfoVO>
	 * @exception EventException
	 */
	public List<SearchCLMInfoVO> searchVLVDList(SearchCLMInfoVO searchCLMInfoVo, String oscaBkgFlg) throws EventException {
		try {
			return dbDao.searchVLVDList(searchCLMInfoVo, oscaBkgFlg);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchVLVDList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchVLVDList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * EES_CTM_0409 Retrieve
	 * retrieving EDI Container Message list
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
	 * EES_CTM_0409 Retrieve
	 * retrieving EDI Result Remark list
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
	 * EES_CTM_0406
	 * retrieving booking list booked that container no after retrieving container no
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
	 * EES_CTM_0406: retrieving ETA/ETD 
	 * retrieving ETA/ETD Time in case VSL/YARD inputed
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

	/** getVvd
	 * 
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return String
	 * @exception EventException
	 */
	public String getVvd(SearchCLMInfoVO searchCLMInfoVo) throws EventException {
		try {
			return dbDao.getVvd(searchCLMInfoVo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - getVvd] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - getVvd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * validating VL Pre Check
	 * handling event for Pre Check button before saving VL
	 *
	 * @param CtmCntrMovInfoVO[] ctmCntrMovInfoVOs
	 * @param SignOnUserAccount account
	 * @param String oscaBkgFlg
	 * @return String[][]
	 * @exception EventException
	 */
	public String[][] checkPREVLVD(CtmCntrMovInfoVO[] ctmCntrMovInfoVOs, SignOnUserAccount account, String oscaBkgFlg) {
		String[][] rtnStr = new String[ctmCntrMovInfoVOs.length][2];
		List<BkgContainerLastVO> bkgCntr = null;
		BkgContainerLastVO   bkgCntrInfo = null;
		int errCnt = 0;
		for (int i = 0; i < ctmCntrMovInfoVOs.length; i++) {
			CtmCntrMovInfoVO vo = ctmCntrMovInfoVOs[i];
			
			try {
				bkgCntr = dbDao.getPreChkValue(vo.getCntrNo(), oscaBkgFlg);
				if (bkgCntr == null || bkgCntr.size() == 0) {
					rtnStr[i][0] = "No Data Found";
					errCnt++;
					continue;
				}
				bkgCntrInfo = bkgCntr.get(0);
			} catch (DAOException e) {
				/*******************************************************
				 * no throwing in case of failure for handling next data *
				 *******************************************************/
				log.error(e.getMessage(),e);
				rtnStr[i][0] = "Booking Select Error";
				errCnt++;
				continue;
			}
			vo.setBkgNo(bkgCntrInfo.getBkgNo());
			if (vo.getMvmtStsCd().equals("VL")) {
				/******************************************************
				 * getting information from MST_CONTAINER about container **
				 ******************************************************/
				String cntrNo = vo.getCntrNo();
//				String checkDgt = vo.getCheckDigit();
				String evntDt = vo.getCnmvEvntDt();
				String yardCd = vo.getOrgYdCd();
				String stsCd = vo.getMvmtStsCd();
				String svrId = "";
//				if (checkDgt == null || checkDgt.equals("null") || checkDgt.equals("")) checkDgt = "";
				
				try {
					svrId = dbDao.searchSvrId(yardCd);
				} catch (DAOException e) {
					/*******************************************************
					 * no throwing in case of failure for handling next data *
					 *******************************************************/
					log.error(e.getMessage(),e);
					rtnStr[i][0] = "Select Server Error!";
					continue;
				}

				
				try {
					MstContainerInfoVO cntrVO = dbDao.getCntrInfo(cntrNo, evntDt, yardCd);
					if (!svrId.equals(cntrVO.getSvrId()) && !stsCd.equals("VD")) {
						rtnStr[i][0] = "Container Is Not Located In This Area " + svrId + ":" + cntrVO.getSvrId();
						errCnt++;
						continue;
					}
				} catch (Exception ex) {
					/*******************************************************
					 * no throwing in case of failure for handling next data *
					 *******************************************************/
					rtnStr[i][0] = "Select CONTAINER Table Error!";
					errCnt++;
					log.error(ex.getMessage(),ex);
					continue;
				}

				
				try {
					String[] mvmtStsCd = dbDao.getMovementHistoryLast3(vo.getCntrNo());

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
					 * no throwing in case of failure for handling next data *
					 *******************************************************/
					log.error(e.getMessage(),e);
					rtnStr[i][0] = "Container Movement Select Error";
					errCnt++;
					continue;
				}
			}

			
			try {
				String checkVVD = dbDao.checkBkgVVD(vo, oscaBkgFlg);
				if (checkVVD == null) {
					rtnStr[i][0] = "Booking VVD Select Error";
					errCnt++;
					continue;
				}
			} catch (Exception e) {
				/*******************************************************
				 * no throwing in case of failure for handling next data *
				 *******************************************************/
				log.error(e.getMessage(),e);
				rtnStr[i][0] = "Booking POL_LOC Error";
				errCnt++;
				continue;
			}

			
			try {
				String cnt = dbDao.getBkgDupCount(vo.getCntrNo(), vo.getMvmtStsCd(), bkgCntrInfo.getCnmvCycNo());
				if (Integer.parseInt(cnt) > 1) {
					List<MultiBkgNoVO> multiBkg = dbDao.searchMultiBkgNoList(vo.getCntrNo(), bkgCntrInfo.getCnmvCycNo(), vo.getMvmtStsCd(), "");
					String bkgNos = "";
					//[2015.05.28]소스품질 Modify
					StringBuffer sb = new StringBuffer();
					for (int idxMul = 0; idxMul < multiBkg.size(); idxMul++) {
						sb.append(multiBkg.get(idxMul).getBkgNo()).append(" ");
						if (idxMul < multiBkg.size() - 1) sb.append(", ");
						//bkgNos = bkgNos + multiBkg.get(idxMul).getBkgNo() + " ";
						//if (idxMul < multiBkg.size() - 1) bkgNos = bkgNos + ", ";
					}
					bkgNos = sb.toString();
					rtnStr[i][0] = "There are different trunk VVD in another Booking![" + bkgNos + "]";
					errCnt++;
					continue;
				}
			} catch (Exception e) {
				/*******************************************************
				* no throwing in case of failure for handling next data *
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
			/* Power Session 위하여 처리 Split도 VD 처리 가능하도록 변경 By Mark LEE		 	
					} else if (bkgNo.length() == 12 && subStr(bkgNo, 10, 12).equals("00")) {
						rtnStr[i][0] = "[VD]Please split MTY REPO BKG No firstly to update VD movement!";
			*/			
					} else if (bkgNo.length() < 10 || bkgNo.length() > 13)
						rtnStr[i][0] = "[VD]Please split MTY REPO BKG No firstly to update VD movement!";
				}

			}

		}
		rtnStr[0][1] = String.valueOf(errCnt);
		return rtnStr;
	}

	/**
	 * EES_CTM_0406 : returning booking container count for type/size
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
	 * returning booking container count for type/size
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
	 * handling event for reservation of VL/VD 
	 * registering reservation information in CTM_MVMT_RSV table
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
	 * validating VL Pre Check
	 * handling event about Pre Check button before saving VL
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @param String oscaBkgFlg
	 * @return String
	 * @exception EventException
	 */
	public String checkVLVDPreChk(CtmCntrMovInfoVO ctmCntrMovInfoVO, String oscaBkgFlg) throws EventException {
		try {
			return dbDao.checkVLVDPreChk(ctmCntrMovInfoVO, oscaBkgFlg);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - checkVLVDPreChk] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - checkVLVDPreChk] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * validating VL Pre Check
	 * handling event about Pre Check button before saving VL
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String checkVVDPreChkOnVslSkd(SearchCLMInfoVO searchCLMInfoVO) throws EventException {
		try {
			return dbDao.checkVVDPreChkOnVslSkd(searchCLMInfoVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - checkVLVDPreChk] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - checkVLVDPreChk] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * CTM common.. calling other modules
	 *
	 * @param CrossItemVO crossItemVO
	 * @param boolean modifyCntrOpResult
	 * @return String
	 * @exception EventException
	 */
	public String updateEtcModule(CrossItemVO crossItemVO, boolean modifyCntrOpResult) throws EventException {
		try {
			
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
	 * updating movement data getting from 0422 
	 * updating movement information. modifying movement information
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
	 * updating movement data getting from 0422 
	 * registering container movement information
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
	 * [calling from MST] Container Movement Creation / Delete
	 * Container Movement Creation / Delete
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @return CusCtmMovementVO
	 * @throws EventException
	 */
	public CusCtmMovementVO manageCntrInfoFromMst(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException {
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
				/**********  Delete   **********/
				
				MVMTBookingInfoVO db = dbDao.searchMovementStatus(cusCtmMovementVO.getCntrNo(), "");

				if (db != null){ // -- need to check
					if (cusCtmMovementVO.getMvmtStsCd().equals(db.getMvmtStsCd()) &&
						cusCtmMovementVO.getCnmvYr().equals(db.getCnmvYr()) &&
						cusCtmMovementVO.getCnmvIdNo().equals(db.getCnmvIdNo())) {
	
						List<CusCtmMovementVO> deleteVoList = new ArrayList<CusCtmMovementVO>();
						deleteVoList.add(cusCtmMovementVO);
	
						dbDao.insertCtmMovementFromMst(deleteVoList);          // insert CTM_MVMT_CORR into select CTM_MOVEMENT
						dbDao.removeCtmMovementVOS(deleteVoList);          // delete CTM_MOVEMENT
	
					} 
				}

			} else {
				/**********  Insert  **********/
				rVo = dbDao.getCntrInfoFromMst(cusCtmMovementVO);
				String idNo  = dbDao.getContainerMaxId(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());
				String idSeq = dbDao.getContainerMaxSeq(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());

				if (idNo == null || idNo.equals("")) idNo = "0";
				if (idSeq == null || idSeq.equals("")) idSeq = "0";
				rVo.setCnmvIdNo(String.valueOf(Integer.parseInt(idNo) + 1));
				rVo.setCnmvSeq(String.valueOf(Integer.parseInt(idSeq) + 1));
				rVo.setMvmtCreTpCd(cusCtmMovementVO.getMvmtCreTpCd());

				dbDao.addCtmMovement(rVo);

			}

		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - manageCntrInfoFromMst] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - manageCntrInfoFromMst] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		return rVo;
	}

//	/**
//	 * checking booking no for handling SPP
//	 * Container Movement Creation
//	 *
//	 * @param String cntrNo
//	 * @param String bkgNo
//	 * @param String blNo
//	 * @return String[]
//	 * @exception EventException
//	 */
//	private String[] checkBkgNoFrSpp(String cntrNo, String bkgNo, String blNo) throws EventException {
//		CheckBookingVO checkBookingVO = null;
//		String[] rtn = new String[]{null, null, null};
//		if (bkgNo != null && !bkgNo.equals("")) {
//			
//			try {
//				checkBookingVO = dbDao.checkBooking(bkgNo);
//				if (checkBookingVO == null || checkBookingVO.getBkgNo() == null || checkBookingVO.getBkgNo().equals("")) {
//					rtn[0] = "N";
//					rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
//					return rtn;
//				} else {
//					rtn[2] = checkBookingVO.getBkgNo();
//				}
//			} catch (DAOException ex) {
//				rtn[0] = "N";
//				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
//				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);
//			} catch (Exception ex) {
//				rtn[0] = "N";
//				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
//				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);
//			}
//
//		} else if (blNo != null && !blNo.equals("")) {
//			try {
//				checkBookingVO = dbDao.checkBlNo(blNo);
//				if (checkBookingVO == null || checkBookingVO.getBkgNo() == null || checkBookingVO.getBkgNo().equals("")) {
//					rtn[0] = "N";
//					rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
//					return rtn;
//				} else {
//					rtn[2] = checkBookingVO.getBkgNo();
//				}
//			} catch (DAOException ex) {
//				rtn[0] = "N";
//				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
//				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);
//			} catch (Exception ex) {
//				rtn[0] = "N";
//				rtn[1] = "Select BKG by BL (e-Tracker) Error(1)!";
//				throw new EventException(new ErrorHandler("Select BKG by BL (e-Tracker) Error(1)!").getMessage(), ex);			}
//		} else {
//			return rtn;
//		}
//
//		/**
//		 * 2014.11.05
//		 */
///*		String bkg = subStr(checkBookingVO.getBkgNo(), 0, 4);
//		rtn[2] = checkBookingVO.getBkgNo();
//		if (bkg.equals("POOL") || subStr(bkg, 0, 3).equals("REP")) {
//			rtn[0] = "N";
//			rtn[1] = "MT Repo BKG Error!";
//			return rtn;
//		}*/
//		
//		return rtn;
//	}

//	/**
//	 * check logic for Movement Status from EDI Inbound
//	 *
//	 * @param String ibFlg
//	 * @param String bkgNo
//	 * @param String orgYd
//	 * @param String destYd
//	 * @return String
//	 * @exception EventException
//	 */
//	@SuppressWarnings("unused")
//	private String checkProcessIn(String ibFlg, String bkgNo, String cntrNo, String orgYd, String destYd) throws EventException{
//		String mvmtCd = null;
//		String delCd, rcvTermCd, podCd;
//		String orgScc, orgLcc, dstScc, dstLcc, delLcc, delScc;
//		orgScc = orgLcc = dstScc = dstLcc = delLcc = delScc = "";
//		try {
//			String[] bkg = dbDao.getBkgInfoFrSpp(bkgNo);
//			if (bkg == null) {
//				return "Select Del_loc, Term by BKG (e-Tracker) Error(1)!";
//			}
//			delCd = bkg[0];
//			rcvTermCd = bkg[1];
//			podCd = bkg[2];
//		} catch (DAOException e) {
//			throw new EventException(new ErrorHandler("Select Del_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
//		} catch (Exception e) {
//			throw new EventException(new ErrorHandler("Select Del_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
//		}
//		try {
//			String[] lcc = dbDao.getLccRccCode(subStr(orgYd, 0, 5));
//			if (lcc == null) {
//				return "Select EVENT_LCC/SCC (e-Tracker) Error(1)!";
//			}
//			orgLcc = lcc[2];
//			orgScc = lcc[3];
//		} catch (DAOException e) {
//			throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//		} catch (Exception e) {
//			throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//		}
//		if (destYd != null && !"".equals(destYd)) {
//			try {
//				String[] lcc = dbDao.getLccRccCode(destYd.length() < 5 ? "" : subStr(destYd, 0, 5));
//				if (lcc == null) {
//					return "Select DEST_LCC/SCC (e-Tracker) Error(1)!";
//				}
//				dstLcc = lcc[2];
//				dstScc = lcc[3];
//			} catch (DAOException e) {
//				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			} catch (Exception e) {
//				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			}
//		}
//		if (StringUtils.isNotEmpty(delCd)) {//[2015.05.28]소스품질 Modify if (delCd != null && !"".equals(delCd))
//			try {
//				String[] lcc = dbDao.getLccRccCode(subStr(delCd, 0, 5));
//				if (lcc == null) {
//					return "Select DEL_LCC/SCC (e-Tracker) Error(1)!";
//				}
//				delLcc = lcc[2];
//				delScc = lcc[3];
//			} catch (DAOException e) {
//				throw new EventException(new ErrorHandler("Select DEL_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			} catch (Exception e) {
//				throw new EventException(new ErrorHandler("Select DEL_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			}
//		}
//		if (destYd == null || "".equals(destYd) || (destYd.length() > 4 && subStr(destYd, 0, 5).equals(delCd))) {
//			if (orgScc.equals(delScc)) {
//				mvmtCd = "ID";
//			} else if (orgLcc.equals(delLcc)) {
//				if ( rcvTermCd.equals("D") && ibFlg.equals("I") ) {
//					try {
//						String returnValue = "";
//						returnValue = dbDao3.searchTrspModCode( bkgNo, cntrNo, orgYd );
//						if ( returnValue == null || returnValue.equals("") ) {
//							mvmtCd = "TN";
//						} else {
//							mvmtCd = "ID";
//						}
//					} catch (DAOException ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					} catch (Exception ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					}
//				} else if ( rcvTermCd.equals("Y") && ibFlg.equals("I") ) {
//					try {
//						String returnValue = "";
//						returnValue = dbDao3.searchFinalFacility( bkgNo, cntrNo );
//						if ( returnValue == null || returnValue.equals("") ) {
//							mvmtCd = "ID";
//						} else {
//							if (returnValue.equals(orgYd)) {
//								mvmtCd = "ID";
//							} else {
//								mvmtCd = "TN";
//							}
//						}
//					} catch (DAOException ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					} catch (Exception ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					}
//				} else {
//					return "TN";
//
//				}
//			} else {
//				if ( rcvTermCd.equals("D") && ibFlg.equals("I") ) {
//					try {
//						String returnValue = "";
//						returnValue = dbDao3.searchTrspModCode( bkgNo, cntrNo, orgYd );
//						if ( returnValue == null || returnValue.equals("") ) {
//							mvmtCd = "EN";
//						} else {
//							mvmtCd = "ID";
//						}
//					} catch (DAOException ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					} catch (Exception ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					}
//				} else if ( rcvTermCd.equals("Y") && ibFlg.equals("I") ) {
//					try {
//						String returnValue = "";
//						returnValue = dbDao3.searchFinalFacility( bkgNo, cntrNo );
//						if ( returnValue == null || returnValue.equals("") ) {
//							mvmtCd = "ID";
//						} else {
//							if (returnValue.equals(orgYd)) {
//								mvmtCd = "ID";
//							} else {
//								mvmtCd = "EN";
//							}
//						}
//					} catch (DAOException ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					} catch (Exception ex) {
//						/***************************************************************
//						 * no throwing in case of failure for handling next data *
//						 ***************************************************************/
//						mvmtCd = "ID";
//						log.error("err " + ex.toString(), ex);
//					}
//				} else {
//					return "EN";
//
//				}
//			}
//		} else {
//			if (orgLcc.equals(dstLcc)) {
//				mvmtCd = "TN";
//			} else {
//				mvmtCd = "EN";
//			}
//		}
//		return mvmtCd;
//	}

//	/**
//	 * check logic for Movement Status from EDI OUTBOUND
//	 *
//	 * @param String ibFlg
//	 * @param String fCntr
//	 * @param String bkgNo
//	 * @param String orgYd
//	 * @param String destYd
//	 * @return String
//	 * @exception EventException
//	 */
//	private String checkProcessOut(String ibFlg, String fCntr, String bkgNo, String orgYd, String destYd) throws EventException{
//		String mvmtCd = null;
//		String polCd;
//		String orgLcc,  dstLcc;
//		 orgLcc = dstLcc = "";
//
//		if (fCntr.equals("M") || fCntr.equals("N")) mvmtCd = "TN";
//		else {
//			try {
//				String[] bkg = dbDao.getBkgInfoFrSpp(bkgNo);
//				if (bkg == null) {
//					return "Select Del_loc, Term by BKG (e-Tracker) Error(1)!";
//				}
//				polCd = bkg[3];
//			} catch (DAOException e) {
//				throw new EventException(new ErrorHandler("Select POL_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
//			} catch (Exception e) {
//				throw new EventException(new ErrorHandler("Select POL_loc, Term by BKG (e-Tracker) Error(1)!").getMessage(), e);
//			}
//
//			if (destYd == null || destYd.equals("")) destYd = polCd;
//
//			try {
//				String[] lcc = dbDao.getLccRccCode(subStr(orgYd, 0, 5));
//				if (lcc == null) {
//					return "Select EVENT_LCC/SCC (e-Tracker) Error(1)!";
//				}
//				orgLcc = lcc[2];
//			} catch (DAOException e) {
//				throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			} catch (Exception e) {
//				throw new EventException(new ErrorHandler("Select EVENT_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			}
//			try {
//				String[] lcc = dbDao.getLccRccCode(destYd.length() < 5 ? "" : subStr(destYd, 0, 5));
//				if (lcc == null) {
//					return "Select DEST_LCC/SCC (e-Tracker) Error(1)!";
//				}
//				dstLcc = lcc[2];
//			} catch (DAOException e) {
//				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			} catch (Exception e) {
//				throw new EventException(new ErrorHandler("Select DEST_LCC/SCC (e-Tracker) Error(1)!").getMessage(), e);
//			}
//			if (orgLcc.equals(dstLcc)) {
//				mvmtCd = "TN";
//			} else {
//				mvmtCd = "EN";
//			}
//		}
//		return mvmtCd;
//	}

	/**
	 * EES_CTM_0456 : searching PreVLVD List
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
	 * EES_CTM_0456 : updating/deleting PreVLVD List
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
	 * BKG
	 * updating STL FLG in CTM_MVMT_IRR
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
	 * handling MT status of new EQ
	 * Container Movement  MT Status Creation
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
			String evntDt = cusCtmMovementVO.getCnmvEvntDt();
			String evntBk = evntDt;
			evntDt = subStr(evntDt, 0, 4) + "-" + subStr(evntDt, 4, 6) + "-" + subStr(evntDt, 6, 8);
			String idNo  = dbDao.getContainerMaxId(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());
			String idSeq = dbDao.getContainerMaxSeq(cusCtmMovementVO.getCntrNo(), cusCtmMovementVO.getCnmvYr());
			if (idNo == null || idNo.equals("")) idNo = "0";
			if (idSeq == null || idSeq.equals("")) idSeq = "0";
			idNo  = String.valueOf(Integer.parseInt(idNo)+1);
			idSeq = String.valueOf(Integer.parseInt(idSeq)+1);
			cusCtmMovementVO.setCnmvEvntDt(evntDt);
			cusCtmMovementVO.setCnmvIdNo(idNo);
			cusCtmMovementVO.setCnmvSeq(idSeq);
			rVo = dbDao.getCntrInfoFromMst(cusCtmMovementVO);
			dbDao.addCtmMovement(rVo);
			cusCtmMovementVO.setCnmvEvntDt(evntBk);
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
	 * getting booking list with Container No and EDI key value
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
	 * retrieving VL/VD Correction information
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

	/**
	 * CTM MOVEMENT COMMON auto creation logic<br>
	 * Container Movement Auto Creation<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVo 	: to be inputed Movement
	 * @param CusCtmMovementVO prevCtmMovementVO	: current Movement
	 * @param MstContainerInfoVO mstContainerInfoVO	: master container
	 * @param BkgBookingInfoVO bkgBookingInfoVO		: BkgBooking
	 * @param CheckBookingVO checkBookingVO			: no use
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO		: previous Movement
	 * @param String[] autoParam					: 
	 * @return String[]
	 * @exception DAOException
	 * @exception EventException
	 */
	private CrossItemVO autoCre(CusCtmMovementVO cusCtmMovementVo, CusCtmMovementVO prevCtmMovementVO, MstContainerInfoVO mstContainerInfoVO, BkgBookingInfoVO bkgBookingInfoVO, CheckBookingVO checkBookingVO, CtmCntrMovInfoVO ctmCntrMovInfoVO, String[] autoParam) throws EventException {
		String cycNo     = autoParam[0]  ;	// cycle no
		String idNo   	 = autoParam[1]  ;	// last CNTR_ID_NO
		String idSeq  	 = autoParam[2]  ;	// last CNTR_ID_SEQ
		String fmFlag 	 = autoParam[3]  ;	// Full/Empty Flag
		String yardCdEq	 = autoParam[4]  ;	// last Yard and to be inputed Yard
		String ofcCd  	 = autoParam[5]  ;	// Office Code
		String userId 	 = autoParam[6]  ;	// User ID		
		String userNm 	 = autoParam[7]  ;	// User Name	
		String svrId  	 = autoParam[8]  ;	// server ID including yard
		String inpType	 = autoParam[9]  ;	// new property
		String vslCd 	 = autoParam[10] ;	// VVD CODE
		String skdVoyCd  = autoParam[11] ;	// VVD CODE
		String skdDirCd  = autoParam[12] ;	// VVD CODE
		String blNo	     = autoParam[13] ;	// BL CODE
		String errMsg    = "";

		List<AutoCreItemVO> autoItem = null;
		CrossItemVO crossItem = new CrossItemVO();
		CusCtmMovementVO cusCtmMovementVO = (CusCtmMovementVO)cusCtmMovementVo.clone();

		String mvmtStsCd = cusCtmMovementVO.getMvmtStsCd(); // MOVEMENT STATUS
		String yardCd    = cusCtmMovementVO.getOrgYdCd();
		String evntDt    = cusCtmMovementVO.getCnmvEvntDt();
		String mtyPlnNo	 = cusCtmMovementVO.getMtyPlnNo();	// 2015/06/18
		String mtyRepoNo = cusCtmMovementVO.getMtyRepoNo();	// 2015/06/18
		String lstmCd    = cusCtmMovementVO.getLstrmCd();   // 2016/07/01
		String dmgFlag   = cusCtmMovementVO.getCntrDmgFlg();
		String dmgFlagDt = "";
		String dmgUnflagDt = "";
		
		String[] rtnVal = new String[6];
		rtnVal[0] = "";
		rtnVal[1] = "";
		rtnVal[2] = "";   
		rtnVal[3] = "";
		rtnVal[4] = idNo;
		rtnVal[5] = idSeq;

		boolean i_ignore_VVD = false;

		try {
			List<CusCtmMovementVO> cgmVo = new ArrayList<CusCtmMovementVO>();

			String ppSts = "";
			if (ctmCntrMovInfoVO != null && ctmCntrMovInfoVO.getMvmtStsCd() != null) {
				ppSts = ctmCntrMovInfoVO.getMvmtStsCd();
			}

			if ("ID".equals(prevCtmMovementVO.getMvmtStsCd()) && "VL".equals(mvmtStsCd) && "M".equals(fmFlag)) {
				errMsg = "Please create MT status first.";
			} else {
				// errMsg= "Movement creation error [auto creation][" + prevCtmMovementVO.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
				errMsg = getErrMsg( prevCtmMovementVO.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag );
			}

			log.info("\n\n      STS : " + mvmtStsCd +
					   "\n PREV STS : " + prevCtmMovementVO.getMvmtStsCd() +
					   "\n PPRV STS : " + ppSts +
					   "\n YARD EQ  : " + yardCdEq +
					   "\n FULL FLG : " + fmFlag +
					   "\n PREV FLG : " + prevCtmMovementVO.getFcntrFlg() +
					   "\n BBLK FLG : " + cusCtmMovementVo.getBbulkFlg() + "\n");

			if ("Y".equals(dmgFlag)) {
				if ("N".equals(mstContainerInfoVO.getDmgFlg())) {
					dmgFlagDt = cusCtmMovementVo.getCnmvEvntDt();
					dmgUnflagDt = "";
				} else {
					dmgFlagDt = prevCtmMovementVO.getDmgFlgDt();
					dmgUnflagDt = "";
				}
			} else if ("N".equals(dmgFlag)) {
				if ("Y".equals(mstContainerInfoVO.getDmgFlg())) {
					dmgFlagDt = prevCtmMovementVO.getDmgFlgDt();
					dmgUnflagDt = cusCtmMovementVo.getCnmvEvntDt();
					
					//MNR 호출 , parameter : crrCntrInfo.getEvntDt() as DM Unflg DT, dmgFlag - "N"
					log.info("MNR 호출 : Unflagging" + dmgUnflagDt);
					crossItem.setMnrCallYN("Y");
				} else {
					dmgFlagDt = "";
					dmgUnflagDt = "";
				}
			} else {
				if ("Y".equals(prevCtmMovementVO.getCntrDmgFlg())){
					dmgFlag = prevCtmMovementVO.getCntrDmgFlg();
					dmgFlagDt = prevCtmMovementVO.getDmgFlgDt();
					dmgUnflagDt = "";
				} else {
					dmgFlag = prevCtmMovementVO.getCntrDmgFlg();
					dmgFlagDt = "";
					dmgUnflagDt = "";
				}
			}
			
			if ("MT".equals(prevCtmMovementVO.getMvmtStsCd()) && "VL".equals(mvmtStsCd) && "Y".equals(cusCtmMovementVo.getBbulkFlg())) {

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
				
				/**  dbDao.checkAutoCreItem(현재Status, 이전Status, 전전Status, YARD EQ, 현재F/M Flag, 이전F/M Flag)  **/
				autoItem = dbDao.checkAutoCreItem(("TN".equals(mvmtStsCd) ? "EN" : mvmtStsCd), prevCtmMovementVO.getMvmtStsCd(), ppSts, yardCdEq, fmFlag, prevCtmMovementVO.getFcntrFlg());
			}

			AutoCreItemVO act = null;

			if (autoItem == null || autoItem.size() == 0) {
				// no data. ERROR. [2015.05.28]소스품질 Modify
				//if (autoItem.size() == 0) {
					rtnVal[0] = "N";
					// rtnVO[1] = "Movement creation error [auto creation][" + prevCtmMovementVO.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
					rtnVal[1] = getErrMsg( prevCtmMovementVO.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag );
					
					crossItem.setRtnStr(rtnVal);
					return crossItem;
				//}

			} else {
				CusCtmMovementVO cVO = null;
				
				for (int i=0; i<autoItem.size(); i++) {
					act = autoItem.get(i);
					String autoSts = subStr(act.getAuto(), 0, 2);
					String asSts = act.getAsSts();
					if (!asSts.equals(mvmtStsCd) && !"TN".equals(mvmtStsCd) && !"VL".equals(mvmtStsCd)) {
						rtnVal[0] = "Y";
						rtnVal[1] = asSts;
					}
			
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
						// inputting booking no in case nBkgNoFlg = False
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
					// checking EN/TN in case status to be auto created is TN
					if (autoSts.equals("EN") || autoSts.equals("TN")) {
						String locationCd = null;
						errMsg = "EN/TN same location";
						locationCd = dbDao.checkLocationCd(yardCd, prevCtmMovementVO.getOrgYdCd());
						if (locationCd == null) {
							rtnVal[0] = "N";
							rtnVal[1] = "EN/TN same location";
							crossItem.setRtnStr(rtnVal);
							return crossItem;
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
						rtnVal[1] = getErrMsg( prevCtmMovementVO.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag );
						crossItem.setRtnStr(rtnVal);
						return crossItem;
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
						if (!"SH".equals(lstmCd) || "OP".equals(asSts) || "CP".equals(asSts)) {	// CSR #14014 Empty Revenue Logic
							// initializing TRUNK 
							cVO.setCrntSkdDirCd("");
							cVO.setCrntSkdVoyNo("");
							cVO.setCrntVslCd("");
							cVO.setTrnkSkdDirCd("");
							cVO.setTrnkSkdVoyNo("");
							cVO.setTrnkVslCd("");
							// initializing BOOKING 
							cVO.setBlNo("");
							cVO.setBkgNo("");
							// initializing others
							cVO.setBkgCgoTpCd("");
							cVO.setFcntrFlg("M");
							cVO.setCnmvLvlNo("0");
						}
					}
					log.info("자동생성" + autoSts);
					cVO.setCreUsrId(userId);
					cVO.setUpdUsrId(userId);
					cVO.setUsrNm(userNm);

					if ("C".equals(act.getTar())) {
						// new
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" Creation error][Auto]";
						cVO.setMvmtStsCd(autoSts);
						cVO.setCnmvEvntDt(evntDt);
						cVO.setObCntrFlg(prevCtmMovementVO.getObCntrFlg());

						if ("OP".equals(autoSts)) {
							cVO.setObCntrFlg("O");
							cVO.setFcntrFlg("M");

						} else if ("OC".equals(autoSts)) {
							cVO.setObCntrFlg("O");
							cVO.setFcntrFlg("F");
						} else if ("IC".equals(autoSts)) {
							cVO.setObCntrFlg("I");
							cVO.setFcntrFlg("F");
						} else if ("clear".equals(act.getCreUsrId()) && "SH".equals(lstmCd) && !"OP".equals(asSts) && !"CP".equals(asSts)) {
							if (cVO.getBkgNo() != null && !"".equals(cVO.getBkgNo())) {
								boolean ObCntrFlg = dbDao.checkObCntrFlg(cVO.getCntrNo(), cVO.getBkgNo());
								if (!ObCntrFlg) {
									cVO.setObCntrFlg("O");
								}
							}
						}

						if (!"clear".equals(act.getCreUsrId())) {
							if (blNo != null && !"".equals(blNo)) {
								cVO.setBlNo(blNo);
							} else if (!prevCtmMovementVO.getBlNo().equals("")) {
								cVO.setBlNo(prevCtmMovementVO.getBlNo());
							}
						} else if ("clear".equals(act.getCreUsrId()) && "SH".equals(lstmCd) && !"OP".equals(asSts) && !"CP".equals(asSts)) {	// CSR #14014 Empty Revenue Logic
							if (blNo != null && !"".equals(blNo)) {
								cVO.setBlNo(blNo);
							} else if (!prevCtmMovementVO.getBlNo().equals("")) {
								cVO.setBlNo(prevCtmMovementVO.getBlNo());
							}
						}

						cVO.setCrntVslCd("");
						cVO.setCrntSkdVoyNo("");
						cVO.setCrntSkdDirCd("");
						if (!act.getCreUsrId().equals("clear") && cusCtmMovementVO.getBkgRcvTermCd() != null && !cusCtmMovementVO.getBkgRcvTermCd().equals("")) {
							cVO.setBkgRcvTermCd(cusCtmMovementVO.getBkgRcvTermCd());
						} else if (!act.getCreUsrId().equals("clear") && prevCtmMovementVO != null && prevCtmMovementVO.getBkgRcvTermCd() != null && !prevCtmMovementVO.getBkgRcvTermCd().equals("")) {
							cVO.setBkgRcvTermCd(prevCtmMovementVO.getBkgRcvTermCd());
						} else if (act.getCreUsrId().equals("clear") && "SH".equals(lstmCd) && !"OP".equals(asSts) && !"CP".equals(asSts)) {	// CSR #14014 Empty Revenue Logic
							if (cusCtmMovementVO.getBkgRcvTermCd() != null && !cusCtmMovementVO.getBkgRcvTermCd().equals("")) {
								cVO.setBkgRcvTermCd(cusCtmMovementVO.getBkgRcvTermCd());
							} else if (prevCtmMovementVO != null && prevCtmMovementVO.getBkgRcvTermCd() != null && !prevCtmMovementVO.getBkgRcvTermCd().equals("")) {
								cVO.setBkgRcvTermCd(prevCtmMovementVO.getBkgRcvTermCd());
							}
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
						} else if (act.getCreUsrId().equals("clear") && "SH".equals(lstmCd) && !"OP".equals(asSts) && !"CP".equals(asSts)) {	// CSR #14014 Empty Revenue Logic
							if (cusCtmMovementVO.getTrnkVslCd() != null && !cusCtmMovementVO.getTrnkVslCd().equals("")) {
								cVO.setTrnkVslCd(cusCtmMovementVO.getTrnkVslCd());
								cVO.setTrnkSkdVoyNo(cusCtmMovementVO.getTrnkSkdVoyNo());
								cVO.setTrnkSkdDirCd(cusCtmMovementVO.getTrnkSkdDirCd());
							} else {
								cVO.setTrnkVslCd(prevCtmMovementVO.getTrnkVslCd());
								cVO.setTrnkSkdVoyNo(prevCtmMovementVO.getTrnkSkdVoyNo());
								cVO.setTrnkSkdDirCd(prevCtmMovementVO.getTrnkSkdDirCd());
							}
						}
						
						if (cVO.getTrnkVslCd() != null && !cVO.getTrnkVslCd().equals("") &&
								(!cVO.getTrnkVslCd().equals(prevCtmMovementVO.getTrnkVslCd()) || !cVO.getTrnkSkdDirCd().equals(prevCtmMovementVO.getTrnkSkdDirCd()) || !cVO.getTrnkSkdVoyNo().equals(prevCtmMovementVO.getTrnkSkdVoyNo()) || i_ignore_VVD == true) && !cVO.getBkgNo().equals(prevCtmMovementVO.getBkgNo())) {
							if (!cVO.getBkgNo().equals(prevCtmMovementVO.getBkgNo()) ) {
								if (prevCtmMovementVO.getFcntrFlg().equals("Y") && (prevCtmMovementVO.getBkgNo() == null || prevCtmMovementVO.getBkgNo().equals("") ) && cVO.getBkgNo().equals(ctmCntrMovInfoVO.getBkgNo()) ) {
									log.info("Full EN : BKG NO IS NOT CHANGE");
								}
								else if((prevCtmMovementVO.getMvmtStsCd().equals("MT")||prevCtmMovementVO.getMvmtStsCd().equals("CM")) && (ctmCntrMovInfoVO != null && ctmCntrMovInfoVO.getMvmtStsCd() != null) && (mvmtStsCd.equals("OP")) && (autoSts.equals("EN") || autoSts.equals("TN") || autoSts.equals("MT") ) ){	
									log.info("No adding cycle no");
								}
								else {
									// VL이후  "VD“ 생성시  VVD 변경은 Cyc +1을 추가하지 않는다
									if(!cVO.getMvmtStsCd().equals("VD"))
									{
										cycNo = (String.valueOf(Integer.parseInt(prevCtmMovementVO.getCnmvCycNo()) + 1));
									}
//									cycNo = (String.valueOf(Integer.parseInt(prevCtmMovementVO.getCnmvCycNo()) + 1));
								}
							}
						} else if (cVO.getTrnkVslCd() != null && !cVO.getTrnkVslCd().equals("") &&
								(cVO.getTrnkVslCd().equals(prevCtmMovementVO.getTrnkVslCd()) || cVO.getTrnkSkdDirCd().equals(prevCtmMovementVO.getTrnkSkdDirCd()) || cVO.getTrnkSkdVoyNo().equals(prevCtmMovementVO.getTrnkSkdVoyNo()) ) && !cVO.getBkgNo().equals(prevCtmMovementVO.getBkgNo())) {
							if(dbDao.checkBKGRSQL(cVO.getCntrNo(), cVO.getBkgNo(), prevCtmMovementVO.getBkgNo())) {
								if (prevCtmMovementVO.getFcntrFlg().equals("Y") && (prevCtmMovementVO.getBkgNo() == null || prevCtmMovementVO.getBkgNo().equals("") ) && cVO.getBkgNo().equals(ctmCntrMovInfoVO.getBkgNo()) ) {
									log.info("Full EN : BKG NO IS NOT CHANGE");
								}
								else if((prevCtmMovementVO.getMvmtStsCd().equals("MT")||prevCtmMovementVO.getMvmtStsCd().equals("CM")) && (ctmCntrMovInfoVO != null && ctmCntrMovInfoVO.getMvmtStsCd() != null) && (mvmtStsCd.equals("OP")) && (autoSts.equals("EN") || autoSts.equals("TN") || autoSts.equals("MT") ) ){	
									log.info("No adding cycle no");
								}
								else {
									// VL이후  "VD“ 생성시  VVD 변경은 Cyc +1을 추가하지 않는다
									if(!cVO.getMvmtStsCd().equals("VD"))
									{
										cycNo = (String.valueOf(Integer.parseInt(prevCtmMovementVO.getCnmvCycNo()) + 1));
									}
//									cycNo = (String.valueOf(Integer.parseInt(prevCtmMovementVO.getCnmvCycNo()) + 1));
								}
						    }
						}
						cVO.setCnmvCycNo(cycNo);
						String lvlCd = null;
						String cgoTp = prevCtmMovementVO.getBkgCgoTpCd();
						errMsg = "Full flag is null";
						//lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, cVO.getMvmtStsCd()).getCnmvLvlNo();
						//if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
						if(dbDao.getCNTRMovSeqRSQL(cgoTp, cVO.getMvmtStsCd()) != null) {
							lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, cVO.getMvmtStsCd()).getCnmvLvlNo();
					    } else {
					    	if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
					    		lvlCd = "0";
					    	} else {
					    		errMsg =  "Cargo Type and Status Unmatch Error!";
					    	}
					    }
						
						cVO.setCnmvLvlNo(lvlCd);

						if (!"clear".equals(act.getCreUsrId())) {
							if (bkgBookingInfoVO == null && !"MT".equals(mvmtStsCd) && !"TN".equals(mvmtStsCd) && !"EN".equals(mvmtStsCd)){
								rtnVal[0] = "N";
								rtnVal[1] = "Booking infomation does not exist[Auto creation]";
								crossItem.setRtnStr(rtnVal);
								return crossItem;
							}
							errMsg = "Booking cgo type is null";
							if (bkgBookingInfoVO != null) {
								cgoTp = bkgBookingInfoVO.getBkgCgoTpCd();
								cVO.setBkgCgoTpCd(cgoTp);
							}
						} else {	// CSR #14014 Empty Revenue Logic
							if ("SH".equals(lstmCd) && !"OP".equals(asSts) && !"CP".equals(asSts)) {
								if (bkgBookingInfoVO == null){
									rtnVal[0] = "N";
									rtnVal[1] = "Booking infomation does not exist[Auto creation]";
									crossItem.setRtnStr(rtnVal);
									return crossItem;
								}
								errMsg = "Booking cgo type is null";
								if (bkgBookingInfoVO != null) {
									cgoTp = bkgBookingInfoVO.getBkgCgoTpCd();
									cVO.setBkgCgoTpCd(cgoTp);
								}
							}
						}

						// 2014.07.07 COMMENT 처리
//						if ("MT".equals(autoSts)) {
//							cVO.setFcntrFlg("N");
//						} else if ("MT".equals(prevCtmMovementVO.getMvmtStsCd()) && ("EN".equals(autoSts) || "TN".equals(autoSts))) {
//							cVO.setTrnkSkdDirCd("");
//							cVO.setTrnkSkdVoyNo("");
//							cVO.setTrnkVslCd("");
//							cVO.setBkgCgoTpCd("");
//							cVO.setBkgRcvTermCd("");
//							cVO.setBlNo("");
//							cVO.setFcntrFlg("N");
//						}
						// 2014.07.07 COMMENT 처리
						
						// 2014.07.07 자동 생성되는 Full BKG의 MT는 이전 Movement의 BKG No.를 사용
						if ("MT".equals(autoSts)) {
							cVO.setFcntrFlg("N");
							// 2014.06.11 자동 생성되는 BKG No.는 이전 Movement의 BKG No.로 함
							if(prevCtmMovementVO.getObCntrFlg().equals("N") && !prevCtmMovementVO.getMvmtStsCd().equals("MT") && !prevCtmMovementVO.getMvmtStsCd().equals("CM")){
						        cVO.setBkgNo(prevCtmMovementVO.getBkgNo()); 
						        cVO.setBlNo(prevCtmMovementVO.getBlNo()); 
						        cVO.setBkgCgoTpCd(prevCtmMovementVO.getBkgCgoTpCd()); 
						        cVO.setMtyPlnNo(prevCtmMovementVO.getMtyPlnNo()); 
						        cVO.setMtyRepoNo(prevCtmMovementVO.getMtyRepoNo()); 
						    }
					       if ("MT".equals(prevCtmMovementVO.getMvmtStsCd()) || "CM".equals(prevCtmMovementVO.getMvmtStsCd())){
					    	   if (!"SH".equals(lstmCd)) {
						    	   cVO.setBkgCgoTpCd("");
							       cVO.setBlNo(""); 
					    	   }
					    	   cVO.setMtyPlnNo(mtyPlnNo);
					    	   cVO.setMtyRepoNo(mtyRepoNo);	
					       }						
						} else if (("MT".equals(prevCtmMovementVO.getMvmtStsCd()) || "CM".equals(prevCtmMovementVO.getMvmtStsCd())) && ("EN".equals(autoSts) || "TN".equals(autoSts))) {
							if ("OP".equals(asSts) || "CP".equals(asSts) || !"SH".equals(lstmCd)) {	// CSR #14014 Empty Revenue Logic
								cVO.setTrnkSkdDirCd("");
								cVO.setTrnkSkdVoyNo("");
								cVO.setTrnkVslCd("");
								cVO.setBkgCgoTpCd("");
								cVO.setBkgRcvTermCd("");
								cVO.setBlNo("");
								cVO.setBkgNo("");
								cVO.setFcntrFlg("N");
							}
							cVO.setMtyPlnNo(mtyPlnNo);
							cVO.setMtyRepoNo(mtyRepoNo);
						}
						else if("ID".equals(autoSts)) { // 2014.06.11 - Auto 생성된  MVMT의 Bkg 과 B/L을 동일하게 유지
					        cVO.setBlNo(cVO.getBlNo());
					        cVO.setFcntrFlg("Y"); // 2014.06.11 - ID Movement는 Full로만 생성됨
							cVO.setMtyPlnNo("");
							cVO.setMtyRepoNo("");
						}
						// 2014.07.07 자동 생성되는 Full BKG의 MT는 이전 Movement의 BKG No.를 사용
						
//						if ("OP".equals(autoSts) && "Y".equals(dmgFlag)) {
//							rtnVal[0] = "N";
//							rtnVal[1] = "Can't release damage container.[Auto creation]";
//							crossItem.setRtnStr(rtnVal);
//							return crossItem;
//						}
						
						cVO.setMvmtCreTpCd("A");
						cVO.setMvmtInpTpCd(inpType);
						cVO.setCntrSvrId(svrId);
						cVO.setBkgKnt(prevCtmMovementVO.getBkgKnt());
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" create error][Auto]";
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						cVO.setCnmvIdNo(idNo);
						cVO.setCnmvSeq(idSeq);
						if((cVO.getBkgNo()).length() == 10)
							cVO.setOscaBkgFlg("Y");
						else
							cVO.setOscaBkgFlg("N");
						
						cVO.setCntrDmgFlg(dmgFlag);
						cVO.setDmgFlgDt(dmgFlagDt);
						cVO.setDmgUnflgDt(dmgUnflagDt);
						
						cVO.setVndrSeq(""); // 2016.06.22 CSR #14927
						
						dbDao.addCtmMovement(cVO);
						
						rtnVal[2] = cVO.getMvmtStsCd();

						CusCtmMovementVO tempVO = (CusCtmMovementVO)cVO.clone();
						cgmVo.add(tempVO);
						
					} else if ("U1".equals(act.getTar())) {
						// updating previous status
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" update(1) error][Auto]";
						cVO.setMvmtStsCd(autoSts);
						if ("CY".equals(subStr(act.getAuto(), 3, 5))) {
							cVO.setOrgYdCd(prevCtmMovementVO.getOrgYdCd());
						} else {
							cVO.setOrgYdCd(yardCd);
						}
						if ("OP".equals(autoSts)) {    
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
							
							cVO.setCnmvCycNo(cusCtmMovementVo.getCnmvCycNo());
							cVO.setBkgCgoTpCd(cusCtmMovementVo.getBkgCgoTpCd());
							cVO.setFcntrFlg("N");
							cVO.setObCntrFlg("Y");
							cVO.setCnmvLvlNo("1");

							if((cVO.getBkgNo()).length() == 10)
								cVO.setOscaBkgFlg("Y");
							else
								cVO.setOscaBkgFlg("N");
							
							 cVO.setMtyPlnNo("");
							 cVO.setMtyRepoNo("");
							
							cVO.setCntrDmgFlg(dmgFlag);
							cVO.setDmgFlgDt(dmgFlagDt);
							cVO.setDmgUnflgDt(dmgUnflagDt);
							dbDao.updateContainer(cVO, "1", "1");
							
							rtnVal[2] = cVO.getMvmtStsCd();
							
							CusCtmMovementVO tempVO = (CusCtmMovementVO)cVO.clone();
							cgmVo.add(tempVO);

						} else {							
							if((cVO.getBkgNo()).length() == 10)
								cVO.setOscaBkgFlg("Y");
							else
								cVO.setOscaBkgFlg("N");
							
							cVO.setCntrDmgFlg(dmgFlag);
							cVO.setDmgFlgDt(dmgFlagDt);
							cVO.setDmgUnflgDt(dmgUnflagDt);
							dbDao.updateContainer(cVO, "1", "");
							
							rtnVal[2] = cVO.getMvmtStsCd();
							
							CusCtmMovementVO tempVO = (CusCtmMovementVO)cVO.clone();
							cgmVo.add(tempVO);
						}

					} else if ("U2".equals(act.getTar())) {
						errMsg = "Unexpected system error occurred during data processing. ["+autoSts+" update(2) error][Auto]";
						cVO.setCnmvYr(ctmCntrMovInfoVO.getCnmvYr());
						cVO.setMvmtStsCd(autoSts);
						cVO.setMvmtCreTpCd("A");
						if ("CY".equals(subStr(act.getAuto(), 3, 5))) {
							cVO.setOrgYdCd(ctmCntrMovInfoVO.getOrgYdCd());
						} else {
							cVO.setOrgYdCd(yardCd);
						}
						if((cVO.getBkgNo()).length() == 10)
							cVO.setOscaBkgFlg("Y");
						else
							cVO.setOscaBkgFlg("N");
						
						cVO.setCntrDmgFlg(dmgFlag);
						cVO.setDmgFlgDt(dmgFlagDt);
						cVO.setDmgUnflgDt(dmgUnflagDt);
						dbDao.updateContainer(cVO, "2", "");
						
						rtnVal[2] = cVO.getMvmtStsCd();
						
						CusCtmMovementVO tempVO = (CusCtmMovementVO)cVO.clone();
						cgmVo.add(tempVO);
						
					}
				}
			}
			
			crossItem.setCusCtmMovementVOs(cgmVo);
			
		} catch (DAOException ex) {
			log.error("\n\n [BCImpl - autoCre] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
		} catch (Exception ex) {
			log.error("\n\n [BCImpl - autoCre] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
		}
		rtnVal[4] = idNo;
		rtnVal[5] = idSeq;
		crossItem.setRtnStr(rtnVal);
		return crossItem;
	}

	/**
	 * registering container movement information
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

		CusCtmMovementVO crrCntrInfo = null;       // entered container information
		MstContainerInfoVO mstCntrInfo = null;     // MST container information
		CusCtmMovementVO pstCntrInfo = null;       // previous container information (CTM_MOVEMENT)
		CtmCntrMovInfoVO atbCntrInfo = null;       // the movement before previous information (CTM_MOVEMENT)
		BkgBookingInfoVO bkgInfo = null;           // booking information
		List<MultiBkgNoVO> multiBkg = null;        // checking multi booking
		List<BkgContainerLastVO> bkgCntr = null;   // booking container
		BkgContainerLastVO bkgCntrInfo = null;     // booking container
		List<BkgVVDInfoVO> vvdVO = null;           // booking VVD
		BkgVVDInfoVO vvdInfo = null;               // booking VVD
		List<CusCtmMovementVO> cgmVo = new ArrayList<CusCtmMovementVO>();

		String cntrNoAft = null;
		String cntrNoBef = null;
		String vslOld = null;
		String voyOld = null;
		String dirOld = null;
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

			cntrNoAft = crrCntrInfo.getCntrNo();               // container no
			String mvmtStsCd = crrCntrInfo.getMvmtStsCd();     // inputed status
			String bkgNo = crrCntrInfo.getBkgNo();             // booking no
			log.info("BKGNO IS :" + bkgNo + ":");
			String svrId = crrCntrInfo.getCntrSvrId();         
			String cycNo = crrCntrInfo.getCnmvCycNo();         
			String mtyPlnNo = crrCntrInfo.getMtyPlnNo();          // reference no 추가 by 2015/06/15 황미연
			String mtyRepoNo = crrCntrInfo.getMtyRepoNo();
			log.info("REFERENCENO IS :" + mtyPlnNo + mtyRepoNo + ":");			// reference no 추가 by 2015/06/15 황미연
			String idNo  = "";
			String idSeq = "";
			String cgoTp = crrCntrInfo.getBkgCgoTpCd();      
			String yardCd = crrCntrInfo.getOrgYdCd();          // Original YARD
			String evntDt = crrCntrInfo.getCnmvEvntDt();       // EVENT DATE
			String fmFlag = crrCntrInfo.getFcntrFlg();         // FULL EMPTY FLAG
			String dmgFlag = crrCntrInfo.getCntrDmgFlg();		// DMAGE FLAG
			String dmgFlagDt = "";		// DMAGE FLAG Date
			String dmgUnflagDt = "";		// DMAGE UNFLAG Date
			String ofcCd = null;                               // USER OFFICE
			String lvlCd = null;                               // STS LEVEL
			String spclBkg = "";                             // SPCIAL 부킹 FLAG
			String userId = crrCntrInfo.getUpdUsrId();         // user ID
			String blNo = "";
			String inpType = null;                             // creating type (MAN/EDI/SPP)
			boolean isFindBkg = true;                          
			boolean findBkgCntr = false;
			String cntrPrtFlg = null;
			List<BkgBookingInfoVO> bkgList = null;
			crossItem.setEdiSendStsCd(mvmtStsCd);              

			/*********************************************************
			 * getting container information from MST_CONTAINER *
			 *********************************************************/
			try {
				mstCntrInfo = dbDao.getCntrInfo(cntrNoAft, evntDt, yardCd);

				if (mstCntrInfo == null) {
					rtnVO[0] = "N";
					rtnVO[1] = "Select CONTAINER Table Error!";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				crrCntrInfo.setLstrmCd(mstCntrInfo.getLstmCd());

				if ("OP".equals(mvmtStsCd)) {
					if ("Y".equals(mstCntrInfo.getImdtExtFlg())) {
						rtnVO[0] = "N";
						rtnVO[1] = "Immediately exit container![OP]";
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					} 
				}

				if (svrId == null || "".equals(svrId)) {
					svrId = dbDao.searchSvrId(yardCd);
				}

				if (!svrId.equals(mstCntrInfo.getSvrId()) && !"VD".equals(mvmtStsCd)) {
					if ("MT".equals(mvmtStsCd) && "Y".equals(mstCntrInfo.getCoCreFlg())) {
						// MT of new EQ
						log.info("신조 장비 임");

					} else {
						rtnVO[0] = "N";
						rtnVO[1] = "Container is not located in this area " + svrId + ":" + mstCntrInfo.getSvrId();
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					}
				}

				if ("Y".equals(mstCntrInfo.getCoCreFlg()) && "I".equals(mstCntrInfo.getAciacDivCd()) && "MT".equals(mvmtStsCd)) {
					/* Executing next logic without return in case of new EQ and Inactive status*/
					rtnVO[1] = "B";
					rtnVO[0] = "Y";
				} else if ("I".equals(mstCntrInfo.getAciacDivCd()) && !"Y".equals(mstCntrInfo.getCoCreFlg())) {
					/* checkint inactive status*/
					rtnVO[0] = "N";
					rtnVO[1] = "It can't be saved because this container is inactive status.";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

				crrCntrInfo.setLstrmCd(mstCntrInfo.getLstmCd());

				pstCntrInfo = dbDao.searchMovementStatusMst(cntrNoAft, evntDt);
				
				if ("Y".equals(dmgFlag)) {
					if ("N".equals(mstCntrInfo.getDmgFlg())) {
						dmgFlagDt = crrCntrInfo.getCnmvEvntDt();
						dmgUnflagDt = "";
						
						//MNR 호출 , parameter : crrCntrInfo.getEvntDt() as DM Flg DT, dmgFlag - "Y"
						log.info("MNR 호출 : Flagging" + dmgFlagDt);
						crossItem.setMnrCallYN("Y");
					} else {
						dmgFlagDt = pstCntrInfo.getDmgFlgDt();
						dmgUnflagDt = "";
					}
				} else if ("N".equals(dmgFlag)) {
					if ("Y".equals(mstCntrInfo.getDmgFlg())) {
						dmgFlagDt = pstCntrInfo.getDmgFlgDt();
						dmgUnflagDt = crrCntrInfo.getCnmvEvntDt();
						
						//MNR 호출 , parameter : crrCntrInfo.getEvntDt() as DM Unflg DT, dmgFlag - "N"
						log.info("MNR 호출 : Unflagging" + dmgUnflagDt);
						crossItem.setMnrCallYN("Y");
					} else {
						dmgFlagDt = "";
						dmgUnflagDt = "";
					}
				} else {
					if ("Y".equals(pstCntrInfo.getCntrDmgFlg())){
						dmgFlag = pstCntrInfo.getCntrDmgFlg();
						dmgFlagDt = pstCntrInfo.getDmgFlgDt();
						dmgUnflagDt = "";
					} else {
						dmgFlag = pstCntrInfo.getCntrDmgFlg();
						dmgFlagDt = "";
						dmgUnflagDt = "";
					}
				}

//				if ("OP".equals(mvmtStsCd)) {
//					if ("Y".equals(dmgFlag)) {
//						rtnVO[0] = "N";
//						rtnVO[1] = "Can't release damage container.";
//						crossItem.setRtnStr(rtnVO);
//						return crossItem;
////						crossItem.setMnrCallYN("Y");
//
//					}
//				}
				
				if (pstCntrInfo == null) {
					if ("MT".equals(mvmtStsCd) && "Y".equals(mstCntrInfo.getCoCreFlg())) {
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
				
				//[2015.05.28]소스품질 Modify
				if (pstCntrInfo != null && "VL".equals(mvmtStsCd) && "VL".equals(pstCntrInfo.getMvmtStsCd()) && yardCd.equals(mstCntrInfo.getCrntYdCd())) {
					String msgId = "";
					if(pstCntrInfo != null) {
						msgId = pstCntrInfo.getMvmtInpTpCd();
					}
					if (msgId.equals("MAN") || msgId.equals("SPP")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Already created by manual!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					} else {
						rtnVO[0] = "N";
						rtnVO[1] = "The same data already existed!";
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
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						} else {
							rtnVO[0] = "N";
							rtnVO[1] = "The same data already existed!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
					}
				}

				/***************************************************
				 * permitting VD only in case previous status is VL*
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
						rtnVO[1] = "Event date(VL-VD) is earlier than last event date in CTM.";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					} else {
						rtnVO[0] = "N";
						rtnVO[1] = "Event date is earlier than last event date in CTM.";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
				}
			} catch (Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Container master]").getMessage(), ex);
			}

			/******************************************
			 *  getting last container movement status *
			 ******************************************/
			try {
				if (cntrNoBef != null && cntrNoAft.equals(cntrNoBef)) {
					sameCntr = true;
				} else {
					sameCntr = false;
				}
				if (pstCntrInfo != null) {
					
					idNo  = dbDao.getContainerMaxId(cntrNoAft, crrCntrInfo.getCnmvYr());
					idSeq = dbDao.getContainerMaxSeq(cntrNoAft, crrCntrInfo.getCnmvYr());
					cycNo = pstCntrInfo.getCnmvCycNo();
					crrCntrInfo.setCnmvCycNo(cycNo);
				}
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("There is no previous(1) container movement!").getMessage(), ex);
			}

			try {
				// checking in case of OP only
				if (!sameCntr) {
					if ("MT".equals(mvmtStsCd) && "IC".equals(mstCntrInfo.getCnmvStsCd()) && "SH".equals(mstCntrInfo.getLstmCd())) {
						rtnVO[0] = "N";
						rtnVO[1] = "The MT status without ID is impossible !(SOC)";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}

					
					if ("USA".equals(svrId) && ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) && pstCntrInfo != null && pstCntrInfo.getOrgYdCd() != null && crrCntrInfo.getOrgYdCd().equals(pstCntrInfo.getOrgYdCd()) && ("EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd()) )) {
						rtnVO[0] = "N";
						rtnVO[1] = "The same data already existed!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					} else if (pstCntrInfo != null && pstCntrInfo.getOrgYdCd() != null && mvmtStsCd.equals(pstCntrInfo.getMvmtStsCd()) && crrCntrInfo.getOrgYdCd().equals(pstCntrInfo.getOrgYdCd()) && subStr(crrCntrInfo.getCnmvEvntDt(), 0, 8).equals(subStr(pstCntrInfo.getCnmvEvntDt(), 0, 8))) {
						rtnVO[0] = "N";
						rtnVO[1] = "The same data already existed!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;

					}
				}

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
				 *   checking CREATION TYPE MAN/EDI/SPP   *
				 ******************************************/
				
				if ("ESVCUSER".equals(userId) || "EDIUSER".equals(userId)) {
					ofcCd = dbDao.getOfcCdByYard(yardCd);
					if (ofcCd.equals("E")) {
						rtnVO[0] = "N";
						rtnVO[1] = "Office select error!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}

					if ("ESVCUSER".equals(userId)) {
						inpType = "SPP";
//						crrCntrInfo.setMvmtEdiMsgTpId("SPP");
//						if ("WW".equals(mvmtStsCd) && "M".equals(fmFlag)) {
//							if (!"WW".equals(mvmtStsCd) && !"M".equals(fmFlag)) {
//								// fake logic
//								return crossItem;
//							}
//							
//							// reference no logic 추가 start by 2015/06/18 황미연
//							crrCntrInfo.setMtyPlnNo(bkgNo);							
//						} else if ("MT".equals(mvmtStsCd)) {
//							crrCntrInfo.setMtyPlnNo(bkgNo);		
//							//  reference no logic 추가 end
//						} else {
//							// checking booking no
//							String[] rtn = checkBkgNoFrSpp(cntrNoAft, bkgNo, crrCntrInfo.getBlNo());
//							bkgNo = rtn[2];             
//							crrCntrInfo.setBkgNo(rtn[2]);
//							crrCntrInfo.setMtyPlnNo("");	//  reference no logic 추가 by 2015/06/22
//							if ("N".equals(rtn[0])) {
//								rtnVO[0] = "N";
//								rtnVO[1] = "[ESVC] Booking/BL No Select Error!";
//								crossItem.setRtnStr(rtnVO);
//								return crossItem;
//							}
//						}
					} else {
						inpType = "EDI";
					}
				} else {
					ofcCd = ofc_Cd;
					if  ("COD".equals(crrCntrInfo.getMvmtEdiMsgTpId()) || "322".equals(crrCntrInfo.getMvmtEdiMsgTpId())) {
						inpType = "EDI";
					} else if  ("SPP".equals(crrCntrInfo.getMvmtEdiMsgTpId())) {
						inpType = "SPP";
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


//			try {
//				if ("ESVCUSER".equals(userId)) {
//					if ("WW".equals(mvmtStsCd)) {
//						String ioBound = crrCntrInfo.getObCntrFlg();
//						if ("O".equals(crrCntrInfo.getObCntrFlg())) {
//							String stsCd = checkProcessOut(crrCntrInfo.getObCntrFlg(), crrCntrInfo.getFcntrFlg(), bkgNo, yardCd, crrCntrInfo.getDestYdCd());
//							if (stsCd.length() != 2) {
//								rtnVO[0] = "N";
//								rtnVO[1] = "[ESVC] Outbound EN-TN determine error!";
//								crossItem.setRtnStr(rtnVO);
//								return crossItem;
//							} else {
//								mvmtStsCd = stsCd;
//								crrCntrInfo.setMvmtStsCd(stsCd);
//							}
//						} else if ("I".equals(ioBound)) {
//							String stsCd = checkProcessIn(crrCntrInfo.getObCntrFlg(), bkgNo, cntrNoAft, yardCd, crrCntrInfo.getDestYdCd());
//							if (stsCd.length() != 2) {
//								rtnVO[0] = "N";
//								rtnVO[1] = "[ESVC] Inbound ID-EN-TN determine error!";
//								crossItem.setRtnStr(rtnVO);
//								return crossItem;
//							} else {
//								mvmtStsCd = stsCd;
//								crrCntrInfo.setMvmtStsCd(stsCd);
//							}
//						}
//					}
//				}
//			} catch (EventException e) {
//				log.info("ERRS" + e.getMessage());
//				throw new EventException(new ErrorHandler(e.getMessage()).getMessage(), e);
//			} catch (Exception e) {
//				throw new EventException(new ErrorHandler(e.getMessage()).getMessage(), e);
//			}

			try {
				atbCntrInfo = dbDao.searchMovementStatusVD(cntrNoAft, 2);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("There is no previous(2) container movement!").getMessage(), ex);
			}

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
			// getting previous movement and BKG information before auto creation
			if ("MT".equals(mvmtStsCd)) {
				if (!"Y".equals(mstCntrInfo.getCoCreFlg())) {
					crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
					/**************************************
					 * getting booking cycle              *
					 * getting max value from CTM_MOVEMENT*
					 **************************************/
					cycNo = pstCntrInfo.getCnmvCycNo();
					crrCntrInfo.setCnmvCycNo(cycNo);

					if ((pstCntrInfo.getMvmtStsCd().equals("ID") || pstCntrInfo.getMvmtStsCd().equals("IC") || pstCntrInfo.getMvmtStsCd().equals("TS")) && pstCntrInfo.getFcntrFlg().equals("Y")) {
						bkgNo = pstCntrInfo.getBkgNo();
						log.info("MT BOOKING ::" + bkgNo);
						crrCntrInfo.setBkgNo(bkgNo);
						crrCntrInfo.setBlNo(pstCntrInfo.getBlNo());
						crrCntrInfo.setFcntrFlg(pstCntrInfo.getFcntrFlg());
						/***************************************
						 * getting booking information from BKG_BOOKING *
						 ***************************************/
						try {
							if (bkgNo == null || bkgNo.equals("")) {
								String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
								bkgNo = returnValues[0];
							}
							bkgList = dbDao.searchBkgBookingList(bkgNo, yardCd);

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
					} else if (pstCntrInfo.getFcntrFlg().equals("N") && crrCntrInfo.getLstrmCd().equals("SH")) {	// CSR #14014 Empty Revenue Logic
						/***************************************
						 * getting booking information from BKG_BOOKING *
						 ***************************************/
						try {
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
							if (bkgNo == null || bkgNo.equals("")) {
								rtnVO[0] = "N";
								rtnVO[1] = "This container is shipper's own container. Please attach the container to a Booking first";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								if (dbDao.checkOldBkg(cntrNoAft, bkgNo)) {
									rtnVO[0] = "N";
									rtnVO[1] = "This container is shipper's own container. Please attach the container to a Booking first";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								} else {
									crrCntrInfo.setBkgNo(bkgNo);
									crrCntrInfo.setBlNo(bkgNo);
								}
							}
							
							bkgList = dbDao.searchBkgBookingList(bkgNo, yardCd);

							if (bkgList == null || bkgList.size() < 1) {
								rtnVO[0] = "N";
								rtnVO[1] = "Booking no does not exist";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							bkgInfo = bkgList.get(0);
							cgoTp = bkgInfo.getBkgCgoTpCd();
							
							if (pstCntrInfo.getMvmtStsCd().equals("MT")) {
								crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
								
								if (crrCntrInfo.getTrnkVslCd() == null || "".equals(crrCntrInfo.getTrnkVslCd())) {
									crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
									crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
									crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
								}
								if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo()) || !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
									if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
										cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
										crrCntrInfo.setCnmvCycNo(cycNo);
									}
								} else if (crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd()) || crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())) {
									if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
										if(dbDao.checkBKGRSQL(crrCntrInfo.getCntrNo(), bkgNo, pstCntrInfo.getBkgNo())) {
											cycNo = (String.valueOf(Integer.parseInt(pstCntrInfo.getCnmvCycNo()) + 1));
											crrCntrInfo.setCnmvCycNo(cycNo);
									    }
									}
								}
							}
						} catch (Exception e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Booking no]").getMessage(), e);
						}
					} else {
						bkgNo = "";
						crrCntrInfo.setBkgNo("");
						 
						//Activate 1st August
//						try {
//							String returnValue = dbDao3.checkEqrRefNo(mtyPlnNo, mtyRepoNo);
//
//							if (returnValue == null || returnValue.equals("")) {
//								crrCntrInfo.setMtyPlnNo("");
//								crrCntrInfo.setMtyRepoNo("");
//							}
//						} catch (Exception e) {
//							log.debug(e.getMessage());
//							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [EQR Ref. no]").getMessage(), e);
//						}
						
						//reference no logic 2015/06/18
						if (pstCntrInfo != null && "N".equals(pstCntrInfo.getFcntrFlg()) && ( "EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd()) )) {
							if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") ) {
								if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
									crrCntrInfo.setMtyPlnNo(pstCntrInfo.getMtyPlnNo());
									crrCntrInfo.setMtyRepoNo(pstCntrInfo.getMtyRepoNo());
								}
							}
							if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") ) {
								if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
									rtnVO[0] = "N";
									rtnVO[1] = "EQR Ref. No does not exist";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
						}
						// reference no logic 추가 end
					}
					/* CNTR FULL/EMPTY FLAG SETTING */
					if (crrCntrInfo.getFcntrFlg() == null || crrCntrInfo.getFcntrFlg().equals(""))
						crrCntrInfo.setFcntrFlg(fmFlag);

				}
			} else if (mvmtStsCd.equals("OP") || mvmtStsCd.equals("OC")) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());

				/**************************************
				 * getting booking cycle              *
				 * getting max value from CTM_MOVEMENT*
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();
				crrCntrInfo.setCnmvCycNo(cycNo);

				/***************************************
				 * getting booking information from BKG_BOOKING *
				 ***************************************/
				try {
					bkgList = dbDao.searchBkgBookingList(bkgNo, yardCd);
					svrId = dbDao.searchSvrId(yardCd);

					if (bkgList == null || bkgList.size() < 1) {
						rtnVO[0] = "N";
						rtnVO[1] = "Booking no does not exist(" + mvmtStsCd + "/" + bkgNo + ")";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					
					if (dbDao.checkOldFullBkg(cntrNoAft, bkgNo)) {
						rtnVO[0] = "N";
						rtnVO[1] = "You can't create OP / OC with Old Booking (" + bkgNo + ")";
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
					if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo()) || !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
						if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
							cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
							crrCntrInfo.setCnmvCycNo(cycNo);
						}
					} else if (crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd()) || crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())) {
						if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
							if(dbDao.checkBKGRSQL(crrCntrInfo.getCntrNo(), bkgNo, pstCntrInfo.getBkgNo())) {
								cycNo = (String.valueOf(Integer.parseInt(pstCntrInfo.getCnmvCycNo()) + 1));
								crrCntrInfo.setCnmvCycNo(cycNo);
						    }
						}
					}
					if (cntrNoBef != null && cntrNoAft.equals(cntrNoBef)) {
						if(vslOld != null && bkgInfo != null && dirOld != null && voyOld != null) {//[2015.05.28]소스품질 Modify
							if (!vslOld.equals(bkgInfo.getVslCd()) || !voyOld.equals(bkgInfo.getSkdVoyNo()) || !dirOld.equals(bkgInfo.getSkdDirCd())) {
								rtnVO[0] = "N";
								rtnVO[1] = "Different trunk VVDs were matched to one container!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
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
							String bkgStr = "";
							for (int idxBkg = 0; idxBkg < multiBkg.size(); idxBkg++) {
								if (!bkgNo.equals(multiBkg.get(idxBkg).getBkgNo()) )
									bkgStr = bkgStr + "," + multiBkg.get(idxBkg).getBkgNo();
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
				 *   getting special booking properties     *
				 ***************************************/
				if (crrCntrInfo.getSpclCgoFlg() != null && !crrCntrInfo.getSpclCgoFlg().equals("") && !crrCntrInfo.getSpclCgoFlg().equals("null")) {
					try {
						spclBkg = dbDao.searchSpclBkg(cntrNoAft, bkgCntrInfo.getCnmvCycNo(), crrCntrInfo.getCnmvCycNo());

						//if (spclBkg == null || spclBkg == "" || spclBkg == "-1") {
						if (spclBkg == null || "".equals(spclBkg) || "-1".equals(spclBkg)) {
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
				 * getting VLS data for comparing VVD  *
				 * excluding EN/TN. excluding no VSL CODE *
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

					if (mvmtStsCd.equals("OC")) {
						fmFlag = "F";
						crrCntrInfo.setFcntrFlg(fmFlag);
					}
				} catch (Exception e) {
					log.error(e.getMessage(),e);
					throw new EventException(new ErrorHandler("Full flag is null").getMessage(), e);
				}
				
				if ("SH".equals(mstCntrInfo.getLstmCd()) && "P".equals(cgoTp)) {
					rtnVO[0] = "N";
					rtnVO[1] = "This Container is Shipper's Own Container, You can't create empty repo status!";
					crossItem.setRtnStr(rtnVO);
					return crossItem;
				}

			} else if ("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
				/*******************************************
				 * getting booking information             *
				 * in case of no booking no                *
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
				 * getting booking cycle               *
				 * getting max value from CTM_MOVEMENT *
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();

				/******************************************
				 * adding 1 to cycle no in case status is OP*
				 ******************************************/
				crrCntrInfo.setCnmvCycNo(cycNo);

				/****************************************
				 * getting booking information from BKG_BOOKGING *
				 ****************************************/
				try {
					svrId = dbDao.searchSvrId(yardCd);
				} catch (Exception e) {
					throw new EventException(new ErrorHandler("Area does not exist [" + yardCd + "]!").getMessage(), e);
				}

				try {
					bkgList = dbDao.searchBkgBookingList(bkgNo, yardCd);

					if (bkgList == null || bkgList.size() < 1) {
						rtnVO[0] = "N";
						rtnVO[1] = "Booking infomation does not exists [" + bkgNo + "]";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					bkgInfo = bkgList.get(0);
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
					if (!crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || !crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo()) || !crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd())) {
						if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
							cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
							crrCntrInfo.setCnmvCycNo(cycNo);
						}
					} else if (crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd()) || crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())) {
						if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
							if(dbDao.checkBKGRSQL(crrCntrInfo.getCntrNo(), bkgNo, pstCntrInfo.getBkgNo())) {
								cycNo = (String.valueOf(Integer.parseInt(pstCntrInfo.getCnmvCycNo()) + 1));
								crrCntrInfo.setCnmvCycNo(cycNo);
						    }
						}
					}
				} catch (DAOException e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Search booking list" + bkgNo+ "]").getMessage(), e);
				}

				crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());

				/********************************************
				 *  getting VSL for comparing VVD           *
				 *  excluding EN/TN. excluding no VSL CODE  *
				 ********************************************/
				try {
					crrCntrInfo.setTrnkSkdDirCd(pstCntrInfo.getTrnkSkdDirCd());
					crrCntrInfo.setTrnkSkdVoyNo(pstCntrInfo.getTrnkSkdVoyNo());
					crrCntrInfo.setTrnkVslCd(pstCntrInfo.getTrnkVslCd());
					crrCntrInfo.setBkgRcvTermCd(pstCntrInfo.getBkgRcvTermCd());
					crrCntrInfo.setCntrActCd(pstCntrInfo.getCntrActCd());
					crrCntrInfo.setCntrDispFlg(pstCntrInfo.getCntrDispFlg());
//					crrCntrInfo.setCntrDmgFlg(pstCntrInfo.getCntrDmgFlg());
					crrCntrInfo.setCntrDmgFlg(dmgFlag);
					crrCntrInfo.setDmgFlgDt(dmgFlagDt);
					crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
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
				 *  getting LEVEL according to STS      *
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
					 * no throwing in case of failure for handling next data       *
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
					if("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd)) {
						fmFlag = "F";
					}
				} catch (Exception ex) {
					/***************************************************************
					 * no throwing in case of failure for handling next data       *
					 ***************************************************************/
					log.info("ERROR GET FMFLAG");
					log.error("err " + ex.toString(), ex);
				}

				/* CNTR FULL/EMPTY FLAG SETTING */
				if (crrCntrInfo.getFcntrFlg() == null || "".equals(crrCntrInfo.getFcntrFlg()))
					crrCntrInfo.setFcntrFlg(fmFlag);
				if("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd)) {
					crrCntrInfo.setFcntrFlg(fmFlag);
				}
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

					crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
					crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
					crrCntrInfo.setBlNo(bkgInfo.getBlNo());
					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
//					crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
					crrCntrInfo.setCntrDmgFlg(dmgFlag);
					crrCntrInfo.setDmgFlgDt(dmgFlagDt);
					crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
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
				} catch (Exception e) {
					log.debug(e.getMessage());
					throw new EventException(new ErrorHandler("Container infomation does not exist! [" + cntrNoAft + "]").getMessage(), e);
				}
			} else if ("VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd)) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
				/*******************************************
				 * getting booking no                    *
				 *******************************************/
				if (!nBkgNoFlg) {
					try {
						//  if (bkgNo == null || bkgNo.equals(""))
						String CrntVvdCd = null;
						String[] returnValues = null;
						CrntVvdCd = crrCntrInfo.getCrntVslCd() + crrCntrInfo.getCrntSkdVoyNo() + crrCntrInfo.getCrntSkdDirCd();
						if (CrntVvdCd.length() == 9) {
							returnValues = dbDao.getBkgNoByCntrNoAndCrntVvdCd(cntrNoAft, CrntVvdCd);
						}
						else {
							returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							
						}
						
						bkgNo = returnValues[0];
						crrCntrInfo.setBbulkFlg(returnValues[1]);    

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
				 * getting bookin cycle information   *
				 * getting max value from CTM_MOVEMENT*
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();

				/********************************************
				 * adding 1 to cycle no in case status is OP*
				 ********************************************/
				crrCntrInfo.setCnmvCycNo(cycNo);
				if (!nBkgNoFlg) {
					/***********************************************
					 * getting booking information from BKG_BOOKING*
					 ***********************************************/
					try {
						svrId = dbDao.searchSvrId(yardCd);
					}catch (Exception e) {
						throw new EventException(new ErrorHandler("Area does not exist [" + yardCd + "]!").getMessage(), e);
					}
					try {
						bkgList = dbDao.searchBkgBookingList(bkgNo, yardCd);

						if (bkgList == null || bkgList.size() < 1) {
							rtnVO[0] = "N";
							rtnVO[1] = "Booking no does not exist [" + bkgNo + "]!";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						bkgInfo = bkgList.get(0);
						cgoTp = bkgInfo.getBkgCgoTpCd();

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
							if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
								cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
								crrCntrInfo.setCnmvCycNo(cycNo);
							}
						} else if (crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd()) || crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())) {
							if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
								if(dbDao.checkBKGRSQL(crrCntrInfo.getCntrNo(), bkgNo, pstCntrInfo.getBkgNo())) {
									cycNo = (String.valueOf(Integer.parseInt(pstCntrInfo.getCnmvCycNo()) + 1));
									crrCntrInfo.setCnmvCycNo(cycNo);
							    }
							}
						}
					} catch (DAOException e) {
						log.debug(e.getMessage());
						throw new EventException(new ErrorHandler("Booking no does not exist [" + bkgNo + "]!").getMessage(), e);
					}

					
					if ("SH".equals(mstCntrInfo.getLstmCd()) && "P".equals(cgoTp)) {
						rtnVO[0] = "N";
						rtnVO[1] = "This container is shipper's own container, You can't create empty repo status!";
						crossItem.setRtnStr(rtnVO);
						return crossItem;
					}
					/**********************************************
					 *  getting VSL information for comparing VVD *
					 **********************************************/
					try {
						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						vvdVO = dbDao.getVVDInfo(crrCntrInfo);
						if (vvdVO == null || vvdVO.size() == 0) {
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
					 *   getting booking container's last information                  *
					 *   in case STS CD is VL or VD                                    *
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
					 *   getting last information from BKG_CONTAINER , BKG_BOOKING     *
					 *******************************************************************/
					try {
						multiBkg = dbDao.searchMultiBkgNo(cntrNoAft, cycNo, mvmtStsCd, bkgNo);

						if (multiBkg != null && multiBkg.size() > 0) {
							MultiBkgNoVO multi = (MultiBkgNoVO) multiBkg.get(0);
							if (multiBkg.size() > 1) {
								String bkgStr = "";
								for (int idxBkg = 0; idxBkg < multiBkg.size(); idxBkg++) {
									if (!bkgNo.equals(multiBkg.get(idxBkg).getBkgNo()) )
										bkgStr = bkgStr + "," + multiBkg.get(idxBkg).getBkgNo();
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
					 * getting special booking information *
					 ***************************************/
					if (crrCntrInfo.getSpclCgoFlg() != null && !crrCntrInfo.getSpclCgoFlg().equals("") && !crrCntrInfo.getSpclCgoFlg().equals("null")) {
						try {
							spclBkg = dbDao.searchSpclBkg(cntrNoAft, bkgCntrInfo.getCnmvCycNo(), crrCntrInfo.getCnmvCycNo());

							//if (spclBkg == "" || spclBkg == "-1") {
							if("".equals(spclBkg) || "-1".equals(spclBkg)) {
								crrCntrInfo.setSpclCgoFlg("N");
							} else {
								crrCntrInfo.setSpclCgoFlg("Y");
							}
						} catch (Exception e) {
							log.debug(e.getMessage());
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Spcial cargo]").getMessage(), e);
						}
					}

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
									String bkgNos = "";
									//[2015.05.28]소스품질 Modify
									StringBuffer sb = new StringBuffer();
									for (int idxMul = 0; idxMul < multiBkg.size(); idxMul++) {
										sb.append(multiBkg.get(idxMul).getBkgNo()).append(" ");
										if (idxMul < multiBkg.size() - 1) sb.append(", ");
										//bkgNos = bkgNos + multiBkg.get(idxMul).getBkgNo() + " ";
										//if (idxMul < multiBkg.size() - 1) bkgNos = bkgNos + ", ";
									}
									bkgNos = sb.toString();
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
					 *  getting LEVEL according to STS      *
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
						 * no throwing in case of failure for handling next data       *
						 ***************************************************************/
						//log.info("Unexpected system error occurred during data processing. [" + cgoTp + "/" + mvmtStsCd + "]");
						log.error("err " + e.toString(), e);
					}

					/***************************************************************
					 * getting FULL/EMPTY FLAG. setting Empty in case of error     *
					 ***************************************************************/
					try {
						if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg()))
							fmFlag = crrCntrInfo.getFcntrFlg();
						else if (fmFlag==null || fmFlag.equals(""))
							fmFlag = cntrMovSeqVO.getFcntrFlg();
					} catch (Exception e) {
						/***************************************************************
						 * no throwing in case of failure for handling next data *
						 ***************************************************************/
						//log.info("Full flag is null");
						log.error("err " + e.toString(), e);
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
//						crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
						crrCntrInfo.setCntrDmgFlg(dmgFlag);
						crrCntrInfo.setDmgFlgDt(dmgFlagDt);
						crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
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

					/*** 2015.04.28 Changed by Mark Lee : Change to process the VD Movement for MT  Start
					* As-Is
					 * 
					 * To-Be (Null 체크추가)
					 * if(bkgInfo!=null) {
					***/
					if(bkgInfo!=null) {
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
								/* Power Session 위하여 처리 Split도 VD 처리 가능하도록 변경 By Mark LEE	
								} else if (bkgNo.length() == 12 && subStr(bkgNo, 10, 12).equals("00")) {
									rtnVO[0] = "N";
									rtnVO[1] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								*/	
								} else if (bkgNo.length() < 10 || bkgNo.length() > 13) { // 2015.01.13 OSCAR의 경우는 10자리 bkgNo가 들어옴
									rtnVO[0] = "N";
									rtnVO[1] = "[VD] Please split MTY REPO BKG No firstly to update VD movement!";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
						}
						autoParam[13] = bkgInfo.getBlNo();						
					}
				}
			} else if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
				crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
				String vslCd 	 = "";
				String skdVoyCd  = "";
				String skdDirCd  = "";

				/*******************************************
				 *   getting booking information           *
				 *   in case of no booking no              *
				 *   can be no data in case of OP or OC    *
				 *******************************************/
				try {
					bkgNo = pstCntrInfo.getBkgNo();
					if (bkgNo == null) bkgNo = "";
					String prevSts = pstCntrInfo.getMvmtStsCd();

					log.info("PREV :::" + prevSts);
					log.info("FULL :::" + crrCntrInfo.getFcntrFlg());
					log.info("FULL :::" + pstCntrInfo.getFcntrFlg());

					if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg()))
						fmFlag = crrCntrInfo.getFcntrFlg();
					else if (fmFlag==null || fmFlag.equals(""))
						fmFlag = pstCntrInfo.getFcntrFlg();
					
					if ("N".equals(crrCntrInfo.getFcntrFlg()) || "M".equals(crrCntrInfo.getFcntrFlg())) {
						if (crrCntrInfo.getLstrmCd().equals("SH")) {	// CSR #14014 Empty Revenue Logic							
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
							if (bkgNo == null || bkgNo.equals("")) {
								rtnVO[0] = "N";
								rtnVO[1] = "This container is shipper's own container. Please attach the container to a Booking first";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								if (dbDao.checkOldBkg(cntrNoAft, bkgNo)) {
									rtnVO[0] = "N";
									rtnVO[1] = "This container is shipper's own container. Please attach the container to a Booking first";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								} else {
									crrCntrInfo.setBkgNo(bkgNo);
								}
							}
						} else {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");
						}
					}  else if ("Y".equals(crrCntrInfo.getFcntrFlg()) || "F".equals(crrCntrInfo.getFcntrFlg())) {
						// bkgNo = dbDao.getBkgNoByCntrNo(cntrNoAft); 
						if (!"ID".equals(prevSts) && crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							if (returnValues[0] == null || returnValues[0].equals("")) {
								bkgNo = pstCntrInfo.getBkgNo();
							} else if (dbDao.checkOldFullBkg(cntrNoAft, returnValues[0])) {
								rtnVO[0] = "N";
								rtnVO[1] = "Please attach the container to a Booking first";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								bkgNo = returnValues[0];
							}
						}
						crrCntrInfo.setBkgNo(bkgNo);
					} else if ("MT".equals(prevSts) || (("EN".equals(prevSts) || "TN".equals(prevSts)) && "N".equals(pstCntrInfo.getFcntrFlg()))) {
						if (crrCntrInfo.getLstrmCd().equals("SH")) {	// CSR #14014 Empty Revenue Logic
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
							if (bkgNo == null || bkgNo.equals("")) {
								rtnVO[0] = "N";
								rtnVO[1] = "This container is shipper's own container. Please attach the container to a Booking first";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							} else {
								if (dbDao.checkOldBkg(cntrNoAft, bkgNo)) {
									rtnVO[0] = "N";
									rtnVO[1] = "This container is shipper's own container. Please attach the container to a Booking first";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								} else {
									crrCntrInfo.setBkgNo(bkgNo);
								}
							}
						} else {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");
						}
					} else {
						if ("C".equals(subStr(prevSts, 0, 1))) {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");
						} else if (("EN".equals(prevSts) || "TN".equals(prevSts)) && "Y".equals(pstCntrInfo.getFcntrFlg()) && (bkgNo == null || "".equals(bkgNo))) {
							if (!"ID".equals(prevSts) && crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
								String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
								if (returnValues[0] == null || returnValues[0].equals("")) {
									bkgNo = pstCntrInfo.getBkgNo();
								} else if (dbDao.checkOldFullBkg(cntrNoAft, returnValues[0])) {
									rtnVO[0] = "N";
									rtnVO[1] = "Please attach the container to a Booking first";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								} else {
									bkgNo = returnValues[0];
								}
							}
						}
						crrCntrInfo.setBkgNo(bkgNo);
					}
				} catch(Exception e) {
					throw new EventException(new ErrorHandler("Booking no check error! [" + cntrNoAft + "]").getMessage(), e);
				}
				log.info("부킹 번호 :" + bkgNo);
				/**************************************
				 *  getting bookin cycle information  *
				 * getting max value from CTM_MOVEMENT*
				 **************************************/
				cycNo = pstCntrInfo.getCnmvCycNo();

				/********************************************
				 * adding 1 to cycle no in case status is OP*
				 ********************************************/
				crrCntrInfo.setCnmvCycNo(cycNo);

				/***********************************************
				 * getting booking information from BKG_BOOKING*
				 ***********************************************/
				if (bkgNo != null && !bkgNo.equals("")) {
					try {
						svrId = dbDao.searchSvrId(yardCd);
					}catch (Exception e) {
						throw new EventException(new ErrorHandler("Area does not exist [" + yardCd + "]!").getMessage(), e);
					}
					try {
						
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
						} else if (crrCntrInfo.getTrnkVslCd().equals(pstCntrInfo.getTrnkVslCd()) || crrCntrInfo.getTrnkSkdDirCd().equals(pstCntrInfo.getTrnkSkdDirCd()) || crrCntrInfo.getTrnkSkdVoyNo().equals(pstCntrInfo.getTrnkSkdVoyNo())) {
							if (!bkgNo.equals(pstCntrInfo.getBkgNo()) ) {
								if(dbDao.checkBKGRSQL(crrCntrInfo.getCntrNo(), bkgNo, pstCntrInfo.getBkgNo())) {
									if (pstCntrInfo.getFcntrFlg().equals("Y") && (pstCntrInfo.getBkgNo() == null || "".equals(pstCntrInfo.getBkgNo())) && bkgNo.equals(atbCntrInfo.getBkgNo())) {
										log.info("Full EN : BKG NO IS NOT CHANGE");
									} else {
										cycNo = String.valueOf(Integer.parseInt(crrCntrInfo.getCnmvCycNo()) + 1);
									}
							    }
							}
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
//						crrCntrInfo.setCntrDmgFlg(pstCntrInfo.getCntrDmgFlg());
						crrCntrInfo.setCntrDmgFlg(dmgFlag);
						crrCntrInfo.setDmgFlgDt(dmgFlagDt);
						crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
						crrCntrInfo.setCntrHngrRckFlg(pstCntrInfo.getCntrHngrRckFlg());
						crrCntrInfo.setCntrRfubFlg(pstCntrInfo.getCntrRfubFlg());
						crrCntrInfo.setImdtExtFlg(pstCntrInfo.getImdtExtFlg());
						crrCntrInfo.setCnmvCycNo(pstCntrInfo.getCnmvCycNo());
//						crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());

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
				} catch (Exception e) {
					/***************************************************************
					 * no throwing in case of failure for handling next data *
					 ***************************************************************/
					//log.info(e.getMessage());
					log.error("err " + e.toString(), e);
				}
				// saving previous status for STOCK UPDATE
				crossItem.setPrevSts(pstCntrInfo.getMvmtStsCd());

				autoParam[13] = blNo;
				autoParam[10] = vslCd;
				autoParam[11] = skdVoyCd;
				autoParam[12] = skdDirCd;
			}

			/***************************************************************
			 * calling auto creation - BCImpl.autoCre()
			 ***************************************************************/
			if (!"Y".equals(mstCntrInfo.getCoCreFlg()) && isFirst) {
				CheckBookingVO bkgVO = null;
				autoParam[3] = fmFlag;
				String[] autoCreRtnVal = new String[6];
				try {
					CrossItemVO item = autoCre(crrCntrInfo, pstCntrInfo, mstCntrInfo, bkgInfo, bkgVO, atbCntrInfo, autoParam);
					for (int i=0; i<item.getCusCtmMovementVOs().size(); i++){
						cgmVo.add(item.getCusCtmMovementVOs().get(i));
					}					
					
					autoCreRtnVal = item.getRtnStr();
					if (autoCreRtnVal[0] != null && autoCreRtnVal[0].equals("N")) {
						crossItem.setRtnStr(autoCreRtnVal);
						return crossItem;
					}
					
					//pstCntrInfo re-setting after autoCre()
					CusCtmMovementVO pstCntrAftAutoCre = dbDao.searchMovementStatusMst(cntrNoAft, evntDt);
					pstCntrInfo.setMvmtStsCd(pstCntrAftAutoCre.getMvmtStsCd());
					pstCntrInfo.setOrgYdCd(pstCntrAftAutoCre.getOrgYdCd());

//					if ("OP".equals(autoCreRtnVal[2]) && "Y".equals(dmgFlag)) {
//						rtnVO[0] = "N";
//						rtnVO[1] = "Can't release damage container.";
//						crossItem.setRtnStr(rtnVO);
//						return crossItem;
//						// flag for calling MNR in case Status is OP and damage flag in MST_CONTAINER is Y
////						crossItem.setMnrCallYN("Y");
//					}

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
			 * end of auto creation  - BCImpl.autoCre()
			 ***************************************************************/

			crossItem.setEdiSendVslCd(crrCntrInfo.getCrntVslCd());          // VslCd setting
			crossItem.setEdiSendSkdVoyNo(crrCntrInfo.getCrntSkdVoyNo());    // SkdVoyNo setting
			crossItem.setEdiSendSkdDirCd(crrCntrInfo.getCrntSkdDirCd());    // SkdDirCd setting
			
			// after auto creation 
			if ("MT".equals(mvmtStsCd)) {
				if (cntrNoAft.equals(cntrNoBef)) continue;
				if ("Y".equals(mstCntrInfo.getCoCreFlg())) {
					crrCntrInfo.setCntrTpszCd(mstCntrInfo.getCntrTpszCd());
					crrCntrInfo.setBkgNo("");
					try {
						if (crrCntrInfo.getFcntrFlg() != null && !"".equals(crrCntrInfo.getFcntrFlg())) {
							fmFlag = crrCntrInfo.getFcntrFlg();
						}
					} catch (Exception e) {
						/***************************************************************
						 * no throwing in case of failure for handling next data *
						 ***************************************************************/
						//log.info("ERROR GET FMFLAG");
						log.error("err " + e.toString(), e);
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
					crrCntrInfo.setCntrDmgFlg(dmgFlag);
					crrCntrInfo.setDmgFlgDt(dmgFlagDt);
					crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);

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
							
							CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
							cgmVo.add(tempVO);

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
					
					//Activate after 1st August
//					try {
//						String returnValue = dbDao3.checkEqrRefNo(mtyPlnNo, mtyRepoNo);
//
//						if (returnValue == null || returnValue.equals("")) {
//							crrCntrInfo.setMtyPlnNo("");
//							crrCntrInfo.setMtyRepoNo("");
//						}
//					} catch (Exception e) {
//						log.debug(e.getMessage());
//						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [EQR Ref. no]").getMessage(), e);
//					}
					
					//reference no logic 추가 start by 2015/06/18 황미연
					if (pstCntrInfo != null && "N".equals(pstCntrInfo.getFcntrFlg()) && ( "EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd()) ) && !crrCntrInfo.getLstrmCd().equals("SH")) {
						if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") ) {
							if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
								crrCntrInfo.setMtyPlnNo(pstCntrInfo.getMtyPlnNo());
								crrCntrInfo.setMtyRepoNo(pstCntrInfo.getMtyRepoNo());
							}
						}
						if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") ) {
							if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
								rtnVO[0] = "N";
								rtnVO[1] = "EQR Ref. No does not exist";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
						}
					}
					// reference no logic 추가 end

					crrCntrInfo.setObCntrFlg("I");
					if ( "ID".equals(pstCntrInfo.getMvmtStsCd()) || ((pstCntrInfo.getMvmtStsCd().equals("MT")||pstCntrInfo.getMvmtStsCd().equals("TN")||pstCntrInfo.getMvmtStsCd().equals("EN")) && (pstCntrInfo.getFcntrFlg().equals("N")||pstCntrInfo.getFcntrFlg().equals("M")) && crrCntrInfo.getLstrmCd().equals("SH")) ) {	// CSR #14014 Empty Revenue Logic
						try {
						bkgNo = pstCntrInfo.getBkgNo();
						if (bkgNo == null || "".equals(bkgNo)) {
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
						}
						crrCntrInfo.setBkgNo(bkgNo);
						crrCntrInfo.setBlNo(pstCntrInfo.getBlNo());
						crrCntrInfo.setFcntrFlg(pstCntrInfo.getFcntrFlg());

						crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());
						/**********************************************
						 *  getting VSL information for comparing VVD *
						 **********************************************/
						crrCntrInfo.setTrnkSkdDirCd(pstCntrInfo.getTrnkSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(pstCntrInfo.getTrnkSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(pstCntrInfo.getTrnkVslCd());
						crrCntrInfo.setBkgRcvTermCd(pstCntrInfo.getBkgRcvTermCd());
						crrCntrInfo.setCntrActCd(pstCntrInfo.getCntrActCd());
						crrCntrInfo.setCntrDispFlg(pstCntrInfo.getCntrDispFlg());
//						crrCntrInfo.setCntrDmgFlg(pstCntrInfo.getCntrDmgFlg());
						crrCntrInfo.setCntrDmgFlg(dmgFlag);
						crrCntrInfo.setDmgFlgDt(dmgFlagDt);
						crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
						crrCntrInfo.setCntrHngrRckFlg(pstCntrInfo.getCntrHngrRckFlg());
						crrCntrInfo.setCntrRfubFlg(pstCntrInfo.getCntrRfubFlg());
						crrCntrInfo.setImdtExtFlg(pstCntrInfo.getImdtExtFlg());
						crrCntrInfo.setCnmvCycNo(pstCntrInfo.getCnmvCycNo());
						crrCntrInfo.setBkgCgoTpCd(pstCntrInfo.getBkgCgoTpCd());
						
						if ((pstCntrInfo.getMvmtStsCd().equals("MT")||pstCntrInfo.getMvmtStsCd().equals("TN")||pstCntrInfo.getMvmtStsCd().equals("EN")) && (pstCntrInfo.getFcntrFlg().equals("N")||pstCntrInfo.getFcntrFlg().equals("M")) && crrCntrInfo.getLstrmCd().equals("SH")) {
							if (crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
								boolean ObCntrFlg = dbDao.checkObCntrFlg(crrCntrInfo.getCntrNo(), crrCntrInfo.getBkgNo());
								if (ObCntrFlg) {
									crrCntrInfo.setObCntrFlg("I");
								} else {
									crrCntrInfo.setObCntrFlg("Y");
								}
							}
						}
						
						} catch (Exception e) {
							log.error(e.getMessage(),e);
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), e);
						}
					}

					lvlCd = "0";
					/****************************************
					 *  getting LEVEL according to STS      *
					 ****************************************/
					CntrMvmtSeqInfoVO cntrMovSeqVO = new CntrMvmtSeqInfoVO();
					try {
						cntrMovSeqVO = dbDao.getCNTRMovSeqRSQL(cgoTp, mvmtStsCd);
						if (cntrMovSeqVO == null) {
							//if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) { 20150507 Park Young Jin
							if ("MT".equals(mvmtStsCd)) {
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
						 * no throwing in case of failure for handling next data *
						 ***************************************************************/
						//log.debug("GET LEVEL FAIL");
						log.error("err " + e.toString(), e);
					}

					try {
						if (crrCntrInfo.getFcntrFlg() != null && !crrCntrInfo.getFcntrFlg().equals(""))
							fmFlag = crrCntrInfo.getFcntrFlg();
						else if (fmFlag==null || fmFlag.equals(""))
							fmFlag = cntrMovSeqVO.getFcntrFlg();
					} catch (Exception e) {
						/***************************************************************
						 * no throwing in case of failure for handling next data *
						 ***************************************************************/
						log.info("ERROR GET FMFLAG");
					}

					if (pstCntrInfo != null && ("OP".equals(pstCntrInfo.getMvmtStsCd()) || (("EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd())) && !crrCntrInfo.getLstrmCd().equals("SH")))) {	// CSR #14014 Empty Revenue Logic
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
//					crrCntrInfo.setObCntrFlg("I");
					crrCntrInfo.setOfcCd(ofcCd);
					crrCntrInfo.setUpdUsrId(userId);
					crrCntrInfo.setUsrNm(userNm);
					crrCntrInfo.setCntrDmgFlg(dmgFlag);
					crrCntrInfo.setDmgFlgDt(dmgFlagDt);
					crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);

					crrCntrInfo.setIbflag("I");
					// saving previous status for STOCK UPDATE
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
							
							CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
							cgmVo.add(tempVO);
							//dbDao.updateMstContainer(ctmVO);
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setUpdateMaster(true);

						}
						
						log.debug("888888888888881111111111111 MT "); 
						// ADDING Logic 2012.12.03 TN change to EN 
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
						
						// ADDING Logic  2013.01.14 EN change to TN						
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
							// setting MT as status after updating CM
							crrCntrInfo.setMvmtStsCd("MT");
						}
					} catch (Exception ex) {
						log.error(ex.getMessage(),ex);
						throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), ex);
					}
				}

			} else if ("OP".equals(mvmtStsCd) || "OC".equals(mvmtStsCd)) {
				/****************************************
				 *  getting LEVEL according to STS      *
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
						cntrPrtFlg  = "N";
					} else {
						findBkgCntr = true;
						cntrPrtFlg  = bkgCntrStr[3];
					}
				} catch (Exception e) {
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [" + bkgNo + "/" + cntrNoAft + "]").getMessage(), e);
				}

				/*****************************
				 * getting CONFIRM from BKG  *
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

					/**********************************************
					 *  setting parameters before inputting DATA  *
					 **********************************************/
					crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
					crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
					crrCntrInfo.setBlNo(bkgInfo.getBlNo());
					crrCntrInfo.setCnmvLvlNo(lvlCd);
					crrCntrInfo.setCnmvCycNo(cycNo);
					crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
//					crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
					crrCntrInfo.setCntrDmgFlg(dmgFlag);
					crrCntrInfo.setDmgFlgDt(dmgFlagDt);
					crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
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
						// inputting in CTM_MOVEMENT 
						idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
						idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
						crrCntrInfo.setCnmvIdNo(idNo);
						crrCntrInfo.setCnmvSeq(idSeq);
						
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
						
						CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
						cgmVo.add(tempVO);

						rtnVO[2] = rtnVO[2] + "U";
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
					// setting true for Confirm Check as Default 
					if ("OP".equals(mvmtStsCd)) {
						if (!isConfirm) {
							// Inserting Into Bkg_Cntr in case Confirm Check is True
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
								// Inserting Into Bkg_Cntr in case Confirm Check is True
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
				
				if(atbCntrInfo != null )	// 
				{
				
					if(!"MT".equals(atbCntrInfo.getMvmtStsCd()) && !"OP".equals(crrCntrInfo.getMvmtStsCd()))
					{
	
						if ("TN".equals(pstCntrInfo.getMvmtStsCd())) { // 
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
						
						// 
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
				}

			} else if ("ID".equals(mvmtStsCd) || "IC".equals(mvmtStsCd) || "TS".equals(mvmtStsCd)) {

				if (cntrNoAft.equals(cntrNoBef)) continue;

				try {
					errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
					if (sameCntr == false) {
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
//						crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
						crrCntrInfo.setCntrDmgFlg(dmgFlag);
						crrCntrInfo.setDmgFlgDt(dmgFlagDt);
						crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
						crrCntrInfo.setCntrHngrRckFlg(vvdInfo.getCntrHngrRckCd());
						crrCntrInfo.setCntrRfubFlg(vvdInfo.getRfubFlg());
						crrCntrInfo.setCntrSvrId(svrId);
						crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
						crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
						crrCntrInfo.setMvmtInpTpCd(inpType);

						if ("TS".equals(mvmtStsCd)) {
							crrCntrInfo.setObCntrFlg(pstCntrInfo.getObCntrFlg());
							crrCntrInfo.setFcntrFlg(pstCntrInfo.getFcntrFlg());
						} 
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
						
						CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
						cgmVo.add(tempVO);
						rtnVO[2] = rtnVO[2] + "U";
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
					// creating XX in case of SH EQ
					if ("SH".equals(mstCntrInfo.getLstmCd())) {
						crrCntrInfo.setMvmtStsCd("XX");
						crossItem.setEdiSendLstrmCd(mstCntrInfo.getLstmCd());    // LstrmCd setting for sendEDIToKOR
						try {
							crrCntrInfo.setMvmtCreTpCd("C");
							crrCntrInfo.setCntrDispFlg("Y");
							crrCntrInfo.setAciacDivCd("I");
							idNo = String.valueOf(Integer.parseInt(idNo) + 1);
							idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
							crrCntrInfo.setCnmvIdNo(idNo);
							crrCntrInfo.setCnmvSeq(idSeq);
							dbDao.addCtmMovement(crrCntrInfo);
							
							CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
							cgmVo.add(tempVO);

							crrCntrInfo.setNewFlg("X");    
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setUpdateMaster(true);
						} catch (DAOException e) {
							/***************************************************************
							 * no throwing in case of failure for handling next data *
							 ***************************************************************/
							log.error(e.getMessage(),e);
							rtnVO[0] = "N";
							rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						} catch (Exception ex) {
							/***************************************************************
							 * no throwing in case of failure for handling next data *
							 ***************************************************************/
							log.error(ex.getMessage(),ex);
							rtnVO[0] = "N";
							rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
							crossItem.setRtnStr(rtnVO);
							return crossItem;
						}
						
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
				
				if ("TS".equals(mvmtStsCd) || "IC".equals(mvmtStsCd)) 
				{
					log.debug("888888888888881111111111111 MT "); 
					// ADDING Logic 2012.12.03 TN change to EN 
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
					
					// ADDING Logic  2013.01.14 EN change to TN						
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
				}

			} else if ("VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd)){
				if (cntrNoAft.equals(cntrNoBef)) continue;

				/*************************************************************
				 * skip in case of VL and not existing of booking no
				 **************************************************************/
				/*************************************************************
				 * skip in case of VL and not existing of booking no
				 **************************************************************/
				/*** 2015.04.28 Changed by Mark Lee : Change to process the VD Movement for MT
				 * As-Is
				 * 1) if (nBkgNoFlg && "VL".equals(mvmtStsCd)) {
				 * 2) crrCntrInfo.setCnmvLvlNo("");
				 * To-Be
				 * 1) if (nBkgNoFlg && ( "VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd))) {
				 * 2) crrCntrInfo.setCnmvLvlNo(lvlCd);				 
				 * New) Add VD logic  추가 --> 2015.04.28 Changed by Mark Lee : Add VD logic Start 및 END 참조
				***/				
				if (nBkgNoFlg && ( "VL".equals(mvmtStsCd) || "VD".equals(mvmtStsCd))) {

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
							lvlCd = dbDao.getCNTRMovSeqRSQL("P", crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
							if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
							crrCntrInfo.setCnmvLvlNo(lvlCd);
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
							crrCntrInfo.setCntrDmgFlg(dmgFlag);
							crrCntrInfo.setDmgFlgDt(dmgFlagDt);
							crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);

							if (sameCntr == false) {
								idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
								idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
								crrCntrInfo.setCnmvIdNo(idNo);
								crrCntrInfo.setCnmvSeq(idSeq);
								dbDao.addCtmMovement(crrCntrInfo);
								
								CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
								cgmVo.add(tempVO);
								crossItem.setEdiSendLstrmCd("N");    // LstrmCd setting for sendEDIToKOR

								rtnVO[2] = rtnVO[2] + "U";
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}

							rtnVO[2] = rtnVO[2] + "U";
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setMstBkgCntrOpUpdate(false);
							crossItem.setFindBkgCntr(true);

						} catch (DAOException e) {
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), e);
						} catch (Exception ex) {
							rtnVO[1] = "Unexpected system error occurred during data processing.["+mvmtStsCd+" Creation error]";
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]").getMessage(), ex);
						}
					} else {
						/*** 2015.04.28 Changed by Mark Lee : Add VD logic Start ***/
						try {
						    if (fmFlag == null || "".equals(fmFlag)) {
						    	crrCntrInfo.setFcntrFlg("M");
						    } else {
						    	crrCntrInfo.setFcntrFlg(fmFlag);
						    }
							crrCntrInfo.setBkgCgoTpCd("P");
							if (!"P".equals(pstCntrInfo.getBkgCgoTpCd())) {
								rtnVO[0] = "N";
								rtnVO[1] = "Cargo Type Unmatch Error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
							crrCntrInfo.setBkgRcvTermCd("");
							crrCntrInfo.setBlNo("");
							lvlCd = dbDao.getCNTRMovSeqRSQL("P", crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
							if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
							crrCntrInfo.setCnmvLvlNo(lvlCd);
							crrCntrInfo.setCnmvCycNo(String.valueOf(Integer.parseInt(cycNo) + 1));
							crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
							crrCntrInfo.setCntrSvrId(svrId);
							crrCntrInfo.setCtrtOfcCtyCd(mstCntrInfo.getAgmtCtyCd());
							crrCntrInfo.setCtrtSeq(mstCntrInfo.getAgmtSeq());
							crrCntrInfo.setMvmtInpTpCd(inpType);
							crrCntrInfo.setObCntrFlg("I");
							crrCntrInfo.setOfcCd(ofcCd);
							crrCntrInfo.setCreUsrId(userId);
							crrCntrInfo.setUpdUsrId(userId);
							crrCntrInfo.setUsrNm(userNm);
							crrCntrInfo.setImdtExtFlg("N");
							crrCntrInfo.setPreStsFlg("Y");
							crrCntrInfo.setTrnkVslCd(crrCntrInfo.getCrntVslCd());
							crrCntrInfo.setTrnkSkdVoyNo(crrCntrInfo.getCrntSkdVoyNo());
							crrCntrInfo.setTrnkSkdDirCd(crrCntrInfo.getCrntSkdDirCd());
							crrCntrInfo.setCntrDmgFlg(dmgFlag);
							crrCntrInfo.setDmgFlgDt(dmgFlagDt);
							crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
						
							if (sameCntr == false) {
							     idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
							     idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
							     crrCntrInfo.setCnmvIdNo(idNo);
							     crrCntrInfo.setCnmvSeq(idSeq);                                       
							     dbDao.addCtmMovement(crrCntrInfo);
									
									CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
									cgmVo.add(tempVO);
							     crossItem.setEdiSendLstrmCd("N");    // LstrmCd setting for sendEDIToKOR
							
							     rtnVO[2] = rtnVO[2] + "U";
							     crossItem.setCusCtmMovementVO(crrCntrInfo);
							     crossItem.setUpdateMaster(true);
							}
						
						} catch (DAOException e) {
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. VD Add Logic1. ["+mvmtStsCd+" Creation error]").getMessage(), e);
						} catch (Exception ex) {
							rtnVO[1] = "Unexpected system error occurred during data processing. VD Add Logic1. ["+mvmtStsCd+" Creation error]";
							throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. VD Add Logic1. ["+mvmtStsCd+" Creation error]").getMessage(), ex);
						}    

						try {
							crrCntrInfo.setMvmtStsCd("MT");
							crrCntrInfo.setFcntrFlg("M");                                  
							errMsg = "MT flag is null ["+crrCntrInfo.getMvmtStsCd()+"]";
							lvlCd = dbDao.getCNTRMovSeqRSQL("P", crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
							if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
							crrCntrInfo.setCnmvLvlNo(lvlCd);
							crrCntrInfo.setMvmtCreTpCd("C");
//							crrCntrInfo.setCrntSkdDirCd("");
//							crrCntrInfo.setCrntSkdVoyNo("");
//							crrCntrInfo.setCrntVslCd("");
							errMsg = "Unexpected system error occurred during data processing. VD Add Logic2 ["+crrCntrInfo.getMvmtStsCd()+" Creation error]";
							if (sameCntr == false) {
							     idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
							     idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
							     crrCntrInfo.setCnmvIdNo(idNo);
							     crrCntrInfo.setCnmvSeq(idSeq);
									crrCntrInfo.setCntrDmgFlg(dmgFlag);
									crrCntrInfo.setDmgFlgDt(dmgFlagDt);
									crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
							     dbDao.addCtmMovement(crrCntrInfo);
									
									CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
									cgmVo.add(tempVO);
							
							     rtnVO[2] = rtnVO[2] + "U";
							     crossItem.setCusCtmMovementVO(crrCntrInfo);
							     crossItem.setUpdateMaster(true);
							}

							rtnVO[2] = rtnVO[2] + "U";
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setMstBkgCntrOpUpdate(true);
							crossItem.setFindBkgCntr(true);
						} catch (Exception ex) {
							throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
						}                             						
						/*** 2015.04.28 Changed by Mark Lee : Add VD logic END   ***/						
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
								crrCntrInfo.setCntrDmgFlg(dmgFlag);
								crrCntrInfo.setDmgFlgDt(dmgFlagDt);
								crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
								dbDao.addCtmMovement(crrCntrInfo);
								
								CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
								cgmVo.add(tempVO);
								crossItem.setEdiSendLstrmCd("N");   // LstrmCd setting for sendEDIToKOR
								rtnVO[2] = rtnVO[2] + "U";
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}
							rtnVO[2] = rtnVO[2] + "U";
							crossItem.setCusCtmMovementVO(crrCntrInfo);
							crossItem.setMstBkgCntrOpUpdate(true);
							crossItem.setFindBkgCntr(true);

						} catch (Exception ex) {
							log.error(ex.getMessage(),ex);
							throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
						}

					} else {
						// checking next vessel existence
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
							if (!crrCntrInfo.getBkgCgoTpCd().equals(pstCntrInfo.getBkgCgoTpCd())) {
								rtnVO[0] = "N";
								rtnVO[1] = "Cargo Type Unmatch Error!";
								crossItem.setRtnStr(rtnVO);
								return crossItem;
							}
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
								crrCntrInfo.setCntrDmgFlg(dmgFlag);
								crrCntrInfo.setDmgFlgDt(dmgFlagDt);
								crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
								dbDao.addCtmMovement(crrCntrInfo);
								
								CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
								cgmVo.add(tempVO);
								crossItem.setEdiSendLstrmCd("N");   // LstrmCd setting for sendEDIToKOR
							}
						} catch (Exception ex) {
							throw new EventException(new ErrorHandler(errMsg).getMessage(), ex);
						}

						if ("Y".equals(extVd)) {
							crrCntrInfo.setMvmtStsCd("TS");
						} else {
							try {
								crrCntrInfo.setMvmtCreTpCd("C");
//								crrCntrInfo.setCrntSkdDirCd("");
//								crrCntrInfo.setCrntSkdVoyNo("");
//								crrCntrInfo.setCrntVslCd("");
								if ("Y".equals(bkgCntrInfo.getBbCgoFlg())) {
									// IC add
									errMsg = "Full flag is null [IC]";
									crrCntrInfo.setMvmtStsCd("IC");
									//lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
									//errMsg = "Unexpected system error occurred during data processing. [IC Creation error]";
									if(dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()) != null){
										lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
								    } else {
								    	if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
								    		lvlCd = "0";
								    	} else {
								    		errMsg =  "Cargo Type and Status Unmatch Error!";
								    	}
								    }

									idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
									idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
									crrCntrInfo.setCnmvIdNo(idNo);
									crrCntrInfo.setCnmvSeq(idSeq);
									crrCntrInfo.setCntrDmgFlg(dmgFlag);
									crrCntrInfo.setDmgFlgDt(dmgFlagDt);
									crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
									dbDao.addCtmMovement(crrCntrInfo);
									
									CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
									cgmVo.add(tempVO);
									// ID add
									errMsg = "Full flag is null [ID]";
									crrCntrInfo.setMvmtStsCd("ID");
									//lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
									//errMsg = "Unexpected system error occurred during data processing. [ID Creation error]";
									if(dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()) != null){
										lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
								    } else {
								    	if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
								    		lvlCd = "0";
								    	} else {
								    		errMsg =  "Cargo Type and Status Unmatch Error!";
								    	}
								    }
									idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
									idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
									crrCntrInfo.setCnmvIdNo(idNo);
									crrCntrInfo.setCnmvSeq(idSeq);
									dbDao.addCtmMovement(crrCntrInfo);
									
									CusCtmMovementVO tempVO2 = (CusCtmMovementVO)crrCntrInfo.clone();
									cgmVo.add(tempVO2);

									crrCntrInfo.setMvmtStsCd("MT");
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
							//errMsg = "Full flag is null ["+crrCntrInfo.getMvmtStsCd()+"]";
							//lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
							//if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
							if(dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()) != null){
								lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, crrCntrInfo.getMvmtStsCd()).getCnmvLvlNo();
						    } else {
						    	if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
						    		lvlCd = "0";
						    	} else {
						    		errMsg =  "Cargo Type and Status Unmatch Error!";
						    	}
						    }
							crrCntrInfo.setCnmvLvlNo(lvlCd);
							crrCntrInfo.setMvmtCreTpCd("C");
//							crrCntrInfo.setCrntSkdDirCd("");
//							crrCntrInfo.setCrntSkdVoyNo("");
//							crrCntrInfo.setCrntVslCd("");
							errMsg = "Unexpected system error occurred during data processing. ["+crrCntrInfo.getMvmtStsCd()+" Creation error]";
							if (sameCntr == false) {
								idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
								idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
								crrCntrInfo.setCnmvIdNo(idNo);
								crrCntrInfo.setCnmvSeq(idSeq);
								crrCntrInfo.setCntrDmgFlg(dmgFlag);
								crrCntrInfo.setDmgFlgDt(dmgFlagDt);
								crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
								dbDao.addCtmMovement(crrCntrInfo);
								
								CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
								cgmVo.add(tempVO);

								// creating XX in case BkgCgoTpCd = R and  LstmCd = SH
								if (!"TS".equals(crrCntrInfo.getMvmtStsCd()) && ("R".equals(bkgCntrInfo.getBkgCgoTpCd()) && "SH".equals(mstCntrInfo.getLstmCd()))) {
									
									String finalYd = dbDao3.searchFinalFacility( crrCntrInfo.getBkgNo(), crrCntrInfo.getCntrNo() );
									
									if ( finalYd == null || finalYd.equals("") || finalYd.equals(crrCntrInfo.getOrgYdCd()) ) {		// When Origin Yard is Final Destination
										crrCntrInfo.setMvmtStsCd("XX");
										crossItem.setEdiSendLstrmCd(mstCntrInfo.getLstmCd());   // LstrmCd setting for sendEDIToKOR

										crrCntrInfo.setMvmtCreTpCd("C");
										crrCntrInfo.setCntrDispFlg("Y");
										crrCntrInfo.setAciacDivCd("I");
										idNo = String.valueOf(Integer.parseInt(idNo) + 1);
										idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
										crrCntrInfo.setCnmvIdNo(idNo);
										crrCntrInfo.setCnmvSeq(idSeq);
										crrCntrInfo.setCntrDmgFlg(dmgFlag);
										crrCntrInfo.setDmgFlgDt(dmgFlagDt);
										crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
										crrCntrInfo.setCrntSkdDirCd("");
										crrCntrInfo.setCrntSkdVoyNo("");
										crrCntrInfo.setCrntVslCd("");

										int rowEffected = dbDao.addCtmMovement(crrCntrInfo);
										
										CusCtmMovementVO tempVO2 = (CusCtmMovementVO)crrCntrInfo.clone();
										cgmVo.add(tempVO2);
										if (rowEffected < 1) {
											rtnVO[0] = "N";
											rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
											crossItem.setRtnStr(rtnVO);
											return crossItem;
										}

										crrCntrInfo.setNewFlg("X");    
										crossItem.setCusCtmMovementVO(crrCntrInfo);
										crossItem.setUpdateMaster(true);
									}						
								}
								rtnVO[2] = rtnVO[2] + "U";
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}

							rtnVO[2] = rtnVO[2] + "U";
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
				
				//Activate after 1st August
//				try {
//					String returnValue = dbDao3.checkEqrRefNo(mtyPlnNo, mtyRepoNo);
//
//					if (returnValue == null || returnValue.equals("")) {
//						crrCntrInfo.setMtyPlnNo("");
//						crrCntrInfo.setMtyRepoNo("");
//					}
//				} catch (Exception e) {
//					log.debug(e.getMessage());
//					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [EQR Ref. no]").getMessage(), e);
//				}

				/* CNTR FULL/EMPTY FLAG SETTING */
				if (crrCntrInfo.getFcntrFlg() == null || crrCntrInfo.getFcntrFlg().equals("")) {
					crrCntrInfo.setFcntrFlg(fmFlag);
				}
				
				try {
					pstCntrInfo = dbDao.searchMovementStatusMst(cntrNoAft, evntDt);
					String prevSts = pstCntrInfo.getMvmtStsCd();
					if ("N".equals(crrCntrInfo.getFcntrFlg()) || "M".equals(crrCntrInfo.getFcntrFlg())) {
						if (crrCntrInfo.getLstrmCd().equals("SH")) {	// CSR #14014 Empty Revenue Logic
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
							crrCntrInfo.setBkgNo(bkgNo);
							if (crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
								boolean ObCntrFlg = dbDao.checkObCntrFlg(crrCntrInfo.getCntrNo(), crrCntrInfo.getBkgNo());
								if (ObCntrFlg) {
									crrCntrInfo.setObCntrFlg("I");
								} else {
									crrCntrInfo.setObCntrFlg("Y");
								}
							}
						} else {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");

							if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") ) {
								if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
									rtnVO[0] = "N";
									rtnVO[1] = "EQR Ref. No does not exist";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
						}
					} else if ( "Y".equals(crrCntrInfo.getFcntrFlg()) || "F".equals(crrCntrInfo.getFcntrFlg()) ) {
//						if (!"ID".equals(prevSts) && crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
//							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
//							if (returnValues[0] == null || returnValues[0].equals("")) {
//								bkgNo = pstCntrInfo.getBkgNo();
//							} else if (dbDao.checkOldFullBkg(cntrNoAft, returnValues[0])) {
//								rtnVO[0] = "N";
//								rtnVO[1] = "Please attach the container to a Booking first";
//								crossItem.setRtnStr(rtnVO);
//								return crossItem;
//							} else {
//								bkgNo = returnValues[0];
//							}
//						}
						crrCntrInfo.setBkgNo(bkgNo);
					} else if ( "MT".equals(prevSts) || (("EN".equals(prevSts) || "TN".equals(prevSts)) && "N".equals(pstCntrInfo.getFcntrFlg())) ) {
						if (crrCntrInfo.getLstrmCd().equals("SH")) {	// CSR #14014 Empty Revenue Logic
							String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
							bkgNo = returnValues[0];
							crrCntrInfo.setBkgNo(bkgNo);
							if (crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
								boolean ObCntrFlg = dbDao.checkObCntrFlg(crrCntrInfo.getCntrNo(), crrCntrInfo.getBkgNo());
								if (ObCntrFlg) {
									crrCntrInfo.setObCntrFlg("I");
								} else {
									crrCntrInfo.setObCntrFlg("Y");
								}
							}
						} else {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");

							if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") ) {
								if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
									rtnVO[0] = "N";
									rtnVO[1] = "EQR Ref. No does not exist";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
						}
					} else {
						if ("C".equals(subStr(prevSts, 0, 1))) {
							bkgNo = "";
							crrCntrInfo.setBkgNo("");
							crrCntrInfo.setBkgKnt("0");
							
							if ( crrCntrInfo.getMtyPlnNo() == null || crrCntrInfo.getMtyPlnNo().equals("") && !crrCntrInfo.getLstrmCd().equals("SH") ) {
								if ( crrCntrInfo.getMtyRepoNo() == null || crrCntrInfo.getMtyRepoNo().equals("") ) {
									rtnVO[0] = "N";
									rtnVO[1] = "EQR Ref. No does not exist";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
							}
//						} else if (("EN".equals(prevSts) || "TN".equals(prevSts)) && "Y".equals(pstCntrInfo.getFcntrFlg()) && "".equals(bkgNo)) {
//							if (!"ID".equals(prevSts) && crrCntrInfo.getBkgNo() != null && !"".equals(crrCntrInfo.getBkgNo())) {
//								String[] returnValues = dbDao.getBkgNoByCntrNo(cntrNoAft);
//								if (returnValues[0] == null || returnValues[0].equals("")) {
//									bkgNo = pstCntrInfo.getBkgNo();
//								} else if (dbDao.checkOldFullBkg(cntrNoAft, returnValues[0])) {
//									rtnVO[0] = "N";
//									rtnVO[1] = "Please attach the container to a Booking first";
//									crossItem.setRtnStr(rtnVO);
//									return crossItem;
//								} else {
//									bkgNo = returnValues[0];
//								}
//							}
						}
						crrCntrInfo.setBkgNo(bkgNo);
					}
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Last movement(Auto)]").getMessage(), ex);
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
					if (("MT".equals(pstCntrInfo.getMvmtStsCd())&&!crrCntrInfo.getLstrmCd().equals("SH")) ||  (bkgNo == null || "".equals(bkgNo) || "null".equals(bkgNo))) {	// CSR #14014 Empty Revenue Logic
						crrCntrInfo.setTrnkSkdDirCd("");
						crrCntrInfo.setTrnkSkdVoyNo("");
						crrCntrInfo.setTrnkVslCd("");
						crrCntrInfo.setBkgCgoTpCd("");
						crrCntrInfo.setBkgKnt("0");
						crrCntrInfo.setBlNo("");
						crrCntrInfo.setCntrDmgFlg(dmgFlag);
						crrCntrInfo.setDmgFlgDt(dmgFlagDt);
						crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
					} else {
						crrCntrInfo.setTrnkSkdDirCd(bkgInfo.getSkdDirCd());
						crrCntrInfo.setTrnkSkdVoyNo(bkgInfo.getSkdVoyNo());
						crrCntrInfo.setTrnkVslCd(bkgInfo.getVslCd());
						crrCntrInfo.setBkgCgoTpCd(bkgInfo.getBkgCgoTpCd());
						crrCntrInfo.setBkgRcvTermCd(bkgInfo.getRcvTermCd());
						crrCntrInfo.setBlNo(bkgInfo.getBlNo());
						crrCntrInfo.setCntrActCd(vvdInfo.getAgmtCtyCd());
						crrCntrInfo.setCntrDispFlg(vvdInfo.getDispFlg());
//						crrCntrInfo.setCntrDmgFlg(vvdInfo.getDmgFlg());
						crrCntrInfo.setCntrDmgFlg(dmgFlag);
						crrCntrInfo.setDmgFlgDt(dmgFlagDt);
						crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
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
						
						CusCtmMovementVO tempVO = (CusCtmMovementVO)crrCntrInfo.clone();
						cgmVo.add(tempVO);

						if ("R".equals(crrCntrInfo.getBkgCgoTpCd()) && "SH".equals(mstCntrInfo.getLstmCd()) && "I".equals(crrCntrInfo.getObCntrFlg())) {
							String finalYd = dbDao3.searchFinalFacility( crrCntrInfo.getBkgNo(), crrCntrInfo.getCntrNo() );
							
							if ( finalYd == null || finalYd.equals("") || finalYd.equals(crrCntrInfo.getOrgYdCd()) ) {		// When Origin Yard is Final Destination														
								if ("EN".equals(crrCntrInfo.getMvmtStsCd())) {
									crrCntrInfo.setMvmtStsCd("TN");      
									crrCntrInfo.setCreUsrId(userId);     
									dbDao.updateContainer(crrCntrInfo, "1", ""); 
								}							
								
								crrCntrInfo.setMvmtStsCd("XX");
								crossItem.setEdiSendLstrmCd(mstCntrInfo.getLstmCd());   // LstrmCd setting for sendEDIToKOR

								crrCntrInfo.setMvmtCreTpCd("C");
								crrCntrInfo.setCntrDispFlg("Y");
								crrCntrInfo.setAciacDivCd("I");
								idNo = String.valueOf(Integer.parseInt(idNo) + 1);
								idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
								crrCntrInfo.setCnmvIdNo(idNo);
								crrCntrInfo.setCnmvSeq(idSeq);
								crrCntrInfo.setCntrDmgFlg(dmgFlag);
								crrCntrInfo.setDmgFlgDt(dmgFlagDt);
								crrCntrInfo.setDmgUnflgDt(dmgUnflagDt);
								crrCntrInfo.setCrntSkdDirCd("");
								crrCntrInfo.setCrntSkdVoyNo("");
								crrCntrInfo.setCrntVslCd("");

								int rowEffected = dbDao.addCtmMovement(crrCntrInfo);
								
								CusCtmMovementVO tempVO2 = (CusCtmMovementVO)crrCntrInfo.clone();
								cgmVo.add(tempVO2);
								if (rowEffected < 1) {
									rtnVO[0] = "N";
									rtnVO[1] = "Unexpected system error occurred during data processing. [" + mvmtStsCd + " Creation error]";
									crossItem.setRtnStr(rtnVO);
									return crossItem;
								}
								crrCntrInfo.setNewFlg("X");    
								crossItem.setCusCtmMovementVO(crrCntrInfo);
								crossItem.setUpdateMaster(true);
							}			
						}					
						
						crossItem.setCusCtmMovementVO(crrCntrInfo);
						crossItem.setUpdateMaster(true);
					}

					crossItem.setCusCtmMovementVO(crrCntrInfo);
					if ( ("MT".equals(pstCntrInfo.getMvmtStsCd()) || (("EN".equals(pstCntrInfo.getMvmtStsCd()) || "TN".equals(pstCntrInfo.getMvmtStsCd())) && "".equals(pstCntrInfo.getBkgNo()))) && !crrCntrInfo.getLstrmCd().equals("SH")) {	// CSR #14014 Empty Revenue Logic
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
		
		crossItem.setCusCtmMovementVOs(cgmVo);
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
	 * getting booking list having same Container No, CycNo
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
	 * saving movement history in case Event Date changed
	 *
	 * @param AutoCreStsListVO[] autoCreStsListVOs
	 * @param account SignOnUserAccount
	 * @return List<AutoCreStsListVO>
	 * @exception EventException
	 */
	public List<AutoCreStsListVO> manageAutoCreSts(AutoCreStsListVO[] autoCreStsListVOs,SignOnUserAccount account) throws EventException {
		try {
			List<AutoCreStsListVO> updateVoList = new ArrayList<AutoCreStsListVO>();
			for ( int i=0; i<autoCreStsListVOs .length; i++ ) {
				autoCreStsListVOs[i].setUpdUsrId(account.getUsr_id());
				autoCreStsListVOs[i].setOfcCd(account.getOfc_cd());
				autoCreStsListVOs[i].setUsrNm(account.getUsr_nm());
				log.info("CNTR NO :::" + autoCreStsListVOs[i].getCntrNo());
				log.info("CNMV NO :::" + autoCreStsListVOs[i].getCnmvId());
				updateVoList.add(autoCreStsListVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifygetAutoCreStsS(updateVoList);
			}
			
			return updateVoList;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * returning substring in case total character is smaller than specified substring length
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
	 * differing errMsg according to previous Sts and current Sts (using in autoCreation)<br>
	 *
	 * @param String preSts
	 * @param String currSts
	 * @param String yardCdEq    // S:Same / D:Different
	 * @param String fullEmptyFlag
	 * @return String
	 **/
	private String getErrMsg( String preSts, String currSts, String yardCdEq, String fullEmptyFlag ) {
		preSts = (preSts == null) ? "" : preSts.trim();
		currSts = (currSts == null) ? "" : currSts.trim();
		yardCdEq = (yardCdEq == null) ? "" : yardCdEq.trim();
		String errMsg = "";

		/*
		if ( "CE".equals(preSts) ) {
			if ( "CD".equals(currSts) || "MT".equals(currSts) || "OC".equals(currSts) || "OP".equals(currSts) || "TN".equals(currSts) ) {
				errMsg = "Please create 'CI' status and retry";
			}
		} 2015/07/23 */ 
		if ( "CE".equals(preSts) ) {
			if ( "CD".equals(currSts) ) {
				errMsg = "Please create 'CI' status and retry";
			} else if ( "OC".equals(currSts) || "OP".equals(currSts) || "TN".equals(currSts) ) {
				errMsg = "Please create 'CI' or 'MT' status and retry";
			}
		} else if ( "CI".equals(preSts) ) {
			if ( "MT".equals(currSts) || "OP".equals(currSts) || "TN".equals(currSts) || "EN".equals(currSts) ) { // 2014.11.05  => "EN" 추가
				errMsg = "Please create 'CD' status and retry";
			}
		} else if ( "CP".equals(preSts) ) {
			if ( "CD".equals(currSts) || "CI".equals(currSts) ) {
				errMsg = "Please create 'CO' status and retry";
			} else if ( "EN".equals(currSts) || "OC".equals(currSts) || "TN".equals(currSts) ) { // 2014.11.05  => "TN" 추가
				errMsg = "Please create 'MT' or 'CO' status and retry";
			}
		} else if ( "EN".equals(preSts) ) {
			if ( "TN".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'EN/TN' status at same yard";
			}
		} else if ( "IC".equals(preSts) ) {
			if ( "IC".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'IC' status at same yard";
			} else if ( "OC".equals(currSts) || "OP".equals(currSts) ) {
				errMsg = "Please create 'ID' and 'MT' status and retry";
			}
		} else if ( "ID".equals(preSts) ) {
			if ( "ID".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'ID' status at same yard";
			}
		} else if ( "MT".equals(preSts) ) {
			if ( "MT".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'MT' status at same yard";
			} else if ( "VL".equals(currSts) && ("F".equals(fullEmptyFlag) || "Y".equals(fullEmptyFlag)) ) {
				errMsg = "Please create 'OP/OC' status and retry";
			}
		} else if ( "OC".equals(preSts) ) {
			if ( "OC".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'OC' status at same yard";
			}
		} else if ( "OP".equals(preSts) ) {
			if ( "CD".equals(currSts) || "CE".equals(currSts) || "CI".equals(currSts) || "CO".equals(currSts) || "CP".equals(currSts) || "CT".equals(currSts) ) { // 2014.11.05  => "CT" 추가
				errMsg = "Please create 'MT' status and retry";
			} else if ( "OP".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'OP' status at same yard";
			}
		} else if ( "TN".equals(preSts) ) {
			if ( "TN".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'EN/TN' status at same yard";
			}
		} else if ( "TS".equals(preSts) ) {
			if ( "TS".equals(currSts) && "S".equals(yardCdEq) ) {
				errMsg = "Already 'TS' status at same yard";
			}
		}

		if ( "".equals(errMsg) ) {
			errMsg = "Movement creation error [auto creation] [" + preSts + "],[" + currSts + "]";
		}
		return errMsg;
	}
	
	/**
	 * Domestic Movement 에서 신규 입력되는 Movement 정보 입력<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String cntCd
	 * @return CrossItemVO
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	public CrossItemVO manageDomesticMVMT(CusCtmMovementVO cusCtmMovementVO, String cntCd) throws EventException{

		String[] strRtn = new String[3];

		strRtn[0] = "";
		strRtn[1] = "";
		strRtn[2] = "";
		CrossItemVO item = new CrossItemVO();
		// SERVER NAME을 얻어온다. D : DEN 그외 : ENT
		String yardCd = cusCtmMovementVO.getOrgYdCd();
		String svrId  = null;
//		String chkDgt = cusCtmMovementVO.getCheckDigit();
		String cntrNo = cusCtmMovementVO.getCntrNo();
//		if (chkDgt != null && !chkDgt.equals("") && !chkDgt.equals("null"))
//			cntrNo = cusCtmMovementVO.getCntrNo() + chkDgt;
//		cusCtmMovementVO.setCntrNo(cntrNo);
//		cusCtmMovementVO.setCheckDigit("");
		String evntDt = cusCtmMovementVO.getCnmvEvntDt();
		String mvmtStsCd = cusCtmMovementVO.getMvmtStsCd();
		String fmFlag = null;
		String cycNo = null;
		String idNo = null;
		String idSeq = null;
		String inpType = null;
		String[] lccRcc = null;
		String[] localTime = null;
		String cntrDmgFlg = cusCtmMovementVO.getCntrDmgFlg();		// DMAGE FLAG
		String dmgFlag = "";		// MST DMAGE FLAG
		String dmgFlagDt = "";		// DMAGE FLAG Date
		String dmgUnflagDt = "";		// DMAGE UNFLAG Date
		MstContainerInfoVO cntrVO = null;          // MST 컨테이너 정보 (MST_CONTAINER)
		CusCtmMovementVO ctmMov = null;            // 마지막 MOVEMENT 정보 (CTM_MOVEMENT)
		CtmCntrMovInfoVO ediVO = null;             // 전전 컨테이너 정보 (CTM_MOVEMENT)
//		cusCtmMovementVO.setCntrNo(cusCtmMovementVO.getCntrNo() + cusCtmMovementVO.getCheckDigit());
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
			try {
				ofcCd = dbDao.getOfcCdByYard(yardCd);
				if (ofcCd.equals("E")) {
					strRtn[0] = "N";
					strRtn[1] = "Office select error!";
					item.setRtnStr(strRtn); return item;
				}
				if  (cusCtmMovementVO.getMvmtEdiTpCd() != null && !"".equals(cusCtmMovementVO.getMvmtEdiTpCd().trim())) {
					inpType = "EDI";
				} else {
					inpType = "MAN";
				}
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("Office select error!").getMessage(), ex);
			}
		}
		cusCtmMovementVO.setOfcCd(ofcCd);
		cusCtmMovementVO.setMvmtInpTpCd(inpType);

		/******************************************
		 *   컨테이너마스터 정보를 읽어온다         *
		 ******************************************/
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
			dmgFlag = cntrVO.getDmgFlg();

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("Unexpected system error occurred during data processing. [Container master]").getMessage(), ex);
		}

		try {
			svrId= dbDao.searchSvrId(yardCd);
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
				if (localTime[2].equals("1")) {
					strRtn[0] = "N";
					strRtn[1] ="Input date must be earlier than system date!";
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
					item.setRtnStr(strRtn);
					return item;
				}

				if (Long.parseLong(cntrVO.getEvntDt()) > Long.parseLong(cntrVO.getCompDt())) {
					if (mvmtStsCd.equals("VL") || mvmtStsCd.equals("VD")) {
						strRtn[0] = "N";
						strRtn[1] = "Event date(VL-VD) is earlier than last event date in CTM.";
						item.setRtnStr(strRtn); return item;
					} else {
						strRtn[0] = "N";
						strRtn[1] = "Event date is earlier than last event date in CTM.";
						item.setRtnStr(strRtn); return item;
					}
				}

				if ("Y".equals(cntrDmgFlg)) {
					if ("N".equals(dmgFlag)) {
						dmgFlagDt = cusCtmMovementVO.getCnmvEvntDt();
						dmgUnflagDt = "";
						
						//MNR 호출 , parameter : crrCntrInfo.getEvntDt() as DM Flg DT, dmgFlag - "Y"
						log.info("MNR 호출 : Flagging" + dmgFlagDt);
						item.setMnrCallYN("Y");
					} else {
						dmgFlagDt = ctmMov.getDmgFlgDt();
						dmgUnflagDt = "";
					}
				} else if ("N".equals(cntrDmgFlg)) {
					if ("Y".equals(dmgFlag)) {
						dmgFlagDt = ctmMov.getDmgFlgDt();
						dmgUnflagDt = cusCtmMovementVO.getCnmvEvntDt();
						
						//MNR 호출 , parameter : crrCntrInfo.getEvntDt() as DM Unflg DT,  - "N"
						log.info("MNR 호출 : Unflagging" + dmgUnflagDt);
						item.setMnrCallYN("Y");
					} else {
						dmgFlagDt = "";
						dmgUnflagDt = "";
					}
				} else {
					if ("Y".equals(ctmMov.getCntrDmgFlg())){
						cntrDmgFlg = ctmMov.getCntrDmgFlg();
						dmgFlagDt = ctmMov.getDmgFlgDt();
						dmgUnflagDt = "";
					} else {
						cntrDmgFlg = ctmMov.getCntrDmgFlg();
						dmgFlagDt = "";
						dmgUnflagDt = "";
					}
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

		/************************
		 * FULL/EMPTY 정보 조회 *
		 ************************/
		if (mvmtStsCd.equals("CP") || mvmtStsCd.equals("CM")) {
			fmFlag = "N";
		} else {
			fmFlag = "Y";
		}
		if (mvmtStsCd.equals("CE") || mvmtStsCd.equals("CT")) {
			fmFlag = ctmMov.getBkgCgoTpCd();
		}
		/*****************************************************************************
		 * 전 상태가 ID 이고 입력할 대상이 CO일때 DOM BOOKING의 ST_TURN_FLG를 조회한다  *
		 *****************************************************************************/
		String checkFlg = "N";
		String evntDtBak = cusCtmMovementVO.getCnmvEvntDt();
		if (ctmMov.getMvmtStsCd().equals("ID") && mvmtStsCd.equals("CO")) {
			try {
				checkFlg = dbDao.checkDomBooking(cntrNo, evntDtBak, ctmMov.getCnmvEvntDt());
			} catch (Exception ex) {
				/*******************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 *******************************************************/
				log.error("err " + ex.toString(), ex);
			}
		}

		/***************************
		 *  자동생성 로직 실행      *
		 ***************************/
		try {
			String yardCdEq = null;

			if (yardCd.equals(ctmMov.getOrgYdCd()))
				yardCdEq = "S";
			else
				yardCdEq = "D";

			String ppSts = "";
			if (ediVO != null && ediVO.getMvmtStsCd() != null)
				ppSts = ediVO.getMvmtStsCd();

			// errMsg = "Movement creation error [auto creation][" + ctmMov.getMvmtStsCd() + "], [" + mvmtStsCd + "]";
			errMsg = getErrMsg( ctmMov.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag );
			autoItem = dbDao.checkAutoCreItem(mvmtStsCd, ctmMov.getMvmtStsCd(), ppSts, yardCdEq, fmFlag, ctmMov.getFcntrFlg());

			AutoCreItemVO act = null;
			if (autoItem == null || autoItem.size() == 0) {
				// 처리할 내역이 없다. ERROR. [2015.05.28]소스품질 Modify
				//if (autoItem.size() == 0) {
					strRtn[0] = "N";
					strRtn[1] = errMsg;
					item.setRtnStr(strRtn); return item;
				//}
			} else {
				CusCtmMovementVO cusVO = null;
				String tmpBkgNo = cusCtmMovementVO.getBkgNo();
				String tmpBlNo = cusCtmMovementVO.getBlNo();
				for (int i = 0; i < autoItem.size(); i++) {
					act = autoItem.get(i);
					String autoSts = subStr(act.getAuto(), 0, 2);
					if (act.getTar().equals("C")) {
						cusVO = (CusCtmMovementVO) cusCtmMovementVO.clone();
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
						strRtn[1] = getErrMsg( ctmMov.getMvmtStsCd(), mvmtStsCd, yardCdEq, fmFlag );
						item.setRtnStr(strRtn); return item;
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
					cusVO.setCntrDmgFlg(cntrDmgFlg);
					cusVO.setDmgFlgDt(dmgFlagDt);
					cusVO.setDmgUnflgDt(dmgUnflagDt);

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
						if (!autoSts.equals("MT") && !autoSts.equals("CM")) {
							cusVO.setBkgNo(cusCtmMovementVO.getBkgNo());
							cusVO.setBlNo(cusCtmMovementVO.getBlNo());
						}
						cusVO.setCnmvEvntDt(evntDt);
						cusVO.setCnmvCycNo(cycNo);
						String lvlCd = null;
						String cgoTp = "";
						//lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, cusVO.getMvmtStsCd()).getCnmvLvlNo();
						//errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" Creation error]";
						//if (lvlCd == null || lvlCd.equals("")) lvlCd = "0";
						errMsg = "Full flag is null";
						if(dbDao.getCNTRMovSeqRSQL(cgoTp, cusVO.getMvmtStsCd()) != null) {
							lvlCd = dbDao.getCNTRMovSeqRSQL(cgoTp, cusVO.getMvmtStsCd()).getCnmvLvlNo();
					    } else {
					    	if ("EN".equals(mvmtStsCd) || "TN".equals(mvmtStsCd)) {
					    		lvlCd = "0";
					    	} else {
					    		errMsg =  "Cargo Type and Status Unmatch Error!";
					    	}
					   }
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
						
						if (cusVO.getMvmtStsCd().equals("MT") && autoSts.equals("MT"))
						{
							cusVO.setBkgNo(ctmMov.getBkgNo());
							cusVO.setBlNo(ctmMov.getBlNo());
						}
						
						dbDao.addCtmMovement(cusVO);
						
						if (cusVO.getMvmtStsCd().equals("MT") && autoSts.equals("MT"))
						{
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
		/**************************************
		 *  Dom에서는 Inbound 처리. Empty 처리 *
		 **************************************/
//		cusCtmMovementVO.setFcntrFlg("M");
		cusCtmMovementVO.setIbflag("N");
		cusCtmMovementVO.setObCntrFlg("N");
		cusCtmMovementVO.setCntrXchCd("N");
		cusCtmMovementVO.setPreStsFlg("N");
		cusCtmMovementVO.setCntrSvrId(svrId);
		cusCtmMovementVO.setUsrNm(userNm);
		cusCtmMovementVO.setMvmtStsCd(mvmtStsCd);
		cusCtmMovementVO.setOrgYdCd(yardCd);
		cusCtmMovementVO.setCtrtOfcCtyCd(cntrVO.getAgmtCtyCd());
		cusCtmMovementVO.setCtrtSeq(cntrVO.getAgmtSeq());
		cusCtmMovementVO.setCntrDmgFlg(cntrDmgFlg);
		cusCtmMovementVO.setDmgFlgDt(dmgFlagDt);
		cusCtmMovementVO.setDmgUnflgDt(dmgUnflagDt);

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
			} else {
				errMsg = "Unexpected system error occurred during data processing. ["+mvmtStsCd+" creation error]";
				idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
				idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
				cusCtmMovementVO.setCnmvIdNo(idNo);
				cusCtmMovementVO.setCnmvSeq(idSeq);

				dbDao.addCtmMovement(cusCtmMovementVO);
				if (mvmtStsCd.equals("CD")) {	//Lease Term 이 SH일 경우 XX 생성
					if ("SH".equals(cntrVO.getLstmCd())){
						cusCtmMovementVO.setMvmtStsCd("XX");
						item.setEdiSendLstrmCd(cntrVO.getLstmCd()); // sendEDIToKOR을 위한 LstrmCd setting try 
						cusCtmMovementVO.setMvmtCreTpCd("C"); 
						cusCtmMovementVO.setCntrDispFlg("Y"); 
						cusCtmMovementVO.setAciacDivCd("I"); 
					}else{	//CM을 생성해준다.
						errMsg = "Unexpected system error occurred during data processing. [CM creation error]";
						cusCtmMovementVO.setMvmtStsCd("CM");
						cusCtmMovementVO.setFcntrFlg("M");
						cusCtmMovementVO.setMvmtCreTpCd("C");						
					}
					idNo  = String.valueOf(Integer.parseInt(idNo) + 1);
					idSeq = String.valueOf(Integer.parseInt(idSeq) + 1);
					cusCtmMovementVO.setCnmvIdNo(idNo);
					cusCtmMovementVO.setCnmvSeq(idSeq);
					dbDao.addCtmMovement(cusCtmMovementVO);
				}
			}
			// CrossItem으로 세팅
			item.setUpdateMaster(true);
			item.setCusCtmMovementVO(cusCtmMovementVO);
			item.setRtnStr(strRtn);
			//dbDao.updateMstContainer(cVO);
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
	 * Save(Deleted) from Update of EDI Message(EES_CTM_0404)<br>
	 * UPDATE CTM_MVMT_EDI_MSG & INSERT CTM_EDI_RSLT_RMK<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @throws EventException
	 */
	public void updateResultAsDelForMvmtEdiMsg(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		try {
			dbDao.updateResultAsDelForMvmtEdiMsg(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - updateResultAsDelForMvmtEdiMsg] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - updateResultAsDelForMvmtEdiMsg] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * Oscar Bkg No Update.
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateOscarContainerMove(CusCtmMovementVO cusCtmMovementVO, SignOnUserAccount account) throws EventException {
		try {			
			if(account==null){
				cusCtmMovementVO.setCreUsrId("SYSTEM");
			}else{
				cusCtmMovementVO.setCreUsrId(account.getUsr_id());
			}
			
			dbDao.updateOscarContainerMove(cusCtmMovementVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - updateOscarContainerMove] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - updateOscarContainerMove] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	
	/**
	 * EES_CTM_0406 Retrieve
	 *
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String searchContiCode(String locCd) throws EventException {
		try {
			return dbDao.searchContiCode(locCd);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchContiCode] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchContiCode] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	
	/**
	 * EES_CTM_0406 Retrieve
	 *
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchDgCargo(String bkgNo) throws EventException {
		try {
			return dbDao.searchDgCargo(bkgNo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchDgCargo] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchDgCargo] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/** searchRcvSnd
	 * 
	 * @param String orgYdCd
	 * @return String[]
	 */
	public String[] searchRcvSnd(String orgYdCd) throws EventException {
		try {
			   //RCV ID 조회 
			   String rcvId = dbDao2.searchEdiRcvId(orgYdCd); 
			   //SND ID 조회 
			   String sndId = dbDao2.searchEdiSndId(rcvId); 	

			   String []  strArr = new String [2];
			   
			   strArr[0] = rcvId;
			   strArr[1] = sndId;
			   
			return strArr;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchRcvSnd] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchRcvSnd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
		
	/**
	 * EES_CTM_0406 Retrieve
	 * handling event for retrieving International VL/VD 
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return String
	 * @exception EventException
	 */
	public String checkCtmBkgVvd(SearchCLMInfoVO searchCLMInfoVo) throws EventException {
		try {
			return dbDao.checkCtmBkgVvd(searchCLMInfoVo);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - checkCtmBkgVvd] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - checkCtmBkgVvd] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
/**
 * EES_CTM_0406 checkPPreMVMTSts
 *
 * @param SearchCLMInfoVO searchCLMInfoVo
 * @return String
 * @exception EventException
 */
public String checkPPreMVMTSts(SearchCLMInfoVO searchCLMInfoVO) throws EventException {
	try {
		return dbDao.checkPPreMVMTSts(searchCLMInfoVO);
	} catch (DAOException ex) {
		log.error("\n\n[BCImpl - checkPPreMVMTSts] DAOException :\n" + ex.getMessage(), ex);
		throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
	} catch(Exception ex) {
		log.error("\n\n[BCImpl - checkPPreMVMTSts] Exception :\n" + ex.getMessage(), ex);
		throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
	}
}
	
}

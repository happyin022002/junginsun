/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterBCImpl.java
*@FileTitle : Constraint Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 Seung-Man KIM
* 1.0 Creation
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
* 2015.07.06[CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함)
* 2015.08.14 김성욱, Standby BKG Report 메뉴 추가
* 2015.08.24 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
* 2015.09.24 이혜민 [CHM-201537552] BKG Control - SMP통제 조건 by lane 변경요청
* 2016.03.17 Stand by BKG MGMT에 대한 Reprocess 정리 및 보완
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration.ConstraintMasterDBDAO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgInfoListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgListForCompFirmBySPCVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BookingStowageVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.GetCodeSelectVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.MultiSetFormSeqVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReportFormVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchCompulsoryFirmVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtDetailVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SpcAlocMgmtVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.CommonCodeVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcBkgAlocMgmtCmdtDtlVO;
import com.hanjin.syscommon.common.table.SpcBkgAlocMgmtCntrTpszDtlVO;
import com.hanjin.syscommon.common.table.SpcBkgAlocMgmtCustDtlVO;
import com.hanjin.syscommon.common.table.SpcSbBkgDtlVO;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-BasicDataManage Business Logic Command Interface<br>
 * - ALPS-BasicDataManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung-Man KIM
 * @see Esm_Spc_0115EventResponse 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterBCImpl extends BasicCommandSupport implements ConstraintMasterBC {

	// Database Access Object
	private transient ConstraintMasterDBDAO dbDao = null;

	/**
	 * ConstraintMasterBCImpl 객체 생성<br>
	 * ConstraintMasterDBDAO를 생성한다.<br>
	 */
	public ConstraintMasterBCImpl() {
		dbDao = new ConstraintMasterDBDAO();
	}

	/**
     * Booking Allocation Master Table 화면 조회 메소드
     * 
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocCtrlOptVO
     * @return List<SpcAlocMgmtVO>
     * @throws EventException
     */
    public List<SpcAlocMgmtVO> searchBkgAlocMgmt(SpcAlocMgmtVO spcAlocCtrlOptVO) throws EventException{
        try {
            return dbDao.searchBkgAlocMgmt(spcAlocCtrlOptVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Booking Allocation Master Table 화면 관리 메소드.<br>
     *
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO[] spcAlocCtrlOptVO
     * @param account
     * @exception EventException
     */
	public void manageBkgAlocMgmt(SpcAlocMgmtVO[] spcAlocCtrlOptVO, SignOnUserAccount account) throws EventException {
		try {
			//BookingUtil utilCmd = new BookingUtil();
			int bkgAlocMgmtSeq = 0;
			String[] trunk_pod_cd = null;
			String[] trunk_pol_cd = null;
			String[] n1st_ts_pol_cd = null;
			String[] n1st_ts_pod_cd = null;
			String[] agmt_act_cnt_cd = null;//actual customer
			String[] cmdt_cd = null;//commodity
			String[] por_cd = null;
			String[] pol_cd = null;
			String[] pod_cd = null;
			String[] del_cd = null;
			String[] n1st_ts_pol_cnt_cd = null;
			String[] n1st_ts_pod_cnt_cd = null;
			String[] bkg_por_cnt_cd = null;
			String[] bkg_pol_cnt_cd = null;
			String[] bkg_pod_cnt_cd = null;
			String[] bkg_del_cnt_cd = null;
			String[] cntr_tpsz_cd = null;			

			String[] ts_nod_cd = null;
			String[] ts_pol_nod_cd = null;
			String[] ts_pod_nod_cd = null;

	        String[] stwg_cd = null;

			SpcAlocMgmtDetailVO spcAlocMgmtDetailVO = null;
			SpcBkgAlocMgmtCustDtlVO custDetailVO = null;//actual customer
			SpcBkgAlocMgmtCmdtDtlVO cmdtDetailVO = null;//commodtiy
			SpcBkgAlocMgmtCntrTpszDtlVO cntrTpszDetailVO = null;//cntrTpsz
			List<SpcAlocMgmtDetailVO> insertDetailVoList = new ArrayList<SpcAlocMgmtDetailVO>();
			List<SpcAlocMgmtDetailVO> updateDeatilVoList = new ArrayList<SpcAlocMgmtDetailVO>();

			List<SpcBkgAlocMgmtCustDtlVO> insertDetailVoList2 = new ArrayList<SpcBkgAlocMgmtCustDtlVO>();//actual customer
			List<SpcBkgAlocMgmtCustDtlVO> updateDeatilVoList2 = new ArrayList<SpcBkgAlocMgmtCustDtlVO>();//actual customer

			List<SpcBkgAlocMgmtCmdtDtlVO> insertDetailVoList3 = new ArrayList<SpcBkgAlocMgmtCmdtDtlVO>();//actual customer
			List<SpcBkgAlocMgmtCmdtDtlVO> updateDeatilVoList3 = new ArrayList<SpcBkgAlocMgmtCmdtDtlVO>();//actual custome

			List<SpcBkgAlocMgmtCntrTpszDtlVO> insertDetailVoList4 = new ArrayList<SpcBkgAlocMgmtCntrTpszDtlVO>();//actual customer
			List<SpcBkgAlocMgmtCntrTpszDtlVO> updateDeatilVoList4 = new ArrayList<SpcBkgAlocMgmtCntrTpszDtlVO>();//actual custome

			for (int i = 0; i < spcAlocCtrlOptVO.length; i++) {

				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getTrunkPolCd())) {
					trunk_pol_cd = spcAlocCtrlOptVO[i].getTrunkPolCd().split(",");
				} else {
					trunk_pol_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getTrunkPodCd())) {
					trunk_pod_cd = spcAlocCtrlOptVO[i].getTrunkPodCd().split(",");
				} else {
					trunk_pod_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getN1stTsPolCd())) {
					n1st_ts_pol_cd = spcAlocCtrlOptVO[i].getN1stTsPolCd().split(",");
				} else {
					n1st_ts_pol_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getN1stTsPodCd())) {
					n1st_ts_pod_cd = spcAlocCtrlOptVO[i].getN1stTsPodCd().split(",");
				} else {
					n1st_ts_pod_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getPorCd())) {
					por_cd = spcAlocCtrlOptVO[i].getPorCd().split(",");
				} else {
					por_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getPolCd())) {
					pol_cd = spcAlocCtrlOptVO[i].getPolCd().split(",");
				} else {
					pol_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getPodCd())) {
					pod_cd = spcAlocCtrlOptVO[i].getPodCd().split(",");
				} else {
					pod_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getDelCd())) {
					del_cd = spcAlocCtrlOptVO[i].getDelCd().split(",");
				} else {
					del_cd = null;
				}

				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getN1stTsPolCntCd())) {
					n1st_ts_pol_cnt_cd = spcAlocCtrlOptVO[i].getN1stTsPolCntCd().split(",");
				} else {
					n1st_ts_pol_cnt_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getN1stTsPodCntCd())) {
					n1st_ts_pod_cnt_cd = spcAlocCtrlOptVO[i].getN1stTsPodCntCd().split(",");
				} else {
					n1st_ts_pod_cnt_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getBkgPorCntCd())) {
					bkg_por_cnt_cd = spcAlocCtrlOptVO[i].getBkgPorCntCd().split(",");
				} else {
					bkg_por_cnt_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getBkgPolCntCd())) {
					bkg_pol_cnt_cd = spcAlocCtrlOptVO[i].getBkgPolCntCd().split(",");
				} else {
					bkg_pol_cnt_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getBkgPodCntCd())) {
					bkg_pod_cnt_cd = spcAlocCtrlOptVO[i].getBkgPodCntCd().split(",");
				} else {
					bkg_pod_cnt_cd = null;
				}
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getBkgDelCntCd())) {
					bkg_del_cnt_cd = spcAlocCtrlOptVO[i].getBkgDelCntCd().split(",");
				} else {
					bkg_del_cnt_cd = null;
				}
				
				
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getTsNodCd())) {
					ts_nod_cd = spcAlocCtrlOptVO[i].getTsNodCd().split(",");
				} else {
					ts_nod_cd = null;
				}

				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getTsPolNodCd())) {
					ts_pol_nod_cd = spcAlocCtrlOptVO[i].getTsPolNodCd().split(",");
				} else {
					ts_pol_nod_cd = null;
				}

				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getTsPodNodCd())) {
					ts_pod_nod_cd = spcAlocCtrlOptVO[i].getTsPodNodCd().split(",");
				} else {
					ts_pod_nod_cd = null;
				}
				
				
				//actual customer
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getAgmtActCntCd())) {
					agmt_act_cnt_cd = spcAlocCtrlOptVO[i].getAgmtActCntCd().split(",");
				} else {
					agmt_act_cnt_cd = null;
				}
				//commodity
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getCmdtCd())) {
					cmdt_cd = spcAlocCtrlOptVO[i].getCmdtCd().split(",");
				} else {
					cmdt_cd = null;
				}
				//cntr_tpsz_cd
				if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getCntrTpszCd())) {
					cntr_tpsz_cd = spcAlocCtrlOptVO[i].getCntrTpszCd().split(",");
				} else {
					cntr_tpsz_cd = null;
				}
				
				//stowage code
                if (StringUtils.isNotBlank(spcAlocCtrlOptVO[i].getStwgCd())) {
                    stwg_cd = spcAlocCtrlOptVO[i].getStwgCd().split(",");
                } else {
                    stwg_cd = null;
                }
                
                

				if (spcAlocCtrlOptVO[i].getIbflag().equals("I")) {
					spcAlocCtrlOptVO[i].setCreUsrId(account.getUsr_id());
					spcAlocCtrlOptVO[i].setUpdUsrId(account.getUsr_id());

					List<SpcAlocMgmtVO> list = null;
					list = dbDao.searchBkgAlocDupCheckData(spcAlocCtrlOptVO[i]);
					if (list.size() > 0) {
						String detail = list.get(0).getBkgAlocTpCd();
						throw new EventException((String) new ErrorHandler("COM12115", new String[] { detail }).getMessage());
					}

					bkgAlocMgmtSeq = Integer.parseInt(dbDao.searchBkgAlocMgmtSeq());
					spcAlocCtrlOptVO[i].setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
					String tempDgrd = spcAlocCtrlOptVO[i].getDgRd();
					if (tempDgrd.equals("dg")) {
						spcAlocCtrlOptVO[i].setDcgoFlg("Y");
					} else if (tempDgrd.equals("rd")) {
						spcAlocCtrlOptVO[i].setRdCgoFlg("Y");
					}
					dbDao.addBkgAlocMgmt(spcAlocCtrlOptVO[i]);

					if (trunk_pol_cd != null && trunk_pol_cd.length > 0) {
						for (int k = 0; k < trunk_pol_cd.length; k++) {
							log.debug("POL-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("TPL");
							spcAlocMgmtDetailVO.setSbLocCd(trunk_pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (trunk_pod_cd != null && trunk_pod_cd.length > 0) {
						for (int k = 0; k < trunk_pod_cd.length; k++) {
							log.debug("POD-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("TPD");
							spcAlocMgmtDetailVO.setSbLocCd(trunk_pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (por_cd != null && por_cd.length > 0) {
						for (int k = 0; k < por_cd.length; k++) {
							log.debug("por_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POR");
							spcAlocMgmtDetailVO.setSbLocCd(por_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (pol_cd != null && pol_cd.length > 0) {
						for (int k = 0; k < pol_cd.length; k++) {
							log.debug("pol_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POL");
							spcAlocMgmtDetailVO.setSbLocCd(pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (pod_cd != null && pod_cd.length > 0) {
						for (int k = 0; k < pod_cd.length; k++) {
							log.debug("pod_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POD");
							spcAlocMgmtDetailVO.setSbLocCd(pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (del_cd != null && del_cd.length > 0) {
						for (int k = 0; k < del_cd.length; k++) {
							log.debug("del_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("DEL");
							spcAlocMgmtDetailVO.setSbLocCd(del_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (bkg_por_cnt_cd != null && bkg_por_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_por_cnt_cd.length; k++) {
							log.debug("bkg_por_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POR");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_por_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (bkg_pol_cnt_cd != null && bkg_pol_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_pol_cnt_cd.length; k++) {
							log.debug("bkg_pol_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POL");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_pol_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (bkg_pod_cnt_cd != null && bkg_pod_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_pod_cnt_cd.length; k++) {
							log.debug("bkg_pod_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POD");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_pod_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (bkg_del_cnt_cd != null && bkg_del_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_del_cnt_cd.length; k++) {
							log.debug("bkg_del_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("DEL");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_del_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (n1st_ts_pol_cnt_cd != null && n1st_ts_pol_cnt_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pol_cnt_cd.length; k++) {
							log.debug("n1st_ts_pol_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPL");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pol_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pod_cnt_cd != null && n1st_ts_pod_cnt_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pod_cnt_cd.length; k++) {
							log.debug("n1st_ts_pod_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPD");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pod_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pol_cd != null && n1st_ts_pol_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pol_cd.length; k++) {
							log.debug("n1st_ts_pol_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPL");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pod_cd != null && n1st_ts_pod_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pod_cd.length; k++) {
							log.debug("n1st_ts_pod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPD");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (ts_nod_cd != null && ts_nod_cd.length > 0) {
						for (int k = 0; k < ts_nod_cd.length; k++) {
							log.debug("ts_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SAY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (ts_pol_nod_cd != null && ts_pol_nod_cd.length > 0) {
						for (int k = 0; k < ts_pol_nod_cd.length; k++) {
							log.debug("ts_pol_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SLY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_pol_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (ts_pod_nod_cd != null && ts_pod_nod_cd.length > 0) {
						for (int k = 0; k < ts_pod_nod_cd.length; k++) {
							log.debug("ts_pod_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SDY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_pod_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
					}
					
					
					
					
					
					//Actual Customer
					if (agmt_act_cnt_cd != null && agmt_act_cnt_cd.length > 0) {
						for (int k = 0; k < agmt_act_cnt_cd.length; k++) {
							log.debug("AcutalCustomer-SEQ");
							custDetailVO = new SpcBkgAlocMgmtCustDtlVO();
							custDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							custDetailVO.setBkgCustTpCd("B"); //B: Actual (실제화주)
							custDetailVO.setCustCntCd(agmt_act_cnt_cd[k]);
							custDetailVO.setCustSeq(agmt_act_cnt_cd[k]);
							custDetailVO.setCreUsrId(account.getUsr_id());
							custDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList2.add(custDetailVO);
						}
					}
					//Commodity
					if (cmdt_cd != null && cmdt_cd.length > 0) {
						for (int k = 0; k < cmdt_cd.length; k++) {
							log.debug("Commodity-SEQ");
							cmdtDetailVO = new SpcBkgAlocMgmtCmdtDtlVO();
							cmdtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							cmdtDetailVO.setCmdtCd(cmdt_cd[k]);
							cmdtDetailVO.setCreUsrId(account.getUsr_id());
							cmdtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList3.add(cmdtDetailVO);
						}
					}
					//cntrTpsz
					if (cntr_tpsz_cd != null && cntr_tpsz_cd.length > 0) {
						for (int k = 0; k < cntr_tpsz_cd.length; k++) {
							log.debug("cntr_tpsz_cd-SEQ");
							cntrTpszDetailVO = new SpcBkgAlocMgmtCntrTpszDtlVO();
							cntrTpszDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							cntrTpszDetailVO.setCntrTpszCd(cntr_tpsz_cd[k]);
							cntrTpszDetailVO.setCreUsrId(account.getUsr_id());
							cntrTpszDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList4.add(cntrTpszDetailVO);
						}
					}
					
					//stowage code
                    if (stwg_cd != null && stwg_cd.length > 0) {
                        for (int k = 0; k < stwg_cd.length; k++) {
                            log.debug("stwg_cd ");
                            spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
                            spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
                            spcAlocMgmtDetailVO.setSbLocDivCd("STW");
                            spcAlocMgmtDetailVO.setSbLocCd(stwg_cd[k]);
                            spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
                            spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
                            insertDetailVoList.add(spcAlocMgmtDetailVO);
                        }
                    }
                    
                    

				} else if (spcAlocCtrlOptVO[i].getIbflag().equals("U")) {
					List<SpcAlocMgmtVO> list = null;
					list = dbDao.searchBkgAlocDupCheckData(spcAlocCtrlOptVO[i]);
					if (list.size() > 0) {
						String detail = list.get(0).getBkgAlocTpCd();
						throw new EventException((String) new ErrorHandler("COM12115", new String[] { detail }).getMessage());
					}

					String tempDgrd = spcAlocCtrlOptVO[i].getDgRd();

					if (tempDgrd.equals("dg")) {
						spcAlocCtrlOptVO[i].setDcgoFlg("Y");
					} else if (tempDgrd.equals("rd")) {
						spcAlocCtrlOptVO[i].setRdCgoFlg("Y");
					}
					spcAlocCtrlOptVO[i].setUpdUsrId(account.getUsr_id());
					dbDao.removeBkgAlocDetailMgmt(spcAlocCtrlOptVO[i]);
					dbDao.removeBkgAlocMgmtCustDetailMgmt(spcAlocCtrlOptVO[i]);//actual customer
					dbDao.removeBkgAlocMgmtCmdtDetailMgmt(spcAlocCtrlOptVO[i]);//commodity
					dbDao.removeBkgAlocMgmtCntrTpszDetailMgmt(spcAlocCtrlOptVO[i]);//cntrTysz
					dbDao.modifyBkgAlocMgmt(spcAlocCtrlOptVO[i]);
//					dbDao.modifyBkgAlocMgmtHist(spcAlocCtrlOptVO[i]);
					
                    if(trunk_pol_cd!=null&&trunk_pol_cd.length>0){
						for(int k = 0; k < trunk_pol_cd.length ; k++){
							log.debug("update: trunk_pol_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("TPL");
							spcAlocMgmtDetailVO.setSbLocCd(trunk_pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (trunk_pod_cd != null && trunk_pod_cd.length > 0) {
						for (int k = 0; k < trunk_pod_cd.length; k++) {
							log.debug("update: n1st_ts_pol_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("TPD");
							spcAlocMgmtDetailVO.setSbLocCd(trunk_pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pol_cd != null && n1st_ts_pol_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pol_cd.length; k++) {
							log.debug("update: n1st_ts_pol_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SPL");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pod_cd != null && n1st_ts_pod_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pod_cd.length; k++) {
							log.debug("update: n1st_ts_pod_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SPD");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (por_cd != null && por_cd.length > 0) {
						for (int k = 0; k < por_cd.length; k++) {
							log.debug("update: por_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("POR");
							spcAlocMgmtDetailVO.setSbLocCd(por_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (pol_cd != null && pol_cd.length > 0) {
						for (int k = 0; k < pol_cd.length; k++) {
							log.debug("update: pol_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("POL");
							spcAlocMgmtDetailVO.setSbLocCd(pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (pod_cd != null && pod_cd.length > 0) {
						for (int k = 0; k < pod_cd.length; k++) {
							log.debug("pod_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("POD");
							spcAlocMgmtDetailVO.setSbLocCd(pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (del_cd != null && del_cd.length > 0) {
						for (int k = 0; k < del_cd.length; k++) {
							log.debug("del_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("DEL");
							spcAlocMgmtDetailVO.setSbLocCd(del_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (bkg_por_cnt_cd != null && bkg_por_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_por_cnt_cd.length; k++) {
							log.debug("bkg_por_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("POR");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_por_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (bkg_pol_cnt_cd != null && bkg_pol_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_pol_cnt_cd.length; k++) {
							log.debug("bkg_pol_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("POL");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_pol_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (bkg_pod_cnt_cd != null && bkg_pod_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_pod_cnt_cd.length; k++) {
							log.debug("bkg_pod_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("POD");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_pod_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (bkg_del_cnt_cd != null && bkg_del_cnt_cd.length > 0) {
						for (int k = 0; k < bkg_del_cnt_cd.length; k++) {
							log.debug("bkg_del_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("DEL");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_del_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pol_cnt_cd != null && n1st_ts_pol_cnt_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pol_cnt_cd.length; k++) {
							log.debug("n1st_ts_pol_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SPL");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pol_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					if (n1st_ts_pod_cnt_cd != null && n1st_ts_pod_cnt_cd.length > 0) {
						for (int k = 0; k < n1st_ts_pod_cnt_cd.length; k++) {
							log.debug("n1st_ts_pod_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SPD");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pod_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					

					if (ts_nod_cd != null && ts_nod_cd.length > 0) {
						for (int k = 0; k < ts_nod_cd.length; k++) {
							log.debug("ts_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SAY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (ts_pol_nod_cd != null && ts_pol_nod_cd.length > 0) {
						for (int k = 0; k < ts_pol_nod_cd.length; k++) {
							log.debug("ts_pol_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SLY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_pol_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}

					if (ts_pod_nod_cd != null && ts_pod_nod_cd.length > 0) {
						for (int k = 0; k < ts_pod_nod_cd.length; k++) {
							log.debug("ts_pod_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							spcAlocMgmtDetailVO.setSbLocDivCd("SDY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_pod_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList.add(spcAlocMgmtDetailVO);
						}
					}
					
					
					//Actual Customer
					if (agmt_act_cnt_cd != null && agmt_act_cnt_cd.length > 0) {
						for (int k = 0; k < agmt_act_cnt_cd.length; k++) {
							log.debug("AcutalCustomer-SEQ");
							custDetailVO = new SpcBkgAlocMgmtCustDtlVO();
							custDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							custDetailVO.setBkgCustTpCd("B"); //B: Actual (실제화주)
							custDetailVO.setCustCntCd(agmt_act_cnt_cd[k]);
							custDetailVO.setCustSeq(agmt_act_cnt_cd[k]);
							custDetailVO.setCreUsrId(account.getUsr_id());
							custDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList2.add(custDetailVO);
						}
					}

					//Commodity
					if (cmdt_cd != null && cmdt_cd.length > 0) {
						for (int k = 0; k < cmdt_cd.length; k++) {
							log.debug("Commodity-SEQ");
							cmdtDetailVO = new SpcBkgAlocMgmtCmdtDtlVO();
							cmdtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							cmdtDetailVO.setCmdtCd(cmdt_cd[k]);
							cmdtDetailVO.setCreUsrId(account.getUsr_id());
							cmdtDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList3.add(cmdtDetailVO);
						}
					}
					//cntrTpsz
					if (cntr_tpsz_cd != null && cntr_tpsz_cd.length > 0) {
						for (int k = 0; k < cntr_tpsz_cd.length; k++) {
							log.debug("cntr_tpsz_cd-SEQ");
							cntrTpszDetailVO = new SpcBkgAlocMgmtCntrTpszDtlVO();
							cntrTpszDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
							cntrTpszDetailVO.setCntrTpszCd(cntr_tpsz_cd[k]);
							cntrTpszDetailVO.setCreUsrId(account.getUsr_id());
							cntrTpszDetailVO.setUpdUsrId(account.getUsr_id());
							updateDeatilVoList4.add(cntrTpszDetailVO);
						}
					}
					//stowage code
					if (stwg_cd != null && stwg_cd.length > 0) {
                        for (int k = 0; k < stwg_cd.length; k++) {
                            log.debug("stwg_cd ");
                            spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
                            spcAlocMgmtDetailVO.setBkgAlocSeq(spcAlocCtrlOptVO[i].getBkgAlocSeq());
                            spcAlocMgmtDetailVO.setSbLocDivCd("STW");
                            spcAlocMgmtDetailVO.setSbLocCd(stwg_cd[k]);
                            spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
                            spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
                            updateDeatilVoList.add(spcAlocMgmtDetailVO);
                        }
                    }

				}
			}
			//Location
			if (insertDetailVoList.size() > 0) {
				dbDao.addBkgAlocMgmtDetail(insertDetailVoList);
//				dbDao.addBkgAlocMgmtDetailHist(insertDetailVoList);
			}
			if (updateDeatilVoList.size() > 0) {
				dbDao.addBkgAlocMgmtDetail(updateDeatilVoList);
//				dbDao.addBkgAlocMgmtDetailHist(updateDeatilVoList);
			}
			//Actual Customer
			if (insertDetailVoList2.size() > 0) {
				dbDao.addBkgAlocMgmtCustDetail(insertDetailVoList2);
//				dbDao.addBkgAlocMgmtCustDetailHist(insertDetailVoList2);
			}
			if (updateDeatilVoList2.size() > 0) {
				dbDao.addBkgAlocMgmtCustDetail(updateDeatilVoList2);
//				dbDao.addBkgAlocMgmtCustDetailHist(updateDeatilVoList2);
			}
			//Commoditiy
			if (insertDetailVoList3.size() > 0) {
				dbDao.addBkgAlocMgmtCmdtDetail(insertDetailVoList3);
//				dbDao.addBkgAlocMgmtCmdtDetailHist(insertDetailVoList3);
			}
			if (updateDeatilVoList3.size() > 0) {
				dbDao.addBkgAlocMgmtCmdtDetail(updateDeatilVoList3);
//				dbDao.addBkgAlocMgmtCmdtDetailHist(updateDeatilVoList3);
			}
			//cntrTpsz
			if (insertDetailVoList4.size() > 0) {
				dbDao.addBkgAlocMgmtCntrTpszDetail(insertDetailVoList4);
			}
			if (updateDeatilVoList4.size() > 0) {
				dbDao.addBkgAlocMgmtCntrTpszDetail(updateDeatilVoList4);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
     * Booking Allocation Master Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 		ChoiMoonHwan
     * @param 		SpcAlocMgmtVO spcAlocCtrlOptVO
	 * @exception 	EventException
     */
	public void removeBkgAlocMgmt(SpcAlocMgmtVO spcAlocCtrlOptVO) throws EventException {
		try {

			log.debug("\n\n SHARC-SEQ=" + spcAlocCtrlOptVO.getShaasSeq() + "SINRS-SEQ=" + spcAlocCtrlOptVO.getSinwaSeq());

			if (!"".equals(spcAlocCtrlOptVO.getShaasSeq()) && !"".equals(spcAlocCtrlOptVO.getSinwaSeq())) {
        		//SHARC/SINRS탭에서 삭제시 두개 동시에 삭제하도록 처리
				log.debug("\n\n SHASS/SINRS DELETE");
				spcAlocCtrlOptVO.setBkgAlocSeq(spcAlocCtrlOptVO.getShaasSeq());
				dbDao.removeBkgAlocDetailMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCustDetailMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCmdtDetailMgmt(spcAlocCtrlOptVO);//commodity
				dbDao.removeBkgAlocMgmt(spcAlocCtrlOptVO);
				spcAlocCtrlOptVO.setBkgAlocSeq(spcAlocCtrlOptVO.getSinwaSeq());
				dbDao.removeBkgAlocDetailMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCustDetailMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCmdtDetailMgmt(spcAlocCtrlOptVO);//commodity
				dbDao.removeBkgAlocMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCntrTpszDetailMgmt(spcAlocCtrlOptVO);//cntrTysz
			} else {
				log.debug("\n\n OTHER RHQ DELETE");
				dbDao.removeBkgAlocDetailMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCustDetailMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCmdtDetailMgmt(spcAlocCtrlOptVO);//commodity
				dbDao.removeBkgAlocMgmt(spcAlocCtrlOptVO);
				dbDao.removeBkgAlocMgmtCntrTpszDetailMgmt(spcAlocCtrlOptVO);//cntrTysz
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
	 * Booking Allocation Master Table 화면에서 T.Lane과 BD값을 검증 한다.<br>
	 * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<SpcAlocMgmtVO>
	 * @exception EventException
	 */	
	public List<SpcAlocMgmtVO> searchBkgAlocValidationData(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException {
		try {

			return dbDao.searchBkgAlocValidationData(spcAlocMgmtVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
     * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocCtrlOptVO
     * @return List<SpcAlocMgmtVO>
     * @throws EventException
     */
	public List<SpcAlocMgmtVO> searchCmdtNm(SpcAlocMgmtVO spcAlocCtrlOptVO) throws EventException {
		try {
			return dbDao.searchCmdtNm(spcAlocCtrlOptVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
     * Booking Allocation Master Table 화면에 Group Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param SpcAlocMgmtVO spcAlocCtrlOptVO
     * @return List<SpcAlocMgmtVO>
     * @throws EventException
     */
	public List<SpcAlocMgmtVO> searchGrpCmdtNm(SpcAlocMgmtVO spcAlocCtrlOptVO) throws EventException {
		try {
			return dbDao.searchGrpCmdtNm(spcAlocCtrlOptVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
     * 기능 : default combo,ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
     * @throws EventException
     */
	public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse, String[][] array, SignOnUserAccount account) throws EventException {
		List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
		GetCodeSelectVO combovo = new GetCodeSelectVO();

		try {
			for (int i = 0; i < array.length; i++) {
				list = getCodeSelectList((array[i][0]).toString(), array[i][1], account);
				if (array[i][2].equals("All")) {
					combovo.setName("All");
					combovo.setCode("All");
					list.add(0, combovo);
				} else if (array[i][2].equals("Blank")) {
					combovo.setName(" ");
					combovo.setCode(" ");
					list.add(0, combovo);
				}
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			throw new EventException("Exception : " + ex.getMessage());
		}
		return eventResponse;
	}

	   /**
	    * 1. 기능 : default combo,ibsheet codelist를 return <p>
	    * 2. 처리개요 : <p>
	    * 3. 주의사항 : <p>
	    * 
	    * @param codeItem  	업무 구분
		 *  					
		 * 26. Report Item Info List : slctItmFom(cre_usr_id)                      
	    * @param String codeItem      	Where절에 들어갈 코드그룹
	    * @param String code      	    Where절에 들어갈 코드조건값
	    * @param SignOnUserAccount account
	    * @return List<GetCodeSelectVO>
	    * @throws EventException
	    */
	   @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<GetCodeSelectVO> getCodeSelectList(String codeItem, String code,SignOnUserAccount account) throws EventException {
		   
			  List<GetCodeSelectVO> list = new ArrayList<GetCodeSelectVO>();
			  DBRowSet dRs = null;
			   
		      try {	        	
		       	dRs = dbDao.searchReportItem(code,account);	
		       	if (dRs != null){
		       		list = (List)RowSetUtil.rowSetToVOs(dRs, GetCodeSelectVO.class);
		       	}
		      } catch(SQLException se){
		          log.error("SQLException : " +se.getMessage());
		          throw new EventException("SQLException : " + se.getMessage());
		      } catch (DAOException de) {
		          log.error("DAOException : " +de.getMessage());
		          throw new EventException("DAOException : " + de.getMessage());
		      } catch(Exception ex){
		    	  log.error("Exception : " +ex.getMessage());
		       	  throw new EventException("Exception : " + ex.getMessage());
		      }
		      return list;  
		  }

	   /**
	    * group code 목록을 조회한다. <br>
	    *
	    * @param SearchConditionVO searchVo
	    * @param ReportFormVO vo
	    * @return List<ReportFormVO>
	    * @exception EventException
	    */	
	public List<ReportFormVO> searchSetFormList(SearchConditionVO searchVo, ReportFormVO vo) throws EventException {
		try {

			HashMap<String, String> qParam = new HashMap<String, String>();
			vo.setIndirectColumnValues(qParam);

			return dbDao.getCodeSelectList(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	   /**
		 * 조회 이벤트 처리<br>
		 * MultiDimension화면에 대한 조회 이벤트 처리<br>
		 * 
	   * @param SearchConditionVO searchVo
	   * @param ReportFormVO vo
	   * @param SignOnUserAccount account
	   * @return List<ReportFormVO>
	   * @exception EventException	 
		 */
	public List<ReportFormVO> searchSetFormList2(SearchConditionVO searchVo, ReportFormVO vo, SignOnUserAccount account) throws EventException {
		try {

			HashMap<String, String> qParam = new HashMap<String, String>();

			log.debug("=====================" + vo.getRptFomNm());
			qParam.put("cre_usr_id", account.getUsr_id());
			qParam.put("rpt_fom_no", searchVo.getFSelgroup());
			//          qParam.put("rpt_fom_no" , "1");
			qParam.put("pgm", vo.getPgm());
			qParam.put("rpt_fom_nm", vo.getRptFomNm());
			vo.setIndirectColumnValues(qParam);

			return dbDao.searchSetFormList2(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	  /**
		 * 조회 이벤트 처리<br>
		 * MultiDimension화면에 대한 조회 이벤트 처리<br>
		 * 
	  * @param SearchConditionVO searchVo
	  * @param ReportFormVO vo
	  * @param SignOnUserAccount account
	  * @return List<ReportFormVO>
	  * @exception EventException	 
		 */
	public ReportFormVO searchSetFormList3(SearchConditionVO searchVo, ReportFormVO vo, SignOnUserAccount account) throws EventException {
		try {
			String[] strItem = new String[2];
			StringBuffer tempBuffer1 = new StringBuffer();
			StringBuffer tempBuffer2 = new StringBuffer();

			if (!searchVo.getFSelgroup().equals("")) {
				List<ReportFormVO> list = searchSetFormList2(searchVo, vo, account);

				int listCnt = list.size();
				if (listCnt > 0) {
					for (int i = 0; i < listCnt; i++) {
						// 					tempBuffer1.append(((ReportFormVO)list.get(i)).getRptItmDesc());
						// 					tempBuffer2.append(((ReportFormVO)list.get(i)).getRptItmColNm());
						tempBuffer1.append(((ReportFormVO) list.get(i)).getColNm());//getRptItmDesc());
						tempBuffer2.append(((ReportFormVO) list.get(i)).getDpNm());
						if (listCnt - 1 != i) {
							tempBuffer1.append("|");
							tempBuffer2.append("|");
						}
					}
				}

				strItem[0] = tempBuffer1.toString();
				strItem[1] = tempBuffer2.toString();
			} else {
				strItem[0] = "";
				strItem[1] = "";
			}
			vo.setHeader(strItem[0]);
			vo.setHeaderNM(strItem[1]);
			return vo;

			//         HashMap<String, String> qParam = new HashMap<String, String>();
			//         
			//         log.debug("====================="+vo.getRptFomNm());
			//         qParam.put("cre_usr_id"       , userId);
			//         qParam.put("rpt_fom_no" , searchVo.getFSelgroup());
			//         qParam.put("pgm_no", vo.getPgm());
			////         qParam.put("rpt_fom_nm", vo.getRptFomNm());
			//         vo.setIndirectColumnValues(qParam);       
			//     	
			//         return dbDao.searchSetFormList3(vo);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	   /**
		 * 멀티 이벤트 처리<br>
		 * ESM_COA_003(So Cost Code)화면에 대한 멀티 이벤트 처리<br>
		 * 
		 * @param SearchConditionVO searchVo
		 * @param SalesRPTCommonVO vo
		 * @param SalesRPTCommonVO[] vos
		 * @param ReportFormVO[] tVos
		 * @param ReportFormVO tVo
		 * @param SignOnUserAccount account
		 * @return EventResponse
		 * @exception EventException
		 */
	public EventResponse multiSetForm(SearchConditionVO searchVo, SalesRPTCommonVO vo, SalesRPTCommonVO[] vos, ReportFormVO[] tVos, ReportFormVO tVo, SignOnUserAccount account) throws EventException {
	       try{
	    	   ArrayList<HashMap<String,String>> createMasterList = null;
	    	   ArrayList<HashMap<String,String>> createDetailList = null;
	    	   ArrayList<HashMap<String,String>> deleteMasterList = null;
	    	   ArrayList<HashMap<String,String>> deleteDetailList = null;
	    	   ArrayList<HashMap<String,String>> updateMasterList = null;
	       	
	           String fom_seq  = searchVo.getFSelgroup();
	           String fom_desc = searchVo.getFGroup();
	           String savename = searchVo.getFSavename(); 
	           String divideName = searchVo.getFDividename(); 
	           String rptFomDesc = tVo.getFRptFomDesc();
	           
				log.debug("\n\n fom_seq=" + fom_seq);
				log.debug("\n fom_desc=" + fom_desc);
				log.debug("\n savename=" + savename);  
				log.debug("\n divideName=" + divideName);  
				log.debug("\n rptFomDesc=" + rptFomDesc);  

	   		if(divideName.trim().equals("save")|| fom_seq.trim().equals("")){
	   			log.debug("save시작==seq START");
	       		//SEQ ---------------------------------- START
	               if(fom_seq.trim().equals("") || (!fom_seq.trim().equals("") && !fom_desc.trim().equals(savename))){
	                   HashMap<String, String> qParam = new HashMap<String, String>();
	                   
	                   qParam.put("pgm_no", tVo.getPgm());
	                   qParam.put("cre_usr_id", account.getUsr_id());
	                   
	                   vo.setIndirectColumnValues(qParam);
	                   
	                   List<MultiSetFormSeqVO> list = dbDao.multiSetFormSeq(vo);
	                   int listCnt = list.size();
	                   if(listCnt > 0){
	                   	fom_seq = ((MultiSetFormSeqVO)list.get(0)).getSeq();
	                   }
	                   
	                   if(listCnt == 0){
	                   	fom_seq = "1";
	                   }
	               }
//	               log.debug("save시작==seq END");
	       		//SEQ ---------------------------------- END    
	               
	   				//신규
	   				if(searchVo.getFSelgroup().trim().equals("")){
//	   					log.debug("save===INSERT START 콤보값없을경우");
	   	            	//마스터(INSERT) ---------------------------------- START
	   	                //query parameter
	   	                HashMap<String, String> param = new HashMap<String, String>();
	   	                param.put("cre_usr_id", account.getUsr_id());
	   	                param.put("upd_usr_id", account.getUsr_id());
	   	                param.put("rpt_fom_no", fom_seq); 
	   	                param.put("rpt_fom_nm", savename);
	   	                param.put("rpt_fom_desc", rptFomDesc);
	   	                param.put("pgm_no", tVo.getPgm());
	   	                
	   	                createMasterList = new ArrayList<HashMap<String,String>>();
	         
	   	                createMasterList.add(param);   

	   	                vo.setMultiCreateList(createMasterList);
	   	                
	   	                //[DB 실행]
	   	                dbDao.multiSetFormRegistMaster(vo);
	   	                //마스터(INSERT) ---------------------------------- END
	               }else{
	            	   
	               	if(!fom_desc.trim().equals(savename)){ 
//	               		log.debug("save===INSERT START 콤보값과 타이틀명이 다를경우");
	               		//마스터(INSERT) ---------------------------------- START
	   	                //query parameter
	   	                HashMap<String, String> param = new HashMap<String, String>();
	   	                param.put("cre_usr_id", account.getUsr_id());
		                param.put("upd_usr_id", account.getUsr_id());
		                param.put("rpt_fom_no", fom_seq); 
		                param.put("rpt_fom_nm", savename);
		                param.put("pgm_no", tVo.getPgm());
		                param.put("rpt_fom_desc", rptFomDesc);
		                
	   	                createMasterList = new ArrayList<HashMap<String,String>>();
	   	                
	   	                createMasterList.add(param);   
	   	                
	   	                vo.setMultiCreateList(createMasterList);
	   	                
	   	                //[DB 실행]
	   	                dbDao.multiSetFormRegistMaster(vo);
	   	                //마스터(INSERT) ---------------------------------- END   
	   	                //기존 타이틀명에 f_rpt_fom_desc값이 달라졋을경우 업데이트START
	               	}
	               }
	               //Detail(DELETE) ---------------------------------- START
	   				
	               deleteDetailList = new ArrayList<HashMap<String,String>>();
	               
		           	log.debug("slct_itm_fom_seq = "+fom_seq);
		           	log.debug("cre_usr_id = "+account.getUsr_id());
		           	log.debug("\n");
	           	
	               //query parameter
	               HashMap<String, String> param = new HashMap<String, String>();
	               param.put("pgm_no", tVo.getPgm());
	               param.put("cre_usr_id", account.getUsr_id());
	               param.put("rpt_fom_no", fom_seq);
	                                      
	               // -------------------------------------------                            
	               deleteDetailList.add(param);     
	               
	               vo.setMultiDeleteList(deleteDetailList);
	               log.debug("Detail(DELETE)");
	               //[DB 실행]
	               dbDao.multiSetFormRemoveDetail(vo);                   
	       		//Detail(DELETE)---------------------------------- END   
	       		
	       		//Detail(INSERT) ---------------------------------- START
	               if(vos.length > 0){
	               	createDetailList = new ArrayList<HashMap<String,String>>(); 
	               	for(int i = 0 ; i < vos.length ; i++){   
	                   	if (vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("R")) {
	                           //query parameter
	                           HashMap<String, String> iParam = new HashMap<String, String>();
	                           int a= i+1;
	                           String temp = String.valueOf(a);
	                           iParam.put("col_nm", vos[i].getRptItmColNm());  
	                           iParam.put("rpt_fom_no", fom_seq);
	                           iParam.put("pgm_no", tVo.getPgm());
	                           iParam.put("dp_seq", temp);
	                           iParam.put("dp_nm", vos[i].getRptItmDesc()); 
	                           iParam.put("cre_usr_id", account.getUsr_id()); 
	                           iParam.put("upd_usr_id", account.getUsr_id()); 

	                           // -------------------------------------------                            
	                           createDetailList.add(iParam);
	                   	} 
	                   }
	               }    		
	               vo.setMultiCreateList(createDetailList);
	               //[DB 실행]
	               dbDao.multiSetFormRegistDetail(vo);                  
	       		//Detail(INSERT)---------------------------------- END       
	   		}else if(divideName.trim().equals("titlesave")){
	   			log.debug("########################################################!!");
	       		HashMap<String, String> param = new HashMap<String, String>();
	            param.put("cre_usr_id", account.getUsr_id());
	            param.put("upd_usr_id", account.getUsr_id());
	            param.put("rpt_fom_no", fom_seq); 
	            param.put("rpt_fom_nm", savename);
	            param.put("pgm_no", tVo.getPgm());
	            param.put("rpt_fom_desc", rptFomDesc);
	            
	            updateMasterList = new ArrayList<HashMap<String,String>>();
	            updateMasterList.add(param); 
	            
	            vo.setMultiUpdateList(updateMasterList);
	            log.debug(vo.getMultiUpdateList());
	          //[DB 실행]
	               dbDao.multiSetFormUpdateMaster(vo);
	   		}
	   		//삭제flg 변경
	   		else{   	
	               //query parameter
	               HashMap<String, String> param = new HashMap<String, String>();

	               param.put("pgm_no", tVo.getPgm());
	               param.put("rpt_fom_no", fom_seq); 
	               param.put("cre_usr_id", account.getUsr_id());
	               
	               deleteMasterList = new ArrayList<HashMap<String,String>>();
	               deleteDetailList = new ArrayList<HashMap<String,String>>();
	               
	               // Masert table Delete
	               // -------------------------------------------                            
	               deleteMasterList.add(param);
	               
	               //velocity parameter
	               HashMap<String, Object> vParam = new HashMap<String, Object>();
	               vParam.put("rpt_itm_cd", "");                       
	               
	               // Detail table Delete
	               // -------------------------------------------                            
	               deleteDetailList.add(param);
	               
	               vo.setMultiDeleteList(deleteDetailList);
	               vo.setIndirectVariableValues(vParam);
	               vo.setMultiDeleteList(deleteMasterList);                
	               
	               //[DB 실행]
	               //dbDao.multiSetFormRemoveDetail(vo);    
	               
	               //[DB 실행]
	               dbDao.multiSetFormRemoveMaster(vo);                 
	   		}

	           GeneralEventResponse eventResponse = new GeneralEventResponse();
	           eventResponse.setETCData("selGroup", fom_seq);
	           return eventResponse; // "SUCCESS"
	       } catch (DAOException de) {
	           log.error("err "+de.toString(),de);
	           throw new EventException(de.getMessage());
	       }
	   }

	/**
	    * Import Mastertable 화면 조회 화면 조회 메소드
	    * 
	    * @author Arie
	    * @param BkgInfoListVO[] bkgVOs
	    * @param SearchConditionVO scvo
	    * @return List<BkgInfoListVO>
	    * @throws EventException
	    */
	public List<BkgInfoListVO> searchBkgInfoList(BkgInfoListVO[] bkgVOs, SearchConditionVO scvo) throws EventException {
		try {
			return dbDao.searchBkgInfoList(bkgVOs, scvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
     * Booking Allocation Master Table 저장하기
     *
     * @author Arie
     * @param BkgInfoListVO[] bkgVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void multiBkgInfoList4MasterTable(BkgInfoListVO[] bkgVOs, SignOnUserAccount account) throws EventException {
		try {
        	//BookingUtil utilCmd = new BookingUtil();
        	int bkgAlocMgmtSeq = 0; 
        	String[] trunk_pod_cd = null;
        	String[] trunk_pol_cd = null;
        	String[] n1st_ts_pol_cd = null;
        	String[] n1st_ts_pod_cd = null;

			String[] ts_nod_cd = null;
			String[] ts_pol_nod_cd = null;
			String[] ts_pod_nod_cd = null;
        	
        	String[] por_cd = null;
        	String[] pol_cd = null;
        	String[] pod_cd = null;
        	String[] del_cd = null;
        	String[] n1st_ts_pol_cnt_cd = null;
        	String[] n1st_ts_pod_cnt_cd = null;
        	String[] bkg_por_cnt_cd = null;
        	String[] bkg_pol_cnt_cd = null;
        	String[] bkg_pod_cnt_cd = null;
        	String[] bkg_del_cnt_cd = null;
        	
        	String[] agmt_act_cnt_cd = null;//actual customer
        	String[] cmdt_cd = null;//commodity
        	String[] cntr_tpsz_cd = null;//cntr_tpsz_cd
        	SpcAlocMgmtDetailVO spcAlocMgmtDetailVO =null;
        	SpcBkgAlocMgmtCustDtlVO custDetailVO = null;//actual customer
        	SpcBkgAlocMgmtCmdtDtlVO cmdtDetailVO = null;//commodtiy
        	SpcBkgAlocMgmtCntrTpszDtlVO cntrTpszDetailVO = null;//cntrTpsz
        	
			List<SpcAlocMgmtDetailVO> insertDetailVoList = new ArrayList<SpcAlocMgmtDetailVO>();
			List<SpcBkgAlocMgmtCustDtlVO> insertDetailVoList2 = new ArrayList<SpcBkgAlocMgmtCustDtlVO>();//actual customer
			List<SpcBkgAlocMgmtCmdtDtlVO> insertDetailVoList3 = new ArrayList<SpcBkgAlocMgmtCmdtDtlVO>();//cmdt
			List<SpcBkgAlocMgmtCntrTpszDtlVO> insertDetailVoList4 = new ArrayList<SpcBkgAlocMgmtCntrTpszDtlVO>();//actual customer
			
			SpcAlocMgmtVO newVo = null;
			String[] dupReason = new String[1000];
			int dupCnt = 0;

			for ( int i=0; i<bkgVOs.length; i++ ) {
				if (StringUtils.isNotBlank(bkgVOs[i].getTrunkPolCd()) && "1".equals(bkgVOs[i].getTrnkPolYn())){
					trunk_pol_cd = bkgVOs[i].getTrunkPolCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getTrunkPodCd()) && "1".equals(bkgVOs[i].getTrnkPodYn())){
					trunk_pod_cd = bkgVOs[i].getTrunkPodCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getN1stTsPolCd()) && "1".equals(bkgVOs[i].getN1stTsPolYn())){
					n1st_ts_pol_cd = bkgVOs[i].getN1stTsPolCd().split(",");
					
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getN1stTsPodCd()) && "1".equals(bkgVOs[i].getN1stTsPodYn())){
					n1st_ts_pod_cd = bkgVOs[i].getN1stTsPodCd().split(",");
				}

				
				if (StringUtils.isNotBlank(bkgVOs[i].getTsNodCd()) && "1".equals(bkgVOs[i].getTsNodYn())){
					ts_nod_cd = bkgVOs[i].getTsNodCd().split(",");
				}

				if (StringUtils.isNotBlank(bkgVOs[i].getTsPolNodCd()) && "1".equals(bkgVOs[i].getTsPolNodYn())){
					ts_pol_nod_cd = bkgVOs[i].getTsPolNodCd().split(",");
				}

				if (StringUtils.isNotBlank(bkgVOs[i].getTsPodNodCd()) && "1".equals(bkgVOs[i].getTsPodNodYn())){
					ts_pod_nod_cd = bkgVOs[i].getTsPodNodCd().split(",");
				}
				
				
				//multi 입력으로 변경
				if (StringUtils.isNotBlank(bkgVOs[i].getPorCd()) && "1".equals(bkgVOs[i].getPorYn())){
					por_cd = bkgVOs[i].getPorCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getPolCd()) && "1".equals(bkgVOs[i].getPolYn())){
					pol_cd = bkgVOs[i].getPolCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getPodCd()) && "1".equals(bkgVOs[i].getPodCdYn())){
					pod_cd = bkgVOs[i].getPodCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getDelCd()) && "1".equals(bkgVOs[i].getDelYn())){
					del_cd = bkgVOs[i].getDelCd().split(",");
				}
				
				if (StringUtils.isNotBlank(bkgVOs[i].getN1stTsPolCntCd()) && "1".equals(bkgVOs[i].getN1stTsPolCntYn())){
					n1st_ts_pol_cnt_cd = bkgVOs[i].getN1stTsPolCntCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getN1stTsPodCntCd()) && "1".equals(bkgVOs[i].getN1stTsPodCntYn())){
					n1st_ts_pod_cnt_cd = bkgVOs[i].getN1stTsPodCntCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getBkgPorCntCd()) && "1".equals(bkgVOs[i].getBkgPorCntYn())){
					bkg_por_cnt_cd = bkgVOs[i].getBkgPorCntCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getBkgPolCntCd()) && "1".equals(bkgVOs[i].getBkgPolCntYn())){
					bkg_pol_cnt_cd = bkgVOs[i].getBkgPolCntCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getBkgPodCntCd()) && "1".equals(bkgVOs[i].getBkgPodCntYn())){
					bkg_pod_cnt_cd = bkgVOs[i].getBkgPodCntCd().split(",");
				}
				if (StringUtils.isNotBlank(bkgVOs[i].getBkgDelCntCd()) && "1".equals(bkgVOs[i].getBkgDelCntYn())){
					bkg_del_cnt_cd = bkgVOs[i].getBkgDelCntCd().split(",");
				}
				
				//actual customer agmt_act_cust_code
				if (StringUtils.isNotBlank(bkgVOs[i].getAgmtActCustCode()) && "1".equals(bkgVOs[i].getAgmtYn())){
					agmt_act_cnt_cd = bkgVOs[i].getAgmtActCustCode().split(",");
				}else{
					agmt_act_cnt_cd =null;
				}
				//commodity
				if (StringUtils.isNotBlank(bkgVOs[i].getCmdtCd()) && "1".equals(bkgVOs[i].getCmdtYn())){
					cmdt_cd = bkgVOs[i].getCmdtCd().split(",");
				}else{
					cmdt_cd =null;
				}
 				//cntr_tpsz_cd
				if (StringUtils.isNotBlank(bkgVOs[i].getCntrTpszCd())) {
					cntr_tpsz_cd = bkgVOs[i].getCntrTpszCd().split(",");
				} else {
					cntr_tpsz_cd = null;
				}
				if ( bkgVOs[i].getIbflag().equals("I") || bkgVOs[i].getIbflag().equals("U")){
log.debug("\n\n BkgInfoListVO=" + bkgVOs[i]);					
					//yn flag에 따라서 Data 변경---이부분이 복잡하겠구나.
					newVo = new SpcAlocMgmtVO();
					
					newVo.setSlsRhqCd(bkgVOs[i].getSlsRhqCd()); 														//sls_rhq_cd
					newVo.setBkgAlocTpCd(bkgVOs[i].getBkgAlocTpCd());  													//bkg_aloc_tp_cd
					
					if("1".equals(bkgVOs[i].getSubTrdYn())) newVo.setSubTrdCd(bkgVOs[i].getSubTrdCd()); 				//sub_trd_yn, sub_trd_cd
					if("1".equals(bkgVOs[i].getTrnkSlanYn())) newVo.setTrnkSlanCd(bkgVOs[i].getTrnkSlanCd());			//trnk_slan_yn, trnk_slan_cd
					if("1".equals(bkgVOs[i].getTrnkDirYn())) newVo.setTrnkDirCd(bkgVOs[i].getTrnkDirCd());				//trnk_dir_yn, trnk_dir_cd
					if("1".equals(bkgVOs[i].getTrnkPolYn())) newVo.setTrunkPolCd(bkgVOs[i].getTrunkPolCd());			//trnk_pol_yn, trunk_pol_cd
					if("1".equals(bkgVOs[i].getTrnkPodYn())) newVo.setTrunkPodCd(bkgVOs[i].getTrunkPodCd());			//trnk_pod_yn, trunk_pod_cd
					
					if("1".equals(bkgVOs[i].getBkgPorCntYn())) newVo.setBkgPorCntCd(bkgVOs[i].getBkgPorCntCd());		//bkg_por_cnt_yn, bkg_por_cnt_cd
					if("1".equals(bkgVOs[i].getPorYn())) newVo.setPorCd(bkgVOs[i].getPorCd());							//por_yn, por_cd
					if("1".equals(bkgVOs[i].getPorNodYn())) newVo.setPorNodCd(bkgVOs[i].getPorNodCd());					//por_nod_yn, por_nod_cd
					if("1".equals(bkgVOs[i].getBkgPorSccYn())) newVo.setBkgPorSccCd(bkgVOs[i].getBkgPorSccCd());		//bkg_por_scc_yn, bkg_por_scc_cd
					if("1".equals(bkgVOs[i].getBkgPolCntYn())) newVo.setBkgPolCntCd(bkgVOs[i].getBkgPolCntCd());		//bkg_pol_cnt_yn, bkg_pol_cnt_cd
					if("1".equals(bkgVOs[i].getPolYn())) newVo.setPolCd(bkgVOs[i].getPolCd());							//pol_yn, pol_cd
					if("1".equals(bkgVOs[i].getPolNodYn())) newVo.setPolNodCd(bkgVOs[i].getPolNodCd());					//pol_nod_yn, pol_nod_cd

					if("1".equals(bkgVOs[i].getN1stTsSlanYn())) newVo.setN1stTsSlanCd(bkgVOs[i].getN1stTsSlanCd());		//n1st_ts_slan_yn, n1st_ts_slan_cd
					if("1".equals(bkgVOs[i].getN1stTsDirYn())) newVo.setN1stTsDirCd(bkgVOs[i].getN1stTsDirCd());		//n1st_ts_dir_yn, n1st_ts_dir_cd
					if("1".equals(bkgVOs[i].getN1stTsPolCntYn())) newVo.setN1stTsPolCntCd(bkgVOs[i].getN1stTsPolCntCd());//n1st_ts_pol_cnt_yn, n1st_ts_pol_cnt_cd
					if("1".equals(bkgVOs[i].getN1stTsPolYn())) newVo.setN1stTsPolCd(bkgVOs[i].getN1stTsPolCd());		//n1st_ts_pol_yn, n1st_ts_pol_cd
					if("1".equals(bkgVOs[i].getN1stTsPodCntYn())) newVo.setN1stTsPodCntCd(bkgVOs[i].getN1stTsPodCntCd());//n1st_ts_pod_cnt_yn, n1st_ts_pod_cnt_cd
					if("1".equals(bkgVOs[i].getN1stTsPodYn())) newVo.setN1stTsPodCd(bkgVOs[i].getN1stTsPodCd());		//n1st_ts_pod_yn, n1st_ts_pod_cd
					
					if("1".equals(bkgVOs[i].getTsNodYn())) newVo.setTsNodCd(bkgVOs[i].getTsNodCd());		
					if("1".equals(bkgVOs[i].getTsPodNodYn())) newVo.setTsPodNodCd(bkgVOs[i].getTsPodNodCd());
					if("1".equals(bkgVOs[i].getTsPolNodYn())) newVo.setTsPolNodCd(bkgVOs[i].getTsPolNodCd());	
				

					if("1".equals(bkgVOs[i].getBkgPodCntYn())) newVo.setBkgPodCntCd(bkgVOs[i].getBkgPodCntCd());		//bkg_pod_cnt_yn, bkg_pod_cnt_cd
					if("1".equals(bkgVOs[i].getPodCdYn())) newVo.setPodCd(bkgVOs[i].getPodCd());						//pod_cd_yn, pod_cd
					if("1".equals(bkgVOs[i].getPodNodYn())) newVo.setPodNodCd(bkgVOs[i].getPodNodCd());					//pod_nod_yn, pod_nod_cd
					if("1".equals(bkgVOs[i].getBkgDelCntYn())) newVo.setBkgDelCntCd(bkgVOs[i].getBkgDelCntCd());		//bkg_del_cnt_yn, bkg_del_cnt_cd
					if("1".equals(bkgVOs[i].getDelYn())) newVo.setDelCd(bkgVOs[i].getDelCd());							//del_yn, del_cd
					if("1".equals(bkgVOs[i].getDelNodYn())) newVo.setDelNodCd(bkgVOs[i].getDelNodCd());					//del_nod_yn, del_nod_cd
					
					if("1".equals(bkgVOs[i].getVvdYn())) newVo.setVvd(bkgVOs[i].getVvd());								//vvd_yn, vvd
					if("1".equals(bkgVOs[i].getCntrTpszYn())) newVo.setCntrTpszCd(bkgVOs[i].getCntrTpszCd());			//cntr_tpsz_yn, cntr_tpsz_cd
					if("1".equals(bkgVOs[i].getDgRdYn())) {																//dg_rd_yn, dg_flg, rd_flg
						newVo.setDgRd(bkgVOs[i].getDgFlg());
						newVo.setDgRd(bkgVOs[i].getRdFlg());
					}

					if("1".equals(bkgVOs[i].getObSlsOfcYn())) newVo.setObSlsOfcCd(bkgVOs[i].getObSlsOfcCd());			//ob_sls_ofc_yn, ob_sls_ofc_cd, ob_sls_ofc_nm
					if("1".equals(bkgVOs[i].getScYn())) newVo.setScNo(bkgVOs[i].getScNo());								//sc_yn, sc_no
					if("1".equals(bkgVOs[i].getRfaYn())) newVo.setRfaNo(bkgVOs[i].getRfaNo());							//rfa_yn, rfa_no

					if("1".equals(bkgVOs[i].getCtrtYn())) newVo.setCtrtCustCntCd(bkgVOs[i].getCtrtCustCode());			//ctrt_yn, ctrt_cust_cnt_cd, ctrt_cust_seq, ctrt_cust_code, ctrt_cust_lgl_eng_nm
//					if("1".equals(bkgVOs[i].getAgmtYn())) newVo.setAgmtActCntCd(bkgVOs[i].getAgmtActCustCode());		//agmt_yn, agmt_act_cnt_cd, agmt_act_cust_seq, agmt_act_cust_code,agmt_cust_lgl_eng_nm 
					if("1".equals(bkgVOs[i].getShprYn())) newVo.setCustCntCd(bkgVOs[i].getShprCustCode());				//shpr_yn, shpr_cust_cnt_cd, shpr_cust_seq, shpr_cust_code, shpr_cust_lgl_eng_nm, --cust_cnt_cd 
					
					if("1".equals(bkgVOs[i].getOftChgYn())) newVo.setOftChgAmt(bkgVOs[i].getOftChgAmt());				//oft_chg_yn, oft_chg_amt
					if("1".equals(bkgVOs[i].getCmpbYn())) {																//cmpb_yn, cmpb_rule_cd, cmpb_amt
//						newVo.setCmpbRuleCd(bkgVOs[i].getCmpbRuleCd());	
						newVo.setCmpbAmt(bkgVOs[i].getCmpbAmt());
					}
					if("1".equals(bkgVOs[i].getAlocLodYn())) newVo.setAlocLodQty(bkgVOs[i].getAlocLodQty());			//aloc_lod_yn, aloc_lod_qty 
					if("1".equals(bkgVOs[i].getAlocRtoYn())) newVo.setAlocLodQtyRto(bkgVOs[i].getAlocLodQtyRto());		//aloc_rto_yn, aloc_lod_qty_rto
					
					if("1".equals(bkgVOs[i].getScgGrpCmdtYn())) newVo.setScgGrpCmdtSeq(bkgVOs[i].getScgGrpCmdtSeq());	//scg_grp_cmdt_yn, scg_grp_cmdt_seq, scg_grp_cmdt_desc
//					if("1".equals(bkgVOs[i].getCmdtYn())) newVo.setCmdtCd(bkgVOs[i].getCmdtCd());						//cmdt_yn, cmdt_cd, cmdt_nm
					newVo.setCntrTpszCd(bkgVOs[i].getCntrTpszCd());
					newVo.setAlocSvcCd(bkgVOs[i].getAlocSvcCd());														//aloc_svc_cd
					
					newVo.setBkgCtrlTpCd(bkgVOs[i].getBkgCtrlTpCd());													//bkg_ctrl_tp_cd                    
					newVo.setBkgAlocRmk(bkgVOs[i].getBkgAlocRmk());														//bkg_aloc_rmk                    
					newVo.setAplyFmYrwk(bkgVOs[i].getAplyFmYrwk());													//aloc_aply_fm_dt ->   aply_fm_yrwk                
					newVo.setAplyToYrwk(bkgVOs[i].getAplyToYrwk());													//aloc_aply_to_dt ->   aply_to_yrwk               
					newVo.setAlocUseFlg(bkgVOs[i].getAlocUseFlg());														//aloc_use_flg                    
					
					newVo.setCreUsrId(account.getUsr_id()); 
					newVo.setUpdUsrId(account.getUsr_id());
    
					List<SpcAlocMgmtVO> list = dbDao.searchBkgAlocDupCheckData(newVo);
log.debug("\n\n newVo=" + newVo);                   
					//중복체크
                    if(list.size()>0){
                    	dupCnt = dupCnt + 1;
                    	dupReason[dupCnt-1] = list.get(0).getBkgAlocTpCd();
	                    String detail = list.get(0).getBkgAlocTpCd();
	                    throw new EventException((String)new ErrorHandler("COM12115",new String[]{ detail }).getMessage());
                    }

					bkgAlocMgmtSeq = Integer.parseInt(dbDao.searchBkgAlocMgmtSeq());
					newVo.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
					
                    dbDao.addBkgAlocMgmt(newVo);		//merge로 바꾸기	
//                    dbDao.addBkgAlocMgmtHist(newVo);		//merge로 바꾸기	
                    
                    //LOC
                    if(trunk_pol_cd!=null&&trunk_pol_cd.length>0){
						for(int k = 0; k < trunk_pol_cd.length ; k++){
							log.debug("POL-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));							
							spcAlocMgmtDetailVO.setSbLocDivCd("TPL");
							spcAlocMgmtDetailVO.setSbLocCd(trunk_pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(trunk_pod_cd!=null&&trunk_pod_cd.length>0){
						for(int k = 0; k < trunk_pod_cd.length ; k++){
							log.debug("POD-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("TPD");
							spcAlocMgmtDetailVO.setSbLocCd(trunk_pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                	        	
                    if(por_cd!=null&&por_cd.length>0){
						for(int k = 0; k < por_cd.length ; k++){
							log.debug("por_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POR");
							spcAlocMgmtDetailVO.setSbLocCd(por_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(pol_cd!=null&&pol_cd.length>0){
						for(int k = 0; k < pol_cd.length ; k++){
							log.debug("pol_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POL");
							spcAlocMgmtDetailVO.setSbLocCd(pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(pod_cd!=null&&pod_cd.length>0){
						for(int k = 0; k < pod_cd.length ; k++){
							log.debug("pod_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POD");
							spcAlocMgmtDetailVO.setSbLocCd(pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(del_cd!=null&&del_cd.length>0){
						for(int k = 0; k < del_cd.length ; k++){
							log.debug("del_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("DEL");
							spcAlocMgmtDetailVO.setSbLocCd(del_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }                    

                    if(bkg_por_cnt_cd!=null&&bkg_por_cnt_cd.length>0){
						for(int k = 0; k < bkg_por_cnt_cd.length ; k++){
							log.debug("bkg_por_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POR");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_por_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(bkg_pol_cnt_cd!=null&&bkg_pol_cnt_cd.length>0){
						for(int k = 0; k < bkg_pol_cnt_cd.length ; k++){
							log.debug("bkg_pol_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POL");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_pol_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(bkg_pod_cnt_cd!=null&&bkg_pod_cnt_cd.length>0){
						for(int k = 0; k < bkg_pod_cnt_cd.length ; k++){
							log.debug("bkg_pod_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("POD");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_pod_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(bkg_del_cnt_cd!=null&&bkg_del_cnt_cd.length>0){
						for(int k = 0; k < bkg_del_cnt_cd.length ; k++){
							log.debug("bkg_del_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("DEL");
							spcAlocMgmtDetailVO.setSbLocCd(bkg_del_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    
                    if(n1st_ts_pol_cnt_cd!=null&&n1st_ts_pol_cnt_cd.length>0){
						for(int k = 0; k < n1st_ts_pol_cnt_cd.length ; k++){
							log.debug("n1st_ts_pol_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPL");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pol_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(n1st_ts_pod_cnt_cd!=null&&n1st_ts_pod_cnt_cd.length>0){
						for(int k = 0; k < n1st_ts_pod_cnt_cd.length ; k++){
							log.debug("n1st_ts_pod_cnt_cd-SEQ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPD");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pod_cnt_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }                    
                    if(n1st_ts_pol_cd!=null&&n1st_ts_pol_cd.length>0){
						for(int k = 0; k < n1st_ts_pol_cd.length ; k++){
							log.debug("n1st_ts_pol_cd");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPL");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pol_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    if(n1st_ts_pod_cd!=null&&n1st_ts_pod_cd.length>0){
						for(int k = 0; k < n1st_ts_pod_cd.length ; k++){
							log.debug("n1st_ts_pod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SPD");
							spcAlocMgmtDetailVO.setSbLocCd(n1st_ts_pod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }

                    if(ts_nod_cd!=null&&ts_nod_cd.length>0){
						for(int k = 0; k < ts_nod_cd.length ; k++){
							log.debug("ts_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SAY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }

                    if(ts_pol_nod_cd!=null&&ts_pol_nod_cd.length>0){
						for(int k = 0; k < ts_pol_nod_cd.length ; k++){
							log.debug("ts_pol_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SLY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_pol_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }

                    if(ts_pod_nod_cd!=null&&ts_pod_nod_cd.length>0){
						for(int k = 0; k < ts_pod_nod_cd.length ; k++){
							log.debug("ts_pod_nod_cd ");
							spcAlocMgmtDetailVO = new SpcAlocMgmtDetailVO();
							spcAlocMgmtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							spcAlocMgmtDetailVO.setSbLocDivCd("SDY");
							spcAlocMgmtDetailVO.setSbLocCd(ts_pod_nod_cd[k]);
							spcAlocMgmtDetailVO.setCreUsrId(account.getUsr_id());
							spcAlocMgmtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList.add(spcAlocMgmtDetailVO);
						}
                    }
                    
                    //Actual Customer
                    if(agmt_act_cnt_cd!=null&&agmt_act_cnt_cd.length>0){
						for(int k = 0; k < agmt_act_cnt_cd.length ; k++){
							log.debug("AcutalCustomer-SEQ");
							custDetailVO = new SpcBkgAlocMgmtCustDtlVO();
							custDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							custDetailVO.setBkgCustTpCd("B"); //B: Actual (실제화주)
							custDetailVO.setCustCntCd(agmt_act_cnt_cd[k]);
							custDetailVO.setCustSeq(agmt_act_cnt_cd[k]);
							custDetailVO.setCreUsrId(account.getUsr_id());
							custDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList2.add(custDetailVO);
						}
                    }
                    
                    //Commodity
                    if(cmdt_cd!=null&&cmdt_cd.length>0){
						for(int k = 0; k < cmdt_cd.length ; k++){
							log.debug("Commodity-SEQ");
							cmdtDetailVO = new SpcBkgAlocMgmtCmdtDtlVO();
							cmdtDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							cmdtDetailVO.setCmdtCd(cmdt_cd[k]);
							cmdtDetailVO.setCreUsrId(account.getUsr_id());
							cmdtDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList3.add(cmdtDetailVO);
						}
                    }
                  //cntrTpsz
					if (cntr_tpsz_cd != null && cntr_tpsz_cd.length > 0) {
						for (int k = 0; k < cntr_tpsz_cd.length; k++) {
							log.debug("cntr_tpsz_cd-SEQ");
							cntrTpszDetailVO = new SpcBkgAlocMgmtCntrTpszDtlVO();
							cntrTpszDetailVO.setBkgAlocSeq(Integer.toString(bkgAlocMgmtSeq));
							cntrTpszDetailVO.setCntrTpszCd(cntr_tpsz_cd[k]);
							cntrTpszDetailVO.setCreUsrId(account.getUsr_id());
							cntrTpszDetailVO.setUpdUsrId(account.getUsr_id());
							insertDetailVoList4.add(cntrTpszDetailVO);
						}
					}
				}
			}
			//Location
			if ( insertDetailVoList.size() > 0 ) {
				dbDao.addBkgAlocMgmtDetail(insertDetailVoList); //merge로 바꾸기
//				dbDao.addBkgAlocMgmtDetailHist(insertDetailVoList); //merge로 바꾸기
			}
			//Actual Customer
			if ( insertDetailVoList2.size() > 0 ) {
				dbDao.addBkgAlocMgmtCustDetail(insertDetailVoList2);
//				dbDao.addBkgAlocMgmtCustDetailHist(insertDetailVoList2);
			}
			//Commoditiy
			if ( insertDetailVoList3.size() > 0 ) {
				dbDao.addBkgAlocMgmtCmdtDetail(insertDetailVoList3);
//				dbDao.addBkgAlocMgmtCmdtDetailHist(insertDetailVoList3);
			}
			//cntrTpsz
			if (insertDetailVoList4.size() > 0) {
				dbDao.addBkgAlocMgmtCntrTpszDetail(insertDetailVoList4);
			}
        } catch (EventException ex) {
            throw ex;      
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
	
	/**
	 *  Compulsory Firm 대상 Booking 정보를 조회한다.<br> Compulsory Firm Copy : 2015.02.11 김성욱
	 *
	 * @author KimByungKyu
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchCompulsoryFirmVO>
	 * @exception EventException
	 */
	public List<SearchCompulsoryFirmVO> searchCompulsoryFirmList(SearchConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCompulsoryFirmList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Office Setup 에 등록된 Office code 인지 여부를 체크합니다.(ESM_SPC_0115)<br>
	 * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<spcAlocMgmtVO>
	 * @exception EventException
	 */
	public List<SpcAlocMgmtVO> checkOfficePfmc(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException {
		try {
			return dbDao.checkOfficePfmc(spcAlocMgmtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  Office Setup 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.(ESM_BKG_0741)<br>
	 * 
	 * @param SpcAlocMgmtVO spcAlocMgmtVO
	 * @return List<SpcAlocMgmtVO>
	 * @exception EventException
	 */	
	public List<SpcAlocMgmtVO> checkCtrlOffice(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException {
		try {
			return dbDao.checkCtrlOffice(spcAlocMgmtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel(VVD)존재체크.<br>
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @return boolean
	 * @throws EventException
	 */
	public boolean validateVvd(String vslCd, String voyNo, String dirCd) throws EventException {
		try {
			return dbDao.validateVvd(vslCd, voyNo, dirCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
     * ESM_BKG_0079_01 : VVD로 Lane 조회<br>
	 * @author 	KimByungKyu
	 * @param  	String vvd
	 * @return 	String 
	 * @throws EventException
	 */
	public String searchSvcLaneByVvd(String vvd) throws EventException {
		try {
			return dbDao.searchSvcLaneByVvd(vvd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	//	/**
	//     * Import Mastertable 화면 조회 화면 조회 메소드
	//     * 
	//     * @author Arie
	//     * @return List<ReapplyBKGListVO>
	//     * @throws EventException
	//     */
	//    public List<ReapplyBKGListVO> searchReapplyBKGList() throws EventException{
	//        try {
	//            return dbDao.searchReapplyBKGList();
	//        } catch(DAOException ex) {
	//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	//        } catch (Exception ex) {
	//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	//        }
	//    }

    /**
	 * SPC_SB_BKG 데이터를 MERGE한다.<BR>
	 * 
     * @author Arie
	 * @param  SpcSbBkgVO vo
     * @return GeneralEventResponse
	 * @throws DAOException
	 */
	public GeneralEventResponse multiSpcSbBk(SpcSbBkgVO vo) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			dbDao.multiSpcSbBk(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse; // "SUCCESS"
	}

    /**
	 * Conpulsory firm 의 confirm Request<BR>
	 * 
     * @author Kim Sung Wook
	 * @param  SpcSbBkgVO[] vos
	 * @param  SignOnUserAccount account
     * @return boolean
	 * @throws EventException
	 */
	public boolean confirmRequest(SpcSbBkgVO[] vos, SignOnUserAccount account) throws EventException {
		String userId = account.getUsr_id();
		try {
			for (int i = 0; i < vos.length; i++) {
				vos[i].setCfmRqstUsrId(userId);
				//        		System.out.println( "\n\n#####====>>"+vos[i].getCfmRqstFlg() +"userId="+userId);
				//        		if( vos[i].getCfmRqstFlg() != null && vos[i].getCfmRqstFlg().equals("1") )
				//        			vos[i].setCfmRqstFlg("Y");
				//        		else
				//        			vos[i].setCfmRqstFlg("N");
				if (vos[i].getBkgNo() != null && vos[i].getBkgNo() != "") {
					dbDao.multiSpcSbBk(vos[i]);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return false;
	}

    /**
	 * BKG에서 호출하는 BKG한건당 Standby 조건 체크<BR>
	 * 
     * @author Arie Im
	 * @param  String bkg_no
	 * @param  SignOnUserAccount account
     * @return List<SpcSbBkgDtlVO>
	 * @throws EventException
	 */
	public List<SpcSbBkgDtlVO> standbyCheck4Bkg(String bkg_no, SignOnUserAccount account) throws EventException {
		try {
			SpcSbBkgDtlVO vo = new SpcSbBkgDtlVO();
			vo.setBkgNo(bkg_no);
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			return dbDao.standbyCheck4Bkg(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Standby를 Firm 으로 변경함.
	 * @param BkgListForCompFirmBySPCVO vo
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @throws EventException
	 */
	public boolean setComfirm(BkgListForCompFirmBySPCVO vo, SignOnUserAccount account) throws EventException {
		String userId = account.getUsr_id();
		try {
			vo.setCfmUsrId(userId);
			if (vo.getBkgNo() != null && vo.getBkgNo() != "") {
				dbDao.setComfirm(vo);
				dbDao.setDetailComfirm(vo);				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return false;
	}


/*	public String doReprocess(SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		ConstraintMasterBackEndJob backEndJob = new ConstraintMasterBackEndJob();
		String userId = account.getUsr_id();
		try {
			conditionVO.setFUsrId(userId);
			backEndJob.setSearchConditionVO(conditionVO);
			BackEndJobManager backEndJobManager = new BackEndJobManager();

			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "SB Reprocess");

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
*/
	/**
	 * Reprocess 버튼 클릭시 수행
	 * DB Procedure 호출
	 * 
	 * @param SearchConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String doReprocess(SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException {		
		ScheduleUtil su = new ScheduleUtil();
        
        String status = "";
		try {
			/*
			modeId		= param[0];	//필수
			userId		= param[1]; //필수
			ofcId		= param[2]; //필수
			*/
			
			String params = conditionVO.getFStsCd() // R:Running
					+ "#" + account.getUsr_id() 
					+ "#" + account.getOfc_cd() ; 

			log.debug("++++++++++++++++++++params++++:"+params);
			status = su.directExecuteJob("ESM_SPC_B014",params);
			log.debug("++++++++++++++++++++status++++:"+status);
			
		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12208", new String[]{""}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12208", new String[]{""}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12208", new String[]{""}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12208", new String[]{""}).getMessage(),e);
		}
		return "C";//실행 성공
	}	
	

	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException {
		DBRowSet rowSet;
		String[] rtnArr = new String[2];
		
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			rtnArr[0] = (String) rowSet.getObject("jb_sts_flg");
			rtnArr[1] = (String) rowSet.getObject("jb_usr_err_msg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
		return rtnArr;
	}

	/**
	 * ESM_SPC_0116 : SEARCH03<br>
	 * Reprocess 버튼 클릭 시 수행전 현재 같은 조건으로 Reprocess되고 있는 백엔드잡이 있는지 체크합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkReprocessCondition(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.checkReprocessCondition(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
	 * ESM_SPC_0116 : MODIFY03<br>
	 * Reprocess 시작 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에 삽입합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
     */
	public void addReprocessCondition(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		String userId = account.getUsr_id();
		try {
			searchConditionVO.setFUsrId(userId);
			dbDao.addReprocessCondition(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
    /**
	 * ESM_SPC_0116 : MODIFY04<br>
	 * Reprocess 종료 시 해당조건을 SPC_SB_BKG_PROC_STS 테이블에서 삭제합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @exception EventException
     */
	public void removeReprocessCondition(SearchConditionVO searchConditionVO) throws EventException {
		try {
			dbDao.removeReprocessCondition(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Office에 해당 하는 Level 값을 가져온다.
	 * @param SearchOfficeCondVO vo
	 * @param SignOnUserAccount account
	 * @return SearchOfficeCondVO
	 * @throws EventException
	 */
	public String searchOfcLevel(SearchOfficeCondVO vo, SignOnUserAccount account) throws EventException {
		String rvo = new String();
		try {
			rvo = dbDao.searchOfcLevel(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return rvo;
	}

	
	
	/**
	 * Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받는다.<br>
	 * 
	 * @param String propNo
	 * @param String amdtSeq
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addFixedFlagInfoByPri(String propNo, String amdtSeq, SignOnUserAccount account) throws EventException {
		
		ConstraintMasterIFBackEndJob backEndJob = new ConstraintMasterIFBackEndJob();
		backEndJob.setPropNo(propNo);
		backEndJob.setAmdtSeq(amdtSeq);
		backEndJob.setUsrId(account.getUsr_id());
		backEndJob.setJobType("FixedFlagIF");
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			backEndJobManager.execute(backEndJob, account.getUsr_id(), "Fixed Flag InFo IF by Pri");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Booking Creation Status 돋보기 누르면 나오는 화면에 대한 조회(Estimated CMPB)
	 * 
	 * @author 
	 * @param String bkgNo
	 * @return List<EstimatedCMPBVO>
	 * @exception EventException
	 */
	public List<EstimatedCMPBVO> searchEstimatedCMPB(String bkgNo) throws EventException {
		try {
			return dbDao.searchEstimatedCMPB(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/*============================== ESM_SPC_0052, 0114 package 변경 시작==============================*/
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param searchSpaceAllocationLaneControlOptionVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiSpaceAllocationControlOption(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SearchSpaceAllocationLaneControlOptionVO> insertVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			List<SearchSpaceAllocationLaneControlOptionVO> updateVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			List<SearchSpaceAllocationLaneControlOptionVO> bkgCtrlLaneDelVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			
			for ( int i=0; i<searchSpaceAllocationLaneControlOptionVOs .length; i++ ) {
				searchSpaceAllocationLaneControlOptionVOs[i].setUpdUsrId(account.getUsr_id());
				
				//2015.04.23 Aloc Flag 값이 설정되면 Booking Control Option 에 Default 값이 설정되도록 수정.
//				String alocFlg = searchSpaceAllocationLaneControlOptionVOs[i].getBkgCtrlAlocFlg();
				
				if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("U")){
				    if(searchSpaceAllocationLaneControlOptionVOs[i].getTmpAcctFlg().equals("")){
						insertVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
					}else{
						if( searchSpaceAllocationLaneControlOptionVOs[i].getRdFlg().equals("1"))
							searchSpaceAllocationLaneControlOptionVOs[i].setUpdUsrId( account.getUsr_id() );
							
						updateVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
					}
					
				} else if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("I")){
					searchSpaceAllocationLaneControlOptionVOs[i].setUpdUsrId( account.getUsr_id() );
					insertVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
					
				} 
				// 위 시트의 by Lane uncheck시 SPC_BKG_CTRL_OPT_DTL 에서 해당 Lane, Bound 데이터를 지움
				if(searchSpaceAllocationLaneControlOptionVOs[i].getBkgCtrlLaneUpdFlg().equals("Y")){
					bkgCtrlLaneDelVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
				}
				
			}
			
			// 신규 정보 생성
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpaceAllocationControlOptionS(insertVoList); //SPC_ALOC_LANE_CTRL_OPT
			}
			
			// Account Group 적용 Week 외 정보들을 업데이트한다.
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpaceAllocationControlOptionS(updateVoList); //SPC_ALOC_LANE_CTRL_OPT
			}
			
			if ( insertVoList.size() > 0) {
				dbDao.modifySpaceAllocationControlOptionS(insertVoList); //SPC_ALOC_CTRL_OPT
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpaceAllocationControlOptionS(updateVoList); //SPC_ALOC_CTRL_OPT
			}
			
			// 위 시트의 by Lane uncheck시 SPC_BKG_CTRL_OPT_DTL 에서 해당 Lane, Bound 데이터를 지움
			if ( bkgCtrlLaneDelVoList.size() > 0 ) {
				dbDao.deleteBkgCtrlOptDtlByLane(bkgCtrlLaneDelVoList); //SPC_BKG_CTRL_OPT_DTL 에서 해당 Lane, Bound 데이터를 지움
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param conditionVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationControlOptionDetail(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceAllocationLaneControlOptionVO> list = dbDao.searchSpaceAllocationControlOptionDetail(conditionVO);
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param searchSpaceAllocationLaneControlOptionVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiSpaceAllocationLaneControlOptionDetail(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SearchSpaceAllocationLaneControlOptionVO> insertVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			List<SearchSpaceAllocationLaneControlOptionVO> updateVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			List<SearchSpaceAllocationLaneControlOptionVO> deleteVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			
			//Control option의 Office 값 이 추가 되면서 저장되는 테이블이 서로 달라 다른 VO를 이용하여 처리 함.
			List<SearchOfficeInControlVO> insertVo = new ArrayList<SearchOfficeInControlVO>();
			List<SearchOfficeInControlVO> updateVo = new ArrayList<SearchOfficeInControlVO>();
			List<SearchOfficeInControlVO> deleteVo = new ArrayList<SearchOfficeInControlVO>();
			
			for ( int i=0; i<searchSpaceAllocationLaneControlOptionVOs.length; i++ ) {
				searchSpaceAllocationLaneControlOptionVOs[i].setUpdUsrId(account.getUsr_id());
				
				String tempOfc = searchSpaceAllocationLaneControlOptionVOs[i].getOfcCd();
				String[] ofcAry = tempOfc.split(",");
				
				if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("I")) {
					insertVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
				}
				else if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("U")) {
					//Fixed Flag 바뀔때만 Upadate를 함
					updateVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
				}
				else if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
				}
				
				for( int x=0 ; x<ofcAry.length ; x++ ) {
					if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("I")) {
						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
							insertVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVOs[i] , ofcAry[x] ));
					}
					else if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("U")) {
//						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
						if( ofcAry[x] != null && !ofcAry[x].equals("null"))
							updateVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVOs[i] , ofcAry[x] ));
						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
							insertVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVOs[i] , ofcAry[x] ));
					}
					else if(searchSpaceAllocationLaneControlOptionVOs[i].getIbflag().equals("D")) {
//						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
						if( ofcAry[x] != null && !ofcAry[x].equals("null"))
							deleteVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVOs[i] , ofcAry[x] ));
					}
				}
			}
						
			// 신규 정보 생성
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpaceAllocationLaneControlOptionDetail(insertVoList);
			}
			
			// Fixed Flag 정보 수정
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpaceAllocationLaneControlOptionDetail(updateVoList);
			}
			
			if( deleteVoList.size() > 0 ) {
				dbDao.removeSpaceAllocationLaneControlOptionDetail(deleteVoList);
			}
			
			//Control Option Office List 처리
			if( deleteVo.size() > 0 ) {
				dbDao.spaceAllocationLaneControlOptionOfficeListDelete(deleteVo);
			}
			
			if( updateVo.size() > 0 ) {
				dbDao.spaceAllocationLaneControlOptionOfficeListUpdate(updateVo);
			}
			
			if( insertVo.size() > 0 ) {
				dbDao.spaceAllocationLaneControlOptionOfficeListInsert(insertVo);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
//	/**
//	 * [ESM_SPC_0052]을 [행위] 합니다.
//	 * 
//	 * @param searchSpaceAllocationLaneControlOptionVOs
//	 * @param account
//	 * @throws EventException
//	 */
//	public void multiSpaceAllocationLaneControlOptionDetail02(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs, SignOnUserAccount account) throws EventException {
//		try {
//			List<SearchSpaceAllocationLaneControlOptionVO> mergeVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
//		
//			for ( int i=0; i<searchSpaceAllocationLaneControlOptionVOs.length; i++ ) {
//				searchSpaceAllocationLaneControlOptionVOs[i].setUpdUsrId(account.getUsr_id());
//				mergeVoList.add(searchSpaceAllocationLaneControlOptionVOs[i]);
//
//			}
//						
//			// 신규 정보 생성
//			if ( mergeVoList.size() > 0 ) {
//				dbDao.addSpaceAllocationLaneControlOptionDetail02(mergeVoList);
//			}
//			
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
//		}
//	}	
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param searchSpaceAllocationLaneControlOptionVO
	 * @throws EventException
	 */
	public void removeSpaceAllocationLaneControlOptionDetail(SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO) throws EventException {
		try {
			dbDao.removeSpaceAllocationLaneControlOptionDetail(searchSpaceAllocationLaneControlOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocationLaneControlOptionDetail02(SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchSpaceAllocationLaneControlOptionVO> mergeVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			List<SearchSpaceAllocationLaneControlOptionVO> deleteVoList = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
			
			List<SearchOfficeInControlVO> insertVo = new ArrayList<SearchOfficeInControlVO>();
			List<SearchOfficeInControlVO> updateVo = new ArrayList<SearchOfficeInControlVO>();
			List<SearchOfficeInControlVO> deleteVo = new ArrayList<SearchOfficeInControlVO>();
			
			for ( int i=0; i<searchSpaceAllocationLaneControlOptionVO .length; i++ ) {
				
				String tempOfc = searchSpaceAllocationLaneControlOptionVO[i].getOfcCd();
				String[] ofcAry = tempOfc.split(",");
				
				if ( searchSpaceAllocationLaneControlOptionVO[i].getIbflag().equals("D")){
					deleteVoList.add(searchSpaceAllocationLaneControlOptionVO[i]);
				} else {//Insert이거나 Update일수 있음
					searchSpaceAllocationLaneControlOptionVO[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(searchSpaceAllocationLaneControlOptionVO[i]);
				}
				
				for( int x=0 ; x<ofcAry.length ; x++ ) {
					if(searchSpaceAllocationLaneControlOptionVO[i].getIbflag().equals("I")) {
						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
							insertVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVO[i] , ofcAry[x] ));
					}
					else if(searchSpaceAllocationLaneControlOptionVO[i].getIbflag().equals("U")) {
//						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
						if( ofcAry[x] != null && !ofcAry[x].equals("null"))
							updateVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVO[i] , ofcAry[x] ));
						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
							insertVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVO[i] , ofcAry[x] ));
					}
					else if(searchSpaceAllocationLaneControlOptionVO[i].getIbflag().equals("D")) {
//						if( ofcAry[x] != null && !ofcAry[x].equals("") && !ofcAry[x].equals("null"))
						if( ofcAry[x] != null && !ofcAry[x].equals("null"))
							deleteVo.add( copy2SearchOfficeInControlVO(searchSpaceAllocationLaneControlOptionVO[i] , ofcAry[x] ));
					}
				}
			}
			
			if ( mergeVoList.size() > 0 ) {
				dbDao.mergeSpaceAllocationLaneControlOptionDetail02(mergeVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpaceAllocationLaneControlOptionDetail02(deleteVoList);
			}
			
			//Control Option Office List 처리
			if( deleteVo.size() > 0 ) {
				dbDao.spaceAllocationLaneControlOptionOfficeListDelete(deleteVo);
			}
			
			if( updateVo.size() > 0 ) {
				dbDao.spaceAllocationLaneControlOptionOfficeListUpdate(updateVo);
			}
			
			if( insertVo.size() > 0 ) {
				dbDao.spaceAllocationLaneControlOptionOfficeListInsert(insertVo);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * Office 정보 가져오기
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 * @return List<SqmQtaLaneOfcVO>
	 * @throws EventException
	 */
	public List<SqmQtaLaneOfcVO> searchSpaceAllocationControloffice(SqmQtaLaneOfcVO sqmQtaLaneOfcVO) throws EventException {
		try {
			List<SqmQtaLaneOfcVO> list = dbDao.searchSpaceAllocationControloffice(sqmQtaLaneOfcVO);
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 선택된 control 에 속한 Office 정보 가져오기
	 * @param SearchOfficeInControlVO searchOfficeInControlVO
	 * @return List<SearchOfficeInControlVO>
	 * @throws EventException
	 */
	public List<SearchOfficeInControlVO> searchSpaceAllocationOfficeInControl(SearchOfficeInControlVO searchOfficeInControlVO) throws EventException {
		try {
			List<SearchOfficeInControlVO> list = dbDao.searchSpaceAllocationOfficeInControl(searchOfficeInControlVO);
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * multiSpaceAllocationBKGControlOptionOfficeList 
	 * @param SearchOfficeBKGInControlVO[] searchOfficeInBKGControlVOs 
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpaceAllocationBKGControlOptionOfficeList( SearchOfficeBKGInControlVO[] searchOfficeInBKGControlVOs , SignOnUserAccount account ) throws EventException {
		try {
			List<SearchOfficeBKGInControlVO> insertVOList = new ArrayList<SearchOfficeBKGInControlVO>();
			List<SearchOfficeBKGInControlVO> updateVOList = new ArrayList<SearchOfficeBKGInControlVO>();
			List<SearchOfficeBKGInControlVO> deleteVOList = new ArrayList<SearchOfficeBKGInControlVO>();
			
			String trd_cd = "";
			String sub_trd_cd = "";
			String rlane_cd = "";
			String dir_cd = "";
			
			for( int x=0 ; x<searchOfficeInBKGControlVOs.length ; x++ ) {
				
				SearchOfficeBKGInControlVO searchOfficeInBKGControlVO = searchOfficeInBKGControlVOs[x];
				searchOfficeInBKGControlVO.setCreUsrId( account.getUsr_id() );
				searchOfficeInBKGControlVO.setUpdUsrId( account.getUsr_id() );
				
				if( x == 0 ) {
					trd_cd = searchOfficeInBKGControlVO.getTrdCd();
					sub_trd_cd = searchOfficeInBKGControlVO.getSubTrdCd();
					rlane_cd = searchOfficeInBKGControlVO.getRlaneCd();
					dir_cd = searchOfficeInBKGControlVO.getDirCd();

				} else {
					searchOfficeInBKGControlVO.setTrdCd(trd_cd);
					searchOfficeInBKGControlVO.setSubTrdCd(sub_trd_cd);
					searchOfficeInBKGControlVO.setRlaneCd(rlane_cd);
					searchOfficeInBKGControlVO.setDirCd(dir_cd);
				}
				
				if( searchOfficeInBKGControlVO.getIbflag().equals("I") ){
					insertVOList.add( searchOfficeInBKGControlVO );
					
				} else if( searchOfficeInBKGControlVO.getIbflag().equals("U") ){
					updateVOList.add( searchOfficeInBKGControlVO );
					
				} else if( searchOfficeInBKGControlVO.getIbflag().equals("D") ){
					deleteVOList.add( searchOfficeInBKGControlVO );
					
				}
			}
			
			if( insertVOList.size() > 0 ){
				dbDao.spaceAllocationBKGControlOptionOfficeListInsert( insertVOList );
			} 

			if( updateVOList.size() > 0 ){
				dbDao.spaceAllocationBKGControlOptionOfficeListUpdate( updateVOList );
				dbDao.modifyMultiSpaceAlloccationControlOptionsReduceCondition(updateVOList);
			} 
			
			if( deleteVOList.size() > 0 ){
				dbDao.spaceAllocationBKGControlOptionOfficeListDelete( deleteVOList );
			}
		
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Booking Control Option get List
	 * @param SearchOfficeBKGInControlVO searchOfficeBKGInControlVO
	 * @return List<SearchOfficeBKGInControlVO>
	 * @throws EventException
	 */
	public List<SearchOfficeBKGInControlVO> searchSpaceAllocationControloffice(SearchOfficeBKGInControlVO searchOfficeBKGInControlVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocationBKGOfficeInControl(searchOfficeBKGInControlVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * multiSpaceAllocationLaneControlOptionOfficeList 
	 * @param SearchOfficeInControlVO[] searchOfficeInControlVOs 
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpaceAllocationLaneControlOptionOfficeList( SearchOfficeInControlVO[] searchOfficeInControlVOs , SignOnUserAccount account ) throws EventException {
		try {
			List<SearchOfficeInControlVO> insertVOList = new ArrayList<SearchOfficeInControlVO>();
			List<SearchOfficeInControlVO> updateVOList = new ArrayList<SearchOfficeInControlVO>();
			List<SearchOfficeInControlVO> deleteVOList = new ArrayList<SearchOfficeInControlVO>();
			
			String trd_cd = "";
			String sub_trd_cd = "";
			String rlane_cd = "";
			String dir_cd = "";
			String aloc_ctrl_tp_cd = "";
			
			for( int x=0 ; x<searchOfficeInControlVOs.length ; x++ ) {
				
				SearchOfficeInControlVO searchOfficeInControlVO = searchOfficeInControlVOs[x];
				searchOfficeInControlVO.setCreUsrId( account.getUsr_id() );
				searchOfficeInControlVO.setUpdUsrId( account.getUsr_id() );
				
				if( x == 0 ) {
					trd_cd = searchOfficeInControlVO.getTrdCd();
					sub_trd_cd = searchOfficeInControlVO.getSubTrdCd();
					rlane_cd = searchOfficeInControlVO.getRlaneCd();
					dir_cd = searchOfficeInControlVO.getDirCd();
					aloc_ctrl_tp_cd = searchOfficeInControlVO.getAlocCtrlTpCd();
				} else {
					searchOfficeInControlVO.setTrdCd(trd_cd);
					searchOfficeInControlVO.setSubTrdCd(sub_trd_cd);
					searchOfficeInControlVO.setRlaneCd(rlane_cd);
					searchOfficeInControlVO.setDirCd(dir_cd);
					searchOfficeInControlVO.setAlocCtrlTpCd(aloc_ctrl_tp_cd);
				}
				
				if( searchOfficeInControlVO.getIbflag().equals("I") ){
					insertVOList.add( searchOfficeInControlVO );
					
				} else if( searchOfficeInControlVO.getIbflag().equals("U") ){
					updateVOList.add( searchOfficeInControlVO );
					
				} else if( searchOfficeInControlVO.getIbflag().equals("D") ){
					deleteVOList.add( searchOfficeInControlVO );
					
				}
			}				
		
			if( insertVOList.size() > 0 ){
				dbDao.spaceAllocationLaneControlOptionOfficeListInsert( insertVOList );
			}

			if( updateVOList.size() > 0 ){
				dbDao.spaceAllocationLaneControlOptionOfficeListUpdate( updateVOList );
			}
			
			if( deleteVOList.size() > 0 ){
				dbDao.spaceAllocationLaneControlOptionOfficeListDelete( deleteVOList );
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * searchCustomerControlCode
	 * @param CustomerControlGroupVO customerControlGroupVO
	 * @return List<SearchOfficeBKGInControlVO>
	 * @throws EventException
	 */
	public List<CustomerControlGroupVO> searchCustomerControlCode(CustomerControlGroupVO customerControlGroupVO) throws EventException {
		try {
			return dbDao.searchCustomerControlCode(customerControlGroupVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * ESM_SPC_0052: 두번째 Sheet내 Control(Fixed) 선택한 후 SC NO 입력시 
	 * 입력한 SC No가 PRI에서 Filed되고 Fixed 되었는지 유효성을 체크합니다.
	 * 
	 * @param String scNo
	 * @return String
	 * @throws EventException
	 */
	public String searchScNoValidForFixed(String scNo) throws EventException {
		try {
			return dbDao.searchScNoValidForFixed(scNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_0052]을 [행위] 합니다.
	 * 
	 * @param conditionVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationControlOption(ConditionVO conditionVO) throws EventException {
		try {
			List<SearchSpaceAllocationLaneControlOptionVO> list = dbDao.searchSpaceAllocationControlOption(conditionVO);
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocationLaneControlOptionVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocationLaneControlOptionVO> searchSpaceAllocationLaneControlOptionDetail02(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSpaceAllocationLaneControlOptionDetail02(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**
	 * VO copy
	 * @param SearchSpaceAllocationLaneControlOptionVO vo
	 * @param String ofcCd
	 * @return SearchOfficeInControlVO
	 */
	public SearchOfficeInControlVO copy2SearchOfficeInControlVO( SearchSpaceAllocationLaneControlOptionVO vo , String ofcCd ) {
		SearchOfficeInControlVO svo = new SearchOfficeInControlVO();
		svo.setTrdCd( vo.getTrdCd() );
		svo.setSubTrdCd( vo.getSubTrdCd() );
		svo.setRlaneCd( vo.getRlaneCd() );
		svo.setDirCd( vo.getDirCd() );
		svo.setOfcCd( ofcCd );
		svo.setCreUsrId( vo.getUpdUsrId() );
		svo.setUpdUsrId( vo.getUpdUsrId() );
		svo.setAlocCtrlTpCd( vo.getAlocCtrlTpCd() );
		svo.setCtrlLocAcctCd( vo.getCtrlLocAcctCd() );
		return svo;
	}
	/**
	 * [Container Type/Size]을 [조회] 합니다.<br>
	 * 
	 * @param GetCodeSelectVO conditionVO
	 * @return List<GetCodeSelectVO>
	 * @exception EventException
	 */
	public List<GetCodeSelectVO> searchSpaceContainerTypeSizeList(GetCodeSelectVO conditionVO) throws EventException {
		try {
			return dbDao.searchSpaceContainerTypeSizeList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	

	/**
	 * BATCH CREATE TABLE로부터 현재 BATCH의 STATUS를 알아본다.
	 * 
	 * @param SearchConditionVO searchVo
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
	public List<CommonCodeVO> searchStandbyBatchStatus(SearchConditionVO searchVo) throws EventException {
		try {
			return dbDao.searchStandbyBatchStatus(searchVo);
		} catch (DAOException de) {
			 throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * BATCH status 를 생성한다. <br>
	 *
	 * @param SpcSbBkgVO[] spcSbBkgVos
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addStandbyBatchStatus(SpcSbBkgVO[] spcSbBkgVos , SignOnUserAccount account ) throws EventException {
		try {
			List<SpcSbBkgVO> modifyVOList = new ArrayList<SpcSbBkgVO>();
			
			
			for( int i=0 ; i<spcSbBkgVos.length ; i++ ) {								
				spcSbBkgVos[i].setCreUsrId(account.getUsr_id());
				spcSbBkgVos[i].setUpdUsrId(account.getUsr_id());
				modifyVOList.add(spcSbBkgVos[i]);
			}
			
			if( modifyVOList.size() > 0 ){
				dbDao.addStandbyBatchStatus( modifyVOList );
			} 
		
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
 


    /**
     * Stowage List를 조회한다.
     * 
     * @param SpcAlocMgmtVO spcAlocMgmtVO
     * @return List<BookingStowageVO>
     * @exception EventException
     */
    public List<BookingStowageVO> searchBookingStowageList(SpcAlocMgmtVO spcAlocMgmtVO) throws EventException {
        try {
            return dbDao.searchBookingStowageList(spcAlocMgmtVO);
        } catch (DAOException de) {
             throw new EventException(de.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
	/*============================== ESM_SPC_0052, 0114 package 변경 종료==============================*/

	/**
	 *  Standby BKG Report 대상 Aloc,SMP 정보를 조회한다.
	 *
	 * @author KimSungWook
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchCompulsoryFirmVO>
	 * @exception EventException
	 */
//	public List<SearchCompulsoryFirmVO> searchStandbyBKGReportList( SearchConditionVO conditionVO ) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			return dbDao.searchStandbyBKGReportList(conditionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
//		}
//	}

	/**
	 *  Standby BKG Report 대상 Mastertable 정보를 조회한다.
	 *
	 * @author KimSungWook
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchStandbyBKGRPTMSTVO>
	 * @exception EventException
	 */
//	public List<SearchStandbyBKGRPTMSTVO> searchStandbyBKGReportMSTList( SearchConditionVO conditionVO ) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			return dbDao.searchStandbyBKGReportMSTList(conditionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
//		}
//	}
	

	/**
	 *  Standby BKG Report 대상 Mastertable, SMP, ALOC 정보를 조회한다.
	 *
	 * @author KimSungWook
	 * @param SearchConditionVO conditionVO
	 * @return List<SearchStandbyBKGRPTMSTVO>
	 * @exception EventException
	 */
//	public List<SearchStandbyBKGRPTMSTVO> searchStandbyBKGReportAllList( SearchConditionVO conditionVO ) throws EventException {
//		// TODO Auto-generated method stub
//		try {
//			return dbDao.searchStandbyBKGReportAllList(conditionVO);
//			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
//		}
//	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalBCImpl.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
* =========================================================
* history
* 2013.06.03 김현화 [CHM-201324585]DG Packing Instruction 기능 적용.checkPreRestriction 를 partmerLine으로 옮김. 
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration.OwnDangerousCargoApprovalDBDAO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSegregationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgNonDcgoRequestVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.UndeclaredHistoryVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgAuthorizationVO;
import com.hanjin.syscommon.common.table.ScgDgCgoVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;


/**
 * ALPS-CargoLoadingApproval Business Logic Basic Command implementation<br>
 * - ALPS-CargoLoadingApproval에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0014EventResponse,OwnDangerousCargoApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OwnDangerousCargoApprovalBCImpl extends BasicCommandSupport implements OwnDangerousCargoApprovalBC {

	// Database Access Object
	private transient OwnDangerousCargoApprovalDBDAO dbDao = null;

	/**
	 * OwnDangerousCargoApprovalBCImpl 객체 생성<br>
	 * OwnDangerousCargoApprovalDBDAO를 생성한다.<br>
	 */
	public OwnDangerousCargoApprovalBCImpl() {
		dbDao = new OwnDangerousCargoApprovalDBDAO();
	}
	
	/**
	 * Booking에서의 SCG에대한 Request의 요청내용을 저장 합니다. <br>
	 * 
	 * @param scgAproRqstVOs
	 * @param scgVvdAproRqstVOs
	 * @param account
	 * @exception EventException
	 */
	public void requestSpecialCargoApproval(ScgAproRqstVO[] scgAproRqstVOs, ScgVvdAproRqstVO[] scgVvdAproRqstVOs, SignOnUserAccount account) throws EventException {
		try {
			//BKG에서 무조건 Insert를 함으로 [U,D]는 삭제함
			List<ScgAproRqstVO> insertVoList = new ArrayList<ScgAproRqstVO>();
			List<ScgVvdAproRqstVO> insertVvdVoList = new ArrayList<ScgVvdAproRqstVO>();
			
			
			for ( int i=0; scgAproRqstVOs != null && !"".equals(scgAproRqstVOs) && i<scgAproRqstVOs.length; i++ ) {
				scgAproRqstVOs[i].setCreUsrId(account.getUsr_id());
				insertVoList.add(scgAproRqstVOs[i]);
			}
			if ( insertVoList.size() > 0 ) {
				//SCG_APRO_RQST INSERT하기전 이전 REQUEST의 LST_RQST_DAT_FLG값을 N으로 변경한다.
				dbDao.modifySCGRequestLstFlg(insertVoList);
				dbDao.addSCGRequest(insertVoList);
			}

			for ( int i=0; scgVvdAproRqstVOs != null && !"".equals(scgVvdAproRqstVOs) && i<scgVvdAproRqstVOs.length; i++ ) {
				scgVvdAproRqstVOs[i].setCreUsrId(account.getUsr_id());
				insertVvdVoList.add(scgVvdAproRqstVOs[i]);
			}			
			if ( insertVvdVoList.size() > 0 ) {
				dbDao.addSCGVvdRequest(insertVvdVoList);
			}
			
			//BKG에서 무조건 Insert를 함으로 [U,D]는 주석처리 향후 업무요건 변경시 주석 제거
//			List<ScgAproRqstVO> insertVoList = new ArrayList<ScgAproRqstVO>();
//			List<ScgAproRqstVO> updateVoList = new ArrayList<ScgAproRqstVO>();
//			List<ScgAproRqstVO> deleteVoList = new ArrayList<ScgAproRqstVO>();
//
//			List<ScgVvdAproRqstVO> insertVvdVoList = new ArrayList<ScgVvdAproRqstVO>();
//			List<ScgVvdAproRqstVO> updateVvdVoList = new ArrayList<ScgVvdAproRqstVO>();
//			List<ScgVvdAproRqstVO> deleteVvdVoList = new ArrayList<ScgVvdAproRqstVO>();
//			
//			for ( int i=0; i<scgAproRqstVOs.length; i++ ) {
//				if ( scgAproRqstVOs[i].getIbflag().equals("I")){
//					scgAproRqstVOs[i].setCreUsrId(account.getUsr_id());
//					insertVoList.add(scgAproRqstVOs[i]);
//				} else if ( scgAproRqstVOs[i].getIbflag().equals("U")){
//					scgAproRqstVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(scgAproRqstVOs[i]);
//				} else if ( scgAproRqstVOs[i].getIbflag().equals("D")){
//					scgAproRqstVOs[i].setUpdUsrId(account.getUsr_id());
//					deleteVoList.add(scgAproRqstVOs[i]);
//				}
//			}
//			
//			if ( insertVoList.size() > 0 ) {
//				//SCG_APRO_RQST INSERT하기전 이전 REQUEST의 LST_RQST_DAT_FLG값을 N으로 변경한다.
//				dbDao.modifySCGRequestLstFlg(insertVoList);
//				dbDao.addSCGRequest(insertVoList);
//			}
//			
//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifySCGRequest(updateVoList);
//			}
//			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeSCGRequest(deleteVoList);
//			}
//
//			for ( int i=0; i<scgVvdAproRqstVOs.length; i++ ) {
//				if ( scgVvdAproRqstVOs[i].getIbflag().equals("I")){
//					scgVvdAproRqstVOs[i].setCreUsrId(account.getUsr_id());
//					insertVvdVoList.add(scgVvdAproRqstVOs[i]);
//				} else if ( scgVvdAproRqstVOs[i].getIbflag().equals("U")){
//					scgVvdAproRqstVOs[i].setUpdUsrId(account.getUsr_id());
//					updateVvdVoList.add(scgVvdAproRqstVOs[i]);
//				} else if ( scgVvdAproRqstVOs[i].getIbflag().equals("D")){
//					scgVvdAproRqstVOs[i].setUpdUsrId(account.getUsr_id());
//					deleteVvdVoList.add(scgVvdAproRqstVOs[i]);
//				}
//			}
//			
//			if ( insertVvdVoList.size() > 0 ) {
//				dbDao.addSCGVvdRequest(insertVvdVoList);
//			}
//			
//			if ( updateVvdVoList.size() > 0 ) {
//				//Request후 VVD가 변경될수 있으므로 SCG_VVD_APRO_RQST를 DELETE후 다시 INSERT한다.
//				dbDao.removeSCGVvdRequest(deleteVvdVoList);
//				dbDao.addSCGVvdRequest(insertVvdVoList);
//			}
//			
//			if ( deleteVvdVoList.size() > 0 ) {
//				dbDao.removeSCGVvdRequest(deleteVvdVoList);
//			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
		}
	}
	
	/**
	 * Booking에서의 SCG CARGO에 대한 CANCEL 및 DELETE의 요청내용을 저장 합니다. <br>
	 * 
	 * @param scgFlg		'DG','AK','BB','RF'
	 * @param bkgNo			booking_no
	 * @param cgoSeqs		cargo_seq
	 * @param spclCgoAproCds	SPCL_CGO_APRO_CD
	 * @param account
	 * @exception EventException
	 */
	public void cancelSpecialCargoRequest(String scgFlg, String bkgNo, String[] cgoSeqs, String[] spclCgoAproCds, SignOnUserAccount account) throws EventException {
		try {
			String strSpclCgoAproRqstSeq = "";
			String dumyCgoSeq = "";
			for ( int i=0; i<cgoSeqs.length; i++ ) {
				//BKG쪽에서 어떤 상태에서 CANCEL요청이 오는지 확인 임시로그
				//log.error("scgFlg:"+scgFlg+" bkgNo:"+bkgNo+" cgoSeqs:"+cgoSeqs[i]+" spclCgoAproCds:"+spclCgoAproCds[i]+" usr_id:"+account.getUsr_id());
				
				if (spclCgoAproCds[i].equals("C")) {
					spclCgoAproCds[i] = "C";
				}else{
					spclCgoAproCds[i] = "D";
				}
				//SCG에 Request된 Booking에 대해 SCG Cargo Table에 Cancel처리 History를 쌓는다.(Split, Combine된 Booking 제외)
				if (dbDao.searchAproRqst(bkgNo, scgFlg).size() > 0) {
					if (scgFlg.equals("DG")){
						if (dbDao.searchScgDgCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgDgCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgDgCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgDgCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
					}
					if (scgFlg.equals("AK")){
						if (dbDao.searchScgAwkCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgAwkCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgAwkDimDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgAwkCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
							dbDao.addScgAwkDimDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgAwkCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
					}
					if (scgFlg.equals("BB")){
						if (dbDao.searchScgBbCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgBbCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgBbCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgBbCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
					}
					if (scgFlg.equals("RF")){
						if (dbDao.searchScgRfCgoDetail(bkgNo, strSpclCgoAproRqstSeq).size() < 1) {
							dbDao.addScgRfCgoDetail(bkgNo, strSpclCgoAproRqstSeq, dumyCgoSeq);
							dbDao.addScgRfCgoDetail(bkgNo, strSpclCgoAproRqstSeq, cgoSeqs[i]);
						}else{
							dbDao.modifyScgRfCgoDetail(bkgNo, cgoSeqs[i], spclCgoAproCds[i]);
						}
					}
				}
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Special Request"}).getMessage(), ex);
		}
	}	
	/**
	 * SPCL CGO APVL for Own BKG의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchScgRequestList(scgRequestListOptionVO, account);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}

	/**
	 * SPCL CGO APVL for Own BKG의 승인내용을 저장 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @param arrCrrCd
	 * @param arrPolCd
	 * @param strScgFlg
	 * @param account
	 * @return List<SearchScgAprovalAuthCdVO>
	 * @exception EventException
	 */
	public List<SearchScgAprovalAuthCdVO> manageSCGApproval(ScgAuthorizationVO[] scgAuthorizationVO, String[] arrCrrCd, String[] arrPolCd, String strScgFlg, SignOnUserAccount account) throws EventException{
		try {

			String dumyCgoSeq = "";
			List<SearchScgAprovalAuthCdVO> list = new ArrayList<SearchScgAprovalAuthCdVO>();
			
			for ( int i=0; i<scgAuthorizationVO.length; i++ ) {
				if (scgAuthorizationVO[i].getSpclCgoAuthCd().equals("N") || scgAuthorizationVO[i].getSpclCgoAuthCd().equals("P") || scgAuthorizationVO[i].getSpclCgoAuthCd().equals("Y")) {
					String strCrrCd = arrCrrCd[i];
					String strPolCd = arrPolCd[i].substring(arrPolCd[i].length()-3, arrPolCd[i].length());
					if (scgAuthorizationVO[i].getSpclCgoAuthSeq().equals("")) {
						scgAuthorizationVO[i].setRgnShpOprCd(scgAuthorizationVO[0].getRgnShpOprCd());
						scgAuthorizationVO[i].setAuthOfcCd(account.getOfc_cd());
						scgAuthorizationVO[i].setAuthUsrId(account.getUsr_id());
						scgAuthorizationVO[i].setCreUsrId(account.getUsr_id());
	
						if (!scgAuthorizationVO[i].getSpclCgoAuthCd().equals("P")) {
							if (!scgAuthorizationVO[i].getDcgoSeq().equals("")) {
								if (dbDao.searchScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							if (!scgAuthorizationVO[i].getAwkCgoSeq().equals("")) {
								if (dbDao.searchScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
									dbDao.addScgAwkDimDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							if (!scgAuthorizationVO[i].getBbCgoSeq().equals("")) {
								if (dbDao.searchScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
							if (!scgAuthorizationVO[i].getRcSeq().equals("")) {
								if (dbDao.searchScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
									dbDao.addScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								}
							}
						}
						/**
						 * SCG_AUTHORIZATION을 생성시 SPCL_CGO_AUTH_SEQ을 MAX+1로 생성 해야 함으로	
						 * executeBatch가 아닌 executeUpdate으로 생성 해야 함으로 FOR문 안에서 addSCGApprovalS을 CALL한다.
						 * insertVoList.add(scgAuthorizationVO[i]) 사용안함
						 */
						dbDao.addSCGApprovalS(scgAuthorizationVO[i]);
						
					}else{
						scgAuthorizationVO[i].setAuthOfcCd(account.getOfc_cd());
						scgAuthorizationVO[i].setAuthUsrId(account.getUsr_id());
						scgAuthorizationVO[i].setUpdUsrId(account.getUsr_id());
	
						if (!scgAuthorizationVO[i].getDcgoSeq().equals("")) {
							if (dbDao.searchScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
								dbDao.addScgDgCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
							}
						}
						if (!scgAuthorizationVO[i].getAwkCgoSeq().equals("")) {
							if (dbDao.searchScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
								dbDao.addScgAwkCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
								dbDao.addScgAwkDimDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
							}
						}
						if (!scgAuthorizationVO[i].getBbCgoSeq().equals("")) {
							if (dbDao.searchScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
								dbDao.addScgBbCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
							}
						}
						if (!scgAuthorizationVO[i].getRcSeq().equals("")) {
							if (dbDao.searchScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq()).size() < 1) {
								dbDao.addScgRfCgoDetail(scgAuthorizationVO[i].getBkgNo(), scgAuthorizationVO[i].getSpclCgoAproRqstSeq(), dumyCgoSeq);
							}
						}
	
						dbDao.modifySCGApprovalS(scgAuthorizationVO[i]);
	
					}
	
					if (scgAuthorizationVO[i].getSpclCgoAuthCd().equals("Y") && "SML".equals(strCrrCd) && ("DG1".equals(strScgFlg) || "DG2".equals(strScgFlg) || "AWK".equals(strScgFlg) || "BB".equals(strScgFlg)) ) {
						if (dbDao.searchScgAuthorization(scgAuthorizationVO[i]).size() < 1) {
							dbDao.modifySCGAproRefNoS(scgAuthorizationVO[i], strPolCd, strScgFlg);
						}
					}

					List<SearchScgAprovalAuthCdVO> authCd  = dbDao.searchScgApprovalAuthCd(scgAuthorizationVO[i], strScgFlg);
					list.addAll(authCd);
					
log.error("\n[001] BKG No.:["+scgAuthorizationVO[i].getBkgNo()+
		"] spcl_cgo_apro_rqst_seq["+scgAuthorizationVO[i].getSpclCgoAproRqstSeq()
		+"] dcgo_seq["+scgAuthorizationVO[i].getDcgoSeq()
		+"] awk_cgo_seq["+scgAuthorizationVO[i].getAwkCgoSeq()
		+"] bb_cgo_seq["+scgAuthorizationVO[i].getBbCgoSeq()
		+"] rc_seq["+scgAuthorizationVO[i].getRcSeq()
		+"] scg_flg["+strScgFlg+"]"
		+"] list.size() ["+list.size()+"]"
		);
				}
			}
			
			return list;
			
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO APVL for Own BKG의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGApprovalMail(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException{
		try {

			scgRequestListOptionVO.setUpdUsrId(account.getUsr_id());
			if (scgRequestListOptionVO.getScgFlg().equals("RF")) {
				List<ScgRequestListOptionVO> updMailKeys  = dbDao.searchScgApprovalRFMailKey(scgRequestListOptionVO);
				for ( int i=0; i < updMailKeys.size(); i++ ) {
					scgRequestListOptionVO.setBkgNo(updMailKeys.get(i).getBkgNo());
					scgRequestListOptionVO.setSpclCgoAproRqstSeq((updMailKeys.get(i).getSpclCgoAproRqstSeq()));
					dbDao.modifySCGApprovalMail(scgRequestListOptionVO);					
				}
			}else{
				dbDao.modifySCGApprovalMail(scgRequestListOptionVO);				
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO Approved Details의 수정내용을 저장 합니다. <br>
	 * 
	 * @param scgAuthorizationVOs 
	 * @param account
	 * @exception EventException
	 */
	public void manageSCGApproved(ScgAuthorizationVO[] scgAuthorizationVOs, SignOnUserAccount account) throws EventException{
		try {
			
			String spclCgoAuthSeq = "";
			for ( int i=0; i<scgAuthorizationVOs.length; i++ ) {
				spclCgoAuthSeq = scgAuthorizationVOs[i].getSpclCgoAuthSeq()==null?"":scgAuthorizationVOs[i].getSpclCgoAuthSeq();
				if(!"".equals(spclCgoAuthSeq)) {
					scgAuthorizationVOs[i].setAuthOfcCd(account.getOfc_cd());
					scgAuthorizationVOs[i].setAuthUsrId(account.getUsr_id());
					scgAuthorizationVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifySCGApprovalS(scgAuthorizationVOs[i]);
				}
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO Approved Details"}).getMessage(), ex);
		}
	}
	
	/**
	 * Application Request & Approval Status의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgApprovalStatusList(ScgRequestListOptionVO scgRequestListOptionVO) throws EventException {
		try {
			return dbDao.searchScgApprovalStatusList(scgRequestListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
		}
	}

	/**
	 * Application Request & Approval Status 를 apro_ref_no를 수정 합니다. <br>
	 * 
	 * @param scgRequestListOptionVOs
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGAproRefNoByHis(ScgRequestListOptionVO[] scgRequestListOptionVOs, SignOnUserAccount account) throws EventException{

		try {			
			List<ScgRequestListOptionVO> updateVoList = new ArrayList<ScgRequestListOptionVO>();

			for ( int i=0; i<scgRequestListOptionVOs.length; i++ ) {
				scgRequestListOptionVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(scgRequestListOptionVOs[i]);
			}
			
			dbDao.modifySCGAproRefNoByHis(updateVoList);
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Application Request & Approval Status"}).getMessage(), ex);
        }
	}
	
	
	/**
	 * Dangerous CGO Application Details for Own BKG 의 Detail를 조회 합니다. <br>
	 * 
	 * @param scgDgCgoVO 
	 * @return List<SearchScgDgRequestDetailVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestDetailVO> searchScgRequestDetail(ScgDgCgoVO scgDgCgoVO) throws EventException {
		try {
			return dbDao.searchScgRequestDetail(scgDgCgoVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Own BKG"}).getMessage(), ex);
		}
	}

//	/**
//	 * Pre Checking Report 를 조회 합니다. 미사용. partmerLine으로 옮김.<br>
//	 * 
//	 * @param preRestrictionInputVO
//	 * @return PreRestrictionOutputVO
//	 * @exception EventException
//	 */
//	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO) throws EventException {
//		try {
//			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
//			
//			if(preRestrictionInputVO != null && preRestrictionInputVO.getInnerPreRestrictionInputVOS() != null && preRestrictionInputVO.getInnerPreRestrictionInputVOS().length > 0) {
//				String f_cmd = preRestrictionInputVO.getInnerPreRestrictionInputVO().getFCmd();			
//				if(Integer.toString(FormCommand.SEARCH01).equals(f_cmd)) {
//					//Container 별  체크를 위한 Sortting
//					PreRestrictionInputVO[] sortVO = preRestrictionInputVO.getInnerPreRestrictionInputVOS();
//					PreRestrictionInputVO   tmpVO = null;
//					String spclCntrSeq1 = "", spclCgoSeq1 = "";
//					String spclCntrSeq2 = "", spclCgoSeq2 = "";
//					for(int sortCt1=0; sortCt1 < sortVO.length; sortCt1++) {
//						spclCntrSeq1 = sortVO[sortCt1].getSpclCntrSeq();
//						spclCgoSeq1  = sortVO[sortCt1].getSpclCgoSeq();
//						for(int sortCt2=sortCt1+1; sortCt2 < sortVO.length; sortCt2++) {
//							spclCntrSeq2 = sortVO[sortCt2].getSpclCntrSeq();
//							spclCgoSeq2  = sortVO[sortCt2].getSpclCgoSeq();
//							if(Integer.parseInt(spclCntrSeq1) > Integer.parseInt(spclCntrSeq2) || (Integer.parseInt(spclCntrSeq1) == Integer.parseInt(spclCntrSeq2) && Integer.parseInt(spclCgoSeq1) > Integer.parseInt(spclCgoSeq2))) {
//								tmpVO = sortVO[sortCt1]; 
//								sortVO[sortCt1] = sortVO[sortCt2];
//								sortVO[sortCt2] = tmpVO;
//							}
//						}
//					}
//					preRestrictionInputVO.setInnerPreRestrictionInputVOS(sortVO);
//					
//					//Container 별 체크
//					List<PreRestrictionSegregationVO> rsltVO = null;
//					List<PreRestrictionSegregationVO> rtnVO  = new ArrayList<PreRestrictionSegregationVO>();
//					spclCntrSeq1 = "";
//					spclCntrSeq2 = "";
//					int startNum = 0, endNum = 0;
//					for(int addCt=0; addCt<sortVO.length; addCt++) {
//						spclCntrSeq1 = sortVO[addCt].getSpclCntrSeq();
//						if((!"".equals(spclCntrSeq2) && !spclCntrSeq1.equals(spclCntrSeq2)) || addCt == sortVO.length-1) {	
//							endNum = addCt;
//							
//							//최종 컨테이너에 대한 수행을 위해 종료시점을 조정
//							if(("".equals(spclCntrSeq2) || spclCntrSeq1.equals(spclCntrSeq2)) && addCt == sortVO.length-1) {
//								endNum++;
//							}
//							preRestrictionInputVO.getInnerPreRestrictionInputVO().setStartNum(Integer.toString(startNum));
//							preRestrictionInputVO.getInnerPreRestrictionInputVO().setEndNum(Integer.toString(endNum));
//							rsltVO = dbDao.checkPreRestrictionSegregation(preRestrictionInputVO);
//							
//							String[] rmList = new String[rsltVO.size()];					
//							for(int rsltCt=0; rsltCt<rsltVO.size(); rsltCt++) {
//								for(int rmCt=rsltCt+1; rmCt<rsltVO.size(); rmCt++) {
//									if(rsltVO.get(rsltCt).getSpclCntrSeq1().equals(rsltVO.get(rmCt).getSpclCntrSeq2())
//									   && rsltVO.get(rsltCt).getSpclCgoSeq1().equals(rsltVO.get(rmCt).getSpclCgoSeq2())
//									   && rsltVO.get(rsltCt).getImdgUnNo1().equals(rsltVO.get(rmCt).getImdgUnNo2())
//									   && rsltVO.get(rsltCt).getImdgUnNoSeq1().equals(rsltVO.get(rmCt).getImdgUnNoSeq2())
//									   && rsltVO.get(rsltCt).getSpclCntrSeq2().equals(rsltVO.get(rmCt).getSpclCntrSeq1())
//									   && rsltVO.get(rsltCt).getSpclCgoSeq2().equals(rsltVO.get(rmCt).getSpclCgoSeq1())
//									   && rsltVO.get(rsltCt).getImdgUnNo2().equals(rsltVO.get(rmCt).getImdgUnNo1())
//									   && rsltVO.get(rsltCt).getImdgUnNoSeq2().equals(rsltVO.get(rmCt).getImdgUnNoSeq1())
//									) 
//									{
//										rmList[rmCt] = "Y";
//									}
//								}
//							}	
//							
//							/*
//							 * 같은 쌍의 경우에도 모두 보여주기로 하여 주석처리함.
//							 * for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
//								if("Y".equals(rmList[delCt])) rsltVO.remove(delCt);	
//			        		}*/
//							
//							for(int rsltCt=0; rsltCt<rsltVO.size(); rsltCt++) {
//								rtnVO.add(rsltVO.get(rsltCt));
//							}
//							
//							startNum = addCt;
//						}
//						spclCntrSeq2 = spclCntrSeq1;
//					}
//					preRestrictionOutputVO.setPreRestrictionSegregationVOs(rtnVO);
//				} else if(Integer.toString(FormCommand.SEARCH02).equals(f_cmd)) {
//					
//					/*
//					 * 1. UN No.로 체크했을 경우 C(Excepted fm Class Prohibition, Target Lane에 포함되지 않은 VVD일 경우-타사제외)일 경우만 제외하고 Class로 재체크를 한다.
//					 * 2. 두개의 체크 모두 Prohibition이 L,P,T인 경우만 목록으로 리턴한다.
//					 */
//					//1. 1차 Un No. 기준 Restriction
//					preRestrictionInputVO.getInnerPreRestrictionInputVO().setOptClss("U");
//					List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs = dbDao.checkPreRestrictionVesselOperator(preRestrictionInputVO);
//					
//					//2. 2차 Class 기준 Restriction
//					Iterator<PreRestrictionVesselOperatorVO> rsltlist = preRestrictionVesselOperatorVOs.iterator();	
//					ArrayList<Integer> expList 		= new ArrayList<Integer>();
//					ArrayList<Integer> expLaneList 	= new ArrayList<Integer>();
//					int expCt = 0;
//					String restrictYn = "";
//		        	while(rsltlist.hasNext()){
//		        		PreRestrictionVesselOperatorVO vo = (PreRestrictionVesselOperatorVO)rsltlist.next();
//		        		restrictYn = vo.getProhibitionCd();
//		        		if(restrictYn == null || "".equals(restrictYn) || "C".equals(restrictYn) ) { 
//	        				expList.add(new Integer(expCt));
//		        		}else if ("L".equals(restrictYn)){
//	        				expLaneList.add(new Integer(expCt));	        			
//		        		}
//		        		expCt++;
//		        	}	
//		        	
//		        	int expCount = expList.size();
//		        	if(expCount > 0) {
//			        	PreRestrictionInputVO[] tndInputVOs = null;
//						PreRestrictionInputVO   tndInputVO  = null;
//						PreRestrictionVesselOperatorVO tVO  = null;
//						
//						tndInputVOs = new PreRestrictionInputVO[expCount];
//						expCt = 0;
//			        	for(int delCt=0; delCt < expList.size(); delCt++) {
//			        		tndInputVO = new PreRestrictionInputVO();
//			        		
//			        		tVO = preRestrictionVesselOperatorVOs.get(expList.get(delCt).intValue());
//			        		
//			        		restrictYn = tVO.getProhibitionCd();
//			        		
//			        		if(!"C".equals(restrictYn)) {
//				        		tndInputVO.setSpclCntrSeq(tVO.getSpclCntrSeq());
//				        		tndInputVO.setSpclCgoSeq(tVO.getSpclCgoSeq());
//				        		tndInputVO.setImdgUnNo(tVO.getImdgUnNo());
//				        		tndInputVO.setImdgUnNoSeq(tVO.getImdgUnNoSeq());
//				        		tndInputVO.setImdgClssCd(tVO.getImdgClssCd());
//				        		tndInputVO.setVslCd(tVO.getVslCd());
//				        		tndInputVO.setSkdVoyNo(tVO.getSkdVoyNo());
//				        		tndInputVO.setSkdDirCd(tVO.getSkdDirCd());
//				        		tndInputVO.setCrrCd(tVO.getCrrCd());
//				        		tndInputVO.setSlanCd(tVO.getSlanCd());
//				        		
//				        		tndInputVOs[expCt++] = tndInputVO;
//			        		}
//		        		}
//			        	
//			        	for(int delCt=expCount-1; delCt >= 0; delCt--) {
//			        		if (!"P".equals(restrictYn) && !"R".equals(restrictYn)) {
//			        			preRestrictionVesselOperatorVOs.remove(expList.get(delCt).intValue());
//			        		}
//		        		}
//			        	
//			        	preRestrictionInputVO.setInnerPreRestrictionInputVOS(tndInputVOs);
//			        	preRestrictionInputVO.getInnerPreRestrictionInputVO().setOptClss("C");
//			        	List<PreRestrictionVesselOperatorVO> tndVOs = dbDao.checkPreRestrictionVesselOperator(preRestrictionInputVO);
//			        	
//			        	Iterator<PreRestrictionVesselOperatorVO> tndRsltlist = tndVOs.iterator();	
//			        	while(tndRsltlist.hasNext()){
//			        		PreRestrictionVesselOperatorVO vo = (PreRestrictionVesselOperatorVO)tndRsltlist.next();
//				        	//VVD가 2개 이상일때 UN으로 Check된 내용이 우선이므로 Class로 Check된 내용을 삭제한다. 
//			        		for(int delCt=0; delCt < expCt; delCt++) {
//				        		if (tndInputVOs[delCt].getSpclCntrSeq().equals(vo.getSpclCntrSeq()) 
//				        			&& tndInputVOs[delCt].getSpclCgoSeq().equals(vo.getSpclCgoSeq()) 
//				        			&& tndInputVOs[delCt].getImdgUnNo().equals(vo.getImdgUnNo()) 
//				        			&& tndInputVOs[delCt].getImdgUnNoSeq().equals(vo.getImdgUnNoSeq()) 
//				        			&& tndInputVOs[delCt].getVslCd().equals(vo.getVslCd()) 
//				        			&& tndInputVOs[delCt].getSkdVoyNo().equals(vo.getSkdVoyNo()) 
//				        			&& tndInputVOs[delCt].getSkdDirCd().equals(vo.getSkdDirCd()) 
//				        			&& tndInputVOs[delCt].getCrrCd().equals(vo.getCrrCd()) ) {
//			        				preRestrictionVesselOperatorVOs.add(vo);
//				        		}
//				        	}
//			        	}
//		        	}
//		        	
//					preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(preRestrictionVesselOperatorVOs);
//				} else if(Integer.toString(FormCommand.SEARCH03).equals(f_cmd)) {
//					preRestrictionOutputVO.setPreRestrictionPortVOs(dbDao.checkPreRestrictionPort(preRestrictionInputVO));
//				}
//			}
//			
//			return preRestrictionOutputVO;
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
//		}
//	}
//	
//	/**
//	 * Pre Checking Report(VVD별 채크기능 추가) 를 조회 합니다. 미사용. partmerLine으로 옮김. <br>
//	 * 
//	 * @param preRestrictionInputVO
//	 * @param segChk
//	 * @param vslChk
//	 * @param prtChk
//	 * @return PreRestrictionOutputVO
//	 * @exception EventException
//	 */
//	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO, boolean segChk, boolean vslChk, boolean prtChk) throws EventException {
//		/********************************************************************************************************************************************
//		 * cf.) 
//		 * PreRestrictionInputVO containerVO = new PreRestrictionInputVO();
//		 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
//		 * preRestrictionInputVO.setBkgNo("ATLX1210006");
//		 * preRestrictionInputVO.setVslCd("HNBR");
//		 * preRestrictionInputVO.setSkdVoyNo("0039");
//		 * preRestrictionInputVO.setSkdDirCd("E");
//		 * containerVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
//		 * PreRestrictionOutputVO chkRslt = checkPreRestriction(containerVO, false, true, true);
//		 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
//		 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
//		 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
//		 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
//		 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
//		 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
//		 ********************************************************************************************************************************************/
//		try {
//			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
//			
//			//Step1 : select list of dangerous cargo in booking
//			List<PreRestrictionInputVO> dgCgoList = dbDao.searchBkgDgCargoList(preRestrictionInputVO);
//			
//			if(dgCgoList != null && dgCgoList.size() > 0) {
//				PreRestrictionInputVO[] dgCgos = (PreRestrictionInputVO[])(dgCgoList.toArray(new PreRestrictionInputVO[dgCgoList.size()]));
//				preRestrictionInputVO.setInnerPreRestrictionInputVOS(dgCgos);
//				
//				String vslCd    = "";
//				String skdVoyNo = "";
//				String skdDirCd = "";
//				
//				//Step2 : check segregation
//				if(segChk) {
//					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH01));
//					List<PreRestrictionSegregationVO> segChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionSegregationVOs();
//					
//					if(segChkRslt != null && segChkRslt.size() > 0) {
//						preRestrictionOutputVO.setSegChkRslt(true);
//						preRestrictionOutputVO.setPreRestrictionSegregationVOs(segChkRslt);
//					}
//				}
//				//Step3 : check vessel
//				if(vslChk) {
//					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH02));
//					List<PreRestrictionVesselOperatorVO> vslChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionVesselOperatorVOs();
//					
//					if(vslChkRslt != null && vslChkRslt.size() > 0) {	
//						vslCd    = preRestrictionInputVO.getVslCd();
//						if(vslCd != null && !"".equals(vslCd)) {							
//							skdVoyNo = preRestrictionInputVO.getSkdVoyNo();
//							skdDirCd = preRestrictionInputVO.getSkdDirCd();
//							
//							List<PreRestrictionVesselOperatorVO> vslChkVos = new ArrayList<PreRestrictionVesselOperatorVO>();
//							
//							for(int rsltCt=0; rsltCt<vslChkRslt.size(); rsltCt++) {
//								if(vslChkRslt.get(rsltCt).getVslCd().equals(vslCd) && vslChkRslt.get(rsltCt).getSkdVoyNo().equals(skdVoyNo) && vslChkRslt.get(rsltCt).getSkdDirCd().equals(skdDirCd)) {
//									preRestrictionOutputVO.setVslChkRslt(true);
//									vslChkVos.add(vslChkRslt.get(rsltCt));
//								}
//							}
//							preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(vslChkVos);
//						} else {
//							preRestrictionOutputVO.setVslChkRslt(true);
//							preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(vslChkRslt);
//						}
//					}
//				}
//				//Step4 : check port
//				if(prtChk) {
//					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH03));
//					
//					preRestrictionInputVO.setInnerPreRestrictionInputVOS(dgCgos);
//					List<PreRestrictionPortVO> prtChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionPortVOs();
//					
//					List<PreRestrictionPortVO> prtChkVos = new ArrayList<PreRestrictionPortVO>();
//					
//					for(int rsltCt=0; prtChkRslt!=null && rsltCt<prtChkRslt.size(); rsltCt++) {
//						if(!"".equals(prtChkRslt.get(rsltCt).getImdgCmptnAuthDesc().trim())) {
//							vslCd    = preRestrictionInputVO.getVslCd();
//							skdVoyNo = preRestrictionInputVO.getSkdVoyNo();
//							skdDirCd = preRestrictionInputVO.getSkdDirCd();
//							
//							if(vslCd != null && !"".equals(vslCd)) {							
//								if(prtChkRslt.get(rsltCt).getVvdCd().equals(vslCd+skdVoyNo+skdDirCd)) {
//									preRestrictionOutputVO.setPrtChkRslt(true);
//									prtChkVos.add(prtChkRslt.get(rsltCt));
//								}
//							} else {
//								preRestrictionOutputVO.setPrtChkRslt(true);
//								prtChkVos.add(prtChkRslt.get(rsltCt));
//							}
//						}
//					}
//					if(preRestrictionOutputVO.getPrtChkRslt()) preRestrictionOutputVO.setPreRestrictionPortVOs(prtChkVos);
//				}
//			}
//
//			return preRestrictionOutputVO;
//        } catch (DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report by VVD"}).getMessage(), ex);
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report by VVD"}).getMessage(), ex);
//		}
//	}
	
	/**
	 * Mail Preview 를 조회 합니다. <br>
	 * 
	 * @param ownApprovalRequestVO
	 * @return List<OwnApprovalRequestVO>
	 * @exception EventException
	 */
	public List<OwnApprovalRequestVO> searchSCGMailingList(OwnApprovalRequestVO ownApprovalRequestVO) throws EventException {
		try {
			return dbDao.searchSCGMailingList(ownApprovalRequestVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}
	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Restrictions 을 조회 합니다. <br>
	 * 
	 * @param restrictionInputVO
	 * @return List<RestrictionOutputVO>
	 * @exception EventException
	 */
	public List<RestrictionOutputVO> searchRestrictions(RestrictionInputVO restrictionInputVO) throws EventException {
		try {
			return dbDao.searchRestrictions(restrictionInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
		}
	}
	
	/**
	 * Time of SPCL CGO Request APVL 의 KPI 를 조회 합니다. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeOutputVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestApvlTimeOutputVO> searchScgRequestApvlTimeList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws EventException {
		try {
			return dbDao.searchScgRequestApvlTimeList(searchScgRequestApvlTimeInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL"}).getMessage(), ex);
		}
	}
	
	/**
	 * Time of SPCL CGO Request APVL 의 KPI 상세정보 를 조회 합니다. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeDetailVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestApvlTimeDetailVO> searchScgRequestApvlTimeDetailList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws EventException {
		try {
			return dbDao.searchScgRequestApvlTimeDetailList(searchScgRequestApvlTimeInputVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL Detail"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Time of SPCL CGO Request APVL Detail"}).getMessage(), ex);
		}
	}
	
	/**
	 * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) (ESM_BKG_0200 ComboList) 조회.<br>
	 * 
	 * @return List<SegrGrpVO>
	 * @throws EventException
	 */
	public List<SegrGrpVO> searchSegrGrp() throws EventException {
		try{
			return dbDao.searchSegrGrp();
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
        }
	}

	/**
     * Target LaneCode for SPCL CGO APVL 체크한다. <br>
	 * 
	 * @param  String vslSlanCd
	 * @return List<MdmVslSvcLaneVO> 
	 * @exception EventException
	 */
	@Override
	public List<MdmVslSvcLaneVO> checkLaneCd(String vslSlanCd) throws EventException {
		try {
			return dbDao.checkLaneCd(vslSlanCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
	}
	
	/**
     * Systematic Inspection Filtering Text정보를 조회 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @return List<ScgNonDcgoRequestVO>
	 * @exception EventException
	 */
	public List<ScgNonDcgoRequestVO> scgNonDcgoRequestList(ScgNonDcgoRequestVO scgNonDcgoRequestVO)
			throws EventException {
		try {
			return dbDao.scgNonDcgoRequestList(scgNonDcgoRequestVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Lane Code"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Systematic Inspection Filtering Text정보를 수정 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVOs
	 * @param account
	 * @exception EventException
	 */
	public void modifyScgNonDcgoRequest(ScgNonDcgoRequestVO[] scgNonDcgoRequestVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgNonDcgoRequestVO> insertVoList = new ArrayList<ScgNonDcgoRequestVO>();
			List<ScgNonDcgoRequestVO> updateVoList = new ArrayList<ScgNonDcgoRequestVO>();
			
			for ( int i=0; i<scgNonDcgoRequestVOs.length; i++ ) {
				if ( "1".equals(scgNonDcgoRequestVOs[i].getChgFlg())){
					scgNonDcgoRequestVOs[i].setCreUsrId(account.getUsr_id());
					scgNonDcgoRequestVOs[i].setUpdUsrId(account.getUsr_id());
					
					// Undeclared인 경우.
					if("X".equals(scgNonDcgoRequestVOs[i].getSpclCgoAproCd())){
						String chkCnt = dbDao.searchScgNonDcgoRequest(scgNonDcgoRequestVOs[i].getBkgNo());
						if("0".equals(chkCnt)){
							insertVoList.add(scgNonDcgoRequestVOs[i]);
						}
					}
					
					updateVoList.add(scgNonDcgoRequestVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyScgNonDcgoRequest(updateVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addScgNonDcgoRequest(insertVoList);
			}

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO RSO"}).getMessage(), ex);
        }
	}
	
	/**
	 * BOOKING의 KEYWORD정보결과를 저장하는 Interface입니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param keySeq
	 * @exception EventException
	 */
    public void addScgNonDgCgoKwRqst(ScgNonDcgoRequestVO scgNonDcgoRequestVO, String[] keySeq) throws EventException{
        try {
                   
               String seq = dbDao.searchNonDgRqstSeq(scgNonDcgoRequestVO.getBkgNo());
               scgNonDcgoRequestVO.setNonDcgoRqstSeq(seq);
               // SCG_NON_DG_CGO_KW_RQST 테이블 등록
               dbDao.addScgNonDgCgoKwRqst(scgNonDcgoRequestVO);
               for(int i = 0; i< keySeq.length; i++){
                         ScgNonDcgoRequestVO vo = new ScgNonDcgoRequestVO();
                         vo.setBkgNo(scgNonDcgoRequestVO.getBkgNo());
                         vo.setNonDcgoRqstSeq(seq);
                         vo.setNonDcgoKwSeq(keySeq[i]);
                         // SCG_NON_DG_CGO_KW_RQST_DTL 테이블 등록 
                         dbDao.addScgNonDgCgoKwRqstDtl(vo);
               }
                   
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * Systematic Inspection Filtering Text의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @exception EventException
	 */
	public void scgNonDcgoRequestMail(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws EventException{
		try {

			scgNonDcgoRequestVO.setUpdUsrId(account.getUsr_id());
			dbDao.scgNonDcgoRequestMail(scgNonDcgoRequestVO);				
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * Undeclared DG Cargo의 메일Format을 조회 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @return List<ScgNonDcgoRequestVO>
	 * @exception EventException
	 */
	public List<ScgNonDcgoRequestVO> scgNonDcgoRequestMailFormat(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.scgNonDcgoRequestMailFormat(scgNonDcgoRequestVO, account);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Mail Preview"}).getMessage(), ex);
		}
	}
	
	/**
	 * Undeclared DG Cargo 자동 메일을 전송한다.<br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String sendVnorEmail(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws EventException {
		StringBuilder sbHtmlContent = null;
		List<String> recipients = new ArrayList<String>();
		String emlSndNo = null;
		
	    try {
	    	
			List<ScgNonDcgoRequestVO > vos = scgNonDcgoRequestMailFormat(scgNonDcgoRequestVO, account);
			
			String fromPsn     = "";
			String toPsn       = "";
			String ccPsn       = "";
			String subject     = "";
			String body_conts  = "";
//			String attachFile  = "";
//			String bodyHeader  = "";
//			String body_footer = "";
			
			if(vos != null && vos.size() > 0) {
				fromPsn     = vos.get(0).getFromPsn();
				toPsn       = vos.get(0).getToPsn();
				ccPsn       = vos.get(0).getCcPsn();
				subject     = vos.get(0).getSubject();
				body_conts  = vos.get(0).getBodyConts();
//				attachFile  = vos.get(0).getAttachFile();
//				bodyHeader  = vos.get(0).getBodyHeader();
//				body_footer = vos.get(0).getBodyFooter();
			}
	    	
//	    	log.debug(" =====> 0237.[BC] - (fromPsn) : "+fromPsn);
//	    	log.debug(" =====> 0237.[BC] - (toPsn) : "+toPsn);
//	    	log.debug(" =====> 0237.[BC] - (ccPsn) : "+ccPsn);
//	    	log.debug(" =====> 0237.[BC] - (subject) : "+subject);
//	    	log.debug(" =====> 0237.[BC] - (body_conts) : "+body_conts);
	    	
	    	 sbHtmlContent = new StringBuilder();
	    	 sbHtmlContent.append("<html>");
	    	 sbHtmlContent.append("<head>");
	    	 sbHtmlContent.append("<title></title>");
	    	 sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
	    	 sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
	    	 sbHtmlContent.append("</head>");
	    	 sbHtmlContent.append("<body>");
	    	 
	    	 sbHtmlContent.append("<table class=\"search\" border=\"0\" width=\"100%\">");
	    	 sbHtmlContent.append("	<tr>");
	    	 sbHtmlContent.append("	<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\">"+body_conts+"</td>");
	    	 sbHtmlContent.append("	</tr>");
	    	 sbHtmlContent.append("</table>");
	    	 sbHtmlContent.append("</body>");
	    	 sbHtmlContent.append("</html>");
	    	 // Set recipients    	
	    	 recipients.add(toPsn);
	    	 
	    	// Send Mail    	 
	    	Mail mail = new Mail();
			mail.setGroupwareMail();
			mail.setRdSubSysCd("SCG");
			mail.setBatFlg("N");
			mail.setFrom(fromPsn);
			mail.setSubject(subject);
			mail.setRecipients(recipients);
			mail.setHtmlContent(sbHtmlContent.toString());
			emlSndNo = mail.send();				

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12229").getMessage(), ex);
		}
		return emlSndNo;
	}
	
	/*====================================================================================*/
	/**
	 * VOP_SCG_0026 Undeclared History 정보를 조회합니다.<br>
	 * 
	 * @param UndeclaredHistoryVO undeclaredHistoryVO
	 * @return List<UndeclaredHistoryVO>
	 * @exception EventException
	 */
	public List<UndeclaredHistoryVO> searchUndeclaredHistoryList(UndeclaredHistoryVO undeclaredHistoryVO) throws EventException {
		try {
			return dbDao.searchUndeclaredHistoryList(undeclaredHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * VOP_SCG_0026 Undeclared History CODE 정보를 추가,수정,삭제합니다.<br>
	 * 
	 * @param undeclaredHistoryVOs
	 * @param account
	 * @return String
	 * @exception EventException
	 */
	public String manageUndeclaredHistory(UndeclaredHistoryVO[] undeclaredHistoryVOs, List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			//FILE UPLOAD KEY값
			Iterator<String> keyArr = null;			
			if(keys != null) keyArr = keys.iterator();
			
			List<UndeclaredHistoryVO> insertVoList = new ArrayList<UndeclaredHistoryVO>();
			List<UndeclaredHistoryVO> updateVoList = new ArrayList<UndeclaredHistoryVO>();
			List<UndeclaredHistoryVO> deleteVoList = new ArrayList<UndeclaredHistoryVO>();
		
			for ( int i=0; i<undeclaredHistoryVOs.length; i++ ) {
				//FILE UPLOAD KEY값 SETTING하기
				if(keyArr != null) {
					if("Y".equals(undeclaredHistoryVOs[i].getFileSetYn()) && keyArr.hasNext()){
						undeclaredHistoryVOs[i].setFileSavId(keyArr.next());
					}
				}
				undeclaredHistoryVOs[i].setCreUsrId(account.getUsr_id());
				undeclaredHistoryVOs[i].setUpdUsrId(account.getUsr_id());
				
				if(undeclaredHistoryVOs[i].getIbflag().equals("I")){
					 insertVoList.add(undeclaredHistoryVOs[i]);
					 
				} else if(undeclaredHistoryVOs[i].getIbflag().equals("U")){
					updateVoList.add(undeclaredHistoryVOs[i]);
				} else if ( undeclaredHistoryVOs[i].getIbflag().equals("D")){
					deleteVoList.add(undeclaredHistoryVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addUndeclaredHistoryList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyUndeclaredHistoryList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeUndeclaredHistoryList(deleteVoList);
			}
		  return "";
		  
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(),ex);
        }
	}

	/**
	 * Undeclared History BKG_NO. 체크<br>
	 * 
	 * @param UndeclaredHistoryVO undeclaredHistoryVO
	 * @return String
	 * @exception EventException
	 */
	public String checkUndeclaredHistory(UndeclaredHistoryVO undeclaredHistoryVO) throws EventException {		
		try {
			return dbDao.checkUndeclaredHistory(undeclaredHistoryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CBF Volume List"}).getMessage(), ex);
		}
	}
	
}
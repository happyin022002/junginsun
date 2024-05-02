/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtBCImp.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.11 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration.RFAExceptionTariffMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionDeleteVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFACopyMstToBzcVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - NIS2010-DMTExceptionMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2003EventResponse,RFAExceptionTariffMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFAExceptionTariffMgtBCImpl extends BasicCommandSupport implements
		RFAExceptionTariffMgtBC {
	
	// Database Access Object
	private transient RFAExceptionTariffMgtDBDAO dbDao = null;
	
	/**
	 * RFAExceptionTariffMgtBCImpl 객체 생성<br>
	 * RFAExceptionTariffMgtDBDAO를 생성한다.<br>
	 */
	public RFAExceptionTariffMgtBCImpl() {
		dbDao = new RFAExceptionTariffMgtDBDAO();
	}
	
	
	/**
	 * Before Booking의 Proposal No. 에 해당되는 DAR No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeDARList(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchBeforeDARList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Booking의 DAR No. 에 해당되는 Version을 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeVERList(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchBeforeVERList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Booking Exception을 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<BeforeExceptionVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionVO> searchBeforeExceptionList(RFAProgressVO rFAProgressVO) throws EventException {
		List<BeforeExceptionVO> beforeExceptionVOs = null;
		try {
			beforeExceptionVOs = dbDao.searchBeforeExceptionList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return beforeExceptionVOs;		
	}
	
	
	/**
	 * Actual Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchCustomerListByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		
		List<RFAExceptionCustomerVO> list = null;
		try {
			list = dbDao.searchCustomerListByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Proposal No. 에 해당되는 Affiliate를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchAffiliateListByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		
		List<RFAExceptionCustomerVO> list = null;
		try {
			list = dbDao.searchAffiliateListByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * DAR No. 나 Approval No. 로 Proposal No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */	
	public List<RFAProgressVO> searchPropNoByDARApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		
		List<RFAProgressVO> list = null;
		try {
			list = dbDao.searchPropNoByDARApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * DAR No. 를 생성, 조회 합니다. <br>
	 * 
	 * @param String bkgTpCd
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchNewDAR(String bkgTpCd, String usrId, String ofcCd) throws EventException {
		try {
			return dbDao.searchNewDAR(bkgTpCd, usrId, ofcCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	
	/**
	 * Version 에 해당되는 Comment History를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchCommentHistory(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	
	/**
	 * Before Booking Exception 을 생성, 수정, 삭제 합니다.<br>
	 * 
	 * @param RFAExceptionGRPVO rFAExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return RFAProgressVO
	 * @exception EventException
	 */
	public RFAProgressVO modifyBeforeException(RFAExceptionGRPVO rFAExceptionGRPVO, SignOnUserAccount account) throws EventException {

		//결과를 반환할 객체를 생성한다.
		RFAProgressVO	rFAProgressVO 	= new RFAProgressVO();
		
		try {
			//Before Booking Request Tariff 의 Version ==================================================================================
			BeforeExceptionVersionVO 		beforeExceptionVersionVO 	= rFAExceptionGRPVO.getBeforeExceptionVersionVO();
			
			beforeExceptionVersionVO.setCreUsrId(		account.getUsr_id()		);
			beforeExceptionVersionVO.setCreOfcCd(		account.getOfc_cd()		);
			beforeExceptionVersionVO.setUpdUsrId(		account.getUsr_id()		);
			beforeExceptionVersionVO.setUpdOfcCd(		account.getOfc_cd()		);	
			beforeExceptionVersionVO.setRqstUsrId(		account.getUsr_id()		);
			beforeExceptionVersionVO.setRqstOfcCd(		account.getOfc_cd()		);
			//==========================================================================================================================

			//Before Booking Request 의 Detail 정보 ======================================================================================
			BeforeExceptionVO				beforeExceptionVO			= null;
			List<BeforeExceptionVO>	 		beforeExceptionVOs 			= rFAExceptionGRPVO.getBeforeExceptionVOS();
			
			if (beforeExceptionVOs != null) {
				beforeExceptionVO = beforeExceptionVOs.get(0);
				
				beforeExceptionVO.setCreUsrId(account.getUsr_id());
				beforeExceptionVO.setCreOfcCd(account.getOfc_cd());
				
				//DAR No. 신규 생성할 경우라면============================================================================================
				if ("I".equals(beforeExceptionVO.getIbflag()) && beforeExceptionVO.getRfaExptDarNo().length() == 0) {
					//DAR No. 를 신규 생성한다.
					rFAProgressVO.setRfaExptDarNo(dbDao.searchNewDAR("B", account.getUsr_id(), account.getOfc_cd()));
					
					//Before Exception Request Version 에 설정해준다.
					beforeExceptionVersionVO.setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
					//Before Exception Request Detail  에 설정해준다.
					beforeExceptionVO.setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
				}
				//======================================================================================================================
				
				//BKG DEL(I) or POR(O)
				if ("US".equals(beforeExceptionVO.getFnlDestCntCd()) || "CA".equals(beforeExceptionVO.getFnlDestCntCd())) {
					beforeExceptionVO.setFnlDestSteCd(beforeExceptionVO.getFnlDestRgnCd());
					beforeExceptionVO.setFnlDestRgnCd("");
				}

				//Before Booking Request 의 Version 정보가 존재하는지 조회 합니다.
				if (!dbDao.existBeforeExceptionVersion(beforeExceptionVersionVO)) {
					//Version 정보가 없으면 생성 합니다.
					dbDao.addBeforeExceptionVersion(beforeExceptionVersionVO);
				}
				else {
					//Version 정보가 있다면, 상태를 'Temp.Saved' 으로 Version 의 상태를 갱신한다.
					dbDao.modifyVersionSTS(beforeExceptionVersionVO);
				}
				
				//Version Prog 테이블에 Temp 상태의 이력을 쌓는다.
				//만일, 현재 버전의 상태가 'Temp.Saved' 일 경우에는 갱신해주고 그렇지 않다면 생성해준다.
				if (dbDao.isTempSavedStatusOfLastVersionProg(beforeExceptionVersionVO)) {
					dbDao.modifyLastVersionProg(beforeExceptionVersionVO);
				}
				else {
					dbDao.addBeforeExceptionVersionProg(beforeExceptionVersionVO);
				}

				if ("I".equals(beforeExceptionVO.getIbflag())) {
					//Detail Seq. 정보를 조회합니다.
					rFAProgressVO.setRfaRqstDtlSeq(dbDao.searchBeforeExceptionDetailSeq(beforeExceptionVO));
					if (rFAProgressVO.getRfaRqstDtlSeq() == null) {
						throw new EventException("DMT00003");
					}
					
					//Before Booking Request 정보를 생성 합니다.
					beforeExceptionVO.setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
					dbDao.addBeforeExceptionDetail(beforeExceptionVO);
				}
				else if ("U".equals(beforeExceptionVO.getIbflag())) {
					beforeExceptionVO.setUpdUsrId(account.getUsr_id());
					beforeExceptionVO.setUpdOfcCd(account.getOfc_cd());
					
					//Before Booking Request 정보를 수정 합니다.	
					dbDao.modifyBeforeExceptionDetail(beforeExceptionVO);
				}
			}
			//=========================================================================================================================
			
			//Before Booking Request 의 Detail Seq. 에 해당하는 Multi Origin or Dest. ====================================================
			List<RFAExceptionCoverageVO>	rFAExceptionCoverageVOs			= rFAExceptionGRPVO.getRFAExceptionCoverageVOS();
			List<RFAExceptionCoverageVO> 	insRFAExceptionCoverageVOs 		= new ArrayList<RFAExceptionCoverageVO>();
			List<RFAExceptionCoverageVO> 	updRFAExceptionCoverageVOs 		= new ArrayList<RFAExceptionCoverageVO>();
			List<RFAExceptionCoverageVO> 	delRFAExceptionCoverageVOs 		= new ArrayList<RFAExceptionCoverageVO>();
			
			if (rFAExceptionCoverageVOs != null) {
				for (int i = 0 ; i < rFAExceptionCoverageVOs.size(); i++) {

					//Coverage
					if ("US".equals(rFAExceptionCoverageVOs.get(i).getCvrgCntCd()) || "CA".equals(rFAExceptionCoverageVOs.get(i).getCvrgCntCd())) {
						rFAExceptionCoverageVOs.get(i).setCvrgSteCd(rFAExceptionCoverageVOs.get(i).getCvrgRgnCd());
						rFAExceptionCoverageVOs.get(i).setCvrgRgnCd("");
					}
					
					//Multi Origin or Destination
					if ("US".equals(rFAExceptionCoverageVOs.get(i).getOrgDestCntCd()) || "CA".equals(rFAExceptionCoverageVOs.get(i).getOrgDestCntCd())) {
						rFAExceptionCoverageVOs.get(i).setOrgDestSteCd(rFAExceptionCoverageVOs.get(i).getOrgDestRgnCd());
						rFAExceptionCoverageVOs.get(i).setOrgDestRgnCd("");
					}
					
					//생성
					if (rFAExceptionCoverageVOs.get(i).getIbflag().equals("I")) {
						rFAExceptionCoverageVOs.get(i).setCreUsrId(account.getUsr_id());
						rFAExceptionCoverageVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Before Exception Request Tariff 가 신규생성되었을 경우 Dar No., Detail Seq.가 없기 때문에 추가해준다.
						if (rFAExceptionCoverageVOs.get(i).getRfaExptDarNo().length() == 0) {
							rFAExceptionCoverageVOs.get(i).setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
						}
						if (rFAExceptionCoverageVOs.get(i).getRfaRqstDtlSeq().length() == 0) {
							rFAExceptionCoverageVOs.get(i).setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
						}
						
						insRFAExceptionCoverageVOs.add(rFAExceptionCoverageVOs.get(i));
					}
					//수정
					else if (rFAExceptionCoverageVOs.get(i).getIbflag().equals("U")) {
						rFAExceptionCoverageVOs.get(i).setUpdUsrId(account.getUsr_id());
						rFAExceptionCoverageVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updRFAExceptionCoverageVOs.add(rFAExceptionCoverageVOs.get(i));
					}
					//삭제
					else if (rFAExceptionCoverageVOs.get(i).getIbflag().equals("D")) {
						delRFAExceptionCoverageVOs.add(rFAExceptionCoverageVOs.get(i));
					}					
				}
			}			
			//=========================================================================================================================
			
			//Before Booking Request 의 Detail Seq. 에 해당하는  Rate Adjustment =========================================================
			List<RFAExceptionRateAdjustVO> 	rFAExceptionRateAdjustVOs		= rFAExceptionGRPVO.getRFAExceptionRateAdjustVOS();
			List<RFAExceptionRateAdjustVO> 	insRFAExceptionRateAdjustVOs 	= new ArrayList<RFAExceptionRateAdjustVO>();
			List<RFAExceptionRateAdjustVO> 	updRFAExceptionRateAdjustVOs 	= new ArrayList<RFAExceptionRateAdjustVO>();
			List<RFAExceptionRateAdjustVO> 	delRFAExceptionRateAdjustVOs 	= new ArrayList<RFAExceptionRateAdjustVO>();
			
			if (rFAExceptionRateAdjustVOs != null) {
				for (int i = 0 ; i < rFAExceptionRateAdjustVOs.size(); i++) {
					//생성
					if (rFAExceptionRateAdjustVOs.get(i).getIbflag().equals("I")) {
						rFAExceptionRateAdjustVOs.get(i).setCreUsrId(account.getUsr_id());
						rFAExceptionRateAdjustVOs.get(i).setCreOfcCd(account.getOfc_cd());
						
						//Before Exception Request Tariff 가 신규생성되었을 경우 Dar No., Detail Seq.가 없기 때문에 추가해준다.
						if (rFAExceptionRateAdjustVOs.get(i).getRfaExptDarNo().length() == 0) {
							rFAExceptionRateAdjustVOs.get(i).setRfaExptDarNo(rFAProgressVO.getRfaExptDarNo());
						}						
						if (rFAExceptionRateAdjustVOs.get(i).getRfaRqstDtlSeq().length() == 0) {
							rFAExceptionRateAdjustVOs.get(i).setRfaRqstDtlSeq(rFAProgressVO.getRfaRqstDtlSeq());
						}
						
						insRFAExceptionRateAdjustVOs.add(rFAExceptionRateAdjustVOs.get(i));
					}
					//수정
					else if (rFAExceptionRateAdjustVOs.get(i).getIbflag().equals("U")) {
						rFAExceptionRateAdjustVOs.get(i).setUpdUsrId(account.getUsr_id());
						rFAExceptionRateAdjustVOs.get(i).setUpdOfcCd(account.getOfc_cd());
						
						updRFAExceptionRateAdjustVOs.add(rFAExceptionRateAdjustVOs.get(i));
					}
					//삭제
					else if (rFAExceptionRateAdjustVOs.get(i).getIbflag().equals("D")) {
						delRFAExceptionRateAdjustVOs.add(rFAExceptionRateAdjustVOs.get(i));
					}
				}
			}
			//=========================================================================================================================
			
			int delCoverageSize	= 0;
			int insCoverageSize = 0;
			
			//1.[Delete Action] * 반드시 삭제 Action 이 먼저 실행되어야 한다. *
			//1-1.Multi Origin(I) or Destination(O)
			if (delRFAExceptionCoverageVOs.size() > 0) {
				dbDao.removeBeforeExceptionCoverage(delRFAExceptionCoverageVOs);
				
				//DMT_RFA_EXPT_TRF_DTL 테이블에 CVRG_CMB_SEQ 컬럼추가로 인해서
				//Coverage 정보가 삭제될 경우 동일한 CVRG_CMB_SEQ 을 갖는 정보도 삭제되어야 한다.
				//아래 변수는 삭제여부를 결정하기 위해서 사용됨.
				delCoverageSize = delRFAExceptionCoverageVOs.size();
			}
			//1-2.Rate Adjustment
			if (delRFAExceptionRateAdjustVOs.size() > 0) {
				dbDao.removeBeforeExceptionRate(delRFAExceptionRateAdjustVOs);
			}

			//2.[Insert Action]
			//2-1.Multi Origin or Destination
			if (insRFAExceptionCoverageVOs.size() > 0) {
				
				insCoverageSize = insRFAExceptionCoverageVOs.size();
				
				//Coverage 데이터를 추가하기 전에 부모 테이블에 Coverage Seq. 에 해당되는 데이터가 있는지 확인후 없는것만 추가하도록 한다.
				//신규 입력되는 Coverage 갯수가 삭제된 Coverage 갯수보다 클 경우에만 Before Exception Request 항목을 추가해준다.
				//이 경우는 Multi 에서 Single 로 변경시 해당됨.
				if (insCoverageSize - delCoverageSize > 0) {
					for (int i = 0 ; i < insCoverageSize ; i++) {
						dbDao.addBeforeExceptionTariffByCVRG(insRFAExceptionCoverageVOs.get(i));
					}
				}
				
				dbDao.addBeforeExceptionCoverage(insRFAExceptionCoverageVOs);
			}
			//2-2.Rate Adjustment
			if (insRFAExceptionRateAdjustVOs.size() > 0) {
				dbDao.addBeforeExceptionRate(insRFAExceptionRateAdjustVOs);
			}
			
			//3.[Update Action]
			//3-1.Multi Origin or Destination
			if (updRFAExceptionCoverageVOs.size() > 0) {
				dbDao.modifyBeforeExceptionCoverage(updRFAExceptionCoverageVOs);
			}
			//3-2.Rate Adjustment
			if (updRFAExceptionRateAdjustVOs.size() > 0) {
				dbDao.modifyBeforeExceptionRate(updRFAExceptionRateAdjustVOs);
			}
			
			//4.삭제된 Coverage 정보가 있다면, 관련 Coverage Seq. 를 갖는 Before Booking Request 정보도 삭제해준다.
			if (delCoverageSize > 0) {
				dbDao.removeBeforeExceptionTariffByCVRG(beforeExceptionVersionVO);
			}
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		return rFAProgressVO;
	}
	
	
	/**
	 * DAR No. 와 Ver No. 에 대한 기존 Approval No. 를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */		
	public String searchPrevApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		String approvalNo = null;
		try {
			//기존 승인번호를 조회한다.
			approvalNo = dbDao.searchPrevApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return approvalNo;
	}
	
	
	/**
	 * Approval No. 를 신규 생성 한다. <br>
	 * 
	 * @param String usrId
	 * @param String rhqOfcCd
	 * @param String bkgTpCd
	 * @return String
	 * @exception EventException
	 */		
	public String searchNewApprovalNo(String usrId, String rhqOfcCd, String bkgTpCd) throws EventException {
		String approvalNo = null;
		try {
			//새로운 승인 번호를 채번한다.
			approvalNo = dbDao.searchNewApprovalNo(usrId, rhqOfcCd, bkgTpCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return approvalNo;
	}
	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Approved'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void approvalBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			//1.현재 버전의 상태를 승인상태로 변경한다.
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			
			//2.승인요청시 Comment를 저장한다.
			dbDao.addCommentHistory(rFAProgressVO);
			
			//3.최종버전이 승인처리될 경우 이전 승인처리된 버전의 Comment History 에 Cancelled 로그를 추가한다.
			//  장민지대리 요청으로 2009-08-16일 추가함
			dbDao.addCancelCommentHistory(rFAProgressVO);
			
			//4.생성된 상위 Version 의 Status 가 Approved 로 변경시에 기존에 Approved 의 STS 를
			//  가지는 해당 DAR 의 다른 Version 의 STS 를 Cancelled 로 변경
			//  이전 버전의 승인상태가 Cancelled 로 변경되기 때문에 승인번호도 지워준다.(2009-08-26)
			dbDao.modifyBeforeExceptionOtherTariffStatus(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Request'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void requestBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Cancel'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void cancelBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Counter Offer'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void counterofferBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Reject'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void rejectBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.modifyBeforeExceptionStatus(rFAProgressVO);
			dbDao.addCommentHistory(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * DAR No. 에 해당되는 Approval No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeAPROList(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchBeforeAPROList(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Proposal No. 에 해당되는 Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchCustomerByProp(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchCustomerByProp(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Proposal No. 에 해당되는 RFA No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFAByProp(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRFAByProp(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * DAR No. 와 Version No. 에 해당되는 모든 Multi Origin or Destination를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCoverageVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCoverageVO> searchMultiCoverageByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchMultiCoverageByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * DAR No. 와 Version No. 에 해당되는 모든 Rate Adjustment를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<RFAExceptionRateAdjustVO> searchRateAdjustmentByRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRateAdjustmentByRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Proposal No. 에 해당되는 RFA No. 와 Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCustomerVO> searchRFANoCustomerByProposalNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRFANoCustomerByProposalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Approval No. 에 해당되는 Version를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchVERByApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchVERByApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * DAR No. 에 해당되는 Approval Office를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchApprovalOfcByDAR(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchApprovalOfcByDAR(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO beforeAfterStatusInputVO
	 * @return List<BeforeAfterStatusVO>
	 * @exception EventException
	 */
	public List<BeforeAfterStatusVO> searchBeforeAfterStatusList(BeforeAfterStatusInputVO beforeAfterStatusInputVO) throws EventException {
		List<BeforeAfterStatusVO> list = null;
		try {
			//"DMT03"인 USER에 한해서만 하위 점소의 AFTER BKG까지 조회한다.
			if ("AB".equals(beforeAfterStatusInputVO.getType()) 
					&& "DATE".equals(beforeAfterStatusInputVO.getCondTp()) 
					&& "RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
				
				//DMT03 인 권한이 있는지 체크한다.
				if (dbDao.searchOwnedRole(beforeAfterStatusInputVO.getLoginUsrId(), beforeAfterStatusInputVO.getUsrRoleCd())) {
					//DMT03 권한이 있을 경우
					beforeAfterStatusInputVO.setIsOwnedRole("Y");
					beforeAfterStatusInputVO.setUsrOfcCd(beforeAfterStatusInputVO.getLoginOfcCd());
				}
				else {
					//DMT03 권한이 없을 경우
					beforeAfterStatusInputVO.setIsOwnedRole("N");
				}
			}
			
			//조회대상 Type 이 S/C 일 경우
			if ("SC".equals(beforeAfterStatusInputVO.getType())) {
				if ("DATE".equals(beforeAfterStatusInputVO.getCondTp())) {
					if ("RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchSCTariffListByDateUserIDRCV(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchSCTariffListByDateUserOfficeRCV(beforeAfterStatusInputVO);
						}
					}
					else {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchSCTariffListByDateUserIDSND(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchSCTariffListByDateUserOfficeSND(beforeAfterStatusInputVO);
						}
					}
				}
				else {
					list = dbDao.searchSCTariffListByDAR(beforeAfterStatusInputVO);
				}
			}
			//조회대상 Type 이 Before Booking 일 경우
			else if ("BB".equals(beforeAfterStatusInputVO.getType())) {
				if ("DATE".equals(beforeAfterStatusInputVO.getCondTp())) {
					if ("RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchBeforeBookingListByDateUserIDRCV(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchBeforeBookingListByDateUserOfficeRCV(beforeAfterStatusInputVO);
						}
					}
					else {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchBeforeBookingListByDateUserIDSND(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchBeforeBookingListByDateUserOfficeSND(beforeAfterStatusInputVO);							
						}
					}					
				}
				else {
					list = dbDao.searchBeforeBookingListByDAR(beforeAfterStatusInputVO);	
				}
			}
			//조회대상 Type 이 After Booking 일 경우
			else if ("AB".equals(beforeAfterStatusInputVO.getType())) {
				if ("DATE".equals(beforeAfterStatusInputVO.getCondTp())) {
					if ("RCV".equals(beforeAfterStatusInputVO.getTabTp())) {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchAfterBookingListByDateUserIDRCV(beforeAfterStatusInputVO);	
						}
						else {
							list = dbDao.searchAfterBookingListByDateUserOfficeRCV(beforeAfterStatusInputVO);							
						}	
					}
					else {
						if (beforeAfterStatusInputVO.getUsrId() != null && beforeAfterStatusInputVO.getUsrId().length() > 0) {
							list = dbDao.searchAfterBookingListByDateUserIDSND(beforeAfterStatusInputVO);
						}
						else {
							list = dbDao.searchAfterBookingListByDateUserOfficeSND(beforeAfterStatusInputVO);							
						}
					}					
				}
				else {
					list = dbDao.searchAfterBookingListByDAR(beforeAfterStatusInputVO);	
				}
			}			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Before Booking Customer여부를 조회 합니다. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isBeforeBKGCustomer(String custCntCd, String custSeq) throws EventException {
		try {
			return dbDao.isBeforeBKGCustomer(custCntCd, custSeq);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Proposal No. 에 해당되는 Before Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByPropNo(BeforeExceptionListInputVO inputVO) throws EventException {
		try {
			return dbDao.searchBeforeExceptionListByPropNo(inputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * Customer Code 와 RFA No. 에 해당되는 Before Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByCustomer(BeforeExceptionListInputVO inputVO) throws EventException {
		try {
			return dbDao.searchBeforeExceptionListByCustomer(inputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * 승인권한자를 조회 합니다. <br>
	 * 
	 * @param ApprovalRequestUserVO approvalRequestUserVO
	 * @param String condType
	 * @return List<ApprovalRequestUserListVO>
	 * @exception EventException
	 */
	public List<ApprovalRequestUserListVO> searchApprovalAuthorityList(ApprovalRequestUserVO approvalRequestUserVO, String condType) throws EventException {
		try {
			return dbDao.searchApprovalAuthorityList(approvalRequestUserVO, condType);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Update 버튼 클릭시 'Approved', 'Rejected' 상태의 Before Booking Request 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */
	public void addBeforeExceptionByUpdate(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			//1.신규 버전 정보를 조회한다.
			String 						versionSeq 					= dbDao.searchBeforeExceptionVersionSeq(rFAProgressVO);

			//2.Version, Version Prog 정보를 생성하기 위한 Version 객체를 생성 합니다.
			BeforeExceptionVersionVO	beforeExceptionVersionVO	= new BeforeExceptionVersionVO();
			
			beforeExceptionVersionVO.setRfaExptDarNo(		rFAProgressVO.getRfaExptDarNo()			);
			beforeExceptionVersionVO.setRfaExptMapgSeq(		rFAProgressVO.getRfaExptMapgSeq()		);
			beforeExceptionVersionVO.setRfaExptVerSeq(		versionSeq								);
			beforeExceptionVersionVO.setCreUsrId(			rFAProgressVO.getCreUsrId()				);
			beforeExceptionVersionVO.setCreOfcCd(			rFAProgressVO.getCreOfcCd()				);
			beforeExceptionVersionVO.setDmdtExptRqstStsCd(	rFAProgressVO.getDmdtExptRqstStsCd()	);
			beforeExceptionVersionVO.setPropNo(				rFAProgressVO.getPropNo()				);
			beforeExceptionVersionVO.setCustCntCd(			rFAProgressVO.getCustCntCd()			);
			beforeExceptionVersionVO.setCustSeq(			rFAProgressVO.getCustSeq()				);
			beforeExceptionVersionVO.setRqstUsrId(			rFAProgressVO.getRqstUsrId()			);
			beforeExceptionVersionVO.setRqstOfcCd(			rFAProgressVO.getRqstOfcCd()			);
			beforeExceptionVersionVO.setAproOfcCd(			rFAProgressVO.getAproOfcCd()			);

			//2-1.Before Booking Request 에 신규 채번된 Version Seq. 를 설정 합니다.
			rFAProgressVO.setRfaExptVerSeq(					versionSeq								);
			
			//3.신규 버전에 대한 정보를 'Temp' 상태로 Version 에 생성 합니다.
			dbDao.addBeforeExceptionVersion(beforeExceptionVersionVO);
			
			//4.신규 버전에 대한 정보를 'Temp' 상태로 Version Prog 에 생성 합니다.
			dbDao.addBeforeExceptionVersionProg(beforeExceptionVersionVO);
			
			//5.이전 버전의 모든 Before Booking Request 의 Detail 정보를 신규 버전으로 생성 합니다.
			dbDao.addBeforeExceptionDetailOfPrevVersion(rFAProgressVO);
			
			//6.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는  Multi Origin or Dest. 정보를 신규 버전으로 생성 합니다.
			dbDao.addBeforeExceptionCoverageOfPrevVersion(rFAProgressVO);
			
			//7.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Rate Adjustment 정보를 신규 버전으로 생성 합니다.
			dbDao.addBeforeExceptionRateAdjustmentOfPrevVersion(rFAProgressVO);
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}		
	
	
	/**
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 DAR History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBeforeExceptionByHistoryCopy(RFAProgressVO rFAProgressVO, SignOnUserAccount account) throws EventException {
		try {
			//1.Version, Version Prog 정보를 생성하기 위한 Version 객체를 생성 합니다.
			BeforeExceptionVersionVO	beforeExceptionVersionVO	= new BeforeExceptionVersionVO();
			BeforeExceptionDeleteVO		beforeExceptionDeleteVO		= null;
			
			//신규버전일 경우 DAR No. 가 없기 때문에 DAR No. 를 새로 생성한다.
			if (rFAProgressVO.getRfaExptDarNo().length() == 0) {
				rFAProgressVO.setRfaExptDarNo(dbDao.searchNewDAR("B", account.getUsr_id(), account.getOfc_cd()));
			}
			
			beforeExceptionVersionVO.setRfaExptDarNo(		rFAProgressVO.getRfaExptDarNo()			);
			beforeExceptionVersionVO.setRfaExptMapgSeq(		rFAProgressVO.getRfaExptMapgSeq()		);
			beforeExceptionVersionVO.setRfaExptVerSeq(		rFAProgressVO.getRfaExptVerSeq()		);
			beforeExceptionVersionVO.setCreUsrId(			rFAProgressVO.getCreUsrId()				);
			beforeExceptionVersionVO.setCreOfcCd(			rFAProgressVO.getCreOfcCd()				);
			beforeExceptionVersionVO.setUpdUsrId(			rFAProgressVO.getUpdUsrId()				);
			beforeExceptionVersionVO.setUpdOfcCd(			rFAProgressVO.getUpdOfcCd()				);
			beforeExceptionVersionVO.setDmdtExptRqstStsCd(	rFAProgressVO.getDmdtExptRqstStsCd()	);
			beforeExceptionVersionVO.setPropNo(				rFAProgressVO.getPropNo()				);
			beforeExceptionVersionVO.setAproOfcCd(			rFAProgressVO.getAproOfcCd()			);
			beforeExceptionVersionVO.setCustCntCd(			rFAProgressVO.getCustCntCd()			);
			beforeExceptionVersionVO.setCustSeq(			rFAProgressVO.getCustSeq()				);
			beforeExceptionVersionVO.setRqstUsrId(			rFAProgressVO.getUpdUsrId()				);
			beforeExceptionVersionVO.setRqstOfcCd(			rFAProgressVO.getUpdOfcCd()				);
			
			//현재 버전의 Before Booking Request 정보가 있다면 삭제 합니다.
			if (dbDao.existBeforeException(rFAProgressVO)) {
				beforeExceptionDeleteVO = new BeforeExceptionDeleteVO();
				beforeExceptionDeleteVO.setDelRfaExptDarNo(		rFAProgressVO.getRfaExptDarNo()		);
				beforeExceptionDeleteVO.setDelRfaExptMapgSeq(	rFAProgressVO.getRfaExptMapgSeq()	);
				beforeExceptionDeleteVO.setDelRfaExptVerSeq(	rFAProgressVO.getRfaExptVerSeq()	);
								
				dbDao.removeBeforeExceptionByVerNo(beforeExceptionDeleteVO);
			}
			
			//2.현재 버전의 상태를 'Temp.Saved' 로 수정 합니다.
			//Before Booking Request 의 Version 정보가 존재하는지 조회 합니다.
			if (!dbDao.existBeforeExceptionVersion(beforeExceptionVersionVO)) {
				//Version 정보가 없으면 생성 합니다.
				dbDao.addBeforeExceptionVersion(beforeExceptionVersionVO);
			}
			else {
				//Version 정보가 있다면, 상태를 'Temp.Saved' 으로 Version 의 상태를 갱신한다.
				dbDao.modifyVersionSTS(beforeExceptionVersionVO);
			}
			
			//3.현재 버전에 대한 정보를 'Temp.Saved' 상태로 Version Prog 에 생성 합니다.
			if (dbDao.isTempSavedStatusOfLastVersionProg(beforeExceptionVersionVO)) {
				dbDao.modifyLastVersionProg(beforeExceptionVersionVO);
			}
			else {
				dbDao.addBeforeExceptionVersionProg(beforeExceptionVersionVO);
			}			
			
			//4.이전 버전의 모든 Before Booking Request 의 Detail 정보를 신규 버전으로 생성 합니다.
			dbDao.addBeforeExceptionDetailOfHistVersion(rFAProgressVO);
			
			//5.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Multi Origin or Dest. 정보를 신규 버전으로 생성 합니다.
			dbDao.addBeforeExceptionCoverageOfHistVersion(rFAProgressVO);
			
			//6.이전 버전의 모든 Before Booking Request 의 Detail 에 해당되는 Rate Adjustment 정보를 신규 버전으로 생성 합니다.
			dbDao.addBeforeExceptionRateAdjustmentOfHistVersion(rFAProgressVO);
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 Before Exception Request 의 Detail 과 그 하위항목을 모두 삭제 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */
	public void removeBeforeException(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			dbDao.removeBeforeExceptionRateAdjustment(	rFAProgressVO	);
			dbDao.removeBeforeExceptionCoverage(		rFAProgressVO	);
			dbDao.removeBeforeExceptionDetail(			rFAProgressVO	);
			
			//Before Booking Request 의 Version 에 포함된 Detail 정보가 존재하는지 조회 합니다.
			if (!dbDao.existBeforeException(rFAProgressVO)) {
				//Before Booking Request 의 Detail 정보가 모두 삭제되었다면 Version Prog 정보를 모두 삭제 합니다.
				dbDao.removeBeforeExceptionVersionProg(rFAProgressVO);
				//Before Booking Request 의 Detail 정보가 모두 삭제되었다면 Version 정보를 삭제 합니다.
				dbDao.removeBeforeExceptionVersion(rFAProgressVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 화면에서 입력한 RFA 정보와 기등록된 RFA 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String isDuplicateRFA(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.isDuplicateRFA(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Approval, Counter Offer, Reject 시 최종 Update Date 를 조회 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchUpdateDate(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFATariffByAPVLNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchRFATariffByAPVLNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Proposal No.나 DAR No. 로 Approval No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return RFAProgressVO
	 * @throws EventException
	 */
	public RFAProgressVO searchAproNoByPropApprovalNo(RFAProgressVO rFAProgressVO) throws EventException {
		try {
			return dbDao.searchAproNoByPropApprovalNo(rFAProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Basic RFA 인지 여부를 조회합니다.<br>
	 * 
	 * @param String propNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isBzcRfa(String propNo) throws EventException {
		
		try {
			return dbDao.isBzcRfa(propNo);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Master RFA 의 Proposal No. 를 조회합니다.<br>
	 * 
	 * @param String propNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPropNoOfMstRfa(String propNo) throws EventException {
		
		try {
			return dbDao.searchPropNoOfMstRfa(propNo);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}			
	}
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Master RFA 의 유효한 버전이 Basic RFA 보다 상위 버전인지 여부를 조회합니다.<br>
	 * 
	 * @param String mstPropNo
	 * @param String bzcPropNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isUpprMstRfaVerThanBzcRfaVer(String mstPropNo, String bzcPropNo) throws EventException {
		
		try {
			return dbDao.isUpprMstRfaVerThanBzcRfaVer(mstPropNo, bzcPropNo);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Auto Update 버튼 클릭시 Master RFA 의 유효한 상위버전 정보를 Basic RFA 에 Copy 합니다.<br>
	 * 
	 * @param RFACopyMstToBzcVO paramVO
	 * @exception EventException
	 */
	public void copyMstRfaVerToBzcRfaVer(RFACopyMstToBzcVO paramVO) throws EventException {
		
		try {
			// Copy Type Code :: C ( Create - PRI 에서만 사용함 ( Copy to RFA 실행시 적용됨 )), U ( Auto Update - DMT 에서만 사용함 ( 2003 화면 ))
			// C 인 경우에는 최초로 DAR 이 생성되기 때문에 아래와 같이 DAR NO. 를 채번해야 함.
			if ("C".equals(paramVO.getCpyTpCd())) {
				// 1. Check Validation ( Master RFA 에 등록된 BBE(Before Booking Exception) 이 존재하지 않으면 종료
				if (!dbDao.isExistMstRfaExptTrf(paramVO.getMstPropNo())) return;
				
				// 2. RFA EXPT DAR NO. 채번
				String rfaExptDarNo = dbDao.searchNewDAR("B", paramVO.getCreUsrId(), paramVO.getCreOfcCd());
				paramVO.setRfaExptDarNo(rfaExptDarNo);
			}
			
			// 2. Remark 추가
			String progRmk = "Basic RFA(".concat(paramVO.getBzcPropNo()).concat(") was copied by Master RFA(").concat(paramVO.getMstPropNo()).concat(")");
			paramVO.setProgRmk(progRmk);
			
			// 3. Copy Master RFA to Basic RFA
			dbDao.addRfaExptTrfByMstRfaVer(paramVO);
			dbDao.addRfaExptTrfDtlByMstRfaVer(paramVO);
			dbDao.addRfaExptCvrgCmbByMstRfaVer(paramVO);
			dbDao.addRfaExptRtByMstRfaVer(paramVO);
			dbDao.addRfaExptTrfProgByMstRfaVer(paramVO);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Request 버튼 클릭시 승인까지 일괄적으로 처리한다.<br>
	 * 
	 * @param RFAProgressVO paramVO
	 * @exception EventException
	 */	
	public void approvalByBzcRfa(RFAProgressVO paramVO) throws EventException {
		
		try {
			// 1. 승인번호 채번
			String rfaExptAproNo = dbDao.searchNewApprovalNo(paramVO.getCreUsrId(), paramVO.getRhqOfcCd(), "B");
			paramVO.setRfaExptAproNo(rfaExptAproNo);
			
			// 2. 현 버전를 '승인' 상태로 변경함.
			dbDao.modifyBeforeExceptionStatus(paramVO);
			
			// 3. 승인요청시 Remark 를 저장함.
			dbDao.addCommentHistory(paramVO);
			
			// 4. 최종버전이 승인처리될 경우 이전 승인처리된 버전의 Comment History 에 Cancelled 로그를 추가한다.
			//    장민지대리 요청으로 2009-08-16일 추가함
			dbDao.addCancelCommentHistory(paramVO);
			
			// 5. 현 버전이 승인된 경우, 하위 버전에 '승인' 상태는 모두 Cancelled 로 변경하고, 승인번호도 삭제한다.
			dbDao.modifyBeforeExceptionOtherTariffStatus(paramVO);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * 화면 Load 시 Prop No. 에 대한 BBE( Before Booking Exception )이 등록되었는지 여부를 조회합니다.<br>
	 * 
	 * @param String propNo
	 * @return boolean
	 * @exception EventException
	 */	
	public boolean isExistRfa(String propNo) throws EventException {	
		
		try {
			return dbDao.isExistRfa(propNo);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}

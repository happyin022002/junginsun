/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostCreateBackEndJob.java
*@FileTitle : Payable Rental Charge Cost Create
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.29 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration.PayableRentalCostDBDAO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
//import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
import com.hanjin.syscommon.common.table.LsePayRntlChgDtlVO;

/**
 * @author Jeong Yong Noh
 * @see EES_LSE_0007EventResponse,PayableRentalCostBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PayableRentalCostBackEndJob extends BackEndCommandSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8181873140303002940L;

	private PayableRentalCostDBDAO dbDao;
	
	private String jobType = "";
	private PayableRentalCostVO payableRentalCostVO = null;
	private SignOnUserAccount account = null;
	
	/**
	 * Payable Charge Creataion BackEndJob 수행
	 * 
	 * @return String
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public String doStart() throws EventException {
		try {
			this.dbDao = new PayableRentalCostDBDAO();
			PayableRentalCostCreatVO[] payableRentalCostCreatVO = payableRentalCostVO.getPayableRentalCostCreatVO();

			if ( getJobType().equals("CHG_CRE") ) {
				if ( payableRentalCostCreatVO.length > 0 ) {
					for ( int i = 0 ; i < payableRentalCostCreatVO.length ; i++ ) {
						PayableRentalCostVO paramVO = new PayableRentalCostVO();

						paramVO.setChgCostYrmon(payableRentalCostVO.getChgCostYrmon());
						paramVO.setAgmtCtyCd(payableRentalCostCreatVO[i].getAgmtCtyCd());
						paramVO.setAgmtSeq(payableRentalCostCreatVO[i].getAgmtSeq());
						paramVO.setOfcCd(payableRentalCostVO.getOfcCd());
						paramVO.setUsrId(payableRentalCostVO.getUsrId());

						/*+++++++++++++++++++++++*/
						/*++++ 신규데이터 입력 ++++*/
						/*+++++++++++++++++++++++*/
						// 신규 Master Charge Sequence 조회
						String chgSeq = dbDao.searchNewChargeSequenceData();
			
						// 신규 Master 데이터 입력
						paramVO.setChgSeq(chgSeq);
			
						dbDao.addPayableRentalChargeMasterData(paramVO);
			
						// 신규 Detail Data 조회
						List<LsePayRntlChgDtlVO> lsePayRntlChgVOs = dbDao.searchPayableRentalChargeDetailData(paramVO);
			
						if ( lsePayRntlChgVOs.size() > 0 ) {
							// Detail Data 입력
							//dbDao.addPayableRentalChargeDetailData(lsePayRntlChgVOs);

							for ( int j = 0 ; j < lsePayRntlChgVOs.size() ; j++ ) {
								LsePayRntlChgDtlVO lsePayRntlChgDtlVO = lsePayRntlChgVOs.get(j);
								dbDao.addPayableRentalChargeDetailData(lsePayRntlChgDtlVO);
							}
						}
			
						// Master Data Update
						dbDao.modifyPayableRentalChargeMasterData(paramVO);
					}
				}
			} else if ( getJobType().equals("CHG_DEL") ) {
				if ( payableRentalCostCreatVO.length > 0 ) {
					for ( int i = 0 ; i < payableRentalCostCreatVO.length ; i++ ) {
						PayableRentalCostVO paramVO = new PayableRentalCostVO();

						paramVO.setChgSeq(payableRentalCostCreatVO[i].getChgSeq());
						paramVO.setAgmtCtyCd(payableRentalCostCreatVO[i].getAgmtCtyCd());
						paramVO.setAgmtSeq(payableRentalCostCreatVO[i].getAgmtSeq());

						//기존 Detail 데이터 삭제
						dbDao.removePayableRentalChargeDetailData(paramVO);

						// 기존 Master 데이터 삭제
						dbDao.removePayableRentalChargeMasterData(paramVO);
					}
				}
			} else if ( getJobType().equals("IVN_CRE") ) {
				PayableRentalCostCreatVO[] payableRentalCostCreatVOs = payableRentalCostVO.getPayableRentalCostCreatVO();

				PayableRentalCostBC command  = new PayableRentalCostBCImpl();
				CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

				List<String> listInvNo = new ArrayList();

				// 1. Invoice No. Selection : request 로 부터 생성된 VO 배열에서 중복 제거된 Invoice No.
				String invNo = "";

				for ( int i = 0 ; i < payableRentalCostCreatVOs.length ; i++ ) {
					invNo = payableRentalCostCreatVOs[i].getInvNo();

					if ( i == 0 ) {
						listInvNo.add(invNo);
					} else {
						boolean includeInvNoFlag = false;

						for ( int j = 0 ; j < listInvNo.size() ; j++ ) {
							if ( invNo.equals(listInvNo.get(j)) ) {
								includeInvNoFlag = true;
							}
						}

						if ( !includeInvNoFlag ) {
							listInvNo.add(invNo);
						}
					}
				}

				// 2. Invoice No. 별로 AP 생성 및 Payable Charge Creation Master Data Update 처리.
				for ( int i = 0 ; i < listInvNo.size() ; i++ ) {
					// AP_INV_MAIN 설정
					ApPayInvVO apPayInvVO = command.makePayableRentalInvoiceCreateMainBasic(listInvNo.get(i), payableRentalCostVO, account);

					// AP_INV_DTL 설정
					ApPayInvDtlVO[] apPayInvDtlVOs = command.makePayableRentalInvoiceCreateDetailBasic(listInvNo.get(i), payableRentalCostVO, account);

					// CSR 메소드 실행
					String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

					// CSR 에 받은 INV_RGST_NO 값을 설정
					command.modifyPayableRentalInvoiceBasic(listInvNo.get(i), invRgstNo, payableRentalCostVO, account);
				}
			} else if ( getJobType().equals("OP_IVN_CRE") ) {
				PayableRentalCostOperationalInvoiceVO[] operationalInvoiceVOs = payableRentalCostVO.getArrPayableRentalCostOperationalInvoiceVO();

				PayableRentalCostBC command  = new PayableRentalCostBCImpl();
				CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

				List<String> listInvNo = new ArrayList();

				// 1. Invoice No. Selection : request 로 부터 생성된 VO 배열에서 중복 제거된 Invoice No.
				String invNo = "";

				for ( int i = 0 ; i < operationalInvoiceVOs.length ; i++ ) {
					invNo = operationalInvoiceVOs[i].getInvNo();

					if ( i == 0 ) {
						listInvNo.add(invNo);
					} else {
						boolean includeInvNoFlag = false;

						for ( int j = 0 ; j < listInvNo.size() ; j++ ) {
							if ( invNo.equals(listInvNo.get(j)) ) {
								includeInvNoFlag = true;
							}
						}

						if ( !includeInvNoFlag ) {
							listInvNo.add(invNo);
						}
					}
				}

				// 2. Invoice No. 별로 AP 생성 및 Payable Charge Creation Master Data Update 처리.
				for ( int i = 0 ; i < listInvNo.size() ; i++ ) {
					// AP_INV_MAIN 설정
					ApPayInvVO apPayInvVO = command.makeOperatingPayableRentalInvoiceCreateMainBasic(listInvNo.get(i), payableRentalCostVO, account);

					// AP_INV_DTL 설정
					ApPayInvDtlVO[] apPayInvDtlVOs = command.makeOperatingPayableRentalInvoiceCreateDetailBasic(listInvNo.get(i), payableRentalCostVO, account);

					// CSR 메소드 실행
					String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

					// CSR 에 받은 INV_RGST_NO 값을 설정
					command.modifyOperatingPayableRentalInvoiceBasic(listInvNo.get(i), invRgstNo, payableRentalCostVO, account);
				}
			}
		} catch (EventException ex) {
			super.log.error(ex.getMessage());
			throw ex;
		} catch (DAOException ex) {
			super.log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charget Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			super.log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Payable Rental Charget Creation"}).getMessage(),ex);
		}
		
		return "S";
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setPayableRentalCostVO(PayableRentalCostVO payableRentalCostVO) {
		this.payableRentalCostVO = payableRentalCostVO;
	}

	public PayableRentalCostVO getPayableRentalCostVO() {
		return payableRentalCostVO;
	}
	
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	public SignOnUserAccount getAccount() {
		return account;
	}
}
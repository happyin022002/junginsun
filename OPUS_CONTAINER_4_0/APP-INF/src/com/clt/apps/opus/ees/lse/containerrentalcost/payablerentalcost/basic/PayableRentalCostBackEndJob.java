/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostCreateBackEndJob.java
*@FileTitle : Payable Rental Charge Cost Create
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration.PayableRentalCostDBDAO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.LsePayRntlChgDtlVO;
//import com.clt.framework.component.message.ErrorHandler;
 
/**
 * @author 
 * @see EES_LSE_0007EventResponse,PayableRentalCostBC 
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
	 * Payable Charge Creataion BackEndJob
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
						/*++++ inserting new data ++++*/
						/*+++++++++++++++++++++++*/
						// retrieving for new Master Charge Sequence 
						String chgSeq = dbDao.searchNewChargeSequenceData();
			
						// inserting new Master data
						paramVO.setChgSeq(chgSeq);
			
						dbDao.addPayableRentalChargeMasterData(paramVO);
			
						// inserting new Detail Data 
						List<LsePayRntlChgDtlVO> lsePayRntlChgVOs = dbDao.searchPayableRentalChargeDetailData(paramVO);
			
						if ( lsePayRntlChgVOs.size() > 0 ) {
							// inserting Detail Data 
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

						//removing existing Detail data
						dbDao.removePayableRentalChargeDetailData(paramVO);

						//removing existing Master data 
						dbDao.removePayableRentalChargeMasterData(paramVO);
					}
				}
			} else if ( getJobType().equals("IVN_CRE") ) {
				PayableRentalCostCreatVO[] payableRentalCostCreatVOs = payableRentalCostVO.getPayableRentalCostCreatVO();
				
				
				PayableRentalCostBC command  = new PayableRentalCostBCImpl();
				CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

				List<String> listInvNo = new ArrayList();

				// 1. Invoice No. Selection 
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
				
				// 2. creating AP for each Invoice No. & Updating Payable Charge Creation Master Data  
				for ( int i = 0 ; i < listInvNo.size() ; i++ ) {
					// setting AP_INV_MAIN 
					payableRentalCostVO.setIntLastInvNo(i+1);
					ApPayInvVO apPayInvVO = command.makePayableRentalInvoiceCreateMainBasic(listInvNo.get(i), payableRentalCostVO, account);

					// setting AP_INV_DTL
					ApPayInvDtlVO[] apPayInvDtlVOs = command.makePayableRentalInvoiceCreateDetailBasic(listInvNo.get(i), payableRentalCostVO, account);
					
					// call CSR method
					String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

					// setting INV_RGST_NO from CSR 
					command.modifyPayableRentalInvoiceBasic(listInvNo.get(i), invRgstNo, payableRentalCostVO, account);
				}
			} else if ( getJobType().equals("OP_IVN_CRE") ) {
				PayableRentalCostOperationalInvoiceVO[] operationalInvoiceVOs = payableRentalCostVO.getArrPayableRentalCostOperationalInvoiceVO();

				PayableRentalCostBC command  = new PayableRentalCostBCImpl();
				CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

				List<String> listInvNo = new ArrayList();

				// 1. Invoice No. Selection 
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

				// 2. creating AP for each Invoice No. & updating Payable Charge Creation Master Data Update 
				for ( int i = 0 ; i < listInvNo.size() ; i++ ) {
					// setting AP_INV_MAIN
					payableRentalCostVO.setIntLastInvNo(i+1);
					ApPayInvVO apPayInvVO = command.makeOperatingPayableRentalInvoiceCreateMainBasic(listInvNo.get(i), payableRentalCostVO, account);

					// setting AP_INV_DTL
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
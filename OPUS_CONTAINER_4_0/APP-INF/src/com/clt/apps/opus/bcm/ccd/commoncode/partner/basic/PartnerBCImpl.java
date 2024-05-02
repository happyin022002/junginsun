/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : partnerBCImpl.java
*@FileTitle : carrier
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.ccd.commoncode.partner.integration.PartnerDBDAO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CarrierVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CreditCustomerVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustAddrIfVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustCntcPntIfVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerContactVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerIfVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerIntegrationVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerPerformanceIfVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerPerformanceVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.SearchSimilarVendorNameVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VendorClassificationVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VendorContactVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VendorGroupVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VendorIfVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.VndrCntcPntIfVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.CustomsCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCustAddrVO;
//import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerContactVO;

/**
 * OPUS-commoncode Business Logic Command Interface<br>
 * An interface to the business logic for common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class PartnerBCImpl extends BasicCommandSupport implements PartnerBC {
	
	// Database Access Object
	private transient PartnerDBDAO dbDao = null;

	/**
	 * partnerBCImpl object creation<br>
	 * Generate artnerDBDAO.<br>
	 */
	public PartnerBCImpl() {
		dbDao = new PartnerDBDAO();
	}
	/**
	 * Carrier Code retrieve.(BCM_CCD_0034)<br>
	 * 
	 * @param String crrCd
	 * @return CarrierVO
	 * @exception EventException
	 */
	public CarrierVO searchCrrCode(String crrCd) throws EventException {
		CarrierVO carrierVO = null;
		try {
			carrierVO = dbDao.searchCrrCode(crrCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return carrierVO;
	}
	
	/**
	 * Carrier Code retrieve.(BCM_CCD_0034)<br>
	 * 
	 * @param String rqstNo
	 * @return CarrierVO
	 * @exception EventException
	 */
	public CarrierVO searchCrrRqst(String rqstNo) throws EventException {
		CarrierVO carrierVO = null;
		try {
			carrierVO = dbDao.searchCrrRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return carrierVO;
	}
	/**
	 * Modify/save/delete event process<br>
	 * Carrier (BCM_CCD_0034.do)<br>
	 * 
	 * @param CarrierVO crrVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCrrCode(CarrierVO crrVo, SignOnUserAccount account) throws EventException {
		
		try {		
				if(crrVo.getIbflag().equals("U")){
				crrVo.setUpdUsrId(account.getUsr_id());
				   dbDao.modifyCrrCode(crrVo);
				   
				}else if(crrVo.getIbflag().equals("I")){
				 crrVo.setCreUsrId(account.getUsr_id());
				 crrVo.setUpdUsrId(account.getUsr_id());
			
					dbDao.addCrrCode(crrVo);	
			}

			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Carrier (BCM_CCD_0034.do)<br>
	 * 
	 * @param CarrierVO crrVo
	 * @param SignOnUserAccount account
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageCrrRqst(CarrierVO crrVo, SignOnUserAccount account, String rqstNo) throws EventException {
		
		try {
			if(crrVo.getIbflag().equals("U")){
				crrVo.setUpdUsrId(account.getUsr_id());
				dbDao.modifyCrrRqst(crrVo, rqstNo);
			}else if(crrVo.getIbflag().equals("I")){
				crrVo.setCreUsrId(account.getUsr_id());
				crrVo.setUpdUsrId(account.getUsr_id());
				dbDao.addCrrRqst(crrVo, rqstNo);	
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Customer Address retrieve.(BCM_CCD_0036)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception EventException
	 */
	public List<CustomerAddressVO> searchCustAddrCode(String custCntCd, String custSeq, String addrTpCd) throws EventException {
		
		try {
			return dbDao.searchCustAddrCode(custCntCd, custSeq, addrTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Address (BCM_CCD_0036.do)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustAddrCode(CustomerAddressVO[] custAddrVOs, SignOnUserAccount account) throws EventException {

		try {	
			if(custAddrVOs!=null){
				for(int i=0; i < custAddrVOs.length; i++) {
//	                int ld_addr_seq = 0;
					if(custAddrVOs[i].getIbflag().equals("U")){
						custAddrVOs[i].setCreUsrId(account.getUsr_id());
						custAddrVOs[i].setUpdUsrId(account.getUsr_id());
						dbDao.modifyCustAddrCode(custAddrVOs[i]);
			        }else if(custAddrVOs[i].getIbflag().equals("I")){
						custAddrVOs[i].setCreUsrId(account.getUsr_id());
						custAddrVOs[i].setUpdUsrId(account.getUsr_id());
	                    //ADDR_SEQ MAX 가져오기
	                    int ld_addr_seq = searchMAXCustAddrSeq(custAddrVOs[i].getCustCntCd(), custAddrVOs[i].getCustSeq(), custAddrVOs[i].getAddrTpCd());
	                    custAddrVOs[i].setAddrSeq(ld_addr_seq+"");
	                    dbDao.addCustAddrCode(custAddrVOs[i]);
					    // dbDao.addBkgCustAddrCode(custAddrVOs[i]);
			        }else if(custAddrVOs[i].getIbflag().equals("D")){
			        	custAddrVOs[i].setCreUsrId(account.getUsr_id());
						custAddrVOs[i].setUpdUsrId(account.getUsr_id());
			        	custAddrVOs[i].setDeltFlg("Y");
			        	dbDao.removeCustAddrCode(custAddrVOs[i]);
				        //dbDao.removeBkgCustAddrCode(custAddrVOs[i]);
			        }
				}
				manageCustAddrIf(custAddrVOs);	
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Customer Contact Point Code retrieve.(BCM_CCD_0037)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerContactVO>
	 * @exception DAOException
	 */
	public List<CustomerContactVO> searchCustCntcCode(String custCntCd, String custSeq) throws EventException {
		
		try {
			return dbDao.searchCustCntcCode(custCntCd, custSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Contact Point Code (BCM_CCD_0037.do)<br>
	 * 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCntcCode(CustomerContactVO[] customerContractVOs, SignOnUserAccount account) throws EventException {
		
		try {		
            double ld_cust_cntc_pnt_seq = 0;
				
			for(int i=0; i < customerContractVOs.length; i++) {
				if(customerContractVOs[i].getIbflag().equals("U")){
					customerContractVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyCustCntcCode(customerContractVOs[i]);
				}else if(customerContractVOs[i].getIbflag().equals("I")){
					customerContractVOs[i].setCreUsrId(account.getUsr_id());
					customerContractVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addCustCntcCode(customerContractVOs[i]);	
                    //CUST_CNTC_PNT_SEQ MAX 가져오기
					ld_cust_cntc_pnt_seq = searchMAXCustCntcPntSeq(customerContractVOs[i].getCustCntCd(), customerContractVOs[i].getCustSeq());
                    customerContractVOs[i].setCustCntcPntSeq(Double.toString(ld_cust_cntc_pnt_seq));
			    }else if(customerContractVOs[i].getIbflag().equals("D")){
				    dbDao.removeCustCntcCode(customerContractVOs[i]);
			    }
			}
			
			// EAI I/F
			manageCustCntcIf(customerContractVOs);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Customer Coderetrieve.(BCM_CCD_0038)<br>
	 * 
	 * @param String custCd
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustPerfCode(String custCd) throws EventException {
		CustomerPerformanceVO customerPerformanceVO = null;
		try {
			customerPerformanceVO = dbDao.searchCustPerfCode(custCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return customerPerformanceVO;
	}
	
	/**
	 * Customer Coderetrieve.(BCM_CCD_0038)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustPerfRqst(String rqstNo) throws EventException {
		CustomerPerformanceVO customerPerformanceVO = null;
		try {
			customerPerformanceVO = dbDao.searchCustPerfRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return customerPerformanceVO;
	}
	
	/**
	 * Customer Group ID retrieve.(BCM_CCD_0038)<br>
	 * 
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustGrpId() throws EventException {
		CustomerPerformanceVO customerPerformanceVO = null;
		try {
			customerPerformanceVO = dbDao.searchCustGrpId();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return customerPerformanceVO;
	}	
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Performance Group  (BCM_CCD_0038.do)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfCode(CustomerPerformanceVO customerPerformanceVO, SignOnUserAccount account) throws EventException {
		
		try {		
			
				if(customerPerformanceVO.getIbflag().equals("U")){
					customerPerformanceVO.setUpdUsrId(account.getUsr_id());
				   dbDao.modifyCustPerfCode(customerPerformanceVO);
				   
				}else if(customerPerformanceVO.getIbflag().equals("I")){
					customerPerformanceVO.setCreUsrId(account.getUsr_id());
					customerPerformanceVO.setUpdUsrId(account.getUsr_id());
			
					dbDao.addCustPerfCode(customerPerformanceVO);	
				}

				manageCustPerfIf(customerPerformanceVO, account);			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Performance Group  (BCM_CCD_0038.do)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfRqst(CustomerPerformanceVO customerPerformanceVO, String rqstNo, SignOnUserAccount account) throws EventException {
		
		try {		
			
				if(customerPerformanceVO.getIbflag().equals("U")){
					customerPerformanceVO.setUpdUsrId(account.getUsr_id());
				    dbDao.modifyCustPerfRqst(customerPerformanceVO, rqstNo);
				   
				}else if(customerPerformanceVO.getIbflag().equals("I")){
					customerPerformanceVO.setCreUsrId(account.getUsr_id());
					customerPerformanceVO.setUpdUsrId(account.getUsr_id());
			
					dbDao.addCustPerfRqst(customerPerformanceVO, rqstNo);	
			}

			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Credit Customer Code retrieve.(BCM_CCD_0039)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CreditCustomerVO
	 * @exception DAOException
	 */
	public CreditCustomerVO searchCrCustCode(String custCntCd, String custSeq) throws EventException {
		
		try {
			return dbDao.searchCrCustCode(custCntCd, custSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Credit Customer Code Creation (BCM_CCD_0039.do)<br>
	 * 
	 * @param CreditCustomerVO[] creditCustomerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCrCustCode(CreditCustomerVO[] creditCustomerVOs,  SignOnUserAccount account) throws EventException {
		
		try {		
				
			for(int i=0; i < creditCustomerVOs.length; i++) {
				if(creditCustomerVOs[i].getIbflag().equals("I")){
					creditCustomerVOs[i].setCreUsrId(account.getUsr_id());
					creditCustomerVOs[i].setUpdUsrId(account.getUsr_id());
					   dbDao.addCrCustCode(creditCustomerVOs[i]);
					}else if(creditCustomerVOs[i].getIbflag().equals("U")){
						creditCustomerVOs[i].setUpdUsrId(account.getUsr_id());
					   dbDao.modifyCrCustCode(creditCustomerVOs[i]);	
			        }

			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Customer Code retrieve.(BCM_CCD_0035)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustCode(String custCntCd, String custSeq) throws EventException {
		
		try {
			return dbDao.searchCustCode(custCntCd, custSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Country code is generated query.(BCM_CCD_0035)<br>
	 * 
	 * @param String custCntCd
	 * @return 	String 
	 * @exception DAOException
	 */	
	public String searchCustMaxSeq(String custCntCd) throws EventException {
		try {
			return  dbDao.searchCustMaxSeq(custCntCd);
		
		} catch (DAOException ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("COM12240").getUserMessage(),ex);
		}
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Code Creation (BCM_CCD_0035.do)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCode(CustomerIntegrationVO custIntgVO,  SignOnUserAccount account) throws EventException {
		try {
			CustomerVO customerVO = custIntgVO.getCustomerVO();

			if(customerVO.getIbflag().equals("I")){
				customerVO.setCreUsrId(account.getUsr_id());
				customerVO.setUpdUsrId(account.getUsr_id());
				dbDao.addCustCode(customerVO);
			}
			else if(customerVO.getIbflag().equals("U")){
				customerVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyCustCode(customerVO);	
		    }
			
			// EAI I/F
        	manageCustInfoIf(custIntgVO);
			
//            for(int i=0; customerVOs!=null && i < customerVOs.length; i++) {
//				if(customerVOs[i].getIbflag().equals("I")){
//					customerVOs[i].setCreUsrId(account.getUsr_id());
//					customerVOs[i].setUpdUsrId(account.getUsr_id());
//					dbDao.addCustCode(customerVOs[i]);
//				}
//				else if(customerVOs[i].getIbflag().equals("U")){
//					customerVOs[i].setUpdUsrId(account.getUsr_id());
//					dbDao.modifyCustCode(customerVOs[i]);	
//			    }
//				// EAI I/F
//	        	manageCustInfoIf(customerVOs[i]);
//			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * check Legacy Code(SAP ID) (BCM_CCD_0035)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @exception EventException
	 */
	public void isLegacyCodeUnique(CustomerIntegrationVO custIntgVO) throws EventException {
		try {
			CustomerVO customerVO = custIntgVO.getCustomerVO();
			
			if(!dbDao.isLegacyCodeUnique(customerVO)) {
				throw new EventException("Registry Failed : Legacy Code(SAP ID) is not unique.");
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 *  Vendor retrieve.<br>
	 * 
	 * @param String vndrCd
	 * @return VendorGroupVO
	 * @exception EventException
	 */ 
	public VendorGroupVO searchVndrCode(String vndrCd) throws EventException{
		// PODO Auto-generated method stub
		try {							 		
			VendorGroupVO vendorGroupVO = new VendorGroupVO();
			VendorVO vendorVO = new VendorVO();
			List<VendorContactVO> vendorContactVOs = new ArrayList<VendorContactVO>();
			List<VendorClassificationVO> vendorClassificationVOs = new ArrayList<VendorClassificationVO>();
			
			vendorVO =  dbDao.searchVndrCode(vndrCd);
			vendorContactVOs = dbDao.searchVndrCntcCode(vndrCd);
			vendorClassificationVOs = dbDao.searchCntrVndrClss(vndrCd);
			
			vendorGroupVO.setVendorVO(vendorVO);
			vendorGroupVO.setVendorClassificationVOS(vendorClassificationVOs);
			vendorGroupVO.setVendorContactVOS(vendorContactVOs);
			
			return vendorGroupVO;
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Retrieve <br>
	 *  Vendor retrieve.<br>
	 * 
	 * @param String rqstNo
	 * @return VendorGroupVO
	 * @exception EventException
	 */ 
	public VendorGroupVO searchVndrRqst(String rqstNo) throws EventException{
		// PODO Auto-generated method stub
		try {							 		
			VendorGroupVO vendorGroupVO = new VendorGroupVO();
			VendorVO vendorVO = new VendorVO();
			List<VendorContactVO> vendorContactVOs = new ArrayList<VendorContactVO>();
			List<VendorClassificationVO> vendorClassificationVOs = new ArrayList<VendorClassificationVO>();
			
			vendorVO =  dbDao.searchVndrRqst(rqstNo);
			vendorContactVOs = dbDao.searchVndrCntcRqst(rqstNo);
			vendorClassificationVOs = dbDao.searchCntrVndrClssRqst(rqstNo);
			
			vendorGroupVO.setVendorVO(vendorVO);
			vendorGroupVO.setVendorClassificationVOS(vendorClassificationVOs);
			vendorGroupVO.setVendorContactVOS(vendorContactVOs);
			
			return vendorGroupVO;
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BCM_CCD_0040 : Code Creation<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrMaxSeq() throws EventException{
		DBRowSet rowSet = null;
        String max_vndr_seq = "";
        
        try {
            rowSet=dbDao.searchVndrMaxSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		max_vndr_seq = rowSet.getString(1);
            	}
            }
            return max_vndr_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor information save.<br>
	 * 
	 * @param VendorGroupVO vendorGroupVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVndrCode(VendorGroupVO vendorGroupVO, SignOnUserAccount account) throws EventException{
		try{
			VendorVO vendorVO = vendorGroupVO.getVendorVO();
			VendorGroupVO ifVendorGroupVO = new VendorGroupVO();
			VendorContactVO[] vendorContactVOs = vendorGroupVO.getVendorContactVOs();
			VendorClassificationVO[] vendorClassificationVOs = vendorGroupVO.getVendorClassificationVOs();
			
			List<VendorContactVO> createContactVOList = new ArrayList<VendorContactVO>();
			List<VendorContactVO> updateContactVOList = new ArrayList<VendorContactVO>();
			List<VendorContactVO> deleteContactVOList = new ArrayList<VendorContactVO>();
			
			List<VendorClassificationVO> createClassificationVOList = new ArrayList<VendorClassificationVO>();
			List<VendorClassificationVO> updateClassificationVOList = new ArrayList<VendorClassificationVO>();
			List<VendorClassificationVO> deleteClassificationVOList = new ArrayList<VendorClassificationVO>();
			
			/* 2015.09.09 */
			// because of difference on primary key between OPUS(Vendor Sequence) and SAKURA(Vendor Country Code + Vendor Sequence)
			// check country code of vendor office
			// if not same then InsfDvCd 'D' and 'I'
			DBRowSet rowSet = null;
	        String isCntCdChanged = "";
			String oriOfcCd = null;
	        
            rowSet=dbDao.searchIsVndrOfcChanged(vendorVO);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		oriOfcCd = rowSet.getString("ofc_cd");
            		isCntCdChanged = rowSet.getString("is_changed");
            	}
            }
			
			if("I".equals(vendorVO.getIbflag())){
				vendorVO.setCreUsrId(account.getUsr_id());
				vendorVO.setUpdUsrId(account.getUsr_id());
				dbDao.addVndrCode(vendorVO); 
			}else if("U".equals(vendorVO.getIbflag())){
				vendorVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyVndrCode(vendorVO); 
			}

			if(vendorContactVOs != null){
	            double ld_vndr_cntc_pnt_seq = 0;
				for( int i = 0; i < vendorContactVOs.length; i++){
					if("D".equals(vendorContactVOs[i].getIbflag())){
							deleteContactVOList.add(vendorContactVOs[i]);
							dbDao.removeVndrCntcCode(deleteContactVOList); 
					}else if("I".equals(vendorContactVOs[i].getIbflag())){
			            vendorContactVOs[i].setUpdUsrId(account.getUsr_id());
						vendorContactVOs[i].setCreUsrId(account.getUsr_id());
						createContactVOList.add(vendorContactVOs[i]);
						dbDao.addVndrCntcCode(vendorContactVOs[i]); 
						//VNDR_CNTC_PNT_SEQ MAX 가져오기
			            ld_vndr_cntc_pnt_seq = searchMaxVndrCntcPntSeq(vendorVO.getVndrSeq());
						vendorContactVOs[i].setVndrCntcPntSeq(Double.toString(ld_vndr_cntc_pnt_seq));
					}else if("U".equals(vendorContactVOs[i].getIbflag())){
						vendorContactVOs[i].setUpdUsrId(account.getUsr_id());
						updateContactVOList.add(vendorContactVOs[i]);
						dbDao.modifyVndrCntcCode(updateContactVOList);
					}
				}
				ifVendorGroupVO.setVendorContactVOs(vendorContactVOs);
			}
			
			if(vendorClassificationVOs != null){
				for( int i = 0; i < vendorClassificationVOs.length; i++){
					if("D".equals(vendorClassificationVOs[i].getIbflag())){
						deleteClassificationVOList.add(vendorClassificationVOs[i]);
					}else if("I".equals(vendorClassificationVOs[i].getIbflag())){
			            vendorClassificationVOs[i].setCreUsrId(account.getUsr_id());
						vendorClassificationVOs[i].setUpdUsrId(account.getUsr_id());
						createClassificationVOList.add(vendorClassificationVOs[i]);
					}else if("U".equals(vendorClassificationVOs[i].getIbflag())){
						vendorClassificationVOs[i].setUpdUsrId(account.getUsr_id());
						updateClassificationVOList.add(vendorClassificationVOs[i]);
					}
				}
			}

			if(deleteClassificationVOList.size() > 0 ){
				dbDao.removeCntrVndrClss(deleteClassificationVOList);
			}
			if(createClassificationVOList.size() > 0 ){
				dbDao.addCntrVndrClss(createClassificationVOList);
			}
			if(updateClassificationVOList.size() > 0 ){
				dbDao.modifyCntrVndrClss(updateClassificationVOList);
			}
			
			//EAI I/F
			manageVndrInfoIf(vendorVO, ifVendorGroupVO.getVendorContactVOs(), account, oriOfcCd, isCntCdChanged);
			
			/*
			 * [VENDOR] add TPB Customer Code
			 */
			log.debug("\n vendorVO.getRfndPsdoCustCd().indexOf(TB) ::"+vendorVO.getRfndPsdoCustCd().indexOf("TB"));
			if(vendorVO.getRfndPsdoCustCd().indexOf("TB") > -1){
//			if("TB".equals(vendorVO.getRfndPsdoCustCd())){
				CustomerVO checkCustomerVO =  dbDao.searchCustCode("TB", vendorVO.getVndrSeq());
				//erp 에 i/f 시 opcd 를 맞추기 위해
				if(checkCustomerVO==null){
					vendorVO.setIbflag("I");
				} else {
					vendorVO.setIbflag("U");
					
				}
				vendorVO.setCreUsrId(account.getUsr_id());
				vendorVO.setUpdUsrId(account.getUsr_id());
				mergeMdmCustFrmVndr(vendorGroupVO); //insert MDM_CUSTOMER & erp i/f
				mergeMdmCustAddrFrmVndr(vendorVO); //insert  MDM_CUST_ADDR & erp i/f
				
			} else if(vendorVO.getRfndPsdoCustCd().indexOf("TB") > -1 ){ //삭제처리
				vendorVO.setCreUsrId(account.getUsr_id());
				vendorVO.setUpdUsrId(account.getUsr_id());
				vendorVO.setIbflag("D");
				mergeMdmCustFrmVndr(vendorGroupVO); //merge MDM_CUSTOMER & erp i/f
				mergeMdmCustAddrFrmVndr(vendorVO); //merge  MDM_CUST_ADDR & erp i/f
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor information save.<br>
	 * 
	 * @param VendorGroupVO vendorGroupVO
	 * @param SignOnUserAccount account
	 * @param String max_vndr_seq
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageVndrRqst(VendorGroupVO vendorGroupVO, SignOnUserAccount account, String max_vndr_seq, String rqstNo) throws EventException{
		try{
			VendorVO vendorVO = vendorGroupVO.getVendorVO();
			VendorGroupVO ifVendorGroupVO = new VendorGroupVO();
			VendorContactVO[] vendorContactVOs = vendorGroupVO.getVendorContactVOs();
			VendorClassificationVO[] vendorClassificationVOs = vendorGroupVO.getVendorClassificationVOs();
			
			List<VendorContactVO> createContactVOList = new ArrayList<VendorContactVO>();
			
			List<VendorClassificationVO> createClassificationVOList = new ArrayList<VendorClassificationVO>();
			
			/* 2015.09.09 */
			// because of difference on primary key between OPUS(Vendor Sequence) and SAKURA(Vendor Country Code + Vendor Sequence)
			// check country code of vendor office
			// if not same then InsfDvCd 'D' and 'I'
			DBRowSet rowSet = null;
	        String isCntCdChanged = "";
			String oriOfcCd = null;
	        
            rowSet=dbDao.searchIsVndrOfcChanged(vendorVO);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		oriOfcCd = rowSet.getString("ofc_cd");
            		isCntCdChanged = rowSet.getString("is_changed");
            	}
            }
			
			vendorVO.setCreUsrId(account.getUsr_id());
			vendorVO.setUpdUsrId(account.getUsr_id());
			vendorVO.setVndrSeq(max_vndr_seq);
			// 2014.12.16 It's a VO retrieved from DB, not delivered from UI
			vendorVO.setIbflag("I");
			dbDao.addVndrCode(vendorVO);
			dbDao.modifyVndrRqst(vendorVO, rqstNo);
			
			if(vendorContactVOs != null){
	            double ld_vndr_cntc_pnt_seq = 0;
				for( int i = 0; i < vendorContactVOs.length; i++){
					vendorContactVOs[i].setVndrSeq(max_vndr_seq);
					vendorContactVOs[i].setUpdUsrId(account.getUsr_id());
					vendorContactVOs[i].setCreUsrId(account.getUsr_id());
					createContactVOList.add(vendorContactVOs[i]);
					dbDao.addVndrCntcCode(vendorContactVOs[i]); 
					//VNDR_CNTC_PNT_SEQ MAX 가져오기
		            ld_vndr_cntc_pnt_seq = searchMaxVndrCntcPntSeq(vendorVO.getVndrSeq());
					vendorContactVOs[i].setVndrCntcPntSeq(Double.toString(ld_vndr_cntc_pnt_seq));
				}
				ifVendorGroupVO.setVendorContactVOs(vendorContactVOs);
			}
			
			if(vendorClassificationVOs != null){
				for( int i = 0; i < vendorClassificationVOs.length; i++){
					vendorClassificationVOs[i].setVndrSeq(max_vndr_seq);
					vendorClassificationVOs[i].setCreUsrId(account.getUsr_id());
					vendorClassificationVOs[i].setUpdUsrId(account.getUsr_id());
					createClassificationVOList.add(vendorClassificationVOs[i]);
				}
			}
			
			// 2015.01.06 ADD TPB Customer ///////
			// set Customer VO, Customer Address VO
			
			// add TPB Customer
			
			// add TPB Customer Address
			
			//////////////////////////////////////
			
			if(createClassificationVOList.size() > 0 ){
				dbDao.addCntrVndrClss(createClassificationVOList);
			}
			
			//I/F 추가
			manageVndrInfoIf(vendorVO, ifVendorGroupVO.getVendorContactVOs(), account, oriOfcCd, isCntCdChanged);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor information save.<br>
	 * 
	 * @param VendorGroupVO vendorGroupVO
	 * @param String rqstNo
	 * @param String ibFlag
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVndrRqst(VendorGroupVO vendorGroupVO, String rqstNo, String ibFlag, SignOnUserAccount account) throws EventException{
		try{
			VendorVO vendorVO = vendorGroupVO.getVendorVO();
			VendorContactVO[] vendorContactVOs = vendorGroupVO.getVendorContactVOs();
			VendorClassificationVO[] vendorClassificationVOs = vendorGroupVO.getVendorClassificationVOs();
			
			List<VendorContactVO> createContactVOList = new ArrayList<VendorContactVO>();
			List<VendorContactVO> updateContactVOList = new ArrayList<VendorContactVO>();
			List<VendorContactVO> deleteContactVOList = new ArrayList<VendorContactVO>();
			
			List<VendorClassificationVO> createClassificationVOList = new ArrayList<VendorClassificationVO>();
			List<VendorClassificationVO> updateClassificationVOList = new ArrayList<VendorClassificationVO>();
			List<VendorClassificationVO> deleteClassificationVOList = new ArrayList<VendorClassificationVO>();
			
			if("U".equals(ibFlag)) {
				vendorVO.setIbflag("U");
			}
			
			if("I".equals(vendorVO.getIbflag())){
				vendorVO.setCreUsrId(account.getUsr_id());
				vendorVO.setUpdUsrId(account.getUsr_id());
				dbDao.addVndrRqst(vendorVO, rqstNo); 
			}else if("U".equals(vendorVO.getIbflag())){
				vendorVO.setUpdUsrId(account.getUsr_id());
				vendorVO.setVndrSeq("1");
				dbDao.modifyVndrRqst(vendorVO, rqstNo); 
			}
			
			if(vendorContactVOs != null){
				for( int i = 0; i < vendorContactVOs.length; i++){
					if("D".equals(vendorContactVOs[i].getIbflag())){
						vendorContactVOs[i].setRqstNo(rqstNo);
						deleteContactVOList.add(vendorContactVOs[i]);
						dbDao.removeVndrCntcRqst(deleteContactVOList); 
					}else if("I".equals(vendorContactVOs[i].getIbflag())){
						vendorContactVOs[i].setRqstNo(rqstNo);
						vendorContactVOs[i].setUpdUsrId(account.getUsr_id());
						vendorContactVOs[i].setCreUsrId(account.getUsr_id());
						createContactVOList.add(vendorContactVOs[i]);
						dbDao.addVndrCntcRqst(vendorContactVOs[i]); 
					}else if("U".equals(vendorContactVOs[i].getIbflag())){
						vendorContactVOs[i].setRqstNo(rqstNo);
						vendorContactVOs[i].setUpdUsrId(account.getUsr_id());
						updateContactVOList.add(vendorContactVOs[i]);
						dbDao.modifyVndrCntcRqst(updateContactVOList);
					}
				}
			}
			
			if(vendorClassificationVOs != null){
				for( int i = 0; i < vendorClassificationVOs.length; i++){
					vendorClassificationVOs[i].setRqstNo(rqstNo);
					if("D".equals(vendorClassificationVOs[i].getIbflag())){
						deleteClassificationVOList.add(vendorClassificationVOs[i]);
					}else if("I".equals(vendorClassificationVOs[i].getIbflag())){
						vendorClassificationVOs[i].setCreUsrId(account.getUsr_id());
						vendorClassificationVOs[i].setUpdUsrId(account.getUsr_id());
						createClassificationVOList.add(vendorClassificationVOs[i]);
					}else if("U".equals(vendorClassificationVOs[i].getIbflag())){
						vendorClassificationVOs[i].setUpdUsrId(account.getUsr_id());
						updateClassificationVOList.add(vendorClassificationVOs[i]);
					}
				}
			}

			if(deleteClassificationVOList.size() > 0 ){
				dbDao.removeCntrVndrClssRqst(deleteClassificationVOList);
			}
			if(createClassificationVOList.size() > 0 ){
				dbDao.addCntrVndrClssRqst(createClassificationVOList);
			}
			if(updateClassificationVOList.size() > 0 ){
				dbDao.modifyCntrVndrClssRqst(updateClassificationVOList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * BCM_CCD_1040 : Retrieve <br>
	 * Vendor Name, to look similar to the registered.<br>
	 * 
	 * @param SearchSimilarVendorNameVO searchSimilarVendorNameVO
	 * @return List<SearchSimilarVendorNameVO>
	 * @exception EventException
	 */ 
	public List<SearchSimilarVendorNameVO> searchSimilarVendorName(SearchSimilarVendorNameVO searchSimilarVendorNameVO) throws EventException{
		try {							 		
			return dbDao.searchSimilarVendorName(searchSimilarVendorNameVO);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * ESM_SAM_0900 : SAVE <br>
	 * Srep_flg save.<br>
	 * @param CustomsCustomerVO customsCustomerVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageSrepByCust(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account) throws EventException {
		try{
			customsCustomerVO.setUserId(account.getUsr_id());
			dbDao.modifySrepPrmryFlg(customsCustomerVO);
		
		} catch(DAOException ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }
	}
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Changing Customer information<br><br>
	 * 
	 * @param SearchCustomerVO[] searchCustomerVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageCustomerInfo(SearchCustomerVO[] searchCustomerVOS, SignOnUserAccount account) throws EventException {
		try{
			List<SearchCustomerVO> updateVoList = new ArrayList<SearchCustomerVO>();
			List<SearchCustomerVO> insertVoList = new ArrayList<SearchCustomerVO>();

			for(int i=0; i<searchCustomerVOS.length; i++){
					searchCustomerVOS[i].setUserId(account.getUsr_id());
					searchCustomerVOS[i].setUpdUsrId(account.getUsr_id());	
					updateVoList.add(searchCustomerVOS[i]);
					insertVoList.add(searchCustomerVOS[i]);
					
				if("0010".equals(searchCustomerVOS[i].getOpnPg())){						
					searchCustomerVOS[i].setUserId(account.getUsr_id());
					updateVoList.add(searchCustomerVOS[i]);
					dbDao.modifyCustomerGroupId(updateVoList);
				}else{							
					dbDao.modifyCustomerInfoCust(updateVoList);
					dbDao.insertCustomerInfoCustCntcPnt(insertVoList);
//					dbDao.modifyMoreInfoCustCntcPnt(updateVoList);
					dbDao.modifyCustomerInfoCustAddr(updateVoList);
				}
			}

		} catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Modify/save/delete Address information <br><br>
	 * 
	 * @param MdmCustAddrVO[] mdmCustAddrVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustomerAddressInfo(MdmCustAddrVO[] mdmCustAddrVOS, SignOnUserAccount account) throws EventException {
		try{
			List<MdmCustAddrVO> insertVoList = new ArrayList<MdmCustAddrVO>();
			List<MdmCustAddrVO> updateVoList = new ArrayList<MdmCustAddrVO>();
			List<MdmCustAddrVO> deleteVoList = new ArrayList<MdmCustAddrVO>();

			for(int i=0; i<mdmCustAddrVOS.length; i++){
				if(mdmCustAddrVOS[i].getIbflag().equals("I")){
					mdmCustAddrVOS[i].setUpdUsrId(account.getUsr_id());
					mdmCustAddrVOS[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(mdmCustAddrVOS[i]);
				}
				if ( mdmCustAddrVOS[i].getIbflag().equals("U")){
					mdmCustAddrVOS[i].setUpdUsrId(account.getUsr_id());
					mdmCustAddrVOS[i].setCreUsrId(account.getUsr_id());
					updateVoList.add(mdmCustAddrVOS[i]);
				}
				if ( mdmCustAddrVOS[i].getIbflag().equals("D")){
					mdmCustAddrVOS[i].setUpdUsrId(account.getUsr_id());
					mdmCustAddrVOS[i].setCreUsrId(account.getUsr_id());
					deleteVoList.add(mdmCustAddrVOS[i]);
				}
			}
			if(insertVoList.size() > 0){
					dbDao.addCustomerAddrInfo(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyCustomerAddrInfo(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeCustomerAddrInfo(deleteVoList);
			}

		} catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Changing Coverage Team information<br><br>
	 * 
	 * @param CustCoverTeamVO[] CustCoverTeamVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCoverInfo(CustCoverTeamVO[] CustCoverTeamVOS, SignOnUserAccount account) throws EventException {
		
		try{
			int seq = 0;
			for(int i = 0 ; i < CustCoverTeamVOS.length ; i++){
				if("Y".equals(CustCoverTeamVOS[i].getSrepPrmryFlg()) ){
					seq = i;
					List<CustCoverTeamVO> updateVoList = new ArrayList<CustCoverTeamVO>();
					CustCoverTeamVOS[seq].setUserId(account.getUsr_id());
					updateVoList.add(CustCoverTeamVOS[seq]);

					dbDao.modifyCustCoverInfo(updateVoList);

				}
			}
		}
		catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0002 : Save<br>
	 * Changing More Info<br><br>
	 * 
	 * @param MoreInfoVO[] moreInfoVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMoreInfo(MoreInfoVO[] moreInfoVOS, SignOnUserAccount account) throws EventException {
		
		try{
			List<MoreInfoVO> updateVoList = new ArrayList<MoreInfoVO>();

			for(int i=0; i<moreInfoVOS.length; i++){
				moreInfoVOS[i].setUserId(account.getUsr_id());
					updateVoList.add(moreInfoVOS[i]);
			}
				dbDao.modifyMoreInfoCust(updateVoList);
				dbDao.modifyMoreInfoCrCust(updateVoList);
				dbDao.modifyMoreInfoCustCntcPnt(updateVoList);
		}
		catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
//	/**
//	 * ESM_SAM_0002 : Save<br>
//	 * Changing More Info<br><br>
//	 * 
//	 * @param SearchCustomerVO[] searchCustomerVOS, SignOnUserAccount account
//	 * @return void
//	 * @exception EventException
//	 */
//	
//	public void manageCustomerBySAM(SearchCustomerVO[] searchCustomerVOS, SignOnUserAccount account) throws EventException {
//		
//		try{
//			List<SearchCustomerVO> updateVoList = new ArrayList<SearchCustomerVO>();
//			List<SearchCustomerVO> insertVoList = new ArrayList<SearchCustomerVO>();
//
//			for(int i=0; i<searchCustomerVOS.length; i++){
//					searchCustomerVOS[i].setUserId(account.getUsr_id());
//					updateVoList.add(searchCustomerVOS[i]);
//					insertVoList.add(searchCustomerVOS[i]);
//			}
//				dbDao.modifyCustomerInfoCust(updateVoList);
//				dbDao.insertCustomerInfoCustCntcPnt(insertVoList);
//				dbDao.modifyCustomerInfoCustAddr(updateVoList);
//				
//		}
//		catch(DAOException ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler(ex).getMessage());
//        } catch (Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            throw new EventException(new ErrorHandler(ex).getMessage());
//        }
//	}
	
	/**
	 * Customer Name, to look similar to the registered .(BCM_CCD_1035)<br>
	 * 
	 * @param String custCntCd
	 * @param String custNm
	 * @param String locCd
	 * @param String custRgstNo
	 * @param String matchRule
	 * @return List<CustomerVO>
	 * @exception DAOException
	 */
	public List<CustomerVO> searchCustomerListByName(String custCntCd, String custNm, String locCd , String custRgstNo, String matchRule) throws EventException {
		
		try {
			return dbDao.searchCustomerListByName(custCntCd, custNm, locCd, custRgstNo, matchRule);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}

	/**
	 * BCM_CCD_1038 : Retrieve<br>
	 * 
	 * Customer Group Duplicate check query event process<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @return List<CustomerPerformanceVO>
	 * @exception EventException
	 */
	public List<CustomerPerformanceVO> searchCustGrpList(CustomerPerformanceVO customerPerformanceVO) throws EventException {
        List<CustomerPerformanceVO> list = null;
        
        try {
        	list   = dbDao.searchCustGrpList(customerPerformanceVO);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
		return list;
	}
	
	
	/**
	 * Customer Integration Request Info retrieve.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerIntegrationVO
	 * @exception DAOException
	 */
	public CustomerIntegrationVO searchCustIntgRqst(String rqstNo) throws EventException {
		CustomerIntegrationVO vo = null;
		try {
			vo = new CustomerIntegrationVO();
			
			vo.setCustomerVO(dbDao.searchCustRqst(rqstNo));
			vo.setCustomerAddressVOS(dbDao.searchCustAddrRqst(rqstNo));
			vo.setCustomerContactVOS(dbDao.searchCustCntcRqst(rqstNo));
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return vo;
	}
	
	/**
	 * Customer Request Info retrieve.(BCM_CCD_0035)<br>
	 * 
	 * @param String rqstNo
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustRqst(String rqstNo) throws EventException {
		
		try {
			return dbDao.searchCustRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Customer Address Request Info retrieve.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return List<CustomerAddressVO>
	 * @exception DAOException
	 */
	public List<CustomerAddressVO> searchCustAddrRqst(String rqstNo) throws EventException {
		
		try {
			return dbDao.searchCustAddrRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Customer Request Info modify.
	 * 
	 * @param CustomerVO[] customerVOs
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustRqst(CustomerVO[] customerVOs, String rqstNo, SignOnUserAccount account) throws EventException {
		// 파라메터 객체 변환
		try {
			for(int i=0; i < customerVOs.length; i++) {
				if(customerVOs[i].getIbflag().equals("I")){
					customerVOs[i].setCreUsrId(account.getUsr_id());
					customerVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addCustRqst(customerVOs[i], rqstNo);
					dbDao.addCustAddrRqst(customerVOs[i], rqstNo);
				} else if(customerVOs[i].getIbflag().equals("U")){
					customerVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyCustRqst(customerVOs[i], rqstNo);	
					dbDao.modifyCustAddrRqst(customerVOs[i], rqstNo);
		        }
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * @param CustomerVO[] customerVOs
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageCustRqstI(CustomerVO[] customerVOs, String rqstNo, SignOnUserAccount account) throws EventException {
		try {
			log.debug("\n\n @@ manageCustRqstI -customerVOs.lg: "+ (customerVOs!=null?customerVOs.length:0) +"<<<<<<\n\n");
			for(int i=0; customerVOs!=null && i < customerVOs.length; i++) {
				log.debug("\n customerVOs["+i+"]: "+customerVOs[i].getIbflag()+" \n");
				if(customerVOs[i].getIbflag().equals("I")){
					customerVOs[i].setCreUsrId(account.getUsr_id());
					customerVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addCustRqst(customerVOs[i], rqstNo);
				} else if(customerVOs[i].getIbflag().equals("U")){
					customerVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyCustRqst(customerVOs[i], rqstNo);
		        }
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Request Info modify.
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param String custCntCd
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void manageCustAddrRqstI(CustomerAddressVO[] custAddrVOs, String custCntCd, String rqstNo, SignOnUserAccount account) throws EventException {
		try {
			log.debug("\n\n @@ manageCustAddrRqstI -custAddrVOs.lg: "+ (custAddrVOs!=null?custAddrVOs.length:0) +"<<<<<<\n\n");
			for(int i=0; custAddrVOs!=null && i < custAddrVOs.length; i++) {
				log.debug("\n custAddrVOs["+i+"]: "+custAddrVOs[i].getIbflag()+" \n");
				if(custAddrVOs[i].getIbflag().equals("I")){
					custAddrVOs[i].setCreUsrId(account.getUsr_id());
					custAddrVOs[i].setUpdUsrId(account.getUsr_id());
					custAddrVOs[i].setCustCntCd(custCntCd);
					dbDao.addCustAddrRqst2(custAddrVOs[i], rqstNo);
				} else if(custAddrVOs[i].getIbflag().equals("U")){
					custAddrVOs[i].setUpdUsrId(account.getUsr_id());
					custAddrVOs[i].setCustCntCd(custCntCd);
					dbDao.modifyCustAddrRqst(custAddrVOs[i], rqstNo);
		        } else if(custAddrVOs[i].getIbflag().equals("D")){
		        	dbDao.removeCustAddrRqst(custAddrVOs[i], rqstNo);
		        }
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	/**
	 * CNTC PNT 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustCntcPntRqst(CustomerContactVO[] customerContractVOs, String rqstNo, SignOnUserAccount account) throws EventException {
		try {
			log.debug("\n\n @@ manageCustRqst -customerVOs.lg: "+ (customerContractVOs!=null?customerContractVOs.length:0) +"<<<<<<\n\n");
			for(int i=0; customerContractVOs!=null && i < customerContractVOs.length; i++) {
				log.debug("\n customerContractVOs["+i+"]: "+customerContractVOs[i].getIbflag()+" \n");
				if(customerContractVOs[i].getIbflag().equals("I")){
					customerContractVOs[i].setCreUsrId(account.getUsr_id());
					customerContractVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addCustCntcPntRqst(customerContractVOs[i], rqstNo);
				} else if(customerContractVOs[i].getIbflag().equals("U")){
					customerContractVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyCustCntcPntRqst(customerContractVOs[i], rqstNo);
		        } else if(customerContractVOs[i].getIbflag().equals("D")){
		        	dbDao.removeCustCntcPntRqst(customerContractVOs[i], rqstNo);
		        }
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Modify/delete event process, Save For EAI I/F process<br>
	 * Customer Info (BCM_CCD_0052.do)<br>
	 * 
	 * @param CustomerIntegrationVO customerIntgVO
	 * @exception EventException
	 */
	public void manageCustInfoIf(CustomerIntegrationVO customerIntgVO) throws EventException {

		try {
			CustomerVO customerVO = customerIntgVO.getCustomerVO();
			CustomerAddressVO[] customerAddressVOArr = customerIntgVO.getCustomerAddressVOs();
			CustomerContactVO[] customerContactVOArr = customerIntgVO.getCustomerContactVOs();
			CustomerIfVO customerifVO = new CustomerIfVO();

			String cust_if_seq = "";
			
			//CUST_IF_SEQ 채번
			cust_if_seq = searchCustIfSeq();
			customerifVO.setCustIfSeq(cust_if_seq);
			
			customerifVO.setCustCntCd(customerVO.getCustCntCd());
			customerifVO.setCustSeq(customerVO.getCustSeq());
			customerifVO.setCustGrpId(customerVO.getCustGrpId());
			customerifVO.setCustLglEngNm(customerVO.getCustLglEngNm());
			customerifVO.setCustLoclLangNm(customerVO.getCustLoclLangNm());
			customerifVO.setCustAbbrNm(customerVO.getCustAbbrNm());
			customerifVO.setCntrCustTpCd(customerVO.getCntrCustTpCd());
			customerifVO.setIndivCorpDivCd(customerVO.getIndivCorpDivCd());
			customerifVO.setOfcCd(customerVO.getOfcCd());
			customerifVO.setFndtDt(customerVO.getFndtDt());
			customerifVO.setCustRgstNo(customerVO.getCustRgstNo());
			customerifVO.setFincStsLvlCd(customerVO.getFincStsLvlCd());
			customerifVO.setLocCd(customerVO.getLocCd());
			customerifVO.setCapiCurrCd(customerVO.getCapiCurrCd());
			customerifVO.setCapiAmt(customerVO.getCapiAmt());
			customerifVO.setLstkFlg(customerVO.getLstkFlg());
			customerifVO.setEmpeKnt(customerVO.getEmpeKnt());
			customerifVO.setVndrSeq(customerVO.getVndrSeq());
			customerifVO.setCustRmk(customerVO.getCustRmk());
			customerifVO.setVbsClssCd(customerVO.getVbsClssCd());
			customerifVO.setNbsClssCd1(customerVO.getNbsClssCd1());
			customerifVO.setNbsClssCd2(customerVO.getNbsClssCd2());
			customerifVO.setNbsClssCd3(customerVO.getNbsClssCd3());
			customerifVO.setNvoccCoScacCd(customerVO.getNvoccCoScacCd());
			customerifVO.setNvoccBdNo(customerVO.getNvoccBdNo());
			customerifVO.setNvoccLicNo(customerVO.getNvoccLicNo());
			customerifVO.setNvoccBdAmt(customerVO.getNvoccBdAmt());
			customerifVO.setNvoccBdStEffDt(customerVO.getNvoccBdStEffDt());
			customerifVO.setNvoccBdEndEffDt(customerVO.getNvoccBdEndEffDt());
			customerifVO.setIndusDesc(customerVO.getIndusDesc());
			customerifVO.setCrntVolKnt(customerVO.getCrntVolKnt());
			customerifVO.setCmptDesc(customerVO.getCmptDesc());
			customerifVO.setSpclReqDesc(customerVO.getSpclReqDesc());
			customerifVO.setPrfSvcDesc(customerVO.getPrfSvcDesc());
			customerifVO.setPrfSvcDtlDesc(customerVO.getPrfSvcDtlDesc());
			customerifVO.setPrfGrpCmdtCd(customerVO.getPrfGrpCmdtCd());
			customerifVO.setPrfCntrTpszCd(customerVO.getPrfCntrTpszCd());
			customerifVO.setPrfRepCmdtCd(customerVO.getPrfRepCmdtCd());
			customerifVO.setSrepCd(customerVO.getSrepCd());
			customerifVO.setCtsNo(customerVO.getCtsNo());
			customerifVO.setFrtFwrdFmcNo(customerVO.getFrtFwrdFmcNo());
			customerifVO.setKeyAcctFlg(customerVO.getKeyAcctFlg());
			customerifVO.setKeyAcctStEffDt(customerVO.getKeyAcctStEffDt());
			customerifVO.setKeyAcctEndEffDt(customerVO.getKeyAcctEndEffDt());
			customerifVO.setSubsCoCd(customerVO.getSubsCoCd());
			customerifVO.setKeyAcctMgrUsrId(customerVO.getKeyAcctMgrUsrId());
			customerifVO.setKeyAcctMgrUsrNm(customerVO.getKeyAcctMgrUsrNm());
			customerifVO.setSlsDeltEffDt(customerVO.getSlsDeltEffDt());
			customerifVO.setNmdCustFlg(customerVO.getNmdCustFlg());
			customerifVO.setMltTrdAcctFlg(customerVO.getMltTrdAcctFlg());
			customerifVO.setCustDivCd(customerVO.getCustDivCd());
			customerifVO.setModiCustCd(customerVO.getModiCustCd());
			customerifVO.setRailRoadPrioFlg(customerVO.getRailRoadPrioFlg());
			customerifVO.setModiCustCd2(customerVO.getModiCustCd2());
			
			// customer address information
			if(customerAddressVOArr != null) {
				for(int i=0;i<customerAddressVOArr.length;i++) {
					// set only primary address
					if("Y".equalsIgnoreCase(customerAddressVOArr[i].getPrmryChkFlg())) { 
						customerifVO.setAddrTpCd(customerAddressVOArr[i].getAddrTpCd()); //ADDR_TP_CD
						customerifVO.setAddrSeq(customerAddressVOArr[i].getAddrSeq()); //ADDR_SEQ
						customerifVO.setPrmryChkFlg(customerAddressVOArr[i].getPrmryChkFlg()); //PRMRY_CHK_FLG
						customerifVO.setBzetNm(customerAddressVOArr[i].getBzetNm());//BZET_NM
						customerifVO.setBzetAddr(customerAddressVOArr[i].getBzetAddr()); //BZET_ADDR
						customerifVO.setCtyNm(customerAddressVOArr[i].getCtyNm()); //CTY_NM
						customerifVO.setSteCd(customerAddressVOArr[i].getSteCd()); //STE_CD
						customerifVO.setZipCd(customerAddressVOArr[i].getZipCd()); //ZIP_CD
						customerifVO.setCntcEml(customerAddressVOArr[i].getCntcEml()); //CNTC_EML
						customerifVO.setCntcPsonNm(customerAddressVOArr[i].getCntcPsonNm()); //CNTC_PSON_NM
						customerifVO.setBzetRmk(customerAddressVOArr[i].getBzetRmk()); //BZET_RMK
						customerifVO.setLoclAddr1(customerAddressVOArr[i].getLoclAddr1()); //LOCL_ADDR1
						customerifVO.setLoclAddr2(customerAddressVOArr[i].getLoclAddr2()); //LOCL_ADDR2
						customerifVO.setLoclAddr3(customerAddressVOArr[i].getLoclAddr3()); //LOCL_ADDR3
						customerifVO.setLoclAddr4(customerAddressVOArr[i].getLoclAddr4()); //LOCL_ADDR4
						customerifVO.setCntCd(customerAddressVOArr[i].getCntCd()); //CNT_CD
						break;
					}
				}
			}

			// customer contact point information
			if(customerContactVOArr != null) {
				for(int i=0;i<customerContactVOArr.length;i++) {
					// set only sequential number 1 in case of Customer
					// set just one in case of Vendor TPB Customer
//					if("1".equals(customerContactVOArr[i].getCustCntcPntSeq()) || i == (customerContactVOArr.length - 1)) {
					if("1".equals(customerContactVOArr[i].getPrmryChkFlg()) || "Y".equals(customerContactVOArr[i].getPrmryChkFlg())) {
						customerifVO.setCustCntcPntSeq(customerContactVOArr[i].getCustCntcPntSeq()); //CUST_CNTC_PNT_SEQ
						customerifVO.setCustEml(customerContactVOArr[i].getCustEml()); //CUST_EML
						customerifVO.setCustUrl(customerContactVOArr[i].getCustUrl()); //CUST_URL
						customerifVO.setIntlPhnNo(customerContactVOArr[i].getIntlPhnNo()); //INTL_PHN_NO
						customerifVO.setPhnNo(customerContactVOArr[i].getPhnNo()); //PHN_NO
						customerifVO.setIntlFaxNo(customerContactVOArr[i].getIntlFaxNo()); //INTL_FAX_NO
						customerifVO.setFaxNo(customerContactVOArr[i].getFaxNo()); //FAX_NO
						break;
					}
				}
			}

			customerifVO.setCreUsrId(customerVO.getCreUsrId());
			customerifVO.setUpdUsrId(customerVO.getUpdUsrId());
			customerifVO.setDeltFlg(customerVO.getDeltFlg());

			customerifVO.setR3InsfId("OPR307");
			customerifVO.setEcomInsfId("OPECOM01");
			if("Y".equals(customerVO.getEdiIfFlg())||"Y".equals(customerVO.getDeltFlg())){
				customerifVO.setOpediInsfId("OPEDI05");
			}else{
				customerifVO.setOpediInsfId("");
			}
			
			if(customerVO.getIbflag().equals("I")){
				customerifVO.setR3InsfDvCd("I");
				customerifVO.setEcomInsfDvCd("I");
				customerifVO.setOpediInsfDvCd("I");
			}else if(customerVO.getIbflag().equals("U")){
				if(customerVO.getDeltFlg().equals("Y")){
					customerifVO.setR3InsfDvCd("D");
					customerifVO.setEcomInsfDvCd("D");
					customerifVO.setOpediInsfDvCd("D");
				}else {
					customerifVO.setR3InsfDvCd("U");
					customerifVO.setEcomInsfDvCd("U");
					customerifVO.setOpediInsfDvCd("U");
				}
			}else if(customerVO.getIbflag().equals("D")){
				customerifVO.setR3InsfDvCd("D");
				customerifVO.setEcomInsfDvCd("D");
				customerifVO.setOpediInsfDvCd("D");
			}

			dbDao.addCustInfoIf(customerifVO);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Address Modify/delete event process, Save For EAI I/F process<br>
	 * Customer Address (BCM_CCD_0052.do)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @exception EventException
	 */
	public void manageCustAddrIf(CustomerAddressVO[] custAddrVOs) throws EventException {

		try {	
			CustAddrIfVO custaddrifVO = new CustAddrIfVO();

			String cust_addr_if_seq = "";
			
			for(int i=0; custAddrVOs!=null && i < custAddrVOs.length; i++) {
				if(custAddrVOs[i].getIbflag().equals("U")||custAddrVOs[i].getIbflag().equals("D")||custAddrVOs[i].getIbflag().equals("I")){
					//CUST_ADDR_IF_SEQ 채번
					cust_addr_if_seq = searchCustAddrIfSeq();
					custaddrifVO.setCustAddrIfSeq(cust_addr_if_seq);
					
					custaddrifVO.setCustCntCd(custAddrVOs[i].getCustCntCd());
					custaddrifVO.setCustSeq(custAddrVOs[i].getCustSeq());
					custaddrifVO.setAddrTpCd(custAddrVOs[i].getAddrTpCd());
					custaddrifVO.setAddrSeq(custAddrVOs[i].getAddrSeq());
					custaddrifVO.setPrmryChkFlg(custAddrVOs[i].getPrmryChkFlg());
					custaddrifVO.setBzetNm(custAddrVOs[i].getBzetNm());
					custaddrifVO.setBzetAddr(custAddrVOs[i].getBzetAddr());
					custaddrifVO.setCtyNm(custAddrVOs[i].getCtyNm());
					custaddrifVO.setSteCd(custAddrVOs[i].getSteCd());
					custaddrifVO.setZipCd(custAddrVOs[i].getZipCd());
					custaddrifVO.setCntcEml(custAddrVOs[i].getCntcEml());
					custaddrifVO.setCntcPsonNm(custAddrVOs[i].getCntcPsonNm());
					custaddrifVO.setBzetRmk(custAddrVOs[i].getBzetRmk());
					custaddrifVO.setLoclAddr1(custAddrVOs[i].getLoclAddr1());
					custaddrifVO.setLoclAddr2(custAddrVOs[i].getLoclAddr2());
					custaddrifVO.setLoclAddr3(custAddrVOs[i].getLoclAddr3());
					custaddrifVO.setLoclAddr4(custAddrVOs[i].getLoclAddr4());
					custaddrifVO.setCntCd(custAddrVOs[i].getCntCd());

					
					custaddrifVO.setCreUsrId(custAddrVOs[i].getCreUsrId());
					custaddrifVO.setUpdUsrId(custAddrVOs[i].getUpdUsrId());
					custaddrifVO.setDeltFlg(custAddrVOs[i].getDeltFlg());

					custaddrifVO.setR3InsfId("OPR307");
					custaddrifVO.setEcomInsfId("OPECOM02");

					if(custAddrVOs[i].getIbflag().equals("I")){
						custaddrifVO.setR3InsfDvCd("I");
						custaddrifVO.setEcomInsfDvCd("I");
					}else if(custAddrVOs[i].getIbflag().equals("U")){
						if(custAddrVOs[i].getDeltFlg().equals("Y")){
							custaddrifVO.setR3InsfDvCd("D");
							custaddrifVO.setEcomInsfDvCd("D");
						}else {
							custaddrifVO.setR3InsfDvCd("U");
							custaddrifVO.setEcomInsfDvCd("U");
						}
					}else if(custAddrVOs[i].getIbflag().equals("D")){
						custaddrifVO.setR3InsfDvCd("D");
						custaddrifVO.setEcomInsfDvCd("D");
					}
				
					dbDao.addCustAddrIf(custaddrifVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Contract Modify/delete event process, Save For EAI I/F process<br>
	 * Customer Contract (BCM_CCD_0052.do)<br>
	 * 
	 * @param CustomerContactVO[] customerContractVOs
	 * @exception EventException
	 */
	public void manageCustCntcIf(CustomerContactVO[] customerContractVOs) throws EventException {

		try {	
			CustCntcPntIfVO custcntcpntifVO = new CustCntcPntIfVO();

			String cust_cntc_pnt_if_seq = "";
			
			for(int i=0; customerContractVOs!=null && i < customerContractVOs.length; i++) {
				if(customerContractVOs[i].getIbflag().equals("U")||customerContractVOs[i].getIbflag().equals("D")||customerContractVOs[i].getIbflag().equals("I")){
					//CUST_CNTC_PNT_IF_SEQ 채번
					cust_cntc_pnt_if_seq = searchCustCntcPntIfSeq();
					custcntcpntifVO.setCustCntcPntIfSeq(cust_cntc_pnt_if_seq);
	
					custcntcpntifVO.setCustCntCd(customerContractVOs[i].getCustCntCd());
					custcntcpntifVO.setCustSeq(customerContractVOs[i].getCustSeq());
					custcntcpntifVO.setCustCntcPntSeq(customerContractVOs[i].getCustCntcPntSeq());
					custcntcpntifVO.setCustEml(customerContractVOs[i].getCustEml());
					custcntcpntifVO.setCustIp(customerContractVOs[i].getCustIp());
					custcntcpntifVO.setCustUrl(customerContractVOs[i].getCustUrl());
					custcntcpntifVO.setIntlPhnNo(customerContractVOs[i].getIntlPhnNo());
					custcntcpntifVO.setPhnNo(customerContractVOs[i].getPhnNo());
					custcntcpntifVO.setIntlFaxNo(customerContractVOs[i].getIntlFaxNo());
					custcntcpntifVO.setFaxNo(customerContractVOs[i].getFaxNo());
	
					custcntcpntifVO.setR3InsfId("OPR307");

					if(customerContractVOs[i].getIbflag().equals("I")){
						custcntcpntifVO.setR3InsfDvCd("I");
					}else if(customerContractVOs[i].getIbflag().equals("U")){
						custcntcpntifVO.setR3InsfDvCd("U");
					}else if(customerContractVOs[i].getIbflag().equals("D")){
						custcntcpntifVO.setR3InsfDvCd("D");
					}

					dbDao.addCustCntcPntIf(custcntcpntifVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer EAI I/F 의 테이블(MDM_CUSTOMER_IF)의 CUST_IF_SEQ생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * Customer Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCustIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String cust_if_seq = "";
        
        try {
            rowSet=dbDao.searchCustIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		cust_if_seq = rowSet.getString(1);
            	}
            }
            return cust_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Customer Address EAI I/F 의 테이블(MDM_CUST_ADDR_IF)의 CUST_ADDR_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * Customer Address Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCustAddrIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String cust_addr_if_seq = "";
        
        try {
            rowSet=dbDao.searchCustAddrIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		cust_addr_if_seq = rowSet.getString(1);
            	}
            }
            return cust_addr_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Customer Contract EAI I/F 의 테이블(MDM_CUST_CNTC_PNT_IF)의 CUST_CNTC_PNT_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0052)<br>
	 * Customer Contract Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCustCntcPntIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String cust_cntc_pnt_if_seq = "";
        
        try {
            rowSet=dbDao.searchCustCntcPntIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		cust_cntc_pnt_if_seq = rowSet.getString(1);
            	}
            }
            return cust_cntc_pnt_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(BCM_CCD_0052)<br>
	 * Customer Address Max Seq retrieve.<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return int
	 * @exception EventException
	 */
	public int searchMAXCustAddrSeq(String custcntcd, String custseq, String addrtpcd) throws EventException{
		DBRowSet rowSet = null;
		int ld_addr_seq = 0;

        try {
            rowSet=dbDao.searchMAXCustAddrSeq(custcntcd, custseq, addrtpcd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ld_addr_seq = rowSet.getInt(1);
            	}
            }
            return ld_addr_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Customer Contract(MDM_CUST_CNTC_PNT) 테이블의 MAX CUST_CNTC_PNT_SEQ 를 가져온다.(BCM_CCD_0052)<br>
	 * Customer Contract Max Seq retrieve.<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @return Double
	 * @exception EventException
	 */
	public Double searchMAXCustCntcPntSeq(String custcntcd, String custseq) throws EventException{
		DBRowSet rowSet = null;
		double ld_addr_seq = 0;

        try {
            rowSet=dbDao.searchMAXCustCntcPntSeq(custcntcd, custseq);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ld_addr_seq = rowSet.getDouble(1);
            	}
            }
            return ld_addr_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * BCM_CCD_0040 : Save<br>
	 * Vendor information save. For EAI I/F process<br>
	 * 
	 * @param VendorVO vendorVO
	 * @param VendorContactVO[] vendorContactVOs
	 * @param SignOnUserAccount account
	 * @param String oriOfcCd
	 * @param String isCntCdChanged
	 * @exception EventException
	 */
	public void manageVndrInfoIf(VendorVO vendorVO, VendorContactVO[] vendorContactVOs, SignOnUserAccount account, String oriOfcCd, String isCntCdChanged) throws EventException{
		try{
			VendorIfVO vendorifVO = new VendorIfVO();
			VndrCntcPntIfVO vndrcntcpntifVO = new VndrCntcPntIfVO();
			
			String vndr_if_seq = "";
			String vndr_cntc_pnt_if_seq = "";
			
			//VNDR_IF_SEQ 채번
			vndr_if_seq = searchVndrIfSeq();
			vendorifVO.setVndrIfSeq(vndr_if_seq);

			vendorifVO.setVndrSeq(vendorVO.getVndrSeq());
			vendorifVO.setVndrCntCd(vendorVO.getVndrCntCd());
			vendorifVO.setVndrLglEngNm(vendorVO.getVndrLglEngNm());
			vendorifVO.setVndrLoclLangNm(vendorVO.getVndrLoclLangNm());
			vendorifVO.setVndrAbbrNm(vendorVO.getVndrAbbrNm());
			vendorifVO.setLgsFlg(vendorVO.getLgsFlg());
			vendorifVO.setProcuFlg(vendorVO.getProcuFlg());
			vendorifVO.setTeamFlg(vendorVO.getTeamFlg());
			vendorifVO.setFincFlg(vendorVO.getFincFlg());
			//vendorifVO.setBlkFlg(vendorVO.getBlkFlg());
			vendorifVO.setInterCoFlg(vendorVO.getInterCoFlg());
			//vendorifVO.setRailVndrFlg(vendorVO.getRailVndrFlg());
			vendorifVO.setLocCd(vendorVO.getLocCd());
			vendorifVO.setOfcCd(vendorVO.getOfcCd());
			vendorifVO.setCeoNm(vendorVO.getCeoNm());
			vendorifVO.setRgstNo(vendorVO.getRgstNo());
			vendorifVO.setTaxId(vendorVO.getTaxId ());
			vendorifVO.setPrntCntCd(vendorVO.getPrntCntCd());
			vendorifVO.setPrntVndrSeq(vendorVO.getPrntVndrSeq());
			vendorifVO.setDcgoHndlFlg(vendorVO.getDcgoHndlFlg());
			vendorifVO.setSvcScpCdNm(vendorVO.getSvcScpCdNm());
			vendorifVO.setSvcPrdTpNm(vendorVO.getSvcPrdTpNm());
			vendorifVO.setSvcPrdRmk(vendorVO.getSvcPrdRmk());
			vendorifVO.setBzctNm(vendorVO.getBzctNm());
			vendorifVO.setBztpNm(vendorVO.getBztpNm());
			vendorifVO.setGenPayTermCd(vendorVO.getGenPayTermCd());
			vendorifVO.setEngAddr(vendorVO.getEngAddr());
			vendorifVO.setLoclLangAddr(vendorVO.getLoclLangAddr());
			vendorifVO.setZipCd(vendorVO.getZipCd());
			vendorifVO.setCntcPsonNm(vendorVO.getCntcPsonNm());
			vendorifVO.setInvCurrCd(vendorVO.getInvCurrCd());
			//vendorifVO.setPayCurrCd(vendorVO.getPayCurrCd());
			vendorifVO.setPayMzdCd(vendorVO.getPayMzdCd());
			vendorifVO.setUsaEdiCd(vendorVO.getUsaEdiCd());
			vendorifVO.setWoAtchFileFlg(vendorVO.getWoAtchFileFlg());
			vendorifVO.setWoEdiUseFlg(vendorVO.getWoEdiUseFlg());
			vendorifVO.setInvEdiUseFlg(vendorVO.getInvEdiUseFlg());
			vendorifVO.setMtyRroEdiUseFlg(vendorVO.getMtyRroEdiUseFlg());
			//vendorifVO.setBlkVndrSvcCd(vendorVO.getBlkVndrSvcCd());
			vendorifVO.setSubsCoCd(vendorVO.getSubsCoCd());
			vendorifVO.setOtrFlg(vendorVO.getOtrFlg());
			vendorifVO.setVndrOfcCd(vendorVO.getVndrOfcCd());
			vendorifVO.setRfndPsdoCustCd(vendorVO.getRfndPsdoCustCd());
			vendorifVO.setPayTermTpCd(vendorVO.getPayTermTpCd());
			vendorifVO.setModiVndrCd(vendorVO.getModiVndrCd());
			
			/* 2014.12.18 INTL_PHN_NO, PHN_NO, INTL_FAX_NO, FAX_NO, VNDR_EML, PRMRY_CHK_FLG, CNTC_PNT_DELT_FLG, CNTC_DIV_CD, CHK_DE_STE_CD, CHK_DE_ZIP_CD, CHK_DE_CNT_CD */
			if(vendorContactVOs != null){
				for( int i = 0; i < vendorContactVOs.length; i++){
					if(vendorContactVOs[i].getPrmryChkFlg().equals("Y") || vendorContactVOs[i].getPrmryChkFlg().equals("1")){
						vendorifVO.setIntlPhnNo(vendorContactVOs[i].getIntlPhnNo());
						vendorifVO.setPhnNo(vendorContactVOs[i].getPhnNo());
						vendorifVO.setIntlFaxNo(vendorContactVOs[i].getIntlFaxNo());
						vendorifVO.setFaxNo(vendorContactVOs[i].getFaxNo());
						vendorifVO.setVndrEml(vendorContactVOs[i].getVndrEml());
						vendorifVO.setPrmryChkFlg(vendorContactVOs[i].getPrmryChkFlg());
						vendorifVO.setCntcPntDeltFlg(vendorContactVOs[i].getDeltFlg());
						vendorifVO.setCntcDivCd(vendorContactVOs[i].getCntcDivCd());
					}
				}
			}
			vendorifVO.setChkDeAddr1(vendorVO.getChkDeAddr1());
			vendorifVO.setChkDeAddr2(vendorVO.getChkDeAddr2());
			vendorifVO.setChkDeAddr3(vendorVO.getChkDeAddr3());
			vendorifVO.setChkDeCntCd(vendorVO.getChkDeCntCd());
			vendorifVO.setChkDeSteCd(vendorVO.getChkDeSteCd());
			vendorifVO.setChkDeCtyNm(vendorVO.getChkDeCtyNm());
			vendorifVO.setChkDeZipCd(vendorVO.getChkDeZipCd());
			/* 2014.12.18 */
			
			vendorifVO.setCreUsrId(account.getUsr_id());
			vendorifVO.setUpdUsrId(account.getUsr_id());
			vendorifVO.setDeltFlg(vendorVO.getDeltFlg());

			vendorifVO.setR3InsfId("OPR308");
			vendorifVO.setOcediInsfId("OCEDI03");
			if("Y".equals(vendorVO.getEdiIfFlg())||"Y".equals(vendorVO.getDeltFlg())){
				vendorifVO.setOpediInsfId("OPEDI06");
			}else{
				vendorifVO.setOpediInsfId("");
			}
			

			if(vendorVO.getIbflag().equals("I")){
				vendorifVO.setR3InsfDvCd("I");
				vendorifVO.setOcediInsfDvCd("I");
				vendorifVO.setOpediInsfDvCd("I");
			}else if(vendorVO.getIbflag().equals("U")){
				if(vendorVO.getDeltFlg().equals("Y")){
					vendorifVO.setR3InsfDvCd("D");
					vendorifVO.setOcediInsfDvCd("D");
					vendorifVO.setOpediInsfDvCd("D");
				}else {
					vendorifVO.setR3InsfDvCd("U");
					vendorifVO.setOcediInsfDvCd("U");
					vendorifVO.setOpediInsfDvCd("U");
				}
			}
			
			/* 2015.09.09 */
			// because of difference on primary key between OPUS(Vendor Sequence) and SAKURA(Vendor Country Code + Vendor Sequence)
			// check country code of vendor office
			// if not same then InsfDvCd 'D' and 'I'
			String newOfcCd = vendorifVO.getOfcCd();
            
			if(vendorVO.getIbflag().equals("U") && 
			   !vendorVO.getDeltFlg().equals("Y") && 
			   isCntCdChanged.equalsIgnoreCase("Y")) { // country is changed
				log.debug("---------------------------------------------");
				log.debug("oriOfcCd : " + oriOfcCd);
				log.debug("---------------------------------------------");
				vendorifVO.setOfcCd(oriOfcCd); // set original office code
				vendorifVO.setR3InsfDvCd("D");
				vendorifVO.setOcediInsfDvCd("");
				vendorifVO.setOpediInsfDvCd("");
				dbDao.addVndrInfoIf(vendorifVO);

				log.debug("---------------------------------------------");
				log.debug("newOfcCd : " + newOfcCd);
				log.debug("---------------------------------------------");
				//VNDR_IF_SEQ 채번
				vndr_if_seq = searchVndrIfSeq();
				vendorifVO.setVndrIfSeq(vndr_if_seq);
				vendorifVO.setOfcCd(newOfcCd); // set new office code
				vendorifVO.setR3InsfDvCd("I");
				vendorifVO.setOcediInsfDvCd("U");
				vendorifVO.setOpediInsfDvCd("U");
				dbDao.addVndrInfoIf(vendorifVO);
			} else {
				dbDao.addVndrInfoIf(vendorifVO);
			}
						
			if(vendorContactVOs != null){
				for( int i = 0; i < vendorContactVOs.length; i++){
					//VNDR_CNTC_PNT_IF_SEQ 채번
					vndr_cntc_pnt_if_seq = searchVndrCntcPntIfSeq();
					vndrcntcpntifVO.setVndrCntcPntIfSeq(vndr_cntc_pnt_if_seq);

					vndrcntcpntifVO.setVndrSeq(vendorContactVOs[i].getVndrSeq());
					vndrcntcpntifVO.setVndrCntcPntSeq(vendorContactVOs[i].getVndrCntcPntSeq());
					vndrcntcpntifVO.setIntlPhnNo(vendorContactVOs[i].getIntlPhnNo());
					vndrcntcpntifVO.setPhnNo(vendorContactVOs[i].getPhnNo());
					vndrcntcpntifVO.setIntlFaxNo(vendorContactVOs[i].getIntlFaxNo());
					vndrcntcpntifVO.setFaxNo(vendorContactVOs[i].getFaxNo());
					vndrcntcpntifVO.setVndrEml(vendorContactVOs[i].getVndrEml());
					vndrcntcpntifVO.setPrmryChkFlg(vendorContactVOs[i].getPrmryChkFlg());
					vndrcntcpntifVO.setCntcDivCd(vendorContactVOs[i].getCntcDivCd());
					
					vndrcntcpntifVO.setCreUsrId(account.getUsr_id());
					vndrcntcpntifVO.setUpdUsrId(account.getUsr_id());
					vndrcntcpntifVO.setDeltFlg(vendorContactVOs[i].getDeltFlg());

					vndrcntcpntifVO.setR3InsfId("OPR308");

					if(vendorContactVOs[i].getIbflag().equals("I")){
						vndrcntcpntifVO.setR3InsfDvCd("I");
					}else if(vendorContactVOs[i].getIbflag().equals("U")){
						if(vendorContactVOs[i].getDeltFlg().equals("Y")){
							vndrcntcpntifVO.setR3InsfDvCd("D");
						}else {
							vndrcntcpntifVO.setR3InsfDvCd("U");
						}
					}
					dbDao.addVndrCntcPntIf(vndrcntcpntifVO);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * Vendor EAI I/F 의 테이블(MDM_CUSTOMER_IF)의 CUST_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0040)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String vndr_if_seq = "";
        
        try {
            rowSet=dbDao.searchvndrIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		vndr_if_seq = rowSet.getString(1);
            	}
            }
            return vndr_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Vendor Contract EAI I/F 의 테이블(MDM_VNDR_CNTC_PNT_IF)의 VNDR_CNTC_PNT_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0040)<br>
	 * Vendor Contract Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrCntcPntIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String vndr_cntc_pnt_if_seq = "";
        
        try {
            rowSet=dbDao.searchVndrCntcPntIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		vndr_cntc_pnt_if_seq = rowSet.getString(1);
            	}
            }
            return vndr_cntc_pnt_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Vendor Contract(MDM_VNDR_CNTC_PNT) 테이블의 MAX VNDR_CNTC_PNT_SEQ 를 가져온다.(BCM_CCD_0040)<br>
	 * Vendor Contract Max Seq retrieve.<br>
	 *  
	 * @param  String vndrseq
	 * @return Double
	 * @exception EventException
	 */
	public Double searchMaxVndrCntcPntSeq(String vndrseq) throws EventException{
		DBRowSet rowSet = null;
		double ld_vndr_cntc_pnt_seq = 0;
        
        try {
            rowSet=dbDao.searchMaxVndrCntcPntSeq(vndrseq);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ld_vndr_cntc_pnt_seq = rowSet.getDouble(1);
            	}
            }
            return ld_vndr_cntc_pnt_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Modify/save/delete event process<br>
	 * Customer Performance Group  (BCM_CCD_0038.do) For EAI I/F process<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfIf(CustomerPerformanceVO customerPerformanceVO, SignOnUserAccount account) throws EventException {		
		try {		
			CustomerPerformanceIfVO customerperformanceifVO = new CustomerPerformanceIfVO();
			String cust_perf_grp_if_seq = "";
			
			//CUST_PERF_GRP_IF_SEQ 채번
			cust_perf_grp_if_seq = searchCustPerfIfSeq();
			customerperformanceifVO.setCustPerfGrpIfSeq(cust_perf_grp_if_seq);

			customerperformanceifVO.setCustGrpId(customerPerformanceVO.getCustGrpId());
			customerperformanceifVO.setCustGrpNm(customerPerformanceVO.getCustGrpNm());
			customerperformanceifVO.setCustGrpAbbrNm(customerPerformanceVO.getCustGrpAbbrNm());
			customerperformanceifVO.setOfcCd(customerPerformanceVO.getOfcCd());
			customerperformanceifVO.setSrepCd(customerPerformanceVO.getSrepCd());
			customerperformanceifVO.setVbsClssCd(customerPerformanceVO.getVbsClssCd());
			customerperformanceifVO.setNbsClssCd1(customerPerformanceVO.getNbsClssCd1());
			customerperformanceifVO.setNbsClssCd2(customerPerformanceVO.getNbsClssCd2());
			customerperformanceifVO.setNbsClssCd3(customerPerformanceVO.getNbsClssCd3());
			
			customerperformanceifVO.setCreUsrId(account.getUsr_id());
			customerperformanceifVO.setUpdUsrId(account.getUsr_id());
			customerperformanceifVO.setDeltFlg(customerPerformanceVO.getDeltFlg());

			customerperformanceifVO.setEcomInsfId("OPECOM04");

			if(customerPerformanceVO.getIbflag().equals("I")){
				customerperformanceifVO.setEcomInsfDvCd("I");
			}else if(customerPerformanceVO.getIbflag().equals("U")){
				if(customerPerformanceVO.getDeltFlg().equals("Y")){
					customerperformanceifVO.setEcomInsfDvCd("D");
				}else {
					customerperformanceifVO.setEcomInsfDvCd("U");
				}
			}

			dbDao.addCustPerfIf(customerperformanceifVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}

	/**
	 * Customer Performance Group EAI I/F 의 테이블(MDM_CUST_PERF_GRP_IF)의 CUST_PERF_GRP_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0038)<br>
	 * Vendor Seq + 1 retrieve.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchCustPerfIfSeq() throws EventException{
		DBRowSet rowSet = null;
        String cust_perf_grp_if_seq = "";
        
        try {
            rowSet=dbDao.searchCustPerfIfSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		cust_perf_grp_if_seq = rowSet.getString(1);
            	}
            }
            return cust_perf_grp_if_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}

	/**
	 * Customer Contract Request Info retrieve.(BCM_CCD_2002)<br>
	 * 
	 * @param String rqstNo
	 * @return List<CustomerContactVO>
	 * @exception DAOException
	 */
	public List<CustomerContactVO> searchCustCntcRqst(String rqstNo) throws EventException {
		
		try {
			return dbDao.searchCustCntcRqst(rqstNo);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * add/update Vendor's TPB Customer (BCM_CCD_2002)<br>
	 * 
	 * @param VendorGroupVO vendorGroup
	 * @throws EventException
	 */
	public void mergeMdmCustFrmVndr(VendorGroupVO vendorGroup) throws EventException {
		try {
			VendorVO vendorVO = vendorGroup.getVendorVO();
			// set VO for MDM_CUSTOMER
			CustomerVO customerVO = new CustomerVO();
			customerVO.setIbflag(vendorVO.getIbflag());
			customerVO.setCustCntCd("TB");
			customerVO.setCustSeq(vendorVO.getVndrSeq());
			customerVO.setCustLglEngNm(vendorVO.getVndrLglEngNm());
			customerVO.setCustLoclLangNm(vendorVO.getVndrLoclLangNm());
			customerVO.setCustRgstNo(vendorVO.getRgstNo());
//			customerVO.setBlkCustTpCd(vendorVO.getBlkVndrSvcCd());
			customerVO.setOfcCd(vendorVO.getOfcCd());
			customerVO.setLocCd(vendorVO.getLocCd());
			customerVO.setVndrSeq(vendorVO.getVndrSeq());
			customerVO.setCreUsrId(vendorVO.getCreUsrId());
			customerVO.setCreDt(vendorVO.getCreDt());
			customerVO.setUpdUsrId(vendorVO.getUpdUsrId());
			customerVO.setUpdDt(vendorVO.getUpdDt());
			customerVO.setDeltFlg(vendorVO.getDeltFlg());
			
			dbDao.mergeMdmCustFrmVndr(customerVO);
			
			CustomerAddressVO customerAddressVO = new CustomerAddressVO();
			//CustomerContactVO customerContactVO = new CustomerContactVO();
			VendorContactVO[] vendorContactVOArr = vendorGroup.getVendorContactVOs();
			
			// customer address information
			if(vendorVO != null) { 
				customerAddressVO.setAddrTpCd("1"); //ADDR_TP_CD
				customerAddressVO.setAddrSeq("1"); //ADDR_SEQ
				customerAddressVO.setPrmryChkFlg("Y"); //PRMRY_CHK_FLG
				customerAddressVO.setBzetNm(vendorVO.getVndrLglEngNm());//BZET_NM
				customerAddressVO.setBzetAddr(vendorVO.getEngAddr()); //BZET_ADDR
				customerAddressVO.setCtyNm(vendorVO.getChkDeCtyNm()); //CTY_NM
				customerAddressVO.setSteCd(vendorVO.getChkDeSteCd()); //STE_CD
				if(StringUtils.isEmpty(vendorVO.getZipCd())) {
					customerAddressVO.setZipCd(vendorVO.getChkDeZipCd()); //ZIP_CD
				} else {
					customerAddressVO.setZipCd(vendorVO.getZipCd()); //ZIP_CD
				}
				customerAddressVO.setCntcEml(""); //CNTC_EML
				customerAddressVO.setCntcPsonNm(vendorVO.getCntcPsonNm()); //CNTC_PSON_NM
				customerAddressVO.setBzetRmk(""); //BZET_RMK
				if(StringUtils.isEmpty(vendorVO.getChkDeAddr1())) {
					customerAddressVO.setLoclAddr1(vendorVO.getEngAddr()); //LOCL_ADDR1
				} else {
					customerAddressVO.setLoclAddr1(vendorVO.getChkDeAddr1()); //LOCL_ADDR1
				}
				customerAddressVO.setLoclAddr2(vendorVO.getChkDeAddr2()); //LOCL_ADDR2
				customerAddressVO.setLoclAddr3(vendorVO.getChkDeAddr3()); //LOCL_ADDR3
				customerAddressVO.setLoclAddr4(""); //LOCL_ADDR4
				customerAddressVO.setCntCd(vendorVO.getChkDeCntCd()); //CNT_CD
			}
			
			CustomerIntegrationVO customerIntgVO = new CustomerIntegrationVO();
			CustomerContactVO[] customerContactVOArr = null;
			// customer contact point information
			if(vendorContactVOArr != null) {
				for(int i=0;i<vendorContactVOArr.length;i++) {
					log.debug("vendorContactVOArr : " + i);
					log.debug("vendorContactVOArr : SEQ [" + vendorContactVOArr[i].getVndrCntcPntSeq() + "]");
					// set only sequential number 1
					if("1".equals(vendorContactVOArr[i].getPrmryChkFlg()) || "Y".equals(vendorContactVOArr[i].getPrmryChkFlg())) {
						log.debug("vendorContactVOArr : FIRST");
						customerContactVOArr = new CustomerContactVO[1];
						customerContactVOArr[0] = new CustomerContactVO();
						customerContactVOArr[0].setPrmryChkFlg(vendorContactVOArr[i].getPrmryChkFlg());
						customerContactVOArr[0].setCustCntcPntSeq(vendorContactVOArr[i].getVndrCntcPntSeq()); //CUST_CNTC_PNT_SEQ
						customerContactVOArr[0].setCustEml(vendorContactVOArr[i].getVndrEml()); //CUST_EML
						customerContactVOArr[0].setCustUrl(""); //CUST_URL
						customerContactVOArr[0].setIntlPhnNo(vendorContactVOArr[i].getIntlPhnNo()); //INTL_PHN_NO
						customerContactVOArr[0].setPhnNo(vendorContactVOArr[i].getPhnNo()); //PHN_NO
						customerContactVOArr[0].setIntlFaxNo(vendorContactVOArr[i].getIntlFaxNo()); //INTL_FAX_NO
						customerContactVOArr[0].setFaxNo(vendorContactVOArr[i].getFaxNo()); //FAX_NO
						break;
					}
				}
				customerIntgVO.setCustomerContactVOs(customerContactVOArr);
			}else{
				log.debug("vendorContactVOArr IS NULL");
			}
			customerIntgVO.setCustomerVO(customerVO);
			customerIntgVO.setCustomerAddressVOs(new CustomerAddressVO[]{customerAddressVO});
			
			manageCustInfoIf(customerIntgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * add/update Vendor's TPB Customer Address (BCM_CCD_2002)<br>
	 * 
	 * @param VendorVO vendorVO
	 * @throws EventException
	 */
	public void mergeMdmCustAddrFrmVndr(VendorVO vendorVO) throws EventException {
		try {
				// set VO for MDM_CUSTOMER
				CustomerAddressVO custAddrVO = new CustomerAddressVO();
				custAddrVO.setIbflag(vendorVO.getIbflag());
				custAddrVO.setCustCntCd("TB");
				custAddrVO.setCustSeq(vendorVO.getVndrSeq());
				custAddrVO.setAddrTpCd("1");
				custAddrVO.setAddrSeq("1");
				custAddrVO.setBzetAddr(vendorVO.getEngAddr());
				custAddrVO.setLoclAddr1(vendorVO.getLoclLangAddr());
				custAddrVO.setLoclAddr2(vendorVO.getChkDeAddr1());
				custAddrVO.setLoclAddr3(vendorVO.getChkDeAddr2());
				custAddrVO.setLoclAddr4(vendorVO.getChkDeAddr3());
				custAddrVO.setBzetNm(vendorVO.getBzctNm());
				custAddrVO.setCreUsrId(vendorVO.getCreUsrId());
				custAddrVO.setCreDt(vendorVO.getCreDt());
				custAddrVO.setUpdUsrId(vendorVO.getUpdUsrId());
				custAddrVO.setUpdDt(vendorVO.getUpdDt());
				custAddrVO.setDeltFlg(vendorVO.getDeltFlg());
				
				dbDao.mergeMdmCustAddrFrmVndr(custAddrVO);
				
				manageCustAddrIf(new CustomerAddressVO[]{custAddrVO});
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Update Vendor Sakura Interface Data<br>
	 * 
	 * @param VendorVO vendorVO
	 * @throws EventException
	 */
	public void modifySakuraInterfaceData(VendorVO vendorVO) throws EventException{
		try {
			dbDao.modifySakuraInterfaceData(vendorVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Retrieve Sakura Interface Target Data<br>
	 * 
	 * @return List<CustomerContactVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchMdaSakuraInterfaceData() throws EventException{
		try {
			return dbDao.searchMdaSakuraInterfaceData();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Vendor Sakura Interface Result Save<br>
	 * 
	 * @param List<VendorVO> list
	 * @exception EventException
	 */
	public void modifyVendorInterfaceResultData(List<VendorVO> list) throws EventException{
		try {
			dbDao.modifyVendorInterfaceResultData(list);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * check Legacy Code(SAP ID) (BCM_CCD_0035)<br>
	 * 
	 * @param VendorVO vendorVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchVendorBankPayData(VendorVO vendorVO) throws EventException{
		try {
			return dbDao.searchVendorBankInfoData(vendorVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Customer Code checking.<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerVO>
	 * @exception EventException
	 */
	public List<CustomerVO> checkExistCustCode(String custCntCd, String custSeq) throws EventException{
        try {
            return dbDao.checkExistCustInfoData(custCntCd, custSeq);            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
}
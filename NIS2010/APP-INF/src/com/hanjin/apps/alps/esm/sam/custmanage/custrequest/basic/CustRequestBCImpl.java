/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustRequestBCImpl.java
*@FileTitle : Customer Request
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.vo.SearchCustGroupVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration.CustMainDBDAO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration.CustMainEAIDAO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.ComboListVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration.CustRequestDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-commoncode Business Logic Command Interface<br>
 * An interface to the business logic for common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public class CustRequestBCImpl extends BasicCommandSupport implements CustRequestBC {

	// Database Access Object
	private transient CustRequestDBDAO dbDao = null;
	private transient CustMainEAIDAO eaiDao = null;

	/**
	 * CustMainBCImpl object creation<br>
	 * Generate artnerDBDAO.<br>
	 */
	public CustRequestBCImpl() {
		dbDao = new CustRequestDBDAO();
		eaiDao = new CustMainEAIDAO();
	}
	
	/**
	 * CustGroup List 조회<br>
	 * @param String custGrpId
	 * @param String custGrpNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String mdmYn
	 * @param String deltFlg
	 * @param String custGrpAbbrNm
	 * @return List<CustomerVO>
	 * @throws EventException
	 */
    public List<CustomerVO> searchRqstCustomer(String rqstNo, String custNm, String ofcCd, int iPage, String deltFlg, String rqstFmDt, String rqstToDt, String creFmDt, String creToDt) throws EventException {
        try {
			return  dbDao.searchRqstCustomer(rqstNo, custNm, ofcCd, iPage, deltFlg, rqstFmDt, rqstToDt, creFmDt, creToDt);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }
    
	/**
	 * Request No checking.<br>
	 * 
	 * @param String rqstNo
	 * @return String
	 * @exception EventException
	 */
	public String checkCustRqst(String rqstNo) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkCustRqst(rqstNo);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Customer 정보를 EAI로 전송한다. <BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param CustomerVO customerVo
	 */
	public void sendCustRqstToMdm(String rqstNo, String usrId, String creFlag) {
		// error에 대한 추가 처리이므호 exception을 throw하지 않음
		try{
			CustomerVO customerVo = dbDao.searchCustRqst(rqstNo);
			log.debug("Customer EAI Start : ");		
			if (customerVo != null){
				eaiDao.sendCustomerToMdm(customerVo, usrId, creFlag);
			}
			
			dbDao.modifyCustRqstEai(rqstNo, usrId);
		} catch (Exception ex) {
        	log.error(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Modify/save event process<br>
	 * Customer Request Creation (ESM_SAM_0309.do)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageCustRqst(CustomerVO customerVO,  SignOnUserAccount account) throws EventException {
		try {
			log.debug("\nmanageCustCode================================"+customerVO.getIbflag());
			if(customerVO.getIbflag().equals("I")){
				customerVO.setCreUsrId(account.getUsr_id());
				customerVO.setUpdUsrId(account.getUsr_id());
				
				log.debug("\nsearchMAXCustomerSeq================================"+customerVO.getIbflag());
				
				int ld_rqst_seq = searchCustomerRqstSeq();
				//log.debug("\nsearchMAXCustomerSeq================================"+ld_cust_seq);
				customerVO.setRqstNo(ld_rqst_seq+"");
				log.debug("\nsearchMAXCustomerSeq================================"+customerVO.getCustSeq());
				dbDao.addCustRqst(customerVO);
			}
			else if(customerVO.getIbflag().equals("U")){
				customerVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyCustRqst(customerVO);	
		    }
			
			return customerVO;
			// EAI I/F
        	//manageCustInfoIf(custIntgVO);
			

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Customer Code retrieve.(ESM_SAM_0309)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
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
	 * Customer (MDM CUSTOMER REQUEST) 테이블의 REQUEST NO 를 가져온다.(ESM_SAM_0309)<br>
	 * Customer Max Seq retrieve.<br>

	 * @return int
	 * @exception EventException
	 */
	public int searchCustomerRqstSeq() throws EventException{
		DBRowSet rowSet = null;
		int ld_cust_seq = 0;

        try {
            rowSet=dbDao.searchCustomerRqstSeq();
            if(rowSet!=null) {
            	while(rowSet.next()){
            		ld_cust_seq = rowSet.getInt(1);
            	}
            }
            return ld_cust_seq;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Currency Code checking.<br>
	 * 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String checkUserMdmAuth(String usrId) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkUserMdmAuth(usrId);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	

}
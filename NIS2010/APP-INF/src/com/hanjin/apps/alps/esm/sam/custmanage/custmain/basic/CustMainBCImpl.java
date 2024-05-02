/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustMainBCImpl.java
*@FileTitle : Customer main 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
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

public class CustMainBCImpl extends BasicCommandSupport implements CustMainBC {

	// Database Access Object
	private transient CustMainDBDAO dbDao = null;
	private transient CustMainEAIDAO eaiDao = null;

	/**
	 * CustMainBCImpl object creation<br>
	 * Generate artnerDBDAO.<br>
	 */
	public CustMainBCImpl() {
		dbDao = new CustMainDBDAO();
		eaiDao = new CustMainEAIDAO();
	}
	
	/**
	 * Customer List 조회<br>
	 * @param String custCd
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String include
	 * @param String cust
	 * @param String zipCd
	 * @return List<SearchCustomerVO>
	 * @throws EventException
	 */
    public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd, String custGrpId, String locCd, String steCd, String srepCd, String deltFlg) throws EventException {
        try {
			return  dbDao.searchCustomerList(custCd, custNm, ofcCd, iPage, include, cust, zipCd, custGrpId, locCd, steCd, srepCd, deltFlg);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
    }
	
	/**
	 * ESM_SAM_0302 : Retrieve<br>
	 * Coverage Team 정보를 조회<br><br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO
	 * @return List<CustCoverTeamVO >
	 * @exception EventException
	 */
	public List<CustCoverTeamVO > searchCustCoverList(String custCntCd, String custSeq )throws EventException {
		try {
			return dbDao.searchCustCoverList(custCntCd, custSeq );
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
	
	/**
	 * Sales Repository Code checking.<br>
	 * 
	 * @param String slsRepCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSlsRepCode(String slsRepCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        String srep_nm = "";
        String ofc_cd = "";
        String mphn_no = "";
        String srep_eml = "";
        
        try {
            rowSet=dbDao.checkSlsRepCode(slsRepCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            		srep_nm = rowSet.getString(2);
            		ofc_cd = rowSet.getString(3);
            		mphn_no = rowSet.getString(4);
            		srep_eml = rowSet.getString(5);
            	}
            }
            return check+","+srep_nm+","+ofc_cd+","+mphn_no+","+srep_eml;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Customer Code checking.<br>
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCustCode(String custCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        String check1 = "";
        String grp_id_chk = "";
        String grp_prmry_chk = "";
        String cust_nm = "";
        String loc_cd = "";
        String ofc_cd = "";
        
        try {
            rowSet=dbDao.checkCustCode(custCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            		check1 = rowSet.getString(2);
            		grp_id_chk = rowSet.getString(3);
            		grp_prmry_chk = rowSet.getString(4);
                    loc_cd = rowSet.getString(5);
                    ofc_cd = rowSet.getString(6);
            		cust_nm = rowSet.getString(7);
            	}
            }
            return check+","+check1+","+grp_id_chk+","+grp_prmry_chk+","+loc_cd+","+ofc_cd+","+cust_nm;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Group Customer Code checking.<br>
	 * 
	 * @param String grpCustCd
	 * @return String
	 * @exception EventException
	 */
	public String checkGrpCustCode (String grpCustCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkGrpCustCode(grpCustCd);
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
	 * State Code checking.<br>
	 * 
	 * @param String steCd
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String checkStateCode (String steCd, String cntCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
         
        try {
            rowSet=dbDao.checkStateCode(steCd, cntCd);
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
	 * Currency Code checking.<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCurrCode(String currCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkCurrCode(currCd);
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
	 * Vender Code checking.<br>
	 * 
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
	 */
	public String checkVndrCode(String vndrCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkVndrCode(vndrCd);
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
	 * Office Code checking.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String checkOfcCode(String ofcCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        String check1 = "";
        try {
            rowSet=dbDao.checkOfcCode(ofcCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            		check1 = rowSet.getString(2);
            	}
            }
            return check+","+check1;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
	}
	
	/**
	 * Customer Name, to look similar to the registered .(ESM_SAM_0304)<br>
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
	 * Location Code checking.<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCode(String locCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkLocCode(locCd);
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
	 * Trade Code checking.<br>
	 * 
	 * @param String trdCd
	 * @return String
	 * @exception EventException
	 */
	public String checkTrdCode (String trdCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkTrdCode(trdCd);
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
	 * Country Code checking.<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCntCode(String cntCd) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkCntCode(cntCd);
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
	 * International No checking.<br>
	 * 
	 * @param String intlNo
	 * @return String
	 * @exception EventException
	 */
	public String checkIntlNo(String intlNo) throws EventException{
		DBRowSet rowSet = null;
        String check = "";
        
        try {
            rowSet=dbDao.checkIntlNo(intlNo);
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
	 * Customer (MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
	 * Customer Max Seq retrieve.<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return double
	 * @exception EventException
	 */
	public double searchMAXCustomerSeq(String custcntcd) throws EventException{
		DBRowSet rowSet = null;
		double ld_cust_seq = 0;

        try {
            rowSet=dbDao.searchMAXCustomerSeq(custcntcd);
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
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
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
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
	 * Customer Address Max Seq retrieve.<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @return int
	 * @exception EventException
	 */
	public int searchCntCustHisSeq(String custcntcd, String custseq) throws EventException{
		DBRowSet rowSet = null;
		int ld_addr_seq = 0;

        try {
            rowSet=dbDao.searchCntCustHisSeq(custcntcd, custseq);
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
	 * Modify/save/delete event process<br>
	 * Customer Address (ESM_SAM_0302.do)<br>
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
			        }else if(custAddrVOs[i].getIbflag().equals("D")){
			        	custAddrVOs[i].setCreUsrId(account.getUsr_id());
						custAddrVOs[i].setUpdUsrId(account.getUsr_id());
			        	custAddrVOs[i].setDeltFlg("Y");
			        	dbDao.removeCustAddrCode(custAddrVOs[i]);
			        }
					
					eaiDao.sendCustAddrToMdm(custAddrVOs[i], account.getUsr_id());
				}
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
     * save MDM Customer data for Customer Code Validation
	 * @param List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception EventException
	 */
	public boolean mergeBkgCustCdVal(List<MdmCustomerVO> mdmCustomerVOs)throws EventException{
		boolean isSuccessful = false;
		try {
			isSuccessful = dbDao.mergeBkgCustCdVal(mdmCustomerVOs);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		return isSuccessful;
	}
	
	/**
     * save MDM Customer data for Customer Code Validation
	 * @param List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception EventException
	 */
	public boolean mergeMdmCustSezCerti(CustomerVO customerVo)throws EventException{
		boolean isSuccessful = false;
		try {
			isSuccessful = dbDao.mergeMdmCustSezCerti(customerVo);
        }catch (DAOException de) {
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
		return isSuccessful;
	}
	
	/**
	 * SalesRep info save/modify.<br>
	 * 
	 * @param BkgSalesRepVO[] bkgSalesRepVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesRep(BkgSalesRepVO[] bkgSalesRepVOs,  SignOnUserAccount account) throws EventException{
		
		try {
			if (bkgSalesRepVOs != null && bkgSalesRepVOs.length >0){
				for ( int i=0; i<bkgSalesRepVOs.length; i++ ) {
					if ( bkgSalesRepVOs[i].getIbflag().equals("D")){
						bkgSalesRepVOs[i].setUserId(account.getUsr_id());
						dbDao.modifySalesRepCode(bkgSalesRepVOs[i]);
					}
				}
				for ( int i=0; i<bkgSalesRepVOs.length; i++ ) {
					if ( bkgSalesRepVOs[i].getIbflag().equals("I")){
						bkgSalesRepVOs[i].setUserId(account.getUsr_id());
						dbDao.addSalesRepCode(bkgSalesRepVOs[i]);
					}
				}
				for ( int i=0; i<bkgSalesRepVOs.length; i++ ) {
					if ( bkgSalesRepVOs[i].getIbflag().equals("U")){
						bkgSalesRepVOs[i].setUserId(account.getUsr_id());
						dbDao.modifySalesRepCode(bkgSalesRepVOs[i]);
					}
				}				
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Contact Point Code (ESM_SAM_0302.do)<br>
	 * 
	 * @param CustomerContactVO[] customerContractVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustCntcCode(CustomerContactVO[] customerContractVOs, SignOnUserAccount account, String creFlag) throws EventException {
		try {		
			for(int i=0; i < customerContractVOs.length; i++) {
				if(customerContractVOs[i].getIbflag().equals("U")){
					customerContractVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyCustCntcCode(customerContractVOs[i]);
				}else if(customerContractVOs[i].getIbflag().equals("I")){
					customerContractVOs[i].setCreUsrId(account.getUsr_id());
					customerContractVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addCustCntcCode(customerContractVOs[i]);	
			    }
			}
			sendCustomerToMdm(customerContractVOs[0].getCustCntCd(), customerContractVOs[0].getCustSeq(), account.getUsr_id(), creFlag);
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

	}
	
	/**
	 * Customer 정보를 EAI로 전송한다. <BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param CustomerVO customerVo
	 */
	public void sendCustomerToMdm(String custCntCd, String custSeq, String usrId, String creFlag) throws EventException {
		// error에 대한 추가 처리이므호 exception을 throw하지 않음
		try{
			CustomerVO customerVo = dbDao.searchCustCode(custCntCd, custSeq);
			log.debug("Customer EAI Start : ");		
			if (customerVo != null){
				eaiDao.sendCustomerToMdm(customerVo, usrId, creFlag);
			}
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}

	/**
	 * ESM_SAM_0302 : manage<br>
	 * Check Sales Rep Code 
	 * @param String custCd 
	 * @param String srepCd
	 * @return String
	 * @exception EventException
	 */
	public String checkSalesRepCode(String custCd, String srepCd) throws EventException {
		DBRowSet rowSet = null;
		String check = "";
		try {
			rowSet = dbDao.checkSalesRepCode(custCd, srepCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
	
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0302 : manage<br>
	 * Check Contact Point
	 * @param String custCntCd 
	 * @param String custSeq
	 * @return String
	 * @exception EventException
	 */
	public String checkCntcPnt(String custCntCd, String custSeq) throws EventException {
		DBRowSet rowSet = null;
		String check = "";
		try {
			rowSet = dbDao.checkCntcPnt(custCntCd, custSeq);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		check = rowSet.getString(1);
            	}
            }
            return check;
	
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESM_SAM_0302 : manage<br>
	 * Check Contact Point
	 * @param String custCntCd 
	 * @param String custSeq
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public void addCustHist(String custCntCd, String custSeq, String usrId) throws EventException {
		try {
			dbDao.addCustHist(custCntCd, custSeq, usrId);
	
		}catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * Modify/save/delete event process<br>
	 * Customer Code Creation (ESM_SAM_0302.do)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageCustCode(CustomerIntegrationVO custIntgVO,  SignOnUserAccount account) throws EventException {
		try {
			CustomerVO customerVO = custIntgVO.getCustomerVO();
			log.debug("\nmanageCustCode================================"+customerVO.getIbflag());
			/*if(customerVO.getIbflag().equals("I")){
				customerVO.setCreUsrId(account.getUsr_id());
				customerVO.setUpdUsrId(account.getUsr_id());
				
				log.debug("\nsearchMAXCustomerSeq================================"+customerVO.getIbflag());
				
				int ld_cust_seq = searchMAXCustomerSeq(customerVO.getCustCntCd());
				//log.debug("\nsearchMAXCustomerSeq================================"+ld_cust_seq);
				customerVO.setCustSeq(ld_cust_seq+"");
				log.debug("\nsearchMAXCustomerSeq================================"+customerVO.getCustSeq());
				dbDao.addCustCode(customerVO);
			}
			else */
			if(customerVO.getIbflag().equals("U")){
				Integer ld_cust_his_seq = searchCntCustHisSeq(customerVO.getCustCntCd(), customerVO.getCustSeq());
				
				if (ld_cust_his_seq==0) {
					dbDao.addCustHistMig(customerVO.getCustCntCd(), customerVO.getCustSeq(), account.getUsr_id());
				}
				
				customerVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyCustCode(customerVO);	
				dbDao.modifyCustGroupSrepCode(customerVO);
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
	 * Modify/save/delete event process<br>
	 * Customer Code Creation (ESM_SAM_0302.do)<br>
	 * 
	 * @param CustomerIntegrationVO custIntgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageGstCustCode(CustomerIntegrationVO custIntgVO,  SignOnUserAccount account) throws EventException {
		try {
			CustomerVO customerVO = custIntgVO.getCustomerVO();
			log.debug("\nmanageCustCode================================"+customerVO.getIbflag());
			if(customerVO.getIbflag().equals("U")){
				Integer ld_cust_his_seq = searchCntCustHisSeq(customerVO.getCustCntCd(), customerVO.getCustSeq());
				
				if (ld_cust_his_seq==0) {
					dbDao.addCustHistMig(customerVO.getCustCntCd(), customerVO.getCustSeq(), account.getUsr_id());
				}
				
				customerVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyGstCustCode(customerVO);	
		    }
			
			return customerVO;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Customer Address retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception EventException
	 */
	public List<CustomerAddressVO> searchCustAddr(String custCntCd, String custSeq, String addrTpCd) throws EventException {
		
		try {
			return dbDao.searchCustAddr(custCntCd, custSeq, addrTpCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * Customer Address retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<HistMainVO>
	 * @exception EventException
	 */
	public List<BlHistVO> searchCustHist(String custCntCd, String custSeq) throws EventException {
		
		try {
			return dbDao.searchCustHist(custCntCd, custSeq);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
    /**
     * funcion : return default combo,ibsheet codelist<p>
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
    public GeneralEventResponse searchCommonCodeList(GeneralEventResponse eventResponse,String[][] array) throws EventException {
    	List<ComboListVO> list = new ArrayList<ComboListVO>();
    	ComboListVO combovo = new ComboListVO();
 	    
 	    try {
	    	for(int i=0 ; i< array.length ; i++) {
	    		list = searchCodeList((array[i][0]).toString());
	    		if ("All".equals(array[i][2])){
	    			combovo.setCd("ALL");
	    	 	    combovo.setCdDesc("ALL");
	    	 	    combovo.setCdEtc("ALL");
	    			list.add(0,combovo);
	    		}else if ("Blank".equals(array[i][2])){
	    			combovo.setCd(" ");
	    	 	    combovo.setCdDesc(" ");
	    	 	    combovo.setCdEtc(" ");
	    			list.add(0,combovo);
	    		}
	    		eventResponse.setRsVoList(list);
	    	}
 	   } catch(Exception ex){
 		   log.error("Exception : " +ex.getMessage());
 		   throw new EventException("Exception : " + ex.getMessage());
       }
 	   return eventResponse;
	}
    
	/**
	 * Customer Code retrieve.(ESM_SAM_0302)<br>
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
	 * Customer Code retrieve.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchLocSteCode(String locCd) throws EventException {
		
		try {
			return dbDao.searchLocSteCode(locCd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
    
	  /**
     * 1. function : return default combo,ibsheet codelist  <p>
     * 
     * @param codeItem      	
     * @return List<ComboListVO>
     * @throws EventException
     */
	public List<ComboListVO> searchCodeList(String codeItem) throws EventException {
		List<ComboListVO> list = new ArrayList<ComboListVO>();
    	DBRowSet dRs = null;
	        try {
	        	if(codeItem.equalsIgnoreCase("Conti")){				    	 // 1. Continent code List
	        		dRs = dbDao.searchContiCode();
	        	}else if(codeItem.equalsIgnoreCase("GrpCmdt")){				 // 2. Group Commodity List
	        		dRs = dbDao.searchGrpCmdtList();
	        	}else if(codeItem.equalsIgnoreCase("RepCmdt")){				 // 3. Repository Commodity List
	        		dRs = dbDao.searchRepCmdtList();
	        	}else if(codeItem.equalsIgnoreCase("RepChg")){				 // 4. Rep. Charge Code List
	        		dRs = dbDao.searchRepChgCode();
	        	}else if(codeItem.equalsIgnoreCase("SubTrade")){			 // 5. Sub Trade Code List
	        		dRs = dbDao.searchSubTradeCode();
	        	}else if(codeItem.equalsIgnoreCase("Trade")){				 // 6. Trade Code List
	        		dRs = dbDao.searchTradeCode();
	        	}else if(codeItem.equalsIgnoreCase("CntrSize")){			 // 7. Container Size Code List
	        		dRs = dbDao.searchCntrSize();
	        	}else if(codeItem.equalsIgnoreCase("CntrType")){	     	 // 8. Container Type Code List
	        		dRs = dbDao.searchCntrType();
	        	}else if(codeItem.equalsIgnoreCase("CntrTpSz")){	     	 // 9. Container Type/Size Code List
	        		dRs = dbDao.searchCntrTypeSize();
	        	}else if(codeItem.equalsIgnoreCase("Package")){	     	 	 // 10. Package Code List
	        		dRs = dbDao.searchPackage();
	        	}else if(codeItem.equalsIgnoreCase("Office")){	     	 	 // 11. Office Code List
		        	dRs = dbDao.searchOffice();
	        	}else if(codeItem.equalsIgnoreCase("IndState")){	     	 // 12. India GST State List
		        	dRs = dbDao.searchIndState();
	        	}else if(codeItem.equalsIgnoreCase("IntlPhnNo")){	     	 // 13. INTERNATIONAL PHN NO
		        	dRs = dbDao.searchIntlPhnNo();
	        	}else{
        	    //common code
        	    	Collection codeList2 = null; 
        	    	codeList2 = com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(codeItem,0);
        	    	Iterator iterator = codeList2.iterator();	        		
	                 
	        		com.hanjin.framework.component.util.code.CodeInfo codeModel2 = null;
	    			while (iterator.hasNext()) {
	    				codeModel2 = (com.hanjin.framework.component.util.code.CodeInfo) iterator.next();
	    				if (codeModel2 != null){
	    					ComboListVO vo = new ComboListVO();
		    				vo.setCd(codeModel2.getCode());
		    				vo.setCdDesc(codeModel2.getName());
		    				vo.setCdEtc("");
		    				list.add(vo);
	    				}
	    			}
	        	}
	        	
	        	if (dRs != null){
	        		list = (List) RowSetUtil.rowSetToVOs(dRs, ComboListVO.class);
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



}
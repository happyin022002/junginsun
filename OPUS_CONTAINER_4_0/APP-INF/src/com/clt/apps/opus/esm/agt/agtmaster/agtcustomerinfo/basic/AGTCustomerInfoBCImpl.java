/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerInfoBCImpl.java
*@FileTitle : Agent Commission Customer Information Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.basic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.integration.AGTCustomerInfoDBDAO;
import com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.integration.AGTCustomerInfoEAIDAO;
import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtBrogCustIntVO;
import com.clt.syscommon.common.table.AgtBrogCustMtchVO;
import com.clt.syscommon.common.table.AgtFacCustRltVO;


/**
 * OPUS-AGT Business Logic Basic Command implementation<br>
 * - OPUS-AGT handling Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see AGTCustomerInfoDAO
 * @since J2EE 1.4
 */
public class AGTCustomerInfoBCImpl extends BasicCommandSupport implements AGTCustomerInfoBC {

	// Database Access Object
	private transient AGTCustomerInfoDBDAO dbDao=null;

	// EAI Interface Database Access Object
	private transient AGTCustomerInfoEAIDAO eaiDao=null;

	/**
	 * AGTOfficeInfoBCImpl Object creation<br>
	 * AGTOfficeInfoDBDAO creation<br>
	 * AGTCustomerInfoEAIDAO creation<br>	 * 
	 */
	public AGTCustomerInfoBCImpl(){
		dbDao = new AGTCustomerInfoDBDAO();
		eaiDao = new AGTCustomerInfoEAIDAO();
		
	}

	/**
	 * retrieve event process<br>
	 * ESM_AGT_0025 retrieve event process<br>
	 * 
	 * @param AgtBrogCustMtchVO agtBrogCustMtchVO
	 * @return List<AgtBrogCustMtchVO
	 * @exception EventException
	 */
	public List<AgtBrogCustMtchVO> searchFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO agtBrogCustMtchVO) throws EventException {
		try {
			return dbDao.searchFForwarderVendorMatchingInfoForBrokerage(agtBrogCustMtchVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * multi event process<br>
	 * ESM_AGT_0025 multi event process<br>
	 * 
	 * @param AgtBrogCustMtchVO[] agtBrogCustMtchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO[] agtBrogCustMtchVOs, SignOnUserAccount account) throws EventException {
		try{
			List<AgtBrogCustMtchVO> insList = new ArrayList<AgtBrogCustMtchVO>();
			List<AgtBrogCustMtchVO> updList = new ArrayList<AgtBrogCustMtchVO>();
			List<AgtBrogCustMtchVO> delList = new ArrayList<AgtBrogCustMtchVO>();
			
			//Customer/Vendor Check
            CommonBC cbc = new CommonBCImpl();
            
            String cust_cnt_cd = "";
            String cust_nm = "";
            String vndr_seq = "";
            String vndr_nm = "";
            
			for(int i=0; i<agtBrogCustMtchVOs.length; i++){
				if(agtBrogCustMtchVOs[i].getIbflag().equals("I")){
					cust_cnt_cd = cbc.searchCode("C", "C", agtBrogCustMtchVOs[i].getCustCntFf());
					cust_nm = cbc.searchCode("C", "N", agtBrogCustMtchVOs[i].getCustCntFf());
					vndr_seq = cbc.searchCode("V", "C", agtBrogCustMtchVOs[i].getVndrSeq());
					vndr_nm = cbc.searchCode("V", "N", agtBrogCustMtchVOs[i].getVndrSeq()); 
					
					agtBrogCustMtchVOs[i].setCreUsrId(account.getUsr_id());
					agtBrogCustMtchVOs[i].setUpdUsrId(account.getUsr_id());
					agtBrogCustMtchVOs[i].setCustCntCd(cust_cnt_cd.substring(0, 2));
					agtBrogCustMtchVOs[i].setCustSeq(cust_cnt_cd.substring(2));
					agtBrogCustMtchVOs[i].setVndrCntCd(vndr_seq.substring(0, 2));
					agtBrogCustMtchVOs[i].setVndrSeq(vndr_seq.substring(2));
					agtBrogCustMtchVOs[i].setCustNm(cust_nm);
					agtBrogCustMtchVOs[i].setVndrNm(vndr_nm);
					
					insList.add(agtBrogCustMtchVOs[i]);
				}else if(agtBrogCustMtchVOs[i].getIbflag().equals("U")){
					cust_cnt_cd = cbc.searchCode("C", "C", agtBrogCustMtchVOs[i].getCustCntFf());
					cust_nm = cbc.searchCode("C", "N", agtBrogCustMtchVOs[i].getCustCntFf());
					vndr_seq = cbc.searchCode("V", "C", agtBrogCustMtchVOs[i].getVndrSeq());
					vndr_nm = cbc.searchCode("V", "N", agtBrogCustMtchVOs[i].getVndrSeq()); 
					
					agtBrogCustMtchVOs[i].setCreUsrId(account.getUsr_id());
					agtBrogCustMtchVOs[i].setUpdUsrId(account.getUsr_id());
					agtBrogCustMtchVOs[i].setCustCntCd(cust_cnt_cd.substring(0, 2));
					agtBrogCustMtchVOs[i].setCustSeq(cust_cnt_cd.substring(2));
					agtBrogCustMtchVOs[i].setVndrCntCd(vndr_seq.substring(0, 2));
					agtBrogCustMtchVOs[i].setVndrSeq(vndr_seq.substring(2));
					agtBrogCustMtchVOs[i].setCustNm(cust_nm);
					agtBrogCustMtchVOs[i].setVndrNm(vndr_nm);
					log.info("\n <<<agtBrogCustMtchVOs[i]>>>"+agtBrogCustMtchVOs[i]);
					updList.add(agtBrogCustMtchVOs[i]);
				}else if(agtBrogCustMtchVOs[i].getIbflag().equals("D")){
					delList.add(agtBrogCustMtchVOs[i]);
				}
			}
			
			if(insList.size() > 0){
				dbDao.addFForwarderVendorMatchingInfoForBrokerage(insList);
			}
			log.info("\n <<<<updList.size()>>>="+updList.size());
			if(updList.size() > 0){
				log.info("\n <<<updList>>="+updList);
				dbDao.modifyFForwarderVendorMatchingInfoForBrokerage(updList);
			}
			
			if(delList.size() > 0 ){
				dbDao.deleteFForwarderVendorMatchingInfoForBrokerage(delList);
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("AGT00027", new String[]{"F/Forward, Vender"}).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_AGT_0026 retrieve event process<br>
	 * @param AgtBrogCustIntVO agtBrogCustIntVO
	 * @return List<AgtBrogCustIntVO
	 * @exception EventException
	 */
	public List<AgtBrogCustIntVO> searchBRKGCustomerToShipperInterestList(AgtBrogCustIntVO agtBrogCustIntVO) throws EventException {
		try {
			return dbDao.searchBRKGCustomerToShipperInterestList(agtBrogCustIntVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_AGT_0026 Multi event process<br>
	 * @param AgtBrogCustIntVO[] agtBrogCustIntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBRKGCustomerToShipperInterestInfo(AgtBrogCustIntVO[] agtBrogCustIntVOs, SignOnUserAccount account) throws EventException {
		try {
			List<AgtBrogCustIntVO> insList = new ArrayList<AgtBrogCustIntVO>();
			List<AgtBrogCustIntVO> updList = new ArrayList<AgtBrogCustIntVO>();
			List<AgtBrogCustIntVO> delList = new ArrayList<AgtBrogCustIntVO>();
			
			CommonBC cbc = new CommonBCImpl();
                        
            for(int i=0; i<agtBrogCustIntVOs.length; i++){
            	String cust_cd2 = cbc.searchCode("C", "C", agtBrogCustIntVOs[i].getCustCd());	//Freight Forwarder Customer Code
                String cust_nm2 = cbc.searchCode("C", "N", agtBrogCustIntVOs[i].getCustCd());	//Freight Forwarder Customer Name
                String shpr_cd2 = cbc.searchCode("C", "C", agtBrogCustIntVOs[i].getShprCd());	//Shipper Customer Code
                String shpr_nm2 = cbc.searchCode("C", "N", agtBrogCustIntVOs[i].getShprCd());	//Shipper Customer Name
                if(agtBrogCustIntVOs[i].getIbflag().equals("I")){
                	agtBrogCustIntVOs[i].setCustCntCd(cust_cd2.substring(0, 2));
                	agtBrogCustIntVOs[i].setCustSeq(cust_cd2.substring(2));
                	agtBrogCustIntVOs[i].setShprCntCd(shpr_cd2.substring(0, 2));
                	agtBrogCustIntVOs[i].setShprSeq(shpr_cd2.substring(2));
                	agtBrogCustIntVOs[i].setCustNm(cust_nm2);
                	agtBrogCustIntVOs[i].setShprNm(shpr_nm2);
                	agtBrogCustIntVOs[i].setCreUsrId(account.getUsr_id());
                	agtBrogCustIntVOs[i].setUpdUsrId(account.getUsr_id());
                	
                	log.info("\n <<<agtBrogCustIntVOs[i]>>="+agtBrogCustIntVOs[i]);
                	insList.add(agtBrogCustIntVOs[i]);
                }else if(agtBrogCustIntVOs[i].getIbflag().equals("U")){
                	agtBrogCustIntVOs[i].setCustCntCd(cust_cd2.substring(0, 2));
                	agtBrogCustIntVOs[i].setCustSeq(cust_cd2.substring(2));
                	agtBrogCustIntVOs[i].setShprCntCd(shpr_cd2.substring(0, 2));
                	agtBrogCustIntVOs[i].setShprSeq(shpr_cd2.substring(2));
                	agtBrogCustIntVOs[i].setCustNm(cust_nm2);
                	agtBrogCustIntVOs[i].setShprNm(shpr_nm2);
                	agtBrogCustIntVOs[i].setUpdUsrId(account.getUsr_id());
                	
                	log.info("\n <<<agtBrogCustIntVOs[i]>>="+agtBrogCustIntVOs[i]);
                	updList.add(agtBrogCustIntVOs[i]);
                }else if(agtBrogCustIntVOs[i].getIbflag().equals("D")){
                	delList.add(agtBrogCustIntVOs[i]);
                }
            }
            
            if(insList.size() > 0){
            	log.info("\n <<<insList>>>="+insList);
            	dbDao.addBRKGCustomerToShipperInterestInfo(insList);
            }
            
            if(updList.size() > 0){
            	dbDao.modifyBRKGCustomerToShipperInterestInfo(updList);
            }
            
            if(delList.size() > 0){
            	dbDao.deleteBRKGCustomerToShipperInterestInfo(delList);
            }
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("AGT00027", new String[]{"F/Forward, Shipper"}).getMessage());
			
//			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESM_AGT_030 retrieve event process<br>
	 * @param AgtFacCustRltVO agtFacCustRltVO
	 * @return List<AgtFacCustRltVO
	 * @exception EventException
	 */
	public List<AgtFacCustRltVO> searchFACCustomerToShipperInterestList(AgtFacCustRltVO agtFacCustRltVO ) throws EventException {
		try {
			return dbDao.searchFACCustomerToShipperInterestList(agtFacCustRltVO);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * ESM_AGT_030 multi event process<br>
	 * @param AgtFacCustRltVO[] agtFacCustRltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
    public void multiFACCustomerToShipperInterestList(AgtFacCustRltVO[] agtFacCustRltVOs, SignOnUserAccount account) throws EventException {
	    try{
	    	List<AgtFacCustRltVO> insList = new ArrayList<AgtFacCustRltVO>();
			List<AgtFacCustRltVO> updList = new ArrayList<AgtFacCustRltVO>();
			List<AgtFacCustRltVO> delList = new ArrayList<AgtFacCustRltVO>();
			
			//sysdate
	        String sCre_dt = null;
	        

			ArrayList array = new ArrayList();
			
			CommonBC cbc = new CommonBCImpl();
			for(int i=0; i<agtFacCustRltVOs.length; i++){
            	String cust_cd2 = cbc.searchCode("C", "C", agtFacCustRltVOs[i].getCustCdSeq());	//Freight Forwarder Customer Code
                String cust_nm2 = cbc.searchCode("C", "N", agtFacCustRltVOs[i].getCustCdSeq());	//Freight Forwarder Customer Name
                String shpr_cd2 = cbc.searchCode("C", "C", agtFacCustRltVOs[i].getShprCdSeq());	//Shipper Customer Code
                String shpr_nm2 = cbc.searchCode("C", "N", agtFacCustRltVOs[i].getShprCdSeq());	//Shipper Customer Name
                if(agtFacCustRltVOs[i].getIbflag().equals("I")){
                	agtFacCustRltVOs[i].setCustCntCd(cust_cd2.substring(0, 2));
                	agtFacCustRltVOs[i].setCustSeq(cust_cd2.substring(2));
                	agtFacCustRltVOs[i].setShprCntCd(shpr_cd2.substring(0, 2));
                	agtFacCustRltVOs[i].setShprSeq(shpr_cd2.substring(2));
                	agtFacCustRltVOs[i].setCustNm(cust_nm2);
                	agtFacCustRltVOs[i].setShprNm(shpr_nm2);
                	agtFacCustRltVOs[i].setCreUsrId(account.getUsr_id());
                	agtFacCustRltVOs[i].setUpdUsrId(account.getUsr_id());
                	
                	log.info("\n <<<agtBrogCustIntVOs[i]>>="+agtFacCustRltVOs[i]);
                	insList.add(agtFacCustRltVOs[i]);
                }else if(agtFacCustRltVOs[i].getIbflag().equals("U")){
                	agtFacCustRltVOs[i].setCustCntCd(cust_cd2.substring(0, 2));
                	agtFacCustRltVOs[i].setCustSeq(cust_cd2.substring(2));
                	agtFacCustRltVOs[i].setShprCntCd(shpr_cd2.substring(0, 2));
                	agtFacCustRltVOs[i].setShprSeq(shpr_cd2.substring(2));
                	agtFacCustRltVOs[i].setCustNm(cust_nm2);
                	agtFacCustRltVOs[i].setShprNm(shpr_nm2);
                	agtFacCustRltVOs[i].setUpdUsrId(account.getUsr_id());
                	
                	log.info("\n <<<agtBrogCustIntVOs[i]>>="+agtFacCustRltVOs[i]);
                	updList.add(agtFacCustRltVOs[i]);
                }else if(agtFacCustRltVOs[i].getIbflag().equals("D")){
                	delList.add(agtFacCustRltVOs[i]);
                }
            }
            
            if(insList.size() > 0){
            	log.info("\n <<<insList>>>="+insList);
            	dbDao.addFACCustomerToShipperInterestList(insList);
            }
            
            if(updList.size() > 0){
            	dbDao.updateFACCustomerToShipperInterestList(updList);
            }
            
            if(delList.size() > 0){
            	dbDao.deleteFACCustomerToShipperInterestList(delList);
            }
            
            for(int j=0; j<agtFacCustRltVOs.length; j++){
            	// get sysdate
		        sCre_dt	= (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Timestamp(Calendar.getInstance().getTimeInMillis())); 
            	// data setting for EAI 
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("FACOFCCD", agtFacCustRltVOs[j].getFacOfcCd());
				map.put("CUSTCNTCD", agtFacCustRltVOs[j].getCustCntCd());
				map.put("CUSTSEQ", agtFacCustRltVOs[j].getCustSeq());
				map.put("SHPRCNTCD", agtFacCustRltVOs[j].getShprCntCd());
				map.put("SHPRSEQ", agtFacCustRltVOs[j].getShprSeq());
				map.put("CUSTNM", agtFacCustRltVOs[j].getCustNm());					
				map.put("SHPRNM", agtFacCustRltVOs[j].getShprNm());
				map.put("CREUSRID", account.getUsr_id());					
				map.put("CREDT", sCre_dt);
				map.put("CUSTCNTCDOLD", agtFacCustRltVOs[j].getCustCntCd2());
				map.put("CUSTSEQOLD", agtFacCustRltVOs[j].getCustSeq2());
				map.put("SHPRCNTCDOLD", agtFacCustRltVOs[j].getShprCntCd2());
				map.put("SHPRSEQOLD", agtFacCustRltVOs[j].getShprSeq2());
				map.put("OPCD", agtFacCustRltVOs[j].getIbflag());
				
				array.add(map);
				
//				eaiDao.multiFACCustomerToShipperInterestInfoInf(array);
            }
	    }catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("AGT00064", new String[]{"F/Forward, Shipper"}).getMessage());
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
    }

	/**
	 * agt biz scenario closing<br>
	 * biz scenario closing<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	

	

	

	
}
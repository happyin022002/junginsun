/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOfficeInfoBCImpl.java
*@FileTitle : China Outbound Agent Information management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration.AGTOfficeInfoDBDAO;
import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtChnLaneAgnVO;
import com.clt.syscommon.common.table.AgtChnVslAgnVO;
import com.clt.syscommon.common.table.BkgChnAgnVO;

/**
 * OPUS-AGTMaster Business Logic Basic Command implementation<br>
 * - OPUS-AGTMaster handling Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see ESM_AGT_022EventResponse,AGTOfficeInfoBC 
 * @since J2EE 1.6
 */
public class AGTOfficeInfoBCImpl extends BasicCommandSupport implements AGTOfficeInfoBC {

	// Database Access Object
	private transient AGTOfficeInfoDBDAO dbDao = null;

	/**
	 * AGTOfficeInfoBCImpl object creation<br>
	 * AGTOfficeInfoDBDAO를 creation.<br>
	 */
	public AGTOfficeInfoBCImpl() {
		dbDao = new AGTOfficeInfoDBDAO();
	}
	/**
	 * (ESM_AGT_022) China Outbound Agent Information retrieve event process<br>
	 * @param BkgChnAgnVO bkgChinaAgentVO
	 * @return List<BkgChnAgnVO>
	 * @exception EventException
	 */
	public List<BkgChnAgnVO> searchChinaBKGAgentList(BkgChnAgnVO bkgChinaAgentVO) throws EventException {
		try {
			return dbDao.searchChinaBKGAgentList(bkgChinaAgentVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	 /**
	 * (ESM_AGT_022)China Outbound Agent Information multi event process <br>
	 * @param BkgChinaAgentVO[] bkgChnAgnVOS
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void multiChinaBKGAgentList(BkgChinaAgentVO[] bkgChnAgnVOS,SignOnUserAccount account) throws EventException{
		try {
			log.debug("bkgChnAgnVOS.length:"+bkgChnAgnVOS.length);
			com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC bkgCommand
			= new com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl();

			//Code Check
			CommonBC cbc = new CommonBCImpl();
			String[] vndrSeq = new String[1];
			String[] vndrSeqStatus = new String[1];
			String[] rtnValue = new String[5];
			String vendorValue = "";
			//Code Check. End
			
			for ( int i=0; i<bkgChnAgnVOS .length; i++ ) {
				if ( bkgChnAgnVOS[i].getIbflag().equals("I")){
					vndrSeq[0] = bkgChnAgnVOS[i].getVndrSeq();
					vndrSeqStatus = cbc.searchCodeList("V", "C", vndrSeq);	//Vendor Code;
					if(!"CN".equals(vndrSeqStatus[0].substring(0, 2))) {
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vendor"}).getMessage());
					}
					vendorValue = this.searchAgentVendor(bkgChnAgnVOS[i].getVndrSeq(), bkgChnAgnVOS[i].getChnAgnCd());
					if(!"0".equals(vendorValue)){
						throw new DAOException(new ErrorHandler("AGT00081", new String[]{"Vendor Code"}).getMessage());
					}
					log.info("\n  vndrSeqStatus="+vndrSeqStatus[0]);
					log.info("\n  bkgChnAgnVOS ahg-agn_cd="+bkgChnAgnVOS[i].getChnAgnCd());
					
					rtnValue = dbDao.searchMdmVendor(bkgChnAgnVOS[i].getVndrSeq());
					bkgChnAgnVOS[i].setVndrCntCd(rtnValue[0]); //vndr_cnt_cd
					bkgChnAgnVOS[i].setVndrSeq(rtnValue[1]); // vndr_seq
					//bkgChnAgnVOS[i].setCustCntCd(rtnValue[2]); // prnt_cnt_cd
					//bkgChnAgnVOS[i].setCustSeq(rtnValue[3]); // prnt_vndr_seq
					bkgChnAgnVOS[i].setOfcCd(rtnValue[4]); // ofc_cd
					
					bkgChnAgnVOS[i].setVndrCntCd(vndrSeqStatus[0].substring(0, 2));
					bkgChnAgnVOS[i].setCreUsrId(account.getUsr_id());
					bkgChnAgnVOS[i].setUpdUsrId(account.getUsr_id());
					log.info("\n  bkgChnAgnVOS="+bkgChnAgnVOS[i]);
					//insertVoList.add(bkgChnAgnVOS[i]);
				} else if ( bkgChnAgnVOS[i].getIbflag().equals("U")){
					
					vndrSeq[0] = bkgChnAgnVOS[i].getVndrSeq();
					vndrSeqStatus = cbc.searchCodeList("V", "C", vndrSeq);	//Vendor Code;
					if(!"CN".equals(vndrSeqStatus[0].substring(0, 2))) {
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vendor"}).getMessage());
					}
					
					vendorValue = this.searchAgentVendor(bkgChnAgnVOS[i].getVndrSeq(), bkgChnAgnVOS[i].getChnAgnCd());
					if(!"0".equals(vendorValue)){
						throw new DAOException(new ErrorHandler("AGT00081", new String[]{"Vendor Code"}).getMessage());
						//throw new EventException(new ErrorHandler("Vendor Code does already exist! Please check up!").getMessage());
					}
					
					rtnValue = dbDao.searchMdmVendor(bkgChnAgnVOS[i].getVndrSeq());
					bkgChnAgnVOS[i].setVndrCntCd(rtnValue[0]); //vndr_cnt_cd
					bkgChnAgnVOS[i].setVndrSeq(rtnValue[1]); // vndr_seq
					//bkgChnAgnVOS[i].setCustCntCd(rtnValue[2]); // prnt_cnt_cd
					//bkgChnAgnVOS[i].setCustSeq(rtnValue[3]); // prnt_vndr_seq
					bkgChnAgnVOS[i].setOfcCd(rtnValue[4]); // ofc_cd
					
					bkgChnAgnVOS[i].setUpdUsrId(account.getUsr_id());
					//updateVoList.add(bkgChnAgnVOS[i]);
				} else if ( bkgChnAgnVOS[i].getIbflag().equals("D")){
					bkgChnAgnVOS[i].setUpdUsrId(account.getUsr_id());
					//deleteVoList.add(bkgChnAgnVOS[i]);
				}
			}

			bkgCommand.manageChinaAgentCode(bkgChnAgnVOS,account);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
			//throw new EventException(new ErrorHandler("AGT00027", new String[]{"Agent"}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * (ESM_AGT_022) China Outbound Agent Information retrieve event process<br>
	 * @param AgtChnLaneAgnVO agtChnLaneAgnVO
	 * @return List<AgtChnLaneAgnVO>
	 * @exception EventException
	 */
	public List<AgtChnLaneAgnVO> searchLaneInboundAgentList(
			AgtChnLaneAgnVO agtChnLaneAgnVO) throws EventException {
		try{
			return dbDao.searchLaneInboundAgentList(agtChnLaneAgnVO);
		}catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * (ESM_AGT_022) China Outbound Agent Information multi event process<br>
	 * @param AgtChnLaneAgnVO[] agtChnLaneAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void multiLaneInboundAgentList(AgtChnLaneAgnVO[] agtChnLaneAgnVO,
			SignOnUserAccount account) throws EventException {
		 
		try{
			List<AgtChnLaneAgnVO> insertVoList = new ArrayList<AgtChnLaneAgnVO>();
			List<AgtChnLaneAgnVO> updateVoList = new ArrayList<AgtChnLaneAgnVO>();
			List<AgtChnLaneAgnVO> deleteVoList = new ArrayList<AgtChnLaneAgnVO>();
			
			//Code Check
            CommonBC cbc = new CommonBCImpl();
			String[] vndrSeq = new String[1];
			String[] vndrSeqStatus = new String[1];
			//String[] rtnValue = new String[5];
			
			for(int i=0; i<agtChnLaneAgnVO.length; i++){
				
				
//	            String[] cust_cd = cbc.searchCodeList("C", "C", agn_cnt_cd);		//Customer Code;
	            //Code Check. End
	            
//				rtnValue = dbDao.SearchMdmVendor(agtChnLaneAgnVO[i].getAgnVndrSeq());
				if(agtChnLaneAgnVO[i].getIbflag().equals("I")){
					vndrSeq[0] = agtChnLaneAgnVO[i].getAgnVndrSeq();
					vndrSeqStatus = cbc.searchCodeList("V", "C", vndrSeq);	//Vendor Code;
					if(vndrSeqStatus.equals(new ErrorHandler("AGT00027", new String[]{"Vendor Code"}).getMessage())) {
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vendor Code"}).getMessage());
					}
					String agn_cnt_cd = agtChnLaneAgnVO[i].getCustCd().substring(0,2); 
					String agn_cust_seq = agtChnLaneAgnVO[i].getCustCd().substring(2);
					agtChnLaneAgnVO[i].setCreUsrId(account.getUsr_id());
					agtChnLaneAgnVO[i].setUpdUsrId(account.getUsr_id());
					agtChnLaneAgnVO[i].setAgnCntCd(agn_cnt_cd);
					agtChnLaneAgnVO[i].setAgnCustSeq(agn_cust_seq);
					insertVoList.add(agtChnLaneAgnVO[i]);
				} else if ( agtChnLaneAgnVO[i].getIbflag().equals("U")){
					vndrSeq[0] = agtChnLaneAgnVO[i].getAgnVndrSeq();
//					log.info("\n vndrSeq[0]="+vndrSeq[0]);
					vndrSeqStatus = cbc.searchCodeList("V", "C", vndrSeq);	//Vendor Code;
					if(vndrSeqStatus.equals(new ErrorHandler("AGT00027", new String[]{"Vendor Code"}).getMessage())) {
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vendor Code"}).getMessage());
					}
					String agn_cnt_cd = agtChnLaneAgnVO[i].getCustCd().substring(0,2); 
					String agn_cust_seq = agtChnLaneAgnVO[i].getCustCd().substring(2);
					String old_pod_cd = agtChnLaneAgnVO[i].getOldPodCd();
//					String agn_vndr_seq = agtChnLaneAgnVO[i].getAgnVndrSeq(); 
					
					
					
					log.info("\n  <<old_pod_cd=="+old_pod_cd+"\n");
					agtChnLaneAgnVO[i].setUpdUsrId(account.getUsr_id());
					agtChnLaneAgnVO[i].setAgnCntCd(agn_cnt_cd);
					agtChnLaneAgnVO[i].setAgnCustSeq(agn_cust_seq);
					
					updateVoList.add(agtChnLaneAgnVO[i]);
				} else if ( agtChnLaneAgnVO[i].getIbflag().equals("D")){
					log.info("\n agtChnLaneAgnVO slan cd = "+agtChnLaneAgnVO[i].getSlanCd());
					deleteVoList.add(agtChnLaneAgnVO[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addmultiLaneInboundAgentList(insertVoList);
			}
			
			if(updateVoList.size() > 0){
				dbDao.modifymultiLaneInboundAgentList(updateVoList);
			}
			
			if(deleteVoList.size() > 0){
				dbDao.deletemultiLaneInboundAgentList(deleteVoList);
			}
		}catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel information retrieve event process<br>
	 * @param AgtChnVslAgnVO agtChnVslAgnVO
	 * @return List<AgtChnVslAgnVO>
	 * @exception EventException
	 */
	public List<AgtChnVslAgnVO> searchInboundChinaOfficeInfoForVessel(
			AgtChnVslAgnVO agtChnVslAgnVO) throws EventException {
		try {
			return dbDao.searchInboundChinaOfficeInfoForVessel(agtChnVslAgnVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel information multi event process<br>
	 * @param AgtChnVslAgnVO[] agtChnVslAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiInboundChinaOfficeInfoForVessel(AgtChnVslAgnVO[] agtChnVslAgnVO, 
			SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try{
//			log.error("aqaqaqaq");
			List<AgtChnVslAgnVO> insertVoList = new ArrayList<AgtChnVslAgnVO>();
			List<AgtChnVslAgnVO> updateVoList = new ArrayList<AgtChnVslAgnVO>();
			//List<AgtChnVslAgnVO> deleteVoList = new ArrayList<AgtChnVslAgnVO>();
			
			//Code Check
			CommonBC cbc = new CommonBCImpl();
			
			
			//Code Check. End
			
			for(int i=0; i<agtChnVslAgnVO.length; i++){
				String[] vndrSeq = new String[1];
				String[] vndrSeqStatus = new String[1];
				
				String[] custCd = new String[1];
				String[] custCdStatus = new String[1];
				
				if(agtChnVslAgnVO[i].getIbflag().equals("I")){
					String agn_cnt_cd = agtChnVslAgnVO[i].getCustCd().substring(0,2); 
					String agn_cust_seq = agtChnVslAgnVO[i].getCustCd().substring(2);
//					log.info("agn_cnt_cd == " + agn_cnt_cd);
					agtChnVslAgnVO[i].setCreUsrId(account.getUsr_id());
					agtChnVslAgnVO[i].setUpdUsrId(account.getUsr_id());
					agtChnVslAgnVO[i].setAgnCntCd(agn_cnt_cd);
					agtChnVslAgnVO[i].setAgnCustSeq(agn_cust_seq);
					
					vndrSeq[0] = agtChnVslAgnVO[i].getAgnVndrSeq();
					vndrSeqStatus = cbc.searchCodeList("V", "C", vndrSeq);	//Vendor Code;
					log.info("\n vndrSeqStatus="+vndrSeqStatus);
					
//					if(vndrSeqStatus.equals(null)) {
//						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vendor Code"}).getMessage());
//					}
					
					custCd[0] = agtChnVslAgnVO[i].getCustCd();
					custCdStatus = cbc.searchCodeList("C", "C",custCd);
					log.info("\n custCdStatus="+custCdStatus);
					
//					if(custCdStatus.equals(null)) {
//						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Customer Code"}).getMessage());
//					}
					
					
					insertVoList.add(agtChnVslAgnVO[i]);
				} else if ( agtChnVslAgnVO[i].getIbflag().equals("U")){
					String agn_cnt_cd = agtChnVslAgnVO[i].getCustCd().substring(0,2); 
					String agn_cust_seq = agtChnVslAgnVO[i].getCustCd().substring(2);
 
					
					vndrSeq[0] = agtChnVslAgnVO[i].getAgnVndrSeq();
					vndrSeqStatus = cbc.searchCodeList("V", "C", vndrSeq);	//Vendor Code;
//					log.info("\n vndrSeqStatus="+vndrSeqStatus);
					
					if(vndrSeqStatus.equals(null)) {
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vendor Code"}).getMessage());
					}
					
					custCd[0] = agtChnVslAgnVO[i].getCustCd();
					custCdStatus = cbc.searchCodeList("C", "C",custCd);
//					log.info("\n custCdStatus="+custCdStatus);
					
					if(custCdStatus.equals(null)) {
						throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Customer Code"}).getMessage());
					}
					
//					log.info("\n  <<old_pod_cd=="+old_pod_cd+"\n");
					agtChnVslAgnVO[i].setUpdUsrId(account.getUsr_id());
					agtChnVslAgnVO[i].setAgnCntCd(agn_cnt_cd);
					agtChnVslAgnVO[i].setAgnCustSeq(agn_cust_seq);
					
					updateVoList.add(agtChnVslAgnVO[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.deletemultiInboundChinaOfficeInfoForVessel(insertVoList);
				dbDao.addmultiInboundChinaOfficeInfoForVessel(insertVoList);
			}
			
			if(updateVoList.size() > 0){
				dbDao.modifymultiInboundChinaOfficeInfoForVessel(updateVoList);
			}
			
		}catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
     * Returning Customer/Vendor Code/Name event process<br>
     *
     * @param  String vndr_seq
     * @param  String chn_agn_cd
     * @return String 
     * @throws EventException
     */
    public String searchAgentVendor(String vndr_seq, String chn_agn_cd) throws EventException{
    	String rtnValue = "";
    	
    	try{
    		rtnValue = dbDao.searchAgentVendor(vndr_seq, chn_agn_cd);
    		
    		return rtnValue;
    		
    	} catch (DAOException de) {
    		log.error("err "+de.toString(),de);
        	throw new EventException(de.getMessage());
        } catch(Exception e){
        	log.error("err "+e.toString(),e);
        	throw new EventException(e.getMessage());
        }
    }

}
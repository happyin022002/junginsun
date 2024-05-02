/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtBCImpl.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtDBDAO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration.TransshipmentMgtEAIDAO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.CntrSumByPodVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SearchCondForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdDetailForPortAssignVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgTsRmkVO;
import com.clt.syscommon.common.table.BkgVslDchgYdVO;
import com.clt.syscommon.common.table.BkgVslOopVO;
import com.clt.syscommon.common.table.BkgVslOpCrrCdVO;
import com.clt.syscommon.common.table.BkgVvdVO;

/**
 * OPUS-TransshipmentMgt Business Logic Basic Command implementation<br>
 * - OPUS-TransshipmentMgt handling business transaction.<br>
 * 
 * @author
 * @see
 * @since J2EE 1.4
 */
public class TransshipmentMgtBCImpl extends BasicCommandSupport implements TransshipmentMgtBC {

	// Database Access Object
	private transient TransshipmentMgtDBDAO dbDao = null;
	private transient TransshipmentMgtEAIDAO dbEaiDao = null;

	/**
	 * Generating TransshipmentMgtBCImpl Object<br>
	 * Generating TransshipmentMgtBCImpl<br>
	 */
	public TransshipmentMgtBCImpl() {
		dbDao = new TransshipmentMgtDBDAO();
		dbEaiDao = new TransshipmentMgtEAIDAO();
	}
	
	/**
	 * saving oop code<br>
	 * 
	 * @param BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOopCode(BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO, SignOnUserAccount account) throws EventException{
		try {
			List<BkgVslOpCrrCdVO> insertVoList = new ArrayList<BkgVslOpCrrCdVO>();
			List<BkgVslOpCrrCdVO> updateVoList = new ArrayList<BkgVslOpCrrCdVO>();
			List<BkgVslOpCrrCdVO> deleteVoList = new ArrayList<BkgVslOpCrrCdVO>();
			for ( int i=0; i<bkgVslOpCrrCdVO .length; i++ ) {
				if ( bkgVslOpCrrCdVO[i].getIbflag().equals("I")){
					bkgVslOpCrrCdVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(bkgVslOpCrrCdVO[i]);
				} else if ( bkgVslOpCrrCdVO[i].getIbflag().equals("U")){
					bkgVslOpCrrCdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgVslOpCrrCdVO[i]);
				} else if ( bkgVslOpCrrCdVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgVslOpCrrCdVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addBkgVslOpCrrCdS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBkgVslOpCrrCdS(updateVoList); 
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBkgVslOpCrrCdS(deleteVoList);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	
	/**
	 * saving oop code<br>
	 * 
	 * @param BkgVslOopVO[] bkgVslOopVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslOopMatch(BkgVslOopVO[] bkgVslOopVO, SignOnUserAccount account) throws EventException{
		try {
			List<BkgVslOopVO> updateVoList = new ArrayList<BkgVslOopVO>();
			List<BkgVslOopVO> deleteVoList = new ArrayList<BkgVslOopVO>();
			
			for ( int i=0; i<bkgVslOopVO.length; i++ ) {
				if ( bkgVslOopVO[i].getIbflag().equals("U")){
					bkgVslOopVO[i].setCreUsrId(account.getUsr_id()); 
					bkgVslOopVO[i].setUpdUsrId(account.getUsr_id()); 	
					updateVoList.add(bkgVslOopVO[i]);
				} else if ( bkgVslOopVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgVslOopVO[i]);
				}
			}
						
			for(int i=0;i<updateVoList.size();i++){ 
				if (dbDao.modifyBkgVslOop(updateVoList.get(i))==0){
					dbDao.addBkgVslOop(updateVoList.get(i));
				}
			}
			
			for(int i=0;i<deleteVoList.size();i++){
				dbDao.removeBkgVslOop(deleteVoList.get(i));
			}
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeBkgVslOopS(deleteVoList);
//			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	
	
	/**
	 * retrieving of bkg_vsl_op_crr_cd<br>
	 * 
	 * @return List<BkgVslOpCrrCdVO>
	 * @exception EventException
	 */
    public List<BkgVslOpCrrCdVO> searchCarrierCode() throws EventException{
    	try {
    		return dbDao.searchOopCode();
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage());
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
    
    /**
	 * retrieving of op_crr_code<br>
	 * 
	 * @param  InputVO inputVO
	 * @return VslOOPVO
	 * @exception EventException
	 */
    public VslOopVO searchVslOopMatch(VslOopInputVO inputVO) throws EventException{
    	try {
    		VslOopVO vslOOPVO = new VslOopVO();
    		vslOOPVO.setVslOopInqVO(dbDao.searchVslOopMatch(inputVO));
    		vslOOPVO.setBkgVslOpCrrCdVO(dbDao.searchOopCode()); 
    		
    		return vslOOPVO;
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	/**
	 * retrieving  crn, uvi no<br>
	 * 
	 * @param  BkgVslDchgYdInputVO bkgVslDchgYdInputVO
	 * @return VslDischargingVO
	 * @exception EventException
	 */
	public VslDischargingVO searchVslDischarging(BkgVslDchgYdInputVO bkgVslDchgYdInputVO) throws EventException {
		try {
			VslDischargingVO vslDischargingVO = new VslDischargingVO();
			vslDischargingVO.setVslDchgYdListVO(dbDao.searchVslDischarging(bkgVslDchgYdInputVO));
			vslDischargingVO.setMdmYardVO(dbDao.searchVslDischargingYard(bkgVslDchgYdInputVO));
			
			return vslDischargingVO;
		 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * Saving  port, CRN No, UVI No<br>
	 * 
	 * @param BkgVslDchgYdVO[] bkgVslDchgYdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslDischarging(BkgVslDchgYdVO[] bkgVslDchgYdVO, SignOnUserAccount account) throws EventException{
		try {
			List<BkgVslDchgYdVO> insertVoList = new ArrayList<BkgVslDchgYdVO>();
			List<BkgVslDchgYdVO> updateVoList = new ArrayList<BkgVslDchgYdVO>();
			List<BkgVslDchgYdVO> deleteVoList = new ArrayList<BkgVslDchgYdVO>();
			for ( int i=0; i<bkgVslDchgYdVO .length; i++ ) {
				if ( bkgVslDchgYdVO[i].getIbflag().equals("I")){
					bkgVslDchgYdVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(bkgVslDchgYdVO[i]);
				} else if ( bkgVslDchgYdVO[i].getIbflag().equals("U")){ 
					bkgVslDchgYdVO[i].setCreUsrId(account.getUsr_id());
					bkgVslDchgYdVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgVslDchgYdVO[i]);
				} else if ( bkgVslDchgYdVO[i].getIbflag().equals("D")){
					deleteVoList.add(bkgVslDchgYdVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addVslDchgYdS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				for(int i=0;i<updateVoList.size();i++){
					if (dbDao.modifyVslDchgYd((BkgVslDchgYdVO)updateVoList.get(i))==0){
						dbDao.addVslDchgYd((BkgVslDchgYdVO)updateVoList.get(i));
					}
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeVslDchgYdS(deleteVoList);
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	/**
	 * Handling retrieving event of booking<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemianListVO> 
	 * @exception EventException
	 */
	public List<TSRemianListVO> searchTSRemainList(TSRemainListInputVO tSRemainListInputVO) throws EventException{
		try {
    		return dbDao.searchTSRemainList(tSRemainListInputVO);
    	 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Handling retrieving event of cntr<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemainSumVO>
	 * @exception EventException
	 */
	public List<TSRemainSumVO> searchTSRemainSumByLoc(TSRemainListInputVO tSRemainListInputVO) throws EventException{
		try {
    		return dbDao.searchTSRemainSumByLoc(tSRemainListInputVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * Handling retrieving event of vessel<br>
	 * 
	 * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO 
	 * @return List<TSListBy1st2ndVVDListVO>
	 * @exception EventException
	 */
	public List<TSListBy1st2ndVVDListVO> searchTSListBy1st2ndVVDList(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException{
		try {
    		return dbDao.searchTSListBy1st2ndVVDList(tSListBy1st2ndVVDListInputVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	/**
	 * Handling retrieving event of vvd<br>
	 * 
     * @param  TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchTSVvdFor1st2nd (TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO) throws EventException{
    	try {
    		return dbDao.searchTSVvdFor1st2nd(tsVvdFor1st2ndInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * fax send event
     * 
     * @param SendTsListVO sendTsListVO
     * @param SignOnUserAccount account
     * @return List<String>
     * @exception EventException
     */
    public List<String> sendTsListByFax (SendTsListVO sendTsListVO,SignOnUserAccount account)throws EventException{
    	try {
    		 StringBuffer sContent=new StringBuffer();
    		 List<CntrSumByPodVO> list = null;
    		 list=dbDao.searchCntrSumByPod(sendTsListVO);
    		 for(int i=0;i<list.size();i++){
    			 sContent.append(list.get(i).getPodCd()).append("    ").append("40' x ")
    			         .append(list.get(i).getFt40()).append(" ,  20' x ").append(list.get(i).getFt20());
    			 if(i>0){
    				 sContent.append("\n");
    			 }
    		 }
    		 
    		 sendTsListVO.setContent(sContent.toString());
    		 return dbEaiDao.sendTsListByFax(sendTsListVO,account);
    	} catch (EAIException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    		 
    }
    
    
    /**
     * email send event
     * 
     * @param SendTsListVO sendTsListVO
     * @param String vvd
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String sendTsListByEmail (SendTsListVO sendTsListVO,String vvd,SignOnUserAccount account)throws EventException{
    	try {
    		StringBuffer sContent=new StringBuffer();
    		 List<CntrSumByPodVO> list = null;
    		 String strVsNm=dbDao.searchTsListTitleVvd(vvd);
    		 sendTsListVO.setRdtitle(strVsNm+" T/S Loading List");
    		 list=dbDao.searchCntrSumByPod(sendTsListVO);
    		 for(int i=0;i<list.size();i++){
    			 sContent.append(list.get(i).getPodCd()).append("    ").append("40' x ").append(list.get(i).getFt40())
    			 .append(" .  20' x ").append(list.get(i).getFt20());
    			 if(i>0){
    				 sContent.append("\n");
    			 }
    		 }
    		  
    		 sendTsListVO.setContent(sContent.toString());
    		 return dbEaiDao.sendTsListByEmail(sendTsListVO,account);
    	} catch (EAIException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    		 
    }
    
    /**
     * retrieving of Cntr Sum<br>
     * 
     * @param  SendTsListVO sendTsListVO
     * @return List<CntrSumByPodVO>
     * @exception EventException
     */
    public List<CntrSumByPodVO> searchCntrSumByPod (SendTsListVO sendTsListVO)throws EventException{
    	try {
    		return dbDao.searchCntrSumByPod(sendTsListVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    
    /**
     * retrieving  T/S port<br>
	 * 
     * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO
     * @return List<TSSummaryVO>
     * @exception EventException
     */
    public List<TSSummaryVO> searchTSSummary(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException{
    	try {
    		return dbDao.searchTSSummary(tSListBy1st2ndVVDListInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    /**
     * retrieving Relay Vessel Group Assign by Relay Port list.<br>
     * 
     * @param  RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO
     * @return List<RlyVslGrpAssignVO>
     * @exception EventException
     */
    public List<RlyVslGrpAssignVO>searchRlyVslGrpAssign ( RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO )throws EventException{
    	try {
    		return dbDao.searchRlyVslGrpAssign(rlyVslGrpAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * retrieving Next VVD Assign T/S Remark T/S remark<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO 
     * @return BkgTsRmkVO
     * @exception EventException
     */
    public BkgTsRmkVO searchTSRemark (BkgTsRmkVO bkgTsRmkVO ) throws EventException{
    	try {
    		return dbDao.searchTSRemark(bkgTsRmkVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Saving t/s port remark<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void manageTSRemark (BkgTsRmkVO bkgTsRmkVO, SignOnUserAccount account ) throws EventException{
    	try {
    		 if(bkgTsRmkVO.getTsRmk().trim().length()==0){
    			 dbDao.removeTSRemark(bkgTsRmkVO,account);
    		 } 
    		 if(dbDao.modifyTSRemark(bkgTsRmkVO,account)==0){
    			 dbDao.addTSRemark(bkgTsRmkVO,account);
    		 }
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * retrieving of vvd,Bkg.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<FormerVvdVO>
     * @exception EventException
     */
    public List<FormerVvdVO>searchFormerVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException{
    	try {
    		return dbDao.searchFormerVvdForAssign(nextVvdAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    }
    
    /**
     * retrieving of  next vvd<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return VvdAssignTargetListVO
     * @exception EventException
     */
    public VvdAssignTargetListVO searchTargetForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException{
    	try {
    		VvdAssignTargetListVO vvdAssignTargetListVO = new VvdAssignTargetListVO();
    		vvdAssignTargetListVO.setFormerVvdSkdVO(dbDao.searchFormerVvdSkd(nextVvdAssignInputVO));
    		vvdAssignTargetListVO.setVvdAssignTargetBkgVO(dbDao.searchTargerBkgForAssign(nextVvdAssignInputVO));
    		vvdAssignTargetListVO.setVvdAssignTargetVvdVO(dbDao.searchTargetVvdForAssign(nextVvdAssignInputVO));
    		
    		return vvdAssignTargetListVO;
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    	
    }
    
    /**
     * retrieving of next vvd<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<NextVvdVO>
     * @exception EventException
     */
    public List<NextVvdVO>searchNextVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException{
    	try {
    		return dbDao.searchNextVvdForAssign(nextVvdAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    }
    
    /**
     * retrieving of Booking by route<br>
     * 
     * @param SearchCondForPortAssignVO searchCondForPortAssignVO
     * @return List<BkgRouteForPortAssignVO>
     * @exception EventException
     */
    public List<BkgRouteForPortAssignVO>searchBkgRouteForPortAssign(SearchCondForPortAssignVO searchCondForPortAssignVO)throws EventException{
    	 try {
     		return dbDao.searchBkgRouteForPortAssign(searchCondForPortAssignVO);
    	 } catch (DAOException de) {
     		log.error("err " + de.toString(), de);
 			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
     	} catch (Exception ex) {
     		log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
 		}
     }
    
    /**
     * retrieving of Detail Booking by route<br>
     * 
     * @param  BkgListForPortAssignInputVO bkgListForPortAssignInputVO
     * @return List<BkgListForPortAssignVO>
     * @exception EventException
     */
    public List<BkgListForPortAssignVO>searchBkgListForPortAssign(BkgListForPortAssignInputVO bkgListForPortAssignInputVO)throws EventException{
    	try {
     		return dbDao.searchBkgListForPortAssign(bkgListForPortAssignInputVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * retrieving of Booking by bkg vvd port<br>
	 * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<BkgVvdVO>
     * @exception EventException
     */
    public List<BkgVvdVO>searchBkgVvdForVvdPortAssign(BkgBlNoVO bkgBlNoVO)throws EventException{
    	try {
     		return dbDao.searchBkgVvdForVvdPortAssign(bkgBlNoVO);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
    }
    
    /**
     * Search VVD detail for Group VVD/Port Assign.<br>
     * 
     * @param SearchCondForPortAssignVO searchCondForPortAssignVO
     * @return List<VvdDetailForPortAssignVO>
     * @exception EventException
     */
    public List<VvdDetailForPortAssignVO>searchVvdDetailForPortAssign(SearchCondForPortAssignVO searchCondForPortAssignVO)throws EventException{
    	 try {
     		return dbDao.searchVvdDetailForPortAssign(searchCondForPortAssignVO);
    	 } catch (DAOException de) {
     		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);
     	} catch (Exception ex) {
     		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
 		}
     }
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtBC.java
*@FileTitle :RepairPartner
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtHdrVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration.PartnerMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPrnrCntcPntVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
   
/** 
 * RepairPartner Business Logic Basic Command implementation<br>
 *
 * @author   
 * @see EventResponse reference 
 * @since J2EE 1.6
 */
 
public class PartnerMgtBCImpl extends BasicCommandSupport implements PartnerMgtBC { 
	
	// Database Access Object  
	private transient PartnerMgtDBDAO dbDao = null;   
       
	/**  
	 * creating object
	 */
	public PartnerMgtBCImpl() {
		dbDao = new PartnerMgtDBDAO();
	}
		
	/**
	 * [EES_MNR_0218] retrieving Tariff Detail Information_Pop_Up. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @return RepairPartnerGRPVO
	 * @exception EventException
	 */
	public RepairPartnerGRPVO searchRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO) throws EventException {
		try { 
			//multiple search       
			List<CustomMnrPartnerVO> customMnrPartnerVOS = null;
			  
			customMnrPartnerVOS = dbDao.searchRepairPartnerData(repairPartnerGRPVO.getPartnerMgtINVO());
			CustomMnrPartnerVO customMnrPartnerVO = null;
			
			//getting list 
			if(repairPartnerGRPVO.getPartnerMgtINVO().getMnrPrnrSeq().equals("") || repairPartnerGRPVO.getPartnerMgtINVO().getMnrPrnrSeq() == null){
				repairPartnerGRPVO.setCustomMnrPartnerVOS(customMnrPartnerVOS);	
   
			} else {
				if(customMnrPartnerVOS.size() > 0){   
					customMnrPartnerVO = customMnrPartnerVOS.get(0);   
					repairPartnerGRPVO.setCustomMnrPartnerVO(customMnrPartnerVO); 
				}    
			}
			return repairPartnerGRPVO;    
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0218] searchRepairPartnerBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0218] searchRepairPartnerBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0156] retrieving Disposal Request. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPPartnerBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try { 
			//multiple search          
			List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOS = null;
			
			customMnrDispBuyerPartVOS = dbDao.searchDSPPartnerData(disposalGRPVO.getDisposalNVO());
			       	
			//getting list
			disposalGRPVO.setCustomMnrDispBuyerPartVOS(customMnrDispBuyerPartVOS);	
			return disposalGRPVO;          
		} catch (DAOException ex) {     
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0156] searchDSPPartnerBasic"}).getMessage(),ex);
		} catch (Exception ex) {     
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0156] searchDSPPartnerBasic"}).getMessage(),ex);
		}
	}
	   
	/**
	 * [EES_MNR_0015] adding/modification/deletion M&R Agreement. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO,SignOnUserAccount account) throws EventException {
		try {        
			CustomMnrPartnerVO[] arrCustomMnrPartnerVOS = repairPartnerGRPVO.getArrCustomMnrPartnerVOS(); 
			CustomMnrAgmtHdrVO customMnrAgmtHdrVO = repairPartnerGRPVO.getCustomMnrAgmtHdrVO();
			List<CustomMnrPartnerVO> listCustomMnrPartnerVOS = new ArrayList<CustomMnrPartnerVO>();

			for ( int i=0; i< arrCustomMnrPartnerVOS.length; i++ ) 
			{  
				if(!"D".equals(arrCustomMnrPartnerVOS[i].getIbflag())){
					arrCustomMnrPartnerVOS[i].setCreUsrId(account.getUsr_id()); 
					arrCustomMnrPartnerVOS[i].setUpdUsrId(account.getUsr_id());
					arrCustomMnrPartnerVOS[i].setAgmtOfcCtyCd(customMnrAgmtHdrVO.getAgmtOfcCtyCd());
					arrCustomMnrPartnerVOS[i].setAgmtSeq(customMnrAgmtHdrVO.getAgmtSeq());
					arrCustomMnrPartnerVOS[i].setAgmtVerNo(customMnrAgmtHdrVO.getAgmtVerNo());
					listCustomMnrPartnerVOS.add(arrCustomMnrPartnerVOS[i]);
				}
			}
			 
			// deleting
			dbDao.removeAGMTPartnerData(listCustomMnrPartnerVOS);
			// adding
			dbDao.addPartnerListData(listCustomMnrPartnerVOS);  
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0015] manageRepairPartnerBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0015] manageRepairPartnerBasic"}).getMessage(),ex);
		} 
	}
	
	/**
	 * [EES_MNR_0155] retrieving Disposal Buyer Management. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalPartnerGRPVO
	 * @exception EventException
	 */
	public DisposalPartnerGRPVO searchDisposalPartnerListBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException {
		try { 
			List<CustomMnrPartnerVO> customMnrPartnerVOS = null;
			List<CustomMnrPrnrCntcPntVO> customMnrPrnrCntcPntVOS = null;
			
			String fGubuns=disposalPartnerGRPVO.getDisposalPartnerMgtINVO().getFGubuns();
			
			if(!fGubuns.equalsIgnoreCase("DTL"))
			{
				customMnrPartnerVOS = dbDao.searchDisposalPartnerListData(disposalPartnerGRPVO.getDisposalPartnerMgtINVO(),account);
			}
			
			if(customMnrPartnerVOS != null && !fGubuns.equalsIgnoreCase("EXIST"))
			{
				if(customMnrPartnerVOS.size()> 0)
				{	
					disposalPartnerGRPVO.getDisposalPartnerMgtINVO().setMnrPrnrCreSeq(customMnrPartnerVOS.get(0).getMnrPrnrCreSeq());
					customMnrPrnrCntcPntVOS = dbDao.searchDisposalPartnerContactData(disposalPartnerGRPVO.getDisposalPartnerMgtINVO());
				}
				disposalPartnerGRPVO.setCustomMnrPartnerVOS(customMnrPartnerVOS);	
			}else if( fGubuns.equalsIgnoreCase("DTL"))
			{
				customMnrPrnrCntcPntVOS = dbDao.searchDisposalPartnerContactData(disposalPartnerGRPVO.getDisposalPartnerMgtINVO());
			}
				
			
			if(!fGubuns.equalsIgnoreCase("EXIST"))
			{
				if(customMnrPrnrCntcPntVOS != null){
					disposalPartnerGRPVO.setCustomMnrPrnrCntcPntVOS(customMnrPrnrCntcPntVOS);	
				}
			}
			return disposalPartnerGRPVO;    
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] searchDisposalPartnerListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] searchDisposalPartnerListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0155] adding/modification/deletion Disposal Buyer Management. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalPartnerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException {
		try {             	
				CustomMnrPartnerVO customMnrPartnerVO = disposalPartnerGRPVO.getCustomMnrPartnerVO();
				CustomMnrPrnrCntcPntVO[] customMnrPrnrCntcPntVOS = disposalPartnerGRPVO.getArrayCustomMnrPrnrCntcPntVOs();
				List<CustomMnrPartnerVO> mergeList = new ArrayList<CustomMnrPartnerVO>();
				List<DisposalPartnerMgtINVO> searchList = new ArrayList<DisposalPartnerMgtINVO>();
				String mnrPrnrCreSeq="";
				customMnrPartnerVO.setCreUsrId(account.getUsr_id()); 
				customMnrPartnerVO.setUpdUsrId(account.getUsr_id());
				if(customMnrPartnerVO.getMnrShopFlg().equalsIgnoreCase("on"))
				{
					customMnrPartnerVO.setMnrShopFlg("Y");
				}else{
					customMnrPartnerVO.setMnrShopFlg("N");
				}
				if(customMnrPartnerVO.getMnrPrnrCreSeq().equalsIgnoreCase(""))
				{
					searchList=dbDao.searchDisposalPartnerData();
					if(searchList.size()>0)
					{
						customMnrPartnerVO.setMnrPrnrCreSeq(searchList.get(0).getMnrPrnrCreSeq());
						mnrPrnrCreSeq=searchList.get(0).getMnrPrnrCreSeq();
					}
				}
				mergeList.add(customMnrPartnerVO);
				if(mergeList.size() > 0) 
				{
					dbDao.mergeDisposalPartnerInfoData(mergeList);
				}
				
				if(customMnrPrnrCntcPntVOS != null)
				{
					List<CustomMnrPrnrCntcPntVO> addList = new ArrayList<CustomMnrPrnrCntcPntVO>();
					List<CustomMnrPrnrCntcPntVO> delList = new ArrayList<CustomMnrPrnrCntcPntVO>();
					for ( int i=0; i< customMnrPrnrCntcPntVOS.length; i++ )  
					{  
						
						if(!customMnrPrnrCntcPntVOS[i].getIbflag().equalsIgnoreCase("D"))
						{
							customMnrPrnrCntcPntVOS[i].setCreUsrId(account.getUsr_id()); 
							customMnrPrnrCntcPntVOS[i].setUpdUsrId(account.getUsr_id()); 
							if(customMnrPrnrCntcPntVOS[i].getMnrPrnrCreSeq().equalsIgnoreCase(""))
							{
								customMnrPrnrCntcPntVOS[i].setMnrPrnrCreSeq(mnrPrnrCreSeq); 
							}
							customMnrPrnrCntcPntVOS[i].setMnrPrnrCreDtlSeq(String.valueOf(i+1)); 
							addList.add(customMnrPrnrCntcPntVOS[i]);
						}
						if(i==0)
						{
							delList.add(customMnrPrnrCntcPntVOS[i]);
						}
						
					} 
					if(delList.size()>0)
					{
						dbDao.removeDisposalPartnerContractData(delList);
					}
					if(addList.size()>0)
					{
						dbDao.addDisposalPartnerContactData(addList);
					}
				}
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] manageDisposalPartnerBasic"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] manageDisposalPartnerBasic"}).getMessage(),ex);
			} 
	}
	
	/**
	 * [EES_MNR_0155] deleting Disposal Buyer Management. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @exception EventException
	 */
	public void removeDisposalPartnerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO) throws EventException {
		try {             	
				CustomMnrPartnerVO customMnrPartnerVO = disposalPartnerGRPVO.getCustomMnrPartnerVO();
				CustomMnrPrnrCntcPntVO customMnrPrnrCntcPntVO=new CustomMnrPrnrCntcPntVO();
				List<CustomMnrPartnerVO> delList = new ArrayList<CustomMnrPartnerVO>();
				List<CustomMnrPrnrCntcPntVO> delCntList = new ArrayList<CustomMnrPrnrCntcPntVO>();

				if(!customMnrPartnerVO.getMnrPrnrCreSeq().equalsIgnoreCase(""))
				{
					delList.add(customMnrPartnerVO);
					customMnrPrnrCntcPntVO.setMnrPrnrCreSeq(customMnrPartnerVO.getMnrPrnrCreSeq());
					delCntList.add(customMnrPrnrCntcPntVO);
				}

				if(delList.size()>0)
				{
					dbDao.removeDisposalPartnerContractData(delCntList);
					dbDao.removeDisposalPartnerInfoData(delList);
				}
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] removeDisposalPartnerBasic"}).getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] removeDisposalPartnerBasic"}).getMessage(),ex);
			} 
	}	

	/**
	 * [EES_MNR_0155] searching duplicated buyer <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchDupDSPBuyerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException {
		try { 
			String result = dbDao.searchDupDSPBuyerData(disposalPartnerGRPVO.getCustomMnrPartnerVO());
			return result;
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] searchDisposalPartnerListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0155] searchDisposalPartnerListBasic"}).getMessage(),ex);
		}
		
	}
}
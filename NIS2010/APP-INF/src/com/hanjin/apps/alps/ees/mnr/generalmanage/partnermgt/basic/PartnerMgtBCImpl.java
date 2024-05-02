/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtBC.java
*@FileTitle :RepairPartner
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.05.21 박명신
* 1.0 Creation  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.integration.PartnerMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPartnerVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.CustomMnrPrnrCntcPntVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
   
/** 
 * RepairPartner Business Logic Basic Command implementation<br>
 * - alps-partnermgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin  
 * @see EventResponse 참조 
 * @since J2EE 1.6
 */
 
public class PartnerMgtBCImpl extends BasicCommandSupport implements PartnerMgtBC { 
	
	// Database Access Object  
	private transient PartnerMgtDBDAO dbDao = null;   
       
	/**  
	 * 생성자
	 */
	public PartnerMgtBCImpl() {
		dbDao = new PartnerMgtDBDAO();
	}
		
	/**
	 * [EES_MNR_0218]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @return RepairPartnerGRPVO
	 * @exception EventException
	 */
	public RepairPartnerGRPVO searchRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO) throws EventException {
		try { 
			//다건조회       
			List<CustomMnrPartnerVO> customMnrPartnerVOS = null;
			  
			customMnrPartnerVOS = dbDao.searchRepairPartnerData(repairPartnerGRPVO.getPartnerMgtINVO());
			CustomMnrPartnerVO customMnrPartnerVO = null;
			
			//리스트 리턴 
			if(repairPartnerGRPVO.getPartnerMgtINVO().getMnrPrnrSeq().equals("") || repairPartnerGRPVO.getPartnerMgtINVO().getMnrPrnrSeq() == null){
				repairPartnerGRPVO.setCustomMnrPartnerVOS(customMnrPartnerVOS);	
			//단건 리턴   
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
	 * [EES_MNR_0156]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPPartnerBasic(DisposalGRPVO disposalGRPVO) throws EventException {
		try { 
			//다건조회          
			List<CustomMnrDispBuyerPartVO> customMnrDispBuyerPartVOS = null;
			
			customMnrDispBuyerPartVOS = dbDao.searchDSPPartnerData(disposalGRPVO.getDisposalNVO());
			       	
			//리스트 리턴 
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
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO,SignOnUserAccount account) throws EventException {
		try {        
			CustomMnrPartnerVO[] arrCustomMnrPartnerVOS = repairPartnerGRPVO.getArrCustomMnrPartnerVOS(); 
			List<CustomMnrPartnerVO> listCustomMnrPartnerVOS = new ArrayList<CustomMnrPartnerVO>();

			for ( int i=0; i< arrCustomMnrPartnerVOS.length; i++ ) 
			{  
				arrCustomMnrPartnerVOS[i].setCreUsrId(account.getUsr_id()); 
				arrCustomMnrPartnerVOS[i].setUpdUsrId(account.getUsr_id()); 
				listCustomMnrPartnerVOS.add(arrCustomMnrPartnerVOS[i]);
			}
			 
			//일단 삭제하고    
			dbDao.removeAGMTPartnerData(listCustomMnrPartnerVOS);
			//다시 넣는다.
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
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
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
			}else if( fGubuns.equalsIgnoreCase("DTL"))
			{
				customMnrPrnrCntcPntVOS = dbDao.searchDisposalPartnerContactData(disposalPartnerGRPVO.getDisposalPartnerMgtINVO());
			}
				
			disposalPartnerGRPVO.setCustomMnrPartnerVOS(customMnrPartnerVOS);	
			if(!fGubuns.equalsIgnoreCase("EXIST"))
			{
				disposalPartnerGRPVO.setCustomMnrPrnrCntcPntVOS(customMnrPrnrCntcPntVOS);	
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
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 추가/수정/삭제 합니다. <br>
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
				
				if(customMnrPartnerVO.getDeltFlg() == ""){
					customMnrPartnerVO.setDeltFlg("N");
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
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 삭제 합니다. <br>
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

}
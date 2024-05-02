/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireBCImpl.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireDBDAO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireEAIDAO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStdInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CrntMvmtInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FACntrListInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MovementVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusUpdateGRPVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaCntrListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * EquipmentManagement Business Logic Basic Command implementation<br>
 * handling business logic about EquipmentManagement<br>
 *
 * @author 
 * @see EES_MST_0032EventResponse,ContainerOnOffhireBC,ContainerOnOffhireDBDAO
 * @since J2EE 1.6
 */
public class ContainerOnOffhireBCImpl extends BasicCommandSupport implements ContainerOnOffhireBC 
{

	// Database Access Object
	private transient ContainerOnOffhireDBDAO dbDao = null;
	private transient ContainerOnOffhireEAIDAO eaiDao = null;
	
	/**
	 * creating ContainerOnOffhireDBDAO<br>
	 */
	public ContainerOnOffhireBCImpl() 
	{
		dbDao  = new ContainerOnOffhireDBDAO();
		eaiDao = new ContainerOnOffhireEAIDAO();
	}

	/** 
	 * EES_MST_0019, EES_MST_0044 : retrieve <br>
	 * retrieving for Container Master Inquiry, Container Master Update<br>
	 * @category EES_MST_0019, EES_MST_0044
	 * @category searchCntrMasterInquiryBasic    
	 * @param MstEtcVO   mstEtcVO
	 * @param SignOnUserAccount account
	 * @return CntrMasterInquiryVO
	 * @exception EventException
	 */	
	public CntrMasterInquiryVO searchCntrMasterInquiryBasic(MstEtcVO mstEtcVO, SignOnUserAccount account) throws EventException {
		try {
			if (!mstEtcVO.getGubun().equals("1")){
			    return dbDao.searchCntrMasterInquiryData(mstEtcVO,account);
			} else {
				return dbDao.searchCntrMasterUpdateInquiryData(mstEtcVO);
			}    
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Master Inquiry"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Master Inquiry"}).getMessage(),de);
		}  
	}

	/** 
	 * seting for CntrLotVO<br>
     * 
     * @param  CntrLotVO cntrLotVO
     * @param  SignOnUserAccount account
     * @return CntrLotVO
	 * @throws EventException
	 * 
	 */	
	private CntrLotVO settingValue(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException {
		
		String lot_pln_yr = cntrLotVO.getMftDt().substring(0, 4);
		cntrLotVO.setLotPlnYr(lot_pln_yr);
		
		if(!cntrLotVO.getPlstFlrFlg().equals("Y")){
			cntrLotVO.setPlstFlrFlg("N");
		}
				
		if(!cntrLotVO.getCntrHngrRckCd().equals("O")){
			cntrLotVO.setCntrHngrRckCd(null);
		}			

		cntrLotVO.setCreUsrId(account.getUsr_id());
		cntrLotVO.setUpdUsrId(account.getUsr_id());
		
		String de_yrmon = cntrLotVO.getDeYrmon().substring(0,4) + cntrLotVO.getDeYrmon().substring(5,7);
		cntrLotVO.setDeYrmon(de_yrmon);
					
		String agmt_cty_cd = cntrLotVO.getAgmtNo().substring(0, 3);
		String agmt_seq = cntrLotVO.getAgmtNo().substring(3,9);				
		cntrLotVO.setAgmtCtyCd(agmt_cty_cd);
		cntrLotVO.setAgmtSeq(agmt_seq);
		
		int fm_ser_no = Integer.parseInt(cntrLotVO.getFmSerNo());
		int to_ser_no  = Integer.parseInt(cntrLotVO.getToSerNo());
		int range_count2 = to_ser_no - fm_ser_no +1;
		cntrLotVO.setRangeCount(String.valueOf(range_count2));

		cntrLotVO.setOfcCd(account.getOfc_cd());	
		
		return cntrLotVO;		
	}
	
	/** EES_MST_0016 : save <br>
	 * saving for Own Container Creation (New Van)<br>
     * 
     * @param  CntrLotVO cntrLotVO
     * @param  SignOnUserAccount account
     * @return CntrLotVO
	 * @throws EventException
	 * 
	 */
    public CntrLotVO createOwnCntrBasic(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException {
    	
    	String cntr_no = "";
    	String lot_no = "";
		try {
			this.settingValue(cntrLotVO, account);
											
			// check the CNTR lot range 
			cntrLotVO = dbDao.searchCntrLotSerialRangeData(cntrLotVO);
			lot_no = cntrLotVO.getLotNo();
			cntr_no = cntrLotVO.getCntrNo();
			// if the lot_no already exists
			if(!"".equals(cntr_no)){				
				throw new EventException(new ErrorHandler("MST01005", new String[]{"cntr_no : "+cntr_no}).getMessage());				
			}else{
				
				if(!"".equals(lot_no)) {
					throw new EventException(new ErrorHandler("MST01005", new String[]{"lot_no : "+lot_no}).getMessage());		
				}else{
					// setting lot_no
					cntrLotVO = dbDao.searchCntrLotLastSeqData(cntrLotVO);
					String lot_seq2 = cntrLotVO.getLotNo2();
					cntrLotVO.setLotSeq(lot_seq2);	
																
					if(lot_seq2.length() == 1){
						lot_seq2 = "00"+lot_seq2;
					}else if(lot_seq2.length() == 2){
						lot_seq2 = "0"+lot_seq2;				
					}
	
					lot_no = cntrLotVO.getLotPlnYr() +"-"+
							 cntrLotVO.getLotLocCd() +"-"+
							 cntrLotVO.getCntrTpszCd() +"-"+lot_seq2;	
					
					//EES_MST_0014 화면을 통해서 접근한경우
					if("2".equals(cntrLotVO.getCType())) {
						dbDao.addLseCntrLotData(cntrLotVO); 
					}else{
						dbDao.addCntrLotData(cntrLotVO);
						dbDao.addOwnCntrMastersData(cntrLotVO);
						dbDao.addOwnCntrStatusHistorysData(cntrLotVO);	
						
						//Movement MT 						
						CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
						IFGateVO iFGateVO = new IFGateVO();
						ContainerMovementMgtBC cmd = new ContainerMovementMgtBCImpl();
						
						String[] cntrInfoArr = null;
						String strCntrNo = "";
						String strOnhYdCd = "";
						String strCntrStsCd = "";
						String strLotPlnYr = "";
						String strCnmvStsCd = "";
						
						List<String> cntrList = dbDao.modifyCntrMasterMvmtData(cntrLotVO,account);						
						
						if(cntrList != null && cntrList.size() > 0) {
							for(int i=0; i < cntrList.size(); i++) {
								cntrInfoArr = cntrList.get(i).split(";");
								
								strCntrNo = cntrInfoArr[0];
								strOnhYdCd = cntrInfoArr[1];
								strCntrStsCd = cntrInfoArr[2];
								strLotPlnYr = cntrInfoArr[3];
								strCnmvStsCd = cntrInfoArr[4];
								
								iFGateVO.setCntrNo(strCntrNo);
								iFGateVO.setCnmvEvntDt(cntrLotVO.getDeDt());
								
								cusCtmMovementVO.setCntrNo(strCntrNo);
								cusCtmMovementVO.setOrgYdCd(strOnhYdCd);
								String cnmvEvntDt = dbDao.searchMvmtTimeData(iFGateVO);
								cusCtmMovementVO.setCnmvEvntDt(cnmvEvntDt);
								cusCtmMovementVO.setCnmvRmk(strCntrStsCd);
								cusCtmMovementVO.setMvmtStsCd(strCnmvStsCd);
								cusCtmMovementVO.setMvmtCreTpCd("E");
								cusCtmMovementVO.setIbflag("I");
								cusCtmMovementVO.setCnmvIdNo("1");
								cusCtmMovementVO.setCnmvYr(strLotPlnYr);
								cusCtmMovementVO.setCreUsrId(account.getUsr_id());
								
								cusCtmMovementVO = cmd.manageCntrInfoFromMst(cusCtmMovementVO, account);
							}
						}
						//MST_CONTAINER
						dbDao.modifyOwnCoCreCntrMastersData(cntrLotVO);
					}
					
				}
			}			
			cntrLotVO.setLotNo(lot_no);
		} catch (EventException ee){
			throw ee;
		} catch (DAOException de) {	
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Creation (New Van)"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Creation (New Van)"}).getMessage(),de);
		}
		return cntrLotVO;
	}  
    
	/**
	 * retrieving for Lot No of Own Container<br>
	 * 
     * @category EES_MST_0016_01
     * @category searchLotInfoBasic
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO 
	 * @exception EventException
	 */
    public CntrLotVO searchLotInfoBasic(CntrLotVO cntrLotVO) throws EventException {
		try {
			String lot_pln_yr = cntrLotVO.getLotNo().substring(0,4);
			String lot_loc_cd = cntrLotVO.getLotNo().substring(5,10);
			String cntr_tpsz_cd = cntrLotVO.getLotNo().substring(11,13);
			String lot_seq = cntrLotVO.getLotNo().substring(14,17);
			
			cntrLotVO.setLotPlnYr(lot_pln_yr);
			cntrLotVO.setLotLocCd(lot_loc_cd);
			cntrLotVO.setCntrTpszCd(cntr_tpsz_cd);
			cntrLotVO.setLotSeq(lot_seq);
						
			cntrLotVO = dbDao.searchLotInfoData(cntrLotVO);			
			return cntrLotVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Lot No Search"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Lot No Search"}).getMessage(),de);
		}
    }

	/** 
	 * saving for Own Container Creation (New Van)<br>
	 * 
     * @category EES_MST_0016_03
     * @category modifyOwnCntrBasic 
     *  
     * @param CntrLotVO cntrLotVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
    public void modifyOwnCntrBasic(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException {
    
		try {			
			this.settingValue(cntrLotVO, account);					
						
			String lot_pln_yr = cntrLotVO.getLotNo().substring(0,4);
			String lot_loc_cd = cntrLotVO.getLotNo().substring(5,10);
			String cntr_tpsz_cd = cntrLotVO.getLotNo().substring(11,13);
			String lot_seq = cntrLotVO.getLotNo().substring(14,17);
			
			cntrLotVO.setLotPlnYr(lot_pln_yr);
			cntrLotVO.setLotLocCd(lot_loc_cd);
			cntrLotVO.setCntrTpszCd(cntr_tpsz_cd);
			cntrLotVO.setLotSeq(lot_seq);			
			
			dbDao.modifyCntrLotData(cntrLotVO);		
			
			// Only updating manufacture date, hanger rack, Plastic Floor 		
			if(!(cntrLotVO.getOrgMftDt().equals(cntrLotVO.getMftDt())   &&			
			     cntrLotVO.getOrgCntrHngrRckCd().equals(cntrLotVO.getCntrHngrRckCd()) &&
			     cntrLotVO.getOrgPlstFlrFlg().equals(cntrLotVO.getPlstFlrFlg()) &&
			     cntrLotVO.getOrgMftVndrSeq().equals(cntrLotVO.getMftVndrSeq()) 
			   ))
			{
				dbDao.modifyOwnCntrMastersData(cntrLotVO);				
			}
			
			// Only updating manufacture date
			cntrLotVO.setOfcCd(account.getOfc_cd());			
			if(!cntrLotVO.getOrgMftDt().equals(cntrLotVO.getMftDt()))
			{	
				dbDao.modifyOwnCntrStatusHistorysData(cntrLotVO);
			}						
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Creation (New Van) "}).getMessage(),de);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Creation (New Van) "}).getMessage(),de);			
		}
    }
    
	/** 
	 * retrieving for Lot No Inquiry<br>
	 * 
	 * @category EES_MST_0038
	 * @category searchLotNoListBrieflyBasic	
	 * 
	 * @param MstEtcVO mstEtcVO
	 * @return List<LotNoListVO>
	 * @exception EventException
	 */	
    public List<LotNoListVO> searchLotNoListBrieflyBasic(MstEtcVO mstEtcVO) throws EventException {
		try {
			LotNoListVO lotNoListVO = null;
			if(mstEtcVO.getCntrNo().length() == 10){			
				String lot_cntr_pfx_cd = mstEtcVO.getCntrNo().substring(0, 4);
				mstEtcVO.setLotCntrPfxCd(lot_cntr_pfx_cd);
	
				String fm_ser_no = mstEtcVO.getCntrNo().substring(4, 10);					
				mstEtcVO.setFmSerNo(fm_ser_no);						
			}
			
			List<LotNoListVO> list = dbDao.searchLotNoListBrieflyData(mstEtcVO);
			
			String lot_no = "";
			String serial_range = "";
			String lot_seq = "";
			
			for(int i=0; i<list.size(); i++){
				lotNoListVO = list.get(i);
				
				lot_seq = lotNoListVO.getLotSeq();
				if(lot_seq.length() == 1){
					lot_seq = "00"+lot_seq;
				}else if(lot_seq.length() == 2){
					lot_seq = "0"+lot_seq;				
				}
				
				lot_no = lotNoListVO.getLotPlnYr() + "-" + 
						 lotNoListVO.getLotLocCd() + "-" +
						 lotNoListVO.getCntrTpszCd() + "-" +
						 lot_seq;						
				lotNoListVO.setLotNo(lot_no);
											
				serial_range = lotNoListVO.getLotCntrPfxCd() + lotNoListVO.getFmSerNo() + " - " +
							   lotNoListVO.getToSerNo();
				lotNoListVO.setSerialRange(serial_range);
				
				list.set(i, lotNoListVO);				
			}			
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Lot No Inquiry"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Lot No Inquiry"}).getMessage(),de);			
		}	
    }
    
	/** 
	 * EES_MST_0014 : retrieve <br>
	 * retrieving for Leased Container<br>
	 * @category EES_MST_0014
	 * @category searchApprovalListBasic    
	 * @param MstEtcVO mstEtcVO
	 * @return List<CntrMasterInquiryVO>
	 * @exception EventException
	 */
	public List<ApprovalListVO> searchApprovalListBasic(MstEtcVO mstEtcVO) throws EventException {
		try {
			return dbDao.searchApprovalListData(mstEtcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Leased Container Creation"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Leased Container Creation"}).getMessage(),de);
		}		
	}

	/** 
	 * EES_MST_0014 : save <br>
	 * saving for Leased Container<br>
	 * @category EES_MST_0014
	 * @category manageLeasedCntrBasic 
	 * @param LeasedCntrVO[] leasedCntrVOs
	 * @param SignOnUserAccount account
	 * @return List<LeasedCntrVO>
	 * @exception EventException
	 */	
	public List<LeasedCntrVO> manageLeasedCntrBasic(LeasedCntrVO[] leasedCntrVOs, SignOnUserAccount account) throws EventException {
		List<LeasedCntrVO> retVoList = new ArrayList<LeasedCntrVO>();
		
		String cntr_no0="";
		String cntr_no1="";
		String cntr_no2="";
		try {
			List<LeasedCntrVO> tmpLeasedCntrVOs = new ArrayList<LeasedCntrVO>();
			if (leasedCntrVOs.length == 1 &&     //in case of Serial Range
				!leasedCntrVOs[0].getCntrNo0().equals("") &&
				!leasedCntrVOs[0].getCntrNo1().equals("") &&
				!leasedCntrVOs[0].getCntrNo2().equals("")){
				
				cntr_no0 = leasedCntrVOs[0].getCntrNo0();
				cntr_no1 = leasedCntrVOs[0].getCntrNo1();
				cntr_no2 = leasedCntrVOs[0].getCntrNo2();
				
				if (!cntr_no0.equals("") &&
				    !cntr_no1.equals("") &&
				    !cntr_no2.equals("")) {
					
					for (int i = 0; i < Integer.parseInt(cntr_no2)-Integer.parseInt(cntr_no1) + 1; i++){
						LeasedCntrVO ttvo = new LeasedCntrVO();
						tmpLeasedCntrVOs.add(i,ttvo);
						tmpLeasedCntrVOs.get(i).setAgmtCtyCd    (leasedCntrVOs[0].getAgmtCtyCd ());
						tmpLeasedCntrVOs.get(i).setAgmtNo       (leasedCntrVOs[0].getAgmtNo ());
						tmpLeasedCntrVOs.get(i).setApprovalNo   (leasedCntrVOs[0].getApprovalNo ());
						tmpLeasedCntrVOs.get(i).setApprovalVol  (leasedCntrVOs[0].getApprovalVol ());
						tmpLeasedCntrVOs.get(i).setCeflg        (leasedCntrVOs[0].getCeflg ());
						tmpLeasedCntrVOs.get(i).setCntrMtrlCd   (leasedCntrVOs[0].getCntrMtrlCd ());
						tmpLeasedCntrVOs.get(i).setCntrNo       (cntr_no0 + lPad(Integer.toString(Integer.parseInt(cntr_no1) + i), 6));
						tmpLeasedCntrVOs.get(i).setCntrNo0      (leasedCntrVOs[0].getCntrNo0 ());
						tmpLeasedCntrVOs.get(i).setCntrNo1      (leasedCntrVOs[0].getCntrNo1 ());
						tmpLeasedCntrVOs.get(i).setCntrNo2      (leasedCntrVOs[0].getCntrNo2 ());
						tmpLeasedCntrVOs.get(i).setCntrNo3      (leasedCntrVOs[0].getCntrNo3 ());
						tmpLeasedCntrVOs.get(i).setCntrOldVanFlg(leasedCntrVOs[0].getCntrOldVanFlg ());
						tmpLeasedCntrVOs.get(i).setCreUsrId     (leasedCntrVOs[0].getCreUsrId ());
						tmpLeasedCntrVOs.get(i).setCtype        (leasedCntrVOs[0].getCtype ());
						tmpLeasedCntrVOs.get(i).setEeflg        (leasedCntrVOs[0].getEeflg ());
						tmpLeasedCntrVOs.get(i).setEqTpszCd     (leasedCntrVOs[0].getEqTpszCd ());
						tmpLeasedCntrVOs.get(i).setFreeDys      (leasedCntrVOs[0].getFreeDys ());
						tmpLeasedCntrVOs.get(i).setHeflg        (leasedCntrVOs[0].getHeflg ());
						tmpLeasedCntrVOs.get(i).setHireDate     (leasedCntrVOs[0].getHireDate ());
						tmpLeasedCntrVOs.get(i).setIbflag       (leasedCntrVOs[0].getIbflag ());
						tmpLeasedCntrVOs.get(i).setIeflg        (leasedCntrVOs[0].getIeflg ());
						tmpLeasedCntrVOs.get(i).setLiftOnChrg   (leasedCntrVOs[0].getLiftOnChrg ());
						tmpLeasedCntrVOs.get(i).setLstmCd       (leasedCntrVOs[0].getLstmCd ());
						tmpLeasedCntrVOs.get(i).setMftDt        (leasedCntrVOs[0].getMftDt ());
						tmpLeasedCntrVOs.get(i).setMinOnhDys    (leasedCntrVOs[0].getMinOnhDys ());
						tmpLeasedCntrVOs.get(i).setPagerows     (leasedCntrVOs[0].getPagerows ());
						tmpLeasedCntrVOs.get(i).setPickUpDueDate(leasedCntrVOs[0].getPickUpDueDate ());
						tmpLeasedCntrVOs.get(i).setPickUpVol    (leasedCntrVOs[0].getPickUpVol ());
						tmpLeasedCntrVOs.get(i).setPkupChgAmt   (leasedCntrVOs[0].getPkupChgAmt ());
						tmpLeasedCntrVOs.get(i).setPkupChgCrAmt (leasedCntrVOs[0].getPkupChgCrAmt ());
						tmpLeasedCntrVOs.get(i).setRefNo        (leasedCntrVOs[0].getRefNo ());
						tmpLeasedCntrVOs.get(i).setStsEvntYdCd  (leasedCntrVOs[0].getStsEvntYdCd ());
						tmpLeasedCntrVOs.get(i).setUeflg        (leasedCntrVOs[0].getUeflg ());
						tmpLeasedCntrVOs.get(i).setUpdUsrId     (leasedCntrVOs[0].getUpdUsrId ());
						tmpLeasedCntrVOs.get(i).setVndrAbbrNm   (leasedCntrVOs[0].getVndrAbbrNm ());
						tmpLeasedCntrVOs.get(i).setVndrSeq      (leasedCntrVOs[0].getVndrSeq ());	
						tmpLeasedCntrVOs.get(i).setAgmtSeq      (leasedCntrVOs[0].getAgmtSeq ());
						tmpLeasedCntrVOs.get(i).setCntrSpecNo   (leasedCntrVOs[0].getCntrSpecNo ());
						
						tmpLeasedCntrVOs.get(i).setRfTpCd   (leasedCntrVOs[0].getRfTpCd ());
						tmpLeasedCntrVOs.get(i).setRfHumidCtrlValCd   (leasedCntrVOs[0].getRfHumidCtrlValCd ());
						tmpLeasedCntrVOs.get(i).setRfCmprCtnt   (leasedCntrVOs[0].getRfCmprCtnt ());
						
						tmpLeasedCntrVOs.get(i).setLotPlnYn(leasedCntrVOs[0].getLotPlnYn());
						tmpLeasedCntrVOs.get(i).setLotLocCd(leasedCntrVOs[0].getLotLocCd());
						tmpLeasedCntrVOs.get(i).setLotSeq(leasedCntrVOs[0].getLotSeq());
						
					}
				}
			} else {   //not in case of Serial Range
				for(int i = 0; i < leasedCntrVOs.length; i++){
					tmpLeasedCntrVOs.add(i, leasedCntrVOs[i]);
				}
			} 
			
			//checking Check digit duplication
			tmpLeasedCntrVOs = dbDao.validationLeasedCntrData(tmpLeasedCntrVOs);
			//if duplicated data exits in Serial Range 
			if (tmpLeasedCntrVOs.get(0).getCtype().equals("2")){
				for (int i = 0; i < tmpLeasedCntrVOs.size(); i++){
					if (tmpLeasedCntrVOs.get(i).getCeflg().equals("D")){  
						tmpLeasedCntrVOs.get(0).setCeflg("B");
						retVoList.add(tmpLeasedCntrVOs.get(0));
						return retVoList;
					}
			    }
			}	
			
			//checkign Status cd, On Hire of duplicated data 
			tmpLeasedCntrVOs = dbDao.validationLeasedUpdateCntrData(tmpLeasedCntrVOs);
			
			//checking Serial Range
			if (tmpLeasedCntrVOs.get(0).getCtype().equals("2")){
				for (int i = 0; i < tmpLeasedCntrVOs.size(); i++){
					if (tmpLeasedCntrVOs.get(i).getEeflg().equals("E")){  
						tmpLeasedCntrVOs.get(0).setEeflg("E");
						 retVoList.add(tmpLeasedCntrVOs.get(0));
						 return retVoList;
					}
					if (tmpLeasedCntrVOs.get(i).getHeflg().equals("E")){
						tmpLeasedCntrVOs.get(0).setHeflg("E"); 
						 retVoList.add(tmpLeasedCntrVOs.get(0));
						 return retVoList;
					}
				}
			}
			//handling in case of General or W.O

			LeasedCntrVO lleasedCntrVO = new LeasedCntrVO();
			for (int i = 0; i < tmpLeasedCntrVOs.size(); i++){
				if (!tmpLeasedCntrVOs.get(i).getCeflg().equals("D") &&
					!tmpLeasedCntrVOs.get(i).getCeflg().equals("E")	&&
					!tmpLeasedCntrVOs.get(i).getEeflg().equals("E") &&
					!tmpLeasedCntrVOs.get(i).getHeflg().equals("E")){
					tmpLeasedCntrVOs.get(i).setCreUsrId(account.getUsr_id());
					tmpLeasedCntrVOs.get(i).setUpdUsrId(account.getUsr_id());
					lleasedCntrVO = tmpLeasedCntrVOs.get(i);
					
					tmpLeasedCntrVOs.get(i).setRfTpCd   (lleasedCntrVO.getRfTpCd ());
					tmpLeasedCntrVOs.get(i).setRfHumidCtrlValCd   (lleasedCntrVO.getRfHumidCtrlValCd ());
					tmpLeasedCntrVOs.get(i).setRfCmprCtnt   (lleasedCntrVO.getRfCmprCtnt ());
					
					tmpLeasedCntrVOs.get(i).setLotPlnYn(lleasedCntrVO.getLotPlnYn());
					tmpLeasedCntrVOs.get(i).setLotLocCd(lleasedCntrVO.getLotLocCd());
					tmpLeasedCntrVOs.get(i).setLotSeq(lleasedCntrVO.getLotSeq());
					
					String nextVal = dbDao.searchMaxCntrStatusHistorySeqData();
					tmpLeasedCntrVOs.get(i).setHisSeq(nextVal);
					int result = dbDao.addLeasedCntrMasterData(tmpLeasedCntrVOs.get(i));
					if (result !=1) lleasedCntrVO.setIeflg("E");
					
					lleasedCntrVO.setOfcCd(account.getOfc_cd());
					
					int result2 = dbDao.addLeasedCntrStatusHistoryData(lleasedCntrVO); // 이력 저장
					if (result2 !=1) lleasedCntrVO.setIeflg("E");
					retVoList.add(lleasedCntrVO);
				}	
				else if (tmpLeasedCntrVOs.get(i).getCeflg().equals("D") &&
						!tmpLeasedCntrVOs.get(i).getEeflg().equals("E") &&
						!tmpLeasedCntrVOs.get(i).getHeflg().equals("E")){
					tmpLeasedCntrVOs.get(i).setCreUsrId(account.getUsr_id());
					tmpLeasedCntrVOs.get(i).setUpdUsrId(account.getUsr_id());	
					lleasedCntrVO = tmpLeasedCntrVOs.get(i);
					
					tmpLeasedCntrVOs.get(i).setRfTpCd   (lleasedCntrVO.getRfTpCd ());
					tmpLeasedCntrVOs.get(i).setRfHumidCtrlValCd   (lleasedCntrVO.getRfHumidCtrlValCd ());
					tmpLeasedCntrVOs.get(i).setRfCmprCtnt   (lleasedCntrVO.getRfCmprCtnt ());

					String nextVal = dbDao.searchMaxCntrStatusHistorySeqData();
					tmpLeasedCntrVOs.get(i).setHisSeq(nextVal);
					int result = dbDao.modifyLeasedCntrMasterData(tmpLeasedCntrVOs.get(i));
					if (result !=1) lleasedCntrVO.setUeflg("E");

					lleasedCntrVO.setOfcCd(account.getOfc_cd());

					int result2 = dbDao.addLeasedCntrStatusHistoryData(lleasedCntrVO); // saving history
					if (result2 !=1) lleasedCntrVO.setIeflg("E");
					retVoList.add(lleasedCntrVO);
				}
				else {
					retVoList.add(tmpLeasedCntrVOs.get(i));
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Leased Container Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Leased Container Creation"}).getMessage(),ex);
		}
		return retVoList;
	}
	
	/** 
	 * EES_MST_0044 : save <br>
	 * saving for Container Master Update <br>
	 * @category EES_MST_0044
	 * @category modifyCntrMasterBasic  
	 * @param MstEtcVO mstEtcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void modifyCntrMasterBasic(MstEtcVO mstEtcVO, SignOnUserAccount account) throws EventException {
		try {			
			mstEtcVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyCntrMasterData(mstEtcVO);			
			
			/*if(!(mstEtcVO.getLotPlnYr().equals("")   &&			
					mstEtcVO.getLotLocCd().equals("") &&
					mstEtcVO.getLotCntrTpszCd().equals("") &&
					mstEtcVO.getLotSeq().equals("") 
				   ))
				{
				
				dbDao.modifyCntrLotData(mstEtcVO);
				}*/
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Master Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Master Update"}).getMessage(),de);
		}
    }
	
	/** handling LPAD
	 * @category EES_MST_0014
	 * @category lPad  
	 * replace null to '0'
	 * @param String src
	 * @param int size 
	 * @return String
	 * @exception
	 */		
	private static String lPad(String src, int size) {
		String pattern = "";
		double dValue = 0d;
		StringBuilder sb = new StringBuilder();
		try {
			dValue = Double.valueOf(src).doubleValue();
		} catch (Exception e) {
			dValue = 0d;
		}
		for (int inx = 0; inx < size; inx++) {
			//pattern = pattern + "0";
			sb.append(pattern).append("0");
		}
		//DecimalFormat df = new DecimalFormat(pattern);
		DecimalFormat df = new DecimalFormat(sb.toString());
		return df.format(dValue);
	}
	
	/**
	 *  retrieving for Movement,Status of lost and found CNTR<br>
	 * 
     * @author J.H.Min
     * @category EES_MST_0025
     * @category searchLostFoundListBasic
	 * 
	 * @param LostFoundVO[] lostFoundVOs
	 * @return List<LostFoundVO>
	 * @exception EventException
	 */	
	public List<LostFoundVO> searchLostFoundListBasic(LostFoundVO[] lostFoundVOs) throws EventException {
		List<LostFoundVO> selectVoList = new ArrayList<LostFoundVO>();		
		try {			
			if(lostFoundVOs != null){
				for ( int i=0; i<lostFoundVOs.length; i++ ){	
					
					lostFoundVOs[i].setCntrTpszCd("");
					lostFoundVOs[i].setLstmCd("");
					lostFoundVOs[i].setVndrSeq("");
					lostFoundVOs[i].setVndrLglEngNm("");
					lostFoundVOs[i].setCntrStsCd("");
					lostFoundVOs[i].setCntrStsEvntDt("");
					lostFoundVOs[i].setLstStsYdCd("");
					lostFoundVOs[i].setFullFlg("");
					lostFoundVOs[i].setCnmvStsCd("");
					lostFoundVOs[i].setCrntYdCd("");
					lostFoundVOs[i].setCnmvDt("");
										
					lostFoundVOs[i].setHCntrStsCd(lostFoundVOs[0].getInputCntrStsCd());				
					lostFoundVOs[i].setHCnmvEvntDt(lostFoundVOs[0].getInputCntrStsEvntDt());				
					lostFoundVOs[i].setHOnhYdCd(lostFoundVOs[0].getInputOnhYdCd());
												
					selectVoList.add(lostFoundVOs[i]);				
				}
				if(selectVoList.size() > 0 ){				
				   selectVoList = dbDao.searchLostFoundListData(selectVoList);				 				   
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lost Found List Search"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lost Found List Search"}).getMessage(),de);
		}
		return selectVoList;
	}
	
	/** 
	 *  saving for Movement,Status of lost and found CNTR<br>
	 * 
	 * @category EES_MST_0025
	 * @category manageLostFoundBasic
	 * 
	 * @param LostFoundVO[] lostFoundVOs
	 * @param SignOnUserAccount account
	 * @return List<LostFoundVO>
	 * @exception EventException
	 */		
	public List<LostFoundVO> manageLostFoundBasic(LostFoundVO[] lostFoundVOs, SignOnUserAccount account) throws EventException {

		List<LostFoundVO> selectVoList = new ArrayList<LostFoundVO>();
		List<LostFoundVO> manageVoList = new ArrayList<LostFoundVO>();		
		try {
			int i=0;			
			for(i=0; i<lostFoundVOs.length; i++ ){	
				lostFoundVOs[i].setHCntrStsCd(lostFoundVOs[0].getInputCntrStsCd());				
				lostFoundVOs[i].setHCnmvEvntDt(lostFoundVOs[0].getInputCntrStsEvntDt());				
				lostFoundVOs[i].setHOnhYdCd(lostFoundVOs[0].getInputOnhYdCd());
				
				selectVoList.add(lostFoundVOs[i]);
			}
			selectVoList = dbDao.searchLostFoundListData(selectVoList);								
								
			for(i=0; i<selectVoList.size(); i++ ){	
				
				if( !(selectVoList.get(i).getHChk1().equals("E") ||
					selectVoList.get(i).getHChk2().equals("E") ||		
					selectVoList.get(i).getHChk3().equals("E"))	)
				{			
					lostFoundVOs[i].setCntrRmk(lostFoundVOs[i].getCntrRmk());				
					selectVoList.set(i, lostFoundVOs[i]); 
					
					lostFoundVOs[i].setCreUsrId(account.getUsr_id());					
					lostFoundVOs[i].setUpdUsrId(account.getUsr_id());	
					lostFoundVOs[i].setOfcCd(account.getOfc_cd());
					
					if(!(selectVoList.get(i).getHChk1().equals("") &&
					     selectVoList.get(i).getHChk2().equals("") &&
					     selectVoList.get(i).getHChk2().equals("") ) ){
						manageVoList.add(lostFoundVOs[i]);						
					}									
				}
			}

			if(manageVoList.size() > 0){
				dbDao.addCntrStatusHistorysByLostFoundData(manageVoList);				
				dbDao.modifyCntrMasterByLostFoundData(manageVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lost Found List Save"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Lost Found List Save"}).getMessage(),de);
		}
		return selectVoList;
	}		
	
	/** 
	 * EES_MST_0024 : retrieve <br>
	 * retrieving for Container Status Creation <br>
	 * 
	 * @category EES_MST_0024
	 * @category searchLeaseOutTargetListBasic
	 *   
	 * @param CntrStatusCreationVO[] cntrStatusCreationVOs
	 * @return List<CntrStatusCreationVO>
	 * @exception EventException
	 */	
	public List<CntrStatusCreationVO> searchLeaseOutTargetListBasic(CntrStatusCreationVO[] cntrStatusCreationVOs) throws EventException{
		List<CntrStatusCreationVO> selectVoList = new ArrayList<CntrStatusCreationVO>();		
		try {		
			for ( int i=0; i<cntrStatusCreationVOs.length; i++ ){					
				selectVoList.add(cntrStatusCreationVOs[i]);				
			}
		   if (cntrStatusCreationVOs[0].getStCd().equals("0")){
				return dbDao.searchLeaseOutTargetListData(cntrStatusCreationVOs[0]);
			} else if (cntrStatusCreationVOs[0].getStCd().equals("4")){
				return dbDao.searchMisUseOutTargetListData(cntrStatusCreationVOs[0]);
			//// Add MNR support logic
			} else if (cntrStatusCreationVOs[0].getStCd().equals("1") ||
					   cntrStatusCreationVOs[0].getStCd().equals("2") ||
					   cntrStatusCreationVOs[0].getStCd().equals("3") ||
					   cntrStatusCreationVOs[0].getStCd().equals("5") ||
					   cntrStatusCreationVOs[0].getStCd().equals("6") ||
					   cntrStatusCreationVOs[0].getStCd().equals("7") ||
					   cntrStatusCreationVOs[0].getStCd().equals("8") ||
					   cntrStatusCreationVOs[0].getStCd().equals("9") ||
					   cntrStatusCreationVOs[0].getStCd().equals("10") ||
					   cntrStatusCreationVOs[0].getStCd().equals("11")){
				return dbDao.searchLeaseOutCntrStatusData(cntrStatusCreationVOs[0]);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Status Creation"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Status Creation"}).getMessage(),de);
		}
		return selectVoList;		
	}
	
	/** 
	 * EES_MST_0024 : save <br>
     * saving for Container Status Creation <br>
	 * @category EES_MST_0024
	 * @category manageCntrStatusCreationBasic
	 * @param CntrStatusCreationVO[] cntrStatusCreationVOs
	 * @param SignOnUserAccount account
	 * @return List<CntrStatusCreationVO>
	 * @exception EventException
	 */	
    public List<CntrStatusCreationVO> manageCntrStatusCreationBasic(CntrStatusCreationVO[] cntrStatusCreationVOs, SignOnUserAccount account) throws EventException {
		List<CntrStatusCreationVO> updateVoList = new ArrayList<CntrStatusCreationVO>();			
		List<CntrStatusCreationVO> tmpCntrStatusCreationVOs = new ArrayList<CntrStatusCreationVO>();
    	
		try {			
			if(cntrStatusCreationVOs != null)
			{
				for ( int i=0; i<cntrStatusCreationVOs.length; i++ ) 
				{
					if ( cntrStatusCreationVOs[i].getIbflag().equals("I")){
						cntrStatusCreationVOs[i].setCreUsrId(account.getUsr_id());
						cntrStatusCreationVOs[i].setUpdUsrId(account.getUsr_id());
						cntrStatusCreationVOs[i].setOfcCd(account.getOfc_cd());
						if (i != 0){
							cntrStatusCreationVOs[i].setStCd(cntrStatusCreationVOs[0].getStCd());
							cntrStatusCreationVOs[i].setStsEvntYdCd(cntrStatusCreationVOs[0].getStsEvntYdCd());
							cntrStatusCreationVOs[i].setAgmtCtyCd(cntrStatusCreationVOs[0].getAgmtCtyCd());
							cntrStatusCreationVOs[i].setAgmtSeq(cntrStatusCreationVOs[0].getAgmtSeq());
							cntrStatusCreationVOs[i].setHireDate(cntrStatusCreationVOs[0].getHireDate());
							cntrStatusCreationVOs[i].setApprovalNo(cntrStatusCreationVOs[0].getApprovalNo());
						}
						updateVoList.add(cntrStatusCreationVOs[i]);
					} else if (cntrStatusCreationVOs[i].getIbflag().equals("U")){
						cntrStatusCreationVOs[i].setCreUsrId(account.getUsr_id());
						cntrStatusCreationVOs[i].setUpdUsrId(account.getUsr_id());
						cntrStatusCreationVOs[i].setOfcCd(account.getOfc_cd());
						if (i != 0){
							cntrStatusCreationVOs[i].setStCd(cntrStatusCreationVOs[0].getStCd());
							cntrStatusCreationVOs[i].setStsEvntYdCd(cntrStatusCreationVOs[0].getStsEvntYdCd());
							cntrStatusCreationVOs[i].setAgmtCtyCd(cntrStatusCreationVOs[0].getAgmtCtyCd());
							cntrStatusCreationVOs[i].setAgmtSeq(cntrStatusCreationVOs[0].getAgmtSeq());
							cntrStatusCreationVOs[i].setHireDate(cntrStatusCreationVOs[0].getHireDate());
							cntrStatusCreationVOs[i].setApprovalNo(cntrStatusCreationVOs[0].getApprovalNo());
						}					
						updateVoList.add(cntrStatusCreationVOs[i]);
					}
				}
			}			
			
			CntrStatusCreationVO lCntrStatusCreationVO = new CntrStatusCreationVO();
			for (int i = 0; i < updateVoList.size(); i++){
				lCntrStatusCreationVO = dbDao.validationCurrentStatusData(updateVoList.get(i)); 
				if (!lCntrStatusCreationVO.getAeflg().equals("E") && 
					!lCntrStatusCreationVO.getBeflg().equals("E") &&
					!lCntrStatusCreationVO.getCeflg().equals("E") &&
					!lCntrStatusCreationVO.getDeflg().equals("E") &&
					!lCntrStatusCreationVO.getFeflg().equals("E") &&
					!lCntrStatusCreationVO.getEeflg().equals("E")){
					//in case of LSO, setting LSE_CO_RTN_YD_CD of LSE_AVAL_OFFH with sts_evnt_yd_cd 값으로 넣는다
					if (cntrStatusCreationVOs[0].getStCd().equals("0")){
						lCntrStatusCreationVO.setStsEvntYdCd(lCntrStatusCreationVO.getLseCoRtnYdCd());
					}
					if (!(lCntrStatusCreationVO.getStCd().equals("7") ||
						  lCntrStatusCreationVO.getStCd().equals("8") ||
						  lCntrStatusCreationVO.getStCd().equals("9") || 
						  lCntrStatusCreationVO.getStCd().equals("10"))){
						String nextVal = dbDao.searchMaxCntrStatusHistorySeqData();
						lCntrStatusCreationVO.setHisSeq(nextVal);		
						int result = dbDao.addCntrStatusHistorysData(lCntrStatusCreationVO);
					
						if (result != 1) lCntrStatusCreationVO.setUeflg("E");
					
						int result2 = dbDao.modifyCntrMasterByLastStatusData(lCntrStatusCreationVO);
					
						if (result2 != 1) lCntrStatusCreationVO.setIeflg("E");
					}
				}
				tmpCntrStatusCreationVOs.add(lCntrStatusCreationVO);
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Status Creation"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Status Creation"}).getMessage(),de);
		}
		return tmpCntrStatusCreationVOs;
    }	


	/**
	 * updating Immediate Exit Creation<br>
	 * 
	 * @param ImmediateExitCreationVO[] immediateExitCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateImmediateExitCreationListBasic(ImmediateExitCreationVO[] immediateExitCreationVOs, SignOnUserAccount account) throws EventException {
		try {
			List<ImmediateExitCreationVO> updateVoList = new ArrayList<ImmediateExitCreationVO>();
			
			for(int i = 0; i < immediateExitCreationVOs.length; i++ ) {				
				if(immediateExitCreationVOs[i].getIbflag().equals("U")) {
					immediateExitCreationVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(immediateExitCreationVOs[i]);
				} 
			}
			
			if(updateVoList.size() > 0) {
				dbDao.modifyCntrImdtExitData(updateVoList);				
			}
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ImmediateExitCreationList Update"}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ImmediateExitCreationList Update"}).getMessage(),ex);
		}
	}

	/**
	 * saving Term Change Creation<br>
	 * 
	 * @param TermChangeCreationVO[] termChangeCreationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTermChangeCreationListBasic(TermChangeCreationVO[] termChangeCreationVOs, SignOnUserAccount account) throws EventException {
		try {
			List<TermChangeCreationVO> termChangeCreationVoList = new ArrayList<TermChangeCreationVO>();
			
			List<TermChangeCreationVO> termChangeCreationVoList1 = new ArrayList<TermChangeCreationVO>();		
			List<TermChangeCreationVO> termChangeCreationVoList2 = new ArrayList<TermChangeCreationVO>();
			List<TermChangeCreationVO> termChangeCreationVoList3 = new ArrayList<TermChangeCreationVO>();			
			
			for(int i = 0; i < termChangeCreationVOs.length; i++ ) {
				
				// checking DelChk flg to save
				if(termChangeCreationVOs[i].getDelChk().equals("1")) {
					termChangeCreationVOs[i].setCreUsrId(account.getUsr_id());
					termChangeCreationVOs[i].setUpdUsrId(account.getUsr_id());				
					termChangeCreationVoList.add(termChangeCreationVOs[i]);
				} 
			}

			if(termChangeCreationVoList.size() > 0) {		
				
				int locCnt1 = 0;
				int locCnt2 = 0;
				int locCnt3 = 0;
				
				for(int i = 0; i < termChangeCreationVoList.size(); i++){
					if (termChangeCreationVoList.get(i).getDiFlag().equals("Y")) {
						termChangeCreationVoList1.add(locCnt1, termChangeCreationVoList.get(i));
						locCnt1++;
					} else if (!termChangeCreationVoList.get(i).getCntrStsCd().equals("SBO") && !termChangeCreationVoList.get(i).getCntrStsCd().equals("MUO")){
						termChangeCreationVoList2.add(locCnt2, termChangeCreationVoList.get(i));
						locCnt2++;
					} else {
						termChangeCreationVoList3.add(locCnt3, termChangeCreationVoList.get(i));
						locCnt3++;
					}	
				}
				//DI FLG = Y
				if (locCnt1 > 0){
					dbDao.addTermChangeCntrStatusHistoryDiFlgYData(termChangeCreationVoList1);
				}
				//Di Flg = N & Cntr Status Code != SBO OR MUO
				if (locCnt2 > 0){
					dbDao.addTermChangeCntrStatusHistoryDiFlgNData(termChangeCreationVoList2);
				}
				//DI FLG = N & STSTUS CODE = SBO OR MUO
				if (locCnt3 > 0){
					dbDao.addTermChangeCntrStatusHistoryDiFlgNSBOData(termChangeCreationVoList3);
				}
				
				// MST_CONATINER UPDATE
				dbDao.modifyCntrMasterByTermChangeData(termChangeCreationVoList);	
				
				// RU Label Histroy INSERT
				dbDao.addTermChangeRuLabelHistoryData(termChangeCreationVoList);
				
				if("OW".equals(termChangeCreationVoList.get(0).getAftLstmCd())){
					dbDao.addTermChangeData(termChangeCreationVoList);
				}
			}	
			
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TermChangeCreationList Create"}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TermChangeCreationList Create"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MST_0028 : retrieve <br>
	 * retrieving for Container Status Update
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateTargetBasic 
	 * @param MstEtcVO mstEtcVO
	 * @param SignOnUserAccount account
	 * @return StatusUpdateGRPVO
	 * @exception EventException
	 */	
	public StatusUpdateGRPVO searchCntrStatusUpdateTargetBasic(MstEtcVO mstEtcVO, SignOnUserAccount account) throws EventException {
		try {
			StatusUpdateGRPVO statusUpdateGRPVO = new StatusUpdateGRPVO(); 
			
			//retrieving for Cntr general information
			CntrMstHeadVO cntrMstHeadVO = dbDao.searchCntrStatusUpdateMasterData(mstEtcVO);
			statusUpdateGRPVO.setCntrMstHeadVO(cntrMstHeadVO);
			
			//retrieving for Container Movement Information
			List<MovementVO> movementVOs = dbDao.searchCntrStatusUpdateMovementData(mstEtcVO);
			statusUpdateGRPVO.setMovementVOs(movementVOs);
			
			//retreiving for Container StatusContainer Status Information
			List<StatusHistoryVO> statusHistoryVOs = dbDao.searchCntrStatusUpdateHistoryData(mstEtcVO, account);
			statusUpdateGRPVO.setStatusHistoryVOs(statusHistoryVOs);
			
			return statusUpdateGRPVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),ex);
		}		
	}
	
	
	/**
	 * EES_MST_0028 : retrieve <br>
	 * retrieving for Container Status Update
	 * @category EES_MST_0028
	 * @category searchCntrStatusSearchTargetBasic 
	 * @param MstEtcVO mstEtcVO
	 * @return StatusUpdateGRPVO
	 * @exception EventException
	 */	
	public StatusUpdateGRPVO searchCntrStatusSearchTargetBasic(MstEtcVO mstEtcVO) throws EventException {
		try {
			StatusUpdateGRPVO statusUpdateGRPVO = new StatusUpdateGRPVO(); 
			
			//retreiving for Container StatusContainer Status Information
			List<StatusHistoryVO> statusHistoryVOs = dbDao.searchCntrStatusSearchData(mstEtcVO);
			statusUpdateGRPVO.setStatusHistoryVOs(statusHistoryVOs);
			
			return statusUpdateGRPVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),ex);
		}		
	}
	
	
	/** 
	 * EES_MST_0028 : save <br>
	 * saving Container Status Update
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateChkBasic  
	 * @param StatusHistoryVO[] statusHistoryVOs
	 * @param SignOnUserAccount		account
	 * @return String
	 * @exception EventException
	 */
	 public String searchCntrStatusUpdateChkBasic(StatusHistoryVO[] statusHistoryVOs, SignOnUserAccount account) throws EventException {
			
		String chkCntrCnt = "";
		String chkCntr = "";
		try {
			if(statusHistoryVOs != null)
			{
				for ( int i=0; i<statusHistoryVOs.length; i++ ) 
				{
					StatusHistoryVO lstatusHistoryVO = new StatusHistoryVO();
					lstatusHistoryVO = statusHistoryVOs[i];
					if (lstatusHistoryVO.getIbflag().equals("D")){
						if (lstatusHistoryVO.getCntrNo().length() == 10){
							lstatusHistoryVO.setCntrNo(statusHistoryVOs[0].getCntrNo()+statusHistoryVOs[0].getChkDgt());
						} else {
							lstatusHistoryVO.setCntrNo(statusHistoryVOs[0].getCntrNo());	
						}
						
						chkCntrCnt = dbDao.checkCntrStatusCnt(lstatusHistoryVO); 
						if("Y".equals(chkCntrCnt)) {
							chkCntr = lstatusHistoryVO.getCntrNo();
							break;
						}
					} 
				}
			}
			
			return chkCntr;
			//return tmpStatusHistoryVOs after this method done
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),de);
		}
    }
	 
	/** 
	 * EES_MST_0028 : save <br>
	 * retrieving for Container Status Update를 저장합니다.
	 * @category EES_MST_0028
	 * @category manageCntrStatusUpdateBasic  
	 * @param StatusHistoryVO[] statusHistoryVOs
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */	
    public void manageCntrStatusUpdateBasic(StatusHistoryVO[] statusHistoryVOs, SignOnUserAccount account) throws EventException {
		List<StatusHistoryVO> tmpStatusHistoryVOs = new ArrayList<StatusHistoryVO>();
		boolean islastDel = false;
		try {
			if(statusHistoryVOs != null)
			{
				for ( int i=0; i<statusHistoryVOs.length; i++ ) 
				{
					StatusHistoryVO lstatusHistoryVO = new StatusHistoryVO();
					lstatusHistoryVO = statusHistoryVOs[i];
					if (lstatusHistoryVO.getIbflag().equals("U")){
						lstatusHistoryVO.setUpdUsrId(account.getUsr_id());
						if (lstatusHistoryVO.getCntrNo().length() == 10){
							lstatusHistoryVO.setCntrNo(statusHistoryVOs[0].getCntrNo()+statusHistoryVOs[0].getChkDgt());
						} else {
							lstatusHistoryVO.setCntrNo(statusHistoryVOs[0].getCntrNo());	
						}
						
						lstatusHistoryVO.setOfcCd(account.getOfc_cd());
						lstatusHistoryVO = dbDao.modifyCntrStatusHistoryByUpdateData(lstatusHistoryVO);
						lstatusHistoryVO = dbDao.modifyMvmtHistorybyUpdateDataUSQL(lstatusHistoryVO);
						tmpStatusHistoryVOs.add(i,lstatusHistoryVO);
					} else if (lstatusHistoryVO.getIbflag().equals("D")){
						if (i == statusHistoryVOs.length - 1){
						   islastDel = true;
						}
						if (lstatusHistoryVO.getCntrNo().length() == 10){
							lstatusHistoryVO.setCntrNo(statusHistoryVOs[0].getCntrNo()+statusHistoryVOs[0].getChkDgt());
						} else {
							lstatusHistoryVO.setCntrNo(statusHistoryVOs[0].getCntrNo());	
						}
						
						lstatusHistoryVO = dbDao.removeCntrStatusHistoryByUpdateData(lstatusHistoryVO);
						lstatusHistoryVO = dbDao.removeCntrMasterByUpdateData(lstatusHistoryVO);
						
						//Container Master 데이타를 확인하여 데이타가 없다면 MST_CNTR_LOT 데이타 삭제
						lstatusHistoryVO = dbDao.removeCntrLotDeleteData(lstatusHistoryVO);
						//Container Master 데이터를 확인하여 데이터가 없으면 Initial Movement Data도 삭제 한다.
						lstatusHistoryVO = dbDao.removeInitialOwnMovementDeleteData(lstatusHistoryVO);
						tmpStatusHistoryVOs.add(i,lstatusHistoryVO);
					} else {
						tmpStatusHistoryVOs.add(i,lstatusHistoryVO);
					}
				}
				
				if (!islastDel){
			    	statusHistoryVOs[0].setUpdUsrId(account.getUsr_id());
			    	dbDao.modifyCntrMasterByUpdateData(statusHistoryVOs[0]);
				}
			}
			//return tmpStatusHistoryVOs after this method done
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),de);
		}
    }
    
	/** 
	 * EES_MST_0028 : save <br>
	 * saving Container Status Update
	 * @category EES_MST_0028
	 * @category modifyCntrMasterByUpdateBasic   
	 * @param StatusHistoryVO statusHistoryVO
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */	    
    public void modifyCntrMasterByUpdateBasic(StatusHistoryVO statusHistoryVO, SignOnUserAccount account) throws EventException {
		try {			
			statusHistoryVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyCntrMasterByUpdateData(statusHistoryVO);				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{" Container Master Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{" Container Master Update"}).getMessage(),de);
		}
    }    
	
	/**
	 * updationg CNTR Master Information required from CIM/CTM<br>
	 * in case of interface with CTM, don't make exception for handling many case 
	 * @param CrossItemVO crossItemVO
	 * @return String
	 * @exception EventException
	 */
	public String updateCntrMasterByMvmtBasic (CrossItemVO crossItemVO) throws EventException {
		CntrStdInfoVO  cntrStdInfoVO = new CntrStdInfoVO ();
		try {
			if (!("Y".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())) && crossItemVO.getUpdateMaster()){
				if(crossItemVO.getCusCtmMovementVO().getNewFlg()=="C"){
					cntrStdInfoVO=null;
					cntrStdInfoVO = dbDao.searchCntrStdInfoData();					
				}
				dbDao.modifyCntrMasterByMvmtData(crossItemVO.getCusCtmMovementVO(),cntrStdInfoVO);
			}

			if("X".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				// in case of SH
				dbDao.addCntrStatusHistoryByMvmtData(crossItemVO.getCusCtmMovementVO());				
			}
			
			if("Y".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				// in case of SH & after removing XX in MOVEMENT, call to remove LSO data
				dbDao.removeCntrStatusHistoryByMvmtDeleteData(crossItemVO.getCusCtmMovementVO());
				dbDao.modifyCntrMasterByMvmtDeleteData(crossItemVO.getCusCtmMovementVO());
			}
			
			if ("Z".equals(crossItemVO.getCusCtmMovementVO().getNewFlg()) || 
				"K".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				// in case of LSO, LSI or in case of K 
				dbDao.modifyCntrMasterByMvmtDeleteData(crossItemVO.getCusCtmMovementVO());
			}
			
			//updating history, in case of accepting or canceling request from CTM
			if ("B".equals(crossItemVO.getCusCtmMovementVO().getNewFlg()) || 
				"C".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				dbDao.modifyCntrStatusHistoryByMvmtData(crossItemVO.getCusCtmMovementVO());
			}
			
			return "";
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Master Update"}).getMessage(),de);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Master Update"}).getMessage(),e);
		}
	}		
		
	/**
	 * updating Approval Number of OW Term CNTR On hire Approval<br>
	 * 
	 * @param OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateAuthNoBasic(OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OnhireApprovalOwnListVO> onhireApprovalOwnListVOList = new ArrayList<OnhireApprovalOwnListVO>();
			
			for(int i = 0; i < onhireApprovalOwnListVOs.length; i++ ) {
				onhireApprovalOwnListVOs[i].setUpdUsrId(account.getUsr_id());								
				if(onhireApprovalOwnListVOs[i].getIbflag().equals("D")) {
					onhireApprovalOwnListVOList.add(onhireApprovalOwnListVOs[i]);
				} 
			}

			if(onhireApprovalOwnListVOList.size() > 0) {				
				dbDao.modifyAuthNoCntrMasterData(onhireApprovalOwnListVOList);
				dbDao.modifyAutnNoCntrStatusHistoryData(onhireApprovalOwnListVOList);				
			}	
			
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalOwnList Create"}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalOwnList Create"}).getMessage(),ex);
		}
	}

   	
	/**
	 * creating CNTR Status in Miss Use Approval<br>
	 * 
	 * @param IFMnrFlagVO[] iFMnrFlagVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMNRStatusBasic(IFMnrFlagVO[] iFMnrFlagVOs, SignOnUserAccount account) throws EventException {
		try {
			List<IFMnrFlagVO> iFMnrFlagVOList = new ArrayList<IFMnrFlagVO>();	
			IFGateVO iFGateVO = new IFGateVO();
			CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();			
						
			for(int i = 0; i < iFMnrFlagVOs.length; i++ ) {				

				if( iFMnrFlagVOs[i].getFlagType().equals("DMG") ||
				    iFMnrFlagVOs[i].getFlagType().equals("DSP") ||
				    iFMnrFlagVOs[i].getFlagType().equals("HGR") ){					
					iFMnrFlagVOList.add(iFMnrFlagVOs[i]);
				}else{	
					if("Y".equals(iFMnrFlagVOs[i].getStsFlag())){ // stsFlag : Y
						dbDao.addCntrStatusHistorysByMNRStatusData(iFMnrFlagVOs[i]);	
					} else {  // if stsFlag = Y then Delete TLL, SCR, DON
						dbDao.removeCntrStatusHistoryByCancelTTLData(iFMnrFlagVOs[i]);	
					}
																				
					cusCtmMovementVO.setCntrNo(iFMnrFlagVOs[i].getEqNo());
					cusCtmMovementVO.setOrgYdCd(iFMnrFlagVOs[i].getFlagYdCd());
					cusCtmMovementVO.setCnmvEvntDt(iFMnrFlagVOs[i].getFlagDt ());
					cusCtmMovementVO.setCnmvRmk(iFMnrFlagVOs[i].getFlagType());
				
					if("Y".equals(iFMnrFlagVOs[i].getStsFlag())){ // stsFlag : Y
						cusCtmMovementVO.setMvmtStsCd("XX");
					}else{		// stsFlag : N  Movement 삭제
						
						CrntMvmtInfoVO crntMvmtInfoVO = dbDao.searchCntrCrntMvmtInfoData(iFMnrFlagVOs[i]);

						if(crntMvmtInfoVO != null) {
							cusCtmMovementVO.setIbflag("D");
							cusCtmMovementVO.setMvmtStsCd(crntMvmtInfoVO.getCnmvStsCd());
							cusCtmMovementVO.setCnmvIdNo(crntMvmtInfoVO.getCnmvIdNo());
							cusCtmMovementVO.setCnmvYr(crntMvmtInfoVO.getCnmvYr());							
						} else {
							cusCtmMovementVO.setMvmtStsCd("MT"); // Delete가 안될 경우 데이터를 못 찾을 경우 MT로 처리
						}

					}
										
					iFGateVO.setCntrNo(iFMnrFlagVOs[i].getEqNo());
					iFGateVO.setCnmvEvntDt(iFMnrFlagVOs[i].getFlagDt ());
					
					String evntDt = dbDao.searchMvmtTimeData ( iFGateVO ); //2010.06.16 로직추가 NKJH
					
					cusCtmMovementVO.setCnmvEvntDt(evntDt);
					
					cusCtmMovementVO.setCreUsrId(iFMnrFlagVOs[i].getFlagUserId());
					cusCtmMovementVO.setUpdUsrId(iFMnrFlagVOs[i].getFlagUserId());					
					cusCtmMovementVO.setPType1(iFMnrFlagVOs[i].getStsFlag());
					cusCtmMovementVO.setPType2(iFMnrFlagVOs[i].getHbType());
					
					ContainerMovementMgtBC cmd = new ContainerMovementMgtBCImpl();
					cusCtmMovementVO = cmd.manageCntrInfoFromMst(cusCtmMovementVO, account);
					
					cusCtmMovementVO.setCntrNo(iFMnrFlagVOs[i].getEqNo());
					cusCtmMovementVO.setUpdUsrId(account.getUsr_id());					
					dbDao.modifyCntrMasterByMNRStatusData(cusCtmMovementVO);																				
				}
			}
			
			if(iFMnrFlagVOList.size() > 0){
				dbDao.modifyCntrMasterByMNRFlaggingData(iFMnrFlagVOList);				
			}				
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"MNR Status Create"}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"MNR Status Create"}).getMessage(),ex);
		}
	}    
 
	/**
	 * modifying CNTR Master Information required from CTM<br>
	 * 
	 * @param IFGateVO[] iFGateVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void createMvmtBasic(IFGateVO[] iFGateVOs, SignOnUserAccount account) throws EventException {		
		try {						
			CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
			
			for(int i=0; i<iFGateVOs.length; i++){
				cusCtmMovementVO.setCntrNo(iFGateVOs[i].getCntrNo());
				cusCtmMovementVO.setOrgYdCd(iFGateVOs[i].getOrgYdCd());
				String cnmvEvntDt = dbDao.searchMvmtTimeData(iFGateVOs[i]);
				cusCtmMovementVO.setCnmvEvntDt(cnmvEvntDt);
				cusCtmMovementVO.setCnmvRmk(iFGateVOs[i].getCntrStsCd());
				cusCtmMovementVO.setMvmtStsCd(iFGateVOs[i].getMvmtStsCd());
				cusCtmMovementVO.setMvmtCreTpCd("E");
				cusCtmMovementVO.setIbflag(iFGateVOs[i].getIbflag());
				cusCtmMovementVO.setCnmvIdNo(iFGateVOs[i].getCnmvIdNo());
				cusCtmMovementVO.setCnmvYr(iFGateVOs[i].getCnmvYr());
				cusCtmMovementVO.setUpdUsrId(account.getUsr_id());
				
				if(iFGateVOs[i].getBackDateFlg().equals("Y")) {
					dbDao.modifyCntrMasterforLstMVMTData(cusCtmMovementVO);
				} else {							
					ContainerMovementMgtBC cmd = new ContainerMovementMgtBCImpl();
					cusCtmMovementVO = cmd.manageCntrInfoFromMst(cusCtmMovementVO, account);					
					if(iFGateVOs[i].getIbflag() == null){
						dbDao.modifyCntrMasterByOnOffHireData(cusCtmMovementVO);
					}					
				}
			}			
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Creation/Update"}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Creation/Update"}).getMessage(),ex);
		}		
	}
	
	/**
	 * updating L/Staying, Unclaim Flag<br>
	 * 
	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateCntrMasterByLongStayCreationBasic(LongStayUclmDetailVO[] longStayUclmDetailVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<LongStayUclmDetailVO> updateVoList = new ArrayList<LongStayUclmDetailVO>();

			if(longStayUclmDetailVOs != null) {
				for ( int i=0; i<longStayUclmDetailVOs.length; i++ ) {
					String uclmLsDivCd = "";
					if (longStayUclmDetailVOs[i].getLsFlg().equals("1")) {
						uclmLsDivCd = "L";
					}
					if (longStayUclmDetailVOs[i].getUcFlg().equals("1")) {
						uclmLsDivCd = "U";
					}
					if ( uclmLsDivCd.equals("") ) {
						longStayUclmDetailVOs[i].setUclmRsn("");
					}					
					longStayUclmDetailVOs[i].setUclmLsDivCd(uclmLsDivCd);
					longStayUclmDetailVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(longStayUclmDetailVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrMasterByLongStayCreationData(updateVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"L/S & U/C Creation Create"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"L/S & U/C Creation Create"}).getMessage(),de);
		}
	}
	
	/**
	 * EES_MST_0046 : retrieve <br>
	 * retrieving for Manufacture Date & Manufacturer Inquiry and Update
	 * @category EES_MST_0046
	 * @category searchCntrManufactureInfoBasic 
	 * @param CntrManufactureListVO[] cntrManufactureListVOs
	 * @return List<CntrManufactureInfoVO> 
	 * @exception EventException
	 */	
	public List<CntrManufactureInfoVO> searchCntrManufactureInfoBasic(CntrManufactureListVO[] cntrManufactureListVOs) throws EventException {
		try {
			List<CntrManufactureInfoVO> list = new ArrayList<CntrManufactureInfoVO>();
			if (cntrManufactureListVOs[0].getCntrNo().equals("")){
				list = dbDao.searchCntrManufactureInfoListData(cntrManufactureListVOs[0]);
			} else {
				list = dbDao.searchCntrManufactureInfoData(cntrManufactureListVOs);
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Date & Manufacturer Inquiry and Update"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Date & Manufacturer Inquiry and Update"}).getMessage(),ex);
		}		
	}
	
	/**
	 * EES_MST_0046 : save <br>
	 * saving Manufacture Date & Manufacturer Inquiry and Update
	 * @category EES_MST_0046
	 * @category modifyCntrManufactureInfoBasic 
	 * @param CntrManufactureInfoVO[] cntrManufactureInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrManufactureInfoBasic(CntrManufactureInfoVO[] cntrManufactureInfoVOs, SignOnUserAccount account) throws EventException {
    	List<CntrManufactureInfoVO> updateVoList = new ArrayList<CntrManufactureInfoVO>();
		try {			
			for(int i=0; i < cntrManufactureInfoVOs.length; i++){
				if (!cntrManufactureInfoVOs[i].getAeflg().equals("E") &&
						!cntrManufactureInfoVOs[i].getBeflg().equals("E") &&
						!cntrManufactureInfoVOs[i].getCeflg().equals("E") &&
						!cntrManufactureInfoVOs[i].getDeflg().equals("E")){
					cntrManufactureInfoVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cntrManufactureInfoVOs[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrManufactureInfoData(updateVoList);	
			}
						
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Date & Manufacturer Inquiry and Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Manufacture Date & Manufacturer Inquiry and Update"}).getMessage(),de);
		}
    }
    
    /**
	  * EES_MST_0047 : retrieve <br>
	 * retrieving for Reefer Unit Info Inquiry and Update
	 * @category EES_MST_0047
	 * @category searchCntrReeferUnitInfoBasic 
	 * @param CntrReeferUnitListVO[] cntrReeferUnitListVOs
	 * @return List<CntrReeferUnitInfoVO> 
	 * @exception EventException
	 */	
	public List<CntrReeferUnitInfoVO> searchCntrReeferUnitInfoBasic(CntrReeferUnitListVO[] cntrReeferUnitListVOs) throws EventException {
		try {
			List<CntrReeferUnitInfoVO> list = new ArrayList<CntrReeferUnitInfoVO>();
			
			if (cntrReeferUnitListVOs[0].getCntrNo().equals("")){ // Excel UpLoad가 아닌 Container 정보 조회
				list = dbDao.searchCntrReeferUnitInfoListData(cntrReeferUnitListVOs[0]);
			} else {
				list = dbDao.searchCntrReeferUnitInfoData(cntrReeferUnitListVOs);
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Reefer Unit Info Inquiry and Update"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Reefer Unit Info Inquiry and Update"}).getMessage(),ex);
		}		
	}
	
	/**
	 * EES_MST_0047 : save <br>
	 * saving Reefer Unit Info Inquiry and Update
	 * @author NamKoong JinHo
	 * @category EES_MST_0047
	 * @category modifyCntrReeferUnitInfoBasic 
	 * @param CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
    public void modifyCntrReeferUnitInfoBasic(CntrReeferUnitInfoVO[] cntrReeferUnitInfoVOs, SignOnUserAccount account) throws EventException {
    	List<CntrReeferUnitInfoVO> updateVoList = new ArrayList<CntrReeferUnitInfoVO>();
		try {			
			for(int i=0; i < cntrReeferUnitInfoVOs.length; i++){
					cntrReeferUnitInfoVOs[i].setUsrId(account.getUsr_id());
					updateVoList.add(cntrReeferUnitInfoVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCntrReeferUnitInfoData(updateVoList);	
			}
						
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Reefer Unit Info Inquiry and Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Reefer Unit Info Inquiry and Update"}).getMessage(),de);
		}
    }
    
    /** 
	 * EES_MST_0017 : retrieve <br>
	 * Own Container Interface to ERP FA를 조회합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0017
	 * @category searchFATargetListBasic
	 * @param MstEtcVO mstEtcVO
	 * @return List<FaTargetListVO>
	 * @exception EventException
	 */	
	public List<FaTargetListVO> searchFATargetListBasic(MstEtcVO mstEtcVO) throws EventException {
		try {
			 return dbDao.searchFATargetListData(mstEtcVO);	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Own Container Interface to ERP FA"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Own Container Interface to ERP FA"}).getMessage(),de);
		}
	}
	
	/** 
	 * EES_MST_0017 : save<br>
	 * Own Container Interface to ERP FA를 저장합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0017
	 * @category updateCntrSendToFABasic 
	 * @param FaTargetListVO[] faTargetListVOs
	 * @param SignOnUserAccount		account
	 * @return List<FaTargetListVO> 
	 * @exception EventException
	 */
    public List<FaTargetListVO> updateCntrSendToFABasic(FaTargetListVO[] faTargetListVOs, SignOnUserAccount account) throws EventException {
		List<FaTargetListVO> updateVoList = new ArrayList<FaTargetListVO>();
		List<FaTargetListVO> tmpFaTargetListVOs = new ArrayList<FaTargetListVO>();
		try {
			if(faTargetListVOs != null)
			{
				String fastscd = "";
				if (faTargetListVOs[0].getHidType().equals("0")){
					fastscd = "OW";
				} else {
					fastscd = "TC";
				}
				faTargetListVOs[0].setFaIfGrpSeq(fastscd);
				String faIfGrpSeq = dbDao.searchFAGrpSeqNoData(faTargetListVOs[0]);				
				
				for ( int i=0; i<faTargetListVOs.length; i++ ) 
				{
					if (faTargetListVOs[i].getIbflag().equals("U")){
						faTargetListVOs[i].setUpdUsrId(account.getUsr_id());
						faTargetListVOs[i].setHidType(faTargetListVOs[0].getHidType());
					    faTargetListVOs[i].setFaIfGrpSeq(faIfGrpSeq);
					    faTargetListVOs[i].setDeYrmon(faTargetListVOs[0].getDeYrmon());
						updateVoList.add(faTargetListVOs[i]);
					} 
				}
			
				tmpFaTargetListVOs = dbDao.modifyCntrMastersSendToFAData (updateVoList);
				//OW
				if (tmpFaTargetListVOs.get(0).getHidType().equals("0")){
					dbDao.modifyCntrLotsFAInterfaceData(tmpFaTargetListVOs);
				}
				//Term Change
				else if (tmpFaTargetListVOs.get(0).getHidType().equals("1")){
					dbDao.modifyCntrTermChangesFAInterfaceData(tmpFaTargetListVOs);
				}
			}				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Own Container Interface to ERP FA"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Own Container Interface to ERP FA"}).getMessage(),de);
		}
		return tmpFaTargetListVOs;
    }

	/** 
	 * EES_MST_0017 : save<br>
	 * Own Container Interface to ERP FA를 전송합니다. <br>
	 * @author LEE HO SUN
	 * @category EES_MST_0017
	 * @category sendToFABasic 
	 * @param List<FaTargetListVO> faTargetListVOs
	 * @exception EventException
	 */    
    public void sendToFABasic(List<FaTargetListVO> faTargetListVOs) throws EventException {
		List<FaCntrListVO> tmpFaCntrListVOs = new ArrayList<FaCntrListVO>();    	
		try {
			for (int i=0; i<faTargetListVOs.size(); i++){
				tmpFaCntrListVOs = dbDao.searchCntrToFAData(faTargetListVOs.get(i));
				this.sendCntrToFAData(tmpFaCntrListVOs);// ==> EAI 연계
			} 			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Own Container Interface to ERP FA"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Own Container Interface to ERP FA"}).getMessage(),de);
		}
    }
    
    /**
 	 * EES_MST_0017 : save <br>
 	 * EAI JMS Send FNS026-0001호출 비동기 요청한다. <br>
 	 * @author LEE HO SUN
 	 * @category EES_MST_0017_1
 	 * @category sendCntrToFAData  
 	 * @param List<FaCntrListVO> faCntrListVOs
 	 * @return String
 	 * @throws DAOException
 	 */
 	private String sendCntrToFAData(List<FaCntrListVO> faCntrListVOs) throws DAOException {

 		String reString 	= 	"";
 		List<FaCntrListVO> tmpFaCntrListVOs = null;
 		
 		try{
 			int listsize = faCntrListVOs.size();
 			int tmpsize = 1000;
 			if (listsize > 1000){
 				while (tmpsize <= listsize){
 					tmpFaCntrListVOs = new ArrayList<FaCntrListVO>();
 					for(int i = tmpsize - 1000; i < tmpsize; i++){
 						tmpFaCntrListVOs.add(faCntrListVOs.get(i));
 					}
 					eaiDao.sendCntrToFADataSub(tmpFaCntrListVOs);
 					if (tmpsize > listsize) break;
 					tmpsize = tmpsize + 1000;
 					if (tmpsize > listsize){ 
 						tmpFaCntrListVOs = new ArrayList<FaCntrListVO>();
 						for(int i = tmpsize - 1000; i < listsize; i++){
 							tmpFaCntrListVOs.add(faCntrListVOs.get(i));
 						}
 						eaiDao.sendCntrToFADataSub(tmpFaCntrListVOs);
 						break;
 					}	
 				}
 			} else {
 				eaiDao.sendCntrToFADataSub(faCntrListVOs);
 			}
 		} catch (Exception e) {
 			throw new DAOException(e.getMessage());
 		}
 		return reString;
 	}

 	/** 
	 * FNS026R001 : EAI receive
	 * FNS026R001을 호출하여 Receive 합니다.<br>
	 * @author LEE HO SUN
	 * @category FNS0260001
	 * @category receiveFABasic    
	 * @param CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs
	 * @param SignOnUserAccount		account
	 * @exception EventException
	 */	
    public void receiveFABasic(CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs, SignOnUserAccount account) throws EventException {
		List<CntrMasterUpdateIFVO> uptOWcntrMasterUpdateIFVOs = new ArrayList<CntrMasterUpdateIFVO>();
		List<CntrMasterUpdateIFVO> uptTPcntrMasterUpdateIFVOs = new ArrayList<CntrMasterUpdateIFVO>();
		List<CntrMasterUpdateIFVO> tmpcntrMasterUpdateIFVOs = new ArrayList<CntrMasterUpdateIFVO>();
		List<CntrMasterUpdateIFVO> tmpcntrMasterUpdateIFVOs_1 = new ArrayList<CntrMasterUpdateIFVO>();
		
		String chkcnt = "";
		String chkecnt = "";
		
		try {
			if(cntrMasterUpdateIFVOs != null)
			{
				for (int i=0; i<cntrMasterUpdateIFVOs.length; i++ ) 
				{
					tmpcntrMasterUpdateIFVOs.add(i, cntrMasterUpdateIFVOs[i]);
					
					if (!cntrMasterUpdateIFVOs[i].getFaIfGrpSeqNo().equals("") && cntrMasterUpdateIFVOs[i].getFaIfGrpSeqNo().substring(0,2).equals("OW")){
						uptOWcntrMasterUpdateIFVOs.add(cntrMasterUpdateIFVOs[i]);
					} else if (!cntrMasterUpdateIFVOs[i].getFaIfGrpSeqNo().equals("") && cntrMasterUpdateIFVOs[i].getFaIfGrpSeqNo().substring(0,2).equals("TC")){
						uptTPcntrMasterUpdateIFVOs.add(cntrMasterUpdateIFVOs[i]);
					}
				}
				
				if (tmpcntrMasterUpdateIFVOs.size() > 0){
					for (int i=0; i<tmpcntrMasterUpdateIFVOs.size(); i++){
						tmpcntrMasterUpdateIFVOs.get(i).setGubun("0");
					}
					//Gubun이 0 Cntr No로 Update
					dbDao.modifyCntrMastersReceiveFAData(tmpcntrMasterUpdateIFVOs);
				}
				if (tmpcntrMasterUpdateIFVOs.size() > 0){
					chkcnt = dbDao.checkCountReceiveFAData(tmpcntrMasterUpdateIFVOs.get(0));
					chkecnt = dbDao.checkErrorCountReceiveFAData(tmpcntrMasterUpdateIFVOs.get(0));
					
					if (!chkecnt.equals("0")){
					   chkcnt = "E";
				    }					
				}
				if (chkcnt.equals("E")){
					//Err 발생한 경우 err flg set
					if (uptOWcntrMasterUpdateIFVOs.size() > 0){
						for(int i = 0; i < uptOWcntrMasterUpdateIFVOs.size(); i++){
							uptOWcntrMasterUpdateIFVOs.get(i).setFaIfStsCd("N");
						} 
					}
					if (uptTPcntrMasterUpdateIFVOs.size() > 0){
						for(int i = 0; i < uptTPcntrMasterUpdateIFVOs.size(); i++){
							uptTPcntrMasterUpdateIFVOs.get(i).setFaIfStsCd("N");
						} 
					}
				} else {
					//Err가 발생하지 않았을때 정상 flg
					if (uptOWcntrMasterUpdateIFVOs.size() > 0){
						for(int i = 0; i < uptOWcntrMasterUpdateIFVOs.size(); i++){
							uptOWcntrMasterUpdateIFVOs.get(i).setFaIfStsCd("Y");
						} 
					}
					if (uptTPcntrMasterUpdateIFVOs.size() > 0){
						for(int i = 0; i < uptTPcntrMasterUpdateIFVOs.size(); i++){
							uptTPcntrMasterUpdateIFVOs.get(i).setFaIfStsCd("Y");
						} 
					}
				}
				//Err가 발생하거나 count가 일치한경우
				if (chkcnt.equals("E") || chkcnt.equals(tmpcntrMasterUpdateIFVOs.get(0).getIfTtlRowKnt())){
					if (uptOWcntrMasterUpdateIFVOs.size() > 0){
						dbDao.modifyCntrLotsFAReceiveData(uptOWcntrMasterUpdateIFVOs.get(0));
					}
					if (uptTPcntrMasterUpdateIFVOs.size() > 0){
						dbDao.modifyCntrTermChangesFAReceiveData(uptTPcntrMasterUpdateIFVOs.get(0));
					}
					
                    if (!chkcnt.equals("E")){
    					for (int i=0; i<tmpcntrMasterUpdateIFVOs.size(); i++){
    						tmpcntrMasterUpdateIFVOs.get(i).setGubun("1");
    					}
    					//Gubun이 1 FA_IF_GRP_SEQ_NO로 'C' (Complete) Update
    					tmpcntrMasterUpdateIFVOs_1.add(0, tmpcntrMasterUpdateIFVOs.get(0));
    					dbDao.modifyCntrMastersReceiveFAData(tmpcntrMasterUpdateIFVOs_1);
                    }					
				}
			}				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"FNS0260001 Receieve Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"FNS0260001 Receieve Update"}).getMessage(),de);
		}
    }	
    
    /**
	 * retrieving for Lot No of Own Container<br>
	 * 
     * @category EES_MST_0016_01
     * @category searchLotInfoBasic
     * 
     * @param	CntrLotVO cntrLotVO
     * @return	CntrLotVO 
	 * @exception EventException
	 */
    public CntrLotVO searchValidaionSpecNoTpsz(CntrLotVO cntrLotVO) throws EventException {
		try {
			String cntr_tpsz_cd = cntrLotVO.getCntrTpszCd();
			String result = "F";
			cntrLotVO.setCntrTpszCd(cntr_tpsz_cd);
			result = dbDao.searchValidaionSpecNoTpsz(cntrLotVO);
			cntrLotVO.setMessageErr(result);
			return cntrLotVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Lot No Search"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Own Container Lot No Search"}).getMessage(),de);
		}
    }
    
	/**                       
	 * retrieving for Eq Type Size List of Agreement<br>
	 * 
	 * @param MstEtcVO mstEtcVO
	 * @return List<MstEtcVO>
	 * @exception EventException
	 */
	public List<MstEtcVO> searchEqTypeSizeListOfAgmt(MstEtcVO mstEtcVO) throws EventException {
		try {
			return dbDao.searchEqTypeSizeListOfAgmt(mstEtcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search TP/SZ"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search TP/SZ"}).getMessage(),ex);
		}
	}
	
    /** 
	 * EES_MST_0055 : retrieve <br>
	 * Searching Container List Information of Interface to ERP FA
	 * @author UN JEONG
	 * @category EES_MST_0055
	 * @category searchFACntrListInfo
	 * @param MstEtcVO mstEtcVO
	 * @return List<FACntrListInfoVO>
	 * @exception EventException
	 */	
	public List<FACntrListInfoVO> searchFACntrListInfo(MstEtcVO mstEtcVO) throws EventException { 
		try {
			 return dbDao.searchFACntrListInfo(mstEtcVO);	
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{""}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{""}).getMessage(),de);
		}
	}
    
    /**
	 * retrieving for Lot No of Own Container<br>
	 * 
     * @category EES_MST_0016_01
     * @category searchLotInfoBasic
     * 
     * @param	String cntrNo
     * @param	String hireDate
     * @return	String 
	 * @exception EventException
	 */
    public String  checkBackDatebyCntr(String cntrNo, String hireDate) throws EventException {
		try {

			String chkFlg = "N";
			chkFlg = dbDao.checkBackDatebyCntr(cntrNo, hireDate);
			return chkFlg;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Check BackDate Flag"}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Check BackDate Flag"}).getMessage(),de);
		}
    }	
}
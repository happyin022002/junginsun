/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerOnOffhireBCImpl.java
*@FileTitle : ContainerOnOffhire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.06.03 김석준
* 1.0 Creation
* ========================================================
* 2010.07.16 남궁진호 : sendCntrToFAData 메소드를 ContainerOnOffhireEAIDAO에서
*                     BC단으로 올림.
* 2010.08.04 남궁진호: 중복 try 문제거(소스품질검토지적사항) 
* 2010.08.20 남궁진호 : Ticket ID : CHM-201005431-01,메소드 파라메타 변경  
*                     searchCntrManufactureInfoBasic   
* 2010.10.05 남궁진호 [CHM-201006272-01] Session User Id 변경, CreUsrId -> UsrId
*                    manageCntrStatusUpdateBasic     
* 2010.10.19 남궁진호 [CHM-201006507-01] EES_MST_0047 신규화면추가
*                    modifyCntrReeferUnitInfoBasic,searchCntrReeferUnitInfoBasic   
* 2011.04.27 남궁진호 [CHM-201110291-01] MNR SOLD Cancel 기능 추가에따른  기능보완
*                   createMNRStatusBasic - SLD Cancel시 cntr_sts_his 삭제기능 추가
*                   공통기능의 DBDAO를 하나로 통합
*                   updateCntrMasterByMvmtBasic 
*                   manageCntrStatusUpdateBasic
* 2013.03.13 채창호    [CHM-201323498-01] ALPS Maater-Status에서 SOC 장비의 OC/OP상태에서 Movement XX 처리 로직 Upgarde  요청
* 2013.06.19 채창호    [CHM-201324954-01] Master에서 SOC creation시 CTM의 OC event date 확인기능 추가
* 2013.11.25 채창호    [CHM-201327495] ALPS Master Ststus Creation in MST and MNR TLL /DON/SLD       
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireDBDAO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration.ContainerOnOffhireEAIDAO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.ApprovalListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrLotVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitInfoVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrReeferUnitListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrStatusCreationVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.FaCntrListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.IFGateVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LeasedCntrVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LostFoundVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.LotNoListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MovementVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusUpdateGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EquipmentManagement Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Suk Jun Kim
 * @see EES_MST_0032EventResponse,ContainerOnOffhireBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ContainerOnOffhireBCImpl extends BasicCommandSupport implements ContainerOnOffhireBC 
{

	// Database Access Object
	private transient ContainerOnOffhireDBDAO dbDao = null;
	private transient ContainerOnOffhireEAIDAO eaiDao = null;
	
	/**
	 * ContainerOnOffhireDBDAO를 생성한다.<br>
	 */
	public ContainerOnOffhireBCImpl() 
	{ 
		dbDao  = new ContainerOnOffhireDBDAO();
		eaiDao = new ContainerOnOffhireEAIDAO();
		
	}

	/** 
	 * EES_MST_0019, EES_MST_0044 : retrieve <br>
	 * Container Master Inquiry, Container Master Update를 리스트 조회처리합니다.<br>
	 * @author LEE HO SUN
	 * @category EES_MST_0019, EES_MST_0044
	 * @category searchCntrMasterInquiryBasic    
	 * @param MstEtcVO   mstEtcVO
	 * @return CntrMasterInquiryVO
	 * @exception EventException
	 */	
	public CntrMasterInquiryVO searchCntrMasterInquiryBasic(MstEtcVO mstEtcVO) throws EventException {
		try {
			if (!mstEtcVO.getGubun().equals("1")){
			    return dbDao.searchCntrMasterInquiryData(mstEtcVO);
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
	 * CntrLotVO에 값 Setting하기 위하여 사용합니다.<br>
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
	 * Own Container Creation (New Van) 대한 입력을 합니다.<br>
     * 
     * @param  CntrLotVO cntrLotVO
     * @param  SignOnUserAccount account
     * @return CntrLotVO
	 * @throws EventException
	 * 
	 */
    public CntrLotVO createOwnCntrBasic(CntrLotVO cntrLotVO, SignOnUserAccount account) throws EventException {
    	
    	String lot_no = "";
    	
		try {
			this.settingValue(cntrLotVO, account);
											
			// 범위 체크 
			cntrLotVO = dbDao.searchCntrLotSerialRangeData(cntrLotVO);
			lot_no = cntrLotVO.getLotNo();
						
			// 기존에 lot_no가 있을경우
			if(!"".equals(lot_no)){				
				throw new EventException(new ErrorHandler("MST01005", new String[]{"lot_no : "+lot_no}).getMessage());				
			}else{				
				// lot_no 추출
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
				
				dbDao.addCntrLotData(cntrLotVO);			
				dbDao.addOwnCntrMastersData(cntrLotVO);
				dbDao.addOwnCntrStatusHistorysData(cntrLotVO);				
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
	 * Own Container의 Lot No를 조회합니다.<br>
	 * 
     * @author J.H.Min
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
	 * Own Container Creation (New Van) 화면에 대한 수정이벤트 처리.<br>
	 * 
     * @author J.H.Min
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
			
			// 제작일자,행거랙,Plastic Floor 수정시에만		
			if(!(cntrLotVO.getOrgMftDt().equals(cntrLotVO.getMftDt())   &&			
			     cntrLotVO.getOrgCntrHngrRckCd().equals(cntrLotVO.getCntrHngrRckCd()) &&
			     cntrLotVO.getOrgPlstFlrFlg().equals(cntrLotVO.getPlstFlrFlg()) &&
			     cntrLotVO.getOrgMftVndrSeq().equals(cntrLotVO.getMftVndrSeq()) 
			   ))
			{
				dbDao.modifyOwnCntrMastersData(cntrLotVO);				
			}
			
			// 제작일자 수정시에만
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
	 * Lot No Inquiry 화면에 대한  조회이벤트 처리.<br>
	 * 
	 * @author J.H.Min
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
	 * Leased Container를 조회합니다.<br>
	 * @author LEE HO SUN
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
	 * Leased Container를 저장합니다.<br>
	 * @author LEE HO SUN
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
			if (leasedCntrVOs.length == 1 &&     //Serial Range 인 경우
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
						tmpLeasedCntrVOs.get(i).setCntrUpdflg   (leasedCntrVOs[0].getCntrUpdflg ());
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
						tmpLeasedCntrVOs.get(i).setErrMsg       (leasedCntrVOs[0].getErrMsg ());
					}
				}
			} else {   //Serial Range 가 아닌 일반적인 경우.
				for(int i = 0; i < leasedCntrVOs.length; i++){
					tmpLeasedCntrVOs.add(i, leasedCntrVOs[i]);
				}
			} 
			
			//Check digit, 중복확인
			tmpLeasedCntrVOs = dbDao.validationLeasedCntrData(tmpLeasedCntrVOs);
			//Serial Range 인것중 Dup인것이 
			if (tmpLeasedCntrVOs.get(0).getCtype().equals("2")){
				for (int i = 0; i < tmpLeasedCntrVOs.size(); i++){
					if (tmpLeasedCntrVOs.get(i).getCeflg().equals("D")){  
						tmpLeasedCntrVOs.get(0).setCeflg("B");
						retVoList.add(tmpLeasedCntrVOs.get(0));
						return retVoList;
					}
			    }
			}
						
			//중복 데이타 중에서 Status cd와 On Hire 확인 
			tmpLeasedCntrVOs = dbDao.validationLeasedUpdateCntrData(tmpLeasedCntrVOs);
			
			//Serial Range 인것을 Check하여 에러인경우 리턴
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
			
			//container update date와 on Hire Date 비교
			tmpLeasedCntrVOs = dbDao.validationLeasedUpdateCntrHisData(tmpLeasedCntrVOs);
			//Serial Range 인것을 Check하여 에러인경우 리턴
			if (tmpLeasedCntrVOs.get(0).getCtype().equals("2")){
				for (int i = 0; i < tmpLeasedCntrVOs.size(); i++){
					if (tmpLeasedCntrVOs.get(i).getCntrUpdflg().equals("E")){  
						tmpLeasedCntrVOs.get(0).setCntrUpdflg("E");
						 retVoList.add(tmpLeasedCntrVOs.get(0));
						 return retVoList;
					}
				}
			}	
			
			//General 또는 W.O 인경우 처리

			LeasedCntrVO lleasedCntrVO = new LeasedCntrVO();
			for (int i = 0; i < tmpLeasedCntrVOs.size(); i++){
				if (!tmpLeasedCntrVOs.get(i).getCeflg().equals("D") &&
					!tmpLeasedCntrVOs.get(i).getCeflg().equals("E")	&&
					!tmpLeasedCntrVOs.get(i).getEeflg().equals("E") &&
					!tmpLeasedCntrVOs.get(i).getHeflg().equals("E") &&
					!tmpLeasedCntrVOs.get(i).getCntrUpdflg().equals("E")){
					tmpLeasedCntrVOs.get(i).setCreUsrId(account.getUsr_id());
					tmpLeasedCntrVOs.get(i).setUpdUsrId(account.getUsr_id());

					//2016.02.24 CNTR NO LENGTH 11 GET	rollback => reTry(16.06.07)
					if(tmpLeasedCntrVOs.get(i).getCntrNo().length() > 11)
						tmpLeasedCntrVOs.get(i).setCntrNo(tmpLeasedCntrVOs.get(i).getCntrNo().substring(0, 11));
					lleasedCntrVO = tmpLeasedCntrVOs.get(i);
					String nextVal = dbDao.searchMaxCntrStatusHistorySeqData();
					tmpLeasedCntrVOs.get(i).setHisSeq(nextVal);

					//2010.08.04 중복 try 문 제거 Start						
					int result = dbDao.addLeasedCntrMasterData(tmpLeasedCntrVOs.get(i));
					if (result !=1) lleasedCntrVO.setIeflg("E");
					
					lleasedCntrVO.setOfcCd(account.getOfc_cd());
					
					int result2 = dbDao.addLeasedCntrStatusHistoryData(lleasedCntrVO); // 이력 저장
					if (result2 !=1) lleasedCntrVO.setIeflg("E");
					//2010.08.04 중복 try 문 제거 end
					retVoList.add(lleasedCntrVO);
				}	
				else if (tmpLeasedCntrVOs.get(i).getCeflg().equals("D") &&
						!tmpLeasedCntrVOs.get(i).getEeflg().equals("E") &&
						!tmpLeasedCntrVOs.get(i).getHeflg().equals("E") &&
						!tmpLeasedCntrVOs.get(i).getCntrUpdflg().equals("E")){
					tmpLeasedCntrVOs.get(i).setCreUsrId(account.getUsr_id());
					tmpLeasedCntrVOs.get(i).setUpdUsrId(account.getUsr_id());	
					lleasedCntrVO = tmpLeasedCntrVOs.get(i);
					String nextVal = dbDao.searchMaxCntrStatusHistorySeqData();
					tmpLeasedCntrVOs.get(i).setHisSeq(nextVal);
					//2010.08.04 중복 try 문 제거 Start	
					int result = dbDao.modifyLeasedCntrMasterData(tmpLeasedCntrVOs.get(i));
					if (result !=1) lleasedCntrVO.setUeflg("E");

					lleasedCntrVO.setOfcCd(account.getOfc_cd());

					int result2 = dbDao.addLeasedCntrStatusHistoryData(lleasedCntrVO); // 이력저장
					if (result2 !=1) lleasedCntrVO.setIeflg("E");
					//2010.08.04 중복 try 문 제거 end	
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
	 * Container Master Update를 저장합니다. <br>
	 * @author LEE HO SUN
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
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Master Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Master Update"}).getMessage(),de);
		}
    }
	
	/**
	 * LPAD 처리를 위한 private 함수
	 * @author LEE HO SUN
	 * @category EES_MST_0014
	 * @category lPad  
	 * size 만큼 src의 자리에 '0' 을 채운다.
	 * @param String src
	 * @param int size 
	 * @return String
	 */		
	private String lPad(String src, int size) {
		StringBuffer pattern = new StringBuffer();
		double dValue = 0d;
		try 
		{
			dValue = Double.valueOf(src).doubleValue();
		} catch (Exception e) {
			dValue = 0d;
			log.error(e.getMessage()); 
		}
		
		for (int inx = 0; inx < size; inx++)
			pattern = pattern.append("0");
		DecimalFormat df = new DecimalFormat(pattern.toString());
		return df.format(dValue);
	}
	
	/**
	 *  해당 컨테이너의 장비 상태(Movement,Status) 정보를 조회한다.<br>
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
	 *  해당 컨테이너의 장비 상태(Movement,Status) 정보를 저장한다.<br>
	 * 
	 * @author J.H.Min
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
	 * Container Status Creation을 조회합니다. <br>
	 * 
	 * @author LEE HO SUN
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
				cntrStatusCreationVOs[i].setStCd(cntrStatusCreationVOs[0].getStCd());
				cntrStatusCreationVOs[i].setHireDate(cntrStatusCreationVOs[0].getHireDate());
				cntrStatusCreationVOs[i].setStsEvntYdCd(cntrStatusCreationVOs[0].getStsEvntYdCd());
				cntrStatusCreationVOs[i].setAgmtCtyCd(cntrStatusCreationVOs[0].getAgmtCtyCd());
				cntrStatusCreationVOs[i].setAgmtSeq(cntrStatusCreationVOs[0].getAgmtSeq());
				cntrStatusCreationVOs[i].setRefNo(cntrStatusCreationVOs[0].getRefNo());
				cntrStatusCreationVOs[i].setVndrSeq(cntrStatusCreationVOs[0].getVndrSeq());
				selectVoList.add(cntrStatusCreationVOs[i]);				
			}			
			if (cntrStatusCreationVOs[0].getStCd().equals("0")){
				return dbDao.searchLeaseOutTargetListData(cntrStatusCreationVOs[0]);
			} else if (cntrStatusCreationVOs[0].getStCd().equals("4")){
				selectVoList = dbDao.searchMisUseOutTargetListData(selectVoList);
			} else if (cntrStatusCreationVOs[0].getStCd().equals("1") ||
					   cntrStatusCreationVOs[0].getStCd().equals("2") ||
					   cntrStatusCreationVOs[0].getStCd().equals("3") ||
					   cntrStatusCreationVOs[0].getStCd().equals("5") ||
					   cntrStatusCreationVOs[0].getStCd().equals("6") ||
					   cntrStatusCreationVOs[0].getStCd().equals("7")){
				selectVoList = dbDao.searchLeaseOutCntrStatusData(selectVoList);
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
     * Container Status Creation을 저장합니다. <br>
	 * @author LEE HO SUN
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
					!lCntrStatusCreationVO.getSeflg().equals("E") &&
					!lCntrStatusCreationVO.getTeflg().equals("E") &&
					!lCntrStatusCreationVO.getEeflg().equals("E")){
					//LSO일경우  LSE_AVAL_OFFH의 LSE_CO_RTN_YD_CD를  조회창의 sts_evnt_yd_cd 값으로 넣는다. 2010.04.14 Start
					if (cntrStatusCreationVOs[0].getStCd().equals("0")){
						lCntrStatusCreationVO.setStsEvntYdCd(lCntrStatusCreationVO.getLseCoRtnYdCd());
					}
					//End	
					//2010.08.04 중복 try 문 제거 Start
					String nextVal = dbDao.searchMaxCntrStatusHistorySeqData();
					lCntrStatusCreationVO.setHisSeq(nextVal);		
					
					int result = dbDao.addCntrStatusHistorysData(lCntrStatusCreationVO);
					//mst_cntr_sts_his 테이블의 update 정상인지 확인 error이면 E
					if (result != 1) lCntrStatusCreationVO.setUeflg("E");
					
					int result2 = dbDao.modifyCntrMasterByLastStatusData(lCntrStatusCreationVO);
					//mst_contanier 테이블의 update 정상인지 확인 error이면  E
					if (result2 != 1) lCntrStatusCreationVO.setIeflg("E");
					//2010.08.04 중복 try 문 제거 end
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
	 * Immediate Exit Creation 대상 장비목록을 일괄 갱신합니다.<br>
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
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.<br>
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
				
				// 저장 대상을 구분하기 위하여 화면상의 DelChk flg를 체크한다.
				if(termChangeCreationVOs[i].getDelChk().equals("-1")) {
					// OFC_CD 추가
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
					} else if (!termChangeCreationVoList.get(i).getCntrStsCd().equals("SBO")){
						termChangeCreationVoList2.add(locCnt2, termChangeCreationVoList.get(i));
						locCnt2++;
					} else {
						termChangeCreationVoList3.add(locCnt3, termChangeCreationVoList.get(i));
						locCnt3++;
					}	
				}
				//DI FLG가 Y인 경우
				if (locCnt1 > 0){
					dbDao.addTermChangeCntrStatusHistoryDiFlgYData(termChangeCreationVoList1);
				}
				//Di Flg가 N이고 Cntr Status Code가 SBO가 아닌경우
				if (locCnt2 > 0){
					dbDao.addTermChangeCntrStatusHistoryDiFlgNData(termChangeCreationVoList2);
				}
				//DI FLG='N' AND STSTUS CODE='SBO' 경우
				if (locCnt3 > 0){
					dbDao.addTermChangeCntrStatusHistoryDiFlgNSBOData(termChangeCreationVoList3);
				}
				
				dbDao.modifyCntrMasterByTermChangeData(termChangeCreationVoList);	

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
	 * Container Status Update를 조회합니다.
	 * @author LEE HO SUN
	 * @category EES_MST_0028
	 * @category searchCntrStatusUpdateTargetBasic 
	 * @param MstEtcVO mstEtcVO
	 * @return StatusUpdateGRPVO
	 * @exception EventException
	 */	
	public StatusUpdateGRPVO searchCntrStatusUpdateTargetBasic(MstEtcVO mstEtcVO) throws EventException {
		try {
			StatusUpdateGRPVO statusUpdateGRPVO = new StatusUpdateGRPVO(); 
			
			//Cntr 일반정보 조회
			CntrMstHeadVO cntrMstHeadVO = dbDao.searchCntrStatusUpdateMasterData(mstEtcVO);
			statusUpdateGRPVO.setCntrMstHeadVO(cntrMstHeadVO);
			
			//Container Movement 정보를 조회
			List<MovementVO> movementVOs = dbDao.searchCntrStatusUpdateMovementData(mstEtcVO);
			statusUpdateGRPVO.setMovementVOs(movementVOs);
			
			//Container StatusContainer Status 정보를 조회
			List<StatusHistoryVO> statusHistoryVOs = dbDao.searchCntrStatusUpdateHistoryData(mstEtcVO);
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
	 * Container Status Update를 저장합니다.
	 * @author LEE HO SUN
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
						
						 dbDao.removeMstCntrStsHisData(lstatusHistoryVO);  //DAO 메소드 변경에 다른 Return제거
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
			//나중에 tmpStatusHistoryVOs를 return한다.
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00028", new String[]{"Container Status Update"}).getMessage(),de);
		}
    }
    
	/** 
	 * EES_MST_0028 : save <br>
	 * Container Status Update를 저장합니다.
	 * @author LEE HO SUN
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
	 * CIM/CTM 에서 요청한 Master 정보를 수정합니다.<br>
	 * CTM 연계시 여러건 모두의 처리를 위해서 EXCEPTION 처리를 하지 않음. 
	 * @param CrossItemVO crossItemVO
	 * @return String
	 * @exception EventException
	 */
	public String updateCntrMasterByMvmtBasic (CrossItemVO crossItemVO) throws EventException {
		try {
			if (!("Y".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())) && crossItemVO.getUpdateMaster()){
				dbDao.modifyCntrMasterByMvmtData(crossItemVO.getCusCtmMovementVO());
			}

			if("X".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				// [SH 장비인 경우]
				dbDao.addCntrStatusHistoryByMvmtData(crossItemVO.getCusCtmMovementVO());				
			}
			
			if("Y".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				// [SH 장비인 경우이면서 MOVEMENT에서 XX를 삭제후 LSO데이타  삭제를 위해 호출]
				StatusHistoryVO statusHistoryVO = new StatusHistoryVO();
				String cntrNo = crossItemVO.getCusCtmMovementVO().getCntrNo();
				
				statusHistoryVO.setCntrNo(cntrNo);
				statusHistoryVO.setCntrStsCd("LSO");
				dbDao.removeMstCntrStsHisData(statusHistoryVO);     //DAO 메소드 변경
				dbDao.modifyCntrMasterByMvmtDeleteData(crossItemVO.getCusCtmMovementVO());
			}
			
			if ("Z".equals(crossItemVO.getCusCtmMovementVO().getNewFlg()) || 
				"K".equals(crossItemVO.getCusCtmMovementVO().getNewFlg())){
				// LSO,LSI 삭제시  내부호출, K일경우는 하나인 LSI 삭제시 호출
				dbDao.modifyCntrMasterByMvmtDeleteData(crossItemVO.getCusCtmMovementVO());
			}
			
			//CTM 에서 요청한 신조 인수/취소시 HISTORY 정보를 수정한다.
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
	 * On hire Approval  된 OW Term 컨테이너에 Approval Number 를 Update 시킨다.<br>
	 * 
	 * @param OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateAuthNoBasic(OnhireApprovalOwnListVO[] onhireApprovalOwnListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<OnhireApprovalOwnListVO> onhireApprovalOwnListVOList = new ArrayList<OnhireApprovalOwnListVO>();
			
			for(int i = 0; i < onhireApprovalOwnListVOs.length; i++ ) {
				// UPD_USR_ID 추가
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
	 * Miss Use Approval 된 컨테이너 Status를 추가시킨다.<br>
	 * 
	 * @param IFMnrFlagVO[] iFMnrFlagVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMNRStatusBasic(IFMnrFlagVO[] iFMnrFlagVOs, SignOnUserAccount account) throws EventException {
		try {
			List<IFMnrFlagVO> iFMnrFlagVOList 	= new ArrayList<IFMnrFlagVO>();	
			IFGateVO iFGateVO 					= new IFGateVO();
			CusCtmMovementVO cusCtmMovementVO 	= new CusCtmMovementVO();
			CntrMasterInquiryVO cntrInquiryVO	= new CntrMasterInquiryVO();	//Cntr_Inquiry Return
			MstEtcVO mstEtcVO 					= new MstEtcVO();				//Cntr_Inquiry 조회용
			StatusHistoryVO stsHisVO 			= new StatusHistoryVO();  	 	//Cntr_Sts_His 삭제용
			CrossItemVO crossItemVO             = null;
			 
			String cntrNo 	= "";
			String flagType ="";
			String stsFlag	= "";
			for(int i = 0; i < iFMnrFlagVOs.length; i++ ) {		
				cntrNo 		= iFMnrFlagVOs[i].getEqNo();
				flagType 	= iFMnrFlagVOs[i].getFlagType();
				stsFlag 	= iFMnrFlagVOs[i].getStsFlag();
				
				
				if( flagType.equals("DMG") ||
					flagType.equals("DSP") ||
					flagType.equals("HGR") ){					
					iFMnrFlagVOList.add(iFMnrFlagVOs[i]);
				}else{
					if (flagType.equals("SLD") && stsFlag.equals("N")){	//SLD Cancel		
						mstEtcVO.setCntrNo(cntrNo);
						mstEtcVO.setChkDgt("");
						cntrInquiryVO = dbDao.searchCntrMasterInquiryData(mstEtcVO); //2010.06.16 로직추가 NKJH
						
						stsHisVO.setCntrNo(cntrNo);
						stsHisVO.setCntrStsCd(flagType);//SLD Status 입력
						dbDao.removeMstCntrStsHisData(stsHisVO);	//CNTR STS HISTORY 삭제

						
						//CTM의 삭제LOGIC을 태위기 위한 셋팅  IbFlag, mvmt_sts_cd, cnmv_yr, cnmv_id_no
						cusCtmMovementVO.setIbflag("D");         
						cusCtmMovementVO.setCntrNo(iFMnrFlagVOs[i].getEqNo());
						cusCtmMovementVO.setMvmtStsCd(cntrInquiryVO.getCnmvStsCd());
						cusCtmMovementVO.setCnmvYr(cntrInquiryVO.getCnmvYr());
						cusCtmMovementVO.setCnmvIdNo(cntrInquiryVO.getCnmvIdNo());
					}
					 else // SLD Cancel 제외한 모든상황
					{
						dbDao.addCntrStatusHistorysByMNRStatusData(iFMnrFlagVOs[i]);					
							
						cusCtmMovementVO.setCntrNo(iFMnrFlagVOs[i].getEqNo());
						cusCtmMovementVO.setOrgYdCd(iFMnrFlagVOs[i].getFlagYdCd());
						cusCtmMovementVO.setCnmvEvntDt(iFMnrFlagVOs[i].getFlagDt ());
						cusCtmMovementVO.setCnmvRmk(iFMnrFlagVOs[i].getFlagType());
					
						if("Y".equals(stsFlag)){ // stsFlag : Y
							cusCtmMovementVO.setMvmtStsCd("XX");
						}else{		// stsFlag : N
							cusCtmMovementVO.setMvmtStsCd("MT");						
						}
							
						iFGateVO.setCntrNo(iFMnrFlagVOs[i].getEqNo());
						iFGateVO.setCnmvEvntDt(iFMnrFlagVOs[i].getFlagDt ());
						
						String evntDt = dbDao.searchMvmtTimeData ( iFGateVO ); //2010.06.16 로직추가 NKJH
						
						cusCtmMovementVO.setCnmvEvntDt(evntDt);
					}
					 cusCtmMovementVO.setCreUsrId(iFMnrFlagVOs[i].getFlagUserId());
					 cusCtmMovementVO.setUpdUsrId(iFMnrFlagVOs[i].getFlagUserId());	
					 cusCtmMovementVO.setPType1(iFMnrFlagVOs[i].getStsFlag());
					 cusCtmMovementVO.setPType2(iFMnrFlagVOs[i].getHbType());
					
					ContainerMovementMgtBC cmd = new ContainerMovementMgtBCImpl(); //CTM의 관련 메소드 호출
					crossItemVO = cmd.manageCntrInfoFromMst(cusCtmMovementVO, account); //ReturnVo의 제거
					if (crossItemVO.getSceActRcvIfVOs().size() > 0){
						CopDetailReceiveBC cmd1 = new CopDetailReceiveBCImpl();
						for (int k=0 ; k < crossItemVO.getSceActRcvIfVOs().size(); k++){
							if( crossItemVO.getSceActRcvIfVOs().get(k).getBkgNo() != ""  && crossItemVO.getSceActRcvIfVOs().get(k).getBkgNo() != null) {
								cmd1.createCOPMVMT(crossItemVO.getSceActRcvIfVOs().get(k));
							}
						}
					}
					cusCtmMovementVO.setNewFlg("N");          //modifyCntrMasterByMvmtDeleteData의 
					cusCtmMovementVO.setCnmvRmk("LSI");       //조건을 충족하기위해 셋팅
					dbDao.modifyCntrMasterByMvmtDeleteData(cusCtmMovementVO);
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
	 * CTM 에서 요청한 Master 정보를 수정한다.<br>
	 * 
	 * @param IFGateVO[] iFGateVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void createMvmtBasic(IFGateVO[] iFGateVOs, SignOnUserAccount account) throws EventException {		
		try {						
			CusCtmMovementVO cusCtmMovementVO = new CusCtmMovementVO();
			CrossItemVO item = null;
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
				cusCtmMovementVO.setIoFixFlag(iFGateVOs[i].getObCntrflg());
			
				
				ContainerMovementMgtBC cmd = new ContainerMovementMgtBCImpl();
				//cusCtmMovementVO = cmd.manageCntrInfoFromMst(cusCtmMovementVO, account);
				item = cmd.manageCntrInfoFromMst(cusCtmMovementVO, account);
				if (item.getSceActRcvIfVOs().size() > 0){
					CopDetailReceiveBC cmd1 = new CopDetailReceiveBCImpl();
					for (int k=0 ; k < item.getSceActRcvIfVOs().size(); k++){
						if(item.getSceActRcvIfVOs().get(k).getBkgNo()!= "" && item.getSceActRcvIfVOs().get(k).getBkgNo() != null ){
							cmd1.createCOPMVMT(item.getSceActRcvIfVOs().get(k));
						}
					}
				}
				
				if(iFGateVOs[i].getIbflag() == null){
					dbDao.modifyCntrMasterByOnOffHireData(item.getCusCtmMovementVO());
				}
			}			
		} catch(DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Creation/Update"}).getMessage(),de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Status Creation/Update"}).getMessage(),ex);
		}		
	}
	
	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
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
	 * Manufacture Date & Manufacturer Inquiry and Update를 조회합니다.
	 * @author LEE HO SUN
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
	 * Manufacture Date & Manufacturer Inquiry and Update를 수정합니다.
	 * @author LEE HO SUN
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
	 * Reefer Unit Info Inquiry and Update를 수정합니다.
	 * @author NamKoong JinHo
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
	 * Reefer Unit Info Inquiry and Update를 수정합니다.
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
	 * EES_MST_28 : re-creation <br>
	 * Sold status를 re-cration하기 위한 정보를 조회처리합니다.<br>
	 * @author Sang-bo La
	 * @category EES_MST_0028
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @return IFMnrFlagVO
	 * @exception EventException
	 */	
	public IFMnrFlagVO searchSoldStatusBasic(IFMnrFlagVO iFMnrFlagVO) throws EventException {
		try {
			return dbDao.searchStatusSoldData(iFMnrFlagVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Master Inquiry"}).getMessage(),ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"Container Master Inquiry"}).getMessage(),de);
		}  
	}
	
	/** 
	 * EES_MST_28 : save <br>
	 * CNTR STS 삭제 시 MST_CONTAINER의 정보도 삭제합니다.<br>
	 * @author Sang-bo La
	 * @category EES_MST_0028
	 * @param String CntrNo
	 * @exception EventException
	 */	
	public void removeMstContainerBasic(String CntrNo) throws EventException{
		try {			
			dbDao.removeMstContainerData(CntrNo);				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Master Update"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{" Container Master Update"}).getMessage(),de);
		}
    }
}
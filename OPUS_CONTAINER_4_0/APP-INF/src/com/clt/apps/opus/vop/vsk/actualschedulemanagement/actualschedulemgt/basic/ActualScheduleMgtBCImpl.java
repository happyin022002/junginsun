/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtBCImpl.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate :  
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActEDISetupInfoVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdChangeVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.EdiLogDataGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.clt.syscommon.common.table.VskActPortSkdHisVO;
import com.clt.syscommon.common.table.VskActPortSkdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * ActualScheduleManagement Business Logic Basic Command implementation<br>
 * - Handling Business Logic of ActualScheduleManagement<br>
 *
 * @author 
 * @see vop_vsk_0027EventResponse,ActualScheduleMgtBC, each DAO Class
 * @since J2EE 1.6
 */
public class ActualScheduleMgtBCImpl extends BasicCommandSupport implements ActualScheduleMgtBC {
  
	// Database Access Object
	private transient ActualScheduleMgtDBDAO dbDao = null;
	// :: VIPS START ::
	private List<VskActPortSkdVO> mVskActPortSkdList = new ArrayList<VskActPortSkdVO>();
	private List<VskVslPortSkdVO> mVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
	private List<VskVslSkdVO> mVskVslSkdList   = new ArrayList<VskVslSkdVO>();
	public List<VskActPortSkdVO> getVskActPortSkdList() {
		return this.mVskActPortSkdList;
	}
	public List<VskVslPortSkdVO> getVslPortSkdList() {
		return this.mVslPortSkdList;
	}
	public List<VskVslSkdVO> getVskVslSkdList() {
		return this.mVskVslSkdList;
	}
	/**
	 * Creating ActualScheduleMgtBCImpl Object<br>
	 * Creating ActualScheduleMgtDBDAO<br>
	 */
	public ActualScheduleMgtBCImpl() {
		dbDao = new ActualScheduleMgtDBDAO();
		// initialize
		this.mVskActPortSkdList = new ArrayList<VskActPortSkdVO>();
		this.mVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
	}
	// :: VIPS END ::
	/**
	 * Handling Retrieve Event about Actual schedule management<br>
	 * Retrieving Vessel Port Schedule, Actual Port Schedule Information <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception EventException
	 */
	public ActSkdMgtVO searchActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException{
		ActSkdMgtVO returnVO = null;
		
		try {
			ActSkdMgtVO chkTurnPortVO = dbDao.checkTurnPort(actSkdMgtVO);
			
			// in case data is not exist
			if(chkTurnPortVO == null){
				/*
				 * MSG - No Data Found - [$s]
				 */
				String[] errMsgs = new String[]{actSkdMgtVO.getVslCd()+"/"+actSkdMgtVO.getSkdVoyNo()+"/"+actSkdMgtVO.getSkdDirCd()+"/"+actSkdMgtVO.getVpsPortCd()+"/"+actSkdMgtVO.getClptIndSeq()};
				throw new EventException(new ErrorHandler("VSK10018", errMsgs).getMessage());
			}
			
			// in case TURN PORT
			if("T".equals(chkTurnPortVO.getFlag())){
				/*
				 * MSG - This Port is Virtual Port. Please input Turning Port Information!
				 */
				throw new EventException(new ErrorHandler("VSK10012").getMessage());
			}
			
			ActSkdMgtVO chkSkipVO = dbDao.checkSkipPort(actSkdMgtVO);
			
			// in case Skip Port
			if("X".equals(chkSkipVO.getFlag())){
				throw new EventException(new ErrorHandler("VSK10031").getMessage()); 
			}
				
			returnVO = dbDao.searchActPortSkd(actSkdMgtVO);
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return returnVO;
	}
	
	/**
	 * Creating and Updating created actual schedule information, and Interfacing necessary information to each module 
	 *
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException{
		
		VslSkdChgStsGRPVO 	vslSkdChgStsGRPVO 	= new VslSkdChgStsGRPVO();
		boolean				actSkdExistFlg		= false;
		
		try {
			ActPortSkdChangeVO actPortSkdChangeVO = null;
			boolean isHistoryFlg = false;
			
			if(actSkdMgtVO != null){
				
				//Saving LST_ETA_DT to VPS_ETA_DT at First.
				ActSkdMgtVO statusVO = dbDao.searchLastCstSkdStatus(actSkdMgtVO);
				
				// Retrieving Last Estimate Time, Turning Information.  
				if(statusVO != null){
					// To use Coastal Data
					if(VSKGeneralUtil.isNotNull(statusVO.getPortSkdStsCd	())) vslSkdChgStsGRPVO.setPortSkdStsCd(statusVO.getPortSkdStsCd());
					if(VSKGeneralUtil.isNotNull(statusVO.getPortSkdStsCd	())) actSkdMgtVO.setPortSkdStsCd(statusVO.getPortSkdStsCd());
					if(VSKGeneralUtil.isNotNull(statusVO.getLstEtaDt		())) actSkdMgtVO.setLstEtaDt(statusVO.getLstEtaDt());
					if(VSKGeneralUtil.isNotNull(statusVO.getLstEtbDt		())) actSkdMgtVO.setLstEtbDt(statusVO.getLstEtbDt());
					if(VSKGeneralUtil.isNotNull(statusVO.getLstEtdDt		())) actSkdMgtVO.setLstEtdDt(statusVO.getLstEtdDt());
					
					//Setting virtual info in case TURN PORT
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnPortFlg		())) actSkdMgtVO.setTurnPortFlg(statusVO.getTurnPortFlg());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnPortIndCd	())) actSkdMgtVO.setTurnPortIndCd(statusVO.getTurnPortIndCd());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnSkdVoyNo	())) actSkdMgtVO.setTurnSkdVoyNo(statusVO.getTurnSkdVoyNo());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnSkdDirCd	())) actSkdMgtVO.setTurnSkdDirCd(statusVO.getTurnSkdDirCd());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnClptIndSeq	())) actSkdMgtVO.setTurnClptIndSeq(statusVO.getTurnClptIndSeq());
					
					if(VSKGeneralUtil.isNull(actSkdMgtVO.getSlanCd())){
						vslSkdChgStsGRPVO.setSlanCd(statusVO.getSlanCd());
					}
				}
				
				actSkdMgtVO.setLstEtaDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getLstEtaDt()));
				actSkdMgtVO.setLstEtbDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getLstEtbDt()));
				actSkdMgtVO.setLstEtdDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getLstEtdDt()));
				
				actSkdMgtVO.setActArrDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActArrDt()));
				actSkdMgtVO.setActBrthDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActBrthDt()));
				actSkdMgtVO.setActDepDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActDepDt()));
				
				actSkdMgtVO.setOrgActArrDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getOrgActArrDt()));
				actSkdMgtVO.setOrgActBrthDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getOrgActBrthDt()));
				actSkdMgtVO.setOrgActDepDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getOrgActDepDt()));
				
				actSkdMgtVO.setPltLstUnldDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getPltLstUnldDt()));
				actSkdMgtVO.setBfrBrthAnkDrpDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getBfrBrthAnkDrpDt()));
				actSkdMgtVO.setBfrBrthAnkOffDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getBfrBrthAnkOffDt()));
				actSkdMgtVO.setAftUnbrthAnkDrpDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getAftUnbrthAnkDrpDt()));
				actSkdMgtVO.setAftUnbrthAnkOffDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getAftUnbrthAnkOffDt()));
				
				actSkdMgtVO.setArrFoilWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrFoilWgt           ()));                      
				actSkdMgtVO.setArrLowSulpFoilWgt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrLowSulpFoilWgt    ()));                       
				actSkdMgtVO.setArrDoilWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrDoilWgt           ()));                       
				actSkdMgtVO.setArrLowSulpDoilWgt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrLowSulpDoilWgt    ()));                       
				actSkdMgtVO.setArrFrshWtrWgt         (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrFrshWtrWgt        ()));                                              
				actSkdMgtVO.setArrBlstWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrBlstWgt           ()));                                              
				actSkdMgtVO.setArrFwddrHgt           (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrFwddrHgt          ()));                                              
				actSkdMgtVO.setArrAftdrHgt           (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrAftdrHgt          ()));                                              
				actSkdMgtVO.setArrGmHgt              (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrGmHgt             ()));                                              
				actSkdMgtVO.setArrTugBotKnt          (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrTugBotKnt         ()));                                              
				actSkdMgtVO.setSplFoilWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplFoilWgt           ()));                                              
				actSkdMgtVO.setSplLowSulpFoilWgt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplLowSulpFoilWgt    ()));                                              
				actSkdMgtVO.setSplDoilWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplDoilWgt           ()));                                              
				actSkdMgtVO.setSplLowSulpDoilWgt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplLowSulpDoilWgt    ()));                                              
				actSkdMgtVO.setSplFrshWtrWgt         (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplFrshWtrWgt        ()));                                              
				actSkdMgtVO.setDepLowSulpFoilWgt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepLowSulpFoilWgt    ()));                                              
				actSkdMgtVO.setDepFoilWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepFoilWgt           ()));                                              
				actSkdMgtVO.setDepLowSulpDoilWgt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepLowSulpDoilWgt    ()));                                              
				actSkdMgtVO.setDepDoilWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepDoilWgt           ()));                                              
				actSkdMgtVO.setDepFrshWtrWgt         (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepFrshWtrWgt        ()));                                              
				actSkdMgtVO.setDepBlstWgt            (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepBlstWgt           ()));                                              
				actSkdMgtVO.setDepFwddrHgt           (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepFwddrHgt          ()));                                              
				actSkdMgtVO.setDepAftdrHgt           (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepAftdrHgt          ()));                                              
				actSkdMgtVO.setDepGmHgt              (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepGmHgt             ()));                                              
				actSkdMgtVO.setDepTugBotKnt          (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepTugBotKnt         ()));                                              
				actSkdMgtVO.setTtlSlgWgt             (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getTtlSlgWgt            ()));                                              
				actSkdMgtVO.setTtlGbgQty             (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getTtlGbgQty            ()));        

				//2014.11.17 KJH 
				actSkdMgtVO.setDchgCmplDt			 (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDchgCmplDt            ()));
				
				// Checking validation Actual Schedule
				checkActSkdValid(actSkdMgtVO);
				
				// Checking Actual Data for separating Insert, Update
				ActSkdMgtVO chkActPortVO 	= dbDao.checkVskActPortSkd(actSkdMgtVO);
				actPortSkdChangeVO 			= dbDao.checkVskActPortSkdChange(actSkdMgtVO);
				
				/** Checking ACT PORT SKD ********************************************************/
				actSkdExistFlg				= dbDao.checkVskActPortSkdCountExist	(actSkdMgtVO);
				/*********************************************************************************/
				
				if(chkActPortVO != null){
					// History Check
					if(actPortSkdChangeVO != null){
						int chgVal = VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAllChk());
						if(chgVal > 0){
							isHistoryFlg = true;
						}
					}
					
					// Update
					dbDao.modifyVskActPortSkd	(actSkdMgtVO);
				}else{
					// Insert
					isHistoryFlg = true;
					dbDao.addVskActPortSkd		(actSkdMgtVO);
					
				}
				// :: VIPS START ::
//				System.out.println("VIPS[addVskActPortSkd1]");
				VskActPortSkdVO actPort = new VskActPortSkdVO();
				actPort.setVslCd(actSkdMgtVO.getVslCd());
				actPort.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
				actPort.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
				actPort.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
				actPort.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
				actPort = dbDao.searchVskActPortSkd(actPort);
				if(actPort != null) {
					this.mVskActPortSkdList.add(actPort);
				}
				
				VskVslPortSkdVO vo = new VskVslPortSkdVO();
				vo.setVslCd		(actSkdMgtVO.getVslCd());
				vo.setSkdVoyNo	(actSkdMgtVO.getSkdVoyNo());
				vo.setSkdDirCd	(actSkdMgtVO.getSkdDirCd());
//				vo.setTurnSkdVoyNo(actVo.getVpsPortCd());
//				vo.setTurnSkdDirCd(actVo.getClptIndSeq());
				VesselScheduleMgtDBDAO dbDaoTmp = new VesselScheduleMgtDBDAO();
				List<VskVslPortSkdVO> list = dbDaoTmp.searchVskVslPortSkdByVVD(vo);
				for(VskVslPortSkdVO port : list) {
					this.mVslPortSkdList.add(port);
				}
				
				
	    		VskVslSkdVO vskVslSkd = new VskVslSkdVO();
	    		vskVslSkd.setVslCd(actSkdMgtVO.getVslCd());
	    		vskVslSkd.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
	    		vskVslSkd.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
	    		List<VskVslSkdVO> vskVslSkdList = dbDaoTmp.searchVskVslSkdByVVD(vskVslSkd);
				for(VskVslSkdVO row : vskVslSkdList) {
					this.mVskVslSkdList.add(row);
				}
				
				if(!"".equals(actSkdMgtVO.getTurnSkdVoyNo())){
					VskActPortSkdVO actTurnPort = new VskActPortSkdVO();
					actTurnPort.setVslCd(actSkdMgtVO.getVslCd());
					actTurnPort.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
					actTurnPort.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
					actTurnPort.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
					actTurnPort.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
					actTurnPort = dbDao.searchVskActPortSkd(actTurnPort);
					if(actTurnPort != null) {
						this.mVskActPortSkdList.add(actTurnPort);
					}
					
					VskVslPortSkdVO turnVo = new VskVslPortSkdVO();
					turnVo.setVslCd		(actSkdMgtVO.getVslCd());
					turnVo.setSkdVoyNo	(actSkdMgtVO.getTurnSkdVoyNo());
					turnVo.setSkdDirCd	(actSkdMgtVO.getTurnSkdDirCd());
					VesselScheduleMgtDBDAO dbTurnDao = new VesselScheduleMgtDBDAO();
					List<VskVslPortSkdVO> turnList = dbTurnDao.searchVskVslPortSkdByVVD(turnVo);
					for(VskVslPortSkdVO port : turnList) {
						this.mVslPortSkdList.add(port);
					}
					
		    		VskVslSkdVO turnVskVslSkd = new VskVslSkdVO();
		    		turnVskVslSkd.setVslCd(actSkdMgtVO.getVslCd());
		    		turnVskVslSkd.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
		    		turnVskVslSkd.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
		    		List<VskVslSkdVO> vskVslSkdList2 = dbDaoTmp.searchVskVslSkdByVVD(turnVskVslSkd);
					for(VskVslSkdVO row : vskVslSkdList2) {
						this.mVskVslSkdList.add(row);
					}
				}
				
				// :: VIPS END ::
			}
			
			/*
			 * History
			 */
			if(isHistoryFlg){
				
				// ACT_ATA_INP_DT, ACT_ATB_INP_DT, ACT_ATD_INP_DT newest data
				VskActPortSkdVO vskActPortSkdVO 		= new VskActPortSkdVO		();
				vskActPortSkdVO.setVslCd				(actSkdMgtVO.getVslCd		());
				vskActPortSkdVO.setSkdVoyNo				(actSkdMgtVO.getSkdVoyNo	());
				vskActPortSkdVO.setSkdDirCd				(actSkdMgtVO.getSkdDirCd	());
				vskActPortSkdVO.setVpsPortCd			(actSkdMgtVO.getVpsPortCd	());
				vskActPortSkdVO.setClptIndSeq			(actSkdMgtVO.getClptIndSeq	());
				vskActPortSkdVO 						= dbDao.searchVskActPortSkd	(vskActPortSkdVO);
				
				VskActPortSkdHisVO vskActPortSkdHisVO 	= new VskActPortSkdHisVO	();
				vskActPortSkdHisVO.setVslCd				(actSkdMgtVO.getVslCd		());
				vskActPortSkdHisVO.setSkdVoyNo			(actSkdMgtVO.getSkdVoyNo	());
				vskActPortSkdHisVO.setSkdDirCd			(actSkdMgtVO.getSkdDirCd	());
				vskActPortSkdHisVO.setVpsPortCd			(actSkdMgtVO.getVpsPortCd	());
				vskActPortSkdHisVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq	());
				
				/** Set zero when not existing ACT SKD HIS **/
				if(!actSkdExistFlg){
					vskActPortSkdHisVO.setHisCreRsnCd	("I");		/** C : None ACT SKD, I : Initial, U : Normal Update, D : ACT SKD Delete **/
					
					vskActPortSkdHisVO.setLstEtaDt		(vskActPortSkdVO.getLstEtaDt());
					vskActPortSkdHisVO.setLstEtbDt		(vskActPortSkdVO.getLstEtbDt());
					vskActPortSkdHisVO.setLstEtdDt		(vskActPortSkdVO.getLstEtdDt());
					
				}else{
					vskActPortSkdHisVO.setHisCreRsnCd	("U");
				}
				
				vskActPortSkdHisVO.setActArrDt			(actSkdMgtVO.getActArrDt	());
				vskActPortSkdHisVO.setActBrthDt			(actSkdMgtVO.getActBrthDt	());
				vskActPortSkdHisVO.setActDepDt			(actSkdMgtVO.getActDepDt	());
				vskActPortSkdHisVO.setCreUsrId			(actSkdMgtVO.getCreUsrId	());
				vskActPortSkdHisVO.setUpdUsrId			(actSkdMgtVO.getUpdUsrId	());
				
				vskActPortSkdHisVO.setActAtaInpDt		(vskActPortSkdVO.getActAtaInpDt());
				vskActPortSkdHisVO.setActAtbInpDt		(vskActPortSkdVO.getActAtbInpDt());
				vskActPortSkdHisVO.setActAtdInpDt		(vskActPortSkdVO.getActAtdInpDt());
				vskActPortSkdHisVO.setActAtaInpUsrId	(vskActPortSkdVO.getActAtaInpUsrId());
				vskActPortSkdHisVO.setActAtbInpUsrId	(vskActPortSkdVO.getActAtbInpUsrId());
				vskActPortSkdHisVO.setActAtdInpUsrId	(vskActPortSkdVO.getActAtdInpUsrId());
				
				/*
				 * COP & Booking
				 * 
				 * IF( UPDATING ) THEN Act Rcv Dt
				 * 1. ATA change, "21"
				 * 2. ATB change,  "22"
				 * 3. ATD change,  "23"
				 * 4. ETA change,  "24"
				 * 5. ETB change,  "25"
				 * 6. ETD change,  "26"
				 * 7. YD change,    "27"
				 * 
				 * Transmitting Virtual Port info from Actual, not from Coastal in case Actual is Turnning
				 */
				// is case booking is exist
				if(actPortSkdChangeVO != null){
					List<SceActRcvIfVO> sceActRcvIfList = new ArrayList<SceActRcvIfVO>();
					List<CanonEmlVO> canonEmlList = new ArrayList<CanonEmlVO>();
					
					// Checking exist in Booking
					if("Y".equals(actPortSkdChangeVO.getBkgChk())){
						//ATA Changing
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtaChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
							sceActRcvIfVO.setActDatRcvDt(actPortSkdChangeVO.getAtaLocTime());
							sceActRcvIfVO.setActRcvTpCd("21");
							sceActRcvIfVO.setActDt(actSkdMgtVO.getActArrDt());
							sceActRcvIfVO.setNodCd(actSkdMgtVO.getYdCd());
							sceActRcvIfVO.setVslCd(actSkdMgtVO.getVslCd());
							sceActRcvIfVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
							sceActRcvIfVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
							sceActRcvIfVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
							sceActRcvIfVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
							sceActRcvIfVO.setVslDlayRsnCd(actSkdMgtVO.getVslArrDlayRsnCd());
							sceActRcvIfVO.setVslDlayRsnDesc(actSkdMgtVO.getVslArrDlayRsnNm());
		//					sceActRcvIfVO.setVpsLocCd(actSkdMgtVO.getVslDlayRsnLocCd());
							sceActRcvIfVO.setCreUsrId(actSkdMgtVO.getCreUsrId());
							sceActRcvIfList.add(sceActRcvIfVO);
						}
						//ATB Changing
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtbChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
							sceActRcvIfVO.setActDatRcvDt(actPortSkdChangeVO.getAtbLocTime());
							sceActRcvIfVO.setActRcvTpCd("22");
							sceActRcvIfVO.setActDt(actSkdMgtVO.getActBrthDt());
							sceActRcvIfVO.setNodCd(actSkdMgtVO.getYdCd());
							sceActRcvIfVO.setVslCd(actSkdMgtVO.getVslCd());
							sceActRcvIfVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
							sceActRcvIfVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
							sceActRcvIfVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
							sceActRcvIfVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
							sceActRcvIfVO.setVslDlayRsnCd(actSkdMgtVO.getVslBrthDlayRsnCd());
							sceActRcvIfVO.setVslDlayRsnDesc(actSkdMgtVO.getVslBrthDlayRsnNm());
							sceActRcvIfVO.setCreUsrId(actSkdMgtVO.getCreUsrId());
							sceActRcvIfList.add(sceActRcvIfVO);
						}
						//ATD Changing
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtdChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
							sceActRcvIfVO.setActDatRcvDt(actPortSkdChangeVO.getAtdLocTime());
							sceActRcvIfVO.setActRcvTpCd("23");
							sceActRcvIfVO.setActDt(actSkdMgtVO.getActDepDt());
							sceActRcvIfVO.setNodCd(actSkdMgtVO.getYdCd());
							sceActRcvIfVO.setVslCd(actSkdMgtVO.getVslCd());
							sceActRcvIfVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
							sceActRcvIfVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
							sceActRcvIfVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
							sceActRcvIfVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
							sceActRcvIfVO.setVslDlayRsnCd(actSkdMgtVO.getVslDepDlayRsnCd());
							sceActRcvIfVO.setVslDlayRsnDesc(actSkdMgtVO.getVslDepDlayRsnNm());
							sceActRcvIfVO.setCreUsrId(actSkdMgtVO.getCreUsrId());
							sceActRcvIfList.add(sceActRcvIfVO);
							
							//Booking Data
							CanonEmlVO canonEmlVO = new CanonEmlVO();
							canonEmlVO.setCoNm("CANON");
							canonEmlVO.setVslCd(actSkdMgtVO.getVslCd());
							canonEmlVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
							canonEmlVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
							canonEmlVO.setPolCd(actSkdMgtVO.getVpsPortCd());
							canonEmlVO.setAtdDt(actSkdMgtVO.getActDepDt());
							canonEmlList.add(canonEmlVO);
						}
					}
					
					// Checking exist in Booking(Virtual)
					if("Y".equals(actPortSkdChangeVO.getBkgVrtChk())){
						//ATA Changing
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtaChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
							sceActRcvIfVO.setActDatRcvDt(actPortSkdChangeVO.getAtaLocTime());
							sceActRcvIfVO.setActRcvTpCd("21");
							sceActRcvIfVO.setActDt(actSkdMgtVO.getActArrDt());
							sceActRcvIfVO.setNodCd(actSkdMgtVO.getYdCd());
							sceActRcvIfVO.setVslCd(actSkdMgtVO.getVslCd());
							sceActRcvIfVO.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
							sceActRcvIfVO.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
							sceActRcvIfVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
							sceActRcvIfVO.setClptIndSeq(actSkdMgtVO.getTurnClptIndSeq());
							sceActRcvIfVO.setVslDlayRsnCd(actSkdMgtVO.getVslArrDlayRsnCd());
							sceActRcvIfVO.setVslDlayRsnDesc(actSkdMgtVO.getVslArrDlayRsnNm());
							sceActRcvIfVO.setCreUsrId(actSkdMgtVO.getCreUsrId());
							sceActRcvIfList.add(sceActRcvIfVO);
						}
						//ATB Changing
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtbChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
							sceActRcvIfVO.setActDatRcvDt(actPortSkdChangeVO.getAtbLocTime());
							sceActRcvIfVO.setActRcvTpCd("22");
							sceActRcvIfVO.setActDt(actSkdMgtVO.getActBrthDt());
							sceActRcvIfVO.setNodCd(actSkdMgtVO.getYdCd());
							sceActRcvIfVO.setVslCd(actSkdMgtVO.getVslCd());
							sceActRcvIfVO.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
							sceActRcvIfVO.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
							sceActRcvIfVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
							sceActRcvIfVO.setClptIndSeq(actSkdMgtVO.getTurnClptIndSeq());
							sceActRcvIfVO.setVslDlayRsnCd(actSkdMgtVO.getVslBrthDlayRsnCd());
							sceActRcvIfVO.setVslDlayRsnDesc(actSkdMgtVO.getVslBrthDlayRsnNm());
							sceActRcvIfVO.setCreUsrId(actSkdMgtVO.getCreUsrId());
							sceActRcvIfList.add(sceActRcvIfVO);
						}
						//ATD Changing
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtdChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO = new SceActRcvIfVO();
							sceActRcvIfVO.setActDatRcvDt(actPortSkdChangeVO.getAtdLocTime());
							sceActRcvIfVO.setActRcvTpCd("23");
							sceActRcvIfVO.setActDt(actSkdMgtVO.getActDepDt());
							sceActRcvIfVO.setNodCd(actSkdMgtVO.getYdCd());
							sceActRcvIfVO.setVslCd(actSkdMgtVO.getVslCd());
							sceActRcvIfVO.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
							sceActRcvIfVO.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
							sceActRcvIfVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
							sceActRcvIfVO.setClptIndSeq(actSkdMgtVO.getTurnClptIndSeq());
							sceActRcvIfVO.setVslDlayRsnCd(actSkdMgtVO.getVslDepDlayRsnCd());
							sceActRcvIfVO.setVslDlayRsnDesc(actSkdMgtVO.getVslDepDlayRsnNm());
							sceActRcvIfVO.setCreUsrId(actSkdMgtVO.getCreUsrId());
							sceActRcvIfList.add(sceActRcvIfVO);
						}
					}
					
					vslSkdChgStsGRPVO.setSceActRcvIfVOs(sceActRcvIfList);	//COP Data
					vslSkdChgStsGRPVO.setCanonEmlVOs(canonEmlList);			//Booking Data
				}
				// COP END
				
				dbDao.addVskActPortSkdHis	(vskActPortSkdHisVO);
			}
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * Checking validation in case of saving Actual info
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @throws EventException
	 */
	private void checkActSkdValid(ActSkdMgtVO actSkdMgtVO) throws EventException{
		try {
			ActSkdMgtVO chkTurnPortVO = dbDao.checkTurnPort(actSkdMgtVO);
			ActSkdMgtVO chkStatusVO = dbDao.checkVslSkdStatus(actSkdMgtVO);
			
			// in case data is not exist
			if(chkTurnPortVO == null || chkStatusVO == null){
				/*
				 * MSG - No Data Found - [$s]
				 */
				String[] errMsgs = new String[]{actSkdMgtVO.getVslCd()+"/"+actSkdMgtVO.getSkdVoyNo()+"/"+actSkdMgtVO.getSkdDirCd()+"/"+actSkdMgtVO.getVpsPortCd()+"/"+actSkdMgtVO.getClptIndSeq()};
				throw new EventException(new ErrorHandler("VSK10018", errMsgs).getMessage());
			}
			
			// in case of TURN PORT
			if("T".equals(chkTurnPortVO.getFlag())){
				/*
				 * MSG - This Port is Virtual Port. Please input Turning Port Information!
				 */
				throw new EventException(new ErrorHandler("VSK10012").getMessage());
			}
			
			// in case of CLOSE
			if("CLO".equals(chkStatusVO.getFlag())){
				/*
				 * MSG - Vessel Schedule Already Closed!
				 */
				throw new EventException(new ErrorHandler("VSK10011").getMessage()); 
			}
			
			// in case of Skip Port
			ActSkdMgtVO chkSkipVO = dbDao.checkSkipPort(actSkdMgtVO);
			if("X".equals(chkSkipVO.getFlag())){
				throw new EventException(new ErrorHandler("VSK10031").getMessage()); 
			}
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Deleting registered Actual Port Schedule <br>
	 * 
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @exception EventException
	 */
	public void removeVskActPortSkd(VskActPortSkdVO vskActPortSkdVO, ActSkdMgtVO actSkdMgtVO) throws EventException{
		
		try {
			
			dbDao.updateVskVslPortSkdtoOriginalEstmDate			(vskActPortSkdVO);
			dbDao.updateVskVslVirtualPortSkdtoOriginalEstmDate	(vskActPortSkdVO);
			
			// :: VIPS START ::
//			System.out.println("VIPS[searchVskActPortSkd1]");
			VskActPortSkdVO actPort = dbDao.searchVskActPortSkd(vskActPortSkdVO);
			if(actPort != null) {
				this.mVskActPortSkdList.add(actPort);
			}
			VskVslPortSkdVO vo = new VskVslPortSkdVO();
			VskActPortSkdVO actVo = vskActPortSkdVO;
			vo.setVslCd(actVo.getVslCd());
			vo.setSkdVoyNo(actVo.getSkdVoyNo());
			vo.setSkdDirCd(actVo.getSkdDirCd());
//			vo.setVpsPortCd(actVo.getVpsPortCd());
//			vo.setClptIndSeq(actVo.getClptIndSeq());
			VesselScheduleMgtDBDAO dbDaoTmp = new VesselScheduleMgtDBDAO();
			List<VskVslPortSkdVO> list = dbDaoTmp.searchVskVslPortSkdByVVD(vo);
			for(VskVslPortSkdVO port : list) {
				this.mVslPortSkdList.add(port);
			}
			
			
    		VskVslSkdVO vskVslSkd = new VskVslSkdVO();
    		vskVslSkd.setVslCd(actVo.getVslCd());
    		vskVslSkd.setSkdVoyNo(actVo.getSkdVoyNo());
    		vskVslSkd.setSkdDirCd(actVo.getSkdDirCd());
    		List<VskVslSkdVO> vskVslSkdList = dbDaoTmp.searchVskVslSkdByVVD(vskVslSkd);
			for(VskVslSkdVO row : vskVslSkdList) {
				this.mVskVslSkdList.add(row);
			}
			
			if(!"".equals(actSkdMgtVO.getTurnSkdVoyNo())){
				VskActPortSkdVO actTurnPort = new VskActPortSkdVO();
				actTurnPort.setVslCd(actSkdMgtVO.getVslCd());
				actTurnPort.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
				actTurnPort.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
				actTurnPort.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
				actTurnPort.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
				actTurnPort = dbDao.searchVskActPortSkd(actTurnPort);
				if(actTurnPort != null) {
					this.mVskActPortSkdList.add(actTurnPort);
				}
				
				VskVslPortSkdVO turnVo = new VskVslPortSkdVO();
				turnVo.setVslCd		(actSkdMgtVO.getVslCd());
				turnVo.setSkdVoyNo	(actSkdMgtVO.getTurnSkdVoyNo());
				turnVo.setSkdDirCd	(actSkdMgtVO.getTurnSkdDirCd());
				VesselScheduleMgtDBDAO dbTurnDao = new VesselScheduleMgtDBDAO();
				List<VskVslPortSkdVO> turnList = dbTurnDao.searchVskVslPortSkdByVVD(turnVo);
				for(VskVslPortSkdVO port : turnList) {
					this.mVslPortSkdList.add(port);
				}
				
	    		VskVslSkdVO turnVskVslSkd = new VskVslSkdVO();
	    		turnVskVslSkd.setVslCd(actSkdMgtVO.getVslCd());
	    		turnVskVslSkd.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
	    		turnVskVslSkd.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
	    		List<VskVslSkdVO> vskVslSkdList2 = dbTurnDao.searchVskVslSkdByVVD(turnVskVslSkd);
				for(VskVslSkdVO row : vskVslSkdList2) {
					this.mVskVslSkdList.add(row);
				}
			}
			
			// :: VIPS END ::

			dbDao.removeVskActPortSkd							(vskActPortSkdVO);
			
			VskActPortSkdHisVO vskActPortSkdHisVO 				= new VskActPortSkdHisVO();
			
			vskActPortSkdHisVO.setVslCd							(vskActPortSkdVO.getVslCd());
			vskActPortSkdHisVO.setSkdVoyNo						(vskActPortSkdVO.getSkdVoyNo());
			vskActPortSkdHisVO.setSkdDirCd						(vskActPortSkdVO.getSkdDirCd());
			vskActPortSkdHisVO.setVpsPortCd						(vskActPortSkdVO.getVpsPortCd());
			vskActPortSkdHisVO.setClptIndSeq					(vskActPortSkdVO.getClptIndSeq());
			vskActPortSkdHisVO.setCreUsrId						(vskActPortSkdVO.getUpdUsrId());
			vskActPortSkdHisVO.setUpdUsrId						(vskActPortSkdVO.getUpdUsrId());
			
			vskActPortSkdHisVO.setHisCreRsnCd					("D");		/** I : Initial, U : Normal Update, D : ACT SKD Delete **/
			
			dbDao.addVskActPortSkdHis							(vskActPortSkdHisVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Target Lane List <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchActualTargetLaneList(ActSkdRtoVO actSkdRtoVO) throws EventException{
		try {
			return dbDao.searchActualTargetLaneList(actSkdRtoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving Actual Report input state of Ports <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdSumVO>
	 * @exception EventException
	 */
	public List<ActSkdSumVO> searchActPortSkdInputSum(ActSkdRtoVO actSkdRtoVO) throws EventException {
		try {
			return dbDao.searchActPortSkdInputSum(actSkdRtoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * Retrieving Detail Actual Report input state of Ports<br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdInputDtl(ActSkdRtoVO actSkdRtoVO) throws EventException {
		try {
			return dbDao.searchActPortSkdInputDtl(actSkdRtoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * Retrieving Uncompleted Actual Schedule Report <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdUnCmplDtl(ActSkdRtoVO actSkdRtoVO) throws EventException {
		try {
			return dbDao.searchActPortSkdUnCmplDtl(actSkdRtoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * Retrieving Actual SKD Information through EDI.<br>
	 * 
	 * @param ActSkdEdiMntrVO actSkdEdiMntrVO
	 * @return List<ActSkdEdiMntrVO>
	 * @exception EventException
	 */
	public List<ActSkdEdiMntrVO> searchActPortSkdEdiMntr(ActSkdEdiMntrVO actSkdEdiMntrVO) throws EventException {
		try {
//			String tmlCd = actSkdEdiMntrVO.getTmlCd();
//			if(VSKGeneralUtil.isNotNull(tmlCd)){
//				actSkdEdiMntrVO.setYdCd(actSkdEdiMntrVO.getVpsPortCd()+tmlCd);
//			}
			actSkdEdiMntrVO.setYdCd(actSkdEdiMntrVO.getTmlCd());
			return dbDao.searchActPortSkdEdiMntr(actSkdEdiMntrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Handling MQ List. Split MQ Message up \n and drop new line
	 * 
	 * @param String sFlatFile
	 * @return ArrayList<String>
	 * @throws EventException
	 */
	private ArrayList<String> flatFileConvertList(String sFlatFile) throws EventException {
		ArrayList<String> rtnArr = new ArrayList<String>();
		try{
			StringTokenizer token = new StringTokenizer(sFlatFile, "\n");
			while (token.hasMoreTokens()) {
				rtnArr.add(token.nextToken());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return rtnArr;
	}
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param String ediFlatFile
	 * @return VskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	public List<VskActPortSkdEdiLogVO> createVskActPortSkdEdiLog(String ediFlatFile) throws EventException{
		List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs = new ArrayList<VskActPortSkdEdiLogVO>();
		
		try {
			//Split MQ Message up \n and drop new line
			ArrayList<String> flatFileList = flatFileConvertList(ediFlatFile);

			StringBuffer startIdxSb = new StringBuffer();
			StringBuffer endIdxSb = new StringBuffer();
			
			//Setting {MAIN -> start, }MAIN -> end
			//Setting each {Main -> startSb because Multi data
			//Setting each }Main -> endSb because Multi data
			for(int i=1; i<flatFileList.size(); i++){
				if(flatFileList.get(i).indexOf("{MAIN") > -1){	
					startIdxSb.append(Integer.toString(i) + ":");
				}else if(flatFileList.get(i).indexOf("}MAIN") > -1){	
					endIdxSb.append(Integer.toString(i) + ":");
				}
			}
			
			String[] startData = startIdxSb.toString().split(":");
			String[] endData = endIdxSb.toString().split(":");
			int[] delStartData = new int[startData.length];
			int[] delEndData = new int[endData.length];
			
			for(int i=0; i<startData.length; i++){
				if(VSKGeneralUtil.isNotNull(startData[i])){
					delStartData[i] = Integer.parseInt(startData[i]);
				}
			}
			for(int i=0; i<endData.length; i++){
				if(VSKGeneralUtil.isNotNull(endData[i])){
					delEndData[i] = Integer.parseInt(endData[i]);
				}
			}
			
			for(int i=0; i<startData.length; i++ ){
				VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO = new VskActPortSkdEdiLogVO();
				
				for(int k=(delStartData[i]+ 2); k<(delEndData[i]); k++){
					String[] jumMomIdArr = flatFileList.get(k).toString().trim().split(":",2);
					String jumMomId = jumMomIdArr[0];
					
					if("VSL_CD".equals(jumMomId)){
						String[] vslCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiVslNm(VSKGeneralUtil.getCheckNullToString(vslCdArr[1]));//VSL_CD
					}else if("VOY_NO".equals(jumMomId)){
						String[] skdVoyNoArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiSkdVoyNo(VSKGeneralUtil.getCheckNullToString(skdVoyNoArr[1]));//SKD_VOY_NO
					}else if("DIR_CD".equals(jumMomId)){
						String[] skdDirCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiSkdDirNm(VSKGeneralUtil.getCheckNullToString(skdDirCdArr[1]));//SKD_DIR_CD
					}else if("CALL_SIGN".equals(jumMomId)){
						String[] callSgnNoArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setCallSgnNo(VSKGeneralUtil.getCheckNullToString(callSgnNoArr[1]));//CALL_SGN_NO
					}else if("IMO_CD".equals(jumMomId)){
						String[] lloydNoArr = flatFileList.get(k).toString().trim().split(":", 2);
						vskActPortSkdEdiLogVO.setLloydNo(VSKGeneralUtil.getCheckNullToString(lloydNoArr[1]));//LLOYD_NO
					}else if("REF_CD".equals(jumMomId)){
						String[] shpCallNoArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setShpCallNo(VSKGeneralUtil.getCheckNullToString(shpCallNoArr[1]));//SHP_CALL_NO
					}else if("LOC_CD".equals(jumMomId)){
						String[] vpsPortCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setVpsPortCd(VSKGeneralUtil.getCheckNullToString(vpsPortCdArr[1]));//VPS_PORT_CD
					}else if("YD_CD".equals(jumMomId)){
						String[] ydCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setYdCd(VSKGeneralUtil.getCheckNullToString(ydCdArr[1]));//YD_CD
					}else if("ATA".equals(jumMomId)){
						String[] actArrDtArr = flatFileList.get(k).toString().trim().split(":",2);
						
						//::2016-07-07:by TOP:IFTSAI-temporary save ATB from ATA of EDI:://
						//**vskActPortSkdEdiLogVO.setEdiActArrDt(VSKGeneralUtil.getCheckNullToString(actArrDtArr[1]));//ACT_ARR_DT
						vskActPortSkdEdiLogVO.setEdiActBrthDt(VSKGeneralUtil.getCheckNullToString(actArrDtArr[1]));//ACT_ARR_DT
						///////////////////////////////////////////////////////////////////
						
					}else if("ATB".equals(jumMomId)){
						
						String[] actBrthDtArr = flatFileList.get(k).toString().trim().split(":",2);
						
						//::2016-07-07:by TOP:IFTSAI-temporary save ATB from ATA of EDI:://
						//**vskActPortSkdEdiLogVO.setEdiActBrthDt(VSKGeneralUtil.getCheckNullToString(actBrthDtArr[1]));//ACT_BRTH_DT
						
						String sTmpActBrthDt	= VSKGeneralUtil.getCheckNullToString(actBrthDtArr[1]);
						if(sTmpActBrthDt != null && !"".equals(sTmpActBrthDt)){
							vskActPortSkdEdiLogVO.setEdiActBrthDt(VSKGeneralUtil.getCheckNullToString(actBrthDtArr[1]));//ACT_BRTH_DT
						}
						///////////////////////////////////////////////////////////////////
						
					}else if("ATD".equals(jumMomId)){
						String[] actDepDtArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiActDepDt(VSKGeneralUtil.getCheckNullToString(actDepDtArr[1]));//ACT_DEP_DT
					//::FOR NYK BY TOP::2014-11-29:://
					}else if("DISC_DT".equals(jumMomId)){
						
						String[] sDchgCmplDt = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setDchgCmplDt(VSKGeneralUtil.getCheckNullToString(sDchgCmplDt[1]));//DISCHARGING COMPLETE DATE
					}
					
					vskActPortSkdEdiLogVO.setScsFlg("N");
				}
				
				vskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
			}
			
			String header = flatFileList.get(0).toString();  
			String sndrTrdPrnrId = header.substring(12, 31).trim();		// SNDR_TRD_PRNR_ID
			String rcvrTrdPrnrId = header.substring(32, 51).trim();		// RCVR_TRD_PRNR_ID
			String ediMsgTpId = header.substring(52, 61).trim();		// EDI_MSG_TP_ID
			String ediMsgProcId = header.substring(62).trim();			// EDI_MSG_PROC_ID
//			String junMomHeader = ediFlatFile.substring(62, 77).trim();
			
			// Creating EDI LOG KEY, and Saving Header Information
			if(vskActPortSkdEdiLogVOs != null){
				// Setting interface id because user id is null in case of MQ Message
				String ediId = "IF_EDI_SVC";
				
				for(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO : vskActPortSkdEdiLogVOs){				
					VskActPortSkdEdiLogVO rtnVO = dbDao.searchVskActPortSkdEdiLogKeyValue();
					vskActPortSkdEdiLogVO.setRcvDt			(rtnVO.getRcvDt	()	);
					vskActPortSkdEdiLogVO.setRcvSeq			(rtnVO.getRcvSeq()	);
					vskActPortSkdEdiLogVO.setSndrTrdPrnrId	(sndrTrdPrnrId		);
					vskActPortSkdEdiLogVO.setRcvrTrdPrnrId	(rcvrTrdPrnrId		);
					vskActPortSkdEdiLogVO.setEdiMsgTpId		(ediMsgTpId			);
					vskActPortSkdEdiLogVO.setEdiMsgProcId	(ediMsgProcId		);
					vskActPortSkdEdiLogVO.setCreUsrId		(ediId				);
					vskActPortSkdEdiLogVO.setUpdUsrId		(ediId				);
					
					vskActPortSkdEdiLogVO.setDchgCmplDt		(vskActPortSkdEdiLogVO.getDchgCmplDt());
					
					//String errMsg = "[Error] An unknown error has occurred while processing. Please contact system administrator.";
					//vskActPortSkdEdiLogVO.setRsltMsg		(errMsg);	// Handling error message
					
    				// Saving Actual Schedule Departure information through Terminal EDI input
					dbDao.addVskActPortSkdEdiLog			(vskActPortSkdEdiLogVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return vskActPortSkdEdiLogVOs;
	}
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs
	 * @param SignOnUserAccount account
	 * @return EdiLogDataGRPVO
	 * @exception EventException
	 */
	public EdiLogDataGRPVO auditReceivedEdiData(List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs, SignOnUserAccount account) throws EventException{
		
		//after checking auditReceivedEdiData method,
		//modifyVskActPortSkdEdiLog
		EdiLogDataGRPVO ediLogDataGRPVO = new EdiLogDataGRPVO();
		int successCnt = 0;		// success count
		int failCnt    = 0;		// fail count
		StringBuffer errMsg = new StringBuffer();
		if (log.isDebugEnabled()) {
			log.info("################### auditReceivedEdiData() START>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		
		try {
			String usrId = "IF_EDI_SVC";
			
			if (vskActPortSkdEdiLogVOs != null && vskActPortSkdEdiLogVOs.size() > 0) {
				List<VskActPortSkdEdiLogVO> rtnVskActPortSkdEdiLogVOs = new ArrayList<VskActPortSkdEdiLogVO>();
				List<VskVslPortSkdVO>                vskVslPortSkdVOs = new ArrayList<VskVslPortSkdVO>();
				List<VskActPortSkdVO>                vskActPortSkdVOs = new ArrayList<VskActPortSkdVO>();
				
				for (VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO : vskActPortSkdEdiLogVOs) {
					
//					#########################################################################
//					# Retrieving EDI Set-up Info.
//					#########################################################################
					ActEDISetupInfoVO paramVO = new ActEDISetupInfoVO();
					paramVO.setPrnrSubLnkCd(vskActPortSkdEdiLogVO.getYdCd());
					paramVO.setSndrTrdPrnrId(vskActPortSkdEdiLogVO.getSndrTrdPrnrId());
					
					
					////::2015-01-11:TOP:://ActEDISetupInfoVO actEDISetupInfoVO = dbDao.searchActEDISetUpInfo(paramVO);
					
					////::2015-01-11:TOP:://if(actEDISetupInfoVO == null || "X".equals(actEDISetupInfoVO.getVslCdFlg())){
					////::2015-01-11:TOP:://	failCnt++;
					////::2015-01-11:TOP:://	//[Error] No exists Set-Up Information.
					////::2015-01-11:TOP:://	vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10065").getUserMessage());
					////::2015-01-11:TOP:://	dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
					////::2015-01-11:TOP:://	continue;
					////::2015-01-11:TOP:://}
					
//					#########################################################################
//					# Finding vsl_cd, skd_voy_no, skd_dir_cd.
//					# Order to find VVD,
//					#     1. Vessel Code.
//					#     2. Call Sign No.
//					#     3. IMO(Llody No) No.					
//					#########################################################################
					
					//List<VskActPortSkdEdiLogVO>  rtnVvdVOs = null;	
					List<VskActPortSkdEdiLogVO> rtnPortVOs = null;
					String	ediVslCd   = vskActPortSkdEdiLogVO.getEdiVslNm();
					String	callSingNo = vskActPortSkdEdiLogVO.getCallSgnNo();
					String	llodyNo    = vskActPortSkdEdiLogVO.getLloydNo();
					String shpCallNo = vskActPortSkdEdiLogVO.getShpCallNo();
					//String dchgCmplDt = vskActPortSkdEdiLogVO.getDchgCmplDt();
					//String	errNo      = "";
					String[] errMsgs   = new String[]{""};
					
					if (log.isDebugEnabled()) {
						log.info("\n\n" +
						   "===================================================================================================================\n"+
						   ////::2015-01-11:TOP:://"["+ actEDISetupInfoVO.getVslCdFlg() +"] ["+ actEDISetupInfoVO.getMnvrInHrsFlg()+"] ["+ actEDISetupInfoVO.getActDateFlg() +"]\n"+
						   "vsl Cd : ["+ ediVslCd +"] call Sign : ["+ callSingNo +"] lloyd : ["+ llodyNo +"] \n"+
						   "CSSM Voy No. (REF_CD) : ["+ vskActPortSkdEdiLogVO.getShpCallNo() +"]\n"+
						   "Voy No. : ["+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"]\n"+
						   "Dir Cd. : ["+ vskActPortSkdEdiLogVO.getEdiSkdDirNm() +"]\n"+
						   "Port Cd : ["+ vskActPortSkdEdiLogVO.getVpsPortCd() +"]\n"+
						   "==================================================================================================================\n");
					}  
					/*
					 * in case ediVslCd, callSignNo, llodyNo are all null, Vessel Code cannot find
					 * VSK10027 : Vessel Code doesn't exist.
					 */
					if(VSKGeneralUtil.isNull(ediVslCd) && VSKGeneralUtil.isNull(callSingNo) && VSKGeneralUtil.isNull(llodyNo)){
						failCnt++;
//						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10027").getUserMessage());
						vskActPortSkdEdiLogVO.setRsltMsg("CallSignNo, IMO No, Vessel Code don't exist in EDI file.");
						//vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10027").getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					if(VSKGeneralUtil.isNull(shpCallNo)){
						failCnt++;
						vskActPortSkdEdiLogVO.setRsltMsg("Consortium Voyage Number doesn't exist in EDI file.");
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
//					###################################################################################
//					# setup information (vslCdFlg = "01"), Finding VVD in case Voyage Number
//					###################################################################################					
						
					//[Error] No exists a VVD as a PAS code.($s)
//					errNo = "VSK10070";
//					////::2015-01-12:TOP::////
					rtnPortVOs = dbDao.searchVvdByReceviedPsaVoyNoAll(vskActPortSkdEdiLogVO);
							
					/*	
					if (rtnPortVOs.size() != 0) {
						// Showing message in case cannot retrieve by yard code, but can retrieve by port code
						errMsgs[0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
					}*/
					
					
					////::2015-01-12:TOP::////
					if (rtnPortVOs == null || rtnPortVOs.size() != 1) {
						String tmpGrpVvdCnt = "";
						String tmpTotCnt = "";
						
						if(rtnPortVOs != null && rtnPortVOs.size() > 1){
							//n건 이상일때.
							tmpGrpVvdCnt 	= rtnPortVOs.get(0).getGrpVvdCnt(); //VVD & YD 가 같은  Count
							tmpTotCnt 		= rtnPortVOs.get(0).getTotCnt(); 	//전체 조회된 Count
														
							if(tmpGrpVvdCnt.equals(tmpTotCnt)){
								//1 건의 VVD일때.
								vskActPortSkdEdiLogVO.setVslCd		(rtnPortVOs.get(0).getVslCd		());
								vskActPortSkdEdiLogVO.setSkdVoyNo	(rtnPortVOs.get(0).getSkdVoyNo	());
								vskActPortSkdEdiLogVO.setSkdDirCd	(rtnPortVOs.get(0).getSkdDirCd	());
							}else{
								// in case more than 2 VVD are retrieving,
								//errMsgs[0] += " Duplicated VVD : " + getDuplicateVvdMsg(rtnPortVOs);
								vskActPortSkdEdiLogVO.setRsltMsg("There are VVDs more than one having same information : " + getDuplicateVvdMsg(rtnPortVOs));
								dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
								continue;
							}	
							
						}else{
							
							//rtnPortVOs null  일때.
							failCnt++;
							
							//errMsgs[0] += " There is not exist VVD. ";
							//vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler(errNo, errMsgs).getUserMessage());
							vskActPortSkdEdiLogVO.setRsltMsg("Cannot find VVD, Please check information in EDI file.");
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
						}
						
					}else{
						
						//1 건의 VVD일때.
						vskActPortSkdEdiLogVO.setVslCd		(rtnPortVOs.get(0).getVslCd		());
						vskActPortSkdEdiLogVO.setSkdVoyNo	(rtnPortVOs.get(0).getSkdVoyNo	());
						vskActPortSkdEdiLogVO.setSkdDirCd	(rtnPortVOs.get(0).getSkdDirCd	());
					}
					
//					#########################################################################
//					# Setting ATA, ATB, ATD using mnvr in hrs
//					#########################################################################
					
					String ediActArrDt 	= vskActPortSkdEdiLogVO.getEdiActArrDt	();
					String ediActBrthDt = vskActPortSkdEdiLogVO.getEdiActBrthDt	();
					String ediActDepDt 	= vskActPortSkdEdiLogVO.getEdiActDepDt	();
					
					if(VSKGeneralUtil.isNull(ediActArrDt) && VSKGeneralUtil.isNull(ediActBrthDt) && VSKGeneralUtil.isNotNull(ediActDepDt)){
						// Assume that ATA, ATB are already input
						vskActPortSkdEdiLogVO.setActDepDt(ediActDepDt);
						
					}else{
						
						////::2015-01-11:TOP:://String actDateFlg 	= actEDISetupInfoVO.getActDateFlg	();
						////::2015-01-11:TOP:://String mnvrInHrsFlg = actEDISetupInfoVO.getMnvrInHrsFlg	();	
						
						//::2016-07-07:by TOP:IFTSAI-temporary save ATB from ATA of EDI:://
						//**if (VSKGeneralUtil.isNotNull(ediActArrDt) && VSKGeneralUtil.isNull(ediActBrthDt)) {
						//**	vskActPortSkdEdiLogVO.setActArrDt(vskActPortSkdEdiLogVO.getEdiActArrDt());
							
						if (VSKGeneralUtil.isNull(ediActArrDt) && VSKGeneralUtil.isNotNull(ediActBrthDt)) {
							vskActPortSkdEdiLogVO.setActBrthDt(vskActPortSkdEdiLogVO.getEdiActBrthDt());
						///////////////////////////////////////////////////////////////////
						
							//::2016-07-07:by TOP:IFTSAI-temporary save ATB from ATA of EDI:://
							//**vskActPortSkdEdiLogVO.setActArrDt(vskActPortSkdEdiLogVO.getEdiActArrDt());
							//**String actBrthDt = dbDao.searchActBrthDtByMnvrInHrs(vskActPortSkdEdiLogVO);
							//**if(VSKGeneralUtil.isNull(actBrthDt)){
							//**	failCnt++;
								// [Error] No exists Maneunvering In Hour.
							//**	vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
							//**	dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							//**	continue;
							//**}
							//**vskActPortSkdEdiLogVO.setActBrthDt(actBrthDt);
							
							vskActPortSkdEdiLogVO.setActBrthDt(vskActPortSkdEdiLogVO.getEdiActBrthDt());
							String actArrDate = dbDao.searchActArrDateByMnvrInHrs(vskActPortSkdEdiLogVO);
							
							
							if(VSKGeneralUtil.isNull(actArrDate)){
								failCnt++;
								// [Error] No exists Maneunvering In Hour.
								vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
								dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
								continue;
							}
							vskActPortSkdEdiLogVO.setActArrDt(actArrDate);
							///////////////////////////////////////////////////////////////////
								
								
						} else if (VSKGeneralUtil.isNotNull(ediActArrDt) && VSKGeneralUtil.isNotNull(ediActBrthDt)) {
							
							vskActPortSkdEdiLogVO.setActArrDt(ediActArrDt);							
							vskActPortSkdEdiLogVO.setActBrthDt(ediActBrthDt);
							
						} else {
							
							failCnt++;
							// [Error] No exists ATA, ATB.
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
						}
						vskActPortSkdEdiLogVO.setActDepDt(ediActDepDt);
					}
					
//					#########################################################################
//					# Setting clpt_ind_seq ,turning info, virtual info
//					#########################################################################				
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslCd(vskActPortSkdEdiLogVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo(vskActPortSkdEdiLogVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd(vskActPortSkdEdiLogVO.getSkdDirCd());
					
					vskVslSkdVO = dbDao.searchVskVslSkd(vskVslSkdVO);
					vskActPortSkdEdiLogVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
					
					String clptIndSeq = dbDao.searchCallingIndicator(vskActPortSkdEdiLogVO);
					vskActPortSkdEdiLogVO.setClptIndSeq(clptIndSeq);
					VskVslPortSkdVO vskVslPortSkdVO = dbDao.searchOriginalVoyDir(vskActPortSkdEdiLogVO);
					
					if(vskVslPortSkdVO == null){
						failCnt++;
						String vslCd = vskActPortSkdEdiLogVO.getVslCd();
						String skdVoyNo = vskActPortSkdEdiLogVO.getSkdVoyNo();
						String skdDirCd = vskActPortSkdEdiLogVO.getSkdDirCd();
						String vpsPortCd = vskActPortSkdEdiLogVO.getVpsPortCd();
						errMsgs = new String[]{vslCd +"/"+ skdVoyNo + "/" + skdDirCd + "/" + vpsPortCd + "/" + clptIndSeq};
						//[Error] No exists a vesssl port schedule.($s)
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10060", errMsgs).getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
						
					}else{
						
						if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVO.getTurnPortIndCd())){
							// Setting turning in case of Virtual
							String tmpSkdVoyNo = vskActPortSkdEdiLogVO.getSkdVoyNo();
							String tmpSkdDirCd = vskActPortSkdEdiLogVO.getSkdDirCd();
							String tmpClptIndSeq = clptIndSeq;
							
							vskActPortSkdEdiLogVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
							vskActPortSkdEdiLogVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
							clptIndSeq = vskVslPortSkdVO.getTurnClptIndSeq();
							
							vskVslPortSkdVO.setTurnPortFlg("Y");
							if("F".equals(vskVslPortSkdVO.getTurnPortIndCd())){
								vskVslPortSkdVO.setTurnPortIndCd("N");
							}else{
								vskVslPortSkdVO.setTurnPortIndCd("Y");
							}
							vskVslPortSkdVO.setTurnSkdVoyNo(tmpSkdVoyNo);
							vskVslPortSkdVO.setTurnSkdDirCd(tmpSkdDirCd);
							vskVslPortSkdVO.setTurnClptIndSeq(tmpClptIndSeq);
						}
					}
					/* 2015.01.21 dongsoo
					 * Actual Future Date Check
					 */
					ActSkdMgtVO actSkdMgtVO = new ActSkdMgtVO();
					 
					actSkdMgtVO.setActArrDt(vskActPortSkdEdiLogVO.getEdiActArrDt());
					actSkdMgtVO.setActBrthDt(vskActPortSkdEdiLogVO.getEdiActBrthDt());
					actSkdMgtVO.setActDepDt(vskActPortSkdEdiLogVO.getEdiActDepDt());
					actSkdMgtVO.setVpsPortCd(vskActPortSkdEdiLogVO.getYdCd().substring(0, 5));
					ActSkdDtlVO actSkdDtlVO = dbDao.checkInputActDateEffectiveness(actSkdMgtVO);
					
					StringBuffer sbIneffectivenessMsg = new StringBuffer("");
					int iInvalKnt = 0;
					if (actSkdDtlVO != null) {
						
						String sInputATADateInvalid	= actSkdDtlVO.getInputATADateEffectiveness();
						String sInputATBDateInvalid	= actSkdDtlVO.getInputATBDateEffectiveness();
						String sInputATDDateInvalid	= actSkdDtlVO.getInputATDDateEffectiveness();
						
						if(sInputATADateInvalid != null && !"".equals(sInputATADateInvalid)){
							sbIneffectivenessMsg.append(sInputATADateInvalid);
							iInvalKnt++;
						}
						
						if(sInputATBDateInvalid != null && !"".equals(sInputATBDateInvalid)){
							if(sbIneffectivenessMsg.length() > 0) {
								sbIneffectivenessMsg.append("/").append(sInputATBDateInvalid);
							} else {
								sbIneffectivenessMsg.append(sInputATBDateInvalid);
							}
							iInvalKnt++;
						}
						
						if(sInputATDDateInvalid != null && !"".equals(sInputATDDateInvalid)){
							if(sbIneffectivenessMsg.length() > 0) {
								sbIneffectivenessMsg.append("/").append(sInputATDDateInvalid);
							} else {
								sbIneffectivenessMsg.append(sInputATDDateInvalid);
							}
							iInvalKnt++;
						}
					}
					
					if (iInvalKnt > 0) {
						errMsgs = new String[]{sbIneffectivenessMsg.toString()};
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK55001", errMsgs).getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
//					#########################################################################
//					# Finding existed Actual, Setting to not change original
//					#########################################################################
					VskActPortSkdVO vvdPortVO = new VskActPortSkdVO();
					vvdPortVO.setVslCd(vskActPortSkdEdiLogVO.getVslCd());
					vvdPortVO.setSkdVoyNo(vskActPortSkdEdiLogVO.getSkdVoyNo());
					vvdPortVO.setSkdDirCd(vskActPortSkdEdiLogVO.getSkdDirCd());
					vvdPortVO.setVpsPortCd(vskActPortSkdEdiLogVO.getVpsPortCd());
					vvdPortVO.setClptIndSeq(clptIndSeq);
					VskActPortSkdVO returnActPortVO = dbDao.searchVskActPortSkd(vvdPortVO);
					
//					if(returnActPortVO != null){
//						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActDepDt())){
//							failCnt++;
//							errMsgs = new String[]{sbIneffectivenessMsg.toString()};
//							// [Failed] Already updated.
//							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10059", errMsgs).getUserMessage());
//							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
//							continue;
//						}
//
//						// in case original ATB is exist, user cannot change
//						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActBrthDt())){
//							errMsgs = new String[]{sbIneffectivenessMsg.toString()};
//							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10059", errMsgs).getUserMessage());
//							vskActPortSkdEdiLogVO.setActBrthDt(returnActPortVO.getActBrthDt());
//						}
//
//						// in case original ATA is exist, user cannot change
//						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActArrDt())){
//							errMsgs = new String[]{sbIneffectivenessMsg.toString()};
//							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10059", errMsgs).getUserMessage());
//							vskActPortSkdEdiLogVO.setActArrDt(returnActPortVO.getActArrDt());
//						}
//					}
//					
					//String ediActArrDt 	= vskActPortSkdEdiLogVO.getEdiActArrDt	();
					//String ediActBrthDt = vskActPortSkdEdiLogVO.getEdiActBrthDt	();
					//String ediActDepDt 	= vskActPortSkdEdiLogVO.getEdiActDepDt	();
					/*
					2015-07-24  ATA or ATB or ATD, Inputed by UI Setting to not change original
					 */
					if(returnActPortVO != null){	
					if(VSKGeneralUtil.isNotNull(returnActPortVO.getActDepDt())&&VSKGeneralUtil.isNotNull(returnActPortVO.getActBrthDt())
							&&VSKGeneralUtil.isNotNull(returnActPortVO.getActArrDt())){
						if(VSKGeneralUtil.isNull(ediActDepDt)){
							failCnt++;
//							errMsgs = new String[]{sbIneffectivenessMsg.toString()};
//							// [Failed] Already updated.
//							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10059", errMsgs).getUserMessage());
							vskActPortSkdEdiLogVO.setRsltMsg("Vessel Condition has already updated 'Departure',  Please update including ATD in EDI.");
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
							}
						}
					}
					
					
					
					/* #########################################################################
					# in case ATA, ATB, ATD is null - Handling Error as follows
					# ==========================================================================
					# 		ATA			ATB			ATD			Result
					#		 O			 O			 O			  Y			ABD
					#		 O			 O			 X			  Y			AB
					#		 O			 X			 X			  Y			A
					#		 O			 X			 O			  X
					#		 X			 O			 O			  X
					#		 X			 O			 X			  X
					#		 X			 X			 O			  X
					#		 X			 X			 X			  X
					######################################################################### */
					String sAta = "";
					String sAtb = "";
					String sAtd = "";
					
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActArrDt())){
						sAta = "A";
					}
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActBrthDt())){
						sAtb = "B";
					}
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActDepDt())){
						sAtd = "D";
					}
					String sAllStatus = sAta + sAtb + sAtd;
					
					if(!("ABD".equals(sAllStatus) || "AB".equals(sAllStatus) || "A".equals(sAllStatus))){
						failCnt++;
						// [Error] No exists ATA, ATB.
						errMsg.append("No exist ATA, ATB.  Please add Actual Berth Date in EDI.");
						vskActPortSkdEdiLogVO.setRsltMsg("[Date Vaildation Error]  : " + errMsg + " ");
						//vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
					
					/*					
					#########################################################################
					# Comparing ETD of previous port and ATA of current port
					# 2015-07-29 
					# Comparing ETA of Next Port and ATA/ATB/ATD of current port
					# Comparing ATA/ATB/ATD of current port
					#########################################################################
 					*/					
					//StringBuffer errMsg = new StringBuffer();
					
					String chkFlg = dbDao.checkPreCallingPortInfo(vskActPortSkdEdiLogVO);
					if("N".equals(chkFlg)){
						failCnt++;
						errMsg.append(" ATB/ATD must be later than Previous Port ETD.");
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						//continue;
					}
					
					String nxtChkFlg = dbDao.checkNextCallingPortInfo(vskActPortSkdEdiLogVO);
					if("N".equals(nxtChkFlg)){
						failCnt++;
						errMsg.append(" ATB/ATD must be faster than Next Port ETA.");
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						//continue;
					}
					
					String revChkFlg = dbDao.checkActDateReverseEdiLog(vskActPortSkdEdiLogVO);
					if("N".equals(revChkFlg)){
					failCnt++;
					errMsg.append(" ATB/ATD can't be reversed.");
					dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
					//continue;
					}
					
					if("N".equals(revChkFlg)||"N".equals(nxtChkFlg)||"N".equals(chkFlg)){
						vskActPortSkdEdiLogVO.setRsltMsg("[Date Vaildation Error]  : " + errMsg + " ");
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}

					
					// Setting user information
					vskActPortSkdEdiLogVO.setCreUsrId(usrId);
					vskActPortSkdEdiLogVO.setUpdUsrId(usrId);
					
					successCnt++;
					
					vskVslPortSkdVO.setClptIndSeq(clptIndSeq);
					vskVslPortSkdVOs.add(vskVslPortSkdVO);
					
					if (returnActPortVO != null) {
						vskActPortSkdVOs.add(returnActPortVO);
					}
				
					rtnVskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
				} // end for
				
				ediLogDataGRPVO.setVskActPortSkdEdiLogVOs(rtnVskActPortSkdEdiLogVOs);
				ediLogDataGRPVO.setVskVslPortSkdVOs(vskVslPortSkdVOs);
				
				if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
					ediLogDataGRPVO.setVskActPortSkdVOs(vskActPortSkdVOs);
				}
				
				ediLogDataGRPVO.setValue1(successCnt);
				ediLogDataGRPVO.setValue2(failCnt);
			}
	
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return ediLogDataGRPVO;
	}
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs
	 * @param SignOnUserAccount account
	 * @return EdiLogDataGRPVO
	 * @exception EventException
	 */
	public EdiLogDataGRPVO auditReceivedEdiData_bk_20150121(List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs, SignOnUserAccount account) throws EventException{
		
		//after checking auditReceivedEdiData method,
		//modifyVskActPortSkdEdiLog
		EdiLogDataGRPVO ediLogDataGRPVO = new EdiLogDataGRPVO();
		int successCnt = 0;		// success count
		int failCnt = 0;		// fail count
		log.info("################### auditReceivedEdiData() START>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		try {
			String usrId = "";
//			if(account == null){
				usrId = "IF_EDI_SVC";
//			}else{
//				usrId = account.getUsr_id();
//			}
			
			if(vskActPortSkdEdiLogVOs != null && vskActPortSkdEdiLogVOs.size() > 0){
				List<VskActPortSkdEdiLogVO> rtnVskActPortSkdEdiLogVOs = new ArrayList<VskActPortSkdEdiLogVO>();
				List<VskVslPortSkdVO> vskVslPortSkdVOs = new ArrayList<VskVslPortSkdVO>();
				List<VskActPortSkdVO> vskActPortSkdVOs = new ArrayList<VskActPortSkdVO>();
				
				for(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO : vskActPortSkdEdiLogVOs){				
					
//					#########################################################################
//					# Retrieving EDI Set-up Info.
//					#########################################################################
					ActEDISetupInfoVO paramVO = new ActEDISetupInfoVO();
					paramVO.setPrnrSubLnkCd(vskActPortSkdEdiLogVO.getYdCd());
					paramVO.setSndrTrdPrnrId(vskActPortSkdEdiLogVO.getSndrTrdPrnrId());
					
					
					////::2015-01-11:TOP:://ActEDISetupInfoVO actEDISetupInfoVO = dbDao.searchActEDISetUpInfo(paramVO);
					
					////::2015-01-11:TOP:://if(actEDISetupInfoVO == null || "X".equals(actEDISetupInfoVO.getVslCdFlg())){
					////::2015-01-11:TOP:://	failCnt++;
					////::2015-01-11:TOP:://	//[Error] No exists Set-Up Information.
					////::2015-01-11:TOP:://	vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10065").getUserMessage());
					////::2015-01-11:TOP:://	dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
					////::2015-01-11:TOP:://	continue;
					////::2015-01-11:TOP:://}
					
//					#########################################################################
//					# Finding vsl_cd, skd_voy_no, skd_dir_cd.
//					# Order to find VVD,
//					#     1. Vessel Code.
//					#     2. Call Sign No.
//					#     3. IMO(Llody No) No.					
//					#########################################################################
					
					List<VskActPortSkdEdiLogVO> rtnVvdVOs = null;	
					List<VskActPortSkdEdiLogVO> rtnPortVOs = null;
					String	ediVslCd = vskActPortSkdEdiLogVO.getEdiVslNm();
					String	callSingNo = vskActPortSkdEdiLogVO.getCallSgnNo();
					String	llodyNo = vskActPortSkdEdiLogVO.getLloydNo();
					String	errNo = "";
					String[] errMsgs = new String[]{""};
					
					////::2015-01-11:TOP:://String vslCdFlg = actEDISetupInfoVO.getVslCdFlg();
					String vslCdFlg = "05";		////::2015-01-11:TOP::HARD CODING FOR NYK:://

					log.info("\n\n" +
					   "===================================================================================================================\n"+
					   ////::2015-01-11:TOP:://"["+ actEDISetupInfoVO.getVslCdFlg() +"] ["+ actEDISetupInfoVO.getMnvrInHrsFlg()+"] ["+ actEDISetupInfoVO.getActDateFlg() +"]\n"+
					   "vsl Cd : ["+ ediVslCd +"] call Sign : ["+ callSingNo +"] lloyd : ["+ llodyNo +"] ship call no : ["+ vskActPortSkdEdiLogVO.getShpCallNo() +"]\n"+
					   "Voy No. : ["+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"]\n"+
					   "Dir Cd. : ["+ vskActPortSkdEdiLogVO.getEdiSkdDirNm() +"]\n"+
					   "Port Cd : ["+ vskActPortSkdEdiLogVO.getVpsPortCd() +"]\n"+
					   "==================================================================================================================\n");
					
					// in case ediVslCd, callSignNo, llodyNo are all null, Vessel Code cannot find
					// VSK10027 : Vessel Code doesn't exist.
					if(VSKGeneralUtil.isNull(ediVslCd) && VSKGeneralUtil.isNull(callSingNo) && VSKGeneralUtil.isNull(llodyNo)){
						failCnt++;
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10027").getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
//					###################################################################################
//					# setup information (vslCdFlg = "01"), Finding VVD in case Voyage Number
//					###################################################################################
					if("01".equals(vslCdFlg)){
						//[Error] No exists VVD(voyage & direction).($s)
						errNo = "VSK10072";
						
						if (!"".equals(ediVslCd)) {
							rtnVvdVOs = dbDao.searchVvdByReceviedVoyDirVslCd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm()};
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSingNo)) {
							rtnVvdVOs  = dbDao.searchVvdByReceviedVoyDirCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm()};
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchVvdByReceviedVoyDirImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm()};
							}
						}
						
						if (rtnVvdVOs == null || rtnVvdVOs.size() == 0) {
							if (!"".equals(ediVslCd)) {
								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm()};
							} else if (!"".equals(callSingNo)) {
								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm()};
							} else if ("2".equals(llodyNo)) {
								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm()};
							}
							
							rtnPortVOs = dbDao.searchVvdByReceviedVoyDirAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								// Showing message in case cannot retrieve in case of yard code, but can retrieve in case of port code
								errMsgs[0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
							}
						}
						
//					###################################################################################
//					# setup information (vslCdFlg = "02"),  Finding VVD in case Terminal Voyage
//					###################################################################################				
					} else if("02".equals(vslCdFlg)){
						//[Error] No exists a Vvd as a terminal voyage.($s)
						errNo = "VSK10062";
						
						if (!"".equals(ediVslCd)) {
							rtnVvdVOs = dbDao.searchVvdByReceviedTmnlVoyNoVslCd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSingNo)) {
							rtnVvdVOs  = dbDao.searchVvdByReceviedTmnlVoyNoCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchVvdByReceviedTmnlVoyNoImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							}									
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
							if (!"".equals(ediVslCd)) {
								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} else if (!"".equals(callSingNo)) {
								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} else if (!"".equals(llodyNo)) {
								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							}
							
							rtnPortVOs = dbDao.searchVvdByReceviedTmnlVoyNoAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								// Showing message in case cannot retrieve in case of yard code, but can retrieve in case of port code
								errMsgs[0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
							}
						}
						
//					###################################################################################
//					# setup information (vslCdFlg = "03" & "04"),  Finding VVD in case BKG Ship Call Number
//					###################################################################################
					} else if("03".equals(vslCdFlg) || "04".equals(vslCdFlg)){

						//[Error] No exists a Vvd as a ship call number.($s)
						errNo = "VSK10063";
						
						if (!"".equals(ediVslCd)) {
							rtnVvdVOs = dbDao.searchVvdByReceviedShipCallNoVslCd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSingNo)) {
							rtnVvdVOs  = dbDao.searchVvdByReceviedShipCallNoCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchVvdByReceviedShipCallNoImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							}									
						}
					
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
							if (!"".equals(ediVslCd)) {
								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} else if (!"".equals(callSingNo)) {
								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							} else if (!"".equals(llodyNo)) {
								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
							}
							
							rtnPortVOs = dbDao.searchVvdByReceviedShipCallNoAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								// Showing message in case cannot retrieve in case of yard code, but can retrieve in case of port code
								errMsgs[0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
							}
						}
						
//					#########################################################################
//					# setup information (vslCdFlg = "05") , Finding VVD
//					#########################################################################
					}else if("05".equals(vslCdFlg)){
						
						//[Error] No exists a VVD as a PAS code.($s)
						errNo = "VSK10070";
						
//						if (!"".equals(ediVslCd)) {
//							rtnVvdVOs = dbDao.searchVvdByReceviedPsaVoyNoVslCd(vskActPortSkdEdiLogVO);
//							
//							if (rtnVvdVOs.size() > 1) {
//								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//							} 
//						}
//						
//						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSingNo)) {
//							rtnVvdVOs  = dbDao.searchVvdByReceviedPsaVoyNoCallSignNo(vskActPortSkdEdiLogVO);
//
//							if (rtnVvdVOs.size() > 1) {
//								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//							} 
//						}
//						
//						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
//							rtnVvdVOs  = dbDao.searchVvdByReceviedPsaVoyNoImoNo(vskActPortSkdEdiLogVO);
//							
//							if (rtnVvdVOs.size() > 1) {
//								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//							}									
//						}
//					
//						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
//							if (!"".equals(ediVslCd)) {
//								errMsgs = new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//							} else if (!"".equals(callSingNo)) {
//								errMsgs = new String[]{"Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//							} else if (!"".equals(llodyNo)) {
//								errMsgs = new String[]{"IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//							}
//							
//							rtnPortVOs = dbDao.searchVvdByReceviedPsaVoyNoAll(vskActPortSkdEdiLogVO);
//							if (rtnPortVOs.size() != 0) {
//								// Showing message in case cannot retrieve by yard code, but can retrieve by port code
//								errMsgs[0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
//							}
//						}
						
						
						////::2015-01-12:TOP::////
						rtnPortVOs = dbDao.searchVvdByReceviedPsaVoyNoAll(vskActPortSkdEdiLogVO);
						if (rtnPortVOs.size() != 0) {
							// Showing message in case cannot retrieve by yard code, but can retrieve by port code
							errMsgs[0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
						}	
						////::2015-01-12:TOP::////
						
					
					}
					
					////::2015-01-12:TOP::////
					if (rtnPortVOs == null || rtnPortVOs.size() != 1) {
						failCnt++;
						
						if (rtnPortVOs != null && rtnPortVOs.size() > 1 ) {
							// in case more than 2 VVD are retrieving,
							if (rtnVvdVOs != null ){
								errMsgs[0] += ", Duplicated VVD : " + getDuplicateVvdMsg(rtnVvdVOs);	
							}
						}
						
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler(errNo, errMsgs).getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}					
					////::2015-01-12:TOP::////
					
					
//					if (rtnVvdVOs == null || rtnVvdVOs.size() != 1) {
//						failCnt++;
//						
//						if (rtnVvdVOs.size() > 1 ) {
//							// in case more than 2 VVD are retrieving,
//							errMsgs[0] += ", Duplicated VVD : " + getDuplicateVvdMsg(rtnVvdVOs);
//						}
//						
//						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler(errNo, errMsgs).getUserMessage());
//						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
//						continue;
//					}
					
					vskActPortSkdEdiLogVO.setVslCd		(rtnPortVOs.get(0).getVslCd		());
					vskActPortSkdEdiLogVO.setSkdVoyNo	(rtnPortVOs.get(0).getSkdVoyNo	());
					vskActPortSkdEdiLogVO.setSkdDirCd	(rtnPortVOs.get(0).getSkdDirCd	());
					
//					#########################################################################
//					# Setting ATA, ATB, ATD using mnvr in hrs
//					#########################################################################
					
					String ediActArrDt 	= vskActPortSkdEdiLogVO.getEdiActArrDt	();
					String ediActBrthDt = vskActPortSkdEdiLogVO.getEdiActBrthDt	();
					String ediActDepDt 	= vskActPortSkdEdiLogVO.getEdiActDepDt	();
					
					if(VSKGeneralUtil.isNull(ediActArrDt) && VSKGeneralUtil.isNull(ediActBrthDt) && VSKGeneralUtil.isNotNull(ediActDepDt)){
						
						// Assume that ATA, ATB are already input
						vskActPortSkdEdiLogVO.setActDepDt(ediActDepDt);
						
					}else{
						
						////::2015-01-11:TOP:://String actDateFlg 	= actEDISetupInfoVO.getActDateFlg	();
						////::2015-01-11:TOP:://String mnvrInHrsFlg = actEDISetupInfoVO.getMnvrInHrsFlg	();
						
						String actDateFlg 	= "01";		////::2015-01-11:TOP::HARD CODING FOR NYK:://
						String mnvrInHrsFlg = "Y";		////::2015-01-11:TOP::HARD CODING FOR NYK:://				
						
						
						if("01".equals(actDateFlg)){
							// actDateFlg == 01 : only ATA, ATD are input
							
							if("Y".equals(mnvrInHrsFlg)){
								if(VSKGeneralUtil.isNotNull(ediActArrDt)){
									
									//::2016-07-07:by TOP:IFTSAI-temporary save ATB from ATA of EDI:://
									//**vskActPortSkdEdiLogVO.setActArrDt(vskActPortSkdEdiLogVO.getEdiActArrDt());
									//**String actBrthDt = dbDao.searchActBrthDtByMnvrInHrs(vskActPortSkdEdiLogVO);
									//**if(VSKGeneralUtil.isNull(actBrthDt)){
									//**	failCnt++;
										// [Error] No exists Maneunvering In Hour.
									//**	vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
									//**	dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
									//**	continue;
									//**}
									//**vskActPortSkdEdiLogVO.setActBrthDt(actBrthDt);
									
									vskActPortSkdEdiLogVO.setActBrthDt(vskActPortSkdEdiLogVO.getEdiActBrthDt());
									String actArrDate = dbDao.searchActArrDateByMnvrInHrs(vskActPortSkdEdiLogVO);
									
									
									if(VSKGeneralUtil.isNull(actArrDate)){
										failCnt++;
										// [Error] No exists Maneunvering In Hour.
										vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
										dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
										continue;
									}
									vskActPortSkdEdiLogVO.setActArrDt(actArrDate);
									///////////////////////////////////////////////////////////////////
									
								}else{
									failCnt++;
									// [Error] No exists ATA, ATB.
									vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
									dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
									continue;
								}
							}else{
								failCnt++;
								// [Error] No exists ATA, ATB.
								vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
								dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
								continue;
							}
							
							
						}else if("02".equals(actDateFlg)){
							// actDateFlg == 02 : only ATB, ATD are input
							if("Y".equals(mnvrInHrsFlg)){
								if(VSKGeneralUtil.isNotNull(ediActBrthDt)){
									vskActPortSkdEdiLogVO.setActBrthDt(vskActPortSkdEdiLogVO.getEdiActBrthDt());
									
									String actArrDt = dbDao.searchActArrDateByMnvrInHrs(vskActPortSkdEdiLogVO);
									if(VSKGeneralUtil.isNull(actArrDt)){
										failCnt++;
										// [Error] No exists Maneunvering In Hour.
										vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
										dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
										continue;
									}
									vskActPortSkdEdiLogVO.setActArrDt(actArrDt);
								}else{
									failCnt++;
									// [Error] No exists ATA, ATB.
									vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
									dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
									continue;
								}
								
							}else{
								failCnt++;
								// [Error] No exists ATA, ATB.
								vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
								dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
								continue;
							}
							
						}else if("03".equals(actDateFlg)){
							vskActPortSkdEdiLogVO.setActArrDt(vskActPortSkdEdiLogVO.getEdiActArrDt());
							vskActPortSkdEdiLogVO.setActBrthDt(vskActPortSkdEdiLogVO.getEdiActBrthDt());
						}else{
							failCnt++;
							// [Error] No exists ATA, ATB, ATD.
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
						}
						vskActPortSkdEdiLogVO.setActDepDt(ediActDepDt);
					}
					
					
//					#########################################################################
//					# Setting clpt_ind_seq ,turning info, virtual info
//					#########################################################################
					
					
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslCd(vskActPortSkdEdiLogVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo(vskActPortSkdEdiLogVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd(vskActPortSkdEdiLogVO.getSkdDirCd());
					
					vskVslSkdVO = dbDao.searchVskVslSkd(vskVslSkdVO);
					vskActPortSkdEdiLogVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
					
					String clptIndSeq = dbDao.searchCallingIndicator(vskActPortSkdEdiLogVO);
					vskActPortSkdEdiLogVO.setClptIndSeq(clptIndSeq);
					VskVslPortSkdVO vskVslPortSkdVO = dbDao.searchOriginalVoyDir(vskActPortSkdEdiLogVO);
					if(vskVslPortSkdVO == null){
						failCnt++;
						String vslCd = vskActPortSkdEdiLogVO.getVslCd();
						String skdVoyNo = vskActPortSkdEdiLogVO.getSkdVoyNo();
						String skdDirCd = vskActPortSkdEdiLogVO.getSkdDirCd();
						String vpsPortCd = vskActPortSkdEdiLogVO.getVpsPortCd();
						errMsgs = new String[]{vslCd +"/"+ skdVoyNo + "/" + skdDirCd + "/" + vpsPortCd + "/" + clptIndSeq};
						//[Error] No exists a vesssl port schedule.($s)
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10060", errMsgs).getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}else{
						if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVO.getTurnPortIndCd())){
							// Setting turning in case of Virtual
							String tmpSkdVoyNo = vskActPortSkdEdiLogVO.getSkdVoyNo();
							String tmpSkdDirCd = vskActPortSkdEdiLogVO.getSkdDirCd();
							String tmpClptIndSeq = clptIndSeq;
							
							vskActPortSkdEdiLogVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
							vskActPortSkdEdiLogVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
							clptIndSeq = vskVslPortSkdVO.getTurnClptIndSeq();
							
							vskVslPortSkdVO.setTurnPortFlg("Y");
							if("F".equals(vskVslPortSkdVO.getTurnPortIndCd())){
								vskVslPortSkdVO.setTurnPortIndCd("N");
							}else{
								vskVslPortSkdVO.setTurnPortIndCd("Y");
							}
							vskVslPortSkdVO.setTurnSkdVoyNo(tmpSkdVoyNo);
							vskVslPortSkdVO.setTurnSkdDirCd(tmpSkdDirCd);
							vskVslPortSkdVO.setTurnClptIndSeq(tmpClptIndSeq);
						}
					}
					
//					#########################################################################
//					# Finding existed Actual, Setting to not change original
//					#########################################################################
					VskActPortSkdVO vvdPortVO = new VskActPortSkdVO();
					vvdPortVO.setVslCd(vskActPortSkdEdiLogVO.getVslCd());
					vvdPortVO.setSkdVoyNo(vskActPortSkdEdiLogVO.getSkdVoyNo());
					vvdPortVO.setSkdDirCd(vskActPortSkdEdiLogVO.getSkdDirCd());
					vvdPortVO.setVpsPortCd(vskActPortSkdEdiLogVO.getVpsPortCd());
					vvdPortVO.setClptIndSeq(clptIndSeq);
					VskActPortSkdVO returnActPortVO = dbDao.searchVskActPortSkd(vvdPortVO);
					
					if(returnActPortVO != null){
						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActDepDt())){
							failCnt++;
							// [Failed] Already updated.
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10059").getUserMessage());
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
						}

						// in case original ATB is exist, user cannot change
						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActBrthDt())){
							vskActPortSkdEdiLogVO.setActBrthDt(returnActPortVO.getActBrthDt());
						}

						// in case original ATA is exist, user cannot change
						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActArrDt())){
							vskActPortSkdEdiLogVO.setActArrDt(returnActPortVO.getActArrDt());
						}
					}
					
					/* #########################################################################
					# in case ATA, ATB, ATD is null - Handling Error as follows
					# ==========================================================================
					# 		ATA			ATB			ATD			Result
					#		 O			 O			 O			  Y			ABD
					#		 O			 O			 X			  Y			AB
					#		 O			 X			 X			  Y			A
					#		 O			 X			 O			  X
					#		 X			 O			 O			  X
					#		 X			 O			 X			  X
					#		 X			 X			 O			  X
					#		 X			 X			 X			  X
					######################################################################### */
					String sAta = "";
					String sAtb = "";
					String sAtd = "";
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActArrDt())){
						sAta = "A";
					}
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActBrthDt())){
						sAtb = "B";
					}
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActDepDt())){
						sAtd = "D";
					}
					String sAllStatus = sAta + sAtb + sAtd;
					if(!("ABD".equals(sAllStatus) || "AB".equals(sAllStatus) || "A".equals(sAllStatus))){
						failCnt++;
						// [Error] No exists ATA, ATB.
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
//					#########################################################################
//					# Comparing ETD of previous port and ATA of current port
//					#########################################################################
					String chkFlg = dbDao.checkPreCallingPortInfo(vskActPortSkdEdiLogVO);
					if("N".equals(chkFlg)){
						failCnt++;
						errMsgs = new String[]{vskActPortSkdEdiLogVO.getActArrDt()};
						// [Error] Current ATA($s) is faster than  ETD of previous VVD.
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10067", errMsgs).getUserMessage());
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
					// Setting user information
					vskActPortSkdEdiLogVO.setCreUsrId(usrId);
					vskActPortSkdEdiLogVO.setUpdUsrId(usrId);
					
					successCnt++;
					
					vskVslPortSkdVO.setClptIndSeq(clptIndSeq);
					vskVslPortSkdVOs.add(vskVslPortSkdVO);
					
					if (returnActPortVO != null) {
						vskActPortSkdVOs.add(returnActPortVO);
					}
				
					rtnVskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
				} // end for
				
				ediLogDataGRPVO.setVskActPortSkdEdiLogVOs(rtnVskActPortSkdEdiLogVOs);
				ediLogDataGRPVO.setVskVslPortSkdVOs(vskVslPortSkdVOs);
				
				if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
					ediLogDataGRPVO.setVskActPortSkdVOs(vskActPortSkdVOs);
				}
				
				ediLogDataGRPVO.setValue1(successCnt);
				ediLogDataGRPVO.setValue2(failCnt);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return ediLogDataGRPVO;
	}
	
	/**
	 * Setting Error remark in case more than 2 VVD are retrieving using EDI Information
	 * 
	 * List<VskActPortSkdEdiLogVO> vvdVOs
	 * @return String
	 */
	 
	private String getDuplicateVvdMsg(List<VskActPortSkdEdiLogVO> vvdVOs){
		
		StringBuffer vvdMsg = new StringBuffer();
		
		for(int i=0; i<vvdVOs.size(); i++){
			vvdMsg.append("(").append(vvdVOs.get(i).getVslCd()).append("/").append(vvdVOs.get(i).getSkdVoyNo()).append("/").append(vvdVOs.get(i).getSkdDirCd()).append(")");
		}
		
		return vvdMsg.toString();
		
	}
	
	/**
	 * Setting Error Remark in case cannot retrieve by yard code, but can retrieve by port code
	 * 
	 * List<VskActPortSkdEdiLogVO> portVOs
	 * @return String
	 */
	 
	private String getPortVvdMsg(List<VskActPortSkdEdiLogVO> portVOs){
		StringBuffer portMsg = new StringBuffer();
		
		for(int i=0; i<portVOs.size(); i++){
			portMsg.append("(").append(portVOs.get(i).getVslCd()).append("/").append(portVOs.get(i).getSkdVoyNo()).append("/").append(portVOs.get(i).getSkdDirCd()).append("/").append(portVOs.get(i).getYdCd()).append(")");
		}
		
		return portMsg.toString();
	}
	
	/**
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO, SignOnUserAccount account) throws EventException{
		try{
			dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Calling Port by condition from SPP
	 * Finding ETA of inputed Port Code between -7 day and +7 day<br>
	 * 
	 * @param String vpsPortCd
	 * @param String vslSvcTpCd
	 * @return List<VvdListByPortVO>
	 * @exception EventException
	 */
	public List<VvdListByPortVO> searchSppVvdListByPort(String vpsPortCd, String vslSvcTpCd) throws EventException {
		try {
			return dbDao.searchSppVvdListByPort(vpsPortCd,vslSvcTpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Actual Schedule History<br>
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<ActPortSkdHisVO>
	 * @exception EventException
	 */
	public List<ActPortSkdHisVO> searchActPortSkdHis(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException{
		try {
			return dbDao.searchActPortSkdHis(vvdPortLaneOtherVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Deleting Actual Port Schedule Information
	 *  
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void removeVskActPortSkd(List<VvdVO> vvdVOs) throws EventException {
		try{
			// :: VIPS START ::
//			System.out.println("VIPS[searchVskActPortSkd2]");
			List<String> vvds = new ArrayList<String>();
			for(int i=0; i<vvdVOs.size(); i++){
				VvdVO vvdVO = vvdVOs.get(i);
				String vvd = vvdVO.getSkdVoyNo() + vvdVO.getSkdVoyNo() + vvdVO.getSkdDirCd();
				if(!vvds.contains(vvd)) {
					VskActPortSkdVO vo = new VskActPortSkdVO();
					vo.setVslCd(vvdVO.getVslCd());
					vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
					vo.setSkdDirCd(vvdVO.getSkdDirCd());
					List<VskActPortSkdVO> list = dbDao.searchActPortSkdbyVVD(vo);
					for(VskActPortSkdVO row : list) {
						this.mVskActPortSkdList.add(row);
					}
					vvds.add(vvd);
				}
			}
			// :: VIPS START ::
			for(int i=0; i<vvdVOs.size(); i++){
				dbDao.removeVskActPortSkd(vvdVOs.get(i));
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}
	}
	
	//::FOR.NYK.START::by TOP:2014-09-16:://
		/**
		 * Adding Validation Check Logic for Inputted Future Date<br>
		 * 
		 * @param ActSkdMgtVO actSkdMgtVO
		 * @return ActSkdDtlVO
		 * @exception EventException
		 */
		public ActSkdDtlVO checkInputActDateEffectiveness(ActSkdMgtVO actSkdMgtVO) throws EventException{
			
			ActSkdDtlVO 	returnVO	= new ActSkdDtlVO();
			
			try {
				
				if(actSkdMgtVO != null){
					returnVO	= dbDao.checkInputActDateEffectiveness(actSkdMgtVO);
				}
				
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
			}
			
			return returnVO;
			
		}	
		//::FOR.NYK.FINISH::by TOP:2014-09-16:://
		
}
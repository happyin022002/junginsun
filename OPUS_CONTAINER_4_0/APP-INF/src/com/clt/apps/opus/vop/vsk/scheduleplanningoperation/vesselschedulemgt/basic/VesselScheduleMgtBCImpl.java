/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VesselScheduleMgtBCImpl.java
 *@FileTitle : VSL SKD Delete & Closing
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.builder.CompareToBuilder;

import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActualSkdBySimNoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SkipPortGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdHisInVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisGroupVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdCheckVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.VskDepRptVO;
import com.clt.syscommon.common.table.VskHydrstMtxVO;
import com.clt.syscommon.common.table.VskNoonRptVO;
import com.clt.syscommon.common.table.VskPortDistVO;
import com.clt.syscommon.common.table.VskPortTideVO;
import com.clt.syscommon.common.table.VskSwapCstPortVO;
import com.clt.syscommon.common.table.VskSwapCstSimVO;
import com.clt.syscommon.common.table.VskSwapCstVvdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * SchedulePlanningOperation Business Logic Basic Command implementation<br>
 * - Handling business logic of SchedulePlanningOperation<br>
 * 
 * @author
 * @see UI_VSK-0018EventResponse,VesselScheduleMgtBC, DAO
 * @since J2EE 1.4
 */ 

public class VesselScheduleMgtBCImpl extends BasicCommandSupport implements
		CoastalScheduleMgtBC, LongRangeScheduleMgtBC {

	// Database Access Object
	private transient VesselScheduleMgtDBDAO dbDao = null;
//	private transient VesselScheduleMgtEAIDAO eaiDao = null;

	// :: VIPS START ::
	private List<VskVslPortSkdVO> mVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
	private List<VskVslPortSkdVO> mDelNextVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
	private List<VskVslPortSkdVO> mDelNextDirVslPortSkdList = new ArrayList<VskVslPortSkdVO>();	
	private List<VskVslSkdVO> mVskVslSkdList   = new ArrayList<VskVslSkdVO>();
	
	public List<VskVslPortSkdVO> getVslPortSkdList() {
		return this.mVslPortSkdList;
	}

	public List<VskVslPortSkdVO> getDelNextVslPortSkdList() {
		return this.mDelNextVslPortSkdList;
	}

	public List<VskVslPortSkdVO> getDelNextDirVslPortSkdList() {
		return this.mDelNextDirVslPortSkdList;
	}
	
	public List<VskVslSkdVO> getVskVslSkdList() {
		return this.mVskVslSkdList;
	}

	/**
	 * VesselScheduleMgtBCImpl object creation<br>
	 * Creating VesselScheduleMgtDBDAO<br>
	 */
	public VesselScheduleMgtBCImpl() {
		dbDao = new VesselScheduleMgtDBDAO();
//		eaiDao = new VesselScheduleMgtEAIDAO();
		// initialize
		this.mVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
		this.mDelNextVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
		this.mDelNextDirVslPortSkdList = new ArrayList<VskVslPortSkdVO>();
		this.mVskVslSkdList  = new ArrayList<VskVslSkdVO>();
	}
	// :: VIPS END ::
	/**
	 * Retrieving Vessel Schedule of lane
	 * 
	 * @param ActivationVvdVO activationVvdVO
	 * @return List<ActivationVvdVO>
	 * @exception EventException
	 */
	public List<ActivationVvdVO> searchVslSkdListByLane(ActivationVvdVO activationVvdVO)
			throws EventException {
		try {
			return dbDao.searchVslSkdListByLane(activationVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Deleting Schedule of VVD
	 * first parameter(activationVvdVO1) - in case SKD without Booking
	 * second parameter(activationVvdVO2) - in case SKD with Booking
	 * 
	 * @param ActivationVvdVO[] activationVvdVO1s
	 * @param ActivationVvdVO[] activationVvdVO2s
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @param SignOnUserAccount account
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVO1s, ActivationVvdVO[] activationVvdVO2s,	VskVslSkdHisVO vskVslSkdHisVO, SignOnUserAccount account, String sFromEventSystem) throws EventException{
		
		String sCnvtFromEventSystem	= "";
		
		try {
			
			//in case reason does not input(UI_VSK_0249)
			//Checking Booging Data of BKG_VVD (exist : PASS (return with returnVoLis), no exist :REMOVE(no save HISTORY))
			
			// in case SKD without Booking
			if(vskVslSkdHisVO == null){
				
				for(ActivationVvdVO vo : activationVvdVO1s){
					if(vo==null) continue;
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				
				//::by TOP:2015-05-08:://
				if(			"DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)";
				}else if(	"DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054)";
				}else if(	"DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)"			.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)";
				}else if(	"DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)";
				}else if(	"DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				}else{
					sCnvtFromEventSystem	= "";
				}
				//::by TOP:2015-05-08:://
				
				// VVD Delete
				//::by TOP:2015-05-08:://removeCstSkdByVvd(activationVvdVO1s);		//original
				
				//::by TOP:2015-05-08:://
				// VVD Delete
				if(activationVvdVO1s != null)	this.removeCstSkdByVvd(activationVvdVO1s, account, sCnvtFromEventSystem, "NoBKG");
				////hmVskVslSkdVOs.put("DELETE_DeletionVvd_NoneBKG", vskVslSkdVOs);
				//::by TOP:2015-05-08:://
				
			// in case SKD with Booking
			}else{
				
				for(int i=0; activationVvdVO1s!=null && i<activationVvdVO1s.length; i++){
					ActivationVvdVO vo = activationVvdVO1s[i];
					if(vo==null) continue;
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				
				//::by TOP:2015-05-08:://
				if(			"DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)";
				}else if(	"DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054)";
				}else if(	"DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)"			.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)";
				}else if(	"DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)";
				}else if(	"DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				}else{
					sCnvtFromEventSystem	= "";
				}
				//::by TOP:2015-05-08:://
				
				
				// Booking��嫄몃젮�덈뒗 �딅뒗 VVD Delete
				if(activationVvdVO1s != null)	this.removeCstSkdByVvd(activationVvdVO1s, account, sCnvtFromEventSystem, "OnBKG");
				////hmVskVslSkdVOs.put("DELETE_DeletionVvd_NoneBKG", vskVslSkdVOs);
				
				
				for(int i=0; activationVvdVO2s!=null && i<activationVvdVO2s.length; i++){
					ActivationVvdVO vo = activationVvdVO2s[i];
					if(vo==null) continue;
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				
				if(			"DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_DeletedGroupVVD_OnBKG(VOP_VSK_0010)";
				}else if(	"DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_LRS_Feeder_DeletedGroupVVD_OnBKG(VOP_VSK_0054)";
				}else if(	"DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)"			.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_OnBKG(VOP_VSK_0018)";
				}else if(	"DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)"		.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_Feeder_DeletionVvd_OnBKG(VOP_VSK_0059)";
				}else if(	"DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)"	.equals(sFromEventSystem)){
					sCnvtFromEventSystem	= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				}else{
					sCnvtFromEventSystem	= "";
				}
				
				// Booking��嫄몃젮�덈뒗 VVD Delete
				if(activationVvdVO2s != null)	this.removeCstSkdByVvd(activationVvdVO2s, vskVslSkdHisVO, sFromEventSystem);
				////hmVskVslSkdVOs.put("DELETE_DeletionVvd_OnBKG", vskVslSkdVOs2);
				
				// Deleting in case SKD without Booking
				//::by TOP:2015-05-08:://removeCstSkdByVvd(activationVvdVO1s);
				
				// Deleting in case SKD with Booking
				//::by TOP:2015-05-08:://removeCstSkdByVvd(activationVvdVO2s, vskVslSkdHisVO);
				
			}
			
		} catch (EventException e) {
			log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
	}
	
	/**
	 * Deletion SKD
	 * 
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @exception EventException
	 */
	//::by TOP:2015-05-08:://private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs) throws EventException {
	private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account, String sFromEventSystem, String attachBkgFlag) throws EventException {
		
		/********************************************** 
		 * attachBkgFlag indicator
		 * ===========================================
		 * 1. "OnBKG"	: VVD taken BKGs
		 * 2. "NoBKG"	: VVD without BKGs
		 * ===========================================
		 */
		if(activationVvdVOs==null || activationVvdVOs.length==0){
			return;
		}
		
		try{
			
			for(int i=0; i<activationVvdVOs.length; i++){
				
				// null means SKD with Booking
				if(activationVvdVOs[i]==null) continue;
				VvdVO paramVO = new VvdVO();
				paramVO.setVslCd	(activationVvdVOs[i].getVslCd		());
				paramVO.setSkdVoyNo	(activationVvdVOs[i].getSkdVoyNo	());
				paramVO.setSkdDirCd	(activationVvdVOs[i].getSkdDirCd	());
				//paramVO.setPfSkdTpCd(activationVvdVOs[i].getPfSvcTpCd	());
				paramVO.setPfSkdTpCd(activationVvdVOs[i].getPfSkdTpCd	());
				
				paramVO.setVslSlanCd(activationVvdVOs[i].getVslSlanCd	());
                paramVO.setActCrrCd	(activationVvdVOs[i].getActCrrCd	());
				
				//Retrieving Pre-VVD, Next-VVD
				List<VvdVO> rePreNextVoList = new ArrayList<VvdVO>();
				//one pre row and one next row are return
				rePreNextVoList = dbDao.searchConnectVvd(paramVO);
				
				/** VO for removing empty VVD : 2015-10-28 : by TOP **/
				VvdVO paramEmptyVvdVO = new VvdVO();
				
				//k == 0, delete pre row and make history . k ==1 , next row update
				for(int k=0; k<rePreNextVoList.size(); k++){
					String tempTurnCd = rePreNextVoList.get(k).getTurnPortIndCd();
					
					if(tempTurnCd.equals("N") || tempTurnCd.equals("Y")){
						// :: VIPS START ::
						// System.out.println("VIPS[removeVskVslPortSkdByPreVvd1]");
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						VvdVO vvdVO = rePreNextVoList.get(k);
						vo.setVslCd(vvdVO.getVslCd());
						vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
						vo.setSkdDirCd(vvdVO.getSkdDirCd());
//						vo.setTurnSkdVoyNo(vvdVO.getTurnSkdVoyNo());
//						vo.setTurnSkdDirCd(vvdVO.getTurnSkdDirCd());
                        
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
						// :: VIPS END ::
						dbDao.removeVskVslPortSkdByPreVvd(rePreNextVoList.get(k));
						
						paramEmptyVvdVO.setVslCd		(rePreNextVoList.get(k).getVslCd		());
						paramEmptyVvdVO.setSkdVoyNo		(rePreNextVoList.get(k).getSkdVoyNo		());
						paramEmptyVvdVO.setSkdDirCd		(rePreNextVoList.get(k).getSkdDirCd		());
						paramEmptyVvdVO.setTurnSkdVoyNo	(rePreNextVoList.get(k).getTurnSkdVoyNo	());
						paramEmptyVvdVO.setTurnSkdDirCd	(rePreNextVoList.get(k).getTurnSkdDirCd	());
						

					}else if(tempTurnCd.equals("D") || tempTurnCd.equals("V") || tempTurnCd.equals("F")){
						dbDao.modifyVskVslPortSkdNextTurnPort (rePreNextVoList.get(k));
						// :: VIPS START ::
						// System.out.println("VIPS[modifyVskVslPortSkdNextTurnPort1]");
						VvdVO vvdVO = rePreNextVoList.get(k);
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vvdVO.getVslCd());
						vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
						vo.setSkdDirCd(vvdVO.getSkdDirCd());
						vo.setTurnSkdVoyNo(vvdVO.getTurnSkdVoyNo());
						vo.setTurnSkdDirCd(vvdVO.getTurnSkdDirCd());
                        
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
						// :: VIPS END ::

					}	
				}
				
				//Retrieving Pre-VVD, Next-VVD from SWAP_CST_PORT
				//List<VvdVO> rePreNextCstVoList = new ArrayList<VvdVO>();
				//one pre row and one next row are return
				//rePreNextCstVoList = dbDao.searchConnectVvdSim(paramVO);
				
				//for(int l = 0; l < rePreNextCstVoList.size(); l++){
				//	String tempCstTurnCd = rePreNextCstVoList.get(l).getTurnPortIndCd();
				//	if(tempCstTurnCd.equals("N") || tempCstTurnCd.equals("Y")){
						////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstPortByPreVvd(rePreNextCstVoList.get(l));
						
//						===================================================================================
				//		VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
				//		vskSwapCstPortVO.setVslCd(rePreNextCstVoList.get(l).getVslCd());
				//		vskSwapCstPortVO.setSkdVoyNo(rePreNextCstVoList.get(l).getSkdVoyNo());
				//		vskSwapCstPortVO.setSkdDirCd(rePreNextCstVoList.get(l).getSkdDirCd());
						////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstPort(vskSwapCstPortVO);
//						===================================================================================
				//	}
					//else if(tempCstTurnCd.equals("D") || tempCstTurnCd.equals("V") || tempCstTurnCd.equals("F")){
						////::2015-05-13:by TOP:NO Need::////dbDao.modifyVskSwapCstPort (rePreNextCstVoList.get(l));
					//}
				//}
				
				//SIM_DT,SIM_NO 
				//List<VskSwapCstSimVO> reCstSimVoList = new ArrayList<VskSwapCstSimVO>();
				//reCstSimVoList = dbDao.searchSimNoVskSwapCstVvd(paramVO);
				
//				===================================================================================
				VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
				vskSwapCstVvdVO.setVslCd		(paramVO.getVslCd	());
				vskSwapCstVvdVO.setSkdVoyNo		(paramVO.getSkdVoyNo());
				vskSwapCstVvdVO.setSkdDirCd		(paramVO.getSkdDirCd());
				
				////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstVvd(vskSwapCstVvdVO);
//				===================================================================================
				////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstRmk (paramVO);
				
				//int cnt = 0;
				//for(int m=0; m < reCstSimVoList.size(); m++){
				//	cnt = dbDao.searchVskSwapCstVvdCount(reCstSimVoList.get(i));
				//	if(cnt == 0){
						////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstSim(reCstSimVoList.get(i));
				//	}
				//}
				// :: VIPS START ::
				// System.out.println("VIPS[removeVskVslPortSkdByVvd1]");
				VskVslPortSkdVO vo = new VskVslPortSkdVO();
				VvdVO vvdVO = paramVO;
				vo.setVslCd(vvdVO.getVslCd());
				vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
				vo.setSkdDirCd(vvdVO.getSkdDirCd());
                
				List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
				for(VskVslPortSkdVO row : list) {
					this.mVslPortSkdList.add(row);
				}
                
				// :: VIPS END ::
                
				dbDao.removeVskVslPortSkdByVvd(paramVO);
				
				if(attachBkgFlag != null && "NoBKG".equals(attachBkgFlag)){
					
					//::by TOP:2015-05-08:://
					List<VslSkdXtraHisVO> vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
					VslSkdXtraHisVO	tmpVO	= new VslSkdXtraHisVO();
					tmpVO.setVskdTpCd		("M");						/** 'M':VVD Schedule, 'P':Port Schedule **/
					tmpVO.setVskdCngTpCd	("D");						/** 'D':VVD Deletion					**/
					tmpVO.setBkgAtchFlg		("N");
					tmpVO.setBfrVslSlanCd	(paramVO.getVslSlanCd	());
					tmpVO.setBfrVslCd		(paramVO.getVslCd		());
					tmpVO.setBfrSkdVoyNo	(paramVO.getSkdVoyNo	());
					tmpVO.setBfrSkdDirCd	(paramVO.getSkdDirCd	());
					
					tmpVO.setBfrPfSvcTpCd	(paramVO.getPfSkdTpCd	());
                    tmpVO.setBfrActCrrCd	(paramVO.getActCrrCd	());
					
					tmpVO.setUpdUsrId		(account.getUsr_id		());
					vslSkdXtraHisVOs.add	(tmpVO);
					
					/*** :: Deleted VVD���대젰�곗씠���앹꽦濡쒖쭅異붽� ::
					 * 		TABLE NAME	: VSK_VSL_SKD_HIS + VSK_VSL_SKD_CNG_HIS
					 * 		濡쒖쭅異붽��쇱옄	: 2013-06-18
					 * 		List<VskVslSkdVO> vskVslSkdVOs
					 ***/
                     
					this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, sFromEventSystem);	
					//::by TOP:2015-05-08:://		
					
				}else{
					
					//::by TOP:2015-05-24:://
					List<VslSkdXtraHisVO> vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
					VslSkdXtraHisVO	tmpVO	= new VslSkdXtraHisVO();
					tmpVO.setVskdTpCd		("M");						/** 'M':VVD Schedule, 'P':Port Schedule **/
					tmpVO.setVskdCngTpCd	("D");						/** 'D':VVD Deletion					**/
					tmpVO.setBkgAtchFlg		("Y");
					tmpVO.setBfrVslSlanCd	(paramVO.getVslSlanCd	());
					tmpVO.setBfrVslCd		(paramVO.getVslCd		());
					tmpVO.setBfrSkdVoyNo	(paramVO.getSkdVoyNo	());
					tmpVO.setBfrSkdDirCd	(paramVO.getSkdDirCd	());
					
					tmpVO.setBfrPfSvcTpCd	(paramVO.getPfSkdTpCd	());
                    tmpVO.setBfrActCrrCd	(paramVO.getActCrrCd	());
					
					tmpVO.setUpdUsrId		(account.getUsr_id		());
					vslSkdXtraHisVOs.add	(tmpVO);
					
					/*** :: Deleted VVD���대젰�곗씠���앹꽦濡쒖쭅異붽� ::
					 * 		TABLE NAME	: VSK_VSL_SKD_HIS + VSK_VSL_SKD_CNG_HIS
					 * 		濡쒖쭅異붽��쇱옄	: 2013-06-18
					 * 		List<VskVslSkdVO> vskVslSkdVOs
					 ***/
                     
					this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, sFromEventSystem);	
					//::by TOP:2015-05-24:://	
				}

				
				dbDao.removeVskVslSkdByVvd		(paramVO);
				
				/** Removing empty VVD which consists of only virtual port after deleting virtual port of previous VVD : 2015-10-28 : by TOP **/
				dbDao.removeVskVslSkdByEmptyVvd	(paramEmptyVvdVO);
				
				/////////////////////////////////////////////////////////////////////////////
				//VskVslSkdHisVO vskVslSkdDelHisVO = new VskVslSkdHisVO();
				//vskVslSkdDelHisVO.setBfrVslSlanCd(activationVvdVOs[i].getVslSlanCd());
				//vskVslSkdDelHisVO.setBfrVslCd(activationVvdVOs[i].getVslCd());
				//vskVslSkdDelHisVO.setBfrSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
				//vskVslSkdDelHisVO.setBfrSkdDirCd(activationVvdVOs[i].getSkdDirCd());
				//vskVslSkdDelHisVO.setCreUsrId(activationVvdVOs[i].getCreUsrId());
				//vskVslSkdDelHisVO.setUpdUsrId(activationVvdVOs[i].getUpdUsrId());
				
				//addVskVslSkdDelHis(vskVslSkdDelHisVO);
				/////////////////////////////////////////////////////////////////////////////
				
			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
		
	}
	
	/**
	 * Deleting SKD and Creating History 
	 * 
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @exception EventException
	 */
	//::by TOP:2015-05-08:://private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs, VskVslSkdHisVO vskVslSkdHisVO) throws EventException {
	private void removeCstSkdByVvd(ActivationVvdVO[] activationVvdVOs, VskVslSkdHisVO vskVslSkdHisVO, String sFromEventSystem) throws EventException {
		
		if(activationVvdVOs==null || activationVvdVOs.length==0){
			return;
		}
		
		try{
			
			for(int i=0; i<activationVvdVOs.length; i++){
				
				// null means SKD with Booking
				if(activationVvdVOs[i]==null) continue;

				vskVslSkdHisVO.setBfrVslSlanCd	(activationVvdVOs[i].getVslSlanCd());
				vskVslSkdHisVO.setBfrVslCd		(activationVvdVOs[i].getVslCd());
				vskVslSkdHisVO.setBfrSkdVoyNo	(activationVvdVOs[i].getSkdVoyNo());
				vskVslSkdHisVO.setBfrSkdDirCd	(activationVvdVOs[i].getSkdDirCd());
				vskVslSkdHisVO.setVskdTpCd		("M");
				vskVslSkdHisVO.setVskdCngTpCd	("D");
				vskVslSkdHisVO.setBkgAtchFlg	("Y");
				vskVslSkdHisVO.setCreUsrId		(activationVvdVOs[i].getCreUsrId());
				vskVslSkdHisVO.setUpdUsrId		(activationVvdVOs[i].getCreUsrId());
                
                vskVslSkdHisVO.setBfrActCrrCd	(activationVvdVOs[i].getActCrrCd());
				//vskVslSkdHisVO.setBfrPfSkdTpCd	(activationVvdVOs[i].getPfSkdTpCd());
				vskVslSkdHisVO.setBfrPfSkdTpCd	(activationVvdVOs[i].getPfSkdTpCd());
				
				VvdVO paramVO = new VvdVO();
				paramVO.setVslCd(activationVvdVOs[i].getVslCd());
				paramVO.setSkdVoyNo(activationVvdVOs[i].getSkdVoyNo());
				paramVO.setSkdDirCd(activationVvdVOs[i].getSkdDirCd());
				
				//Retrieving Pre-VVD, Next-VVD
				List<VvdVO> rePreNextVoList = new ArrayList<VvdVO>();
				//one pre row and one next row are return
				rePreNextVoList = dbDao.searchConnectVvd(paramVO);
				
				//k == 0, delete pre row and make history . k ==1 , next row update
				for(int k=0; k<rePreNextVoList.size(); k++){
					String tempTurnCd = rePreNextVoList.get(k).getTurnPortIndCd();
					
					if(tempTurnCd.equals("N") || tempTurnCd.equals("Y")){
						
						// Virtual Port with Booking : "VIR"
						// VVD, Virtual Port are with Booking : "ALL":
						// making history
						if("VIR".equals(activationVvdVOs[i].getHisflag()) || "ALL".equals(activationVvdVOs[i].getHisflag())){
							List<VskVslSkdHisVO> podYardList = new ArrayList<VskVslSkdHisVO>();
							podYardList = dbDao.checkPreVvdBkgPodYard(rePreNextVoList.get(k));
							if(podYardList.size() != 0){
								for(int j=0; j < podYardList.size(); j++){
									VskVslSkdHisVO hisVO = podYardList.get(j);
									hisVO.setVskdTpCd		("M");
									hisVO.setVskdCngTpCd	("D");
									hisVO.setBkgAtchFlg		("Y");
									hisVO.setCreUsrId		(activationVvdVOs[i].getCreUsrId());
									hisVO.setUpdUsrId		(activationVvdVOs[i].getCreUsrId());
									hisVO.setAftVslSlanCd	(vskVslSkdHisVO.getAftVslSlanCd());
									hisVO.setAftVslCd		(vskVslSkdHisVO.getAftVslCd());
									hisVO.setAftSkdVoyNo	(vskVslSkdHisVO.getAftSkdVoyNo());
									hisVO.setAftSkdDirCd	(vskVslSkdHisVO.getAftSkdDirCd());
									hisVO.setAftVpsPortCd	(vskVslSkdHisVO.getAftVpsPortCd());
									hisVO.setAftClptIndSeq	(vskVslSkdHisVO.getAftClptIndSeq());
									
									String tempRemark = vskVslSkdHisVO.getDiffRmk() 
																+ "/Deleted Virtual Port by Turning Port["
																+ activationVvdVOs[i].getVslCd()
																+ activationVvdVOs[i].getSkdVoyNo()
																+ activationVvdVOs[i].getSkdDirCd()+ "]";
									hisVO.setDiffRmk(tempRemark);
									dbDao.addVslSkdHis(hisVO);
                                    
								}
							}
						}
                        
						// :: VIPS START ::
						// System.out.println("VIPS[removeVskVslPortSkdByPreVvd2]");
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						VvdVO vvdVO = rePreNextVoList.get(k);
						vo.setVslCd(vvdVO.getVslCd());
						vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
						vo.setSkdDirCd(vvdVO.getSkdDirCd());
//						vo.setTurnSkdVoyNo(vvdVO.getTurnSkdVoyNo());
//						vo.setTurnSkdDirCd(vvdVO.getTurnSkdDirCd());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
						// :: VIPS END ::
						dbDao.removeVskVslPortSkdByPreVvd(rePreNextVoList.get(k));

					}else if(tempTurnCd.equals("D") || tempTurnCd.equals("V") || tempTurnCd.equals("F")){
						dbDao.modifyVskVslPortSkdNextTurnPort (rePreNextVoList.get(k));
						// :: VIPS START ::
						// System.out.println("VIPS[modifyVskVslPortSkdNextTurnPort2]");
						VvdVO vvdVO = rePreNextVoList.get(k);
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vvdVO.getVslCd());
						vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
						vo.setSkdDirCd(vvdVO.getSkdDirCd());
//						vo.setTurnSkdVoyNo(vvdVO.getTurnSkdVoyNo());
//						vo.setTurnSkdDirCd(vvdVO.getTurnSkdDirCd());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
						// :: VIPS END ::
					}	
				}
				
				//Creating history in case of current VVD with Booking
				if("VVD".equals(activationVvdVOs[i].getHisflag()) || "ALL".equals(activationVvdVOs[i].getHisflag())){
					dbDao.addVslSkdHis(vskVslSkdHisVO);
				}
				
				//Retrieving Pre-VVD, Next-VVD from SWAP_CST_PORT
				//List<VvdVO> rePreNextCstVoList = new ArrayList<VvdVO>();
				//one pre row and one next row are return
				//rePreNextCstVoList = dbDao.searchConnectVvdSim(paramVO);
				
				//for(int l = 0; l < rePreNextCstVoList.size(); l++){
				//	String tempCstTurnCd = rePreNextCstVoList.get(l).getTurnPortIndCd();
				//	if(tempCstTurnCd.equals("N") || tempCstTurnCd.equals("Y")){
						////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstPortByPreVvd(rePreNextCstVoList.get(l));
						
//						===================================================================================
				//		VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
				//		vskSwapCstPortVO.setVslCd(rePreNextCstVoList.get(l).getVslCd());
				//		vskSwapCstPortVO.setSkdVoyNo(rePreNextCstVoList.get(l).getSkdVoyNo());
				//		vskSwapCstPortVO.setSkdDirCd(rePreNextCstVoList.get(l).getSkdDirCd());
						////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstPort(vskSwapCstPortVO);
//						===================================================================================
				//	}
					//else if(tempCstTurnCd.equals("D") || tempCstTurnCd.equals("V") || tempCstTurnCd.equals("F")){
						////::2015-05-13:by TOP:NO Need::////dbDao.modifyVskSwapCstPort (rePreNextCstVoList.get(l));
					//}
				//}
				
				//SIM_DT,SIM_NO
				//List<VskSwapCstSimVO> reCstSimVoList = new ArrayList<VskSwapCstSimVO>();
				//reCstSimVoList = dbDao.searchSimNoVskSwapCstVvd(paramVO);
				
//				===================================================================================
				VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
				vskSwapCstVvdVO.setVslCd(paramVO.getVslCd());
				vskSwapCstVvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
				vskSwapCstVvdVO.setSkdDirCd(paramVO.getSkdDirCd());
				////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstVvd(vskSwapCstVvdVO);
//				===================================================================================
				////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstRmk (paramVO);
				
				//int cnt = 0;
				//for(int m=0; m < reCstSimVoList.size(); m++){
				//	cnt = dbDao.searchVskSwapCstVvdCount(reCstSimVoList.get(i));
				//	if(cnt == 0){
						////::2015-05-13:by TOP:NO Need::////dbDao.removeVskSwapCstSim(reCstSimVoList.get(i));
				//	}
				//}
				// :: VIPS START ::
				// System.out.println("VIPS[removeVskVslPortSkdByVvd2]");
				VskVslPortSkdVO vo = new VskVslPortSkdVO();
				VvdVO vvdVO = paramVO;
				vo.setVslCd(vvdVO.getVslCd());
				vo.setSkdVoyNo(vvdVO.getSkdVoyNo());
				vo.setSkdDirCd(vvdVO.getSkdDirCd());
                
				List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
                
				for(VskVslPortSkdVO row : list) {
					this.mVslPortSkdList.add(row);
				}
				// :: VIPS END ::
				dbDao.removeVskVslPortSkdByVvd(paramVO);
				
				dbDao.removeVskVslSkdByVvd(paramVO);
				
				VskVslSkdHisVO vskVslSkdDelHisVO 	= new VskVslSkdHisVO();
				
				//::2015-05-24::///////////////////////////////////////////////////////////////
				vskVslSkdDelHisVO.setVskdTpCd		("M");
				vskVslSkdDelHisVO.setVskdCngTpCd	("D");
				vskVslSkdDelHisVO.setBkgAtchFlg		("Y");
				///////////////////////////////////////////////////////////////////////////////
				
				vskVslSkdDelHisVO.setBfrVslSlanCd	(vskVslSkdHisVO.getBfrVslSlanCd());
				vskVslSkdDelHisVO.setBfrVslCd		(vskVslSkdHisVO.getBfrVslCd());
				vskVslSkdDelHisVO.setBfrSkdVoyNo	(vskVslSkdHisVO.getBfrSkdVoyNo());
				vskVslSkdDelHisVO.setBfrSkdDirCd	(vskVslSkdHisVO.getBfrSkdDirCd());
				vskVslSkdDelHisVO.setCreUsrId		(vskVslSkdHisVO.getCreUsrId());
				
				vskVslSkdDelHisVO.setBfrPfSvcTpCd	(vskVslSkdHisVO.getBfrPfSvcTpCd());
				
				vskVslSkdDelHisVO.setUpdUsrId		(vskVslSkdHisVO.getUpdUsrId());
				
				this.addVskVslSkdDelHis				(vskVslSkdDelHisVO);
                
                //:ADDING VESSEL SCHEDULE OVERALL HISTORY://
				List<VslSkdXtraHisVO> vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
				VslSkdXtraHisVO	tmpVO	= new VslSkdXtraHisVO();
				
				tmpVO.setHisSaveKndCd	("O");		/** 'B':BOTH, 'A':After-Before History Only, 'O':Overall History Only **/
				
				tmpVO.setVskdTpCd		("M");		/** 'M':VVD Schedule, 'P':Port Schedule **/
				tmpVO.setVskdCngTpCd	("D");		/** 'D':VVD Deletion					**/
				tmpVO.setBkgAtchFlg		("Y");
				tmpVO.setBfrVslSlanCd	(vskVslSkdHisVO.getBfrVslSlanCd	());
				tmpVO.setBfrVslCd		(vskVslSkdHisVO.getBfrVslCd		());
				tmpVO.setBfrSkdVoyNo	(vskVslSkdHisVO.getBfrSkdVoyNo	());
				tmpVO.setBfrSkdDirCd	(vskVslSkdHisVO.getBfrSkdDirCd	());
				
				tmpVO.setBfrPfSvcTpCd	(vskVslSkdHisVO.getBfrPfSkdTpCd	());
				tmpVO.setBfrActCrrCd	(vskVslSkdHisVO.getBfrActCrrCd	());
				
				tmpVO.setUpdUsrId		(vskVslSkdHisVO.getUpdUsrId		());
				vslSkdXtraHisVOs.add	(tmpVO);
				
				/*** :: Deleted VVD���대젰�곗씠���앹꽦濡쒖쭅異붽� ::
				 * 		TABLE NAME	: VSK_VSL_SKD_HIS + VSK_VSL_SKD_CNG_HIS
				 * 		濡쒖쭅異붽��쇱옄	: 2013-06-18
				 * 		List<VskVslSkdVO> vskVslSkdVOs
				 ***/
				
				this.createVesselScheduleExtraChangeHistory			(vslSkdXtraHisVOs, sFromEventSystem);
				//:ADDING VESSEL SCHEDULE OVERALL HISTORY://
				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		} catch (EventException ex){
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), de);
		}
		
	}
	
	/**
	 * Checking P/F usint LRS simulation
	 * 
	 * @param PfSkdVO[] pfSkdVOs
	 * @exception EventException
	 */
//	private void validatePfSkd(PfSkdVO[] pfSkdVOs) throws EventException {
//		{ // Checking etbDyNo, etdDyNo are increasing
//			int dyNo = Integer.parseInt(pfSkdVOs[0].getEtbDyNo());
//			for(PfSkdVO vo : pfSkdVOs){
//				if(dyNo <= Integer.parseInt(vo.getEtbDyNo())){
//					dyNo = Integer.parseInt(vo.getEtbDyNo());
//				}else{
//					throw new EventException(new ErrorHandler("VSK10050").getMessage());
//				}
//				if(dyNo <= Integer.parseInt(vo.getEtdDyNo())){
//					dyNo = Integer.parseInt(vo.getEtdDyNo());
//				}else{
//					throw new EventException(new ErrorHandler("VSK10050").getMessage());
//				}
//			}
//		}
//	}

	/**
	 * Simulating Long Range Schedule 
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	public List<LongRangeSkdVO> simulateLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException {
		
		try {
			List<String[]> vslInfo = longRangeSkdGRPVO.getVslInfo();
			String endDate = longRangeSkdGRPVO.getEndDate().replaceAll("-", "");
			
			PfSkdVO[] pfSkdVOS = longRangeSkdGRPVO.getPfSkdVOs();
			String voyNoType   = longRangeSkdGRPVO.getVoyNoType();
			String svcDurDys   = longRangeSkdGRPVO.getSvcDurDys();
			int iSvcDurDys     = VSKGeneralUtil.getCheckNullToString(svcDurDys).equals("")?0:Math.round(Float.parseFloat(svcDurDys));
			//int iSvcDurDys     = VSKGeneralUtil.getCheckNullToString(svcDurDys).equals("")?0:Integer.parseInt(svcDurDys);
			
			String vslCount = longRangeSkdGRPVO.getVslCount();
			int iVslCount = VSKGeneralUtil.getCheckNullToString(vslCount).equals("")?0:Integer.parseInt(vslCount);
			
			String voyTypeCnt = longRangeSkdGRPVO.getVoyTypeCnt();
			int iVoyTypeCnt = VSKGeneralUtil.getCheckNullToString(voyTypeCnt).equals("")?0:Integer.parseInt(voyTypeCnt);
			
			//validatePfSkd(pfSkdVOS);
	      
			List<LongRangeSkdVO> list = null;
	
			if ("btn_Simulation".equals(longRangeSkdGRPVO.getOpType())) { // simulation
				list = getSimSkd(pfSkdVOS, vslInfo, endDate, 0, voyNoType, iSvcDurDys, iVslCount);
			}  else if ("btn_SimulationMultiple".equals(longRangeSkdGRPVO.getOpType())) { // simulation - Long Range SKD
//				list = getSimSkd(pfSkdVOS, vslInfo, endDate, 0, voyNoType, iSvcDurDys, iVslCount);
				list = this.getSimSkdMultiple(pfSkdVOS, vslInfo, endDate, 0, voyNoType, iSvcDurDys, iVslCount, iVoyTypeCnt);
				
			} else if ("btn_PhaseIn".equals(longRangeSkdGRPVO.getOpType())) { // phase in
				
				
				list = new ArrayList<LongRangeSkdVO>();
				int phaseInPort = Integer.parseInt(longRangeSkdGRPVO.getPhaseinCol()) - 1;
				
				List<String[]> phaseInVslInfo = new ArrayList<String[]>();
				String[] phaseinVslInfo = new String[]{
						longRangeSkdGRPVO.getPhaseinStartDate(),
						longRangeSkdGRPVO.getPhaseinVslCd(),
						longRangeSkdGRPVO.getPhaseinVoyNo()
				};
				phaseInVslInfo.add(phaseinVslInfo);
	
				// Creating SKD with PhaseIn. backup origin vessel list
				List<String[]> orgVslInfo = longRangeSkdGRPVO.getVslInfo();
				longRangeSkdGRPVO.setVslInfo(phaseInVslInfo);
				List<LongRangeSkdVO> phaseInVOList = getSimSkd(pfSkdVOS, phaseInVslInfo, endDate, phaseInPort, voyNoType, iSvcDurDys, iVslCount);
				
				List<LongRangeSkdVO> srcList = loadSimDataList(longRangeSkdGRPVO, 0, 0, null, false);
				
				longRangeSkdGRPVO.setVslInfo(orgVslInfo);
				
				////////////////////////////////
				
				List<List<LongRangeSkdVO>> skdSplitList = new ArrayList<List<LongRangeSkdVO>>();
				List<List<LongRangeSkdVO>> phaseInSplitList = new ArrayList<List<LongRangeSkdVO>>();
				List<List<LongRangeSkdVO>> finalList = new ArrayList<List<LongRangeSkdVO>>();
				
				int pos = 0;
				for(int i=0; i<srcList.size(); i++){
					// split
					if(srcList.get(i).getVslCd()==null){
						skdSplitList.add(srcList.subList(pos, i));
						pos = i+1;
					}
				}
				
				pos = 0;
				for(int i=0; i<phaseInVOList.size(); i++){
					// split
					if(phaseInVOList.get(i).getVslCd()==null){
						phaseInSplitList.add(phaseInVOList.subList(pos, i));
						pos = i+1;
					}
				}
				
				
				List<String[]> vslInfos = longRangeSkdGRPVO.getVslInfo();
				int m = 0;
				int k = 0;
		
				while(m!=skdSplitList.size() || k!=phaseInSplitList.size()){
					if(
							!"0".equals(longRangeSkdGRPVO.getPhaseinRow()) && // simple phase in, srcList is null
							m<Integer.parseInt(longRangeSkdGRPVO.getPhaseinRow())+3){ // showing selected phasein row + hidden 3row in advance
						finalList.add(skdSplitList.get(m++));
					}else{
						if(k<phaseInSplitList.size()){
							finalList.add(phaseInSplitList.get(k++));
							finalList.add(phaseInSplitList.get(k++));
							finalList.add(phaseInSplitList.get(k++));
							finalList.add(phaseInSplitList.get(k++));
						}
						for(int i=0; i<vslInfos.size()*4;i++){
							if(m<skdSplitList.size()){
								finalList.add(skdSplitList.get(m++));
							}
						}
					}
				}
				
				for(int i=0; i<finalList.size(); i++){
					List<LongRangeSkdVO> fList = finalList.get(i);
					for(int j=0; j<fList.size(); j++){
						list.add(fList.get(j));
					}
					list.add(new LongRangeSkdVO());
				}
				
				
			} else if ("btn_AddCall".equals(longRangeSkdGRPVO.getOpType())) { // add call
				int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
				
				String addCallPosition = longRangeSkdGRPVO.getAddCallPosition();
				if("before".equals(addCallPosition)){
					addCallPos = addCallPos + 0; 
				}else if("after".equals(addCallPosition)){
					addCallPos = addCallPos + 1;
				}
				
				int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());			
				String addPortCd = longRangeSkdGRPVO.getAddCallPortCd();
				String etb = longRangeSkdGRPVO.getAddCallEtb();
				String etd = longRangeSkdGRPVO.getAddCallEtd();
				
				LongRangeSkdVO addCallVo = new LongRangeSkdVO();
				addCallVo.setPortCd(addPortCd);
				
				addCallVo.setEtbDyCd("");
				addCallVo.setInitEtbDay("");
				addCallVo.setInitEtbDay("");
				addCallVo.setInitEtbDate(etb);
						
				addCallVo.setEtdDyCd("");
				addCallVo.setInitEtdDay("");
				addCallVo.setInitEtdDay("");
				addCallVo.setInitEtdDate(etd);
				
				list = loadSimDataList(longRangeSkdGRPVO, addCallPos, addVvdPos, addCallVo, false);
			} else if ("btn_AddCallCancel".equals(longRangeSkdGRPVO.getOpType())) { // add call cancel
				
				int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
				int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());
				
				list = loadSimDataList(longRangeSkdGRPVO, addCallPos, addVvdPos, null, true);
			}

			return list;
			
		} catch (EventException e) {
			log.error("err " + e.toString(), e);
			throw e;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}

	}
	
	/**
	 * Creating basic simulation information
	 * 
	 * @param PfSkdVO[] pfSkdVOs
	 * @param List<String[]> vslValues
	 * @param String endDate
	 * @param int initPortPos
	 * @param String voyNoType
	 * @param int iSvcDurDys
	 * @param int iVslCount
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	private List<LongRangeSkdVO> getSimSkdMultiple(PfSkdVO[] pfSkdVOs, List<String[]> vslValues, String endDate, int initPortPos, String voyNoType, int iSvcDurDys, int iVslCount, int iVoyTypeCnt) throws EventException {
		
		try {
			
			List<LongRangeSkdVO> skdlist = new ArrayList<LongRangeSkdVO>();
			
			String[] vslCd 		= new String[vslValues.size()];
			String[] voyNo 		= new String[vslValues.size()];
			String[] startDate 	= new String[vslValues.size()];
			String[] standDate 	= new String[vslValues.size()];
			
			String[] pfSvcTpCd 	= new String[vslValues.size()];
			int[] svcDurDys 	= new int[vslValues.size()];
			
			boolean[] validDate = new boolean[vslValues.size()];
			Arrays.fill(validDate, true);
			
			int i = 0;
			int m = 0;
			
			// in case ETB_DY_NO of P/F is starting 0, increasing 1 to ETB_DY_NO, ETD_DY_NO
			if("0".equals(pfSkdVOs[0].getEtbDyNo())){
				for(int k=0; k<pfSkdVOs.length; k++){				
					pfSkdVOs[k].setEtbDyNo(Integer.toString(Integer.parseInt(pfSkdVOs[k].getEtbDyNo())+1));
					pfSkdVOs[k].setEtdDyNo(Integer.toString(Integer.parseInt(pfSkdVOs[k].getEtdDyNo())+1));
				}
			}
			
			Map<String, String> pfSvcTpCdMap = new HashMap<String, String>();
			
			for(String[] array : vslValues){
				pfSvcTpCdMap.put(array[1]+array[0], array[3]);				
				startDate[i] = array[m++].replaceAll("-", "");
				vslCd[i] = array[m++];
				voyNo[i] = array[m++];
				
				pfSvcTpCd[i] = array[m++];
				
				i++;
				m=0;
			}
			
			/*
				voyNoType
				
				0 : Normal
				1 : Direction (ADD One)
				2 : Sequence
			*/
		 	//voyNoType = (voyNoType==null || voyNoType=="")?"0":voyNoType;   
		 	voyNoType = (voyNoType==null || "".compareTo(voyNoType)==0) ? "0" : voyNoType;
			int iVoyNoType = Integer.parseInt(voyNoType);
			
			/* in case of sequence, if VSL_COUNT is 0 then use inputted vessel count */
//			if(iVoyNoType==2 && iVslCount==0){
			if(iVoyNoType==2){
				iVslCount = vslValues.size();
			}
			
			PfSkdVO pfSkdVO = null;
			LongRangeSkdVO skdVO = null;
			LongRangeSkdVO dummy = new LongRangeSkdVO();
			
			pfSkdVO = pfSkdVOs[0];
			
			String etb = null;
			String etd = null;
			
			// VVD-3	
			String vvd3 = null;
//			if(pfSkdVO.getSkdDirCd().equals(pfSkdVOs[pfSkdVOs.length-1].getSkdDirCd())){
//				vvd3 = pfSkdVO.getSkdDirCd();
//			}else{
//				vvd3 = pfSkdVO.getSkdDirCd() + "/" + pfSkdVOs[pfSkdVOs.length-1].getSkdDirCd();
//			}
			String 	sSheetObjNo 	= "";		
			String 	sPfSvcTpCd 		= "";		
			
			// Start Port
			PfSkdVO initPort 		= null;
			int 	initPortDyNo 	= 0;
			
			int 	iSheetObjNo 	= 0;
			int 	iPortSeq 		= 1;
			
//			String firstDirCd = pfSkdVO.getSkdDirCd();
//			boolean oneWayDirCd = true;						
//			for(PfSkdVO vo : pfSkdVOs){
//				if(firstDirCd.equals(vo.getSkdDirCd())){
//					continue;
//				}else{
//					oneWayDirCd = false; // P/F is made up 2 Directions
//					break;
//				}
//			}
			
			Map<String, Boolean> 	oneWayDirMap 	= new HashMap<String, Boolean>();
			Map<String, Integer> 	portSeqMap 		= new HashMap<String, Integer>();
			
			String 					tmpDirCd 		= pfSkdVO.getSkdDirCd();
			String 					tmpPfSvcTpCd 	= pfSkdVO.getPfSvcTpCd();
			boolean 				boolPfSvcTpCd 	= true;
			
			for(PfSkdVO vo : pfSkdVOs){				
				oneWayDirMap.put(vo.getPfSvcTpCd(), true);
			}
			
			for(PfSkdVO vo : pfSkdVOs){
				if(tmpPfSvcTpCd.equals(vo.getPfSvcTpCd()) && !tmpDirCd.equals(vo.getSkdDirCd())){
					oneWayDirMap.put(vo.getPfSvcTpCd(), false);
				}
				tmpDirCd = vo.getSkdDirCd();
				tmpPfSvcTpCd = vo.getPfSvcTpCd();
			}
			
			tmpPfSvcTpCd = pfSkdVO.getPfSvcTpCd();
			
			for(PfSkdVO vo : pfSkdVOs){
				
				if(!tmpPfSvcTpCd.equals(vo.getPfSvcTpCd())){
					boolPfSvcTpCd = false;
				}
				tmpPfSvcTpCd = vo.getPfSvcTpCd();
				
				iSheetObjNo  = (vo.getSheetObjNo() == null || "".equals(vo.getSheetObjNo())) ? 0 : Integer.parseInt(vo.getSheetObjNo());
				
				portSeqMap.put(Integer.toString(iSheetObjNo), iPortSeq);
				iPortSeq++;
				
			}
			
			PfSkdVO pfSkdVO_0	= pfSkdVOs[0];
			int 	iEtbDyNo 	= 0;
			
			for(i=0; true; i++){
				
				int pos = i%vslCd.length;
				
				if(VSKGeneralUtil.isFinish(validDate)){
					break;
				}					
				//if(!"Y".equals(pfSkdVO.getMrgFlg())){
					if(!validDate[pos]){
						continue;
					}
				//}

				/**
				 * 2013-10-25 Multiple 
				 * DIR 
				 */				
				vvd3 = "";
				for(int h=0 ; h<pfSkdVOs.length ; h++){					
					if(pfSvcTpCd[pos].equals(pfSkdVOs[h].getPfSvcTpCd())){
						if(!"".equals(vvd3) && !vvd3.equals(pfSkdVOs[h].getSkdDirCd())){
							vvd3 = vvd3 + "/" + pfSkdVOs[h].getSkdDirCd();
							break;
						}
						vvd3 = pfSkdVOs[h].getSkdDirCd();
						//svcDurDys[pos] = Math.round(Float.parseFloat(pfSkdVOs[h].getSvcDurDys()));
						svcDurDys[pos] = (int) Math.ceil(Double.parseDouble(pfSkdVOs[h].getSvcDurDys()));
					}
				}
				
				
				if(standDate[pos]==null){
					standDate[pos] = startDate[pos];
				}
				// setting first port when first vvd create.
				if(i==0){
					initPort = pfSkdVOs[initPortPos];
				}else{
					initPort = pfSkdVOs[0];
				}
				initPortDyNo = Integer.parseInt(initPort.getEtbDyNo());
				
				pfSkdVO_0 = pfSkdVOs[0];
				iEtbDyNo = 0;
				
				// for DB (PF, INIT, VPS - 3 row), for temp (4th row). i.e., showing row in screen is row of k=0, others are hidden
				for(int k=0; k<4; k++){
					
					////////////////////////////////////////////////////////
					
					////////////////////////////////////////////////////////
					
					for(m=0; m<pfSkdVOs.length; m++){

						pfSkdVO = pfSkdVOs[m];	
						
						//portSeqMap 
						if(vslCd.length==3 && iSheetObjNo==1){
							if(!boolPfSvcTpCd){
								portSeqMap.put("1", pfSkdVOs.length/3);
								portSeqMap.put("2", pfSkdVOs.length*2/3);
								portSeqMap.put("3", pfSkdVOs.length);
//							
							}
							
						}else if(vslCd.length==2 && iSheetObjNo==1){
							if(!boolPfSvcTpCd){
								portSeqMap.put("1", pfSkdVOs.length/2);
								portSeqMap.put("2", pfSkdVOs.length);
//							
							}
						}
//						LongRangeSkdVO
						skdVO = new LongRangeSkdVO();
						
						if(vslCd[pos]==null || vslCd[pos].length()==0){
							continue;
						}
						skdVO.setVslCd(vslCd[pos]);
						
						if(iVoyNoType==0){
							skdVO.setVoyNo(VSKGeneralUtil.getVoyNo(voyNo[pos]));
						}else if(iVoyNoType==1){
							String voyNo1 = VSKGeneralUtil.getVoyNo(voyNo[pos]);
							String voyNo2 = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
							//oneWayDir
							if(oneWayDirMap.get(pfSvcTpCdMap.get(vslCd[pos]+startDate[pos]))){
								skdVO.setVoyNo(voyNo1);
							}else{
								skdVO.setVoyNo(voyNo1 + "/" + voyNo2);
							}
						}else if(iVoyNoType==2){
							skdVO.setVoyNo(VSKGeneralUtil.getVoyNo(voyNo[pos]));
						}
						skdVO.setSkdDirCd(vvd3);
						
						// choosing first port when first vvd create.
						
						
						if(i==0 && m<initPortPos){
							skdVO.setPortCd(pfSkdVO.getPortCd());
							skdVO.setEtbDyCd(pfSkdVO.getEtbDyCd());
							skdVO.setEtdDyCd(pfSkdVO.getEtdDyCd());
							
							skdVO.setInitEtbDate("");
							skdVO.setInitEtbDay(pfSkdVO.getEtbDyCd());
							
							skdVO.setInitEtdDate("");
							skdVO.setInitEtdDay(pfSkdVO.getEtdDyCd());
														
						}else{
							
							if(pfSvcTpCd[pos].equals(pfSkdVO.getPfSvcTpCd())){
	
								skdVO.setPortCd(pfSkdVO.getPortCd());
								skdVO.setEtbDyCd(pfSkdVO.getEtbDyCd());
								skdVO.setEtdDyCd(pfSkdVO.getEtdDyCd());
								
								// Setting ETB of first simulation with P/F
								etb = VSKGeneralUtil.getActionDate(standDate[pos], (Integer.parseInt(pfSkdVO.getEtbDyNo())-initPortDyNo));
								if(k!=3){
									skdVO.setInitEtbDay(VSKGeneralUtil.getDay(etb));
									skdVO.setInitEtbDate(etb + pfSkdVO.getEtbTmHrmnt());
								}
								/* 2013-12-02  */
								
									// Setting ETD of first simulation with P/F
								etd = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVO.getEtdDyNo()) - initPortDyNo);
								
 								/**/
								if(k!=3){
									skdVO.setInitEtdDay(VSKGeneralUtil.getDay(etd));
									skdVO.setInitEtdDate(etd + pfSkdVO.getEtdTmHrmnt());
								}
								//Sheet 
								sSheetObjNo = (pfSkdVO.getSheetObjNo() == null || "".equals(pfSkdVO.getSheetObjNo())) ? "0" : pfSkdVO.getSheetObjNo();
								
								sPfSvcTpCd = pfSkdVO.getPfSvcTpCd();
								
								skdVO.setSheetObjNo	(sSheetObjNo);
								skdVO.setPfSvcTpCd	(sPfSvcTpCd);
								
								log.info("*********************************************");
								log.info("pfSvcTpCd[pos]=" + pfSvcTpCd[pos] + "  pos=" + pos + "   K=" + k + "  sSheetObjNo=" + sSheetObjNo + " sPfSvcTpCd=" + sPfSvcTpCd);
								log.info("skdVO=" + skdVO.getVslCd());
								log.info("day="   + skdVO.getInitEtdDay());
								log.info("etb="   + skdVO.getInitEtbDate());
								log.info("etd="   + skdVO.getInitEtdDate());
								log.info("*********************************************");
								//log.info("sSheetObjNo =" + pfSkdVO.getSheetObjNo() + "pfSvcTpCd[pos]:"+pfSvcTpCd[pos]+"/pfSkdVO.getPfSvcTpCd():"+pfSkdVO.getPfSvcTpCd());
								
								skdlist.add(skdVO);
								
							}else{
								
								if(iVoyNoType==2 && pos+1<vslCd.length && vslCd[pos].equals(vslCd[pos+1])){
									if(vslCd.length==3 && iSheetObjNo>2 && m==portSeqMap.get("2")-1){
										iEtbDyNo = Integer.parseInt(pfSkdVO.getEtbDyNo())-1;
									}else if(vslCd.length==3 && m==portSeqMap.get("1")-1){
										iEtbDyNo = Integer.parseInt(pfSkdVO.getEtbDyNo())-1;
									}
								}
							}
						}
						
//						skdlist.add(skdVO);
						
					}					
					//if(!"Y".equals(pfSkdVO.getMrgFlg())){
					if(		etb.compareTo(endDate) 		>= 0 
						&&	pfSkdVO.getTurnPortIndCd() 	!= null
						&&	"F".equals(pfSkdVO.getTurnPortIndCd()))
					{
						//:2016-05-06:by TOP://
						skdlist.remove(skdlist.size()-1);							
					}
//					}else{
//						if(pos==vslCd.length-1 && etb.compareTo(endDate)>=0){
//							skdlist.remove(skdlist.size()-1);
//						}
					//}
					
			
					dummy = new LongRangeSkdVO();
					dummy.setSheetObjNo	(sSheetObjNo);
					dummy.setPfSvcTpCd	(sPfSvcTpCd);	
					skdlist.add			(dummy);	
					
				}

//				log.info("##voyNo[pos]:"+voyNo[pos]+"/pos:"+pos+"/etb:"+etb+"/iEtbDyNo:"+iEtbDyNo+"/pfSkdVO.getEtbDyNo():"+pfSkdVO.getEtbDyNo()+"/standDate[pos]:"+standDate[pos]);
				
				if(iVoyNoType==0){
//					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], iVoyTypeCnt);
				}else if(iVoyNoType==1){
//					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], 2);
//					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], iVoyTypeCnt);
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], (iVoyTypeCnt+1));
				}else if(iVoyNoType==2){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], iVslCount*iVoyTypeCnt);
				}
				
//				if(oneWayDirCd){
				if(oneWayDirMap.get(pfSvcTpCdMap.get(vslCd[pos]+startDate[pos]))){
//					standDate[pos] = VSKGeneralUtil.getActionDate(standDate[pos], iSvcDurDys);
					standDate[pos] = VSKGeneralUtil.getActionDate(standDate[pos], svcDurDys[pos]);
				}else{
					if(pos+1<vslCd.length){		
						if(iVoyNoType==2 && vslCd[pos].equals(vslCd[pos+1]) ){
							standDate[pos] = VSKGeneralUtil.getActionDate(etb, iEtbDyNo+Integer.parseInt(pfSkdVO.getEtbDyNo())-1);
							standDate[pos+1] = etb;
						}else{
							standDate[pos] = etb;
						}
					}else{
						standDate[pos] = etb;
					}
				}
				if(standDate[pos].compareTo(endDate)>=0){
					validDate[pos] = false;
				}
				//log.info("pos:"+pos+"/etb:"+etb+"/standDate[pos]:"+standDate[pos]);
			}
			
			return skdlist;
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}
		
	}
	
	/**
	 * Loading UI Simulation
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @param int addCallPos
	 * @param int addVvdPos
	 * @param LongRangeSkdVO addPort
	 * @param boolean addCancel
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	private List<LongRangeSkdVO> loadSimDataList(
			LongRangeSkdGRPVO longRangeSkdGRPVO,
			int addCallPos,
			int addVvdPos,
			LongRangeSkdVO addPort,
			boolean addCancel) throws EventException {
		
		try {
			
			PfSkdVO[] pfSkdVOs = longRangeSkdGRPVO.getPfSkdVOs();
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1();
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2();
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3();
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4();
			
			Map<String, String[]> simInfoMap = longRangeSkdGRPVO.getSimInfoMap();
			
			String[] titles1 = headTitle1.split("\\|");
			String[] titles2 = headTitle2.split("\\|");
			String[] titles3 = headTitle3.split("\\|");
			String[] titles4 = headTitle4.split("\\|");
			
			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles1.length)
			))
			{
				// in case header lengths are different
				throw new EventException(new ErrorHandler("VSK10039").getMessage());			
			}
			
			// Setting CLPT_IND_SEQ, CLPT_SEQ, CALL_YD_IND_SEQ

			// ---------- Step1. PfSkdVO list creation start ----------
			
			// Adding Header to PF
			List<PfSkdVO> pfSkdList = new ArrayList<PfSkdVO>();
			for(int i=1,k=0; i<titles1.length; i=i+2){
				PfSkdVO pfSkdVO = pfSkdVOs[k];
				if(titles2[i].equals(pfSkdVO.getPortCd())){
					pfSkdList.add(pfSkdVO);
					k++;
				}else{
					// Creating PfSkdVO using title
					PfSkdVO vo = new PfSkdVO();
					vo.setPortCd(titles2[i]);
					vo.setSkdDirCd(titles1[i]);
					pfSkdList.add(vo);
				}
			}
			
			// ---------- Step1. PfSkdVO list creation END ----------
			
			// ---------- Step2. Changing Simulation info of screen to Vessel list ----------
			
			String[] vvd1 = longRangeSkdGRPVO.getVVD1();
			String[] vvd2 = longRangeSkdGRPVO.getVVD2();
			String[] vvd3 = longRangeSkdGRPVO.getVVD3();
			
			List<LongRangeSkdVO> skdList 	= new ArrayList<LongRangeSkdVO>(); // �붾㈃ �ㅼ�伊��뺣낫
			List<LongRangeSkdVO> tmpList 	= new ArrayList<LongRangeSkdVO>();
			
			String initEtbDate 				= null;
			String initEtbDay 				= null;
			String initEtdDate 				= null;
			String initEtdDay 				= null;
			
			LongRangeSkdVO dummy = new LongRangeSkdVO();
			LongRangeSkdVO empty = null;
			
			String uiFormat = "MM/ddyyyyHHmm";
			String dataFormat = "yyyyMMddHHmm";
			
			//in case of p/in, no simulation then vvd1/vvd2/vvd3 can null
			for(int m=0; vvd1!=null && m<vvd1.length; m++){
				
				empty = new LongRangeSkdVO();
				if(!addCancel && addPort!=null){
					empty.setPortCd(addPort.getPortCd());
					empty.setEtbDyCd("");
					empty.setEtdDyCd("");
					empty.setInitEtbDay("");
					empty.setInitEtdDay("");
				}
				
				if(vvd1[m].equals(longRangeSkdGRPVO.getPhaseinVslCd())){
					continue;
				}
				
				tmpList.clear();
				
				for(int k=0; k<pfSkdList.size(); k++){
					
					if(addCancel && k==addCallPos-1){
						continue;
					}
					
					LongRangeSkdVO skdVo = new LongRangeSkdVO();
					PfSkdVO pfSkdVO = pfSkdList.get(k);
					
					skdVo.setVslCd(vvd1[m]);
					skdVo.setVoyNo(vvd2[m]);
					skdVo.setSkdDirCd(vvd3[m]);
					skdVo.setPortCd(pfSkdVO.getPortCd());
					
					boolean skip = false;
					
					if(m!=0 && (m+1)%4==0){
						initEtbDate = simInfoMap.get("ETB" + k)[m];
						initEtdDate = simInfoMap.get("ETD" + k)[m];
						
						if("SKIP".equals(initEtbDate.trim())){
							skip = true;
						}
						
						if("SKIP".equals(initEtdDate.trim())){
							skip = true;
						}
						
						if(!skip){
							skdVo.setInitEtbDate(initEtbDate);
							skdVo.setInitEtdDate(initEtdDate);
						}else{
							skdVo.setSkip(true);
						}
						
					}else{
						skdVo.setEtbDyCd(pfSkdVO.getEtbDyCd());
						skdVo.setEtdDyCd(pfSkdVO.getEtdDyCd());
						
						initEtbDate = simInfoMap.get("ETB" + k)[m];
						initEtdDate = simInfoMap.get("ETD" + k)[m];
						
						if("SKIP".equals(initEtbDate.trim())){
							skip = true;
						}
						
						if("SKIP".equals(initEtdDate.trim())){
							skip = true;
						}
						
						if(!skip){
							initEtbDate = VSKGeneralUtil.changeDateFormat(initEtbDate, uiFormat, dataFormat);
							initEtdDate = VSKGeneralUtil.changeDateFormat(initEtdDate, uiFormat, dataFormat);
							
							initEtbDay = VSKGeneralUtil.getDay(initEtbDate);
							initEtdDay = VSKGeneralUtil.getDay(initEtdDate);
							
							skdVo.setInitEtbDate(initEtbDate);
							skdVo.setInitEtdDate(initEtdDate);
							skdVo.setInitEtbDay(initEtbDay);
							skdVo.setInitEtdDay(initEtdDay);
						}else{
							skdVo.setSkip(true);
						}
					}
					
					tmpList.add(skdVo);
					
				}
				
				tmpList.add(dummy);
				if(!addCancel && addPort!=null){
					
					if(m==addVvdPos){
						// Copying VVD of First port for in case add port is first row
						LongRangeSkdVO firstPort = tmpList.get(0);
						addPort.setVslCd(firstPort.getVslCd());
						addPort.setVoyNo(firstPort.getVoyNo());
						addPort.setSkdDirCd(firstPort.getSkdDirCd());
						addPort.setSkdCngStsCd("A");
						tmpList.add(addCallPos-1, addPort);
					}else{
						// Copying VVD of First port for in case add port is first row
						LongRangeSkdVO firstPort = tmpList.get(0);
						empty.setVslCd(firstPort.getVslCd());
						empty.setVoyNo(firstPort.getVoyNo());
						empty.setSkdDirCd(firstPort.getSkdDirCd());
						tmpList.add(addCallPos-1, empty);
					}
					
				}
	 			skdList.addAll(tmpList);
			}
			
			return skdList;
				
			// ---------- Step2. Changing Simulation info of screen to Vessel list END ----------
			
		} catch (EventException e) {
			throw e;			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}
		
	}

	/**
	 * Creating basic simulation information
	 * 
	 * @param PfSkdVO[] pfSkdVOs
	 * @param List<String[]> vslValues
	 * @param String endDate
	 * @param int initPortPos
	 * @param String voyNoType
	 * @param int iSvcDurDys
	 * @param int iVslCount
	 * @return List<LongRangeSkdVO>
	 * @exception EventException
	 */
	private List<LongRangeSkdVO> getSimSkd(PfSkdVO[] pfSkdVOs, List<String[]> vslValues, String endDate, int initPortPos, String voyNoType, int iSvcDurDys, int iVslCount) throws EventException {
		
		try {
			
			List<LongRangeSkdVO> skdlist = new ArrayList<LongRangeSkdVO>();
			
			String[] vslCd = new String[vslValues.size()];
			String[] voyNo = new String[vslValues.size()];
			String[] startDate = new String[vslValues.size()];
			String[] standDate = new String[vslValues.size()];
			boolean[] validDate = new boolean[vslValues.size()];
			Arrays.fill(validDate, true);
			
			int i = 0;
			int m = 0;
			
			// in case ETB_DY_NO of P/F is starting 0, increasing 1 to ETB_DY_NO, ETD_DY_NO
			if("0".equals(pfSkdVOs[0].getEtbDyNo())){
				for(int k=0; k<pfSkdVOs.length; k++){
					pfSkdVOs[k].setEtbDyNo(Integer.toString(Integer.parseInt(pfSkdVOs[k].getEtbDyNo())+1));
					pfSkdVOs[k].setEtdDyNo(Integer.toString(Integer.parseInt(pfSkdVOs[k].getEtdDyNo())+1));
				}
			}
			
			for(String[] array : vslValues){
				startDate[i] = array[m++].replaceAll("-", "");
				vslCd[i] = array[m++];
				voyNo[i] = array[m++];
				
				i++;
				m=0;	
			}
			
			/*
				voyNoType
				0 : Normal
				1 : Direction (ADD One)
				2 : Sequence
			*/
		 	//voyNoType = (voyNoType==null || voyNoType=="")?"0":voyNoType;   
		 	voyNoType = (voyNoType==null || "".compareTo(voyNoType)==0) ? "0" : voyNoType;
			int iVoyNoType = Integer.parseInt(voyNoType);
			
			/* in case of sequence, if VSL_COUNT is 0 then use inputted vessel count */
			if(iVoyNoType==2 && iVslCount==0){
				iVslCount = vslValues.size();
			}
			
			PfSkdVO pfSkdVO = null;
			LongRangeSkdVO skdVO = null;
			LongRangeSkdVO dummy = new LongRangeSkdVO();
			
			pfSkdVO = pfSkdVOs[0];
			
			String etb = null;
			String etd = null;
			
			// VVD-3
			String vvd3 = null;
			if(pfSkdVO.getSkdDirCd().equals(pfSkdVOs[pfSkdVOs.length-1].getSkdDirCd())){
				vvd3 = pfSkdVO.getSkdDirCd();
			}else{
				vvd3 = pfSkdVO.getSkdDirCd() + "/" + pfSkdVOs[pfSkdVOs.length-1].getSkdDirCd();
			}
			
			// Start Port
			PfSkdVO initPort = null;
			int initPortDyNo = 0;
			
			String firstDirCd = pfSkdVO.getSkdDirCd();
			boolean oneWayDirCd = true;
			for(PfSkdVO vo : pfSkdVOs){
				if(firstDirCd.equals(vo.getSkdDirCd())){
					continue;
				}else{
					oneWayDirCd = false; // P/F is made up 2 Directions
					break;
				}
			}
			
			 for(i=0; true; i++){
				
				int pos = i%vslCd.length;
				
				if(VSKGeneralUtil.isFinish(validDate)){
					break;
				}
				
				if(!validDate[pos]){
					continue;
				}
				
				if(standDate[pos]==null){
					standDate[pos] = startDate[pos];
				}
				
				// setting first port when first vvd create.
				if(i==0){
					initPort = pfSkdVOs[initPortPos];
				}else{
					initPort = pfSkdVOs[0];
				}
				initPortDyNo = Integer.parseInt(initPort.getEtbDyNo());
				
				// for DB (PF, INIT, VPS - 3 row), for temp (4th row). i.e., showing row in screen is row of k=0, others are hidden
				for(int k=0; k<4; k++){
					for(m=0; m<pfSkdVOs.length; m++){
						
						pfSkdVO = pfSkdVOs[m];
						
//						 LongRangeSkdVO
						skdVO = new LongRangeSkdVO();
						
						if(vslCd[pos]==null || vslCd[pos].length()==0){
							continue;
						}
						
						skdVO.setVslCd(vslCd[pos]);
						if(iVoyNoType==0){
							skdVO.setVoyNo(VSKGeneralUtil.getVoyNo(voyNo[pos]));
						}else if(iVoyNoType==1){
							String voyNo1 = VSKGeneralUtil.getVoyNo(voyNo[pos]);
							String voyNo2 = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
							skdVO.setVoyNo(voyNo1 + "/" + voyNo2);
						}else if(iVoyNoType==2){
							skdVO.setVoyNo(VSKGeneralUtil.getVoyNo(voyNo[pos]));
						}
						skdVO.setSkdDirCd(vvd3);
						
						// choosing first port when first vvd create.
						if(i==0 && m<initPortPos){
							
							skdVO.setPortCd(pfSkdVO.getPortCd());
							skdVO.setEtbDyCd(pfSkdVO.getEtbDyCd());
							skdVO.setEtdDyCd(pfSkdVO.getEtdDyCd());
							
							skdVO.setInitEtbDate("");
							skdVO.setInitEtbDay(pfSkdVO.getEtbDyCd());
							
							skdVO.setInitEtdDate("");
							skdVO.setInitEtdDay(pfSkdVO.getEtdDyCd());
							
						}else{
						
							skdVO.setPortCd(pfSkdVO.getPortCd());
							skdVO.setEtbDyCd(pfSkdVO.getEtbDyCd());
							skdVO.setEtdDyCd(pfSkdVO.getEtdDyCd());
							
							// Setting ETB of first simulation with P/F
							etb = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVO.getEtbDyNo()) - initPortDyNo);
							if(k!=3){
								skdVO.setInitEtbDay(VSKGeneralUtil.getDay(etb));
								skdVO.setInitEtbDate(etb + pfSkdVO.getEtbTmHrmnt());
							}
							
							// Setting ETD of first simulation with P/F
							etd = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVO.getEtdDyNo()) - initPortDyNo);
							if(k!=3){
								skdVO.setInitEtdDay(VSKGeneralUtil.getDay(etd));
								skdVO.setInitEtdDate(etd + pfSkdVO.getEtdTmHrmnt());
							}
						
						}
						
						skdlist.add(skdVO);
					}
					
					if(etb.compareTo(endDate)>=0){
						skdlist.remove(skdlist.size()-1);
					}
					
					skdlist.add(dummy);	
				}
				
				if(iVoyNoType==0){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], 1);
				}else if(iVoyNoType==1){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], 2);
				}else if(iVoyNoType==2){
					voyNo[pos] = VSKGeneralUtil.nextVoyNo(voyNo[pos], iVslCount);
				}
				
				if(oneWayDirCd){
					//standDate[pos] = VSKGeneralUtil.getActionDate(standDate[pos], Integer.parseInt(pfSkdVOs[pfSkdVOs.length-1].getEtbDyNo()));
					standDate[pos] = VSKGeneralUtil.getActionDate(standDate[pos], iSvcDurDys);
				}else{
					standDate[pos] = etb;
				}
				
				if(standDate[pos].compareTo(endDate)>=0){
					validDate[pos] = false;
				}
				
			}
			
			return skdlist;
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), de);
		}
		
	}
	
	/**
	 * Creating LongRangeSchedule
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkd(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException {
		
		try {
			
			PfSkdVO[] pfSkdVOs = longRangeSkdGRPVO.getPfSkdVOs();
			Map<String, MdmVslCntrVO> vesselVOs = new HashMap<String, MdmVslCntrVO>();
			String[] skdRmk = longRangeSkdGRPVO.getSkdRmk();
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1(); // SKD_DIR_CD
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2(); // VPS_PORT_CD
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3(); // ETB_DY_NO/ETD_DY_NO
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			String headTitle5 = longRangeSkdGRPVO.getHeadTitle5(); // CLPT_SEQ
			String headTitle6 = longRangeSkdGRPVO.getHeadTitle6(); // YD_CD
			
			boolean oneWayDir = true;
			
			Map<String, String[]> simInfo = longRangeSkdGRPVO.getSimInfoMap();
			
			String[] titles1 = headTitle1.split("\\|");
			String[] titles2 = headTitle2.split("\\|");
			String[] titles3 = headTitle3.split("\\|");
			String[] titles4 = headTitle4.split("\\|");
			String[] titles5 = headTitle5.split("\\|");
			String[] titles6 = headTitle6.split("\\|");
			
			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles5.length)
					&& (titles5.length==titles6.length)
			))
			{
				// in case Header lengths are different, Exception
				throw new EventException(new ErrorHandler("VSK10039").getMessage());			
			}
			
			
			// Setting CLPT_IND_SEQ, CLPT_SEQ, CALL_YD_IND_SEQ
	
			// ---------- Step1. PfSkdVO list creation start  ----------
			
			String beforeDir = null;
			// Adding Header to PF
			List<PfSkdVO> pfSkdList = new ArrayList<PfSkdVO>();
			for(int i=1,k=0; i<titles1.length; i=i+2){
				PfSkdVO pfSkdVO = pfSkdVOs[k];
				
				// if direction of now and p/f are different, this PF construct with 2 direction
				if(oneWayDir && beforeDir!=null && !pfSkdVO.getSkdDirCd().equals(beforeDir)){
					oneWayDir = false;
				}
				beforeDir = pfSkdVO.getSkdDirCd();
				
				if(pfSkdVOs[k].getTurnPortIndCd()==null || "".equals(pfSkdVOs[k].getTurnPortIndCd())){
					pfSkdVOs[k].setTurnPortIndCd("N");
				}
				
				if(titles2[i].equals(pfSkdVO.getPortCd())){
					pfSkdList.add(pfSkdVO);
					k++;
				}else{
					// Creating PfSkdVO using title
					PfSkdVO vo = new PfSkdVO();
					vo.setPortCd(titles2[i]);
					vo.setSkdDirCd(titles1[i]);
					vo.setYdCd(titles6[i]);
					vo.setVslSlanCd(longRangeSkdGRPVO.getVslSlanCd());
					vo.setVslSvcTpCd(longRangeSkdGRPVO.getVslSvcTpCd());
					vo.setTurnPortIndCd("N");
					
					pfSkdList.add(vo);
				}
			}
			// ---------- Step1. PfSkdVO list creation END ----------
			
			
			// ---------- Step2. Changing Simulation info of screen to Vessel list ----------
			Map<String, List<VskSwapCstPortVO>> skdByVsl = new HashMap<String, List<VskSwapCstPortVO>>();
			{	
				String[] vvd1 = longRangeSkdGRPVO.getVVD1();
				String[] vvd2 = longRangeSkdGRPVO.getVVD2();
				String[] vvd2_1 = new String[vvd2.length];
				String[] vvd2_2 = new String[vvd2.length];
				
				//VskSwapCstPortVO skdVO = null;
				PfSkdVO pfSkdVO = null;
				
				String skdCngStsCd = null;
				String uiFormat = "MM/ddyyyyHHmm";
				String dataFormat = "yyyyMMddHHmm";
				
				// 4 rows are information of one VVD
				for(int m=0; m<vvd1.length; m=m+4){
					
					if( vvd1[m].length() >0 ){
					// no save in case of Phase Out VVD
					if(longRangeSkdGRPVO.getPOutFlag()!=null && longRangeSkdGRPVO.getPOutFlag()[m]!=null && longRangeSkdGRPVO.getPOutFlag()[m].length()!=0){
						continue;
					}
					
					for(int k=0; k<pfSkdList.size(); k++){
						
						VskSwapCstPortVO skdVO = new VskSwapCstPortVO();
						pfSkdVO = pfSkdList.get(k);
						
						skdVO.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
						skdVO.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
						
						skdVO.setVslCd(vvd1[m]);
						skdVO.setSkdDirCd(pfSkdVO.getSkdDirCd());
						
						if(!vesselVOs.containsKey(vvd1[m])){
							vesselVOs.put(vvd1[m], dbDao.searchMdmVslCntr(vvd1[m]));
						}
						
						if(vvd2[m].length()>4){
							vvd2_1[m] = vvd2[m].substring(0, 4);
							vvd2_2[m] = vvd2[m].substring(5, 9);
							
							if(skdVO.getSkdDirCd().equals(pfSkdList.get(0).getSkdDirCd())){
								skdVO.setSkdVoyNo(vvd2_1[m]);
							}else if(skdVO.getSkdDirCd().equals(pfSkdList.get(pfSkdList.size()-1).getSkdDirCd())){
								skdVO.setSkdVoyNo(vvd2_2[m]);
							}
							
						}else{
							skdVO.setSkdVoyNo(vvd2[m]);	
						}
						
						skdVO.setVpsPortCd(pfSkdVO.getPortCd());
						skdVO.setSlanCd(pfSkdVO.getVslSlanCd());
						skdVO.setYdCd(pfSkdVO.getYdCd());
						skdVO.setTurnPortFlg(pfSkdVO.getTurnPortFlg());
						skdVO.setTurnPortIndCd(pfSkdVO.getTurnPortIndCd());
						
						skdVO.setSeaBufHrs(pfSkdVO.getSeaBufHrs());
						skdVO.setPortBufHrs(pfSkdVO.getPortBufHrs());
						
						// Initializing CLPT_IND_SEQ, CALL_YD_IND_SEQ = 1
						skdVO.setClptIndSeq("1");
						skdVO.setCallYdIndSeq("1");
	
						// Setting PF_ET, INIT_ET, VPS_ET
						// 
						// in case of SKIP port
						// m+1 : INIT_ET
						// m+2 : PF_ET
						// m+3 : VPS_ET
						//
						// in case of no SKIP port
						// m : VPS_ET
						// m+1 : INIT_ET
						// m+2 : PF_ET
						// m+3 : SKD_CNG_STS_CD
						
						// m+1(common)
						skdVO.setInitEtbDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m+1], uiFormat, dataFormat));
						skdVO.setInitEtdDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m+1], uiFormat, dataFormat));
						skdVO.setInitEtaDt(
								getETA(skdVO.getInitEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
						
						// m+2(common)
						skdVO.setPfEtbDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m+2], uiFormat, dataFormat));
						skdVO.setPfEtdDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m+2], uiFormat, dataFormat));
						skdVO.setPfEtaDt(
								getETA(skdVO.getPfEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
	
						
						if("SKIP".equals(simInfo.get("ETB" + k)[m])){
							// in case of SKIP port
							// m+3 : VPS_ET
							skdCngStsCd = "S";
							
							skdVO.setVpsEtbDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m+3], uiFormat, dataFormat));
							skdVO.setVpsEtdDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m+3], uiFormat, dataFormat));
							skdVO.setVpsEtaDt(
									getETA(skdVO.getVpsEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
							
						}else{
							// in case of no SKIP port
							// m : VPS_ET
							// m+3 : SKD_CNG_STS_CD
							skdCngStsCd = "";
							skdVO.setVpsEtbDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + k)[m], uiFormat, dataFormat));
							skdVO.setVpsEtdDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + k)[m], uiFormat, dataFormat));
							skdVO.setVpsEtaDt(
									getETA(skdVO.getVpsEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
							
							skdCngStsCd = simInfo.get("ETD" + k)[m+3];
							
							// Add Call, TURN_PORT_FLG = "N"
							if("A".equals(skdCngStsCd)){
								skdVO.setTurnPortFlg("N");
							}
							
							if(skdCngStsCd.startsWith("O:")){
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2));
								skdCngStsCd = "O";
							}
							
							if(skdCngStsCd.startsWith("I:")){
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2));
								skdCngStsCd = "I";
							}
							
						}
						
						// Add Call, Retrieving and Setting PORT_BUF_HRS
						if("A".equals(skdCngStsCd)){
							String portBufHrs = dbDao.searchPortBufHrs(skdVO.getVpsPortCd());
							skdVO.setPortBufHrs(portBufHrs);
						}
						
						/*
						 * A : Add / R : Reverse / S : Skip / C : Change / I : Phase In / O : Phase Out
						 */
						//kjh 2014 UI媛쒖꽑 �묒뾽..
						//�곗씠�곌� 湲몄뼱��諛�┝ �꾩긽��諛⑹� �섍린 �꾪빐 ARSCIO��寃쎌슦瑜��쒖쇅��寃쎌슦��媛뺤죺濡�null setting
						if( skdCngStsCd.equals("A") || skdCngStsCd.equals("R") || skdCngStsCd.equals("I")||skdCngStsCd.equals("S")||skdCngStsCd.equals("C")||skdCngStsCd.equals("O")){
						skdVO.setSkdCngStsCd(skdCngStsCd);
						}else{
							skdVO.setSkdCngStsCd("");
						}
						
						// Creating SKD per Vessel
						List<VskSwapCstPortVO> list = skdByVsl.get(skdVO.getVslCd());
						if(list==null){
							list = new ArrayList<VskSwapCstPortVO>();
						}
						list.add(skdVO);
						skdByVsl.put(skdVO.getVslCd(), list);
						
					}
				}
				}
			}
			// ---------- Step2. Changing Simulation info of screen to Vessel list END ----------
			
			
			// ---------- Step3. Changing list include Virtual Port ----------
			List<VskSwapCstPortVO> currVVD = new ArrayList<VskSwapCstPortVO>();
			List<VskSwapCstPortVO> prevVVD = new ArrayList<VskSwapCstPortVO>();
			
			// list include Virtual Port
			List<VskSwapCstPortVO> portSkdList = new ArrayList<VskSwapCstPortVO>();
			
			for(Iterator<List<VskSwapCstPortVO>> i = skdByVsl.values().iterator(); i.hasNext();){
				
				// by Step 2
				List<VskSwapCstPortVO> list = i.next();
				
				/*
				
				First VVD does not create virtual port in LRS Creation
				
				*/
				
				String firstVoyNo = null;
				String firstDirCd = null;
				String prevDirCd = null;
				
				for(int m=0; m<list.size();){
					
					// roof per count of port list 
					for(int k=0; m<list.size() && k<pfSkdList.size(); k++){
						VskSwapCstPortVO skdVO = list.get(m++);
	
						if("".equals(skdVO.getVpsEtbDt())){
							continue;
						}
						
						// in case of PF with one way direction, virtual is not necessary
						if(oneWayDir){
                            skdVO.setTurnPortFlg("N");
							addPortSkd(skdVO, currVVD);
							continue;
						}
	
						// first VVD
						if(firstVoyNo==null && firstDirCd==null){
							firstVoyNo = skdVO.getSkdVoyNo();
							firstDirCd = skdVO.getSkdDirCd();
							prevDirCd = firstDirCd;
						}
						
						// use first VVD
						if("I".equals(skdVO.getSkdCngStsCd())){
							firstVoyNo = skdVO.getSkdVoyNo();
							firstDirCd = skdVO.getSkdDirCd();
						}
						
						if(!skdVO.getSkdDirCd().equals(prevDirCd)){
							portSkdList.addAll(prevVVD);
							prevVVD.clear();
							prevVVD.addAll(currVVD);
							currVVD.clear();
						}
						
						skdVO = addPortSkd(skdVO, currVVD);
						
						if(firstVoyNo.equals(skdVO.getSkdVoyNo()) && firstDirCd.equals(skdVO.getSkdDirCd())){
							skdVO.setTurnPortFlg("N");
							skdVO.setTurnPortIndCd("N");
						}
						
						// Adding Vistual Port SKD to pre VVD List when First VVD SKD is not
						if(!(firstVoyNo.equals(skdVO.getSkdVoyNo()) && firstDirCd.equals(skdVO.getSkdDirCd()))){
							// After Virtual Port Managing, get turning information
							skdVO = addVirtualPortSkd(skdVO, prevVVD);
							
							// updating port skd with include Turning info
							currVVD.set(currVVD.size()-1, skdVO);
						}
						
						prevDirCd = skdVO.getSkdDirCd();
	
					}
					
					if(oneWayDir){
						portSkdList.addAll(prevVVD);
						prevVVD.clear();
						prevVVD.addAll(currVVD);
						currVVD.clear();
					}
					
				}
				
				// prevVVD, currVVD-last row- include result lost
				portSkdList.addAll(prevVVD);
				prevVVD.clear();
				portSkdList.addAll(currVVD);
				currVVD.clear();
				
			}
			// ---------- Step3. Changing list include Virtual Port END ----------
			
	
			// ---------- Step4. Selecting data to save VSK_VSL_SKD START ----------
			List<VskSwapCstVvdVO> vslSkdList = new ArrayList<VskSwapCstVvdVO>();
			Map<String, String> keyMap = new HashMap<String, String>();
			String key = null;
			
			for(VskSwapCstPortVO portSkdVO : portSkdList){
				
				String startPortCd = null;
				String firstPortBerthDate = null;
				
				key = portSkdVO.getVslCd() + ":" + portSkdVO.getSkdVoyNo() + ":" + portSkdVO.getSkdDirCd();
				
				// because VVD is key in VSK_VSL_SKD, then pick up one data per VVD
				if(keyMap.containsKey(key)){
					continue;
				}else{
					keyMap.put(key, key);
					startPortCd = portSkdVO.getVpsPortCd();
					firstPortBerthDate = portSkdVO.getVpsEtbDt();
				}
				
				VskSwapCstVvdVO vslSkdVO = new VskSwapCstVvdVO();
				vslSkdVO.setVslCd(portSkdVO.getVslCd());
				vslSkdVO.setSkdVoyNo(portSkdVO.getSkdVoyNo());
				vslSkdVO.setSkdDirCd(portSkdVO.getSkdDirCd());
				vslSkdVO.setSlanCd(portSkdVO.getSlanCd());
				
				if(vesselVOs.containsKey(portSkdVO.getVslCd())){
					MdmVslCntrVO mdmVslCntrVO = vesselVOs.get(portSkdVO.getVslCd());
					if("T".equals(mdmVslCntrVO.getVslClssFlg())){
						vslSkdVO.setSkdStsCd("RDY");
					}else{
						vslSkdVO.setSkdStsCd("ACT");
					}
				}
				
				vslSkdVO.setSkdUsdIndCd("H");
				vslSkdVO.setPfSkdTpCd(longRangeSkdGRPVO.getPfSvcTpCd());
				vslSkdVO.setStPortCd(startPortCd);
				vslSkdVO.setN1stPortBrthDt(firstPortBerthDate);
				vslSkdVO.setCoCd("H");
				vslSkdVO.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
				vslSkdVO.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
				
				vslSkdList.add(vslSkdVO);
				
			}
			
			for(int i=0; i<vslSkdList.size(); i++){
				VskSwapCstVvdVO vslSkdVO = vslSkdList.get(i);
				if(oneWayDir){
					vslSkdVO.setSkdRmk(skdRmk[i*4]);
				}else{
					vslSkdVO.setSkdRmk(skdRmk[(i/2)*4]);
				}
			}
			
			// Create PSDO_VVD_CD
			// "FD" + YYMMDD(first PORT VPS_ETD_DT) + "E"
			String vslSkdVvd = null;
			String portSkdVvd = null;
			for(VskSwapCstVvdVO vslSkdVO : vslSkdList){
				
				vslSkdVvd = vslSkdVO.getVslCd() + ":" + vslSkdVO.getSkdVoyNo() + ":" + vslSkdVO.getSkdDirCd();
				for(VskSwapCstPortVO portSkdVO : portSkdList){
					portSkdVvd = portSkdVO.getVslCd() + ":" + portSkdVO.getSkdVoyNo() + ":" + portSkdVO.getSkdDirCd();
					
					if(vslSkdVvd.equals(portSkdVvd)){
						
						// Setting PSDO_VVD_CD
						vslSkdVO.setPsdoVvdCd("FD" + getDateString("yyMMdd", "yyyyMMddHHmm", portSkdVO.getVpsEtbDt()) + "E");
						
						break;
					}
				}
	
			}
		// ---------- Step4. Selecting data to save VSK_VSL_SKD END ----------
		
		
		// ---------- Step5. Saving Simulation SKD START ----------
			List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
			for(VskSwapCstVvdVO vslSkdVO : vslSkdList){
				VskVslSkdVO vo = new VskVslSkdVO();
				vo.setVslCd(vslSkdVO.getVslCd());
				vo.setSkdVoyNo(vslSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(vslSkdVO.getSkdDirCd());
				vo.setVslSlanCd(vslSkdVO.getSlanCd());
				vo.setSkdStsCd(vslSkdVO.getSkdStsCd());
				vo.setSkdUsdIndCd("H");
				vo.setPfSkdTpCd(longRangeSkdGRPVO.getPfSvcTpCd());
				vo.setStPortCd(vslSkdVO.getStPortCd());
				vo.setN1stPortBrthDt(vslSkdVO.getN1stPortBrthDt());
				vo.setCoCd("H");
				vo.setSkdRmk(vslSkdVO.getSkdRmk());
				vo.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
				vo.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
				vo.setPsdoVvdCd(vslSkdVO.getPsdoVvdCd());
				vskVslSkdList.add(vo);
			}
			
			dbDao.addVskVslSkd(vskVslSkdList);				// VSK_VSL_SKD
			// :: VIPS START ::
			// System.out.println("VIPS[addVskVslSkd1]");
			for(VskVslSkdVO vo : vskVslSkdList) {
				List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
				for(VskVslSkdVO row : list) {
					this.mVskVslSkdList.add(row);
				}
			}
			// :: VIPS END ::
			longRangeSkdGRPVO.setVskVslSkdList(vskVslSkdList);
			
			List<VslPortSkdVO> vskVslPortSkdList = new ArrayList<VslPortSkdVO>();
			
			/********************************************************
			 * Setting the indicator of first virtual port
			 * 		for creation default consortium voyage number
			 * ------------------------------------------------------
			 **/
			String				sFirstDirCd					= "";
			String				sSecondDirFirstTurnPortCd	= "";
			String				sFirstVirPortCd				= "";
			String				sFirstVirClptIndSeq			= "";
			String				sCurrVVD					= "";
			String				sNextVVD					= "";
			/********************************************************/
			for(VskSwapCstPortVO portSkdVO : portSkdList){
				
				if(portSkdVO.getInitEtaDt()==null || portSkdVO.getInitEtaDt()==null){
				//if(portSkdVO.getInitEtaDt()==null || portSkdVO.getInitEtaDt().equals(null)){
					continue; 
				}
				
				VslPortSkdVO vo = new VslPortSkdVO();
				
				/********************************************************
				 * Setting the indicator of first virtual port
				 * 		for creation default consortium voyage number
				 * ======================================================
				 * 2015-05-15 by TOP
				 * ------------------------------------------------------
				 **/
				sCurrVVD	= portSkdVO.getVslCd()+portSkdVO.getSkdVoyNo()+portSkdVO.getSkdDirCd();
				
				if(!sCurrVVD.equals(sNextVVD)){
					
					sFirstDirCd					= "";
					sSecondDirFirstTurnPortCd	= "";
					sFirstVirPortCd				= "";
					sFirstVirClptIndSeq			= "";
					sCurrVVD					= "";
					sNextVVD					= "";
					
					for(VskSwapCstPortVO tmpVO : portSkdList){
						if("".equals(sFirstDirCd))																sFirstDirCd					= tmpVO.getSkdDirCd();
						if("".equals(sSecondDirFirstTurnPortCd) && !sFirstDirCd.equals(tmpVO.getSkdDirCd()))	sSecondDirFirstTurnPortCd	= tmpVO.getSkdDirCd();
						if("".equals(sFirstVirPortCd) && "Y".equals(tmpVO.getTurnPortFlg())){
							sFirstVirPortCd		= tmpVO.getVpsPortCd();
							sFirstVirClptIndSeq	= tmpVO.getClptIndSeq();
							break;
						}					
					}
				}
				
				//:2015-05-15:://if(sFirstDirCd.equals(portSkdVO.getSkdDirCd()) && sFirstVirPortCd.equals(portSkdVO.getVpsPortCd()) && sFirstVirClptIndSeq.equals(portSkdVO.getClptIndSeq())){
				if(sFirstDirCd.equals(portSkdVO.getSkdDirCd()) && sFirstVirPortCd.equals(portSkdVO.getVpsPortCd())){
					vo.setFirstVirPortFlg("Y");	
				}else{
					vo.setFirstVirPortFlg("N");	
				}
				
				sNextVVD	= portSkdVO.getVslCd()+portSkdVO.getSkdVoyNo()+portSkdVO.getSkdDirCd();
				/********************************************************/
				
				vo.setVslCd(portSkdVO.getVslCd());
				vo.setSkdVoyNo(portSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(portSkdVO.getSkdDirCd());
				vo.setVpsPortCd(portSkdVO.getVpsPortCd());
				vo.setNewClptIndSeq(portSkdVO.getClptIndSeq());
				vo.setClptSeq(portSkdVO.getClptSeq());
				vo.setSlanCd(portSkdVO.getSlanCd());
				vo.setPortSkdStsCd(portSkdVO.getPortSkdStsCd());
				vo.setYdCd(portSkdVO.getYdCd());
				vo.setCallYdIndSeq(portSkdVO.getCallYdIndSeq());
				//----------------------------------------------------
				vo.setPfEtaDt(portSkdVO.getVpsEtaDt());
				vo.setPfEtbDt(portSkdVO.getVpsEtbDt());
				vo.setPfEtdDt(portSkdVO.getVpsEtdDt());
				vo.setInitEtaDt(portSkdVO.getVpsEtaDt());
				vo.setInitEtbDt(portSkdVO.getVpsEtbDt());
				vo.setInitEtdDt(portSkdVO.getVpsEtdDt());
				vo.setVpsEtaDt(portSkdVO.getVpsEtaDt());
				vo.setVpsEtbDt(portSkdVO.getVpsEtbDt());
				vo.setVpsEtdDt(portSkdVO.getVpsEtdDt());
				//----------------------------------------------------
				vo.setPortSkpTpCd(portSkdVO.getPortSkpTpCd());
				vo.setPortSkpRsnCd(portSkdVO.getPortSkpRsnCd());
				vo.setPortSkpRsnOffrRmk(portSkdVO.getPortSkpRsnOffrRmk());
				vo.setTtlDlayHrs(portSkdVO.getTtlDlayHrs());
				vo.setTsPortCd(portSkdVO.getTsPortCd());
				vo.setUsdFlg(portSkdVO.getUsdFlg());
				vo.setNoonRptInpFlg(portSkdVO.getNoonRptInpFlg());
				vo.setDepRptInpFlg(portSkdVO.getDepRptInpFlg());
				vo.setActInpFlg(portSkdVO.getActInpFlg());
				vo.setPrtChkFlg(portSkdVO.getPrtChkFlg());
				vo.setCreUsrId(portSkdVO.getCreUsrId());
				vo.setUpdUsrId(portSkdVO.getUpdUsrId());
				vo.setVslDlayRsnCd(portSkdVO.getVslDlayRsnCd());
				vo.setVslDlayRsnDesc(portSkdVO.getVslDlayRsnDesc());
				vo.setShpCallNo(portSkdVO.getShpCallNo());
				vo.setShpCallNoUpdUsrId(portSkdVO.getShpCallNoUpdUsrId());
				vo.setShpCallNoUpdDt(portSkdVO.getShpCallNoUpdDt());
				vo.setTmlVoyNo(portSkdVO.getTmlVoyNo());
				vo.setTmlVslCd(portSkdVO.getTmlVslCd());
				vo.setFtDt(portSkdVO.getFtDt());
				vo.setPlismYdCd(portSkdVO.getPlismYdCd());
				vo.setPlismVoyNo(portSkdVO.getPlismVoyNo());
				vo.setPlismVslCd(portSkdVO.getPlismVslCd());
				vo.setSkdCngStsCd(portSkdVO.getSkdCngStsCd());
				vo.setTurnPortFlg(portSkdVO.getTurnPortFlg());
				vo.setTurnPortIndCd(portSkdVO.getTurnPortIndCd());
				vo.setTurnSkdVoyNo(portSkdVO.getTurnSkdVoyNo());
				vo.setTurnSkdDirCd(portSkdVO.getTurnSkdDirCd());
				vo.setTurnClptIndSeq(portSkdVO.getTurnClptIndSeq());
				vo.setIbCgoQty(portSkdVO.getIbCgoQty());
				vo.setObCgoQty(portSkdVO.getObCgoQty());
				vo.setVpsRmk(portSkdVO.getVpsRmk());
				vo.setPhsIoRsnCd(portSkdVO.getPhsIoRsnCd());
				vo.setPhsIoRmk(portSkdVO.getPhsIoRmk());
				vo.setSkdBrthNo(portSkdVO.getSkdBrthNo());
				vo.setInitSkdInpFlg("Y");
				vo.setOfcInpFlg(portSkdVO.getOfcInpFlg());
				vo.setSeaBufHrs(portSkdVO.getSeaBufHrs());
				vo.setPortBufHrs(portSkdVO.getPortBufHrs());
				/*
				 * Trunk/Feeder Long Range Schedule �앹꽦, Creation by VVD, Add Calling
				 * AutoSkdCngFlg���곹깭 媛믪쓣 DEFAULT媛믪� 'Y'濡��ㅼ젙
				 * 2015.03.16 
				 */
				vo.setAutoSkdCngFlg("Y");
				
				vskVslPortSkdList.add(vo);
			}
			
			// last row(turning port = F) does not save in Long Range SKD Creation
			if("F".equals(vskVslPortSkdList.get(vskVslPortSkdList.size()-1).getTurnPortFlg())){
				vskVslPortSkdList.remove(vskVslPortSkdList.size()-1);
			}
			
			List<VslPortSkdVO> vskVslPortSkdList_m = new ArrayList<VslPortSkdVO>();
			
			for(int i=0;i<vskVslPortSkdList.size();i++){
				if( vskVslPortSkdList.get(i).getInitEtaDt() != null){
				vskVslPortSkdList_m.add(vskVslPortSkdList.get(i));
				
				log.info("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
				log.info("\n::getVslCd::["+vskVslPortSkdList.get(i).getVslCd()+"]");
				log.info("\n::getSkdVoyNo::["+vskVslPortSkdList.get(i).getSkdVoyNo()+"]");
				log.info("\n::getSkdDirCd::["+vskVslPortSkdList.get(i).getSkdDirCd()+"]");
				log.info("\n::getVpsPortCd::["+vskVslPortSkdList.get(i).getVpsPortCd()+"]");
				log.info("\n::getClptIndSeq::["+vskVslPortSkdList.get(i).getClptIndSeq()+"]");
				log.info("\n::getClptSeq::["+vskVslPortSkdList.get(i).getClptSeq()+"]");
				log.info("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}
			}
			
			dbDao.addVskVslPortSkd(vskVslPortSkdList);		// VSK_VSL_PORT_SKD
			// :: VIPS START ::
			// System.out.println("VIPS[addVskVslPortSkd1]");
			for(VslPortSkdVO vslPortSkdVO : vskVslPortSkdList) {
				VskVslPortSkdVO vo = new VskVslPortSkdVO();
				vo.setVslCd(vslPortSkdVO.getVslCd());
				vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
				vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
				vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
				List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
				for(VskVslPortSkdVO row : list) {
					this.mVslPortSkdList.add(row);
				}
			}
			// :: VIPS END ::
			return longRangeSkdGRPVO;

		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			
			if(ex.toString().indexOf("FRM10501")>-1 || ex.toString().indexOf("TimedOutException")>-1){
				throw new EventException(new ErrorHandler("VSK10076").getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
			}
			
		} catch (EventException e) {
			throw e;
		}catch(Exception e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), e);
		}
		
		// ---------- Step5. Saving Simulation SKD END  ----------		
		
	}
	
	/**
	 * Adding Port SKD to Current VVD List
	 * 
	 * @param VskSwapCstPortVO skdVO
	 * @param List<VskSwapCstPortVO> currVVD
	 * @return VskSwapCstPortVO
	 */
	private VskSwapCstPortVO addPortSkd(VskSwapCstPortVO skdVO, List<VskSwapCstPortVO> currVVD){
		
		int clptIndSeq = 1;
		int callYdIndSeq = 1;
		
		for(VskSwapCstPortVO vo : currVVD){
			if(vo.getVpsPortCd().equals(skdVO.getVpsPortCd())){
				skdVO.setClptIndSeq(Integer.toString(++clptIndSeq));  // CLPT_IND_SEQ					
			}
			if(skdVO.getYdCd()!=null 
					&& skdVO.getYdCd().trim().length()!=0
					&& skdVO.getYdCd().equals(vo.getYdCd())){
				skdVO.setCallYdIndSeq(Integer.toString(++callYdIndSeq));  // CALL_YD_IND_SEQ
			}
		}
		skdVO.setClptSeq(Integer.toString(currVVD.size()+1));  // CLPT_SEQ
		currVVD.add(skdVO);
		return skdVO;
	}
	
	/**
	 * Adding Virtual Port SKD to pre VVD List
	 * 
	 * @param VskSwapCstPortVO skdVO
	 * @param List<VskSwapCstPortVO> prevVVD
	 * @return VskSwapCstPortVO
	 */
	private VskSwapCstPortVO addVirtualPortSkd(VskSwapCstPortVO skdVO, List<VskSwapCstPortVO> prevVVD){
		if("N".equals(skdVO.getTurnPortFlg())){
			return skdVO;
		}else{
			VskSwapCstPortVO lastVO = prevVVD.get(prevVVD.size()-1);			
			VskSwapCstPortVO virtualSkdVO = new VskSwapCstPortVO(); 
			ObjectCloner.build(skdVO, virtualSkdVO);
			
			int clptIndSeq = 1;
			int callYdIndSeq = 1;
			
			if(lastVO.getSkdVoyNo().equals(virtualSkdVO.getSkdVoyNo())){
				virtualSkdVO.setTurnPortFlg("N");
				virtualSkdVO.setTurnPortIndCd("D");
			}else{
				virtualSkdVO.setTurnPortFlg("N");
				virtualSkdVO.setTurnPortIndCd("V");
			}
			
			virtualSkdVO.setSkdVoyNo(lastVO.getSkdVoyNo());  // SKD_VOY_NO
			virtualSkdVO.setSkdDirCd(lastVO.getSkdDirCd());  // SKD_DIR_CD
			virtualSkdVO.setTurnSkdVoyNo(skdVO.getSkdVoyNo());  // TURN_SKD_VOY_NO
			virtualSkdVO.setTurnSkdDirCd(skdVO.getSkdDirCd());  // TURN_SKD_DIR_CD
			virtualSkdVO.setTurnClptIndSeq(skdVO.getClptIndSeq());  // TURN_CLPT_IND_SEQ
			
			if(lastVO.getVpsPortCd().equals(virtualSkdVO.getVpsPortCd()) &&
					lastVO.getYdCd().equals(virtualSkdVO.getYdCd())){
				if("F".equals(lastVO.getTurnPortIndCd())){
					prevVVD.remove(prevVVD.size()-1);
					virtualSkdVO.setTurnPortIndCd("F");
				}
			}
			
			virtualSkdVO.setClptSeq(Integer.toString(prevVVD.size()+1));  // CLPT_SEQ
			for(VskSwapCstPortVO vo : prevVVD){
				if(vo.getVpsPortCd().equals(virtualSkdVO.getVpsPortCd())){
					virtualSkdVO.setClptIndSeq(Integer.toString(++clptIndSeq));  // CLPT_IND_SEQ					
				}
				if(virtualSkdVO.getYdCd()!=null 
						&& virtualSkdVO.getYdCd().trim().length()!=0 
						&& virtualSkdVO.getYdCd().equals(vo.getYdCd())){
					virtualSkdVO.setCallYdIndSeq(Integer.toString(++callYdIndSeq));  // CALL_YD_IND_SEQ
				}
			}
			
			prevVVD.add(virtualSkdVO);
			
			skdVO.setTurnSkdVoyNo(virtualSkdVO.getSkdVoyNo());  // TURN_SKD_VOY_NO
			skdVO.setTurnSkdDirCd(virtualSkdVO.getSkdDirCd());  // TURN_SKD_DIR_CD
			skdVO.setTurnClptIndSeq(virtualSkdVO.getClptIndSeq());  // TURN_CLPT_IND_SEQ
			
			return skdVO;
		}
	}
	
	/**
	 * ETA = ETB - Maneuvering In Hour
	 * 
	 * @param String strEtb
	 * @param String format
	 * @param String mnvrInHour
	 * @return String
	 */
	private String getETA(String strEtb, String format, String mnvrInHour){
		
		if(strEtb==null || strEtb.trim().length()==0){
			return "";
		}
		
		if(mnvrInHour==null || mnvrInHour.trim().length()==0){
			mnvrInHour = "0";
		}
		
		BigDecimal mnvrInTime = new BigDecimal(mnvrInHour);
		mnvrInTime = mnvrInTime.movePointRight(1);
		
		int hour = mnvrInTime.intValue() / 10;
		int min = mnvrInTime.intValue() % 10 * 6; // 1 means 6 min, 2 means 12 min ...
		
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date eta = null;
		Date etb = null;
		Calendar cal = Calendar.getInstance();
		try {
			etb = sf.parse(strEtb);
		} catch (ParseException e) {
			log.error(e.getMessage());
			return "";
		}
		cal.setTime(etb);
		cal.add(Calendar.HOUR_OF_DAY, hour*(-1));
		cal.add(Calendar.MINUTE, min*(-1));
		eta = cal.getTime();
		return sf.format(eta);
	}
	
	/**
	 * Retrieving Calling Port
	 * 
	 * @param VvdVO vvdVO 
	 * @return SkipPortGRPVO
	 * @exception EventException
	 */
	public SkipPortGRPVO searchCallingPortList(VvdVO vvdVO) throws EventException {
		try {
			SkipPortGRPVO skipPortGRPVO = new SkipPortGRPVO();
			skipPortGRPVO.setReasonPortList(dbDao.searchPreCallingPortList(vvdVO));
			skipPortGRPVO.setTsPortList(dbDao.searchNextCallingPortList(vvdVO));
	
			return skipPortGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}
	}
	
	/**
	 * Checking Booking is exist with the VVD
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVvdApplyBooking(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkVvdApplyBooking(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Checking Vessel Code is exist in MDM_VSL_CNTR
	 * @param String vslCd
	 * @return int
	 * @exception EventException
	 */
	public int checkVslCntr(String vslCd) throws EventException {
		try {
			return dbDao.checkVslCntr(vslCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Checking Actual Port Schedule is exist with the vvd
	 * 
	 * @param VvdVO vvdVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVvdActualSkdInput(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkVvdActualSkdInput(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Checking RUSE_PROHI_FLG with the VVD
	 * 
	 * @param VvdVO vvdVO
	 * @return String
	 * @exception EventException
	 */
	public String checkReuseVvd(VvdVO vvdVO) throws EventException {
		try {
			return dbDao.checkReuseVvd(vvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Vessel Schedule
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdByVvdVO> searchCstSkdByVvd(CstSkdByVvdVO cstSkdByVvdVO) throws EventException {
		try {
			return dbDao.searchCstSkdByVvd(cstSkdByVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @return List<CstSkdByVvdVO>
	 * @exception EventException
	 */
	public List<CstSkdByVvdVO> searchCstSkdByPfSkdUse(CstSkdByVvdVO cstSkdByVvdVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPfSkdUse(cstSkdByVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Proforma Schedule
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdByPfSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPfSkdSim(swapCstSkdSimVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Checking Service Lane Code, Direction Code are in MDM Service Lane Table
	 * 
	 * @param List<VskVslSkdVO> list
	 * @return boolean
	 * @exception EventException
	 */
	private boolean isCheckLaneDir(List<VskVslSkdVO> list) throws EventException{
		boolean isFlag = false;
		
		try{
			for(int i=0; i<list.size(); i++) {
				String chkFlag = dbDao.checkLaneDir(list.get(i).getVslSlanCd(), list.get(i).getSkdDirCd());
				if("X".equals(chkFlag)){
					isFlag = true;
				}else{
					throw new EventException(new ErrorHandler("VSK10019").getMessage());
				}
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return isFlag;
	}
	
	/**
	 * Checking data is MDM Container Vessel Code
	 * 
	 * @param List<VskVslSkdVO> list
	 * @return boolean
	 * @exception EventException
	 */
	private boolean isCheckVslCntr(List<VskVslSkdVO> list) throws EventException{
		boolean isFlag = false;
		
		try{
			for(int i=0; i<list.size(); i++) {
				int chkCnt = dbDao.checkVslCntr(list.get(i).getVslCd());
				if(chkCnt > 0){
					isFlag = true;
				}else{
					throw new EventException(new ErrorHandler("VSK10028").getMessage());
				}
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return isFlag;
	}
	
	/**
	 * Checking VVD is in inputted list
	 * 
	 * @param List<VskVslSkdVO> list
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return boolean
	 */
	private boolean isSameDataByVvd(List<VskVslSkdVO> list, VskVslSkdVO vskVslSkdVO){
		if(list != null && list.size() > 0 && vskVslSkdVO != null){
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getVslCd().equals(vskVslSkdVO.getVslCd())
						&& list.get(i).getSkdVoyNo().equals(vskVslSkdVO.getSkdVoyNo())
						&& list.get(i).getSkdDirCd().equals(vskVslSkdVO.getSkdDirCd())){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Retrieving SKD_STS_CD(ACT, RDY etc.).
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	private String getSkdStsCd(String vslCd) throws EventException{
		String skdStsCd = "";
		try{
			skdStsCd = dbDao.searchSkdStsCd(vslCd);
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return skdStsCd;
	}
	
	/**
	 * Finding port code and etb of first port of VVD 
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String vvd
	 * @return VskVslSkdVO
	 */
	private VskVslSkdVO getfirstPortBrthDt(CstSkdByVvdVO[] cstSkdByVvdVOs, String vvd){
		VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs) {
			String sVvd = cstSkdByVvdVO.getVslCd() + cstSkdByVvdVO.getSkdVoyNo() + cstSkdByVvdVO.getSkdDirCd();
			
			// exclude skip
			if(sVvd.equals(vvd)){
				if(!"S".equals(cstSkdByVvdVO.getSkdCngStsCd())){
					vskVslSkdVO.setStPortCd(cstSkdByVvdVO.getVpsPortCd());
					vskVslSkdVO.setN1stPortBrthDt(cstSkdByVvdVO.getVpsEtbDt());
					break;
				}
			}
		}
		return vskVslSkdVO;
	}
	
	/**
	 * Finding master data to insert in Vessel Port SKD
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 * @throws DAOException 
	 */
	private List<VskVslSkdVO> getMasterInsertData(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId) throws EventException, DAOException{
		List<VskVslSkdVO> insertVoList = new ArrayList<VskVslSkdVO>();
		
		for (CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs) {
			if ("I".equals(cstSkdByVvdVO.getIbflag())) {
				VskVslSkdVO chkVO = new VskVslSkdVO();
				
				chkVO.setVslCd(cstSkdByVvdVO.getVslCd());
				chkVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				chkVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				
				int chkCnt = dbDao.checkVvd(chkVO);
				
				if (chkCnt == 0) {
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					
					vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
					vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
					vskVslSkdVO.setSkdUsdIndCd("H");
					vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd());
					vskVslSkdVO.setPsdoVvdCd("FD" + cstSkdByVvdVO.getVpsEtdDt().substring(2, 8) + "E");
					vskVslSkdVO.setCoCd("H");
					vskVslSkdVO.setSkdRmk(cstSkdByVvdVO.getSkdRmk());
					vskVslSkdVO.setCreUsrId(userId);
					vskVslSkdVO.setUpdUsrId(userId);
					
					if(!isSameDataByVvd(insertVoList, vskVslSkdVO)){
						// Retrieving SKD_STS_CD
						if(VSKGeneralUtil.isNull(vskVslSkdVO.getSkdStsCd())){
							vskVslSkdVO.setSkdStsCd(getSkdStsCd(vskVslSkdVO.getVslCd()));
						}
						
						// Retrieving ETB of 1st Port
						String vvd = vskVslSkdVO.getVslCd() + vskVslSkdVO.getSkdVoyNo() + vskVslSkdVO.getSkdDirCd();
						VskVslSkdVO firstPortInfoVO = getfirstPortBrthDt(cstSkdByVvdVOs, vvd);
						if(firstPortInfoVO == null){
							vskVslSkdVO.setStPortCd(cstSkdByVvdVO.getVpsPortCd());
							vskVslSkdVO.setN1stPortBrthDt(cstSkdByVvdVO.getVpsEtbDt());
						}else{
							vskVslSkdVO.setStPortCd(firstPortInfoVO.getStPortCd());
							vskVslSkdVO.setN1stPortBrthDt(firstPortInfoVO.getN1stPortBrthDt());
						}
						
						insertVoList.add(vskVslSkdVO);
					}
				}
			}
		}//end for
	
		return insertVoList;
	}
	
	/**
	 * Retrieving master data to update in Vessel Port SKD
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> getMasterUpdateData(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId) throws EventException{
		List<VskVslSkdVO> updateVoList = new ArrayList<VskVslSkdVO>();
		
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs) {
			if ("U".equals(cstSkdByVvdVO.getIbflag())){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				
				vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
				vskVslSkdVO.setSkdStsCd(cstSkdByVvdVO.getSkdStsCd());
				vskVslSkdVO.setSkdUsdIndCd("H");
				vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd());
				vskVslSkdVO.setPsdoVvdCd("FD" + cstSkdByVvdVO.getVpsEtdDt().substring(2, 8) + "E");
				vskVslSkdVO.setCoCd("H");
				vskVslSkdVO.setSkdRmk(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSkdRmk(), " "));
				vskVslSkdVO.setCreUsrId(userId);
				vskVslSkdVO.setUpdUsrId(userId);
				
				if(!isSameDataByVvd(updateVoList, vskVslSkdVO)){
					// Retrieving SKD_STS_CD
					if(VSKGeneralUtil.isNull(vskVslSkdVO.getSkdStsCd())){
						vskVslSkdVO.setSkdStsCd(getSkdStsCd(vskVslSkdVO.getVslCd()));
					}
					
					// Retrieving ETB of 1st Port
					String vvd = vskVslSkdVO.getVslCd() + vskVslSkdVO.getSkdVoyNo() + vskVslSkdVO.getSkdDirCd();
					VskVslSkdVO firstPortInfoVO = getfirstPortBrthDt(cstSkdByVvdVOs, vvd);
					if(firstPortInfoVO == null){
						vskVslSkdVO.setStPortCd(cstSkdByVvdVO.getVpsPortCd());
						vskVslSkdVO.setN1stPortBrthDt(cstSkdByVvdVO.getVpsEtbDt());
					}else{
						vskVslSkdVO.setStPortCd(firstPortInfoVO.getStPortCd());
						vskVslSkdVO.setN1stPortBrthDt(firstPortInfoVO.getN1stPortBrthDt());
					}
					
					updateVoList.add(vskVslSkdVO);
				}
			}
		}//end for
	
		return updateVoList;
	}
	
	/**
	 * Retrieving master data to delete in Vessel Port SKD
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> getMasterDeleteData(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId) throws EventException{
		List<VskVslSkdVO> deleteVoList = new ArrayList<VskVslSkdVO>();		// to delete VVD
		List<VskVslSkdVO> masterVoList = getMasterVvdList(cstSkdByVvdVOs, userId);		// cstSkdByVvdVOs
		
		// finding VVD to delete in masterVoList, and put in deleteVoList
		for(VskVslSkdVO vskVslSkdVO : masterVoList){
			boolean isDelFlg = true;	// delete flag per port
			for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
				if(vskVslSkdVO.getVslCd().equals(cstSkdByVvdVO.getVslCd())
						&& vskVslSkdVO.getSkdVoyNo().equals(cstSkdByVvdVO.getSkdVoyNo())
						&& vskVslSkdVO.getSkdDirCd().equals(cstSkdByVvdVO.getSkdDirCd())){
					if(!"D".equals(cstSkdByVvdVO.getIbflag())){
						isDelFlg = false;
						break;
					}
				}
			}
			
			// all port of VVD are target to delete, Delete the VVD
			if(isDelFlg){
				deleteVoList.add(vskVslSkdVO);
			}
		}
		
		return deleteVoList;
	}
	
	/**
	 * Returning current User Id
	 * 
	 * @param SignOnUserAccount account
	 * @param String strId
	 * @return String
	 */
	private String currentUserId(SignOnUserAccount account, String strId){
		String userId = "";
		
		if(account == null){
			userId = strId;
		}else{
			userId = account.getUsr_id();
		}
		
		return userId;
	}
	
	/**
	 * Returning Master Data from Coastal Schedule
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 */
	private List<VskVslSkdVO> getMasterVvdList(CstSkdByVvdVO[] cstSkdByVvdVOs, String userId){
		List<VskVslSkdVO> masterVoList = new ArrayList<VskVslSkdVO>();

		String curVvdCd = "";
		String preVvdCd = "";
		
		// Setting VVD from cstSkdByVvdVOs
		for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
			//VVD code
			curVvdCd = cstSkdByVvdVO.getVslCd() + cstSkdByVvdVO.getSkdVoyNo() + cstSkdByVvdVO.getSkdDirCd();
			
			if(!curVvdCd.equals(preVvdCd)){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
				// user info for Log
				if(VSKGeneralUtil.isNull(cstSkdByVvdVO.getCreUsrId())){
					vskVslSkdVO.setCreUsrId(userId);
				}else{
					vskVslSkdVO.setCreUsrId(cstSkdByVvdVO.getCreUsrId());
				}
				// user info for Log
				if(VSKGeneralUtil.isNull(cstSkdByVvdVO.getUpdUsrId())){
					vskVslSkdVO.setUpdUsrId(userId);
				}else{
					vskVslSkdVO.setUpdUsrId(cstSkdByVvdVO.getUpdUsrId());
				}
				
				if(!isSameDataByVvd(masterVoList, vskVslSkdVO)){
					masterVoList.add(vskVslSkdVO);
				}
				
				preVvdCd = curVvdCd;
			}
		}
		
		return masterVoList;
	}
	
	/**
	 * Creating Virtual Port DataSet
	 *  
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param String clptIndSeq
	 * @param String clptSeq
	 * @param String laneCd
	 * @param String ydCd
	 * @param String callYdIndSeq
	 * @param String turnPortIndCd
	 * @param String userId
	 * @return
	 */
	private VslPortSkdVO makeVirtualDataSet(CstSkdByVvdVO cstSkdByVvdVO, String clptIndSeq, String clptSeq, String laneCd, String ydCd, String callYdIndSeq, String turnPortIndCd, String userId) throws EventException {
		
		VslPortSkdVO virtualPortVO 	= new VslPortSkdVO();
		
		try{
			
			virtualPortVO.setVslCd			(cstSkdByVvdVO.getVslCd());
			virtualPortVO.setSkdVoyNo		(cstSkdByVvdVO.getTurnSkdVoyNo());
			virtualPortVO.setSkdDirCd		(cstSkdByVvdVO.getTurnSkdDirCd());
			virtualPortVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd());
			
			

			/** NEW_CLPT_IND_SEQ was already set in the previous conversion logic. It should not be set current logic **/
			//:2016-05-24:by TOP://virtualPortVO.setClptIndSeq		(clptIndSeq);
			//:2016-05-24:by TOP://virtualPortVO.setNewClptIndSeq	(clptIndSeq);
			
			
			virtualPortVO.setClptIndSeq		(cstSkdByVvdVO.getTurnClptIndSeq());
			virtualPortVO.setNewClptIndSeq	(clptIndSeq);
			
			
			
			
			/******* Correction for CLPT_SEQ except virtual add calling port ********************************/
			//:2016-07-08://int	iVirAddPortCount			= dbDao.searchVirtualAddCallPortCount(virtualPortVO);
			//:2016-07-08://String	sCorrClptSeq			= String.valueOf(Integer.parseInt(clptSeq) - iVirAddPortCount);
			
			virtualPortVO.setClptSeq		(clptSeq);
			//:2016-07-08://virtualPortVO.setClptSeq		(sCorrClptSeq);
			/************************************************************************************************/
			
			virtualPortVO.setSlanCd			(laneCd);
			virtualPortVO.setPortSkdStsCd	(cstSkdByVvdVO.getPortSkdStsCd());
			virtualPortVO.setYdCd			(ydCd);
			virtualPortVO.setCallYdIndSeq	(callYdIndSeq);
			virtualPortVO.setPfEtaDt		(cstSkdByVvdVO.getPfEtaDt());
			virtualPortVO.setPfEtbDt		(cstSkdByVvdVO.getPfEtbDt());
			virtualPortVO.setPfEtdDt		(cstSkdByVvdVO.getPfEtdDt());
			virtualPortVO.setInitEtaDt		(VSKGeneralUtil.nvl(cstSkdByVvdVO.getInitEtaDt(), cstSkdByVvdVO.getVpsEtaDt()));
			virtualPortVO.setInitEtbDt		(VSKGeneralUtil.nvl(cstSkdByVvdVO.getInitEtbDt(), cstSkdByVvdVO.getVpsEtbDt()));
			virtualPortVO.setInitEtdDt		(VSKGeneralUtil.nvl(cstSkdByVvdVO.getInitEtdDt(), cstSkdByVvdVO.getVpsEtdDt()));
			virtualPortVO.setVpsEtaDt		(cstSkdByVvdVO.getVpsEtaDt());
			virtualPortVO.setVpsEtbDt		(cstSkdByVvdVO.getVpsEtbDt());
			virtualPortVO.setVpsEtdDt		(cstSkdByVvdVO.getVpsEtdDt());
			virtualPortVO.setVslDlayRsnCd	(cstSkdByVvdVO.getVslDlayRsnCd());
			virtualPortVO.setVslDlayRsnDesc	(cstSkdByVvdVO.getVslDlayRsnDesc());
			virtualPortVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
			virtualPortVO.setShpCallNo		(cstSkdByVvdVO.getShpCallNo());
			virtualPortVO.setShpCallNoUpdUsrId(cstSkdByVvdVO.getShpCallNoUpdUsrId());
			virtualPortVO.setShpCallNoUpdDt	(cstSkdByVvdVO.getShpCallNoUpdDt());
			virtualPortVO.setTmlVslCd		(cstSkdByVvdVO.getTmlVslCd());
			virtualPortVO.setTmlVoyNo		(cstSkdByVvdVO.getTmlVoyNo());
			virtualPortVO.setFtDt			(cstSkdByVvdVO.getFtDt());
			virtualPortVO.setPlismYdCd		(cstSkdByVvdVO.getPlismYdCd());
			virtualPortVO.setPlismVslCd		(cstSkdByVvdVO.getPlismVslCd());
			virtualPortVO.setPlismVoyNo		(cstSkdByVvdVO.getPlismVoyNo());
			
			if("I".equals(cstSkdByVvdVO.getSkdCngStsCd())){
				// when Turn Port Flag is "Y" and Phase In then Virtual -> Phase Out
				virtualPortVO.setSkdCngStsCd("O");
			}else{
				virtualPortVO.setSkdCngStsCd(cstSkdByVvdVO.getSkdCngStsCd());
			}
			
			virtualPortVO.setTurnPortFlg	("N");
			virtualPortVO.setTurnPortIndCd	(turnPortIndCd);
			virtualPortVO.setTurnSkdVoyNo	(cstSkdByVvdVO.getSkdVoyNo());
			virtualPortVO.setTurnSkdDirCd	(cstSkdByVvdVO.getSkdDirCd());
			virtualPortVO.setTurnClptIndSeq	(cstSkdByVvdVO.getNewClptIndSeq());
			virtualPortVO.setIbCgoQty		(cstSkdByVvdVO.getIbCgoQty());
			virtualPortVO.setObCgoQty		(cstSkdByVvdVO.getObCgoQty());
			virtualPortVO.setVpsRmk			(cstSkdByVvdVO.getVpsRmk());
			virtualPortVO.setPhsIoRsnCd		(cstSkdByVvdVO.getPhsIoRsnCd());
			virtualPortVO.setPhsIoRmk		(cstSkdByVvdVO.getPhsIoRmk());
			virtualPortVO.setSkdBrthNo		(cstSkdByVvdVO.getSkdBrthNo());
			virtualPortVO.setInitSkdInpFlg	(cstSkdByVvdVO.getInitSkdInpFlg());
			virtualPortVO.setOfcInpFlg		(cstSkdByVvdVO.getOfcInpFlg());
			virtualPortVO.setNoonRptInpFlg	(cstSkdByVvdVO.getNoonRptInpFlg());
			virtualPortVO.setDepRptInpFlg	(cstSkdByVvdVO.getDepRptInpFlg());
			virtualPortVO.setActInpFlg		(cstSkdByVvdVO.getActInpFlg());
			virtualPortVO.setPrtChkFlg		(cstSkdByVvdVO.getPrtChkFlg());
			virtualPortVO.setCreUsrId		(userId);
			virtualPortVO.setUpdUsrId		(userId);
			virtualPortVO.setEdiSndKnt		(cstSkdByVvdVO.getEdiSndKnt());
			virtualPortVO.setPortSkpTpCd	(cstSkdByVvdVO.getPortSkpTpCd());
			virtualPortVO.setPortSkpRsnCd	(cstSkdByVvdVO.getPortSkpRsnCd());
			virtualPortVO.setPortSkpRsnOffrRmk(cstSkdByVvdVO.getPortSkpRsnOffrRmk());
			virtualPortVO.setTtlDlayHrs		(cstSkdByVvdVO.getTtlDlayHrs());
			virtualPortVO.setTsPortCd		(cstSkdByVvdVO.getTsPortCd());
			virtualPortVO.setUsdFlg			(cstSkdByVvdVO.getUsdFlg());
			virtualPortVO.setAutoSkdCngFlg	(cstSkdByVvdVO.getAutoSkdCngFlg());
			virtualPortVO.setLnkDist		(cstSkdByVvdVO.getLnkDist());
			virtualPortVO.setLnkSpd			(cstSkdByVvdVO.getLnkSpd());
			virtualPortVO.setTztmHrs		(cstSkdByVvdVO.getTztmHrs());
			virtualPortVO.setSeaBufHrs		(cstSkdByVvdVO.getSeaBufHrs());
			virtualPortVO.setMnvrInHrs		(cstSkdByVvdVO.getMnvrInHrs());
			virtualPortVO.setMnvrOutHrs		(cstSkdByVvdVO.getMnvrOutHrs());
			virtualPortVO.setPortWrkHrs		(cstSkdByVvdVO.getActWrkHrs());
			virtualPortVO.setPortBufHrs		(cstSkdByVvdVO.getPortBufHrs());
			
			/** adding column IB/OB CSSM Voyage Number **/
			virtualPortVO.setIbCssmVoyNo	(cstSkdByVvdVO.getIbCssmVoyNo			());
			//::2016-04-16:://virtualPortVO.setIbCssmVoyNo	(cstSkdByVvdVO.getTurnIbCssmVoyNo			());
			virtualPortVO.setObCssmVoyNo	(cstSkdByVvdVO.getObCssmVoyNo			());
			
			virtualPortVO.setCssmVoyInitCreFlg(cstSkdByVvdVO.getCssmVoyInitCreFlg	());
			
			/** adding column virtual add calling flag **/
			virtualPortVO.setVtAddCallFlg	(cstSkdByVvdVO.getVtAddCallFlg			());
		
			virtualPortVO.setVslRenmOldVslCd(cstSkdByVvdVO.getVslRenmOldVslCd		());
			virtualPortVO.setVslRenmOldVslEngNm(cstSkdByVvdVO.getVslRenmOldVslEngNm	());
			virtualPortVO.setVslRenmNewVslCd(cstSkdByVvdVO.getVslRenmNewVslCd		());
			virtualPortVO.setVslRenmNewVslEngNm(cstSkdByVvdVO.getVslRenmNewVslEngNm	());
			virtualPortVO.setVsldWks		(cstSkdByVvdVO.getVsldWks				());
			virtualPortVO.setAddCallFlg		(cstSkdByVvdVO.getAddCallFlg			());
			virtualPortVO.setSkpCallFlg		(cstSkdByVvdVO.getSkpCallFlg			());
			
			virtualPortVO.setAddCallXterFlg	(cstSkdByVvdVO.getAddCallXterFlg		());
			virtualPortVO.setPrivCallFlg	(cstSkdByVvdVO.getPrivCallFlg			());
			
			//:2016-08-03:byTOP://
			////virtualPortVO.setNewClptIndSeq	(clptIndSeq);
			//:2016-08-03:byTOP://
			
		//:2016-07-08://} catch (DAOException ex) {
		//:2016-07-08://	log.error("err " + ex.toString(), ex);
		//:2016-07-08://	throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
				
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return virtualPortVO;
	}
	
	/**
	 * Creating VskVslPortSkdVO DataSet
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param String callYdIndSeq
	 * @param String turnClptIndSeq
	 * @param String turnPortIndCd
	 * @param String userId
	 * @return
	 */
	private VslPortSkdVO makeVskVslPortDataSet(CstSkdByVvdVO cstSkdByVvdVO, String callYdIndSeq, String turnClptIndSeq, String turnPortIndCd, String userId){
		VslPortSkdVO vslPortSkdVO = new VslPortSkdVO();
		
		vslPortSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
		vslPortSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
		vslPortSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
		vslPortSkdVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
		vslPortSkdVO.setClptIndSeq(cstSkdByVvdVO.getClptIndSeq());
		vslPortSkdVO.setNewClptIndSeq(cstSkdByVvdVO.getNewClptIndSeq());
		vslPortSkdVO.setClptSeq(cstSkdByVvdVO.getClptSeq());	//UI(�붾㈃)�먯꽌 Setting 
		vslPortSkdVO.setSlanCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
		vslPortSkdVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
		vslPortSkdVO.setCallYdIndSeq(callYdIndSeq);
		
		//::2015-04-18:by TOP:://
/*		vslPortSkdVO.setPfEtaDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtaDt(), " "));
		vslPortSkdVO.setPfEtbDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtbDt(), " "));
		vslPortSkdVO.setPfEtdDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtdDt(), " "));*/

		vslPortSkdVO.setPfEtaDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtaDt(), ""));
		vslPortSkdVO.setPfEtbDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtbDt(), ""));
		vslPortSkdVO.setPfEtdDt(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPfEtdDt(), ""));

		vslPortSkdVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
		vslPortSkdVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
		vslPortSkdVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
		vslPortSkdVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
		vslPortSkdVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
		vslPortSkdVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
		vslPortSkdVO.setShpCallNo(cstSkdByVvdVO.getShpCallNo());
		vslPortSkdVO.setShpCallNoUpdUsrId(cstSkdByVvdVO.getShpCallNoUpdUsrId());
		vslPortSkdVO.setShpCallNoUpdDt(cstSkdByVvdVO.getShpCallNoUpdDt());
		vslPortSkdVO.setTmlVslCd(cstSkdByVvdVO.getTmlVslCd());
		vslPortSkdVO.setTmlVoyNo(cstSkdByVvdVO.getTmlVoyNo());
		vslPortSkdVO.setFtDt(cstSkdByVvdVO.getFtDt());
		vslPortSkdVO.setPlismYdCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPlismYdCd(), " "));
		vslPortSkdVO.setPlismVslCd(cstSkdByVvdVO.getPlismVslCd());
		vslPortSkdVO.setPlismVoyNo(cstSkdByVvdVO.getPlismVoyNo());
		vslPortSkdVO.setSkdCngStsCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSkdCngStsCd(), " "));
		vslPortSkdVO.setTurnPortFlg(cstSkdByVvdVO.getTurnPortFlg());
		vslPortSkdVO.setTurnPortIndCd(turnPortIndCd);
		vslPortSkdVO.setTurnSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
		vslPortSkdVO.setTurnSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
		vslPortSkdVO.setTurnClptIndSeq(turnClptIndSeq);
		vslPortSkdVO.setIbCgoQty(cstSkdByVvdVO.getIbCgoQty());
		vslPortSkdVO.setObCgoQty(cstSkdByVvdVO.getObCgoQty());
		vslPortSkdVO.setVpsRmk(cstSkdByVvdVO.getVpsRmk());
		vslPortSkdVO.setPhsIoRsnCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPhsIoRsnCd(), " "));
		vslPortSkdVO.setPhsIoRmk(VSKGeneralUtil.nvl(cstSkdByVvdVO.getPhsIoRmk(), " "));
		vslPortSkdVO.setOfcInpFlg(cstSkdByVvdVO.getOfcInpFlg());
		vslPortSkdVO.setCreUsrId(userId);
		vslPortSkdVO.setUpdUsrId(userId);
		vslPortSkdVO.setPortSkpTpCd(cstSkdByVvdVO.getPortSkpTpCd());
		vslPortSkdVO.setPortSkpRsnCd(cstSkdByVvdVO.getPortSkpRsnCd());
		vslPortSkdVO.setPortSkpRsnOffrRmk(cstSkdByVvdVO.getPortSkpRsnOffrRmk());
		vslPortSkdVO.setTtlDlayHrs(cstSkdByVvdVO.getTtlDlayHrs());
		vslPortSkdVO.setTsPortCd(cstSkdByVvdVO.getTsPortCd());
		vslPortSkdVO.setUsdFlg(cstSkdByVvdVO.getUsdFlg());
		vslPortSkdVO.setAutoSkdCngFlg(cstSkdByVvdVO.getAutoSkdCngFlg());
		vslPortSkdVO.setLnkDist(cstSkdByVvdVO.getLnkDist());
		vslPortSkdVO.setLnkSpd(cstSkdByVvdVO.getLnkSpd());
		vslPortSkdVO.setTztmHrs(cstSkdByVvdVO.getTztmHrs());
		vslPortSkdVO.setSeaBufHrs(cstSkdByVvdVO.getSeaBufHrs());
		vslPortSkdVO.setMnvrInHrs(cstSkdByVvdVO.getMnvrInHrs());
		vslPortSkdVO.setMnvrOutHrs(cstSkdByVvdVO.getMnvrOutHrs());
		vslPortSkdVO.setPortWrkHrs(cstSkdByVvdVO.getActWrkHrs());
		vslPortSkdVO.setPortBufHrs(cstSkdByVvdVO.getPortBufHrs());
		
		/** adding column IB/OB CSSM Voyage Number **/
		vslPortSkdVO.setIbCssmVoyNo		(cstSkdByVvdVO.getIbCssmVoyNo			());
		vslPortSkdVO.setObCssmVoyNo		(cstSkdByVvdVO.getObCssmVoyNo			());
		
		vslPortSkdVO.setCssmVoyInitCreFlg(cstSkdByVvdVO.getCssmVoyInitCreFlg	());
		
		/** adding column virtual add calling flag **/
		vslPortSkdVO.setVtAddCallFlg	(cstSkdByVvdVO.getVtAddCallFlg			());
		
		vslPortSkdVO.setVslRenmOldVslCd	(cstSkdByVvdVO.getVslRenmOldVslCd		());
		vslPortSkdVO.setVslRenmOldVslEngNm(cstSkdByVvdVO.getVslRenmOldVslEngNm	());
		vslPortSkdVO.setVslRenmNewVslCd	(cstSkdByVvdVO.getVslRenmNewVslCd		());
		vslPortSkdVO.setVslRenmNewVslEngNm(cstSkdByVvdVO.getVslRenmNewVslEngNm	());
		vslPortSkdVO.setVsldWks			(cstSkdByVvdVO.getVsldWks				());
		vslPortSkdVO.setAddCallFlg		(cstSkdByVvdVO.getAddCallFlg			());
		vslPortSkdVO.setSkpCallFlg		(cstSkdByVvdVO.getSkpCallFlg			());
		
		vslPortSkdVO.setAddCallXterFlg	(cstSkdByVvdVO.getAddCallXterFlg		());
		vslPortSkdVO.setPrivCallFlg		(cstSkdByVvdVO.getPrivCallFlg			());
		
		return vslPortSkdVO;
	}
	

	/**
	 * Updating and Deleting changed Vessel Port SKD
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SignOnUserAccount account) throws EventException{
		
		VslSkdChgStsGRPVO 	vslSkdChgStsGRPVO 		= new VslSkdChgStsGRPVO();
		
		//::by TOP:2015-05-08:://
		Map<String, List<VslSkdXtraHisVO>>	hmVslSkdXtraHisVOs		= new HashMap<String, List<VslSkdXtraHisVO>>();
		VslSkdXtraHisGroupVO				vslSkdXtraHisGroupVO	= new VslSkdXtraHisGroupVO();
		//::by TOP:2015-05-08:://
		
		try{
			
			if(cstSkdByVvdVOs != null){
				List<VskVslSkdVO> insertVoList = new ArrayList<VskVslSkdVO>();
				List<VskVslSkdVO> updateVoList = new ArrayList<VskVslSkdVO>();
				List<VskVslSkdVO> deleteVoList = new ArrayList<VskVslSkdVO>();
				
				String userId 	= currentUserId(account, cstSkdByVvdVOs[0].getUpdUsrId());
				
				/*************************************************************************************
				 * VVD
				 *************************************************************************************/
				insertVoList 	= this.getMasterInsertData(cstSkdByVvdVOs, userId);
				updateVoList 	= this.getMasterUpdateData(cstSkdByVvdVOs, userId);
				deleteVoList 	= this.getMasterDeleteData(cstSkdByVvdVOs, userId);
				
				if(insertVoList != null && insertVoList.size() > 0) isCheckLaneDir(insertVoList);
				if(insertVoList != null && insertVoList.size() > 0) isCheckVslCntr(insertVoList);
				if(updateVoList != null && updateVoList.size() > 0) isCheckLaneDir(updateVoList);
				if(updateVoList != null && updateVoList.size() > 0) isCheckVslCntr(updateVoList);
				if(deleteVoList != null && deleteVoList.size() > 0) isCheckVslCntr(deleteVoList);
				
				/*************************************************************************************
				 * Port
				 *************************************************************************************/
				List<VslPortSkdVO> 		insertPortVoList 			= new ArrayList<VslPortSkdVO>();
				List<VslPortSkdVO> 		updatePortVoList 			= new ArrayList<VslPortSkdVO>();
				
				// in case modified data is not key in VSK_VSL_PORT_SKD
				List<VslPortSkdVO> 		updatePortDataList 			= new ArrayList<VslPortSkdVO>();  
				
				List<VslPortSkdVO> 		deletePortVoList 			= new ArrayList<VslPortSkdVO>();
				List<VskVslPortSkdVO> 	deleteVirtualPortVoList 	= new ArrayList<VskVslPortSkdVO>();
				List<VslPortSkdVO> 		insertVirtualPortVoList 	= new ArrayList<VslPortSkdVO>();
				List<VskVslPortSkdVO> 	updateNextPortVoList 		= new ArrayList<VskVslPortSkdVO>();
				List<VskVslPortSkdVO> 	deleteVirtualPortERPVoList 	= new ArrayList<VskVslPortSkdVO>();	//for transmitting deleted virtual port to ERP
				List<VskVslPortSkdVO> 	curPortInfoVOList 			= null;			
				List<VskVslPortSkdVO> 	prePortInfoVOList 			= null;			
				
				List<VskVslPortSkdVO> 	totalOrgPortList 			= new ArrayList<VskVslPortSkdVO>();
	
				boolean 				isFirstPort 				= false;
				int 					vitualSeq 					= 0; 		// Virtual order(in case of first virtual, when next port create, turn_port_ind_cd = N)
	
				List<VskVslSkdVO> 		masterVoList 				= this.getMasterVvdList(cstSkdByVvdVOs, userId);		// VVD from cstSkdByVvdVOs
				boolean 				firstVVD 					= true;
				
				
				for(VskVslSkdVO vskVslSkdVO : masterVoList){
					String vslCd 	= vskVslSkdVO.getVslCd();
					String skdVoyNo = vskVslSkdVO.getSkdVoyNo();
					String skdDirCd = vskVslSkdVO.getSkdDirCd();
					
					VskVslPortSkdVO originPortParamVO = new VskVslPortSkdVO();
					originPortParamVO.setVslCd(vslCd);
					originPortParamVO.setSkdVoyNo(skdVoyNo);
					originPortParamVO.setSkdDirCd(skdDirCd);
					List<VskVslPortSkdVO> originPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(originPortParamVO);	//Retrieving port info before current VVD save
					
					if(originPortVoList != null && originPortVoList.size()>0){
						totalOrgPortList.addAll(originPortVoList);
					}
	
					////////////////////////////////////////////////////////////////////////////
					if(curPortInfoVOList != null){
						prePortInfoVOList = curPortInfoVOList;
					}
					
					curPortInfoVOList 	= new ArrayList<VskVslPortSkdVO>();
					////////////////////////////////////////////////////////////////////////////
					
					int currSeq 					= 0;		// Port - for loop seq
					isFirstPort 					= true;
					
					boolean isFirstTurningPortChk	= false;
					
					for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){ 
						
						boolean isFirstTurningPort		= false;
						
						// Acting per VVD
						if(vslCd.equals(cstSkdByVvdVO.getVslCd()) && skdVoyNo.equals(cstSkdByVvdVO.getSkdVoyNo()) && skdDirCd.equals(cstSkdByVvdVO.getSkdDirCd())){
							String ibFlag 			= cstSkdByVvdVO.getIbflag();
							String newClptIndSeq 	= cstSkdByVvdVO.getNewClptIndSeq();		// count of port in same VVD
							String vpsPortCd 		= cstSkdByVvdVO.getVpsPortCd();
							String ydCd 			= vpsPortCd + cstSkdByVvdVO.getTmlCd();				// Yard Code = Port Code + Terminal Code
							String turnPortFlg 		= cstSkdByVvdVO.getTurnPortFlg();
							String turnPortIndCd 	= cstSkdByVvdVO.getTurnPortIndCd();
							String turnClptIndSeq 	= cstSkdByVvdVO.getTurnClptIndSeq();
							String turnSkdVoyNo 	= cstSkdByVvdVO.getTurnSkdVoyNo();
							String turnSkdDirCd 	= cstSkdByVvdVO.getTurnSkdDirCd();
							String vpsEtaDt 	    = cstSkdByVvdVO.getVpsEtaDt();
						
							/** Virtual Add Calling Port Indicator ******************/
							String vtAddCallFlg		= cstSkdByVvdVO.getVtAddCallFlg()==null?"":cstSkdByVvdVO.getVtAddCallFlg();
							
							int nTurnClptIndSeq 	= 0;	//count of port in Turnning VVD
							int nCallYdIndSeq 		= makeCallYardSeq(cstSkdByVvdVOs, currSeq);	//Yard Seq(count of yard in samd VVD)
							
							//================================================================================================================
							VskVslPortSkdVO curPortInfoVO = new VskVslPortSkdVO();
							curPortInfoVO.setIbflag		(ibFlag);
							curPortInfoVO.setVslCd		(vslCd);
							curPortInfoVO.setSkdVoyNo	(skdVoyNo);
							curPortInfoVO.setSkdDirCd	(skdDirCd);
							curPortInfoVO.setVpsPortCd	(vpsPortCd);
							curPortInfoVO.setClptIndSeq	(cstSkdByVvdVO.getClptIndSeq());
							curPortInfoVO.setSlanCd		(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
							curPortInfoVO.setYdCd		(ydCd);
							curPortInfoVO.setTurnPortFlg(turnPortFlg);
							
							/** Virtual Add Calling Port Indicator ******************/
							curPortInfoVO.setVtAddCallFlg(vtAddCallFlg);
							
							
							curPortInfoVOList.add		(curPortInfoVO);
							//================================================================================================================
							
							//================================================================================================================
							//[in case Data is changed after user retrieve START]
							if(originPortVoList != null && originPortVoList.size()>0){
								for(VskVslPortSkdVO vskVslPortSkdVO : originPortVoList){
									if(vpsPortCd.equals(vskVslPortSkdVO.getVpsPortCd()) && cstSkdByVvdVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq())){
										if(!cstSkdByVvdVO.getUpdDt().equals(vskVslPortSkdVO.getUpdDt())){
											throw new EventException(new ErrorHandler("VSK10077", new String[]{vskVslPortSkdVO.getUpdUsrId()}).getMessage());
										}
									}
								}
							}
							//[in case Data is changed after user retrieve END]
							//================================================================================================================
							
							/**
							 * Identify first direction
							 * 2015-12-17
							 */
							
							if("Y".equals(turnPortFlg) && isFirstTurningPortChk == false){
								isFirstTurningPort		= true;
								isFirstTurningPortChk	= true;
							}
							
							
							//:2015-12-17://turnPortIndCd = this.turnPortIndCdControl(turnPortIndCd, turnPortFlg, cstSkdByVvdVO.getPortRotnSeq(), cstSkdByVvdVO.getVslSlanCd(), skdDirCd, cstSkdByVvdVO.getClptSeq());
							turnPortIndCd = this.turnPortIndCdControl(cstSkdByVvdVO, isFirstTurningPort, turnPortIndCd, turnPortFlg, cstSkdByVvdVO.getPortRotnSeq(), cstSkdByVvdVO.getVslSlanCd(), skdDirCd, cstSkdByVvdVO.getClptSeq());
							
							String originTurnVoyNo = "";		// Original TurnVoyNo
							String originTurnDirCd = "";		// Original TurnDirCd
							
							if(originPortVoList != null && originPortVoList.size()>0){
								for(VskVslPortSkdVO vskVslPortSkdVO : originPortVoList){
									if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
										originTurnVoyNo = vskVslPortSkdVO.getTurnSkdVoyNo();
										originTurnDirCd = vskVslPortSkdVO.getTurnSkdDirCd();
										break;
									}
								}
							}
							
							//================================================================================================================
							// [Retrieving Virtual Port START]
							
							if("Y".equals(turnPortFlg)){
								// Tunning Port Validation(Compatibility Check).
								this.checkVskVslPortSkd(vslCd, skdVoyNo, skdDirCd, turnSkdVoyNo, turnSkdDirCd, vpsEtaDt);
								
								// Retrieving Virtual
								VskVslPortSkdVO virtualPortParamVO 	= new VskVslPortSkdVO();
								virtualPortParamVO.setVslCd			(vslCd);
								virtualPortParamVO.setSkdVoyNo		(turnSkdVoyNo);
								virtualPortParamVO.setSkdDirCd		(turnSkdDirCd);
								
								List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);
								
								// in case of first VVD, adding virtual port list of turning linked pre vvd to totalOrgPortList
								if(firstVVD){
									for(VskVslPortSkdVO vskVslPortSkdVO : virtualPortVoList){
										if(		"D".equals(vskVslPortSkdVO.getTurnPortIndCd()) ||
												"V".equals(vskVslPortSkdVO.getTurnPortIndCd()) ||
												"F".equals(vskVslPortSkdVO.getTurnPortIndCd()))
										{
												totalOrgPortList.add(vskVslPortSkdVO);
										}
									}
								}else{
									firstVVD = false;
								}
								
								// Judging Virtual Port Turn Indicator Code
								String virtualTurnPortIndCd = this.virtualTurnPortIndCdControl(cstSkdByVvdVO, virtualPortVoList.get(0).getSlanCd(), turnPortIndCd);
								
								//kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
								
								// Creating Virtual Vessel Port Schedule using inputted Turning Vvd, Port
								if(virtualPortVoList != null && virtualPortVoList.size() > 0){
									
									int preVvdExCnt  		= 0;	//count of port except virtual of pre vvd
									int virtualCallYdIndSeq = 0;
									String prePortCd 		= "";
									String virtualLaneCd 	= "";
									
									
									if(prePortInfoVOList != null && prePortInfoVOList.size() > 0){
										
										String delFlag = "";
										
										for(VskVslPortSkdVO prePortInfoVO : prePortInfoVOList){
											
											delFlag = prePortInfoVO.getIbflag();
											//not counting deleted data
											if(!"D".equals(delFlag)){
												preVvdExCnt++;
			
												prePortCd = prePortInfoVO.getVpsPortCd();
												if(vpsPortCd.equals(prePortCd)){
													nTurnClptIndSeq++;	//(= Virtual clpt_ind_seq)
												}
												
												if(ydCd.equals(prePortInfoVO.getYdCd())){
													virtualCallYdIndSeq++;
												}
											}
										}
										virtualLaneCd = prePortInfoVOList.get(0).getSlanCd();
										
									}else{
										
										// in case of creating virtual of first vvd
										String tmpTurnPortIndCd = "";
										String tmpVtAddCallFlg	= "";
										
										/******************************************************/
										for(VskVslPortSkdVO virtualPortVo : virtualPortVoList){
											tmpTurnPortIndCd = virtualPortVo.getTurnPortIndCd();
											tmpVtAddCallFlg		= virtualPortVo.getVtAddCallFlg	() == null?"":virtualPortVo.getVtAddCallFlg	();
											
											//not counting Virtual Port
											if(!VSKGeneralUtil.isVirtualPort(tmpTurnPortIndCd) && !"Y".equals(tmpVtAddCallFlg)){
												preVvdExCnt++;
			
												
												log.info("\n\n ===================== TOP.TOP.TOP << nTurnClptIndSeq >> TOP.TOP.TOP ================== \n\n");
												log.info("\n\n BEFORE :: prePortCd ["+prePortCd+"] VS vpsPortCd ["+vpsPortCd+"] >>> nTurnClptIndSeq ["+nTurnClptIndSeq+"]\n\n");
												
												
												prePortCd = virtualPortVo.getVpsPortCd();
												if(vpsPortCd.equals(prePortCd)){
													nTurnClptIndSeq++;	//(= Virtual clpt_ind_seq)
												}
												
												log.info("\n\n AFTER :: prePortCd ["+prePortCd+"] VS vpsPortCd ["+vpsPortCd+"] >>> nTurnClptIndSeq ["+nTurnClptIndSeq+"]\n\n");
												
												
												if(ydCd.equals(virtualPortVo.getYdCd())){
													virtualCallYdIndSeq++;
												}
											}
										}	
										/** ::END OF FOR LOOP using [virtualPortVoList] :: **/
										
										virtualLaneCd = virtualPortVoList.get(0).getSlanCd();
									}
									
									
									log.info("\n\n FINAL BEFORE :: ydCd ["+ydCd+"] --- nTurnClptIndSeq ["+nTurnClptIndSeq+"] VS newClptIndSeq ["+newClptIndSeq+"] \n\n");
									
									
									/****************************************************************************
									 ********** 2016-05-20 : by TOP TEMPORARY SETTING ***************************
									 * STARTED...................................................................
									 **************************************************************************** 
									 */
									//because adding port to Virtual Port, increasing clptIndSeq of Port
									/** [AS-IS] **/
									//nTurnClptIndSeq 	= getParsingTurnClptIndSeq(nTurnClptIndSeq, newClptIndSeq);
									
									int	nSameTurningPortKnt	= 0;
									
									for(CstSkdByVvdVO tmpVO : cstSkdByVvdVOs){ 
										
										if(		vslCd.equals		(tmpVO.getVslCd		()) 
											&&	skdVoyNo.equals		(tmpVO.getSkdVoyNo	()) 
											&&	skdDirCd.equals		(tmpVO.getSkdDirCd	())
											&&	vpsPortCd.equals	(tmpVO.getVpsPortCd	())
											&&	"Y".equals(tmpVO.getTurnPortFlg())
											)
										{
											nSameTurningPortKnt++;
											
											if(newClptIndSeq.equals(tmpVO.getNewClptIndSeq()))	break;
										}
									
									}

									log.info("\n\n FINAL BEFORE :: ydCd ["+ydCd+"] --- nTurnClptIndSeq ["+nTurnClptIndSeq+"] nSameTurningPortKnt ["+nSameTurningPortKnt+"] VS newClptIndSeq ["+newClptIndSeq+"] \n\n");
									
									/** [TO-BE] **/
									nTurnClptIndSeq 	= getParsingTurnClptIndSeq(nTurnClptIndSeq, String.valueOf(nSameTurningPortKnt));
									
									/****************************************************************************
									 ********** 2016-05-20 : by TOP TEMPORARY SETTING ***************************
									 * FINISHED .................................................................
									 **************************************************************************** 
									 */
									
									log.info("\n\n FINAL AFTER :: ydCd ["+ydCd+"] --- nTurnClptIndSeq ["+nTurnClptIndSeq+"] VS newClptIndSeq ["+newClptIndSeq+"] org turn_clpt_ind_seq ["+cstSkdByVvdVO.getTurnClptIndSeq()+"] \n\n");
									
									
									//:2016-08-03:byTOP://
									////cstSkdByVvdVO.setTurnClptIndSeq		(Integer.toString(nTurnClptIndSeq));
									////cstSkdByVvdVO.setNewTurnClptIndSeq	(Integer.toString(nTurnClptIndSeq));
									//:2016-08-03:byTOP://
									
									virtualCallYdIndSeq = virtualCallYdIndSeq + nCallYdIndSeq;
									
									// ****************************** Virtual Info ******************************
									VslPortSkdVO virtualPortVO = this.makeVirtualDataSet(	cstSkdByVvdVO
																						,	Integer.toString(nTurnClptIndSeq)
																						,	Integer.toString(preVvdExCnt + this.curTurnPortCnt(curPortInfoVOList))
																						,	virtualLaneCd
																						,	ydCd
																						,	Integer.toString(virtualCallYdIndSeq)
																						,	virtualTurnPortIndCd
																						,	userId
																						);

									
									
									
									log.info("\n\n ======= TOP.TOP.TOP.TOP.TOP ===================================");
									log.info("\n\n  VVD ["+virtualPortVO.getVslCd()+virtualPortVO.getSkdVoyNo()+virtualPortVO.getSkdDirCd()+"]   port ["+virtualPortVO.getVpsPortCd()+"] ["+virtualPortVO.getClptIndSeq()+"] turning indicator ["+virtualPortVO.getTurnPortIndCd()+"] clpt seq ["+virtualPortVO.getClptSeq()+"] org value  preVvdExCnt ["+preVvdExCnt+"] curTurnPortCnt ["+this.curTurnPortCnt(curPortInfoVOList)+"]");
									
									
									// ****************************** Virtual Delete Info ******************************
									// after delete, insert Virtual
									if(deleteVirtualPortVoList != null && deleteVirtualPortVoList.size() > 0){
										int voSize = deleteVirtualPortVoList.size();
										for(int n=0; n<voSize; n++){
											VskVslPortSkdVO delPortVO = deleteVirtualPortVoList.get(n);
											if(!	(	delPortVO.getVslCd().equals(vslCd) 
													&&	delPortVO.getSkdVoyNo().equals(turnSkdVoyNo)
													&&	delPortVO.getSkdDirCd().equals(turnSkdDirCd))
													)
											{
												VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
												virtualDelPortVO.setVslCd(vslCd);
												virtualDelPortVO.setSkdVoyNo(turnSkdVoyNo);
												virtualDelPortVO.setSkdDirCd(turnSkdDirCd);
												virtualDelPortVO.setSlanCd(virtualLaneCd);
												
												deleteVirtualPortVoList.add(virtualDelPortVO);
											}
											
											//if orginal virtual and inputted virtual are different, deleting orginal virtual
											if(!(turnSkdVoyNo.equals(originTurnVoyNo) && turnSkdDirCd.equals(originTurnDirCd))){
												if(!(delPortVO.getVslCd().equals(vslCd) 
														&& delPortVO.getSkdVoyNo().equals(originTurnVoyNo)
														&& delPortVO.getSkdDirCd().equals(originTurnDirCd))){
													VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
													virtualDelPortVO.setVslCd(vslCd);
													virtualDelPortVO.setSkdVoyNo(originTurnVoyNo);
													virtualDelPortVO.setSkdDirCd(originTurnDirCd);
													virtualDelPortVO.setSlanCd(virtualLaneCd);
													
													deleteVirtualPortVoList.add(virtualDelPortVO);
												}
											}
										}
										
									}else{
										
										VskVslPortSkdVO virtualDelPortVO = new VskVslPortSkdVO();
										virtualDelPortVO.setVslCd(vslCd);
										virtualDelPortVO.setSkdVoyNo(turnSkdVoyNo);
										virtualDelPortVO.setSkdDirCd(turnSkdDirCd);
										virtualDelPortVO.setSlanCd(virtualLaneCd);
										
										deleteVirtualPortVoList.add(virtualDelPortVO);
										
										//if orginal virtual and inputted virtual are different, deleting orginal virtual
										if(VSKGeneralUtil.isNotNull(originTurnVoyNo) && VSKGeneralUtil.isNotNull(originTurnDirCd)){
											if(!(turnSkdVoyNo.equals(originTurnVoyNo) && turnSkdDirCd.equals(originTurnDirCd))){
												VskVslPortSkdVO orgVirtualDelPortVO = new VskVslPortSkdVO();
												orgVirtualDelPortVO.setVslCd(vslCd);
												orgVirtualDelPortVO.setSkdVoyNo(originTurnVoyNo);
												orgVirtualDelPortVO.setSkdDirCd(originTurnDirCd);
												orgVirtualDelPortVO.setSlanCd(virtualLaneCd);
												
												deleteVirtualPortVoList.add(orgVirtualDelPortVO);
											}
										}
									}
									
									// ****************************** Virtual Insert Info ******************************
									//Blocking to create virtual port in case of deletion
									if(!"D".equals(ibFlag)){
										virtualPortVO.setCreDt(cstSkdByVvdVO.getCreDt());
										insertVirtualPortVoList.add(virtualPortVO);
									}
								}
							}
							//Handling in case of turnPortFlg :'Y' -> 'N'
							else if("N".equals(turnPortFlg)){
								if(VSKGeneralUtil.isNotNull(originTurnVoyNo) && VSKGeneralUtil.isNotNull(originTurnDirCd)){
									VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
									virtualPortParamVO.setVslCd(vslCd);
									virtualPortParamVO.setSkdVoyNo(originTurnVoyNo);
									virtualPortParamVO.setSkdDirCd(originTurnDirCd);
									
									// original Virtual Port
									List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);

									//Deleting Virtual Port in case of turnPortFlg :'Y' -> 'N'
									if(virtualPortVoList != null && virtualPortVoList.size() > 0){
										String orgVirtualTurnPortIndCd = "";
										String orgVirtualClptIndSeq = "";
										String orgVirtualVpsPortCd = "";
										for(VskVslPortSkdVO virtualPortVo : virtualPortVoList){
											orgVirtualTurnPortIndCd = virtualPortVo.getTurnPortIndCd();
											orgVirtualClptIndSeq = virtualPortVo.getClptIndSeq();
											orgVirtualVpsPortCd = virtualPortVo.getVpsPortCd();
											
											if(VSKGeneralUtil.isVirtualPort(orgVirtualTurnPortIndCd)){
												if(vpsPortCd.equals(orgVirtualVpsPortCd) && turnClptIndSeq.equals(orgVirtualClptIndSeq)){
													deleteVirtualPortVoList.add(virtualPortVo);
													nTurnClptIndSeq = 0;
													
													break;
												}
											}
										}
									}
								}
							}
							//[Retrieving Virtual Port END]
							//================================================================================================================
	
							//================================================================================================================
							//Modifying next port in case Virtual Port change
							//TURN_PORT_IND_CD IN ('F', 'V', 'D')
							if(VSKGeneralUtil.isVirtualPort(turnPortIndCd)){
								vitualSeq++;
								VskVslPortSkdVO nxtVskVslPortSkdVO = makeNextPortDataSet(cstSkdByVvdVO, newClptIndSeq, turnClptIndSeq, vitualSeq, userId);
								updateNextPortVoList.add(nxtVskVslPortSkdVO);
								
								if(VSKGeneralUtil.isNull(turnClptIndSeq)){
									nTurnClptIndSeq = 0;
								}else{
									nTurnClptIndSeq = Integer.parseInt(turnClptIndSeq);
								}
							}
							// End Next Port Setting...
							//================================================================================================================
							
							if(nTurnClptIndSeq == 0){
								turnClptIndSeq = "";
							}else{
								turnClptIndSeq = Integer.toString(nTurnClptIndSeq);
							}
	
							// ************************************ VskVslPortSkdVO Info ************************************
							VslPortSkdVO vslPortSkdVO = this.makeVskVslPortDataSet	(	cstSkdByVvdVO
																					, 	Integer.toString(nCallYdIndSeq)
																					, 	turnClptIndSeq
																					, 	turnPortIndCd
																					, 	userId
																					);
							
							
							if("I".equals(ibFlag)){
								vslPortSkdVO.setInitEtaDt(cstSkdByVvdVO.getVpsEtaDt());
								vslPortSkdVO.setInitEtbDt(cstSkdByVvdVO.getVpsEtbDt());
								vslPortSkdVO.setInitEtdDt(cstSkdByVvdVO.getVpsEtdDt());
								
								insertPortVoList.add(vslPortSkdVO);
							}else if ("U".equals(ibFlag)){
								vslPortSkdVO.setInitEtaDt(cstSkdByVvdVO.getInitEtaDt());
								vslPortSkdVO.setInitEtbDt(cstSkdByVvdVO.getInitEtbDt());
								vslPortSkdVO.setInitEtdDt(cstSkdByVvdVO.getInitEtdDt());

//::2015-02-16 commented by TOP:://								
/*								boolean findSamePort = false;
								for(CstSkdByVvdVO vo : cstSkdByVvdVOs){
									if(
											vo.getVpsPortCd().equals(vpsPortCd) &&
											vo.getClptIndSeq().equals(newClptIndSeq) &&
											!vo.getIbflag().equals("D")){
										findSamePort = true;
										vslPortSkdVO.setClptIndSeq(newClptIndSeq);
										break;
									}
								}
								
								if(findSamePort){
									updatePortDataList.add(vslPortSkdVO);
								}else{
									updatePortVoList.add(vslPortSkdVO);									
								}*/
								
								
								boolean isSameVVDTerminal 	= false;
								for(CstSkdByVvdVO vo : cstSkdByVvdVOs){
									
									/*****************************************************************************
									 * cstSkdByVvdVOs���붾㈃�꾩껜��vvd+port list�닿린�뚮Ц��vvd瑜��쒖뼱臾몄뿉 �ы븿�섏� �딅뒗寃쎌슦 pre-vvd��virtual port媛�議곌굔��嫄몃━湲곕븣臾몄뿉
									 * insert/update �깆쓽 援щ텇���섎せ �먮떒�����덉쓬.
									 *****************************************************************************/
									
									if(		vo.getVslCd		().equals(vslCd)			&&	//異붽�::2013/04/01:://
											vo.getSkdVoyNo	().equals(skdVoyNo)			&&	//異붽�::2013/04/01:://
											vo.getSkdDirCd	().equals(skdDirCd)			&&	//異붽�::2013/04/01:://
											vo.getVpsPortCd	().equals(vpsPortCd) 		&&
											vo.getClptIndSeq().equals(newClptIndSeq) 	&&
											!vo.getIbflag	().equals("D"))
									{						
										
										/*************************************************************************
										 * CLPT_IND_SEQ(PK) 蹂�꼍 CASE
										 * 1. REVERSE CALL	: PK 蹂�꼍遺덇�(DUP.) 		> PK�댁쇅���곗씠�곕쭔 蹂�꼍泥섎━
										 * 2. ADD CALL		: PK 蹂�꼍�꾩슂 or 遺덊븘��> PK�낅뜲�댄듃泥섎━
										 *    - ADD CALL.CLPT_IND_SEQ < ORG.CLPT_IND_SEQ PK �낅뜲�댄듃泥섎━
										 *    - ADD CALL.CLPT_IND_SEQ > ORG.CLPT_IND_SEQ PK �낅뜲�댄듃�쒖쇅/�곗씠�곕쭔 �낅뜲�댄듃
										 *************************************************************************/
										int		iTmpCurInsertRowClptIndSeq		= 0;
										int		iTmpMinInsertRowClptIndSeq		= 0;
										
										for(CstSkdByVvdVO tmpVo : cstSkdByVvdVOs)
										{
											if	( 	tmpVo.getVslCd		().equals(vslCd		)	&&	
													tmpVo.getSkdVoyNo	().equals(skdVoyNo	)	&&	
													tmpVo.getSkdDirCd	().equals(skdDirCd	)	&&	
													tmpVo.getVpsPortCd	().equals(vpsPortCd	)	&&
													tmpVo.getIbflag		().equals("I")
												)
											{
												iTmpCurInsertRowClptIndSeq		= Integer.parseInt(tmpVo.getNewClptIndSeq());
												if(iTmpMinInsertRowClptIndSeq == 0)								iTmpMinInsertRowClptIndSeq	= iTmpCurInsertRowClptIndSeq;
												if(iTmpCurInsertRowClptIndSeq < iTmpMinInsertRowClptIndSeq)		iTmpMinInsertRowClptIndSeq	= iTmpCurInsertRowClptIndSeq;
											}
										}
											
										if(iTmpMinInsertRowClptIndSeq > 0 && (Integer.parseInt(newClptIndSeq) > iTmpMinInsertRowClptIndSeq)){

											if(!vo.getClptIndSeq().equals(vo.getNewClptIndSeq())){
												////::dbDao.modifyVskVslPortSkd 			��긽�대맖	::CLPT_IND_SEQ 蹂�꼍-Add Calling�깆쑝濡��명븳 Tml 異붽�:://
												isSameVVDTerminal = false;
												break;
											}
										}
										
										isSameVVDTerminal = true;
										vslPortSkdVO.setClptIndSeq(newClptIndSeq);
										break;
									}
								}
								
								
								if(isSameVVDTerminal){
									updatePortDataList.add	(vslPortSkdVO);
									/*********************************************************************
									 * ::dbDao.modifyVskVslPortSkdDataOnly 	��긽�대맖	::CLPT_IND_SEQ �좎�
									 * 	 > VesselScheduleMgtDBDAOModifyVskVslPortDataOnlyUSQL
									 *********************************************************************/
								}else{
									updatePortVoList.add	(vslPortSkdVO);
									/*********************************************************************
									 * ::dbDao.modifyVskVslPortSkd 			��긽�대맖	::CLPT_IND_SEQ 蹂�꼍
									 *   > VesselScheduleMgtDBDAOModifyVskVslPortSkdUSQL
									 *********************************************************************/
								}								
								
								
//::2015-02-16 commented by TOP:://									
								
							}else if ("D".equals(ibFlag)){
								if(isFirstPort){
									// Checking Booking
									VvdVO vvdVO = new VvdVO();
									vvdVO.setVslCd(vslCd);
									vvdVO.setSkdVoyNo(skdVoyNo);
									vvdVO.setSkdDirCd(skdDirCd);
									int chkCnt = dbDao.checkVvdApplyBooking(vvdVO);
									if(chkCnt > 0){
										String curDate = VSKGeneralUtil.replaceDateTypeToString(JSPUtil.getKSTDate());
										String etaDt = cstSkdByVvdVO.getVpsEtaDt().substring(0, 8);
										long dateL = VSKGeneralUtil.dateDiff(curDate, "yyyyMMdd", etaDt, "yyyyMMdd", "d");
										if(Math.abs(dateL) <= 3){
											String[] errMsgs = new String[]{vslCd + skdVoyNo + skdDirCd};
											throw new EventException(new ErrorHandler("VSK10075", errMsgs).getMessage());
										}
									}
								}
								deletePortVoList.add(vslPortSkdVO);
								
								//to transmit virtual to ERP in case Turnning Port delete
								if("Y".equals(vslPortSkdVO.getTurnPortFlg())){
									VskVslPortSkdVO tmpVO = new VskVslPortSkdVO();
									tmpVO.setVslCd(vslPortSkdVO.getVslCd());
									tmpVO.setSkdVoyNo(vslPortSkdVO.getTurnSkdVoyNo());
									tmpVO.setSkdDirCd(vslPortSkdVO.getTurnSkdDirCd());
									tmpVO.setSlanCd(VSKGeneralUtil.nvl(cstSkdByVvdVO.getSlanCd(), cstSkdByVvdVO.getVslSlanCd()));
									
									deleteVirtualPortERPVoList.add(tmpVO);
								}
							}
						}
						
						isFirstPort = false;
						currSeq++;
						
					}// end for(Port)
					
				}// end for(Master)		
				
				
				// ***************** History START *****************
				List<VslSkdHisInVO> vslSkdHisInVOs 	= this.makeHistoryDataSetByCoastal	(cstSkdByVvdVOs, insertVirtualPortVoList, updateNextPortVoList, userId);
				vslSkdChgStsGRPVO 					= this.manageVslSkdChgSts			(vslSkdHisInVOs);
				// ***************** History  END  *****************
				
				
				//=============== VSK_VSL_SKD [INSERT, UPDATE]===============
				if(insertVoList != null && insertVoList.size() > 0){
					//Checking VSK_VSL_SKD
					VskVslSkdVO chkVO = insertVoList.get(0);
					int chkCnt = dbDao.checkVvd(chkVO);
					if(chkCnt > 0){
						throw new EventException(new ErrorHandler("VSK10017").getMessage());
					}else{
						dbDao.addVskVslSkd(insertVoList);
						// :: VIPS START ::
						// System.out.println("VIPS[addVskVslSkd2]");
						for(VskVslSkdVO vo : insertVoList) {
							List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
							for(VskVslSkdVO row : list) {
								this.mVskVslSkdList.add(row);
							}
						}
						// :: VIPS END ::
					}
				}
				
				if(updateVoList != null && updateVoList.size() > 0){
					dbDao.modifyVskVslSkd(updateVoList);
					// :: VIPS START ::
					// System.out.println("VIPS[modifyVskVslSkd1]");
					for(VskVslSkdVO vo : updateVoList) {
						List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
						for(VskVslSkdVO row : list) {
							this.mVskVslSkdList.add(row);
						}
					}
					// :: VIPS END ::
				}
				
				//=============== VSK_VSL_PORT_SKD ===============
				//Deleting Vessel Port SKD in case TURN_PORT_IND_CD in 'D','V','F' of inputted turning vvd
				
				if (log.isDebugEnabled()) {
					log.debug("********************************** deleteVirtualPortVoList START *******************************************");
					log.debug("SIZE ==>" + deleteVirtualPortVoList.size());
				}
				if(deleteVirtualPortVoList != null && deleteVirtualPortVoList.size() > 0){
					// :: VIPS START ::
					// System.out.println("VIPS[removeVskVslPortSkdByVirtualPort1]");
					for(VskVslPortSkdVO vo : deleteVirtualPortVoList) {
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
					dbDao.removeVskVslPortSkdByVirtualPort(deleteVirtualPortVoList);

				}
				
				if (log.isDebugEnabled()) {					
					log.debug("********************************** deleteVirtualPortVoList END *******************************************");
				}
				/* 2015.01.15 DONGSOO
				 * act skd��긽�대㈃ �꾨옒��媛숈� �щ㎎�쇰줈 �ㅻ쪟 MSG
				 * [HJXX0001E-KRPUS], [HJXX0001E-USLAX], [HJXX0001E-USOAK] 
				 */
				boolean actSkd = false;
				String  rtnMsg = "";
				if(deletePortVoList != null && deletePortVoList.size() > 0){
					for(VslPortSkdVO vo : deletePortVoList) {
						int cnt = dbDao.checkVskActPortSkd(vo);
						if (cnt > 0) {
							if ("".equals(rtnMsg)) {
								rtnMsg = "[" + vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() + "-" + vo.getVpsPortCd()+ "]";
							} else {
								rtnMsg = rtnMsg + ":" + "[" + vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() + "-" + vo.getVpsPortCd()+ "]";
							}							
							actSkd = true;
						}
					}
				}
				
				if (actSkd) {
					throw new EventException(new ErrorHandler().getMessage() +"ACT:"+ rtnMsg+":ACT", null);
				}
				
				if(deletePortVoList != null && deletePortVoList.size() > 0){
					// :: VIPS START ::
					// System.out.println("VIPS[removeVskVslPortSkd1]");
					for(VslPortSkdVO vslPortSkdVO : deletePortVoList) {
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vslPortSkdVO.getVslCd());
						vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
						vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
					dbDao.removeVskVslPortSkd(deletePortVoList);
					
					for(VslPortSkdVO vslPortSkdVO : deletePortVoList) {
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vslPortSkdVO.getVslCd());
						vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
						vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mDelNextVslPortSkdList.add(row);
						}
						vo.setSkdDirCd("");
						List<VskVslPortSkdVO> list2 = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list2) {
							this.mDelNextDirVslPortSkdList.add(row);
						}
					}
				}
				
				
				/******************************************************************************
				 *  [VesselScheduleMgtDBDAOModifyVskVslPortSkdUSQL] 
				 * 	CASE 1 : If there is "I" (to be inserted), firstly it will be updated in case of changing CLPT_IND_SEQ
				 * 			 And then, it will be updated in reverse.
				 * 			 > tmpPoList
				 *  CASE 2 : If there is "D" to be deleted, it will be updated sequentially.
				 *  		 > updatePortVoList
				 *  CASE 3 : It there is not to be inserted, it will be updated sequentially.
				 *  		 > updatePortVoList
				 ******************************************************************************/
				if(updatePortVoList != null && updatePortVoList.size() > 0){
					if(insertPortVoList != null && insertPortVoList.size() > 0){
						if(deletePortVoList != null && deletePortVoList.size() > 0){
							dbDao.modifyVskVslPortSkd(updatePortVoList);
							// :: VIPS START ::
							// System.out.println("VIPS[modifyVskVslPortSkd1]");
							for(VslPortSkdVO vslPortSkdVO : updatePortVoList) {
								VskVslPortSkdVO vo = new VskVslPortSkdVO();
								vo.setVslCd(vslPortSkdVO.getVslCd());
								vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
								vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
								vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
								vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
								List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
								for(VskVslPortSkdVO row : list) {
									this.mVslPortSkdList.add(row);
								}									

							}
							// :: VIPS END ::

						}else{
							List<VslPortSkdVO> tmpPoList = new ArrayList<VslPortSkdVO>();
							int tmpCnt = updatePortVoList.size(); 
							for(int k=tmpCnt; k>0; k--){
								VslPortSkdVO tmpVO = updatePortVoList.get(k-1);
								tmpPoList.add(tmpVO);
							}
							
							dbDao.modifyVskVslPortSkd(tmpPoList);
							// :: VIPS START ::
							// System.out.println("VIPS[modifyVskVslPortSkd2]");
							for(VslPortSkdVO vslPortSkdVO : tmpPoList) {
								VskVslPortSkdVO vo = new VskVslPortSkdVO();
								vo.setVslCd(vslPortSkdVO.getVslCd());
								vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
								vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
								vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
								vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
								List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
								for(VskVslPortSkdVO row : list) {
									this.mVslPortSkdList.add(row);
								}
							}
							// :: VIPS END ::
						}
					
					}else{

						dbDao.modifyVskVslPortSkd(updatePortVoList);
						// :: VIPS START ::
						// System.out.println("VIPS[modifyVskVslPortSkd3]");
						for(VslPortSkdVO vslPortSkdVO : updatePortVoList) {
							VskVslPortSkdVO vo = new VskVslPortSkdVO();
							vo.setVslCd(vslPortSkdVO.getVslCd());
							vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
							vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
							vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
							vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
							List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
							
							for(VskVslPortSkdVO row : list) {
								this.mVslPortSkdList.add(row);
							}
						}
						// :: VIPS END ::
					}
				}
				/******************************************************************************/
				
				
				if(updatePortDataList != null && updatePortDataList.size() > 0){
					dbDao.modifyVskVslPortSkdDataOnly(updatePortDataList);
					// :: VIPS START ::
					// System.out.println("VIPS[modifyVskVslPortSkdDataOnly1]");
					
					List<VslPortSkdVO> listSkip	= new ArrayList<VslPortSkdVO>();
					
					for(VslPortSkdVO vslPortSkdVO : updatePortDataList) {
						
						String sTmpSkdCngStsCd		= vslPortSkdVO.getSkdCngStsCd() == null ? "" : vslPortSkdVO.getSkdCngStsCd();
						if("S".equals(sTmpSkdCngStsCd)){
							listSkip.add(vslPortSkdVO);
						}
						
						VskVslPortSkdVO 	vo 		= new VskVslPortSkdVO		();
						vo.setVslCd					(vslPortSkdVO.getVslCd		());
						vo.setSkdVoyNo				(vslPortSkdVO.getSkdVoyNo	());
						vo.setSkdDirCd				(vslPortSkdVO.getSkdDirCd	());
						
						List<VskVslPortSkdVO> tmpList 	= dbDao.searchVskVslPortSkdByVVD(vo);
						List<VskVslPortSkdVO> list		= new ArrayList<VskVslPortSkdVO>();
						
						for(VskVslPortSkdVO tmpVO1:tmpList){
							for(VslPortSkdVO tmpVO2:listSkip){
								if(		tmpVO1.getVslCd		().equals(tmpVO2.getVslCd		())
									&&	tmpVO1.getSkdVoyNo	().equals(tmpVO2.getSkdVoyNo	())
									&&	tmpVO1.getSkdDirCd	().equals(tmpVO2.getSkdDirCd	())
									&&	tmpVO1.getVpsPortCd	().equals(tmpVO2.getVpsPortCd	())
									&&	tmpVO1.getClptIndSeq().equals(tmpVO2.getClptIndSeq	())){
									
									tmpVO1.setSkdCngStsCd("S");	
								}
							}
							list.add(tmpVO1);
						}
						
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
				}
				
				if(updateNextPortVoList != null && updateNextPortVoList.size() > 0){
					dbDao.modifyVskVslPortSkdByNextPort(updateNextPortVoList);
					// :: VIPS START ::
					// System.out.println("VIPS[modifyVskVslPortSkdByNextPort1]");
					for(VskVslPortSkdVO vo : updateNextPortVoList) {
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
				}
				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://if(insertPortVoList != null && insertPortVoList.size() > 0){
				//::by TOP:2015-05-08:://	dbDao.addVskVslPortSkd(insertPortVoList);
				//::by TOP:2015-05-08:://}
				
				if(insertPortVoList != null && insertPortVoList.size() > 0){
					
					dbDao.addVskVslPortSkd(insertPortVoList);
					//::2016-04-13://dbDao.addVskVslPortSkdCoastalUpdate	(insertPortVoList);
					
					
					// :: VIPS START ::
					// System.out.println("VIPS[addVskVslPortSkd2]");
					for(VslPortSkdVO vslPortSkdVO : insertPortVoList) {
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vslPortSkdVO.getVslCd());
						vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
//						vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
//						vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
					
					/******************************************************************
					 * Vessel Schedule Change History �앹꽦 :: 2013-08-08
					 * ----------------------------------------------------------------
					 * Insert & Update媛��숈떆��諛쒖깮�섍린 �뚮Ц��UpdateVO媛��녿뒗寃쎌슦�먮쭔
					 * �좉퇋�앹꽦(Insert)����븳 History �곗씠���앹꽦��
					 */
					if(updateVoList == null || updateVoList.size()==0){
						
						/* ============================================================================
						 * Vessel Schedule History 愿�━(Header+Detail) Started ::2013-07-30::
						 * ----------------------------------------------------------------------------
						 * <TABLE NAME>
						 * VSK_VSL_SKD_HIS
						 * ============================================================================
						 */
						//log.info("\n\n ::jskjskjsk::[history+detail] insertPortVoList [INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)] started!!! :: \n");
			
						List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
						
						String				sVslSlanCd		= null;
						String				sVslCd			= null;
						String				sSkdVoyNo		= null;
						String				sSkdDirCd		= null;
						
						for(int k=0; k<insertPortVoList.size(); k++){
							
							VslPortSkdVO	tmpVO			= new VslPortSkdVO	();
							tmpVO							= insertPortVoList.get(k);
							VslSkdXtraHisVO	tmpXtraHisVO	= new VslSkdXtraHisVO();
							
							sVslSlanCd						= tmpVO.getSlanCd	();
							sVslCd							= tmpVO.getVslCd	();
							sSkdVoyNo						= tmpVO.getSkdVoyNo	();
							sSkdDirCd						= tmpVO.getSkdDirCd	();
								
							if(k==0){
								
								tmpXtraHisVO.setVskdTpCd		("P");				/** 'M':VVD Schedule, 'P':Port Schedule **/
								tmpXtraHisVO.setVskdCngTpCd		("U");				/** 'U':Normal Update					**/
								tmpXtraHisVO.setBkgAtchFlg		("N");
								tmpXtraHisVO.setBfrVslSlanCd	(sVslSlanCd			);
								tmpXtraHisVO.setBfrVslCd		(sVslCd				);
								tmpXtraHisVO.setBfrSkdVoyNo		(sSkdVoyNo			);
								tmpXtraHisVO.setBfrSkdDirCd		(sSkdDirCd			);
								tmpXtraHisVO.setUpdUsrId		(account.getUsr_id	());
								vslSkdXtraHisVOs.add			(tmpXtraHisVO		);
								
							}else{
								
								int iDupKnt		= 0;
								for(VslSkdXtraHisVO tmpVO3 : vslSkdXtraHisVOs){
									if(		sVslCd.equals	(tmpVO3.getBfrVslCd		())
										&&	sSkdVoyNo.equals(tmpVO3.getBfrSkdVoyNo	())
										&&	sSkdDirCd.equals(tmpVO3.getBfrSkdDirCd	())
										)
									{
										iDupKnt++;
									}
								}
								if(iDupKnt == 0){
									
									tmpXtraHisVO.setVskdTpCd		("P");				/** 'M':VVD Schedule, 'P':Port Schedule **/
									tmpXtraHisVO.setVskdCngTpCd		("U");				/** 'U':Normal Update					**/
									tmpXtraHisVO.setBkgAtchFlg		("N");
									tmpXtraHisVO.setBfrVslSlanCd	(sVslSlanCd			);
									tmpXtraHisVO.setBfrVslCd		(sVslCd				);
									tmpXtraHisVO.setBfrSkdVoyNo		(sSkdVoyNo			);
									tmpXtraHisVO.setBfrSkdDirCd		(sSkdDirCd			);
									tmpXtraHisVO.setUpdUsrId		(account.getUsr_id	());
									vslSkdXtraHisVOs.add			(tmpXtraHisVO		);
									
								}
							}
							
							
						}
						//this.createVslSkdChangeHistory(vskVslSkdVOs, null, "INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)");	
						/****************************************************************
						 * �댄빆�ㅼ�伊��대젰愿�━瑜��꾪븳 VO or VO List Setting ::2013-08-28::
						 */
						hmVslSkdXtraHisVOs.put("INSERT_CST_ByVvd_NormalPort", vslSkdXtraHisVOs);
						
						//log.info("\n\n ::jskjskjsk::[history+detail]insertPortVoList [INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)] finished!!! :: \n");
						/* ----------------------------------------------------------------------------
						 * Vessel Schedule History 愿�━(Header+Detail) Finished ::2013-07-30::
						 * ============================================================================
						 */			
						
					}
					
				}				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				

				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://if(insertVirtualPortVoList != null && insertVirtualPortVoList.size() > 0){
				//::by TOP:2015-05-08:://	dbDao.addVskVslPortSkd(insertVirtualPortVoList);
				//::by TOP:2015-05-08:://}
				
				if(insertVirtualPortVoList != null && insertVirtualPortVoList.size() > 0){
					
					for(int inx=0; inx<insertVirtualPortVoList.size(); inx++){
						
						if(		insertVirtualPortVoList.get(inx).getTurnPortIndCd() != null 
							&&	(		"D".equals(insertVirtualPortVoList.get(inx).getTurnPortIndCd())
									||	"V".equals(insertVirtualPortVoList.get(inx).getTurnPortIndCd())
									||	"F".equals(insertVirtualPortVoList.get(inx).getTurnPortIndCd())
								)
																
							){
								insertVirtualPortVoList.get(inx).setFirstVirPortFlg("Y");	
								break;
							}
						
					}
					
					dbDao.addVskVslPortSkd	(insertVirtualPortVoList);
					//::2016-04-13://dbDao.addVskVslPortSkdCoastalUpdate	(insertVirtualPortVoList);
					
					// :: VIPS START ::
					// System.out.println("VIPS[addVskVslPortSkd3]");
					for(VslPortSkdVO vslPortSkdVO : insertPortVoList) {
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vslPortSkdVO.getVslCd());
						vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
						vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
					
					/*******************************************************************
					 * Correction clpt_seq in case VVD which is included virtual add calling port 
					 *   > VesselScheduleMgtDBDAOUpdateClptSeqforVirtualAddCallOnlyUSQL
					 * Added by TOP : 13JUL
					 *******************************************************************/
					dbDao.correctClptSeqforVirtualAddCallOnly(insertVirtualPortVoList.get(0));
					
					/*******************************************************************/
					
					// :: VIPS START ::
					// System.out.println("VIPS[correctClptSeqforVirtualAddCallOnly1]");
					VslPortSkdVO vslPortSkdVO = insertVirtualPortVoList.get(0);
					VskVslPortSkdVO vo = new VskVslPortSkdVO();
					vo.setVslCd(vslPortSkdVO.getVslCd());
					vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
					vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
					List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
					for(VskVslPortSkdVO row : list) {
						this.mVslPortSkdList.add(row);
					}
					// :: VIPS END ::

					/******************************************************************
					 * Vessel Schedule Change History �앹꽦 :: 2013-08-08
					 * ----------------------------------------------------------------
					 * Insert & Update媛��숈떆��諛쒖깮�섍린 �뚮Ц��UpdateVO媛��녿뒗寃쎌슦�먮쭔
					 * �좉퇋�앹꽦(Insert)����븳 History �곗씠���앹꽦��
					 */
					if(updateVoList == null || updateVoList.size()==0){
						
						/* ============================================================================
						 * Vessel Schedule History 愿�━(Header+Detail) Started ::2013-07-30::
						 * ----------------------------------------------------------------------------
						 * <TABLE NAME>
						 * VSK_VSL_SKD_HIS
						 * ============================================================================
						 */
						//log.info("\n\n ::jskjskjsk::[history+detail] insertPortVoList [INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)] started!!! :: \n");
			
						List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
						String					sVslSlanCd			= null;
						String					sVslCd				= null;
						String					sSkdVoyNo			= null;
						String					sSkdDirCd			= null;
						
						for(int k=0; k<insertVirtualPortVoList.size(); k++){
							VslPortSkdVO	tmpVO			= new VslPortSkdVO	();
							VslSkdXtraHisVO	tmpXtraHisVO	= new VslSkdXtraHisVO();
							tmpVO							= insertPortVoList.get(k);
							
							sVslSlanCd						= tmpVO.getSlanCd	();
							sVslCd							= tmpVO.getVslCd	();
							sSkdVoyNo						= tmpVO.getSkdVoyNo	();
							sSkdDirCd						= tmpVO.getSkdDirCd	();
								
							if(k==0){
								
								tmpXtraHisVO.setVskdTpCd		("P");				/** 'M':VVD Schedule, 'P':Port Schedule **/
								tmpXtraHisVO.setVskdCngTpCd		("M");				/** 'U':Normal Update					**/
								tmpXtraHisVO.setBkgAtchFlg		("N");
								tmpXtraHisVO.setBfrVslSlanCd	(sVslSlanCd			);
								tmpXtraHisVO.setBfrVslCd		(sVslCd				);
								tmpXtraHisVO.setBfrSkdVoyNo		(sSkdVoyNo			);
								tmpXtraHisVO.setBfrSkdDirCd		(sSkdDirCd			);
								tmpXtraHisVO.setUpdUsrId		(account.getUsr_id	());
								vslSkdXtraHisVOs.add			(tmpXtraHisVO		);	
								
							}else{
								int iDupKnt		= 0;
								for(VslSkdXtraHisVO tmpVO3 : vslSkdXtraHisVOs){
									if(		sVslCd.equals	(tmpVO3.getBfrVslCd		())
										&&	sSkdVoyNo.equals(tmpVO3.getBfrSkdVoyNo	())
										&&	sSkdDirCd.equals(tmpVO3.getBfrSkdDirCd	())
										)
									{
										iDupKnt++;
									}
								}
								if(iDupKnt == 0){
									
									tmpXtraHisVO.setVskdTpCd		("P");				/** 'M':VVD Schedule, 'P':Port Schedule **/
									tmpXtraHisVO.setVskdCngTpCd		("M");				/** 'U':Normal Update					**/
									tmpXtraHisVO.setBkgAtchFlg		("N");
									tmpXtraHisVO.setBfrVslSlanCd	(sVslSlanCd			);
									tmpXtraHisVO.setBfrVslCd		(sVslCd				);
									tmpXtraHisVO.setBfrSkdVoyNo		(sSkdVoyNo			);
									tmpXtraHisVO.setBfrSkdDirCd		(sSkdDirCd			);
									tmpXtraHisVO.setUpdUsrId		(account.getUsr_id	());
									vslSkdXtraHisVOs.add			(tmpXtraHisVO		);
								}
							}
						}
						//this.createVslSkdChangeHistory(vskVslSkdVOs, null, "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)");	
						
						/****************************************************************
						 * �댄빆�ㅼ�伊��대젰愿�━瑜��꾪븳 VO or VO List Setting ::2013-08-28::
						 */
						hmVslSkdXtraHisVOs.put("INSERT_CST_ByVvd_VirtualPort", vslSkdXtraHisVOs);
						
						//log.info("\n\n ::jskjskjsk::[history+detail]insertPortVoList [INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)] finished!!! :: \n");
						/* ----------------------------------------------------------------------------
						 * Vessel Schedule History 愿�━(Header+Detail) Finished ::2013-07-30::
						 * ============================================================================
						 */			
						
					}
					
				}				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				
				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				if(updateVoList != null && updateVoList.size() > 0){
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByVvd] started!!! :: \n");
	
					//this.createVslSkdChangeHistory(updateVoList, vslSkdCngHisDtlVOs, "UPDATE_CST_ByVvd");	
					
					/****************************************************************
					 * �댄빆�ㅼ�伊��대젰愿�━瑜��꾪븳 VO or VO List Setting ::2013-08-28::
					 */
					//::by TOP:2015-05-08:://vslSkdXtraHisGroupVO.setVskVslSkdVOs		(updateVoList		);
					//::jskjskjsk::2013-11-28:://vslSkdCngHistGroupVO.setVslSkdCngHisDtlVOs	(vslSkdCngHisDtlVOs	);
					vslSkdXtraHisGroupVO.setVslSkdXtraHisVOs	(vslSkdChgStsGRPVO.getVslSkdXtraHisVOs());
					vslSkdXtraHisGroupVO.setFromEventSystem		("UPDATE_CST_ByVvd"	);
				
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByVvd] finished!!! :: \n");
				}
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				
				
				//=============== VSK_VSL_SKD [DELETE] ===============
				if(deleteVoList != null && deleteVoList.size() > 0){
					/*
					 * Creating History when VVD delete regardless of booking
					 */
					for(VskVslSkdVO vskVslSkdVO : deleteVoList){

						VskVslSkdHisVO vskVslSkdDelHisVO 	= new VskVslSkdHisVO();
						vskVslSkdDelHisVO.setBfrVslCd		(vskVslSkdVO.getVslCd());
						vskVslSkdDelHisVO.setBfrSkdVoyNo	(vskVslSkdVO.getSkdVoyNo());
						vskVslSkdDelHisVO.setBfrSkdDirCd	(vskVslSkdVO.getSkdDirCd());
						vskVslSkdDelHisVO.setBfrVslSlanCd	(vskVslSkdVO.getVslSlanCd());
						
						vskVslSkdDelHisVO.setBfrPfSvcTpCd	(vskVslSkdVO.getPfSkdTpCd());
						
						vskVslSkdDelHisVO.setCreUsrId		(vskVslSkdVO.getCreUsrId());
						vskVslSkdDelHisVO.setUpdUsrId		(vskVslSkdVO.getUpdUsrId());
						
						addVskVslSkdDelHis					(vskVslSkdDelHisVO);
					}
					
					
					//::by TOP:2015-05-08:://
					/* ============================================================================
					 * Creation for Vessel Schedule History ::2015-05-08::
					 * ----------------------------------------------------------------------------
					 * <TABLE NAME>
					 * VSK_VSL_SKD_HIS
					 * ============================================================================
					 */
					//this.createVskVslSkdChangeHistoryMstOnly(deleteVoList, "DELETE_CST_ByVvd");
					
					List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
					for(int i=0; i<deleteVoList.size(); i++){
						VslSkdXtraHisVO	tmpVO				= new VslSkdXtraHisVO();
						VskVslSkdVO		tmpVskVslSkdVO		= deleteVoList.get(i);
						
						tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
						tmpVO.setVskdCngTpCd	("D");							/** 'D':VVD Deletion					**/
						tmpVO.setBkgAtchFlg		("N");
						tmpVO.setBfrVslSlanCd	(tmpVskVslSkdVO.getVslSlanCd	());
						tmpVO.setBfrVslCd		(tmpVskVslSkdVO.getVslCd		());
						tmpVO.setBfrSkdVoyNo	(tmpVskVslSkdVO.getSkdVoyNo		());
						tmpVO.setBfrSkdDirCd	(tmpVskVslSkdVO.getSkdDirCd		());
						tmpVO.setUpdUsrId		(account.getUsr_id				());
						vslSkdXtraHisVOs.add	(tmpVO);				
					}
					
					this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "DELETE_CST_ByVvd(0014/0015/0057/0058)");
					//::by TOP:2015-05-08:://
					
					dbDao.removeVskVslSkd(deleteVoList);
					// :: VIPS START ::
					// System.out.println("VIPS[removeVskVslSkd1]");
					for(VskVslSkdVO vo : deleteVoList) {
						List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
						for(VskVslSkdVO row : list) {
							this.mVskVslSkdList.add(row);
						}
					}
					// :: VIPS END ::

				}
				
				//===================== Setting for EDI ========================
				List<VvdVO> ediVvdVOs = new ArrayList<VvdVO>();
	
				// in case of add VVD
				ediVvdVOs = setTransObjectByVvd(ediVvdVOs, insertVoList, "I");
				
				// in case of Add Port
				if(insertPortVoList != null && insertPortVoList.size() > 0){
					for(VslPortSkdVO vslPortSkdVO : insertPortVoList){
						VvdVO vvdVO = new VvdVO();
						vvdVO.setIbflag("I");
						vvdVO.setVslCd(vslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vslPortSkdVO.getSlanCd());
						
						if(!isCheckObjectByVvd(ediVvdVOs, vvdVO)){
							ediVvdVOs.add(vvdVO);
						}
					}
				}
				
				for(VslPortSkdVO virVslPortSkdVO : insertVirtualPortVoList){
					
					
					boolean newVirPort = true;
					
					if(totalOrgPortList != null && totalOrgPortList.size()>0){
					
					for(VskVslPortSkdVO vskVslPortSkdVO : totalOrgPortList){
						if(	(virVslPortSkdVO.getVslCd().equals(vskVslPortSkdVO.getVslCd())) &&
								(virVslPortSkdVO.getSkdVoyNo().equals(vskVslPortSkdVO.getSkdVoyNo())) &&
								(virVslPortSkdVO.getSkdDirCd().equals(vskVslPortSkdVO.getSkdDirCd())) &&
								(virVslPortSkdVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd())) &&
								(virVslPortSkdVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq()))){
							newVirPort = false;
							break;
						}
					}
					
					}
					
					if(newVirPort){
						VvdVO vvdVO = new VvdVO();
						vvdVO.setIbflag("I");
						vvdVO.setVslCd(virVslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(virVslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(virVslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(virVslPortSkdVO.getSlanCd());
						
						if(!isCheckObjectByVvd(ediVvdVOs, vvdVO)){
							ediVvdVOs.add(vvdVO);
						}
					}
				}
				
				for(VvdVO vvdVO : ediVvdVOs){
					if(VSKGeneralUtil.isNull(vvdVO.getCreUsrId())){
						vvdVO.setCreUsrId(userId);	
					}
					if(VSKGeneralUtil.isNull(vvdVO.getUpdUsrId())){
						vvdVO.setUpdUsrId(userId);
					}
				}
				//===================== Setting for EDI END ========================

				//			********************* Transmitting changed VVD to ERP *********************
							
				List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, insertVoList, "I");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, updateVoList, "U");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deleteVoList, "D");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deletePortVoList, "D");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, deleteVirtualPortERPVoList, "D");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, insertVirtualPortVoList, "U");
				erpVvdVOs = setTransObjectByVvd(erpVvdVOs, updateNextPortVoList, "U");
				vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);
				vslSkdChgStsGRPVO.setEdiVvdVOs(ediVvdVOs);
				
	//			Booking BDR LOG
				if(erpVvdVOs != null && erpVvdVOs.size() > 0){
					List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
					vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);
				}
			}
			
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			/****************************************************************
			 * �댄빆�ㅼ�伊��대젰愿�━瑜��꾪븳 VO or VO List Return ::2015-05-08::
			 */
			vslSkdChgStsGRPVO.setHmVslSkdXtraHisVOs		(hmVslSkdXtraHisVOs		);
			vslSkdChgStsGRPVO.setVslSkdXtraHisGroupVO	(vslSkdXtraHisGroupVO	);
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * Creating History DataSet for Coastal History
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param List<VslPortSkdVO> insertVirtualPortVoList
	 * @param List<VskVslPortSkdVO> updateNextPortVoList
	 * @param String userId
	 * @return List<VslSkdHisInVO>
	 * @exception EventException
	 */
	private List<VslSkdHisInVO> makeHistoryDataSetByCoastal(CstSkdByVvdVO[] cstSkdByVvdVOs, List<VslPortSkdVO> insertVirtualPortVoList, List<VskVslPortSkdVO> updateNextPortVoList, String userId)throws EventException{
		
		List<VslSkdHisInVO> vslSkdHisInVOs = new ArrayList<VslSkdHisInVO>();

		try{
			
			for(CstSkdByVvdVO cstSkdByVvdVO : cstSkdByVvdVOs){
				
				VslSkdHisInVO vslSkdHisInVO 	= new VslSkdHisInVO();
				
				vslSkdHisInVO.setIbflag			(cstSkdByVvdVO.getIbflag());
				vslSkdHisInVO.setSkdCngStsCd	(cstSkdByVvdVO.getSkdCngStsCd());
				vslSkdHisInVO.setVslCd			(cstSkdByVvdVO.getVslCd());
				vslSkdHisInVO.setSkdVoyNo		(cstSkdByVvdVO.getSkdVoyNo());
				vslSkdHisInVO.setSkdDirCd		(cstSkdByVvdVO.getSkdDirCd());
				vslSkdHisInVO.setVslSlanCd		(cstSkdByVvdVO.getVslSlanCd());
				vslSkdHisInVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd());
				vslSkdHisInVO.setClptIndSeq		(cstSkdByVvdVO.getClptIndSeq());
				vslSkdHisInVO.setYdCd			(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
				vslSkdHisInVO.setVpsEtaDt		(cstSkdByVvdVO.getVpsEtaDt());
				vslSkdHisInVO.setVpsEtbDt		(cstSkdByVvdVO.getVpsEtbDt());
				vslSkdHisInVO.setVpsEtdDt		(cstSkdByVvdVO.getVpsEtdDt());
				vslSkdHisInVO.setVslDlayRsnCd	(cstSkdByVvdVO.getVslDlayRsnCd());
				vslSkdHisInVO.setVslDlayRsnDesc	(cstSkdByVvdVO.getVslDlayRsnDesc());
				vslSkdHisInVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());
				vslSkdHisInVO.setUsrId			(userId);
				vslSkdHisInVO.setNewClptIndSeq	(cstSkdByVvdVO.getNewClptIndSeq());
				vslSkdHisInVO.setTurnPortFlg	(cstSkdByVvdVO.getTurnPortFlg());
				vslSkdHisInVO.setTurnPortIndCd	(cstSkdByVvdVO.getTurnPortIndCd());
				
				vslSkdHisInVO.setPfSvcTpCd		(cstSkdByVvdVO.getPfSkdTpCd()==null?cstSkdByVvdVO.getPfSvcTpCd():cstSkdByVvdVO.getPfSkdTpCd());
				
				vslSkdHisInVO.setVtAddCallFlg	(cstSkdByVvdVO.getVtAddCallFlg());
				
				//:2016-08-03:byTOP://
				////vslSkdHisInVO.setTurnSkdVoyNo	(cstSkdByVvdVO.getTurnSkdVoyNo	());
				////vslSkdHisInVO.setTurnSkdDirCd	(cstSkdByVvdVO.getTurnSkdDirCd	());
				////vslSkdHisInVO.setTurnClptIndSeq	(cstSkdByVvdVO.getTurnClptIndSeq());
				//:2016-08-03:byTOP://
				
				vslSkdHisInVOs.add				(vslSkdHisInVO);
				
				
				//Virtual Port History Setting.
				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg())){
					VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();
					
					virtualVslSkdHisInVO.setIbflag			(cstSkdByVvdVO.getIbflag());
					virtualVslSkdHisInVO.setSkdCngStsCd		(cstSkdByVvdVO.getSkdCngStsCd());
					virtualVslSkdHisInVO.setVslCd			(cstSkdByVvdVO.getVslCd());
					virtualVslSkdHisInVO.setSkdVoyNo		(cstSkdByVvdVO.getTurnSkdVoyNo());
					virtualVslSkdHisInVO.setSkdDirCd		(cstSkdByVvdVO.getTurnSkdDirCd());
					virtualVslSkdHisInVO.setVslSlanCd		(cstSkdByVvdVO.getVslSlanCd());
					virtualVslSkdHisInVO.setVpsPortCd		(cstSkdByVvdVO.getVpsPortCd());
					virtualVslSkdHisInVO.setClptIndSeq		(cstSkdByVvdVO.getTurnClptIndSeq());
					
					//:2016-08-03:byTOP://
					virtualVslSkdHisInVO.setNewClptIndSeq	(cstSkdByVvdVO.getNewClptIndSeq());	//============= TOP.TOP.TOP ADDING IN 2015 YEAR ===============//
					////virtualVslSkdHisInVO.setNewClptIndSeq	(cstSkdByVvdVO.getNewTurnClptIndSeq());
					//:2016-08-03:byTOP://
					
					virtualVslSkdHisInVO.setYdCd			(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
					virtualVslSkdHisInVO.setVpsEtaDt		(cstSkdByVvdVO.getVpsEtaDt());
					virtualVslSkdHisInVO.setVpsEtbDt		(cstSkdByVvdVO.getVpsEtbDt());
					virtualVslSkdHisInVO.setVpsEtdDt		(cstSkdByVvdVO.getVpsEtdDt());
					virtualVslSkdHisInVO.setVslDlayRsnCd	(cstSkdByVvdVO.getVslDlayRsnCd());
					virtualVslSkdHisInVO.setVslDlayRsnDesc	(cstSkdByVvdVO.getVslDlayRsnDesc());
					virtualVslSkdHisInVO.setVslDlayRsnLocCd	(cstSkdByVvdVO.getVslDlayRsnLocCd());
					
					virtualVslSkdHisInVO.setPfSvcTpCd		(cstSkdByVvdVO.getPfSkdTpCd()==null?cstSkdByVvdVO.getPfSvcTpCd():cstSkdByVvdVO.getPfSkdTpCd());
					virtualVslSkdHisInVO.setUsrId			(userId);
					
					//:2016-08-03:byTOP://
					//virtualVslSkdHisInVO.setTurnSkdVoyNo	(cstSkdByVvdVO.getTurnSkdVoyNo		());
					//virtualVslSkdHisInVO.setTurnSkdDirCd	(cstSkdByVvdVO.getTurnSkdDirCd		());
					//virtualVslSkdHisInVO.setTurnClptIndSeq	(cstSkdByVvdVO.getTurnClptIndSeq	());
					//:2016-08-03:byTOP://
					
					for(VslPortSkdVO virtualPortSkdVO : insertVirtualPortVoList)
					{
						if(		cstSkdByVvdVO.getVslCd			().equals(virtualPortSkdVO.getVslCd			())
							&&	cstSkdByVvdVO.getSkdVoyNo		().equals(virtualPortSkdVO.getTurnSkdVoyNo	())
							&&	cstSkdByVvdVO.getSkdDirCd		().equals(virtualPortSkdVO.getTurnSkdDirCd	())
							
							&&	cstSkdByVvdVO.getVpsPortCd		().equals(virtualPortSkdVO.getVpsPortCd		())
							&&	cstSkdByVvdVO.getClptIndSeq		().equals(virtualPortSkdVO.getTurnClptIndSeq())	
							//:2016-05-31:by TOP://&&	cstSkdByVvdVO.getNewClptIndSeq	().equals(virtualPortSkdVO.getTurnClptIndSeq())
							)
							 
						{
							
							//:2016-05-24:by TOP://virtualVslSkdHisInVO.setNewClptIndSeq(virtualPortSkdVO.getClptIndSeq());
							virtualVslSkdHisInVO.setNewClptIndSeq		(virtualPortSkdVO.getNewClptIndSeq	());
							virtualVslSkdHisInVO.setClptIndSeq			(virtualPortSkdVO.getClptIndSeq		());
							
							virtualVslSkdHisInVO.setTurnPortFlg			(virtualPortSkdVO.getTurnPortFlg	());
							virtualVslSkdHisInVO.setTurnPortIndCd		(virtualPortSkdVO.getTurnPortIndCd	());
							
							//:2016-08-03:byTOP://
							//virtualVslSkdHisInVO.setTurnSkdVoyNo		(virtualPortSkdVO.getTurnSkdVoyNo	());
							//virtualVslSkdHisInVO.setTurnSkdDirCd		(virtualPortSkdVO.getTurnSkdDirCd	());
							//virtualVslSkdHisInVO.setTurnClptIndSeq		(virtualPortSkdVO.getTurnClptIndSeq	());
							//:2016-08-03:byTOP://
							break;
						}
					}
					
					vslSkdHisInVOs.add						(virtualVslSkdHisInVO);
				}
				
				
				//Next Port History Setting.
				if(VSKGeneralUtil.isVirtualPort(cstSkdByVvdVO.getTurnPortIndCd())){
					VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();
					
					nxtVslSkdHisInVO.setIbflag				("U");
					nxtVslSkdHisInVO.setSkdCngStsCd			(cstSkdByVvdVO.getSkdCngStsCd());
					nxtVslSkdHisInVO.setVslCd				(cstSkdByVvdVO.getVslCd());
					nxtVslSkdHisInVO.setSkdVoyNo			(cstSkdByVvdVO.getTurnSkdVoyNo());
					nxtVslSkdHisInVO.setSkdDirCd			(cstSkdByVvdVO.getTurnSkdDirCd());
					nxtVslSkdHisInVO.setVslSlanCd			(cstSkdByVvdVO.getVslSlanCd());
					nxtVslSkdHisInVO.setVpsPortCd			(cstSkdByVvdVO.getVpsPortCd());
					nxtVslSkdHisInVO.setClptIndSeq			(cstSkdByVvdVO.getTurnClptIndSeq());
					nxtVslSkdHisInVO.setYdCd				(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
					nxtVslSkdHisInVO.setVpsEtaDt			(cstSkdByVvdVO.getVpsEtaDt());
					nxtVslSkdHisInVO.setVpsEtbDt			(cstSkdByVvdVO.getVpsEtbDt());
					nxtVslSkdHisInVO.setVpsEtdDt			(cstSkdByVvdVO.getVpsEtdDt());
					nxtVslSkdHisInVO.setVslDlayRsnCd		(cstSkdByVvdVO.getVslDlayRsnCd());
					nxtVslSkdHisInVO.setVslDlayRsnDesc		(cstSkdByVvdVO.getVslDlayRsnDesc());
					nxtVslSkdHisInVO.setVslDlayRsnLocCd		(cstSkdByVvdVO.getVslDlayRsnLocCd());
					
					nxtVslSkdHisInVO.setPfSvcTpCd			(cstSkdByVvdVO.getPfSkdTpCd()==null?cstSkdByVvdVO.getPfSvcTpCd():cstSkdByVvdVO.getPfSkdTpCd());
					nxtVslSkdHisInVO.setUsrId				(userId);
					
					//:2016-08-03:byTOP://
					//nxtVslSkdHisInVO.setTurnSkdVoyNo		(cstSkdByVvdVO.getTurnSkdVoyNo		());
					//nxtVslSkdHisInVO.setTurnSkdDirCd		(cstSkdByVvdVO.getTurnSkdDirCd		());
					//nxtVslSkdHisInVO.setTurnClptIndSeq		(cstSkdByVvdVO.getTurnClptIndSeq	());
					//:2016-08-03:byTOP://
					
					for(VskVslPortSkdVO nextPortSkdVO : updateNextPortVoList)
					{
						if(		cstSkdByVvdVO.getVpsPortCd().equals(nextPortSkdVO.getVpsPortCd())
							&&	cstSkdByVvdVO.getNewClptIndSeq().equals(nextPortSkdVO.getTurnClptIndSeq()))
						{
							nxtVslSkdHisInVO.setNewClptIndSeq	(nextPortSkdVO.getClptIndSeq	());
							nxtVslSkdHisInVO.setTurnPortFlg		(nextPortSkdVO.getTurnPortFlg	());
							nxtVslSkdHisInVO.setTurnPortIndCd	(nextPortSkdVO.getTurnPortIndCd	());
							
							//:2016-08-03:byTOP://
							//nxtVslSkdHisInVO.setTurnSkdVoyNo	(nextPortSkdVO.getTurnSkdVoyNo	());
							//nxtVslSkdHisInVO.setTurnSkdDirCd	(nextPortSkdVO.getTurnSkdDirCd	());
							//nxtVslSkdHisInVO.setTurnClptIndSeq	(nextPortSkdVO.getTurnClptIndSeq());
							//:2016-08-03:byTOP://
							
							break;
						}
					}
					
					vslSkdHisInVOs.add						(nxtVslSkdHisInVO);
				}
			}
			
			
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return vslSkdHisInVOs;
	}
	
	/**
	 * Changing Turn of virtual in Coastal(Next Port).
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param String clptIndSeq
	 * @param String turnClptIndSeq
	 * @param int vitualSeq
	 * @param String userId
	 * @return VskVslPortSkdVO
	 * @exception EventException
	 */
	private VskVslPortSkdVO makeNextPortDataSet(CstSkdByVvdVO cstSkdByVvdVO, String clptIndSeq, String turnClptIndSeq, int vitualSeq, String userId) throws EventException{
		VskVslPortSkdVO nxtVskVslPortSkdVO = new VskVslPortSkdVO();
		
		try{
			nxtVskVslPortSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
			nxtVskVslPortSkdVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
			nxtVskVslPortSkdVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
			nxtVskVslPortSkdVO.setVpsPortCd(cstSkdByVvdVO.getVpsPortCd());
			nxtVskVslPortSkdVO.setClptIndSeq(turnClptIndSeq);
			/*
			 * 2014.12.26
			 * DONGSOO 
			 * virtual�쇰븣 �댁쟾�ы듃�먯꽌 ADD CALL���덉쓣寃���CLPT_SEQ媛�利앷��섏� �딅뒗 臾몄젣 諛쒖깮��
			 */
			nxtVskVslPortSkdVO.setClptSeq(cstSkdByVvdVO.getClptSeq());
			nxtVskVslPortSkdVO.setClptIndSeq(turnClptIndSeq);
			nxtVskVslPortSkdVO.setYdCd(cstSkdByVvdVO.getVpsPortCd() + cstSkdByVvdVO.getTmlCd());
			nxtVskVslPortSkdVO.setVpsEtaDt(cstSkdByVvdVO.getVpsEtaDt());
			nxtVskVslPortSkdVO.setVpsEtbDt(cstSkdByVvdVO.getVpsEtbDt());
			nxtVskVslPortSkdVO.setVpsEtdDt(cstSkdByVvdVO.getVpsEtdDt());
			nxtVskVslPortSkdVO.setVslDlayRsnCd(cstSkdByVvdVO.getVslDlayRsnCd());
			nxtVskVslPortSkdVO.setVslDlayRsnDesc(cstSkdByVvdVO.getVslDlayRsnDesc());
			nxtVskVslPortSkdVO.setVslDlayRsnLocCd(cstSkdByVvdVO.getVslDlayRsnLocCd());

			if("D".equals(cstSkdByVvdVO.getIbflag())){
				//Deleting turn of next port
				nxtVskVslPortSkdVO.setTurnPortFlg("N");
				nxtVskVslPortSkdVO.setTurnPortIndCd("N");
				nxtVskVslPortSkdVO.setTurnSkdVoyNo("");
				nxtVskVslPortSkdVO.setTurnSkdDirCd("");
				nxtVskVslPortSkdVO.setTurnClptIndSeq("");
			}else{
				String sTurnPortIndCd = "Y";
				nxtVskVslPortSkdVO.setTurnPortFlg("Y");
				if(vitualSeq == 1){
					VvdVO paramVO = new VvdVO();
					paramVO.setVslCd(cstSkdByVvdVO.getVslCd());
					paramVO.setSkdVoyNo(cstSkdByVvdVO.getTurnSkdVoyNo());
					paramVO.setSkdDirCd(cstSkdByVvdVO.getTurnSkdDirCd());
					// 1st Lane & 1st Port -> 'N', else -> 'Y'
					List<MdmVslSvcLaneDirVO> list = dbDao.searchSvcLaneDirByVvd(paramVO);
					if(list != null && list.size() > 0){
						for(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO : list){
							if(cstSkdByVvdVO.getTurnSkdDirCd().equals(mdmVslSvcLaneDirVO.getVslSlanDirCd())){
								if("1".equals(mdmVslSvcLaneDirVO.getVslSlanDirSeq())){
									sTurnPortIndCd = "N";
								}
							}
						}
					}
				}
				nxtVskVslPortSkdVO.setTurnPortIndCd(sTurnPortIndCd);
				nxtVskVslPortSkdVO.setTurnSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
				nxtVskVslPortSkdVO.setTurnSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
				nxtVskVslPortSkdVO.setTurnClptIndSeq(clptIndSeq);
			}

			nxtVskVslPortSkdVO.setAutoSkdCngFlg(cstSkdByVvdVO.getAutoSkdCngFlg());
			nxtVskVslPortSkdVO.setLnkSpd(cstSkdByVvdVO.getLnkSpd());
			nxtVskVslPortSkdVO.setSeaBufHrs(cstSkdByVvdVO.getSeaBufHrs());
			nxtVskVslPortSkdVO.setPortBufHrs(cstSkdByVvdVO.getPortBufHrs());
			nxtVskVslPortSkdVO.setTztmHrs(cstSkdByVvdVO.getTztmHrs());
			nxtVskVslPortSkdVO.setPortWrkHrs(cstSkdByVvdVO.getActWrkHrs());
			nxtVskVslPortSkdVO.setLnkDist(cstSkdByVvdVO.getLnkDist());
			nxtVskVslPortSkdVO.setMnvrOutHrs(cstSkdByVvdVO.getMnvrOutHrs());
			nxtVskVslPortSkdVO.setMnvrInHrs(cstSkdByVvdVO.getMnvrInHrs());
			nxtVskVslPortSkdVO.setUpdUsrId(userId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return nxtVskVslPortSkdVO;
	}
	
	/**
	 * Checking VVD of partVvdList is exist in baseVvdList. If not exist, putting VVD in baseVvdList
	 * 
	 * @param List<VvdVO> baseVvdList
	 * @param Object obj
	 * @param String ibFlg
	 * @return List<VvdVO>
	 * @exception EventException 
	 */
	@SuppressWarnings("unchecked")
	private List<VvdVO> setTransObjectByVvd(List<VvdVO> baseVvdList, Object obj, String ibFlg) throws EventException{
		try{
			List<Object> objList = (List<Object>)obj;
			
			if(objList != null && objList.size() > 0){
				for(Object voObject : objList){
					VvdVO vvdVO = new VvdVO();
					
					if(voObject.getClass().isInstance(new VskVslSkdVO())){
						VskVslSkdVO vskVslSkdVO = (VskVslSkdVO)voObject;
						vvdVO.setIbflag(ibFlg);
						vvdVO.setVslCd(vskVslSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
					}else if(voObject.getClass().isInstance(new VskVslPortSkdVO())){
						VskVslPortSkdVO vskVslPortSkdVO = (VskVslPortSkdVO)voObject;
						vvdVO.setIbflag(ibFlg);
						vvdVO.setVslCd(vskVslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
					}else if(voObject.getClass().isInstance(new VslPortSkdVO())){
						VslPortSkdVO vslPortSkdVO = (VslPortSkdVO)voObject;
						vvdVO.setIbflag(ibFlg);
						vvdVO.setVslCd(vslPortSkdVO.getVslCd());
						vvdVO.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vvdVO.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vvdVO.setVslSlanCd(vslPortSkdVO.getSlanCd());
					}else{
						throw new EventException(new ErrorHandler("VSK10039").getMessage());
					}
					
					if(!isCheckObjectByVvd(baseVvdList, vvdVO)){
						baseVvdList.add(vvdVO);
					}
				}
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return baseVvdList;
	}
	
	/**
	 * Creating Yard Ind Seq
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param int currSeq
	 * @return int
	 */
	private int makeCallYardSeq(CstSkdByVvdVO[] cstSkdByVvdVOs, int currSeq){
		int callYdIndSeq = 0;
		
		String ydCd = cstSkdByVvdVOs[currSeq].getVpsPortCd() + cstSkdByVvdVOs[currSeq].getTmlCd();
		String preVvd = "";		// pre VVD
		String curVvd = "";		// current VVD
		for(int j=0; j<=currSeq; j++){
			curVvd = cstSkdByVvdVOs[j].getVslCd() + cstSkdByVvdVOs[j].getSkdVoyNo() + cstSkdByVvdVOs[j].getSkdDirCd();
			
			if(!preVvd.equals(curVvd)){
				callYdIndSeq = 0;
				preVvd = curVvd;
			}
			
			if(ydCd.equals(cstSkdByVvdVOs[j].getVpsPortCd() + cstSkdByVvdVOs[j].getTmlCd())){
				// not counting in case of data to delete
				if(!"D".equals(cstSkdByVvdVOs[j].getIbflag())){
					callYdIndSeq++;
				}
			}
		}
		
		return callYdIndSeq;
	}
	
	/**
	 * Checking Tunning Port
	 * 
	 * @param String vslCd
	 * @param String turnSkdVoyNo
	 * @param String turnSkdDirCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @exception EventException
	 */
	private void checkVskVslPortSkd(String vslCd, String skdVoyNo, String skdDirCd, String turnSkdVoyNo, String turnSkdDirCd, String vpsEtaDt) throws EventException {
		try{
			// checking Turnning Port exist
			VslPortSkdVO paramVO 	= new VslPortSkdVO();
			paramVO.setVslCd		(vslCd);
			paramVO.setSkdVoyNo		(turnSkdVoyNo);
			paramVO.setSkdDirCd		(turnSkdDirCd);
			paramVO.setTurnSkdVoyNo	(skdVoyNo);
			paramVO.setTurnSkdDirCd	(skdDirCd);
			VvdCheckVO vvdCheckVO 	= dbDao.checkVskVslPortSkd(paramVO);
			
			if(vvdCheckVO == null || vvdCheckVO.getCnt() == null || "".equals(vvdCheckVO.getCnt())){
				throw new EventException(new ErrorHandler("VSK10013").getMessage());
			}else if(Integer.parseInt(vvdCheckVO.getCnt()) < 1){
				throw new EventException(new ErrorHandler("VSK10013").getMessage());
			}
			
			if(Integer.parseInt(vvdCheckVO.getVrtCnt()) > 0){
				String[] errMsgs = new String[]{vslCd+turnSkdVoyNo+turnSkdDirCd, vvdCheckVO.getVvd()};
				throw new EventException(new ErrorHandler("VSK10001", errMsgs).getMessage());
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Returning count of turning port in list
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @return int
	 */
	private int curTurnPortCnt(List<VskVslPortSkdVO> vskVslPortSkdVOs){
		int turnPortCnt = 0;
		if(vskVslPortSkdVOs != null && vskVslPortSkdVOs.size()>0){
			for(VskVslPortSkdVO vskVslPortSkdVO : vskVslPortSkdVOs){
				if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					turnPortCnt++;
				}
			}
		}
		return turnPortCnt;
	}
	
	/**
	 * Retrieving Target info for changing BDR in Booking
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @return List<BkgVvdBdrLogVO>
	 * @exception EventException
	 */
	public List<BkgVvdBdrLogVO> searchBkgBdrLog(List<VvdVO> vvdVOs) throws EventException {
		List<BkgVvdBdrLogVO> bkgVvdLogList = new ArrayList<BkgVvdBdrLogVO>();
		try{
			for(VvdVO vvdVO : vvdVOs){
				BkgVvdBdrLogVO bkgVvdBdrLogVO = new BkgVvdBdrLogVO();
				bkgVvdBdrLogVO.setVslCd(vvdVO.getVslCd());
				bkgVvdBdrLogVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
				bkgVvdBdrLogVO.setSkdDirCd(vvdVO.getSkdDirCd());
				bkgVvdLogList.add(bkgVvdBdrLogVO);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return bkgVvdLogList;
	}
	
	/**
	 * Judging turn_port_ind_cd
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param boolean isFirstTurningPort
	 * @param String tPortIndCd
	 * @param String tPortFlg
	 * @param String portRotnSeq
	 * @param String vslSlanCd
	 * @param String vslSlanDirCd
	 * @param String clptSeq
	 * @return String
	 * @exception EventException
	 */
	private String turnPortIndCdControl(CstSkdByVvdVO cstSkdByVvdVO, boolean isFirstTurningPort, String tPortIndCd, String tPortFlg, String portRotnSeq, String vslSlanCd, String vslSlanDirCd, String clptSeq) throws EventException {
		
		String 	turnPortIndCd 			= "";
		
		try{
			
			if(VSKGeneralUtil.isNotNull(tPortIndCd)){
				if(!VSKGeneralUtil.isVirtualPort(tPortIndCd)){
					if("Y".equals(tPortFlg)){
						
						/** Identification for first direction : checkFirstDirForLane **/
						if(isFirstTurningPort == true && dbDao.checkFirstDirForLane(cstSkdByVvdVO)){
							turnPortIndCd = "N";
						}else{
							turnPortIndCd = "Y";
						}
						
						//:2015-12-17://if("1".equals(portRotnSeq) && "1".equals(clptSeq)){
						//:2015-12-17://	turnPortIndCd = "N";
						//:2015-12-17://}else{
						//:2015-12-17://	if("1".equals(portRotnSeq) && isFirstTurningPort == true){
						//:2015-12-17://		turnPortIndCd = "N";
						//:2015-12-17://	}else{
						//:2015-12-17://		turnPortIndCd = "Y";	
						//:2015-12-17://	}
						
					}else{
						turnPortIndCd = "N";
					}
				}else{
					turnPortIndCd = tPortIndCd;
				}
				
			}else{
				
				//in case of new input data, turnPortIndCd is Null
				if("Y".equals(tPortFlg)){
					
					/** Identification for first direction : checkFirstDirForLane **/
					if(isFirstTurningPort == true && dbDao.checkFirstDirForLane(cstSkdByVvdVO)){
						turnPortIndCd = "N";
					}else{
						turnPortIndCd = "Y";
					}
					
					//:2015-12-17://if(VSKGeneralUtil.isNotNull(portRotnSeq)){
					//:2015-12-17://	if("1".equals(portRotnSeq) && "1".equals(clptSeq)){
					//:2015-12-17://		turnPortIndCd = "N";
					//:2015-12-17://	}else{
					//:2015-12-17://		turnPortIndCd = "Y";
					//:2015-12-17://	}
					//:2015-12-17://}else{
						// in case of no use p/f, portRotnSeq is Null
					//:2015-12-17://	MdmVslSvcLaneDirVO paramVO = new MdmVslSvcLaneDirVO();
					//:2015-12-17://	paramVO.setVslSlanCd(vslSlanCd);
					//:2015-12-17://	paramVO.setVslSlanDirCd(vslSlanDirCd);
					//:2015-12-17://	paramVO.setDeltFlg("N");
						
					//:2015-12-17://	String dirSeq = dbDao.searchDirectionSeq(paramVO);
					//:2015-12-17://	if("1".equals(dirSeq)){
					//:2015-12-17://		turnPortIndCd = "N";
					//:2015-12-17://	}else{
					//:2015-12-17://		turnPortIndCd = "Y";
					//:2015-12-17://	}
					//:2015-12-17://}
					
				}else{
					turnPortIndCd = "N";
				}
				
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return turnPortIndCd;
	}
	
	/**
	 * Returning Virtual Port Turn Indicator Code
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param VskVslPortSkdVO virtualPortVO
	 * @param String turnPortIndCd
	 * @return String
	 */
	private String virtualTurnPortIndCdControl(CstSkdByVvdVO cstSkdByVvdVO, String turnLaneCd, String turnPortIndCd) throws EventException{
		/*
		 * [condition of Virtual Port Turn Indicator Code]
		 * 
		 * LANE different 'V'
		 * 
		 * LANE same
		 * pf_seq=1 and voy1!=voy2 and dir1!= dir2 => 'F'
		 * voy1!=voy2 and dir1!= dir2 => 'V'
		 * voy1!=voy2 and dir1== dir2 => 'V'
		 * voy1==voy2 and dir1!= dir2 => 'D'
		 */
		String virtualTurnPortIndCd = "";
		
		try{
				
			//:2016-10-26:Applying unique routine for all cases-Not Considering Lane Change or Not://
			if(!cstSkdByVvdVO.getVslSlanCd().equals(turnLaneCd)){
				
				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg()) && "N".equals(turnPortIndCd) && dbDao.checkFinalYardForSecondDir(cstSkdByVvdVO)){
					virtualTurnPortIndCd = "F";
				}else{
					virtualTurnPortIndCd = "V";
				}
				
			}else{
				
				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg()) && "N".equals(turnPortIndCd)){
					virtualTurnPortIndCd = "F";
				} else if (!cstSkdByVvdVO.getSkdVoyNo().equals(cstSkdByVvdVO.getTurnSkdVoyNo())){
					
					//:rollabak 2016-10-28://if(dbDao.checkFinalYardForSecondDir2(cstSkdByVvdVO)){
					//:rollabak 2016-10-28://	virtualTurnPortIndCd = "F";
					//:rollabak 2016-10-28://}else{
						
					virtualTurnPortIndCd = "V";	
					
					//:rollabak 2016-10-28://}
					
				} else if(!cstSkdByVvdVO.getSkdDirCd().equals(cstSkdByVvdVO.getTurnSkdDirCd())){
					virtualTurnPortIndCd = "D";
				}
			}

			
//old routine////////////////////////////////////////////////////////////////////////////////////////			
//			if(!cstSkdByVvdVO.getVslSlanCd().equals(turnLaneCd)){
//				if(dbDao.checkFinalYardForSecondDir(cstSkdByVvdVO)){
//					virtualTurnPortIndCd = "F";
//				}else{
//					virtualTurnPortIndCd = "V";
//				}
//			}else{
//				if("Y".equals(cstSkdByVvdVO.getTurnPortFlg()) && "N".equals(turnPortIndCd)){
//					virtualTurnPortIndCd = "F";
//				} else if (!cstSkdByVvdVO.getSkdVoyNo().equals(cstSkdByVvdVO.getTurnSkdVoyNo())){
//					virtualTurnPortIndCd = "V";
//				} else if(!cstSkdByVvdVO.getSkdDirCd().equals(cstSkdByVvdVO.getTurnSkdDirCd())){
//					virtualTurnPortIndCd = "D";
//				}
//			}
//old routine////////////////////////////////////////////////////////////////////////////////////////				
			
				
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return virtualTurnPortIndCd;
	}
	
	/**
	 * Checking vvdVO is exist in List<VvdVO> list
	 * @param list List<VvdVO>
	 * @param vvdVO VvdVO
	 * @return boolean
	 */
	private boolean isCheckObjectByVvd(List<VvdVO> list, VvdVO vvdVO){
		boolean rtnFlg = false;
		
		for(int i=0; i<list.size(); i++){
			VvdVO tmpVO = list.get(i);
			if(tmpVO.getVslCd().equals(vvdVO.getVslCd())
					&& tmpVO.getSkdVoyNo().equals(vvdVO.getSkdVoyNo())
					&& tmpVO.getSkdDirCd().equals(vvdVO.getSkdDirCd())){
				rtnFlg = true;
				break;
			}
		}
		
		return rtnFlg;
	}
	
	/**
	 * Creating turn_clpt_ind_seq
	 * 
	 * @param int turnClptIndSeq
	 * @param String newClptIndSeq
	 * @return int
	 * @exception EventException
	 */
	private int getParsingTurnClptIndSeq(int turnClptIndSeq, String newClptIndSeq) throws EventException {
		try{
			turnClptIndSeq = turnClptIndSeq + Integer.parseInt(newClptIndSeq);
			return turnClptIndSeq;
		}catch(NumberFormatException ne){
			throw new EventException(new ErrorHandler(ne).getMessage(), ne);
		}		
	}
	
	/**
	 * Creating History
	 * 
	 * @param List<VslSkdHisInVO> vslSkdHisInVOs
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	private VslSkdChgStsGRPVO manageVslSkdChgSts(List<VslSkdHisInVO> vslSkdHisInVOs) throws EventException {
		
		//return Group VO
		VslSkdChgStsGRPVO 		vslSkdChgStsGRPVO 			= new VslSkdChgStsGRPVO				();
		//return [Booking] VO List
		List<VslSkdCngNoticeVO> bkgNoticeList 				= new ArrayList<VslSkdCngNoticeVO>	();
		List<VslSkdCngUpdateVO> bkgUpdateList 				= new ArrayList<VslSkdCngUpdateVO>	();
		
		//return [COP] VO List
		List<SceActRcvIfVO> 	copNoticeList 				= new ArrayList<SceActRcvIfVO>		();
		
		List<VskVslSkdHisVO> 	historyList 				= new ArrayList<VskVslSkdHisVO>		();
		List<VskVslSkdVO> 		masterVOList 				= new ArrayList<VskVslSkdVO>		();		// VSK_VSL_SKD
		
		//Vessel Schedule Detail History 愿�━��List::VSK_VSL_SKD_HIS//
		List<VslSkdXtraHisVO> 	vslSkdWithoutBKGHisVOList	= new ArrayList<VslSkdXtraHisVO>	();
		
		/**************************************************************************************
		 * VSK-BKG
		 * ------------------------------------------------------------------------------------
		 * Original YARD, Original CLPT_IND_SEQ + New YARD, New CLPT_IND_SEQ
		 * ------------------------------------------------------------------------------------
		 * VSK-SCE
		 * SCE_ACT_TMNL_IF
		 * Original/New Pair 愿�━�꾩슂.
		 * ====================================================================================
		 * [CASE]					[INDICATOR]			[TABLE NAME]
		 * ------------------------------------------------------------------------------------
		 * 1. ACT SKD I/F			:: 21,22,23			SCE_ACT_RCV_IF
		 * 2. TERMINAL CHANGE		:: 27				SCE_ACT_TML_IF
		 * 3. CLPT_IND_SEQ CHANGE	:: 72				SCE_ACT_TML_IF
		 * 4. EST SKD I/F			:: 24,25,26			SCE_VPS_IF
		 * 5. E-SVC SKD I/F			:: 28,29,30			SCE_SVC_PTAL_VPS_IF
		 * 6. ATD I/F				:: 23 ONLY			SCE_POD_ARR_VSL_SKD_HIS
		 * ====================================================================================
		 **/
		
		try{
			
			if(vslSkdHisInVOs != null && vslSkdHisInVOs.size() > 0){
				
				List<CstSkdByVvdVO> orgPortVoList = null;		//original Port List
				
				String preVvdCd 	= "";
				String curVvdCd 	= "";
				
				String vslSlanCd	= "";
				String vslCd 		= "";
				String skdVoyNo 	= "";
				String skdDirCd 	= "";
				String vpsPortCd 	= "";
				
				for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
					
					vslSlanCd	= vslSkdHisInVO.getVslSlanCd();
					
					vslCd 		= vslSkdHisInVO.getVslCd	();
					skdVoyNo 	= vslSkdHisInVO.getSkdVoyNo	();
					skdDirCd 	= vslSkdHisInVO.getSkdDirCd	();
					vpsPortCd 	= vslSkdHisInVO.getVpsPortCd();
					
					curVvdCd 	= vslCd + skdVoyNo + skdDirCd;
					
					/////////////////////////////////////////////////////////////////////////////
					int 			iHisDtlTargetKnt		= 0;					//1���섎㈃ Next Vo濡��대룞�쒕떎.
					//::VSL_VSL_SKD_XTRA_HIS �대젰�곗씠���앹꽦���꾪븳 Temporary VO:://
					
					////////////////////////////////////////////////////////////////////////////
					
					/* 
					 * ###################################################################################
					 * if Booking exist
					 * 
					 * Make History
					 * Transmit to BKG
					 * Transmit to SCE - COP
					 * ################################################################################### 
					 */
					VslPortSkdVO paramVO				= new VslPortSkdVO();
					paramVO.setVslCd					(vslCd);
					paramVO.setSkdVoyNo					(skdVoyNo);
					paramVO.setSkdDirCd					(skdDirCd);
					paramVO.setVpsPortCd				(vpsPortCd);
					paramVO.setClptIndSeq				(vslSkdHisInVO.getClptIndSeq());
					
					VslPortSkdVO bkgCheckVO				= null;
					
					if(!VSKGeneralUtil.isNull(vslSkdHisInVO.getClptIndSeq())){
						
						/*** VVD����븳 BOOKING �뺣낫 議댁옱�좊Т 議고쉶 *************************************/
						
						bkgCheckVO 						= dbDao.checkVslSkdByRowID(paramVO);
						
						//if(bkgCheckVO == null)			bkgCheckVO 	= dbDao.checkVslSkdByRowID2(paramVO);
						
						/************************************************************************/
						
						//::by TOP:2015-05-08:://
						//if(bkgCheckVO == null) {
							// Booking �뺣낫媛��덉쓣 寃쎌슦�먮뒗 �ㅼ쓬 濡쒖쭅�먯꽌 History �뺣낫瑜��앹꽦�섍린 �뚮Ц���듦낵�대룄 �쒕떎.
							// �� Skip �댄썑 Booking瑜�紐⑤몢 �ㅻⅨ VVD濡���꼈��寃쎌슦瑜�媛먯븞�섍퀬 �덈떎.
						//	skipCallFlag = dbDao.checkSkipCallHistory(vslSkdHisInVO); // Schedule History����Skip Call���덈뒗吏��뺤씤.
						//}
						//::by TOP:2015-05-08:://
						
					}
					
					
					/** CASE : BOOKING ATTACHED ************************************/
					if(bkgCheckVO != null && !"".equals(bkgCheckVO.getVpsPortCd())){
						
						if(!preVvdCd.equals(curVvdCd)){
							
							CstSkdByVvdVO orgParamVO 	= new CstSkdByVvdVO(); 
							orgParamVO.setVslCd			(vslCd);
							orgParamVO.setSkdVoyNo		(skdVoyNo);
							orgParamVO.setSkdDirCd		(skdDirCd);
							
								
							orgPortVoList 				= dbDao.searchCstSkdByVvd	(orgParamVO);

							
							// in case Master change, for History (Lane, VVD delete)
							boolean mstFlg = true;
							for(VskVslSkdVO mstVO : masterVOList){
								if(vslCd.equals(mstVO.getVslCd()) && skdVoyNo.equals(mstVO.getSkdVoyNo()) && skdDirCd.equals(mstVO.getSkdDirCd())){
									mstFlg = false;
									break;
								}
							}
							// ADD in case data not exist in Master
							if(mstFlg){
								VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
								vskVslSkdVO.setVslCd	(vslCd);
								vskVslSkdVO.setSkdVoyNo	(skdVoyNo);
								vskVslSkdVO.setSkdDirCd	(skdDirCd);
								vskVslSkdVO.setCreUsrId	(vslSkdHisInVO.getUsrId());
								vskVslSkdVO.setUpdUsrId	(vslSkdHisInVO.getUsrId());
								
								masterVOList.add		(vskVslSkdVO);
							}
						}
						
						CstSkdByVvdVO orgPortVO = null;						
						//Find skip port before change
						////int i = 0; 
						if(orgPortVoList != null && orgPortVoList.size() > 0){
							
							for(CstSkdByVvdVO orgPortTmpVO : orgPortVoList){								
						
/*								if(	(		
											vslSkdHisInVO.getVpsPortCd().equals		(cstSkdByVvdVO.getVpsPortCd		())
										&& 	vslSkdHisInVO.getNewClptIndSeq() 		!= null 
										&& 	vslSkdHisInVO.getNewClptIndSeq().equals	(cstSkdByVvdVO.getClptIndSeq	())
										
										&&	vslSkdHisInVO.getVslCd().equals			(cstSkdByVvdVO.getVslCd			())
										&&	vslSkdHisInVO.getSkdVoyNo().equals		(cstSkdByVvdVO.getSkdVoyNo		())
										&&	vslSkdHisInVO.getSkdDirCd().equals		(cstSkdByVvdVO.getSkdDirCd		())
									)
									||
									(
											vslSkdHisInVO.getVpsPortCd().equals		(cstSkdByVvdVO.getVpsPortCd		())
										&& 	vslSkdHisInVO.getNewClptIndSeq() 		!= null 
										&& 	vslSkdHisInVO.getClptIndSeq().equals	(cstSkdByVvdVO.getClptIndSeq	())
										&& 	!vslSkdHisInVO.getClptIndSeq().equals	(vslSkdHisInVO.getNewClptIndSeq	())
										
										&&	vslSkdHisInVO.getVslCd().equals			(cstSkdByVvdVO.getVslCd			())
										&&	vslSkdHisInVO.getSkdVoyNo().equals		(cstSkdByVvdVO.getSkdVoyNo		())
										&&	vslSkdHisInVO.getSkdDirCd().equals		(cstSkdByVvdVO.getSkdDirCd		())										
									)
								  )*/
								
								if(		vslSkdHisInVO.getVslCd		().equals	(orgPortTmpVO.getVslCd		())
									&&	vslSkdHisInVO.getSkdVoyNo	().equals	(orgPortTmpVO.getSkdVoyNo	())
									&&	vslSkdHisInVO.getSkdDirCd	().equals	(orgPortTmpVO.getSkdDirCd	())		&&
										
										vslSkdHisInVO.getVpsPortCd	().equals	(orgPortTmpVO.getVpsPortCd	())
									&& 	vslSkdHisInVO.getClptIndSeq	()			!= null
									&& 	vslSkdHisInVO.getClptIndSeq	().equals	(orgPortTmpVO.getClptIndSeq()))								
								{
									orgPortVO = orgPortTmpVO;
									break;
								}
								////i++;
							}
						}
						
						/*
						 * VskdCngTpCd - reason code
						 * 'S' : Port Skip
						 * 'O' : Phase Out
						 * 'V' : VVD delete
						 * 'T' : PORT delete (no Virtual Port)
						 * 'D' : PORT delete (Virtual Port)
						 * 'L' : Lane change
						 * 'E' : ETA, ETB, ETD
						 * 'Y' : YARD change
						 * 'P' : change CALLING SEQUENCE
						 */
						
						if(orgPortVO != null){
							
							//***** 'S' : Port Skip() *****							
							if(!"S".equals(orgPortVO.getSkdCngStsCd())){
								
								if("S".equals(vslSkdHisInVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null){
									
									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO	();
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO	();
								
									/*
									 * VSKD_TP_CD - where data change
									 * 
									 * M : Vessel Schedule
									 * P : Vessel Port Schedule (Default)
									 */
									vskVslSkdHisVO.setVskdTpCd			("P");
									vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd());
									vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo());
									vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd());
									vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd());
									vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt());
									vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt());
									vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt());
									vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd());
									vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq());
									vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd());
									vskVslSkdHisVO.setVskdCngTpCd		("S");					//'S' : Port Skip()
									vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setBkgAtchFlg		("Y");
									vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd());
									
									historyList.add						(vskVslSkdHisVO);
									
									vslSkdCngNoticeVO.setVslCd			(vslCd);
									vslSkdCngNoticeVO.setSkdVoyNo		(skdVoyNo);
									vslSkdCngNoticeVO.setSkdDirCd		(skdDirCd);
									vslSkdCngNoticeVO.setPortCd			(vslSkdHisInVO.getVpsPortCd());
									vslSkdCngNoticeVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq());
									vslSkdCngNoticeVO.setYdCd			(vslSkdHisInVO.getYdCd());
									vslSkdCngNoticeVO.setTypeCd			("S");
									vslSkdCngNoticeVO.setRemark			("Skip");
									
									bkgNoticeList.add					(vslSkdCngNoticeVO);
									
									log.info("\n\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ::SKIP CALLING:: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> \n\n");
									
								}
							}
							
							
							/*
							 * Orginal SKD ��Skip �댁�留� �붾㈃�먯꽌 Skip Call Cancel ��寃쎌슦.
							 *
							 */
							if("S".equals(orgPortVO.getSkdCngStsCd()) && orgPortVO.getSkdCngStsCd() != null){
								//�덈줈 �낅젰���곗씠��� Skip Cancel�대㈃
								if("".equals(vslSkdHisInVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null){
									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();

									/*
									 * VSKD_TP_CD - Vessel Schedule�먯꽌 蹂�꼍�덈뒗吏� Vessel Port Schedule�먯꽌 蹂�꼍���댁슜�몄�瑜�援щ텇.
									 *
									 * M : Vessel Schedule
									 * P : Vessel Port Schedule (Default)
									 */
									vskVslSkdHisVO.setVskdTpCd			("P");
									vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd());
									vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo());
									vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd());
									vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd());
									vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt());
									vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt());
									vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt());
									vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd());
									vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq());
									vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd());
									vskVslSkdHisVO.setVskdCngTpCd		("X");					//蹂�꼍���댁쑀瑜�CODE���섏뿬 �쒖떆 - 'X' : Skip Cancel
									vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setBkgAtchFlg		("Y");
									
									vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd());

									historyList.add						(vskVslSkdHisVO);

									/* --------------------------------------------------------------------
									 * PORT SKIP CANCEL����븳 TO BKG NOTICE
									 * --------------------------------------------------------------------
									 * PORT SKIP : "X"
									 */
									vslSkdCngNoticeVO.setVslCd		(vslCd							);
									vslSkdCngNoticeVO.setSkdVoyNo	(skdVoyNo						);
									vslSkdCngNoticeVO.setSkdDirCd	(skdDirCd						);
									vslSkdCngNoticeVO.setPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
									vslSkdCngNoticeVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
									vslSkdCngNoticeVO.setYdCd		(vslSkdHisInVO.getYdCd		()	);
									vslSkdCngNoticeVO.setTypeCd		("X"							);
									vslSkdCngNoticeVO.setRemark		("Skip Cancel"					);

									bkgNoticeList.add				(vslSkdCngNoticeVO);
									
								}
							}
							
							
							//***** 'O' : Phase Out *****
							if("O".equals(vslSkdHisInVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null){
								VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
								VslSkdCngNoticeVO vslSkdCngNoticeVO = new VslSkdCngNoticeVO();
								
								// history...
								vskVslSkdHisVO.setVskdTpCd			("P");
								vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd());
								vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo());
								vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd());
								vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd());
								vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt());
								vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt());
								vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt());
								vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd());
								vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq());
								vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd());
								vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getCngVslCd());
								vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getCngSkdVoyNo());
								vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getCngSkdDirCd());
								vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getCngLaneCd());
								vskVslSkdHisVO.setDiffRmk			("Phase Out");
								vskVslSkdHisVO.setVskdCngTpCd		("O");					//'O' : Phase Out
								vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId());
								vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId());
								vskVslSkdHisVO.setBkgAtchFlg		("Y");
								
								vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd());
								
								historyList.add						(vskVslSkdHisVO);
								
								// booking...
								vslSkdCngNoticeVO.setVslCd			(vslCd);
								vslSkdCngNoticeVO.setSkdVoyNo		(skdVoyNo);
								vslSkdCngNoticeVO.setSkdDirCd		(skdDirCd);
								vslSkdCngNoticeVO.setPortCd			(vslSkdHisInVO.getVpsPortCd());
								vslSkdCngNoticeVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq());
								vslSkdCngNoticeVO.setYdCd			(vslSkdHisInVO.getYdCd());
								vslSkdCngNoticeVO.setTypeCd			("O");
								vslSkdCngNoticeVO.setRemark			("Phase Out");
								
								bkgNoticeList.add					(vslSkdCngNoticeVO);
							}
							
							//***** 'T' : Port Delete *****
							if("D".equals(vslSkdHisInVO.getIbflag())){
								
								VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
								VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();
								
								String vskdCngTpCd 	= "T";
								String diffRmk 		= "Actual Port Deletion";
								
								if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
									vskdCngTpCd 	= "D";
									diffRmk 		= "Virtual Port Deletion";
								}
								
								
								// history...
								vskVslSkdHisVO.setVskdTpCd			("P");
								vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd());
								vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo());
								vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd());
								vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd());
								vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt());
								vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt());
								vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt());
								vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd());
								vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq());
								vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd());
								vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getCngVslCd());
								vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getCngSkdVoyNo());
								vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getCngSkdDirCd());
								vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getCngLaneCd());
								vskVslSkdHisVO.setDiffRmk			(diffRmk);
								vskVslSkdHisVO.setVskdCngTpCd		(vskdCngTpCd);					//'T' : Port Delete
								vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId());
								vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId());
								vskVslSkdHisVO.setBkgAtchFlg		("Y");
								
								vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd());
								
								historyList.add						(vskVslSkdHisVO);
								
								// booking...
								vslSkdCngNoticeVO.setVslCd			(vslCd);
								vslSkdCngNoticeVO.setSkdVoyNo		(skdVoyNo);
								vslSkdCngNoticeVO.setSkdDirCd		(skdDirCd);
								vslSkdCngNoticeVO.setPortCd			(vslSkdHisInVO.getVpsPortCd());
								vslSkdCngNoticeVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq());
								vslSkdCngNoticeVO.setYdCd			(vslSkdHisInVO.getYdCd());
								vslSkdCngNoticeVO.setTypeCd			(vskdCngTpCd);
								vslSkdCngNoticeVO.setRemark			(diffRmk);
								
								bkgNoticeList.add					(vslSkdCngNoticeVO);
							}
							
							
							/*******BOOKING ATTACHED*******/
							/* Add change of turning port to normal in case of existing BKGs :by TOP 2016-04-28 */
							if(		"Y".equals(orgPortVO.getTurnPortFlg		())	&& orgPortVO.getTurnPortFlg		() 	!= null
								&&	"N".equals(vslSkdHisInVO.getTurnPortFlg	())	&& vslSkdHisInVO.getTurnPortFlg	() 	!= null
								){
								/* --------------------------------------------------------------------
								 * TURNING PORT FLAG CHANGE����븳 VSK VESSEL SCHEDULE HISTORY
								 * --------------------------------------------------------------------
								 * D	Virtual Port Deletion by turning port flag change
								 * R	Turning Port Change to Normal
								 */
								
								/*** VVD taken BKG Kind *************************************************
								**	"ACTUAL"	: 
								**	"VIRTUAL"	:  
								************************************************************************/
								
								//---------------------------------------------------------------------//
								
								VskVslSkdHisVO 	vskVslSkdHisVO 		= new VskVslSkdHisVO				();
								
								vskVslSkdHisVO.setVskdTpCd			("P"								);
								vskVslSkdHisVO.setVskdCngTpCd		("R"								);
								vskVslSkdHisVO.setBkgAtchFlg		("Y"								);
								vskVslSkdHisVO.setDiffRmk			("Turning Port Change to Normal"	);
								
								vskVslSkdHisVO.setBfrVslSlanCd		(vslSlanCd							);
								vskVslSkdHisVO.setBfrVslCd			(vslCd								);
								vskVslSkdHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								vskVslSkdHisVO.setBfrSkdDirCd		(skdDirCd							);
								vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd	()			);
								vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq()			);
								vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd()				);
								
								vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd()		);
								vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId()			);
								vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId()			);
								
								historyList.add						(vskVslSkdHisVO);
								
								//----------------------------------------------------------------------//
								
								/** Interface to BKG by turning port flag change	**/
								VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO			();
								
								vslSkdCngNoticeVO.setVslCd			(vslCd								);
								vslSkdCngNoticeVO.setSkdVoyNo		(skdVoyNo							);
								vslSkdCngNoticeVO.setSkdDirCd		(skdDirCd							);
								vslSkdCngNoticeVO.setPortCd			(vslSkdHisInVO.getVpsPortCd	()		);
								vslSkdCngNoticeVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq()		);
								vslSkdCngNoticeVO.setYdCd			(vslSkdHisInVO.getYdCd		()		);
								vslSkdCngNoticeVO.setTypeCd			("R");
								vslSkdCngNoticeVO.setRemark			("Turning Port Change to Normal"	);
								
								bkgNoticeList.add					(vslSkdCngNoticeVO					);
								
								//---------------------------------------------------------------------//
								
								VslPortSkdVO tmpVirtualVVDTakenBkg 		= null;
								tmpVirtualVVDTakenBkg 					= dbDao.checkVslSkdByRowIDVirtualVVD(paramVO);
								
								if(tmpVirtualVVDTakenBkg != null){

									VskVslSkdHisVO 	vskVslSkdHisVO2 	= new VskVslSkdHisVO				();
									
									vskVslSkdHisVO2.setVskdTpCd			("P"								);
									
									vskVslSkdHisVO2.setVskdCngTpCd		("D"								);
									vskVslSkdHisVO2.setBkgAtchFlg		("Y"								);
									vskVslSkdHisVO2.setDiffRmk			("Virtual Port Deletion by turning port flag change");
									
									vskVslSkdHisVO2.setBfrVslSlanCd		(vslSlanCd							);
									vskVslSkdHisVO2.setBfrVslCd			(vslCd								);
									vskVslSkdHisVO2.setBfrSkdVoyNo		(orgPortVO.getTurnSkdVoyNo	()		);
									vskVslSkdHisVO2.setBfrSkdDirCd		(orgPortVO.getTurnSkdDirCd	()		);
									vskVslSkdHisVO2.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
									vskVslSkdHisVO2.setBfrClptIndSeq	(orgPortVO.getTurnClptIndSeq()		);
									vskVslSkdHisVO2.setBfrYdCd			(orgPortVO.getYdCd			()		);
									
									vskVslSkdHisVO2.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd	()		);
									vskVslSkdHisVO2.setCreUsrId			(vslSkdHisInVO.getUsrId		()		);
									vskVslSkdHisVO2.setUpdUsrId			(vslSkdHisInVO.getUsrId		()		);
									
									historyList.add						(vskVslSkdHisVO2);
									
									//----------------------------------------------------------------------//
									
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO2 	= new VslSkdCngNoticeVO			();
									
									vslSkdCngNoticeVO2.setVslCd			(vslCd								);
									vslSkdCngNoticeVO2.setSkdVoyNo		(orgPortVO.getTurnSkdVoyNo	()		);
									vslSkdCngNoticeVO2.setSkdDirCd		(orgPortVO.getTurnSkdDirCd	()		);
									vslSkdCngNoticeVO2.setPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
									vslSkdCngNoticeVO2.setClptIndSeq	(orgPortVO.getTurnClptIndSeq()		);
									vslSkdCngNoticeVO2.setYdCd			(orgPortVO.getYdCd			()		);
									vslSkdCngNoticeVO2.setTypeCd		("D");
									vslSkdCngNoticeVO2.setRemark		("Virtual Port Deletion by turning port flag change");
									
									bkgNoticeList.add					(vslSkdCngNoticeVO2					);
						                  
								}else{
									
									VskVslSkdHisVO 	vskVslSkdHisVO2 	= new VskVslSkdHisVO				();
									
									vskVslSkdHisVO2.setVskdTpCd			("P"								);
									
									vskVslSkdHisVO2.setVskdCngTpCd		("D"								);
									vskVslSkdHisVO2.setBkgAtchFlg		("N"								);
									vskVslSkdHisVO2.setDiffRmk			("Virtual Port Deletion by turning port flag change");
									
									vskVslSkdHisVO2.setBfrVslSlanCd		(vslSlanCd							);
									vskVslSkdHisVO2.setBfrVslCd			(vslCd								);
									vskVslSkdHisVO2.setBfrSkdVoyNo		(orgPortVO.getTurnSkdVoyNo	()		);
									vskVslSkdHisVO2.setBfrSkdDirCd		(orgPortVO.getTurnSkdDirCd	()		);
									vskVslSkdHisVO2.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
									vskVslSkdHisVO2.setBfrClptIndSeq	(orgPortVO.getTurnClptIndSeq()		);
									vskVslSkdHisVO2.setBfrYdCd			(orgPortVO.getYdCd			()		);
									
									vskVslSkdHisVO2.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd	()		);
									vskVslSkdHisVO2.setCreUsrId			(vslSkdHisInVO.getUsrId		()		);
									vskVslSkdHisVO2.setUpdUsrId			(vslSkdHisInVO.getUsrId		()		);
									
									historyList.add						(vskVslSkdHisVO2);
									
								}	//END OF IF
								
							}
							
							
							/*******BOOKING ATTACHED*******/
							if(		"N".equals(orgPortVO.getTurnPortFlg		())	&& orgPortVO.getTurnPortFlg		() 	!= null
								&&	"Y".equals(vslSkdHisInVO.getTurnPortFlg	())	&& vslSkdHisInVO.getTurnPortFlg	() 	!= null
							){
								/* --------------------------------------------------------------------
								 * TURNING PORT FLAG CHANGE����븳 VSK VESSEL SCHEDULE HISTORY
								 * --------------------------------------------------------------------
								 * A	Add Virtual Port by turning port flag change
								 * C	Normal Port Change to Turning
								 */

								if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
									
									VskVslSkdHisVO 		vskVslSkdHisVO2 	= new VskVslSkdHisVO				();
									
									vskVslSkdHisVO2.setVskdTpCd				("P"								);
									vskVslSkdHisVO2.setVskdCngTpCd			("A"								);
									vskVslSkdHisVO2.setBkgAtchFlg			("Y"								);
									
									vskVslSkdHisVO2.setDiffRmk				("Add Virtual Port by turning port flag change");
									
									vskVslSkdHisVO2.setBfrVslSlanCd			(vslSlanCd							);
									vskVslSkdHisVO2.setBfrVslCd				("****"								);
									vskVslSkdHisVO2.setBfrSkdVoyNo			("****"								);
									vskVslSkdHisVO2.setBfrSkdDirCd			("*"								);
									vskVslSkdHisVO2.setBfrVpsPortCd			(orgPortVO.getVpsPortCd	()			);
									vskVslSkdHisVO2.setBfrClptIndSeq		(orgPortVO.getTurnClptIndSeq()		);
									vskVslSkdHisVO2.setBfrYdCd				(orgPortVO.getYdCd()				);
									//vskVslSkdHisVO2.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt()			);
									//vskVslSkdHisVO2.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt()			);
									//vskVslSkdHisVO2.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt()			);
									
									//vskVslSkdHisVO2.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt()		);
									//vskVslSkdHisVO2.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt()		);
									//vskVslSkdHisVO2.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt()		);
									
									vskVslSkdHisVO2.setBfrPfSvcTpCd			(vslSkdHisInVO.getPfSvcTpCd()		);
									vskVslSkdHisVO2.setCreUsrId				(vslSkdHisInVO.getUsrId()			);
									vskVslSkdHisVO2.setUpdUsrId				(vslSkdHisInVO.getUsrId()			);
									
									historyList.add							(vskVslSkdHisVO2);
									
								}else{

									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO				();
									
									vskVslSkdHisVO.setVskdTpCd				("P"								);
									vskVslSkdHisVO.setVskdCngTpCd			("C"								);
									vskVslSkdHisVO.setBkgAtchFlg			("Y"								);
									
									vskVslSkdHisVO.setDiffRmk				("Normal Port Change to Turning"	);
									
									vskVslSkdHisVO.setBfrVslSlanCd			(vslSlanCd							);
									vskVslSkdHisVO.setBfrVslCd				(vslCd								);
									vskVslSkdHisVO.setBfrSkdVoyNo			(skdVoyNo							);
									vskVslSkdHisVO.setBfrSkdDirCd			(skdDirCd							);
									vskVslSkdHisVO.setBfrVpsPortCd			(orgPortVO.getVpsPortCd	()			);
									vskVslSkdHisVO.setBfrClptIndSeq			(orgPortVO.getClptIndSeq()			);
									vskVslSkdHisVO.setBfrYdCd				(orgPortVO.getYdCd()				);
									//vskVslSkdHisVO.setBfrVpsEtaDt			(orgPortVO.getVpsEtaDt()			);
									//vskVslSkdHisVO.setBfrVpsEtbDt			(orgPortVO.getVpsEtbDt()			);
									//vskVslSkdHisVO.setBfrVpsEtdDt			(orgPortVO.getVpsEtdDt()			);
									
									//vskVslSkdHisVO.setAftVpsEtaDt			(vslSkdHisInVO.getVpsEtaDt()		);
									//vskVslSkdHisVO.setAftVpsEtbDt			(vslSkdHisInVO.getVpsEtbDt()		);
									//vskVslSkdHisVO.setAftVpsEtdDt			(vslSkdHisInVO.getVpsEtdDt()		);
									
									vskVslSkdHisVO.setBfrPfSvcTpCd			(vslSkdHisInVO.getPfSvcTpCd()		);
									vskVslSkdHisVO.setCreUsrId				(vslSkdHisInVO.getUsrId()			);
									vskVslSkdHisVO.setUpdUsrId				(vslSkdHisInVO.getUsrId()			);
									
									historyList.add							(vskVslSkdHisVO);
									
								}
								//--------------------------------------------------------------------------//

							}
							/* Add change of turning port to normal in case of existing BKGs :by TOP 2016-04-28 */
							

							/*
							 * Orginal SKD ��Add Call �댁�留� �붾㈃�먯꽌 Add Call Cancel ��寃쎌슦.
							 *
							 */
							if("A".equals(orgPortVO.getSkdCngStsCd()) && orgPortVO.getSkdCngStsCd() != null){
								
								//�덈줈 �낅젰���곗씠��� Add Call Cancel�대㈃
								if("D".equals(vslSkdHisInVO.getIbflag())){
									VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO();
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO 	= new VslSkdCngNoticeVO();
									
									String	sVtAddCallFlg					= "";
									if(orgPortVO.getVtAddCallFlg() != null && "Y".equals(orgPortVO.getVtAddCallFlg())){
										sVtAddCallFlg						= "X";
									}else{
										sVtAddCallFlg						= "";
									}
									
									/*
									 * VSKD_TP_CD - Vessel Schedule�먯꽌 蹂�꼍�덈뒗吏� Vessel Port Schedule�먯꽌 蹂�꼍���댁슜�몄�瑜�援щ텇.
									 *
									 * M : Vessel Schedule
									 * P : Vessel Port Schedule (Default)
									 */
									vskVslSkdHisVO.setVskdTpCd			("P");
									vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd());
									vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo());
									vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd());
									vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd());
									vskVslSkdHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt());
									vskVslSkdHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt());
									vskVslSkdHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt());
									vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd());
									vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq());
									vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd());
									
									vskVslSkdHisVO.setVskdCngTpCd		("B");							/** <<Add Calling Cancellation>> **/
									vskVslSkdHisVO.setDiffRmk			("Add Calling Cancellation");
									
									vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId());
									vskVslSkdHisVO.setBkgAtchFlg		("Y");

									vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd());
									
									vskVslSkdHisVO.setVtAddCallFlg		(sVtAddCallFlg);
									
									historyList.add						(vskVslSkdHisVO);

									/* --------------------------------------------------------------------
									 * PORT ADD CALL CANCEL����븳 TO BKG NOTICE
									 * --------------------------------------------------------------------
									 * ADLL CALL CANCEL : "B"
									 */
									vslSkdCngNoticeVO.setVslCd		(vslCd							);
									vslSkdCngNoticeVO.setSkdVoyNo	(skdVoyNo						);
									vslSkdCngNoticeVO.setSkdDirCd	(skdDirCd						);
									vslSkdCngNoticeVO.setPortCd		(vslSkdHisInVO.getVpsPortCd	()	);
									vslSkdCngNoticeVO.setClptIndSeq	(vslSkdHisInVO.getClptIndSeq()	);
									vslSkdCngNoticeVO.setYdCd		(vslSkdHisInVO.getYdCd		()	);
									vslSkdCngNoticeVO.setTypeCd		("B"							);
									vslSkdCngNoticeVO.setRemark		("Add Call Cancel"				);

									bkgNoticeList.add				(vslSkdCngNoticeVO);
									
								}
								
							}
								
							
							//***** 'E' : ETA, ETB, ETD *****
							if(
									((!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())))
								||	((!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())))
								|| 	((!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())))
							){
								
								VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO	();
								StringBuilder		sbDiffRmk			= new StringBuilder		();
								
								vskVslSkdHisVO.setVskdTpCd				("P");
								vskVslSkdHisVO.setBfrVslCd				(orgPortVO.getVslCd			());
								vskVslSkdHisVO.setBfrSkdVoyNo			(orgPortVO.getSkdVoyNo		());
								vskVslSkdHisVO.setBfrSkdDirCd			(orgPortVO.getSkdDirCd		());
								vskVslSkdHisVO.setBfrVslSlanCd			(orgPortVO.getVslSlanCd		());
								vskVslSkdHisVO.setBfrVpsEtaDt			(orgPortVO.getVpsEtaDt		());
								vskVslSkdHisVO.setBfrVpsEtbDt			(orgPortVO.getVpsEtbDt		());
								vskVslSkdHisVO.setBfrVpsEtdDt			(orgPortVO.getVpsEtdDt		());
								vskVslSkdHisVO.setBfrVpsPortCd			(orgPortVO.getVpsPortCd		());
								vskVslSkdHisVO.setBfrClptIndSeq			(orgPortVO.getClptIndSeq	());
								vskVslSkdHisVO.setBfrYdCd				(orgPortVO.getYdCd			());
								vskVslSkdHisVO.setAftVslCd				(vslSkdHisInVO.getVslCd		());
								vskVslSkdHisVO.setAftSkdVoyNo			(vslSkdHisInVO.getSkdVoyNo	());
								vskVslSkdHisVO.setAftSkdDirCd			(vslSkdHisInVO.getSkdDirCd	());
								vskVslSkdHisVO.setAftVpsEtaDt			(vslSkdHisInVO.getVpsEtaDt	());
								vskVslSkdHisVO.setAftVpsEtbDt			(vslSkdHisInVO.getVpsEtbDt	());
								vskVslSkdHisVO.setAftVpsEtdDt			(vslSkdHisInVO.getVpsEtdDt	());
								vskVslSkdHisVO.setVskdCngTpCd			("E");							//'E' : ETA, ETB, ETD
								
								if(!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt()) && VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())){
									sbDiffRmk.append("ETA");
								}
								if(!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt()) && VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())){
									if(sbDiffRmk.length() == 0)	sbDiffRmk.append("ETB");
									else						sbDiffRmk.append("/ETB");
									
								}
								if(!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt()) && VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())){
									if(sbDiffRmk.length() == 0)	sbDiffRmk.append("ETD");
									else						sbDiffRmk.append("/ETD");
								}
								sbDiffRmk.append(" is changed(with BKG)");
								
								vskVslSkdHisVO.setDiffRmk		(sbDiffRmk.toString()		);
								vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId		());
								vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId		());
								
								vskVslSkdHisVO.setBkgAtchFlg	("Y");
								
								vskVslSkdHisVO.setBfrPfSvcTpCd	(vslSkdHisInVO.getPfSvcTpCd	());
								
								historyList.add					(vskVslSkdHisVO);
								
								
								// cop...
								/*
								 *  IF( UPDATING ) THEN Act Rcv Dt
								 *  1. ATA -> "21"
								 *  2. ATB -> "22"
								 *  3. ATD -> "23"
								 *  4. ETA -> "24"
								 *  5. ETB -> "25"
								 *  6. ETD -> "26"
								 *  7. YD  -> "27"
								 */
								if(!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())	&& VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())){
									SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
									sceActRcvIfVO.setActRcvTpCd		("24");
									sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtaDt		());
									sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd			());
									
									sceActRcvIfVO.setVslCd			(vslSkdHisInVO.getVslCd			());
									sceActRcvIfVO.setSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo		());
									sceActRcvIfVO.setSkdDirCd		(vslSkdHisInVO.getSkdDirCd		());
									sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd		());
									sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq	());
									
									sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd	());
									sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc());
									sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd());
									sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId			());
									
									copNoticeList.add				(sceActRcvIfVO);
								}
								
								if(!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())	&& VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())){
									SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
									sceActRcvIfVO.setActRcvTpCd		("25");
									sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtbDt		());
									
									sceActRcvIfVO.setVslCd			(vslSkdHisInVO.getVslCd			());
									sceActRcvIfVO.setSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo		());
									sceActRcvIfVO.setSkdDirCd		(vslSkdHisInVO.getSkdDirCd		());
									sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd		());
									sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq	());
									
									sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd	());
									sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc());
									sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd());
									sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd			());
									sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId			());
									
									copNoticeList.add				(sceActRcvIfVO);
								}
								
								if(!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())	&& VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())){
									SceActRcvIfVO sceActRcvIfVO		 = new SceActRcvIfVO();
									sceActRcvIfVO.setActRcvTpCd		("26");
									sceActRcvIfVO.setActDt			(vslSkdHisInVO.getVpsEtdDt		());
									
									sceActRcvIfVO.setVslCd			(vslSkdHisInVO.getVslCd			());
									sceActRcvIfVO.setSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo		());
									sceActRcvIfVO.setSkdDirCd		(vslSkdHisInVO.getSkdDirCd		());
									sceActRcvIfVO.setVpsPortCd		(vslSkdHisInVO.getVpsPortCd		());
									sceActRcvIfVO.setClptIndSeq		(vslSkdHisInVO.getClptIndSeq	());
									
									sceActRcvIfVO.setVslDlayRsnCd	(vslSkdHisInVO.getVslDlayRsnCd	());
									sceActRcvIfVO.setVslDlayRsnDesc	(vslSkdHisInVO.getVslDlayRsnDesc());
									sceActRcvIfVO.setVpsLocCd		(vslSkdHisInVO.getVslDlayRsnLocCd());
									sceActRcvIfVO.setNodCd			(vslSkdHisInVO.getYdCd			());
									sceActRcvIfVO.setCreUsrId		(vslSkdHisInVO.getUsrId			());
									
									copNoticeList.add				(sceActRcvIfVO);
								}
								
							}
							
							
							//***** 'Y' : YARD Change *****
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd())){
								if(!vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd())){
									VskVslSkdHisVO vskVslSkdHisVO 		= new VskVslSkdHisVO();
									VslSkdCngUpdateVO vslSkdCngUpdateVO = new VslSkdCngUpdateVO();
									
									// history...
									vskVslSkdHisVO.setVskdTpCd			("P");
									vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd				());
									vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo			());
									vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd			());
									vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd			());
									
									//:2016-03-08://vskVslSkdHisVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtaDt());
									//:2016-03-08://vskVslSkdHisVO.setBfrVpsEtbDt	(orgPortVO.getVpsEtbDt());
									//:2016-03-08://vskVslSkdHisVO.setBfrVpsEtdDt	(orgPortVO.getVpsEtdDt());
									
									vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			());
									vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		());
									vskVslSkdHisVO.setBfrYdCd			(orgPortVO.getYdCd				());
									vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getVslCd			());
									vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo		());
									vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getSkdDirCd		());
									vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getVslSlanCd		());
									vskVslSkdHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			());
									vskVslSkdHisVO.setVskdCngTpCd		("Y");								//'Y' : YARD change
									vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			());
									vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			());
									vskVslSkdHisVO.setBkgAtchFlg		("Y");
									
									vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		());
									
									historyList.add						(vskVslSkdHisVO);
									
									//�대젰���앹꽦�섏� �딆븯�ㅻ땲 ����
									
									// booking...
									vslSkdCngUpdateVO.setVvd			(vslCd + skdVoyNo + skdDirCd);
									vslSkdCngUpdateVO.setPortCd			(vslSkdHisInVO.getVpsPortCd		());
									vslSkdCngUpdateVO.setOldClptIndSeq	(orgPortVO.getClptIndSeq		());
									vslSkdCngUpdateVO.setNewClptIndSeq	(vslSkdHisInVO.getClptIndSeq	());
									vslSkdCngUpdateVO.setOldYdCd		(orgPortVO.getYdCd				());
									vslSkdCngUpdateVO.setNewYdCd		(vslSkdHisInVO.getYdCd			());
									
									bkgUpdateList.add					(vslSkdCngUpdateVO);
									
									// cop...
									SceActRcvIfVO sceActRcvIfVO 		= new SceActRcvIfVO();
									sceActRcvIfVO.setActRcvTpCd			("27");
									sceActRcvIfVO.setVslCd				(vslCd							);
									sceActRcvIfVO.setSkdVoyNo			(skdVoyNo						);
									sceActRcvIfVO.setSkdDirCd			(skdDirCd						);
									sceActRcvIfVO.setVpsPortCd			(vslSkdHisInVO.getVpsPortCd		());
									sceActRcvIfVO.setClptIndSeq			(vslSkdHisInVO.getClptIndSeq	());
									sceActRcvIfVO.setVslDlayRsnCd		(vslSkdHisInVO.getVslDlayRsnCd	());
									sceActRcvIfVO.setVslDlayRsnDesc		(vslSkdHisInVO.getVslDlayRsnDesc());
									sceActRcvIfVO.setVpsLocCd			(vslSkdHisInVO.getVslDlayRsnLocCd());
									sceActRcvIfVO.setNodCd				(vslSkdHisInVO.getYdCd			());
									sceActRcvIfVO.setCreUsrId			(vslSkdHisInVO.getUsrId			());
									
									//8. Call Indicator Seq. 蹂�꼍 "72" ::�뺤긽湲�:bkg-vsk-sce-prd::2013-03-19//
									sceActRcvIfVO.setCallYdIndCngFlg	("N");			/**	SCE_ACT_TML_IF	**/
									/////////////////////////////////////////////////////////////////////////
									
									copNoticeList.add					(sceActRcvIfVO);
								}
							}
							
							//if(		"OSRC2001S".equals(vslSkdHisInVO.getVslCd()+vslSkdHisInVO.getSkdVoyNo()+vslSkdHisInVO.getSkdDirCd())
							//	&&	"JPHIJ".equals(vslSkdHisInVO.getVpsPortCd())
								//&&	"3".equals(vslSkdHisInVO.getClptIndSeq())
							//	)
							//{
							
								log.info("\n\n ============ top.top.top (BKG ATTACHED) ====================\n");
								log.info("\n VVD ["+vslSkdHisInVO.getVslCd()+vslSkdHisInVO.getSkdVoyNo()+vslSkdHisInVO.getSkdDirCd()+"] ["+vslSkdHisInVO.getVpsPortCd()+"] CLPT_IND_SEQ ["+vslSkdHisInVO.getClptIndSeq()+"] NEW CLPT_IND_SEQ ["+vslSkdHisInVO.getNewClptIndSeq()+"] ");
								log.info("\n ============ top.top.top (BKG ATTACHED) ====================\n\n");
							
							//}
							
							//***** 'P' : Change CALLING SEQUENCE *****
							if(		!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq()) 
								&&	vslSkdHisInVO.getNewClptIndSeq() != null
								&&	!"".equals(vslSkdHisInVO.getNewClptIndSeq().trim())
								)
							{
								VskVslSkdHisVO 		vskVslSkdHisVO 		= new VskVslSkdHisVO		();
								VslSkdCngUpdateVO 	vslSkdCngUpdateVO 	= new VslSkdCngUpdateVO		();
								
								vskVslSkdHisVO.setVskdTpCd			("P");
								vskVslSkdHisVO.setBfrVslCd			(orgPortVO.getVslCd				());
								vskVslSkdHisVO.setBfrSkdVoyNo		(orgPortVO.getSkdVoyNo			());
								vskVslSkdHisVO.setBfrSkdDirCd		(orgPortVO.getSkdDirCd			());
								vskVslSkdHisVO.setBfrVslSlanCd		(orgPortVO.getVslSlanCd			());
								vskVslSkdHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			());
								vskVslSkdHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		());
								vskVslSkdHisVO.setAftVslCd			(vslSkdHisInVO.getVslCd			());
								vskVslSkdHisVO.setAftSkdVoyNo		(vslSkdHisInVO.getSkdVoyNo		());
								vskVslSkdHisVO.setAftSkdDirCd		(vslSkdHisInVO.getSkdDirCd		());
								vskVslSkdHisVO.setAftVslSlanCd		(vslSkdHisInVO.getVslSlanCd		());
								vskVslSkdHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		());
								vskVslSkdHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	());
								
								vskVslSkdHisVO.setVskdCngTpCd		("P");										//'P' : CALLING SEQUENCE change
								vskVslSkdHisVO.setDiffRmk			("Calling Indicator Change (CLPT_IND_SEQ) with BKGs");
								
								vskVslSkdHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			());
								vskVslSkdHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			());
								vskVslSkdHisVO.setBkgAtchFlg		("Y");
								
								vskVslSkdHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd());
								
								historyList.add						(vskVslSkdHisVO);
								
								
								//booking
								vslSkdCngUpdateVO.setVvd			(vslCd + skdVoyNo + skdDirCd	  );
								vslSkdCngUpdateVO.setPortCd			(vslSkdHisInVO.getVpsPortCd		());
								vslSkdCngUpdateVO.setOldClptIndSeq	(orgPortVO.getClptIndSeq		());
								//::2015-02-28:by TOP:://vslSkdCngUpdateVO.setNewClptIndSeq	(vslSkdHisInVO.getClptIndSeq());
								vslSkdCngUpdateVO.setNewClptIndSeq	(vslSkdHisInVO.getNewClptIndSeq	());
								vslSkdCngUpdateVO.setOldYdCd		(orgPortVO.getYdCd				());
								vslSkdCngUpdateVO.setNewYdCd		(vslSkdHisInVO.getYdCd			());	
								
								bkgUpdateList.add					(vslSkdCngUpdateVO);
								
								
								//8. Call Indicator Seq. 蹂�꼍 "72" ::�뺤긽湲�:bkg-vsk-sce-prd::2013-03-19//STARTED
								//to SCE_ACT_TML_IF(COP), /Old Terminal Code
								SceActRcvIfVO sceActRcvIfVO 		= new SceActRcvIfVO();
								sceActRcvIfVO.setActRcvTpCd			("72");
								sceActRcvIfVO.setVslCd				(vslCd								);
								sceActRcvIfVO.setSkdVoyNo			(skdVoyNo							);
								sceActRcvIfVO.setSkdDirCd			(skdDirCd							);
								
								//::old information:://
								sceActRcvIfVO.setVpsPortCd			(orgPortVO.getVpsPortCd			()	);
								sceActRcvIfVO.setClptIndSeq			(orgPortVO.getClptIndSeq		()	);
								sceActRcvIfVO.setNodCd				(orgPortVO.getYdCd				()	);
								///////////////////////
								
								sceActRcvIfVO.setVslDlayRsnCd		(vslSkdHisInVO.getVslDlayRsnCd	()	);
								sceActRcvIfVO.setVslDlayRsnDesc		(vslSkdHisInVO.getVslDlayRsnDesc()	);
								sceActRcvIfVO.setVpsLocCd			(vslSkdHisInVO.getVslDlayRsnLocCd()	);
								sceActRcvIfVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);

								sceActRcvIfVO.setCallYdIndCngFlg	("Y");		/**	SCE_ACT_TML_IF	**/
								
								copNoticeList.add					(sceActRcvIfVO);
								//8. Call Indicator Seq. 蹂�꼍 "72" ::�뺤긽湲�:bkg-vsk-sce-prd::2013-03-19//FINISHED
								
							}
						
							
						}
						
					
					/** CASE : BOOKING NOT ATTACHED ********************************/
					}else{
					
						
						/**
						 *  Making Vessel Schedule Change History without Bookings
						 *  Date	: 2015-05-08
						 *  Table	: VSK_VSL_SKD_HIS 
						 */
						
					     ///////////////////////////////////////////////////////////////////////////
					     //int iHisDtlTargetKnt = 0; //1���섎㈃ Next VO濡��대룞�쒕떎.
					     ///////////////////////////////////////////////////////////////////////////
					     //VVD 肄붾뱶
						 vslSlanCd					= vslSkdHisInVO.getVslSlanCd();
					     vslCd     					= vslSkdHisInVO.getVslCd 	();
					     skdVoyNo    				= vslSkdHisInVO.getSkdVoyNo ();
					     skdDirCd    				= vslSkdHisInVO.getSkdDirCd ();
					     vpsPortCd    				= vslSkdHisInVO.getVpsPortCd();
					     paramVO.setVslCd  			(vslCd  	);
					     paramVO.setSkdVoyNo  		(skdVoyNo 	);
					     paramVO.setSkdDirCd  		(skdDirCd 	);
					     paramVO.setVpsPortCd 		(vpsPortCd 	);
					     paramVO.setClptIndSeq 		(vslSkdHisInVO.getClptIndSeq());
					     String sTmpCurVvdCd		= vslCd + skdVoyNo + skdDirCd;
					     String sTmpPreVvdCd		= "";
					     
					     // VVD 媛��щ윭 嫄댁씪 ���덉쑝誘�줈.
					     if(!sTmpPreVvdCd.equals	(sTmpCurVvdCd)){
					      sTmpPreVvdCd 				= sTmpCurVvdCd;
					      // �대떦 VVD��蹂�꼍�섍린�꾩쓽 Port �뺣낫瑜�議고쉶�쒕떎.
					      CstSkdByVvdVO orgParamVO 	= new CstSkdByVvdVO();
					      orgParamVO.setVslCd  		(vslCd);
					      orgParamVO.setSkdVoyNo 	(skdVoyNo);
					      orgParamVO.setSkdDirCd 	(skdDirCd);
					      orgPortVoList    			= dbDao.searchCstSkdByVvd(orgParamVO);
					     }
					     
					     //::by TOP:2015-05-08:://CstSkdByVvdVO orgPortVO 	= null;
					     CstSkdByVvdVO	orgPortVO 	= null;
					     
					     
					     //�대떦 Skip ��蹂�꼍 �꾩쓽 Port �뺣낫瑜�李얜뒗��
					     if(orgPortVoList != null && orgPortVoList.size() > 0){
					      for(CstSkdByVvdVO orgCstSkdByVvdVO : orgPortVoList){
					       if( 			vslSkdHisInVO.getVpsPortCd	().equals(orgCstSkdByVvdVO.getVpsPortCd())
					    		   && 	vslSkdHisInVO.getClptIndSeq	() != null
					    		   && 	vslSkdHisInVO.getClptIndSeq	().equals(orgCstSkdByVvdVO.getClptIndSeq()))
					       {
					        orgPortVO = orgCstSkdByVvdVO;
					        break;
					       }
					      }
					     }
						
						/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
						 * VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD V1
						 * - sVslSkdTmlCngTpCd
						 * ----------------------------------------------
						 * 'N' : 理쒖큹�앹꽦.
						 * ----------------------------------------------
						 * 'U' : Normal UPDATE 
						 * 'S' : Port SKIP
						 * 'I' : Phase IN
						 * 'O' : Phase OUT
						 * 'D' : Port Delete
						 * 'E' : ETA, ETB, ETD 蹂�꼍
						 * 'Y' : YARD(Terminal) 蹂�꼍
						 * 'P' : PORT��Calling Indicator Seq.(CLPT_IND_SEQ) 蹂�꼍
						 * 'R' : REVERSE Call
						 * ---------------------------------------------
						 * 'A' : ADD Call
						 * 'T' : AUTO UPDATE (by Acctual Schedule)
						 * ---------------------------------------------
						 * 'X' : Port SKIP Cancel
						 * ---------------------------------------------
						 */
						if(orgPortVO != null){
							
							//湲곗〈 �곗씠�곌� Port Skip���꾨땲怨� �덈줈 �낅젰���곗씠�곌� Port Skip�대㈃ 
							//:2016-05-19://if((!"S".equals(orgPortVO.getSkdCngStsCd()) || orgPortVO.getSkdCngStsCd() == null) && "S".equals(vslSkdHisInVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
							if((!"S".equals(orgPortVO.getSkdCngStsCd()) || orgPortVO.getSkdCngStsCd() == null) && "S".equals(vslSkdHisInVO.getSkdCngStsCd())){
								/* --------------------------------------------------------------------
								 * PORT SKIP����븳 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * PORT SKIP : "S"
								 */		
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("S"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd()		);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId()			);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId()			);
								
								iHisDtlTargetKnt++;			
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO		);
							}
							
							
							if("S".equals(orgPortVO.getSkdCngStsCd()) && orgPortVO.getSkdCngStsCd() != null && "".equals(vslSkdHisInVO.getSkdCngStsCd()) && iHisDtlTargetKnt == 0){
								/* --------------------------------------------------------------------
								 * PORT SKIP CANCEL����븳 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * PORT SKIP CANCEL : "X"
								 */				
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("X"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd()		);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId()			);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId()			);
								
								iHisDtlTargetKnt++;
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO		);
							}
							
							//:2016-05-19://if("O".equals(vslSkdHisInVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null && iHisDtlTargetKnt == 0){
							if("O".equals(vslSkdHisInVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null){
										
								/* --------------------------------------------------------------------
								 * PHASE OUT����븳 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * PHASE OUT : "O"
								 */		
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("O"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd()		);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId()			);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId()			);
								
								iHisDtlTargetKnt++;		
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO		);
							}
								
							//湲곗〈 �곗씠�곌� ADD CALL�닿퀬, �덈줈 �낅젰���곗씠�곌� ADD CALL CANCEL �대㈃ 
							//:2016-05-19://if("A".equals(orgPortVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null && "D".equals(vslSkdHisInVO.getIbflag()) && iHisDtlTargetKnt == 0){
							if("A".equals(orgPortVO.getSkdCngStsCd()) && vslSkdHisInVO.getSkdCngStsCd() != null && "D".equals(vslSkdHisInVO.getIbflag())){
										/* --------------------------------------------------------------------
								 * ADD CALL CANCEL ����븳 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * ADD CALL CANCEL : "B"
								 */		
								
								String	sVtAddCallFlg					= "";
								if(orgPortVO.getVtAddCallFlg() != null && "Y".equals(orgPortVO.getVtAddCallFlg())){
									sVtAddCallFlg						= "X";
								}else{
									sVtAddCallFlg						= "";
								}
								
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("B"								);
								tmpVslSkdXtraHisVO.setDiffRmk			("Add Calling Cancellation"			);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq()	);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd()		);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId()			);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId()			);
								
								tmpVslSkdXtraHisVO.setVtAddCallFlg		(sVtAddCallFlg						);
								
								iHisDtlTargetKnt++;	
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO		);
							}
								
							
							//***** 'T' : Port ��젣 *****
							//:2016-05-19://if("D".equals(vslSkdHisInVO.getIbflag()) && iHisDtlTargetKnt == 0){
							if("D".equals(vslSkdHisInVO.getIbflag())){
														
								String vskdCngTpCd	= null;
								String vskdCngRmk	= null;
								if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
									vskdCngTpCd		= "D";	// Virtual Port ��젣��寃쎌슦 Code 瑜�援щ텇
									vskdCngRmk		= "Port Deletion as Virtual Port";
								}else{
									vskdCngTpCd		= "T";
									vskdCngRmk		= "Port Deletion as Actual Port";
								}
									
								/*************************************************************************
								* Vessel Schedule Change History Detial VO �앹꽦
								* -----------------------------------------------------------------------
								* NORMAL/TURNING PORT DELETION : "T"
								* VIRTUAL 		  PORT DELETION : "D"
								*************************************************************************
								*/		
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		(vskdCngTpCd						);
								tmpVslSkdXtraHisVO.setDiffRmk			(vskdCngRmk							);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(vslSkdHisInVO.getClptIndSeq()		);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd	()		);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId		()		);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId		()		);
								
								iHisDtlTargetKnt++;	
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
								/*************************************************************************
								*/															
							}
														
						
							//:2016-05-19://if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd()) && !vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd()) && iHisDtlTargetKnt == 0){
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getYdCd()) && !vslSkdHisInVO.getYdCd().equals(orgPortVO.getYdCd())){
								/* --------------------------------------------------------------------
								 * YARD CHANGE����븳 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * YARD CHANGE : "Y"
								 */		
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("Y"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			()	);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		()	);
								tmpVslSkdXtraHisVO.setBfrYdCd			(orgPortVO.getYdCd				()	);
								tmpVslSkdXtraHisVO.setBfrCallYdIndSeq	(orgPortVO.getCallYdIndSeq		()	);
								
								tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
								tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
								tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
								tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);

								iHisDtlTargetKnt++;	
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
							}
							
							
							log.info("\n\n ============ top.top.top (bkg not attached) ====================\n");
							log.info("\n VVD ["+vslSkdHisInVO.getVslCd()+vslSkdHisInVO.getSkdVoyNo()+vslSkdHisInVO.getSkdDirCd()+"] ["+vslSkdHisInVO.getVpsPortCd()+"] CLPT_IND_SEQ ["+vslSkdHisInVO.getClptIndSeq()+"] NEW CLPT_IND_SEQ ["+vslSkdHisInVO.getNewClptIndSeq()+"] ");
							log.info("\n ============ top.top.top (bkg not attached) ====================\n\n");
							
							//:2016-05-19://if(!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq()) && iHisDtlTargetKnt == 0){
							if(!vslSkdHisInVO.getClptIndSeq().equals(vslSkdHisInVO.getNewClptIndSeq())){
								/* --------------------------------------------------------------------
								 * CALLING PORT SEQUENCE CHANGE����븳 VSK VESSEL SCHEDULE HISTORY DETAIL
								 * --------------------------------------------------------------------
								 * CALLING PORT INDICATOR SEQUENCE CHANGE : "P"
								 */	
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("P"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setDiffRmk			("Calling Indicator Change (CLPT_IND_SEQ) without BKG");
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			()	);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		()	);
								tmpVslSkdXtraHisVO.setBfrYdCd			(orgPortVO.getYdCd				()	);
								tmpVslSkdXtraHisVO.setBfrCallYdIndSeq	(orgPortVO.getCallYdIndSeq		()	);
								
								tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
								tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
								tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
								tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
								
								iHisDtlTargetKnt++;		
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
							}
								
							if(
									(((!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())))
								|| 	(( !vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())))
								|| 	(( !vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt())) && (VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())))) 
							){
								/* --------------------------------------------------------------------
								 * ETA, ETB, ETD CHANGE����븳 VSK VESSEL SCHEDULE HISTORY
								 * --------------------------------------------------------------------
								 * ETA, ETB, ETD CHANGE : "E"
								 */
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO				();
								StringBuilder	sbDiffRmk				= new StringBuilder					();
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("E"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd		()		);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq	()		);
								tmpVslSkdXtraHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt		()		);
								tmpVslSkdXtraHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt		()		);
								tmpVslSkdXtraHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt		()		);
								
								tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt	()		);
								tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt	()		);
								tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt	()		);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd	()		);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId		()		);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId		()		);
								
								if(!vslSkdHisInVO.getVpsEtaDt().equals(orgPortVO.getVpsEtaDt()) && VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtaDt())){
									sbDiffRmk.append("ETA");
								}
								if(!vslSkdHisInVO.getVpsEtbDt().equals(orgPortVO.getVpsEtbDt()) && VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtbDt())){
									if(sbDiffRmk.length() == 0)	sbDiffRmk.append("ETB");
									else						sbDiffRmk.append("/ETB");
									
								}
								if(!vslSkdHisInVO.getVpsEtdDt().equals(orgPortVO.getVpsEtdDt()) && VSKGeneralUtil.isNotNull(vslSkdHisInVO.getVpsEtdDt())){
									if(sbDiffRmk.length() == 0)	sbDiffRmk.append("ETD");
									else						sbDiffRmk.append("/ETD");
								}
								sbDiffRmk.append(" is changed(with BKGs)");
								
								tmpVslSkdXtraHisVO.setDiffRmk			(sbDiffRmk.toString()				);
								
								iHisDtlTargetKnt ++;
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
							}
							

							/*******BOOKING NOT ATTACHED*******/
							/* Add change of turning port to normal in case of not existing BKGs :by TOP 2016-04-28 */
							if(		"Y".equals(orgPortVO.getTurnPortFlg		())	&& orgPortVO.getTurnPortFlg		() 	!= null
								&&	"N".equals(vslSkdHisInVO.getTurnPortFlg	())	&& vslSkdHisInVO.getTurnPortFlg	() 	!= null
							){
							/* --------------------------------------------------------------------
							 * TURNING PORT FLAG CHANGE����븳 VSK VESSEL SCHEDULE HISTORY
							 * --------------------------------------------------------------------
							 * D	Virtual Port Deletion by turning port flag change
							 * R	Turning Port Change to Normal
							 */
								VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
								
				                //paramVO.setTurnSkdVoyNo					(orgPortVO.getTurnSkdVoyNo	()	);
				                //paramVO.setTurnSkdDirCd					(orgPortVO.getTurnSkdDirCd	()	);
				                //paramVO.setTurnClptIndSeq				(orgPortVO.getTurnClptIndSeq()	);
				                
				                //VslPortSkdVO tmpBkgCheckVO         		= dbDao.checkVslSkdByRowID3      (paramVO);
				                //String  sBkgAttachFlg          			= tmpBkgCheckVO == null ? "N" : "Y";
				                
				                //String  sDiffRmk						= null;
				                //if("Y".equals(sBkgAttachFlg)){
				                //	sDiffRmk							= "Turning Port Change to Normal(with BKGs)";
				                //}else{
				                //	sDiffRmk							= "Turning Port Change to Normal";
				                //}
								
								tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
								tmpVslSkdXtraHisVO.setVskdCngTpCd		("R"								);
								tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
								
								tmpVslSkdXtraHisVO.setDiffRmk			("Turning Port Change to Normal"	);
								
								tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
								tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
								tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
								tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
								tmpVslSkdXtraHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			()	);
								tmpVslSkdXtraHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		()	);
								tmpVslSkdXtraHisVO.setBfrYdCd			(orgPortVO.getYdCd				()	);
								//tmpVslSkdXtraHisVO.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt()			);
								//tmpVslSkdXtraHisVO.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt()			);
								//tmpVslSkdXtraHisVO.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt()			);
								
								//tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt()		);
								//tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt()		);
								//tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt()		);
								
								tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
								tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
								tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
								
								iHisDtlTargetKnt ++;
								
								vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
								
								//--------------------------------------------------------------------------//
								
								VslPortSkdVO tmpVirtualVVDTakenBkg 		= null;
								tmpVirtualVVDTakenBkg 					= dbDao.checkVslSkdByRowIDVirtualVVD(paramVO);
								
								if(tmpVirtualVVDTakenBkg != null){

									VslSkdXtraHisVO tmpVslSkdXtraHisVO2	= new VslSkdXtraHisVO();
									
									tmpVslSkdXtraHisVO2.setVskdTpCd		("P"								);
									
									tmpVslSkdXtraHisVO2.setVskdCngTpCd	("D"								);
									tmpVslSkdXtraHisVO2.setBkgAtchFlg	("Y"								);
									tmpVslSkdXtraHisVO2.setDiffRmk		("Virtual Port Deletion by turning port flag change");
									
									tmpVslSkdXtraHisVO2.setBfrVslSlanCd	(vslSlanCd							);
									tmpVslSkdXtraHisVO2.setBfrVslCd		(vslCd								);
									tmpVslSkdXtraHisVO2.setBfrSkdVoyNo	(orgPortVO.getTurnSkdVoyNo	()		);
									tmpVslSkdXtraHisVO2.setBfrSkdDirCd	(orgPortVO.getTurnSkdDirCd	()		);
									tmpVslSkdXtraHisVO2.setBfrVpsPortCd	(vslSkdHisInVO.getVpsPortCd	()		);
									tmpVslSkdXtraHisVO2.setBfrClptIndSeq(orgPortVO.getTurnClptIndSeq()		);
									tmpVslSkdXtraHisVO2.setBfrYdCd		(orgPortVO.getYdCd			()		);
									
									tmpVslSkdXtraHisVO2.setBfrPfSvcTpCd	(vslSkdHisInVO.getPfSvcTpCd	()		);
									tmpVslSkdXtraHisVO2.setCreUsrId		(vslSkdHisInVO.getUsrId		()		);
									tmpVslSkdXtraHisVO2.setUpdUsrId		(vslSkdHisInVO.getUsrId		()		);
									
									vslSkdWithoutBKGHisVOList.add		(tmpVslSkdXtraHisVO2		);
									
									//----------------------------------------------------------------------//
									
									VslSkdCngNoticeVO 	vslSkdCngNoticeVO2 	= new VslSkdCngNoticeVO			();
									
									vslSkdCngNoticeVO2.setVslCd			(vslCd								);
									vslSkdCngNoticeVO2.setSkdVoyNo		(orgPortVO.getTurnSkdVoyNo	()		);
									vslSkdCngNoticeVO2.setSkdDirCd		(orgPortVO.getTurnSkdDirCd	()		);
									vslSkdCngNoticeVO2.setPortCd		(vslSkdHisInVO.getVpsPortCd	()		);
									vslSkdCngNoticeVO2.setClptIndSeq	(orgPortVO.getTurnClptIndSeq()		);
									vslSkdCngNoticeVO2.setYdCd			(orgPortVO.getYdCd			()		);
									vslSkdCngNoticeVO2.setTypeCd		("D");
									vslSkdCngNoticeVO2.setRemark		("Virtual Port Deletion by turning port flag change");
									
									bkgNoticeList.add					(vslSkdCngNoticeVO2					);
						                  
								}else{
									
									VslSkdXtraHisVO tmpVslSkdXtraHisVO2	= new VslSkdXtraHisVO();
									
									tmpVslSkdXtraHisVO2.setVskdTpCd		("P"								);
									
									tmpVslSkdXtraHisVO2.setVskdCngTpCd	("D"								);
									tmpVslSkdXtraHisVO2.setBkgAtchFlg	("N"								);
									tmpVslSkdXtraHisVO2.setDiffRmk		("Virtual Port Deletion by turning port flag change");
									
									tmpVslSkdXtraHisVO2.setBfrVslSlanCd	(vslSlanCd							);
									tmpVslSkdXtraHisVO2.setBfrVslCd		(vslCd								);
									tmpVslSkdXtraHisVO2.setBfrSkdVoyNo	(orgPortVO.getTurnSkdVoyNo	()		);
									tmpVslSkdXtraHisVO2.setBfrSkdDirCd	(orgPortVO.getTurnSkdDirCd	()		);
									tmpVslSkdXtraHisVO2.setBfrVpsPortCd	(vslSkdHisInVO.getVpsPortCd	()		);
									tmpVslSkdXtraHisVO2.setBfrClptIndSeq(orgPortVO.getTurnClptIndSeq()		);
									tmpVslSkdXtraHisVO2.setBfrYdCd		(orgPortVO.getYdCd			()		);
									
									tmpVslSkdXtraHisVO2.setBfrPfSvcTpCd	(vslSkdHisInVO.getPfSvcTpCd	()		);
									tmpVslSkdXtraHisVO2.setCreUsrId		(vslSkdHisInVO.getUsrId		()		);
									tmpVslSkdXtraHisVO2.setUpdUsrId		(vslSkdHisInVO.getUsrId		()		);
									
									vslSkdWithoutBKGHisVOList.add		(tmpVslSkdXtraHisVO2		);
									
									//----------------------------------------------------------------------//
									
								}	//END OF IF
								
							}
							
							
							/*******BOOKING NOT ATTACHED*******/
							if(		"N".equals(orgPortVO.getTurnPortFlg		())	&& orgPortVO.getTurnPortFlg		() 	!= null
								&&	"Y".equals(vslSkdHisInVO.getTurnPortFlg	())	&& vslSkdHisInVO.getTurnPortFlg	() 	!= null
							){
								/* --------------------------------------------------------------------
								 * TURNING PORT FLAG CHANGE����븳 VSK VESSEL SCHEDULE HISTORY
								 * --------------------------------------------------------------------
								 * A	Add Virtual Port by turning port flag change
								 * C	Normal Port Change to Turning
								 */
								
								if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
									
									VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
									
									tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
									tmpVslSkdXtraHisVO.setVskdCngTpCd		("A"								);
									
					                paramVO.setClptIndSeq          			(vslSkdHisInVO.getNewClptIndSeq ()  );
					                
					                VslPortSkdVO tmpBkgCheckVO         		= dbDao.checkVslSkdByRowID2      (paramVO);
					                String  sBkgAttachFlg          			= tmpBkgCheckVO == null ? "N" : "Y";
					                tmpVslSkdXtraHisVO.setBkgAtchFlg    	(sBkgAttachFlg            			);
									
									tmpVslSkdXtraHisVO.setDiffRmk			("Add Virtual Port by turning port flag change");
									
									tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setBfrVslCd			("****"								);
									tmpVslSkdXtraHisVO.setBfrSkdVoyNo		("****"								);
									tmpVslSkdXtraHisVO.setBfrSkdDirCd		("*"								);
									tmpVslSkdXtraHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			()	);
									tmpVslSkdXtraHisVO.setBfrClptIndSeq		(orgPortVO.getTurnClptIndSeq	()	);
									tmpVslSkdXtraHisVO.setBfrYdCd			(orgPortVO.getYdCd				()	);
									//vskVslSkdHisVO2.setBfrVpsEtaDt		(orgPortVO.getVpsEtaDt()			);
									//vskVslSkdHisVO2.setBfrVpsEtbDt		(orgPortVO.getVpsEtbDt()			);
									//vskVslSkdHisVO2.setBfrVpsEtdDt		(orgPortVO.getVpsEtdDt()			);
									
									//vskVslSkdHisVO2.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt()		);
									//vskVslSkdHisVO2.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt()		);
									//vskVslSkdHisVO2.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt()		);
									
									tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
									tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
									tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
									
									vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
									
								}else{

									VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
									
					                paramVO.setClptIndSeq          			(vslSkdHisInVO.getNewClptIndSeq  ()  );
					                
					                //paramVO.setTurnSkdVoyNo					(vslSkdHisInVO.getTurnSkdVoyNo	()	);
					                //paramVO.setTurnSkdDirCd					(vslSkdHisInVO.getTurnSkdDirCd	()	);
					                //paramVO.setTurnClptIndSeq				(vslSkdHisInVO.getTurnClptIndSeq()	);
					                
					                //VslPortSkdVO tmpBkgCheckVO         		= dbDao.checkVslSkdByRowID3      (paramVO);
					                //String  sBkgAttachFlg          			= tmpBkgCheckVO == null ? "N" : "Y";
									
					                //String  sDiffRmk						= null;
					                //if("Y".equals(sBkgAttachFlg)){
					                //	sDiffRmk							= "Normal Port Change to Turning(with BKGs)";
					                //}else{
					                //	sDiffRmk							= "Normal Port Change to Turning";
					                //}
					                
									tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
									tmpVslSkdXtraHisVO.setVskdCngTpCd		("C"								);
									tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
									
									tmpVslSkdXtraHisVO.setDiffRmk			("Normal Port Change to Turning"	);
									
									tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
									tmpVslSkdXtraHisVO.setBfrVpsPortCd		(orgPortVO.getVpsPortCd			()	);
									tmpVslSkdXtraHisVO.setBfrClptIndSeq		(orgPortVO.getClptIndSeq		()	);
									tmpVslSkdXtraHisVO.setBfrYdCd			(orgPortVO.getYdCd				()	);
									//vskVslSkdHisVO.setBfrVpsEtaDt			(orgPortVO.getVpsEtaDt()			);
									//vskVslSkdHisVO.setBfrVpsEtbDt			(orgPortVO.getVpsEtbDt()			);
									//vskVslSkdHisVO.setBfrVpsEtdDt			(orgPortVO.getVpsEtdDt()			);
									
									//vskVslSkdHisVO.setAftVpsEtaDt			(vslSkdHisInVO.getVpsEtaDt()		);
									//vskVslSkdHisVO.setAftVpsEtbDt			(vslSkdHisInVO.getVpsEtbDt()		);
									//vskVslSkdHisVO.setAftVpsEtdDt			(vslSkdHisInVO.getVpsEtdDt()		);
									
									tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
									tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
									tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
									
									vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
								}
								
								iHisDtlTargetKnt ++;
								//--------------------------------------------------------------------------//
								
							}
							/* Add change of turning port to normal in case of not existing BKGs :by TOP 2016-04-28 */
							
							
						}else{
							
							/** ONLY FOR VIRTUAL PORT **/
							if(VSKGeneralUtil.isVirtualPort(vslSkdHisInVO.getTurnPortIndCd())){
								
								if(vslSkdHisInVO.getSkdCngStsCd() != null && "A".equals(vslSkdHisInVO.getSkdCngStsCd())){
										
									/*************************************************************************
									 * Vessel Schedule Change History Detial VO �앹꽦
									 * -----------------------------------------------------------------------
									 * ADD CALLING
									 *************************************************************************
									 */		
									VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
									
									tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
									tmpVslSkdXtraHisVO.setVskdCngTpCd		("M"								);
									
									
									paramVO.setClptIndSeq					(vslSkdHisInVO.getNewClptIndSeq	()	);
									VslPortSkdVO tmpBkgCheckVO   			= dbDao.checkVslSkdByRowID2			(paramVO);
									String	sBkgAttachFlg					= tmpBkgCheckVO == null ? "N" : "Y";
									tmpVslSkdXtraHisVO.setBkgAtchFlg		(sBkgAttachFlg						);

									
									tmpVslSkdXtraHisVO.setDiffRmk			("Add#1 Virtual Port by add calling of turning port");
									
									tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
									
									tmpVslSkdXtraHisVO.setAftVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setAftVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setAftSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setAftSkdDirCd		(skdDirCd							);
									
									tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
									tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
									tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
									tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
									tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt		()	);
									tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt		()	);
									tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt		()	);
									
									tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
									tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
									tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
									
									tmpVslSkdXtraHisVO.setVtAddCallFlg		(vslSkdHisInVO.getVtAddCallFlg	()	);
									
									iHisDtlTargetKnt++;
									
									vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
									/*************************************************************************
									 */
										
								}else if("".equals(vslSkdHisInVO.getPfEtbDt())){
										
									/*************************************************************************
									 * Vessel Schedule Change History Detial VO �앹꽦
									 * -----------------------------------------------------------------------
									 * ADD CALLING
									 *************************************************************************
									 */		
									VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
									
									tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
									tmpVslSkdXtraHisVO.setVskdCngTpCd		("M"								);
									tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);

									tmpVslSkdXtraHisVO.setDiffRmk			("Add#2 Virtual Port by add calling of turning port");
									
									tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
									
									tmpVslSkdXtraHisVO.setAftVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setAftVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setAftSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setAftSkdDirCd		(skdDirCd							);
									
									tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
									tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
									tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
									tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
									tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt		()	);
									tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt		()	);
									tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt		()	);
									
									tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
									tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
									tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
									
									tmpVslSkdXtraHisVO.setVtAddCallFlg		(vslSkdHisInVO.getVtAddCallFlg	()	);
									
									iHisDtlTargetKnt++;
									
									vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
									/*************************************************************************
									 */
									
								}else{
									
									/*************************************************************************
									 * Vessel Schedule Change History Detial VO �앹꽦
									 * -----------------------------------------------------------------------
									 * Recovered ADD CALLING by Phase Out Cancellation
									 *************************************************************************
									 */		
									VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
									
									tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
									tmpVslSkdXtraHisVO.setVskdCngTpCd		("M"								);
									tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
									
									tmpVslSkdXtraHisVO.setDiffRmk			("Add Virtual Port by change port from normal to turning");
									//Add Virtual Port by another reason
									
									tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
									
									tmpVslSkdXtraHisVO.setAftVslSlanCd		(vslSlanCd							);
									tmpVslSkdXtraHisVO.setAftVslCd			(vslCd								);
									tmpVslSkdXtraHisVO.setAftSkdVoyNo		(skdVoyNo							);
									tmpVslSkdXtraHisVO.setAftSkdDirCd		(skdDirCd							);
									
									tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
									tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
									tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
									tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
									tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt		()	);
									tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt		()	);
									tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt		()	);
									
									tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
									tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
									tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
									
									iHisDtlTargetKnt++;
									
									vslSkdWithoutBKGHisVOList.add			(tmpVslSkdXtraHisVO					);
									/*************************************************************************
									 */
								}
								
							/** ONLY FOR NORMAL+TURNING PORT **/
							}else{
								
								if(			"Y".equals(vslSkdHisInVO.getTurnPortFlg	())	&& vslSkdHisInVO.getTurnPortFlg	() 	!= null
										&&	vslSkdHisInVO.getSkdCngStsCd() != null 		&& "A".equals(vslSkdHisInVO.getSkdCngStsCd()) 
									)
									{
										
										/*************************************************************************
										 * Vessel Schedule Change History Detial VO �앹꽦
										 * -----------------------------------------------------------------------
										 * ADD CALLING
										 *************************************************************************
										 */		
										VslSkdXtraHisVO tmpVslSkdXtraHisVO		= new VslSkdXtraHisVO();
										
										tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
										tmpVslSkdXtraHisVO.setVskdCngTpCd		("A"								);
										tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);

										tmpVslSkdXtraHisVO.setDiffRmk			("Add Port by change port from normal to turning in CST/SKD screen");
										
										tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
										tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
										tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
										tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
										
										tmpVslSkdXtraHisVO.setAftVslSlanCd		(vslSlanCd							);
										tmpVslSkdXtraHisVO.setAftVslCd			(vslCd								);
										tmpVslSkdXtraHisVO.setAftSkdVoyNo		(skdVoyNo							);
										tmpVslSkdXtraHisVO.setAftSkdDirCd		(skdDirCd							);
										
										tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
										tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
										tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
										tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt		()	);
										tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt		()	);
										tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt		()	);
										
										tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
										tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
										tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
										
										tmpVslSkdXtraHisVO.setVtAddCallFlg		(vslSkdHisInVO.getVtAddCallFlg	()	);
										
										iHisDtlTargetKnt++;
										
										vslSkdWithoutBKGHisVOList.add      (tmpVslSkdXtraHisVO						);
										/*************************************************************************
										 */
										
									}else if(	"Y".equals(vslSkdHisInVO.getTurnPortFlg	())	&& vslSkdHisInVO.getTurnPortFlg	() 	!= null
											&&	"".equals(vslSkdHisInVO.getPfEtbDt()) 
											)
									{
											
										/*************************************************************************
										 * Vessel Schedule Change History Detial VO �앹꽦
										 * -----------------------------------------------------------------------
										 * ADD CALLING
										 *************************************************************************
										 */		
										VslSkdXtraHisVO tmpVslSkdXtraHisVO    	= new VslSkdXtraHisVO();
										
										tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
										tmpVslSkdXtraHisVO.setVskdCngTpCd		("A"								);
										tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);

										tmpVslSkdXtraHisVO.setDiffRmk			("Add Port by change port from normal to turning in by VVD screen");
										
										tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
										tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
										tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
										tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
										
										tmpVslSkdXtraHisVO.setAftVslSlanCd		(vslSlanCd							);
										tmpVslSkdXtraHisVO.setAftVslCd			(vslCd								);
										tmpVslSkdXtraHisVO.setAftSkdVoyNo		(skdVoyNo							);
										tmpVslSkdXtraHisVO.setAftSkdDirCd		(skdDirCd							);
										
										tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
										tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
										tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
										tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt		()	);
										tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt		()	);
										tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt		()	);
										
										tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
										tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
										tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
										
										tmpVslSkdXtraHisVO.setVtAddCallFlg		(vslSkdHisInVO.getVtAddCallFlg	()	);
										
										iHisDtlTargetKnt++;
										
										vslSkdWithoutBKGHisVOList.add      		(tmpVslSkdXtraHisVO					);
										/*************************************************************************
										 */
										
									}else{
										
										/*************************************************************************
										 * Vessel Schedule Change History Detial VO �앹꽦
										 * -----------------------------------------------------------------------
										 * Recovered ADD CALLING by Phase Out Cancellation
										 *************************************************************************
										 */		
										VslSkdXtraHisVO tmpVslSkdXtraHisVO    	= new VslSkdXtraHisVO();
										
										tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
										tmpVslSkdXtraHisVO.setVskdCngTpCd		("A"								);
										tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);
										
										tmpVslSkdXtraHisVO.setDiffRmk			("Add Calling Port by row add or add calling function");
										
										tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
										tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
										tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
										tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
										
										tmpVslSkdXtraHisVO.setAftVslSlanCd		(vslSlanCd							);
										tmpVslSkdXtraHisVO.setAftVslCd			(vslCd								);
										tmpVslSkdXtraHisVO.setAftSkdVoyNo		(skdVoyNo							);
										tmpVslSkdXtraHisVO.setAftSkdDirCd		(skdDirCd							);
										
										tmpVslSkdXtraHisVO.setAftVpsPortCd		(vslSkdHisInVO.getVpsPortCd		()	);
										tmpVslSkdXtraHisVO.setAftClptIndSeq		(vslSkdHisInVO.getNewClptIndSeq	()	);
										tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd			()	);
										tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq	()	);
										tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt		()	);
										tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt		()	);
										tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt		()	);
										
										tmpVslSkdXtraHisVO.setBfrPfSvcTpCd		(vslSkdHisInVO.getPfSvcTpCd		()	);
										tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
										tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
										
										iHisDtlTargetKnt++;
										
										vslSkdWithoutBKGHisVOList.add      		(tmpVslSkdXtraHisVO					);
										/*************************************************************************
										 */
									}
								
							}
							
							

							
						}
						/********** END OF VO is Not Null "orgPortVO" **********/
						
						////////////////////////// 2013-08-03 Vessel Schedule Change History Detail 愿�━瑜��꾪븳 VO(VslSkdCngHisDtlVO) �앹꽦 /////////////
						////////////////////////// None Unassigned Booking - Vessel Schedule List //////////////////////////////////////////////////

					}	/** END OF IF ... BOOKING ATTACHED OR NOT ATTACHED **/
					

					if(iHisDtlTargetKnt == 0){
						/*************************************************************************
						 * Vessel Schedule Change History Detial VO �앹꽦
						 * -----------------------------------------------------------------------
						 * NORMAL
						 *************************************************************************
						 */		
						VslSkdXtraHisVO tmpVslSkdXtraHisVO    	= new VslSkdXtraHisVO();
						
						tmpVslSkdXtraHisVO.setIstargetforskdhisbyuser(false);
						
						tmpVslSkdXtraHisVO.setVskdTpCd			("P"								);
						tmpVslSkdXtraHisVO.setVskdCngTpCd		("U"								);
						tmpVslSkdXtraHisVO.setBkgAtchFlg		("N"								);

						tmpVslSkdXtraHisVO.setDiffRmk			("Schedule Update for generating ");
						
						tmpVslSkdXtraHisVO.setBfrVslSlanCd		(vslSlanCd							);
						tmpVslSkdXtraHisVO.setBfrVslCd			(vslCd								);
						tmpVslSkdXtraHisVO.setBfrSkdVoyNo		(skdVoyNo							);
						tmpVslSkdXtraHisVO.setBfrSkdDirCd		(skdDirCd							);
						
						//tmpVslSkdXtraHisVO.setAftVpsPortCd	(vslSkdHisInVO.getVpsPortCd	()		);
						//tmpVslSkdXtraHisVO.setAftClptIndSeq	(vslSkdHisInVO.getNewClptIndSeq()	);
						//tmpVslSkdXtraHisVO.setAftYdCd			(vslSkdHisInVO.getYdCd()			);
						//tmpVslSkdXtraHisVO.setAftCallYdIndSeq	(vslSkdHisInVO.getCallYdIndSeq()	);
						//tmpVslSkdXtraHisVO.setAftVpsEtaDt		(vslSkdHisInVO.getVpsEtaDt()		);
						//tmpVslSkdXtraHisVO.setAftVpsEtbDt		(vslSkdHisInVO.getVpsEtbDt()		);
						//tmpVslSkdXtraHisVO.setAftVpsEtdDt		(vslSkdHisInVO.getVpsEtdDt()		);
						
						tmpVslSkdXtraHisVO.setCreUsrId			(vslSkdHisInVO.getUsrId			()	);
						tmpVslSkdXtraHisVO.setUpdUsrId			(vslSkdHisInVO.getUsrId			()	);
						
						vslSkdWithoutBKGHisVOList.add      		(tmpVslSkdXtraHisVO					);
						/*************************************************************************
						 */	
					}	
						
					preVvdCd = curVvdCd;
				}
					
				/*******************************************************
				 * For Loop Statement END for vslSkdHisInVOs
				 *******************************************************
				 */					
					
			}//end for
				
				
			// in case Master change, History START
			if(masterVOList != null && masterVOList.size()>0){
				for(VskVslSkdVO vskVslSkdVO : masterVOList){
					//***** 'L' : Lane change *****
					for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
						if(vskVslSkdVO.getVslCd().equals(vslSkdHisInVO.getVslCd())
								&& vskVslSkdVO.getSkdVoyNo().equals(vslSkdHisInVO.getSkdVoyNo())
								&& vskVslSkdVO.getSkdDirCd().equals(vslSkdHisInVO.getSkdDirCd())){
							//***** 'L' : Lane change *****
							if(VSKGeneralUtil.isNotNull(vslSkdHisInVO.getCngLaneCd())){
								if(!vslSkdHisInVO.getVslSlanCd().equals(vslSkdHisInVO.getCngLaneCd())){
									VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
									
									vskVslSkdHisVO.setVskdTpCd		("M");
									vskVslSkdHisVO.setBfrVslCd		(vslSkdHisInVO.getVslCd		());
									vskVslSkdHisVO.setBfrSkdVoyNo	(vslSkdHisInVO.getSkdVoyNo	());
									vskVslSkdHisVO.setBfrSkdDirCd	(vslSkdHisInVO.getSkdDirCd	());
									vskVslSkdHisVO.setBfrVslSlanCd	(vslSkdHisInVO.getVslSlanCd	());
									vskVslSkdHisVO.setAftVslCd		(vslSkdHisInVO.getVslCd		());
									vskVslSkdHisVO.setAftSkdVoyNo	(vslSkdHisInVO.getSkdVoyNo	());
									vskVslSkdHisVO.setAftSkdDirCd	(vslSkdHisInVO.getSkdDirCd	());
									vskVslSkdHisVO.setAftVslSlanCd	(vslSkdHisInVO.getCngLaneCd	());
									vskVslSkdHisVO.setVskdCngTpCd	("L");								//'L' : Lane change
									vskVslSkdHisVO.setCreUsrId		(vslSkdHisInVO.getUsrId		());
									vskVslSkdHisVO.setUpdUsrId		(vslSkdHisInVO.getUsrId		());
									vskVslSkdHisVO.setBkgAtchFlg	("Y");
									
									historyList.add					(vskVslSkdHisVO);
								}
							}
							
							break;
						}
					}
					
					boolean vvdDelFlg = false;
					for(VslSkdHisInVO vslSkdHisInVO : vslSkdHisInVOs){
						if(vskVslSkdVO.getVslCd().equals(vslSkdHisInVO.getVslCd())
								&& vskVslSkdVO.getSkdVoyNo().equals(vslSkdHisInVO.getSkdVoyNo())
								&& vskVslSkdVO.getSkdDirCd().equals(vslSkdHisInVO.getSkdDirCd())){
							vvdDelFlg = true;
							//***** 'V' : VVD change *****
							if(!"D".equals(vslSkdHisInVO.getIbflag())){
								vvdDelFlg = false;
								break;
							}
						}
					}

					//***** 'V' : VVD change *****
					if(vvdDelFlg){
						VskVslSkdHisVO vskVslSkdHisVO = new VskVslSkdHisVO();
						
						vskVslSkdHisVO.setVskdTpCd		("M");
						vskVslSkdHisVO.setBfrVslCd		(vskVslSkdVO.getVslCd	());
						vskVslSkdHisVO.setBfrSkdVoyNo	(vskVslSkdVO.getSkdVoyNo());
						vskVslSkdHisVO.setBfrSkdDirCd	(vskVslSkdVO.getSkdDirCd());
						vskVslSkdHisVO.setVskdCngTpCd	("V");							//'V' : VVD change
						vskVslSkdHisVO.setCreUsrId		(vskVslSkdVO.getUpdUsrId());
						vskVslSkdHisVO.setUpdUsrId		(vskVslSkdVO.getUpdUsrId());
						vskVslSkdHisVO.setBkgAtchFlg	("Y");
						
						historyList.add					(vskVslSkdHisVO);
					}
				}
			}
			// in case of Master change, History END
			
			vslSkdChgStsGRPVO.setVslSkdCngNoticeVOs		(bkgNoticeList		);	// BKG
			vslSkdChgStsGRPVO.setVslSkdCngUpdateVOs		(bkgUpdateList		);	// BKG
			vslSkdChgStsGRPVO.setSceActRcvIfVOs			(copNoticeList		);	// COP
			
			/** GENERATING VSL SKD CHANGE HISTORY DETAIL :: VSK_VSL_SKD_HIS + VSK_VSL_SKD_CNG_HIS_DTL **/
			vslSkdChgStsGRPVO.setVslSkdXtraHisVOs		(vslSkdWithoutBKGHisVOList);	

//				********************* History Save *********************
			if(historyList != null && historyList.size()>0){
				dbDao.addVskVslSkdHis(historyList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * Setting Simulation Data to Coastal Schedule
	 * 
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageSettleByVvd(CstSkdByVvdVO[] cstSkdByVvdVOs, SwapCstSkdSimVO swapCstSkdSimVO, SignOnUserAccount account) throws EventException {
		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		try {
			VskSwapCstSimVO paramVO = new VskSwapCstSimVO();
			paramVO.setSimDt(swapCstSkdSimVO.getSimDt());
			paramVO.setSimNo(swapCstSkdSimVO.getSimNo());
			
			List<String> chkSims = dbDao.searchCstSimDifference(paramVO);
			if(chkSims != null && chkSims.size()>0){
				int errCnt = chkSims.size();
				StringBuilder errMsg = new StringBuilder();
				errMsg.append("\n------------------------------------------------------------------");
				for(int i=0; i<errCnt; i++){
					errMsg.append("\n" + chkSims.get(i));
				}
				throw new EventException(new ErrorHandler("VSK10055", new String[]{errMsg.toString()}).getMessage());
			}
			
			List<ActualSkdBySimNoVO> actSimList = dbDao.searchActualSkdBySimNo (paramVO);
			if(actSimList != null && actSimList.size()>0){
				cstSkdByVvdVOs = simulationDataCheckByActual(actSimList, cstSkdByVvdVOs);
				vslSkdChgStsGRPVO = manageCstSkdByVvd(cstSkdByVvdVOs, account);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * in case Actual input at Settlement from Recovery Plan
	 * Updating Actual Data to Simulation Data
	 * 
	 * @param List<ActualSkdBySimNoVO> actualSkdBySimNoVOs	: retrieving Data in Coastal
	 * @param CstSkdByVvdVO[] cstSkdByVvdVOs				: User Simulation Data
	 * @return CstSkdByVvdVO[]
	 */
	private CstSkdByVvdVO[] simulationDataCheckByActual(List<ActualSkdBySimNoVO> actualSkdBySimNoVOs, CstSkdByVvdVO[] cstSkdByVvdVOs) throws EventException {
		try{
			if(actualSkdBySimNoVOs != null && actualSkdBySimNoVOs.size() > 0 && cstSkdByVvdVOs != null && cstSkdByVvdVOs.length > 0){
				for(ActualSkdBySimNoVO actualSkdBySimNoVO:actualSkdBySimNoVOs){
					String portSkdStsCd = actualSkdBySimNoVO.getPortSkdStsCd();
					if(VSKGeneralUtil.isNotNull(portSkdStsCd)){		//Actual Data
						int voCnt = cstSkdByVvdVOs.length;
						for(int i=0; i<voCnt; i++){
							if(actualSkdBySimNoVO.getVpsPortCd().equals(cstSkdByVvdVOs[i].getVpsPortCd())
									&& actualSkdBySimNoVO.getClptIndSeq().equals(cstSkdByVvdVOs[i].getClptIndSeq())){
								if("Y".equals(cstSkdByVvdVOs[i].getUsrHdnFlg())){
									String etbDt = cstSkdByVvdVOs[i].getVpsEtbDt();
									String etdDt = cstSkdByVvdVOs[i].getVpsEtdDt();
									ObjectCloner.build(actualSkdBySimNoVO, cstSkdByVvdVOs[i]);
									
									if("A".equals(portSkdStsCd)){
										cstSkdByVvdVOs[i].setVpsEtaDt(actualSkdBySimNoVO.getActArrDt());
										cstSkdByVvdVOs[i].setVpsEtbDt(etbDt);
										cstSkdByVvdVOs[i].setVpsEtdDt(etdDt);
									}else if("B".equals(portSkdStsCd)){
										cstSkdByVvdVOs[i].setVpsEtaDt(actualSkdBySimNoVO.getActArrDt());
										cstSkdByVvdVOs[i].setVpsEtbDt(actualSkdBySimNoVO.getActBrthDt());
										cstSkdByVvdVOs[i].setVpsEtdDt(etdDt);
									}else if("D".equals(portSkdStsCd)){
										cstSkdByVvdVOs[i].setVpsEtaDt(actualSkdBySimNoVO.getActArrDt());
										cstSkdByVvdVOs[i].setVpsEtbDt(actualSkdBySimNoVO.getActBrthDt());
										cstSkdByVvdVOs[i].setVpsEtdDt(actualSkdBySimNoVO.getActDepDt());
									}
									
									break;
								}else{
									throw new EventException(new ErrorHandler("VSK10056").getMessage());
								}
							}
						}// end for
					}
				}// end for
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return cstSkdByVvdVOs;
	}
	
	
	/**
	 * Managing VVD Remark<br>
	 * 
	 * @param CstSkdByVvdVO cstSkdByVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstSkdByRmk(CstSkdByVvdVO cstSkdByVvdVO, SignOnUserAccount account) throws EventException {
		try {
			List<VskVslSkdVO> updateVoList = new ArrayList<VskVslSkdVO>();
			VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
			
			String userId = currentUserId(account, cstSkdByVvdVO.getUpdUsrId());
			
			vskVslSkdVO.setVslCd(cstSkdByVvdVO.getVslCd());
			vskVslSkdVO.setSkdVoyNo(cstSkdByVvdVO.getSkdVoyNo());
			vskVslSkdVO.setSkdDirCd(cstSkdByVvdVO.getSkdDirCd());
			vskVslSkdVO.setVslSlanCd(cstSkdByVvdVO.getVslSlanCd());
			vskVslSkdVO.setPfSkdTpCd(cstSkdByVvdVO.getPfSvcTpCd());
			vskVslSkdVO.setSkdRmk(cstSkdByVvdVO.getSkdRmk());
			vskVslSkdVO.setUpdUsrId(userId);
			updateVoList.add(vskVslSkdVO);
			
			if(updateVoList != null && updateVoList.size() > 0){
				dbDao.modifyVskVslSkdByRmk(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Checking turn in case of data from SPP
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return VskVslPortSkdVO
	 * @exception EventException
	 */
	private VskVslPortSkdVO sppTurnInfoVaild(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			if("ESVCUSER".equals(vskVslPortSkdVO.getUpdUsrId())){
				if(! "Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
					paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
					paramVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
					paramVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
					
					// Turnning Port
					List<VskVslPortSkdVO> turnPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(paramVO);
					
					if(turnPortVoList != null && turnPortVoList.size() > 0){
						for(VskVslPortSkdVO turnPortVo : turnPortVoList){
							if(vskVslPortSkdVO.getVpsPortCd().equals(turnPortVo.getVpsPortCd()) && vskVslPortSkdVO.getClptIndSeq().equals(turnPortVo.getClptIndSeq())){
								if("Y".equals(turnPortVo.getTurnPortFlg())){
									vskVslPortSkdVO.setTurnPortFlg(turnPortVo.getTurnPortFlg());
									vskVslPortSkdVO.setTurnSkdVoyNo(turnPortVo.getTurnSkdVoyNo());
									vskVslPortSkdVO.setTurnSkdDirCd(turnPortVo.getTurnSkdDirCd());
									vskVslPortSkdVO.setTurnClptIndSeq(turnPortVo.getTurnClptIndSeq());
								}
							}
						}
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vskVslPortSkdVO;
	}
	
	/**
	 * Creating VskVslSkdVO dataset with VskVslPortSkdVO
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return VskVslSkdVO
	 * @exception EventException
	 */
	private VskVslSkdVO makeVskVslSkdDataSet(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
		
		try{
			VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
			
			paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
			paramVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
			paramVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
			paramVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
			paramVO.setClptIndSeq(vskVslPortSkdVO.getClptIndSeq());
			
			if("Y".equals(dbDao.checkFirstCallingPort(paramVO))){
				vskVslSkdVO.setVslCd(vskVslPortSkdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
				vskVslSkdVO.setStPortCd(vskVslPortSkdVO.getVpsPortCd());
				vskVslSkdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
				vskVslSkdVO.setN1stPortBrthDt(vskVslPortSkdVO.getVpsEtbDt());
				vskVslSkdVO.setUpdUsrId(vskVslPortSkdVO.getUpdUsrId());
			}else{
				vskVslSkdVO.setVslCd(vskVslPortSkdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
				vskVslSkdVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
				vskVslSkdVO.setUpdUsrId(vskVslPortSkdVO.getUpdUsrId());
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return vskVslSkdVO;
	}
	
	/**
	 * Retrieving ActCrrCd
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return VskVslSkdVO
	 * @exception EventException
	 */
	private VskVslSkdVO addActCrrCd(VskVslSkdVO vskVslSkdVO) throws EventException {
		try{
			vskVslSkdVO.setActCrrCd(dbDao.searchCarrierCode(vskVslSkdVO.getVslCd()));
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return vskVslSkdVO;
	}
	
	/**
	 * Changing and Deleting changed Vessel Port SKD
	 * 
	 * @param SwapCstGRPVO swapCstGRPVO
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdByActual(SwapCstGRPVO swapCstGRPVO) throws EventException {
		
		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		
		try {
			VskVslPortSkdVO vskVslPortSkdVO = sppTurnInfoVaild(swapCstGRPVO.getVskVslPortSkdVO());
			List<VskVslPortSkdVO> 	actPortList 	= new ArrayList<VskVslPortSkdVO>();
			List<VvdVO> 			erpVvdVOs 		= new ArrayList<VvdVO>();
			
			actPortList.add(vskVslPortSkdVO);
			
//			***************** AutoUpdate Data Set START *****************
			SwapCstGRPVO 			autoGRPVO 		= manageAutoSkdUpdate(vskVslPortSkdVO);
			
			List<VskVslSkdVO> 		autoVOList 		= autoGRPVO.getVskVslSkdVOList();
			List<VskVslPortSkdVO> 	autoPortVOList 	= autoGRPVO.getVskVslPortSkdVOList();
//			***************** AutoUpdate Data Set  END  *****************
			
//			***************** History START *****************
			if(autoPortVOList != null && autoPortVOList.size()>0){
				vslSkdChgStsGRPVO = manageVslSkdChgSts(makeHistoryDataSetByActual(autoPortVOList));
			}else{
				vslSkdChgStsGRPVO = manageVslSkdChgSts(makeHistoryDataSetByActual(actPortList));
			}
//			***************** History  END  *****************

//			***************** AutoUpdate START *****************
			
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			if(autoVOList == null || autoVOList.size() < 1){
				autoVOList = new ArrayList<VskVslSkdVO>();
				
				//:for blocking unexpected actual carrier code update
				//:2016-03-23:by TOP://
				autoVOList.add(addActCrrCd(makeVskVslSkdDataSet(vskVslPortSkdVO)));
				
//				dbDao.modifyVskVslSkd(swapCstGRPVO.getVskVslSkdVOList());
			}
			
			dbDao.modifyVskVslSkd(autoVOList);
			// :: VIPS START ::
			// System.out.println("VIPS[modifyVskVslSkd2]");
			for(VskVslSkdVO vo : autoVOList) {
				List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
				for(VskVslSkdVO row : list) {
					this.mVskVslSkdList.add(row);
				}
			}
			// :: VIPS END ::
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			
			/* ============================================================================
			 * Creation for Vessel Schedule History ::2015-05-08::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_HIS
			 * ============================================================================
			 */
			
			//::jskjskjsk::2015-05-08:://if(autoVOList != null && autoVOList.size() > 0){
				
				//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_ACT_AutoUpdate] started!!! :: \n");

				////this.createVslSkdChangeHistory(autoVOList, null, "UPDATE_ACT_AutoUpdate");	
				
				//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_ACT_AutoUpdate] finished!!! :: \n");
			//::jskjskjsk::2015-05-08:://}
			
			/* ----------------------------------------------------------------------------
			 * Vessel Schedule History 愿�━(Header+Detail) Finished ::2015-05-08::
			 * ============================================================================
			 */	
			
			
			if(autoPortVOList != null && autoPortVOList.size()>0){
				dbDao.modifyVskVslPortSkdByAutoUpdate(autoPortVOList);
			}
			// Handling Virtual
			if(autoPortVOList != null && autoPortVOList.size()>0){
				List<VskVslPortSkdVO> autoVirtualPortVOList = setAutoVirtualData(autoPortVOList);
				dbDao.modifyVskVslPortSkdByAutoUpdate(autoVirtualPortVOList);
			}
			
			// Handling Next Data
			if(autoPortVOList != null && autoPortVOList.size()>0){
				List<VskVslPortSkdVO> autoNextPortVOList = setAutoNextData(autoPortVOList);
				dbDao.modifyVskVslPortSkdByAutoUpdate(autoNextPortVOList);
			}
//			***************** AutoUpdate  END  *****************
			

//			***************** Saving user input data START *****************
			VskVslPortSkdVO virtualPortVO = null;
			//Virtual Port Update
			if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
//				VskVslPortSkdVO virtualPortVO = new VskVslPortSkdVO();
				virtualPortVO = new VskVslPortSkdVO();
				
				virtualPortVO.setVslCd(vskVslPortSkdVO.getVslCd());
				virtualPortVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
				virtualPortVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
				virtualPortVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
				virtualPortVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
				virtualPortVO.setPortSkdStsCd(vskVslPortSkdVO.getPortSkdStsCd());
				virtualPortVO.setYdCd(vskVslPortSkdVO.getYdCd());
				virtualPortVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
				virtualPortVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
				virtualPortVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
				virtualPortVO.setActInpFlg(vskVslPortSkdVO.getActInpFlg());
				virtualPortVO.setSlanCd(vskVslPortSkdVO.getSlanCd());
				
				virtualPortVO.setUpdUsrId(vskVslPortSkdVO.getUpdUsrId());
				actPortList.add(virtualPortVO);
			}
			
			dbDao.modifyVskVslPortSkdByActual(actPortList);
//			***************** Saving user input data  END  *****************
			

			
//			********************* Transmitting changed VVD to ERP *********************
			if(autoVOList != null && autoVOList.size()>0){
				for(VskVslSkdVO vskVslSkdVO : autoVOList){
					VvdVO vvdVO = new VvdVO();
					vvdVO.setIbflag("U");
					vvdVO.setVslCd(vskVslSkdVO.getVslCd());
					vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
					vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
					vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
					erpVvdVOs.add(vvdVO);
				}
				
				if(virtualPortVO!=null){
					VvdVO vvdVO = new VvdVO();
					vvdVO.setIbflag("U");
					vvdVO.setVslCd(virtualPortVO.getVslCd());
					vvdVO.setSkdVoyNo(virtualPortVO.getSkdVoyNo());
					vvdVO.setSkdDirCd(virtualPortVO.getSkdDirCd());
					vvdVO.setVslSlanCd(virtualPortVO.getSlanCd());
					erpVvdVOs.add(vvdVO);
				}
			}
			
			vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);

			if(erpVvdVOs != null && erpVvdVOs.size() > 0){
//				[Yard Call Ind Seq]============================================
				dbDao.modifyYardCallSeq(erpVvdVOs);
				
//				[Booking BDR LOG]============================================
				List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
				vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);
			}
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * Creating Virtual Data in Auto Update
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @return List<VskVslPortSkdVO>
	 */
	private List<VskVslPortSkdVO> setAutoVirtualData(List<VskVslPortSkdVO> vskVslPortSkdVOList){
		List<VskVslPortSkdVO> rstVOList = new ArrayList<VskVslPortSkdVO>();
		
		if(vskVslPortSkdVOList != null && vskVslPortSkdVOList.size()>0){
			for(VskVslPortSkdVO vskVslPortSkdVO : vskVslPortSkdVOList){
				if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					vskVslPortSkdVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					vskVslPortSkdVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					vskVslPortSkdVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					vskVslPortSkdVO.setTurnSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
					vskVslPortSkdVO.setTurnSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
					vskVslPortSkdVO.setTurnClptIndSeq(vskVslPortSkdVO.getClptIndSeq());
					
					rstVOList.add(vskVslPortSkdVO);
				}
			}
		}
		
		return rstVOList;
	}
	
	/**
	 * Creating Next Turnning Data of Virtual Data in Auto Update
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @return List<VskVslPortSkdVO>
	 */
	private List<VskVslPortSkdVO> setAutoNextData(List<VskVslPortSkdVO> vskVslPortSkdVOList){
		List<VskVslPortSkdVO> rstVOList = new ArrayList<VskVslPortSkdVO>();
		
		if(vskVslPortSkdVOList != null && vskVslPortSkdVOList.size()>0){
			int listCnt = vskVslPortSkdVOList.size();
			for(int i=0; i<listCnt; i++){
				if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVOList.get(i).getTurnPortIndCd())){
					VskVslPortSkdVO vskVslPortSkdVO = vskVslPortSkdVOList.get(i);
					vskVslPortSkdVO.setSkdVoyNo(vskVslPortSkdVOList.get(i).getTurnSkdVoyNo());
					vskVslPortSkdVO.setSkdDirCd(vskVslPortSkdVOList.get(i).getTurnSkdDirCd());
					vskVslPortSkdVO.setClptIndSeq(vskVslPortSkdVOList.get(i).getTurnClptIndSeq());
					vskVslPortSkdVO.setTurnSkdVoyNo(vskVslPortSkdVOList.get(i).getSkdVoyNo());
					vskVslPortSkdVO.setTurnSkdDirCd(vskVslPortSkdVOList.get(i).getSkdDirCd());
					vskVslPortSkdVO.setTurnClptIndSeq(vskVslPortSkdVOList.get(i).getClptIndSeq());
					
					rstVOList.add(vskVslPortSkdVO);
				}
			}
		}
		
		return rstVOList;
	}
	
	/**
	 * Creating History DataSet
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOList
	 * @return List<VslSkdHisInVO>
	 * @exception EventException
	 */
	private List<VslSkdHisInVO> makeHistoryDataSetByActual(List<VskVslPortSkdVO> vskVslPortSkdVOList) throws EventException {
		List<VslSkdHisInVO> vslSkdHisInVOList = new ArrayList<VslSkdHisInVO>();
		
		try{
			for(VskVslPortSkdVO vskVslPortSkdVO : vskVslPortSkdVOList) {
				VslSkdHisInVO vslSkdHisInVO = new VslSkdHisInVO();
				
				vslSkdHisInVO.setIbflag("U");
				vslSkdHisInVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
				vslSkdHisInVO.setVslCd(vskVslPortSkdVO.getVslCd());
				vslSkdHisInVO.setSkdVoyNo(vskVslPortSkdVO.getSkdVoyNo());
				vslSkdHisInVO.setSkdDirCd(vskVslPortSkdVO.getSkdDirCd());
				vslSkdHisInVO.setVslSlanCd(vskVslPortSkdVO.getSlanCd());
				vslSkdHisInVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
				vslSkdHisInVO.setClptIndSeq(vskVslPortSkdVO.getClptIndSeq());
				vslSkdHisInVO.setYdCd(vskVslPortSkdVO.getYdCd());
				vslSkdHisInVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
				vslSkdHisInVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
				vslSkdHisInVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
				vslSkdHisInVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
				vslSkdHisInVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
				vslSkdHisInVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
				vslSkdHisInVO.setUsrId(vskVslPortSkdVO.getUpdUsrId());
				vslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getClptIndSeq());
				
				vslSkdHisInVOList.add(vslSkdHisInVO);
				
				//Virtual Port History Setting.
				if("Y".equals(vskVslPortSkdVO.getTurnPortFlg())){
					String slanCd = vskVslPortSkdVO.getSlanCd();
					
					// Retrieving Lane of Turnning Port
					VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
					paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
					paramVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					paramVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					
					// Virtual Port
					List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(paramVO);
					if(virtualPortVoList != null && virtualPortVoList.size() > 0){
						slanCd = virtualPortVoList.get(0).getSlanCd();
					}
					
					VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();
					
					virtualVslSkdHisInVO.setIbflag("U");
					virtualVslSkdHisInVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
					virtualVslSkdHisInVO.setVslCd(vskVslPortSkdVO.getVslCd());
					virtualVslSkdHisInVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					virtualVslSkdHisInVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					virtualVslSkdHisInVO.setVslSlanCd(slanCd);
					virtualVslSkdHisInVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
					virtualVslSkdHisInVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					virtualVslSkdHisInVO.setYdCd(vskVslPortSkdVO.getYdCd());
					virtualVslSkdHisInVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
					virtualVslSkdHisInVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
					virtualVslSkdHisInVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
					virtualVslSkdHisInVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
					virtualVslSkdHisInVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
					virtualVslSkdHisInVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
					virtualVslSkdHisInVO.setUsrId(vskVslPortSkdVO.getUpdUsrId());
					virtualVslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					
					vslSkdHisInVOList.add(virtualVslSkdHisInVO);
				}
				
				//Next Port History Setting.
				if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVO.getTurnPortIndCd())){
					String slanCd = vskVslPortSkdVO.getSlanCd();
					
					// Retrieving Lane of Next Turn Port
					VskVslPortSkdVO paramVO = new VskVslPortSkdVO();
					paramVO.setVslCd(vskVslPortSkdVO.getVslCd());
					paramVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					paramVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					
					// Next Turn Port
					List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(paramVO);
					if(virtualPortVoList != null && virtualPortVoList.size() > 0){
						slanCd = virtualPortVoList.get(0).getSlanCd();
					}
					
					VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();
					
					nxtVslSkdHisInVO.setIbflag("U");
					nxtVslSkdHisInVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
					nxtVslSkdHisInVO.setVslCd(vskVslPortSkdVO.getVslCd());
					nxtVslSkdHisInVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
					nxtVslSkdHisInVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
					nxtVslSkdHisInVO.setVslSlanCd(slanCd);
					nxtVslSkdHisInVO.setVpsPortCd(vskVslPortSkdVO.getVpsPortCd());
					nxtVslSkdHisInVO.setClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					nxtVslSkdHisInVO.setYdCd(vskVslPortSkdVO.getYdCd());
					nxtVslSkdHisInVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
					nxtVslSkdHisInVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
					nxtVslSkdHisInVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
					nxtVslSkdHisInVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
					nxtVslSkdHisInVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
					nxtVslSkdHisInVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
					nxtVslSkdHisInVO.setUsrId(vskVslPortSkdVO.getUpdUsrId());
					nxtVslSkdHisInVO.setNewClptIndSeq(vskVslPortSkdVO.getTurnClptIndSeq());
					
					vslSkdHisInVOList.add(nxtVslSkdHisInVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vslSkdHisInVOList;
	}
	
	/**
	 * Control SKD automatically when SKD change
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return SwapCstGRPVO
	 * @exception EventException
	 */
	private SwapCstGRPVO manageAutoSkdUpdate(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		SwapCstGRPVO swapCstGRPVO = new SwapCstGRPVO();
		try{
			String usrId = vskVslPortSkdVO.getUpdUsrId();
			List<VskVslPortSkdVO> rebuildSkdList = null;
			List<VskVslPortSkdVO> orgList = searchAutoSkdUpdate(vskVslPortSkdVO);	//Retrieving target VVD for auto update
			
			String portSkdStsCd = vskVslPortSkdVO.getPortSkdStsCd();
			long dlayTime = 0L;		// Delay Time
			long recvTime = 0L;		// Recovery Time
			
			if(orgList != null && orgList.size()>0 && isUsedActualSkd(orgList)){
				if("A".equals(portSkdStsCd)){
					String orgEtaDt = orgList.get(0).getVpsEtaDt();
					String usrEtaDt = vskVslPortSkdVO.getVpsEtaDt();
					
					int dlayFlg = isDlaySkdDate(orgEtaDt, usrEtaDt);
					if(dlayFlg < 0){
						dlayTime = diffSkdDate(orgEtaDt, usrEtaDt);
					}else if(dlayFlg > 0){
						recvTime = diffSkdDate(orgEtaDt, usrEtaDt);
					}
				}else if("B".equals(portSkdStsCd)){
					String orgEtbDt = orgList.get(0).getVpsEtbDt();
					String usrEtbDt = vskVslPortSkdVO.getVpsEtbDt();
					
					int dlayFlg = isDlaySkdDate(orgEtbDt, usrEtbDt);
					if(dlayFlg < 0){
						dlayTime = diffSkdDate(orgEtbDt, usrEtbDt);
					}else if(dlayFlg > 0){
						recvTime = diffSkdDate(orgEtbDt, usrEtbDt);
					}
				}else if("D".equals(portSkdStsCd)){
					String orgEtdDt = orgList.get(0).getVpsEtdDt();
					String usrEtdDt = vskVslPortSkdVO.getVpsEtdDt();
					
					int dlayFlg = isDlaySkdDate(orgEtdDt, usrEtdDt);
					if(dlayFlg < 0){
						dlayTime = diffSkdDate(orgEtdDt, usrEtdDt);
					}else if(dlayFlg > 0){
						recvTime = diffSkdDate(orgEtdDt, usrEtdDt);
					}
				}

				if(dlayTime > 0){
					rebuildSkdList = calcDelayAutoSkdUpdate(orgList, vskVslPortSkdVO, (int)dlayTime, portSkdStsCd, usrId);
				}else if(recvTime < 0){
					rebuildSkdList = calcRecoveryAutoSkdUpdate(orgList, vskVslPortSkdVO, (int)recvTime, portSkdStsCd, usrId);
				}

				if(rebuildSkdList != null && rebuildSkdList.size()>0){
					VskVslPortSkdVO firstRebuidVO = rebuildSkdList.get(0);

					List<VskVslSkdVO> vskVslSkdVOList = new ArrayList<VskVslSkdVO>();
					
//					=====================================================================================
					//:for blocking unexpected actual carrier code update
					//:2016-03-23:by TOP://
					vskVslSkdVOList.add(addActCrrCd(makeVskVslSkdDataSet(firstRebuidVO)));
//					=====================================================================================
					
					boolean isFirstPort = false;
					String preVVD = "";
					String curVVD = "";
					
					for(VskVslPortSkdVO rebuildVO : rebuildSkdList){
						String vslCd = rebuildVO.getVslCd();
						String skdVoyNo = rebuildVO.getSkdVoyNo();
						String skdDirCd = rebuildVO.getSkdDirCd();
						String vpsPortCd = rebuildVO.getVpsPortCd();
						String clptIndSeq = rebuildVO.getClptIndSeq();
						
						curVVD = vslCd + skdVoyNo + skdDirCd;

						if(!"".equals(preVVD)){
							if(!preVVD.equals(curVVD)){
								isFirstPort = true;
							}
						}
						
						if(isFirstPort){
							VskVslPortSkdVO chkParamVO = new VskVslPortSkdVO();
							
							chkParamVO.setVslCd(vslCd);
							chkParamVO.setSkdVoyNo(skdVoyNo);
							chkParamVO.setSkdDirCd(skdDirCd);
							chkParamVO.setVpsPortCd(vpsPortCd);
							chkParamVO.setClptIndSeq(clptIndSeq);
							if("Y".equals(dbDao.checkFirstCallingPort(chkParamVO))){
								VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
								
								vskVslSkdVO.setVslCd(vslCd);
								vskVslSkdVO.setSkdVoyNo(skdVoyNo);
								vskVslSkdVO.setSkdDirCd(skdDirCd);
								vskVslSkdVO.setStPortCd(vpsPortCd);
								vskVslSkdVO.setVslSlanCd(rebuildVO.getSlanCd());
								vskVslSkdVO.setN1stPortBrthDt(rebuildVO.getVpsEtbDt());
								vskVslSkdVO.setUpdUsrId(rebuildVO.getUpdUsrId());
								
								vskVslSkdVOList.add(vskVslSkdVO);
								isFirstPort = false;
							}else{
								isFirstPort = true;
							}
						}
						preVVD = vslCd + skdVoyNo + skdDirCd;
					} // end for
					
					swapCstGRPVO.setVskVslSkdVOList(vskVslSkdVOList);
					swapCstGRPVO.setVskVslPortSkdVOList(rebuildSkdList);
				}
				
			}else{
				
				List<VskVslSkdVO> vskVslSkdVOList = new ArrayList<VskVslSkdVO>();
				
				//:for blocking unexpected actual carrier code update
				//:2016-03-23:by TOP://
				vskVslSkdVOList.add(addActCrrCd(makeVskVslSkdDataSet(vskVslPortSkdVO)));
				
				swapCstGRPVO.setVskVslSkdVOList(vskVslSkdVOList);
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10038").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return swapCstGRPVO;
	}
	
	/**
	 * Managing Delayed SKD with Buffer Time
	 * 
	 * @param List<VskVslPortSkdVO> list
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @param int dlayTime
	 * @param String portSkdStsCd
	 * @param String usrId
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	private List<VskVslPortSkdVO> calcDelayAutoSkdUpdate(List<VskVslPortSkdVO> vskVslPortSkdVOs, VskVslPortSkdVO vskVslPortSkdVO, int dlayTime, String portSkdStsCd, String usrId) throws EventException {
		List<VskVslPortSkdVO> rstList = new ArrayList<VskVslPortSkdVO>();
		int portBufTime = 0;
		int seaBufTime = 0;
		try{
			String actAutoId = "ACT_AUTO_UPDATE";
			int cnt = vskVslPortSkdVOs.size();
			VskVslPortSkdVO firstVO = vskVslPortSkdVOs.get(0);
			
			// Handling Port Buffer.
			if("A".equals(portSkdStsCd)){
				firstVO.setVpsEtaDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtaDt(), dlayTime));
				firstVO.setVpsEtbDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtbDt(), dlayTime));
				portBufTime = getConvertMinByBufTime(firstVO.getPortBufHrs());
				if(isCompareBufTime(dlayTime, portBufTime)){
					dlayTime = dlayTime - portBufTime;
					firstVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime));
					portBufTime = 0;
					firstVO.setPortBufHrs(portBufTime+"");
				}else{
					portBufTime = portBufTime - dlayTime;
					firstVO.setPortBufHrs(getConvertHourByBufTime(portBufTime));
					dlayTime = 0;
				}
			}else if("B".equals(portSkdStsCd)){
				firstVO.setVpsEtbDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtbDt(), dlayTime));
				portBufTime = getConvertMinByBufTime(firstVO.getPortBufHrs());
				if(isCompareBufTime(dlayTime, portBufTime)){
					dlayTime = dlayTime - portBufTime;
					firstVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime));
					portBufTime = 0;
					firstVO.setPortBufHrs(portBufTime + "");
				}else{
					portBufTime = portBufTime - dlayTime;
					firstVO.setPortBufHrs(getConvertHourByBufTime(portBufTime));
					dlayTime = 0;
				}
			}else if("D".equals(portSkdStsCd)){
				firstVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), dlayTime));
			}
			
			if(dlayTime > 0){
				// Handling Sea Buffer - when next Schedule exist
				if(cnt > 1){
					seaBufTime = getConvertMinByBufTime(firstVO.getSeaBufHrs());
					if(isCompareBufTime(dlayTime, seaBufTime)){
						firstVO.setSeaBufHrs("0");
					}else{
						firstVO.setSeaBufHrs(getConvertHourByBufTime(seaBufTime - dlayTime));
					}
				}
			}

			firstVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
			firstVO.setSlanCd(vskVslPortSkdVO.getSlanCd());
			firstVO.setYdCd(vskVslPortSkdVO.getYdCd());
			firstVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
			firstVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
			firstVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
			firstVO.setUpdUsrId(usrId);
			rstList.add(firstVO);
			
			for(int i=1; i<cnt; i++){
				VskVslPortSkdVO portVO = vskVslPortSkdVOs.get(i);
				
				if(isCallAutoProcess(portVO)){
					if(dlayTime > 0){
						if(isCompareBufTime(dlayTime, seaBufTime)){
							dlayTime = dlayTime - seaBufTime;
							portVO.setVpsEtaDt(VSKGeneralUtil.addDelayTime(portVO.getVpsEtaDt(), dlayTime));
							portVO.setVpsEtbDt(VSKGeneralUtil.addDelayTime(portVO.getVpsEtbDt(), dlayTime));
							
							portBufTime = getConvertMinByBufTime(portVO.getPortBufHrs());
							if(isCompareBufTime(dlayTime, portBufTime)){
								dlayTime = dlayTime - portBufTime;
								portVO.setVpsEtdDt(VSKGeneralUtil.addDelayTime(portVO.getVpsEtdDt(), dlayTime));
								portVO.setPortBufHrs("0");
							}else{
								portBufTime = portBufTime - dlayTime;
								portVO.setPortBufHrs(getConvertHourByBufTime(portBufTime));
								dlayTime = 0;
							}
	
							if(dlayTime > 0){
								// Handling Sea Buffer - when next Schedule exist
								if(i < cnt-1){
									seaBufTime = getConvertMinByBufTime(portVO.getSeaBufHrs());
									if(isCompareBufTime(dlayTime, seaBufTime)){
										portVO.setSeaBufHrs("0");
									}else{
										portVO.setSeaBufHrs(getConvertHourByBufTime(seaBufTime - dlayTime));
									}
								}
							}
							
							portVO.setVpsEtaDt(VSKGeneralUtil.controlTime(portVO.getVpsEtaDt(), 30));
							portVO.setVpsEtbDt(VSKGeneralUtil.controlTime(portVO.getVpsEtbDt(), 30));
							portVO.setVpsEtdDt(VSKGeneralUtil.controlTime(portVO.getVpsEtdDt(), 30));
							
						}else{
							dlayTime = 0;
						}
					}else{
						break;
					}
					portVO.setUpdUsrId(actAutoId);
					rstList.add(portVO);
				}
			} // end for
		}catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return rstList;
	}
	
	/**
	 * in case Delayed SKD recovery
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @param int recvTime
	 * @param String portSkdStsCd
	 * @param String usrId
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	private List<VskVslPortSkdVO> calcRecoveryAutoSkdUpdate(List<VskVslPortSkdVO> vskVslPortSkdVOs, VskVslPortSkdVO vskVslPortSkdVO, int recvTime, String portSkdStsCd, String usrId) throws EventException {
		List<VskVslPortSkdVO> rstList = new ArrayList<VskVslPortSkdVO>();
		try{
			String actAutoId = "ACT_AUTO_UPDATE";
			int cnt = vskVslPortSkdVOs.size();
			VskVslPortSkdVO firstVO = vskVslPortSkdVOs.get(0);
			
			if("A".equals(portSkdStsCd)){
				String recvEtbDt = VSKGeneralUtil.addDelayTime(firstVO.getVpsEtbDt(), recvTime);
				String recvEtdDt = VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), recvTime);
				String pfEtbDt = VSKGeneralUtil.isNotNull(firstVO.getPfEtbDt())?firstVO.getPfEtbDt():firstVO.getInitEtbDt();
				String pfEtdDt = VSKGeneralUtil.isNotNull(firstVO.getPfEtdDt())?firstVO.getPfEtdDt():firstVO.getInitEtdDt();
				
				firstVO.setVpsEtaDt(vskVslPortSkdVO.getVpsEtaDt());
				firstVO.setVpsEtbDt(callRecoveryDate(recvEtbDt, pfEtbDt));
				firstVO.setVpsEtdDt(callRecoveryDate(recvEtdDt, pfEtdDt));
			}else if("B".equals(portSkdStsCd)){
				String recvEtdDt = VSKGeneralUtil.addDelayTime(firstVO.getVpsEtdDt(), recvTime);
				String pfEtdDt = VSKGeneralUtil.isNotNull(firstVO.getPfEtdDt())?firstVO.getPfEtdDt():firstVO.getInitEtdDt();
				
				firstVO.setVpsEtbDt(vskVslPortSkdVO.getVpsEtbDt());
				firstVO.setVpsEtdDt(callRecoveryDate(recvEtdDt, pfEtdDt));
			}else if("D".equals(portSkdStsCd)){
				firstVO.setVpsEtdDt(vskVslPortSkdVO.getVpsEtdDt());
			}
			

			firstVO.setSkdCngStsCd(vskVslPortSkdVO.getSkdCngStsCd());
			firstVO.setSlanCd(vskVslPortSkdVO.getSlanCd());
			firstVO.setYdCd(vskVslPortSkdVO.getYdCd());
			firstVO.setVslDlayRsnCd(vskVslPortSkdVO.getVslDlayRsnCd());
			firstVO.setVslDlayRsnDesc(vskVslPortSkdVO.getVslDlayRsnDesc());
			firstVO.setVslDlayRsnLocCd(vskVslPortSkdVO.getVslDlayRsnLocCd());
			firstVO.setUpdUsrId(usrId);
			rstList.add(firstVO);
			
			boolean isAdvanced = false;
			
			for(int i=1; i<cnt; i++){
				VskVslPortSkdVO portVO = vskVslPortSkdVOs.get(i);
				
				if(isCallAutoProcess(portVO)){
					String pfEtaDt = VSKGeneralUtil.isNotNull(portVO.getPfEtaDt())?portVO.getPfEtaDt():portVO.getInitEtaDt();
					String pfEtbDt = VSKGeneralUtil.isNotNull(portVO.getPfEtbDt())?portVO.getPfEtbDt():portVO.getInitEtbDt();
					String pfEtdDt = VSKGeneralUtil.isNotNull(portVO.getPfEtdDt())?portVO.getPfEtdDt():portVO.getInitEtdDt();
			
					portVO.setUpdUsrId(actAutoId);
					
					if(!isAdvanced && isDlaySkdDate(pfEtaDt, portVO.getVpsEtaDt()) < 0){
						
						// Applying Delayed data to VPS_ETA_DT
						String recvEtaDt = VSKGeneralUtil.addDelayTime(portVO.getVpsEtaDt(), recvTime);
						portVO.setVpsEtaDt(callRecoveryDate(recvEtaDt, pfEtaDt));

						
						if(isDlaySkdDate(pfEtbDt, portVO.getVpsEtbDt()) < 0){
							
							// Applying Delayed data to VPS_ETB_DT
							String recvEtbDt = VSKGeneralUtil.addDelayTime(portVO.getVpsEtbDt(), recvTime);
							portVO.setVpsEtbDt(callRecoveryDate(recvEtbDt, pfEtbDt));

							if(isDlaySkdDate(pfEtdDt, portVO.getVpsEtdDt()) < 0){
								
								// Applying Delayed data to VPS_ETD_DT
								String recvEtdDt = VSKGeneralUtil.addDelayTime(portVO.getVpsEtdDt(), recvTime);
								portVO.setVpsEtdDt(callRecoveryDate(recvEtdDt, pfEtdDt));
							}else{
								isAdvanced = true;
								
								// PF SKD < VPS SKD(Advance)
								portVO.setVpsEtdDt(pfEtdDt);
								rstList.add(portVO);
								continue;
								
							}
						}else{
							isAdvanced = true;
							
							// PF SKD < VPS SKD(Advance)
							portVO.setVpsEtbDt(pfEtbDt);
							portVO.setVpsEtdDt(pfEtdDt);
							rstList.add(portVO);
							continue;
							
							
						}
						
						portVO.setVpsEtaDt(VSKGeneralUtil.controlTime(portVO.getVpsEtaDt(), 30));
						portVO.setVpsEtbDt(VSKGeneralUtil.controlTime(portVO.getVpsEtbDt(), 30));
						portVO.setVpsEtdDt(VSKGeneralUtil.controlTime(portVO.getVpsEtdDt(), 30));
						
						rstList.add(portVO);
					}else{
						isAdvanced = true;
						
						// PF SKD < VPS SKD(Advance)
						portVO.setVpsEtaDt(pfEtaDt);
						portVO.setVpsEtbDt(pfEtbDt);
						portVO.setVpsEtdDt(pfEtdDt);
						rstList.add(portVO);
						continue;
						
					}
				}
			} // end for
		}catch (EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return rstList;
	}
	
	/**
	 * Returning later time in recovery time and p/f time
	 * 
	 * @param String recvDate
	 * @param String pfDate
	 * @return String
	 * @exception EventException
	 */
	private String callRecoveryDate(String recvDate, String pfDate) throws EventException{
		String rtnDate = "";
		if(diffSkdDate(recvDate, pfDate) >= 0){
			rtnDate = pfDate;
		}else{
			rtnDate = recvDate;
		}
		return rtnDate;
	}
	
	/**
	 * prohibiting auto update when auto update flag(from 0015) is "Y" or skip
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return boolean
	 */
	private boolean isCallAutoProcess(VskVslPortSkdVO vskVslPortSkdVO){
		boolean rstFlg = true;
		
		if("Y".equals(vskVslPortSkdVO.getAutoSkdCngFlg()) || "S".equals(vskVslPortSkdVO.getSkdCngStsCd())){
			rstFlg = false;
		}
		return rstFlg;
	}
	
	/**
	 * Checking Delay > Buffer
	 * 
	 * @param int dlayTime
	 * @param int bufTime
	 * @return boolean
	 */
	private boolean isCompareBufTime(int dlayTime, int bufTime){
		boolean flag = false;
		
		if(dlayTime > bufTime){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * Changing hour unit buffer time to minute unit
	 * 
	 * @param String bufTime
	 * @return int
	 */
	private int getConvertMinByBufTime(String bufTime){
		if(!VSKGeneralUtil.isNotNull(bufTime)){
			bufTime = "0";
		}
		int nBufTime = 0;
		
		nBufTime = (int)(Double.parseDouble(bufTime) * 60);
		
		return nBufTime;
	}
	
	/**
	 * Changing minute unit buffer time to hour unit
	 * 
	 * @param double dBufTime
	 * @return String
	 */
	private String getConvertHourByBufTime(double bufTime){
		double dBufTime = 0.0;
		
		dBufTime = bufTime / 6.0;
		dBufTime = Math.round(dBufTime) / 10.0;
		
		return dBufTime+"";
	}
	
	/**
	 * Checking whether two days delay or not
	 * 
	 * @param String date1
	 * @param String date2
	 * @return int
	 * @exception EventException
	 */
	private int isDlaySkdDate(String date1, String date2) throws EventException {
		String pattern = "yyyyMMddHHmm";
		return VSKGeneralUtil.compareSkdDate(date1, pattern, date2, pattern);
	}
	
	/**
	 * calculating difference of two days
	 * date2 - date1
	 * 
	 * @param String date1
	 * @param String date2
	 * @return String
	 * @exception EventException
	 */
	private long diffSkdDate(String date1, String date2) throws EventException {
		String pattern = "yyyyMMddHHmm";
		return VSKGeneralUtil.dateDiff(date1, pattern, date2, pattern, "m");
	}
	
	/**
	 * Retrieving target list for auto Update
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	private List<VskVslPortSkdVO> searchAutoSkdUpdate(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		List<VskVslPortSkdVO> list = null;
		try{
			list = dbDao.searchAutoSkdUpdate(vskVslPortSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Judging Actual exist from Auto Update target list, and Returning flag
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @return boolean
	 */
	private boolean isUsedActualSkd(List<VskVslPortSkdVO> vskVslPortSkdVOs) {
		boolean actFlag = true;
		if(vskVslPortSkdVOs != null && vskVslPortSkdVOs.size()>0){
			int voSize = vskVslPortSkdVOs.size();
			for(int i=1; i<voSize; i++){
				if("Y".equals(vskVslPortSkdVOs.get(i).getActInpFlg())){
					actFlag = false;
					break;
				}
			}
		}else{
			actFlag = false;
		}
		
		return actFlag;
	}
	
	/**
	 * Checking Booking status of VVD
	 * 
	 * @param SimulationVvdCheckVO simulationVvdCheckVO
	 * @return List<VvdBkgStsVO>
	 * @exception EventException
	 */
	public List<VvdBkgStsVO> checkBkgStsByVvd(SimulationVvdCheckVO simulationVvdCheckVO) throws EventException {
		try {
			
			List<VvdBkgStsVO> vvdBkgStsVOs = new ArrayList<VvdBkgStsVO>();
			VvdBkgStsVO vo 		= null;
			
			String vslCd     	= simulationVvdCheckVO.getVslCd			();
			String skdVoyNo  	= simulationVvdCheckVO.getSkdVoyNo		();
			String startDate 	= simulationVvdCheckVO.getStartDate		();
			String endDate   	= simulationVvdCheckVO.getEndDate		();
			String vslCnt    	= simulationVvdCheckVO.getVslCnt		();
			String voyNoType 	= simulationVvdCheckVO.getVoyNoType		();
			String voyTypeCnt 	= simulationVvdCheckVO.getVoyTypeCnt	();
			String skdDirCd1 	= simulationVvdCheckVO.getSkdDirCd1		();
			String skdDirCd2 	= simulationVvdCheckVO.getSkdDirCd2		();
			int idxVal       	= (simulationVvdCheckVO.getDuration		().indexOf(".") >= 0) ? simulationVvdCheckVO.getDuration().indexOf(".") : simulationVvdCheckVO.getDuration().length();
			String duration  	= simulationVvdCheckVO.getDuration		().substring(0, idxVal);
			
			//int iDuration 	= VSKGeneralUtil.getCheckNullToString(duration)==""?0:Integer.parseInt(duration);
			int iDuration 		= "".compareTo(VSKGeneralUtil.getCheckNullToString(duration))	==0 ? 0 : Integer.parseInt(duration);
			int iSkdVoyNo 		= Integer.parseInt(skdVoyNo);
			int iVoyTypeCnt 	= "".compareTo(VSKGeneralUtil.getCheckNullToString(voyTypeCnt))	==0 ? 1 : Integer.parseInt(voyTypeCnt);
			
			//int iVslCnt 		= VSKGeneralUtil.getCheckNullToString(vslCnt)==""?0:Integer.parseInt(vslCnt);
			int iVslCnt 		= "".compareTo(VSKGeneralUtil.getCheckNullToString(vslCnt))		==0 ? 0 : Integer.parseInt(vslCnt);
			
			
			if(iDuration!=0){
				
				endDate 			= VSKGeneralUtil.changeDateFormat(endDate, "yyyy-MM-dd", "yyyyMMdd");
				String doingDate 	= startDate;
				
				while(doingDate.compareTo(endDate)<=0){
					// 1st Direction VVD
					vo 				= new VvdBkgStsVO();
					vo.setVslCd		(vslCd);
					vo.setSkdVoyNo	(VSKGeneralUtil.getVoyNo(skdVoyNo));
					vo.setSkdDirCd	(skdDirCd1);
					
					if("1".equals(voyNoType)){
						iSkdVoyNo 	= iSkdVoyNo + 1;
						skdVoyNo 	= Integer.toString(iSkdVoyNo);
					}
					vvdBkgStsVOs.add(vo);
					
					// 2nd Direction VVD
					vo 				= new VvdBkgStsVO();
					vo.setVslCd		(vslCd);
					vo.setSkdVoyNo	(VSKGeneralUtil.getVoyNo(skdVoyNo));
					vo.setSkdDirCd	(skdDirCd2);
					
					doingDate 		= VSKGeneralUtil.getActionDate(doingDate, iDuration);
					if("0".equals(voyNoType)){
						iSkdVoyNo 	= iSkdVoyNo + iVoyTypeCnt;
						skdVoyNo 	= Integer.toString(iSkdVoyNo);
					}else if("1".equals(voyNoType)){
						iSkdVoyNo 	= iSkdVoyNo + iVoyTypeCnt;
						skdVoyNo 	= Integer.toString(iSkdVoyNo);
					}else if("2".equals(voyNoType)){
						iSkdVoyNo 	= iSkdVoyNo + (iVslCnt * iVoyTypeCnt);
						skdVoyNo 	= Integer.toString(iSkdVoyNo);
					}
					vvdBkgStsVOs.add(vo);
				}	
			}
			
			return dbDao.checkBkgStsByVvd(vvdBkgStsVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Costal Schedule Simulation
	 * 
	 * @param SwapCstSkdSimVO swapCstSkdSimVO
	 * @return List<SwapCstSkdSimVO>
	 * @exception EventException
	 */
	public List<SwapCstSkdSimVO> searchCstSkdSim(SwapCstSkdSimVO swapCstSkdSimVO) throws EventException {
		List<SwapCstSkdSimVO> list = null;
		try {
			String rtvFlg = swapCstSkdSimVO.getRtvFlg();
		
			if("N".equals(rtvFlg)){
				list = dbDao.searchCstSkdSrc(swapCstSkdSimVO);
			} else if ("Y".equals(rtvFlg)) {
				list = dbDao.searchCstSkdSim(swapCstSkdSimVO);
			} else {
				throw new EventException(new ErrorHandler("VSK10035").getMessage());
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return list;
	}
	
	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return VslPortSkdVO
	 * @exception EventException
	 */
	public VslPortSkdVO searchCstSkdByVvdPort(VslPortSkdVO vslPortSkdVO) throws EventException {
		try {
			return dbDao.searchCstSkdByVvdPort(vslPortSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Vessel Berth Information
	 * 
	 * @param CstSkdBerthWdoVO cstSkdBerthWdoVO
	 * @return List<CstSkdBerthWdoVO>
	 * @exception EventException
	 */
	public List<CstSkdBerthWdoVO> searchCstSkdBerthWdo(CstSkdBerthWdoVO cstSkdBerthWdoVO) throws EventException {
		try {
			return dbDao.searchCstSkdBerthWdo(cstSkdBerthWdoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Managing Coastal, ETA, ETB, ETD, Next ETA, etc.
	 * 
	 * @param CstSkdBerthWdoVO[] cstSkdBerthWdoVOs
	 * @param SignOnUserAccount account
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageCstSkdBerthWdo(CstSkdBerthWdoVO[] cstSkdBerthWdoVOs, SignOnUserAccount account) throws EventException {
		
		VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
		
		try {
			if(cstSkdBerthWdoVOs != null){
				List<CstSkdBerthWdoVO> cstSkdBerthWdoVOList = new ArrayList<CstSkdBerthWdoVO>();
				String userId = currentUserId(account, cstSkdBerthWdoVOs[0].getUpdUsrId());
				
				//================================================================================================================
				//[in case data change after retrieve START]
				int okCnt = 0;
				int failCnt = 0;
				List<String> failPortInfos = new ArrayList<String>();
				
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs){
					
					VskVslPortSkdVO originPortParamVO = new VskVslPortSkdVO();
					originPortParamVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
					originPortParamVO.setSkdVoyNo(cstSkdBerthWdoVO.getSkdVoyNo());
					originPortParamVO.setSkdDirCd(cstSkdBerthWdoVO.getSkdDirCd());
					List<VskVslPortSkdVO> originPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(originPortParamVO);
					
					if(originPortVoList != null && originPortVoList.size()>0){
						for(VskVslPortSkdVO vskVslPortSkdVO : originPortVoList){
							if(cstSkdBerthWdoVO.getVpsPortCd().equals(vskVslPortSkdVO.getVpsPortCd()) && cstSkdBerthWdoVO.getClptIndSeq().equals(vskVslPortSkdVO.getClptIndSeq())){
								if(!cstSkdBerthWdoVO.getUpdDt().equals(vskVslPortSkdVO.getUpdDt())){
									failCnt++;
									String portInfo = cstSkdBerthWdoVO.getVslCd() 
													+ cstSkdBerthWdoVO.getSkdVoyNo() 
													+ cstSkdBerthWdoVO.getSkdDirCd() + "/"
													+ cstSkdBerthWdoVO.getVpsPortCd() + "/"
													+ cstSkdBerthWdoVO.getClptIndSeq();
									failPortInfos.add(portInfo);
								}else{
									okCnt++;
									cstSkdBerthWdoVOList.add(cstSkdBerthWdoVO);
								}
							}
						}
					}
				}
				
				//[in case data change after retrieve END]
				//================================================================================================================
				
				// ***************** History START *****************
				List<VslSkdHisInVO> vslSkdHisInVOList 	= makeDataSetByCstSkdBerthWdoHis(cstSkdBerthWdoVOList, userId);
				vslSkdChgStsGRPVO 						= this.manageVslSkdChgSts(vslSkdHisInVOList);
				// ***************** History END *******************
				
				// ***************** Coastal SKD START *****************
				List<VskVslSkdVO> 	updateList 			= makeDataSetByCstSkdBerthWdo		(cstSkdBerthWdoVOList, userId);
				List<VslPortSkdVO> 	updatePortList 		= makeDataSetByCstPortSkdBerthWdo	(cstSkdBerthWdoVOList, userId);
				// ***************** Coastal SKD END *******************
				
				if(updateList != null && updateList.size()>0){
					dbDao.modifyVskVslSkd		(updateList);
					// :: VIPS START ::
					// System.out.println("VIPS[modifyVskVslSkd3]");
					for(VskVslSkdVO vo : updateList) {
						List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
						for(VskVslSkdVO row : list) {
							this.mVskVslSkdList.add(row);
						}
					}
					// :: VIPS END ::
				}
				
				if(updatePortList != null && updatePortList.size()>0){
					dbDao.modifyVskVslPortSkd	(updatePortList);
					// :: VIPS START ::
					// System.out.println("VIPS[modifyVskVslPortSkd4]");
					for(VslPortSkdVO vslPortSkdVO : updatePortList) {
						VskVslPortSkdVO vo = new VskVslPortSkdVO();
						vo.setVslCd(vslPortSkdVO.getVslCd());
						vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
						vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
						vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
						vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
						List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
						for(VskVslPortSkdVO row : list) {
							this.mVslPortSkdList.add(row);
						}
					}
					// :: VIPS END ::
				}
				
				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
				
				if(updatePortList != null && updatePortList.size() > 0){
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updatePortList>0 started!!! :: \n");
	
					//List<VslSkdCngHisVO> 	tmpVslSkdCngHisVOs 	= new ArrayList<VslSkdCngHisVO>();
					//tmpVslSkdCngHisVOs							= createVslSkdChangeHistory(updateList, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					
					String				sVslCd			= null;
					String				sSkdVoyNo		= null;
					String				sSkdDirCd		= null;
					int					iDupKnt			= 0;
					
					for(int k=0; k<updatePortList.size(); k++){
						
						VslPortSkdVO	tmpVO	= new VslPortSkdVO();
						tmpVO					= updatePortList.get(k);
						iDupKnt					= 0;

						sVslCd		= tmpVO.getVslCd	();
						sSkdVoyNo	= tmpVO.getSkdVoyNo	();
						sSkdDirCd	= tmpVO.getSkdDirCd	();
						
						if(k == 0){
							VskVslSkdVO	tmpVO2	= new VskVslSkdVO();
							
							tmpVO2.setVslCd		(sVslCd		);
							tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
							tmpVO2.setSkdDirCd	(sSkdDirCd	);
							
							vskVslSkdVOs.add	(tmpVO2);
						}else{
							
							for(VskVslSkdVO tmpVO3 : vskVslSkdVOs){
								if(sVslCd.equals(tmpVO3.getVslCd()) && sSkdVoyNo.equals(tmpVO3.getSkdVoyNo()) && sSkdDirCd.equals(tmpVO3.getSkdDirCd())){
									iDupKnt++;
								}
							}
							
							if(iDupKnt == 0){
								VskVslSkdVO	tmpVO2	= new VskVslSkdVO();
								
								tmpVO2.setVslCd		(sVslCd		);
								tmpVO2.setSkdVoyNo	(sSkdVoyNo	);
								tmpVO2.setSkdDirCd	(sSkdDirCd	);
								
								vskVslSkdVOs.add	(tmpVO2);
							}
						}
						
					}
					
					//this.createVslSkdChangeHistory(vskVslSkdVOs, null, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updatePortList>0 finished!!! :: \n");
					
				}else if(updateList != null && updateList.size() > 0){
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updateList>0 started!!! :: \n");
	
					//List<VslSkdCngHisVO> 	tmpVslSkdCngHisVOs 	= new ArrayList<VslSkdCngHisVO>();
					//tmpVslSkdCngHisVOs							= createVslSkdChangeHistory(updateList, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
					for(int i=0; i<updateList.size(); i++){
						VslSkdXtraHisVO	tmpVO				= new VslSkdXtraHisVO();
						VskVslSkdVO		tmpVskVslSkdVO		= updateList.get(i);
						
						tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
						tmpVO.setVskdCngTpCd	("U");							/** 'U':General Update, 'D':VVD Deletion**/
						tmpVO.setBfrVslSlanCd	(tmpVskVslSkdVO.getVslSlanCd	());
						tmpVO.setBfrVslCd		(tmpVskVslSkdVO.getVslCd		());
						tmpVO.setBfrSkdVoyNo	(tmpVskVslSkdVO.getSkdVoyNo		());
						tmpVO.setBfrSkdDirCd	(tmpVskVslSkdVO.getSkdDirCd		());
						
						tmpVO.setBfrPfSvcTpCd	(tmpVskVslSkdVO.getPfSkdTpCd	());
						
						tmpVO.setBkgAtchFlg		("");
						
//						tmpVO.setBfrVpsPortCd	(orgPortVO.getVpsPortCd	()			);
//						tmpVO.setBfrClptIndSeq	(orgPortVO.getClptIndSeq()			);
//						tmpVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtaDt()			);
//						tmpVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtbDt()			);
//						tmpVO.setBfrVpsEtaDt	(orgPortVO.getVpsEtdDt()			);
//						
//						tmpVO.setAftVpsEtaDt	(vslSkdHisInVO.getVpsEtaDt()		);
//						tmpVO.setAftVpsEtaDt	(vslSkdHisInVO.getVpsEtbDt()		);
//						tmpVO.setAftVpsEtaDt	(vslSkdHisInVO.getVpsEtdDt()		);	
						
						tmpVO.setUpdUsrId		(account.getUsr_id				());
						vslSkdXtraHisVOs.add	(tmpVO);				
					}

					//::by TOP:2015-05-24:://this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
					
					//log.info("\n\n ::jskjskjsk::[history+detail][UPDATE_CST_ByBrthWdo].updateList>0 finished!!! :: \n");
				}
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://
				
				
//				********************* Transmitting changed VVD to ERP *********************
				List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();		//(I,U,D)
				
				if(updatePortList != null && updatePortList.size() > 0){
					
					int voCnt = updatePortList.size();
					
					for(int i=0; i<voCnt; i++){
						
						VvdVO vvdVO = new VvdVO();
						vvdVO.setIbflag("U");
						vvdVO.setVslCd(updatePortList.get(i).getVslCd());
						vvdVO.setSkdVoyNo(updatePortList.get(i).getSkdVoyNo());
						vvdVO.setSkdDirCd(updatePortList.get(i).getSkdDirCd());
						vvdVO.setVslSlanCd(updatePortList.get(i).getSlanCd());
						
						boolean isErpFlg = true;
						if(erpVvdVOs != null && erpVvdVOs.size() > 0){
							for(int j=0; j<erpVvdVOs.size(); j++){
								VvdVO tmpVO = erpVvdVOs.get(j);
								if(tmpVO.getVslCd().equals(vvdVO.getVslCd())
										&& tmpVO.getSkdVoyNo().equals(vvdVO.getSkdVoyNo())
										&& tmpVO.getSkdDirCd().equals(vvdVO.getSkdDirCd())){
									isErpFlg = false;
									break;
								}
							}
						}

						if(isErpFlg){
							erpVvdVOs.add(vvdVO);
						}
					}
				}
				
				vslSkdChgStsGRPVO.setErpVvdVOs(erpVvdVOs);
				
				if(erpVvdVOs != null && erpVvdVOs.size() > 0){
					dbDao.modifyYardCallSeq(erpVvdVOs);
					
//					[Booking BDR LOG]============================================
					List<BkgVvdBdrLogVO> bkgVvdLogList = searchBkgBdrLog(erpVvdVOs);
					vslSkdChgStsGRPVO.setBkgVvdBdrLogVOs(bkgVvdLogList);
				}
				
				vslSkdChgStsGRPVO.setOkCnt			(VSKGeneralUtil.getCheckNullToZero(Integer.toString(okCnt)));
				vslSkdChgStsGRPVO.setFailCnt		(VSKGeneralUtil.getCheckNullToZero(Integer.toString(failCnt)));
				vslSkdChgStsGRPVO.setFailPortInfos	(failPortInfos);
			}
			
			
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://vslSkdChgStsGRPVO.setVskVslSkdVOs	(vskVslSkdVOs);
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * Making DataSet for History of Daily Berth Window
	 * 
	 * @param List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs
	 * @param String userId
	 * @return List<VslSkdHisInVO>
	 * @exception EventException
	 */
	private List<VslSkdHisInVO> makeDataSetByCstSkdBerthWdoHis(List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs, String userId) throws EventException{
		List<VslSkdHisInVO> vslSkdHisInVOList = new ArrayList<VslSkdHisInVO>();
		try{
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.size() > 0){
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs) {
					VslSkdHisInVO vslSkdHisInVO = new VslSkdHisInVO();
					
					vslSkdHisInVO.setIbflag(cstSkdBerthWdoVO.getIbflag());
					vslSkdHisInVO.setSkdCngStsCd(cstSkdBerthWdoVO.getSkdCngStsCd());
					vslSkdHisInVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
					vslSkdHisInVO.setSkdVoyNo(cstSkdBerthWdoVO.getSkdVoyNo());
					vslSkdHisInVO.setSkdDirCd(cstSkdBerthWdoVO.getSkdDirCd());
					vslSkdHisInVO.setVslSlanCd(cstSkdBerthWdoVO.getSlanCd());
					vslSkdHisInVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
					vslSkdHisInVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					vslSkdHisInVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
					vslSkdHisInVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
					vslSkdHisInVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
					vslSkdHisInVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
					vslSkdHisInVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
					vslSkdHisInVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
					vslSkdHisInVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
					vslSkdHisInVO.setUsrId(userId);
					vslSkdHisInVO.setNewClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					
					vslSkdHisInVOList.add(vslSkdHisInVO);
					
					//Virtual Port History Setting.
					if("Y".equals(cstSkdBerthWdoVO.getTurnPortFlg())){
						VslSkdHisInVO virtualVslSkdHisInVO = new VslSkdHisInVO();
						
						virtualVslSkdHisInVO.setIbflag("U");
						virtualVslSkdHisInVO.setSkdCngStsCd(cstSkdBerthWdoVO.getSkdCngStsCd());
						virtualVslSkdHisInVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
						virtualVslSkdHisInVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						virtualVslSkdHisInVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						virtualVslSkdHisInVO.setVslSlanCd(cstSkdBerthWdoVO.getSlanCd());
						virtualVslSkdHisInVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
						virtualVslSkdHisInVO.setClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						virtualVslSkdHisInVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
						virtualVslSkdHisInVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
						virtualVslSkdHisInVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
						virtualVslSkdHisInVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
						virtualVslSkdHisInVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
						virtualVslSkdHisInVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
						virtualVslSkdHisInVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
						virtualVslSkdHisInVO.setUsrId(userId);
						virtualVslSkdHisInVO.setNewClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						
						vslSkdHisInVOList.add(virtualVslSkdHisInVO);
					}
					
					//Next Port History Setting.
					if(VSKGeneralUtil.isVirtualPort(cstSkdBerthWdoVO.getTurnPortIndCd())){
						VslSkdHisInVO nxtVslSkdHisInVO = new VslSkdHisInVO();
						
						nxtVslSkdHisInVO.setIbflag("U");
						nxtVslSkdHisInVO.setSkdCngStsCd(cstSkdBerthWdoVO.getSkdCngStsCd());
						nxtVslSkdHisInVO.setVslCd(cstSkdBerthWdoVO.getVslCd());
						nxtVslSkdHisInVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						nxtVslSkdHisInVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						nxtVslSkdHisInVO.setVslSlanCd(cstSkdBerthWdoVO.getSlanCd());
						nxtVslSkdHisInVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
						nxtVslSkdHisInVO.setClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						nxtVslSkdHisInVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
						nxtVslSkdHisInVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
						nxtVslSkdHisInVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
						nxtVslSkdHisInVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
						nxtVslSkdHisInVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
						nxtVslSkdHisInVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
						nxtVslSkdHisInVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
						nxtVslSkdHisInVO.setUsrId(userId);
						nxtVslSkdHisInVO.setNewClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						
						vslSkdHisInVOList.add(nxtVslSkdHisInVO);
					}
				} // end for
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return vslSkdHisInVOList;
	}
	
	/**
	 * Making Coastal Schedule DataSet for Daily Berth Window
	 * 
	 * @param List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VskVslSkdVO> makeDataSetByCstSkdBerthWdo(List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs, String userId) throws EventException{
		List<VskVslSkdVO> vskVslSkdVOList = new ArrayList<VskVslSkdVO>();
		try{
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.size() > 0){
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs){
					VskVslPortSkdVO chkParamVO = new VskVslPortSkdVO();
					
					String vslCd = cstSkdBerthWdoVO.getVslCd();
					String skdVoyNo = cstSkdBerthWdoVO.getSkdVoyNo();
					String skdDirCd = cstSkdBerthWdoVO.getSkdDirCd();
					
					chkParamVO.setVslCd(vslCd);
					chkParamVO.setSkdVoyNo(skdVoyNo);
					chkParamVO.setSkdDirCd(skdDirCd);
					chkParamVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
					chkParamVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					
					if("Y".equals(dbDao.checkFirstCallingPort(chkParamVO))){
						VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
						
						vskVslSkdVO.setVslCd(vslCd);
						vskVslSkdVO.setSkdVoyNo(skdVoyNo);
						vskVslSkdVO.setSkdDirCd(skdDirCd);
						vskVslSkdVO.setN1stPortBrthDt(cstSkdBerthWdoVO.getVpsEtbDt());
						vskVslSkdVO.setUpdUsrId(userId);
						
						vskVslSkdVOList.add(vskVslSkdVO);
					}
				}//end for
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return vskVslSkdVOList;
	}
	
	/**
	 * Making Coastal Schedule DataSet for Daily Berth Window
	 * 
	 * @param List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs
	 * @param String userId
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	private List<VslPortSkdVO> makeDataSetByCstPortSkdBerthWdo(List<CstSkdBerthWdoVO> cstSkdBerthWdoVOs, String userId) throws EventException{
		List<VslPortSkdVO> vslPortSkdVOList = new ArrayList<VslPortSkdVO>();
		
		try{
			if(cstSkdBerthWdoVOs != null && cstSkdBerthWdoVOs.size() > 0){
				for(CstSkdBerthWdoVO cstSkdBerthWdoVO : cstSkdBerthWdoVOs){
					String vslCd = cstSkdBerthWdoVO.getVslCd();
					String skdVoyNo = cstSkdBerthWdoVO.getSkdVoyNo();
					String skdDirCd = cstSkdBerthWdoVO.getSkdDirCd();
					
					VslPortSkdVO vslPortSkdVO = new VslPortSkdVO();
					vslPortSkdVO.setVslCd(vslCd);
					vslPortSkdVO.setSkdVoyNo(skdVoyNo);
					vslPortSkdVO.setSkdDirCd(skdDirCd);
					vslPortSkdVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
					vslPortSkdVO.setClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					vslPortSkdVO.setNewClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
					vslPortSkdVO.setClptSeq(cstSkdBerthWdoVO.getClptSeq());
					vslPortSkdVO.setUpdUsrId(userId);
					vslPortSkdVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
					vslPortSkdVO.setCallYdIndSeq(cstSkdBerthWdoVO.getCallYdIndSeq());
					vslPortSkdVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
					vslPortSkdVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
					vslPortSkdVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
					vslPortSkdVO.setSkdBrthNo(cstSkdBerthWdoVO.getSkdBrthNo());
					vslPortSkdVO.setIbCgoQty(cstSkdBerthWdoVO.getIbCgoQty());
					vslPortSkdVO.setObCgoQty(cstSkdBerthWdoVO.getObCgoQty());
					vslPortSkdVO.setFtDt(cstSkdBerthWdoVO.getFreeTmDt());
					vslPortSkdVO.setTmlVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVslCd(), " "));
					vslPortSkdVO.setTmlVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVoyNo(), " "));
					vslPortSkdVO.setTurnSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
					vslPortSkdVO.setTurnSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
					vslPortSkdVO.setTurnClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
					vslPortSkdVO.setVslDlayRsnCd(cstSkdBerthWdoVO.getVslDlayRsnCd());
					vslPortSkdVO.setVslDlayRsnDesc(cstSkdBerthWdoVO.getVslDlayRsnDesc());
					vslPortSkdVO.setVslDlayRsnLocCd(cstSkdBerthWdoVO.getVslDlayRsnLocCd());
					vslPortSkdVO.setSlanCd(cstSkdBerthWdoVO.getSlanCd());
					vslPortSkdVO.setVpsRmk(cstSkdBerthWdoVO.getVpsRmk());
					vslPortSkdVO.setPlismYdCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismYdCd(), " "));
					vslPortSkdVO.setPlismVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVslCd(), " "));
					vslPortSkdVO.setPlismVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVoyNo(), " "));
					
					vslPortSkdVOList.add(vslPortSkdVO);
					
		//			================= [ VIRTUAL PORT ] START ==============================================
					if("Y".equals(cstSkdBerthWdoVO.getTurnPortFlg())){
						//Retrieving Turnnig
						VskVslPortSkdVO virtualPortParamVO = new VskVslPortSkdVO();
						virtualPortParamVO.setVslCd(vslCd);
						virtualPortParamVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						virtualPortParamVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						List<VskVslPortSkdVO> virtualPortVoList = dbDao.searchVskVslPortSkdByVirtualPort(virtualPortParamVO);
						
						String virtualSlanCd = cstSkdBerthWdoVO.getSlanCd();
						if(virtualPortVoList != null && virtualPortVoList.size() > 0){
							virtualSlanCd = virtualPortVoList.get(0).getSlanCd();
						}
						
						VslPortSkdVO virtualPortSkdVO = new VslPortSkdVO();
						virtualPortSkdVO.setVslCd(vslCd);
						virtualPortSkdVO.setSkdVoyNo(cstSkdBerthWdoVO.getTurnSkdVoyNo());
						virtualPortSkdVO.setSkdDirCd(cstSkdBerthWdoVO.getTurnSkdDirCd());
						virtualPortSkdVO.setVpsPortCd(cstSkdBerthWdoVO.getVpsPortCd());
						virtualPortSkdVO.setClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						virtualPortSkdVO.setNewClptIndSeq(cstSkdBerthWdoVO.getTurnClptIndSeq());
						virtualPortSkdVO.setUpdUsrId(userId);
						virtualPortSkdVO.setYdCd(cstSkdBerthWdoVO.getYdCd());
						virtualPortSkdVO.setCallYdIndSeq("1");
						virtualPortSkdVO.setVpsEtaDt(cstSkdBerthWdoVO.getVpsEtaDt());
						virtualPortSkdVO.setVpsEtbDt(cstSkdBerthWdoVO.getVpsEtbDt());
						virtualPortSkdVO.setVpsEtdDt(cstSkdBerthWdoVO.getVpsEtdDt());
						virtualPortSkdVO.setSkdBrthNo(cstSkdBerthWdoVO.getSkdBrthNo());
						virtualPortSkdVO.setIbCgoQty(cstSkdBerthWdoVO.getIbCgoQty());
						virtualPortSkdVO.setObCgoQty(cstSkdBerthWdoVO.getObCgoQty());
						virtualPortSkdVO.setFtDt(cstSkdBerthWdoVO.getFreeTmDt());
						virtualPortSkdVO.setTmlVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVslCd(), " "));
						virtualPortSkdVO.setTmlVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getTmlVoyNo(), " "));
						virtualPortSkdVO.setTurnSkdVoyNo(skdVoyNo);
						virtualPortSkdVO.setTurnSkdDirCd(skdDirCd);
						virtualPortSkdVO.setTurnClptIndSeq(cstSkdBerthWdoVO.getClptIndSeq());
						virtualPortSkdVO.setSlanCd(virtualSlanCd);
						virtualPortSkdVO.setVpsRmk(cstSkdBerthWdoVO.getVpsRmk());
						virtualPortSkdVO.setPlismYdCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismYdCd(), " "));
						virtualPortSkdVO.setPlismVslCd(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVslCd(), " "));
						virtualPortSkdVO.setPlismVoyNo(VSKGeneralUtil.nvl(cstSkdBerthWdoVO.getPlismVoyNo(), " "));
						
						vslPortSkdVOList.add(virtualPortSkdVO);
					}
//					================= [ VIRTUAL PORT ] END ==============================================
				}//end for
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return vslPortSkdVOList;
	}
	
	/**
	 * Handling Coastal SKD Simulation(Recovery Plan)
	 * 
	 * @param SwapCstSkdSimVO[] swapCstSkdSimVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCstSkdSim(SwapCstSkdSimVO[] swapCstSkdSimVOs, SignOnUserAccount account) throws EventException {
		String simCode = "";
		try {
			if(swapCstSkdSimVOs != null){
				List<VskSwapCstSimVO> saveVskSwapCstSimVOList = new ArrayList<VskSwapCstSimVO>();
				List<VskSwapCstVvdVO> saveVskSwapCstVvdVOList = new ArrayList<VskSwapCstVvdVO>();
				List<VskSwapCstPortVO> saveVskSwapCstPortVOList = new ArrayList<VskSwapCstPortVO>();
				
				VskSwapCstSimVO vskSwapCstSimVO = new VskSwapCstSimVO();
				
				if(swapCstSkdSimVOs != null && swapCstSkdSimVOs.length > 0){
					
					String simDt = "";
					String simNo = "";
					
					if("I".equals(swapCstSkdSimVOs[0].getIbflag())){
						vskSwapCstSimVO = dbDao.searchSimNo();
						
						simDt = vskSwapCstSimVO.getSimDt();
						simNo = vskSwapCstSimVO.getSimNo();
						
						simCode = simDt + ":" + simNo;
					}else{
						simDt = VSKGeneralUtil.replaceDateTypeToString(swapCstSkdSimVOs[0].getSimDt());
						simNo = swapCstSkdSimVOs[0].getSimNo();
						
						vskSwapCstSimVO.setSimDt(simDt);
						vskSwapCstSimVO.setSimNo(simNo);
					}
					
					/* ====================================================== */
					vskSwapCstSimVO.setVslSimTpCd(swapCstSkdSimVOs[0].getVslSimTpCd());
					vskSwapCstSimVO.setDiffRmk(swapCstSkdSimVOs[0].getDiffRmk());
					vskSwapCstSimVO.setCreDt(account.getCre_dt());
					vskSwapCstSimVO.setCreUsrId(account.getUsr_id());
					vskSwapCstSimVO.setUpdUsrId(account.getUsr_id());
					
					saveVskSwapCstSimVOList.add(vskSwapCstSimVO);
					/* ====================================================== */
					
					int voCnt = swapCstSkdSimVOs.length;
					String vvdCd = "";
					String newVvdCd = "";
					String ydCd = "";
					
					for(int i=0; i<voCnt; i++){
						vvdCd = swapCstSkdSimVOs[i].getVslCd()
								+ swapCstSkdSimVOs[i].getSkdVoyNo()
								+ swapCstSkdSimVOs[i].getSkdDirCd();
						/* ====================================================== */
						if(!vvdCd.equals(newVvdCd)){
							VskSwapCstVvdVO vskSwapCstVvdVO = new VskSwapCstVvdVO();
							
							vskSwapCstVvdVO.setSimDt(simDt);
							vskSwapCstVvdVO.setSimNo(simNo);
							vskSwapCstVvdVO.setVslCd(swapCstSkdSimVOs[i].getVslCd());
							vskSwapCstVvdVO.setSkdVoyNo(swapCstSkdSimVOs[i].getSkdVoyNo());
							vskSwapCstVvdVO.setSkdDirCd(swapCstSkdSimVOs[i].getSkdDirCd());
							vskSwapCstVvdVO.setSlanCd(swapCstSkdSimVOs[i].getVslSlanCd());
							vskSwapCstVvdVO.setSkdStsCd(swapCstSkdSimVOs[i].getPortSkdStsCd());
							vskSwapCstVvdVO.setSkdVoyTpCd(swapCstSkdSimVOs[i].getSkdVoyTpCd());
							vskSwapCstVvdVO.setSkdUsdIndCd(swapCstSkdSimVOs[i].getSkdUsdIndCd());
							vskSwapCstVvdVO.setPfSkdTpCd(swapCstSkdSimVOs[i].getPfSkdTpCd());
							vskSwapCstVvdVO.setStPortCd(swapCstSkdSimVOs[i].getVpsPortCd());
							vskSwapCstVvdVO.setN1stPortBrthDt(swapCstSkdSimVOs[i].getVpsEtbDt());
							vskSwapCstVvdVO.setPsdoVvdCd(swapCstSkdSimVOs[i].getPsdoVvdCd());
							vskSwapCstVvdVO.setCoCd(swapCstSkdSimVOs[i].getCoCd());
							vskSwapCstVvdVO.setSkdRmk(swapCstSkdSimVOs[i].getSkdRmk());
							vskSwapCstVvdVO.setDiffRmk(swapCstSkdSimVOs[i].getDiffRmk());
							vskSwapCstVvdVO.setCreDt(swapCstSkdSimVOs[i].getCreDt());
							vskSwapCstVvdVO.setCreUsrId(account.getUsr_id());
							vskSwapCstVvdVO.setUpdUsrId(account.getUsr_id());
							
							saveVskSwapCstVvdVOList.add(vskSwapCstVvdVO);
							
							newVvdCd = vvdCd;
						}
						/* ====================================================== */
						ydCd = swapCstSkdSimVOs[i].getVpsPortCd() + swapCstSkdSimVOs[i].getTmlCd();
						if(!"D".equals(swapCstSkdSimVOs[i].getIbflag())){
							VskSwapCstPortVO vskSwapCstPortVO = new VskSwapCstPortVO();
							
							vskSwapCstPortVO.setSimDt(simDt);
							vskSwapCstPortVO.setSimNo(simNo);
							vskSwapCstPortVO.setVslCd(swapCstSkdSimVOs[i].getVslCd());
							vskSwapCstPortVO.setSkdVoyNo(swapCstSkdSimVOs[i].getSkdVoyNo());
							vskSwapCstPortVO.setSkdDirCd(swapCstSkdSimVOs[i].getSkdDirCd());
							vskSwapCstPortVO.setVpsPortCd(swapCstSkdSimVOs[i].getVpsPortCd());
							vskSwapCstPortVO.setClptIndSeq(swapCstSkdSimVOs[i].getNewClptIndSeq());
							vskSwapCstPortVO.setClptSeq(swapCstSkdSimVOs[i].getClptSeq());
							vskSwapCstPortVO.setSlanCd(swapCstSkdSimVOs[i].getVslSlanCd());
							vskSwapCstPortVO.setPortSkdStsCd(swapCstSkdSimVOs[i].getPortSkdStsCd());
							vskSwapCstPortVO.setYdCd(ydCd);
							vskSwapCstPortVO.setCallYdIndSeq(swapCstSkdSimVOs[i].getCallYdIndSeq());
							vskSwapCstPortVO.setPfEtaDt(swapCstSkdSimVOs[i].getPfEtaDt());
							vskSwapCstPortVO.setPfEtbDt(swapCstSkdSimVOs[i].getPfEtbDt());
							vskSwapCstPortVO.setPfEtdDt(swapCstSkdSimVOs[i].getPfEtdDt());
							vskSwapCstPortVO.setInitEtaDt(swapCstSkdSimVOs[i].getInitEtaDt());
							vskSwapCstPortVO.setInitEtbDt(swapCstSkdSimVOs[i].getInitEtbDt());
							vskSwapCstPortVO.setInitEtdDt(swapCstSkdSimVOs[i].getInitEtdDt());
							vskSwapCstPortVO.setVpsEtaDt(swapCstSkdSimVOs[i].getVpsEtaDt());
							vskSwapCstPortVO.setVpsEtbDt(swapCstSkdSimVOs[i].getVpsEtbDt());
							vskSwapCstPortVO.setVpsEtdDt(swapCstSkdSimVOs[i].getVpsEtdDt());
							vskSwapCstPortVO.setVslDlayRsnCd(swapCstSkdSimVOs[i].getVslDlayRsnCd());
							vskSwapCstPortVO.setVslDlayRsnDesc(swapCstSkdSimVOs[i].getVslDlayRsnDesc());
							vskSwapCstPortVO.setVpsLocCd(swapCstSkdSimVOs[i].getVslDlayRsnLocCd());
							vskSwapCstPortVO.setShpCallNo(swapCstSkdSimVOs[i].getShpCallNo());
							vskSwapCstPortVO.setShpCallNoUpdUsrId(swapCstSkdSimVOs[i].getShpCallNoUpdUsrId());
							vskSwapCstPortVO.setShpCallNoUpdDt(swapCstSkdSimVOs[i].getShpCallNoUpdDt());
							vskSwapCstPortVO.setTmlVslCd(swapCstSkdSimVOs[i].getTmlVslCd());
							vskSwapCstPortVO.setTmlVoyNo(swapCstSkdSimVOs[i].getTmlVoyNo());
							vskSwapCstPortVO.setFtDt(swapCstSkdSimVOs[i].getFtDt());
							vskSwapCstPortVO.setPlismYdCd(swapCstSkdSimVOs[i].getPlismYdCd());
							vskSwapCstPortVO.setPlismVslCd(swapCstSkdSimVOs[i].getPlismVslCd());
							vskSwapCstPortVO.setPlismVoyNo(swapCstSkdSimVOs[i].getPlismVoyNo());
							vskSwapCstPortVO.setSkdCngStsCd(swapCstSkdSimVOs[i].getSkdCngStsCd());
							vskSwapCstPortVO.setTurnPortFlg(swapCstSkdSimVOs[i].getTurnPortFlg());
							vskSwapCstPortVO.setTurnPortIndCd(swapCstSkdSimVOs[i].getTurnPortIndCd());
							vskSwapCstPortVO.setTurnSkdVoyNo(swapCstSkdSimVOs[i].getTurnSkdVoyNo());
							vskSwapCstPortVO.setTurnSkdDirCd(swapCstSkdSimVOs[i].getTurnSkdDirCd());
							vskSwapCstPortVO.setTurnClptIndSeq(swapCstSkdSimVOs[i].getTurnClptIndSeq());
							vskSwapCstPortVO.setIbCgoQty(swapCstSkdSimVOs[i].getIbCgoQty());
							vskSwapCstPortVO.setObCgoQty(swapCstSkdSimVOs[i].getObCgoQty());
							vskSwapCstPortVO.setVpsRmk(swapCstSkdSimVOs[i].getVpsRmk());
							vskSwapCstPortVO.setPhsIoRsnCd(swapCstSkdSimVOs[i].getPhsIoRsnCd());
							vskSwapCstPortVO.setPhsIoRmk(swapCstSkdSimVOs[i].getPhsIoRmk());
							vskSwapCstPortVO.setSkdBrthNo(swapCstSkdSimVOs[i].getSkdBrthNo());
							vskSwapCstPortVO.setInitSkdInpFlg(swapCstSkdSimVOs[i].getInitSkdInpFlg());
							vskSwapCstPortVO.setOfcInpFlg(swapCstSkdSimVOs[i].getOfcInpFlg());
							vskSwapCstPortVO.setNoonRptInpFlg(swapCstSkdSimVOs[i].getNoonRptInpFlg());
							vskSwapCstPortVO.setDepRptInpFlg(swapCstSkdSimVOs[i].getDepRptInpFlg());
							vskSwapCstPortVO.setActInpFlg(swapCstSkdSimVOs[i].getActInpFlg());
							vskSwapCstPortVO.setPrtChkFlg(swapCstSkdSimVOs[i].getPrtChkFlg());
							vskSwapCstPortVO.setLnkDist(swapCstSkdSimVOs[i].getLnkDist());
							vskSwapCstPortVO.setLnkSpd(swapCstSkdSimVOs[i].getLnkSpd());
							vskSwapCstPortVO.setTztmHrs(swapCstSkdSimVOs[i].getTztmHrs());
							vskSwapCstPortVO.setTdHrs(swapCstSkdSimVOs[i].getTimeDiff());
							vskSwapCstPortVO.setMnvrInHrs(swapCstSkdSimVOs[i].getMnvrInHrs());
							vskSwapCstPortVO.setMnvrOutHrs(swapCstSkdSimVOs[i].getMnvrOutHrs());
							vskSwapCstPortVO.setTmlProdQty(swapCstSkdSimVOs[i].getTmlProdQty());
							vskSwapCstPortVO.setCrnKnt(swapCstSkdSimVOs[i].getCrnKnt());
							vskSwapCstPortVO.setPortWrkHrs(swapCstSkdSimVOs[i].getActWrkHrs());
							vskSwapCstPortVO.setSeaBufHrs(swapCstSkdSimVOs[i].getSeaBufHrs());
							vskSwapCstPortVO.setPortBufHrs(swapCstSkdSimVOs[i].getPortBufHrs());
							vskSwapCstPortVO.setAddBnkCsmQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getAddBnkCsmQty()));
							vskSwapCstPortVO.setAddBnkCostAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getAddBnkCostAmt()));
							vskSwapCstPortVO.setTs20ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs20ftTtlQty()));	/* �붾㈃�먯꽌 �쒓굅���ъ슜�덊븿) */
							vskSwapCstPortVO.setTs40ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs40ftTtlQty()));	/* �붾㈃�먯꽌 �쒓굅���ъ슜�덊븿) */
							vskSwapCstPortVO.setTs20ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs20ftTtlAmt()));	/* �붾㈃�먯꽌 �쒓굅���ъ슜�덊븿) */
							vskSwapCstPortVO.setTs40ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTs40ftTtlAmt()));	/* �붾㈃�먯꽌 �쒓굅���ъ슜�덊븿) */
							vskSwapCstPortVO.setTmlHndl20ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl20ftTtlQty()));
							vskSwapCstPortVO.setTmlHndl40ftTtlQty(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl40ftTtlQty()));
							vskSwapCstPortVO.setTmlHndl20ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl20ftTtlAmt()));
							vskSwapCstPortVO.setTmlHndl40ftTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTmlHndl40ftTtlAmt()));
							vskSwapCstPortVO.setPeUsdTtlAmt(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getPeUsdTtlAmt()));
							vskSwapCstPortVO.setUsrHdnFlg(swapCstSkdSimVOs[i].getUsrHdnFlg());
							vskSwapCstPortVO.setCreDt(swapCstSkdSimVOs[i].getCreDt());
							vskSwapCstPortVO.setCreUsrId(account.getUsr_id());
							vskSwapCstPortVO.setUpdDt(swapCstSkdSimVOs[i].getUpdDt());
							vskSwapCstPortVO.setUpdUsrId(account.getUsr_id());
							// Skip Info...
							vskSwapCstPortVO.setTtlDlayHrs(VSKGeneralUtil.getCheckNullToZero(swapCstSkdSimVOs[i].getTtlDlayHrs()));
							vskSwapCstPortVO.setPortSkpRsnOffrRmk(swapCstSkdSimVOs[i].getPortSkpRsnOffrRmk());
							vskSwapCstPortVO.setPortSkpTpCd(swapCstSkdSimVOs[i].getPortSkpTpCd());
							vskSwapCstPortVO.setPortSkpRsnCd(swapCstSkdSimVOs[i].getPortSkpRsnCd());
							vskSwapCstPortVO.setTsPortCd(swapCstSkdSimVOs[i].getTsPortCd());
							vskSwapCstPortVO.setUsdFlg(VSKGeneralUtil.getCheckNotToString(swapCstSkdSimVOs[i].getUsdFlg()));
							vskSwapCstPortVO.setAutoSkdCngFlg(swapCstSkdSimVOs[i].getAutoSkdCngFlg());
							
							saveVskSwapCstPortVOList.add(vskSwapCstPortVO);
						}
					}// end for
					
					//in case ibflag == "U", Deleting DATA and Saving newly
					if("U".equals(swapCstSkdSimVOs[0].getIbflag())){
						dbDao.removeVskSwapCstPort(saveVskSwapCstPortVOList.get(0));
						dbDao.removeVskSwapCstVvd(saveVskSwapCstVvdVOList.get(0));
						
						dbDao.modifyVskSwapCstSim(saveVskSwapCstSimVOList.get(0));
					}else{
						if(saveVskSwapCstSimVOList.size() > 0){
							dbDao.addVskSwapCstSim(saveVskSwapCstSimVOList);
						}
					}
					
					if(saveVskSwapCstVvdVOList.size() > 0){
						dbDao.addVskSwapCstVvd(saveVskSwapCstVvdVOList);
					}
					if(saveVskSwapCstPortVOList.size() > 0){
						dbDao.addVskSwapCstPort(saveVskSwapCstPortVOList);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return simCode;
	}
	
	/**
	 * Retrieving Container cargo weight and etc cost of Skip Call Port. And Retrieving distance info
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchSkipCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		CstSkdSimDtlCalcInfoVO returnVO = new CstSkdSimDtlCalcInfoVO();
		try {
			String ttlChgAmt = (dbDao.searchPortExpenceByVessel(cstSkdSimDtlCalcInfoVO)).getTtlChgAmt();
			String stndDist = dbDao.searchVskPortDist(cstSkdSimDtlCalcInfoVO.getFmLocCd(), cstSkdSimDtlCalcInfoVO.getToLocCd());
			CstSkdSimDtlCalcInfoVO tmnlReHdlCostVO = dbDao.searchTmnlReHdlCost(cstSkdSimDtlCalcInfoVO);
			CstSkdSimDtlCalcInfoVO cargoVolByBayPlanVO = dbDao.searchCargoVolByBayPlan(cstSkdSimDtlCalcInfoVO);
			CstSkdSimDtlCalcInfoVO cargoVolByTDRVO = dbDao.searchCargoVolByTDR(cstSkdSimDtlCalcInfoVO);
			
			returnVO.setTtlChgAmt(ttlChgAmt);
			returnVO.setStndDist(stndDist);
			if(tmnlReHdlCostVO != null){
				returnVO.setTmD2(tmnlReHdlCostVO.getTmD2());
				returnVO.setTmD4(tmnlReHdlCostVO.getTmD4());
			}
			if(cargoVolByBayPlanVO != null){
				returnVO.setTp20Qty(cargoVolByBayPlanVO.getTp20Qty());
				returnVO.setTp40Qty(cargoVolByBayPlanVO.getTp40Qty());
			}else{
				if(cargoVolByTDRVO != null){
					returnVO.setTp20Qty(cargoVolByTDRVO.getTp20Qty());
					returnVO.setTp40Qty(cargoVolByTDRVO.getTp40Qty());
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		
		return returnVO;
	}
	
	/**
	 * Retrieving Container cargo weight and etc cost of Skip Call Port. And Retrieving distance info
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchAddCallInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		
		try {
		
			//stSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO = new CstSkdSimDtlCalcInfoVO();
			
			//LNK_DIST, Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY
			return dbDao.searchVskPortMnvrTimeZone(cstSkdSimDtlCalcInfoVO);
			
			//SPD
			//by top//swapCstSkdSimVO.setLnkSpd	(dbDao.searchMdmVslCntr(cstSkdSimDtlCalcInfoVO.getVslCd()).getVslSvcSpd());
			
			//TimeZone(Time Diff)
			//by top//swapCstSkdSimVO.setTimeDiff(dbDao.searchTimeZone(cstSkdSimDtlCalcInfoVO.getLocCd()).getTimeDiff());
			
			//Port Charge
			//by top//String ttlChgAmt 	= (dbDao.searchPortExpenceByVessel(cstSkdSimDtlCalcInfoVO)).getTtlChgAmt();
			
			
			//by top//returnVO.setPortDist	(swapCstSkdSimVO.getPortDist	());
			//by top//returnVO.setSpd			(swapCstSkdSimVO.getLnkSpd		());
			//by top//returnVO.setTimeDiff	(swapCstSkdSimVO.getTimeDiff	());
			//by top//returnVO.setMnvrInHrs	(swapCstSkdSimVO.getMnvrInHrs	());
			//by top//returnVO.setMnvrOutHrs	(swapCstSkdSimVO.getMnvrOutHrs	());
			//by top//returnVO.setCrnKnt		(swapCstSkdSimVO.getCrnKnt		());
			//by top//returnVO.setTmlProdQty	(swapCstSkdSimVO.getTmlProdQty	());
			//by top//returnVO.setPortBufHrs	(swapCstSkdSimVO.getPortBufHrs	());
			//by top//returnVO.setTtlChgAmt	(ttlChgAmt);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Port Charge
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPortExpenceByVessel(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		String ttlChgAmt = "";
		try {
			ttlChgAmt = (dbDao.searchPortExpenceByVessel(cstSkdSimDtlCalcInfoVO)).getTtlChgAmt();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return ttlChgAmt;
	}
	
	/**
	 * Retrieving distance of port to port
	 * 
	 * @param List<VskPortDistVO> vskPortDistVOs
	 * @return List<VskPortDistVO>
	 * @exception EventException
	 */
	public List<VskPortDistVO> searchVskPortDist(List<VskPortDistVO> vskPortDistVOs) throws EventException {
		List<VskPortDistVO> list = new ArrayList<VskPortDistVO>();
		
		try {
			String fmLocCd = "";
			String toLocCd = "";
			String stndDist = "";
			
			if(vskPortDistVOs != null && vskPortDistVOs.size() > 0){
				for(int i=0; i<vskPortDistVOs.size(); i++){
					fmLocCd = vskPortDistVOs.get(i).getFmLocCd();
					toLocCd = vskPortDistVOs.get(i).getToLocCd();
					
					stndDist = dbDao.searchVskPortDist(fmLocCd, toLocCd);
					
					VskPortDistVO vskPortDistVO = new VskPortDistVO();
					vskPortDistVO.setStndDist(stndDist);
					
					list.add(vskPortDistVO);
				}
			}
			
			return list;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Costal Schedule of POL, POD
	 * 
	 * @param CstSkdByPolPodVO cstSkdByPolPodVO
	 * @return List<CstSkdByPolPodVO>
	 * @exception EventException
	 */
	public List<CstSkdByPolPodVO> searchCstSkdByPolPod(CstSkdByPolPodVO cstSkdByPolPodVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPolPod(cstSkdByPolPodVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param CstSkdByPortVO cstSkdByPortVO
	 * @return List<CstSkdByPortVO>
	 * @exception EventException
	 */
	public List<CstSkdByPortVO> searchCstSkdByPort(CstSkdByPortVO cstSkdByPortVO) throws EventException {
		try {
			return dbDao.searchCstSkdByPort(cstSkdByPortVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving Time Zone, Manu In/Out, Terminal Productivity, Port Expence
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchCstSkdSimBaseInfo(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException {
		
		try {

//			SwapCstSkdSimVO swapCstSkdSimVO = new SwapCstSkdSimVO();
//			MdmVslCntrVO mdmVslCntrVO = null;
			
			//LNK_DIST(PORT_DIST), Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY
			//by top//swapCstSkdSimVO = dbDao.searchVskPortMnvrTimeZone(swapCstGRPVO.getVslCd(), swapCstGRPVO.getPortCd(), swapCstGRPVO.getYardCd(), null, null);
			return dbDao.searchVskPortMnvrTimeZone(cstSkdSimDtlCalcInfoVO);
			
			//SPD
//			mdmVslCntrVO = dbDao.searchMdmVslCntr(swapCstGRPVO.getVslCd());
			//by top//swapCstSkdSimVO.setLnkSpd(dbDao.searchMdmVslCntr(swapCstGRPVO.getVslCd()).getVslSvcSpd());
			
			//TimeZone(Time Diff)
			//by top//swapCstSkdSimVO.setTimeDiff(dbDao.searchTimeZone(swapCstGRPVO.getPortCd()).getTimeDiff());
			
			//by top//return swapCstSkdSimVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving DATA in case Speed change
	 * 
	 * @param CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO
	 * @return CstSkdSimDtlCalcInfoVO
	 * @exception EventException
	 */
	public CstSkdSimDtlCalcInfoVO searchBunkerQtyBySpeed(CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) throws EventException{
		try {
			//Bunker Additional Cost
			return dbDao.searchBunkerQtyBySpeed(cstSkdSimDtlCalcInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Retrieving VSL SKD History
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<VskVslSkdHisVO>
	 * @exception EventException
	 */
	public List<VskVslSkdHisVO> searchCstSkdHisByVvd(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException{
		try {
			return dbDao.searchCstSkdHisByVvd(vvdPortLaneOtherVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Finding CNSHA Port, pre bound port, and Retrieving Bay Plan Port
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchBayPlanInputPort(VskVslPortSkdVO vskVslPortSkdVO) throws EventException{
		try {
			return dbDao.searchBayPlanInputPort(vskVslPortSkdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Calculating Loadable Weight and Retrieving
	 * 
	 * @param LoadWgtGRPVO loadWgtGRPVO
	 * @return LoadWgtGRPVO
	 * @exception EventException
	 */
	public LoadWgtGRPVO calLoadableWgt(LoadWgtGRPVO loadWgtGRPVO) throws EventException{
		try {
			LoadWgtGRPVO rtnGRPVO = new LoadWgtGRPVO();
			LoadWgtVO paramVO = null;
			MdmVslCntrVO mdmVslCntrVO = null;
			VskDepRptVO vskDepRptVO = null;
			VskPortTideVO vskPortTideVO = null;
			VskHydrstMtxVO vskHydrstMtxVO = null;
			List<LoadWgtVO> loadWgtVOs = null;
			ArrayList<String> cwParam = new ArrayList<String>();
			
			paramVO = loadWgtGRPVO.getLoadWgtVO();
			
			/*
			 * CNTR_VSL_CLSS_CAPA AS VSL_CLASS(Vessel Class)
			 * LGT_SHP_TONG_WGT AS LIGHT_SHIP(Light Ship)
			 */
			mdmVslCntrVO = dbDao.searchMdmVslCntrInfo(paramVO.getVslCd());
			String sVslClss = "";
			String sLightShip = "";
			if(mdmVslCntrVO != null){
				sVslClss = mdmVslCntrVO.getCntrVslClssCapa();
				sLightShip = mdmVslCntrVO.getLgtShpTongWgt();
				rtnGRPVO.setVslClass(sVslClss);
				rtnGRPVO.setLightShip(sLightShip);
			}
			
			/*
			 * (DEP_FOIL_WGT + DEP_LOW_SULP_FOIL_WGT) AS Fuel_Oil
			 * (DEP_DOIL_WGT + DEP_LOW_SULP_DOIL_WGT) AS Diesel_Oil
			 * (DEP_FRSH_WTR_WGT) AS Fresh_Water
			 * (DEP_BLST_WGT) AS Ballast
			 */
			vskDepRptVO = dbDao.searchDeptureReport(paramVO);
			
			String sFuelOil = paramVO.getFuelOil();
			String sDieselOil = paramVO.getDieselOil();
			String sFreshWater = paramVO.getFreshWater();
			String sBallast = paramVO.getBallast();
			
			if(vskDepRptVO != null){
				/*
				 * if inputted data is null, calculating displacement
				 */
				if(!VSKGeneralUtil.isNotNull(sFuelOil)) sFuelOil = vskDepRptVO.getDepFoilWgt();
				if(!VSKGeneralUtil.isNotNull(sDieselOil)) sDieselOil = vskDepRptVO.getDepDoilWgt();
				if(!VSKGeneralUtil.isNotNull(sFreshWater)) sFreshWater = vskDepRptVO.getDepFrshWtrWgt();
				if(!VSKGeneralUtil.isNotNull(sBallast)) sBallast = vskDepRptVO.getDepBlstWgt();
			}
			rtnGRPVO.setFuelOil(sFuelOil);
			rtnGRPVO.setDieselOil(sDieselOil);
			rtnGRPVO.setFreshWater(sFreshWater);
			rtnGRPVO.setBallast(sBallast);
			
			/*
			 * N1ST_HIGH_TIDE_HGT AS DRAFT(Draft at FW)
			 */
			vskPortTideVO = dbDao.searchPortTide(paramVO);
			String sDraft = "";
			if(vskPortTideVO != null){
				sDraft = vskPortTideVO.getN1stHighTideHgt();
				rtnGRPVO.setDraft(sDraft);
			}
			
			/*
			 * DRFT_DPTH AS TPC, DWT_WGT AS DISPLACEMENT(Displacement)
			 */
			String sDisplacement = "";
			if(VSKGeneralUtil.isNotNull(sDraft) && VSKGeneralUtil.isNotNull(sVslClss) && vskPortTideVO != null){
				vskHydrstMtxVO = dbDao.searchHydrstWgt(vskPortTideVO.getN1stHighTideHgt(), paramVO.getVslCd());
				if(vskHydrstMtxVO != null){
					sDisplacement = vskHydrstMtxVO.getDwtWgt();
					rtnGRPVO.setTpc(vskHydrstMtxVO.getDrftDpth());
					rtnGRPVO.setDisplacement(vskHydrstMtxVO.getDwtWgt());
				}
			}
			
			String sConstant = JSPUtil.removeCharacter(VSKGeneralUtil.getCheckNullToZero(loadWgtGRPVO.getLoadWgtVO().getConstant()), ",");
			
			/*
			 * Calculating Cargo Weight
			 * Cargo Weight = Displacement - (Light Ship + Constant + Fuel Oil + Diesel Oil + Fresh Water + Ballast)
			 */
			cwParam.add(sLightShip);
			cwParam.add(sConstant);
			cwParam.add(sFuelOil);
			cwParam.add(sDieselOil);
			cwParam.add(sFreshWater);
			cwParam.add(sBallast);
			
			String cargoWeight = calcCargoWeight(sDisplacement, cwParam);
			rtnGRPVO.setCargoWeight(cargoWeight);
			paramVO.setCargoWeight(cargoWeight);
			
			//BSA, Loadable Cargo Weight, Loaded Cargo Weight, Actual Loadable Weight
			loadWgtVOs = dbDao.searchCoaBsaByVvd(paramVO);
			if(loadWgtVOs != null){
				rtnGRPVO.setLoadWgtVOList(loadWgtVOs);
			}
			
			return rtnGRPVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Calculating Cargo Weight
	 * 
	 * @param String sDisplacement
	 * @param ArrayList<String> sParam
	 * @return String
	 */
	private String calcCargoWeight(String sDisplacement, ArrayList<String> sParam){
		String sCargoWeight = "0.0";
		
		/*
		 * Cargo Weight = Displacement - (Light Ship + Constant + Fuel Oil + Diesel Oil + Fresh Water + Ballast)
		 * => sDisplacement - (ALL ADD(sParam))
		 */
		if(sParam != null && VSKGeneralUtil.isNotNull(sDisplacement)){
			BigDecimal bDisplacement = new BigDecimal(sDisplacement);
			
			for(int i=0; i<sParam.size(); i++){
				if(VSKGeneralUtil.isNotNull(sParam.get(i))){
					BigDecimal bParam = new BigDecimal(JSPUtil.removeCharacter(sParam.get(i), ","));
					bDisplacement = bDisplacement.subtract(bParam);
				}
			}
			
			sCargoWeight = bDisplacement.toString();
		}
		
		return sCargoWeight;
	}
	
	/**
	 * Retrieving Booking List
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgListByVvdVO>
	 * @exception EventException
	 */
	public List<BkgListByVvdVO> searchBkgListByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException {
		try{
			List<BkgListByVvdVO> list = dbDao.searchBkgListByVvd(vslCd, skdVoyNo, skdDirCd);
			if(list.size()==0){
				throw new EventException(new ErrorHandler("VSK10024").getMessage());
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Manually Closing VVD
	 * 
	 * @param ActivationVvdVO[] activationVvdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslSkdListByLane(ActivationVvdVO[] activationVvdVOs, SignOnUserAccount account) throws EventException {
		
		try{
			
			for(ActivationVvdVO vo : activationVvdVOs){
				vo.setUpdUsrId(account.getUsr_id());
			}
			dbDao.modifyVslSkdListByLane(activationVvdVOs);

			//IBIS
			for(ActivationVvdVO vo : activationVvdVOs) {
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				vskVslSkdVO.setVslCd(vo.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vo.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vo.getSkdDirCd());
				
				List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vskVslSkdVO);
				for(VskVslSkdVO row : list) {
					this.mVskVslSkdList.add(row);
				}
			}
			//IBIS
			
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			/*** :: VVD Close<->Activate �대젰�곗씠���앹꽦濡쒖쭅異붽� ::
		      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
		      *   濡쒖쭅異붽��쇱옄 : 2013-08-08
		      ***/
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			
			for(ActivationVvdVO actVvdVo : activationVvdVOs){
				
				VslSkdXtraHisVO	tmpVO				= new VslSkdXtraHisVO();
				
				tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
				tmpVO.setVskdCngTpCd	("F");							/** 'F':Activate, 'G':Holding/Closing	**/
				tmpVO.setBfrVslSlanCd	(actVvdVo.getVslSlanCd		());
				tmpVO.setBfrVslCd		(actVvdVo.getVslCd			());
				tmpVO.setBfrSkdVoyNo	(actVvdVo.getSkdVoyNo		());
				tmpVO.setBfrSkdDirCd	(actVvdVo.getSkdDirCd		());
				
				tmpVO.setBfrPfSvcTpCd	(actVvdVo.getPfSkdTpCd		());
				
				tmpVO.setUpdUsrId		(account.getUsr_id			());
				tmpVO.setBkgAtchFlg		("");
				
				vslSkdXtraHisVOs.add	(tmpVO);					
				
			}
			
		    this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "MODIFY_VvdStatusChange");
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}
	
	/**
	 * Activating VVD
	 *  
	 * @param ActivationVvdVO activationVvdVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageSkdActivate(ActivationVvdVO activationVvdVO, SignOnUserAccount account) throws EventException {
		
		try{
			
			activationVvdVO.setUpdUsrId(account.getUsr_id());
			dbDao.manageSkdActivate(activationVvdVO);
			
			//IBIS
			VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
			vskVslSkdVO.setVslCd(activationVvdVO.getVslCd());
			vskVslSkdVO.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
			vskVslSkdVO.setSkdDirCd(activationVvdVO.getSkdDirCd());
			
			List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vskVslSkdVO);
			for(VskVslSkdVO row : list) {
				this.mVskVslSkdList.add(row);
			}
			//IBIS
			
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			/*** :: VVD Activation �대젰�곗씠���앹꽦濡쒖쭅異붽� ::
		      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
		      *   濡쒖쭅異붽��쇱옄 : 2013-08-08
		      ***/
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			VslSkdXtraHisVO			tmpVO				= new VslSkdXtraHisVO();
			
			tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
			tmpVO.setVskdCngTpCd	("F");							/** 'F':Activate, 'G:Holding/Closing	**/
			tmpVO.setBfrVslSlanCd	(activationVvdVO.getVslSlanCd	());
			tmpVO.setBfrVslCd		(activationVvdVO.getVslCd		());
			tmpVO.setBfrSkdVoyNo	(activationVvdVO.getSkdVoyNo	());
			tmpVO.setBfrSkdDirCd	(activationVvdVO.getSkdDirCd	());
			
			tmpVO.setBfrPfSvcTpCd	(activationVvdVO.getPfSkdTpCd	());
			
			tmpVO.setUpdUsrId		(account.getUsr_id				());
			tmpVO.setBkgAtchFlg		("");
			
			vslSkdXtraHisVOs.add	(tmpVO);
			
		    this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "ACTIVATE_ByVvd");
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}

	/**
	 * JMS Inbound EDS061-0001
	 *  
	 * @param  VskNoonRptVO[] vskNoonRptVOs
	 * @exception EventException
	 */
	public void createNoonReport(VskNoonRptVO[] vskNoonRptVOs) throws EventException {

		VslPortSkdVO checkVO = null;
		String 		 cudFlg  = "";		//D, delete
		
		try{
			for(int i=0; i<vskNoonRptVOs.length; i++){
				VslPortSkdVO vslPortSkdVO = new VslPortSkdVO();
				vslPortSkdVO.setVslCd(vskNoonRptVOs[i].getVslCd());
				vslPortSkdVO.setSkdVoyNo(vskNoonRptVOs[i].getSkdVoyNo());
				vslPortSkdVO.setSkdDirCd(vskNoonRptVOs[i].getSkdDirCd());
				vslPortSkdVO.setVpsPortCd(vskNoonRptVOs[i].getNxtPortCd());
				vslPortSkdVO.setClptIndSeq("1");
				
				checkVO = dbDao.searchCstSkdByVvdPort(vslPortSkdVO);	//1 or Null
				
				if(checkVO != null){ 
					cudFlg = vskNoonRptVOs[i].getUpdUsrId();
					cleanString(vskNoonRptVOs[i]);
					if("D".equalsIgnoreCase(cudFlg)){
						dbDao.removeVskNoonRpt(vskNoonRptVOs[i]);		//Delete
					} else{					
						dbDao.addVskNoonRpt(vskNoonRptVOs[i]);			//Merge
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Initializing trash data of VskDepRptVO to null string
	 * @param VskNoonRptVO vskNoonRptVO
	 */
	private void cleanString(VskNoonRptVO vskNoonRptVO){
		vskNoonRptVO.setPortLat      		(vskNoonRptVO.getPortLat()==null?"":          vskNoonRptVO.getPortLat().trim()         );
		vskNoonRptVO.setPortLon      		(vskNoonRptVO.getPortLon()==null?"":          vskNoonRptVO.getPortLon().trim()         );
		vskNoonRptVO.setSailHrmnt    		(vskNoonRptVO.getSailHrmnt()==null?"":        vskNoonRptVO.getSailHrmnt().trim()       );
		vskNoonRptVO.setNvgtDist     		(vskNoonRptVO.getNvgtDist()==null?"":         vskNoonRptVO.getNvgtDist().trim()        );
		vskNoonRptVO.setEngMlDist    		(vskNoonRptVO.getEngMlDist()==null?"":        vskNoonRptVO.getEngMlDist().trim()       );
		vskNoonRptVO.setWndDirCtnt   	(vskNoonRptVO.getWndDirCtnt()==null?"":       vskNoonRptVO.getWndDirCtnt().trim()      );
		vskNoonRptVO.setWndSclNo     	(vskNoonRptVO.getWndSclNo()==null?"":         vskNoonRptVO.getWndSclNo().trim()        );
		vskNoonRptVO.setOcnCrntCtnt  	(vskNoonRptVO.getOcnCrntCtnt()==null?"":      vskNoonRptVO.getOcnCrntCtnt().trim()     );
		vskNoonRptVO.setSeaSteNo     		(vskNoonRptVO.getSeaSteNo()==null?"":         vskNoonRptVO.getSeaSteNo().trim()        );
		vskNoonRptVO.setVisRngNo     		(vskNoonRptVO.getVisRngNo()==null?"":         vskNoonRptVO.getVisRngNo().trim()        );
		vskNoonRptVO.setCrntActSpd   		(vskNoonRptVO.getCrntActSpd()==null?"":       vskNoonRptVO.getCrntActSpd().trim()      );
		vskNoonRptVO.setCrntActRpmPwr	(vskNoonRptVO.getCrntActRpmPwr()==null?"":    vskNoonRptVO.getCrntActRpmPwr().trim()   );
		vskNoonRptVO.setSlpRt        		(vskNoonRptVO.getSlpRt()==null?"":            vskNoonRptVO.getSlpRt().trim()           );
		vskNoonRptVO.setRmnDist      		(vskNoonRptVO.getRmnDist()==null?"":          vskNoonRptVO.getRmnDist().trim()         );
		vskNoonRptVO.setRmnAvgSpd  		(vskNoonRptVO.getRmnAvgSpd()==null?"":        vskNoonRptVO.getRmnAvgSpd().trim()       );
		vskNoonRptVO.setFoilCsmWgt  		(vskNoonRptVO.getFoilCsmWgt()==null?"":       vskNoonRptVO.getFoilCsmWgt().trim()      );
		vskNoonRptVO.setDoilCsmWgt  	(vskNoonRptVO.getDoilCsmWgt()==null?"":       vskNoonRptVO.getDoilCsmWgt().trim()      );
		vskNoonRptVO.setCrsNo        		(vskNoonRptVO.getCrsNo()==null?"":            vskNoonRptVO.getCrsNo().trim()           );
		vskNoonRptVO.setLodIndQty    		(vskNoonRptVO.getLodIndQty()==null?"":        vskNoonRptVO.getLodIndQty().trim()       );
	}
	
	/**
	 * JMS Inbound EDS062-0001
	 *  
	 * @param  VskDepRptVO[] vskDepRptVOs
	 * @exception EventException
	 */
	public void createDepartureReport(VskDepRptVO[] vskDepRptVOs) throws EventException {
		
		VslPortSkdVO checkVO = null;
		String 		 cudFlg  = "";		//D, delete
		
		try{
			for(int i=0; i<vskDepRptVOs.length; i++){
				VslPortSkdVO vslPortSkdVO = new VslPortSkdVO();
				vslPortSkdVO.setVslCd(vskDepRptVOs[i].getVslCd());
				vslPortSkdVO.setSkdVoyNo(vskDepRptVOs[i].getSkdVoyNo());
				vslPortSkdVO.setSkdDirCd(vskDepRptVOs[i].getSkdDirCd());
				vslPortSkdVO.setVpsPortCd(vskDepRptVOs[i].getVpsPortCd());
				vslPortSkdVO.setClptIndSeq("1");
				
				checkVO = dbDao.searchCstSkdByVvdPort(vslPortSkdVO);	//1 or Null
				
				if(checkVO != null){ 
					vskDepRptVOs[i].setClptIndSeq("1");	
					cleanString(vskDepRptVOs[i]);
					
					cudFlg = vskDepRptVOs[i].getUpdUsrId();
					
					if("D".equalsIgnoreCase(cudFlg)){
						dbDao.removeVskDepRpt(vskDepRptVOs[i]);
						// Deleting Virtual port report with TURNING
						if( checkVO.getTurnSkdVoyNo() 		!= null && checkVO.getTurnSkdVoyNo().length() 	== 4
							&& checkVO.getTurnSkdDirCd() 	!= null && checkVO.getTurnSkdDirCd().length() 	== 1
							&& checkVO.getTurnClptIndSeq() 	!= null && checkVO.getTurnClptIndSeq().length() == 1
						){
							vskDepRptVOs[i].setSkdVoyNo(checkVO.getTurnSkdVoyNo());
							vskDepRptVOs[i].setSkdDirCd(checkVO.getTurnSkdDirCd());
							vskDepRptVOs[i].setClptIndSeq(checkVO.getTurnClptIndSeq());
							dbDao.removeVskDepRpt(vskDepRptVOs[i]);
						}
					} else{
						/*
						dbDao.addVskDepRpt(vskDepRptVOs[i]);
						// Adding Virtual Port Report with TURNING
						if( checkVO.getTurnSkdVoyNo() 		!= null && checkVO.getTurnSkdVoyNo().length() 	== 4
							&& checkVO.getTurnSkdDirCd() 	!= null && checkVO.getTurnSkdDirCd().length() 	== 1
							&& checkVO.getTurnClptIndSeq() 	!= null && checkVO.getTurnClptIndSeq().length() == 1
						){
							vskDepRptVOs[i].setSkdVoyNo(checkVO.getTurnSkdVoyNo());
							vskDepRptVOs[i].setSkdDirCd(checkVO.getTurnSkdDirCd());
							vskDepRptVOs[i].setClptIndSeq(checkVO.getTurnClptIndSeq());
							dbDao.addVskDepRpt(vskDepRptVOs[i]);
							
						}*/
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Initializing trash data of VskDepRptVO to null string
	 * @param VskDepRptVO vskDepRptVO
	 */
	private void cleanString(VskDepRptVO vskDepRptVO){
		
		vskDepRptVO.setRmnDist(										vskDepRptVO.getRmnDist()==null?"":                 vskDepRptVO.getRmnDist().trim());
		vskDepRptVO.setRmnAvgSpd(									vskDepRptVO.getRmnAvgSpd()==null?"":               vskDepRptVO.getRmnAvgSpd().trim());
		vskDepRptVO.setArrFwddrHgt(								vskDepRptVO.getArrFwddrHgt()==null?"":             vskDepRptVO.getArrFwddrHgt().trim());
		vskDepRptVO.setArrMidDrftHgt(							vskDepRptVO.getArrMidDrftHgt()==null?"":           vskDepRptVO.getArrMidDrftHgt().trim());
		vskDepRptVO.setArrAftdrHgt(								vskDepRptVO.getArrAftdrHgt()==null?"":             vskDepRptVO.getArrAftdrHgt().trim());
		vskDepRptVO.setArrGmHgt(									vskDepRptVO.getArrGmHgt()==null?"":                vskDepRptVO.getArrGmHgt().trim());
		vskDepRptVO.setArrFoilWgt(								vskDepRptVO.getArrFoilWgt()==null?"":              vskDepRptVO.getArrFoilWgt().trim());
		vskDepRptVO.setArrDoilWgt(								vskDepRptVO.getArrDoilWgt()==null?"":              vskDepRptVO.getArrDoilWgt().trim());
		vskDepRptVO.setArrFrshWtrWgt(							vskDepRptVO.getArrFrshWtrWgt()==null?"":           vskDepRptVO.getArrFrshWtrWgt().trim());
		vskDepRptVO.setArrBlstWgt(								vskDepRptVO.getArrBlstWgt()==null?"":              vskDepRptVO.getArrBlstWgt().trim());
		vskDepRptVO.setArrLowSulpFoilWgt(					vskDepRptVO.getArrLowSulpFoilWgt()==null?"":       vskDepRptVO.getArrLowSulpFoilWgt().trim());
		vskDepRptVO.setArrLowSulpDoilWgt(					vskDepRptVO.getArrLowSulpDoilWgt()==null?"":       vskDepRptVO.getArrLowSulpDoilWgt().trim());
		vskDepRptVO.setDepFwddrHgt(								vskDepRptVO.getDepFwddrHgt()==null?"":             vskDepRptVO.getDepFwddrHgt().trim());
		vskDepRptVO.setDepMidDrftHgt(							vskDepRptVO.getDepMidDrftHgt()==null?"":           vskDepRptVO.getDepMidDrftHgt().trim());
		vskDepRptVO.setDepAftdrHgt(								vskDepRptVO.getDepAftdrHgt()==null?"":             vskDepRptVO.getDepAftdrHgt().trim());
		vskDepRptVO.setDepGmHgt(									vskDepRptVO.getDepGmHgt()==null?"":                vskDepRptVO.getDepGmHgt().trim());
		vskDepRptVO.setDepFoilWgt(								vskDepRptVO.getDepFoilWgt()==null?"":              vskDepRptVO.getDepFoilWgt().trim());
		vskDepRptVO.setDepDoilWgt(								vskDepRptVO.getDepDoilWgt()==null?"":              vskDepRptVO.getDepDoilWgt().trim());
		vskDepRptVO.setDepFrshWtrWgt(							vskDepRptVO.getDepFrshWtrWgt()==null?"":           vskDepRptVO.getDepFrshWtrWgt().trim());
		vskDepRptVO.setDepBlstWgt(								vskDepRptVO.getDepBlstWgt()==null?"":              vskDepRptVO.getDepBlstWgt().trim());
		vskDepRptVO.setDepLowSulpFoilWgt(					vskDepRptVO.getDepLowSulpFoilWgt()==null?"":       vskDepRptVO.getDepLowSulpFoilWgt().trim());
		vskDepRptVO.setDepLowSulpDoilWgt(					vskDepRptVO.getDepLowSulpDoilWgt()==null?"":       vskDepRptVO.getDepLowSulpDoilWgt().trim());
		vskDepRptVO.setSplFoilWgt(								vskDepRptVO.getSplFoilWgt()==null?"":              vskDepRptVO.getSplFoilWgt().trim());
		vskDepRptVO.setSplDoilWgt(								vskDepRptVO.getSplDoilWgt()==null?"":              vskDepRptVO.getSplDoilWgt().trim());
		vskDepRptVO.setSplFrshWtrWgt(							vskDepRptVO.getSplFrshWtrWgt()==null?"":           vskDepRptVO.getSplFrshWtrWgt().trim());
		vskDepRptVO.setSplLowSulpFoilWgt(					vskDepRptVO.getSplLowSulpFoilWgt()==null?"":       vskDepRptVO.getSplLowSulpFoilWgt().trim());
		vskDepRptVO.setSplLowSulpDoilWgt(					vskDepRptVO.getSplLowSulpDoilWgt()==null?"":       vskDepRptVO.getSplLowSulpDoilWgt().trim());
		vskDepRptVO.setNvgtDist(									vskDepRptVO.getNvgtDist()==null?"":                vskDepRptVO.getNvgtDist().trim());
		vskDepRptVO.setEngMlDist(									vskDepRptVO.getEngMlDist()==null?"":               vskDepRptVO.getEngMlDist().trim());
		vskDepRptVO.setAvgSpd(										vskDepRptVO.getAvgSpd()==null?"":                  vskDepRptVO.getAvgSpd().trim());
		vskDepRptVO.setAvgRpmPwr(									vskDepRptVO.getAvgRpmPwr()==null?"":               vskDepRptVO.getAvgRpmPwr().trim());
		vskDepRptVO.setMnvrInMlDist(							vskDepRptVO.getMnvrInMlDist()==null?"":            vskDepRptVO.getMnvrInMlDist().trim());
		vskDepRptVO.setMnvrOutMlDist(							vskDepRptVO.getMnvrOutMlDist()==null?"":           vskDepRptVO.getMnvrOutMlDist().trim());
		vskDepRptVO.setSeaMnFuelCsmWgt(						vskDepRptVO.getSeaMnFuelCsmWgt()==null?"":         vskDepRptVO.getSeaMnFuelCsmWgt().trim());
		vskDepRptVO.setSeaGnrFuelCsmWgt(					vskDepRptVO.getSeaGnrFuelCsmWgt()==null?"":        vskDepRptVO.getSeaGnrFuelCsmWgt().trim());
		vskDepRptVO.setSeaBlrFuelCsmWgt(					vskDepRptVO.getSeaBlrFuelCsmWgt()==null?"":        vskDepRptVO.getSeaBlrFuelCsmWgt().trim());
		vskDepRptVO.setSeaMnDzlCsmWgt(						vskDepRptVO.getSeaMnDzlCsmWgt()==null?"":          vskDepRptVO.getSeaMnDzlCsmWgt().trim());
		vskDepRptVO.setSeaGnrDzlCsmWgt(						vskDepRptVO.getSeaGnrDzlCsmWgt()==null?"":         vskDepRptVO.getSeaGnrDzlCsmWgt().trim());
		vskDepRptVO.setSeaBlrDzlCsmWgt(						vskDepRptVO.getSeaBlrDzlCsmWgt()==null?"":         vskDepRptVO.getSeaBlrDzlCsmWgt().trim());
		vskDepRptVO.setSeaMnLowSulpFuelCsmWgt(		vskDepRptVO.getSeaMnLowSulpFuelCsmWgt()==null?"":  vskDepRptVO.getSeaMnLowSulpFuelCsmWgt().trim());
		vskDepRptVO.setSeaGnrLowSulpFuelCsmWgt(		vskDepRptVO.getSeaGnrLowSulpFuelCsmWgt()==null?"": vskDepRptVO.getSeaGnrLowSulpFuelCsmWgt().trim());
		vskDepRptVO.setSeaBlrLowSulpFuelCsmWgt(		vskDepRptVO.getSeaBlrLowSulpFuelCsmWgt()==null?"": vskDepRptVO.getSeaBlrLowSulpFuelCsmWgt().trim());
		vskDepRptVO.setSeaMnLowSulpDzlCsmWgt(			vskDepRptVO.getSeaMnLowSulpDzlCsmWgt()==null?"":   vskDepRptVO.getSeaMnLowSulpDzlCsmWgt().trim());
		vskDepRptVO.setSeaGnrLowSulpDzlCsmWgt(		vskDepRptVO.getSeaGnrLowSulpDzlCsmWgt()==null?"":  vskDepRptVO.getSeaGnrLowSulpDzlCsmWgt().trim());
		vskDepRptVO.setSeaBlrLowSulpDzlCsmWgt(		vskDepRptVO.getSeaBlrLowSulpDzlCsmWgt()==null?"":  vskDepRptVO.getSeaBlrLowSulpDzlCsmWgt().trim());
		vskDepRptVO.setPortMnFuelCsmWgt(					vskDepRptVO.getPortMnFuelCsmWgt()==null?"":        vskDepRptVO.getPortMnFuelCsmWgt().trim());
		vskDepRptVO.setPortGnrFuelCsmWgt(					vskDepRptVO.getPortGnrFuelCsmWgt()==null?"":       vskDepRptVO.getPortGnrFuelCsmWgt().trim());
		vskDepRptVO.setPortBlrFuelCsmWgt(					vskDepRptVO.getPortBlrFuelCsmWgt()==null?"":       vskDepRptVO.getPortBlrFuelCsmWgt().trim());
		vskDepRptVO.setPortMnDzlCsmWgt(						vskDepRptVO.getPortMnDzlCsmWgt()==null?"":         vskDepRptVO.getPortMnDzlCsmWgt().trim());
		vskDepRptVO.setPortGnrDzlCsmWgt(					vskDepRptVO.getPortGnrDzlCsmWgt()==null?"":        vskDepRptVO.getPortGnrDzlCsmWgt().trim());
		vskDepRptVO.setPortBlrDzlCsmWgt(					vskDepRptVO.getPortBlrDzlCsmWgt()==null?"":        vskDepRptVO.getPortBlrDzlCsmWgt().trim());
		vskDepRptVO.setPortMnLowSulpFuelCsmWgt(		vskDepRptVO.getPortMnLowSulpFuelCsmWgt()==null?"": vskDepRptVO.getPortMnLowSulpFuelCsmWgt().trim());
		vskDepRptVO.setPortGnrLowSulpFuelCsmWgt(	vskDepRptVO.getPortGnrLowSulpFuelCsmWgt()==null?"":vskDepRptVO.getPortGnrLowSulpFuelCsmWgt().trim());
		vskDepRptVO.setPortBlrLowSulpFuelCsmWgt(	vskDepRptVO.getPortBlrLowSulpFuelCsmWgt()==null?"":vskDepRptVO.getPortBlrLowSulpFuelCsmWgt().trim());
		vskDepRptVO.setPortMnLowSulpDzlCsmWgt(		vskDepRptVO.getPortMnLowSulpDzlCsmWgt()==null?"":  vskDepRptVO.getPortMnLowSulpDzlCsmWgt().trim());
		vskDepRptVO.setPortGnrLowSulpDzlCsmWgt(		vskDepRptVO.getPortGnrLowSulpDzlCsmWgt()==null?"": vskDepRptVO.getPortGnrLowSulpDzlCsmWgt().trim());
		vskDepRptVO.setPortBlrLowSulpDzlCsmWgt(		vskDepRptVO.getPortBlrLowSulpDzlCsmWgt()==null?"": vskDepRptVO.getPortBlrLowSulpDzlCsmWgt().trim());
		vskDepRptVO.setTtlSlgWgt(									vskDepRptVO.getTtlSlgWgt()==null?"":               vskDepRptVO.getTtlSlgWgt().trim());
		
	}
	
	/**
	 * Retrieving Canal Transit List and Surcharge
	 * 
	 * @param CanalTransitTargetVvdVO canalTransitTargetVvdVO
	 * @return List<CanalTransitTargetVvdVO>
	 * @exception EventException
	 */
	public List<CanalTransitTargetVvdVO> searchCanalTzList(CanalTransitTargetVvdVO canalTransitTargetVvdVO) throws EventException {
		try{
			List<CanalTransitTargetVvdVO> bayList = new ArrayList<CanalTransitTargetVvdVO>();
			List<CanalTransitTargetVvdVO> afterBayList = new ArrayList<CanalTransitTargetVvdVO>();
			Map<String, CanalTransitTargetVvdVO> item = new HashMap<String, CanalTransitTargetVvdVO>();

			// 1. Retrieving schedule
			List<CanalTransitTargetVvdVO> list = dbDao.searchCanalTzList(canalTransitTargetVvdVO);
			
			
			// 2. Retrieving bay plan in case of EGSCA
			if(VSKGeneralUtil.SUEZ_CANAL.equals(canalTransitTargetVvdVO.getPortCd())){
				for(CanalTransitTargetVvdVO vo : list){
					item.put(vo.getVvd(), vo);
					if(!"".equals(VSKGeneralUtil.getCheckNullToString(vo.getBayLoc()))){
						bayList.add(vo);
					}
				}
			}
			
			int pos = 0;
			int cnt = 0;
			int pkgCnt = 30;
			for(int i=0; i<bayList.size(); i++){
				
				if(i==bayList.size()-1){
					afterBayList.addAll(dbDao.searchCanalTzTierCalc(  bayList.subList(pos, bayList.size())));
				}
				
				if(cnt<pkgCnt){
					cnt++;
					continue;
				}else{
					afterBayList.addAll(dbDao.searchCanalTzTierCalc(  bayList.subList(pos, pos+pkgCnt)));
					pos = i;
					cnt = 1;
					continue;
				}
			}
			
			// Applying retrieved bay_plan to VVD VO
			for(CanalTransitTargetVvdVO vo : afterBayList){
				CanalTransitTargetVvdVO orgVO = item.get(vo.getVvd());
				orgVO.setScgCarPortCd(vo.getScgCarPortCd());
				orgVO.setScgCarTier(vo.getScgCarTier());
				orgVO.setScgCarTeu(vo.getScgCarTeu());
				orgVO.setScgCarRatio(vo.getScgCarRatio());
				item.put(vo.getVvd(), orgVO);
			}
			
			// Applying retrieved bay_plan in case of EGSCA
			if(VSKGeneralUtil.SUEZ_CANAL.equals(canalTransitTargetVvdVO.getPortCd())){
				for(CanalTransitTargetVvdVO vo : list){
					CanalTransitTargetVvdVO orgVO = item.get(vo.getVvd());
					vo.setScgCarPortCd(orgVO.getScgCarPortCd());
					vo.setScgCarTier(orgVO.getScgCarTier());
					vo.setScgCarTeu(orgVO.getScgCarTeu());
					vo.setScgCarRatio(orgVO.getScgCarRatio());
				}
			}
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving difference of Bunker charge and Canal Surcharge
	 * 
	 * @param CanalBnkSavVO canalBnkSavVO
	 * @return List<CanalBnkSavVO>
	 * @exception EventException
	 */
	public List<CanalBnkSavVO> calCanalBunkerSaving(CanalBnkSavVO canalBnkSavVO) throws EventException {
		try{
			
			List<CanalBnkSavVO> list = dbDao.calCanalBunkerSaving(canalBnkSavVO);
			return list;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * Changing data format
	 * 
	 * @param String newDateFormat
	 * @param String oldDateFormat
	 * @param String oldDate
	 * @return String
	 * @exception EventException
	 */
	private String getDateString(String newDateFormat, String oldDateFormat, String oldDate) throws EventException {
		try{
			String newDate = new SimpleDateFormat(newDateFormat).format(new SimpleDateFormat(oldDateFormat).parse(oldDate));
			return newDate;
		}catch(ParseException e){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e); 
		}
	}
	
	/**
	 * Setting P/F
	 * 
	 * @param List<ActivationVvdVO> activationVvdVOs
	 * @exception EventException
	 */
	public void manageVvdPf(List<ActivationVvdVO> activationVvdVOs) throws EventException {
		
		try{
			
			dbDao.manageVvdPf(activationVvdVOs);
			
			//IBIS
			for(ActivationVvdVO vo : activationVvdVOs) {
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				vskVslSkdVO.setVslCd(vo.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vo.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vo.getSkdDirCd());
				
				List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vskVslSkdVO);
				for(VskVslSkdVO row : list) {
					this.mVskVslSkdList.add(row);
				}
			}
			//IBIS
			
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			/*** :: VVD Close<->Activate �대젰�곗씠���앹꽦濡쒖쭅異붽� ::
		      *   TABLE NAME : VSK_VSL_SKD_CNG_HIS
		      *   濡쒖쭅異붽��쇱옄 : 2013-08-08
		      ***/
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			for(ActivationVvdVO actVvdVo : activationVvdVOs){
				
				VslSkdXtraHisVO			tmpVO				= new VslSkdXtraHisVO();
				
				tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
				tmpVO.setVskdCngTpCd	("H");							/** 'H':Proforma Type Change			**/
				tmpVO.setBfrVslSlanCd	(actVvdVo.getVslSlanCd		());
				tmpVO.setBfrVslCd		(actVvdVo.getVslCd			());
				tmpVO.setBfrSkdVoyNo	(actVvdVo.getSkdVoyNo		());
				tmpVO.setBfrSkdDirCd	(actVvdVo.getSkdDirCd		());
				
				tmpVO.setBfrPfSvcTpCd	(actVvdVo.getPfSkdTpCd		());
				
				tmpVO.setUpdUsrId		(actVvdVo.getUpdUsrId		());
				tmpVO.setBkgAtchFlg		("");
				
				vslSkdXtraHisVOs.add	(tmpVO);					
			}
			
			this.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "MODIFY_VvdProformaType");
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://
			
			
		}catch(DAOException e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), e);
		}catch(Exception e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), e);
		}
	}
	
	/**
	 * Retrieving Vessel Port SKD
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return List<PortSkdOnLongRangeVO>
	 * @exception EventException
	 */
	public List<PortSkdOnLongRangeVO> searchPortSkd(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {
		try {
			return dbDao.searchPortSkdOnLongRange(portSkdOnLongRangeVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Vessel Port SKD in Long Range SKD Form
	 * 
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return LongRangeSkdInqGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdInqGRPVO searchPortSkdOnLongRange(PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {
		
		LongRangeSkdInqGRPVO 				longRangeSkdInqGRPVO 	= null;
		Map<String, List<PfSkdDetailVO>> 	pfSkdDetailsByGroup 	= new HashMap<String, List<PfSkdDetailVO>>();
		
		try{
			
//			1. Retrieving PORT SKD
//			2. Getting P/F Type list from retrieved PORT SKD
//			3. Retrieving P/F TYPE
//			4. P/F info /  Combinating PORT SKD (arrangement by first port of P/F)
//			5. arranged list -> by P/F type
//			2015.01.28 Feeder��긽�� Trunk���숈씪 �섍쾶 蹂댁씠寃�蹂�꼍��feeder��10媛��댁긽��寃쎌슦 *濡�蹂댁씠��遺�텇 二쇱꽍 泥섎━��
			
			List<PortSkdOnLongRangeVO> 				subVVDList 				= null;
			Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD 			= new HashMap<String, List<PortSkdOnLongRangeVO>>();
			Map<String, String> 					firstEtbByVVD 			= new HashMap<String, String>();
			
			// 1. Retrieving PORT SKD
			List<PortSkdOnLongRangeVO> 				portSkdOnLongRangeVOs 	= this.searchPortSkd(portSkdOnLongRangeVO);
			
			if(portSkdOnLongRangeVOs==null || portSkdOnLongRangeVOs.size()==0){
				throw new EventException(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());
			}else{
				longRangeSkdInqGRPVO = new LongRangeSkdInqGRPVO();
			}
			
			List<PfSkdDetailVO> pfTypes 	= new ArrayList<PfSkdDetailVO>();
			Map<String, String> portNmMap 	= new HashMap<String, String>(); 
			Map<String, String> vslEngNmMap = new HashMap<String, String>();
			
			for(PortSkdOnLongRangeVO vo1 : portSkdOnLongRangeVOs){

				// 2.1 Getting P/F Type list from retrieved PORT SKD
				// in case of Feeder Port Skd, Setting all Feeder port skd has same data
//				if("O".equals(vo1.getVslSvcTpCd())){ // Trunk
//					vo1.setPfSkdTpCd("FEEDER");
//				}
				
				PfSkdDetailVO pfSkdDetailVO = new PfSkdDetailVO();
				pfSkdDetailVO.setVslSlanCd	(vo1.getVslSlanCd());
				//:2015-11-20:No Need://pfSkdDetailVO.setVslSvcTpCd	(vo1.getVslSvcTpCd());
				pfSkdDetailVO.setPfSvcTpCd	(vo1.getPfSkdTpCd());
				
				boolean sameExist = false;
				for(PfSkdDetailVO vo2 : pfTypes){
					if(vo2.isSameType(pfSkdDetailVO)){ // Comparing VSL_SLAN_CD, PF_SVC_TP_CD
						sameExist = true;
						break;
					}
				}
				
				if(!sameExist){
					pfTypes.add(pfSkdDetailVO);
				}
				
				//------------- [START] Composing sublist by VVD
				//:2015-11-20://String vvdKey = vo1.getVslCd() + vo1.getSkdVoyNo() + vo1.getSkdDirCd();
				String vvdKey 	= vo1.getVslSlanCd() + vo1.getPfSkdTpCd() + vo1.getVslCd() + vo1.getSkdVoyNo() + vo1.getSkdDirCd();
				
				if(portSkdByVVD.containsKey(vvdKey)){
					subVVDList = portSkdByVVD.get(vvdKey);
					subVVDList.add(vo1);
				}else{
					subVVDList = new ArrayList<PortSkdOnLongRangeVO>();
					subVVDList.add(vo1);
				}
				portSkdByVVD.put(vvdKey, subVVDList);
				//------------- [END] Composing sublist by VVD
				
				// 2.2 Getting Port Name and Vessel Eng Name from retrieved port skd
				if(!portNmMap.containsKey(vo1.getVpsPortCd())){
					portNmMap.put(vo1.getVpsPortCd(), vo1.getPortNm());
				}
				if(!vslEngNmMap.containsKey(vo1.getVslCd())){
					vslEngNmMap.put(vo1.getVslCd(), vo1.getVslEngNm());
				}
				
			}
			
			// 2.3  Setting Port Name and Vessel Eng Name to Group VO
			longRangeSkdInqGRPVO.setPortNms		(portNmMap	);
			longRangeSkdInqGRPVO.setVslEngNms	(vslEngNmMap);			
			
			// 3. Retrieving P/F TYPE
			Map<String, List<PfSkdDetailVO>> pfSkdDetails = new HashMap<String, List<PfSkdDetailVO>>();
			
			for(PfSkdDetailVO vo : pfTypes){
				
				//if(!"O".equals(vo.getVslSvcTpCd())){ // Trunk
				//if("".equals(VSKGeneralUtil.getCheckNullToString(vo.getPfSvcTpCd()))){ // Trunk Lane, if PF_SVC_TP_CD is null, throw exception
				//	throw new EventException(new ErrorHandler("VSK10068").getMessage());
				//}
				
				List<PfSkdDetailVO> pfSkdDetailVOs = dbDao.searchPfSkdDetail(vo);
				
				/*************************************************************************
				 * User Exception in case VVD without P/F Service Type. 
				 *************************************************************************
				 */
				if(pfSkdDetailVOs == null || pfSkdDetailVOs.size() == 0){
					StringBuffer 	sbMsg	= new StringBuffer();
									sbMsg.append(new ErrorHandler("VSK10068").getMessage());
									sbMsg.append(" [");
									sbMsg.append(vo.getVslSlanCd());
									sbMsg.append("]");
					
					throw new EventException(sbMsg.toString());	
				}
				
				// Backup P/F
				pfSkdDetails.put	(vo.getVslSlanCd() + vo.getPfSvcTpCd(), pfSkdDetailVOs);
				longRangeSkdInqGRPVO.setPfSkdDetails(pfSkdDetails);
			//}
					
			}
			
			
			/**==================================================
			 *  4. Arranging VVD
			 *===================================================
			 */
			for(Iterator<String> i = portSkdByVVD.keySet().iterator(); i.hasNext(); ){
				String vvdKey = i.next();
				
				List<PortSkdOnLongRangeVO> 	portSkds 		= portSkdByVVD.get(vvdKey);
				PortSkdOnLongRangeVO 		firstPortSkd 	= portSkds.get(0);
				
//				if("O".equals(firstPortSkd.getVslSvcTpCd())){
//					
//					for(PortSkdOnLongRangeVO vo : portSkds){
//						if(firstEtbByVVD.containsKey(vvdKey)){
//							break;
//						}
//						firstEtbByVVD.put(vvdKey, VSKGeneralUtil.changeDateFormat(vo.getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"));
//					}
//					
//				}else{
					
					List<PfSkdDetailVO> pfSkdDetailVOs = pfSkdDetails.get(firstPortSkd.getVslSlanCd() + firstPortSkd.getPfSkdTpCd());
					
					// for loop a1
					// Getting first PF_ETB_DT of VVD using P/F, Setting arranged Map
					for(PortSkdOnLongRangeVO vo : portSkds){
						
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						
						// PF_ETB_DT is null, pass
						if(VSKGeneralUtil.getCheckNullToString(vo.getPfEtbDt()).length()==0){
							continue;
						}
						
						if (pfSkdDetailVOs.size() > 0) {							
							this.setFirstEtbByPF(vvdKey, vo, pfSkdDetailVOs, firstEtbByVVD);
						} else {
							throw new EventException(new ErrorHandler("VSK00096").getMessage());
						}
					}
					
					// for loop a2
					// Getting first PF_ETB_DT of VVD using INIT_ETB_DT, Setting arranged Map
					for(PortSkdOnLongRangeVO vo : portSkds){
						
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						
						// using INIT_ETB_DT, Setting arranged Map
						this.setFirstEtbByInit(vvdKey, vo, pfSkdDetailVOs, firstEtbByVVD);
					
					}
					
					// for loop a3
					// Setting arranged Map always exist INIT_ETB_DT
					for(PortSkdOnLongRangeVO vo : portSkds){
						
						if(firstEtbByVVD.containsKey(vvdKey)){
							break;
						}
						
						firstEtbByVVD.put(vvdKey, VSKGeneralUtil.changeDateFormat(vo.getInitEtbDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"));
					}
					
				}
			
			//}
			
			this.linkTurningVVD		(portSkdByVVD);
			this.linkSameVoyageVVD	(portSkdByVVD);
			
			/**==================================================
			 *  5. arranged list
			 *===================================================
			 */			
			List<List<PortSkdOnLongRangeVO>> orderedPortSkdOnLongRangeVOs	= this.sortPortSkd(portSkdByVVD, firstEtbByVVD);
			longRangeSkdInqGRPVO.setPortSkdVOs(orderedPortSkdOnLongRangeVOs);
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Handling Remark
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			LongRangeSkdInqVO remarkVO = null;
			List<LongRangeSkdInqVO> rmkList = new ArrayList<LongRangeSkdInqVO>();
			Map<String, String> rmkVVD = new HashMap<String, String>();
			
			for(List<PortSkdOnLongRangeVO> list : orderedPortSkdOnLongRangeVOs){
				PortSkdOnLongRangeVO first = list.get(0);
				PortSkdOnLongRangeVO last = list.get(list.size()-1);
				
				String vvd = first.getVslCd() + first.getSkdVoyNo() + first.getSkdDirCd();
				
				if(first.getVpsRmk()!=null && first.getVpsRmk().trim().length()!=0){
					if(!rmkVVD.containsKey(vvd)){
						remarkVO = new LongRangeSkdInqVO();
						remarkVO.setRemarkFlag	(true);
						remarkVO.setVslCd		(first.getVslCd		());
						remarkVO.setSkdVoyNo	(first.getSkdVoyNo	()); 
						remarkVO.setSkdDirCd	(first.getSkdDirCd	());
						remarkVO.setVpsRmk		(first.getVpsRmk	());
						rmkList.add				(remarkVO);
						
						rmkVVD.put				(vvd, vvd);
					}
				}
				
				vvd = last.getVslCd() + last.getSkdVoyNo() + last.getSkdDirCd();
				
				if(last.getVpsRmk()!=null && last.getVpsRmk().trim().length()!=0){
					if(!rmkVVD.containsKey(vvd)){
						remarkVO = new LongRangeSkdInqVO();
						remarkVO.setRemarkFlag	(true);
						remarkVO.setVslCd		(last.getVslCd());
						remarkVO.setSkdVoyNo	(last.getSkdVoyNo()); 
						remarkVO.setSkdDirCd	(last.getSkdDirCd());
						remarkVO.setVpsRmk		(last.getVpsRmk());
						rmkList.add				(remarkVO);
						
						rmkVVD.put(vvd, vvd);
					}
				}
			}

			longRangeSkdInqGRPVO.setRemarks(rmkList);
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			// grouping by P/F
			
			/**==========================================================================
			 * Start of sorting by proforma type code
			 * 2015-04-20 by TOP
			 * ==========================================================================
			 */
			
			List<List<List<PortSkdOnLongRangeVO>>> groupByPfSkdType = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();

			String preVslSlanPfSkd = "";
			String curVslSlanPfSkd = "";
			
			List<List<PortSkdOnLongRangeVO>> tmp = new ArrayList<List<PortSkdOnLongRangeVO>>();
			
			
			//====================== Below is Old Source Code ========================//
			
/*			for(List<PortSkdOnLongRangeVO> portSkds : orderedPortSkdOnLongRangeVOs){
				
				currentPfSkdTpCd = portSkds.get(0).getPfSkdTpCd();

				if(beforePfSkdTpCd==null){
					tmp.add(portSkds);
				}else{
					if(beforePfSkdTpCd.equals(currentPfSkdTpCd)){
						tmp.add(portSkds);
					}else{
						groupByPfSkdType.add(tmp);
						tmp = new ArrayList<List<PortSkdOnLongRangeVO>>();
						tmp.add(portSkds);
					}
				}	
				
				beforePfSkdTpCd = currentPfSkdTpCd;
			}
			groupByPfSkdType.add(tmp);*/
			
			
			//=================== Above is Old Code & Below is Revised Code =====================//
			
			List<String>				vslSlanPfSkdTpCdList= new ArrayList<String>();
			
			List<PortSkdOnLongRangeVO>	tmpPortSkds			= null;
			
			/** Making Distinct Proforma Service Type **/
			for(int i=0; i<orderedPortSkdOnLongRangeVOs.size(); i++){
				tmpPortSkds	= orderedPortSkdOnLongRangeVOs.get(i);
				
				curVslSlanPfSkd = tmpPortSkds.get(0).getVslSlanCd() +","+ tmpPortSkds.get(0).getPfSkdTpCd(); 

				if("".equals(preVslSlanPfSkd) ){
					vslSlanPfSkdTpCdList.add(curVslSlanPfSkd);

					preVslSlanPfSkd	= curVslSlanPfSkd;
					
				}else{
					
					if(!vslSlanPfSkdTpCdList.contains(curVslSlanPfSkd)){
						vslSlanPfSkdTpCdList.add(curVslSlanPfSkd);
					}
				}
			}

			/** Making Long Range Schedule by Vessel Service Lane + Proforma Type **/
			for(int i=0; i<vslSlanPfSkdTpCdList.size(); i++){
				for(List<PortSkdOnLongRangeVO> tempPortSkds : orderedPortSkdOnLongRangeVOs){
					String[] vslSlanPfSkdTpSplit = vslSlanPfSkdTpCdList.get(i).split(",");
					if(tempPortSkds.get(0).getVslSlanCd().equals(vslSlanPfSkdTpSplit[0]) && tempPortSkds.get(0).getPfSkdTpCd().equals(vslSlanPfSkdTpSplit[1])){
						tmp.add(tempPortSkds);
					}
				}
				
				groupByPfSkdType.add(tmp);
				tmp	= new ArrayList<List<PortSkdOnLongRangeVO>>();
			}
			
			/**==========================================================================
			 * End of sorting by proforma type code
			 * ==========================================================================
			 */
			
			
			// in case grid is more than 10
			// in case of Feeder lane
			// �꾩옱 �곹깭�먯꽌��1000媛��댁긽 �섏삱 ���놁뼱���꾨옒 議곌굔��臾댁“嫄�else議곌굔��2015.02.28
			
			if(groupByPfSkdType.size()>1000){
			////if(false){
				
				List<List<PortSkdOnLongRangeVO>> mergedGrid = new ArrayList<List<PortSkdOnLongRangeVO>>();
				
				for(int i=0; i<groupByPfSkdType.size(); i++){
					adjustAllSkd(groupByPfSkdType.get(i), mergedGrid);
				}

				groupByPfSkdType = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();
				groupByPfSkdType.add(mergedGrid);
				
				List<PfSkdDetailVO> pfSkdDetailVOs = new ArrayList<PfSkdDetailVO>();
				
				for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
					PfSkdDetailVO pfSkdDetailVO 	= new PfSkdDetailVO();
					pfSkdDetailVO.setVslSlanCd		(portSkdVO.getVslSlanCd());
					pfSkdDetailVO.setSkdDirCd		(portSkdVO.getSkdDirCd());
					pfSkdDetailVO.setPortCd			(portSkdVO.getVpsPortCd());
					pfSkdDetailVO.setEtbDyCd		("*");
					pfSkdDetailVO.setEtbTmHrmnt		("*");
					pfSkdDetailVO.setEtdDyCd		("*");
					pfSkdDetailVO.setEtdTmHrmnt		("*");
					pfSkdDetailVO.setClptSeq		(portSkdVO.getClptIndSeq());
					pfSkdDetailVO.setYdCd			(portSkdVO.getYdCd());
					pfSkdDetailVO.setCallYdIndSeq	("");
					
					pfSkdDetailVOs.add				(pfSkdDetailVO);
				}
				
				for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
					if(!portSkdVO.isEmptySkd()){
						pfSkdDetailsByGroup.put(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo(), pfSkdDetailVOs);		
					}
				}
				
			}else{
				
				// Controlling Header and SKD START
				for(int i=0; i<groupByPfSkdType.size(); i++){
					List<List<PortSkdOnLongRangeVO>> samePfGroup = groupByPfSkdType.get(i);
					
					PortSkdOnLongRangeVO vo = samePfGroup.get(0).get(0);
					
					/** old separated login for feeder service **/
					if("FEEDER".equals(vo.getPfSkdTpCd())){
					////if(false){
						
						List<List<PortSkdOnLongRangeVO>> mergedGrid = new ArrayList<List<PortSkdOnLongRangeVO>>();
						adjustAllSkd(samePfGroup, mergedGrid);
						groupByPfSkdType.set(i, mergedGrid);
						
						groupByPfSkdType = new ArrayList<List<List<PortSkdOnLongRangeVO>>>();
						groupByPfSkdType.add(mergedGrid);
						
						List<PfSkdDetailVO> pfSkdDetailVOs = new ArrayList<PfSkdDetailVO>();
						for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
							PfSkdDetailVO pfSkdDetailVO 	= new PfSkdDetailVO();
							pfSkdDetailVO.setVslSlanCd		(portSkdVO.getVslSlanCd());
							pfSkdDetailVO.setSkdDirCd		(portSkdVO.getSkdDirCd());
							pfSkdDetailVO.setPortCd			(portSkdVO.getVpsPortCd());
							pfSkdDetailVO.setEtbDyCd		("*");
							pfSkdDetailVO.setEtbTmHrmnt		("*");
							pfSkdDetailVO.setEtdDyCd		("*");
							pfSkdDetailVO.setEtdTmHrmnt		("*");
							pfSkdDetailVO.setClptSeq		(portSkdVO.getClptIndSeq());
							pfSkdDetailVO.setYdCd			(portSkdVO.getYdCd());
							pfSkdDetailVO.setCallYdIndSeq	("");
							
							pfSkdDetailVOs.add				(pfSkdDetailVO);
						}
						
						for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
							if(!portSkdVO.isEmptySkd()){
								pfSkdDetailsByGroup.put(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo(), pfSkdDetailVOs);
								break;
							}
						}
						
					}else{
						
						
						//:2015-11-20:***************************************************************************//
//						List<List<PortSkdOnLongRangeVO>> mergedGrid = new ArrayList<List<PortSkdOnLongRangeVO>>();
//						adjustAllSkd		(samePfGroup, mergedGrid);
//						groupByPfSkdType.set(i			, mergedGrid);
//						
//						groupByPfSkdType 	= new ArrayList<List<List<PortSkdOnLongRangeVO>>>();
//						groupByPfSkdType.add(mergedGrid);
//						
//						List<PfSkdDetailVO> pfSkdDetailVOs 	= new ArrayList<PfSkdDetailVO>();
//						for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
//							PfSkdDetailVO pfSkdDetailVO 	= new PfSkdDetailVO();
//							pfSkdDetailVO.setVslSlanCd		(portSkdVO.getVslSlanCd());
//							pfSkdDetailVO.setSkdDirCd		(portSkdVO.getSkdDirCd());
//							pfSkdDetailVO.setPortCd			(portSkdVO.getVpsPortCd());
//							pfSkdDetailVO.setEtbDyCd		("*");
//							pfSkdDetailVO.setEtbTmHrmnt		("*");
//							pfSkdDetailVO.setEtdDyCd		("*");
//							pfSkdDetailVO.setEtdTmHrmnt		("*");
//							pfSkdDetailVO.setClptSeq		(portSkdVO.getClptIndSeq());
//							pfSkdDetailVO.setYdCd			(portSkdVO.getYdCd());
//							pfSkdDetailVO.setCallYdIndSeq	("");
//							
//							pfSkdDetailVOs.add				(pfSkdDetailVO);
//						}
//						
//						for(PortSkdOnLongRangeVO portSkdVO : mergedGrid.get(0)){
//							if(!portSkdVO.isEmptySkd()){
//								pfSkdDetailsByGroup.put(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo(), pfSkdDetailVOs);
//								//break;
//							}
//						}
						//:2015-11-20:***************************************************************************//
						
						
						// Arranging SKD by P/F
						groupByPfSkdType.set(i, this.adjustSkd(pfSkdDetails, samePfGroup, pfSkdDetailsByGroup));						
						
					}
				}
			}
			
			longRangeSkdInqGRPVO.setPortSkdVOsByPf		(groupByPfSkdType	);
			longRangeSkdInqGRPVO.setPfSkdDetailsByGroup	(pfSkdDetailsByGroup);
			
			return longRangeSkdInqGRPVO;
			
		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10038").getMessage(), ex);
		}
	}
	

	private void setFirstEtbByPF(String vvdKey, PortSkdOnLongRangeVO portSkdOnLongRangeVO, List<PfSkdDetailVO> pfSkdDetailVOs, Map<String, String> firstEtbByVVD) throws EventException {
		
		PfSkdDetailVO 	firstPfSkd = pfSkdDetailVOs.get(0);
		
		for(PfSkdDetailVO pfSkdDetailVO : pfSkdDetailVOs){
			// Finding P/F which same as Port Skd
			if(pfSkdDetailVO.getSkdDirCd().equals(portSkdOnLongRangeVO.getSkdDirCd()) &&
					pfSkdDetailVO.getPortCd	().equals(portSkdOnLongRangeVO.getVpsPortCd	()) &&
					pfSkdDetailVO.getYdCd	().equals(portSkdOnLongRangeVO.getYdCd		()) &&
					pfSkdDetailVO.getClptSeq().equals(portSkdOnLongRangeVO.getClptIndSeq())){
				
				portSkdOnLongRangeVO.setPfSkdDetailVO(pfSkdDetailVO);
				
				this.setFirstEtb(vvdKey, portSkdOnLongRangeVO.getPfEtbDt(), firstPfSkd, pfSkdDetailVO, firstEtbByVVD);
				break;
			}
		}
	}
	
	private void setFirstEtbByInit(String vvdKey, PortSkdOnLongRangeVO portSkdOnLongRangeVO, List<PfSkdDetailVO> pfSkdDetailVOs, Map<String, String> firstEtbByVVD) throws EventException {
		
		PfSkdDetailVO 		firstPfSkd = pfSkdDetailVOs.get(0);
		
		for(PfSkdDetailVO pfSkdDetailVO : pfSkdDetailVOs){
			// Finding P/F which same as Port Skd
			if(		pfSkdDetailVO.getSkdDirCd	().equals(portSkdOnLongRangeVO.getSkdDirCd	()) 
				&&	pfSkdDetailVO.getPortCd		().equals(portSkdOnLongRangeVO.getVpsPortCd	()) 
				&&	pfSkdDetailVO.getYdCd		().equals(portSkdOnLongRangeVO.getYdCd		()) 
				&&	pfSkdDetailVO.getClptSeq	().equals(portSkdOnLongRangeVO.getClptIndSeq())){
				
				portSkdOnLongRangeVO.setPfSkdDetailVO(pfSkdDetailVO);
				
				setFirstEtb(vvdKey, portSkdOnLongRangeVO.getInitEtbDt(), firstPfSkd, pfSkdDetailVO, firstEtbByVVD);
				break;
			}
		}
	}
	
	private void setFirstEtb(String vvdKey, String etbDt, PfSkdDetailVO firstPfSkd, PfSkdDetailVO pfSkdDetailVO, Map<String, String> firstEtbByVVD) throws EventException {
		
		if("1".equals(pfSkdDetailVO.getPortRotnSeq())){
			firstEtbByVVD.put(vvdKey, VSKGeneralUtil.changeDateFormat(etbDt, "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss"));
		}else{
			String date = VSKGeneralUtil.changeDateFormat(etbDt, "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss").substring(0, 8);
			String genDate = VSKGeneralUtil.getActionDate(date , VSKGeneralUtil.convertNumberByString(firstPfSkd.getEtbDyNo()) - VSKGeneralUtil.convertNumberByString(pfSkdDetailVO.getEtbDyNo())); 
			firstEtbByVVD.put(vvdKey, genDate + firstPfSkd.getEtbTmHrmnt() + "59");
		}
		
	}
	
	/**
	 * Linking 1st Direction and 2nd Direction VVD with Turning
	 * 
	 * @param Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD
	 */
	private void linkTurningVVD(Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD){
		
		String[] vvdKeys = portSkdByVVD.keySet().toArray(new String[portSkdByVVD.size()]);
		
		List<PortSkdOnLongRangeVO> 	portSkds 		= null;
		List<PortSkdOnLongRangeVO> 	targetPortSkds 	= null;
		PortSkdOnLongRangeVO 		tmpPortSkd 		= null;
		String 						turnPortVVD 	= null;
		
		for(int i=0; i<vvdKeys.length; i++){
			
			if(!portSkdByVVD.containsKey(vvdKeys[i])){
				continue;
			}
			
//			if("KOHD0500E".equals(vvdKeys[i])){
//				log.debug("");
//			}
			
			portSkds 		= portSkdByVVD.get(vvdKeys[i]);
			targetPortSkds 	= null;
			
			tmpPortSkd 		= null;
			turnPortVVD 	= null;
			
			for(int k=0; k<portSkds.size(); k++){
				
				if("1".equals(portSkds.get(0).getVslSlanDirSeq())){
					break;
				}
				
				tmpPortSkd = portSkds.get(k);
				
				// Linking 1st Direction and 2nd Direction VVD with Turning
				// Finding 1st VVD through 2nd VVD
				if("2".equals(tmpPortSkd.getVslSlanDirSeq()) && "Y".equals(tmpPortSkd.getTurnPortIndCd())){
					
					//:2015-11-23://turnPortVVD 	= tmpPortSkd.getVslCd() + tmpPortSkd.getTurnSkdVoyNo() + tmpPortSkd.getTurnSkdDirCd();
					turnPortVVD 	= tmpPortSkd.getVslSlanCd() + tmpPortSkd.getPfSkdTpCd() + tmpPortSkd.getVslCd() + tmpPortSkd.getTurnSkdVoyNo() + tmpPortSkd.getTurnSkdDirCd();
					targetPortSkds 	= portSkdByVVD.get(turnPortVVD);
					break;
				}
				
			}
			
			if(turnPortVVD != null && targetPortSkds != null){
				
				// Linking if P/F Schedule Type CDs are same
				//:2015-11-23://if(tmpPortSkd.getPfSkdTpCd().equals(targetPortSkds.get(0).getPfSkdTpCd())){
				if(tmpPortSkd.getVslSlanCd().equals(targetPortSkds.get(0).getVslSlanCd()) && tmpPortSkd.getPfSkdTpCd().equals(targetPortSkds.get(0).getPfSkdTpCd())){
					
					targetPortSkds.addAll	(portSkdByVVD.get(vvdKeys[i]));
					portSkdByVVD.remove		(vvdKeys[i]);
				}
			}
			
		}
	}
	
	/**
	 * Linking same voyage no Direction and 2nd Direction VVD
	 * 
	 * @param Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD
	 */
	private void linkSameVoyageVVD(Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD){
		
		String[] vvdKeys = portSkdByVVD.keySet().toArray(new String[portSkdByVVD.size()]);
		
		List<PortSkdOnLongRangeVO> 	portSkd 	= null;
		PortSkdOnLongRangeVO 		tmpPortSkd 	= null;
		String 						sameVoyVVD 	= null;
		String						firstDirCd 	= null;
		
		for(int i=0; i<vvdKeys.length; i++){
			
			if(!portSkdByVVD.containsKey(vvdKeys[i])){
				continue;
			}
			
			portSkd 	= portSkdByVVD.get(vvdKeys[i]);
			
			sameVoyVVD 	= null;
			tmpPortSkd 	= null;
			firstDirCd 	= null;
			
			for(int k=0; k<portSkd.size(); k++){
				tmpPortSkd = portSkd.get(k);

				if("1".equals(tmpPortSkd.getVslSlanDirSeq())){
					//:2015-11-23://sameVoyVVD = tmpPortSkd.getVslCd() + tmpPortSkd.getSkdVoyNo();
					sameVoyVVD = tmpPortSkd.getVslSlanCd() + tmpPortSkd.getPfSkdTpCd() + tmpPortSkd.getVslCd() + tmpPortSkd.getSkdVoyNo();
					
					firstDirCd = tmpPortSkd.getSkdDirCd();
					if("E".equals(firstDirCd)){
						sameVoyVVD = sameVoyVVD + "W";
					}else if("W".equals(firstDirCd)){
						sameVoyVVD = sameVoyVVD + "E";
					}else if("S".equals(firstDirCd)){
						sameVoyVVD = sameVoyVVD + "N";
					}else if("N".equals(firstDirCd)){
						sameVoyVVD = sameVoyVVD + "S";
					}
					break;
				}

			}
			
			// Linking same voyage no Direction and 2nd Direction VVD
			if(sameVoyVVD!=null && portSkdByVVD.containsKey(sameVoyVVD)){
				
				// Linking if P/F Schedule Type CDs are same
				//:2015-11-23://if(tmpPortSkd.getPfSkdTpCd().equals(portSkdByVVD.get(sameVoyVVD).get(0).getPfSkdTpCd())){
				if(tmpPortSkd.getVslSlanCd().equals(portSkdByVVD.get(sameVoyVVD).get(0).getVslSlanCd()) && tmpPortSkd.getPfSkdTpCd().equals(portSkdByVVD.get(sameVoyVVD).get(0).getPfSkdTpCd())){
					portSkd.addAll		(portSkdByVVD.get(sameVoyVVD));
					portSkdByVVD.remove	(sameVoyVVD);	
				}
			}
			
		}
	}
	
	private List<List<PortSkdOnLongRangeVO>> sortPortSkd(Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD, Map<String, String> firstEtbByVVD) throws EventException {
		
		// Comparing other vvd with one vvd
		
		String[] 	vvdKeys 	= portSkdByVVD.keySet().toArray(new String[portSkdByVVD.size()]);
		String 		tmpVVD 		= null;
		int 		compare 	= 0;
		
		for(int i=0; i<vvdKeys.length; i++){
			for(int m=0; m<vvdKeys.length; m++){
				compare = 0;
				
				if(i==m){
					continue;
				}else if(i<m){
					compare = compareVVD(vvdKeys[i], vvdKeys[m], firstEtbByVVD.get(vvdKeys[i]), firstEtbByVVD.get(vvdKeys[m]), portSkdByVVD);	
				}else if(i>m){
					compare = compareVVD(vvdKeys[m], vvdKeys[i], firstEtbByVVD.get(vvdKeys[m]), firstEtbByVVD.get(vvdKeys[i]), portSkdByVVD);
				}
				
				// yVVDKeys[m] is next skd, compare < 0 ==> normal
				// xVVDKeys[i] > yVVDKeys[m]. i.e., xVVDKeys[i] is next skd, compare > 0  ==> change order
				if(compare>0){
					tmpVVD = vvdKeys[i];
					vvdKeys[i] = vvdKeys[m];
					vvdKeys[m] = tmpVVD;
				}
			}
		}
		
		// Setting Port Schedule list with arranged VVD
		List<List<PortSkdOnLongRangeVO>> sortedPortList = new ArrayList<List<PortSkdOnLongRangeVO>>();
		for(int i=0; i<vvdKeys.length; i++){
			sortedPortList.add(portSkdByVVD.get(vvdKeys[i]));
		}
		
		Collections.sort(sortedPortList, new Comparator<List<PortSkdOnLongRangeVO>>()
		{
			public int compare(List<PortSkdOnLongRangeVO> o1, List<PortSkdOnLongRangeVO> o2)
			{
				return new CompareToBuilder().append(o1.get(0).getVpsEtbDt(), o2.get(0).getVpsEtbDt())
											 .append(o1.get(0).getCreDt(), o2.get(0).getCreDt())
											 .toComparison();
			}
		});
		
		return sortedPortList;		
	}
	
	private int compareVVD(String vvd1, String vvd2, String etb1, String etb2, Map<String, List<PortSkdOnLongRangeVO>> portSkdByVVD) throws EventException {
		List<PortSkdOnLongRangeVO> portSkd1 = portSkdByVVD.get(vvd1);
		List<PortSkdOnLongRangeVO> portSkd2 = portSkdByVVD.get(vvd2);
		
		int compare = 0;
		boolean findSamePort = false;
		PortSkdOnLongRangeVO skdVO1 = null;
		PortSkdOnLongRangeVO skdVO2 = null;
		
		// VVD1 is previous, return -1
		// VVD1 and VVD2 are same, return 0
		// VVD1 is later, return 1
		
		for(int i=0; i<portSkd1.size(); i++){
			skdVO1 = portSkd1.get(i);
			for(int m=0; m<portSkd2.size(); m++){
				skdVO2 = portSkd2.get(m);
				if(skdVO1.isSamePort(skdVO2)){
					findSamePort = true;
					break;
				}
			}
			
			if(findSamePort){
				break;
			}
			
		}
		
		if(findSamePort){
			// Comparing VPS_ETB_DT
			compare = VSKGeneralUtil.compareSkdDate(skdVO1.getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss", skdVO2.getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss");
		}else{
			
			// if VSL_CD, SKD_VOY_NO are same
			// Setting 1st Direction VVD previous
			if(		skdVO1	!= null
				&&	skdVO2	!= null
				&&	skdVO1.getVslCd		().equals(skdVO2.getVslCd()) 
				&&	skdVO1.getSkdVoyNo	().equals(skdVO2.getSkdVoyNo())
			){
				compare = VSKGeneralUtil.compareSkdDate(portSkd1.get(0).getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss", portSkd2.get(0).getVpsEtbDt(), "yyyy-MM-dd HH:mm:ss");
			}else{
				compare = VSKGeneralUtil.compareSkdDate(etb1, "yyyyMMddHHmmss", etb2, "yyyyMMddHHmmss");
			}
		}
		
		return compare;
		
	}
	
	/**
	 * Reflecting srcGrid to tgtGrid
	 * in case Direction Code, Port Code, Yard Code from tgtGrid are same
	 * 
	 * @param List<List<PortSkdOnLongRangeVO>> srcVVDs
	 * @param List<List<PortSkdOnLongRangeVO>> tgtVVDs
	 * @return List<List<PortSkdOnLongRangeVO>>
	 */
	private List<List<PortSkdOnLongRangeVO>> adjustAllSkd(List<List<PortSkdOnLongRangeVO>> srcVVDs, List<List<PortSkdOnLongRangeVO>> tgtVVDs){
		
		List<PortSkdOnLongRangeVO> tmp 			= null;
		List<PortSkdOnLongRangeVO> emptyList 	= null;
		List<PortSkdOnLongRangeVO> newVVD 		= null;
		
		if(tgtVVDs.size()<0){
			tgtVVDs.addAll(srcVVDs);
		}else{
			
			for(List<PortSkdOnLongRangeVO> portSkdVOs : srcVVDs){
				
				if(tgtVVDs.size()==0){
					tgtVVDs.add(srcVVDs.get(0));
					continue;
				}
				
				tmp = new ArrayList<PortSkdOnLongRangeVO>();
				emptyList = new ArrayList<PortSkdOnLongRangeVO>();
				
				newVVD = new ArrayList<PortSkdOnLongRangeVO>();
				
				for(PortSkdOnLongRangeVO portSkdVO : tgtVVDs.get(0)){
				
					PortSkdOnLongRangeVO empty 	= new PortSkdOnLongRangeVO();
					
					empty.setVslSlanCd			(portSkdVO.getVslSlanCd());
					empty.setPfSkdTpCd			(portSkdVO.getPfSkdTpCd());
					empty.setSkdDirCd			(portSkdVO.getSkdDirCd());
					empty.setVpsPortCd			(portSkdVO.getVpsPortCd());
					empty.setClptIndSeq			(portSkdVO.getClptIndSeq());
					empty.setYdCd				(portSkdVO.getYdCd());
					empty.setCallYdIndSeq		(portSkdVO.getCallYdIndSeq());
					empty.setClptSeq			(portSkdVO.getClptSeq());
					empty.setEmptySkd			(true);
					
					newVVD.add					(empty);
				}
				
				// Finding 2nd Direction position
				int startPos2nd = find2ndStartPos(tgtVVDs.get(0));
								
				String currentDir = null;
				boolean changeDir = false;
				
				for(PortSkdOnLongRangeVO portSkdVO : portSkdVOs){
					
					if(currentDir!=null && !currentDir.equals(portSkdVO.getSkdDirCd())){
						currentDir = portSkdVO.getSkdDirCd();
						changeDir = true;
					}else{
						currentDir = portSkdVO.getSkdDirCd();
						changeDir = false;
					}

					if(tmp.size()>0 && changeDir){

						if(startPos2nd>-1){
							newVVD.addAll(startPos2nd, tmp);
							for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
								otherVVD.addAll(startPos2nd, emptyList);
							}
						}else{
							newVVD.addAll(tmp);
							for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
								otherVVD.addAll(emptyList);
							}
						}
						
						tmp = new ArrayList<PortSkdOnLongRangeVO>();
						emptyList = new ArrayList<PortSkdOnLongRangeVO>();
					}
					
					
					int tgtPos = findTargetPos(tgtVVDs.get(0), portSkdVO);
					
					if(tgtPos==-1 || !newVVD.get(tgtPos).isEmptySkd()){
						
						// adding info to VVD
						tmp.add(portSkdVO);
						
						// adding info to other VVD
						PortSkdOnLongRangeVO empty 	= new PortSkdOnLongRangeVO();
					
						empty.setVslSlanCd			(portSkdVO.getVslSlanCd());
						empty.setPfSkdTpCd			(portSkdVO.getPfSkdTpCd());
						empty.setSkdDirCd			(portSkdVO.getSkdDirCd());
						empty.setVpsPortCd			(portSkdVO.getVpsPortCd());
						empty.setClptIndSeq			(portSkdVO.getClptIndSeq());
						empty.setYdCd				(portSkdVO.getYdCd());
						empty.setCallYdIndSeq		(portSkdVO.getCallYdIndSeq());
						empty.setClptSeq			(portSkdVO.getClptSeq());
						empty.setEmptySkd			(true);
						
						emptyList.add				(empty);
						
						continue;
						
					}else{
						
						// Setting Port info to VVD
						newVVD.set(tgtPos, portSkdVO);
						
						if(tmp.size()>0){
							
							newVVD.addAll(tgtPos, tmp);
							for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
								otherVVD.addAll(tgtPos, emptyList);
							}
							
							tmp = new ArrayList<PortSkdOnLongRangeVO>();
							emptyList = new ArrayList<PortSkdOnLongRangeVO>();
						}
					}
				}
				
				// Setting at last point of each Direction
				if(tmp.size()>0){
					newVVD.addAll(tmp);
					for(List<PortSkdOnLongRangeVO> otherVVD : tgtVVDs){
						otherVVD.addAll(emptyList);
					}
				}
				
				// Adding new VVD
				tgtVVDs.add(newVVD);
			}
			// grouoping direction. ex) W, E, W, E -> W | E
			if(tgtVVDs.size()>0){
				sortSkdByDir(tgtVVDs);
			}
		}
		return null;
	}
	
	/**
	 * Arranging several VVDs with Direction
	 * 
	 * @param List<List<PortSkdOnLongRangeVO>> tgtVVDs
	 */
	private void sortSkdByDir(List<List<PortSkdOnLongRangeVO>> tgtVVDs){
		boolean finish = false;
		while(!finish){
			List<PortSkdOnLongRangeVO> firstVVDSkd = tgtVVDs.get(0);
			// 1st direction of tgtVVD
			String firstSkdDirCd = firstVVDSkd.get(0).getSkdDirCd();
			int lastPos1stDir = 0;
			int pos2stDir = 0;
			
			PortSkdOnLongRangeVO portSkdOnLongRangeVO = null;
			String skdDirCd = null;
			for(int i=0; i<firstVVDSkd.size(); i++){
				portSkdOnLongRangeVO = firstVVDSkd.get(i);
				skdDirCd = portSkdOnLongRangeVO.getSkdDirCd();
				
				if(pos2stDir>0 && firstSkdDirCd.equals(skdDirCd)){
					control(tgtVVDs, pos2stDir, i);
					break;
				}
				
				if(firstSkdDirCd.equals(skdDirCd)){
					lastPos1stDir = i;
					continue;
				}else{
					pos2stDir = i;
					continue;
				}
			}
			
			if(lastPos1stDir==firstVVDSkd.size()-1 || pos2stDir==firstVVDSkd.size()-1){
				finish = true;
			}
		}
	}
	
	/**
	 * Change Port SKD of srcPos to tgtPos
	 * 
	 * @param List<List<PortSkdOnLongRangeVO>> tgtVVDs
	 * @param int tgtPos
	 * @param int srcPos
	 */
	private void control(List<List<PortSkdOnLongRangeVO>> tgtVVDs, int tgtPos, int srcPos){
		for(List<PortSkdOnLongRangeVO> vvdSkd : tgtVVDs){
			PortSkdOnLongRangeVO tmpVO = vvdSkd.get(srcPos);
			vvdSkd.remove(srcPos);
			vvdSkd.add(tgtPos, tmpVO);
		}
	}
	
	
	private int findTargetPos(List<PortSkdOnLongRangeVO> tgtVVD, PortSkdOnLongRangeVO srcVO){
		boolean find = false;
		int tgtPos = 0;
		for(PortSkdOnLongRangeVO tgtVO : tgtVVD){
			if(tgtVO.getSkdDirCd().equals(srcVO.getSkdDirCd()) &&
					tgtVO.getVpsPortCd().equals(srcVO.getVpsPortCd()) &&
					tgtVO.getYdCd().equals(srcVO.getYdCd()) &&
					tgtVO.getClptIndSeq().equals(srcVO.getClptIndSeq())
					){
				find = true;
				break;
			}
			tgtPos++;
		}
		if(find){
			return tgtPos;
		}else{
			return -1;
		}
	}
	
	private int find2ndStartPos(List<PortSkdOnLongRangeVO> portSkdVOs){
		int pos = 0;
		boolean find = false;
		for(PortSkdOnLongRangeVO vo : portSkdVOs){
			if("2".equals(vo.getVslSlanDirSeq())){
				find = true;
				break;
			}
			pos++;
		}
		if(find){
			return pos;
		}else{
			return -1;
		}
	}
	
	/**
	 * Setting PortSkd with P/F
	 * 
	 * @param Map<String, List<PfSkdDetailVO>> pfSkdDetails
	 * @param List<List<PortSkdOnLongRangeVO>> portSkdVOBySamePf
	 * @param Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup
	 * @return List<List<PortSkdOnLongRangeVO>>
	 */
	private List<List<PortSkdOnLongRangeVO>> adjustSkd(Map<String, List<PfSkdDetailVO>> pfSkdDetails, List<List<PortSkdOnLongRangeVO>> portSkdVOBySamePf, Map<String, List<PfSkdDetailVO>> pfSkdDetailsByGroup) throws EventException {

		List<PortSkdOnLongRangeVO> 	addingPortList 			= new ArrayList<PortSkdOnLongRangeVO>();
		PortSkdOnLongRangeVO 		vo 						= null;

		Collections.sort(portSkdVOBySamePf, new Comparator<List<PortSkdOnLongRangeVO>>()
		{
			public int compare(List<PortSkdOnLongRangeVO> o1, List<PortSkdOnLongRangeVO> o2)
			{
				return new CompareToBuilder().append(o1.get(0).getVpsEtbDt(), o2.get(0).getVpsEtbDt())
											 .append(o1.get(0).getCreDt(), o2.get(0).getCreDt())
											 .toComparison();
			}
		});
		
		// P/F �뺣낫瑜�援ы븳��
		vo 													= portSkdVOBySamePf.get(0).get(0);
		String 				pfSkdKey 						= vo.getVslSlanCd() + vo.getPfSkdTpCd();
		String 				pfSkdKeyByGroup 				= pfSkdKey + vo.getVslCd() + vo.getSkdVoyNo();
		List<PfSkdDetailVO> pfSkdDetailVOs 					= pfSkdDetails.get(pfSkdKey);
		List<PfSkdDetailVO> pfSkdDetailVOsByGroup 			= new ArrayList<PfSkdDetailVO>(pfSkdDetails.get(pfSkdKey));

		PortSkdOnLongRangeVO[] tmpPortSkdArr 				= null;
		List<List<PortSkdOnLongRangeVO>> tmpPortSkdGridData = new ArrayList<List<PortSkdOnLongRangeVO>>();

		// Adding Port瑜��쒖쇅�섎㈃ 紐⑤뱺 Port Skd��P/F �곸쓽 �대뼡 �ы듃���쇱튂�쒕떎.
		// 洹몃윭誘�줈, 1李⑥쟻�쇰줈 Adding Port �ㅼ�伊댁쓣 �쒖쇅���섎㉧吏��ㅼ�伊댁쓣 P/F瑜��댁슜�섏뿬 諛곗튂�섍퀬
		// �⑥븘�덈뒗 Adding Port瑜��곸젅�섍쾶 �쇱썙�ｋ뒗��

		try{
			
			for(List<PortSkdOnLongRangeVO> portSkdVOs : portSkdVOBySamePf){

				tmpPortSkdArr 		= this.initSkdByPf	(pfSkdDetailVOs);

				int addPortCount 	= 0;

				for(int i=0; i<portSkdVOs.size(); i++){
					vo = portSkdVOs.get(i);

					//if("A".equals(vo.getSkdCngStsCd()) || "".equals(vo.getPfEtaDt())){
					// PF Estimate Time ���놁쑝硫�Adding Calling�쇰줈 媛꾩＜.
					// SKD_CNG_STS_CD 肄붾뱶�먯꽌 "A"���좊ː�깆씠 �⑥뼱吏�
					
					//if(!"".equals(vo.getPfEtbDt())){
					if("".equals(vo.getPfEtbDt())){
						addPortCount++;
						
						vo.setAddingSkd		(true);
						addingPortList.add	(vo);
						//continue;
						
					}else{

						// 異붽�(2010.02.19)
						// PF Estimate Time ���덈뒗 寃쎌슦��諛쒖깮�� 利��곗씠���곸쑝濡쒕뒗 Add Calling �몄� �뺤씤�����녿뒗 寃쎌슦媛�議댁옱��
						// PF��Port��Yard瑜�議곗궗�섏뿬 洹��꾩튂媛믪쓣 李얠쓣 ���녿뒗 寃쎌슦 Add Calling�쇰줈 �몄떇�쒕떎.
						int idx = this.getHeaderIdx(pfSkdDetailVOs, vo);
						if(idx != -1){
							tmpPortSkdArr[idx] = vo;
						}else{

							// Final Port媛��꾨땶 寃쎌슦���쇰컲�곸씤 Add Calling�쇰줈 �몄떇�쒕떎.
							if(!"F".equals(vo.getTurnPortIndCd())){
								vo.setAddingSkd		(true);
								addingPortList.add	(vo);
							}else{

								// Final Port濡��먮퀎��寃쎌슦 ==> Final Port �욎뿉 �숈씪��Port, Yard濡�Add call port瑜��댁꽌, Final Port �뺣낫��CLPT_IND_SEQ媛�利앷�. 寃곌뎅 PF ��쓽 �쇱튂 �뺣낫瑜�李얠쓣 ���녾쾶�섏뼱 踰꾨┛ 寃쎌슦
								//
								// tmpPortSkdArr[] 諛곗뿴(PF ���쇱튂�섎뒗 �뺣낫 諛곗뿴)�먯꽌 �숈씪��Port, Yard瑜�媛�����뺣낫以�媛�옣 留덉�留���긽��李얠븘��Final Port �뺣낫��援먰솚 �쒕떎.

								int pos = -1;
								for(int m=tmpPortSkdArr.length-1; m>=0; m--){
									if(
											vo.getSkdDirCd().equals		(tmpPortSkdArr[m].getSkdDirCd		()) 	
										&&	vo.getVpsPortCd().equals	(tmpPortSkdArr[m].getVpsPortCd		()) 	
										
										//:2015-08-04:by TOP://
										////by TOP////
										&&	vo.getClptIndSeq().equals	(tmpPortSkdArr[m].getClptIndSeq		()) 
										
										&&	vo.getYdCd().equals			(tmpPortSkdArr[m].getYdCd			())	
										
										////by TOP////
										&&	vo.getCallYdIndSeq().equals	(tmpPortSkdArr[m].getCallYdIndSeq	()) // CHM-201108759-01 // Long Range Inquiry �붾㈃�먯꽌 議고쉶��VVD��媛숈� Yard(double calling)����빐 援щ텇�섎룄濡�蹂�꼍
									
										//:2015-09-19:by TOP://
										&&	vo.getVslSlanCd().equals	(tmpPortSkdArr[m].getVslSlanCd		())
										&&	vo.getPfSkdTpCd().equals	(tmpPortSkdArr[m].getPfSkdTpCd		())
									){
										pos = m;
										break;
									}
								}

								if(pos != -1){
									// ��긽��李얠쑝硫�援먰솚
									tmpPortSkdArr[pos].setAddingSkd(true);
									addingPortList.add	(tmpPortSkdArr[pos]);
									tmpPortSkdArr[pos] 	= vo;
								}else{
									// ��긽��紐살갼�쇰㈃ �곗씠�곗뿉 �댁긽���덈뒗 寃껋엫.
									// �쇰떒 Add Calling�쇰줈 泥섎━�섍퀬 �곗씠�곕� �뺤씤��蹂댁븘����
									vo.setAddingSkd		(true);
									addingPortList.add	(vo);
								}
								
							}
						}
					}
				}

				
				// tmpPortSkdArr���쇰컲�곸씤 �ы듃 �ㅼ�以꾩씠 �녿뒗 寃쎌슦(Adding Port濡쒕쭔 援ъ꽦��VVD)
				// tmpPortSkdGridData��VVD�뺣낫留��덈뒗 鍮��ㅼ�以꾩쓣 異붽��쒕떎.
				boolean isEmptyVVD 				= true;
				for(int i=0; i<tmpPortSkdArr.length; i++){
					PortSkdOnLongRangeVO tmpVo 	= tmpPortSkdArr[i];
					if(!tmpVo.isEmptySkd()){
						isEmptyVVD 				= false;
						break;
					}
				}

				if(isEmptyVVD){
					tmpPortSkdArr[0].setVslCd							(portSkdVOs.get(0).getVslCd		());
					tmpPortSkdArr[0].setSkdVoyNo						(portSkdVOs.get(0).getSkdVoyNo	());
					tmpPortSkdArr[0].setSkdDirCd						(portSkdVOs.get(0).getSkdDirCd	());

					tmpPortSkdArr[tmpPortSkdArr.length-1].setVslCd		(portSkdVOs.get(portSkdVOs.size()-1).getVslCd	());
					tmpPortSkdArr[tmpPortSkdArr.length-1].setSkdVoyNo	(portSkdVOs.get(portSkdVOs.size()-1).getSkdVoyNo());
					tmpPortSkdArr[tmpPortSkdArr.length-1].setSkdDirCd	(portSkdVOs.get(portSkdVOs.size()-1).getSkdDirCd());
				}

				tmpPortSkdGridData.add	(Arrays.asList(tmpPortSkdArr));
			}
			
		}catch(Exception e){
			String sTmpErrMsg	= vo.getVslCd()==null?"":vo.getVslCd() + vo.getSkdVoyNo()==null?"":vo.getSkdVoyNo() + vo.getSkdDirCd()==null?"":vo.getSkdDirCd() + " Schedule (System Exception)";
			throw new EventException(new ErrorHandler("COM12114", new String[]{sTmpErrMsg}).getMessage(), e);
		}

		// Adding Port媛��녿떎硫�湲곕낯 P/F���숈씪��寃껋엫.
		pfSkdDetailsByGroup.put	(pfSkdKeyByGroup, pfSkdDetailVOsByGroup);

		// Adding Port �뺣낫瑜�異붽��쒕떎.
		// 1. �대뼡 VVD�몄� �앸퀎
		// 2. CLPT_SEQ瑜��댁슜�섏뿬 VVD�곸쓽 �꾩튂 �앸퀎
		// 3. �대떦 �꾩튂���덈뒗 �ㅻⅨ VVD �곸쓽 Port �뺣낫�� �쒓컙 �꾪썑 愿�퀎瑜�怨좊젮�섏뿬 理쒖쥌 �꾩튂 �좎젙
		// 4. �대떦 VVD��Adding Port �뺣낫瑜�異붽��섍퀬, �ㅻⅨ VVD���대떦 �꾩튂�먮뒗 鍮��ㅼ�伊댁쓣 異붽��쒕떎.

		List<String> tmpYdCdList = new ArrayList<String>();
		boolean tmpYdCdProc = true;
		boolean adjustSkdSwapProc = false;
		int ydCdDirCnt=0;
		
		for(int i=0; i<addingPortList.size(); i++){
			for(int k=i; k<addingPortList.size(); k++){
				if(addingPortList.get(i).getYdCd().equals(addingPortList.get(k).getYdCd()) &&
						addingPortList.get(i).getSkdDirCd().equals(addingPortList.get(k).getSkdDirCd()) && 
                        addingPortList.get(0).getSkdDirCd().equals(addingPortList.get(k).getSkdDirCd()) && 
						!addingPortList.get(i).getClptSeq().equals(addingPortList.get(k).getClptSeq()))
				{
					ydCdDirCnt++;
					break;
				}
			}
			if(ydCdDirCnt > 0){
				break;
			}
		}
		
		for(int i=0; i<addingPortList.size(); i++){
			
			PortSkdOnLongRangeVO addPortVO 	= addingPortList.get(i);
			int 	iPositionOnVVD 			= 0;
			int 	iCurPortClptSeq 		= 0;
			boolean isFindVvdPosition 		= false;

			PortSkdOnLongRangeVO first 		= null;
			PortSkdOnLongRangeVO last 		= null;
			
			if(addPortVO.isEmptySkd()){
				continue;
			}

			// find iPositionOnVVD
			for(List<PortSkdOnLongRangeVO> portSkdVOs : tmpPortSkdGridData){
						
				first 	= this.findFirstSkd	(portSkdVOs);
				last 	= this.findLastSkd	(portSkdVOs);
				
				// first, last媛�null ��寃쎌슦���대떦 vvd��Adding Port媛��꾨땶 �쇰컲�곸씤 �ㅼ�以꾩쓣 �녿뒗 �곹솴�대�濡�Adding Port媛��쒖씪 癒쇱� �깅줉�섎뒗 寃쎌슦��
				if(first==null && last==null){
					first 	= addPortVO;
					last 	= addPortVO;
				}
				
				if(		(	addPortVO.getVslCd().equals(first.getVslCd	())	&& addPortVO.getSkdVoyNo().equals(first.getSkdVoyNo		())	) 
					||	(	addPortVO.getVslCd().equals(last.getVslCd	()) && addPortVO.getSkdVoyNo().equals(last.getSkdVoyNo		())	) 
						
					||	(	addPortVO.getVslCd().equals(first.getVslCd	()) && addPortVO.getSkdVoyNo().equals(first.getTurnSkdVoyNo	()	) 
							&&	
							("Y".equals(first.getTurnPortIndCd()) || "N".equals(first.getTurnPortIndCd())	)							
						)
						
						/** Adding Statement for Identifying proper position of specific SKD :: 2015-09-26 :: by TOP **/
//					||	(	addPortVO.getVslCd().equals(first.getVslCd	()) && addPortVO.getTurnSkdVoyNo().equals(first.getSkdVoyNo	()	) 
//							&&	
//							("Y".equals(first.getTurnPortIndCd()) || "N".equals(first.getTurnPortIndCd())	)							
//						)		
						/**********************************************************************************************/
				){
					isFindVvdPosition = true;
					break;
				}
				
				iPositionOnVVD++;
			}

			if(!isFindVvdPosition){
				int 	tmpPoCnt    			= 0;
				for(List<PortSkdOnLongRangeVO> portSkdVOs : tmpPortSkdGridData){
					first 	= this.findFirstSkd	(portSkdVOs);
					last 	= this.findLastSkd	(portSkdVOs);
					
					// first, last媛�null ��寃쎌슦���대떦 vvd��Adding Port媛��꾨땶 �쇰컲�곸씤 �ㅼ�以꾩쓣 �녿뒗 �곹솴�대�濡�Adding Port媛��쒖씪 癒쇱� �깅줉�섎뒗 寃쎌슦��
					if(first==null && last==null){
						first 	= addPortVO;
						last 	= addPortVO;
					}
					
					if(	addPortVO.getVslCd().equals(first.getVslCd	()) && addPortVO.getTurnSkdVoyNo().equals(first.getSkdVoyNo	()	) 
						&&	
						("Y".equals(first.getTurnPortIndCd()) || "N".equals(first.getTurnPortIndCd())	)							
					){
						if(tmpPoCnt==0){
							iPositionOnVVD = 1;
						}else{
							iPositionOnVVD = tmpPoCnt;
						}
						isFindVvdPosition = true;
						break;						
					 }
					
				 	tmpPoCnt++;
				}
				if(!isFindVvdPosition){
					throw new EventException(new ErrorHandler("COM12114", new String[]{" <"+addPortVO.getVslCd() + addPortVO.getSkdVoyNo() + addPortVO.getSkdDirCd() + "> Schedule"}).getMessage());	
				}
			}
			
			List<PortSkdOnLongRangeVO> targetVVD 	= tmpPortSkdGridData.get(iPositionOnVVD			);
			int addPortClptSeq 						= Integer.parseInt		(addPortVO.getClptSeq()	);

			// find iCurPortClptSeq
			// Adding Port��CLPT_SEQ 蹂대떎 �묒� 寃껊뱾以�媛�옣 ��Port��洹몃━���곸쓽 而щ읆 �꾩튂媛믩� 李얜뒗 怨쇱젙
			// Adding Port��CLPT_SEQ�먯꽌 1��鍮쇱꽌 �ъ슜�섏� �딅뒗 �댁쑀��
			// Adding Port媛��곗냽�섏뼱 �덈뒗 寃쎌슦媛��덇린 �뚮Ц�대떎.
			boolean isFindAddPortPosition 	= false;
			int 	iAddPortNewClptSeq 		= 0;
			
			for(int prePortClptSeq = addPortClptSeq-1; prePortClptSeq>0; prePortClptSeq--){
				iAddPortNewClptSeq 			= 0;

				for(PortSkdOnLongRangeVO prePort : targetVVD){
					
					if	(		prePort.getVslSlanCd	().equals	(addPortVO.getVslSlanCd			()	)
							&&	prePort.getPfSkdTpCd	().equals	(addPortVO.getPfSkdTpCd			()	)
							
							&&	prePort.getSkdDirCd		().equals	(addPortVO.getSkdDirCd			()	) 
							&&	prePort.getClptSeq		().equals	(Integer.toString(prePortClptSeq)	)
							
							//::2015-09-21:by TOP:://
							//-----------&&	prePort.getVslCd		().equals	(addPortVO.getVslCd				()	)
							
							//&&	prePort.getVpsPortCd	().equals	(addPortVO.getVpsPortCd			())
							
							//&&	prePort.getYdCd			().equals	(addPortVO.getYdCd				())
							//&&	prePort.getCallYdIndSeq	().equals	(addPortVO.getCallYdIndSeq		())
							
						){
						
						isFindAddPortPosition = true;
						break;
					}
					
					iAddPortNewClptSeq++;
				}
				
				if(isFindAddPortPosition){
					break;
				}
			}
			
			// isFindAddPortPosition媛�false �대㈃ Adding Port媛�留��욎뿉 �덈떎��留먯씠 ��
			// 留⑥븵��異붽��섎뒗 寃쎌슦. 媛�Direction 蹂�泥섏쓬 �꾩튂瑜�李얜뒗��
			if(!isFindAddPortPosition){
				for(int m=0; m<targetVVD.size(); m++){
					if(addPortVO.getSkdDirCd().equals(targetVVD.get(m).getSkdDirCd())){
						if(m==0 && !pfSkdDetailVOs.get(0).getSkdDirCd().equals(addPortVO.getSkdDirCd())){
							continue;
						}else{
							iAddPortNewClptSeq = m - 1;
							break;
						}

					}
				}
			}
			
			iCurPortClptSeq = iAddPortNewClptSeq + 1;
			
			//if(iCurPortClptSeq < Integer.parseInt(addPortVO.getClptSeq()))	iCurPortClptSeq	= Integer.parseInt(addPortVO.getClptSeq());	//:2015-09-27:01:34:by TOP://
			
			// targetVVD��iPositionOnVVD, iCurPortClptSeq+1 �꾩튂遺�꽣 Adding Port媛��꾨땺�뚭퉴吏�寃�깋�쒕떎.(�ㅻⅨ Adding��Port媛��덉쓣 寃쎌슦)
			// Adding Port媛��놁쑝硫�iPositionOnVVD, iCurPortClptSeq+1 �꾩튂���쎌엯�쒕떎.
			// 湲곗〈 Adding Port媛��덉쑝硫�異붽��좊젮��Port(Yard)���숈씪�쒖� �뺤씤�섏뿬 �숈씪��寃쎌슦 �대떦 �꾩튂���ㅼ�伊��뺣낫瑜��낅뜲�댄듃�쒕떎.(�ㅼ�伊댁씠 �녿뒗 鍮덇났媛꾩씪寃껋엫)
			
			
			boolean isTobeAddedPortOnGrid = true;
			
			
			for(int m=iCurPortClptSeq; m<targetVVD.size(); m++){
				
				PortSkdOnLongRangeVO tmp = targetVVD.get(m);
				
				////::2015-09-22:by TOP::////if(tmp.isEmptySkd()){
				if(!tmp.isAddingSkd()){
						
					
					
					//////////////////////////////////////////////////////////////////////////
					//////////////////////////////////////////////////////////////////////////
					
					
					
					/** �숈씪 add calling port �멸� : Merging for same port+terminal in case of actual port **/
					if(		
							//:2015-09-19:by TOP://
							tmp.getVslSlanCd().equals	(addPortVO.getVslSlanCd		())
						&&	tmp.getPfSkdTpCd().equals	(addPortVO.getPfSkdTpCd		())
							
						&&	tmp.getSkdDirCd	().equals	(addPortVO.getSkdDirCd		()) 
						&&	tmp.getVpsPortCd().equals	(addPortVO.getVpsPortCd		()) 
						&&	tmp.getYdCd		().equals	(addPortVO.getYdCd			())
						&&	tmp.getCallYdIndSeq().equals(addPortVO.getCallYdIndSeq	())
						//:2015-09-30:by TOP://
						//&&	tmp.getClptIndSeq().equals	(addPortVO.getClptIndSeq	()) 
						//&&	tmp.getCallYdIndSeq().equals(addPortVO.getCallYdIndSeq	())
					)
					{
						
						isTobeAddedPortOnGrid 			= false;
						tmpPortSkdGridData.get			(iPositionOnVVD).set(m, addPortVO);
						break;
					}
					
					
					//////////////////////////////////////////////////////////////////////////
					//////////////////////////////////////////////////////////////////////////
					
					
					if(m == 0 && ydCdDirCnt > 0 && "1".equals(addPortVO.getExclAddClptIndSeq()) && addPortVO.getPfEtbDt() != null && !"".equals(addPortVO.getPfEtbDt())){
						isTobeAddedPortOnGrid 			= true;
						break;
					}
					
					
					/** �숈씪 add calling port �멸� : Merging for same port+terminal in case of actual port **/
					/** The below logic is moved to the beginning of this statment by TOP at August 29, 2016 **/
					////if(		
					////		//:2015-09-19:by TOP://
					////		tmp.getVslSlanCd().equals	(addPortVO.getVslSlanCd		())
					////	&&	tmp.getPfSkdTpCd().equals	(addPortVO.getPfSkdTpCd		())
					////		
					////	&&	tmp.getSkdDirCd	().equals	(addPortVO.getSkdDirCd		()) 
					////	&&	tmp.getVpsPortCd().equals	(addPortVO.getVpsPortCd		()) 
					////	&&	tmp.getYdCd		().equals	(addPortVO.getYdCd			())
					////	&&	tmp.getCallYdIndSeq().equals(addPortVO.getCallYdIndSeq	())
					////	//:2015-09-30:by TOP://
					////	//&&	tmp.getClptIndSeq().equals	(addPortVO.getClptIndSeq	()) 
					////	//&&	tmp.getCallYdIndSeq().equals(addPortVO.getCallYdIndSeq	())
					////)
					////{
					////	
					////	isTobeAddedPortOnGrid 			= false;
					////	tmpPortSkdGridData.get			(iPositionOnVVD).set(m, addPortVO);
					////	break;
					////}
					
				}
				
			}

			/** Setup add calling port or terminal change port and so on **/
			// �덈줈��adding port 異붽� ==> 洹몃━�쒖뿉��Column��異붽��섎뒗 �곹솴
			if(isTobeAddedPortOnGrid){
				adjustSkdSwapProc = true;
				if(!tmpYdCdList.contains(addPortVO.getYdCd())){
					tmpYdCdList.add(addPortVO.getYdCd());
				}else{
					//if(tmpYdCdProc &&  "1".equals(addPortVO.getCallYdIndSeq()) && iCurPortClptSeq != 1 && !Integer.toString(addingPortList.size()).equals(addPortVO.getClptSeq()) ){
					if(tmpYdCdProc &&  "1".equals(addPortVO.getCallYdIndSeq()) && iCurPortClptSeq != 1 && !Integer.toString(iCurPortClptSeq).equals(addPortVO.getClptSeq()) ){
						iCurPortClptSeq++;
						tmpYdCdProc = false;
					}else{
						
						for(int m=0; m<portSkdVOBySamePf.get(iPositionOnVVD).size(); m++){
							
							PortSkdOnLongRangeVO	portSkdOnLongRangeVO = portSkdVOBySamePf.get(iPositionOnVVD).get(m);
							if(portSkdOnLongRangeVO.getYdCd().equals(addPortVO.getYdCd()) && portSkdOnLongRangeVO.getSkdDirCd().equals(addPortVO.getSkdDirCd())){
								if(!"1".equals(portSkdOnLongRangeVO.getClptSeq()) && m != 0){
									
									for(int k=0; k<targetVVD.size(); k++){
										
										PortSkdOnLongRangeVO tmp = targetVVD.get(k);
										if(tmp.getYdCd().equals(portSkdVOBySamePf.get(iPositionOnVVD).get(m-1).getYdCd()) && tmp.getSkdDirCd().equals(portSkdVOBySamePf.get(iPositionOnVVD).get(m-1).getSkdDirCd())){
											iCurPortClptSeq =  k+1;
										}
										
										
									}
									
								}
							}
							
						}
					}
				}
				
				PortSkdOnLongRangeVO 		longRangeHdrOnlyVO 	= null;
				List<PortSkdOnLongRangeVO> 				tmpList = null;
				
				longRangeHdrOnlyVO 						= new PortSkdOnLongRangeVO	();
				longRangeHdrOnlyVO.setVslSlanCd			(addPortVO.getVslSlanCd		());
				longRangeHdrOnlyVO.setPfSkdTpCd			(addPortVO.getPfSkdTpCd		());
				longRangeHdrOnlyVO.setSkdDirCd			(addPortVO.getSkdDirCd		());
				longRangeHdrOnlyVO.setVpsPortCd			(addPortVO.getVpsPortCd		());
				longRangeHdrOnlyVO.setClptIndSeq		(addPortVO.getClptIndSeq	());
				longRangeHdrOnlyVO.setYdCd				(addPortVO.getYdCd			());
				longRangeHdrOnlyVO.setCallYdIndSeq		(addPortVO.getCallYdIndSeq	());
				longRangeHdrOnlyVO.setClptSeq			(addPortVO.getClptSeq		());
				
				longRangeHdrOnlyVO.setEmptySkd			(true);
				
				for(int m=0; m<tmpPortSkdGridData.size(); m++){
					tmpList = new ArrayList<PortSkdOnLongRangeVO>(tmpPortSkdGridData.get(m));
					
					if(m==iPositionOnVVD){
						
						//:2015-11-20://tmp.add(iCurPortClptSeq, addPortVO			);
						this.addPortSkdOnLongRange	(tmpList, iCurPortClptSeq, addPortVO);
						
					}else{
						
						//:2015-11-20://tmp.add(iCurPortClptSeq, longRangeHdrOnlyVO	);
						this.addPortSkdOnLongRange	(tmpList, iCurPortClptSeq, longRangeHdrOnlyVO);
						
					}
					
					tmpPortSkdGridData.set(m, tmpList);
					
		
//:Back to original because broken grid://					
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//					if(		tmpPortSkdGridData.get(m).get(0).getVslCd	() == null 
//						||	tmpPortSkdGridData.get(m).get(0).getSkdVoyNo() == null
//						||	(
//								(tmpList.get(0).getVslCd	() == null ? "" : tmpList.get(0).getVslCd	()).equals(tmpPortSkdGridData.get(m).get(0).getVslCd	() == null ? "" : tmpPortSkdGridData.get(m).get(0).getVslCd		())
//							&&	(tmpList.get(0).getSkdVoyNo	() == null ? "" : tmpList.get(0).getSkdVoyNo()).equals(tmpPortSkdGridData.get(m).get(0).getSkdVoyNo	() == null ? "" : tmpPortSkdGridData.get(m).get(0).getSkdVoyNo	())
//							)
//						)
//					{
//						tmpPortSkdGridData.set(m, tmpList);
//					}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					
				}

				// P/F �대떦 �꾩튂�먮룄 �뺣낫 異붽�
				PfSkdDetailVO addingPfSkdVO 			= new PfSkdDetailVO();
				
				addingPfSkdVO.setSkdDirCd				(addPortVO.getSkdDirCd		());
				addingPfSkdVO.setPortCd					(addPortVO.getVpsPortCd		());
				addingPfSkdVO.setClptSeq				(addPortVO.getClptIndSeq	());
				addingPfSkdVO.setYdCd					(addPortVO.getYdCd			());
				addingPfSkdVO.setCallYdIndSeq			(addPortVO.getCallYdIndSeq	());
				addingPfSkdVO.setEtbDyCd				("*");
				addingPfSkdVO.setEtdDyCd				("*");
				addingPfSkdVO.setEtbTmHrmnt				("*");
				addingPfSkdVO.setEtdTmHrmnt				("*");

				//:2015-11-20://pfSkdDetailVOsByGroup.add	(iCurPortClptSeq	, addingPfSkdVO		);
				this.addPfSkdDetailsByGroup				(pfSkdDetailVOsByGroup, iCurPortClptSeq, addingPfSkdVO);
				
				pfSkdDetailsByGroup.put					(pfSkdKeyByGroup	, pfSkdDetailVOsByGroup	);
			}
			/**************************************************************/
		}

		
		// tmpPortSkdGridData �먯꽌 �쒓컙����쟾���ы듃瑜��ㅼ젙�쒕떎. :: REVERSE CALLING PORT 寃곗젙 ::
		/** Applying except adding port when deciding 'REVERSE ALL' ************************/
		//:2015-11-23:Move to below the part of method calling adjustSkdSwap://Commented by TOP//
//		for(List<PortSkdOnLongRangeVO> vvd : tmpPortSkdGridData){
//			String 	firstDirCd 	= null;
//			int 	maxClptSeq 	= 1;
//			
//			//::2015-09-08:by TOP:://for(PortSkdOnLongRangeVO portSkdOnLongRangeVO : vvd){
//			for(int inx = 0; inx<vvd.size(); inx++){
//				
//				PortSkdOnLongRangeVO	portSkdOnLongRangeVO	= vvd.get(inx);
//				
//				if(portSkdOnLongRangeVO.isEmptySkd()){
//					continue;
//				}
//				
//				if(firstDirCd==null || !firstDirCd.equals(portSkdOnLongRangeVO.getSkdDirCd())){
//					maxClptSeq = 1;
//					firstDirCd = portSkdOnLongRangeVO.getSkdDirCd();
//				}
//				
//				if(maxClptSeq > Integer.parseInt(portSkdOnLongRangeVO.getClptSeq())){
//					
//					//:2015-11-23://PortSkdOnLongRangeVO	tmpPrevVO	= null;
//					//:2015-11-23://tmpPrevVO							= this.getPrevPort	(vvd, inx);
//					
//					PortSkdOnLongRangeVO	tmpNextVO	= null;
//					tmpNextVO							= this.getNextPort	(vvd, inx);
//					
//					/////////////////////////////////////////////////////////////////
//					//try{
//					//	if(vvd.get(inx+1) != null){
//					//		tmpNextVO	= vvd.get(inx+1);
//					//	}
//					//}catch(IndexOutOfBoundsException oex){
//					//	log.error("\n\n VesselScheduleMgtBCImpl.adjustSKD() :: IndexOutOfBoundsException Occured for VVD+YD+CLPT_IND+CLPT_SEQ ["+vvd.get(inx).getVslCd()+vvd.get(inx).getSkdVoyNo()+vvd.get(inx).getSkdDirCd()+"] ["+vvd.get(inx).getYdCd()+"] ["+vvd.get(inx).getClptIndSeq()+"] ["+vvd.get(inx).getClptSeq()+"] \n\n");
//					//}
//					/////////////////////////////////////////////////////////////////
//					
//					
//					//::2015-09-08:by TOP:://
//					if	(		tmpNextVO != null
//							&&	!portSkdOnLongRangeVO.isAddingSkd()
//							//:2015-11-23://&&	!tmpPrevVO.isAddingSkd()	&& tmpPrevVO.getVpsEtbDt() != null
//							&&	!tmpNextVO.isAddingSkd()	&& tmpNextVO.getVpsEtbDt() != null
//							
//							////&&	portSkdOnLongRangeVO.getVpsEtbDt().compareTo(tmpNextVO.getVpsEtbDt()) > 0
//						)
//					{		
//						////portSkdOnLongRangeVO.setReverse(true);
//					}
//					
//				}else{
//					maxClptSeq = Integer.parseInt(portSkdOnLongRangeVO.getClptSeq());
//				}
//			}
//		}
		
		
		
		// tmpPortSkdGridData �먯꽌 �쒓컙����쟾���ы듃瑜��ㅼ젙�쒕떎. :: REVERSE CALLING PORT 寃곗젙 ::
		/** :2015-11-23:by TOP:Modifying except adding port when deciding 'REVERSE ALL' ************************/
		for(List<PortSkdOnLongRangeVO> vvd : tmpPortSkdGridData){
			
			//::2015-09-08:by TOP:://for(PortSkdOnLongRangeVO portSkdOnLongRangeVO : vvd){
			for(int inx = 0; inx<vvd.size(); inx++){
				
				PortSkdOnLongRangeVO	curPortVO	= vvd.get(inx);
				
				if(curPortVO.isEmptySkd()){
					continue;
				}
				
				PortSkdOnLongRangeVO	tmpPrevVO	= null;
				tmpPrevVO							= this.getPrevPort	(vvd, inx);
				
//				if(tmpPrevVO != null && curPortVO != null && curPortVO.getVslCd().equals("NFJT") && curPortVO.getSkdVoyNo().equals("0032") && curPortVO.getSkdDirCd().equals("S")){
//					log.info("\n\n curPort Info  PORT_CD ["+curPortVO.getVpsPortCd()+"] curPortVO.isAddingSkd() ["+curPortVO.isAddingSkd()+"] curPortVO.getVpsEtbDt() ["+curPortVO.getVpsEtbDt()+"] ");
//					log.info("\n   tmpPrevVO Info PORT_CD ["+tmpPrevVO.getVpsPortCd()+"] tmpPrevVO.isAddingSkd() ["+tmpPrevVO.isAddingSkd()+"] tmpPrevVO.getVpsEtbDt() ["+tmpPrevVO.getVpsEtbDt()+"] \n\n");
//				}
				
				if	(		tmpPrevVO != null			&& curPortVO != null
						&&	!curPortVO.isAddingSkd()
						//:2015-11-23://&&	!tmpPrevVO.isAddingSkd()	&& tmpPrevVO.getVpsEtbDt() != null
						
						&&	curPortVO.getVpsEtbDt().compareTo(tmpPrevVO.getVpsEtbDt()) < 0
					)
				{		
					curPortVO.setReverse(true);
				}
					
			}
		}
		if(adjustSkdSwapProc){
			adjustSkdSwap(tmpPortSkdGridData, pfSkdDetailVOsByGroup, 0);
		}
		
		
		return tmpPortSkdGridData;
		
	}
	
	private PortSkdOnLongRangeVO getPrevPort(List<PortSkdOnLongRangeVO> vvd, int inx){
		PortSkdOnLongRangeVO tmpPrevVO	= null;
		
		try{
			
			if(vvd == null || vvd.size() == 0)	return null;
			
			for(int i=inx-1; i>=0; i--){
				if(!vvd.get(i).isAddingSkd() && vvd.get(i).getVpsEtbDt() != null && !"S".equals(vvd.get(i).getSkdCngStsCd())){
					tmpPrevVO	= vvd.get(i);
					break;
				}
			}
			
		}catch(IndexOutOfBoundsException oex){
			log.error("\n\n VesselScheduleMgtBCImpl.adjustSKD() :: IndexOutOfBoundsException Occured for VVD+YD+CLPT_IND+CLPT_SEQ ["+vvd.get(inx).getVslCd()+vvd.get(inx).getSkdVoyNo()+vvd.get(inx).getSkdDirCd()+"] ["+vvd.get(inx).getYdCd()+"] ["+vvd.get(inx).getClptIndSeq()+"] ["+vvd.get(inx).getClptSeq()+"] \n\n");
		}
		return	tmpPrevVO;
	}
	
//	private PortSkdOnLongRangeVO getNextPort(List<PortSkdOnLongRangeVO> vvd, int inx){
//		PortSkdOnLongRangeVO tmpNextVO	= null;
//		
//		try{
//			
//			if(vvd == null || vvd.size() == 0)	return null;
//			
//			for(int i=inx+1; i<vvd.size(); i++){
//				if(!vvd.get(i).isAddingSkd() && vvd.get(i).getVpsEtbDt() != null && !"S".equals(vvd.get(i).getSkdCngStsCd())){
//					tmpNextVO	= vvd.get(i);
//					break;
//				}
//			}
//			
//		}catch(IndexOutOfBoundsException oex){
//			log.error("\n\n VesselScheduleMgtBCImpl.adjustSKD() :: IndexOutOfBoundsException Occured for VVD+YD+CLPT_IND+CLPT_SEQ ["+vvd.get(inx).getVslCd()+vvd.get(inx).getSkdVoyNo()+vvd.get(inx).getSkdDirCd()+"] ["+vvd.get(inx).getYdCd()+"] ["+vvd.get(inx).getClptIndSeq()+"] ["+vvd.get(inx).getClptSeq()+"] \n\n");
//		}
//		return	tmpNextVO;
//	}
	
	private List<PortSkdOnLongRangeVO> addPortSkdOnLongRange(List<PortSkdOnLongRangeVO> tmpPortSkdOnLongRangeVOs, int iCurPortClptSeq, PortSkdOnLongRangeVO tmpPortSkdOnLongRangeVO){
		
		try{
			if(tmpPortSkdOnLongRangeVOs == null || tmpPortSkdOnLongRangeVOs.size() == 0 || tmpPortSkdOnLongRangeVO == null)		return null;
			
			tmpPortSkdOnLongRangeVOs.add(iCurPortClptSeq, tmpPortSkdOnLongRangeVO	);
		}catch(IndexOutOfBoundsException oex){
			log.error("\n\n VesselScheduleMgtBCImpl.adjustSKD().addPortSkdOnLongRange() :: IndexOutOfBoundsException Occured for iCurPortClptSeq ["+iCurPortClptSeq+"] \n\n");
		}
		
		return	tmpPortSkdOnLongRangeVOs;
	}
	
	private List<PfSkdDetailVO> addPfSkdDetailsByGroup(List<PfSkdDetailVO> tmpPfSkdDetailVOsByGroupList, int iCurPortClptSeq, PfSkdDetailVO tmpPfSkdDetailVOsByGroup){
		
		try{
			if(tmpPfSkdDetailVOsByGroupList == null || tmpPfSkdDetailVOsByGroupList.size() == 0 || tmpPfSkdDetailVOsByGroup == null)	return null;
			
			tmpPfSkdDetailVOsByGroupList.add (iCurPortClptSeq , tmpPfSkdDetailVOsByGroup);
		}catch(IndexOutOfBoundsException oex){
			log.error("\n\n VesselScheduleMgtBCImpl.adjustSKD().addPfSkdDetailsByGroup() :: IndexOutOfBoundsException Occured for iCurPortClptSeq ["+iCurPortClptSeq+"] \n\n");
		}
		
		return	tmpPfSkdDetailVOsByGroupList;
	}
	
	
	private void adjustSkdSwap(List<List<PortSkdOnLongRangeVO>> tmpPortSkdGridData, List<PfSkdDetailVO> pfSkdDetailVOsByGroup, int cnt){
		int swapIdx = 0;
		for(List<PortSkdOnLongRangeVO> vvd : tmpPortSkdGridData){
			for(int inx = 0; inx<vvd.size(); inx++){
				if(cnt <= vvd.size()){
					if(inx > 0 && vvd.get(inx).getSkdDirCd().equals(vvd.get(inx-1).getSkdDirCd()) 
							   && vvd.get(inx).getVpsEtbDt() != null && vvd.get(inx-1).getVpsEtbDt() != null 
							   //:2016-05-23:by HS://&& vvd.get(inx).getClptIndSeq().equals(vvd.get(inx-1).getClptIndSeq())	   
							   && (Integer.parseInt("".equals(vvd.get(inx).getClptSeq()) ? "0" : vvd.get(inx).getClptSeq()) < Integer.parseInt("".equals(vvd.get(inx-1).getClptSeq()) ? "0" : vvd.get(inx-1).getClptSeq()))){
							   //:2016-04-xx:by HS://&& vvd.get(inx).getVpsEtbDt().compareTo(vvd.get(inx-1).getVpsEtbDt()) < 0) {
						if(!vvd.get(inx).equals(vvd.get(inx-1)) && vvd.get(inx).isReverse() != true ){
							swapIdx = inx;
						}
					}
				}	
			}
		}
		if(swapIdx > 1){
			for(List<PortSkdOnLongRangeVO> vvd : tmpPortSkdGridData){
				//for(int inx = 0; inx<vvd.size(); inx++){
					Collections.swap(vvd, swapIdx-1, swapIdx);
				//}
			}
			cnt++;
			Collections.swap(pfSkdDetailVOsByGroup, swapIdx-1, swapIdx);
			adjustSkdSwap(tmpPortSkdGridData, pfSkdDetailVOsByGroup, cnt);
		}
	}
	
	private PortSkdOnLongRangeVO findFirstSkd(List<PortSkdOnLongRangeVO> rowData){
		PortSkdOnLongRangeVO first 	= null;
		
		for(PortSkdOnLongRangeVO vo : rowData){
			if	(		vo.isEmptySkd() 
					&&	(vo.getVslCd()==null && vo.getSkdVoyNo()==null)
				)
			{
				continue;
			}else{
				first = vo;
				break;
			}
		}
		return first;
	}
	
	private PortSkdOnLongRangeVO findLastSkd(List<PortSkdOnLongRangeVO> rowData){
		PortSkdOnLongRangeVO last 	= null;
		PortSkdOnLongRangeVO vo 	= null;
		for(int i=rowData.size()-1; i>=0; i--){
			vo = rowData.get(i);
			if	(		vo.isEmptySkd() 
					&&	(vo.getVslCd()==null && vo.getSkdVoyNo()==null)
				)
			{
				continue;
			}else{
				last = vo;
				break;
			}
		}
		return last;
	}
	
	/**
	 * Creating initial Port SKD Info using P/F
	 * 
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @return PortSkdOnLongRangeVO[]
	 */
	private PortSkdOnLongRangeVO[] initSkdByPf(List<PfSkdDetailVO> pfSkdDetailVOs){
		
		PortSkdOnLongRangeVO[] 	portSkdArr 		= new PortSkdOnLongRangeVO[pfSkdDetailVOs.size()];
		PfSkdDetailVO 			pfSkdDetailVO 	= null;
		PortSkdOnLongRangeVO 	vo 				= null;
		
		for(int i=0; i<pfSkdDetailVOs.size(); i++){
		
			pfSkdDetailVO 		= pfSkdDetailVOs.get(i);
			
			vo 					= new PortSkdOnLongRangeVO();
			
			vo.setVslSlanCd		(pfSkdDetailVO.getVslSlanCd		());
			vo.setPfSkdTpCd		(pfSkdDetailVO.getPfSvcTpCd		());
			vo.setSkdDirCd		(pfSkdDetailVO.getSkdDirCd		());
			vo.setVpsPortCd		(pfSkdDetailVO.getPortCd		());
			vo.setClptIndSeq	(pfSkdDetailVO.getClptSeq		());
			vo.setYdCd			(pfSkdDetailVO.getYdCd			());
			vo.setCallYdIndSeq	(pfSkdDetailVO.getCallYdIndSeq	());
			vo.setClptSeq		("");
			
			vo.setEmptySkd		(true);
			
			portSkdArr[i] 		= vo;
		}
		return portSkdArr;
	}
	
	/**
	 * Retrieving port skd order in P/F
	 * 
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @param PortSkdOnLongRangeVO portSkdOnLongRangeVO
	 * @return int
	 */
	private int getHeaderIdx(List<PfSkdDetailVO> pfSkdDetailVOs, PortSkdOnLongRangeVO portSkdOnLongRangeVO) throws EventException {
		
		int 	idx 		= 0;
		boolean find		= false;
		
		String pfEtbDtStr	= null;
		String pfEtdDtStr	= null;
		
		for(PfSkdDetailVO pfSkdDetailVO : pfSkdDetailVOs){
			
			if(		portSkdOnLongRangeVO.getVslSlanCd			().equals(pfSkdDetailVO.getVslSlanCd		())
				&&	portSkdOnLongRangeVO.getPfSkdTpCd			().equals(pfSkdDetailVO.getPfSvcTpCd		())
				
				&&	portSkdOnLongRangeVO.getSkdDirCd			().equals(pfSkdDetailVO.getSkdDirCd			()) 	
				&&	portSkdOnLongRangeVO.getVpsPortCd			().equals(pfSkdDetailVO.getPortCd			()) 
				&&	portSkdOnLongRangeVO.getYdCd				().equals(pfSkdDetailVO.getYdCd				())
				
				&&	portSkdOnLongRangeVO.getExclAddClptIndSeq	().equals(pfSkdDetailVO.getClptSeq			())		/** Add to correct calling indicator seq : 2015-09-30 : by TOP **/
				&&	(portSkdOnLongRangeVO.getPfEtbDt() != null && !"".equals(portSkdOnLongRangeVO.getPfEtbDt()))
			){
				
				pfEtbDtStr = VSKGeneralUtil.changeDateFormat(portSkdOnLongRangeVO.getPfEtbDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
				pfEtdDtStr = VSKGeneralUtil.changeDateFormat(portSkdOnLongRangeVO.getPfEtdDt(), "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
				
				// if PORT_CD, ETB_TM_HRMNT, ETD_TM_HRMNT are match, PF match. Finding that index
				if(pfEtbDtStr.length()==14 && pfEtdDtStr.length()==14){
					if(		pfEtbDtStr.substring(8, 12).equals(pfSkdDetailVO.getEtbTmHrmnt()) 
						&&	pfEtdDtStr.substring(8, 12).equals(pfSkdDetailVO.getEtdTmHrmnt())
					){
						find = true;
						break;
					}
				}
			}
			idx++;
		}
		
		if(find){
			return idx;
		}else{
			return -1;
		}
	}
	
	/**
	 * Creating VVD delete history
	 * 
	 * @param VskVslSkdHisVO vskVslSkdHisVO
	 * @exception EventException
	 */
	private void addVskVslSkdDelHis(VskVslSkdHisVO vskVslSkdHisVO) throws EventException {
		try{
			dbDao.addVskVslSkdDelHis(vskVslSkdHisVO);	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * Changing Vessel Port SKD as per Deleting Actual SKD
	 * 
	 * @param List<VskVslPortSkdVO> vskVslPortSkdVOs
	 * @exception EventException
	 */
	public void modifyVskVslPortSkdByActSkdDelelet(List<VskVslPortSkdVO> vskVslPortSkdVOs) throws EventException {
		try{
			dbDao.modifyVskVslPortSkdByActSkdDelelet(vskVslPortSkdVOs);	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}	
	}
	
	/**
	 * VOP_VSK_0018 : crr_cd
	 * @param String crrCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCrrCd(String crrCd) throws EventException {
		try{
			return dbDao.searchCrrCd(crrCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}	
	}
	
	/**
	 * Creating LongRangeScheduleMultiple
	 * 
	 * @param LongRangeSkdGRPVO longRangeSkdGRPVO
	 * @return LongRangeSkdGRPVO
	 * @exception EventException
	 */
	public LongRangeSkdGRPVO createLongRngSkdMultiple(LongRangeSkdGRPVO longRangeSkdGRPVO) throws EventException {
		
		try {
			
			PfSkdVO[] pfSkdVOs = longRangeSkdGRPVO.getPfSkdVOs();
			Map<String, MdmVslCntrVO> vesselVOs = new HashMap<String, MdmVslCntrVO>();
			
			String[] skdRmk = longRangeSkdGRPVO.getSkdRmk();
			Map<String, String> skdRmkMap = new HashMap<String, String>();
			Map<String, String> pfSvcTpCdMap = new HashMap<String, String>();
			
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1(); // SKD_DIR_CD
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2(); // VPS_PORT_CD
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3(); // ETB_DY_NO/ETD_DY_NO
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			String headTitle5 = longRangeSkdGRPVO.getHeadTitle5(); // CLPT_SEQ
			String headTitle6 = longRangeSkdGRPVO.getHeadTitle6(); // YD_CD
			
//			boolean oneWayDir = true;
			Map<String, Boolean> oneWayDirMap = new HashMap<String, Boolean>();
			
			Map<String, String[]> simInfo = longRangeSkdGRPVO.getSimInfoMap();
			List<String[]> vslInfo = longRangeSkdGRPVO.getVslInfo();
			String[] vslInfoStr = null;
			
			int s1BreakPoint = 0;
			int s2BreakPoint = 0;
			String[] titlesSplit = headTitle1.split("\\|");
			
			for(int i=0 ; i<titlesSplit.length ; i++){
				if(titlesSplit[i].indexOf("@") > -1){
					s1BreakPoint = i/2;		//etb, etd 2揶쏆뮇逾�?�용┛ ?���?
				}
				if(titlesSplit[i].indexOf("#") > -1){
					s2BreakPoint = i/2;		//etb, etd 2揶쏆뮇逾�?�용┛ ?���?
				}
			}

			String[] titles1 = headTitle1.replaceAll("@", "").replaceAll("#", "").split("\\|");
			String[] titles2 = headTitle2.replaceAll("@", "").replaceAll("#", "").split("\\|");
			String[] titles3 = headTitle3.replaceAll("@", "").replaceAll("#", "").split("\\|");
			String[] titles4 = headTitle4.replaceAll("@", "").replaceAll("#", "").split("\\|");
			String[] titles5 = headTitle5.replaceAll("@", "").replaceAll("#", "").split("\\|");
			String[] titles6 = headTitle6.replaceAll("@", "").replaceAll("#", "").split("\\|");
			
			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles5.length)
					&& (titles5.length==titles6.length)
			))
			{
				// in case Header lengths are different, Exception
				throw new EventException(new ErrorHandler("VSK10039").getMessage());			
			}
			
			
			// Setting CLPT_IND_SEQ, CLPT_SEQ, CALL_YD_IND_SEQ
			
			log.info("Step1-Start");
			
			// ---------- Step1. PfSkdVO list creation start  ----------
			String pfSvcTpCd = "";
			List<String> portList = new ArrayList<String>();
			String portTmp = "";
			
			List<String> s1PfSvcList = new ArrayList<String>();
			List<String> s2PfSvcList = new ArrayList<String>();
			List<String> s3PfSvcList = new ArrayList<String>();
			
			List<String> s1VslList = new ArrayList<String>();
			List<String> s2VslList = new ArrayList<String>();
			List<String> s3VslList = new ArrayList<String>();
			
			Map<String, String> vslCdMap = new HashMap<String, String>();
			Map<String, List<String>> skdDirCdMap = new HashMap<String, List<String>>();
			
			List<String> dirCdList = new ArrayList<String>();
			
			int s1Vsl1Break = 0;
			int s1Vsl2Break = 0;
			int s2Vsl1Break = 0;
			int s3Vsl1Break = 0;
			
//			int totHeadSz = pfSkdList.size();
			int totHeadSz = titles1.length/2;
			int s1Head = 0;
			int s2Head = 0;
//			int s3Head = 0;
			
			if(s2BreakPoint == 0 && s1BreakPoint == 0){
				s1Head = totHeadSz;
				s2Head = 0;
//				s3Head = 0;
			}else if(s2BreakPoint == 0 && s1BreakPoint > 0){
				s1Head = s1BreakPoint;
				s2Head = totHeadSz-s1BreakPoint;
//				s3Head = 0;
			}else if(s2BreakPoint > 0 && s1BreakPoint > 0){
				s1Head = s1BreakPoint;
				s2Head = s2BreakPoint-s1BreakPoint;
//				s3Head = totHeadSz-s2BreakPoint;
			}
			
			for(int p=0 ; p<pfSkdVOs.length ; p++){
				PfSkdVO pfSkdVO = pfSkdVOs[p];
				StringBuffer sbPortTmp	= new StringBuffer("");
				
				if(!"".equals(pfSvcTpCd) && !pfSvcTpCd.equals(pfSkdVO.getPfSvcTpCd())){
					
					if(!portList.contains(portTmp)){
						portList.add(portTmp);
					}
					if(portList.get(0).equals(portTmp)){
						s1PfSvcList.add(pfSvcTpCd);
						if(s1Vsl1Break==0)
							s1Vsl1Break = p;
						else if(s1Vsl2Break==0)
							s1Vsl2Break = p;
						
					}else if(portList.get(1) != null && portList.get(1).equals(portTmp)){
						s2PfSvcList.add(pfSvcTpCd);
						if(s2Vsl1Break==0)
							s2Vsl1Break = p;
						
					}else if(portList.get(2) != null && portList.get(2).equals(portTmp)){
						s3PfSvcList.add(pfSvcTpCd);
						if(s3Vsl1Break==0)
							s3Vsl1Break = p;
						
					}	
					portTmp = "";
					dirCdList = new ArrayList<String>();

				}
				
				sbPortTmp.append	(portTmp			);
				//sbPortTmp.append	(pfSkdVO.getPortCd());
				sbPortTmp.append	(pfSkdVO.getPfSvcTpCd());
				portTmp = sbPortTmp.toString();
				
				pfSvcTpCd = pfSkdVO.getPfSvcTpCd();
				dirCdList.add(pfSkdVO.getSkdDirCd());				
				skdDirCdMap.put(pfSkdVO.getPfSvcTpCd(), dirCdList);
				oneWayDirMap.put(pfSkdVO.getPfSvcTpCd(), true);
				
			}
			if(!portList.contains(portTmp)){
				portList.add(portTmp);
			}
			if(portList.get(0).equals(portTmp)){
				s1PfSvcList.add(pfSvcTpCd);
			}else if(portList.get(1) != null && portList.get(1).equals(portTmp)){
				s2PfSvcList.add(pfSvcTpCd);
			}else if(portList.get(2) != null && portList.get(2).equals(portTmp)){
				s3PfSvcList.add(pfSvcTpCd);
			}	
					

			String sPfSvcTpCd1 = "";
			String sPfSvcTpCd2 = "";
			String sPfSvcTpCd3 = "";
			
			int vsl2AddCnt = 0;
			int vsl3AddCnt = 0;
			
			List<String> dirCdList1 = new ArrayList<String>();
			List<String> dirCdList2 = new ArrayList<String>();
			List<String> dirCdList3 = new ArrayList<String>();
			PfSkdVO pfSkdVO2 = null;
			PfSkdVO pfSkdVO3 = null;
			
			String beforeDir = null;
			String beforeDir2 = null;
			String beforeDir3 = null;
			
			boolean oneWayDir1 = true;
			boolean oneWayDir2 = true;
			boolean oneWayDir3 = true;
			
			// Adding Header to PF
			List<PfSkdVO> pfSkdList = new ArrayList<PfSkdVO>();
			for(int i=1,k=0,l=0,n=0; i<titles1.length; i=i+2){

				if(k >= pfSkdVOs.length)
				   k = pfSkdVOs.length - 1;
				PfSkdVO	pfSkdVO = pfSkdVOs[k];

				if(s1Vsl1Break > 0 && l == 0){
					l = s1Vsl1Break;
				}else if(s2Vsl1Break > 0 && l == 0){
					l = s2Vsl1Break;					
				}
				if(l <pfSkdVOs.length)
					pfSkdVO2 = pfSkdVOs[l];
				
				if(s3Vsl1Break > 0 && n == 0){
					n = s3Vsl1Break;					
				}else if(s1Vsl2Break > 0 && n == 0){
					n = s1Vsl2Break;
				}else if(s2Vsl1Break > 0 && n == 0){
					n = s2Vsl1Break;
				}  
				if(n <pfSkdVOs.length)
					pfSkdVO3 = pfSkdVOs[n];
				
				//skdDirCdMap ??proforma code癰�dirCd �귐딅뮞???類ｋ궖 �닌딄쉐
				if(s1Vsl1Break > 0 && k < s1Vsl1Break){
					sPfSvcTpCd1 = pfSkdVO.getPfSvcTpCd();
					oneWayDirMap.put(pfSkdVO.getPfSvcTpCd(), oneWayDir1);
					
					if(titles2[i].equals(pfSkdVO.getPortCd())){
						dirCdList1.add(pfSkdVO.getSkdDirCd());
					}else{
						if(beforeDir.equals(pfSkdVO.getSkdDirCd())){
							dirCdList1.add(pfSkdVO.getSkdDirCd());
						}else if(titles1[i].indexOf("*") < 0){
							dirCdList1.add(titles1[i]);
						}else if(titles1[i].indexOf("*") > -1 && !beforeDir.equals(pfSkdVO.getSkdDirCd()) 
								&& beforeDir.equals(titles1[i].replace("*",""))){
							dirCdList1.add(pfSkdVO.getSkdDirCd());
						}else if(titles1[i].indexOf("*") > -1 && !beforeDir.equals(pfSkdVO.getSkdDirCd()) 
								&& pfSkdVO.getSkdDirCd().equals(titles1[i].replace("*",""))){
							dirCdList1.add(beforeDir);
						}else{
							dirCdList1.add(titles1[i].replace("*",""));	//獄쏆뮇源�醫롫땾 ?�곸벉
						}
					}
					skdDirCdMap.put(sPfSvcTpCd1, dirCdList1);
					
				}
				if(pfSkdVO2 != null && ((s1Vsl2Break > 0 && l < s1Vsl2Break) || (s2Vsl1Break > 0 && l < s2Vsl1Break))){
					sPfSvcTpCd2 = pfSkdVO2.getPfSvcTpCd();
					oneWayDirMap.put(pfSkdVO2.getPfSvcTpCd(), oneWayDir2);
					
					vsl2AddCnt = (s1Head*2)+i;
					if (titles2.length <= vsl2AddCnt) {
						vsl2AddCnt = (s1Head*2);
					}
					
					if(titles2[vsl2AddCnt].equals(pfSkdVO2.getPortCd())){
						dirCdList2.add(pfSkdVO2.getSkdDirCd());
					}else{
						if(beforeDir2 != null && beforeDir2.equals(pfSkdVO2.getSkdDirCd())){
							dirCdList2.add(pfSkdVO2.getSkdDirCd());
						}else if(titles1[vsl2AddCnt].indexOf("*") < 0){
							dirCdList2.add(titles1[vsl2AddCnt]);
						}else if(titles1[vsl2AddCnt].indexOf("*") > -1 && beforeDir2 != null && !beforeDir2.equals(pfSkdVO2.getSkdDirCd()) 
								&& beforeDir2.equals(titles1[vsl2AddCnt].replace("*",""))){
							dirCdList2.add(pfSkdVO2.getSkdDirCd());
						}else if(titles1[vsl2AddCnt].indexOf("*") > -1 && beforeDir2 != null && !beforeDir2.equals(pfSkdVO2.getSkdDirCd()) 
								&& pfSkdVO2.getSkdDirCd().equals(titles1[vsl2AddCnt].replace("*",""))){
							dirCdList2.add(beforeDir2);
						}else{
							dirCdList2.add(titles1[vsl2AddCnt].replace("*",""));	//獄쏆뮇源�醫롫땾 ?�곸벉
						}
					}
					skdDirCdMap.put(sPfSvcTpCd2, dirCdList2);
					
				}
				if(pfSkdVO3 != null && ((s2Vsl1Break > 0 && n < s2Vsl1Break) || (s3Vsl1Break > 0 && n < s3Vsl1Break))){
					sPfSvcTpCd2 = pfSkdVO3.getPfSvcTpCd();
					oneWayDirMap.put(pfSkdVO3.getPfSvcTpCd(), oneWayDir3);
					
					if(s3Vsl1Break > 0 && n < s3Vsl1Break)
						vsl3AddCnt = (s2Head*2)+i;
					else if(s2Vsl1Break > 0 && n < s2Vsl1Break)
						vsl3AddCnt = (s1Head*2)+i;
					
					if(titles2[vsl3AddCnt].equals(pfSkdVO3.getPortCd())){
						dirCdList3.add(pfSkdVO3.getSkdDirCd());
					}else{
						if(beforeDir3 != null && beforeDir3.equals(pfSkdVO3.getSkdDirCd())){
							dirCdList3.add(pfSkdVO3.getSkdDirCd());
						}else if(titles1[vsl3AddCnt].indexOf("*") < 0){
							dirCdList3.add(titles1[vsl3AddCnt]);
						}else if(titles1[vsl3AddCnt].indexOf("*") > -1 && beforeDir3 != null && !beforeDir3.equals(pfSkdVO3.getSkdDirCd()) 
								&& beforeDir3.equals(titles1[vsl3AddCnt].replace("*",""))){
							dirCdList3.add(pfSkdVO3.getSkdDirCd());
						}else if(titles1[vsl3AddCnt].indexOf("*") > -1 && beforeDir3 != null && !beforeDir3.equals(pfSkdVO3.getSkdDirCd()) 
								&& pfSkdVO3.getSkdDirCd().equals(titles1[vsl3AddCnt].replace("*",""))){
							dirCdList3.add(beforeDir3);
						}else{
							dirCdList3.add(titles1[vsl3AddCnt].replace("*",""));	//獄쏆뮇源�醫롫땾 ?�곸벉
						}
					}
					skdDirCdMap.put(sPfSvcTpCd3, dirCdList3);
					
				}
				
				// if direction of now and p/f are different, this PF construct with 2 direction
				if(oneWayDir1 && beforeDir!=null && !pfSkdVO.getSkdDirCd().equals(beforeDir)){
//					oneWayDir = false;
					oneWayDir1 = false;
					oneWayDirMap.put(pfSkdVO.getPfSvcTpCd(), oneWayDir1);
					
				}
				if(oneWayDir2 && beforeDir2!=null && !pfSkdVO2.getSkdDirCd().equals(beforeDir2)){
					oneWayDir2 = false;
					oneWayDirMap.put(pfSkdVO2.getPfSvcTpCd(), oneWayDir2);
					
				}
				if(oneWayDir3 && beforeDir3!=null && !pfSkdVO3.getSkdDirCd().equals(beforeDir3)){
					oneWayDir3 = false;
					oneWayDirMap.put(pfSkdVO3.getPfSvcTpCd(), oneWayDir3);
					
				}
				beforeDir = pfSkdVO.getSkdDirCd();
				if(pfSkdVO2 != null)
					beforeDir2 = pfSkdVO2.getSkdDirCd();
				if(pfSkdVO3 != null)
					beforeDir3 = pfSkdVO3.getSkdDirCd();
				
				if(pfSkdVOs[k].getTurnPortIndCd()==null || "".equals(pfSkdVOs[k].getTurnPortIndCd())){
					pfSkdVOs[k].setTurnPortIndCd("N");
				}
				
				if(titles2[i].trim().equals(pfSkdVO.getPortCd().trim())){
					pfSkdList.add(pfSkdVO);
					k++;
					l++;		//l count add
					n++;		//n count add
				}else{
					// Creating PfSkdVO using title
				    int existCnt = 0;
					for(int h=0; h<pfSkdVOs.length; h++){
					   if (titles2[i].trim().equals(pfSkdVOs[h].getPortCd().trim())) {
							existCnt++;
							if (existCnt == 1) {
								pfSkdList.add(pfSkdVOs[h]);
							}
						}
					}
					if (existCnt == 0) {
						PfSkdVO vo = new PfSkdVO();
						vo.setPortCd(titles2[i]);
						vo.setSkdDirCd(titles1[i]);
						vo.setYdCd( titles2[i].trim()+titles6[i].trim());
						vo.setVslSlanCd(longRangeSkdGRPVO.getVslSlanCd());
						vo.setVslSvcTpCd(longRangeSkdGRPVO.getVslSvcTpCd());	
						vo.setTurnPortIndCd("N");
						pfSkdList.add(vo);
					}				
			  }
/*

				if(titles2[i].equals(pfSkdVO.getPortCd())){
					pfSkdList.add(pfSkdVO);
					k++;
					l++;		//l count 筌앹빓?
					n++;		//n count 筌앹빓?
				}else{
					// Creating PfSkdVO using title
					PfSkdVO vo = new PfSkdVO();
					vo.setPortCd(titles2[i]);
					vo.setSkdDirCd(titles1[i]);
					vo.setYdCd(titles6[i]);
					vo.setVslSlanCd(longRangeSkdGRPVO.getVslSlanCd());
					vo.setVslSvcTpCd(longRangeSkdGRPVO.getVslSvcTpCd());
					vo.setTurnPortIndCd("N");
					pfSkdList.add(vo);
				}
*/
				
				
			}
			
			//?怨뚭퍙 ??媛�?紐� ?類ㅼ뵥 Flag : true ??野껋럩��?�덉뵬 vessel 嚥�?怨뚭퍙?�뺣뮄 ??媛�
			boolean boolSeqVoy = false;
			String tmpVsl = "";
			String voyNoType = longRangeSkdGRPVO.getVoyNoType();

			List<String> s1VoyList = new ArrayList<String>();
			List<String> s2VoyList = new ArrayList<String>();
			List<String> s3VoyList = new ArrayList<String>();
			
			//Sheet1 ???�덈뮉 Vsl Cd揶�??��
			for(int i=0 ; i<vslInfo.size() ; i++){
				vslInfoStr = vslInfo.get(i);
				if(s1PfSvcList.contains(vslInfoStr[3])){
					s1VslList.add(vslInfoStr[1]);
					s1VoyList.add(vslInfoStr[2]);
				}else if(s2PfSvcList.contains(vslInfoStr[3])){
					s2VslList.add(vslInfoStr[1]);
					s2VoyList.add(vslInfoStr[2]);
				}else if(s3PfSvcList.contains(vslInfoStr[3])){
					s3VslList.add(vslInfoStr[1]);
					s3VoyList.add(vslInfoStr[2]);
				}
				vslCdMap.put(vslInfoStr[1], vslInfoStr[3]);
				
				if("2".equals(voyNoType) && tmpVsl.equals(vslInfoStr[1])){
					boolSeqVoy = true;
				}
				tmpVsl = vslInfoStr[1];
			}
						
			
			// ---------- Step1. PfSkdVO list creation END ----------
			
			log.info("Step2-Start");
			
			// ---------- Step2. Changing Simulation info of screen to Vessel list ----------

			Map<String, List<VskSwapCstPortVO>> skdByVsl = new HashMap<String, List<VskSwapCstPortVO>>();
			{	
		
				String[] vvd1 = longRangeSkdGRPVO.getVVD1();
				String[] vvd2 = longRangeSkdGRPVO.getVVD2();
				String[] vvd3 = longRangeSkdGRPVO.getVVD3();
				String[] vvd2_1 = new String[vvd2.length];
				String[] vvd2_2 = new String[vvd2.length];
				
				String[] pfSvcTpCds = longRangeSkdGRPVO.getPfSvcTpCds();
				
				//VskSwapCstPortVO skdVO = null;
				PfSkdVO pfSkdVO = null;
				
				String skdCngStsCd = null;
				String uiFormat = "MM/ddyyyyHHmm";
				String dataFormat = "yyyyMMddHHmm";
				
				boolean mCnt0Flag = false;
				boolean mCnt1Flag = false;
				boolean mCnt2Flag = false;
				
				String tmpDivCd = "N";
				String tmpPfSvcTpCd = "";
				int kTmp = 0;
				int mTmp = 0;
				int mCnt0 = 0;
				int mCnt1 = 0;
				int mCnt2 = 0;				
				
				// 4 rows are information of one VVD
				for(int m=0; m<vvd1.length; m=m+4){
					
					// no save in case of Phase Out VVD
					if(longRangeSkdGRPVO.getPOutFlag()!=null && longRangeSkdGRPVO.getPOutFlag()[m]!=null && longRangeSkdGRPVO.getPOutFlag()[m].length()!=0){
						continue;
					}

					mCnt0Flag = false;
					mCnt1Flag = false;
					mCnt2Flag = false;
					
					for(int k=0; k<pfSkdList.size(); k++){
						
//						log.info("m:"+m+"/k:"+k);
						
						VskSwapCstPortVO skdVO = new VskSwapCstPortVO();
						pfSkdVO = pfSkdList.get(k);
						
						skdVO.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
						skdVO.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
						
						skdVO.setVslCd(vvd1[m]);
						
						//?�덉뵬 Port List?�겸봺 �얜씈�앾쭖?Dir揶쏅���?��わ쭪????�됱벉 - ?袁⑥삋?癒�퐣 ?�낆젾
//						skdVO.setSkdDirCd(pfSkdVO.getSkdDirCd());
						
						if(!vesselVOs.containsKey(vvd1[m])){
							vesselVOs.put(vvd1[m], dbDao.searchMdmVslCntr(vvd1[m]));
							
						}
										
						skdVO.setVpsPortCd(pfSkdVO.getPortCd());
						skdVO.setSlanCd(pfSkdVO.getVslSlanCd());
						skdVO.setYdCd(pfSkdVO.getYdCd());
						skdVO.setTurnPortFlg(pfSkdVO.getTurnPortFlg());
						skdVO.setTurnPortIndCd(pfSkdVO.getTurnPortIndCd());
						skdVO.setMrgFlg(pfSkdVO.getMrgFlg());
						
						skdVO.setSeaBufHrs(pfSkdVO.getSeaBufHrs());
						skdVO.setPortBufHrs(pfSkdVO.getPortBufHrs());
						
						// Initializing CLPT_IND_SEQ, CALL_YD_IND_SEQ = 1
						skdVO.setClptIndSeq("1");
						skdVO.setCallYdIndSeq("1");
	
						//Sheet ??Data 筌띲끋釉�筌ｌ꼶��
//						if(s3VslList.contains(vvd1[m])){
						if(checkVslVoyContains(boolSeqVoy, s3VslList, s3VoyList, vvd1[m], vvd2[m], vslInfo.size(), vvd1.length)){
							if(s2BreakPoint > 0 && k < s2BreakPoint){
								continue;
							}else{
								kTmp = k-s2BreakPoint;
							}
							if(s2BreakPoint > 0 && k >= s2BreakPoint+s2Head && s1Head > s2Head && k < s2BreakPoint+s1Head){
								mTmp = mCnt0;
								mCnt0Flag = true;
								log.info("3-0");

							}else if(s2BreakPoint > 0 && k >= s2BreakPoint+s2Head){
								mTmp = mCnt2;
								mCnt2Flag = true;
								log.info("3-1");

							}else if(s2BreakPoint > 0 && k >= s2BreakPoint+s1Head){
								mTmp = mCnt1;
								mCnt1Flag = true;
								log.info("3-2");
								
							}else{
								mTmp = m;
								log.info("3-4");
							}
//							log.info("sheet03/"+pfSkdVO.getPfSvcTpCd());
//						}else if(s2VslList.contains(vvd1[m])){
						}else if(checkVslVoyContains(boolSeqVoy, s2VslList, s2VoyList, vvd1[m], vvd2[m], vslInfo.size(), vvd1.length)){
							if(s1BreakPoint > 0 && k < s1BreakPoint){
								continue;
							}else if(s2BreakPoint > 0 && k >= s2BreakPoint){
								continue;								
							}else{
								kTmp = k-s1BreakPoint;
							}
							if(s1BreakPoint > 0 && k >= s1BreakPoint+s1Head ){
								mTmp = mCnt1;
								mCnt1Flag = true;
							}else{
								mTmp = m;
							}
//							log.info("sheet02/"+pfSkdVO.getPfSvcTpCd());
//						}else if(s1VslList.contains(vvd1[m])){
						}else if(checkVslVoyContains(boolSeqVoy, s1VslList, s1VoyList, vvd1[m], vvd2[m], vslInfo.size(), vvd1.length)){
							if(s1BreakPoint > 0 && k >= s1Head){
								continue;
							}else{
								kTmp = k;
							}
							mCnt0 = m;
							mTmp = m;
							mCnt0Flag = true;
//							log.info("sheet01/"+pfSkdVO.getPfSvcTpCd());
						}
						//skdDirCd 揶쏅���揶�議�?苑�?�낆젾
						if(pfSkdVO.getPfSvcTpCd() != null)
							tmpPfSvcTpCd = pfSkdVO.getPfSvcTpCd();
						
						dirCdList = skdDirCdMap.get(tmpPfSvcTpCd);
						if(vvd3[m].indexOf("/") < 0){
							skdVO.setSkdDirCd(vvd3[m]);
							skdVO.setOneWayDir("true");
							
						}else if(vvd3[m].indexOf("/") >= 0 && kTmp == 0 && vvd3[m].length()>1){
							skdVO.setSkdDirCd(vvd3[m].substring(0,1));
							skdVO.setOneWayDir("false");
							
						}else if(dirCdList != null && kTmp < dirCdList.size()){
							skdVO.setSkdDirCd(dirCdList.get(kTmp));
							skdVO.setOneWayDir("false");
							
						}else{ 
							skdVO.setSkdDirCd(tmpDivCd);
							skdVO.setOneWayDir("false");
						}
						tmpDivCd = pfSkdVO.getSkdDirCd();
						if(pfSkdVO.getPfSvcTpCd() != null)
							tmpPfSvcTpCd = pfSkdVO.getPfSvcTpCd();
						
						if(vvd2[m].length()>4){
							vvd2_1[m] = vvd2[m].substring(0, 4);
							vvd2_2[m] = vvd2[m].substring(5, 9);
							
							skdRmkMap.put(vvd1[m]+vvd2_1[m], skdRmk[m]);
							skdRmkMap.put(vvd1[m]+vvd2_2[m], skdRmk[m]);
							
//							pfSvcTpCdMap.put(vvd1[m]+vvd2_1[m], pfSkdVO.getPfSvcTpCd());
//							pfSvcTpCdMap.put(vvd1[m]+vvd2_2[m], pfSkdVO.getPfSvcTpCd());
							pfSvcTpCdMap.put(vvd1[m]+vvd2_1[m], pfSvcTpCds[m]);
							pfSvcTpCdMap.put(vvd1[m]+vvd2_2[m], pfSvcTpCds[m]);
							
							if(skdVO.getSkdDirCd().equals(pfSkdList.get(0).getSkdDirCd())){
								skdVO.setSkdVoyNo(vvd2_1[m]);
//							}else if(skdVO.getSkdDirCd().equals(pfSkdList.get(pfSkdList.size()-1).getSkdDirCd())){
//								skdVO.setSkdVoyNo(vvd2_2[m]);
							}else{
								skdVO.setSkdVoyNo(vvd2_2[m]);
							}
						}else{
							skdVO.setSkdVoyNo(vvd2[m]);	
							
							skdRmkMap.put(vvd1[m]+vvd2[m], skdRmk[m]);
							
//							pfSvcTpCdMap.put(vvd1[m]+vvd2[m], pfSkdVO.getPfSvcTpCd());
							pfSvcTpCdMap.put(vvd1[m]+vvd2[m], pfSvcTpCds[m]);
							
						}							
						log.info("test04:k:"+k+"/kTmp:"+kTmp+"/m:"+m+"/mTmp:"+mTmp+"/vvd1[m]:"+vvd1[m]+"/vvd2[m]:"+vvd2[m]+"/pfSkdVO.getSkdDirCd():"+pfSkdVO.getSkdDirCd());
						
						// Setting PF_ET, INIT_ET, VPS_ET
						// 
						// in case of SKIP port
						// m+1 : INIT_ET
						// m+2 : PF_ET
						// m+3 : VPS_ET
						//
						// in case of no SKIP port
						// m : VPS_ET
						// m+1 : INIT_ET
						// m+2 : PF_ET
						// m+3 : SKD_CNG_STS_CD
						// m+1(common)
						skdVO.setInitEtbDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + kTmp)[mTmp+1], uiFormat, dataFormat));
						skdVO.setInitEtdDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + kTmp)[mTmp+1], uiFormat, dataFormat));
						skdVO.setInitEtaDt(
								getETA(skdVO.getInitEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
						
						// m+2(common)
						skdVO.setPfEtbDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + kTmp)[mTmp+2], uiFormat, dataFormat));
						skdVO.setPfEtdDt(
								VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + kTmp)[mTmp+2], uiFormat, dataFormat));
						skdVO.setPfEtaDt(
								getETA(skdVO.getPfEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
	
						
						if(" SKIP".equals(simInfo.get("ETB" + kTmp)[mTmp])){
							// in case of SKIP port
							// m+3 : VPS_ET
							skdCngStsCd = "S";
							
							skdVO.setVpsEtbDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + kTmp)[mTmp+3], uiFormat, dataFormat));
							skdVO.setVpsEtdDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + kTmp)[mTmp+3], uiFormat, dataFormat));
							skdVO.setVpsEtaDt(
									getETA(skdVO.getVpsEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
							
						}else{
							// in case of no SKIP port
							// m : VPS_ET
							// m+3 : SKD_CNG_STS_CD
							skdVO.setVpsEtbDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETB" + kTmp)[mTmp], uiFormat, dataFormat));
							skdVO.setVpsEtdDt(
									VSKGeneralUtil.changeDateFormat(simInfo.get("ETD" + kTmp)[mTmp], uiFormat, dataFormat));
							skdVO.setVpsEtaDt(
									getETA(skdVO.getVpsEtbDt(), dataFormat, pfSkdVO.getMnvrInHrs()));
							
							skdCngStsCd = simInfo.get("ETD" + kTmp)[mTmp+3];
							
							// Add Call, TURN_PORT_FLG = "N"
							if("A".equals(skdCngStsCd)){
								skdVO.setTurnPortFlg("N");
							}
							
							if(skdCngStsCd.startsWith("O:")){
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2));
								skdCngStsCd = "O";
							}
							
							if(skdCngStsCd.startsWith("I:")){
								skdVO.setPhsIoRsnCd(skdCngStsCd.substring(2));
								skdCngStsCd = "I";
							}
														
						}

						// Add Call, Retrieving and Setting PORT_BUF_HRS
						if("A".equals(skdCngStsCd)){
							String portBufHrs = dbDao.searchPortBufHrs(skdVO.getVpsPortCd());
							skdVO.setPortBufHrs(portBufHrs);
						}
												/*
						 * A : Add / R : Reverse / S : Skip / C : Change / I : Phase In / O : Phase Out
						 */
						skdVO.setSkdCngStsCd(skdCngStsCd);
						
						// Creating SKD per Vessel
						List<VskSwapCstPortVO> list = skdByVsl.get(skdVO.getVslCd());
						if(list==null){
							list = new ArrayList<VskSwapCstPortVO>();
						}
						
						/* ?怨뚭퍙 ??媛�癒�퐣 筌띾뜆?筌�??媛먨첎??袁⑤빒野껉퍓彛�??�� */
						if(!"X".equals(skdVO.getTurnPortIndCd())){
							list.add(skdVO);
							skdByVsl.put(skdVO.getVslCd(), list);
						}
												
					}
					if(mCnt0Flag){
						mCnt0 = mCnt0+4;
					}
					if(mCnt1Flag){
						mCnt1 = mCnt1+4;
					}
					if(mCnt2Flag){
						mCnt2 = mCnt2+4;
					}
				}
			}
			
			
			// ---------- Step2. Changing Simulation info of screen to Vessel list END ----------
			
			log.info("Step3-Start");
			
			// ---------- Step3. Changing list include Virtual Port ----------
			
			List<VskSwapCstPortVO> currVVD = new ArrayList<VskSwapCstPortVO>();
			List<VskSwapCstPortVO> prevVVD = new ArrayList<VskSwapCstPortVO>();
			
			String oneWayDirStr="false";
			
			// list include Virtual Port
			List<VskSwapCstPortVO> portSkdList = new ArrayList<VskSwapCstPortVO>();
			
			for(Iterator<List<VskSwapCstPortVO>> i = skdByVsl.values().iterator(); i.hasNext();){
				
				// by Step 2
				List<VskSwapCstPortVO> list = i.next();

				for(int j=0 ; j<list.size()-1 ; j++){
					for(int k=1 ; k<list.size()-j ; k++){
						if(Integer.parseInt(list.get(k-1).getSkdVoyNo()) > Integer.parseInt(list.get(k).getSkdVoyNo())){
							VskSwapCstPortVO tmpVO1 = list.get(k-1);
							VskSwapCstPortVO tmpVO2 = list.get(k);
							list.set(k-1, tmpVO2);
							list.set(k, tmpVO1); 
						}
					}
				}
				/*
				
				First VVD does not create virtual port in LRS Creation
				
				*/
				
				String firstVoyNo = null;
				String firstDirCd = null;
				String prevDirCd = null;
				
				for(int m=0; m<list.size();){
					
					// roof per count of port list 
					for(int k=0; m<list.size() && k<pfSkdList.size(); k++){
						VskSwapCstPortVO skdVO = list.get(m++);
						
						if("".equals(skdVO.getVpsEtbDt())){
							continue;
						}
						
						// in case of PF with one way direction, virtual is not necessary
//						if(oneWayDir){
//						if("true".equals(skdVO.getOneWayDir()));
						oneWayDirStr = skdVO.getOneWayDir();
						if("true".equals(oneWayDirStr)){
							skdVO.setTurnPortFlg("N");
							addPortSkd(skdVO, currVVD);
							continue;
						}
						
						// first VVD
						if(firstVoyNo==null && firstDirCd==null){
							firstVoyNo = skdVO.getSkdVoyNo();
							firstDirCd = skdVO.getSkdDirCd();
							prevDirCd = firstDirCd;
						}
						
						// use first VVD
						if("I".equals(skdVO.getSkdCngStsCd())){
							firstVoyNo = skdVO.getSkdVoyNo();
							firstDirCd = skdVO.getSkdDirCd();
						}
						
						if(!skdVO.getSkdDirCd().equals(prevDirCd)){
							portSkdList.addAll(prevVVD);
							prevVVD.clear();
							prevVVD.addAll(currVVD);
							currVVD.clear();
						}
						
						skdVO = addPortSkd(skdVO, currVVD);
						
						if(firstVoyNo.equals(skdVO.getSkdVoyNo()) && firstDirCd.equals(skdVO.getSkdDirCd())){
							skdVO.setTurnPortFlg("N");
							skdVO.setTurnPortIndCd("N");
						}
						
						// Adding Vistual Port SKD to pre VVD List when First VVD SKD is not
						if(!(firstVoyNo.equals(skdVO.getSkdVoyNo()) && firstDirCd.equals(skdVO.getSkdDirCd()))
								//2013-10-29 ktk
								&& prevVVD.size() > 0){
							// After Virtual Port Managing, get turning information
							skdVO = addVirtualPortSkd(skdVO, prevVVD);
							
							// updating port skd with include Turning info
							currVVD.set(currVVD.size()-1, skdVO);
						}
						
						prevDirCd = skdVO.getSkdDirCd();
							
					}
					
//					if(oneWayDir){
//					if(oneWayDirMap.get(vslCdMap.get(vslCd))){
					if("true".equals(oneWayDirStr)){
						portSkdList.addAll(prevVVD);
						prevVVD.clear();
						prevVVD.addAll(currVVD);
						currVVD.clear();
					}
					
				}
				
				// prevVVD, currVVD-last row- include result lost
				portSkdList.addAll(prevVVD);
				prevVVD.clear();
				portSkdList.addAll(currVVD);
				currVVD.clear();
				
			}
			
			// ---------- Step3. Changing list include Virtual Port END ----------
			
			log.info("Step4-Start");
			
			// ---------- Step4. Selecting data to save VSK_VSL_SKD START ----------
				
			List<VskSwapCstVvdVO> vslSkdList = new ArrayList<VskSwapCstVvdVO>();
			Map<String, String> keyMap = new HashMap<String, String>();
			String key = null;
			
			log.info("portSkdList.size():"+portSkdList.size());
			
			for(VskSwapCstPortVO portSkdVO : portSkdList){
				
				String startPortCd = null;
				String firstPortBerthDate = null;
				
				key = portSkdVO.getVslCd() + ":" + portSkdVO.getSkdVoyNo() + ":" + portSkdVO.getSkdDirCd();
				
				// because VVD is key in VSK_VSL_SKD, then pick up one data per VVD
				if(keyMap.containsKey(key)){
					continue;
				}else{
					keyMap.put(key, key);
					startPortCd = portSkdVO.getVpsPortCd();
					firstPortBerthDate = portSkdVO.getVpsEtbDt();
				}
				
				VskSwapCstVvdVO vslSkdVO = new VskSwapCstVvdVO();
				vslSkdVO.setVslCd(portSkdVO.getVslCd());
				vslSkdVO.setSkdVoyNo(portSkdVO.getSkdVoyNo());
				vslSkdVO.setSkdDirCd(portSkdVO.getSkdDirCd());
				vslSkdVO.setSlanCd(portSkdVO.getSlanCd());
				
				if(vesselVOs.containsKey(portSkdVO.getVslCd())){
					MdmVslCntrVO mdmVslCntrVO = vesselVOs.get(portSkdVO.getVslCd());
					if("T".equals(mdmVslCntrVO.getVslClssFlg())){
						vslSkdVO.setSkdStsCd("RDY");
					}else{
						vslSkdVO.setSkdStsCd("ACT");
					}
				}
				
				vslSkdVO.setSkdUsdIndCd("H");
//				vslSkdVO.setPfSkdTpCd(longRangeSkdGRPVO.getPfSvcTpCd());
				vslSkdVO.setPfSkdTpCd(pfSvcTpCdMap.get(portSkdVO.getVslCd()+portSkdVO.getSkdVoyNo()));
				
				vslSkdVO.setStPortCd(startPortCd);
				vslSkdVO.setN1stPortBrthDt(firstPortBerthDate);
				vslSkdVO.setCoCd("H");
				vslSkdVO.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
				vslSkdVO.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
				
				vslSkdList.add(vslSkdVO);
				
			}

//			log.info("vslSkdList.size():"+vslSkdList.size()+"/skdRmk.length:"+skdRmk.length);
			
			for(int i=0; i<vslSkdList.size(); i++){
				VskSwapCstVvdVO vslSkdVO = vslSkdList.get(i);
//				if(oneWayDir){
//					vslSkdVO.setSkdRmk(skdRmk[i*4]);
//				}else{
//					vslSkdVO.setSkdRmk(skdRmk[(i/2)*4]);
//				}
				vslSkdVO.setSkdRmk(skdRmkMap.get(vslSkdVO.getVslCd()+vslSkdVO.getSkdVoyNo()));
				
			}
			
			// Create PSDO_VVD_CD
			// "FD" + YYMMDD(first PORT VPS_ETD_DT) + "E"
			String vslSkdVvd = null;
			String portSkdVvd = null;
			for(VskSwapCstVvdVO vslSkdVO : vslSkdList){
				
				vslSkdVvd = vslSkdVO.getVslCd() + ":" + vslSkdVO.getSkdVoyNo() + ":" + vslSkdVO.getSkdDirCd();
				for(VskSwapCstPortVO portSkdVO : portSkdList){
					portSkdVvd = portSkdVO.getVslCd() + ":" + portSkdVO.getSkdVoyNo() + ":" + portSkdVO.getSkdDirCd();
					
					if(vslSkdVvd.equals(portSkdVvd)){
						
						// Setting PSDO_VVD_CD
						vslSkdVO.setPsdoVvdCd("FD" + getDateString("yyMMdd", "yyyyMMddHHmm", portSkdVO.getVpsEtbDt()) + "E");
						
						break;
					}
				}
	
			}
		
		// ---------- Step4. Selecting data to save VSK_VSL_SKD END ----------
		
		log.info("Step5-Start");
		
		// ---------- Step5. Saving Simulation SKD START ----------
			
			List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
			for(VskSwapCstVvdVO vslSkdVO : vslSkdList){
				VskVslSkdVO vo = new VskVslSkdVO();
				vo.setVslCd(vslSkdVO.getVslCd());
				vo.setSkdVoyNo(vslSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(vslSkdVO.getSkdDirCd());
				vo.setVslSlanCd(vslSkdVO.getSlanCd());
				vo.setSkdStsCd(vslSkdVO.getSkdStsCd());
				vo.setSkdUsdIndCd("H");
//				vo.setPfSkdTpCd(longRangeSkdGRPVO.getPfSvcTpCd());
//				vo.setPfSkdTpCd(vslCdMap.get(vslSkdVO.getVslCd()));
				vo.setPfSkdTpCd(pfSvcTpCdMap.get(vslSkdVO.getVslCd()+vslSkdVO.getSkdVoyNo()));
				
				vo.setStPortCd(vslSkdVO.getStPortCd());
				vo.setN1stPortBrthDt(vslSkdVO.getN1stPortBrthDt());
				vo.setCoCd("H");
				vo.setSkdRmk(vslSkdVO.getSkdRmk());
				vo.setCreUsrId(longRangeSkdGRPVO.getCreUsrId());
				vo.setUpdUsrId(longRangeSkdGRPVO.getUpdUsrId());
				vo.setPsdoVvdCd(vslSkdVO.getPsdoVvdCd());

//				log.info(vo.getVslCd()+"/"+vo.getSkdVoyNo()+"/"+vo.getSkdDirCd());
				
				vskVslSkdList.add(vo);
				
			}
			
			log.info("vskVslSkdList.size():"+vskVslSkdList.size());
			
			dbDao.addVskVslSkd(vskVslSkdList);				// VSK_VSL_SKD
			// :: VIPS START ::
			// System.out.println("VIPS[addVskVslSkd3]");
			for(VskVslSkdVO vo : vskVslSkdList) {
				List<VskVslSkdVO> list = dbDao.searchVskVslSkdByVVD(vo);
				for(VskVslSkdVO row : list) {
					this.mVskVslSkdList.add(row);
				}
			}
			// :: VIPS END ::
			longRangeSkdGRPVO.setVskVslSkdList(vskVslSkdList);
			
			List<VslPortSkdVO> 	vskVslPortSkdList 			= new ArrayList<VslPortSkdVO>();

			/********************************************************
			 * Setting the indicator of first virtual port
			 * 		for creation default consortium voyage number
			 * ------------------------------------------------------
			 **/
			String				sFirstDirCd					= "";
			String				sSecondDirFirstTurnPortCd	= "";
			String				sFirstVirPortCd				= "";
			String				sFirstVirClptIndSeq			= "";
			String				sCurrVVD					= "";
			String				sNextVVD					= "";
			/********************************************************/
			
			for(VskSwapCstPortVO portSkdVO : portSkdList){
				
				if(portSkdVO.getInitEtaDt()==null){
					continue;
				}
				
				VslPortSkdVO vo = new VslPortSkdVO();
				
				/********************************************************
				 * Setting the indicator of first virtual port
				 * 		for creation default consortium voyage number
				 * ======================================================
				 * 2015-05-15 by TOP
				 * ------------------------------------------------------
				 **/
				sCurrVVD	= portSkdVO.getVslCd()+portSkdVO.getSkdVoyNo()+portSkdVO.getSkdDirCd();
				
				if(!sCurrVVD.equals(sNextVVD)){
					
					sFirstDirCd					= "";
					sSecondDirFirstTurnPortCd	= "";
					sFirstVirPortCd				= "";
					sFirstVirClptIndSeq			= "";
					sCurrVVD					= "";
					sNextVVD					= "";
					
					for(VskSwapCstPortVO tmpVO : portSkdList){
						if("".equals(sFirstDirCd))																sFirstDirCd					= tmpVO.getSkdDirCd();
						if("".equals(sSecondDirFirstTurnPortCd) && !sFirstDirCd.equals(tmpVO.getSkdDirCd()))	sSecondDirFirstTurnPortCd	= tmpVO.getSkdDirCd();
						if("".equals(sFirstVirPortCd) && "Y".equals(tmpVO.getTurnPortFlg())){
							sFirstVirPortCd		= tmpVO.getVpsPortCd();
							sFirstVirClptIndSeq	= tmpVO.getClptIndSeq();
							break;
						}					
					}
				}
				
				//:2015-05-15:://if(sFirstDirCd.equals(portSkdVO.getSkdDirCd()) && sFirstVirPortCd.equals(portSkdVO.getVpsPortCd()) && sFirstVirClptIndSeq.equals(portSkdVO.getClptIndSeq())){
				if(sFirstDirCd.equals(portSkdVO.getSkdDirCd()) && sFirstVirPortCd.equals(portSkdVO.getVpsPortCd())){
					vo.setFirstVirPortFlg("Y");	
				}else{
					vo.setFirstVirPortFlg("N");	
				}
				
				sNextVVD	= portSkdVO.getVslCd()+portSkdVO.getSkdVoyNo()+portSkdVO.getSkdDirCd();
				/********************************************************/
				
				vo.setVslCd(portSkdVO.getVslCd());
				vo.setSkdVoyNo(portSkdVO.getSkdVoyNo());
				vo.setSkdDirCd(portSkdVO.getSkdDirCd());
				vo.setVpsPortCd(portSkdVO.getVpsPortCd());
				vo.setNewClptIndSeq(portSkdVO.getClptIndSeq());
				vo.setClptSeq(portSkdVO.getClptSeq());
				vo.setSlanCd(portSkdVO.getSlanCd());
				vo.setPortSkdStsCd(portSkdVO.getPortSkdStsCd());
				if (portSkdVO.getYdCd().length() == 2) {
					vo.setYdCd(portSkdVO.getVpsPortCd()+portSkdVO.getYdCd());
				} else {
					vo.setYdCd(portSkdVO.getYdCd());	
				}
				
				vo.setCallYdIndSeq(portSkdVO.getCallYdIndSeq());
				vo.setPfEtaDt(portSkdVO.getPfEtaDt());
				vo.setPfEtbDt(portSkdVO.getPfEtbDt());
				vo.setPfEtdDt(portSkdVO.getPfEtdDt());
				vo.setInitEtaDt(portSkdVO.getInitEtaDt());
				vo.setInitEtbDt(portSkdVO.getInitEtbDt());
				vo.setInitEtdDt(portSkdVO.getInitEtdDt());
				vo.setVpsEtaDt(portSkdVO.getVpsEtaDt());
				vo.setVpsEtbDt(portSkdVO.getVpsEtbDt());
				vo.setVpsEtdDt(portSkdVO.getVpsEtdDt());
				vo.setPortSkpTpCd(portSkdVO.getPortSkpTpCd());
				vo.setPortSkpRsnCd(portSkdVO.getPortSkpRsnCd());
				vo.setPortSkpRsnOffrRmk(portSkdVO.getPortSkpRsnOffrRmk());
				vo.setTtlDlayHrs(portSkdVO.getTtlDlayHrs());
				vo.setTsPortCd(portSkdVO.getTsPortCd());
				vo.setUsdFlg(portSkdVO.getUsdFlg());
				vo.setNoonRptInpFlg(portSkdVO.getNoonRptInpFlg());
				vo.setDepRptInpFlg(portSkdVO.getDepRptInpFlg());
				vo.setActInpFlg(portSkdVO.getActInpFlg());
				vo.setPrtChkFlg(portSkdVO.getPrtChkFlg());
				vo.setCreUsrId(portSkdVO.getCreUsrId());
				vo.setUpdUsrId(portSkdVO.getUpdUsrId());
				vo.setVslDlayRsnCd(portSkdVO.getVslDlayRsnCd());
				vo.setVslDlayRsnDesc(portSkdVO.getVslDlayRsnDesc());
				vo.setShpCallNo(portSkdVO.getShpCallNo());
				vo.setShpCallNoUpdUsrId(portSkdVO.getShpCallNoUpdUsrId());
				vo.setShpCallNoUpdDt(portSkdVO.getShpCallNoUpdDt());
				vo.setTmlVoyNo(portSkdVO.getTmlVoyNo());
				vo.setTmlVslCd(portSkdVO.getTmlVslCd());
				vo.setFtDt(portSkdVO.getFtDt());
				vo.setPlismYdCd(portSkdVO.getPlismYdCd());
				vo.setPlismVoyNo(portSkdVO.getPlismVoyNo());
				vo.setPlismVslCd(portSkdVO.getPlismVslCd());
				vo.setSkdCngStsCd(portSkdVO.getSkdCngStsCd());
				vo.setTurnPortFlg(portSkdVO.getTurnPortFlg());
				vo.setTurnPortIndCd(portSkdVO.getTurnPortIndCd());
				vo.setTurnSkdVoyNo(portSkdVO.getTurnSkdVoyNo());
				vo.setTurnSkdDirCd(portSkdVO.getTurnSkdDirCd());
				vo.setTurnClptIndSeq(portSkdVO.getTurnClptIndSeq());
				vo.setIbCgoQty(portSkdVO.getIbCgoQty());
				vo.setObCgoQty(portSkdVO.getObCgoQty());
				vo.setVpsRmk(portSkdVO.getVpsRmk());
				vo.setPhsIoRsnCd(portSkdVO.getPhsIoRsnCd());
				vo.setPhsIoRmk(portSkdVO.getPhsIoRmk());
				vo.setSkdBrthNo(portSkdVO.getSkdBrthNo());
				vo.setInitSkdInpFlg("Y");
				vo.setOfcInpFlg(portSkdVO.getOfcInpFlg());
				vo.setSeaBufHrs(portSkdVO.getSeaBufHrs());
				vo.setPortBufHrs(portSkdVO.getPortBufHrs());
				
				/*
				 * Trunk/Feeder Long Range Schedule �앹꽦, Creation by VVD, Add Calling
				 * AutoSkdCngFlg���곹깭 媛믪쓣 DEFAULT媛믪� 'Y'濡��ㅼ젙
				 * 2015.03.16 
				 */
				vo.setAutoSkdCngFlg("Y");
				
				vskVslPortSkdList.add(vo);
			}
			
			// last row(turning port = F) does not save in Long Range SKD Creation
			if("F".equals(vskVslPortSkdList.get(vskVslPortSkdList.size()-1).getTurnPortFlg())){
				vskVslPortSkdList.remove(vskVslPortSkdList.size()-1);
			}
			
			
			if(vskVslPortSkdList != null && vskVslPortSkdList.size()>0){
				log.info("vskVslPortSkdList.size() ["+vskVslPortSkdList.size()+"]");
				dbDao.addVskVslPortSkd(vskVslPortSkdList);		/** VSK_VSL_PORT_SKD **/
				// :: VIPS START ::
				// System.out.println("VIPS[addVskVslPortSkd4]");
				for(VslPortSkdVO vslPortSkdVO : vskVslPortSkdList) {
					VskVslPortSkdVO vo = new VskVslPortSkdVO();
					vo.setVslCd(vslPortSkdVO.getVslCd());
					vo.setSkdVoyNo(vslPortSkdVO.getSkdVoyNo());
					vo.setSkdDirCd(vslPortSkdVO.getSkdDirCd());
					vo.setVpsPortCd(vslPortSkdVO.getVpsPortCd());
					vo.setClptIndSeq(vslPortSkdVO.getClptIndSeq());
					List<VskVslPortSkdVO> list = dbDao.searchVskVslPortSkdByVVD(vo);
					for(VskVslPortSkdVO row : list) {
						this.mVslPortSkdList.add(row);
					}
				}
				// :: VIPS END ::
			}else{
				log.info("vskVslPortSkdList is ["+vskVslPortSkdList == null+"]");
			}

			
			log.info("Step-End");
			
			return longRangeSkdGRPVO;

		}catch(DAOException ex){
			log.error("err " + ex.toString(), ex);
			
			if(ex.toString().indexOf("FRM10501")>-1 || ex.toString().indexOf("TimedOutException")>-1){
				throw new EventException(new ErrorHandler("VSK10076").getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
			}
			
		} catch (EventException e) {
			throw e;
		}catch(Exception e){
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), e);
		}
		
		// ---------- Step5. Saving Simulation SKD END  ----------		
				
	}
	
	/**
	 * checkVslVoyContains
	 * 
	 * @param boolean boolSeqVoy
	 * @param List<String> vslList
	 * @param List<String> voyList
	 * @param String vslCd
	 * @param String voyNo
	 * @param int vslCnt
	 * @param int rowCnt
	 * @return boolean
	 */
	public boolean checkVslVoyContains(boolean boolSeqVoy, List<String> vslList, List<String> voyList, String vslCd, String voyNo, int vslCnt, int rowCnt){
		
		boolean reBool = false;
		int tmpVoyNo = 1;
				
		if(boolSeqVoy){
			for(int i=0 ; i<voyList.size() ; i++){
				for(int j=0 ; j<rowCnt ; j++){
					tmpVoyNo = Integer.parseInt(voyList.get(i)) + (j * vslCnt);
					if(vslList.contains(vslCd) && Integer.parseInt(voyNo) == tmpVoyNo){
						reBool = true;
						break;
					}
				}
				if(reBool){
					break;
				}
			}
		}else{ 
			if(vslList.contains(vslCd)){
				reBool = true;
			}	
		}
		
		return reBool;
	}
	

	

	/**
	 * Creation for Vessel Schedule History without Bookings<br>
	 *
	 * @param List<VslSkdXtraHisVO> vslSkdXtraHisVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	public void createVesselScheduleExtraChangeHistory(List<VslSkdXtraHisVO> vslSkdXtraHisVOs, String sFromEventSystem) throws EventException {
		
		try{
		
			/******************************************************************************
			 * Change Notification Back End Job 泥섎━
			 */
			this.createVesselScheduleExtraChangeHistoryBackEndJob(vslSkdXtraHisVOs, sFromEventSystem);

		} catch (Exception ex) {
			/*
			 * MSG - �쒕퉬���ㅽ뻾以��ㅻ쪟媛�諛쒖깮�섏��듬땲��
			 */
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	
	/**
	 * Vessel Schedule 蹂�꼍�대젰愿�━<br>
	 *
	 * @param List<VslSkdXtraHisVO> vslSkdXtraHisVOs
	 * @param String sFromEventSystem
	 * @return String
	 * @exception EventException
	 */
	public String createVesselScheduleExtraChangeHistoryBackEndJob(List<VslSkdXtraHisVO> vslSkdXtraHisVOs, String sFromEventSystem) throws EventException {
		
		String 												backendJobKey		= null;
		VesselScheduleExtraChangeHistCreationBackEndJob 	backEndCommand		= new VesselScheduleExtraChangeHistCreationBackEndJob();
		BackEndJobManager 									backEndJobManager 	= new BackEndJobManager();
		
		try {
			
			if(vslSkdXtraHisVOs == null || vslSkdXtraHisVOs.size() == 0)	return null;
			
			backEndCommand.setVslSkdCngHisDtlVOs(vslSkdXtraHisVOs	);
			backEndCommand.setFromEventSystem	(sFromEventSystem	);
			
			backendJobKey	= backEndJobManager.execute(backEndCommand, "VSK_byTOP", "manageVslSkdXtraCngHistCreation");

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return backendJobKey;
	}
	

	/**
	 * Checking VVD ETD
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return int
	 * @exception EventException
	 */
	public int checkVskVslPortSkdEtd(VslPortSkdVO vslPortSkdVO) throws EventException {
		int rtn = 0;
		try{
			// checking Turnning Port exist
			VvdCheckVO vvdCheckVO 	= dbDao.checkVskVslPortSkd(vslPortSkdVO);

			rtn = vslPortSkdVO.getVpsEtaDt().compareTo(vvdCheckVO.getVpsEtdDt());
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return rtn;
	}
	
	/**
	 * Checking VPS Reverse or not
	 * 
	 * @param VslPortSkdVO vslPortSkdVO
	 * @return boolean
	 * @exception EventException
	 * @author TOP
	 */
	public boolean isReverseVesselPortSchedule(VslPortSkdVO vslPortSkdVO) throws EventException {
		
		boolean isReverse = false;
		
		try{
			// checking Turnning Port exist
			isReverse	= dbDao.isReverseVesselPortSchedule	(vslPortSkdVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return isReverse;
	}
	
	
}

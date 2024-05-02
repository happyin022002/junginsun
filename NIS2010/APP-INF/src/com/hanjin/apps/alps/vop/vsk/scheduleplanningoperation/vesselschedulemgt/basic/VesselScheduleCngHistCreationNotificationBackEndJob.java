/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleCngHistCreationNotificationBackEndJob.java
*@FileTitle : Vessel Schedule Change Notification  Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.27
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.08.27 정상기
* 1.0 Creation
* 
* History
* 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
* 2015.08.10 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration.ScheduleNotificationManagementDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration.ScheduleNotificationManagementEAIDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo.VslSkdCngNotificationTransmitLogVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration.VSKCodeFinderDBDAO;
//import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * Vessel Schedule Change Notification Back End Job Basic Command implementation<br>
 * @author JEONG SANKG-KI
 * @see VOP_VSK_0015 참조
 * @since J2EE 1.6
 */

public class VesselScheduleCngHistCreationNotificationBackEndJob extends BackEndCommandSupport {


	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;
	
	/**
	 * Change Notification
	 */
	private List<VskVslSkdVO> vskVslSkdVOs;
	
	/**
	 * Change Notification
	 */
	private List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs;
	
	/**
	 * Change Notification
	 */
	//private List<VslSkdCngNotificationTransmitLogVO> vslSkdCngNtfcTrsmLogVOs;
	
	/**
	 * Change Notification
	 */
	private String sFromEventSystem;
	
	/**
	 * Change Notification
	 */
	//private String sCnvtHisCreUserId;
	
	
	/**
	 * Change Notification
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 */
	public void setVslSkdVOs(List<VskVslSkdVO> vskVslSkdVOs) {
		this.vskVslSkdVOs = vskVslSkdVOs;
	}
	
	/**
	 * Change Notification
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 */
	public void setVslSkdCngHisDtlVOs(List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs) {
		this.vslSkdCngHisDtlVOs = vslSkdCngHisDtlVOs;
	}
	
	/**
	 * Change Notification
	 * @param VslSkdCngHisVO vslSkdCngHisVO
	 */
	//public void setVslSkdCngHisVOs(List<VslSkdCngNotificationTransmitLogVO> vslSkdCngNtfcTrsmLogVOs) {
	//	this.vslSkdCngNtfcTrsmLogVOs = vslSkdCngNtfcTrsmLogVOs;
	//}
	
	/**
	 * Change Notification
	 * @param String sCnvtHisCreUserId
	 */
	//public void setCnvtHisCreUserId(String sCnvtHisCreUserId) {
	//	this.sCnvtHisCreUserId = sCnvtHisCreUserId;
	//}
	
	/**
	 * Change Notification
	 * @param VslSkdCngHisVO vslSkdCngHisVO
	 */
	public void setFromEventSystem(String sFromEventSystem) {
		this.sFromEventSystem = sFromEventSystem;
	}
	
	/**
	 * Change Notification 실행반영한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		this.manageVslSkdCngHistCreationNotification(this.vskVslSkdVOs, this.vslSkdCngHisDtlVOs, this.sFromEventSystem); 
		return null;
	}
	
	/**
	 * Vessel Schedule 변경사항에 대한 이력발송<br>
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	private void manageVslSkdCngHistCreationNotification(List<VskVslSkdVO> vskVslSkdVOs, List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs, String sFromEventSystem) throws EventException {
		
		try {
			
			if(vskVslSkdVOs == null || vskVslSkdVOs.size() == 0)	return;
			
			/***************************************************************************************
			 * vslSkdCngHisDtlVOs is NULL		: Normal 이력데이터 생성
			 * vslSkdCngHisDtlVOs is NOT NULL	: Vessel Schedule History "VO"를 이용한 이력데이터 생성
			 */
			
			/**
			 *                				::CREATION/UPDATE 	::UI ID + UI NAME						::BC.Method Name
			 * -------------------------------------------------------------------------
			 * DELETE_CST_ByVvd				: DELETE			VOP_VSK_0015 (COSTAL SKD UPDATE)		::removeCstSkdByVvd.removeCstSkdByVvd
			 * DELETE_DeletionVvd_NoneBKG	: DELETE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::removeCstSkdByVvd.removeCstSkdByVvd
			 * DELETE_DeletionVvd_OnBKG		: DELETE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::manageCstSkdByVvd.removeCstSkdByVvd
			 * ACTIVATE_ByVvd				: UPDATE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::manageSkdActivate
			 * MODIFY_VvdStatusChange		: UPDATE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::modifyVslSkdListByLane
			 * MODIFY_VvdProformaType		: UPDATE			VOP_VSK_0018 (VSL SKD Deletion/Closing)	::manageVvdPf
			 */

			VesselScheduleMgtDBDAO 		dbDao 	= new VesselScheduleMgtDBDAO();
			
			List<VslSkdCngHisVO> 	vslSkdCngHisVOs 	= new ArrayList<VslSkdCngHisVO>();

			String			sCnvtVslSkdCngTpCd	= null;
			String			sCnvtHisCreUserId	= null;
			String			sSkdHisDesc			= null;
			StringBuffer	sbTmpDesc			= new StringBuffer("");
			
			/***************************************************************************************
			 * vslSkdCngHisDtlVOs is NULL		: Normal 이력데이터 생성
			 * vslSkdCngHisDtlVOs is NOT NULL	: Vessel Schedule History "VO"를 이용한 이력데이터 생성
			 * 
			 */
			
			/*******************************************************************************************************************
			 *                				::CREATION/UPDATE 	::UI ID + UI NAME						::Method Name
			 * -----------------------------------------------------------------------------------------------------------------
			 * CREATION_LRS 				::CREATION          ::VOP_VSK_0010(LONG RANGE SKD CREATION)::createLongRngSkd
			 * -----------------------------------------------------------------------------------------------------------------
			 * UPDATE_CST_ByVvd				::UPDATE			::VOP_VSK_0015(COSTAL SKD UPDATE)		::manageCstSkdByVvd
			 * INSERT_CST_ByVvd_NormalPort	::INSERT			::VOP_VSK_0014/0015						::manageCstSkdByVvd
			 * INSERT_CST_ByVvd_VirtualPort	::INSERT			::VOP_VSK_0014/0015						::manageCstSkdByVvd 
			 * -----------------------------------------------------------------------------------------------------------------
			 * UPDATE_ACT_AutoUpdate		::UPDATE			::VOP_VSK_0025+EDI+ESVC					::manageCstSkdByActual
			 * -----------------------------------------------------------------------------------------------------------------
			 * UPDATE_CST_ByBrthWdo			::UPDATE			::VOP_VSK_0017(DAILY BERTH WINDOW)		::manageCstSkdBerthWdo
			 * -----------------------------------------------------------------------------------------------------------------
			 */
			
			String	sCurTime		= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
			String	sCarriageReturn	= "\n";
			
			if("CREATION_LRS".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "N";		//NEW//
				sCnvtHisCreUserId	= "LRS_(VOP_VSK_0010)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("CRE TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Long Range SKD Creation (VOP_VSK_0010)");
				sbTmpDesc.append(sCarriageReturn);				
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			//----------------------------------------------------------------------//
			//----------------------------------------------------------------------//				
				
			}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "I";		//NORMAL/TURNING PORT INSERT//
				sCnvtHisCreUserId	= "CST_NorPortIns(0014)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Creation by VVD (VOP_VSK_0014)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0015)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "I";		//NORMAL/TURNING PORT INSERT//
				sCnvtHisCreUserId	= "CST_NorPortIns(0015)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : CST SKD Update (VOP_VSK_0015)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0057)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "I";		//NORMAL/TURNING PORT INSERT//
				sCnvtHisCreUserId	= "CST_NorPortIns(0057)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Creation by VVD - CCA (VOP_VSK_0057)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0058)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "I";		//NORMAL/TURNING PORT INSERT//
				sCnvtHisCreUserId	= "CST_NorPortIns(0058)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : CST SKD Update - CCA (VOP_VSK_0058)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "I";		//NORMAL/TURNING PORT INSERT//
				sCnvtHisCreUserId	= "CST_NorPortIns(ESVC)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : E-SVC WebServices CCA SKD Creation by VVD (VOP_VSK_SPP_VSK_0005)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			//----------------------------------------------------------------------//	
				
			}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "J";		//VIRTUAL PORT INSERT//
				sCnvtHisCreUserId	= "CST_VirPortIns(0014)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Creation by VVD (VOP_VSK_0014)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : ADD VIRTUAL PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0015)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "J";		//VIRTUAL PORT INSERT//
				sCnvtHisCreUserId	= "CST_VirPortIns(0015)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : CST SKD Update (VOP_VSK_0015)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : ADD VIRTUAL PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0057)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "J";		//VIRTUAL PORT INSERT//
				sCnvtHisCreUserId	= "CST_VirPortIns(0057)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Creation by VVD - CCA (VOP_VSK_0057)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : ADD VIRTUAL PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0058)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "J";		//VIRTUAL PORT INSERT//
				sCnvtHisCreUserId	= "CST_VirPortIns(0058)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : CST SKD Update - CCA (VOP_VSK_0058)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : ADD VIRTUAL PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "J";		//VIRTUAL PORT INSERT//
				sCnvtHisCreUserId	= "CST_VirPortIns(ESVC)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("INS TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : E-SVC WebServices CCA SKD Creation by VVD (VOP_VSK_SPP_VSK_0005)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("RMK : ADD VIRTUAL PORT");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			//----------------------------------------------------------------------//
			//----------------------------------------------------------------------//
				
			}else if("UPDATE_CST_ByVvd(VOP_VSK_0014)".equals(sFromEventSystem)){	
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "CST_(VOP_VSK_0014)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Creation by VVD (VOP_VSK_0014)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("UPDATE_CST_ByVvd(VOP_VSK_0015)".equals(sFromEventSystem)){	
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "CST_(VOP_VSK_0015)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : C/SKD Update (VOP_VSK_0015)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);			
				
			}else if("UPDATE_CST_ByVvd(VOP_VSK_0057)".equals(sFromEventSystem)){	
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "CST_(VOP_VSK_0057)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : VSL SKD Creation by VVD - CCA (VOP_VSK_0057)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);		
				
			}else if("UPDATE_CST_ByVvd(VOP_VSK_0058)".equals(sFromEventSystem)){	
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "CST_(VOP_VSK_0058)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : C/SKD Update - CCA (VOP_VSK_0058)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);		
				
			}else if("UPDATE_CST_ByVvd(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)){	
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "CST_(ESVC)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : E-SVC WebServices CCA SKD Creation by VVD (VOP_VSK_SPP_VSK_0005)");
				sbTmpDesc.append(sCarriageReturn);	
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);		
						
			
			//----------------------------------------------------------------------//
			//----------------------------------------------------------------------//
				
			}else if("UPDATE_ACT_AutoUpdate(VOP_VSK_0025)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "T";		//AUTO UPDATE//
				sCnvtHisCreUserId	= "ACT_AU(VOP_VSK_0025)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Actual SKD Creation (VOP_VSK_0025)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("UPDATE_ACT_AutoUpdate(VOP_VSK_SPP_VSK_0003)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "T";		//AUTO UPDATE//
				sCnvtHisCreUserId	= "ACT_AU(ESVC)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("PGM : ESVC - FEEDER");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("UPDATE_ACT_AutoUpdate(IF_EDI_SVC)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "T";		//AUTO UPDATE//
				sCnvtHisCreUserId	= "ACT_AU(EDI)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("PGM : IFTSAI EDI");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("UPDATE_ACT_AutoUpdate(IF_EDI_SVC(VOP_VSK_0027))".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "T";		//AUTO UPDATE//
				sCnvtHisCreUserId	= "ACT_AU(EDI-VSK_0027)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Actual SKD Input Ratio Report.EDI SKD Monitoring (VOP_VSK_0027)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("RMK : AUTO UPDATE by UI-EDI RETRY SEND");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);				
				
			//----------------------------------------------------------------------//
			}else if("UPDATE_CST_ByBrthWdo(VOP_VSK_0017)".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "CST_(VOP_VSK_0017)";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : Daily Berth Window (VOP_VSK_0017)");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);
				
			}else if("EDI_XCH_AUTO_MAPPING".equals(sFromEventSystem)){
				sCnvtVslSkdCngTpCd	= "U";		//NORMAL UPDATE//
				sCnvtHisCreUserId	= "XCH_SKD_ALLIANCE";
				
				sbTmpDesc.append("=== Vessel Schedule HISTORY CREATION (MASTER+DETAIL) === ");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UPD TIME : ["+sCurTime+"]");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("UI : EDI (EXCHANGE ALLIANCE SKD");
				sbTmpDesc.append(sCarriageReturn);
				sbTmpDesc.append("======================================================== ");
				sbTmpDesc.append(sCarriageReturn);				
				
			}else{
				sCnvtVslSkdCngTpCd	= "";
				sCnvtHisCreUserId	= "NO_ACCOUNT_USER_ID";
			}
			
			sSkdHisDesc		= sbTmpDesc.toString();
			
			if(vslSkdCngHisDtlVOs == null){
					
				if (vskVslSkdVOs != null && vskVslSkdVOs.size()>0) {
					
					/* ============================================================================
					 * Vessel Schedule History 관리(Header) Started ::2013-07-30::
					 * ----------------------------------------------------------------------------
					 * <TABLE NAME>
					 * 1. VSK_VSL_SKD_CNG_HIS
					 * 2. VSK_VSL_SKD_CNG_HIS_DTL
					 * ----------------------------------------------------------------------------
					 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
					 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
					 * ============================================================================
					 */
					
					/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
					 * VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD V1
					 * - sVslSkdCngTpCd
					 * ------------------------------------------------------
					 * 'N' : Vessel Schedule 최초생성. 
					 * ------------------------------------------------------
					 * 'U' : Normal UPDATE
					 * 'S' : Port SKIP
					 * 'O' : Phase OUT
					 * 'V' : VVD DELETE
					 * 'L' : Lane 변경
					 * 'E' : ETA, ETB, ETD
					 * 'Y' : YARD 변경
					 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
					 * ------------------------------------------------------
					 * 'A' : Activate
					 * 'T' : Auto Update (by Actual Schedule)
					 * ------------------------------------------------------
					 * 'M' : Holding/Turning Port INSERT
					 * 'I' : Normal/Turning Port INSERT
					 * 'J' : Virtual Port INSERT
					 * 'F' : Proforma Type Update
					 * ------------------------------------------------------
					 */
										
					for(VskVslSkdVO 	tmpVslSkdVO : vskVslSkdVOs){
						
						/****
						 * VslSkdCngHisVO Setting. (1)
						 * - tmpVslSkdCngHisVO
						 */
						
						VslSkdCngHisVO 			tmpVslSkdCngHisVO 	= new VslSkdCngHisVO();
						List<VslSkdCngHisVO>	tmpVslSkdCngHisVOs	= new ArrayList<VslSkdCngHisVO>();
						
						tmpVslSkdCngHisVO.setVslCd		(tmpVslSkdVO.getVslCd	());
						tmpVslSkdCngHisVO.setSkdVoyNo	(tmpVslSkdVO.getSkdVoyNo());
						tmpVslSkdCngHisVO.setSkdDirCd	(tmpVslSkdVO.getSkdDirCd());
						
						tmpVslSkdCngHisVOs.add	(tmpVslSkdCngHisVO);
						
						String sVvdHisSeq		= dbDao.createVslSkdChangeVvdHisSeq(tmpVslSkdCngHisVOs);
						tmpVslSkdCngHisVO.setVvdHisSeq	(sVvdHisSeq			);
	
						tmpVslSkdCngHisVO.setVskdCngTpCd(sCnvtVslSkdCngTpCd	);		/* Setting :: VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD */
						tmpVslSkdCngHisVO.setHisCreUsrId(sCnvtHisCreUserId	);		/* Setting :: VSK_VSL_SKD_CNG_HIS.HIS_CRE_USR_ID */
						tmpVslSkdCngHisVO.setSkdHisDesc	(sSkdHisDesc		);		/* Setting :: VSK_VSL_SKD_CNG_HIS.SKD_HIS_DESC 	 */
						
						log.info("\n\n ::jskjskjsk:: createVslSkdChangeHistory.sVvdHisSeq ["+sVvdHisSeq+"]");
						/****
						 * VslSkdCngHisVO Setting. (2)
						 * - tmpVslSkdCngHisVO
						 */
	
						/* VSK_VSL_SKD_CNG_HIS_DTL INSERT용 VO 만들기 */
						vslSkdCngHisVOs.add		(tmpVslSkdCngHisVO	);
					
					}
					
					dbDao.createVslSkdChangeHistory	(vslSkdCngHisVOs);	
				}
				
				if(vslSkdCngHisVOs != null && vslSkdCngHisVOs.size()>0){
					if("CREATION_LRS".equals(sFromEventSystem)){
						//NORMAL CASE : INSERT ONLY + NONE NOTIFICATION
						this.createVslSkdChangeHistoryDetailInsertOnly		(vslSkdCngHisVOs, sFromEventSystem, sCnvtHisCreUserId);	
					}else{
						//ACTUAL SCHEDULE AUTO UPDATE
						/***
						 * 1. ACTUAL SKD 입력에 따른 COASTAL SKD AUTO UPDATE
						 * 2. 기타 : NOTIFICATION 필요한 경우
						 */
						this.createVslSkdChangeHistoryDetailAutoUpdateOther	(vslSkdCngHisVOs, sFromEventSystem, sCnvtHisCreUserId);	
					}
				}
				
			}else if(vslSkdCngHisDtlVOs != null && vslSkdCngHisDtlVOs.size()>0){
				
				this.createVslSkdChangeHistoryDetailMultiNotice(vslSkdCngHisDtlVOs, sCnvtVslSkdCngTpCd, sCnvtHisCreUserId, sSkdHisDesc);
				
			}else{
				return;
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
			
	}
	
	/**
	 * Vessel Schedule History 관리(Header)<br>
	 *
	 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
	 * @param String sFromEventSystem
	 * @param String sCnvtHisCreUserId
	 * @exception EventException
	 */
	public void createVslSkdChangeHistoryDetailInsertOnly(List<VslSkdCngHisVO> vslSkdCngHisVOs, String sFromEventSystem, String sCnvtHisCreUserId) throws EventException {

		try {
		
			if (vslSkdCngHisVOs != null && vslSkdCngHisVOs.size()>0) {
				
				VesselScheduleMgtDBDAO 		dbDao 					= new VesselScheduleMgtDBDAO();
				String						sCvtVslSkdTmlCngTpCd	= null;
				
				/* ============================================================================
				 * Vessel Schedule History 관리(Detail) Started ::2013-07-30::
				 * ----------------------------------------------------------------------------
				 * <TABLE NAME>
				 * 1. VSK_VSL_SKD_CNG_HIS
				 * 2. VSK_VSL_SKD_CNG_HIS_DTL
				 * ----------------------------------------------------------------------------
				 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
				 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
				 * ============================================================================
				 */
				
				/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
				 * VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD V1
				 * - sVslSkdTmlCngTpCd
				 * ----------------------------------------------
				 * 'N' : 최초생성.
				 * ----------------------------------------------
				 * 'U' : Normal UPDATE 
				 * 'S' : Port SKIP
				 * 'I' : Phase IN
				 * 'O' : Phase OUT
				 * 'D' : Port Delete
				 * 'E' : ETA, ETB, ETD 변경
				 * 'Y' : YARD(Terminal) 변경
				 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
				 * 'R' : REVERSE Call
				 * ---------------------------------------------
				 * 'A' : ADD Call
				 * 'T' : AUTO UPDATE (by Acctual Schedule)
				 * ---------------------------------------------
				 */
				
				for(VslSkdCngHisVO tmpVslSkdCngHisVO : vslSkdCngHisVOs){
					
					/****
					 * VslSkdCngHisDtlVO Setting. (1)
					 * - vslSkdCngHisDtlVO
					 */
					VslSkdCngHisDtlVO					tmpVslSkdCngHisDtlVO					= new VslSkdCngHisDtlVO();
					List<VslSkdCngHisDtlVO> 			tmpVslSkdCngHisDtlVOs 					= new ArrayList<VslSkdCngHisDtlVO>();
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVslSkdCngHisVO.getVslCd			()	);
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVslSkdCngHisVO.getSkdVoyNo		()	);
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVslSkdCngHisVO.getSkdDirCd		()	);
					tmpVslSkdCngHisDtlVO.setVvdHisSeq	(tmpVslSkdCngHisVO.getVvdHisSeq		()	);
					tmpVslSkdCngHisDtlVO.setHisCreUsrId	(sCnvtHisCreUserId						);
					
					if("CREATION_LRS".equals(sFromEventSystem)){
						sCvtVslSkdTmlCngTpCd	= "N";
					}else{
						sCvtVslSkdTmlCngTpCd	= "";
					}
					
					tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd		(sCvtVslSkdTmlCngTpCd);	/* Setting :: VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD */
					
					tmpVslSkdCngHisDtlVOs.add					(tmpVslSkdCngHisDtlVO);
					
					dbDao.createVslSkdChangeHistoryDetailByVvd	(tmpVslSkdCngHisDtlVOs);	
				}
				/******** vslSkdHisInVOs is null or size zero :: Finished!!! *************/
				
				/* ----------------------------------------------------------------------------
				 * Vessel Schedule History 관리 Finished ::2013-07-30::
				 * ============================================================================
				 */	
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	
	/**
	 * Vessel Schedule History 관리(Detail+Single Notice)<br>
	 *
	 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
	 * @param String sFromEventSystem
	 * @param String sCnvtHisCreUserId
	 * @exception EventException
	 */
	public void createVslSkdChangeHistoryDetailAutoUpdateOther(List<VslSkdCngHisVO> vslSkdCngHisVOs, String sFromEventSystem, String sCnvtHisCreUserId) throws EventException {

		try {
		
			if (vslSkdCngHisVOs == null || vslSkdCngHisVOs.size()==0)	return;
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Detail) Started ::2013-07-30::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			
			/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
			 * VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD V1
			 * - sVslSkdTmlCngTpCd
			 * ----------------------------------------------
			 * 'N' : 최초생성.
			 * ----------------------------------------------
			 * 'U' : Normal UPDATE 
			 * 'S' : Port SKIP
			 * 'I' : Phase IN
			 * 'O' : Phase OUT
			 * 'D' : Port Delete
			 * 'E' : ETA, ETB, ETD 변경
			 * 'Y' : YARD(Terminal) 변경
			 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
			 * 'R' : REVERSE Call
			 * ---------------------------------------------
			 * 'A' : ADD Call
			 * 'T' : AUTO UPDATE (by Acctual Schedule)
			 * ---------------------------------------------
			 */
			
			VesselScheduleMgtDBDAO 		dbDao 					= new VesselScheduleMgtDBDAO();
			String						sCvtVslSkdTmlCngTpCd	= null;
			
			log.info("\n\n ################################################################################### ");
			log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetailAutoUpdate ::vslSkdCngHisVOs size ["+vslSkdCngHisVOs.size()+"]");

			for(VslSkdCngHisVO tmpVslSkdCngHisVO : vslSkdCngHisVOs){
				
				/****
				 * VslSkdCngHisDtlVO Setting. (1)
				 * - vslSkdCngHisDtlVO
				 */
				VslSkdCngHisDtlVO					tmpVslSkdCngHisDtlVO					= new VslSkdCngHisDtlVO();
				List<VslSkdCngHisDtlVO> 			tmpVslSkdCngHisDtlVOs 					= new ArrayList<VslSkdCngHisDtlVO>();
				tmpVslSkdCngHisDtlVO.setVslCd		(tmpVslSkdCngHisVO.getVslCd			()	);
				tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVslSkdCngHisVO.getSkdVoyNo		()	);
				tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVslSkdCngHisVO.getSkdDirCd		()	);
				tmpVslSkdCngHisDtlVO.setVvdHisSeq	(tmpVslSkdCngHisVO.getVvdHisSeq		()	);
				tmpVslSkdCngHisDtlVO.setHisCreUsrId	(sCnvtHisCreUserId						);
				
				
				if	(			"UPDATE_ACT_AutoUpdate(VOP_VSK_0025)".equals(sFromEventSystem)
							||	"UPDATE_ACT_AutoUpdate(VOP_VSK_SPP_VSK_0003)".equals(sFromEventSystem)
							||	"UPDATE_ACT_AutoUpdate(IF_EDI_SVC)".equals(sFromEventSystem)
							||	"UPDATE_ACT_AutoUpdate(IF_EDI_SVC(VOP_VSK_0027))".equals(sFromEventSystem)
					)
				{
					sCvtVslSkdTmlCngTpCd	= "T";	//AUTO UPDATE(by Actual Schedule)//
				}else if(		"INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_NormalPort(VOP_VSK_0015)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_NormalPort(VOP_VSK_0057)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_NormalPort(VOP_VSK_0058)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_NormalPort(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0015)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0057)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0058)".equals(sFromEventSystem)
							||	"INSERT_CST_ByVvd_VirtualPort(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)
							)
				{
					sCvtVslSkdTmlCngTpCd	= "N";		//NORMAL/TURNING PORT + VIRTUAL INSERT//
				}else if("UPDATE_CST_ByBrthWdo(VOP_VSK_0017)".equals(sFromEventSystem)){
					sCvtVslSkdTmlCngTpCd	= "U";		//BERTH WINDOW UPDATE//
				//----------------------------------------------------------------------//
				}else{
					sCvtVslSkdTmlCngTpCd	= "";
				}

				tmpVslSkdCngHisDtlVO.setVskdTmlCngTpCd		(sCvtVslSkdTmlCngTpCd	);	/* Setting :: VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD */
				
				tmpVslSkdCngHisDtlVOs.add					(tmpVslSkdCngHisDtlVO	);
				
				dbDao.createVslSkdChangeHistoryDetailByVvd	(tmpVslSkdCngHisDtlVOs	);	
			}
			/******** vslSkdHisInVOs is null or size zero :: Finished!!! *************/
			
			/* ----------------------------------------------------------------------------
			 * Vessel Schedule History 관리 Finished ::2013-07-30::
			 * ============================================================================
			 */	
			
			/******************************************************************************
			 * Change Notification Back End Job 처리
			 */
			
			log.info("\n\n ################################################################################### ");
			log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetailAutoUpdate ::BACKENDJOB STARTED!!!");

			this.sendVslSkdCngNotification(vslSkdCngHisVOs, sCnvtHisCreUserId);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	
	/**
	 * Vessel Schedule History 관리(Detail+Multiple Notice)<br>
	 *
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 * @param String sCnvtVslSkdCngTpCd
	 * @param String sCnvtHisCreUserId
	 * @param String sSkdHisDesc
	 * @exception EventException
	 */
	public void createVslSkdChangeHistoryDetailMultiNotice(List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs, String sCnvtVslSkdCngTpCd, String sCnvtHisCreUserId, String sSkdHisDesc) throws EventException {

		try {
		
			if (vslSkdCngHisDtlVOs == null || vslSkdCngHisDtlVOs.size()==0)	return;
			
			//String	sCvtVslSkdTmlCngTpCd	= null;
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Detail) Started ::2013-07-30::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY		ref.method->makeVslSkdChgHisDtlDataSet
			 * ============================================================================
			 */
			
			/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
			 * VSK_VSL_SKD_CNG_HIS_DTL.VSKD_TML_CNG_TP_CD V1
			 * - sVslSkdTmlCngTpCd
			 * ----------------------------------------------
			 * 'N' : 최초생성.
			 * ----------------------------------------------
			 * 'U' : Normal UPDATE 
			 * 'S' : Port SKIP
			 * 'I' : Phase IN
			 * 'O' : Phase OUT
			 * 'D' : Port Delete
			 * 'E' : ETA, ETB, ETD 변경
			 * 'Y' : YARD(Terminal) 변경
			 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
			 * 'R' : REVERSE Call
			 * ---------------------------------------------
			 * 'A' : ADD Call
			 * 'T' : AUTO UPDATE (by Acctual Schedule)
			 * ---------------------------------------------
			 */
			
			VesselScheduleMgtDBDAO 		dbDao 					= new VesselScheduleMgtDBDAO();
			List<VslSkdCngHisDtlVO> 	finalVslSkdCngHisDtlVOs	= new ArrayList<VslSkdCngHisDtlVO>	();
			
			log.info("\n\n ################################################################################### ");
			log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2 ::vslSkdCngHisDtlVOs size ["+vslSkdCngHisDtlVOs.size()+"]");
			log.info("\n\n ################################################################################### ");
			
			int tmpLoopKnt		= 0;
//			int iVOInx			= 0;
			int iSameVvdKnt		= 0;
			
			List<VskVslSkdVO>		tmpVskVslSkdVOs		= new ArrayList<VskVslSkdVO>	();	
			List<VslSkdCngHisVO> 	vslSkdCngHisVOs		= new ArrayList<VslSkdCngHisVO>	();
			
			
			/////////////// VO "vslSkdCngHisDtlVOs"에서 VVD 추출 STARTED. //////////////////////////////////
			for(VslSkdCngHisDtlVO tmpVslSkdCngHisDtlVO : vslSkdCngHisDtlVOs){
				
				tmpLoopKnt++;
				
				List<VslSkdCngHisVO> 	tmpVslSkdCngHisVOs1		= new ArrayList<VslSkdCngHisVO>	();		/* VVD_HIS_SEQ  추출용	*/
				
				String sVslCd			= tmpVslSkdCngHisDtlVO.getVslCd		() == null ? "" :tmpVslSkdCngHisDtlVO.getVslCd		();
				String sSkdVoyNo		= tmpVslSkdCngHisDtlVO.getSkdVoyNo	() == null ? "" :tmpVslSkdCngHisDtlVO.getSkdVoyNo	();
				String sSkdDirCd		= tmpVslSkdCngHisDtlVO.getSkdDirCd	() == null ? "" :tmpVslSkdCngHisDtlVO.getSkdDirCd	();
				String sVvdHisSeq		= null;

				log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.outer :: tmpVskVslSkdVOs size ["+tmpVskVslSkdVOs.size()+"] :: vvd ["+sVslCd+sSkdVoyNo+sSkdDirCd+"]");
				
				if(tmpLoopKnt == 1){
					VskVslSkdVO		tmpVskVslSkdVO				= new VskVslSkdVO();
					
					tmpVskVslSkdVO.setVslCd		(sVslCd			);
					tmpVskVslSkdVO.setSkdVoyNo	(sSkdVoyNo		);
					tmpVskVslSkdVO.setSkdDirCd	(sSkdDirCd		);
					tmpVskVslSkdVOs.add			(tmpVskVslSkdVO	);
				
				
					log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.inner.confirm.init :: for.vvd["+sVslCd+sSkdVoyNo+sSkdDirCd+"]");
					log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.inner.confirm :: tmpVskVslSkdVOs size ["+tmpVskVslSkdVOs.size()+"] :: vvd ["+sVslCd+sSkdVoyNo+sSkdDirCd+"]");
					
					
					
					/*******************************************************************************/
					VslSkdCngHisVO	tmpVslSkdCngHisVO1	= new VslSkdCngHisVO();
					tmpVslSkdCngHisVO1.setVslCd		(sVslCd				);
					tmpVslSkdCngHisVO1.setSkdVoyNo	(sSkdVoyNo			);
					tmpVslSkdCngHisVO1.setSkdDirCd	(sSkdDirCd			);
					tmpVslSkdCngHisVOs1.add			(tmpVslSkdCngHisVO1	);
					
					sVvdHisSeq		= dbDao.createVslSkdChangeVvdHisSeq(tmpVslSkdCngHisVOs1);
					
					log.info("\n\n ################################################################################### ");
					log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.xxx.first :: sVvdHisSeq ["+sVslCd+sSkdVoyNo+sSkdDirCd+"], new vvd his seq ["+sVvdHisSeq+"]");
					log.info("\n\n ################################################################################### ");					
					
					VslSkdCngHisVO	tmpVslSkdCngHisVO	= new VslSkdCngHisVO();
					tmpVslSkdCngHisVO.setVslCd		(sVslCd				);
					tmpVslSkdCngHisVO.setSkdVoyNo	(sSkdVoyNo			);
					tmpVslSkdCngHisVO.setSkdDirCd	(sSkdDirCd			);
					tmpVslSkdCngHisVO.setVvdHisSeq	(sVvdHisSeq			);
					
					tmpVslSkdCngHisVO.setVskdCngTpCd(sCnvtVslSkdCngTpCd	);		 //Setting :: VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD 
					tmpVslSkdCngHisVO.setHisCreUsrId(sCnvtHisCreUserId	);		 //Setting :: VSK_VSL_SKD_CNG_HIS.HIS_CRE_USR_ID 
					tmpVslSkdCngHisVO.setSkdHisDesc	(sSkdHisDesc		);		 //Setting :: VSK_VSL_SKD_CNG_HIS.SKD_HIS_DESC
					
					vslSkdCngHisVOs.add				(tmpVslSkdCngHisVO	);
					
					dbDao.createVslSkdChangeHistory	(vslSkdCngHisVOs	);
					/*******************************************************************************/
					
				}else if(tmpVskVslSkdVOs != null && tmpVskVslSkdVOs.size()>0){
					
					log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.inner :: tmpVskVslSkdVOs size ["+tmpVskVslSkdVOs.size()+"] :: vvd ["+sVslCd+sSkdVoyNo+sSkdDirCd+"]");
					
					iSameVvdKnt	= 0;
					List<VslSkdCngHisVO> 	vslSkdCngHisVOs2		= new ArrayList<VslSkdCngHisVO>	();
					
					for(int i=0; i<tmpVskVslSkdVOs.size(); i++){
						VskVslSkdVO		tmpVskVslSkdVO			= new VskVslSkdVO();
						tmpVskVslSkdVO	= tmpVskVslSkdVOs.get(i);
						
						if(		sVslCd		.equals	(tmpVskVslSkdVO.getVslCd	())
							&&	sSkdVoyNo	.equals	(tmpVskVslSkdVO.getSkdVoyNo	())
							&&	sSkdDirCd	.equals	(tmpVskVslSkdVO.getSkdDirCd	()))
						{
							iSameVvdKnt++;
						}
					}
					
					if(iSameVvdKnt == 0){
						
//						iVOInx++;
						VskVslSkdVO		tmpVskVslSkdVO			= new VskVslSkdVO();
						
						tmpVskVslSkdVO.setVslCd		(sVslCd			);
						tmpVskVslSkdVO.setSkdVoyNo	(sSkdVoyNo		);
						tmpVskVslSkdVO.setSkdDirCd	(sSkdDirCd		);
						tmpVskVslSkdVOs.add			(tmpVskVslSkdVO	);
						
						//log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.inner.confirm :: for.vvd["+sVslCd+sSkdVoyNo+sSkdDirCd+"] :: vo.vvd ["+tmpVskVslSkdVO11.getVslCd		()+tmpVskVslSkdVO11.getSkdVoyNo	()+tmpVskVslSkdVO11.getSkdDirCd	()+"]");
						log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.inner.confirm :: for.vvd["+sVslCd+sSkdVoyNo+sSkdDirCd+"]");
						
						
						log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.inner.confirm :: tmpVskVslSkdVOs size ["+tmpVskVslSkdVOs.size()+"] :: vvd ["+sVslCd+sSkdVoyNo+sSkdDirCd+"]");
						
						
						/*******************************************************************************/
						VslSkdCngHisVO	tmpVslSkdCngHisVO1	= new VslSkdCngHisVO();
						tmpVslSkdCngHisVO1.setVslCd		(sVslCd				);
						tmpVslSkdCngHisVO1.setSkdVoyNo	(sSkdVoyNo			);
						tmpVslSkdCngHisVO1.setSkdDirCd	(sSkdDirCd			);
						tmpVslSkdCngHisVOs1.add			(tmpVslSkdCngHisVO1	);
						
						sVvdHisSeq		= dbDao.createVslSkdChangeVvdHisSeq(tmpVslSkdCngHisVOs1);
						
						log.info("\n\n ################################################################################### ");
						log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.xxx.second :: sVvdHisSeq ["+sVslCd+sSkdVoyNo+sSkdDirCd+"], new vvd his seq ["+sVvdHisSeq+"]");
						log.info("\n\n ################################################################################### ");					

						
						VslSkdCngHisVO	tmpVslSkdCngHisVO	= new VslSkdCngHisVO();
						tmpVslSkdCngHisVO.setVslCd		(sVslCd				);
						tmpVslSkdCngHisVO.setSkdVoyNo	(sSkdVoyNo			);
						tmpVslSkdCngHisVO.setSkdDirCd	(sSkdDirCd			);
						tmpVslSkdCngHisVO.setVvdHisSeq	(sVvdHisSeq			);
						
						tmpVslSkdCngHisVO.setVskdCngTpCd(sCnvtVslSkdCngTpCd	);		 //Setting :: VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD 
						tmpVslSkdCngHisVO.setHisCreUsrId(sCnvtHisCreUserId	);		 //Setting :: VSK_VSL_SKD_CNG_HIS.HIS_CRE_USR_ID 
						
						vslSkdCngHisVOs2.add			(tmpVslSkdCngHisVO	);
						
						/****************************************************************
						 * VSK_VSL_SKD_CNG_HIS_DTL INSERT를 위한 VO List Setting
						 */
						vslSkdCngHisVOs.add				(tmpVslSkdCngHisVO	);	
						/****************************************************************/
						
						dbDao.createVslSkdChangeHistory	(vslSkdCngHisVOs2	);
						/*******************************************************************************/							
						
					}
					
				}
				
			}	
			/////////////// VO "vslSkdCngHisDtlVOs"에서 VVD 추출 FINISHED. //////////////////////////////////
				
//			for(VskVslSkdVO tmpVO : tmpVskVslSkdVOs){
//				log.info("\n\n ################################################################################### ");
//				log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2 :: tmpVskVslSkdVOs size ["+tmpVskVslSkdVOs.size()+"]");
//				log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2 :: tmpVO vvd ["+tmpVO.getVslCd()+tmpVO.getSkdVoyNo()+tmpVO.getSkdDirCd()+"]");
//				log.info("\n\n ################################################################################### ");
//			}
			

			String sVvdHisSeq		= null;
			for(VslSkdCngHisDtlVO tmpVslSkdCngHisDtlVO : vslSkdCngHisDtlVOs){

				VslSkdCngHisDtlVO	tmpVslSkdCngHisDtlVO1	= new VslSkdCngHisDtlVO();
				tmpVslSkdCngHisDtlVO1.setVslCd				(tmpVslSkdCngHisDtlVO.getVslCd				());
				tmpVslSkdCngHisDtlVO1.setSkdVoyNo			(tmpVslSkdCngHisDtlVO.getSkdVoyNo			());
				tmpVslSkdCngHisDtlVO1.setSkdDirCd			(tmpVslSkdCngHisDtlVO.getSkdDirCd			());
				tmpVslSkdCngHisDtlVO1.setVpsPortCd			(tmpVslSkdCngHisDtlVO.getVpsPortCd			());
				tmpVslSkdCngHisDtlVO1.setClptIndSeq			(tmpVslSkdCngHisDtlVO.getClptIndSeq			());
				
				for(VslSkdCngHisVO vslSkdCngHisVO : vslSkdCngHisVOs){
					if	(		vslSkdCngHisVO.getVslCd		().equals(tmpVslSkdCngHisDtlVO.getVslCd		())
							&&	vslSkdCngHisVO.getSkdVoyNo	().equals(tmpVslSkdCngHisDtlVO.getSkdVoyNo	())
							&&	vslSkdCngHisVO.getSkdDirCd	().equals(tmpVslSkdCngHisDtlVO.getSkdDirCd	())
						)	
					{
						sVvdHisSeq	= vslSkdCngHisVO.getVvdHisSeq();
						break;
					}
				}

				log.info("\n\n ################################################################################### ");
				log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.createVslSkdChangeHistoryDetail :: vvd ["+tmpVslSkdCngHisDtlVO.getVslCd	()+tmpVslSkdCngHisDtlVO.getSkdVoyNo()+tmpVslSkdCngHisDtlVO.getSkdDirCd()+"], new vvd his seq ["+sVvdHisSeq+"]");
				log.info("\n\n ################################################################################### ");

				
				tmpVslSkdCngHisDtlVO1.setVvdHisSeq			(sVvdHisSeq	);
				tmpVslSkdCngHisDtlVO1.setVskdTmlCngTpCd		(tmpVslSkdCngHisDtlVO.getVskdTmlCngTpCd		()	);
				//------------------------------------------------------------------------------------------//
				tmpVslSkdCngHisDtlVO1.setBfrYdCd			(tmpVslSkdCngHisDtlVO.getBfrYdCd			()	);
				tmpVslSkdCngHisDtlVO1.setPairRvsPortCd		(tmpVslSkdCngHisDtlVO.getPairRvsPortCd		()	);
				tmpVslSkdCngHisDtlVO1.setPairRvsClptIndSeq	(tmpVslSkdCngHisDtlVO.getPairRvsClptIndSeq	()	);
				tmpVslSkdCngHisDtlVO1.setHisCreUsrId		(sCnvtHisCreUserId								);
				
				if(tmpVslSkdCngHisDtlVO1.getVvdHisSeq() != null && !"".equals(tmpVslSkdCngHisDtlVO1.getVvdHisSeq())){
					finalVslSkdCngHisDtlVOs.add				(tmpVslSkdCngHisDtlVO1);	
				}
			}
			
			log.info("\n\n ################################################################################### ");
			log.info("\n\n ############# ::jskjskjsk:: createVslSkdChangeHistoryDetail2.dbDao.createVslSkdChangeHistoryDetail :: finalVslSkdCngHisDtlVOs size ["+finalVslSkdCngHisDtlVOs.size()+"]");
			log.info("\n\n ################################################################################### ");
			
			if(finalVslSkdCngHisDtlVOs != null && finalVslSkdCngHisDtlVOs.size()>0){
				dbDao.createVslSkdChangeHistoryDetailByVvdPort	(finalVslSkdCngHisDtlVOs);	
			}
			
			
			/* ----------------------------------------------------------------------------
			 * Vessel Schedule History 관리 Finished ::2013-07-30::
			 * ============================================================================
			 */	
			
			/******************************************************************************
			 * Change Notification Back End Job 처리
			 */
			
			this.sendVslSkdCngNotification(vslSkdCngHisVOs, sCnvtHisCreUserId);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	

	/**
	 * Vessel Schedule 변경사항에 대한 이력발송<br>
	 * @param List<VslSkdCngHisVO> vslSkdCngHisVOs
	 * @exception EventException
	 */
	private void sendVslSkdCngNotification(List<VslSkdCngHisVO> vslSkdCngHisVOs, String sCnvtHisCreUserId) throws EventException {
		
		log.info("\n\n ################################################################################### ");
		log.info("\n\n ############# ::jskjskjsk:: sendVslSkdCngNotification :: sCnvtHisCreUserId ["+sCnvtHisCreUserId+"]");
		log.info("\n\n ################################################################################### ");
		
		try {
			
			if(vslSkdCngHisVOs == null || vslSkdCngHisVOs.size() == 0)	return;
			
			ScheduleNotificationManagementDBDAO 		dbDao 		= new ScheduleNotificationManagementDBDAO();
			ScheduleNotificationManagementEAIDAO 		eaiDao		= new ScheduleNotificationManagementEAIDAO();
			VSKCodeFinderDBDAO 							commonDbDao	= new VSKCodeFinderDBDAO();
			int											sExistKnt	= 0;
			
			List<VslSkdCngNotificationTransmitLogVO>	vslSkdCngNtfcTrsmLogVOs		= null;
			vslSkdCngNtfcTrsmLogVOs						= dbDao.searchVslSkdChangeNotificationTargetList(vslSkdCngHisVOs);
			
			
			for(VslSkdCngNotificationTransmitLogVO tmpVO : vslSkdCngNtfcTrsmLogVOs){
				
				log.info("\n\n ::jskjskjsk:: VesselScheduleCngNotificationBackEndJob :: INNER.FOR RECEIVER EML ["+commonDbDao.searchUserEmail(tmpVO.getUsrId())+"]");
				
				/***************************************************************
				 * ETA/ETB/ETD 변경으로 인한 NOTICE 발송시 
				 * 직전 NOTICE 발송이후 변경이 없는상태에서 NOTICE 발송제외처리함
				 * =============================================================
				 * VSK_VSL_SKD_NTFC_TRSM_LOG.NTFC_TRSM_TP_CD V2
				 * -------------------------------------------------------------
				 * "ET" : ETA/ETB/ETD 지연
				 * "PS" : PORT SKIP
				 * "PX" : PORT SKIP CANCEL
				 * "PR" : PORT REVERSE				<== 발송대상에서 제외함.
				 * "SR" : BOTH SKIP + REVERSE		<== "PR"제외로 의미없음
				 * --------------------------------------------------------------
				 * 
				 */
				
				if("ET".equals(tmpVO.getNtfcTrsmTpCd())){
					
					sExistKnt	= dbDao.checkVslSkdCngNotificationTransmitByEst(tmpVO);
					
					if(sExistKnt == 0){
						
						VslSkdCngNotificationTransmitLogVO tmpVO1	= null;
						tmpVO.setRcvrEml(commonDbDao.searchUserEmail	(tmpVO.getUsrId()));
						tmpVO1	= eaiDao.sendScheduleNotificationEmail	(tmpVO);
						
						VslSkdCngNotificationTransmitLogVO 			tmpVO2	= new VslSkdCngNotificationTransmitLogVO();
						List<VslSkdCngNotificationTransmitLogVO> 	tmpVOs2	= new ArrayList<VslSkdCngNotificationTransmitLogVO>();
						//-------------------- PK ---------------------------------//
						tmpVO2.setVslCd				(tmpVO.getVslCd				()	);
						tmpVO2.setSkdVoyNo			(tmpVO.getSkdVoyNo			()	);
						tmpVO2.setSkdDirCd			(tmpVO.getSkdDirCd			()	);
						tmpVO2.setVpsPortCd			(tmpVO.getVpsPortCd			()	);
						tmpVO2.setClptIndSeq		(tmpVO.getClptIndSeq		()	);
						tmpVO2.setUsrId				(tmpVO.getUsrId				()	);
						//-------------------- PK ---------------------------------//
						tmpVO2.setVvdHisSeq			(tmpVO.getVvdHisSeq			()	);
						tmpVO2.setHisDtlSeq			(tmpVO.getHisDtlSeq			()	);
						
						tmpVO2.setVslSlanCd			(tmpVO.getVslSlanCd			()	);
						tmpVO2.setTrsmMzdCd			(tmpVO.getTrsmMzdCd			()	);
						tmpVO2.setNtfcTrsmTpCd		(tmpVO.getNtfcTrsmTpCd		()	);
						tmpVO2.setPfEtaDt			(tmpVO.getPfEtaDt			()	);
						tmpVO2.setPfEtbDt			(tmpVO.getPfEtbDt			()	);
						tmpVO2.setPfEtdDt			(tmpVO.getPfEtdDt			()	);
						tmpVO2.setVpsEtaDt			(tmpVO.getVpsEtaDt			()	);
						tmpVO2.setVpsEtbDt			(tmpVO.getVpsEtbDt			()	);
						tmpVO2.setVpsEtdDt			(tmpVO.getVpsEtdDt			()	);
						tmpVO2.setPortSkpTpCd		(tmpVO.getPortSkpTpCd		()	);
						tmpVO2.setBfrYdCd			(tmpVO.getBfrYdCd			()	);
						tmpVO2.setCrntYdCd			(tmpVO.getCrntYdCd			()	);
						tmpVO2.setPairRvsPortCd		(tmpVO.getPairRvsPortCd		()	);
						tmpVO2.setPairRvsClptIndSeq	(tmpVO.getPairRvsClptIndSeq	()	);
						//---------------------------------------------------------//
						tmpVO2.setHisCreUsrId		(sCnvtHisCreUserId				);
						/////////////////////////////////////////////////////////////
						tmpVO2.setRcvrEml			(tmpVO1.getRcvrEml			()	);
						tmpVO2.setSndrEml			(tmpVO1.getSndrEml			()	);
						tmpVO2.setEmlSndNo			(tmpVO1.getEmlSndNo			()	);
						/////////////////////////////////////////////////////////////
						tmpVO2.setEtaDelayHrs		(tmpVO.getEtaDelayHrs		()	);
						tmpVO2.setEtbDelayHrs		(tmpVO.getEtbDelayHrs		()	);
						tmpVO2.setEtdDelayHrs		(tmpVO.getEtdDelayHrs		()	);
						/////////////////////////////////////////////////////////////
						
						tmpVOs2.add					(tmpVO2);
						
						dbDao.createVslSkdChangeNotificationTransmitLog(tmpVOs2);
					}
					
				}else if("PS".equals(tmpVO.getNtfcTrsmTpCd()) || "PX".equals(tmpVO.getNtfcTrsmTpCd())){
					
					VslSkdCngNotificationTransmitLogVO tmpVO1	= null;
					tmpVO.setRcvrEml(commonDbDao.searchUserEmail	(tmpVO.getUsrId()));
					tmpVO1	= eaiDao.sendScheduleNotificationEmail	(tmpVO);
					
					VslSkdCngNotificationTransmitLogVO 			tmpVO2	= new VslSkdCngNotificationTransmitLogVO();
					List<VslSkdCngNotificationTransmitLogVO> 	tmpVOs2	= new ArrayList<VslSkdCngNotificationTransmitLogVO>();
					//-------------------- PK ---------------------------------//
					tmpVO2.setVslCd				(tmpVO.getVslCd				()	);
					tmpVO2.setSkdVoyNo			(tmpVO.getSkdVoyNo			()	);
					tmpVO2.setSkdDirCd			(tmpVO.getSkdDirCd			()	);
					tmpVO2.setVpsPortCd			(tmpVO.getVpsPortCd			()	);
					tmpVO2.setClptIndSeq		(tmpVO.getClptIndSeq		()	);
					tmpVO2.setUsrId				(tmpVO.getUsrId				()	);
					//-------------------- PK ---------------------------------//
					tmpVO2.setVvdHisSeq			(tmpVO.getVvdHisSeq			()	);
					tmpVO2.setHisDtlSeq			(tmpVO.getHisDtlSeq			()	);
					
					tmpVO2.setVslSlanCd			(tmpVO.getVslSlanCd			()	);
					tmpVO2.setTrsmMzdCd			(tmpVO.getTrsmMzdCd			()	);
					tmpVO2.setNtfcTrsmTpCd		(tmpVO.getNtfcTrsmTpCd		()	);
					tmpVO2.setPfEtaDt			(tmpVO.getPfEtaDt			()	);
					tmpVO2.setPfEtbDt			(tmpVO.getPfEtbDt			()	);
					tmpVO2.setPfEtdDt			(tmpVO.getPfEtdDt			()	);
					tmpVO2.setVpsEtaDt			(tmpVO.getVpsEtaDt			()	);
					tmpVO2.setVpsEtbDt			(tmpVO.getVpsEtbDt			()	);
					tmpVO2.setVpsEtdDt			(tmpVO.getVpsEtdDt			()	);
					tmpVO2.setPortSkpTpCd		(tmpVO.getPortSkpTpCd		()	);
					tmpVO2.setBfrYdCd			(tmpVO.getBfrYdCd			()	);
					tmpVO2.setCrntYdCd			(tmpVO.getCrntYdCd			()	);
					tmpVO2.setPairRvsPortCd		(tmpVO.getPairRvsPortCd		()	);
					tmpVO2.setPairRvsClptIndSeq	(tmpVO.getPairRvsClptIndSeq	()	);
					//---------------------------------------------------------//
					tmpVO2.setHisCreUsrId		(sCnvtHisCreUserId				);
					/////////////////////////////////////////////////////////////
					tmpVO2.setRcvrEml			(tmpVO1.getRcvrEml			()	);
					tmpVO2.setSndrEml			(tmpVO1.getSndrEml			()	);
					tmpVO2.setEmlSndNo			(tmpVO1.getEmlSndNo			()	);
					/////////////////////////////////////////////////////////////
					
					tmpVOs2.add					(tmpVO2);
					
					dbDao.createVslSkdChangeNotificationTransmitLog(tmpVOs2);
				}
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
	
}

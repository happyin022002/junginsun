/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName 		: VesselScheduleExtraChangeHistCreationBackEndJob.java
*@FileTitle 	: VesselScheduleExtraChangeHistCreationBackEndJob
*Open Issues 	:
*Change history :
*@LastModifyDate: 2015.05.08
*@LastModifier 	: 정상기
*@LastVersion 	: 1.0
* 2015.05.08 	: JEONG SANG-KI
* 1.0 Creation
* 
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration.VesselScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHisDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;


/**
 * VesselScheduleExtraChangeHistCreationBackEndJob Business Logic Back End Job Basic Command implementation<br>
 * - Handling business logic of Vessel Schedule Change History<br>
 * 
 * @author
 * @see DAO
 * @since J2EE 1.4
 */ 
public class VesselScheduleExtraChangeHistCreationBackEndJob extends BackEndCommandSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;
		
	/**
	 * Change Notification
	 */
	private List<VslSkdXtraHisVO> vslSkdXtraHisVOs;
	
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
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 */
	public void setVslSkdCngHisDtlVOs(List<VslSkdXtraHisVO> vslSkdXtraHisVOs) {
		this.vslSkdXtraHisVOs = vslSkdXtraHisVOs;
	}
	
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
		this.manageVslSkdXtraCngHistCreation(this.vslSkdXtraHisVOs, this.sFromEventSystem); 
		return null;
	}
	
	/**
	 * Vessel Schedule 변경사항에 대한 이력발송<br>
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @param List<VslSkdCngHisDtlVO> vslSkdCngHisDtlVOs
	 * @param String sFromEventSystem
	 * @exception EventException
	 */
	private void manageVslSkdXtraCngHistCreation(List<VslSkdXtraHisVO> vslSkdXtraHisVOs, String sFromEventSystem) throws EventException {
		
		try {
			
			if(vslSkdXtraHisVOs == null || vslSkdXtraHisVOs.size() == 0)	return;
			
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

			VesselScheduleMgtDBDAO 	dbDao 				= new VesselScheduleMgtDBDAO();

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
			
			String	sCurTime					= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
			String	sCarriageReturn				= "\n";
			boolean	isTargetForSkdHisRqstByUser	= true;
			boolean isDelProcSeperate			= false;
			
			/** Only for saving by VVD ********************************/
			List<VslSkdCngHisDtlVO>	VslSkdCngHisDtlVOList	= new ArrayList<VslSkdCngHisDtlVO>();
			
			for(int i=0; i<vslSkdXtraHisVOs.size(); i++){
				
				String					sVskdTpCd			= null;
				
				//String				sVskdCngTpCd		= null;
				String					sVskdCngTpCd		= "U";
				
				String					sBkgAtchFlg			= null;
				
				String					sCnvtHisCreUserId	= null;
				String					sSkdHisDesc			= null;
				StringBuffer			sbTmpHisDesc		= new StringBuffer("");
				
				String					sVtAddCallDesc		= "";
				
				VslSkdXtraHisVO	tmpVO	= new VslSkdXtraHisVO();
				tmpVO					= vslSkdXtraHisVOs.get(i);
				
				/** Only for saving by VVD ********************************/
				VslSkdCngHisDtlVO		tmpVslSkdCngHisDtlVO	= new VslSkdCngHisDtlVO();
				
				
				if("CSSM_UPDATE".equals(sFromEventSystem)){
					
					isTargetForSkdHisRqstByUser	= false;
					
					sVskdCngTpCd			= "U";
					sCnvtHisCreUserId		= "CSSM_UPDATE(VOP_VSK_5001)";
					
					sbTmpHisDesc.append("CRE TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Consortium Voyage Update (VOP_VSK_5001)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
					
				}else if("CREATION_LRS".equals(sFromEventSystem)){
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "N";		//NEW or ETC//
					sBkgAtchFlg			= "N";
					sCnvtHisCreUserId	= "LRS_Creation(VOP_VSK_0010)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("CRE TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Long Range SKD Creation (VOP_VSK_0010)");
					
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				//----------------------------------------------------------------------//
				//----------------------------------------------------------------------//		
				}else if("DELETE_LRS_DeletedGroupVVD_NoneBKG(VOP_VSK_0010)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "D";		//VVD Deletion//
					sBkgAtchFlg			= "N";
					sCnvtHisCreUserId	= "LRS_Delete(VOP_VSK_0010)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Long Range SKD Creation (VOP_VSK_0010)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : DELETE Old LRS Before Creating LRS");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					tmpVslSkdCngHisDtlVO.setActCrrCd	(tmpVO.getBfrActCrrCd	());
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("DELETE_LRS_Feeder_DeletedGroupVVD_NoneBKG(VOP_VSK_0054)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "D";		//VVD Deletion//
					sBkgAtchFlg			= "N";
					sCnvtHisCreUserId	= "LRS_Delete(VOP_VSK_0054)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Feeder Long Range SKD Creation (VOP_VSK_0054)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : DELETE Old LRS Before Creating LRS");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					tmpVslSkdCngHisDtlVO.setActCrrCd	(tmpVO.getBfrActCrrCd	());
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("DELETE_CST_DeletionVvd_NoneBKG(VOP_VSK_0018)".equals(sFromEventSystem)){
					
					isDelProcSeperate	= true;
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "D";		//VVD Deletion//
					sBkgAtchFlg			= "N";
					sCnvtHisCreUserId	= "VVD_Delete(VOP_VSK_0018)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VVD Deletion/Holding (VOP_VSK_0018)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : DELETE VVD");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					tmpVslSkdCngHisDtlVO.setActCrrCd	(tmpVO.getBfrActCrrCd	());
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("DELETE_CST_Feeder_DeletionVvd_NoneBKG(VOP_VSK_0059)".equals(sFromEventSystem)){
					
					isDelProcSeperate	= true;
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "D";		//VVD Deletion//
					sBkgAtchFlg			= "N";
					sCnvtHisCreUserId	= "VVD_Delete(VOP_VSK_0059)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VVD Deletion/Holding (VOP_VSK_0059)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : DELETE Old LRS Before Creating LRS");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					tmpVslSkdCngHisDtlVO.setActCrrCd	(tmpVO.getBfrActCrrCd	());
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)".equals(sFromEventSystem)){
					
					isDelProcSeperate	= true;
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "D";		//VVD Deletion//
					sBkgAtchFlg			= "Y";
					sCnvtHisCreUserId	= "VVD_Delete_POP(VOP_VSK_0249)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VVD Deletion/Holding_POP(VOP_VSK_0249)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : DELETE VVD with BKGs");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					tmpVslSkdCngHisDtlVO.setActCrrCd	(tmpVO.getBfrActCrrCd	());
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("DELETE_CST_ByVvd(0014/0015/0057/0058)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "M";
					sVskdCngTpCd		= "D";		//VVD Deletion//
					sCnvtHisCreUserId	= "VVD_Delete(0014/0015/0057/0058)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VVD_Delete(0014/0015/0057/0058)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : VVD_Delete(0014/0015/0057/0058)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					tmpVslSkdCngHisDtlVO.setActCrrCd	(tmpVO.getBfrActCrrCd	());
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				//----------------------------------------------------------------------//
				//----------------------------------------------------------------------//
					
				}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "N";		//NEW or ETC PORT INSERT//
					sCnvtHisCreUserId	= "CST_NorPortIns(0014)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VSL SKD Creation by VVD (VOP_VSK_0014)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0015)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "N";		//NEW or ETC PORT INSERT//
					sCnvtHisCreUserId	= "CST_NorPortIns(0015)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : CST SKD Update (VOP_VSK_0015)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0057)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "N";		//NEW or ETC PORT INSERT//
					sCnvtHisCreUserId	= "CST_NorPortIns(0057)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VSL SKD Creation by VVD - Feeder (VOP_VSK_0057)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_0058)".equals(sFromEventSystem)){
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "N";		//NEW or ETC PORT INSERT//
					sCnvtHisCreUserId	= "CST_NorPortIns(0058)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : CST SKD Update - Feeder (VOP_VSK_0058)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_NormalPort(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "N";		//NEW or ETC PORT INSERT//
					sCnvtHisCreUserId	= "CST_NorPortIns(ESVC)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : E-SVC WebServices Feeder SKD Creation by VVD (VOP_VSK_SPP_VSK_0005)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : INSERT/ADD NORMAL/TURNING PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				//----------------------------------------------------------------------//	
					
				}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "M";		//NEW Virtual Port INSERT//
					sCnvtHisCreUserId	= "CST_VirPortIns(0014)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VSL SKD Creation by VVD (VOP_VSK_0014)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : ADD VIRTUAL PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0015)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "M";		//NEW Virtual Port INSERT//
					sCnvtHisCreUserId	= "CST_VirPortIns(0015)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : CST SKD Update (VOP_VSK_0015)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : ADD VIRTUAL PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0057)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "M";		//NEW Virtual Port INSERT//
					sCnvtHisCreUserId	= "CST_VirPortIns(0057)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VSL SKD Creation by VVD - Feeder (VOP_VSK_0057)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : ADD VIRTUAL PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0058)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "M";		//NEW Virtual Port INSERT//
					sCnvtHisCreUserId	= "CST_VirPortIns(0058)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : CST SKD Update - Feeder (VOP_VSK_0058)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : ADD VIRTUAL PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("INSERT_CST_ByVvd_VirtualPort(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "M";		//NEW Virtual Port INSERT//
					sCnvtHisCreUserId	= "CST_VirPortIns(ESVC)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("INS TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : E-SVC WebServices Feeder SKD Creation by VVD (VOP_VSK_SPP_VSK_0005)");
					sbTmpHisDesc.append(sCarriageReturn);	
					sbTmpHisDesc.append("RMK : ADD VIRTUAL PORT");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				//----------------------------------------------------------------------//
				//----------------------------------------------------------------------//
					
				}else if("UPDATE_CST_ByVvd(VOP_VSK_0014)".equals(sFromEventSystem)){	
					
					sVskdTpCd			= "P";
					//sVskdCngTpCd		= "";		//NORMAL UPDATE//
					sCnvtHisCreUserId	= "CST_(VOP_VSK_0014)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VSL SKD Creation by VVD (VOP_VSK_0014)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_CST_ByVvd(VOP_VSK_0015)".equals(sFromEventSystem)){	
					
					sVskdTpCd			= "P";
					//sVskdCngTpCd		= "";		//NORMAL UPDATE//
					sCnvtHisCreUserId	= "CST_(VOP_VSK_0015)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : C/SKD Update (VOP_VSK_0015)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_CST_ByVvd(VOP_VSK_0057)".equals(sFromEventSystem)){	
					
					sVskdTpCd			= "P";
					//sVskdCngTpCd		= "";		//NORMAL UPDATE//
					sCnvtHisCreUserId	= "CST_(VOP_VSK_0057)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : VSL SKD Creation by VVD - Feeder (VOP_VSK_0057)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_CST_ByVvd(VOP_VSK_0058)".equals(sFromEventSystem)){	
					
					sVskdTpCd			= "P";
					//sVskdCngTpCd		= "";		//NORMAL UPDATE//
					sCnvtHisCreUserId	= "CST_(VOP_VSK_0058)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : C/SKD Update - Feeder (VOP_VSK_0058)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_CST_ByVvd(VOP_VSK_SPP_VSK_0005)".equals(sFromEventSystem)){	
					
					sVskdTpCd			= "P";
					//sVskdCngTpCd		= "";		//NORMAL UPDATE//
					sCnvtHisCreUserId	= "CST_(ESVC)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : E-SVC WebServices Feeder SKD Creation by VVD (VOP_VSK_SPP_VSK_0005)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
							
				//----------------------------------------------------------------------//
				//----------------------------------------------------------------------//
					
				}else if("UPDATE_ACT_AutoUpdate(VOP_VSK_0025)".equals(sFromEventSystem)){
					
					isTargetForSkdHisRqstByUser	= false;
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "U";		//AUTO UPDATE//
					sCnvtHisCreUserId	= "ACT_AU(VOP_VSK_0025)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - with/without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Actual SKD Creation (VOP_VSK_0025)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_ACT_AutoUpdate(VOP_VSK_SPP_VSK_0003)".equals(sFromEventSystem)){
					
					isTargetForSkdHisRqstByUser	= false;
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "U";		//AUTO UPDATE//
					sCnvtHisCreUserId	= "ACT_AU(ESVC)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - with/without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("PGM : ESVC - FEEDER");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_ACT_AutoUpdate(IF_EDI_SVC)".equals(sFromEventSystem)){
					
					isTargetForSkdHisRqstByUser	= false;
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "U";		//AUTO UPDATE//
					sCnvtHisCreUserId	= "ACT_AU(EDI)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - with/without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("PGM : IFTSAI EDI");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("UPDATE_ACT_AutoUpdate(IF_EDI_SVC(VOP_VSK_0027))".equals(sFromEventSystem)){
					
					isTargetForSkdHisRqstByUser	= false;
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "U";		//AUTO UPDATE//
					sCnvtHisCreUserId	= "ACT_AU(EDI-VSK_0027)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - with/without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Actual SKD Input Ratio Report.EDI SKD Monitoring (VOP_VSK_0027)");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("RMK : AUTO UPDATE by UI-EDI RETRY SEND");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				//----------------------------------------------------------------------//
					
				}else if("DELETE_ACT_SKD(VOP_VSK_0025)".equals(sFromEventSystem)){
					
					isTargetForSkdHisRqstByUser	= false;
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "U";		//AUTO UPDATE//
					sCnvtHisCreUserId	= "ACT_DEL(VOP_VSK_0025)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - with/without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Actual SKD Delete (VOP_VSK_0025)");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("RMK : AUTO DELETE by UI");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				//----------------------------------------------------------------------//
					
				}else if("UPDATE_CST_ByBrthWdo(VOP_VSK_0017)".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "E";		//ETA, ETB, ETD UPDATE//
					sCnvtHisCreUserId	= "CST_BerthWindow(VOP_VSK_0017)";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - with/without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : Daily Berth Window (VOP_VSK_0017)");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else if("EDI_XCH_AUTO_MAPPING".equals(sFromEventSystem)){
					
					sVskdTpCd			= "P";
					sVskdCngTpCd		= "Z";		//NORMAL UPDATE//
					sCnvtHisCreUserId	= "XCH_SKD_ALLIANCE";
					
					sbTmpHisDesc.append("=== Vessel Schedule HISTORY CREATION (Extra - without BKGs) === ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UPD TIME : ["+sCurTime+"]");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("UI : EDI (EXCHANGE ALLIANCE SKD");
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sbTmpHisDesc.toString	());
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}else{
					
					sVskdTpCd			= tmpVO.getVskdTpCd		();
					sVskdCngTpCd		= tmpVO.getVskdCngTpCd	();
					sBkgAtchFlg			= tmpVO.getBkgAtchFlg	();
					sCnvtHisCreUserId	= "NO_ACCOUNT_USER_ID";
					
					/** Only for saving by VVD ***********************************/
					tmpVslSkdCngHisDtlVO.setVslCd		(tmpVO.getBfrVslCd		());
					tmpVslSkdCngHisDtlVO.setSkdVoyNo	(tmpVO.getBfrSkdVoyNo	());
					tmpVslSkdCngHisDtlVO.setSkdDirCd	(tmpVO.getBfrSkdDirCd	());
					
					tmpVslSkdCngHisDtlVO.setVslSlanCd	(tmpVO.getBfrVslSlanCd	());
					tmpVslSkdCngHisDtlVO.setPfSkdTpCd	(tmpVO.getBfrPfSvcTpCd	());
					
					tmpVslSkdCngHisDtlVO.setVskdCngTpCd	(sVskdCngTpCd			  );
					
					tmpVslSkdCngHisDtlVO.setSkdCngId	(sCnvtHisCreUserId		  );
					tmpVslSkdCngHisDtlVO.setSkdCngDesc	(sCnvtHisCreUserId		  );
					
					tmpVslSkdCngHisDtlVO.setUpdUsrId	(tmpVO.getUpdUsrId		());
					/**************************************************************/
					
				}
				
				sVskdCngTpCd			= sVskdCngTpCd == null || "".equals(sVskdCngTpCd) ? tmpVO.getVskdCngTpCd() : sVskdCngTpCd;
				
				tmpVO.setVskdTpCd		(sVskdTpCd			);
				tmpVO.setVskdCngTpCd	(sVskdCngTpCd		);
				
				if(sBkgAtchFlg != null && !"".equals(sBkgAtchFlg)){
					tmpVO.setBkgAtchFlg	(sBkgAtchFlg		);
				}
				
				String sVtAddCallFlg	= tmpVO.getVtAddCallFlg()==null?"":tmpVO.getVtAddCallFlg();
				if("Y".equals(sVtAddCallFlg)){
					sVtAddCallDesc	= "Virtual Add Calling Port";	
				}else if("X".equals(sVtAddCallFlg)){
					sVtAddCallDesc	= "Virtual Add Calling Cancelled";
				}
				
				if("Y".equals(sVtAddCallFlg) || "X".equals(sVtAddCallFlg)){
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("-------------------------------------------------------- ");
					sbTmpHisDesc.append(sCarriageReturn);
					sbTmpHisDesc.append("ADD RMK : ").append(sVtAddCallDesc).append(" FM-[").append(tmpVO.getBfrVpsPortCd()).append("] TO-[").append(tmpVO.getAftVpsPortCd()).append("]");
				}
				
				sbTmpHisDesc.append(sCarriageReturn);				
				sbTmpHisDesc.append("======================================================== ");
				sbTmpHisDesc.append(sCarriageReturn);
				
				sSkdHisDesc				= sbTmpHisDesc.toString();
				
				tmpVO.setDiffRmk		(tmpVO.getDiffRmk	()	);
				tmpVO.setSkdCngId		(sCnvtHisCreUserId		);
				tmpVO.setSkdCngDesc		(sSkdHisDesc			);
				
				/** 'B':BOTH, 'A':After-Before History Only, 'O':Overall History Only **/
				String	sTmpHisSaveKndCd	= null;
				if(tmpVO.getHisSaveKndCd() == null || "".equals(tmpVO.getHisSaveKndCd())){
						sTmpHisSaveKndCd	= "B";
				}else{
						sTmpHisSaveKndCd	= tmpVO.getHisSaveKndCd();
				}
				
				if(isTargetForSkdHisRqstByUser && tmpVO.getIstargetforskdhisbyuser() && !"O".equals(sTmpHisSaveKndCd)){
					dbDao.createVesselScheduleExtraChangeHistory	(tmpVO);
				}
				
				
				/** Only for saving by VVD ********************************/
				VslSkdCngHisDtlVOList.add						(tmpVslSkdCngHisDtlVO);
			}
			
			/* ============================================================================
			 * Creation for Vessel Schedule History ::2015-05-08::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_HIS
			 * ============================================================================
			 */
					
			/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
			 * VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD V1
			 * - sVslSkdCngTpCd
			 * ------------------------------------------------------
			 * 'N' : Vessel Schedule 최초생성. 
			 * ------------------------------------------------------
			 * ''  : Normal UPDATE
			 * 'S' : Port SKIP
			 * 'O' : Phase OUT
			 * 'Q' : Phase OUT Cancel
			 * 'V' : VVD DELETE
			 * 'L' : Lane 변경
			 * 'E' : ETA, ETB, ETD
			 * 'Y' : YARD 변경
			 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
			 * ------------------------------------------------------
			 * 'A' : Add Calling
			 * 'B' : Add Calling Cancel
			 * 'U' : Auto Update (by Actual Schedule)
			 * ------------------------------------------------------
			 * 'D' : Virtual Port Deletion
			 * 'T' : Actual Port Deletion
			 * ------------------------------------------------------
			 * 'M' : Holding/Turning Port INSERT
			 * 'I' : Normal/Turning Port INSERT
			 * 'J' : Virtual Port INSERT
			 * 'F' : Proforma Type Update
			 * ------------------------------------------------------
			 */
			
			
			
			
			
			/* ============================================================================
			 * Creation for Vessel Schedule History ::2015-05-23::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_CNG_HIS + VSK_VSL_SKD_CNG_HIS_DTL
			 * ============================================================================
			 */
					
			/** VESSEL SCHEDULE CHANGE/CREATION TYPE CODE **
			 * VSK_VSL_SKD_CNG_HIS.VSKD_CNG_TP_CD V1
			 * - sVslSkdCngTpCd
			 * ------------------------------------------------------
			 * 'N' : Vessel Schedule 최초생성. 
			 * ------------------------------------------------------
			 * ''  : Normal UPDATE
			 * 'S' : Port SKIP
			 * 'O' : Phase OUT
			 * 'Q' : Phase OUT Cancel
			 * 'V' : VVD DELETE
			 * 'L' : Lane 변경
			 * 'E' : ETA, ETB, ETD
			 * 'Y' : YARD 변경
			 * 'P' : PORT의 Calling Indicator Seq.(CLPT_IND_SEQ) 변경
			 * ------------------------------------------------------
			 * 'A' : Add Calling
			 * 'B' : Add Calling Cancel
			 * 'U' : Auto Update (by Actual Schedule)
			 * ------------------------------------------------------
			 * 'D' : Virtual Port Deletion
			 * 'T' : Actual Port Deletion
			 * ------------------------------------------------------
			 * 'M' : Holding/Turning Port INSERT
			 * 'I' : Normal/Turning Port INSERT
			 * 'J' : Virtual Port INSERT
			 * 'F' : Proforma Type Update
			 * ------------------------------------------------------
			 */
			String			tempVVD		= "";
			List<String>	VVDList		= new ArrayList<String>();
			
			for(VslSkdCngHisDtlVO tmpSkdCngHisDtlVO:VslSkdCngHisDtlVOList){
				
				tempVVD													= tmpSkdCngHisDtlVO.getVslCd()+tmpSkdCngHisDtlVO.getSkdVoyNo()+tmpSkdCngHisDtlVO.getSkdDirCd();
				
				if(!VVDList.contains(tempVVD)){
					
					String	sHisVvdSeq									= dbDao.createVesselScheduleOverallChangeHistorySequence();
					String  sTmpHisDelProhiFlg							= tmpSkdCngHisDtlVO.getVskdCngTpCd() != null && ("D".equals(tmpSkdCngHisDtlVO.getVskdCngTpCd()) || "N".equals(tmpSkdCngHisDtlVO.getVskdCngTpCd())) ? "Y" : "N";
					
					if(isDelProcSeperate){
						
						tmpSkdCngHisDtlVO.setHisVvdSeq									(sHisVvdSeq			);
						tmpSkdCngHisDtlVO.setHisDeltProhiFlg							(sTmpHisDelProhiFlg	);
						dbDao.createVesselScheduleOverallChangeHistoryForDeletionOnly	(tmpSkdCngHisDtlVO	);
						
					}else{
						
						tmpSkdCngHisDtlVO.setHisVvdSeq									(sHisVvdSeq			);
						tmpSkdCngHisDtlVO.setHisDeltProhiFlg							(sTmpHisDelProhiFlg	);
						dbDao.createVesselScheduleOverallChangeHistory					(tmpSkdCngHisDtlVO	);
						
					}
					
					if(!"Y".equals(sTmpHisDelProhiFlg)){
						dbDao.createVesselScheduleOverallChangeHistoryDetail(tmpSkdCngHisDtlVO);		
					}
				
				}
				
				if(tempVVD != null)		VVDList.add(tempVVD);
				
			}
										
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
}

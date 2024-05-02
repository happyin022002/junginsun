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
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
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
public class InterfaceScheduleToExternalBackEndJob extends BackEndCommandSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;
		
	/**
	 * Change Notification
	 */
	private List<VskVipsIfMstVO> vskVipsIfMstVOs;
	
	/**
	 * Change Notification
	 */
	private List<VskVipsIfDtlVO> vskVipsIfDtlVOs;
	
	/**
	 * Change Notification
	 */
	private String sRevEventTypeVoyager;
	
	/**
	 * Change Notification
	 * @param List<VskVipsIfMstVO> vskVipsIfMstVO
	 */
	public void setVskVipsIfMstVOs(List<VskVipsIfMstVO> vskVipsIfMstVOs) {
		this.vskVipsIfMstVOs = vskVipsIfMstVOs;
	}
	/**
	 * Change Notification
	 * @param List<VskVipsIfDtlVO> vskVipsIfDtlVO
	 */
	public void setVskVipsIfDtlVOs(List<VskVipsIfDtlVO> vskVipsIfDtlVOs) {
		this.vskVipsIfDtlVOs = vskVipsIfDtlVOs;
	}
	/**
	 * Change Notification
	 * @param String sRevEventTypeVoyager
	 */
	public void setFromEventSystem(String sRevEventTypeVoyager) {
		this.sRevEventTypeVoyager = sRevEventTypeVoyager;
	}
	
	/**
	 * Change Notification 실행반영한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		this.createVskVipsIfBackEndJob(this.vskVipsIfMstVOs, this.vskVipsIfDtlVOs, this.sRevEventTypeVoyager); 
		return null;
	}	

	/**
	 * Vessel Schedule 변경사항에 대한 이력발송<br>
	 * 
	 * @param List<VskVipsIfMstVO> vskVipsIfMstVOs
	 * @param List<VskVipsIfDtlVO> vskVipsIfDtlVOs
	 * @param String sRevEventTypeVoyager
	 * @exception EventException
	 */
	private void createVskVipsIfBackEndJob(List<VskVipsIfMstVO> vskVipsIfMstVOs, List<VskVipsIfDtlVO> vskVipsIfDtlVOs, String sEventTypeVoyager) throws EventException {
		
		try {
			
			log.info("\n*********************************************************************************");
			log.info("\n\n =================== VIPS INTERFACE STARTING ==================================");
			log.info("\n   =================== BACK END JOB > createVskVipsIfBackEndJob");
			log.info("\n   =================== original sRevEventTypeVoyager ["+sRevEventTypeVoyager+"]");
			log.info("\n*********************************************************************************");
			
			if(vskVipsIfMstVOs == null || vskVipsIfMstVOs.size() == 0)	return;
			if(vskVipsIfDtlVOs == null)									vskVipsIfDtlVOs	= new ArrayList<VskVipsIfDtlVO>();
			
			InterfaceScheduleToExternalDBDAO	dbDao = new InterfaceScheduleToExternalDBDAO();
			
			/**
			 * Regeneration for another direction schedule
			 * STEP 1. Searching another direction schedule
			 * STEP 2. Checking searched schedule whether exist or not
			 * STEP 3. Appending another direction schedule when it does not exist in port schedule VO
			 * STEP 4. Arranging port schedule VO in order vessel, voyage
			 *         or
			 *         Using Map in order to check unique key(VIPS_IF_SEQ)
			 */
			
			/** STEP 1. **/
			List<VskVipsIfMstVO>	tmpPairVipsIfMstVOs	= dbDao.searchPairVVDforVipsIfMst(vskVipsIfMstVOs);
			
			log.info("\n\n   =================== tmpPairVipsIfMstVOs VVD Count is ["+tmpPairVipsIfMstVOs.size()+"]\n\n");
			
			
			/** STEP 2. **/
			for(VskVipsIfMstVO tmpVo:tmpPairVipsIfMstVOs){
				
				vskVipsIfMstVOs.add		(tmpVo);		/** STEP 3. **/
				
				List<VskVipsIfDtlVO> tmpVos	= dbDao.searchPairPortScheduleList(tmpVo);
				
				log.info("\n\n   =================== tmpPairVipsIfMstVOs VVD Port Count is ["+tmpVos.size()+"]\n\n");
				
				for(VskVipsIfDtlVO tmpVo2:tmpVos){
					vskVipsIfDtlVOs.add	(tmpVo2);		/** STEP 3. **/
				}
			}
			
			Map<String, String> tmpMapVoyage2			= new HashMap<String, String>();
			List<VskVipsIfMstVO> tmpVskVipsIfMstVOs2	= new ArrayList<VskVipsIfMstVO>();
			String tmpCurVoyage2						= "";
			for(VskVipsIfMstVO tmpVo:vskVipsIfMstVOs){
				
				tmpCurVoyage2	= tmpVo.getVslCd() + tmpVo.getSkdVoyNo();
				
				if(tmpMapVoyage2.isEmpty()){
					tmpMapVoyage2.put(tmpCurVoyage2, tmpCurVoyage2);
					tmpVskVipsIfMstVOs2.add(tmpVo);
				}else if(!tmpMapVoyage2.containsKey(tmpCurVoyage2)){
					tmpMapVoyage2.put(tmpCurVoyage2, tmpCurVoyage2);
					tmpVskVipsIfMstVOs2.add(tmpVo);
				}
			}
			
			List<VskVipsIfMstVO> sortedVskVipsIfMstVOs	= new ArrayList<VskVipsIfMstVO>();
			
			/** STEP 4. **/
			for(int i=0; i<tmpVskVipsIfMstVOs2.size(); i++){
				
				VskVipsIfMstVO tmpVo	= tmpVskVipsIfMstVOs2.get(i);
				
				for(VskVipsIfMstVO tmpVo2:vskVipsIfMstVOs){
					if(		tmpVo.getVslCd().equals		(tmpVo2.getVslCd()) 
						&&	tmpVo.getSkdVoyNo().equals	(tmpVo2.getSkdVoyNo())){
						sortedVskVipsIfMstVOs.add(tmpVo2);
					}
				}
				
			}
			
			sRevEventTypeVoyager	= sRevEventTypeVoyager == null || "".equals(sRevEventTypeVoyager) ? "N" : sRevEventTypeVoyager;
			
			//String	sCurTime		= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()));
			//String	sCarriageReturn	= "\n";
			
			String  sNewVipsIfSeq 			= null;
			
			String	sTmpHdrCurVoyage	= "";
			String	sTmpHdrPreVoyage	= "";
			boolean	isTargetHdr			= false;
			
			boolean isExistVoyage		= false;
			String  sTmpVvdDelCd		= null;
			
			String	sTmpMstPreVVD		= "";
			String	sTmpMstCurVVD		= "";
			
			VskVipsIfMstVO tmpVskVipsIfMstVO	= new VskVipsIfMstVO();

			for(int i=0; i<sortedVskVipsIfMstVOs.size(); i++){
				
				VskVipsIfMstVO 		voHdr 	= sortedVskVipsIfMstVOs.get(i);
				VskVipsIfMstVO 		voMst 	= sortedVskVipsIfMstVOs.get(i);
				
				String	sTmpLastestIfRsltCd	= "";
				String	sTmpLastestInsfDvCd	= "";
				String  sTmpNewVipsIfTgtFlg	= "";
				String	sTmpNewInsfDvCd		= "";
				
				sTmpHdrCurVoyage			= voHdr.getVslCd()+voHdr.getSkdVoyNo();
				sTmpMstCurVVD				= voHdr.getVslCd()+voHdr.getSkdVoyNo()+voHdr.getSkdDirCd();
				
				if(!sTmpHdrCurVoyage.equals(sTmpHdrPreVoyage)){
					isTargetHdr				= true;
					sNewVipsIfSeq 			= dbDao.searchVskVipsIfSeqNo ();
					
					/** STEP 4. **/
					isExistVoyage			= dbDao.checkExistForSpecificVoyage				(voHdr);
					if(!isExistVoyage)		sRevEventTypeVoyager = "D";
					else					sRevEventTypeVoyager = "U";
					
					tmpVskVipsIfMstVO		= dbDao.checkInterfaceStatusforSpecificVoyage	(voHdr);
					
				}else{
					isTargetHdr				= false;
				}
				
				/** Initialization **/
				voHdr.setVipsIfSeq			(sNewVipsIfSeq);
				voHdr.setInsfDvCd			("X");			
				voHdr.setVipsIfTgtFlg		("X");
				/********************/
				
				log.info("\n*********************************************************************************");
				log.info("\n   =================== isExistVoyage for rev is ["+isExistVoyage+"]");
				log.info("\n   =================== revised sRevEventTypeVoyager ["+sRevEventTypeVoyager+"] ["+voHdr.getVslCd()+voHdr.getSkdVoyNo()+"]");
				log.info("\n*********************************************************************************");
				
				if("D".equals(sEventTypeVoyager) && !dbDao.checkExistForSpecificVVD(voMst)){
					sTmpVvdDelCd	= "D";
				}else{
					sTmpVvdDelCd	= "U";
				}

				
				if(!sTmpMstCurVVD.equals(sTmpMstPreVVD)){
					
					/**=================================================================================== 
					 * Make a decision whether 'I' or 'U' or 'D'
					 * =================================================================================== **/
				
					/**-----------------------------------------------------------------------------------
					 *  <<SKD CREATION>>
					 * -----------------------------------------------------------------------------------
					 * 
					 * ----------------------------------------------------------------------------------
					 **/
						
					if(tmpVskVipsIfMstVO != null){
						
						sTmpLastestIfRsltCd			= tmpVskVipsIfMstVO.getLatestIfRsltCd();
						sTmpLastestInsfDvCd			= tmpVskVipsIfMstVO.getLatestInsfDvCd();
						
						/** <<SKD CREATION>> starting :: 'CRE_I_I_I'+'CRE_UI_UI_I'+'CRE_U_U_DI' **/
						if("N".equals(sRevEventTypeVoyager) || "U".equals(sRevEventTypeVoyager)){
							
							sTmpNewVipsIfTgtFlg	= "Y";
							
							if("*".equals(sTmpLastestIfRsltCd)){
								
								sTmpNewInsfDvCd	= "I";
								
							}else if("S".equals(sTmpLastestIfRsltCd)){
								
								if("I".equals(sTmpLastestInsfDvCd)){
									sTmpNewInsfDvCd	= "U";
								}else if("U".equals(sTmpLastestInsfDvCd)){
									sTmpNewInsfDvCd	= "U";
								}else if("D".equals(sTmpLastestInsfDvCd)){
									sTmpNewInsfDvCd	= "I";
								}
								
							}else if("E".equals(sTmpLastestIfRsltCd)){
								
								sTmpNewInsfDvCd	= sTmpLastestInsfDvCd;
							}
							
						}else if("D".equals(sRevEventTypeVoyager)){
							
							sTmpNewInsfDvCd				= "D";
							
							if("*".equals(sTmpLastestIfRsltCd)){
								
								sTmpNewVipsIfTgtFlg		= "N";
								
							}else if("S".equals(sTmpLastestIfRsltCd)){
								
								if("I".equals(sTmpLastestInsfDvCd)){
									sTmpNewVipsIfTgtFlg	= "Y";
								}else if("U".equals(sTmpLastestInsfDvCd)){
									sTmpNewVipsIfTgtFlg	= "Y";
								}else if("D".equals(sTmpLastestInsfDvCd)){
									sTmpNewVipsIfTgtFlg	= "N";
								}
								
							}else if("E".equals(sTmpLastestIfRsltCd)){
								
								if("I".equals(sTmpLastestInsfDvCd)){
									sTmpNewVipsIfTgtFlg	= "N";
								}else if("U".equals(sTmpLastestInsfDvCd)){
									sTmpNewVipsIfTgtFlg	= "Y";
								}else if("D".equals(sTmpLastestInsfDvCd)){
									sTmpNewVipsIfTgtFlg	= "Y";
								}
								
							}
							
						}
							
							
						log.info("\n*********************************************************************************");
						log.info("\n   =================== isExistVoyage for rev is ["+isExistVoyage+"]");
						log.info("\n   =================== revised sRevEventTypeVoyager ["+sRevEventTypeVoyager+"] ["+voHdr.getVslCd()+voHdr.getSkdVoyNo()+voHdr.getSkdDirCd()+"]");
						log.info("\n   =================== sTmpLastestIfRsltCd ["+sTmpLastestIfRsltCd+"]");
						log.info("\n   =================== sTmpLastestInsfDvCd ["+sTmpLastestInsfDvCd+"]");
						log.info("\n   =================== sTmpNewInsfDvCd ["+sTmpNewInsfDvCd+"]");
						log.info("\n   =================== sTmpNewVipsIfTgtFlg ["+sTmpNewVipsIfTgtFlg+"]");
						log.info("\n---------------------------------------------------------------------------------");
						log.info("\n   =================== sTmpVvdDelCd ["+sTmpVvdDelCd+"]");
						log.info("\n*********************************************************************************");
						
						
						if("N".equals(sRevEventTypeVoyager) || "U".equals(sRevEventTypeVoyager)){
							
							voHdr.setVipsIfSeq				(sNewVipsIfSeq);
							dbDao.modifyVipsIfHdrInterfaceStatusforExclOldVoyage(voHdr);
							
							if(isTargetHdr){
								voHdr.setInsfDvCd			(sTmpNewInsfDvCd);
								voHdr.setVipsIfTgtFlg		(sTmpNewVipsIfTgtFlg);
								voHdr.setVipsIfRmk			("Creation/Update");
								dbDao.addVskVipsIfHdr		(voHdr);									
							}
						
							voHdr.setInsfDvCd				("U");
							voHdr.setVvdDelCd				(sTmpVvdDelCd);
							
							dbDao.addVskVipsIfMst			(voHdr);	
							
						}else if("D".equals(sRevEventTypeVoyager)){
						
							if(isTargetHdr){
								voHdr.setVipsIfSeq			(sNewVipsIfSeq);
								dbDao.modifyVipsIfHdrInterfaceStatusforExclOldVoyage(voHdr);
								
								voHdr.setInsfDvCd			(sTmpNewInsfDvCd);
								voHdr.setVipsIfTgtFlg		(sTmpNewVipsIfTgtFlg);	
								voHdr.setVipsIfRmk			("Deletion");
								dbDao.addVskVipsIfHdr		(voHdr);
								
								voHdr.setVvdDelCd			(sTmpVvdDelCd);
								dbDao.addVskVipsIfMstUsingVipsIfHis	(voHdr);	
							}
						}
					}
					
					if("N".equals(sRevEventTypeVoyager) || "U".equals(sRevEventTypeVoyager)){
						
//						for(int j=0; j<vskVipsIfDtlVOs.size(); j++){
//							
//							VskVipsIfDtlVO voDtl			= vskVipsIfDtlVOs.get(j);	
//							
//							sTmpDtlVVD						= voDtl.getVslCd()+voDtl.getSkdVoyNo()+voDtl.getSkdDirCd();
//							
//							if(sTmpDtlVVD.equals(sTmpMstCurVVD)){
//								
//								voDtl.setVipsIfSeq		(sNewVipsIfSeq);	
//								dbDao.addVskVipsIfDtl 	(voDtl); 	
//							}
//						}
						
						//if("D".equals(sTmpVvdDelCd)){
						//	for(int j=0; j<vskVipsIfDtlVOs.size(); j++){
						//	VskVipsIfDtlVO voDtl			= vskVipsIfDtlVOs.get(j);	
						//	sTmpDtlVVD						= voDtl.getVslCd()+voDtl.getSkdVoyNo()+voDtl.getSkdDirCd();
						//		if(sTmpDtlVVD.equals(sTmpMstCurVVD)){
						//			voDtl.setVipsIfSeq		(sNewVipsIfSeq);	
						//			dbDao.addVskVipsIfDtl 	(voDtl); 	
						//		}
						//	}
							
						//}else{
							
							voHdr.setVipsIfSeq					(sNewVipsIfSeq);
							dbDao.addVskVipsIfDtlfromPortSkdList(voHdr);
							
						//}
						
					}else if("D".equals(sRevEventTypeVoyager)){
						
						if(isTargetHdr){
							voHdr.setVipsIfSeq			(sNewVipsIfSeq);
							dbDao.addVskVipsIfDtlUsingVipsIfHis(voHdr);							
						}
					}
					
				}
				sTmpHdrPreVoyage		= sTmpHdrCurVoyage;
				sTmpMstPreVVD			= sTmpMstCurVVD;
			}
										
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
}

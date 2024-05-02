/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalBCImpl.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.integration.CargoApprovalCommonDBDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.vo.ScgCargoApprovalCommonVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration.PartnerLinesDangerousCargoApprovalDBDAO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrScgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/** 
 * APLS-CargoLoadingApproval Business Logic Basic Command implementation<br>
 * - Handling business transactions of APLS-CargoLoadingApproval<br>
 *
 * @author
 * @see VOP_SCG_0022EventResponse,PartnerLinesDangerousCargoApprovalBC
 * @since J2EE 1.6
 */
public class PartnerLinesDangerousCargoApprovalBCImpl extends BasicCommandSupport implements PartnerLinesDangerousCargoApprovalBC {
 
	// Database Access Object
	private transient PartnerLinesDangerousCargoApprovalDBDAO dbDao = null;
	
	private transient CargoApprovalCommonDBDAO dbDao2 = null;

	/**
	 * PartnerLinesDangerousCargoApprovalBCImpl object creation<br>
	 * PartnerLinesDangerousCargoApprovalDBDAO creation<br>
	 */
	public PartnerLinesDangerousCargoApprovalBCImpl() {
		dbDao = new PartnerLinesDangerousCargoApprovalDBDAO();
		
		dbDao2 = new CargoApprovalCommonDBDAO();
	}
	/**
	 * VOP_SCG_0022 : Retrieve <br>
	 * SPCL CGO APVL for Partner Lines retrieve <br>
	 * 
	 * @param partnerApprovalRequestVO   PartnerApprovalRequestVO
	 * @return List<PartnerApprovalRequestVO>
	 * @exception EventException
	 */
	public List<PartnerApprovalRequestVO> searchPatnerSCGList(PartnerApprovalRequestVO partnerApprovalRequestVO) throws EventException {
		try {			
			return dbDao.searchPatnerSCGList(partnerApprovalRequestVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0022 : Save(return:key, prnr_cgo_rqst_seq) <br>
	 * SPCL CGO APVL for Partner Lines create,modify,delete <br>
	 * 
	 * @param partnerApprovalRequestVO PartnerApprovalRequestVO[]
	 * @param keys List<String>
	 * @param account SignOnUserAccount
	 * @return List<Map>
	 * @exception EventException
	 */
	public List<Map> managePartnerSCGReturn(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException{
		
		List<Map> returnVal = new ArrayList<Map>();
		
		try {
		
			String					sFinalPrnrCgoRqstSeq	= null;
			String					sFinalSpclCgoRqstSeq	= null;
			
			if(partnerApprovalRequestVO != null) {
			
				String					sFinalAproStsCd				= null;
				
				ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     		= partnerApprovalRequestVO.getScgPrnrAproRqstVOs();	
				ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  		= partnerApprovalRequestVO.getScgPrnrAproRqstCgoVOs();
				ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs 		= partnerApprovalRequestVO.getScgPrnrAproRqstFileVOs();
				
				
				// Request
				List<ScgPrnrAproRqstVO> finalVoList1 				= new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> deleteVoList1 				= new ArrayList<ScgPrnrAproRqstVO>();
				
				
				// Cargo
				List<ScgPrnrAproRqstCgoVO> finalVoList2 			= new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				List<ScgPrnrAproRqstCgoVO> deleteVoList2 			= new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> deleteVoList2All			= new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> rqstNoVoList2 			= new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				// Attach File
				List<ScgPrnrAproRqstFileVO> finalAttachFileVoList3 	= new ArrayList<ScgPrnrAproRqstFileVO>();
				List<ScgPrnrAproRqstFileVO> deleteVoList3 			= new ArrayList<ScgPrnrAproRqstFileVO>();
				
				boolean isRequest 	= false;
				boolean isAuth 		= false;
				boolean isEDI 		= false;
				
				String mode = partnerApprovalRequestVO.getMode();
				
				/** "R":Requst, "":Save **/
				if("R".equals(mode)) isRequest = true;
				
				if("A".equals(mode)) isAuth = true;
				if(scgPrnrAproRqstVOs != null) { //TODO:scgPrnrAproRqstCgoVOs가 아닌지??
					
					//Sort by booking number and Cargo number
					int bkgRqtCt = scgPrnrAproRqstVOs.length;
					int cagoRqtCt = scgPrnrAproRqstCgoVOs==null?0:scgPrnrAproRqstCgoVOs.length;
					List<String> dupCheckList = new ArrayList<String>();
					String	sTmpKey	= "";
					//String  TmpKeyCgoVo = "";
					
					// 1. Request Info Setting(SCG_PRNR_APRO_RQST)
					for ( int bkgIdx=0; bkgIdx<bkgRqtCt; bkgIdx++ ) {
						if("EDI".equals(scgPrnrAproRqstVOs[bkgIdx].getSrcTpCd())) isEDI = true;
						scgPrnrAproRqstVOs[bkgIdx].setRgnShpOprCd(partnerApprovalRequestVO.getRgnShpOprCd());
						scgPrnrAproRqstVOs[bkgIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
						scgPrnrAproRqstVOs[bkgIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
						if("Y".equals(scgPrnrAproRqstVOs[bkgIdx].getDgFlg())) {
							scgPrnrAproRqstVOs[bkgIdx].setSpclCgoCateCd("DG");
						} 
						if("Y".equals(scgPrnrAproRqstVOs[bkgIdx].getAwkFlg())) {
							scgPrnrAproRqstVOs[bkgIdx].setSpclCgoCateCd("AK");
						} 
//						scgPrnrAproRqstVOs[bkgIdx].setSrcTpCd("MNL");
						scgPrnrAproRqstVOs[bkgIdx].setCreUsrId(account.getUsr_id());
						scgPrnrAproRqstVOs[bkgIdx].setUpdUsrId(account.getUsr_id());
						scgPrnrAproRqstVOs[bkgIdx].setRqstOfcCd(account.getOfc_cd());
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by SLAN_CD.		
						
						if(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() != null && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo()) && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getSlanCd())) {
							if ("I".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								finalVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							} else if ("U".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								finalVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							} else if ("D".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								sTmpKey = scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() + scgPrnrAproRqstVOs[bkgIdx].getSpclCgoRqstSeq()+ scgPrnrAproRqstVOs[bkgIdx].getPrnrCgoRqstSeq();
								if(!dupCheckList.contains(sTmpKey)){
									deleteVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);	
									//2016-05-31
									deleteVoList2All.add(scgPrnrAproRqstCgoVOs[bkgIdx]);
								}
								dupCheckList.add	(sTmpKey);
							}
						}	
						
					}
					

					for ( int cgoIdx=0; cgoIdx<cagoRqtCt; cgoIdx++ ) {
						
						// compulsory items handling exception
						Method[] methods  = scgPrnrAproRqstCgoVOs[cgoIdx].getClass().getMethods();		
						String gMethodNm = "", sMethodNm = "";
						for(int mIdx1=0; mIdx1<methods.length; mIdx1++) {
							Method gMethod = methods[mIdx1];
							if (gMethod.getName().indexOf("get") != -1) {								
								if(gMethod.getReturnType().getName().equals("java.lang.String")) {
									String val = (String)gMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx]);									
						            if(val == null || "".equals(val)) {
						            	gMethodNm = gMethod.getName();
										gMethodNm = gMethodNm.substring(3,gMethodNm.length());										
							            for(int mIdx2=0; mIdx2<methods.length; mIdx2++) {
											Method sMethod = methods[mIdx2];
											sMethodNm = sMethod.getName();
											sMethodNm = sMethodNm.substring(3,sMethodNm.length());
											if(sMethod.getName().indexOf("set") != -1 && gMethodNm.equals(sMethodNm)) {
												if(gMethodNm.equals("AproRefNo")||gMethodNm.equals("PckQty")||
												   gMethodNm.equals("InN1stImdgPckQty")||gMethodNm.equals("InN2ndImdgPckQty")||
												   gMethodNm.equals("MaxInPckQty")||gMethodNm.equals("MeasQty")||
												   gMethodNm.equals("OutN1stImdgPckQty")||gMethodNm.equals("OutN2ndImdgPckQty")||
												   gMethodNm.equals("ImdgUnNo")||gMethodNm.equals("ImdgUnNoSeq")
											      ) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "0");
												} else if(gMethodNm.equals("ClodFlg")) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "N");
												}
											}
							            }
						            }
								}
					        }
						}
						
						// 2. SCG Info Setting
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by CNTR_SEQ.
						if(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq() != null && !"".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq())) {
							scgPrnrAproRqstCgoVOs[cgoIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
							scgPrnrAproRqstCgoVOs[cgoIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthOfcCd(account.getOfc_cd());
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthUsrId(account.getUsr_id());
							scgPrnrAproRqstCgoVOs[cgoIdx].setCreUsrId(account.getUsr_id());
							scgPrnrAproRqstCgoVOs[cgoIdx].setUpdUsrId(account.getUsr_id());
							if(isRequest) {
								scgPrnrAproRqstCgoVOs[cgoIdx].setAuthStsCd("R");
							}
							String spclCgoCateCd = "DG";
							if("N".equals(partnerApprovalRequestVO.getDgFlg()) &&
							   "Y".equals(partnerApprovalRequestVO.getAwkFlg())) {
								spclCgoCateCd = "AK";
							}
							scgPrnrAproRqstCgoVOs[cgoIdx].setSpclCgoCateCd(spclCgoCateCd);
							
							if ("I".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								finalVoList2.add	(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if ("U".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								finalVoList2.add	(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if ("D".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								deleteVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
							
							//Sorting transactions to create verification numbers
							if ("Y".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getAuthStsCd()) || "D".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								rqstNoVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
						}
					}
					
					//1. delete process
				
					if (deleteVoList2.size() > 0) {
						// 1-1. Delete Cargo
						//System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
//						dbDao.removePartnerSCGCGO(deleteVoList2);
//				    	// 1-2. If all cargoes are deleted, delete request.
//						Iterator list 	= deleteVoList1.iterator();
//						String[] rmList = new String[deleteVoList1.size()];
//						int isCt = 0, expCt = 0;
//						while (list.hasNext()) {
//							ScgPrnrAproRqstVO vo = (ScgPrnrAproRqstVO) list.next();
//							isCt = dbDao.searchPatnerSCGCGOIsSeq(vo);
//							if (isCt > 0) {
//								rmList[expCt] = "Y";
//							}
//							expCt++;
//
//						}
//						for (int delCt = rmList.length - 1; delCt >= 0; delCt--) {
//							if ("Y".equals(rmList[delCt]))
//								deleteVoList1.remove(delCt);
//						}
						//2016-05-31
						if (deleteVoList1.size() > 0) {
							//System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							//2015-12-17 VOP_SCG_0022에서 Request 단위로 지울 때, Attached File 이 있으면, 먼저 지운 후 지운다.
							Iterator it = deleteVoList1.iterator();
							List<ScgPrnrAproRqstFileVO> fileDelList = new ArrayList<ScgPrnrAproRqstFileVO>();
							while (it.hasNext()) {
								ScgPrnrAproRqstVO vo = (ScgPrnrAproRqstVO)it.next();
								ScgPrnrAproRqstFileVO fileVo = new ScgPrnrAproRqstFileVO();
								
								fileVo.setCrrCd(vo.getCrrCd());
								fileVo.setBkgRefNo(vo.getBkgRefNo());
								fileVo.setSpclCgoRqstSeq(vo.getSpclCgoRqstSeq());
								fileVo.setPrnrCgoRqstSeq(vo.getPrnrCgoRqstSeq());
								fileDelList.add(fileVo);
							}
							dbDao.removePartnerSCGAttachAll(fileDelList);
							dbDao.removePartnerSCGCGOAll(deleteVoList2All);
							dbDao.removePartnerSCG		(deleteVoList1);
						}
						else{
							// 1-1. Delete Cargo
							//System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
							dbDao.removePartnerSCGCGO(deleteVoList2);
					    	// 1-2. If all cargoes are deleted, delete request.
							Iterator list 	= deleteVoList1.iterator();
							String[] rmList = new String[deleteVoList1.size()];
							int isCt = 0, expCt = 0;
							while (list.hasNext()) {
								ScgPrnrAproRqstVO vo = (ScgPrnrAproRqstVO) list.next();
								isCt = dbDao.searchPatnerSCGCGOIsSeq(vo);
								if (isCt > 0) {
									rmList[expCt] = "Y";
								}
								expCt++;

							}
							for (int delCt = rmList.length - 1; delCt >= 0; delCt--) {
								if ("Y".equals(rmList[delCt]))
									deleteVoList1.remove(delCt);
							}	
						}

					}
					
					
					//FILE UPLOAD KEY
					Iterator<String> keyArr = null;	
					if(keys != null) keyArr = keys.iterator();
					
					if(scgPrnrAproRqstFileVOs != null) {
						for ( int i=0; i<scgPrnrAproRqstFileVOs.length; i++ ) {
							
							//FILE UPLOAD KEY SETTING
							if(keyArr != null) {
								if("Y".equals(scgPrnrAproRqstFileVOs[i].getFileSetYn()) && keyArr.hasNext()) 
									scgPrnrAproRqstFileVOs[i].setFileSavId(keyArr.next());	 
							}
							
							if (scgPrnrAproRqstFileVOs[i].getIbflag().equals("I")){
								scgPrnrAproRqstFileVOs[i].setCreUsrId(account.getUsr_id());
								scgPrnrAproRqstFileVOs[i].setUpdUsrId(account.getUsr_id());
								//insertVoList3.add(scgPrnrAproRqstFileVOs[i]);
								
								finalAttachFileVoList3.add(scgPrnrAproRqstFileVOs[i]);
							} else if (scgPrnrAproRqstFileVOs[i].getIbflag().equals("U")){
								scgPrnrAproRqstFileVOs[i].setUpdUsrId(account.getUsr_id());
								//updateVoList3.add(scgPrnrAproRqstFileVOs[i]);
								
								finalAttachFileVoList3.add(scgPrnrAproRqstFileVOs[i]);
							} else if (scgPrnrAproRqstFileVOs[i].getIbflag().equals("D")){
								deleteVoList3.add(scgPrnrAproRqstFileVOs[i]);
							}
						}
					}
					
			        	
			        	//3-2. Create request numbers.
			        	
//			        	String appendSpclCgoRqstSeq;	//existing request number for subordinate cargo : copy from screen
			        	
			        	for(int insCt1=0; insCt1<finalVoList1.size(); insCt1++) {
			        		
			        		// Seq설정 이전에 미리 설정한다.
			        		//String valKey = insertVoList1.get(insCt1).getCgoOprCd() + insertVoList1.get(insCt1).getBkgRefNo() + insertVoList1.get(insCt1).getVslCd() + insertVoList1.get(insCt1).getSkdVoyNo() + insertVoList1.get(insCt1).getSkdDirCd() + insertVoList1.get(insCt1).getPolCd() + insertVoList1.get(insCt1).getPodCd();
			        		//valStr1 = valKey + insertVoList1.get(insCt1).getPrnrCgoRqstSeq();
			        		
			        		//2015-12-22
			        		PartnerApprovalRequestVO tmpVo 	= new PartnerApprovalRequestVO();
			        		tmpVo 							= dbDao.searchScgAuthStsCd(finalVoList1.get(insCt1));
			        		String	sTmpOldAuthStsCd		= "";
			        		
			        		if(tmpVo != null){
			        			sFinalAproStsCd		= tmpVo.getUpdIndicator();	/** "INSERT", "UPDATE", "X" **/
			        			sTmpOldAuthStsCd	= tmpVo.getAuthStsCd();
			        		}else{
			        			sFinalAproStsCd	= "";
			        		}
			        		
			        		log.info("\n\n ============= sFinalAproStsCd ["+sFinalAproStsCd+"] >>> sTmpOldAuthStsCd ["+sTmpOldAuthStsCd+"] =============\n\n");
			        		
			        		/** REQUST ****************************/		        		
			        		
			        		if("INSERT".equals(sFinalAproStsCd)){
			        			
			        			if("*".equals(sTmpOldAuthStsCd)){
			        				sFinalPrnrCgoRqstSeq		= dbDao.searchMaxScgPrnrCgoRqstSeq	();
			        			}else{
			        				if(tmpVo != null){
			        					sFinalPrnrCgoRqstSeq	= tmpVo.getPrnrCgoRqstSeq			();
			        				}else{
			        					sFinalPrnrCgoRqstSeq	= "";
			        				}
			        			}
			        			
			        			log.info("\n\n ============= sFinalPrnrCgoRqstSeq ["+sFinalPrnrCgoRqstSeq+"] =============\n\n");
			        			
			        			sFinalSpclCgoRqstSeq 			= dbDao.searchPatnerSCGMaxSeq		(finalVoList1.get(insCt1));
			        			
			        			finalVoList1.get(insCt1).setPrnrCgoRqstSeq(sFinalPrnrCgoRqstSeq);
			        			finalVoList1.get(insCt1).setSpclCgoRqstSeq(sFinalSpclCgoRqstSeq);
				        		
				        		dbDao.modifyPartnerSCGLstFlg	(finalVoList1);
			        			dbDao.addPartnerSCG				(finalVoList1);
			        			
			        			
					        	List<ScgPrnrAproRqstFileVO> tmpFinalAttachFileVoList3 = new ArrayList<ScgPrnrAproRqstFileVO>();
					        	for(int i = 0; i<finalAttachFileVoList3.size(); i++){
					        		ScgPrnrAproRqstFileVO tmpVo3	= new ScgPrnrAproRqstFileVO();
					        		tmpVo3	= finalAttachFileVoList3.get	(i);
					        		tmpVo3.setPrnrCgoRqstSeq		(sFinalPrnrCgoRqstSeq);
					        		tmpVo3.setSpclCgoRqstSeq		(sFinalSpclCgoRqstSeq);
					        		
					        		tmpFinalAttachFileVoList3.add	(tmpVo3);
					        	}
					        	
				        		if(tmpFinalAttachFileVoList3 != null && tmpFinalAttachFileVoList3.size()>0)	{
				        			dbDao.addPartnerSCGAttach		(tmpFinalAttachFileVoList3);
				        		}
			        			
			        		}else if("UPDATE".equals(sFinalAproStsCd)){
			        			
			        			sFinalPrnrCgoRqstSeq			= tmpVo.getPrnrCgoRqstSeq			();
			        			sFinalSpclCgoRqstSeq 			= tmpVo.getSpclCgoRqstSeq			();
			        			
			        			finalVoList1.get(insCt1).setPrnrCgoRqstSeq(sFinalPrnrCgoRqstSeq);
			        			finalVoList1.get(insCt1).setSpclCgoRqstSeq(sFinalSpclCgoRqstSeq);
				        		
			        			dbDao.addPartnerSCG				(finalVoList1);

			        			//SCG_PRNR_RQST_UNMAP CORR UPDATE
			        			String ediUnmapDtlCds = finalVoList1.get(insCt1).getEdiUnmapDtlCd();
			        			StringTokenizer tokens = new StringTokenizer( ediUnmapDtlCds, "," );
			        			String ediUnmapDtlCd="";
			        			while(tokens.hasMoreElements()){
			        				ediUnmapDtlCd = tokens.nextToken();
			        			    ScgPrnrAproRqstVO scgPrnrAproRqstVO = new ScgPrnrAproRqstVO();
			        			    scgPrnrAproRqstVO.setCrrCd(finalVoList1.get(insCt1).getCrrCd());
			        			    scgPrnrAproRqstVO.setBkgRefNo(finalVoList1.get(insCt1).getBkgRefNo());
			        			    scgPrnrAproRqstVO.setSpclCgoRqstSeq(finalVoList1.get(insCt1).getSpclCgoRqstSeq());
			        			    scgPrnrAproRqstVO.setPrnrCgoRqstSeq(finalVoList1.get(insCt1).getPrnrCgoRqstSeq());
			        			    
			        			    scgPrnrAproRqstVO.setEdiUnmapDtlCd(ediUnmapDtlCd);

			        			    if("011".equals(ediUnmapDtlCd)){
			        			    	scgPrnrAproRqstVO.setEdiUnmapCorrRmk(finalVoList1.get(insCt1).getRgnShpOprCd());
			        			    	dbDao.modifyScgPrnrRqstUnmap(scgPrnrAproRqstVO);
			        			    }else if("012".equals(ediUnmapDtlCd)){
			        			    	String  unmapPolCd = finalVoList1.get(insCt1).getUnmapPolCd();
			        			    	String  polCd = finalVoList1.get(insCt1).getPolCd();
			        			    	if(!unmapPolCd.equals(polCd) && !"".equals(polCd)){
			        			    		scgPrnrAproRqstVO.setEdiUnmapCorrRmk(unmapPolCd + ">> " + polCd);
			        			    		dbDao.modifyScgPrnrRqstUnmap(scgPrnrAproRqstVO);
			        			    	}
			        			    }else if("013".equals(ediUnmapDtlCd)){
			        			    	
			        			    	String  unmapPodCd = finalVoList1.get(insCt1).getUnmapPodCd();
			        			    	String  podCd = finalVoList1.get(insCt1).getPodCd();
			        			    	if(!unmapPodCd.equals(podCd) && !"".equals(podCd)){
			        			    		scgPrnrAproRqstVO.setEdiUnmapCorrRmk(unmapPodCd + " >> " + podCd);
			        			    		dbDao.modifyScgPrnrRqstUnmap(scgPrnrAproRqstVO);
			        			    	}
			        			    	
			        			    //}else if("021".equals(ediUnmapDtlCd)){
			        			    	//TODO
			        			    //}else if("022".equals(ediUnmapDtlCd)){
			        			    	//TODO
			        			    }
			        			    
			        			    
			        			}
			        			
					        	List<ScgPrnrAproRqstFileVO> tmpFinalAttachFileVoList3 = new ArrayList<ScgPrnrAproRqstFileVO>();
					        	for(int i = 0; i<finalAttachFileVoList3.size(); i++){
					        		ScgPrnrAproRqstFileVO tmpVo3	= new ScgPrnrAproRqstFileVO();
					        		tmpVo3	= finalAttachFileVoList3.get	(i);
					        		tmpVo3.setPrnrCgoRqstSeq		(sFinalPrnrCgoRqstSeq);
					        		tmpVo3.setSpclCgoRqstSeq		(sFinalSpclCgoRqstSeq);
					        		
					        		tmpFinalAttachFileVoList3.add			(tmpVo3);
					        	}
					        	
				        		if(tmpFinalAttachFileVoList3 != null && tmpFinalAttachFileVoList3.size()>0)	{
				        			dbDao.addPartnerSCGAttach		(tmpFinalAttachFileVoList3);
				        		}
			        		}
			        		
			        		log.info("\n\n ============= sFinalPrnrCgoRqstSeq ["+sFinalPrnrCgoRqstSeq+"] =============\n\n");
			        		log.info("\n\n ============= sFinalSpclCgoRqstSeq ["+sFinalSpclCgoRqstSeq+"] =============\n\n");
			        		
			        		Map<String, String> seq = new HashMap<String, String>();
			        		//seq.put(valKey, sFinalSpclCgoRqstSeq+","+sFinalPrnrCgoRqstSeq);
			        		returnVal.add(seq);
			        	}
			        	
			        	//3-3. Create and label request number

					
		        	//3-4. Create request.(Request)
		        	//3-5. Create Cargo.request(request>cargo순으로 등록(부모키))
			        	
			        if(finalVoList2.size()>0){
			        	
			        	List<ScgPrnrAproRqstCgoVO> tmpFinalVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
			        	for(int i = 0; i<finalVoList2.size(); i++){
			        		ScgPrnrAproRqstCgoVO tmpVo	= new ScgPrnrAproRqstCgoVO();
			        		tmpVo	= finalVoList2.get	(i);
			        		tmpVo.setPrnrCgoRqstSeq		(sFinalPrnrCgoRqstSeq);
			        		tmpVo.setSpclCgoRqstSeq		(sFinalSpclCgoRqstSeq);
			        		tmpVo.setAuthStsCd			(isRequest == true?"R":"");
			        		
			        		//tmpVo.setSkdVoyNo			(insertVoList1.get(0).getSkdVoyNo());
			        		//tmpVo.setPolCd				(insertVoList1.get(0).getPolCd());
			        		
			        		tmpFinalVoList2.add			(tmpVo);
			        		
			        		
		        			//SCG_PRNR_RQST_CGO_UNMAP CORR UPDATE
		        			String ediUnmapDtlCds = finalVoList2.get(i).getEdiUnmapDtlCd();
		        			StringTokenizer tokens = new StringTokenizer( ediUnmapDtlCds, "," );
		        			String ediUnmapDtlCd="";
		        			while(tokens.hasMoreElements()){
		        				ediUnmapDtlCd = tokens.nextToken();
		        			    ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO = new ScgPrnrAproRqstCgoVO();
		        			    scgPrnrAproRqstCgoVO.setCrrCd(finalVoList2.get(i).getCrrCd());
		        			    scgPrnrAproRqstCgoVO.setBkgRefNo(finalVoList2.get(i).getBkgRefNo());
		        			    scgPrnrAproRqstCgoVO.setSpclCgoRqstSeq(finalVoList2.get(i).getSpclCgoRqstSeq());
		        			    scgPrnrAproRqstCgoVO.setPrnrCgoRqstSeq(finalVoList2.get(i).getPrnrCgoRqstSeq());
		        			    scgPrnrAproRqstCgoVO.setEdiUnmapDtlCd(ediUnmapDtlCd);

		        			    if("101".equals(ediUnmapDtlCd)){
		        			    	
		        			    	String  unmapCntrTpszCd = finalVoList2.get(i).getUnmapCntrTpszCd();
		        			    	String  cntrTpszCd = finalVoList2.get(i).getCntrTpszCd();
		        			    	if(!unmapCntrTpszCd.equals(cntrTpszCd) && !"".equals(cntrTpszCd)){
		        			    		scgPrnrAproRqstCgoVO.setEdiUnmapCorrRmk(unmapCntrTpszCd + ">> " + cntrTpszCd);
		        			    		dbDao.modifyScgPrnrRqstCgoUnmap(scgPrnrAproRqstCgoVO);
		        			    	}

		        			    }else if("201".equals(ediUnmapDtlCd)){
		        			    	scgPrnrAproRqstCgoVO.setEdiUnmapCorrRmk(finalVoList2.get(i).getImdgUnNoSeq());
		        			    	dbDao.modifyScgPrnrRqstCgoUnmap(scgPrnrAproRqstCgoVO);
		        			    }else if("202".equals(ediUnmapDtlCd)){
		        			    	scgPrnrAproRqstCgoVO.setEdiUnmapCorrRmk(finalVoList2.get(i).getHzdDesc());
		        			    	dbDao.modifyScgPrnrRqstCgoUnmap(scgPrnrAproRqstCgoVO);
		        			    }
		        			}
		        			
			        	}
	        			dbDao.addPartnerSCGCGO			(tmpFinalVoList2);
			        	
			        }
			        	
					//6-1. File delete process
					if ( deleteVoList3.size() > 0 ) {
						dbDao.removePartnerSCGAttach(deleteVoList3);
					}
				}
//				String aaa= null;
//				if(aaa.equals("333")){
//					
//				}else{
//					
//				}
//				int aaa2 =3;
//				aaa2 = aaa2/0;
				
				// Save 결과
				Map<String, String> resultMap 	= new HashMap<String, String>();
				String sNewCreatedKey			= sFinalSpclCgoRqstSeq+","+sFinalPrnrCgoRqstSeq;
				resultMap.put					("resultMap", sNewCreatedKey);
        		returnVal.add					(resultMap);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
		
		return returnVal;
	}
	
	/**
	 * VOP_SCG_0022(AK) : Save <br>
	 * SPCL CGO APVL for Partner Lines create,modify,delete <br>
	 * 
	 * @param partnerApprovalRequestVO PartnerApprovalRequestVO[]
	 * @param keys List<String>
	 * @param account SignOnUserAccount
	 * @return int
	 * @exception EventException
	 */
	public int managePartnerSCGAK(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException{
		
		//List<Map> returnVal = new ArrayList<Map>();
		
		try {
			if(partnerApprovalRequestVO != null) {
				
				ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     = partnerApprovalRequestVO.getScgPrnrAproRqstVOs();	
				ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = partnerApprovalRequestVO.getScgPrnrAproRqstCgoVOs();
				
				// Request
				List<ScgPrnrAproRqstVO> insertVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> updateVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> deleteVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				
				// SCG
				List<ScgPrnrAproRqstCgoVO> insertVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> updateVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> deleteVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				if(scgPrnrAproRqstVOs != null) {
					
					//Sort by booking number and Cargo number
					int bkgRqtCt = scgPrnrAproRqstVOs.length;
					int cagoRqtCt = scgPrnrAproRqstCgoVOs==null?0:scgPrnrAproRqstCgoVOs.length;
					
					// 1. Request Info Setting(SCG_PRNR_APRO_RQST)
					for ( int bkgIdx=0; bkgIdx<bkgRqtCt; bkgIdx++ ) {
						scgPrnrAproRqstVOs[bkgIdx].setRgnShpOprCd(partnerApprovalRequestVO.getRgnShpOprCd());
						scgPrnrAproRqstVOs[bkgIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
						scgPrnrAproRqstVOs[bkgIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
						scgPrnrAproRqstVOs[bkgIdx].setSrcTpCd("MNL");
						scgPrnrAproRqstVOs[bkgIdx].setCreUsrId(account.getUsr_id());
						scgPrnrAproRqstVOs[bkgIdx].setUpdUsrId(account.getUsr_id());
						scgPrnrAproRqstVOs[bkgIdx].setRqstOfcCd(account.getOfc_cd());
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by SLAN_CD.						
						if(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() != null && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo()) && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getSlanCd())) {
							if ("I".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								insertVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							} else if ("U".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								updateVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							} else if ("D".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								deleteVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							}
						}
					}
					
					for ( int cgoIdx=0; cgoIdx<cagoRqtCt; cgoIdx++ ) {
						// compulsory items handling exception
						Method[] methods  = scgPrnrAproRqstCgoVOs[cgoIdx].getClass().getMethods();		
						String gMethodNm = "", sMethodNm = "";
						for(int mIdx1=0; mIdx1<methods.length; mIdx1++) {
							Method gMethod = methods[mIdx1];
							if (gMethod.getName().indexOf("get") != -1) {								
								if(gMethod.getReturnType().getName().equals("java.lang.String")) {
									String val = (String)gMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx]);									
						            if(val == null || "".equals(val)) {
						            	gMethodNm = gMethod.getName();
										gMethodNm = gMethodNm.substring(3,gMethodNm.length());										
							            for(int mIdx2=0; mIdx2<methods.length; mIdx2++) {
											Method sMethod = methods[mIdx2];
											sMethodNm = sMethod.getName();
											sMethodNm = sMethodNm.substring(3,sMethodNm.length());
											if(sMethod.getName().indexOf("set") != -1 && gMethodNm.equals(sMethodNm)) {
												if(gMethodNm.equals("AproRefNo")||gMethodNm.equals("PckQty")||
												   gMethodNm.equals("InN1stImdgPckQty")||gMethodNm.equals("InN2ndImdgPckQty")||
												   gMethodNm.equals("MaxInPckQty")||gMethodNm.equals("MeasQty")||
												   gMethodNm.equals("OutN1stImdgPckQty")||gMethodNm.equals("OutN2ndImdgPckQty")
											      ) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "0");
												} else if(gMethodNm.equals("ClodFlg")) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "N");
												}
											}
							            }
						            }
								}
					        }
						}
						// 2. SCG Info Setting
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by CNTR_SEQ.
						if(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq() != null 
								&& !"".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq())) {
							scgPrnrAproRqstCgoVOs[cgoIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
							scgPrnrAproRqstCgoVOs[cgoIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthOfcCd(account.getOfc_cd());
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthUsrId(account.getUsr_id());
							scgPrnrAproRqstCgoVOs[cgoIdx].setCreUsrId(account.getUsr_id());
							scgPrnrAproRqstCgoVOs[cgoIdx].setUpdUsrId(account.getUsr_id());
							if("".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getAuthStsCd())) {
								scgPrnrAproRqstCgoVOs[cgoIdx].setAuthStsCd("R");
							} 
							scgPrnrAproRqstCgoVOs[cgoIdx].setSpclCgoCateCd("AK");
							
							if("Y".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getAuthStsCd())) {
								if(updateVoList1.size() > 0) {
									String strSeq = scgPrnrAproRqstCgoVOs[cgoIdx].getPrnrCgoRqstSeq();
									for(int i=0;i<updateVoList1.size();i++) {
										if(strSeq.equals(updateVoList1.get(i).getPrnrCgoRqstSeq())) {
											String strAproRefNo = dbDao.makeSpclAproRefNo(updateVoList1.get(i));
											scgPrnrAproRqstCgoVOs[cgoIdx].setAproRefNo(strAproRefNo);
											break;
										}
									}
								}
							}
							
							if ("I".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								insertVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if ("U".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								updateVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if ("D".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								deleteVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
						}
					}
					
					//1. delete process
					
						
					if ( deleteVoList2.size() > 0 ) {
						//1-1. Delete Cargo
						dbDao.removePartnerSCGCGO(deleteVoList2);
			        	if ( deleteVoList1.size() > 0 ) {
							dbDao.removePartnerSCG(deleteVoList1);
						}
					}
					
					
					//3. create process
					if ( insertVoList2.size() > 0) {
			        	//3-2. Create request numbers.
			        	for(int insCt1=insertVoList1.size()-1; insCt1>=0; insCt1--) {
			        		insertVoList1.get(insCt1).setSpclCgoRqstSeq("1"); //AK는 BKG당 한건
			        		String prnrCgoRqstSeq = insertVoList1.get(insCt1).getPrnrCgoRqstSeq();
			        		if(prnrCgoRqstSeq == null || "".equals(prnrCgoRqstSeq)) { // 신규Booking의 경우
			        			prnrCgoRqstSeq = String.valueOf(dbDao.searchMaxScgPrnrCgoRqstSeq());
			        		} 
			        		insertVoList1.get(insCt1).setPrnrCgoRqstSeq(prnrCgoRqstSeq);
//			        		int count = dbDao.searchPartnerSCGRequest(insertVoList1.get(insCt1));
//			        		if(count > 0) {
//			        			insertVoList1.remove(insCt1); //기존에 등록된 request가 있으면 등록하지 않음
//			        		} 
			        	}
			        	for(int insCt2=0; insCt2<insertVoList2.size(); insCt2++) {
			        		insertVoList2.get(insCt2).setSpclCgoRqstSeq("1"); //AK는 BKG당 한건
			        		String key2 =  insertVoList2.get(insCt2).getCgoOprCd() + insertVoList2.get(insCt2).getBkgRefNo() + insertVoList2.get(insCt2).getVslCd() + insertVoList2.get(insCt2).getSkdVoyNo() + insertVoList2.get(insCt2).getSkdDirCd() + insertVoList2.get(insCt2).getPolCd() + insertVoList2.get(insCt2).getPodCd();
			        		for(int i=0;i<insertVoList1.size();i++) {
			        			String key1 =  insertVoList1.get(i).getCgoOprCd() + insertVoList1.get(i).getBkgRefNo() + insertVoList1.get(i).getVslCd() + insertVoList1.get(i).getSkdVoyNo() + insertVoList1.get(i).getSkdDirCd() + insertVoList1.get(i).getPolCd() + insertVoList1.get(i).getPodCd();
			        			if(key1.equals(key2)) {
			        				insertVoList2.get(insCt2).setPrnrCgoRqstSeq(insertVoList1.get(i).getPrnrCgoRqstSeq());
			        				break;	
			        			}
			        		}
			        	}
			        }
				}
				
				//2016-01-11 START Awk Data Insert & Update
	        	//3-4. Create request.(Request)
	        	//3-5. Create Cargo.request(request>cargo순으로 등록(부모키))				
	        	if (insertVoList2.size() > 0) {
        			dbDao.addPartnerSCG(insertVoList1);
        			dbDao.addPartnerSCGCGO(insertVoList2);
	        	}
				if (updateVoList2.size() > 0) {
					//dbDao.modifyPartnerSCGApvl(updateVoList1, false);
					dbDao.modifyPartnerSCGCGO(updateVoList2);
				}
			}
			//2016-01-11 END 
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
		
		return 1;
	}
	
	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO APVL for Partner Lines modify <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs ScgPrnrAproRqstCgoVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void updatePartnerSCGCGOApproved(ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgPrnrAproRqstCgoVO> updateVoList = new ArrayList<ScgPrnrAproRqstCgoVO>();
			
			for ( int i=0; i<scgPrnrAproRqstCgoVOs.length; i++ ) {		
				if(!"".equals(scgPrnrAproRqstCgoVOs[i].getSpclCgoRqstSeq())) {
					scgPrnrAproRqstCgoVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgPrnrAproRqstCgoVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPartnerSCGCGOApproved(updateVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_1022 : Retrieve <br>
	 * Dangerous CGO Application Details for Partner Lines retrieve <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return PartnerApprovalRequestVO
	 * @exception EventException
	 */
	public PartnerApprovalRequestVO searchPartnerSCGDetailList(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException{
		PartnerApprovalRequestVO rsltVO = new PartnerApprovalRequestVO();
		try {
			ScgPrnrAproRqstVO          vo   	= dbDao.searchPatnerSCG		(scgPrnrAproRqstVO);
			List<ScgPrnrAproRqstCgoVO> list1 	= dbDao.searchPatnerSCGCGO	(scgPrnrAproRqstVO);
			scgPrnrAproRqstVO.setCrrCd			(vo.getCrrCd				());
			scgPrnrAproRqstVO.setBkgRefNo		(vo.getBkgRefNo				());
			scgPrnrAproRqstVO.setSpclCgoRqstSeq	(vo.getSpclCgoRqstSeq		());
			scgPrnrAproRqstVO.setPrnrCgoRqstSeq	(vo.getPrnrCgoRqstSeq		());
			
			List<ScgPrnrAproRqstFileVO> list2 = dbDao.searchPatnerSCGAttach	(scgPrnrAproRqstVO);
			
			rsltVO.setScgPrnrAproRqstVO			(vo);			
			rsltVO.setScgPrnrAproRqstCgoVOl		(list1);
			rsltVO.setScgPrnrAproRqstFileVOl	(list2);
			
			return rsltVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_1022 : Validation <br>
	 * Dangerous CGO Application Details for Partner Lines's MPA1 NET Weight sum retrieve <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerSCGMpa1NetSum(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException{
		try {			
			return dbDao.searchPatnerSCGMpa1NetSum(scgPrnrAproRqstVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"NET Weight"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"NET Weight"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_1022 : Save <br>
	 * DG Ref. No. Duplication Check <br>
	 * 
	 * @param ScgPrnrAproRqstVO   scgPrnrAproRqstVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerDcgoRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException {
		try {			
			return dbDao.searchPatnerDcgoRefNo(scgPrnrAproRqstVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_1022 : Save <br>
	 * BKG Ref. No. Duplication Check <br>
	 * 
	 * @param ScgPrnrAproRqstVO   scgPrnrAproRqstVO
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerBkgRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO, PartnerApprovalRequestVO partnerApprovalRequestVO) throws EventException {
		try {			
			return dbDao.searchPatnerBkgRefNo(scgPrnrAproRqstVO, partnerApprovalRequestVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * Application Request & Approval Status's List For Parnter Lines retrieve <br>
	 * 
	 * @param ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO
	 * @return SearchPrnrScgListVO
	 * @exception EventException
	 */
	public SearchPrnrScgListVO searchScgApprovalStatusListPartner(ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO) throws EventException {
		try {
			return dbDao.searchScgApprovalStatusList(scgPrnrRequestListOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status For Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Application Request & Approval Status For Partner Lines"}).getMessage(), ex);
		}
	}
	
	/**
	 * SPCL CGO APVL for Own BKG's mail send result retrieve. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPartnerSCGApprovalMail(ScgPrnrAproRqstVO scgPrnrAproRqstVO, SignOnUserAccount account) throws EventException{
		try {
			scgPrnrAproRqstVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyPartnerSCGApprovalMail(scgPrnrAproRqstVO);					
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Own BKG"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_SCG_1022 : Retrieve <br>
	 * Dangerous CGO Application Details for Partner Lines retrieve <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return PartnerApprovalRequestVO
	 * @exception EventException
	 */
	public PartnerApprovalRequestVO searchPartnerSCGDetailListBefore(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException{
		PartnerApprovalRequestVO rsltVO = new PartnerApprovalRequestVO();
		try {
			List<ScgPrnrAproRqstCgoVO> list1 = dbDao.searchPatnerSCGCGO(scgPrnrAproRqstVO, true);		
			rsltVO.setScgPrnrAproRqstCgoVOl(list1);
			
			return rsltVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	

	/**
	 * VOP_SCG_5001 : Save <br>
	 * SPCL CGO APVL for Partner Lines modify <br>
	 * 
	 * @param partnerApprovalRequestVO PartnerApprovalRequestVO[]
	 * @param keys List<String>
	 * @param account SignOnUserAccount
	 * @return List
	 * @exception EventException
	 */
	public List<Map> managePartnerSCGApvl(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException {
		
		List<Map> returnVal = new ArrayList<Map>();
		
		try {
			if(partnerApprovalRequestVO != null) {
				ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     = partnerApprovalRequestVO.getScgPrnrAproRqstVOs();	
				ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = partnerApprovalRequestVO.getScgPrnrAproRqstCgoVOs();
				// Request
				List<ScgPrnrAproRqstVO> updateVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				// SCG
				List<ScgPrnrAproRqstCgoVO> updateVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> rqstNoVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				//2016-03-21 Own, Partner Approval Reference Number 통합
				ScgCargoApprovalCommonVO comvo = new ScgCargoApprovalCommonVO();
				
				boolean isRequest = false;
				boolean isAuth = false;
				boolean isEDI = false;
				String mode = partnerApprovalRequestVO.getMode();
				if("R".equals(mode)) isRequest = true;
				if("A".equals(mode)) isAuth = true;
				
				if(scgPrnrAproRqstVOs != null) { 
					//Sort by booking number and Cargo number
					int bkgRqtCt = scgPrnrAproRqstVOs.length;
					int cagoRqtCt = scgPrnrAproRqstCgoVOs==null?0:scgPrnrAproRqstCgoVOs.length;
					
					// 1. Request Info Setting(SCG_PRNR_APRO_RQST)
					for ( int bkgIdx=0; bkgIdx<bkgRqtCt; bkgIdx++ ) {
						if("EDI".equals(scgPrnrAproRqstVOs[bkgIdx].getSrcTpCd())) isEDI = true;
						scgPrnrAproRqstVOs[bkgIdx].setRgnShpOprCd(partnerApprovalRequestVO.getRgnShpOprCd());
						scgPrnrAproRqstVOs[bkgIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
						scgPrnrAproRqstVOs[bkgIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
						if("Y".equals(scgPrnrAproRqstVOs[bkgIdx].getDgFlg())) {
							scgPrnrAproRqstVOs[bkgIdx].setSpclCgoCateCd("DG");
						} 
						if("Y".equals(scgPrnrAproRqstVOs[bkgIdx].getAwkFlg())) {
							scgPrnrAproRqstVOs[bkgIdx].setSpclCgoCateCd("AK");
						} 
//						scgPrnrAproRqstVOs[bkgIdx].setSrcTpCd("MNL");
						scgPrnrAproRqstVOs[bkgIdx].setCreUsrId(account.getUsr_id());
						scgPrnrAproRqstVOs[bkgIdx].setUpdUsrId(account.getUsr_id());
						scgPrnrAproRqstVOs[bkgIdx].setRqstOfcCd(account.getOfc_cd());
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by SLAN_CD.						
						if(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() != null && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo()) && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getSlanCd())) {
				
							 if ("U".equals(scgPrnrAproRqstVOs[bkgIdx].getIbflag())) {
								updateVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							 }
						}	
					}
					
					for ( int cgoIdx=0; cgoIdx<cagoRqtCt; cgoIdx++ ) {
						
						// compulsory items handling exception
						Method[] methods  = scgPrnrAproRqstCgoVOs[cgoIdx].getClass().getMethods();		
						String gMethodNm = "", sMethodNm = "";
						for(int mIdx1=0; mIdx1<methods.length; mIdx1++) {
							Method gMethod = methods[mIdx1];
							if (gMethod.getName().indexOf("get") != -1) {								
								if(gMethod.getReturnType().getName().equals("java.lang.String")) {
									String val = (String)gMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx]);									
						            if(val == null || "".equals(val)) {
						            	gMethodNm = gMethod.getName();
										gMethodNm = gMethodNm.substring(3,gMethodNm.length());										
							            for(int mIdx2=0; mIdx2<methods.length; mIdx2++) {
											Method sMethod = methods[mIdx2];
											sMethodNm = sMethod.getName();
											sMethodNm = sMethodNm.substring(3,sMethodNm.length());
											if(sMethod.getName().indexOf("set") != -1 && gMethodNm.equals(sMethodNm)) {
												if(gMethodNm.equals("AproRefNo")||gMethodNm.equals("PckQty")||
												   gMethodNm.equals("InN1stImdgPckQty")||gMethodNm.equals("InN2ndImdgPckQty")||
												   gMethodNm.equals("MaxInPckQty")||gMethodNm.equals("MeasQty")||
												   gMethodNm.equals("OutN1stImdgPckQty")||gMethodNm.equals("OutN2ndImdgPckQty")||
												   gMethodNm.equals("ImdgUnNo")||gMethodNm.equals("ImdgUnNoSeq")
											      ) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "0");
												} else if(gMethodNm.equals("ClodFlg")) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "N");
												}
											}
							            }
						            }
								}
					        }
						}
						
						// 2. SCG Info Setting
						//In case of DG Detail Pop-Up, sort BKG & CARGO's parameter by CNTR_SEQ.
						if(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq() != null && !"".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq())) {
							scgPrnrAproRqstCgoVOs[cgoIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
							scgPrnrAproRqstCgoVOs[cgoIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthOfcCd(account.getOfc_cd());
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthUsrId(account.getUsr_id());
							scgPrnrAproRqstCgoVOs[cgoIdx].setCreUsrId(account.getUsr_id());
							scgPrnrAproRqstCgoVOs[cgoIdx].setUpdUsrId(account.getUsr_id());
							if(isRequest) {
								scgPrnrAproRqstCgoVOs[cgoIdx].setAuthStsCd("R");
							}
							String spclCgoCateCd = "DG";
							if("N".equals(partnerApprovalRequestVO.getDgFlg()) &&
							   "Y".equals(partnerApprovalRequestVO.getAwkFlg())) {
								spclCgoCateCd = "AK";
							}
							scgPrnrAproRqstCgoVOs[cgoIdx].setSpclCgoCateCd(spclCgoCateCd);

						
							if ("U".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								//if(count > 0) {
									updateVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
								//}
							}
							
							//Sorting transactions to create verification numbers
							if ("Y".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getAuthStsCd()) || "D".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
								rqstNoVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
						}
					}

//					if (updateVoList2.size() > 0) {
//						//APVL ?붾㈃?먯꽌??BKG_REF_NO ?⑥쐞 Update 
//						dbDao.modifyPartnerSCGApvl(updateVoList1, false);  
//						//dbDao.modifyPartnerSCGCGO(updateVoList2);
//						Map<String, String> aproRefNoMap = new HashMap<String, String>();
//						
//						for(int i=0;i<updateVoList2.size();i++){
//							//2015-12-18 Approval Reference Number Start 
//							ScgPrnrAproRqstCgoVO vo = (ScgPrnrAproRqstCgoVO)updateVoList2.get(i);
//							if("Y".equals(vo.getAuthStsCd())) {
//								if(updateVoList1.size() > 0) {
//									String strSeq = vo.getPrnrCgoRqstSeq();
//									//String strSeq2 = vo.getBkgRefNo();
//									String tmpkey = vo.getBkgRefNo() + vo.getPrnrCgoRqstSeq();
//									for(int ii=0;ii<updateVoList1.size();ii++) {
//										if(strSeq.equals(updateVoList1.get(ii).getPrnrCgoRqstSeq())) {
//											// key瑜?留뚮벉 (bkg_ref_no + prnr_cgo_rqst_seq 媛 ?由?寃쎌슦 梨꾨쾲 ???
//											if(aproRefNoMap.containsKey(tmpkey)){
//												String tmpValue = aproRefNoMap.get(tmpkey); 
//										        vo.setAproRefNo(tmpValue);
//											}else{ 
//												//String strAproRefNo = dbDao.makeSpclAproRefNo(updateVoList1.get(ii));
//												//String strAproRefNo = dbDao2.searchSpclAproRefNo(updateVoList1.get(ii), null, "","");
//												comvo.setPolCd(vo.getPolCd());
//												String strAproRefNo = dbDao2.searchSpclAproRefNo(comvo);
//												vo.setAproRefNo(strAproRefNo);
//												aproRefNoMap.put(tmpkey, strAproRefNo);
//											}
//											//log.debug("\n************************************************["+vo+"]["+i+"]["+strSeq+"]["+updateVoList1.get(i).getPrnrCgoRqstSeq()+"]["+vo.getAproRefNo()+"]" );
//											dbDao.modifyPartnerSCGCGOInfo(vo);
//											break;
//										}
//									}
//								}
//							}else{
//								dbDao.modifyPartnerSCGCGO(updateVoList2);
//							}
//						}
//					}
					
				
					//2016-04-16 START CNTR, Cargo 가 모두 승인 됬을 때만, 해당 BKG Ref No 단위로 Approval Ref No 부여
					if (updateVoList2.size() > 0) {
						dbDao.modifyPartnerSCGApvl(updateVoList1, false); 
						for(int i=0;i<updateVoList2.size();i++){
							ScgPrnrAproRqstCgoVO vo = (ScgPrnrAproRqstCgoVO)updateVoList2.get(i);
							if("Y".equals(vo.getAuthStsCd())) {
								if(updateVoList1.size() > 0) {
									dbDao.modifyPartnerSCGCGO(vo);
									comvo.setPolCd(vo.getPolCd());
									String allAproStsCd = dbDao.searchAllApprovedCgo(vo);
									if("O".equals(allAproStsCd)){
										String strAproRefNo = dbDao2.searchSpclAproRefNo(comvo);
										vo.setAproRefNo(strAproRefNo);
										dbDao.modifyPartnerScgPrnrAproRefNo(vo);
									}    
								}
							}
							else{
								dbDao.modifyPartnerSCGCGO(vo);
							}
						}
					}
				}
				//2016-04-16 END

				// Save 
				Map<String, String> result = new HashMap<String, String>();
				result.put("result", "1");
        		returnVal.add(result);
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
		
		return returnVal;
	}

	/**
	 * VOP_SCG_5001 : Update <br>
	 * SPCL CGO APVL for Partner Lines modify <br>
	 * 
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartnerCntrNm(PartnerApprovalRequestVO partnerApprovalRequestVO, SignOnUserAccount account) throws EventException{
		try {
			if(partnerApprovalRequestVO != null) {
				
				ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = partnerApprovalRequestVO.getScgPrnrAproRqstCgoVOs();
				List<ScgPrnrAproRqstCgoVO> updateVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				int cagoRqtCt = scgPrnrAproRqstCgoVOs==null?0:scgPrnrAproRqstCgoVOs.length;
				for ( int cgoIdx=0; cgoIdx<cagoRqtCt; cgoIdx++ ) {
							
					if ("U".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag())) {
						scgPrnrAproRqstCgoVOs[cgoIdx].setUpdUsrId(account.getUpd_usr_id());
						updateVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
					}
				}
				
				if (updateVoList2.size() > 0) {
					dbDao.modifyPartnerCntrNm(updateVoList2);
				}
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }

	}
}
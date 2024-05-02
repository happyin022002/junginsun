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
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic;

import java.util.List;
import java.util.ListIterator;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration.InterfaceScheduleToExternalScnDBDAO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration.InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.vo.TxScnInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * VesselScheduleExtraChangeHistCreationBackEndJob Business Logic Back End Job Basic Command implementation<br>
 * - Handling business logic of Vessel Schedule Change History<br>
 * 
 * @author
 * @see DAO
 * @since J2EE 1.4
 */ 
public class InterfaceScheduleToExternalScnBackEndJob extends BackEndCommandSupport {

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
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 */
	public void setScnVskVslSkdVOs(List<VskVslSkdVO> vskVslSkdVOs) {
		this.vskVslSkdVOs = vskVslSkdVOs;
	}
	
	/**
	 * Change Notification 실행반영한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		this.createVskScnIfBackEndJob(this.vskVslSkdVOs); 
		return null;
	}	

	/**
	 * Vessel Schedule 변경사항에 대한 이력발송<br>
	 * 
	 * @param @param List<VskVslSkdVO> vskVslSkdVOs
	 * @exception EventException
	 */
	private void createVskScnIfBackEndJob(List<VskVslSkdVO> vskVslSkdVOs) throws EventException {
		
		try {
			
			log.info("\n*********************************************************************************");
			log.info("\n\n =================== SCN INTERFACE STARTING ===================================");
			log.info("\n   =================== BACK END JOB > createVskScnIfBackEndJob ==================");
			log.info("\n*********************************************************************************");
			
			String sTxTypeCd	= "";
			
			if(vskVslSkdVOs == null || vskVslSkdVOs.size() == 0)	return;
			
			InterfaceScheduleToExternalScnDBDAO	dbDao 	= new InterfaceScheduleToExternalScnDBDAO();
			
			/**
			 * Regeneration for SCN I/F
			 * STEP 1. Checking and Deciding TX Type ("U" or "D")
			 * STEP 2. 
			 * STEP 3. 
			 * STEP 4. 
			 */
			
			log.info("\n\n   =================== vskVslSkdVOs's VVD Count is ["+vskVslSkdVOs.size()+"]\n\n");
			
			ListIterator<VskVslSkdVO>	scnVskVslSkdVOItr	= vskVslSkdVOs.listIterator();
			
			while(scnVskVslSkdVOItr.hasNext()){
				
				VskVslSkdVO	tmpVO	= scnVskVslSkdVOItr.next();
				
				log.info("\n\n ::::::::::  VVD is ["+tmpVO.getVslCd()+tmpVO.getSkdVoyNo()+tmpVO.getSkdDirCd()+"]	::::::::::\n\n");
				
				/** STEP 1. **/
				if(dbDao.checkExistForSpecificVVD(tmpVO)){
					sTxTypeCd	= "U";
				}else{
					sTxTypeCd	= "D";
				}
				
				
				/** STEP 2. **/
				if("D".equals(sTxTypeCd)){
					
					/** VVD Deletion ******************/
					List<TxScnInterfaceVO> 			txScnInterfaceVOs	= dbDao.checkTxTypeforDeleteScnInterfaceList(tmpVO);


					/******************************************** 
					 * 'D'	: Update INSF
					 * 'ROW_DELETE' : Delete Row Physically
					 * 'X'	: Keep current Row 
					 ********************************************/
					for(TxScnInterfaceVO tmpDelVO : txScnInterfaceVOs){
						
						String sNewInsfDvCd		= tmpDelVO == null || tmpDelVO.getNewInsfDvCd() == null ? "" : tmpDelVO.getNewInsfDvCd	();
						String sNewTxTpCd		= tmpDelVO == null || tmpDelVO.getNewTxTpCd	 () == null ? "" : tmpDelVO.getNewTxTpCd	();
						
						/** INSERT **/
						if("I".equals(sNewTxTpCd)){
							
							//:InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL://
							tmpDelVO.setInsfDvCd		(sNewInsfDvCd);
							dbDao.insertPortScnInterface(tmpDelVO);
						
						/** UPDATE **/
						}else if("U".equals(sNewTxTpCd)){
							
							//:InterfaceScheduleToExternalScnDBDAOUpdatePortScnInterfaceUSQL://
							tmpDelVO.setInsfDvCd		(sNewInsfDvCd);
							dbDao.updatePortScnInterface(tmpDelVO);
							
						/** DELETE **/
						}else if("ROW_DELETE".equals(sNewTxTpCd)){
							
							//:InterfaceScheduleToExternalScnDBDAODeletePortScnInterfaceDSQL://
							dbDao.deletePortScnInterface(tmpDelVO);
							
						}
					}
					
					
				}else if("U".equals(sTxTypeCd)){
					
					/** VVD Creation or Update ********/
					List<TxScnInterfaceVO> 			txScnInterfaceVOs	= dbDao.checkTxTypeforUpdateScnInterfaceList(tmpVO);	
					
					
					/** INSERT ALL PORTS **/
					if(txScnInterfaceVOs == null || txScnInterfaceVOs.size() == 0){
						
						dbDao.createAllPortScnInterface(tmpVO);
						
						
					/** INSERT or UPDATE CASE BY CASE **/
					}else{
						
						/** from VSK_VSL_PORT_SKD **/
						List<VskVslPortSkdVO>	allPortList	= dbDao.searchAllPortListforVVD(tmpVO);
						
						for(VskVslPortSkdVO tmpPortVO : allPortList){
							
							List<TxScnInterfaceVO>	txScnInterfacePortVOs	= dbDao.checkTxPortTypeforUpdateScnInterfaceList(tmpPortVO);
							
							/** INSERT ONLY ONE PORT **/
							if(txScnInterfacePortVOs == null || txScnInterfacePortVOs.size() == 0){
								
								dbDao.createSpecificPortScnInterface(tmpPortVO);
								
							}else{
								
								for(TxScnInterfaceVO txPortVO : txScnInterfacePortVOs){

									String sNewInsfDvCd		= txPortVO == null || txPortVO.getNewInsfDvCd() == null ? "" : txPortVO.getNewInsfDvCd	();
									String sNewTxTpCd		= txPortVO == null || txPortVO.getNewTxTpCd	 () == null ? "" : txPortVO.getNewTxTpCd	();
									
									/** INSERT PORT **/
									if("I".equals(sNewTxTpCd)){
										
										//:InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL://
										txPortVO.setInsfDvCd		(sNewInsfDvCd);
										dbDao.insertPortScnInterface(txPortVO);

									/** UPDATE PORT **/
									}else if("U".equals(sNewTxTpCd)){
										
										//:InterfaceScheduleToExternalScnDBDAOUpdatePortScnInterfaceUSQL://
										txPortVO.setInsfDvCd		(sNewInsfDvCd);
										dbDao.updatePortScnInterface(txPortVO);
									}
									
								}

							}
							
						}
						
					}
					
				}
				
			}
			
										
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
}

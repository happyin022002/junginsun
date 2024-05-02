/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISBackEndJob.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic;

import java.util.List;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration.InterfaceScheduleToIBISDBDAO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPortNworkIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdDtlIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslPortSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslSkdIbisIfVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see InterfaceScheduleToIBISBCImpl
 * @since J2EE 1.4
 */
public class InterfaceScheduleToIBISBackEndJob extends BackEndCommandSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1257124099247549774L;

	
	/**
	 * Change Notification
	 */
	private List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs;
	
	/**
	 * Change Notification
	 */
	private List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs;
	
	/**
	 * Change Notification
	 */
	private List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs;
	/**
	 * Change Notification
	 */
	private List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs;
	/**
	 * Change Notification
	 */
	private List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs;

	/**
	 * Change Notification
	 */
	private String jobType;;
	
	/**
	 * Change Notification
	 * @param List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs
	 */
	public void setVskPortNworkIbisIfVOs(List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs) {
		this.vskPortNworkIbisIfVOs = vskPortNworkIbisIfVOs;
	}
	
	/**
	 * Change Notification
	 * @param List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs
	 */
	public void setVskPfSkdIbisIfVOs(List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs) {
		this.vskPfSkdIbisIfVOs = vskPfSkdIbisIfVOs;
	}
	
	/**
	 * Change Notification
	 * @param List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs
	 */
	public void setVskPfSkdDtlIbisIfVOs(List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs) {
		this.vskPfSkdDtlIbisIfVOs = vskPfSkdDtlIbisIfVOs;
	}
	
	/**
	 * Change Notification
	 * @param List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs
	 */
	public void setVskVslPortSkdIbisIfVOs(List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs) {
		this.vskVslPortSkdIbisIfVOs = vskVslPortSkdIbisIfVOs;
	}
	
	/**
	 * Change Notification
	 * @param List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs
	 */
	public void setVskVslSkdIbisIfVOs(List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs) {
		this.vskVslSkdIbisIfVOs = vskVslSkdIbisIfVOs;
	}
	
	/**
	 * Change Notification
	 * @param String jobType
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	/**
	 * Change Notification 실행반영한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		
		if("VskPortNwork".equals(jobType)){
			this.insertVskPortNwork(vskPortNworkIbisIfVOs); 	
		}else if("VskPfSkd".equals(jobType)){
			this.insertVskPfSkd(vskPfSkdIbisIfVOs, vskPfSkdDtlIbisIfVOs);
		}else if("VskVslSkd".equals(jobType)){
			this.insertVskVslSkd(vskVslSkdIbisIfVOs, vskVslPortSkdIbisIfVOs); 
		}
		
		return null;
	}
	
	/**
	 * VSK_PORT_NWORK interface insert
	 * 
	 * @param List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs
	 * @exception EventException
	 */
	private void insertVskPortNwork(List<VskPortNworkIbisIfVO> vskPortNworkIbisIfVOs) throws EventException {
		
		try {
			
			log.info("\n*********************************************************************************");
			log.info("\n\n =================== IBIS INTERFACE STARTING ==================================");
			log.info("\n   =================== BACK END JOB > insertVskPortNwork");
			log.info("\n   =================== original vskPortNworkIbisIfVOs ["+vskPortNworkIbisIfVOs+"]");
			log.info("\n*********************************************************************************");
						
			InterfaceScheduleToIBISDBDAO	dbDao = new InterfaceScheduleToIBISDBDAO();
			String  ifMnplCd = "";
			
			if(vskPortNworkIbisIfVOs == null || vskPortNworkIbisIfVOs.size() == 0)	return;
			
			for(int i=0; i<vskPortNworkIbisIfVOs.size(); i++){
				
				VskPortNworkIbisIfVO vskPortNworkIbisIfVO = vskPortNworkIbisIfVOs.get(i);

				ifMnplCd = dbDao.searchVskPortNworkIfMnplCd(vskPortNworkIbisIfVO);
				vskPortNworkIbisIfVO.setIfMnplCd(ifMnplCd);
				
				dbDao.updateVskPortNwork(vskPortNworkIbisIfVO);
				dbDao.insertVskPortNwork(vskPortNworkIbisIfVO);	
				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

	}
	
	/**
	 * VSK_PF_SKD, VSK_PF_SKD_DTL interface insert
	 * 
	 * @param List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVO
	 * @param List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs
	 * @exception EventException
	 */
	private void insertVskPfSkd(List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs, List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs) throws EventException {
		
		try {
			
			log.info("\n*********************************************************************************");
			log.info("\n\n =================== IBIS INTERFACE STARTING ==================================");
			log.info("\n   =================== BACK END JOB > insertVskPfSkd");
			log.info("\n   =================== original vskPfSkdIbisIfVOs ["+vskPfSkdIbisIfVOs+"]");
			log.info("\n   =================== original vskPfSkdDtlIbisIfVOs ["+vskPfSkdDtlIbisIfVOs+"]");
			log.info("\n*********************************************************************************");
			
			InterfaceScheduleToIBISDBDAO	dbDao = new InterfaceScheduleToIBISDBDAO();
			String  ibisIfSeq = "";
			String  ifMnplCd = "";

			if(vskPfSkdIbisIfVOs != null  && vskPfSkdIbisIfVOs.size() != 0) {
				for(int i=0; i<vskPfSkdIbisIfVOs.size(); i++){
					VskPfSkdIbisIfVO vskPfSkdIbisIfVO = vskPfSkdIbisIfVOs.get(i);

					ifMnplCd  = dbDao.searchVskPfSkdIfMnplCd(vskPfSkdIbisIfVO);
					ibisIfSeq = dbDao.searchVskPfSkdSeq();
					
					vskPfSkdIbisIfVO.setIfMnplCd(ifMnplCd);
					vskPfSkdIbisIfVO.setIbisIfSeq(ibisIfSeq);
					
					dbDao.updateVskPfSkd(vskPfSkdIbisIfVO);
					
					if(!"".equals(ifMnplCd)){

						vskPfSkdIbisIfVO.setIfMnplCd("");

						dbDao.insertVskPfSkd(vskPfSkdIbisIfVO); 
						
						vskPfSkdIbisIfVO.setIfMnplCd(ifMnplCd);
						ibisIfSeq = dbDao.searchVskPfSkdSeq();
						vskPfSkdIbisIfVO.setIbisIfSeq(ibisIfSeq);

					}
					dbDao.insertVskPfSkd(vskPfSkdIbisIfVO);	
					
					VskPfSkdDtlIbisIfVO vskPfSkdDtlIbisIfVO = new VskPfSkdDtlIbisIfVO();
					
					vskPfSkdDtlIbisIfVO.setVslSlanCd(vskPfSkdIbisIfVO.getVslSlanCd());
					vskPfSkdDtlIbisIfVO.setPfSvcTpCd(vskPfSkdIbisIfVO.getPfSvcTpCd());
					vskPfSkdDtlIbisIfVO.setIbisIfSeq(ibisIfSeq);
					vskPfSkdDtlIbisIfVO.setCreUsrId(vskPfSkdIbisIfVO.getCreUsrId());
					vskPfSkdDtlIbisIfVO.setUpdUsrId(vskPfSkdIbisIfVO.getUpdUsrId());
					
					dbDao.insertVskPfSkdDtl(vskPfSkdDtlIbisIfVO);
					
				}
			}
			
										
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

	}
	
	/**
	 * VSK_VSL_SKD, VSK_VSL_PORT_SKD interface insert
	 * 
	 * @param List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs
	 * @param List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs
	 * @exception EventException
	 */
	private void insertVskVslSkd(List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs, List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs) throws EventException {
		
		try {
			
			log.info("\n*********************************************************************************");
			log.info("\n\n =================== IBIS INTERFACE STARTING ==================================");
			log.info("\n   =================== BACK END JOB > insertVskVslSkd");
			log.info("\n   =================== original vskVslSkdIbisIfVO ["+vskVslSkdIbisIfVOs+"]");
			log.info("\n   =================== original vskVslPortSkdIbisIfVOs ["+vskVslPortSkdIbisIfVOs+"]");
			log.info("\n*********************************************************************************");
			
			InterfaceScheduleToIBISDBDAO	dbDao = new InterfaceScheduleToIBISDBDAO();
			String  ibisIfSeq = "";
			String ifMnplCd = "";
			
			StringBuffer strBuff = null;
			StringBuffer strBuff2 = null;
			
			if(vskVslSkdIbisIfVOs != null){
				for(int inx = 0; inx<vskVslSkdIbisIfVOs.size(); inx++){
					VskVslSkdIbisIfVO	vskVslSkdIbisIfVO	= vskVslSkdIbisIfVOs.get(inx);
					strBuff = new StringBuffer("");
					strBuff.append(vskVslSkdIbisIfVO.getVslCd());
					strBuff.append(vskVslSkdIbisIfVO.getSkdVoyNo());
					strBuff.append(vskVslSkdIbisIfVO.getSkdDirCd());
		
					
					for(int inx2 = 0; inx2<vskVslSkdIbisIfVOs.size(); inx2++){
						
						VskVslSkdIbisIfVO	vskVslSkdIbisIfVO2	= vskVslSkdIbisIfVOs.get(inx2);
						
						strBuff2 = new StringBuffer("");
						strBuff2.append(vskVslSkdIbisIfVO2.getVslCd());
						strBuff2.append(vskVslSkdIbisIfVO2.getSkdVoyNo());
						strBuff2.append(vskVslSkdIbisIfVO2.getSkdDirCd());
						
						if(strBuff.toString().equals(strBuff2.toString())){
							if(inx != inx2){
								vskVslSkdIbisIfVOs.remove(inx2);
							}
						}
					}
				}	
			}
			
			if(vskVslSkdIbisIfVOs != null && vskVslSkdIbisIfVOs.size() != 0) {
				for(int i=0; i<vskVslSkdIbisIfVOs.size(); i++){
					VskVslSkdIbisIfVO vskVslSkdIbisIfVO = vskVslSkdIbisIfVOs.get(i);

					ifMnplCd  = dbDao.searchVskVslSkdIfMnplCd(vskVslSkdIbisIfVO);
					ibisIfSeq = dbDao.searchVskVslSkdSeq();
					
					vskVslSkdIbisIfVO.setIfMnplCd(ifMnplCd);
					vskVslSkdIbisIfVO.setIbisIfSeq(ibisIfSeq);
					
					dbDao.updateVskVslSkd(vskVslSkdIbisIfVO);
					if(!"".equals(ifMnplCd)){

						vskVslSkdIbisIfVO.setIfMnplCd("");

						dbDao.insertVskVslSkd(vskVslSkdIbisIfVO); 
						
						vskVslSkdIbisIfVO.setIfMnplCd(ifMnplCd);
						
						ibisIfSeq = dbDao.searchVskVslSkdSeq();
						vskVslSkdIbisIfVO.setIbisIfSeq(ibisIfSeq);

					}
					dbDao.insertVskVslSkd(vskVslSkdIbisIfVO);	
					
					VskVslPortSkdIbisIfVO vskVslPortSkdIbisIfVO = new VskVslPortSkdIbisIfVO();
					
					vskVslPortSkdIbisIfVO.setVslCd(vskVslSkdIbisIfVO.getVslCd());
					vskVslPortSkdIbisIfVO.setSkdVoyNo(vskVslSkdIbisIfVO.getSkdVoyNo());
					vskVslPortSkdIbisIfVO.setSkdDirCd(vskVslSkdIbisIfVO.getSkdDirCd());
					vskVslPortSkdIbisIfVO.setIbisIfSeq(ibisIfSeq);
					vskVslPortSkdIbisIfVO.setCreUsrId(vskVslSkdIbisIfVO.getCreUsrId());
					vskVslPortSkdIbisIfVO.setUpdUsrId(vskVslSkdIbisIfVO.getUpdUsrId());
					
					dbDao.insertVskVslPortSkd(vskVslPortSkdIbisIfVO);
					
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

	}
}

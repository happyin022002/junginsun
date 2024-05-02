/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFileUploadBCImpl.java
*@FileTitle : JO Member Information 파일 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.08 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.basic;

import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.integration.FmsFileUploadDBDAO;
import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;


/**
 *  JOO 파일 첨부 관련 Business Logic Basic Command implementation<br>
 *  JOO 파일 첨부 관련 비지니스 로직을 처리한다.<br> 
 *
 * @author 이준범
 * @see JOOFileUploadBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FMSFileUploadBCImpl extends BasicCommandSupport implements FMSFileUploadBC {

	// Database Access Object
	private transient FmsFileUploadDBDAO dbDao = null;

	/**
	 * FMSFileUploadBCImpl 객체 생성<br>
	 * FmsFileUploadDBDAO를 생성한다.<br>
	 */
	public FMSFileUploadBCImpl() {
		dbDao = new FmsFileUploadDBDAO();
	}
	
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param String vslCd
	 * @param String vnorSeq
	 * @param String vnorItmSeq
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchCsrFileUploadList(String vslCd, String vnorSeq, String vnorItmSeq) throws EventException {
	
		try {			
			return dbDao.searchCsrFileUploadList(vslCd, vnorSeq, vnorItmSeq);			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Retrieve"}).getMessage(), ex);
		}
		
	}
	
	/**
	 * File Upload 삭제 ,입력<br>
	 * 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @param String vslCd
	 * @param String vnorSeq
	 * @param String vnorItmSeq 
	 * @exception EventException
	 */
	public void manageCsrFileUpload(FileUploadListVO[] fileUploadListVOs, String vslCd, String vnorSeq, String vnorItmSeq) throws EventException {
		try {					
			String atchFileLnkId = dbDao.searchAtchFileLnkId(vslCd, vnorSeq, vnorItmSeq);
			
			if (fileUploadListVOs != null && fileUploadListVOs.length > 0) {
				String usrId = fileUploadListVOs[0].getUpdUsrId();
				
				for (int i = 0; i < fileUploadListVOs.length; i++) {
					FileUploadListVO fileUploadListVO = fileUploadListVOs[i];
					fileUploadListVO.setUpdUsrId(usrId);
					fileUploadListVO.setVslCd(vslCd);
					fileUploadListVO.setVnorSeq(vnorSeq);
					fileUploadListVO.setVnorItmSeq(vnorItmSeq);
					fileUploadListVO.setAtchFileLnkId(atchFileLnkId);
					
					String ibflag = fileUploadListVO.getIbflag();					
					if ("I".equals(ibflag)) {							
						dbDao.addFileUpload(fileUploadListVO);
						dbDao.updateFmsVndoItm(fileUploadListVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeFileUpload(fileUploadListVO);
					}  else if ("U".equals(ibflag)) {
						dbDao.modifyFileUpload(fileUploadListVO);
					}
				}				
			} 			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Save"}).getMessage(), ex);
		}
	}
	
	/********************************************************************************************************************
	 * Owner's Account
	 */
	
	/**
	 * Owner's Account File Upload 리스트 조회<br>
	 * 
	 * @param String csrNo
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchCsrFileUploadListOA(String csrNo) throws EventException {
	
		try {			
			return dbDao.searchCsrFileUploadListOA(csrNo);			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Retrieve"}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Owner's Account File Upload 삭제 ,입력<br>
	 * 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @param String csrNo 
	 * @exception EventException
	 */
	public void manageCsrFileUploadOA(FileUploadListVO[] fileUploadListVOs, String csrNo) throws EventException {
		try {					
			String atchFileLnkId = csrNo;
			
			if (fileUploadListVOs != null && fileUploadListVOs.length > 0) {
				String usrId = fileUploadListVOs[0].getUpdUsrId();
				
				for (int i = 0; i < fileUploadListVOs.length; i++) {
					FileUploadListVO fileUploadListVO = fileUploadListVOs[i];
					fileUploadListVO.setUpdUsrId(usrId);
					fileUploadListVO.setCsrNo(csrNo);
					fileUploadListVO.setAtchFileLnkId(atchFileLnkId);
					
					String ibflag = fileUploadListVO.getIbflag();					
					if ("I".equals(ibflag)) {							
						dbDao.addFileUploadOA(fileUploadListVO);
						dbDao.updateFmsCsulSlp(fileUploadListVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeFileUploadOA(fileUploadListVO);
					}  else if ("U".equals(ibflag)) {
						dbDao.modifyFileUploadOA(fileUploadListVO);
					}
				}				
			} 			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Save"}).getMessage(), ex);
		}
	}
	
}
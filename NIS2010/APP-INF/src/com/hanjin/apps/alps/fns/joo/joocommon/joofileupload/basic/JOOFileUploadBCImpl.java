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
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration.JooFileUploadDBDAO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 *  JOO 파일 첨부 관련 Business Logic Basic Command implementation<br>
 *  JOO 파일 첨부 관련 비지니스 로직을 처리한다.<br>
 *
 * @author 이준범
 * @see JOOFileUploadBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JOOFileUploadBCImpl extends BasicCommandSupport implements JOOFileUploadBC {

	// Database Access Object
	private transient JooFileUploadDBDAO dbDao = null;

	/**
	 * JOOFileUploadBCImpl 객체 생성<br>
	 * JooFileUploadDBDAO를 생성한다.<br>
	 */
	public JOOFileUploadBCImpl() {
		dbDao = new JooFileUploadDBDAO();
	}
	
	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param String joCrrCd
	 * @param String crrCntcSeq
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchFileUploadList(String joCrrCd, String crrCntcSeq) throws EventException {
	
		try {			
			return dbDao.searchFileUploadList(joCrrCd, crrCntcSeq);			
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
	 * @author 이준범
	 * @category FNS_JOO_0082
	 * @category manageFileUpload 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @exception EventException
	 */
	public void manageFileUpload(FileUploadListVO[] fileUploadListVOs) throws EventException {

		try {		
			if (fileUploadListVOs != null && fileUploadListVOs.length > 0) {
				String usrId = fileUploadListVOs[0].getUpdUsrId();
				String joCrrCd = fileUploadListVOs[0].getJoCrrCd();
				String crrCntcSeq = fileUploadListVOs[0].getCrrCntcSeq();
				for (int i = 0; i < fileUploadListVOs.length; i++) {
					FileUploadListVO fileUploadListVO = fileUploadListVOs[i];
					fileUploadListVO.setUpdUsrId(usrId);
					fileUploadListVO.setJoCrrCd(joCrrCd);
					fileUploadListVO.setCrrCntcSeq(crrCntcSeq);
					
					String ibflag = fileUploadListVO.getIbflag();					
					if ("I".equals(ibflag)) {	
						dbDao.addFileUpload(fileUploadListVO);
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

	/**
	 * File Upload 리스트 조회<br>
	 * 
	 * @param String csrNo
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchCsrFileUploadList(String csrNo) throws EventException {
	
		try {			
			return dbDao.searchCsrFileUploadList(csrNo);			
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
	 * @author 민정호
	 * @category FNS_JOO_0098
	 * @category manageCsrFileUpload 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @exception EventException
	 */
	public void manageCsrFileUpload(FileUploadListVO[] fileUploadListVOs) throws EventException {

		try {		
			if (fileUploadListVOs != null && fileUploadListVOs.length > 0) {
				String usrId = fileUploadListVOs[0].getUpdUsrId();
				String csrNo = fileUploadListVOs[0].getCsrNo();
				String fileSeq = fileUploadListVOs[0].getFileSeq();
				for (int i = 0; i < fileUploadListVOs.length; i++) {
					FileUploadListVO fileUploadListVO = fileUploadListVOs[i];
					fileUploadListVO.setUpdUsrId(usrId);
					fileUploadListVO.setCsrNo(csrNo);
					fileUploadListVO.setFileSeq(fileSeq);
					
					String ibflag = fileUploadListVO.getIbflag();					
					if ("I".equals(ibflag)) {	
						dbDao.addCsrFileUpload(fileUploadListVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeCsrFileUpload(fileUploadListVO);
					}  else if ("U".equals(ibflag)) {
						dbDao.modifyCsrFileUpload(fileUploadListVO);
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
	
	
	/**
	 *  File Upload Info 조회<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @category searchFileUploadInfo 
	 * @param FileUploadInfoVO fileUploadInfoVO
	 * @return List<FileUploadInfoVO>
	 * @exception EventException
	 */
	public List<FileUploadInfoVO> searchFileUploadInfo(FileUploadInfoVO fileUploadInfoVO) throws EventException {
		try {			
			return dbDao.searchFileUploadInfo(fileUploadInfoVO);			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Retrieve"}).getMessage(), ex);
		}
	}		

	/**
	 *  File Upload Info 삭제, 입력<br>
	 * @author 김현주
	 * @category FNS_JOO_0097
	 * @category manageFileUpload 
	 * @param FileUploadInfoVO[] fileUploadInfoVOs
	 * @return String
	 * @exception EventException
	 */	
	public String manageFileUploadInfo(FileUploadInfoVO[] fileUploadInfoVOs) throws EventException {

		try {
			
			String saveId=null;
			
			if (fileUploadInfoVOs != null && fileUploadInfoVOs.length > 0) {
				//String usrId = fileUploadInfoVOs[0].getUpdUsrId();
				//String joCrrCd = fileUploadInfoVOs[0].getJoCrrCd();
				//String crrCntcSeq = fileUploadInfoVOs[0].getCrrCntcSeq();
				for (int i = 0; i < fileUploadInfoVOs.length; i++) {
					FileUploadInfoVO fileUploadInfoVO = fileUploadInfoVOs[i];
//					fileUploadListVO.setUpdUsrId(usrId);
//					fileUploadListVO.setJoCrrCd(joCrrCd);
//					fileUploadListVO.setCrrCntcSeq(crrCntcSeq);
					
					String ibflag = fileUploadInfoVO.getIbflag();
					if ("I".equals(ibflag)) {	
						dbDao.modifyFileUploadInfo(fileUploadInfoVO);		// Svae ID 입력시 첨부파일 있는 경우
					} else if ("D".equals(ibflag)) {
						fileUploadInfoVO.setFileSaveId(null);				// SaveID를 Null 로 하면 첨부파일 없는 경우
						dbDao.modifyFileUploadInfo(fileUploadInfoVO);
					}  else if ("U".equals(ibflag)) {
						dbDao.modifyFileUploadInfo(fileUploadInfoVO);		//?
					}
					saveId = fileUploadInfoVO.getFileSaveId();
				}				
			}
			
			return saveId;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"FileUpload", "Save"}).getMessage(), ex);
		}
		
	}	
	
}
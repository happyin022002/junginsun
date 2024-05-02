/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFileUploadBCImpl.java
*@FileTitle : creating JO Member Information file
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofileupload.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.joocommon.joofileupload.integration.JooFileUploadDBDAO;
import com.clt.apps.opus.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 *  JOO file attachement Business Logic Basic Command implementation<br>
 *
 * @author
 * @see JOOFileUploadBCImpl DAO class
 * @since J2EE 1.6
 */
public class JOOFileUploadBCImpl extends BasicCommandSupport implements JOOFileUploadBC {

	// Database Access Object
	private transient JooFileUploadDBDAO dbDao = null;

	/**
	 * JOOFileUploadBCImpl object creation<br>
	 * JooFileUploadDBDAO creation<br>
	 */
	public JOOFileUploadBCImpl() {
		dbDao = new JooFileUploadDBDAO();
	}
	
	/**
	 * File Upload list<br>
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
	 * File Upload delete, input<br>
	 * @author
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

}
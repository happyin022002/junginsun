/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFileUploadBC.java
*@FileTitle : creating JO Member Information file
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofileupload.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.joocommon.joofileupload.vo.FileUploadListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 *  JOO file attachement Business Logic Basic Command implementation<br>
 *
 * @author
 * @see JooFileUploadBC DAO class
 * @since J2EE 1.6
 */

public interface JOOFileUploadBC {
	
	/**
	 * File Upload list<br>
	 * @author
	 * @category FNS_JOO_0082
	 * @category searchFileUploadList 
	 * @param String joCrrCd
	 * @param String crrCntcSeq
	 * @return List<FileUploadListVO>
	 * @exception EventException
	 */
	public List<FileUploadListVO> searchFileUploadList(String joCrrCd, String crrCntcSeq) throws EventException;	
	
	/**
	 * File Upload delete, input<br>
	 * @author
	 * @category FNS_JOO_0082
	 * @category manageFileUpload 
	 * @param FileUploadListVO[] fileUploadListVOs
	 * @exception EventException
	 */
	public void manageFileUpload(FileUploadListVO[] fileUploadListVOs) throws EventException;	


}
/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FileUploadPopupHTMLAction.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Apr 20, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.syscommon.common.fileupload.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * FileUpload Popup 화면
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Apr 20, 2009
 */
public class FileUploadPopupHTMLAction extends HTMLActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6128593351758517128L;

	/**
	 * This method sets a method.
	 * @author Jeong-Hoon, KIM
	 * @param request
	 * @return Event
	 * @throws HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FileUploadPopupEvent event = new FileUploadPopupEvent();
		event.setModueMetaData(FileMetaDataManager.getInstance().getFileMetaData(request.getSession().getServletContext(), request.getParameter("subSysCd")));
		return event;
	}
}

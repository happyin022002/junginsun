/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OpusbkgPanamaReceiveEvent
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event;

import com.clt.apps.opus.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * @author 김민정
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class OpusbkgPanamaReceiveEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public String flatFile = null;

	/**
	 * @return the flatFile
	 */
	public String getFlatFile() {
		return flatFile;
	}

	/**
	 * @param flatFile the flatFile to set
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
		
}

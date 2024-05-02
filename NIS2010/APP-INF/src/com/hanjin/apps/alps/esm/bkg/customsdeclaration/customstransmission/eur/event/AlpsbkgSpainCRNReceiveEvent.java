/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AlpsbkgSpainCRNReceiveEvent
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.09.20
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2011.09.20 경종윤
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event;

import com.hanjin.apps.alps.esm.bkg.servicesio.CustomsDeclarationProxy;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * SITPRO(스페인, 포르투갈 CRN 수신)EDI 수신용 이벤트
 * 
 * @author Kyoung Jong Yun
 * @see CustomsDeclarationProxy 참조
 * @since J2EE 1.6
 */
public class AlpsbkgSpainCRNReceiveEvent extends EventSupport {
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

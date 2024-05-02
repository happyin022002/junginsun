/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : UbizhjsAlpsCtmVermasEvent.java
 * @FileTitle : EDI to Terminal
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.07.12 김상현 1.0 Creation
 */

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * receiving from MQ
 *
 * @author 김상현
 * @see 
 * @since J2EE 1.6
 */
public class UbizhjsAlpsCtmVermasEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
}

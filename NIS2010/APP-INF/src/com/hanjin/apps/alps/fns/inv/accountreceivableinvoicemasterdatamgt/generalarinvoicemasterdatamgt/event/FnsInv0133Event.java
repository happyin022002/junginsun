/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FnsInv0132Event.java
 * @FileTitle : EDI Submission(Philips)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.12.02
 * @LastModifier : 9011620
 * @LastVersion : 1.0
 * 1.0 Creation 2012.12.02 9011620.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PHILSLocationListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * DHL EDI에 대한 parameter value object.
 * 
 * @author 9011620
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FnsInv0133Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PHILSLocationListVO philsLocationListVO[] = null;

	/**
	 * @return the philsLocationListVO
	 */
	public PHILSLocationListVO[] getPhilsLocationListVO() {
		return philsLocationListVO;
	}

	/**
	 * @param philsLocationListVO the philsLocationListVO to set
	 */
	public void setPhilsLocationListVO(PHILSLocationListVO[] philsLocationListVO) {
		this.philsLocationListVO = philsLocationListVO;
	}
}

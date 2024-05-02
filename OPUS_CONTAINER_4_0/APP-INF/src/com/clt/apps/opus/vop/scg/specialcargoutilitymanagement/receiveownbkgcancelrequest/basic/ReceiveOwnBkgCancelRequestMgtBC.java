/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceiveOwnBkgCancelRequestMgtBC.java
 *@FileTitle : ReceiveOwnBkgCancelRequestMgtBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.19
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.19 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic;

import java.util.List;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Receive Own Bkg Cancel Request Mgt Basic Command <br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public interface ReceiveOwnBkgCancelRequestMgtBC {
	
	/**
	 * SCG_VVD_DG_CGO_CXL_RQST SAVE <br>
	 * 
	 * @param List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs
	 * @exception EventException
	 */
	public void addScgVvdDgCgoCxlRqst(List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs) throws EventException;
}

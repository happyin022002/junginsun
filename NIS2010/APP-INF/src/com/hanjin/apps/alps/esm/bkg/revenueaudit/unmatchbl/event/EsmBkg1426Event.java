/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkgEvent.java
*@FileTitle :  Multi Rate BKG List for Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2016.08.19 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_ 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongmin Cho
 * @see ESM_BKG_0698HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1426Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MultiRateBkgListVO multiRateBkgListVO = null;

	/**
	 * @return the multiRateBkgListVO
	 */
	public MultiRateBkgListVO getMultiRateBkgListVO() {
		return multiRateBkgListVO;
	} 

	/**
	 * @param MultiRateBkgListVO the multiRateBkgListVO to set
	 */
	public void setMultiRateBkgListVO(MultiRateBkgListVO multiRateBkgListVO) {
		this.multiRateBkgListVO = multiRateBkgListVO;
	}


}
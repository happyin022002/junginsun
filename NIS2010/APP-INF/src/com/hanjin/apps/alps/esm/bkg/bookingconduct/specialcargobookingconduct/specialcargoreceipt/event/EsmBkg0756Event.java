/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0756Event.java
*@FileTitle : Details per each package
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.23 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0756 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0756HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0756HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0756Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgAwkDimVO bkgAwkDimVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgAwkDimVO[] bkgAwkDimVOs = null;

	public EsmBkg0756Event(){}

	/**
	 * @param bkgAwkDimVO the bkgAwkDimVO to set
	 */
	public void setBkgAwkDimVO(BkgAwkDimVO bkgAwkDimVO){
		this. bkgAwkDimVO = bkgAwkDimVO;
	}

	/**
	 * @param bkgAwkDimVOs the bkgAwkDimVOs to set
	 */
	public void setBkgAwkDimVOS(BkgAwkDimVO[] bkgAwkDimVOs){
		this. bkgAwkDimVOs = bkgAwkDimVOs;
	}

	 /**
     * @return the bkgAwkDimVO
     */
	public BkgAwkDimVO getBkgAwkDimVO(){
		return bkgAwkDimVO;
	}

	 /**
     * @return the bkgAwkDimVOs
     */
	public BkgAwkDimVO[] getBkgAwkDimVOS(){
		return bkgAwkDimVOs;
	}

}
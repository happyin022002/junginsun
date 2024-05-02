/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0369Event.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_0742 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0742HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0742HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0742Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg0742Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private AttachFileInVO attachFileInVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  출력VO   */
	private AttachFileOutVO attachFileOutVO = null;


	/**
	 * @return the attachFileInVO
	 */
	public AttachFileInVO getAttachFileInVO() {
		return attachFileInVO;
	}
	/**
	 * @param attachFileInVO the attachFileInVO to set
	 */
	public void setAttachFileInVO(AttachFileInVO attachFileInVO) {
		this.attachFileInVO = attachFileInVO;
	}
	/**
	 * @return the attachFileOutVO
	 */
	public AttachFileOutVO getAttachFileOutVO() {
		return attachFileOutVO;
	}
	/**
	 * @param attachFileOutVO the attachFileOutVO to set
	 */
	public void setAttachFileOutVO(AttachFileOutVO attachFileOutVO) {
		this.attachFileOutVO = attachFileOutVO;
	}



}
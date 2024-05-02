/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0305Event.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.03 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaBondDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaBondListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0305 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0305HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0305HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0305Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IndiaBondListCondVO indiaBondListCondVO = null;
	private IndiaBondDetailVO indiaBondDetailVO = null;
	
	public EsmBkg0305Event(){}

	/**
	 * @return the indiaBondListCondVO
	 */
	public IndiaBondListCondVO getIndiaBondListCondVO() {
		return indiaBondListCondVO;
	}

	/**
	 * @param indiaBondListCondVO the indiaBondListCondVO to set
	 */
	public void setIndiaBondListCondVO(IndiaBondListCondVO indiaBondListCondVO) {
		this.indiaBondListCondVO = indiaBondListCondVO;
	}

	/**
	 * @return the indiaBondDetailVO
	 */
	public IndiaBondDetailVO getIndiaBondDetailVO() {
		return indiaBondDetailVO;
	}

	/**
	 * @param indiaBondDetailVO the indiaBondDetailVO to set
	 */
	public void setIndiaBondDetailVO(IndiaBondDetailVO indiaBondDetailVO) {
		this.indiaBondDetailVO = indiaBondDetailVO;
	}
	

}
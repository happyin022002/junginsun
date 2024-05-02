/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0304Event.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.04 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0304 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0304HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0304HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0304Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InVesselArrivalCondVO inVesselArrivalCondVO = null;
	private InVesselArrivalDetailVO inVesselArrivalDetailVO = null;
	private InVesselArrivalVO inVesselArrivalVO = null;
	
	
	public EsmBkg0304Event(){}


	/**
	 * @return the inVesselArrivalCondVO
	 */
	public InVesselArrivalCondVO getInVesselArrivalCondVO() {
		return inVesselArrivalCondVO;
	}


	/**
	 * @param inVesselArrivalCondVO the inVesselArrivalCondVO to set
	 */
	public void setInVesselArrivalCondVO(InVesselArrivalCondVO inVesselArrivalCondVO) {
		this.inVesselArrivalCondVO = inVesselArrivalCondVO;
	}


	/**
	 * @return the inVesselArrivalDetailVO
	 */
	public InVesselArrivalDetailVO getInVesselArrivalDetailVO() {
		return inVesselArrivalDetailVO;
	}


	/**
	 * @param inVesselArrivalDetailVO the inVesselArrivalDetailVO to set
	 */
	public void setInVesselArrivalDetailVO(
			InVesselArrivalDetailVO inVesselArrivalDetailVO) {
		this.inVesselArrivalDetailVO = inVesselArrivalDetailVO;
	}


	/**
	 * @return the inVesselArrivalVO
	 */
	public InVesselArrivalVO getInVesselArrivalVO() {
		return inVesselArrivalVO;
	}


	/**
	 * @param inVesselArrivalVO the inVesselArrivalVO to set
	 */
	public void setInVesselArrivalVO(InVesselArrivalVO inVesselArrivalVO) {
		this.inVesselArrivalVO = inVesselArrivalVO;
	}



	

}
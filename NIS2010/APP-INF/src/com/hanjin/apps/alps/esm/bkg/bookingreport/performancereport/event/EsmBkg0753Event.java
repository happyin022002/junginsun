/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0753Event.java
*@FileTitle : bookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.01 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;


/**
 * ESM_BKG_0753 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0753HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0753HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0753Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselVVDListVO vesselVVDListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VesselVVDListVO[] vesselVVDListVOs = null;

	public EsmBkg0753Event(){}
	
	public void setVesselVVDListVO(VesselVVDListVO vesselVVDListVO){
		this. vesselVVDListVO = vesselVVDListVO;
	}

	public void setVesselVVDListVOS(VesselVVDListVO[] vesselVVDListVOs){
		this. vesselVVDListVOs = vesselVVDListVOs;
	}

	public VesselVVDListVO getVesselVVDListVO(){
		return vesselVVDListVO;
	}

	public VesselVVDListVO[] getVesselVVDListVOS(){
		return vesselVVDListVOs;
	}

}
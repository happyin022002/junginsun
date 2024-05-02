/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0018Event.java
*@FileTitle : ESM_BKG-0018
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0018HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PanamaVesselVO panamaVesselVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private PanamaVesselVO[] panamaVesselVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PanamaVesselCondVO panamaVesselCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PanamaVesselCondVO[] panamaVesselCondVOs = null;			

	public EsmBkg0018Event(){}
	
	public void setPanamaVesselVO(PanamaVesselVO panamaVesselVO){
		this. panamaVesselVO = panamaVesselVO;
	}

	public void setPanamaVesselVOS(PanamaVesselVO[] panamaVesselVOs){
		this. panamaVesselVOs = panamaVesselVOs;
	}
	
	public void setPanamaVesselCondVO(PanamaVesselCondVO panamaVesselCondVO){
		this. panamaVesselCondVO = panamaVesselCondVO;
	}

	public void setPanamaVesselCondVOS(PanamaVesselCondVO[] panamaVesselCondVOs){
		this. panamaVesselCondVOs = panamaVesselCondVOs;
	}	
	
	public PanamaVesselVO getPanamaVesselVO(){
		return panamaVesselVO;
	}

	public PanamaVesselVO[] getPanamaVesselVOS(){
		return panamaVesselVOs;
	}
	
	public PanamaVesselCondVO getPanamaVesselCondVO(){
		return panamaVesselCondVO;
	}

	public VesselCondVO[] getPanamaVesselCondVOS(){
		return panamaVesselCondVOs;
	}		

}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0053Event.java
*@FileTitle : Stevedore Damage Inquiry & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.02 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SdmsOptionVO sdmsOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SdmsOptionVO[] sdmsOptionVOs = null;

	public VopOpf0053Event(){}
	
	public void setSdmsOptionVO(SdmsOptionVO sdmsOptionVO){
		this. sdmsOptionVO = sdmsOptionVO;
	}

	public void setSdmsOptionVOS(SdmsOptionVO[] sdmsOptionVOs){
		if (sdmsOptionVOs != null) {
			SdmsOptionVO[] tmpVOs = Arrays.copyOf(sdmsOptionVOs, sdmsOptionVOs.length);
			this.sdmsOptionVOs = tmpVOs;
		} // end if
	}

	public SdmsOptionVO getSdmsOptionVO(){
		return sdmsOptionVO;
	}

	public SdmsOptionVO[] getSdmsOptionVOS(){
		SdmsOptionVO[] rtnVOs = null;
		if (this.sdmsOptionVOs != null) {
			rtnVOs = Arrays.copyOf(this.sdmsOptionVOs, this.sdmsOptionVOs.length);
		} // end if
		return rtnVOs;
	}

}
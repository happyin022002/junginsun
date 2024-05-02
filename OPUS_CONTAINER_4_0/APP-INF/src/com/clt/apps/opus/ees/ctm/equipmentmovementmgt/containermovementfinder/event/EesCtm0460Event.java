/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0460Event.java
*@FileTitle : VL/VD update status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.09.25 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.VLVDUpdateStatusVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CTM_0460 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CTM_0460HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung Min Woo
 * @see EES_CTM_0460HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCtm0460Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VLVDUpdateStatusVO vLVDUpdateStatus = null;
	
	/** Table Value Object Multi Data 처리 */
	private VLVDUpdateStatusVO[] vLVDUpdateStatuss = null;

	public EesCtm0460Event(){}
	
	public void setVLVDUpdateStatusVO(VLVDUpdateStatusVO vLVDUpdateStatus){
		this. vLVDUpdateStatus = vLVDUpdateStatus;
	}

	public void setVLVDUpdateStatusVOS(VLVDUpdateStatusVO[] vLVDUpdateStatuss){
		if (vLVDUpdateStatuss != null) {
			VLVDUpdateStatusVO[] tmpVOs = new VLVDUpdateStatusVO[vLVDUpdateStatuss.length];
			System.arraycopy(vLVDUpdateStatuss, 0, tmpVOs, 0, tmpVOs.length);
			this.vLVDUpdateStatuss = tmpVOs;
		}
	}

	public VLVDUpdateStatusVO getVLVDUpdateStatusVO(){
		return vLVDUpdateStatus;
	}

	public VLVDUpdateStatusVO[] getVLVDUpdateStatusVOS(){
		VLVDUpdateStatusVO[] tmpVOs = null;
		if (this.vLVDUpdateStatuss != null) {
			tmpVOs = new VLVDUpdateStatusVO[vLVDUpdateStatuss.length];
			System.arraycopy(vLVDUpdateStatuss, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
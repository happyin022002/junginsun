/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0083Event.java
*@FileTitle : Owner List Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.16 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0083 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0083HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0083HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0083Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomOwnerVO customownervo = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomOwnerVO[] customownervos = null;

	public EsmFms0083Event(){}
	
	public void setCustomOwnerVO(CustomOwnerVO customownervo){
		this. customownervo = customownervo;
	}

	public void setCustomOwnerVOS(CustomOwnerVO[] customownervos){
		if (customownervos != null) {
			CustomOwnerVO[] tmpVOs = new CustomOwnerVO[customownervos.length];
			System.arraycopy(customownervos, 0, tmpVOs, 0, tmpVOs.length);
			this.customownervos = tmpVOs;
		}
	}

	public CustomOwnerVO getCustomOwnerVO(){
		return customownervo;
	}

	public CustomOwnerVO[] getCustomOwnerVOS(){
		CustomOwnerVO[] tmpVOs = null;
		if (this.customownervos != null) {
			tmpVOs = new CustomOwnerVO[customownervos.length];
			System.arraycopy(customownervos, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
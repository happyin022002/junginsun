/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0205Event.java
*@FileTitle : EAC Inquiry/EDIT
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACEditVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0205 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0205HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0205HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0205Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACEditVO eacEditVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EacSearchVO[] eacEditVOs = null;
	
	public EsdEas0205Event(){}

	public EacSearchVO getEacSearchVO() {
		return eacSearchVO;
	}

	public void setEacSearchVO(EacSearchVO eacSearchVO) {
		this.eacSearchVO = eacSearchVO;
	}


	public EACEditVO getEacEditVO() {
		return eacEditVO;
	}

	public void setEacEditVO(EACEditVO eacEditVO) {
		this.eacEditVO = eacEditVO;
	}

	public EacSearchVO[] getEacEditVOs() {
		EacSearchVO[] rtnVOs = null;
		if (this.eacEditVOs != null) {
			rtnVOs = new EacSearchVO[eacEditVOs.length];
			System.arraycopy(eacEditVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacEditVOs(EacSearchVO[] eacEditVOs){
		if(eacEditVOs != null){
			EacSearchVO[] tmpVOs = new EacSearchVO[eacEditVOs.length];
			System.arraycopy(eacEditVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacEditVOs = tmpVOs;
		}
	}


	


}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0220Event.java
*@FileTitle : TPB Inquiry by EAC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.23 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;


import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqEacVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0220 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0220HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0220HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0220Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACInqEacVO eacInqEacVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACInqEacVO[] eacInqEacVOs = null;

	public EsdEas0220Event(){}

	public EACInqEacVO getEacInqEacVO() {
		return eacInqEacVO;
	}

	public void setEacInqEacVO(EACInqEacVO eacInqEacVO) {
		this.eacInqEacVO = eacInqEacVO;
	}

	public EACInqEacVO[] getEacInqEacVOs() {
		EACInqEacVO[] rtnVOs = null;
		if (this.eacInqEacVOs != null) {
			rtnVOs = new EACInqEacVO[eacInqEacVOs.length];
			System.arraycopy(eacInqEacVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacInqEacVOs(EACInqEacVO[] eacInqEacVOs){
		if(eacInqEacVOs != null){
			EACInqEacVO[] tmpVOs = new EACInqEacVO[eacInqEacVOs.length];
			System.arraycopy(eacInqEacVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacInqEacVOs = tmpVOs;
		}
	}


}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0211Event.java
*@FileTitle : Rejection Notice Mail
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0211 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0211HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0211HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0211Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACNtcVO eacNtcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACNtcVO[] eacNtcVOs = null;

	public EsdEas0211Event(){}

	public EACNtcVO getEacNtcVO() {
		return eacNtcVO;
	}

	public void setEacNtcVO(EACNtcVO eacNtcVO) {
		this.eacNtcVO = eacNtcVO;
	}

	public EACNtcVO[] getEacNtcVOs() {
		EACNtcVO[] rtnVOs = null;
		if (this.eacNtcVOs != null) {
			rtnVOs = new EACNtcVO[eacNtcVOs.length];
			System.arraycopy(eacNtcVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacNtcVOs(EACNtcVO[] eacNtcVOs){
		if(eacNtcVOs != null){
			EACNtcVO[] tmpVOs = new EACNtcVO[eacNtcVOs.length];
			System.arraycopy(eacNtcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacNtcVOs = tmpVOs;
		}
	}
	


}
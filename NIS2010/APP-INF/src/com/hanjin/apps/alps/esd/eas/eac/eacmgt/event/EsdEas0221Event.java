/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0221Event.java
*@FileTitle : Rejection Notice Send History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;


import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0221 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0221HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0221HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0221Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACNtcHisVO eacNtcHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACNtcHisVO[] eacNtcHisVOs = null;

	public EsdEas0221Event(){}

	public EACNtcHisVO getEacNtcHisVO() {
		return eacNtcHisVO;
	}

	public void setEacNtcHisVO(EACNtcHisVO eacNtcHisVO) {
		this.eacNtcHisVO = eacNtcHisVO;
	}

	public EACNtcHisVO[] getEacNtcHisVOs() {
		EACNtcHisVO[] rtnVOs = null;
		if (this.eacNtcHisVOs != null) {
			rtnVOs = new EACNtcHisVO[eacNtcHisVOs.length];
			System.arraycopy(eacNtcHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacNtcHisVOs(EACNtcHisVO[] eacNtcHisVOs){
		if(eacNtcHisVOs != null){
			EACNtcHisVO[] tmpVOs = new EACNtcHisVO[eacNtcHisVOs.length];
			System.arraycopy(eacNtcHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacNtcHisVOs = tmpVOs;
		}
	}


	

}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0217Event.java
*@FileTitle : EAC Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.03 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0217 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0217HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0217HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0217Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EacSearchVO[] eacSearchVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACInqVO eacInqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACInqVO[] eacInqVOs = null;

	public EsdEas0217Event(){}

	public EacSearchVO getEacSearchVO() {
		return eacSearchVO;
	}

	public void setEacSearchVO(EacSearchVO eacSearchVO) {
		this.eacSearchVO = eacSearchVO;
	}

	public EacSearchVO[] getEacSearchVOs() {
		EacSearchVO[] rtnVOs = null;
		if (this.eacSearchVOs != null) {
			rtnVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacSearchVOs(EacSearchVO[] eacSearchVOs){
		if(eacSearchVOs != null){
			EacSearchVO[] tmpVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacSearchVOs = tmpVOs;
		}
	}

	public EACInqVO getEacInqVO() {
		return eacInqVO;
	}

	public void setEacInqVO(EACInqVO eacInqVO) {
		this.eacInqVO = eacInqVO;
	}

	public EACInqVO[] getEacInqVOs() {
		EACInqVO[] rtnVOs = null;
		if (this.eacInqVOs != null) {
			rtnVOs = new EACInqVO[eacInqVOs.length];
			System.arraycopy(eacInqVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacInqVOs(EACInqVO[] eacInqVOs){
		if(eacInqVOs != null){
			EACInqVO[] tmpVOs = new EACInqVO[eacInqVOs.length];
			System.arraycopy(eacInqVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacInqVOs = tmpVOs;
		}
	}
	

}
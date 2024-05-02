/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0223Event.java
*@FileTitle : EAC 첨부 파일 내역 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileInVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0223 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0223HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0223HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0223Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdEas0223Event(){}
	
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	EacFileInVO eacFileInVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	EacFileOutVO[] eacFileOutVOs = null;
	public EacFileInVO getEacFileInVO() {
		return eacFileInVO;
	}

	public void setEacFileInVO(EacFileInVO eacFileInVO) {
		this.eacFileInVO = eacFileInVO;
	}

	public EacFileOutVO[] getEacFileOutVOs() {
		EacFileOutVO[] rtnVOs = null;
		if (this.eacFileOutVOs != null) {
			rtnVOs = new EacFileOutVO[eacFileOutVOs.length];
			System.arraycopy(eacFileOutVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacFileOutVOs(EacFileOutVO[] eacFileOutVOs){
		if(eacFileOutVOs != null){
			EacFileOutVO[] tmpVOs = new EacFileOutVO[eacFileOutVOs.length];
			System.arraycopy(eacFileOutVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacFileOutVOs = tmpVOs;
		}
	}

}
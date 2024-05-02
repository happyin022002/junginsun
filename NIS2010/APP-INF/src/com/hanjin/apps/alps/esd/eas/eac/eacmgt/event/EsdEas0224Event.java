/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0224Event.java
*@FileTitle : EAS Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.16 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;


/**
 * ESD_EAS_0224 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0224HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0224HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0224Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EacSearchVO[] eacSearchVOs = null;

	public EsdEas0224Event(){}
	
	public void setEacSearchVO(EacSearchVO eacSearchVO){
		this. eacSearchVO = eacSearchVO;
	}

	public void setEacSearchVOS(EacSearchVO[] eacSearchVOs){
		if(eacSearchVOs != null){
			EacSearchVO[] tmpVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacSearchVOs = tmpVOs;
		}
	}

	public EacSearchVO getEacSearchVO(){
		return eacSearchVO;
	}

	public EacSearchVO[] getEacSearchVOS(){
		EacSearchVO[] rtnVOs = null;
		if (this.eacSearchVOs != null) {
			rtnVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}
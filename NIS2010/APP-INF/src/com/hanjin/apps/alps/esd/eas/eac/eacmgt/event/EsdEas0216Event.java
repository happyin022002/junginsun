/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0216Event.java
*@FileTitle : EAC Reject
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.03 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCfmVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0216 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0216HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0216HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0216Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACCfmVO eacCfmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACCfmVO[] eacCfmVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EacSearchVO[] eacSearchVOs = null;

	public EsdEas0216Event(){}

	public EACCfmVO getEacCfmVO() {
		return eacCfmVO;
	}

	public void setEacCfmVO(EACCfmVO eacCfmVO) {
		this.eacCfmVO = eacCfmVO;
	}

	public EACCfmVO[] getEacCfmVOs() {
		EACCfmVO[] rtnVOs = null;
		if (this.eacCfmVOs != null) {
			rtnVOs = new EACCfmVO[eacCfmVOs.length];
			System.arraycopy(eacCfmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEacCfmVOs(EACCfmVO[] eacCfmVOs){
		if(eacCfmVOs != null){
			EACCfmVO[] tmpVOs = new EACCfmVO[eacCfmVOs.length];
			System.arraycopy(eacCfmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacCfmVOs = tmpVOs;
		}
	}

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
	

}
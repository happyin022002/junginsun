/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0202Event.java
*@FileTitle : Contract Point
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACSpCtrtVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0202 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0202HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0202HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0202Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACSpCtrtVO eacSpContactPointVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACSpCtrtVO[] eacSpContactPointVOs = null;
	
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object MultiCombo Data 처리 */
	EacSearchVO[] eacSearchVOs = null;	
	
	public EsdEas0202Event(){}
	public void setEacSearchVO(EacSearchVO eacSearchVO) {
		this.eacSearchVO = eacSearchVO;
	}
	public void setEacSearchVOs(EacSearchVO[] eacSearchVOs){
		if(eacSearchVOs != null){
			EacSearchVO[] tmpVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacSearchVOs = tmpVOs;
		}
	}
	public EacSearchVO getEacSearchVO() {
		return eacSearchVO;
	}

	public EacSearchVO[] getEacSearchVOs() {
		EacSearchVO[] rtnVOs = null;
		if (this.eacSearchVOs != null) {
			rtnVOs = new EacSearchVO[eacSearchVOs.length];
			System.arraycopy(eacSearchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public EACSpCtrtVO getEacSpContactPointVO() {
		return eacSpContactPointVO;
	}
	public void setEacSpContactPointVO(EACSpCtrtVO eacSpContactPointVO) {
		this.eacSpContactPointVO = eacSpContactPointVO;
	}
	public EACSpCtrtVO[] getEacSpContactPointVOs() {
		EACSpCtrtVO[] rtnVOs = null;
		if (this.eacSpContactPointVOs != null) {
			rtnVOs = new EACSpCtrtVO[eacSpContactPointVOs.length];
			System.arraycopy(eacSpContactPointVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setEacSpContactPointVOs(EACSpCtrtVO[] eacSpContactPointVOs){
		if(eacSpContactPointVOs != null){
			EACSpCtrtVO[] tmpVOs = new EACSpCtrtVO[eacSpContactPointVOs.length];
			System.arraycopy(eacSpContactPointVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacSpContactPointVOs = tmpVOs;
		}
	}




}
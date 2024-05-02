/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0201Event.java
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

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACRgstVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACTpbDtlVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0201 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0201HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0201HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0201Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	EACRgstVO eacRegistrationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	EACRgstVO[] eacRegistrationVOs = null;
	
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	EacSearchVO eacSearchVO = null;
	
	/** Table Value Object MultiCombo Data 처리 */
	EacSearchVO[] eacSearchVOs = null;	

	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	EACTpbDtlVO eacTpbDtlVO = null;
	
	/** Table Value Object MultiCombo Data 처리 */
	EACTpbDtlVO[] eacTpbDtlVOs = null;	
	
	public EsdEas0201Event(){}
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
	
	public EACRgstVO getEacRegistrationVO() {
		return eacRegistrationVO;
	}
	public void setEacRegistrationVO(EACRgstVO eacRegistrationVO) {
		this.eacRegistrationVO = eacRegistrationVO;
	}
	public EACRgstVO[] getEacRegistrationVOs() {
		EACRgstVO[] rtnVOs = null;
		if (this.eacRegistrationVOs != null) {
			rtnVOs = new EACRgstVO[eacRegistrationVOs.length];
			System.arraycopy(eacRegistrationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setEacRegistrationVOs(EACRgstVO[] eacRegistrationVOs){
		if(eacRegistrationVOs != null){
			EACRgstVO[] tmpVOs = new EACRgstVO[eacRegistrationVOs.length];
			System.arraycopy(eacRegistrationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacRegistrationVOs = tmpVOs;
		}
	}
	public EACTpbDtlVO getEacTpbDtlVO() {
		return eacTpbDtlVO;
	}
	public void setEacTpbDtlVO(EACTpbDtlVO eacTpbDtlVO) {
		this.eacTpbDtlVO = eacTpbDtlVO;
	}
	public EACTpbDtlVO[] getEacTpbDtlVOs() {
		EACTpbDtlVO[] rtnVOs = null;
		if (this.eacTpbDtlVOs != null) {
			rtnVOs = new EACTpbDtlVO[eacTpbDtlVOs.length];
			System.arraycopy(eacTpbDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setEacTpbDtlVOs(EACTpbDtlVO[] eacTpbDtlVOs){
		if(eacTpbDtlVOs != null){
			EACTpbDtlVO[] tmpVOs = new EACTpbDtlVO[eacTpbDtlVOs.length];
			System.arraycopy(eacTpbDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eacTpbDtlVOs = tmpVOs;
		}
	}




}
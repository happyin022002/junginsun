/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PriScqBbRqstVO.java
*@FileTitle : PriScqBbRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo;

import java.io.Serializable;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScqBbRqstVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriScqBbHdrVO[] priScqBbHdrVOs = null;
	private PriScqBbCgoVO[] priScqBbCgoVOs = null;
	private PriScqBbCntrVO[] priScqBbCntrVOs = null;
	private PriScqBbRoutCostVO[] priScqBbRoutCostVOs = null;
	private PriScqBbHdrVO priScqBbHdrVO = null;
		
	private String masterDelChk = "";
	
	public PriScqBbHdrVO[] getPriScqBbHdrVOs() {
		return priScqBbHdrVOs;
	}
	public PriScqBbCgoVO[] getPriScqBbCgoVOs() {
		return priScqBbCgoVOs;
	}
	public PriScqBbCntrVO[] getPriScqBbCntrVOs() {
		return priScqBbCntrVOs;
	}
	public PriScqBbRoutCostVO[] getPriScqBbRoutCostVOs() {
		return priScqBbRoutCostVOs;
	}
	
	public void setPriScqBbHdrVOs(PriScqBbHdrVO[] priScqBbHdrVOs) {
		this.priScqBbHdrVOs = priScqBbHdrVOs;
	}
	public void setPriScqBbCgoVOs(PriScqBbCgoVO[] priScqBbCgoVOs) {
		this.priScqBbCgoVOs = priScqBbCgoVOs;
	}
	public void setPriScqBbCntrVOs(PriScqBbCntrVO[] priScqBbCntrVOs) {
		this.priScqBbCntrVOs = priScqBbCntrVOs;
	}
	public void setPriScqBbRoutCostVOs(PriScqBbRoutCostVO[] priScqBbRoutCostVOs) {
		this.priScqBbRoutCostVOs = priScqBbRoutCostVOs;
	}
	
	public String getMasterDelChk() {
		return masterDelChk;
	}
	public void setMasterDelChk(String masterDelChk) {
		this.masterDelChk = masterDelChk;
	}
	public PriScqBbHdrVO getPriScqBbHdrVO() {
		return priScqBbHdrVO;
	}
	public void setPriScqBbHdrVO(PriScqBbHdrVO PriScqBbHdrVO) {
		this.priScqBbHdrVO = PriScqBbHdrVO;
	}
	
}
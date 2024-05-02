/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PriScqAwkRqstVO.java
*@FileTitle : PriScqAwkRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo;

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

public class PriScqAwkRqstVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriScqAwkHdrVO[] priScqAwkHdrVOs = null;
	private PriScqAwkCgoVO[] priScqAwkCgoVOs = null;
	private AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVOs = null;
	private PriScqAwkHdrVO priScqAwkHdrVO = null;
		
	private String masterDelChk = "";
	
	public PriScqAwkHdrVO[] getPriScqAwkHdrVOs() {
		return priScqAwkHdrVOs;
	}
	public PriScqAwkCgoVO[] getPriScqAwkCgoVOs() {
		return priScqAwkCgoVOs;
	}
	public AwkCgoExtraCostByRouteVO[] getAwkCgoExtraCostByRouteVOs() {
		return awkCgoExtraCostByRouteVOs;
	}
	public void setPriScqAwkHdrVOs(PriScqAwkHdrVO[] priScqAwkHdrVOs) {
		this.priScqAwkHdrVOs = priScqAwkHdrVOs;
	}
	public void setPriScqAwkCgoVOs(PriScqAwkCgoVO[] priScqAwkCgoVOs) {
		this.priScqAwkCgoVOs = priScqAwkCgoVOs;
	}
	public void setAwkCgoExtraCostByRouteVOs(AwkCgoExtraCostByRouteVO[] awkCgoExtraCostByRouteVOs) {
		this.awkCgoExtraCostByRouteVOs = awkCgoExtraCostByRouteVOs;
	}
	public String getMasterDelChk() {
		return masterDelChk;
	}
	public void setMasterDelChk(String masterDelChk) {
		this.masterDelChk = masterDelChk;
	}
	public PriScqAwkHdrVO getPriScqAwkHdrVO() {
		return priScqAwkHdrVO;
	}
	public void setPriScqAwkHdrVO(PriScqAwkHdrVO priScqAwkHdrVO) {
		this.priScqAwkHdrVO = priScqAwkHdrVO;
	}
	
}
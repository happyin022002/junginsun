/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AllCNTRCargoVO.java
*@FileTitle : AllCNTRCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : Kim Tae Kyun
*@LastVersion : 1.0
* 2010.07.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AllCNTRCargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private SCCNTRCargoVO sCCNTRCargoVO = null;
	
	private RFACNTRCargoVO rFACNTRCargoVO = null;

	public SCCNTRCargoVO getSCCNTRCargoVO() {
		return this.sCCNTRCargoVO;
	}

	public void setSCCNTRCargoVO(SCCNTRCargoVO sCCNTRCargoVO) {
		this.sCCNTRCargoVO = sCCNTRCargoVO;
	}

	public RFACNTRCargoVO getRFACNTRCargoVO() {
		return this.rFACNTRCargoVO;
	}

	public void setRFACNTRCargoVO(RFACNTRCargoVO rFACNTRCargoVO) {
		this.rFACNTRCargoVO = rFACNTRCargoVO;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriTrfBzcRoutPntVO.java
*@FileTitle : RsltPriTrfBzcRoutPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo;

import java.io.Serializable;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.PriTrfBzcProgVO;
import com.hanjin.syscommon.common.table.PriTrfBzcRoutPntVO;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrfBzcMnVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PriTrfBzcVO priTrfBzcVO = null;
	private PriTrfBzcRoutPntVO[] priTrfBzcRoutPntVOs = null;
	private PriTrfBzcRoutPntVO[] priTrfBzcRoutPntVOs2 = null;
	private PriTrfBzcProgVO priTrfBzcProgVO = null;
		
	public PriTrfBzcVO getPriTrfBzcVO() {
		return priTrfBzcVO;
	}
	public PriTrfBzcRoutPntVO[] getPriTrfBzcRoutPntVOs() {
		return priTrfBzcRoutPntVOs;
	}
	public PriTrfBzcRoutPntVO[] getPriTrfBzcRoutPntVOs2() {
		return priTrfBzcRoutPntVOs2;
	}
	public PriTrfBzcProgVO getPriTrfBzcProgVO() {
		return priTrfBzcProgVO;
	}
	
	public void setPriTrfBzcVO(PriTrfBzcVO priTrfBzcVO) {
		this.priTrfBzcVO = priTrfBzcVO;
	}
	public void setPriTrfBzcRoutPntVOs(PriTrfBzcRoutPntVO[] priTrfBzcRoutPntVOs) {
		this.priTrfBzcRoutPntVOs = priTrfBzcRoutPntVOs;
	}
	public void setPriTrfBzcRoutPntVOs2(PriTrfBzcRoutPntVO[] priTrfBzcRoutPntVOs2) {
		this.priTrfBzcRoutPntVOs2 = priTrfBzcRoutPntVOs2;
	}
	public void setPriTrfBzcProgVO(PriTrfBzcProgVO priTrfBzcProgVO) {
		this.priTrfBzcProgVO = priTrfBzcProgVO;
	}

}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpLocGlineVO.java
*@FileTitle : GrpLocGlineVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.04.16 변영주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriSpBlplCtntVO;
import com.clt.syscommon.common.table.PriSpBlplVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 공백진
 * @since J2EE 1.5
 */

public class BlplPropVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public PriSpBlplVO[] getPriSpBlplVOs() {
		return priSpBlplVOs;
	}
	public void setPriSpBlplVOs(PriSpBlplVO[] priSpBlplVOs) {
		this.priSpBlplVOs = priSpBlplVOs;
	}
	public PriSpBlplCtntVO[] getPriSpBlplCtntVOs() {
		return priSpBlplCtntVOs;
	}
	public void setPriSpBlplCtntVOs(PriSpBlplCtntVO[] priSpBlplCtntVOs) {
		this.priSpBlplCtntVOs = priSpBlplCtntVOs;
	}
	private PriSpBlplVO[] priSpBlplVOs = null;
	private PriSpBlplCtntVO[] priSpBlplCtntVOs = null;	

	

	
	
}

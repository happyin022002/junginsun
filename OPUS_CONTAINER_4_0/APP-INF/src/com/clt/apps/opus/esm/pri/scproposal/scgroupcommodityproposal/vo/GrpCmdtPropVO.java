/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpCmdtPropVO.java
*@FileTitle : GrpCmdtPropVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.27 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scgroupcommodityproposal.vo;

import java.io.Serializable;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpCmdtVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpCmdtPropVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs = null;
	private PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs = null;
	
	private String masterDelChk = "";
	
	public PriSpScpGrpCmdtVO[] getPriSpScpGrpCmdtVOs() {
		return priSpScpGrpCmdtVOs;
	}
	public PriSpScpGrpCmdtDtlVO[] getPriSpScpGrpCmdtDtlVOs() {
		return priSpScpGrpCmdtDtlVOs;
	}
	public void setPriSpScpGrpCmdtVOs(PriSpScpGrpCmdtVO[] priSpScpGrpCmdtVOs) {
		this.priSpScpGrpCmdtVOs = priSpScpGrpCmdtVOs;
	}
	public void setPriSpScpGrpCmdtDtlVOs(
			PriSpScpGrpCmdtDtlVO[] priSpScpGrpCmdtDtlVOs) {
		this.priSpScpGrpCmdtDtlVOs = priSpScpGrpCmdtDtlVOs;
	}
	public String getMasterDelChk() {
		return masterDelChk;
	}
	public void setMasterDelChk(String masterDelChk) {
		this.masterDelChk = masterDelChk;
	}
	
}

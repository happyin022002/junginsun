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

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo;

import java.io.Serializable;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtVO;

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
	private PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs = null;
	private PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs = null;
	private PriRpScpGrpCmdtVO priRpScpGrpCmdtVO = null;
		
	private String masterDelChk = "";
	
	public PriRpScpGrpCmdtVO[] getPriRpScpGrpCmdtVOs() {
		return priRpScpGrpCmdtVOs;
	}
	public PriRpScpGrpCmdtDtlVO[] getPriRpScpGrpCmdtDtlVOs() {
		return priRpScpGrpCmdtDtlVOs;
	}
	public void setPriRpScpGrpCmdtVOs(PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs) {
		this.priRpScpGrpCmdtVOs = priRpScpGrpCmdtVOs;
	}
	public void setPriRpScpGrpCmdtDtlVOs(
			PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs) {
		this.priRpScpGrpCmdtDtlVOs = priRpScpGrpCmdtDtlVOs;
	}
	public String getMasterDelChk() {
		return masterDelChk;
	}
	public void setMasterDelChk(String masterDelChk) {
		this.masterDelChk = masterDelChk;
	}
	public PriRpScpGrpCmdtVO getPriRpScpGrpCmdtVO() {
		return priRpScpGrpCmdtVO;
	}
	public void setPriRpScpGrpCmdtVO(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) {
		this.priRpScpGrpCmdtVO = priRpScpGrpCmdtVO;
	}
	
}

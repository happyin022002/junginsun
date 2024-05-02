/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScPropMnVO.java
*@FileTitle : ScPropMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.04.16 변영주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

import java.io.Serializable;

import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpProgVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class RfaPropProgVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriRpMnVO[] PriRpMnVOs = null;
	private PriRpScpMnVO[] PriRpScpMnVOs = null;
	private PriRpProgVO[] PriRpProgVOs = null;	
	private PriRpScpProgVO[] PriRpScpProgVOs = null;
	private PriRpHdrVO[] PriRpHdrVOs = null;
	
	public PriRpHdrVO[] getPriRpHdrVOs() {
		return PriRpHdrVOs;
	}
	public void setPriRpHdrVOs(PriRpHdrVO[] priRpHdrVOs) {
		PriRpHdrVOs = priRpHdrVOs;
	}
	public PriRpMnVO[] getPriRpMnVOs() {
		return PriRpMnVOs;
	}
	public void setPriRpMnVOs(PriRpMnVO[] PriRpMnVOs) {
		this.PriRpMnVOs = PriRpMnVOs;
	}
	public PriRpScpMnVO[] getPriRpScpMnVOs() {
		return PriRpScpMnVOs;
	}
	public void setPriRpScpMnVOs(PriRpScpMnVO[] PriRpScpMnVOs) {
		this.PriRpScpMnVOs = PriRpScpMnVOs;
	}
	public PriRpProgVO[] getPriRpProgVOs() {
		return PriRpProgVOs;
	}
	public void setPriRpProgVOs(PriRpProgVO[] PriRpProgVOs) {
		this.PriRpProgVOs = PriRpProgVOs;
	}	
	public PriRpScpProgVO[] getPriRpScpProgVOs() {
		return PriRpScpProgVOs;
	}
	public void setPriRpScpProgVOs(PriRpScpProgVO[] PriRpScpProgVOs) {
		this.PriRpScpProgVOs = PriRpScpProgVOs;
	}

	
}

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

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

import java.io.Serializable;

import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpProgVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpProgVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class ScPropProgVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriSpMnVO[] PriSpMnVOs = null;
	private PriSpScpMnVO[] PriSpScpMnVOs = null;
	private PriSpProgVO[] PriSpProgVOs = null;	
	private PriSpScpProgVO[] PriSpScpProgVOs = null;
	
	public PriSpMnVO[] getPriSpMnVOs() {
		return PriSpMnVOs;
	}
	public void setPriSpMnVOs(PriSpMnVO[] PriSpMnVOs) {
		this.PriSpMnVOs = PriSpMnVOs;
	}
	public PriSpScpMnVO[] getPriSpScpMnVOs() {
		return PriSpScpMnVOs;
	}
	public void setPriSpScpMnVOs(PriSpScpMnVO[] PriSpScpMnVOs) {
		this.PriSpScpMnVOs = PriSpScpMnVOs;
	}
	public PriSpProgVO[] getPriSpProgVOs() {
		return PriSpProgVOs;
	}
	public void setPriSpProgVOs(PriSpProgVO[] PriSpProgVOs) {
		this.PriSpProgVOs = PriSpProgVOs;
	}	
	public PriSpScpProgVO[] getPriSpScpProgVOs() {
		return PriSpScpProgVOs;
	}
	public void setPriSpScpProgVOs(PriSpScpProgVO[] PriSpScpProgVOs) {
		this.PriSpScpProgVOs = PriSpScpProgVOs;
	}

	
}

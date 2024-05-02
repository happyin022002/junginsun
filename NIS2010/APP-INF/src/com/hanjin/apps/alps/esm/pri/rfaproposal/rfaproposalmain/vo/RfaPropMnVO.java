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

import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;
import com.hanjin.syscommon.common.table.PriRpDurVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
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

public class RfaPropMnVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriRpHdrVO[] PriRpHdrVOs = null;	
	
	private PriRpMnVO[] PriRpMnVOs = null;
	private PriRpDurVO[] PriRpDurVOs = null;
	private PriRpProgVO[] PriRpProgVOs = null;
	private PriRpAmdtSmryVO[] PriRpAmdtSmryVOs = null;

	
	private PriRpScpMnVO[] PriRpScpMnVOs = null;
	private PriRpScpDurVO[] PriRpScpDurVOs = null;
	private PriRpScpProgVO[] PriRpScpProgVOs = null;
	private PriRpScpAmdtSmryVO[] PriRpScpAmdtSmryVOs = null;	

	private PriRpDmdtVO[] priRpDmdtVOs = null;	

	public PriRpDmdtVO[] getPriRpDmdtVOs() {
		return priRpDmdtVOs;
	}
	public void setPriRpDmdtVOs(PriRpDmdtVO[] priRpDmdtVOs) {
		this.priRpDmdtVOs = priRpDmdtVOs;
	}
	public PriRpHdrVO[] getPriRpHdrVOs() {
		return PriRpHdrVOs;
	}
	public void setPriRpHdrVOs(PriRpHdrVO[] PriRpHdrVOs) {
		this.PriRpHdrVOs = PriRpHdrVOs;
	}	
	
	
	public PriRpMnVO[] getPriRpMnVOs() {
		return PriRpMnVOs;
	}
	public void setPriRpMnVOs(PriRpMnVO[] PriRpMnVOs) {
		this.PriRpMnVOs = PriRpMnVOs;
	}
	
	public PriRpDurVO[] getPriRpDurVOs() {
		return PriRpDurVOs;
	}
	public void setPriRpDurVOs(PriRpDurVO[] PriRpDurVOs) {
		this.PriRpDurVOs = PriRpDurVOs;
	}
	
	
	public PriRpProgVO[] getPriRpProgVOs() {
		return PriRpProgVOs;
	}
	public void setPriRpProgVOs(PriRpProgVO[] PriRpProgVOs) {
		this.PriRpProgVOs = PriRpProgVOs;
	}
	
	
	public PriRpAmdtSmryVO[] getPriRpAmdtSmryVOs() {
		return PriRpAmdtSmryVOs;
	}
	public void setPriRpAmdtSmryVOs(PriRpAmdtSmryVO[] PriRpAmdtSmryVOs) {
		this.PriRpAmdtSmryVOs = PriRpAmdtSmryVOs;
	}	



	public PriRpScpMnVO[] getPriRpScpMnVOs() {
		return PriRpScpMnVOs;
	}
	public void setPriRpScpMnVOs(PriRpScpMnVO[] PriRpScpMnVOs) {
		this.PriRpScpMnVOs = PriRpScpMnVOs;
	}
	public PriRpScpDurVO[] getPriRpScpDurVOs() {
		return PriRpScpDurVOs;
	}
	public void setPriRpScpDurVOs(PriRpScpDurVO[] PriRpScpDurVOs) {
		this.PriRpScpDurVOs = PriRpScpDurVOs;
	}

	public PriRpScpProgVO[] getPriRpScpProgVOs() {
		return PriRpScpProgVOs;
	}
	public void setPriRpScpProgVOs(PriRpScpProgVO[] PriRpScpProgVOs) {
		this.PriRpScpProgVOs = PriRpScpProgVOs;
	}
	public PriRpScpAmdtSmryVO[] getPriRpScpAmdtSmryVOs() {
		return PriRpScpAmdtSmryVOs;
	}
	public void setPriRpScpAmdtSmryVOs(PriRpScpAmdtSmryVO[] PriRpScpAmdtSmryVOs) {
		this.PriRpScpAmdtSmryVOs = PriRpScpAmdtSmryVOs;
	}	
	
	
}

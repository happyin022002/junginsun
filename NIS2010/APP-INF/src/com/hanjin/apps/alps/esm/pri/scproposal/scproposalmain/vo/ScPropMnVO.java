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

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

import java.io.Serializable;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtCustTpVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpDurVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpMqcVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpProgVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class ScPropMnVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private PriSpHdrVO[] PriSpHdrVOs = null;
	
	private PriSpMnVO[] PriSpMnVOs = null;
	private PriSpDurVO[] PriSpDurVOs = null;
	private PriSpMqcVO[] PriSpMqcVOs = null;
	private PriSpProgVO[] PriSpProgVOs = null;
	private PriSpCtrtPtyVO[] PriSpCtrtPtyVOs = null;
	private PriSpCtrtCustTpVO[] PriSpCtrtCustTpVOs = null;
	private PriSpAmdtSmryVO[] PriSpAmdtSmryVOs = null;

	
	private PriSpScpMnVO[] PriSpScpMnVOs = null;
	private PriSpScpDurVO[] PriSpScpDurVOs = null;
	private PriSpScpMqcVO[] PriSpScpMqcVOs = null;
	private PriSpScpProgVO[] PriSpScpProgVOs = null;
	private PriSpScpAmdtSmryVO[] PriSpScpAmdtSmryVOs = null;
	
	private String propNo = null;


	public PriSpHdrVO[] getPriSpHdrVOs() {
		return PriSpHdrVOs;
	}
	public void setPriSpHdrVOs(PriSpHdrVO[] PriSpHdrVOs) {
		this.PriSpHdrVOs = PriSpHdrVOs;
	}	
	
	
	public PriSpMnVO[] getPriSpMnVOs() {
		return PriSpMnVOs;
	}
	public void setPriSpMnVOs(PriSpMnVO[] PriSpMnVOs) {
		this.PriSpMnVOs = PriSpMnVOs;
	}
	
	public PriSpDurVO[] getPriSpDurVOs() {
		return PriSpDurVOs;
	}
	public void setPriSpDurVOs(PriSpDurVO[] PriSpDurVOs) {
		this.PriSpDurVOs = PriSpDurVOs;
	}
	
	public PriSpMqcVO[] getPriSpMqcVOs() {
		return PriSpMqcVOs;
	}
	public void setPriSpMqcVOs(PriSpMqcVO[] PriSpMqcVOs) {
		this.PriSpMqcVOs = PriSpMqcVOs;
	}	
	
	
	public PriSpProgVO[] getPriSpProgVOs() {
		return PriSpProgVOs;
	}
	public void setPriSpProgVOs(PriSpProgVO[] PriSpProgVOs) {
		this.PriSpProgVOs = PriSpProgVOs;
	}
	
	public PriSpCtrtPtyVO[] getPriSpCtrtPtyVOs() {
		return PriSpCtrtPtyVOs;
	}
	public void setPriSpCtrtPtyVOs(PriSpCtrtPtyVO[] PriSpCtrtPtyVOs) {
		this.PriSpCtrtPtyVOs = PriSpCtrtPtyVOs;
	}
	
	public PriSpCtrtCustTpVO[] getPriSpCtrtCustTpVOs() {
		return PriSpCtrtCustTpVOs;
	}
	public void setPriSpCtrtCustTpVOs(PriSpCtrtCustTpVO[] PriSpCtrtCustTpVOs) {
		this.PriSpCtrtCustTpVOs = PriSpCtrtCustTpVOs;
	}
	
	public PriSpAmdtSmryVO[] getPriSpAmdtSmryVOs() {
		return PriSpAmdtSmryVOs;
	}
	public void setPriSpAmdtSmryVOs(PriSpAmdtSmryVO[] PriSpAmdtSmryVOs) {
		this.PriSpAmdtSmryVOs = PriSpAmdtSmryVOs;
	}	



	public PriSpScpMnVO[] getPriSpScpMnVOs() {
		return PriSpScpMnVOs;
	}
	public void setPriSpScpMnVOs(PriSpScpMnVO[] PriSpScpMnVOs) {
		this.PriSpScpMnVOs = PriSpScpMnVOs;
	}
	public PriSpScpDurVO[] getPriSpScpDurVOs() {
		return PriSpScpDurVOs;
	}
	public void setPriSpScpDurVOs(PriSpScpDurVO[] PriSpScpDurVOs) {
		this.PriSpScpDurVOs = PriSpScpDurVOs;
	}
	public PriSpScpMqcVO[] getPriSpScpMqcVOs() {
		return PriSpScpMqcVOs;
	}
	public void setPriSpScpMqcVOs(PriSpScpMqcVO[] PriSpScpMqcVOs) {
		this.PriSpScpMqcVOs = PriSpScpMqcVOs;
	}	
	public PriSpScpProgVO[] getPriSpScpProgVOs() {
		return PriSpScpProgVOs;
	}
	public void setPriSpScpProgVOs(PriSpScpProgVO[] PriSpScpProgVOs) {
		this.PriSpScpProgVOs = PriSpScpProgVOs;
	}
	public PriSpScpAmdtSmryVO[] getPriSpScpAmdtSmryVOs() {
		return PriSpScpAmdtSmryVOs;
	}
	public void setPriSpScpAmdtSmryVOs(PriSpScpAmdtSmryVO[] PriSpScpAmdtSmryVOs) {
		this.PriSpScpAmdtSmryVOs = PriSpScpAmdtSmryVOs;
	}
    /**
     * @return the propNo
     */
    public String getPropNo () {
        return propNo;
    }
    /**
     * @param propNo the propNo to set
     */
    public void setPropNo (String propNo) {
        this.propNo = propNo;
    }	
	
	
}

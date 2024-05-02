/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseInfoMgtVO.java
*@FileTitle : ExpenseInfoMgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.04 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 */

public class ExpenseInfoMgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	@Override
	public HashMap<String, String> getColumnValues() {		
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {	
		return null;
	}
	
	
	private GemExpenseVO gemExpenseVO;
	
	private List<GemAcctExptVO> gemAcctExptVOs;
	private List<GemAcctMtxVO> gemAcctMtxVOs;

	public GemExpenseVO getGemExpenseVO() {
		return gemExpenseVO;
	}

	public void setGemExpenseVO(GemExpenseVO gemExpenseVO) {
		this.gemExpenseVO = gemExpenseVO;
	}

	public List<GemAcctExptVO> getGemAcctExptVOs() {
		return gemAcctExptVOs;
	}

	public void setGemAcctExptVOs(List<GemAcctExptVO> gemAcctExptVOs) {
		this.gemAcctExptVOs = gemAcctExptVOs;
	}

	public List<GemAcctMtxVO> getGemAcctMtxVOs() {
		return gemAcctMtxVOs;
	}

	public void setGemAcctMtxVOs(List<GemAcctMtxVO> gemAcctMtxVOs) {
		this.gemAcctMtxVOs = gemAcctMtxVOs;
	}
	
	
	
	

	
	
}

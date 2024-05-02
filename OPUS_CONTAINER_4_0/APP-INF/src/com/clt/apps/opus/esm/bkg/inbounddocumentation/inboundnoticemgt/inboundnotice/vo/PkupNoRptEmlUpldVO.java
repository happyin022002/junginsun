/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PkupNoRptEmlUpldVO.java
*@FileTitle : PkupNoRptEmlUpldVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class PkupNoRptEmlUpldVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	/* 철도 운송 회사 코드 */
	private String emlFrom = null;

	private PkupNoRptEmlCtntVO pkupNoRptEmlCtntVO = null;
	
	private PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs = null;
	
	
	public PkupNoRptEmlUpldVO() {}

	
	/**
	 * @param emlFrom the emlFrom to set
	 */
	public void setEmlFrom(String emlFrom) {
		this.emlFrom = emlFrom;
	}


	/**
	 * @return the emlFrom
	 */
	public String getEmlFrom() {
		return emlFrom;
	}


	/**
	 * @param pkupNoRptEmlCtntVO the pkupNoRptEmlCtntVO to set
	 */
	public void setPkupNoRptEmlCtntVO(PkupNoRptEmlCtntVO pkupNoRptEmlCtntVO) {
		this.pkupNoRptEmlCtntVO = pkupNoRptEmlCtntVO;
	}


	/**
	 * @return the pkupNoRptEmlCtntVO
	 */
	public PkupNoRptEmlCtntVO getPkupNoRptEmlCtntVO() {
		return pkupNoRptEmlCtntVO;
	}


	/**
	 * @param pkupNoRptEmlCtntVOs the pkupNoRptEmlCtntVOs to set
	 */
	public void setPkupNoRptEmlCtntVOs(PkupNoRptEmlCtntVO[] pkupNoRptEmlCtntVOs) {
		this.pkupNoRptEmlCtntVOs = pkupNoRptEmlCtntVOs;
	}


	/**
	 * @return the pkupNoRptEmlCtntVOs
	 */
	public PkupNoRptEmlCtntVO[] getPkupNoRptEmlCtntVOs() {
		return pkupNoRptEmlCtntVOs;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		return null;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return null;
	}
	
}

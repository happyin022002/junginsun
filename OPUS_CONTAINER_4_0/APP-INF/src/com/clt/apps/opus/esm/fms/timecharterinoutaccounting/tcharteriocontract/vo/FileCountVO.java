/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileCountVO.java
*@FileTitle :  FileUpload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.24
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0001HTMLAction
 */
 
public class FileCountVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private String cefFileCnt;
	private String cpfFileCnt;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public FileCountVO() {}
	
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCefFileCnt() {
		return cefFileCnt;
	}

	public void setCefFileCnt(String cefFileCnt) {
		this.cefFileCnt = cefFileCnt;
	}

	public String getCpfFileCnt() {
		return cpfFileCnt;
	}

	public void setCpfFileCnt(String cpfFileCnt) {
		this.cpfFileCnt = cpfFileCnt;
	}

}
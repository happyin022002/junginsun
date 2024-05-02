/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonComboSetVO.java
*@FileTitle : CommonComboSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.13 박광석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박광석
 * @since J2EE 1.6
 * @see ..
 */

public class CommonComboSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	
	/* Column Info */
	private String[] sPort = null;

	/* Column Info */
	private String[] sLane = null;

	/* Column Info */
	private String[] sTrade = null;

	/* Column Info */
	private String[] sTpsz = null;

	/* Column Info */
	private String[] sRcc = null;

	/* Column Info */
	private List<TypeSizeSequenceVO> typeSizeSequenceVO = null;

	




	public String[] getSPort() {
		return sPort;
	}


	public void setSPort(String[] port) {
		sPort = port;
	}


	public String[] getSLane() {
		return sLane;
	}


	public void setSLane(String[] lane) {
		sLane = lane;
	}


	public String[] getSTrade() {
		return sTrade;
	}


	public void setSTrade(String[] trade) {
		sTrade = trade;
	}


	public String[] getSTpsz() {
		return sTpsz;
	}


	public void setSTpsz(String[] tpsz) {
		sTpsz = tpsz;
	}


	public String[] getSRcc() {
		return sRcc;
	}


	public void setSRcc(String[] rcc) {
		sRcc = rcc;
	}


	public List<TypeSizeSequenceVO> getTypeSizeSequenceVO() {
		return typeSizeSequenceVO;
	}


	public void setTypeSizeSequenceVO(List<TypeSizeSequenceVO> typeSizeSequenceVO) {
		this.typeSizeSequenceVO = typeSizeSequenceVO;
	}


	public CommonComboSetVO() {}


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
	

}

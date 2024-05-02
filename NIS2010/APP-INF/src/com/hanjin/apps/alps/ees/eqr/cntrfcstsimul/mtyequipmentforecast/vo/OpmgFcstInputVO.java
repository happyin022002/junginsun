/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpmgFcstInputVO.java
*@FileTitle : OpmgFcstInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpmgFcstInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpmgFcstInputVO> models = new ArrayList<OpmgFcstInputVO>();
	
	/* Column Info */
	private String w9A4 = null;
	/* Column Info */
	private String w9A5 = null;	
	/* Column Info */
	private String w9A2 = null;
	/* Column Info */
	private String w5A4 = null;
	/* Column Info */
	private String w5A5 = null;
	/* Column Info */
	private String w5R2 = null;
	/* Column Info */
	private String w2F = null;
	/* Column Info */
	private String w1R5 = null;
	/* Column Info */
	private String w1R2 = null;
	/* Column Info */
	private String w8O4 = null;
	/* Column Info */
	private String w8O5 = null;
	/* Column Info */
	private String w8O2 = null;
	/* Column Info */
	private String w4O4 = null;
	/* Column Info */
	private String w8Ef = null;
	/* Column Info */
	private String w4O5 = null;
	/* Column Info */
	private String w4O2 = null;
	/* Column Info */
	private String w6S4 = null;
	/* Column Info */
	private String w5A2 = null;
	/* Column Info */
	private String w1A4 = null;
	/* Column Info */
	private String w1A5 = null;
	/* Column Info */
	private String w1A2 = null;
	/* Column Info */
	private String w9Wk = null;
	/* Column Info */
	private String w5Wk = null;
	/* Column Info */
	private String w7D7 = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String w7D4 = null;
	/* Column Info */
	private String w8F5 = null;
	/* Column Info */
	private String w7D5 = null;
	/* Column Info */
	private String mtyBalTpCd = null;
	/* Column Info */
	private String w4Ef = null;
	/* Column Info */
	private String w6S2 = null;
	/* Column Info */
	private String w2S4 = null;
	/* Column Info */
	private String w3F = null;
	/* Column Info */
	private String w2S2 = null;
	/* Column Info */
	private String w6R9 = null;
	/* Column Info */
	private String w2R9 = null;
	/* Column Info */
	private String w6R5 = null;
	/* Column Info */
	private String w1Wk = null;
	/* Column Info */
	private String w7D2 = null;
	/* Column Info */
	private String w3D7 = null;
	/* Column Info */
	private String w8F4 = null;
	/* Column Info */
	private String w3D4 = null;
	/* Column Info */
	private String w4F5 = null;
	/* Column Info */
	private String w3D5 = null;
	/* Column Info */
	private String w8F2 = null;
	/* Column Info */
	private String w3D2 = null;
	/* Column Info */
	private String w4F4 = null;
	/* Column Info */
	private String w4F2 = null;
	/* Column Info */
	private String w8A4 = null;
	/* Column Info */
	private String w8A5 = null;	
	/* Column Info */
	private String w8A2 = null;
	/* Column Info */
	private String w4A4 = null;
	/* Column Info */
	private String w4A5 = null;
	/* Column Info */
	private String w4F = null;
	/* Column Info */
	private String w4R2 = null;
	/* Column Info */
	private String w7O5 = null;
	/* Column Info */
	private String w7O4 = null;
	/* Column Info */
	private String w3O5 = null;
	/* Column Info */
	private String w7O2 = null;
	/* Column Info */
	private String w9S4 = null;
	/* Column Info */
	private String w3O4 = null;
	/* Column Info */
	private String w7Ef = null;
	/* Column Info */
	private String w9S2 = null;
	/* Column Info */
	private String w4A2 = null;
	/* Column Info */
	private String w8Wk = null;
	/* Column Info */
	private String w6D7 = null;
	/* Column Info */
	private String w6D5 = null;
	/* Column Info */
	private String w4Wk = null;
	/* Column Info */
	private String w3O2 = null;
	/* Column Info */
	private String w5F = null;
	/* Column Info */
	private String w5S4 = null;
	/* Column Info */
	private String w5S2 = null;
	/* Column Info */
	private String w1S4 = null;
	/* Column Info */
	private String w1S2 = null;
	/* Column Info */
	private String w5R9 = null;
	/* Column Info */
	private String w9R5 = null;
	/* Column Info */
	private String w9R2 = null;
	/* Column Info */
	private String w1R9 = null;
	/* Column Info */
	private String w5R5 = null;
	/* Column Info */
	private String w2D7 = null;
	/* Column Info */
	private String w7F4 = null;
	/* Column Info */
	private String w6D4 = null;
	/* Column Info */
	private String w7F5 = null;
	/* Column Info */
	private String w2D5 = null;
	/* Column Info */
	private String w7F2 = null;
	/* Column Info */
	private String w6D2 = null;
	/* Column Info */
	private String w3F4 = null;
	/* Column Info */
	private String w2D4 = null;
	/* Column Info */
	private String w3F5 = null;
	/* Column Info */
	private String w3F2 = null;
	/* Column Info */
	private String w2D2 = null;
	/* Column Info */
	private String w9R9 = null;
	/* Column Info */
	private String w7A4 = null;
	/* Column Info */
	private String w7A5 = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String w6F = null;
	/* Column Info */
	private String w7A2 = null;
	/* Column Info */
	private String w3R5 = null;
	/* Column Info */
	private String w3R2 = null;
	/* Column Info */
	private String w6O4 = null;
	/* Column Info */
	private String w6O5 = null;
	/* Column Info */
	private String w6O2 = null;
	/* Column Info */
	private String w8S4 = null;
	/* Column Info */
	private String w2O4 = null;
	/* Column Info */
	private String w6Ef = null;
	/* Column Info */
	private String w8S2 = null;
	/* Column Info */
	private String w2O5 = null;
	/* Column Info */
	private String w3A4 = null;
	/* Column Info */
	private String w3A5 = null;
	/* Column Info */
	private String w3A2 = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String w7Wk = null;
	/* Column Info */
	private String w9D7 = null;
	/* Column Info */
	private String w9D4 = null;
	/* Column Info */
	private String w9D5 = null;
	/* Column Info */
	private String w3Wk = null;
	/* Column Info */
	private String w9D2 = null;
	/* Column Info */
	private String w5D7 = null;
	/* Column Info */
	private String w7F = null;
	/* Column Info */
	private String w2O2 = null;
	/* Column Info */
	private String w4S4 = null;
	/* Column Info */
	private String w4S2 = null;
	/* Column Info */
	private String w2F2 = null;
	/* Column Info */
	private String w4R9 = null;
	/* Column Info */
	private String w8R5 = null;
	/* Column Info */
	private String w4R5 = null;
	/* Column Info */
	private String w8R2 = null;
	/* Column Info */
	private String w5D4 = null;
	/* Column Info */
	private String w6F5 = null;
	/* Column Info */
	private String w5D5 = null;
	/* Column Info */
	private String w5D2 = null;
	/* Column Info */
	private String w1D7 = null;
	/* Column Info */
	private String w6F4 = null;
	/* Column Info */
	private String w1D4 = null;
	/* Column Info */
	private String w2F5 = null;
	/* Column Info */
	private String w1D5 = null;
	/* Column Info */
	private String w6F2 = null;
	/* Column Info */
	private String w1D2 = null;
	/* Column Info */
	private String w8R9 = null;
	/* Column Info */
	private String w2F4 = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String w6A4 = null;
	/* Column Info */
	private String w6A5 = null;
	/* Column Info */
	private String w8F = null;
	/* Column Info */
	private String w6A2 = null;
	/* Column Info */
	private String w2R5 = null;
	/* Column Info */
	private String w6R2 = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String w2R2 = null;
	/* Column Info */
	private String w9O4 = null;
	/* Column Info */
	private String w5O5 = null;
	/* Column Info */
	private String w9O2 = null;
	/* Column Info */
	private String w5O4 = null;
	/* Column Info */
	private String w9Ef = null;
	/* Column Info */
	private String w1O5 = null;
	/* Column Info */
	private String w5O2 = null;
	/* Column Info */
	private String w7S4 = null;
	/* Column Info */
	private String w2A4 = null;
	/* Column Info */
	private String w2A5 = null;
	/* Column Info */
	private String w2A2 = null;
	/* Column Info */
	private String w9O5 = null;
	/* Column Info */
	private String w8D7 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String w8D5 = null;
	/* Column Info */
	private String w6Wk = null;
	/* Column Info */
	private String w9F = null;
	/* Column Info */
	private String w4D7 = null;
	/* Column Info */
	private String w9F4 = null;
	/* Column Info */
	private String w8D4 = null;
	/* Column Info */
	private String w9F5 = null;
	/* Column Info */
	private String w1O4 = null;
	/* Column Info */
	private String w5Ef = null;
	/* Column Info */
	private String w7S2 = null;
	/* Column Info */
	private String w1O2 = null;
	/* Column Info */
	private String w3S4 = null;
	/* Column Info */
	private String w1F = null;
	/* Column Info */
	private String w3S2 = null;
	/* Column Info */
	private String w1F2 = null;
	/* Column Info */
	private String w7R9 = null;
	/* Column Info */
	private String w3R9 = null;
	/* Column Info */
	private String w7R5 = null;
	/* Column Info */
	private String w7R2 = null;
	/* Column Info */
	private String w4D5 = null;
	/* Column Info */
	private String w9F2 = null;
	/* Column Info */
	private String w2Wk = null;
	/* Column Info */
	private String w8D2 = null;
	/* Column Info */
	private String w5F4 = null;
	/* Column Info */
	private String w4D4 = null;
	/* Column Info */
	private String w5F5 = null;
	/* Column Info */
	private String w5F2 = null;
	/* Column Info */
	private String w4D2 = null;
	/* Column Info */
	private String w1F4 = null;
	/* Column Info */
	private String w1F5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpmgFcstInputVO() {}

	public OpmgFcstInputVO(String ibflag, String pagerows, String dpSeq, String locCd, String locGrpCd, String mtyBalTpCd, String title, String w1A2, String w1A4, String w1A5, String w1D2, String w1D4, String w1D5, String w1D7, String w1F, String w1F2, String w1F4, String w1F5, String w1O2, String w1O4, String w1O5, String w1R2, String w1R5, String w1R9, String w1S2, String w1S4, String w1Wk, String w2A2, String w2A4, String w2A5, String w2D2, String w2D4, String w2D5, String w2D7, String w2F, String w2F2, String w2F4, String w2F5, String w2O2, String w2O4, String w2O5, String w2R2, String w2R5, String w2R9, String w2S2, String w2S4, String w2Wk, String w3A2, String w3A4, String w3A5, String w3D2, String w3D4, String w3D5, String w3D7, String w3F, String w3F2, String w3F4, String w3F5, String w3O2, String w3O4, String w3O5, String w3R2, String w3R5, String w3R9, String w3S2, String w3S4, String w3Wk, String w4A2, String w4A4, String w4A5, String w4D2, String w4D4, String w4D5, String w4D7, String w4Ef, String w4F, String w4F2, String w4F4, String w4F5, String w4O2, String w4O4, String w4O5, String w4R2, String w4R5, String w4R9, String w4S2, String w4S4, String w4Wk, String w5A2, String w5A4, String w5A5, String w5D2, String w5D4, String w5D5, String w5D7, String w5Ef, String w5F, String w5F2, String w5F4, String w5F5, String w5O2, String w5O4, String w5O5, String w5R2, String w5R5, String w5R9, String w5S2, String w5S4, String w5Wk, String w6A2, String w6A4, String w6A5, String w6D2, String w6D4, String w6D5, String w6D7, String w6Ef, String w6F, String w6F2, String w6F4, String w6F5, String w6O2, String w6O4, String w6O5, String w6R2, String w6R5, String w6R9, String w6S2, String w6S4, String w6Wk, String w7A2, String w7A4, String w7A5, String w7D2, String w7D4, String w7D5, String w7D7, String w7Ef, String w7F, String w7F2, String w7F4, String w7F5, String w7O2, String w7O4, String w7O5, String w7R2, String w7R5, String w7R9, String w7S2, String w7S4, String w7Wk, String w8A2, String w8A4, String w8A5, String w8D2, String w8D4, String w8D5, String w8D7, String w8Ef, String w8F, String w8F2, String w8F4, String w8F5, String w8O2, String w8O4, String w8O5, String w8R2, String w8R5, String w8R9, String w8S2, String w8S4, String w8Wk, String w9A2, String w9A4, String w9A5, String w9D2, String w9D4, String w9D5, String w9D7, String w9Ef, String w9F, String w9F2, String w9F4, String w9F5, String w9O2, String w9O4, String w9O5, String w9R2, String w9R5, String w9R9, String w9S2, String w9S4, String w9Wk) {
		this.w9A4 = w9A4;
		this.setW9A5(w9A5);
		this.w9A2 = w9A2;
		this.w5A4 = w5A4;
		this.w5A5 = w5A5;
		this.w5R2 = w5R2;
		this.w2F = w2F;
		this.w1R5 = w1R5;
		this.w1R2 = w1R2;
		this.w8O4 = w8O4;
		this.w8O5 = w8O5;
		this.w8O2 = w8O2;
		this.w4O4 = w4O4;
		this.w8Ef = w8Ef;
		this.w4O5 = w4O5;
		this.w4O2 = w4O2;
		this.w6S4 = w6S4;
		this.w5A2 = w5A2;
		this.w1A4 = w1A4;
		this.w1A5 = w1A5;
		this.w1A2 = w1A2;
		this.w9Wk = w9Wk;
		this.w5Wk = w5Wk;
		this.w7D7 = w7D7;
		this.locGrpCd = locGrpCd;
		this.w7D4 = w7D4;
		this.w8F5 = w8F5;
		this.w7D5 = w7D5;
		this.mtyBalTpCd = mtyBalTpCd;
		this.w4Ef = w4Ef;
		this.w6S2 = w6S2;
		this.w2S4 = w2S4;
		this.w3F = w3F;
		this.w2S2 = w2S2;
		this.w6R9 = w6R9;
		this.w2R9 = w2R9;
		this.w6R5 = w6R5;
		this.w1Wk = w1Wk;
		this.w7D2 = w7D2;
		this.w3D7 = w3D7;
		this.w8F4 = w8F4;
		this.w3D4 = w3D4;
		this.w4F5 = w4F5;
		this.w3D5 = w3D5;
		this.w8F2 = w8F2;
		this.w3D2 = w3D2;
		this.w4F4 = w4F4;
		this.w4F2 = w4F2;
		this.w8A4 = w8A4;
		this.w8A5 = w8A5;
		this.w8A2 = w8A2;
		this.w4A4 = w4A4;
		this.w4A5 = w4A5;
		this.w4F = w4F;
		this.w4R2 = w4R2;
		this.w7O5 = w7O5;
		this.w7O4 = w7O4;
		this.w3O5 = w3O5;
		this.w7O2 = w7O2;
		this.w9S4 = w9S4;
		this.w3O4 = w3O4;
		this.w7Ef = w7Ef;
		this.w9S2 = w9S2;
		this.w4A2 = w4A2;
		this.w8Wk = w8Wk;
		this.w6D7 = w6D7;
		this.w6D5 = w6D5;
		this.w4Wk = w4Wk;
		this.w3O2 = w3O2;
		this.w5F = w5F;
		this.w5S4 = w5S4;
		this.w5S2 = w5S2;
		this.w1S4 = w1S4;
		this.w1S2 = w1S2;
		this.w5R9 = w5R9;
		this.w9R5 = w9R5;
		this.w9R2 = w9R2;
		this.w1R9 = w1R9;
		this.w5R5 = w5R5;
		this.w2D7 = w2D7;
		this.w7F4 = w7F4;
		this.w6D4 = w6D4;
		this.w7F5 = w7F5;
		this.w2D5 = w2D5;
		this.w7F2 = w7F2;
		this.w6D2 = w6D2;
		this.w3F4 = w3F4;
		this.w2D4 = w2D4;
		this.w3F5 = w3F5;
		this.w3F2 = w3F2;
		this.w2D2 = w2D2;
		this.w9R9 = w9R9;
		this.w7A4 = w7A4;
		this.w7A5 = w7A5;
		this.dpSeq = dpSeq;
		this.w6F = w6F;
		this.w7A2 = w7A2;
		this.w3R5 = w3R5;
		this.w3R2 = w3R2;
		this.w6O4 = w6O4;
		this.w6O5 = w6O5;
		this.w6O2 = w6O2;
		this.w8S4 = w8S4;
		this.w2O4 = w2O4;
		this.w6Ef = w6Ef;
		this.w8S2 = w8S2;
		this.w2O5 = w2O5;
		this.w3A4 = w3A4;
		this.w3A5 = w3A5;
		this.w3A2 = w3A2;
		this.pagerows = pagerows;
		this.w7Wk = w7Wk;
		this.w9D7 = w9D7;
		this.w9D4 = w9D4;
		this.w9D5 = w9D5;
		this.w3Wk = w3Wk;
		this.w9D2 = w9D2;
		this.w5D7 = w5D7;
		this.w7F = w7F;
		this.w2O2 = w2O2;
		this.w4S4 = w4S4;
		this.w4S2 = w4S2;
		this.w2F2 = w2F2;
		this.w4R9 = w4R9;
		this.w8R5 = w8R5;
		this.w4R5 = w4R5;
		this.w8R2 = w8R2;
		this.w5D4 = w5D4;
		this.w6F5 = w6F5;
		this.w5D5 = w5D5;
		this.w5D2 = w5D2;
		this.w1D7 = w1D7;
		this.w6F4 = w6F4;
		this.w1D4 = w1D4;
		this.w2F5 = w2F5;
		this.w1D5 = w1D5;
		this.w6F2 = w6F2;
		this.w1D2 = w1D2;
		this.w8R9 = w8R9;
		this.w2F4 = w2F4;
		this.ibflag = ibflag;
		this.w6A4 = w6A4;
		this.w6A5 = w6A5;
		this.w8F = w8F;
		this.w6A2 = w6A2;
		this.w2R5 = w2R5;
		this.w6R2 = w6R2;
		this.title = title;
		this.w2R2 = w2R2;
		this.w9O4 = w9O4;
		this.w5O5 = w5O5;
		this.w9O2 = w9O2;
		this.w5O4 = w5O4;
		this.w9Ef = w9Ef;
		this.w1O5 = w1O5;
		this.w5O2 = w5O2;
		this.w7S4 = w7S4;
		this.w2A4 = w2A4;
		this.w2A5 = w2A5;
		this.w2A2 = w2A2;
		this.w9O5 = w9O5;
		this.w8D7 = w8D7;
		this.locCd = locCd;
		this.w8D5 = w8D5;
		this.w6Wk = w6Wk;
		this.w9F = w9F;
		this.w4D7 = w4D7;
		this.w9F4 = w9F4;
		this.w8D4 = w8D4;
		this.w9F5 = w9F5;
		this.w1O4 = w1O4;
		this.w5Ef = w5Ef;
		this.w7S2 = w7S2;
		this.w1O2 = w1O2;
		this.w3S4 = w3S4;
		this.w1F = w1F;
		this.w3S2 = w3S2;
		this.w1F2 = w1F2;
		this.w7R9 = w7R9;
		this.w3R9 = w3R9;
		this.w7R5 = w7R5;
		this.w7R2 = w7R2;
		this.w4D5 = w4D5;
		this.w9F2 = w9F2;
		this.w2Wk = w2Wk;
		this.w8D2 = w8D2;
		this.w5F4 = w5F4;
		this.w4D4 = w4D4;
		this.w5F5 = w5F5;
		this.w5F2 = w5F2;
		this.w4D2 = w4D2;
		this.w1F4 = w1F4;
		this.w1F5 = w1F5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("w9_a4", getW9A4());
		this.hashColumns.put("w9_a5", getW9A5());
		this.hashColumns.put("w9_a2", getW9A2());
		this.hashColumns.put("w5_a4", getW5A4());
		this.hashColumns.put("w5_a5", getW5A5());
		this.hashColumns.put("w5_r2", getW5R2());
		this.hashColumns.put("w2_f", getW2F());
		this.hashColumns.put("w1_r5", getW1R5());
		this.hashColumns.put("w1_r2", getW1R2());
		this.hashColumns.put("w8_o4", getW8O4());
		this.hashColumns.put("w8_o5", getW8O5());
		this.hashColumns.put("w8_o2", getW8O2());
		this.hashColumns.put("w4_o4", getW4O4());
		this.hashColumns.put("w8_ef", getW8Ef());
		this.hashColumns.put("w4_o5", getW4O5());
		this.hashColumns.put("w4_o2", getW4O2());
		this.hashColumns.put("w6_s4", getW6S4());
		this.hashColumns.put("w5_a2", getW5A2());
		this.hashColumns.put("w1_a4", getW1A4());
		this.hashColumns.put("w1_a5", getW1A5());
		this.hashColumns.put("w1_a2", getW1A2());
		this.hashColumns.put("w9_wk", getW9Wk());
		this.hashColumns.put("w5_wk", getW5Wk());
		this.hashColumns.put("w7_d7", getW7D7());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("w7_d4", getW7D4());
		this.hashColumns.put("w8_f5", getW8F5());
		this.hashColumns.put("w7_d5", getW7D5());
		this.hashColumns.put("mty_bal_tp_cd", getMtyBalTpCd());
		this.hashColumns.put("w4_ef", getW4Ef());
		this.hashColumns.put("w6_s2", getW6S2());
		this.hashColumns.put("w2_s4", getW2S4());
		this.hashColumns.put("w3_f", getW3F());
		this.hashColumns.put("w2_s2", getW2S2());
		this.hashColumns.put("w6_r9", getW6R9());
		this.hashColumns.put("w2_r9", getW2R9());
		this.hashColumns.put("w6_r5", getW6R5());
		this.hashColumns.put("w1_wk", getW1Wk());
		this.hashColumns.put("w7_d2", getW7D2());
		this.hashColumns.put("w3_d7", getW3D7());
		this.hashColumns.put("w8_f4", getW8F4());
		this.hashColumns.put("w3_d4", getW3D4());
		this.hashColumns.put("w4_f5", getW4F5());
		this.hashColumns.put("w3_d5", getW3D5());
		this.hashColumns.put("w8_f2", getW8F2());
		this.hashColumns.put("w3_d2", getW3D2());
		this.hashColumns.put("w4_f4", getW4F4());
		this.hashColumns.put("w4_f2", getW4F2());
		this.hashColumns.put("w8_a4", getW8A4());
		this.hashColumns.put("w8_a5", getW8A5());
		this.hashColumns.put("w8_a2", getW8A2());
		this.hashColumns.put("w4_a4", getW4A4());
		this.hashColumns.put("w4_a5", getW4A5());
		this.hashColumns.put("w4_f", getW4F());
		this.hashColumns.put("w4_r2", getW4R2());
		this.hashColumns.put("w7_o5", getW7O5());
		this.hashColumns.put("w7_o4", getW7O4());
		this.hashColumns.put("w3_o5", getW3O5());
		this.hashColumns.put("w7_o2", getW7O2());
		this.hashColumns.put("w9_s4", getW9S4());
		this.hashColumns.put("w3_o4", getW3O4());
		this.hashColumns.put("w7_ef", getW7Ef());
		this.hashColumns.put("w9_s2", getW9S2());
		this.hashColumns.put("w4_a2", getW4A2());
		this.hashColumns.put("w8_wk", getW8Wk());
		this.hashColumns.put("w6_d7", getW6D7());
		this.hashColumns.put("w6_d5", getW6D5());
		this.hashColumns.put("w4_wk", getW4Wk());
		this.hashColumns.put("w3_o2", getW3O2());
		this.hashColumns.put("w5_f", getW5F());
		this.hashColumns.put("w5_s4", getW5S4());
		this.hashColumns.put("w5_s2", getW5S2());
		this.hashColumns.put("w1_s4", getW1S4());
		this.hashColumns.put("w1_s2", getW1S2());
		this.hashColumns.put("w5_r9", getW5R9());
		this.hashColumns.put("w9_r5", getW9R5());
		this.hashColumns.put("w9_r2", getW9R2());
		this.hashColumns.put("w1_r9", getW1R9());
		this.hashColumns.put("w5_r5", getW5R5());
		this.hashColumns.put("w2_d7", getW2D7());
		this.hashColumns.put("w7_f4", getW7F4());
		this.hashColumns.put("w6_d4", getW6D4());
		this.hashColumns.put("w7_f5", getW7F5());
		this.hashColumns.put("w2_d5", getW2D5());
		this.hashColumns.put("w7_f2", getW7F2());
		this.hashColumns.put("w6_d2", getW6D2());
		this.hashColumns.put("w3_f4", getW3F4());
		this.hashColumns.put("w2_d4", getW2D4());
		this.hashColumns.put("w3_f5", getW3F5());
		this.hashColumns.put("w3_f2", getW3F2());
		this.hashColumns.put("w2_d2", getW2D2());
		this.hashColumns.put("w9_r9", getW9R9());
		this.hashColumns.put("w7_a4", getW7A4());
		this.hashColumns.put("w7_a5", getW7A5());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("w6_f", getW6F());
		this.hashColumns.put("w7_a2", getW7A2());
		this.hashColumns.put("w3_r5", getW3R5());
		this.hashColumns.put("w3_r2", getW3R2());
		this.hashColumns.put("w6_o4", getW6O4());
		this.hashColumns.put("w6_o5", getW6O5());
		this.hashColumns.put("w6_o2", getW6O2());
		this.hashColumns.put("w8_s4", getW8S4());
		this.hashColumns.put("w2_o4", getW2O4());
		this.hashColumns.put("w6_ef", getW6Ef());
		this.hashColumns.put("w8_s2", getW8S2());
		this.hashColumns.put("w2_o5", getW2O5());
		this.hashColumns.put("w3_a4", getW3A4());
		this.hashColumns.put("w3_a5", getW3A5());
		this.hashColumns.put("w3_a2", getW3A2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("w7_wk", getW7Wk());
		this.hashColumns.put("w9_d7", getW9D7());
		this.hashColumns.put("w9_d4", getW9D4());
		this.hashColumns.put("w9_d5", getW9D5());
		this.hashColumns.put("w3_wk", getW3Wk());
		this.hashColumns.put("w9_d2", getW9D2());
		this.hashColumns.put("w5_d7", getW5D7());
		this.hashColumns.put("w7_f", getW7F());
		this.hashColumns.put("w2_o2", getW2O2());
		this.hashColumns.put("w4_s4", getW4S4());
		this.hashColumns.put("w4_s2", getW4S2());
		this.hashColumns.put("w2_f2", getW2F2());
		this.hashColumns.put("w4_r9", getW4R9());
		this.hashColumns.put("w8_r5", getW8R5());
		this.hashColumns.put("w4_r5", getW4R5());
		this.hashColumns.put("w8_r2", getW8R2());
		this.hashColumns.put("w5_d4", getW5D4());
		this.hashColumns.put("w6_f5", getW6F5());
		this.hashColumns.put("w5_d5", getW5D5());
		this.hashColumns.put("w5_d2", getW5D2());
		this.hashColumns.put("w1_d7", getW1D7());
		this.hashColumns.put("w6_f4", getW6F4());
		this.hashColumns.put("w1_d4", getW1D4());
		this.hashColumns.put("w2_f5", getW2F5());
		this.hashColumns.put("w1_d5", getW1D5());
		this.hashColumns.put("w6_f2", getW6F2());
		this.hashColumns.put("w1_d2", getW1D2());
		this.hashColumns.put("w8_r9", getW8R9());
		this.hashColumns.put("w2_f4", getW2F4());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("w6_a4", getW6A4());
		this.hashColumns.put("w6_a5", getW6A5());
		this.hashColumns.put("w8_f", getW8F());
		this.hashColumns.put("w6_a2", getW6A2());
		this.hashColumns.put("w2_r5", getW2R5());
		this.hashColumns.put("w6_r2", getW6R2());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("w2_r2", getW2R2());
		this.hashColumns.put("w9_o4", getW9O4());
		this.hashColumns.put("w5_o5", getW5O5());
		this.hashColumns.put("w9_o2", getW9O2());
		this.hashColumns.put("w5_o4", getW5O4());
		this.hashColumns.put("w9_ef", getW9Ef());
		this.hashColumns.put("w1_o5", getW1O5());
		this.hashColumns.put("w5_o2", getW5O2());
		this.hashColumns.put("w7_s4", getW7S4());
		this.hashColumns.put("w2_a4", getW2A4());
		this.hashColumns.put("w2_a5", getW2A5());
		this.hashColumns.put("w2_a2", getW2A2());
		this.hashColumns.put("w9_o5", getW9O5());
		this.hashColumns.put("w8_d7", getW8D7());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("w8_d5", getW8D5());
		this.hashColumns.put("w6_wk", getW6Wk());
		this.hashColumns.put("w9_f", getW9F());
		this.hashColumns.put("w4_d7", getW4D7());
		this.hashColumns.put("w9_f4", getW9F4());
		this.hashColumns.put("w8_d4", getW8D4());
		this.hashColumns.put("w9_f5", getW9F5());
		this.hashColumns.put("w1_o4", getW1O4());
		this.hashColumns.put("w5_ef", getW5Ef());
		this.hashColumns.put("w7_s2", getW7S2());
		this.hashColumns.put("w1_o2", getW1O2());
		this.hashColumns.put("w3_s4", getW3S4());
		this.hashColumns.put("w1_f", getW1F());
		this.hashColumns.put("w3_s2", getW3S2());
		this.hashColumns.put("w1_f2", getW1F2());
		this.hashColumns.put("w7_r9", getW7R9());
		this.hashColumns.put("w3_r9", getW3R9());
		this.hashColumns.put("w7_r5", getW7R5());
		this.hashColumns.put("w7_r2", getW7R2());
		this.hashColumns.put("w4_d5", getW4D5());
		this.hashColumns.put("w9_f2", getW9F2());
		this.hashColumns.put("w2_wk", getW2Wk());
		this.hashColumns.put("w8_d2", getW8D2());
		this.hashColumns.put("w5_f4", getW5F4());
		this.hashColumns.put("w4_d4", getW4D4());
		this.hashColumns.put("w5_f5", getW5F5());
		this.hashColumns.put("w5_f2", getW5F2());
		this.hashColumns.put("w4_d2", getW4D2());
		this.hashColumns.put("w1_f4", getW1F4());
		this.hashColumns.put("w1_f5", getW1F5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("w9_a4", "w9A4");
		this.hashFields.put("w9_a5", "w9A5");
		this.hashFields.put("w9_a2", "w9A2");
		this.hashFields.put("w5_a4", "w5A4");
		this.hashFields.put("w5_a5", "w5A5");
		this.hashFields.put("w5_r2", "w5R2");
		this.hashFields.put("w2_f", "w2F");
		this.hashFields.put("w1_r5", "w1R5");
		this.hashFields.put("w1_r2", "w1R2");
		this.hashFields.put("w8_o4", "w8O4");
		this.hashFields.put("w8_o5", "w8O5");
		this.hashFields.put("w8_o2", "w8O2");
		this.hashFields.put("w4_o4", "w4O4");
		this.hashFields.put("w8_ef", "w8Ef");
		this.hashFields.put("w4_o5", "w4O5");
		this.hashFields.put("w4_o2", "w4O2");
		this.hashFields.put("w6_s4", "w6S4");
		this.hashFields.put("w5_a2", "w5A2");
		this.hashFields.put("w1_a4", "w1A4");
		this.hashFields.put("w1_a5", "w1A5");
		this.hashFields.put("w1_a2", "w1A2");
		this.hashFields.put("w9_wk", "w9Wk");
		this.hashFields.put("w5_wk", "w5Wk");
		this.hashFields.put("w7_d7", "w7D7");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("w7_d4", "w7D4");
		this.hashFields.put("w8_f5", "w8F5");
		this.hashFields.put("w7_d5", "w7D5");
		this.hashFields.put("mty_bal_tp_cd", "mtyBalTpCd");
		this.hashFields.put("w4_ef", "w4Ef");
		this.hashFields.put("w6_s2", "w6S2");
		this.hashFields.put("w2_s4", "w2S4");
		this.hashFields.put("w3_f", "w3F");
		this.hashFields.put("w2_s2", "w2S2");
		this.hashFields.put("w6_r9", "w6R9");
		this.hashFields.put("w2_r9", "w2R9");
		this.hashFields.put("w6_r5", "w6R5");
		this.hashFields.put("w1_wk", "w1Wk");
		this.hashFields.put("w7_d2", "w7D2");
		this.hashFields.put("w3_d7", "w3D7");
		this.hashFields.put("w8_f4", "w8F4");
		this.hashFields.put("w3_d4", "w3D4");
		this.hashFields.put("w4_f5", "w4F5");
		this.hashFields.put("w3_d5", "w3D5");
		this.hashFields.put("w8_f2", "w8F2");
		this.hashFields.put("w3_d2", "w3D2");
		this.hashFields.put("w4_f4", "w4F4");
		this.hashFields.put("w4_f2", "w4F2");
		this.hashFields.put("w8_a4", "w8A4");
		this.hashFields.put("w8_a5", "w8A5");
		this.hashFields.put("w8_a2", "w8A2");
		this.hashFields.put("w4_a4", "w4A4");
		this.hashFields.put("w4_a5", "w4A5");
		this.hashFields.put("w4_f", "w4F");
		this.hashFields.put("w4_r2", "w4R2");
		this.hashFields.put("w7_o5", "w7O5");
		this.hashFields.put("w7_o4", "w7O4");
		this.hashFields.put("w3_o5", "w3O5");
		this.hashFields.put("w7_o2", "w7O2");
		this.hashFields.put("w9_s4", "w9S4");
		this.hashFields.put("w3_o4", "w3O4");
		this.hashFields.put("w7_ef", "w7Ef");
		this.hashFields.put("w9_s2", "w9S2");
		this.hashFields.put("w4_a2", "w4A2");
		this.hashFields.put("w8_wk", "w8Wk");
		this.hashFields.put("w6_d7", "w6D7");
		this.hashFields.put("w6_d5", "w6D5");
		this.hashFields.put("w4_wk", "w4Wk");
		this.hashFields.put("w3_o2", "w3O2");
		this.hashFields.put("w5_f", "w5F");
		this.hashFields.put("w5_s4", "w5S4");
		this.hashFields.put("w5_s2", "w5S2");
		this.hashFields.put("w1_s4", "w1S4");
		this.hashFields.put("w1_s2", "w1S2");
		this.hashFields.put("w5_r9", "w5R9");
		this.hashFields.put("w9_r5", "w9R5");
		this.hashFields.put("w9_r2", "w9R2");
		this.hashFields.put("w1_r9", "w1R9");
		this.hashFields.put("w5_r5", "w5R5");
		this.hashFields.put("w2_d7", "w2D7");
		this.hashFields.put("w7_f4", "w7F4");
		this.hashFields.put("w6_d4", "w6D4");
		this.hashFields.put("w7_f5", "w7F5");
		this.hashFields.put("w2_d5", "w2D5");
		this.hashFields.put("w7_f2", "w7F2");
		this.hashFields.put("w6_d2", "w6D2");
		this.hashFields.put("w3_f4", "w3F4");
		this.hashFields.put("w2_d4", "w2D4");
		this.hashFields.put("w3_f5", "w3F5");
		this.hashFields.put("w3_f2", "w3F2");
		this.hashFields.put("w2_d2", "w2D2");
		this.hashFields.put("w9_r9", "w9R9");
		this.hashFields.put("w7_a4", "w7A4");
		this.hashFields.put("w7_a5", "w7A5");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("w6_f", "w6F");
		this.hashFields.put("w7_a2", "w7A2");
		this.hashFields.put("w3_r5", "w3R5");
		this.hashFields.put("w3_r2", "w3R2");
		this.hashFields.put("w6_o4", "w6O4");
		this.hashFields.put("w6_o5", "w6O5");
		this.hashFields.put("w6_o2", "w6O2");
		this.hashFields.put("w8_s4", "w8S4");
		this.hashFields.put("w2_o4", "w2O4");
		this.hashFields.put("w6_ef", "w6Ef");
		this.hashFields.put("w8_s2", "w8S2");
		this.hashFields.put("w2_o5", "w2O5");
		this.hashFields.put("w3_a4", "w3A4");
		this.hashFields.put("w3_a5", "w3A5");
		this.hashFields.put("w3_a2", "w3A2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("w7_wk", "w7Wk");
		this.hashFields.put("w9_d7", "w9D7");
		this.hashFields.put("w9_d4", "w9D4");
		this.hashFields.put("w9_d5", "w9D5");
		this.hashFields.put("w3_wk", "w3Wk");
		this.hashFields.put("w9_d2", "w9D2");
		this.hashFields.put("w5_d7", "w5D7");
		this.hashFields.put("w7_f", "w7F");
		this.hashFields.put("w2_o2", "w2O2");
		this.hashFields.put("w4_s4", "w4S4");
		this.hashFields.put("w4_s2", "w4S2");
		this.hashFields.put("w2_f2", "w2F2");
		this.hashFields.put("w4_r9", "w4R9");
		this.hashFields.put("w8_r5", "w8R5");
		this.hashFields.put("w4_r5", "w4R5");
		this.hashFields.put("w8_r2", "w8R2");
		this.hashFields.put("w5_d4", "w5D4");
		this.hashFields.put("w6_f5", "w6F5");
		this.hashFields.put("w5_d5", "w5D5");
		this.hashFields.put("w5_d2", "w5D2");
		this.hashFields.put("w1_d7", "w1D7");
		this.hashFields.put("w6_f4", "w6F4");
		this.hashFields.put("w1_d4", "w1D4");
		this.hashFields.put("w2_f5", "w2F5");
		this.hashFields.put("w1_d5", "w1D5");
		this.hashFields.put("w6_f2", "w6F2");
		this.hashFields.put("w1_d2", "w1D2");
		this.hashFields.put("w8_r9", "w8R9");
		this.hashFields.put("w2_f4", "w2F4");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("w6_a4", "w6A4");
		this.hashFields.put("w6_a5", "w6A5");
		this.hashFields.put("w8_f", "w8F");
		this.hashFields.put("w6_a2", "w6A2");
		this.hashFields.put("w2_r5", "w2R5");
		this.hashFields.put("w6_r2", "w6R2");
		this.hashFields.put("title", "title");
		this.hashFields.put("w2_r2", "w2R2");
		this.hashFields.put("w9_o4", "w9O4");
		this.hashFields.put("w5_o5", "w5O5");
		this.hashFields.put("w9_o2", "w9O2");
		this.hashFields.put("w5_o4", "w5O4");
		this.hashFields.put("w9_ef", "w9Ef");
		this.hashFields.put("w1_o5", "w1O5");
		this.hashFields.put("w5_o2", "w5O2");
		this.hashFields.put("w7_s4", "w7S4");
		this.hashFields.put("w2_a4", "w2A4");
		this.hashFields.put("w2_a5", "w2A5");
		this.hashFields.put("w2_a2", "w2A2");
		this.hashFields.put("w9_o5", "w9O5");
		this.hashFields.put("w8_d7", "w8D7");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("w8_d5", "w8D5");
		this.hashFields.put("w6_wk", "w6Wk");
		this.hashFields.put("w9_f", "w9F");
		this.hashFields.put("w4_d7", "w4D7");
		this.hashFields.put("w9_f4", "w9F4");
		this.hashFields.put("w8_d4", "w8D4");
		this.hashFields.put("w9_f5", "w9F5");
		this.hashFields.put("w1_o4", "w1O4");
		this.hashFields.put("w5_ef", "w5Ef");
		this.hashFields.put("w7_s2", "w7S2");
		this.hashFields.put("w1_o2", "w1O2");
		this.hashFields.put("w3_s4", "w3S4");
		this.hashFields.put("w1_f", "w1F");
		this.hashFields.put("w3_s2", "w3S2");
		this.hashFields.put("w1_f2", "w1F2");
		this.hashFields.put("w7_r9", "w7R9");
		this.hashFields.put("w3_r9", "w3R9");
		this.hashFields.put("w7_r5", "w7R5");
		this.hashFields.put("w7_r2", "w7R2");
		this.hashFields.put("w4_d5", "w4D5");
		this.hashFields.put("w9_f2", "w9F2");
		this.hashFields.put("w2_wk", "w2Wk");
		this.hashFields.put("w8_d2", "w8D2");
		this.hashFields.put("w5_f4", "w5F4");
		this.hashFields.put("w4_d4", "w4D4");
		this.hashFields.put("w5_f5", "w5F5");
		this.hashFields.put("w5_f2", "w5F2");
		this.hashFields.put("w4_d2", "w4D2");
		this.hashFields.put("w1_f4", "w1F4");
		this.hashFields.put("w1_f5", "w1F5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return w9A4
	 */
	public String getW9A4() {
		return this.w9A4;
	}
	
	/**
	 * Column Info
	 * @return w9A2
	 */
	public String getW9A2() {
		return this.w9A2;
	}
	
	/**
	 * Column Info
	 * @return w5A4
	 */
	public String getW5A4() {
		return this.w5A4;
	}
	
	/**
	 * Column Info
	 * @return w5R2
	 */
	public String getW5R2() {
		return this.w5R2;
	}
	
	/**
	 * Column Info
	 * @return w2F
	 */
	public String getW2F() {
		return this.w2F;
	}
	
	/**
	 * Column Info
	 * @return w1R5
	 */
	public String getW1R5() {
		return this.w1R5;
	}
	
	/**
	 * Column Info
	 * @return w1R2
	 */
	public String getW1R2() {
		return this.w1R2;
	}
	
	/**
	 * Column Info
	 * @return w8O4
	 */
	public String getW8O4() {
		return this.w8O4;
	}
	
	/**
	 * Column Info
	 * @return w8O5
	 */
	public String getW8O5() {
		return this.w8O5;
	}
	
	/**
	 * Column Info
	 * @return w8O2
	 */
	public String getW8O2() {
		return this.w8O2;
	}
	
	/**
	 * Column Info
	 * @return w4O4
	 */
	public String getW4O4() {
		return this.w4O4;
	}
	
	/**
	 * Column Info
	 * @return w8Ef
	 */
	public String getW8Ef() {
		return this.w8Ef;
	}
	
	/**
	 * Column Info
	 * @return w4O5
	 */
	public String getW4O5() {
		return this.w4O5;
	}
	
	/**
	 * Column Info
	 * @return w4O2
	 */
	public String getW4O2() {
		return this.w4O2;
	}
	
	/**
	 * Column Info
	 * @return w6S4
	 */
	public String getW6S4() {
		return this.w6S4;
	}
	
	/**
	 * Column Info
	 * @return w5A2
	 */
	public String getW5A2() {
		return this.w5A2;
	}
	
	/**
	 * Column Info
	 * @return w1A4
	 */
	public String getW1A4() {
		return this.w1A4;
	}
	
	/**
	 * Column Info
	 * @return w1A2
	 */
	public String getW1A2() {
		return this.w1A2;
	}
	
	/**
	 * Column Info
	 * @return w9Wk
	 */
	public String getW9Wk() {
		return this.w9Wk;
	}
	
	/**
	 * Column Info
	 * @return w5Wk
	 */
	public String getW5Wk() {
		return this.w5Wk;
	}
	
	/**
	 * Column Info
	 * @return w7D7
	 */
	public String getW7D7() {
		return this.w7D7;
	}
	
	/**
	 * Column Info
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
	}
	
	/**
	 * Column Info
	 * @return w7D4
	 */
	public String getW7D4() {
		return this.w7D4;
	}
	
	/**
	 * Column Info
	 * @return w8F5
	 */
	public String getW8F5() {
		return this.w8F5;
	}
	
	/**
	 * Column Info
	 * @return w7D5
	 */
	public String getW7D5() {
		return this.w7D5;
	}
	
	/**
	 * Column Info
	 * @return mtyBalTpCd
	 */
	public String getMtyBalTpCd() {
		return this.mtyBalTpCd;
	}
	
	/**
	 * Column Info
	 * @return w4Ef
	 */
	public String getW4Ef() {
		return this.w4Ef;
	}
	
	/**
	 * Column Info
	 * @return w6S2
	 */
	public String getW6S2() {
		return this.w6S2;
	}
	
	/**
	 * Column Info
	 * @return w2S4
	 */
	public String getW2S4() {
		return this.w2S4;
	}
	
	/**
	 * Column Info
	 * @return w3F
	 */
	public String getW3F() {
		return this.w3F;
	}
	
	/**
	 * Column Info
	 * @return w2S2
	 */
	public String getW2S2() {
		return this.w2S2;
	}
	
	/**
	 * Column Info
	 * @return w6R9
	 */
	public String getW6R9() {
		return this.w6R9;
	}
	
	/**
	 * Column Info
	 * @return w2R9
	 */
	public String getW2R9() {
		return this.w2R9;
	}
	
	/**
	 * Column Info
	 * @return w6R5
	 */
	public String getW6R5() {
		return this.w6R5;
	}
	
	/**
	 * Column Info
	 * @return w1Wk
	 */
	public String getW1Wk() {
		return this.w1Wk;
	}
	
	/**
	 * Column Info
	 * @return w7D2
	 */
	public String getW7D2() {
		return this.w7D2;
	}
	
	/**
	 * Column Info
	 * @return w3D7
	 */
	public String getW3D7() {
		return this.w3D7;
	}
	
	/**
	 * Column Info
	 * @return w8F4
	 */
	public String getW8F4() {
		return this.w8F4;
	}
	
	/**
	 * Column Info
	 * @return w3D4
	 */
	public String getW3D4() {
		return this.w3D4;
	}
	
	/**
	 * Column Info
	 * @return w4F5
	 */
	public String getW4F5() {
		return this.w4F5;
	}
	
	/**
	 * Column Info
	 * @return w3D5
	 */
	public String getW3D5() {
		return this.w3D5;
	}
	
	/**
	 * Column Info
	 * @return w8F2
	 */
	public String getW8F2() {
		return this.w8F2;
	}
	
	/**
	 * Column Info
	 * @return w3D2
	 */
	public String getW3D2() {
		return this.w3D2;
	}
	
	/**
	 * Column Info
	 * @return w4F4
	 */
	public String getW4F4() {
		return this.w4F4;
	}
	
	/**
	 * Column Info
	 * @return w4F2
	 */
	public String getW4F2() {
		return this.w4F2;
	}
	
	/**
	 * Column Info
	 * @return w8A4
	 */
	public String getW8A4() {
		return this.w8A4;
	}
	
	/**
	 * Column Info
	 * @return w8A2
	 */
	public String getW8A2() {
		return this.w8A2;
	}
	
	/**
	 * Column Info
	 * @return w4A4
	 */
	public String getW4A4() {
		return this.w4A4;
	}
	
	/**
	 * Column Info
	 * @return w4F
	 */
	public String getW4F() {
		return this.w4F;
	}
	
	/**
	 * Column Info
	 * @return w4R2
	 */
	public String getW4R2() {
		return this.w4R2;
	}
	
	/**
	 * Column Info
	 * @return w7O5
	 */
	public String getW7O5() {
		return this.w7O5;
	}
	
	/**
	 * Column Info
	 * @return w7O4
	 */
	public String getW7O4() {
		return this.w7O4;
	}
	
	/**
	 * Column Info
	 * @return w3O5
	 */
	public String getW3O5() {
		return this.w3O5;
	}
	
	/**
	 * Column Info
	 * @return w7O2
	 */
	public String getW7O2() {
		return this.w7O2;
	}
	
	/**
	 * Column Info
	 * @return w9S4
	 */
	public String getW9S4() {
		return this.w9S4;
	}
	
	/**
	 * Column Info
	 * @return w3O4
	 */
	public String getW3O4() {
		return this.w3O4;
	}
	
	/**
	 * Column Info
	 * @return w7Ef
	 */
	public String getW7Ef() {
		return this.w7Ef;
	}
	
	/**
	 * Column Info
	 * @return w9S2
	 */
	public String getW9S2() {
		return this.w9S2;
	}
	
	/**
	 * Column Info
	 * @return w4A2
	 */
	public String getW4A2() {
		return this.w4A2;
	}
	
	/**
	 * Column Info
	 * @return w8Wk
	 */
	public String getW8Wk() {
		return this.w8Wk;
	}
	
	/**
	 * Column Info
	 * @return w6D7
	 */
	public String getW6D7() {
		return this.w6D7;
	}
	
	/**
	 * Column Info
	 * @return w6D5
	 */
	public String getW6D5() {
		return this.w6D5;
	}
	
	/**
	 * Column Info
	 * @return w4Wk
	 */
	public String getW4Wk() {
		return this.w4Wk;
	}
	
	/**
	 * Column Info
	 * @return w3O2
	 */
	public String getW3O2() {
		return this.w3O2;
	}
	
	/**
	 * Column Info
	 * @return w5F
	 */
	public String getW5F() {
		return this.w5F;
	}
	
	/**
	 * Column Info
	 * @return w5S4
	 */
	public String getW5S4() {
		return this.w5S4;
	}
	
	/**
	 * Column Info
	 * @return w5S2
	 */
	public String getW5S2() {
		return this.w5S2;
	}
	
	/**
	 * Column Info
	 * @return w1S4
	 */
	public String getW1S4() {
		return this.w1S4;
	}
	
	/**
	 * Column Info
	 * @return w1S2
	 */
	public String getW1S2() {
		return this.w1S2;
	}
	
	/**
	 * Column Info
	 * @return w5R9
	 */
	public String getW5R9() {
		return this.w5R9;
	}
	
	/**
	 * Column Info
	 * @return w9R5
	 */
	public String getW9R5() {
		return this.w9R5;
	}
	
	/**
	 * Column Info
	 * @return w9R2
	 */
	public String getW9R2() {
		return this.w9R2;
	}
	
	/**
	 * Column Info
	 * @return w1R9
	 */
	public String getW1R9() {
		return this.w1R9;
	}
	
	/**
	 * Column Info
	 * @return w5R5
	 */
	public String getW5R5() {
		return this.w5R5;
	}
	
	/**
	 * Column Info
	 * @return w2D7
	 */
	public String getW2D7() {
		return this.w2D7;
	}
	
	/**
	 * Column Info
	 * @return w7F4
	 */
	public String getW7F4() {
		return this.w7F4;
	}
	
	/**
	 * Column Info
	 * @return w6D4
	 */
	public String getW6D4() {
		return this.w6D4;
	}
	
	/**
	 * Column Info
	 * @return w7F5
	 */
	public String getW7F5() {
		return this.w7F5;
	}
	
	/**
	 * Column Info
	 * @return w2D5
	 */
	public String getW2D5() {
		return this.w2D5;
	}
	
	/**
	 * Column Info
	 * @return w7F2
	 */
	public String getW7F2() {
		return this.w7F2;
	}
	
	/**
	 * Column Info
	 * @return w6D2
	 */
	public String getW6D2() {
		return this.w6D2;
	}
	
	/**
	 * Column Info
	 * @return w3F4
	 */
	public String getW3F4() {
		return this.w3F4;
	}
	
	/**
	 * Column Info
	 * @return w2D4
	 */
	public String getW2D4() {
		return this.w2D4;
	}
	
	/**
	 * Column Info
	 * @return w3F5
	 */
	public String getW3F5() {
		return this.w3F5;
	}
	
	/**
	 * Column Info
	 * @return w3F2
	 */
	public String getW3F2() {
		return this.w3F2;
	}
	
	/**
	 * Column Info
	 * @return w2D2
	 */
	public String getW2D2() {
		return this.w2D2;
	}
	
	/**
	 * Column Info
	 * @return w9R9
	 */
	public String getW9R9() {
		return this.w9R9;
	}
	
	/**
	 * Column Info
	 * @return w7A4
	 */
	public String getW7A4() {
		return this.w7A4;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return w6F
	 */
	public String getW6F() {
		return this.w6F;
	}
	
	/**
	 * Column Info
	 * @return w7A2
	 */
	public String getW7A2() {
		return this.w7A2;
	}
	
	/**
	 * Column Info
	 * @return w3R5
	 */
	public String getW3R5() {
		return this.w3R5;
	}
	
	/**
	 * Column Info
	 * @return w3R2
	 */
	public String getW3R2() {
		return this.w3R2;
	}
	
	/**
	 * Column Info
	 * @return w6O4
	 */
	public String getW6O4() {
		return this.w6O4;
	}
	
	/**
	 * Column Info
	 * @return w6O5
	 */
	public String getW6O5() {
		return this.w6O5;
	}
	
	/**
	 * Column Info
	 * @return w6O2
	 */
	public String getW6O2() {
		return this.w6O2;
	}
	
	/**
	 * Column Info
	 * @return w8S4
	 */
	public String getW8S4() {
		return this.w8S4;
	}
	
	/**
	 * Column Info
	 * @return w2O4
	 */
	public String getW2O4() {
		return this.w2O4;
	}
	
	/**
	 * Column Info
	 * @return w6Ef
	 */
	public String getW6Ef() {
		return this.w6Ef;
	}
	
	/**
	 * Column Info
	 * @return w8S2
	 */
	public String getW8S2() {
		return this.w8S2;
	}
	
	/**
	 * Column Info
	 * @return w2O5
	 */
	public String getW2O5() {
		return this.w2O5;
	}
	
	/**
	 * Column Info
	 * @return w3A4
	 */
	public String getW3A4() {
		return this.w3A4;
	}
	
	/**
	 * Column Info
	 * @return w3A2
	 */
	public String getW3A2() {
		return this.w3A2;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return w7Wk
	 */
	public String getW7Wk() {
		return this.w7Wk;
	}
	
	/**
	 * Column Info
	 * @return w9D7
	 */
	public String getW9D7() {
		return this.w9D7;
	}
	
	/**
	 * Column Info
	 * @return w9D4
	 */
	public String getW9D4() {
		return this.w9D4;
	}
	
	/**
	 * Column Info
	 * @return w9D5
	 */
	public String getW9D5() {
		return this.w9D5;
	}
	
	/**
	 * Column Info
	 * @return w3Wk
	 */
	public String getW3Wk() {
		return this.w3Wk;
	}
	
	/**
	 * Column Info
	 * @return w9D2
	 */
	public String getW9D2() {
		return this.w9D2;
	}
	
	/**
	 * Column Info
	 * @return w5D7
	 */
	public String getW5D7() {
		return this.w5D7;
	}
	
	/**
	 * Column Info
	 * @return w7F
	 */
	public String getW7F() {
		return this.w7F;
	}
	
	/**
	 * Column Info
	 * @return w2O2
	 */
	public String getW2O2() {
		return this.w2O2;
	}
	
	/**
	 * Column Info
	 * @return w4S4
	 */
	public String getW4S4() {
		return this.w4S4;
	}
	
	/**
	 * Column Info
	 * @return w4S2
	 */
	public String getW4S2() {
		return this.w4S2;
	}
	
	/**
	 * Column Info
	 * @return w2F2
	 */
	public String getW2F2() {
		return this.w2F2;
	}
	
	/**
	 * Column Info
	 * @return w4R9
	 */
	public String getW4R9() {
		return this.w4R9;
	}
	
	/**
	 * Column Info
	 * @return w8R5
	 */
	public String getW8R5() {
		return this.w8R5;
	}
	
	/**
	 * Column Info
	 * @return w4R5
	 */
	public String getW4R5() {
		return this.w4R5;
	}
	
	/**
	 * Column Info
	 * @return w8R2
	 */
	public String getW8R2() {
		return this.w8R2;
	}
	
	/**
	 * Column Info
	 * @return w5D4
	 */
	public String getW5D4() {
		return this.w5D4;
	}
	
	/**
	 * Column Info
	 * @return w6F5
	 */
	public String getW6F5() {
		return this.w6F5;
	}
	
	/**
	 * Column Info
	 * @return w5D5
	 */
	public String getW5D5() {
		return this.w5D5;
	}
	
	/**
	 * Column Info
	 * @return w5D2
	 */
	public String getW5D2() {
		return this.w5D2;
	}
	
	/**
	 * Column Info
	 * @return w1D7
	 */
	public String getW1D7() {
		return this.w1D7;
	}
	
	/**
	 * Column Info
	 * @return w6F4
	 */
	public String getW6F4() {
		return this.w6F4;
	}
	
	/**
	 * Column Info
	 * @return w1D4
	 */
	public String getW1D4() {
		return this.w1D4;
	}
	
	/**
	 * Column Info
	 * @return w2F5
	 */
	public String getW2F5() {
		return this.w2F5;
	}
	
	/**
	 * Column Info
	 * @return w1D5
	 */
	public String getW1D5() {
		return this.w1D5;
	}
	
	/**
	 * Column Info
	 * @return w6F2
	 */
	public String getW6F2() {
		return this.w6F2;
	}
	
	/**
	 * Column Info
	 * @return w1D2
	 */
	public String getW1D2() {
		return this.w1D2;
	}
	
	/**
	 * Column Info
	 * @return w8R9
	 */
	public String getW8R9() {
		return this.w8R9;
	}
	
	/**
	 * Column Info
	 * @return w2F4
	 */
	public String getW2F4() {
		return this.w2F4;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return w6A4
	 */
	public String getW6A4() {
		return this.w6A4;
	}
	
	/**
	 * Column Info
	 * @return w8F
	 */
	public String getW8F() {
		return this.w8F;
	}
	
	/**
	 * Column Info
	 * @return w6A2
	 */
	public String getW6A2() {
		return this.w6A2;
	}
	
	/**
	 * Column Info
	 * @return w2R5
	 */
	public String getW2R5() {
		return this.w2R5;
	}
	
	/**
	 * Column Info
	 * @return w6R2
	 */
	public String getW6R2() {
		return this.w6R2;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return w2R2
	 */
	public String getW2R2() {
		return this.w2R2;
	}
	
	/**
	 * Column Info
	 * @return w9O4
	 */
	public String getW9O4() {
		return this.w9O4;
	}
	
	/**
	 * Column Info
	 * @return w5O5
	 */
	public String getW5O5() {
		return this.w5O5;
	}
	
	/**
	 * Column Info
	 * @return w9O2
	 */
	public String getW9O2() {
		return this.w9O2;
	}
	
	/**
	 * Column Info
	 * @return w5O4
	 */
	public String getW5O4() {
		return this.w5O4;
	}
	
	/**
	 * Column Info
	 * @return w9Ef
	 */
	public String getW9Ef() {
		return this.w9Ef;
	}
	
	/**
	 * Column Info
	 * @return w1O5
	 */
	public String getW1O5() {
		return this.w1O5;
	}
	
	/**
	 * Column Info
	 * @return w5O2
	 */
	public String getW5O2() {
		return this.w5O2;
	}
	
	/**
	 * Column Info
	 * @return w7S4
	 */
	public String getW7S4() {
		return this.w7S4;
	}
	
	/**
	 * Column Info
	 * @return w2A4
	 */
	public String getW2A4() {
		return this.w2A4;
	}
	
	/**
	 * Column Info
	 * @return w2A2
	 */
	public String getW2A2() {
		return this.w2A2;
	}
	
	/**
	 * Column Info
	 * @return w9O5
	 */
	public String getW9O5() {
		return this.w9O5;
	}
	
	/**
	 * Column Info
	 * @return w8D7
	 */
	public String getW8D7() {
		return this.w8D7;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return w8D5
	 */
	public String getW8D5() {
		return this.w8D5;
	}
	
	/**
	 * Column Info
	 * @return w6Wk
	 */
	public String getW6Wk() {
		return this.w6Wk;
	}
	
	/**
	 * Column Info
	 * @return w9F
	 */
	public String getW9F() {
		return this.w9F;
	}
	
	/**
	 * Column Info
	 * @return w4D7
	 */
	public String getW4D7() {
		return this.w4D7;
	}
	
	/**
	 * Column Info
	 * @return w9F4
	 */
	public String getW9F4() {
		return this.w9F4;
	}
	
	/**
	 * Column Info
	 * @return w8D4
	 */
	public String getW8D4() {
		return this.w8D4;
	}
	
	/**
	 * Column Info
	 * @return w9F5
	 */
	public String getW9F5() {
		return this.w9F5;
	}
	
	/**
	 * Column Info
	 * @return w1O4
	 */
	public String getW1O4() {
		return this.w1O4;
	}
	
	/**
	 * Column Info
	 * @return w5Ef
	 */
	public String getW5Ef() {
		return this.w5Ef;
	}
	
	/**
	 * Column Info
	 * @return w7S2
	 */
	public String getW7S2() {
		return this.w7S2;
	}
	
	/**
	 * Column Info
	 * @return w1O2
	 */
	public String getW1O2() {
		return this.w1O2;
	}
	
	/**
	 * Column Info
	 * @return w3S4
	 */
	public String getW3S4() {
		return this.w3S4;
	}
	
	/**
	 * Column Info
	 * @return w1F
	 */
	public String getW1F() {
		return this.w1F;
	}
	
	/**
	 * Column Info
	 * @return w3S2
	 */
	public String getW3S2() {
		return this.w3S2;
	}
	
	/**
	 * Column Info
	 * @return w1F2
	 */
	public String getW1F2() {
		return this.w1F2;
	}
	
	/**
	 * Column Info
	 * @return w7R9
	 */
	public String getW7R9() {
		return this.w7R9;
	}
	
	/**
	 * Column Info
	 * @return w3R9
	 */
	public String getW3R9() {
		return this.w3R9;
	}
	
	/**
	 * Column Info
	 * @return w7R5
	 */
	public String getW7R5() {
		return this.w7R5;
	}
	
	/**
	 * Column Info
	 * @return w7R2
	 */
	public String getW7R2() {
		return this.w7R2;
	}
	
	/**
	 * Column Info
	 * @return w4D5
	 */
	public String getW4D5() {
		return this.w4D5;
	}
	
	/**
	 * Column Info
	 * @return w9F2
	 */
	public String getW9F2() {
		return this.w9F2;
	}
	
	/**
	 * Column Info
	 * @return w2Wk
	 */
	public String getW2Wk() {
		return this.w2Wk;
	}
	
	/**
	 * Column Info
	 * @return w8D2
	 */
	public String getW8D2() {
		return this.w8D2;
	}
	
	/**
	 * Column Info
	 * @return w5F4
	 */
	public String getW5F4() {
		return this.w5F4;
	}
	
	/**
	 * Column Info
	 * @return w4D4
	 */
	public String getW4D4() {
		return this.w4D4;
	}
	
	/**
	 * Column Info
	 * @return w5F5
	 */
	public String getW5F5() {
		return this.w5F5;
	}
	
	/**
	 * Column Info
	 * @return w5F2
	 */
	public String getW5F2() {
		return this.w5F2;
	}
	
	/**
	 * Column Info
	 * @return w4D2
	 */
	public String getW4D2() {
		return this.w4D2;
	}
	
	/**
	 * Column Info
	 * @return w1F4
	 */
	public String getW1F4() {
		return this.w1F4;
	}
	
	/**
	 * Column Info
	 * @return w1F5
	 */
	public String getW1F5() {
		return this.w1F5;
	}
	

	/**
	 * Column Info
	 * @param w9A4
	 */
	public void setW9A4(String w9A4) {
		this.w9A4 = w9A4;
	}
	
	/**
	 * Column Info
	 * @param w9A2
	 */
	public void setW9A2(String w9A2) {
		this.w9A2 = w9A2;
	}
	
	/**
	 * Column Info
	 * @param w5A4
	 */
	public void setW5A4(String w5A4) {
		this.w5A4 = w5A4;
	}
	
	/**
	 * Column Info
	 * @param w5R2
	 */
	public void setW5R2(String w5R2) {
		this.w5R2 = w5R2;
	}
	
	/**
	 * Column Info
	 * @param w2F
	 */
	public void setW2F(String w2F) {
		this.w2F = w2F;
	}
	
	/**
	 * Column Info
	 * @param w1R5
	 */
	public void setW1R5(String w1R5) {
		this.w1R5 = w1R5;
	}
	
	/**
	 * Column Info
	 * @param w1R2
	 */
	public void setW1R2(String w1R2) {
		this.w1R2 = w1R2;
	}
	
	/**
	 * Column Info
	 * @param w8O4
	 */
	public void setW8O4(String w8O4) {
		this.w8O4 = w8O4;
	}
	
	/**
	 * Column Info
	 * @param w8O5
	 */
	public void setW8O5(String w8O5) {
		this.w8O5 = w8O5;
	}
	
	/**
	 * Column Info
	 * @param w8O2
	 */
	public void setW8O2(String w8O2) {
		this.w8O2 = w8O2;
	}
	
	/**
	 * Column Info
	 * @param w4O4
	 */
	public void setW4O4(String w4O4) {
		this.w4O4 = w4O4;
	}
	
	/**
	 * Column Info
	 * @param w8Ef
	 */
	public void setW8Ef(String w8Ef) {
		this.w8Ef = w8Ef;
	}
	
	/**
	 * Column Info
	 * @param w4O5
	 */
	public void setW4O5(String w4O5) {
		this.w4O5 = w4O5;
	}
	
	/**
	 * Column Info
	 * @param w4O2
	 */
	public void setW4O2(String w4O2) {
		this.w4O2 = w4O2;
	}
	
	/**
	 * Column Info
	 * @param w6S4
	 */
	public void setW6S4(String w6S4) {
		this.w6S4 = w6S4;
	}
	
	/**
	 * Column Info
	 * @param w5A2
	 */
	public void setW5A2(String w5A2) {
		this.w5A2 = w5A2;
	}
	
	/**
	 * Column Info
	 * @param w1A4
	 */
	public void setW1A4(String w1A4) {
		this.w1A4 = w1A4;
	}
	
	/**
	 * Column Info
	 * @param w1A2
	 */
	public void setW1A2(String w1A2) {
		this.w1A2 = w1A2;
	}
	
	/**
	 * Column Info
	 * @param w9Wk
	 */
	public void setW9Wk(String w9Wk) {
		this.w9Wk = w9Wk;
	}
	
	/**
	 * Column Info
	 * @param w5Wk
	 */
	public void setW5Wk(String w5Wk) {
		this.w5Wk = w5Wk;
	}
	
	/**
	 * Column Info
	 * @param w7D7
	 */
	public void setW7D7(String w7D7) {
		this.w7D7 = w7D7;
	}
	
	/**
	 * Column Info
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
	}
	
	/**
	 * Column Info
	 * @param w7D4
	 */
	public void setW7D4(String w7D4) {
		this.w7D4 = w7D4;
	}
	
	/**
	 * Column Info
	 * @param w8F5
	 */
	public void setW8F5(String w8F5) {
		this.w8F5 = w8F5;
	}
	
	/**
	 * Column Info
	 * @param w7D5
	 */
	public void setW7D5(String w7D5) {
		this.w7D5 = w7D5;
	}
	
	/**
	 * Column Info
	 * @param mtyBalTpCd
	 */
	public void setMtyBalTpCd(String mtyBalTpCd) {
		this.mtyBalTpCd = mtyBalTpCd;
	}
	
	/**
	 * Column Info
	 * @param w4Ef
	 */
	public void setW4Ef(String w4Ef) {
		this.w4Ef = w4Ef;
	}
	
	/**
	 * Column Info
	 * @param w6S2
	 */
	public void setW6S2(String w6S2) {
		this.w6S2 = w6S2;
	}
	
	/**
	 * Column Info
	 * @param w2S4
	 */
	public void setW2S4(String w2S4) {
		this.w2S4 = w2S4;
	}
	
	/**
	 * Column Info
	 * @param w3F
	 */
	public void setW3F(String w3F) {
		this.w3F = w3F;
	}
	
	/**
	 * Column Info
	 * @param w2S2
	 */
	public void setW2S2(String w2S2) {
		this.w2S2 = w2S2;
	}
	
	/**
	 * Column Info
	 * @param w6R9
	 */
	public void setW6R9(String w6R9) {
		this.w6R9 = w6R9;
	}
	
	/**
	 * Column Info
	 * @param w2R9
	 */
	public void setW2R9(String w2R9) {
		this.w2R9 = w2R9;
	}
	
	/**
	 * Column Info
	 * @param w6R5
	 */
	public void setW6R5(String w6R5) {
		this.w6R5 = w6R5;
	}
	
	/**
	 * Column Info
	 * @param w1Wk
	 */
	public void setW1Wk(String w1Wk) {
		this.w1Wk = w1Wk;
	}
	
	/**
	 * Column Info
	 * @param w7D2
	 */
	public void setW7D2(String w7D2) {
		this.w7D2 = w7D2;
	}
	
	/**
	 * Column Info
	 * @param w3D7
	 */
	public void setW3D7(String w3D7) {
		this.w3D7 = w3D7;
	}
	
	/**
	 * Column Info
	 * @param w8F4
	 */
	public void setW8F4(String w8F4) {
		this.w8F4 = w8F4;
	}
	
	/**
	 * Column Info
	 * @param w3D4
	 */
	public void setW3D4(String w3D4) {
		this.w3D4 = w3D4;
	}
	
	/**
	 * Column Info
	 * @param w4F5
	 */
	public void setW4F5(String w4F5) {
		this.w4F5 = w4F5;
	}
	
	/**
	 * Column Info
	 * @param w3D5
	 */
	public void setW3D5(String w3D5) {
		this.w3D5 = w3D5;
	}
	
	/**
	 * Column Info
	 * @param w8F2
	 */
	public void setW8F2(String w8F2) {
		this.w8F2 = w8F2;
	}
	
	/**
	 * Column Info
	 * @param w3D2
	 */
	public void setW3D2(String w3D2) {
		this.w3D2 = w3D2;
	}
	
	/**
	 * Column Info
	 * @param w4F4
	 */
	public void setW4F4(String w4F4) {
		this.w4F4 = w4F4;
	}
	
	/**
	 * Column Info
	 * @param w4F2
	 */
	public void setW4F2(String w4F2) {
		this.w4F2 = w4F2;
	}
	
	/**
	 * Column Info
	 * @param w8A4
	 */
	public void setW8A4(String w8A4) {
		this.w8A4 = w8A4;
	}
	
	/**
	 * Column Info
	 * @param w8A2
	 */
	public void setW8A2(String w8A2) {
		this.w8A2 = w8A2;
	}
	
	/**
	 * Column Info
	 * @param w4A4
	 */
	public void setW4A4(String w4A4) {
		this.w4A4 = w4A4;
	}
	
	/**
	 * Column Info
	 * @param w4F
	 */
	public void setW4F(String w4F) {
		this.w4F = w4F;
	}
	
	/**
	 * Column Info
	 * @param w4R2
	 */
	public void setW4R2(String w4R2) {
		this.w4R2 = w4R2;
	}
	
	/**
	 * Column Info
	 * @param w7O5
	 */
	public void setW7O5(String w7O5) {
		this.w7O5 = w7O5;
	}
	
	/**
	 * Column Info
	 * @param w7O4
	 */
	public void setW7O4(String w7O4) {
		this.w7O4 = w7O4;
	}
	
	/**
	 * Column Info
	 * @param w3O5
	 */
	public void setW3O5(String w3O5) {
		this.w3O5 = w3O5;
	}
	
	/**
	 * Column Info
	 * @param w7O2
	 */
	public void setW7O2(String w7O2) {
		this.w7O2 = w7O2;
	}
	
	/**
	 * Column Info
	 * @param w9S4
	 */
	public void setW9S4(String w9S4) {
		this.w9S4 = w9S4;
	}
	
	/**
	 * Column Info
	 * @param w3O4
	 */
	public void setW3O4(String w3O4) {
		this.w3O4 = w3O4;
	}
	
	/**
	 * Column Info
	 * @param w7Ef
	 */
	public void setW7Ef(String w7Ef) {
		this.w7Ef = w7Ef;
	}
	
	/**
	 * Column Info
	 * @param w9S2
	 */
	public void setW9S2(String w9S2) {
		this.w9S2 = w9S2;
	}
	
	/**
	 * Column Info
	 * @param w4A2
	 */
	public void setW4A2(String w4A2) {
		this.w4A2 = w4A2;
	}
	
	/**
	 * Column Info
	 * @param w8Wk
	 */
	public void setW8Wk(String w8Wk) {
		this.w8Wk = w8Wk;
	}
	
	/**
	 * Column Info
	 * @param w6D7
	 */
	public void setW6D7(String w6D7) {
		this.w6D7 = w6D7;
	}
	
	/**
	 * Column Info
	 * @param w6D5
	 */
	public void setW6D5(String w6D5) {
		this.w6D5 = w6D5;
	}
	
	/**
	 * Column Info
	 * @param w4Wk
	 */
	public void setW4Wk(String w4Wk) {
		this.w4Wk = w4Wk;
	}
	
	/**
	 * Column Info
	 * @param w3O2
	 */
	public void setW3O2(String w3O2) {
		this.w3O2 = w3O2;
	}
	
	/**
	 * Column Info
	 * @param w5F
	 */
	public void setW5F(String w5F) {
		this.w5F = w5F;
	}
	
	/**
	 * Column Info
	 * @param w5S4
	 */
	public void setW5S4(String w5S4) {
		this.w5S4 = w5S4;
	}
	
	/**
	 * Column Info
	 * @param w5S2
	 */
	public void setW5S2(String w5S2) {
		this.w5S2 = w5S2;
	}
	
	/**
	 * Column Info
	 * @param w1S4
	 */
	public void setW1S4(String w1S4) {
		this.w1S4 = w1S4;
	}
	
	/**
	 * Column Info
	 * @param w1S2
	 */
	public void setW1S2(String w1S2) {
		this.w1S2 = w1S2;
	}
	
	/**
	 * Column Info
	 * @param w5R9
	 */
	public void setW5R9(String w5R9) {
		this.w5R9 = w5R9;
	}
	
	/**
	 * Column Info
	 * @param w9R5
	 */
	public void setW9R5(String w9R5) {
		this.w9R5 = w9R5;
	}
	
	/**
	 * Column Info
	 * @param w9R2
	 */
	public void setW9R2(String w9R2) {
		this.w9R2 = w9R2;
	}
	
	/**
	 * Column Info
	 * @param w1R9
	 */
	public void setW1R9(String w1R9) {
		this.w1R9 = w1R9;
	}
	
	/**
	 * Column Info
	 * @param w5R5
	 */
	public void setW5R5(String w5R5) {
		this.w5R5 = w5R5;
	}
	
	/**
	 * Column Info
	 * @param w2D7
	 */
	public void setW2D7(String w2D7) {
		this.w2D7 = w2D7;
	}
	
	/**
	 * Column Info
	 * @param w7F4
	 */
	public void setW7F4(String w7F4) {
		this.w7F4 = w7F4;
	}
	
	/**
	 * Column Info
	 * @param w6D4
	 */
	public void setW6D4(String w6D4) {
		this.w6D4 = w6D4;
	}
	
	/**
	 * Column Info
	 * @param w7F5
	 */
	public void setW7F5(String w7F5) {
		this.w7F5 = w7F5;
	}
	
	/**
	 * Column Info
	 * @param w2D5
	 */
	public void setW2D5(String w2D5) {
		this.w2D5 = w2D5;
	}
	
	/**
	 * Column Info
	 * @param w7F2
	 */
	public void setW7F2(String w7F2) {
		this.w7F2 = w7F2;
	}
	
	/**
	 * Column Info
	 * @param w6D2
	 */
	public void setW6D2(String w6D2) {
		this.w6D2 = w6D2;
	}
	
	/**
	 * Column Info
	 * @param w3F4
	 */
	public void setW3F4(String w3F4) {
		this.w3F4 = w3F4;
	}
	
	/**
	 * Column Info
	 * @param w2D4
	 */
	public void setW2D4(String w2D4) {
		this.w2D4 = w2D4;
	}
	
	/**
	 * Column Info
	 * @param w3F5
	 */
	public void setW3F5(String w3F5) {
		this.w3F5 = w3F5;
	}
	
	/**
	 * Column Info
	 * @param w3F2
	 */
	public void setW3F2(String w3F2) {
		this.w3F2 = w3F2;
	}
	
	/**
	 * Column Info
	 * @param w2D2
	 */
	public void setW2D2(String w2D2) {
		this.w2D2 = w2D2;
	}
	
	/**
	 * Column Info
	 * @param w9R9
	 */
	public void setW9R9(String w9R9) {
		this.w9R9 = w9R9;
	}
	
	/**
	 * Column Info
	 * @param w7A4
	 */
	public void setW7A4(String w7A4) {
		this.w7A4 = w7A4;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param w6F
	 */
	public void setW6F(String w6F) {
		this.w6F = w6F;
	}
	
	/**
	 * Column Info
	 * @param w7A2
	 */
	public void setW7A2(String w7A2) {
		this.w7A2 = w7A2;
	}
	
	/**
	 * Column Info
	 * @param w3R5
	 */
	public void setW3R5(String w3R5) {
		this.w3R5 = w3R5;
	}
	
	/**
	 * Column Info
	 * @param w3R2
	 */
	public void setW3R2(String w3R2) {
		this.w3R2 = w3R2;
	}
	
	/**
	 * Column Info
	 * @param w6O4
	 */
	public void setW6O4(String w6O4) {
		this.w6O4 = w6O4;
	}
	
	/**
	 * Column Info
	 * @param w6O5
	 */
	public void setW6O5(String w6O5) {
		this.w6O5 = w6O5;
	}
	
	/**
	 * Column Info
	 * @param w6O2
	 */
	public void setW6O2(String w6O2) {
		this.w6O2 = w6O2;
	}
	
	/**
	 * Column Info
	 * @param w8S4
	 */
	public void setW8S4(String w8S4) {
		this.w8S4 = w8S4;
	}
	
	/**
	 * Column Info
	 * @param w2O4
	 */
	public void setW2O4(String w2O4) {
		this.w2O4 = w2O4;
	}
	
	/**
	 * Column Info
	 * @param w6Ef
	 */
	public void setW6Ef(String w6Ef) {
		this.w6Ef = w6Ef;
	}
	
	/**
	 * Column Info
	 * @param w8S2
	 */
	public void setW8S2(String w8S2) {
		this.w8S2 = w8S2;
	}
	
	/**
	 * Column Info
	 * @param w2O5
	 */
	public void setW2O5(String w2O5) {
		this.w2O5 = w2O5;
	}
	
	/**
	 * Column Info
	 * @param w3A4
	 */
	public void setW3A4(String w3A4) {
		this.w3A4 = w3A4;
	}
	
	/**
	 * Column Info
	 * @param w3A2
	 */
	public void setW3A2(String w3A2) {
		this.w3A2 = w3A2;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param w7Wk
	 */
	public void setW7Wk(String w7Wk) {
		this.w7Wk = w7Wk;
	}
	
	/**
	 * Column Info
	 * @param w9D7
	 */
	public void setW9D7(String w9D7) {
		this.w9D7 = w9D7;
	}
	
	/**
	 * Column Info
	 * @param w9D4
	 */
	public void setW9D4(String w9D4) {
		this.w9D4 = w9D4;
	}
	
	/**
	 * Column Info
	 * @param w9D5
	 */
	public void setW9D5(String w9D5) {
		this.w9D5 = w9D5;
	}
	
	/**
	 * Column Info
	 * @param w3Wk
	 */
	public void setW3Wk(String w3Wk) {
		this.w3Wk = w3Wk;
	}
	
	/**
	 * Column Info
	 * @param w9D2
	 */
	public void setW9D2(String w9D2) {
		this.w9D2 = w9D2;
	}
	
	/**
	 * Column Info
	 * @param w5D7
	 */
	public void setW5D7(String w5D7) {
		this.w5D7 = w5D7;
	}
	
	/**
	 * Column Info
	 * @param w7F
	 */
	public void setW7F(String w7F) {
		this.w7F = w7F;
	}
	
	/**
	 * Column Info
	 * @param w2O2
	 */
	public void setW2O2(String w2O2) {
		this.w2O2 = w2O2;
	}
	
	/**
	 * Column Info
	 * @param w4S4
	 */
	public void setW4S4(String w4S4) {
		this.w4S4 = w4S4;
	}
	
	/**
	 * Column Info
	 * @param w4S2
	 */
	public void setW4S2(String w4S2) {
		this.w4S2 = w4S2;
	}
	
	/**
	 * Column Info
	 * @param w2F2
	 */
	public void setW2F2(String w2F2) {
		this.w2F2 = w2F2;
	}
	
	/**
	 * Column Info
	 * @param w4R9
	 */
	public void setW4R9(String w4R9) {
		this.w4R9 = w4R9;
	}
	
	/**
	 * Column Info
	 * @param w8R5
	 */
	public void setW8R5(String w8R5) {
		this.w8R5 = w8R5;
	}
	
	/**
	 * Column Info
	 * @param w4R5
	 */
	public void setW4R5(String w4R5) {
		this.w4R5 = w4R5;
	}
	
	/**
	 * Column Info
	 * @param w8R2
	 */
	public void setW8R2(String w8R2) {
		this.w8R2 = w8R2;
	}
	
	/**
	 * Column Info
	 * @param w5D4
	 */
	public void setW5D4(String w5D4) {
		this.w5D4 = w5D4;
	}
	
	/**
	 * Column Info
	 * @param w6F5
	 */
	public void setW6F5(String w6F5) {
		this.w6F5 = w6F5;
	}
	
	/**
	 * Column Info
	 * @param w5D5
	 */
	public void setW5D5(String w5D5) {
		this.w5D5 = w5D5;
	}
	
	/**
	 * Column Info
	 * @param w5D2
	 */
	public void setW5D2(String w5D2) {
		this.w5D2 = w5D2;
	}
	
	/**
	 * Column Info
	 * @param w1D7
	 */
	public void setW1D7(String w1D7) {
		this.w1D7 = w1D7;
	}
	
	/**
	 * Column Info
	 * @param w6F4
	 */
	public void setW6F4(String w6F4) {
		this.w6F4 = w6F4;
	}
	
	/**
	 * Column Info
	 * @param w1D4
	 */
	public void setW1D4(String w1D4) {
		this.w1D4 = w1D4;
	}
	
	/**
	 * Column Info
	 * @param w2F5
	 */
	public void setW2F5(String w2F5) {
		this.w2F5 = w2F5;
	}
	
	/**
	 * Column Info
	 * @param w1D5
	 */
	public void setW1D5(String w1D5) {
		this.w1D5 = w1D5;
	}
	
	/**
	 * Column Info
	 * @param w6F2
	 */
	public void setW6F2(String w6F2) {
		this.w6F2 = w6F2;
	}
	
	/**
	 * Column Info
	 * @param w1D2
	 */
	public void setW1D2(String w1D2) {
		this.w1D2 = w1D2;
	}
	
	/**
	 * Column Info
	 * @param w8R9
	 */
	public void setW8R9(String w8R9) {
		this.w8R9 = w8R9;
	}
	
	/**
	 * Column Info
	 * @param w2F4
	 */
	public void setW2F4(String w2F4) {
		this.w2F4 = w2F4;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param w6A4
	 */
	public void setW6A4(String w6A4) {
		this.w6A4 = w6A4;
	}
	
	/**
	 * Column Info
	 * @param w8F
	 */
	public void setW8F(String w8F) {
		this.w8F = w8F;
	}
	
	/**
	 * Column Info
	 * @param w6A2
	 */
	public void setW6A2(String w6A2) {
		this.w6A2 = w6A2;
	}
	
	/**
	 * Column Info
	 * @param w2R5
	 */
	public void setW2R5(String w2R5) {
		this.w2R5 = w2R5;
	}
	
	/**
	 * Column Info
	 * @param w6R2
	 */
	public void setW6R2(String w6R2) {
		this.w6R2 = w6R2;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param w2R2
	 */
	public void setW2R2(String w2R2) {
		this.w2R2 = w2R2;
	}
	
	/**
	 * Column Info
	 * @param w9O4
	 */
	public void setW9O4(String w9O4) {
		this.w9O4 = w9O4;
	}
	
	/**
	 * Column Info
	 * @param w5O5
	 */
	public void setW5O5(String w5O5) {
		this.w5O5 = w5O5;
	}
	
	/**
	 * Column Info
	 * @param w9O2
	 */
	public void setW9O2(String w9O2) {
		this.w9O2 = w9O2;
	}
	
	/**
	 * Column Info
	 * @param w5O4
	 */
	public void setW5O4(String w5O4) {
		this.w5O4 = w5O4;
	}
	
	/**
	 * Column Info
	 * @param w9Ef
	 */
	public void setW9Ef(String w9Ef) {
		this.w9Ef = w9Ef;
	}
	
	/**
	 * Column Info
	 * @param w1O5
	 */
	public void setW1O5(String w1O5) {
		this.w1O5 = w1O5;
	}
	
	/**
	 * Column Info
	 * @param w5O2
	 */
	public void setW5O2(String w5O2) {
		this.w5O2 = w5O2;
	}
	
	/**
	 * Column Info
	 * @param w7S4
	 */
	public void setW7S4(String w7S4) {
		this.w7S4 = w7S4;
	}
	
	/**
	 * Column Info
	 * @param w2A4
	 */
	public void setW2A4(String w2A4) {
		this.w2A4 = w2A4;
	}
	
	/**
	 * Column Info
	 * @param w2A2
	 */
	public void setW2A2(String w2A2) {
		this.w2A2 = w2A2;
	}
	
	/**
	 * Column Info
	 * @param w9O5
	 */
	public void setW9O5(String w9O5) {
		this.w9O5 = w9O5;
	}
	
	/**
	 * Column Info
	 * @param w8D7
	 */
	public void setW8D7(String w8D7) {
		this.w8D7 = w8D7;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param w8D5
	 */
	public void setW8D5(String w8D5) {
		this.w8D5 = w8D5;
	}
	
	/**
	 * Column Info
	 * @param w6Wk
	 */
	public void setW6Wk(String w6Wk) {
		this.w6Wk = w6Wk;
	}
	
	/**
	 * Column Info
	 * @param w9F
	 */
	public void setW9F(String w9F) {
		this.w9F = w9F;
	}
	
	/**
	 * Column Info
	 * @param w4D7
	 */
	public void setW4D7(String w4D7) {
		this.w4D7 = w4D7;
	}
	
	/**
	 * Column Info
	 * @param w9F4
	 */
	public void setW9F4(String w9F4) {
		this.w9F4 = w9F4;
	}
	
	/**
	 * Column Info
	 * @param w8D4
	 */
	public void setW8D4(String w8D4) {
		this.w8D4 = w8D4;
	}
	
	/**
	 * Column Info
	 * @param w9F5
	 */
	public void setW9F5(String w9F5) {
		this.w9F5 = w9F5;
	}
	
	/**
	 * Column Info
	 * @param w1O4
	 */
	public void setW1O4(String w1O4) {
		this.w1O4 = w1O4;
	}
	
	/**
	 * Column Info
	 * @param w5Ef
	 */
	public void setW5Ef(String w5Ef) {
		this.w5Ef = w5Ef;
	}
	
	/**
	 * Column Info
	 * @param w7S2
	 */
	public void setW7S2(String w7S2) {
		this.w7S2 = w7S2;
	}
	
	/**
	 * Column Info
	 * @param w1O2
	 */
	public void setW1O2(String w1O2) {
		this.w1O2 = w1O2;
	}
	
	/**
	 * Column Info
	 * @param w3S4
	 */
	public void setW3S4(String w3S4) {
		this.w3S4 = w3S4;
	}
	
	/**
	 * Column Info
	 * @param w1F
	 */
	public void setW1F(String w1F) {
		this.w1F = w1F;
	}
	
	/**
	 * Column Info
	 * @param w3S2
	 */
	public void setW3S2(String w3S2) {
		this.w3S2 = w3S2;
	}
	
	/**
	 * Column Info
	 * @param w1F2
	 */
	public void setW1F2(String w1F2) {
		this.w1F2 = w1F2;
	}
	
	/**
	 * Column Info
	 * @param w7R9
	 */
	public void setW7R9(String w7R9) {
		this.w7R9 = w7R9;
	}
	
	/**
	 * Column Info
	 * @param w3R9
	 */
	public void setW3R9(String w3R9) {
		this.w3R9 = w3R9;
	}
	
	/**
	 * Column Info
	 * @param w7R5
	 */
	public void setW7R5(String w7R5) {
		this.w7R5 = w7R5;
	}
	
	/**
	 * Column Info
	 * @param w7R2
	 */
	public void setW7R2(String w7R2) {
		this.w7R2 = w7R2;
	}
	
	/**
	 * Column Info
	 * @param w4D5
	 */
	public void setW4D5(String w4D5) {
		this.w4D5 = w4D5;
	}
	
	/**
	 * Column Info
	 * @param w9F2
	 */
	public void setW9F2(String w9F2) {
		this.w9F2 = w9F2;
	}
	
	/**
	 * Column Info
	 * @param w2Wk
	 */
	public void setW2Wk(String w2Wk) {
		this.w2Wk = w2Wk;
	}
	
	/**
	 * Column Info
	 * @param w8D2
	 */
	public void setW8D2(String w8D2) {
		this.w8D2 = w8D2;
	}
	
	/**
	 * Column Info
	 * @param w5F4
	 */
	public void setW5F4(String w5F4) {
		this.w5F4 = w5F4;
	}
	
	/**
	 * Column Info
	 * @param w4D4
	 */
	public void setW4D4(String w4D4) {
		this.w4D4 = w4D4;
	}
	
	/**
	 * Column Info
	 * @param w5F5
	 */
	public void setW5F5(String w5F5) {
		this.w5F5 = w5F5;
	}
	
	/**
	 * Column Info
	 * @param w5F2
	 */
	public void setW5F2(String w5F2) {
		this.w5F2 = w5F2;
	}
	
	/**
	 * Column Info
	 * @param w4D2
	 */
	public void setW4D2(String w4D2) {
		this.w4D2 = w4D2;
	}
	
	/**
	 * Column Info
	 * @param w1F4
	 */
	public void setW1F4(String w1F4) {
		this.w1F4 = w1F4;
	}
	
	/**
	 * Column Info
	 * @param w1F5
	 */
	public void setW1F5(String w1F5) {
		this.w1F5 = w1F5;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setW9A4(JSPUtil.getParameter(request, prefix + "w9_a4", ""));
		setW9A5(JSPUtil.getParameter(request, prefix + "w9_a5", ""));
		setW9A2(JSPUtil.getParameter(request, prefix + "w9_a2", ""));
		setW5A4(JSPUtil.getParameter(request, prefix + "w5_a4", ""));
		setW5A5(JSPUtil.getParameter(request, prefix + "w5_a5", ""));
		setW5R2(JSPUtil.getParameter(request, prefix + "w5_r2", ""));
		setW2F(JSPUtil.getParameter(request, prefix + "w2_f", ""));
		setW1R5(JSPUtil.getParameter(request, prefix + "w1_r5", ""));
		setW1R2(JSPUtil.getParameter(request, prefix + "w1_r2", ""));
		setW8O4(JSPUtil.getParameter(request, prefix + "w8_o4", ""));
		setW8O5(JSPUtil.getParameter(request, prefix + "w8_o5", ""));
		setW8O2(JSPUtil.getParameter(request, prefix + "w8_o2", ""));
		setW4O4(JSPUtil.getParameter(request, prefix + "w4_o4", ""));
		setW8Ef(JSPUtil.getParameter(request, prefix + "w8_ef", ""));
		setW4O5(JSPUtil.getParameter(request, prefix + "w4_o5", ""));
		setW4O2(JSPUtil.getParameter(request, prefix + "w4_o2", ""));
		setW6S4(JSPUtil.getParameter(request, prefix + "w6_s4", ""));
		setW5A2(JSPUtil.getParameter(request, prefix + "w5_a2", ""));
		setW1A4(JSPUtil.getParameter(request, prefix + "w1_a4", ""));
		setW1A5(JSPUtil.getParameter(request, prefix + "w1_a5", ""));
		setW1A2(JSPUtil.getParameter(request, prefix + "w1_a2", ""));
		setW9Wk(JSPUtil.getParameter(request, prefix + "w9_wk", ""));
		setW5Wk(JSPUtil.getParameter(request, prefix + "w5_wk", ""));
		setW7D7(JSPUtil.getParameter(request, prefix + "w7_d7", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setW7D4(JSPUtil.getParameter(request, prefix + "w7_d4", ""));
		setW8F5(JSPUtil.getParameter(request, prefix + "w8_f5", ""));
		setW7D5(JSPUtil.getParameter(request, prefix + "w7_d5", ""));
		setMtyBalTpCd(JSPUtil.getParameter(request, prefix + "mty_bal_tp_cd", ""));
		setW4Ef(JSPUtil.getParameter(request, prefix + "w4_ef", ""));
		setW6S2(JSPUtil.getParameter(request, prefix + "w6_s2", ""));
		setW2S4(JSPUtil.getParameter(request, prefix + "w2_s4", ""));
		setW3F(JSPUtil.getParameter(request, prefix + "w3_f", ""));
		setW2S2(JSPUtil.getParameter(request, prefix + "w2_s2", ""));
		setW6R9(JSPUtil.getParameter(request, prefix + "w6_r9", ""));
		setW2R9(JSPUtil.getParameter(request, prefix + "w2_r9", ""));
		setW6R5(JSPUtil.getParameter(request, prefix + "w6_r5", ""));
		setW1Wk(JSPUtil.getParameter(request, prefix + "w1_wk", ""));
		setW7D2(JSPUtil.getParameter(request, prefix + "w7_d2", ""));
		setW3D7(JSPUtil.getParameter(request, prefix + "w3_d7", ""));
		setW8F4(JSPUtil.getParameter(request, prefix + "w8_f4", ""));
		setW3D4(JSPUtil.getParameter(request, prefix + "w3_d4", ""));
		setW4F5(JSPUtil.getParameter(request, prefix + "w4_f5", ""));
		setW3D5(JSPUtil.getParameter(request, prefix + "w3_d5", ""));
		setW8F2(JSPUtil.getParameter(request, prefix + "w8_f2", ""));
		setW3D2(JSPUtil.getParameter(request, prefix + "w3_d2", ""));
		setW4F4(JSPUtil.getParameter(request, prefix + "w4_f4", ""));
		setW4F2(JSPUtil.getParameter(request, prefix + "w4_f2", ""));
		setW8A4(JSPUtil.getParameter(request, prefix + "w8_a4", ""));
		setW8A5(JSPUtil.getParameter(request, prefix + "w8_a5", ""));
		setW8A2(JSPUtil.getParameter(request, prefix + "w8_a2", ""));
		setW4A4(JSPUtil.getParameter(request, prefix + "w4_a4", ""));
		setW4A5(JSPUtil.getParameter(request, prefix + "w4_a5", ""));
		setW4F(JSPUtil.getParameter(request, prefix + "w4_f", ""));
		setW4R2(JSPUtil.getParameter(request, prefix + "w4_r2", ""));
		setW7O5(JSPUtil.getParameter(request, prefix + "w7_o5", ""));
		setW7O4(JSPUtil.getParameter(request, prefix + "w7_o4", ""));
		setW3O5(JSPUtil.getParameter(request, prefix + "w3_o5", ""));
		setW7O2(JSPUtil.getParameter(request, prefix + "w7_o2", ""));
		setW9S4(JSPUtil.getParameter(request, prefix + "w9_s4", ""));
		setW3O4(JSPUtil.getParameter(request, prefix + "w3_o4", ""));
		setW7Ef(JSPUtil.getParameter(request, prefix + "w7_ef", ""));
		setW9S2(JSPUtil.getParameter(request, prefix + "w9_s2", ""));
		setW4A2(JSPUtil.getParameter(request, prefix + "w4_a2", ""));
		setW8Wk(JSPUtil.getParameter(request, prefix + "w8_wk", ""));
		setW6D7(JSPUtil.getParameter(request, prefix + "w6_d7", ""));
		setW6D5(JSPUtil.getParameter(request, prefix + "w6_d5", ""));
		setW4Wk(JSPUtil.getParameter(request, prefix + "w4_wk", ""));
		setW3O2(JSPUtil.getParameter(request, prefix + "w3_o2", ""));
		setW5F(JSPUtil.getParameter(request, prefix + "w5_f", ""));
		setW5S4(JSPUtil.getParameter(request, prefix + "w5_s4", ""));
		setW5S2(JSPUtil.getParameter(request, prefix + "w5_s2", ""));
		setW1S4(JSPUtil.getParameter(request, prefix + "w1_s4", ""));
		setW1S2(JSPUtil.getParameter(request, prefix + "w1_s2", ""));
		setW5R9(JSPUtil.getParameter(request, prefix + "w5_r9", ""));
		setW9R5(JSPUtil.getParameter(request, prefix + "w9_r5", ""));
		setW9R2(JSPUtil.getParameter(request, prefix + "w9_r2", ""));
		setW1R9(JSPUtil.getParameter(request, prefix + "w1_r9", ""));
		setW5R5(JSPUtil.getParameter(request, prefix + "w5_r5", ""));
		setW2D7(JSPUtil.getParameter(request, prefix + "w2_d7", ""));
		setW7F4(JSPUtil.getParameter(request, prefix + "w7_f4", ""));
		setW6D4(JSPUtil.getParameter(request, prefix + "w6_d4", ""));
		setW7F5(JSPUtil.getParameter(request, prefix + "w7_f5", ""));
		setW2D5(JSPUtil.getParameter(request, prefix + "w2_d5", ""));
		setW7F2(JSPUtil.getParameter(request, prefix + "w7_f2", ""));
		setW6D2(JSPUtil.getParameter(request, prefix + "w6_d2", ""));
		setW3F4(JSPUtil.getParameter(request, prefix + "w3_f4", ""));
		setW2D4(JSPUtil.getParameter(request, prefix + "w2_d4", ""));
		setW3F5(JSPUtil.getParameter(request, prefix + "w3_f5", ""));
		setW3F2(JSPUtil.getParameter(request, prefix + "w3_f2", ""));
		setW2D2(JSPUtil.getParameter(request, prefix + "w2_d2", ""));
		setW9R9(JSPUtil.getParameter(request, prefix + "w9_r9", ""));
		setW7A4(JSPUtil.getParameter(request, prefix + "w7_a4", ""));
		setW7A5(JSPUtil.getParameter(request, prefix + "w7_a5", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setW6F(JSPUtil.getParameter(request, prefix + "w6_f", ""));
		setW7A2(JSPUtil.getParameter(request, prefix + "w7_a2", ""));
		setW3R5(JSPUtil.getParameter(request, prefix + "w3_r5", ""));
		setW3R2(JSPUtil.getParameter(request, prefix + "w3_r2", ""));
		setW6O4(JSPUtil.getParameter(request, prefix + "w6_o4", ""));
		setW6O5(JSPUtil.getParameter(request, prefix + "w6_o5", ""));
		setW6O2(JSPUtil.getParameter(request, prefix + "w6_o2", ""));
		setW8S4(JSPUtil.getParameter(request, prefix + "w8_s4", ""));
		setW2O4(JSPUtil.getParameter(request, prefix + "w2_o4", ""));
		setW6Ef(JSPUtil.getParameter(request, prefix + "w6_ef", ""));
		setW8S2(JSPUtil.getParameter(request, prefix + "w8_s2", ""));
		setW2O5(JSPUtil.getParameter(request, prefix + "w2_o5", ""));
		setW3A4(JSPUtil.getParameter(request, prefix + "w3_a4", ""));
		setW3A5(JSPUtil.getParameter(request, prefix + "w3_a5", ""));
		setW3A2(JSPUtil.getParameter(request, prefix + "w3_a2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setW7Wk(JSPUtil.getParameter(request, prefix + "w7_wk", ""));
		setW9D7(JSPUtil.getParameter(request, prefix + "w9_d7", ""));
		setW9D4(JSPUtil.getParameter(request, prefix + "w9_d4", ""));
		setW9D5(JSPUtil.getParameter(request, prefix + "w9_d5", ""));
		setW3Wk(JSPUtil.getParameter(request, prefix + "w3_wk", ""));
		setW9D2(JSPUtil.getParameter(request, prefix + "w9_d2", ""));
		setW5D7(JSPUtil.getParameter(request, prefix + "w5_d7", ""));
		setW7F(JSPUtil.getParameter(request, prefix + "w7_f", ""));
		setW2O2(JSPUtil.getParameter(request, prefix + "w2_o2", ""));
		setW4S4(JSPUtil.getParameter(request, prefix + "w4_s4", ""));
		setW4S2(JSPUtil.getParameter(request, prefix + "w4_s2", ""));
		setW2F2(JSPUtil.getParameter(request, prefix + "w2_f2", ""));
		setW4R9(JSPUtil.getParameter(request, prefix + "w4_r9", ""));
		setW8R5(JSPUtil.getParameter(request, prefix + "w8_r5", ""));
		setW4R5(JSPUtil.getParameter(request, prefix + "w4_r5", ""));
		setW8R2(JSPUtil.getParameter(request, prefix + "w8_r2", ""));
		setW5D4(JSPUtil.getParameter(request, prefix + "w5_d4", ""));
		setW6F5(JSPUtil.getParameter(request, prefix + "w6_f5", ""));
		setW5D5(JSPUtil.getParameter(request, prefix + "w5_d5", ""));
		setW5D2(JSPUtil.getParameter(request, prefix + "w5_d2", ""));
		setW1D7(JSPUtil.getParameter(request, prefix + "w1_d7", ""));
		setW6F4(JSPUtil.getParameter(request, prefix + "w6_f4", ""));
		setW1D4(JSPUtil.getParameter(request, prefix + "w1_d4", ""));
		setW2F5(JSPUtil.getParameter(request, prefix + "w2_f5", ""));
		setW1D5(JSPUtil.getParameter(request, prefix + "w1_d5", ""));
		setW6F2(JSPUtil.getParameter(request, prefix + "w6_f2", ""));
		setW1D2(JSPUtil.getParameter(request, prefix + "w1_d2", ""));
		setW8R9(JSPUtil.getParameter(request, prefix + "w8_r9", ""));
		setW2F4(JSPUtil.getParameter(request, prefix + "w2_f4", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setW6A4(JSPUtil.getParameter(request, prefix + "w6_a4", ""));
		setW6A5(JSPUtil.getParameter(request, prefix + "w6_a5", ""));
		setW8F(JSPUtil.getParameter(request, prefix + "w8_f", ""));
		setW6A2(JSPUtil.getParameter(request, prefix + "w6_a2", ""));
		setW2R5(JSPUtil.getParameter(request, prefix + "w2_r5", ""));
		setW6R2(JSPUtil.getParameter(request, prefix + "w6_r2", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setW2R2(JSPUtil.getParameter(request, prefix + "w2_r2", ""));
		setW9O4(JSPUtil.getParameter(request, prefix + "w9_o4", ""));
		setW5O5(JSPUtil.getParameter(request, prefix + "w5_o5", ""));
		setW9O2(JSPUtil.getParameter(request, prefix + "w9_o2", ""));
		setW5O4(JSPUtil.getParameter(request, prefix + "w5_o4", ""));
		setW9Ef(JSPUtil.getParameter(request, prefix + "w9_ef", ""));
		setW1O5(JSPUtil.getParameter(request, prefix + "w1_o5", ""));
		setW5O2(JSPUtil.getParameter(request, prefix + "w5_o2", ""));
		setW7S4(JSPUtil.getParameter(request, prefix + "w7_s4", ""));
		setW2A4(JSPUtil.getParameter(request, prefix + "w2_a4", ""));
		setW2A5(JSPUtil.getParameter(request, prefix + "w2_a5", ""));
		setW2A2(JSPUtil.getParameter(request, prefix + "w2_a2", ""));
		setW9O5(JSPUtil.getParameter(request, prefix + "w9_o5", ""));
		setW8D7(JSPUtil.getParameter(request, prefix + "w8_d7", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setW8D5(JSPUtil.getParameter(request, prefix + "w8_d5", ""));
		setW6Wk(JSPUtil.getParameter(request, prefix + "w6_wk", ""));
		setW9F(JSPUtil.getParameter(request, prefix + "w9_f", ""));
		setW4D7(JSPUtil.getParameter(request, prefix + "w4_d7", ""));
		setW9F4(JSPUtil.getParameter(request, prefix + "w9_f4", ""));
		setW8D4(JSPUtil.getParameter(request, prefix + "w8_d4", ""));
		setW9F5(JSPUtil.getParameter(request, prefix + "w9_f5", ""));
		setW1O4(JSPUtil.getParameter(request, prefix + "w1_o4", ""));
		setW5Ef(JSPUtil.getParameter(request, prefix + "w5_ef", ""));
		setW7S2(JSPUtil.getParameter(request, prefix + "w7_s2", ""));
		setW1O2(JSPUtil.getParameter(request, prefix + "w1_o2", ""));
		setW3S4(JSPUtil.getParameter(request, prefix + "w3_s4", ""));
		setW1F(JSPUtil.getParameter(request, prefix + "w1_f", ""));
		setW3S2(JSPUtil.getParameter(request, prefix + "w3_s2", ""));
		setW1F2(JSPUtil.getParameter(request, prefix + "w1_f2", ""));
		setW7R9(JSPUtil.getParameter(request, prefix + "w7_r9", ""));
		setW3R9(JSPUtil.getParameter(request, prefix + "w3_r9", ""));
		setW7R5(JSPUtil.getParameter(request, prefix + "w7_r5", ""));
		setW7R2(JSPUtil.getParameter(request, prefix + "w7_r2", ""));
		setW4D5(JSPUtil.getParameter(request, prefix + "w4_d5", ""));
		setW9F2(JSPUtil.getParameter(request, prefix + "w9_f2", ""));
		setW2Wk(JSPUtil.getParameter(request, prefix + "w2_wk", ""));
		setW8D2(JSPUtil.getParameter(request, prefix + "w8_d2", ""));
		setW5F4(JSPUtil.getParameter(request, prefix + "w5_f4", ""));
		setW4D4(JSPUtil.getParameter(request, prefix + "w4_d4", ""));
		setW5F5(JSPUtil.getParameter(request, prefix + "w5_f5", ""));
		setW5F2(JSPUtil.getParameter(request, prefix + "w5_f2", ""));
		setW4D2(JSPUtil.getParameter(request, prefix + "w4_d2", ""));
		setW1F4(JSPUtil.getParameter(request, prefix + "w1_f4", ""));
		setW1F5(JSPUtil.getParameter(request, prefix + "w1_f5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpmgFcstInputVO[]
	 */
	public OpmgFcstInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpmgFcstInputVO[]
	 */
	public OpmgFcstInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpmgFcstInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] w9A4 = (JSPUtil.getParameter(request, prefix	+ "w9_a4", length));
			String[] w9A5 = (JSPUtil.getParameter(request, prefix	+ "w9_a5", length));
			String[] w9A2 = (JSPUtil.getParameter(request, prefix	+ "w9_a2", length));
			String[] w5A4 = (JSPUtil.getParameter(request, prefix	+ "w5_a4", length));
			String[] w5A5 = (JSPUtil.getParameter(request, prefix	+ "w5_a5", length));
			String[] w5R2 = (JSPUtil.getParameter(request, prefix	+ "w5_r2", length));
			String[] w2F = (JSPUtil.getParameter(request, prefix	+ "w2_f", length));
			String[] w1R5 = (JSPUtil.getParameter(request, prefix	+ "w1_r5", length));
			String[] w1R2 = (JSPUtil.getParameter(request, prefix	+ "w1_r2", length));
			String[] w8O4 = (JSPUtil.getParameter(request, prefix	+ "w8_o4", length));
			String[] w8O5 = (JSPUtil.getParameter(request, prefix	+ "w8_o5", length));
			String[] w8O2 = (JSPUtil.getParameter(request, prefix	+ "w8_o2", length));
			String[] w4O4 = (JSPUtil.getParameter(request, prefix	+ "w4_o4", length));
			String[] w8Ef = (JSPUtil.getParameter(request, prefix	+ "w8_ef", length));
			String[] w4O5 = (JSPUtil.getParameter(request, prefix	+ "w4_o5", length));
			String[] w4O2 = (JSPUtil.getParameter(request, prefix	+ "w4_o2", length));
			String[] w6S4 = (JSPUtil.getParameter(request, prefix	+ "w6_s4", length));
			String[] w5A2 = (JSPUtil.getParameter(request, prefix	+ "w5_a2", length));
			String[] w1A4 = (JSPUtil.getParameter(request, prefix	+ "w1_a4", length));
			String[] w1A5 = (JSPUtil.getParameter(request, prefix	+ "w1_a5", length));
			String[] w1A2 = (JSPUtil.getParameter(request, prefix	+ "w1_a2", length));
			String[] w9Wk = (JSPUtil.getParameter(request, prefix	+ "w9_wk", length));
			String[] w5Wk = (JSPUtil.getParameter(request, prefix	+ "w5_wk", length));
			String[] w7D7 = (JSPUtil.getParameter(request, prefix	+ "w7_d7", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] w7D4 = (JSPUtil.getParameter(request, prefix	+ "w7_d4", length));
			String[] w8F5 = (JSPUtil.getParameter(request, prefix	+ "w8_f5", length));
			String[] w7D5 = (JSPUtil.getParameter(request, prefix	+ "w7_d5", length));
			String[] mtyBalTpCd = (JSPUtil.getParameter(request, prefix	+ "mty_bal_tp_cd", length));
			String[] w4Ef = (JSPUtil.getParameter(request, prefix	+ "w4_ef", length));
			String[] w6S2 = (JSPUtil.getParameter(request, prefix	+ "w6_s2", length));
			String[] w2S4 = (JSPUtil.getParameter(request, prefix	+ "w2_s4", length));
			String[] w3F = (JSPUtil.getParameter(request, prefix	+ "w3_f", length));
			String[] w2S2 = (JSPUtil.getParameter(request, prefix	+ "w2_s2", length));
			String[] w6R9 = (JSPUtil.getParameter(request, prefix	+ "w6_r9", length));
			String[] w2R9 = (JSPUtil.getParameter(request, prefix	+ "w2_r9", length));
			String[] w6R5 = (JSPUtil.getParameter(request, prefix	+ "w6_r5", length));
			String[] w1Wk = (JSPUtil.getParameter(request, prefix	+ "w1_wk", length));
			String[] w7D2 = (JSPUtil.getParameter(request, prefix	+ "w7_d2", length));
			String[] w3D7 = (JSPUtil.getParameter(request, prefix	+ "w3_d7", length));
			String[] w8F4 = (JSPUtil.getParameter(request, prefix	+ "w8_f4", length));
			String[] w3D4 = (JSPUtil.getParameter(request, prefix	+ "w3_d4", length));
			String[] w4F5 = (JSPUtil.getParameter(request, prefix	+ "w4_f5", length));
			String[] w3D5 = (JSPUtil.getParameter(request, prefix	+ "w3_d5", length));
			String[] w8F2 = (JSPUtil.getParameter(request, prefix	+ "w8_f2", length));
			String[] w3D2 = (JSPUtil.getParameter(request, prefix	+ "w3_d2", length));
			String[] w4F4 = (JSPUtil.getParameter(request, prefix	+ "w4_f4", length));
			String[] w4F2 = (JSPUtil.getParameter(request, prefix	+ "w4_f2", length));
			String[] w8A4 = (JSPUtil.getParameter(request, prefix	+ "w8_a4", length));
			String[] w8A5 = (JSPUtil.getParameter(request, prefix	+ "w8_a5", length));
			String[] w8A2 = (JSPUtil.getParameter(request, prefix	+ "w8_a2", length));
			String[] w4A4 = (JSPUtil.getParameter(request, prefix	+ "w4_a4", length));
			String[] w4A5 = (JSPUtil.getParameter(request, prefix	+ "w4_a5", length));
			String[] w4F = (JSPUtil.getParameter(request, prefix	+ "w4_f", length));
			String[] w4R2 = (JSPUtil.getParameter(request, prefix	+ "w4_r2", length));
			String[] w7O5 = (JSPUtil.getParameter(request, prefix	+ "w7_o5", length));
			String[] w7O4 = (JSPUtil.getParameter(request, prefix	+ "w7_o4", length));
			String[] w3O5 = (JSPUtil.getParameter(request, prefix	+ "w3_o5", length));
			String[] w7O2 = (JSPUtil.getParameter(request, prefix	+ "w7_o2", length));
			String[] w9S4 = (JSPUtil.getParameter(request, prefix	+ "w9_s4", length));
			String[] w3O4 = (JSPUtil.getParameter(request, prefix	+ "w3_o4", length));
			String[] w7Ef = (JSPUtil.getParameter(request, prefix	+ "w7_ef", length));
			String[] w9S2 = (JSPUtil.getParameter(request, prefix	+ "w9_s2", length));
			String[] w4A2 = (JSPUtil.getParameter(request, prefix	+ "w4_a2", length));
			String[] w8Wk = (JSPUtil.getParameter(request, prefix	+ "w8_wk", length));
			String[] w6D7 = (JSPUtil.getParameter(request, prefix	+ "w6_d7", length));
			String[] w6D5 = (JSPUtil.getParameter(request, prefix	+ "w6_d5", length));
			String[] w4Wk = (JSPUtil.getParameter(request, prefix	+ "w4_wk", length));
			String[] w3O2 = (JSPUtil.getParameter(request, prefix	+ "w3_o2", length));
			String[] w5F = (JSPUtil.getParameter(request, prefix	+ "w5_f", length));
			String[] w5S4 = (JSPUtil.getParameter(request, prefix	+ "w5_s4", length));
			String[] w5S2 = (JSPUtil.getParameter(request, prefix	+ "w5_s2", length));
			String[] w1S4 = (JSPUtil.getParameter(request, prefix	+ "w1_s4", length));
			String[] w1S2 = (JSPUtil.getParameter(request, prefix	+ "w1_s2", length));
			String[] w5R9 = (JSPUtil.getParameter(request, prefix	+ "w5_r9", length));
			String[] w9R5 = (JSPUtil.getParameter(request, prefix	+ "w9_r5", length));
			String[] w9R2 = (JSPUtil.getParameter(request, prefix	+ "w9_r2", length));
			String[] w1R9 = (JSPUtil.getParameter(request, prefix	+ "w1_r9", length));
			String[] w5R5 = (JSPUtil.getParameter(request, prefix	+ "w5_r5", length));
			String[] w2D7 = (JSPUtil.getParameter(request, prefix	+ "w2_d7", length));
			String[] w7F4 = (JSPUtil.getParameter(request, prefix	+ "w7_f4", length));
			String[] w6D4 = (JSPUtil.getParameter(request, prefix	+ "w6_d4", length));
			String[] w7F5 = (JSPUtil.getParameter(request, prefix	+ "w7_f5", length));
			String[] w2D5 = (JSPUtil.getParameter(request, prefix	+ "w2_d5", length));
			String[] w7F2 = (JSPUtil.getParameter(request, prefix	+ "w7_f2", length));
			String[] w6D2 = (JSPUtil.getParameter(request, prefix	+ "w6_d2", length));
			String[] w3F4 = (JSPUtil.getParameter(request, prefix	+ "w3_f4", length));
			String[] w2D4 = (JSPUtil.getParameter(request, prefix	+ "w2_d4", length));
			String[] w3F5 = (JSPUtil.getParameter(request, prefix	+ "w3_f5", length));
			String[] w3F2 = (JSPUtil.getParameter(request, prefix	+ "w3_f2", length));
			String[] w2D2 = (JSPUtil.getParameter(request, prefix	+ "w2_d2", length));
			String[] w9R9 = (JSPUtil.getParameter(request, prefix	+ "w9_r9", length));
			String[] w7A4 = (JSPUtil.getParameter(request, prefix	+ "w7_a4", length));
			String[] w7A5 = (JSPUtil.getParameter(request, prefix	+ "w7_a5", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] w6F = (JSPUtil.getParameter(request, prefix	+ "w6_f", length));
			String[] w7A2 = (JSPUtil.getParameter(request, prefix	+ "w7_a2", length));
			String[] w3R5 = (JSPUtil.getParameter(request, prefix	+ "w3_r5", length));
			String[] w3R2 = (JSPUtil.getParameter(request, prefix	+ "w3_r2", length));
			String[] w6O4 = (JSPUtil.getParameter(request, prefix	+ "w6_o4", length));
			String[] w6O5 = (JSPUtil.getParameter(request, prefix	+ "w6_o5", length));
			String[] w6O2 = (JSPUtil.getParameter(request, prefix	+ "w6_o2", length));
			String[] w8S4 = (JSPUtil.getParameter(request, prefix	+ "w8_s4", length));
			String[] w2O4 = (JSPUtil.getParameter(request, prefix	+ "w2_o4", length));
			String[] w6Ef = (JSPUtil.getParameter(request, prefix	+ "w6_ef", length));
			String[] w8S2 = (JSPUtil.getParameter(request, prefix	+ "w8_s2", length));
			String[] w2O5 = (JSPUtil.getParameter(request, prefix	+ "w2_o5", length));
			String[] w3A4 = (JSPUtil.getParameter(request, prefix	+ "w3_a4", length));
			String[] w3A5 = (JSPUtil.getParameter(request, prefix	+ "w3_a5", length));
			String[] w3A2 = (JSPUtil.getParameter(request, prefix	+ "w3_a2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] w7Wk = (JSPUtil.getParameter(request, prefix	+ "w7_wk", length));
			String[] w9D7 = (JSPUtil.getParameter(request, prefix	+ "w9_d7", length));
			String[] w9D4 = (JSPUtil.getParameter(request, prefix	+ "w9_d4", length));
			String[] w9D5 = (JSPUtil.getParameter(request, prefix	+ "w9_d5", length));
			String[] w3Wk = (JSPUtil.getParameter(request, prefix	+ "w3_wk", length));
			String[] w9D2 = (JSPUtil.getParameter(request, prefix	+ "w9_d2", length));
			String[] w5D7 = (JSPUtil.getParameter(request, prefix	+ "w5_d7", length));
			String[] w7F = (JSPUtil.getParameter(request, prefix	+ "w7_f", length));
			String[] w2O2 = (JSPUtil.getParameter(request, prefix	+ "w2_o2", length));
			String[] w4S4 = (JSPUtil.getParameter(request, prefix	+ "w4_s4", length));
			String[] w4S2 = (JSPUtil.getParameter(request, prefix	+ "w4_s2", length));
			String[] w2F2 = (JSPUtil.getParameter(request, prefix	+ "w2_f2", length));
			String[] w4R9 = (JSPUtil.getParameter(request, prefix	+ "w4_r9", length));
			String[] w8R5 = (JSPUtil.getParameter(request, prefix	+ "w8_r5", length));
			String[] w4R5 = (JSPUtil.getParameter(request, prefix	+ "w4_r5", length));
			String[] w8R2 = (JSPUtil.getParameter(request, prefix	+ "w8_r2", length));
			String[] w5D4 = (JSPUtil.getParameter(request, prefix	+ "w5_d4", length));
			String[] w6F5 = (JSPUtil.getParameter(request, prefix	+ "w6_f5", length));
			String[] w5D5 = (JSPUtil.getParameter(request, prefix	+ "w5_d5", length));
			String[] w5D2 = (JSPUtil.getParameter(request, prefix	+ "w5_d2", length));
			String[] w1D7 = (JSPUtil.getParameter(request, prefix	+ "w1_d7", length));
			String[] w6F4 = (JSPUtil.getParameter(request, prefix	+ "w6_f4", length));
			String[] w1D4 = (JSPUtil.getParameter(request, prefix	+ "w1_d4", length));
			String[] w2F5 = (JSPUtil.getParameter(request, prefix	+ "w2_f5", length));
			String[] w1D5 = (JSPUtil.getParameter(request, prefix	+ "w1_d5", length));
			String[] w6F2 = (JSPUtil.getParameter(request, prefix	+ "w6_f2", length));
			String[] w1D2 = (JSPUtil.getParameter(request, prefix	+ "w1_d2", length));
			String[] w8R9 = (JSPUtil.getParameter(request, prefix	+ "w8_r9", length));
			String[] w2F4 = (JSPUtil.getParameter(request, prefix	+ "w2_f4", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] w6A4 = (JSPUtil.getParameter(request, prefix	+ "w6_a4", length));
			String[] w6A5 = (JSPUtil.getParameter(request, prefix	+ "w6_a5", length));
			String[] w8F = (JSPUtil.getParameter(request, prefix	+ "w8_f", length));
			String[] w6A2 = (JSPUtil.getParameter(request, prefix	+ "w6_a2", length));
			String[] w2R5 = (JSPUtil.getParameter(request, prefix	+ "w2_r5", length));
			String[] w6R2 = (JSPUtil.getParameter(request, prefix	+ "w6_r2", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] w2R2 = (JSPUtil.getParameter(request, prefix	+ "w2_r2", length));
			String[] w9O4 = (JSPUtil.getParameter(request, prefix	+ "w9_o4", length));
			String[] w5O5 = (JSPUtil.getParameter(request, prefix	+ "w5_o5", length));
			String[] w9O2 = (JSPUtil.getParameter(request, prefix	+ "w9_o2", length));
			String[] w5O4 = (JSPUtil.getParameter(request, prefix	+ "w5_o4", length));
			String[] w9Ef = (JSPUtil.getParameter(request, prefix	+ "w9_ef", length));
			String[] w1O5 = (JSPUtil.getParameter(request, prefix	+ "w1_o5", length));
			String[] w5O2 = (JSPUtil.getParameter(request, prefix	+ "w5_o2", length));
			String[] w7S4 = (JSPUtil.getParameter(request, prefix	+ "w7_s4", length));
			String[] w2A4 = (JSPUtil.getParameter(request, prefix	+ "w2_a4", length));
			String[] w2A5 = (JSPUtil.getParameter(request, prefix	+ "w2_a5", length));
			String[] w2A2 = (JSPUtil.getParameter(request, prefix	+ "w2_a2", length));
			String[] w9O5 = (JSPUtil.getParameter(request, prefix	+ "w9_o5", length));
			String[] w8D7 = (JSPUtil.getParameter(request, prefix	+ "w8_d7", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] w8D5 = (JSPUtil.getParameter(request, prefix	+ "w8_d5", length));
			String[] w6Wk = (JSPUtil.getParameter(request, prefix	+ "w6_wk", length));
			String[] w9F = (JSPUtil.getParameter(request, prefix	+ "w9_f", length));
			String[] w4D7 = (JSPUtil.getParameter(request, prefix	+ "w4_d7", length));
			String[] w9F4 = (JSPUtil.getParameter(request, prefix	+ "w9_f4", length));
			String[] w8D4 = (JSPUtil.getParameter(request, prefix	+ "w8_d4", length));
			String[] w9F5 = (JSPUtil.getParameter(request, prefix	+ "w9_f5", length));
			String[] w1O4 = (JSPUtil.getParameter(request, prefix	+ "w1_o4", length));
			String[] w5Ef = (JSPUtil.getParameter(request, prefix	+ "w5_ef", length));
			String[] w7S2 = (JSPUtil.getParameter(request, prefix	+ "w7_s2", length));
			String[] w1O2 = (JSPUtil.getParameter(request, prefix	+ "w1_o2", length));
			String[] w3S4 = (JSPUtil.getParameter(request, prefix	+ "w3_s4", length));
			String[] w1F = (JSPUtil.getParameter(request, prefix	+ "w1_f", length));
			String[] w3S2 = (JSPUtil.getParameter(request, prefix	+ "w3_s2", length));
			String[] w1F2 = (JSPUtil.getParameter(request, prefix	+ "w1_f2", length));
			String[] w7R9 = (JSPUtil.getParameter(request, prefix	+ "w7_r9", length));
			String[] w3R9 = (JSPUtil.getParameter(request, prefix	+ "w3_r9", length));
			String[] w7R5 = (JSPUtil.getParameter(request, prefix	+ "w7_r5", length));
			String[] w7R2 = (JSPUtil.getParameter(request, prefix	+ "w7_r2", length));
			String[] w4D5 = (JSPUtil.getParameter(request, prefix	+ "w4_d5", length));
			String[] w9F2 = (JSPUtil.getParameter(request, prefix	+ "w9_f2", length));
			String[] w2Wk = (JSPUtil.getParameter(request, prefix	+ "w2_wk", length));
			String[] w8D2 = (JSPUtil.getParameter(request, prefix	+ "w8_d2", length));
			String[] w5F4 = (JSPUtil.getParameter(request, prefix	+ "w5_f4", length));
			String[] w4D4 = (JSPUtil.getParameter(request, prefix	+ "w4_d4", length));
			String[] w5F5 = (JSPUtil.getParameter(request, prefix	+ "w5_f5", length));
			String[] w5F2 = (JSPUtil.getParameter(request, prefix	+ "w5_f2", length));
			String[] w4D2 = (JSPUtil.getParameter(request, prefix	+ "w4_d2", length));
			String[] w1F4 = (JSPUtil.getParameter(request, prefix	+ "w1_f4", length));
			String[] w1F5 = (JSPUtil.getParameter(request, prefix	+ "w1_f5", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpmgFcstInputVO();
				if (w9A4[i] != null)
					model.setW9A4(w9A4[i]);
				if (w9A5[i] != null)
					model.setW9A5(w9A5[i]);
				if (w9A2[i] != null)
					model.setW9A2(w9A2[i]);
				if (w5A4[i] != null)
					model.setW5A4(w5A4[i]);
				if (w5A5[i] != null)
					model.setW5A5(w5A5[i]);
				if (w5R2[i] != null)
					model.setW5R2(w5R2[i]);
				if (w2F[i] != null)
					model.setW2F(w2F[i]);
				if (w1R5[i] != null)
					model.setW1R5(w1R5[i]);
				if (w1R2[i] != null)
					model.setW1R2(w1R2[i]);
				if (w8O4[i] != null)
					model.setW8O4(w8O4[i]);
				if (w8O5[i] != null)
					model.setW8O5(w8O5[i]);
				if (w8O2[i] != null)
					model.setW8O2(w8O2[i]);
				if (w4O4[i] != null)
					model.setW4O4(w4O4[i]);
				if (w8Ef[i] != null)
					model.setW8Ef(w8Ef[i]);
				if (w4O5[i] != null)
					model.setW4O5(w4O5[i]);
				if (w4O2[i] != null)
					model.setW4O2(w4O2[i]);
				if (w6S4[i] != null)
					model.setW6S4(w6S4[i]);
				if (w5A2[i] != null)
					model.setW5A2(w5A2[i]);
				if (w1A4[i] != null)
					model.setW1A4(w1A4[i]);
				if (w1A5[i] != null)
					model.setW1A5(w1A5[i]);
				if (w1A2[i] != null)
					model.setW1A2(w1A2[i]);
				if (w9Wk[i] != null)
					model.setW9Wk(w9Wk[i]);
				if (w5Wk[i] != null)
					model.setW5Wk(w5Wk[i]);
				if (w7D7[i] != null)
					model.setW7D7(w7D7[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (w7D4[i] != null)
					model.setW7D4(w7D4[i]);
				if (w8F5[i] != null)
					model.setW8F5(w8F5[i]);
				if (w7D5[i] != null)
					model.setW7D5(w7D5[i]);
				if (mtyBalTpCd[i] != null)
					model.setMtyBalTpCd(mtyBalTpCd[i]);
				if (w4Ef[i] != null)
					model.setW4Ef(w4Ef[i]);
				if (w6S2[i] != null)
					model.setW6S2(w6S2[i]);
				if (w2S4[i] != null)
					model.setW2S4(w2S4[i]);
				if (w3F[i] != null)
					model.setW3F(w3F[i]);
				if (w2S2[i] != null)
					model.setW2S2(w2S2[i]);
				if (w6R9[i] != null)
					model.setW6R9(w6R9[i]);
				if (w2R9[i] != null)
					model.setW2R9(w2R9[i]);
				if (w6R5[i] != null)
					model.setW6R5(w6R5[i]);
				if (w1Wk[i] != null)
					model.setW1Wk(w1Wk[i]);
				if (w7D2[i] != null)
					model.setW7D2(w7D2[i]);
				if (w3D7[i] != null)
					model.setW3D7(w3D7[i]);
				if (w8F4[i] != null)
					model.setW8F4(w8F4[i]);
				if (w3D4[i] != null)
					model.setW3D4(w3D4[i]);
				if (w4F5[i] != null)
					model.setW4F5(w4F5[i]);
				if (w3D5[i] != null)
					model.setW3D5(w3D5[i]);
				if (w8F2[i] != null)
					model.setW8F2(w8F2[i]);
				if (w3D2[i] != null)
					model.setW3D2(w3D2[i]);
				if (w4F4[i] != null)
					model.setW4F4(w4F4[i]);
				if (w4F2[i] != null)
					model.setW4F2(w4F2[i]);
				if (w8A4[i] != null)
					model.setW8A4(w8A4[i]);
				if (w8A5[i] != null)
					model.setW8A5(w8A5[i]);
				if (w8A2[i] != null)
					model.setW8A2(w8A2[i]);
				if (w4A4[i] != null)
					model.setW4A4(w4A4[i]);
				if (w4A5[i] != null)
					model.setW4A5(w4A5[i]);
				if (w4F[i] != null)
					model.setW4F(w4F[i]);
				if (w4R2[i] != null)
					model.setW4R2(w4R2[i]);
				if (w7O5[i] != null)
					model.setW7O5(w7O5[i]);
				if (w7O4[i] != null)
					model.setW7O4(w7O4[i]);
				if (w3O5[i] != null)
					model.setW3O5(w3O5[i]);
				if (w7O2[i] != null)
					model.setW7O2(w7O2[i]);
				if (w9S4[i] != null)
					model.setW9S4(w9S4[i]);
				if (w3O4[i] != null)
					model.setW3O4(w3O4[i]);
				if (w7Ef[i] != null)
					model.setW7Ef(w7Ef[i]);
				if (w9S2[i] != null)
					model.setW9S2(w9S2[i]);
				if (w4A2[i] != null)
					model.setW4A2(w4A2[i]);
				if (w8Wk[i] != null)
					model.setW8Wk(w8Wk[i]);
				if (w6D7[i] != null)
					model.setW6D7(w6D7[i]);
				if (w6D5[i] != null)
					model.setW6D5(w6D5[i]);
				if (w4Wk[i] != null)
					model.setW4Wk(w4Wk[i]);
				if (w3O2[i] != null)
					model.setW3O2(w3O2[i]);
				if (w5F[i] != null)
					model.setW5F(w5F[i]);
				if (w5S4[i] != null)
					model.setW5S4(w5S4[i]);
				if (w5S2[i] != null)
					model.setW5S2(w5S2[i]);
				if (w1S4[i] != null)
					model.setW1S4(w1S4[i]);
				if (w1S2[i] != null)
					model.setW1S2(w1S2[i]);
				if (w5R9[i] != null)
					model.setW5R9(w5R9[i]);
				if (w9R5[i] != null)
					model.setW9R5(w9R5[i]);
				if (w9R2[i] != null)
					model.setW9R2(w9R2[i]);
				if (w1R9[i] != null)
					model.setW1R9(w1R9[i]);
				if (w5R5[i] != null)
					model.setW5R5(w5R5[i]);
				if (w2D7[i] != null)
					model.setW2D7(w2D7[i]);
				if (w7F4[i] != null)
					model.setW7F4(w7F4[i]);
				if (w6D4[i] != null)
					model.setW6D4(w6D4[i]);
				if (w7F5[i] != null)
					model.setW7F5(w7F5[i]);
				if (w2D5[i] != null)
					model.setW2D5(w2D5[i]);
				if (w7F2[i] != null)
					model.setW7F2(w7F2[i]);
				if (w6D2[i] != null)
					model.setW6D2(w6D2[i]);
				if (w3F4[i] != null)
					model.setW3F4(w3F4[i]);
				if (w2D4[i] != null)
					model.setW2D4(w2D4[i]);
				if (w3F5[i] != null)
					model.setW3F5(w3F5[i]);
				if (w3F2[i] != null)
					model.setW3F2(w3F2[i]);
				if (w2D2[i] != null)
					model.setW2D2(w2D2[i]);
				if (w9R9[i] != null)
					model.setW9R9(w9R9[i]);
				if (w7A4[i] != null)
					model.setW7A4(w7A4[i]);
				if (w7A5[i] != null)
					model.setW7A5(w7A5[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (w6F[i] != null)
					model.setW6F(w6F[i]);
				if (w7A2[i] != null)
					model.setW7A2(w7A2[i]);
				if (w3R5[i] != null)
					model.setW3R5(w3R5[i]);
				if (w3R2[i] != null)
					model.setW3R2(w3R2[i]);
				if (w6O4[i] != null)
					model.setW6O4(w6O4[i]);
				if (w6O5[i] != null)
					model.setW6O5(w6O5[i]);
				if (w6O2[i] != null)
					model.setW6O2(w6O2[i]);
				if (w8S4[i] != null)
					model.setW8S4(w8S4[i]);
				if (w2O4[i] != null)
					model.setW2O4(w2O4[i]);
				if (w6Ef[i] != null)
					model.setW6Ef(w6Ef[i]);
				if (w8S2[i] != null)
					model.setW8S2(w8S2[i]);
				if (w2O5[i] != null)
					model.setW2O5(w2O5[i]);
				if (w3A4[i] != null)
					model.setW3A4(w3A4[i]);
				if (w3A5[i] != null)
					model.setW3A5(w3A5[i]);
				if (w3A2[i] != null)
					model.setW3A2(w3A2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (w7Wk[i] != null)
					model.setW7Wk(w7Wk[i]);
				if (w9D7[i] != null)
					model.setW9D7(w9D7[i]);
				if (w9D4[i] != null)
					model.setW9D4(w9D4[i]);
				if (w9D5[i] != null)
					model.setW9D5(w9D5[i]);
				if (w3Wk[i] != null)
					model.setW3Wk(w3Wk[i]);
				if (w9D2[i] != null)
					model.setW9D2(w9D2[i]);
				if (w5D7[i] != null)
					model.setW5D7(w5D7[i]);
				if (w7F[i] != null)
					model.setW7F(w7F[i]);
				if (w2O2[i] != null)
					model.setW2O2(w2O2[i]);
				if (w4S4[i] != null)
					model.setW4S4(w4S4[i]);
				if (w4S2[i] != null)
					model.setW4S2(w4S2[i]);
				if (w2F2[i] != null)
					model.setW2F2(w2F2[i]);
				if (w4R9[i] != null)
					model.setW4R9(w4R9[i]);
				if (w8R5[i] != null)
					model.setW8R5(w8R5[i]);
				if (w4R5[i] != null)
					model.setW4R5(w4R5[i]);
				if (w8R2[i] != null)
					model.setW8R2(w8R2[i]);
				if (w5D4[i] != null)
					model.setW5D4(w5D4[i]);
				if (w6F5[i] != null)
					model.setW6F5(w6F5[i]);
				if (w5D5[i] != null)
					model.setW5D5(w5D5[i]);
				if (w5D2[i] != null)
					model.setW5D2(w5D2[i]);
				if (w1D7[i] != null)
					model.setW1D7(w1D7[i]);
				if (w6F4[i] != null)
					model.setW6F4(w6F4[i]);
				if (w1D4[i] != null)
					model.setW1D4(w1D4[i]);
				if (w2F5[i] != null)
					model.setW2F5(w2F5[i]);
				if (w1D5[i] != null)
					model.setW1D5(w1D5[i]);
				if (w6F2[i] != null)
					model.setW6F2(w6F2[i]);
				if (w1D2[i] != null)
					model.setW1D2(w1D2[i]);
				if (w8R9[i] != null)
					model.setW8R9(w8R9[i]);
				if (w2F4[i] != null)
					model.setW2F4(w2F4[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (w6A4[i] != null)
					model.setW6A4(w6A4[i]);
				if (w6A5[i] != null)
					model.setW6A5(w6A5[i]);
				if (w8F[i] != null)
					model.setW8F(w8F[i]);
				if (w6A2[i] != null)
					model.setW6A2(w6A2[i]);
				if (w2R5[i] != null)
					model.setW2R5(w2R5[i]);
				if (w6R2[i] != null)
					model.setW6R2(w6R2[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (w2R2[i] != null)
					model.setW2R2(w2R2[i]);
				if (w9O4[i] != null)
					model.setW9O4(w9O4[i]);
				if (w5O5[i] != null)
					model.setW5O5(w5O5[i]);
				if (w9O2[i] != null)
					model.setW9O2(w9O2[i]);
				if (w5O4[i] != null)
					model.setW5O4(w5O4[i]);
				if (w9Ef[i] != null)
					model.setW9Ef(w9Ef[i]);
				if (w1O5[i] != null)
					model.setW1O5(w1O5[i]);
				if (w5O2[i] != null)
					model.setW5O2(w5O2[i]);
				if (w7S4[i] != null)
					model.setW7S4(w7S4[i]);
				if (w2A4[i] != null)
					model.setW2A4(w2A4[i]);
				if (w2A5[i] != null)
					model.setW2A5(w2A5[i]);
				if (w2A2[i] != null)
					model.setW2A2(w2A2[i]);
				if (w9O5[i] != null)
					model.setW9O5(w9O5[i]);
				if (w8D7[i] != null)
					model.setW8D7(w8D7[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (w8D5[i] != null)
					model.setW8D5(w8D5[i]);
				if (w6Wk[i] != null)
					model.setW6Wk(w6Wk[i]);
				if (w9F[i] != null)
					model.setW9F(w9F[i]);
				if (w4D7[i] != null)
					model.setW4D7(w4D7[i]);
				if (w9F4[i] != null)
					model.setW9F4(w9F4[i]);
				if (w8D4[i] != null)
					model.setW8D4(w8D4[i]);
				if (w9F5[i] != null)
					model.setW9F5(w9F5[i]);
				if (w1O4[i] != null)
					model.setW1O4(w1O4[i]);
				if (w5Ef[i] != null)
					model.setW5Ef(w5Ef[i]);
				if (w7S2[i] != null)
					model.setW7S2(w7S2[i]);
				if (w1O2[i] != null)
					model.setW1O2(w1O2[i]);
				if (w3S4[i] != null)
					model.setW3S4(w3S4[i]);
				if (w1F[i] != null)
					model.setW1F(w1F[i]);
				if (w3S2[i] != null)
					model.setW3S2(w3S2[i]);
				if (w1F2[i] != null)
					model.setW1F2(w1F2[i]);
				if (w7R9[i] != null)
					model.setW7R9(w7R9[i]);
				if (w3R9[i] != null)
					model.setW3R9(w3R9[i]);
				if (w7R5[i] != null)
					model.setW7R5(w7R5[i]);
				if (w7R2[i] != null)
					model.setW7R2(w7R2[i]);
				if (w4D5[i] != null)
					model.setW4D5(w4D5[i]);
				if (w9F2[i] != null)
					model.setW9F2(w9F2[i]);
				if (w2Wk[i] != null)
					model.setW2Wk(w2Wk[i]);
				if (w8D2[i] != null)
					model.setW8D2(w8D2[i]);
				if (w5F4[i] != null)
					model.setW5F4(w5F4[i]);
				if (w4D4[i] != null)
					model.setW4D4(w4D4[i]);
				if (w5F5[i] != null)
					model.setW5F5(w5F5[i]);
				if (w5F2[i] != null)
					model.setW5F2(w5F2[i]);
				if (w4D2[i] != null)
					model.setW4D2(w4D2[i]);
				if (w1F4[i] != null)
					model.setW1F4(w1F4[i]);
				if (w1F5[i] != null)
					model.setW1F5(w1F5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpmgFcstInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpmgFcstInputVO[]
	 */
	public OpmgFcstInputVO[] getOpmgFcstInputVOs(){
		OpmgFcstInputVO[] vos = (OpmgFcstInputVO[])models.toArray(new OpmgFcstInputVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.w9A4 = this.w9A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9A5 = this.w9A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9A2 = this.w9A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5A4 = this.w5A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5A5 = this.w5A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5R2 = this.w5R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2F = this.w2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1R5 = this.w1R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1R2 = this.w1R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8O4 = this.w8O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8O5 = this.w8O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8O2 = this.w8O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4O4 = this.w4O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8Ef = this.w8Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4O5 = this.w4O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4O2 = this.w4O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6S4 = this.w6S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5A2 = this.w5A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1A4 = this.w1A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1A5 = this.w1A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1A2 = this.w1A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9Wk = this.w9Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5Wk = this.w5Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7D7 = this.w7D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7D4 = this.w7D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8F5 = this.w8F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7D5 = this.w7D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBalTpCd = this.mtyBalTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4Ef = this.w4Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6S2 = this.w6S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2S4 = this.w2S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3F = this.w3F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2S2 = this.w2S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6R9 = this.w6R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2R9 = this.w2R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6R5 = this.w6R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1Wk = this.w1Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7D2 = this.w7D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3D7 = this.w3D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8F4 = this.w8F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3D4 = this.w3D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4F5 = this.w4F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3D5 = this.w3D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8F2 = this.w8F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3D2 = this.w3D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4F4 = this.w4F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4F2 = this.w4F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8A4 = this.w8A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8A5 = this.w8A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8A2 = this.w8A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4A4 = this.w4A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4A5 = this.w4A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4F = this.w4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4R2 = this.w4R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7O5 = this.w7O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7O4 = this.w7O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3O5 = this.w3O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7O2 = this.w7O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9S4 = this.w9S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3O4 = this.w3O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7Ef = this.w7Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9S2 = this.w9S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4A2 = this.w4A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8Wk = this.w8Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6D7 = this.w6D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6D5 = this.w6D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4Wk = this.w4Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3O2 = this.w3O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5F = this.w5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5S4 = this.w5S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5S2 = this.w5S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1S4 = this.w1S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1S2 = this.w1S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5R9 = this.w5R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9R5 = this.w9R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9R2 = this.w9R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1R9 = this.w1R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5R5 = this.w5R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2D7 = this.w2D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7F4 = this.w7F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6D4 = this.w6D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7F5 = this.w7F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2D5 = this.w2D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7F2 = this.w7F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6D2 = this.w6D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3F4 = this.w3F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2D4 = this.w2D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3F5 = this.w3F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3F2 = this.w3F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2D2 = this.w2D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9R9 = this.w9R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7A4 = this.w7A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7A5 = this.w7A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6F = this.w6F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7A2 = this.w7A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3R5 = this.w3R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3R2 = this.w3R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6O4 = this.w6O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6O5 = this.w6O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6O2 = this.w6O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8S4 = this.w8S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2O4 = this.w2O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6Ef = this.w6Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8S2 = this.w8S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2O5 = this.w2O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3A4 = this.w3A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3A5 = this.w3A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3A2 = this.w3A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7Wk = this.w7Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9D7 = this.w9D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9D4 = this.w9D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9D5 = this.w9D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3Wk = this.w3Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9D2 = this.w9D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5D7 = this.w5D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7F = this.w7F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2O2 = this.w2O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4S4 = this.w4S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4S2 = this.w4S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2F2 = this.w2F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4R9 = this.w4R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8R5 = this.w8R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4R5 = this.w4R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8R2 = this.w8R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5D4 = this.w5D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6F5 = this.w6F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5D5 = this.w5D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5D2 = this.w5D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1D7 = this.w1D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6F4 = this.w6F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1D4 = this.w1D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2F5 = this.w2F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1D5 = this.w1D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6F2 = this.w6F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1D2 = this.w1D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8R9 = this.w8R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2F4 = this.w2F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6A4 = this.w6A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6A5 = this.w6A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8F = this.w8F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6A2 = this.w6A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2R5 = this.w2R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6R2 = this.w6R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2R2 = this.w2R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9O4 = this.w9O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5O5 = this.w5O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9O2 = this.w9O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5O4 = this.w5O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9Ef = this.w9Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1O5 = this.w1O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5O2 = this.w5O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7S4 = this.w7S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2A4 = this.w2A4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2A5 = this.w2A5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2A2 = this.w2A2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9O5 = this.w9O5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8D7 = this.w8D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8D5 = this.w8D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w6Wk = this.w6Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9F = this.w9F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4D7 = this.w4D7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9F4 = this.w9F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8D4 = this.w8D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9F5 = this.w9F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1O4 = this.w1O4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5Ef = this.w5Ef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7S2 = this.w7S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1O2 = this.w1O2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3S4 = this.w3S4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1F = this.w1F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3S2 = this.w3S2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1F2 = this.w1F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7R9 = this.w7R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w3R9 = this.w3R9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7R5 = this.w7R5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w7R2 = this.w7R2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4D5 = this.w4D5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w9F2 = this.w9F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w2Wk = this.w2Wk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w8D2 = this.w8D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.w5F4 = this.w5F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4D4 = this.w4D4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5F5 = this.w5F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w5F2 = this.w5F2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w4D2 = this.w4D2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1F4 = this.w1F4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.w1F5 = this.w1F5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getW5A5() {
		return w5A5;
	}

	public void setW5A5(String w5a5) {
		w5A5 = w5a5;
	}

	public String getW1A5() {
		return w1A5;
	}

	public void setW1A5(String w1a5) {
		w1A5 = w1a5;
	}

	public String getW4A5() {
		return w4A5;
	}

	public void setW4A5(String w4a5) {
		w4A5 = w4a5;
	}

	public String getW7A5() {
		return w7A5;
	}

	public void setW7A5(String w7a5) {
		w7A5 = w7a5;
	}

	public String getW3A5() {
		return w3A5;
	}

	public void setW3A5(String w3a5) {
		w3A5 = w3a5;
	}

	public String getW6A5() {
		return w6A5;
	}

	public void setW6A5(String w6a5) {
		w6A5 = w6a5;
	}

	public String getW2A5() {
		return w2A5;
	}

	public void setW2A5(String w2a5) {
		w2A5 = w2a5;
	}

	public String getW9A5() {
		return w9A5;
	}

	public void setW9A5(String w9a5) {
		w9A5 = w9a5;
	}

	public String getW8A5() {
		return w8A5;
	}

	public void setW8A5(String w8a5) {
		w8A5 = w8a5;
	}
}

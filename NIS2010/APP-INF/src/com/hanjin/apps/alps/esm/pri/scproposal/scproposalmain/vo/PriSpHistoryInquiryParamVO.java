/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriEdiScGenInfVO.java
*@FileTitle : PriEdiScGenInfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2009.10.23 이석준 
* 1.0 Creation 
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이석준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpHistoryInquiryParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpHistoryInquiryParamVO> models = new ArrayList<PriSpHistoryInquiryParamVO>();
	
	/* Column Info */
	private String conFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSpHistoryInquiryParamVO() {}

	public PriSpHistoryInquiryParamVO(String conFlg) {
		this.conFlg = conFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("con_flg", getConFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("con_flg", "conFlg");
		return this.hashFields;
	}
	

	public String getConFlg() {
		return conFlg;
	}

	public void setConFlg(String conFlg) {
		this.conFlg = conFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setConFlg(JSPUtil.getParameter(request, "con_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriEdiScGenInfVO[]
	 */
	public PriSpHistoryInquiryParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriEdiScGenInfVO[]
	 */
	public PriSpHistoryInquiryParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpHistoryInquiryParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] conFlg = (JSPUtil.getParameter(request, prefix	+ "con_flg", length));			
			
			for (int i = 0; i < length; i++) {
				model = new PriSpHistoryInquiryParamVO();
				if (conFlg[i] != null)
					model.setConFlg(conFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpHistoryInquiryParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpHistoryInquiryParamVO[]
	 */
	public PriSpHistoryInquiryParamVO[] getPriSpHistoryInquiryParamVOs(){
		PriSpHistoryInquiryParamVO[] vos = (PriSpHistoryInquiryParamVO[])models.toArray(new PriSpHistoryInquiryParamVO[models.size()]);
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
		this.conFlg = this.conFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

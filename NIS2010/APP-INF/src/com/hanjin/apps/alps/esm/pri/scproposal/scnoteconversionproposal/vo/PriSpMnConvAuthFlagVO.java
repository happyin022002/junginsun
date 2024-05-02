/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : PriSpMnConvAuthFlagVO.java
*@FileTitle : PriSpMnConvAuthFlagVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.17 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo;

import java.lang.reflect.Field;
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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpMnConvAuthFlagVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpMnConvAuthFlagVO> models = new ArrayList<PriSpMnConvAuthFlagVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcAuthYn = null;
	/* Column Info */
	private String reqUsrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriSpMnConvAuthFlagVO() {}

	public PriSpMnConvAuthFlagVO(String ibflag, String pagerows, String reqUsrFlg, String ofcAuthYn) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ofcAuthYn = ofcAuthYn;
		this.reqUsrFlg = reqUsrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_auth_yn", getOfcAuthYn());
		this.hashColumns.put("req_usr_flg", getReqUsrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_auth_yn", "ofcAuthYn");
		this.hashFields.put("req_usr_flg", "reqUsrFlg");
		return this.hashFields;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return ofcAuthYn
	 */
	public String getOfcAuthYn() {
		return this.ofcAuthYn;
	}
	
	/**
	 * Column Info
	 * @return reqUsrFlg
	 */
	public String getReqUsrFlg() {
		return this.reqUsrFlg;
	}
	

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param ofcAuthYn
	 */
	public void setOfcAuthYn(String ofcAuthYn) {
		this.ofcAuthYn = ofcAuthYn;
	}
	
	/**
	 * Column Info
	 * @param reqUsrFlg
	 */
	public void setReqUsrFlg(String reqUsrFlg) {
		this.reqUsrFlg = reqUsrFlg;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcAuthYn(JSPUtil.getParameter(request, prefix + "ofc_auth_yn", ""));
		setReqUsrFlg(JSPUtil.getParameter(request, prefix + "req_usr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpMnConvAuthFlagVO[]
	 */
	public PriSpMnConvAuthFlagVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpMnConvAuthFlagVO[]
	 */
	public PriSpMnConvAuthFlagVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpMnConvAuthFlagVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcAuthYn = (JSPUtil.getParameter(request, prefix	+ "ofc_auth_yn", length));
			String[] reqUsrFlg = (JSPUtil.getParameter(request, prefix	+ "req_usr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpMnConvAuthFlagVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcAuthYn[i] != null)
					model.setOfcAuthYn(ofcAuthYn[i]);
				if (reqUsrFlg[i] != null)
					model.setReqUsrFlg(reqUsrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpMnConvAuthFlagVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpMnConvAuthFlagVO[]
	 */
	public PriSpMnConvAuthFlagVO[] getPriSpMnConvAuthFlagVOs(){
		PriSpMnConvAuthFlagVO[] vos = (PriSpMnConvAuthFlagVO[])models.toArray(new PriSpMnConvAuthFlagVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAuthYn = this.ofcAuthYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrFlg = this.reqUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

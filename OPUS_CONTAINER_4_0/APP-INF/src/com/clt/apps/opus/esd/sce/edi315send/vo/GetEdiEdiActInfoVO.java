/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetEdiEdiActInfoVO.java
*@FileTitle : GetEdiEdiActInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.07 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/** 삭제 예정.... 
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetEdiEdiActInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetEdiEdiActInfoVO> models = new ArrayList<GetEdiEdiActInfoVO>();
	
	/* Column Info */
	private String num = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newEdiSts = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetEdiEdiActInfoVO() {}

	public GetEdiEdiActInfoVO(String ibflag, String pagerows, String num, String newEdiSts) {
		this.num = num;
		this.ibflag = ibflag;
		this.newEdiSts = newEdiSts;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_edi_sts", getNewEdiSts());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("num", "num");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_edi_sts", "newEdiSts");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return num
	 */
	public String getNum() {
		return this.num;
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
	 * @return newEdiSts
	 */
	public String getNewEdiSts() {
		return this.newEdiSts;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Column Info
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
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
	 * @param newEdiSts
	 */
	public void setNewEdiSts(String newEdiSts) {
		this.newEdiSts = newEdiSts;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNum(JSPUtil.getParameter(request, "num", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewEdiSts(JSPUtil.getParameter(request, "new_edi_sts", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetEdiEdiActInfoVO[]
	 */
	public GetEdiEdiActInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetEdiEdiActInfoVO[]
	 */
	public GetEdiEdiActInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetEdiEdiActInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newEdiSts = (JSPUtil.getParameter(request, prefix	+ "new_edi_sts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetEdiEdiActInfoVO();
				if (num[i] != null)
					model.setNum(num[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newEdiSts[i] != null)
					model.setNewEdiSts(newEdiSts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetEdiEdiActInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetEdiEdiActInfoVO[]
	 */
	public GetEdiEdiActInfoVO[] getGetEdiEdiActInfoVOs(){
		GetEdiEdiActInfoVO[] vos = (GetEdiEdiActInfoVO[])models.toArray(new GetEdiEdiActInfoVO[models.size()]);
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
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEdiSts = this.newEdiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

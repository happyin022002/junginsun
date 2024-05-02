/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GetRailTermVO.java
*@FileTitle : GetRailTermVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.08 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

import java.lang.reflect.Field;
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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetRailTermVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetRailTermVO> models = new ArrayList<GetRailTermVO>();
	
	/* Column Info */
	private String oanTermSeq = null;
	/* Column Info */
	private String railCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetRailTermVO() {}

	public GetRailTermVO(String ibflag, String pagerows, String railCnt, String oanTermSeq) {
		this.oanTermSeq = oanTermSeq;
		this.railCnt = railCnt;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oan_term_seq", getOanTermSeq());
		this.hashColumns.put("rail_cnt", getRailCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oan_term_seq", "oanTermSeq");
		this.hashFields.put("rail_cnt", "railCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oanTermSeq
	 */
	public String getOanTermSeq() {
		return this.oanTermSeq;
	}
	
	/**
	 * Column Info
	 * @return railCnt
	 */
	public String getRailCnt() {
		return this.railCnt;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param oanTermSeq
	 */
	public void setOanTermSeq(String oanTermSeq) {
		this.oanTermSeq = oanTermSeq;
	}
	
	/**
	 * Column Info
	 * @param railCnt
	 */
	public void setRailCnt(String railCnt) {
		this.railCnt = railCnt;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOanTermSeq(JSPUtil.getParameter(request, prefix + "oan_term_seq", ""));
		setRailCnt(JSPUtil.getParameter(request, prefix + "rail_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetRailTermVO[]
	 */
	public GetRailTermVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetRailTermVO[]
	 */
	public GetRailTermVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetRailTermVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oanTermSeq = (JSPUtil.getParameter(request, prefix	+ "oan_term_seq", length));
			String[] railCnt = (JSPUtil.getParameter(request, prefix	+ "rail_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetRailTermVO();
				if (oanTermSeq[i] != null)
					model.setOanTermSeq(oanTermSeq[i]);
				if (railCnt[i] != null)
					model.setRailCnt(railCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetRailTermVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetRailTermVO[]
	 */
	public GetRailTermVO[] getGetRailTermVOs(){
		GetRailTermVO[] vos = (GetRailTermVO[])models.toArray(new GetRailTermVO[models.size()]);
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
		this.oanTermSeq = this.oanTermSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCnt = this.railCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

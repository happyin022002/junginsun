/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltBlplGcCntVO.java
*@FileTitle : RsltBlplGcCntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.08.03 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltBlplGcCntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltBlplGcCntVO> models = new ArrayList<RsltBlplGcCntVO>();
	
	/* Column Info */
	private String blplCtntMnsCnt = null;
	/* Column Info */
	private String blplCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blplCtntCnt = null;
	/* Column Info */
	private String blplMnsCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltBlplGcCntVO() {}

	public RsltBlplGcCntVO(String ibflag, String pagerows, String blplCnt, String blplCtntCnt, String blplMnsCnt, String blplCtntMnsCnt) {
		this.blplCtntMnsCnt = blplCtntMnsCnt;
		this.blplCnt = blplCnt;
		this.ibflag = ibflag;
		this.blplCtntCnt = blplCtntCnt;
		this.blplMnsCnt = blplMnsCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("blpl_ctnt_mns_cnt", getBlplCtntMnsCnt());
		this.hashColumns.put("blpl_cnt", getBlplCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("blpl_ctnt_cnt", getBlplCtntCnt());
		this.hashColumns.put("blpl_mns_cnt", getBlplMnsCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("blpl_ctnt_mns_cnt", "blplCtntMnsCnt");
		this.hashFields.put("blpl_cnt", "blplCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("blpl_ctnt_cnt", "blplCtntCnt");
		this.hashFields.put("blpl_mns_cnt", "blplMnsCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blplCtntMnsCnt
	 */
	public String getBlplCtntMnsCnt() {
		return this.blplCtntMnsCnt;
	}
	
	/**
	 * Column Info
	 * @return blplCnt
	 */
	public String getBlplCnt() {
		return this.blplCnt;
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
	 * @return blplCtntCnt
	 */
	public String getBlplCtntCnt() {
		return this.blplCtntCnt;
	}
	
	/**
	 * Column Info
	 * @return blplMnsCnt
	 */
	public String getBlplMnsCnt() {
		return this.blplMnsCnt;
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
	 * @param blplCtntMnsCnt
	 */
	public void setBlplCtntMnsCnt(String blplCtntMnsCnt) {
		this.blplCtntMnsCnt = blplCtntMnsCnt;
	}
	
	/**
	 * Column Info
	 * @param blplCnt
	 */
	public void setBlplCnt(String blplCnt) {
		this.blplCnt = blplCnt;
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
	 * @param blplCtntCnt
	 */
	public void setBlplCtntCnt(String blplCtntCnt) {
		this.blplCtntCnt = blplCtntCnt;
	}
	
	/**
	 * Column Info
	 * @param blplMnsCnt
	 */
	public void setBlplMnsCnt(String blplMnsCnt) {
		this.blplMnsCnt = blplMnsCnt;
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
		setBlplCtntMnsCnt(JSPUtil.getParameter(request, prefix + "blpl_ctnt_mns_cnt", ""));
		setBlplCnt(JSPUtil.getParameter(request, prefix + "blpl_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlplCtntCnt(JSPUtil.getParameter(request, prefix + "blpl_ctnt_cnt", ""));
		setBlplMnsCnt(JSPUtil.getParameter(request, prefix + "blpl_mns_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltBlplGcCntVO[]
	 */
	public RsltBlplGcCntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltBlplGcCntVO[]
	 */
	public RsltBlplGcCntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltBlplGcCntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blplCtntMnsCnt = (JSPUtil.getParameter(request, prefix	+ "blpl_ctnt_mns_cnt", length));
			String[] blplCnt = (JSPUtil.getParameter(request, prefix	+ "blpl_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blplCtntCnt = (JSPUtil.getParameter(request, prefix	+ "blpl_ctnt_cnt", length));
			String[] blplMnsCnt = (JSPUtil.getParameter(request, prefix	+ "blpl_mns_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltBlplGcCntVO();
				if (blplCtntMnsCnt[i] != null)
					model.setBlplCtntMnsCnt(blplCtntMnsCnt[i]);
				if (blplCnt[i] != null)
					model.setBlplCnt(blplCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blplCtntCnt[i] != null)
					model.setBlplCtntCnt(blplCtntCnt[i]);
				if (blplMnsCnt[i] != null)
					model.setBlplMnsCnt(blplMnsCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltBlplGcCntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltBlplGcCntVO[]
	 */
	public RsltBlplGcCntVO[] getRsltBlplGcCntVOs(){
		RsltBlplGcCntVO[] vos = (RsltBlplGcCntVO[])models.toArray(new RsltBlplGcCntVO[models.size()]);
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
		this.blplCtntMnsCnt = this.blplCtntMnsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplCnt = this.blplCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplCtntCnt = this.blplCtntCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplMnsCnt = this.blplMnsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

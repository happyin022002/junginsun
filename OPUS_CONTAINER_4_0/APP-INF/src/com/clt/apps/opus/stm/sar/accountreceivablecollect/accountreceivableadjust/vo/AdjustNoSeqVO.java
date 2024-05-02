/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustNoSeqVO.java
*@FileTitle : AdjustNoSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdjustNoSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjustNoSeqVO> models = new ArrayList<AdjustNoSeqVO>();
	
	/* Column Info */
	private String otsAdjSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adjKeyNo = null;
	/* Column Info */
	private String adjNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdjustNoSeqVO() {}

	public AdjustNoSeqVO(String ibflag, String pagerows, String otsAdjSeq, String adjNo, String adjKeyNo) {
		this.otsAdjSeq = otsAdjSeq;
		this.ibflag = ibflag;
		this.adjKeyNo = adjKeyNo;
		this.adjNo = adjNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ots_adj_seq", getOtsAdjSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adj_key_no", getAdjKeyNo());
		this.hashColumns.put("adj_no", getAdjNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ots_adj_seq", "otsAdjSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adj_key_no", "adjKeyNo");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otsAdjSeq
	 */
	public String getOtsAdjSeq() {
		return this.otsAdjSeq;
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
	 * @return adjKeyNo
	 */
	public String getAdjKeyNo() {
		return this.adjKeyNo;
	}
	
	/**
	 * Column Info
	 * @return adjNo
	 */
	public String getAdjNo() {
		return this.adjNo;
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
	 * @param otsAdjSeq
	 */
	public void setOtsAdjSeq(String otsAdjSeq) {
		this.otsAdjSeq = otsAdjSeq;
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
	 * @param adjKeyNo
	 */
	public void setAdjKeyNo(String adjKeyNo) {
		this.adjKeyNo = adjKeyNo;
	}
	
	/**
	 * Column Info
	 * @param adjNo
	 */
	public void setAdjNo(String adjNo) {
		this.adjNo = adjNo;
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
		setOtsAdjSeq(JSPUtil.getParameter(request, prefix + "ots_adj_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAdjKeyNo(JSPUtil.getParameter(request, prefix + "adj_key_no", ""));
		setAdjNo(JSPUtil.getParameter(request, prefix + "adj_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustNoSeqVO[]
	 */
	public AdjustNoSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustNoSeqVO[]
	 */
	public AdjustNoSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjustNoSeqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otsAdjSeq = (JSPUtil.getParameter(request, prefix	+ "ots_adj_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adjKeyNo = (JSPUtil.getParameter(request, prefix	+ "adj_key_no", length));
			String[] adjNo = (JSPUtil.getParameter(request, prefix	+ "adj_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjustNoSeqVO();
				if (otsAdjSeq[i] != null)
					model.setOtsAdjSeq(otsAdjSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adjKeyNo[i] != null)
					model.setAdjKeyNo(adjKeyNo[i]);
				if (adjNo[i] != null)
					model.setAdjNo(adjNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjustNoSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustNoSeqVO[]
	 */
	public AdjustNoSeqVO[] getAdjustNoSeqVOs(){
		AdjustNoSeqVO[] vos = (AdjustNoSeqVO[])models.toArray(new AdjustNoSeqVO[models.size()]);
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
		this.otsAdjSeq = this.otsAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjKeyNo = this.adjKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo = this.adjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

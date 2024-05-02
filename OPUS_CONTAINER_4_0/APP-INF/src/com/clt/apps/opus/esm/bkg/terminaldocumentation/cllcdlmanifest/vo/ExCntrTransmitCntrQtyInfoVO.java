/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExCntrTransmitCntrQtyInfoVO.java
*@FileTitle : ExCntrTransmitCntrQtyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.23
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class ExCntrTransmitCntrQtyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ExCntrTransmitCntrQtyInfoVO> models = new ArrayList<ExCntrTransmitCntrQtyInfoVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qtywgt = null;
	/* Column Info */
	private String count = null;
	/* Column Info */
	private String hantype = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ExCntrTransmitCntrQtyInfoVO() {}

	public ExCntrTransmitCntrQtyInfoVO(String ibflag, String pagerows, String hantype, String count, String qtywgt) {
		this.ibflag = ibflag;
		this.qtywgt = qtywgt;
		this.count = count;
		this.hantype = hantype;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qtywgt", getQtywgt());
		this.hashColumns.put("count", getCount());
		this.hashColumns.put("hantype", getHantype());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qtywgt", "qtywgt");
		this.hashFields.put("count", "count");
		this.hashFields.put("hantype", "hantype");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return qtywgt
	 */
	public String getQtywgt() {
		return this.qtywgt;
	}

	/**
	 * Column Info
	 * @return count
	 */
	public String getCount() {
		return this.count;
	}

	/**
	 * Column Info
	 * @return hantype
	 */
	public String getHantype() {
		return this.hantype;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param qtywgt
	 */
	public void setQtywgt(String qtywgt) {
		this.qtywgt = qtywgt;
	}

	/**
	 * Column Info
	 * @param count
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * Column Info
	 * @param hantype
	 */
	public void setHantype(String hantype) {
		this.hantype = hantype;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setQtywgt(JSPUtil.getParameter(request, "qtywgt", ""));
		setCount(JSPUtil.getParameter(request, "count", ""));
		setHantype(JSPUtil.getParameter(request, "hantype", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExCntrTransmitCntrQtyInfoVO[]
	 */
	public ExCntrTransmitCntrQtyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExCntrTransmitCntrQtyInfoVO[]
	 */
	public ExCntrTransmitCntrQtyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExCntrTransmitCntrQtyInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qtywgt = (JSPUtil.getParameter(request, prefix	+ "qtywgt", length));
			String[] count = (JSPUtil.getParameter(request, prefix	+ "count", length));
			String[] hantype = (JSPUtil.getParameter(request, prefix	+ "hantype", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ExCntrTransmitCntrQtyInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qtywgt[i] != null)
					model.setQtywgt(qtywgt[i]);
				if (count[i] != null)
					model.setCount(count[i]);
				if (hantype[i] != null)
					model.setHantype(hantype[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExCntrTransmitCntrQtyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExCntrTransmitCntrQtyInfoVO[]
	 */
	public ExCntrTransmitCntrQtyInfoVO[] getExCntrTransmitCntrQtyInfoVOs(){
		ExCntrTransmitCntrQtyInfoVO[] vos = (ExCntrTransmitCntrQtyInfoVO[])models.toArray(new ExCntrTransmitCntrQtyInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtywgt = this.qtywgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count = this.count .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hantype = this.hantype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

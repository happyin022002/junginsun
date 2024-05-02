/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorFullEmpSumVO.java
*@FileTitle : KorFullEmpSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.19 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorFullEmpSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorFullEmpSumVO> models = new ArrayList<KorFullEmpSumVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntEmpty = null;
	/* Column Info */
	private String cntFull = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorFullEmpSumVO() {}

	public KorFullEmpSumVO(String ibflag, String pagerows, String cntFull, String cntEmpty) {
		this.ibflag = ibflag;
		this.cntEmpty = cntEmpty;
		this.cntFull = cntFull;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_empty", getCntEmpty());
		this.hashColumns.put("cnt_full", getCntFull());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_empty", "cntEmpty");
		this.hashFields.put("cnt_full", "cntFull");
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
	 * @return cntEmpty
	 */
	public String getCntEmpty() {
		return this.cntEmpty;
	}

	/**
	 * Column Info
	 * @return cntFull
	 */
	public String getCntFull() {
		return this.cntFull;
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
	 * @param cntEmpty
	 */
	public void setCntEmpty(String cntEmpty) {
		this.cntEmpty = cntEmpty;
	}

	/**
	 * Column Info
	 * @param cntFull
	 */
	public void setCntFull(String cntFull) {
		this.cntFull = cntFull;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntEmpty(JSPUtil.getParameter(request, prefix + "cnt_empty", ""));
		setCntFull(JSPUtil.getParameter(request, prefix + "cnt_full", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorFullEmpSumVO[]
	 */
	public KorFullEmpSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorFullEmpSumVO[]
	 */
	public KorFullEmpSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorFullEmpSumVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntEmpty = (JSPUtil.getParameter(request, prefix	+ "cnt_empty", length));
			String[] cntFull = (JSPUtil.getParameter(request, prefix	+ "cnt_full", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorFullEmpSumVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntEmpty[i] != null)
					model.setCntEmpty(cntEmpty[i]);
				if (cntFull[i] != null)
					model.setCntFull(cntFull[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorFullEmpSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorFullEmpSumVO[]
	 */
	public KorFullEmpSumVO[] getKorFullEmpSumVOs(){
		KorFullEmpSumVO[] vos = (KorFullEmpSumVO[])models.toArray(new KorFullEmpSumVO[models.size()]);
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
		this.cntEmpty = this.cntEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntFull = this.cntFull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

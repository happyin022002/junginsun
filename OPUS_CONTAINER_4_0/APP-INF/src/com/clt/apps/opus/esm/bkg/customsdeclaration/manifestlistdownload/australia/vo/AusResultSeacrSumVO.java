/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusResultSeacrSumVO.java
*@FileTitle : AusResultSeacrSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier :
*@LastVersion : 1.0
* 2014.12.17
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo;

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

public class AusResultSeacrSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AusResultSeacrSumVO> models = new ArrayList<AusResultSeacrSumVO>();

	/* Column Info */
	private String sentCnt = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sentErrCnt = null;
	/* Column Info */
	private String sentAccCnt = null;
	/* Column Info */
	private String blCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public AusResultSeacrSumVO() {}

	public AusResultSeacrSumVO(String ibflag, String pagerows, String podCd, String blCnt, String sentCnt, String sentAccCnt, String sentErrCnt) {
		this.sentCnt = sentCnt;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.sentErrCnt = sentErrCnt;
		this.sentAccCnt = sentAccCnt;
		this.blCnt = blCnt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sent_cnt", getSentCnt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sent_err_cnt", getSentErrCnt());
		this.hashColumns.put("sent_acc_cnt", getSentAccCnt());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sent_cnt", "sentCnt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sent_err_cnt", "sentErrCnt");
		this.hashFields.put("sent_acc_cnt", "sentAccCnt");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return sentCnt
	 */
	public String getSentCnt() {
		return this.sentCnt;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return sentErrCnt
	 */
	public String getSentErrCnt() {
		return this.sentErrCnt;
	}

	/**
	 * Column Info
	 * @return sentAccCnt
	 */
	public String getSentAccCnt() {
		return this.sentAccCnt;
	}

	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
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
	 * @param sentCnt
	 */
	public void setSentCnt(String sentCnt) {
		this.sentCnt = sentCnt;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param sentErrCnt
	 */
	public void setSentErrCnt(String sentErrCnt) {
		this.sentErrCnt = sentErrCnt;
	}

	/**
	 * Column Info
	 * @param sentAccCnt
	 */
	public void setSentAccCnt(String sentAccCnt) {
		this.sentAccCnt = sentAccCnt;
	}

	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setSentCnt(JSPUtil.getParameter(request, prefix + "sent_cnt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSentErrCnt(JSPUtil.getParameter(request, prefix + "sent_err_cnt", ""));
		setSentAccCnt(JSPUtil.getParameter(request, prefix + "sent_acc_cnt", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusResultSeacrSumVO[]
	 */
	public AusResultSeacrSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AusResultSeacrSumVO[]
	 */
	public AusResultSeacrSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusResultSeacrSumVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sentCnt = (JSPUtil.getParameter(request, prefix	+ "sent_cnt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sentErrCnt = (JSPUtil.getParameter(request, prefix	+ "sent_err_cnt", length));
			String[] sentAccCnt = (JSPUtil.getParameter(request, prefix	+ "sent_acc_cnt", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new AusResultSeacrSumVO();
				if (sentCnt[i] != null)
					model.setSentCnt(sentCnt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sentErrCnt[i] != null)
					model.setSentErrCnt(sentErrCnt[i]);
				if (sentAccCnt[i] != null)
					model.setSentAccCnt(sentAccCnt[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusResultSeacrSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusResultSeacrSumVO[]
	 */
	public AusResultSeacrSumVO[] getAusResultSeacrSumVOs(){
		AusResultSeacrSumVO[] vos = (AusResultSeacrSumVO[])models.toArray(new AusResultSeacrSumVO[models.size()]);
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
		this.sentCnt = this.sentCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentErrCnt = this.sentErrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentAccCnt = this.sentAccCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

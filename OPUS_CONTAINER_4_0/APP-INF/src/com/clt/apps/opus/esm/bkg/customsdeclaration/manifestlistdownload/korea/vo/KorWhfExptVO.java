/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorWhfExptVO.java
*@FileTitle : KorWhfExptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.18 박상훈
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

public class KorWhfExptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorWhfExptVO> models = new ArrayList<KorWhfExptVO>();

	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgRtWhfExptCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String whfShprRgstNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorWhfExptVO() {}

	public KorWhfExptVO(String ibflag, String pagerows, String bkgRtWhfExptCd, String whfShprRgstNo, String cltOfcCd, String bkgNo) {
		this.bkgNo = bkgNo;
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
		this.ibflag = ibflag;
		this.cltOfcCd = cltOfcCd;
		this.whfShprRgstNo = whfShprRgstNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_rt_whf_expt_cd", getBkgRtWhfExptCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("whf_shpr_rgst_no", getWhfShprRgstNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_rt_whf_expt_cd", "bkgRtWhfExptCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("whf_shpr_rgst_no", "whfShprRgstNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return bkgRtWhfExptCd
	 */
	public String getBkgRtWhfExptCd() {
		return this.bkgRtWhfExptCd;
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
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}

	/**
	 * Column Info
	 * @return whfShprRgstNo
	 */
	public String getWhfShprRgstNo() {
		return this.whfShprRgstNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param bkgRtWhfExptCd
	 */
	public void setBkgRtWhfExptCd(String bkgRtWhfExptCd) {
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
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
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}

	/**
	 * Column Info
	 * @param whfShprRgstNo
	 */
	public void setWhfShprRgstNo(String whfShprRgstNo) {
		this.whfShprRgstNo = whfShprRgstNo;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgRtWhfExptCd(JSPUtil.getParameter(request, "bkg_rt_whf_expt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCltOfcCd(JSPUtil.getParameter(request, "clt_ofc_cd", ""));
		setWhfShprRgstNo(JSPUtil.getParameter(request, "whf_shpr_rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorWhfExptVO[]
	 */
	public KorWhfExptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorWhfExptVO[]
	 */
	public KorWhfExptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorWhfExptVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgRtWhfExptCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rt_whf_expt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] whfShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "whf_shpr_rgst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorWhfExptVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgRtWhfExptCd[i] != null)
					model.setBkgRtWhfExptCd(bkgRtWhfExptCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (whfShprRgstNo[i] != null)
					model.setWhfShprRgstNo(whfShprRgstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorWhfExptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorWhfExptVO[]
	 */
	public KorWhfExptVO[] getKorWhfExptVOs(){
		KorWhfExptVO[] vos = (KorWhfExptVO[])models.toArray(new KorWhfExptVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRtWhfExptCd = this.bkgRtWhfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfShprRgstNo = this.whfShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

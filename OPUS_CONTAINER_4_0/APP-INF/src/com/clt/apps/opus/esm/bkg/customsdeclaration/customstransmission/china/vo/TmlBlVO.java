/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TmlBlVO.java
*@FileTitle : TmlBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier :
*@LastVersion : 1.0
* 2009.11.17
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

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

public class TmlBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TmlBlVO> models = new ArrayList<TmlBlVO>();

	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String blPolName = null;
	/* Column Info */
	private String blPodName = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blPod = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cgoDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blDelName = null;
	/* Column Info */
	private String blPol = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String blDel = null;
	/* Column Info */
	private String shpr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TmlBlVO() {}

	public TmlBlVO(String ibflag, String pagerows, String blNo, String bkgNo, String blPol, String blPolName, String blPod, String blPodName, String blDel, String blDelName, String shpr, String cnee, String ntfy, String cgoDesc) {
		this.ntfy = ntfy;
		this.blPolName = blPolName;
		this.blPodName = blPodName;
		this.blNo = blNo;
		this.blPod = blPod;
		this.pagerows = pagerows;
		this.cgoDesc = cgoDesc;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.blDelName = blDelName;
		this.blPol = blPol;
		this.cnee = cnee;
		this.blDel = blDel;
		this.shpr = shpr;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("bl_pol_name", getBlPolName());
		this.hashColumns.put("bl_pod_name", getBlPodName());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_pod", getBlPod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cgo_desc", getCgoDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_del_name", getBlDelName());
		this.hashColumns.put("bl_pol", getBlPol());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("bl_del", getBlDel());
		this.hashColumns.put("shpr", getShpr());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("bl_pol_name", "blPolName");
		this.hashFields.put("bl_pod_name", "blPodName");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_pod", "blPod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cgo_desc", "cgoDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_del_name", "blDelName");
		this.hashFields.put("bl_pol", "blPol");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("bl_del", "blDel");
		this.hashFields.put("shpr", "shpr");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}

	/**
	 * Column Info
	 * @return blPolName
	 */
	public String getBlPolName() {
		return this.blPolName;
	}

	/**
	 * Column Info
	 * @return blPodName
	 */
	public String getBlPodName() {
		return this.blPodName;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return blPod
	 */
	public String getBlPod() {
		return this.blPod;
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
	 * @return cgoDesc
	 */
	public String getCgoDesc() {
		return this.cgoDesc;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return blDelName
	 */
	public String getBlDelName() {
		return this.blDelName;
	}

	/**
	 * Column Info
	 * @return blPol
	 */
	public String getBlPol() {
		return this.blPol;
	}

	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}

	/**
	 * Column Info
	 * @return blDel
	 */
	public String getBlDel() {
		return this.blDel;
	}

	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}


	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}

	/**
	 * Column Info
	 * @param blPolName
	 */
	public void setBlPolName(String blPolName) {
		this.blPolName = blPolName;
	}

	/**
	 * Column Info
	 * @param blPodName
	 */
	public void setBlPodName(String blPodName) {
		this.blPodName = blPodName;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param blPod
	 */
	public void setBlPod(String blPod) {
		this.blPod = blPod;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * @param cgoDesc
	 */
	public void setCgoDesc(String cgoDesc) {
		this.cgoDesc = cgoDesc;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param blDelName
	 */
	public void setBlDelName(String blDelName) {
		this.blDelName = blDelName;
	}

	/**
	 * Column Info
	 * @param blPol
	 */
	public void setBlPol(String blPol) {
		this.blPol = blPol;
	}

	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}

	/**
	 * Column Info
	 * @param blDel
	 */
	public void setBlDel(String blDel) {
		this.blDel = blDel;
	}

	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setBlPolName(JSPUtil.getParameter(request, "bl_pol_name", ""));
		setBlPodName(JSPUtil.getParameter(request, "bl_pod_name", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlPod(JSPUtil.getParameter(request, "bl_pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCgoDesc(JSPUtil.getParameter(request, "cgo_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBlDelName(JSPUtil.getParameter(request, "bl_del_name", ""));
		setBlPol(JSPUtil.getParameter(request, "bl_pol", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setBlDel(JSPUtil.getParameter(request, "bl_del", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmlBlVO[]
	 */
	public TmlBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TmlBlVO[]
	 */
	public TmlBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmlBlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] blPolName = (JSPUtil.getParameter(request, prefix	+ "bl_pol_name", length));
			String[] blPodName = (JSPUtil.getParameter(request, prefix	+ "bl_pod_name", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blPod = (JSPUtil.getParameter(request, prefix	+ "bl_pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cgoDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blDelName = (JSPUtil.getParameter(request, prefix	+ "bl_del_name", length));
			String[] blPol = (JSPUtil.getParameter(request, prefix	+ "bl_pol", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] blDel = (JSPUtil.getParameter(request, prefix	+ "bl_del", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));

			for (int i = 0; i < length; i++) {
				model = new TmlBlVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (blPolName[i] != null)
					model.setBlPolName(blPolName[i]);
				if (blPodName[i] != null)
					model.setBlPodName(blPodName[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blPod[i] != null)
					model.setBlPod(blPod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cgoDesc[i] != null)
					model.setCgoDesc(cgoDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blDelName[i] != null)
					model.setBlDelName(blDelName[i]);
				if (blPol[i] != null)
					model.setBlPol(blPol[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (blDel[i] != null)
					model.setBlDel(blDel[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmlBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmlBlVO[]
	 */
	public TmlBlVO[] getTmlBlVOs(){
		TmlBlVO[] vos = (TmlBlVO[])models.toArray(new TmlBlVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPolName = this.blPolName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPodName = this.blPodName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPod = this.blPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc = this.cgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDelName = this.blDelName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPol = this.blPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDel = this.blDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

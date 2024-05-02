/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgCstmsMySndLogVO.java
*@FileTitle : BkgCstmsMySndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsMySndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsMySndLogVO> models = new ArrayList<BkgCstmsMySndLogVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String ttlCntrKnt = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String myMfSndIndCd = null;
	/* Column Info */
	private String blKnt = null;
	/* Column Info */
	private String myCstmsBndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsMySndLogVO() {}

	public BkgCstmsMySndLogVO(String ibflag, String pagerows, String myMfSndIndCd, String fltFileRefNo, String vvd, String polCd, String podCd, String myCstmsBndCd, String ofcCd, String blKnt, String ttlCntrKnt, String usrId) {
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.ttlCntrKnt = ttlCntrKnt;
		this.fltFileRefNo = fltFileRefNo;
		this.myMfSndIndCd = myMfSndIndCd;
		this.blKnt = blKnt;
		this.myCstmsBndCd = myCstmsBndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ttl_cntr_knt", getTtlCntrKnt());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("my_mf_snd_ind_cd", getMyMfSndIndCd());
		this.hashColumns.put("bl_knt", getBlKnt());
		this.hashColumns.put("my_cstms_bnd_cd", getMyCstmsBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ttl_cntr_knt", "ttlCntrKnt");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("my_mf_snd_ind_cd", "myMfSndIndCd");
		this.hashFields.put("bl_knt", "blKnt");
		this.hashFields.put("my_cstms_bnd_cd", "myCstmsBndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrKnt
	 */
	public String getTtlCntrKnt() {
		return this.ttlCntrKnt;
	}
	
	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @return myMfSndIndCd
	 */
	public String getMyMfSndIndCd() {
		return this.myMfSndIndCd;
	}
	
	/**
	 * Column Info
	 * @return blKnt
	 */
	public String getBlKnt() {
		return this.blKnt;
	}
	
	/**
	 * Column Info
	 * @return myCstmsBndCd
	 */
	public String getMyCstmsBndCd() {
		return this.myCstmsBndCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrKnt
	 */
	public void setTtlCntrKnt(String ttlCntrKnt) {
		this.ttlCntrKnt = ttlCntrKnt;
	}
	
	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @param myMfSndIndCd
	 */
	public void setMyMfSndIndCd(String myMfSndIndCd) {
		this.myMfSndIndCd = myMfSndIndCd;
	}
	
	/**
	 * Column Info
	 * @param blKnt
	 */
	public void setBlKnt(String blKnt) {
		this.blKnt = blKnt;
	}
	
	/**
	 * Column Info
	 * @param myCstmsBndCd
	 */
	public void setMyCstmsBndCd(String myCstmsBndCd) {
		this.myCstmsBndCd = myCstmsBndCd;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setTtlCntrKnt(JSPUtil.getParameter(request, prefix + "ttl_cntr_knt", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setMyMfSndIndCd(JSPUtil.getParameter(request, prefix + "my_mf_snd_ind_cd", ""));
		setBlKnt(JSPUtil.getParameter(request, prefix + "bl_knt", ""));
		setMyCstmsBndCd(JSPUtil.getParameter(request, prefix + "my_cstms_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsMySndLogVO[]
	 */
	public BkgCstmsMySndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsMySndLogVO[]
	 */
	public BkgCstmsMySndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsMySndLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] ttlCntrKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_knt", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] myMfSndIndCd = (JSPUtil.getParameter(request, prefix	+ "my_mf_snd_ind_cd", length));
			String[] blKnt = (JSPUtil.getParameter(request, prefix	+ "bl_knt", length));
			String[] myCstmsBndCd = (JSPUtil.getParameter(request, prefix	+ "my_cstms_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsMySndLogVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (ttlCntrKnt[i] != null)
					model.setTtlCntrKnt(ttlCntrKnt[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (myMfSndIndCd[i] != null)
					model.setMyMfSndIndCd(myMfSndIndCd[i]);
				if (blKnt[i] != null)
					model.setBlKnt(blKnt[i]);
				if (myCstmsBndCd[i] != null)
					model.setMyCstmsBndCd(myCstmsBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsMySndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsMySndLogVO[]
	 */
	public BkgCstmsMySndLogVO[] getBkgCstmsMySndLogVOs(){
		BkgCstmsMySndLogVO[] vos = (BkgCstmsMySndLogVO[])models.toArray(new BkgCstmsMySndLogVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrKnt = this.ttlCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.myMfSndIndCd = this.myMfSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKnt = this.blKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.myCstmsBndCd = this.myCstmsBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

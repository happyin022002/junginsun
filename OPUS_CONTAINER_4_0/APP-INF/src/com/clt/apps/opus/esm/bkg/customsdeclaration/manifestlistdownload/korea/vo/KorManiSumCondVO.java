/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManiSumCondVO.java
*@FileTitle : KorManiSumCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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

public class KorManiSumCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorManiSumCondVO> models = new ArrayList<KorManiSumCondVO>();
	
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vvdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorManiSumCondVO() {}

	public KorManiSumCondVO(String ibflag, String pagerows, String inType, String ioBndCd, String mrnNo, String ofcCd, String podCd, String polCd, String polYdCd, String portCd, String tmlCd, String userId, String vvd, String vvdSeq) {
		this.ioBndCd = ioBndCd;
		this.mrnNo = mrnNo;
		this.tmlCd = tmlCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.inType = inType;
		this.polCd = polCd;
		this.polYdCd = polYdCd;
		this.userId = userId;
		this.portCd = portCd;
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
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
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorManiSumCondVO[]
	 */
	public KorManiSumCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorManiSumCondVO[]
	 */
	public KorManiSumCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorManiSumCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorManiSumCondVO();
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorManiSumCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorManiSumCondVO[]
	 */
	public KorManiSumCondVO[] getKorManiSumCondVOs(){
		KorManiSumCondVO[] vos = (KorManiSumCondVO[])models.toArray(new KorManiSumCondVO[models.size()]);
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
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

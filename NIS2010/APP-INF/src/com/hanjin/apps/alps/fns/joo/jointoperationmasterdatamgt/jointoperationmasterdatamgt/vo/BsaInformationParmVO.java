/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BsaInformationParmVO.java
*@FileTitle : BsaInformationParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.03
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.05.03 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaInformationParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaInformationParmVO> models = new ArrayList<BsaInformationParmVO>();
	
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String joEndSkdVoyNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String joStSkdVoyNo = null;
	/* Column Info */
	private String joVerNo = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String oldJoVerNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaInformationParmVO() {}

	public BsaInformationParmVO(String ibflag, String pagerows, String vslCd, String skdDirCd, String portCd, String portSeq, String joCrrCd, String rlaneCd, String joVerNo, String oldJoVerNo, String joStSkdVoyNo, String joEndSkdVoyNo) {
		this.portSeq = portSeq;
		this.vslCd = vslCd;
		this.joEndSkdVoyNo = joEndSkdVoyNo;
		this.ibflag = ibflag;
		this.joStSkdVoyNo = joStSkdVoyNo;
		this.joVerNo = joVerNo;
		this.joCrrCd = joCrrCd;
		this.rlaneCd = rlaneCd;
		this.oldJoVerNo = oldJoVerNo;
		this.portCd = portCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("jo_end_skd_voy_no", getJoEndSkdVoyNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_st_skd_voy_no", getJoStSkdVoyNo());
		this.hashColumns.put("jo_ver_no", getJoVerNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("old_jo_ver_no", getOldJoVerNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("jo_end_skd_voy_no", "joEndSkdVoyNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_st_skd_voy_no", "joStSkdVoyNo");
		this.hashFields.put("jo_ver_no", "joVerNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("old_jo_ver_no", "oldJoVerNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return joEndSkdVoyNo
	 */
	public String getJoEndSkdVoyNo() {
		return this.joEndSkdVoyNo;
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
	 * @return joStSkdVoyNo
	 */
	public String getJoStSkdVoyNo() {
		return this.joStSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return joVerNo
	 */
	public String getJoVerNo() {
		return this.joVerNo;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return oldJoVerNo
	 */
	public String getOldJoVerNo() {
		return this.oldJoVerNo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param joEndSkdVoyNo
	 */
	public void setJoEndSkdVoyNo(String joEndSkdVoyNo) {
		this.joEndSkdVoyNo = joEndSkdVoyNo;
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
	 * @param joStSkdVoyNo
	 */
	public void setJoStSkdVoyNo(String joStSkdVoyNo) {
		this.joStSkdVoyNo = joStSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param joVerNo
	 */
	public void setJoVerNo(String joVerNo) {
		this.joVerNo = joVerNo;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param oldJoVerNo
	 */
	public void setOldJoVerNo(String oldJoVerNo) {
		this.oldJoVerNo = oldJoVerNo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setJoEndSkdVoyNo(JSPUtil.getParameter(request, prefix + "jo_end_skd_voy_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJoStSkdVoyNo(JSPUtil.getParameter(request, prefix + "jo_st_skd_voy_no", ""));
		setJoVerNo(JSPUtil.getParameter(request, prefix + "jo_ver_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setOldJoVerNo(JSPUtil.getParameter(request, prefix + "old_jo_ver_no", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaInformationParmVO[]
	 */
	public BsaInformationParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaInformationParmVO[]
	 */
	public BsaInformationParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaInformationParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] joEndSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "jo_end_skd_voy_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] joStSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "jo_st_skd_voy_no", length));
			String[] joVerNo = (JSPUtil.getParameter(request, prefix	+ "jo_ver_no", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] oldJoVerNo = (JSPUtil.getParameter(request, prefix	+ "old_jo_ver_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaInformationParmVO();
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (joEndSkdVoyNo[i] != null)
					model.setJoEndSkdVoyNo(joEndSkdVoyNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (joStSkdVoyNo[i] != null)
					model.setJoStSkdVoyNo(joStSkdVoyNo[i]);
				if (joVerNo[i] != null)
					model.setJoVerNo(joVerNo[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (oldJoVerNo[i] != null)
					model.setOldJoVerNo(oldJoVerNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaInformationParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaInformationParmVO[]
	 */
	public BsaInformationParmVO[] getBsaInformationParmVOs(){
		BsaInformationParmVO[] vos = (BsaInformationParmVO[])models.toArray(new BsaInformationParmVO[models.size()]);
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
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joEndSkdVoyNo = this.joEndSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStSkdVoyNo = this.joStSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joVerNo = this.joVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldJoVerNo = this.oldJoVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

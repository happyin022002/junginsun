/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesEqr1052ConditionRobVO.java
*@FileTitle : EesEqr1052ConditionRobVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo;

import java.lang.reflect.Field;
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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1052ConditionRobVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1052ConditionRobVO> models = new ArrayList<EesEqr1052ConditionRobVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String checkTurnPort = null;
	/* Column Info */
	private String vvdSize = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String vlBkgNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvdNum = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1052ConditionRobVO() {}

	public EesEqr1052ConditionRobVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vslSeq, String vlBkgNo, String vvdSize, String vvdNum, String checkTurnPort, String podYdCd, String podClptIndSeq) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.checkTurnPort = checkTurnPort;
		this.vvdSize = vvdSize;
		this.podClptIndSeq = podClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.vslSeq = vslSeq;
		this.podYdCd = podYdCd;
		this.vlBkgNo = vlBkgNo;
		this.skdDirCd = skdDirCd;
		this.vvdNum = vvdNum;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("check_turn_port", getCheckTurnPort());
		this.hashColumns.put("vvd_size", getVvdSize());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("vl_bkg_no", getVlBkgNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd_num", getVvdNum());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("check_turn_port", "checkTurnPort");
		this.hashFields.put("vvd_size", "vvdSize");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("vl_bkg_no", "vlBkgNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd_num", "vvdNum");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return checkTurnPort
	 */
	public String getCheckTurnPort() {
		return this.checkTurnPort;
	}
	
	/**
	 * Column Info
	 * @return vvdSize
	 */
	public String getVvdSize() {
		return this.vvdSize;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return vlBkgNo
	 */
	public String getVlBkgNo() {
		return this.vlBkgNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vvdNum
	 */
	public String getVvdNum() {
		return this.vvdNum;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param checkTurnPort
	 */
	public void setCheckTurnPort(String checkTurnPort) {
		this.checkTurnPort = checkTurnPort;
	}
	
	/**
	 * Column Info
	 * @param vvdSize
	 */
	public void setVvdSize(String vvdSize) {
		this.vvdSize = vvdSize;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param vlBkgNo
	 */
	public void setVlBkgNo(String vlBkgNo) {
		this.vlBkgNo = vlBkgNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vvdNum
	 */
	public void setVvdNum(String vvdNum) {
		this.vvdNum = vvdNum;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCheckTurnPort(JSPUtil.getParameter(request, prefix + "check_turn_port", ""));
		setVvdSize(JSPUtil.getParameter(request, prefix + "vvd_size", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setVlBkgNo(JSPUtil.getParameter(request, prefix + "vl_bkg_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvdNum(JSPUtil.getParameter(request, prefix + "vvd_num", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1052ConditionRobVO[]
	 */
	public EesEqr1052ConditionRobVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1052ConditionRobVO[]
	 */
	public EesEqr1052ConditionRobVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1052ConditionRobVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] checkTurnPort = (JSPUtil.getParameter(request, prefix	+ "check_turn_port", length));
			String[] vvdSize = (JSPUtil.getParameter(request, prefix	+ "vvd_size", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] vlBkgNo = (JSPUtil.getParameter(request, prefix	+ "vl_bkg_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvdNum = (JSPUtil.getParameter(request, prefix	+ "vvd_num", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1052ConditionRobVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (checkTurnPort[i] != null)
					model.setCheckTurnPort(checkTurnPort[i]);
				if (vvdSize[i] != null)
					model.setVvdSize(vvdSize[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (vlBkgNo[i] != null)
					model.setVlBkgNo(vlBkgNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvdNum[i] != null)
					model.setVvdNum(vvdNum[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1052ConditionRobVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1052ConditionRobVO[]
	 */
	public EesEqr1052ConditionRobVO[] getEesEqr1052ConditionRobVOs(){
		EesEqr1052ConditionRobVO[] vos = (EesEqr1052ConditionRobVO[])models.toArray(new EesEqr1052ConditionRobVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkTurnPort = this.checkTurnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSize = this.vvdSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlBkgNo = this.vlBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNum = this.vvdNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

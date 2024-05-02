/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Isf5InfoVO.java
*@FileTitle : Isf5InfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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

public class Isf5InfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Isf5InfoVO> models = new ArrayList<Isf5InfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String isfActCd = null;
	/* Column Info */
	private String cstmsRmk3 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String mh = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String hamoCmdtCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Isf5InfoVO() {}

	public Isf5InfoVO(String ibflag, String pagerows, String isfActCd, String cstmsRmk3, String mblNo, String mh, String blNo, String hamoCmdtCd, String cntrNo, String cntrCnt, String cstmsPortCd) {
		this.ibflag = ibflag;
		this.isfActCd = isfActCd;
		this.cstmsRmk3 = cstmsRmk3;
		this.cntrNo = cntrNo;
		this.mblNo = mblNo;
		this.mh = mh;
		this.cntrCnt = cntrCnt;
		this.hamoCmdtCd = hamoCmdtCd;
		this.blNo = blNo;
		this.cstmsPortCd = cstmsPortCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("isf_act_cd", getIsfActCd());
		this.hashColumns.put("cstms_rmk3", getCstmsRmk3());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("mh", getMh());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("hamo_cmdt_cd", getHamoCmdtCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("isf_act_cd", "isfActCd");
		this.hashFields.put("cstms_rmk3", "cstmsRmk3");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("mh", "mh");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("hamo_cmdt_cd", "hamoCmdtCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
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
	 * @return isfActCd
	 */
	public String getIsfActCd() {
		return this.isfActCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsRmk3
	 */
	public String getCstmsRmk3() {
		return this.cstmsRmk3;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return mh
	 */
	public String getMh() {
		return this.mh;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return hamoCmdtCd
	 */
	public String getHamoCmdtCd() {
		return this.hamoCmdtCd;
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
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
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
	 * @param isfActCd
	 */
	public void setIsfActCd(String isfActCd) {
		this.isfActCd = isfActCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsRmk3
	 */
	public void setCstmsRmk3(String cstmsRmk3) {
		this.cstmsRmk3 = cstmsRmk3;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param mh
	 */
	public void setMh(String mh) {
		this.mh = mh;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param hamoCmdtCd
	 */
	public void setHamoCmdtCd(String hamoCmdtCd) {
		this.hamoCmdtCd = hamoCmdtCd;
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
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
		setIsfActCd(JSPUtil.getParameter(request, prefix + "isf_act_cd", ""));
		setCstmsRmk3(JSPUtil.getParameter(request, prefix + "cstms_rmk3", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setMh(JSPUtil.getParameter(request, prefix + "mh", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setHamoCmdtCd(JSPUtil.getParameter(request, prefix + "hamo_cmdt_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Isf5InfoVO[]
	 */
	public Isf5InfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Isf5InfoVO[]
	 */
	public Isf5InfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Isf5InfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] isfActCd = (JSPUtil.getParameter(request, prefix	+ "isf_act_cd", length));
			String[] cstmsRmk3 = (JSPUtil.getParameter(request, prefix	+ "cstms_rmk3", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] mh = (JSPUtil.getParameter(request, prefix	+ "mh", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] hamoCmdtCd = (JSPUtil.getParameter(request, prefix	+ "hamo_cmdt_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Isf5InfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (isfActCd[i] != null)
					model.setIsfActCd(isfActCd[i]);
				if (cstmsRmk3[i] != null)
					model.setCstmsRmk3(cstmsRmk3[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (mh[i] != null)
					model.setMh(mh[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (hamoCmdtCd[i] != null)
					model.setHamoCmdtCd(hamoCmdtCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIsf5InfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Isf5InfoVO[]
	 */
	public Isf5InfoVO[] getIsf5InfoVOs(){
		Isf5InfoVO[] vos = (Isf5InfoVO[])models.toArray(new Isf5InfoVO[models.size()]);
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
		this.isfActCd = this.isfActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRmk3 = this.cstmsRmk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mh = this.mh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hamoCmdtCd = this.hamoCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomMnrAproStepVO.java
*@FileTitle : CustomMnrAproStepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.05
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.02.05 최덕우 
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo;

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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrAproStepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrAproStepVO> models = new ArrayList<CustomMnrAproStepVO>();
	
	/* Column Info */
	private String pic1UsrId = null;
	/* Column Info */
	private String aproStepSeq = null;
	/* Column Info */
	private String pic4OfcCd = null;
	/* Column Info */
	private String prePic4UsrId = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pic3OfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rgnHqOfcFlg = null;
	/* Column Info */
	private String pic3UsrId = null;
	/* Column Info */
	private String pic2Nm = null;
	/* Column Info */
	private String wrtfNo = null;
	/* Column Info */
	private String pic4UsrId = null;
	/* Column Info */
	private String pic2UsrId = null;
	/* Column Info */
	private String prePic3UsrId = null;
	/* Column Info */
	private String pic1Nm = null;
	/* Column Info */
	private String pic3Ofc = null;
	/* Column Info */
	private String pic2Ofc = null;
	/* Column Info */
	private String pic4Nm = null;
	/* Column Info */
	private String prePic1UsrId = null;
	/* Column Info */
	private String prePic2UsrId = null;
	/* Column Info */
	private String pic3Nm = null;
	/* Column Info */
	private String pic1Ofc = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String apstsCd = null;
	/* Column Info */
	private String pic2OfcCd = null;
	/* Column Info */
	private String pic4Ofc = null;
	/* Column Info */
	private String pic1OfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrAproStepVO() {}

	public CustomMnrAproStepVO(String ibflag, String pagerows, String pic4UsrId, String pic1UsrId, String pic2UsrId, String aproStepSeq, String pic1Nm, String pic3Ofc, String pic2Ofc, String pic4Nm, String ofcTpCd, String pic1Ofc, String pic3Nm, String ofcCd, String rgnHqOfcFlg, String pic3UsrId, String aproUsrId, String apstsCd, String pic4Ofc, String pic2Nm, String wrtfNo, String prePic1UsrId, String prePic2UsrId, String prePic3UsrId, String prePic4UsrId, String pic1OfcCd, String pic2OfcCd, String pic3OfcCd, String pic4OfcCd) {
		this.pic1UsrId = pic1UsrId;
		this.aproStepSeq = aproStepSeq;
		this.pic4OfcCd = pic4OfcCd;
		this.prePic4UsrId = prePic4UsrId;
		this.ofcTpCd = ofcTpCd;
		this.pagerows = pagerows;
		this.pic3OfcCd = pic3OfcCd;
		this.ibflag = ibflag;
		this.rgnHqOfcFlg = rgnHqOfcFlg;
		this.pic3UsrId = pic3UsrId;
		this.pic2Nm = pic2Nm;
		this.wrtfNo = wrtfNo;
		this.pic4UsrId = pic4UsrId;
		this.pic2UsrId = pic2UsrId;
		this.prePic3UsrId = prePic3UsrId;
		this.pic1Nm = pic1Nm;
		this.pic3Ofc = pic3Ofc;
		this.pic2Ofc = pic2Ofc;
		this.pic4Nm = pic4Nm;
		this.prePic1UsrId = prePic1UsrId;
		this.prePic2UsrId = prePic2UsrId;
		this.pic3Nm = pic3Nm;
		this.pic1Ofc = pic1Ofc;
		this.ofcCd = ofcCd;
		this.aproUsrId = aproUsrId;
		this.apstsCd = apstsCd;
		this.pic2OfcCd = pic2OfcCd;
		this.pic4Ofc = pic4Ofc;
		this.pic1OfcCd = pic1OfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pic1_usr_id", getPic1UsrId());
		this.hashColumns.put("apro_step_seq", getAproStepSeq());
		this.hashColumns.put("pic4_ofc_cd", getPic4OfcCd());
		this.hashColumns.put("pre_pic4_usr_id", getPrePic4UsrId());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pic3_ofc_cd", getPic3OfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rgn_hq_ofc_flg", getRgnHqOfcFlg());
		this.hashColumns.put("pic3_usr_id", getPic3UsrId());
		this.hashColumns.put("pic2_nm", getPic2Nm());
		this.hashColumns.put("wrtf_no", getWrtfNo());
		this.hashColumns.put("pic4_usr_id", getPic4UsrId());
		this.hashColumns.put("pic2_usr_id", getPic2UsrId());
		this.hashColumns.put("pre_pic3_usr_id", getPrePic3UsrId());
		this.hashColumns.put("pic1_nm", getPic1Nm());
		this.hashColumns.put("pic3_ofc", getPic3Ofc());
		this.hashColumns.put("pic2_ofc", getPic2Ofc());
		this.hashColumns.put("pic4_nm", getPic4Nm());
		this.hashColumns.put("pre_pic1_usr_id", getPrePic1UsrId());
		this.hashColumns.put("pre_pic2_usr_id", getPrePic2UsrId());
		this.hashColumns.put("pic3_nm", getPic3Nm());
		this.hashColumns.put("pic1_ofc", getPic1Ofc());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("pic2_ofc_cd", getPic2OfcCd());
		this.hashColumns.put("pic4_ofc", getPic4Ofc());
		this.hashColumns.put("pic1_ofc_cd", getPic1OfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pic1_usr_id", "pic1UsrId");
		this.hashFields.put("apro_step_seq", "aproStepSeq");
		this.hashFields.put("pic4_ofc_cd", "pic4OfcCd");
		this.hashFields.put("pre_pic4_usr_id", "prePic4UsrId");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pic3_ofc_cd", "pic3OfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rgn_hq_ofc_flg", "rgnHqOfcFlg");
		this.hashFields.put("pic3_usr_id", "pic3UsrId");
		this.hashFields.put("pic2_nm", "pic2Nm");
		this.hashFields.put("wrtf_no", "wrtfNo");
		this.hashFields.put("pic4_usr_id", "pic4UsrId");
		this.hashFields.put("pic2_usr_id", "pic2UsrId");
		this.hashFields.put("pre_pic3_usr_id", "prePic3UsrId");
		this.hashFields.put("pic1_nm", "pic1Nm");
		this.hashFields.put("pic3_ofc", "pic3Ofc");
		this.hashFields.put("pic2_ofc", "pic2Ofc");
		this.hashFields.put("pic4_nm", "pic4Nm");
		this.hashFields.put("pre_pic1_usr_id", "prePic1UsrId");
		this.hashFields.put("pre_pic2_usr_id", "prePic2UsrId");
		this.hashFields.put("pic3_nm", "pic3Nm");
		this.hashFields.put("pic1_ofc", "pic1Ofc");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("pic2_ofc_cd", "pic2OfcCd");
		this.hashFields.put("pic4_ofc", "pic4Ofc");
		this.hashFields.put("pic1_ofc_cd", "pic1OfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pic1UsrId
	 */
	public String getPic1UsrId() {
		return this.pic1UsrId;
	}
	
	/**
	 * Column Info
	 * @return aproStepSeq
	 */
	public String getAproStepSeq() {
		return this.aproStepSeq;
	}
	
	/**
	 * Column Info
	 * @return pic4OfcCd
	 */
	public String getPic4OfcCd() {
		return this.pic4OfcCd;
	}
	
	/**
	 * Column Info
	 * @return prePic4UsrId
	 */
	public String getPrePic4UsrId() {
		return this.prePic4UsrId;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
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
	 * @return pic3OfcCd
	 */
	public String getPic3OfcCd() {
		return this.pic3OfcCd;
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
	 * @return rgnHqOfcFlg
	 */
	public String getRgnHqOfcFlg() {
		return this.rgnHqOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return pic3UsrId
	 */
	public String getPic3UsrId() {
		return this.pic3UsrId;
	}
	
	/**
	 * Column Info
	 * @return pic2Nm
	 */
	public String getPic2Nm() {
		return this.pic2Nm;
	}
	
	/**
	 * Column Info
	 * @return wrtfNo
	 */
	public String getWrtfNo() {
		return this.wrtfNo;
	}
	
	/**
	 * Column Info
	 * @return pic4UsrId
	 */
	public String getPic4UsrId() {
		return this.pic4UsrId;
	}
	
	/**
	 * Column Info
	 * @return pic2UsrId
	 */
	public String getPic2UsrId() {
		return this.pic2UsrId;
	}
	
	/**
	 * Column Info
	 * @return prePic3UsrId
	 */
	public String getPrePic3UsrId() {
		return this.prePic3UsrId;
	}
	
	/**
	 * Column Info
	 * @return pic1Nm
	 */
	public String getPic1Nm() {
		return this.pic1Nm;
	}
	
	/**
	 * Column Info
	 * @return pic3Ofc
	 */
	public String getPic3Ofc() {
		return this.pic3Ofc;
	}
	
	/**
	 * Column Info
	 * @return pic2Ofc
	 */
	public String getPic2Ofc() {
		return this.pic2Ofc;
	}
	
	/**
	 * Column Info
	 * @return pic4Nm
	 */
	public String getPic4Nm() {
		return this.pic4Nm;
	}
	
	/**
	 * Column Info
	 * @return prePic1UsrId
	 */
	public String getPrePic1UsrId() {
		return this.prePic1UsrId;
	}
	
	/**
	 * Column Info
	 * @return prePic2UsrId
	 */
	public String getPrePic2UsrId() {
		return this.prePic2UsrId;
	}
	
	/**
	 * Column Info
	 * @return pic3Nm
	 */
	public String getPic3Nm() {
		return this.pic3Nm;
	}
	
	/**
	 * Column Info
	 * @return pic1Ofc
	 */
	public String getPic1Ofc() {
		return this.pic1Ofc;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return apstsCd
	 */
	public String getApstsCd() {
		return this.apstsCd;
	}
	
	/**
	 * Column Info
	 * @return pic2OfcCd
	 */
	public String getPic2OfcCd() {
		return this.pic2OfcCd;
	}
	
	/**
	 * Column Info
	 * @return pic4Ofc
	 */
	public String getPic4Ofc() {
		return this.pic4Ofc;
	}
	
	/**
	 * Column Info
	 * @return pic1OfcCd
	 */
	public String getPic1OfcCd() {
		return this.pic1OfcCd;
	}
	

	/**
	 * Column Info
	 * @param pic1UsrId
	 */
	public void setPic1UsrId(String pic1UsrId) {
		this.pic1UsrId = pic1UsrId;
	}
	
	/**
	 * Column Info
	 * @param aproStepSeq
	 */
	public void setAproStepSeq(String aproStepSeq) {
		this.aproStepSeq = aproStepSeq;
	}
	
	/**
	 * Column Info
	 * @param pic4OfcCd
	 */
	public void setPic4OfcCd(String pic4OfcCd) {
		this.pic4OfcCd = pic4OfcCd;
	}
	
	/**
	 * Column Info
	 * @param prePic4UsrId
	 */
	public void setPrePic4UsrId(String prePic4UsrId) {
		this.prePic4UsrId = prePic4UsrId;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
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
	 * @param pic3OfcCd
	 */
	public void setPic3OfcCd(String pic3OfcCd) {
		this.pic3OfcCd = pic3OfcCd;
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
	 * @param rgnHqOfcFlg
	 */
	public void setRgnHqOfcFlg(String rgnHqOfcFlg) {
		this.rgnHqOfcFlg = rgnHqOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param pic3UsrId
	 */
	public void setPic3UsrId(String pic3UsrId) {
		this.pic3UsrId = pic3UsrId;
	}
	
	/**
	 * Column Info
	 * @param pic2Nm
	 */
	public void setPic2Nm(String pic2Nm) {
		this.pic2Nm = pic2Nm;
	}
	
	/**
	 * Column Info
	 * @param wrtfNo
	 */
	public void setWrtfNo(String wrtfNo) {
		this.wrtfNo = wrtfNo;
	}
	
	/**
	 * Column Info
	 * @param pic4UsrId
	 */
	public void setPic4UsrId(String pic4UsrId) {
		this.pic4UsrId = pic4UsrId;
	}
	
	/**
	 * Column Info
	 * @param pic2UsrId
	 */
	public void setPic2UsrId(String pic2UsrId) {
		this.pic2UsrId = pic2UsrId;
	}
	
	/**
	 * Column Info
	 * @param prePic3UsrId
	 */
	public void setPrePic3UsrId(String prePic3UsrId) {
		this.prePic3UsrId = prePic3UsrId;
	}
	
	/**
	 * Column Info
	 * @param pic1Nm
	 */
	public void setPic1Nm(String pic1Nm) {
		this.pic1Nm = pic1Nm;
	}
	
	/**
	 * Column Info
	 * @param pic3Ofc
	 */
	public void setPic3Ofc(String pic3Ofc) {
		this.pic3Ofc = pic3Ofc;
	}
	
	/**
	 * Column Info
	 * @param pic2Ofc
	 */
	public void setPic2Ofc(String pic2Ofc) {
		this.pic2Ofc = pic2Ofc;
	}
	
	/**
	 * Column Info
	 * @param pic4Nm
	 */
	public void setPic4Nm(String pic4Nm) {
		this.pic4Nm = pic4Nm;
	}
	
	/**
	 * Column Info
	 * @param prePic1UsrId
	 */
	public void setPrePic1UsrId(String prePic1UsrId) {
		this.prePic1UsrId = prePic1UsrId;
	}
	
	/**
	 * Column Info
	 * @param prePic2UsrId
	 */
	public void setPrePic2UsrId(String prePic2UsrId) {
		this.prePic2UsrId = prePic2UsrId;
	}
	
	/**
	 * Column Info
	 * @param pic3Nm
	 */
	public void setPic3Nm(String pic3Nm) {
		this.pic3Nm = pic3Nm;
	}
	
	/**
	 * Column Info
	 * @param pic1Ofc
	 */
	public void setPic1Ofc(String pic1Ofc) {
		this.pic1Ofc = pic1Ofc;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param apstsCd
	 */
	public void setApstsCd(String apstsCd) {
		this.apstsCd = apstsCd;
	}
	
	/**
	 * Column Info
	 * @param pic2OfcCd
	 */
	public void setPic2OfcCd(String pic2OfcCd) {
		this.pic2OfcCd = pic2OfcCd;
	}
	
	/**
	 * Column Info
	 * @param pic4Ofc
	 */
	public void setPic4Ofc(String pic4Ofc) {
		this.pic4Ofc = pic4Ofc;
	}
	
	/**
	 * Column Info
	 * @param pic1OfcCd
	 */
	public void setPic1OfcCd(String pic1OfcCd) {
		this.pic1OfcCd = pic1OfcCd;
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
		setPic1UsrId(JSPUtil.getParameter(request, prefix + "pic1_usr_id", ""));
		setAproStepSeq(JSPUtil.getParameter(request, prefix + "apro_step_seq", ""));
		setPic4OfcCd(JSPUtil.getParameter(request, prefix + "pic4_ofc_cd", ""));
		setPrePic4UsrId(JSPUtil.getParameter(request, prefix + "pre_pic4_usr_id", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPic3OfcCd(JSPUtil.getParameter(request, prefix + "pic3_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRgnHqOfcFlg(JSPUtil.getParameter(request, prefix + "rgn_hq_ofc_flg", ""));
		setPic3UsrId(JSPUtil.getParameter(request, prefix + "pic3_usr_id", ""));
		setPic2Nm(JSPUtil.getParameter(request, prefix + "pic2_nm", ""));
		setWrtfNo(JSPUtil.getParameter(request, prefix + "wrtf_no", ""));
		setPic4UsrId(JSPUtil.getParameter(request, prefix + "pic4_usr_id", ""));
		setPic2UsrId(JSPUtil.getParameter(request, prefix + "pic2_usr_id", ""));
		setPrePic3UsrId(JSPUtil.getParameter(request, prefix + "pre_pic3_usr_id", ""));
		setPic1Nm(JSPUtil.getParameter(request, prefix + "pic1_nm", ""));
		setPic3Ofc(JSPUtil.getParameter(request, prefix + "pic3_ofc", ""));
		setPic2Ofc(JSPUtil.getParameter(request, prefix + "pic2_ofc", ""));
		setPic4Nm(JSPUtil.getParameter(request, prefix + "pic4_nm", ""));
		setPrePic1UsrId(JSPUtil.getParameter(request, prefix + "pre_pic1_usr_id", ""));
		setPrePic2UsrId(JSPUtil.getParameter(request, prefix + "pre_pic2_usr_id", ""));
		setPic3Nm(JSPUtil.getParameter(request, prefix + "pic3_nm", ""));
		setPic1Ofc(JSPUtil.getParameter(request, prefix + "pic1_ofc", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setApstsCd(JSPUtil.getParameter(request, prefix + "apsts_cd", ""));
		setPic2OfcCd(JSPUtil.getParameter(request, prefix + "pic2_ofc_cd", ""));
		setPic4Ofc(JSPUtil.getParameter(request, prefix + "pic4_ofc", ""));
		setPic1OfcCd(JSPUtil.getParameter(request, prefix + "pic1_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrAproStepVO[]
	 */
	public CustomMnrAproStepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrAproStepVO[]
	 */
	public CustomMnrAproStepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrAproStepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pic1UsrId = (JSPUtil.getParameter(request, prefix	+ "pic1_usr_id", length));
			String[] aproStepSeq = (JSPUtil.getParameter(request, prefix	+ "apro_step_seq", length));
			String[] pic4OfcCd = (JSPUtil.getParameter(request, prefix	+ "pic4_ofc_cd", length));
			String[] prePic4UsrId = (JSPUtil.getParameter(request, prefix	+ "pre_pic4_usr_id", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pic3OfcCd = (JSPUtil.getParameter(request, prefix	+ "pic3_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rgnHqOfcFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_hq_ofc_flg", length));
			String[] pic3UsrId = (JSPUtil.getParameter(request, prefix	+ "pic3_usr_id", length));
			String[] pic2Nm = (JSPUtil.getParameter(request, prefix	+ "pic2_nm", length));
			String[] wrtfNo = (JSPUtil.getParameter(request, prefix	+ "wrtf_no", length));
			String[] pic4UsrId = (JSPUtil.getParameter(request, prefix	+ "pic4_usr_id", length));
			String[] pic2UsrId = (JSPUtil.getParameter(request, prefix	+ "pic2_usr_id", length));
			String[] prePic3UsrId = (JSPUtil.getParameter(request, prefix	+ "pre_pic3_usr_id", length));
			String[] pic1Nm = (JSPUtil.getParameter(request, prefix	+ "pic1_nm", length));
			String[] pic3Ofc = (JSPUtil.getParameter(request, prefix	+ "pic3_ofc", length));
			String[] pic2Ofc = (JSPUtil.getParameter(request, prefix	+ "pic2_ofc", length));
			String[] pic4Nm = (JSPUtil.getParameter(request, prefix	+ "pic4_nm", length));
			String[] prePic1UsrId = (JSPUtil.getParameter(request, prefix	+ "pre_pic1_usr_id", length));
			String[] prePic2UsrId = (JSPUtil.getParameter(request, prefix	+ "pre_pic2_usr_id", length));
			String[] pic3Nm = (JSPUtil.getParameter(request, prefix	+ "pic3_nm", length));
			String[] pic1Ofc = (JSPUtil.getParameter(request, prefix	+ "pic1_ofc", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] pic2OfcCd = (JSPUtil.getParameter(request, prefix	+ "pic2_ofc_cd", length));
			String[] pic4Ofc = (JSPUtil.getParameter(request, prefix	+ "pic4_ofc", length));
			String[] pic1OfcCd = (JSPUtil.getParameter(request, prefix	+ "pic1_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrAproStepVO();
				if (pic1UsrId[i] != null)
					model.setPic1UsrId(pic1UsrId[i]);
				if (aproStepSeq[i] != null)
					model.setAproStepSeq(aproStepSeq[i]);
				if (pic4OfcCd[i] != null)
					model.setPic4OfcCd(pic4OfcCd[i]);
				if (prePic4UsrId[i] != null)
					model.setPrePic4UsrId(prePic4UsrId[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pic3OfcCd[i] != null)
					model.setPic3OfcCd(pic3OfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rgnHqOfcFlg[i] != null)
					model.setRgnHqOfcFlg(rgnHqOfcFlg[i]);
				if (pic3UsrId[i] != null)
					model.setPic3UsrId(pic3UsrId[i]);
				if (pic2Nm[i] != null)
					model.setPic2Nm(pic2Nm[i]);
				if (wrtfNo[i] != null)
					model.setWrtfNo(wrtfNo[i]);
				if (pic4UsrId[i] != null)
					model.setPic4UsrId(pic4UsrId[i]);
				if (pic2UsrId[i] != null)
					model.setPic2UsrId(pic2UsrId[i]);
				if (prePic3UsrId[i] != null)
					model.setPrePic3UsrId(prePic3UsrId[i]);
				if (pic1Nm[i] != null)
					model.setPic1Nm(pic1Nm[i]);
				if (pic3Ofc[i] != null)
					model.setPic3Ofc(pic3Ofc[i]);
				if (pic2Ofc[i] != null)
					model.setPic2Ofc(pic2Ofc[i]);
				if (pic4Nm[i] != null)
					model.setPic4Nm(pic4Nm[i]);
				if (prePic1UsrId[i] != null)
					model.setPrePic1UsrId(prePic1UsrId[i]);
				if (prePic2UsrId[i] != null)
					model.setPrePic2UsrId(prePic2UsrId[i]);
				if (pic3Nm[i] != null)
					model.setPic3Nm(pic3Nm[i]);
				if (pic1Ofc[i] != null)
					model.setPic1Ofc(pic1Ofc[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (pic2OfcCd[i] != null)
					model.setPic2OfcCd(pic2OfcCd[i]);
				if (pic4Ofc[i] != null)
					model.setPic4Ofc(pic4Ofc[i]);
				if (pic1OfcCd[i] != null)
					model.setPic1OfcCd(pic1OfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrAproStepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrAproStepVO[]
	 */
	public CustomMnrAproStepVO[] getCustomMnrAproStepVOs(){
		CustomMnrAproStepVO[] vos = (CustomMnrAproStepVO[])models.toArray(new CustomMnrAproStepVO[models.size()]);
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
		this.pic1UsrId = this.pic1UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStepSeq = this.aproStepSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic4OfcCd = this.pic4OfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePic4UsrId = this.prePic4UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic3OfcCd = this.pic3OfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnHqOfcFlg = this.rgnHqOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic3UsrId = this.pic3UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic2Nm = this.pic2Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfNo = this.wrtfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic4UsrId = this.pic4UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic2UsrId = this.pic2UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePic3UsrId = this.prePic3UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic1Nm = this.pic1Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic3Ofc = this.pic3Ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic2Ofc = this.pic2Ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic4Nm = this.pic4Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePic1UsrId = this.prePic1UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePic2UsrId = this.prePic2UsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic3Nm = this.pic3Nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic1Ofc = this.pic1Ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic2OfcCd = this.pic2OfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic4Ofc = this.pic4Ofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic1OfcCd = this.pic1OfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

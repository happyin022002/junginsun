/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ASAInfoByOfcAgnVO.java
*@FileTitle : ASAInfoByOfcAgnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

import java.lang.reflect.Field;
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

public class ASAInfoByOfcAgnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ASAInfoByOfcAgnVO> models = new ArrayList<ASAInfoByOfcAgnVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String preAsaNo = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String cntAsaNo = null;
	/* Column Info */
	private String maxAsaPrdToDt = null;
	/* Column Info */
	private String asaPrdToDt = null;
	/* Column Info */
	private String openAsaYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxAsaNo = null;
	/* Column Info */
	private String asaPrdFmDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String asaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ASAInfoByOfcAgnVO() {}

	public ASAInfoByOfcAgnVO(String ibflag, String pagerows, String currCd, String preAsaNo, String cntAsaNo, String maxAsaPrdToDt, String asaPrdToDt, String openAsaYn, String ofcCd, String agnCd, String maxAsaNo, String asaPrdFmDt, String userId, String asaNo, String backendjobKey) {
		this.currCd = currCd;
		this.preAsaNo = preAsaNo;
		this.backendjobKey = backendjobKey;
		this.cntAsaNo = cntAsaNo;
		this.maxAsaPrdToDt = maxAsaPrdToDt;
		this.asaPrdToDt = asaPrdToDt;
		this.openAsaYn = openAsaYn;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.maxAsaNo = maxAsaNo;
		this.asaPrdFmDt = asaPrdFmDt;
		this.userId = userId;
		this.asaNo = asaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pre_asa_no", getPreAsaNo());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("cnt_asa_no", getCntAsaNo());
		this.hashColumns.put("max_asa_prd_to_dt", getMaxAsaPrdToDt());
		this.hashColumns.put("asa_prd_to_dt", getAsaPrdToDt());
		this.hashColumns.put("open_asa_yn", getOpenAsaYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_asa_no", getMaxAsaNo());
		this.hashColumns.put("asa_prd_fm_dt", getAsaPrdFmDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("asa_no", getAsaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pre_asa_no", "preAsaNo");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("cnt_asa_no", "cntAsaNo");
		this.hashFields.put("max_asa_prd_to_dt", "maxAsaPrdToDt");
		this.hashFields.put("asa_prd_to_dt", "asaPrdToDt");
		this.hashFields.put("open_asa_yn", "openAsaYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_asa_no", "maxAsaNo");
		this.hashFields.put("asa_prd_fm_dt", "asaPrdFmDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("asa_no", "asaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return preAsaNo
	 */
	public String getPreAsaNo() {
		return this.preAsaNo;
	}
	
	/**
	 * Column Info
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
	}
	
	/**
	 * Column Info
	 * @return cntAsaNo
	 */
	public String getCntAsaNo() {
		return this.cntAsaNo;
	}
	
	/**
	 * Column Info
	 * @return maxAsaPrdToDt
	 */
	public String getMaxAsaPrdToDt() {
		return this.maxAsaPrdToDt;
	}
	
	/**
	 * Column Info
	 * @return asaPrdToDt
	 */
	public String getAsaPrdToDt() {
		return this.asaPrdToDt;
	}
	
	/**
	 * Column Info
	 * @return openAsaYn
	 */
	public String getOpenAsaYn() {
		return this.openAsaYn;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return maxAsaNo
	 */
	public String getMaxAsaNo() {
		return this.maxAsaNo;
	}
	
	/**
	 * Column Info
	 * @return asaPrdFmDt
	 */
	public String getAsaPrdFmDt() {
		return this.asaPrdFmDt;
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
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param preAsaNo
	 */
	public void setPreAsaNo(String preAsaNo) {
		this.preAsaNo = preAsaNo;
	}
	
	/**
	 * Column Info
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	/**
	 * Column Info
	 * @param cntAsaNo
	 */
	public void setCntAsaNo(String cntAsaNo) {
		this.cntAsaNo = cntAsaNo;
	}
	
	/**
	 * Column Info
	 * @param maxAsaPrdToDt
	 */
	public void setMaxAsaPrdToDt(String maxAsaPrdToDt) {
		this.maxAsaPrdToDt = maxAsaPrdToDt;
	}
	
	/**
	 * Column Info
	 * @param asaPrdToDt
	 */
	public void setAsaPrdToDt(String asaPrdToDt) {
		this.asaPrdToDt = asaPrdToDt;
	}
	
	/**
	 * Column Info
	 * @param openAsaYn
	 */
	public void setOpenAsaYn(String openAsaYn) {
		this.openAsaYn = openAsaYn;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param maxAsaNo
	 */
	public void setMaxAsaNo(String maxAsaNo) {
		this.maxAsaNo = maxAsaNo;
	}
	
	/**
	 * Column Info
	 * @param asaPrdFmDt
	 */
	public void setAsaPrdFmDt(String asaPrdFmDt) {
		this.asaPrdFmDt = asaPrdFmDt;
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
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPreAsaNo(JSPUtil.getParameter(request, prefix + "pre_asa_no", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setCntAsaNo(JSPUtil.getParameter(request, prefix + "cnt_asa_no", ""));
		setMaxAsaPrdToDt(JSPUtil.getParameter(request, prefix + "max_asa_prd_to_dt", ""));
		setAsaPrdToDt(JSPUtil.getParameter(request, prefix + "asa_prd_to_dt", ""));
		setOpenAsaYn(JSPUtil.getParameter(request, prefix + "open_asa_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMaxAsaNo(JSPUtil.getParameter(request, prefix + "max_asa_no", ""));
		setAsaPrdFmDt(JSPUtil.getParameter(request, prefix + "asa_prd_fm_dt", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ASAInfoByOfcAgnVO[]
	 */
	public ASAInfoByOfcAgnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ASAInfoByOfcAgnVO[]
	 */
	public ASAInfoByOfcAgnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ASAInfoByOfcAgnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] preAsaNo = (JSPUtil.getParameter(request, prefix	+ "pre_asa_no", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] cntAsaNo = (JSPUtil.getParameter(request, prefix	+ "cnt_asa_no", length));
			String[] maxAsaPrdToDt = (JSPUtil.getParameter(request, prefix	+ "max_asa_prd_to_dt", length));
			String[] asaPrdToDt = (JSPUtil.getParameter(request, prefix	+ "asa_prd_to_dt", length));
			String[] openAsaYn = (JSPUtil.getParameter(request, prefix	+ "open_asa_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxAsaNo = (JSPUtil.getParameter(request, prefix	+ "max_asa_no", length));
			String[] asaPrdFmDt = (JSPUtil.getParameter(request, prefix	+ "asa_prd_fm_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ASAInfoByOfcAgnVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (preAsaNo[i] != null)
					model.setPreAsaNo(preAsaNo[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (cntAsaNo[i] != null)
					model.setCntAsaNo(cntAsaNo[i]);
				if (maxAsaPrdToDt[i] != null)
					model.setMaxAsaPrdToDt(maxAsaPrdToDt[i]);
				if (asaPrdToDt[i] != null)
					model.setAsaPrdToDt(asaPrdToDt[i]);
				if (openAsaYn[i] != null)
					model.setOpenAsaYn(openAsaYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxAsaNo[i] != null)
					model.setMaxAsaNo(maxAsaNo[i]);
				if (asaPrdFmDt[i] != null)
					model.setAsaPrdFmDt(asaPrdFmDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getASAInfoByOfcAgnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ASAInfoByOfcAgnVO[]
	 */
	public ASAInfoByOfcAgnVO[] getASAInfoByOfcAgnVOs(){
		ASAInfoByOfcAgnVO[] vos = (ASAInfoByOfcAgnVO[])models.toArray(new ASAInfoByOfcAgnVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAsaNo = this.preAsaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntAsaNo = this.cntAsaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAsaPrdToDt = this.maxAsaPrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaPrdToDt = this.asaPrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.openAsaYn = this.openAsaYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAsaNo = this.maxAsaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaPrdFmDt = this.asaPrdFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

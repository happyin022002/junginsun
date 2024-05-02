/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModifySrTransferVO.java
*@FileTitle : ModifySrTransferVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.11 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifySrTransferVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifySrTransferVO> models = new ArrayList<ModifySrTransferVO>();
	
	/* Column Info */
	private String srHisSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String srMtchStsCd = null;
	/* Column Info */
	private String srNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifySrTransferVO() {}

	public ModifySrTransferVO(String ibflag, String pagerows, String bkgNo, String srNo, String srKndCd, String usrId, String srMtchStsCd, String ofcCd, String srHisSeq, String rcvDt, String srStsCd) {
		this.srHisSeq = srHisSeq;
		this.ofcCd = ofcCd;
		this.srKndCd = srKndCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.srStsCd = srStsCd;
		this.usrId = usrId;
		this.rcvDt = rcvDt;
		this.srMtchStsCd = srMtchStsCd;
		this.srNo = srNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sr_his_seq", getSrHisSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("sr_mtch_sts_cd", getSrMtchStsCd());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sr_his_seq", "srHisSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("sr_mtch_sts_cd", "srMtchStsCd");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srHisSeq
	 */
	public String getSrHisSeq() {
		return this.srHisSeq;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return srMtchStsCd
	 */
	public String getSrMtchStsCd() {
		return this.srMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
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
	 * @param srHisSeq
	 */
	public void setSrHisSeq(String srHisSeq) {
		this.srHisSeq = srHisSeq;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param srMtchStsCd
	 */
	public void setSrMtchStsCd(String srMtchStsCd) {
		this.srMtchStsCd = srMtchStsCd;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
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
		setSrHisSeq(JSPUtil.getParameter(request, "sr_his_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSrStsCd(JSPUtil.getParameter(request, "sr_sts_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setSrMtchStsCd(JSPUtil.getParameter(request, "sr_mtch_sts_cd", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ModifySrTransferVO[]
	 */
	public ModifySrTransferVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ModifySrTransferVO[]
	 */
	public ModifySrTransferVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifySrTransferVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srHisSeq = (JSPUtil.getParameter(request, prefix	+ "sr_his_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] srMtchStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_mtch_sts_cd", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ModifySrTransferVO();
				if (srHisSeq[i] != null)
					model.setSrHisSeq(srHisSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (srMtchStsCd[i] != null)
					model.setSrMtchStsCd(srMtchStsCd[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getModifySrTransferVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ModifySrTransferVO[]
	 */
	public ModifySrTransferVO[] getModifySrTransferVOs(){
		ModifySrTransferVO[] vos = (ModifySrTransferVO[])models.toArray(new ModifySrTransferVO[models.size()]);
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
		this.srHisSeq = this.srHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srMtchStsCd = this.srMtchStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

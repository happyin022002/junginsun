/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QueueStatusDetailVO.java
*@FileTitle : QueueStatusDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class QueueStatusDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<QueueStatusDetailVO> models = new ArrayList<QueueStatusDetailVO>();
	
	/* Column Info */
	private String pndFlg = null;
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srWrkStsCd = null;
	/* Column Info */
	private String srWrkStsDt = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String fntOfcRtnCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public QueueStatusDetailVO() {}

	public QueueStatusDetailVO(String ibflag, String pagerows, String rgnOfcCd, String bkgOfcCd, String bkgNo, String srWrkStsDt, String blDocInpFlg, String blRtFlg, String blAudFlg, String pndFlg, String srWrkStsCd, String fntOfcRtnCd) {
		this.pndFlg = pndFlg;
		this.blAudFlg = blAudFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.blDocInpFlg = blDocInpFlg;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.srWrkStsCd = srWrkStsCd;
		this.srWrkStsDt = srWrkStsDt;
		this.blRtFlg = blRtFlg;
		this.rgnOfcCd = rgnOfcCd;
		this.fntOfcRtnCd = fntOfcRtnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pnd_flg", getPndFlg());
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_wrk_sts_cd", getSrWrkStsCd());
		this.hashColumns.put("sr_wrk_sts_dt", getSrWrkStsDt());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("fnt_ofc_rtn_cd", getFntOfcRtnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pnd_flg", "pndFlg");
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_wrk_sts_cd", "srWrkStsCd");
		this.hashFields.put("sr_wrk_sts_dt", "srWrkStsDt");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("fnt_ofc_rtn_cd", "fntOfcRtnCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pndFlg
	 */
	public String getPndFlg() {
		return this.pndFlg;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
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
	 * @return srWrkStsCd
	 */
	public String getSrWrkStsCd() {
		return this.srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @return srWrkStsDt
	 */
	public String getSrWrkStsDt() {
		return this.srWrkStsDt;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fntOfcRtnCd
	 */
	public String getFntOfcRtnCd() {
		return this.fntOfcRtnCd;
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
	 * @param pndFlg
	 */
	public void setPndFlg(String pndFlg) {
		this.pndFlg = pndFlg;
	}
	
	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
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
	 * @param srWrkStsCd
	 */
	public void setSrWrkStsCd(String srWrkStsCd) {
		this.srWrkStsCd = srWrkStsCd;
	}
	
	/**
	 * Column Info
	 * @param srWrkStsDt
	 */
	public void setSrWrkStsDt(String srWrkStsDt) {
		this.srWrkStsDt = srWrkStsDt;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fntOfcRtnCd
	 */
	public void setFntOfcRtnCd(String fntOfcRtnCd) {
		this.fntOfcRtnCd = fntOfcRtnCd;
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
		setPndFlg(JSPUtil.getParameter(request, prefix + "pnd_flg", ""));
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrWrkStsCd(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_cd", ""));
		setSrWrkStsDt(JSPUtil.getParameter(request, prefix + "sr_wrk_sts_dt", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setFntOfcRtnCd(JSPUtil.getParameter(request, prefix + "fnt_ofc_rtn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return QueueStatusDetailVO[]
	 */
	public QueueStatusDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return QueueStatusDetailVO[]
	 */
	public QueueStatusDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		QueueStatusDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pndFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_flg", length));
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srWrkStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_cd", length));
			String[] srWrkStsDt = (JSPUtil.getParameter(request, prefix	+ "sr_wrk_sts_dt", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] fntOfcRtnCd = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_rtn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new QueueStatusDetailVO();
				if (pndFlg[i] != null)
					model.setPndFlg(pndFlg[i]);
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srWrkStsCd[i] != null)
					model.setSrWrkStsCd(srWrkStsCd[i]);
				if (srWrkStsDt[i] != null)
					model.setSrWrkStsDt(srWrkStsDt[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (fntOfcRtnCd[i] != null)
					model.setFntOfcRtnCd(fntOfcRtnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getQueueStatusDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return QueueStatusDetailVO[]
	 */
	public QueueStatusDetailVO[] getQueueStatusDetailVOs(){
		QueueStatusDetailVO[] vos = (QueueStatusDetailVO[])models.toArray(new QueueStatusDetailVO[models.size()]);
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
		this.pndFlg = this.pndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsCd = this.srWrkStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srWrkStsDt = this.srWrkStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcRtnCd = this.fntOfcRtnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

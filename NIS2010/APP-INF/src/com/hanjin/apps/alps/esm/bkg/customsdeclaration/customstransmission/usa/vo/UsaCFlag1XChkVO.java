/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCFlag1XChkVO.java
*@FileTitle : UsaCFlag1XChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.21 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaCFlag1XChkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaCFlag1XChkVO> models = new ArrayList<UsaCFlag1XChkVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String holdFlg = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String remvCd = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String cstmsSeq = null;
	/* Column Info */
	private String remvFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaCFlag1XChkVO() {}

	public UsaCFlag1XChkVO(String ibflag, String pagerows, String blNo, String cstmsSeq, String dspoCd, String arrDt, String holdFlg, String remvFlg, String remvCd, String cntrQty) {
		this.ibflag = ibflag;
		this.arrDt = arrDt;
		this.holdFlg = holdFlg;
		this.cntrQty = cntrQty;
		this.remvCd = remvCd;
		this.dspoCd = dspoCd;
		this.cstmsSeq = cstmsSeq;
		this.remvFlg = remvFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("hold_flg", getHoldFlg());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("remv_cd", getRemvCd());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("cstms_seq", getCstmsSeq());
		this.hashColumns.put("remv_flg", getRemvFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("hold_flg", "holdFlg");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("remv_cd", "remvCd");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("cstms_seq", "cstmsSeq");
		this.hashFields.put("remv_flg", "remvFlg");
		this.hashFields.put("bl_no", "blNo");
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
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return holdFlg
	 */
	public String getHoldFlg() {
		return this.holdFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return remvCd
	 */
	public String getRemvCd() {
		return this.remvCd;
	}
	
	/**
	 * Column Info
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsSeq
	 */
	public String getCstmsSeq() {
		return this.cstmsSeq;
	}
	
	/**
	 * Column Info
	 * @return remvFlg
	 */
	public String getRemvFlg() {
		return this.remvFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param holdFlg
	 */
	public void setHoldFlg(String holdFlg) {
		this.holdFlg = holdFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param remvCd
	 */
	public void setRemvCd(String remvCd) {
		this.remvCd = remvCd;
	}
	
	/**
	 * Column Info
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsSeq
	 */
	public void setCstmsSeq(String cstmsSeq) {
		this.cstmsSeq = cstmsSeq;
	}
	
	/**
	 * Column Info
	 * @param remvFlg
	 */
	public void setRemvFlg(String remvFlg) {
		this.remvFlg = remvFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setHoldFlg(JSPUtil.getParameter(request, prefix + "hold_flg", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setRemvCd(JSPUtil.getParameter(request, prefix + "remv_cd", ""));
		setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
		setCstmsSeq(JSPUtil.getParameter(request, prefix + "cstms_seq", ""));
		setRemvFlg(JSPUtil.getParameter(request, prefix + "remv_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaCFlag1XChkVO[]
	 */
	public UsaCFlag1XChkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaCFlag1XChkVO[]
	 */
	public UsaCFlag1XChkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaCFlag1XChkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] holdFlg = (JSPUtil.getParameter(request, prefix	+ "hold_flg", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] remvCd = (JSPUtil.getParameter(request, prefix	+ "remv_cd", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] cstmsSeq = (JSPUtil.getParameter(request, prefix	+ "cstms_seq", length));
			String[] remvFlg = (JSPUtil.getParameter(request, prefix	+ "remv_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaCFlag1XChkVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (holdFlg[i] != null)
					model.setHoldFlg(holdFlg[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (remvCd[i] != null)
					model.setRemvCd(remvCd[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (cstmsSeq[i] != null)
					model.setCstmsSeq(cstmsSeq[i]);
				if (remvFlg[i] != null)
					model.setRemvFlg(remvFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaCFlag1XChkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaCFlag1XChkVO[]
	 */
	public UsaCFlag1XChkVO[] getUsaCFlag1XChkVOs(){
		UsaCFlag1XChkVO[] vos = (UsaCFlag1XChkVO[])models.toArray(new UsaCFlag1XChkVO[models.size()]);
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
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holdFlg = this.holdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remvCd = this.remvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsSeq = this.cstmsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remvFlg = this.remvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

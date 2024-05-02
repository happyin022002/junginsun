/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InternalRemarkVO.java
*@FileTitle : InternalRemarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.05.18 박찬우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo;

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
 * @author 박찬우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InternalRemarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InternalRemarkVO> models = new ArrayList<InternalRemarkVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String interRmkSeq = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String interRmkCd = null;
	/* Column Info */
	private String woNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InternalRemarkVO() {}

	public InternalRemarkVO(String ibflag, String pagerows, String bkgNo, String interRmkSeq, String eqNo, String soNo, String woNo, String interRmk, String usrId, String updDt, String interRmkCd) {
		this.updDt = updDt;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.soNo = soNo;
		this.eqNo = eqNo;
		this.interRmkSeq = interRmkSeq;
		this.interRmk = interRmk;
		this.usrId = usrId;
		this.interRmkCd = interRmkCd;
		this.woNo = woNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inter_rmk_seq", getInterRmkSeq());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("inter_rmk_cd", getInterRmkCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inter_rmk_seq", "interRmkSeq");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("inter_rmk_cd", "interRmkCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return interRmkSeq
	 */
	public String getInterRmkSeq() {
		return this.interRmkSeq;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
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
	 * @return interRmkCd
	 */
	public String getInterRmkCd() {
		return this.interRmkCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param interRmkSeq
	 */
	public void setInterRmkSeq(String interRmkSeq) {
		this.interRmkSeq = interRmkSeq;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
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
	 * @param interRmkCd
	 */
	public void setInterRmkCd(String interRmkCd) {
		this.interRmkCd = interRmkCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInterRmkSeq(JSPUtil.getParameter(request, prefix + "inter_rmk_seq", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setInterRmkCd(JSPUtil.getParameter(request, prefix + "inter_rmk_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InternalRemarkVO[]
	 */
	public InternalRemarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InternalRemarkVO[]
	 */
	public InternalRemarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InternalRemarkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] interRmkSeq = (JSPUtil.getParameter(request, prefix	+ "inter_rmk_seq", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] interRmkCd = (JSPUtil.getParameter(request, prefix	+ "inter_rmk_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InternalRemarkVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (interRmkSeq[i] != null)
					model.setInterRmkSeq(interRmkSeq[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (interRmkCd[i] != null)
					model.setInterRmkCd(interRmkCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInternalRemarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InternalRemarkVO[]
	 */
	public InternalRemarkVO[] getInternalRemarkVOs(){
		InternalRemarkVO[] vos = (InternalRemarkVO[])models.toArray(new InternalRemarkVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmkSeq = this.interRmkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmkCd = this.interRmkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
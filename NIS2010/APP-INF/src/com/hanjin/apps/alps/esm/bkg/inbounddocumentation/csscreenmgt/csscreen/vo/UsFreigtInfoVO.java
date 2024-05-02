/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsFreigtInfoVO.java
*@FileTitle : UsFreigtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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

public class UsFreigtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsFreigtInfoVO> models = new ArrayList<UsFreigtInfoVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String frtCltLstDt = null;
	/* Column Info */
	private String frtCltOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsFreigtInfoVO() {}

	public UsFreigtInfoVO(String ibflag, String pagerows, String bkgNo, String frtCltFlg, String frtCltLstDt, String frtCltOfcCd, String hisSeq) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.frtCltFlg = frtCltFlg;
		this.hisSeq = hisSeq;
		this.frtCltLstDt = frtCltLstDt;
		this.frtCltOfcCd = frtCltOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("frt_clt_lst_dt", getFrtCltLstDt());
		this.hashColumns.put("frt_clt_ofc_cd", getFrtCltOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("frt_clt_lst_dt", "frtCltLstDt");
		this.hashFields.put("frt_clt_ofc_cd", "frtCltOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return frtCltLstDt
	 */
	public String getFrtCltLstDt() {
		return this.frtCltLstDt;
	}
	
	/**
	 * Column Info
	 * @return frtCltOfcCd
	 */
	public String getFrtCltOfcCd() {
		return this.frtCltOfcCd;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param frtCltLstDt
	 */
	public void setFrtCltLstDt(String frtCltLstDt) {
		this.frtCltLstDt = frtCltLstDt;
	}
	
	/**
	 * Column Info
	 * @param frtCltOfcCd
	 */
	public void setFrtCltOfcCd(String frtCltOfcCd) {
		this.frtCltOfcCd = frtCltOfcCd;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setFrtCltLstDt(JSPUtil.getParameter(request, prefix + "frt_clt_lst_dt", ""));
		setFrtCltOfcCd(JSPUtil.getParameter(request, prefix + "frt_clt_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsFreigtInfoVO[]
	 */
	public UsFreigtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsFreigtInfoVO[]
	 */
	public UsFreigtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsFreigtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] frtCltLstDt = (JSPUtil.getParameter(request, prefix	+ "frt_clt_lst_dt", length));
			String[] frtCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "frt_clt_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsFreigtInfoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (frtCltLstDt[i] != null)
					model.setFrtCltLstDt(frtCltLstDt[i]);
				if (frtCltOfcCd[i] != null)
					model.setFrtCltOfcCd(frtCltOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsFreigtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsFreigtInfoVO[]
	 */
	public UsFreigtInfoVO[] getUsFreigtInfoVOs(){
		UsFreigtInfoVO[] vos = (UsFreigtInfoVO[])models.toArray(new UsFreigtInfoVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltLstDt = this.frtCltLstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltOfcCd = this.frtCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

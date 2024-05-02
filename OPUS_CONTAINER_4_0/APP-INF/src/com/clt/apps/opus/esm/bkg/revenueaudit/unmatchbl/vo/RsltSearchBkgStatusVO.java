/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchBkgStatusVO.java
*@FileTitle : RsltSearchBkgStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.27 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchBkgStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchBkgStatusVO> models = new ArrayList<RsltSearchBkgStatusVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchBkgStatusVO() {}

	public RsltSearchBkgStatusVO(String ibflag, String pagerows, String bkgStsCd, String caFlg, String ctrtTpCd, String corrNo, String svcScpCd, String interRmk) {
		this.ibflag = ibflag;
		this.interRmk = interRmk;
		this.svcScpCd = svcScpCd;
		this.bkgStsCd = bkgStsCd;
		this.corrNo = corrNo;
		this.caFlg = caFlg;
		this.ctrtTpCd = ctrtTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtTpCd
	 */
	public String getCtrtTpCd() {
		return this.ctrtTpCd;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtTpCd
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
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
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, prefix + "ctrt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchBkgStatusVO[]
	 */
	public RsltSearchBkgStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchBkgStatusVO[]
	 */
	public RsltSearchBkgStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchBkgStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchBkgStatusVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchBkgStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchBkgStatusVO[]
	 */
	public RsltSearchBkgStatusVO[] getRsltSearchBkgStatusVOs(){
		RsltSearchBkgStatusVO[] vos = (RsltSearchBkgStatusVO[])models.toArray(new RsltSearchBkgStatusVO[models.size()]);
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
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

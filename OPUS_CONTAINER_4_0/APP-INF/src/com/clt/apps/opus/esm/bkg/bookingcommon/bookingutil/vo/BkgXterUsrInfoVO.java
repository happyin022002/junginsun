/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgXterUsrInfoVO.java
*@FileTitle : BkgXterUsrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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
public class BkgXterUsrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgXterUsrInfoVO> models = new ArrayList<BkgXterUsrInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String usrId = null;

	/* Column Info */
	private String usrN1stNm = null;

	/* Column Info */
	private String usrLstNm = null;

	/* Column Info */
	private String usrStsCd = null;

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String rdyFoPrfFlg = null;

	/* Column Info */
	private String rdyFoPrnFlg = null;

	/* Column Info */
	private String seaWblEmlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgXterUsrInfoVO() {}

	public BkgXterUsrInfoVO(String ibflag, String pagerows, String usrId, String usrN1stNm, String usrLstNm, String usrStsCd, String custCntCd, String custSeq, String rdyFoPrfFlg, String rdyFoPrnFlg, String seaWblEmlFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.usrId = usrId;
		this.usrN1stNm = usrN1stNm;
		this.usrLstNm = usrLstNm;
		this.usrStsCd = usrStsCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.rdyFoPrfFlg = rdyFoPrfFlg;
		this.rdyFoPrnFlg = rdyFoPrnFlg;
		this.seaWblEmlFlg = seaWblEmlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_n1st_nm", getUsrN1stNm());
		this.hashColumns.put("usr_lst_nm", getUsrLstNm());
		this.hashColumns.put("usr_sts_cd", getUsrStsCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("rdy_fo_prf_flg", getRdyFoPrfFlg());
		this.hashColumns.put("rdy_fo_prn_flg", getRdyFoPrnFlg());
		this.hashColumns.put("sea_wbl_eml_flg", getSeaWblEmlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_n1st_nm", "usrN1stNm");
		this.hashFields.put("usr_lst_nm", "usrLstNm");
		this.hashFields.put("usr_sts_cd", "usrStsCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("rdy_fo_prf_flg", "rdyFoPrfFlg");
		this.hashFields.put("rdy_fo_prn_flg", "rdyFoPrnFlg");
		this.hashFields.put("sea_wbl_eml_flg", "seaWblEmlFlg");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * 
	 * @return String usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 *
	 * @param String usrN1stNm
	 */
	public void setUsrN1stNm(String usrN1stNm) {
		this.usrN1stNm = usrN1stNm;
	}
	
	/**
	 * 
	 * @return String usrN1stNm
	 */
	public String getUsrN1stNm() {
		return this.usrN1stNm;
	}
	
	/**
	 *
	 * @param String usrLstNm
	 */
	public void setUsrLstNm(String usrLstNm) {
		this.usrLstNm = usrLstNm;
	}
	
	/**
	 * 
	 * @return String usrLstNm
	 */
	public String getUsrLstNm() {
		return this.usrLstNm;
	}
	
	/**
	 *
	 * @param String usrStsCd
	 */
	public void setUsrStsCd(String usrStsCd) {
		this.usrStsCd = usrStsCd;
	}
	
	/**
	 * 
	 * @return String usrStsCd
	 */
	public String getUsrStsCd() {
		return this.usrStsCd;
	}
	
	/**
	 *
	 * @param String custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 
	 * @return String custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 *
	 * @param String custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * 
	 * @return String custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 *
	 * @param String rdyFoPrfFlg
	 */
	public void setRdyFoPrfFlg(String rdyFoPrfFlg) {
		this.rdyFoPrfFlg = rdyFoPrfFlg;
	}
	
	/**
	 * 
	 * @return String rdyFoPrfFlg
	 */
	public String getRdyFoPrfFlg() {
		return this.rdyFoPrfFlg;
	}
	
	/**
	 *
	 * @param String rdyFoPrnFlg
	 */
	public void setRdyFoPrnFlg(String rdyFoPrnFlg) {
		this.rdyFoPrnFlg = rdyFoPrnFlg;
	}
	
	/**
	 * 
	 * @return String rdyFoPrnFlg
	 */
	public String getRdyFoPrnFlg() {
		return this.rdyFoPrnFlg;
	}
	
	/**
	 *
	 * @param String seaWblEmlFlg
	 */
	public void setSeaWblEmlFlg(String seaWblEmlFlg) {
		this.seaWblEmlFlg = seaWblEmlFlg;
	}
	
	/**
	 * 
	 * @return String seaWblEmlFlg
	 */
	public String getSeaWblEmlFlg() {
		return this.seaWblEmlFlg;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrN1stNm(JSPUtil.getParameter(request, prefix + "usr_n1st_nm", ""));
		setUsrLstNm(JSPUtil.getParameter(request, prefix + "usr_lst_nm", ""));
		setUsrStsCd(JSPUtil.getParameter(request, prefix + "usr_sts_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setRdyFoPrfFlg(JSPUtil.getParameter(request, prefix + "rdy_fo_prf_flg", ""));
		setRdyFoPrnFlg(JSPUtil.getParameter(request, prefix + "rdy_fo_prn_flg", ""));
		setSeaWblEmlFlg(JSPUtil.getParameter(request, prefix + "sea_wbl_eml_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterUsrInfoVO[]
	 */
	public BkgXterUsrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterUsrInfoVO[]
	 */
	public BkgXterUsrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterUsrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrN1stNm = (JSPUtil.getParameter(request, prefix	+ "usr_n1st_nm", length));
			String[] usrLstNm = (JSPUtil.getParameter(request, prefix	+ "usr_lst_nm", length));
			String[] usrStsCd = (JSPUtil.getParameter(request, prefix	+ "usr_sts_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] rdyFoPrfFlg = (JSPUtil.getParameter(request, prefix	+ "rdy_fo_prf_flg", length));
			String[] rdyFoPrnFlg = (JSPUtil.getParameter(request, prefix	+ "rdy_fo_prn_flg", length));
			String[] seaWblEmlFlg = (JSPUtil.getParameter(request, prefix	+ "sea_wbl_eml_flg", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new BkgXterUsrInfoVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (usrId[i] != null) 
					model.setUsrId(usrId[i]);
				if (usrN1stNm[i] != null) 
					model.setUsrN1stNm(usrN1stNm[i]);
				if (usrLstNm[i] != null) 
					model.setUsrLstNm(usrLstNm[i]);
				if (usrStsCd[i] != null) 
					model.setUsrStsCd(usrStsCd[i]);
				if (custCntCd[i] != null) 
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
					model.setCustSeq(custSeq[i]);
				if (rdyFoPrfFlg[i] != null) 
					model.setRdyFoPrfFlg(rdyFoPrfFlg[i]);
				if (rdyFoPrnFlg[i] != null) 
					model.setRdyFoPrnFlg(rdyFoPrnFlg[i]);
				if (seaWblEmlFlg[i] != null) 
					model.setSeaWblEmlFlg(seaWblEmlFlg[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterUsrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterUsrInfoVO[]
	 */
	public BkgXterUsrInfoVO[] getBkgXterUsrInfoVOs(){
		BkgXterUsrInfoVO[] vos = (BkgXterUsrInfoVO[])models.toArray(new BkgXterUsrInfoVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrN1stNm = this.usrN1stNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrLstNm = this.usrLstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrStsCd = this.usrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdyFoPrfFlg = this.rdyFoPrfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdyFoPrnFlg = this.rdyFoPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaWblEmlFlg = this.seaWblEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
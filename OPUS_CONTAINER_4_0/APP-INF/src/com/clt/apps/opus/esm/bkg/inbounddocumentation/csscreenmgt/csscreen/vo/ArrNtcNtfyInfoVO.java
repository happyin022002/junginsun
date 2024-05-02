/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcNtfyInfoVO.java
*@FileTitle : ArrNtcNtfyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcNtfyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcNtfyInfoVO> models = new ArrayList<ArrNtcNtfyInfoVO>();
	
	/* Column Info */
	private String sndRsltNm2 = null;
	/* Column Info */
	private String sndRsltNm1 = null;
	/* Column Info */
	private String sndRsltNm4 = null;
	/* Column Info */
	private String sndRsltNm3 = null;
	/* Column Info */
	private String sndRsltNm5 = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndRsltCd4 = null;
	/* Column Info */
	private String sndRsltCd3 = null;
	/* Column Info */
	private String sndFlg5 = null;
	/* Column Info */
	private String sndRsltCd5 = null;
	/* Column Info */
	private String sndFlg4 = null;
	/* Column Info */
	private String sndFlg3 = null;
	/* Column Info */
	private String sndFlg2 = null;
	/* Column Info */
	private String sndRsltCd2 = null;
	/* Column Info */
	private String sndFlg1 = null;
	/* Column Info */
	private String sndRsltCd1 = null;
	/* Column Info */
	private String sndNo1 = null;
	/* Column Info */
	private String sndGdt = null;
	/* Column Info */
	private String sndNo4 = null;
	/* Column Info */
	private String sndNo5 = null;
	/* Column Info */
	private String sndNo2 = null;
	/* Column Info */
	private String sndNo3 = null;
	/* Column Info */
	private String kindDesc = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String isEval = null;
	/* Column Info */
	private String chgDpFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcNtfyInfoVO() {}

	public ArrNtcNtfyInfoVO(String ibflag, String pagerows, String kindDesc, String chgDpFlg, String sndNo1, String sndNo2, String sndNo3, String sndNo4, String sndNo5, String sndRsltCd1, String sndRsltCd2, String sndRsltCd3, String sndRsltCd4, String sndRsltCd5, String sndFlg1, String sndFlg2, String sndFlg3, String sndFlg4, String sndFlg5, String sndRsltNm1, String sndRsltNm2, String sndRsltNm3, String sndRsltNm4, String sndRsltNm5, String sndDt, String sndGdt, String diffRmk, String isEval) {
		this.sndRsltNm2 = sndRsltNm2;
		this.sndRsltNm1 = sndRsltNm1;
		this.sndRsltNm4 = sndRsltNm4;
		this.sndRsltNm3 = sndRsltNm3;
		this.sndRsltNm5 = sndRsltNm5;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sndRsltCd4 = sndRsltCd4;
		this.sndRsltCd3 = sndRsltCd3;
		this.sndFlg5 = sndFlg5;
		this.sndRsltCd5 = sndRsltCd5;
		this.sndFlg4 = sndFlg4;
		this.sndFlg3 = sndFlg3;
		this.sndFlg2 = sndFlg2;
		this.sndRsltCd2 = sndRsltCd2;
		this.sndFlg1 = sndFlg1;
		this.sndRsltCd1 = sndRsltCd1;
		this.sndNo1 = sndNo1;
		this.sndGdt = sndGdt;
		this.sndNo4 = sndNo4;
		this.sndNo5 = sndNo5;
		this.sndNo2 = sndNo2;
		this.sndNo3 = sndNo3;
		this.kindDesc = kindDesc;
		this.diffRmk = diffRmk;
		this.isEval = isEval;
		this.chgDpFlg = chgDpFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("snd_rslt_nm2", getSndRsltNm2());
		this.hashColumns.put("snd_rslt_nm1", getSndRsltNm1());
		this.hashColumns.put("snd_rslt_nm4", getSndRsltNm4());
		this.hashColumns.put("snd_rslt_nm3", getSndRsltNm3());
		this.hashColumns.put("snd_rslt_nm5", getSndRsltNm5());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_rslt_cd4", getSndRsltCd4());
		this.hashColumns.put("snd_rslt_cd3", getSndRsltCd3());
		this.hashColumns.put("snd_flg5", getSndFlg5());
		this.hashColumns.put("snd_rslt_cd5", getSndRsltCd5());
		this.hashColumns.put("snd_flg4", getSndFlg4());
		this.hashColumns.put("snd_flg3", getSndFlg3());
		this.hashColumns.put("snd_flg2", getSndFlg2());
		this.hashColumns.put("snd_rslt_cd2", getSndRsltCd2());
		this.hashColumns.put("snd_flg1", getSndFlg1());
		this.hashColumns.put("snd_rslt_cd1", getSndRsltCd1());
		this.hashColumns.put("snd_no1", getSndNo1());
		this.hashColumns.put("snd_gdt", getSndGdt());
		this.hashColumns.put("snd_no4", getSndNo4());
		this.hashColumns.put("snd_no5", getSndNo5());
		this.hashColumns.put("snd_no2", getSndNo2());
		this.hashColumns.put("snd_no3", getSndNo3());
		this.hashColumns.put("kind_desc", getKindDesc());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("is_eval", getIsEval());
		this.hashColumns.put("chg_dp_flg", getChgDpFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("snd_rslt_nm2", "sndRsltNm2");
		this.hashFields.put("snd_rslt_nm1", "sndRsltNm1");
		this.hashFields.put("snd_rslt_nm4", "sndRsltNm4");
		this.hashFields.put("snd_rslt_nm3", "sndRsltNm3");
		this.hashFields.put("snd_rslt_nm5", "sndRsltNm5");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_rslt_cd4", "sndRsltCd4");
		this.hashFields.put("snd_rslt_cd3", "sndRsltCd3");
		this.hashFields.put("snd_flg5", "sndFlg5");
		this.hashFields.put("snd_rslt_cd5", "sndRsltCd5");
		this.hashFields.put("snd_flg4", "sndFlg4");
		this.hashFields.put("snd_flg3", "sndFlg3");
		this.hashFields.put("snd_flg2", "sndFlg2");
		this.hashFields.put("snd_rslt_cd2", "sndRsltCd2");
		this.hashFields.put("snd_flg1", "sndFlg1");
		this.hashFields.put("snd_rslt_cd1", "sndRsltCd1");
		this.hashFields.put("snd_no1", "sndNo1");
		this.hashFields.put("snd_gdt", "sndGdt");
		this.hashFields.put("snd_no4", "sndNo4");
		this.hashFields.put("snd_no5", "sndNo5");
		this.hashFields.put("snd_no2", "sndNo2");
		this.hashFields.put("snd_no3", "sndNo3");
		this.hashFields.put("kind_desc", "kindDesc");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("is_eval", "isEval");
		this.hashFields.put("chg_dp_flg", "chgDpFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sndRsltNm2
	 */
	public String getSndRsltNm2() {
		return this.sndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @return sndRsltNm1
	 */
	public String getSndRsltNm1() {
		return this.sndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @return sndRsltNm4
	 */
	public String getSndRsltNm4() {
		return this.sndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return sndRsltNm3
	 */
	public String getSndRsltNm3() {
		return this.sndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return sndRsltNm5
	 */
	public String getSndRsltNm5() {
		return this.sndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sndRsltCd4
	 */
	public String getSndRsltCd4() {
		return this.sndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return sndRsltCd3
	 */
	public String getSndRsltCd3() {
		return this.sndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return sndFlg5
	 */
	public String getSndFlg5() {
		return this.sndFlg5;
	}
	
	/**
	 * Column Info
	 * @return sndRsltCd5
	 */
	public String getSndRsltCd5() {
		return this.sndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @return sndFlg4
	 */
	public String getSndFlg4() {
		return this.sndFlg4;
	}
	
	/**
	 * Column Info
	 * @return sndFlg3
	 */
	public String getSndFlg3() {
		return this.sndFlg3;
	}
	
	/**
	 * Column Info
	 * @return sndFlg2
	 */
	public String getSndFlg2() {
		return this.sndFlg2;
	}
	
	/**
	 * Column Info
	 * @return sndRsltCd2
	 */
	public String getSndRsltCd2() {
		return this.sndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return sndFlg1
	 */
	public String getSndFlg1() {
		return this.sndFlg1;
	}
	
	/**
	 * Column Info
	 * @return sndRsltCd1
	 */
	public String getSndRsltCd1() {
		return this.sndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @return sndNo1
	 */
	public String getSndNo1() {
		return this.sndNo1;
	}
	
	/**
	 * Column Info
	 * @return sndGdt
	 */
	public String getSndGdt() {
		return this.sndGdt;
	}
	
	/**
	 * Column Info
	 * @return sndNo4
	 */
	public String getSndNo4() {
		return this.sndNo4;
	}
	
	/**
	 * Column Info
	 * @return sndNo5
	 */
	public String getSndNo5() {
		return this.sndNo5;
	}
	
	/**
	 * Column Info
	 * @return sndNo2
	 */
	public String getSndNo2() {
		return this.sndNo2;
	}
	
	/**
	 * Column Info
	 * @return sndNo3
	 */
	public String getSndNo3() {
		return this.sndNo3;
	}
	
	/**
	 * Column Info
	 * @return kindDesc
	 */
	public String getKindDesc() {
		return this.kindDesc;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return isEval
	 */
	public String getIsEval() {
		return this.isEval;
	}
	
	/**
	 * Column Info
	 * @return chgDpFlg
	 */
	public String getChgDpFlg() {
		return this.chgDpFlg;
	}
	

	/**
	 * Column Info
	 * @param sndRsltNm2
	 */
	public void setSndRsltNm2(String sndRsltNm2) {
		this.sndRsltNm2 = sndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @param sndRsltNm1
	 */
	public void setSndRsltNm1(String sndRsltNm1) {
		this.sndRsltNm1 = sndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @param sndRsltNm4
	 */
	public void setSndRsltNm4(String sndRsltNm4) {
		this.sndRsltNm4 = sndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param sndRsltNm3
	 */
	public void setSndRsltNm3(String sndRsltNm3) {
		this.sndRsltNm3 = sndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param sndRsltNm5
	 */
	public void setSndRsltNm5(String sndRsltNm5) {
		this.sndRsltNm5 = sndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param sndRsltCd4
	 */
	public void setSndRsltCd4(String sndRsltCd4) {
		this.sndRsltCd4 = sndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param sndRsltCd3
	 */
	public void setSndRsltCd3(String sndRsltCd3) {
		this.sndRsltCd3 = sndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param sndFlg5
	 */
	public void setSndFlg5(String sndFlg5) {
		this.sndFlg5 = sndFlg5;
	}
	
	/**
	 * Column Info
	 * @param sndRsltCd5
	 */
	public void setSndRsltCd5(String sndRsltCd5) {
		this.sndRsltCd5 = sndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @param sndFlg4
	 */
	public void setSndFlg4(String sndFlg4) {
		this.sndFlg4 = sndFlg4;
	}
	
	/**
	 * Column Info
	 * @param sndFlg3
	 */
	public void setSndFlg3(String sndFlg3) {
		this.sndFlg3 = sndFlg3;
	}
	
	/**
	 * Column Info
	 * @param sndFlg2
	 */
	public void setSndFlg2(String sndFlg2) {
		this.sndFlg2 = sndFlg2;
	}
	
	/**
	 * Column Info
	 * @param sndRsltCd2
	 */
	public void setSndRsltCd2(String sndRsltCd2) {
		this.sndRsltCd2 = sndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param sndFlg1
	 */
	public void setSndFlg1(String sndFlg1) {
		this.sndFlg1 = sndFlg1;
	}
	
	/**
	 * Column Info
	 * @param sndRsltCd1
	 */
	public void setSndRsltCd1(String sndRsltCd1) {
		this.sndRsltCd1 = sndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @param sndNo1
	 */
	public void setSndNo1(String sndNo1) {
		this.sndNo1 = sndNo1;
	}
	
	/**
	 * Column Info
	 * @param sndGdt
	 */
	public void setSndGdt(String sndGdt) {
		this.sndGdt = sndGdt;
	}
	
	/**
	 * Column Info
	 * @param sndNo4
	 */
	public void setSndNo4(String sndNo4) {
		this.sndNo4 = sndNo4;
	}
	
	/**
	 * Column Info
	 * @param sndNo5
	 */
	public void setSndNo5(String sndNo5) {
		this.sndNo5 = sndNo5;
	}
	
	/**
	 * Column Info
	 * @param sndNo2
	 */
	public void setSndNo2(String sndNo2) {
		this.sndNo2 = sndNo2;
	}
	
	/**
	 * Column Info
	 * @param sndNo3
	 */
	public void setSndNo3(String sndNo3) {
		this.sndNo3 = sndNo3;
	}
	
	/**
	 * Column Info
	 * @param kindDesc
	 */
	public void setKindDesc(String kindDesc) {
		this.kindDesc = kindDesc;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param isEval
	 */
	public void setIsEval(String isEval) {
		this.isEval = isEval;
	}
	
	/**
	 * Column Info
	 * @param chgDpFlg
	 */
	public void setChgDpFlg(String chgDpFlg) {
		this.chgDpFlg = chgDpFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSndRsltNm2(JSPUtil.getParameter(request, "snd_rslt_nm2", ""));
		setSndRsltNm1(JSPUtil.getParameter(request, "snd_rslt_nm1", ""));
		setSndRsltNm4(JSPUtil.getParameter(request, "snd_rslt_nm4", ""));
		setSndRsltNm3(JSPUtil.getParameter(request, "snd_rslt_nm3", ""));
		setSndRsltNm5(JSPUtil.getParameter(request, "snd_rslt_nm5", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndRsltCd4(JSPUtil.getParameter(request, "snd_rslt_cd4", ""));
		setSndRsltCd3(JSPUtil.getParameter(request, "snd_rslt_cd3", ""));
		setSndFlg5(JSPUtil.getParameter(request, "snd_flg5", ""));
		setSndRsltCd5(JSPUtil.getParameter(request, "snd_rslt_cd5", ""));
		setSndFlg4(JSPUtil.getParameter(request, "snd_flg4", ""));
		setSndFlg3(JSPUtil.getParameter(request, "snd_flg3", ""));
		setSndFlg2(JSPUtil.getParameter(request, "snd_flg2", ""));
		setSndRsltCd2(JSPUtil.getParameter(request, "snd_rslt_cd2", ""));
		setSndFlg1(JSPUtil.getParameter(request, "snd_flg1", ""));
		setSndRsltCd1(JSPUtil.getParameter(request, "snd_rslt_cd1", ""));
		setSndNo1(JSPUtil.getParameter(request, "snd_no1", ""));
		setSndGdt(JSPUtil.getParameter(request, "snd_gdt", ""));
		setSndNo4(JSPUtil.getParameter(request, "snd_no4", ""));
		setSndNo5(JSPUtil.getParameter(request, "snd_no5", ""));
		setSndNo2(JSPUtil.getParameter(request, "snd_no2", ""));
		setSndNo3(JSPUtil.getParameter(request, "snd_no3", ""));
		setKindDesc(JSPUtil.getParameter(request, "kind_desc", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setIsEval(JSPUtil.getParameter(request, "is_eval", ""));
		setChgDpFlg(JSPUtil.getParameter(request, "chg_dp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcNtfyInfoVO[]
	 */
	public ArrNtcNtfyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcNtfyInfoVO[]
	 */
	public ArrNtcNtfyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcNtfyInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_nm2", length));
			String[] sndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_nm1", length));
			String[] sndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_nm4", length));
			String[] sndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_nm3", length));
			String[] sndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_nm5", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_cd4", length));
			String[] sndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_cd3", length));
			String[] sndFlg5 = (JSPUtil.getParameter(request, prefix	+ "snd_flg5", length));
			String[] sndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_cd5", length));
			String[] sndFlg4 = (JSPUtil.getParameter(request, prefix	+ "snd_flg4", length));
			String[] sndFlg3 = (JSPUtil.getParameter(request, prefix	+ "snd_flg3", length));
			String[] sndFlg2 = (JSPUtil.getParameter(request, prefix	+ "snd_flg2", length));
			String[] sndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_cd2", length));
			String[] sndFlg1 = (JSPUtil.getParameter(request, prefix	+ "snd_flg1", length));
			String[] sndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "snd_rslt_cd1", length));
			String[] sndNo1 = (JSPUtil.getParameter(request, prefix	+ "snd_no1", length));
			String[] sndGdt = (JSPUtil.getParameter(request, prefix	+ "snd_gdt", length));
			String[] sndNo4 = (JSPUtil.getParameter(request, prefix	+ "snd_no4", length));
			String[] sndNo5 = (JSPUtil.getParameter(request, prefix	+ "snd_no5", length));
			String[] sndNo2 = (JSPUtil.getParameter(request, prefix	+ "snd_no2", length));
			String[] sndNo3 = (JSPUtil.getParameter(request, prefix	+ "snd_no3", length));
			String[] kindDesc = (JSPUtil.getParameter(request, prefix	+ "kind_desc", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] isEval = (JSPUtil.getParameter(request, prefix	+ "is_eval", length));
			String[] chgDpFlg = (JSPUtil.getParameter(request, prefix	+ "chg_dp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcNtfyInfoVO();
				if (sndRsltNm2[i] != null)
					model.setSndRsltNm2(sndRsltNm2[i]);
				if (sndRsltNm1[i] != null)
					model.setSndRsltNm1(sndRsltNm1[i]);
				if (sndRsltNm4[i] != null)
					model.setSndRsltNm4(sndRsltNm4[i]);
				if (sndRsltNm3[i] != null)
					model.setSndRsltNm3(sndRsltNm3[i]);
				if (sndRsltNm5[i] != null)
					model.setSndRsltNm5(sndRsltNm5[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndRsltCd4[i] != null)
					model.setSndRsltCd4(sndRsltCd4[i]);
				if (sndRsltCd3[i] != null)
					model.setSndRsltCd3(sndRsltCd3[i]);
				if (sndFlg5[i] != null)
					model.setSndFlg5(sndFlg5[i]);
				if (sndRsltCd5[i] != null)
					model.setSndRsltCd5(sndRsltCd5[i]);
				if (sndFlg4[i] != null)
					model.setSndFlg4(sndFlg4[i]);
				if (sndFlg3[i] != null)
					model.setSndFlg3(sndFlg3[i]);
				if (sndFlg2[i] != null)
					model.setSndFlg2(sndFlg2[i]);
				if (sndRsltCd2[i] != null)
					model.setSndRsltCd2(sndRsltCd2[i]);
				if (sndFlg1[i] != null)
					model.setSndFlg1(sndFlg1[i]);
				if (sndRsltCd1[i] != null)
					model.setSndRsltCd1(sndRsltCd1[i]);
				if (sndNo1[i] != null)
					model.setSndNo1(sndNo1[i]);
				if (sndGdt[i] != null)
					model.setSndGdt(sndGdt[i]);
				if (sndNo4[i] != null)
					model.setSndNo4(sndNo4[i]);
				if (sndNo5[i] != null)
					model.setSndNo5(sndNo5[i]);
				if (sndNo2[i] != null)
					model.setSndNo2(sndNo2[i]);
				if (sndNo3[i] != null)
					model.setSndNo3(sndNo3[i]);
				if (kindDesc[i] != null)
					model.setKindDesc(kindDesc[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (isEval[i] != null)
					model.setIsEval(isEval[i]);
				if (chgDpFlg[i] != null)
					model.setChgDpFlg(chgDpFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcNtfyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcNtfyInfoVO[]
	 */
	public ArrNtcNtfyInfoVO[] getArrNtcNtfyInfoVOs(){
		ArrNtcNtfyInfoVO[] vos = (ArrNtcNtfyInfoVO[])models.toArray(new ArrNtcNtfyInfoVO[models.size()]);
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
		this.sndRsltNm2 = this.sndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltNm1 = this.sndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltNm4 = this.sndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltNm3 = this.sndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltNm5 = this.sndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltCd4 = this.sndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltCd3 = this.sndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg5 = this.sndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltCd5 = this.sndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg4 = this.sndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg3 = this.sndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg2 = this.sndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltCd2 = this.sndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg1 = this.sndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRsltCd1 = this.sndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNo1 = this.sndNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndGdt = this.sndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNo4 = this.sndNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNo5 = this.sndNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNo2 = this.sndNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndNo3 = this.sndNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindDesc = this.kindDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isEval = this.isEval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDpFlg = this.chgDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

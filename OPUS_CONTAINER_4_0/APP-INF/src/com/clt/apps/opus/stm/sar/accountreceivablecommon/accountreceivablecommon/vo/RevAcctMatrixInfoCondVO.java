/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RevAcctMatrixInfoCondVO.java
*@FileTitle : RevAcctMatrixInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class RevAcctMatrixInfoCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevAcctMatrixInfoCondVO> models = new ArrayList<RevAcctMatrixInfoCondVO>();
	
	/* Column Info */
	private String fArAcctCd = null;
	/* Column Info */
	private String fDupAcctCtnt1 = null;
	/* Column Info */
	private String fDupAcctCtnt2 = null;
	/* Column Info */
	private String fDupChk = null;
	/* Column Info */
	private String fDupAcctTpCd = null;
	/* Column Info */
	private String fAcctCtnt8 = null;
	/* Column Info */
	private String fAcctCtnt7 = null;
	/* Column Info */
	private String fAcctCtnt6 = null;
	/* Column Info */
	private String fRevAcctDivCd = null;
	/* Column Info */
	private String fAcctCtnt5 = null;
	/* Column Info */
	private String fAcctCtnt4 = null;
	/* Column Info */
	private String fAcctCtnt3 = null;
	/* Column Info */
	private String fAcctTpCd = null;
	/* Column Info */
	private String fAcctCtnt2 = null;
	/* Column Info */
	private String fAcctCtnt1 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fDeltFlg = null;
	/* Column Info */
	private String fDupAcctCtnt4 = null;
	/* Column Info */
	private String fDupAcctCtnt3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RevAcctMatrixInfoCondVO() {}

	public RevAcctMatrixInfoCondVO(String ibflag, String pagerows, String fDupAcctCtnt1, String fDupAcctCtnt2, String fDupChk, String fDupAcctTpCd, String fAcctCtnt8, String fAcctCtnt7, String fAcctCtnt6, String fRevAcctDivCd, String fAcctCtnt5, String fAcctCtnt4, String fAcctCtnt3, String fAcctCtnt2, String fAcctTpCd, String fAcctCtnt1, String fDeltFlg, String fDupAcctCtnt4, String fDupAcctCtnt3, String fArAcctCd) {
		this.fArAcctCd = fArAcctCd;
		this.fDupAcctCtnt1 = fDupAcctCtnt1;
		this.fDupAcctCtnt2 = fDupAcctCtnt2;
		this.fDupChk = fDupChk;
		this.fDupAcctTpCd = fDupAcctTpCd;
		this.fAcctCtnt8 = fAcctCtnt8;
		this.fAcctCtnt7 = fAcctCtnt7;
		this.fAcctCtnt6 = fAcctCtnt6;
		this.fRevAcctDivCd = fRevAcctDivCd;
		this.fAcctCtnt5 = fAcctCtnt5;
		this.fAcctCtnt4 = fAcctCtnt4;
		this.fAcctCtnt3 = fAcctCtnt3;
		this.fAcctTpCd = fAcctTpCd;
		this.fAcctCtnt2 = fAcctCtnt2;
		this.fAcctCtnt1 = fAcctCtnt1;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fDeltFlg = fDeltFlg;
		this.fDupAcctCtnt4 = fDupAcctCtnt4;
		this.fDupAcctCtnt3 = fDupAcctCtnt3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_ar_acct_cd", getFArAcctCd());
		this.hashColumns.put("f_dup_acct_ctnt1", getFDupAcctCtnt1());
		this.hashColumns.put("f_dup_acct_ctnt2", getFDupAcctCtnt2());
		this.hashColumns.put("f_dup_chk", getFDupChk());
		this.hashColumns.put("f_dup_acct_tp_cd", getFDupAcctTpCd());
		this.hashColumns.put("f_acct_ctnt8", getFAcctCtnt8());
		this.hashColumns.put("f_acct_ctnt7", getFAcctCtnt7());
		this.hashColumns.put("f_acct_ctnt6", getFAcctCtnt6());
		this.hashColumns.put("f_rev_acct_div_cd", getFRevAcctDivCd());
		this.hashColumns.put("f_acct_ctnt5", getFAcctCtnt5());
		this.hashColumns.put("f_acct_ctnt4", getFAcctCtnt4());
		this.hashColumns.put("f_acct_ctnt3", getFAcctCtnt3());
		this.hashColumns.put("f_acct_tp_cd", getFAcctTpCd());
		this.hashColumns.put("f_acct_ctnt2", getFAcctCtnt2());
		this.hashColumns.put("f_acct_ctnt1", getFAcctCtnt1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_delt_flg", getFDeltFlg());
		this.hashColumns.put("f_dup_acct_ctnt4", getFDupAcctCtnt4());
		this.hashColumns.put("f_dup_acct_ctnt3", getFDupAcctCtnt3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_ar_acct_cd", "fArAcctCd");
		this.hashFields.put("f_dup_acct_ctnt1", "fDupAcctCtnt1");
		this.hashFields.put("f_dup_acct_ctnt2", "fDupAcctCtnt2");
		this.hashFields.put("f_dup_chk", "fDupChk");
		this.hashFields.put("f_dup_acct_tp_cd", "fDupAcctTpCd");
		this.hashFields.put("f_acct_ctnt8", "fAcctCtnt8");
		this.hashFields.put("f_acct_ctnt7", "fAcctCtnt7");
		this.hashFields.put("f_acct_ctnt6", "fAcctCtnt6");
		this.hashFields.put("f_rev_acct_div_cd", "fRevAcctDivCd");
		this.hashFields.put("f_acct_ctnt5", "fAcctCtnt5");
		this.hashFields.put("f_acct_ctnt4", "fAcctCtnt4");
		this.hashFields.put("f_acct_ctnt3", "fAcctCtnt3");
		this.hashFields.put("f_acct_tp_cd", "fAcctTpCd");
		this.hashFields.put("f_acct_ctnt2", "fAcctCtnt2");
		this.hashFields.put("f_acct_ctnt1", "fAcctCtnt1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_delt_flg", "fDeltFlg");
		this.hashFields.put("f_dup_acct_ctnt4", "fDupAcctCtnt4");
		this.hashFields.put("f_dup_acct_ctnt3", "fDupAcctCtnt3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fArAcctCd
	 */
	public String getFArAcctCd() {
		return this.fArAcctCd;
	}
	
	/**
	 * Column Info
	 * @return fDupAcctCtnt1
	 */
	public String getFDupAcctCtnt1() {
		return this.fDupAcctCtnt1;
	}
	
	/**
	 * Column Info
	 * @return fDupAcctCtnt2
	 */
	public String getFDupAcctCtnt2() {
		return this.fDupAcctCtnt2;
	}
	
	/**
	 * Column Info
	 * @return fDupChk
	 */
	public String getFDupChk() {
		return this.fDupChk;
	}
	
	/**
	 * Column Info
	 * @return fDupAcctTpCd
	 */
	public String getFDupAcctTpCd() {
		return this.fDupAcctTpCd;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt8
	 */
	public String getFAcctCtnt8() {
		return this.fAcctCtnt8;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt7
	 */
	public String getFAcctCtnt7() {
		return this.fAcctCtnt7;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt6
	 */
	public String getFAcctCtnt6() {
		return this.fAcctCtnt6;
	}
	
	/**
	 * Column Info
	 * @return fRevAcctDivCd
	 */
	public String getFRevAcctDivCd() {
		return this.fRevAcctDivCd;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt5
	 */
	public String getFAcctCtnt5() {
		return this.fAcctCtnt5;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt4
	 */
	public String getFAcctCtnt4() {
		return this.fAcctCtnt4;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt3
	 */
	public String getFAcctCtnt3() {
		return this.fAcctCtnt3;
	}
	
	/**
	 * Column Info
	 * @return fAcctTpCd
	 */
	public String getFAcctTpCd() {
		return this.fAcctTpCd;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt2
	 */
	public String getFAcctCtnt2() {
		return this.fAcctCtnt2;
	}
	
	/**
	 * Column Info
	 * @return fAcctCtnt1
	 */
	public String getFAcctCtnt1() {
		return this.fAcctCtnt1;
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
	 * @return fDeltFlg
	 */
	public String getFDeltFlg() {
		return this.fDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return fDupAcctCtnt4
	 */
	public String getFDupAcctCtnt4() {
		return this.fDupAcctCtnt4;
	}
	
	/**
	 * Column Info
	 * @return fDupAcctCtnt3
	 */
	public String getFDupAcctCtnt3() {
		return this.fDupAcctCtnt3;
	}
	

	/**
	 * Column Info
	 * @param fArAcctCd
	 */
	public void setFArAcctCd(String fArAcctCd) {
		this.fArAcctCd = fArAcctCd;
	}
	
	/**
	 * Column Info
	 * @param fDupAcctCtnt1
	 */
	public void setFDupAcctCtnt1(String fDupAcctCtnt1) {
		this.fDupAcctCtnt1 = fDupAcctCtnt1;
	}
	
	/**
	 * Column Info
	 * @param fDupAcctCtnt2
	 */
	public void setFDupAcctCtnt2(String fDupAcctCtnt2) {
		this.fDupAcctCtnt2 = fDupAcctCtnt2;
	}
	
	/**
	 * Column Info
	 * @param fDupChk
	 */
	public void setFDupChk(String fDupChk) {
		this.fDupChk = fDupChk;
	}
	
	/**
	 * Column Info
	 * @param fDupAcctTpCd
	 */
	public void setFDupAcctTpCd(String fDupAcctTpCd) {
		this.fDupAcctTpCd = fDupAcctTpCd;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt8
	 */
	public void setFAcctCtnt8(String fAcctCtnt8) {
		this.fAcctCtnt8 = fAcctCtnt8;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt7
	 */
	public void setFAcctCtnt7(String fAcctCtnt7) {
		this.fAcctCtnt7 = fAcctCtnt7;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt6
	 */
	public void setFAcctCtnt6(String fAcctCtnt6) {
		this.fAcctCtnt6 = fAcctCtnt6;
	}
	
	/**
	 * Column Info
	 * @param fRevAcctDivCd
	 */
	public void setFRevAcctDivCd(String fRevAcctDivCd) {
		this.fRevAcctDivCd = fRevAcctDivCd;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt5
	 */
	public void setFAcctCtnt5(String fAcctCtnt5) {
		this.fAcctCtnt5 = fAcctCtnt5;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt4
	 */
	public void setFAcctCtnt4(String fAcctCtnt4) {
		this.fAcctCtnt4 = fAcctCtnt4;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt3
	 */
	public void setFAcctCtnt3(String fAcctCtnt3) {
		this.fAcctCtnt3 = fAcctCtnt3;
	}
	
	/**
	 * Column Info
	 * @param fAcctTpCd
	 */
	public void setFAcctTpCd(String fAcctTpCd) {
		this.fAcctTpCd = fAcctTpCd;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt2
	 */
	public void setFAcctCtnt2(String fAcctCtnt2) {
		this.fAcctCtnt2 = fAcctCtnt2;
	}
	
	/**
	 * Column Info
	 * @param fAcctCtnt1
	 */
	public void setFAcctCtnt1(String fAcctCtnt1) {
		this.fAcctCtnt1 = fAcctCtnt1;
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
	 * @param fDeltFlg
	 */
	public void setFDeltFlg(String fDeltFlg) {
		this.fDeltFlg = fDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param fDupAcctCtnt4
	 */
	public void setFDupAcctCtnt4(String fDupAcctCtnt4) {
		this.fDupAcctCtnt4 = fDupAcctCtnt4;
	}
	
	/**
	 * Column Info
	 * @param fDupAcctCtnt3
	 */
	public void setFDupAcctCtnt3(String fDupAcctCtnt3) {
		this.fDupAcctCtnt3 = fDupAcctCtnt3;
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
		setFArAcctCd(JSPUtil.getParameter(request, prefix + "f_ar_acct_cd", ""));
		setFDupAcctCtnt1(JSPUtil.getParameter(request, prefix + "f_dup_acct_ctnt1", ""));
		setFDupAcctCtnt2(JSPUtil.getParameter(request, prefix + "f_dup_acct_ctnt2", ""));
		setFDupChk(JSPUtil.getParameter(request, prefix + "f_dup_chk", ""));
		setFDupAcctTpCd(JSPUtil.getParameter(request, prefix + "f_dup_acct_tp_cd", ""));
		setFAcctCtnt8(JSPUtil.getParameter(request, prefix + "f_acct_ctnt8", ""));
		setFAcctCtnt7(JSPUtil.getParameter(request, prefix + "f_acct_ctnt7", ""));
		setFAcctCtnt6(JSPUtil.getParameter(request, prefix + "f_acct_ctnt6", ""));
		setFRevAcctDivCd(JSPUtil.getParameter(request, prefix + "f_rev_acct_div_cd", ""));
		setFAcctCtnt5(JSPUtil.getParameter(request, prefix + "f_acct_ctnt5", ""));
		setFAcctCtnt4(JSPUtil.getParameter(request, prefix + "f_acct_ctnt4", ""));
		setFAcctCtnt3(JSPUtil.getParameter(request, prefix + "f_acct_ctnt3", ""));
		setFAcctTpCd(JSPUtil.getParameter(request, prefix + "f_acct_tp_cd", ""));
		setFAcctCtnt2(JSPUtil.getParameter(request, prefix + "f_acct_ctnt2", ""));
		setFAcctCtnt1(JSPUtil.getParameter(request, prefix + "f_acct_ctnt1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFDeltFlg(JSPUtil.getParameter(request, prefix + "f_delt_flg", ""));
		setFDupAcctCtnt4(JSPUtil.getParameter(request, prefix + "f_dup_acct_ctnt4", ""));
		setFDupAcctCtnt3(JSPUtil.getParameter(request, prefix + "f_dup_acct_ctnt3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevAcctMatrixInfoCondVO[]
	 */
	public RevAcctMatrixInfoCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevAcctMatrixInfoCondVO[]
	 */
	public RevAcctMatrixInfoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevAcctMatrixInfoCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fArAcctCd = (JSPUtil.getParameter(request, prefix	+ "f_ar_acct_cd", length));
			String[] fDupAcctCtnt1 = (JSPUtil.getParameter(request, prefix	+ "f_dup_acct_ctnt1", length));
			String[] fDupAcctCtnt2 = (JSPUtil.getParameter(request, prefix	+ "f_dup_acct_ctnt2", length));
			String[] fDupChk = (JSPUtil.getParameter(request, prefix	+ "f_dup_chk", length));
			String[] fDupAcctTpCd = (JSPUtil.getParameter(request, prefix	+ "f_dup_acct_tp_cd", length));
			String[] fAcctCtnt8 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt8", length));
			String[] fAcctCtnt7 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt7", length));
			String[] fAcctCtnt6 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt6", length));
			String[] fRevAcctDivCd = (JSPUtil.getParameter(request, prefix	+ "f_rev_acct_div_cd", length));
			String[] fAcctCtnt5 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt5", length));
			String[] fAcctCtnt4 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt4", length));
			String[] fAcctCtnt3 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt3", length));
			String[] fAcctTpCd = (JSPUtil.getParameter(request, prefix	+ "f_acct_tp_cd", length));
			String[] fAcctCtnt2 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt2", length));
			String[] fAcctCtnt1 = (JSPUtil.getParameter(request, prefix	+ "f_acct_ctnt1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fDeltFlg = (JSPUtil.getParameter(request, prefix	+ "f_delt_flg", length));
			String[] fDupAcctCtnt4 = (JSPUtil.getParameter(request, prefix	+ "f_dup_acct_ctnt4", length));
			String[] fDupAcctCtnt3 = (JSPUtil.getParameter(request, prefix	+ "f_dup_acct_ctnt3", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevAcctMatrixInfoCondVO();
				if (fArAcctCd[i] != null)
					model.setFArAcctCd(fArAcctCd[i]);
				if (fDupAcctCtnt1[i] != null)
					model.setFDupAcctCtnt1(fDupAcctCtnt1[i]);
				if (fDupAcctCtnt2[i] != null)
					model.setFDupAcctCtnt2(fDupAcctCtnt2[i]);
				if (fDupChk[i] != null)
					model.setFDupChk(fDupChk[i]);
				if (fDupAcctTpCd[i] != null)
					model.setFDupAcctTpCd(fDupAcctTpCd[i]);
				if (fAcctCtnt8[i] != null)
					model.setFAcctCtnt8(fAcctCtnt8[i]);
				if (fAcctCtnt7[i] != null)
					model.setFAcctCtnt7(fAcctCtnt7[i]);
				if (fAcctCtnt6[i] != null)
					model.setFAcctCtnt6(fAcctCtnt6[i]);
				if (fRevAcctDivCd[i] != null)
					model.setFRevAcctDivCd(fRevAcctDivCd[i]);
				if (fAcctCtnt5[i] != null)
					model.setFAcctCtnt5(fAcctCtnt5[i]);
				if (fAcctCtnt4[i] != null)
					model.setFAcctCtnt4(fAcctCtnt4[i]);
				if (fAcctCtnt3[i] != null)
					model.setFAcctCtnt3(fAcctCtnt3[i]);
				if (fAcctTpCd[i] != null)
					model.setFAcctTpCd(fAcctTpCd[i]);
				if (fAcctCtnt2[i] != null)
					model.setFAcctCtnt2(fAcctCtnt2[i]);
				if (fAcctCtnt1[i] != null)
					model.setFAcctCtnt1(fAcctCtnt1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fDeltFlg[i] != null)
					model.setFDeltFlg(fDeltFlg[i]);
				if (fDupAcctCtnt4[i] != null)
					model.setFDupAcctCtnt4(fDupAcctCtnt4[i]);
				if (fDupAcctCtnt3[i] != null)
					model.setFDupAcctCtnt3(fDupAcctCtnt3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevAcctMatrixInfoCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevAcctMatrixInfoCondVO[]
	 */
	public RevAcctMatrixInfoCondVO[] getRevAcctMatrixInfoCondVOs(){
		RevAcctMatrixInfoCondVO[] vos = (RevAcctMatrixInfoCondVO[])models.toArray(new RevAcctMatrixInfoCondVO[models.size()]);
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
		this.fArAcctCd = this.fArAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDupAcctCtnt1 = this.fDupAcctCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDupAcctCtnt2 = this.fDupAcctCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDupChk = this.fDupChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDupAcctTpCd = this.fDupAcctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt8 = this.fAcctCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt7 = this.fAcctCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt6 = this.fAcctCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevAcctDivCd = this.fRevAcctDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt5 = this.fAcctCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt4 = this.fAcctCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt3 = this.fAcctCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctTpCd = this.fAcctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt2 = this.fAcctCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctCtnt1 = this.fAcctCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeltFlg = this.fDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDupAcctCtnt4 = this.fDupAcctCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDupAcctCtnt3 = this.fDupAcctCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PCFStatusInfoVO.java
*@FileTitle : PCFStatusInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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

public class PCFStatusInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PCFStatusInfoVO> models = new ArrayList<PCFStatusInfoVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amt5 = null;
	/* Column Info */
	private String cnt7 = null;
	/* Column Info */
	private String amt4 = null;
	/* Column Info */
	private String cnt8 = null;
	/* Column Info */
	private String cnt5 = null;
	/* Column Info */
	private String amt7 = null;
	/* Column Info */
	private String cnt6 = null;
	/* Column Info */
	private String amt6 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt1 = null;
	/* Column Info */
	private String cnt3 = null;
	/* Column Info */
	private String cnt4 = null;
	/* Column Info */
	private String cnt1 = null;
	/* Column Info */
	private String amt3 = null;
	/* Column Info */
	private String cnt2 = null;
	/* Column Info */
	private String amt2 = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String tmnlCd = null;
	/* Column Info */
	private String amt8 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PCFStatusInfoVO() {}

	public PCFStatusInfoVO(String ibflag, String pagerows, String chnAgnCd, String tmnlCd, String vvdCd, String cnt1, String amt1, String cnt2, String amt2, String cnt3, String amt3, String cnt4, String amt4, String cnt5, String amt5, String cnt6, String amt6, String cnt7, String amt7, String cnt8, String amt8, String totCnt, String totAmt) {
		this.pagerows = pagerows;
		this.amt5 = amt5;
		this.cnt7 = cnt7;
		this.amt4 = amt4;
		this.cnt8 = cnt8;
		this.cnt5 = cnt5;
		this.amt7 = amt7;
		this.cnt6 = cnt6;
		this.amt6 = amt6;
		this.ibflag = ibflag;
		this.amt1 = amt1;
		this.cnt3 = cnt3;
		this.cnt4 = cnt4;
		this.cnt1 = cnt1;
		this.amt3 = amt3;
		this.cnt2 = cnt2;
		this.amt2 = amt2;
		this.totAmt = totAmt;
		this.vvdCd = vvdCd;
		this.totCnt = totCnt;
		this.chnAgnCd = chnAgnCd;
		this.tmnlCd = tmnlCd;
		this.amt8 = amt8;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt5", getAmt5());
		this.hashColumns.put("cnt7", getCnt7());
		this.hashColumns.put("amt4", getAmt4());
		this.hashColumns.put("cnt8", getCnt8());
		this.hashColumns.put("cnt5", getCnt5());
		this.hashColumns.put("amt7", getAmt7());
		this.hashColumns.put("cnt6", getCnt6());
		this.hashColumns.put("amt6", getAmt6());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt1", getAmt1());
		this.hashColumns.put("cnt3", getCnt3());
		this.hashColumns.put("cnt4", getCnt4());
		this.hashColumns.put("cnt1", getCnt1());
		this.hashColumns.put("amt3", getAmt3());
		this.hashColumns.put("cnt2", getCnt2());
		this.hashColumns.put("amt2", getAmt2());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("tmnl_cd", getTmnlCd());
		this.hashColumns.put("amt8", getAmt8());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt5", "amt5");
		this.hashFields.put("cnt7", "cnt7");
		this.hashFields.put("amt4", "amt4");
		this.hashFields.put("cnt8", "cnt8");
		this.hashFields.put("cnt5", "cnt5");
		this.hashFields.put("amt7", "amt7");
		this.hashFields.put("cnt6", "cnt6");
		this.hashFields.put("amt6", "amt6");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt1", "amt1");
		this.hashFields.put("cnt3", "cnt3");
		this.hashFields.put("cnt4", "cnt4");
		this.hashFields.put("cnt1", "cnt1");
		this.hashFields.put("amt3", "amt3");
		this.hashFields.put("cnt2", "cnt2");
		this.hashFields.put("amt2", "amt2");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("tmnl_cd", "tmnlCd");
		this.hashFields.put("amt8", "amt8");
		return this.hashFields;
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
	 * @return amt5
	 */
	public String getAmt5() {
		return this.amt5;
	}
	
	/**
	 * Column Info
	 * @return cnt7
	 */
	public String getCnt7() {
		return this.cnt7;
	}
	
	/**
	 * Column Info
	 * @return amt4
	 */
	public String getAmt4() {
		return this.amt4;
	}
	
	/**
	 * Column Info
	 * @return cnt8
	 */
	public String getCnt8() {
		return this.cnt8;
	}
	
	/**
	 * Column Info
	 * @return cnt5
	 */
	public String getCnt5() {
		return this.cnt5;
	}
	
	/**
	 * Column Info
	 * @return amt7
	 */
	public String getAmt7() {
		return this.amt7;
	}
	
	/**
	 * Column Info
	 * @return cnt6
	 */
	public String getCnt6() {
		return this.cnt6;
	}
	
	/**
	 * Column Info
	 * @return amt6
	 */
	public String getAmt6() {
		return this.amt6;
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
	 * @return amt1
	 */
	public String getAmt1() {
		return this.amt1;
	}
	
	/**
	 * Column Info
	 * @return cnt3
	 */
	public String getCnt3() {
		return this.cnt3;
	}
	
	/**
	 * Column Info
	 * @return cnt4
	 */
	public String getCnt4() {
		return this.cnt4;
	}
	
	/**
	 * Column Info
	 * @return cnt1
	 */
	public String getCnt1() {
		return this.cnt1;
	}
	
	/**
	 * Column Info
	 * @return amt3
	 */
	public String getAmt3() {
		return this.amt3;
	}
	
	/**
	 * Column Info
	 * @return cnt2
	 */
	public String getCnt2() {
		return this.cnt2;
	}
	
	/**
	 * Column Info
	 * @return amt2
	 */
	public String getAmt2() {
		return this.amt2;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @return tmnlCd
	 */
	public String getTmnlCd() {
		return this.tmnlCd;
	}
	
	/**
	 * Column Info
	 * @return amt8
	 */
	public String getAmt8() {
		return this.amt8;
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
	 * @param amt5
	 */
	public void setAmt5(String amt5) {
		this.amt5 = amt5;
	}
	
	/**
	 * Column Info
	 * @param cnt7
	 */
	public void setCnt7(String cnt7) {
		this.cnt7 = cnt7;
	}
	
	/**
	 * Column Info
	 * @param amt4
	 */
	public void setAmt4(String amt4) {
		this.amt4 = amt4;
	}
	
	/**
	 * Column Info
	 * @param cnt8
	 */
	public void setCnt8(String cnt8) {
		this.cnt8 = cnt8;
	}
	
	/**
	 * Column Info
	 * @param cnt5
	 */
	public void setCnt5(String cnt5) {
		this.cnt5 = cnt5;
	}
	
	/**
	 * Column Info
	 * @param amt7
	 */
	public void setAmt7(String amt7) {
		this.amt7 = amt7;
	}
	
	/**
	 * Column Info
	 * @param cnt6
	 */
	public void setCnt6(String cnt6) {
		this.cnt6 = cnt6;
	}
	
	/**
	 * Column Info
	 * @param amt6
	 */
	public void setAmt6(String amt6) {
		this.amt6 = amt6;
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
	 * @param amt1
	 */
	public void setAmt1(String amt1) {
		this.amt1 = amt1;
	}
	
	/**
	 * Column Info
	 * @param cnt3
	 */
	public void setCnt3(String cnt3) {
		this.cnt3 = cnt3;
	}
	
	/**
	 * Column Info
	 * @param cnt4
	 */
	public void setCnt4(String cnt4) {
		this.cnt4 = cnt4;
	}
	
	/**
	 * Column Info
	 * @param cnt1
	 */
	public void setCnt1(String cnt1) {
		this.cnt1 = cnt1;
	}
	
	/**
	 * Column Info
	 * @param amt3
	 */
	public void setAmt3(String amt3) {
		this.amt3 = amt3;
	}
	
	/**
	 * Column Info
	 * @param cnt2
	 */
	public void setCnt2(String cnt2) {
		this.cnt2 = cnt2;
	}
	
	/**
	 * Column Info
	 * @param amt2
	 */
	public void setAmt2(String amt2) {
		this.amt2 = amt2;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @param tmnlCd
	 */
	public void setTmnlCd(String tmnlCd) {
		this.tmnlCd = tmnlCd;
	}
	
	/**
	 * Column Info
	 * @param amt8
	 */
	public void setAmt8(String amt8) {
		this.amt8 = amt8;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmt5(JSPUtil.getParameter(request, prefix + "amt5", ""));
		setCnt7(JSPUtil.getParameter(request, prefix + "cnt7", ""));
		setAmt4(JSPUtil.getParameter(request, prefix + "amt4", ""));
		setCnt8(JSPUtil.getParameter(request, prefix + "cnt8", ""));
		setCnt5(JSPUtil.getParameter(request, prefix + "cnt5", ""));
		setAmt7(JSPUtil.getParameter(request, prefix + "amt7", ""));
		setCnt6(JSPUtil.getParameter(request, prefix + "cnt6", ""));
		setAmt6(JSPUtil.getParameter(request, prefix + "amt6", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt1(JSPUtil.getParameter(request, prefix + "amt1", ""));
		setCnt3(JSPUtil.getParameter(request, prefix + "cnt3", ""));
		setCnt4(JSPUtil.getParameter(request, prefix + "cnt4", ""));
		setCnt1(JSPUtil.getParameter(request, prefix + "cnt1", ""));
		setAmt3(JSPUtil.getParameter(request, prefix + "amt3", ""));
		setCnt2(JSPUtil.getParameter(request, prefix + "cnt2", ""));
		setAmt2(JSPUtil.getParameter(request, prefix + "amt2", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
		setTmnlCd(JSPUtil.getParameter(request, prefix + "tmnl_cd", ""));
		setAmt8(JSPUtil.getParameter(request, prefix + "amt8", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PCFStatusInfoVO[]
	 */
	public PCFStatusInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PCFStatusInfoVO[]
	 */
	public PCFStatusInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PCFStatusInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt5 = (JSPUtil.getParameter(request, prefix	+ "amt5", length));
			String[] cnt7 = (JSPUtil.getParameter(request, prefix	+ "cnt7", length));
			String[] amt4 = (JSPUtil.getParameter(request, prefix	+ "amt4", length));
			String[] cnt8 = (JSPUtil.getParameter(request, prefix	+ "cnt8", length));
			String[] cnt5 = (JSPUtil.getParameter(request, prefix	+ "cnt5", length));
			String[] amt7 = (JSPUtil.getParameter(request, prefix	+ "amt7", length));
			String[] cnt6 = (JSPUtil.getParameter(request, prefix	+ "cnt6", length));
			String[] amt6 = (JSPUtil.getParameter(request, prefix	+ "amt6", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt1 = (JSPUtil.getParameter(request, prefix	+ "amt1", length));
			String[] cnt3 = (JSPUtil.getParameter(request, prefix	+ "cnt3", length));
			String[] cnt4 = (JSPUtil.getParameter(request, prefix	+ "cnt4", length));
			String[] cnt1 = (JSPUtil.getParameter(request, prefix	+ "cnt1", length));
			String[] amt3 = (JSPUtil.getParameter(request, prefix	+ "amt3", length));
			String[] cnt2 = (JSPUtil.getParameter(request, prefix	+ "cnt2", length));
			String[] amt2 = (JSPUtil.getParameter(request, prefix	+ "amt2", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] tmnlCd = (JSPUtil.getParameter(request, prefix	+ "tmnl_cd", length));
			String[] amt8 = (JSPUtil.getParameter(request, prefix	+ "amt8", length));
			
			for (int i = 0; i < length; i++) {
				model = new PCFStatusInfoVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amt5[i] != null)
					model.setAmt5(amt5[i]);
				if (cnt7[i] != null)
					model.setCnt7(cnt7[i]);
				if (amt4[i] != null)
					model.setAmt4(amt4[i]);
				if (cnt8[i] != null)
					model.setCnt8(cnt8[i]);
				if (cnt5[i] != null)
					model.setCnt5(cnt5[i]);
				if (amt7[i] != null)
					model.setAmt7(amt7[i]);
				if (cnt6[i] != null)
					model.setCnt6(cnt6[i]);
				if (amt6[i] != null)
					model.setAmt6(amt6[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt1[i] != null)
					model.setAmt1(amt1[i]);
				if (cnt3[i] != null)
					model.setCnt3(cnt3[i]);
				if (cnt4[i] != null)
					model.setCnt4(cnt4[i]);
				if (cnt1[i] != null)
					model.setCnt1(cnt1[i]);
				if (amt3[i] != null)
					model.setAmt3(amt3[i]);
				if (cnt2[i] != null)
					model.setCnt2(cnt2[i]);
				if (amt2[i] != null)
					model.setAmt2(amt2[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (tmnlCd[i] != null)
					model.setTmnlCd(tmnlCd[i]);
				if (amt8[i] != null)
					model.setAmt8(amt8[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPCFStatusInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PCFStatusInfoVO[]
	 */
	public PCFStatusInfoVO[] getPCFStatusInfoVOs(){
		PCFStatusInfoVO[] vos = (PCFStatusInfoVO[])models.toArray(new PCFStatusInfoVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt5 = this.amt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt7 = this.cnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt4 = this.amt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt8 = this.cnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt5 = this.cnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt7 = this.amt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt6 = this.cnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt6 = this.amt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt1 = this.amt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt3 = this.cnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt4 = this.cnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt1 = this.cnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt3 = this.amt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt2 = this.cnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt2 = this.amt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlCd = this.tmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt8 = this.amt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

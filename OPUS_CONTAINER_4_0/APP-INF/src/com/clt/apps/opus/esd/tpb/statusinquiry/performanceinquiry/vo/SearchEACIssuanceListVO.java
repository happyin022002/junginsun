/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEACIssuanceListVO.java
*@FileTitle : SearchEACIssuanceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.20 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEACIssuanceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEACIssuanceListVO> models = new ArrayList<SearchEACIssuanceListVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String amtA = null;
	/* Column Info */
	private String amtB = null;
	/* Column Info */
	private String amtC = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String cntTot = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String amtTot = null;
	/* Column Info */
	private String ifRhqCd = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntC = null;
	/* Column Info */
	private String cntB = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String cntA = null;
	/* Column Info */
	private String expnTpCd = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String sOfficeLevel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEACIssuanceListVO() {}

	public SearchEACIssuanceListVO(String ibflag, String pagerows, String sOfficeLevel, String sRhqCdForRhq, String sOfcCdForRhq, String sSdate, String sEdate, String sIfRhqCd, String userOfcCd, String ifRhqCd, String expnTpCd, String cntA, String amtA, String cntB, String amtB, String cntC, String amtC, String cntTot, String amtTot) {
		this.userOfcCd = userOfcCd;
		this.amtA = amtA;
		this.amtB = amtB;
		this.amtC = amtC;
		this.sEdate = sEdate;
		this.cntTot = cntTot;
		this.sSdate = sSdate;
		this.amtTot = amtTot;
		this.ifRhqCd = ifRhqCd;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.pagerows = pagerows;
		this.cntC = cntC;
		this.cntB = cntB;
		this.ibflag = ibflag;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.cntA = cntA;
		this.expnTpCd = expnTpCd;
		this.sIfRhqCd = sIfRhqCd;
		this.sOfficeLevel = sOfficeLevel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("amt_a", getAmtA());
		this.hashColumns.put("amt_b", getAmtB());
		this.hashColumns.put("amt_c", getAmtC());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("cnt_tot", getCntTot());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("amt_tot", getAmtTot());
		this.hashColumns.put("if_rhq_cd", getIfRhqCd());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnt_c", getCntC());
		this.hashColumns.put("cnt_b", getCntB());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("cnt_a", getCntA());
		this.hashColumns.put("expn_tp_cd", getExpnTpCd());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("amt_a", "amtA");
		this.hashFields.put("amt_b", "amtB");
		this.hashFields.put("amt_c", "amtC");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("cnt_tot", "cntTot");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("amt_tot", "amtTot");
		this.hashFields.put("if_rhq_cd", "ifRhqCd");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnt_c", "cntC");
		this.hashFields.put("cnt_b", "cntB");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("cnt_a", "cntA");
		this.hashFields.put("expn_tp_cd", "expnTpCd");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return amtA
	 */
	public String getAmtA() {
		return this.amtA;
	}
	
	/**
	 * Column Info
	 * @return amtB
	 */
	public String getAmtB() {
		return this.amtB;
	}
	
	/**
	 * Column Info
	 * @return amtC
	 */
	public String getAmtC() {
		return this.amtC;
	}
	
	/**
	 * Column Info
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return cntTot
	 */
	public String getCntTot() {
		return this.cntTot;
	}
	
	/**
	 * Column Info
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return amtTot
	 */
	public String getAmtTot() {
		return this.amtTot;
	}
	
	/**
	 * Column Info
	 * @return ifRhqCd
	 */
	public String getIfRhqCd() {
		return this.ifRhqCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCdForRhq
	 */
	public String getSOfcCdForRhq() {
		return this.sOfcCdForRhq;
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
	 * @return cntC
	 */
	public String getCntC() {
		return this.cntC;
	}
	
	/**
	 * Column Info
	 * @return cntB
	 */
	public String getCntB() {
		return this.cntB;
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
	 * @return sRhqCdForRhq
	 */
	public String getSRhqCdForRhq() {
		return this.sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @return cntA
	 */
	public String getCntA() {
		return this.cntA;
	}
	
	/**
	 * Column Info
	 * @return expnTpCd
	 */
	public String getExpnTpCd() {
		return this.expnTpCd;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @return sOfficeLevel
	 */
	public String getSOfficeLevel() {
		return this.sOfficeLevel;
	}
	

	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param amtA
	 */
	public void setAmtA(String amtA) {
		this.amtA = amtA;
	}
	
	/**
	 * Column Info
	 * @param amtB
	 */
	public void setAmtB(String amtB) {
		this.amtB = amtB;
	}
	
	/**
	 * Column Info
	 * @param amtC
	 */
	public void setAmtC(String amtC) {
		this.amtC = amtC;
	}
	
	/**
	 * Column Info
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param cntTot
	 */
	public void setCntTot(String cntTot) {
		this.cntTot = cntTot;
	}
	
	/**
	 * Column Info
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param amtTot
	 */
	public void setAmtTot(String amtTot) {
		this.amtTot = amtTot;
	}
	
	/**
	 * Column Info
	 * @param ifRhqCd
	 */
	public void setIfRhqCd(String ifRhqCd) {
		this.ifRhqCd = ifRhqCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCdForRhq
	 */
	public void setSOfcCdForRhq(String sOfcCdForRhq) {
		this.sOfcCdForRhq = sOfcCdForRhq;
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
	 * @param cntC
	 */
	public void setCntC(String cntC) {
		this.cntC = cntC;
	}
	
	/**
	 * Column Info
	 * @param cntB
	 */
	public void setCntB(String cntB) {
		this.cntB = cntB;
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
	 * @param sRhqCdForRhq
	 */
	public void setSRhqCdForRhq(String sRhqCdForRhq) {
		this.sRhqCdForRhq = sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @param cntA
	 */
	public void setCntA(String cntA) {
		this.cntA = cntA;
	}
	
	/**
	 * Column Info
	 * @param expnTpCd
	 */
	public void setExpnTpCd(String expnTpCd) {
		this.expnTpCd = expnTpCd;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @param sOfficeLevel
	 */
	public void setSOfficeLevel(String sOfficeLevel) {
		this.sOfficeLevel = sOfficeLevel;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setAmtA(JSPUtil.getParameter(request, "amt_a", ""));
		setAmtB(JSPUtil.getParameter(request, "amt_b", ""));
		setAmtC(JSPUtil.getParameter(request, "amt_c", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setCntTot(JSPUtil.getParameter(request, "cnt_tot", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setAmtTot(JSPUtil.getParameter(request, "amt_tot", ""));
		setIfRhqCd(JSPUtil.getParameter(request, "if_rhq_cd", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntC(JSPUtil.getParameter(request, "cnt_c", ""));
		setCntB(JSPUtil.getParameter(request, "cnt_b", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setCntA(JSPUtil.getParameter(request, "cnt_a", ""));
		setExpnTpCd(JSPUtil.getParameter(request, "expn_tp_cd", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEACIssuanceListVO[]
	 */
	public SearchEACIssuanceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEACIssuanceListVO[]
	 */
	public SearchEACIssuanceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEACIssuanceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] amtA = (JSPUtil.getParameter(request, prefix	+ "amt_a", length));
			String[] amtB = (JSPUtil.getParameter(request, prefix	+ "amt_b", length));
			String[] amtC = (JSPUtil.getParameter(request, prefix	+ "amt_c", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] cntTot = (JSPUtil.getParameter(request, prefix	+ "cnt_tot", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] amtTot = (JSPUtil.getParameter(request, prefix	+ "amt_tot", length));
			String[] ifRhqCd = (JSPUtil.getParameter(request, prefix	+ "if_rhq_cd", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntC = (JSPUtil.getParameter(request, prefix	+ "cnt_c", length));
			String[] cntB = (JSPUtil.getParameter(request, prefix	+ "cnt_b", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] cntA = (JSPUtil.getParameter(request, prefix	+ "cnt_a", length));
			String[] expnTpCd = (JSPUtil.getParameter(request, prefix	+ "expn_tp_cd", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEACIssuanceListVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (amtA[i] != null)
					model.setAmtA(amtA[i]);
				if (amtB[i] != null)
					model.setAmtB(amtB[i]);
				if (amtC[i] != null)
					model.setAmtC(amtC[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (cntTot[i] != null)
					model.setCntTot(cntTot[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (amtTot[i] != null)
					model.setAmtTot(amtTot[i]);
				if (ifRhqCd[i] != null)
					model.setIfRhqCd(ifRhqCd[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntC[i] != null)
					model.setCntC(cntC[i]);
				if (cntB[i] != null)
					model.setCntB(cntB[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (cntA[i] != null)
					model.setCntA(cntA[i]);
				if (expnTpCd[i] != null)
					model.setExpnTpCd(expnTpCd[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (sOfficeLevel[i] != null)
					model.setSOfficeLevel(sOfficeLevel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEACIssuanceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEACIssuanceListVO[]
	 */
	public SearchEACIssuanceListVO[] getSearchEACIssuanceListVOs(){
		SearchEACIssuanceListVO[] vos = (SearchEACIssuanceListVO[])models.toArray(new SearchEACIssuanceListVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtA = this.amtA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtB = this.amtB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtC = this.amtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTot = this.cntTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtTot = this.amtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRhqCd = this.ifRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntC = this.cntC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntB = this.cntB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntA = this.cntA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTpCd = this.expnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

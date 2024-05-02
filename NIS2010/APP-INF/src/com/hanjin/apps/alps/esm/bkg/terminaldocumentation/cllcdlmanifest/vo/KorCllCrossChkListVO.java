/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorCllCrossChkListVO.java
*@FileTitle : KorCllCrossChkListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.11.07 민정호 
* 1.0 Creation
* 
* 2011.11.10 민정호 [CHM-201114288] Container Loadign Cross-Check (KOR) 기능 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllCrossChkListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCllCrossChkListVO> models = new ArrayList<KorCllCrossChkListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrnoM = null;
	/* Column Info */
	private String cntrnoCll = null;
	/* Column Info */
	private String matchCnt = null;
	/* Column Info */
	private String podBl = null;
	/* Column Info */
	private String podCll = null;
	/* Column Info */
	private String bl = null;
	/* Column Info */
	private String podM = null;
	/* Column Info */
	private String unmatchCnt = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String cntrnoBl = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCllCrossChkListVO() {}

	public KorCllCrossChkListVO(String ibflag, String pagerows, String bl, String podCll, String podBl, String podM, String cntrnoCll, String cntrnoBl, String cntrnoM, String totalCnt, String matchCnt, String unmatchCnt) {
		this.ibflag = ibflag;
		this.cntrnoM = cntrnoM;
		this.cntrnoCll = cntrnoCll;
		this.matchCnt = matchCnt;
		this.podBl = podBl;
		this.podCll = podCll;
		this.bl = bl;
		this.podM = podM;
		this.unmatchCnt = unmatchCnt;
		this.totalCnt = totalCnt;
		this.cntrnoBl = cntrnoBl;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntrno_m", getCntrnoM());
		this.hashColumns.put("cntrno_cll", getCntrnoCll());
		this.hashColumns.put("match_cnt", getMatchCnt());
		this.hashColumns.put("pod_bl", getPodBl());
		this.hashColumns.put("pod_cll", getPodCll());
		this.hashColumns.put("bl", getBl());
		this.hashColumns.put("pod_m", getPodM());
		this.hashColumns.put("unmatch_cnt", getUnmatchCnt());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("cntrno_bl", getCntrnoBl());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntrno_m", "cntrnoM");
		this.hashFields.put("cntrno_cll", "cntrnoCll");
		this.hashFields.put("match_cnt", "matchCnt");
		this.hashFields.put("pod_bl", "podBl");
		this.hashFields.put("pod_cll", "podCll");
		this.hashFields.put("bl", "bl");
		this.hashFields.put("pod_m", "podM");
		this.hashFields.put("unmatch_cnt", "unmatchCnt");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("cntrno_bl", "cntrnoBl");
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
	 * @return cntrnoM
	 */
	public String getCntrnoM() {
		return this.cntrnoM;
	}
	
	/**
	 * Column Info
	 * @return cntrnoCll
	 */
	public String getCntrnoCll() {
		return this.cntrnoCll;
	}
	
	/**
	 * Column Info
	 * @return matchCnt
	 */
	public String getMatchCnt() {
		return this.matchCnt;
	}
	
	/**
	 * Column Info
	 * @return podBl
	 */
	public String getPodBl() {
		return this.podBl;
	}
	
	/**
	 * Column Info
	 * @return podCll
	 */
	public String getPodCll() {
		return this.podCll;
	}
	
	/**
	 * Column Info
	 * @return bl
	 */
	public String getBl() {
		return this.bl;
	}
	
	/**
	 * Column Info
	 * @return podM
	 */
	public String getPodM() {
		return this.podM;
	}
	
	/**
	 * Column Info
	 * @return unmatchCnt
	 */
	public String getUnmatchCnt() {
		return this.unmatchCnt;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return cntrnoBl
	 */
	public String getCntrnoBl() {
		return this.cntrnoBl;
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
	 * @param cntrnoM
	 */
	public void setCntrnoM(String cntrnoM) {
		this.cntrnoM = cntrnoM;
	}
	
	/**
	 * Column Info
	 * @param cntrnoCll
	 */
	public void setCntrnoCll(String cntrnoCll) {
		this.cntrnoCll = cntrnoCll;
	}
	
	/**
	 * Column Info
	 * @param matchCnt
	 */
	public void setMatchCnt(String matchCnt) {
		this.matchCnt = matchCnt;
	}
	
	/**
	 * Column Info
	 * @param podBl
	 */
	public void setPodBl(String podBl) {
		this.podBl = podBl;
	}
	
	/**
	 * Column Info
	 * @param podCll
	 */
	public void setPodCll(String podCll) {
		this.podCll = podCll;
	}
	
	/**
	 * Column Info
	 * @param bl
	 */
	public void setBl(String bl) {
		this.bl = bl;
	}
	
	/**
	 * Column Info
	 * @param podM
	 */
	public void setPodM(String podM) {
		this.podM = podM;
	}
	
	/**
	 * Column Info
	 * @param unmatchCnt
	 */
	public void setUnmatchCnt(String unmatchCnt) {
		this.unmatchCnt = unmatchCnt;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param cntrnoBl
	 */
	public void setCntrnoBl(String cntrnoBl) {
		this.cntrnoBl = cntrnoBl;
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
		setCntrnoM(JSPUtil.getParameter(request, prefix + "cntrno_m", ""));
		setCntrnoCll(JSPUtil.getParameter(request, prefix + "cntrno_cll", ""));
		setMatchCnt(JSPUtil.getParameter(request, prefix + "match_cnt", ""));
		setPodBl(JSPUtil.getParameter(request, prefix + "pod_bl", ""));
		setPodCll(JSPUtil.getParameter(request, prefix + "pod_cll", ""));
		setBl(JSPUtil.getParameter(request, prefix + "bl", ""));
		setPodM(JSPUtil.getParameter(request, prefix + "pod_m", ""));
		setUnmatchCnt(JSPUtil.getParameter(request, prefix + "unmatch_cnt", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setCntrnoBl(JSPUtil.getParameter(request, prefix + "cntrno_bl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllCrossChkListVO[]
	 */
	public KorCllCrossChkListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCllCrossChkListVO[]
	 */
	public KorCllCrossChkListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllCrossChkListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrnoM = (JSPUtil.getParameter(request, prefix	+ "cntrno_m", length));
			String[] cntrnoCll = (JSPUtil.getParameter(request, prefix	+ "cntrno_cll", length));
			String[] matchCnt = (JSPUtil.getParameter(request, prefix	+ "match_cnt", length));
			String[] podBl = (JSPUtil.getParameter(request, prefix	+ "pod_bl", length));
			String[] podCll = (JSPUtil.getParameter(request, prefix	+ "pod_cll", length));
			String[] bl = (JSPUtil.getParameter(request, prefix	+ "bl", length));
			String[] podM = (JSPUtil.getParameter(request, prefix	+ "pod_m", length));
			String[] unmatchCnt = (JSPUtil.getParameter(request, prefix	+ "unmatch_cnt", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] cntrnoBl = (JSPUtil.getParameter(request, prefix	+ "cntrno_bl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCllCrossChkListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrnoM[i] != null)
					model.setCntrnoM(cntrnoM[i]);
				if (cntrnoCll[i] != null)
					model.setCntrnoCll(cntrnoCll[i]);
				if (matchCnt[i] != null)
					model.setMatchCnt(matchCnt[i]);
				if (podBl[i] != null)
					model.setPodBl(podBl[i]);
				if (podCll[i] != null)
					model.setPodCll(podCll[i]);
				if (bl[i] != null)
					model.setBl(bl[i]);
				if (podM[i] != null)
					model.setPodM(podM[i]);
				if (unmatchCnt[i] != null)
					model.setUnmatchCnt(unmatchCnt[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (cntrnoBl[i] != null)
					model.setCntrnoBl(cntrnoBl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllCrossChkListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllCrossChkListVO[]
	 */
	public KorCllCrossChkListVO[] getKorCllCrossChkListVOs(){
		KorCllCrossChkListVO[] vos = (KorCllCrossChkListVO[])models.toArray(new KorCllCrossChkListVO[models.size()]);
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
		this.cntrnoM = this.cntrnoM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnoCll = this.cntrnoCll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchCnt = this.matchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBl = this.podBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCll = this.podCll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bl = this.bl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podM = this.podM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmatchCnt = this.unmatchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnoBl = this.cntrnoBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

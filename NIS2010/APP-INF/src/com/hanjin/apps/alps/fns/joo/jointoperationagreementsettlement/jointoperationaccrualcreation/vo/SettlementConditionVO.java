/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SettlementConditionVO.java
*@FileTitle : SettlementConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.08.11 이준범 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SettlementConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SettlementConditionVO> models = new ArrayList<SettlementConditionVO>();
	
	/* Column Info */
	private String creFlg = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String adjust = null;	
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String revYrmonFr = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String revYrmonTo = null;
	/* Column Info */
	private String searchGubun = null;		// 1:Retrieve, 2:Target Retrieve 3:I/F Retrieve
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SettlementConditionVO() {}

	public SettlementConditionVO(String ibflag, String pagerows, String reDivrCd, String exeYrmon, String joCrrCd, String trdCd, String rlaneCd, String revYrmonFr, String revYrmonTo, String ofcCd, String creFlg, String pageNo, String usrId, String vvd, String diff, String acctCd, String estmVvdTpCd, String adjust, String searchGubun) {
		this.creFlg = creFlg;
		this.diff = diff;
		this.adjust = adjust;		
		this.exeYrmon = exeYrmon;
		this.joCrrCd = joCrrCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.estmVvdTpCd = estmVvdTpCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.revYrmonFr = revYrmonFr;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.pageNo = pageNo;
		this.acctCd = acctCd;
		this.reDivrCd = reDivrCd;
		this.revYrmonTo = revYrmonTo;
		this.searchGubun = searchGubun;				
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_flg", getCreFlg());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("adjust", getAdjust());		
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rev_yrmon_fr", getRevYrmonFr());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("rev_yrmon_to", getRevYrmonTo());
		this.hashColumns.put("search_gubun", getSearchGubun());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_flg", "creFlg");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("adjust", "adjust");		
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rev_yrmon_fr", "revYrmonFr");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("rev_yrmon_to", "revYrmonTo");
		this.hashFields.put("search_gubun", "searchGubun");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creFlg
	 */
	public String getCreFlg() {
		return this.creFlg;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return adjust
	 */
	public String getAdjust() {
		return this.adjust;
	}
		
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return revYrmonFr
	 */
	public String getRevYrmonFr() {
		return this.revYrmonFr;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return revYrmonTo
	 */
	public String getRevYrmonTo() {
		return this.revYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return searchGubun
	 */
	public String getSearchGubun() {
		return this.searchGubun;
	}

	
	/**
	 * Column Info
	 * @param creFlg
	 */
	public void setCreFlg(String creFlg) {
		this.creFlg = creFlg;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param adjust
	 */
	public void setAdjust(String adjust) {
		this.adjust = adjust;
	}	
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param revYrmonFr
	 */
	public void setRevYrmonFr(String revYrmonFr) {
		this.revYrmonFr = revYrmonFr;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param revYrmonTo
	 */
	public void setRevYrmonTo(String revYrmonTo) {
		this.revYrmonTo = revYrmonTo;
	}

	/**
	 * Column Info
	 * @param searchGubun
	 */
	public void setSearchGubun(String searchGubun) {
		this.searchGubun = searchGubun;
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
		setCreFlg(JSPUtil.getParameter(request, prefix + "cre_flg", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setAdjust(JSPUtil.getParameter(request, prefix + "adjust", ""));		
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRevYrmonFr(JSPUtil.getParameter(request, prefix + "rev_yrmon_fr", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setRevYrmonTo(JSPUtil.getParameter(request, prefix + "rev_yrmon_to", ""));
		setSearchGubun(JSPUtil.getParameter(request, prefix + "search_gubun", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementConditionVO[]
	 */
	public SettlementConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SettlementConditionVO[]
	 */
	public SettlementConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SettlementConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creFlg = (JSPUtil.getParameter(request, prefix	+ "cre_flg", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] adjust = (JSPUtil.getParameter(request, prefix	+ "adjust", length));			
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] revYrmonFr = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_fr", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] revYrmonTo = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_to", length));
			String[] searchGubun = (JSPUtil.getParameter(request, prefix	+ "search_gubun", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SettlementConditionVO();
				if (creFlg[i] != null)
					model.setCreFlg(creFlg[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (adjust[i] != null)
					model.setAdjust(adjust[i]);				
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (revYrmonFr[i] != null)
					model.setRevYrmonFr(revYrmonFr[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (revYrmonTo[i] != null)
					model.setRevYrmonTo(revYrmonTo[i]);
				if (searchGubun[i] != null)
					model.setSearchGubun(searchGubun[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSettlementConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SettlementConditionVO[]
	 */
	public SettlementConditionVO[] getSettlementConditionVOs(){
		SettlementConditionVO[] vos = (SettlementConditionVO[])models.toArray(new SettlementConditionVO[models.size()]);
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
		this.creFlg = this.creFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjust = this.adjust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmonFr = this.revYrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmonTo = this.revYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchGubun = this.searchGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}

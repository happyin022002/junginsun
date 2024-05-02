/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchScgRequestApvlTimeOutputVO.java
*@FileTitle : SearchScgRequestApvlTimeOutputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.12.14 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScgRequestApvlTimeOutputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScgRequestApvlTimeOutputVO> models = new ArrayList<SearchScgRequestApvlTimeOutputVO>();
	
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String inBb = null;
	/* Column Info */
	private String inDg = null;
	/* Column Info */
	private String tBb = null;
	/* Column Info */
	private String outDg = null;
	/* Column Info */
	private String tAk = null;
	/* Column Info */
	private String outAk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inAk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tDg = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String tRf = null;
	/* Column Info */
	private String outRf = null;
	/* Column Info */
	private String inRf = null;
	/* Column Info */
	private String outBb = null;

	private String inSs = null;
	private String outSs = null;
	private String tSs = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScgRequestApvlTimeOutputVO() {}

	public SearchScgRequestApvlTimeOutputVO(String ibflag, String pagerows, String rgnShpOprCd, String term, String tDg, String inDg, String outDg, String tAk, String inAk, String outAk, String tRf, String inRf, String outRf, String tBb, String inBb, String outBb, String inSs, String outSs, String tSs) {
		this.rgnShpOprCd = rgnShpOprCd;
		this.inBb = inBb;
		this.inDg = inDg;
		this.tBb = tBb;
		this.outDg = outDg;
		this.tAk = tAk;
		this.outAk = outAk;
		this.pagerows = pagerows;
		this.inAk = inAk;
		this.ibflag = ibflag;
		this.tDg = tDg;
		this.term = term;
		this.tRf = tRf;
		this.outRf = outRf;
		this.inRf = inRf;
		this.outBb = outBb;
		
		this.inSs = inSs;
		this.outSs = outSs;
		this.tSs = tSs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("in_bb", getInBb());
		this.hashColumns.put("in_dg", getInDg());
		this.hashColumns.put("t_bb", getTBb());
		this.hashColumns.put("out_dg", getOutDg());
		this.hashColumns.put("t_ak", getTAk());
		this.hashColumns.put("out_ak", getOutAk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_ak", getInAk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t_dg", getTDg());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("t_rf", getTRf());
		this.hashColumns.put("out_rf", getOutRf());
		this.hashColumns.put("in_rf", getInRf());
		this.hashColumns.put("out_bb", getOutBb());
		
		this.hashColumns.put("in_ss", getInSs());
		this.hashColumns.put("out_ss", getOutSs());
		this.hashColumns.put("t_ss", getTSs());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("in_bb", "inBb");
		this.hashFields.put("in_dg", "inDg");
		this.hashFields.put("t_bb", "tBb");
		this.hashFields.put("out_dg", "outDg");
		this.hashFields.put("t_ak", "tAk");
		this.hashFields.put("out_ak", "outAk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_ak", "inAk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t_dg", "tDg");
		this.hashFields.put("term", "term");
		this.hashFields.put("t_rf", "tRf");
		this.hashFields.put("out_rf", "outRf");
		this.hashFields.put("in_rf", "inRf");
		this.hashFields.put("out_bb", "outBb");
		
		this.hashFields.put("in_ss",  "inSs");
		this.hashFields.put("out_ss", "outSs");
		this.hashFields.put("t_ss",   "tSs");
		
		return this.hashFields;
	}
	
	public String getInSs() {
		return inSs;
	}

	public void setInSs(String inSs) {
		this.inSs = inSs;
	}

	public String getOutSs() {
		return outSs;
	}

	public void setOutSs(String outSs) {
		this.outSs = outSs;
	}

	public String getTSs() {
		return tSs;
	}

	public void setTSs(String tSs) {
		this.tSs = tSs;
	}

	/**
	 * Column Info
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return inBb
	 */
	public String getInBb() {
		return this.inBb;
	}
	
	/**
	 * Column Info
	 * @return inDg
	 */
	public String getInDg() {
		return this.inDg;
	}
	
	/**
	 * Column Info
	 * @return tBb
	 */
	public String getTBb() {
		return this.tBb;
	}
	
	/**
	 * Column Info
	 * @return outDg
	 */
	public String getOutDg() {
		return this.outDg;
	}
	
	/**
	 * Column Info
	 * @return tAk
	 */
	public String getTAk() {
		return this.tAk;
	}
	
	/**
	 * Column Info
	 * @return outAk
	 */
	public String getOutAk() {
		return this.outAk;
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
	 * @return inAk
	 */
	public String getInAk() {
		return this.inAk;
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
	 * @return tDg
	 */
	public String getTDg() {
		return this.tDg;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return tRf
	 */
	public String getTRf() {
		return this.tRf;
	}
	
	/**
	 * Column Info
	 * @return outRf
	 */
	public String getOutRf() {
		return this.outRf;
	}
	
	/**
	 * Column Info
	 * @return inRf
	 */
	public String getInRf() {
		return this.inRf;
	}
	
	/**
	 * Column Info
	 * @return outBb
	 */
	public String getOutBb() {
		return this.outBb;
	}
	

	/**
	 * Column Info
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param inBb
	 */
	public void setInBb(String inBb) {
		this.inBb = inBb;
	}
	
	/**
	 * Column Info
	 * @param inDg
	 */
	public void setInDg(String inDg) {
		this.inDg = inDg;
	}
	
	/**
	 * Column Info
	 * @param tBb
	 */
	public void setTBb(String tBb) {
		this.tBb = tBb;
	}
	
	/**
	 * Column Info
	 * @param outDg
	 */
	public void setOutDg(String outDg) {
		this.outDg = outDg;
	}
	
	/**
	 * Column Info
	 * @param tAk
	 */
	public void setTAk(String tAk) {
		this.tAk = tAk;
	}
	
	/**
	 * Column Info
	 * @param outAk
	 */
	public void setOutAk(String outAk) {
		this.outAk = outAk;
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
	 * @param inAk
	 */
	public void setInAk(String inAk) {
		this.inAk = inAk;
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
	 * @param tDg
	 */
	public void setTDg(String tDg) {
		this.tDg = tDg;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param tRf
	 */
	public void setTRf(String tRf) {
		this.tRf = tRf;
	}
	
	/**
	 * Column Info
	 * @param outRf
	 */
	public void setOutRf(String outRf) {
		this.outRf = outRf;
	}
	
	/**
	 * Column Info
	 * @param inRf
	 */
	public void setInRf(String inRf) {
		this.inRf = inRf;
	}
	
	/**
	 * Column Info
	 * @param outBb
	 */
	public void setOutBb(String outBb) {
		this.outBb = outBb;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRgnShpOprCd(JSPUtil.getParameter(request, "rgn_shp_opr_cd", ""));
		setInBb(JSPUtil.getParameter(request, "in_bb", ""));
		setInDg(JSPUtil.getParameter(request, "in_dg", ""));
		setTBb(JSPUtil.getParameter(request, "t_bb", ""));
		setOutDg(JSPUtil.getParameter(request, "out_dg", ""));
		setTAk(JSPUtil.getParameter(request, "t_ak", ""));
		setOutAk(JSPUtil.getParameter(request, "out_ak", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInAk(JSPUtil.getParameter(request, "in_ak", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTDg(JSPUtil.getParameter(request, "t_dg", ""));
		setTerm(JSPUtil.getParameter(request, "term", ""));
		setTRf(JSPUtil.getParameter(request, "t_rf", ""));
		setOutRf(JSPUtil.getParameter(request, "out_rf", ""));
		setInRf(JSPUtil.getParameter(request, "in_rf", ""));
		setOutBb(JSPUtil.getParameter(request, "out_bb", ""));
		
		setInSs(JSPUtil.getParameter(request, "in_ss", ""));
		setOutSs(JSPUtil.getParameter(request, "out_ss", ""));
		setTSs(JSPUtil.getParameter(request, "t_ss", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScgRequestApvlTimeOutputVO[]
	 */
	public SearchScgRequestApvlTimeOutputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScgRequestApvlTimeOutputVO[]
	 */
	public SearchScgRequestApvlTimeOutputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScgRequestApvlTimeOutputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] inBb = (JSPUtil.getParameter(request, prefix	+ "in_bb", length));
			String[] inDg = (JSPUtil.getParameter(request, prefix	+ "in_dg", length));
			String[] tBb = (JSPUtil.getParameter(request, prefix	+ "t_bb", length));
			String[] outDg = (JSPUtil.getParameter(request, prefix	+ "out_dg", length));
			String[] tAk = (JSPUtil.getParameter(request, prefix	+ "t_ak", length));
			String[] outAk = (JSPUtil.getParameter(request, prefix	+ "out_ak", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inAk = (JSPUtil.getParameter(request, prefix	+ "in_ak", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tDg = (JSPUtil.getParameter(request, prefix	+ "t_dg", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] tRf = (JSPUtil.getParameter(request, prefix	+ "t_rf", length));
			String[] outRf = (JSPUtil.getParameter(request, prefix	+ "out_rf", length));
			String[] inRf = (JSPUtil.getParameter(request, prefix	+ "in_rf", length));
			String[] outBb = (JSPUtil.getParameter(request, prefix	+ "out_bb", length));
			
			String[] inSs = (JSPUtil.getParameter(request, prefix	+ "in_ss", length));
			String[] outSs = (JSPUtil.getParameter(request, prefix	+ "out_ss", length));
			String[] tSs = (JSPUtil.getParameter(request, prefix	+ "t_ss", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScgRequestApvlTimeOutputVO();
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (inBb[i] != null)
					model.setInBb(inBb[i]);
				if (inDg[i] != null)
					model.setInDg(inDg[i]);
				if (tBb[i] != null)
					model.setTBb(tBb[i]);
				if (outDg[i] != null)
					model.setOutDg(outDg[i]);
				if (tAk[i] != null)
					model.setTAk(tAk[i]);
				if (outAk[i] != null)
					model.setOutAk(outAk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inAk[i] != null)
					model.setInAk(inAk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tDg[i] != null)
					model.setTDg(tDg[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (tRf[i] != null)
					model.setTRf(tRf[i]);
				if (outRf[i] != null)
					model.setOutRf(outRf[i]);
				if (inRf[i] != null)
					model.setInRf(inRf[i]);
				if (outBb[i] != null)
					model.setOutBb(outBb[i]);
				
				if (inSs[i] != null)
					model.setInSs(inSs[i]);
				if (outSs[i] != null)
					model.setOutSs(outSs[i]);
				if (tSs[i] != null)
					model.setTSs(tSs[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScgRequestApvlTimeOutputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScgRequestApvlTimeOutputVO[]
	 */
	public SearchScgRequestApvlTimeOutputVO[] getSearchScgRequestApvlTimeOutputVOs(){
		SearchScgRequestApvlTimeOutputVO[] vos = (SearchScgRequestApvlTimeOutputVO[])models.toArray(new SearchScgRequestApvlTimeOutputVO[models.size()]);
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
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBb = this.inBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDg = this.inDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tBb = this.tBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outDg = this.outDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tAk = this.tAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outAk = this.outAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inAk = this.inAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDg = this.tDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tRf = this.tRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outRf = this.outRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inRf = this.inRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outBb = this.outBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.inSs = this.inSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outSs = this.outSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tSs = this.tSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

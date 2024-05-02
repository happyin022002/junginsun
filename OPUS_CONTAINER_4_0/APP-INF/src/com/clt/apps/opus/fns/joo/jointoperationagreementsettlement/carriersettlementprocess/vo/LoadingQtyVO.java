/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LoadingQtyVO.java
*@FileTitle : LoadingQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.02.05 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LoadingQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LoadingQtyVO> models = new ArrayList<LoadingQtyVO>();
	
	/* Column Info */
	private String mtCnt = null;
	/* Column Info */
	private String mt45Cnt = null;
	/* Column Info */
	private String mtHcCnt = null;
	/* Column Info */
	private String mt40Cnt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCdCnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String headerSql = null;
	/* Column Info */
	private String mt20Cnt = null;
	/* Column Info */
	private String ratehc = null;
	/* Column Info */
	private String rate45 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LoadingQtyVO() {}

	public LoadingQtyVO(String ibflag, String pagerows, String vvd, String ofcCd, String polCd, String skdDirCd, String clptSeq, String polCdCnt, String headerSql, String ratehc, String rate45, String mtCnt, String mt20Cnt, String mt40Cnt, String mtHcCnt, String mt45Cnt) {
		this.mtCnt = mtCnt;
		this.mt45Cnt = mt45Cnt;
		this.mtHcCnt = mtHcCnt;
		this.mt40Cnt = mt40Cnt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.polCdCnt = polCdCnt;
		this.ofcCd = ofcCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.headerSql = headerSql;
		this.mt20Cnt = mt20Cnt;
		this.ratehc = ratehc;
		this.rate45 = rate45;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mt_cnt", getMtCnt());
		this.hashColumns.put("mt_45_cnt", getMt45Cnt());
		this.hashColumns.put("mt_hc_cnt", getMtHcCnt());
		this.hashColumns.put("mt_40_cnt", getMt40Cnt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd_cnt", getPolCdCnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("header_sql", getHeaderSql());
		this.hashColumns.put("mt_20_cnt", getMt20Cnt());
		this.hashColumns.put("ratehc", getRatehc());
		this.hashColumns.put("rate45", getRate45());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mt_cnt", "mtCnt");
		this.hashFields.put("mt_45_cnt", "mt45Cnt");
		this.hashFields.put("mt_hc_cnt", "mtHcCnt");
		this.hashFields.put("mt_40_cnt", "mt40Cnt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd_cnt", "polCdCnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("header_sql", "headerSql");
		this.hashFields.put("mt_20_cnt", "mt20Cnt");
		this.hashFields.put("ratehc", "ratehc");
		this.hashFields.put("rate45", "rate45");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mtCnt
	 */
	public String getMtCnt() {
		return this.mtCnt;
	}
	
	/**
	 * Column Info
	 * @return mt45Cnt
	 */
	public String getMt45Cnt() {
		return this.mt45Cnt;
	}
	
	/**
	 * Column Info
	 * @return mtHcCnt
	 */
	public String getMtHcCnt() {
		return this.mtHcCnt;
	}
	
	/**
	 * Column Info
	 * @return mt40Cnt
	 */
	public String getMt40Cnt() {
		return this.mt40Cnt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return polCdCnt
	 */
	public String getPolCdCnt() {
		return this.polCdCnt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return headerSql
	 */
	public String getHeaderSql() {
		return this.headerSql;
	}
	
	/**
	 * Column Info
	 * @return mt20Cnt
	 */
	public String getMt20Cnt() {
		return this.mt20Cnt;
	}
	
	/**
	 * Column Info
	 * @return ratehc
	 */
	public String getRatehc() {
		return this.ratehc;
	}
	
	/**
	 * Column Info
	 * @return rate45
	 */
	public String getRate45() {
		return this.rate45;
	}
	

	/**
	 * Column Info
	 * @param mtCnt
	 */
	public void setMtCnt(String mtCnt) {
		this.mtCnt = mtCnt;
	}
	
	/**
	 * Column Info
	 * @param mt45Cnt
	 */
	public void setMt45Cnt(String mt45Cnt) {
		this.mt45Cnt = mt45Cnt;
	}
	
	/**
	 * Column Info
	 * @param mtHcCnt
	 */
	public void setMtHcCnt(String mtHcCnt) {
		this.mtHcCnt = mtHcCnt;
	}
	
	/**
	 * Column Info
	 * @param mt40Cnt
	 */
	public void setMt40Cnt(String mt40Cnt) {
		this.mt40Cnt = mt40Cnt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param polCdCnt
	 */
	public void setPolCdCnt(String polCdCnt) {
		this.polCdCnt = polCdCnt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param headerSql
	 */
	public void setHeaderSql(String headerSql) {
		this.headerSql = headerSql;
	}
	
	/**
	 * Column Info
	 * @param mt20Cnt
	 */
	public void setMt20Cnt(String mt20Cnt) {
		this.mt20Cnt = mt20Cnt;
	}
	
	/**
	 * Column Info
	 * @param ratehc
	 */
	public void setRatehc(String ratehc) {
		this.ratehc = ratehc;
	}
	
	/**
	 * Column Info
	 * @param rate45
	 */
	public void setRate45(String rate45) {
		this.rate45 = rate45;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMtCnt(JSPUtil.getParameter(request, "mt_cnt", ""));
		setMt45Cnt(JSPUtil.getParameter(request, "mt_45_cnt", ""));
		setMtHcCnt(JSPUtil.getParameter(request, "mt_hc_cnt", ""));
		setMt40Cnt(JSPUtil.getParameter(request, "mt_40_cnt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPolCdCnt(JSPUtil.getParameter(request, "pol_cd_cnt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setHeaderSql(JSPUtil.getParameter(request, "header_sql", ""));
		setMt20Cnt(JSPUtil.getParameter(request, "mt_20_cnt", ""));
		setRatehc(JSPUtil.getParameter(request, "ratehc", ""));
		setRate45(JSPUtil.getParameter(request, "rate45", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LoadingQtyVO[]
	 */
	public LoadingQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LoadingQtyVO[]
	 */
	public LoadingQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LoadingQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mtCnt = (JSPUtil.getParameter(request, prefix	+ "mt_cnt", length));
			String[] mt45Cnt = (JSPUtil.getParameter(request, prefix	+ "mt_45_cnt", length));
			String[] mtHcCnt = (JSPUtil.getParameter(request, prefix	+ "mt_hc_cnt", length));
			String[] mt40Cnt = (JSPUtil.getParameter(request, prefix	+ "mt_40_cnt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCdCnt = (JSPUtil.getParameter(request, prefix	+ "pol_cd_cnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] headerSql = (JSPUtil.getParameter(request, prefix	+ "header_sql", length));
			String[] mt20Cnt = (JSPUtil.getParameter(request, prefix	+ "mt_20_cnt", length));
			String[] ratehc = (JSPUtil.getParameter(request, prefix	+ "ratehc", length));
			String[] rate45 = (JSPUtil.getParameter(request, prefix	+ "rate45", length));
			
			for (int i = 0; i < length; i++) {
				model = new LoadingQtyVO();
				if (mtCnt[i] != null)
					model.setMtCnt(mtCnt[i]);
				if (mt45Cnt[i] != null)
					model.setMt45Cnt(mt45Cnt[i]);
				if (mtHcCnt[i] != null)
					model.setMtHcCnt(mtHcCnt[i]);
				if (mt40Cnt[i] != null)
					model.setMt40Cnt(mt40Cnt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCdCnt[i] != null)
					model.setPolCdCnt(polCdCnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (headerSql[i] != null)
					model.setHeaderSql(headerSql[i]);
				if (mt20Cnt[i] != null)
					model.setMt20Cnt(mt20Cnt[i]);
				if (ratehc[i] != null)
					model.setRatehc(ratehc[i]);
				if (rate45[i] != null)
					model.setRate45(rate45[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLoadingQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LoadingQtyVO[]
	 */
	public LoadingQtyVO[] getLoadingQtyVOs(){
		LoadingQtyVO[] vos = (LoadingQtyVO[])models.toArray(new LoadingQtyVO[models.size()]);
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
		this.mtCnt = this.mtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt45Cnt = this.mt45Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtHcCnt = this.mtHcCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40Cnt = this.mt40Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdCnt = this.polCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headerSql = this.headerSql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt20Cnt = this.mt20Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratehc = this.ratehc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate45 = this.rate45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

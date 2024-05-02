/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchLaneTSCommitmentListVO.java
*@FileTitle : SearchLaneTSCommitmentListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.12.04 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLaneTSCommitmentListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLaneTSCommitmentListVO> models = new ArrayList<SearchLaneTSCommitmentListVO>();
	
	/* Column Info */
	private String rowType = null;
	/* Column Info */
	private String eAmt = null;
	/* Column Info */
	private String toTrdCd = null;
	/* Column Info */
	private String bsaCmmtAmt = null;
	/* Column Info */
	private String bsaCmmtRto = null;
	/* Column Info */
	private String dirRank = null;
	/* Column Info */
	private String toHulBndCd = null;
	/* Column Info */
	private String fmDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmTrdCd = null;
	/* Column Info */
	private String eRatio = null;
	/* Column Info */
	private String fmHulBndCd = null;
	/* Column Info */
	private String rank = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String toTrdCdSeq = null;
	/* Column Info */
	private String fmRlaneCd = null;
	/* Column Info */
	private String wRatio = null;
	/* Column Info */
	private String wAmt = null;
	/* Column Info */
	private String fmIocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchLaneTSCommitmentListVO() {}

	public SearchLaneTSCommitmentListVO(String ibflag, String pagerows, String costYrmon, String fmTrdCd, String fmRlaneCd, String fmIocCd, String fmDirCd, String fmHulBndCd, String toTrdCd, String toHulBndCd, String bsaCmmtAmt, String bsaCmmtRto, String toTrdCdSeq, String rank, String dirRank, String eAmt, String wAmt, String eRatio, String wRatio, String rowType) {
		this.rowType = rowType;
		this.eAmt = eAmt;
		this.toTrdCd = toTrdCd;
		this.bsaCmmtAmt = bsaCmmtAmt;
		this.bsaCmmtRto = bsaCmmtRto;
		this.dirRank = dirRank;
		this.toHulBndCd = toHulBndCd;
		this.fmDirCd = fmDirCd;
		this.pagerows = pagerows;
		this.fmTrdCd = fmTrdCd;
		this.eRatio = eRatio;
		this.fmHulBndCd = fmHulBndCd;
		this.rank = rank;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.toTrdCdSeq = toTrdCdSeq;
		this.fmRlaneCd = fmRlaneCd;
		this.wRatio = wRatio;
		this.wAmt = wAmt;
		this.fmIocCd = fmIocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("row_type", getRowType());
		this.hashColumns.put("e_amt", getEAmt());
		this.hashColumns.put("to_trd_cd", getToTrdCd());
		this.hashColumns.put("bsa_cmmt_amt", getBsaCmmtAmt());
		this.hashColumns.put("bsa_cmmt_rto", getBsaCmmtRto());
		this.hashColumns.put("dir_rank", getDirRank());
		this.hashColumns.put("to_hul_bnd_cd", getToHulBndCd());
		this.hashColumns.put("fm_dir_cd", getFmDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_trd_cd", getFmTrdCd());
		this.hashColumns.put("e_ratio", getERatio());
		this.hashColumns.put("fm_hul_bnd_cd", getFmHulBndCd());
		this.hashColumns.put("rank", getRank());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("to_trd_cd_seq", getToTrdCdSeq());
		this.hashColumns.put("fm_rlane_cd", getFmRlaneCd());
		this.hashColumns.put("w_ratio", getWRatio());
		this.hashColumns.put("w_amt", getWAmt());
		this.hashColumns.put("fm_ioc_cd", getFmIocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("row_type", "rowType");
		this.hashFields.put("e_amt", "eAmt");
		this.hashFields.put("to_trd_cd", "toTrdCd");
		this.hashFields.put("bsa_cmmt_amt", "bsaCmmtAmt");
		this.hashFields.put("bsa_cmmt_rto", "bsaCmmtRto");
		this.hashFields.put("dir_rank", "dirRank");
		this.hashFields.put("to_hul_bnd_cd", "toHulBndCd");
		this.hashFields.put("fm_dir_cd", "fmDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_trd_cd", "fmTrdCd");
		this.hashFields.put("e_ratio", "eRatio");
		this.hashFields.put("fm_hul_bnd_cd", "fmHulBndCd");
		this.hashFields.put("rank", "rank");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("to_trd_cd_seq", "toTrdCdSeq");
		this.hashFields.put("fm_rlane_cd", "fmRlaneCd");
		this.hashFields.put("w_ratio", "wRatio");
		this.hashFields.put("w_amt", "wAmt");
		this.hashFields.put("fm_ioc_cd", "fmIocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rowType
	 */
	public String getRowType() {
		return this.rowType;
	}
	
	/**
	 * Column Info
	 * @return eAmt
	 */
	public String getEAmt() {
		return this.eAmt;
	}
	
	/**
	 * Column Info
	 * @return toTrdCd
	 */
	public String getToTrdCd() {
		return this.toTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaCmmtAmt
	 */
	public String getBsaCmmtAmt() {
		return this.bsaCmmtAmt;
	}
	
	/**
	 * Column Info
	 * @return bsaCmmtRto
	 */
	public String getBsaCmmtRto() {
		return this.bsaCmmtRto;
	}
	
	/**
	 * Column Info
	 * @return dirRank
	 */
	public String getDirRank() {
		return this.dirRank;
	}
	
	/**
	 * Column Info
	 * @return toHulBndCd
	 */
	public String getToHulBndCd() {
		return this.toHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return fmDirCd
	 */
	public String getFmDirCd() {
		return this.fmDirCd;
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
	 * @return fmTrdCd
	 */
	public String getFmTrdCd() {
		return this.fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @return eRatio
	 */
	public String getERatio() {
		return this.eRatio;
	}
	
	/**
	 * Column Info
	 * @return fmHulBndCd
	 */
	public String getFmHulBndCd() {
		return this.fmHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return rank
	 */
	public String getRank() {
		return this.rank;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return toTrdCdSeq
	 */
	public String getToTrdCdSeq() {
		return this.toTrdCdSeq;
	}
	
	/**
	 * Column Info
	 * @return fmRlaneCd
	 */
	public String getFmRlaneCd() {
		return this.fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return wRatio
	 */
	public String getWRatio() {
		return this.wRatio;
	}
	
	/**
	 * Column Info
	 * @return wAmt
	 */
	public String getWAmt() {
		return this.wAmt;
	}
	
	/**
	 * Column Info
	 * @return fmIocCd
	 */
	public String getFmIocCd() {
		return this.fmIocCd;
	}
	

	/**
	 * Column Info
	 * @param rowType
	 */
	public void setRowType(String rowType) {
		this.rowType = rowType;
	}
	
	/**
	 * Column Info
	 * @param eAmt
	 */
	public void setEAmt(String eAmt) {
		this.eAmt = eAmt;
	}
	
	/**
	 * Column Info
	 * @param toTrdCd
	 */
	public void setToTrdCd(String toTrdCd) {
		this.toTrdCd = toTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaCmmtAmt
	 */
	public void setBsaCmmtAmt(String bsaCmmtAmt) {
		this.bsaCmmtAmt = bsaCmmtAmt;
	}
	
	/**
	 * Column Info
	 * @param bsaCmmtRto
	 */
	public void setBsaCmmtRto(String bsaCmmtRto) {
		this.bsaCmmtRto = bsaCmmtRto;
	}
	
	/**
	 * Column Info
	 * @param dirRank
	 */
	public void setDirRank(String dirRank) {
		this.dirRank = dirRank;
	}
	
	/**
	 * Column Info
	 * @param toHulBndCd
	 */
	public void setToHulBndCd(String toHulBndCd) {
		this.toHulBndCd = toHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param fmDirCd
	 */
	public void setFmDirCd(String fmDirCd) {
		this.fmDirCd = fmDirCd;
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
	 * @param fmTrdCd
	 */
	public void setFmTrdCd(String fmTrdCd) {
		this.fmTrdCd = fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @param eRatio
	 */
	public void setERatio(String eRatio) {
		this.eRatio = eRatio;
	}
	
	/**
	 * Column Info
	 * @param fmHulBndCd
	 */
	public void setFmHulBndCd(String fmHulBndCd) {
		this.fmHulBndCd = fmHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param toTrdCdSeq
	 */
	public void setToTrdCdSeq(String toTrdCdSeq) {
		this.toTrdCdSeq = toTrdCdSeq;
	}
	
	/**
	 * Column Info
	 * @param fmRlaneCd
	 */
	public void setFmRlaneCd(String fmRlaneCd) {
		this.fmRlaneCd = fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param wRatio
	 */
	public void setWRatio(String wRatio) {
		this.wRatio = wRatio;
	}
	
	/**
	 * Column Info
	 * @param wAmt
	 */
	public void setWAmt(String wAmt) {
		this.wAmt = wAmt;
	}
	
	/**
	 * Column Info
	 * @param fmIocCd
	 */
	public void setFmIocCd(String fmIocCd) {
		this.fmIocCd = fmIocCd;
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
		setRowType(JSPUtil.getParameter(request, prefix + "row_type", ""));
		setEAmt(JSPUtil.getParameter(request, prefix + "e_amt", ""));
		setToTrdCd(JSPUtil.getParameter(request, prefix + "to_trd_cd", ""));
		setBsaCmmtAmt(JSPUtil.getParameter(request, prefix + "bsa_cmmt_amt", ""));
		setBsaCmmtRto(JSPUtil.getParameter(request, prefix + "bsa_cmmt_rto", ""));
		setDirRank(JSPUtil.getParameter(request, prefix + "dir_rank", ""));
		setToHulBndCd(JSPUtil.getParameter(request, prefix + "to_hul_bnd_cd", ""));
		setFmDirCd(JSPUtil.getParameter(request, prefix + "fm_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmTrdCd(JSPUtil.getParameter(request, prefix + "fm_trd_cd", ""));
		setERatio(JSPUtil.getParameter(request, prefix + "e_ratio", ""));
		setFmHulBndCd(JSPUtil.getParameter(request, prefix + "fm_hul_bnd_cd", ""));
		setRank(JSPUtil.getParameter(request, prefix + "rank", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setToTrdCdSeq(JSPUtil.getParameter(request, prefix + "to_trd_cd_seq", ""));
		setFmRlaneCd(JSPUtil.getParameter(request, prefix + "fm_rlane_cd", ""));
		setWRatio(JSPUtil.getParameter(request, prefix + "w_ratio", ""));
		setWAmt(JSPUtil.getParameter(request, prefix + "w_amt", ""));
		setFmIocCd(JSPUtil.getParameter(request, prefix + "fm_ioc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLaneTSCommitmentListVO[]
	 */
	public SearchLaneTSCommitmentListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLaneTSCommitmentListVO[]
	 */
	public SearchLaneTSCommitmentListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLaneTSCommitmentListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rowType = (JSPUtil.getParameter(request, prefix	+ "row_type", length));
			String[] eAmt = (JSPUtil.getParameter(request, prefix	+ "e_amt", length));
			String[] toTrdCd = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd", length));
			String[] bsaCmmtAmt = (JSPUtil.getParameter(request, prefix	+ "bsa_cmmt_amt", length));
			String[] bsaCmmtRto = (JSPUtil.getParameter(request, prefix	+ "bsa_cmmt_rto", length));
			String[] dirRank = (JSPUtil.getParameter(request, prefix	+ "dir_rank", length));
			String[] toHulBndCd = (JSPUtil.getParameter(request, prefix	+ "to_hul_bnd_cd", length));
			String[] fmDirCd = (JSPUtil.getParameter(request, prefix	+ "fm_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmTrdCd = (JSPUtil.getParameter(request, prefix	+ "fm_trd_cd", length));
			String[] eRatio = (JSPUtil.getParameter(request, prefix	+ "e_ratio", length));
			String[] fmHulBndCd = (JSPUtil.getParameter(request, prefix	+ "fm_hul_bnd_cd", length));
			String[] rank = (JSPUtil.getParameter(request, prefix	+ "rank", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] toTrdCdSeq = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd_seq", length));
			String[] fmRlaneCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlane_cd", length));
			String[] wRatio = (JSPUtil.getParameter(request, prefix	+ "w_ratio", length));
			String[] wAmt = (JSPUtil.getParameter(request, prefix	+ "w_amt", length));
			String[] fmIocCd = (JSPUtil.getParameter(request, prefix	+ "fm_ioc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLaneTSCommitmentListVO();
				if (rowType[i] != null)
					model.setRowType(rowType[i]);
				if (eAmt[i] != null)
					model.setEAmt(eAmt[i]);
				if (toTrdCd[i] != null)
					model.setToTrdCd(toTrdCd[i]);
				if (bsaCmmtAmt[i] != null)
					model.setBsaCmmtAmt(bsaCmmtAmt[i]);
				if (bsaCmmtRto[i] != null)
					model.setBsaCmmtRto(bsaCmmtRto[i]);
				if (dirRank[i] != null)
					model.setDirRank(dirRank[i]);
				if (toHulBndCd[i] != null)
					model.setToHulBndCd(toHulBndCd[i]);
				if (fmDirCd[i] != null)
					model.setFmDirCd(fmDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmTrdCd[i] != null)
					model.setFmTrdCd(fmTrdCd[i]);
				if (eRatio[i] != null)
					model.setERatio(eRatio[i]);
				if (fmHulBndCd[i] != null)
					model.setFmHulBndCd(fmHulBndCd[i]);
				if (rank[i] != null)
					model.setRank(rank[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (toTrdCdSeq[i] != null)
					model.setToTrdCdSeq(toTrdCdSeq[i]);
				if (fmRlaneCd[i] != null)
					model.setFmRlaneCd(fmRlaneCd[i]);
				if (wRatio[i] != null)
					model.setWRatio(wRatio[i]);
				if (wAmt[i] != null)
					model.setWAmt(wAmt[i]);
				if (fmIocCd[i] != null)
					model.setFmIocCd(fmIocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLaneTSCommitmentListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLaneTSCommitmentListVO[]
	 */
	public SearchLaneTSCommitmentListVO[] getSearchLaneTSCommitmentListVOs(){
		SearchLaneTSCommitmentListVO[] vos = (SearchLaneTSCommitmentListVO[])models.toArray(new SearchLaneTSCommitmentListVO[models.size()]);
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
		this.rowType = this.rowType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eAmt = this.eAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdCd = this.toTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCmmtAmt = this.bsaCmmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCmmtRto = this.bsaCmmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirRank = this.dirRank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toHulBndCd = this.toHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDirCd = this.fmDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrdCd = this.fmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eRatio = this.eRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmHulBndCd = this.fmHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rank = this.rank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdCdSeq = this.toTrdCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRlaneCd = this.fmRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wRatio = this.wRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wAmt = this.wAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIocCd = this.fmIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

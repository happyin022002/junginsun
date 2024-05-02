/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSoByCopVO.java
*@FileTitle : SearchSoByCopVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.06 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSoByCopVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSoByCopVO> models = new ArrayList<SearchSoByCopVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String trspRqstBkgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trspFrstFlg = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String tableName = null;
	/* Column Info */
	private String trspSoStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSoByCopVO() {}

	public SearchSoByCopVO(String ibflag, String pagerows, String tableName, String trspSoOfcCtyCd, String trspSoSeq, String trspSoStsCd, String copNo, String costActGrpSeq, String eqNo, String fmNodCd, String toNodCd, String trspBndCd, String deltFlg, String trspRqstBkgFlg, String trspFrstFlg) {
		this.toNodCd = toNodCd;
		this.trspBndCd = trspBndCd;
		this.deltFlg = deltFlg;
		this.trspSoSeq = trspSoSeq;
		this.copNo = copNo;
		this.trspRqstBkgFlg = trspRqstBkgFlg;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.fmNodCd = fmNodCd;
		this.ibflag = ibflag;
		this.trspFrstFlg = trspFrstFlg;
		this.eqNo = eqNo;
		this.costActGrpSeq = costActGrpSeq;
		this.tableName = tableName;
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("trsp_rqst_bkg_flg", getTrspRqstBkgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("table_name", getTableName());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("trsp_rqst_bkg_flg", "trspRqstBkgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("table_name", "tableName");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return trspRqstBkgFlg
	 */
	public String getTrspRqstBkgFlg() {
		return this.trspRqstBkgFlg;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return trspFrstFlg
	 */
	public String getTrspFrstFlg() {
		return this.trspFrstFlg;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return tableName
	 */
	public String getTableName() {
		return this.tableName;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param trspRqstBkgFlg
	 */
	public void setTrspRqstBkgFlg(String trspRqstBkgFlg) {
		this.trspRqstBkgFlg = trspRqstBkgFlg;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param trspFrstFlg
	 */
	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setTrspRqstBkgFlg(JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, prefix + "trsp_frst_flg", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setTableName(JSPUtil.getParameter(request, prefix + "table_name", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSoByCopVO[]
	 */
	public SearchSoByCopVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSoByCopVO[]
	 */
	public SearchSoByCopVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSoByCopVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] trspRqstBkgFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_bkg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_frst_flg", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] tableName = (JSPUtil.getParameter(request, prefix	+ "table_name", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSoByCopVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (trspRqstBkgFlg[i] != null)
					model.setTrspRqstBkgFlg(trspRqstBkgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (tableName[i] != null)
					model.setTableName(tableName[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSoByCopVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSoByCopVO[]
	 */
	public SearchSoByCopVO[] getSearchSoByCopVOs(){
		SearchSoByCopVO[] vos = (SearchSoByCopVO[])models.toArray(new SearchSoByCopVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstBkgFlg = this.trspRqstBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableName = this.tableName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

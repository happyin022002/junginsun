/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanResultVO.java
*@FileTitle : ReplanResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.09 김인수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReplanResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReplanResultVO> models = new ArrayList<ReplanResultVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rplnRsltFlg = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String umchFlg = null;
	/* Column Info */
	private String updRmk = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReplanResultVO() {}

	public ReplanResultVO(String ibflag, String pagerows, String umchFlg, String trspSoOfcCtyCd, String trspSoSeq, String fmNodCd, String toNodCd, String copNo, String costActGrpSeq, String updRmk, String rplnRsltFlg) {
		this.toNodCd = toNodCd;
		this.fmNodCd = fmNodCd;
		this.ibflag = ibflag;
		this.rplnRsltFlg = rplnRsltFlg;
		this.costActGrpSeq = costActGrpSeq;
		this.umchFlg = umchFlg;
		this.updRmk = updRmk;
		this.trspSoSeq = trspSoSeq;
		this.copNo = copNo;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpln_rslt_flg", getRplnRsltFlg());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("umch_flg", getUmchFlg());
		this.hashColumns.put("upd_rmk", getUpdRmk());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpln_rslt_flg", "rplnRsltFlg");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("umch_flg", "umchFlg");
		this.hashFields.put("upd_rmk", "updRmk");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return rplnRsltFlg
	 */
	public String getRplnRsltFlg() {
		return this.rplnRsltFlg;
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
	 * @return umchFlg
	 */
	public String getUmchFlg() {
		return this.umchFlg;
	}
	
	/**
	 * Column Info
	 * @return updRmk
	 */
	public String getUpdRmk() {
		return this.updRmk;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param rplnRsltFlg
	 */
	public void setRplnRsltFlg(String rplnRsltFlg) {
		this.rplnRsltFlg = rplnRsltFlg;
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
	 * @param umchFlg
	 */
	public void setUmchFlg(String umchFlg) {
		this.umchFlg = umchFlg;
	}
	
	/**
	 * Column Info
	 * @param updRmk
	 */
	public void setUpdRmk(String updRmk) {
		this.updRmk = updRmk;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRplnRsltFlg(JSPUtil.getParameter(request, prefix + "rpln_rslt_flg", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setUmchFlg(JSPUtil.getParameter(request, prefix + "umch_flg", ""));
		setUpdRmk(JSPUtil.getParameter(request, prefix + "upd_rmk", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReplanResultVO[]
	 */
	public ReplanResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReplanResultVO[]
	 */
	public ReplanResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReplanResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rplnRsltFlg = (JSPUtil.getParameter(request, prefix	+ "rpln_rslt_flg", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] umchFlg = (JSPUtil.getParameter(request, prefix	+ "umch_flg", length));
			String[] updRmk = (JSPUtil.getParameter(request, prefix	+ "upd_rmk", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReplanResultVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rplnRsltFlg[i] != null)
					model.setRplnRsltFlg(rplnRsltFlg[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (umchFlg[i] != null)
					model.setUmchFlg(umchFlg[i]);
				if (updRmk[i] != null)
					model.setUpdRmk(updRmk[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReplanResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReplanResultVO[]
	 */
	public ReplanResultVO[] getReplanResultVOs(){
		ReplanResultVO[] vos = (ReplanResultVO[])models.toArray(new ReplanResultVO[models.size()]);
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
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnRsltFlg = this.rplnRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchFlg = this.umchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updRmk = this.updRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

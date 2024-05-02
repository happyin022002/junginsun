/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlockLaneVO.java
*@FileTitle : BlockLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.30 함대성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlockLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlockLaneVO> models = new ArrayList<BlockLaneVO>();
	
	/* Column Info */
	private String blckSeq = null;
	/* Column Info */
	private String routRcvDt = null;
	/* Column Info */
	private String gubun = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlockLaneVO() {}

	public BlockLaneVO(String ibflag, String pagerows, String slanCd, String vslSlanNm, String custTrdPrnrId, String polCd, String podCd, String updUsrId, String creUsrId, String gubun, String routRcvDt, String routSeq, String blckSeq) {
		this.blckSeq = blckSeq;
		this.routRcvDt = routRcvDt;
		this.gubun = gubun;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.vslSlanNm = vslSlanNm;
		this.custTrdPrnrId = custTrdPrnrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("blck_seq", getBlckSeq());
		this.hashColumns.put("rout_rcv_dt", getRoutRcvDt());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("blck_seq", "blckSeq");
		this.hashFields.put("rout_rcv_dt", "routRcvDt");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blckSeq
	 */
	public String getBlckSeq() {
		return this.blckSeq;
	}
	
	/**
	 * Column Info
	 * @return routRcvDt
	 */
	public String getRoutRcvDt() {
		return this.routRcvDt;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param blckSeq
	 */
	public void setBlckSeq(String blckSeq) {
		this.blckSeq = blckSeq;
	}
	
	/**
	 * Column Info
	 * @param routRcvDt
	 */
	public void setRoutRcvDt(String routRcvDt) {
		this.routRcvDt = routRcvDt;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setBlckSeq(JSPUtil.getParameter(request, prefix + "blck_seq", ""));
		setRoutRcvDt(JSPUtil.getParameter(request, prefix + "rout_rcv_dt", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlockLaneVO[]
	 */
	public BlockLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlockLaneVO[]
	 */
	public BlockLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlockLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blckSeq = (JSPUtil.getParameter(request, prefix	+ "blck_seq", length));
			String[] routRcvDt = (JSPUtil.getParameter(request, prefix	+ "rout_rcv_dt", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlockLaneVO();
				if (blckSeq[i] != null)
					model.setBlckSeq(blckSeq[i]);
				if (routRcvDt[i] != null)
					model.setRoutRcvDt(routRcvDt[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlockLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlockLaneVO[]
	 */
	public BlockLaneVO[] getBlockLaneVOs(){
		BlockLaneVO[] vos = (BlockLaneVO[])models.toArray(new BlockLaneVO[models.size()]);
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
		this.blckSeq = this.blckSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRcvDt = this.routRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

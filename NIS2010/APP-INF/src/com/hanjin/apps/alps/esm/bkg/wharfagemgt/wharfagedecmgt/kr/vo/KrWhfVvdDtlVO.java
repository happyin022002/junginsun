/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWhfVvdDtlVO.java
*@FileTitle : KrWhfVvdDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfVvdDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfVvdDtlVO> models = new ArrayList<KrWhfVvdDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String portSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String unldTpCd = null;
	/* Column Info */
	private String ttlTonQty = null;
	/* Column Info */
	private String krWhfDcRsnCd = null;
	/* Column Info */
	private String krWhfDcCd = null;
	/* Column Info */
	private String updFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfVvdDtlVO() {}

	public KrWhfVvdDtlVO(String ibflag, String pagerows, String portSeq, String unldTpCd, String ttlTonQty, String krWhfDcCd, String rate, String krWhfDcRsnCd, String updFlg, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.portSeq = portSeq;
		this.ibflag = ibflag;
		this.rate = rate;
		this.unldTpCd = unldTpCd;
		this.ttlTonQty = ttlTonQty;
		this.krWhfDcRsnCd = krWhfDcRsnCd;
		this.krWhfDcCd = krWhfDcCd;
		this.updFlg = updFlg;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("unld_tp_cd", getUnldTpCd());
		this.hashColumns.put("ttl_ton_qty", getTtlTonQty());
		this.hashColumns.put("kr_whf_dc_rsn_cd", getKrWhfDcRsnCd());
		this.hashColumns.put("kr_whf_dc_cd", getKrWhfDcCd());
		this.hashColumns.put("upd_flg", getUpdFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("unld_tp_cd", "unldTpCd");
		this.hashFields.put("ttl_ton_qty", "ttlTonQty");
		this.hashFields.put("kr_whf_dc_rsn_cd", "krWhfDcRsnCd");
		this.hashFields.put("kr_whf_dc_cd", "krWhfDcCd");
		this.hashFields.put("upd_flg", "updFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return unldTpCd
	 */
	public String getUnldTpCd() {
		return this.unldTpCd;
	}
	
	/**
	 * Column Info
	 * @return ttlTonQty
	 */
	public String getTtlTonQty() {
		return this.ttlTonQty;
	}
	
	/**
	 * Column Info
	 * @return krWhfDcRsnCd
	 */
	public String getKrWhfDcRsnCd() {
		return this.krWhfDcRsnCd;
	}
	
	/**
	 * Column Info
	 * @return krWhfDcCd
	 */
	public String getKrWhfDcCd() {
		return this.krWhfDcCd;
	}
	
	/**
	 * Column Info
	 * @return updFlg
	 */
	public String getUpdFlg() {
		return this.updFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param unldTpCd
	 */
	public void setUnldTpCd(String unldTpCd) {
		this.unldTpCd = unldTpCd;
	}
	
	/**
	 * Column Info
	 * @param ttlTonQty
	 */
	public void setTtlTonQty(String ttlTonQty) {
		this.ttlTonQty = ttlTonQty;
	}
	
	/**
	 * Column Info
	 * @param krWhfDcRsnCd
	 */
	public void setKrWhfDcRsnCd(String krWhfDcRsnCd) {
		this.krWhfDcRsnCd = krWhfDcRsnCd;
	}
	
	/**
	 * Column Info
	 * @param krWhfDcCd
	 */
	public void setKrWhfDcCd(String krWhfDcCd) {
		this.krWhfDcCd = krWhfDcCd;
	}
	
	/**
	 * Column Info
	 * @param updFlg
	 */
	public void setUpdFlg(String updFlg) {
		this.updFlg = updFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setUnldTpCd(JSPUtil.getParameter(request, prefix + "unld_tp_cd", ""));
		setTtlTonQty(JSPUtil.getParameter(request, prefix + "ttl_ton_qty", ""));
		setKrWhfDcRsnCd(JSPUtil.getParameter(request, prefix + "kr_whf_dc_rsn_cd", ""));
		setKrWhfDcCd(JSPUtil.getParameter(request, prefix + "kr_whf_dc_cd", ""));
		setUpdFlg(JSPUtil.getParameter(request, prefix + "upd_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfVvdDtlVO[]
	 */
	public KrWhfVvdDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfVvdDtlVO[]
	 */
	public KrWhfVvdDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfVvdDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] unldTpCd = (JSPUtil.getParameter(request, prefix	+ "unld_tp_cd", length));
			String[] ttlTonQty = (JSPUtil.getParameter(request, prefix	+ "ttl_ton_qty", length));
			String[] krWhfDcRsnCd = (JSPUtil.getParameter(request, prefix	+ "kr_whf_dc_rsn_cd", length));
			String[] krWhfDcCd = (JSPUtil.getParameter(request, prefix	+ "kr_whf_dc_cd", length));
			String[] updFlg = (JSPUtil.getParameter(request, prefix	+ "upd_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfVvdDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (unldTpCd[i] != null)
					model.setUnldTpCd(unldTpCd[i]);
				if (ttlTonQty[i] != null)
					model.setTtlTonQty(ttlTonQty[i]);
				if (krWhfDcRsnCd[i] != null)
					model.setKrWhfDcRsnCd(krWhfDcRsnCd[i]);
				if (krWhfDcCd[i] != null)
					model.setKrWhfDcCd(krWhfDcCd[i]);
				if (updFlg[i] != null)
					model.setUpdFlg(updFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfVvdDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfVvdDtlVO[]
	 */
	public KrWhfVvdDtlVO[] getKrWhfVvdDtlVOs(){
		KrWhfVvdDtlVO[] vos = (KrWhfVvdDtlVO[])models.toArray(new KrWhfVvdDtlVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unldTpCd = this.unldTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTonQty = this.ttlTonQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfDcRsnCd = this.krWhfDcRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfDcCd = this.krWhfDcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updFlg = this.updFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

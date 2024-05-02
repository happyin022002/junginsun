/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SamActivityInfoVO.java
*@FileTitle : SamActivityInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.09 서미진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamActivityInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamActivityInfoVO> models = new ArrayList<SamActivityInfoVO>();
	
	/* Column Info */
	private String keymanNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actPlnDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String slsActActDt = null;
	/* Column Info */
	private String slsActTpDesc = null;
	/* Column Info */
	private String slsActSeq = null;
	/* Column Info */
	private String srepCmtDesc = null;
	/* Column Info */
	private String slsSts = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String slsActSubTpDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamActivityInfoVO() {}

	public SamActivityInfoVO(String ibflag, String pagerows, String slsActSeq, String srepCmtDesc, String keymanNm, String srepCd, String slsActTpDesc, String slsActSubTpDesc, String actPlnDt, String slsActActDt, String slsSts, String userId) {
		this.keymanNm = keymanNm;
		this.ibflag = ibflag;
		this.actPlnDt = actPlnDt;
		this.userId = userId;
		this.slsActActDt = slsActActDt;
		this.slsActTpDesc = slsActTpDesc;
		this.slsActSeq = slsActSeq;
		this.srepCmtDesc = srepCmtDesc;
		this.slsSts = slsSts;
		this.srepCd = srepCd;
		this.slsActSubTpDesc = slsActSubTpDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("keyman_nm", getKeymanNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_pln_dt", getActPlnDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("sls_act_act_dt", getSlsActActDt());
		this.hashColumns.put("sls_act_tp_desc", getSlsActTpDesc());
		this.hashColumns.put("sls_act_seq", getSlsActSeq());
		this.hashColumns.put("srep_cmt_desc", getSrepCmtDesc());
		this.hashColumns.put("sls_sts", getSlsSts());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("sls_act_sub_tp_desc", getSlsActSubTpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("keyman_nm", "keymanNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_pln_dt", "actPlnDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("sls_act_act_dt", "slsActActDt");
		this.hashFields.put("sls_act_tp_desc", "slsActTpDesc");
		this.hashFields.put("sls_act_seq", "slsActSeq");
		this.hashFields.put("srep_cmt_desc", "srepCmtDesc");
		this.hashFields.put("sls_sts", "slsSts");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("sls_act_sub_tp_desc", "slsActSubTpDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return keymanNm
	 */
	public String getKeymanNm() {
		return this.keymanNm;
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
	 * @return actPlnDt
	 */
	public String getActPlnDt() {
		return this.actPlnDt;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return slsActActDt
	 */
	public String getSlsActActDt() {
		return this.slsActActDt;
	}
	
	/**
	 * Column Info
	 * @return slsActTpDesc
	 */
	public String getSlsActTpDesc() {
		return this.slsActTpDesc;
	}
	
	/**
	 * Column Info
	 * @return slsActSeq
	 */
	public String getSlsActSeq() {
		return this.slsActSeq;
	}
	
	/**
	 * Column Info
	 * @return srepCmtDesc
	 */
	public String getSrepCmtDesc() {
		return this.srepCmtDesc;
	}
	
	/**
	 * Column Info
	 * @return slsSts
	 */
	public String getSlsSts() {
		return this.slsSts;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return slsActSubTpDesc
	 */
	public String getSlsActSubTpDesc() {
		return this.slsActSubTpDesc;
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
	 * @param keymanNm
	 */
	public void setKeymanNm(String keymanNm) {
		this.keymanNm = keymanNm;
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
	 * @param actPlnDt
	 */
	public void setActPlnDt(String actPlnDt) {
		this.actPlnDt = actPlnDt;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param slsActActDt
	 */
	public void setSlsActActDt(String slsActActDt) {
		this.slsActActDt = slsActActDt;
	}
	
	/**
	 * Column Info
	 * @param slsActTpDesc
	 */
	public void setSlsActTpDesc(String slsActTpDesc) {
		this.slsActTpDesc = slsActTpDesc;
	}
	
	/**
	 * Column Info
	 * @param slsActSeq
	 */
	public void setSlsActSeq(String slsActSeq) {
		this.slsActSeq = slsActSeq;
	}
	
	/**
	 * Column Info
	 * @param srepCmtDesc
	 */
	public void setSrepCmtDesc(String srepCmtDesc) {
		this.srepCmtDesc = srepCmtDesc;
	}
	
	/**
	 * Column Info
	 * @param slsSts
	 */
	public void setSlsSts(String slsSts) {
		this.slsSts = slsSts;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param slsActSubTpDesc
	 */
	public void setSlsActSubTpDesc(String slsActSubTpDesc) {
		this.slsActSubTpDesc = slsActSubTpDesc;
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
		setKeymanNm(JSPUtil.getParameter(request, prefix + "keyman_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActPlnDt(JSPUtil.getParameter(request, prefix + "act_pln_dt", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSlsActActDt(JSPUtil.getParameter(request, prefix + "sls_act_act_dt", ""));
		setSlsActTpDesc(JSPUtil.getParameter(request, prefix + "sls_act_tp_desc", ""));
		setSlsActSeq(JSPUtil.getParameter(request, prefix + "sls_act_seq", ""));
		setSrepCmtDesc(JSPUtil.getParameter(request, prefix + "srep_cmt_desc", ""));
		setSlsSts(JSPUtil.getParameter(request, prefix + "sls_sts", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setSlsActSubTpDesc(JSPUtil.getParameter(request, prefix + "sls_act_sub_tp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamActivityInfoVO[]
	 */
	public SamActivityInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamActivityInfoVO[]
	 */
	public SamActivityInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamActivityInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] keymanNm = (JSPUtil.getParameter(request, prefix	+ "keyman_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actPlnDt = (JSPUtil.getParameter(request, prefix	+ "act_pln_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] slsActActDt = (JSPUtil.getParameter(request, prefix	+ "sls_act_act_dt", length));
			String[] slsActTpDesc = (JSPUtil.getParameter(request, prefix	+ "sls_act_tp_desc", length));
			String[] slsActSeq = (JSPUtil.getParameter(request, prefix	+ "sls_act_seq", length));
			String[] srepCmtDesc = (JSPUtil.getParameter(request, prefix	+ "srep_cmt_desc", length));
			String[] slsSts = (JSPUtil.getParameter(request, prefix	+ "sls_sts", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] slsActSubTpDesc = (JSPUtil.getParameter(request, prefix	+ "sls_act_sub_tp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamActivityInfoVO();
				if (keymanNm[i] != null)
					model.setKeymanNm(keymanNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actPlnDt[i] != null)
					model.setActPlnDt(actPlnDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (slsActActDt[i] != null)
					model.setSlsActActDt(slsActActDt[i]);
				if (slsActTpDesc[i] != null)
					model.setSlsActTpDesc(slsActTpDesc[i]);
				if (slsActSeq[i] != null)
					model.setSlsActSeq(slsActSeq[i]);
				if (srepCmtDesc[i] != null)
					model.setSrepCmtDesc(srepCmtDesc[i]);
				if (slsSts[i] != null)
					model.setSlsSts(slsSts[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (slsActSubTpDesc[i] != null)
					model.setSlsActSubTpDesc(slsActSubTpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamActivityInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamActivityInfoVO[]
	 */
	public SamActivityInfoVO[] getSamActivityInfoVOs(){
		SamActivityInfoVO[] vos = (SamActivityInfoVO[])models.toArray(new SamActivityInfoVO[models.size()]);
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
		this.keymanNm = this.keymanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPlnDt = this.actPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActActDt = this.slsActActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActTpDesc = this.slsActTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSeq = this.slsActSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCmtDesc = this.srepCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsSts = this.slsSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSubTpDesc = this.slsActSubTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

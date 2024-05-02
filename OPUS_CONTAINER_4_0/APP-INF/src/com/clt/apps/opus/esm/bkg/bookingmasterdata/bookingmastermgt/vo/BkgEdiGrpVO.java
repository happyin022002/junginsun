/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgEdiGrpVO.java
*@FileTitle : BkgEdiGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgEdiGrpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEdiGrpVO> models = new ArrayList<BkgEdiGrpVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String mchnTrdPrnrId = null;
	/* Column Info */
	private String esvcGrpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eaiSts = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String esvcGrpNm = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String esvcGrpDeltFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEdiGrpVO() {}

	public BkgEdiGrpVO(String ibflag, String pagerows, String esvcGrpCd, String coCd, String esvcGrpNm, String custTrdPrnrId, String mchnTrdPrnrId, String esvcGrpDeltFlg, String eaiSts, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.coCd = coCd;
		this.mchnTrdPrnrId = mchnTrdPrnrId;
		this.esvcGrpCd = esvcGrpCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.eaiSts = eaiSts;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.esvcGrpNm = esvcGrpNm;
		this.custTrdPrnrId = custTrdPrnrId;
		this.esvcGrpDeltFlg = esvcGrpDeltFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("mchn_trd_prnr_id", getMchnTrdPrnrId());
		this.hashColumns.put("esvc_grp_cd", getEsvcGrpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eai_sts", getEaiSts());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("esvc_grp_nm", getEsvcGrpNm());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("esvc_grp_delt_flg", getEsvcGrpDeltFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("mchn_trd_prnr_id", "mchnTrdPrnrId");
		this.hashFields.put("esvc_grp_cd", "esvcGrpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eai_sts", "eaiSts");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("esvc_grp_nm", "esvcGrpNm");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("esvc_grp_delt_flg", "esvcGrpDeltFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return mchnTrdPrnrId
	 */
	public String getMchnTrdPrnrId() {
		return this.mchnTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return esvcGrpCd
	 */
	public String getEsvcGrpCd() {
		return this.esvcGrpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return eaiSts
	 */
	public String getEaiSts() {
		return this.eaiSts;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return esvcGrpNm
	 */
	public String getEsvcGrpNm() {
		return this.esvcGrpNm;
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
	 * @return esvcGrpDeltFlg
	 */
	public String getEsvcGrpDeltFlg() {
		return this.esvcGrpDeltFlg;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param mchnTrdPrnrId
	 */
	public void setMchnTrdPrnrId(String mchnTrdPrnrId) {
		this.mchnTrdPrnrId = mchnTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param esvcGrpCd
	 */
	public void setEsvcGrpCd(String esvcGrpCd) {
		this.esvcGrpCd = esvcGrpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param eaiSts
	 */
	public void setEaiSts(String eaiSts) {
		this.eaiSts = eaiSts;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param esvcGrpNm
	 */
	public void setEsvcGrpNm(String esvcGrpNm) {
		this.esvcGrpNm = esvcGrpNm;
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
	 * @param esvcGrpDeltFlg
	 */
	public void setEsvcGrpDeltFlg(String esvcGrpDeltFlg) {
		this.esvcGrpDeltFlg = esvcGrpDeltFlg;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setMchnTrdPrnrId(JSPUtil.getParameter(request, prefix + "mchn_trd_prnr_id", ""));
		setEsvcGrpCd(JSPUtil.getParameter(request, prefix + "esvc_grp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEaiSts(JSPUtil.getParameter(request, prefix + "eai_sts", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEsvcGrpNm(JSPUtil.getParameter(request, prefix + "esvc_grp_nm", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setEsvcGrpDeltFlg(JSPUtil.getParameter(request, prefix + "esvc_grp_delt_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEdiGrpVO[]
	 */
	public BkgEdiGrpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEdiGrpVO[]
	 */
	public BkgEdiGrpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEdiGrpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] mchnTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "mchn_trd_prnr_id", length));
			String[] esvcGrpCd = (JSPUtil.getParameter(request, prefix	+ "esvc_grp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eaiSts = (JSPUtil.getParameter(request, prefix	+ "eai_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] esvcGrpNm = (JSPUtil.getParameter(request, prefix	+ "esvc_grp_nm", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] esvcGrpDeltFlg = (JSPUtil.getParameter(request, prefix	+ "esvc_grp_delt_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEdiGrpVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (mchnTrdPrnrId[i] != null)
					model.setMchnTrdPrnrId(mchnTrdPrnrId[i]);
				if (esvcGrpCd[i] != null)
					model.setEsvcGrpCd(esvcGrpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eaiSts[i] != null)
					model.setEaiSts(eaiSts[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (esvcGrpNm[i] != null)
					model.setEsvcGrpNm(esvcGrpNm[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (esvcGrpDeltFlg[i] != null)
					model.setEsvcGrpDeltFlg(esvcGrpDeltFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEdiGrpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEdiGrpVO[]
	 */
	public BkgEdiGrpVO[] getBkgEdiGrpVOs(){
		BkgEdiGrpVO[] vos = (BkgEdiGrpVO[])models.toArray(new BkgEdiGrpVO[models.size()]);
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
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mchnTrdPrnrId = this.mchnTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcGrpCd = this.esvcGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiSts = this.eaiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcGrpNm = this.esvcGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcGrpDeltFlg = this.esvcGrpDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

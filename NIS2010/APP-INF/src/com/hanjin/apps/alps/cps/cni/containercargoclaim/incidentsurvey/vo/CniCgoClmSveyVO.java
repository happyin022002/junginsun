/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCgoClmSveyVO.java
*@FileTitle : CniCgoClmSveyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.12 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmSveyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmSveyVO> models = new ArrayList<CniCgoClmSveyVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sveyInpDt = null;
	/* Column Info */
	private String svyrFeeLoclAmt = null;
	/* Column Info */
	private String svyrLoclCurrCd = null;
	/* Column Info */
	private String svyrFactFndDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svyrXchRt = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String refSvyrNo = null;
	/* Column Info */
	private String svyrApntDt = null;
	/* Column Info */
	private String svyrFeeUsdAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String svyrTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmSveyVO() {}

	public CniCgoClmSveyVO(String ibflag, String pagerows, String cgoClmNo, String clmPtyNo, String svyrTpCd, String refSvyrNo, String svyrApntDt, String sveyInpDt, String svyrFeeLoclAmt, String svyrLoclCurrCd, String svyrXchRt, String svyrFeeUsdAmt, String svyrFactFndDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.sveyInpDt = sveyInpDt;
		this.svyrFeeLoclAmt = svyrFeeLoclAmt;
		this.svyrLoclCurrCd = svyrLoclCurrCd;
		this.svyrFactFndDesc = svyrFactFndDesc;
		this.pagerows = pagerows;
		this.svyrXchRt = svyrXchRt;
		this.clmPtyNo = clmPtyNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.refSvyrNo = refSvyrNo;
		this.svyrApntDt = svyrApntDt;
		this.svyrFeeUsdAmt = svyrFeeUsdAmt;
		this.cgoClmNo = cgoClmNo;
		this.updUsrId = updUsrId;
		this.svyrTpCd = svyrTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("svey_inp_dt", getSveyInpDt());
		this.hashColumns.put("svyr_fee_locl_amt", getSvyrFeeLoclAmt());
		this.hashColumns.put("svyr_locl_curr_cd", getSvyrLoclCurrCd());
		this.hashColumns.put("svyr_fact_fnd_desc", getsvyrFactFndDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svyr_xch_rt", getSvyrXchRt());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ref_svyr_no", getRefSvyrNo());
		this.hashColumns.put("svyr_apnt_dt", getSvyrApntDt());
		this.hashColumns.put("svyr_fee_usd_amt", getSvyrFeeUsdAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("svyr_tp_cd", getSvyrTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("svey_inp_dt", "sveyInpDt");
		this.hashFields.put("svyr_fee_locl_amt", "svyrFeeLoclAmt");
		this.hashFields.put("svyr_locl_curr_cd", "svyrLoclCurrCd");
		this.hashFields.put("svyrFactFndDesc", "svyrFactFndDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svyr_xch_rt", "svyrXchRt");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ref_svyr_no", "refSvyrNo");
		this.hashFields.put("svyr_apnt_dt", "svyrApntDt");
		this.hashFields.put("svyr_fee_usd_amt", "svyrFeeUsdAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("svyr_tp_cd", "svyrTpCd");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return sveyInpDt
	 */
	public String getSveyInpDt() {
		return this.sveyInpDt;
	}
	
	/**
	 * Column Info
	 * @return svyrFeeLoclAmt
	 */
	public String getSvyrFeeLoclAmt() {
		return this.svyrFeeLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return svyrLoclCurrCd
	 */
	public String getSvyrLoclCurrCd() {
		return this.svyrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return svyrFactFndDesc
	 */
	public String getsvyrFactFndDesc() {
		return this.svyrFactFndDesc;
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
	 * @return svyrXchRt
	 */
	public String getSvyrXchRt() {
		return this.svyrXchRt;
	}
	
	/**
	 * Column Info
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return refSvyrNo
	 */
	public String getRefSvyrNo() {
		return this.refSvyrNo;
	}
	
	/**
	 * Column Info
	 * @return svyrApntDt
	 */
	public String getSvyrApntDt() {
		return this.svyrApntDt;
	}
	
	/**
	 * Column Info
	 * @return svyrFeeUsdAmt
	 */
	public String getSvyrFeeUsdAmt() {
		return this.svyrFeeUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
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
	 * @return svyrTpCd
	 */
	public String getSvyrTpCd() {
		return this.svyrTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param sveyInpDt
	 */
	public void setSveyInpDt(String sveyInpDt) {
		this.sveyInpDt = sveyInpDt;
	}
	
	/**
	 * Column Info
	 * @param svyrFeeLoclAmt
	 */
	public void setSvyrFeeLoclAmt(String svyrFeeLoclAmt) {
		this.svyrFeeLoclAmt = svyrFeeLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param svyrLoclCurrCd
	 */
	public void setSvyrLoclCurrCd(String svyrLoclCurrCd) {
		this.svyrLoclCurrCd = svyrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param svyrFactFndDesc
	 */
	public void setsvyrFactFndDesc(String svyrFactFndDesc) {
		this.svyrFactFndDesc = svyrFactFndDesc;
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
	 * @param svyrXchRt
	 */
	public void setSvyrXchRt(String svyrXchRt) {
		this.svyrXchRt = svyrXchRt;
	}
	
	/**
	 * Column Info
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param refSvyrNo
	 */
	public void setRefSvyrNo(String refSvyrNo) {
		this.refSvyrNo = refSvyrNo;
	}
	
	/**
	 * Column Info
	 * @param svyrApntDt
	 */
	public void setSvyrApntDt(String svyrApntDt) {
		this.svyrApntDt = svyrApntDt;
	}
	
	/**
	 * Column Info
	 * @param svyrFeeUsdAmt
	 */
	public void setSvyrFeeUsdAmt(String svyrFeeUsdAmt) {
		this.svyrFeeUsdAmt = svyrFeeUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param svyrTpCd
	 */
	public void setSvyrTpCd(String svyrTpCd) {
		this.svyrTpCd = svyrTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSveyInpDt(JSPUtil.getParameter(request, "svey_inp_dt", ""));
		setSvyrFeeLoclAmt(JSPUtil.getParameter(request, "svyr_fee_locl_amt", ""));
		setSvyrLoclCurrCd(JSPUtil.getParameter(request, "svyr_locl_curr_cd", ""));
		setsvyrFactFndDesc(JSPUtil.getParameter(request, "svyr_fact_fnd_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvyrXchRt(JSPUtil.getParameter(request, "svyr_xch_rt", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRefSvyrNo(JSPUtil.getParameter(request, "ref_svyr_no", ""));
		setSvyrApntDt(JSPUtil.getParameter(request, "svyr_apnt_dt", ""));
		setSvyrFeeUsdAmt(JSPUtil.getParameter(request, "svyr_fee_usd_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSvyrTpCd(JSPUtil.getParameter(request, "svyr_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmSveyVO[]
	 */
	public CniCgoClmSveyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmSveyVO[]
	 */
	public CniCgoClmSveyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmSveyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sveyInpDt = (JSPUtil.getParameter(request, prefix	+ "svey_inp_dt", length));
			String[] svyrFeeLoclAmt = (JSPUtil.getParameter(request, prefix	+ "svyr_fee_locl_amt", length));
			String[] svyrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "svyr_locl_curr_cd", length));
			String[] svyrFactFndDesc = (JSPUtil.getParameter(request, prefix	+ "svyr_fact_fnd_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svyrXchRt = (JSPUtil.getParameter(request, prefix	+ "svyr_xch_rt", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] refSvyrNo = (JSPUtil.getParameter(request, prefix	+ "ref_svyr_no", length));
			String[] svyrApntDt = (JSPUtil.getParameter(request, prefix	+ "svyr_apnt_dt", length));
			String[] svyrFeeUsdAmt = (JSPUtil.getParameter(request, prefix	+ "svyr_fee_usd_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] svyrTpCd = (JSPUtil.getParameter(request, prefix	+ "svyr_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmSveyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sveyInpDt[i] != null)
					model.setSveyInpDt(sveyInpDt[i]);
				if (svyrFeeLoclAmt[i] != null)
					model.setSvyrFeeLoclAmt(svyrFeeLoclAmt[i]);
				if (svyrLoclCurrCd[i] != null)
					model.setSvyrLoclCurrCd(svyrLoclCurrCd[i]);
				if (svyrFactFndDesc[i] != null)
					model.setsvyrFactFndDesc(svyrFactFndDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svyrXchRt[i] != null)
					model.setSvyrXchRt(svyrXchRt[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (refSvyrNo[i] != null)
					model.setRefSvyrNo(refSvyrNo[i]);
				if (svyrApntDt[i] != null)
					model.setSvyrApntDt(svyrApntDt[i]);
				if (svyrFeeUsdAmt[i] != null)
					model.setSvyrFeeUsdAmt(svyrFeeUsdAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (svyrTpCd[i] != null)
					model.setSvyrTpCd(svyrTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmSveyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmSveyVO[]
	 */
	public CniCgoClmSveyVO[] getCniCgoClmSveyVOs(){
		CniCgoClmSveyVO[] vos = (CniCgoClmSveyVO[])models.toArray(new CniCgoClmSveyVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyInpDt = this.sveyInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrFeeLoclAmt = this.svyrFeeLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrLoclCurrCd = this.svyrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrFactFndDesc = this.svyrFactFndDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrXchRt = this.svyrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSvyrNo = this.refSvyrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrApntDt = this.svyrApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrFeeUsdAmt = this.svyrFeeUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrTpCd = this.svyrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

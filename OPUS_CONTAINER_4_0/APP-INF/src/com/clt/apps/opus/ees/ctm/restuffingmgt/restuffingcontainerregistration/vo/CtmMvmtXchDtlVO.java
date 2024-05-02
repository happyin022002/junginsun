/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmMvmtXchDtlVO.java
*@FileTitle : CtmMvmtXchDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.11 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmMvmtXchDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmMvmtXchDtlVO> models = new ArrayList<CtmMvmtXchDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntrXchRsnSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrXchSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrXchRefSeq = null;
	/* Column Info */
	private String xchRsnCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CtmMvmtXchDtlVO() {}

	public CtmMvmtXchDtlVO(String ibflag, String pagerows, String cntrNo, String cnmvYr, String cnmvIdNo, String cntrXchRefSeq, String cntrXchSeq, String cntrXchRsnSeq, String xchRsnCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cntrXchRsnSeq = cntrXchRsnSeq;
		this.creDt = creDt;
		this.cntrXchSeq = cntrXchSeq;
		this.pagerows = pagerows;
		this.cnmvIdNo = cnmvIdNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrXchRefSeq = cntrXchRefSeq;
		this.xchRsnCd = xchRsnCd;
		this.cntrNo = cntrNo;
		this.cnmvYr = cnmvYr;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_xch_rsn_seq", getCntrXchRsnSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_xch_seq", getCntrXchSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_xch_ref_seq", getCntrXchRefSeq());
		this.hashColumns.put("xch_rsn_cd", getXchRsnCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_xch_rsn_seq", "cntrXchRsnSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_xch_seq", "cntrXchSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_xch_ref_seq", "cntrXchRefSeq");
		this.hashFields.put("xch_rsn_cd", "xchRsnCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
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
	 * @return cntrXchRsnSeq
	 */
	public String getCntrXchRsnSeq() {
		return this.cntrXchRsnSeq;
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
	 * @return cntrXchSeq
	 */
	public String getCntrXchSeq() {
		return this.cntrXchSeq;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return cntrXchRefSeq
	 */
	public String getCntrXchRefSeq() {
		return this.cntrXchRefSeq;
	}
	
	/**
	 * Column Info
	 * @return xchRsnCd
	 */
	public String getXchRsnCd() {
		return this.xchRsnCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
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
	 * @param cntrXchRsnSeq
	 */
	public void setCntrXchRsnSeq(String cntrXchRsnSeq) {
		this.cntrXchRsnSeq = cntrXchRsnSeq;
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
	 * @param cntrXchSeq
	 */
	public void setCntrXchSeq(String cntrXchSeq) {
		this.cntrXchSeq = cntrXchSeq;
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
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param cntrXchRefSeq
	 */
	public void setCntrXchRefSeq(String cntrXchRefSeq) {
		this.cntrXchRefSeq = cntrXchRefSeq;
	}
	
	/**
	 * Column Info
	 * @param xchRsnCd
	 */
	public void setXchRsnCd(String xchRsnCd) {
		this.xchRsnCd = xchRsnCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCntrXchRsnSeq(JSPUtil.getParameter(request, "cntr_xch_rsn_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrXchSeq(JSPUtil.getParameter(request, "cntr_xch_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrXchRefSeq(JSPUtil.getParameter(request, "cntr_xch_ref_seq", ""));
		setXchRsnCd(JSPUtil.getParameter(request, "xch_rsn_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmMvmtXchDtlVO[]
	 */
	public CtmMvmtXchDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtmMvmtXchDtlVO[]
	 */
	public CtmMvmtXchDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmMvmtXchDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntrXchRsnSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_rsn_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrXchSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrXchRefSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_ref_seq", length));
			String[] xchRsnCd = (JSPUtil.getParameter(request, prefix	+ "xch_rsn_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmMvmtXchDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntrXchRsnSeq[i] != null)
					model.setCntrXchRsnSeq(cntrXchRsnSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrXchSeq[i] != null)
					model.setCntrXchSeq(cntrXchSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrXchRefSeq[i] != null)
					model.setCntrXchRefSeq(cntrXchRefSeq[i]);
				if (xchRsnCd[i] != null)
					model.setXchRsnCd(xchRsnCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmMvmtXchDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmMvmtXchDtlVO[]
	 */
	public CtmMvmtXchDtlVO[] getCtmMvmtXchDtlVOs(){
		CtmMvmtXchDtlVO[] vos = (CtmMvmtXchDtlVO[])models.toArray(new CtmMvmtXchDtlVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchRsnSeq = this.cntrXchRsnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchSeq = this.cntrXchSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchRefSeq = this.cntrXchRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRsnCd = this.xchRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

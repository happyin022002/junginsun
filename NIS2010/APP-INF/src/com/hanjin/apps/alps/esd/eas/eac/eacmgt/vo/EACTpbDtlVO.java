/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACTpbDtlVO.java
*@FileTitle : EACTpbDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACTpbDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACTpbDtlVO> models = new ArrayList<EACTpbDtlVO>();
	
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String eacDtlSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String audrUsrId = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String diffInvAmt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACTpbDtlVO() {}

	public EACTpbDtlVO(String ibflag, String pagerows, String eacDtlSeq, String eqKndCd, String eqNo, String eqTpszCd, String diffInvAmt, String eacNo, String audrUsrId) {
		this.eacNo = eacNo;
		this.eacDtlSeq = eacDtlSeq;
		this.ibflag = ibflag;
		this.audrUsrId = audrUsrId;
		this.eqNo = eqNo;
		this.diffInvAmt = diffInvAmt;
		this.eqKndCd = eqKndCd;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("eac_dtl_seq", getEacDtlSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("audr_usr_id", getAudrUsrId());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("diff_inv_amt", getDiffInvAmt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("eac_dtl_seq", "eacDtlSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("audr_usr_id", "audrUsrId");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("diff_inv_amt", "diffInvAmt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eacNo
	 */
	public String getEacNo() {
		return this.eacNo;
	}
	
	/**
	 * Column Info
	 * @return eacDtlSeq
	 */
	public String getEacDtlSeq() {
		return this.eacDtlSeq;
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
	 * @return audrUsrId
	 */
	public String getAudrUsrId() {
		return this.audrUsrId;
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
	 * @return diffInvAmt
	 */
	public String getDiffInvAmt() {
		return this.diffInvAmt;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @param eacNo
	 */
	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
	}
	
	/**
	 * Column Info
	 * @param eacDtlSeq
	 */
	public void setEacDtlSeq(String eacDtlSeq) {
		this.eacDtlSeq = eacDtlSeq;
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
	 * @param audrUsrId
	 */
	public void setAudrUsrId(String audrUsrId) {
		this.audrUsrId = audrUsrId;
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
	 * @param diffInvAmt
	 */
	public void setDiffInvAmt(String diffInvAmt) {
		this.diffInvAmt = diffInvAmt;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setEacDtlSeq(JSPUtil.getParameter(request, prefix + "eac_dtl_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAudrUsrId(JSPUtil.getParameter(request, prefix + "audr_usr_id", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDiffInvAmt(JSPUtil.getParameter(request, prefix + "diff_inv_amt", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACTpbDtlVO[]
	 */
	public EACTpbDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACTpbDtlVO[]
	 */
	public EACTpbDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACTpbDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] eacDtlSeq = (JSPUtil.getParameter(request, prefix	+ "eac_dtl_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] audrUsrId = (JSPUtil.getParameter(request, prefix	+ "audr_usr_id", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] diffInvAmt = (JSPUtil.getParameter(request, prefix	+ "diff_inv_amt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACTpbDtlVO();
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (eacDtlSeq[i] != null)
					model.setEacDtlSeq(eacDtlSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (audrUsrId[i] != null)
					model.setAudrUsrId(audrUsrId[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (diffInvAmt[i] != null)
					model.setDiffInvAmt(diffInvAmt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACTpbDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACTpbDtlVO[]
	 */
	public EACTpbDtlVO[] getEACTpbDtlVOs(){
		EACTpbDtlVO[] vos = (EACTpbDtlVO[])models.toArray(new EACTpbDtlVO[models.size()]);
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
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacDtlSeq = this.eacDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audrUsrId = this.audrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffInvAmt = this.diffInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

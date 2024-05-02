/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CtmMovementHisColVO.java
*@FileTitle : CtmMovementHisColVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmMovementHisColVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmMovementHisColVO> models = new ArrayList<CtmMovementHisColVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvHisSeq = null;
	/* Column Info */
	private String cnmvHisColSeq = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cnmvHisColNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CtmMovementHisColVO() {}

	public CtmMovementHisColVO(String ibflag, String pagerows, String cntrNo, String cnmvYr, String cnmvIdNo, String cnmvHisSeq, String cnmvHisColSeq, String cnmvHisColNm, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.pagerows = pagerows;
		this.cnmvIdNo = cnmvIdNo;
		this.ibflag = ibflag;
		this.cnmvHisSeq = cnmvHisSeq;
		this.cnmvHisColSeq = cnmvHisColSeq;
		this.cnmvYr = cnmvYr;
		this.updDt = updDt;
		this.cnmvHisColNm = cnmvHisColNm;
		this.updUsrId = updUsrId;
		this.cntrNo = cntrNo;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_his_seq", getCnmvHisSeq());
		this.hashColumns.put("cnmv_his_col_seq", getCnmvHisColSeq());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnmv_his_col_nm", getCnmvHisColNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_his_seq", "cnmvHisSeq");
		this.hashFields.put("cnmv_his_col_seq", "cnmvHisColSeq");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnmv_his_col_nm", "cnmvHisColNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		return this.hashFields;
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
	 * @return cnmvHisSeq
	 */
	public String getCnmvHisSeq() {
		return this.cnmvHisSeq;
	}
	
	/**
	 * Column Info
	 * @return cnmvHisColSeq
	 */
	public String getCnmvHisColSeq() {
		return this.cnmvHisColSeq;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvHisColNm
	 */
	public String getCnmvHisColNm() {
		return this.cnmvHisColNm;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @param cnmvHisSeq
	 */
	public void setCnmvHisSeq(String cnmvHisSeq) {
		this.cnmvHisSeq = cnmvHisSeq;
	}
	
	/**
	 * Column Info
	 * @param cnmvHisColSeq
	 */
	public void setCnmvHisColSeq(String cnmvHisColSeq) {
		this.cnmvHisColSeq = cnmvHisColSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvHisColNm
	 */
	public void setCnmvHisColNm(String cnmvHisColNm) {
		this.cnmvHisColNm = cnmvHisColNm;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvHisSeq(JSPUtil.getParameter(request, prefix + "cnmv_his_seq", ""));
		setCnmvHisColSeq(JSPUtil.getParameter(request, prefix + "cnmv_his_col_seq", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCnmvHisColNm(JSPUtil.getParameter(request, prefix + "cnmv_his_col_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmMovementHisColVO[]
	 */
	public CtmMovementHisColVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtmMovementHisColVO[]
	 */
	public CtmMovementHisColVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmMovementHisColVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvHisSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_his_seq", length));
			String[] cnmvHisColSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_his_col_seq", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cnmvHisColNm = (JSPUtil.getParameter(request, prefix	+ "cnmv_his_col_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmMovementHisColVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvHisSeq[i] != null)
					model.setCnmvHisSeq(cnmvHisSeq[i]);
				if (cnmvHisColSeq[i] != null)
					model.setCnmvHisColSeq(cnmvHisColSeq[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cnmvHisColNm[i] != null)
					model.setCnmvHisColNm(cnmvHisColNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmMovementHisColVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmMovementHisColVO[]
	 */
	public CtmMovementHisColVO[] getCtmMovementHisColVOs(){
		CtmMovementHisColVO[] vos = (CtmMovementHisColVO[])models.toArray(new CtmMovementHisColVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisSeq = this.cnmvHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisColSeq = this.cnmvHisColSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisColNm = this.cnmvHisColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

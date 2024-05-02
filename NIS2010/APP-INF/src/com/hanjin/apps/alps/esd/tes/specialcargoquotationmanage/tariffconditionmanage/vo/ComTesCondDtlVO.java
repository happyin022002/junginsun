/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComTesCondDtlVO.java
*@FileTitle : ComTesCondDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComTesCondDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComTesCondDtlVO> models = new ArrayList<ComTesCondDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String condOprValCtnt = null;
	/* Column Info */
	private String condDtlUseTpCd = null;
	/* Column Info */
	private String objDpNm = null;
	/* Column Info */
	private String condSeq = null;
	/* Column Info */
	private String tmlCondOprCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tmlCondDtlTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String objListNo = null;
	/* Column Info */
	private String condNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComTesCondDtlVO() {}

	public ComTesCondDtlVO(String ibflag, String pagerows, String condNo, String condDtlUseTpCd, String objDpNm, String condSeq, String tmlCondDtlTpCd, String tmlCondOprCd, String objListNo, String condOprValCtnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.condOprValCtnt = condOprValCtnt;
		this.condDtlUseTpCd = condDtlUseTpCd;
		this.objDpNm = objDpNm;
		this.condSeq = condSeq;
		this.tmlCondOprCd = tmlCondOprCd;
		this.creDt = creDt;
		this.tmlCondDtlTpCd = tmlCondDtlTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.objListNo = objListNo;
		this.condNo = condNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cond_opr_val_ctnt", getCondOprValCtnt());
		this.hashColumns.put("cond_dtl_use_tp_cd", getCondDtlUseTpCd());
		this.hashColumns.put("obj_dp_nm", getObjDpNm());
		this.hashColumns.put("cond_seq", getCondSeq());
		this.hashColumns.put("tml_cond_opr_cd", getTmlCondOprCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tml_cond_dtl_tp_cd", getTmlCondDtlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("obj_list_no", getObjListNo());
		this.hashColumns.put("cond_no", getCondNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cond_opr_val_ctnt", "condOprValCtnt");
		this.hashFields.put("cond_dtl_use_tp_cd", "condDtlUseTpCd");
		this.hashFields.put("obj_dp_nm", "objDpNm");
		this.hashFields.put("cond_seq", "condSeq");
		this.hashFields.put("tml_cond_opr_cd", "tmlCondOprCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tml_cond_dtl_tp_cd", "tmlCondDtlTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("obj_list_no", "objListNo");
		this.hashFields.put("cond_no", "condNo");
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
	 * @return condOprValCtnt
	 */
	public String getCondOprValCtnt() {
		return this.condOprValCtnt;
	}
	
	/**
	 * Column Info
	 * @return condDtlUseTpCd
	 */
	public String getCondDtlUseTpCd() {
		return this.condDtlUseTpCd;
	}
	
	/**
	 * Column Info
	 * @return objDpNm
	 */
	public String getObjDpNm() {
		return this.objDpNm;
	}
	
	/**
	 * Column Info
	 * @return condSeq
	 */
	public String getCondSeq() {
		return this.condSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlCondOprCd
	 */
	public String getTmlCondOprCd() {
		return this.tmlCondOprCd;
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
	 * @return tmlCondDtlTpCd
	 */
	public String getTmlCondDtlTpCd() {
		return this.tmlCondDtlTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return objListNo
	 */
	public String getObjListNo() {
		return this.objListNo;
	}
	
	/**
	 * Column Info
	 * @return condNo
	 */
	public String getCondNo() {
		return this.condNo;
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
	 * @param condOprValCtnt
	 */
	public void setCondOprValCtnt(String condOprValCtnt) {
		this.condOprValCtnt = condOprValCtnt;
	}
	
	/**
	 * Column Info
	 * @param condDtlUseTpCd
	 */
	public void setCondDtlUseTpCd(String condDtlUseTpCd) {
		this.condDtlUseTpCd = condDtlUseTpCd;
	}
	
	/**
	 * Column Info
	 * @param objDpNm
	 */
	public void setObjDpNm(String objDpNm) {
		this.objDpNm = objDpNm;
	}
	
	/**
	 * Column Info
	 * @param condSeq
	 */
	public void setCondSeq(String condSeq) {
		this.condSeq = condSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlCondOprCd
	 */
	public void setTmlCondOprCd(String tmlCondOprCd) {
		this.tmlCondOprCd = tmlCondOprCd;
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
	 * @param tmlCondDtlTpCd
	 */
	public void setTmlCondDtlTpCd(String tmlCondDtlTpCd) {
		this.tmlCondDtlTpCd = tmlCondDtlTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param objListNo
	 */
	public void setObjListNo(String objListNo) {
		this.objListNo = objListNo;
	}
	
	/**
	 * Column Info
	 * @param condNo
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
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
		setCondOprValCtnt(JSPUtil.getParameter(request, prefix + "cond_opr_val_ctnt", ""));
		setCondDtlUseTpCd(JSPUtil.getParameter(request, prefix + "cond_dtl_use_tp_cd", ""));
		setObjDpNm(JSPUtil.getParameter(request, prefix + "obj_dp_nm", ""));
		setCondSeq(JSPUtil.getParameter(request, prefix + "cond_seq", ""));
		setTmlCondOprCd(JSPUtil.getParameter(request, prefix + "tml_cond_opr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTmlCondDtlTpCd(JSPUtil.getParameter(request, prefix + "tml_cond_dtl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setObjListNo(JSPUtil.getParameter(request, prefix + "obj_list_no", ""));
		setCondNo(JSPUtil.getParameter(request, prefix + "cond_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComTesCondDtlVO[]
	 */
	public ComTesCondDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComTesCondDtlVO[]
	 */
	public ComTesCondDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComTesCondDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] condOprValCtnt = (JSPUtil.getParameter(request, prefix	+ "cond_opr_val_ctnt", length));
			String[] condDtlUseTpCd = (JSPUtil.getParameter(request, prefix	+ "cond_dtl_use_tp_cd", length));
			String[] objDpNm = (JSPUtil.getParameter(request, prefix	+ "obj_dp_nm", length));
			String[] condSeq = (JSPUtil.getParameter(request, prefix	+ "cond_seq", length));
			String[] tmlCondOprCd = (JSPUtil.getParameter(request, prefix	+ "tml_cond_opr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tmlCondDtlTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_cond_dtl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] objListNo = (JSPUtil.getParameter(request, prefix	+ "obj_list_no", length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComTesCondDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (condOprValCtnt[i] != null)
					model.setCondOprValCtnt(condOprValCtnt[i]);
				if (condDtlUseTpCd[i] != null)
					model.setCondDtlUseTpCd(condDtlUseTpCd[i]);
				if (objDpNm[i] != null)
					model.setObjDpNm(objDpNm[i]);
				if (condSeq[i] != null)
					model.setCondSeq(condSeq[i]);
				if (tmlCondOprCd[i] != null)
					model.setTmlCondOprCd(tmlCondOprCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tmlCondDtlTpCd[i] != null)
					model.setTmlCondDtlTpCd(tmlCondDtlTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (objListNo[i] != null)
					model.setObjListNo(objListNo[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComTesCondDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComTesCondDtlVO[]
	 */
	public ComTesCondDtlVO[] getComTesCondDtlVOs(){
		ComTesCondDtlVO[] vos = (ComTesCondDtlVO[])models.toArray(new ComTesCondDtlVO[models.size()]);
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
		this.condOprValCtnt = this.condOprValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condDtlUseTpCd = this.condDtlUseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objDpNm = this.objDpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condSeq = this.condSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCondOprCd = this.tmlCondOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCondDtlTpCd = this.tmlCondDtlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNo = this.objListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

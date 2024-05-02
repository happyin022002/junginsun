/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SearchListCnstExptVO.java
*@FileTitle : SearchListCnstExptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo;

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
public class SearchListCnstExptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchListCnstExptVO> models = new ArrayList<SearchListCnstExptVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String nodCd = null;

	/* Column Info */
	private String nodCnstItmCd = null;

	/* Column Info */
	private String nodCnstSeq = null;

	/* Column Info */
	private String cnstExptSeq = null;

	/* Column Info */
	private String cnstExptTpCd = null;

	/* Column Info */
	private String cnstExptNo = null;

	/* Column Info */
	private String cnstExptNoChk = null;

	/* Column Info */
	private String cnstExptRmk = null;

	/* Column Info */
	private String creOfcCd = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchListCnstExptVO() {}

	public SearchListCnstExptVO(String ibflag, String pagerows, String nodCd, String nodCnstItmCd, String nodCnstSeq, String cnstExptSeq, String cnstExptTpCd, String cnstExptNo, String cnstExptNoChk, String cnstExptRmk, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.nodCd = nodCd;
		this.nodCnstItmCd = nodCnstItmCd;
		this.nodCnstSeq = nodCnstSeq;
		this.cnstExptSeq = cnstExptSeq;
		this.cnstExptTpCd = cnstExptTpCd;
		this.cnstExptNo = cnstExptNo;
		this.cnstExptNoChk = cnstExptNoChk;
		this.cnstExptRmk = cnstExptRmk;
		this.creOfcCd = creOfcCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("nod_cnst_itm_cd", getNodCnstItmCd());
		this.hashColumns.put("nod_cnst_seq", getNodCnstSeq());
		this.hashColumns.put("cnst_expt_seq", getCnstExptSeq());
		this.hashColumns.put("cnst_expt_tp_cd", getCnstExptTpCd());
		this.hashColumns.put("cnst_expt_no", getCnstExptNo());
		this.hashColumns.put("cnst_expt_no_chk", getCnstExptNoChk());
		this.hashColumns.put("cnst_expt_rmk", getCnstExptRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("nod_cnst_itm_cd", "nodCnstItmCd");
		this.hashFields.put("nod_cnst_seq", "nodCnstSeq");
		this.hashFields.put("cnst_expt_seq", "cnstExptSeq");
		this.hashFields.put("cnst_expt_tp_cd", "cnstExptTpCd");
		this.hashFields.put("cnst_expt_no", "cnstExptNo");
		this.hashFields.put("cnst_expt_no_chk", "cnstExptNoChk");
		this.hashFields.put("cnst_expt_rmk", "cnstExptRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * 
	 * @return String nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 *
	 * @param String nodCnstItmCd
	 */
	public void setNodCnstItmCd(String nodCnstItmCd) {
		this.nodCnstItmCd = nodCnstItmCd;
	}
	
	/**
	 * 
	 * @return String nodCnstItmCd
	 */
	public String getNodCnstItmCd() {
		return this.nodCnstItmCd;
	}
	
	/**
	 *
	 * @param String nodCnstSeq
	 */
	public void setNodCnstSeq(String nodCnstSeq) {
		this.nodCnstSeq = nodCnstSeq;
	}
	
	/**
	 * 
	 * @return String nodCnstSeq
	 */
	public String getNodCnstSeq() {
		return this.nodCnstSeq;
	}
	
	/**
	 *
	 * @param String cnstExptSeq
	 */
	public void setCnstExptSeq(String cnstExptSeq) {
		this.cnstExptSeq = cnstExptSeq;
	}
	
	/**
	 * 
	 * @return String cnstExptSeq
	 */
	public String getCnstExptSeq() {
		return this.cnstExptSeq;
	}
	
	/**
	 *
	 * @param String cnstExptTpCd
	 */
	public void setCnstExptTpCd(String cnstExptTpCd) {
		this.cnstExptTpCd = cnstExptTpCd;
	}
	
	/**
	 * 
	 * @return String cnstExptTpCd
	 */
	public String getCnstExptTpCd() {
		return this.cnstExptTpCd;
	}
	
	/**
	 *
	 * @param String cnstExptNo
	 */
	public void setCnstExptNo(String cnstExptNo) {
		this.cnstExptNo = cnstExptNo;
	}
	
	/**
	 * 
	 * @return String cnstExptNo
	 */
	public String getCnstExptNo() {
		return this.cnstExptNo;
	}
	
	/**
	 *
	 * @param String cnstExptNoChk
	 */
	public void setCnstExptNoChk(String cnstExptNoChk) {
		this.cnstExptNoChk = cnstExptNoChk;
	}
	
	/**
	 * 
	 * @return String cnstExptNoChk
	 */
	public String getCnstExptNoChk() {
		return this.cnstExptNoChk;
	}
	
	/**
	 *
	 * @param String cnstExptRmk
	 */
	public void setCnstExptRmk(String cnstExptRmk) {
		this.cnstExptRmk = cnstExptRmk;
	}
	
	/**
	 * 
	 * @return String cnstExptRmk
	 */
	public String getCnstExptRmk() {
		return this.cnstExptRmk;
	}
	
	/**
	 *
	 * @param String creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * 
	 * @return String creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setNodCnstItmCd(JSPUtil.getParameter(request, prefix + "nod_cnst_itm_cd", ""));
		setNodCnstSeq(JSPUtil.getParameter(request, prefix + "nod_cnst_seq", ""));
		setCnstExptSeq(JSPUtil.getParameter(request, prefix + "cnst_expt_seq", ""));
		setCnstExptTpCd(JSPUtil.getParameter(request, prefix + "cnst_expt_tp_cd", ""));
		setCnstExptNo(JSPUtil.getParameter(request, prefix + "cnst_expt_no", ""));
		setCnstExptNoChk(JSPUtil.getParameter(request, prefix + "cnst_expt_no_chk", ""));
		setCnstExptRmk(JSPUtil.getParameter(request, prefix + "cnst_expt_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchListCnstExptVO[]
	 */
	public SearchListCnstExptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchListCnstExptVO[]
	 */
	public SearchListCnstExptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchListCnstExptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] nodCnstItmCd = (JSPUtil.getParameter(request, prefix	+ "nod_cnst_itm_cd", length));
			String[] nodCnstSeq = (JSPUtil.getParameter(request, prefix	+ "nod_cnst_seq", length));
			String[] cnstExptSeq = (JSPUtil.getParameter(request, prefix	+ "cnst_expt_seq", length));
			String[] cnstExptTpCd = (JSPUtil.getParameter(request, prefix	+ "cnst_expt_tp_cd", length));
			String[] cnstExptNo = (JSPUtil.getParameter(request, prefix	+ "cnst_expt_no", length));
			String[] cnstExptNoChk = (JSPUtil.getParameter(request, prefix	+ "cnst_expt_no_chk", length));
			String[] cnstExptRmk = (JSPUtil.getParameter(request, prefix	+ "cnst_expt_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SearchListCnstExptVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (nodCd[i] != null) 
					model.setNodCd(nodCd[i]);
				if (nodCnstItmCd[i] != null) 
					model.setNodCnstItmCd(nodCnstItmCd[i]);
				if (nodCnstSeq[i] != null) 
					model.setNodCnstSeq(nodCnstSeq[i]);
				if (cnstExptSeq[i] != null) 
					model.setCnstExptSeq(cnstExptSeq[i]);
				if (cnstExptTpCd[i] != null) 
					model.setCnstExptTpCd(cnstExptTpCd[i]);
				if (cnstExptNo[i] != null) 
					model.setCnstExptNo(cnstExptNo[i]);
				if (cnstExptNoChk[i] != null) 
					model.setCnstExptNoChk(cnstExptNoChk[i]);
				if (cnstExptRmk[i] != null) 
					model.setCnstExptRmk(cnstExptRmk[i]);
				if (creOfcCd[i] != null) 
					model.setCreOfcCd(creOfcCd[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchListCnstExptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchListCnstExptVO[]
	 */
	public SearchListCnstExptVO[] getSearchListCnstExptVOs(){
		SearchListCnstExptVO[] vos = (SearchListCnstExptVO[])models.toArray(new SearchListCnstExptVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCnstItmCd = this.nodCnstItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCnstSeq = this.nodCnstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstExptSeq = this.cnstExptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstExptTpCd = this.cnstExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstExptNo = this.cnstExptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstExptNoChk = this.cnstExptNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstExptRmk = this.cnstExptRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
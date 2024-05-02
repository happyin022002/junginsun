/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TriPropGRIVO.java
*@FileTitle : TriPropGRIVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.23 박성수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo;

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
 * @author 박성수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TriPropGRIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TriPropGRIVO> models = new ArrayList<TriPropGRIVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String griEffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String triAproUsrId = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String triRqstOfcCd = null;
	/* Column Info */
	private String triAproOfcCd = null;
	/* Column Info */
	private String triRqstUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TriPropGRIVO() {}

	public TriPropGRIVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String griEffDt, String triRqstOfcCd, String triRqstUsrId, String triAproOfcCd, String triAproUsrId, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.griEffDt = griEffDt;
		this.ibflag = ibflag;
		this.triAproUsrId = triAproUsrId;
		this.trfNo = trfNo;
		this.trfPfxCd = trfPfxCd;
		this.updUsrId = updUsrId;
		this.triRqstOfcCd = triRqstOfcCd;
		this.triAproOfcCd = triAproOfcCd;
		this.triRqstUsrId = triRqstUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("gri_eff_dt", getGriEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tri_apro_usr_id", getTriAproUsrId());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tri_rqst_ofc_cd", getTriRqstOfcCd());
		this.hashColumns.put("tri_apro_ofc_cd", getTriAproOfcCd());
		this.hashColumns.put("tri_rqst_usr_id", getTriRqstUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("gri_eff_dt", "griEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tri_apro_usr_id", "triAproUsrId");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tri_rqst_ofc_cd", "triRqstOfcCd");
		this.hashFields.put("tri_apro_ofc_cd", "triAproOfcCd");
		this.hashFields.put("tri_rqst_usr_id", "triRqstUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return griEffDt
	 */
	public String getGriEffDt() {
		return this.griEffDt;
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
	 * @return triAproUsrId
	 */
	public String getTriAproUsrId() {
		return this.triAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
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
	 * @return triRqstOfcCd
	 */
	public String getTriRqstOfcCd() {
		return this.triRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return triAproOfcCd
	 */
	public String getTriAproOfcCd() {
		return this.triAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return triRqstUsrId
	 */
	public String getTriRqstUsrId() {
		return this.triRqstUsrId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param griEffDt
	 */
	public void setGriEffDt(String griEffDt) {
		this.griEffDt = griEffDt;
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
	 * @param triAproUsrId
	 */
	public void setTriAproUsrId(String triAproUsrId) {
		this.triAproUsrId = triAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
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
	 * @param triRqstOfcCd
	 */
	public void setTriRqstOfcCd(String triRqstOfcCd) {
		this.triRqstOfcCd = triRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param triAproOfcCd
	 */
	public void setTriAproOfcCd(String triAproOfcCd) {
		this.triAproOfcCd = triAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param triRqstUsrId
	 */
	public void setTriRqstUsrId(String triRqstUsrId) {
		this.triRqstUsrId = triRqstUsrId;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setGriEffDt(JSPUtil.getParameter(request, "gri_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTriAproUsrId(JSPUtil.getParameter(request, "tri_apro_usr_id", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, "trf_pfx_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTriRqstOfcCd(JSPUtil.getParameter(request, "tri_rqst_ofc_cd", ""));
		setTriAproOfcCd(JSPUtil.getParameter(request, "tri_apro_ofc_cd", ""));
		setTriRqstUsrId(JSPUtil.getParameter(request, "tri_rqst_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TriPropGRIVO[]
	 */
	public TriPropGRIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TriPropGRIVO[]
	 */
	public TriPropGRIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TriPropGRIVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] griEffDt = (JSPUtil.getParameter(request, prefix	+ "gri_eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] triAproUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_apro_usr_id", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] triRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_ofc_cd", length));
			String[] triAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_apro_ofc_cd", length));
			String[] triRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TriPropGRIVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (griEffDt[i] != null)
					model.setGriEffDt(griEffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (triAproUsrId[i] != null)
					model.setTriAproUsrId(triAproUsrId[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (triRqstOfcCd[i] != null)
					model.setTriRqstOfcCd(triRqstOfcCd[i]);
				if (triAproOfcCd[i] != null)
					model.setTriAproOfcCd(triAproOfcCd[i]);
				if (triRqstUsrId[i] != null)
					model.setTriRqstUsrId(triRqstUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTriPropGRIVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TriPropGRIVO[]
	 */
	public TriPropGRIVO[] getTriPropGRIVOs(){
		TriPropGRIVO[] vos = (TriPropGRIVO[])models.toArray(new TriPropGRIVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griEffDt = this.griEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproUsrId = this.triAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstOfcCd = this.triRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproOfcCd = this.triAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstUsrId = this.triRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesAwkCgoAdonHdrVO.java
*@FileTitle : TesAwkCgoAdonHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesAwkCgoAdonHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAwkCgoAdonHdrVO> models = new ArrayList<TesAwkCgoAdonHdrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String lstUpdUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String fmNodYdNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toNodYdNo = null;
	/* Column Info */
	private String tmlAwkAdonVerNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String condNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lstUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesAwkCgoAdonHdrVO() {}

	public TesAwkCgoAdonHdrVO(String ibflag, String pagerows, String fmLocCd, String fmNodYdNo, String toLocCd, String toNodYdNo, String condNo, String tmlAwkAdonVerNo, String vndrSeq, String vndrNm, String calcRmk, String lstUpdUsrId, String lstUpdDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.calcRmk = calcRmk;
		this.creDt = creDt;
		this.toLocCd = toLocCd;
		this.lstUpdUsrId = lstUpdUsrId;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.fmNodYdNo = fmNodYdNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.toNodYdNo = toNodYdNo;
		this.tmlAwkAdonVerNo = tmlAwkAdonVerNo;
		this.vndrSeq = vndrSeq;
		this.fmLocCd = fmLocCd;
		this.condNo = condNo;
		this.updUsrId = updUsrId;
		this.lstUpdDt = lstUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("lst_upd_usr_id", getLstUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("fm_nod_yd_no", getFmNodYdNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_nod_yd_no", getToNodYdNo());
		this.hashColumns.put("tml_awk_adon_ver_no", getTmlAwkAdonVerNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("cond_no", getCondNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lst_upd_dt", getLstUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("lst_upd_usr_id", "lstUpdUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("fm_nod_yd_no", "fmNodYdNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_nod_yd_no", "toNodYdNo");
		this.hashFields.put("tml_awk_adon_ver_no", "tmlAwkAdonVerNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("cond_no", "condNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lst_upd_dt", "lstUpdDt");
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
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
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
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return lstUpdUsrId
	 */
	public String getLstUpdUsrId() {
		return this.lstUpdUsrId;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return fmNodYdNo
	 */
	public String getFmNodYdNo() {
		return this.fmNodYdNo;
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
	 * @return toNodYdNo
	 */
	public String getToNodYdNo() {
		return this.toNodYdNo;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkAdonVerNo
	 */
	public String getTmlAwkAdonVerNo() {
		return this.tmlAwkAdonVerNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
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
	 * @return lstUpdDt
	 */
	public String getLstUpdDt() {
		return this.lstUpdDt;
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
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
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
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param lstUpdUsrId
	 */
	public void setLstUpdUsrId(String lstUpdUsrId) {
		this.lstUpdUsrId = lstUpdUsrId;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param fmNodYdNo
	 */
	public void setFmNodYdNo(String fmNodYdNo) {
		this.fmNodYdNo = fmNodYdNo;
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
	 * @param toNodYdNo
	 */
	public void setToNodYdNo(String toNodYdNo) {
		this.toNodYdNo = toNodYdNo;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkAdonVerNo
	 */
	public void setTmlAwkAdonVerNo(String tmlAwkAdonVerNo) {
		this.tmlAwkAdonVerNo = tmlAwkAdonVerNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
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
	 * Column Info
	 * @param lstUpdDt
	 */
	public void setLstUpdDt(String lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
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
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setLstUpdUsrId(JSPUtil.getParameter(request, prefix + "lst_upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setFmNodYdNo(JSPUtil.getParameter(request, prefix + "fm_nod_yd_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToNodYdNo(JSPUtil.getParameter(request, prefix + "to_nod_yd_no", ""));
		setTmlAwkAdonVerNo(JSPUtil.getParameter(request, prefix + "tml_awk_adon_ver_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setCondNo(JSPUtil.getParameter(request, prefix + "cond_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLstUpdDt(JSPUtil.getParameter(request, prefix + "lst_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAwkCgoAdonHdrVO[]
	 */
	public TesAwkCgoAdonHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAwkCgoAdonHdrVO[]
	 */
	public TesAwkCgoAdonHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAwkCgoAdonHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] lstUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "lst_upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] fmNodYdNo = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yd_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toNodYdNo = (JSPUtil.getParameter(request, prefix	+ "to_nod_yd_no", length));
			String[] tmlAwkAdonVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_awk_adon_ver_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lstUpdDt = (JSPUtil.getParameter(request, prefix	+ "lst_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAwkCgoAdonHdrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (lstUpdUsrId[i] != null)
					model.setLstUpdUsrId(lstUpdUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (fmNodYdNo[i] != null)
					model.setFmNodYdNo(fmNodYdNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toNodYdNo[i] != null)
					model.setToNodYdNo(toNodYdNo[i]);
				if (tmlAwkAdonVerNo[i] != null)
					model.setTmlAwkAdonVerNo(tmlAwkAdonVerNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lstUpdDt[i] != null)
					model.setLstUpdDt(lstUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAwkCgoAdonHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAwkCgoAdonHdrVO[]
	 */
	public TesAwkCgoAdonHdrVO[] getTesAwkCgoAdonHdrVOs(){
		TesAwkCgoAdonHdrVO[] vos = (TesAwkCgoAdonHdrVO[])models.toArray(new TesAwkCgoAdonHdrVO[models.size()]);
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
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUpdUsrId = this.lstUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYdNo = this.fmNodYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYdNo = this.toNodYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkAdonVerNo = this.tmlAwkAdonVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUpdDt = this.lstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

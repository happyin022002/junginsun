/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VskVipsIfHdrVO.java
*@FileTitle : VskVipsIfHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class VskVipsIfHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskVipsIfHdrVO> models = new ArrayList<VskVipsIfHdrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vslCd = null;

	/* Column Info */
	private String skdVoyNo = null;

	/* Column Info */
	private String vipsIfSeq = null;

	/* Column Info */
	private String insfId = null;

	/* Column Info */
	private String insfPrsId = null;

	/* Column Info */
	private String insfDttm = null;

	/* Column Info */
	private String insfCnqeVal = null;

	/* Column Info */
	private String insfDvCd = null;

	/* Column Info */
	private String vipsRunUtNo = null;

	/* Column Info */
	private String vipsIfTgtFlg = null;

	/* Column Info */
	private String vipsIfProcKnt = null;

	/* Column Info */
	private String vipsIfRmk = null;

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
	
	public VskVipsIfHdrVO() {}

	public VskVipsIfHdrVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String vipsIfSeq, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String vipsRunUtNo, String vipsIfTgtFlg, String vipsIfProcKnt, String vipsIfRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.vipsIfSeq = vipsIfSeq;
		this.insfId = insfId;
		this.insfPrsId = insfPrsId;
		this.insfDttm = insfDttm;
		this.insfCnqeVal = insfCnqeVal;
		this.insfDvCd = insfDvCd;
		this.vipsRunUtNo = vipsRunUtNo;
		this.vipsIfTgtFlg = vipsIfTgtFlg;
		this.vipsIfProcKnt = vipsIfProcKnt;
		this.vipsIfRmk = vipsIfRmk;
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
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vips_if_seq", getVipsIfSeq());
		this.hashColumns.put("insf_id", getInsfId());
		this.hashColumns.put("insf_prs_id", getInsfPrsId());
		this.hashColumns.put("insf_dttm", getInsfDttm());
		this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
		this.hashColumns.put("insf_dv_cd", getInsfDvCd());
		this.hashColumns.put("vips_run_ut_no", getVipsRunUtNo());
		this.hashColumns.put("vips_if_tgt_flg", getVipsIfTgtFlg());
		this.hashColumns.put("vips_if_proc_knt", getVipsIfProcKnt());
		this.hashColumns.put("vips_if_rmk", getVipsIfRmk());
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
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vips_if_seq", "vipsIfSeq");
		this.hashFields.put("insf_id", "insfId");
		this.hashFields.put("insf_prs_id", "insfPrsId");
		this.hashFields.put("insf_dttm", "insfDttm");
		this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
		this.hashFields.put("insf_dv_cd", "insfDvCd");
		this.hashFields.put("vips_run_ut_no", "vipsRunUtNo");
		this.hashFields.put("vips_if_tgt_flg", "vipsIfTgtFlg");
		this.hashFields.put("vips_if_proc_knt", "vipsIfProcKnt");
		this.hashFields.put("vips_if_rmk", "vipsIfRmk");
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
	 * @param String vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * 
	 * @return String vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 *
	 * @param String skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * 
	 * @return String skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 *
	 * @param String vipsIfSeq
	 */
	public void setVipsIfSeq(String vipsIfSeq) {
		this.vipsIfSeq = vipsIfSeq;
	}
	
	/**
	 * 
	 * @return String vipsIfSeq
	 */
	public String getVipsIfSeq() {
		return this.vipsIfSeq;
	}
	
	/**
	 *
	 * @param String insfId
	 */
	public void setInsfId(String insfId) {
		this.insfId = insfId;
	}
	
	/**
	 * 
	 * @return String insfId
	 */
	public String getInsfId() {
		return this.insfId;
	}
	
	/**
	 *
	 * @param String insfPrsId
	 */
	public void setInsfPrsId(String insfPrsId) {
		this.insfPrsId = insfPrsId;
	}
	
	/**
	 * 
	 * @return String insfPrsId
	 */
	public String getInsfPrsId() {
		return this.insfPrsId;
	}
	
	/**
	 *
	 * @param String insfDttm
	 */
	public void setInsfDttm(String insfDttm) {
		this.insfDttm = insfDttm;
	}
	
	/**
	 * 
	 * @return String insfDttm
	 */
	public String getInsfDttm() {
		return this.insfDttm;
	}
	
	/**
	 *
	 * @param String insfCnqeVal
	 */
	public void setInsfCnqeVal(String insfCnqeVal) {
		this.insfCnqeVal = insfCnqeVal;
	}
	
	/**
	 * 
	 * @return String insfCnqeVal
	 */
	public String getInsfCnqeVal() {
		return this.insfCnqeVal;
	}
	
	/**
	 *
	 * @param String insfDvCd
	 */
	public void setInsfDvCd(String insfDvCd) {
		this.insfDvCd = insfDvCd;
	}
	
	/**
	 * 
	 * @return String insfDvCd
	 */
	public String getInsfDvCd() {
		return this.insfDvCd;
	}
	
	/**
	 *
	 * @param String vipsRunUtNo
	 */
	public void setVipsRunUtNo(String vipsRunUtNo) {
		this.vipsRunUtNo = vipsRunUtNo;
	}
	
	/**
	 * 
	 * @return String vipsRunUtNo
	 */
	public String getVipsRunUtNo() {
		return this.vipsRunUtNo;
	}
	
	/**
	 *
	 * @param String vipsIfTgtFlg
	 */
	public void setVipsIfTgtFlg(String vipsIfTgtFlg) {
		this.vipsIfTgtFlg = vipsIfTgtFlg;
	}
	
	/**
	 * 
	 * @return String vipsIfTgtFlg
	 */
	public String getVipsIfTgtFlg() {
		return this.vipsIfTgtFlg;
	}
	
	/**
	 *
	 * @param String vipsIfProcKnt
	 */
	public void setVipsIfProcKnt(String vipsIfProcKnt) {
		this.vipsIfProcKnt = vipsIfProcKnt;
	}
	
	/**
	 * 
	 * @return String vipsIfProcKnt
	 */
	public String getVipsIfProcKnt() {
		return this.vipsIfProcKnt;
	}
	
	/**
	 *
	 * @param String vipsIfRmk
	 */
	public void setVipsIfRmk(String vipsIfRmk) {
		this.vipsIfRmk = vipsIfRmk;
	}
	
	/**
	 * 
	 * @return String vipsIfRmk
	 */
	public String getVipsIfRmk() {
		return this.vipsIfRmk;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVipsIfSeq(JSPUtil.getParameter(request, prefix + "vips_if_seq", ""));
		setInsfId(JSPUtil.getParameter(request, prefix + "insf_id", ""));
		setInsfPrsId(JSPUtil.getParameter(request, prefix + "insf_prs_id", ""));
		setInsfDttm(JSPUtil.getParameter(request, prefix + "insf_dttm", ""));
		setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
		setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
		setVipsRunUtNo(JSPUtil.getParameter(request, prefix + "vips_run_ut_no", ""));
		setVipsIfTgtFlg(JSPUtil.getParameter(request, prefix + "vips_if_tgt_flg", ""));
		setVipsIfProcKnt(JSPUtil.getParameter(request, prefix + "vips_if_proc_knt", ""));
		setVipsIfRmk(JSPUtil.getParameter(request, prefix + "vips_if_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVipsIfHdrVO[]
	 */
	public VskVipsIfHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVipsIfHdrVO[]
	 */
	public VskVipsIfHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskVipsIfHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vipsIfSeq = (JSPUtil.getParameter(request, prefix	+ "vips_if_seq", length));
			String[] insfId = (JSPUtil.getParameter(request, prefix	+ "insf_id", length));
			String[] insfPrsId = (JSPUtil.getParameter(request, prefix	+ "insf_prs_id", length));
			String[] insfDttm = (JSPUtil.getParameter(request, prefix	+ "insf_dttm", length));
			String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix	+ "insf_cnqe_val", length));
			String[] insfDvCd = (JSPUtil.getParameter(request, prefix	+ "insf_dv_cd", length));
			String[] vipsRunUtNo = (JSPUtil.getParameter(request, prefix	+ "vips_run_ut_no", length));
			String[] vipsIfTgtFlg = (JSPUtil.getParameter(request, prefix	+ "vips_if_tgt_flg", length));
			String[] vipsIfProcKnt = (JSPUtil.getParameter(request, prefix	+ "vips_if_proc_knt", length));
			String[] vipsIfRmk = (JSPUtil.getParameter(request, prefix	+ "vips_if_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new VskVipsIfHdrVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vslCd[i] != null) 
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null) 
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vipsIfSeq[i] != null) 
					model.setVipsIfSeq(vipsIfSeq[i]);
				if (insfId[i] != null) 
					model.setInsfId(insfId[i]);
				if (insfPrsId[i] != null) 
					model.setInsfPrsId(insfPrsId[i]);
				if (insfDttm[i] != null) 
					model.setInsfDttm(insfDttm[i]);
				if (insfCnqeVal[i] != null) 
					model.setInsfCnqeVal(insfCnqeVal[i]);
				if (insfDvCd[i] != null) 
					model.setInsfDvCd(insfDvCd[i]);
				if (vipsRunUtNo[i] != null) 
					model.setVipsRunUtNo(vipsRunUtNo[i]);
				if (vipsIfTgtFlg[i] != null) 
					model.setVipsIfTgtFlg(vipsIfTgtFlg[i]);
				if (vipsIfProcKnt[i] != null) 
					model.setVipsIfProcKnt(vipsIfProcKnt[i]);
				if (vipsIfRmk[i] != null) 
					model.setVipsIfRmk(vipsIfRmk[i]);
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
		return getVskVipsIfHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskVipsIfHdrVO[]
	 */
	public VskVipsIfHdrVO[] getVskVipsIfHdrVOs(){
		VskVipsIfHdrVO[] vos = (VskVipsIfHdrVO[])models.toArray(new VskVipsIfHdrVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsIfSeq = this.vipsIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfId = this.insfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfPrsId = this.insfPrsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDttm = this.insfDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfCnqeVal = this.insfCnqeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDvCd = this.insfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsRunUtNo = this.vipsRunUtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsIfTgtFlg = this.vipsIfTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsIfProcKnt = this.vipsIfProcKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipsIfRmk = this.vipsIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
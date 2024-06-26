/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommentHistoryVO.java
*@FileTitle : CommentHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommentHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommentHistoryVO> models = new ArrayList<CommentHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String progUsrId = null;
	/* Column Info */
	private String stsDesc = null;
	/* Column Info */
	private String progSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String dmdtExptRqstStsCd = null;
	/* Column Info */
	private String progDt = null;
	/* Column Info */
	private String progOfcCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String progUsrNm = null;
	/* Column Info */
	private String progRmk = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String progRmkFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommentHistoryVO() {}

	public CommentHistoryVO(String ibflag, String pagerows, String aftExptDarNo, String progSeq, String dmdtExptRqstStsCd, String stsDesc, String progRmk, String progDt, String progUsrId, String progUsrNm, String progOfcCd, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String progRmkFlg) {
		this.updDt = updDt;
		this.progUsrId = progUsrId;
		this.stsDesc = stsDesc;
		this.progSeq = progSeq;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.aftExptDarNo = aftExptDarNo;
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
		this.progDt = progDt;
		this.progOfcCd = progOfcCd;
		this.creOfcCd = creOfcCd;
		this.progUsrNm = progUsrNm;
		this.progRmk = progRmk;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.progRmkFlg = progRmkFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prog_usr_id", getProgUsrId());
		this.hashColumns.put("sts_desc", getStsDesc());
		this.hashColumns.put("prog_seq", getProgSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
		this.hashColumns.put("prog_dt", getProgDt());
		this.hashColumns.put("prog_ofc_cd", getProgOfcCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("prog_usr_nm", getProgUsrNm());
		this.hashColumns.put("prog_rmk", getProgRmk());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prog_rmk_flg", getProgRmkFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prog_usr_id", "progUsrId");
		this.hashFields.put("sts_desc", "stsDesc");
		this.hashFields.put("prog_seq", "progSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
		this.hashFields.put("prog_dt", "progDt");
		this.hashFields.put("prog_ofc_cd", "progOfcCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("prog_usr_nm", "progUsrNm");
		this.hashFields.put("prog_rmk", "progRmk");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prog_rmk_flg", "progRmkFlg");
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
	 * @return progUsrId
	 */
	public String getProgUsrId() {
		return this.progUsrId;
	}
	
	/**
	 * Column Info
	 * @return stsDesc
	 */
	public String getStsDesc() {
		return this.stsDesc;
	}
	
	/**
	 * Column Info
	 * @return progSeq
	 */
	public String getProgSeq() {
		return this.progSeq;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstStsCd
	 */
	public String getDmdtExptRqstStsCd() {
		return this.dmdtExptRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return progDt
	 */
	public String getProgDt() {
		return this.progDt;
	}
	
	/**
	 * Column Info
	 * @return progOfcCd
	 */
	public String getProgOfcCd() {
		return this.progOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return progUsrNm
	 */
	public String getProgUsrNm() {
		return this.progUsrNm;
	}
	
	/**
	 * Column Info
	 * @return progRmk
	 */
	public String getProgRmk() {
		return this.progRmk;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @param progUsrId
	 */
	public void setProgUsrId(String progUsrId) {
		this.progUsrId = progUsrId;
	}
	
	/**
	 * Column Info
	 * @param stsDesc
	 */
	public void setStsDesc(String stsDesc) {
		this.stsDesc = stsDesc;
	}
	
	/**
	 * Column Info
	 * @param progSeq
	 */
	public void setProgSeq(String progSeq) {
		this.progSeq = progSeq;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptRqstStsCd
	 */
	public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param progDt
	 */
	public void setProgDt(String progDt) {
		this.progDt = progDt;
	}
	
	/**
	 * Column Info
	 * @param progOfcCd
	 */
	public void setProgOfcCd(String progOfcCd) {
		this.progOfcCd = progOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param progUsrNm
	 */
	public void setProgUsrNm(String progUsrNm) {
		this.progUsrNm = progUsrNm;
	}
	
	/**
	 * Column Info
	 * @param progRmk
	 */
	public void setProgRmk(String progRmk) {
		this.progRmk = progRmk;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getProgRmkFlg() {
		return progRmkFlg;
	}

	public void setProgRmkFlg(String progRmkFlg) {
		this.progRmkFlg = progRmkFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setProgUsrId(JSPUtil.getParameter(request, "prog_usr_id", ""));
		setStsDesc(JSPUtil.getParameter(request, "sts_desc", ""));
		setProgSeq(JSPUtil.getParameter(request, "prog_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, "aft_expt_dar_no", ""));
		setDmdtExptRqstStsCd(JSPUtil.getParameter(request, "dmdt_expt_rqst_sts_cd", ""));
		setProgDt(JSPUtil.getParameter(request, "prog_dt", ""));
		setProgOfcCd(JSPUtil.getParameter(request, "prog_ofc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setProgUsrNm(JSPUtil.getParameter(request, "prog_usr_nm", ""));
		setProgRmk(JSPUtil.getParameter(request, "prog_rmk", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setProgRmkFlg(JSPUtil.getParameter(request, "prog_rmk_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommentHistoryVO[]
	 */
	public CommentHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommentHistoryVO[]
	 */
	public CommentHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommentHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] progUsrId = (JSPUtil.getParameter(request, prefix	+ "prog_usr_id", length));
			String[] stsDesc = (JSPUtil.getParameter(request, prefix	+ "sts_desc", length));
			String[] progSeq = (JSPUtil.getParameter(request, prefix	+ "prog_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_cd", length));
			String[] progDt = (JSPUtil.getParameter(request, prefix	+ "prog_dt", length));
			String[] progOfcCd = (JSPUtil.getParameter(request, prefix	+ "prog_ofc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] progUsrNm = (JSPUtil.getParameter(request, prefix	+ "prog_usr_nm", length));
			String[] progRmk = (JSPUtil.getParameter(request, prefix	+ "prog_rmk", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] progRmkFlg = (JSPUtil.getParameter(request, prefix	+ "prog_rmk_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommentHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (progUsrId[i] != null)
					model.setProgUsrId(progUsrId[i]);
				if (stsDesc[i] != null)
					model.setStsDesc(stsDesc[i]);
				if (progSeq[i] != null)
					model.setProgSeq(progSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (dmdtExptRqstStsCd[i] != null)
					model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
				if (progDt[i] != null)
					model.setProgDt(progDt[i]);
				if (progOfcCd[i] != null)
					model.setProgOfcCd(progOfcCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (progUsrNm[i] != null)
					model.setProgUsrNm(progUsrNm[i]);
				if (progRmk[i] != null)
					model.setProgRmk(progRmk[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (progRmkFlg[i] != null)
					model.setProgRmkFlg(progRmkFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommentHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommentHistoryVO[]
	 */
	public CommentHistoryVO[] getCommentHistoryVOs(){
		CommentHistoryVO[] vos = (CommentHistoryVO[])models.toArray(new CommentHistoryVO[models.size()]);
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
		this.progUsrId = this.progUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsDesc = this.stsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progSeq = this.progSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progDt = this.progDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progOfcCd = this.progOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progUsrNm = this.progUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRmk = this.progRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRmkFlg = this.progRmkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

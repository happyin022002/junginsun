/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckReguPkgIbcCdVO.java
*@FileTitle : ScgPckReguPkgIbcCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;


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

public class ScgPckReguPkgIbcCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckReguPkgIbcCdVO> models = new ArrayList<ScgPckReguPkgIbcCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String andOrCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String pkgCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String pckCdSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pkgTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String pckCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String permChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckReguPkgIbcCdVO() {}

	public ScgPckReguPkgIbcCdVO(String ibflag, String pagerows, String pckCd, String pckCdSeq, String dispNo, String seq, String permChk, String pkgTpCd, String pkgCd, String andOrCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.andOrCd = andOrCd;
		this.dispNo = dispNo;
		this.pkgCd = pkgCd;
		this.deltFlg = deltFlg;
		this.pckCdSeq = pckCdSeq;
		this.creDt = creDt;
		this.pkgTpCd = pkgTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.pckCd = pckCd;
		this.seq = seq;
		this.updUsrId = updUsrId;
		this.permChk = permChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("and_or_cd", getAndOrCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("pkg_cd", getPkgCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("pck_cd_seq", getPckCdSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pkg_tp_cd", getPkgTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pck_cd", getPckCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("perm_chk", getPermChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("and_or_cd", "andOrCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("pkg_cd", "pkgCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("pck_cd_seq", "pckCdSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pkg_tp_cd", "pkgTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pck_cd", "pckCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("perm_chk", "permChk");
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
	 * @return andOrCd
	 */
	public String getAndOrCd() {
		return this.andOrCd;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return pkgCd
	 */
	public String getPkgCd() {
		return this.pkgCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return pckCdSeq
	 */
	public String getPckCdSeq() {
		return this.pckCdSeq;
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
	 * @return pkgTpCd
	 */
	public String getPkgTpCd() {
		return this.pkgTpCd;
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
	 * @return pckCd
	 */
	public String getPckCd() {
		return this.pckCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @return permChk
	 */
	public String getPermChk() {
		return this.permChk;
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
	 * @param andOrCd
	 */
	public void setAndOrCd(String andOrCd) {
		this.andOrCd = andOrCd;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param pkgCd
	 */
	public void setPkgCd(String pkgCd) {
		this.pkgCd = pkgCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param pckCdSeq
	 */
	public void setPckCdSeq(String pckCdSeq) {
		this.pckCdSeq = pckCdSeq;
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
	 * @param pkgTpCd
	 */
	public void setPkgTpCd(String pkgTpCd) {
		this.pkgTpCd = pkgTpCd;
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
	 * @param pckCd
	 */
	public void setPckCd(String pckCd) {
		this.pckCd = pckCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @param permChk
	 */
	public void setPermChk(String permChk) {
		this.permChk = permChk;
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
		setAndOrCd(JSPUtil.getParameter(request, prefix + "and_or_cd", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setPkgCd(JSPUtil.getParameter(request, prefix + "pkg_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setPckCdSeq(JSPUtil.getParameter(request, prefix + "pck_cd_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPkgTpCd(JSPUtil.getParameter(request, prefix + "pkg_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPckCd(JSPUtil.getParameter(request, prefix + "pck_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPermChk(JSPUtil.getParameter(request, prefix + "perm_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckReguPkgIbcCdVO[]
	 */
	public ScgPckReguPkgIbcCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckReguPkgIbcCdVO[]
	 */
	public ScgPckReguPkgIbcCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckReguPkgIbcCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] andOrCd = (JSPUtil.getParameter(request, prefix	+ "and_or_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] pkgCd = (JSPUtil.getParameter(request, prefix	+ "pkg_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] pckCdSeq = (JSPUtil.getParameter(request, prefix	+ "pck_cd_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pkgTpCd = (JSPUtil.getParameter(request, prefix	+ "pkg_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] pckCd = (JSPUtil.getParameter(request, prefix	+ "pck_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] permChk = (JSPUtil.getParameter(request, prefix	+ "perm_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckReguPkgIbcCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (andOrCd[i] != null)
					model.setAndOrCd(andOrCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (pkgCd[i] != null)
					model.setPkgCd(pkgCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (pckCdSeq[i] != null)
					model.setPckCdSeq(pckCdSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pkgTpCd[i] != null)
					model.setPkgTpCd(pkgTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pckCd[i] != null)
					model.setPckCd(pckCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (permChk[i] != null)
					model.setPermChk(permChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckReguPkgIbcCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckReguPkgIbcCdVO[]
	 */
	public ScgPckReguPkgIbcCdVO[] getScgPckReguPkgIbcCdVOs(){
		ScgPckReguPkgIbcCdVO[] vos = (ScgPckReguPkgIbcCdVO[])models.toArray(new ScgPckReguPkgIbcCdVO[models.size()]);
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
		this.andOrCd = this.andOrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCd = this.pkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCdSeq = this.pckCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgTpCd = this.pkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCd = this.pckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.permChk = this.permChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

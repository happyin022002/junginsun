/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DispoCdDetailVO.java
*@FileTitle : DispoCdDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.08 김민정
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DispoCdDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DispoCdDetailVO> models = new ArrayList<DispoCdDetailVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dspoDesc = null;
	/* Column Info */
	private String hold = null;
	/* Column Info */
	private String obNtcFlg = null;
	/* Column Info */
	private String cstmsDspoCd = null;
	/* Column Info */
	private String cstmsPairDspoCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String autoNtcFlg = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dspoTpCd = null;
	/* Column Info */
	private String cstmsDspoNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DispoCdDetailVO() {}

	public DispoCdDetailVO(String ibflag, String pagerows, String cntCd, String cstmsDspoCd, String cstmsDspoNm, String dspoTpCd, String dspoDesc, String cstmsPairDspoCd, String autoNtcFlg, String obNtcFlg, String diffRmk, String updDt, String updUsrId, String creUsrId, String hold) {
		this.updDt = updDt;
		this.dspoDesc = dspoDesc;
		this.hold = hold;
		this.obNtcFlg = obNtcFlg;
		this.cstmsDspoCd = cstmsDspoCd;
		this.cstmsPairDspoCd = cstmsPairDspoCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.autoNtcFlg = autoNtcFlg;
		this.cntCd = cntCd;
		this.dspoTpCd = dspoTpCd;
		this.cstmsDspoNm = cstmsDspoNm;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dspo_desc", getDspoDesc());
		this.hashColumns.put("hold", getHold());
		this.hashColumns.put("ob_ntc_flg", getObNtcFlg());
		this.hashColumns.put("cstms_dspo_cd", getCstmsDspoCd());
		this.hashColumns.put("cstms_pair_dspo_cd", getCstmsPairDspoCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("auto_ntc_flg", getAutoNtcFlg());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dspo_tp_cd", getDspoTpCd());
		this.hashColumns.put("cstms_dspo_nm", getCstmsDspoNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dspo_desc", "dspoDesc");
		this.hashFields.put("hold", "hold");
		this.hashFields.put("ob_ntc_flg", "obNtcFlg");
		this.hashFields.put("cstms_dspo_cd", "cstmsDspoCd");
		this.hashFields.put("cstms_pair_dspo_cd", "cstmsPairDspoCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("auto_ntc_flg", "autoNtcFlg");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dspo_tp_cd", "dspoTpCd");
		this.hashFields.put("cstms_dspo_nm", "cstmsDspoNm");
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
	 * @return dspoDesc
	 */
	public String getDspoDesc() {
		return this.dspoDesc;
	}

	/**
	 * Column Info
	 * @return hold
	 */
	public String getHold() {
		return this.hold;
	}

	/**
	 * Column Info
	 * @return obNtcFlg
	 */
	public String getObNtcFlg() {
		return this.obNtcFlg;
	}

	/**
	 * Column Info
	 * @return cstmsDspoCd
	 */
	public String getCstmsDspoCd() {
		return this.cstmsDspoCd;
	}

	/**
	 * Column Info
	 * @return cstmsPairDspoCd
	 */
	public String getCstmsPairDspoCd() {
		return this.cstmsPairDspoCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}

	/**
	 * Column Info
	 * @return autoNtcFlg
	 */
	public String getAutoNtcFlg() {
		return this.autoNtcFlg;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @return dspoTpCd
	 */
	public String getDspoTpCd() {
		return this.dspoTpCd;
	}

	/**
	 * Column Info
	 * @return cstmsDspoNm
	 */
	public String getCstmsDspoNm() {
		return this.cstmsDspoNm;
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
	 * @param dspoDesc
	 */
	public void setDspoDesc(String dspoDesc) {
		this.dspoDesc = dspoDesc;
	}

	/**
	 * Column Info
	 * @param hold
	 */
	public void setHold(String hold) {
		this.hold = hold;
	}

	/**
	 * Column Info
	 * @param obNtcFlg
	 */
	public void setObNtcFlg(String obNtcFlg) {
		this.obNtcFlg = obNtcFlg;
	}

	/**
	 * Column Info
	 * @param cstmsDspoCd
	 */
	public void setCstmsDspoCd(String cstmsDspoCd) {
		this.cstmsDspoCd = cstmsDspoCd;
	}

	/**
	 * Column Info
	 * @param cstmsPairDspoCd
	 */
	public void setCstmsPairDspoCd(String cstmsPairDspoCd) {
		this.cstmsPairDspoCd = cstmsPairDspoCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}

	/**
	 * Column Info
	 * @param autoNtcFlg
	 */
	public void setAutoNtcFlg(String autoNtcFlg) {
		this.autoNtcFlg = autoNtcFlg;
	}

	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * Column Info
	 * @param dspoTpCd
	 */
	public void setDspoTpCd(String dspoTpCd) {
		this.dspoTpCd = dspoTpCd;
	}

	/**
	 * Column Info
	 * @param cstmsDspoNm
	 */
	public void setCstmsDspoNm(String cstmsDspoNm) {
		this.cstmsDspoNm = cstmsDspoNm;
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
		setDspoDesc(JSPUtil.getParameter(request, prefix + "dspo_desc", ""));
		setHold(JSPUtil.getParameter(request, prefix + "hold", ""));
		setObNtcFlg(JSPUtil.getParameter(request, prefix + "ob_ntc_flg", ""));
		setCstmsDspoCd(JSPUtil.getParameter(request, prefix + "cstms_dspo_cd", ""));
		setCstmsPairDspoCd(JSPUtil.getParameter(request, prefix + "cstms_pair_dspo_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setAutoNtcFlg(JSPUtil.getParameter(request, prefix + "auto_ntc_flg", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setDspoTpCd(JSPUtil.getParameter(request, prefix + "dspo_tp_cd", ""));
		setCstmsDspoNm(JSPUtil.getParameter(request, prefix + "cstms_dspo_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DispoCdDetailVO[]
	 */
	public DispoCdDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DispoCdDetailVO[]
	 */
	public DispoCdDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DispoCdDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dspoDesc = (JSPUtil.getParameter(request, prefix	+ "dspo_desc", length));
			String[] hold = (JSPUtil.getParameter(request, prefix	+ "hold", length));
			String[] obNtcFlg = (JSPUtil.getParameter(request, prefix	+ "ob_ntc_flg", length));
			String[] cstmsDspoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_cd", length));
			String[] cstmsPairDspoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pair_dspo_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] autoNtcFlg = (JSPUtil.getParameter(request, prefix	+ "auto_ntc_flg", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dspoTpCd = (JSPUtil.getParameter(request, prefix	+ "dspo_tp_cd", length));
			String[] cstmsDspoNm = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new DispoCdDetailVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dspoDesc[i] != null)
					model.setDspoDesc(dspoDesc[i]);
				if (hold[i] != null)
					model.setHold(hold[i]);
				if (obNtcFlg[i] != null)
					model.setObNtcFlg(obNtcFlg[i]);
				if (cstmsDspoCd[i] != null)
					model.setCstmsDspoCd(cstmsDspoCd[i]);
				if (cstmsPairDspoCd[i] != null)
					model.setCstmsPairDspoCd(cstmsPairDspoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (autoNtcFlg[i] != null)
					model.setAutoNtcFlg(autoNtcFlg[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dspoTpCd[i] != null)
					model.setDspoTpCd(dspoTpCd[i]);
				if (cstmsDspoNm[i] != null)
					model.setCstmsDspoNm(cstmsDspoNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDispoCdDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DispoCdDetailVO[]
	 */
	public DispoCdDetailVO[] getDispoCdDetailVOs(){
		DispoCdDetailVO[] vos = (DispoCdDetailVO[])models.toArray(new DispoCdDetailVO[models.size()]);
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
		this.dspoDesc = this.dspoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hold = this.hold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obNtcFlg = this.obNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoCd = this.cstmsDspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPairDspoCd = this.cstmsPairDspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoNtcFlg = this.autoNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoTpCd = this.dspoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoNm = this.cstmsDspoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MnrReeferSparePartCodeVO.java
*@FileTitle : MnrReeferSparePartCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2010.05.27 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo;

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
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrReeferSparePartCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrReeferSparePartCodeVO> models = new ArrayList<MnrReeferSparePartCodeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sprPrtNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sprPrtSplTpCd = null;
	/* Column Info */
	private String sprPrtQty = null;
	/* Column Info */
	private String sprPrtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sprUtTpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sprPrtRmk = null;
	/* Column Info */
	private String sprPrtTpFlg1 = null;
	/* Column Info */
	private String sprPrtTpFlg2 = null;
	/* Column Info */
	private String sprPrtTpFlg3 = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MnrReeferSparePartCodeVO() {}

	public MnrReeferSparePartCodeVO(String ibflag, String pagerows, String updDt, String sprPrtNo, String creDt, String sprPrtQty, String sprPrtNm, String sprUtTpNm, String creUsrId, String sprPrtRmk, String sprPrtTpFlg1, String sprPrtTpFlg2, String sprPrtTpFlg3, String updUsrId, String sprPrtSplTpCd) {
		this.updDt = updDt;
		this.sprPrtNo = sprPrtNo;
		this.creDt = creDt;
		this.sprPrtSplTpCd = sprPrtSplTpCd;
		this.sprPrtQty = sprPrtQty;
		this.sprPrtNm = sprPrtNm;
		this.pagerows = pagerows;
		this.sprUtTpNm = sprUtTpNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.sprPrtRmk = sprPrtRmk;
		this.sprPrtTpFlg1 = sprPrtTpFlg1;
		this.sprPrtTpFlg2 = sprPrtTpFlg2;
		this.sprPrtTpFlg3 = sprPrtTpFlg3;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spr_prt_no", getSprPrtNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spr_prt_spl_tp_cd", getSprPrtSplTpCd());
		this.hashColumns.put("spr_prt_qty", getSprPrtQty());
		this.hashColumns.put("spr_prt_nm", getSprPrtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spr_ut_tp_nm", getSprUtTpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spr_prt_rmk", getSprPrtRmk());
		this.hashColumns.put("spr_prt_tp_flg1", getSprPrtTpFlg1());
		this.hashColumns.put("spr_prt_tp_flg2", getSprPrtTpFlg2());
		this.hashColumns.put("spr_prt_tp_flg3", getSprPrtTpFlg3());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spr_prt_spl_tp_cd", "sprPrtSplTpCd");
		this.hashFields.put("spr_prt_qty", "sprPrtQty");
		this.hashFields.put("spr_prt_nm", "sprPrtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spr_ut_tp_nm", "sprUtTpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spr_prt_rmk", "sprPrtRmk");
		this.hashFields.put("spr_prt_tp_flg1", "sprPrtTpFlg1");
		this.hashFields.put("spr_prt_tp_flg2", "sprPrtTpFlg2");
		this.hashFields.put("spr_prt_tp_flg3", "sprPrtTpFlg3");
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
	 * @return sprPrtNo
	 */
	public String getSprPrtNo() {
		return this.sprPrtNo;
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
	 * @return sprPrtSplTpCd
	 */
	public String getSprPrtSplTpCd() {
		return this.sprPrtSplTpCd;
	}
	
	/**
	 * Column Info
	 * @return sprPrtQty
	 */
	public String getSprPrtQty() {
		return this.sprPrtQty;
	}
	
	/**
	 * Column Info
	 * @return sprPrtNm
	 */
	public String getSprPrtNm() {
		return this.sprPrtNm;
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
	 * @return sprUtTpNm
	 */
	public String getSprUtTpNm() {
		return this.sprUtTpNm;
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
	 * @return sprPrtRmk
	 */
	public String getSprPrtRmk() {
		return this.sprPrtRmk;
	}
	
	/**
	 * Column Info
	 * @return sprPrtTpFlg1
	 */
	public String getSprPrtTpFlg1() {
		return this.sprPrtTpFlg1;
	}
	
	/**
	 * Column Info
	 * @return sprPrtTpFlg2
	 */
	public String getSprPrtTpFlg2() {
		return this.sprPrtTpFlg2;
	}
	
	/**
	 * Column Info
	 * @return sprPrtTpFlg3
	 */
	public String getSprPrtTpFlg3() {
		return this.sprPrtTpFlg3;
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
	 * @param sprPrtNo
	 */
	public void setSprPrtNo(String sprPrtNo) {
		this.sprPrtNo = sprPrtNo;
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
	 * @param sprPrtSplTpCd
	 */
	public void setSprPrtSplTpCd(String sprPrtSplTpCd) {
		this.sprPrtSplTpCd = sprPrtSplTpCd;
	}
	
	/**
	 * Column Info
	 * @param sprPrtQty
	 */
	public void setSprPrtQty(String sprPrtQty) {
		this.sprPrtQty = sprPrtQty;
	}
	
	/**
	 * Column Info
	 * @param sprPrtNm
	 */
	public void setSprPrtNm(String sprPrtNm) {
		this.sprPrtNm = sprPrtNm;
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
	 * @param sprUtTpNm
	 */
	public void setSprUtTpNm(String sprUtTpNm) {
		this.sprUtTpNm = sprUtTpNm;
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
	 * @param sprPrtRmk
	 */
	public void setSprPrtRmk(String sprPrtRmk) {
		this.sprPrtRmk = sprPrtRmk;
	}
	
	/**
	 * Column Info
	 * @param sprPrtTpFlg1
	 */
	public void setSprPrtTpFlg1(String sprPrtTpFlg1) {
		this.sprPrtTpFlg1 = sprPrtTpFlg1;
	}
	
	/**
	 * Column Info
	 * @param sprPrtTpFlg2
	 */
	public void setSprPrtTpFlg2(String sprPrtTpFlg2) {
		this.sprPrtTpFlg2 = sprPrtTpFlg2;
	}
	
	/**
	 * Column Info
	 * @param sprPrtTpFlg3
	 */
	public void setSprPrtTpFlg3(String sprPrtTpFlg3) {
		this.sprPrtTpFlg3 = sprPrtTpFlg3;
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
		setSprPrtNo(JSPUtil.getParameter(request, prefix + "spr_prt_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSprPrtSplTpCd(JSPUtil.getParameter(request, prefix + "spr_prt_spl_tp_cd", ""));
		setSprPrtQty(JSPUtil.getParameter(request, prefix + "spr_prt_qty", ""));
		setSprPrtNm(JSPUtil.getParameter(request, prefix + "spr_prt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSprUtTpNm(JSPUtil.getParameter(request, prefix + "spr_ut_tp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSprPrtRmk(JSPUtil.getParameter(request, prefix + "spr_prt_rmk", ""));
		setSprPrtTpFlg1(JSPUtil.getParameter(request, prefix + "spr_prt_tp_flg1", ""));
		setSprPrtTpFlg2(JSPUtil.getParameter(request, prefix + "spr_prt_tp_flg2", ""));
		setSprPrtTpFlg3(JSPUtil.getParameter(request, prefix + "spr_prt_tp_flg3", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrReeferSparePartCodeVO[]
	 */
	public MnrReeferSparePartCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrReeferSparePartCodeVO[]
	 */
	public MnrReeferSparePartCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrReeferSparePartCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sprPrtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sprPrtSplTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_tp_cd", length));
			String[] sprPrtQty = (JSPUtil.getParameter(request, prefix	+ "spr_prt_qty", length));
			String[] sprPrtNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sprUtTpNm = (JSPUtil.getParameter(request, prefix	+ "spr_ut_tp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sprPrtRmk = (JSPUtil.getParameter(request, prefix	+ "spr_prt_rmk", length));
			String[] sprPrtTpFlg1 = (JSPUtil.getParameter(request, prefix	+ "spr_prt_tp_flg1", length));
			String[] sprPrtTpFlg2 = (JSPUtil.getParameter(request, prefix	+ "spr_prt_tp_flg2", length));
			String[] sprPrtTpFlg3 = (JSPUtil.getParameter(request, prefix	+ "spr_prt_tp_flg3", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrReeferSparePartCodeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sprPrtNo[i] != null)
					model.setSprPrtNo(sprPrtNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sprPrtSplTpCd[i] != null)
					model.setSprPrtSplTpCd(sprPrtSplTpCd[i]);
				if (sprPrtQty[i] != null)
					model.setSprPrtQty(sprPrtQty[i]);
				if (sprPrtNm[i] != null)
					model.setSprPrtNm(sprPrtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sprUtTpNm[i] != null)
					model.setSprUtTpNm(sprUtTpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sprPrtRmk[i] != null)
					model.setSprPrtRmk(sprPrtRmk[i]);
				if (sprPrtTpFlg1[i] != null)
					model.setSprPrtTpFlg1(sprPrtTpFlg1[i]);
				if (sprPrtTpFlg2[i] != null)
					model.setSprPrtTpFlg2(sprPrtTpFlg2[i]);
				if (sprPrtTpFlg3[i] != null)
					model.setSprPrtTpFlg3(sprPrtTpFlg3[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrReeferSparePartCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrReeferSparePartCodeVO[]
	 */
	public MnrReeferSparePartCodeVO[] getMnrReeferSparePartCodeVOs(){
		MnrReeferSparePartCodeVO[] vos = (MnrReeferSparePartCodeVO[])models.toArray(new MnrReeferSparePartCodeVO[models.size()]);
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
		this.sprPrtNo = this.sprPrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplTpCd = this.sprPrtSplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtQty = this.sprPrtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNm = this.sprPrtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprUtTpNm = this.sprUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtRmk = this.sprPrtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtTpFlg1 = this.sprPrtTpFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtTpFlg2 = this.sprPrtTpFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtTpFlg3 = this.sprPrtTpFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

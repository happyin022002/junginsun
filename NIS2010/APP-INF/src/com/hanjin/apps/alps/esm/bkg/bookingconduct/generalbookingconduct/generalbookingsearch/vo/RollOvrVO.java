/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RollOvrVO.java
*@FileTitle : RollOvrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.16
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.01.16 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RollOvrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RollOvrVO> models = new ArrayList<RollOvrVO>();
	
	/* Column Info */
	private String rollOvrRsnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String predate = null;
	/* Column Info */
	private String newdate = null;
	/* Column Info */
	private String rollOvrSeq = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RollOvrVO() {}

	public RollOvrVO(String ibflag, String pagerows, String newdate, String predate, String rollOvrRsnCd, String updUsrId, String evntDt, String diffRmk, String updUsrNm, String rollOvrSeq) {
		this.rollOvrRsnCd = rollOvrRsnCd;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.predate = predate;
		this.newdate = newdate;
		this.rollOvrSeq = rollOvrSeq;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
		this.evntDt = evntDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("roll_ovr_rsn_cd", getRollOvrRsnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("predate", getPredate());
		this.hashColumns.put("newdate", getNewdate());
		this.hashColumns.put("roll_ovr_seq", getRollOvrSeq());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("roll_ovr_rsn_cd", "rollOvrRsnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("predate", "predate");
		this.hashFields.put("newdate", "newdate");
		this.hashFields.put("roll_ovr_seq", "rollOvrSeq");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rollOvrRsnCd
	 */
	public String getRollOvrRsnCd() {
		return this.rollOvrRsnCd;
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
	 * @return predate
	 */
	public String getPredate() {
		return this.predate;
	}
	
	/**
	 * Column Info
	 * @return newdate
	 */
	public String getNewdate() {
		return this.newdate;
	}
	
	/**
	 * Column Info
	 * @return rollOvrSeq
	 */
	public String getRollOvrSeq() {
		return this.rollOvrSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param rollOvrRsnCd
	 */
	public void setRollOvrRsnCd(String rollOvrRsnCd) {
		this.rollOvrRsnCd = rollOvrRsnCd;
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
	 * @param predate
	 */
	public void setPredate(String predate) {
		this.predate = predate;
	}
	
	/**
	 * Column Info
	 * @param newdate
	 */
	public void setNewdate(String newdate) {
		this.newdate = newdate;
	}
	
	/**
	 * Column Info
	 * @param rollOvrSeq
	 */
	public void setRollOvrSeq(String rollOvrSeq) {
		this.rollOvrSeq = rollOvrSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRollOvrRsnCd(JSPUtil.getParameter(request, prefix + "roll_ovr_rsn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setPredate(JSPUtil.getParameter(request, prefix + "predate", ""));
		setNewdate(JSPUtil.getParameter(request, prefix + "newdate", ""));
		setRollOvrSeq(JSPUtil.getParameter(request, prefix + "roll_ovr_seq", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RollOvrVO[]
	 */
	public RollOvrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RollOvrVO[]
	 */
	public RollOvrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RollOvrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rollOvrRsnCd = (JSPUtil.getParameter(request, prefix	+ "roll_ovr_rsn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] predate = (JSPUtil.getParameter(request, prefix	+ "predate", length));
			String[] newdate = (JSPUtil.getParameter(request, prefix	+ "newdate", length));
			String[] rollOvrSeq = (JSPUtil.getParameter(request, prefix	+ "roll_ovr_seq", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RollOvrVO();
				if (rollOvrRsnCd[i] != null)
					model.setRollOvrRsnCd(rollOvrRsnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (predate[i] != null)
					model.setPredate(predate[i]);
				if (newdate[i] != null)
					model.setNewdate(newdate[i]);
				if (rollOvrSeq[i] != null)
					model.setRollOvrSeq(rollOvrSeq[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRollOvrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RollOvrVO[]
	 */
	public RollOvrVO[] getRollOvrVOs(){
		RollOvrVO[] vos = (RollOvrVO[])models.toArray(new RollOvrVO[models.size()]);
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
		this.rollOvrRsnCd = this.rollOvrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.predate = this.predate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newdate = this.newdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvrSeq = this.rollOvrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

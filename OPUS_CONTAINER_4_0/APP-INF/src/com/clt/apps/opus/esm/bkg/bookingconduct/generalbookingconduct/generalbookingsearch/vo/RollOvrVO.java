/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RollOvrVO.java
*@FileTitle : RollOvrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.14 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
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
	private String evntDt = null;
	/* Column Info */
	private String predate = null;
	/* Column Info */
	private String newdate = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rollOvrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RollOvrVO() {}

	public RollOvrVO(String ibflag, String pagerows, String newdate, String predate, String rollOvrRsnCd, String updUsrId, String evntDt, String diffRmk, String updUsrNm, String rollOvrSeq) {
		this.rollOvrRsnCd = rollOvrRsnCd;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.evntDt = evntDt;
		this.predate = predate;
		this.newdate = newdate;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.rollOvrSeq = rollOvrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("roll_ovr_rsn_cd", getRollOvrRsnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("predate", getPredate());
		this.hashColumns.put("newdate", getNewdate());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("roll_ovr_seq", getRollOvrSeq());
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
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("predate", "predate");
		this.hashFields.put("newdate", "newdate");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("roll_ovr_seq", "rollOvrSeq");
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * @return the rollOvrSeq
	 */
	public String getRollOvrSeq() {
		return rollOvrSeq;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @param rollOvrSeq the rollOvrSeq to set
	 */
	public void setRollOvrSeq(String rollOvrSeq) {
		this.rollOvrSeq = rollOvrSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRollOvrRsnCd(JSPUtil.getParameter(request, "roll_ovr_rsn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setPredate(JSPUtil.getParameter(request, "predate", ""));
		setNewdate(JSPUtil.getParameter(request, "newdate", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRollOvrSeq(JSPUtil.getParameter(request, "roll_ovr_seq", ""));
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
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] predate = (JSPUtil.getParameter(request, prefix	+ "predate", length));
			String[] newdate = (JSPUtil.getParameter(request, prefix	+ "newdate", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rollOvrSeq = (JSPUtil.getParameter(request, prefix	+ "roll_ovr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RollOvrVO();
				if (rollOvrRsnCd[i] != null)
					model.setRollOvrRsnCd(rollOvrRsnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (predate[i] != null)
					model.setPredate(predate[i]);
				if (newdate[i] != null)
					model.setNewdate(newdate[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rollOvrSeq[i] != null)
					model.setRollOvrSeq(rollOvrSeq[i]);

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
		this.rollOvrRsnCd = this.rollOvrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.predate = this.predate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newdate = this.newdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvrSeq = this.rollOvrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

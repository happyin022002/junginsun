/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoaSltChtrInfoVO.java
*@FileTitle : CoaSltChtrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoaSltChtrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaSltChtrInfoVO> models = new ArrayList<CoaSltChtrInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String expnSubChtrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creSlctFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String incmCrsChtrCd = null;
	/* Column Info */
	private String expnBzcChtrCd = null;
	/* Column Info */
	private String expnCrsChtrCd = null;
	/* Column Info */
	private String incmSubLseCd = null;
	/* Column Info */
	private String sltTpCd = null;
	/* Column Info */
	private String opCreStsCd = null;
	/* Column Info */
	private String incmBzcChtrCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoaSltChtrInfoVO() {}

	public CoaSltChtrInfoVO(String ibflag, String pagerows, String sltTpCd, String vopCd, String incmBzcChtrCd, String incmSubLseCd, String incmCrsChtrCd, String expnBzcChtrCd, String expnSubChtrCd, String expnCrsChtrCd, String opCreStsCd, String creSlctFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.expnSubChtrCd = expnSubChtrCd;
		this.creDt = creDt;
		this.vopCd = vopCd;
		this.pagerows = pagerows;
		this.creSlctFlg = creSlctFlg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.incmCrsChtrCd = incmCrsChtrCd;
		this.expnBzcChtrCd = expnBzcChtrCd;
		this.expnCrsChtrCd = expnCrsChtrCd;
		this.incmSubLseCd = incmSubLseCd;
		this.sltTpCd = sltTpCd;
		this.opCreStsCd = opCreStsCd;
		this.incmBzcChtrCd = incmBzcChtrCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("expn_sub_chtr_cd", getExpnSubChtrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_slct_flg", getCreSlctFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("incm_crs_chtr_cd", getIncmCrsChtrCd());
		this.hashColumns.put("expn_bzc_chtr_cd", getExpnBzcChtrCd());
		this.hashColumns.put("expn_crs_chtr_cd", getExpnCrsChtrCd());
		this.hashColumns.put("incm_sub_lse_cd", getIncmSubLseCd());
		this.hashColumns.put("slt_tp_cd", getSltTpCd());
		this.hashColumns.put("op_cre_sts_cd", getOpCreStsCd());
		this.hashColumns.put("incm_bzc_chtr_cd", getIncmBzcChtrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("expn_sub_chtr_cd", "expnSubChtrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_slct_flg", "creSlctFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("incm_crs_chtr_cd", "incmCrsChtrCd");
		this.hashFields.put("expn_bzc_chtr_cd", "expnBzcChtrCd");
		this.hashFields.put("expn_crs_chtr_cd", "expnCrsChtrCd");
		this.hashFields.put("incm_sub_lse_cd", "incmSubLseCd");
		this.hashFields.put("slt_tp_cd", "sltTpCd");
		this.hashFields.put("op_cre_sts_cd", "opCreStsCd");
		this.hashFields.put("incm_bzc_chtr_cd", "incmBzcChtrCd");
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
	 * @return expnSubChtrCd
	 */
	public String getExpnSubChtrCd() {
		return this.expnSubChtrCd;
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
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return creSlctFlg
	 */
	public String getCreSlctFlg() {
		return this.creSlctFlg;
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
	 * @return incmCrsChtrCd
	 */
	public String getIncmCrsChtrCd() {
		return this.incmCrsChtrCd;
	}
	
	/**
	 * Column Info
	 * @return expnBzcChtrCd
	 */
	public String getExpnBzcChtrCd() {
		return this.expnBzcChtrCd;
	}
	
	/**
	 * Column Info
	 * @return expnCrsChtrCd
	 */
	public String getExpnCrsChtrCd() {
		return this.expnCrsChtrCd;
	}
	
	/**
	 * Column Info
	 * @return incmSubLseCd
	 */
	public String getIncmSubLseCd() {
		return this.incmSubLseCd;
	}
	
	/**
	 * Column Info
	 * @return sltTpCd
	 */
	public String getSltTpCd() {
		return this.sltTpCd;
	}
	
	/**
	 * Column Info
	 * @return opCreStsCd
	 */
	public String getOpCreStsCd() {
		return this.opCreStsCd;
	}
	
	/**
	 * Column Info
	 * @return incmBzcChtrCd
	 */
	public String getIncmBzcChtrCd() {
		return this.incmBzcChtrCd;
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
	 * @param expnSubChtrCd
	 */
	public void setExpnSubChtrCd(String expnSubChtrCd) {
		this.expnSubChtrCd = expnSubChtrCd;
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
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param creSlctFlg
	 */
	public void setCreSlctFlg(String creSlctFlg) {
		this.creSlctFlg = creSlctFlg;
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
	 * @param incmCrsChtrCd
	 */
	public void setIncmCrsChtrCd(String incmCrsChtrCd) {
		this.incmCrsChtrCd = incmCrsChtrCd;
	}
	
	/**
	 * Column Info
	 * @param expnBzcChtrCd
	 */
	public void setExpnBzcChtrCd(String expnBzcChtrCd) {
		this.expnBzcChtrCd = expnBzcChtrCd;
	}
	
	/**
	 * Column Info
	 * @param expnCrsChtrCd
	 */
	public void setExpnCrsChtrCd(String expnCrsChtrCd) {
		this.expnCrsChtrCd = expnCrsChtrCd;
	}
	
	/**
	 * Column Info
	 * @param incmSubLseCd
	 */
	public void setIncmSubLseCd(String incmSubLseCd) {
		this.incmSubLseCd = incmSubLseCd;
	}
	
	/**
	 * Column Info
	 * @param sltTpCd
	 */
	public void setSltTpCd(String sltTpCd) {
		this.sltTpCd = sltTpCd;
	}
	
	/**
	 * Column Info
	 * @param opCreStsCd
	 */
	public void setOpCreStsCd(String opCreStsCd) {
		this.opCreStsCd = opCreStsCd;
	}
	
	/**
	 * Column Info
	 * @param incmBzcChtrCd
	 */
	public void setIncmBzcChtrCd(String incmBzcChtrCd) {
		this.incmBzcChtrCd = incmBzcChtrCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setExpnSubChtrCd(JSPUtil.getParameter(request, "expn_sub_chtr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreSlctFlg(JSPUtil.getParameter(request, "cre_slct_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIncmCrsChtrCd(JSPUtil.getParameter(request, "incm_crs_chtr_cd", ""));
		setExpnBzcChtrCd(JSPUtil.getParameter(request, "expn_bzc_chtr_cd", ""));
		setExpnCrsChtrCd(JSPUtil.getParameter(request, "expn_crs_chtr_cd", ""));
		setIncmSubLseCd(JSPUtil.getParameter(request, "incm_sub_lse_cd", ""));
		setSltTpCd(JSPUtil.getParameter(request, "slt_tp_cd", ""));
		setOpCreStsCd(JSPUtil.getParameter(request, "op_cre_sts_cd", ""));
		setIncmBzcChtrCd(JSPUtil.getParameter(request, "incm_bzc_chtr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaSltChtrInfoVO[]
	 */
	public CoaSltChtrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaSltChtrInfoVO[]
	 */
	public CoaSltChtrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaSltChtrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] expnSubChtrCd = (JSPUtil.getParameter(request, prefix	+ "expn_sub_chtr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creSlctFlg = (JSPUtil.getParameter(request, prefix	+ "cre_slct_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] incmCrsChtrCd = (JSPUtil.getParameter(request, prefix	+ "incm_crs_chtr_cd", length));
			String[] expnBzcChtrCd = (JSPUtil.getParameter(request, prefix	+ "expn_bzc_chtr_cd", length));
			String[] expnCrsChtrCd = (JSPUtil.getParameter(request, prefix	+ "expn_crs_chtr_cd", length));
			String[] incmSubLseCd = (JSPUtil.getParameter(request, prefix	+ "incm_sub_lse_cd", length));
			String[] sltTpCd = (JSPUtil.getParameter(request, prefix	+ "slt_tp_cd", length));
			String[] opCreStsCd = (JSPUtil.getParameter(request, prefix	+ "op_cre_sts_cd", length));
			String[] incmBzcChtrCd = (JSPUtil.getParameter(request, prefix	+ "incm_bzc_chtr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoaSltChtrInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (expnSubChtrCd[i] != null)
					model.setExpnSubChtrCd(expnSubChtrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creSlctFlg[i] != null)
					model.setCreSlctFlg(creSlctFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (incmCrsChtrCd[i] != null)
					model.setIncmCrsChtrCd(incmCrsChtrCd[i]);
				if (expnBzcChtrCd[i] != null)
					model.setExpnBzcChtrCd(expnBzcChtrCd[i]);
				if (expnCrsChtrCd[i] != null)
					model.setExpnCrsChtrCd(expnCrsChtrCd[i]);
				if (incmSubLseCd[i] != null)
					model.setIncmSubLseCd(incmSubLseCd[i]);
				if (sltTpCd[i] != null)
					model.setSltTpCd(sltTpCd[i]);
				if (opCreStsCd[i] != null)
					model.setOpCreStsCd(opCreStsCd[i]);
				if (incmBzcChtrCd[i] != null)
					model.setIncmBzcChtrCd(incmBzcChtrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaSltChtrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaSltChtrInfoVO[]
	 */
	public CoaSltChtrInfoVO[] getCoaSltChtrInfoVOs(){
		CoaSltChtrInfoVO[] vos = (CoaSltChtrInfoVO[])models.toArray(new CoaSltChtrInfoVO[models.size()]);
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
		this.expnSubChtrCd = this.expnSubChtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creSlctFlg = this.creSlctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incmCrsChtrCd = this.incmCrsChtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnBzcChtrCd = this.expnBzcChtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnCrsChtrCd = this.expnCrsChtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incmSubLseCd = this.incmSubLseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltTpCd = this.sltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCreStsCd = this.opCreStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incmBzcChtrCd = this.incmBzcChtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

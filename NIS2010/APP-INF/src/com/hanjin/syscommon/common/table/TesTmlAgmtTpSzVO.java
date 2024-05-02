/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TesTmlAgmtTpSzVO.java
*@FileTitle : TesTmlAgmtTpSzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.25 yOng hO lEE 
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
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesTmlAgmtTpSzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesTmlAgmtTpSzVO> models = new ArrayList<TesTmlAgmtTpSzVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tmlAgmtOfcCtyCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlAgmtVerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtRt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String tmlAgmtSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tmlAgmtDtlSeq = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String agmtDys = null;
	/* Column Info */
	private String cntrAplyTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesTmlAgmtTpSzVO() {}

	public TesTmlAgmtTpSzVO(String ibflag, String pagerows, String tmlAgmtOfcCtyCd, String tmlAgmtSeq, String tmlAgmtVerNo, String tmlAgmtDtlSeq, String cntrTpszCd, String cntrAplyTpCd, String agmtRt, String agmtDys, String creUsrId, String creDt, String updUsrId, String updDt, String loclCreDt, String loclUpdDt) {
		this.updDt = updDt;
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
		this.loclCreDt = loclCreDt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.tmlAgmtVerNo = tmlAgmtVerNo;
		this.ibflag = ibflag;
		this.agmtRt = agmtRt;
		this.creUsrId = creUsrId;
		this.tmlAgmtSeq = tmlAgmtSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.tmlAgmtDtlSeq = tmlAgmtDtlSeq;
		this.loclUpdDt = loclUpdDt;
		this.agmtDys = agmtDys;
		this.cntrAplyTpCd = cntrAplyTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_agmt_ver_no", getTmlAgmtVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_rt", getAgmtRt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tml_agmt_dtl_seq", getTmlAgmtDtlSeq());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("agmt_dys", getAgmtDys());
		this.hashColumns.put("cntr_aply_tp_cd", getCntrAplyTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_agmt_ver_no", "tmlAgmtVerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_rt", "agmtRt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tml_agmt_dtl_seq", "tmlAgmtDtlSeq");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("agmt_dys", "agmtDys");
		this.hashFields.put("cntr_aply_tp_cd", "cntrAplyTpCd");
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
	 * @return tmlAgmtOfcCtyCd
	 */
	public String getTmlAgmtOfcCtyCd() {
		return this.tmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
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
	 * Column Info
	 * @return tmlAgmtVerNo
	 */
	public String getTmlAgmtVerNo() {
		return this.tmlAgmtVerNo;
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
	 * @return agmtRt
	 */
	public String getAgmtRt() {
		return this.agmtRt;
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
	 * @return tmlAgmtSeq
	 */
	public String getTmlAgmtSeq() {
		return this.tmlAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtDtlSeq
	 */
	public String getTmlAgmtDtlSeq() {
		return this.tmlAgmtDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return agmtDys
	 */
	public String getAgmtDys() {
		return this.agmtDys;
	}
	
	/**
	 * Column Info
	 * @return cntrAplyTpCd
	 */
	public String getCntrAplyTpCd() {
		return this.cntrAplyTpCd;
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
	 * @param tmlAgmtOfcCtyCd
	 */
	public void setTmlAgmtOfcCtyCd(String tmlAgmtOfcCtyCd) {
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
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
	 * Column Info
	 * @param tmlAgmtVerNo
	 */
	public void setTmlAgmtVerNo(String tmlAgmtVerNo) {
		this.tmlAgmtVerNo = tmlAgmtVerNo;
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
	 * @param agmtRt
	 */
	public void setAgmtRt(String agmtRt) {
		this.agmtRt = agmtRt;
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
	 * @param tmlAgmtSeq
	 */
	public void setTmlAgmtSeq(String tmlAgmtSeq) {
		this.tmlAgmtSeq = tmlAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtDtlSeq
	 */
	public void setTmlAgmtDtlSeq(String tmlAgmtDtlSeq) {
		this.tmlAgmtDtlSeq = tmlAgmtDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param agmtDys
	 */
	public void setAgmtDys(String agmtDys) {
		this.agmtDys = agmtDys;
	}
	
	/**
	 * Column Info
	 * @param cntrAplyTpCd
	 */
	public void setCntrAplyTpCd(String cntrAplyTpCd) {
		this.cntrAplyTpCd = cntrAplyTpCd;
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
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, "tml_agmt_ofc_cty_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, "locl_cre_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTmlAgmtVerNo(JSPUtil.getParameter(request, "tml_agmt_ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtRt(JSPUtil.getParameter(request, "agmt_rt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request, "tml_agmt_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setTmlAgmtDtlSeq(JSPUtil.getParameter(request, "tml_agmt_dtl_seq", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, "locl_upd_dt", ""));
		setAgmtDys(JSPUtil.getParameter(request, "agmt_dys", ""));
		setCntrAplyTpCd(JSPUtil.getParameter(request, "cntr_aply_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesTmlAgmtTpSzVO[]
	 */
	public TesTmlAgmtTpSzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesTmlAgmtTpSzVO[]
	 */
	public TesTmlAgmtTpSzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesTmlAgmtTpSzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_cty_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlAgmtVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtRt = (JSPUtil.getParameter(request, prefix	+ "agmt_rt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tmlAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tmlAgmtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_dtl_seq", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] agmtDys = (JSPUtil.getParameter(request, prefix	+ "agmt_dys", length));
			String[] cntrAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_aply_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesTmlAgmtTpSzVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tmlAgmtOfcCtyCd[i] != null)
					model.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlAgmtVerNo[i] != null)
					model.setTmlAgmtVerNo(tmlAgmtVerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtRt[i] != null)
					model.setAgmtRt(agmtRt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (tmlAgmtSeq[i] != null)
					model.setTmlAgmtSeq(tmlAgmtSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tmlAgmtDtlSeq[i] != null)
					model.setTmlAgmtDtlSeq(tmlAgmtDtlSeq[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (agmtDys[i] != null)
					model.setAgmtDys(agmtDys[i]);
				if (cntrAplyTpCd[i] != null)
					model.setCntrAplyTpCd(cntrAplyTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesTmlAgmtTpSzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesTmlAgmtTpSzVO[]
	 */
	public TesTmlAgmtTpSzVO[] getTesTmlAgmtTpSzVOs(){
		TesTmlAgmtTpSzVO[] vos = (TesTmlAgmtTpSzVO[])models.toArray(new TesTmlAgmtTpSzVO[models.size()]);
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
		this.tmlAgmtOfcCtyCd = this.tmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVerNo = this.tmlAgmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRt = this.agmtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq = this.tmlAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtDtlSeq = this.tmlAgmtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDys = this.agmtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAplyTpCd = this.cntrAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

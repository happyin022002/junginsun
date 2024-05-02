/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskPortTrspCondVO.java
*@FileTitle : VskPortTrspCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.11 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskPortTrspCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPortTrspCondVO> models = new ArrayList<VskPortTrspCondVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lmtHgt = null;
	/* Column Info */
	private String lmtOvrHgt = null;
	/* Column Info */
	private String trspRmk = null;
	/* Column Info */
	private String lmtWdt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lmt20ftWgt = null;
	/* Column Info */
	private String lmtOvrWdt = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String lmtLen = null;
	/* Column Info */
	private String lmt40ftWgt = null;
	/* Column Info */
	private String lmtAxlWgt = null;
	/* Column Info */
	private String tempLocCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lmtOvrLen = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskPortTrspCondVO() {}

	public VskPortTrspCondVO(String ibflag, String pagerows, String locCd, String trspModCd, String lmt20ftWgt, String lmt40ftWgt, String lmtAxlWgt, String lmtLen, String lmtWdt, String lmtHgt, String lmtOvrLen, String lmtOvrWdt, String lmtOvrHgt, String trspRmk, String creUsrId, String creDt, String updUsrId, String updDt, String tempLocCd) {
		this.updDt = updDt;
		this.lmtHgt = lmtHgt;
		this.lmtOvrHgt = lmtOvrHgt;
		this.trspRmk = trspRmk;
		this.lmtWdt = lmtWdt;
		this.creDt = creDt;
		this.lmt20ftWgt = lmt20ftWgt;
		this.lmtOvrWdt = lmtOvrWdt;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.lmtLen = lmtLen;
		this.lmt40ftWgt = lmt40ftWgt;
		this.lmtAxlWgt = lmtAxlWgt;
		this.tempLocCd = tempLocCd;
		this.updUsrId = updUsrId;
		this.lmtOvrLen = lmtOvrLen;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lmt_hgt", getLmtHgt());
		this.hashColumns.put("lmt_ovr_hgt", getLmtOvrHgt());
		this.hashColumns.put("trsp_rmk", getTrspRmk());
		this.hashColumns.put("lmt_wdt", getLmtWdt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lmt_20ft_wgt", getLmt20ftWgt());
		this.hashColumns.put("lmt_ovr_wdt", getLmtOvrWdt());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("lmt_len", getLmtLen());
		this.hashColumns.put("lmt_40ft_wgt", getLmt40ftWgt());
		this.hashColumns.put("lmt_axl_wgt", getLmtAxlWgt());
		this.hashColumns.put("temp_loc_cd", getTempLocCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lmt_ovr_len", getLmtOvrLen());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lmt_hgt", "lmtHgt");
		this.hashFields.put("lmt_ovr_hgt", "lmtOvrHgt");
		this.hashFields.put("trsp_rmk", "trspRmk");
		this.hashFields.put("lmt_wdt", "lmtWdt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lmt_20ft_wgt", "lmt20ftWgt");
		this.hashFields.put("lmt_ovr_wdt", "lmtOvrWdt");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("lmt_len", "lmtLen");
		this.hashFields.put("lmt_40ft_wgt", "lmt40ftWgt");
		this.hashFields.put("lmt_axl_wgt", "lmtAxlWgt");
		this.hashFields.put("temp_loc_cd", "tempLocCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lmt_ovr_len", "lmtOvrLen");
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
	 * @return lmtHgt
	 */
	public String getLmtHgt() {
		return this.lmtHgt;
	}
	
	/**
	 * Column Info
	 * @return lmtOvrHgt
	 */
	public String getLmtOvrHgt() {
		return this.lmtOvrHgt;
	}
	
	/**
	 * Column Info
	 * @return trspRmk
	 */
	public String getTrspRmk() {
		return this.trspRmk;
	}
	
	/**
	 * Column Info
	 * @return lmtWdt
	 */
	public String getLmtWdt() {
		return this.lmtWdt;
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
	 * @return lmt20ftWgt
	 */
	public String getLmt20ftWgt() {
		return this.lmt20ftWgt;
	}
	
	/**
	 * Column Info
	 * @return lmtOvrWdt
	 */
	public String getLmtOvrWdt() {
		return this.lmtOvrWdt;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return lmtLen
	 */
	public String getLmtLen() {
		return this.lmtLen;
	}
	
	/**
	 * Column Info
	 * @return lmt40ftWgt
	 */
	public String getLmt40ftWgt() {
		return this.lmt40ftWgt;
	}
	
	/**
	 * Column Info
	 * @return lmtAxlWgt
	 */
	public String getLmtAxlWgt() {
		return this.lmtAxlWgt;
	}
	
	/**
	 * Column Info
	 * @return tempLocCd
	 */
	public String getTempLocCd() {
		return this.tempLocCd;
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
	 * @return lmtOvrLen
	 */
	public String getLmtOvrLen() {
		return this.lmtOvrLen;
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
	 * @param lmtHgt
	 */
	public void setLmtHgt(String lmtHgt) {
		this.lmtHgt = lmtHgt;
	}
	
	/**
	 * Column Info
	 * @param lmtOvrHgt
	 */
	public void setLmtOvrHgt(String lmtOvrHgt) {
		this.lmtOvrHgt = lmtOvrHgt;
	}
	
	/**
	 * Column Info
	 * @param trspRmk
	 */
	public void setTrspRmk(String trspRmk) {
		this.trspRmk = trspRmk;
	}
	
	/**
	 * Column Info
	 * @param lmtWdt
	 */
	public void setLmtWdt(String lmtWdt) {
		this.lmtWdt = lmtWdt;
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
	 * @param lmt20ftWgt
	 */
	public void setLmt20ftWgt(String lmt20ftWgt) {
		this.lmt20ftWgt = lmt20ftWgt;
	}
	
	/**
	 * Column Info
	 * @param lmtOvrWdt
	 */
	public void setLmtOvrWdt(String lmtOvrWdt) {
		this.lmtOvrWdt = lmtOvrWdt;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param lmtLen
	 */
	public void setLmtLen(String lmtLen) {
		this.lmtLen = lmtLen;
	}
	
	/**
	 * Column Info
	 * @param lmt40ftWgt
	 */
	public void setLmt40ftWgt(String lmt40ftWgt) {
		this.lmt40ftWgt = lmt40ftWgt;
	}
	
	/**
	 * Column Info
	 * @param lmtAxlWgt
	 */
	public void setLmtAxlWgt(String lmtAxlWgt) {
		this.lmtAxlWgt = lmtAxlWgt;
	}
	
	/**
	 * Column Info
	 * @param tempLocCd
	 */
	public void setTempLocCd(String tempLocCd) {
		this.tempLocCd = tempLocCd;
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
	 * @param lmtOvrLen
	 */
	public void setLmtOvrLen(String lmtOvrLen) {
		this.lmtOvrLen = lmtOvrLen;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLmtHgt(JSPUtil.getParameter(request, "lmt_hgt", ""));
		setLmtOvrHgt(JSPUtil.getParameter(request, "lmt_ovr_hgt", ""));
		setTrspRmk(JSPUtil.getParameter(request, "trsp_rmk", ""));
		setLmtWdt(JSPUtil.getParameter(request, "lmt_wdt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setLmt20ftWgt(JSPUtil.getParameter(request, "lmt_20ft_wgt", ""));
		setLmtOvrWdt(JSPUtil.getParameter(request, "lmt_ovr_wdt", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setLmtLen(JSPUtil.getParameter(request, "lmt_len", ""));
		setLmt40ftWgt(JSPUtil.getParameter(request, "lmt_40ft_wgt", ""));
		setLmtAxlWgt(JSPUtil.getParameter(request, "lmt_axl_wgt", ""));
		setTempLocCd(JSPUtil.getParameter(request, "temp_loc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLmtOvrLen(JSPUtil.getParameter(request, "lmt_ovr_len", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPortTrspCondVO[]
	 */
	public VskPortTrspCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPortTrspCondVO[]
	 */
	public VskPortTrspCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPortTrspCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] lmtHgt = (JSPUtil.getParameter(request, prefix	+ "lmt_hgt".trim(), length));
			String[] lmtOvrHgt = (JSPUtil.getParameter(request, prefix	+ "lmt_ovr_hgt".trim(), length));
			String[] trspRmk = (JSPUtil.getParameter(request, prefix	+ "trsp_rmk".trim(), length));
			String[] lmtWdt = (JSPUtil.getParameter(request, prefix	+ "lmt_wdt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] lmt20ftWgt = (JSPUtil.getParameter(request, prefix	+ "lmt_20ft_wgt".trim(), length));
			String[] lmtOvrWdt = (JSPUtil.getParameter(request, prefix	+ "lmt_ovr_wdt".trim(), length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] lmtLen = (JSPUtil.getParameter(request, prefix	+ "lmt_len".trim(), length));
			String[] lmt40ftWgt = (JSPUtil.getParameter(request, prefix	+ "lmt_40ft_wgt".trim(), length));
			String[] lmtAxlWgt = (JSPUtil.getParameter(request, prefix	+ "lmt_axl_wgt".trim(), length));
			String[] tempLocCd = (JSPUtil.getParameter(request, prefix	+ "temp_loc_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] lmtOvrLen = (JSPUtil.getParameter(request, prefix	+ "lmt_ovr_len".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPortTrspCondVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lmtHgt[i] != null)
					model.setLmtHgt(lmtHgt[i]);
				if (lmtOvrHgt[i] != null)
					model.setLmtOvrHgt(lmtOvrHgt[i]);
				if (trspRmk[i] != null)
					model.setTrspRmk(trspRmk[i]);
				if (lmtWdt[i] != null)
					model.setLmtWdt(lmtWdt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lmt20ftWgt[i] != null)
					model.setLmt20ftWgt(lmt20ftWgt[i]);
				if (lmtOvrWdt[i] != null)
					model.setLmtOvrWdt(lmtOvrWdt[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (lmtLen[i] != null)
					model.setLmtLen(lmtLen[i]);
				if (lmt40ftWgt[i] != null)
					model.setLmt40ftWgt(lmt40ftWgt[i]);
				if (lmtAxlWgt[i] != null)
					model.setLmtAxlWgt(lmtAxlWgt[i]);
				if (tempLocCd[i] != null)
					model.setTempLocCd(tempLocCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lmtOvrLen[i] != null)
					model.setLmtOvrLen(lmtOvrLen[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPortTrspCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPortTrspCondVO[]
	 */
	public VskPortTrspCondVO[] getVskPortTrspCondVOs(){
		VskPortTrspCondVO[] vos = (VskPortTrspCondVO[])models.toArray(new VskPortTrspCondVO[models.size()]);
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
		this.lmtHgt = this.lmtHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtOvrHgt = this.lmtOvrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRmk = this.trspRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtWdt = this.lmtWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmt20ftWgt = this.lmt20ftWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtOvrWdt = this.lmtOvrWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtLen = this.lmtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmt40ftWgt = this.lmt40ftWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtAxlWgt = this.lmtAxlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempLocCd = this.tempLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtOvrLen = this.lmtOvrLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

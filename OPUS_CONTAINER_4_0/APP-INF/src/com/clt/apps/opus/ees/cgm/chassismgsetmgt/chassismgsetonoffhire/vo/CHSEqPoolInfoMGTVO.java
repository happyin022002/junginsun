/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSEqPoolInfoMGTVO.java
*@FileTitle : CHSEqPoolInfoMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.05
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.07.05 박의수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 박의수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSEqPoolInfoMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSEqPoolInfoMGTVO> models = new ArrayList<CHSEqPoolInfoMGTVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chssRgstUpdDt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String chssRgstUpdOfcCd = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String aciacDivCd = null; 
	/* Column Info */
	private String chssRgstUpdId = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chssPoolCdw = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSEqPoolInfoMGTVO() {}

	public CHSEqPoolInfoMGTVO(String ibflag, String pagerows, String eqNo, String eqKndCd, String location, String eqTpszCd, String crntYdCd, String aciacDivCd, String chssPoolCd, String chssPoolCdw, String chssRgstUpdDt, String chssRgstUpdId, String chssRgstUpdOfcCd, String crntLocCd, String sccCd, String creDt, String creUsrId, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.chssRgstUpdDt = chssRgstUpdDt;
		this.chssPoolCd = chssPoolCd;
		this.chssRgstUpdOfcCd = chssRgstUpdOfcCd;
		this.location = location;
		this.creDt = creDt;
		this.crntYdCd = crntYdCd;
		this.aciacDivCd = aciacDivCd;
		this.chssRgstUpdId = chssRgstUpdId;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sccCd = sccCd;
		this.eqNo = eqNo;
		this.crntLocCd = crntLocCd;
		this.updUsrId = updUsrId;
		this.chssPoolCdw = chssPoolCdw;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chss_rgst_upd_dt", getChssRgstUpdDt());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("chss_rgst_upd_ofc_cd", getChssRgstUpdOfcCd());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("chss_rgst_upd_id", getChssRgstUpdId());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chss_pool_cdw", getChssPoolCdw());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chss_rgst_upd_dt", "chssRgstUpdDt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("chss_rgst_upd_ofc_cd", "chssRgstUpdOfcCd");
		this.hashFields.put("location", "location");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("chss_rgst_upd_id", "chssRgstUpdId");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chss_pool_cdw", "chssPoolCdw");
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
	 * @return chssRgstUpdDt
	 */
	public String getChssRgstUpdDt() {
		return this.chssRgstUpdDt;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdOfcCd
	 */
	public String getChssRgstUpdOfcCd() {
		return this.chssRgstUpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}	
	
	/**
	 * Column Info
	 * @return chssRgstUpdId
	 */
	public String getChssRgstUpdId() {
		return this.chssRgstUpdId;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
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
	 * @return chssPoolCdw
	 */
	public String getChssPoolCdw() {
		return this.chssPoolCdw;
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
	 * @param chssRgstUpdDt
	 */
	public void setChssRgstUpdDt(String chssRgstUpdDt) {
		this.chssRgstUpdDt = chssRgstUpdDt;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdOfcCd
	 */
	public void setChssRgstUpdOfcCd(String chssRgstUpdOfcCd) {
		this.chssRgstUpdOfcCd = chssRgstUpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}	
	
	/**
	 * Column Info
	 * @param chssRgstUpdId
	 */
	public void setChssRgstUpdId(String chssRgstUpdId) {
		this.chssRgstUpdId = chssRgstUpdId;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
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
	 * @param chssPoolCdw
	 */
	public void setChssPoolCdw(String chssPoolCdw) {
		this.chssPoolCdw = chssPoolCdw;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setChssRgstUpdDt(JSPUtil.getParameter(request, "chss_rgst_upd_dt", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setChssRgstUpdOfcCd(JSPUtil.getParameter(request, "chss_rgst_upd_ofc_cd", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setChssRgstUpdId(JSPUtil.getParameter(request, "chss_rgst_upd_id", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChssPoolCdw(JSPUtil.getParameter(request, "chss_pool_cdw", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSEqPoolInfoMGTVO[]
	 */
	public CHSEqPoolInfoMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSEqPoolInfoMGTVO[]
	 */
	public CHSEqPoolInfoMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSEqPoolInfoMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chssRgstUpdDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_dt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] chssRgstUpdOfcCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_ofc_cd", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix + "aciac_div_cd", length));
			String[] chssRgstUpdId = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_id", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chssPoolCdw = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cdw", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSEqPoolInfoMGTVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chssRgstUpdDt[i] != null)
					model.setChssRgstUpdDt(chssRgstUpdDt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (chssRgstUpdOfcCd[i] != null)
					model.setChssRgstUpdOfcCd(chssRgstUpdOfcCd[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (chssRgstUpdId[i] != null)
					model.setChssRgstUpdId(chssRgstUpdId[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chssPoolCdw[i] != null)
					model.setChssPoolCdw(chssPoolCdw[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSEqPoolInfoMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSEqPoolInfoMGTVO[]
	 */
	public CHSEqPoolInfoMGTVO[] getCHSEqPoolInfoMGTVOs(){
		CHSEqPoolInfoMGTVO[] vos = (CHSEqPoolInfoMGTVO[])models.toArray(new CHSEqPoolInfoMGTVO[models.size()]);
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
		this.chssRgstUpdDt = this.chssRgstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdOfcCd = this.chssRgstUpdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdId = this.chssRgstUpdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCdw = this.chssPoolCdw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
